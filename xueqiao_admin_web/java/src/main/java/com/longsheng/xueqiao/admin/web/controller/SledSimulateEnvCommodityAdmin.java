package com.longsheng.xueqiao.admin.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.thrift.TException;
import org.soldier.base.StringFactory;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.web_framework.model.ErrorResult;
import org.soldier.platform.web_framework.util.GsonFactory;

import com.longsheng.xueqiao.admin.bean.LocalExchange;
import com.longsheng.xueqiao.admin.bean.LocalSimpleCommodity;
import com.longsheng.xueqiao.admin.bean.LocalSimulateEnvCommodity;
import com.longsheng.xueqiao.admin.bean.tradetime.LocalTradeTimeSelectionInfo;
import com.longsheng.xueqiao.contract.standard.thriftapi.ReqSledCommodityOption;
import com.longsheng.xueqiao.contract.standard.thriftapi.ReqSledExchangeOption;
import com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodity;
import com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodityType;
import com.longsheng.xueqiao.contract.standard.thriftapi.SledExchange;
import com.longsheng.xueqiao.contract.standard.thriftapi.SledExchangePage;
import com.longsheng.xueqiao.contract.thriftapi.SledCommodityEdit;
import com.longsheng.xueqiao.contract.thriftapi.SledCommodityEditPage;
import com.longsheng.xueqiao.contract.thriftapi.client.ContractServiceStub;

public class SledSimulateEnvCommodityAdmin extends OaAuthController {

	private static final int PAGE_SIZE = 10;
	private static final int PAGE_SIZE_MAX = Integer.MAX_VALUE;

	ContractServiceStub mContractServiceStub = new ContractServiceStub();

	private int mTotalPage = 1;
	private int mTotalNum = 0;

	public void show() throws Exception {

		int requestPage = parameter("requestPage", 1);
		String exchangeMic = parameter("exchangeMic", "");
		String exchangeCnName = parameter("exchangeCnName", "");
		String commodityCode = parameter("commodityCode", "");
		String commodityCnName = parameter("commodityCnName", "");

		AppLog.i("SledSimulateEnvCommodityAdmin ---- show ---- requestPage : " + requestPage + ", exchangeMic : "
				+ exchangeMic + ", exchangeCnName : " + exchangeCnName + ", commodityCode : " + commodityCode
				+ ", commodityCnName : " + commodityCnName);

		if (requestPage < 1) {
			requestPage = 1;
		}

		if (exchangeMic.isEmpty() && !exchangeCnName.isEmpty()) {
			exchangeMic = getExchangeMicByCnName(exchangeCnName);
			AppLog.i("SledSimulateEnvCommodityAdmin ---- show ---- getExchangeMicByCnName ---- exchangeMic : "
					+ exchangeMic);
		}

		requestPage = querySimulateEnvCommodityList(requestPage - 1, exchangeMic, commodityCode, commodityCnName);

		if (mTotalPage < 1) {
			mTotalPage = 1;
		}
		put("totalPage", mTotalPage);
		put("totalNum", mTotalNum);
		put("currentPage", requestPage + 1);

		put("exchangeMic", exchangeMic);
		put("exchangeCnName", exchangeCnName);
		put("commodityCode", commodityCode);
		put("commodityCnName", commodityCnName);


		setBaseQueryUrl(exchangeMic, exchangeCnName, commodityCode, commodityCnName);

		render("sled_simulate_env_commodity_admin.html");
	}

	private void setBaseQueryUrl(String exchangeMic, String exchangeCnName, String commodityCode,
			String commodityCnName) {
		StringBuffer baseQueryUrl = new StringBuffer();
		String baseUrl = this.baseUrl;
		int l = baseUrl.indexOf("requestPage");
		if (l > 0) {
			baseUrl = baseUrl.substring(0, l);
		}
		baseQueryUrl.append(baseUrl);
		baseQueryUrl.append("/SledSimulateEnvCommodityAdmin/show?exchangeMic=").append(exchangeMic);
		baseQueryUrl.append("&exchangeCnName=").append(exchangeCnName);
		baseQueryUrl.append("&commodityCode=").append(commodityCode);
		baseQueryUrl.append("&commodityCnName=").append(commodityCnName);
		baseQueryUrl.append("&");

		put("baseQueryUrl", baseQueryUrl);
	}

