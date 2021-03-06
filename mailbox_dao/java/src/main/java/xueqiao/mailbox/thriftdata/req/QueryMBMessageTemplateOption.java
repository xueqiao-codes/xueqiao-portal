/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package xueqiao.mailbox.thriftdata.req;

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
 * 查询信箱消息条件
 */
public class QueryMBMessageTemplateOption implements org.apache.thrift.TBase<QueryMBMessageTemplateOption, QueryMBMessageTemplateOption._Fields>, java.io.Serializable, Cloneable, Comparable<QueryMBMessageTemplateOption> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("QueryMBMessageTemplateOption");

  private static final org.apache.thrift.protocol.TField TEMPLATE_ID_SET_FIELD_DESC = new org.apache.thrift.protocol.TField("templateIdSet", org.apache.thrift.protocol.TType.SET, (short)1);
  private static final org.apache.thrift.protocol.TField TEMPLATE_NAME_PARTIAL_FIELD_DESC = new org.apache.thrift.protocol.TField("templateNamePartial", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField CHANNEL_FIELD_DESC = new org.apache.thrift.protocol.TField("channel", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("type", org.apache.thrift.protocol.TType.I32, (short)4);
  private static final org.apache.thrift.protocol.TField LEVEL_FIELD_DESC = new org.apache.thrift.protocol.TField("level", org.apache.thrift.protocol.TType.I32, (short)5);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new QueryMBMessageTemplateOptionStandardSchemeFactory());
    schemes.put(TupleScheme.class, new QueryMBMessageTemplateOptionTupleSchemeFactory());
  }

  public Set<Long> templateIdSet; // optional
  public String templateNamePartial; // optional
  /**
   * 
   * @see xueqiao.mailbox.thriftdata.mb.MSendingChannel
   */
  public xueqiao.mailbox.thriftdata.mb.MSendingChannel channel; // optional
  /**
   * 
   * @see xueqiao.mailbox.thriftdata.message.MType
   */
  public xueqiao.mailbox.thriftdata.message.MType type; // optional
  /**
   * 
   * @see xueqiao.mailbox.thriftdata.message.MLevel
   */
  public xueqiao.mailbox.thriftdata.message.MLevel level; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    TEMPLATE_ID_SET((short)1, "templateIdSet"),
    TEMPLATE_NAME_PARTIAL((short)2, "templateNamePartial"),
    /**
     * 
     * @see xueqiao.mailbox.thriftdata.mb.MSendingChannel
     */
    CHANNEL((short)3, "channel"),
    /**
     * 
     * @see xueqiao.mailbox.thriftdata.message.MType
     */
    TYPE((short)4, "type"),
    /**
     * 
     * @see xueqiao.mailbox.thriftdata.message.MLevel
     */
    LEVEL((short)5, "level");

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
        case 1: // TEMPLATE_ID_SET
          return TEMPLATE_ID_SET;
        case 2: // TEMPLATE_NAME_PARTIAL
          return TEMPLATE_NAME_PARTIAL;
        case 3: // CHANNEL
          return CHANNEL;
        case 4: // TYPE
          return TYPE;
        case 5: // LEVEL
          return LEVEL;
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
  private _Fields optionals[] = {_Fields.TEMPLATE_ID_SET,_Fields.TEMPLATE_NAME_PARTIAL,_Fields.CHANNEL,_Fields.TYPE,_Fields.LEVEL};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TEMPLATE_ID_SET, new org.apache.thrift.meta_data.FieldMetaData("templateIdSet", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.SetMetaData(org.apache.thrift.protocol.TType.SET, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64))));
    tmpMap.put(_Fields.TEMPLATE_NAME_PARTIAL, new org.apache.thrift.meta_data.FieldMetaData("templateNamePartial", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.CHANNEL, new org.apache.thrift.meta_data.FieldMetaData("channel", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, xueqiao.mailbox.thriftdata.mb.MSendingChannel.class)));
    tmpMap.put(_Fields.TYPE, new org.apache.thrift.meta_data.FieldMetaData("type", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, xueqiao.mailbox.thriftdata.message.MType.class)));
    tmpMap.put(_Fields.LEVEL, new org.apache.thrift.meta_data.FieldMetaData("level", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, xueqiao.mailbox.thriftdata.message.MLevel.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(QueryMBMessageTemplateOption.class, metaDataMap);
  }

  public QueryMBMessageTemplateOption() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public QueryMBMessageTemplateOption(QueryMBMessageTemplateOption other) {
    if (other.isSetTemplateIdSet()) {
      Set<Long> __this__templateIdSet = new HashSet<Long>(other.templateIdSet);
      this.templateIdSet = __this__templateIdSet;
    }
    if (other.isSetTemplateNamePartial()) {
      this.templateNamePartial = other.templateNamePartial;
    }
    if (other.isSetChannel()) {
      this.channel = other.channel;
    }
    if (other.isSetType()) {
      this.type = other.type;
    }
    if (other.isSetLevel()) {
      this.level = other.level;
    }
  }

  public QueryMBMessageTemplateOption deepCopy() {
    return new QueryMBMessageTemplateOption(this);
  }

  @Override
  public void clear() {
    this.templateIdSet = null;
    this.templateNamePartial = null;
    this.channel = null;
    this.type = null;
    this.level = null;
  }

  public int getTemplateIdSetSize() {
    return (this.templateIdSet == null) ? 0 : this.templateIdSet.size();
  }

  public java.util.Iterator<Long> getTemplateIdSetIterator() {
    return (this.templateIdSet == null) ? null : this.templateIdSet.iterator();
  }

  public void addToTemplateIdSet(long elem) {
    if (this.templateIdSet == null) {
      this.templateIdSet = new HashSet<Long>();
    }
    this.templateIdSet.add(elem);
  }

  public Set<Long> getTemplateIdSet() {
    return this.templateIdSet;
  }

  public QueryMBMessageTemplateOption setTemplateIdSet(Set<Long> templateIdSet) {
    this.templateIdSet = templateIdSet;
    return this;
  }

  public void unsetTemplateIdSet() {
    this.templateIdSet = null;
  }

  /** Returns true if field templateIdSet is set (has been assigned a value) and false otherwise */
  public boolean isSetTemplateIdSet() {
    return this.templateIdSet != null;
  }

  public void setTemplateIdSetIsSet(boolean value) {
    if (!value) {
      this.templateIdSet = null;
    }
  }

  public String getTemplateNamePartial() {
    return this.templateNamePartial;
  }

  public QueryMBMessageTemplateOption setTemplateNamePartial(String templateNamePartial) {
    this.templateNamePartial = templateNamePartial;
    return this;
  }

  public void unsetTemplateNamePartial() {
    this.templateNamePartial = null;
  }

  /** Returns true if field templateNamePartial is set (has been assigned a value) and false otherwise */
  public boolean isSetTemplateNamePartial() {
    return this.templateNamePartial != null;
  }

  public void setTemplateNamePartialIsSet(boolean value) {
    if (!value) {
      this.templateNamePartial = null;
    }
  }

  /**
   * 
   * @see xueqiao.mailbox.thriftdata.mb.MSendingChannel
   */
  public xueqiao.mailbox.thriftdata.mb.MSendingChannel getChannel() {
    return this.channel;
  }

  /**
   * 
   * @see xueqiao.mailbox.thriftdata.mb.MSendingChannel
   */
  public QueryMBMessageTemplateOption setChannel(xueqiao.mailbox.thriftdata.mb.MSendingChannel channel) {
    this.channel = channel;
    return this;
  }

  public void unsetChannel() {
    this.channel = null;
  }

  /** Returns true if field channel is set (has been assigned a value) and false otherwise */
  public boolean isSetChannel() {
    return this.channel != null;
  }

  public void setChannelIsSet(boolean value) {
    if (!value) {
      this.channel = null;
    }
  }

  /**
   * 
   * @see xueqiao.mailbox.thriftdata.message.MType
   */
  public xueqiao.mailbox.thriftdata.message.MType getType() {
    return this.type;
  }

  /**
   * 
   * @see xueqiao.mailbox.thriftdata.message.MType
   */
  public QueryMBMessageTemplateOption setType(xueqiao.mailbox.thriftdata.message.MType type) {
    this.type = type;
    return this;
  }

  public void unsetType() {
    this.type = null;
  }

  /** Returns true if field type is set (has been assigned a value) and false otherwise */
  public boolean isSetType() {
    return this.type != null;
  }

  public void setTypeIsSet(boolean value) {
    if (!value) {
      this.type = null;
    }
  }

  /**
   * 
   * @see xueqiao.mailbox.thriftdata.message.MLevel
   */
  public xueqiao.mailbox.thriftdata.message.MLevel getLevel() {
    return this.level;
  }

  /**
   * 
   * @see xueqiao.mailbox.thriftdata.message.MLevel
   */
  public QueryMBMessageTemplateOption setLevel(xueqiao.mailbox.thriftdata.message.MLevel level) {
    this.level = level;
    return this;
  }

  public void unsetLevel() {
    this.level = null;
  }

  /** Returns true if field level is set (has been assigned a value) and false otherwise */
  public boolean isSetLevel() {
    return this.level != null;
  }

  public void setLevelIsSet(boolean value) {
    if (!value) {
      this.level = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case TEMPLATE_ID_SET:
      if (value == null) {
        unsetTemplateIdSet();
      } else {
        setTemplateIdSet((Set<Long>)value);
      }
      break;

    case TEMPLATE_NAME_PARTIAL:
      if (value == null) {
        unsetTemplateNamePartial();
      } else {
        setTemplateNamePartial((String)value);
      }
      break;

    case CHANNEL:
      if (value == null) {
        unsetChannel();
      } else {
        setChannel((xueqiao.mailbox.thriftdata.mb.MSendingChannel)value);
      }
      break;

    case TYPE:
      if (value == null) {
        unsetType();
      } else {
        setType((xueqiao.mailbox.thriftdata.message.MType)value);
      }
      break;

    case LEVEL:
      if (value == null) {
        unsetLevel();
      } else {
        setLevel((xueqiao.mailbox.thriftdata.message.MLevel)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case TEMPLATE_ID_SET:
      return getTemplateIdSet();

    case TEMPLATE_NAME_PARTIAL:
      return getTemplateNamePartial();

    case CHANNEL:
      return getChannel();

    case TYPE:
      return getType();

    case LEVEL:
      return getLevel();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case TEMPLATE_ID_SET:
      return isSetTemplateIdSet();
    case TEMPLATE_NAME_PARTIAL:
      return isSetTemplateNamePartial();
    case CHANNEL:
      return isSetChannel();
    case TYPE:
      return isSetType();
    case LEVEL:
      return isSetLevel();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof QueryMBMessageTemplateOption)
      return this.equals((QueryMBMessageTemplateOption)that);
    return false;
  }

  public boolean equals(QueryMBMessageTemplateOption that) {
    if (that == null)
      return false;

    boolean this_present_templateIdSet = true && this.isSetTemplateIdSet();
    boolean that_present_templateIdSet = true && that.isSetTemplateIdSet();
    if (this_present_templateIdSet || that_present_templateIdSet) {
      if (!(this_present_templateIdSet && that_present_templateIdSet))
        return false;
      if (!this.templateIdSet.equals(that.templateIdSet))
        return false;
    }

    boolean this_present_templateNamePartial = true && this.isSetTemplateNamePartial();
    boolean that_present_templateNamePartial = true && that.isSetTemplateNamePartial();
    if (this_present_templateNamePartial || that_present_templateNamePartial) {
      if (!(this_present_templateNamePartial && that_present_templateNamePartial))
        return false;
      if (!this.templateNamePartial.equals(that.templateNamePartial))
        return false;
    }

    boolean this_present_channel = true && this.isSetChannel();
    boolean that_present_channel = true && that.isSetChannel();
    if (this_present_channel || that_present_channel) {
      if (!(this_present_channel && that_present_channel))
        return false;
      if (!this.channel.equals(that.channel))
        return false;
    }

    boolean this_present_type = true && this.isSetType();
    boolean that_present_type = true && that.isSetType();
    if (this_present_type || that_present_type) {
      if (!(this_present_type && that_present_type))
        return false;
      if (!this.type.equals(that.type))
        return false;
    }

    boolean this_present_level = true && this.isSetLevel();
    boolean that_present_level = true && that.isSetLevel();
    if (this_present_level || that_present_level) {
      if (!(this_present_level && that_present_level))
        return false;
      if (!this.level.equals(that.level))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(QueryMBMessageTemplateOption other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetTemplateIdSet()).compareTo(other.isSetTemplateIdSet());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTemplateIdSet()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.templateIdSet, other.templateIdSet);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTemplateNamePartial()).compareTo(other.isSetTemplateNamePartial());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTemplateNamePartial()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.templateNamePartial, other.templateNamePartial);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetChannel()).compareTo(other.isSetChannel());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetChannel()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.channel, other.channel);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetType()).compareTo(other.isSetType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.type, other.type);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetLevel()).compareTo(other.isSetLevel());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLevel()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.level, other.level);
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
    StringBuilder sb = new StringBuilder("QueryMBMessageTemplateOption(");
    boolean first = true;

    if (isSetTemplateIdSet()) {
      sb.append("templateIdSet:");
      if (this.templateIdSet == null) {
        sb.append("null");
      } else {
        sb.append(this.templateIdSet);
      }
      first = false;
    }
    if (isSetTemplateNamePartial()) {
      if (!first) sb.append(", ");
      sb.append("templateNamePartial:");
      if (this.templateNamePartial == null) {
        sb.append("null");
      } else {
        sb.append(this.templateNamePartial);
      }
      first = false;
    }
    if (isSetChannel()) {
      if (!first) sb.append(", ");
      sb.append("channel:");
      if (this.channel == null) {
        sb.append("null");
      } else {
        sb.append(this.channel);
      }
      first = false;
    }
    if (isSetType()) {
      if (!first) sb.append(", ");
      sb.append("type:");
      if (this.type == null) {
        sb.append("null");
      } else {
        sb.append(this.type);
      }
      first = false;
    }
    if (isSetLevel()) {
      if (!first) sb.append(", ");
      sb.append("level:");
      if (this.level == null) {
        sb.append("null");
      } else {
        sb.append(this.level);
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

  private static class QueryMBMessageTemplateOptionStandardSchemeFactory implements SchemeFactory {
    public QueryMBMessageTemplateOptionStandardScheme getScheme() {
      return new QueryMBMessageTemplateOptionStandardScheme();
    }
  }

  private static class QueryMBMessageTemplateOptionStandardScheme extends StandardScheme<QueryMBMessageTemplateOption> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, QueryMBMessageTemplateOption struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // TEMPLATE_ID_SET
            if (schemeField.type == org.apache.thrift.protocol.TType.SET) {
              {
                org.apache.thrift.protocol.TSet _set72 = iprot.readSetBegin();
                struct.templateIdSet = new HashSet<Long>(2*_set72.size);
                for (int _i73 = 0; _i73 < _set72.size; ++_i73)
                {
                  long _elem74;
                  _elem74 = iprot.readI64();
                  struct.templateIdSet.add(_elem74);
                }
                iprot.readSetEnd();
              }
              struct.setTemplateIdSetIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // TEMPLATE_NAME_PARTIAL
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.templateNamePartial = iprot.readString();
              struct.setTemplateNamePartialIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // CHANNEL
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.channel = xueqiao.mailbox.thriftdata.mb.MSendingChannel.findByValue(iprot.readI32());
              struct.setChannelIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.type = xueqiao.mailbox.thriftdata.message.MType.findByValue(iprot.readI32());
              struct.setTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // LEVEL
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.level = xueqiao.mailbox.thriftdata.message.MLevel.findByValue(iprot.readI32());
              struct.setLevelIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, QueryMBMessageTemplateOption struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.templateIdSet != null) {
        if (struct.isSetTemplateIdSet()) {
          oprot.writeFieldBegin(TEMPLATE_ID_SET_FIELD_DESC);
          {
            oprot.writeSetBegin(new org.apache.thrift.protocol.TSet(org.apache.thrift.protocol.TType.I64, struct.templateIdSet.size()));
            for (long _iter75 : struct.templateIdSet)
            {
              oprot.writeI64(_iter75);
            }
            oprot.writeSetEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.templateNamePartial != null) {
        if (struct.isSetTemplateNamePartial()) {
          oprot.writeFieldBegin(TEMPLATE_NAME_PARTIAL_FIELD_DESC);
          oprot.writeString(struct.templateNamePartial);
          oprot.writeFieldEnd();
        }
      }
      if (struct.channel != null) {
        if (struct.isSetChannel()) {
          oprot.writeFieldBegin(CHANNEL_FIELD_DESC);
          oprot.writeI32(struct.channel.getValue());
          oprot.writeFieldEnd();
        }
      }
      if (struct.type != null) {
        if (struct.isSetType()) {
          oprot.writeFieldBegin(TYPE_FIELD_DESC);
          oprot.writeI32(struct.type.getValue());
          oprot.writeFieldEnd();
        }
      }
      if (struct.level != null) {
        if (struct.isSetLevel()) {
          oprot.writeFieldBegin(LEVEL_FIELD_DESC);
          oprot.writeI32(struct.level.getValue());
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class QueryMBMessageTemplateOptionTupleSchemeFactory implements SchemeFactory {
    public QueryMBMessageTemplateOptionTupleScheme getScheme() {
      return new QueryMBMessageTemplateOptionTupleScheme();
    }
  }

  private static class QueryMBMessageTemplateOptionTupleScheme extends TupleScheme<QueryMBMessageTemplateOption> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, QueryMBMessageTemplateOption struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetTemplateIdSet()) {
        optionals.set(0);
      }
      if (struct.isSetTemplateNamePartial()) {
        optionals.set(1);
      }
      if (struct.isSetChannel()) {
        optionals.set(2);
      }
      if (struct.isSetType()) {
        optionals.set(3);
      }
      if (struct.isSetLevel()) {
        optionals.set(4);
      }
      oprot.writeBitSet(optionals, 5);
      if (struct.isSetTemplateIdSet()) {
        {
          oprot.writeI32(struct.templateIdSet.size());
          for (long _iter76 : struct.templateIdSet)
          {
            oprot.writeI64(_iter76);
          }
        }
      }
      if (struct.isSetTemplateNamePartial()) {
        oprot.writeString(struct.templateNamePartial);
      }
      if (struct.isSetChannel()) {
        oprot.writeI32(struct.channel.getValue());
      }
      if (struct.isSetType()) {
        oprot.writeI32(struct.type.getValue());
      }
      if (struct.isSetLevel()) {
        oprot.writeI32(struct.level.getValue());
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, QueryMBMessageTemplateOption struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(5);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TSet _set77 = new org.apache.thrift.protocol.TSet(org.apache.thrift.protocol.TType.I64, iprot.readI32());
          struct.templateIdSet = new HashSet<Long>(2*_set77.size);
          for (int _i78 = 0; _i78 < _set77.size; ++_i78)
          {
            long _elem79;
            _elem79 = iprot.readI64();
            struct.templateIdSet.add(_elem79);
          }
        }
        struct.setTemplateIdSetIsSet(true);
      }
      if (incoming.get(1)) {
        struct.templateNamePartial = iprot.readString();
        struct.setTemplateNamePartialIsSet(true);
      }
      if (incoming.get(2)) {
        struct.channel = xueqiao.mailbox.thriftdata.mb.MSendingChannel.findByValue(iprot.readI32());
        struct.setChannelIsSet(true);
      }
      if (incoming.get(3)) {
        struct.type = xueqiao.mailbox.thriftdata.message.MType.findByValue(iprot.readI32());
        struct.setTypeIsSet(true);
      }
      if (incoming.get(4)) {
        struct.level = xueqiao.mailbox.thriftdata.message.MLevel.findByValue(iprot.readI32());
        struct.setLevelIsSet(true);
      }
    }
  }

}

