import cookie from "../storage/cookie.js"
// import config from "../config/config.js"
import strings from "../config/strings.js"

var transport = new Thrift.Transport("")
var protocol = new Thrift.Protocol(transport)
var client = new MailboxWebapiClient(protocol)

export default {
  reqMBMessageTemplateSelector(response) {
    var clientSendData = client.send_reqMBMessageTemplateSelector(
      new PlatformArgs()
    )
    this.doHttpPost(
      clientSendData,
      function() {
        var ret = null
        try {
          ret = client.recv_reqMBMessageTemplateSelector()
          response(ret)
        } catch (ei) {
          let eiJson = JSON.stringify(ei)
          if (eiJson != "{}") {
            alert(eiJson)
          } else {
            alert(ei)
          }
        }
      },
      function() {
        var errorInfo = {
          errorCode: -1,
          errorMsg: strings.message.callMethodFail
        }
        response(errorInfo)
      }
    )
  },
  reqCompanyReceiver(response) {
    // var ret = client.reqCompanyReceiver(new PlatformArgs())
    // alert("reqCompanyReceiver ---- ret : " + JSON.stringify(ret))
    var clientSendData = client.send_reqCompanyReceiver(new PlatformArgs())
    this.doHttpPost(
      clientSendData,
      function() {
        var ret = null
        try {
          ret = client.recv_reqCompanyReceiver()
          // alert("ret : " + JSON.stringify(ret))
          response(ret)
        } catch (ei) {
          let eiJson = JSON.stringify(ei)
          if (eiJson != "{}") {
            alert(eiJson)
          } else {
            alert(ei)
          }
        }
      },
      function() {
        var errorInfo = {
          errorCode: -1,
          errorMsg: strings.message.callMethodFail
        }
        response(errorInfo)
      }
    )
  },
  reqGroupReceiver(companyId, response) {
    var clientSendData = client.send_reqGroupReceiver(
      new PlatformArgs(),
      companyId
    )
    this.doHttpPost(
      clientSendData,
      function() {
        var ret = null
        try {
          ret = client.recv_reqGroupReceiver()
          response(ret)
        } catch (ei) {
          let eiJson = JSON.stringify(ei)
          if (eiJson != "{}") {
            alert(eiJson)
          } else {
            alert(ei)
          }
        }
      },
      function() {
        var errorInfo = {
          errorCode: -1,
          errorMsg: strings.message.callMethodFail
        }
        response(errorInfo)
      }
    )
  },
  addMBMessage(message, response) {
    var clientSendData = client.send_addMBMessage(new PlatformArgs(), message)
    this.doHttpPost(
      clientSendData,
      function() {
        var ret = null
        try {
          ret = client.recv_addMBMessage()
          response(ret)
        } catch (ei) {
          let eiJson = JSON.stringify(ei)
          if (eiJson != "{}") {
            alert("ei : " + eiJson)
          } else {
            alert(ei)
          }
        }
      },
      function() {
        var errorInfo = {
          errorCode: -1,
          errorMsg: strings.message.callMethodFail
        }
        response(errorInfo)
      }
    )
  },
  addTemplate(template, response) {
    var clientSendData = client.send_addTemplate(new PlatformArgs(), template)
    this.doHttpPost(
      clientSendData,
      function() {
        var ret = null
        try {
          ret = client.recv_addTemplate()
          response(ret)
        } catch (ei) {
          let eiJson = JSON.stringify(ei)
          if (eiJson != "{}") {
            alert(eiJson)
          } else {
            alert(ei)
          }
        }
      },
      function() {
        var errorInfo = {
          errorCode: -1,
          errorMsg: strings.message.callMethodFail
        }
        response(errorInfo)
      }
    )
  },
  updateTemplate(template, response) {
    var clientSendData = client.send_updateTemplate(
      new PlatformArgs(),
      template
    )
    this.doHttpPost(
      clientSendData,
      function() {
        var ret = null
        try {
          ret = client.recv_updateTemplate()
          response(ret)
        } catch (ei) {
          let eiJson = JSON.stringify(ei)
          if (eiJson != "{}") {
            alert(eiJson)
          } else {
            alert(ei)
          }
        }
      },
      function() {
        var errorInfo = {
          errorCode: -1,
          errorMsg: strings.message.callMethodFail
        }
        response(errorInfo)
      }
    )
  },
  reqTemplate(option, pageOption, response) {
    var clientSendData = client.send_reqTemplate(
      new PlatformArgs(),
      option,
      pageOption
    )
    this.doHttpPost(
      clientSendData,
      function() {
        var ret = null
        try {
          ret = client.recv_reqTemplate()
          response(ret)
        } catch (ei) {
          let eiJson = JSON.stringify(ei)
          if (eiJson != "{}") {
            alert(eiJson)
          } else {
            alert(ei)
          }
        }
      },
      function() {
        var errorInfo = {
          errorCode: -1,
          errorMsg: strings.message.callMethodFail
        }
        response(errorInfo)
      }
    )
  },
  removeTemplate(templateId, response) {
    var clientSendData = client.send_removeTemplate(
      new PlatformArgs(),
      templateId
    )
    this.doHttpPost(
      clientSendData,
      function() {
        var ret = null
        try {
          ret = client.recv_removeTemplate()
          response(ret)
        } catch (ei) {
          let eiJson = JSON.stringify(ei)
          if (eiJson != "{}") {
            alert(eiJson)
          } else {
            alert(ei)
          }
        }
      },
      function() {
        var errorInfo = {
          errorCode: -1,
          errorMsg: strings.message.callMethodFail
        }
        response(errorInfo)
      }
    )
  },
  reqMBMessageJob(option, pageOption, response) {
    var clientSendData = client.send_reqMBMessageJob(
      new PlatformArgs(),
      option,
      pageOption
    )
    this.doHttpPost(
      clientSendData,
      function() {
        var ret = null
        try {
          ret = client.recv_reqMBMessageJob()
          response(ret)
        } catch (ei) {
          let eiJson = JSON.stringify(ei)
          if (eiJson != "{}") {
            alert(eiJson)
          } else {
            alert(ei)
          }
        }
      },
      function() {
        var errorInfo = {
          errorCode: -1,
          errorMsg: strings.message.callMethodFail
        }
        response(errorInfo)
      }
    )
  },
  reqContentText(fileName, response) {
    var clientSendData = client.send_reqContentText(
      new PlatformArgs(),
      fileName
    )
    this.doHttpPost(
      clientSendData,
      function() {
        var ret = null
        try {
          ret = client.recv_reqContentText()
          response(ret)
        } catch (ei) {
          let eiJson = JSON.stringify(ei)
          if (eiJson != "{}") {
            alert(eiJson)
          } else {
            alert(ei)
          }
        }
      },
      function() {
        var errorInfo = {
          errorCode: -1,
          errorMsg: strings.message.callMethodFail
        }
        response(errorInfo)
      }
    )
  },
  updateMessageJobStatus(messageJobId, status, response) {
    var clientSendData = client.send_updateMessageJobStatus(
      new PlatformArgs(),
      messageJobId,
      status
    )
    this.doHttpPost(
      clientSendData,
      function() {
        var ret = null
        try {
          ret = client.recv_updateMessageJobStatus()
          response(ret)
        } catch (ei) {
          let eiJson = JSON.stringify(ei)
          if (eiJson != "{}") {
            alert(eiJson)
          } else {
            alert(ei)
          }
        }
      },
      function() {
        var errorInfo = {
          errorCode: -1,
          errorMsg: strings.message.callMethodFail
        }
        response(errorInfo)
      }
    )
  },
  /**
   * common do post method
   * @param {thrift send data} clientSendData
   * @param {http success callback} responseSuccess
   * @param {http error callback} responseError
   */
  doHttpPost(clientSendData, responseSuccess, responseError) {
    let proxyhost = this.getProxyHost()
    // alert("proxyhost : " + proxyhost)
    if (!proxyhost) {
      alert("proxyHost is empty, please refresh and try again")
      return
    }
    var proxyurl = proxyhost + "?servant=mailbox_webapi"
    $.ajax({
      url: proxyurl,
      data: clientSendData,
      type: "POST",
      cache: false,
      contentType: "application/json",
      dataType: "json",
      beforeSend: function(XMLHttpRequest) {
        XMLHttpRequest.setRequestHeader(
          "X-Oa-Falcon-Sig",
          cookie.getCookie("oa_falcon_sig")
        )
        XMLHttpRequest.setRequestHeader(
          "X-Oa-User-Id",
          cookie.getCookie("oa_user_id")
        )
        XMLHttpRequest.setRequestHeader(
          "X-Oa-User-Name",
          cookie.getCookie("oa_user_name")
        )
        XMLHttpRequest.setRequestHeader(
          "X-Oa-User-Secret",
          cookie.getCookie("oa_user_secret")
        )
      },
      success: function(res) {
        // alert("res : " + JSON.stringify(res))
        transport.setRecvBuffer(res)
        responseSuccess()
      },
      error: function() {
        responseError()
      }
    })
  },
  getProxyHost() {
    var host = window.location.host
    if (host === "192.168.0.62:8080") {
      return "http://mailbox.devoa.xueqiao.cn/webapi"
    } else if (host == "localhost:8080") {
      return "http://mailbox.devoa.xueqiao.cn/webapi"
    }
    return "/webapi"
  }
}
