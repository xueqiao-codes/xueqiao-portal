package com.longsheng.xueqiao.admin.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

import com.longsheng.xueqiao.admin.bean.LocalGeneralCommodityMappingInfo;
import com.longsheng.xueqiao.contract.standard.thriftapi.CommodityMapping;
import com.longsheng.xueqiao.contract.standard.thriftapi.ReqSledCommodityOption;
import com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodity;
import com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodityType;
import com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatform;
import com.longsheng.xueqiao.contract.thriftapi.CommodityMappingEdit;
import com.longsheng.xueqiao.contract.thriftapi.CommodityMappingEditPage;
import com.longsheng.xueqiao.contract.thriftapi.ReqCommodityMappingEditOption;
import com.longsheng.xueqiao.contract.thriftapi.SledCommodityEdit;
import com.longsheng.xueqiao.contract.thriftapi.SledCommodityEditPage;
import com.longsheng.xueqiao.contract.thriftapi.client.ContractServiceStub;

public class GeneralCommodityMapDetail extends OaAuthController {

	private static final int TIME_OUT = 3000;
	private static final int PAGE_SIZE = 10;
	private static final int PAGE_SIZE_MAX = Integer.MAX_VALUE;
	
	ContractServiceStub mContractServiceStub = new ContractServiceStub();
	
	private int mTotalPage = 1;
	private int mTotalNum = 0;

	public void show() throws Exception {

		int requestPage = parameter("requestPage", 1);
		String platform = parameter("platform", "");
		
		// filter
		String sledExchangeMic = parameter("sledExchangeMic", "");
		String sledCommodityType = parameter("sledCommodityType", "");
		String sledCommodityCode = parameter("sledCommodityCode", "");
		String mappingExchange = parameter("mappingExchange", "");
		String mappingCommodityCode = parameter("mappingCommodityCode", "");
		
		AppLog.i("GeneralCommodityMapDetail ---- show ---- requestPage : " + requestPage + ", platform : " + platform + ", sledExchangeMic : " + sledExchangeMic
				+ ", sledCommodityType : " + sledCommodityType + ", sledCommodityCode : " + sledCommodityCode + ", mappingExchange : " + mappingExchange
				+ ", mappingCommodityCode : " + mappingCommodityCode);
		
		if (platform == null || platform.isEmpty()) {
			return;
		}
		
		if (requestPage < 1) {
			requestPage = 1;
		}

		List<LocalGeneralCommodityMappingInfo> localGeneralCommodityMappingInfoList = queryCommodityMappingInfo(requestPage, TechPlatform.valueOf(platform), sledExchangeMic, sledCommodityType, sledCommodityCode, mappingExchange, mappingCommodityCode);
		
		setBaseQueryUrl(platform, sledExchangeMic, sledCommodityType, sledCommodityCode, mappingExchange, mappingCommodityCode);

		if (mTotalPage < 1) {
			mTotalPage = 1;
		}
		put("totalPage", mTotalPage);
		put("totalNum", mTotalNum);
		put("platform", platform);
		put("currentPage", requestPage);

		put("sledExchangeMic", sledExchangeMic);
		put("sledCommodityType", sledCommodityType);
		put("sledCommodityCode", sledCommodityCode);
		put("mappingExchange", mappingExchange);
		put("mappingCommodityCode", mappingCommodityCode);

		put("commodityMappingInfoList", localGeneralCommodityMappingInfoList);
		
		render("general_commodity_map_detail.html");
	}
	
	private void setBaseQueryUrl(String platform, String sledExchangeMic, String sledCommodityType, String sledCommodityCode, String mappingExchange, String mappingCommodityCode) {
		StringBuffer baseQueryUrl = new StringBuffer();
		String baseUrl = this.baseUrl;
		int l = baseUrl.indexOf("requestPage");
		if (l > 0) {
			baseUrl = baseUrl.substring(0, l);
		}
		baseQueryUrl.append(baseUrl);
		baseQueryUrl.append("/GeneralCommodityMapDetail/show?platform=").append(platform);
		baseQueryUrl.append("&sledExchangeMic=").append(sledExchangeMic);
		baseQueryUrl.append("&sledCommodityType=").append(sledCommodityType);
		baseQueryUrl.append("&sledCommodityCode=").append(sledCommodityCode);
		baseQueryUrl.append("&mappingExchange=").append(mappingExchange);
		baseQueryUrl.append("&mappingCommodityCode=").append(mappingCommodityCode);
		baseQueryUrl.append("&");
		put("baseQueryUrl", baseQueryUrl);
	}
	
	private CommodityMappingEditPage queryCommodityMappingByPlatform(TechPlatform techPlatform, List<Integer> sledCommodityIdList, String mappingExchange, String mappingCommodityCode) throws ErrorInfo, TException {
		
		ReqCommodityMappingEditOption reqCommodityMappingEditOption = new ReqCommodityMappingEditOption();
		reqCommodityMappingEditOption.setTechPlatform(techPlatform);
		
		//filter
//		if (sledCommodityIdList != null && !sledCommodityIdList.isEmpty()) {
			reqCommodityMappingEditOption.setSledCommodityIdList(sledCommodityIdList);
//		}
		if (mappingExchange != null && !mappingExchange.isEmpty()) {
			reqCommodityMappingEditOption.setExchange(mappingExchange);
		}
		if (mappingCommodityCode != null && !mappingCommodityCode.isEmpty()) {
			reqCommodityMappingEditOption.setCommodityCode(mappingCommodityCode);
		}
		
		if (mContractServiceStub == null) {
			mContractServiceStub = new ContractServiceStub();
		}
		
		CommodityMappingEditPage commodityMappingEditPage = mContractServiceStub.reqCommodityMapping(reqCommodityMappingEditOption, 0, PAGE_SIZE_MAX);
		return commodityMappingEditPage;
	}
	
