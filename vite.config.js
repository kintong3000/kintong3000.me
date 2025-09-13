import {fileURLToPath, URL} from 'node:url'
import UnoCSS from 'unocss/vite'
import {defineConfig} from 'vite'
import Vue from '@vitejs/plugin-vue'
import AutoImport from 'unplugin-auto-import/vite'
import {VueRouterAutoImports} from 'unplugin-vue-router'
import VueRouter from 'unplugin-vue-router/vite'
import Components from 'unplugin-vue-components/vite'
import matter from "gray-matter";
import fs from 'fs-extra'
import Markdown from 'unplugin-vue-markdown/vite'
import Shiki from "@shikijs/markdown-it";
import TOC from "markdown-it-table-of-contents";
import anchor from "markdown-it-anchor";
import GitHubAlerts from 'markdown-it-github-alerts'


export default defineConfig({
    plugins: [
        AutoImport({
            imports: [
                'vue',
                VueRouterAutoImports,
                '@vueuse/core',
            ],
        }),

        UnoCSS(),

        Markdown({
            wrapperComponent: (id, code) => code.includes('introduction')
                ? 'WrapperIntroduction'
                : 'WrapperPost',

            wrapperClasses: (id, code) => code.includes('@layout-full-width')
                ? ''
                : 'prose m-auto slide-enter-content',
            headEnabled: true,
            exportFrontmatter: false,
            exposeFrontmatter: false,
            exposeExcerpt: false,
            markdownItOptions: {
                quotes: '""\'\'',
            },
            async markdownItSetup(md) {
                md.use(await Shiki({
                    themes: {
                        light: 'rose-pine-dawn',
                        dark: 'vitesse-dark',
                    }

                }))

                md.use(TOC, {
                    includeLevel: [1, 2, 3, 4],
                    // containerHeaderHtml: '<div class="table-of-contents-anchor"><div class="i-material-symbols:content-paste w-1em h-1em"></div></div>',
                    containerHeaderHtml: '<div class="table-of-contents-anchor"><div class="i-material-symbols:content-paste-sharp w-1em h-1em"></div>Contents</div>'
                })

                md.use(anchor)
                md.use(GitHubAlerts)
                // md.use(preWrapperPlugin, false)
            }
        }),

        VueRouter({
            extensions: ['.vue', '.md'],
            routesFolder: 'pages',
            logs: true,
            extendRoute(route) {
                const path = route.components.get('default')
                if (!path)
                    return

                if (!path.includes('projects.md') && path.endsWith('.md')) {
                    const {data} = matter(fs.readFileSync(path, 'utf-8'))
                    route.addToMeta({
                        frontmatter: data,
                    })
                }
            },
        }),

        Vue({
            include: [/\.vue$/, /\.md$/],
        }),

        Components({
            extensions: ['vue', 'md'],
            dts: true,
            include: [/\.vue$/, /\.vue\?vue/, /\.md$/],

        }),

    ],
    resolve: {
        alias: {
            '@': fileURLToPath(new URL('./src', import.meta.url))
        }
    }
})
