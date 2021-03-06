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

public class SledContractEdit implements org.apache.thrift.TBase<SledContractEdit, SledContractEdit._Fields>, java.io.Serializable, Cloneable, Comparable<SledContractEdit> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("SledContractEdit");

  private static final org.apache.thrift.protocol.TField SLED_CONTRACT_FIELD_DESC = new org.apache.thrift.protocol.TField("sledContract", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField EDIT_STATUS_FIELD_DESC = new org.apache.thrift.protocol.TField("editStatus", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField WORKING_STATUS_FIELD_DESC = new org.apache.thrift.protocol.TField("workingStatus", org.apache.thrift.protocol.TType.I32, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new SledContractEditStandardSchemeFactory());
    schemes.put(TupleScheme.class, new SledContractEditTupleSchemeFactory());
  }

  public com.longsheng.xueqiao.contract.standard.thriftapi.SledContract sledContract; // optional
  /**
   * 
   * @see EditStatus
   */
  public EditStatus editStatus; // optional
  /**
   * 
   * @see WorkingStatus
   */
  public WorkingStatus workingStatus; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    SLED_CONTRACT((short)1, "sledContract"),
    /**
     * 
     * @see EditStatus
     */
    EDIT_STATUS((short)2, "editStatus"),
    /**
     * 
     * @see WorkingStatus
     */
    WORKING_STATUS((short)3, "workingStatus");

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
        case 1: // SLED_CONTRACT
          return SLED_CONTRACT;
        case 2: // EDIT_STATUS
          return EDIT_STATUS;
        case 3: // WORKING_STATUS
          return WORKING_STATUS;
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
  private _Fields optionals[] = {_Fields.SLED_CONTRACT,_Fields.EDIT_STATUS,_Fields.WORKING_STATUS};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.SLED_CONTRACT, new org.apache.thrift.meta_data.FieldMetaData("sledContract", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, com.longsheng.xueqiao.contract.standard.thriftapi.SledContract.class)));
    tmpMap.put(_Fields.EDIT_STATUS, new org.apache.thrift.meta_data.FieldMetaData("editStatus", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, EditStatus.class)));
    tmpMap.put(_Fields.WORKING_STATUS, new org.apache.thrift.meta_data.FieldMetaData("workingStatus", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, WorkingStatus.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(SledContractEdit.class, metaDataMap);
  }

  public SledContractEdit() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public SledContractEdit(SledContractEdit other) {
    if (other.isSetSledContract()) {
      this.sledContract = new com.longsheng.xueqiao.contract.standard.thriftapi.SledContract(other.sledContract);
    }
    if (other.isSetEditStatus()) {
      this.editStatus = other.editStatus;
    }
    if (other.isSetWorkingStatus()) {
      this.workingStatus = other.workingStatus;
    }
  }

  public SledContractEdit deepCopy() {
    return new SledContractEdit(this);
  }

  @Override
  public void clear() {
    this.sledContract = null;
    this.editStatus = null;
    this.workingStatus = null;
  }

  public com.longsheng.xueqiao.contract.standard.thriftapi.SledContract getSledContract() {
    return this.sledContract;
  }

  public SledContractEdit setSledContract(com.longsheng.xueqiao.contract.standard.thriftapi.SledContract sledContract) {
    this.sledContract = sledContract;
    return this;
  }

  public void unsetSledContract() {
    this.sledContract = null;
  }

  /** Returns true if field sledContract is set (has been assigned a value) and false otherwise */
  public boolean isSetSledContract() {
    return this.sledContract != null;
  }

  public void setSledContractIsSet(boolean value) {
    if (!value) {
      this.sledContract = null;
    }
  }

  /**
   * 
   * @see EditStatus
   */
  public EditStatus getEditStatus() {
    return this.editStatus;
  }

  /**
   * 
   * @see EditStatus
   */
  public SledContractEdit setEditStatus(EditStatus editStatus) {
    this.editStatus = editStatus;
    return this;
  }

  public void unsetEditStatus() {
    this.editStatus = null;
  }

  /** Returns true if field editStatus is set (has been assigned a value) and false otherwise */
  public boolean isSetEditStatus() {
    return this.editStatus != null;
  }

  public void setEditStatusIsSet(boolean value) {
    if (!value) {
      this.editStatus = null;
    }
  }

  /**
   * 
   * @see WorkingStatus
   */
  public WorkingStatus getWorkingStatus() {
    return this.workingStatus;
  }

  /**
   * 
   * @see WorkingStatus
   */
  public SledContractEdit setWorkingStatus(WorkingStatus workingStatus) {
    this.workingStatus = workingStatus;
    return this;
  }

  public void unsetWorkingStatus() {
    this.workingStatus = null;
  }

  /** Returns true if field workingStatus is set (has been assigned a value) and false otherwise */
  public boolean isSetWorkingStatus() {
    return this.workingStatus != null;
  }

  public void setWorkingStatusIsSet(boolean value) {
    if (!value) {
      this.workingStatus = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case SLED_CONTRACT:
      if (value == null) {
        unsetSledContract();
      } else {
        setSledContract((com.longsheng.xueqiao.contract.standard.thriftapi.SledContract)value);
      }
      break;

    case EDIT_STATUS:
      if (value == null) {
        unsetEditStatus();
      } else {
        setEditStatus((EditStatus)value);
      }
      break;

    case WORKING_STATUS:
      if (value == null) {
        unsetWorkingStatus();
      } else {
        setWorkingStatus((WorkingStatus)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case SLED_CONTRACT:
      return getSledContract();

    case EDIT_STATUS:
      return getEditStatus();

    case WORKING_STATUS:
      return getWorkingStatus();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case SLED_CONTRACT:
      return isSetSledContract();
    case EDIT_STATUS:
      return isSetEditStatus();
    case WORKING_STATUS:
      return isSetWorkingStatus();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof SledContractEdit)
      return this.equals((SledContractEdit)that);
    return false;
  }

  public boolean equals(SledContractEdit that) {
    if (that == null)
      return false;

    boolean this_present_sledContract = true && this.isSetSledContract();
    boolean that_present_sledContract = true && that.isSetSledContract();
    if (this_present_sledContract || that_present_sledContract) {
      if (!(this_present_sledContract && that_present_sledContract))
        return false;
      if (!this.sledContract.equals(that.sledContract))
        return false;
    }

    boolean this_present_editStatus = true && this.isSetEditStatus();
    boolean that_present_editStatus = true && that.isSetEditStatus();
    if (this_present_editStatus || that_present_editStatus) {
      if (!(this_present_editStatus && that_present_editStatus))
        return false;
      if (!this.editStatus.equals(that.editStatus))
        return false;
    }

    boolean this_present_workingStatus = true && this.isSetWorkingStatus();
    boolean that_present_workingStatus = true && that.isSetWorkingStatus();
    if (this_present_workingStatus || that_present_workingStatus) {
      if (!(this_present_workingStatus && that_present_workingStatus))
        return false;
      if (!this.workingStatus.equals(that.workingStatus))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(SledContractEdit other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetSledContract()).compareTo(other.isSetSledContract());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSledContract()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sledContract, other.sledContract);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetEditStatus()).compareTo(other.isSetEditStatus());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEditStatus()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.editStatus, other.editStatus);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetWorkingStatus()).compareTo(other.isSetWorkingStatus());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetWorkingStatus()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.workingStatus, other.workingStatus);
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
    StringBuilder sb = new StringBuilder("SledContractEdit(");
    boolean first = true;

    if (isSetSledContract()) {
      sb.append("sledContract:");
      if (this.sledContract == null) {
        sb.append("null");
      } else {
        sb.append(this.sledContract);
      }
      first = false;
    }
    if (isSetEditStatus()) {
      if (!first) sb.append(", ");
      sb.append("editStatus:");
      if (this.editStatus == null) {
        sb.append("null");
      } else {
        sb.append(this.editStatus);
      }
      first = false;
    }
    if (isSetWorkingStatus()) {
      if (!first) sb.append(", ");
      sb.append("workingStatus:");
      if (this.workingStatus == null) {
        sb.append("null");
      } else {
        sb.append(this.workingStatus);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (sledContract != null) {
      sledContract.validate();
    }
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

  private static class SledContractEditStandardSchemeFactory implements SchemeFactory {
    public SledContractEditStandardScheme getScheme() {
      return new SledContractEditStandardScheme();
    }
  }

  private static class SledContractEditStandardScheme extends StandardScheme<SledContractEdit> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, SledContractEdit struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // SLED_CONTRACT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.sledContract = new com.longsheng.xueqiao.contract.standard.thriftapi.SledContract();
              struct.sledContract.read(iprot);
              struct.setSledContractIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // EDIT_STATUS
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.editStatus = EditStatus.findByValue(iprot.readI32());
              struct.setEditStatusIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // WORKING_STATUS
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.workingStatus = WorkingStatus.findByValue(iprot.readI32());
              struct.setWorkingStatusIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, SledContractEdit struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.sledContract != null) {
        if (struct.isSetSledContract()) {
          oprot.writeFieldBegin(SLED_CONTRACT_FIELD_DESC);
          struct.sledContract.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.editStatus != null) {
        if (struct.isSetEditStatus()) {
          oprot.writeFieldBegin(EDIT_STATUS_FIELD_DESC);
          oprot.writeI32(struct.editStatus.getValue());
          oprot.writeFieldEnd();
        }
      }
      if (struct.workingStatus != null) {
        if (struct.isSetWorkingStatus()) {
          oprot.writeFieldBegin(WORKING_STATUS_FIELD_DESC);
          oprot.writeI32(struct.workingStatus.getValue());
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class SledContractEditTupleSchemeFactory implements SchemeFactory {
    public SledContractEditTupleScheme getScheme() {
      return new SledContractEditTupleScheme();
    }
  }

  private static class SledContractEditTupleScheme extends TupleScheme<SledContractEdit> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, SledContractEdit struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetSledContract()) {
        optionals.set(0);
      }
      if (struct.isSetEditStatus()) {
        optionals.set(1);
      }
      if (struct.isSetWorkingStatus()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetSledContract()) {
        struct.sledContract.write(oprot);
      }
      if (struct.isSetEditStatus()) {
        oprot.writeI32(struct.editStatus.getValue());
      }
      if (struct.isSetWorkingStatus()) {
        oprot.writeI32(struct.workingStatus.getValue());
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, SledContractEdit struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.sledContract = new com.longsheng.xueqiao.contract.standard.thriftapi.SledContract();
        struct.sledContract.read(iprot);
        struct.setSledContractIsSet(true);
      }
      if (incoming.get(1)) {
        struct.editStatus = EditStatus.findByValue(iprot.readI32());
        struct.setEditStatusIsSet(true);
      }
      if (incoming.get(2)) {
        struct.workingStatus = WorkingStatus.findByValue(iprot.readI32());
        struct.setWorkingStatusIsSet(true);
      }
    }
  }

}

