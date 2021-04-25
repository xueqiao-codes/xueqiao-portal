/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.longsheng.xueqiao.contract.thriftapi;

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

public class CommoditySource implements org.apache.thrift.TBase<CommoditySource, CommoditySource._Fields>, java.io.Serializable, Cloneable, Comparable<CommoditySource> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("CommoditySource");

  private static final org.apache.thrift.protocol.TField SOURCE_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("sourceId", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField EXCHANGE_MIC_FIELD_DESC = new org.apache.thrift.protocol.TField("exchangeMic", org.apache.thrift.protocol.TType.LIST, (short)2);
  private static final org.apache.thrift.protocol.TField TECH_PLATFORM_SOURCE_FIELD_DESC = new org.apache.thrift.protocol.TField("techPlatformSource", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField TECH_PLATFORM_ENV_FIELD_DESC = new org.apache.thrift.protocol.TField("techPlatformEnv", org.apache.thrift.protocol.TType.I32, (short)4);
  private static final org.apache.thrift.protocol.TField CREATE_TIMESTAMP_FIELD_DESC = new org.apache.thrift.protocol.TField("createTimestamp", org.apache.thrift.protocol.TType.I64, (short)25);
  private static final org.apache.thrift.protocol.TField LAST_MODIFY_TIMESTAMP_FIELD_DESC = new org.apache.thrift.protocol.TField("lastModifyTimestamp", org.apache.thrift.protocol.TType.I64, (short)26);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new CommoditySourceStandardSchemeFactory());
    schemes.put(TupleScheme.class, new CommoditySourceTupleSchemeFactory());
  }

  public int sourceId; // optional
  public List<String> exchangeMic; // optional
  /**
   * 
   * @see com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatform
   */
  public com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatform techPlatformSource; // optional
  /**
   * 
   * @see com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv
   */
  public com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv techPlatformEnv; // optional
  public long createTimestamp; // optional
  public long lastModifyTimestamp; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    SOURCE_ID((short)1, "sourceId"),
    EXCHANGE_MIC((short)2, "exchangeMic"),
    /**
     * 
     * @see com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatform
     */
    TECH_PLATFORM_SOURCE((short)3, "techPlatformSource"),
    /**
     * 
     * @see com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv
     */
    TECH_PLATFORM_ENV((short)4, "techPlatformEnv"),
    CREATE_TIMESTAMP((short)25, "createTimestamp"),
    LAST_MODIFY_TIMESTAMP((short)26, "lastModifyTimestamp");

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
        case 1: // SOURCE_ID
          return SOURCE_ID;
        case 2: // EXCHANGE_MIC
          return EXCHANGE_MIC;
        case 3: // TECH_PLATFORM_SOURCE
          return TECH_PLATFORM_SOURCE;
        case 4: // TECH_PLATFORM_ENV
          return TECH_PLATFORM_ENV;
        case 25: // CREATE_TIMESTAMP
          return CREATE_TIMESTAMP;
        case 26: // LAST_MODIFY_TIMESTAMP
          return LAST_MODIFY_TIMESTAMP;
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
  private static final int __SOURCEID_ISSET_ID = 0;
  private static final int __CREATETIMESTAMP_ISSET_ID = 1;
  private static final int __LASTMODIFYTIMESTAMP_ISSET_ID = 2;
  private byte __isset_bitfield = 0;
  private _Fields optionals[] = {_Fields.SOURCE_ID,_Fields.EXCHANGE_MIC,_Fields.TECH_PLATFORM_SOURCE,_Fields.TECH_PLATFORM_ENV,_Fields.CREATE_TIMESTAMP,_Fields.LAST_MODIFY_TIMESTAMP};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.SOURCE_ID, new org.apache.thrift.meta_data.FieldMetaData("sourceId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.EXCHANGE_MIC, new org.apache.thrift.meta_data.FieldMetaData("exchangeMic", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    tmpMap.put(_Fields.TECH_PLATFORM_SOURCE, new org.apache.thrift.meta_data.FieldMetaData("techPlatformSource", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatform.class)));
    tmpMap.put(_Fields.TECH_PLATFORM_ENV, new org.apache.thrift.meta_data.FieldMetaData("techPlatformEnv", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv.class)));
    tmpMap.put(_Fields.CREATE_TIMESTAMP, new org.apache.thrift.meta_data.FieldMetaData("createTimestamp", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.LAST_MODIFY_TIMESTAMP, new org.apache.thrift.meta_data.FieldMetaData("lastModifyTimestamp", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(CommoditySource.class, metaDataMap);
  }

  public CommoditySource() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public CommoditySource(CommoditySource other) {
    __isset_bitfield = other.__isset_bitfield;
    this.sourceId = other.sourceId;
    if (other.isSetExchangeMic()) {
      List<String> __this__exchangeMic = new ArrayList<String>(other.exchangeMic);
      this.exchangeMic = __this__exchangeMic;
    }
    if (other.isSetTechPlatformSource()) {
      this.techPlatformSource = other.techPlatformSource;
    }
    if (other.isSetTechPlatformEnv()) {
      this.techPlatformEnv = other.techPlatformEnv;
    }
    this.createTimestamp = other.createTimestamp;
    this.lastModifyTimestamp = other.lastModifyTimestamp;
  }

  public CommoditySource deepCopy() {
    return new CommoditySource(this);
  }

  @Override
  public void clear() {
    setSourceIdIsSet(false);
    this.sourceId = 0;
    this.exchangeMic = null;
    this.techPlatformSource = null;
    this.techPlatformEnv = null;
    setCreateTimestampIsSet(false);
    this.createTimestamp = 0;
    setLastModifyTimestampIsSet(false);
    this.lastModifyTimestamp = 0;
  }

  public int getSourceId() {
    return this.sourceId;
  }

  public CommoditySource setSourceId(int sourceId) {
    this.sourceId = sourceId;
    setSourceIdIsSet(true);
    return this;
  }

  public void unsetSourceId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __SOURCEID_ISSET_ID);
  }

  /** Returns true if field sourceId is set (has been assigned a value) and false otherwise */
  public boolean isSetSourceId() {
    return EncodingUtils.testBit(__isset_bitfield, __SOURCEID_ISSET_ID);
  }

  public void setSourceIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __SOURCEID_ISSET_ID, value);
  }

  public int getExchangeMicSize() {
    return (this.exchangeMic == null) ? 0 : this.exchangeMic.size();
  }

  public java.util.Iterator<String> getExchangeMicIterator() {
    return (this.exchangeMic == null) ? null : this.exchangeMic.iterator();
  }

  public void addToExchangeMic(String elem) {
    if (this.exchangeMic == null) {
      this.exchangeMic = new ArrayList<String>();
    }
    this.exchangeMic.add(elem);
  }

  public List<String> getExchangeMic() {
    return this.exchangeMic;
  }

  public CommoditySource setExchangeMic(List<String> exchangeMic) {
    this.exchangeMic = exchangeMic;
    return this;
  }

  public void unsetExchangeMic() {
    this.exchangeMic = null;
  }

  /** Returns true if field exchangeMic is set (has been assigned a value) and false otherwise */
  public boolean isSetExchangeMic() {
    return this.exchangeMic != null;
  }

  public void setExchangeMicIsSet(boolean value) {
    if (!value) {
      this.exchangeMic = null;
    }
  }

  /**
   * 
   * @see com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatform
   */
  public com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatform getTechPlatformSource() {
    return this.techPlatformSource;
  }

  /**
   * 
   * @see com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatform
   */
  public CommoditySource setTechPlatformSource(com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatform techPlatformSource) {
    this.techPlatformSource = techPlatformSource;
    return this;
  }

  public void unsetTechPlatformSource() {
    this.techPlatformSource = null;
  }

  /** Returns true if field techPlatformSource is set (has been assigned a value) and false otherwise */
  public boolean isSetTechPlatformSource() {
    return this.techPlatformSource != null;
  }

  public void setTechPlatformSourceIsSet(boolean value) {
    if (!value) {
      this.techPlatformSource = null;
    }
  }

  /**
   * 
   * @see com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv
   */
  public com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv getTechPlatformEnv() {
    return this.techPlatformEnv;
  }

  /**
   * 
   * @see com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv
   */
  public CommoditySource setTechPlatformEnv(com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv techPlatformEnv) {
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

  public long getCreateTimestamp() {
    return this.createTimestamp;
  }

  public CommoditySource setCreateTimestamp(long createTimestamp) {
    this.createTimestamp = createTimestamp;
    setCreateTimestampIsSet(true);
    return this;
  }

  public void unsetCreateTimestamp() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __CREATETIMESTAMP_ISSET_ID);
  }

  /** Returns true if field createTimestamp is set (has been assigned a value) and false otherwise */
  public boolean isSetCreateTimestamp() {
    return EncodingUtils.testBit(__isset_bitfield, __CREATETIMESTAMP_ISSET_ID);
  }

  public void setCreateTimestampIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __CREATETIMESTAMP_ISSET_ID, value);
  }

  public long getLastModifyTimestamp() {
    return this.lastModifyTimestamp;
  }

  public CommoditySource setLastModifyTimestamp(long lastModifyTimestamp) {
    this.lastModifyTimestamp = lastModifyTimestamp;
    setLastModifyTimestampIsSet(true);
    return this;
  }

  public void unsetLastModifyTimestamp() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __LASTMODIFYTIMESTAMP_ISSET_ID);
  }

  /** Returns true if field lastModifyTimestamp is set (has been assigned a value) and false otherwise */
  public boolean isSetLastModifyTimestamp() {
    return EncodingUtils.testBit(__isset_bitfield, __LASTMODIFYTIMESTAMP_ISSET_ID);
  }

  public void setLastModifyTimestampIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __LASTMODIFYTIMESTAMP_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case SOURCE_ID:
      if (value == null) {
        unsetSourceId();
      } else {
        setSourceId((Integer)value);
      }
      break;

    case EXCHANGE_MIC:
      if (value == null) {
        unsetExchangeMic();
      } else {
        setExchangeMic((List<String>)value);
      }
      break;

    case TECH_PLATFORM_SOURCE:
      if (value == null) {
        unsetTechPlatformSource();
      } else {
        setTechPlatformSource((com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatform)value);
      }
      break;

    case TECH_PLATFORM_ENV:
      if (value == null) {
        unsetTechPlatformEnv();
      } else {
        setTechPlatformEnv((com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv)value);
      }
      break;

    case CREATE_TIMESTAMP:
      if (value == null) {
        unsetCreateTimestamp();
      } else {
        setCreateTimestamp((Long)value);
      }
      break;

    case LAST_MODIFY_TIMESTAMP:
      if (value == null) {
        unsetLastModifyTimestamp();
      } else {
        setLastModifyTimestamp((Long)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case SOURCE_ID:
      return Integer.valueOf(getSourceId());

    case EXCHANGE_MIC:
      return getExchangeMic();

    case TECH_PLATFORM_SOURCE:
      return getTechPlatformSource();

    case TECH_PLATFORM_ENV:
      return getTechPlatformEnv();

    case CREATE_TIMESTAMP:
      return Long.valueOf(getCreateTimestamp());

    case LAST_MODIFY_TIMESTAMP:
      return Long.valueOf(getLastModifyTimestamp());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case SOURCE_ID:
      return isSetSourceId();
    case EXCHANGE_MIC:
      return isSetExchangeMic();
    case TECH_PLATFORM_SOURCE:
      return isSetTechPlatformSource();
    case TECH_PLATFORM_ENV:
      return isSetTechPlatformEnv();
    case CREATE_TIMESTAMP:
      return isSetCreateTimestamp();
    case LAST_MODIFY_TIMESTAMP:
      return isSetLastModifyTimestamp();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof CommoditySource)
      return this.equals((CommoditySource)that);
    return false;
  }

  public boolean equals(CommoditySource that) {
    if (that == null)
      return false;

    boolean this_present_sourceId = true && this.isSetSourceId();
    boolean that_present_sourceId = true && that.isSetSourceId();
    if (this_present_sourceId || that_present_sourceId) {
      if (!(this_present_sourceId && that_present_sourceId))
        return false;
      if (this.sourceId != that.sourceId)
        return false;
    }

    boolean this_present_exchangeMic = true && this.isSetExchangeMic();
    boolean that_present_exchangeMic = true && that.isSetExchangeMic();
    if (this_present_exchangeMic || that_present_exchangeMic) {
      if (!(this_present_exchangeMic && that_present_exchangeMic))
        return false;
      if (!this.exchangeMic.equals(that.exchangeMic))
        return false;
    }

    boolean this_present_techPlatformSource = true && this.isSetTechPlatformSource();
    boolean that_present_techPlatformSource = true && that.isSetTechPlatformSource();
    if (this_present_techPlatformSource || that_present_techPlatformSource) {
      if (!(this_present_techPlatformSource && that_present_techPlatformSource))
        return false;
      if (!this.techPlatformSource.equals(that.techPlatformSource))
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

    boolean this_present_createTimestamp = true && this.isSetCreateTimestamp();
    boolean that_present_createTimestamp = true && that.isSetCreateTimestamp();
    if (this_present_createTimestamp || that_present_createTimestamp) {
      if (!(this_present_createTimestamp && that_present_createTimestamp))
        return false;
      if (this.createTimestamp != that.createTimestamp)
        return false;
    }

    boolean this_present_lastModifyTimestamp = true && this.isSetLastModifyTimestamp();
    boolean that_present_lastModifyTimestamp = true && that.isSetLastModifyTimestamp();
    if (this_present_lastModifyTimestamp || that_present_lastModifyTimestamp) {
      if (!(this_present_lastModifyTimestamp && that_present_lastModifyTimestamp))
        return false;
      if (this.lastModifyTimestamp != that.lastModifyTimestamp)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(CommoditySource other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetSourceId()).compareTo(other.isSetSourceId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSourceId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sourceId, other.sourceId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetExchangeMic()).compareTo(other.isSetExchangeMic());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetExchangeMic()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.exchangeMic, other.exchangeMic);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTechPlatformSource()).compareTo(other.isSetTechPlatformSource());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTechPlatformSource()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.techPlatformSource, other.techPlatformSource);
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
    lastComparison = Boolean.valueOf(isSetCreateTimestamp()).compareTo(other.isSetCreateTimestamp());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCreateTimestamp()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.createTimestamp, other.createTimestamp);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetLastModifyTimestamp()).compareTo(other.isSetLastModifyTimestamp());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLastModifyTimestamp()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.lastModifyTimestamp, other.lastModifyTimestamp);
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
    StringBuilder sb = new StringBuilder("CommoditySource(");
    boolean first = true;

    if (isSetSourceId()) {
      sb.append("sourceId:");
      sb.append(this.sourceId);
      first = false;
    }
    if (isSetExchangeMic()) {
      if (!first) sb.append(", ");
      sb.append("exchangeMic:");
      if (this.exchangeMic == null) {
        sb.append("null");
      } else {
        sb.append(this.exchangeMic);
      }
      first = false;
    }
    if (isSetTechPlatformSource()) {
      if (!first) sb.append(", ");
      sb.append("techPlatformSource:");
      if (this.techPlatformSource == null) {
        sb.append("null");
      } else {
        sb.append(this.techPlatformSource);
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
    if (isSetCreateTimestamp()) {
      if (!first) sb.append(", ");
      sb.append("createTimestamp:");
      sb.append(this.createTimestamp);
      first = false;
    }
    if (isSetLastModifyTimestamp()) {
      if (!first) sb.append(", ");
      sb.append("lastModifyTimestamp:");
      sb.append(this.lastModifyTimestamp);
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

  private static class CommoditySourceStandardSchemeFactory implements SchemeFactory {
    public CommoditySourceStandardScheme getScheme() {
      return new CommoditySourceStandardScheme();
    }
  }

  private static class CommoditySourceStandardScheme extends StandardScheme<CommoditySource> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, CommoditySource struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // SOURCE_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.sourceId = iprot.readI32();
              struct.setSourceIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // EXCHANGE_MIC
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list752 = iprot.readListBegin();
                struct.exchangeMic = new ArrayList<String>(_list752.size);
                for (int _i753 = 0; _i753 < _list752.size; ++_i753)
                {
                  String _elem754;
                  _elem754 = iprot.readString();
                  struct.exchangeMic.add(_elem754);
                }
                iprot.readListEnd();
              }
              struct.setExchangeMicIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // TECH_PLATFORM_SOURCE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.techPlatformSource = com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatform.findByValue(iprot.readI32());
              struct.setTechPlatformSourceIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // TECH_PLATFORM_ENV
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.techPlatformEnv = com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv.findByValue(iprot.readI32());
              struct.setTechPlatformEnvIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 25: // CREATE_TIMESTAMP
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.createTimestamp = iprot.readI64();
              struct.setCreateTimestampIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 26: // LAST_MODIFY_TIMESTAMP
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.lastModifyTimestamp = iprot.readI64();
              struct.setLastModifyTimestampIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, CommoditySource struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.isSetSourceId()) {
        oprot.writeFieldBegin(SOURCE_ID_FIELD_DESC);
        oprot.writeI32(struct.sourceId);
        oprot.writeFieldEnd();
      }
      if (struct.exchangeMic != null) {
        if (struct.isSetExchangeMic()) {
          oprot.writeFieldBegin(EXCHANGE_MIC_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, struct.exchangeMic.size()));
            for (String _iter755 : struct.exchangeMic)
            {
              oprot.writeString(_iter755);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.techPlatformSource != null) {
        if (struct.isSetTechPlatformSource()) {
          oprot.writeFieldBegin(TECH_PLATFORM_SOURCE_FIELD_DESC);
          oprot.writeI32(struct.techPlatformSource.getValue());
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
      if (struct.isSetCreateTimestamp()) {
        oprot.writeFieldBegin(CREATE_TIMESTAMP_FIELD_DESC);
        oprot.writeI64(struct.createTimestamp);
        oprot.writeFieldEnd();
      }
      if (struct.isSetLastModifyTimestamp()) {
        oprot.writeFieldBegin(LAST_MODIFY_TIMESTAMP_FIELD_DESC);
        oprot.writeI64(struct.lastModifyTimestamp);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class CommoditySourceTupleSchemeFactory implements SchemeFactory {
    public CommoditySourceTupleScheme getScheme() {
      return new CommoditySourceTupleScheme();
    }
  }

  private static class CommoditySourceTupleScheme extends TupleScheme<CommoditySource> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, CommoditySource struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetSourceId()) {
        optionals.set(0);
      }
      if (struct.isSetExchangeMic()) {
        optionals.set(1);
      }
      if (struct.isSetTechPlatformSource()) {
        optionals.set(2);
      }
      if (struct.isSetTechPlatformEnv()) {
        optionals.set(3);
      }
      if (struct.isSetCreateTimestamp()) {
        optionals.set(4);
      }
      if (struct.isSetLastModifyTimestamp()) {
        optionals.set(5);
      }
      oprot.writeBitSet(optionals, 6);
      if (struct.isSetSourceId()) {
        oprot.writeI32(struct.sourceId);
      }
      if (struct.isSetExchangeMic()) {
        {
          oprot.writeI32(struct.exchangeMic.size());
          for (String _iter756 : struct.exchangeMic)
          {
            oprot.writeString(_iter756);
          }
        }
      }
      if (struct.isSetTechPlatformSource()) {
        oprot.writeI32(struct.techPlatformSource.getValue());
      }
      if (struct.isSetTechPlatformEnv()) {
        oprot.writeI32(struct.techPlatformEnv.getValue());
      }
      if (struct.isSetCreateTimestamp()) {
        oprot.writeI64(struct.createTimestamp);
      }
      if (struct.isSetLastModifyTimestamp()) {
        oprot.writeI64(struct.lastModifyTimestamp);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, CommoditySource struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(6);
      if (incoming.get(0)) {
        struct.sourceId = iprot.readI32();
        struct.setSourceIdIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TList _list757 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, iprot.readI32());
          struct.exchangeMic = new ArrayList<String>(_list757.size);
          for (int _i758 = 0; _i758 < _list757.size; ++_i758)
          {
            String _elem759;
            _elem759 = iprot.readString();
            struct.exchangeMic.add(_elem759);
          }
        }
        struct.setExchangeMicIsSet(true);
      }
      if (incoming.get(2)) {
        struct.techPlatformSource = com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatform.findByValue(iprot.readI32());
        struct.setTechPlatformSourceIsSet(true);
      }
      if (incoming.get(3)) {
        struct.techPlatformEnv = com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv.findByValue(iprot.readI32());
        struct.setTechPlatformEnvIsSet(true);
      }
      if (incoming.get(4)) {
        struct.createTimestamp = iprot.readI64();
        struct.setCreateTimestampIsSet(true);
      }
      if (incoming.get(5)) {
        struct.lastModifyTimestamp = iprot.readI64();
        struct.setLastModifyTimestampIsSet(true);
      }
    }
  }

}

