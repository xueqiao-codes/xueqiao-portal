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
 * 行情账号关联商品的订阅信息(统计查询用)
 */
public class QuotationAccountRelatedCommoditySubscribe implements org.apache.thrift.TBase<QuotationAccountRelatedCommoditySubscribe, QuotationAccountRelatedCommoditySubscribe._Fields>, java.io.Serializable, Cloneable, Comparable<QuotationAccountRelatedCommoditySubscribe> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("QuotationAccountRelatedCommoditySubscribe");

  private static final org.apache.thrift.protocol.TField ACCOUNT_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("accountId", org.apache.thrift.protocol.TType.I64, (short)1);
  private static final org.apache.thrift.protocol.TField COMMODITY_IDS_FIELD_DESC = new org.apache.thrift.protocol.TField("commodityIds", org.apache.thrift.protocol.TType.SET, (short)2);
  private static final org.apache.thrift.protocol.TField SUBSCRIBED_CONTRACT_COUNT_FIELD_DESC = new org.apache.thrift.protocol.TField("subscribedContractCount", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField MAX_CONTRACT_COUNT_FIELD_DESC = new org.apache.thrift.protocol.TField("maxContractCount", org.apache.thrift.protocol.TType.I32, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new QuotationAccountRelatedCommoditySubscribeStandardSchemeFactory());
    schemes.put(TupleScheme.class, new QuotationAccountRelatedCommoditySubscribeTupleSchemeFactory());
  }

  public long accountId; // optional
  public Set<Integer> commodityIds; // optional
  public int subscribedContractCount; // optional
  public int maxContractCount; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ACCOUNT_ID((short)1, "accountId"),
    COMMODITY_IDS((short)2, "commodityIds"),
    SUBSCRIBED_CONTRACT_COUNT((short)3, "subscribedContractCount"),
    MAX_CONTRACT_COUNT((short)4, "maxContractCount");

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
        case 2: // COMMODITY_IDS
          return COMMODITY_IDS;
        case 3: // SUBSCRIBED_CONTRACT_COUNT
          return SUBSCRIBED_CONTRACT_COUNT;
        case 4: // MAX_CONTRACT_COUNT
          return MAX_CONTRACT_COUNT;
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
  private static final int __SUBSCRIBEDCONTRACTCOUNT_ISSET_ID = 1;
  private static final int __MAXCONTRACTCOUNT_ISSET_ID = 2;
  private byte __isset_bitfield = 0;
  private _Fields optionals[] = {_Fields.ACCOUNT_ID,_Fields.COMMODITY_IDS,_Fields.SUBSCRIBED_CONTRACT_COUNT,_Fields.MAX_CONTRACT_COUNT};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ACCOUNT_ID, new org.apache.thrift.meta_data.FieldMetaData("accountId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.COMMODITY_IDS, new org.apache.thrift.meta_data.FieldMetaData("commodityIds", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.SetMetaData(org.apache.thrift.protocol.TType.SET, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32))));
    tmpMap.put(_Fields.SUBSCRIBED_CONTRACT_COUNT, new org.apache.thrift.meta_data.FieldMetaData("subscribedContractCount", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.MAX_CONTRACT_COUNT, new org.apache.thrift.meta_data.FieldMetaData("maxContractCount", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(QuotationAccountRelatedCommoditySubscribe.class, metaDataMap);
  }

  public QuotationAccountRelatedCommoditySubscribe() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public QuotationAccountRelatedCommoditySubscribe(QuotationAccountRelatedCommoditySubscribe other) {
    __isset_bitfield = other.__isset_bitfield;
    this.accountId = other.accountId;
    if (other.isSetCommodityIds()) {
      Set<Integer> __this__commodityIds = new HashSet<Integer>(other.commodityIds);
      this.commodityIds = __this__commodityIds;
    }
    this.subscribedContractCount = other.subscribedContractCount;
    this.maxContractCount = other.maxContractCount;
  }

  public QuotationAccountRelatedCommoditySubscribe deepCopy() {
    return new QuotationAccountRelatedCommoditySubscribe(this);
  }

  @Override
  public void clear() {
    setAccountIdIsSet(false);
    this.accountId = 0;
    this.commodityIds = null;
    setSubscribedContractCountIsSet(false);
    this.subscribedContractCount = 0;
    setMaxContractCountIsSet(false);
    this.maxContractCount = 0;
  }

  public long getAccountId() {
    return this.accountId;
  }

  public QuotationAccountRelatedCommoditySubscribe setAccountId(long accountId) {
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

  public int getCommodityIdsSize() {
    return (this.commodityIds == null) ? 0 : this.commodityIds.size();
  }

  public java.util.Iterator<Integer> getCommodityIdsIterator() {
    return (this.commodityIds == null) ? null : this.commodityIds.iterator();
  }

  public void addToCommodityIds(int elem) {
    if (this.commodityIds == null) {
      this.commodityIds = new HashSet<Integer>();
    }
    this.commodityIds.add(elem);
  }

  public Set<Integer> getCommodityIds() {
    return this.commodityIds;
  }

  public QuotationAccountRelatedCommoditySubscribe setCommodityIds(Set<Integer> commodityIds) {
    this.commodityIds = commodityIds;
    return this;
  }

  public void unsetCommodityIds() {
    this.commodityIds = null;
  }

  /** Returns true if field commodityIds is set (has been assigned a value) and false otherwise */
  public boolean isSetCommodityIds() {
    return this.commodityIds != null;
  }

  public void setCommodityIdsIsSet(boolean value) {
    if (!value) {
      this.commodityIds = null;
    }
  }

  public int getSubscribedContractCount() {
    return this.subscribedContractCount;
  }

  public QuotationAccountRelatedCommoditySubscribe setSubscribedContractCount(int subscribedContractCount) {
    this.subscribedContractCount = subscribedContractCount;
    setSubscribedContractCountIsSet(true);
    return this;
  }

  public void unsetSubscribedContractCount() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __SUBSCRIBEDCONTRACTCOUNT_ISSET_ID);
  }

  /** Returns true if field subscribedContractCount is set (has been assigned a value) and false otherwise */
  public boolean isSetSubscribedContractCount() {
    return EncodingUtils.testBit(__isset_bitfield, __SUBSCRIBEDCONTRACTCOUNT_ISSET_ID);
  }

  public void setSubscribedContractCountIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __SUBSCRIBEDCONTRACTCOUNT_ISSET_ID, value);
  }

  public int getMaxContractCount() {
    return this.maxContractCount;
  }

  public QuotationAccountRelatedCommoditySubscribe setMaxContractCount(int maxContractCount) {
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

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case ACCOUNT_ID:
      if (value == null) {
        unsetAccountId();
      } else {
        setAccountId((Long)value);
      }
      break;

    case COMMODITY_IDS:
      if (value == null) {
        unsetCommodityIds();
      } else {
        setCommodityIds((Set<Integer>)value);
      }
      break;

    case SUBSCRIBED_CONTRACT_COUNT:
      if (value == null) {
        unsetSubscribedContractCount();
      } else {
        setSubscribedContractCount((Integer)value);
      }
      break;

    case MAX_CONTRACT_COUNT:
      if (value == null) {
        unsetMaxContractCount();
      } else {
        setMaxContractCount((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case ACCOUNT_ID:
      return Long.valueOf(getAccountId());

    case COMMODITY_IDS:
      return getCommodityIds();

    case SUBSCRIBED_CONTRACT_COUNT:
      return Integer.valueOf(getSubscribedContractCount());

    case MAX_CONTRACT_COUNT:
      return Integer.valueOf(getMaxContractCount());

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
    case COMMODITY_IDS:
      return isSetCommodityIds();
    case SUBSCRIBED_CONTRACT_COUNT:
      return isSetSubscribedContractCount();
    case MAX_CONTRACT_COUNT:
      return isSetMaxContractCount();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof QuotationAccountRelatedCommoditySubscribe)
      return this.equals((QuotationAccountRelatedCommoditySubscribe)that);
    return false;
  }

  public boolean equals(QuotationAccountRelatedCommoditySubscribe that) {
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

    boolean this_present_commodityIds = true && this.isSetCommodityIds();
    boolean that_present_commodityIds = true && that.isSetCommodityIds();
    if (this_present_commodityIds || that_present_commodityIds) {
      if (!(this_present_commodityIds && that_present_commodityIds))
        return false;
      if (!this.commodityIds.equals(that.commodityIds))
        return false;
    }

    boolean this_present_subscribedContractCount = true && this.isSetSubscribedContractCount();
    boolean that_present_subscribedContractCount = true && that.isSetSubscribedContractCount();
    if (this_present_subscribedContractCount || that_present_subscribedContractCount) {
      if (!(this_present_subscribedContractCount && that_present_subscribedContractCount))
        return false;
      if (this.subscribedContractCount != that.subscribedContractCount)
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

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(QuotationAccountRelatedCommoditySubscribe other) {
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
    lastComparison = Boolean.valueOf(isSetCommodityIds()).compareTo(other.isSetCommodityIds());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCommodityIds()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.commodityIds, other.commodityIds);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSubscribedContractCount()).compareTo(other.isSetSubscribedContractCount());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSubscribedContractCount()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.subscribedContractCount, other.subscribedContractCount);
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
    StringBuilder sb = new StringBuilder("QuotationAccountRelatedCommoditySubscribe(");
    boolean first = true;

    if (isSetAccountId()) {
      sb.append("accountId:");
      sb.append(this.accountId);
      first = false;
    }
    if (isSetCommodityIds()) {
      if (!first) sb.append(", ");
      sb.append("commodityIds:");
      if (this.commodityIds == null) {
        sb.append("null");
      } else {
        sb.append(this.commodityIds);
      }
      first = false;
    }
    if (isSetSubscribedContractCount()) {
      if (!first) sb.append(", ");
      sb.append("subscribedContractCount:");
      sb.append(this.subscribedContractCount);
      first = false;
    }
    if (isSetMaxContractCount()) {
      if (!first) sb.append(", ");
      sb.append("maxContractCount:");
      sb.append(this.maxContractCount);
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

  private static class QuotationAccountRelatedCommoditySubscribeStandardSchemeFactory implements SchemeFactory {
    public QuotationAccountRelatedCommoditySubscribeStandardScheme getScheme() {
      return new QuotationAccountRelatedCommoditySubscribeStandardScheme();
    }
  }

  private static class QuotationAccountRelatedCommoditySubscribeStandardScheme extends StandardScheme<QuotationAccountRelatedCommoditySubscribe> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, QuotationAccountRelatedCommoditySubscribe struct) throws org.apache.thrift.TException {
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
          case 2: // COMMODITY_IDS
            if (schemeField.type == org.apache.thrift.protocol.TType.SET) {
              {
                org.apache.thrift.protocol.TSet _set68 = iprot.readSetBegin();
                struct.commodityIds = new HashSet<Integer>(2*_set68.size);
                for (int _i69 = 0; _i69 < _set68.size; ++_i69)
                {
                  int _elem70;
                  _elem70 = iprot.readI32();
                  struct.commodityIds.add(_elem70);
                }
                iprot.readSetEnd();
              }
              struct.setCommodityIdsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // SUBSCRIBED_CONTRACT_COUNT
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.subscribedContractCount = iprot.readI32();
              struct.setSubscribedContractCountIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // MAX_CONTRACT_COUNT
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.maxContractCount = iprot.readI32();
              struct.setMaxContractCountIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, QuotationAccountRelatedCommoditySubscribe struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.isSetAccountId()) {
        oprot.writeFieldBegin(ACCOUNT_ID_FIELD_DESC);
        oprot.writeI64(struct.accountId);
        oprot.writeFieldEnd();
      }
      if (struct.commodityIds != null) {
        if (struct.isSetCommodityIds()) {
          oprot.writeFieldBegin(COMMODITY_IDS_FIELD_DESC);
          {
            oprot.writeSetBegin(new org.apache.thrift.protocol.TSet(org.apache.thrift.protocol.TType.I32, struct.commodityIds.size()));
            for (int _iter71 : struct.commodityIds)
            {
              oprot.writeI32(_iter71);
            }
            oprot.writeSetEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetSubscribedContractCount()) {
        oprot.writeFieldBegin(SUBSCRIBED_CONTRACT_COUNT_FIELD_DESC);
        oprot.writeI32(struct.subscribedContractCount);
        oprot.writeFieldEnd();
      }
      if (struct.isSetMaxContractCount()) {
        oprot.writeFieldBegin(MAX_CONTRACT_COUNT_FIELD_DESC);
        oprot.writeI32(struct.maxContractCount);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class QuotationAccountRelatedCommoditySubscribeTupleSchemeFactory implements SchemeFactory {
    public QuotationAccountRelatedCommoditySubscribeTupleScheme getScheme() {
      return new QuotationAccountRelatedCommoditySubscribeTupleScheme();
    }
  }

  private static class QuotationAccountRelatedCommoditySubscribeTupleScheme extends TupleScheme<QuotationAccountRelatedCommoditySubscribe> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, QuotationAccountRelatedCommoditySubscribe struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetAccountId()) {
        optionals.set(0);
      }
      if (struct.isSetCommodityIds()) {
        optionals.set(1);
      }
      if (struct.isSetSubscribedContractCount()) {
        optionals.set(2);
      }
      if (struct.isSetMaxContractCount()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetAccountId()) {
        oprot.writeI64(struct.accountId);
      }
      if (struct.isSetCommodityIds()) {
        {
          oprot.writeI32(struct.commodityIds.size());
          for (int _iter72 : struct.commodityIds)
          {
            oprot.writeI32(_iter72);
          }
        }
      }
      if (struct.isSetSubscribedContractCount()) {
        oprot.writeI32(struct.subscribedContractCount);
      }
      if (struct.isSetMaxContractCount()) {
        oprot.writeI32(struct.maxContractCount);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, QuotationAccountRelatedCommoditySubscribe struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.accountId = iprot.readI64();
        struct.setAccountIdIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TSet _set73 = new org.apache.thrift.protocol.TSet(org.apache.thrift.protocol.TType.I32, iprot.readI32());
          struct.commodityIds = new HashSet<Integer>(2*_set73.size);
          for (int _i74 = 0; _i74 < _set73.size; ++_i74)
          {
            int _elem75;
            _elem75 = iprot.readI32();
            struct.commodityIds.add(_elem75);
          }
        }
        struct.setCommodityIdsIsSet(true);
      }
      if (incoming.get(2)) {
        struct.subscribedContractCount = iprot.readI32();
        struct.setSubscribedContractCountIsSet(true);
      }
      if (incoming.get(3)) {
        struct.maxContractCount = iprot.readI32();
        struct.setMaxContractCountIsSet(true);
      }
    }
  }

}
