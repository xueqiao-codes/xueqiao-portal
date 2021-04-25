package xueqiao.mailbox.dao.util;

import com.google.gson.Gson;
import org.apache.commons.lang.StringUtils;
import xueqiao.mailbox.dao.bean.LMessageContent;
import xueqiao.mailbox.dao.storage.bean.*;
import xueqiao.mailbox.thriftdata.mb.*;
import xueqiao.mailbox.thriftdata.message.MessageContent;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MessageUtil {

    public static int convertChannelListToInt(List<MSendingChannel> channelList) {
        if (CollectionUtil.isListBlank(channelList)) {
            return 0;
        }
        int channelInt = 0;
        for (MSendingChannel channel : channelList) {
            channelInt = channelInt | channel.getValue();
        }
        return channelInt;
    }

    public static List<MSendingChannel> convertChannelToList(int channelInt) {
        List<MSendingChannel> channelList = new ArrayList<>();
        /*
        * 控制其他地方编历channel列表的顺序
        * */
        MSendingChannel[] channelArray = new MSendingChannel[3];
        channelArray[0] = MSendingChannel.MSC_HOSTING;
        channelArray[1] = MSendingChannel.MSC_MAIL;
        channelArray[2] = MSendingChannel.MSC_SMS;
        for (MSendingChannel channel : channelArray) {
            if ((channel.getValue() & channelInt) != 0) {
                channelList.add(channel);
            }
        }
        return channelList;
    }

    /**
     * 返回打开了某位开关的所有值
     * 背景：Channel在数据库的存储是以位域的方式，用某个位来表示某个渠道的开关。
     * 当要查询打开了某个渠道的数据时，就需要用in的方式来查找所有包含了打开该渠道
     * 开关的值。
     */
    public static Set<Integer> convertChannelToIntegerList(MSendingChannel channel) {
        Set<Integer> channelSet = new HashSet<>();
        // 最大值是 （2 ^ 位总数） - 1， 如MSendingChannel有3位，则最大值为2 ^ 3 - 1 = 7
        int maxValue = (2 << (MSendingChannel.values().length - 1)) - 1;
        for (int index = 1; index <= maxValue; index++) {
            channelSet.add(index | channel.getValue());
        }
        return channelSet;
    }

    public static int convertRoleListToInt(List<HostingUserRole> roleList) {
        // 默认发所有者，所以为空时，最大值
        if (CollectionUtil.isListBlank(roleList)) {
            return (2 << (HostingUserRole.values().length - 1)) - 1;
        }
        int roleInt = 0;
        for (HostingUserRole role : roleList) {
            roleInt = roleInt | role.getValue();
        }
        return roleInt;
    }

    public static List<HostingUserRole> convertRoleToList(int roleInt) {
        List<HostingUserRole> roleList = new ArrayList<>();
        for (HostingUserRole role : HostingUserRole.values()) {
            if ((role.getValue() & roleInt) != 0) {
                roleList.add(role);
            }
        }
        return roleList;
    }

    public static String convertMessageContentToJson(MessageContent content) {
        LMessageContent lMessageContent = new LMessageContent();
        lMessageContent.setType(content.getType());
        lMessageContent.setLevel(content.getLevel());
        lMessageContent.setTitle(content.getTitle());
        lMessageContent.setSummary(content.getSummary());
        lMessageContent.setContent(content.getContent());
        return new Gson().toJson(lMessageContent);
    }

    public static MessageContent convertJsonToMessageContent(String json) {
        return new Gson().fromJson(json, MessageContent.class);
    }

    public static TmSendingTimeRule convertTimeRuleToTm(MSendingTimeRule mSendingTimeRule) {
        TmSendingTimeRule tmSendingTimeRule = new TmSendingTimeRule();
        tmSendingTimeRule.setMbmId(mSendingTimeRule.getMbmId());
        tmSendingTimeRule.setMbStartTime(mSendingTimeRule.getMbStartTime());
        tmSendingTimeRule.setRepeatUnit(mSendingTimeRule.getRepeatUnit());
        tmSendingTimeRule.setRepeatCount(mSendingTimeRule.getRepeatCount());
        Gson gson = new Gson();
        if (!mSendingTimeRule.getDayTimeList().isEmpty()) {
            tmSendingTimeRule.setDayTimeList(gson.toJson(mSendingTimeRule.getDayTimeList()));
        }
        if (!mSendingTimeRule.getUnitTimeList().isEmpty()) {
            tmSendingTimeRule.setUnitTimeList(gson.toJson(mSendingTimeRule.getUnitTimeList()));
        }
        return tmSendingTimeRule;
    }

    public static MSendingTimeRule convertTmSendingTimeRuleToM(TmSendingTimeRule tmSendingTimeRule) {
        MSendingTimeRule timeRule = new MSendingTimeRule();
        timeRule.setMbmId(tmSendingTimeRule.getMbmId());
        timeRule.setMbStartTime(tmSendingTimeRule.getMbStartTime());
        timeRule.setRepeatUnit(tmSendingTimeRule.getRepeatUnit());
        timeRule.setRepeatCount(tmSendingTimeRule.getRepeatCount());
        Gson gson = new Gson();
        if (StringUtils.isNotBlank(tmSendingTimeRule.getDayTimeList())) {
            timeRule.setDayTimeList(JsonUtil.convertToLongArrayList(tmSendingTimeRule.getDayTimeList()));
        }
        if (StringUtils.isNotBlank(tmSendingTimeRule.getUnitTimeList())) {
            timeRule.setUnitTimeList(JsonUtil.convertToIntegerArrayList(tmSendingTimeRule.getUnitTimeList()));
        }
        return timeRule;
    }

    public static MessageContent castToMBMessage(TmbMessage tmbMessage) {
        MessageContent messageContent = new MessageContent();
        messageContent.setType(tmbMessage.getContentType());
        messageContent.setLevel(tmbMessage.getContentLevel());
        messageContent.setTitle(tmbMessage.getContentTitle());
        messageContent.setSummary(tmbMessage.getContentSummary());
        messageContent.setContent(tmbMessage.getContentBody());
        return messageContent;
    }

    public static MessageContent castToMBMessage(TmbMessageTemplate template) {
        MessageContent messageContent = new MessageContent();
        messageContent.setType(template.getContentType());
        messageContent.setLevel(template.getContentLevel());
        messageContent.setTitle(template.getContentTitle());
        messageContent.setSummary(template.getContentSummary());
        messageContent.setContent(template.getContentBody());
        return messageContent;
    }

    public static MessageContent castToMBMessage(TmbMessageJob job) {
        MessageContent messageContent = new MessageContent();
        messageContent.setType(job.getContentType());
        messageContent.setLevel(job.getContentLevel());
        messageContent.setTitle(job.getContentTitle());
        messageContent.setSummary(job.getContentSummary());
        messageContent.setContent(job.getContentBody());
        return messageContent;
    }

    public static TmbReceiverHosting castToTmbReceiverHosting(MReceiverHosting receiverHosting) {
        TmbReceiverHosting tmbReceiverHosting = new TmbReceiverHosting();
        tmbReceiverHosting.setMbmId(receiverHosting.getMbmId());
        tmbReceiverHosting.setCompanyId(receiverHosting.getCompanyId());
        tmbReceiverHosting.setGroupId(receiverHosting.getGroupId());
        tmbReceiverHosting.setRole(convertRoleListToInt(receiverHosting.getRoleList()));
        return tmbReceiverHosting;
    }

    public static MReceiverHosting castToMReceiverHosting(TmbReceiverHosting tmbReceiverHosting) {
        MReceiverHosting mReceiverHosting = new MReceiverHosting();
        mReceiverHosting.setMbmId(tmbReceiverHosting.getMbmId());
        mReceiverHosting.setCompanyId(tmbReceiverHosting.getCompanyId());
        mReceiverHosting.setGroupId(tmbReceiverHosting.getGroupId());
        mReceiverHosting.setRoleList(convertRoleToList(tmbReceiverHosting.getRole()));
        return mReceiverHosting;
    }

    public static Set<Integer> getMStatusValueSet(Set<MStatus> mStatusList) {
        Set<Integer> mStatusValueList = new HashSet<>();
        if (mStatusList != null) {
            for (MStatus mStatus : mStatusList) {
                mStatusValueList.add(mStatus.getValue());
            }
        }
        return mStatusValueList;
    }

    public static Set<Integer> getMJStatusValueSet(Set<MJStatus> mStatusList) {
        Set<Integer> mStatusValueList = new HashSet<>();
        if (mStatusList != null) {
            for (MJStatus status : mStatusList) {
                mStatusValueList.add(status.getValue());
            }
        }
        return mStatusValueList;
    }
}
