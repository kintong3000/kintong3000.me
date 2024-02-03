
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

import { preWrapperPlugin } from '@/assets/preWrapper'
const md = new MarkdownIt()

md.use(await Shiki({
  themes: {
    light: 'solarized-light',
    dark: 'github-dark',
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

const {data} = await useFetch(`https://dev.usemock.com/65bdf10d6309cc7a3772327b/${route.params.articlePublishedTime}/${route.params.title}`, {
  method:"GET",
})
var damn = data.value.data.content
const result = md.render(damn)

</script>

<template>

  <div class="prose px-7 py-10 m-auto of-x-hidden ">
    <div class="">
      <h1>blog</h1>
    </div>
<!--    <div>data:{{data.data.content}}</div>-->
    <article class="text-base ">
      <div v-html="result"></div>

    </article>

  </div>

  <div class="p-16">{{ $route.params.articlePublishedTime }} - {{ $route.params.title }}</div>
</template>

<style scoped>

</style>
