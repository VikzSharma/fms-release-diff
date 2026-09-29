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

import com.filemaker.jwpc.fmwp.api.thrift.service.SimpleRecord;
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

public class IDLPortal
implements TBase<IDLPortal, _Fields>,
Serializable,
Cloneable,
Comparable<IDLPortal> {
    private static final TStruct STRUCT_DESC = new TStruct("IDLPortal");
    private static final TField TABLE_FIELD_DESC = new TField("table", 11, 1);
    private static final TField RECORDS_FIELD_DESC = new TField("records", 15, 2);
    private static final TField TOTAL_RECORDS_FIELD_DESC = new TField("totalRecords", 10, 3);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new IDLPortalStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new IDLPortalTupleSchemeFactory();
    @Nullable
    private String table;
    @Nullable
    private List<SimpleRecord> records;
    private long totalRecords;
    private static final int __TOTALRECORDS_ISSET_ID = 0;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public IDLPortal() {
    }

    public IDLPortal(String string, List<SimpleRecord> list, long l) {
        this();
        this.table = string;
        this.records = list;
        this.totalRecords = l;
        this.setTotalRecordsIsSet(true);
    }

    public IDLPortal(IDLPortal iDLPortal) {
        this.__isset_bitfield = iDLPortal.__isset_bitfield;
        if (iDLPortal.isSetTable()) {
            this.table = iDLPortal.table;
        }
        if (iDLPortal.isSetRecords()) {
            ArrayList<SimpleRecord> arrayList = new ArrayList<SimpleRecord>(iDLPortal.records.size());
            for (SimpleRecord simpleRecord : iDLPortal.records) {
                arrayList.add(new SimpleRecord(simpleRecord));
            }
            this.records = arrayList;
        }
        this.totalRecords = iDLPortal.totalRecords;
    }

    public IDLPortal deepCopy() {
        return new IDLPortal(this);
    }

    public void clear() {
        this.table = null;
        this.records = null;
        this.setTotalRecordsIsSet(false);
        this.totalRecords = 0L;
    }

    @Nullable
    public String getTable() {
        return this.table;
    }

    public void setTable(@Nullable String string) {
        this.table = string;
    }

    public void unsetTable() {
        this.table = null;
    }

    public boolean isSetTable() {
        return this.table != null;
    }

    public void setTableIsSet(boolean bl) {
        if (!bl) {
            this.table = null;
        }
    }

    public int getRecordsSize() {
        return this.records == null ? 0 : this.records.size();
    }

    @Nullable
    public Iterator<SimpleRecord> getRecordsIterator() {
        return this.records == null ? null : this.records.iterator();
    }

    public void addToRecords(SimpleRecord simpleRecord) {
        if (this.records == null) {
            this.records = new ArrayList<SimpleRecord>();
        }
        this.records.add(simpleRecord);
    }

    @Nullable
    public List<SimpleRecord> getRecords() {
        return this.records;
    }

    public void setRecords(@Nullable List<SimpleRecord> list) {
        this.records = list;
    }

    public void unsetRecords() {
        this.records = null;
    }

    public boolean isSetRecords() {
        return this.records != null;
    }

    public void setRecordsIsSet(boolean bl) {
        if (!bl) {
            this.records = null;
        }
    }

    public long getTotalRecords() {
        return this.totalRecords;
    }

    public void setTotalRecords(long l) {
        this.totalRecords = l;
        this.setTotalRecordsIsSet(true);
    }

    public void unsetTotalRecords() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetTotalRecords() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setTotalRecordsIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetTable();
                    break;
                }
                this.setTable((String)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetRecords();
                    break;
                }
                this.setRecords((List)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetTotalRecords();
                    break;
                }
                this.setTotalRecords((Long)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getTable();
            }
            case 1: {
                return this.getRecords();
            }
            case 2: {
                return this.getTotalRecords();
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
                return this.isSetTable();
            }
            case 1: {
                return this.isSetRecords();
            }
            case 2: {
                return this.isSetTotalRecords();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof IDLPortal) {
            return this.equals((IDLPortal)object);
        }
        return false;
    }

    public boolean equals(IDLPortal iDLPortal) {
        if (iDLPortal == null) {
            return false;
        }
        if (this == iDLPortal) {
            return true;
        }
        boolean bl = this.isSetTable();
        boolean bl2 = iDLPortal.isSetTable();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.table.equals(iDLPortal.table)) {
                return false;
            }
        }
        boolean bl3 = this.isSetRecords();
        boolean bl4 = iDLPortal.isSetRecords();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.records.equals(iDLPortal.records)) {
                return false;
            }
        }
        boolean bl5 = true;
        boolean bl6 = true;
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (this.totalRecords != iDLPortal.totalRecords) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetTable() ? 131071 : 524287);
        if (this.isSetTable()) {
            n = n * 8191 + this.table.hashCode();
        }
        n = n * 8191 + (this.isSetRecords() ? 131071 : 524287);
        if (this.isSetRecords()) {
            n = n * 8191 + this.records.hashCode();
        }
        n = n * 8191 + TBaseHelper.hashCode((long)this.totalRecords);
        return n;
    }

    @Override
    public int compareTo(IDLPortal iDLPortal) {
        if (!this.getClass().equals(iDLPortal.getClass())) {
            return this.getClass().getName().compareTo(iDLPortal.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetTable(), iDLPortal.isSetTable());
        if (n != 0) {
            return n;
        }
        if (this.isSetTable() && (n = TBaseHelper.compareTo((String)this.table, (String)iDLPortal.table)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetRecords(), iDLPortal.isSetRecords());
        if (n != 0) {
            return n;
        }
        if (this.isSetRecords() && (n = TBaseHelper.compareTo(this.records, iDLPortal.records)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetTotalRecords(), iDLPortal.isSetTotalRecords());
        if (n != 0) {
            return n;
        }
        if (this.isSetTotalRecords() && (n = TBaseHelper.compareTo((long)this.totalRecords, (long)iDLPortal.totalRecords)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        IDLPortal.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        IDLPortal.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("IDLPortal(");
        boolean bl = true;
        stringBuilder.append("table:");
        if (this.table == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.table);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("records:");
        if (this.records == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.records);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("totalRecords:");
        stringBuilder.append(this.totalRecords);
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
        enumMap.put(_Fields.TABLE, new FieldMetaData("table", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.RECORDS, new FieldMetaData("records", 3, (FieldValueMetaData)new ListMetaData(15, (FieldValueMetaData)new StructMetaData(12, SimpleRecord.class))));
        enumMap.put(_Fields.TOTAL_RECORDS, new FieldMetaData("totalRecords", 3, new FieldValueMetaData(10)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(IDLPortal.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        TABLE(1, "table"),
        RECORDS(2, "records"),
        TOTAL_RECORDS(3, "totalRecords");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return TABLE;
                }
                case 2: {
                    return RECORDS;
                }
                case 3: {
                    return TOTAL_RECORDS;
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

    private static class IDLPortalStandardSchemeFactory
    implements SchemeFactory {
        private IDLPortalStandardSchemeFactory() {
        }

        public IDLPortalStandardScheme getScheme() {
            return new IDLPortalStandardScheme();
        }
    }

    private static class IDLPortalTupleSchemeFactory
    implements SchemeFactory {
        private IDLPortalTupleSchemeFactory() {
        }

        public IDLPortalTupleScheme getScheme() {
            return new IDLPortalTupleScheme();
        }
    }

    private static class IDLPortalTupleScheme
    extends TupleScheme<IDLPortal> {
        private IDLPortalTupleScheme() {
        }

        public void write(TProtocol tProtocol, IDLPortal iDLPortal) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (iDLPortal.isSetTable()) {
                bitSet.set(0);
            }
            if (iDLPortal.isSetRecords()) {
                bitSet.set(1);
            }
            if (iDLPortal.isSetTotalRecords()) {
                bitSet.set(2);
            }
            tTupleProtocol.writeBitSet(bitSet, 3);
            if (iDLPortal.isSetTable()) {
                tTupleProtocol.writeString(iDLPortal.table);
            }
            if (iDLPortal.isSetRecords()) {
                tTupleProtocol.writeI32(iDLPortal.records.size());
                for (SimpleRecord simpleRecord : iDLPortal.records) {
                    simpleRecord.write((TProtocol)tTupleProtocol);
                }
            }
            if (iDLPortal.isSetTotalRecords()) {
                tTupleProtocol.writeI64(iDLPortal.totalRecords);
            }
        }

        public void read(TProtocol tProtocol, IDLPortal iDLPortal) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(3);
            if (bitSet.get(0)) {
                iDLPortal.table = tTupleProtocol.readString();
                iDLPortal.setTableIsSet(true);
            }
            if (bitSet.get(1)) {
                TList tList = tTupleProtocol.readListBegin((byte)12);
                iDLPortal.records = new ArrayList<SimpleRecord>(tList.size);
                for (int i = 0; i < tList.size; ++i) {
                    SimpleRecord simpleRecord = new SimpleRecord();
                    simpleRecord.read((TProtocol)tTupleProtocol);
                    iDLPortal.records.add(simpleRecord);
                }
                iDLPortal.setRecordsIsSet(true);
            }
            if (bitSet.get(2)) {
                iDLPortal.totalRecords = tTupleProtocol.readI64();
                iDLPortal.setTotalRecordsIsSet(true);
            }
        }
    }

    private static class IDLPortalStandardScheme
    extends StandardScheme<IDLPortal> {
        private IDLPortalStandardScheme() {
        }

        public void read(TProtocol tProtocol, IDLPortal iDLPortal) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 11) {
                            iDLPortal.table = tProtocol.readString();
                            iDLPortal.setTableIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 15) {
                            TList tList = tProtocol.readListBegin();
                            iDLPortal.records = new ArrayList<SimpleRecord>(tList.size);
                            for (int i = 0; i < tList.size; ++i) {
                                SimpleRecord simpleRecord = new SimpleRecord();
                                simpleRecord.read(tProtocol);
                                iDLPortal.records.add(simpleRecord);
                            }
                            tProtocol.readListEnd();
                            iDLPortal.setRecordsIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 10) {
                            iDLPortal.totalRecords = tProtocol.readI64();
                            iDLPortal.setTotalRecordsIsSet(true);
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
            iDLPortal.validate();
        }

        public void write(TProtocol tProtocol, IDLPortal iDLPortal) throws TException {
            iDLPortal.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (iDLPortal.table != null) {
                tProtocol.writeFieldBegin(TABLE_FIELD_DESC);
                tProtocol.writeString(iDLPortal.table);
                tProtocol.writeFieldEnd();
            }
            if (iDLPortal.records != null) {
                tProtocol.writeFieldBegin(RECORDS_FIELD_DESC);
                tProtocol.writeListBegin(new TList(12, iDLPortal.records.size()));
                for (SimpleRecord simpleRecord : iDLPortal.records) {
                    simpleRecord.write(tProtocol);
                }
                tProtocol.writeListEnd();
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(TOTAL_RECORDS_FIELD_DESC);
            tProtocol.writeI64(iDLPortal.totalRecords);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

