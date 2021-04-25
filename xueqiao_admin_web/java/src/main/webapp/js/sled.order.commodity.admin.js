/**
 * ljq 20180521
 */

var baseUrl = '/admin/SledOrderProductAdmin/';//'http://owlweb.devoa.galacard.me/';

var app = new Vue({
	el : "#vue-app-order-commodity-admin",
	data : {
		isAddOrderProductDialogShow : false,
		isModifyOrderProductDialogShow : false,
		productPage : null,
		newProduct : {
			type : null,
			name : null,
			description : null,
			inventoryQuantity : null,
			price : null,
			currencyType : null,
			needOperator : null,
			operation : null,
			purpose : null,
			purposeType : null,
			xCoinIncrement : null,
			timeIncrement : null,
		},
		modifyProduct : {
			productId : null,
			inventoryQuantity : null,
			status : null,
			name: null,
			description: null
		},
		searchKeywords: {
		    productType: "",
//		    currencyType: "ALL",
		    productStatus: "VALID"
		}
	},
	created : function() {
		this.isAddOrderProductDialogShow = false;
		this.isModifyOrderProductDialogShow = false;
	},
	mounted : function() {
		this.queryOrderProductList();
	},
	methods : {
		queryOrderProductList : function() {
			var requestUrl = baseUrl + 'queryOrderProductList';
			var data = this.searchKeywords;
			var that = this;
			$.getJSON(requestUrl, data, function(json) {
				
				if (json.errorCode) {
					alert(json.errorMsg);
				} else {
					that.productPage = json;
				}
			});
		},
		search : function() {
            this.queryOrderProductList();
        },
		showAddOrderProductDialog : function() {
            this.newProduct.type = null;
            this.newProduct.name = null;
            this.newProduct.description = null;
            this.newProduct.inventoryQuantity = null;
            this.newProduct.price = null;
            this.newProduct.currencyType = null;
            this.newProduct.needOperator = null;
            this.newProduct.operation = null;
            this.newProduct.purpose = null;
            this.newProduct.purposeType = null;
            this.newProduct.xcoinIncrement = null;
            this.newProduct.timeIncrement = null;

			this.isAddOrderProductDialogShow = true;
		},
		addOrderProdcutConfirm : function() {
		    if (this.newProduct.purpose == null) {
		        alert("请选择商品目的");
		        return;
		    }
		    if (this.newProduct.name == null || this.newProduct.name == '' || this.newProduct.name == undefined) {
                alert("请输入商品名称");
                return;
            }
            if (this.newProduct.price == null || this.newProduct.price == '' || this.newProduct.price == undefined) {
                alert("请输入商品单价");
                return;
            }
            if (this.newProduct.description == null || this.newProduct.description == '' || this.newProduct.description == undefined) {
                alert("请输入商品描述");
                return;
            }

		    if (this.newProduct.purpose === "NEW") {
                if (this.newProduct.type == null) {
                    alert("请选择商品类型");
                    return;
                }
                if (this.newProduct.timeIncrement == null || this.newProduct.timeIncrement == '' || this.newProduct.timeIncrement == undefined) {
                    alert("请输入时间时长");
                    return;
                }
		    } else if (this.newProduct.purpose === "UPGRADE") {
                if (this.newProduct.type == null) {
                    alert("请选择商品类型");
                    return;
                }
                if (this.newProduct.purposeType == null) {
                    alert("请选择商品目标规格");
                    return;
                }
		    } else if (this.newProduct.purpose === "RECHARGE_XCOIN") {
                if (this.newProduct.xCoinIncrement == null || this.newProduct.xCoinIncrement == '' || this.newProduct.xCoinIncrement == undefined) {
                    alert("请输入雪橇币增量");
                    return;
                }
            } else if (this.newProduct.purpose === "RECHARGE_TIME") {
                if (this.newProduct.type == null) {
                    alert("请选择商品类型");
                    return;
                }
                if (this.newProduct.timeIncrement == null || this.newProduct.timeIncrement == '' || this.newProduct.timeIncrement == undefined) {
                    alert("请输入时间时长");
                    return;
                }
            } else if (this.newProduct.purpose === "PERSONAL_NEW" || this.newProduct.purpose === "PERSONAL_RECHARGE_TIME") {
                if (this.newProduct.timeIncrement == null || this.newProduct.timeIncrement == '' || this.newProduct.timeIncrement == undefined) {
                    alert("请输入时间时长");
                    return;
                }
            }

			var requestUrl = baseUrl + 'addNewOrderProduct';
			var data = JSON.stringify(this.newProduct);
			var that = this;
			$.post(requestUrl, data, function(json) {
				if (json.errorMsg) {
					alert(json.errorMsg);
					that.queryOrderProductList();
				} else {
					alert("添加成功");
					that.queryOrderProductList();
				}
			});
			this.isAddOrderProductDialogShow = false;
		},
		addOrderProdcutCancel : function() {
			this.isAddOrderProductDialogShow = false;
		},
		showModifyOrderProductDialog : function(product) {
		    this.modifyProduct.name = product.name;
		    this.modifyProduct.description = product.description;
			this.modifyProduct.productId = product.productId;
			this.modifyProduct.inventoryQuantity = product.inventoryQuantity;
			this.modifyProduct.status = product.status;
			this.isModifyOrderProductDialogShow = true;
		},
		modifyOrderProdcutConfirm : function() {

		    if (this.modifyProduct.name == null || this.modifyProduct.name == '' || this.modifyProduct.name == undefined) {
                alert("请输入商品名称");
                return;
            }
            if (this.modifyProduct.description == null || this.modifyProduct.description == '' || this.modifyProduct.description == undefined) {
                alert("请输入商品描述");
                return;
            }

			var requestUrl = baseUrl + 'updateOrderProduct';
			var data = JSON.stringify(this.modifyProduct);
			var that = this;
			$.post(requestUrl, data, function(json) {
				if (json.errorMsg) {
					alert(json.errorMsg);
				} else {
					alert("修改成功");
//					that.queryOrderProductList();
				}
				that.queryOrderProductList();
			});
			this.isModifyOrderProductDialogShow = false;
		},
		modifyOrderProdcutCancel : function() {
			this.isModifyOrderProductDialogShow = false;
		},
		isProductInvalid : function(status) {
		    return 'INVALID' === status;
		}
	}
})