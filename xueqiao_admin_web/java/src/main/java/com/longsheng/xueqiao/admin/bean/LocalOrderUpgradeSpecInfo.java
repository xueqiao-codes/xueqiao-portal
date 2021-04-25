package com.longsheng.xueqiao.admin.bean;

public class LocalOrderUpgradeSpecInfo {

	private int orderId;
	private String currentType;
	private String purposeType;
	private String description;
	private long machineId;
	private String machineSpec;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCurrentType() {
		return currentType;
	}

	public void setCurrentType(String currentType) {
		this.currentType = currentType;
	}

	public String getPurposeType() {
		return purposeType;
	}

	public void setPurposeType(String purposeType) {
		this.purposeType = purposeType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getMachineId() {
		return machineId;
	}

	public void setMachineId(long machineId) {
		this.machineId = machineId;
	}

	public String getMachineSpec() {
		return machineSpec;
	}

	public void setMachineSpec(String machineSpec) {
		this.machineSpec = machineSpec;
	}
}
