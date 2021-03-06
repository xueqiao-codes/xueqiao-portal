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

/**
 * 账号路由信息, 主要是子用户关联账户
 */
public class HostingOrderRouteRelatedInfo implements org.apache.thrift.TBase<HostingOrderRouteRelatedInfo, HostingOrderRouteRelatedInfo._Fields>, java.io.Serializable, Cloneable, Comparable<HostingOrderRouteRelatedInfo> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("HostingOrderRouteRelatedInfo");

  private static final org.apache.thrift.protocol.TField FORBIDDEN_FIELD_DESC = new org.apache.thrift.protocol.TField("forbidden", org.apache.thrift.protocol.TType.BOOL, (short)1);
  private static final org.apache.thrift.protocol.TField MAIN_TRADE_ACCOUNT_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("mainTradeAccountId", org.apache.thrift.protocol.TType.I64, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new HostingOrderRouteRelatedInfoStandardSchemeFactory());
    schemes.put(TupleScheme.class, new HostingOrderRouteRelatedInfoTupleSchemeFactory());
  }

  public boolean forbidden; // optional
  public long mainTradeAccountId; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    FORBIDDEN((short)1, "forbidden"),
    MAIN_TRADE_ACCOUNT_ID((short)2, "mainTradeAccountId");

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
        case 1: // FORBIDDEN
          return FORBIDDEN;
        case 2: // MAIN_TRADE_ACCOUNT_ID
          return MAIN_TRADE_ACCOUNT_ID;
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
  private static final int __FORBIDDEN_ISSET_ID = 0;
  private static final int __MAINTRADEACCOUNTID_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  private _Fields optionals[] = {_Fields.FORBIDDEN,_Fields.MAIN_TRADE_ACCOUNT_ID};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.FORBIDDEN, new org.apache.thrift.meta_data.FieldMetaData("forbidden", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    tmpMap.put(_Fields.MAIN_TRADE_ACCOUNT_ID, new org.apache.thrift.meta_data.FieldMetaData("mainTradeAccountId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(HostingOrderRouteRelatedInfo.class, metaDataMap);
  }

  public HostingOrderRouteRelatedInfo() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public HostingOrderRouteRelatedInfo(HostingOrderRouteRelatedInfo other) {
    __isset_bitfield = other.__isset_bitfield;
    this.forbidden = other.forbidden;
    this.mainTradeAccountId = other.mainTradeAccountId;
  }

  public HostingOrderRouteRelatedInfo deepCopy() {
    return new HostingOrderRouteRelatedInfo(this);
  }

  @Override
  public void clear() {
    setForbiddenIsSet(false);
    this.forbidden = false;
    setMainTradeAccountIdIsSet(false);
    this.mainTradeAccountId = 0;
  }

  public boolean isForbidden() {
    return this.forbidden;
  }

  public HostingOrderRouteRelatedInfo setForbidden(boolean forbidden) {
    this.forbidden = forbidden;
    setForbiddenIsSet(true);
    return this;
  }

  public void unsetForbidden() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __FORBIDDEN_ISSET_ID);
  }

  /** Returns true if field forbidden is set (has been assigned a value) and false otherwise */
  public boolean isSetForbidden() {
    return EncodingUtils.testBit(__isset_bitfield, __FORBIDDEN_ISSET_ID);
  }

  public void setForbiddenIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __FORBIDDEN_ISSET_ID, value);
  }

  public long getMainTradeAccountId() {
    return this.mainTradeAccountId;
  }

  public HostingOrderRouteRelatedInfo setMainTradeAccountId(long mainTradeAccountId) {
    this.mainTradeAccountId = mainTradeAccountId;
    setMainTradeAccountIdIsSet(true);
    return this;
  }

  public void unsetMainTradeAccountId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __MAINTRADEACCOUNTID_ISSET_ID);
  }

  /** Returns true if field mainTradeAccountId is set (has been assigned a value) and false otherwise */
  public boolean isSetMainTradeAccountId() {
    return EncodingUtils.testBit(__isset_bitfield, __MAINTRADEACCOUNTID_ISSET_ID);
  }

  public void setMainTradeAccountIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __MAINTRADEACCOUNTID_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case FORBIDDEN:
      if (value == null) {
        unsetForbidden();
      } else {
        setForbidden((Boolean)value);
      }
      break;

    case MAIN_TRADE_ACCOUNT_ID:
      if (value == null) {
        unsetMainTradeAccountId();
      } else {
        setMainTradeAccountId((Long)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case FORBIDDEN:
      return Boolean.valueOf(isForbidden());

    case MAIN_TRADE_ACCOUNT_ID:
      return Long.valueOf(getMainTradeAccountId());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case FORBIDDEN:
      return isSetForbidden();
    case MAIN_TRADE_ACCOUNT_ID:
      return isSetMainTradeAccountId();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof HostingOrderRouteRelatedInfo)
      return this.equals((HostingOrderRouteRelatedInfo)that);
    return false;
  }

  public boolean equals(HostingOrderRouteRelatedInfo that) {
    if (that == null)
      return false;

    boolean this_present_forbidden = true && this.isSetForbidden();
    boolean that_present_forbidden = true && that.isSetForbidden();
    if (this_present_forbidden || that_present_forbidden) {
      if (!(this_present_forbidden && that_present_forbidden))
        return false;
      if (this.forbidden != that.forbidden)
        return false;
    }

    boolean this_present_mainTradeAccountId = true && this.isSetMainTradeAccountId();
    boolean that_present_mainTradeAccountId = true && that.isSetMainTradeAccountId();
    if (this_present_mainTradeAccountId || that_present_mainTradeAccountId) {
      if (!(this_present_mainTradeAccountId && that_present_mainTradeAccountId))
        return false;
      if (this.mainTradeAccountId != that.mainTradeAccountId)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(HostingOrderRouteRelatedInfo other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetForbidden()).compareTo(other.isSetForbidden());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetForbidden()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.forbidden, other.forbidden);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetMainTradeAccountId()).compareTo(other.isSetMainTradeAccountId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMainTradeAccountId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.mainTradeAccountId, other.mainTradeAccountId);
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
    StringBuilder sb = new StringBuilder("HostingOrderRouteRelatedInfo(");
    boolean first = true;

    if (isSetForbidden()) {
      sb.append("forbidden:");
      sb.append(this.forbidden);
      first = false;
    }
    if (isSetMainTradeAccountId()) {
      if (!first) sb.append(", ");
      sb.append("mainTradeAccountId:");
      sb.append(this.mainTradeAccountId);
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
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class HostingOrderRouteRelatedInfoStandardSchemeFactory implements SchemeFactory {
    public HostingOrderRouteRelatedInfoStandardScheme getScheme() {
      return new HostingOrderRouteRelatedInfoStandardScheme();
    }
  }

  private static class HostingOrderRouteRelatedInfoStandardScheme extends StandardScheme<HostingOrderRouteRelatedInfo> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, HostingOrderRouteRelatedInfo struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // FORBIDDEN
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.forbidden = iprot.readBool();
              struct.setForbiddenIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // MAIN_TRADE_ACCOUNT_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.mainTradeAccountId = iprot.readI64();
              struct.setMainTradeAccountIdIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, HostingOrderRouteRelatedInfo struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.isSetForbidden()) {
        oprot.writeFieldBegin(FORBIDDEN_FIELD_DESC);
        oprot.writeBool(struct.forbidden);
        oprot.writeFieldEnd();
      }
      if (struct.isSetMainTradeAccountId()) {
        oprot.writeFieldBegin(MAIN_TRADE_ACCOUNT_ID_FIELD_DESC);
        oprot.writeI64(struct.mainTradeAccountId);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class HostingOrderRouteRelatedInfoTupleSchemeFactory implements SchemeFactory {
    public HostingOrderRouteRelatedInfoTupleScheme getScheme() {
      return new HostingOrderRouteRelatedInfoTupleScheme();
    }
  }

  private static class HostingOrderRouteRelatedInfoTupleScheme extends TupleScheme<HostingOrderRouteRelatedInfo> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, HostingOrderRouteRelatedInfo struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetForbidden()) {
        optionals.set(0);
      }
      if (struct.isSetMainTradeAccountId()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetForbidden()) {
        oprot.writeBool(struct.forbidden);
      }
      if (struct.isSetMainTradeAccountId()) {
        oprot.writeI64(struct.mainTradeAccountId);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, HostingOrderRouteRelatedInfo struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.forbidden = iprot.readBool();
        struct.setForbiddenIsSet(true);
      }
      if (incoming.get(1)) {
        struct.mainTradeAccountId = iprot.readI64();
        struct.setMainTradeAccountIdIsSet(true);
      }
    }
  }

}

