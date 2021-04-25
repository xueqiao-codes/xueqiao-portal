package xueqiao.mailbox.sending.daemon.app;

import org.soldier.base.logger.AppLog;
import xueqiao.mailbox.sending.daemon.service.AddToMessageJobService;
import xueqiao.mailbox.sending.daemon.service.NetworkErrorRetrySendingService;
import xueqiao.mailbox.sending.daemon.service.SendingService;

/**
 * daemon 入口
 */
public class DaemonEntry {
    public static void main(String[] args) {

        /*
         * 添加消息实例到job队列服务
         * 服务从job队列中发送
         * */
        new AddToMessageJobService().start();

        /*
         * 信箱消息发送服务
         * */
        new SendingService().start();

        /*
         * 信箱消息因网络失败重发送服务
         * 目前错误重发的，也在SendingService服务中处理
         * */
//        new NetworkErrorRetrySendingService().start();

        AppLog.i("MailboxSendingDaemon start ...");
    }
}
