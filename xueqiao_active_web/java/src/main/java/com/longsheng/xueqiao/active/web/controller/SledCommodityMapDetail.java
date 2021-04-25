package com.longsheng.xueqiao.active.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

import com.longsheng.xueqiao.active.bean.LocalCommodityMappingInfo;
import com.longsheng.xueqiao.contract.online.dao.thriftapi.client.ContractOnlineDaoServiceStub;
import com.longsheng.xueqiao.contract.standard.thriftapi.CommodityMapping;
import com.longsheng.xueqiao.contract.standard.thriftapi.CommodityMappingPage;
import com.longsheng.xueqiao.contract.standard.thriftapi.ReqCommodityMappingOption;
import com.longsheng.xueqiao.contract.standard.thriftapi.ReqSledCommodityOption;
import com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodity;
import com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodityPage;
import com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatform;

public class SledCommodityMapDetail extends OaAuthController {

	private static final int TIME_OUT = 3000;
	private static final int PAGE_SIZE = 10;
	private static final int PAGE_SIZE_MAX = Integer.MAX_VALUE;
	
	private ContractOnlineDaoServiceStub mContractOnlineDaoService = new ContractOnlineDaoServiceStub();
	
	private int mTotalPage = 1;

	public void show() throws Exception {

		int requestPage = parameter("requestPage", 1);
		int brokerEntryId = parameter("brokerEntryId", 0);
		String brokerCnName = parameter("brokerCnName", "");

		if (requestPage < 1) {
			requestPage = 1;
		}

		List<LocalCommodityMappingInfo> LocalCommodityMappingInfoList = queryCommodityMappingInfo(brokerEntryId, requestPage);
		
		setBaseQueryUrl(brokerEntryId, brokerCnName);

		if (mTotalPage < 1) {
			mTotalPage = 1;
		}
		put("totalPage", mTotalPage);
		put("currentPage", requestPage);
		put("brokerCnName", brokerCnName);
		put("commodityMappingInfoList", LocalCommodityMappingInfoList);
		
		render("sled_commodity_map_detail.html");
	}
	
	private void setBaseQueryUrl(int brokerEntryId, String brokerCnName) {
		StringBuffer baseQueryUrl = new StringBuffer();
		String baseUrl = this.baseUrl;
		int l = baseUrl.indexOf("requestPage");
		if (l > 0) {
			baseUrl = baseUrl.substring(0, l);
		}
		baseQueryUrl.append(baseUrl);
		baseQueryUrl.append("/SledCommodityMapDetail/show?brokerEntryId=" + brokerEntryId + "&brokerCnName=" + brokerCnName + "&");
		put("baseQueryUrl", baseQueryUrl);
	}
	
	private CommodityMappingPage queryCommodityMappingByPlatform(int brokerEntryId, TechPlatform techPlatform) throws ErrorInfo, TException {
		
		ReqCommodityMappingOption reqCommodityMappingEditOption = new ReqCommodityMappingOption();
		reqCommodityMappingEditOption.setBrokerEntryId(brokerEntryId);
		reqCommodityMappingEditOption.setTechPlatform(techPlatform);
		
		if (mContractOnlineDaoService == null) {
			mContractOnlineDaoService = new ContractOnlineDaoServiceStub();
		}
		
		CommodityMappingPage commodityMappingPage = mContractOnlineDaoService.reqCommodityMapping(reqCommodityMappingEditOption, 0, PAGE_SIZE_MAX);
		return commodityMappingPage;
	}
	
	private SledCommodityPage querySledCommodity(List<Integer> sledCommodityIdList) throws ErrorInfo, TException {
		
		ReqSledCommodityOption reqSledCommodityOption = new ReqSledCommodityOption();
		reqSledCommodityOption.setSledCommodityIdList(sledCommodityIdList);
		
		if (mContractOnlineDaoService == null) {
			mContractOnlineDaoService = new ContractOnlineDaoServiceStub();
		}
		SledCommodityPage sledCommodityPage = mContractOnlineDaoService.reqSledCommodity(reqSledCommodityOption, 0, PAGE_SIZE_MAX);
		return sledCommodityPage;
	}
	
