package com.longsheng.xueqiao.admin.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.thrift.TException;
import org.soldier.base.StringFactory;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.page.IndexedPageOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.web_framework.model.ErrorResult;
import org.soldier.platform.web_framework.util.GsonFactory;

import com.antiy.error_code.ErrorCodeOuter;
import com.longsheng.xueqiao.admin.bean.LocalCommodity;
import com.longsheng.xueqiao.admin.bean.LocalCommodityConfig;
import com.longsheng.xueqiao.admin.bean.LocalCommodityMappingInfo;
import com.longsheng.xueqiao.admin.bean.LocalTechPlatformCommodity;
import com.longsheng.xueqiao.admin.util.CityTimeZoneMapping;
import com.longsheng.xueqiao.admin.web.controller.AbstractDBLockController.ModuleType;
import com.longsheng.xueqiao.broker.dao.thriftapi.client.BrokerDaoServiceStub;
import com.longsheng.xueqiao.contract.standard.thriftapi.CmbDirect;
import com.longsheng.xueqiao.contract.standard.thriftapi.CommodityState;
//import com.longsheng.xueqiao.contract.standard.thriftapi.CoverMode;
import com.longsheng.xueqiao.contract.standard.thriftapi.DeliveryMode;
//import com.longsheng.xueqiao.contract.standard.thriftapi.DepositCalculateMode;
//import com.longsheng.xueqiao.contract.standard.thriftapi.OpenCloseMode;
import com.longsheng.xueqiao.contract.standard.thriftapi.ReqSledCommodityOption;
//import com.longsheng.xueqiao.contract.standard.thriftapi.SledBaseCommodity;
import com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodity;
import com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodityConfig;
import com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodityPage;
import com.longsheng.xueqiao.contract.standard.thriftapi.SledExchange;
import com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatform;
import com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv;
import com.longsheng.xueqiao.contract.thriftapi.CommodityMappingEditPage;
import com.longsheng.xueqiao.contract.thriftapi.CommoditySourceAccount;
import com.longsheng.xueqiao.contract.thriftapi.CommoditySourceAccountPage;
import com.longsheng.xueqiao.contract.thriftapi.RemoveSpecTradeTimeOption;
import com.longsheng.xueqiao.contract.thriftapi.ReqCommodityMappingEditOption;
import com.longsheng.xueqiao.contract.thriftapi.ReqCommoditySourceAccountOption;
import com.longsheng.xueqiao.contract.thriftapi.ReqTechPlatformCommodityOption;
import com.longsheng.xueqiao.contract.thriftapi.SledCommodityEditPage;
import com.longsheng.xueqiao.contract.thriftapi.TechPlatformCommodityPage;
import com.longsheng.xueqiao.contract.thriftapi.client.ContractServiceStub;

public class SledCommodityDetail extends AbstractDBLockController {

	private static final int TIME_OUT = 3000;
	private static final int PAGE_SIZE = 10;
	private static final int PAGE_SIZE_MAX = Integer.MAX_VALUE;
	
	ContractServiceStub mContractServiceStub = new ContractServiceStub();
	
	private int mCommoditySourceAccountEs3BrokerId = -1;

	public void show() throws Exception {

		int sledCommodityId = parameter("sledCommodityId", 0);
		String exchangeMic = parameter("exchangeMic", "");
		String commodityType = parameter("commodityType", "");
		String exchangeCNName = parameter("exchangeCNName", "");

		if (sledCommodityId <= 0) {
			return;
		}

		queryCommodityById(sledCommodityId);
		queryTechPlatformCommodityById(sledCommodityId);

		getModuleLockStatus(ModuleType.MM_CONTRACT);
		
		getZoneIdList();
		
		put("exchangeMic", exchangeMic);
		put("commodityType", commodityType);
		put("exchangeCNName", exchangeCNName);
		
		render("sled_commodity_detail.html");
	}

