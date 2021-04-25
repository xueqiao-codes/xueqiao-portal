import Vue from "vue"
import Router from "vue-router"
import Home from "./views/Home.vue"
import Test from "./views/Test.vue"
import CommodityActiveConfig from "./views/CommodityActiveConfig.vue"
import SubscribedContract from "./views/SubscribedContract.vue"
import QuotationAccount from "./views/QuotationAccount.vue"
import SubscribedQuotation from "./views/SubscribedQuotation.vue"
import AccountRegisterAbility from "./views/AccountRegisterAbility.vue"
import SubscribedPreview from "./views/SubscribedPreview.vue"
import PlanedSubscribedPreview from "./views/PlanedSubscribedPreview.vue"

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: "/",
      redirect: "/commodityActiveConfig",
      name: "home",
      component: Home
    },
    {
      path: "/commodityActiveConfig",
      name: "commodityActiveConfig",
      component: CommodityActiveConfig
    },
    {
      path: "/subscribedContract",
      name: "subscribedContract",
      component: SubscribedContract
    },
    {
      path: "/quotationAccount",
      name: "quotationAccount",
      component: QuotationAccount
    },
    {
      path: "/subscribedQuotation",
      name: "subscribedQuotation",
      component: SubscribedQuotation
    },
    {
      path: "/accountRegisterAbility", // /:accountId
      name: "accountRegisterAbility",
      component: AccountRegisterAbility
    },
    {
      path: "/subscribedPreview/:from",
      name: "subscribedPreview",
      component: SubscribedPreview
    },
    {
      path: "/planedSubscribedPreview",
      name: "planedSubscribedPreview",
      component: PlanedSubscribedPreview
    },
    {
      path: "/test",
      name: "test",
      component: Test
    },
    {
      path: "/about",
      name: "about",
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () =>
        import(/* webpackChunkName: "about" */ "./views/About.vue")
    }
  ]
})
