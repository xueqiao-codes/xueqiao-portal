package com.longsheng.xueqiao.admin.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.longsheng.xueqiao.admin.helper.Mapper;
import com.longsheng.xueqiao.admin.module.hosting.MXueqiaoHosting;
import com.longsheng.xueqiao.admin.module.sms.SmsHandler;
import com.longsheng.xueqiao.admin.util.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.page.IndexedPageOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.web_framework.model.ErrorResult;

import com.longsheng.xueqiao.admin.bean.LocalHostingMachineInfo;
import com.longsheng.xueqiao.admin.bean.LocalOrder;
import com.longsheng.xueqiao.admin.bean.LocalOrderAllocateSpecInfo;
import com.longsheng.xueqiao.admin.bean.LocalOrderDetail;
import com.longsheng.xueqiao.admin.bean.LocalOrderFlow;
import com.longsheng.xueqiao.admin.bean.LocalOrderPage;
import com.longsheng.xueqiao.admin.bean.LocalOrderUpgradeSpecInfo;
import com.longsheng.xueqiao.admin.module.MXueqiaoConfig;
import com.longsheng.xueqiao.admin.module.hosting.MXueqiaoHostMachine;
import com.longsheng.xueqiao.admin.module.user.MXueqiaoUserCenter;
import com.longsheng.xueqiao.admin.module.user.MXueqiaoUserCenterPayment;
import com.longsheng.xueqiao.admin.util.TimeFormator;
import com.longsheng.xueqiao.aliyun.resource.thriftapi.EcsInstance;
import com.longsheng.xueqiao.payment.product.thriftapi.Product;
import com.longsheng.xueqiao.payment.thriftapi.Order;
import com.longsheng.xueqiao.payment.thriftapi.OrderFlow;
import com.longsheng.xueqiao.payment.thriftapi.OrderFlowPage;
import com.longsheng.xueqiao.payment.thriftapi.OrderPage;
import com.longsheng.xueqiao.payment.thriftapi.OrderStatus;

import xueqiao.company.*;
import xueqiao.hosting.machine.*;
import xueqiao.hosting.machine.dao.client.HostingMachineDaoStub;
import xueqiao.hosting.taskqueue.SyncInitHostingTask;
import xueqiao.hosting.taskqueue.TaskType;
import xueqiao.trade.hosting.HostingInfo;
import xueqiao.trade.hosting.HostingRunningMode;
import xueqiao.trade.hosting.HostingStatus;

public class SledOrderAdmin extends OaAuthController {

    public void show() throws Exception {
        render("sled_order_admin.html");
    }

