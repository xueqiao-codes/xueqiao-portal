/**
 * ljq 20180521
 */

var host = '/admin/SledOrderAdmin/';//'http://owlweb.devoa.galacard.me/';

var app = new Vue({
	el : "#vue-app-order-admin",
	data : {
		isAllocateSpecDialogShow : false,
		isUpgradeSpecDialogShow : false,
		isOrderDetailDialogShow : false,
		orderPage : null,
		totalNum : 0,
		totalPage : 1,
		currentPage : 1,
		upgradeSpecInfo : null,
		allocateSpecInfo : null,
		orderProductPage : null,
		orderDetail : null,
		orderDetailOrderFlow :null,
		searchKeywords : {
			orderId : null,
			productId : null,
			companyId : null,
			status : "",
			requestPage : 1,
		}

	},
	mounted : function() {
		this.queryOrderList(1);
		this.queryOrderProductList();
	},
	methods : {
		queryOrderList : function(requestPage) {
			var requestUrl = host + 'queryOrderList';
			this.searchKeywords.requestPage = requestPage;
			var data = this.searchKeywords;
			var that = this;
			
			$.post(requestUrl, data, function(json) {
				
				if (json.errorCode) {
					alert(json.errorMsg);
				} else {
					that.orderPage = json.orderList;
					that.totalNum = json.totalNum;
					that.totalPage = json.totalPage;
					that.currentPage = json.currentPage;
				}
			});
		},
		queryOrderProductList : function() {
			var requestUrl = '/admin/SledOrderProductAdmin/queryOrderProductList';
			var data = {};
			var that = this;
			$.getJSON(requestUrl, data, function(json) {
				if (json.errorMsg) {
					alert(json.errorMsg);
				} else {
					that.orderProductPage = json;
				}
			});
		},
		gotoFirstPage : function() {
			this.queryOrderList(1);
		},
		gotoPreviousPage : function() {
			this.currentPage -=1;
			if (this.currentPage < 1) {
				this.currentPage = 1;
			}
			this.queryOrderList(this.currentPage);
		},
		gotoGivenPage : function() {
			this.queryOrderList(this.currentPage);
		},
		gotoNextPage : function() {
			this.currentPage +=1;
			if (this.currentPage > this.totalPage) {
				this.currentPage = this.totalPage;
			}
			this.queryOrderList(this.currentPage);
		},
		gotoLastPage : function() {
			this.queryOrderList(this.totalPage);
		},
		search : function() {
			this.queryOrderList(1);
		},
		operateOrder : function(order) {
//			alert("operate order : " + order.orderId + ", " + order.operation);
			if (order.operation == "ALLOCATE_SPEC") {
				var requestUrl = host + 'queryAllocateSpecInfo';
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
				var requestUrl = host + 'queryUpgradeSpecInfo';
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
			} else if (order.operation == "ALLOCATE_PERSONAL_USER_HOSTING_SERVICE") {
                this.confirmAllocatePersionalUserHostingService(order);
			}
		},
		confirmAllocatePersionalUserHostingService(order) {
		    if (confirm("确定已经完成此用户个人版云服务的分配？")) {
		        var requestUrl = host + 'confirmAllocatePersonalUserHostingService';
                var data = {
                        orderId : order.orderId,
                };
                var that = this;
                $.post(requestUrl, data, function(json) {
                    if (json.errorMsg) {
                        alert(json.errorMsg);
                    } else {
                        alert("已确认");
                        that.queryOrderList(this.currentPage);
                    }
                });
		    }
		},
		allocateSpecDialogConfirm : function() {
			var requestUrl = host + 'confirmAllocateSpec';
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
					alert("初始化托管机任务已提交");
					that.queryOrderList(this.currentPage);
				}
			});
			this.isAllocateSpecDialogShow = false;
		},
		allocateSpecDialogCancel : function() {
			this.isAllocateSpecDialogShow = false;
		},
		upgradeSpecDialogConfirm : function() {
			var requestUrl = host + 'confirmUpgradeSpec';
			var data = {
					orderId : this.upgradeSpecInfo.orderId,
			};
			var that = this;
			$.post(requestUrl, data, function(json) {
				if (json.errorMsg) {
					alert(json.errorMsg);
				} else {
					alert("确认完成");
					that.queryOrderList(this.currentPage);
				}
			});
			this.isUpgradeSpecDialogShow = false;
		},
		upgradeSpecDialogCancel : function() {
			this.isUpgradeSpecDialogShow = false;
		},
		queryOrderDetail : function(order) {
		    this.orderDetailOrderFlow = null;
			this.orderDetail = order;
//			alert(this.orderDetail.productName);
			var requestUrl = host + 'queryOrderFlow';
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
		isNeedOperate : function(order) {
          if (order.status == 'SYSTEM_PROCESSED' &&
              order.needOperator == '是') {
            return true
          } else {
            return false
          }
        }
	}
})