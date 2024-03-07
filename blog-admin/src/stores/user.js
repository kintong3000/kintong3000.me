import { defineStore } from 'pinia'
import { ref } from 'vue'
import {logout} from '@/net'
import router from "@/router";
import axios from "axios";
export const useUserStore = defineStore('user', () => {
    const userInfo = ref({
        username: '',
        role: ''
    })
    const token = ref(null)


    async function initializeUserFromToken() {
        const storedToken = localStorage.getItem('token')
        if (storedToken) {
            token.value = storedToken
            // 假设有一个API用于根据令牌验证用户状态并返回用户信息
            try {
                const response = await axios.get('http://127.0.0.1:8080/cms/UserInfo',{ headers: {
                        'Authorization': `Bearer ${token.value}`
                    } })
                userInfo.value = response.data
            } catch (error) {
                // 如果令牌验证失败，比如令牌过期或无效
                userLogout()
            }
        }
    }


    function userLogout() {
        logout(() => router.push("/login"))
    }

    // 返回响应式状态和方法
    return { userInfo, token, userLogout,initializeUserFromToken }
})
