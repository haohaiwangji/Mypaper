import {createRouter, createWebHashHistory, RouteRecordRaw} from "vue-router";

//路由
const Main = () => import('@/views/main/main.vue')
// const Login = () => import('@/views/login/login.vue')
const Home = () => import('@/views/home/home.vue')
const Classify = () => import('@/views/classify/classify.vue')
const Aidraw = () => import('@/views/aidraw/aidraw.vue')
const Collection = () => import('@/views/collection/collection.vue')
const Setup = () => import('@/views/setup/setup.vue')


const routers: Array<RouteRecordRaw> = [
    {
        path: '/',
        name: 'Main',
        component: Main,
        redirect: '/home',
        children: [
            {
                path: '/home',
                name: 'Home',
                component: Home,
                meta: {
                    title: '首页',
                }
            },
            {
                path: '/classify',
                name: 'Classify',
                component: Classify,
                meta: {
                    title: '分类',
                }
            },
            {
                path: '/aidraw',
                name: 'Aidraw',
                component: Aidraw,
                meta: {
                    title: 'AI绘画',
                }
            },
            {
                path: '/collection',
                name: 'Collection',
                component: Collection,
                meta: {
                    title: '收藏',
                }
            },
            {
                path: '/setup',
                name: 'Setup',
                component: Setup,
                meta: {
                    title: '设置',
                }
            },
        ]
    }
]

const router = createRouter({
    history: createWebHashHistory(),
    routes: routers,

})
export default router

