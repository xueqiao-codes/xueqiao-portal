import Vue from "vue"
import Vuex from "vuex"

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    navigationStack: [{ name: "通知运行管理 发送通知", router: { path: '/sending' } }],
  },
  mutations: {
    resetNavigationStack(state) {
      state.navigationStack = []
    },
    pushNavigationStack(state, item) {
      state.navigationStack.push(item)
    }
  },
  actions: {}
})
