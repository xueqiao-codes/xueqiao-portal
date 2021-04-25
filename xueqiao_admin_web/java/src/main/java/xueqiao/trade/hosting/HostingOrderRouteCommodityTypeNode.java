/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package xueqiao.trade.hosting;

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

public class HostingOrderRouteCommodityTypeNode implements org.apache.thrift.TBase<HostingOrderRouteCommodityTypeNode, HostingOrderRouteCommodityTypeNode._Fields>, java.io.Serializable, Cloneable, Comparable<HostingOrderRouteCommodityTypeNode> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("HostingOrderRouteCommodityTypeNode");

  private static final org.apache.thrift.protocol.TField SLED_COMMODITY_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("sledCommodityType", org.apache.thrift.protocol.TType.I16, (short)1);
  private static final org.apache.thrift.protocol.TField SUB_COMMODITY_CODE_NODES_FIELD_DESC = new org.apache.thrift.protocol.TField("subCommodityCodeNodes", org.apache.thrift.protocol.TType.MAP, (short)2);
  private static final org.apache.thrift.protocol.TField RELATED_INFO_FIELD_DESC = new org.apache.thrift.protocol.TField("relatedInfo", org.apache.thrift.protocol.TType.STRUCT, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new HostingOrderRouteCommodityTypeNodeStandardSchemeFactory());
    schemes.put(TupleScheme.class, new HostingOrderRouteCommodityTypeNodeTupleSchemeFactory());
  }

  public short sledCommodityType; // optional
  public Map<String,HostingOrderRouteCommodityCodeNode> subCommodityCodeNodes; // optional
  public HostingOrderRouteRelatedInfo relatedInfo; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    SLED_COMMODITY_TYPE((short)1, "sledCommodityType"),
    SUB_COMMODITY_CODE_NODES((short)2, "subCommodityCodeNodes"),
    RELATED_INFO((short)3, "relatedInfo");

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
        case 1: // SLED_COMMODITY_TYPE
          return SLED_COMMODITY_TYPE;
        case 2: // SUB_COMMODITY_CODE_NODES
          return SUB_COMMODITY_CODE_NODES;
        case 3: // RELATED_INFO
          return RELATED_INFO;
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
  private static final int __SLEDCOMMODITYTYPE_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private _Fields optionals[] = {_Fields.SLED_COMMODITY_TYPE,_Fields.SUB_COMMODITY_CODE_NODES,_Fields.RELATED_INFO};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.SLED_COMMODITY_TYPE, new org.apache.thrift.meta_data.FieldMetaData("sledCommodityType", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I16)));
    tmpMap.put(_Fields.SUB_COMMODITY_CODE_NODES, new org.apache.thrift.meta_data.FieldMetaData("subCommodityCodeNodes", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING), 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, HostingOrderRouteCommodityCodeNode.class))));
    tmpMap.put(_Fields.RELATED_INFO, new org.apache.thrift.meta_data.FieldMetaData("relatedInfo", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, HostingOrderRouteRelatedInfo.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(HostingOrderRouteCommodityTypeNode.class, metaDataMap);
  }

  public HostingOrderRouteCommodityTypeNode() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public HostingOrderRouteCommodityTypeNode(HostingOrderRouteCommodityTypeNode other) {
    __isset_bitfield = other.__isset_bitfield;
    this.sledCommodityType = other.sledCommodityType;
    if (other.isSetSubCommodityCodeNodes()) {
      Map<String,HostingOrderRouteCommodityCodeNode> __this__subCommodityCodeNodes = new HashMap<String,HostingOrderRouteCommodityCodeNode>(other.subCommodityCodeNodes.size());
      for (Map.Entry<String, HostingOrderRouteCommodityCodeNode> other_element : other.subCommodityCodeNodes.entrySet()) {

        String other_element_key = other_element.getKey();
        HostingOrderRouteCommodityCodeNode other_element_value = other_element.getValue();

        String __this__subCommodityCodeNodes_copy_key = other_element_key;

        HostingOrderRouteCommodityCodeNode __this__subCommodityCodeNodes_copy_value = new HostingOrderRouteCommodityCodeNode(other_element_value);

        __this__subCommodityCodeNodes.put(__this__subCommodityCodeNodes_copy_key, __this__subCommodityCodeNodes_copy_value);
      }
      this.subCommodityCodeNodes = __this__subCommodityCodeNodes;
    }
    if (other.isSetRelatedInfo()) {
      this.relatedInfo = new HostingOrderRouteRelatedInfo(other.relatedInfo);
    }
  }

  public HostingOrderRouteCommodityTypeNode deepCopy() {
    return new HostingOrderRouteCommodityTypeNode(this);
  }

  @Override
  public void clear() {
    setSledCommodityTypeIsSet(false);
    this.sledCommodityType = 0;
    this.subCommodityCodeNodes = null;
    this.relatedInfo = null;
  }

  public short getSledCommodityType() {
    return this.sledCommodityType;
  }

  public HostingOrderRouteCommodityTypeNode setSledCommodityType(short sledCommodityType) {
    this.sledCommodityType = sledCommodityType;
    setSledCommodityTypeIsSet(true);
    return this;
  }

  public void unsetSledCommodityType() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __SLEDCOMMODITYTYPE_ISSET_ID);
  }

  /** Returns true if field sledCommodityType is set (has been assigned a value) and false otherwise */
  public boolean isSetSledCommodityType() {
    return EncodingUtils.testBit(__isset_bitfield, __SLEDCOMMODITYTYPE_ISSET_ID);
  }

  public void setSledCommodityTypeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __SLEDCOMMODITYTYPE_ISSET_ID, value);
  }

  public int getSubCommodityCodeNodesSize() {
    return (this.subCommodityCodeNodes == null) ? 0 : this.subCommodityCodeNodes.size();
  }

  public void putToSubCommodityCodeNodes(String key, HostingOrderRouteCommodityCodeNode val) {
    if (this.subCommodityCodeNodes == null) {
      this.subCommodityCodeNodes = new HashMap<String,HostingOrderRouteCommodityCodeNode>();
    }
    this.subCommodityCodeNodes.put(key, val);
  }

  public Map<String,HostingOrderRouteCommodityCodeNode> getSubCommodityCodeNodes() {
    return this.subCommodityCodeNodes;
  }

  public HostingOrderRouteCommodityTypeNode setSubCommodityCodeNodes(Map<String,HostingOrderRouteCommodityCodeNode> subCommodityCodeNodes) {
    this.subCommodityCodeNodes = subCommodityCodeNodes;
    return this;
  }

  public void unsetSubCommodityCodeNodes() {
    this.subCommodityCodeNodes = null;
  }

  /** Returns true if field subCommodityCodeNodes is set (has been assigned a value) and false otherwise */
  public boolean isSetSubCommodityCodeNodes() {
    return this.subCommodityCodeNodes != null;
  }

  public void setSubCommodityCodeNodesIsSet(boolean value) {
    if (!value) {
      this.subCommodityCodeNodes = null;
    }
  }

  public HostingOrderRouteRelatedInfo getRelatedInfo() {
    return this.relatedInfo;
  }

  public HostingOrderRouteCommodityTypeNode setRelatedInfo(HostingOrderRouteRelatedInfo relatedInfo) {
    this.relatedInfo = relatedInfo;
    return this;
  }

  public void unsetRelatedInfo() {
    this.relatedInfo = null;
  }

  /** Returns true if field relatedInfo is set (has been assigned a value) and false otherwise */
  public boolean isSetRelatedInfo() {
    return this.relatedInfo != null;
  }

  public void setRelatedInfoIsSet(boolean value) {
    if (!value) {
      this.relatedInfo = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case SLED_COMMODITY_TYPE:
      if (value == null) {
        unsetSledCommodityType();
      } else {
        setSledCommodityType((Short)value);
      }
      break;

    case SUB_COMMODITY_CODE_NODES:
      if (value == null) {
        unsetSubCommodityCodeNodes();
      } else {
        setSubCommodityCodeNodes((Map<String,HostingOrderRouteCommodityCodeNode>)value);
      }
      break;

    case RELATED_INFO:
      if (value == null) {
        unsetRelatedInfo();
      } else {
        setRelatedInfo((HostingOrderRouteRelatedInfo)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case SLED_COMMODITY_TYPE:
      return Short.valueOf(getSledCommodityType());

    case SUB_COMMODITY_CODE_NODES:
      return getSubCommodityCodeNodes();

    case RELATED_INFO:
      return getRelatedInfo();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case SLED_COMMODITY_TYPE:
      return isSetSledCommodityType();
    case SUB_COMMODITY_CODE_NODES:
      return isSetSubCommodityCodeNodes();
    case RELATED_INFO:
      return isSetRelatedInfo();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof HostingOrderRouteCommodityTypeNode)
      return this.equals((HostingOrderRouteCommodityTypeNode)that);
    return false;
  }

  public boolean equals(HostingOrderRouteCommodityTypeNode that) {
    if (that == null)
      return false;

    boolean this_present_sledCommodityType = true && this.isSetSledCommodityType();
    boolean that_present_sledCommodityType = true && that.isSetSledCommodityType();
    if (this_present_sledCommodityType || that_present_sledCommodityType) {
      if (!(this_present_sledCommodityType && that_present_sledCommodityType))
        return false;
      if (this.sledCommodityType != that.sledCommodityType)
        return false;
    }

    boolean this_present_subCommodityCodeNodes = true && this.isSetSubCommodityCodeNodes();
    boolean that_present_subCommodityCodeNodes = true && that.isSetSubCommodityCodeNodes();
    if (this_present_subCommodityCodeNodes || that_present_subCommodityCodeNodes) {
      if (!(this_present_subCommodityCodeNodes && that_present_subCommodityCodeNodes))
        return false;
      if (!this.subCommodityCodeNodes.equals(that.subCommodityCodeNodes))
        return false;
    }

    boolean this_present_relatedInfo = true && this.isSetRelatedInfo();
    boolean that_present_relatedInfo = true && that.isSetRelatedInfo();
    if (this_present_relatedInfo || that_present_relatedInfo) {
      if (!(this_present_relatedInfo && that_present_relatedInfo))
        return false;
      if (!this.relatedInfo.equals(that.relatedInfo))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(HostingOrderRouteCommodityTypeNode other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetSledCommodityType()).compareTo(other.isSetSledCommodityType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSledCommodityType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sledCommodityType, other.sledCommodityType);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSubCommodityCodeNodes()).compareTo(other.isSetSubCommodityCodeNodes());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSubCommodityCodeNodes()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.subCommodityCodeNodes, other.subCommodityCodeNodes);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetRelatedInfo()).compareTo(other.isSetRelatedInfo());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRelatedInfo()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.relatedInfo, other.relatedInfo);
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
    StringBuilder sb = new StringBuilder("HostingOrderRouteCommodityTypeNode(");
    boolean first = true;

    if (isSetSledCommodityType()) {
      sb.append("sledCommodityType:");
      sb.append(this.sledCommodityType);
      first = false;
    }
    if (isSetSubCommodityCodeNodes()) {
      if (!first) sb.append(", ");
      sb.append("subCommodityCodeNodes:");
      if (this.subCommodityCodeNodes == null) {
        sb.append("null");
      } else {
        sb.append(this.subCommodityCodeNodes);
      }
      first = false;
    }
    if (isSetRelatedInfo()) {
      if (!first) sb.append(", ");
      sb.append("relatedInfo:");
      if (this.relatedInfo == null) {
        sb.append("null");
      } else {
        sb.append(this.relatedInfo);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (relatedInfo != null) {
      relatedInfo.validate();
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
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class HostingOrderRouteCommodityTypeNodeStandardSchemeFactory implements SchemeFactory {
    public HostingOrderRouteCommodityTypeNodeStandardScheme getScheme() {
      return new HostingOrderRouteCommodityTypeNodeStandardScheme();
    }
  }

  private static class HostingOrderRouteCommodityTypeNodeStandardScheme extends StandardScheme<HostingOrderRouteCommodityTypeNode> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, HostingOrderRouteCommodityTypeNode struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // SLED_COMMODITY_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I16) {
              struct.sledCommodityType = iprot.readI16();
              struct.setSledCommodityTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // SUB_COMMODITY_CODE_NODES
            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
              {
                org.apache.thrift.protocol.TMap _map66 = iprot.readMapBegin();
                struct.subCommodityCodeNodes = new HashMap<String,HostingOrderRouteCommodityCodeNode>(2*_map66.size);
                for (int _i67 = 0; _i67 < _map66.size; ++_i67)
                {
                  String _key68;
                  HostingOrderRouteCommodityCodeNode _val69;
                  _key68 = iprot.readString();
                  _val69 = new HostingOrderRouteCommodityCodeNode();
                  _val69.read(iprot);
                  struct.subCommodityCodeNodes.put(_key68, _val69);
                }
                iprot.readMapEnd();
              }
              struct.setSubCommodityCodeNodesIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // RELATED_INFO
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.relatedInfo = new HostingOrderRouteRelatedInfo();
              struct.relatedInfo.read(iprot);
              struct.setRelatedInfoIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, HostingOrderRouteCommodityTypeNode struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.isSetSledCommodityType()) {
        oprot.writeFieldBegin(SLED_COMMODITY_TYPE_FIELD_DESC);
        oprot.writeI16(struct.sledCommodityType);
        oprot.writeFieldEnd();
      }
      if (struct.subCommodityCodeNodes != null) {
        if (struct.isSetSubCommodityCodeNodes()) {
          oprot.writeFieldBegin(SUB_COMMODITY_CODE_NODES_FIELD_DESC);
          {
            oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRUCT, struct.subCommodityCodeNodes.size()));
            for (Map.Entry<String, HostingOrderRouteCommodityCodeNode> _iter70 : struct.subCommodityCodeNodes.entrySet())
            {
              oprot.writeString(_iter70.getKey());
              _iter70.getValue().write(oprot);
            }
            oprot.writeMapEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.relatedInfo != null) {
        if (struct.isSetRelatedInfo()) {
          oprot.writeFieldBegin(RELATED_INFO_FIELD_DESC);
          struct.relatedInfo.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class HostingOrderRouteCommodityTypeNodeTupleSchemeFactory implements SchemeFactory {
    public HostingOrderRouteCommodityTypeNodeTupleScheme getScheme() {
      return new HostingOrderRouteCommodityTypeNodeTupleScheme();
    }
  }

  private static class HostingOrderRouteCommodityTypeNodeTupleScheme extends TupleScheme<HostingOrderRouteCommodityTypeNode> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, HostingOrderRouteCommodityTypeNode struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetSledCommodityType()) {
        optionals.set(0);
      }
      if (struct.isSetSubCommodityCodeNodes()) {
        optionals.set(1);
      }
      if (struct.isSetRelatedInfo()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetSledCommodityType()) {
        oprot.writeI16(struct.sledCommodityType);
      }
      if (struct.isSetSubCommodityCodeNodes()) {
        {
          oprot.writeI32(struct.subCommodityCodeNodes.size());
          for (Map.Entry<String, HostingOrderRouteCommodityCodeNode> _iter71 : struct.subCommodityCodeNodes.entrySet())
          {
            oprot.writeString(_iter71.getKey());
            _iter71.getValue().write(oprot);
          }
        }
      }
      if (struct.isSetRelatedInfo()) {
        struct.relatedInfo.write(oprot);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, HostingOrderRouteCommodityTypeNode struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.sledCommodityType = iprot.readI16();
        struct.setSledCommodityTypeIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TMap _map72 = new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.subCommodityCodeNodes = new HashMap<String,HostingOrderRouteCommodityCodeNode>(2*_map72.size);
          for (int _i73 = 0; _i73 < _map72.size; ++_i73)
          {
            String _key74;
            HostingOrderRouteCommodityCodeNode _val75;
            _key74 = iprot.readString();
            _val75 = new HostingOrderRouteCommodityCodeNode();
            _val75.read(iprot);
            struct.subCommodityCodeNodes.put(_key74, _val75);
          }
        }
        struct.setSubCommodityCodeNodesIsSet(true);
      }
      if (incoming.get(2)) {
        struct.relatedInfo = new HostingOrderRouteRelatedInfo();
        struct.relatedInfo.read(iprot);
        struct.setRelatedInfoIsSet(true);
      }
    }
  }

}

