package com.longsheng.xueqiao.active.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.math.RandomUtils;
import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

import com.longsheng.xueqiao.active.bean.LocalCommodityMapFileInfo;
import com.longsheng.xueqiao.active.util.TimeFormator;
import com.longsheng.xueqiao.broker.dao.thriftapi.BrokerAccessEntryPage;
import com.longsheng.xueqiao.broker.dao.thriftapi.BrokerEntryPage;
import com.longsheng.xueqiao.broker.dao.thriftapi.ReqBrokerAccessEntryOption;
import com.longsheng.xueqiao.broker.dao.thriftapi.ReqBrokerEntryOption;
import com.longsheng.xueqiao.broker.dao.thriftapi.client.BrokerDaoServiceStub;
import com.longsheng.xueqiao.broker.thriftapi.BrokerAccessEntry;
import com.longsheng.xueqiao.broker.thriftapi.BrokerEntry;
import com.longsheng.xueqiao.broker.thriftapi.BrokerPlatform;
import com.longsheng.xueqiao.contract.thriftapi.CommodityMapFileInfo;
import com.longsheng.xueqiao.contract.thriftapi.CommodityMapFileInfoPage;
import com.longsheng.xueqiao.contract.thriftapi.ReqCommodityMapFileInfoOption;
import com.longsheng.xueqiao.contract.thriftapi.client.ContractServiceStub;

public class SledCommodityMapAdmin extends OaAuthController {

	private static final int TIME_OUT = 3000;
	private static final int PAGE_SIZE = 10;
	private static final int PAGE_SIZE_MAX = Integer.MAX_VALUE;

	private String MAPPING_PLATFORM = "ESUNNY_3";
	
	BrokerDaoServiceStub mBrokerDaoServiceStub = new BrokerDaoServiceStub();
	ContractServiceStub mContractServiceStub = new ContractServiceStub();
	
	private int mTotalPage = 1;
	
	public void show() throws Exception {

		int requestPage = parameter("requestPage", 1);
		if (requestPage < 1) {
			requestPage = 1;
		}
		
		setBaseQueryUrl();
		
//		requestPage = queryBrokerEntryListByPlatform(requestPage - 1, BrokerPlatform.valueOf(MAPPING_PLATFORM));
		List<LocalCommodityMapFileInfo> LocalCommodityMapFileInfoList = queryCommodityMapFileInfo(requestPage);

		if (mTotalPage < 1) {
			mTotalPage = 1;
		}
		put("totalPage", mTotalPage);
		put("currentPage", requestPage);
		put("commodityMapFileInfoList", LocalCommodityMapFileInfoList);
		
		render("sled_commodity_map_admin.html");
	}

	public List<LocalCommodityMapFileInfo> queryCommodityMapFileInfo(int pageIndex) throws IOException, TException {
		BrokerEntryPage brokerEntryPage = queryBrokerEntryPageByPlatform(BrokerPlatform.valueOf(MAPPING_PLATFORM));
		CommodityMapFileInfoPage commodityMapFileInfoPage = queryMappingInfo();
		List<LocalCommodityMapFileInfo> localCommodityMapFileInfoAllList = new LinkedList<LocalCommodityMapFileInfo>();
		List<LocalCommodityMapFileInfo> localCommodityMapFileInfoList = new ArrayList<LocalCommodityMapFileInfo>();
		AppLog.i("SledCommodityMapAdmin ---- queryCommodityMapFileInfo ---- brokerEntryPage : " + brokerEntryPage.getPageSize() + ", commodityMapFileInfoPage : " + commodityMapFileInfoPage.getPageSize());
		boolean hasMapFile = false;
		int noMapFileIndex = 0;
		for (BrokerEntry brokerEntry : brokerEntryPage.getPage()) {
			LocalCommodityMapFileInfo localCommodityMapFileInfo = new LocalCommodityMapFileInfo();
			localCommodityMapFileInfo.setBrokerId(brokerEntry.getBrokerId());
			localCommodityMapFileInfo.setCnName(brokerEntry.getCnName());
			hasMapFile = false;
			for (CommodityMapFileInfo commodityMapFileInfo : commodityMapFileInfoPage.getPage()) {
				AppLog.i("SledCommodityMapAdmin ---- queryCommodityMapFileInfo ---- brokerEntry.getBrokerId() : " + brokerEntry.getBrokerId() + ", commodityMapFileInfo.getBrokerEntryId() : " + commodityMapFileInfo.getBrokerEntryId());
				if (brokerEntry.getBrokerId() == commodityMapFileInfo.getBrokerEntryId()) {
					localCommodityMapFileInfo.setFileMD5(commodityMapFileInfo.getFileMD5());
					localCommodityMapFileInfo.setVersion(String.valueOf(commodityMapFileInfo.getVersion()));
					localCommodityMapFileInfo.setUrl(commodityMapFileInfo.getUrl());
					localCommodityMapFileInfo.setLastModityTime(TimeFormator.timeStampToDate(commodityMapFileInfo.getLastModityTimestamp()));
					hasMapFile = true;
					break;
				}
			}
			AppLog.i("SledCommodityMapAdmin ---- queryCommodityMapFileInfo ---- hasMapFile : " + hasMapFile + ", noMapFileIndex : " + noMapFileIndex);
			if (hasMapFile) {
				localCommodityMapFileInfoAllList.add(localCommodityMapFileInfo);
			} else {
				localCommodityMapFileInfoAllList.add(noMapFileIndex, localCommodityMapFileInfo);
				noMapFileIndex++;
			}
		}
		mTotalPage = (brokerEntryPage.getTotal() + PAGE_SIZE - 1) / PAGE_SIZE;
		AppLog.i("SledCommodityMapAdmin ---- queryCommodityMapFileInfo ---- pageIndex : " + pageIndex + ", mTotalPage : " + mTotalPage + ", localCommodityMapFileInfoAllList : " + localCommodityMapFileInfoAllList.size());
		if (pageIndex <= mTotalPage) {
			for (int index = (pageIndex - 1) * PAGE_SIZE; index < pageIndex * PAGE_SIZE; index++) {
				if (index < brokerEntryPage.getTotal()) {
					localCommodityMapFileInfoList.add(localCommodityMapFileInfoAllList.get(index));
				}
			}
		}
		AppLog.i("SledCommodityMapAdmin ---- queryCommodityMapFileInfo ---- localCommodityMapFileInfoList : " + localCommodityMapFileInfoList.size());
		return localCommodityMapFileInfoList;
	}
	
