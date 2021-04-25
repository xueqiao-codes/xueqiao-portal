/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package xueqiao.mailbox.hosting.thriftapi;

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

public class ReqHostingMessageOption implements org.apache.thrift.TBase<ReqHostingMessageOption, ReqHostingMessageOption._Fields>, java.io.Serializable, Cloneable, Comparable<ReqHostingMessageOption> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ReqHostingMessageOption");

  private static final org.apache.thrift.protocol.TField USER_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("userId", org.apache.thrift.protocol.TType.I64, (short)1);
  private static final org.apache.thrift.protocol.TField COMPANY_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("companyId", org.apache.thrift.protocol.TType.I64, (short)2);
  private static final org.apache.thrift.protocol.TField MESSAGE_JOB_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("messageJobId", org.apache.thrift.protocol.TType.I64, (short)3);
  private static final org.apache.thrift.protocol.TField HOSTING_MESSAGE_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("hostingMessageId", org.apache.thrift.protocol.TType.SET, (short)4);
  private static final org.apache.thrift.protocol.TField STATE_FIELD_DESC = new org.apache.thrift.protocol.TField("state", org.apache.thrift.protocol.TType.I32, (short)5);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new ReqHostingMessageOptionStandardSchemeFactory());
    schemes.put(TupleScheme.class, new ReqHostingMessageOptionTupleSchemeFactory());
  }

  public long userId; // optional
  public long companyId; // optional
  public long messageJobId; // optional
  public Set<Long> hostingMessageId; // optional
  /**
   * 
   * @see MessageState
   */
  public MessageState state; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    USER_ID((short)1, "userId"),
    COMPANY_ID((short)2, "companyId"),
    MESSAGE_JOB_ID((short)3, "messageJobId"),
    HOSTING_MESSAGE_ID((short)4, "hostingMessageId"),
    /**
     * 
     * @see MessageState
     */
    STATE((short)5, "state");

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
        case 1: // USER_ID
          return USER_ID;
        case 2: // COMPANY_ID
          return COMPANY_ID;
        case 3: // MESSAGE_JOB_ID
          return MESSAGE_JOB_ID;
        case 4: // HOSTING_MESSAGE_ID
          return HOSTING_MESSAGE_ID;
        case 5: // STATE
          return STATE;
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
  private static final int __USERID_ISSET_ID = 0;
  private static final int __COMPANYID_ISSET_ID = 1;
  private static final int __MESSAGEJOBID_ISSET_ID = 2;
  private byte __isset_bitfield = 0;
  private _Fields optionals[] = {_Fields.USER_ID,_Fields.COMPANY_ID,_Fields.MESSAGE_JOB_ID,_Fields.HOSTING_MESSAGE_ID,_Fields.STATE};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.USER_ID, new org.apache.thrift.meta_data.FieldMetaData("userId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.COMPANY_ID, new org.apache.thrift.meta_data.FieldMetaData("companyId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.MESSAGE_JOB_ID, new org.apache.thrift.meta_data.FieldMetaData("messageJobId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.HOSTING_MESSAGE_ID, new org.apache.thrift.meta_data.FieldMetaData("hostingMessageId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.SetMetaData(org.apache.thrift.protocol.TType.SET, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64))));
    tmpMap.put(_Fields.STATE, new org.apache.thrift.meta_data.FieldMetaData("state", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, MessageState.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ReqHostingMessageOption.class, metaDataMap);
  }

  public ReqHostingMessageOption() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ReqHostingMessageOption(ReqHostingMessageOption other) {
    __isset_bitfield = other.__isset_bitfield;
    this.userId = other.userId;
    this.companyId = other.companyId;
    this.messageJobId = other.messageJobId;
    if (other.isSetHostingMessageId()) {
      Set<Long> __this__hostingMessageId = new HashSet<Long>(other.hostingMessageId);
      this.hostingMessageId = __this__hostingMessageId;
    }
    if (other.isSetState()) {
      this.state = other.state;
    }
  }

  public ReqHostingMessageOption deepCopy() {
    return new ReqHostingMessageOption(this);
  }

  @Override
  public void clear() {
    setUserIdIsSet(false);
    this.userId = 0;
    setCompanyIdIsSet(false);
    this.companyId = 0;
    setMessageJobIdIsSet(false);
    this.messageJobId = 0;
    this.hostingMessageId = null;
    this.state = null;
  }

  public long getUserId() {
    return this.userId;
  }

  public ReqHostingMessageOption setUserId(long userId) {
    this.userId = userId;
    setUserIdIsSet(true);
    return this;
  }

  public void unsetUserId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __USERID_ISSET_ID);
  }

  /** Returns true if field userId is set (has been assigned a value) and false otherwise */
  public boolean isSetUserId() {
    return EncodingUtils.testBit(__isset_bitfield, __USERID_ISSET_ID);
  }

  public void setUserIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __USERID_ISSET_ID, value);
  }

  public long getCompanyId() {
    return this.companyId;
  }

  public ReqHostingMessageOption setCompanyId(long companyId) {
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

  public long getMessageJobId() {
    return this.messageJobId;
  }

  public ReqHostingMessageOption setMessageJobId(long messageJobId) {
    this.messageJobId = messageJobId;
    setMessageJobIdIsSet(true);
    return this;
  }

  public void unsetMessageJobId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __MESSAGEJOBID_ISSET_ID);
  }

  /** Returns true if field messageJobId is set (has been assigned a value) and false otherwise */
  public boolean isSetMessageJobId() {
    return EncodingUtils.testBit(__isset_bitfield, __MESSAGEJOBID_ISSET_ID);
  }

  public void setMessageJobIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __MESSAGEJOBID_ISSET_ID, value);
  }

  public int getHostingMessageIdSize() {
    return (this.hostingMessageId == null) ? 0 : this.hostingMessageId.size();
  }

  public java.util.Iterator<Long> getHostingMessageIdIterator() {
    return (this.hostingMessageId == null) ? null : this.hostingMessageId.iterator();
  }

  public void addToHostingMessageId(long elem) {
    if (this.hostingMessageId == null) {
      this.hostingMessageId = new HashSet<Long>();
    }
    this.hostingMessageId.add(elem);
  }

  public Set<Long> getHostingMessageId() {
    return this.hostingMessageId;
  }

  public ReqHostingMessageOption setHostingMessageId(Set<Long> hostingMessageId) {
    this.hostingMessageId = hostingMessageId;
    return this;
  }

  public void unsetHostingMessageId() {
    this.hostingMessageId = null;
  }

  /** Returns true if field hostingMessageId is set (has been assigned a value) and false otherwise */
  public boolean isSetHostingMessageId() {
    return this.hostingMessageId != null;
  }

  public void setHostingMessageIdIsSet(boolean value) {
    if (!value) {
      this.hostingMessageId = null;
    }
  }

  /**
   * 
   * @see MessageState
   */
  public MessageState getState() {
    return this.state;
  }

  /**
   * 
   * @see MessageState
   */
  public ReqHostingMessageOption setState(MessageState state) {
    this.state = state;
    return this;
  }

  public void unsetState() {
    this.state = null;
  }

  /** Returns true if field state is set (has been assigned a value) and false otherwise */
  public boolean isSetState() {
    return this.state != null;
  }

  public void setStateIsSet(boolean value) {
    if (!value) {
      this.state = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case USER_ID:
      if (value == null) {
        unsetUserId();
      } else {
        setUserId((Long)value);
      }
      break;

    case COMPANY_ID:
      if (value == null) {
        unsetCompanyId();
      } else {
        setCompanyId((Long)value);
      }
      break;

    case MESSAGE_JOB_ID:
      if (value == null) {
        unsetMessageJobId();
      } else {
        setMessageJobId((Long)value);
      }
      break;

    case HOSTING_MESSAGE_ID:
      if (value == null) {
        unsetHostingMessageId();
      } else {
        setHostingMessageId((Set<Long>)value);
      }
      break;

    case STATE:
      if (value == null) {
        unsetState();
      } else {
        setState((MessageState)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case USER_ID:
      return Long.valueOf(getUserId());

    case COMPANY_ID:
      return Long.valueOf(getCompanyId());

    case MESSAGE_JOB_ID:
      return Long.valueOf(getMessageJobId());

    case HOSTING_MESSAGE_ID:
      return getHostingMessageId();

    case STATE:
      return getState();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case USER_ID:
      return isSetUserId();
    case COMPANY_ID:
      return isSetCompanyId();
    case MESSAGE_JOB_ID:
      return isSetMessageJobId();
    case HOSTING_MESSAGE_ID:
      return isSetHostingMessageId();
    case STATE:
      return isSetState();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ReqHostingMessageOption)
      return this.equals((ReqHostingMessageOption)that);
    return false;
  }

  public boolean equals(ReqHostingMessageOption that) {
    if (that == null)
      return false;

    boolean this_present_userId = true && this.isSetUserId();
    boolean that_present_userId = true && that.isSetUserId();
    if (this_present_userId || that_present_userId) {
      if (!(this_present_userId && that_present_userId))
        return false;
      if (this.userId != that.userId)
        return false;
    }

    boolean this_present_companyId = true && this.isSetCompanyId();
    boolean that_present_companyId = true && that.isSetCompanyId();
    if (this_present_companyId || that_present_companyId) {
      if (!(this_present_companyId && that_present_companyId))
        return false;
      if (this.companyId != that.companyId)
        return false;
    }

    boolean this_present_messageJobId = true && this.isSetMessageJobId();
    boolean that_present_messageJobId = true && that.isSetMessageJobId();
    if (this_present_messageJobId || that_present_messageJobId) {
      if (!(this_present_messageJobId && that_present_messageJobId))
        return false;
      if (this.messageJobId != that.messageJobId)
        return false;
    }

    boolean this_present_hostingMessageId = true && this.isSetHostingMessageId();
    boolean that_present_hostingMessageId = true && that.isSetHostingMessageId();
    if (this_present_hostingMessageId || that_present_hostingMessageId) {
      if (!(this_present_hostingMessageId && that_present_hostingMessageId))
        return false;
      if (!this.hostingMessageId.equals(that.hostingMessageId))
        return false;
    }

    boolean this_present_state = true && this.isSetState();
    boolean that_present_state = true && that.isSetState();
    if (this_present_state || that_present_state) {
      if (!(this_present_state && that_present_state))
        return false;
      if (!this.state.equals(that.state))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(ReqHostingMessageOption other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetUserId()).compareTo(other.isSetUserId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUserId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.userId, other.userId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
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
    lastComparison = Boolean.valueOf(isSetMessageJobId()).compareTo(other.isSetMessageJobId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMessageJobId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.messageJobId, other.messageJobId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetHostingMessageId()).compareTo(other.isSetHostingMessageId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetHostingMessageId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.hostingMessageId, other.hostingMessageId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetState()).compareTo(other.isSetState());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetState()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.state, other.state);
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
    StringBuilder sb = new StringBuilder("ReqHostingMessageOption(");
    boolean first = true;

    if (isSetUserId()) {
      sb.append("userId:");
      sb.append(this.userId);
      first = false;
    }
    if (isSetCompanyId()) {
      if (!first) sb.append(", ");
      sb.append("companyId:");
      sb.append(this.companyId);
      first = false;
    }
    if (isSetMessageJobId()) {
      if (!first) sb.append(", ");
      sb.append("messageJobId:");
      sb.append(this.messageJobId);
      first = false;
    }
    if (isSetHostingMessageId()) {
      if (!first) sb.append(", ");
      sb.append("hostingMessageId:");
      if (this.hostingMessageId == null) {
        sb.append("null");
      } else {
        sb.append(this.hostingMessageId);
      }
      first = false;
    }
    if (isSetState()) {
      if (!first) sb.append(", ");
      sb.append("state:");
      if (this.state == null) {
        sb.append("null");
      } else {
        sb.append(this.state);
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

  private static class ReqHostingMessageOptionStandardSchemeFactory implements SchemeFactory {
    public ReqHostingMessageOptionStandardScheme getScheme() {
      return new ReqHostingMessageOptionStandardScheme();
    }
  }

  private static class ReqHostingMessageOptionStandardScheme extends StandardScheme<ReqHostingMessageOption> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ReqHostingMessageOption struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // USER_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.userId = iprot.readI64();
              struct.setUserIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // COMPANY_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.companyId = iprot.readI64();
              struct.setCompanyIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // MESSAGE_JOB_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.messageJobId = iprot.readI64();
              struct.setMessageJobIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // HOSTING_MESSAGE_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.SET) {
              {
                org.apache.thrift.protocol.TSet _set8 = iprot.readSetBegin();
                struct.hostingMessageId = new HashSet<Long>(2*_set8.size);
                for (int _i9 = 0; _i9 < _set8.size; ++_i9)
                {
                  long _elem10;
                  _elem10 = iprot.readI64();
                  struct.hostingMessageId.add(_elem10);
                }
                iprot.readSetEnd();
              }
              struct.setHostingMessageIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // STATE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.state = MessageState.findByValue(iprot.readI32());
              struct.setStateIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, ReqHostingMessageOption struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.isSetUserId()) {
        oprot.writeFieldBegin(USER_ID_FIELD_DESC);
        oprot.writeI64(struct.userId);
        oprot.writeFieldEnd();
      }
      if (struct.isSetCompanyId()) {
        oprot.writeFieldBegin(COMPANY_ID_FIELD_DESC);
        oprot.writeI64(struct.companyId);
        oprot.writeFieldEnd();
      }
      if (struct.isSetMessageJobId()) {
        oprot.writeFieldBegin(MESSAGE_JOB_ID_FIELD_DESC);
        oprot.writeI64(struct.messageJobId);
        oprot.writeFieldEnd();
      }
      if (struct.hostingMessageId != null) {
        if (struct.isSetHostingMessageId()) {
          oprot.writeFieldBegin(HOSTING_MESSAGE_ID_FIELD_DESC);
          {
            oprot.writeSetBegin(new org.apache.thrift.protocol.TSet(org.apache.thrift.protocol.TType.I64, struct.hostingMessageId.size()));
            for (long _iter11 : struct.hostingMessageId)
            {
              oprot.writeI64(_iter11);
            }
            oprot.writeSetEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.state != null) {
        if (struct.isSetState()) {
          oprot.writeFieldBegin(STATE_FIELD_DESC);
          oprot.writeI32(struct.state.getValue());
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ReqHostingMessageOptionTupleSchemeFactory implements SchemeFactory {
    public ReqHostingMessageOptionTupleScheme getScheme() {
      return new ReqHostingMessageOptionTupleScheme();
    }
  }

  private static class ReqHostingMessageOptionTupleScheme extends TupleScheme<ReqHostingMessageOption> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ReqHostingMessageOption struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetUserId()) {
        optionals.set(0);
      }
      if (struct.isSetCompanyId()) {
        optionals.set(1);
      }
      if (struct.isSetMessageJobId()) {
        optionals.set(2);
      }
      if (struct.isSetHostingMessageId()) {
        optionals.set(3);
      }
      if (struct.isSetState()) {
        optionals.set(4);
      }
      oprot.writeBitSet(optionals, 5);
      if (struct.isSetUserId()) {
        oprot.writeI64(struct.userId);
      }
      if (struct.isSetCompanyId()) {
        oprot.writeI64(struct.companyId);
      }
      if (struct.isSetMessageJobId()) {
        oprot.writeI64(struct.messageJobId);
      }
      if (struct.isSetHostingMessageId()) {
        {
          oprot.writeI32(struct.hostingMessageId.size());
          for (long _iter12 : struct.hostingMessageId)
          {
            oprot.writeI64(_iter12);
          }
        }
      }
      if (struct.isSetState()) {
        oprot.writeI32(struct.state.getValue());
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ReqHostingMessageOption struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(5);
      if (incoming.get(0)) {
        struct.userId = iprot.readI64();
        struct.setUserIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.companyId = iprot.readI64();
        struct.setCompanyIdIsSet(true);
      }
      if (incoming.get(2)) {
        struct.messageJobId = iprot.readI64();
        struct.setMessageJobIdIsSet(true);
      }
      if (incoming.get(3)) {
        {
          org.apache.thrift.protocol.TSet _set13 = new org.apache.thrift.protocol.TSet(org.apache.thrift.protocol.TType.I64, iprot.readI32());
          struct.hostingMessageId = new HashSet<Long>(2*_set13.size);
          for (int _i14 = 0; _i14 < _set13.size; ++_i14)
          {
            long _elem15;
            _elem15 = iprot.readI64();
            struct.hostingMessageId.add(_elem15);
          }
        }
        struct.setHostingMessageIdIsSet(true);
      }
      if (incoming.get(4)) {
        struct.state = MessageState.findByValue(iprot.readI32());
        struct.setStateIsSet(true);
      }
    }
  }

}

