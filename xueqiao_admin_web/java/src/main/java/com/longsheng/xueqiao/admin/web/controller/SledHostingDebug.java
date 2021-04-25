package com.longsheng.xueqiao.admin.web.controller;

import com.longsheng.xueqiao.admin.module.hosting.MXueqiaoHostMachine;
import com.longsheng.xueqiao.admin.module.user.MXueqiaoUserCenter;
import com.longsheng.xueqiao.admin.util.TimeUtil;
import org.apache.commons.lang.StringUtils;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.page.IndexedPageOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.web_framework.model.ErrorResult;
import xueqiao.company.CompanyGroupSpec;
import xueqiao.company.GroupUser;
import xueqiao.company.GroupUserPage;
import xueqiao.company.HostingServiceStatus;
import xueqiao.hosting.machine.HostingMachineAssignStatus;
import xueqiao.hosting.machine.HostingRelatedInfo;
import xueqiao.trade.hosting.HostingInfo;
import xueqiao.trade.hosting.HostingStatus;
import xueqiao.trade.hosting.QueryHostingUserOption;
import xueqiao.trade.hosting.QueryHostingUserPage;
import xueqiao.trade.hosting.cloud.ao.HostingResetReq;
import xueqiao.trade.hosting.cloud.ao.client.TradeHostingCloudAoStub;

import java.io.IOException;

public class SledHostingDebug extends OaAuthController {

    public void show() throws Exception {
        String hostingIP = parameter("hostingIP", "");
        AppLog.e("SledHostingDebug # show ---- hostingIP : " + hostingIP);
        put("hostingIP", hostingIP);
        render("sled_hosting_debug.html");
    }

    public void queryCompanyInfo() throws IOException {
        ErrorResult result = new ErrorResult();

        String hostingIP = parameter("hostingIP", "");

        if (StringUtils.isBlank(hostingIP)) {
            return;
        }
        TradeHostingCloudAoStub tradeHostingCloudAoStub = new TradeHostingCloudAoStub();

        try {
            tradeHostingCloudAoStub.setPeerAddr(hostingIP);
            HostingInfo hostingInfo = tradeHostingCloudAoStub.getHostingInfo();
            echoJson(hostingInfo);
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

    public void queryCompanyUsersInfo() throws IOException {
        ErrorResult result = new ErrorResult();

        String hostingIP = parameter("hostingIP", "");

        TradeHostingCloudAoStub tradeHostingCloudAoStub = new TradeHostingCloudAoStub();

        try {
            tradeHostingCloudAoStub.setPeerAddr(hostingIP);
            QueryHostingUserOption queryOption = new QueryHostingUserOption();
            IndexedPageOption pageOption = new IndexedPageOption();
            pageOption.setPageIndex(0).setPageSize(50).setNeedTotalCount(true);
            QueryHostingUserPage queryHostingUserPage = tradeHostingCloudAoStub.getHostingUserPage(queryOption, pageOption);

//            QueryHostingUserPage queryHostingUserPageRet = new QueryHostingUserPage();
//            queryHostingUserPageRet.setTotalCount(queryHostingUserPage.getTotalCount());
//            queryHostingUserPageRet.setResultList(queryHostingUserPage.getResultList());
//            String hostingUsersInfo = new Gson().toJson(queryHostingUserPage.getResultList());
            echoJson(queryHostingUserPage.getResultList());
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

    public void resetHosting() throws IOException {
        ErrorResult result = new ErrorResult();

        String hostingIP = parameter("hostingIP", "");
        int machineId = parameter("machineId", 0);
        String aes16key = parameter("aes16key", "");

        TradeHostingCloudAoStub tradeHostingCloudAoStub = new TradeHostingCloudAoStub();

        try {
            tradeHostingCloudAoStub.setPeerAddr(hostingIP);
            HostingResetReq req = new HostingResetReq();

            req.setHostingAES16Key(aes16key);
            req.setMachineId(machineId);

            tradeHostingCloudAoStub.resetHosting(req);
            result.setErrorCode(0);
            result.setErrorMsg("重置成功");
            echoJson(result);
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

    public void unbindHostingMachine() throws IOException {

        ErrorResult result = new ErrorResult();

        String oaUserName = getUserName();
        if (oaUserName == null || oaUserName.isEmpty()) {
            result.setErrorCode(5);
            result.setErrorMsg("登录信息过期，请重新登录后再操作");
            echoJson(result);
            return;
        }

        int machineId = parameter("machineId", 0);

        try {
            // query relativeInfo
            HostingRelatedInfo hostingRelatedInfo = MXueqiaoHostMachine.getInstance().queryRelatedInfoByMachineId(machineId);
            if (hostingRelatedInfo == null) {
                result.setErrorCode(5);
                result.setErrorMsg("查找不到关联公司服务组信息，请确认是否已经解绑");
                echoJson(result);
                return;
            }

            TradeHostingCloudAoStub tradeHostingCloudAoStub = new TradeHostingCloudAoStub();
            tradeHostingCloudAoStub.setPeerAddr(hostingRelatedInfo.getMachineInnerIP());
            HostingInfo hostingInfo = tradeHostingCloudAoStub.getHostingInfo();
            if (hostingInfo.getStatus() != HostingStatus.EMPTY) {
                result.setErrorCode(0);
                result.setErrorMsg("绑定的托管机(" + hostingRelatedInfo.getMachineInnerIP() + ") 未处于空状态，请确认后再操作");
                echoJson(result);
                return;
            }

            // reset hosting machine status
            MXueqiaoHostMachine.getInstance().updateHostingMachineAssignStatus(machineId, HostingMachineAssignStatus.RAW);

            // remove related info
            MXueqiaoHostMachine.getInstance().removeRelatedInfo(hostingRelatedInfo.getRelatedId());

            // update company group spec status
            CompanyGroupSpec updateGroupSpec = new CompanyGroupSpec();
            updateGroupSpec.setCompanyId(hostingRelatedInfo.getCompanyId());
            updateGroupSpec.setGroupId(hostingRelatedInfo.getCompanyGroupId());
            updateGroupSpec.setHostingServiceStatus(HostingServiceStatus.RELEASED);
            updateGroupSpec.setReleaseTimestamp(TimeUtil.getCurrentTimeSeconds());
            updateGroupSpec.setOperateDescription(oaUserName + ": force release");
            MXueqiaoUserCenter.getInstance().updateCompanyGroupSpec(updateGroupSpec);

            // delete group users
            GroupUserPage groupUserPage = MXueqiaoUserCenter.getInstance().queryGroupUserList(hostingRelatedInfo.getCompanyId(), hostingRelatedInfo.getCompanyGroupId());
            if (groupUserPage != null && groupUserPage.getPageSize() > 0) {
                for (GroupUser groupUser : groupUserPage.getPage()) {
                    MXueqiaoUserCenter.getInstance().deleteCompanyGroupUser(hostingRelatedInfo.getCompanyId(), hostingRelatedInfo.getCompanyGroupId(), groupUser.getUserId());
                }
            }

            result.setErrorCode(0);
            result.setErrorMsg("解绑成功");
            echoJson(result);
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
}
