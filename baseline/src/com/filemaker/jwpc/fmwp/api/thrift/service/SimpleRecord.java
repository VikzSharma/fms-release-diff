/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.thrift.EncodingUtils
 *  org.apache.thrift.TBase
 *  org.apache.thrift.TBaseHelper
 *  org.apache.thrift.TException
 *  org.apache.thrift.TFieldIdEnum
 *  org.apache.thrift.annotation.Nullable
 *  org.apache.thrift.meta_data.FieldMetaData
 *  org.apache.thrift.meta_data.FieldValueMetaData
 *  org.apache.thrift.meta_data.ListMetaData
 *  org.apache.thrift.meta_data.StructMetaData
 *  org.apache.thrift.protocol.TCompactProtocol
 *  org.apache.thrift.protocol.TField
 *  org.apache.thrift.protocol.TList
 *  org.apache.thrift.protocol.TProtocol
 *  org.apache.thrift.protocol.TProtocolUtil
 *  org.apache.thrift.protocol.TStruct
 *  org.apache.thrift.protocol.TTupleProtocol
 *  org.apache.thrift.scheme.IScheme
 *  org.apache.thrift.scheme.SchemeFactory
 *  org.apache.thrift.scheme.StandardScheme
 *  org.apache.thrift.scheme.TupleScheme
 *  org.apache.thrift.transport.TIOStreamTransport
 *  org.apache.thrift.transport.TTransport
 */
package com.filemaker.jwpc.fmwp.api.thrift.service;

import com.filemaker.jwpc.fmwp.api.thrift.service.IDLField;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TBase;
import org.apache.thrift.TBaseHelper;
import org.apache.thrift.TException;
import org.apache.thrift.TFieldIdEnum;
import org.apache.thrift.annotation.Nullable;
import org.apache.thrift.meta_data.FieldMetaData;
import org.apache.thrift.meta_data.FieldValueMetaData;
import org.apache.thrift.meta_data.ListMetaData;
import org.apache.thrift.meta_data.StructMetaData;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TList;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolUtil;
import org.apache.thrift.protocol.TStruct;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;
import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.transport.TIOStreamTransport;
import org.apache.thrift.transport.TTransport;

