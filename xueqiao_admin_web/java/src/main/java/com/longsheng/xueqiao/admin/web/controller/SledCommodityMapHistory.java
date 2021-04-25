package com.longsheng.xueqiao.admin.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

import com.longsheng.xueqiao.admin.bean.LocalCommodityMapFileInfo;
import com.longsheng.xueqiao.admin.util.TimeFormator;
import com.longsheng.xueqiao.contract.thriftapi.CommodityMapFileInfo;
import com.longsheng.xueqiao.contract.thriftapi.CommodityMapFileInfoPage;
import com.longsheng.xueqiao.contract.thriftapi.ReqCommodityMapFileInfoOption;
import com.longsheng.xueqiao.contract.thriftapi.client.ContractServiceStub;

public class SledCommodityMapHistory extends OaAuthController {

	private static final int TIME_OUT = 3000;
	private static final int PAGE_SIZE = 10;

	ContractServiceStub mContractServiceStub = new ContractServiceStub();
	
	private int mTotalPage = 1;
	private int mTotalNum = 0;
	
	public void show() throws Exception {

		int requestPage = parameter("requestPage", 1);
		int brokerEntryId = parameter("brokerEntryId", 0);
		String brokerCnName = parameter("brokerCnName", "");
		
//		int brokerId = parameter("brokerId", 0);
		String platform = parameter("platform", "");


		AppLog.i("SledCommodityMapHistory ---- show ---- brokerEntryId : " + brokerEntryId + ", brokerCnName : " + brokerCnName + ", platform : " + platform);

		if (requestPage < 1) {
			requestPage = 1;
		}
		requestPage = queryMappingInfo(brokerEntryId, requestPage);

		setBaseQueryUrl(brokerEntryId, brokerCnName);
		if (mTotalPage < 1) {
			mTotalPage = 1;
		}
		put("totalPage", mTotalPage);
		put("totalNum", mTotalNum);
		put("currentPage", requestPage);
		put("brokerId", brokerEntryId);
		put("platform", platform);
		put("brokerCnName", brokerCnName);
		
		render("sled_commodity_map_history.html");
	}
	
	private void setBaseQueryUrl(int brokerEntryId, String brokerCnName) {
		StringBuffer baseQueryUrl = new StringBuffer();
		String baseUrl = this.baseUrl;
		int l = baseUrl.indexOf("requestPage");
		if (l > 0) {
			baseUrl = baseUrl.substring(0, l);
		}
		baseQueryUrl.append(baseUrl);
		baseQueryUrl.append("/SledCommodityMapHistory/show?brokerEntryId=" + brokerEntryId + "&brokerCnName=" + brokerCnName + "&");
		put("baseQueryUrl", baseQueryUrl);
	}
	
	private int queryMappingInfo(int brokerEntryId, int pageIndex) throws ErrorInfo, TException {
		if (mContractServiceStub == null) {
			mContractServiceStub = new ContractServiceStub();
		}
		ReqCommodityMapFileInfoOption reqCommodityMapFileInfoOption = new ReqCommodityMapFileInfoOption();
		List<Integer> brokerEntryIds = new ArrayList<Integer>();
		brokerEntryIds.add(brokerEntryId);
		reqCommodityMapFileInfoOption.setBrokerEntryIds(brokerEntryIds);
		CommodityMapFileInfoPage commodityMapFileInfoPage = mContractServiceStub.reqCommodityMapFileInfo(reqCommodityMapFileInfoOption, pageIndex - 1, PAGE_SIZE);
		AppLog.i("SledCommodityMapHistory ---- queryMappingInfo ---- commodityMapFileInfoPage total : " + commodityMapFileInfoPage.getTotal() + ", commodityMapFileInfoPage pagesize : " + commodityMapFileInfoPage.getPageSize());
		
		List<LocalCommodityMapFileInfo> localCommodityMapFileInfoList = new ArrayList<LocalCommodityMapFileInfo>();
		
		for (CommodityMapFileInfo commodityMapFileInfo : commodityMapFileInfoPage.getPage()) {
			LocalCommodityMapFileInfo localCommodityMapFileInfo = new LocalCommodityMapFileInfo();
			
			localCommodityMapFileInfo.setVersion(String.valueOf(commodityMapFileInfo.getVersion()));
			localCommodityMapFileInfo.setFileMD5(commodityMapFileInfo.getFileMD5());
			localCommodityMapFileInfo.setLastModityTime(TimeFormator.timeStampToDate(commodityMapFileInfo.getLastModityTimestamp()));
			localCommodityMapFileInfo.setUrl(commodityMapFileInfo.getUrl());
			
			localCommodityMapFileInfoList.add(localCommodityMapFileInfo);
		}
		
		put("commodityMapFileInfoList", localCommodityMapFileInfoList);
		
		mTotalNum = commodityMapFileInfoPage.getTotal();
		mTotalPage = (commodityMapFileInfoPage.getTotal() + PAGE_SIZE - 1) / PAGE_SIZE;
		if (mTotalPage < pageIndex) {
			return mTotalPage + 1;
		} else {
			return pageIndex;
		}
	}

}