	private String getExchangeMicByCnName(String exchangeCnName) throws ErrorInfo, TException {
		if (mContractServiceStub == null) {
			mContractServiceStub = new ContractServiceStub();
		}
		ReqSledExchangeOption option = new ReqSledExchangeOption();
		option.setCnNamePartical(exchangeCnName);
		SledExchangePage exchangePage = mContractServiceStub.reqSledExchange(option, 0, 1);
//		AppLog.i("SledSimulateEnvCommodityAdmin ---- getExchangeMicByCnName ---- exchangePage : "
//				+ exchangePage.getPageSize());
		if (exchangePage != null && exchangePage.getPageSize() > 0) {
			return exchangePage.getPage().get(0).getExchangeMic();
		}
		return "";
	}

	private int querySimulateEnvCommodityList(int pageIndex, String exchangeMic, String commodityCode,
			String commodityCnName) throws ErrorInfo, TException {

		if (mContractServiceStub == null) {
			mContractServiceStub = new ContractServiceStub();
		}

		ReqSledCommodityOption option = new ReqSledCommodityOption();

		if (exchangeMic != null && !exchangeMic.isEmpty()) {
			option.setExchangeMic(exchangeMic);
		}
		if (commodityCnName != null && !commodityCnName.isEmpty()) {
			option.setCnNamePartical(commodityCnName);
		}
		if (commodityCode != null && !commodityCode.isEmpty()) {
			option.setSledCommodityCodePartical(commodityCode);
		}

		SledCommodityEditPage sledCommodityEditPage = mContractServiceStub.reqSledCommodity(option, 0, PAGE_SIZE_MAX);

		AppLog.i("SledSimulateEnvCommodityAdmin ---- querySimulateEnvCommodityList ---- pageIndex : " + pageIndex
				+ ", sledCommodityEditPage : " + sledCommodityEditPage.getPageSize());

		List<LocalSimulateEnvCommodity> localSimulateEnvCommodityList = new ArrayList<LocalSimulateEnvCommodity>();
		int simulateEnvCommodityIndex = 0;

//		AppLog.i("SledSimulateEnvCommodityAdmin ---- querySimulateEnvCommodityList ---- (pageIndex * PAGE_SIZE) : "
//				+ (pageIndex * PAGE_SIZE) + ", ((pageIndex + 1) * PAGE_SIZE) : " + ((pageIndex + 1) * PAGE_SIZE));

		for (SledCommodityEdit sledCommodityEdit : sledCommodityEditPage.getPage()) {
			if (sledCommodityEdit.getSledCommodity().isAlsoSupportSim) {
				if (simulateEnvCommodityIndex >= (pageIndex * PAGE_SIZE)
						&& simulateEnvCommodityIndex < ((pageIndex + 1) * PAGE_SIZE)) {
					localSimulateEnvCommodityList
							.add(getLocalSimulateEnvCommodity(sledCommodityEdit.getSledCommodity()));
					AppLog.i(
							"SledSimulateEnvCommodityAdmin ---- querySimulateEnvCommodityList ---- simulateEnvCommodityIndex : "
									+ simulateEnvCommodityIndex);
				}
				simulateEnvCommodityIndex++;
			}
		}

		put("localSimulateEnvCommodityList", localSimulateEnvCommodityList);

		mTotalNum = simulateEnvCommodityIndex;

		mTotalPage = (mTotalNum + PAGE_SIZE - 1) / PAGE_SIZE;
		return pageIndex > mTotalPage ? mTotalPage : pageIndex;
	}

	private LocalSimulateEnvCommodity getLocalSimulateEnvCommodity(SledCommodity sledCommodity)
			throws ErrorInfo, TException {

		LocalSimulateEnvCommodity localSimulateEnvCommodity = new LocalSimulateEnvCommodity();

		localSimulateEnvCommodity.setSledCommodityId(sledCommodity.getSledCommodityId());
		localSimulateEnvCommodity.setSledCommodityCode(sledCommodity.getSledCommodityCode());
		localSimulateEnvCommodity.setSledCommodityType(sledCommodity.getSledCommodityType().name());
		localSimulateEnvCommodity.setSledCommodityCnName(sledCommodity.getCnName());
		localSimulateEnvCommodity.setExchangeMic(sledCommodity.getExchangeMic());
		localSimulateEnvCommodity.setExchangeCnName(getExchangeCnNameByMic(sledCommodity.getExchangeMic()));
		return localSimulateEnvCommodity;
	}

