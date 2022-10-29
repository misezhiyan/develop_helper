const routes = [{
    name: '表生成结构',
    path: '/tabletojava/index',
    component: () => import('@/components/tabletojava/index')
}, {
    path: '/project',
    meta: {
        title: '项目管理'
    },
    children: [{
        name: '项目配置',
        path: 'index',
        component: () => import('@/components/project/index')
    }]
}, {
    name: '菜单',
    path: '/menu',
    children: [{
        name: '菜单配置',
        path: 'index',
        component: () => import('@/components/menu/index')
    }]
}, {
    name: '数据库',
    path: '/db',
    children: [{
        name: '数据库列表',
        path: 'index',
        component: () => import('@/components/db/index')
    }, {
        name: '数据库配置',
        path: 'dbConfig',
        component: () => import('@/components/db/dbConfig')
    }]
}, {
    name: '404',
    path: '/',
    redirect: '/project/index',
}]

export default routes