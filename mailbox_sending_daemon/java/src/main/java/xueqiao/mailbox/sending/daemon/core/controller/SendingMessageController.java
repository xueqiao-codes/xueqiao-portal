package xueqiao.mailbox.sending.daemon.core.controller;

import com.google.gson.Gson;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import xueqiao.mailbox.sending.daemon.api.MailboxDaoApi;
import xueqiao.mailbox.sending.daemon.core.bean.SendingMessage;
import xueqiao.mailbox.sending.daemon.util.SendingMessageUtil;
import xueqiao.mailbox.thriftdata.mb.*;
import xueqiao.mailbox.thriftdata.req.QueryMBMessageJobOption;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SendingMessageController extends AbstractSendingController {

    private List<MBMessageJob> messageJobList;
    /*
     * 没有对该map做限制，因此有占用内存过大的风险
     * 但从业务上看，异常重试有时间有效期，为1个小时; 保留期为2个小时间
     * 并且该发送消息为低频操作
     * 因此，导致该map出现问题的概率不大，并且kubernetes有进程死掉重启进程的保护
     * 因而认为此处做法是安全的。
     * */
    private Map<Long, SendingMessage> sendingMessageMap = new HashMap<>();


    @Override
    protected boolean sendingOneRound() {
        getMessageList();
        if (messageJobList == null) {
            return true;
        }
        Iterator<MBMessageJob> iterator = messageJobList.iterator();
        MBMessageJob message;
        long jobId = 0;
        while (iterator.hasNext()) {
            message = iterator.next();
            try {
                jobId = message.getJobId();

                SendingMessage sendingMessage = SendingMessageUtil.getMessage(message, sendingMessageMap);
                AppLog.i("sendingOneRound ---- sendingMessage : " + new Gson().toJson(sendingMessage));
                if (sendingMessage == null) {
                    MailboxDaoApi.modifyMBMessageJobStatus(jobId, MJStatus.MJS_NETWORK_ERROR_STOP, "retry time out");
                    continue;
                }

                // 按渠道发送
                sendOneMessage(sendingMessage);

                SendingMessageUtil.completeMessage(sendingMessageMap);

                // 设置发送成功标志
                MailboxDaoApi.modifyMBMessageJobStatus(jobId, MJStatus.MJS_COMPLETED, null);
            } catch (ErrorInfo errorInfo) {
                AppLog.e("send message fail ---- errorInfo", errorInfo);
                StringBuilder builder = new StringBuilder();
                builder.append("(")
                        .append(errorInfo.getErrorCode())
                        .append(")")
                        .append(errorInfo.getErrorMsg());
                MailboxDaoApi.modifyMBMessageJobStatus(jobId, MJStatus.MJS_EXCEPTION_STOP, builder.toString());
            } catch (Throwable throwable) {
                AppLog.e("send message fail ---- throwable", throwable);
                StringBuilder builder = new StringBuilder();
                builder.append("(throwable)")
                        .append(throwable.getMessage());
                MailboxDaoApi.modifyMBMessageJobStatus(jobId, MJStatus.MJS_NETWORK_ERROR_RETRY, builder.toString());
            } finally {
                /*
                 * 异常或完成，都从缓存表中删除
                 * 如果是异常，下个循环还会重复
                 * */
                iterator.remove();
            }
        }
        return false;
    }

    private void getMessageList() {
        QueryMBMessageJobOption option = new QueryMBMessageJobOption();
        option.addToStatusSet(MJStatus.MJS_SENDING);
        option.addToStatusSet(MJStatus.MJS_NETWORK_ERROR_RETRY);
        messageJobList = MailboxDaoApi.queryMBMessageJobList(option);
    }
}
