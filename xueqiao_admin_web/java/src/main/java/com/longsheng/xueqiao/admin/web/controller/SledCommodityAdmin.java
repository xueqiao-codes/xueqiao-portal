package com.longsheng.xueqiao.admin.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.thrift.TException;
import org.soldier.base.StringFactory;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.web_framework.model.ErrorResult;
import org.soldier.platform.web_framework.util.GsonFactory;

import com.longsheng.xueqiao.admin.bean.LocalCommodity;
import com.longsheng.xueqiao.admin.bean.LocalSimpleCommodity;
import com.longsheng.xueqiao.admin.web.controller.AbstractDBLockController.ModuleType;
//import com.longsheng.xueqiao.contract.standard.thriftapi.CalculateMode;
//import com.longsheng.xueqiao.contract.standard.thriftapi.CmbDirect;
//import com.longsheng.xueqiao.contract.standard.thriftapi.CommodityState;
//import com.longsheng.xueqiao.contract.standard.thriftapi.CoverMode;
//import com.longsheng.xueqiao.contract.standard.thriftapi.CurrencyGroup;
//import com.longsheng.xueqiao.contract.standard.thriftapi.DeliveryMode;
//import com.longsheng.xueqiao.contract.standard.thriftapi.DepositCalculateMode;
//import com.longsheng.xueqiao.contract.standard.thriftapi.OpenCloseMode;
import com.longsheng.xueqiao.contract.standard.thriftapi.ReqSledCommodityOption;
import com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodity;
//import com.longsheng.xueqiao.contract.standard.thriftapi.SledBaseCommodity;
//import com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodity;
//import com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodityPage;
import com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodityType;
import com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatform;
import com.longsheng.xueqiao.contract.thriftapi.LinkCommodityMappingInfo;
import com.longsheng.xueqiao.contract.thriftapi.SledCommodityEdit;
import com.longsheng.xueqiao.contract.thriftapi.SledCommodityEditPage;
import com.longsheng.xueqiao.contract.thriftapi.client.ContractServiceStub;

public class SledCommodityAdmin extends AbstractDBLockController {

	private static final int TIME_OUT = 3000;
	private static final int PAGE_SIZE = 14;
	private static final int PAGE_SIZE_MAX = Integer.MAX_VALUE;
	
//	private int mCommodityTotal = 0;
	private int mTotalPage = 1;
	private int mTotalNum = 0;

	public void show() throws Exception {

		String exchangeMic = parameter("exchangeMic", "");
		String commodityType = parameter("commodityType", "");
		String exchangeCNName = parameter("exchangeCNName", "");
		
		// commodity query
		String cnName = parameter("cnName", "");
		String sledCommodityCode = parameter("sledCommodityCode", "");
		
		int requestPage = parameter("requestPage", 1);
		
		AppLog.i("SledCommodityAdmin ---- show ---- exchangeMic : " + exchangeMic + ", commodityType : " + commodityType + ", requestPage : " + requestPage + ", cnName : " + cnName + ", sledCommodityCode : " + sledCommodityCode);
		
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
		
		getModuleLockStatus(ModuleType.MM_CONTRACT);
		
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
		ContractServiceStub stub = new ContractServiceStub();

		ReqSledCommodityOption option = new ReqSledCommodityOption();
		
		option.setExchangeMic(exchangeMic);
		option.setSledCommodityType(SledCommodityType.valueOf(commodityType));
		
		if (cnName != null && !cnName.isEmpty()) {
			option.setCnNamePartical(cnName);
		}
		if (sledCommodityCode != null && !sledCommodityCode.isEmpty()) {
			option.setSledCommodityCodePartical(sledCommodityCode);
		}
		
		SledCommodityEditPage sledCommodityEditPage = stub.reqSledCommodity(RandomUtils.nextInt(), TIME_OUT, option, pageIndex, PAGE_SIZE);
		
		AppLog.i("SledCommodityAdmin ---- queryCommoditiesByExchangeMic ---- pageIndex : " + pageIndex + ", sledCommodityEditPage : " + sledCommodityEditPage.getPageSize());
		
		put("sledCommodityList", LocalCommodity.transferToLocalCommodityList(stub, sledCommodityEditPage.getPage()));
		
		mTotalNum = sledCommodityEditPage.getTotal();
		
		mTotalPage = (mTotalNum + PAGE_SIZE - 1) / PAGE_SIZE;
		AppLog.i("SledCommodityAdmin ---- queryCommoditiesByExchangeId ---- mTotalPage : " + mTotalPage);
		return pageIndex > mTotalPage ? mTotalPage : pageIndex;

	}
	
