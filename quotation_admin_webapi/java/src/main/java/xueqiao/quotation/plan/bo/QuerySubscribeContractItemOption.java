/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package xueqiao.quotation.plan.bo;

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

public class QuerySubscribeContractItemOption implements org.apache.thrift.TBase<QuerySubscribeContractItemOption, QuerySubscribeContractItemOption._Fields>, java.io.Serializable, Cloneable, Comparable<QuerySubscribeContractItemOption> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("QuerySubscribeContractItemOption");

  private static final org.apache.thrift.protocol.TField QUOTATION_ACCOUNT_IDS_FIELD_DESC = new org.apache.thrift.protocol.TField("quotationAccountIds", org.apache.thrift.protocol.TType.SET, (short)1);
  private static final org.apache.thrift.protocol.TField SLED_COMMODITY_IDS_FIELD_DESC = new org.apache.thrift.protocol.TField("sledCommodityIds", org.apache.thrift.protocol.TType.SET, (short)2);
  private static final org.apache.thrift.protocol.TField PLATFORM_ENV_FIELD_DESC = new org.apache.thrift.protocol.TField("platformEnv", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField QUOTATION_DEPLOY_SET_FIELD_DESC = new org.apache.thrift.protocol.TField("quotationDeploySet", org.apache.thrift.protocol.TType.I32, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new QuerySubscribeContractItemOptionStandardSchemeFactory());
    schemes.put(TupleScheme.class, new QuerySubscribeContractItemOptionTupleSchemeFactory());
  }

  public Set<Long> quotationAccountIds; // optional
  public Set<Long> sledCommodityIds; // optional
  /**
   * 
   * @see xueqiao.quotation.account.thriftapi.QuotationPlatformEnv
   */
  public xueqiao.quotation.account.thriftapi.QuotationPlatformEnv platformEnv; // optional
  /**
   * 
   * @see xueqiao.quotation.account.thriftapi.DeploySet
   */
  public xueqiao.quotation.account.thriftapi.DeploySet quotationDeploySet; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    QUOTATION_ACCOUNT_IDS((short)1, "quotationAccountIds"),
    SLED_COMMODITY_IDS((short)2, "sledCommodityIds"),
    /**
     * 
     * @see xueqiao.quotation.account.thriftapi.QuotationPlatformEnv
     */
    PLATFORM_ENV((short)3, "platformEnv"),
    /**
     * 
     * @see xueqiao.quotation.account.thriftapi.DeploySet
     */
    QUOTATION_DEPLOY_SET((short)4, "quotationDeploySet");

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
        case 1: // QUOTATION_ACCOUNT_IDS
          return QUOTATION_ACCOUNT_IDS;
        case 2: // SLED_COMMODITY_IDS
          return SLED_COMMODITY_IDS;
        case 3: // PLATFORM_ENV
          return PLATFORM_ENV;
        case 4: // QUOTATION_DEPLOY_SET
          return QUOTATION_DEPLOY_SET;
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
  private _Fields optionals[] = {_Fields.QUOTATION_ACCOUNT_IDS,_Fields.SLED_COMMODITY_IDS,_Fields.PLATFORM_ENV,_Fields.QUOTATION_DEPLOY_SET};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.QUOTATION_ACCOUNT_IDS, new org.apache.thrift.meta_data.FieldMetaData("quotationAccountIds", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.SetMetaData(org.apache.thrift.protocol.TType.SET, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64))));
    tmpMap.put(_Fields.SLED_COMMODITY_IDS, new org.apache.thrift.meta_data.FieldMetaData("sledCommodityIds", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.SetMetaData(org.apache.thrift.protocol.TType.SET, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64))));
    tmpMap.put(_Fields.PLATFORM_ENV, new org.apache.thrift.meta_data.FieldMetaData("platformEnv", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, xueqiao.quotation.account.thriftapi.QuotationPlatformEnv.class)));
    tmpMap.put(_Fields.QUOTATION_DEPLOY_SET, new org.apache.thrift.meta_data.FieldMetaData("quotationDeploySet", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, xueqiao.quotation.account.thriftapi.DeploySet.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(QuerySubscribeContractItemOption.class, metaDataMap);
  }

  public QuerySubscribeContractItemOption() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public QuerySubscribeContractItemOption(QuerySubscribeContractItemOption other) {
    if (other.isSetQuotationAccountIds()) {
      Set<Long> __this__quotationAccountIds = new HashSet<Long>(other.quotationAccountIds);
      this.quotationAccountIds = __this__quotationAccountIds;
    }
    if (other.isSetSledCommodityIds()) {
      Set<Long> __this__sledCommodityIds = new HashSet<Long>(other.sledCommodityIds);
      this.sledCommodityIds = __this__sledCommodityIds;
    }
    if (other.isSetPlatformEnv()) {
      this.platformEnv = other.platformEnv;
    }
    if (other.isSetQuotationDeploySet()) {
      this.quotationDeploySet = other.quotationDeploySet;
    }
  }

  public QuerySubscribeContractItemOption deepCopy() {
    return new QuerySubscribeContractItemOption(this);
  }

  @Override
  public void clear() {
    this.quotationAccountIds = null;
    this.sledCommodityIds = null;
    this.platformEnv = null;
    this.quotationDeploySet = null;
  }

  public int getQuotationAccountIdsSize() {
    return (this.quotationAccountIds == null) ? 0 : this.quotationAccountIds.size();
  }

  public java.util.Iterator<Long> getQuotationAccountIdsIterator() {
    return (this.quotationAccountIds == null) ? null : this.quotationAccountIds.iterator();
  }

  public void addToQuotationAccountIds(long elem) {
    if (this.quotationAccountIds == null) {
      this.quotationAccountIds = new HashSet<Long>();
    }
    this.quotationAccountIds.add(elem);
  }

  public Set<Long> getQuotationAccountIds() {
    return this.quotationAccountIds;
  }

  public QuerySubscribeContractItemOption setQuotationAccountIds(Set<Long> quotationAccountIds) {
    this.quotationAccountIds = quotationAccountIds;
    return this;
  }

  public void unsetQuotationAccountIds() {
    this.quotationAccountIds = null;
  }

  /** Returns true if field quotationAccountIds is set (has been assigned a value) and false otherwise */
  public boolean isSetQuotationAccountIds() {
    return this.quotationAccountIds != null;
  }

  public void setQuotationAccountIdsIsSet(boolean value) {
    if (!value) {
      this.quotationAccountIds = null;
    }
  }

  public int getSledCommodityIdsSize() {
    return (this.sledCommodityIds == null) ? 0 : this.sledCommodityIds.size();
  }

  public java.util.Iterator<Long> getSledCommodityIdsIterator() {
    return (this.sledCommodityIds == null) ? null : this.sledCommodityIds.iterator();
  }

  public void addToSledCommodityIds(long elem) {
    if (this.sledCommodityIds == null) {
      this.sledCommodityIds = new HashSet<Long>();
    }
    this.sledCommodityIds.add(elem);
  }

  public Set<Long> getSledCommodityIds() {
    return this.sledCommodityIds;
  }

  public QuerySubscribeContractItemOption setSledCommodityIds(Set<Long> sledCommodityIds) {
    this.sledCommodityIds = sledCommodityIds;
    return this;
  }

  public void unsetSledCommodityIds() {
    this.sledCommodityIds = null;
  }

  /** Returns true if field sledCommodityIds is set (has been assigned a value) and false otherwise */
  public boolean isSetSledCommodityIds() {
    return this.sledCommodityIds != null;
  }

  public void setSledCommodityIdsIsSet(boolean value) {
    if (!value) {
      this.sledCommodityIds = null;
    }
  }

  /**
   * 
   * @see xueqiao.quotation.account.thriftapi.QuotationPlatformEnv
   */
  public xueqiao.quotation.account.thriftapi.QuotationPlatformEnv getPlatformEnv() {
    return this.platformEnv;
  }

  /**
   * 
   * @see xueqiao.quotation.account.thriftapi.QuotationPlatformEnv
   */
  public QuerySubscribeContractItemOption setPlatformEnv(xueqiao.quotation.account.thriftapi.QuotationPlatformEnv platformEnv) {
    this.platformEnv = platformEnv;
    return this;
  }

  public void unsetPlatformEnv() {
    this.platformEnv = null;
  }

  /** Returns true if field platformEnv is set (has been assigned a value) and false otherwise */
  public boolean isSetPlatformEnv() {
    return this.platformEnv != null;
  }

  public void setPlatformEnvIsSet(boolean value) {
    if (!value) {
      this.platformEnv = null;
    }
  }

  /**
   * 
   * @see xueqiao.quotation.account.thriftapi.DeploySet
   */
  public xueqiao.quotation.account.thriftapi.DeploySet getQuotationDeploySet() {
    return this.quotationDeploySet;
  }

  /**
   * 
   * @see xueqiao.quotation.account.thriftapi.DeploySet
   */
  public QuerySubscribeContractItemOption setQuotationDeploySet(xueqiao.quotation.account.thriftapi.DeploySet quotationDeploySet) {
    this.quotationDeploySet = quotationDeploySet;
    return this;
  }

  public void unsetQuotationDeploySet() {
    this.quotationDeploySet = null;
  }

  /** Returns true if field quotationDeploySet is set (has been assigned a value) and false otherwise */
  public boolean isSetQuotationDeploySet() {
    return this.quotationDeploySet != null;
  }

  public void setQuotationDeploySetIsSet(boolean value) {
    if (!value) {
      this.quotationDeploySet = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case QUOTATION_ACCOUNT_IDS:
      if (value == null) {
        unsetQuotationAccountIds();
      } else {
        setQuotationAccountIds((Set<Long>)value);
      }
      break;

    case SLED_COMMODITY_IDS:
      if (value == null) {
        unsetSledCommodityIds();
      } else {
        setSledCommodityIds((Set<Long>)value);
      }
      break;

    case PLATFORM_ENV:
      if (value == null) {
        unsetPlatformEnv();
      } else {
        setPlatformEnv((xueqiao.quotation.account.thriftapi.QuotationPlatformEnv)value);
      }
      break;

    case QUOTATION_DEPLOY_SET:
      if (value == null) {
        unsetQuotationDeploySet();
      } else {
        setQuotationDeploySet((xueqiao.quotation.account.thriftapi.DeploySet)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case QUOTATION_ACCOUNT_IDS:
      return getQuotationAccountIds();

    case SLED_COMMODITY_IDS:
      return getSledCommodityIds();

    case PLATFORM_ENV:
      return getPlatformEnv();

    case QUOTATION_DEPLOY_SET:
      return getQuotationDeploySet();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case QUOTATION_ACCOUNT_IDS:
      return isSetQuotationAccountIds();
    case SLED_COMMODITY_IDS:
      return isSetSledCommodityIds();
    case PLATFORM_ENV:
      return isSetPlatformEnv();
    case QUOTATION_DEPLOY_SET:
      return isSetQuotationDeploySet();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof QuerySubscribeContractItemOption)
      return this.equals((QuerySubscribeContractItemOption)that);
    return false;
  }

  public boolean equals(QuerySubscribeContractItemOption that) {
    if (that == null)
      return false;

    boolean this_present_quotationAccountIds = true && this.isSetQuotationAccountIds();
    boolean that_present_quotationAccountIds = true && that.isSetQuotationAccountIds();
    if (this_present_quotationAccountIds || that_present_quotationAccountIds) {
      if (!(this_present_quotationAccountIds && that_present_quotationAccountIds))
        return false;
      if (!this.quotationAccountIds.equals(that.quotationAccountIds))
        return false;
    }

    boolean this_present_sledCommodityIds = true && this.isSetSledCommodityIds();
    boolean that_present_sledCommodityIds = true && that.isSetSledCommodityIds();
    if (this_present_sledCommodityIds || that_present_sledCommodityIds) {
      if (!(this_present_sledCommodityIds && that_present_sledCommodityIds))
        return false;
      if (!this.sledCommodityIds.equals(that.sledCommodityIds))
        return false;
    }

    boolean this_present_platformEnv = true && this.isSetPlatformEnv();
    boolean that_present_platformEnv = true && that.isSetPlatformEnv();
    if (this_present_platformEnv || that_present_platformEnv) {
      if (!(this_present_platformEnv && that_present_platformEnv))
        return false;
      if (!this.platformEnv.equals(that.platformEnv))
        return false;
    }

    boolean this_present_quotationDeploySet = true && this.isSetQuotationDeploySet();
    boolean that_present_quotationDeploySet = true && that.isSetQuotationDeploySet();
    if (this_present_quotationDeploySet || that_present_quotationDeploySet) {
      if (!(this_present_quotationDeploySet && that_present_quotationDeploySet))
        return false;
      if (!this.quotationDeploySet.equals(that.quotationDeploySet))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(QuerySubscribeContractItemOption other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetQuotationAccountIds()).compareTo(other.isSetQuotationAccountIds());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetQuotationAccountIds()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.quotationAccountIds, other.quotationAccountIds);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSledCommodityIds()).compareTo(other.isSetSledCommodityIds());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSledCommodityIds()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sledCommodityIds, other.sledCommodityIds);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPlatformEnv()).compareTo(other.isSetPlatformEnv());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPlatformEnv()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.platformEnv, other.platformEnv);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetQuotationDeploySet()).compareTo(other.isSetQuotationDeploySet());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetQuotationDeploySet()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.quotationDeploySet, other.quotationDeploySet);
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
    StringBuilder sb = new StringBuilder("QuerySubscribeContractItemOption(");
    boolean first = true;

    if (isSetQuotationAccountIds()) {
      sb.append("quotationAccountIds:");
      if (this.quotationAccountIds == null) {
        sb.append("null");
      } else {
        sb.append(this.quotationAccountIds);
      }
      first = false;
    }
    if (isSetSledCommodityIds()) {
      if (!first) sb.append(", ");
      sb.append("sledCommodityIds:");
      if (this.sledCommodityIds == null) {
        sb.append("null");
      } else {
        sb.append(this.sledCommodityIds);
      }
      first = false;
    }
    if (isSetPlatformEnv()) {
      if (!first) sb.append(", ");
      sb.append("platformEnv:");
      if (this.platformEnv == null) {
        sb.append("null");
      } else {
        sb.append(this.platformEnv);
      }
      first = false;
    }
    if (isSetQuotationDeploySet()) {
      if (!first) sb.append(", ");
      sb.append("quotationDeploySet:");
      if (this.quotationDeploySet == null) {
        sb.append("null");
      } else {
        sb.append(this.quotationDeploySet);
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

  private static class QuerySubscribeContractItemOptionStandardSchemeFactory implements SchemeFactory {
    public QuerySubscribeContractItemOptionStandardScheme getScheme() {
      return new QuerySubscribeContractItemOptionStandardScheme();
    }
  }

  private static class QuerySubscribeContractItemOptionStandardScheme extends StandardScheme<QuerySubscribeContractItemOption> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, QuerySubscribeContractItemOption struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // QUOTATION_ACCOUNT_IDS
            if (schemeField.type == org.apache.thrift.protocol.TType.SET) {
              {
                org.apache.thrift.protocol.TSet _set80 = iprot.readSetBegin();
                struct.quotationAccountIds = new HashSet<Long>(2*_set80.size);
                for (int _i81 = 0; _i81 < _set80.size; ++_i81)
                {
                  long _elem82;
                  _elem82 = iprot.readI64();
                  struct.quotationAccountIds.add(_elem82);
                }
                iprot.readSetEnd();
              }
              struct.setQuotationAccountIdsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // SLED_COMMODITY_IDS
            if (schemeField.type == org.apache.thrift.protocol.TType.SET) {
              {
                org.apache.thrift.protocol.TSet _set83 = iprot.readSetBegin();
                struct.sledCommodityIds = new HashSet<Long>(2*_set83.size);
                for (int _i84 = 0; _i84 < _set83.size; ++_i84)
                {
                  long _elem85;
                  _elem85 = iprot.readI64();
                  struct.sledCommodityIds.add(_elem85);
                }
                iprot.readSetEnd();
              }
              struct.setSledCommodityIdsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // PLATFORM_ENV
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.platformEnv = xueqiao.quotation.account.thriftapi.QuotationPlatformEnv.findByValue(iprot.readI32());
              struct.setPlatformEnvIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // QUOTATION_DEPLOY_SET
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.quotationDeploySet = xueqiao.quotation.account.thriftapi.DeploySet.findByValue(iprot.readI32());
              struct.setQuotationDeploySetIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, QuerySubscribeContractItemOption struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.quotationAccountIds != null) {
        if (struct.isSetQuotationAccountIds()) {
          oprot.writeFieldBegin(QUOTATION_ACCOUNT_IDS_FIELD_DESC);
          {
            oprot.writeSetBegin(new org.apache.thrift.protocol.TSet(org.apache.thrift.protocol.TType.I64, struct.quotationAccountIds.size()));
            for (long _iter86 : struct.quotationAccountIds)
            {
              oprot.writeI64(_iter86);
            }
            oprot.writeSetEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.sledCommodityIds != null) {
        if (struct.isSetSledCommodityIds()) {
          oprot.writeFieldBegin(SLED_COMMODITY_IDS_FIELD_DESC);
          {
            oprot.writeSetBegin(new org.apache.thrift.protocol.TSet(org.apache.thrift.protocol.TType.I64, struct.sledCommodityIds.size()));
            for (long _iter87 : struct.sledCommodityIds)
            {
              oprot.writeI64(_iter87);
            }
            oprot.writeSetEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.platformEnv != null) {
        if (struct.isSetPlatformEnv()) {
          oprot.writeFieldBegin(PLATFORM_ENV_FIELD_DESC);
          oprot.writeI32(struct.platformEnv.getValue());
          oprot.writeFieldEnd();
        }
      }
      if (struct.quotationDeploySet != null) {
        if (struct.isSetQuotationDeploySet()) {
          oprot.writeFieldBegin(QUOTATION_DEPLOY_SET_FIELD_DESC);
          oprot.writeI32(struct.quotationDeploySet.getValue());
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class QuerySubscribeContractItemOptionTupleSchemeFactory implements SchemeFactory {
    public QuerySubscribeContractItemOptionTupleScheme getScheme() {
      return new QuerySubscribeContractItemOptionTupleScheme();
    }
  }

  private static class QuerySubscribeContractItemOptionTupleScheme extends TupleScheme<QuerySubscribeContractItemOption> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, QuerySubscribeContractItemOption struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetQuotationAccountIds()) {
        optionals.set(0);
      }
      if (struct.isSetSledCommodityIds()) {
        optionals.set(1);
      }
      if (struct.isSetPlatformEnv()) {
        optionals.set(2);
      }
      if (struct.isSetQuotationDeploySet()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetQuotationAccountIds()) {
        {
          oprot.writeI32(struct.quotationAccountIds.size());
          for (long _iter88 : struct.quotationAccountIds)
          {
            oprot.writeI64(_iter88);
          }
        }
      }
      if (struct.isSetSledCommodityIds()) {
        {
          oprot.writeI32(struct.sledCommodityIds.size());
          for (long _iter89 : struct.sledCommodityIds)
          {
            oprot.writeI64(_iter89);
          }
        }
      }
      if (struct.isSetPlatformEnv()) {
        oprot.writeI32(struct.platformEnv.getValue());
      }
      if (struct.isSetQuotationDeploySet()) {
        oprot.writeI32(struct.quotationDeploySet.getValue());
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, QuerySubscribeContractItemOption struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TSet _set90 = new org.apache.thrift.protocol.TSet(org.apache.thrift.protocol.TType.I64, iprot.readI32());
          struct.quotationAccountIds = new HashSet<Long>(2*_set90.size);
          for (int _i91 = 0; _i91 < _set90.size; ++_i91)
          {
            long _elem92;
            _elem92 = iprot.readI64();
            struct.quotationAccountIds.add(_elem92);
          }
        }
        struct.setQuotationAccountIdsIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TSet _set93 = new org.apache.thrift.protocol.TSet(org.apache.thrift.protocol.TType.I64, iprot.readI32());
          struct.sledCommodityIds = new HashSet<Long>(2*_set93.size);
          for (int _i94 = 0; _i94 < _set93.size; ++_i94)
          {
            long _elem95;
            _elem95 = iprot.readI64();
            struct.sledCommodityIds.add(_elem95);
          }
        }
        struct.setSledCommodityIdsIsSet(true);
      }
      if (incoming.get(2)) {
        struct.platformEnv = xueqiao.quotation.account.thriftapi.QuotationPlatformEnv.findByValue(iprot.readI32());
        struct.setPlatformEnvIsSet(true);
      }
      if (incoming.get(3)) {
        struct.quotationDeploySet = xueqiao.quotation.account.thriftapi.DeploySet.findByValue(iprot.readI32());
        struct.setQuotationDeploySetIsSet(true);
      }
    }
  }

}

