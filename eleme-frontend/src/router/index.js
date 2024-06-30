// src/router/index.js
import { createRouter, createWebHistory } from 'vue-router'
import HomePage from '../views/HomePage.vue'
import NewPage from '../views/NewPage.vue'  // 导入新页面组件
import OrderConfirm from '../views/OrderConfirm.vue'

const routes = [
    {
        path: '/HonePage',
        name: 'HomePage',
        component: HomePage
    },
    {
        path: '/',
        name: 'OrderConfirm',
        component: OrderConfirm
    },
    {
        path: '/new-page',
        name: 'NewPage',
        component: NewPage  // 设置路由指向新页面组件
    }
]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router
