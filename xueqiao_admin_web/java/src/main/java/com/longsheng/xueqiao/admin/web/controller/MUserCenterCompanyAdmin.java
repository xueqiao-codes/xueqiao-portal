package com.longsheng.xueqiao.admin.web.controller;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.thrift.TException;
import org.soldier.base.StringFactory;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.web_framework.model.ErrorResult;
import org.soldier.platform.web_framework.util.GsonFactory;

import com.longsheng.xueqiao.admin.bean.LocalExchangeMapping;
import com.longsheng.xueqiao.admin.module.user.MXueqiaoUserCenter;
import com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatform;
import com.longsheng.xueqiao.contract.thriftapi.SledExchangeMapping;
import com.longsheng.xueqiao.contract.thriftapi.client.ContractServiceStub;

import xueqiao.company.CompanyEntry;
import xueqiao.company.CompanyPageResult;

public class MUserCenterCompanyAdmin extends OaAuthController {

	private static final int TIME_OUT = 3000;
//	private static final int PAGE_SIZE = 10;
	private static final int PAGE_SIZE_MAX = Integer.MAX_VALUE;

	private MXueqiaoUserCenter mMXueqiaoUserCenter;
	
	private int mTotalPage = 1;
	private int mTotalNum = 0;
	
	public void show() throws Exception {

		int requestPage = parameter("requestPage", 1);
		if (requestPage < 1) {
			requestPage = 1;
		}
		
		setBaseQueryUrl();
		
		requestPage = queryCompanyList(requestPage - 1);
		
		if (mTotalPage < 1) {
			mTotalPage = 1;
		}
		put("totalPage", mTotalPage);
		put("totalNum", mTotalNum);
		put("currentPage", requestPage + 1);
		
		render("m_user_center_company_admin.html");
	}

	private void setBaseQueryUrl() {
		StringBuffer baseQueryUrl = new StringBuffer();
		String baseUrl = this.baseUrl;
		int l = baseUrl.indexOf("requestPage");
		if (l > 0) {
			baseUrl = baseUrl.substring(0, l);
		}
		baseQueryUrl.append(baseUrl);
		baseQueryUrl.append("/MUserCenterCompanyAdmin/show?");
		put("baseQueryUrl", baseQueryUrl);
	}
	
	private int queryCompanyList(int pageIndex) throws TException {

		if (mMXueqiaoUserCenter == null) {
			mMXueqiaoUserCenter = new MXueqiaoUserCenter();
		}

		CompanyPageResult companyPageResult = mMXueqiaoUserCenter.queryCompanyList(pageIndex);
		
		if (companyPageResult != null && companyPageResult.getResultListSize() > 0) {
			put("companyList", companyPageResult.getResultList());
		}

		mTotalNum = companyPageResult.getTotalCount();
		mTotalPage = (mTotalNum + MXueqiaoUserCenter.PAGE_SIZE - 1) / MXueqiaoUserCenter.PAGE_SIZE;
		return pageIndex > mTotalPage ? mTotalPage : pageIndex;
	}
	
	public void addCompany() throws IOException {
		
		if (mMXueqiaoUserCenter == null) {
			mMXueqiaoUserCenter = new MXueqiaoUserCenter();
		}
		
		ErrorResult result = new ErrorResult();
		
		String content = StringFactory.newUtf8String(IOUtils.toByteArray(getServletRequest().getInputStream()));
		AppLog.i("MUserCenterCompanyAdmin ---- addCompany ---- content : " + content);
		
		CompanyEntry companyEntry = GsonFactory.getGson().fromJson(content, CompanyEntry.class);
		
		try {
			mMXueqiaoUserCenter.addCompany(companyEntry);
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
