import './assets/main.css'
import 'ant-design-vue/dist/reset.css';
import { createApp } from 'vue'
import App from './App.vue'
import 'virtual:uno.css'
import '@unocss/reset/tailwind-compat.css'
import 'element-plus/theme-chalk/dark/css-vars.css'
import 'element-plus/es/components/message/style/css'
import router from "@/router/index.js";
import { createPinia } from 'pinia'
import {useUserStore} from "@/stores/user.js";

const pinia = createPinia()

const app = createApp(App)

app.use(pinia)

app.use(router)
app.mount('#app')

const userStore = useUserStore()
userStore.initializeUserFromToken()
