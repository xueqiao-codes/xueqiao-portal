/**
 * ljq 20180612
 */

var host = '/admin/SledTradeTimeConfigAdmin/';

var app = new Vue({
	el : "#vue-app-admin",
	data : {
        isAddTradingSessionDialogShow: false,
        isEditTradingSessionDialogShow: false,

        standardTradingSessionList: null,
        dstTradingSessionList: null,
        tradingSessionList: null,

        tradingSesisonReused: null,
        tradingSesisonAddition: {
            tradeSessionId: 0,
            timeSystem: 0,
            timeSpans: [{
                timeSpanId: 0,
                startDay: 0,
                startTime: "00:00",
                endDay: 0,
                endTime: "00:00",
                startWeekdayAndTime: "",
                endWeekdayAndTime: "",
            },],
        },
        tradingSessionEdit: null,
	},
	watch : {
	    tradingSesisonReused: function(newValue, oldValue) {
            if (newValue != null && newValue != undefined) {
                this.tradingSesisonAddition.timeSystem = newValue.timeSystem;
                var timeSpanList = [];
                for (var i=0; i<newValue.timeSpans.length; i++) {
                    var timeSpan = {
                        timeSpanId: 0,
                        startDay: newValue.timeSpans[i].startDay,
                        startTime: newValue.timeSpans[i].startTime,
                        endDay: newValue.timeSpans[i].endDay,
                        endTime: newValue.timeSpans[i].endTime,
                        startWeekdayAndTime: "",
                        endWeekdayAndTime: "",
                    };
                    timeSpanList.push(timeSpan);
                }
                this.tradingSesisonAddition.timeSystem = newValue.timeSystem;
                this.tradingSesisonAddition.timeSpans = timeSpanList;

                if (this.tradingSessionEdit != null) {
                    this.tradingSessionEdit.timeSpans = timeSpanList;
                }
                this.tradingSesisonReused = null;
            }
	    }
	},
	mounted : function() {
		this.queryStandardTradingSession();
		this.queryDstTradingSession();
//		this.combineTradingSession();
	},
	methods : {
		queryStandardTradingSession : function() {
			var requestUrl = host + 'queryStandardTradingSession';

			var data = {
			    sledCommodityId : window.sledCommodityId,
			};
			var that = this;

			$.post(requestUrl, data, function(json) {

				if (json.errorCode) {
					alert(json.errorMsg);
				} else {
					that.standardTradingSessionList = json;
					that.combineTradingSession();
				}
			});
		},
		queryDstTradingSession : function() {
			var requestUrl = host + 'queryDstTradingSession';
			var data = {
			    sledCommodityId : window.sledCommodityId,
			};
			var that = this;

			$.post(requestUrl, data, function(json) {

				if (json.errorCode) {
					alert(json.errorMsg);
				} else {
					that.dstTradingSessionList = json;
					that.combineTradingSession();
				}
			});
		},
		combineTradingSession: function() {
            if (this.standardTradingSessionList != null && this.dstTradingSessionList != null) {
                this.tradingSessionList = this.standardTradingSessionList.concat(this.dstTradingSessionList);
            } else if (this.standardTradingSessionList != null) {
                this.tradingSessionList = this.standardTradingSessionList;
            } else if (this.dstTradingSessionList != null) {
                this.tradingSessionList = this.dstTradingSessionList;
            } else {
                this.tradingSessionList = [];
            }
		},
		showAddTradingSessionDialog: function() {
		    // 做一些必要的初始化工作
		    this.tradingSesisonAddition.tradeSessionId = 0;
		    this.tradingSesisonAddition.timeSystem = 0;
		    this.tradingSesisonAddition.timeSpans = [{
		        timeSpanId: 0,
                startDay: 0,
                startTime: "00:00",
                endDay: 0,
                endTime: "00:00",
                startWeekdayAndTime: "",
                endWeekdayAndTime: "",
		    },];

            this.isAddTradingSessionDialogShow = true;
		},
		addTradingSessionConfirm: function() {
		    var requestUrl = host + 'addTradingSession';
            var data = {
                sledCommodityId : window.sledCommodityId,
                tradingSesison : JSON.stringify(this.tradingSesisonAddition),
            };
            var that = this;
            $.post(requestUrl, data, function(json) {
                if (json.errorCode) {
                    alert(json.errorMsg);
                } else {
                    alert("添加成功");
                    that.queryStandardTradingSession();
                    that.queryDstTradingSession();
                    that.isAddTradingSessionDialogShow = false;
                }
            });
		},
		addTradingSessionCancel: function() {
		    this.isAddTradingSessionDialogShow = false;
		},
        showEditTradingSessionDialog: function(standardTradingSession) {
            // 拷贝对象
            this.tradingSessionEdit = JSON.parse(JSON.stringify(standardTradingSession))
            this.isEditTradingSessionDialogShow = true;
        },
        editTradingSessionConfirm: function() {
            var requestUrl = host + 'editTradingSession';
            var data = {
                sledCommodityId : window.sledCommodityId,
                tradingSesison : JSON.stringify(this.tradingSessionEdit),
            };
            var that = this;
            $.post(requestUrl, data, function(json) {
                if (json.errorCode) {
                    alert(json.errorMsg);
                } else {
                    alert("编辑成功");
                    that.queryStandardTradingSession();
                    that.queryDstTradingSession();
                    that.isEditTradingSessionDialogShow = false;
                }
            });
        },
        editTradingSessionCancel: function() {
            this.isEditTradingSessionDialogShow = false;
        },
        showDeleteTradingSessionDialog: function(tradeSessionId) {
            if (confirm("确认删除？")) {
                var requestUrl = host + 'removeTradingSession';
                var data = {
                    tradeSessionId : tradeSessionId,
                };
                var that = this;
                $.post(requestUrl, data, function(json) {
                    if (json.errorCode) {
                        alert(json.errorMsg);
                    } else {
                        alert("删除成功");
                        that.queryStandardTradingSession();
                        that.queryDstTradingSession();
                        that.isAddTradingSessionDialogShow = false;
                    }
                });
            }
        },
        addOneDayOverTradingSession: function(type) {
            if (type == 0) { // add trading session
                for (var i=0; i<this.tradingSesisonAddition.timeSpans.length; i++) {
                    this.tradingSesisonAddition.timeSpans[i].startDay++;
                    if (this.tradingSesisonAddition.timeSpans[i].startDay > 6) {
                        this.tradingSesisonAddition.timeSpans[i].startDay = 0;
                    }
                    this.tradingSesisonAddition.timeSpans[i].endDay++;
                    if (this.tradingSesisonAddition.timeSpans[i].endDay > 6) {
                        this.tradingSesisonAddition.timeSpans[i].endDay = 0;
                    }
                }
            } else if (type == 1) {  // edit trading session
                for (var i=0; i<this.tradingSessionEdit.timeSpans.length; i++) {
                    this.tradingSessionEdit.timeSpans[i].startDay++;
                    if (this.tradingSessionEdit.timeSpans[i].startDay > 6) {
                        this.tradingSessionEdit.timeSpans[i].startDay = 0;
                    }
                    this.tradingSessionEdit.timeSpans[i].endDay++;
                    if (this.tradingSessionEdit.timeSpans[i].endDay > 6) {
                        this.tradingSessionEdit.timeSpans[i].endDay = 0;
                    }
                }
            }
        },
        subtractOneDayOverTradingSession: function(type) {
            if (type == 0) {    // add trading session
                for (var i=0; i<this.tradingSesisonAddition.timeSpans.length; i++) {
                    this.tradingSesisonAddition.timeSpans[i].startDay--;
                    if (this.tradingSesisonAddition.timeSpans[i].startDay < 0) {
                        this.tradingSesisonAddition.timeSpans[i].startDay = 6;
                    }
                    this.tradingSesisonAddition.timeSpans[i].endDay--;
                    if (this.tradingSesisonAddition.timeSpans[i].endDay < 0) {
                        this.tradingSesisonAddition.timeSpans[i].endDay = 6;
                    }
                }
            } else if (type == 1) {  // edit trading session
                for (var i=0; i<this.tradingSessionEdit.timeSpans.length; i++) {
                    this.tradingSessionEdit.timeSpans[i].startDay--;
                    if (this.tradingSessionEdit.timeSpans[i].startDay < 0) {
                        this.tradingSessionEdit.timeSpans[i].startDay = 6;
                    }
                    this.tradingSessionEdit.timeSpans[i].endDay--;
                    if (this.tradingSessionEdit.timeSpans[i].endDay < 0) {
                        this.tradingSessionEdit.timeSpans[i].endDay = 6;
                    }
                }
            }
        },
        addTimeSpan: function(type) {
            var newTimeSpan = {
                startDay: 0,
                startTime: "00:00",
                endDay: 0,
                endTime: "00:00",
            };
            if (type == 0) {    // add trading session
                this.tradingSesisonAddition.timeSpans.push(newTimeSpan);
            } else if (type == 1) {  // edit trading session
                this.tradingSessionEdit.timeSpans.push(newTimeSpan);
            }
        },
        showDeleteTimeSpanDialog: function(type, index) {
            if (type == 0) {    // add trading session
                this.tradingSesisonAddition.timeSpans.splice(index, 1);
            } else if (type == 1) {  // edit trading session
                this.tradingSessionEdit.timeSpans.splice(index, 1);
            }
        },
	}
})