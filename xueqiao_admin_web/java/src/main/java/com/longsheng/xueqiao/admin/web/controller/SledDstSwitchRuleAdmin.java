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

import com.longsheng.xueqiao.admin.bean.LocalDstTransferConfig;
import com.longsheng.xueqiao.admin.bean.LocalExchange;
import com.longsheng.xueqiao.admin.bean.LocalSimpleCommodity;
import com.longsheng.xueqiao.admin.bean.tradetime.LocalTradeTimeSelectionInfo;
import com.longsheng.xueqiao.contract.standard.thriftapi.ReqSledCommodityOption;
import com.longsheng.xueqiao.contract.standard.thriftapi.ReqSledExchangeOption;
import com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodity;
import com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodityType;
import com.longsheng.xueqiao.contract.standard.thriftapi.SledExchange;
import com.longsheng.xueqiao.contract.standard.thriftapi.SledExchangePage;
import com.longsheng.xueqiao.contract.thriftapi.DstTransferConfig;
import com.longsheng.xueqiao.contract.thriftapi.DstTransferConfigPage;
import com.longsheng.xueqiao.contract.thriftapi.RemoveDstTransferConfigOption;
import com.longsheng.xueqiao.contract.thriftapi.ReqDstTransferConfigOption;
import com.longsheng.xueqiao.contract.thriftapi.SledCommodityEdit;
import com.longsheng.xueqiao.contract.thriftapi.SledCommodityEditPage;
import com.longsheng.xueqiao.contract.thriftapi.client.ContractServiceStub;

public class SledDstSwitchRuleAdmin extends AbstractDBLockController {
	ContractServiceStub mContractServiceStub = new ContractServiceStub();

//	private static SimpleDateFormat dateSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//	private static SimpleDateFormat dateSimpleTimeFormat = new SimpleDateFormat("HH:mm:ss");

//	private static final String BEIJING_TIME_ZONE = "UTC+8";

//	private static final int ONE_DATE_TIMESTAMP = 1000 * 60 * 60 * 24 - 1;
	private static final int PAGE_SIZE = 10;
	private static final int PAGE_SIZE_MAX = Integer.MAX_VALUE;
	
	private int mTotalPage = 1;
	private int mTotalNum = 0;

	public void show() throws Exception {

		getModuleLockStatus(ModuleType.MM_CONTRACT);

		int requestPage = parameter("requestPage", 1);
		
		String exchangeMic = parameter("exchangeMic", "");
		String sledCommodityType = parameter("sledCommodityType", "");
		String commodityCnName = parameter("commodityCnName", "");
		
		AppLog.i("SledDstSwitchRuleAdmin ---- show ---- requestPage : " + requestPage + ", exchangeMic : " + exchangeMic + ", sledCommodityType : " + sledCommodityType + ", commodityCnName : " + commodityCnName);
		if (requestPage < 1) {
			requestPage = 1;
		}
		requestPage = queryDstTransferConfig(exchangeMic, sledCommodityType, commodityCnName, requestPage - 1);

		if (mTotalPage < 1) {
			mTotalPage = 1;
		}
		put("currentPage", requestPage + 1);
		put("totalPage", mTotalPage);
		put("totalNum", mTotalNum);
		
		setBaseQueryUrl(exchangeMic, sledCommodityType, commodityCnName);
		render("sled_dst_switch_rule_admin.html");
	}
	
	private void setBaseQueryUrl(String exchangeMic, String sledCommodityType, String commodityCnName) {
		StringBuffer baseQueryUrl = new StringBuffer();
		String baseUrl = this.baseUrl;
		int l = baseUrl.indexOf("requestPage");
		if (l > 0) {
			baseUrl = baseUrl.substring(0, l);
		}
		baseQueryUrl.append(baseUrl);
		baseQueryUrl.append("/SledDstSwitchRuleAdmin/show?exchangeMic=").append(exchangeMic);
		baseQueryUrl.append("&sledCommodityType=").append(sledCommodityType);
		baseQueryUrl.append("&commodityCnName=").append(commodityCnName);
		baseQueryUrl.append("&");
		put("baseQueryUrl", baseQueryUrl);
	}
	
