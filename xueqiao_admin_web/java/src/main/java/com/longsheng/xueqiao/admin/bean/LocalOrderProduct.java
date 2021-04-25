package com.longsheng.xueqiao.admin.bean;

import com.google.gson.Gson;
import com.longsheng.xueqiao.admin.helper.Mapper;
import com.longsheng.xueqiao.payment.product.thriftapi.ProductPurpose;
import com.longsheng.xueqiao.payment.product.thriftapi.ProductStatus;
import com.longsheng.xueqiao.payment.product.thriftapi.ProductType;

public class LocalOrderProduct {

	private static final int SECONDS_PER_DAY = 60 * 60 * 24;

	private int productId;
	private String type;
	private String typeCn;
	private String name;
	private String description;
	private int inventoryQuantity; // 库存数量
	private String price; // 使用对应货币的价格
	private String currencyType;
	private String imageCodes;
	private String status;
	private String statusCn;
	private String needOperator; // 是否需要操作员介入
	private String operation;
	private String purpose;
	private String purposeCn;
	private String purposeType; // 目标规格
	private String purposeTypeCn;
	private String xCoinIncrement; // 购买该商品时的雪橇币增量
	private long timeIncrement;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getType() {
		return type;
	}

	public void setType(ProductType type) {
		this.type = type.name();
		this.typeCn = Mapper.getOrderProductTypeString(type);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getInventoryQuantity() {
		return inventoryQuantity;
	}

	public void setInventoryQuantity(int inventoryQuantity) {
		this.inventoryQuantity = inventoryQuantity;
	}

	public double getPrice() {
		return Double.parseDouble(price);
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

	public String getImageCodes() {
		return imageCodes;
	}

	public void setImageCodes(String imageCodes) {
		this.imageCodes = imageCodes;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(ProductStatus status) {
		this.status = status.name();
		this.statusCn = Mapper.getOrderProductStatusString(status);
	}

	public String getNeedOperator() {
		return needOperator;
	}

	public void setNeedOperator(String needOperator) {
		this.needOperator = needOperator;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(ProductPurpose purpose) {
		this.purpose = purpose.name();
		this.purposeCn = Mapper.getOrderProductPurposeString(purpose);
	}

	public String getPurposeType() {
		return purposeType;
	}

	public void setPurposeType(ProductType purposeType) {
		this.purposeType = purposeType.name();
		this.purposeTypeCn = Mapper.getOrderProductTypeString(purposeType);
	}

	public double getxCoinIncrement() {
		return Double.parseDouble(xCoinIncrement);
	}

	public void setxCoinIncrement(Double xCoinIncrement) {
		this.xCoinIncrement = String.valueOf(xCoinIncrement);
	}

	public long getTimeIncrement() {
		return timeIncrement * SECONDS_PER_DAY;
	}

	public void setTimeIncrement(long timeIncrement) {
		this.timeIncrement = timeIncrement  / SECONDS_PER_DAY;
	}

	public String getTypeCn() {
		return typeCn;
	}

	public String getPurposeCn() {
		return purposeCn;
	}

	public String getPurposeTypeCn() {
		return purposeTypeCn;
	}

	public String getStatusCn() {
		return statusCn;
	}

	public static long convertDayToSeconds(int days) {
		return days * SECONDS_PER_DAY;
	}

	public String toString() {
		return new Gson().toJson(this);
	}
}
