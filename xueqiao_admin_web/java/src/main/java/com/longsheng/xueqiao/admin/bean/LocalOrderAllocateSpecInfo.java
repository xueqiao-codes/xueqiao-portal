package com.longsheng.xueqiao.admin.bean;

import java.util.List;

public class LocalOrderAllocateSpecInfo {

	private int orderId;
	private int companyId;
	private int groupId;
	private String currentType;
	private int timeIncrement; // day

	private List<LocalHostingMachineInfo> hostingMachineInfoList;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getCurrentType() {
		return currentType;
	}

	public void setCurrentType(String currentType) {
		this.currentType = currentType;
	}

	public long getTimeIncrement() {
		return timeIncrement;
	}

	public void setTimeIncrement(long timeIncrement) {
		this.timeIncrement = (int)timeIncrement;
	}

	public List<LocalHostingMachineInfo> getHostingMachineInfoList() {
		return hostingMachineInfoList;
	}

	public void setHostingMachineInfoList(List<LocalHostingMachineInfo> hostingMachineInfoList) {
		this.hostingMachineInfoList = hostingMachineInfoList;
	}
}
