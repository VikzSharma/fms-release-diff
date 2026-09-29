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
 *  org.apache.thrift.meta_data.EnumMetaData
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

import com.filemaker.jwpc.iwp.thrift.common.LayoutObjectType;
import com.filemaker.jwpc.iwp.thrift.layout.FieldObjectData;
import com.filemaker.jwpc.iwp.thrift.layout.NonFieldObjectData;
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
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TBase;
import org.apache.thrift.TBaseHelper;
import org.apache.thrift.TException;
import org.apache.thrift.TFieldIdEnum;
import org.apache.thrift.annotation.Nullable;
import org.apache.thrift.meta_data.EnumMetaData;
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

public class SinglePartObjectsData
implements TBase<SinglePartObjectsData, _Fields>,
Serializable,
Cloneable,
Comparable<SinglePartObjectsData> {
    private static final TStruct STRUCT_DESC = new TStruct("SinglePartObjectsData");
    private static final TField PART_INDEX_FIELD_DESC = new TField("partIndex", 8, 1);
    private static final TField ROW_INDEX_FIELD_DESC = new TField("rowIndex", 8, 2);
    private static final TField ROW_ID_FIELD_DESC = new TField("rowId", 8, 3);
    private static final TField PART_TYPE_FIELD_DESC = new TField("partType", 8, 4);
    private static final TField FIELD_OBJECTS_DATA_FIELD_DESC = new TField("fieldObjectsData", 13, 5);
    private static final TField NON_FIELD_OBJECTS_DATA_FIELD_DESC = new TField("nonFieldObjectsData", 13, 6);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new SinglePartObjectsDataStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new SinglePartObjectsDataTupleSchemeFactory();
    private int partIndex;
    private int rowIndex;
    private int rowId;
    @Nullable
    private LayoutObjectType partType;
    @Nullable
    private Map<Integer, FieldObjectData> fieldObjectsData;
    @Nullable
    private Map<Integer, NonFieldObjectData> nonFieldObjectsData;
    private static final int __PARTINDEX_ISSET_ID = 0;
    private static final int __ROWINDEX_ISSET_ID = 1;
    private static final int __ROWID_ISSET_ID = 2;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public SinglePartObjectsData() {
        this.partIndex = 0;
        this.rowIndex = 0;
        this.rowId = 0;
    }

    public SinglePartObjectsData(int n, int n2, int n3, LayoutObjectType layoutObjectType, Map<Integer, FieldObjectData> map, Map<Integer, NonFieldObjectData> map2) {
        this();
        this.partIndex = n;
        this.setPartIndexIsSet(true);
        this.rowIndex = n2;
        this.setRowIndexIsSet(true);
        this.rowId = n3;
        this.setRowIdIsSet(true);
        this.partType = layoutObjectType;
        this.fieldObjectsData = map;
        this.nonFieldObjectsData = map2;
    }

    public SinglePartObjectsData(SinglePartObjectsData singlePartObjectsData) {
        Comparable<FieldObjectData> comparable;
        Integer n;
        Comparable<FieldObjectData> comparable2;
        Integer n2;
        HashMap<Integer, FieldObjectData> hashMap;
        this.__isset_bitfield = singlePartObjectsData.__isset_bitfield;
        this.partIndex = singlePartObjectsData.partIndex;
        this.rowIndex = singlePartObjectsData.rowIndex;
        this.rowId = singlePartObjectsData.rowId;
        if (singlePartObjectsData.isSetPartType()) {
            this.partType = singlePartObjectsData.partType;
        }
        if (singlePartObjectsData.isSetFieldObjectsData()) {
            hashMap = new HashMap<Integer, FieldObjectData>(singlePartObjectsData.fieldObjectsData.size());
            for (Map.Entry<Integer, Comparable<FieldObjectData>> entry : singlePartObjectsData.fieldObjectsData.entrySet()) {
                n2 = entry.getKey();
                comparable2 = (FieldObjectData)entry.getValue();
                n = n2;
                comparable = new FieldObjectData((FieldObjectData)comparable2);
                hashMap.put(n, (FieldObjectData)comparable);
            }
            this.fieldObjectsData = hashMap;
        }
        if (singlePartObjectsData.isSetNonFieldObjectsData()) {
            hashMap = new HashMap(singlePartObjectsData.nonFieldObjectsData.size());
            for (Map.Entry<Integer, Comparable<FieldObjectData>> entry : singlePartObjectsData.nonFieldObjectsData.entrySet()) {
                n2 = entry.getKey();
                comparable2 = (NonFieldObjectData)entry.getValue();
                n = n2;
                comparable = new NonFieldObjectData((NonFieldObjectData)comparable2);
                hashMap.put(n, (FieldObjectData)comparable);
            }
            this.nonFieldObjectsData = hashMap;
        }
    }

    public SinglePartObjectsData deepCopy() {
        return new SinglePartObjectsData(this);
    }

    public void clear() {
        this.partIndex = 0;
        this.rowIndex = 0;
        this.rowId = 0;
        this.partType = null;
        this.fieldObjectsData = null;
        this.nonFieldObjectsData = null;
    }

    public int getPartIndex() {
        return this.partIndex;
    }

    public void setPartIndex(int n) {
        this.partIndex = n;
        this.setPartIndexIsSet(true);
    }

    public void unsetPartIndex() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetPartIndex() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setPartIndexIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public int getRowIndex() {
        return this.rowIndex;
    }

    public void setRowIndex(int n) {
        this.rowIndex = n;
        this.setRowIndexIsSet(true);
    }

    public void unsetRowIndex() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)1);
    }

    public boolean isSetRowIndex() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)1);
    }

    public void setRowIndexIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)1, (boolean)bl);
    }

    public int getRowId() {
        return this.rowId;
    }

    public void setRowId(int n) {
        this.rowId = n;
        this.setRowIdIsSet(true);
    }

    public void unsetRowId() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)2);
    }

    public boolean isSetRowId() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)2);
    }

    public void setRowIdIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)2, (boolean)bl);
    }

    @Nullable
    public LayoutObjectType getPartType() {
        return this.partType;
    }

    public void setPartType(@Nullable LayoutObjectType layoutObjectType) {
        this.partType = layoutObjectType;
    }

    public void unsetPartType() {
        this.partType = null;
    }

    public boolean isSetPartType() {
        return this.partType != null;
    }

    public void setPartTypeIsSet(boolean bl) {
        if (!bl) {
            this.partType = null;
        }
    }

    public int getFieldObjectsDataSize() {
        return this.fieldObjectsData == null ? 0 : this.fieldObjectsData.size();
    }

    public void putToFieldObjectsData(int n, FieldObjectData fieldObjectData) {
        if (this.fieldObjectsData == null) {
            this.fieldObjectsData = new HashMap<Integer, FieldObjectData>();
        }
        this.fieldObjectsData.put(n, fieldObjectData);
    }

    @Nullable
    public Map<Integer, FieldObjectData> getFieldObjectsData() {
        return this.fieldObjectsData;
    }

    public void setFieldObjectsData(@Nullable Map<Integer, FieldObjectData> map) {
        this.fieldObjectsData = map;
    }

    public void unsetFieldObjectsData() {
        this.fieldObjectsData = null;
    }

    public boolean isSetFieldObjectsData() {
        return this.fieldObjectsData != null;
    }

    public void setFieldObjectsDataIsSet(boolean bl) {
        if (!bl) {
            this.fieldObjectsData = null;
        }
    }

    public int getNonFieldObjectsDataSize() {
        return this.nonFieldObjectsData == null ? 0 : this.nonFieldObjectsData.size();
    }

    public void putToNonFieldObjectsData(int n, NonFieldObjectData nonFieldObjectData) {
        if (this.nonFieldObjectsData == null) {
            this.nonFieldObjectsData = new HashMap<Integer, NonFieldObjectData>();
        }
        this.nonFieldObjectsData.put(n, nonFieldObjectData);
    }

    @Nullable
    public Map<Integer, NonFieldObjectData> getNonFieldObjectsData() {
        return this.nonFieldObjectsData;
    }

    public void setNonFieldObjectsData(@Nullable Map<Integer, NonFieldObjectData> map) {
        this.nonFieldObjectsData = map;
    }

    public void unsetNonFieldObjectsData() {
        this.nonFieldObjectsData = null;
    }

    public boolean isSetNonFieldObjectsData() {
        return this.nonFieldObjectsData != null;
    }

    public void setNonFieldObjectsDataIsSet(boolean bl) {
        if (!bl) {
            this.nonFieldObjectsData = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetPartIndex();
                    break;
                }
                this.setPartIndex((Integer)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetRowIndex();
                    break;
                }
                this.setRowIndex((Integer)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetRowId();
                    break;
                }
                this.setRowId((Integer)object);
                break;
            }
            case 3: {
                if (object == null) {
                    this.unsetPartType();
                    break;
                }
                this.setPartType((LayoutObjectType)((Object)object));
                break;
            }
            case 4: {
                if (object == null) {
                    this.unsetFieldObjectsData();
                    break;
                }
                this.setFieldObjectsData((Map)object);
                break;
            }
            case 5: {
                if (object == null) {
                    this.unsetNonFieldObjectsData();
                    break;
                }
                this.setNonFieldObjectsData((Map)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getPartIndex();
            }
            case 1: {
                return this.getRowIndex();
            }
            case 2: {
                return this.getRowId();
            }
            case 3: {
                return this.getPartType();
            }
            case 4: {
                return this.getFieldObjectsData();
            }
            case 5: {
                return this.getNonFieldObjectsData();
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
                return this.isSetPartIndex();
            }
            case 1: {
                return this.isSetRowIndex();
            }
            case 2: {
                return this.isSetRowId();
            }
            case 3: {
                return this.isSetPartType();
            }
            case 4: {
                return this.isSetFieldObjectsData();
            }
            case 5: {
                return this.isSetNonFieldObjectsData();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof SinglePartObjectsData) {
            return this.equals((SinglePartObjectsData)object);
        }
        return false;
    }

    public boolean equals(SinglePartObjectsData singlePartObjectsData) {
        if (singlePartObjectsData == null) {
            return false;
        }
        if (this == singlePartObjectsData) {
            return true;
        }
        boolean bl = true;
        boolean bl2 = true;
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (this.partIndex != singlePartObjectsData.partIndex) {
                return false;
            }
        }
        boolean bl3 = true;
        boolean bl4 = true;
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (this.rowIndex != singlePartObjectsData.rowIndex) {
                return false;
            }
        }
        boolean bl5 = true;
        boolean bl6 = true;
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (this.rowId != singlePartObjectsData.rowId) {
                return false;
            }
        }
        boolean bl7 = this.isSetPartType();
        boolean bl8 = singlePartObjectsData.isSetPartType();
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (!this.partType.equals((Object)singlePartObjectsData.partType)) {
                return false;
            }
        }
        boolean bl9 = this.isSetFieldObjectsData();
        boolean bl10 = singlePartObjectsData.isSetFieldObjectsData();
        if (bl9 || bl10) {
            if (!bl9 || !bl10) {
                return false;
            }
            if (!this.fieldObjectsData.equals(singlePartObjectsData.fieldObjectsData)) {
                return false;
            }
        }
        boolean bl11 = this.isSetNonFieldObjectsData();
        boolean bl12 = singlePartObjectsData.isSetNonFieldObjectsData();
        if (bl11 || bl12) {
            if (!bl11 || !bl12) {
                return false;
            }
            if (!this.nonFieldObjectsData.equals(singlePartObjectsData.nonFieldObjectsData)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + this.partIndex;
        n = n * 8191 + this.rowIndex;
        n = n * 8191 + this.rowId;
        n = n * 8191 + (this.isSetPartType() ? 131071 : 524287);
        if (this.isSetPartType()) {
            n = n * 8191 + this.partType.getValue();
        }
        n = n * 8191 + (this.isSetFieldObjectsData() ? 131071 : 524287);
        if (this.isSetFieldObjectsData()) {
            n = n * 8191 + this.fieldObjectsData.hashCode();
        }
        n = n * 8191 + (this.isSetNonFieldObjectsData() ? 131071 : 524287);
        if (this.isSetNonFieldObjectsData()) {
            n = n * 8191 + this.nonFieldObjectsData.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(SinglePartObjectsData singlePartObjectsData) {
        if (!this.getClass().equals(singlePartObjectsData.getClass())) {
            return this.getClass().getName().compareTo(singlePartObjectsData.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetPartIndex(), singlePartObjectsData.isSetPartIndex());
        if (n != 0) {
            return n;
        }
        if (this.isSetPartIndex() && (n = TBaseHelper.compareTo((int)this.partIndex, (int)singlePartObjectsData.partIndex)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetRowIndex(), singlePartObjectsData.isSetRowIndex());
        if (n != 0) {
            return n;
        }
        if (this.isSetRowIndex() && (n = TBaseHelper.compareTo((int)this.rowIndex, (int)singlePartObjectsData.rowIndex)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetRowId(), singlePartObjectsData.isSetRowId());
        if (n != 0) {
            return n;
        }
        if (this.isSetRowId() && (n = TBaseHelper.compareTo((int)this.rowId, (int)singlePartObjectsData.rowId)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetPartType(), singlePartObjectsData.isSetPartType());
        if (n != 0) {
            return n;
        }
        if (this.isSetPartType() && (n = TBaseHelper.compareTo((Comparable)((Object)this.partType), (Comparable)((Object)singlePartObjectsData.partType))) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetFieldObjectsData(), singlePartObjectsData.isSetFieldObjectsData());
        if (n != 0) {
            return n;
        }
        if (this.isSetFieldObjectsData() && (n = TBaseHelper.compareTo(this.fieldObjectsData, singlePartObjectsData.fieldObjectsData)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetNonFieldObjectsData(), singlePartObjectsData.isSetNonFieldObjectsData());
        if (n != 0) {
            return n;
        }
        if (this.isSetNonFieldObjectsData() && (n = TBaseHelper.compareTo(this.nonFieldObjectsData, singlePartObjectsData.nonFieldObjectsData)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        SinglePartObjectsData.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        SinglePartObjectsData.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("SinglePartObjectsData(");
        boolean bl = true;
        stringBuilder.append("partIndex:");
        stringBuilder.append(this.partIndex);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("rowIndex:");
        stringBuilder.append(this.rowIndex);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("rowId:");
        stringBuilder.append(this.rowId);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("partType:");
        if (this.partType == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append((Object)this.partType);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("fieldObjectsData:");
        if (this.fieldObjectsData == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.fieldObjectsData);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("nonFieldObjectsData:");
        if (this.nonFieldObjectsData == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.nonFieldObjectsData);
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
        enumMap.put(_Fields.PART_INDEX, new FieldMetaData("partIndex", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.ROW_INDEX, new FieldMetaData("rowIndex", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.ROW_ID, new FieldMetaData("rowId", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.PART_TYPE, new FieldMetaData("partType", 3, (FieldValueMetaData)new EnumMetaData(-1, LayoutObjectType.class)));
        enumMap.put(_Fields.FIELD_OBJECTS_DATA, new FieldMetaData("fieldObjectsData", 3, (FieldValueMetaData)new MapMetaData(13, new FieldValueMetaData(8), (FieldValueMetaData)new StructMetaData(12, FieldObjectData.class))));
        enumMap.put(_Fields.NON_FIELD_OBJECTS_DATA, new FieldMetaData("nonFieldObjectsData", 3, (FieldValueMetaData)new MapMetaData(13, new FieldValueMetaData(8), (FieldValueMetaData)new StructMetaData(12, NonFieldObjectData.class))));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(SinglePartObjectsData.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        PART_INDEX(1, "partIndex"),
        ROW_INDEX(2, "rowIndex"),
        ROW_ID(3, "rowId"),
        PART_TYPE(4, "partType"),
        FIELD_OBJECTS_DATA(5, "fieldObjectsData"),
        NON_FIELD_OBJECTS_DATA(6, "nonFieldObjectsData");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return PART_INDEX;
                }
                case 2: {
                    return ROW_INDEX;
                }
                case 3: {
                    return ROW_ID;
                }
                case 4: {
                    return PART_TYPE;
                }
                case 5: {
                    return FIELD_OBJECTS_DATA;
                }
                case 6: {
                    return NON_FIELD_OBJECTS_DATA;
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

    private static class SinglePartObjectsDataStandardSchemeFactory
    implements SchemeFactory {
        private SinglePartObjectsDataStandardSchemeFactory() {
        }

        public SinglePartObjectsDataStandardScheme getScheme() {
            return new SinglePartObjectsDataStandardScheme();
        }
    }

    private static class SinglePartObjectsDataTupleSchemeFactory
    implements SchemeFactory {
        private SinglePartObjectsDataTupleSchemeFactory() {
        }

        public SinglePartObjectsDataTupleScheme getScheme() {
            return new SinglePartObjectsDataTupleScheme();
        }
    }

    private static class SinglePartObjectsDataTupleScheme
    extends TupleScheme<SinglePartObjectsData> {
        private SinglePartObjectsDataTupleScheme() {
        }

        public void write(TProtocol tProtocol, SinglePartObjectsData singlePartObjectsData) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (singlePartObjectsData.isSetPartIndex()) {
                bitSet.set(0);
            }
            if (singlePartObjectsData.isSetRowIndex()) {
                bitSet.set(1);
            }
            if (singlePartObjectsData.isSetRowId()) {
                bitSet.set(2);
            }
            if (singlePartObjectsData.isSetPartType()) {
                bitSet.set(3);
            }
            if (singlePartObjectsData.isSetFieldObjectsData()) {
                bitSet.set(4);
            }
            if (singlePartObjectsData.isSetNonFieldObjectsData()) {
                bitSet.set(5);
            }
            tTupleProtocol.writeBitSet(bitSet, 6);
            if (singlePartObjectsData.isSetPartIndex()) {
                tTupleProtocol.writeI32(singlePartObjectsData.partIndex);
            }
            if (singlePartObjectsData.isSetRowIndex()) {
                tTupleProtocol.writeI32(singlePartObjectsData.rowIndex);
            }
            if (singlePartObjectsData.isSetRowId()) {
                tTupleProtocol.writeI32(singlePartObjectsData.rowId);
            }
            if (singlePartObjectsData.isSetPartType()) {
                tTupleProtocol.writeI32(singlePartObjectsData.partType.getValue());
            }
            if (singlePartObjectsData.isSetFieldObjectsData()) {
                tTupleProtocol.writeI32(singlePartObjectsData.fieldObjectsData.size());
                for (Map.Entry<Integer, Comparable<FieldObjectData>> entry : singlePartObjectsData.fieldObjectsData.entrySet()) {
                    tTupleProtocol.writeI32(entry.getKey().intValue());
                    ((FieldObjectData)entry.getValue()).write((TProtocol)tTupleProtocol);
                }
            }
            if (singlePartObjectsData.isSetNonFieldObjectsData()) {
                tTupleProtocol.writeI32(singlePartObjectsData.nonFieldObjectsData.size());
                for (Map.Entry<Integer, Comparable<FieldObjectData>> entry : singlePartObjectsData.nonFieldObjectsData.entrySet()) {
                    tTupleProtocol.writeI32(entry.getKey().intValue());
                    ((NonFieldObjectData)entry.getValue()).write((TProtocol)tTupleProtocol);
                }
            }
        }

        public void read(TProtocol tProtocol, SinglePartObjectsData singlePartObjectsData) throws TException {
            Comparable<FieldObjectData> comparable;
            int n;
            int n2;
            TMap tMap;
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(6);
            if (bitSet.get(0)) {
                singlePartObjectsData.partIndex = tTupleProtocol.readI32();
                singlePartObjectsData.setPartIndexIsSet(true);
            }
            if (bitSet.get(1)) {
                singlePartObjectsData.rowIndex = tTupleProtocol.readI32();
                singlePartObjectsData.setRowIndexIsSet(true);
            }
            if (bitSet.get(2)) {
                singlePartObjectsData.rowId = tTupleProtocol.readI32();
                singlePartObjectsData.setRowIdIsSet(true);
            }
            if (bitSet.get(3)) {
                singlePartObjectsData.partType = LayoutObjectType.findByValue(tTupleProtocol.readI32());
                singlePartObjectsData.setPartTypeIsSet(true);
            }
            if (bitSet.get(4)) {
                tMap = tTupleProtocol.readMapBegin((byte)8, (byte)12);
                singlePartObjectsData.fieldObjectsData = new HashMap<Integer, FieldObjectData>(2 * tMap.size);
                for (n2 = 0; n2 < tMap.size; ++n2) {
                    n = tTupleProtocol.readI32();
                    comparable = new FieldObjectData();
                    ((FieldObjectData)comparable).read((TProtocol)tTupleProtocol);
                    singlePartObjectsData.fieldObjectsData.put(n, (FieldObjectData)comparable);
                }
                singlePartObjectsData.setFieldObjectsDataIsSet(true);
            }
            if (bitSet.get(5)) {
                tMap = tTupleProtocol.readMapBegin((byte)8, (byte)12);
                singlePartObjectsData.nonFieldObjectsData = new HashMap<Integer, NonFieldObjectData>(2 * tMap.size);
                for (n2 = 0; n2 < tMap.size; ++n2) {
                    n = tTupleProtocol.readI32();
                    comparable = new NonFieldObjectData();
                    ((NonFieldObjectData)comparable).read((TProtocol)tTupleProtocol);
                    singlePartObjectsData.nonFieldObjectsData.put(n, (NonFieldObjectData)comparable);
                }
                singlePartObjectsData.setNonFieldObjectsDataIsSet(true);
            }
        }
    }

    private static class SinglePartObjectsDataStandardScheme
    extends StandardScheme<SinglePartObjectsData> {
        private SinglePartObjectsDataStandardScheme() {
        }

        public void read(TProtocol tProtocol, SinglePartObjectsData singlePartObjectsData) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 8) {
                            singlePartObjectsData.partIndex = tProtocol.readI32();
                            singlePartObjectsData.setPartIndexIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 8) {
                            singlePartObjectsData.rowIndex = tProtocol.readI32();
                            singlePartObjectsData.setRowIndexIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 8) {
                            singlePartObjectsData.rowId = tProtocol.readI32();
                            singlePartObjectsData.setRowIdIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 8) {
                            singlePartObjectsData.partType = LayoutObjectType.findByValue(tProtocol.readI32());
                            singlePartObjectsData.setPartTypeIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 5: {
                        Comparable<FieldObjectData> comparable;
                        int n;
                        int n2;
                        TMap tMap;
                        if (tField.type == 13) {
                            tMap = tProtocol.readMapBegin();
                            singlePartObjectsData.fieldObjectsData = new HashMap<Integer, FieldObjectData>(2 * tMap.size);
                            for (n2 = 0; n2 < tMap.size; ++n2) {
                                n = tProtocol.readI32();
                                comparable = new FieldObjectData();
                                ((FieldObjectData)comparable).read(tProtocol);
                                singlePartObjectsData.fieldObjectsData.put(n, (FieldObjectData)comparable);
                            }
                            tProtocol.readMapEnd();
                            singlePartObjectsData.setFieldObjectsDataIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 6: {
                        Comparable<FieldObjectData> comparable;
                        int n;
                        int n2;
                        TMap tMap;
                        if (tField.type == 13) {
                            tMap = tProtocol.readMapBegin();
                            singlePartObjectsData.nonFieldObjectsData = new HashMap<Integer, NonFieldObjectData>(2 * tMap.size);
                            for (n2 = 0; n2 < tMap.size; ++n2) {
                                n = tProtocol.readI32();
                                comparable = new NonFieldObjectData();
                                ((NonFieldObjectData)comparable).read(tProtocol);
                                singlePartObjectsData.nonFieldObjectsData.put(n, (NonFieldObjectData)comparable);
                            }
                            tProtocol.readMapEnd();
                            singlePartObjectsData.setNonFieldObjectsDataIsSet(true);
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
            singlePartObjectsData.validate();
        }

        public void write(TProtocol tProtocol, SinglePartObjectsData singlePartObjectsData) throws TException {
            singlePartObjectsData.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            tProtocol.writeFieldBegin(PART_INDEX_FIELD_DESC);
            tProtocol.writeI32(singlePartObjectsData.partIndex);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(ROW_INDEX_FIELD_DESC);
            tProtocol.writeI32(singlePartObjectsData.rowIndex);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(ROW_ID_FIELD_DESC);
            tProtocol.writeI32(singlePartObjectsData.rowId);
            tProtocol.writeFieldEnd();
            if (singlePartObjectsData.partType != null) {
                tProtocol.writeFieldBegin(PART_TYPE_FIELD_DESC);
                tProtocol.writeI32(singlePartObjectsData.partType.getValue());
                tProtocol.writeFieldEnd();
            }
            if (singlePartObjectsData.fieldObjectsData != null) {
                tProtocol.writeFieldBegin(FIELD_OBJECTS_DATA_FIELD_DESC);
                tProtocol.writeMapBegin(new TMap(8, 12, singlePartObjectsData.fieldObjectsData.size()));
                for (Map.Entry<Integer, Comparable<FieldObjectData>> entry : singlePartObjectsData.fieldObjectsData.entrySet()) {
                    tProtocol.writeI32(entry.getKey().intValue());
                    ((FieldObjectData)entry.getValue()).write(tProtocol);
                }
                tProtocol.writeMapEnd();
                tProtocol.writeFieldEnd();
            }
            if (singlePartObjectsData.nonFieldObjectsData != null) {
                tProtocol.writeFieldBegin(NON_FIELD_OBJECTS_DATA_FIELD_DESC);
                tProtocol.writeMapBegin(new TMap(8, 12, singlePartObjectsData.nonFieldObjectsData.size()));
                for (Map.Entry<Integer, Comparable<FieldObjectData>> entry : singlePartObjectsData.nonFieldObjectsData.entrySet()) {
                    tProtocol.writeI32(entry.getKey().intValue());
                    ((NonFieldObjectData)entry.getValue()).write(tProtocol);
                }
                tProtocol.writeMapEnd();
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

