<script setup lang="ts">
import {Search} from "@element-plus/icons-vue";
import {ref, watch} from "vue";
import router from "@/router";
import {useStore} from '@/store/store.ts'
import {isEmpty} from "@/utils/utils.ts";
import avatar from "@/assets/avatar.jpg"

const store = useStore();

const search = ref("");
const searchInput = () => {
  if (isEmpty(search.value)) {
    ElMessage({
      message: '请输入搜索内容！',
      type: 'warning',
      offset: 100
    })
  } else {
    //跳转页面
    if (router.currentRoute.value.path != "/home") {
      router.push("/home");
      store.isBack = "home"
    }
    //提供搜索数据
    store.searchValue = search;
    //清除home页面数据
    store.ImgList = []
    store.page=1
  }
}
//路由监听
watch(
    () => router.currentRoute.value,
    (newValue: any) => {
      if (newValue.path != '/home') {
        store.searchValue = ""
      } else {
        store.searchValue = search;
      }
    },
    {immediate: true}
)

</script>

<template>
  <div class="topbar_box">
    <div class="topbar_title">
      <img src="@/assets/Mypaper.png" alt="#"/>
    </div>

    <div class="topbar_middle">
      <div class="topbar_search">
        <el-input
            class="topbar_visible"
            v-model.trim="search"
            size="large"
            placeholder="探索一下吧！"
            :prefix-icon="Search"
            clearable
            blur
            style="height: 35px;"
            @change="searchInput"
        />
      </div>
    </div>


    <div class="topbar_right">
      <div class="topbar_avatar">
        <el-avatar
            class="topbar_visible"
            :src="avatar"
        />
      </div>
      <div class="topbar_notice topbar_visible">
        <img src="@/assets/notice.png" alt="#"/>
      </div>
    </div>


  </div>
</template>

<style scoped lang="less">

.topbar_box {
  -webkit-app-region: drag;
  width: 100%;
  height: 100%;
  background: #ffffff;
  opacity: 1;
  border: 1px solid #F0F6FD;
  box-shadow: 0 10px 40px #E7EDF3;
  padding: 0 20px;
  //background: aqua;
  display: flex;
  align-items: center;

  .topbar_title {
    img {
      width: 73px;
      height: 18px;
    }
  }

  .topbar_middle {
    width: 100%;
    display: flex;
    justify-content: center;
    align-items: center;

    .topbar_search {
      width: 300px;
    }
  }

  .topbar_right {
    display: flex;
    justify-content: center;
    align-items: center;

    .topbar_notice {
      margin-left: 20px;

      img {
        width: 20px;
        height: 20px;
      }
    }
  }

}

.topbar_visible {
  -webkit-app-region: no-drag;
}
</style>
