// uno.config.ts
import { defineConfig } from 'unocss'
import presetWind from '@unocss/preset-wind'
import presetIcons from '@unocss/preset-icons'
import {
    presetAttributify,
    presetTypography,
    presetUno,
    transformerDirectives
} from 'unocss'

export default defineConfig({
    presets: [
        presetWind(),
        presetIcons(),
        presetAttributify(), // 使用attribute模式时必须
        presetUno(), // 必须
        presetTypography()
    ],
    transformers: [
        transformerDirectives(),
    ]
})
