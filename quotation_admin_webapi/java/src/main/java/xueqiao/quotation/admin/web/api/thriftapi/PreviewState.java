/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package xueqiao.quotation.admin.web.api.thriftapi;


import java.util.Map;
import java.util.HashMap;
import org.apache.thrift.TEnum;

public enum PreviewState implements org.apache.thrift.TEnum {
  EMPTY(0),
  GEN_TASK_RUNNING(1),
  FINISH(2),
  GEN_FAIL(3);

  private final int value;

  private PreviewState(int value) {
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
  public static PreviewState findByValue(int value) { 
    switch (value) {
      case 0:
        return EMPTY;
      case 1:
        return GEN_TASK_RUNNING;
      case 2:
        return FINISH;
      case 3:
        return GEN_FAIL;
      default:
        return null;
    }
  }
}