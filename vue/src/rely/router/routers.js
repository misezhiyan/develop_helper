const routes = [{
    name: '数据库',
    path: '/db',
    children: [{
        name: '数据库列表',
        path: 'dbIndex',
        component: () => import('@/components/db/index')
    }, {
        name: '数据库配置',
        path: 'dbConfig',
        component: () => import('@/components/db/dbConfig')
    }]
}, {
    name: '菜单',
    path: '/menu',
    children: [{
        name: '菜单配置',
        path: 'menuIndex',
        component: () => import('@/components/menu/index')
    }]
}, {
    name: '表生成结构',
    path: '/tabletojava',
    children: [{
        name: '菜单配置',
        path: 'tabletojavaIndex',
        component: () => import('@/components/tabletojava/index')
    }]
}, {
    name: '404',
    path: '/',
    component: () => import('@/components/db/index')
}]

export default routes