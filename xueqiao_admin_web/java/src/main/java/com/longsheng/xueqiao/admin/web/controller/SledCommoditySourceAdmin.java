package com.longsheng.xueqiao.admin.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.apache.thrift.TException;
import org.soldier.base.StringFactory;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.page.IndexedPageOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.web_framework.model.ErrorResult;
import org.soldier.platform.web_framework.util.GsonFactory;

import com.longsheng.xueqiao.admin.bean.LocalCommoditySource;
import com.longsheng.xueqiao.admin.bean.LocalSledExchange;
import com.longsheng.xueqiao.contract.standard.thriftapi.ReqSledExchangeOption;
import com.longsheng.xueqiao.contract.standard.thriftapi.SledExchangePage;
import com.longsheng.xueqiao.contract.thriftapi.CommoditySource;
import com.longsheng.xueqiao.contract.thriftapi.CommoditySourcePage;
import com.longsheng.xueqiao.contract.thriftapi.ReqCommoditySourceOption;
import com.longsheng.xueqiao.contract.thriftapi.client.ContractServiceStub;

public class SledCommoditySourceAdmin extends OaAuthController {
	private static final int PAGE_SIZE = 10;
	private static final int PAGE_SIZE_MAX = Integer.MAX_VALUE;
	
	ContractServiceStub mContractServiceStub = new ContractServiceStub();
	
	public void show() throws Exception {
		
		queryCommoditySourceList();
		getExchangeList();

		if (mContractServiceStub == null) {
			mContractServiceStub = new ContractServiceStub();
		}
		put("sledTradeTimeList", null);
		
		render("sled_commodity_source_admin.html");
	}
	
	private void queryCommoditySourceList() throws ErrorInfo, TException {
		
		if (mContractServiceStub == null) {
			mContractServiceStub = new ContractServiceStub();
		}
		
		ReqCommoditySourceOption reqCommoditySourceOption = new ReqCommoditySourceOption();
		IndexedPageOption indexedPageOption = new IndexedPageOption();
		indexedPageOption.setPageIndex(0);
		indexedPageOption.setPageSize(PAGE_SIZE_MAX);
		reqCommoditySourceOption.setPageOption(indexedPageOption);
		CommoditySourcePage commoditySourcePage = mContractServiceStub.reqCommoditySource(reqCommoditySourceOption);
		
		List<LocalCommoditySource> localCommoditySourceList = new ArrayList<LocalCommoditySource>();
		
		if (commoditySourcePage.getPageSize() > 0) {
			for (CommoditySource commoditySource : commoditySourcePage.getPage()) {
				LocalCommoditySource localCommoditySource = new LocalCommoditySource();
				
				localCommoditySource.setSourceId(commoditySource.getSourceId());
				if (commoditySource.getExchangeMic() != null && !commoditySource.getExchangeMic().isEmpty()) {
					localCommoditySource.setExchangeMicList(commoditySource.getExchangeMic());
				}
				localCommoditySource.setTechPlatformSource(commoditySource.getTechPlatformSource().name());
				localCommoditySource.setTechPlatformEnv(commoditySource.getTechPlatformEnv().name());
				
				localCommoditySourceList.add(localCommoditySource);
			}
		}
		
		put("sledCommoditySourceList", localCommoditySourceList);
		
	}
	
	public void getExchangeList() throws IOException {
		ErrorResult result = new ErrorResult();
		
		if (mContractServiceStub == null) {
			mContractServiceStub = new ContractServiceStub();
		}
		
		ReqSledExchangeOption reqSledExchangeOption = new ReqSledExchangeOption();
		
		SledExchangePage sledExchangePage = null;
		
		try {
			sledExchangePage = mContractServiceStub.reqSledExchange(reqSledExchangeOption, 0, PAGE_SIZE_MAX);
		} catch(ErrorInfo errorInfo) {
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
		put("sledExchangeList", LocalSledExchange.transferToLocalExchangeList(sledExchangePage.getPage()));
		
	}
	
	public void getCommoditySourceDialogInfo() throws IOException {
		ErrorResult result = new ErrorResult();
		int sourceId = parameter("sourceId", -1);
		
		ReqCommoditySourceOption reqCommoditySourceOption = new ReqCommoditySourceOption();
		IndexedPageOption indexedPageOption = new IndexedPageOption();
		indexedPageOption.setPageIndex(0);
		indexedPageOption.setPageSize(PAGE_SIZE_MAX);
		reqCommoditySourceOption.setPageOption(indexedPageOption);
		
		Set<Integer> sourceIds = new HashSet<Integer>();
		sourceIds.add(sourceId);
		reqCommoditySourceOption.setSourceIds(sourceIds);
		CommoditySourcePage commoditySourcePage = null;
		try {
			commoditySourcePage = mContractServiceStub.reqCommoditySource(reqCommoditySourceOption);
		} catch(ErrorInfo errorInfo) {
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
		
		if (commoditySourcePage != null && commoditySourcePage.getPageSize() > 0) {
			echoJson(commoditySourcePage.getPage().get(0).getExchangeMic());
			return;
		}
		result.setErrorCode(7);
		result.setErrorMsg("获取不到sourceId: " + sourceId + "对应的交易所信息");
		echoJson(commoditySourcePage.getPage().get(0).getExchangeMic());
	}

	public void updateCommoditySource() throws IOException {
		ErrorResult result = new ErrorResult();
		
		if (mContractServiceStub == null) {
			mContractServiceStub = new ContractServiceStub();
		}
		
		String content = StringFactory.newUtf8String(IOUtils.toByteArray(getServletRequest().getInputStream()));
		AppLog.i("SledCommoditySourceAdmin ---- updateCommoditySource ---- content : " + content);
		
		LocalCommoditySource localCommoditySource = GsonFactory.getGson().fromJson(content, LocalCommoditySource.class);
		if (localCommoditySource == null) {
			result.setErrorCode(5);
			result.setErrorMsg("接收交易所列表信息失败");
			echoJson(result);
			return;
		}
		try {
			CommoditySource commoditySource = new CommoditySource();
			commoditySource.setSourceId(localCommoditySource.getSourceId());
			commoditySource.setExchangeMic(localCommoditySource.getExchangeMicList());
			mContractServiceStub.updateCommoditySource(commoditySource);
		} catch(ErrorInfo errorInfo) {
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
		echoJson(result);
	}
}
