import { defineStore } from 'pinia'
import { ref } from 'vue'
import {logout,get,getUserInfo} from '@/net'
import router from "@/router";
import {ElMessage} from "element-plus";
export const useUserStore = defineStore('user', () => {
    const userInfo = ref({
        username: '',
        role: ''
    })
    const token = ref(null)


    async function initializeUserFromToken() {
        const storedToken = localStorage.getItem('authorize') || sessionStorage.getItem('authorize');
        if (storedToken) {
            token.value = storedToken
            getUserInfo((response)=>{
                userInfo.value.username = response.username
                userInfo.value.role = response.role
            },(message, status, url) => {
                console.warn(`请求地址: ${url}, 状态码: ${status}, 错误信息: ${message}`)
                ElMessage.warning(message)
                userLogout()
            })
        }
        else {
            ElMessage.warning("未登录")
            console.log("未登录")
        }
    }


    function userLogout() {
        logout(() => router.push("/login"))
    }

    // 返回响应式状态和方法
    return { userInfo, token, userLogout,initializeUserFromToken }
})
