package com.longsheng.xueqiao.active.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.math.RandomUtils;
import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

import com.longsheng.xueqiao.active.bean.LocalCommodity;
import com.longsheng.xueqiao.active.bean.LocalSimpleCommodity;
import com.longsheng.xueqiao.contract.online.dao.thriftapi.client.ContractOnlineDaoServiceStub;
import com.longsheng.xueqiao.contract.standard.thriftapi.ReqSledCommodityOption;
import com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodity;
import com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodityPage;
import com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodityType;

public class SledCommodityAdmin extends OaAuthController {

	private static final int TIME_OUT = 3000;
	private static final int PAGE_SIZE = 14;
	private static final int PAGE_SIZE_MAX = Integer.MAX_VALUE;
	
	private int mCommodityTotal = 0;
	private int mTotalPage = 1;
	private int mTotalNum = 0;

	private ContractOnlineDaoServiceStub mContractOnlineDaoService = new ContractOnlineDaoServiceStub();
	
	public void show() throws Exception {

		String exchangeMic = parameter("exchangeMic", "");
		String commodityType = parameter("commodityType", "");
		String exchangeCNName = parameter("exchangeCNName", "");

		// commodity query
		String cnName = parameter("cnName", "");
		String sledCommodityCode = parameter("sledCommodityCode", "");

		int requestPage = parameter("requestPage", 1);
		
		AppLog.i("SledCommodityAdmin ---- show ---- exchangeMic : " + exchangeMic + ", commodityType : " + commodityType + ", requestPage : " + requestPage);
		
		if (requestPage < 1) {
			requestPage = 1;
		}
		
		if (exchangeMic == null || exchangeMic.isEmpty()) {
			return;
		}
		if (commodityType == null || commodityType.isEmpty()) {
			commodityType = "FUTURES";
		}
		requestPage = queryCommoditiesByExchangeMic(exchangeMic, commodityType, cnName, sledCommodityCode, requestPage - 1);
		// relative commodity must be futures
		queryRelativeCommodityList(exchangeMic, "FUTURES");
//		requestPage++;
//		
		if (mTotalPage < 1) {
			mTotalPage = 1;
		}
		put("totalPage", mTotalPage);
		put("totalNum", mTotalNum);
		put("currentPage", requestPage + 1);
		put("commodityType", commodityType);
		put("exchangeMic", exchangeMic);
		put("exchangeCNName", exchangeCNName);

		put("cnName", cnName);
		put("sledCommodityCode", sledCommodityCode);

		setBaseQueryUrl(exchangeMic, commodityType, exchangeCNName, cnName, sledCommodityCode);
		
		render("sled_commodity_admin.html");
	}
	
	private void setBaseQueryUrl(String exchangeMic, String commodityType, String exchangeCNName, String cnName, String sledCommodityCode) {
		StringBuffer baseQueryUrl = new StringBuffer();
		String baseUrl = this.baseUrl;
		int l = baseUrl.indexOf("requestPage");
		if (l > 0) {
			baseUrl = baseUrl.substring(0, l);
		}
		baseQueryUrl.append(baseUrl);
		baseQueryUrl.append("/SledCommodityAdmin/show?exchangeMic=");
		baseQueryUrl.append(exchangeMic);
		baseQueryUrl.append("&commodityType=");
		baseQueryUrl.append(commodityType);
		baseQueryUrl.append("&exchangeCNName=");
		baseQueryUrl.append(exchangeCNName);
		baseQueryUrl.append("&cnName=");
		baseQueryUrl.append(cnName);
		baseQueryUrl.append("&sledCommodityCode=");
		baseQueryUrl.append(sledCommodityCode);
		baseQueryUrl.append("&");
		put("baseQueryUrl", baseQueryUrl);
	}

	private int queryCommoditiesByExchangeMic(String exchangeMic, String commodityType, String cnName, String sledCommodityCode, int pageIndex) throws ErrorInfo, TException {
//		ContractServiceStub stub = new ContractServiceStub();
		if (mContractOnlineDaoService == null) {
			mContractOnlineDaoService = new ContractOnlineDaoServiceStub();
		}

		ReqSledCommodityOption option = new ReqSledCommodityOption();
		
		option.setExchangeMic(exchangeMic);
		option.setSledCommodityType(SledCommodityType.valueOf(commodityType));

		if (cnName != null && !cnName.isEmpty()) {
			option.setCnNamePartical(cnName);
		}
		if (sledCommodityCode != null && !sledCommodityCode.isEmpty()) {
			option.setSledCommodityCodePartical(sledCommodityCode);
		}

		SledCommodityPage sledCommodityPage = mContractOnlineDaoService.reqSledCommodity(RandomUtils.nextInt(), TIME_OUT, option, pageIndex, PAGE_SIZE);
		
		AppLog.i("SledCommodityAdmin ---- queryCommoditiesByExchangeMic ---- pageIndex : " + pageIndex + ", sledCommodityPage : " + sledCommodityPage.getPageSize());
		
		put("sledCommodityList", LocalCommodity.transferToLocalCommodityList(mContractOnlineDaoService, sledCommodityPage.getPage()));
		
		mCommodityTotal = sledCommodityPage.getTotal();
		mTotalNum = sledCommodityPage.getTotal();
		mTotalPage = (mCommodityTotal + PAGE_SIZE - 1) / PAGE_SIZE;
		AppLog.i("SledCommodityAdmin ---- queryCommoditiesByExchangeId ---- mTotalPage : " + mTotalPage);
		return pageIndex > mTotalPage ? mTotalPage : pageIndex;

	}
	
	private void queryRelativeCommodityList(String exchangeMic, String commodityType) throws ErrorInfo, TException {
//		ContractServiceStub stub = new ContractServiceStub();
		if (mContractOnlineDaoService == null) {
			mContractOnlineDaoService = new ContractOnlineDaoServiceStub();
		}

		ReqSledCommodityOption option = new ReqSledCommodityOption();
		option.setExchangeMic(exchangeMic);
		option.setSledCommodityType(SledCommodityType.valueOf(commodityType));
		AppLog.i("SledCommodityAdmin ---- queryRelativeCommodityList ---- mCommodityTotal : " + mCommodityTotal + ", exchangeMic : " + exchangeMic + ", commodityType : " + commodityType);
		SledCommodityPage sledCommodityPage = mContractOnlineDaoService.reqSledCommodity(RandomUtils.nextInt(), TIME_OUT, option, 0, PAGE_SIZE_MAX);
		
		List<LocalSimpleCommodity> LocalSimpleCommodityList = new ArrayList<LocalSimpleCommodity>();
		
		for (SledCommodity sledCommodity : sledCommodityPage.getPage()) {
			LocalSimpleCommodity localSimpleCommodity = new LocalSimpleCommodity();
			localSimpleCommodity.setSledCommodityId(String.valueOf(sledCommodity.getSledCommodityId()));
			localSimpleCommodity.setSledCommodityCode(sledCommodity.getSledCommodityCode());
			LocalSimpleCommodityList.add(localSimpleCommodity);
		}
		put("relativeCommodityCandidateList", LocalSimpleCommodityList);
	}
}
