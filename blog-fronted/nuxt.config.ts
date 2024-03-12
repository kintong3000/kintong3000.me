// https://nuxt.com/docs/api/configuration/nuxt-config
import NodeGlobalsPolyfillPlugin from "@esbuild-plugins/node-globals-polyfill";
import {nodePolyfills} from 'vite-plugin-node-polyfills'

export default defineNuxtConfig({
    runtimeConfig: {
        // Private config that is only available on the server
        // apiSecret: {API_URL:process.env.API_URL},
        // Config within public will be also exposed to the client
        // public: {
        //     API_URL:process.env.API_URL
        // }
        public: {
            apiUrl: process.env.API_URL || 'http://localhost:8080'
        }

    },
    vite: {
        // optimizeDeps: {
        //     esbuildOptions: {
        //         // Node.js global to browser globalThis
        //         // define: {
        //         //     global: 'globalThis'
        //         // },
        //         // Enable esbuild polyfill plugins
        //         plugins: [
        //             // NodeGlobalsPolyfillPlugin({ //fix something
        //             //     buffer: true
        //             // })
        //             nodePolyfills({
        //                 globals: {
        //                     Buffer: true, // can also be 'build', 'dev', or false
        //                     global: true,
        //                     process: true,
        //                 }
        //             }),
        //
        //
        //         ]
        //     }
        // }

        plugins: [nodePolyfills({

            globals: {
                Buffer: true, // can also be 'build', 'dev', or false
                global: true,
                process: true,
            },

        })],


    },
    nitro: {
        routeRules: {
            '/api/**': {
                proxy: process.env.API_URL || 'http://localhost:8080'
            }
        }
    },

    // ssr: false,
    routeRules: {
        '/': {isr: 60},
        '/blog/**': {isr: 60},
        '/blog': {isr: 60},


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
        '@element-plus/nuxt',
    ],


    // elementPlus: { /** Options */ }
})
// function defineNuxtConfig(arg0: unknown) {
//     throw new Error("Function not implemented.");
// }