	private void queryCommodityById(int sledCommodityId) throws ErrorInfo, TException {
		ContractServiceStub stub = new ContractServiceStub();
		ReqSledCommodityOption commodityOption = new ReqSledCommodityOption();
//		SledBaseCommodity baseCommodity = new SledBaseCommodity();
		List<Integer> sledCommodityIdList = new ArrayList<Integer>();
		sledCommodityIdList.add(sledCommodityId);
		commodityOption.setSledCommodityIdList(sledCommodityIdList);
//		commodityOption.setSledBaseCommodity(baseCommodity);
		SledCommodityEditPage sledCommodityEditPage = stub.reqSledCommodity(RandomUtils.nextInt(), TIME_OUT, commodityOption, 0, 1);

		AppLog.i("SledCommodityDetail ---- queryCommodityById ---- sledCommodityEditPage : " + sledCommodityEditPage.toString());
		
		if (sledCommodityEditPage != null && sledCommodityEditPage.getTotal() > 0) {
			AppLog.i("SledCommodityDetail ---- queryCommodityById ---- getTotal : " + sledCommodityEditPage.getTotal());
			LocalCommodity localCommodity = LocalCommodity.transferToLocalCommodity(stub, sledCommodityEditPage.getPage().get(0), true);
			LocalCommodityConfig localCommodityConfig = null;
			if (localCommodity.getLocalCommodityConfigList().size() > 0) {
				localCommodityConfig = localCommodity.getLocalCommodityConfigList().get(0);
			} else {
				localCommodityConfig = new LocalCommodityConfig();
			}

			put("sledCommodity", localCommodity);
			put("localCommodityConfig", localCommodityConfig);
			
			queryCommodityMappingById(sledCommodityEditPage.getPage().get(0).getSledCommodity());
		}
	}
	
	private void getZoneIdList() {
		List<String> zoneIdList = CityTimeZoneMapping.getInstance().getZoneList();
		put("zoneIdList", zoneIdList);
//		AppLog.i("SledCommodityDetail ---- getZoneIdList ---- zoneIdList size : " + zoneIdList.size() + ", zoneId 0 : " + zoneIdList.get(0));
	}
	
	private void queryTechPlatformCommodityById(int sledCommodityId) throws ErrorInfo, TException {
		ContractServiceStub stub = new ContractServiceStub();
		
		ReqTechPlatformCommodityOption option = new ReqTechPlatformCommodityOption();
		List<Integer> sledCommodityIds = new ArrayList<Integer>();
		sledCommodityIds.add(sledCommodityId);
		option.setSledCommodityIds(sledCommodityIds);
		
		TechPlatformCommodityPage techPlatformCommodityPage = stub.reqTechPlatformCommodity(option, 0, 1);
		
		AppLog.i("SledCommodityDetail ---- queryTechPlatformCommodityById ---- techPlatformCommodityPage : " + techPlatformCommodityPage.toString());
		
		if (techPlatformCommodityPage != null && techPlatformCommodityPage.getPageSize() > 0) {
			put("techPlatformCommodity", LocalTechPlatformCommodity.transferToLocalCommodity(techPlatformCommodityPage.getPage().get(0)));
		} else {
			put("techPlatformCommodity", new LocalTechPlatformCommodity());
		}
	}
	
