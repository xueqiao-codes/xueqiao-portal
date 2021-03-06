/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package xueqiao.trade.hosting;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HostingExecOrderDealCTPInfo implements org.apache.thrift.TBase<HostingExecOrderDealCTPInfo, HostingExecOrderDealCTPInfo._Fields>, java.io.Serializable, Cloneable, Comparable<HostingExecOrderDealCTPInfo> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("HostingExecOrderDealCTPInfo");

  private static final org.apache.thrift.protocol.TField OFFSET_FLAG_FIELD_DESC = new org.apache.thrift.protocol.TField("offsetFlag", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField TRADE_DIRECTION_FIELD_DESC = new org.apache.thrift.protocol.TField("tradeDirection", org.apache.thrift.protocol.TType.I32, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new HostingExecOrderDealCTPInfoStandardSchemeFactory());
    schemes.put(TupleScheme.class, new HostingExecOrderDealCTPInfoTupleSchemeFactory());
  }

  /**
   * 
   * @see CTPCombOffsetFlagType
   */
  public CTPCombOffsetFlagType offsetFlag; // optional
  /**
   * 
   * @see CTPTradeDirection
   */
  public CTPTradeDirection tradeDirection; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * 
     * @see CTPCombOffsetFlagType
     */
    OFFSET_FLAG((short)1, "offsetFlag"),
    /**
     * 
     * @see CTPTradeDirection
     */
    TRADE_DIRECTION((short)2, "tradeDirection");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // OFFSET_FLAG
          return OFFSET_FLAG;
        case 2: // TRADE_DIRECTION
          return TRADE_DIRECTION;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private _Fields optionals[] = {_Fields.OFFSET_FLAG,_Fields.TRADE_DIRECTION};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.OFFSET_FLAG, new org.apache.thrift.meta_data.FieldMetaData("offsetFlag", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, CTPCombOffsetFlagType.class)));
    tmpMap.put(_Fields.TRADE_DIRECTION, new org.apache.thrift.meta_data.FieldMetaData("tradeDirection", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, CTPTradeDirection.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(HostingExecOrderDealCTPInfo.class, metaDataMap);
  }

  public HostingExecOrderDealCTPInfo() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public HostingExecOrderDealCTPInfo(HostingExecOrderDealCTPInfo other) {
    if (other.isSetOffsetFlag()) {
      this.offsetFlag = other.offsetFlag;
    }
    if (other.isSetTradeDirection()) {
      this.tradeDirection = other.tradeDirection;
    }
  }

  public HostingExecOrderDealCTPInfo deepCopy() {
    return new HostingExecOrderDealCTPInfo(this);
  }

  @Override
  public void clear() {
    this.offsetFlag = null;
    this.tradeDirection = null;
  }

  /**
   * 
   * @see CTPCombOffsetFlagType
   */
  public CTPCombOffsetFlagType getOffsetFlag() {
    return this.offsetFlag;
  }

  /**
   * 
   * @see CTPCombOffsetFlagType
   */
  public HostingExecOrderDealCTPInfo setOffsetFlag(CTPCombOffsetFlagType offsetFlag) {
    this.offsetFlag = offsetFlag;
    return this;
  }

  public void unsetOffsetFlag() {
    this.offsetFlag = null;
  }

  /** Returns true if field offsetFlag is set (has been assigned a value) and false otherwise */
  public boolean isSetOffsetFlag() {
    return this.offsetFlag != null;
  }

  public void setOffsetFlagIsSet(boolean value) {
    if (!value) {
      this.offsetFlag = null;
    }
  }

  /**
   * 
   * @see CTPTradeDirection
   */
  public CTPTradeDirection getTradeDirection() {
    return this.tradeDirection;
  }

  /**
   * 
   * @see CTPTradeDirection
   */
  public HostingExecOrderDealCTPInfo setTradeDirection(CTPTradeDirection tradeDirection) {
    this.tradeDirection = tradeDirection;
    return this;
  }

  public void unsetTradeDirection() {
    this.tradeDirection = null;
  }

  /** Returns true if field tradeDirection is set (has been assigned a value) and false otherwise */
  public boolean isSetTradeDirection() {
    return this.tradeDirection != null;
  }

  public void setTradeDirectionIsSet(boolean value) {
    if (!value) {
      this.tradeDirection = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case OFFSET_FLAG:
      if (value == null) {
        unsetOffsetFlag();
      } else {
        setOffsetFlag((CTPCombOffsetFlagType)value);
      }
      break;

    case TRADE_DIRECTION:
      if (value == null) {
        unsetTradeDirection();
      } else {
        setTradeDirection((CTPTradeDirection)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case OFFSET_FLAG:
      return getOffsetFlag();

    case TRADE_DIRECTION:
      return getTradeDirection();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case OFFSET_FLAG:
      return isSetOffsetFlag();
    case TRADE_DIRECTION:
      return isSetTradeDirection();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof HostingExecOrderDealCTPInfo)
      return this.equals((HostingExecOrderDealCTPInfo)that);
    return false;
  }

  public boolean equals(HostingExecOrderDealCTPInfo that) {
    if (that == null)
      return false;

    boolean this_present_offsetFlag = true && this.isSetOffsetFlag();
    boolean that_present_offsetFlag = true && that.isSetOffsetFlag();
    if (this_present_offsetFlag || that_present_offsetFlag) {
      if (!(this_present_offsetFlag && that_present_offsetFlag))
        return false;
      if (!this.offsetFlag.equals(that.offsetFlag))
        return false;
    }

    boolean this_present_tradeDirection = true && this.isSetTradeDirection();
    boolean that_present_tradeDirection = true && that.isSetTradeDirection();
    if (this_present_tradeDirection || that_present_tradeDirection) {
      if (!(this_present_tradeDirection && that_present_tradeDirection))
        return false;
      if (!this.tradeDirection.equals(that.tradeDirection))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(HostingExecOrderDealCTPInfo other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetOffsetFlag()).compareTo(other.isSetOffsetFlag());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetOffsetFlag()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.offsetFlag, other.offsetFlag);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTradeDirection()).compareTo(other.isSetTradeDirection());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTradeDirection()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.tradeDirection, other.tradeDirection);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("HostingExecOrderDealCTPInfo(");
    boolean first = true;

    if (isSetOffsetFlag()) {
      sb.append("offsetFlag:");
      if (this.offsetFlag == null) {
        sb.append("null");
      } else {
        sb.append(this.offsetFlag);
      }
      first = false;
    }
    if (isSetTradeDirection()) {
      if (!first) sb.append(", ");
      sb.append("tradeDirection:");
      if (this.tradeDirection == null) {
        sb.append("null");
      } else {
        sb.append(this.tradeDirection);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class HostingExecOrderDealCTPInfoStandardSchemeFactory implements SchemeFactory {
    public HostingExecOrderDealCTPInfoStandardScheme getScheme() {
      return new HostingExecOrderDealCTPInfoStandardScheme();
    }
  }

  private static class HostingExecOrderDealCTPInfoStandardScheme extends StandardScheme<HostingExecOrderDealCTPInfo> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, HostingExecOrderDealCTPInfo struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // OFFSET_FLAG
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.offsetFlag = CTPCombOffsetFlagType.findByValue(iprot.readI32());
              struct.setOffsetFlagIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // TRADE_DIRECTION
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.tradeDirection = CTPTradeDirection.findByValue(iprot.readI32());
              struct.setTradeDirectionIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, HostingExecOrderDealCTPInfo struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.offsetFlag != null) {
        if (struct.isSetOffsetFlag()) {
          oprot.writeFieldBegin(OFFSET_FLAG_FIELD_DESC);
          oprot.writeI32(struct.offsetFlag.getValue());
          oprot.writeFieldEnd();
        }
      }
      if (struct.tradeDirection != null) {
        if (struct.isSetTradeDirection()) {
          oprot.writeFieldBegin(TRADE_DIRECTION_FIELD_DESC);
          oprot.writeI32(struct.tradeDirection.getValue());
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class HostingExecOrderDealCTPInfoTupleSchemeFactory implements SchemeFactory {
    public HostingExecOrderDealCTPInfoTupleScheme getScheme() {
      return new HostingExecOrderDealCTPInfoTupleScheme();
    }
  }

  private static class HostingExecOrderDealCTPInfoTupleScheme extends TupleScheme<HostingExecOrderDealCTPInfo> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, HostingExecOrderDealCTPInfo struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetOffsetFlag()) {
        optionals.set(0);
      }
      if (struct.isSetTradeDirection()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetOffsetFlag()) {
        oprot.writeI32(struct.offsetFlag.getValue());
      }
      if (struct.isSetTradeDirection()) {
        oprot.writeI32(struct.tradeDirection.getValue());
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, HostingExecOrderDealCTPInfo struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.offsetFlag = CTPCombOffsetFlagType.findByValue(iprot.readI32());
        struct.setOffsetFlagIsSet(true);
      }
      if (incoming.get(1)) {
        struct.tradeDirection = CTPTradeDirection.findByValue(iprot.readI32());
        struct.setTradeDirectionIsSet(true);
      }
    }
  }

}

