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
 * 信息实例状态
 */
public enum MJStatus implements org.apache.thrift.TEnum {
  MJS_SENDING(0),
  MJS_COMPLETED(1),
  MJS_EXCEPTION_STOP(2),
  MJS_NETWORK_ERROR_RETRY(3),
  MJS_NETWORK_ERROR_STOP(4);

  private final int value;

  private MJStatus(int value) {
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
  public static MJStatus findByValue(int value) { 
    switch (value) {
      case 0:
        return MJS_SENDING;
      case 1:
        return MJS_COMPLETED;
      case 2:
        return MJS_EXCEPTION_STOP;
      case 3:
        return MJS_NETWORK_ERROR_RETRY;
      case 4:
        return MJS_NETWORK_ERROR_STOP;
      default:
        return null;
    }
  }
}
