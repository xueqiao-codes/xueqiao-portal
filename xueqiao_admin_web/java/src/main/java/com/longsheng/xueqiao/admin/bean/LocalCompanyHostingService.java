package com.longsheng.xueqiao.admin.bean;

import java.util.List;

public class LocalCompanyHostingService {

	private int companyId;
	private List<LocalCompanyHostingServiceGroup> hostingServiceGroupList;

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public List<LocalCompanyHostingServiceGroup> getHostingServiceGroupList() {
		return hostingServiceGroupList;
	}

	public void setHostingServiceGroupList(List<LocalCompanyHostingServiceGroup> hostingServiceGroupList) {
		this.hostingServiceGroupList = hostingServiceGroupList;
	}
}
