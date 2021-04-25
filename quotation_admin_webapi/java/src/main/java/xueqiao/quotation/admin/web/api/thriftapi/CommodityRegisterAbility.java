/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package xueqiao.quotation.admin.web.api.thriftapi;

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

public class CommodityRegisterAbility implements org.apache.thrift.TBase<CommodityRegisterAbility, CommodityRegisterAbility._Fields>, java.io.Serializable, Cloneable, Comparable<CommodityRegisterAbility> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("CommodityRegisterAbility");

  private static final org.apache.thrift.protocol.TField REGISTER_ABILITY_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("registerAbilityId", org.apache.thrift.protocol.TType.I64, (short)1);
  private static final org.apache.thrift.protocol.TField ACCOUNT_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("accountId", org.apache.thrift.protocol.TType.I64, (short)2);
  private static final org.apache.thrift.protocol.TField SLED_COMMODITY_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("sledCommodityId", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField SLED_EXCHANGE_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("sledExchangeId", org.apache.thrift.protocol.TType.I32, (short)4);
  private static final org.apache.thrift.protocol.TField COMMODITY_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("commodityName", org.apache.thrift.protocol.TType.STRING, (short)6);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new CommodityRegisterAbilityStandardSchemeFactory());
    schemes.put(TupleScheme.class, new CommodityRegisterAbilityTupleSchemeFactory());
  }

  public long registerAbilityId; // optional
  public long accountId; // optional
  public int sledCommodityId; // optional
  public int sledExchangeId; // optional
  public String commodityName; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    REGISTER_ABILITY_ID((short)1, "registerAbilityId"),
    ACCOUNT_ID((short)2, "accountId"),
    SLED_COMMODITY_ID((short)3, "sledCommodityId"),
    SLED_EXCHANGE_ID((short)4, "sledExchangeId"),
    COMMODITY_NAME((short)6, "commodityName");

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
        case 1: // REGISTER_ABILITY_ID
          return REGISTER_ABILITY_ID;
        case 2: // ACCOUNT_ID
          return ACCOUNT_ID;
        case 3: // SLED_COMMODITY_ID
          return SLED_COMMODITY_ID;
        case 4: // SLED_EXCHANGE_ID
          return SLED_EXCHANGE_ID;
        case 6: // COMMODITY_NAME
          return COMMODITY_NAME;
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
  private static final int __REGISTERABILITYID_ISSET_ID = 0;
  private static final int __ACCOUNTID_ISSET_ID = 1;
  private static final int __SLEDCOMMODITYID_ISSET_ID = 2;
  private static final int __SLEDEXCHANGEID_ISSET_ID = 3;
  private byte __isset_bitfield = 0;
  private _Fields optionals[] = {_Fields.REGISTER_ABILITY_ID,_Fields.ACCOUNT_ID,_Fields.SLED_COMMODITY_ID,_Fields.SLED_EXCHANGE_ID,_Fields.COMMODITY_NAME};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.REGISTER_ABILITY_ID, new org.apache.thrift.meta_data.FieldMetaData("registerAbilityId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.ACCOUNT_ID, new org.apache.thrift.meta_data.FieldMetaData("accountId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.SLED_COMMODITY_ID, new org.apache.thrift.meta_data.FieldMetaData("sledCommodityId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.SLED_EXCHANGE_ID, new org.apache.thrift.meta_data.FieldMetaData("sledExchangeId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.COMMODITY_NAME, new org.apache.thrift.meta_data.FieldMetaData("commodityName", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(CommodityRegisterAbility.class, metaDataMap);
  }

  public CommodityRegisterAbility() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public CommodityRegisterAbility(CommodityRegisterAbility other) {
    __isset_bitfield = other.__isset_bitfield;
    this.registerAbilityId = other.registerAbilityId;
    this.accountId = other.accountId;
    this.sledCommodityId = other.sledCommodityId;
    this.sledExchangeId = other.sledExchangeId;
    if (other.isSetCommodityName()) {
      this.commodityName = other.commodityName;
    }
  }

  public CommodityRegisterAbility deepCopy() {
    return new CommodityRegisterAbility(this);
  }

  @Override
  public void clear() {
    setRegisterAbilityIdIsSet(false);
    this.registerAbilityId = 0;
    setAccountIdIsSet(false);
    this.accountId = 0;
    setSledCommodityIdIsSet(false);
    this.sledCommodityId = 0;
    setSledExchangeIdIsSet(false);
    this.sledExchangeId = 0;
    this.commodityName = null;
  }

  public long getRegisterAbilityId() {
    return this.registerAbilityId;
  }

  public CommodityRegisterAbility setRegisterAbilityId(long registerAbilityId) {
    this.registerAbilityId = registerAbilityId;
    setRegisterAbilityIdIsSet(true);
    return this;
  }

  public void unsetRegisterAbilityId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __REGISTERABILITYID_ISSET_ID);
  }

  /** Returns true if field registerAbilityId is set (has been assigned a value) and false otherwise */
  public boolean isSetRegisterAbilityId() {
    return EncodingUtils.testBit(__isset_bitfield, __REGISTERABILITYID_ISSET_ID);
  }

  public void setRegisterAbilityIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __REGISTERABILITYID_ISSET_ID, value);
  }

  public long getAccountId() {
    return this.accountId;
  }

  public CommodityRegisterAbility setAccountId(long accountId) {
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

  public CommodityRegisterAbility setSledCommodityId(int sledCommodityId) {
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

  public CommodityRegisterAbility setSledExchangeId(int sledExchangeId) {
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

  public String getCommodityName() {
    return this.commodityName;
  }

  public CommodityRegisterAbility setCommodityName(String commodityName) {
    this.commodityName = commodityName;
    return this;
  }

  public void unsetCommodityName() {
    this.commodityName = null;
  }

  /** Returns true if field commodityName is set (has been assigned a value) and false otherwise */
  public boolean isSetCommodityName() {
    return this.commodityName != null;
  }

  public void setCommodityNameIsSet(boolean value) {
    if (!value) {
      this.commodityName = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case REGISTER_ABILITY_ID:
      if (value == null) {
        unsetRegisterAbilityId();
      } else {
        setRegisterAbilityId((Long)value);
      }
      break;

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

    case COMMODITY_NAME:
      if (value == null) {
        unsetCommodityName();
      } else {
        setCommodityName((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case REGISTER_ABILITY_ID:
      return Long.valueOf(getRegisterAbilityId());

    case ACCOUNT_ID:
      return Long.valueOf(getAccountId());

    case SLED_COMMODITY_ID:
      return Integer.valueOf(getSledCommodityId());

    case SLED_EXCHANGE_ID:
      return Integer.valueOf(getSledExchangeId());

    case COMMODITY_NAME:
      return getCommodityName();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case REGISTER_ABILITY_ID:
      return isSetRegisterAbilityId();
    case ACCOUNT_ID:
      return isSetAccountId();
    case SLED_COMMODITY_ID:
      return isSetSledCommodityId();
    case SLED_EXCHANGE_ID:
      return isSetSledExchangeId();
    case COMMODITY_NAME:
      return isSetCommodityName();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof CommodityRegisterAbility)
      return this.equals((CommodityRegisterAbility)that);
    return false;
  }

  public boolean equals(CommodityRegisterAbility that) {
    if (that == null)
      return false;

    boolean this_present_registerAbilityId = true && this.isSetRegisterAbilityId();
    boolean that_present_registerAbilityId = true && that.isSetRegisterAbilityId();
    if (this_present_registerAbilityId || that_present_registerAbilityId) {
      if (!(this_present_registerAbilityId && that_present_registerAbilityId))
        return false;
      if (this.registerAbilityId != that.registerAbilityId)
        return false;
    }

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

    boolean this_present_commodityName = true && this.isSetCommodityName();
    boolean that_present_commodityName = true && that.isSetCommodityName();
    if (this_present_commodityName || that_present_commodityName) {
      if (!(this_present_commodityName && that_present_commodityName))
        return false;
      if (!this.commodityName.equals(that.commodityName))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(CommodityRegisterAbility other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetRegisterAbilityId()).compareTo(other.isSetRegisterAbilityId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRegisterAbilityId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.registerAbilityId, other.registerAbilityId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
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
    lastComparison = Boolean.valueOf(isSetCommodityName()).compareTo(other.isSetCommodityName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCommodityName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.commodityName, other.commodityName);
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
    StringBuilder sb = new StringBuilder("CommodityRegisterAbility(");
    boolean first = true;

    if (isSetRegisterAbilityId()) {
      sb.append("registerAbilityId:");
      sb.append(this.registerAbilityId);
      first = false;
    }
    if (isSetAccountId()) {
      if (!first) sb.append(", ");
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
    if (isSetCommodityName()) {
      if (!first) sb.append(", ");
      sb.append("commodityName:");
      if (this.commodityName == null) {
        sb.append("null");
      } else {
        sb.append(this.commodityName);
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
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class CommodityRegisterAbilityStandardSchemeFactory implements SchemeFactory {
    public CommodityRegisterAbilityStandardScheme getScheme() {
      return new CommodityRegisterAbilityStandardScheme();
    }
  }

  private static class CommodityRegisterAbilityStandardScheme extends StandardScheme<CommodityRegisterAbility> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, CommodityRegisterAbility struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // REGISTER_ABILITY_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.registerAbilityId = iprot.readI64();
              struct.setRegisterAbilityIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // ACCOUNT_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.accountId = iprot.readI64();
              struct.setAccountIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // SLED_COMMODITY_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.sledCommodityId = iprot.readI32();
              struct.setSledCommodityIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // SLED_EXCHANGE_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.sledExchangeId = iprot.readI32();
              struct.setSledExchangeIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // COMMODITY_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.commodityName = iprot.readString();
              struct.setCommodityNameIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, CommodityRegisterAbility struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.isSetRegisterAbilityId()) {
        oprot.writeFieldBegin(REGISTER_ABILITY_ID_FIELD_DESC);
        oprot.writeI64(struct.registerAbilityId);
        oprot.writeFieldEnd();
      }
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
      if (struct.commodityName != null) {
        if (struct.isSetCommodityName()) {
          oprot.writeFieldBegin(COMMODITY_NAME_FIELD_DESC);
          oprot.writeString(struct.commodityName);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class CommodityRegisterAbilityTupleSchemeFactory implements SchemeFactory {
    public CommodityRegisterAbilityTupleScheme getScheme() {
      return new CommodityRegisterAbilityTupleScheme();
    }
  }

  private static class CommodityRegisterAbilityTupleScheme extends TupleScheme<CommodityRegisterAbility> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, CommodityRegisterAbility struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetRegisterAbilityId()) {
        optionals.set(0);
      }
      if (struct.isSetAccountId()) {
        optionals.set(1);
      }
      if (struct.isSetSledCommodityId()) {
        optionals.set(2);
      }
      if (struct.isSetSledExchangeId()) {
        optionals.set(3);
      }
      if (struct.isSetCommodityName()) {
        optionals.set(4);
      }
      oprot.writeBitSet(optionals, 5);
      if (struct.isSetRegisterAbilityId()) {
        oprot.writeI64(struct.registerAbilityId);
      }
      if (struct.isSetAccountId()) {
        oprot.writeI64(struct.accountId);
      }
      if (struct.isSetSledCommodityId()) {
        oprot.writeI32(struct.sledCommodityId);
      }
      if (struct.isSetSledExchangeId()) {
        oprot.writeI32(struct.sledExchangeId);
      }
      if (struct.isSetCommodityName()) {
        oprot.writeString(struct.commodityName);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, CommodityRegisterAbility struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(5);
      if (incoming.get(0)) {
        struct.registerAbilityId = iprot.readI64();
        struct.setRegisterAbilityIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.accountId = iprot.readI64();
        struct.setAccountIdIsSet(true);
      }
      if (incoming.get(2)) {
        struct.sledCommodityId = iprot.readI32();
        struct.setSledCommodityIdIsSet(true);
      }
      if (incoming.get(3)) {
        struct.sledExchangeId = iprot.readI32();
        struct.setSledExchangeIdIsSet(true);
      }
      if (incoming.get(4)) {
        struct.commodityName = iprot.readString();
        struct.setCommodityNameIsSet(true);
      }
    }
  }

}

