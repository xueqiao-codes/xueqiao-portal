/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.longsheng.xueqiao.contract.quotation.source.thriftapi;

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
 * 商品订阅额度
 */
public class CommoditySubscribeQuota implements org.apache.thrift.TBase<CommoditySubscribeQuota, CommoditySubscribeQuota._Fields>, java.io.Serializable, Cloneable, Comparable<CommoditySubscribeQuota> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("CommoditySubscribeQuota");

  private static final org.apache.thrift.protocol.TField COMMODITY_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("commodityId", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField MAX_CONTRACT_COUNT_FIELD_DESC = new org.apache.thrift.protocol.TField("maxContractCount", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField SLED_CONTRACT_IDS_FIELD_DESC = new org.apache.thrift.protocol.TField("sledContractIds", org.apache.thrift.protocol.TType.SET, (short)3);
  private static final org.apache.thrift.protocol.TField CREATE_TIMESTAMP_FIELD_DESC = new org.apache.thrift.protocol.TField("createTimestamp", org.apache.thrift.protocol.TType.I64, (short)21);
  private static final org.apache.thrift.protocol.TField LAST_MODIFY_TIMESTAMP_FIELD_DESC = new org.apache.thrift.protocol.TField("lastModifyTimestamp", org.apache.thrift.protocol.TType.I64, (short)22);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new CommoditySubscribeQuotaStandardSchemeFactory());
    schemes.put(TupleScheme.class, new CommoditySubscribeQuotaTupleSchemeFactory());
  }

  public int commodityId; // optional
  public int maxContractCount; // optional
  public Set<Integer> sledContractIds; // optional
  public long createTimestamp; // optional
  public long lastModifyTimestamp; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    COMMODITY_ID((short)1, "commodityId"),
    MAX_CONTRACT_COUNT((short)2, "maxContractCount"),
    SLED_CONTRACT_IDS((short)3, "sledContractIds"),
    CREATE_TIMESTAMP((short)21, "createTimestamp"),
    LAST_MODIFY_TIMESTAMP((short)22, "lastModifyTimestamp");

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
        case 1: // COMMODITY_ID
          return COMMODITY_ID;
        case 2: // MAX_CONTRACT_COUNT
          return MAX_CONTRACT_COUNT;
        case 3: // SLED_CONTRACT_IDS
          return SLED_CONTRACT_IDS;
        case 21: // CREATE_TIMESTAMP
          return CREATE_TIMESTAMP;
        case 22: // LAST_MODIFY_TIMESTAMP
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
  private static final int __COMMODITYID_ISSET_ID = 0;
  private static final int __MAXCONTRACTCOUNT_ISSET_ID = 1;
  private static final int __CREATETIMESTAMP_ISSET_ID = 2;
  private static final int __LASTMODIFYTIMESTAMP_ISSET_ID = 3;
  private byte __isset_bitfield = 0;
  private _Fields optionals[] = {_Fields.COMMODITY_ID,_Fields.MAX_CONTRACT_COUNT,_Fields.SLED_CONTRACT_IDS,_Fields.CREATE_TIMESTAMP,_Fields.LAST_MODIFY_TIMESTAMP};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.COMMODITY_ID, new org.apache.thrift.meta_data.FieldMetaData("commodityId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.MAX_CONTRACT_COUNT, new org.apache.thrift.meta_data.FieldMetaData("maxContractCount", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.SLED_CONTRACT_IDS, new org.apache.thrift.meta_data.FieldMetaData("sledContractIds", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.SetMetaData(org.apache.thrift.protocol.TType.SET, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32))));
    tmpMap.put(_Fields.CREATE_TIMESTAMP, new org.apache.thrift.meta_data.FieldMetaData("createTimestamp", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.LAST_MODIFY_TIMESTAMP, new org.apache.thrift.meta_data.FieldMetaData("lastModifyTimestamp", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(CommoditySubscribeQuota.class, metaDataMap);
  }

  public CommoditySubscribeQuota() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public CommoditySubscribeQuota(CommoditySubscribeQuota other) {
    __isset_bitfield = other.__isset_bitfield;
    this.commodityId = other.commodityId;
    this.maxContractCount = other.maxContractCount;
    if (other.isSetSledContractIds()) {
      Set<Integer> __this__sledContractIds = new HashSet<Integer>(other.sledContractIds);
      this.sledContractIds = __this__sledContractIds;
    }
    this.createTimestamp = other.createTimestamp;
    this.lastModifyTimestamp = other.lastModifyTimestamp;
  }

  public CommoditySubscribeQuota deepCopy() {
    return new CommoditySubscribeQuota(this);
  }

  @Override
  public void clear() {
    setCommodityIdIsSet(false);
    this.commodityId = 0;
    setMaxContractCountIsSet(false);
    this.maxContractCount = 0;
    this.sledContractIds = null;
    setCreateTimestampIsSet(false);
    this.createTimestamp = 0;
    setLastModifyTimestampIsSet(false);
    this.lastModifyTimestamp = 0;
  }

  public int getCommodityId() {
    return this.commodityId;
  }

  public CommoditySubscribeQuota setCommodityId(int commodityId) {
    this.commodityId = commodityId;
    setCommodityIdIsSet(true);
    return this;
  }

  public void unsetCommodityId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __COMMODITYID_ISSET_ID);
  }

  /** Returns true if field commodityId is set (has been assigned a value) and false otherwise */
  public boolean isSetCommodityId() {
    return EncodingUtils.testBit(__isset_bitfield, __COMMODITYID_ISSET_ID);
  }

  public void setCommodityIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __COMMODITYID_ISSET_ID, value);
  }

  public int getMaxContractCount() {
    return this.maxContractCount;
  }

  public CommoditySubscribeQuota setMaxContractCount(int maxContractCount) {
    this.maxContractCount = maxContractCount;
    setMaxContractCountIsSet(true);
    return this;
  }

  public void unsetMaxContractCount() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __MAXCONTRACTCOUNT_ISSET_ID);
  }

  /** Returns true if field maxContractCount is set (has been assigned a value) and false otherwise */
  public boolean isSetMaxContractCount() {
    return EncodingUtils.testBit(__isset_bitfield, __MAXCONTRACTCOUNT_ISSET_ID);
  }

  public void setMaxContractCountIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __MAXCONTRACTCOUNT_ISSET_ID, value);
  }

  public int getSledContractIdsSize() {
    return (this.sledContractIds == null) ? 0 : this.sledContractIds.size();
  }

  public java.util.Iterator<Integer> getSledContractIdsIterator() {
    return (this.sledContractIds == null) ? null : this.sledContractIds.iterator();
  }

  public void addToSledContractIds(int elem) {
    if (this.sledContractIds == null) {
      this.sledContractIds = new HashSet<Integer>();
    }
    this.sledContractIds.add(elem);
  }

  public Set<Integer> getSledContractIds() {
    return this.sledContractIds;
  }

  public CommoditySubscribeQuota setSledContractIds(Set<Integer> sledContractIds) {
    this.sledContractIds = sledContractIds;
    return this;
  }

  public void unsetSledContractIds() {
    this.sledContractIds = null;
  }

  /** Returns true if field sledContractIds is set (has been assigned a value) and false otherwise */
  public boolean isSetSledContractIds() {
    return this.sledContractIds != null;
  }

  public void setSledContractIdsIsSet(boolean value) {
    if (!value) {
      this.sledContractIds = null;
    }
  }

  public long getCreateTimestamp() {
    return this.createTimestamp;
  }

  public CommoditySubscribeQuota setCreateTimestamp(long createTimestamp) {
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

  public CommoditySubscribeQuota setLastModifyTimestamp(long lastModifyTimestamp) {
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
    case COMMODITY_ID:
      if (value == null) {
        unsetCommodityId();
      } else {
        setCommodityId((Integer)value);
      }
      break;

    case MAX_CONTRACT_COUNT:
      if (value == null) {
        unsetMaxContractCount();
      } else {
        setMaxContractCount((Integer)value);
      }
      break;

    case SLED_CONTRACT_IDS:
      if (value == null) {
        unsetSledContractIds();
      } else {
        setSledContractIds((Set<Integer>)value);
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
    case COMMODITY_ID:
      return Integer.valueOf(getCommodityId());

    case MAX_CONTRACT_COUNT:
      return Integer.valueOf(getMaxContractCount());

    case SLED_CONTRACT_IDS:
      return getSledContractIds();

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
    case COMMODITY_ID:
      return isSetCommodityId();
    case MAX_CONTRACT_COUNT:
      return isSetMaxContractCount();
    case SLED_CONTRACT_IDS:
      return isSetSledContractIds();
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
    if (that instanceof CommoditySubscribeQuota)
      return this.equals((CommoditySubscribeQuota)that);
    return false;
  }

  public boolean equals(CommoditySubscribeQuota that) {
    if (that == null)
      return false;

    boolean this_present_commodityId = true && this.isSetCommodityId();
    boolean that_present_commodityId = true && that.isSetCommodityId();
    if (this_present_commodityId || that_present_commodityId) {
      if (!(this_present_commodityId && that_present_commodityId))
        return false;
      if (this.commodityId != that.commodityId)
        return false;
    }

    boolean this_present_maxContractCount = true && this.isSetMaxContractCount();
    boolean that_present_maxContractCount = true && that.isSetMaxContractCount();
    if (this_present_maxContractCount || that_present_maxContractCount) {
      if (!(this_present_maxContractCount && that_present_maxContractCount))
        return false;
      if (this.maxContractCount != that.maxContractCount)
        return false;
    }

    boolean this_present_sledContractIds = true && this.isSetSledContractIds();
    boolean that_present_sledContractIds = true && that.isSetSledContractIds();
    if (this_present_sledContractIds || that_present_sledContractIds) {
      if (!(this_present_sledContractIds && that_present_sledContractIds))
        return false;
      if (!this.sledContractIds.equals(that.sledContractIds))
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
  public int compareTo(CommoditySubscribeQuota other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetCommodityId()).compareTo(other.isSetCommodityId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCommodityId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.commodityId, other.commodityId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetMaxContractCount()).compareTo(other.isSetMaxContractCount());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMaxContractCount()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.maxContractCount, other.maxContractCount);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSledContractIds()).compareTo(other.isSetSledContractIds());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSledContractIds()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sledContractIds, other.sledContractIds);
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
    StringBuilder sb = new StringBuilder("CommoditySubscribeQuota(");
    boolean first = true;

    if (isSetCommodityId()) {
      sb.append("commodityId:");
      sb.append(this.commodityId);
      first = false;
    }
    if (isSetMaxContractCount()) {
      if (!first) sb.append(", ");
      sb.append("maxContractCount:");
      sb.append(this.maxContractCount);
      first = false;
    }
    if (isSetSledContractIds()) {
      if (!first) sb.append(", ");
      sb.append("sledContractIds:");
      if (this.sledContractIds == null) {
        sb.append("null");
      } else {
        sb.append(this.sledContractIds);
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

  private static class CommoditySubscribeQuotaStandardSchemeFactory implements SchemeFactory {
    public CommoditySubscribeQuotaStandardScheme getScheme() {
      return new CommoditySubscribeQuotaStandardScheme();
    }
  }

  private static class CommoditySubscribeQuotaStandardScheme extends StandardScheme<CommoditySubscribeQuota> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, CommoditySubscribeQuota struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // COMMODITY_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.commodityId = iprot.readI32();
              struct.setCommodityIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // MAX_CONTRACT_COUNT
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.maxContractCount = iprot.readI32();
              struct.setMaxContractCountIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // SLED_CONTRACT_IDS
            if (schemeField.type == org.apache.thrift.protocol.TType.SET) {
              {
                org.apache.thrift.protocol.TSet _set36 = iprot.readSetBegin();
                struct.sledContractIds = new HashSet<Integer>(2*_set36.size);
                for (int _i37 = 0; _i37 < _set36.size; ++_i37)
                {
                  int _elem38;
                  _elem38 = iprot.readI32();
                  struct.sledContractIds.add(_elem38);
                }
                iprot.readSetEnd();
              }
              struct.setSledContractIdsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 21: // CREATE_TIMESTAMP
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.createTimestamp = iprot.readI64();
              struct.setCreateTimestampIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 22: // LAST_MODIFY_TIMESTAMP
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, CommoditySubscribeQuota struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.isSetCommodityId()) {
        oprot.writeFieldBegin(COMMODITY_ID_FIELD_DESC);
        oprot.writeI32(struct.commodityId);
        oprot.writeFieldEnd();
      }
      if (struct.isSetMaxContractCount()) {
        oprot.writeFieldBegin(MAX_CONTRACT_COUNT_FIELD_DESC);
        oprot.writeI32(struct.maxContractCount);
        oprot.writeFieldEnd();
      }
      if (struct.sledContractIds != null) {
        if (struct.isSetSledContractIds()) {
          oprot.writeFieldBegin(SLED_CONTRACT_IDS_FIELD_DESC);
          {
            oprot.writeSetBegin(new org.apache.thrift.protocol.TSet(org.apache.thrift.protocol.TType.I32, struct.sledContractIds.size()));
            for (int _iter39 : struct.sledContractIds)
            {
              oprot.writeI32(_iter39);
            }
            oprot.writeSetEnd();
          }
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

  private static class CommoditySubscribeQuotaTupleSchemeFactory implements SchemeFactory {
    public CommoditySubscribeQuotaTupleScheme getScheme() {
      return new CommoditySubscribeQuotaTupleScheme();
    }
  }

  private static class CommoditySubscribeQuotaTupleScheme extends TupleScheme<CommoditySubscribeQuota> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, CommoditySubscribeQuota struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetCommodityId()) {
        optionals.set(0);
      }
      if (struct.isSetMaxContractCount()) {
        optionals.set(1);
      }
      if (struct.isSetSledContractIds()) {
        optionals.set(2);
      }
      if (struct.isSetCreateTimestamp()) {
        optionals.set(3);
      }
      if (struct.isSetLastModifyTimestamp()) {
        optionals.set(4);
      }
      oprot.writeBitSet(optionals, 5);
      if (struct.isSetCommodityId()) {
        oprot.writeI32(struct.commodityId);
      }
      if (struct.isSetMaxContractCount()) {
        oprot.writeI32(struct.maxContractCount);
      }
      if (struct.isSetSledContractIds()) {
        {
          oprot.writeI32(struct.sledContractIds.size());
          for (int _iter40 : struct.sledContractIds)
          {
            oprot.writeI32(_iter40);
          }
        }
      }
      if (struct.isSetCreateTimestamp()) {
        oprot.writeI64(struct.createTimestamp);
      }
      if (struct.isSetLastModifyTimestamp()) {
        oprot.writeI64(struct.lastModifyTimestamp);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, CommoditySubscribeQuota struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(5);
      if (incoming.get(0)) {
        struct.commodityId = iprot.readI32();
        struct.setCommodityIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.maxContractCount = iprot.readI32();
        struct.setMaxContractCountIsSet(true);
      }
      if (incoming.get(2)) {
        {
          org.apache.thrift.protocol.TSet _set41 = new org.apache.thrift.protocol.TSet(org.apache.thrift.protocol.TType.I32, iprot.readI32());
          struct.sledContractIds = new HashSet<Integer>(2*_set41.size);
          for (int _i42 = 0; _i42 < _set41.size; ++_i42)
          {
            int _elem43;
            _elem43 = iprot.readI32();
            struct.sledContractIds.add(_elem43);
          }
        }
        struct.setSledContractIdsIsSet(true);
      }
      if (incoming.get(3)) {
        struct.createTimestamp = iprot.readI64();
        struct.setCreateTimestampIsSet(true);
      }
      if (incoming.get(4)) {
        struct.lastModifyTimestamp = iprot.readI64();
        struct.setLastModifyTimestampIsSet(true);
      }
    }
  }

}

