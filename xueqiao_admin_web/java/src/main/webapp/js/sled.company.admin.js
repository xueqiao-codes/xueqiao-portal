/**
 * ljq 20180529
 */

var host = '/admin/SledCompanyAdmin/';//'http://owlweb.devoa.galacard.me/';

var app = new Vue({
	el : "#vue-app-company-admin",
	data : {
		isCompanyDetailShow : false,
		totalNum : 0,
		totalPage : 1,
		currentPage : 1,
		searchKeywords : {
			companyId : null,
			companyName : null,
			email : "",
			telephone : "",
			requestPage : 1,
		},
		companyPage : null,
		selectCompany : null,
	},
	mounted : function() {
		this.queryCompanyList(1);
	},
	methods : {
		queryCompanyList : function(requestPage) {
			var requestUrl = host + 'queryCompanyList';
			this.searchKeywords.requestPage = requestPage;
			var data = this.searchKeywords;
			var that = this;
			
			$.post(requestUrl, data, function(json) {
				
				if (json.errorCode) {
					alert(json.errorMsg);
				} else {
					that.companyPage = json.companyList;
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
		search : function() {
			this.queryCompanyList(1);
		},
		gotoHostingServicePage : function(company) {
			window.location.href = "/admin/SledCompanyHostingServiceAdmin/show?companyId=" + company.companyId + "&companyName=" + company.companyName;
		},
		gotoCompanyDetail : function(company) {
			this.selectCompany = company;
			this.isCompanyDetailShow = true;
//			alert("gotoCompanyDetail : ");
		},
		goBackToCompanyAdmin : function() {
			this.isCompanyDetailShow = false;
		},
		gotoBalancePage : function(company) {
			window.location.href = "/admin/SledCompanyBalanceAdmin/show?companyId=" + company.companyId + "&companyName=" + company.companyName;
		},
		gotoTabServiceMaintenance: function() {
		    var host = window.location.host
		    var targetHost = "";
		    if (host == "adminweb.gaoa.xueqiao.cn") {
		        // gamma
		        targetHost = "https://company-service-maintenance.gaoa.xueqiao.cn/#/maintenance"
		    } else if (host == "adminweb.oa.xueqiao.cn") {
		        // idc
		        targetHost = "https://company-service-maintenance.oa.xueqiao.cn/#/maintenance"
		    } else {
		        // dev
		        targetHost = "https://company-service-maintenance.devoa.xueqiao.cn/#/maintenance"
		    }
		    window.location.href = targetHost
		},
		gotoTabMaintenancePlan: function() {
		    var host = window.location.host
		    var targetHost = "";
            if (host == "adminweb.gaoa.xueqiao.cn") {
                // gamma
                targetHost = "https://company-service-maintenance.gaoa.xueqiao.cn/#/plan"
            } else if (host == "adminweb.oa.xueqiao.cn") {
                // idc
                targetHost = "https://company-service-maintenance.oa.xueqiao.cn/#/plan"
            } else {
                // dev
                targetHost = "https://company-service-maintenance.devoa.xueqiao.cn/#/plan"
            }
            window.location.href = targetHost
		}
	}
})