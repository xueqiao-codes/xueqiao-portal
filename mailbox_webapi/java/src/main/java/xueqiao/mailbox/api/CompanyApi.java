package xueqiao.mailbox.api;

import org.apache.commons.collections.map.AbstractReferenceMap;
import org.apache.thrift.TException;
import org.soldier.platform.page.IndexedPageOption;
import xueqiao.company.*;
import xueqiao.company.dao.client.CompanyDaoStub;
import xueqiao.mailbox.webapi.thriftapi.CompanyReceiver;
import xueqiao.mailbox.webapi.thriftapi.GroupReceiver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompanyApi {


    public List<CompanyReceiver> reqCompanyReceiver() throws TException {
        CompanyDaoStub stub = new CompanyDaoStub();
        QueryCompanyOption option = new QueryCompanyOption();
        int pageIndex = 0;
        int pageSize = 20;
        int total = 0;
        List<CompanyReceiver> receivers = new ArrayList<>();
        do {
            IndexedPageOption pageOption = new IndexedPageOption();
            pageOption.setNeedTotalCount(true);
            pageOption.setPageIndex(pageIndex);
            pageOption.setPageSize(pageSize);
            CompanyPageResult page = stub.queryCompanyPage(option, pageOption);
            total = page.getTotalCount();
            for (CompanyEntry entry : page.getResultList()) {
                CompanyReceiver receiver = new CompanyReceiver();
                receiver.setCompanyCode(entry.getCompanyCode());
                receiver.setCompanyId(entry.getCompanyId());
                receiver.setCompanyName(entry.getCompanyName());
                receivers.add(receiver);
            }

            pageIndex++;
        } while (total > pageIndex * pageSize);

        return receivers;
    }


    public List<GroupReceiver> reqGroupReceiver(long companyId) throws TException {
        CompanyDaoStub stub = new CompanyDaoStub();
        QueryCompanyGroupOption option = new QueryCompanyGroupOption();
        option.setCompanyId((int) companyId);
        int pageIndex = 0;
        int pageSize = 20;
        int total = 0;
        Map<Integer, CompanyGroup> companyGroups = new HashMap<>();
        do {
            IndexedPageOption pageOption = new IndexedPageOption();
            pageOption.setPageSize(pageSize);
            pageOption.setPageIndex(pageIndex);
            pageOption.setNeedTotalCount(true);
            CompanyGroupPageResult eachPage = stub.queryCompanyGroupPage(option, pageOption);
            for (CompanyGroup group : eachPage.getResultList()) {
                companyGroups.put(group.getGroupId(), group);
            }
            pageIndex++;
        } while (total > pageIndex * pageSize);


        QueryCompanyGroupSpecOption specOption = new QueryCompanyGroupSpecOption();
        specOption.setCompanyId((int) companyId);
        CompanyGroupSpecPage groupSpecPage = stub.queryCompanyGroupSpec(specOption, new IndexedPageOption().setPageIndex(0).setPageSize(Integer.MAX_VALUE));

        List<GroupReceiver> receivers = new ArrayList<>();
        for (CompanyGroupSpec groupSpec : groupSpecPage.getPage()) {
            if (HostingServiceStatus.WORKING.equals(groupSpec.getHostingServiceStatus())
                    || HostingServiceStatus.UPGRADING.equals(groupSpec.getHostingServiceStatus())
                    || HostingServiceStatus.EXPIRED.equals(groupSpec.getHostingServiceStatus())) {
                GroupReceiver receiver = new GroupReceiver();
                CompanyGroup group = companyGroups.get(groupSpec.getGroupId());
                receiver.setCompanyId(companyId);
                receiver.setGroupCode(group.getGroupCode());
                receiver.setGroupId(group.getGroupId());
                receiver.setGroupName(group.getGroupName());
                receivers.add(receiver);
            }
        }

        return receivers;
    }

}
