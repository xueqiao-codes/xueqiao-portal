import api from "../api/api.js"
import { Loading } from "element-ui"
export default {
  replanSubscribe(success) {
    // var that = this;
    var platformEnv = TechPlatformEnv.NONE
    var options = {
      text: "订阅规划中...",
      lock: true,
      background: "rgba(0, 0, 0, 0.2)"
    }
    let loadingInstance = Loading.service(options)
    api.replanSubscribe(platformEnv, function(response) {
      if (response != null && response.errorMsg) {
        alert(response.errorMsg)
      } else {
        // alert("重新规划完成 : " + JSON.stringify(response))
        success()
      }
      loadingInstance.close()
    })
  }
}
