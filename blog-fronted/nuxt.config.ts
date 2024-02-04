// https://nuxt.com/docs/api/configuration/nuxt-config
export default defineNuxtConfig({

    // ssr: false,
    devtools: {enabled: true},
    css: [
        '~/assets/styles/main.css',
        '~/assets/styles/rainbow.css',
        '~/assets/styles/markdown.css',
        '~/assets/styles/prose.css',
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
