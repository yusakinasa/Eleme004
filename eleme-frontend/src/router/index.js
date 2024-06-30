// src/router/index.js
import { createRouter, createWebHistory } from 'vue-router'
import HomePage from '../views/HomePage.vue'
import NewPage from '../views/NewPage.vue'  // 导入新页面组件
import OrderConfirm from '../views/OrderConfirm.vue'
import LogIn from '../views/LogIn.vue'

const routes = [
    {
        path: '/home-page',
        name: 'HomePage',
        component: HomePage
    },
    {
        path: '/order-confirm',
        name: 'OrderConfirm',
        component: OrderConfirm
    },
    {
        path: '/new-page',
        name: 'NewPage',
        component: NewPage  // 设置路由指向新页面组件
    },
    {
        path: '/',  // 设置登录页面的路由路径
        name: 'LogIn',
        component: LogIn  // 设置路由指向 LogIn 组件
    }
]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router
