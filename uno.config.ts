// uno.config.ts
import { defineConfig } from 'unocss'
import {
    presetAttributify,
    presetTypography,
    presetUno,
    transformerDirectives,
    presetIcons,
    presetWebFonts
} from 'unocss'
import presetAnimations from "unocss-preset-animations";
import { presetShadcn } from "unocss-preset-shadcn";
// import { presetShadcn } from "./preset.shadcn"
import presetWind4 from '@unocss/preset-wind4'

export default defineConfig({
    theme: {
        spacing: {
            1: '0.25rem',
            2: '0.5rem',
            3: '0.75rem',
            4: '1rem',
            // ...
        },
    },
    presets: [
        presetWind4(),
        presetAnimations(),
        presetShadcn(
            {
                color: "red",
                // With default setting for SolidUI, you need to set the darkSelector option.
                darkSelector: '[data-kb-theme="dark"]',
            },
            {
                // If you are using reka ui.
                componentLibrary: "reka",
            },

        ),
        // presetShadcn(),
        presetIcons({
            extraProperties: {
                'display': 'inline-block',
                'height': '1.2em',
                'width': '1.2em',
                'vertical-align': 'text-bottom',
            },
        }),
        presetAttributify(), // 使用attribute模式时必须
        presetUno(), // 必须
        presetTypography(),
        presetWebFonts({
            fonts: {
                sans: 'Inter:400,600,800',
                mono: 'DM Mono:400,600',
                condensed: 'Roboto Condensed',
                wisper: 'Bad Script',
            },
        }),
    ],
    transformers: [
        transformerDirectives(),
    ],
    safelist: [
        'i-material-symbols:content-paste-sharp',
    ],
    content: {
        pipeline: {
            include: [
                // the default
                /\.(vue|svelte|[jt]sx|mdx?|astro|elm|php|phtml|html)($|\?)/,
                // include js/ts files
                "(components|src)/**/*.{js,ts}",
            ],
        },
    },
})
