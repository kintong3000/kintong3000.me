<script setup>
import {ref} from "vue";
import Header from "@/components/Header.vue";
import SiderBar from "@/components/SiderBar.vue";

</script>

<template>
  <Header/>
  <div class="">
    <SiderBar style="height: calc(100vh - 70px);"/>
    <main><router-view/></main>
  </div>

</template>

<style scoped>


</style>
