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

import com.filemaker.jwpc.fmwp.api.thrift.service.IDLLayoutSpec;
import com.filemaker.jwpc.fmwp.api.thrift.service.IDLRecord;
import com.filemaker.jwpc.fmwp.api.thrift.service.ReplyStatus;
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

public class IDLResultSet
implements TBase<IDLResultSet, _Fields>,
Serializable,
Cloneable,
Comparable<IDLResultSet> {
    private static final TStruct STRUCT_DESC = new TStruct("IDLResultSet");
    private static final TField STATUS_FIELD_DESC = new TField("status", 12, 1);
    private static final TField TOTAL_FOUND_FIELD_DESC = new TField("totalFound", 10, 2);
    private static final TField LAYOUT_FIELD_DESC = new TField("layout", 12, 3);
    private static final TField RECORDS_FIELD_DESC = new TField("records", 15, 4);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new IDLResultSetStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new IDLResultSetTupleSchemeFactory();
    @Nullable
    private ReplyStatus status;
    private long totalFound;
    @Nullable
    private IDLLayoutSpec layout;
    @Nullable
    private List<IDLRecord> records;
    private static final int __TOTALFOUND_ISSET_ID = 0;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public IDLResultSet() {
    }

    public IDLResultSet(ReplyStatus replyStatus, long l, IDLLayoutSpec iDLLayoutSpec, List<IDLRecord> list) {
        this();
        this.status = replyStatus;
        this.totalFound = l;
        this.setTotalFoundIsSet(true);
        this.layout = iDLLayoutSpec;
        this.records = list;
    }

    public IDLResultSet(IDLResultSet iDLResultSet) {
        this.__isset_bitfield = iDLResultSet.__isset_bitfield;
        if (iDLResultSet.isSetStatus()) {
            this.status = new ReplyStatus(iDLResultSet.status);
        }
        this.totalFound = iDLResultSet.totalFound;
        if (iDLResultSet.isSetLayout()) {
            this.layout = new IDLLayoutSpec(iDLResultSet.layout);
        }
        if (iDLResultSet.isSetRecords()) {
            ArrayList<IDLRecord> arrayList = new ArrayList<IDLRecord>(iDLResultSet.records.size());
            for (IDLRecord iDLRecord : iDLResultSet.records) {
                arrayList.add(new IDLRecord(iDLRecord));
            }
            this.records = arrayList;
        }
    }

    public IDLResultSet deepCopy() {
        return new IDLResultSet(this);
    }

    public void clear() {
        this.status = null;
        this.setTotalFoundIsSet(false);
        this.totalFound = 0L;
        this.layout = null;
        this.records = null;
    }

    @Nullable
    public ReplyStatus getStatus() {
        return this.status;
    }

    public void setStatus(@Nullable ReplyStatus replyStatus) {
        this.status = replyStatus;
    }

    public void unsetStatus() {
        this.status = null;
    }

    public boolean isSetStatus() {
        return this.status != null;
    }

    public void setStatusIsSet(boolean bl) {
        if (!bl) {
            this.status = null;
        }
    }

    public long getTotalFound() {
        return this.totalFound;
    }

    public void setTotalFound(long l) {
        this.totalFound = l;
        this.setTotalFoundIsSet(true);
    }

    public void unsetTotalFound() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetTotalFound() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setTotalFoundIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    @Nullable
    public IDLLayoutSpec getLayout() {
        return this.layout;
    }

    public void setLayout(@Nullable IDLLayoutSpec iDLLayoutSpec) {
        this.layout = iDLLayoutSpec;
    }

    public void unsetLayout() {
        this.layout = null;
    }

    public boolean isSetLayout() {
        return this.layout != null;
    }

    public void setLayoutIsSet(boolean bl) {
        if (!bl) {
            this.layout = null;
        }
    }

    public int getRecordsSize() {
        return this.records == null ? 0 : this.records.size();
    }

    @Nullable
    public Iterator<IDLRecord> getRecordsIterator() {
        return this.records == null ? null : this.records.iterator();
    }

    public void addToRecords(IDLRecord iDLRecord) {
        if (this.records == null) {
            this.records = new ArrayList<IDLRecord>();
        }
        this.records.add(iDLRecord);
    }

    @Nullable
    public List<IDLRecord> getRecords() {
        return this.records;
    }

    public void setRecords(@Nullable List<IDLRecord> list) {
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

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetStatus();
                    break;
                }
                this.setStatus((ReplyStatus)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetTotalFound();
                    break;
                }
                this.setTotalFound((Long)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetLayout();
                    break;
                }
                this.setLayout((IDLLayoutSpec)object);
                break;
            }
            case 3: {
                if (object == null) {
                    this.unsetRecords();
                    break;
                }
                this.setRecords((List)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getStatus();
            }
            case 1: {
                return this.getTotalFound();
            }
            case 2: {
                return this.getLayout();
            }
            case 3: {
                return this.getRecords();
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
                return this.isSetStatus();
            }
            case 1: {
                return this.isSetTotalFound();
            }
            case 2: {
                return this.isSetLayout();
            }
            case 3: {
                return this.isSetRecords();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof IDLResultSet) {
            return this.equals((IDLResultSet)object);
        }
        return false;
    }

    public boolean equals(IDLResultSet iDLResultSet) {
        if (iDLResultSet == null) {
            return false;
        }
        if (this == iDLResultSet) {
            return true;
        }
        boolean bl = this.isSetStatus();
        boolean bl2 = iDLResultSet.isSetStatus();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.status.equals(iDLResultSet.status)) {
                return false;
            }
        }
        boolean bl3 = true;
        boolean bl4 = true;
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (this.totalFound != iDLResultSet.totalFound) {
                return false;
            }
        }
        boolean bl5 = this.isSetLayout();
        boolean bl6 = iDLResultSet.isSetLayout();
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (!this.layout.equals(iDLResultSet.layout)) {
                return false;
            }
        }
        boolean bl7 = this.isSetRecords();
        boolean bl8 = iDLResultSet.isSetRecords();
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (!this.records.equals(iDLResultSet.records)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetStatus() ? 131071 : 524287);
        if (this.isSetStatus()) {
            n = n * 8191 + this.status.hashCode();
        }
        n = n * 8191 + TBaseHelper.hashCode((long)this.totalFound);
        n = n * 8191 + (this.isSetLayout() ? 131071 : 524287);
        if (this.isSetLayout()) {
            n = n * 8191 + this.layout.hashCode();
        }
        n = n * 8191 + (this.isSetRecords() ? 131071 : 524287);
        if (this.isSetRecords()) {
            n = n * 8191 + this.records.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(IDLResultSet iDLResultSet) {
        if (!this.getClass().equals(iDLResultSet.getClass())) {
            return this.getClass().getName().compareTo(iDLResultSet.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetStatus(), iDLResultSet.isSetStatus());
        if (n != 0) {
            return n;
        }
        if (this.isSetStatus() && (n = TBaseHelper.compareTo((Comparable)this.status, (Comparable)iDLResultSet.status)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetTotalFound(), iDLResultSet.isSetTotalFound());
        if (n != 0) {
            return n;
        }
        if (this.isSetTotalFound() && (n = TBaseHelper.compareTo((long)this.totalFound, (long)iDLResultSet.totalFound)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetLayout(), iDLResultSet.isSetLayout());
        if (n != 0) {
            return n;
        }
        if (this.isSetLayout() && (n = TBaseHelper.compareTo((Comparable)this.layout, (Comparable)iDLResultSet.layout)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetRecords(), iDLResultSet.isSetRecords());
        if (n != 0) {
            return n;
        }
        if (this.isSetRecords() && (n = TBaseHelper.compareTo(this.records, iDLResultSet.records)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        IDLResultSet.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        IDLResultSet.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("IDLResultSet(");
        boolean bl = true;
        stringBuilder.append("status:");
        if (this.status == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.status);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("totalFound:");
        stringBuilder.append(this.totalFound);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("layout:");
        if (this.layout == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.layout);
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
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void validate() throws TException {
        if (this.status != null) {
            this.status.validate();
        }
        if (this.layout != null) {
            this.layout.validate();
        }
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
        enumMap.put(_Fields.STATUS, new FieldMetaData("status", 3, (FieldValueMetaData)new StructMetaData(12, ReplyStatus.class)));
        enumMap.put(_Fields.TOTAL_FOUND, new FieldMetaData("totalFound", 3, new FieldValueMetaData(10)));
        enumMap.put(_Fields.LAYOUT, new FieldMetaData("layout", 3, (FieldValueMetaData)new StructMetaData(12, IDLLayoutSpec.class)));
        enumMap.put(_Fields.RECORDS, new FieldMetaData("records", 3, (FieldValueMetaData)new ListMetaData(15, (FieldValueMetaData)new StructMetaData(12, IDLRecord.class))));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(IDLResultSet.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        STATUS(1, "status"),
        TOTAL_FOUND(2, "totalFound"),
        LAYOUT(3, "layout"),
        RECORDS(4, "records");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return STATUS;
                }
                case 2: {
                    return TOTAL_FOUND;
                }
                case 3: {
                    return LAYOUT;
                }
                case 4: {
                    return RECORDS;
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

    private static class IDLResultSetStandardSchemeFactory
    implements SchemeFactory {
        private IDLResultSetStandardSchemeFactory() {
        }

        public IDLResultSetStandardScheme getScheme() {
            return new IDLResultSetStandardScheme();
        }
    }

    private static class IDLResultSetTupleSchemeFactory
    implements SchemeFactory {
        private IDLResultSetTupleSchemeFactory() {
        }

        public IDLResultSetTupleScheme getScheme() {
            return new IDLResultSetTupleScheme();
        }
    }

    private static class IDLResultSetTupleScheme
    extends TupleScheme<IDLResultSet> {
        private IDLResultSetTupleScheme() {
        }

        public void write(TProtocol tProtocol, IDLResultSet iDLResultSet) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (iDLResultSet.isSetStatus()) {
                bitSet.set(0);
            }
            if (iDLResultSet.isSetTotalFound()) {
                bitSet.set(1);
            }
            if (iDLResultSet.isSetLayout()) {
                bitSet.set(2);
            }
            if (iDLResultSet.isSetRecords()) {
                bitSet.set(3);
            }
            tTupleProtocol.writeBitSet(bitSet, 4);
            if (iDLResultSet.isSetStatus()) {
                iDLResultSet.status.write((TProtocol)tTupleProtocol);
            }
            if (iDLResultSet.isSetTotalFound()) {
                tTupleProtocol.writeI64(iDLResultSet.totalFound);
            }
            if (iDLResultSet.isSetLayout()) {
                iDLResultSet.layout.write((TProtocol)tTupleProtocol);
            }
            if (iDLResultSet.isSetRecords()) {
                tTupleProtocol.writeI32(iDLResultSet.records.size());
                for (IDLRecord iDLRecord : iDLResultSet.records) {
                    iDLRecord.write((TProtocol)tTupleProtocol);
                }
            }
        }

        public void read(TProtocol tProtocol, IDLResultSet iDLResultSet) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(4);
            if (bitSet.get(0)) {
                iDLResultSet.status = new ReplyStatus();
                iDLResultSet.status.read((TProtocol)tTupleProtocol);
                iDLResultSet.setStatusIsSet(true);
            }
            if (bitSet.get(1)) {
                iDLResultSet.totalFound = tTupleProtocol.readI64();
                iDLResultSet.setTotalFoundIsSet(true);
            }
            if (bitSet.get(2)) {
                iDLResultSet.layout = new IDLLayoutSpec();
                iDLResultSet.layout.read((TProtocol)tTupleProtocol);
                iDLResultSet.setLayoutIsSet(true);
            }
            if (bitSet.get(3)) {
                TList tList = tTupleProtocol.readListBegin((byte)12);
                iDLResultSet.records = new ArrayList<IDLRecord>(tList.size);
                for (int i = 0; i < tList.size; ++i) {
                    IDLRecord iDLRecord = new IDLRecord();
                    iDLRecord.read((TProtocol)tTupleProtocol);
                    iDLResultSet.records.add(iDLRecord);
                }
                iDLResultSet.setRecordsIsSet(true);
            }
        }
    }

    private static class IDLResultSetStandardScheme
    extends StandardScheme<IDLResultSet> {
        private IDLResultSetStandardScheme() {
        }

        public void read(TProtocol tProtocol, IDLResultSet iDLResultSet) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 12) {
                            iDLResultSet.status = new ReplyStatus();
                            iDLResultSet.status.read(tProtocol);
                            iDLResultSet.setStatusIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 10) {
                            iDLResultSet.totalFound = tProtocol.readI64();
                            iDLResultSet.setTotalFoundIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 12) {
                            iDLResultSet.layout = new IDLLayoutSpec();
                            iDLResultSet.layout.read(tProtocol);
                            iDLResultSet.setLayoutIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 15) {
                            TList tList = tProtocol.readListBegin();
                            iDLResultSet.records = new ArrayList<IDLRecord>(tList.size);
                            for (int i = 0; i < tList.size; ++i) {
                                IDLRecord iDLRecord = new IDLRecord();
                                iDLRecord.read(tProtocol);
                                iDLResultSet.records.add(iDLRecord);
                            }
                            tProtocol.readListEnd();
                            iDLResultSet.setRecordsIsSet(true);
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
            iDLResultSet.validate();
        }

        public void write(TProtocol tProtocol, IDLResultSet iDLResultSet) throws TException {
            iDLResultSet.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (iDLResultSet.status != null) {
                tProtocol.writeFieldBegin(STATUS_FIELD_DESC);
                iDLResultSet.status.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(TOTAL_FOUND_FIELD_DESC);
            tProtocol.writeI64(iDLResultSet.totalFound);
            tProtocol.writeFieldEnd();
            if (iDLResultSet.layout != null) {
                tProtocol.writeFieldBegin(LAYOUT_FIELD_DESC);
                iDLResultSet.layout.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            if (iDLResultSet.records != null) {
                tProtocol.writeFieldBegin(RECORDS_FIELD_DESC);
                tProtocol.writeListBegin(new TList(12, iDLResultSet.records.size()));
                for (IDLRecord iDLRecord : iDLResultSet.records) {
                    iDLRecord.write(tProtocol);
                }
                tProtocol.writeListEnd();
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

