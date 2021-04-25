/**
 * ljq 20180802
 */

var host = '/admin/SledGroupSpecDebug/';

var app = new Vue({
	el: "#vue-app-groupspec-debug",
	data: {
		showCompanyGroupSpecInfo: false,
		isModifyExpiredTimeDialogShow: true,
		companyId: null,
		companyGroupSpecPage: null,
		modifyInfo: {
			companyId: null,
			groupId: null,
			expiredDate: null,
			expiredTime: null,
		}
	},
	mounted: function() {
	},
	methods: {
		queryComapanyGroupInfoList: function() {
			var requestUrl = host + 'queryComapanyGroupInfoList';

			var data = {
				companyId : this.companyId,
			};
			var that = this;

			$.post(requestUrl, data, function(json) {

				if(json.errorCode) {
					alert(json.errorMsg);
				} else {
					that.companyGroupSpecPage = json;
					that.showCompanyGroupSpecInfo = true;
				}
			});
		},
		queryGroupSpecs: function() {
			if (!this.companyId) {
				alert('请输入companyId');
				return;
			}
			this.queryComapanyGroupInfoList();
		},
		showModifyExpiredTimeDialog: function(companyGroupSpec) {
			this.modifyInfo.companyId = this.companyId;
			this.modifyInfo.groupId = companyGroupSpec.groupId;
			this.isModifyExpiredTimeDialogShow = true;
//			alert('showModifyExpiredTimeDialog : ' + this.isModifyExpiredTimeDialogShow);
		},
		modifyExpiredTimeDialogConfirm: function() {
			if (!this.modifyInfo.expiredDate) {
				alert('请输入日期');
				return;
			}
			if (!this.modifyInfo.expiredTime) {
				alert('请输入时间');
				return;
			}
			this.modifyInfo.companyId = this.companyId;
			var that = this;
			var requestUrl = host + 'modifyExpiredTime';
			$.post(requestUrl, this.modifyInfo, function(json) {

				if(json.errorCode) {
					alert(json.errorMsg);
				} else {
					alert('修改成功');
					that.isModifyExpiredTimeDialogShow = false;
					that.queryComapanyGroupInfoList();
				}
			});
			
		}
	}
})