	private void queryRelativeCommodityList(String exchangeMic, String commodityType) throws ErrorInfo, TException {
		ContractServiceStub stub = new ContractServiceStub();

		ReqSledCommodityOption option = new ReqSledCommodityOption();
		option.setExchangeMic(exchangeMic);
		option.setSledCommodityType(SledCommodityType.valueOf(commodityType));
		AppLog.i("SledCommodityAdmin ---- queryRelativeCommodityList ---- mTotalNum : " + mTotalNum + ", exchangeMic : " + exchangeMic + ", commodityType : " + commodityType);
		SledCommodityEditPage sledCommodityEditPage = stub.reqSledCommodity(RandomUtils.nextInt(), TIME_OUT, option, 0, PAGE_SIZE_MAX);
		
		List<LocalSimpleCommodity> LocalSimpleCommodityList = new ArrayList<LocalSimpleCommodity>();
		
		for (SledCommodityEdit sledCommodityEdit : sledCommodityEditPage.getPage()) {
			LocalSimpleCommodity localSimpleCommodity = new LocalSimpleCommodity();
			localSimpleCommodity.setSledCommodityId(String.valueOf(sledCommodityEdit.getSledCommodity().getSledCommodityId()));
			localSimpleCommodity.setSledCommodityCode(sledCommodityEdit.getSledCommodity().getSledCommodityCode());
			LocalSimpleCommodityList.add(localSimpleCommodity);
		}
		put("relativeCommodityCandidateList", LocalSimpleCommodityList);
	}
	
	public void addSledCommodity() throws Exception {
		ErrorResult result = new ErrorResult();
		String content = StringFactory.newUtf8String(IOUtils.toByteArray(getServletRequest().getInputStream()));
		AppLog.i("SledCommodityAdmin ---- addSledCommodity ---- content : " + content);
		
		LocalCommodity localCommodity = GsonFactory.getGson().fromJson(content, LocalCommodity.class);

		if (localCommodity == null) {
			result.setErrorCode(405);
			result.setErrorMsg("数据获取失败，添加失败");
			echoJson(result);
			return;
		}
		
		ContractServiceStub stub = new ContractServiceStub();
		try {
			SledCommodity sledCommodity = new SledCommodity();
			sledCommodity.setExchangeMic(localCommodity.getExchangeMic());
			sledCommodity.setSledCommodityType(SledCommodityType.valueOf(localCommodity.getSledCommodityType()));
			sledCommodity.setSledCommodityCode(localCommodity.getSledCommodityCode());
			
			if ("SPREAD_MONTH".equals(localCommodity.getSledCommodityType()) || "SPREAD_COMMODITY".equals(localCommodity.getSledCommodityType())) {
				if (localCommodity.getRelateCommodityIdList() != null && localCommodity.getRelateCommodityIdList().size() > 0) {
					sledCommodity.setRelateCommodityIds(localCommodity.getRelateCommodityIdList());
				}
			}
			
			SledCommodityEdit sledCommodityEditResult = stub.addSledCommodity(sledCommodity, localCommodity.getMappingCode());
			if (sledCommodityEditResult != null && sledCommodityEditResult.getSledCommodity().getSledCommodityId() > 0) {
				AppLog.i("SledCommodityAdmin ---- addSledCommodity ---- getSledCommodityId : " + sledCommodityEditResult.getSledCommodity().getSledCommodityId());
				result.setErrorCode(0);
				result.setErrorMsg("添加成功");
			} else {
				result.setErrorCode(405);
				result.setErrorMsg("添加失败");
			}
			
			
		} catch(ErrorInfo errorInfo) {
			errorInfo.printStackTrace();
			result.setErrorCode(errorInfo.getErrorCode());
			result.setErrorMsg(errorInfo.getErrorMsg());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.setErrorCode(5);
			result.setErrorMsg("服务器繁忙");
		}
		
		echoJson(result);
	}
	