    public void queryOrderList() throws IOException {
        ErrorResult result = new ErrorResult();

        int requestPage = parameter("requestPage", 1);
        int orderId = parameter("orderId", 0);
        int companyId = parameter("companyId", 0);
        int productId = parameter("productId", 0);
        String status = parameter("status", "");

        AppLog.i("SledOrderAdmin ---- queryOrderList ---- requestPage : " + requestPage + ", orderId : " + orderId + ", companyId : " + companyId + ", productId : " + productId + ", status : " + status);

        if (requestPage < 1) {
            requestPage = 1;
        }

        OrderPage orderPage = null;
        try {
            orderPage = MXueqiaoUserCenterPayment.getInstance().queryOrderList(requestPage - 1, orderId, companyId, productId, status);

            if (orderPage != null) {
                AppLog.i("SledOrderAdmin ---- queryOrderList ---- orderPage size : " + orderPage.getPageSize());
                LocalOrderPage localOrderPage = new LocalOrderPage();
                localOrderPage.setOrderList(getLocalOrderListFromOrderList(orderPage.getPage()));
                localOrderPage.setTotalNum(orderPage.getTotal());
                localOrderPage.setTotalPage((orderPage.getTotal() + MXueqiaoUserCenterPayment.PAGE_SIZE - 1) / MXueqiaoUserCenterPayment.PAGE_SIZE);
                localOrderPage.setCurrentPage(requestPage);
                echoJson(localOrderPage);
            } else {
                result.setErrorCode(5);
                result.setErrorMsg("查找订单失败");
                echoJson(result);
            }
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

    public void queryUpgradeSpecInfo() throws IOException {
        ErrorResult result = new ErrorResult();

        int orderId = parameter("orderId", 0);
        int companyId = parameter("companyId", 0);
        int groupId = parameter("groupId", 0);
        int productId = parameter("productId", 0);

        AppLog.i("SledOrderAdmin ---- queryUpgradeSpecInfo ---- productId : " + productId + ", groupId : " + groupId + ", companyId : " + companyId + ", orderId : " + orderId);

        try {
            HostingRelatedInfo hostingRelatedInfo = MXueqiaoHostMachine.getInstance().queryRelatedInfoById(companyId, groupId);
            HostingMachine hostingMachine = null;
            if (hostingRelatedInfo != null) {
                hostingMachine = MXueqiaoHostMachine.getInstance().queryHostMachineById(hostingRelatedInfo.getMachineId());
            }

            Product product = MXueqiaoUserCenterPayment.getInstance().queryOrderProductById(productId);
            if (hostingMachine != null && product != null) {
                LocalOrderUpgradeSpecInfo localOrderUpgradeSpecInfo = new LocalOrderUpgradeSpecInfo();
                localOrderUpgradeSpecInfo.setOrderId(orderId);
                localOrderUpgradeSpecInfo.setCurrentType(product.getType().name());
                localOrderUpgradeSpecInfo.setPurposeType(product.getPurposeType().name());
                localOrderUpgradeSpecInfo.setDescription(product.getDescription());
                localOrderUpgradeSpecInfo.setMachineId(hostingMachine.getMachineId());
                localOrderUpgradeSpecInfo.setMachineSpec(hostingMachine.getMachineSpec().getCpuCount() + "核, 内存" + hostingMachine.getMachineSpec().getMemoryGB() + "GB, 带宽" + hostingMachine.getMachineSpec().getOutIfBandMB() + "MB");
                echoJson(localOrderUpgradeSpecInfo);
                return;
            } else {
                result.setErrorCode(7);
                result.setErrorMsg("查找商品或机器信息失败");
                echoJson(result);
                return;
            }

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

    public void queryAllocateSpecInfo() throws IOException {
        ErrorResult result = new ErrorResult();

        int orderId = parameter("orderId", 0);
        int companyId = parameter("companyId", 0);
        int groupId = parameter("groupId", 0);
        int productId = parameter("productId", 0);

        AppLog.i("SledOrderAdmin ---- queryAllocateSpecInfo ---- productId : " + productId + ", groupId : " + groupId + ", companyId : " + companyId + ", orderId : " + orderId);

        try {
            List<LocalHostingMachineInfo> localHostingMachineInfoList = queryNotAssignedHostingMachineList();

            Product product = MXueqiaoUserCenterPayment.getInstance().queryOrderProductById(productId);
            if (product != null) {
                LocalOrderAllocateSpecInfo localOrderAllocateSpecInfo = new LocalOrderAllocateSpecInfo();
                localOrderAllocateSpecInfo.setOrderId(orderId);
                localOrderAllocateSpecInfo.setCompanyId(companyId);
                localOrderAllocateSpecInfo.setGroupId(groupId);
                localOrderAllocateSpecInfo.setCurrentType(product.getType().name());
                localOrderAllocateSpecInfo.setTimeIncrement(product.getTimeIncrement() / MXueqiaoConfig.SECONDS_PER_DAY);
                localOrderAllocateSpecInfo.setHostingMachineInfoList(localHostingMachineInfoList);
                echoJson(localOrderAllocateSpecInfo);
                return;
            } else {
                result.setErrorCode(7);
                result.setErrorMsg("查找商品信息失败");
                echoJson(result);
                return;
            }

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

    public void confirmUpgradeSpec() throws IOException {
        ErrorResult result = new ErrorResult();

        int orderId = parameter("orderId", 0);
        String oaUserName = getUserName();
        AppLog.i("SledOrderAdmin ---- confirmUpgradeSpec ---- orderId : " + orderId + ", oaUserName : " + oaUserName);
        if (orderId <= 0) {
            result.setErrorCode(5);
            result.setErrorMsg("订单ID不正确, orderId : " + orderId);
            echoJson(result);
            return;
        }

        if (oaUserName == null || oaUserName.isEmpty()) {
            result.setErrorCode(5);
            result.setErrorMsg("登录信息过期，请重新登录后再操作");
            echoJson(result);
            return;
        }

        // query order
        Order order = null;
        try {
            order = MXueqiaoUserCenterPayment.getInstance().queryOrderById(orderId);
        } catch (ErrorInfo errorInfo) {
            errorInfo.printStackTrace();
            result.setErrorCode(errorInfo.getErrorCode());
            result.setErrorMsg(errorInfo.getErrorMsg());
            echoJson(result);
            return;
        } catch (Throwable e) {
            e.printStackTrace();
            result.setErrorCode(5);
            result.setErrorMsg("服务器繁忙,查找订单失败");
            echoJson(result);
            return;
        }
        if (order == null) {
            result.setErrorCode(6);
            result.setErrorMsg("查找订单失败(orderId:" + orderId + ")");
            echoJson(result);
            return;
        }

        try {
//            updateHostedService(order);
//            MXueqiaoUserCenterPayment.getInstance().modifyOrder(orderId, oaUserName, OrderStatus.SUCCESS);
            MXueqiaoUserCenter.getInstance().doUpgradeGroupSpec(orderId, oaUserName);

            // send sms to user
            sendSms(order);
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

    private void sendSms(Order order) throws TException {
        CompanyEntry companyEntry = MXueqiaoUserCenter.getInstance().queryCompanyById(order.getCompanyId());
        if (companyEntry == null) {
            AppLog.e("SledOrderAdmin ---- sendSms ---- companyEntry is null ---- companyId : " + order.getCompanyId());
            return;
        }
        SmsHandler.getInstance().sendUserNotificationSms(companyEntry, order.getCompanyGroupName(), SmsHandler.UPGRADE_HOSINT_MACHINE);
    }

    /**
     * 订单支付完成后，更新托管机的规格和到期日
     */
//    private void updateHostedService(Order order) throws TException {
//        com.longsheng.xueqiao.payment.thriftapi.CompanyGroupSpec companyGroupSpecFromPaymentDao = MXueqiaoUserCenterPayment.getInstance().queryCompanyGroupSpecFromPaymentDao(order.getCompanyId(), order.getCompanyGroupId());
//        if (companyGroupSpecFromPaymentDao == null) {
//            throw new ErrorInfo(90005, "fail to find companyGroupSpec in paymentDao ---- companyId : " + order.getCompanyId() + ", groupId : " + order.getCompanyGroupId());
//        }
//
//        CompanyGroupSpec updateGroupSpec = new CompanyGroupSpec();
//        updateGroupSpec.setCompanyId(companyGroupSpecFromPaymentDao.getCompanyId());
//        updateGroupSpec.setGroupId(companyGroupSpecFromPaymentDao.getGroupId());
//        updateGroupSpec.setExpiredTimestamp(companyGroupSpecFromPaymentDao.getExpiredTimestamp());
//        updateGroupSpec.setHostingServiceStatus(HostingServiceStatus.WORKING);
//        updateGroupSpec.setSpecName(companyGroupSpecFromPaymentDao.getProductType().name());
//        MXueqiaoUserCenter.getInstance().updateCompanyGroupSpec(updateGroupSpec);
//    }
    public void confirmAllocateSpec() throws IOException {
        ErrorResult result = new ErrorResult();

        int orderId = parameter("orderId", 0);
        int companyId = parameter("companyId", 0);
        int groupId = parameter("groupId", 0);
        long machineId = parameter("machineId", 0);

        AppLog.i("SledOrderAdmin ---- confirmAllocateSpec ---- orderId : " + orderId + ", companyId : " + companyId + ", groupId : " + groupId + ", machineId : " + machineId);
        if (orderId <= 0) {
            result.setErrorCode(5);
            result.setErrorMsg("订单ID不正确, orderId : " + orderId);
            echoJson(result);
            return;
        }
        if (machineId <= 0) {
            result.setErrorCode(6);
            result.setErrorMsg("machineId不正确, machineId : " + machineId);
            echoJson(result);
            return;
        }

        String oaUserName = getUserName();
        if (oaUserName == null || oaUserName.isEmpty()) {
            result.setErrorCode(5);
            result.setErrorMsg("登录信息过期，请重新登录后再操作");
            echoJson(result);
            return;
        }

        // 查询托管机状态，如果已提交任务，如分配成功，则不再执行，避免重复操作
        Order order = null;
        try {
            order = MXueqiaoUserCenterPayment.getInstance().queryOrderById(orderId);
        } catch (TException e) {
            AppLog.e("SledOrderAdmin ---- queryOrderById fail ---- e : " + e.toString());
            e.printStackTrace();
        }
        if (order == null) {
            result.setErrorCode(6);
            result.setErrorMsg("查找不到订单信息，订单号（" + orderId + ")");
            echoJson(result);
            return;
        }
        if (order.getStatus().getValue() >= OrderStatus.MANUAL_PROCESSING.getValue()) {
            result.setErrorCode(6);
            result.setErrorMsg("已提交初始化托管机任务，请勿重复提交");
            echoJson(result);
            return;
        }

        try {
            HostingRelatedInfo hostingRelatedInfo = MXueqiaoHostMachine.getInstance().queryRelatedInfoByMachineId(machineId);
            if (hostingRelatedInfo != null) {
                result.setErrorCode(7);
                result.setErrorMsg("出错，机器已关联, machineId : " + hostingRelatedInfo.getMachineId());
                echoJson(result);
                return;
            }
        } catch (ErrorInfo errorInfo) {
            AppLog.i("SledOrderAdmin ---- confirmAllocateSpec --ErrorInfo-- orderId : " + orderId);
            errorInfo.printStackTrace();
            result.setErrorCode(errorInfo.getErrorCode());
            result.setErrorMsg(errorInfo.getErrorMsg());
            echoJson(result);
            return;
        } catch (Throwable e) {
            AppLog.i("SledOrderAdmin ---- confirmAllocateSpec --Throwable-- orderId : " + orderId);
            e.printStackTrace();
            result.setErrorCode(5);
            result.setErrorMsg("服务器繁忙");
            echoJson(result);
            return;
        }

        // init hosting
        try {
            initHosting(companyId, groupId, orderId, machineId, oaUserName);
        } catch (ErrorInfo errorInfo) {
            AppLog.e("SledOrderAdmin ---- initHosting ---- e : " + errorInfo.toString());
            result.setErrorCode(errorInfo.getErrorCode());
            result.setErrorMsg("提交初始化托管机任务失败 : " + errorInfo.getErrorMsg());
            echoJson(result);
            return;
        } catch (Throwable e) {
            e.printStackTrace();
            result.setErrorCode(6);
            result.setErrorMsg("服务器繁忙，提交初始化托管机任务失败");
            echoJson(result);
            return;
        }

        result.setErrorCode(0);
        echoJson(result);
    }

    public void confirmAllocatePersonalUserHostingService() throws IOException, TException {
        ErrorResult result = new ErrorResult();
        int orderId = parameter("orderId", 0);

        if (orderId < 1) {
            result.setErrorCode(4);
            result.setErrorMsg("无效的orderId : " + orderId);
            echoJson(result);
            return;
        }

        String oaUserName = getUserName();
        if (oaUserName == null || oaUserName.isEmpty()) {
            result.setErrorCode(5);
            result.setErrorMsg("登录信息过期，请重新登录后再操作");
            echoJson(result);
            return;
        }

        Order order = MXueqiaoUserCenterPayment.getInstance().modifyOrder(orderId, oaUserName, OrderStatus.SUCCESS);

        /*
        * 完成分配时，发送短信告知用户
        * */
        String tel = getOrderUserTel(order);
        if (StringUtils.isNotBlank(tel)) {
            SmsHandler.getInstance().sendPersonalUserHostingServiceAllocateCompletedSms(tel);
        }

        result.setErrorCode(0);
        echoJson(result);
    }

    private void initHosting(int companyId, int groupId, int orderId, long machineId, String oaUserName) throws TException {

        // query company group aes16key
        CompanyGroup companyGroup = MXueqiaoUserCenter.getInstance().queryCompanyGroupById(companyId, groupId);
        if (companyGroup == null || StringUtils.isBlank(companyGroup.getHostingAES16Key())) {
            throw new ErrorInfo(8000, "查找不到公司组的AES16KEY(companyId : " + companyId + ", groupId : " + groupId + ")");
        }

        // query running mode
        CompanyGroupSpec companyGroupSpec = MXueqiaoUserCenter.getInstance().queryCompanyGroupSpec(companyId, groupId);
        if (companyGroupSpec == null) {
            throw new ErrorInfo(8001, "查找不到公司组规格信息(companyId : " + companyId + ", groupId : " + groupId + ")");
        }
        TradeType tradeType = companyGroupSpec.getServiceType();

        // query hosting machine IP
        HostingMachine hostingMachine = MXueqiaoHostMachine.getInstance().queryHostMachineById(machineId);
        if (hostingMachine == null) {
            throw new ErrorInfo(8002, "查找不到托管机信息(machineId : " + machineId + ")");
        }

        // 获取托管机状态, 非空机状态的托管机不能关联
        HostingInfo hostingInfo = MXueqiaoHosting.getInstance().queryHostingInfo(hostingMachine.getMachineInnerIP());
        if (AppLog.infoEnabled()) {
            AppLog.i("initHosting ---- hostingInfo : " + new Gson().toJson(hostingInfo));
        }
        if (hostingInfo == null || hostingInfo.getStatus() != HostingStatus.EMPTY) {
            throw new ErrorInfo(8003, "托管机非空机状态，不能关联");
        }

        // submit initHosting task
        SyncInitHostingTask task = new SyncInitHostingTask();
        task.setTaskType(TaskType.INIT_HOSTING);
        task.setMachineInnerIP(hostingMachine.getMachineInnerIP());
        task.setCompanyId(companyId);
        task.setGroupId(groupId);
        task.setOrderId(orderId);
        task.setOaUserName(oaUserName);
        task.setMachineId(machineId);
        task.setHostingAES16Key(companyGroup.getHostingAES16Key());
        if (TradeType.REAL == tradeType) {
            task.setRunningMode(HostingRunningMode.REAL_HOSTING.name());
        } else if (TradeType.SIM == tradeType) {
            task.setRunningMode(HostingRunningMode.SIM_HOSTING.name());
        } else {
            throw new ErrorInfo(8001, "公司组规格信息中交易类型不正确(companyId : " + companyId + ", groupId : " + groupId + ", tradeType : " + tradeType + ")");
        }

        // 提交初始化托管机任务
        InitHostingMachineReq initHostingMachineReq = new InitHostingMachineReq();
        initHostingMachineReq.setCompanyId(companyId);
        initHostingMachineReq.setGroupId(groupId);
        initHostingMachineReq.setInitHostingTask(task);
        /*
         * 提交初始化托管机任务
         * 1 提交初始化托管机任务
         * 2 提交添加用户任务
         * 3 设置机器预绑定状态
         * 4 设置订单状态为 MANUAL_PROCESSING
         * */
        MXueqiaoUserCenter.getInstance().submitInitHostingMachineTask(initHostingMachineReq);
    }

    public void queryOrderFlow() throws IOException {
        ErrorResult result = new ErrorResult();

        int orderId = parameter("orderId", 0);

        AppLog.i("SledOrderAdmin ---- queryOrderFlow ---- orderId : " + orderId);

        try {
            OrderFlowPage OrderFlowPage = MXueqiaoUserCenterPayment.getInstance().queryOrderFlow(orderId);
            if (OrderFlowPage != null && OrderFlowPage.getPageSize() > 0) {
                LocalOrderDetail localOrderDetail = new LocalOrderDetail();
                List<LocalOrderFlow> localOrderFlowList = new ArrayList<LocalOrderFlow>();

                for (OrderFlow orderFlow : OrderFlowPage.getPage()) {
                    LocalOrderFlow localOrderFlow = new LocalOrderFlow();
                    localOrderFlow.setOrderId(orderFlow.getOrderId());
                    localOrderFlow.setFlowId(orderFlow.getFlowId());

                    StringBuilder descriptionBuilder = new StringBuilder();

                    descriptionBuilder.append("(").append(orderFlow.getDescription()).append(")");
                    descriptionBuilder.append(Mapper.getOrderStatusString(orderFlow.getStatus()));

                    localOrderFlow.setDescription(descriptionBuilder.toString());
                    localOrderFlow.setStatus(orderFlow.getStatus().name());
                    localOrderFlow.setCreateTimestamp(TimeFormator.timeStampToDate(orderFlow.getCreateTimestamp()));

                    localOrderFlowList.add(localOrderFlow);
                }

                localOrderDetail.setOrderFlowList(localOrderFlowList);
                echoJson(localOrderDetail);
                return;
            } else {
                result.setErrorCode(7);
                result.setErrorMsg("查找订单流信息为空，订单号： " + orderId);
                echoJson(result);
                return;
            }

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

    private List<LocalHostingMachineInfo> queryNotAssignedHostingMachineList() throws ErrorInfo, TException {

        HostingMachineDaoStub hostingMachineDaoStub = new HostingMachineDaoStub();

        QueryHostingMachineOption queryHostingMachineOption = new QueryHostingMachineOption();
//		queryHostingMachineOption.setMachineAssignStatus(HostingMachineAssignStatus.NOT_ASSIGNED);

        IndexedPageOption indexedPageOption = new IndexedPageOption();
        indexedPageOption.setPageIndex(0);
        indexedPageOption.setPageSize(MXueqiaoConfig.PAGE_SIZE_MAX);
        HostingMachinePageResult hostingMachinePageResult = hostingMachineDaoStub.queryHostingMachinePage(queryHostingMachineOption, indexedPageOption);

        AppLog.i("SledOrderAdmin ---- queryHostingMachineList ---- hostingMachinePageResult : " + hostingMachinePageResult.getResultListSize());

        List<LocalHostingMachineInfo> LocalHostingMachineInfoList = new ArrayList<LocalHostingMachineInfo>();

        for (HostingMachine hostingMachine : hostingMachinePageResult.resultList) {
            if (hostingMachine.getMachineAssignStatus() == HostingMachineAssignStatus.RAW ||
                    hostingMachine.getMachineAssignStatus() == HostingMachineAssignStatus.NOT_ASSIGNED) {
                LocalHostingMachineInfo localHostingMachineInfo = new LocalHostingMachineInfo();
                localHostingMachineInfo.setMachineId(hostingMachine.getMachineId());
                localHostingMachineInfo.setMachineHostname(hostingMachine.getMachineHostname());
                localHostingMachineInfo.setMachineAssignStatus(hostingMachine.getMachineAssignStatus().name());
                localHostingMachineInfo.setInstanceId(hostingMachine.getInstanceId());
                localHostingMachineInfo.setRegionId(hostingMachine.getRegionId());

                EcsInstance ecsInstance = MXueqiaoHostMachine.getInstance().queryEcsInstance(hostingMachine.getInstanceId(), hostingMachine.getRegionId());
                if (ecsInstance != null) {
                    localHostingMachineInfo.setAliyunInstanceId(ecsInstance.getAliyunInstanceId());
                    localHostingMachineInfo.setZoneId(ecsInstance.getZoneId());
                    localHostingMachineInfo.setInnerIpAddress(ecsInstance.getInnerIpAddress());
                    localHostingMachineInfo.setPublicIpAddress(ecsInstance.getPublicIpAddress());
                    localHostingMachineInfo.setIpAddress(ecsInstance.getPublicIpAddress() + "(公)</br>" + ecsInstance.getInnerIpAddress() + "(私有)");

                    localHostingMachineInfo.setRunningStatus(ecsInstance.getRunningStatus().name());
                    localHostingMachineInfo.setInstanceNetworkType(ecsInstance.getInstanceNetworkType().name());
                    localHostingMachineInfo.setMachineSpec(ecsInstance.getMachineSpec().getCpuCount() + "核, 内存" + ecsInstance.getMachineSpec().getMemoryGB() + "GB, 带宽" + ecsInstance.getMachineSpec().getOutIfBandMB() + "MB");
                    localHostingMachineInfo.setInstanceChargeType(ecsInstance.getInstanceChargeType().name());
                    localHostingMachineInfo.setAliyunExpiredTime(TimeFormator.timeStampToDate2(ecsInstance.getAliyunExpiredTimestamp()));
                }
                LocalHostingMachineInfoList.add(localHostingMachineInfo);
            }
        }

        return LocalHostingMachineInfoList;
    }

    private List<LocalOrder> getLocalOrderListFromOrderList(List<Order> orderList) throws ErrorInfo, TException {
        List<LocalOrder> localOrderList = new ArrayList<LocalOrder>();

        for (Order order : orderList) {
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

            localOrder.setExtraInfo(getOrderExtraInfo(order));

            CompanyEntry companyEntry = MXueqiaoUserCenter.getInstance().queryCompanyById(order.getCompanyId());
            if (companyEntry != null) {
                localOrder.setCompanyName(companyEntry.getCompanyName());
            }

            CompanyGroup companyGroup = MXueqiaoUserCenter.getInstance().queryCompanyGroupById(order.getCompanyId(), order.getCompanyGroupId());
            if (companyGroup != null) {
                localOrder.setCompanyGroupName(companyGroup.getGroupName());
            }

            localOrderList.add(localOrder);
        }

        return localOrderList;
    }

    private static String getOrderExtraInfo(Order order) {
        String tel = getOrderUserTel(order);
        if (StringUtils.isNotBlank(tel)) {
            return "用户手机号：" + tel;
        }
        return "";
    }

    private static String getOrderUserTel(Order order) {
        Map<String, String> extraInfoMap = StringUtil.string2Map(order.getExtraInfo());
        return extraInfoMap.get("tel");
    }
}
