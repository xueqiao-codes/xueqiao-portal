package com.longsheng.xueqiao.admin.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.thrift.TException;
import org.soldier.base.StringFactory;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.web_framework.model.ErrorResult;
import org.soldier.platform.web_framework.util.GsonFactory;

import com.longsheng.xueqiao.admin.bean.LocalCurrencyPage;
import com.longsheng.xueqiao.admin.bean.LocalExchangeRatePage;
import com.longsheng.xueqiao.admin.module.MXueqiaoConfig;
import com.longsheng.xueqiao.admin.module.MXueqiaoCurrency;
import com.longsheng.xueqiao.currency.thriftapi.Currency;
import com.longsheng.xueqiao.currency.thriftapi.CurrencyPage;
import com.longsheng.xueqiao.currency.thriftapi.ExchangeRate;
import com.longsheng.xueqiao.currency.thriftapi.ExchangeRatePage;

public class SledCurrencyAdmin extends OaAuthController {

	public void show() throws Exception {
		render("sled_currency_admin.html");
	}

	public void querySledCurrencyList() throws IOException {
		ErrorResult result = new ErrorResult();

		int requestPage = parameter("requestPage", 1);

		CurrencyPage currencyPage = null;
		try {
			currencyPage = MXueqiaoCurrency.getInstance().queryCurrencyList(requestPage - 1, MXueqiaoConfig.PAGE_SIZE);

			if (currencyPage != null) {
				AppLog.i("SledCurrencyAdmin ---- querySledCurrencyList ---- productPage size : " + currencyPage.getPageSize());
				LocalCurrencyPage localCurrencyPage = new LocalCurrencyPage();

				localCurrencyPage.setCurrencyList(currencyPage.getPage());
				localCurrencyPage.setTotalNum(currencyPage.getTotal());
				localCurrencyPage.setTotalPage((currencyPage.getTotal() + MXueqiaoConfig.PAGE_SIZE - 1) / MXueqiaoConfig.PAGE_SIZE);
				localCurrencyPage.setCurrentPage(requestPage);

				echoJson(localCurrencyPage);
			} else {
				result.setErrorCode(5);
				result.setErrorMsg("查找货币失败");
				echoJson(result);
			}
		} catch (ErrorInfo errorInfo) {
			errorInfo.printStackTrace();
			result.setErrorCode(errorInfo.getErrorCode());
			result.setErrorMsg(errorInfo.getErrorMsg());
			echoJson(result);
		} catch (Throwable e) {
			e.printStackTrace();
			result.setErrorCode(5);
			result.setErrorMsg("服务器繁忙");
			echoJson(result);
		}
	}

	public void querySledExchangeRateList() throws IOException {
		ErrorResult result = new ErrorResult();

		int requestPage = parameter("requestPage", 1);

		try {
			List<LocalExchangeRatePage> exchangeRatePageList = new ArrayList<LocalExchangeRatePage>();

			CurrencyPage currencyPage = MXueqiaoCurrency.getInstance().queryCurrencyList(true, requestPage - 1, MXueqiaoConfig.PAGE_SIZE);
			ExchangeRatePage exchangeRatePage = MXueqiaoCurrency.getInstance().queryExchangeRateList();

			if (currencyPage != null && currencyPage.getPageSize() > 0 && exchangeRatePage != null && exchangeRatePage.getPageSize() > 0) {
				AppLog.i("SledCurrencyAdmin ---- querySledExchangeRateList ---- productPage size : " + currencyPage.getPageSize());

				for (Currency currency : currencyPage.getPage()) {
					LocalExchangeRatePage localExchangeRatePage = new LocalExchangeRatePage();
					localExchangeRatePage.setBaseCurrencyName(MXueqiaoCurrency.getCurrencyMap().get(currency.getCurrencyCode()));
					List<ExchangeRate> exchangeList = new ArrayList<ExchangeRate>();
					for (ExchangeRate exchangeRate : exchangeRatePage.getPage()) {
						if (exchangeRate.getBaseCurrency().equals(currency.getCurrencyCode())) {
							exchangeList.add(exchangeRate);
						}
					}
					localExchangeRatePage.setExchangeList(exchangeList);
					exchangeRatePageList.add(localExchangeRatePage);
				}
			}
			echoJson(exchangeRatePageList);
		} catch (ErrorInfo errorInfo) {
			errorInfo.printStackTrace();
			result.setErrorCode(errorInfo.getErrorCode());
			result.setErrorMsg(errorInfo.getErrorMsg());
			echoJson(result);
		} catch (Throwable e) {
			e.printStackTrace();
			result.setErrorCode(5);
			result.setErrorMsg("服务器繁忙");
			echoJson(result);
		}
	}

