/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package xueqiao.mailbox.thriftdata.mb;


import java.util.Map;
import java.util.HashMap;
import org.apache.thrift.TEnum;

/**
 * 消息发送时间重复单位
 */
public enum MSendingTimeRepeatUnit implements org.apache.thrift.TEnum {
  MSTRU_INFINITE(0),
  MSTRU_DAY(1),
  MSTRU_WEEK(2),
  MSTRU_MONTH(3);

  private final int value;

  private MSendingTimeRepeatUnit(int value) {
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
  public static MSendingTimeRepeatUnit findByValue(int value) { 
    switch (value) {
      case 0:
        return MSTRU_INFINITE;
      case 1:
        return MSTRU_DAY;
      case 2:
        return MSTRU_WEEK;
      case 3:
        return MSTRU_MONTH;
      default:
        return null;
    }
  }
}
