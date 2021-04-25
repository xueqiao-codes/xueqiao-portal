/**
 * ljq 20180521
 */

var host = '/admin/SledHostingDebug/';

var app = new Vue({
	el: "#vue-app-hosting-debug",
	data: {
		hostingServerIp: window.hostingIP,
		companyUsers: null,
		machineId: null,
		AES16KEY: null,
		hostingInfo: null,
		showCompanyInfo: false,
		showCompanyUserInfo: false,
		unbindMachineId: null,
	},
	mounted: function() {
	    this.queryCompanyInfo()
//	    if (window.hostingIP) {
//	        this.hostingServerIp = window.hostingIP
//	        this.queryCompanyInfo()
//	    }
	},
	methods: {
		queryCompanyInfo: function() {
			var requestUrl = host + 'queryCompanyInfo';
			if(!this.hostingServerIp) {
				alert('请输入托管服务IP');
				return;
			}

			var data = {
				hostingIP: this.hostingServerIp,
			};
			var that = this;

			$.post(requestUrl, data, function(json) {

				if(json.errorCode) {
					alert(json.errorMsg);
				} else {
					that.hostingInfo = json;
					that.machineId = that.hostingInfo.machineId;
					that.unbindMachineId = that.hostingInfo.machineId;
					that.showCompanyInfo = true;
				}
			});
		},
		queryCompanyUsers: function() {
			var requestUrl = host + 'queryCompanyUsersInfo';

			if(!this.hostingServerIp) {
				alert('请输入托管服务IP');
				return;
			}

			var data = {
				hostingIP: this.hostingServerIp,
			};
			var that = this;

			$.post(requestUrl, data, function(json) {

				if(json.errorCode) {
					alert(json.errorMsg);
				} else {
					that.companyUsers = json;
					that.showCompanyUserInfo = true;
				}
			});
		},
		resetHosting: function() {
			var requestUrl = host + 'resetHosting';

			if(!this.hostingServerIp) {
				alert('请输入托管服务IP');
				return;
			}
			if(!this.machineId) {
				alert('请输入machineId');
				return;
			}
			if(!this.AES16KEY) {
				alert('请输入AES16KEY');
				return;
			}

			var data = {
				hostingIP: this.hostingServerIp,
				machineId: this.machineId,
				aes16key: this.AES16KEY,
			};
			var that = this;

			if(confirm("确认重置？")) {
				$.post(requestUrl, data, function(json) {
					if(json.errorCode) {
						alert(json.errorMsg);
					} else {
						alert('重置成功');
					}
				});
			}
		},
		unbindHostingMachine: function() {
			var requestUrl = host + 'unbindHostingMachine';

			if(!this.unbindMachineId) {
				alert('请输入machineId');
				return;
			}
			var data = {
				machineId: this.unbindMachineId,
			};
			var that = this;

			if(confirm("确认解绑？")) {
				$.post(requestUrl, data, function(json) {
					if(json.errorCode) {
						alert(json.errorMsg);
					} else {
						alert('解绑成功');
					}
				});
			}
		}
	}
})