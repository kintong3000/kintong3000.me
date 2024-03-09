import {createRouter, createWebHistory} from 'vue-router'
import {unauthorized} from "@/net";
import Posts from "@/views/Posts.vue";
import UserManagement from "@/views/UserManagement.vue";
import PostsEdit from "@/views/PostsEdit.vue";
import Index from "@/views/index.vue";
import newPost from "@/views/newPost.vue";
import UpdateIntroduction from "@/views/UpdateIntroduction.vue";

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '/admin',
            name: 'admin',
            component: () => import('@/views/Home.vue'),
            children: [
                // {
                //   path:'',
                //   name:'index',
                //   component:Index,
                // },
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
                    path: 'postsEdit/:id',
                    name:'postsEdit',
                    component: PostsEdit,
                },
                {
                    path: 'newPost',
                    name:'newPost',
                    component: newPost,
                },
                {
                    path: 'updateIntroduction',
                    name:'updateIntroduction',
                    component: UpdateIntroduction,
                }
            ]
        },
        {
            path: '/login',
            name: 'login',
            component: () => import('@/views/Login.vue'),
        },
        {
            path: '/:catchAll(.*)', // 或者使用 '*'
            redirect: '/admin/posts'
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
