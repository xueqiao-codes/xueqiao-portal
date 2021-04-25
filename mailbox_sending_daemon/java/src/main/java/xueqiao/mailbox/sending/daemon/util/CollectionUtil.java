package xueqiao.mailbox.sending.daemon.util;

import java.util.List;

public class CollectionUtil {
    public static boolean isListNotBlank(List list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean isListBlank(List list) {
        if (list == null || list.isEmpty()) {
            return true;
        }
        return false;
    }
}
