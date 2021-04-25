package com.longsheng.xueqiao.admin.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.longsheng.xueqiao.admin.bean.hosting.ReleaseHostingDescription;
import com.longsheng.xueqiao.admin.module.sms.SmsHandler;
import com.longsheng.xueqiao.admin.util.TimeUtil;
import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.web_framework.model.ErrorResult;

import com.longsheng.xueqiao.admin.bean.LocalCompanyHostingService;
import com.longsheng.xueqiao.admin.bean.LocalCompanyHostingServiceGroup;
import com.longsheng.xueqiao.admin.bean.LocalHostingMachineInfo;
import com.longsheng.xueqiao.admin.bean.LocalOrder;
import com.longsheng.xueqiao.admin.module.hosting.MXueqiaoHostMachine;
import com.longsheng.xueqiao.admin.module.user.MXueqiaoUserCenter;
import com.longsheng.xueqiao.admin.module.user.MXueqiaoUserCenterPayment;
import com.longsheng.xueqiao.admin.util.TimeFormator;
import com.longsheng.xueqiao.aliyun.resource.thriftapi.EcsInstance;
import com.longsheng.xueqiao.payment.thriftapi.Order;
import com.longsheng.xueqiao.payment.thriftapi.OrderPage;

import xueqiao.company.*;
import xueqiao.hosting.machine.HostingMachine;
import xueqiao.hosting.machine.HostingMachineAssignStatus;
import xueqiao.hosting.machine.HostingRelatedInfo;
import xueqiao.trade.hosting.HostingInfo;
import xueqiao.trade.hosting.HostingStatus;
import xueqiao.trade.hosting.cloud.ao.HostingResetReq;
import xueqiao.trade.hosting.cloud.ao.client.TradeHostingCloudAoStub;

public class SledCompanyHostingServiceAdmin extends OaAuthController {

    public void show() throws Exception {

        int companyId = parameter("companyId", -1);
        String companyName = parameter("companyName", "");

        AppLog.i("SledCompanyHostingServiceAdmin ---- show ---- companyId : " + companyId);
        put("companyId", companyId);
        put("companyName", companyName);
        render("sled_company_hosting_service_admin.html");
    }

