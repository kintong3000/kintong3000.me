// https://nuxt.com/docs/api/configuration/nuxt-config
import NodeGlobalsPolyfillPlugin from "@esbuild-plugins/node-globals-polyfill";
export default defineNuxtConfig({
    vite:{
        optimizeDeps: {
            esbuildOptions: {
                // Node.js global to browser globalThis
                define: {
                    global: 'globalThis'
                },
                // Enable esbuild polyfill plugins
                plugins: [
                    NodeGlobalsPolyfillPlugin({ //fix something
                        buffer: true
                    })
                ]
            }
        }
    },


    // ssr: false,
    routeRules: {
        '/': { isr: 3600 },
        '/blog/**': { isr: 3600 },
        '/blog': { isr: 3600 },



    },


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
