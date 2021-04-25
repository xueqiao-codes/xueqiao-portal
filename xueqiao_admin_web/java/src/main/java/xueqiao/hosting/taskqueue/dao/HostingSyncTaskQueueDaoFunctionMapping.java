package xueqiao.hosting.taskqueue.dao;


import java.util.HashMap;
import java.util.Map; 

public class HostingSyncTaskQueueDaoFunctionMapping {

  private static Map<String, Integer> sMapping = new HashMap<String, Integer>();

  static {
    putEntry("addSyncTaskQueue",1);
    putEntry("querySyncTaskQueue",2);
    putEntry("deleteSyncTaskQueue",3);
    putEntry("updateSyncTaskQueue",4);
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
