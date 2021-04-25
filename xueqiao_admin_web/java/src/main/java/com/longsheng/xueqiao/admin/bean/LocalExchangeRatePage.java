package com.longsheng.xueqiao.admin.bean;

import java.util.List;

import com.longsheng.xueqiao.currency.thriftapi.ExchangeRate;

public class LocalExchangeRatePage {

	private String baseCurrencyName;
	private List<ExchangeRate> exchangeList;

	public String getBaseCurrencyName() {
		return baseCurrencyName;
	}

	public void setBaseCurrencyName(String baseCurrencyName) {
		this.baseCurrencyName = baseCurrencyName;
	}

	public List<ExchangeRate> getExchangeList() {
		return exchangeList;
	}

	public void setExchangeList(List<ExchangeRate> exchangeList) {
		this.exchangeList = exchangeList;
	}
}
