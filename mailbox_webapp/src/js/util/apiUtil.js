import api from "../api/api.js"
export default {
  reqGroupReceiver(companyId, callback) {
    api.reqGroupReceiver(companyId, function(response) {
      if (response != null && response.errorMsg) {
        alert(response.errorMsg)
      } else {
        if (response == null || response.length < 1) {
          callback([])
          return
        }
        callback(response)
      }
    })
  }
}
