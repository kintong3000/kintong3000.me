<script setup>
import {ref} from "vue";

const selectedKeys = ref(['1']);
const openKeys = ref(['sub1']);
const items = ref([
  {
    key: '1',
    label: 'Navigation One',
    title: 'Navigation One',
  },
  {
    key: '2',
    label: 'Navigation Two',
    title: 'Navigation Two',
  }])
</script>

<template>
  <a-menu
      v-model:openKeys="openKeys"
      v-model:selectedKeys="selectedKeys"
      style="width: 256px"
      mode="inline"
      :items="items"
      theme="dark"
  />
</template>

<style scoped>

</style>
