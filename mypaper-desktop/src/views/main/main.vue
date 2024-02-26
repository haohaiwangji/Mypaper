<script setup lang="ts">
import Navbar from "@/components/navbar/navbar.vue";
import Topbar from "@/components/topbar/topbar.vue";
</script>

<template>
  <el-container class="nav_box">
    <el-aside width="66px">
      <Navbar/>
    </el-aside>
    <el-container>

      <el-header>
        <Topbar/>
      </el-header>
      <el-main class="main_content">
        <div class="fade-transform-box main_content_background">
          <router-view v-slot="{ Component }">
              <transition name="fade-transform" mode="out-in">
                <component :is="Component" key="cached-component" />
              </transition>
          </router-view>

        </div>
      </el-main>
    </el-container>
  </el-container>
</template>


<style scoped lang="less">
.nav_box {
  width: 100vw;
  height: 100vh;
}

//解决el-header的padding问题（两边留白）
.el-header {
  padding: 0;
  margin: 0;
}

.fade-transform-box {
  position: relative;
  top: 0;
  bottom: 0;
  width: 100%;
  overflow: hidden;
}

.main_content {
  padding: 0 !important;
  background: #F5F5F5;
}

.fade-transform-enter-active,
.fade-transform-leave-active {
  transition: all 0.3s ease 0s;
}

.fade-transform-enter {
  opacity: 0;
  transform: translateX(-30px);
}

.fade-transform-leave-to {
  opacity: 0;
  transform: translateX(30px);
}

</style>
