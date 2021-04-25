package com.longsheng.xueqiao.admin.module.user.bean;

import com.longsheng.xueqiao.admin.util.TimeFormator;

public class LocalOrder {

	private int orderId;
	private String source;
	private int productId;
	private int companyId;
	private int companyGroupId;
	private String productName;
	private String productDescription;
	private int productQuantity;
	private String price;
	private String currencyType;
	private String totalAmount;
	private String payType;
	private String thirdPartyOrderNo;
	private String status;
	private String tradeInfo;
	private String needOperator; /* boolean */
	private String operator;
	private String operation;
	private String createTimestamp;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getCompanyGroupId() {
		return companyGroupId;
	}

	public void setCompanyGroupId(int companyGroupId) {
		this.companyGroupId = companyGroupId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = String.valueOf(price);
	}

	public String getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = String.valueOf(totalAmount);
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getThirdPartyOrderNo() {
		return thirdPartyOrderNo;
	}

	public void setThirdPartyOrderNo(String thirdPartyOrderNo) {
		this.thirdPartyOrderNo = thirdPartyOrderNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTradeInfo() {
		return tradeInfo;
	}

	public void setTradeInfo(String tradeInfo) {
		this.tradeInfo = tradeInfo;
	}

	public String getNeedOperator() {
		return needOperator;
	}

	public void setNeedOperator(boolean needOperator) {
		this.needOperator = needOperator?"是":"否";
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getCreateTimestamp() {
		return createTimestamp;
	}

	public void setCreateTimestamp(long createTimestamp) {
		this.createTimestamp = TimeFormator.timeStampToDate2(createTimestamp);
	}

}
