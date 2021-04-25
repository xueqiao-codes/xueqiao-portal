package com.longsheng.xueqiao.admin.web.controller;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.thrift.TException;
import org.soldier.base.StringFactory;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.web_framework.model.ErrorResult;
import org.soldier.platform.web_framework.util.GsonFactory;

import com.longsheng.xueqiao.admin.module.user.MXueqiaoUserCenter;
import xueqiao.company.CompanyUser;
import xueqiao.company.CompanyUserPage;

public class MUserCenterUserAdmin extends OaAuthController {

	private static final int PAGE_SIZE = 10;
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
		
		requestPage = queryUserList(requestPage - 1);
		
		if (mTotalPage < 1) {
			mTotalPage = 1;
		}
		put("totalPage", mTotalPage);
		put("totalNum", mTotalNum);
		put("currentPage", requestPage + 1);
		
		render("m_user_center_user_admin.html");
	}

	private void setBaseQueryUrl() {
		StringBuffer baseQueryUrl = new StringBuffer();
		String baseUrl = this.baseUrl;
		int l = baseUrl.indexOf("requestPage");
		if (l > 0) {
			baseUrl = baseUrl.substring(0, l);
		}
		baseQueryUrl.append(baseUrl);
		baseQueryUrl.append("/MUserCenterUserAdmin/show?");
		put("baseQueryUrl", baseQueryUrl);
	}
	
	private int queryUserList(int pageIndex) throws TException {

		if (mMXueqiaoUserCenter == null) {
			mMXueqiaoUserCenter = new MXueqiaoUserCenter();
		}

		CompanyUserPage companyUserPage = mMXueqiaoUserCenter.queryCompanyUserList(pageIndex);
		
		if (companyUserPage != null && companyUserPage.getPageSize() > 0) {
			put("companyUserList", companyUserPage.getPage());
		}

		mTotalNum = companyUserPage.getTotal();
		mTotalPage = (mTotalNum + MXueqiaoUserCenter.PAGE_SIZE - 1) / MXueqiaoUserCenter.PAGE_SIZE;
		return pageIndex > mTotalPage ? mTotalPage : pageIndex;
	}
	
	public void addCompanyUser() throws IOException {
		if (mMXueqiaoUserCenter == null) {
			mMXueqiaoUserCenter = new MXueqiaoUserCenter();
		}
		
		ErrorResult result = new ErrorResult();
		
		String content = StringFactory.newUtf8String(IOUtils.toByteArray(getServletRequest().getInputStream()));
		AppLog.i("MUserCenterUserAdmin ---- addCompanyUser ---- content : " + content);
		
		CompanyUser companyUser = GsonFactory.getGson().fromJson(content, CompanyUser.class);
		
		try {
			mMXueqiaoUserCenter.addCompanyUser(companyUser);
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
