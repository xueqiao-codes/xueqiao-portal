package com.longsheng.xueqiao.admin.web.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.longsheng.xueqiao.admin.module.hosting.MXueqiaoHostMachine;
import com.longsheng.xueqiao.admin.module.hosting.MXueqiaoHosting;
import com.longsheng.xueqiao.admin.module.user.MXueqiaoUserCenter;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.thrift.TException;
import org.soldier.base.StringFactory;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.page.IndexedPageOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.web_framework.model.ErrorResult;
import org.soldier.platform.web_framework.util.GsonFactory;

import com.longsheng.xueqiao.admin.bean.LocalEcsInstance;
import com.longsheng.xueqiao.admin.bean.LocalHostingMachineInfo;
import com.longsheng.xueqiao.aliyun.resource.thriftapi.EcsInstance;
import com.longsheng.xueqiao.aliyun.resource.thriftapi.EcsInstancePage;
import com.longsheng.xueqiao.aliyun.resource.thriftapi.ReqEcsInstanceOption;
import com.longsheng.xueqiao.aliyun.resource.thriftapi.SynceEcsInstanceOption;
import com.longsheng.xueqiao.aliyun.resource.thriftapi.client.AliyunResourceAoServiceStub;

import xueqiao.company.CompanyEntry;
import xueqiao.company.CompanyGroup;
import xueqiao.hosting.machine.HostingMachine;
import xueqiao.hosting.machine.HostingMachineAssignStatus;
import xueqiao.hosting.machine.HostingMachinePageResult;
import xueqiao.hosting.machine.HostingRelatedInfo;
import xueqiao.hosting.machine.HostingRelatedInfoPageResult;
import xueqiao.hosting.machine.QueryHostingMachineOption;
import xueqiao.hosting.machine.QueryHostingRelatedInfoOption;
import xueqiao.hosting.machine.dao.client.HostingMachineDaoStub;
import xueqiao.trade.hosting.HostingInfo;

public class SledServerAdmin extends OaAuthController {
    private static SimpleDateFormat dateSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final int PAGE_SIZE = 10;
    private static final int PAGE_SIZE_FOR_ECS_INSTANCE = 40;
    private static final int PAGE_SIZE_MAX = Integer.MAX_VALUE;

    private int mTotalPage = 1;
    private int mTotalNum = 0;

    public void show() throws Exception {
        int companyId = parameter("companyId", 0);
        int groupId = parameter("groupId", 0);
        int machineId = parameter("machineId", 0);
        String innerIpAddress = parameter("innerIpAddress");
        String publicIpAddress = parameter("publicIpAddress");
        String machineAssignStatus = parameter("machineAssignStatus");
        if (groupId > 0 && companyId > 0 && machineId == 0) {
            try {
                HostingRelatedInfo hostingRelatedInfo = MXueqiaoHostMachine.getInstance().queryRelatedInfoById(companyId, groupId);
                if (hostingRelatedInfo != null) {
                    machineId = (int) hostingRelatedInfo.getMachineId();
                } else {
                    machineId = 1;
                }
            } catch (Exception e) {
                AppLog.e("SledServerAdmin # show ---- queryRelatedInfoById fail", e);
                machineId = 1;
            }
        }
        int requestPage = parameter("requestPage", 1);

        AppLog.i("SledServerAdmin ---- show ---- machineId : " + machineId + ", innerIpAddress : " + innerIpAddress + ", publicIpAddress : " + publicIpAddress + ", machineAssignStatus : " + machineAssignStatus + ", requestPage : " + requestPage);

        if (requestPage < 1) {
            requestPage = 1;
        }
        requestPage = queryHostingMachineList(requestPage - 1, machineId, innerIpAddress, publicIpAddress, machineAssignStatus);
        if (mTotalPage < 1) {
            mTotalPage = 1;
        }
        put("totalPage", mTotalPage);
        put("totalNum", mTotalNum);
        put("currentPage", requestPage + 1);

        if (machineId == 1) {
            machineId = 0;
        }
        put("machineId", machineId);
        put("innerIpAddress", innerIpAddress);
        put("publicIpAddress", publicIpAddress);
        put("machineAssignStatus", machineAssignStatus);
        setBaseQueryUrl(machineId, innerIpAddress, publicIpAddress, machineAssignStatus);
        render("sled_server_admin.html");
    }

