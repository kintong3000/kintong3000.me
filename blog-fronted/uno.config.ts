// uno.config.ts
import { defineConfig } from 'unocss'
import presetWind from '@unocss/preset-wind'
import presetIcons from '@unocss/preset-icons'


export default defineConfig({
    presets: [
        presetWind(),
        presetIcons()
    ],
})