    public void querycompanyHostingServiceList() throws IOException {
        ErrorResult result = new ErrorResult();

        int companyId = parameter("companyId", 0);

        AppLog.i("SledCompanyHostingServiceAdmin ---- querycompanyHostingServiceList ---- companyId : " + companyId);

        LocalCompanyHostingService companyHostingService = new LocalCompanyHostingService();
        companyHostingService.setCompanyId(companyId);
        try {
            List<LocalCompanyHostingServiceGroup> hostingServiceGroupList = new ArrayList<LocalCompanyHostingServiceGroup>();

            CompanyGroupPageResult companyGroupPageResult = MXueqiaoUserCenter.getInstance().queryCompanyGroupList(companyId);
            OrderPage orderPage = MXueqiaoUserCenterPayment.getInstance().queryOrderList(companyId);

            if (companyGroupPageResult != null && companyGroupPageResult.getResultListSize() > 0) {
                for (CompanyGroup companyGroup : companyGroupPageResult.getResultList()) {
                    LocalCompanyHostingServiceGroup companyHostingServiceGroup = new LocalCompanyHostingServiceGroup();

                    //CompanyGroup
                    companyHostingServiceGroup.setCompanyId(companyGroup.getCompanyId());
                    companyHostingServiceGroup.setGroupId(companyGroup.getGroupId());
                    companyHostingServiceGroup.setGroupCode(companyGroup.getGroupCode());
                    companyHostingServiceGroup.setGroupName(companyGroup.getGroupName());

                    //CompanyGroupSpec
                    CompanyGroupSpec companyGroupSpec = MXueqiaoUserCenter.getInstance().queryCompanyGroupSpec(companyId, companyGroup.getGroupId());
                    if (companyGroupSpec != null) {
                        companyHostingServiceGroup.setHostingServiceStatus(companyGroupSpec.getHostingServiceStatus().name());
                        companyHostingServiceGroup.setServiceType(companyGroupSpec.getServiceType().name());
                        companyHostingServiceGroup.setSpecName(companyGroupSpec.getSpecName());
                        if (companyGroupSpec.getExpiredTimestamp() == 0) {
                            companyHostingServiceGroup.setExpiredTimestamp("-");
                        } else {
                            companyHostingServiceGroup.setExpiredTimestamp(TimeFormator.timeStampToDate2(companyGroupSpec.getExpiredTimestamp()));
                        }
                        companyHostingServiceGroup.setReleaseHostingDescription(ReleaseHostingDescription.getInstanceFromJson(companyGroupSpec.getOperateDescription()));
                    }

                    //machine
                    HostingRelatedInfo hostingRelatedInfo = MXueqiaoHostMachine.getInstance().queryRelatedInfoById(companyId, companyGroup.getGroupId());
                    LocalHostingMachineInfo hostingMachineInfo = new LocalHostingMachineInfo();
                    if (hostingRelatedInfo != null) {
                        hostingMachineInfo.setMachineId(hostingRelatedInfo.getMachineId());

                        HostingMachine hostingMachine = MXueqiaoHostMachine.getInstance().queryHostMachineById(hostingRelatedInfo.getMachineId());
                        if (hostingMachine != null) {
                            hostingMachineInfo.setMachineHostname(hostingMachine.getMachineHostname());
                            EcsInstance ecsInstance = MXueqiaoHostMachine.getInstance().queryEcsInstance(hostingMachine.getInstanceId(), hostingMachine.getRegionId());
                            if (ecsInstance != null) {
                                hostingMachineInfo.setAliyunExpiredTime(TimeFormator.timeStampToDate(ecsInstance.getAliyunExpiredTimestamp()));
                                hostingMachineInfo.setAliyunInstanceId(ecsInstance.getAliyunInstanceId());
                                hostingMachineInfo.setRunningStatus(ecsInstance.getRunningStatus().name());
                            }
                        }
                    }
                    companyHostingServiceGroup.setHostingMachineInfo(hostingMachineInfo);

                    //order list
                    if (orderPage != null && orderPage.getPageSize() > 0) {
                        List<LocalOrder> orderList = new ArrayList<LocalOrder>();
                        for (Order order : orderPage.getPage()) {
                            if (order.getCompanyGroupId() == companyGroup.getGroupId()) {
                                LocalOrder localOrder = new LocalOrder();

                                localOrder.setOrderId(order.getOrderId());
                                localOrder.setSource(order.getSource());
                                localOrder.setProductId(order.getProductId());
                                localOrder.setCompanyId(order.getCompanyId());
                                localOrder.setCompanyGroupId(order.getCompanyGroupId());
                                localOrder.setProductName(order.getProductName());
                                localOrder.setProductDescription(order.getProductDescription());
                                localOrder.setProductQuantity(order.getProductQuantity());
                                localOrder.setPrice(order.getPrice());
                                localOrder.setCurrencyType(order.getCurrencyType());
                                localOrder.setTotalAmount(order.getTotalAmount());
                                localOrder.setPayType(order.getPayType());
                                localOrder.setThirdPartyOrderNo(order.getThirdPartyOrderNo());
                                localOrder.setStatus(order.getStatus());
                                localOrder.setTradeInfo(order.getTradeInfo());
                                localOrder.setNeedOperator(order.isNeedOperator());
                                localOrder.setOperator(order.getOperator());
                                localOrder.setOperation(order.getOperation());
                                localOrder.setCreateTimestamp(order.getCreateTimestamp());
                                localOrder.setLastModifyTimestamp(order.getCreateTimestamp());

                                orderList.add(localOrder);
                            }
                        }
                        companyHostingServiceGroup.setOrderList(orderList);
                    }

                    hostingServiceGroupList.add(companyHostingServiceGroup);
                }
                companyHostingService.setHostingServiceGroupList(hostingServiceGroupList);
            }
            echoJson(companyHostingService);
        } catch (ErrorInfo errorInfo) {
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

    public void releaseHostingService() throws IOException {
        ErrorResult result = new ErrorResult();

        String oaUserName = getUserName();
        if (oaUserName == null || oaUserName.isEmpty()) {
            result.setErrorCode(5);
            result.setErrorMsg("登录信息过期，请重新登录后再操作");
            echoJson(result);
            return;
        }

        int companyId = parameter("companyId", 0);
        int groupId = parameter("groupId", 0);
        String releaseReason = parameter("releaseReason", "");

        // query company group sepc
        CompanyGroupSpec companyGroupSpec = null;
        try {
            companyGroupSpec = MXueqiaoUserCenter.getInstance().queryCompanyGroupSpec(companyId, groupId);
        } catch (ErrorInfo errorInfo) {
            errorInfo.printStackTrace();
            result.setErrorCode(errorInfo.getErrorCode());
            result.setErrorMsg(errorInfo.getErrorMsg());
            echoJson(result);
            return;
        } catch (Throwable e) {
            e.printStackTrace();
            result.setErrorCode(5);
            result.setErrorMsg("服务器繁忙，获取公司组规格信息失败");
            echoJson(result);
            return;
        }
        if (companyGroupSpec == null) {
            AppLog.e("SledCompanyHostingServiceAdmin ---- releaseHostingService ---- fail to find company group spec （companyId:" + companyId + ", groupId:" + groupId + ")");
            result.setErrorCode(6);
            result.setErrorMsg("查找不到对应的公司组规格信息（companyId:" + companyId + ", groupId:" + groupId + ")");
            echoJson(result);
            return;
        }
        // check hosting service status
        if (companyGroupSpec.getHostingServiceStatus() != HostingServiceStatus.WORKING && companyGroupSpec.getHostingServiceStatus() != HostingServiceStatus.EXPIRED) {
            AppLog.e("SledCompanyHostingServiceAdmin ---- releaseHostingService ---- companyGroupSpec.getHostingServiceStatus() :" + companyGroupSpec.getHostingServiceStatus());
            result.setErrorCode(7);
            result.setErrorMsg("托管机不处于关联状态（未分配托管机或已释放）");
            echoJson(result);
            return;
        }

        // query company group (to get AES16KEY)
        CompanyGroup companyGroup = null;
        try {
            companyGroup = MXueqiaoUserCenter.getInstance().queryCompanyGroupById(companyId, groupId);
        } catch (ErrorInfo errorInfo) {
            errorInfo.printStackTrace();
            result.setErrorCode(errorInfo.getErrorCode());
            result.setErrorMsg(errorInfo.getErrorMsg());
            echoJson(result);
            return;
        } catch (Throwable e) {
            e.printStackTrace();
            result.setErrorCode(5);
            result.setErrorMsg("服务器繁忙，获取公司组规格信息失败");
            echoJson(result);
            return;
        }
        if (companyGroup == null) {
            AppLog.e("SledCompanyHostingServiceAdmin ---- releaseHostingService ---- fail to find company group （companyId:" + companyId + ", groupId:" + groupId + ")");
            result.setErrorCode(6);
            result.setErrorMsg("查找不到对应的公司组信息（companyId:" + companyId + ", groupId:" + groupId + ")");
            echoJson(result);
            return;
        }

        // query related info (to get machineIP and machineId)
        HostingRelatedInfo hostingRelatedInfo = null;
        try {
            hostingRelatedInfo = MXueqiaoHostMachine.getInstance().queryRelatedInfoById(companyId, groupId);
        } catch (ErrorInfo errorInfo) {
            errorInfo.printStackTrace();
            result.setErrorCode(errorInfo.getErrorCode());
            result.setErrorMsg(errorInfo.getErrorMsg());
            echoJson(result);
            return;
        } catch (Throwable e) {
            e.printStackTrace();
            result.setErrorCode(5);
            result.setErrorMsg("服务器繁忙，获取托管机关联信息失败（companyId:" + companyId + ", groupId:" + groupId + ")");
            echoJson(result);
            return;
        }
        if (hostingRelatedInfo == null) {
            AppLog.e("SledCompanyHostingServiceAdmin ---- releaseHostingService ---- fail to find hosting machine RelatedInfo （companyId:" + companyId + ", groupId:" + groupId + ")");
            result.setErrorCode(5);
            result.setErrorMsg("服务器繁忙，获取托管机关联信息失败（companyId:" + companyId + ", groupId:" + groupId + ")");
            echoJson(result);
            return;
        }

        /*
        * check if machine in aliyun is exist
        * */
        // 1 query hostingMachine by relatedInfo, to get instanceId and regionId
        HostingMachine hostingMachine = null;
        try {
            hostingMachine = MXueqiaoHostMachine.getInstance().queryHostMachineById(hostingRelatedInfo.getMachineId());
        } catch (ErrorInfo errorInfo) {
            errorInfo.printStackTrace();
            result.setErrorCode(errorInfo.getErrorCode());
            result.setErrorMsg(errorInfo.getErrorMsg());
            echoJson(result);
            return;
        } catch (Throwable e) {
            e.printStackTrace();
            result.setErrorCode(5);
            result.setErrorMsg("服务器繁忙，获取托管机信息失败（machineId:" + hostingRelatedInfo.getMachineId() + ")");
            echoJson(result);
            return;
        }
        if (hostingMachine == null) {
            AppLog.e("SledCompanyHostingServiceAdmin ---- releaseHostingService ---- fail to find hosting machine RelatedInfo （companyId:" + companyId + ", groupId:" + groupId + ")");
            result.setErrorCode(5);
            result.setErrorMsg("查找托管机信息失败（machineId:" + hostingRelatedInfo.getMachineId() + ")");
            echoJson(result);
            return;
        }

        // 2 query machine in aliyun by instanceId and regionId
        EcsInstance ecsInstance = null;
        try {
            ecsInstance = MXueqiaoHostMachine.getInstance().queryEcsInstance(hostingMachine.getInstanceId(), hostingMachine.getRegionId());
        } catch (ErrorInfo errorInfo) {
            errorInfo.printStackTrace();
            result.setErrorCode(errorInfo.getErrorCode());
            result.setErrorMsg(errorInfo.getErrorMsg());
            echoJson(result);
            return;
        } catch (Throwable e) {
            e.printStackTrace();
            result.setErrorCode(5);
            result.setErrorMsg("服务器繁忙，阿里云机器信息失败（instanceId:" + hostingMachine.getInstanceId() + ", regionId: " + hostingMachine.getRegionId() + ")");
            echoJson(result);
            return;
        }

        /*
        * reset hosting machine if machine exist
        * */
        if (ecsInstance != null) {
            // reset hosting machine
            TradeHostingCloudAoStub tradeHostingCloudAoStub = new TradeHostingCloudAoStub();
            try {
                tradeHostingCloudAoStub.setPeerAddr(hostingRelatedInfo.getMachineInnerIP());

                //query hostingInfo
                HostingInfo hostingInfo = tradeHostingCloudAoStub.getHostingInfo();
                if (hostingInfo.getStatus() == HostingStatus.NORMAL) {
                    HostingResetReq req = new HostingResetReq();
                    req.setHostingAES16Key(companyGroup.getHostingAES16Key());
                    req.setMachineId((int) hostingRelatedInfo.getMachineId());
                    tradeHostingCloudAoStub.resetHosting(req);
                } else {
                    result.setErrorCode(4);
                    result.setErrorMsg("托管机没有处于运行状态，请确认后再做操作");
                    echoJson(result);
                    return;
                }
            } catch (ErrorInfo errorInfo) {
                errorInfo.printStackTrace();
                result.setErrorCode(errorInfo.getErrorCode());
                result.setErrorMsg(errorInfo.getErrorMsg());
                echoJson(result);
                return;
            } catch (Throwable e) {
                e.printStackTrace();
                result.setErrorCode(5);
                result.setErrorMsg("服务器繁忙，托管机重置失败，释放托管机失败");
                echoJson(result);
                return;
            }
        } else {
            AppLog.e("SledCompanyHostingServiceAdmin ---- releaseHostingService ---- ecsInstance in aliyun is not exit");
        }

        /*
        * delete related info
        * */
        try {
            // reset hosting machine status
            MXueqiaoHostMachine.getInstance().updateHostingMachineAssignStatus(hostingRelatedInfo.getMachineId(), HostingMachineAssignStatus.RAW);

            // remove related info
            MXueqiaoHostMachine.getInstance().removeRelatedInfo(hostingRelatedInfo.getRelatedId());

            // update company group spec status
            CompanyGroupSpec updateGroupSpec = new CompanyGroupSpec();
            updateGroupSpec.setCompanyId(hostingRelatedInfo.getCompanyId());
            updateGroupSpec.setGroupId(hostingRelatedInfo.getCompanyGroupId());
            updateGroupSpec.setHostingServiceStatus(HostingServiceStatus.RELEASED);
            updateGroupSpec.setReleaseTimestamp(TimeUtil.getCurrentTimeSeconds());

            ReleaseHostingDescription releaseHostingDescription = new ReleaseHostingDescription();
            releaseHostingDescription.setOperator(oaUserName);
            releaseHostingDescription.setReleaseDay(TimeFormator.timeStampToDate2(updateGroupSpec.getReleaseTimestamp()));
            releaseHostingDescription.setReason(ReleaseHostingDescription.getForceReleaseReason(releaseReason));

            updateGroupSpec.setOperateDescription(releaseHostingDescription.toString());
            MXueqiaoUserCenter.getInstance().updateCompanyGroupSpec(updateGroupSpec);

            // delete group users
            GroupUserPage groupUserPage = MXueqiaoUserCenter.getInstance().queryGroupUserList(hostingRelatedInfo.getCompanyId(), hostingRelatedInfo.getCompanyGroupId());
            if (groupUserPage != null && groupUserPage.getPageSize() > 0) {
                for (GroupUser groupUser : groupUserPage.getPage()) {
                    MXueqiaoUserCenter.getInstance().deleteCompanyGroupUser(hostingRelatedInfo.getCompanyId(), hostingRelatedInfo.getCompanyGroupId(), groupUser.getUserId());
                }
            }

            // send sms to user, notify released hosting machine
            sendSms(companyId, companyGroup.getGroupName());

        } catch (ErrorInfo errorInfo) {
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

    private void sendSms(int companyId, String groupName) throws TException {
        CompanyEntry companyEntry = MXueqiaoUserCenter.getInstance().queryCompanyById(companyId);
        if (companyEntry == null) {
            AppLog.e("SledOrderAdmin ---- sendSms ---- companyEntry is null ---- companyId : " + companyId);
            return;
        }
        SmsHandler.getInstance().sendUserReleaseNotificationSms(companyEntry, groupName);
    }
}
