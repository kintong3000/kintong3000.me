<script setup>
import {ref} from "vue";
import {computed} from "vue";
import {useDark} from "@vueuse/core";
import router from "@/router/index.js";
import {useRoute} from "vue-router";
import { onMounted } from 'vue'


const route = useRoute()
function handelClick(item) {
  //判断点击路径与点击菜单路径是否不同
  //有效避免重复替换相同路径
  if (item.key !== route.path) {
    router.push(item.key)
  }
}
onMounted(() =>{
  router.push('/posts')
})



const isDark = useDark()
const menuTheme = computed(() => {
  return isDark.value ? 'dark' : 'light';
})
</script>

<template>
  <a-menu
      :selectedKeys="[$route.path]"
      style="width: 256px"
      mode="vertical"
      :theme="menuTheme"
      @click="handelClick"
  >
    <a-menu-item key='/posts'>
      <span>文章管理</span>
    </a-menu-item>
    <a-menu-item key='/user'>
      <span>用户管理</span>
    </a-menu-item>


  </a-menu>
</template>

<style scoped>

</style>
