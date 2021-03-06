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

public class PreviewFields implements org.apache.thrift.TBase<PreviewFields, PreviewFields._Fields>, java.io.Serializable, Cloneable, Comparable<PreviewFields> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("PreviewFields");

  private static final org.apache.thrift.protocol.TField ACTIVE_MONTHS_FIELD_DESC = new org.apache.thrift.protocol.TField("activeMonths", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField INACTIVE_MONTHS_FIELD_DESC = new org.apache.thrift.protocol.TField("inactiveMonths", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField ACTIVE_SUBSCRIBE_NUM_FIELD_DESC = new org.apache.thrift.protocol.TField("activeSubscribeNum", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField IN_ACTIVE_SUBSCRIBE_NUM_FIELD_DESC = new org.apache.thrift.protocol.TField("inActiveSubscribeNum", org.apache.thrift.protocol.TType.I32, (short)4);
  private static final org.apache.thrift.protocol.TField BACKUP_COUNTS_FIELD_DESC = new org.apache.thrift.protocol.TField("backupCounts", org.apache.thrift.protocol.TType.I32, (short)5);
  private static final org.apache.thrift.protocol.TField FIXED_CODE_FIELD_DESC = new org.apache.thrift.protocol.TField("fixedCode", org.apache.thrift.protocol.TType.STRING, (short)6);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new PreviewFieldsStandardSchemeFactory());
    schemes.put(TupleScheme.class, new PreviewFieldsTupleSchemeFactory());
  }

  public String activeMonths; // optional
  public String inactiveMonths; // optional
  public int activeSubscribeNum; // optional
  public int inActiveSubscribeNum; // optional
  public int backupCounts; // optional
  public String fixedCode; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ACTIVE_MONTHS((short)1, "activeMonths"),
    INACTIVE_MONTHS((short)2, "inactiveMonths"),
    ACTIVE_SUBSCRIBE_NUM((short)3, "activeSubscribeNum"),
    IN_ACTIVE_SUBSCRIBE_NUM((short)4, "inActiveSubscribeNum"),
    BACKUP_COUNTS((short)5, "backupCounts"),
    FIXED_CODE((short)6, "fixedCode");

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
        case 1: // ACTIVE_MONTHS
          return ACTIVE_MONTHS;
        case 2: // INACTIVE_MONTHS
          return INACTIVE_MONTHS;
        case 3: // ACTIVE_SUBSCRIBE_NUM
          return ACTIVE_SUBSCRIBE_NUM;
        case 4: // IN_ACTIVE_SUBSCRIBE_NUM
          return IN_ACTIVE_SUBSCRIBE_NUM;
        case 5: // BACKUP_COUNTS
          return BACKUP_COUNTS;
        case 6: // FIXED_CODE
          return FIXED_CODE;
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
  private static final int __ACTIVESUBSCRIBENUM_ISSET_ID = 0;
  private static final int __INACTIVESUBSCRIBENUM_ISSET_ID = 1;
  private static final int __BACKUPCOUNTS_ISSET_ID = 2;
  private byte __isset_bitfield = 0;
  private _Fields optionals[] = {_Fields.ACTIVE_MONTHS,_Fields.INACTIVE_MONTHS,_Fields.ACTIVE_SUBSCRIBE_NUM,_Fields.IN_ACTIVE_SUBSCRIBE_NUM,_Fields.BACKUP_COUNTS,_Fields.FIXED_CODE};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ACTIVE_MONTHS, new org.apache.thrift.meta_data.FieldMetaData("activeMonths", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.INACTIVE_MONTHS, new org.apache.thrift.meta_data.FieldMetaData("inactiveMonths", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.ACTIVE_SUBSCRIBE_NUM, new org.apache.thrift.meta_data.FieldMetaData("activeSubscribeNum", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.IN_ACTIVE_SUBSCRIBE_NUM, new org.apache.thrift.meta_data.FieldMetaData("inActiveSubscribeNum", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.BACKUP_COUNTS, new org.apache.thrift.meta_data.FieldMetaData("backupCounts", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.FIXED_CODE, new org.apache.thrift.meta_data.FieldMetaData("fixedCode", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(PreviewFields.class, metaDataMap);
  }

  public PreviewFields() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public PreviewFields(PreviewFields other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetActiveMonths()) {
      this.activeMonths = other.activeMonths;
    }
    if (other.isSetInactiveMonths()) {
      this.inactiveMonths = other.inactiveMonths;
    }
    this.activeSubscribeNum = other.activeSubscribeNum;
    this.inActiveSubscribeNum = other.inActiveSubscribeNum;
    this.backupCounts = other.backupCounts;
    if (other.isSetFixedCode()) {
      this.fixedCode = other.fixedCode;
    }
  }

  public PreviewFields deepCopy() {
    return new PreviewFields(this);
  }

  @Override
  public void clear() {
    this.activeMonths = null;
    this.inactiveMonths = null;
    setActiveSubscribeNumIsSet(false);
    this.activeSubscribeNum = 0;
    setInActiveSubscribeNumIsSet(false);
    this.inActiveSubscribeNum = 0;
    setBackupCountsIsSet(false);
    this.backupCounts = 0;
    this.fixedCode = null;
  }

  public String getActiveMonths() {
    return this.activeMonths;
  }

  public PreviewFields setActiveMonths(String activeMonths) {
    this.activeMonths = activeMonths;
    return this;
  }

  public void unsetActiveMonths() {
    this.activeMonths = null;
  }

  /** Returns true if field activeMonths is set (has been assigned a value) and false otherwise */
  public boolean isSetActiveMonths() {
    return this.activeMonths != null;
  }

  public void setActiveMonthsIsSet(boolean value) {
    if (!value) {
      this.activeMonths = null;
    }
  }

  public String getInactiveMonths() {
    return this.inactiveMonths;
  }

  public PreviewFields setInactiveMonths(String inactiveMonths) {
    this.inactiveMonths = inactiveMonths;
    return this;
  }

  public void unsetInactiveMonths() {
    this.inactiveMonths = null;
  }

  /** Returns true if field inactiveMonths is set (has been assigned a value) and false otherwise */
  public boolean isSetInactiveMonths() {
    return this.inactiveMonths != null;
  }

  public void setInactiveMonthsIsSet(boolean value) {
    if (!value) {
      this.inactiveMonths = null;
    }
  }

  public int getActiveSubscribeNum() {
    return this.activeSubscribeNum;
  }

  public PreviewFields setActiveSubscribeNum(int activeSubscribeNum) {
    this.activeSubscribeNum = activeSubscribeNum;
    setActiveSubscribeNumIsSet(true);
    return this;
  }

  public void unsetActiveSubscribeNum() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ACTIVESUBSCRIBENUM_ISSET_ID);
  }

  /** Returns true if field activeSubscribeNum is set (has been assigned a value) and false otherwise */
  public boolean isSetActiveSubscribeNum() {
    return EncodingUtils.testBit(__isset_bitfield, __ACTIVESUBSCRIBENUM_ISSET_ID);
  }

  public void setActiveSubscribeNumIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ACTIVESUBSCRIBENUM_ISSET_ID, value);
  }

  public int getInActiveSubscribeNum() {
    return this.inActiveSubscribeNum;
  }

  public PreviewFields setInActiveSubscribeNum(int inActiveSubscribeNum) {
    this.inActiveSubscribeNum = inActiveSubscribeNum;
    setInActiveSubscribeNumIsSet(true);
    return this;
  }

  public void unsetInActiveSubscribeNum() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __INACTIVESUBSCRIBENUM_ISSET_ID);
  }

  /** Returns true if field inActiveSubscribeNum is set (has been assigned a value) and false otherwise */
  public boolean isSetInActiveSubscribeNum() {
    return EncodingUtils.testBit(__isset_bitfield, __INACTIVESUBSCRIBENUM_ISSET_ID);
  }

  public void setInActiveSubscribeNumIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __INACTIVESUBSCRIBENUM_ISSET_ID, value);
  }

  public int getBackupCounts() {
    return this.backupCounts;
  }

  public PreviewFields setBackupCounts(int backupCounts) {
    this.backupCounts = backupCounts;
    setBackupCountsIsSet(true);
    return this;
  }

  public void unsetBackupCounts() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __BACKUPCOUNTS_ISSET_ID);
  }

  /** Returns true if field backupCounts is set (has been assigned a value) and false otherwise */
  public boolean isSetBackupCounts() {
    return EncodingUtils.testBit(__isset_bitfield, __BACKUPCOUNTS_ISSET_ID);
  }

  public void setBackupCountsIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __BACKUPCOUNTS_ISSET_ID, value);
  }

  public String getFixedCode() {
    return this.fixedCode;
  }

  public PreviewFields setFixedCode(String fixedCode) {
    this.fixedCode = fixedCode;
    return this;
  }

  public void unsetFixedCode() {
    this.fixedCode = null;
  }

  /** Returns true if field fixedCode is set (has been assigned a value) and false otherwise */
  public boolean isSetFixedCode() {
    return this.fixedCode != null;
  }

  public void setFixedCodeIsSet(boolean value) {
    if (!value) {
      this.fixedCode = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case ACTIVE_MONTHS:
      if (value == null) {
        unsetActiveMonths();
      } else {
        setActiveMonths((String)value);
      }
      break;

    case INACTIVE_MONTHS:
      if (value == null) {
        unsetInactiveMonths();
      } else {
        setInactiveMonths((String)value);
      }
      break;

    case ACTIVE_SUBSCRIBE_NUM:
      if (value == null) {
        unsetActiveSubscribeNum();
      } else {
        setActiveSubscribeNum((Integer)value);
      }
      break;

    case IN_ACTIVE_SUBSCRIBE_NUM:
      if (value == null) {
        unsetInActiveSubscribeNum();
      } else {
        setInActiveSubscribeNum((Integer)value);
      }
      break;

    case BACKUP_COUNTS:
      if (value == null) {
        unsetBackupCounts();
      } else {
        setBackupCounts((Integer)value);
      }
      break;

    case FIXED_CODE:
      if (value == null) {
        unsetFixedCode();
      } else {
        setFixedCode((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case ACTIVE_MONTHS:
      return getActiveMonths();

    case INACTIVE_MONTHS:
      return getInactiveMonths();

    case ACTIVE_SUBSCRIBE_NUM:
      return Integer.valueOf(getActiveSubscribeNum());

    case IN_ACTIVE_SUBSCRIBE_NUM:
      return Integer.valueOf(getInActiveSubscribeNum());

    case BACKUP_COUNTS:
      return Integer.valueOf(getBackupCounts());

    case FIXED_CODE:
      return getFixedCode();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case ACTIVE_MONTHS:
      return isSetActiveMonths();
    case INACTIVE_MONTHS:
      return isSetInactiveMonths();
    case ACTIVE_SUBSCRIBE_NUM:
      return isSetActiveSubscribeNum();
    case IN_ACTIVE_SUBSCRIBE_NUM:
      return isSetInActiveSubscribeNum();
    case BACKUP_COUNTS:
      return isSetBackupCounts();
    case FIXED_CODE:
      return isSetFixedCode();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof PreviewFields)
      return this.equals((PreviewFields)that);
    return false;
  }

  public boolean equals(PreviewFields that) {
    if (that == null)
      return false;

    boolean this_present_activeMonths = true && this.isSetActiveMonths();
    boolean that_present_activeMonths = true && that.isSetActiveMonths();
    if (this_present_activeMonths || that_present_activeMonths) {
      if (!(this_present_activeMonths && that_present_activeMonths))
        return false;
      if (!this.activeMonths.equals(that.activeMonths))
        return false;
    }

    boolean this_present_inactiveMonths = true && this.isSetInactiveMonths();
    boolean that_present_inactiveMonths = true && that.isSetInactiveMonths();
    if (this_present_inactiveMonths || that_present_inactiveMonths) {
      if (!(this_present_inactiveMonths && that_present_inactiveMonths))
        return false;
      if (!this.inactiveMonths.equals(that.inactiveMonths))
        return false;
    }

    boolean this_present_activeSubscribeNum = true && this.isSetActiveSubscribeNum();
    boolean that_present_activeSubscribeNum = true && that.isSetActiveSubscribeNum();
    if (this_present_activeSubscribeNum || that_present_activeSubscribeNum) {
      if (!(this_present_activeSubscribeNum && that_present_activeSubscribeNum))
        return false;
      if (this.activeSubscribeNum != that.activeSubscribeNum)
        return false;
    }

    boolean this_present_inActiveSubscribeNum = true && this.isSetInActiveSubscribeNum();
    boolean that_present_inActiveSubscribeNum = true && that.isSetInActiveSubscribeNum();
    if (this_present_inActiveSubscribeNum || that_present_inActiveSubscribeNum) {
      if (!(this_present_inActiveSubscribeNum && that_present_inActiveSubscribeNum))
        return false;
      if (this.inActiveSubscribeNum != that.inActiveSubscribeNum)
        return false;
    }

    boolean this_present_backupCounts = true && this.isSetBackupCounts();
    boolean that_present_backupCounts = true && that.isSetBackupCounts();
    if (this_present_backupCounts || that_present_backupCounts) {
      if (!(this_present_backupCounts && that_present_backupCounts))
        return false;
      if (this.backupCounts != that.backupCounts)
        return false;
    }

    boolean this_present_fixedCode = true && this.isSetFixedCode();
    boolean that_present_fixedCode = true && that.isSetFixedCode();
    if (this_present_fixedCode || that_present_fixedCode) {
      if (!(this_present_fixedCode && that_present_fixedCode))
        return false;
      if (!this.fixedCode.equals(that.fixedCode))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(PreviewFields other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetActiveMonths()).compareTo(other.isSetActiveMonths());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetActiveMonths()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.activeMonths, other.activeMonths);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetInactiveMonths()).compareTo(other.isSetInactiveMonths());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetInactiveMonths()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.inactiveMonths, other.inactiveMonths);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetActiveSubscribeNum()).compareTo(other.isSetActiveSubscribeNum());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetActiveSubscribeNum()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.activeSubscribeNum, other.activeSubscribeNum);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetInActiveSubscribeNum()).compareTo(other.isSetInActiveSubscribeNum());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetInActiveSubscribeNum()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.inActiveSubscribeNum, other.inActiveSubscribeNum);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetBackupCounts()).compareTo(other.isSetBackupCounts());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBackupCounts()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.backupCounts, other.backupCounts);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetFixedCode()).compareTo(other.isSetFixedCode());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFixedCode()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.fixedCode, other.fixedCode);
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
    StringBuilder sb = new StringBuilder("PreviewFields(");
    boolean first = true;

    if (isSetActiveMonths()) {
      sb.append("activeMonths:");
      if (this.activeMonths == null) {
        sb.append("null");
      } else {
        sb.append(this.activeMonths);
      }
      first = false;
    }
    if (isSetInactiveMonths()) {
      if (!first) sb.append(", ");
      sb.append("inactiveMonths:");
      if (this.inactiveMonths == null) {
        sb.append("null");
      } else {
        sb.append(this.inactiveMonths);
      }
      first = false;
    }
    if (isSetActiveSubscribeNum()) {
      if (!first) sb.append(", ");
      sb.append("activeSubscribeNum:");
      sb.append(this.activeSubscribeNum);
      first = false;
    }
    if (isSetInActiveSubscribeNum()) {
      if (!first) sb.append(", ");
      sb.append("inActiveSubscribeNum:");
      sb.append(this.inActiveSubscribeNum);
      first = false;
    }
    if (isSetBackupCounts()) {
      if (!first) sb.append(", ");
      sb.append("backupCounts:");
      sb.append(this.backupCounts);
      first = false;
    }
    if (isSetFixedCode()) {
      if (!first) sb.append(", ");
      sb.append("fixedCode:");
      if (this.fixedCode == null) {
        sb.append("null");
      } else {
        sb.append(this.fixedCode);
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

  private static class PreviewFieldsStandardSchemeFactory implements SchemeFactory {
    public PreviewFieldsStandardScheme getScheme() {
      return new PreviewFieldsStandardScheme();
    }
  }

  private static class PreviewFieldsStandardScheme extends StandardScheme<PreviewFields> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, PreviewFields struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ACTIVE_MONTHS
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.activeMonths = iprot.readString();
              struct.setActiveMonthsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // INACTIVE_MONTHS
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.inactiveMonths = iprot.readString();
              struct.setInactiveMonthsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // ACTIVE_SUBSCRIBE_NUM
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.activeSubscribeNum = iprot.readI32();
              struct.setActiveSubscribeNumIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // IN_ACTIVE_SUBSCRIBE_NUM
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.inActiveSubscribeNum = iprot.readI32();
              struct.setInActiveSubscribeNumIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // BACKUP_COUNTS
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.backupCounts = iprot.readI32();
              struct.setBackupCountsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // FIXED_CODE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.fixedCode = iprot.readString();
              struct.setFixedCodeIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, PreviewFields struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.activeMonths != null) {
        if (struct.isSetActiveMonths()) {
          oprot.writeFieldBegin(ACTIVE_MONTHS_FIELD_DESC);
          oprot.writeString(struct.activeMonths);
          oprot.writeFieldEnd();
        }
      }
      if (struct.inactiveMonths != null) {
        if (struct.isSetInactiveMonths()) {
          oprot.writeFieldBegin(INACTIVE_MONTHS_FIELD_DESC);
          oprot.writeString(struct.inactiveMonths);
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetActiveSubscribeNum()) {
        oprot.writeFieldBegin(ACTIVE_SUBSCRIBE_NUM_FIELD_DESC);
        oprot.writeI32(struct.activeSubscribeNum);
        oprot.writeFieldEnd();
      }
      if (struct.isSetInActiveSubscribeNum()) {
        oprot.writeFieldBegin(IN_ACTIVE_SUBSCRIBE_NUM_FIELD_DESC);
        oprot.writeI32(struct.inActiveSubscribeNum);
        oprot.writeFieldEnd();
      }
      if (struct.isSetBackupCounts()) {
        oprot.writeFieldBegin(BACKUP_COUNTS_FIELD_DESC);
        oprot.writeI32(struct.backupCounts);
        oprot.writeFieldEnd();
      }
      if (struct.fixedCode != null) {
        if (struct.isSetFixedCode()) {
          oprot.writeFieldBegin(FIXED_CODE_FIELD_DESC);
          oprot.writeString(struct.fixedCode);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class PreviewFieldsTupleSchemeFactory implements SchemeFactory {
    public PreviewFieldsTupleScheme getScheme() {
      return new PreviewFieldsTupleScheme();
    }
  }

  private static class PreviewFieldsTupleScheme extends TupleScheme<PreviewFields> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, PreviewFields struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetActiveMonths()) {
        optionals.set(0);
      }
      if (struct.isSetInactiveMonths()) {
        optionals.set(1);
      }
      if (struct.isSetActiveSubscribeNum()) {
        optionals.set(2);
      }
      if (struct.isSetInActiveSubscribeNum()) {
        optionals.set(3);
      }
      if (struct.isSetBackupCounts()) {
        optionals.set(4);
      }
      if (struct.isSetFixedCode()) {
        optionals.set(5);
      }
      oprot.writeBitSet(optionals, 6);
      if (struct.isSetActiveMonths()) {
        oprot.writeString(struct.activeMonths);
      }
      if (struct.isSetInactiveMonths()) {
        oprot.writeString(struct.inactiveMonths);
      }
      if (struct.isSetActiveSubscribeNum()) {
        oprot.writeI32(struct.activeSubscribeNum);
      }
      if (struct.isSetInActiveSubscribeNum()) {
        oprot.writeI32(struct.inActiveSubscribeNum);
      }
      if (struct.isSetBackupCounts()) {
        oprot.writeI32(struct.backupCounts);
      }
      if (struct.isSetFixedCode()) {
        oprot.writeString(struct.fixedCode);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, PreviewFields struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(6);
      if (incoming.get(0)) {
        struct.activeMonths = iprot.readString();
        struct.setActiveMonthsIsSet(true);
      }
      if (incoming.get(1)) {
        struct.inactiveMonths = iprot.readString();
        struct.setInactiveMonthsIsSet(true);
      }
      if (incoming.get(2)) {
        struct.activeSubscribeNum = iprot.readI32();
        struct.setActiveSubscribeNumIsSet(true);
      }
      if (incoming.get(3)) {
        struct.inActiveSubscribeNum = iprot.readI32();
        struct.setInActiveSubscribeNumIsSet(true);
      }
      if (incoming.get(4)) {
        struct.backupCounts = iprot.readI32();
        struct.setBackupCountsIsSet(true);
      }
      if (incoming.get(5)) {
        struct.fixedCode = iprot.readString();
        struct.setFixedCodeIsSet(true);
      }
    }
  }

}

