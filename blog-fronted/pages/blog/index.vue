<script setup lang="ts">
import {fakeArticleList} from "~/composables/fakeData";
import type {Post} from "~/types";

const articleList = fakeArticleList
const getYear = (a: Date | string | number) => new Date(a).getFullYear()
const isSameYear = (a?: Date | string | number, b?: Date | string | number) => a && b && getYear(a) === getYear(b)

function isSameGroup(a: Post, b?: Post) {
  return isSameYear(a.date, b?.date)
}

function getGroupName(p: Post) {

  return getYear(p.date)
}

function getBlogUrl(p: Post) {
  return p.url
}
</script>

<template>
  <div class="m-auto max-w-prose		">

    <div class="text-6xl font-sans	font-bold	text-center	mb-10 slide-enter">Blog</div>
    <ul>
      <div v-for="article in articleList">
        <div
            v-if="!isSameGroup(article, articleList[article.id - 2])"
            select-none relative h20 pointer-events-none slide-enter
            :style="{
          '--enter-stage': article.id - 3,
          '--enter-step': '60ms',
        }"
        >
          <span text-8em color-transparent absolute left--3rem top--2rem font-bold text-stroke-2 text-stroke-hex-aaa
                op10>{{ getGroupName(article) }}</span>
        </div>
        <div class="slide-enter"  :style="{
          '--enter-stage': article.id,
          '--enter-step': '60ms',
        }">
        <router-link to="getBlogUrl(article)" class="item block font-normal mb-6 mt-2 no-underline "

        >
          <li class="no-underline" flex="~ col md:row gap-2 md:items-center">
            <div class="title text-lg leading-1.2em" flex="~ gap-2 wrap">
              <span align-middle>{{ article.title }}</span>
            </div>
            <div flex="~ gap-2 items-center">
              <span text-sm op50 ws-nowrap>
                {{ formatDate(article.createTime, true) }}
              </span>
            </div>
          </li>
        </router-link></div>
      </div>
    </ul>
  </div>
</template>

<style scoped>

</style>
