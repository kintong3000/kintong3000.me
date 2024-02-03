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



</script>

<template>

  <div class="prose  ">
    <div class="">
      <h1>blog</h1>
    </div>
<!--<div>{{result}}</div>-->
    <article class="text-base ">
      <div v-html="result"></div>

    </article>

  </div>
</template>

<style scoped>

</style>
