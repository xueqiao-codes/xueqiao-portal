package xueqiao.mailbox.sending.daemon.util;

import xueqiao.mailbox.thriftdata.message.MType;

public class MTypeMapping {
    public static xueqiao.mailbox.user.message.thriftapi.MType getMType(MType type) {
        return xueqiao.mailbox.user.message.thriftapi.MType.valueOf(type.name());
    }
}
