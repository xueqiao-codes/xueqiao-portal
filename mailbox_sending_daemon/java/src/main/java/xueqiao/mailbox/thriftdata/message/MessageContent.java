/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package xueqiao.mailbox.thriftdata.message;

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
 * 信息体
 */
public class MessageContent implements org.apache.thrift.TBase<MessageContent, MessageContent._Fields>, java.io.Serializable, Cloneable, Comparable<MessageContent> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("MessageContent");

  private static final org.apache.thrift.protocol.TField TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("type", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField LEVEL_FIELD_DESC = new org.apache.thrift.protocol.TField("level", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField TITLE_FIELD_DESC = new org.apache.thrift.protocol.TField("title", org.apache.thrift.protocol.TType.STRING, (short)10);
  private static final org.apache.thrift.protocol.TField SUMMARY_FIELD_DESC = new org.apache.thrift.protocol.TField("summary", org.apache.thrift.protocol.TType.STRING, (short)11);
  private static final org.apache.thrift.protocol.TField CONTENT_FIELD_DESC = new org.apache.thrift.protocol.TField("content", org.apache.thrift.protocol.TType.STRING, (short)12);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new MessageContentStandardSchemeFactory());
    schemes.put(TupleScheme.class, new MessageContentTupleSchemeFactory());
  }

  /**
   * 
   * @see MType
   */
  public MType type; // optional
  /**
   * 
   * @see MLevel
   */
  public MLevel level; // optional
  public String title; // optional
  public String summary; // optional
  public String content; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * 
     * @see MType
     */
    TYPE((short)1, "type"),
    /**
     * 
     * @see MLevel
     */
    LEVEL((short)2, "level"),
    TITLE((short)10, "title"),
    SUMMARY((short)11, "summary"),
    CONTENT((short)12, "content");

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
        case 1: // TYPE
          return TYPE;
        case 2: // LEVEL
          return LEVEL;
        case 10: // TITLE
          return TITLE;
        case 11: // SUMMARY
          return SUMMARY;
        case 12: // CONTENT
          return CONTENT;
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
  private _Fields optionals[] = {_Fields.TYPE,_Fields.LEVEL,_Fields.TITLE,_Fields.SUMMARY,_Fields.CONTENT};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TYPE, new org.apache.thrift.meta_data.FieldMetaData("type", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, MType.class)));
    tmpMap.put(_Fields.LEVEL, new org.apache.thrift.meta_data.FieldMetaData("level", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, MLevel.class)));
    tmpMap.put(_Fields.TITLE, new org.apache.thrift.meta_data.FieldMetaData("title", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.SUMMARY, new org.apache.thrift.meta_data.FieldMetaData("summary", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.CONTENT, new org.apache.thrift.meta_data.FieldMetaData("content", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(MessageContent.class, metaDataMap);
  }

  public MessageContent() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public MessageContent(MessageContent other) {
    if (other.isSetType()) {
      this.type = other.type;
    }
    if (other.isSetLevel()) {
      this.level = other.level;
    }
    if (other.isSetTitle()) {
      this.title = other.title;
    }
    if (other.isSetSummary()) {
      this.summary = other.summary;
    }
    if (other.isSetContent()) {
      this.content = other.content;
    }
  }

  public MessageContent deepCopy() {
    return new MessageContent(this);
  }

  @Override
  public void clear() {
    this.type = null;
    this.level = null;
    this.title = null;
    this.summary = null;
    this.content = null;
  }

  /**
   * 
   * @see MType
   */
  public MType getType() {
    return this.type;
  }

  /**
   * 
   * @see MType
   */
  public MessageContent setType(MType type) {
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
   * @see MLevel
   */
  public MLevel getLevel() {
    return this.level;
  }

  /**
   * 
   * @see MLevel
   */
  public MessageContent setLevel(MLevel level) {
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

  public String getTitle() {
    return this.title;
  }

  public MessageContent setTitle(String title) {
    this.title = title;
    return this;
  }

  public void unsetTitle() {
    this.title = null;
  }

  /** Returns true if field title is set (has been assigned a value) and false otherwise */
  public boolean isSetTitle() {
    return this.title != null;
  }

  public void setTitleIsSet(boolean value) {
    if (!value) {
      this.title = null;
    }
  }

  public String getSummary() {
    return this.summary;
  }

  public MessageContent setSummary(String summary) {
    this.summary = summary;
    return this;
  }

  public void unsetSummary() {
    this.summary = null;
  }

  /** Returns true if field summary is set (has been assigned a value) and false otherwise */
  public boolean isSetSummary() {
    return this.summary != null;
  }

  public void setSummaryIsSet(boolean value) {
    if (!value) {
      this.summary = null;
    }
  }

  public String getContent() {
    return this.content;
  }

  public MessageContent setContent(String content) {
    this.content = content;
    return this;
  }

  public void unsetContent() {
    this.content = null;
  }

  /** Returns true if field content is set (has been assigned a value) and false otherwise */
  public boolean isSetContent() {
    return this.content != null;
  }

  public void setContentIsSet(boolean value) {
    if (!value) {
      this.content = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case TYPE:
      if (value == null) {
        unsetType();
      } else {
        setType((MType)value);
      }
      break;

    case LEVEL:
      if (value == null) {
        unsetLevel();
      } else {
        setLevel((MLevel)value);
      }
      break;

    case TITLE:
      if (value == null) {
        unsetTitle();
      } else {
        setTitle((String)value);
      }
      break;

    case SUMMARY:
      if (value == null) {
        unsetSummary();
      } else {
        setSummary((String)value);
      }
      break;

    case CONTENT:
      if (value == null) {
        unsetContent();
      } else {
        setContent((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case TYPE:
      return getType();

    case LEVEL:
      return getLevel();

    case TITLE:
      return getTitle();

    case SUMMARY:
      return getSummary();

    case CONTENT:
      return getContent();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case TYPE:
      return isSetType();
    case LEVEL:
      return isSetLevel();
    case TITLE:
      return isSetTitle();
    case SUMMARY:
      return isSetSummary();
    case CONTENT:
      return isSetContent();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof MessageContent)
      return this.equals((MessageContent)that);
    return false;
  }

  public boolean equals(MessageContent that) {
    if (that == null)
      return false;

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

    boolean this_present_title = true && this.isSetTitle();
    boolean that_present_title = true && that.isSetTitle();
    if (this_present_title || that_present_title) {
      if (!(this_present_title && that_present_title))
        return false;
      if (!this.title.equals(that.title))
        return false;
    }

    boolean this_present_summary = true && this.isSetSummary();
    boolean that_present_summary = true && that.isSetSummary();
    if (this_present_summary || that_present_summary) {
      if (!(this_present_summary && that_present_summary))
        return false;
      if (!this.summary.equals(that.summary))
        return false;
    }

    boolean this_present_content = true && this.isSetContent();
    boolean that_present_content = true && that.isSetContent();
    if (this_present_content || that_present_content) {
      if (!(this_present_content && that_present_content))
        return false;
      if (!this.content.equals(that.content))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(MessageContent other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

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
    lastComparison = Boolean.valueOf(isSetTitle()).compareTo(other.isSetTitle());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTitle()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.title, other.title);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSummary()).compareTo(other.isSetSummary());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSummary()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.summary, other.summary);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetContent()).compareTo(other.isSetContent());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetContent()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.content, other.content);
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
    StringBuilder sb = new StringBuilder("MessageContent(");
    boolean first = true;

    if (isSetType()) {
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
    if (isSetTitle()) {
      if (!first) sb.append(", ");
      sb.append("title:");
      if (this.title == null) {
        sb.append("null");
      } else {
        sb.append(this.title);
      }
      first = false;
    }
    if (isSetSummary()) {
      if (!first) sb.append(", ");
      sb.append("summary:");
      if (this.summary == null) {
        sb.append("null");
      } else {
        sb.append(this.summary);
      }
      first = false;
    }
    if (isSetContent()) {
      if (!first) sb.append(", ");
      sb.append("content:");
      if (this.content == null) {
        sb.append("null");
      } else {
        sb.append(this.content);
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

  private static class MessageContentStandardSchemeFactory implements SchemeFactory {
    public MessageContentStandardScheme getScheme() {
      return new MessageContentStandardScheme();
    }
  }

  private static class MessageContentStandardScheme extends StandardScheme<MessageContent> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, MessageContent struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.type = MType.findByValue(iprot.readI32());
              struct.setTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // LEVEL
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.level = MLevel.findByValue(iprot.readI32());
              struct.setLevelIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 10: // TITLE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.title = iprot.readString();
              struct.setTitleIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 11: // SUMMARY
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.summary = iprot.readString();
              struct.setSummaryIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 12: // CONTENT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.content = iprot.readString();
              struct.setContentIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, MessageContent struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
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
      if (struct.title != null) {
        if (struct.isSetTitle()) {
          oprot.writeFieldBegin(TITLE_FIELD_DESC);
          oprot.writeString(struct.title);
          oprot.writeFieldEnd();
        }
      }
      if (struct.summary != null) {
        if (struct.isSetSummary()) {
          oprot.writeFieldBegin(SUMMARY_FIELD_DESC);
          oprot.writeString(struct.summary);
          oprot.writeFieldEnd();
        }
      }
      if (struct.content != null) {
        if (struct.isSetContent()) {
          oprot.writeFieldBegin(CONTENT_FIELD_DESC);
          oprot.writeString(struct.content);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class MessageContentTupleSchemeFactory implements SchemeFactory {
    public MessageContentTupleScheme getScheme() {
      return new MessageContentTupleScheme();
    }
  }

  private static class MessageContentTupleScheme extends TupleScheme<MessageContent> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, MessageContent struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetType()) {
        optionals.set(0);
      }
      if (struct.isSetLevel()) {
        optionals.set(1);
      }
      if (struct.isSetTitle()) {
        optionals.set(2);
      }
      if (struct.isSetSummary()) {
        optionals.set(3);
      }
      if (struct.isSetContent()) {
        optionals.set(4);
      }
      oprot.writeBitSet(optionals, 5);
      if (struct.isSetType()) {
        oprot.writeI32(struct.type.getValue());
      }
      if (struct.isSetLevel()) {
        oprot.writeI32(struct.level.getValue());
      }
      if (struct.isSetTitle()) {
        oprot.writeString(struct.title);
      }
      if (struct.isSetSummary()) {
        oprot.writeString(struct.summary);
      }
      if (struct.isSetContent()) {
        oprot.writeString(struct.content);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, MessageContent struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(5);
      if (incoming.get(0)) {
        struct.type = MType.findByValue(iprot.readI32());
        struct.setTypeIsSet(true);
      }
      if (incoming.get(1)) {
        struct.level = MLevel.findByValue(iprot.readI32());
        struct.setLevelIsSet(true);
      }
      if (incoming.get(2)) {
        struct.title = iprot.readString();
        struct.setTitleIsSet(true);
      }
      if (incoming.get(3)) {
        struct.summary = iprot.readString();
        struct.setSummaryIsSet(true);
      }
      if (incoming.get(4)) {
        struct.content = iprot.readString();
        struct.setContentIsSet(true);
      }
    }
  }

}
