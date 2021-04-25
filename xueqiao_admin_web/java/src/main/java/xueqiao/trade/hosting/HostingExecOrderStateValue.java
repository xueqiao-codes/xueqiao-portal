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

public enum HostingExecOrderStateValue implements org.apache.thrift.TEnum {
  ORDER_WAITING_VERIFY(1),
  ORDER_VERIFY_FAILED(2),
  ORDER_WAITING_SLED_SEND(3),
  ORDER_SLED_SEND_FAILED(4),
  ORDER_SLED_SEND_UNKOWN(5),
  ORDER_UPSIDE_REJECTED(6),
  ORDER_UPSIDE_RECEIVED(7),
  ORDER_UPSIDE_RESTING(8),
  ORDER_UPSIDE_PARTFINISHED(9),
  ORDER_UPSIDE_FINISHED(11),
  ORDER_UPSIDE_RECEIVED_WAITING_REVOKE(12),
  ORDER_UPSIDE_RESTING_WAITING_REVOKE(13),
  ORDER_UPSIDE_PARTFINISHED_WAITING_REVOKE(14),
  ORDER_UPSIDE_RECEIVED_REVOKE_SEND_UNKOWN(15),
  ORDER_UPSIDE_RESTING_REVOKE_SEND_UNKOWN(16),
  ORDER_UPSIDE_PARTFINISHED_REVOKE_SEND_UNKOWN(17),
  ORDER_UPSIDE_REVOKE_RECEIVED(18),
  ORDER_UPSIDE_DELETED(20),
  ORDER_CONDITION_NOT_TRIGGER(23),
  ORDER_CONDITION_TRIGGEDED(24),
  ORDER_CONDITION_NOT_TRIGGER_WAITING_REVOKE(25),
  ORDER_CONDITION_NOT_TRIGGER_REVOKE_SEND_UNKOWN(26),
  ORDER_SLED_ALLOC_REF_FINISHED(30),
  ORDER_EXPIRED(31);

  private final int value;

  private HostingExecOrderStateValue(int value) {
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
  public static HostingExecOrderStateValue findByValue(int value) { 
    switch (value) {
      case 1:
        return ORDER_WAITING_VERIFY;
      case 2:
        return ORDER_VERIFY_FAILED;
      case 3:
        return ORDER_WAITING_SLED_SEND;
      case 4:
        return ORDER_SLED_SEND_FAILED;
      case 5:
        return ORDER_SLED_SEND_UNKOWN;
      case 6:
        return ORDER_UPSIDE_REJECTED;
      case 7:
        return ORDER_UPSIDE_RECEIVED;
      case 8:
        return ORDER_UPSIDE_RESTING;
      case 9:
        return ORDER_UPSIDE_PARTFINISHED;
      case 11:
        return ORDER_UPSIDE_FINISHED;
      case 12:
        return ORDER_UPSIDE_RECEIVED_WAITING_REVOKE;
      case 13:
        return ORDER_UPSIDE_RESTING_WAITING_REVOKE;
      case 14:
        return ORDER_UPSIDE_PARTFINISHED_WAITING_REVOKE;
      case 15:
        return ORDER_UPSIDE_RECEIVED_REVOKE_SEND_UNKOWN;
      case 16:
        return ORDER_UPSIDE_RESTING_REVOKE_SEND_UNKOWN;
      case 17:
        return ORDER_UPSIDE_PARTFINISHED_REVOKE_SEND_UNKOWN;
      case 18:
        return ORDER_UPSIDE_REVOKE_RECEIVED;
      case 20:
        return ORDER_UPSIDE_DELETED;
      case 23:
        return ORDER_CONDITION_NOT_TRIGGER;
      case 24:
        return ORDER_CONDITION_TRIGGEDED;
      case 25:
        return ORDER_CONDITION_NOT_TRIGGER_WAITING_REVOKE;
      case 26:
        return ORDER_CONDITION_NOT_TRIGGER_REVOKE_SEND_UNKOWN;
      case 30:
        return ORDER_SLED_ALLOC_REF_FINISHED;
      case 31:
        return ORDER_EXPIRED;
      default:
        return null;
    }
  }
}