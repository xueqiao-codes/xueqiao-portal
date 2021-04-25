package com.longsheng.xueqiao.active.web.controller;

import com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

import com.longsheng.xueqiao.active.bean.LocalContract;
import com.longsheng.xueqiao.contract.online.dao.thriftapi.client.ContractOnlineDaoServiceStub;
import com.longsheng.xueqiao.contract.standard.thriftapi.ReqSledContractOption;
import com.longsheng.xueqiao.contract.standard.thriftapi.SledContractPage;

public class SledContractDetail extends OaAuthController {

	private static final int TIME_OUT = 3000;
	private static final int PAGE_SIZE = 50;

	private int mTotalPage = 1;
	private int mTotalNum = 0;

	private ContractOnlineDaoServiceStub mContractOnlineDaoService = new ContractOnlineDaoServiceStub();

	public void show() throws Exception {

		int sledCommodityId = parameter("sledCommodityId", 0);
		String exchangeMic = parameter("exchangeMic", "");
		String commodityType = parameter("commodityType", "");
		String exchangeCNName = parameter("exchangeCNName", "");
		String commodityCnName = parameter("commodityCnName", "");

		// filter
		String sledContractCode = parameter("sledContractCode", "");
		String platformEnv = parameter("platformEnv", "");

		int requestPage = parameter("requestPage", 1);

		if (requestPage < 1) {
			requestPage = 1;
		}

		if (sledCommodityId <= 0) {
			return;
		}
//
		requestPage = queryContractById(sledCommodityId, sledContractCode, platformEnv, requestPage - 1);

		setBaseQueryUrl(sledCommodityId, exchangeMic, commodityType, exchangeCNName, commodityCnName, sledContractCode, platformEnv);
		if (mTotalPage < 1) {
			mTotalPage = 1;
		}
		put("totalPage", mTotalPage);
		put("totalNum", mTotalNum);
		put("currentPage", requestPage + 1);
		put("exchangeMic", exchangeMic);
		put("commodityType", commodityType);
		put("exchangeCNName", exchangeCNName);
		put("commodityCnName", commodityCnName);
		put("sledCommodityId", sledCommodityId);

		put("sledContractCode", sledContractCode);
		put("platformEnv", platformEnv);

//		put("sledContract", sledContract);

		render("sled_contract_detail.html");
	}

	private void setBaseQueryUrl(int sledCommodityId, String exchangeMic, String commodityType, String exchangeCNName, String commodityCnName, String sledContractCode, String platformEnv) {
		StringBuffer baseQueryUrl = new StringBuffer();
		String baseUrl = this.baseUrl;
		int l = baseUrl.indexOf("requestPage");
		if (l > 0) {
			baseUrl = baseUrl.substring(0, l);
		}
		baseQueryUrl.append(baseUrl);
		baseQueryUrl.append("/SledContractDetail/show?sledCommodityId=");
		baseQueryUrl.append(sledCommodityId);
		baseQueryUrl.append("&exchangeMic=");
		baseQueryUrl.append(exchangeMic);
		baseQueryUrl.append("&commodityType=");
		baseQueryUrl.append(commodityType);
		baseQueryUrl.append("&exchangeCNName=");
		baseQueryUrl.append(exchangeCNName);
		baseQueryUrl.append("&commodityCnName=");
		baseQueryUrl.append(commodityCnName);
		baseQueryUrl.append("&sledContractCode=");
		baseQueryUrl.append(sledContractCode);
		baseQueryUrl.append("&platformEnv=");
		baseQueryUrl.append(platformEnv);
		baseQueryUrl.append("&");
		put("baseQueryUrl", baseQueryUrl);
	}

	private int queryContractById(int sledCommodityId, String sledContractCode, String platformEnv, int pageIndex) throws ErrorInfo, TException {
//		ContractServiceStub stub = new ContractServiceStub();
		if (mContractOnlineDaoService == null) {
			mContractOnlineDaoService = new ContractOnlineDaoServiceStub();
		}

		ReqSledContractOption option = new ReqSledContractOption();
		option.setSledCommodityId(sledCommodityId);

		// filter
		if (sledContractCode != null && !sledContractCode.isEmpty()) {
			option.setContractCodePartical(sledContractCode);
		}
		if (platformEnv != null && !platformEnv.isEmpty()) {
			option.setPlatformEnv(TechPlatformEnv.valueOf(platformEnv));
		}

		SledContractPage sledContractPage = mContractOnlineDaoService.reqSledContract(RandomUtils.nextInt(), TIME_OUT, option, pageIndex, PAGE_SIZE);

		if (sledContractPage.getPageSize() > 0 ) {
			put("sledContractList", LocalContract.transferToLocalContractList(sledContractPage.getPage()));
		}

		mTotalNum = sledContractPage.getTotal();
		mTotalPage = (mTotalNum + PAGE_SIZE - 1) / PAGE_SIZE;
		AppLog.i("SledCommodityAdmin ---- queryCommoditiesByExchangeId ---- mTotalPage : " + mTotalPage);
		return pageIndex > mTotalPage ? mTotalPage : pageIndex;
	}

}
