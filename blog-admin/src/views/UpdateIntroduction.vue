<script setup>

import {ref} from "vue";
import Markdown from "@/components/Markdown.vue";
import {getIntroduction,UpdateIntroduction} from '@/net'
import router from "@/router/index.js";

const title = ref()
const id = ref()
const urlName = ref()
const articleContent = ref('')


getIntroduction((data) => {
  articleContent.value = data.content
  title.value = data.title
  id.value = data.id
})




// 当MarkdownEditor组件中的文章内容更新时，这个函数会被调用
function handleTextUpdate(newText) {
  articleContent.value = newText;
}

// 当用户点击提交按钮时，执行此函数
function submitArticle() {
  UpdateIntroduction({
    "id":id.value,
    "title":title.value,
    "content":articleContent.value,
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

    <div class="w-10/12 mx-auto mt-4">
      <a-space class="w-full" direction="vertical">
        <a-input v-model:value="title" placeholder="输入标题"/>
      </a-space>
    </div>
    <div class="m-3 grow	">
      <markdown :initialText="articleContent" @update:text="handleTextUpdate" class="h-full"/>
    </div>

    <div class="flex flex-row-reverse m-4">
      <a-button type="primary" @click="submitArticle">确认更改</a-button>
    </div>

  </div>
</template>

<style scoped>

</style>
