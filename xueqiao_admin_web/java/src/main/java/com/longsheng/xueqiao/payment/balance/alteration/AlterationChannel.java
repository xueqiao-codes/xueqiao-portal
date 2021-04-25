/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.longsheng.xueqiao.payment.balance.alteration;


import java.util.Map;
import java.util.HashMap;
import org.apache.thrift.TEnum;

public enum AlterationChannel implements org.apache.thrift.TEnum {
  NONE(0),
  ALIPAY(1),
  WXPAY(2),
  BANK_TRANSFER(3),
  OTHERS(4);

  private final int value;

  private AlterationChannel(int value) {
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
  public static AlterationChannel findByValue(int value) { 
    switch (value) {
      case 0:
        return NONE;
      case 1:
        return ALIPAY;
      case 2:
        return WXPAY;
      case 3:
        return BANK_TRANSFER;
      case 4:
        return OTHERS;
      default:
        return null;
    }
  }
}