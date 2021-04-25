import store from "@/store"
import config from "../config/config.js"
import api from "../api/api.js"
import apiUtil from "../util/apiUtil.js"
export default {
  resetNavigationStack() {
    store.commit("resetNavigationStack")
  },
  pushNavigationStack(item) {
    store.commit("pushNavigationStack", item)
  },
  getCompanyListFromHostingList(hostingList) {
    if (!hostingList || hostingList.length < 1) {
      return []
    }
    var companyList = []
    for (var index = 0; index < hostingList.length; index++) {
      if (companyList.indexOf(hostingList[index].companyId) == -1) {
        companyList.push(hostingList[index].companyId)
      }
    }
    if (companyList.length == 1 && companyList[0] == 0) {
      return []
    }
    return companyList
  },
  getGroupListFromHostingList(hostingList) {
    if (!hostingList || hostingList.length < 1) {
      return []
    }
    var groupList = []
    for (var index = 0; index < hostingList.length; index++) {
      if (groupList.indexOf(hostingList[index].groupId) == -1) {
        groupList.push(hostingList[index].groupId)
      }
    }
    if (groupList.length == 1 && groupList[0] == 0) {
      return []
    }
    return groupList
  },
  getRoleListFromHostingList(hostingList) {
    if (
      !hostingList ||
      hostingList.length < 1 ||
      !hostingList[0].roleList ||
      hostingList[0].roleList.length < 1
    ) {
      return config.ENUM.HOSTING_USER_ROLE.VALUES
    }
    var roleList = []
    for (var index = 0; index < hostingList[0].roleList.length; index++) {
      roleList.push(String(hostingList[0].roleList[index]))
    }
    return roleList
  },
  getStringChannelList(numberChannelList) {
    var stringChannelList = []
    if (numberChannelList && numberChannelList.length > 0) {
      for (var index = 0; index < numberChannelList.length; index++) {
        stringChannelList.push(String(numberChannelList[index]))
      }
    } else {
      // stringChannelList.push("4")
    }
    return stringChannelList
  },
  getRTFContent(fileName, result) {
    api.reqContentText(fileName, function(response) {
      if (!response && response.errorMsg) {
        alert("error : " + response.errorMsg)
      } else {
        if (response && response.contentText) {
          //   alert("response.contentText : " + response.contentText)
          result(response.contentText)
          return
        }
        result(null)
      }
    })
  },
  getMReceiverHostingList(
    selectedCompanyList,
    selectedGroupList,
    selectedRoleList
  ) {
    var roleList = []
    for (var index = 0; index < selectedRoleList.length; index++) {
      roleList.push(parseInt(selectedRoleList[index]))
    }
    var receiverHostingList = []
    var receiverHosting = null
    if (!selectedCompanyList || selectedCompanyList.length < 1) {
      receiverHosting = new MReceiverHosting()
      receiverHosting.companyId = 0
      receiverHosting.groupId = 0
      receiverHosting.roleList = roleList
      receiverHostingList.push(receiverHosting)
    } else if (selectedCompanyList.length > 1) {
      for (var index = 0; index < selectedCompanyList.length; index++) {
        receiverHosting = new MReceiverHosting()
        receiverHosting.companyId = selectedCompanyList[index]
        receiverHosting.groupId = 0
        receiverHosting.roleList = roleList
        receiverHostingList.push(receiverHosting)
      }
    } else {
      if (!selectedGroupList || selectedGroupList.length < 1) {
        receiverHosting = new MReceiverHosting()
        receiverHosting.companyId = selectedCompanyList[0]
        receiverHosting.groupId = 0
        receiverHosting.roleList = roleList
        receiverHostingList.push(receiverHosting)
      } else {
        for (var index = 0; index < selectedGroupList.length; index++) {
          receiverHosting = new MReceiverHosting()
          receiverHosting.companyId = selectedCompanyList[0]
          receiverHosting.groupId = selectedGroupList[index]
          receiverHosting.roleList = roleList
          receiverHostingList.push(receiverHosting)
        }
      }
    }
    return receiverHostingList
  },
  checkCompany(selectedCompanyList, callback) {
    // apiUtil.
    if (selectedCompanyList && selectedCompanyList.length > 0) {
      var selectedCompanyId = selectedCompanyList[selectedCompanyList.length - 1]
      apiUtil.reqGroupReceiver(selectedCompanyId, function (groupOptions) {
        if (groupOptions && groupOptions.length > 0) {
          callback(groupOptions)
        } else {
          alert("该公司还没有开通托管机，不能选择该公司")
          selectedCompanyList.splice(selectedCompanyList.length - 1, 1);
          callback(null);
        }
      })
    } else { 
      callback(null);
    }
  },
  genHTMLContent(rtfContent) { 
    var head =
      "<html><header><style>table {border-top: 1px solid #ccc;border-left: 1px solid #ccc;}table td,table th {border-bottom: 1px solid #ccc;border-right: 1px solid #ccc;padding: 3px 5px;}table th {border-bottom: 2px solid #ccc;text-align: center;}blockquote {display: block;border-left: 8px solid #d0e5f2;padding: 5px 10px;margin: 10px 0;line-height: 1.4;font-size: 100%;background-color: #f1f1f1;}</style></header><body>"
    var tail = "</body></html>"
    return head + rtfContent + tail;
  }
}
