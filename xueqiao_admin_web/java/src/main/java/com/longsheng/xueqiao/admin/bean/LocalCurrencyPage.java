package com.longsheng.xueqiao.admin.bean;

import java.util.List;

import com.longsheng.xueqiao.currency.thriftapi.Currency;

public class LocalCurrencyPage {
	private List<Currency> currencyList;
	private int totalNum;
	private int totalPage;
	private int currentPage;

	public List<Currency> getCurrencyList() {
		return currencyList;
	}

	public void setCurrencyList(List<Currency> currencyList) {
		this.currencyList = currencyList;
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
