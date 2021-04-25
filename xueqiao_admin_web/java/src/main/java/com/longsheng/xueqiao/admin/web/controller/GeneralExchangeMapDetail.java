package com.longsheng.xueqiao.admin.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.thrift.TException;
import org.soldier.base.StringFactory;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.page.IndexedPageOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.web_framework.model.ErrorResult;
import org.soldier.platform.web_framework.util.GsonFactory;

import com.longsheng.xueqiao.admin.bean.LocalExchangeMapping;
import com.longsheng.xueqiao.contract.standard.thriftapi.ReqSledExchangeOption;
import com.longsheng.xueqiao.contract.standard.thriftapi.SledExchange;
import com.longsheng.xueqiao.contract.standard.thriftapi.SledExchangePage;
import com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatform;
import com.longsheng.xueqiao.contract.thriftapi.ReqSledExchangeMappingOption;
import com.longsheng.xueqiao.contract.thriftapi.SledExchangeMapping;
import com.longsheng.xueqiao.contract.thriftapi.SledExchangeMappingPage;
import com.longsheng.xueqiao.contract.thriftapi.client.ContractServiceStub;

public class GeneralExchangeMapDetail extends OaAuthController {
	private static final int PAGE_SIZE = 10;
	private static final int PAGE_SIZE_MAX = Integer.MAX_VALUE;
	
	ContractServiceStub mContractServiceStub = new ContractServiceStub();
	
	private int mTotalPage = 1;
	private int mTotalNum = 0;

	public void show() throws Exception {

		int requestPage = parameter("requestPage", 1);
		String platform = parameter("platform", "");
		
		String sledExchangeCnName = parameter("sledExchangeCnName", "");
		String sledExchangeMic = parameter("sledExchangeMic", "");
		String techPlatformExchangeCode = parameter("techPlatformExchangeCode", "");

		if (platform == null || platform.isEmpty()) {
			return;
		}
		
		if (requestPage < 1) {
			requestPage = 1;
		}

		if (StringUtils.isNotBlank(sledExchangeMic)) {
			put("sledExchangeMic", sledExchangeMic);
		}
		if (sledExchangeCnName != null && !sledExchangeCnName.isEmpty()) {
			sledExchangeMic = getExchangeMicByCnName(sledExchangeCnName);
		}
		
		requestPage = queryExchangeMappingList(platform, sledExchangeMic, techPlatformExchangeCode, requestPage - 1);
		
		setBaseQueryUrl(platform, sledExchangeMic, techPlatformExchangeCode);

		if (mTotalPage < 1) {
			mTotalPage = 1;
		}
		
		put("sledExchangeMicList", getSledExchangeMicList());
		
		put("totalPage", mTotalPage);
		put("totalNum", mTotalNum);
		put("platform", platform);
		put("currentPage", requestPage + 1);

		put("sledExchangeCnName", sledExchangeCnName);
		put("techPlatformExchangeCode", techPlatformExchangeCode);
		
		render("general_exchange_map_detail.html");
	}
	
	private void setBaseQueryUrl(String platform, String sledExchangeMic, String techPlatformExchangeCode) {
		StringBuffer baseQueryUrl = new StringBuffer();
		String baseUrl = this.baseUrl;
		int l = baseUrl.indexOf("requestPage");
		if (l > 0) {
			baseUrl = baseUrl.substring(0, l);
		}
		baseQueryUrl.append(baseUrl);
		baseQueryUrl.append("/GeneralExchangeMapDetail/show?platform=");
		baseQueryUrl.append(platform);
		baseQueryUrl.append("&sledExchangeMic=").append(sledExchangeMic);
		baseQueryUrl.append("&techPlatformExchangeCode=").append(techPlatformExchangeCode);
		baseQueryUrl.append("&");
		put("baseQueryUrl", baseQueryUrl);
	}
	
	private String getExchangeMicByCnName(String sledExchangeCnName) throws ErrorInfo, TException {
		if (mContractServiceStub == null) {
			mContractServiceStub = new ContractServiceStub();
		}
		ReqSledExchangeOption option = new ReqSledExchangeOption();

		option.setCnNamePartical(sledExchangeCnName);
		
		SledExchangePage exchangePage = mContractServiceStub.reqSledExchange(option, 0, 0);
		if (exchangePage.getPageSize() > 0) {
			return exchangePage.getPage().get(0).getExchangeMic();
		}
		return "";
	}
	
