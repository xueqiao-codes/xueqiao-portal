package xueqiao.quotation.admin.web.api.thriftapi;


import java.util.HashMap;
import java.util.Map; 

public class QuotationAdminWebApiFunctionMapping {

  private static Map<String, Integer> sMapping = new HashMap<String, Integer>();

  static {
    putEntry("reqCommodityActiveConfig",1);
    putEntry("updateCommodityActiveConfig",2);
    putEntry("addCommodityActiveConfig",3);
    putEntry("deleteCommodityActiveConfig",4);
    putEntry("reqCommodityRegister",5);
    putEntry("updateCommodityRegister",6);
    putEntry("addCommodityRegister",7);
    putEntry("deleteCommodityRegister",8);
    putEntry("setCommodityRegisterOrderIndex",21);
    putEntry("reqQuotationAccountInfo",9);
    putEntry("updateQuotationAccountInfo",10);
    putEntry("addQuotationAccountInfo",11);
    putEntry("deleteQuotationAccount",12);
    putEntry("reqExchangeRegisterAbility",13);
    putEntry("batAddAccountRegisterAbility",15);
    putEntry("deleteAccountRegisterAbility",16);
    putEntry("deleteAccountRegisterAbilityByExchange",23);
    putEntry("reqSubscribedContract",17);
    putEntry("replanSubscribe",18);
    putEntry("reqPreviewSubscribedContract",19);
    putEntry("submitSubscribeInfo",20);
    putEntry("reqPlanningSubscribedInfo",22);
    putEntry("reqCommodityTree",30);
    putEntry("reqCommodityTypeTree",31);
    putEntry("reqContractTreeCommodityNodes",32);
    putEntry("reqContractNodes",34);
    putEntry("reqBrokerTree",33);
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
