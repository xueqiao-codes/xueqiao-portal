package xueqiao.mailbox.webapi.thriftapi;


import java.util.HashMap;
import java.util.Map; 

public class MailboxWebapiFunctionMapping {

  private static Map<String, Integer> sMapping = new HashMap<String, Integer>();

  static {
    putEntry("reqTemplate",1);
    putEntry("addTemplate",2);
    putEntry("updateTemplate",3);
    putEntry("removeTemplate",4);
    putEntry("reqMBMessageJob",5);
    putEntry("addMBMessage",6);
    putEntry("reqCompanyReceiver",7);
    putEntry("reqGroupReceiver",8);
    putEntry("reqContentText",9);
    putEntry("reqMBMessageTemplateSelector",10);
    putEntry("reqMBMessage",11);
    putEntry("updateMessageJobStatus",12);
  }

  public static int getUniqueNumber(String functionName) {
    Integer number = sMapping.get(functionName);
    if (number == null) {
      return -1;    }
    return number.intValue();
  }

  private static void putEntry(String functionName, int uniqueNumber) {
    sMapping.put(functionName, uniqueNumber);
  }

}
