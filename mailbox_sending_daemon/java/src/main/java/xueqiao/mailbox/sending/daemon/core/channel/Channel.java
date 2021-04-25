package xueqiao.mailbox.sending.daemon.core.channel;

import org.apache.commons.lang.StringUtils;
import org.apache.thrift.TException;
import xueqiao.company.GroupUserEx;
import xueqiao.mailbox.sending.daemon.core.bean.Receiver;
import xueqiao.mailbox.sending.daemon.core.bean.SendingMessage;

import static xueqiao.mailbox.thriftdata.message.mb_messageConstants.*;

public abstract class Channel {
//    protected long jobId;
    protected SendingMessage sendingMessage;
//    protected BaseMessage message;
//    protected List<GroupUserEx> groupUserList;

//    public Channel(long jobId, List<GroupUserEx> groupUserList, BaseMessage message) {
//        this.jobId = jobId;
//        this.groupUserList = groupUserList;
//        this.message = message;
//    }

    public Channel(SendingMessage sendingMessage) {
        this.sendingMessage = sendingMessage;
    }

    protected String preProcess(GroupUserEx groupUserEx, String messageContent) {
        String messageContentPreProcess = messageContent;
        /*
         * 因为companyName用户不填写的话，就会是空，所以，这个字段不做为可替换变量
         * */
//            if (StringUtils.isNotBlank(groupUserEx.getCompanyName())) {
//                messageContentPreProcess = messageContent.replace(MESSAGE_ENV_VARIABLE_COMPANY_NAME, groupUserEx.getCompanyName());
//            }
        if (StringUtils.isNotBlank(groupUserEx.getCompanyCode())) {
            messageContentPreProcess = messageContentPreProcess.replace(MESSAGE_ENV_VARIABLE_COMPANY_CODE, groupUserEx.getCompanyCode());
        }
        /*
        * 本系统是在公司用户级别，不在公司组用户级别，所以，不要存在组相关的内容
        * */
//        if (StringUtils.isNotBlank(groupUserEx.getGroupName())) {
//            messageContentPreProcess = messageContentPreProcess.replace(MESSAGE_ENV_VARIABLE_GROUP_NAME, groupUserEx.getGroupName());
//        }
        if (StringUtils.isNotBlank(groupUserEx.getCnName())) {
            messageContentPreProcess = messageContentPreProcess.replace(MESSAGE_ENV_VARIABLE_USER_NAME, groupUserEx.getCnName());
        }
        return messageContentPreProcess;
    }

    protected String preProcess(Receiver receiver, String messageContent) {
        String messageContentPreProcess = messageContent;
        /*
         * 因为companyName用户不填写的话，就会是空，所以，这个字段不做为可替换变量
         * */
//            if (StringUtils.isNotBlank(groupUserEx.getCompanyName())) {
//                messageContentPreProcess = messageContent.replace(MESSAGE_ENV_VARIABLE_COMPANY_NAME, groupUserEx.getCompanyName());
//            }
        if (StringUtils.isNotBlank(receiver.getCompanyCode())) {
            messageContentPreProcess = messageContentPreProcess.replace(MESSAGE_ENV_VARIABLE_COMPANY_CODE, receiver.getCompanyCode());
        }
//        if (StringUtils.isNotBlank(receiver.getGroupName())) {
//            messageContentPreProcess = messageContentPreProcess.replace(MESSAGE_ENV_VARIABLE_GROUP_NAME, receiver.getGroupName());
//        }
        if (StringUtils.isNotBlank(receiver.getCnName())) {
            messageContentPreProcess = messageContentPreProcess.replace(MESSAGE_ENV_VARIABLE_USER_NAME, receiver.getCnName());
        }
        return messageContentPreProcess;
    }

    protected boolean isMessageBodyShouldPreProcess(String messageContent) {
        if (StringUtils.isBlank(messageContent)) {
            return false;
        }
        if (messageContent.contains(MESSAGE_ENV_VARIABLE_COMPANY_CODE)) {
            return true;
        }
        if (messageContent.contains(MESSAGE_ENV_VARIABLE_GROUP_NAME)) {
            return true;
        }
        if (messageContent.contains(MESSAGE_ENV_VARIABLE_USER_NAME)) {
            return true;
        }
        return false;
    }

    public abstract void send() throws TException;
}
