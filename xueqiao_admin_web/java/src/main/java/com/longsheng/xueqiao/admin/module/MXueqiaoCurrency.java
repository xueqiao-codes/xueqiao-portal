package com.longsheng.xueqiao.admin.module;

import java.util.HashMap;
import java.util.Map;

import org.apache.thrift.TException;
import org.soldier.platform.page.IndexedPageOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import com.longsheng.xueqiao.currency.dao.thriftapi.client.CurrencyDaoStub;
import com.longsheng.xueqiao.currency.thriftapi.Currency;
import com.longsheng.xueqiao.currency.thriftapi.CurrencyPage;
import com.longsheng.xueqiao.currency.thriftapi.ExchangeRate;
import com.longsheng.xueqiao.currency.thriftapi.ExchangeRatePage;
import com.longsheng.xueqiao.currency.thriftapi.ReqCurrencyOption;
import com.longsheng.xueqiao.currency.thriftapi.ReqExchangeRateOption;

public class MXueqiaoCurrency {
	private static MXueqiaoCurrency mInstance;

	private CurrencyDaoStub mCurrencyDaoStub;

	private static Map<String, String> mTCurrencyCode = new HashMap<String, String>();
	
	static {
		mTCurrencyCode.put("USD", "美元");
		mTCurrencyCode.put("CNY", "人民币");
		mTCurrencyCode.put("EUR", "欧元");
		mTCurrencyCode.put("GBP", "英镑");
		mTCurrencyCode.put("HKD", "港币");
		mTCurrencyCode.put("JPY", "日元");
		mTCurrencyCode.put("KRW", "韩元");
		mTCurrencyCode.put("MYR", "马来西亚林吉特");
		mTCurrencyCode.put("SGD", "新加坡元");
		mTCurrencyCode.put("THB", "泰铢");
		mTCurrencyCode.put("AUD", "澳元");
		mTCurrencyCode.put("CAD", "加元");
		mTCurrencyCode.put("CHF", "瑞士法郎");
		mTCurrencyCode.put("CNH", "离岸人民币");
	}
	
	public static MXueqiaoCurrency getInstance() {
		if (mInstance == null) {
			mInstance = new MXueqiaoCurrency();
		}
		return mInstance;
	}
	
	public static Map<String, String> getCurrencyMap() {
		return mTCurrencyCode;
	}

	private MXueqiaoCurrency() {
		mCurrencyDaoStub = new CurrencyDaoStub();
	}

	public CurrencyPage queryCurrencyList(int pageIndex, int pageSize) throws ErrorInfo, TException {

		ReqCurrencyOption currencyOption = new ReqCurrencyOption();
		
		IndexedPageOption pageOption = new IndexedPageOption();
		pageOption.setNeedTotalCount(true);
		pageOption.setPageIndex(pageIndex);
		pageOption.setPageSize(pageSize);

		return mCurrencyDaoStub.reqCurrency(currencyOption, pageOption);
	}
	
	public CurrencyPage queryCurrencyList(boolean isBaseCurrency, int pageIndex, int pageSize) throws ErrorInfo, TException {

		ReqCurrencyOption currencyOption = new ReqCurrencyOption();
		currencyOption.setIsBaseCurrency(isBaseCurrency);
		
		IndexedPageOption pageOption = new IndexedPageOption();
		pageOption.setNeedTotalCount(true);
		pageOption.setPageIndex(pageIndex);
		pageOption.setPageSize(pageSize);

		return mCurrencyDaoStub.reqCurrency(currencyOption, pageOption);
	}
	
	public void addCurrency(Currency newCurrency) throws ErrorInfo, TException {
		mCurrencyDaoStub.addCurrency(newCurrency);
	}
	
	public void modifyCurrency(Currency modifyCurrency) throws ErrorInfo, TException {
		mCurrencyDaoStub.updateCurrency(modifyCurrency);
	}
	
	public ExchangeRatePage queryExchangeRateList() throws ErrorInfo, TException {
		ReqExchangeRateOption exchangeRateOption = new ReqExchangeRateOption();
		
		IndexedPageOption pageOption = new IndexedPageOption();
		pageOption.setPageIndex(0);
		pageOption.setPageSize(MXueqiaoConfig.PAGE_SIZE_MAX);
		
		return mCurrencyDaoStub.reqExchangeRate(exchangeRateOption, pageOption);
	}
	
	public void modifyExchangeRate(ExchangeRate modifyExchangeRate) throws ErrorInfo, TException {
		mCurrencyDaoStub.updateExchangeRateValue(modifyExchangeRate);
	}

	public void syncExchangeRateToOnline() throws TException {
		mCurrencyDaoStub.syncExchangeRateToOnline();
	}
}
