import Vue from "vue"
import Vuex from "vuex"

Vue.use(Vuex)

// const store = () =>
export default new Vuex.Store({
  state: {
    quotationAccount: {
      deploySet: null,
      platfromEnv: null
    },
    subscribedContract: {
      platfromEnv: null
    },
    subscribedQuotation: {
      deploySet: null,
      platfromEnv: null
    }
  },
  mutations: {
    // this.$store.commit('setQuotationAccountDeploySet', value)
    // $store.state.quotationAccount.deploySet
    setQuotationAccountDeploySet(state, deploySet) {
      state.quotationAccount.deploySet = deploySet
    },
    setQuotationAccountPlatformEnv(state, platformEnv) {
      state.quotationAccount.platfromEnv = platformEnv
    },
    setSubscribedContractPlatformEnv(state, platformEnv) {
      state.subscribedContract.platfromEnv = platformEnv
    },
    setSubscribedQuotationDeploySet(state, deploySet) {
      state.subscribedQuotation.deploySet = deploySet
    },
    setSubscribedQuotationPlatformEnv(state, platformEnv) {
      state.subscribedQuotation.platfromEnv = platformEnv
    }
  }
})

// export default store
