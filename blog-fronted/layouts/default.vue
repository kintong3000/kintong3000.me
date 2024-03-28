<template>
  <div>
    <AppHeader />
    <slot />
  </div>
  <SpeedInsights/>

</template>


<script setup lang="ts">
import { SpeedInsights } from "@vercel/speed-insights/nuxt"
</script>
