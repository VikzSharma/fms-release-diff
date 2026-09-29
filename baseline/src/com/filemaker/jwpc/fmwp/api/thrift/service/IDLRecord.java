/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
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

import com.filemaker.jwpc.fmwp.api.thrift.service.IDLPortal;
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

public class IDLRecord
implements TBase<IDLRecord, _Fields>,
Serializable,
Cloneable,
Comparable<IDLRecord> {
    private static final TStruct STRUCT_DESC = new TStruct("IDLRecord");
    private static final TField RECORD_FIELD_DESC = new TField("record", 12, 1);
    private static final TField PORTALS_FIELD_DESC = new TField("portals", 15, 2);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new IDLRecordStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new IDLRecordTupleSchemeFactory();
    @Nullable
    private SimpleRecord record;
    @Nullable
    private List<IDLPortal> portals;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public IDLRecord() {
    }

    public IDLRecord(SimpleRecord simpleRecord, List<IDLPortal> list) {
        this();
        this.record = simpleRecord;
        this.portals = list;
    }

    public IDLRecord(IDLRecord iDLRecord) {
        if (iDLRecord.isSetRecord()) {
            this.record = new SimpleRecord(iDLRecord.record);
        }
        if (iDLRecord.isSetPortals()) {
            ArrayList<IDLPortal> arrayList = new ArrayList<IDLPortal>(iDLRecord.portals.size());
            for (IDLPortal iDLPortal : iDLRecord.portals) {
                arrayList.add(new IDLPortal(iDLPortal));
            }
            this.portals = arrayList;
        }
    }

    public IDLRecord deepCopy() {
        return new IDLRecord(this);
    }

    public void clear() {
        this.record = null;
        this.portals = null;
    }

    @Nullable
    public SimpleRecord getRecord() {
        return this.record;
    }

    public void setRecord(@Nullable SimpleRecord simpleRecord) {
        this.record = simpleRecord;
    }

    public void unsetRecord() {
        this.record = null;
    }

    public boolean isSetRecord() {
        return this.record != null;
    }

    public void setRecordIsSet(boolean bl) {
        if (!bl) {
            this.record = null;
        }
    }

    public int getPortalsSize() {
        return this.portals == null ? 0 : this.portals.size();
    }

    @Nullable
    public Iterator<IDLPortal> getPortalsIterator() {
        return this.portals == null ? null : this.portals.iterator();
    }

    public void addToPortals(IDLPortal iDLPortal) {
        if (this.portals == null) {
            this.portals = new ArrayList<IDLPortal>();
        }
        this.portals.add(iDLPortal);
    }

    @Nullable
    public List<IDLPortal> getPortals() {
        return this.portals;
    }

    public void setPortals(@Nullable List<IDLPortal> list) {
        this.portals = list;
    }

    public void unsetPortals() {
        this.portals = null;
    }

    public boolean isSetPortals() {
        return this.portals != null;
    }

    public void setPortalsIsSet(boolean bl) {
        if (!bl) {
            this.portals = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetRecord();
                    break;
                }
                this.setRecord((SimpleRecord)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetPortals();
                    break;
                }
                this.setPortals((List)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getRecord();
            }
            case 1: {
                return this.getPortals();
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
                return this.isSetRecord();
            }
            case 1: {
                return this.isSetPortals();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof IDLRecord) {
            return this.equals((IDLRecord)object);
        }
        return false;
    }

    public boolean equals(IDLRecord iDLRecord) {
        if (iDLRecord == null) {
            return false;
        }
        if (this == iDLRecord) {
            return true;
        }
        boolean bl = this.isSetRecord();
        boolean bl2 = iDLRecord.isSetRecord();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.record.equals(iDLRecord.record)) {
                return false;
            }
        }
        boolean bl3 = this.isSetPortals();
        boolean bl4 = iDLRecord.isSetPortals();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.portals.equals(iDLRecord.portals)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetRecord() ? 131071 : 524287);
        if (this.isSetRecord()) {
            n = n * 8191 + this.record.hashCode();
        }
        n = n * 8191 + (this.isSetPortals() ? 131071 : 524287);
        if (this.isSetPortals()) {
            n = n * 8191 + this.portals.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(IDLRecord iDLRecord) {
        if (!this.getClass().equals(iDLRecord.getClass())) {
            return this.getClass().getName().compareTo(iDLRecord.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetRecord(), iDLRecord.isSetRecord());
        if (n != 0) {
            return n;
        }
        if (this.isSetRecord() && (n = TBaseHelper.compareTo((Comparable)this.record, (Comparable)iDLRecord.record)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetPortals(), iDLRecord.isSetPortals());
        if (n != 0) {
            return n;
        }
        if (this.isSetPortals() && (n = TBaseHelper.compareTo(this.portals, iDLRecord.portals)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        IDLRecord.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        IDLRecord.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("IDLRecord(");
        boolean bl = true;
        stringBuilder.append("record:");
        if (this.record == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.record);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("portals:");
        if (this.portals == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.portals);
        }
        bl = false;
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void validate() throws TException {
        if (this.record != null) {
            this.record.validate();
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
        enumMap.put(_Fields.RECORD, new FieldMetaData("record", 3, (FieldValueMetaData)new StructMetaData(12, SimpleRecord.class)));
        enumMap.put(_Fields.PORTALS, new FieldMetaData("portals", 3, (FieldValueMetaData)new ListMetaData(15, (FieldValueMetaData)new StructMetaData(12, IDLPortal.class))));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(IDLRecord.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        RECORD(1, "record"),
        PORTALS(2, "portals");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return RECORD;
                }
                case 2: {
                    return PORTALS;
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

    private static class IDLRecordStandardSchemeFactory
    implements SchemeFactory {
        private IDLRecordStandardSchemeFactory() {
        }

        public IDLRecordStandardScheme getScheme() {
            return new IDLRecordStandardScheme();
        }
    }

    private static class IDLRecordTupleSchemeFactory
    implements SchemeFactory {
        private IDLRecordTupleSchemeFactory() {
        }

        public IDLRecordTupleScheme getScheme() {
            return new IDLRecordTupleScheme();
        }
    }

    private static class IDLRecordTupleScheme
    extends TupleScheme<IDLRecord> {
        private IDLRecordTupleScheme() {
        }

        public void write(TProtocol tProtocol, IDLRecord iDLRecord) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (iDLRecord.isSetRecord()) {
                bitSet.set(0);
            }
            if (iDLRecord.isSetPortals()) {
                bitSet.set(1);
            }
            tTupleProtocol.writeBitSet(bitSet, 2);
            if (iDLRecord.isSetRecord()) {
                iDLRecord.record.write((TProtocol)tTupleProtocol);
            }
            if (iDLRecord.isSetPortals()) {
                tTupleProtocol.writeI32(iDLRecord.portals.size());
                for (IDLPortal iDLPortal : iDLRecord.portals) {
                    iDLPortal.write((TProtocol)tTupleProtocol);
                }
            }
        }

        public void read(TProtocol tProtocol, IDLRecord iDLRecord) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(2);
            if (bitSet.get(0)) {
                iDLRecord.record = new SimpleRecord();
                iDLRecord.record.read((TProtocol)tTupleProtocol);
                iDLRecord.setRecordIsSet(true);
            }
            if (bitSet.get(1)) {
                TList tList = tTupleProtocol.readListBegin((byte)12);
                iDLRecord.portals = new ArrayList<IDLPortal>(tList.size);
                for (int i = 0; i < tList.size; ++i) {
                    IDLPortal iDLPortal = new IDLPortal();
                    iDLPortal.read((TProtocol)tTupleProtocol);
                    iDLRecord.portals.add(iDLPortal);
                }
                iDLRecord.setPortalsIsSet(true);
            }
        }
    }

    private static class IDLRecordStandardScheme
    extends StandardScheme<IDLRecord> {
        private IDLRecordStandardScheme() {
        }

        public void read(TProtocol tProtocol, IDLRecord iDLRecord) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 12) {
                            iDLRecord.record = new SimpleRecord();
                            iDLRecord.record.read(tProtocol);
                            iDLRecord.setRecordIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 15) {
                            TList tList = tProtocol.readListBegin();
                            iDLRecord.portals = new ArrayList<IDLPortal>(tList.size);
                            for (int i = 0; i < tList.size; ++i) {
                                IDLPortal iDLPortal = new IDLPortal();
                                iDLPortal.read(tProtocol);
                                iDLRecord.portals.add(iDLPortal);
                            }
                            tProtocol.readListEnd();
                            iDLRecord.setPortalsIsSet(true);
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
            iDLRecord.validate();
        }

        public void write(TProtocol tProtocol, IDLRecord iDLRecord) throws TException {
            iDLRecord.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (iDLRecord.record != null) {
                tProtocol.writeFieldBegin(RECORD_FIELD_DESC);
                iDLRecord.record.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            if (iDLRecord.portals != null) {
                tProtocol.writeFieldBegin(PORTALS_FIELD_DESC);
                tProtocol.writeListBegin(new TList(12, iDLRecord.portals.size()));
                for (IDLPortal iDLPortal : iDLRecord.portals) {
                    iDLPortal.write(tProtocol);
                }
                tProtocol.writeListEnd();
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

