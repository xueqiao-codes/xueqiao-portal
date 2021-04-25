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

public class DayTradeTime implements org.apache.thrift.TBase<DayTradeTime, DayTradeTime._Fields>, java.io.Serializable, Cloneable, Comparable<DayTradeTime> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("DayTradeTime");

  private static final org.apache.thrift.protocol.TField T_TRADE_TIMES_FIELD_DESC = new org.apache.thrift.protocol.TField("tTradeTimes", org.apache.thrift.protocol.TType.LIST, (short)1);
  private static final org.apache.thrift.protocol.TField T_PLUS_ONE_TRADE_TIMES_FIELD_DESC = new org.apache.thrift.protocol.TField("tPlusOneTradeTimes", org.apache.thrift.protocol.TType.LIST, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new DayTradeTimeStandardSchemeFactory());
    schemes.put(TupleScheme.class, new DayTradeTimeTupleSchemeFactory());
  }

  public List<String> tTradeTimes; // optional
  public List<String> tPlusOneTradeTimes; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    T_TRADE_TIMES((short)1, "tTradeTimes"),
    T_PLUS_ONE_TRADE_TIMES((short)2, "tPlusOneTradeTimes");

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
        case 1: // T_TRADE_TIMES
          return T_TRADE_TIMES;
        case 2: // T_PLUS_ONE_TRADE_TIMES
          return T_PLUS_ONE_TRADE_TIMES;
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
  private _Fields optionals[] = {_Fields.T_TRADE_TIMES,_Fields.T_PLUS_ONE_TRADE_TIMES};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.T_TRADE_TIMES, new org.apache.thrift.meta_data.FieldMetaData("tTradeTimes", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    tmpMap.put(_Fields.T_PLUS_ONE_TRADE_TIMES, new org.apache.thrift.meta_data.FieldMetaData("tPlusOneTradeTimes", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(DayTradeTime.class, metaDataMap);
  }

  public DayTradeTime() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public DayTradeTime(DayTradeTime other) {
    if (other.isSetTTradeTimes()) {
      List<String> __this__tTradeTimes = new ArrayList<String>(other.tTradeTimes);
      this.tTradeTimes = __this__tTradeTimes;
    }
    if (other.isSetTPlusOneTradeTimes()) {
      List<String> __this__tPlusOneTradeTimes = new ArrayList<String>(other.tPlusOneTradeTimes);
      this.tPlusOneTradeTimes = __this__tPlusOneTradeTimes;
    }
  }

  public DayTradeTime deepCopy() {
    return new DayTradeTime(this);
  }

  @Override
  public void clear() {
    this.tTradeTimes = null;
    this.tPlusOneTradeTimes = null;
  }

  public int getTTradeTimesSize() {
    return (this.tTradeTimes == null) ? 0 : this.tTradeTimes.size();
  }

  public java.util.Iterator<String> getTTradeTimesIterator() {
    return (this.tTradeTimes == null) ? null : this.tTradeTimes.iterator();
  }

  public void addToTTradeTimes(String elem) {
    if (this.tTradeTimes == null) {
      this.tTradeTimes = new ArrayList<String>();
    }
    this.tTradeTimes.add(elem);
  }

  public List<String> getTTradeTimes() {
    return this.tTradeTimes;
  }

  public DayTradeTime setTTradeTimes(List<String> tTradeTimes) {
    this.tTradeTimes = tTradeTimes;
    return this;
  }

  public void unsetTTradeTimes() {
    this.tTradeTimes = null;
  }

  /** Returns true if field tTradeTimes is set (has been assigned a value) and false otherwise */
  public boolean isSetTTradeTimes() {
    return this.tTradeTimes != null;
  }

  public void setTTradeTimesIsSet(boolean value) {
    if (!value) {
      this.tTradeTimes = null;
    }
  }

  public int getTPlusOneTradeTimesSize() {
    return (this.tPlusOneTradeTimes == null) ? 0 : this.tPlusOneTradeTimes.size();
  }

  public java.util.Iterator<String> getTPlusOneTradeTimesIterator() {
    return (this.tPlusOneTradeTimes == null) ? null : this.tPlusOneTradeTimes.iterator();
  }

  public void addToTPlusOneTradeTimes(String elem) {
    if (this.tPlusOneTradeTimes == null) {
      this.tPlusOneTradeTimes = new ArrayList<String>();
    }
    this.tPlusOneTradeTimes.add(elem);
  }

  public List<String> getTPlusOneTradeTimes() {
    return this.tPlusOneTradeTimes;
  }

  public DayTradeTime setTPlusOneTradeTimes(List<String> tPlusOneTradeTimes) {
    this.tPlusOneTradeTimes = tPlusOneTradeTimes;
    return this;
  }

  public void unsetTPlusOneTradeTimes() {
    this.tPlusOneTradeTimes = null;
  }

  /** Returns true if field tPlusOneTradeTimes is set (has been assigned a value) and false otherwise */
  public boolean isSetTPlusOneTradeTimes() {
    return this.tPlusOneTradeTimes != null;
  }

  public void setTPlusOneTradeTimesIsSet(boolean value) {
    if (!value) {
      this.tPlusOneTradeTimes = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case T_TRADE_TIMES:
      if (value == null) {
        unsetTTradeTimes();
      } else {
        setTTradeTimes((List<String>)value);
      }
      break;

    case T_PLUS_ONE_TRADE_TIMES:
      if (value == null) {
        unsetTPlusOneTradeTimes();
      } else {
        setTPlusOneTradeTimes((List<String>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case T_TRADE_TIMES:
      return getTTradeTimes();

    case T_PLUS_ONE_TRADE_TIMES:
      return getTPlusOneTradeTimes();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case T_TRADE_TIMES:
      return isSetTTradeTimes();
    case T_PLUS_ONE_TRADE_TIMES:
      return isSetTPlusOneTradeTimes();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof DayTradeTime)
      return this.equals((DayTradeTime)that);
    return false;
  }

  public boolean equals(DayTradeTime that) {
    if (that == null)
      return false;

    boolean this_present_tTradeTimes = true && this.isSetTTradeTimes();
    boolean that_present_tTradeTimes = true && that.isSetTTradeTimes();
    if (this_present_tTradeTimes || that_present_tTradeTimes) {
      if (!(this_present_tTradeTimes && that_present_tTradeTimes))
        return false;
      if (!this.tTradeTimes.equals(that.tTradeTimes))
        return false;
    }

    boolean this_present_tPlusOneTradeTimes = true && this.isSetTPlusOneTradeTimes();
    boolean that_present_tPlusOneTradeTimes = true && that.isSetTPlusOneTradeTimes();
    if (this_present_tPlusOneTradeTimes || that_present_tPlusOneTradeTimes) {
      if (!(this_present_tPlusOneTradeTimes && that_present_tPlusOneTradeTimes))
        return false;
      if (!this.tPlusOneTradeTimes.equals(that.tPlusOneTradeTimes))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(DayTradeTime other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetTTradeTimes()).compareTo(other.isSetTTradeTimes());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTTradeTimes()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.tTradeTimes, other.tTradeTimes);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTPlusOneTradeTimes()).compareTo(other.isSetTPlusOneTradeTimes());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTPlusOneTradeTimes()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.tPlusOneTradeTimes, other.tPlusOneTradeTimes);
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
    StringBuilder sb = new StringBuilder("DayTradeTime(");
    boolean first = true;

    if (isSetTTradeTimes()) {
      sb.append("tTradeTimes:");
      if (this.tTradeTimes == null) {
        sb.append("null");
      } else {
        sb.append(this.tTradeTimes);
      }
      first = false;
    }
    if (isSetTPlusOneTradeTimes()) {
      if (!first) sb.append(", ");
      sb.append("tPlusOneTradeTimes:");
      if (this.tPlusOneTradeTimes == null) {
        sb.append("null");
      } else {
        sb.append(this.tPlusOneTradeTimes);
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

  private static class DayTradeTimeStandardSchemeFactory implements SchemeFactory {
    public DayTradeTimeStandardScheme getScheme() {
      return new DayTradeTimeStandardScheme();
    }
  }

  private static class DayTradeTimeStandardScheme extends StandardScheme<DayTradeTime> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, DayTradeTime struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // T_TRADE_TIMES
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list336 = iprot.readListBegin();
                struct.tTradeTimes = new ArrayList<String>(_list336.size);
                for (int _i337 = 0; _i337 < _list336.size; ++_i337)
                {
                  String _elem338;
                  _elem338 = iprot.readString();
                  struct.tTradeTimes.add(_elem338);
                }
                iprot.readListEnd();
              }
              struct.setTTradeTimesIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // T_PLUS_ONE_TRADE_TIMES
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list339 = iprot.readListBegin();
                struct.tPlusOneTradeTimes = new ArrayList<String>(_list339.size);
                for (int _i340 = 0; _i340 < _list339.size; ++_i340)
                {
                  String _elem341;
                  _elem341 = iprot.readString();
                  struct.tPlusOneTradeTimes.add(_elem341);
                }
                iprot.readListEnd();
              }
              struct.setTPlusOneTradeTimesIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, DayTradeTime struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.tTradeTimes != null) {
        if (struct.isSetTTradeTimes()) {
          oprot.writeFieldBegin(T_TRADE_TIMES_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, struct.tTradeTimes.size()));
            for (String _iter342 : struct.tTradeTimes)
            {
              oprot.writeString(_iter342);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.tPlusOneTradeTimes != null) {
        if (struct.isSetTPlusOneTradeTimes()) {
          oprot.writeFieldBegin(T_PLUS_ONE_TRADE_TIMES_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, struct.tPlusOneTradeTimes.size()));
            for (String _iter343 : struct.tPlusOneTradeTimes)
            {
              oprot.writeString(_iter343);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class DayTradeTimeTupleSchemeFactory implements SchemeFactory {
    public DayTradeTimeTupleScheme getScheme() {
      return new DayTradeTimeTupleScheme();
    }
  }

  private static class DayTradeTimeTupleScheme extends TupleScheme<DayTradeTime> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, DayTradeTime struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetTTradeTimes()) {
        optionals.set(0);
      }
      if (struct.isSetTPlusOneTradeTimes()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetTTradeTimes()) {
        {
          oprot.writeI32(struct.tTradeTimes.size());
          for (String _iter344 : struct.tTradeTimes)
          {
            oprot.writeString(_iter344);
          }
        }
      }
      if (struct.isSetTPlusOneTradeTimes()) {
        {
          oprot.writeI32(struct.tPlusOneTradeTimes.size());
          for (String _iter345 : struct.tPlusOneTradeTimes)
          {
            oprot.writeString(_iter345);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, DayTradeTime struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TList _list346 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, iprot.readI32());
          struct.tTradeTimes = new ArrayList<String>(_list346.size);
          for (int _i347 = 0; _i347 < _list346.size; ++_i347)
          {
            String _elem348;
            _elem348 = iprot.readString();
            struct.tTradeTimes.add(_elem348);
          }
        }
        struct.setTTradeTimesIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TList _list349 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, iprot.readI32());
          struct.tPlusOneTradeTimes = new ArrayList<String>(_list349.size);
          for (int _i350 = 0; _i350 < _list349.size; ++_i350)
          {
            String _elem351;
            _elem351 = iprot.readString();
            struct.tPlusOneTradeTimes.add(_elem351);
          }
        }
        struct.setTPlusOneTradeTimesIsSet(true);
      }
    }
  }

}

