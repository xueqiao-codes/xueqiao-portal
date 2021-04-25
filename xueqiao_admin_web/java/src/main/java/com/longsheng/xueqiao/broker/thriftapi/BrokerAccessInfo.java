/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.longsheng.xueqiao.broker.thriftapi;

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

public class BrokerAccessInfo implements org.apache.thrift.TBase<BrokerAccessInfo, BrokerAccessInfo._Fields>, java.io.Serializable, Cloneable, Comparable<BrokerAccessInfo> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("BrokerAccessInfo");

  private static final org.apache.thrift.protocol.TField ENTRY_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("entryId", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField BROKER_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("brokerId", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField PLATFORM_FIELD_DESC = new org.apache.thrift.protocol.TField("platform", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField ENG_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("engName", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField CN_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("cnName", org.apache.thrift.protocol.TType.STRING, (short)5);
  private static final org.apache.thrift.protocol.TField NOTE_FIELD_DESC = new org.apache.thrift.protocol.TField("note", org.apache.thrift.protocol.TType.STRING, (short)6);
  private static final org.apache.thrift.protocol.TField TECH_PLATFORM_ENV_FIELD_DESC = new org.apache.thrift.protocol.TField("techPlatformEnv", org.apache.thrift.protocol.TType.I32, (short)10);
  private static final org.apache.thrift.protocol.TField ACCESS_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("accessName", org.apache.thrift.protocol.TType.STRING, (short)11);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new BrokerAccessInfoStandardSchemeFactory());
    schemes.put(TupleScheme.class, new BrokerAccessInfoTupleSchemeFactory());
  }

  public int entryId; // optional
  public int brokerId; // optional
  /**
   * 
   * @see com.longsheng.xueqiao.broker.thriftapi.BrokerPlatform
   */
  public com.longsheng.xueqiao.broker.thriftapi.BrokerPlatform platform; // optional
  public String engName; // optional
  public String cnName; // optional
  public String note; // optional
  /**
   * 
   * @see com.longsheng.xueqiao.broker.thriftapi.TechPlatformEnv
   */
  public com.longsheng.xueqiao.broker.thriftapi.TechPlatformEnv techPlatformEnv; // optional
  public String accessName; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ENTRY_ID((short)1, "entryId"),
    BROKER_ID((short)2, "brokerId"),
    /**
     * 
     * @see com.longsheng.xueqiao.broker.thriftapi.BrokerPlatform
     */
    PLATFORM((short)3, "platform"),
    ENG_NAME((short)4, "engName"),
    CN_NAME((short)5, "cnName"),
    NOTE((short)6, "note"),
    /**
     * 
     * @see com.longsheng.xueqiao.broker.thriftapi.TechPlatformEnv
     */
    TECH_PLATFORM_ENV((short)10, "techPlatformEnv"),
    ACCESS_NAME((short)11, "accessName");

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
        case 1: // ENTRY_ID
          return ENTRY_ID;
        case 2: // BROKER_ID
          return BROKER_ID;
        case 3: // PLATFORM
          return PLATFORM;
        case 4: // ENG_NAME
          return ENG_NAME;
        case 5: // CN_NAME
          return CN_NAME;
        case 6: // NOTE
          return NOTE;
        case 10: // TECH_PLATFORM_ENV
          return TECH_PLATFORM_ENV;
        case 11: // ACCESS_NAME
          return ACCESS_NAME;
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
  private static final int __ENTRYID_ISSET_ID = 0;
  private static final int __BROKERID_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  private _Fields optionals[] = {_Fields.ENTRY_ID,_Fields.BROKER_ID,_Fields.PLATFORM,_Fields.ENG_NAME,_Fields.CN_NAME,_Fields.NOTE,_Fields.TECH_PLATFORM_ENV,_Fields.ACCESS_NAME};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ENTRY_ID, new org.apache.thrift.meta_data.FieldMetaData("entryId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.BROKER_ID, new org.apache.thrift.meta_data.FieldMetaData("brokerId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.PLATFORM, new org.apache.thrift.meta_data.FieldMetaData("platform", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, com.longsheng.xueqiao.broker.thriftapi.BrokerPlatform.class)));
    tmpMap.put(_Fields.ENG_NAME, new org.apache.thrift.meta_data.FieldMetaData("engName", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.CN_NAME, new org.apache.thrift.meta_data.FieldMetaData("cnName", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.NOTE, new org.apache.thrift.meta_data.FieldMetaData("note", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.TECH_PLATFORM_ENV, new org.apache.thrift.meta_data.FieldMetaData("techPlatformEnv", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, com.longsheng.xueqiao.broker.thriftapi.TechPlatformEnv.class)));
    tmpMap.put(_Fields.ACCESS_NAME, new org.apache.thrift.meta_data.FieldMetaData("accessName", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(BrokerAccessInfo.class, metaDataMap);
  }

  public BrokerAccessInfo() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public BrokerAccessInfo(BrokerAccessInfo other) {
    __isset_bitfield = other.__isset_bitfield;
    this.entryId = other.entryId;
    this.brokerId = other.brokerId;
    if (other.isSetPlatform()) {
      this.platform = other.platform;
    }
    if (other.isSetEngName()) {
      this.engName = other.engName;
    }
    if (other.isSetCnName()) {
      this.cnName = other.cnName;
    }
    if (other.isSetNote()) {
      this.note = other.note;
    }
    if (other.isSetTechPlatformEnv()) {
      this.techPlatformEnv = other.techPlatformEnv;
    }
    if (other.isSetAccessName()) {
      this.accessName = other.accessName;
    }
  }

  public BrokerAccessInfo deepCopy() {
    return new BrokerAccessInfo(this);
  }

  @Override
  public void clear() {
    setEntryIdIsSet(false);
    this.entryId = 0;
    setBrokerIdIsSet(false);
    this.brokerId = 0;
    this.platform = null;
    this.engName = null;
    this.cnName = null;
    this.note = null;
    this.techPlatformEnv = null;
    this.accessName = null;
  }

  public int getEntryId() {
    return this.entryId;
  }

  public BrokerAccessInfo setEntryId(int entryId) {
    this.entryId = entryId;
    setEntryIdIsSet(true);
    return this;
  }

  public void unsetEntryId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ENTRYID_ISSET_ID);
  }

  /** Returns true if field entryId is set (has been assigned a value) and false otherwise */
  public boolean isSetEntryId() {
    return EncodingUtils.testBit(__isset_bitfield, __ENTRYID_ISSET_ID);
  }

  public void setEntryIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ENTRYID_ISSET_ID, value);
  }

  public int getBrokerId() {
    return this.brokerId;
  }

  public BrokerAccessInfo setBrokerId(int brokerId) {
    this.brokerId = brokerId;
    setBrokerIdIsSet(true);
    return this;
  }

  public void unsetBrokerId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __BROKERID_ISSET_ID);
  }

  /** Returns true if field brokerId is set (has been assigned a value) and false otherwise */
  public boolean isSetBrokerId() {
    return EncodingUtils.testBit(__isset_bitfield, __BROKERID_ISSET_ID);
  }

  public void setBrokerIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __BROKERID_ISSET_ID, value);
  }

  /**
   * 
   * @see com.longsheng.xueqiao.broker.thriftapi.BrokerPlatform
   */
  public com.longsheng.xueqiao.broker.thriftapi.BrokerPlatform getPlatform() {
    return this.platform;
  }

  /**
   * 
   * @see com.longsheng.xueqiao.broker.thriftapi.BrokerPlatform
   */
  public BrokerAccessInfo setPlatform(com.longsheng.xueqiao.broker.thriftapi.BrokerPlatform platform) {
    this.platform = platform;
    return this;
  }

  public void unsetPlatform() {
    this.platform = null;
  }

  /** Returns true if field platform is set (has been assigned a value) and false otherwise */
  public boolean isSetPlatform() {
    return this.platform != null;
  }

  public void setPlatformIsSet(boolean value) {
    if (!value) {
      this.platform = null;
    }
  }

  public String getEngName() {
    return this.engName;
  }

  public BrokerAccessInfo setEngName(String engName) {
    this.engName = engName;
    return this;
  }

  public void unsetEngName() {
    this.engName = null;
  }

  /** Returns true if field engName is set (has been assigned a value) and false otherwise */
  public boolean isSetEngName() {
    return this.engName != null;
  }

  public void setEngNameIsSet(boolean value) {
    if (!value) {
      this.engName = null;
    }
  }

  public String getCnName() {
    return this.cnName;
  }

  public BrokerAccessInfo setCnName(String cnName) {
    this.cnName = cnName;
    return this;
  }

  public void unsetCnName() {
    this.cnName = null;
  }

  /** Returns true if field cnName is set (has been assigned a value) and false otherwise */
  public boolean isSetCnName() {
    return this.cnName != null;
  }

  public void setCnNameIsSet(boolean value) {
    if (!value) {
      this.cnName = null;
    }
  }

  public String getNote() {
    return this.note;
  }

  public BrokerAccessInfo setNote(String note) {
    this.note = note;
    return this;
  }

  public void unsetNote() {
    this.note = null;
  }

  /** Returns true if field note is set (has been assigned a value) and false otherwise */
  public boolean isSetNote() {
    return this.note != null;
  }

  public void setNoteIsSet(boolean value) {
    if (!value) {
      this.note = null;
    }
  }

  /**
   * 
   * @see com.longsheng.xueqiao.broker.thriftapi.TechPlatformEnv
   */
  public com.longsheng.xueqiao.broker.thriftapi.TechPlatformEnv getTechPlatformEnv() {
    return this.techPlatformEnv;
  }

  /**
   * 
   * @see com.longsheng.xueqiao.broker.thriftapi.TechPlatformEnv
   */
  public BrokerAccessInfo setTechPlatformEnv(com.longsheng.xueqiao.broker.thriftapi.TechPlatformEnv techPlatformEnv) {
    this.techPlatformEnv = techPlatformEnv;
    return this;
  }

  public void unsetTechPlatformEnv() {
    this.techPlatformEnv = null;
  }

  /** Returns true if field techPlatformEnv is set (has been assigned a value) and false otherwise */
  public boolean isSetTechPlatformEnv() {
    return this.techPlatformEnv != null;
  }

  public void setTechPlatformEnvIsSet(boolean value) {
    if (!value) {
      this.techPlatformEnv = null;
    }
  }

  public String getAccessName() {
    return this.accessName;
  }

  public BrokerAccessInfo setAccessName(String accessName) {
    this.accessName = accessName;
    return this;
  }

  public void unsetAccessName() {
    this.accessName = null;
  }

  /** Returns true if field accessName is set (has been assigned a value) and false otherwise */
  public boolean isSetAccessName() {
    return this.accessName != null;
  }

  public void setAccessNameIsSet(boolean value) {
    if (!value) {
      this.accessName = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case ENTRY_ID:
      if (value == null) {
        unsetEntryId();
      } else {
        setEntryId((Integer)value);
      }
      break;

    case BROKER_ID:
      if (value == null) {
        unsetBrokerId();
      } else {
        setBrokerId((Integer)value);
      }
      break;

    case PLATFORM:
      if (value == null) {
        unsetPlatform();
      } else {
        setPlatform((com.longsheng.xueqiao.broker.thriftapi.BrokerPlatform)value);
      }
      break;

    case ENG_NAME:
      if (value == null) {
        unsetEngName();
      } else {
        setEngName((String)value);
      }
      break;

    case CN_NAME:
      if (value == null) {
        unsetCnName();
      } else {
        setCnName((String)value);
      }
      break;

    case NOTE:
      if (value == null) {
        unsetNote();
      } else {
        setNote((String)value);
      }
      break;

    case TECH_PLATFORM_ENV:
      if (value == null) {
        unsetTechPlatformEnv();
      } else {
        setTechPlatformEnv((com.longsheng.xueqiao.broker.thriftapi.TechPlatformEnv)value);
      }
      break;

    case ACCESS_NAME:
      if (value == null) {
        unsetAccessName();
      } else {
        setAccessName((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case ENTRY_ID:
      return Integer.valueOf(getEntryId());

    case BROKER_ID:
      return Integer.valueOf(getBrokerId());

    case PLATFORM:
      return getPlatform();

    case ENG_NAME:
      return getEngName();

    case CN_NAME:
      return getCnName();

    case NOTE:
      return getNote();

    case TECH_PLATFORM_ENV:
      return getTechPlatformEnv();

    case ACCESS_NAME:
      return getAccessName();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case ENTRY_ID:
      return isSetEntryId();
    case BROKER_ID:
      return isSetBrokerId();
    case PLATFORM:
      return isSetPlatform();
    case ENG_NAME:
      return isSetEngName();
    case CN_NAME:
      return isSetCnName();
    case NOTE:
      return isSetNote();
    case TECH_PLATFORM_ENV:
      return isSetTechPlatformEnv();
    case ACCESS_NAME:
      return isSetAccessName();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof BrokerAccessInfo)
      return this.equals((BrokerAccessInfo)that);
    return false;
  }

  public boolean equals(BrokerAccessInfo that) {
    if (that == null)
      return false;

    boolean this_present_entryId = true && this.isSetEntryId();
    boolean that_present_entryId = true && that.isSetEntryId();
    if (this_present_entryId || that_present_entryId) {
      if (!(this_present_entryId && that_present_entryId))
        return false;
      if (this.entryId != that.entryId)
        return false;
    }

    boolean this_present_brokerId = true && this.isSetBrokerId();
    boolean that_present_brokerId = true && that.isSetBrokerId();
    if (this_present_brokerId || that_present_brokerId) {
      if (!(this_present_brokerId && that_present_brokerId))
        return false;
      if (this.brokerId != that.brokerId)
        return false;
    }

    boolean this_present_platform = true && this.isSetPlatform();
    boolean that_present_platform = true && that.isSetPlatform();
    if (this_present_platform || that_present_platform) {
      if (!(this_present_platform && that_present_platform))
        return false;
      if (!this.platform.equals(that.platform))
        return false;
    }

    boolean this_present_engName = true && this.isSetEngName();
    boolean that_present_engName = true && that.isSetEngName();
    if (this_present_engName || that_present_engName) {
      if (!(this_present_engName && that_present_engName))
        return false;
      if (!this.engName.equals(that.engName))
        return false;
    }

    boolean this_present_cnName = true && this.isSetCnName();
    boolean that_present_cnName = true && that.isSetCnName();
    if (this_present_cnName || that_present_cnName) {
      if (!(this_present_cnName && that_present_cnName))
        return false;
      if (!this.cnName.equals(that.cnName))
        return false;
    }

    boolean this_present_note = true && this.isSetNote();
    boolean that_present_note = true && that.isSetNote();
    if (this_present_note || that_present_note) {
      if (!(this_present_note && that_present_note))
        return false;
      if (!this.note.equals(that.note))
        return false;
    }

    boolean this_present_techPlatformEnv = true && this.isSetTechPlatformEnv();
    boolean that_present_techPlatformEnv = true && that.isSetTechPlatformEnv();
    if (this_present_techPlatformEnv || that_present_techPlatformEnv) {
      if (!(this_present_techPlatformEnv && that_present_techPlatformEnv))
        return false;
      if (!this.techPlatformEnv.equals(that.techPlatformEnv))
        return false;
    }

    boolean this_present_accessName = true && this.isSetAccessName();
    boolean that_present_accessName = true && that.isSetAccessName();
    if (this_present_accessName || that_present_accessName) {
      if (!(this_present_accessName && that_present_accessName))
        return false;
      if (!this.accessName.equals(that.accessName))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(BrokerAccessInfo other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetEntryId()).compareTo(other.isSetEntryId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEntryId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.entryId, other.entryId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetBrokerId()).compareTo(other.isSetBrokerId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBrokerId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.brokerId, other.brokerId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPlatform()).compareTo(other.isSetPlatform());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPlatform()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.platform, other.platform);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetEngName()).compareTo(other.isSetEngName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEngName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.engName, other.engName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetCnName()).compareTo(other.isSetCnName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCnName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.cnName, other.cnName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetNote()).compareTo(other.isSetNote());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetNote()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.note, other.note);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTechPlatformEnv()).compareTo(other.isSetTechPlatformEnv());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTechPlatformEnv()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.techPlatformEnv, other.techPlatformEnv);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetAccessName()).compareTo(other.isSetAccessName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAccessName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.accessName, other.accessName);
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
    StringBuilder sb = new StringBuilder("BrokerAccessInfo(");
    boolean first = true;

    if (isSetEntryId()) {
      sb.append("entryId:");
      sb.append(this.entryId);
      first = false;
    }
    if (isSetBrokerId()) {
      if (!first) sb.append(", ");
      sb.append("brokerId:");
      sb.append(this.brokerId);
      first = false;
    }
    if (isSetPlatform()) {
      if (!first) sb.append(", ");
      sb.append("platform:");
      if (this.platform == null) {
        sb.append("null");
      } else {
        sb.append(this.platform);
      }
      first = false;
    }
    if (isSetEngName()) {
      if (!first) sb.append(", ");
      sb.append("engName:");
      if (this.engName == null) {
        sb.append("null");
      } else {
        sb.append(this.engName);
      }
      first = false;
    }
    if (isSetCnName()) {
      if (!first) sb.append(", ");
      sb.append("cnName:");
      if (this.cnName == null) {
        sb.append("null");
      } else {
        sb.append(this.cnName);
      }
      first = false;
    }
    if (isSetNote()) {
      if (!first) sb.append(", ");
      sb.append("note:");
      if (this.note == null) {
        sb.append("null");
      } else {
        sb.append(this.note);
      }
      first = false;
    }
    if (isSetTechPlatformEnv()) {
      if (!first) sb.append(", ");
      sb.append("techPlatformEnv:");
      if (this.techPlatformEnv == null) {
        sb.append("null");
      } else {
        sb.append(this.techPlatformEnv);
      }
      first = false;
    }
    if (isSetAccessName()) {
      if (!first) sb.append(", ");
      sb.append("accessName:");
      if (this.accessName == null) {
        sb.append("null");
      } else {
        sb.append(this.accessName);
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

  private static class BrokerAccessInfoStandardSchemeFactory implements SchemeFactory {
    public BrokerAccessInfoStandardScheme getScheme() {
      return new BrokerAccessInfoStandardScheme();
    }
  }

  private static class BrokerAccessInfoStandardScheme extends StandardScheme<BrokerAccessInfo> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, BrokerAccessInfo struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ENTRY_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.entryId = iprot.readI32();
              struct.setEntryIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // BROKER_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.brokerId = iprot.readI32();
              struct.setBrokerIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // PLATFORM
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.platform = com.longsheng.xueqiao.broker.thriftapi.BrokerPlatform.findByValue(iprot.readI32());
              struct.setPlatformIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // ENG_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.engName = iprot.readString();
              struct.setEngNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // CN_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.cnName = iprot.readString();
              struct.setCnNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // NOTE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.note = iprot.readString();
              struct.setNoteIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 10: // TECH_PLATFORM_ENV
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.techPlatformEnv = com.longsheng.xueqiao.broker.thriftapi.TechPlatformEnv.findByValue(iprot.readI32());
              struct.setTechPlatformEnvIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 11: // ACCESS_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.accessName = iprot.readString();
              struct.setAccessNameIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, BrokerAccessInfo struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.isSetEntryId()) {
        oprot.writeFieldBegin(ENTRY_ID_FIELD_DESC);
        oprot.writeI32(struct.entryId);
        oprot.writeFieldEnd();
      }
      if (struct.isSetBrokerId()) {
        oprot.writeFieldBegin(BROKER_ID_FIELD_DESC);
        oprot.writeI32(struct.brokerId);
        oprot.writeFieldEnd();
      }
      if (struct.platform != null) {
        if (struct.isSetPlatform()) {
          oprot.writeFieldBegin(PLATFORM_FIELD_DESC);
          oprot.writeI32(struct.platform.getValue());
          oprot.writeFieldEnd();
        }
      }
      if (struct.engName != null) {
        if (struct.isSetEngName()) {
          oprot.writeFieldBegin(ENG_NAME_FIELD_DESC);
          oprot.writeString(struct.engName);
          oprot.writeFieldEnd();
        }
      }
      if (struct.cnName != null) {
        if (struct.isSetCnName()) {
          oprot.writeFieldBegin(CN_NAME_FIELD_DESC);
          oprot.writeString(struct.cnName);
          oprot.writeFieldEnd();
        }
      }
      if (struct.note != null) {
        if (struct.isSetNote()) {
          oprot.writeFieldBegin(NOTE_FIELD_DESC);
          oprot.writeString(struct.note);
          oprot.writeFieldEnd();
        }
      }
      if (struct.techPlatformEnv != null) {
        if (struct.isSetTechPlatformEnv()) {
          oprot.writeFieldBegin(TECH_PLATFORM_ENV_FIELD_DESC);
          oprot.writeI32(struct.techPlatformEnv.getValue());
          oprot.writeFieldEnd();
        }
      }
      if (struct.accessName != null) {
        if (struct.isSetAccessName()) {
          oprot.writeFieldBegin(ACCESS_NAME_FIELD_DESC);
          oprot.writeString(struct.accessName);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class BrokerAccessInfoTupleSchemeFactory implements SchemeFactory {
    public BrokerAccessInfoTupleScheme getScheme() {
      return new BrokerAccessInfoTupleScheme();
    }
  }

  private static class BrokerAccessInfoTupleScheme extends TupleScheme<BrokerAccessInfo> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, BrokerAccessInfo struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetEntryId()) {
        optionals.set(0);
      }
      if (struct.isSetBrokerId()) {
        optionals.set(1);
      }
      if (struct.isSetPlatform()) {
        optionals.set(2);
      }
      if (struct.isSetEngName()) {
        optionals.set(3);
      }
      if (struct.isSetCnName()) {
        optionals.set(4);
      }
      if (struct.isSetNote()) {
        optionals.set(5);
      }
      if (struct.isSetTechPlatformEnv()) {
        optionals.set(6);
      }
      if (struct.isSetAccessName()) {
        optionals.set(7);
      }
      oprot.writeBitSet(optionals, 8);
      if (struct.isSetEntryId()) {
        oprot.writeI32(struct.entryId);
      }
      if (struct.isSetBrokerId()) {
        oprot.writeI32(struct.brokerId);
      }
      if (struct.isSetPlatform()) {
        oprot.writeI32(struct.platform.getValue());
      }
      if (struct.isSetEngName()) {
        oprot.writeString(struct.engName);
      }
      if (struct.isSetCnName()) {
        oprot.writeString(struct.cnName);
      }
      if (struct.isSetNote()) {
        oprot.writeString(struct.note);
      }
      if (struct.isSetTechPlatformEnv()) {
        oprot.writeI32(struct.techPlatformEnv.getValue());
      }
      if (struct.isSetAccessName()) {
        oprot.writeString(struct.accessName);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, BrokerAccessInfo struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(8);
      if (incoming.get(0)) {
        struct.entryId = iprot.readI32();
        struct.setEntryIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.brokerId = iprot.readI32();
        struct.setBrokerIdIsSet(true);
      }
      if (incoming.get(2)) {
        struct.platform = com.longsheng.xueqiao.broker.thriftapi.BrokerPlatform.findByValue(iprot.readI32());
        struct.setPlatformIsSet(true);
      }
      if (incoming.get(3)) {
        struct.engName = iprot.readString();
        struct.setEngNameIsSet(true);
      }
      if (incoming.get(4)) {
        struct.cnName = iprot.readString();
        struct.setCnNameIsSet(true);
      }
      if (incoming.get(5)) {
        struct.note = iprot.readString();
        struct.setNoteIsSet(true);
      }
      if (incoming.get(6)) {
        struct.techPlatformEnv = com.longsheng.xueqiao.broker.thriftapi.TechPlatformEnv.findByValue(iprot.readI32());
        struct.setTechPlatformEnvIsSet(true);
      }
      if (incoming.get(7)) {
        struct.accessName = iprot.readString();
        struct.setAccessNameIsSet(true);
      }
    }
  }

}

