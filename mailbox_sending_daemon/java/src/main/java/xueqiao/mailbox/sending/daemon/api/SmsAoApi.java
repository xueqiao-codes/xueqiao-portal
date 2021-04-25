package xueqiao.mailbox.sending.daemon.api;

import com.longsheng.xueqiao.goose.thriftapi.client.GooseAoStub;
import org.apache.thrift.TException;

public class SmsAoApi {
    private static GooseAoStub smsAoStub = new GooseAoStub();

    public static void sendSms(String tel, String userName, String smsContent) throws TException {
        smsAoStub.sendMailboxMessage(tel, userName, smsContent);
    }
}