	private SledCommodityEditPage querySledCommodity(String sledExchangeMic, String sledCommodityType, String sledCommodityCode/*List<Integer> sledCommodityIdList*/) throws ErrorInfo, TException {
		
		ReqSledCommodityOption reqSledCommodityOption = new ReqSledCommodityOption();
//		reqSledCommodityOption.setSledCommodityIdList(sledCommodityIdList);
		
		// filter
		if (sledExchangeMic != null && !sledExchangeMic.isEmpty()) {
			reqSledCommodityOption.setExchangeMic(sledExchangeMic);
		}
		if (sledCommodityType != null && !sledCommodityType.isEmpty()) {
			reqSledCommodityOption.setSledCommodityType(SledCommodityType.valueOf(sledCommodityType));
		}
		if (sledCommodityCode != null && !sledCommodityCode.isEmpty()) {
//			reqSledCommodityOption.setSledCommodityCode(sledCommodityCode);
			reqSledCommodityOption.setSledCommodityCodePartical(sledCommodityCode);
		}
		
		if (mContractServiceStub == null) {
			mContractServiceStub = new ContractServiceStub();
		}
		SledCommodityEditPage sledCommodityEditPage = mContractServiceStub.reqSledCommodity(reqSledCommodityOption, 0, PAGE_SIZE_MAX);
		AppLog.i("GeneralCommodityMapDetail ---- querySledCommodity ---- sledCommodityEditPage size : " + sledCommodityEditPage.getPageSize());
		return sledCommodityEditPage;
	}
	
	private List<LocalGeneralCommodityMappingInfo> queryCommodityMappingInfo(int pageIndex, TechPlatform platform, String sledExchangeMic, String sledCommodityType, String sledCommodityCode, String mappingExchange, String mappingCommodityCode) throws ErrorInfo, TException {
		
		List<LocalGeneralCommodityMappingInfo> localGeneralCommodityMappingInfoList = new ArrayList<LocalGeneralCommodityMappingInfo>();
		
		//Sled
		Map<Integer, SledCommodity> sledCommodityMap = new HashMap<Integer, SledCommodity>();
		List<Integer> sledCommodityIdList = new ArrayList<Integer>();
		
		SledCommodityEditPage sledCommodityEditPage = querySledCommodity(sledExchangeMic, sledCommodityType, sledCommodityCode/*sledCommodityIdList*/);
		for (SledCommodityEdit sledCommodityEdit : sledCommodityEditPage.getPage()) {
			sledCommodityMap.put(sledCommodityEdit.getSledCommodity().getSledCommodityId(), sledCommodityEdit.getSledCommodity());
			sledCommodityIdList.add(sledCommodityEdit.getSledCommodity().getSledCommodityId());
		}
		
		if (sledCommodityIdList.isEmpty()) {
			return localGeneralCommodityMappingInfoList;
		}
		// MAP
		CommodityMappingEditPage commodityMappingEditPage = queryCommodityMappingByPlatform(platform, sledCommodityIdList, mappingExchange, mappingCommodityCode);
		Map<Integer, CommodityMapping> mappingcommodityMap = new HashMap<Integer, CommodityMapping>();
		
		for (CommodityMappingEdit commodityMappingEdit : commodityMappingEditPage.getPage()) {
			mappingcommodityMap.put(commodityMappingEdit.getCommodityMapping().getSledCommodityId(), commodityMappingEdit.getCommodityMapping());
		}
		
		//page
		mTotalNum = commodityMappingEditPage.getTotal();
		mTotalPage = (commodityMappingEditPage.getTotal() + PAGE_SIZE - 1) / PAGE_SIZE;
		AppLog.i("GeneralCommodityMapDetail ---- queryCommodityMappingInfo ---- pageIndex : " + pageIndex + ", mTotalPage : " + mTotalPage + ", commodityMappingEditPage : " + commodityMappingEditPage.getPageSize());
		if (pageIndex <= mTotalPage) {
			for (int index = (pageIndex - 1) * PAGE_SIZE; index < pageIndex * PAGE_SIZE; index++) {
				if (index < commodityMappingEditPage.getTotal()) {
					int key = commodityMappingEditPage.getPage().get(index).getCommodityMapping().getSledCommodityId();
					LocalGeneralCommodityMappingInfo localGeneralCommodityMappingInfo = new LocalGeneralCommodityMappingInfo();

					CommodityMapping ommodityMapping = mappingcommodityMap.get(key);
					if (ommodityMapping != null) {
						localGeneralCommodityMappingInfo.setMappingExchange(ommodityMapping.getExchange());
						localGeneralCommodityMappingInfo.setMappingCommodityCode(ommodityMapping.getCommodityCode());
						localGeneralCommodityMappingInfo.setMappingCommodityType(ommodityMapping.getCommodityType());
						localGeneralCommodityMappingInfo.setMappingMoneyRatio(String.valueOf(ommodityMapping.getMoneyRatio()));
					}
					//sled
					SledCommodity sledCommodity = sledCommodityMap.get(key);
					if (sledCommodity != null) {
						localGeneralCommodityMappingInfo.setSledExchangeMic(sledCommodity.getExchangeMic());
						localGeneralCommodityMappingInfo.setSledCommodityCode(sledCommodity.getSledCommodityCode());
						localGeneralCommodityMappingInfo.setSledCommodityType(sledCommodity.getSledCommodityType().name());
					}
					
					localGeneralCommodityMappingInfoList.add(localGeneralCommodityMappingInfo);
				}
			}
		}
		return localGeneralCommodityMappingInfoList;
	}

}
