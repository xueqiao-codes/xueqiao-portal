/**
 * ljq 20180730
 */

var host = '/admin/SledCompanyBalanceAdmin/';//'http://owlweb.devoa.galacard.me/';

var app = new Vue({
	el : "#vue-company-balance-admin",
	data : {
		totalNum : 0,
		totalPage : 1,
		currentPage : 1,
		
		isShowAlterBalanceDialog : false,
		isShowModityAlterRecordDialog: false,
		xCoinBalance : '0.0',
		balanceAlterationPage : null,
		alterBalanceDialogTitle: null,
		alterBalanceInfo: {
		    companyId: window.companyId,
            operationType: null,
            alterationChannel: null,
            thirdPartyTradeNo: null,
            description: null,
            alerationXCoin: null,
		},
		modifyAlterRecordInfo: {
			alterationId: null,
			description: null,
		}
	},
	mounted : function() {
		this.queryCompanyBalance();
		this.queryCompanyBalanceAlterationList(1);
	},
	methods : {
		queryCompanyBalance : function() {
			var requestUrl = host + 'queryCompanyBalance';
			var data = {
				companyId : window.companyId,
			};
			var that = this;
			
			$.post(requestUrl, data, function(json) {
				
				if (json.errorCode) {
					alert(json.errorMsg);
				} else {
					that.xCoinBalance = json;
				}
			});
		},
		queryCompanyBalanceAlterationList : function(requestPage) {
			var requestUrl = host + 'queryBalanceAlterationList';
			var data = {
				companyId : window.companyId,
				pageIndex : requestPage - 1,
			};
			var that = this;
			
			$.post(requestUrl, data, function(json) {
				
				if (json.errorCode) {
					alert(json.errorMsg);
				} else {
					that.balanceAlterationPage = json.balanceAlterationList;
					that.totalNum = json.totalNum;
					that.totalPage = json.totalPage;
					that.currentPage = json.currentPage;
				}
			});
		},
		gotoFirstPage : function() {
			this.queryCompanyList(1);
		},
		gotoPreviousPage : function() {
			this.currentPage -=1;
			if (this.currentPage < 1) {
				this.currentPage = 1;
			}
			this.queryCompanyList(this.currentPage);
		},
		gotoGivenPage : function() {
			this.queryCompanyList(this.currentPage);
		},
		gotoNextPage : function() {
			this.currentPage +=1;
			if (this.currentPage > this.totalPage) {
				this.currentPage = this.totalPage;
			}
			this.queryCompanyList(this.currentPage);
		},
		gotoLastPage : function() {
			this.queryCompanyList(this.totalPage);
		},
		showModifyBalanceDialog : function(flagAlterType) {
            if (flagAlterType > 0) {
                this.alterBalanceDialogTitle = '增加';
                this.alterBalanceInfo.operationType = 'ADD_XCOIN';
            } else {
                this.alterBalanceDialogTitle = '扣减';
                this.alterBalanceInfo.operationType = 'REDUCE_XCOIN';
            }
            // reset status
            
            this.alterBalanceInfo.alterationChannel = 'NONE';
            this.alterBalanceInfo.alerationXCoin = null;
            this.alterBalanceInfo.description = null;
            this.alterBalanceInfo.thirdPartyTradeNo = null;
            
			this.isShowAlterBalanceDialog = true;
		},
		confirmAlterBalance : function() {

		    if (this.alterBalanceInfo.alerationXCoin == '' || this.alterBalanceInfo.alerationXCoin == null || this.alterBalanceInfo.alerationXCoin == undefined) {
		        alert('请输入雪橇币数额');
		        return;
		    }

		    var requestUrl = host + 'alterBalance';
            var that = this;

            $.post(requestUrl, this.alterBalanceInfo, function(json) {
                if (json.errorCode) {
                    alert(json.errorMsg);
                } else {
                    alert('修改成功');
                    that.isShowAlterBalanceDialog = false;
                    that.queryCompanyBalance();
                    that.queryCompanyBalanceAlterationList(1);
                }
            });
		},
		cancelAlterBalance : function() {
			this.isShowAlterBalanceDialog = false;
		},
		showModifyAlterRecordDialog : function(balanceAlteration) {
			this.modifyAlterRecordInfo.alterationId = balanceAlteration.alterationId;
			this.modifyAlterRecordInfo.description = balanceAlteration.description;
			this.isShowModityAlterRecordDialog = true;
		},
		confirmModifyAlterRecord : function() {
			var requestUrl = host + 'modifyAlterBalanceRecord';
            var that = this;

            $.post(requestUrl, this.modifyAlterRecordInfo, function(json) {
                if (json.errorCode) {
                    alert(json.errorMsg);
                } else {
                    alert('修改成功');
                    that.isShowModityAlterRecordDialog = false;
                    that.queryCompanyBalanceAlterationList(1);
                }
            });
		},
		cancelModifyAlterRecord : function() {
			this.isShowModityAlterRecordDialog = false;
		}
	}
})