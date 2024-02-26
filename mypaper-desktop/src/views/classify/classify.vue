<script setup lang="ts">
import {ref} from 'vue'
import {useStore} from '@/store/store.ts'
import api from "@/api/api.ts";
import DetailDialog from "@/components/detailDialog/detailDialog.vue";

const store = useStore()
const type = ref<string>('')
const typeValue = ref<string>('')
const top = ref<string>('')
//参数几页
const page = ref<number>(1)
const paperType = ref<string | null>('')
const paperData = ref<paperListType[]>([])
//图片列表
const ImgList = ref<ImgListType[]>([])
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
//切换类别与排行榜
const handType = ref<string>('')
//排行榜类别
const topType = ref<string>('')
//控制数据是否已经全部加载完成
const isover=ref<boolean>(false)
//瀑布流组件渲染组件
const renderView = ref();


//获取缓存中数据
const getPaperType = () => {
  paperType.value = localStorage.getItem('paperData')
  store.ImgList=[]
  store.page=1
  switch (paperType.value) {
    case 'wall':
      type.value = '最新'
      paperData.value = store.WakHavenContentList
      typeValue.value = paperData.value[0].value
      handType.value = 'getPaperTypeList'
      break
    case 'bird':
      type.value = '4k'
      paperData.value = store.BirdContentList
      typeValue.value = paperData.value[0].value
      handType.value = 'getPaperTypeList'
      break
    case 'wall360':
      type.value = '最新'
      paperData.value = store.Wall360ContentList
      typeValue.value = paperData.value[0].value
      handType.value = 'getPaperTypeList'
      break
  }
}
//初始化数据
getPaperType()
//获取图片数据列表
const getImgDataList = () => {
  if (handType.value == 'getPaperTypeList') {
    api.getImgData({
      "id": page.value
    }, paperType.value, typeValue.value).then(res => {
      console.log(res.data)
      //判断数据是否结束
      if (res.data.length==0){
        isover.value=true
      }
      ImgList.value = ImgList.value.concat(res.data)
      isLoading.value = false
      page.value++
      fullscreenLoading.value = false
    })
  } else if (handType.value == 'TopType') {
    api.getTopListImg({
      "topRange": topType.value,
      "id": page.value
    }).then(res => {
      console.log(res.data)
      //判断数据是否结束
      if (res.data.length==0){
        isover.value=true
      }
      ImgList.value = ImgList.value.concat(res.data)
      isLoading.value = false
      page.value++
      fullscreenLoading.value = false
    })
  }
}

//切换类别数据
const getPaperTypeList = (item: paperListType) => {
  fullscreenLoading.value = true
  type.value = item.label
  typeValue.value = item.value
  ImgList.value = []
  page.value = 1
  handType.value = 'getPaperTypeList'
  getImgDataList()
  //重新渲染
  renderView.value.reRender()

}

//排行数据
const TopType = (topFlag: string) => {
  fullscreenLoading.value = true
  page.value = 1
  ImgList.value = []
  topType.value = topFlag
  handType.value = 'TopType'
  getImgDataList()
}

//打开弹窗
const toDetail = (imgHref: string, cover: string, item:DetailType) => {
  const paperDataType: string | null = localStorage.getItem('paperData')
  DetailImg.value = cover
  fullscreenLoading.value = true
  console.log(paperDataType)
  if (paperDataType == 'wall'){
    //请求数据
    api.getImgInfo({
      "imghref": imgHref
    }, paperDataType).then(res => {
      console.log(res.data)
      Detail.value = res.data
      fullscreenLoading.value = false
      showDetail.value = true
    })
  }else {
    Detail.value =item
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
  <div class="classify_box">
    <el-affix :offset="61">
      <div class="classify_head">
        <span>类别</span>
        <div class="classify_types">
          <el-radio-group v-model="type" size="small" v-for="item in paperData" :key="item.label">
            <el-radio-button :label="item.label" style="padding: 4px" @change="getPaperTypeList(item)"
                             v-loading.fullscreen.lock="fullscreenLoading" element-loading-text="加载中..."
                             element-loading-background="rgba(0, 0, 0, 0.7)"/>
          </el-radio-group>
          <el-select v-model="top" placeholder="排行" size="small" style="width: 100px" v-if="paperType==='wall'"
                     @change="TopType">
            <el-option v-for="item in store.WakHavenTopList" :key="item" :label="item.label" :value="item.value"/>
          </el-select>
        </div>
      </div>
    </el-affix>

    <div class="classify_body">
      <el-scrollbar>
        <v3-waterfall class="waterfall" :list="ImgList" srcKey="imgCover" :gap="12" :colWidth="315"
                      :distanceToScroll="150" @scrollReachBottom="getImgDataList" :isLoading="isLoading"
                      :virtualTime="500" :isOver="isover" :virtualLength="300" ref="renderView">
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
      </el-scrollbar>
      <detail-dialog :showDialog="showDetail" :Detail="Detail" :DetailImg="DetailImg"
                     @close-dialog="handleDialogClose"/>
    </div>

  </div>

</template>

<style scoped lang="less">
.classify_box {
  width: 100%;
  height: 660px;
  display: flex;
  flex-direction: column;

  .classify_head {
    //width: 98.5%;
    display: flex;
    align-items: center;
    background: #ffffff;
    padding-top: 5px;
    padding-bottom: 5px;
    margin-top: -1px;

    span {
      width: 40px;
      color: @description-color;
      font-size: @font-size-min;
      margin-left: 15px;
    }

    .classify_types {
      display: flex;
      flex-wrap: wrap;
      align-items: center;
      align-content: flex-start; //排列格式
    }
  }

  .classify_body {
    width: 100%;
    margin-top: 55px;
    overflow: hidden;

    .list-item {
      box-sizing: border-box;

      .cover-wrapper {
        overflow: hidden;
        //background-color: #fff;
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

      .cover {
        width: 100%;
        vertical-align: middle;
        border-radius: 8px;
      }
    }

  }

}

// 内容居中
.el-select-dropdown__item {
  text-align: center;
}
</style>
