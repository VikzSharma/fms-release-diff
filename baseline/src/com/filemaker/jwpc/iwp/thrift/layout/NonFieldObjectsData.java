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

public class NonFieldObjectsData
implements TBase<NonFieldObjectsData, _Fields>,
Serializable,
Cloneable,
Comparable<NonFieldObjectsData> {
    private static final TStruct STRUCT_DESC = new TStruct("NonFieldObjectsData");
    private static final TField OBJECTS_FIELD_DESC = new TField("objects", 13, 1);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new NonFieldObjectsDataStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new NonFieldObjectsDataTupleSchemeFactory();
    @Nullable
    private Map<Integer, NonFieldObjectData> objects;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public NonFieldObjectsData() {
    }

    public NonFieldObjectsData(Map<Integer, NonFieldObjectData> map) {
        this();
        this.objects = map;
    }

    public NonFieldObjectsData(NonFieldObjectsData nonFieldObjectsData) {
        if (nonFieldObjectsData.isSetObjects()) {
            HashMap<Integer, NonFieldObjectData> hashMap = new HashMap<Integer, NonFieldObjectData>(nonFieldObjectsData.objects.size());
            for (Map.Entry<Integer, NonFieldObjectData> entry : nonFieldObjectsData.objects.entrySet()) {
                Integer n = entry.getKey();
                NonFieldObjectData nonFieldObjectData = entry.getValue();
                Integer n2 = n;
                NonFieldObjectData nonFieldObjectData2 = new NonFieldObjectData(nonFieldObjectData);
                hashMap.put(n2, nonFieldObjectData2);
            }
            this.objects = hashMap;
        }
    }

    public NonFieldObjectsData deepCopy() {
        return new NonFieldObjectsData(this);
    }

    public void clear() {
        this.objects = null;
    }

    public int getObjectsSize() {
        return this.objects == null ? 0 : this.objects.size();
    }

    public void putToObjects(int n, NonFieldObjectData nonFieldObjectData) {
        if (this.objects == null) {
            this.objects = new HashMap<Integer, NonFieldObjectData>();
        }
        this.objects.put(n, nonFieldObjectData);
    }

    @Nullable
    public Map<Integer, NonFieldObjectData> getObjects() {
        return this.objects;
    }

    public void setObjects(@Nullable Map<Integer, NonFieldObjectData> map) {
        this.objects = map;
    }

    public void unsetObjects() {
        this.objects = null;
    }

    public boolean isSetObjects() {
        return this.objects != null;
    }

    public void setObjectsIsSet(boolean bl) {
        if (!bl) {
            this.objects = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetObjects();
                    break;
                }
                this.setObjects((Map)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getObjects();
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
                return this.isSetObjects();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof NonFieldObjectsData) {
            return this.equals((NonFieldObjectsData)object);
        }
        return false;
    }

    public boolean equals(NonFieldObjectsData nonFieldObjectsData) {
        if (nonFieldObjectsData == null) {
            return false;
        }
        if (this == nonFieldObjectsData) {
            return true;
        }
        boolean bl = this.isSetObjects();
        boolean bl2 = nonFieldObjectsData.isSetObjects();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.objects.equals(nonFieldObjectsData.objects)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetObjects() ? 131071 : 524287);
        if (this.isSetObjects()) {
            n = n * 8191 + this.objects.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(NonFieldObjectsData nonFieldObjectsData) {
        if (!this.getClass().equals(nonFieldObjectsData.getClass())) {
            return this.getClass().getName().compareTo(nonFieldObjectsData.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetObjects(), nonFieldObjectsData.isSetObjects());
        if (n != 0) {
            return n;
        }
        if (this.isSetObjects() && (n = TBaseHelper.compareTo(this.objects, nonFieldObjectsData.objects)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        NonFieldObjectsData.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        NonFieldObjectsData.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("NonFieldObjectsData(");
        boolean bl = true;
        stringBuilder.append("objects:");
        if (this.objects == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.objects);
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
        enumMap.put(_Fields.OBJECTS, new FieldMetaData("objects", 3, (FieldValueMetaData)new MapMetaData(13, new FieldValueMetaData(8), (FieldValueMetaData)new StructMetaData(12, NonFieldObjectData.class))));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(NonFieldObjectsData.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        OBJECTS(1, "objects");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return OBJECTS;
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

    private static class NonFieldObjectsDataStandardSchemeFactory
    implements SchemeFactory {
        private NonFieldObjectsDataStandardSchemeFactory() {
        }

        public NonFieldObjectsDataStandardScheme getScheme() {
            return new NonFieldObjectsDataStandardScheme();
        }
    }

    private static class NonFieldObjectsDataTupleSchemeFactory
    implements SchemeFactory {
        private NonFieldObjectsDataTupleSchemeFactory() {
        }

        public NonFieldObjectsDataTupleScheme getScheme() {
            return new NonFieldObjectsDataTupleScheme();
        }
    }

    private static class NonFieldObjectsDataTupleScheme
    extends TupleScheme<NonFieldObjectsData> {
        private NonFieldObjectsDataTupleScheme() {
        }

        public void write(TProtocol tProtocol, NonFieldObjectsData nonFieldObjectsData) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (nonFieldObjectsData.isSetObjects()) {
                bitSet.set(0);
            }
            tTupleProtocol.writeBitSet(bitSet, 1);
            if (nonFieldObjectsData.isSetObjects()) {
                tTupleProtocol.writeI32(nonFieldObjectsData.objects.size());
                for (Map.Entry<Integer, NonFieldObjectData> entry : nonFieldObjectsData.objects.entrySet()) {
                    tTupleProtocol.writeI32(entry.getKey().intValue());
                    entry.getValue().write((TProtocol)tTupleProtocol);
                }
            }
        }

        public void read(TProtocol tProtocol, NonFieldObjectsData nonFieldObjectsData) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(1);
            if (bitSet.get(0)) {
                TMap tMap = tTupleProtocol.readMapBegin((byte)8, (byte)12);
                nonFieldObjectsData.objects = new HashMap<Integer, NonFieldObjectData>(2 * tMap.size);
                for (int i = 0; i < tMap.size; ++i) {
                    int n = tTupleProtocol.readI32();
                    NonFieldObjectData nonFieldObjectData = new NonFieldObjectData();
                    nonFieldObjectData.read((TProtocol)tTupleProtocol);
                    nonFieldObjectsData.objects.put(n, nonFieldObjectData);
                }
                nonFieldObjectsData.setObjectsIsSet(true);
            }
        }
    }

    private static class NonFieldObjectsDataStandardScheme
    extends StandardScheme<NonFieldObjectsData> {
        private NonFieldObjectsDataStandardScheme() {
        }

        public void read(TProtocol tProtocol, NonFieldObjectsData nonFieldObjectsData) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 13) {
                            TMap tMap = tProtocol.readMapBegin();
                            nonFieldObjectsData.objects = new HashMap<Integer, NonFieldObjectData>(2 * tMap.size);
                            for (int i = 0; i < tMap.size; ++i) {
                                int n = tProtocol.readI32();
                                NonFieldObjectData nonFieldObjectData = new NonFieldObjectData();
                                nonFieldObjectData.read(tProtocol);
                                nonFieldObjectsData.objects.put(n, nonFieldObjectData);
                            }
                            tProtocol.readMapEnd();
                            nonFieldObjectsData.setObjectsIsSet(true);
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
            nonFieldObjectsData.validate();
        }

        public void write(TProtocol tProtocol, NonFieldObjectsData nonFieldObjectsData) throws TException {
            nonFieldObjectsData.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (nonFieldObjectsData.objects != null) {
                tProtocol.writeFieldBegin(OBJECTS_FIELD_DESC);
                tProtocol.writeMapBegin(new TMap(8, 12, nonFieldObjectsData.objects.size()));
                for (Map.Entry<Integer, NonFieldObjectData> entry : nonFieldObjectsData.objects.entrySet()) {
                    tProtocol.writeI32(entry.getKey().intValue());
                    entry.getValue().write(tProtocol);
                }
                tProtocol.writeMapEnd();
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

