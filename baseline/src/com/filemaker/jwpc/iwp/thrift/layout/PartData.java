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
import com.filemaker.jwpc.iwp.thrift.layout.SinglePartObjectsData;
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

public class PartData
implements TBase<PartData, _Fields>,
Serializable,
Cloneable,
Comparable<PartData> {
    private static final TStruct STRUCT_DESC = new TStruct("PartData");
    private static final TField PART_NON_FIELD_OBJECTS_DATA_FIELD_DESC = new TField("partNonFieldObjectsData", 13, 1);
    private static final TField PART_OBJECTS_DATA_FIELD_DESC = new TField("partObjectsData", 12, 2);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new PartDataStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new PartDataTupleSchemeFactory();
    @Nullable
    private Map<Integer, NonFieldObjectsData> partNonFieldObjectsData;
    @Nullable
    private SinglePartObjectsData partObjectsData;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public PartData() {
    }

    public PartData(Map<Integer, NonFieldObjectsData> map, SinglePartObjectsData singlePartObjectsData) {
        this();
        this.partNonFieldObjectsData = map;
        this.partObjectsData = singlePartObjectsData;
    }

    public PartData(PartData partData) {
        if (partData.isSetPartNonFieldObjectsData()) {
            HashMap<Integer, NonFieldObjectsData> hashMap = new HashMap<Integer, NonFieldObjectsData>(partData.partNonFieldObjectsData.size());
            for (Map.Entry<Integer, NonFieldObjectsData> entry : partData.partNonFieldObjectsData.entrySet()) {
                Integer n = entry.getKey();
                NonFieldObjectsData nonFieldObjectsData = entry.getValue();
                Integer n2 = n;
                NonFieldObjectsData nonFieldObjectsData2 = new NonFieldObjectsData(nonFieldObjectsData);
                hashMap.put(n2, nonFieldObjectsData2);
            }
            this.partNonFieldObjectsData = hashMap;
        }
        if (partData.isSetPartObjectsData()) {
            this.partObjectsData = new SinglePartObjectsData(partData.partObjectsData);
        }
    }

    public PartData deepCopy() {
        return new PartData(this);
    }

    public void clear() {
        this.partNonFieldObjectsData = null;
        this.partObjectsData = null;
    }

    public int getPartNonFieldObjectsDataSize() {
        return this.partNonFieldObjectsData == null ? 0 : this.partNonFieldObjectsData.size();
    }

    public void putToPartNonFieldObjectsData(int n, NonFieldObjectsData nonFieldObjectsData) {
        if (this.partNonFieldObjectsData == null) {
            this.partNonFieldObjectsData = new HashMap<Integer, NonFieldObjectsData>();
        }
        this.partNonFieldObjectsData.put(n, nonFieldObjectsData);
    }

    @Nullable
    public Map<Integer, NonFieldObjectsData> getPartNonFieldObjectsData() {
        return this.partNonFieldObjectsData;
    }

    public void setPartNonFieldObjectsData(@Nullable Map<Integer, NonFieldObjectsData> map) {
        this.partNonFieldObjectsData = map;
    }

    public void unsetPartNonFieldObjectsData() {
        this.partNonFieldObjectsData = null;
    }

    public boolean isSetPartNonFieldObjectsData() {
        return this.partNonFieldObjectsData != null;
    }

    public void setPartNonFieldObjectsDataIsSet(boolean bl) {
        if (!bl) {
            this.partNonFieldObjectsData = null;
        }
    }

    @Nullable
    public SinglePartObjectsData getPartObjectsData() {
        return this.partObjectsData;
    }

    public void setPartObjectsData(@Nullable SinglePartObjectsData singlePartObjectsData) {
        this.partObjectsData = singlePartObjectsData;
    }

    public void unsetPartObjectsData() {
        this.partObjectsData = null;
    }

    public boolean isSetPartObjectsData() {
        return this.partObjectsData != null;
    }

    public void setPartObjectsDataIsSet(boolean bl) {
        if (!bl) {
            this.partObjectsData = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetPartNonFieldObjectsData();
                    break;
                }
                this.setPartNonFieldObjectsData((Map)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetPartObjectsData();
                    break;
                }
                this.setPartObjectsData((SinglePartObjectsData)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getPartNonFieldObjectsData();
            }
            case 1: {
                return this.getPartObjectsData();
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
                return this.isSetPartNonFieldObjectsData();
            }
            case 1: {
                return this.isSetPartObjectsData();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof PartData) {
            return this.equals((PartData)object);
        }
        return false;
    }

    public boolean equals(PartData partData) {
        if (partData == null) {
            return false;
        }
        if (this == partData) {
            return true;
        }
        boolean bl = this.isSetPartNonFieldObjectsData();
        boolean bl2 = partData.isSetPartNonFieldObjectsData();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.partNonFieldObjectsData.equals(partData.partNonFieldObjectsData)) {
                return false;
            }
        }
        boolean bl3 = this.isSetPartObjectsData();
        boolean bl4 = partData.isSetPartObjectsData();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.partObjectsData.equals(partData.partObjectsData)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetPartNonFieldObjectsData() ? 131071 : 524287);
        if (this.isSetPartNonFieldObjectsData()) {
            n = n * 8191 + this.partNonFieldObjectsData.hashCode();
        }
        n = n * 8191 + (this.isSetPartObjectsData() ? 131071 : 524287);
        if (this.isSetPartObjectsData()) {
            n = n * 8191 + this.partObjectsData.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(PartData partData) {
        if (!this.getClass().equals(partData.getClass())) {
            return this.getClass().getName().compareTo(partData.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetPartNonFieldObjectsData(), partData.isSetPartNonFieldObjectsData());
        if (n != 0) {
            return n;
        }
        if (this.isSetPartNonFieldObjectsData() && (n = TBaseHelper.compareTo(this.partNonFieldObjectsData, partData.partNonFieldObjectsData)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetPartObjectsData(), partData.isSetPartObjectsData());
        if (n != 0) {
            return n;
        }
        if (this.isSetPartObjectsData() && (n = TBaseHelper.compareTo((Comparable)this.partObjectsData, (Comparable)partData.partObjectsData)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        PartData.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        PartData.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("PartData(");
        boolean bl = true;
        stringBuilder.append("partNonFieldObjectsData:");
        if (this.partNonFieldObjectsData == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.partNonFieldObjectsData);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("partObjectsData:");
        if (this.partObjectsData == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.partObjectsData);
        }
        bl = false;
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void validate() throws TException {
        if (this.partObjectsData != null) {
            this.partObjectsData.validate();
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
        enumMap.put(_Fields.PART_NON_FIELD_OBJECTS_DATA, new FieldMetaData("partNonFieldObjectsData", 3, (FieldValueMetaData)new MapMetaData(13, new FieldValueMetaData(8), (FieldValueMetaData)new StructMetaData(12, NonFieldObjectsData.class))));
        enumMap.put(_Fields.PART_OBJECTS_DATA, new FieldMetaData("partObjectsData", 3, (FieldValueMetaData)new StructMetaData(12, SinglePartObjectsData.class)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(PartData.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        PART_NON_FIELD_OBJECTS_DATA(1, "partNonFieldObjectsData"),
        PART_OBJECTS_DATA(2, "partObjectsData");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return PART_NON_FIELD_OBJECTS_DATA;
                }
                case 2: {
                    return PART_OBJECTS_DATA;
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

    private static class PartDataStandardSchemeFactory
    implements SchemeFactory {
        private PartDataStandardSchemeFactory() {
        }

        public PartDataStandardScheme getScheme() {
            return new PartDataStandardScheme();
        }
    }

    private static class PartDataTupleSchemeFactory
    implements SchemeFactory {
        private PartDataTupleSchemeFactory() {
        }

        public PartDataTupleScheme getScheme() {
            return new PartDataTupleScheme();
        }
    }

    private static class PartDataTupleScheme
    extends TupleScheme<PartData> {
        private PartDataTupleScheme() {
        }

        public void write(TProtocol tProtocol, PartData partData) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (partData.isSetPartNonFieldObjectsData()) {
                bitSet.set(0);
            }
            if (partData.isSetPartObjectsData()) {
                bitSet.set(1);
            }
            tTupleProtocol.writeBitSet(bitSet, 2);
            if (partData.isSetPartNonFieldObjectsData()) {
                tTupleProtocol.writeI32(partData.partNonFieldObjectsData.size());
                for (Map.Entry<Integer, NonFieldObjectsData> entry : partData.partNonFieldObjectsData.entrySet()) {
                    tTupleProtocol.writeI32(entry.getKey().intValue());
                    entry.getValue().write((TProtocol)tTupleProtocol);
                }
            }
            if (partData.isSetPartObjectsData()) {
                partData.partObjectsData.write((TProtocol)tTupleProtocol);
            }
        }

        public void read(TProtocol tProtocol, PartData partData) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(2);
            if (bitSet.get(0)) {
                TMap tMap = tTupleProtocol.readMapBegin((byte)8, (byte)12);
                partData.partNonFieldObjectsData = new HashMap<Integer, NonFieldObjectsData>(2 * tMap.size);
                for (int i = 0; i < tMap.size; ++i) {
                    int n = tTupleProtocol.readI32();
                    NonFieldObjectsData nonFieldObjectsData = new NonFieldObjectsData();
                    nonFieldObjectsData.read((TProtocol)tTupleProtocol);
                    partData.partNonFieldObjectsData.put(n, nonFieldObjectsData);
                }
                partData.setPartNonFieldObjectsDataIsSet(true);
            }
            if (bitSet.get(1)) {
                partData.partObjectsData = new SinglePartObjectsData();
                partData.partObjectsData.read((TProtocol)tTupleProtocol);
                partData.setPartObjectsDataIsSet(true);
            }
        }
    }

    private static class PartDataStandardScheme
    extends StandardScheme<PartData> {
        private PartDataStandardScheme() {
        }

        public void read(TProtocol tProtocol, PartData partData) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 13) {
                            TMap tMap = tProtocol.readMapBegin();
                            partData.partNonFieldObjectsData = new HashMap<Integer, NonFieldObjectsData>(2 * tMap.size);
                            for (int i = 0; i < tMap.size; ++i) {
                                int n = tProtocol.readI32();
                                NonFieldObjectsData nonFieldObjectsData = new NonFieldObjectsData();
                                nonFieldObjectsData.read(tProtocol);
                                partData.partNonFieldObjectsData.put(n, nonFieldObjectsData);
                            }
                            tProtocol.readMapEnd();
                            partData.setPartNonFieldObjectsDataIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 12) {
                            partData.partObjectsData = new SinglePartObjectsData();
                            partData.partObjectsData.read(tProtocol);
                            partData.setPartObjectsDataIsSet(true);
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
            partData.validate();
        }

        public void write(TProtocol tProtocol, PartData partData) throws TException {
            partData.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (partData.partNonFieldObjectsData != null) {
                tProtocol.writeFieldBegin(PART_NON_FIELD_OBJECTS_DATA_FIELD_DESC);
                tProtocol.writeMapBegin(new TMap(8, 12, partData.partNonFieldObjectsData.size()));
                for (Map.Entry<Integer, NonFieldObjectsData> entry : partData.partNonFieldObjectsData.entrySet()) {
                    tProtocol.writeI32(entry.getKey().intValue());
                    entry.getValue().write(tProtocol);
                }
                tProtocol.writeMapEnd();
                tProtocol.writeFieldEnd();
            }
            if (partData.partObjectsData != null) {
                tProtocol.writeFieldBegin(PART_OBJECTS_DATA_FIELD_DESC);
                partData.partObjectsData.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