	private void queryCommodityMappingById(SledCommodity sledCommodity) throws ErrorInfo, TException {
		
		LocalCommodityMappingInfo localCommodityMappingInfo = new LocalCommodityMappingInfo();
		localCommodityMappingInfo.setSledExchangeMic(sledCommodity.getExchangeMic());
		localCommodityMappingInfo.setSledCommodityCode(sledCommodity.getSledCommodityCode());
		localCommodityMappingInfo.setSledCommodityType(sledCommodity.getSledCommodityType().name());
		
		ContractServiceStub stub = new ContractServiceStub();
		ReqCommodityMappingEditOption reqCommodityMappingEditOption = new ReqCommodityMappingEditOption();
		reqCommodityMappingEditOption.setTechPlatform(TechPlatform.CTP);
		
		List<Integer> sledCommodityIdList = new ArrayList<Integer>();
		sledCommodityIdList.add(sledCommodity.getSledCommodityId());
		reqCommodityMappingEditOption.setSledCommodityIdList(sledCommodityIdList);

		reqCommodityMappingEditOption.setTechPlatform(TechPlatform.CTP);
		CommodityMappingEditPage ctpCommodityMappingEditPage = stub.reqCommodityMapping(reqCommodityMappingEditOption, 0, PAGE_SIZE_MAX);
		AppLog.i("SledCommodityDetail ---- queryCommodityMappingById ---- ctpCommodityMappingEditPage : " + ctpCommodityMappingEditPage.toString());
		if (ctpCommodityMappingEditPage.getPageSize() > 0) {
			localCommodityMappingInfo.setCtpCommodityCode(ctpCommodityMappingEditPage.getPage().get(0).getCommodityMapping().getCommodityCode());
			localCommodityMappingInfo.setCtpCommodityType(ctpCommodityMappingEditPage.getPage().get(0).getCommodityMapping().getCommodityType());
			localCommodityMappingInfo.setCtpExchange(ctpCommodityMappingEditPage.getPage().get(0).getCommodityMapping().getExchange());
			localCommodityMappingInfo.setCtpMoneyRatio(String.valueOf(ctpCommodityMappingEditPage.getPage().get(0).getCommodityMapping().getMoneyRatio()));
			
			localCommodityMappingInfo.setMappingPlatform("CTP");
			
			put("localCommodityMappingInfo", localCommodityMappingInfo);
			
			return;
		}
		
		reqCommodityMappingEditOption.setTechPlatform(TechPlatform.ESUNNY);
		CommodityMappingEditPage es9CommodityMappingEditPage = stub.reqCommodityMapping(reqCommodityMappingEditOption, 0, PAGE_SIZE_MAX);
		AppLog.i("SledCommodityDetail ---- queryCommodityMappingById ---- es9CommodityMappingEditPage : " + es9CommodityMappingEditPage.toString());
		if (es9CommodityMappingEditPage.getPageSize() <= 0) {
			return;
		}
		
		if (mCommoditySourceAccountEs3BrokerId < 0) {
			mCommoditySourceAccountEs3BrokerId = queryCommoditySourceAccountEs3BrokerId();
		}
		reqCommodityMappingEditOption.setTechPlatform(TechPlatform.ESUNNY_3);
		reqCommodityMappingEditOption.setBrokerEntryId(mCommoditySourceAccountEs3BrokerId);
		CommodityMappingEditPage es3CommodityMappingEditPage = stub.reqCommodityMapping(reqCommodityMappingEditOption, 0, PAGE_SIZE_MAX);
		AppLog.i("SledCommodityDetail ---- queryCommodityMappingById ---- mCommoditySourceAccountEs3BrokerId : " + mCommoditySourceAccountEs3BrokerId + ", es3CommodityMappingEditPage : " + es3CommodityMappingEditPage.toString());
		if (es3CommodityMappingEditPage.getPageSize() > 0) {
			localCommodityMappingInfo.setEs3CommodityCode(es3CommodityMappingEditPage.getPage().get(0).getCommodityMapping().getCommodityCode());
			localCommodityMappingInfo.setEs3CommodityType(es3CommodityMappingEditPage.getPage().get(0).getCommodityMapping().getCommodityType());
			localCommodityMappingInfo.setEs3Exchange(es3CommodityMappingEditPage.getPage().get(0).getCommodityMapping().getExchange());
			localCommodityMappingInfo.setEs3MoneyRatio(String.valueOf(es3CommodityMappingEditPage.getPage().get(0).getCommodityMapping().getMoneyRatio()));
			
			localCommodityMappingInfo.setEs9CommodityCode(es9CommodityMappingEditPage.getPage().get(0).getCommodityMapping().getCommodityCode());
			localCommodityMappingInfo.setEs9CommodityType(es9CommodityMappingEditPage.getPage().get(0).getCommodityMapping().getCommodityType());
			localCommodityMappingInfo.setEs9Exchange(es9CommodityMappingEditPage.getPage().get(0).getCommodityMapping().getExchange());
			localCommodityMappingInfo.setEs9MoneyRatio(String.valueOf(es9CommodityMappingEditPage.getPage().get(0).getCommodityMapping().getMoneyRatio()));
			
			localCommodityMappingInfo.setMappingPlatform("ESUNNY");
			
			put("localCommodityMappingInfo", localCommodityMappingInfo);
		}
	}
	
	private int queryCommoditySourceAccountEs3BrokerId() throws ErrorInfo, TException {
//		reqCommoditySourceAccount
		
		if (mContractServiceStub == null) {
			mContractServiceStub = new ContractServiceStub();
		}
		
		ReqCommoditySourceAccountOption reqCommoditySourceAccountOption = new ReqCommoditySourceAccountOption();
		IndexedPageOption indexedPageOption = new IndexedPageOption();
		indexedPageOption.setNeedTotalCount(true);
		indexedPageOption.setPageIndex(0);
		indexedPageOption.setPageSize(PAGE_SIZE_MAX);
		reqCommoditySourceAccountOption.setPageOption(indexedPageOption);
		CommoditySourceAccountPage commoditySourceAccountPage = mContractServiceStub.reqCommoditySourceAccount(reqCommoditySourceAccountOption);
		
		if (commoditySourceAccountPage.getPageSize() > 0) {
			for (CommoditySourceAccount commoditySourceAccount : commoditySourceAccountPage.getPage()) {
				if (TechPlatform.ESUNNY_3 == commoditySourceAccount.getTechPlatform() && TechPlatformEnv.REAL == commoditySourceAccount.getTechPlatformEnv()) {
					return commoditySourceAccount.getBrokerEntryId();
				}
			}
			
		}
		return -1;
	}
	
