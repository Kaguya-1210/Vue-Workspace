import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
//1.引入element-plus组件库
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
//3.引入element-plus图标库
import * as ElementPlusIconsVue from '@element-plus/icons-vue'
//5.1修改elementPlus默认中文
import zhCn from 'element-plus/dist/locale/zh-cn.mjs'

// 8.1配置根路径

const BASE_URL = 'http://localhost:8080';
// win里配置的都是全局内容，可以在任意script中使用
window.BASE_URL = BASE_URL;
app.config.globalProperties.BASER_URL = BASE_URL;


const app = createApp(App)
//4.遍历ElementPlusIconsVue对象中的所有图标组件并注册到app中
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
}

//2.app.use(ElementPlus) 使用Element-plus组件库
//5.2 app.use(ElementPlus,{ locale: zhCn })将El本地化为中文
app.use(ElementPlus,{ locale: zhCn }).use(store).use(router).mount('#app')

//6.解决ResizeObserver Error
const debounce = (fn, delay) => {
    let timer = null;
    return function () {
        let context = this;
        let args = arguments;
        clearTimeout(timer);
        timer = setTimeout(function () {
            fn.apply(context, args);
        }, delay);
    }
}
const _ResizeObserver = window.ResizeObserver;
window.ResizeObserver = class ResizeObserver extends _ResizeObserver {
    constructor(callback) {
        callback = debounce(callback, 16);
        super(callback);
    }
}

//7.定义获取登录用户信息的全局方法
window.getUser = ()=>{
    //如果获取到了用户数据,转为JS对象
    //如果没有获取到用户数据''转为布尔是false,值为null
    return localStorage.user ? JSON.parse(localStorage.user) : null
}

