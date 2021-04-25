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

import xueqiao.company.CompanyUserPage;
import xueqiao.company.GroupUser;
import xueqiao.company.GroupUserPage;

public class MUserCenterCompanyGroupUserAdmin extends OaAuthController {
//
	private static final int TIME_OUT = 3000;
	private static final int PAGE_SIZE = 10;
	private static final int PAGE_SIZE_MAX = Integer.MAX_VALUE;

	private MXueqiaoUserCenter mMXueqiaoUserCenter;
	
	private int mTotalPage = 1;
	private int mTotalNum = 0;
	
	public void show() throws Exception {

		int groupId = parameter("groupId", -1);
		int companyId = parameter("companyId", -1);
		
		int requestPage = parameter("requestPage", 1);
		
		AppLog.i("MUserCenterCompanyGroupUserAdmin ---- show ---- groupId : " + groupId + ", requestPage : " + requestPage + ", companyId : " + companyId);
		
		if (requestPage < 1) {
			requestPage = 1;
		}
		
		requestPage = queryCompanyGroupUserList(requestPage - 1, companyId, groupId);
		
		if (mTotalPage < 1) {
			mTotalPage = 1;
		}
		
		put("companyId", companyId);
		put("groupId", groupId);
		
		put("totalPage", mTotalPage);
		put("totalNum", mTotalNum);
		put("currentPage", requestPage + 1);
		setBaseQueryUrl();
		queryCompanyUserList(companyId);
		render("m_user_center_company_group_user.html");
	}

	private void setBaseQueryUrl() {
		StringBuffer baseQueryUrl = new StringBuffer();
		String baseUrl = this.baseUrl;
		int l = baseUrl.indexOf("requestPage");
		if (l > 0) {
			baseUrl = baseUrl.substring(0, l);
		}
		baseQueryUrl.append(baseUrl);
		baseQueryUrl.append("/MUserCenterCompanyGroupUserAdmin/show?");
		put("baseQueryUrl", baseQueryUrl);
	}
	
	private int queryCompanyGroupUserList(int pageIndex, int companyId, int groupId) throws ErrorInfo, TException {
		if (mMXueqiaoUserCenter == null) {
			mMXueqiaoUserCenter = new MXueqiaoUserCenter();
		}
		GroupUserPage groupUserPage = mMXueqiaoUserCenter.queryGroupUserList(pageIndex, companyId, groupId);
		
		put("groupUserList", groupUserPage.getPage());
		
		mTotalNum =groupUserPage.getTotal();
		mTotalPage = (mTotalNum + MXueqiaoUserCenter.PAGE_SIZE - 1) / MXueqiaoUserCenter.PAGE_SIZE;
		return pageIndex > mTotalPage ? mTotalPage : pageIndex;
	}
	
	private void queryCompanyUserList(int companyId) throws TException {

		if (mMXueqiaoUserCenter == null) {
			mMXueqiaoUserCenter = new MXueqiaoUserCenter();
		}
		CompanyUserPage companyUserPage = mMXueqiaoUserCenter.queryCompanyUserListByCompanyId(companyId);
		put("companyUserList", companyUserPage.getPage());
	}
	
	public void addCompanyGroupUser() throws IOException {
		if (mMXueqiaoUserCenter == null) {
			mMXueqiaoUserCenter = new MXueqiaoUserCenter();
		}
		
		ErrorResult result = new ErrorResult();
		
		String content = StringFactory.newUtf8String(IOUtils.toByteArray(getServletRequest().getInputStream()));
		AppLog.i("MUserCenterServiceGroupAdmin ---- addCompanyGroupUser ---- content : " + content);
		
		GroupUser groupUser = GsonFactory.getGson().fromJson(content, GroupUser.class);
		
		try {
			mMXueqiaoUserCenter.addCompanyGroupUser(groupUser);
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
	
	public void deleteCompanyGroupUser() throws IOException {
		if (mMXueqiaoUserCenter == null) {
			mMXueqiaoUserCenter = new MXueqiaoUserCenter();
		}
		
		ErrorResult result = new ErrorResult();
		
		int companyId = parameter("companyId", 0);
		int groupId = parameter("groupId", 0);
		int userId = parameter("userId", 0);
		
		try {
			mMXueqiaoUserCenter.deleteCompanyGroupUser(companyId, groupId, userId);
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