    private void setBaseQueryUrl(int machineId, String innerIpAddress, String publicIpAddress, String machineAssignStatus) {
        StringBuffer baseQueryUrl = new StringBuffer();
        String baseUrl = this.baseUrl;
        int l = baseUrl.indexOf("requestPage");
        if (l > 0) {
            baseUrl = baseUrl.substring(0, l);
        }
        baseQueryUrl.append(baseUrl)
                .append("/SledServerAdmin/show?machineId=")
                .append(machineId)
                .append("&innerIpAddress=")
                .append(innerIpAddress)
                .append("&publicIpAddress=")
                .append(publicIpAddress)
                .append("&machineAssignStatus=")
                .append(machineAssignStatus)
                .append("&");

        put("baseQueryUrl", baseQueryUrl.toString());
    }

    private int queryHostingMachineList(int pageIndex, long machineId, String innerIpAddress, String publicIpAddress, String machineAssignStatus) throws ErrorInfo, TException {

        HostingMachineDaoStub hostingMachineDaoStub = new HostingMachineDaoStub();
        AliyunResourceAoServiceStub aliyunResourceAoServiceStub = new AliyunResourceAoServiceStub();

        QueryHostingMachineOption queryHostingMachineOption = new QueryHostingMachineOption();
        if (machineId > 0) {
            queryHostingMachineOption.setMachineId(machineId);
        }
        if (innerIpAddress != null && !innerIpAddress.isEmpty()) {
            queryHostingMachineOption.setMachineInnerIPPartical(innerIpAddress);
        }
        if (publicIpAddress != null && !publicIpAddress.isEmpty()) {
            queryHostingMachineOption.setMachineOuterIPPartical(publicIpAddress);
        }
        if (machineAssignStatus != null && !machineAssignStatus.isEmpty()) {
            queryHostingMachineOption.setMachineAssignStatus(HostingMachineAssignStatus.valueOf(machineAssignStatus));
        }

        IndexedPageOption indexedPageOption = new IndexedPageOption();
        indexedPageOption.setPageIndex(pageIndex);
        indexedPageOption.setPageSize(PAGE_SIZE);
        indexedPageOption.setNeedTotalCount(true);
        HostingMachinePageResult hostingMachinePageResult = hostingMachineDaoStub.queryHostingMachinePage(queryHostingMachineOption, indexedPageOption);

        AppLog.i("SledServerAdmin ---- queryHostingMachineList ---- hostingMachinePageResult : " + hostingMachinePageResult.getResultListSize());

        List<LocalHostingMachineInfo> LocalHostingMachineInfoList = new ArrayList<LocalHostingMachineInfo>();
//		List<String> instanceIdList = new ArrayList<String>();
//		Set<String> regionId = new HashSet<String>();

        for (HostingMachine hostingMachine : hostingMachinePageResult.resultList) {
            LocalHostingMachineInfo localHostingMachineInfo = new LocalHostingMachineInfo();
            localHostingMachineInfo.setMachineId(hostingMachine.getMachineId());
            localHostingMachineInfo.setMachineHostname(hostingMachine.getMachineHostname());
            localHostingMachineInfo.setMachineAssignStatus(hostingMachine.getMachineAssignStatus().name());
            localHostingMachineInfo.setInstanceId(hostingMachine.getInstanceId());
            localHostingMachineInfo.setRegionId(hostingMachine.getRegionId());

            HostingRelatedInfo hostingRelatedInfo = queryRelatedInfo(hostingMachineDaoStub, hostingMachine.getMachineId());
            if (hostingRelatedInfo != null) {
                localHostingMachineInfo.setRelatedId(hostingRelatedInfo.getRelatedId());
                localHostingMachineInfo.setCompanyId(hostingRelatedInfo.getCompanyId());
                localHostingMachineInfo.setCompanyGroupId(hostingRelatedInfo.getCompanyGroupId());

                // query company code
                CompanyEntry companyEntry = MXueqiaoUserCenter.getInstance().queryCompanyById(hostingRelatedInfo.getCompanyId());
                if (companyEntry != null) {
                    localHostingMachineInfo.setCompanyCode(companyEntry.getCompanyCode());
                }
                // query company group name
                CompanyGroup companyGroup = MXueqiaoUserCenter.getInstance().queryCompanyGroupById(hostingRelatedInfo.getCompanyId(), hostingRelatedInfo.getCompanyGroupId());
                if (companyGroup != null) {
                    localHostingMachineInfo.setGroupName(companyGroup.getGroupName());
                }
            }

            EcsInstance ecsInstance = queryEcsInstance(aliyunResourceAoServiceStub, hostingMachine.getInstanceId(), hostingMachine.getRegionId());
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
                localHostingMachineInfo.setAliyunExpiredTime(dateSimpleDateFormat.format(new Date(ecsInstance.getAliyunExpiredTimestamp() * 1000)));

                // 获取托管机状态
                HostingInfo hostingInfo = MXueqiaoHosting.getInstance().queryHostingInfo(ecsInstance.getInnerIpAddress());
                if (hostingInfo != null) {
                    localHostingMachineInfo.setHostingStatus(hostingInfo.getStatus());
                }
            }
            LocalHostingMachineInfoList.add(localHostingMachineInfo);
        }


