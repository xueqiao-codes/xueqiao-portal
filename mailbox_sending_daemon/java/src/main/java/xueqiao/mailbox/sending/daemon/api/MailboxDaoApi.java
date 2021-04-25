package xueqiao.mailbox.sending.daemon.api;

import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;
import xueqiao.mailbox.dao.thriftapi.client.MailboxDaoStub;
import xueqiao.mailbox.thriftdata.mb.MBMessage;
import xueqiao.mailbox.thriftdata.mb.MBMessageJob;
import xueqiao.mailbox.thriftdata.mb.MJStatus;
import xueqiao.mailbox.thriftdata.mb.MStatus;
import xueqiao.mailbox.thriftdata.req.MBMessageJobPage;
import xueqiao.mailbox.thriftdata.req.MBMessagePage;
import xueqiao.mailbox.thriftdata.req.QueryMBMessageJobOption;
import xueqiao.mailbox.thriftdata.req.QueryMBMessageOption;

import java.util.List;

public class MailboxDaoApi {

    private static MailboxDaoStub mailboxDaoStub = new MailboxDaoStub();

    public static List<MBMessage> queryMBMessageList(QueryMBMessageOption option) {
        MBMessagePage page = null;
        try {
            page = mailboxDaoStub.queryMBMessagePage(option, null);
        } catch (TException e) {
            AppLog.e("queryMBMessageList fail", e);
        }
        if (page != null && page.getMessageListSize() > 0) {
            return page.getMessageList();
        }
        return null;
    }

    public static List<MBMessageJob> queryMBMessageJobList(QueryMBMessageJobOption option) {
        MBMessageJobPage page = null;
        try {
            page = mailboxDaoStub.queryMBMessageJobPage(option, null);
        } catch (TException e) {
            AppLog.e("queryMBMessageJobList fail", e);
        }
        if (page != null && page.getMessageJobListSize() > 0) {
            return page.getMessageJobList();
        }
        return null;
    }

    public static void modifyMBMessageStatus(long mbmId, MStatus status) throws TException {
        mailboxDaoStub.modifyMBMessageStatus(mbmId, status);
    }

    public static long startSendMBMessage(long mbmId, boolean isMessageCompleted) throws TException {
        return mailboxDaoStub.startSendMBMessage(mbmId, isMessageCompleted);
    }

    public static void modifyMBMessageJobStatus(long jobId, MJStatus status, String errorDescription) {
        try {
            mailboxDaoStub.modifyMBMessageJobStatus(jobId, status, errorDescription);
        } catch (TException e) {
            AppLog.e("modifyMBMessageJobStatus fail, jobId : " + jobId + ", status : " + status, e);
        }
    }
}