	public void updateSledCommodityState() throws IOException {
		ErrorResult result = new ErrorResult();
		int sledCommodityId = parameter("sledCommodityId", 0);
		String commodityState = parameter("commodityState", "");
		String cnName = parameter("cnName", "");
		String engName = parameter("engName", "");

		String cnAcronym = parameter("cnAcronym", "");
		String engAcronym = parameter("engAcronym", "");

		String zoneId = parameter("zoneId", "");
		
		String tradeCurrency = parameter("tradeCurrency", "");
		String contractSizeStr = parameter("contractSize", "");
		String tickSizeStr = parameter("tickSize", "");
		int denominator = parameter("denominator", 0);
		String cmbDirect = parameter("cmbDirect", "");
		
		double contractSize = 0;
		double tickSize = 0;
		
		AppLog.i("SledCommodityDetail ---- updateSledCommodityState ---- sledCommodityId : " + sledCommodityId
				+ ", commodityState : " + commodityState + ", cnName : " + cnName
				+ ", engName : " + engName + ", zoneId : " + zoneId
				+ ", tradeCurrency : " + tradeCurrency + ", contractSizeStr : " + contractSizeStr
				+ ", tickSizeStr : " + tickSizeStr + ", denominator : " + denominator
				+ ", cmbDirect : " + cmbDirect + ", cnAcronym : " + cnAcronym + ", engAcronym : " + engAcronym);
		
		try {
			contractSize = Double.valueOf(contractSizeStr);
			tickSize = Double.valueOf(tickSizeStr);
		} catch(Exception e) {
			result.setErrorCode(5);
			result.setErrorMsg("合约每手乘数或最小变动价位应该为double类型");
			echoJson(result);
			return;
		}
		
		AppLog.i("SledCommodityDetail ---- updateSledCommodityState ---- contractSize : " + contractSize + ", tickSize : " + tickSize);
		
		if (!CityTimeZoneMapping.getInstance().getZoneList().contains(zoneId)) {
			result.setErrorCode(5);
			result.setErrorMsg("时区格式不正确");
			echoJson(result);
			return;
		}
		
		ContractServiceStub stub = new ContractServiceStub();

		SledCommodity sledCommodity = new SledCommodity();
		sledCommodity.setSledCommodityId(sledCommodityId);
		sledCommodity.setCommodityState(CommodityState.valueOf(commodityState));
		sledCommodity.setCnName(cnName);
		sledCommodity.setEngName(engName);

		sledCommodity.setCnAcronym(cnAcronym);
		sledCommodity.setEngAcronym(engAcronym);

		sledCommodity.setZoneId(zoneId);
		
		sledCommodity.setTradeCurrency(tradeCurrency);
		sledCommodity.setContractSize(contractSize);
		sledCommodity.setTickSize(tickSize);
		sledCommodity.setDenominator(denominator);
		sledCommodity.setCmbDirect(CmbDirect.valueOf(cmbDirect));
		
		try{
			stub.updateSledCommodity(RandomUtils.nextInt(), TIME_OUT, sledCommodity);
		} catch(ErrorInfo errorInfo) {
			AppLog.e(errorInfo.getMessage(), errorInfo);
			result.setErrorCode(errorInfo.getErrorCode());
			result.setErrorMsg(errorInfo.getErrorMsg());
		} catch (Throwable t) {
			AppLog.e(t.getMessage(), t);
			result.setErrorCode(ErrorCodeOuter.SERVER_BUSY.getErrorCode());
			result.setErrorMsg(ErrorCodeOuter.SERVER_BUSY.getErrorMsg());
		}
		echoJson(result);
	}
	
