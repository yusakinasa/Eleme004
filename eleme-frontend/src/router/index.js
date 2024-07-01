// src/router/index.js
import { createRouter, createWebHistory } from 'vue-router'
import OrderConfirm from '../views/OrderConfirm.vue'
import LogIn from '../views/LogIn.vue'

const routes = [
    {
        path: '/',
        name: 'OrderConfirm',
        component: OrderConfirm
    },
    {
        path: '/login',  // 设置登录页面的路由路径
        name: 'LogIn',
        component: LogIn  // 设置路由指向 LogIn 组件
    }
]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router
