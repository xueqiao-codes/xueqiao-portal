package com.longsheng.xueqiao.admin.util;

import java.util.UUID;

public class UuidUtil {

    public static String get16uuid(String name){
        if (name == null || name.isEmpty()) {
            UUID uuid = UUID.randomUUID();
            String str = uuid.toString();
            String uuidStr = str.replace("-", "");
            return uuidStr.substring(8,24);
        } else {
            UUID uuid= UUID.nameUUIDFromBytes(name.getBytes());
            String str = uuid.toString();
            String uuidStr=str.replace("-", "");
            return uuidStr.substring(8,24);
        }
    }
}
