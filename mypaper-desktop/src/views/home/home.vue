<script setup lang="ts">
import {ref, watch} from 'vue'
import api from "@/api/api.ts";
import DetailDialog from "@/components/detailDialog/detailDialog.vue";
import {useStore} from '@/store/store.ts'
import {isEmpty} from "@/utils/utils.ts";


const store = useStore();

//加载中
const isLoading = ref<boolean>(false)
//弹出详情页
const showDetail = ref<boolean>(false)
//弹出详情页
const Detail = ref<DetailType>()
//el加载
const fullscreenLoading = ref(false)
//内容图片
const DetailImg = ref<string>("")
//控制数据是否已经全部加载完成
const isover=ref<boolean>(false)
//瀑布流组件渲染组件
const renderView = ref();

//获取下一页数据
const getImgNext = () => {
  const paperDataType: string | null = localStorage.getItem('paperData')
  isLoading.value = true

  if (isEmpty(store.searchValue)) {
    api.getRandomImg({
      "id": store.page
    }, paperDataType).then(res => {
      console.log(res.data)
      //判断数据是否结束
      if (res.data.length==0){
        isover.value=true
      }
      store.ImgList = store.ImgList.concat(res.data)
      isLoading.value = false
      store.page++
    })

  } else {
    api.getImgData({
      "id": store.page,
      "text": store.searchValue
    }, paperDataType=='wall360'?"bird":paperDataType, "getSearchImg").then(res => {
      //判断数据是否结束
      if (res.data.length==0){
        isover.value=true
      }
      store.ImgList = store.ImgList.concat(res.data)
      isLoading.value = false
      store.page++
    })
  }
  //重新渲染
  renderView.value.reRender()
}
//监听ImgList数据变化
watch(
    () => store.ImgList,
    () => {
      if (store.ImgList.length == 0) {
        getImgNext()
      }
    }
)
//打开弹窗
const toDetail = (imgHref: string, cover: string, item: DetailType) => {
  const paperDataType: string | null = localStorage.getItem('paperData')
  // if (paperDataType !== null) {
  DetailImg.value = cover
  fullscreenLoading.value = true
  //请求数据
  if (paperDataType == 'wall') {
    api.getImgInfo({
      "imghref": imgHref
    }, paperDataType).then(res => {
      console.log(res.data)
      Detail.value = res.data
      fullscreenLoading.value = false
      showDetail.value = true
    })
  } else {
    Detail.value = item
    fullscreenLoading.value = false
    showDetail.value = true
  }
}
//关闭弹窗
const handleDialogClose = () => {
  showDetail.value = false
};
</script>
<template>
  <div class="home_box">
    <el-scrollbar>
      <v3-waterfall class="waterfall" :list="store.ImgList" srcKey="imgCover" :gap="12" :colWidth="315"
                    :distanceToScroll="150" @scrollReachBottom="getImgNext" :isLoading="isLoading" :virtualTime="500" :isOver="isover"
                  ref="renderView" :virtualLength="300">
        <template v-slot:default="slotProp">
          <div v-loading.fullscreen.lock="fullscreenLoading" element-loading-text="加载中..."
               element-loading-background="rgba(0, 0, 0, 0.7)"
               class="list-item" @click="toDetail(slotProp.item.imgHref,slotProp.item.imgCover,slotProp.item)">
            <div class="cover-wrapper">
              <img :src="slotProp.item.imgCover" class="cover" alt="#"/>
            </div>
          </div>
        </template>
      </v3-waterfall>
      <el-backtop :right="35" :bottom="25" style="background:#fff; opacity:0.8;"
                  target=".home_box .el-scrollbar__wrap"
                  :visibility-height="50">
      </el-backtop>
    </el-scrollbar>
    <detail-dialog :showDialog="showDetail" :Detail="Detail" :DetailImg="DetailImg" @close-dialog="handleDialogClose"/>
  </div>
</template>


<style scoped lang="less">
.home_box {
  width: 100%;
  height: 640px;
  margin-top: 20px;
  overflow-x: hidden;
}

.list-item {
  box-sizing: border-box;

  .cover-wrapper {
    overflow: hidden;
    background-color: #fff;
    cursor: pointer;
  }

  &:hover {
    box-shadow: 5px 5px 5px #ccc;

    .cover {
      animation: scaleImg 0.1s linear forwards;
    }

    @keyframes scaleImg {
      0% {
        transform: scale(1);
      }
      100% {
        transform: scale(1.5);
      }
    }
  }
}

.cover {
  width: 100%;
  vertical-align: middle;
  border-radius: 8px;
}
</style>
