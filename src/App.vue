<script setup>
import AppHeader from "./components/AppHeader.vue";

import {useRoute} from 'vue-router'
import {computed} from 'vue'
import {useDark} from "@vueuse/core";


const route = useRoute()
const isHomePage = computed(() => route.name === '/')
// const isDark = useDark();
const isDark = useDark({
  selector: 'html',
  attribute: 'data-kb-theme',
  valueDark: 'dark',
  valueLight: 'light',
})
const raysColor = computed(() => (isDark.value ? '#ffffff' : '#ffffff'));
</script>

<template>
  <div class="font-sans text-gray-700 dark:text-gray-200 relative ">
    <LightRays
        v-if="isHomePage && isDark"
        rays-origin="top-center"
        :rays-color="raysColor"
        :rays-speed="1"
        :light-spread="0.5"
        :ray-length="2"
        :follow-mouse="true"
        :mouse-influence="0.8"
        :noise-amount="0.3"
        :distortion="0.05"
        class-name="custom-rays"
    />
    <AppHeader/>
    <div>
      <main class=" py-0 px-0 m-auto of-x-hidden   min-h-screen">
        <RouterView/>
      </main>
    </div>
  </div>
</template>

<style>

html {
  scroll-behavior: smooth;
}

</style>
