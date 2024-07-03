// src/router/index.js
import { createRouter, createWebHistory } from 'vue-router'

import OrderConfirm from '../views/OrderConfirm.vue'
import LogIn from '../views/LogIn.vue'
import ShopSelection from '../views/ShopSelection.vue'
import MenuSelection from '../views/MenuSelection.vue'
import OrderDetails from '../views/OrderDetail.vue';


const routes = [
    {
        path: '/order-confirm',
        name: 'OrderConfirm',
        component: OrderConfirm
    },
    {
        path: '/',
        name: 'LogIn',
        component: LogIn
    },
    {
        path: '/shop-selection',
        name: 'ShopSelection',
        component: ShopSelection
    },
    {
        path: '/menu-selection',
        name: 'MenuSelection',
        component: MenuSelection
    },
    {
        path: '/order-details',
        name: 'OrderDetails',
        component: OrderDetails
    }
]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router