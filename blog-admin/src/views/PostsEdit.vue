<script setup>

import {ref} from "vue";
import Markdown from "@/components/Markdown.vue";
import {getPost, UpdatePost} from '@/net'
import {useRoute} from "vue-router";
import router from "@/router/index.js";

const title = ref()
const id = ref()
const route = useRoute()
const article = ref()
const urlName = ref()
const articleContent = ref('')


getPost(route.params.id, (data) => {
  article.value = data
  articleContent.value = article.value.content
  title.value = article.value.title
  id.value = article.value.id
  urlName.value=article.value.urlName
})




// 当MarkdownEditor组件中的文章内容更新时，这个函数会被调用
function handleTextUpdate(newText) {
  articleContent.value = newText;
}

// 当用户点击提交按钮时，执行此函数
function submitArticle() {
  UpdatePost({
    "id":id.value,
    "title":title.value,
    "content":articleContent.value,
    "urlName":urlName.value

  },(data)=>{
    ElMessage({
      message: '更改成功',
      type: 'success',
    })
    router.push("/admin/posts")
  })

}

</script>

<template>
  <div class="flex flex-col h-full">
    <div class=" mx-auto mt-4">
      <a-space class="" direction="vertical">
        <a-input v-model:value="urlName" placeholder="urlName"/>
      </a-space>
    </div>
    <div class="w-10/12 mx-auto mt-4">
      <a-space class="w-full" direction="vertical">
        <a-input v-model:value="title" placeholder="输入标题"/>
      </a-space>
    </div>
    <div class="m-3 grow	">
      <markdown :initialText="articleContent" @update:text="handleTextUpdate" class="h-full"/>
    </div>

    <div class="flex flex-row-reverse m-4">
      <a-button type="primary" @click="submitArticle">发布</a-button>
    </div>

  </div>
</template>

<style scoped>

</style>
