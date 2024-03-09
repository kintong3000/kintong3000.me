<script setup lang="ts">
// @ts-expect-error missing types
import MarkdownIt from 'markdown-it'

import Shiki from '@shikijs/markdown-it'
import anchor from 'markdown-it-anchor'

// @ts-expect-error missing types
import TOC from 'markdown-it-table-of-contents'
import MarkdownItGitHubAlerts from 'markdown-it-github-alerts'

import 'markdown-it-github-alerts/styles/github-colors-light.css'
import 'markdown-it-github-alerts/styles/github-colors-dark-class.css'
import 'markdown-it-github-alerts/styles/github-base.css'

import { preWrapperPlugin } from '~/composables/preWrapper'

import config from "~/config/fetchConfig";


const md = new MarkdownIt()

md.use(await Shiki({
  themes: {
    light: 'rose-pine-dawn',
    dark: 'vitesse-dark',
  }

}))

md.use(TOC,{
  includeLevel: [1, 2, 3, 4],
  containerHeaderHtml: '<div class="table-of-contents-anchor"><div class="i-material-symbols:content-paste-sharp w-1em h-1em"></div>Contents</div>'
})
md.use(anchor)
md.use(MarkdownItGitHubAlerts)
md.use(preWrapperPlugin,false)
const route = useRoute()


const {data,error} = await useFetch(`api/blog/article/${route.params.title}`, {
  method:"GET",
  baseURL:config.api,
})
if (error.value){
  console.log(error.value)
}

// @ts-expect-error missing types
const result = data.value.data
const contentHtml = md.render(result.content)



</script>

<template>

  <div class="prose prose-coolgray dark:prose-invert m-auto slide-enter-content">
    <div
        v-if="result.title"
        class="prose m-auto mb-8"
        :class="[result.wrapperClass]"
    >
      <h1 class="mb-0 slide-enter-50">
        {{ result.title }}
      </h1>
      <p
          v-if="result.createTime"
          class="opacity-50 !-mt-6 slide-enter-50"
      >
        {{ formatDate(result.createTime, false) }}
      </p>

    </div>
    <article class="text-base ">
      <div class="slide-enter-content" v-html="contentHtml"></div>

    </article>

  </div>
  <AppFooter/>

</template>

<style scoped>

</style>
