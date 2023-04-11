import {createApp} from 'vue'
import App from './App.vue'
import 'element-plus/dist/index.css'
import ElementPlus from 'element-plus'
import * as elIcons from '@element-plus/icons-vue'
// import axiosReq from "./rely/axios/axiosConfig";
import * as develophelperApi from './rely/axios/develophelper.js'
import router from './rely/router/index.js'

const app = createApp(App);
app.use(ElementPlus);
app.use(router);
app.mount('#app')
// app.config.globalProperties.$axios = axiosReq;
app.config.globalProperties.develophelperApi = develophelperApi
// const app = createApp(App).mount('#app').use(ElementPlus)
// .use(store).use(Router)

for (const [key, component] of Object.entries(elIcons)) {
    // console.log(key)
    // console.log(component)
    app.component(key, component)
}