	private int queryDstTransferConfig(String exchangeMic, String sledCommodityType, String commodityCnName, int pageIndex) throws ErrorInfo, TException {
		
		if (mContractServiceStub == null) {
			mContractServiceStub = new ContractServiceStub();
		}
		
		ReqDstTransferConfigOption reqDstTransferConfigOption = new ReqDstTransferConfigOption();
		
		DstTransferConfigPage dstTransferConfigPage = mContractServiceStub.reqDstTransferConfig(reqDstTransferConfigOption, 0, PAGE_SIZE_MAX);
		
		List<LocalDstTransferConfig> localDstTransferConfigList = dstTransferConfigFilter(dstTransferConfigPage, exchangeMic, sledCommodityType, commodityCnName);
		
		List<LocalDstTransferConfig> localDstTransferConfigListResult = new ArrayList<LocalDstTransferConfig>();
		
		if (((pageIndex + 1) * PAGE_SIZE) <= localDstTransferConfigList.size()) {
			for (int index = pageIndex * PAGE_SIZE; index < ((pageIndex + 1) * PAGE_SIZE); index++) {
				localDstTransferConfigListResult.add(localDstTransferConfigList.get(index));
			}
		} else if ((pageIndex * PAGE_SIZE) < localDstTransferConfigList.size()) {
			for (int index = pageIndex * PAGE_SIZE; index < localDstTransferConfigList.size(); index++) {
				localDstTransferConfigListResult.add(localDstTransferConfigList.get(index));
			}
		}
		
		put("dstTransferConfigList", localDstTransferConfigListResult);
		
		mTotalNum = localDstTransferConfigList.size();
		mTotalPage = (mTotalNum + PAGE_SIZE - 1) / PAGE_SIZE;
		return pageIndex > mTotalPage ? mTotalPage : pageIndex;
	}
	
	private List<LocalDstTransferConfig> dstTransferConfigFilter(DstTransferConfigPage dstTransferConfigPage, String exchangeMic, String sledCommodityType, String commodityCnName) {
		List<LocalDstTransferConfig> localDstTransferConfigFilterList = new ArrayList<LocalDstTransferConfig>();
		List<LocalDstTransferConfig> localDstTransferConfigList = LocalDstTransferConfig.transferToLocalDstTransferConfigList(dstTransferConfigPage.getPage());
		
		if (commodityCnName != null && !commodityCnName.isEmpty()) {
			for (LocalDstTransferConfig localDstTransferConfig : localDstTransferConfigList) {
				if (localDstTransferConfig.getSledCommodityNames().contains(commodityCnName)) {
					localDstTransferConfigFilterList.add(localDstTransferConfig);
					break;
				}
			}
			return localDstTransferConfigFilterList;
		}
		
		if (!exchangeMic.isEmpty() && sledCommodityType.isEmpty()) {
			for (LocalDstTransferConfig localDstTransferConfig : localDstTransferConfigList) {
				if (localDstTransferConfig.getExchangeMic().equals(exchangeMic)) {
					localDstTransferConfigFilterList.add(localDstTransferConfig);
					break;
				}
			}
			return localDstTransferConfigFilterList;
		}
		
		if (exchangeMic.isEmpty() && !sledCommodityType.isEmpty()) {
			for (LocalDstTransferConfig localDstTransferConfig : localDstTransferConfigList) {
				if (localDstTransferConfig.getSledCommodityType().equals(sledCommodityType)) {
					localDstTransferConfigFilterList.add(localDstTransferConfig);
				}
			}
			return localDstTransferConfigFilterList;
		}
		
		if (!exchangeMic.isEmpty() && !sledCommodityType.isEmpty()) {
			for (LocalDstTransferConfig localDstTransferConfig : localDstTransferConfigList) {
				if (localDstTransferConfig.getExchangeMic().equals(exchangeMic) && localDstTransferConfig.getSledCommodityType().equals(sledCommodityType)) {
					localDstTransferConfigFilterList.add(localDstTransferConfig);
				}
			}
			return localDstTransferConfigFilterList;
		}
		
		return localDstTransferConfigList;
	}
	
