<script setup lang="ts">
import type {Post} from "~/types";
import {formatDate} from "../../composables/formatDate";

const props = defineProps<{
  type?: string
  posts?: Post[]
  extra?: Post[]
}>()

const router = useRouter()
const routes: Post[] = router.getRoutes()
    .filter(i => i.path.startsWith('/blogs') && i.meta.frontmatter.date && !i.meta.frontmatter.draft)
    .filter(i => !i.path.endsWith('.html') && (i.meta.frontmatter.type || 'blog').split('+').includes(props.type))
    .map(i => ({
      path: i.meta.frontmatter.redirect || i.path,
      title: i.meta.frontmatter.title,
      date: i.meta.frontmatter.date,
      lang: i.meta.frontmatter.lang,
      duration: i.meta.frontmatter.duration,
      recording: i.meta.frontmatter.recording,
      upcoming: i.meta.frontmatter.upcoming,
      redirect: i.meta.frontmatter.redirect,
      place: i.meta.frontmatter.place,
    }))

const posts = computed(() =>
    [...(props.posts || routes), ...props.extra || []]
        .sort((a, b) => +new Date(b.date) - +new Date(a.date))
)


const getYear = (a: Date | string | number) => new Date(a).getFullYear()
const isSameYear = (a?: Date | string | number, b?: Date | string | number) => a && b && getYear(a) === getYear(b)

function isSameGroup(a: Post, b?: Post) {
  return isSameYear(a.date, b?.date)
}

function getGroupName(p: Post) {

  return getYear(p.date)
}

</script>

<template>
  <div class="m-auto max-w-prose		">

    <div class="text-6xl font-sans	font-bold	text-center	mb-10 slide-enter list-title	">Blog</div>
    <ul>
      <div v-for="(article, index) in posts" :key="index">
        <div
            v-if="!isSameGroup(article, posts[index - 1])"
            select-none relative h20 pointer-events-none slide-enter
            :style="{
          '--enter-stage': index + 3,
          '--enter-step': '60ms',
        }"
        >
          <span text-8em color-transparent absolute left--3rem top--2rem font-bold text-stroke-2 text-stroke-hex-aaa
                op10>{{ getGroupName(article) }}</span>
        </div>
        <div class="slide-enter" :style="{
          '--enter-stage': index+1,
          '--enter-step': '60ms',
        }">
          <RouterLink :to="article.path" class="item block font-normal mb-6 mt-2 no-underline "

          >
            <li class="no-underline" flex="~ col md:row gap-2 md:items-center">
              <div class="title  text-lg leading-1.2em" flex="~ gap-2 wrap">
                <span align-middle >{{ article.title }}</span>
              </div>
              <div flex="~ gap-2 items-center">
              <span text-sm op50 ws-nowrap>
                {{ formatDate(article.date, true) }}
              </span>
              </div>
            </li>

          </RouterLink>
        </div>
      </div>
    </ul>
  </div>
</template>

<style scoped>

</style>
