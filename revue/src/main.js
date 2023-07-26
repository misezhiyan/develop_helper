import { createApp } from 'vue'
import App from './App.vue'
import router from './router/index'
import '@/styles/index.scss'
import element3 from "element3";
import "element3/lib/theme-chalk/index.css";

// createApp(App).mount('#app')
// createApp(App).use(router).mount('#app')
createApp(App).use(router).use(element3).mount('#app')