	public void getDstTransferConfigSelectionInfo() throws IOException {
		ErrorResult result = new ErrorResult();

		String exchangeMic = parameter("exchangeMic", "");
		String sledCommodityType = parameter("sledCommodityType", "FUTURES");
		
		if (sledCommodityType == null || sledCommodityType.isEmpty()) {
			sledCommodityType = "FUTURES";
		}
		
		AppLog.i("SledDstSwitchRuleAdmin ---- getDstTransferConfigSelectionInfo ---- exchangeMic : " + exchangeMic + ", sledCommodityType : " + sledCommodityType);
		
		if (mContractServiceStub == null) {
			mContractServiceStub = new ContractServiceStub();
		}
		
		LocalTradeTimeSelectionInfo localTradeTimeSelectionInfo = new LocalTradeTimeSelectionInfo();
		
		// get exchange list
		ReqSledExchangeOption reqSledExchangeOption = new ReqSledExchangeOption();
		try {
			SledExchangePage exchangePage = mContractServiceStub.reqSledExchange(reqSledExchangeOption, 0, PAGE_SIZE_MAX);
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
		
		if (exchangeMic == null || exchangeMic.isEmpty()) {
			exchangeMic = localTradeTimeSelectionInfo.getExchangeList().get(0).getExchangeMic();
		}
		
		AppLog.i("SledDstSwitchRuleAdmin ---- getDstTransferConfigSelectionInfo ---- exchangeMic : " + exchangeMic);
		
		// get exchange
		localTradeTimeSelectionInfo.setExchangeMic(exchangeMic);
		
		// get commodity type
		localTradeTimeSelectionInfo.setSledCommodityType(sledCommodityType);
		
		// get commodities
		ReqSledCommodityOption reqSledCommodityOption = new ReqSledCommodityOption();
		reqSledCommodityOption.setExchangeMic(exchangeMic);
		reqSledCommodityOption.setSledCommodityType(SledCommodityType.valueOf(sledCommodityType));
		
		try {
			SledCommodityEditPage sledCommodityEditPage = mContractServiceStub.reqSledCommodity(reqSledCommodityOption, 0, PAGE_SIZE_MAX);
			List<LocalSimpleCommodity> localSimpleCommodityList = new ArrayList<LocalSimpleCommodity>();
			
			if (sledCommodityEditPage.getPageSize() > 0) {
				for (SledCommodityEdit sledCommodityEdit : sledCommodityEditPage.getPage()) {
					SledCommodity sledCommodity = sledCommodityEdit.getSledCommodity();
					
					LocalSimpleCommodity localSimpleCommodity = new LocalSimpleCommodity();
					localSimpleCommodity.setSledCommodityId(String.valueOf(sledCommodity.getSledCommodityId()));
					localSimpleCommodity.setCnName(sledCommodity.getCnName());
					localSimpleCommodity.setSledCommodityCode(sledCommodity.getSledCommodityCode());
					
					localSimpleCommodityList.add(localSimpleCommodity);
				}
			}
			
			//get commodities 
			localTradeTimeSelectionInfo.setLocalSimpleCommodityList(localSimpleCommodityList);
			
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
		
		AppLog.i("SledDstSwitchRuleAdmin ---- getDstTransferConfigSelectionInfo ---- localTradeTimeSelectionInfo : " + localTradeTimeSelectionInfo.toString());
		echoJson(localTradeTimeSelectionInfo);
	}
	
	public void addDstTransferConfig() throws IOException {
		ErrorResult result = new ErrorResult();
		
		if (mContractServiceStub == null) {
			mContractServiceStub = new ContractServiceStub();
		}
		
		try {
			String content = StringFactory.newUtf8String(IOUtils.toByteArray(getServletRequest().getInputStream()));

			AppLog.i("SledDstSwitchRuleAdmin ---- addDstTransferConfig ---- content : " + content);

			LocalDstTransferConfig localDstTransferConfig = GsonFactory.getGson().fromJson(content, LocalDstTransferConfig.class);
			
			AppLog.i("SledDstSwitchRuleAdmin ---- addDstTransferConfig ---- localDstTransferConfig is not null : " + (localDstTransferConfig != null));

			if (mContractServiceStub == null) {
				mContractServiceStub = new ContractServiceStub();
			}

			DstTransferConfig dstTransferConfig = new DstTransferConfig();
			
			if (localDstTransferConfig.getExchangeMic() != null && !localDstTransferConfig.getExchangeMic().isEmpty()) {
				List<String> exchangeMics = new ArrayList<String>();
				exchangeMics.add(localDstTransferConfig.getExchangeMic());
				dstTransferConfig.setExchangeMics(exchangeMics);
			} else {
				result.setErrorCode(7);
				result.setErrorMsg("获取交易所信息失败");
				echoJson(result);
				return;
			}
			
			if (localDstTransferConfig.getSledCommodityType() != null && !localDstTransferConfig.getSledCommodityType().isEmpty()) {
				List<String> sledCommodityTypes = new ArrayList<String>();
				sledCommodityTypes.add(localDstTransferConfig.getSledCommodityType());
				dstTransferConfig.setSledCommodityTypes(sledCommodityTypes);
			} else {
				result.setErrorCode(7);
				result.setErrorMsg("获取商品类型信息失败");
				echoJson(result);
				return;
			}
			
			if (localDstTransferConfig.getCommodityIds().size() > 0) {
				dstTransferConfig.setCommodityIds(localDstTransferConfig.getCommodityIds());
				
				ReqSledCommodityOption reqSledCommodityOption = new ReqSledCommodityOption();
				reqSledCommodityOption.setSledCommodityIdList(localDstTransferConfig.getCommodityIds());
				SledCommodityEditPage sledCommodityEditPage = mContractServiceStub.reqSledCommodity(reqSledCommodityOption, 0, PAGE_SIZE_MAX);
				
				List<String> sledCommodityNames = new ArrayList<String>();
				for (SledCommodityEdit sledCommodityEdit : sledCommodityEditPage.getPage()) {
					sledCommodityNames.add(sledCommodityEdit.getSledCommodity().getCnName());
				}
				dstTransferConfig.setSledCommodityNames(sledCommodityNames);
				
			} else {
				result.setErrorCode(7);
				result.setErrorMsg("商品个数为0，添加失败");
				echoJson(result);
				return;
			}
			
			// minus : previous
			dstTransferConfig.setStandard2DstOffSetMinute(localDstTransferConfig.getStandard2DstOffSetMinute() * -1);
			
			mContractServiceStub.addDstTransferConfig(dstTransferConfig);


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
	
	public void deleteDstTransferConfig() throws IOException {
		ErrorResult result = new ErrorResult();
		
		int dstTransferConfigId = parameter("dstTransferConfigId", 0);
		AppLog.i("SledSpecTradeTimeAdmin ---- deleteSpecTradeTime ---- dstTransferConfigId : " + dstTransferConfigId);

		if (dstTransferConfigId <= 0) {
			result.setErrorCode(2);
			result.setErrorMsg("获取不到dstTransferConfigId，删除失败");
			echoJson(result);
			return;
		}
		
		if (mContractServiceStub == null) {
			mContractServiceStub = new ContractServiceStub();
		}
		
		try {
			RemoveDstTransferConfigOption removeDstTransferConfigOption = new RemoveDstTransferConfigOption();
			List<Integer> dstTransferConfigIds = new ArrayList<Integer>();
			dstTransferConfigIds.add(dstTransferConfigId);
			removeDstTransferConfigOption.setDstTransferConfigIds(dstTransferConfigIds);
			mContractServiceStub.removeDstTransferConfig(removeDstTransferConfigOption);
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
}