	private List<SledCommodityConfig> queryCommodityConfigById(int sledCommodityId) throws ErrorInfo, TException {
		ContractServiceStub stub = new ContractServiceStub();
		ReqSledCommodityOption commodityOption = new ReqSledCommodityOption();
		List<Integer> sledCommodityIdList = new ArrayList<Integer>();
		sledCommodityIdList.add(sledCommodityId);
		commodityOption.setSledCommodityIdList(sledCommodityIdList);
		SledCommodityEditPage sledCommodityEditPage = stub.reqSledCommodity(RandomUtils.nextInt(), TIME_OUT, commodityOption, 0, 1);

		AppLog.i("SledCommodityDetail ---- queryCommodityConfigById ---- sledCommodityEditPage : " + sledCommodityEditPage.toString());
		
		if (sledCommodityEditPage != null && sledCommodityEditPage.getTotal() > 0) {
			AppLog.i("SledCommodityDetail ---- queryCommodityById ---- getTotal : " + sledCommodityEditPage.getTotal());
			return sledCommodityEditPage.getPage().get(0).getSledCommodity().getSledCommodityConfig();
		} else {
			return null;
		}
	}
	
	
	public void addSledCommodityConfig() throws IOException {
		ErrorResult result = new ErrorResult();
		
		String content = StringFactory.newUtf8String(IOUtils.toByteArray(getServletRequest().getInputStream()));
		AppLog.i("SledCommodityDetail ---- addSledCommodityConfig ---- content : " + content);

		LocalCommodityConfig localCommodityConfig = GsonFactory.getGson().fromJson(content, LocalCommodityConfig.class);
		
		ContractServiceStub stub = new ContractServiceStub();

		SledCommodity sledCommodity = new SledCommodity();
		sledCommodity.setSledCommodityId(localCommodityConfig.getSledCommodityId());
		
		List<SledCommodityConfig> sledCommodityConfigList;
		
		try {
			sledCommodityConfigList = queryCommodityConfigById(localCommodityConfig.getSledCommodityId());
		} catch(ErrorInfo errorInfo) {
			AppLog.e(errorInfo.getMessage(), errorInfo);
			result.setErrorCode(errorInfo.getErrorCode());
			result.setErrorMsg(errorInfo.getErrorMsg());
			echoJson(result);
			return;
		} catch (Throwable t) {
			AppLog.e(t.getMessage(), t);
			result.setErrorCode(ErrorCodeOuter.SERVER_BUSY.getErrorCode());
			result.setErrorMsg(ErrorCodeOuter.SERVER_BUSY.getErrorMsg());
			echoJson(result);
			return;
		}
		
		if (sledCommodityConfigList == null) {
			sledCommodityConfigList = new ArrayList<SledCommodityConfig>();
		}
		SledCommodityConfig sledCommodityConfig = LocalCommodityConfig.transferToSledCommodityConfig(localCommodityConfig);
		sledCommodityConfig.setConfigId(sledCommodityConfigList.size());
		sledCommodityConfigList.add(0, sledCommodityConfig);
		sledCommodity.setSledCommodityConfig(sledCommodityConfigList);

		
		try{
			stub.updateSledCommodity(RandomUtils.nextInt(), TIME_OUT, sledCommodity);
		} catch(ErrorInfo errorInfo) {
			AppLog.e(errorInfo.getMessage(), errorInfo);
			result.setErrorCode(errorInfo.getErrorCode());
			result.setErrorMsg(errorInfo.getErrorMsg());
		} catch (Throwable t) {
			AppLog.e(t.getMessage(), t);
			result.setErrorCode(ErrorCodeOuter.SERVER_BUSY.getErrorCode());
			result.setErrorMsg(ErrorCodeOuter.SERVER_BUSY.getErrorMsg());
		}
		echoJson(result);
	}
	
