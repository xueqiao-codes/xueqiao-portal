/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package xueqiao.quotation.plan.bo;


import java.util.Map;
import java.util.HashMap;
import org.apache.thrift.TEnum;

public enum EGenPreviewStatus implements org.apache.thrift.TEnum {
  PREVIEW_EMPTY(0),
  PREVIEW_GENTASK_RUNNING(1),
  PREVIEW_FINISHED(2),
  PREVIEW_GENFAILED(3);

  private final int value;

  private EGenPreviewStatus(int value) {
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
  public static EGenPreviewStatus findByValue(int value) { 
    switch (value) {
      case 0:
        return PREVIEW_EMPTY;
      case 1:
        return PREVIEW_GENTASK_RUNNING;
      case 2:
        return PREVIEW_FINISHED;
      case 3:
        return PREVIEW_GENFAILED;
      default:
        return null;
    }
  }
}