	private String getExchangeCnNameByMic(String exchangeMic) throws ErrorInfo, TException {
		if (mContractServiceStub == null) {
			mContractServiceStub = new ContractServiceStub();
		}
		ReqSledExchangeOption option = new ReqSledExchangeOption();
		option.setExchangeMic(exchangeMic);
		SledExchangePage exchangePage = mContractServiceStub.reqSledExchange(option, 0, 1);
//		AppLog.i("SledSimulateEnvCommodityAdmin ---- getExchangeCnNameByMic ---- exchangePage : "
//				+ exchangePage.getPageSize());
		if (exchangePage != null && exchangePage.getPageSize() > 0) {
			return exchangePage.getPage().get(0).getCnName();
		}
		return "";
	}

	public void getSimulateEnvCommoditySelectionInfo() throws IOException {
		ErrorResult result = new ErrorResult();

		String exchangeMic = parameter("exchangeMic", "");
		String sledCommodityType = parameter("sledCommodityType", "FUTURES");

		if (sledCommodityType == null || sledCommodityType.isEmpty()) {
			sledCommodityType = "FUTURES";
		}

		AppLog.i("SledSimulateEnvCommodityAdmin ---- getSimulateEnvCommoditySelectionInfo ---- exchangeMic : "
				+ exchangeMic + ", sledCommodityType : " + sledCommodityType);

		if (mContractServiceStub == null) {
			mContractServiceStub = new ContractServiceStub();
		}

		LocalTradeTimeSelectionInfo localTradeTimeSelectionInfo = new LocalTradeTimeSelectionInfo();

		// get exchange list
		ReqSledExchangeOption reqSledExchangeOption = new ReqSledExchangeOption();
		try {
			SledExchangePage exchangePage = mContractServiceStub.reqSledExchange(reqSledExchangeOption, 0,
					PAGE_SIZE_MAX);
			if (exchangePage.getPageSize() > 0) {
				List<LocalExchange> exchangeList = new ArrayList<LocalExchange>();
				for (SledExchange sledExchange : exchangePage.getPage()) {
					LocalExchange localExchange = new LocalExchange();
					localExchange.setExchangeMic(sledExchange.getExchangeMic());
					localExchange.setCnName(sledExchange.getCnName());
					localExchange.setAcronym(sledExchange.getAcronym());
					localExchange.setCnAcronym(sledExchange.getCnAcronym());
					exchangeList.add(localExchange);
				}
				localTradeTimeSelectionInfo.setExchangeList(exchangeList);
			} else {
				result.setErrorCode(6);
				result.setErrorMsg("查到交易所数量为0");
				echoJson(result);
				return;
			}
		} catch (ErrorInfo errorInfo) {
			errorInfo.printStackTrace();
			result.setErrorCode(errorInfo.getErrorCode());
			result.setErrorMsg(errorInfo.getErrorMsg());
			echoJson(result);
			return;
		} catch (Throwable e) {
			e.printStackTrace();
			result.setErrorCode(5);
			result.setErrorMsg("服务器繁忙");
			echoJson(result);
			return;
		}

		if (exchangeMic == null || exchangeMic.isEmpty()) {
			exchangeMic = localTradeTimeSelectionInfo.getExchangeList().get(0).getExchangeMic();
		}

//		AppLog.i("SledSimulateEnvCommodityAdmin ---- getSimulateEnvCommoditySelectionInfo ---- exchangeMic : "
//				+ exchangeMic);

		// get exchange
		localTradeTimeSelectionInfo.setExchangeMic(exchangeMic);

		// get commodity type
		localTradeTimeSelectionInfo.setSledCommodityType(sledCommodityType);

		// get commodities
		ReqSledCommodityOption reqSledCommodityOption = new ReqSledCommodityOption();
		reqSledCommodityOption.setExchangeMic(exchangeMic);
		reqSledCommodityOption.setSledCommodityType(SledCommodityType.valueOf(sledCommodityType));

		try {
			SledCommodityEditPage sledCommodityEditPage = mContractServiceStub.reqSledCommodity(reqSledCommodityOption,
					0, PAGE_SIZE_MAX);
			List<LocalSimpleCommodity> localSimpleCommodityList = new ArrayList<LocalSimpleCommodity>();

			if (sledCommodityEditPage.getPageSize() > 0) {
				for (SledCommodityEdit sledCommodityEdit : sledCommodityEditPage.getPage()) {
					if (!sledCommodityEdit.getSledCommodity().isAlsoSupportSim) {
						SledCommodity sledCommodity = sledCommodityEdit.getSledCommodity();

						LocalSimpleCommodity localSimpleCommodity = new LocalSimpleCommodity();
						localSimpleCommodity.setSledCommodityId(String.valueOf(sledCommodity.getSledCommodityId()));
						localSimpleCommodity.setCnName(sledCommodity.getCnName());
						localSimpleCommodity.setSledCommodityCode(sledCommodity.getSledCommodityCode());

						localSimpleCommodityList.add(localSimpleCommodity);
					}
				}
			}

			// get commodities
			localTradeTimeSelectionInfo.setLocalSimpleCommodityList(localSimpleCommodityList);

		} catch (ErrorInfo errorInfo) {
			errorInfo.printStackTrace();
			result.setErrorCode(errorInfo.getErrorCode());
			result.setErrorMsg(errorInfo.getErrorMsg());
			echoJson(result);
			return;
		} catch (Throwable e) {
			e.printStackTrace();
			result.setErrorCode(5);
			result.setErrorMsg("服务器繁忙");
			echoJson(result);
			return;
		}

//		AppLog.i(
//				"SledSimulateEnvCommodityAdmin ---- getSimulateEnvCommoditySelectionInfo ---- localTradeTimeSelectionInfo : "
//						+ localTradeTimeSelectionInfo.toString());
		echoJson(localTradeTimeSelectionInfo);
	}