	public void addNewCurrency() throws IOException {
		ErrorResult result = new ErrorResult();
		try {
			String content = StringFactory.newUtf8String(IOUtils.toByteArray(getServletRequest().getInputStream()));

			AppLog.i("SledCurrencyAdmin ---- addNewCurrency ---- content : " + content);

			Currency currency = GsonFactory.getGson().fromJson(content, Currency.class);
			if (currency != null) {
				Currency newCurrency = new Currency();
				newCurrency.setCurrencyCode(currency.getCurrencyCode());
				newCurrency.setCnName(MXueqiaoCurrency.getCurrencyMap().get(currency.getCurrencyCode()));
				newCurrency.setEnName(currency.getEnName());
				newCurrency.setSymbol(currency.getSymbol());
				newCurrency.setIsBaseCurrency(currency.isBaseCurrency);

				MXueqiaoCurrency.getInstance().addCurrency(newCurrency);
			} else {
				result.setErrorCode(6);
				result.setErrorMsg("货币信息为空，请检查是否填写错误");
				echoJson(result);
				return;
			}
		} catch (ErrorInfo errorInfo) {
			errorInfo.printStackTrace();
			result.setErrorCode(errorInfo.getErrorCode());
			result.setErrorMsg(errorInfo.getErrorMsg());
			echoJson(result);
			return;
		} catch (Throwable e) {
			e.printStackTrace();
			result.setErrorCode(5);
			result.setErrorMsg("服务器繁忙");
			echoJson(result);
			return;
		}
		echoJson("success");
	}

	public void modifyCurrency() throws IOException {
		ErrorResult result = new ErrorResult();
		try {
			String content = StringFactory.newUtf8String(IOUtils.toByteArray(getServletRequest().getInputStream()));

			AppLog.i("SledCurrencyAdmin ---- modifyCurrency ---- content : " + content);

			Currency currency = GsonFactory.getGson().fromJson(content, Currency.class);

			if (currency != null) {

				Currency modifyCurrency = new Currency();
				modifyCurrency.setCurrencyCode(currency.getCurrencyCode());
				modifyCurrency.setEnName(currency.getEnName());
				modifyCurrency.setSymbol(currency.getSymbol());
				modifyCurrency.setIsBaseCurrency(currency.isBaseCurrency);

				MXueqiaoCurrency.getInstance().modifyCurrency(modifyCurrency);
			} else {
				result.setErrorCode(6);
				result.setErrorMsg("货币信息为空，请检查是否填写错误");
				echoJson(result);
				return;
			}
		} catch (ErrorInfo errorInfo) {
			errorInfo.printStackTrace();
			result.setErrorCode(errorInfo.getErrorCode());
			result.setErrorMsg(errorInfo.getErrorMsg());
			echoJson(result);
			return;
		} catch (Throwable e) {
			e.printStackTrace();
			result.setErrorCode(5);
			result.setErrorMsg("服务器繁忙");
			echoJson(result);
			return;
		}
		echoJson("success");
	}

	public void modifyExchangeRate() throws IOException {
		ErrorResult result = new ErrorResult();
		try {
			String content = StringFactory.newUtf8String(IOUtils.toByteArray(getServletRequest().getInputStream()));

			AppLog.i("SledCurrencyAdmin ---- modifyExchangeRate ---- content : " + content);

			ExchangeRate exchangeRate = GsonFactory.getGson().fromJson(content, ExchangeRate.class);

			if (exchangeRate != null) {
				ExchangeRate modifyExchangeRate = new ExchangeRate();
				modifyExchangeRate.setBaseCurrency(exchangeRate.getBaseCurrency());
				modifyExchangeRate.setTargetCurrency(exchangeRate.getTargetCurrency());
				modifyExchangeRate.setExchangeRate(exchangeRate.getExchangeRate());
				MXueqiaoCurrency.getInstance().modifyExchangeRate(modifyExchangeRate);
			} else {
				result.setErrorCode(6);
				result.setErrorMsg("货币信息为空，请检查是否填写错误");
				echoJson(result);
				return;
			}
		} catch (ErrorInfo errorInfo) {
			errorInfo.printStackTrace();
			result.setErrorCode(errorInfo.getErrorCode());
			result.setErrorMsg(errorInfo.getErrorMsg());
			echoJson(result);
			return;
		} catch (Throwable e) {
			e.printStackTrace();
			result.setErrorCode(5);
			result.setErrorMsg("服务器繁忙");
			echoJson(result);
			return;
		}
		echoJson("success");
	}

	/**
	 * ajax 接口
	 * 同步到 zookeeper 线上环境
	 */
	public void syncExchangeRateToOnline() throws IOException {

		AppLog.i("SledCurrencyAdmin ---- syncExchangeRateToOnline");

		ErrorResult result = new ErrorResult();
		try {
			MXueqiaoCurrency.getInstance().syncExchangeRateToOnline();
		} catch (ErrorInfo errorInfo) {
			errorInfo.printStackTrace();
			result.setErrorCode(errorInfo.getErrorCode());
			result.setErrorMsg(errorInfo.getErrorMsg());
			echoJson(result);
			return;
		} catch (Throwable e) {
			e.printStackTrace();
			result.setErrorCode(5);
			result.setErrorMsg("服务器繁忙");
			echoJson(result);
			return;
		}
	}
}
