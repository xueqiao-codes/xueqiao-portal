package xueqiao.mailbox.api;

import org.apache.thrift.TException;
import org.soldier.platform.page.IndexedPageOption;
import xueqiao.mailbox.dao.thriftapi.client.MailboxDaoStub;
import xueqiao.mailbox.thriftdata.mb.MJStatus;
import xueqiao.mailbox.thriftdata.req.MBMessageJobPage;
import xueqiao.mailbox.thriftdata.req.QueryMBMessageJobOption;
import xueqiao.mailbox.webapi.thriftapi.OperateResult;

public class MessageJobApi {

    public MBMessageJobPage reqMBMessageJob(QueryMBMessageJobOption option, IndexedPageOption pageOption) throws TException {
        return new MailboxDaoStub().queryMBMessageJobPage(option, pageOption);
    }

    public OperateResult updateMBMessageJobStatus(long jobId, MJStatus status) throws TException {
        new MailboxDaoStub().modifyMBMessageJobStatus(jobId, status, null);
        return new OperateResult().setSuccess(true);
    }
}
