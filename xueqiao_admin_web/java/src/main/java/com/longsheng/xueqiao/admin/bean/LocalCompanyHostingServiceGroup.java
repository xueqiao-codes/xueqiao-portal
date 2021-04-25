package com.longsheng.xueqiao.admin.bean;

import com.longsheng.xueqiao.admin.bean.hosting.ReleaseHostingDescription;

import java.util.List;

public class LocalCompanyHostingServiceGroup {

	// CompanyGroup
	private int companyId;
	private int groupId; // 组ID
	private String groupCode; // 组代号
	private String groupName;

	// CompanyGroupSpec
	private String hostingServiceStatus;
	private String serviceType;
	private String specName; // 规格名称 (从支付服务中同步过来的信息，加快访问速度)
	private String expiredTimestamp; // 过期时间 (从支付服务中同步过来的信息，加快访问速度)

	// a group only has one machine for the time being
	LocalHostingMachineInfo hostingMachineInfo;

	// release description
	private ReleaseHostingDescription releaseHostingDescription;

	List<LocalOrder> orderList;

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

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getHostingServiceStatus() {
		return hostingServiceStatus;
	}

	public void setHostingServiceStatus(String hostingServiceStatus) {
		this.hostingServiceStatus = hostingServiceStatus;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getSpecName() {
		return specName;
	}

	public void setSpecName(String specName) {
		this.specName = specName;
	}

	public String getExpiredTimestamp() {
		return expiredTimestamp;
	}

	public void setExpiredTimestamp(String expiredTimestamp) {
		this.expiredTimestamp = expiredTimestamp;
	}

	public LocalHostingMachineInfo getHostingMachineInfo() {
		return hostingMachineInfo;
	}

	public void setHostingMachineInfo(LocalHostingMachineInfo hostingMachineInfo) {
		this.hostingMachineInfo = hostingMachineInfo;
	}

	public List<LocalOrder> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<LocalOrder> orderList) {
		this.orderList = orderList;
	}

	public ReleaseHostingDescription getReleaseHostingDescription() {
		return releaseHostingDescription;
	}

	public void setReleaseHostingDescription(ReleaseHostingDescription releaseHostingDescription) {
		this.releaseHostingDescription = releaseHostingDescription;
	}
}
