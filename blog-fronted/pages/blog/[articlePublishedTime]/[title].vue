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
import  {fakemd} from '~/composables/fakeData'
import matter from 'gray-matter';
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


const {data,error} = await useFetch(`${route.params.articlePublishedTime}/${route.params.title}`, {
  method:"GET",
  baseURL:config.api,
})
if (error.value){
  console.log(error.value)
}

// const result = matter(fakemd)
const result = matter(data.value.data.content)
const frontmatter = result.data
const content = result.content
const contentHtml = md.render(content)

</script>

<template>

  <div class="prose prose-coolgray dark:prose-invert m-auto slide-enter-content">
    <div
        v-if=" frontmatter.title"
        class="prose m-auto mb-8"
        :class="[frontmatter.wrapperClass]"
    >
      <h1 class="mb-0 slide-enter-50">
        {{ frontmatter.title }}
      </h1>
      <p
          v-if="frontmatter.date"
          class="opacity-50 !-mt-6 slide-enter-50"
      >
        {{ formatDate(frontmatter.date, false) }}
<!--        <span v-if="frontmatter.duration">· {{ frontmatter.duration }}</span>-->
      </p>
<!--      <p v-if="frontmatter.place" class="mt&#45;&#45;4!">-->
<!--        <span op50>at </span>-->
<!--        <a v-if="frontmatter.placeLink" :href="frontmatter.placeLink" target="_blank">-->
<!--          {{ frontmatter.place }}-->
<!--        </a>-->
<!--        <span v-else font-bold>-->
<!--        {{ frontmatter.place }}-->
<!--      </span>-->
<!--      </p>-->
<!--      <p-->
<!--          v-if="frontmatter.subtitle"-->
<!--          class="opacity-50 !-mt-6 italic slide-enter"-->
<!--      >-->
<!--        {{ frontmatter.subtitle }}-->
<!--      </p>-->

    </div>
    <article class="text-base ">
      <div class="slide-enter-content" v-html="contentHtml"></div>

    </article>

  </div>
  <AppFooter/>

</template>

<style scoped>

</style>
