/**
 * ljq 20180529
 */

var host = '/admin/SledCompanyHostingServiceAdmin/';//'http://owlweb.devoa.galacard.me/';
var orderHost = '/admin/SledOrderAdmin/';

var app = new Vue({
	el : "#vue-app-company-hosting-service-admin",
	data : {
		tabActive : 0,
		isCompanyHostingServicePageShow : false,
		isAllocateSpecDialogShow : false,
		isUpgradeSpecDialogShow : false,
		isOrderDetailDialogShow : false,
		isReleaseHostingServiceDialogShow : false,
		companyHostingServicePage : null,
		selectedHostingServiceGroup : null,
		upgradeSpecInfo : null,
		allocateSpecInfo : null,
		orderProductPage : null,
		orderDetail : null,
		orderDetailOrderFlow :null,
		releaseHostingServiceReason: null,
		currentTabReleaseHostingDescription: {
			operator:'-',
			reason:'-',
			releaseDay:'-',
		},
		isCurrentTabHostingRelease: false,
		isShowCurrentTabReleaseHostingBtn: false,
	},
	mounted : function() {
		this.querycompanyHostingServiceList();
	},
	methods : {
		querycompanyHostingServiceList : function() {
			var requestUrl = host + 'querycompanyHostingServiceList';
			var data = {
				companyId : window.companyId,
			}
			var that = this;
			
			$.post(requestUrl, data, function(json) {
				
				if (json.errorCode) {
					alert(json.errorMsg);
				} else {
					that.companyHostingServicePage = json;
					if(that.companyHostingServicePage.hostingServiceGroupList) {
						that.isCompanyHostingServicePageShow = true;
						that.selectedHostingServiceGroup = that.companyHostingServicePage.hostingServiceGroupList[0];
						if (that.selectedHostingServiceGroup.releaseHostingDescription) {
							that.currentTabReleaseHostingDescription.operator = that.selectedHostingServiceGroup.releaseHostingDescription.operator;
							that.currentTabReleaseHostingDescription.reason = that.selectedHostingServiceGroup.releaseHostingDescription.reason;
							that.currentTabReleaseHostingDescription.releaseDay = that.selectedHostingServiceGroup.releaseHostingDescription.releaseDay;
						}
						if (that.selectedHostingServiceGroup.hostingServiceStatus == "RELEASED") {
							that.isCurrentTabHostingRelease = true;
						} else {
							that.isCurrentTabHostingRelease = false;
						}
						if (that.selectedHostingServiceGroup.hostingServiceStatus == "UPGRADING" ||
						    that.selectedHostingServiceGroup.hostingServiceStatus == "WORKING" ||
						    that.selectedHostingServiceGroup.hostingServiceStatus == "EXPIRED") {
							that.isShowCurrentTabReleaseHostingBtn = true;
						} else {
							that.isShowCurrentTabReleaseHostingBtn = false;
						}
					}
					
				}
			});
		},
		tabToggle : function(index) {
			this.tabActive = index;
			this.selectedHostingServiceGroup = this.companyHostingServicePage.hostingServiceGroupList[index];
			if (this.selectedHostingServiceGroup.releaseHostingDescription) {
				this.currentTabReleaseHostingDescription.operator = this.selectedHostingServiceGroup.releaseHostingDescription.operator;
				this.currentTabReleaseHostingDescription.reason = this.selectedHostingServiceGroup.releaseHostingDescription.reason;
				this.currentTabReleaseHostingDescription.releaseDay = this.selectedHostingServiceGroup.releaseHostingDescription.releaseDay;
			}
			if (this.selectedHostingServiceGroup.hostingServiceStatus == "RELEASED") {
				this.isCurrentTabHostingRelease = true;
			} else {
				this.isCurrentTabHostingRelease = false;
			}
			if (this.selectedHostingServiceGroup.hostingServiceStatus == "UPGRADING" ||
			    this.selectedHostingServiceGroup.hostingServiceStatus == "WORKING" ||
			    this.selectedHostingServiceGroup.hostingServiceStatus == "EXPIRED") {
				this.isShowCurrentTabReleaseHostingBtn = true;
			} else {
				this.isShowCurrentTabReleaseHostingBtn = false;
			}
		},
		operateOrder : function(order) {
			if (order.operation == "ALLOCATE_SPEC") {
				var requestUrl = orderHost + 'queryAllocateSpecInfo';
				var data = {
						orderId : order.orderId,
						companyId : order.companyId,
						groupId : order.companyGroupId,
						productId : order.productId,
				};
				var that = this;
				$.post(requestUrl, data, function(json) {
					if (json.errorMsg) {
						alert(json.errorMsg);
					} else {
						that.allocateSpecInfo = json;
					}
				});
				this.isAllocateSpecDialogShow = true;
			} else if (order.operation == "UPGRADE_SPEC"){
				var requestUrl = orderHost + 'queryUpgradeSpecInfo';
				var data = {
						orderId : order.orderId,
						companyId : order.companyId,
						groupId : order.companyGroupId,
						productId : order.productId,
				};
				var that = this;
				$.post(requestUrl, data, function(json) {
//					alert("json : " + json);
					if (json.errorMsg) {
						alert(json.errorMsg);
					} else {
						that.upgradeSpecInfo = json;
					}
				});
				this.isUpgradeSpecDialogShow = true;
			}
		},
		allocateSpecDialogConfirm : function() {
			var requestUrl = orderHost + 'confirmAllocateSpec';
			var data = {
					orderId : this.allocateSpecInfo.orderId,
					companyId : this.allocateSpecInfo.companyId,
					groupId : this.allocateSpecInfo.groupId,
					machineId : this.allocateSpecInfo.machineId,
			};
			var that = this;
			$.post(requestUrl, data, function(json) {
				if (json.errorMsg) {
					alert(json.errorMsg);
				} else {
					alert("确认完成");
					that.querycompanyHostingServiceList();
				}
			});
			this.isAllocateSpecDialogShow = false;
		},
		allocateSpecDialogCancel : function() {
			this.isAllocateSpecDialogShow = false;
		},
		upgradeSpecDialogConfirm : function() {
			var requestUrl = orderHost + 'confirmUpgradeSpec';
			var data = {
					orderId : this.upgradeSpecInfo.orderId,
			};
			var that = this;
			$.post(requestUrl, data, function(json) {
				if (json.errorMsg) {
					alert(json.errorMsg);
				} else {
					alert("确认完成");
					that.querycompanyHostingServiceList();
				}
			});
			this.isUpgradeSpecDialogShow = false;
		},
		upgradeSpecDialogCancel : function() {
			this.isUpgradeSpecDialogShow = false;
		},
		queryOrderDetail : function(order) {
			this.orderDetail = order;
//			alert(this.orderDetail.productName);
			var requestUrl = orderHost + 'queryOrderFlow';
			var data = {
					orderId : order.orderId,
			};
			var that = this;
			$.post(requestUrl, data, function(json) {
				if (json.errorMsg) {
					alert(json.errorMsg);
				} else {
					that.orderDetailOrderFlow = json.orderFlowList;
				}
			});
			this.isOrderDetailDialogShow = true;
		},
		orderDetailDialogConfirm : function() {
			this.isOrderDetailDialogShow = false;
		},
		showReleaseHostingServiceDialog : function() {
			this.isReleaseHostingServiceDialogShow = true;
		},
		releaseHostingServiceConfirm : function() {
			var requestUrl = host + 'releaseHostingService';
			
			if (this.releaseHostingServiceReason == null || this.releaseHostingServiceReason == '' || this.releaseHostingServiceReason == undefined) {
				alert('请填写释放原因');
				return;
			}
			
			var data = {
					companyId : window.companyId,
					groupId : this.selectedHostingServiceGroup.groupId,
					releaseReason : this.releaseHostingServiceReason,
			};
			var that = this;
			$.post(requestUrl, data, function(json) {
				if (json.errorMsg) {
					alert(json.errorMsg);
				} else {
					alert('释放成功');
					that.querycompanyHostingServiceList();
				}
			});
			this.isReleaseHostingServiceDialogShow = false;
		},
		releaseHostingServiceCancel : function() {
			this.isReleaseHostingServiceDialogShow = false;
		},
		isNeedOperate : function(order) {
		  if (order.status == 'SYSTEM_PROCESSED' &&
		      order.needOperator == '是') {
		    return true
		  } else {
		    return false
		  }
		},
		gotoSledServerPage() {
		    window.location.href = "/admin/SledServerAdmin/show?companyId=" + this.selectedHostingServiceGroup.companyId + "&groupId=" + this.selectedHostingServiceGroup.groupId;
		}
	}
})