import Vue from 'vue'
// import Vuex from 'vuex'
import App from './App.vue'
import router from './router'
import "./plugins/element.js"
import store from "./plugins/vuex.js"
import api from "./func/api/api"
import cookie from "./func/storage/cookie"
import config from "./func/config/config.js"
import util from "./func/util/util.js"
import common from "./func/common/common.js"
import "./assets/css/global.css"
import "./assets/css/dialog.css"

Vue.config.productionTip = false
Vue.prototype.$api = api
Vue.prototype.$cookie = cookie
Vue.prototype.$config = config
Vue.prototype.$util = util
Vue.prototype.$common = common
// Vue.prototype.$proxyhost = null

// Vue.use(Vuex)

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
