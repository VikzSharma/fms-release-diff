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
package com.filemaker.jwpc.iwp.thrift.layout;

import com.filemaker.jwpc.iwp.thrift.layout.SinglePartObjectsData;
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

public class SingleRowPartsData
implements TBase<SingleRowPartsData, _Fields>,
Serializable,
Cloneable,
Comparable<SingleRowPartsData> {
    private static final TStruct STRUCT_DESC = new TStruct("SingleRowPartsData");
    private static final TField ROW_INDEX_FIELD_DESC = new TField("rowIndex", 8, 1);
    private static final TField ROW_ID_FIELD_DESC = new TField("rowId", 8, 2);
    private static final TField PARTS_DATA_FIELD_DESC = new TField("partsData", 15, 3);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new SingleRowPartsDataStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new SingleRowPartsDataTupleSchemeFactory();
    private int rowIndex;
    private int rowId;
    @Nullable
    private List<SinglePartObjectsData> partsData;
    private static final int __ROWINDEX_ISSET_ID = 0;
    private static final int __ROWID_ISSET_ID = 1;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public SingleRowPartsData() {
        this.rowIndex = 0;
        this.rowId = 0;
    }

    public SingleRowPartsData(int n, int n2, List<SinglePartObjectsData> list) {
        this();
        this.rowIndex = n;
        this.setRowIndexIsSet(true);
        this.rowId = n2;
        this.setRowIdIsSet(true);
        this.partsData = list;
    }

    public SingleRowPartsData(SingleRowPartsData singleRowPartsData) {
        this.__isset_bitfield = singleRowPartsData.__isset_bitfield;
        this.rowIndex = singleRowPartsData.rowIndex;
        this.rowId = singleRowPartsData.rowId;
        if (singleRowPartsData.isSetPartsData()) {
            ArrayList<SinglePartObjectsData> arrayList = new ArrayList<SinglePartObjectsData>(singleRowPartsData.partsData.size());
            for (SinglePartObjectsData singlePartObjectsData : singleRowPartsData.partsData) {
                arrayList.add(new SinglePartObjectsData(singlePartObjectsData));
            }
            this.partsData = arrayList;
        }
    }

    public SingleRowPartsData deepCopy() {
        return new SingleRowPartsData(this);
    }

    public void clear() {
        this.rowIndex = 0;
        this.rowId = 0;
        this.partsData = null;
    }

    public int getRowIndex() {
        return this.rowIndex;
    }

    public void setRowIndex(int n) {
        this.rowIndex = n;
        this.setRowIndexIsSet(true);
    }

    public void unsetRowIndex() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetRowIndex() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setRowIndexIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public int getRowId() {
        return this.rowId;
    }

    public void setRowId(int n) {
        this.rowId = n;
        this.setRowIdIsSet(true);
    }

    public void unsetRowId() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)1);
    }

    public boolean isSetRowId() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)1);
    }

    public void setRowIdIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)1, (boolean)bl);
    }

    public int getPartsDataSize() {
        return this.partsData == null ? 0 : this.partsData.size();
    }

    @Nullable
    public Iterator<SinglePartObjectsData> getPartsDataIterator() {
        return this.partsData == null ? null : this.partsData.iterator();
    }

    public void addToPartsData(SinglePartObjectsData singlePartObjectsData) {
        if (this.partsData == null) {
            this.partsData = new ArrayList<SinglePartObjectsData>();
        }
        this.partsData.add(singlePartObjectsData);
    }

    @Nullable
    public List<SinglePartObjectsData> getPartsData() {
        return this.partsData;
    }

    public void setPartsData(@Nullable List<SinglePartObjectsData> list) {
        this.partsData = list;
    }

    public void unsetPartsData() {
        this.partsData = null;
    }

    public boolean isSetPartsData() {
        return this.partsData != null;
    }

    public void setPartsDataIsSet(boolean bl) {
        if (!bl) {
            this.partsData = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetRowIndex();
                    break;
                }
                this.setRowIndex((Integer)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetRowId();
                    break;
                }
                this.setRowId((Integer)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetPartsData();
                    break;
                }
                this.setPartsData((List)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getRowIndex();
            }
            case 1: {
                return this.getRowId();
            }
            case 2: {
                return this.getPartsData();
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
                return this.isSetRowIndex();
            }
            case 1: {
                return this.isSetRowId();
            }
            case 2: {
                return this.isSetPartsData();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof SingleRowPartsData) {
            return this.equals((SingleRowPartsData)object);
        }
        return false;
    }

    public boolean equals(SingleRowPartsData singleRowPartsData) {
        if (singleRowPartsData == null) {
            return false;
        }
        if (this == singleRowPartsData) {
            return true;
        }
        boolean bl = true;
        boolean bl2 = true;
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (this.rowIndex != singleRowPartsData.rowIndex) {
                return false;
            }
        }
        boolean bl3 = true;
        boolean bl4 = true;
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (this.rowId != singleRowPartsData.rowId) {
                return false;
            }
        }
        boolean bl5 = this.isSetPartsData();
        boolean bl6 = singleRowPartsData.isSetPartsData();
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (!this.partsData.equals(singleRowPartsData.partsData)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + this.rowIndex;
        n = n * 8191 + this.rowId;
        n = n * 8191 + (this.isSetPartsData() ? 131071 : 524287);
        if (this.isSetPartsData()) {
            n = n * 8191 + this.partsData.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(SingleRowPartsData singleRowPartsData) {
        if (!this.getClass().equals(singleRowPartsData.getClass())) {
            return this.getClass().getName().compareTo(singleRowPartsData.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetRowIndex(), singleRowPartsData.isSetRowIndex());
        if (n != 0) {
            return n;
        }
        if (this.isSetRowIndex() && (n = TBaseHelper.compareTo((int)this.rowIndex, (int)singleRowPartsData.rowIndex)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetRowId(), singleRowPartsData.isSetRowId());
        if (n != 0) {
            return n;
        }
        if (this.isSetRowId() && (n = TBaseHelper.compareTo((int)this.rowId, (int)singleRowPartsData.rowId)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetPartsData(), singleRowPartsData.isSetPartsData());
        if (n != 0) {
            return n;
        }
        if (this.isSetPartsData() && (n = TBaseHelper.compareTo(this.partsData, singleRowPartsData.partsData)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        SingleRowPartsData.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        SingleRowPartsData.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("SingleRowPartsData(");
        boolean bl = true;
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
        stringBuilder.append("partsData:");
        if (this.partsData == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.partsData);
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
        enumMap.put(_Fields.ROW_INDEX, new FieldMetaData("rowIndex", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.ROW_ID, new FieldMetaData("rowId", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.PARTS_DATA, new FieldMetaData("partsData", 3, (FieldValueMetaData)new ListMetaData(15, (FieldValueMetaData)new StructMetaData(12, SinglePartObjectsData.class))));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(SingleRowPartsData.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        ROW_INDEX(1, "rowIndex"),
        ROW_ID(2, "rowId"),
        PARTS_DATA(3, "partsData");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return ROW_INDEX;
                }
                case 2: {
                    return ROW_ID;
                }
                case 3: {
                    return PARTS_DATA;
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

    private static class SingleRowPartsDataStandardSchemeFactory
    implements SchemeFactory {
        private SingleRowPartsDataStandardSchemeFactory() {
        }

        public SingleRowPartsDataStandardScheme getScheme() {
            return new SingleRowPartsDataStandardScheme();
        }
    }

    private static class SingleRowPartsDataTupleSchemeFactory
    implements SchemeFactory {
        private SingleRowPartsDataTupleSchemeFactory() {
        }

        public SingleRowPartsDataTupleScheme getScheme() {
            return new SingleRowPartsDataTupleScheme();
        }
    }

    private static class SingleRowPartsDataTupleScheme
    extends TupleScheme<SingleRowPartsData> {
        private SingleRowPartsDataTupleScheme() {
        }

        public void write(TProtocol tProtocol, SingleRowPartsData singleRowPartsData) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (singleRowPartsData.isSetRowIndex()) {
                bitSet.set(0);
            }
            if (singleRowPartsData.isSetRowId()) {
                bitSet.set(1);
            }
            if (singleRowPartsData.isSetPartsData()) {
                bitSet.set(2);
            }
            tTupleProtocol.writeBitSet(bitSet, 3);
            if (singleRowPartsData.isSetRowIndex()) {
                tTupleProtocol.writeI32(singleRowPartsData.rowIndex);
            }
            if (singleRowPartsData.isSetRowId()) {
                tTupleProtocol.writeI32(singleRowPartsData.rowId);
            }
            if (singleRowPartsData.isSetPartsData()) {
                tTupleProtocol.writeI32(singleRowPartsData.partsData.size());
                for (SinglePartObjectsData singlePartObjectsData : singleRowPartsData.partsData) {
                    singlePartObjectsData.write((TProtocol)tTupleProtocol);
                }
            }
        }

        public void read(TProtocol tProtocol, SingleRowPartsData singleRowPartsData) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(3);
            if (bitSet.get(0)) {
                singleRowPartsData.rowIndex = tTupleProtocol.readI32();
                singleRowPartsData.setRowIndexIsSet(true);
            }
            if (bitSet.get(1)) {
                singleRowPartsData.rowId = tTupleProtocol.readI32();
                singleRowPartsData.setRowIdIsSet(true);
            }
            if (bitSet.get(2)) {
                TList tList = tTupleProtocol.readListBegin((byte)12);
                singleRowPartsData.partsData = new ArrayList<SinglePartObjectsData>(tList.size);
                for (int i = 0; i < tList.size; ++i) {
                    SinglePartObjectsData singlePartObjectsData = new SinglePartObjectsData();
                    singlePartObjectsData.read((TProtocol)tTupleProtocol);
                    singleRowPartsData.partsData.add(singlePartObjectsData);
                }
                singleRowPartsData.setPartsDataIsSet(true);
            }
        }
    }

    private static class SingleRowPartsDataStandardScheme
    extends StandardScheme<SingleRowPartsData> {
        private SingleRowPartsDataStandardScheme() {
        }

        public void read(TProtocol tProtocol, SingleRowPartsData singleRowPartsData) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 8) {
                            singleRowPartsData.rowIndex = tProtocol.readI32();
                            singleRowPartsData.setRowIndexIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 8) {
                            singleRowPartsData.rowId = tProtocol.readI32();
                            singleRowPartsData.setRowIdIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 15) {
                            TList tList = tProtocol.readListBegin();
                            singleRowPartsData.partsData = new ArrayList<SinglePartObjectsData>(tList.size);
                            for (int i = 0; i < tList.size; ++i) {
                                SinglePartObjectsData singlePartObjectsData = new SinglePartObjectsData();
                                singlePartObjectsData.read(tProtocol);
                                singleRowPartsData.partsData.add(singlePartObjectsData);
                            }
                            tProtocol.readListEnd();
                            singleRowPartsData.setPartsDataIsSet(true);
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
            singleRowPartsData.validate();
        }

        public void write(TProtocol tProtocol, SingleRowPartsData singleRowPartsData) throws TException {
            singleRowPartsData.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            tProtocol.writeFieldBegin(ROW_INDEX_FIELD_DESC);
            tProtocol.writeI32(singleRowPartsData.rowIndex);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(ROW_ID_FIELD_DESC);
            tProtocol.writeI32(singleRowPartsData.rowId);
            tProtocol.writeFieldEnd();
            if (singleRowPartsData.partsData != null) {
                tProtocol.writeFieldBegin(PARTS_DATA_FIELD_DESC);
                tProtocol.writeListBegin(new TList(12, singleRowPartsData.partsData.size()));
                for (SinglePartObjectsData singlePartObjectsData : singleRowPartsData.partsData) {
                    singlePartObjectsData.write(tProtocol);
                }
                tProtocol.writeListEnd();
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

