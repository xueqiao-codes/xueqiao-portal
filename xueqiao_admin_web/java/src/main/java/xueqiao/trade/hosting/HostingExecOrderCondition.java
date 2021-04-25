/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package xueqiao.trade.hosting;


import java.util.Map;
import java.util.HashMap;
import org.apache.thrift.TEnum;

public enum HostingExecOrderCondition implements org.apache.thrift.TEnum {
  LASTEST_PRICE_GT(1),
  LASTEST_PRICE_GE(2),
  LASTEST_PRICE_LT(3),
  LASTEST_PRICE_LE(4),
  SELLONE_PRICE_GT(5),
  SELLONE_PRICE_GE(6),
  SELLONE_PRICE_LT(7),
  SELLONE_PRICE_LE(8),
  BUYONE_PRICE_GT(9),
  BUYONE_PRICE_GE(10),
  BUYONE_PRICE_LT(11),
  BUYONE_PRICE_LE(12);

  private final int value;

  private HostingExecOrderCondition(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  public static HostingExecOrderCondition findByValue(int value) { 
    switch (value) {
      case 1:
        return LASTEST_PRICE_GT;
      case 2:
        return LASTEST_PRICE_GE;
      case 3:
        return LASTEST_PRICE_LT;
      case 4:
        return LASTEST_PRICE_LE;
      case 5:
        return SELLONE_PRICE_GT;
      case 6:
        return SELLONE_PRICE_GE;
      case 7:
        return SELLONE_PRICE_LT;
      case 8:
        return SELLONE_PRICE_LE;
      case 9:
        return BUYONE_PRICE_GT;
      case 10:
        return BUYONE_PRICE_GE;
      case 11:
        return BUYONE_PRICE_LT;
      case 12:
        return BUYONE_PRICE_LE;
      default:
        return null;
    }
  }
}
