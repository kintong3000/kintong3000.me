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
import {preWrapperPlugin} from '~/composables/preWrapper'


const md = new MarkdownIt()

md.use(await Shiki({
  themes: {
    light: 'rose-pine-dawn',
    dark: 'vitesse-dark',
  }

}))

md.use(TOC, {
  includeLevel: [1, 2, 3, 4],
  containerHeaderHtml: '<div class="table-of-contents-anchor"><div class="i-material-symbols:content-paste-sharp w-1em h-1em"></div>Contents</div>'
})
md.use(anchor)
md.use(MarkdownItGitHubAlerts)
md.use(preWrapperPlugin, false)
const route = useRoute()

const runtimeconfig = useRuntimeConfig()
const {data, error} = await useFetch(`/api/article/${route.params.title}`, {
  method: "GET",
  // baseURL:runtimeconfig.public.apiUrl,
})
if (error.value) {
  console.log(error.value)
}

// @ts-expect-error missing types
const result = data.value?.data;

const frontmatter = result?.frontmatter;
const contentHtml = result ? md.render(result.content) : '<p>Content not found</p>';


</script>

<template>

  <div class="prose prose-coolgray dark:prose-invert m-auto ">
    <div
        v-if="frontmatter.title"
        class="prose m-auto mb-8"
    >
      <h1 class="mb-0 slide-enter-50">
        {{ frontmatter.title }}
      </h1>
      <p
          v-if="frontmatter.date"
          class="opacity-50 !-mt-6 slide-enter-60"
      >
        {{ formatDate(frontmatter.date, false) }}
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
