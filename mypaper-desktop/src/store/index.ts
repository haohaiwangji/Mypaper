//配置pinia数据化持久化插件
import {createPinia} from 'pinia'
import piniaPersist from 'pinia-plugin-persist'

const store = createPinia()
store.use(piniaPersist)

export default store
