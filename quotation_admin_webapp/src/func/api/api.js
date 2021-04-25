import cookie from "../storage/cookie.js"
import config from "../config/config.js"
import strings from "../config/strings.js"

var transport = new Thrift.Transport("")
var protocol = new Thrift.Protocol(transport)
var client = new QuotationAdminWebApiClient(protocol)

export default {
  reqCommodityActiveConfig(
    reqCommodityActiveConfigOption,
    pageOption,
    response
  ) {
    var clientSendData = client.send_reqCommodityActiveConfig(
      new PlatformArgs(),
      reqCommodityActiveConfigOption,
      pageOption
    )
    this.doHttpPost(
      clientSendData,
      function() {
        try {
          response(client.recv_reqCommodityActiveConfig())
        } catch (ei) {
          if (ei.errorMsg) {
            alert(ei.errorCode + ", " + ei.errorMsg)
          } else {
            alert(strings.message.serverBusy)
          }
          return
        }
      },
      function() {
        alert(strings.message.errorMsg)
      }
    )
  },
  deleteCommodityActiveConfig(
    sledCommodityId,
    activeType,
    fixedCode,
    response
  ) {
    var clientSendData = client.send_deleteCommodityActiveConfig(
      new PlatformArgs(),
      sledCommodityId,
      activeType,
      fixedCode
    )
    this.doHttpPost(
      clientSendData,
      function() {
        var ret = null
        try {
          ret = client.recv_deleteCommodityActiveConfig()
        } catch (ei) {
          // alert(ei.errorCode + ", " + ei.errorMsg)
          alert(JSON.stringify(ei))
          return
        }
        response(ret)
      },
      function() {
        alert(strings.message.errorMsg)
      }
    )
  },
  reqCommodityTree(platformEnv, response) {
    var clientSendData = client.send_reqCommodityTree(
      new PlatformArgs(),
      platformEnv
    )
    this.doHttpPost(
      clientSendData,
      function() {
        try {
          // alert(JSON.stringify(client.recv_reqCommodityTree()))
          response(client.recv_reqCommodityTree())
        } catch (ei) {
          if (ei.errorMsg) {
            alert(ei.errorCode + ", " + ei.errorMsg)
          } else {
            alert(strings.message.serverBusy)
          }
          return
        }
      },
      function() {
        alert(strings.message.errorMsg)
      }
    )
  },
  addCommodityActiveConfig(commodityActiveConfig, response) {
    var clientSendData = client.send_addCommodityActiveConfig(
      new PlatformArgs(),
      commodityActiveConfig
    )
    this.doHttpPost(
      clientSendData,
      function() {
        var ret = null
        try {
          // alert(JSON.stringify(client.recv_reqCommodityTree()))
          ret = client.recv_addCommodityActiveConfig()
        } catch (ei) {
          alert(JSON.stringify(ei))
          return
        }
        response(ret)
      },
      function() {
        alert(strings.message.errorMsg)
      }
    )
  },
  updateCommodityActiveConfig(commodityActiveConfig, response) {
    var clientSendData = client.send_updateCommodityActiveConfig(
      new PlatformArgs(),
      commodityActiveConfig
    )
    this.doHttpPost(
      clientSendData,
      function() {
        var ret = null
        try {
          ret = client.recv_updateCommodityActiveConfig()
        } catch (ei) {
          alert(JSON.stringify(ei))
          return
        }
        response(ret)
      },
      function() {
        alert(strings.message.errorMsg)
      }
    )
  },
  reqQuotationAccountInfo(reqQuotationAccountInfoOption, pageOption, response) {
    var clientSendData = client.send_reqQuotationAccountInfo(
      new PlatformArgs(),
      reqQuotationAccountInfoOption,
      pageOption
    )
    this.doHttpPost(
      clientSendData,
      function() {
        var ret = null
        try {
          ret = client.recv_reqQuotationAccountInfo()
        } catch (ei) {
          if (ei.errorMsg) {
            alert(ei.errorCode + ", " + ei.errorMsg)
          } else {
            alert(strings.message.serverBusy)
          }
          return
        }
        response(ret)
      },
      function() {
        alert(strings.message.errorMsg)
      }
    )
  },
  addQuotationAccountInfo(quotationAccountInfo, response) {
    var clientSendData = client.send_addQuotationAccountInfo(
      new PlatformArgs(),
      quotationAccountInfo
    )
    this.doHttpPost(
      clientSendData,
      function() {
        var ret = null
        try {
          ret = client.recv_addQuotationAccountInfo()
        } catch (ei) {
          alert(JSON.stringify(ei))
          return
        }
        response(ret)
      },
      function() {
        alert(strings.message.errorMsg)
      }
    )
  },
  updateQuotationAccountInfo(quotationAccountInfo, response) {
    var clientSendData = client.send_updateQuotationAccountInfo(
      new PlatformArgs(),
      quotationAccountInfo
    )
    this.doHttpPost(
      clientSendData,
      function() {
        var ret = null
        try {
          ret = client.recv_updateQuotationAccountInfo()
        } catch (ei) {
          alert(JSON.stringify(ei))
          return
        }
        response(ret)
      },
      function() {
        alert(strings.message.errorMsg)
      }
    )
  },
  deleteQuotationAccount(accountId, response) {
    var clientSendData = client.send_deleteQuotationAccount(
      new PlatformArgs(),
      accountId
    )
    this.doHttpPost(
      clientSendData,
      function() {
        var ret = null
        try {
          ret = client.recv_deleteQuotationAccount()
        } catch (ei) {
          alert(JSON.stringify(ei))
          return
        }
        response(ret)
      },
      function() {
        alert(strings.message.errorMsg)
      }
    )
  },
  reqCommodityRegister(reqCommodityRegisterOption, pageOption, response) {
    var clientSendData = client.send_reqCommodityRegister(
      new PlatformArgs(),
      reqCommodityRegisterOption,
      pageOption
    )
    this.doHttpPost(
      clientSendData,
      function() {
        var ret = null
        try {
          ret = client.recv_reqCommodityRegister()
        } catch (ei) {
          if (ei.errorMsg) {
            alert(ei.errorCode + ", " + ei.errorMsg)
          } else {
            alert(strings.message.serverBusy)
          }
          return
        }
        response(ret)
      },
      function() {
        alert(strings.message.errorMsg)
      }
    )
  },
  addCommodityRegister(commodityRegister, response) {
    var clientSendData = client.send_addCommodityRegister(
      new PlatformArgs(),
      commodityRegister
    )
    this.doHttpPost(
      clientSendData,
      function() {
        var ret = null
        try {
          ret = client.recv_addCommodityRegister()
        } catch (ei) {
          alert(JSON.stringify(ei))
          return
        }
        response(ret)
      },
      function() {
        alert(strings.message.errorMsg)
      }
    )
  },
  updateCommodityRegister(commodityRegister, response) {
    var clientSendData = client.send_updateCommodityRegister(
      new PlatformArgs(),
      commodityRegister
    )
    this.doHttpPost(
      clientSendData,
      function() {
        var ret = null
        try {
          ret = client.recv_updateCommodityRegister()
        } catch (ei) {
          alert(JSON.stringify(ei))
          return
        }
        response(ret)
      },
      function() {
        alert(strings.message.errorMsg)
      }
    )
  },
  deleteCommodityRegister(
    sledCommodityId,
    platformEnv,
    activeType,
    fixedCode,
    response
  ) {
    var clientSendData = client.send_deleteCommodityRegister(
      new PlatformArgs(),
      sledCommodityId,
      platformEnv,
      activeType,
      fixedCode
    )
    this.doHttpPost(
      clientSendData,
      function() {
        var ret = null
        try {
          ret = client.recv_deleteCommodityRegister()
        } catch (ei) {
          alert(JSON.stringify(ei))
          return
        }
        response(ret)
      },
      function() {
        alert(strings.message.errorMsg)
      }
    )
  },
  setCommodityRegisterOrderIndex(
    sledCommodityId,
    platformEnv,
    orderIndex,
    activeType,
    fixedCode,
    response
  ) {
    var clientSendData = client.send_setCommodityRegisterOrderIndex(
      new PlatformArgs(),
      sledCommodityId,
      platformEnv,
      orderIndex,
      activeType,
      fixedCode
    )
    this.doHttpPost(
      clientSendData,
      function() {
        var ret = null
        try {
          ret = client.recv_setCommodityRegisterOrderIndex()
        } catch (ei) {
          alert(JSON.stringify(ei))
          return
        }
        response(ret)
      },
      function() {
        alert(strings.message.errorMsg)
      }
    )
  },
  reqCommodityTypeTree(platformEnv, response) {
    var clientSendData = client.send_reqCommodityTypeTree(
      new PlatformArgs(),
      platformEnv
    )
    this.doHttpPost(
      clientSendData,
      function() {
        try {
          response(client.recv_reqCommodityTypeTree())
        } catch (ei) {
          if (ei.errorMsg) {
            alert(ei.errorCode + ", " + ei.errorMsg)
          } else {
            alert(strings.message.serverBusy)
          }
          return
        }
      },
      function() {
        alert(strings.message.errorMsg)
      }
    )
  },
  reqContractTreeCommodityNodes(
    sledExchangeId,
    commodityType,
    platformEnv,
    response
  ) {
    var clientSendData = client.send_reqContractTreeCommodityNodes(
      new PlatformArgs(),
      sledExchangeId,
      commodityType,
      platformEnv
    )
    this.doHttpPost(
      clientSendData,
      function() {
        try {
          response(client.recv_reqContractTreeCommodityNodes())
        } catch (ei) {
          if (ei.errorMsg) {
            alert(ei.errorCode + ", " + ei.errorMsg)
          } else {
            alert(strings.message.serverBusy)
          }
          return
        }
      },
      function() {
        alert(strings.message.errorMsg)
      }
    )
  },
  batAddAccountRegisterAbility(abilities, response) {
    var clientSendData = client.send_batAddAccountRegisterAbility(
      new PlatformArgs(),
      abilities
    )
    this.doHttpPost(
      clientSendData,
      function() {
        try {
          response(client.recv_batAddAccountRegisterAbility())
        } catch (ei) {
          alert(JSON.stringify(ei))
          return
        }
      },
      function() {
        alert(strings.message.errorMsg)
      }
    )
  },
  deleteAccountRegisterAbility(registerAbilityId, response) {
    var clientSendData = client.send_deleteAccountRegisterAbility(
      new PlatformArgs(),
      registerAbilityId
    )
    this.doHttpPost(
      clientSendData,
      function() {
        try {
          response(client.recv_deleteAccountRegisterAbility())
        } catch (ei) {
          alert(JSON.stringify(ei))
          return
        }
      },
      function() {
        alert(strings.message.errorMsg)
      }
    )
  },
  reqBrokerTree(platformEnv, response) {
    var clientSendData = client.send_reqBrokerTree(
      new PlatformArgs(),
      platformEnv
    )
    this.doHttpPost(
      clientSendData,
      function() {
        try {
          response(client.recv_reqBrokerTree())
        } catch (ei) {
          if (ei.errorMsg) {
            alert(ei.errorCode + ", " + ei.errorMsg)
          } else {
            alert(strings.message.serverBusy)
          }
          return
        }
      },
      function() {
        alert(strings.message.errorMsg)
      }
    )
  },
  reqAccountRegisterAbility(
    reqAccountRegisterAbilityOption,
    pageOption,
    response
  ) {
    var clientSendData = client.send_reqAccountRegisterAbility(
      new PlatformArgs(),
      reqAccountRegisterAbilityOption,
      pageOption
    )
    this.doHttpPost(
      clientSendData,
      function() {
        try {
          response(client.recv_reqAccountRegisterAbility())
        } catch (ei) {
          if (ei.errorMsg) {
            alert(ei.errorCode + ", " + ei.errorMsg)
          } else {
            alert(strings.message.serverBusy)
          }
          return
        }
      },
      function() {
        alert(strings.message.errorMsg)
      }
    )
  },
  reqSubscribedContract(reqSubscribedContractOption, pageOption, response) {
    var clientSendData = client.send_reqSubscribedContract(
      new PlatformArgs(),
      reqSubscribedContractOption,
      pageOption
    )
    this.doHttpPost(
      clientSendData,
      function() {
        var ret = null
        try {
          ret = client.recv_reqSubscribedContract()
        } catch (ei) {
          alert(strings.message.serverBusy)
          return
        }
        response(ret)
      },
      function() {
        alert(strings.message.errorMsg)
      }
    )
  },
  replanSubscribe(platformEnv, response) {
    var platformArgs = new PlatformArgs()
    // platformArgs.timeoutMs = 8000
    var clientSendData = client.send_replanSubscribe(
      // new PlatformArgs(),
      platformArgs,
      platformEnv
    )
    this.doHttpPost(
      clientSendData,
      function() {
        var ret = null
        try {
          ret = client.recv_replanSubscribe()
        } catch (ei) {
          ret = ei
        }
        response(ret)
      },
      function() {
        // alert("error callback")
        var errorInfo = { errorMsg: strings.message.errorMsg }
        response(errorInfo)
      }
    )
  },
  reqPreviewSubscribedContract(reqRePlanSubscribedInfoPreviewOption, response) {
    var clientSendData = client.send_reqPreviewSubscribedContract(
      new PlatformArgs(),
      reqRePlanSubscribedInfoPreviewOption,
      null
    )
    this.doHttpPost(
      clientSendData,
      function() {
        var ret = null
        try {
          ret = client.recv_reqPreviewSubscribedContract()
        } catch (ei) {
          ret = ei
        }
        response(ret)
      },
      function() {
        var errorInfo = { errorCode: -1, errorMsg: strings.message.errorMsg }
        response(errorInfo)
        // alert("error callback")
      }
    )
  },
  submitSubscribeInfo(platformEnv, response) {
    var clientSendData = client.send_submitSubscribeInfo(
      new PlatformArgs(),
      platformEnv
    )
    this.doHttpPost(
      clientSendData,
      function() {
        var ret = null
        try {
          ret = client.recv_submitSubscribeInfo()
        } catch (ei) {
          ret = ei
        }
        response(ret)
      },
      function() {
        alert(strings.message.errorMsg)
      }
    )
  },
  reqExchangeRegisterAbility(reqAccountRegisterAbilityOption, response) {
    var clientSendData = client.send_reqExchangeRegisterAbility(
      new PlatformArgs(),
      reqAccountRegisterAbilityOption
    )
    this.doHttpPost(
      clientSendData,
      function() {
        var ret = null
        try {
          ret = client.recv_reqExchangeRegisterAbility()
        } catch (ei) {
          ret = ei
        }
        response(ret)
      },
      function() {
        var errorInfo = { errorCode: -1, errorMsg: strings.message.errorMsg }
        response(errorInfo)
        // alert("error callback")
      }
    )
  },
  deleteAccountRegisterAbilityByExchange(accountId, exchangeId, response) {
    var clientSendData = client.send_deleteAccountRegisterAbilityByExchange(
      new PlatformArgs(),
      accountId,
      exchangeId
    )
    this.doHttpPost(
      clientSendData,
      function() {
        var ret = null
        try {
          ret = client.recv_deleteAccountRegisterAbilityByExchange()
        } catch (ei) {
          ret = ei
        }
        response(ret)
      },
      function() {
        var errorInfo = { errorCode: -1, errorMsg: strings.message.errorMsg }
        response(errorInfo)
        // alert("error callback")
      }
    )
  },
  reqPlanningSubscribedInfo(reqPlanningSubscribedInfoOption, response) {
    var clientSendData = client.send_reqPlanningSubscribedInfo(
      new PlatformArgs(),
      reqPlanningSubscribedInfoOption
    )
    this.doHttpPost(
      clientSendData,
      function() {
        var ret = null
        try {
          ret = client.recv_reqPlanningSubscribedInfo()
        } catch (ei) {
          ret = ei
        }
        response(ret)
      },
      function() {
        var errorInfo = { errorCode: -1, errorMsg: strings.message.errorMsg }
        response(errorInfo)
        // alert("error callback")
      }
    )
  },
  reqContractNodes(sledCommodityId, platformEnv, response) {
    var clientSendData = client.send_reqContractNodes(
      new PlatformArgs(),
      sledCommodityId,
      platformEnv
    )
    this.doHttpPost(
      clientSendData,
      function() {
        var ret = null
        try {
          ret = client.recv_reqContractNodes()
        } catch (ei) {
          ret = ei
        }
        response(ret)
      },
      function() {
        var errorInfo = { errorCode: -1, errorMsg: strings.message.errorMsg }
        response(errorInfo)
        // alert("error callback")
      }
    )
  },
  test() {
    alert("empty test")
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
    var proxyurl = proxyhost + "?servant=quotation_admin_webapi"
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
      return "https://quotation.devoa.xueqiao.cn/webapi"
    } else if (host === "localhost:8080") {
      return "https://quotation.devoa.xueqiao.cn/webapi"
    }
    // if (host === "192.168.0.62:8080") {
    //   return config.PROXY_ROUTER.LOCALHOST.PROXY_HOST
    // } else if (host === config.PROXY_ROUTER.LOCALHOST.HOST) {
    //   return config.PROXY_ROUTER.LOCALHOST.PROXY_HOST
    // } else if (host === config.PROXY_ROUTER.DEV.HOST) {
    //   return config.PROXY_ROUTER.DEV.PROXY_HOST
    // } else if (host === config.PROXY_ROUTER.GAMMA.HOST) {
    //   return config.PROXY_ROUTER.GAMMA.PROXY_HOST
    // } else if (host === config.PROXY_ROUTER.IDC.HOST) {
    //   return config.PROXY_ROUTER.IDC.PROXY_HOST
    // }
    return "/webapi"
  }
}
