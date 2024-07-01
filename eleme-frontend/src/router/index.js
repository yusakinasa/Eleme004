// src/router/index.js
import { createRouter, createWebHistory } from 'vue-router'

import OrderConfirm from '../views/OrderConfirm.vue'
import LogIn from '../views/LogIn.vue'
import ShopSelection from '../views/ShopSelection.vue'

const routes = [
    {
        path: '/order-confirm',
        name: 'OrderConfirm',
        component: OrderConfirm
    },
  {
        path: '/',  // 设置登录页面的路由路径
        name: 'LogIn',
        component: LogIn  // 设置路由指向 LogIn 组件
    },
    {
        path: '/shop-selection',
        name: 'ShopSelection',
        component: ShopSelection
    }
]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router
