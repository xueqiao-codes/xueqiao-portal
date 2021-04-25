package com.longsheng.xueqiao.admin.web.controller;

import com.longsheng.xueqiao.admin.bean.company.LocalCompanyGroupSpecInfo;
import com.longsheng.xueqiao.admin.module.user.MXueqiaoUserCenter;
import com.longsheng.xueqiao.admin.util.TimeFormator;
import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.web_framework.model.ErrorResult;
import xueqiao.company.CompanyGroup;
import xueqiao.company.CompanyGroupPageResult;
import xueqiao.company.CompanyGroupSpec;
import xueqiao.company.CompanyGroupSpecPage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SledGroupSpecDebug extends OaAuthController {

    public void show() throws Exception {
        render("sled_group_spec_debug.html");
    }

    public void queryComapanyGroupInfoList() throws IOException {
        ErrorResult result = new ErrorResult();

        int companyId = parameter("companyId", 0);

        CompanyGroupPageResult companyGroupPageResult = null;
        CompanyGroupSpecPage companyGroupSpecPage = null;
        try {
            companyGroupPageResult = MXueqiaoUserCenter.getInstance().queryCompanyGroupList(companyId);
            companyGroupSpecPage = MXueqiaoUserCenter.getInstance().queryCompanyGroupSpec(companyId);
        } catch (TException e) {
            e.printStackTrace();
        }

        if (companyGroupPageResult == null || companyGroupPageResult.getResultListSize() < 1) {
            result.setErrorCode(5);
            result.setErrorMsg("查找不到公司组信息");
            echoJson(result);
            return;
        }
        if (companyGroupSpecPage == null || companyGroupSpecPage.getPageSize() < 1) {
            result.setErrorCode(6);
            result.setErrorMsg("查找不到公司组规格信息");
            echoJson(result);
            return;
        }

        Map<Integer, CompanyGroupSpec> companyGroupSpecMap = new HashMap<>();
        for (CompanyGroupSpec companyGroupSpec : companyGroupSpecPage.getPage()) {
            companyGroupSpecMap.put(companyGroupSpec.getGroupId(), companyGroupSpec);
        }

        List<LocalCompanyGroupSpecInfo> localCompanyGroupSpecInfoList = new ArrayList<>();
        CompanyGroupSpec companyGroupSpec = null;
        for (CompanyGroup companyGroup : companyGroupPageResult.getResultList()) {

            companyGroupSpec = companyGroupSpecMap.get(companyGroup.getGroupId());
            if (companyGroupSpec == null) {
                continue;
            }

            LocalCompanyGroupSpecInfo localCompanyGroupSpecInfo = new LocalCompanyGroupSpecInfo();

            localCompanyGroupSpecInfo.setCompanyId(companyGroup.getCompanyId());
            localCompanyGroupSpecInfo.setGroupId(companyGroup.getGroupId());
            localCompanyGroupSpecInfo.setGroupName(companyGroup.getGroupName());
            localCompanyGroupSpecInfo.setHostingServiceStatus(companyGroupSpec.getHostingServiceStatus().name());
            localCompanyGroupSpecInfo.setServiceType(companyGroupSpec.getServiceType().name());
            localCompanyGroupSpecInfo.setExpiredTimestamp(TimeFormator.timeStampToDate(companyGroupSpec.getExpiredTimestamp()));
            localCompanyGroupSpecInfo.setReleaseTimestamp(TimeFormator.timeStampToDate(companyGroupSpec.getReleaseTimestamp()));
            localCompanyGroupSpecInfo.setOperateDescription(companyGroupSpec.getOperateDescription());

            localCompanyGroupSpecInfoList.add(localCompanyGroupSpecInfo);
        }

        echoJson(localCompanyGroupSpecInfoList);
    }

    public void modifyExpiredTime() throws IOException {
        ErrorResult result = new ErrorResult();

        int companyId = parameter("companyId", 0);
        int groupId = parameter("groupId", 0);
        String expiredDate = parameter("expiredDate", "");
        String expiredTime = parameter("expiredTime", "");

        AppLog.i("SledGroupSpecDebug ---- modifyExpiredTime ---- companyId : " + companyId + ", groupId : " + groupId
            + ", expiredDate : " + expiredDate + ", expiredTime : " + expiredTime);

        String date = expiredDate + " " + expiredTime;
        long expiredTimeStamp = TimeFormator.dateToTimeStamp3(date);

        AppLog.i("SledGroupSpecDebug ---- modifyExpiredTime ---- expiredTimeStamp : " + expiredTimeStamp);

        CompanyGroupSpec updateGroupSpec = new CompanyGroupSpec();

        updateGroupSpec.setCompanyId(companyId);
        updateGroupSpec.setGroupId(groupId);
        updateGroupSpec.setExpiredTimestamp(expiredTimeStamp / 1000);
        try {
            MXueqiaoUserCenter.getInstance().updateCompanyGroupSpec(updateGroupSpec);
        } catch (ErrorInfo e) {
            e.printStackTrace();
            result.setErrorCode(5);
            result.setErrorMsg(e.getErrorMsg());
            echoJson(result);
        } catch (Throwable t) {
            result.setErrorCode(5);
            result.setErrorMsg("更新失败");
            echoJson(result);
        }
    }
}
