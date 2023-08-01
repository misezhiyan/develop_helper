import { createApp } from 'vue'
import './style.css'
import App from './App.vue'
import router from './router'
import {store} from './store'
import * as ElementPlusIcons from '@element-plus/icons'
import * as daydayupApi from '@/axios/daydayupApi'

const app = createApp(App)
// 注册图标
for (const [key, component] of Object.entries(ElementPlusIcons)) {
    app.component(key, component)
}
app.use(router).use(store).mount('#app')

// 挂载接口
app.config.globalProperties.daydayupApi = daydayupApi