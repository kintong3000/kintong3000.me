<script setup>
import { ref,computed,watch } from 'vue';
import { MdEditor } from 'md-editor-v3';
import 'md-editor-v3/lib/style.css';
import {useDark} from "@vueuse/core";
const text = ref('');

const isDark = useDark()
const theme = computed(()=> isDark.value ? 'dark':'light')
const props = defineProps({
  initialText: String
});
const internalText = ref(props.initialText);
const emit = defineEmits(['update:text']);

watch(internalText, (newValue) => {
  emit('update:text', newValue);
});
watch(() => props.initialText, (newVal) => {
  if (internalText.value !== newVal) { // 避免不必要的更新
    internalText.value = newVal;
  }
});

const toolbars = ref([
  'bold',
  'underline',
  'italic',
  '-',
  'strikeThrough',
  'title',
  'sub',
  'sup',
  'quote',
  'unorderedList',
  'orderedList',
  'task', // ^2.4.0
  '-',
  'codeRow',
  'code',
  'link',
  'image',
  'table',
  'mermaid',
  'katex',

]);
</script>
<template>
  <MdEditor v-model="internalText" :theme="theme" :toolbars="toolbars" style="height: 100%"  />
</template>

<style scoped>

.md-editor-dark {
  --md-bk-color: #333 !important;
}
</style>
