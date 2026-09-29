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
 *  org.apache.thrift.meta_data.MapMetaData
 *  org.apache.thrift.meta_data.StructMetaData
 *  org.apache.thrift.protocol.TCompactProtocol
 *  org.apache.thrift.protocol.TField
 *  org.apache.thrift.protocol.TMap
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
package com.filemaker.jwpc.iwp.thrift.layout;

import com.filemaker.jwpc.iwp.thrift.layout.NonFieldObjectsData;
import com.filemaker.jwpc.iwp.thrift.layout.SingleRowPartsData;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import org.apache.thrift.TBase;
import org.apache.thrift.TBaseHelper;
import org.apache.thrift.TException;
import org.apache.thrift.TFieldIdEnum;
import org.apache.thrift.annotation.Nullable;
import org.apache.thrift.meta_data.FieldMetaData;
import org.apache.thrift.meta_data.FieldValueMetaData;
import org.apache.thrift.meta_data.MapMetaData;
import org.apache.thrift.meta_data.StructMetaData;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TMap;
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

public class LayoutData
implements TBase<LayoutData, _Fields>,
Serializable,
Cloneable,
Comparable<LayoutData> {
    private static final TStruct STRUCT_DESC = new TStruct("LayoutData");
    private static final TField ALL_PARTS_NON_FIELD_OBJECTS_DATA_FIELD_DESC = new TField("allPartsNonFieldObjectsData", 13, 1);
    private static final TField ROWS_DATA_FIELD_DESC = new TField("rowsData", 13, 2);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new LayoutDataStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new LayoutDataTupleSchemeFactory();
    @Nullable
    private Map<Integer, NonFieldObjectsData> allPartsNonFieldObjectsData;
    @Nullable
    private Map<Integer, SingleRowPartsData> rowsData;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public LayoutData() {
    }

    public LayoutData(Map<Integer, NonFieldObjectsData> map, Map<Integer, SingleRowPartsData> map2) {
        this();
        this.allPartsNonFieldObjectsData = map;
        this.rowsData = map2;
    }

    public LayoutData(LayoutData layoutData) {
        Comparable<NonFieldObjectsData> comparable;
        Integer n;
        Comparable<NonFieldObjectsData> comparable2;
        Integer n2;
        HashMap<Integer, NonFieldObjectsData> hashMap;
        if (layoutData.isSetAllPartsNonFieldObjectsData()) {
            hashMap = new HashMap<Integer, NonFieldObjectsData>(layoutData.allPartsNonFieldObjectsData.size());
            for (Map.Entry<Integer, Comparable<NonFieldObjectsData>> entry : layoutData.allPartsNonFieldObjectsData.entrySet()) {
                n2 = entry.getKey();
                comparable2 = (NonFieldObjectsData)entry.getValue();
                n = n2;
                comparable = new NonFieldObjectsData((NonFieldObjectsData)comparable2);
                hashMap.put(n, (NonFieldObjectsData)comparable);
            }
            this.allPartsNonFieldObjectsData = hashMap;
        }
        if (layoutData.isSetRowsData()) {
            hashMap = new HashMap(layoutData.rowsData.size());
            for (Map.Entry<Integer, Comparable<NonFieldObjectsData>> entry : layoutData.rowsData.entrySet()) {
                n2 = entry.getKey();
                comparable2 = (SingleRowPartsData)entry.getValue();
                n = n2;
                comparable = new SingleRowPartsData((SingleRowPartsData)comparable2);
                hashMap.put(n, (NonFieldObjectsData)comparable);
            }
            this.rowsData = hashMap;
        }
    }

    public LayoutData deepCopy() {
        return new LayoutData(this);
    }

    public void clear() {
        this.allPartsNonFieldObjectsData = null;
        this.rowsData = null;
    }

    public int getAllPartsNonFieldObjectsDataSize() {
        return this.allPartsNonFieldObjectsData == null ? 0 : this.allPartsNonFieldObjectsData.size();
    }

    public void putToAllPartsNonFieldObjectsData(int n, NonFieldObjectsData nonFieldObjectsData) {
        if (this.allPartsNonFieldObjectsData == null) {
            this.allPartsNonFieldObjectsData = new HashMap<Integer, NonFieldObjectsData>();
        }
        this.allPartsNonFieldObjectsData.put(n, nonFieldObjectsData);
    }

    @Nullable
    public Map<Integer, NonFieldObjectsData> getAllPartsNonFieldObjectsData() {
        return this.allPartsNonFieldObjectsData;
    }

    public void setAllPartsNonFieldObjectsData(@Nullable Map<Integer, NonFieldObjectsData> map) {
        this.allPartsNonFieldObjectsData = map;
    }

    public void unsetAllPartsNonFieldObjectsData() {
        this.allPartsNonFieldObjectsData = null;
    }

    public boolean isSetAllPartsNonFieldObjectsData() {
        return this.allPartsNonFieldObjectsData != null;
    }

    public void setAllPartsNonFieldObjectsDataIsSet(boolean bl) {
        if (!bl) {
            this.allPartsNonFieldObjectsData = null;
        }
    }

    public int getRowsDataSize() {
        return this.rowsData == null ? 0 : this.rowsData.size();
    }

    public void putToRowsData(int n, SingleRowPartsData singleRowPartsData) {
        if (this.rowsData == null) {
            this.rowsData = new HashMap<Integer, SingleRowPartsData>();
        }
        this.rowsData.put(n, singleRowPartsData);
    }

    @Nullable
    public Map<Integer, SingleRowPartsData> getRowsData() {
        return this.rowsData;
    }

    public void setRowsData(@Nullable Map<Integer, SingleRowPartsData> map) {
        this.rowsData = map;
    }

    public void unsetRowsData() {
        this.rowsData = null;
    }

    public boolean isSetRowsData() {
        return this.rowsData != null;
    }

    public void setRowsDataIsSet(boolean bl) {
        if (!bl) {
            this.rowsData = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetAllPartsNonFieldObjectsData();
                    break;
                }
                this.setAllPartsNonFieldObjectsData((Map)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetRowsData();
                    break;
                }
                this.setRowsData((Map)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getAllPartsNonFieldObjectsData();
            }
            case 1: {
                return this.getRowsData();
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
                return this.isSetAllPartsNonFieldObjectsData();
            }
            case 1: {
                return this.isSetRowsData();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof LayoutData) {
            return this.equals((LayoutData)object);
        }
        return false;
    }

    public boolean equals(LayoutData layoutData) {
        if (layoutData == null) {
            return false;
        }
        if (this == layoutData) {
            return true;
        }
        boolean bl = this.isSetAllPartsNonFieldObjectsData();
        boolean bl2 = layoutData.isSetAllPartsNonFieldObjectsData();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.allPartsNonFieldObjectsData.equals(layoutData.allPartsNonFieldObjectsData)) {
                return false;
            }
        }
        boolean bl3 = this.isSetRowsData();
        boolean bl4 = layoutData.isSetRowsData();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.rowsData.equals(layoutData.rowsData)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetAllPartsNonFieldObjectsData() ? 131071 : 524287);
        if (this.isSetAllPartsNonFieldObjectsData()) {
            n = n * 8191 + this.allPartsNonFieldObjectsData.hashCode();
        }
        n = n * 8191 + (this.isSetRowsData() ? 131071 : 524287);
        if (this.isSetRowsData()) {
            n = n * 8191 + this.rowsData.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(LayoutData layoutData) {
        if (!this.getClass().equals(layoutData.getClass())) {
            return this.getClass().getName().compareTo(layoutData.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetAllPartsNonFieldObjectsData(), layoutData.isSetAllPartsNonFieldObjectsData());
        if (n != 0) {
            return n;
        }
        if (this.isSetAllPartsNonFieldObjectsData() && (n = TBaseHelper.compareTo(this.allPartsNonFieldObjectsData, layoutData.allPartsNonFieldObjectsData)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetRowsData(), layoutData.isSetRowsData());
        if (n != 0) {
            return n;
        }
        if (this.isSetRowsData() && (n = TBaseHelper.compareTo(this.rowsData, layoutData.rowsData)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        LayoutData.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        LayoutData.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("LayoutData(");
        boolean bl = true;
        stringBuilder.append("allPartsNonFieldObjectsData:");
        if (this.allPartsNonFieldObjectsData == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.allPartsNonFieldObjectsData);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("rowsData:");
        if (this.rowsData == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.rowsData);
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
        enumMap.put(_Fields.ALL_PARTS_NON_FIELD_OBJECTS_DATA, new FieldMetaData("allPartsNonFieldObjectsData", 3, (FieldValueMetaData)new MapMetaData(13, new FieldValueMetaData(8), (FieldValueMetaData)new StructMetaData(12, NonFieldObjectsData.class))));
        enumMap.put(_Fields.ROWS_DATA, new FieldMetaData("rowsData", 3, (FieldValueMetaData)new MapMetaData(13, new FieldValueMetaData(8), (FieldValueMetaData)new StructMetaData(12, SingleRowPartsData.class))));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(LayoutData.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        ALL_PARTS_NON_FIELD_OBJECTS_DATA(1, "allPartsNonFieldObjectsData"),
        ROWS_DATA(2, "rowsData");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return ALL_PARTS_NON_FIELD_OBJECTS_DATA;
                }
                case 2: {
                    return ROWS_DATA;
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

    private static class LayoutDataStandardSchemeFactory
    implements SchemeFactory {
        private LayoutDataStandardSchemeFactory() {
        }

        public LayoutDataStandardScheme getScheme() {
            return new LayoutDataStandardScheme();
        }
    }

    private static class LayoutDataTupleSchemeFactory
    implements SchemeFactory {
        private LayoutDataTupleSchemeFactory() {
        }

        public LayoutDataTupleScheme getScheme() {
            return new LayoutDataTupleScheme();
        }
    }

    private static class LayoutDataTupleScheme
    extends TupleScheme<LayoutData> {
        private LayoutDataTupleScheme() {
        }

        public void write(TProtocol tProtocol, LayoutData layoutData) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (layoutData.isSetAllPartsNonFieldObjectsData()) {
                bitSet.set(0);
            }
            if (layoutData.isSetRowsData()) {
                bitSet.set(1);
            }
            tTupleProtocol.writeBitSet(bitSet, 2);
            if (layoutData.isSetAllPartsNonFieldObjectsData()) {
                tTupleProtocol.writeI32(layoutData.allPartsNonFieldObjectsData.size());
                for (Map.Entry<Integer, Comparable<NonFieldObjectsData>> entry : layoutData.allPartsNonFieldObjectsData.entrySet()) {
                    tTupleProtocol.writeI32(entry.getKey().intValue());
                    ((NonFieldObjectsData)entry.getValue()).write((TProtocol)tTupleProtocol);
                }
            }
            if (layoutData.isSetRowsData()) {
                tTupleProtocol.writeI32(layoutData.rowsData.size());
                for (Map.Entry<Integer, Comparable<NonFieldObjectsData>> entry : layoutData.rowsData.entrySet()) {
                    tTupleProtocol.writeI32(entry.getKey().intValue());
                    ((SingleRowPartsData)entry.getValue()).write((TProtocol)tTupleProtocol);
                }
            }
        }

        public void read(TProtocol tProtocol, LayoutData layoutData) throws TException {
            Comparable<NonFieldObjectsData> comparable;
            int n;
            int n2;
            TMap tMap;
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(2);
            if (bitSet.get(0)) {
                tMap = tTupleProtocol.readMapBegin((byte)8, (byte)12);
                layoutData.allPartsNonFieldObjectsData = new HashMap<Integer, NonFieldObjectsData>(2 * tMap.size);
                for (n2 = 0; n2 < tMap.size; ++n2) {
                    n = tTupleProtocol.readI32();
                    comparable = new NonFieldObjectsData();
                    ((NonFieldObjectsData)comparable).read((TProtocol)tTupleProtocol);
                    layoutData.allPartsNonFieldObjectsData.put(n, (NonFieldObjectsData)comparable);
                }
                layoutData.setAllPartsNonFieldObjectsDataIsSet(true);
            }
            if (bitSet.get(1)) {
                tMap = tTupleProtocol.readMapBegin((byte)8, (byte)12);
                layoutData.rowsData = new HashMap<Integer, SingleRowPartsData>(2 * tMap.size);
                for (n2 = 0; n2 < tMap.size; ++n2) {
                    n = tTupleProtocol.readI32();
                    comparable = new SingleRowPartsData();
                    ((SingleRowPartsData)comparable).read((TProtocol)tTupleProtocol);
                    layoutData.rowsData.put(n, (SingleRowPartsData)comparable);
                }
                layoutData.setRowsDataIsSet(true);
            }
        }
    }

    private static class LayoutDataStandardScheme
    extends StandardScheme<LayoutData> {
        private LayoutDataStandardScheme() {
        }

        public void read(TProtocol tProtocol, LayoutData layoutData) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        Comparable<NonFieldObjectsData> comparable;
                        int n;
                        int n2;
                        TMap tMap;
                        if (tField.type == 13) {
                            tMap = tProtocol.readMapBegin();
                            layoutData.allPartsNonFieldObjectsData = new HashMap<Integer, NonFieldObjectsData>(2 * tMap.size);
                            for (n2 = 0; n2 < tMap.size; ++n2) {
                                n = tProtocol.readI32();
                                comparable = new NonFieldObjectsData();
                                ((NonFieldObjectsData)comparable).read(tProtocol);
                                layoutData.allPartsNonFieldObjectsData.put(n, (NonFieldObjectsData)comparable);
                            }
                            tProtocol.readMapEnd();
                            layoutData.setAllPartsNonFieldObjectsDataIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        Comparable<NonFieldObjectsData> comparable;
                        int n;
                        int n2;
                        TMap tMap;
                        if (tField.type == 13) {
                            tMap = tProtocol.readMapBegin();
                            layoutData.rowsData = new HashMap<Integer, SingleRowPartsData>(2 * tMap.size);
                            for (n2 = 0; n2 < tMap.size; ++n2) {
                                n = tProtocol.readI32();
                                comparable = new SingleRowPartsData();
                                ((SingleRowPartsData)comparable).read(tProtocol);
                                layoutData.rowsData.put(n, (SingleRowPartsData)comparable);
                            }
                            tProtocol.readMapEnd();
                            layoutData.setRowsDataIsSet(true);
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
            layoutData.validate();
        }

        public void write(TProtocol tProtocol, LayoutData layoutData) throws TException {
            layoutData.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (layoutData.allPartsNonFieldObjectsData != null) {
                tProtocol.writeFieldBegin(ALL_PARTS_NON_FIELD_OBJECTS_DATA_FIELD_DESC);
                tProtocol.writeMapBegin(new TMap(8, 12, layoutData.allPartsNonFieldObjectsData.size()));
                for (Map.Entry<Integer, Comparable<NonFieldObjectsData>> entry : layoutData.allPartsNonFieldObjectsData.entrySet()) {
                    tProtocol.writeI32(entry.getKey().intValue());
                    ((NonFieldObjectsData)entry.getValue()).write(tProtocol);
                }
                tProtocol.writeMapEnd();
                tProtocol.writeFieldEnd();
            }
            if (layoutData.rowsData != null) {
                tProtocol.writeFieldBegin(ROWS_DATA_FIELD_DESC);
                tProtocol.writeMapBegin(new TMap(8, 12, layoutData.rowsData.size()));
                for (Map.Entry<Integer, Comparable<NonFieldObjectsData>> entry : layoutData.rowsData.entrySet()) {
                    tProtocol.writeI32(entry.getKey().intValue());
                    ((SingleRowPartsData)entry.getValue()).write(tProtocol);
                }
                tProtocol.writeMapEnd();
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

