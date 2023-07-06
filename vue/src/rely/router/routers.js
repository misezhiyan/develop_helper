const routes = [{
    name: '表生成结构',
    path: '/tabletojava/index',
    component: () => import('@/components/tabletojava/index')
}, {
    name:'项目管理',
    path: '/project',
    children: [{
        name: '项目配置',
        path: 'index',
        component: () => import('@/components/project/index')
    },{
        name: '数据库代码生成',
        path: 'dbcreate',
        component: () => import('@/components/project/create/dbcreate')
    },{
        name: '数据库代码生成策略',
        path: 'dbcreatestrategy',
        component: () => import('@/components/project/create/dbcreatestrategy')
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
    name: '模板',
    path: '/template',
    children: [{
        name: '模板配置',
        path: 'index',
        component: () => import('@/components/template/index')
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
    name: '图像识别',
    path: '/picrecognize',
    children: [{
        name: '图像识别记录',
        path: 'index',
        component: () => import('@/components/picrecognize/index')
    }, {
        name: '图像特征匹配',
        path: 'feature',
        component: () => import('@/components/picrecognize/feature')
    }]
}, {
    name: '天天向上',
    path: '/daydayup',
    children: [{
        name: '生源信息',
        path: 'index',
        component: () => import('@/components/daydayup/student/index')
    }]
}, {
    name: '404',
    path: '/',
    redirect: '/daydayup/index',
}]

export default routes