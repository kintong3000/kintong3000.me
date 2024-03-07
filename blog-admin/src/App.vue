<script setup>
import {theme} from "ant-design-vue";
import {useDark} from "@vueuse/core";
import {computed} from "vue";

const isDark = useDark()
const currentThemeAlgorithm = computed(() => {
  return isDark.value ? theme.darkAlgorithm : theme.defaultAlgorithm;
});


</script>

<template>
  <a-config-provider
      :theme="{
      algorithm: currentThemeAlgorithm,
    }">
  </a-config-provider>


  <div>
    <router-view></router-view>
  </div>
</template>

<style scoped>

</style>
