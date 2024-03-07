<script setup>
import ToggleDarkSwitch from "@/components/toggleDarkSwitch.vue";
import {useUserStore} from "@/stores/user.js";

const userStore = useUserStore()

</script>

<template>
  <header class="w-full  pt-1 z-100 header-bg" style="border-bottom: #989898 1px solid ">
    <nav class="h-16 flex flex-row-reverse  ">
      <div class="my-auto mx-3">
        <ToggleDarkSwitch/>
      </div>
      <div class="my-auto mr-6">
        <el-popover
            :width="30"
            popper-style="box-shadow: rgb(14 18 22 / 35%) 0px 10px 38px -10px, rgb(14 18 22 / 20%) 0px 10px 20px -15px; padding: 20px;"
        >
          <template #reference>
            <el-avatar> {{ userStore.userInfo.username }}</el-avatar>
          </template>
          <template #default>
            <div class="flex flex-col">
              <div class="text font-semibold">用户：{{ userStore.userInfo.username }}</div>
              <div class="text font-semibold">角色：{{ userStore.userInfo.role }}</div>
              <el-button class="mt-4" type="danger" @click="userStore.userLogout()" round>退出登录</el-button>
            </div>
          </template>
        </el-popover>
      </div>
    </nav>
  </header>
</template>

<style scoped>

</style>
