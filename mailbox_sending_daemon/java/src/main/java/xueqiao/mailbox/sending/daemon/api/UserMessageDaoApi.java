package xueqiao.mailbox.sending.daemon.api;

import org.apache.thrift.TException;
import xueqiao.mailbox.user.message.dao.thriftapi.client.UserMessageDaoStub;
import xueqiao.mailbox.user.message.thriftapi.UserMessage;

import java.util.List;

public class UserMessageDaoApi {
    private static UserMessageDaoStub userMessageDaoStub = new UserMessageDaoStub();

    public static void addUserMessage(List<UserMessage> userMessageList) throws TException {
        userMessageDaoStub.addUserMessage(userMessageList);
    }
}
