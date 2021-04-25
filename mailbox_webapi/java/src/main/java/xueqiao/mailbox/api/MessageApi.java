package xueqiao.mailbox.api;

import org.apache.commons.lang.StringUtils;
import org.apache.thrift.TException;
import xueqiao.mailbox.dao.thriftapi.client.MailboxDaoStub;
import xueqiao.mailbox.thriftdata.mb.MBMessage;
import xueqiao.mailbox.webapi.thriftapi.OperateResult;


public class MessageApi {

    public OperateResult addMBMessage(MBMessage message) throws TException {

        if (message.isSetContent()) {
            String text = message.getContent().getContent();
            if (StringUtils.isNotBlank(text)) {
                message.getContent().setContent(Utils.saveContentText(message.getContent(), ""));
            }
        }

        new MailboxDaoStub().addMBMessage(message);
        return success();
    }

    private OperateResult success() {
        OperateResult result = new OperateResult();
        result.setSuccess(true);
        return result;
    }
}
