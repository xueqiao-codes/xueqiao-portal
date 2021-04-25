import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import './plugins/element.js'
import timeUtil from "./js/util/timeUtil.js"
import util from "./js/util/util.js"
import apiUtil from "./js/util/apiUtil.js"
import api from "./js/api/api"
import cookie from "./js/storage/cookie"
import cache from "./js/storage/cache"
import config from "./js/config/config"

import "./assets/css/global.css"
import "./assets/css/dialog.css"
import "./assets/css/content-table.css"

Vue.config.productionTip = false
Vue.prototype.$timeUtil = timeUtil
Vue.prototype.$util = util
Vue.prototype.$apiUtil = apiUtil
Vue.prototype.$api = api
Vue.prototype.$cookie = cookie
Vue.prototype.$cache = cache
Vue.prototype.$config = config

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
