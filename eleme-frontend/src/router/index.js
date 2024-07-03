// src/router/index.js
import { createRouter, createWebHistory } from 'vue-router'

import OrderConfirm from '../views/OrderConfirm.vue'
import Log from '../views/Log.vue'
import ShopSelection from '../views/ShopSelection.vue'
import MenuSelection from "../views/MenuSelection.vue";
import PayComplete from "../views/PayComplete.vue";
import MyOrder from "../views/MyOrder.vue";
import OrderDetail from "../views/OrderDetail.vue";


const routes = [
    {
        path: '/',
        name: 'OrderConfirm',
        component: OrderConfirm
    },
  {
        path: '/log',
        name: 'Log',
        component: Log
    },
    {
        path: '/shop-selection',
        name: 'ShopSelection',
        component: ShopSelection
    },
    {
        path: '/pay-complete',
        name: 'PayComplete',
        component: PayComplete
    },
    {
        path: '/my-order',
        name: 'MyOrder',
        component: MyOrder
    },
    {
        path: '/order-detail',
        name: 'OrderDetail',
        component:OrderDetail
    },
    {
        path: '/menu-selection',
        name: 'MenuSelection',
        component: MenuSelection
    }
]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router
