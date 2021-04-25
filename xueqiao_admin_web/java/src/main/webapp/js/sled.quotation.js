/**
 * ljq 20180806
 */

var host = '/admin/SledQuotationAdmin/';

var app = new Vue({
	el : "#vue-app-quotation-admin",
	data : {
		totalNum : 0,
		totalPage : 1,
		currentPage : 1,
	},
	mounted : function() {
//		this.querySledCurrencyList(1);
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
		gotoQuotationAccount: function() {
			window.location.href = "/admin/SledQuotationAccountAdmin/show";
		},
	}
})