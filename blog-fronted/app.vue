<template>
  <div class="font-sans text-gray-700 dark:text-gray-200 ">
    <NuxtLayout >
      <main class="px-7 py-10 m-auto of-x-hidden">
        <NuxtPage />
      </main>
    </NuxtLayout>
  </div>
</template>

<script setup lang="ts">

useHead({

  script: [{
    innerHTML: '(function () {\n' +
        '        const prefersDark =\n' +
        '          window.matchMedia &&\n' +
        '          window.matchMedia(\'(prefers-color-scheme: dark)\').matches\n' +
        '        const setting = localStorage.getItem(\'vueuse-color-scheme\') || \'auto\'\n' +
        '        if (setting === \'dark\' || (prefersDark && setting !== \'light\'))\n' +
        '          document.documentElement.classList.toggle(\'dark\', true)\n' +
        '      })()'
  }],

  title: 'kintong',
  meta: [
    { name: 'description', content: 'kintong-blog' }
  ],
  link: [
    { rel: 'icon', type: 'image/x-icon', href: '/favicon.ico' },
  ]

})
</script>


<style>


</style>
