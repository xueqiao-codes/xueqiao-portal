package xueqiao.mailbox.sending.daemon.api;

import com.google.gson.Gson;
import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.page.IndexedPageOption;
import xueqiao.company.GroupUserEx;
import xueqiao.company.GroupUserExPage;
import xueqiao.company.QueryGroupUserExOption;
import xueqiao.company.dao.client.CompanyDaoStub;
import xueqiao.mailbox.sending.daemon.util.CollectionUtil;
import xueqiao.mailbox.sending.daemon.util.UserRoleMapping;
import xueqiao.mailbox.thriftdata.mb.HostingUserRole;
import xueqiao.mailbox.thriftdata.mb.MReceiverHosting;

import java.util.ArrayList;
import java.util.List;

public class CompanyDaoApi {

    private static CompanyDaoStub companyDaoStub = new CompanyDaoStub();

    public static List<GroupUserEx> queryAllGroupUserList(QueryGroupUserExOption option) throws TException {
        List<GroupUserEx> groupUserList = new ArrayList<>();
        IndexedPageOption pageOption = new IndexedPageOption();
        pageOption.setPageSize(50);
        int pageIndex = 0;
        GroupUserExPage page = null;
        do {
            pageOption.setPageIndex(pageIndex);
            page = companyDaoStub.queryGroupUserEx(option, pageOption);
            pageIndex++;
            if (page == null || page.getPageSize() < 1) {
                break;
            }
            for (GroupUserEx groupUserEx : page.getPage()) {
                groupUserList.add(groupUserEx);
            }
        } while (page != null && page.getPageSize() > 0);
        return groupUserList;
    }

    public static List<GroupUserEx> queryAllGroupUserList(List<MReceiverHosting> hostingList) throws TException {
//        AppLog.i("queryAllGroupUserList ---- message : " + new Gson().toJson(hostingList));
        if (CollectionUtil.isListBlank(hostingList)) {
            return null;
        }
        if (CollectionUtil.isListBlank(hostingList.get(0).getRoleList())) {
            return null;
        }
        QueryGroupUserExOption option = new QueryGroupUserExOption();
        for (MReceiverHosting receiverHosting : hostingList) {
            if (receiverHosting.isSetCompanyId() && receiverHosting.getCompanyId() > 0) {
                option.addToCompanyIds((int) receiverHosting.getCompanyId());
            }
            if (receiverHosting.isSetGroupId() && receiverHosting.getGroupId() > 0) {
                option.addToGroupIds((int) receiverHosting.getGroupId());
            }
        }
        for (HostingUserRole userRole : hostingList.get(0).getRoleList()) {
            option.addToRoles(UserRoleMapping.getGroupUserOperatorRole(userRole));
        }
        AppLog.i("queryAllGroupUserList ---- option : " + new Gson().toJson(option));
        return CompanyDaoApi.queryAllGroupUserList(option);
    }
}
