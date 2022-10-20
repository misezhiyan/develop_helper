import {createRouter, createWebHistory} from 'vue-router'

import routes from './routers'

const routers = createRouter({
    history: createWebHistory(),
    routes: routes,
    base:'/index'
})

export default routers