	public void addSimulateEnvCommodity() throws IOException {
		ErrorResult result = new ErrorResult();

		if (mContractServiceStub == null) {
			mContractServiceStub = new ContractServiceStub();
		}

		try {
			String content = StringFactory.newUtf8String(IOUtils.toByteArray(getServletRequest().getInputStream()));

			AppLog.i("SledSimulateEnvCommodityAdmin ---- addSimulateEnvCommodity ---- content : " + content);

			SimulateEnvCommodityInfo simulateEnvCommodityInfo = GsonFactory.getGson().fromJson(content, SimulateEnvCommodityInfo.class);

			if (simulateEnvCommodityInfo != null && simulateEnvCommodityInfo.getCommodityIds().size() > 0) {
				SledCommodity sledCommodity = new SledCommodity();
				for (int commodityId : simulateEnvCommodityInfo.getCommodityIds()) {
					sledCommodity.setSledCommodityId(commodityId);
					sledCommodity.setIsAlsoSupportSim(true);
					mContractServiceStub.updateSledCommodity(sledCommodity);
				}
			}

		} catch (ErrorInfo errorInfo) {
			errorInfo.printStackTrace();
			result.setErrorCode(errorInfo.getErrorCode());
			result.setErrorMsg(errorInfo.getErrorMsg());
			echoJson(result);
			return;
		} catch (Throwable e) {
			e.printStackTrace();
			result.setErrorCode(5);
			result.setErrorMsg("服务器繁忙");
			echoJson(result);
			return;
		}
		echoJson(result);
	}
	
	public void deleteSimulateEnvCommodity() throws IOException {
		ErrorResult result = new ErrorResult();
		
		int sledCommodityId = parameter("sledCommodityId", 0);
		AppLog.i("SledSimulateEnvCommodityAdmin ---- deleteSimulateEnvCommodity ---- sledCommodityId : " + sledCommodityId);

		if (sledCommodityId <= 0) {
			result.setErrorCode(2);
			result.setErrorMsg("获取不到商品Id，删除失败");
			echoJson(result);
			return;
		}
		
		if (mContractServiceStub == null) {
			mContractServiceStub = new ContractServiceStub();
		}
		
		try {
			SledCommodity sledCommodity = new SledCommodity();
			sledCommodity.setSledCommodityId(sledCommodityId);
			sledCommodity.setIsAlsoSupportSim(false);
			
			mContractServiceStub.updateSledCommodity(sledCommodity);
		} catch(ErrorInfo errorInfo) {
			errorInfo.printStackTrace();
			result.setErrorCode(errorInfo.getErrorCode());
			result.setErrorMsg(errorInfo.getErrorMsg());
			echoJson(result);
			return;
		} catch (Throwable e) {
			e.printStackTrace();
			result.setErrorCode(5);
			result.setErrorMsg("服务器繁忙");
			echoJson(result);
			return;
		}
		
		echoJson(result);
	}

	private class SimulateEnvCommodityInfo {
		List<Integer> commodityIds;

		public List<Integer> getCommodityIds() {
			return commodityIds;
		}

		public void setCommodityIds(List<Integer> commodityIds) {
			this.commodityIds = commodityIds;
		}
	}
}
