/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package xueqiao.hosting.machine;

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

public class QueryHostingInitializationOption implements org.apache.thrift.TBase<QueryHostingInitializationOption, QueryHostingInitializationOption._Fields>, java.io.Serializable, Cloneable, Comparable<QueryHostingInitializationOption> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("QueryHostingInitializationOption");

  private static final org.apache.thrift.protocol.TField COMPANY_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("companyId", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField COMPANY_GROUP_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("companyGroupId", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField MACHINE_INNER_IP_FIELD_DESC = new org.apache.thrift.protocol.TField("machineInnerIp", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField STATUS_FIELD_DESC = new org.apache.thrift.protocol.TField("status", org.apache.thrift.protocol.TType.I32, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new QueryHostingInitializationOptionStandardSchemeFactory());
    schemes.put(TupleScheme.class, new QueryHostingInitializationOptionTupleSchemeFactory());
  }

  public int companyId; // optional
  public int companyGroupId; // optional
  public String machineInnerIp; // optional
  /**
   * 
   * @see SyncStatus
   */
  public SyncStatus status; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    COMPANY_ID((short)1, "companyId"),
    COMPANY_GROUP_ID((short)2, "companyGroupId"),
    MACHINE_INNER_IP((short)3, "machineInnerIp"),
    /**
     * 
     * @see SyncStatus
     */
    STATUS((short)4, "status");

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
        case 1: // COMPANY_ID
          return COMPANY_ID;
        case 2: // COMPANY_GROUP_ID
          return COMPANY_GROUP_ID;
        case 3: // MACHINE_INNER_IP
          return MACHINE_INNER_IP;
        case 4: // STATUS
          return STATUS;
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
  private static final int __COMPANYID_ISSET_ID = 0;
  private static final int __COMPANYGROUPID_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  private _Fields optionals[] = {_Fields.COMPANY_ID,_Fields.COMPANY_GROUP_ID,_Fields.MACHINE_INNER_IP,_Fields.STATUS};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.COMPANY_ID, new org.apache.thrift.meta_data.FieldMetaData("companyId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.COMPANY_GROUP_ID, new org.apache.thrift.meta_data.FieldMetaData("companyGroupId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.MACHINE_INNER_IP, new org.apache.thrift.meta_data.FieldMetaData("machineInnerIp", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.STATUS, new org.apache.thrift.meta_data.FieldMetaData("status", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, SyncStatus.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(QueryHostingInitializationOption.class, metaDataMap);
  }

  public QueryHostingInitializationOption() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public QueryHostingInitializationOption(QueryHostingInitializationOption other) {
    __isset_bitfield = other.__isset_bitfield;
    this.companyId = other.companyId;
    this.companyGroupId = other.companyGroupId;
    if (other.isSetMachineInnerIp()) {
      this.machineInnerIp = other.machineInnerIp;
    }
    if (other.isSetStatus()) {
      this.status = other.status;
    }
  }

  public QueryHostingInitializationOption deepCopy() {
    return new QueryHostingInitializationOption(this);
  }

  @Override
  public void clear() {
    setCompanyIdIsSet(false);
    this.companyId = 0;
    setCompanyGroupIdIsSet(false);
    this.companyGroupId = 0;
    this.machineInnerIp = null;
    this.status = null;
  }

  public int getCompanyId() {
    return this.companyId;
  }

  public QueryHostingInitializationOption setCompanyId(int companyId) {
    this.companyId = companyId;
    setCompanyIdIsSet(true);
    return this;
  }

  public void unsetCompanyId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __COMPANYID_ISSET_ID);
  }

  /** Returns true if field companyId is set (has been assigned a value) and false otherwise */
  public boolean isSetCompanyId() {
    return EncodingUtils.testBit(__isset_bitfield, __COMPANYID_ISSET_ID);
  }

  public void setCompanyIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __COMPANYID_ISSET_ID, value);
  }

  public int getCompanyGroupId() {
    return this.companyGroupId;
  }

  public QueryHostingInitializationOption setCompanyGroupId(int companyGroupId) {
    this.companyGroupId = companyGroupId;
    setCompanyGroupIdIsSet(true);
    return this;
  }

  public void unsetCompanyGroupId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __COMPANYGROUPID_ISSET_ID);
  }

  /** Returns true if field companyGroupId is set (has been assigned a value) and false otherwise */
  public boolean isSetCompanyGroupId() {
    return EncodingUtils.testBit(__isset_bitfield, __COMPANYGROUPID_ISSET_ID);
  }

  public void setCompanyGroupIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __COMPANYGROUPID_ISSET_ID, value);
  }

  public String getMachineInnerIp() {
    return this.machineInnerIp;
  }

  public QueryHostingInitializationOption setMachineInnerIp(String machineInnerIp) {
    this.machineInnerIp = machineInnerIp;
    return this;
  }

  public void unsetMachineInnerIp() {
    this.machineInnerIp = null;
  }

  /** Returns true if field machineInnerIp is set (has been assigned a value) and false otherwise */
  public boolean isSetMachineInnerIp() {
    return this.machineInnerIp != null;
  }

  public void setMachineInnerIpIsSet(boolean value) {
    if (!value) {
      this.machineInnerIp = null;
    }
  }

  /**
   * 
   * @see SyncStatus
   */
  public SyncStatus getStatus() {
    return this.status;
  }

  /**
   * 
   * @see SyncStatus
   */
  public QueryHostingInitializationOption setStatus(SyncStatus status) {
    this.status = status;
    return this;
  }

  public void unsetStatus() {
    this.status = null;
  }

  /** Returns true if field status is set (has been assigned a value) and false otherwise */
  public boolean isSetStatus() {
    return this.status != null;
  }

  public void setStatusIsSet(boolean value) {
    if (!value) {
      this.status = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case COMPANY_ID:
      if (value == null) {
        unsetCompanyId();
      } else {
        setCompanyId((Integer)value);
      }
      break;

    case COMPANY_GROUP_ID:
      if (value == null) {
        unsetCompanyGroupId();
      } else {
        setCompanyGroupId((Integer)value);
      }
      break;

    case MACHINE_INNER_IP:
      if (value == null) {
        unsetMachineInnerIp();
      } else {
        setMachineInnerIp((String)value);
      }
      break;

    case STATUS:
      if (value == null) {
        unsetStatus();
      } else {
        setStatus((SyncStatus)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case COMPANY_ID:
      return Integer.valueOf(getCompanyId());

    case COMPANY_GROUP_ID:
      return Integer.valueOf(getCompanyGroupId());

    case MACHINE_INNER_IP:
      return getMachineInnerIp();

    case STATUS:
      return getStatus();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case COMPANY_ID:
      return isSetCompanyId();
    case COMPANY_GROUP_ID:
      return isSetCompanyGroupId();
    case MACHINE_INNER_IP:
      return isSetMachineInnerIp();
    case STATUS:
      return isSetStatus();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof QueryHostingInitializationOption)
      return this.equals((QueryHostingInitializationOption)that);
    return false;
  }

  public boolean equals(QueryHostingInitializationOption that) {
    if (that == null)
      return false;

    boolean this_present_companyId = true && this.isSetCompanyId();
    boolean that_present_companyId = true && that.isSetCompanyId();
    if (this_present_companyId || that_present_companyId) {
      if (!(this_present_companyId && that_present_companyId))
        return false;
      if (this.companyId != that.companyId)
        return false;
    }

    boolean this_present_companyGroupId = true && this.isSetCompanyGroupId();
    boolean that_present_companyGroupId = true && that.isSetCompanyGroupId();
    if (this_present_companyGroupId || that_present_companyGroupId) {
      if (!(this_present_companyGroupId && that_present_companyGroupId))
        return false;
      if (this.companyGroupId != that.companyGroupId)
        return false;
    }

    boolean this_present_machineInnerIp = true && this.isSetMachineInnerIp();
    boolean that_present_machineInnerIp = true && that.isSetMachineInnerIp();
    if (this_present_machineInnerIp || that_present_machineInnerIp) {
      if (!(this_present_machineInnerIp && that_present_machineInnerIp))
        return false;
      if (!this.machineInnerIp.equals(that.machineInnerIp))
        return false;
    }

    boolean this_present_status = true && this.isSetStatus();
    boolean that_present_status = true && that.isSetStatus();
    if (this_present_status || that_present_status) {
      if (!(this_present_status && that_present_status))
        return false;
      if (!this.status.equals(that.status))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(QueryHostingInitializationOption other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetCompanyId()).compareTo(other.isSetCompanyId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCompanyId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.companyId, other.companyId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetCompanyGroupId()).compareTo(other.isSetCompanyGroupId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCompanyGroupId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.companyGroupId, other.companyGroupId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetMachineInnerIp()).compareTo(other.isSetMachineInnerIp());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMachineInnerIp()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.machineInnerIp, other.machineInnerIp);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetStatus()).compareTo(other.isSetStatus());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStatus()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.status, other.status);
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
    StringBuilder sb = new StringBuilder("QueryHostingInitializationOption(");
    boolean first = true;

    if (isSetCompanyId()) {
      sb.append("companyId:");
      sb.append(this.companyId);
      first = false;
    }
    if (isSetCompanyGroupId()) {
      if (!first) sb.append(", ");
      sb.append("companyGroupId:");
      sb.append(this.companyGroupId);
      first = false;
    }
    if (isSetMachineInnerIp()) {
      if (!first) sb.append(", ");
      sb.append("machineInnerIp:");
      if (this.machineInnerIp == null) {
        sb.append("null");
      } else {
        sb.append(this.machineInnerIp);
      }
      first = false;
    }
    if (isSetStatus()) {
      if (!first) sb.append(", ");
      sb.append("status:");
      if (this.status == null) {
        sb.append("null");
      } else {
        sb.append(this.status);
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

  private static class QueryHostingInitializationOptionStandardSchemeFactory implements SchemeFactory {
    public QueryHostingInitializationOptionStandardScheme getScheme() {
      return new QueryHostingInitializationOptionStandardScheme();
    }
  }

  private static class QueryHostingInitializationOptionStandardScheme extends StandardScheme<QueryHostingInitializationOption> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, QueryHostingInitializationOption struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // COMPANY_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.companyId = iprot.readI32();
              struct.setCompanyIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // COMPANY_GROUP_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.companyGroupId = iprot.readI32();
              struct.setCompanyGroupIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // MACHINE_INNER_IP
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.machineInnerIp = iprot.readString();
              struct.setMachineInnerIpIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // STATUS
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.status = SyncStatus.findByValue(iprot.readI32());
              struct.setStatusIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, QueryHostingInitializationOption struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.isSetCompanyId()) {
        oprot.writeFieldBegin(COMPANY_ID_FIELD_DESC);
        oprot.writeI32(struct.companyId);
        oprot.writeFieldEnd();
      }
      if (struct.isSetCompanyGroupId()) {
        oprot.writeFieldBegin(COMPANY_GROUP_ID_FIELD_DESC);
        oprot.writeI32(struct.companyGroupId);
        oprot.writeFieldEnd();
      }
      if (struct.machineInnerIp != null) {
        if (struct.isSetMachineInnerIp()) {
          oprot.writeFieldBegin(MACHINE_INNER_IP_FIELD_DESC);
          oprot.writeString(struct.machineInnerIp);
          oprot.writeFieldEnd();
        }
      }
      if (struct.status != null) {
        if (struct.isSetStatus()) {
          oprot.writeFieldBegin(STATUS_FIELD_DESC);
          oprot.writeI32(struct.status.getValue());
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class QueryHostingInitializationOptionTupleSchemeFactory implements SchemeFactory {
    public QueryHostingInitializationOptionTupleScheme getScheme() {
      return new QueryHostingInitializationOptionTupleScheme();
    }
  }

  private static class QueryHostingInitializationOptionTupleScheme extends TupleScheme<QueryHostingInitializationOption> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, QueryHostingInitializationOption struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetCompanyId()) {
        optionals.set(0);
      }
      if (struct.isSetCompanyGroupId()) {
        optionals.set(1);
      }
      if (struct.isSetMachineInnerIp()) {
        optionals.set(2);
      }
      if (struct.isSetStatus()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetCompanyId()) {
        oprot.writeI32(struct.companyId);
      }
      if (struct.isSetCompanyGroupId()) {
        oprot.writeI32(struct.companyGroupId);
      }
      if (struct.isSetMachineInnerIp()) {
        oprot.writeString(struct.machineInnerIp);
      }
      if (struct.isSetStatus()) {
        oprot.writeI32(struct.status.getValue());
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, QueryHostingInitializationOption struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.companyId = iprot.readI32();
        struct.setCompanyIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.companyGroupId = iprot.readI32();
        struct.setCompanyGroupIdIsSet(true);
      }
      if (incoming.get(2)) {
        struct.machineInnerIp = iprot.readString();
        struct.setMachineInnerIpIsSet(true);
      }
      if (incoming.get(3)) {
        struct.status = SyncStatus.findByValue(iprot.readI32());
        struct.setStatusIsSet(true);
      }
    }
  }

}
