/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package xueqiao.company;

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

public class QueryCompanySpecOption implements org.apache.thrift.TBase<QueryCompanySpecOption, QueryCompanySpecOption._Fields>, java.io.Serializable, Cloneable, Comparable<QueryCompanySpecOption> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("QueryCompanySpecOption");

  private static final org.apache.thrift.protocol.TField COMPANY_IDS_FIELD_DESC = new org.apache.thrift.protocol.TField("companyIds", org.apache.thrift.protocol.TType.SET, (short)1);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new QueryCompanySpecOptionStandardSchemeFactory());
    schemes.put(TupleScheme.class, new QueryCompanySpecOptionTupleSchemeFactory());
  }

  public Set<Integer> companyIds; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    COMPANY_IDS((short)1, "companyIds");

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
        case 1: // COMPANY_IDS
          return COMPANY_IDS;
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
  private _Fields optionals[] = {_Fields.COMPANY_IDS};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.COMPANY_IDS, new org.apache.thrift.meta_data.FieldMetaData("companyIds", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.SetMetaData(org.apache.thrift.protocol.TType.SET, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(QueryCompanySpecOption.class, metaDataMap);
  }

  public QueryCompanySpecOption() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public QueryCompanySpecOption(QueryCompanySpecOption other) {
    if (other.isSetCompanyIds()) {
      Set<Integer> __this__companyIds = new HashSet<Integer>(other.companyIds);
      this.companyIds = __this__companyIds;
    }
  }

  public QueryCompanySpecOption deepCopy() {
    return new QueryCompanySpecOption(this);
  }

  @Override
  public void clear() {
    this.companyIds = null;
  }

  public int getCompanyIdsSize() {
    return (this.companyIds == null) ? 0 : this.companyIds.size();
  }

  public java.util.Iterator<Integer> getCompanyIdsIterator() {
    return (this.companyIds == null) ? null : this.companyIds.iterator();
  }

  public void addToCompanyIds(int elem) {
    if (this.companyIds == null) {
      this.companyIds = new HashSet<Integer>();
    }
    this.companyIds.add(elem);
  }

  public Set<Integer> getCompanyIds() {
    return this.companyIds;
  }

  public QueryCompanySpecOption setCompanyIds(Set<Integer> companyIds) {
    this.companyIds = companyIds;
    return this;
  }

  public void unsetCompanyIds() {
    this.companyIds = null;
  }

  /** Returns true if field companyIds is set (has been assigned a value) and false otherwise */
  public boolean isSetCompanyIds() {
    return this.companyIds != null;
  }

  public void setCompanyIdsIsSet(boolean value) {
    if (!value) {
      this.companyIds = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case COMPANY_IDS:
      if (value == null) {
        unsetCompanyIds();
      } else {
        setCompanyIds((Set<Integer>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case COMPANY_IDS:
      return getCompanyIds();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case COMPANY_IDS:
      return isSetCompanyIds();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof QueryCompanySpecOption)
      return this.equals((QueryCompanySpecOption)that);
    return false;
  }

  public boolean equals(QueryCompanySpecOption that) {
    if (that == null)
      return false;

    boolean this_present_companyIds = true && this.isSetCompanyIds();
    boolean that_present_companyIds = true && that.isSetCompanyIds();
    if (this_present_companyIds || that_present_companyIds) {
      if (!(this_present_companyIds && that_present_companyIds))
        return false;
      if (!this.companyIds.equals(that.companyIds))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(QueryCompanySpecOption other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetCompanyIds()).compareTo(other.isSetCompanyIds());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCompanyIds()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.companyIds, other.companyIds);
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
    StringBuilder sb = new StringBuilder("QueryCompanySpecOption(");
    boolean first = true;

    if (isSetCompanyIds()) {
      sb.append("companyIds:");
      if (this.companyIds == null) {
        sb.append("null");
      } else {
        sb.append(this.companyIds);
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

  private static class QueryCompanySpecOptionStandardSchemeFactory implements SchemeFactory {
    public QueryCompanySpecOptionStandardScheme getScheme() {
      return new QueryCompanySpecOptionStandardScheme();
    }
  }

  private static class QueryCompanySpecOptionStandardScheme extends StandardScheme<QueryCompanySpecOption> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, QueryCompanySpecOption struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // COMPANY_IDS
            if (schemeField.type == org.apache.thrift.protocol.TType.SET) {
              {
                org.apache.thrift.protocol.TSet _set88 = iprot.readSetBegin();
                struct.companyIds = new HashSet<Integer>(2*_set88.size);
                for (int _i89 = 0; _i89 < _set88.size; ++_i89)
                {
                  int _elem90;
                  _elem90 = iprot.readI32();
                  struct.companyIds.add(_elem90);
                }
                iprot.readSetEnd();
              }
              struct.setCompanyIdsIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, QueryCompanySpecOption struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.companyIds != null) {
        if (struct.isSetCompanyIds()) {
          oprot.writeFieldBegin(COMPANY_IDS_FIELD_DESC);
          {
            oprot.writeSetBegin(new org.apache.thrift.protocol.TSet(org.apache.thrift.protocol.TType.I32, struct.companyIds.size()));
            for (int _iter91 : struct.companyIds)
            {
              oprot.writeI32(_iter91);
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

  private static class QueryCompanySpecOptionTupleSchemeFactory implements SchemeFactory {
    public QueryCompanySpecOptionTupleScheme getScheme() {
      return new QueryCompanySpecOptionTupleScheme();
    }
  }

  private static class QueryCompanySpecOptionTupleScheme extends TupleScheme<QueryCompanySpecOption> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, QueryCompanySpecOption struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetCompanyIds()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetCompanyIds()) {
        {
          oprot.writeI32(struct.companyIds.size());
          for (int _iter92 : struct.companyIds)
          {
            oprot.writeI32(_iter92);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, QueryCompanySpecOption struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TSet _set93 = new org.apache.thrift.protocol.TSet(org.apache.thrift.protocol.TType.I32, iprot.readI32());
          struct.companyIds = new HashSet<Integer>(2*_set93.size);
          for (int _i94 = 0; _i94 < _set93.size; ++_i94)
          {
            int _elem95;
            _elem95 = iprot.readI32();
            struct.companyIds.add(_elem95);
          }
        }
        struct.setCompanyIdsIsSet(true);
      }
    }
  }

}

