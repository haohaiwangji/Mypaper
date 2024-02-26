<script setup lang="ts">
import {useStore} from '@/store/store.ts'

const store = useStore();

store.ImgList = []
store.page=1
</script>

<template>
  <div class="collection_box">
    <el-card class="collection-card">
      <el-empty :image-size="200"  description="收藏 正在开发中..."/>
    </el-card>
  </div>
</template>

<style scoped>
.collection_box{
  height: 643px;
  margin: 8px;

  .collection-card {
    width: 100%;
    height: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
  }
}
</style>