	private List<LocalCommodityMappingInfo> queryCommodityMappingInfo(int brokerEntryId, int pageIndex) throws ErrorInfo, TException {
		CommodityMappingPage es3CommodityMappingPage = queryCommodityMappingByPlatform(brokerEntryId, TechPlatform.ESUNNY_3);
		CommodityMappingPage es9CommodityMappingPage = queryCommodityMappingByPlatform(brokerEntryId, TechPlatform.ESUNNY);
		
		Map<Integer, CommodityMapping> es3commodityMap = new HashMap<Integer, CommodityMapping>();
		Map<Integer, CommodityMapping> es9commodityMap = new HashMap<Integer, CommodityMapping>();
		Map<Integer, SledCommodity> sledCommodityMap = new HashMap<Integer, SledCommodity>();
		List<Integer> sledCommodityIdList = new ArrayList<Integer>();
		
		List<LocalCommodityMappingInfo> LocalCommodityMappingInfoList = new ArrayList<LocalCommodityMappingInfo>();
		
		//ES3
		for (CommodityMapping commodityMapping : es3CommodityMappingPage.getPage()) {
			sledCommodityIdList.add(commodityMapping.getSledCommodityId());
			es3commodityMap.put(commodityMapping.getSledCommodityId(), commodityMapping);
		}
		
		//ES9
		for (CommodityMapping commodityMapping : es9CommodityMappingPage.getPage()) {
			es9commodityMap.put(commodityMapping.getSledCommodityId(), commodityMapping);
		}
		
		//Sled
		SledCommodityPage sledCommodityPage = querySledCommodity(sledCommodityIdList);
		for (SledCommodity sledCommodity : sledCommodityPage.getPage()) {
			sledCommodityMap.put(sledCommodity.getSledCommodityId(), sledCommodity);
		}
		
		//page
		mTotalPage = (es3CommodityMappingPage.getTotal() + PAGE_SIZE - 1) / PAGE_SIZE;
		AppLog.i("SledCommodityMapDetail ---- queryCommodityMappingInfo ---- pageIndex : " + pageIndex + ", mTotalPage : " + mTotalPage + ", es3CommodityMappingPage : " + es3CommodityMappingPage.getPageSize());
		if (pageIndex <= mTotalPage) {
			for (int index = (pageIndex - 1) * PAGE_SIZE; index < pageIndex * PAGE_SIZE; index++) {
				if (index < es3CommodityMappingPage.getTotal()) {
					int key = es3CommodityMappingPage.getPage().get(index).getSledCommodityId();
					LocalCommodityMappingInfo localCommodityMappingInfo = new LocalCommodityMappingInfo();
					//es3
					CommodityMapping es3CommodityMapping = es3commodityMap.get(key);
					if (es3CommodityMapping != null) {
						localCommodityMappingInfo.setEs3Exchange(es3CommodityMapping.getExchange());
						localCommodityMappingInfo.setEs3CommodityCode(es3CommodityMapping.getCommodityCode());
						localCommodityMappingInfo.setEs3CommodityType(es3CommodityMapping.getCommodityType());
						localCommodityMappingInfo.setEs3MoneyRatio(String.valueOf(es3CommodityMapping.getMoneyRatio()));
					}
					//es9
					CommodityMapping es9CommodityMapping = es9commodityMap.get(key);
					if (es9CommodityMapping != null) {
						localCommodityMappingInfo.setEs9Exchange(es9CommodityMapping.getExchange());
						localCommodityMappingInfo.setEs9CommodityCode(es9CommodityMapping.getCommodityCode());
						localCommodityMappingInfo.setEs9CommodityType(es9CommodityMapping.getCommodityType());
						localCommodityMappingInfo.setEs9MoneyRatio(String.valueOf(es9CommodityMapping.getMoneyRatio()));
					}
					//sled
					SledCommodity sledCommodity = sledCommodityMap.get(key);
					if (sledCommodity != null) {
						localCommodityMappingInfo.setSledExchangeMic(sledCommodity.getExchangeMic());
						localCommodityMappingInfo.setSledCommodityCode(sledCommodity.getSledCommodityCode());
						localCommodityMappingInfo.setSledCommodityType(sledCommodity.getSledCommodityType().name());
					}
					
					LocalCommodityMappingInfoList.add(localCommodityMappingInfo);
				}
			}
		}
		return LocalCommodityMappingInfoList;
	}

}