	public void deleteSledCommodity() throws IOException {
		
		ErrorResult result = new ErrorResult();
		int sledCommodityId = parameter("sledCommodityId", 0);
		AppLog.i("SledCommodityAdmin ---- deleteSledCommodity ---- sledCommodityId : " + sledCommodityId);

		if (sledCommodityId <= 0) {
			result.setErrorCode(2);
			result.setErrorMsg("获取不到商品ID，删除失败");
			echoJson(result);
			return;
		}

		ContractServiceStub stub = new ContractServiceStub();
		
		try {
			stub.removeSledCommodity(sledCommodityId);
		} catch(ErrorInfo errorInfo) {
			errorInfo.printStackTrace();
			result.setErrorCode(errorInfo.getErrorCode());
			result.setErrorMsg(errorInfo.getErrorMsg() + " : " + errorInfo.getErrorMsg());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.setErrorCode(5);
			result.setErrorMsg("服务器繁忙");
		}
		echoJson(result);
	}
	
	public void activeSledCommodity() throws IOException {
		ErrorResult result = new ErrorResult();
		int sledCommodityId = parameter("sledCommodityId", 0);
		AppLog.i("SledCommodityAdmin ---- activeSledCommodity ---- sledCommodityId : " + sledCommodityId);

		if (sledCommodityId <= 0) {
			result.setErrorCode(2);
			result.setErrorMsg("获取不到商品ID，删除失败");
			echoJson(result);
			return;
		}

		ContractServiceStub stub = new ContractServiceStub();
		
		try {
			stub.activeSledCommodity(sledCommodityId);
		} catch(ErrorInfo errorInfo) {
			errorInfo.printStackTrace();
			result.setErrorCode(errorInfo.getErrorCode());
			result.setErrorMsg(errorInfo.getErrorMsg() + " : " + errorInfo.getErrorMsg());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.setErrorCode(5);
			result.setErrorMsg("服务器繁忙");
		}
		echoJson(result);
	}
	
	public void associateWithPlatform() throws IOException {
		ErrorResult result = new ErrorResult();
		int sledCommodityId = parameter("sledCommodityId", -1);
		String platform = parameter("platform", "");
		
		AppLog.i("SledCommodityAdmin ---- associateWithPlatform ---- sledCommodityId : " + sledCommodityId + ", platform : " + platform);
		
		if (sledCommodityId > 0 && !platform.isEmpty()) {
			ContractServiceStub stub = new ContractServiceStub();

//			ImportCommodityMapInfo mapInfo = new ImportCommodityMapInfo();
//			mapInfo.setSledCommodityId(sledCommodityId);
//			mapInfo.setTechPlatform(TechPlatform.valueOf(platform));
			
			LinkCommodityMappingInfo linkCommodityMappingInfo = new LinkCommodityMappingInfo();
			linkCommodityMappingInfo.setSledCommodityId(sledCommodityId);
			linkCommodityMappingInfo.setTechPlatform(TechPlatform.valueOf(platform));
			
			try {
//				stub.inputCommodityMap(RandomUtils.nextInt(), TIME_OUT, mapInfo);
				stub.linkTechPlatformMapping(linkCommodityMappingInfo);
			} catch (ErrorInfo errorInfo) {
				result.setErrorCode(errorInfo.getErrorCode());
				result.setErrorMsg(errorInfo.getErrorMsg() + ":" + errorInfo.getErrorCode());
			} catch (TException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				result.setErrorCode(5);
				result.setErrorMsg("服务器繁忙");
			}
		} else {
			result.setErrorCode(5);
			result.setErrorMsg("获取商品ID或平台信息失败，关联失败");
		}
		echoJson(result);
	}

}
