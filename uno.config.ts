// uno.config.ts
import { defineConfig } from 'unocss'
import {
    presetAttributify,
    presetTypography,
    presetUno,
    transformerDirectives,
    presetWind,
    presetIcons,
    presetWebFonts
} from 'unocss'

export default defineConfig({
    presets: [
        presetWind(),
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
})
