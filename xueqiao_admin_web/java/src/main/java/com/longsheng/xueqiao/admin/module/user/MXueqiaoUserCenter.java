package com.longsheng.xueqiao.admin.module.user;

import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.page.IndexedPageOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

import xueqiao.company.*;
import xueqiao.company.dao.client.CompanyDaoStub;

public class MXueqiaoUserCenter {

    public static final int PAGE_SIZE = 10;
    private static final int PAGE_SIZE_MAX = Integer.MAX_VALUE;
    private CompanyDaoStub mCompanyDaoStub;

    private static MXueqiaoUserCenter mInstance;

    public static MXueqiaoUserCenter getInstance() {
        if (mInstance == null) {
            mInstance = new MXueqiaoUserCenter();
        }
        return mInstance;
    }

    public MXueqiaoUserCenter() {
        mCompanyDaoStub = new CompanyDaoStub();
    }

    public CompanyPageResult queryCompanyList(int pageIndex) throws ErrorInfo, TException {
        QueryCompanyOption queryOption = new QueryCompanyOption();
        IndexedPageOption pageOption = new IndexedPageOption();
        pageOption.setNeedTotalCount(true);
        pageOption.setPageIndex(pageIndex);
        pageOption.setPageSize(PAGE_SIZE);
        return mCompanyDaoStub.queryCompanyPage(queryOption, pageOption);
    }

    public CompanyPageResult queryCompanyList(int pageIndex, int companyId, String companyName, String email, String telephone) throws ErrorInfo, TException {
        QueryCompanyOption queryOption = new QueryCompanyOption();
        if (companyId > 0) {
            queryOption.setCompanyId(companyId);
        }
        if (companyName != null && !companyName.isEmpty()) {
            AppLog.i("MXueqiaoUserCenter ---- queryCompanyList ---- companyName : " + companyName);
            queryOption.setCompanyNamePartical(companyName);
        }
        if (email != null && !email.isEmpty()) {
            queryOption.setEmailPartical(email);
        }
        if (telephone != null && !telephone.isEmpty()) {
            queryOption.setPhonePartical(telephone);
        }

        IndexedPageOption pageOption = new IndexedPageOption();
        pageOption.setNeedTotalCount(true);
        pageOption.setPageIndex(pageIndex);
        pageOption.setPageSize(PAGE_SIZE);
        return mCompanyDaoStub.queryCompanyPage(queryOption, pageOption);
    }

    public CompanyEntry queryCompanyById(int companyId) throws ErrorInfo, TException {
        QueryCompanyOption queryOption = new QueryCompanyOption();
        queryOption.setCompanyId(companyId);

        IndexedPageOption pageOption = new IndexedPageOption();
        pageOption.setPageIndex(0);
        pageOption.setPageSize(PAGE_SIZE);
        CompanyPageResult companyPageResult = mCompanyDaoStub.queryCompanyPage(queryOption, pageOption);

        AppLog.i("MXueqiaoUserCenter ---- queryCompanyById ---- companyId : " + companyId + ", companyPageResult size : " + companyPageResult.getResultListSize());

        if (companyPageResult != null && companyPageResult.getResultListSize() > 0) {
            return companyPageResult.getResultList().get(0);
        }
        return null;
    }

    public int addCompany(CompanyEntry newCompany) throws ErrorInfo, TException {
        CompanyEntry companyEntry = new CompanyEntry();
        companyEntry.setCompanyCode(newCompany.getCompanyCode());
        companyEntry.setCompanyName(newCompany.getCompanyName());
        companyEntry.setFund(newCompany.getFund());
        companyEntry.setChannel(newCompany.getChannel());
        companyEntry.setAddress(newCompany.getAddress());
        companyEntry.setEmail(newCompany.getEmail());
        companyEntry.setTelephone(newCompany.getTelephone());
        companyEntry.setPassword(newCompany.getPassword());

        return mCompanyDaoStub.addCompany(companyEntry);
    }

