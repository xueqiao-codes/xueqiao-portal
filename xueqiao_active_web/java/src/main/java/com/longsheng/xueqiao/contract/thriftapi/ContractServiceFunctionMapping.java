package com.longsheng.xueqiao.contract.thriftapi;


import java.util.HashMap;
import java.util.Map; 

public class ContractServiceFunctionMapping {

  private static Map<String, Integer> sMapping = new HashMap<String, Integer>();

  static {
    putEntry("reqSledContractDetail",2);
    putEntry("reqSledCommodity",6);
    putEntry("reqSledExchange",7);
    putEntry("addCommodityMapping",8);
    putEntry("addSledExchange",9);
    putEntry("reqCommodityMapping",10);
    putEntry("addSledCommodity",11);
    putEntry("updateSledExchange",12);
    putEntry("updateSledCommodity",13);
    putEntry("updateCommodityMapping",14);
    putEntry("importCommodityMapFile",30);
    putEntry("reqCommodityMapFileInfo",31);
    putEntry("linkTechPlatformMapping",32);
    putEntry("reqTechPlatformCommodity",33);
    putEntry("addTechPlatformCommodity",34);
    putEntry("activeSledCommodity",35);
    putEntry("syncSledCommodityConfig",36);
    putEntry("removeSledCommodity",37);
    putEntry("removeSledExchange",38);
    putEntry("changeSledCommodityState",39);
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
