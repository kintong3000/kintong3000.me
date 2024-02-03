// https://nuxt.com/docs/api/configuration/nuxt-config
export default defineNuxtConfig({
    // app: {
    // head: {
    //   "meta": [
    //     {
    //       "name": "viewport",
    //       "content": "width=device-width, initial-scale=1"
    //     },
    //     {
    //       "charset": "utf-8"
    //     }
    //   ],
    //   "link": [{rel:"stylesheet",href:"https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.9.0/styles/default.min.css"}],
    //   "style": [],
    //   "script": [{src:"https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.9.0/languages/go.min.js"},{src:"https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.9.0/highlight.min.js"}],
    //   "noscript": []
    // }},
    // ssr: false,
    devtools: {enabled: true},
    css: [
        '~/assets/styles/main.css',
        '~/assets/styles/rainbow.css',
        '~/assets/styles/markdown.css',
        '@unocss/reset/tailwind.css'
    ],

    modules: [
        // '@nuxtjs/tailwindcss',
        '@pinia/nuxt',
        '@unocss/nuxt',
        '@vueuse/nuxt',
        '@element-plus/nuxt'
    ],
    // elementPlus: { /** Options */ }
})