	private void setBaseQueryUrl() {
		StringBuffer baseQueryUrl = new StringBuffer();
		String baseUrl = this.baseUrl;
		int l = baseUrl.indexOf("requestPage");
		if (l > 0) {
			baseUrl = baseUrl.substring(0, l);
		}
		baseQueryUrl.append(baseUrl);
		baseQueryUrl.append("/SledCommodityMapAdmin/show?");
		put("baseQueryUrl", baseQueryUrl);
	}
	
	private BrokerEntryPage queryBrokerEntryPageByPlatform(BrokerPlatform platform) throws TException {

		if (mBrokerDaoServiceStub == null) {
			mBrokerDaoServiceStub = new BrokerDaoServiceStub();
		}
		
		BrokerEntryPage brokerEntryPage = null;

		ReqBrokerAccessEntryOption reqBrokerAccessEntryOption = new ReqBrokerAccessEntryOption();
		reqBrokerAccessEntryOption.setPlatform(platform);
		BrokerAccessEntryPage brokerAccessEntryPage = mBrokerDaoServiceStub.reqBrokerAccessEntry(RandomUtils.nextInt(), TIME_OUT, reqBrokerAccessEntryOption, 0, PAGE_SIZE_MAX);
		
		AppLog.i("SledCommodityMapAdmin ---- queryBrokerEntryPageByPlatform ---- platform : " + platform.name() + ", PAGE_SIZE_MAX : " + PAGE_SIZE_MAX + ", brokerAccessEntryPage total : " + brokerAccessEntryPage.getTotal() + ", brokerAccessEntryPage pagesize: " + brokerAccessEntryPage.getPageSize());
		
		if (brokerAccessEntryPage != null && brokerAccessEntryPage.getPageSize() > 0) {
			ReqBrokerEntryOption reqBrokerEntryOption = new ReqBrokerEntryOption();
			List<Integer> brokerIds = new ArrayList<Integer>();
			for (BrokerAccessEntry brokerAccessEntry : brokerAccessEntryPage.getPage()) {
				brokerIds.add(brokerAccessEntry.getBrokerId());
			}
			reqBrokerEntryOption.setBrokerIds(brokerIds);
			brokerEntryPage = mBrokerDaoServiceStub.reqBrokerEntry(RandomUtils.nextInt(), TIME_OUT, reqBrokerEntryOption, 0, PAGE_SIZE_MAX);
		}
		return brokerEntryPage;
	}
	
	private CommodityMapFileInfoPage queryMappingInfo() throws ErrorInfo, TException {
		if (mContractServiceStub == null) {
			mContractServiceStub = new ContractServiceStub();
		}
		ReqCommodityMapFileInfoOption reqCommodityMapFileInfoOption = new ReqCommodityMapFileInfoOption();
		CommodityMapFileInfoPage commodityMapFileInfoPage = mContractServiceStub.reqCommodityMapFileInfo(reqCommodityMapFileInfoOption, 0, PAGE_SIZE_MAX);
		AppLog.i("SledCommodityMapAdmin ---- queryBrokerEntryPageByPlatform ---- PAGE_SIZE_MAX : " + PAGE_SIZE_MAX + ", commodityMapFileInfoPage total : " + commodityMapFileInfoPage.getTotal() + ", commodityMapFileInfoPage pagesize : " + commodityMapFileInfoPage.getPageSize());
		return commodityMapFileInfoPage;
	}
}
