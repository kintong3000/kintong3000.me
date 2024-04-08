<script setup lang="ts">
import {breakpointsTailwind} from '@vueuse/core'
import demoItems from '@/projects/data'

const breakpoints = useBreakpoints(breakpointsTailwind)
const cols = ref(3)

// Use onMounted lifecycle hook to update cols based on actual viewport size after hydration
onMounted(() => {
  if (breakpoints.xl.value) {
    cols.value = 3
  } else if (breakpoints.lg.value) {
    cols.value = 2
  } else {
    cols.value = 1
  }
})

// const cols = computed(() => {
//   if (breakpoints.xl.value)
//     return 3
//   if (breakpoints.lg.value)
//     return 2
//   return 1
// })


const parts = computed(() => {
  const result = Array.from({length: cols.value}, () => [] as typeof demoItems)
  demoItems.forEach((item, i) => {
    result[i % cols.value].push(item)
  })
  return result
})
</script>

<template>
    <div class="prose prose-coolgray dark:prose-invert m-auto slide-enter m-b-8">
      <h1 class="text-center">Projects</h1>
    </div>

  <div grid="~ cols-1 lg:cols-2 xl:cols-3 gap-4">
    <div v-for="(items, idx) in parts" :key="idx" flex="~ col gap-4">
      <div v-for="{ text, url, img } of items">
        <a
            border="~ base rounded-lg" block of-hidden
            class="group"
            hover="scale-101 shadow-xl z-10" transition-all duration-500 bg-base relative
            :href="url"
            target="_blank"
        >
          <img :src="img" alt="Girl in a jacket" w-full autoplay loop muted playsinline border="b base">

          <div class="prose prose-base p4 m0 pb3">
            <div class="slide-enter-content" v-html="text"></div>
          </div>
        </a>
      </div>
    </div>
  </div>
</template>

<style scoped>
[border~="base"] {
  --un-border-opacity: 0.27;
  border-color: rgb(136 136 136 / var(--un-border-opacity));
}
</style>
