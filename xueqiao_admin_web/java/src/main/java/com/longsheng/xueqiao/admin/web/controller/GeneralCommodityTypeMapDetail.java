package com.longsheng.xueqiao.admin.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.page.IndexedPageOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

import com.longsheng.xueqiao.admin.bean.LocalCommodityTypeMapping;
import com.longsheng.xueqiao.admin.bean.LocalGeneralCommodityMappingInfo;
import com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatform;
import com.longsheng.xueqiao.contract.thriftapi.ReqSledCommodityTypeMappingOption;
import com.longsheng.xueqiao.contract.thriftapi.SledCommodityTypeMapping;
import com.longsheng.xueqiao.contract.thriftapi.SledCommodityTypeMappingPage;
import com.longsheng.xueqiao.contract.thriftapi.client.ContractServiceStub;

public class GeneralCommodityTypeMapDetail extends OaAuthController {
	private static final int TIME_OUT = 3000;
	private static final int PAGE_SIZE = 10;
	private static final int PAGE_SIZE_MAX = Integer.MAX_VALUE;
	
	ContractServiceStub mContractServiceStub = new ContractServiceStub();
	
	private int mTotalPage = 1;
	private int mTotalNum = 0;

	public void show() throws Exception {

		int requestPage = parameter("requestPage", 1);
		String platform = parameter("platform", "");

		if (platform == null || platform.isEmpty()) {
			return;
		}
		
		if (requestPage < 1) {
			requestPage = 1;
		}

		requestPage = querySledCommodityTypeMappingList(platform, requestPage - 1);
		
		setBaseQueryUrl(platform);

		if (mTotalPage < 1) {
			mTotalPage = 1;
		}
		put("totalPage", mTotalPage);
		put("totalNum", mTotalNum);
		put("platform", platform);
		put("currentPage", requestPage + 1);
		
		render("general_commodity_type_map_detail.html");
	}
	
	private void setBaseQueryUrl(String platform) {
		StringBuffer baseQueryUrl = new StringBuffer();
		String baseUrl = this.baseUrl;
		int l = baseUrl.indexOf("requestPage");
		if (l > 0) {
			baseUrl = baseUrl.substring(0, l);
		}
		baseQueryUrl.append(baseUrl);
		baseQueryUrl.append("/GeneralCommodityTypeMapDetail/show?platform=");
		baseQueryUrl.append(platform);
		baseQueryUrl.append("&");
		put("baseQueryUrl", baseQueryUrl);
	}
	
	private int querySledCommodityTypeMappingList(String platform, int pageIndex) throws ErrorInfo, TException {
		if (mContractServiceStub == null) {
			mContractServiceStub = new ContractServiceStub();
		}
		
		ReqSledCommodityTypeMappingOption reqSledCommodityTypeMappingOption = new ReqSledCommodityTypeMappingOption();
		IndexedPageOption indexedPageOption = new IndexedPageOption();
		indexedPageOption.setPageIndex(pageIndex);
		indexedPageOption.setPageSize(PAGE_SIZE);
		indexedPageOption.setNeedTotalCount(true);
		
		reqSledCommodityTypeMappingOption.setTechPlatform(TechPlatform.valueOf(platform));
		reqSledCommodityTypeMappingOption.setPageOption(indexedPageOption);
		
		
		SledCommodityTypeMappingPage sledCommodityTypeMappingPage = mContractServiceStub.reqSledCommodityTypeMapping(reqSledCommodityTypeMappingOption);
		
		List<LocalCommodityTypeMapping> localCommodityTypeMappingList = new ArrayList<LocalCommodityTypeMapping>();
		
		for (SledCommodityTypeMapping sledCommodityTypeMapping : sledCommodityTypeMappingPage.getPage()) {
			LocalCommodityTypeMapping localCommodityTypeMapping = new LocalCommodityTypeMapping();
			
			localCommodityTypeMapping.setMappingId(sledCommodityTypeMapping.getMappingId());
			localCommodityTypeMapping.setSledCommodityType(sledCommodityTypeMapping.getSledCommodityType().name());
			localCommodityTypeMapping.setTechPlatformCommodityType(sledCommodityTypeMapping.getTechPlatformCommodityType());
			localCommodityTypeMapping.setTechPlatform(sledCommodityTypeMapping.getTechPlatform().name());
			
			localCommodityTypeMappingList.add(localCommodityTypeMapping);
		}
		
		put("commodityTypeMappingList", localCommodityTypeMappingList);
		mTotalNum = sledCommodityTypeMappingPage.getTotal();
		mTotalPage = (mTotalNum + PAGE_SIZE - 1) / PAGE_SIZE;
		return pageIndex > mTotalPage ? mTotalPage : pageIndex;
	}
}
