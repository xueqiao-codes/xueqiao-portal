package xueqiao.hosting.machine.dao;


import java.util.HashMap;
import java.util.Map; 

public class HostingMachineDaoFunctionMapping {

  private static Map<String, Integer> sMapping = new HashMap<String, Integer>();

  static {
    putEntry("addHostingMachine",1);
    putEntry("updateHostingMachine",2);
    putEntry("deleteHostingMachine",3);
    putEntry("queryHostingMachinePage",4);
    putEntry("addRelatedInfo",5);
    putEntry("updateRelatedInfo",6);
    putEntry("deleteRelatedInfo",7);
    putEntry("queryRelatedInfoPage",8);
    putEntry("addInitHostingMachineRecord",10);
    putEntry("updateInitHostingMachineRecord",11);
    putEntry("queryHostingInitializationPage",12);
    putEntry("addSyncHostingUser",13);
    putEntry("updateSyncHostingUser",14);
    putEntry("querySyncHostingUserPage",15);
    putEntry("addSyncTaskQueue",20);
    putEntry("querySyncTaskQueue",21);
    putEntry("deleteSyncTaskQueue",22);
    putEntry("updateSyncTaskQueue",23);
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
