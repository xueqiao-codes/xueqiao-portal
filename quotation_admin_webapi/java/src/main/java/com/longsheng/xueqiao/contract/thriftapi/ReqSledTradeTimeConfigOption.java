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

public class ReqSledTradeTimeConfigOption implements org.apache.thrift.TBase<ReqSledTradeTimeConfigOption, ReqSledTradeTimeConfigOption._Fields>, java.io.Serializable, Cloneable, Comparable<ReqSledTradeTimeConfigOption> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ReqSledTradeTimeConfigOption");

  private static final org.apache.thrift.protocol.TField SLED_COMMODITY_IDS_FIELD_DESC = new org.apache.thrift.protocol.TField("sledCommodityIds", org.apache.thrift.protocol.TType.SET, (short)1);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new ReqSledTradeTimeConfigOptionStandardSchemeFactory());
    schemes.put(TupleScheme.class, new ReqSledTradeTimeConfigOptionTupleSchemeFactory());
  }

  public Set<Integer> sledCommodityIds; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    SLED_COMMODITY_IDS((short)1, "sledCommodityIds");

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
        case 1: // SLED_COMMODITY_IDS
          return SLED_COMMODITY_IDS;
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
  private _Fields optionals[] = {_Fields.SLED_COMMODITY_IDS};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.SLED_COMMODITY_IDS, new org.apache.thrift.meta_data.FieldMetaData("sledCommodityIds", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.SetMetaData(org.apache.thrift.protocol.TType.SET, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ReqSledTradeTimeConfigOption.class, metaDataMap);
  }

  public ReqSledTradeTimeConfigOption() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ReqSledTradeTimeConfigOption(ReqSledTradeTimeConfigOption other) {
    if (other.isSetSledCommodityIds()) {
      Set<Integer> __this__sledCommodityIds = new HashSet<Integer>(other.sledCommodityIds);
      this.sledCommodityIds = __this__sledCommodityIds;
    }
  }

  public ReqSledTradeTimeConfigOption deepCopy() {
    return new ReqSledTradeTimeConfigOption(this);
  }

  @Override
  public void clear() {
    this.sledCommodityIds = null;
  }

  public int getSledCommodityIdsSize() {
    return (this.sledCommodityIds == null) ? 0 : this.sledCommodityIds.size();
  }

  public java.util.Iterator<Integer> getSledCommodityIdsIterator() {
    return (this.sledCommodityIds == null) ? null : this.sledCommodityIds.iterator();
  }

  public void addToSledCommodityIds(int elem) {
    if (this.sledCommodityIds == null) {
      this.sledCommodityIds = new HashSet<Integer>();
    }
    this.sledCommodityIds.add(elem);
  }

  public Set<Integer> getSledCommodityIds() {
    return this.sledCommodityIds;
  }

  public ReqSledTradeTimeConfigOption setSledCommodityIds(Set<Integer> sledCommodityIds) {
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

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case SLED_COMMODITY_IDS:
      if (value == null) {
        unsetSledCommodityIds();
      } else {
        setSledCommodityIds((Set<Integer>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case SLED_COMMODITY_IDS:
      return getSledCommodityIds();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case SLED_COMMODITY_IDS:
      return isSetSledCommodityIds();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ReqSledTradeTimeConfigOption)
      return this.equals((ReqSledTradeTimeConfigOption)that);
    return false;
  }

  public boolean equals(ReqSledTradeTimeConfigOption that) {
    if (that == null)
      return false;

    boolean this_present_sledCommodityIds = true && this.isSetSledCommodityIds();
    boolean that_present_sledCommodityIds = true && that.isSetSledCommodityIds();
    if (this_present_sledCommodityIds || that_present_sledCommodityIds) {
      if (!(this_present_sledCommodityIds && that_present_sledCommodityIds))
        return false;
      if (!this.sledCommodityIds.equals(that.sledCommodityIds))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(ReqSledTradeTimeConfigOption other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

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
    StringBuilder sb = new StringBuilder("ReqSledTradeTimeConfigOption(");
    boolean first = true;

    if (isSetSledCommodityIds()) {
      sb.append("sledCommodityIds:");
      if (this.sledCommodityIds == null) {
        sb.append("null");
      } else {
        sb.append(this.sledCommodityIds);
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

  private static class ReqSledTradeTimeConfigOptionStandardSchemeFactory implements SchemeFactory {
    public ReqSledTradeTimeConfigOptionStandardScheme getScheme() {
      return new ReqSledTradeTimeConfigOptionStandardScheme();
    }
  }

  private static class ReqSledTradeTimeConfigOptionStandardScheme extends StandardScheme<ReqSledTradeTimeConfigOption> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ReqSledTradeTimeConfigOption struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // SLED_COMMODITY_IDS
            if (schemeField.type == org.apache.thrift.protocol.TType.SET) {
              {
                org.apache.thrift.protocol.TSet _set400 = iprot.readSetBegin();
                struct.sledCommodityIds = new HashSet<Integer>(2*_set400.size);
                for (int _i401 = 0; _i401 < _set400.size; ++_i401)
                {
                  int _elem402;
                  _elem402 = iprot.readI32();
                  struct.sledCommodityIds.add(_elem402);
                }
                iprot.readSetEnd();
              }
              struct.setSledCommodityIdsIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, ReqSledTradeTimeConfigOption struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.sledCommodityIds != null) {
        if (struct.isSetSledCommodityIds()) {
          oprot.writeFieldBegin(SLED_COMMODITY_IDS_FIELD_DESC);
          {
            oprot.writeSetBegin(new org.apache.thrift.protocol.TSet(org.apache.thrift.protocol.TType.I32, struct.sledCommodityIds.size()));
            for (int _iter403 : struct.sledCommodityIds)
            {
              oprot.writeI32(_iter403);
            }
            oprot.writeSetEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ReqSledTradeTimeConfigOptionTupleSchemeFactory implements SchemeFactory {
    public ReqSledTradeTimeConfigOptionTupleScheme getScheme() {
      return new ReqSledTradeTimeConfigOptionTupleScheme();
    }
  }

  private static class ReqSledTradeTimeConfigOptionTupleScheme extends TupleScheme<ReqSledTradeTimeConfigOption> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ReqSledTradeTimeConfigOption struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetSledCommodityIds()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetSledCommodityIds()) {
        {
          oprot.writeI32(struct.sledCommodityIds.size());
          for (int _iter404 : struct.sledCommodityIds)
          {
            oprot.writeI32(_iter404);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ReqSledTradeTimeConfigOption struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TSet _set405 = new org.apache.thrift.protocol.TSet(org.apache.thrift.protocol.TType.I32, iprot.readI32());
          struct.sledCommodityIds = new HashSet<Integer>(2*_set405.size);
          for (int _i406 = 0; _i406 < _set405.size; ++_i406)
          {
            int _elem407;
            _elem407 = iprot.readI32();
            struct.sledCommodityIds.add(_elem407);
          }
        }
        struct.setSledCommodityIdsIsSet(true);
      }
    }
  }

}

