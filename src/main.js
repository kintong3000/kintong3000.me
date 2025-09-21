import './styles/main.css'

// import { createApp } from 'vue'
import 'virtual:uno.css'

// import '@unocss/reset/tailwind.css'
// import 'markdown-it-github-alerts/styles/github-colors-light.css'
// import 'markdown-it-github-alerts/styles/github-colors-dark-class.css'
// import 'markdown-it-github-alerts/styles/github-base.css'
// import '@shikijs/twoslash/style-rich.css'
// import 'shiki-magic-move/style.css'
import './styles/main.css'
import './styles/prose.css'
import './styles/markdown.css'
import './styles/rainbow.css'
import 'uno.css'
import './styles/globals.css'
import { routes } from "vue-router/auto-routes"
import { ViteSSG } from 'vite-ssg'
import dayjs from 'dayjs'
import LocalizedFormat from 'dayjs/plugin/localizedFormat.js'

import App from './App.vue'
// import '@unocss/reset/tailwind.css'
// import '@unocss/reset/tailwind-compat.css'
// createApp(App).mount('#app')


export const createApp = ViteSSG(
    App,
    {
        routes,
    },
    ({ router, app, isClient }) => {
        dayjs.extend(LocalizedFormat)


    },
)
