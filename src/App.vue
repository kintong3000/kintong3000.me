<script setup>
import AppHeader from "./components/AppHeader.vue";


</script>

<template>
  <div class="font-sans text-gray-700 dark:text-gray-200 ">
    <AppHeader/>

    <div>
      <main class="px-7 py-10 m-auto of-x-hidden">
        <RouterView/>
      </main>
    </div>
  </div>
</template>

<style>

html {
  scroll-behavior: smooth;
}

</style>
