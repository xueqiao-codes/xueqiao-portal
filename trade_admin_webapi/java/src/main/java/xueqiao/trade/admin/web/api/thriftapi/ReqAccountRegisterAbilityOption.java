/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package xueqiao.trade.admin.web.api.thriftapi;

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

public class ReqAccountRegisterAbilityOption implements org.apache.thrift.TBase<ReqAccountRegisterAbilityOption, ReqAccountRegisterAbilityOption._Fields>, java.io.Serializable, Cloneable, Comparable<ReqAccountRegisterAbilityOption> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ReqAccountRegisterAbilityOption");

  private static final org.apache.thrift.protocol.TField ACCOUNT_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("accountId", org.apache.thrift.protocol.TType.I64, (short)1);
  private static final org.apache.thrift.protocol.TField SLED_COMMODITY_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("sledCommodityId", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField SLED_EXCHANGE_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("sledExchangeId", org.apache.thrift.protocol.TType.I32, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new ReqAccountRegisterAbilityOptionStandardSchemeFactory());
    schemes.put(TupleScheme.class, new ReqAccountRegisterAbilityOptionTupleSchemeFactory());
  }

  public long accountId; // optional
  public int sledCommodityId; // optional
  public int sledExchangeId; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ACCOUNT_ID((short)1, "accountId"),
    SLED_COMMODITY_ID((short)2, "sledCommodityId"),
    SLED_EXCHANGE_ID((short)3, "sledExchangeId");

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
        case 1: // ACCOUNT_ID
          return ACCOUNT_ID;
        case 2: // SLED_COMMODITY_ID
          return SLED_COMMODITY_ID;
        case 3: // SLED_EXCHANGE_ID
          return SLED_EXCHANGE_ID;
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
  private static final int __ACCOUNTID_ISSET_ID = 0;
  private static final int __SLEDCOMMODITYID_ISSET_ID = 1;
  private static final int __SLEDEXCHANGEID_ISSET_ID = 2;
  private byte __isset_bitfield = 0;
  private _Fields optionals[] = {_Fields.ACCOUNT_ID,_Fields.SLED_COMMODITY_ID,_Fields.SLED_EXCHANGE_ID};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ACCOUNT_ID, new org.apache.thrift.meta_data.FieldMetaData("accountId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.SLED_COMMODITY_ID, new org.apache.thrift.meta_data.FieldMetaData("sledCommodityId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.SLED_EXCHANGE_ID, new org.apache.thrift.meta_data.FieldMetaData("sledExchangeId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ReqAccountRegisterAbilityOption.class, metaDataMap);
  }

  public ReqAccountRegisterAbilityOption() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ReqAccountRegisterAbilityOption(ReqAccountRegisterAbilityOption other) {
    __isset_bitfield = other.__isset_bitfield;
    this.accountId = other.accountId;
    this.sledCommodityId = other.sledCommodityId;
    this.sledExchangeId = other.sledExchangeId;
  }

  public ReqAccountRegisterAbilityOption deepCopy() {
    return new ReqAccountRegisterAbilityOption(this);
  }

  @Override
  public void clear() {
    setAccountIdIsSet(false);
    this.accountId = 0;
    setSledCommodityIdIsSet(false);
    this.sledCommodityId = 0;
    setSledExchangeIdIsSet(false);
    this.sledExchangeId = 0;
  }

  public long getAccountId() {
    return this.accountId;
  }

  public ReqAccountRegisterAbilityOption setAccountId(long accountId) {
    this.accountId = accountId;
    setAccountIdIsSet(true);
    return this;
  }

  public void unsetAccountId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ACCOUNTID_ISSET_ID);
  }

  /** Returns true if field accountId is set (has been assigned a value) and false otherwise */
  public boolean isSetAccountId() {
    return EncodingUtils.testBit(__isset_bitfield, __ACCOUNTID_ISSET_ID);
  }

  public void setAccountIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ACCOUNTID_ISSET_ID, value);
  }

  public int getSledCommodityId() {
    return this.sledCommodityId;
  }

  public ReqAccountRegisterAbilityOption setSledCommodityId(int sledCommodityId) {
    this.sledCommodityId = sledCommodityId;
    setSledCommodityIdIsSet(true);
    return this;
  }

  public void unsetSledCommodityId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __SLEDCOMMODITYID_ISSET_ID);
  }

  /** Returns true if field sledCommodityId is set (has been assigned a value) and false otherwise */
  public boolean isSetSledCommodityId() {
    return EncodingUtils.testBit(__isset_bitfield, __SLEDCOMMODITYID_ISSET_ID);
  }

  public void setSledCommodityIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __SLEDCOMMODITYID_ISSET_ID, value);
  }

  public int getSledExchangeId() {
    return this.sledExchangeId;
  }

  public ReqAccountRegisterAbilityOption setSledExchangeId(int sledExchangeId) {
    this.sledExchangeId = sledExchangeId;
    setSledExchangeIdIsSet(true);
    return this;
  }

  public void unsetSledExchangeId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __SLEDEXCHANGEID_ISSET_ID);
  }

  /** Returns true if field sledExchangeId is set (has been assigned a value) and false otherwise */
  public boolean isSetSledExchangeId() {
    return EncodingUtils.testBit(__isset_bitfield, __SLEDEXCHANGEID_ISSET_ID);
  }

  public void setSledExchangeIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __SLEDEXCHANGEID_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case ACCOUNT_ID:
      if (value == null) {
        unsetAccountId();
      } else {
        setAccountId((Long)value);
      }
      break;

    case SLED_COMMODITY_ID:
      if (value == null) {
        unsetSledCommodityId();
      } else {
        setSledCommodityId((Integer)value);
      }
      break;

    case SLED_EXCHANGE_ID:
      if (value == null) {
        unsetSledExchangeId();
      } else {
        setSledExchangeId((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case ACCOUNT_ID:
      return Long.valueOf(getAccountId());

    case SLED_COMMODITY_ID:
      return Integer.valueOf(getSledCommodityId());

    case SLED_EXCHANGE_ID:
      return Integer.valueOf(getSledExchangeId());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case ACCOUNT_ID:
      return isSetAccountId();
    case SLED_COMMODITY_ID:
      return isSetSledCommodityId();
    case SLED_EXCHANGE_ID:
      return isSetSledExchangeId();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ReqAccountRegisterAbilityOption)
      return this.equals((ReqAccountRegisterAbilityOption)that);
    return false;
  }

  public boolean equals(ReqAccountRegisterAbilityOption that) {
    if (that == null)
      return false;

    boolean this_present_accountId = true && this.isSetAccountId();
    boolean that_present_accountId = true && that.isSetAccountId();
    if (this_present_accountId || that_present_accountId) {
      if (!(this_present_accountId && that_present_accountId))
        return false;
      if (this.accountId != that.accountId)
        return false;
    }

    boolean this_present_sledCommodityId = true && this.isSetSledCommodityId();
    boolean that_present_sledCommodityId = true && that.isSetSledCommodityId();
    if (this_present_sledCommodityId || that_present_sledCommodityId) {
      if (!(this_present_sledCommodityId && that_present_sledCommodityId))
        return false;
      if (this.sledCommodityId != that.sledCommodityId)
        return false;
    }

    boolean this_present_sledExchangeId = true && this.isSetSledExchangeId();
    boolean that_present_sledExchangeId = true && that.isSetSledExchangeId();
    if (this_present_sledExchangeId || that_present_sledExchangeId) {
      if (!(this_present_sledExchangeId && that_present_sledExchangeId))
        return false;
      if (this.sledExchangeId != that.sledExchangeId)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(ReqAccountRegisterAbilityOption other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetAccountId()).compareTo(other.isSetAccountId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAccountId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.accountId, other.accountId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSledCommodityId()).compareTo(other.isSetSledCommodityId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSledCommodityId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sledCommodityId, other.sledCommodityId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSledExchangeId()).compareTo(other.isSetSledExchangeId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSledExchangeId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sledExchangeId, other.sledExchangeId);
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
    StringBuilder sb = new StringBuilder("ReqAccountRegisterAbilityOption(");
    boolean first = true;

    if (isSetAccountId()) {
      sb.append("accountId:");
      sb.append(this.accountId);
      first = false;
    }
    if (isSetSledCommodityId()) {
      if (!first) sb.append(", ");
      sb.append("sledCommodityId:");
      sb.append(this.sledCommodityId);
      first = false;
    }
    if (isSetSledExchangeId()) {
      if (!first) sb.append(", ");
      sb.append("sledExchangeId:");
      sb.append(this.sledExchangeId);
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

  private static class ReqAccountRegisterAbilityOptionStandardSchemeFactory implements SchemeFactory {
    public ReqAccountRegisterAbilityOptionStandardScheme getScheme() {
      return new ReqAccountRegisterAbilityOptionStandardScheme();
    }
  }

  private static class ReqAccountRegisterAbilityOptionStandardScheme extends StandardScheme<ReqAccountRegisterAbilityOption> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ReqAccountRegisterAbilityOption struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ACCOUNT_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.accountId = iprot.readI64();
              struct.setAccountIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // SLED_COMMODITY_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.sledCommodityId = iprot.readI32();
              struct.setSledCommodityIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // SLED_EXCHANGE_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.sledExchangeId = iprot.readI32();
              struct.setSledExchangeIdIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, ReqAccountRegisterAbilityOption struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.isSetAccountId()) {
        oprot.writeFieldBegin(ACCOUNT_ID_FIELD_DESC);
        oprot.writeI64(struct.accountId);
        oprot.writeFieldEnd();
      }
      if (struct.isSetSledCommodityId()) {
        oprot.writeFieldBegin(SLED_COMMODITY_ID_FIELD_DESC);
        oprot.writeI32(struct.sledCommodityId);
        oprot.writeFieldEnd();
      }
      if (struct.isSetSledExchangeId()) {
        oprot.writeFieldBegin(SLED_EXCHANGE_ID_FIELD_DESC);
        oprot.writeI32(struct.sledExchangeId);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ReqAccountRegisterAbilityOptionTupleSchemeFactory implements SchemeFactory {
    public ReqAccountRegisterAbilityOptionTupleScheme getScheme() {
      return new ReqAccountRegisterAbilityOptionTupleScheme();
    }
  }

  private static class ReqAccountRegisterAbilityOptionTupleScheme extends TupleScheme<ReqAccountRegisterAbilityOption> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ReqAccountRegisterAbilityOption struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetAccountId()) {
        optionals.set(0);
      }
      if (struct.isSetSledCommodityId()) {
        optionals.set(1);
      }
      if (struct.isSetSledExchangeId()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetAccountId()) {
        oprot.writeI64(struct.accountId);
      }
      if (struct.isSetSledCommodityId()) {
        oprot.writeI32(struct.sledCommodityId);
      }
      if (struct.isSetSledExchangeId()) {
        oprot.writeI32(struct.sledExchangeId);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ReqAccountRegisterAbilityOption struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.accountId = iprot.readI64();
        struct.setAccountIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.sledCommodityId = iprot.readI32();
        struct.setSledCommodityIdIsSet(true);
      }
      if (incoming.get(2)) {
        struct.sledExchangeId = iprot.readI32();
        struct.setSledExchangeIdIsSet(true);
      }
    }
  }

}