public class SimpleRecord
implements TBase<SimpleRecord, _Fields>,
Serializable,
Cloneable,
Comparable<SimpleRecord> {
    private static final TStruct STRUCT_DESC = new TStruct("SimpleRecord");
    private static final TField RECORD_ID_FIELD_DESC = new TField("recordId", 11, 1);
    private static final TField MOD_COUNT_FIELD_DESC = new TField("modCount", 10, 2);
    private static final TField FIELDS_FIELD_DESC = new TField("fields", 15, 3);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new SimpleRecordStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new SimpleRecordTupleSchemeFactory();
    @Nullable
    private String recordId;
    private long modCount;
    @Nullable
    private List<IDLField> fields;
    private static final int __MODCOUNT_ISSET_ID = 0;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public SimpleRecord() {
    }

    public SimpleRecord(String string, long l, List<IDLField> list) {
        this();
        this.recordId = string;
        this.modCount = l;
        this.setModCountIsSet(true);
        this.fields = list;
    }

    public SimpleRecord(SimpleRecord simpleRecord) {
        this.__isset_bitfield = simpleRecord.__isset_bitfield;
        if (simpleRecord.isSetRecordId()) {
            this.recordId = simpleRecord.recordId;
        }
        this.modCount = simpleRecord.modCount;
        if (simpleRecord.isSetFields()) {
            ArrayList<IDLField> arrayList = new ArrayList<IDLField>(simpleRecord.fields.size());
            for (IDLField iDLField : simpleRecord.fields) {
                arrayList.add(new IDLField(iDLField));
            }
            this.fields = arrayList;
        }
    }

    public SimpleRecord deepCopy() {
        return new SimpleRecord(this);
    }

    public void clear() {
        this.recordId = null;
        this.setModCountIsSet(false);
        this.modCount = 0L;
        this.fields = null;
    }

    @Nullable
    public String getRecordId() {
        return this.recordId;
    }

    public void setRecordId(@Nullable String string) {
        this.recordId = string;
    }

    public void unsetRecordId() {
        this.recordId = null;
    }

    public boolean isSetRecordId() {
        return this.recordId != null;
    }

    public void setRecordIdIsSet(boolean bl) {
        if (!bl) {
            this.recordId = null;
        }
    }

    public long getModCount() {
        return this.modCount;
    }

    public void setModCount(long l) {
        this.modCount = l;
        this.setModCountIsSet(true);
    }

    public void unsetModCount() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetModCount() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setModCountIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public int getFieldsSize() {
        return this.fields == null ? 0 : this.fields.size();
    }

    @Nullable
    public Iterator<IDLField> getFieldsIterator() {
        return this.fields == null ? null : this.fields.iterator();
    }

    public void addToFields(IDLField iDLField) {
        if (this.fields == null) {
            this.fields = new ArrayList<IDLField>();
        }
        this.fields.add(iDLField);
    }

    @Nullable
    public List<IDLField> getFields() {
        return this.fields;
    }

    public void setFields(@Nullable List<IDLField> list) {
        this.fields = list;
    }

    public void unsetFields() {
        this.fields = null;
    }

    public boolean isSetFields() {
        return this.fields != null;
    }

    public void setFieldsIsSet(boolean bl) {
        if (!bl) {
            this.fields = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetRecordId();
                    break;
                }
                this.setRecordId((String)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetModCount();
                    break;
                }
                this.setModCount((Long)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetFields();
                    break;
                }
                this.setFields((List)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getRecordId();
            }
            case 1: {
                return this.getModCount();
            }
            case 2: {
                return this.getFields();
            }
        }
        throw new IllegalStateException();
    }

    public boolean isSet(_Fields _Fields2) {
        if (_Fields2 == null) {
            throw new IllegalArgumentException();
        }
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.isSetRecordId();
            }
            case 1: {
                return this.isSetModCount();
            }
            case 2: {
                return this.isSetFields();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof SimpleRecord) {
            return this.equals((SimpleRecord)object);
        }
        return false;
    }

    public boolean equals(SimpleRecord simpleRecord) {
        if (simpleRecord == null) {
            return false;
        }
        if (this == simpleRecord) {
            return true;
        }
        boolean bl = this.isSetRecordId();
        boolean bl2 = simpleRecord.isSetRecordId();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.recordId.equals(simpleRecord.recordId)) {
                return false;
            }
        }
        boolean bl3 = true;
        boolean bl4 = true;
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (this.modCount != simpleRecord.modCount) {
                return false;
            }
        }
        boolean bl5 = this.isSetFields();
        boolean bl6 = simpleRecord.isSetFields();
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (!this.fields.equals(simpleRecord.fields)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetRecordId() ? 131071 : 524287);
        if (this.isSetRecordId()) {
            n = n * 8191 + this.recordId.hashCode();
        }
        n = n * 8191 + TBaseHelper.hashCode((long)this.modCount);
        n = n * 8191 + (this.isSetFields() ? 131071 : 524287);
        if (this.isSetFields()) {
            n = n * 8191 + this.fields.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(SimpleRecord simpleRecord) {
        if (!this.getClass().equals(simpleRecord.getClass())) {
            return this.getClass().getName().compareTo(simpleRecord.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetRecordId(), simpleRecord.isSetRecordId());
        if (n != 0) {
            return n;
        }
        if (this.isSetRecordId() && (n = TBaseHelper.compareTo((String)this.recordId, (String)simpleRecord.recordId)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetModCount(), simpleRecord.isSetModCount());
        if (n != 0) {
            return n;
        }
        if (this.isSetModCount() && (n = TBaseHelper.compareTo((long)this.modCount, (long)simpleRecord.modCount)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetFields(), simpleRecord.isSetFields());
        if (n != 0) {
            return n;
        }
        if (this.isSetFields() && (n = TBaseHelper.compareTo(this.fields, simpleRecord.fields)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        SimpleRecord.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        SimpleRecord.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("SimpleRecord(");
        boolean bl = true;
        stringBuilder.append("recordId:");
        if (this.recordId == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.recordId);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("modCount:");
        stringBuilder.append(this.modCount);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("fields:");
        if (this.fields == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.fields);
        }
        bl = false;
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void validate() throws TException {
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            this.write((TProtocol)new TCompactProtocol((TTransport)new TIOStreamTransport((OutputStream)objectOutputStream)));
        }
        catch (TException tException) {
            throw new IOException(tException);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.__isset_bitfield = 0;
            this.read((TProtocol)new TCompactProtocol((TTransport)new TIOStreamTransport((InputStream)objectInputStream)));
        }
        catch (TException tException) {
            throw new IOException(tException);
        }
    }

    private static <S extends IScheme> S scheme(TProtocol tProtocol) {
        return (S)(StandardScheme.class.equals((Object)tProtocol.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
    }

    static {
        EnumMap<_Fields, FieldMetaData> enumMap = new EnumMap<_Fields, FieldMetaData>(_Fields.class);
        enumMap.put(_Fields.RECORD_ID, new FieldMetaData("recordId", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.MOD_COUNT, new FieldMetaData("modCount", 3, new FieldValueMetaData(10)));
        enumMap.put(_Fields.FIELDS, new FieldMetaData("fields", 3, (FieldValueMetaData)new ListMetaData(15, (FieldValueMetaData)new StructMetaData(12, IDLField.class))));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(SimpleRecord.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        RECORD_ID(1, "recordId"),
        MOD_COUNT(2, "modCount"),
        FIELDS(3, "fields");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return RECORD_ID;
                }
                case 2: {
                    return MOD_COUNT;
                }
                case 3: {
                    return FIELDS;
                }
            }
            return null;
        }

        public static _Fields findByThriftIdOrThrow(int n) {
            _Fields _Fields2 = _Fields.findByThriftId(n);
            if (_Fields2 == null) {
                throw new IllegalArgumentException("Field " + n + " doesn't exist!");
            }
            return _Fields2;
        }

        @Nullable
        public static _Fields findByName(String string) {
            return byName.get(string);
        }

        private _Fields(short s, String string2) {
            this._thriftId = s;
            this._fieldName = string2;
        }

        public short getThriftFieldId() {
            return this._thriftId;
        }

        public String getFieldName() {
            return this._fieldName;
        }

        static {
            byName = new HashMap<String, _Fields>();
            for (_Fields _Fields2 : EnumSet.allOf(_Fields.class)) {
                byName.put(_Fields2.getFieldName(), _Fields2);
            }
        }
    }

    private static class SimpleRecordStandardSchemeFactory
    implements SchemeFactory {
        private SimpleRecordStandardSchemeFactory() {
        }

        public SimpleRecordStandardScheme getScheme() {
            return new SimpleRecordStandardScheme();
        }
    }

    private static class SimpleRecordTupleSchemeFactory
    implements SchemeFactory {
        private SimpleRecordTupleSchemeFactory() {
        }

        public SimpleRecordTupleScheme getScheme() {
            return new SimpleRecordTupleScheme();
        }
    }

    private static class SimpleRecordTupleScheme
    extends TupleScheme<SimpleRecord> {
        private SimpleRecordTupleScheme() {
        }

        public void write(TProtocol tProtocol, SimpleRecord simpleRecord) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (simpleRecord.isSetRecordId()) {
                bitSet.set(0);
            }
            if (simpleRecord.isSetModCount()) {
                bitSet.set(1);
            }
            if (simpleRecord.isSetFields()) {
                bitSet.set(2);
            }
            tTupleProtocol.writeBitSet(bitSet, 3);
            if (simpleRecord.isSetRecordId()) {
                tTupleProtocol.writeString(simpleRecord.recordId);
            }
            if (simpleRecord.isSetModCount()) {
                tTupleProtocol.writeI64(simpleRecord.modCount);
            }
            if (simpleRecord.isSetFields()) {
                tTupleProtocol.writeI32(simpleRecord.fields.size());
                for (IDLField iDLField : simpleRecord.fields) {
                    iDLField.write((TProtocol)tTupleProtocol);
                }
            }
        }

        public void read(TProtocol tProtocol, SimpleRecord simpleRecord) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(3);
            if (bitSet.get(0)) {
                simpleRecord.recordId = tTupleProtocol.readString();
                simpleRecord.setRecordIdIsSet(true);
            }
            if (bitSet.get(1)) {
                simpleRecord.modCount = tTupleProtocol.readI64();
                simpleRecord.setModCountIsSet(true);
            }
            if (bitSet.get(2)) {
                TList tList = tTupleProtocol.readListBegin((byte)12);
                simpleRecord.fields = new ArrayList<IDLField>(tList.size);
                for (int i = 0; i < tList.size; ++i) {
                    IDLField iDLField = new IDLField();
                    iDLField.read((TProtocol)tTupleProtocol);
                    simpleRecord.fields.add(iDLField);
                }
                simpleRecord.setFieldsIsSet(true);
            }
        }
    }

    private static class SimpleRecordStandardScheme
    extends StandardScheme<SimpleRecord> {
        private SimpleRecordStandardScheme() {
        }

        public void read(TProtocol tProtocol, SimpleRecord simpleRecord) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 11) {
                            simpleRecord.recordId = tProtocol.readString();
                            simpleRecord.setRecordIdIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 10) {
                            simpleRecord.modCount = tProtocol.readI64();
                            simpleRecord.setModCountIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 15) {
                            TList tList = tProtocol.readListBegin();
                            simpleRecord.fields = new ArrayList<IDLField>(tList.size);
                            for (int i = 0; i < tList.size; ++i) {
                                IDLField iDLField = new IDLField();
                                iDLField.read(tProtocol);
                                simpleRecord.fields.add(iDLField);
                            }
                            tProtocol.readListEnd();
                            simpleRecord.setFieldsIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    default: {
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                    }
                }
                tProtocol.readFieldEnd();
            }
            tProtocol.readStructEnd();
            simpleRecord.validate();
        }

        public void write(TProtocol tProtocol, SimpleRecord simpleRecord) throws TException {
            simpleRecord.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (simpleRecord.recordId != null) {
                tProtocol.writeFieldBegin(RECORD_ID_FIELD_DESC);
                tProtocol.writeString(simpleRecord.recordId);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(MOD_COUNT_FIELD_DESC);
            tProtocol.writeI64(simpleRecord.modCount);
            tProtocol.writeFieldEnd();
            if (simpleRecord.fields != null) {
                tProtocol.writeFieldBegin(FIELDS_FIELD_DESC);
                tProtocol.writeListBegin(new TList(12, simpleRecord.fields.size()));
                for (IDLField iDLField : simpleRecord.fields) {
                    iDLField.write(tProtocol);
                }
                tProtocol.writeListEnd();
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

