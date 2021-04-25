package com.longsheng.xueqiao.admin.bean;

import java.util.List;

public class LocalOrderPage {

	List<LocalOrder> orderList;
	private int totalNum;
	private int totalPage;
	private int currentPage;

	public List<LocalOrder> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<LocalOrder> orderList) {
		this.orderList = orderList;
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
