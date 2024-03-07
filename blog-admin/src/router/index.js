import {createRouter, createWebHistory} from 'vue-router'
import {unauthorized} from "@/net";
import Posts from "@/views/Posts.vue";
import UserManagement from "@/views/UserManagement.vue";
import PostsEdit from "@/views/PostsEdit.vue";

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '/',
            name: 'index',
            component: () => import('@/views/Index.vue'),
            children: [
                {
                    path: 'posts',
                    name:'posts',
                    component: Posts,
                },
                {
                    path: 'user',
                    name:'user',
                    component: UserManagement,
                },
                {
                    path: 'postsEdit',
                    name:'postsEdit',
                    component: PostsEdit,
                },
            ]
        },
        {
            path: '/login',
            name: 'login',
            component: () => import('@/views/Login.vue'),
        }
    ]
})

router.beforeEach((to, from, next) => {
    const isUnauthorized = unauthorized()
    if ( !to.name.startsWith('login') && isUnauthorized) {
        next('/login')
    } else {
        next()
    }
})

export default router
