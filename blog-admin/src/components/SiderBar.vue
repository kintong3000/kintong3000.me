<script setup>
import {ref} from "vue";
import {computed} from "vue";
import {useDark} from "@vueuse/core";
const selectedKeys = ref(['1']);
const items = ref([
  {
    key: '1',
    label: '文章管理',
    title: '文章管理',
  },
  {
    key: '2',
    label: '用户管理',
    title: '用户管理',
  }])
const isDark = useDark()
const menuTheme = computed(() => {
  return isDark.value ? 'dark' : 'light';
})
</script>

<template>
  <a-menu
      v-model:selectedKeys="selectedKeys"
      style="width: 256px"
      mode="vertical"
      :items="items"
      :theme="menuTheme"
  />
</template>

<style scoped>

</style>
