package com.longsheng.xueqiao.active.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.longsheng.xueqiao.active.bean.LocalSledExchange;
import com.longsheng.xueqiao.active.util.CityTimeZoneMapping;
import com.longsheng.xueqiao.contract.standard.thriftapi.SledExchange;
import com.longsheng.xueqiao.contract.thriftapi.client.ContractServiceStub;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.thrift.TException;
import org.soldier.base.StringFactory;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

import com.longsheng.xueqiao.contract.online.dao.thriftapi.client.ContractOnlineDaoServiceStub;
import com.longsheng.xueqiao.contract.standard.thriftapi.ReqSledExchangeOption;
import com.longsheng.xueqiao.contract.standard.thriftapi.SledExchangePage;
import org.soldier.platform.web_framework.model.ErrorResult;
import org.soldier.platform.web_framework.util.GsonFactory;

public class SledExchangeAdmin extends OaAuthController {

	private static final int TIME_OUT = 3000;
	private static final int PAGE_SIZE = 14;

	ContractOnlineDaoServiceStub mContractServiceStub = new ContractOnlineDaoServiceStub();

	private int mTotalPage = 1;
	private int mTotalNum = 0;

	public void show() throws Exception {

		int requestPage = parameter("requestPage", 1);
		String cnName = parameter("cnName", "");
		String acronym = parameter("acronym", "");
		String cnAcronym = parameter("cnAcronym", "");

		AppLog.i("SledExchangeAdmin ---- show ---- requestPage : " + requestPage + ", cnName : " + cnName + ", acronym : " + acronym + ", cnAcronym : " + cnAcronym);

		if (requestPage < 1) {
			requestPage = 1;
		}
		requestPage = queryExchangeList(requestPage - 1, cnName, acronym, cnAcronym);
		getZoneIdList();
		put("currentPage", requestPage + 1);
		if (mTotalPage < 1) {
			mTotalPage = 1;
		}
		put("totalPage", mTotalPage);
		put("totalNum", mTotalNum);

		put("cnName", cnName);
		put("acronym", acronym);
		put("cnAcronym", cnAcronym);

		if (mContractServiceStub == null) {
			mContractServiceStub = new ContractOnlineDaoServiceStub();
		}
//		getModuleLockStatus(ModuleType.MM_CONTRACT);
		setBaseQueryUrl(cnName, acronym, cnAcronym);
		render("sled_exchange_admin.html");
	}

	private void setBaseQueryUrl(String cnName, String acronym, String cnAcronym) {
		StringBuffer baseQueryUrl = new StringBuffer();
		String baseUrl = this.baseUrl;
		int l = baseUrl.indexOf("requestPage");
		if (l > 0) {
			baseUrl = baseUrl.substring(0, l);
		}
		baseQueryUrl.append(baseUrl);
		baseQueryUrl.append("/SledExchangeAdmin/show?cnName=").append(cnName).append("&acronym=").append(acronym).append("&cnAcronym=").append(cnAcronym).append("&");
		put("baseQueryUrl", baseQueryUrl);
	}

	private void getZoneIdList() {
		List<String> zoneIdList = CityTimeZoneMapping.getInstance().getZoneList();
		put("zoneIdList", zoneIdList);
	}

	private int queryExchangeList(int pageIndex, String cnName, String acronym, String cnAcronym) throws TException {
		if (mContractServiceStub == null) {
			mContractServiceStub = new ContractOnlineDaoServiceStub();
		}
		// query all exchanges
		ReqSledExchangeOption option = new ReqSledExchangeOption();
		if (cnName != null && !cnName.isEmpty()) {
			option.setCnNamePartical(cnName);
		}
		if (acronym != null && !acronym.isEmpty()) {
			option.setAcronymPartical(acronym);
		}
		if (cnAcronym != null && !cnAcronym.isEmpty()) {
			option.setCnAcronymPartical(cnAcronym);
		}

		SledExchangePage exchangePage = mContractServiceStub.reqSledExchange(RandomUtils.nextInt(), TIME_OUT, option, pageIndex, PAGE_SIZE);
		put("sledExchangeList", exchangePage.getPage());
		mTotalNum = exchangePage.getTotal();
		mTotalPage = (exchangePage.getTotal() + PAGE_SIZE - 1) / PAGE_SIZE;
		AppLog.i("SledExchangeAdmin ---- queryExchangeList ---- mTotalPage : " + mTotalPage);
		return pageIndex > mTotalPage ? mTotalPage : pageIndex;
	}

	public void getSledExchange() throws ErrorInfo, TException, Exception {
		int sledExchangeId = parameter("sledExchangeId", -1);

		if (sledExchangeId > 0) {
			if (mContractServiceStub == null) {
				mContractServiceStub = new ContractOnlineDaoServiceStub();
			}
			ReqSledExchangeOption option = new ReqSledExchangeOption();
			List<Integer> sledExchangeIds = new ArrayList<Integer>();
			sledExchangeIds.add(sledExchangeId);
			option.setSledExchangeIds(sledExchangeIds);

			SledExchangePage exchangePage = mContractServiceStub.reqSledExchange(RandomUtils.nextInt(), TIME_OUT, option, 0, 0);
			if (exchangePage.getPageSize() > 0) {
				echoJson(exchangePage.getPage().get(0));
			}
		}
	}
}
