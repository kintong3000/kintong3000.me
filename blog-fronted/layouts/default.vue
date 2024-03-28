<template>
  <div>
    <AppHeader />
    <slot />
    <SpeedInsights/>
  </div>
</template>


<script setup lang="ts">
import { SpeedInsights } from "@vercel/speed-insights/nuxt"
</script>
