package com.longsheng.xueqiao.admin.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.web_framework.model.ErrorResult;

import com.longsheng.xueqiao.admin.bean.LocalCompany;
import com.longsheng.xueqiao.admin.bean.LocalCompanyPage;
import com.longsheng.xueqiao.admin.module.user.MXueqiaoUserCenter;
import com.longsheng.xueqiao.admin.module.user.MXueqiaoUserCenterPayment;
import com.longsheng.xueqiao.admin.util.TimeFormator;
import xueqiao.company.CompanyEntry;
import xueqiao.company.CompanyPageResult;

public class SledCompanyAdmin extends OaAuthController {

	public void show() throws Exception {
		render("sled_company_admin.html");
	}

	public void queryCompanyList() throws IOException {
		ErrorResult result = new ErrorResult();
		
		int requestPage = parameter("requestPage", 1);
		int companyId = parameter("companyId", 0);
		String companyName = parameter("companyName", "");
		String email = parameter("email", "");
		String telephone = parameter("telephone", "");
		
		AppLog.i("SledCompanyAdmin ---- queryCompanyList ---- requestPage : " + requestPage + ", companyId : " + companyId + ", companyName : " + companyName + ", email : " + email + ", telephone : " + telephone);
		
		if (requestPage < 1) {
			requestPage = 1;
		}
		
		CompanyPageResult companyPageResult = null;
		try {
			companyPageResult = MXueqiaoUserCenter.getInstance().queryCompanyList(requestPage - 1, companyId, companyName, email, telephone);
			
			if (companyPageResult != null) {
				LocalCompanyPage localCompanyPage = new LocalCompanyPage();
				localCompanyPage.setLocalCompanyList(getLocalCompanyListFromCompanyList(companyPageResult.getResultList()));
				localCompanyPage.setTotalNum(companyPageResult.getTotalCount());
				localCompanyPage.setTotalPage((companyPageResult.getTotalCount() + MXueqiaoUserCenterPayment.PAGE_SIZE - 1) / MXueqiaoUserCenterPayment.PAGE_SIZE);
				localCompanyPage.setCurrentPage(requestPage);
				echoJson(localCompanyPage);
			} else {
				result.setErrorCode(5);
				result.setErrorMsg("查找订单失败");
				echoJson(result);
			}
		} catch(ErrorInfo errorInfo) {
			errorInfo.printStackTrace();
			result.setErrorCode(errorInfo.getErrorCode());
			result.setErrorMsg(errorInfo.getErrorMsg());
			echoJson(result);
		} catch (Throwable e) {
			e.printStackTrace();
			result.setErrorCode(5);
			result.setErrorMsg("服务器繁忙");
			echoJson(result);
		}
	}
	
	private List<LocalCompany> getLocalCompanyListFromCompanyList(List<CompanyEntry> companyEntryList) throws ErrorInfo, TException {
		List<LocalCompany> localCompanyList = new ArrayList<LocalCompany>();
		
		for(CompanyEntry company : companyEntryList) {
			LocalCompany localCompany = new LocalCompany();
			localCompany.setCompanyId(company.getCompanyId());
			localCompany.setCompanyCode(company.getCompanyCode());
			localCompany.setCompanyName(company.getCompanyName());
			localCompany.setFund(company.getFund());
			localCompany.setChannel(company.getChannel());
			localCompany.setAddress(company.getAddress());
			localCompany.setEmail(company.getEmail());
			localCompany.setTelephone(company.getTelephone());
			localCompany.setPassword(company.getPassword());
			localCompany.setCreateTimestamp(TimeFormator.timeStampToDate(company.getCreateTimestamp()));
			
			localCompanyList.add(localCompany);
		}
		return localCompanyList;
	}
}