    public CompanyUserPage queryCompanyUserList(int pageIndex) throws ErrorInfo, TException {
        QueryCompanyUserOption option = new QueryCompanyUserOption();
        IndexedPageOption pageOption = new IndexedPageOption();
        pageOption.setNeedTotalCount(true);
        pageOption.setPageIndex(pageIndex);
        pageOption.setPageSize(PAGE_SIZE);
        return mCompanyDaoStub.queryCompanyUser(option, pageOption);
    }

    public CompanyUser queryCompanyUserById(int userId) throws ErrorInfo, TException {
        QueryCompanyUserOption option = new QueryCompanyUserOption();
        option.addToUserId(userId);
        IndexedPageOption pageOption = new IndexedPageOption();
        pageOption.setPageIndex(0);
        pageOption.setPageSize(1);
        CompanyUserPage companyUserPage = mCompanyDaoStub.queryCompanyUser(option, pageOption);
        if (companyUserPage != null && companyUserPage.getPageSize() > 0) {
            return companyUserPage.getPage().get(0);
        }
        return null;
    }

    public int addCompanyUser(CompanyUser newCompanyUser) throws ErrorInfo, TException {
        CompanyUser companyUser = new CompanyUser();
        companyUser.setCompanyId(newCompanyUser.getCompanyId());
        companyUser.setUserName(newCompanyUser.getUserName());
        companyUser.setPassword(newCompanyUser.getPassword());
        companyUser.setTel(newCompanyUser.getTel());
        companyUser.setCnName(newCompanyUser.getCnName());

        return mCompanyDaoStub.addCompanyUser(companyUser);
    }

    public GroupUserPage queryGroupUserList(int pageIndex, int companyId, int groupId) throws ErrorInfo, TException {
        QueryGroupUserOption option = new QueryGroupUserOption();
        option.setCompanyId(companyId);
        option.setGroupId(groupId);
        IndexedPageOption pageOption = new IndexedPageOption();
        pageOption.setNeedTotalCount(true);
        pageOption.setPageIndex(pageIndex);
        pageOption.setPageSize(PAGE_SIZE);

        return mCompanyDaoStub.queryGroupUser(option, pageOption);
    }

    public GroupUserPage queryGroupUserList(int companyId, int groupId) throws ErrorInfo, TException {
        QueryGroupUserOption option = new QueryGroupUserOption();
        option.setCompanyId(companyId);
        option.setGroupId(groupId);
        IndexedPageOption pageOption = new IndexedPageOption();
        pageOption.setPageIndex(0);
        pageOption.setPageSize(PAGE_SIZE_MAX);

        return mCompanyDaoStub.queryGroupUser(option, pageOption);
    }

    public CompanyUserPage queryCompanyUserListByCompanyId(int companyId) throws ErrorInfo, TException {
        QueryCompanyUserOption option = new QueryCompanyUserOption();
        option.setCompanyId(companyId);

        IndexedPageOption pageOption = new IndexedPageOption();
        pageOption.setPageIndex(0);
        pageOption.setPageSize(PAGE_SIZE_MAX);
        return mCompanyDaoStub.queryCompanyUser(option, pageOption);
    }

    public CompanyGroupPageResult queryCompanyGroupList(int companyId) throws ErrorInfo, TException {
        QueryCompanyGroupOption queryOption = new QueryCompanyGroupOption();
        queryOption.setCompanyId(companyId);
        IndexedPageOption pageOption = new IndexedPageOption();
        pageOption.setPageIndex(0);
        pageOption.setPageSize(PAGE_SIZE_MAX);
        return mCompanyDaoStub.queryCompanyGroupPage(queryOption, pageOption);
    }

    public CompanyGroup queryCompanyGroupById(int companyId, int groupId) throws ErrorInfo, TException {
        QueryCompanyGroupOption queryOption = new QueryCompanyGroupOption();
        queryOption.setCompanyId(companyId);
        queryOption.setGroupId(groupId);

        IndexedPageOption pageOption = new IndexedPageOption();
        pageOption.setPageIndex(0);
        pageOption.setPageSize(PAGE_SIZE_MAX);
        CompanyGroupPageResult companyGroupPageResult = mCompanyDaoStub.queryCompanyGroupPage(queryOption, pageOption);

        AppLog.i("MXueqiaoUserCenter ---- queryCompanyGroupById ---- companyId : " + companyId + ", groupId : " + groupId + ", companyGroupPageResult size : " + companyGroupPageResult.getResultListSize());

        if (companyGroupPageResult != null && companyGroupPageResult.getResultListSize() > 0) {
            return companyGroupPageResult.getResultList().get(0);
        } else {
            return null;
        }
    }

