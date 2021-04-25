/**
 * ljq 20180612
 */

var host = '/admin/SledCurrencyAdmin/';

var app = new Vue({
	el : "#vue-app-currency-admin",
	data : {
		isExchangeRatePageShow : false,
		isAddCurrencyDialogShow : false,
		isModifyCurrencyDialogSHow : false,
		isModifyExchangeRateDialogSHow : false,
		totalNum : 0,
		totalPage : 1,
		currentPage : 1,
		tabActive : -1,
		searchKeywords : {
			requestPage : 1,
		},
		currencyList : null,
		exchangeRatePageList : null,
		newCurrency : {
			currencyCode : null,
			enName : null,
			cnName : null,
			symbol : null,
			isBaseCurrency : null,
		},
		modifyCurrency : null,
		selectedExchangeRatePage : null,
		modifyExchangeRate : null,
	},
	mounted : function() {
		this.querySledCurrencyList(1);
		this.queryExchangeRatePageList();
	},
	methods : {
		querySledCurrencyList : function(requestPage) {
			var requestUrl = host + 'querySledCurrencyList';
			this.searchKeywords.requestPage = requestPage;
			var data = this.searchKeywords;
			var that = this;
			
			$.post(requestUrl, data, function(json) {
				
				if (json.errorCode) {
					alert(json.errorMsg);
				} else {
					that.currencyList = json.currencyList;
					that.totalNum = json.totalNum;
					that.totalPage = json.totalPage;
					that.currentPage = json.currentPage;
				}
			});
		},
		queryExchangeRatePageList : function() {
			var requestUrl = host + 'querySledExchangeRateList';
			var data = {};
			var that = this;
			
			$.post(requestUrl, data, function(json) {
				
				if (json.errorCode) {
					alert(json.errorMsg);
				} else {
					that.exchangeRatePageList = json;
				}
			});
		},
		gotoFirstPage : function() {
			this.querySledCurrencyList(1);
		},
		gotoPreviousPage : function() {
			this.currentPage -=1;
			if (this.currentPage < 1) {
				this.currentPage = 1;
			}
			this.querySledCurrencyList(this.currentPage);
		},
		gotoGivenPage : function() {
			this.querySledCurrencyList(this.currentPage);
		},
		gotoNextPage : function() {
			this.currentPage +=1;
			if (this.currentPage > this.totalPage) {
				this.currentPage = this.totalPage;
			}
			this.querySledCurrencyList(this.currentPage);
		},
		gotoLastPage : function() {
			this.querySledCurrencyList(this.totalPage);
		},
		showAddCurrencyDialog : function() {
			this.isAddCurrencyDialogShow = true;
		},
		addCurrencyDialogConfirm : function() {
			var requestUrl = host + 'addNewCurrency';
			var data = JSON.stringify(this.newCurrency);
			var that = this;
			$.post(requestUrl, data, function(json) {
				if (json.errorMsg) {
					alert(json.errorMsg);
				} else {
					alert("添加成功");
					that.querySledCurrencyList(this.currentPage);
					that.queryExchangeRatePageList();
				}
			});
			this.isAddCurrencyDialogShow = false;
		},
		addCurrencyDialogCancel : function() {
			this.isAddCurrencyDialogShow = false;
		},
		showEditCurrencyDialog : function(currency) {
			this.modifyCurrency = currency;
			this.isModifyCurrencyDialogSHow = true;
		},
		modifyCurrencyDialogConfirm : function() {
			var requestUrl = host + 'modifyCurrency';
			var data = JSON.stringify(this.modifyCurrency);
			var that = this;
			$.post(requestUrl, data, function(json) {
				if (json.errorMsg) {
					alert(json.errorMsg);
				} else {
					alert("修改成功");
					that.querySledCurrencyList(this.currentPage);
					that.queryExchangeRatePageList();
				}
			});
			this.isModifyCurrencyDialogSHow = false;
		},
		modifyCurrencyDialogCancel : function() {
			this.isModifyCurrencyDialogSHow = false;
		},
		tabToggle : function(index) {
			this.tabActive = index;
			if (this.tabActive >= 0) {
				this.selectedExchangeRatePage = this.exchangeRatePageList[index];
				this.isExchangeRatePageShow = true;
			} else {
				this.isExchangeRatePageShow = false;
			}
		},
		showEditExchangeRateDialog : function(exchangeRate) {
			this.modifyExchangeRate = exchangeRate;
			this.isModifyExchangeRateDialogSHow = true;
		},
		modifyExchangeRateDialogConfirm : function() {
			var requestUrl = host + 'modifyExchangeRate';
			var data = JSON.stringify(this.modifyExchangeRate);
			var that = this;
			$.post(requestUrl, data, function(json) {
				if (json.errorMsg) {
					alert(json.errorMsg);
				} else {
					alert("修改成功");
				}
			});
			this.isModifyExchangeRateDialogSHow = false;
		},
		modifyExchangeRateDialogCancel : function() {
			this.isModifyExchangeRateDialogSHow = false;
		},
		showSyncCurrencyDialog: function() {
            if (confirm("确认同步？")) {
                var requestUrl = host + 'syncExchangeRateToOnline';
                var data = {};
                var that = this;
                $.post(requestUrl, data, function(json) {
                    if (json.errorMsg) {
                        alert(json.errorMsg);
                    } else {
                        alert("同步成功");
                    }
                });
            }
		},
//		gotoHostingServicePage : function(company) {
//			window.location.href = "/admin/SledCompanyHostingServiceAdmin/show?companyId=" + company.companyId;
//		},
	}
})