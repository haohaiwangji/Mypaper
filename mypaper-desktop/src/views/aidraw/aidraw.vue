<script setup lang="ts">
import {useStore} from '@/store/store.ts'
import {ref} from "vue";
import {downloadImage, generateRandomString, isEmpty} from "@/utils/utils.ts";
import api from "@/api/api.ts";

import loadingImg from "@/assets/loading.gif";

const store = useStore();
//初始化数据
store.ImgList = []
store.page = 1

const aiText = ref<string>()
//模型选项值
const modelValue = ref<string>('')
//ai图片
const aiImg = ref<string>('')
//下载图片loading
const loading = ref<boolean>(false)
//初始化空白图片
const initImgFlag = ref<boolean>(true)
//生成图片按钮loading
const loadingBtn = ref<boolean>(false)


//生成图片
const createImg = () => {
  //判断描述是否为空
  if (isEmpty(aiText.value)) {
    ElMessage({
      message: '描述不能为空！',
      type: 'warning',
      offset: 100
    })
    return
  }
  //判断模型是否为空
  if (isEmpty(modelValue.value)) {
    ElMessage({
      message: '请选择模型！',
      type: 'warning',
      offset: 100
    })
    return
  }

  //第一次进入初始化面板
  initImgFlag.value=false
  aiImg.value=''
  loadingBtn.value=true
  //发起请求
  fetch(api.getAiImg(aiText.value, modelValue.value)).then(res=>{
    console.log(res.url)
    aiImg.value=res.url
    loadingBtn.value=false
  })
}

//下载图片
const downloadImg = () => {
//获取图片url
  if (isEmpty(aiImg.value)) {
    ElMessage({
      message: '请先生成图片！',
      type: 'warning',
      offset: 100
    })
    return
  }

  loading.value = true
  // 下载图片
  downloadImage({
    url: aiImg.value,
    filename: generateRandomString(10)
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
  <div class="aidraw_box">
    <el-card class="aidraw-card">
      <div class="aidraw_top">
        <el-empty v-if="aiImg==''&&initImgFlag" :image-size="200"  description="AI绘画，描述一下吧！"/>
        <el-empty v-show="aiImg==''&&!initImgFlag"  :image="loadingImg" description="努力绘画中..."/>
        <el-image  v-show="aiImg!=''" style="width: auto;height: 510px; border-radius: 6px;" fit="contain"
                  :src="aiImg" >
          <template #error>
            <div class="image-slot">
              <el-result
                  icon="warning"
                  title="等会在试试吧"
                  sub-title="连续请求次数过多，请稍后重试！"
              >
              </el-result>
            </div>
          </template>
        </el-image>
      </div>
      <div class="aidraw_bottom">
        <div class="aidraw_text">
          <el-input
              v-model.trim="aiText"
              :rows="4"
              type="textarea"
              maxlength="100"
              show-word-limit
              resize="none"
              placeholder="请描述一下图片内容"
          />
        </div>
        <div class="aidraw_operation">
          <div class="aidraw_operation_top">
            <el-select v-model="modelValue" placeholder="选择模型" size="large">
              <el-option v-for="item in store.modelList" :key="item" :label="item.label" :value="item.value"/>
            </el-select>
          </div>
          <div class="aidraw_operation_btn">
            <el-button type="primary" style="width: 100px;height: 40px;" @click="createImg" :disabled="loadingBtn">生成</el-button>
            <el-button type="success" style="width: 100px;height: 40px;" @click="downloadImg" :loading="loading">下载
            </el-button>
          </div>
        </div>
      </div>
    </el-card>


  </div>
</template>

<style scoped lang="less">
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

.aidraw_box {
  height: 643px;
  margin: 8px;

  .aidraw-card {
    width: 100%;
    height: 100%;
    display: flex;
    flex-direction: column;

    .aidraw_top {
      height: 520px;
      display: flex;
      justify-content: center;
    }

    .aidraw_bottom {
      width: 100%;
      display: flex;

      .aidraw_text {
        width: 80%;
      }

      .aidraw_operation {
        display: flex;
        flex-direction: column;
        margin-right: 5px;
        margin-left: 20px;
        margin-top: 2px;

        .aidraw_operation_btn {
          display: flex;
          margin-top: 10px;
        }
      }
    }
  }


}

// 内容居中
.el-select-dropdown__item {
  text-align: center;
}
</style>