	public void deleteSledCommodityConfig() throws IOException {
		ErrorResult result = new ErrorResult();
		
		int sledCommodityId = parameter("sledCommodityId", 0);
		int configId = parameter("configId", 0);
		
		ContractServiceStub stub = new ContractServiceStub();

		SledCommodity sledCommodity = new SledCommodity();
		sledCommodity.setSledCommodityId(sledCommodityId);
		
		List<SledCommodityConfig> sledCommodityConfigList;
		
		try {
			sledCommodityConfigList = queryCommodityConfigById(sledCommodityId);
		} catch(ErrorInfo errorInfo) {
			AppLog.e(errorInfo.getMessage(), errorInfo);
			result.setErrorCode(errorInfo.getErrorCode());
			result.setErrorMsg(errorInfo.getErrorMsg());
			echoJson(result);
			return;
		} catch (Throwable t) {
			AppLog.e(t.getMessage(), t);
			result.setErrorCode(ErrorCodeOuter.SERVER_BUSY.getErrorCode());
			result.setErrorMsg(ErrorCodeOuter.SERVER_BUSY.getErrorMsg());
			echoJson(result);
			return;
		}
		
		if (sledCommodityConfigList != null) {
			for (int index = 0; index < sledCommodityConfigList.size(); index++) {
				if (sledCommodityConfigList.get(index).getConfigId() == configId) {
					sledCommodityConfigList.remove(index);
				}
			}
			//reset id
			for (int index = 0; index < sledCommodityConfigList.size(); index++) {
				sledCommodityConfigList.get(index).setConfigId(index);
			}
			
			sledCommodity.setSledCommodityConfig(sledCommodityConfigList);
			
			try{
				stub.updateSledCommodity(RandomUtils.nextInt(), TIME_OUT, sledCommodity);
			} catch(ErrorInfo errorInfo) {
				AppLog.e(errorInfo.getMessage(), errorInfo);
				result.setErrorCode(errorInfo.getErrorCode());
				result.setErrorMsg(errorInfo.getErrorMsg() + " : " + errorInfo.getErrorMsg());
			} catch (Throwable t) {
				AppLog.e(t.getMessage(), t);
				result.setErrorCode(ErrorCodeOuter.SERVER_BUSY.getErrorCode());
				result.setErrorMsg(ErrorCodeOuter.SERVER_BUSY.getErrorMsg());
			}
		} else {
			result.setErrorCode(ErrorCodeOuter.SERVER_BUSY.getErrorCode());
			result.setErrorMsg("sledCommodityConfig列表为空，删除失败");
		}

		echoJson(result);
	}
	
//	public void synceSledCommodityConfig() throws IOException {
//		ErrorResult result = new ErrorResult();
//		
//		int sledCommodityId = parameter("sledCommodityId", 0);
//		
//		ContractServiceStub stub = new ContractServiceStub();
//		
//		try{
//			stub.syncSledCommodityConfig(sledCommodityId);
//		} catch(ErrorInfo errorInfo) {
//			AppLog.e(errorInfo.getMessage(), errorInfo);
//			result.setErrorCode(errorInfo.getErrorCode());
//			result.setErrorMsg(errorInfo.getErrorMsg() + " : " + errorInfo.getErrorMsg());
//		} catch (Throwable t) {
//			AppLog.e(t.getMessage(), t);
//			result.setErrorCode(ErrorCodeOuter.SERVER_BUSY.getErrorCode());
//			result.setErrorMsg(ErrorCodeOuter.SERVER_BUSY.getErrorMsg());
//		}
//
//		echoJson(result);
//	}
	
	public void updateSledCommodity() throws ErrorInfo, TException, Exception {
		ErrorResult result = new ErrorResult();
		result.setErrorCode(0);
		result.setErrorMsg("修改成功");
		try {
			String content = StringFactory.newUtf8String(IOUtils.toByteArray(getServletRequest().getInputStream()));
			AppLog.i("SledCommodityDetail ---- updateSledCommodity ---- content : " + content);

			LocalCommodity localCommodity = GsonFactory.getGson().fromJson(content, LocalCommodity.class);

			if (localCommodity == null) {
				result.setErrorCode(405);
				result.setErrorMsg("修改失败");
				echoJson(result);
				return;
			}
			
			ContractServiceStub stub = new ContractServiceStub();

			try{
				stub.updateSledCommodity(RandomUtils.nextInt(), TIME_OUT, LocalCommodity.transferToSledCommodity(localCommodity));
			} catch(ErrorInfo errorInfo) {
				result.setErrorCode(errorInfo.getErrorCode());
				result.setErrorMsg(errorInfo.getErrorMsg() + " : " + errorInfo.getErrorMsg());
			}

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.setErrorCode(405);
			result.setErrorMsg("修改失败");
		}
		echoJson(result);
	}
	
	public void verifySledCommodity() throws IOException {
		ErrorResult result = new ErrorResult();
		
		int sledCommodityId = parameter("sledCommodityId", 0);
		AppLog.i("SledCommodityDetail ---- verifySledCommodity ---- sledCommodityId : " + sledCommodityId);

		if (sledCommodityId <= 0) {
			result.setErrorCode(2);
			result.setErrorMsg("获取不到商品ID，验证失败");
			echoJson(result);
			return;
		}
		
		ContractServiceStub stub = new ContractServiceStub();
		
		try {
			stub.verifySledCommodity(sledCommodityId);
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
