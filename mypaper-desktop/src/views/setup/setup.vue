<script setup lang="ts">
import {useStore} from '@/store/store.ts'
import {onMounted, ref} from "vue";

const store = useStore();
//初始化数据
store.ImgList = []
store.page = 1

//api设置
const ApiSetUp = ref<string|null>()

//初始化本地数据
onMounted(()=>{
  const paperData = localStorage.getItem("paperData");
  if (paperData) {
    ApiSetUp.value = paperData;
  }
})
//设置配置
const setConfig=()=>{
  // 保存接口来源
  const paperData = ApiSetUp.value;
  if (typeof paperData === "string") {
    localStorage.setItem("paperData", paperData);
  } else {
    localStorage.setItem("paperData", 'wall');
  }
  //设置成功弹出提示
  ElMessage({
    message: '保存成功！',
    type: 'success',
    offset: 100
  })
}

</script>

<template>
  <div class="setup_box">
    <el-card class="setup-card">
      <h2>设置</h2>
      <el-divider/>
      <div class="setup_config">

        <el-tabs tab-position="left" class="setup_tabs">
          <!--壁纸来源-->
          <el-tab-pane label="壁纸来源">
            <div class="setup_config_item">
              <div class="setup_config_label">壁纸来源：</div>
              <el-select v-model="ApiSetUp" placeholder="请选择壁纸来源" style="width: 250px">
                <el-option v-for="item in store.ApiSetUpList" :key="item" :label="item.label" :value="item.value"/>
              </el-select>
            </div>
          </el-tab-pane>
          <!--版本信息-->
          <el-tab-pane label="版本信息">
            <el-card class="setup-card">
              <template #header>
                <div class="card-header">
                  <span style="font-weight: bold">版本信息</span>
                </div>
              </template>
              <el-form>
                <el-form-item >gitee开源地址: 后续将开源</el-form-item>
                <el-form-item >服务器版本: v0.2.24</el-form-item>
                <el-form-item >客户端版本: v0.2.44</el-form-item>
              </el-form>
            </el-card>
          </el-tab-pane>
        </el-tabs>


      </div>
      <div class="setup_foot">
        <el-button type="primary" style="width: 100px;height: 40px;" @click="setConfig">保存</el-button>
      </div>
    </el-card>
  </div>
</template>

<style scoped lang="less">
.setup_box {
  height: 643px;
  margin: 8px;

  .setup-card {
    width: 100%;
    height: 100%;
    display: flex;
    flex-direction: column;
    position: relative;

    .setup_config {
      margin-top: 20px;

      .setup_tabs {
        height: 510px;

        .setup_config_item {
          display: flex;
          align-items: center;
          margin-left: 20px;

          .setup_config_label {
            width: 80px;
            color: @title-color;
            //font-weight: bold;
            font-size: @font-size-default;
          }
        }
      }
    }

    .setup_foot {
      position: absolute;
      bottom: 10px;
      right: 20px;
    }
  }
}
h2{
  color: @title-color;
  font-size: 24px;
  margin-bottom: 10px;
}
// 内容居中
.el-select-dropdown__item {
  text-align: center;
}
/deep/ .el-tabs__item{
  font-size: @font-size-default;
}
</style>
