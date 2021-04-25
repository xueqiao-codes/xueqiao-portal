package com.longsheng.xueqiao.active.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.math.RandomUtils;
import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

import com.longsheng.xueqiao.active.bean.LocalCommodity;
import com.longsheng.xueqiao.contract.online.dao.thriftapi.client.ContractOnlineDaoServiceStub;
import com.longsheng.xueqiao.contract.standard.thriftapi.ReqSledCommodityOption;
import com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodityPage;

public class SledCommodityDetail extends OaAuthController {

	private static final int TIME_OUT = 3000;

	private ContractOnlineDaoServiceStub mContractOnlineDaoService = new ContractOnlineDaoServiceStub();
	
	public void show() throws Exception {

		int sledCommodityId = parameter("sledCommodityId", 0);
		String exchangeMic = parameter("exchangeMic", "");
		String commodityType = parameter("commodityType", "");
		String exchangeCNName = parameter("exchangeCNName", "");

		if (sledCommodityId <= 0) {
			return;
		}

		queryCommodityById(sledCommodityId);

		put("exchangeMic", exchangeMic);
		put("commodityType", commodityType);
		put("exchangeCNName", exchangeCNName);
		
		render("sled_commodity_detail.html");
	}

	private void queryCommodityById(int sledCommodityId) throws ErrorInfo, TException {
		if (mContractOnlineDaoService == null) {
			mContractOnlineDaoService = new ContractOnlineDaoServiceStub();
		}
		
		ReqSledCommodityOption commodityOption = new ReqSledCommodityOption();
		List<Integer> sledCommodityIdList = new ArrayList<Integer>();
		sledCommodityIdList.add(sledCommodityId);
		commodityOption.setSledCommodityIdList(sledCommodityIdList);
		SledCommodityPage sledCommodityPage = mContractOnlineDaoService.reqSledCommodity(RandomUtils.nextInt(), TIME_OUT, commodityOption, 0, 1);

		AppLog.i("SledCommodityDetail ---- queryCommodityById ---- sledCommodityPage : " + sledCommodityPage.toString());
		
		if (sledCommodityPage != null && sledCommodityPage.getTotal() > 0) {
			AppLog.i("SledCommodityDetail ---- queryCommodityById ---- getTotal : " + sledCommodityPage.getTotal());
			put("sledCommodity", LocalCommodity.transferToLocalCommodity(mContractOnlineDaoService, sledCommodityPage.getPage().get(0), true));
		}
	}
}
