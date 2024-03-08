<script setup>
// 1.1 引入Vditor 构造函数
import Vditor from 'vditor'
// 1.2 引入样式
import 'vditor/dist/index.css';
import { ref, onMounted,computed } from 'vue';

// 2. 获取DOM引用
const vditor = ref()

// 3. 在组件初始化时，就创建Vditor对象，并引用
onMounted(() => {
  vditor.value = new Vditor('vditor',{
    height: '100%',
    width: '100%',
    theme:'dark',
    "outline": {
      "enable": true
    },
    toolbar: ["emoji",
      "headings",
      "bold",
      "italic",
      "strike",
      "link",
      "|",
      "list",
      "ordered-list",
      "check",
      "outdent",
      "indent",
      "|",
      "quote",
      "line",
      "code",
      "inline-code",
      "insert-before",
      "insert-after",
      "|",
      "table",
      "|",
      "edit-mode",
    ],
    preview: {
      theme: {
        current: "dark"
      },
      actions: ["desktop", "tablet", "mobile"]
    }


  })
  const markdownContent = vditor.value;
console.log(markdownContent.getValue())
})

</script>

<template>

  <div id="vditor" name="description" ></div>


</template>
<style scoped>

</style>


