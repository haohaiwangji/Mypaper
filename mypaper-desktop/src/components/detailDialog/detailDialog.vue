<script setup lang="ts">
import {Star} from "@element-plus/icons-vue";
import {ref, watch} from 'vue';
import {downloadImage} from "@/utils/utils.ts"

const loading = ref<boolean>(false)
//父组件传值
const props = defineProps<{ showDialog: boolean, Detail?: DetailType, DetailImg: string }>();
//子组件传父
const emit = defineEmits(['close-dialog']);
// 创建一个ref并监听props.Detail的变化
const detail = ref(props.Detail);
// 创建一个ref并监听props.showDialog的变化
const localShowDialog = ref(props.showDialog);

watch([() => props.showDialog, () => props.Detail], ([newValue1, newValue2]) => {
  localShowDialog.value = newValue1;
  detail.value = newValue2;
}, {immediate: true});
//关闭方法
const handleClose = (done: () => void) => {
  emit('close-dialog');
  done(); // 触发el-dialog的关闭动画完成回调
}

//下载图片
const handleDownload = (imgUrl: string) => {
  loading.value = true
  //获取名字
  const parts: string[] = imgUrl.split('/');
  const filename: string = parts[parts.length - 1];
  downloadImage({
    url: imgUrl,
    filename: filename
  });
  setTimeout(() => {
    loading.value = false
    ElMessage({
      message: '下载成功！',
      type: 'success',
      offset: 100,
      duration: 1000,
    })
  }, 3000);

}

</script>
<template>
  <el-dialog v-model="localShowDialog" :close-on-click-modal="false"
             :before-close="handleClose" width="80%" top="14vh">
    <template #header>
      <div slot="header" class='detail_title'>{{ Detail?.realTitle }}</div>
    </template>
    <div class="detail_box">
      <div class="detail_left">
        <el-image class="detail_img"
                  :src="props.DetailImg"
                  referrerpolicy='no-referrer'
                  fit="cover"
        >
          <template #placeholder>
            <div class="image-slot"><img src="@/assets/loading.gif" alt="#" style="object-fit: cover;"/></div>
          </template>
        </el-image>
      </div>
      <el-divider direction="vertical" class="detail_divider" border-style="dashed"/>
      <div class="detail_right">
        <div class="detail_btn">
          <el-button class="collect_pictures" :icon="Star" size="large"/>
          <el-button class="download_image" type="primary" size="large" :loading="loading"
                     @click="handleDownload(<string>Detail?.realImg)">下载
          </el-button>
        </div>

        <div class="detail_content">
          <h3 class="detail_content_title">图片信息</h3>
          <div class="detail_content_list">
            <div class="detail_content_list_item" v-if="Detail?.resolution!=null">
              <div>分辨率</div>
              <div>{{ Detail.resolution }}</div>
            </div>

            <div class="detail_content_list_item" v-if="Detail?.realSize!=null">
              <div>大小</div>
              <div>{{ Detail.realSize }}</div>
            </div>

            <div class="detail_content_list_item" v-if="Detail?.category!=null">
              <div>类别</div>
              <div>
                <el-tag style="width: 60px">{{ Detail?.category }}</el-tag>
              </div>
            </div>
          </div>
        </div>

      </div>
    </div>
  </el-dialog>
</template>

<style scoped lang="less">
.detail_title {
  color: @title-color;
  font-size: @font-size-max;
  font-weight: bold;
}

.image-slot {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100%;

  img {
    width: 100px;
    height: 100px;
  }
}

.detail_box {
  height: 450px;
  display: flex;

  .detail_left {
    width: 70%;
    background: #f6f9fc;
    margin-right: 10px;
    margin-bottom: 10px;
    margin-top: -20px;

    .detail_img {
      width: 100%;
      height: 100%;
      border-radius: 5px;
    }
  }

  .detail_divider {
    height: 100%;
    margin-top: -19px;
    margin-bottom: 10px;
  }

  .detail_right {
    width: 30%;
    flex: 1;
    margin-top: -19px;
    margin-bottom: 10px;
    display: flex;
    flex-direction: column;
    margin-left: 10px;

    .detail_btn {
      .collect_pictures {
        width: 55px;
      }

      .download_image {
        width: 120px;
      }
    }

    .detail_content {
      width: 100%;
      height: 100%;
      margin-top: 20px;

      .detail_content_title {
        color: @title-color;
        font-size: @font-size-default;
        font-weight: 700;
        line-height: 26px;
        padding-bottom: 15px;
        padding-left: 12px;
        position: relative;

      }

      .detail_content_title::before {
        background: #409EFF;
        border-radius: 2px;
        content: "";
        display: block;
        height: @font-size-default;
        left: 0;
        position: absolute;
        top: 5px;
        width: 4px;
      }

      .detail_content_list {
        width: 100%;

        .detail_content_list_item {
          display: flex;
          margin-bottom: 10px;

          div:nth-child(1) {
            width: 100px;
            color: @description-color;
          }

          div:nth-child(2) {
            color: @title-color;
          }
        }

      }

    }
  }
}
</style>