    public void addCompanyGroup(CompanyGroup companyGroup) throws ErrorInfo, TException {
        CompanyGroup newCompanyGroup = new CompanyGroup();
        newCompanyGroup.setCompanyId(companyGroup.getCompanyId());
        newCompanyGroup.setGroupCode(companyGroup.getGroupCode());
        newCompanyGroup.setGroupName(companyGroup.getGroupName());
        mCompanyDaoStub.addCompanyGroup(newCompanyGroup);
    }

    public void deleteCompanyGroup(int companyId, int groupId) throws ErrorInfo, TException {
        mCompanyDaoStub.deleteCompanyGroup(companyId, groupId);
    }

    public void addCompanyGroupUser(GroupUser groupUser) throws ErrorInfo, TException {
        GroupUser newGroupUser = new GroupUser();
        newGroupUser.setUserId(groupUser.getUserId());
        newGroupUser.setCompanyId(groupUser.getCompanyId());
        newGroupUser.setGroupId(groupUser.getGroupId());
        newGroupUser.setRole(groupUser.getRole());

        mCompanyDaoStub.addUser2Group(newGroupUser);
    }

    public void deleteCompanyGroupUser(int companyId, int groupId, int userId) throws ErrorInfo, TException {
        GroupUser deleteGroupUser = new GroupUser();
        deleteGroupUser.setUserId(userId);
        deleteGroupUser.setCompanyId(companyId);
        deleteGroupUser.setGroupId(groupId);

        mCompanyDaoStub.removeGroupUser(deleteGroupUser);
    }

    public CompanyGroupSpec queryCompanyGroupSpec(int companyId, int companyGroupId) throws ErrorInfo, TException {
        QueryCompanyGroupSpecOption option = new QueryCompanyGroupSpecOption();
        option.setCompanyId(companyId);
        option.setCompanyGroupId(companyGroupId);

        IndexedPageOption pageOption = new IndexedPageOption();
        pageOption.setPageIndex(0);
        pageOption.setPageSize(1);
        CompanyGroupSpecPage companyGroupSpecPage = mCompanyDaoStub.queryCompanyGroupSpec(option, pageOption);
        AppLog.i("MXueqiaoUserCenter ---- queryCompanyGroupSpec ---- companyId : " + companyId + ", companyGroupId : " + companyGroupId + ", companyGroupSpecPage : " + companyGroupSpecPage.toString());
        if (companyGroupSpecPage != null && companyGroupSpecPage.getPageSize() > 0) {
            return companyGroupSpecPage.getPage().get(0);
        }
        return null;
    }

    public CompanyGroupSpecPage queryCompanyGroupSpec(int companyId) throws ErrorInfo, TException {
        QueryCompanyGroupSpecOption option = new QueryCompanyGroupSpecOption();
        option.setCompanyId(companyId);

        IndexedPageOption pageOption = new IndexedPageOption();
        pageOption.setPageIndex(0);
        pageOption.setPageSize(PAGE_SIZE_MAX);
        return mCompanyDaoStub.queryCompanyGroupSpec(option, pageOption);
    }

    public void updateCompanyGroupSpec(CompanyGroupSpec updateGroupSpec) throws TException {
        mCompanyDaoStub.updateCompanyGroupSpec(updateGroupSpec);
    }

    public void submitInitHostingMachineTask(InitHostingMachineReq initHostingMachineReq) throws TException {
        mCompanyDaoStub.submitInitHosingTask(initHostingMachineReq);
    }

    public void doUpgradeGroupSpec(int orderId, String oaUserName) throws TException {
        mCompanyDaoStub.doUpgradeGroupSpec(orderId, oaUserName);
    }
}
