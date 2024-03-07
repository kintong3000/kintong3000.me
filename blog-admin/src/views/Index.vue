<script setup>
import {ref} from "vue";
import Header from "@/components/Header.vue";
import SiderBar from "@/components/SiderBar.vue";

</script>

<template>
    <Header/>

  <div class="">
<SiderBar/>
  </div>
<!--  <div class="flex" >-->
<!--    <div class="w-60 h-screen	dark:bg-zinc-700							" >-->
<!--      <el-menu style="border-right: 0px"-->
<!--      >-->
<!--        <el-menu-item index="1" >-->
<!--          <span>文章列表</span>-->
<!--        </el-menu-item>-->

<!--        <el-menu-item index="2">-->
<!--          <span>用户管理</span>-->
<!--        </el-menu-item>-->
<!--      </el-menu>-->
<!--    </div>-->
<!--  </div>-->
</template>

<style scoped>



.el-menu{
  --el-menu-bg-color:transparent;
}
</style>
