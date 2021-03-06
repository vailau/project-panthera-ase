/**
 * Autogenerated by Thrift Compiler (0.9.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.hadoop.hive.ql.plan.api;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
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

public class QueryPlan implements org.apache.thrift.TBase<QueryPlan, QueryPlan._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("QueryPlan");

  private static final org.apache.thrift.protocol.TField QUERIES_FIELD_DESC = new org.apache.thrift.protocol.TField("queries", org.apache.thrift.protocol.TType.LIST, (short)1);
  private static final org.apache.thrift.protocol.TField DONE_FIELD_DESC = new org.apache.thrift.protocol.TField("done", org.apache.thrift.protocol.TType.BOOL, (short)2);
  private static final org.apache.thrift.protocol.TField STARTED_FIELD_DESC = new org.apache.thrift.protocol.TField("started", org.apache.thrift.protocol.TType.BOOL, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new QueryPlanStandardSchemeFactory());
    schemes.put(TupleScheme.class, new QueryPlanTupleSchemeFactory());
  }

  private List<Query> queries; // required
  private boolean done; // required
  private boolean started; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    QUERIES((short)1, "queries"),
    DONE((short)2, "done"),
    STARTED((short)3, "started");

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
        case 1: // QUERIES
          return QUERIES;
        case 2: // DONE
          return DONE;
        case 3: // STARTED
          return STARTED;
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
  private static final int __DONE_ISSET_ID = 0;
  private static final int __STARTED_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.QUERIES, new org.apache.thrift.meta_data.FieldMetaData("queries", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, Query.class))));
    tmpMap.put(_Fields.DONE, new org.apache.thrift.meta_data.FieldMetaData("done", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    tmpMap.put(_Fields.STARTED, new org.apache.thrift.meta_data.FieldMetaData("started", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(QueryPlan.class, metaDataMap);
  }

  public QueryPlan() {
  }

  public QueryPlan(
    List<Query> queries,
    boolean done,
    boolean started)
  {
    this();
    this.queries = queries;
    this.done = done;
    setDoneIsSet(true);
    this.started = started;
    setStartedIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public QueryPlan(QueryPlan other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetQueries()) {
      List<Query> __this__queries = new ArrayList<Query>();
      for (Query other_element : other.queries) {
        __this__queries.add(new Query(other_element));
      }
      this.queries = __this__queries;
    }
    this.done = other.done;
    this.started = other.started;
  }

  public QueryPlan deepCopy() {
    return new QueryPlan(this);
  }

  @Override
  public void clear() {
    this.queries = null;
    setDoneIsSet(false);
    this.done = false;
    setStartedIsSet(false);
    this.started = false;
  }

  public int getQueriesSize() {
    return (this.queries == null) ? 0 : this.queries.size();
  }

  public java.util.Iterator<Query> getQueriesIterator() {
    return (this.queries == null) ? null : this.queries.iterator();
  }

  public void addToQueries(Query elem) {
    if (this.queries == null) {
      this.queries = new ArrayList<Query>();
    }
    this.queries.add(elem);
  }

  public List<Query> getQueries() {
    return this.queries;
  }

  public void setQueries(List<Query> queries) {
    this.queries = queries;
  }

  public void unsetQueries() {
    this.queries = null;
  }

  /** Returns true if field queries is set (has been assigned a value) and false otherwise */
  public boolean isSetQueries() {
    return this.queries != null;
  }

  public void setQueriesIsSet(boolean value) {
    if (!value) {
      this.queries = null;
    }
  }

  public boolean isDone() {
    return this.done;
  }

  public void setDone(boolean done) {
    this.done = done;
    setDoneIsSet(true);
  }

  public void unsetDone() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __DONE_ISSET_ID);
  }

  /** Returns true if field done is set (has been assigned a value) and false otherwise */
  public boolean isSetDone() {
    return EncodingUtils.testBit(__isset_bitfield, __DONE_ISSET_ID);
  }

  public void setDoneIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __DONE_ISSET_ID, value);
  }

  public boolean isStarted() {
    return this.started;
  }

  public void setStarted(boolean started) {
    this.started = started;
    setStartedIsSet(true);
  }

  public void unsetStarted() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __STARTED_ISSET_ID);
  }

  /** Returns true if field started is set (has been assigned a value) and false otherwise */
  public boolean isSetStarted() {
    return EncodingUtils.testBit(__isset_bitfield, __STARTED_ISSET_ID);
  }

  public void setStartedIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __STARTED_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case QUERIES:
      if (value == null) {
        unsetQueries();
      } else {
        setQueries((List<Query>)value);
      }
      break;

    case DONE:
      if (value == null) {
        unsetDone();
      } else {
        setDone((Boolean)value);
      }
      break;

    case STARTED:
      if (value == null) {
        unsetStarted();
      } else {
        setStarted((Boolean)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case QUERIES:
      return getQueries();

    case DONE:
      return Boolean.valueOf(isDone());

    case STARTED:
      return Boolean.valueOf(isStarted());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case QUERIES:
      return isSetQueries();
    case DONE:
      return isSetDone();
    case STARTED:
      return isSetStarted();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof QueryPlan)
      return this.equals((QueryPlan)that);
    return false;
  }

  public boolean equals(QueryPlan that) {
    if (that == null)
      return false;

    boolean this_present_queries = true && this.isSetQueries();
    boolean that_present_queries = true && that.isSetQueries();
    if (this_present_queries || that_present_queries) {
      if (!(this_present_queries && that_present_queries))
        return false;
      if (!this.queries.equals(that.queries))
        return false;
    }

    boolean this_present_done = true;
    boolean that_present_done = true;
    if (this_present_done || that_present_done) {
      if (!(this_present_done && that_present_done))
        return false;
      if (this.done != that.done)
        return false;
    }

    boolean this_present_started = true;
    boolean that_present_started = true;
    if (this_present_started || that_present_started) {
      if (!(this_present_started && that_present_started))
        return false;
      if (this.started != that.started)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_queries = true && (isSetQueries());
    builder.append(present_queries);
    if (present_queries)
      builder.append(queries);

    boolean present_done = true;
    builder.append(present_done);
    if (present_done)
      builder.append(done);

    boolean present_started = true;
    builder.append(present_started);
    if (present_started)
      builder.append(started);

    return builder.toHashCode();
  }

  public int compareTo(QueryPlan other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    QueryPlan typedOther = (QueryPlan)other;

    lastComparison = Boolean.valueOf(isSetQueries()).compareTo(typedOther.isSetQueries());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetQueries()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.queries, typedOther.queries);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDone()).compareTo(typedOther.isSetDone());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDone()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.done, typedOther.done);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetStarted()).compareTo(typedOther.isSetStarted());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStarted()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.started, typedOther.started);
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
    StringBuilder sb = new StringBuilder("QueryPlan(");
    boolean first = true;

    sb.append("queries:");
    if (this.queries == null) {
      sb.append("null");
    } else {
      sb.append(this.queries);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("done:");
    sb.append(this.done);
    first = false;
    if (!first) sb.append(", ");
    sb.append("started:");
    sb.append(this.started);
    first = false;
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

  private static class QueryPlanStandardSchemeFactory implements SchemeFactory {
    public QueryPlanStandardScheme getScheme() {
      return new QueryPlanStandardScheme();
    }
  }

  private static class QueryPlanStandardScheme extends StandardScheme<QueryPlan> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, QueryPlan struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // QUERIES
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list128 = iprot.readListBegin();
                struct.queries = new ArrayList<Query>(_list128.size);
                for (int _i129 = 0; _i129 < _list128.size; ++_i129)
                {
                  Query _elem130; // required
                  _elem130 = new Query();
                  _elem130.read(iprot);
                  struct.queries.add(_elem130);
                }
                iprot.readListEnd();
              }
              struct.setQueriesIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // DONE
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.done = iprot.readBool();
              struct.setDoneIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // STARTED
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.started = iprot.readBool();
              struct.setStartedIsSet(true);
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
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, QueryPlan struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.queries != null) {
        oprot.writeFieldBegin(QUERIES_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.queries.size()));
          for (Query _iter131 : struct.queries)
          {
            _iter131.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(DONE_FIELD_DESC);
      oprot.writeBool(struct.done);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(STARTED_FIELD_DESC);
      oprot.writeBool(struct.started);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class QueryPlanTupleSchemeFactory implements SchemeFactory {
    public QueryPlanTupleScheme getScheme() {
      return new QueryPlanTupleScheme();
    }
  }

  private static class QueryPlanTupleScheme extends TupleScheme<QueryPlan> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, QueryPlan struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetQueries()) {
        optionals.set(0);
      }
      if (struct.isSetDone()) {
        optionals.set(1);
      }
      if (struct.isSetStarted()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetQueries()) {
        {
          oprot.writeI32(struct.queries.size());
          for (Query _iter132 : struct.queries)
          {
            _iter132.write(oprot);
          }
        }
      }
      if (struct.isSetDone()) {
        oprot.writeBool(struct.done);
      }
      if (struct.isSetStarted()) {
        oprot.writeBool(struct.started);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, QueryPlan struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TList _list133 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.queries = new ArrayList<Query>(_list133.size);
          for (int _i134 = 0; _i134 < _list133.size; ++_i134)
          {
            Query _elem135; // required
            _elem135 = new Query();
            _elem135.read(iprot);
            struct.queries.add(_elem135);
          }
        }
        struct.setQueriesIsSet(true);
      }
      if (incoming.get(1)) {
        struct.done = iprot.readBool();
        struct.setDoneIsSet(true);
      }
      if (incoming.get(2)) {
        struct.started = iprot.readBool();
        struct.setStartedIsSet(true);
      }
    }
  }

}

