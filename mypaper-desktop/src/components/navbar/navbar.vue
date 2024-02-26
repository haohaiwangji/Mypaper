<script setup lang="ts">
const {ipcRenderer} = require('electron')
import router from "@/router";
import {useStore} from '@/store/store.ts'
import {ref} from "vue";

const store =useStore();

//控制导航栏菜单的显示和隐藏
const NavShow = ref(false);
//窗口缩小
const windowMin = () => {
  ipcRenderer.send('window-min');
}
//窗口关闭
const windowClose = () => {
  ipcRenderer.send('window-close');
}
//跳转页面
const windowTo = (url: string) => {
  switch (url) {
    case "首页":
      store.isBack = "home";
      router.push("/home");
      break;
    case "分类":
      store.isBack = "classify";
      router.push("/classify");
      break;
    case "Ai绘画":
      store.isBack = "aidraw";
      router.push("/aidraw");
      break;
    case "收藏":
      store.isBack = "collection";
      router.push("/collection");
      break;
    case "设置":
      store.isBack = "setup";
      router.push("/setup");
      break;
  }
}
</script>

<template>
  <div class="navbar_box">
    <div class="navbar_group" @mouseenter="NavShow=true" @mouseleave="NavShow=false">
      <div class="navbar_down" @click="windowClose">
        <span v-show="NavShow">
          <img src="@/assets/close.png" alt="关闭" style="width: 12px; height: 12px;"/>
        </span>
      </div>
      <div class="navbar_shrink" @click="windowMin">
        <span v-show="NavShow">
            <img src="@/assets/down.png" alt="缩小"  style="width: 12px; height: 12px;"/>
        </span>
      </div>
    </div>
    <div class="navbar_menu_list">
      <div class="navbar_menu">
        <div @click="windowTo('首页')" :class=" store.isBack=='home' ? 'change_back' : ''">
          <img src="@/assets/home.png" alt="首页"/>
        </div>
        <div @click="windowTo('分类')" :class=" store.isBack=='classify' ? 'change_back' : ''">
          <img src="@/assets/classify.png" alt="分类"/>
        </div>
        <div @click="windowTo('Ai绘画')" :class=" store.isBack=='aidraw' ? 'change_back' : ''">
          <img src="@/assets/ai.png" alt="Ai绘画"/>
        </div>
        <div @click="windowTo('收藏')" :class=" store.isBack=='collection' ? 'change_back' : ''">
          <img src="@/assets/collection.png" alt="收藏"/>
        </div>
      </div>

      <div class="navbar_setup" @click="windowTo('设置')" :class=" store.isBack=='setup' ? 'change_back' : ''">
        <img src="@/assets/setup.png" alt="设置"/>
      </div>
    </div>
  </div>
</template>

<style scoped lang="less">
.navbar_box {
  width: 100%;
  height: 100%;
  background: #ffffff;
  opacity: 1;
  border: 1px solid #EBF1FB;
  display: flex;
  flex-direction: column;

  .navbar_group {
    width: 100%;
    height: 40px;
    display: flex;
    justify-content: space-around;
    align-items: center;
    //background: bisque;
    div {
      width: 16px;
      height: 16px;
      opacity: 1;
      border-radius: 50% 50%;
      background: #FF453A;
      box-shadow: inset 0 0 5px 2px rgba(0, 0, 0, 0.05);
      font-weight: bold;
      display: flex;
      justify-content: center;
      align-items: center;
      cursor: pointer;
    }

    div:nth-child(1) {
      //background: #FF453A;
      background: #FA625C;
    }

    div:nth-child(2) {
      //background: #30D158;
      background: #FBB43A;
    }
  }

  .navbar_menu_list {
    width: 100%;
    flex: 1;
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-top: 50px;

    .navbar_menu {
      width: 100%;
      height: 100%;
      display: flex;
      flex-direction: column;
      align-items: center;

      div {
        //background: #FF453A;
        margin-top: 50px;
        height: 50px;
        width: 90%;
        display: flex;
        justify-content: center;
        align-items: center;

        img {
          width: 25px;
          height: 25px;
        }
      }

      div:hover {
        margin-left: 10px;
        margin-right: 10px;
        border-radius: 10px;
        background: linear-gradient(145deg, #e6e6e6, #ffffff);
        box-shadow: 20px 20px 60px #d9d9d9,
          -20px -20px 60px #ffffff;
      }

    }

    .navbar_setup {
      height: 50px;
      width: 90%;
      display: flex;
      justify-content: center;
      align-items: center;
      margin-bottom: 10px;
      //background: #FF453A;
      img {
        width: 20px;
        height: 20px;
      }
    }

    .navbar_setup:hover {
      margin-left: 10px;
      margin-right: 10px;
      border-radius: 10px;
      background: linear-gradient(145deg, #e6e6e6, #ffffff);
      box-shadow: 20px 20px 60px #d9d9d9,
        -20px -20px 60px #ffffff;
    }
  }
  .change_back{
    margin-left: 10px;
    margin-right: 10px;
    border-radius: 10px;
    background: linear-gradient(145deg, #e6e6e6, #ffffff);
    box-shadow: 20px 20px 60px #d9d9d9,
      -20px -20px 60px #ffffff;
  }
}
</style>
