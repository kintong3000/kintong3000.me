<script setup>
import {ref} from "vue";
import Header from "@/components/Header.vue";
import SiderBar from "@/components/SiderBar.vue";
import {useUserStore} from "@/stores/user.js";


</script>

<template>
  <Header/>
  <div class="flex ">
    <SiderBar style="height: calc(100vh - 70px);"/>
    <main class="flex-auto"><router-view></router-view></main>
  </div>

</template>

<style scoped>


</style>
