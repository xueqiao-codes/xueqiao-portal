package xueqiao.mailbox.sending.daemon.core.controller;

import org.soldier.base.logger.AppLog;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import xueqiao.mailbox.sending.daemon.api.MailboxDaoApi;
import xueqiao.mailbox.sending.daemon.core.bean.BaseMessage;
import xueqiao.mailbox.thriftdata.mb.*;
import xueqiao.mailbox.thriftdata.req.QueryMBMessageJobOption;

import java.util.Iterator;
import java.util.List;

/**
 * 废弃
 * 重复发送的逻辑已合并到SendindMessageService中
 */
public class NetworkErrorRetrySendingController extends AbstractSendingController {

    private List<MBMessageJob> messageJobList;

    @Override
    protected boolean sendingOneRound() {
//        getMessageList();
//        if (messageJobList == null) {
//            return true;
//        }
//        Iterator<MBMessageJob> iterator = messageJobList.iterator();
//        MBMessageJob message;
//        long jobId = 0;
//        while (iterator.hasNext()) {
//            message = iterator.next();
//            try {
//                // 开始发送
//                jobId = message.getJobId();
//
//                // 按渠道发送
//                sendOneMessage(jobId, BaseMessage.getFromMBMessageJob(message));
//
//                /*
//                 * 设置发送成功标志
//                 * 重试发送成功的，不消除原来的错误描述
//                 * */
//                MailboxDaoApi.modifyMBMessageJobStatus(jobId, MJStatus.MJS_COMPLETED, null);
//            } catch (ErrorInfo errorInfo) {
//                AppLog.e("send message fail ---- errorInfo", errorInfo);
//                StringBuilder builder = new StringBuilder();
//                builder.append("(")
//                        .append(errorInfo.getErrorCode())
//                        .append(")")
//                        .append(errorInfo.getErrorMsg());
//                MailboxDaoApi.modifyMBMessageJobStatus(jobId, MJStatus.MJS_EXCEPTION_STOP, builder.toString());
//            } catch (Throwable throwable) {
//                AppLog.e("send message fail ---- throwable", throwable);
//                StringBuilder builder = new StringBuilder();
//                builder.append("(throwable)")
//                        .append(throwable.getMessage());
//                MailboxDaoApi.modifyMBMessageJobStatus(jobId, MJStatus.MJS_NETWORK_ERROR_RETRY, builder.toString());
//            } finally {
//                /*
//                 * 异常或完成，都从缓存表中删除
//                 * 如果是异常，下个循环还会重复
//                 * */
//                iterator.remove();
//            }
//        }
        return false;
    }

    private void getMessageList() {
        QueryMBMessageJobOption option = new QueryMBMessageJobOption();
        option.addToStatusSet(MJStatus.MJS_NETWORK_ERROR_RETRY);
        messageJobList = MailboxDaoApi.queryMBMessageJobList(option);
    }
}
