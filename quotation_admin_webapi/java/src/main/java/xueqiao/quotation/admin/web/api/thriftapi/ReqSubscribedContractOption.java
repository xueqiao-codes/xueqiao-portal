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

public class ReqSubscribedContractOption implements org.apache.thrift.TBase<ReqSubscribedContractOption, ReqSubscribedContractOption._Fields>, java.io.Serializable, Cloneable, Comparable<ReqSubscribedContractOption> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ReqSubscribedContractOption");

  private static final org.apache.thrift.protocol.TField ACCOUNT_NAME_PARTICAL_FIELD_DESC = new org.apache.thrift.protocol.TField("accountNamePartical", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField COMMODITY_NAME_PARTICAL_FIELD_DESC = new org.apache.thrift.protocol.TField("commodityNamePartical", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField PLATFORM_ENV_FIELD_DESC = new org.apache.thrift.protocol.TField("platformEnv", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField DEPLOY_SET_FIELD_DESC = new org.apache.thrift.protocol.TField("deploySet", org.apache.thrift.protocol.TType.I32, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new ReqSubscribedContractOptionStandardSchemeFactory());
    schemes.put(TupleScheme.class, new ReqSubscribedContractOptionTupleSchemeFactory());
  }

  public String accountNamePartical; // optional
  public String commodityNamePartical; // optional
  /**
   * 
   * @see com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv
   */
  public com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv; // required
  /**
   * 
   * @see xueqiao.quotation.account.thriftapi.DeploySet
   */
  public xueqiao.quotation.account.thriftapi.DeploySet deploySet; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ACCOUNT_NAME_PARTICAL((short)1, "accountNamePartical"),
    COMMODITY_NAME_PARTICAL((short)2, "commodityNamePartical"),
    /**
     * 
     * @see com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv
     */
    PLATFORM_ENV((short)3, "platformEnv"),
    /**
     * 
     * @see xueqiao.quotation.account.thriftapi.DeploySet
     */
    DEPLOY_SET((short)4, "deploySet");

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
        case 1: // ACCOUNT_NAME_PARTICAL
          return ACCOUNT_NAME_PARTICAL;
        case 2: // COMMODITY_NAME_PARTICAL
          return COMMODITY_NAME_PARTICAL;
        case 3: // PLATFORM_ENV
          return PLATFORM_ENV;
        case 4: // DEPLOY_SET
          return DEPLOY_SET;
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
  private _Fields optionals[] = {_Fields.ACCOUNT_NAME_PARTICAL,_Fields.COMMODITY_NAME_PARTICAL,_Fields.DEPLOY_SET};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ACCOUNT_NAME_PARTICAL, new org.apache.thrift.meta_data.FieldMetaData("accountNamePartical", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.COMMODITY_NAME_PARTICAL, new org.apache.thrift.meta_data.FieldMetaData("commodityNamePartical", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PLATFORM_ENV, new org.apache.thrift.meta_data.FieldMetaData("platformEnv", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv.class)));
    tmpMap.put(_Fields.DEPLOY_SET, new org.apache.thrift.meta_data.FieldMetaData("deploySet", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, xueqiao.quotation.account.thriftapi.DeploySet.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ReqSubscribedContractOption.class, metaDataMap);
  }

  public ReqSubscribedContractOption() {
  }

  public ReqSubscribedContractOption(
    com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv)
  {
    this();
    this.platformEnv = platformEnv;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ReqSubscribedContractOption(ReqSubscribedContractOption other) {
    if (other.isSetAccountNamePartical()) {
      this.accountNamePartical = other.accountNamePartical;
    }
    if (other.isSetCommodityNamePartical()) {
      this.commodityNamePartical = other.commodityNamePartical;
    }
    if (other.isSetPlatformEnv()) {
      this.platformEnv = other.platformEnv;
    }
    if (other.isSetDeploySet()) {
      this.deploySet = other.deploySet;
    }
  }

  public ReqSubscribedContractOption deepCopy() {
    return new ReqSubscribedContractOption(this);
  }

  @Override
  public void clear() {
    this.accountNamePartical = null;
    this.commodityNamePartical = null;
    this.platformEnv = null;
    this.deploySet = null;
  }

  public String getAccountNamePartical() {
    return this.accountNamePartical;
  }

  public ReqSubscribedContractOption setAccountNamePartical(String accountNamePartical) {
    this.accountNamePartical = accountNamePartical;
    return this;
  }

  public void unsetAccountNamePartical() {
    this.accountNamePartical = null;
  }

  /** Returns true if field accountNamePartical is set (has been assigned a value) and false otherwise */
  public boolean isSetAccountNamePartical() {
    return this.accountNamePartical != null;
  }

  public void setAccountNameParticalIsSet(boolean value) {
    if (!value) {
      this.accountNamePartical = null;
    }
  }

  public String getCommodityNamePartical() {
    return this.commodityNamePartical;
  }

  public ReqSubscribedContractOption setCommodityNamePartical(String commodityNamePartical) {
    this.commodityNamePartical = commodityNamePartical;
    return this;
  }

  public void unsetCommodityNamePartical() {
    this.commodityNamePartical = null;
  }

  /** Returns true if field commodityNamePartical is set (has been assigned a value) and false otherwise */
  public boolean isSetCommodityNamePartical() {
    return this.commodityNamePartical != null;
  }

  public void setCommodityNameParticalIsSet(boolean value) {
    if (!value) {
      this.commodityNamePartical = null;
    }
  }

  /**
   * 
   * @see com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv
   */
  public com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv getPlatformEnv() {
    return this.platformEnv;
  }

  /**
   * 
   * @see com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv
   */
  public ReqSubscribedContractOption setPlatformEnv(com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv platformEnv) {
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
  public xueqiao.quotation.account.thriftapi.DeploySet getDeploySet() {
    return this.deploySet;
  }

  /**
   * 
   * @see xueqiao.quotation.account.thriftapi.DeploySet
   */
  public ReqSubscribedContractOption setDeploySet(xueqiao.quotation.account.thriftapi.DeploySet deploySet) {
    this.deploySet = deploySet;
    return this;
  }

  public void unsetDeploySet() {
    this.deploySet = null;
  }

  /** Returns true if field deploySet is set (has been assigned a value) and false otherwise */
  public boolean isSetDeploySet() {
    return this.deploySet != null;
  }

  public void setDeploySetIsSet(boolean value) {
    if (!value) {
      this.deploySet = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case ACCOUNT_NAME_PARTICAL:
      if (value == null) {
        unsetAccountNamePartical();
      } else {
        setAccountNamePartical((String)value);
      }
      break;

    case COMMODITY_NAME_PARTICAL:
      if (value == null) {
        unsetCommodityNamePartical();
      } else {
        setCommodityNamePartical((String)value);
      }
      break;

    case PLATFORM_ENV:
      if (value == null) {
        unsetPlatformEnv();
      } else {
        setPlatformEnv((com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv)value);
      }
      break;

    case DEPLOY_SET:
      if (value == null) {
        unsetDeploySet();
      } else {
        setDeploySet((xueqiao.quotation.account.thriftapi.DeploySet)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case ACCOUNT_NAME_PARTICAL:
      return getAccountNamePartical();

    case COMMODITY_NAME_PARTICAL:
      return getCommodityNamePartical();

    case PLATFORM_ENV:
      return getPlatformEnv();

    case DEPLOY_SET:
      return getDeploySet();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case ACCOUNT_NAME_PARTICAL:
      return isSetAccountNamePartical();
    case COMMODITY_NAME_PARTICAL:
      return isSetCommodityNamePartical();
    case PLATFORM_ENV:
      return isSetPlatformEnv();
    case DEPLOY_SET:
      return isSetDeploySet();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ReqSubscribedContractOption)
      return this.equals((ReqSubscribedContractOption)that);
    return false;
  }

  public boolean equals(ReqSubscribedContractOption that) {
    if (that == null)
      return false;

    boolean this_present_accountNamePartical = true && this.isSetAccountNamePartical();
    boolean that_present_accountNamePartical = true && that.isSetAccountNamePartical();
    if (this_present_accountNamePartical || that_present_accountNamePartical) {
      if (!(this_present_accountNamePartical && that_present_accountNamePartical))
        return false;
      if (!this.accountNamePartical.equals(that.accountNamePartical))
        return false;
    }

    boolean this_present_commodityNamePartical = true && this.isSetCommodityNamePartical();
    boolean that_present_commodityNamePartical = true && that.isSetCommodityNamePartical();
    if (this_present_commodityNamePartical || that_present_commodityNamePartical) {
      if (!(this_present_commodityNamePartical && that_present_commodityNamePartical))
        return false;
      if (!this.commodityNamePartical.equals(that.commodityNamePartical))
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

    boolean this_present_deploySet = true && this.isSetDeploySet();
    boolean that_present_deploySet = true && that.isSetDeploySet();
    if (this_present_deploySet || that_present_deploySet) {
      if (!(this_present_deploySet && that_present_deploySet))
        return false;
      if (!this.deploySet.equals(that.deploySet))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(ReqSubscribedContractOption other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetAccountNamePartical()).compareTo(other.isSetAccountNamePartical());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAccountNamePartical()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.accountNamePartical, other.accountNamePartical);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetCommodityNamePartical()).compareTo(other.isSetCommodityNamePartical());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCommodityNamePartical()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.commodityNamePartical, other.commodityNamePartical);
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
    lastComparison = Boolean.valueOf(isSetDeploySet()).compareTo(other.isSetDeploySet());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDeploySet()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.deploySet, other.deploySet);
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
    StringBuilder sb = new StringBuilder("ReqSubscribedContractOption(");
    boolean first = true;

    if (isSetAccountNamePartical()) {
      sb.append("accountNamePartical:");
      if (this.accountNamePartical == null) {
        sb.append("null");
      } else {
        sb.append(this.accountNamePartical);
      }
      first = false;
    }
    if (isSetCommodityNamePartical()) {
      if (!first) sb.append(", ");
      sb.append("commodityNamePartical:");
      if (this.commodityNamePartical == null) {
        sb.append("null");
      } else {
        sb.append(this.commodityNamePartical);
      }
      first = false;
    }
    if (!first) sb.append(", ");
    sb.append("platformEnv:");
    if (this.platformEnv == null) {
      sb.append("null");
    } else {
      sb.append(this.platformEnv);
    }
    first = false;
    if (isSetDeploySet()) {
      if (!first) sb.append(", ");
      sb.append("deploySet:");
      if (this.deploySet == null) {
        sb.append("null");
      } else {
        sb.append(this.deploySet);
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

  private static class ReqSubscribedContractOptionStandardSchemeFactory implements SchemeFactory {
    public ReqSubscribedContractOptionStandardScheme getScheme() {
      return new ReqSubscribedContractOptionStandardScheme();
    }
  }

  private static class ReqSubscribedContractOptionStandardScheme extends StandardScheme<ReqSubscribedContractOption> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ReqSubscribedContractOption struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ACCOUNT_NAME_PARTICAL
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.accountNamePartical = iprot.readString();
              struct.setAccountNameParticalIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // COMMODITY_NAME_PARTICAL
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.commodityNamePartical = iprot.readString();
              struct.setCommodityNameParticalIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // PLATFORM_ENV
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.platformEnv = com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv.findByValue(iprot.readI32());
              struct.setPlatformEnvIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // DEPLOY_SET
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.deploySet = xueqiao.quotation.account.thriftapi.DeploySet.findByValue(iprot.readI32());
              struct.setDeploySetIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, ReqSubscribedContractOption struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.accountNamePartical != null) {
        if (struct.isSetAccountNamePartical()) {
          oprot.writeFieldBegin(ACCOUNT_NAME_PARTICAL_FIELD_DESC);
          oprot.writeString(struct.accountNamePartical);
          oprot.writeFieldEnd();
        }
      }
      if (struct.commodityNamePartical != null) {
        if (struct.isSetCommodityNamePartical()) {
          oprot.writeFieldBegin(COMMODITY_NAME_PARTICAL_FIELD_DESC);
          oprot.writeString(struct.commodityNamePartical);
          oprot.writeFieldEnd();
        }
      }
      if (struct.platformEnv != null) {
        oprot.writeFieldBegin(PLATFORM_ENV_FIELD_DESC);
        oprot.writeI32(struct.platformEnv.getValue());
        oprot.writeFieldEnd();
      }
      if (struct.deploySet != null) {
        if (struct.isSetDeploySet()) {
          oprot.writeFieldBegin(DEPLOY_SET_FIELD_DESC);
          oprot.writeI32(struct.deploySet.getValue());
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ReqSubscribedContractOptionTupleSchemeFactory implements SchemeFactory {
    public ReqSubscribedContractOptionTupleScheme getScheme() {
      return new ReqSubscribedContractOptionTupleScheme();
    }
  }

  private static class ReqSubscribedContractOptionTupleScheme extends TupleScheme<ReqSubscribedContractOption> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ReqSubscribedContractOption struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetAccountNamePartical()) {
        optionals.set(0);
      }
      if (struct.isSetCommodityNamePartical()) {
        optionals.set(1);
      }
      if (struct.isSetPlatformEnv()) {
        optionals.set(2);
      }
      if (struct.isSetDeploySet()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetAccountNamePartical()) {
        oprot.writeString(struct.accountNamePartical);
      }
      if (struct.isSetCommodityNamePartical()) {
        oprot.writeString(struct.commodityNamePartical);
      }
      if (struct.isSetPlatformEnv()) {
        oprot.writeI32(struct.platformEnv.getValue());
      }
      if (struct.isSetDeploySet()) {
        oprot.writeI32(struct.deploySet.getValue());
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ReqSubscribedContractOption struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.accountNamePartical = iprot.readString();
        struct.setAccountNameParticalIsSet(true);
      }
      if (incoming.get(1)) {
        struct.commodityNamePartical = iprot.readString();
        struct.setCommodityNameParticalIsSet(true);
      }
      if (incoming.get(2)) {
        struct.platformEnv = com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv.findByValue(iprot.readI32());
        struct.setPlatformEnvIsSet(true);
      }
      if (incoming.get(3)) {
        struct.deploySet = xueqiao.quotation.account.thriftapi.DeploySet.findByValue(iprot.readI32());
        struct.setDeploySetIsSet(true);
      }
    }
  }

}
