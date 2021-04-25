package com.longsheng.xueqiao.contract.quotation.source.thriftapi;


import java.util.HashMap;
import java.util.Map; 

public class QuotationSourceServiceFunctionMapping {

  private static Map<String, Integer> sMapping = new HashMap<String, Integer>();

  static {
    putEntry("addQuotationAccount",1);
    putEntry("updateQuotationAccount",2);
    putEntry("updateQuotationAccountSubscribeQuota",3);
    putEntry("reqQuotationAccount",4);
    putEntry("reqQuotationAccountSubscribeQuota",5);
    putEntry("addCommoditySubscribeQuota",6);
    putEntry("updateCommoditySubscribeQuota",7);
    putEntry("reqCommoditySubscribeQuota",8);
    putEntry("deleteQuotationAccount",9);
    putEntry("setCommoditySubscribeAssigned",10);
    putEntry("deleteCommoditySubscribeAssigned",11);
    putEntry("reqCommodityRelatedQuotationAccountSubscribe",13);
    putEntry("reqQuotationAccountRelatedCommoditySubscribe",14);
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
