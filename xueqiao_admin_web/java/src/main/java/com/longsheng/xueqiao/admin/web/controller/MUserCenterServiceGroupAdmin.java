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

import com.longsheng.xueqiao.admin.module.user.MXueqiaoUserCenter;
import com.longsheng.xueqiao.admin.module.user.bean.LocalGroupUser;
import com.longsheng.xueqiao.broker.dao.thriftapi.client.BrokerDaoServiceStub;
import com.longsheng.xueqiao.contract.thriftapi.client.ContractServiceStub;

import xueqiao.company.CompanyEntry;
import xueqiao.company.CompanyGroup;
import xueqiao.company.CompanyGroupPageResult;
import xueqiao.company.CompanyPageResult;
import xueqiao.company.CompanyUserPage;
import xueqiao.company.GroupUser;
import xueqiao.company.GroupUserPage;

public class MUserCenterServiceGroupAdmin extends OaAuthController {

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
		
		AppLog.i("MUserCenterServiceGroupAdmin ---- show ---- groupId : " + groupId + ", requestPage : " + requestPage + ", companyId : " + companyId);
		
		if (requestPage < 1) {
			requestPage = 1;
		}
		
		requestPage = queryCompanyGroupList(requestPage - 1, companyId);
//		requestPage = queryGroupUserList(requestPage - 1, companyId,  groupId);
		
		if (mTotalPage < 1) {
			mTotalPage = 1;
		}
		
		put("companyId", companyId);
		
		put("totalPage", mTotalPage);
		put("totalNum", mTotalNum);
		put("currentPage", requestPage + 1);
		queryCompanyUserList(companyId);
		setBaseQueryUrl();
		render("m_user_center_service_group_admin.html");
	}

	private void setBaseQueryUrl() {
		StringBuffer baseQueryUrl = new StringBuffer();
		String baseUrl = this.baseUrl;
		int l = baseUrl.indexOf("requestPage");
		if (l > 0) {
			baseUrl = baseUrl.substring(0, l);
		}
		baseQueryUrl.append(baseUrl);
		baseQueryUrl.append("/MUserCenterServiceGroupAdmin/show?");
		put("baseQueryUrl", baseQueryUrl);
	}
	
	private int queryCompanyGroupList(int pageIndex, int companyId) throws ErrorInfo, TException {
		if (mMXueqiaoUserCenter == null) {
			mMXueqiaoUserCenter = new MXueqiaoUserCenter();
		}
		
		CompanyGroupPageResult companyGroupPageResult = mMXueqiaoUserCenter.queryCompanyGroupList(companyId);
		AppLog.i("MUserCenterServiceGroupAdmin ---- queryCompanyGroupList ---- companyGroupPageResult : " + companyGroupPageResult.getResultListSize());
//		if (companyGroupPageResult.getResultListSize() > 0) {
			put("groupList", companyGroupPageResult.getResultList());
//			return companyGroupPageResult.getResultList().get(0).getGroupId();
//		}
		
		mTotalNum =companyGroupPageResult.getTotalCount();
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

	public void addCompanyGroup() throws IOException {
		if (mMXueqiaoUserCenter == null) {
			mMXueqiaoUserCenter = new MXueqiaoUserCenter();
		}
		
		ErrorResult result = new ErrorResult();
		
		String content = StringFactory.newUtf8String(IOUtils.toByteArray(getServletRequest().getInputStream()));
		AppLog.i("MUserCenterServiceGroupAdmin ---- addCompanyGroup ---- content : " + content);
		
		CompanyGroup companyGroup = GsonFactory.getGson().fromJson(content, CompanyGroup.class);
		
		try {
			mMXueqiaoUserCenter.addCompanyGroup(companyGroup);
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
	
	public void deleteCompanyGroup() throws IOException {
		if (mMXueqiaoUserCenter == null) {
			mMXueqiaoUserCenter = new MXueqiaoUserCenter();
		}
		
		ErrorResult result = new ErrorResult();
		
		int companyId = parameter("companyId", 0);
		int groupId = parameter("groupId", 0);
		
		try {
			mMXueqiaoUserCenter.deleteCompanyGroup(companyId, groupId);
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
