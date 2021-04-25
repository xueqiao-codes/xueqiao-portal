package xueqiao.mailbox.sending.daemon.core.controller;

import com.antiy.error_code.ErrorCodeInner;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import xueqiao.mailbox.sending.daemon.api.MailboxDaoApi;
import xueqiao.mailbox.sending.daemon.core.policy.ISendingPolicy;
import xueqiao.mailbox.sending.daemon.core.policy.SendingFixedTime;
import xueqiao.mailbox.sending.daemon.core.policy.SendingNow;
import xueqiao.mailbox.sending.daemon.core.policy.SendingRepeat;
import xueqiao.mailbox.thriftdata.mb.MBMessage;
import xueqiao.mailbox.thriftdata.mb.MSendingPolicy;
import xueqiao.mailbox.thriftdata.mb.MStatus;
import xueqiao.mailbox.thriftdata.req.QueryMBMessageOption;

import java.util.Iterator;
import java.util.List;

public class AddToMessageJobController extends AbstractSendingController {

    private ISendingPolicy sendingPolicy;
    private List<MBMessage> toSendMessageList;

    @Override
    protected boolean sendingOneRound() {
        getMessageList();
        if (toSendMessageList == null) {
            return true;
        }
        Iterator<MBMessage> iterator = toSendMessageList.iterator();
        MBMessage message;
        while (iterator.hasNext()) {
            message = iterator.next();
            try {
                sendingPolicy = getSendingPolicy(message);
                if (!sendingPolicy.sendNow()) {
                    continue;
                }
                /*
                 * 将消息实例写入job队列
                 * */
                MailboxDaoApi.startSendMBMessage(message.getMbmId(), sendingPolicy.isMessageCompleted());
            } catch (ErrorInfo errorInfo) {
                AppLog.e("add to message job fail ---- errorInfo", errorInfo);
            } catch (Throwable throwable) {
                AppLog.e("add to message job fail ---- throwable", throwable);
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

    private ISendingPolicy getSendingPolicy(MBMessage message) throws ErrorInfo {
        ISendingPolicy policy;
        if (message.getPolicy() == MSendingPolicy.MSP_NOW) {
            policy = new SendingNow();
        } else if (message.getPolicy() == MSendingPolicy.MSP_FIXED_TIME) {
            policy = new SendingFixedTime();
        } else if (message.getPolicy() == MSendingPolicy.MSP_REPEAT) {
            policy = new SendingRepeat();
        } else {
            throw new ErrorInfo(ErrorCodeInner.ILLEGAL_OPERATION_ERROR.getErrorCode(), "illegal policy");
        }
        return policy;
    }

    private void getMessageList() {
        QueryMBMessageOption option = new QueryMBMessageOption();
        option.addToStatusList(MStatus.MS_VALID);
        toSendMessageList = MailboxDaoApi.queryMBMessageList(option);
    }
}
