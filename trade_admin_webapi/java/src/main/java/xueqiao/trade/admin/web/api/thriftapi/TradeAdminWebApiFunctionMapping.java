package xueqiao.trade.admin.web.api.thriftapi;


import java.util.HashMap;
import java.util.Map; 

public class TradeAdminWebApiFunctionMapping {

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
    putEntry("reqQuotationAccountInfo",9);
    putEntry("updateQuotationAccountInfo",10);
    putEntry("addQuotationAccountInfo",11);
    putEntry("deleteQuotationAccount",12);
    putEntry("reqAccountRegisterAbility",13);
    putEntry("addAccountRegisterAbility",15);
    putEntry("deleteAccountRegisterAbility",16);
    putEntry("reqSubscribedContract",17);
    putEntry("reqContractTreeExchangeNodes",30);
    putEntry("reqContractTreeCommodityNodes",31);
    putEntry("reqContractTreeContractNodes",32);
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
