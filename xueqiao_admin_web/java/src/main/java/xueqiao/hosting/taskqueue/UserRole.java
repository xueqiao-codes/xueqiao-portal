/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package xueqiao.hosting.taskqueue;


import java.util.Map;
import java.util.HashMap;
import org.apache.thrift.TEnum;

public enum UserRole implements org.apache.thrift.TEnum {
  TRADER(0),
  ADMIN(1),
  OBSERVER(2);

  private final int value;

  private UserRole(int value) {
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
  public static UserRole findByValue(int value) { 
    switch (value) {
      case 0:
        return TRADER;
      case 1:
        return ADMIN;
      case 2:
        return OBSERVER;
      default:
        return null;
    }
  }
}
