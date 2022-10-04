import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

createApp(App).use(router).use(store).mount('#app')
// App.config.globalProperties.$axios = axios
// App.config.globalProperties.$store = store
