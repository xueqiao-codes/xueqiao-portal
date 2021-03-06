/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.longsheng.xueqiao.contract.thriftapi;


import java.util.Map;
import java.util.HashMap;
import org.apache.thrift.TEnum;

public enum EditStatus implements org.apache.thrift.TEnum {
  NEW(0),
  EDIT(1),
  VERIFIED_CORRECT(2),
  SYNCHRONIZED(3);

  private final int value;

  private EditStatus(int value) {
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
  public static EditStatus findByValue(int value) { 
    switch (value) {
      case 0:
        return NEW;
      case 1:
        return EDIT;
      case 2:
        return VERIFIED_CORRECT;
      case 3:
        return SYNCHRONIZED;
      default:
        return null;
    }
  }
}
