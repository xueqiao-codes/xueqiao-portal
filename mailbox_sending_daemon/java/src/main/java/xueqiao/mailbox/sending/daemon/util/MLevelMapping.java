package xueqiao.mailbox.sending.daemon.util;

import xueqiao.mailbox.thriftdata.message.MLevel;

public class MLevelMapping {
    public static xueqiao.mailbox.user.message.thriftapi.MLevel getMLevel(MLevel level) {
        return xueqiao.mailbox.user.message.thriftapi.MLevel.valueOf(level.name());
    }
}
