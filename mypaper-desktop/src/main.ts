import { createApp } from 'vue'
import './style.less'
import App from './App.vue'
import ElementPlus from 'element-plus'
import router from "./router/index.ts";
import store from './store'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'

//壁纸
import V3waterfall from 'v3-waterfall'
import 'v3-waterfall/dist/style.css'



const app = createApp(App)
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
}
app.use(ElementPlus)
app.use(router)
app.use(store)
app.use(V3waterfall)
app.mount('#app')
