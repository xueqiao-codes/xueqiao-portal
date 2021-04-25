package com.longsheng.xueqiao.admin.bean;

import java.util.List;

public class LocalCompanyPage {

	List<LocalCompany> companyList;
	private int totalNum;
	private int totalPage;
	private int currentPage;

	public List<LocalCompany> getLocalCompanyList() {
		return companyList;
	}

	public void setLocalCompanyList(List<LocalCompany> localCompanyList) {
		this.companyList = localCompanyList;
	}

	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

}
