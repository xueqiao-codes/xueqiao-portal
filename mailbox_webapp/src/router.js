import Vue from "vue"
import Router from "vue-router"
import Home from "./views/Home.vue"
import SendingMessage from "./views/SendingMessage.vue"
import SentMessage from "./views/SentMessage.vue"
import ErrorSentMessage from "./views/ErrorSentMessage.vue"
import Template from "./views/Template.vue"
import AddTemplate from "./views/AddTemplate.vue"
import EditTemplate from "./views/EditTemplate.vue"

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: "/",
      name: "home",
      component: Home,
      redirect: "/sending",
      children: [
        {
          path: "/sending",
          name: "sendingMessage",
          component: SendingMessage
        },
        {
          path: "/sent",
          name: "sentMessage",
          component: SentMessage
        },
        {
          path: "/errorMessage",
          name: "errorMessage",
          component: ErrorSentMessage
        },
        {
          path: "/template",
          name: "template",
          component: Template
        },
        {
          path: "/addTemplate",
          name: "addTemplate",
          component: AddTemplate
        },
        {
          path: "/editTemplate",
          name: "editTemplate",
          component: EditTemplate
        }
      ]
    }
  ]
})
