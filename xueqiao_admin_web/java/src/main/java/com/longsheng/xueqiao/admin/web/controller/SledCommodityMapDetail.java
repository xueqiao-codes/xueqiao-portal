package com.longsheng.xueqiao.admin.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

import com.longsheng.xueqiao.admin.bean.LocalCommodityMappingInfo;
import com.longsheng.xueqiao.contract.standard.thriftapi.CommodityMapping;
import com.longsheng.xueqiao.contract.standard.thriftapi.ReqSledCommodityOption;
import com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodity;
import com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatform;
import com.longsheng.xueqiao.contract.thriftapi.CommodityMappingEdit;
import com.longsheng.xueqiao.contract.thriftapi.CommodityMappingEditPage;
import com.longsheng.xueqiao.contract.thriftapi.ReqCommodityMappingEditOption;
import com.longsheng.xueqiao.contract.thriftapi.SledCommodityEdit;
import com.longsheng.xueqiao.contract.thriftapi.SledCommodityEditPage;
import com.longsheng.xueqiao.contract.thriftapi.client.ContractServiceStub;

public class SledCommodityMapDetail extends OaAuthController {

	private static final int TIME_OUT = 3000;
	private static final int PAGE_SIZE = 10;
	private static final int PAGE_SIZE_MAX = Integer.MAX_VALUE;
	
	ContractServiceStub mContractServiceStub = new ContractServiceStub();
	
	private int mTotalPage = 1;
	private int mTotalNum = 0;

	public void show() throws Exception {

		int requestPage = parameter("requestPage", 1);
		int brokerEntryId = parameter("brokerEntryId", 0);
		String brokerCnName = parameter("brokerCnName", "");
//		int brokerId = parameter("brokerId", 0);
		String platform = parameter("platform", "");

		if (requestPage < 1) {
			requestPage = 1;
		}
//		if (sledCommodityId <= 0) {
//			return;
//		}

		List<LocalCommodityMappingInfo> LocalCommodityMappingInfoList = queryCommodityMappingInfo(brokerEntryId, requestPage);
		
		setBaseQueryUrl(brokerEntryId, brokerCnName);
//
//		put("exchangeMic", exchangeMic);
		if (mTotalPage < 1) {
			mTotalPage = 1;
		}
		put("totalPage", mTotalPage);
		put("totalNum", mTotalNum);
		put("brokerCnName", brokerCnName);
		put("brokerId", brokerEntryId);
		put("platform", platform);
		put("currentPage", requestPage);
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
	
	private CommodityMappingEditPage queryCommodityMappingByPlatform(int brokerEntryId, TechPlatform techPlatform) throws ErrorInfo, TException {
		
		ReqCommodityMappingEditOption reqCommodityMappingEditOption = new ReqCommodityMappingEditOption();
		reqCommodityMappingEditOption.setBrokerEntryId(brokerEntryId);
		reqCommodityMappingEditOption.setTechPlatform(techPlatform);
		
		if (mContractServiceStub == null) {
			mContractServiceStub = new ContractServiceStub();
		}
		
		CommodityMappingEditPage commodityMappingEditPage = mContractServiceStub.reqCommodityMapping(reqCommodityMappingEditOption, 0, PAGE_SIZE_MAX);
		return commodityMappingEditPage;
	}
	
	private SledCommodityEditPage querySledCommodity(List<Integer> sledCommodityIdList) throws ErrorInfo, TException {
		
		ReqSledCommodityOption reqSledCommodityOption = new ReqSledCommodityOption();
		reqSledCommodityOption.setSledCommodityIdList(sledCommodityIdList);
		
		if (mContractServiceStub == null) {
			mContractServiceStub = new ContractServiceStub();
		}
		SledCommodityEditPage sledCommodityEditPage = mContractServiceStub.reqSledCommodity(reqSledCommodityOption, 0, PAGE_SIZE_MAX);
		return sledCommodityEditPage;
	}
	
	private List<LocalCommodityMappingInfo> queryCommodityMappingInfo(int brokerEntryId, int pageIndex) throws ErrorInfo, TException {
		CommodityMappingEditPage es3CommodityMappingEditPage = queryCommodityMappingByPlatform(brokerEntryId, TechPlatform.ESUNNY_3);
		CommodityMappingEditPage es9CommodityMappingEditPage = queryCommodityMappingByPlatform(brokerEntryId, TechPlatform.ESUNNY);
		
		Map<Integer, CommodityMapping> es3commodityMap = new HashMap<Integer, CommodityMapping>();
		Map<Integer, CommodityMapping> es9commodityMap = new HashMap<Integer, CommodityMapping>();
		Map<Integer, SledCommodity> sledCommodityMap = new HashMap<Integer, SledCommodity>();
		List<Integer> sledCommodityIdList = new ArrayList<Integer>();
		
		List<LocalCommodityMappingInfo> LocalCommodityMappingInfoList = new ArrayList<LocalCommodityMappingInfo>();
		
		//ES3
		for (CommodityMappingEdit commodityMappingEdit : es3CommodityMappingEditPage.getPage()) {
			sledCommodityIdList.add(commodityMappingEdit.getCommodityMapping().getSledCommodityId());
			es3commodityMap.put(commodityMappingEdit.getCommodityMapping().getSledCommodityId(), commodityMappingEdit.getCommodityMapping());
		}
		
		//ES9
		for (CommodityMappingEdit commodityMappingEdit : es9CommodityMappingEditPage.getPage()) {
			es9commodityMap.put(commodityMappingEdit.getCommodityMapping().getSledCommodityId(), commodityMappingEdit.getCommodityMapping());
		}
		
		//Sled
		SledCommodityEditPage sledCommodityEditPage = querySledCommodity(sledCommodityIdList);
		for (SledCommodityEdit sledCommodityEdit : sledCommodityEditPage.getPage()) {
			sledCommodityMap.put(sledCommodityEdit.getSledCommodity().getSledCommodityId(), sledCommodityEdit.getSledCommodity());
		}
		
		//page
		mTotalNum = es3CommodityMappingEditPage.getTotal();
		mTotalPage = (es3CommodityMappingEditPage.getTotal() + PAGE_SIZE - 1) / PAGE_SIZE;
		AppLog.i("SledCommodityMapDetail ---- queryCommodityMappingInfo ---- pageIndex : " + pageIndex + ", mTotalPage : " + mTotalPage + ", es3CommodityMappingEditPage : " + es3CommodityMappingEditPage.getPageSize());
		if (pageIndex <= mTotalPage) {
			for (int index = (pageIndex - 1) * PAGE_SIZE; index < pageIndex * PAGE_SIZE; index++) {
				if (index < es3CommodityMappingEditPage.getTotal()) {
					int key = es3CommodityMappingEditPage.getPage().get(index).getCommodityMapping().getSledCommodityId();
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