	private int queryExchangeMappingList(String platform, String sledExchangeMic, String techPlatformExchangeCode, int pageIndex) throws ErrorInfo, TException {
		
		AppLog.i("GeneralExchangeMapDetail ---- queryExchangeMappingList ---- platform : " + platform + ", pageIndex : " + pageIndex);
		
		if (mContractServiceStub == null) {
			mContractServiceStub = new ContractServiceStub();
		}
		
		ReqSledExchangeMappingOption reqSledExchangeMappingOption = new ReqSledExchangeMappingOption();
		reqSledExchangeMappingOption.setTechPlatform(TechPlatform.valueOf(platform));
		
		// filter
		if (sledExchangeMic != null && !sledExchangeMic.isEmpty()) {
			reqSledExchangeMappingOption.setSledExchangeMic(sledExchangeMic);
		}
		if (techPlatformExchangeCode != null && !techPlatformExchangeCode.isEmpty()) {
			reqSledExchangeMappingOption.setTechPlatformExchangeCode(techPlatformExchangeCode);
		}
		
		IndexedPageOption indexedPageOption = new IndexedPageOption();
		indexedPageOption.setPageIndex(pageIndex);
		indexedPageOption.setPageSize(PAGE_SIZE);
		indexedPageOption.setNeedTotalCount(true);
		
		reqSledExchangeMappingOption.setPageOption(indexedPageOption);
		
		
		SledExchangeMappingPage sledExchangeMappingPage = mContractServiceStub.reqSledExchangeMapping(reqSledExchangeMappingOption);
		
		List<LocalExchangeMapping> localExchangeMappingList = new ArrayList<LocalExchangeMapping>();
		
		for (SledExchangeMapping sledExchangeMapping : sledExchangeMappingPage.getPage()) {
			LocalExchangeMapping localExchangeMapping = new LocalExchangeMapping();
			
			localExchangeMapping.setMappingId(sledExchangeMapping.getMappingId());
			localExchangeMapping.setSledExchangeMic(sledExchangeMapping.getSledExchangeMic());
			localExchangeMapping.setSledExchangeCnName(getExchangeCnNameByMic(sledExchangeMapping.getSledExchangeMic()));
			localExchangeMapping.setTechPlatform(sledExchangeMapping.getTechPlatform().name());
			localExchangeMapping.setTechPlatformExchangeCode(sledExchangeMapping.getTechPlatformExchangeCode());
			
			localExchangeMappingList.add(localExchangeMapping);
		}
		
		put("exchangeMappingList", localExchangeMappingList);
		AppLog.i("GeneralExchangeMapDetail ---- queryExchangeMappingList ---- sledExchangeMappingPage.getTotal() : " + sledExchangeMappingPage.getTotal());
		mTotalNum = sledExchangeMappingPage.getTotal();
		mTotalPage = (mTotalNum + PAGE_SIZE - 1) / PAGE_SIZE;
		return pageIndex > mTotalPage ? mTotalPage : pageIndex;
	}
	
	private String getExchangeCnNameByMic(String exchangeMic) {
		if (mContractServiceStub == null) {
			mContractServiceStub = new ContractServiceStub();
		}
		ReqSledExchangeOption reqSledExchangeOption = new ReqSledExchangeOption();
		reqSledExchangeOption.setExchangeMic(exchangeMic);
		SledExchangePage sledExchangePage = null;
		try {
			sledExchangePage = mContractServiceStub.reqSledExchange(reqSledExchangeOption, 0, 1);
		} catch (TException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (sledExchangePage != null && sledExchangePage.getPageSize() > 0) {
			return sledExchangePage.getPage().get(0).getCnName();
		} else {
			return "";
		}
	}
	
	public void addSledExchangeMapping() throws IOException {
		
		ErrorResult result = new ErrorResult();
		
		if (mContractServiceStub == null) {
			mContractServiceStub = new ContractServiceStub();
		}
		
		String content = StringFactory.newUtf8String(IOUtils.toByteArray(getServletRequest().getInputStream()));
		AppLog.i("GeneralExchangeMapDetail ---- addSledExchangeMapping ---- content : " + content);
		
		LocalExchangeMapping localExchangeMapping = GsonFactory.getGson().fromJson(content, LocalExchangeMapping.class);
		
		if (localExchangeMapping == null) {
			result.setErrorCode(6);
			result.setErrorMsg("获取不到交易所映射信息，添加失败");
			echoJson(result);
			return;
		}
		
		SledExchangeMapping sledExchangeMapping = new SledExchangeMapping();
		
		try {
			sledExchangeMapping.setTechPlatform(TechPlatform.valueOf(localExchangeMapping.getTechPlatform()));
			sledExchangeMapping.setTechPlatformExchangeCode(localExchangeMapping.getTechPlatformExchangeCode());
			
			if (getSledExchangeMicList().contains(localExchangeMapping.getSledExchangeMic())) {
				sledExchangeMapping.setSledExchangeMic(localExchangeMapping.getSledExchangeMic());
			} else {
				result.setErrorCode(7);
				result.setErrorMsg("找不到雪橇交易所MIC: " + localExchangeMapping.getSledExchangeMic() + "， 添加失败");
				echoJson(result);
				return;
			}
			
			mContractServiceStub.addSledExchangeMapping(sledExchangeMapping);
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
	
	private List<String> getSledExchangeMicList() throws ErrorInfo, TException {
		List<String> sledExchangeMicList = new ArrayList<String>();
		
		// get exchange list
		ReqSledExchangeOption reqSledExchangeOption = new ReqSledExchangeOption();
		SledExchangePage exchangePage = mContractServiceStub.reqSledExchange(reqSledExchangeOption, 0, PAGE_SIZE_MAX);
		if (exchangePage.getPageSize() > 0) {
			for (SledExchange sledExchange : exchangePage.getPage()) {
				sledExchangeMicList.add(sledExchange.getExchangeMic());
			}
		}
		
		return sledExchangeMicList;
	}
}