        put("hostingMachineInfoList", LocalHostingMachineInfoList);

        mTotalNum = hostingMachinePageResult.getTotalNum();
        mTotalPage = (mTotalNum + PAGE_SIZE - 1) / PAGE_SIZE;
        AppLog.i("SledServerAdmin ---- queryHostingMachineList ---- mTotalPage : " + mTotalPage);
        return pageIndex > mTotalPage ? mTotalPage : pageIndex;
    }

    private HostingRelatedInfo queryRelatedInfo(HostingMachineDaoStub stub, long machineId) throws ErrorInfo, TException {

        QueryHostingRelatedInfoOption queryHostingRelatedInfoOption = new QueryHostingRelatedInfoOption();
        queryHostingRelatedInfoOption.setMachineId(machineId);
        IndexedPageOption indexedPageOption = new IndexedPageOption();
        indexedPageOption.setPageIndex(0);
        indexedPageOption.setPageSize(PAGE_SIZE_MAX);

        HostingRelatedInfoPageResult hostingRelatedInfoPageResult = stub.queryRelatedInfoPage(queryHostingRelatedInfoOption, indexedPageOption);

        AppLog.i("SledServerAdmin ---- queryRelatedInfo ---- pageSize : " + hostingRelatedInfoPageResult.getResultList().size() + ", machineId: " + machineId);

        if (hostingRelatedInfoPageResult.getResultList().size() > 0) {
            return hostingRelatedInfoPageResult.getResultList().get(0);
        }
        return null;
    }

    private EcsInstance queryEcsInstance(AliyunResourceAoServiceStub stub, String instanceId, String regionId) throws ErrorInfo, TException {

        ReqEcsInstanceOption reqEcsInstanceOption = new ReqEcsInstanceOption();
        Set<String> instanceIds = new HashSet<String>();
        instanceIds.add(instanceId);
        reqEcsInstanceOption.setInstanceIds(instanceIds);
        reqEcsInstanceOption.setRegionId(regionId);

        EcsInstancePage ecsInstancePage = stub.reqEcsInstance(reqEcsInstanceOption);

        AppLog.i("SledServerAdmin ---- queryEcsInstance ---- pageSize : " + ecsInstancePage.getPage().size() + ", instanceId: " + instanceId + ", regionId : " + regionId);

        if (ecsInstancePage.getPage().size() > 0) {
            return ecsInstancePage.getPage().get(0);
        } else {
            return null;
        }
    }

    public void syncEcsInstance() throws IOException {
        ErrorResult result = new ErrorResult();

        AppLog.i("SledServerAdmin ---- syncEcsInstance");

        AliyunResourceAoServiceStub aliyunResourceAoServiceStub = new AliyunResourceAoServiceStub();
        SynceEcsInstanceOption synceEcsInstanceOption = new SynceEcsInstanceOption();
        try {
            aliyunResourceAoServiceStub.syncEcsInstance(RandomUtils.nextInt(), 60000, synceEcsInstanceOption);
        } catch (ErrorInfo errorInfo) {
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

    public void getEcsInstanceInfo() throws IOException {
        ErrorResult result = new ErrorResult();

        AppLog.i("SledServerAdmin ---- getEcsInstanceInfo");

        AliyunResourceAoServiceStub aliyunResourceAoServiceStub = new AliyunResourceAoServiceStub();
        List<EcsInstance> ecsInstanceList = new ArrayList<EcsInstance>();
        EcsInstancePage ecsInstancePage = null;
        try {
            ReqEcsInstanceOption reqEcsInstanceOption = new ReqEcsInstanceOption();
            IndexedPageOption indexedPageOption = new IndexedPageOption();
            indexedPageOption.setPageSize(PAGE_SIZE_FOR_ECS_INSTANCE);
            int pageIndex = 0;

            while (true) {
                indexedPageOption.setPageIndex(pageIndex);
                reqEcsInstanceOption.setPageOption(indexedPageOption);
                ecsInstancePage = aliyunResourceAoServiceStub.reqEcsInstance(RandomUtils.nextInt(), 3000, reqEcsInstanceOption);
                pageIndex++;
                if (ecsInstancePage != null && ecsInstancePage.getPageSize() > 0) {
                    ecsInstanceList.addAll(ecsInstancePage.getPage());
                } else {
                    break;
                }
            }

        } catch (ErrorInfo errorInfo) {
            errorInfo.printStackTrace();
            result.setErrorCode(errorInfo.getErrorCode());
            result.setErrorMsg(errorInfo.getErrorMsg());
            AppLog.e("SledServerAdmin ---- getEcsInstanceInfo ---- reqEcsInstance ---- errorInfo", errorInfo);
            echoJson(result);
            return;
        } catch (Throwable e) {
            e.printStackTrace();
            result.setErrorCode(5);
            result.setErrorMsg("服务器繁忙(reqEcsInstance)");
            AppLog.e("SledServerAdmin ---- getEcsInstanceInfo ---- reqEcsInstance ---- Throwable", e);
            echoJson(result);
            return;
        }

        AppLog.i("SledServerAdmin ---- getEcsInstanceInfo ---- ecsInstanceList size : " + ecsInstanceList.size());
        if (ecsInstanceList.size() > 0) {
            HostingMachineDaoStub hostingMachineDaoStub = new HostingMachineDaoStub();

            QueryHostingMachineOption queryHostingMachineOption = new QueryHostingMachineOption();

            IndexedPageOption indexedPageOption = new IndexedPageOption();
            indexedPageOption.setPageIndex(0);
            indexedPageOption.setPageSize(PAGE_SIZE_MAX);

            HostingMachinePageResult hostingMachinePageResult = null;

            try {
                hostingMachinePageResult = hostingMachineDaoStub.queryHostingMachinePage(queryHostingMachineOption, indexedPageOption);
            } catch (ErrorInfo errorInfo) {
                errorInfo.printStackTrace();
                result.setErrorCode(errorInfo.getErrorCode());
                result.setErrorMsg(errorInfo.getErrorMsg());
                AppLog.e("SledServerAdmin ---- getEcsInstanceInfo ---- queryHostingMachinePage ---- errorInfo", errorInfo);
                echoJson(result);
                return;
            } catch (Throwable e) {
                e.printStackTrace();
                result.setErrorCode(5);
                result.setErrorMsg("服务器繁忙(queryHostingMachinePage)");
                AppLog.e("SledServerAdmin ---- getEcsInstanceInfo ---- queryHostingMachinePage ---- Throwable", e);
                echoJson(result);
                return;
            }

            AppLog.i("SledServerAdmin ---- getEcsInstanceInfo ---- hostingMachinePageResult : " + hostingMachinePageResult.getResultListSize());

            List<LocalEcsInstance> localEcsInstanceList = new ArrayList<LocalEcsInstance>();
            Set<String> instanceIdSet = new HashSet<String>();

            if (hostingMachinePageResult != null && hostingMachinePageResult.getResultListSize() > 0) {
                for (HostingMachine hostingMachine : hostingMachinePageResult.getResultList()) {
                    instanceIdSet.add(hostingMachine.getInstanceId());
                }
            }

            for (EcsInstance ecsInstance : ecsInstanceList) {
                if (!instanceIdSet.isEmpty() && instanceIdSet.contains(ecsInstance.getAliyunInstanceId())) {
                    continue;
                }
                LocalEcsInstance localEcsInstance = new LocalEcsInstance();

                localEcsInstance.setAliyunInstanceId(ecsInstance.getAliyunInstanceId());
                localEcsInstance.setRegionId(ecsInstance.getRegionId());
                localEcsInstance.setInstanceName(ecsInstance.getInstanceName());
                localEcsInstance.setAliyunExpiredTime(dateSimpleDateFormat.format(new Date(ecsInstance.getAliyunExpiredTimestamp() * 1000)));
                localEcsInstance.setZoneId(ecsInstance.getZoneId());
                localEcsInstance.setInstanceNetworkType(ecsInstance.getInstanceNetworkType().name());
                localEcsInstance.setInstanceChargeType(ecsInstance.getInstanceChargeType().name());

                StringBuilder tagsStringBuilder = new StringBuilder();
                for (String key : ecsInstance.getTags().keySet()) {
                    tagsStringBuilder.append("[").append(key).append(",").append(ecsInstance.getTags().get(key)).append("], ");
                }
                localEcsInstance.setTags(tagsStringBuilder.toString());

                if (ecsInstance.getInnerIpAddress() != null && !ecsInstance.getInnerIpAddress().isEmpty()) {
                    localEcsInstance.setInnerIpAddress(ecsInstance.getInnerIpAddress() + "(私有)");
                } else {
                    localEcsInstance.setInnerIpAddress("");
                }
                if (ecsInstance.getPublicIpAddress() != null && !ecsInstance.getPublicIpAddress().isEmpty()) {
                    localEcsInstance.setPublicIpAddress(ecsInstance.getPublicIpAddress() + "(公)");
                } else {
                    localEcsInstance.setPublicIpAddress("");
                }
                localEcsInstance.setRunningStatus(ecsInstance.getRunningStatus().name());

                AppLog.i("SledServerAdmin ---- getEcsInstanceInfo ---- m : " + ecsInstance.getMachineSpec().getMemoryGB() + ", cpu : " + ecsInstance.getMachineSpec().getCpuCount() + ", b : " + ecsInstance.getMachineSpec().getOutIfBandMB());

                localEcsInstance.setMachineSpec(ecsInstance.getMachineSpec().getCpuCount() + "核, 内存" + ecsInstance.getMachineSpec().getMemoryGB() + "GB, 带宽" + ecsInstance.getMachineSpec().getOutIfBandMB() + "MB");
                localEcsInstance.setMemoryGB(ecsInstance.getMachineSpec().getMemoryGB());
                localEcsInstance.setCpuCount(ecsInstance.getMachineSpec().getCpuCount());
                localEcsInstance.setOutIfBandMB(ecsInstance.getMachineSpec().getOutIfBandMB());

                localEcsInstanceList.add(localEcsInstance);
            }
            AppLog.i("SledServerAdmin ---- getEcsInstanceInfo ---- hostingMachinePageResult : " + hostingMachinePageResult.getResultListSize() + ", localEcsInstanceList size : " + localEcsInstanceList.size());
            echoJson(localEcsInstanceList);
            return;

        } else {
            result.setErrorCode(5);
            result.setErrorMsg("查询不到ECS实例");
            echoJson(result);
            return;
        }

    }

    private EcsInstance getEcsInstanceInfoById(String ecsInstanceId) throws ErrorInfo, TException {
        AliyunResourceAoServiceStub aliyunResourceAoServiceStub = new AliyunResourceAoServiceStub();
        EcsInstancePage ecsInstancePage = null;
        ReqEcsInstanceOption reqEcsInstanceOption = new ReqEcsInstanceOption();
        Set<String> instanceIds = new HashSet<String>();
        instanceIds.add(ecsInstanceId);
        reqEcsInstanceOption.setInstanceIds(instanceIds);

        IndexedPageOption indexedPageOption = new IndexedPageOption();
        indexedPageOption.setPageIndex(0);
        indexedPageOption.setPageSize(1);
        reqEcsInstanceOption.setPageOption(indexedPageOption);
        ecsInstancePage = aliyunResourceAoServiceStub.reqEcsInstance(reqEcsInstanceOption);

        if (ecsInstancePage.getPageSize() > 0) {
            return ecsInstancePage.getPage().get(0);
        }
        return null;
    }

    public void addEcsInstanceInfo() throws IOException {
        ErrorResult result = new ErrorResult();

        HostingMachineDaoStub hostingMachineDaoStub = new HostingMachineDaoStub();

        try {

            String content = StringFactory.newUtf8String(IOUtils.toByteArray(getServletRequest().getInputStream()));

            AppLog.i("SledServerAdmin ---- addEcsInstanceInfo ---- content : " + content);

            EcsInstanceInfo ecsInstanceInfo = GsonFactory.getGson().fromJson(content, EcsInstanceInfo.class);

            AppLog.i("SledServerAdmin ---- addEcsInstanceInfo ---- ecsInstanceInfo is not null : " + (ecsInstanceInfo != null));

            if (ecsInstanceInfo == null || ecsInstanceInfo.getEcsInstanceIdList().isEmpty()) {
                result.setErrorCode(7);
                result.setErrorMsg("没有选译ECS实例");
                echoJson(result);
                return;
            }

            HostingMachine hostingMachine = new HostingMachine();
            for (String ecsInstanceId : ecsInstanceInfo.getEcsInstanceIdList()) {
                EcsInstance ecsInstance = getEcsInstanceInfoById(ecsInstanceId);
                if (ecsInstance != null) {
                    hostingMachine.setMachineInnerIP(ecsInstance.getInnerIpAddress());
                    hostingMachine.setMachineOuterIP(ecsInstance.getPublicIpAddress());
                    hostingMachine.setMachineHostname(ecsInstance.getInstanceName());
                    hostingMachine.setMachineSpec(ecsInstance.getMachineSpec());
                    hostingMachine.setMachineRunningStatus(ecsInstance.getRunningStatus());
                    hostingMachine.setRegionId(ecsInstance.getRegionId());
                    hostingMachine.setInstanceId(ecsInstanceId);
                    hostingMachineDaoStub.addHostingMachine(hostingMachine);
                }
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
            result.setErrorMsg("服务器繁忙");
            echoJson(result);
            return;
        }
        echoJson(result);
    }

    public void deleteHostingMachine() throws IOException {
        ErrorResult result = new ErrorResult();

        HostingMachineDaoStub hostingMachineDaoStub = new HostingMachineDaoStub();

        int machineId = parameter("machineId", 0);
        AppLog.i("SledServerAdmin ---- deleteHostingMachine ---- machineId : " + machineId);

        if (machineId <= 0) {
            result.setErrorCode(2);
            result.setErrorMsg("获取不到服务器ID，删除失败");
            echoJson(result);
            return;
        }

        try {
            hostingMachineDaoStub.deleteHostingMachine(machineId);
        } catch (ErrorInfo errorInfo) {
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

    private class EcsInstanceInfo {
        List<String> ecsInstanceIdList;

        public List<String> getEcsInstanceIdList() {
            return ecsInstanceIdList;
        }

        public void setEcsInstanceIdList(List<String> ecsInstanceIdList) {
            this.ecsInstanceIdList = ecsInstanceIdList;
        }
    }
}
