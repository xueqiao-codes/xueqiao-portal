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

import com.longsheng.xueqiao.admin.bean.LocalSledExchange;
import com.longsheng.xueqiao.admin.util.CityTimeZoneMapping;
import com.longsheng.xueqiao.contract.standard.thriftapi.ReqSledExchangeOption;
import com.longsheng.xueqiao.contract.standard.thriftapi.SledExchange;
import com.longsheng.xueqiao.contract.standard.thriftapi.SledExchangePage;
import com.longsheng.xueqiao.contract.thriftapi.client.ContractServiceStub;

public class SledExchangeAdmin extends AbstractDBLockController {

	private static final int TIME_OUT = 3000;
	private static final int PAGE_SIZE = 14;

	ContractServiceStub mContractServiceStub = new ContractServiceStub();
	
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
		
		if (mContractServiceStub == null) {
			mContractServiceStub = new ContractServiceStub();
		}

		put("cnName", cnName);
		put("acronym", acronym);
		put("cnAcronym", cnAcronym);

		getModuleLockStatus(ModuleType.MM_CONTRACT);
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
			mContractServiceStub = new ContractServiceStub();
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
				mContractServiceStub = new ContractServiceStub();
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

	public void addSledExchange() throws Exception {
		ErrorResult result = new ErrorResult();
		try {
			String content = StringFactory.newUtf8String(IOUtils.toByteArray(getServletRequest().getInputStream()));

			// TODO: 转为大写

			AppLog.i("SledExchangeAdmin ---- addSledExchange ---- content : " + content);

			SledExchange sledExchange = GsonFactory.getGson().fromJson(content, SledExchange.class);

			// Change from lower case to upper case : exchangeMic, operatingMic,
			// nameInstitution
			sledExchange.setExchangeMic(sledExchange.getExchangeMic().toUpperCase());
			sledExchange.setOperatingMic(sledExchange.getOperatingMic().toUpperCase());
			sledExchange.setAcronym(sledExchange.getAcronym().toUpperCase());

			if (mContractServiceStub == null) {
				mContractServiceStub = new ContractServiceStub();
			}

			SledExchange sledExchangeResult = mContractServiceStub.addSledExchange(RandomUtils.nextInt(), TIME_OUT, sledExchange);

			if (sledExchangeResult != null && sledExchangeResult.getSledExchangeId() > 0) {
				AppLog.i("SledExchangeAdmin ---- addSledExchange ---- getSledExchangeId : "
						+ sledExchangeResult.getSledExchangeId());
				result.setErrorCode(0);
				result.setErrorMsg("添加成功");
			} else {
				result.setErrorCode(405);
				result.setErrorMsg("添加失败");
			}

		} catch(ErrorInfo errorInfo) {
			result.setErrorCode(errorInfo.getErrorCode());
			result.setErrorMsg(errorInfo.getErrorMsg() + " : " + errorInfo.getErrorMsg());
		}
		echoJson(result);
	}

	public void updateSledExchange() throws Exception {
		ErrorResult result = new ErrorResult();
		try {
			String content = StringFactory.newUtf8String(IOUtils.toByteArray(getServletRequest().getInputStream()));
			AppLog.i("SledExchangeAdmin ---- updateSledExchange ---- content : " + content);

			LocalSledExchange localSledExchange = GsonFactory.getGson().fromJson(content, LocalSledExchange.class);
			AppLog.i("SledExchangeAdmin ---- updateSledExchange ---- localSledExchange : " + localSledExchange.getSledExchangeId() + ", zoneid : " + localSledExchange.getZoneId());
			
			SledExchange sledExchange = new SledExchange();
			
			sledExchange.setSledExchangeId(localSledExchange.getSledExchangeId());
			sledExchange.setCnName(localSledExchange.getCnName());
			sledExchange.setCnAcronym(localSledExchange.getCnAcronym());
			sledExchange.setNameInstitution(localSledExchange.getNameInstitution());
			sledExchange.setAcronym(localSledExchange.getAcronym());
			sledExchange.setWebsite(localSledExchange.getWebsite());
			sledExchange.setZoneId(localSledExchange.getZoneId());
			AppLog.i("SledExchangeAdmin ---- updateSledExchange ---- sledExchange.getSledExchangeId() : " + sledExchange.getSledExchangeId());
			// Change from lower case to upper case : acronym
			sledExchange.setAcronym(sledExchange.getAcronym().toUpperCase());

			if (mContractServiceStub == null) {
				mContractServiceStub = new ContractServiceStub();
			}

			mContractServiceStub.updateSledExchange(RandomUtils.nextInt(), TIME_OUT, sledExchange);

			result.setErrorCode(0);
			result.setErrorMsg("修改成功");
		} catch(ErrorInfo errorInfo) {
			errorInfo.printStackTrace();
			result.setErrorCode(errorInfo.getErrorCode());
			result.setErrorMsg(errorInfo.getErrorMsg());
		} catch (Throwable e) {
			e.printStackTrace();
			result.setErrorCode(34);
			result.setErrorMsg(e.getMessage());
		}
		echoJson(result);
	}

	public void deleteSledExchange() throws IOException {
		ErrorResult result = new ErrorResult();
		int sledExchangeId = parameter("sledExchangeId", 0);
		AppLog.i("SledExchangeAdmin ---- deleteSledExchange ---- sledExchangeId : " + sledExchangeId);

		if (mContractServiceStub == null) {
			mContractServiceStub = new ContractServiceStub();
		}

		try {
			mContractServiceStub.removeSledExchange(sledExchangeId);
		} catch(ErrorInfo errorInfo) {
			errorInfo.printStackTrace();
			result.setErrorCode(errorInfo.getErrorCode());
			result.setErrorMsg(errorInfo.getErrorMsg() + " : " + errorInfo.getErrorMsg());
		} catch (Throwable e) {
			e.printStackTrace();
			result.setErrorCode(34);
			result.setErrorMsg(e.getMessage());
		}
		
		echoJson(result);
	}
	
}
