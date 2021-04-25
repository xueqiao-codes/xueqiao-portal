package xueqiao.mailbox.dao.thriftapi;


import java.util.HashMap;
import java.util.Map; 

public class MailboxDaoFunctionMapping {

  private static Map<String, Integer> sMapping = new HashMap<String, Integer>();

  static {
    putEntry("addMBMessage",1);
    putEntry("modifyMBMessageStatus",2);
    putEntry("queryMBMessagePage",3);
    putEntry("addMBMessageTemplate",6);
    putEntry("modifyMBMessageTemplate",7);
    putEntry("deleteMBMessageTemplate",8);
    putEntry("queryMBMessageTemplatePage",9);
    putEntry("startSendMBMessage",10);
    putEntry("modifyMBMessageJobStatus",12);
    putEntry("queryMBMessageJobPage",13);
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
