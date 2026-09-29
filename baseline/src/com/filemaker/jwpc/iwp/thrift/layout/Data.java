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

import com.filemaker.jwpc.iwp.thrift.common.BinaryData;
import com.filemaker.jwpc.iwp.thrift.common.StringData;
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

public class Data
implements TBase<Data, _Fields>,
Serializable,
Cloneable,
Comparable<Data> {
    private static final TStruct STRUCT_DESC = new TStruct("Data");
    private static final TField BINARY_VALUE_FIELD_DESC = new TField("binaryValue", 12, 1);
    private static final TField BINARY_VALUES_FIELD_DESC = new TField("binaryValues", 13, 2);
    private static final TField STRING_VALUE_FIELD_DESC = new TField("stringValue", 12, 3);
    private static final TField STRING_REP_VALUES_FIELD_DESC = new TField("stringRepValues", 13, 4);
    private static final TField STRING_VALUES_FIELD_DESC = new TField("stringValues", 13, 5);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new DataStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new DataTupleSchemeFactory();
    @Nullable
    private BinaryData binaryValue;
    @Nullable
    private Map<Short, BinaryData> binaryValues;
    @Nullable
    private StringData stringValue;
    @Nullable
    private Map<Short, StringData> stringRepValues;
    @Nullable
    private Map<Integer, StringData> stringValues;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public Data() {
    }

    public Data(BinaryData binaryData, Map<Short, BinaryData> map, StringData stringData, Map<Short, StringData> map2, Map<Integer, StringData> map3) {
        this();
        this.binaryValue = binaryData;
        this.binaryValues = map;
        this.stringValue = stringData;
        this.stringRepValues = map2;
        this.stringValues = map3;
    }

    public Data(Data data) {
        Comparable<BinaryData> comparable;
        Short s;
        Comparable<BinaryData> comparable2;
        Number number;
        HashMap<Short, BinaryData> hashMap;
        if (data.isSetBinaryValue()) {
            this.binaryValue = new BinaryData(data.binaryValue);
        }
        if (data.isSetBinaryValues()) {
            hashMap = new HashMap<Short, BinaryData>(data.binaryValues.size());
            for (Map.Entry<Short, BinaryData> entry : data.binaryValues.entrySet()) {
                number = entry.getKey();
                comparable2 = entry.getValue();
                s = number;
                comparable = new BinaryData((BinaryData)comparable2);
                hashMap.put(s, (BinaryData)comparable);
            }
            this.binaryValues = hashMap;
        }
        if (data.isSetStringValue()) {
            this.stringValue = new StringData(data.stringValue);
        }
        if (data.isSetStringRepValues()) {
            hashMap = new HashMap(data.stringRepValues.size());
            for (Map.Entry<Number, Comparable<BinaryData>> entry : data.stringRepValues.entrySet()) {
                number = (Short)entry.getKey();
                comparable2 = (StringData)entry.getValue();
                s = number;
                comparable = new StringData((StringData)comparable2);
                hashMap.put(s, (BinaryData)comparable);
            }
            this.stringRepValues = hashMap;
        }
        if (data.isSetStringValues()) {
            hashMap = new HashMap(data.stringValues.size());
            for (Map.Entry<Number, Comparable<BinaryData>> entry : data.stringValues.entrySet()) {
                number = (Integer)entry.getKey();
                comparable2 = (StringData)entry.getValue();
                s = number;
                comparable = new StringData((StringData)comparable2);
                hashMap.put(s, (BinaryData)comparable);
            }
            this.stringValues = hashMap;
        }
    }

    public Data deepCopy() {
        return new Data(this);
    }

    public void clear() {
        this.binaryValue = null;
        this.binaryValues = null;
        this.stringValue = null;
        this.stringRepValues = null;
        this.stringValues = null;
    }

    @Nullable
    public BinaryData getBinaryValue() {
        return this.binaryValue;
    }

    public void setBinaryValue(@Nullable BinaryData binaryData) {
        this.binaryValue = binaryData;
    }

    public void unsetBinaryValue() {
        this.binaryValue = null;
    }

    public boolean isSetBinaryValue() {
        return this.binaryValue != null;
    }

    public void setBinaryValueIsSet(boolean bl) {
        if (!bl) {
            this.binaryValue = null;
        }
    }

    public int getBinaryValuesSize() {
        return this.binaryValues == null ? 0 : this.binaryValues.size();
    }

    public void putToBinaryValues(short s, BinaryData binaryData) {
        if (this.binaryValues == null) {
            this.binaryValues = new HashMap<Short, BinaryData>();
        }
        this.binaryValues.put(s, binaryData);
    }

    @Nullable
    public Map<Short, BinaryData> getBinaryValues() {
        return this.binaryValues;
    }

    public void setBinaryValues(@Nullable Map<Short, BinaryData> map) {
        this.binaryValues = map;
    }

    public void unsetBinaryValues() {
        this.binaryValues = null;
    }

    public boolean isSetBinaryValues() {
        return this.binaryValues != null;
    }

    public void setBinaryValuesIsSet(boolean bl) {
        if (!bl) {
            this.binaryValues = null;
        }
    }

    @Nullable
    public StringData getStringValue() {
        return this.stringValue;
    }

    public void setStringValue(@Nullable StringData stringData) {
        this.stringValue = stringData;
    }

    public void unsetStringValue() {
        this.stringValue = null;
    }

    public boolean isSetStringValue() {
        return this.stringValue != null;
    }

    public void setStringValueIsSet(boolean bl) {
        if (!bl) {
            this.stringValue = null;
        }
    }

    public int getStringRepValuesSize() {
        return this.stringRepValues == null ? 0 : this.stringRepValues.size();
    }

    public void putToStringRepValues(short s, StringData stringData) {
        if (this.stringRepValues == null) {
            this.stringRepValues = new HashMap<Short, StringData>();
        }
        this.stringRepValues.put(s, stringData);
    }

    @Nullable
    public Map<Short, StringData> getStringRepValues() {
        return this.stringRepValues;
    }

    public void setStringRepValues(@Nullable Map<Short, StringData> map) {
        this.stringRepValues = map;
    }

    public void unsetStringRepValues() {
        this.stringRepValues = null;
    }

    public boolean isSetStringRepValues() {
        return this.stringRepValues != null;
    }

    public void setStringRepValuesIsSet(boolean bl) {
        if (!bl) {
            this.stringRepValues = null;
        }
    }

    public int getStringValuesSize() {
        return this.stringValues == null ? 0 : this.stringValues.size();
    }

    public void putToStringValues(int n, StringData stringData) {
        if (this.stringValues == null) {
            this.stringValues = new HashMap<Integer, StringData>();
        }
        this.stringValues.put(n, stringData);
    }

    @Nullable
    public Map<Integer, StringData> getStringValues() {
        return this.stringValues;
    }

    public void setStringValues(@Nullable Map<Integer, StringData> map) {
        this.stringValues = map;
    }

    public void unsetStringValues() {
        this.stringValues = null;
    }

    public boolean isSetStringValues() {
        return this.stringValues != null;
    }

    public void setStringValuesIsSet(boolean bl) {
        if (!bl) {
            this.stringValues = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetBinaryValue();
                    break;
                }
                this.setBinaryValue((BinaryData)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetBinaryValues();
                    break;
                }
                this.setBinaryValues((Map)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetStringValue();
                    break;
                }
                this.setStringValue((StringData)object);
                break;
            }
            case 3: {
                if (object == null) {
                    this.unsetStringRepValues();
                    break;
                }
                this.setStringRepValues((Map)object);
                break;
            }
            case 4: {
                if (object == null) {
                    this.unsetStringValues();
                    break;
                }
                this.setStringValues((Map)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getBinaryValue();
            }
            case 1: {
                return this.getBinaryValues();
            }
            case 2: {
                return this.getStringValue();
            }
            case 3: {
                return this.getStringRepValues();
            }
            case 4: {
                return this.getStringValues();
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
                return this.isSetBinaryValue();
            }
            case 1: {
                return this.isSetBinaryValues();
            }
            case 2: {
                return this.isSetStringValue();
            }
            case 3: {
                return this.isSetStringRepValues();
            }
            case 4: {
                return this.isSetStringValues();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof Data) {
            return this.equals((Data)object);
        }
        return false;
    }

    public boolean equals(Data data) {
        if (data == null) {
            return false;
        }
        if (this == data) {
            return true;
        }
        boolean bl = this.isSetBinaryValue();
        boolean bl2 = data.isSetBinaryValue();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.binaryValue.equals(data.binaryValue)) {
                return false;
            }
        }
        boolean bl3 = this.isSetBinaryValues();
        boolean bl4 = data.isSetBinaryValues();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.binaryValues.equals(data.binaryValues)) {
                return false;
            }
        }
        boolean bl5 = this.isSetStringValue();
        boolean bl6 = data.isSetStringValue();
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (!this.stringValue.equals(data.stringValue)) {
                return false;
            }
        }
        boolean bl7 = this.isSetStringRepValues();
        boolean bl8 = data.isSetStringRepValues();
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (!this.stringRepValues.equals(data.stringRepValues)) {
                return false;
            }
        }
        boolean bl9 = this.isSetStringValues();
        boolean bl10 = data.isSetStringValues();
        if (bl9 || bl10) {
            if (!bl9 || !bl10) {
                return false;
            }
            if (!this.stringValues.equals(data.stringValues)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetBinaryValue() ? 131071 : 524287);
        if (this.isSetBinaryValue()) {
            n = n * 8191 + this.binaryValue.hashCode();
        }
        n = n * 8191 + (this.isSetBinaryValues() ? 131071 : 524287);
        if (this.isSetBinaryValues()) {
            n = n * 8191 + this.binaryValues.hashCode();
        }
        n = n * 8191 + (this.isSetStringValue() ? 131071 : 524287);
        if (this.isSetStringValue()) {
            n = n * 8191 + this.stringValue.hashCode();
        }
        n = n * 8191 + (this.isSetStringRepValues() ? 131071 : 524287);
        if (this.isSetStringRepValues()) {
            n = n * 8191 + this.stringRepValues.hashCode();
        }
        n = n * 8191 + (this.isSetStringValues() ? 131071 : 524287);
        if (this.isSetStringValues()) {
            n = n * 8191 + this.stringValues.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(Data data) {
        if (!this.getClass().equals(data.getClass())) {
            return this.getClass().getName().compareTo(data.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetBinaryValue(), data.isSetBinaryValue());
        if (n != 0) {
            return n;
        }
        if (this.isSetBinaryValue() && (n = TBaseHelper.compareTo((Comparable)this.binaryValue, (Comparable)data.binaryValue)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetBinaryValues(), data.isSetBinaryValues());
        if (n != 0) {
            return n;
        }
        if (this.isSetBinaryValues() && (n = TBaseHelper.compareTo(this.binaryValues, data.binaryValues)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetStringValue(), data.isSetStringValue());
        if (n != 0) {
            return n;
        }
        if (this.isSetStringValue() && (n = TBaseHelper.compareTo((Comparable)this.stringValue, (Comparable)data.stringValue)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetStringRepValues(), data.isSetStringRepValues());
        if (n != 0) {
            return n;
        }
        if (this.isSetStringRepValues() && (n = TBaseHelper.compareTo(this.stringRepValues, data.stringRepValues)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetStringValues(), data.isSetStringValues());
        if (n != 0) {
            return n;
        }
        if (this.isSetStringValues() && (n = TBaseHelper.compareTo(this.stringValues, data.stringValues)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        Data.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        Data.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Data(");
        boolean bl = true;
        stringBuilder.append("binaryValue:");
        if (this.binaryValue == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.binaryValue);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("binaryValues:");
        if (this.binaryValues == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.binaryValues);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("stringValue:");
        if (this.stringValue == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.stringValue);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("stringRepValues:");
        if (this.stringRepValues == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.stringRepValues);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("stringValues:");
        if (this.stringValues == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.stringValues);
        }
        bl = false;
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void validate() throws TException {
        if (this.binaryValue != null) {
            this.binaryValue.validate();
        }
        if (this.stringValue != null) {
            this.stringValue.validate();
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
        enumMap.put(_Fields.BINARY_VALUE, new FieldMetaData("binaryValue", 3, (FieldValueMetaData)new StructMetaData(12, BinaryData.class)));
        enumMap.put(_Fields.BINARY_VALUES, new FieldMetaData("binaryValues", 3, (FieldValueMetaData)new MapMetaData(13, new FieldValueMetaData(6), (FieldValueMetaData)new StructMetaData(12, BinaryData.class))));
        enumMap.put(_Fields.STRING_VALUE, new FieldMetaData("stringValue", 3, (FieldValueMetaData)new StructMetaData(12, StringData.class)));
        enumMap.put(_Fields.STRING_REP_VALUES, new FieldMetaData("stringRepValues", 3, (FieldValueMetaData)new MapMetaData(13, new FieldValueMetaData(6), (FieldValueMetaData)new StructMetaData(12, StringData.class))));
        enumMap.put(_Fields.STRING_VALUES, new FieldMetaData("stringValues", 3, (FieldValueMetaData)new MapMetaData(13, new FieldValueMetaData(8), (FieldValueMetaData)new StructMetaData(12, StringData.class))));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(Data.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        BINARY_VALUE(1, "binaryValue"),
        BINARY_VALUES(2, "binaryValues"),
        STRING_VALUE(3, "stringValue"),
        STRING_REP_VALUES(4, "stringRepValues"),
        STRING_VALUES(5, "stringValues");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return BINARY_VALUE;
                }
                case 2: {
                    return BINARY_VALUES;
                }
                case 3: {
                    return STRING_VALUE;
                }
                case 4: {
                    return STRING_REP_VALUES;
                }
                case 5: {
                    return STRING_VALUES;
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

    private static class DataStandardSchemeFactory
    implements SchemeFactory {
        private DataStandardSchemeFactory() {
        }

        public DataStandardScheme getScheme() {
            return new DataStandardScheme();
        }
    }

    private static class DataTupleSchemeFactory
    implements SchemeFactory {
        private DataTupleSchemeFactory() {
        }

        public DataTupleScheme getScheme() {
            return new DataTupleScheme();
        }
    }

    private static class DataTupleScheme
    extends TupleScheme<Data> {
        private DataTupleScheme() {
        }

        public void write(TProtocol tProtocol, Data data) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (data.isSetBinaryValue()) {
                bitSet.set(0);
            }
            if (data.isSetBinaryValues()) {
                bitSet.set(1);
            }
            if (data.isSetStringValue()) {
                bitSet.set(2);
            }
            if (data.isSetStringRepValues()) {
                bitSet.set(3);
            }
            if (data.isSetStringValues()) {
                bitSet.set(4);
            }
            tTupleProtocol.writeBitSet(bitSet, 5);
            if (data.isSetBinaryValue()) {
                data.binaryValue.write((TProtocol)tTupleProtocol);
            }
            if (data.isSetBinaryValues()) {
                tTupleProtocol.writeI32(data.binaryValues.size());
                for (Map.Entry<Short, BinaryData> entry : data.binaryValues.entrySet()) {
                    tTupleProtocol.writeI16(entry.getKey().shortValue());
                    entry.getValue().write((TProtocol)tTupleProtocol);
                }
            }
            if (data.isSetStringValue()) {
                data.stringValue.write((TProtocol)tTupleProtocol);
            }
            if (data.isSetStringRepValues()) {
                tTupleProtocol.writeI32(data.stringRepValues.size());
                for (Map.Entry<Number, Comparable<BinaryData>> entry : data.stringRepValues.entrySet()) {
                    tTupleProtocol.writeI16(((Short)entry.getKey()).shortValue());
                    ((StringData)entry.getValue()).write((TProtocol)tTupleProtocol);
                }
            }
            if (data.isSetStringValues()) {
                tTupleProtocol.writeI32(data.stringValues.size());
                for (Map.Entry<Number, Comparable<BinaryData>> entry : data.stringValues.entrySet()) {
                    tTupleProtocol.writeI32(((Integer)entry.getKey()).intValue());
                    ((StringData)entry.getValue()).write((TProtocol)tTupleProtocol);
                }
            }
        }

        public void read(TProtocol tProtocol, Data data) throws TException {
            Comparable<BinaryData> comparable;
            int n;
            TMap tMap;
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(5);
            if (bitSet.get(0)) {
                data.binaryValue = new BinaryData();
                data.binaryValue.read((TProtocol)tTupleProtocol);
                data.setBinaryValueIsSet(true);
            }
            if (bitSet.get(1)) {
                tMap = tTupleProtocol.readMapBegin((byte)6, (byte)12);
                data.binaryValues = new HashMap<Short, BinaryData>(2 * tMap.size);
                for (n = 0; n < tMap.size; ++n) {
                    short s = tTupleProtocol.readI16();
                    comparable = new BinaryData();
                    ((BinaryData)comparable).read((TProtocol)tTupleProtocol);
                    data.binaryValues.put(s, (BinaryData)comparable);
                }
                data.setBinaryValuesIsSet(true);
            }
            if (bitSet.get(2)) {
                data.stringValue = new StringData();
                data.stringValue.read((TProtocol)tTupleProtocol);
                data.setStringValueIsSet(true);
            }
            if (bitSet.get(3)) {
                tMap = tTupleProtocol.readMapBegin((byte)6, (byte)12);
                data.stringRepValues = new HashMap<Short, StringData>(2 * tMap.size);
                for (n = 0; n < tMap.size; ++n) {
                    short s = tTupleProtocol.readI16();
                    comparable = new StringData();
                    ((StringData)comparable).read((TProtocol)tTupleProtocol);
                    data.stringRepValues.put(s, (StringData)comparable);
                }
                data.setStringRepValuesIsSet(true);
            }
            if (bitSet.get(4)) {
                tMap = tTupleProtocol.readMapBegin((byte)8, (byte)12);
                data.stringValues = new HashMap<Integer, StringData>(2 * tMap.size);
                for (n = 0; n < tMap.size; ++n) {
                    int n2 = tTupleProtocol.readI32();
                    comparable = new StringData();
                    ((StringData)comparable).read((TProtocol)tTupleProtocol);
                    data.stringValues.put(n2, (StringData)comparable);
                }
                data.setStringValuesIsSet(true);
            }
        }
    }

    private static class DataStandardScheme
    extends StandardScheme<Data> {
        private DataStandardScheme() {
        }

        public void read(TProtocol tProtocol, Data data) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 12) {
                            data.binaryValue = new BinaryData();
                            data.binaryValue.read(tProtocol);
                            data.setBinaryValueIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        Comparable<BinaryData> comparable;
                        short s;
                        int n;
                        TMap tMap;
                        if (tField.type == 13) {
                            tMap = tProtocol.readMapBegin();
                            data.binaryValues = new HashMap<Short, BinaryData>(2 * tMap.size);
                            for (n = 0; n < tMap.size; ++n) {
                                s = tProtocol.readI16();
                                comparable = new BinaryData();
                                ((BinaryData)comparable).read(tProtocol);
                                data.binaryValues.put(s, (BinaryData)comparable);
                            }
                            tProtocol.readMapEnd();
                            data.setBinaryValuesIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 12) {
                            data.stringValue = new StringData();
                            data.stringValue.read(tProtocol);
                            data.setStringValueIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        Comparable<BinaryData> comparable;
                        short s;
                        int n;
                        TMap tMap;
                        if (tField.type == 13) {
                            tMap = tProtocol.readMapBegin();
                            data.stringRepValues = new HashMap<Short, StringData>(2 * tMap.size);
                            for (n = 0; n < tMap.size; ++n) {
                                s = tProtocol.readI16();
                                comparable = new StringData();
                                ((StringData)comparable).read(tProtocol);
                                data.stringRepValues.put(s, (StringData)comparable);
                            }
                            tProtocol.readMapEnd();
                            data.setStringRepValuesIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 5: {
                        Comparable<BinaryData> comparable;
                        short s;
                        int n;
                        TMap tMap;
                        if (tField.type == 13) {
                            tMap = tProtocol.readMapBegin();
                            data.stringValues = new HashMap<Integer, StringData>(2 * tMap.size);
                            for (n = 0; n < tMap.size; ++n) {
                                s = tProtocol.readI32();
                                comparable = new StringData();
                                ((StringData)comparable).read(tProtocol);
                                data.stringValues.put(Integer.valueOf(s), (StringData)comparable);
                            }
                            tProtocol.readMapEnd();
                            data.setStringValuesIsSet(true);
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
            data.validate();
        }

        public void write(TProtocol tProtocol, Data data) throws TException {
            data.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (data.binaryValue != null) {
                tProtocol.writeFieldBegin(BINARY_VALUE_FIELD_DESC);
                data.binaryValue.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            if (data.binaryValues != null) {
                tProtocol.writeFieldBegin(BINARY_VALUES_FIELD_DESC);
                tProtocol.writeMapBegin(new TMap(6, 12, data.binaryValues.size()));
                for (Map.Entry<Short, BinaryData> entry : data.binaryValues.entrySet()) {
                    tProtocol.writeI16(entry.getKey().shortValue());
                    entry.getValue().write(tProtocol);
                }
                tProtocol.writeMapEnd();
                tProtocol.writeFieldEnd();
            }
            if (data.stringValue != null) {
                tProtocol.writeFieldBegin(STRING_VALUE_FIELD_DESC);
                data.stringValue.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            if (data.stringRepValues != null) {
                tProtocol.writeFieldBegin(STRING_REP_VALUES_FIELD_DESC);
                tProtocol.writeMapBegin(new TMap(6, 12, data.stringRepValues.size()));
                for (Map.Entry<Number, Comparable<BinaryData>> entry : data.stringRepValues.entrySet()) {
                    tProtocol.writeI16(((Short)entry.getKey()).shortValue());
                    ((StringData)entry.getValue()).write(tProtocol);
                }
                tProtocol.writeMapEnd();
                tProtocol.writeFieldEnd();
            }
            if (data.stringValues != null) {
                tProtocol.writeFieldBegin(STRING_VALUES_FIELD_DESC);
                tProtocol.writeMapBegin(new TMap(8, 12, data.stringValues.size()));
                for (Map.Entry<Number, Comparable<BinaryData>> entry : data.stringValues.entrySet()) {
                    tProtocol.writeI32(((Integer)entry.getKey()).intValue());
                    ((StringData)entry.getValue()).write(tProtocol);
                }
                tProtocol.writeMapEnd();
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

