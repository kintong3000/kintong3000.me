<script setup lang="ts">
// @ts-expect-error missing types
import MarkdownIt from 'markdown-it'

import Shiki from '@shikijs/markdown-it'
import anchor from 'markdown-it-anchor'

// @ts-expect-error missing types
import MarkdownItGitHubAlerts from 'markdown-it-github-alerts'

import 'markdown-it-github-alerts/styles/github-colors-light.css'
import 'markdown-it-github-alerts/styles/github-colors-dark-class.css'
import 'markdown-it-github-alerts/styles/github-base.css'

import {preWrapperPlugin} from '~/composables/preWrapper'
import config from '~/config/fetchConfig'

const md = new MarkdownIt()

md.use(await Shiki({
  themes: {
    light: 'rose-pine-dawn',
    dark: 'vitesse-dark',
  }

}))


md.use(anchor)
md.use(MarkdownItGitHubAlerts)
md.use(preWrapperPlugin, false)
const route = useRoute()

const runtimeconfig = useRuntimeConfig()

const {data} = await useFetch(`api/blog/introduction`, {
  method:"GET",
  baseURL:runtimeconfig.public.apiUrl,
  key:"1"
})

const result = data.value.data

// const contentHtml = ref()
// watch(data, (newValue) => {
//   if (newValue && newValue.value && newValue.value.data) {
//     // 确保在数据存在时处理数据
//     contentHtml.value = md.render(newValue.value.data.content)
//   }
// }, { immediate: true })

const contentHtml = md.render(result.content)

</script>

<template>
  <div class="bg-color-flow "></div>
  <div class="prose prose-coolgray dark:prose-invert m-auto slide-enter-content">
<!--    <div-->
<!--        v-if="result.title"-->
<!--        class="prose m-auto mb-8"-->
<!--        :class="[result.wrapperClass]"-->
<!--    >-->
<!--      <h1 class="mb-0 slide-enter-50 clip">-->
<!--        {{ result.title }}-->
<!--      </h1>-->
<!--    </div>-->
    <article class="text-xl ">
      <div class="slide-enter-content" v-html="contentHtml"></div>

    </article>

  </div>
  <AppFooter/>

</template>

<style scoped>
.bg-color-flow {
  position: absolute;
  background-image: var(--vp-home-hero-image-background-image);
  border-radius: 50%;
  width: 192px;
  height: 192px;
  filter: var(--vp-home-hero-image-filter);
  top: 150px;
  left: 600px;
  /*rtl:ignore*/
  //left: 50%;
}
.clip{
    background: var(--vp-home-hero-name-background);
    -webkit-background-clip: text;
    background-clip: text;
    -webkit-text-fill-color: var(--vp-home-hero-name-color);
}
</style>
