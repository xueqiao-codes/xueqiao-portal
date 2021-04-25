/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package xueqiao.quotation.account.thriftapi;

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

public class QuotationAccountPage implements org.apache.thrift.TBase<QuotationAccountPage, QuotationAccountPage._Fields>, java.io.Serializable, Cloneable, Comparable<QuotationAccountPage> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("QuotationAccountPage");

  private static final org.apache.thrift.protocol.TField TOTAL_FIELD_DESC = new org.apache.thrift.protocol.TField("total", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField PAGE_FIELD_DESC = new org.apache.thrift.protocol.TField("page", org.apache.thrift.protocol.TType.LIST, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new QuotationAccountPageStandardSchemeFactory());
    schemes.put(TupleScheme.class, new QuotationAccountPageTupleSchemeFactory());
  }

  public int total; // optional
  public List<QuotationAccount> page; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    TOTAL((short)1, "total"),
    PAGE((short)2, "page");

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
        case 1: // TOTAL
          return TOTAL;
        case 2: // PAGE
          return PAGE;
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
  private static final int __TOTAL_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private _Fields optionals[] = {_Fields.TOTAL,_Fields.PAGE};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TOTAL, new org.apache.thrift.meta_data.FieldMetaData("total", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.PAGE, new org.apache.thrift.meta_data.FieldMetaData("page", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, QuotationAccount.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(QuotationAccountPage.class, metaDataMap);
  }

  public QuotationAccountPage() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public QuotationAccountPage(QuotationAccountPage other) {
    __isset_bitfield = other.__isset_bitfield;
    this.total = other.total;
    if (other.isSetPage()) {
      List<QuotationAccount> __this__page = new ArrayList<QuotationAccount>(other.page.size());
      for (QuotationAccount other_element : other.page) {
        __this__page.add(new QuotationAccount(other_element));
      }
      this.page = __this__page;
    }
  }

  public QuotationAccountPage deepCopy() {
    return new QuotationAccountPage(this);
  }

  @Override
  public void clear() {
    setTotalIsSet(false);
    this.total = 0;
    this.page = null;
  }

  public int getTotal() {
    return this.total;
  }

  public QuotationAccountPage setTotal(int total) {
    this.total = total;
    setTotalIsSet(true);
    return this;
  }

  public void unsetTotal() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __TOTAL_ISSET_ID);
  }

  /** Returns true if field total is set (has been assigned a value) and false otherwise */
  public boolean isSetTotal() {
    return EncodingUtils.testBit(__isset_bitfield, __TOTAL_ISSET_ID);
  }

  public void setTotalIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __TOTAL_ISSET_ID, value);
  }

  public int getPageSize() {
    return (this.page == null) ? 0 : this.page.size();
  }

  public java.util.Iterator<QuotationAccount> getPageIterator() {
    return (this.page == null) ? null : this.page.iterator();
  }

  public void addToPage(QuotationAccount elem) {
    if (this.page == null) {
      this.page = new ArrayList<QuotationAccount>();
    }
    this.page.add(elem);
  }

  public List<QuotationAccount> getPage() {
    return this.page;
  }

  public QuotationAccountPage setPage(List<QuotationAccount> page) {
    this.page = page;
    return this;
  }

  public void unsetPage() {
    this.page = null;
  }

  /** Returns true if field page is set (has been assigned a value) and false otherwise */
  public boolean isSetPage() {
    return this.page != null;
  }

  public void setPageIsSet(boolean value) {
    if (!value) {
      this.page = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case TOTAL:
      if (value == null) {
        unsetTotal();
      } else {
        setTotal((Integer)value);
      }
      break;

    case PAGE:
      if (value == null) {
        unsetPage();
      } else {
        setPage((List<QuotationAccount>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case TOTAL:
      return Integer.valueOf(getTotal());

    case PAGE:
      return getPage();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case TOTAL:
      return isSetTotal();
    case PAGE:
      return isSetPage();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof QuotationAccountPage)
      return this.equals((QuotationAccountPage)that);
    return false;
  }

  public boolean equals(QuotationAccountPage that) {
    if (that == null)
      return false;

    boolean this_present_total = true && this.isSetTotal();
    boolean that_present_total = true && that.isSetTotal();
    if (this_present_total || that_present_total) {
      if (!(this_present_total && that_present_total))
        return false;
      if (this.total != that.total)
        return false;
    }

    boolean this_present_page = true && this.isSetPage();
    boolean that_present_page = true && that.isSetPage();
    if (this_present_page || that_present_page) {
      if (!(this_present_page && that_present_page))
        return false;
      if (!this.page.equals(that.page))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(QuotationAccountPage other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetTotal()).compareTo(other.isSetTotal());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTotal()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.total, other.total);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPage()).compareTo(other.isSetPage());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPage()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.page, other.page);
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
    StringBuilder sb = new StringBuilder("QuotationAccountPage(");
    boolean first = true;

    if (isSetTotal()) {
      sb.append("total:");
      sb.append(this.total);
      first = false;
    }
    if (isSetPage()) {
      if (!first) sb.append(", ");
      sb.append("page:");
      if (this.page == null) {
        sb.append("null");
      } else {
        sb.append(this.page);
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

  private static class QuotationAccountPageStandardSchemeFactory implements SchemeFactory {
    public QuotationAccountPageStandardScheme getScheme() {
      return new QuotationAccountPageStandardScheme();
    }
  }

  private static class QuotationAccountPageStandardScheme extends StandardScheme<QuotationAccountPage> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, QuotationAccountPage struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // TOTAL
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.total = iprot.readI32();
              struct.setTotalIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // PAGE
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list96 = iprot.readListBegin();
                struct.page = new ArrayList<QuotationAccount>(_list96.size);
                for (int _i97 = 0; _i97 < _list96.size; ++_i97)
                {
                  QuotationAccount _elem98;
                  _elem98 = new QuotationAccount();
                  _elem98.read(iprot);
                  struct.page.add(_elem98);
                }
                iprot.readListEnd();
              }
              struct.setPageIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, QuotationAccountPage struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.isSetTotal()) {
        oprot.writeFieldBegin(TOTAL_FIELD_DESC);
        oprot.writeI32(struct.total);
        oprot.writeFieldEnd();
      }
      if (struct.page != null) {
        if (struct.isSetPage()) {
          oprot.writeFieldBegin(PAGE_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.page.size()));
            for (QuotationAccount _iter99 : struct.page)
            {
              _iter99.write(oprot);
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

  private static class QuotationAccountPageTupleSchemeFactory implements SchemeFactory {
    public QuotationAccountPageTupleScheme getScheme() {
      return new QuotationAccountPageTupleScheme();
    }
  }

  private static class QuotationAccountPageTupleScheme extends TupleScheme<QuotationAccountPage> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, QuotationAccountPage struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetTotal()) {
        optionals.set(0);
      }
      if (struct.isSetPage()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetTotal()) {
        oprot.writeI32(struct.total);
      }
      if (struct.isSetPage()) {
        {
          oprot.writeI32(struct.page.size());
          for (QuotationAccount _iter100 : struct.page)
          {
            _iter100.write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, QuotationAccountPage struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.total = iprot.readI32();
        struct.setTotalIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TList _list101 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.page = new ArrayList<QuotationAccount>(_list101.size);
          for (int _i102 = 0; _i102 < _list101.size; ++_i102)
          {
            QuotationAccount _elem103;
            _elem103 = new QuotationAccount();
            _elem103.read(iprot);
            struct.page.add(_elem103);
          }
        }
        struct.setPageIsSet(true);
      }
    }
  }

}

