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
 *  org.apache.thrift.protocol.TCompactProtocol
 *  org.apache.thrift.protocol.TField
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
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TField;
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

public class NVPair
implements TBase<NVPair, _Fields>,
Serializable,
Cloneable,
Comparable<NVPair> {
    private static final TStruct STRUCT_DESC = new TStruct("NVPair");
    private static final TField KEY_FIELD_DESC = new TField("key", 11, 1);
    private static final TField VALUE_FIELD_DESC = new TField("value", 11, 2);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new NVPairStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new NVPairTupleSchemeFactory();
    @Nullable
    private String key;
    @Nullable
    private String value;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public NVPair() {
    }

    public NVPair(String string, String string2) {
        this();
        this.key = string;
        this.value = string2;
    }

    public NVPair(NVPair nVPair) {
        if (nVPair.isSetKey()) {
            this.key = nVPair.key;
        }
        if (nVPair.isSetValue()) {
            this.value = nVPair.value;
        }
    }

    public NVPair deepCopy() {
        return new NVPair(this);
    }

    public void clear() {
        this.key = null;
        this.value = null;
    }

    @Nullable
    public String getKey() {
        return this.key;
    }

    public void setKey(@Nullable String string) {
        this.key = string;
    }

    public void unsetKey() {
        this.key = null;
    }

    public boolean isSetKey() {
        return this.key != null;
    }

    public void setKeyIsSet(boolean bl) {
        if (!bl) {
            this.key = null;
        }
    }

    @Nullable
    public String getValue() {
        return this.value;
    }

    public void setValue(@Nullable String string) {
        this.value = string;
    }

    public void unsetValue() {
        this.value = null;
    }

    public boolean isSetValue() {
        return this.value != null;
    }

    public void setValueIsSet(boolean bl) {
        if (!bl) {
            this.value = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetKey();
                    break;
                }
                this.setKey((String)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetValue();
                    break;
                }
                this.setValue((String)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getKey();
            }
            case 1: {
                return this.getValue();
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
                return this.isSetKey();
            }
            case 1: {
                return this.isSetValue();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof NVPair) {
            return this.equals((NVPair)object);
        }
        return false;
    }

    public boolean equals(NVPair nVPair) {
        if (nVPair == null) {
            return false;
        }
        if (this == nVPair) {
            return true;
        }
        boolean bl = this.isSetKey();
        boolean bl2 = nVPair.isSetKey();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.key.equals(nVPair.key)) {
                return false;
            }
        }
        boolean bl3 = this.isSetValue();
        boolean bl4 = nVPair.isSetValue();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.value.equals(nVPair.value)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetKey() ? 131071 : 524287);
        if (this.isSetKey()) {
            n = n * 8191 + this.key.hashCode();
        }
        n = n * 8191 + (this.isSetValue() ? 131071 : 524287);
        if (this.isSetValue()) {
            n = n * 8191 + this.value.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(NVPair nVPair) {
        if (!this.getClass().equals(nVPair.getClass())) {
            return this.getClass().getName().compareTo(nVPair.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetKey(), nVPair.isSetKey());
        if (n != 0) {
            return n;
        }
        if (this.isSetKey() && (n = TBaseHelper.compareTo((String)this.key, (String)nVPair.key)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetValue(), nVPair.isSetValue());
        if (n != 0) {
            return n;
        }
        if (this.isSetValue() && (n = TBaseHelper.compareTo((String)this.value, (String)nVPair.value)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        NVPair.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        NVPair.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("NVPair(");
        boolean bl = true;
        stringBuilder.append("key:");
        if (this.key == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.key);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("value:");
        if (this.value == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.value);
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
        enumMap.put(_Fields.KEY, new FieldMetaData("key", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.VALUE, new FieldMetaData("value", 3, new FieldValueMetaData(11)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(NVPair.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        KEY(1, "key"),
        VALUE(2, "value");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return KEY;
                }
                case 2: {
                    return VALUE;
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

    private static class NVPairStandardSchemeFactory
    implements SchemeFactory {
        private NVPairStandardSchemeFactory() {
        }

        public NVPairStandardScheme getScheme() {
            return new NVPairStandardScheme();
        }
    }

    private static class NVPairTupleSchemeFactory
    implements SchemeFactory {
        private NVPairTupleSchemeFactory() {
        }

        public NVPairTupleScheme getScheme() {
            return new NVPairTupleScheme();
        }
    }

    private static class NVPairTupleScheme
    extends TupleScheme<NVPair> {
        private NVPairTupleScheme() {
        }

        public void write(TProtocol tProtocol, NVPair nVPair) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (nVPair.isSetKey()) {
                bitSet.set(0);
            }
            if (nVPair.isSetValue()) {
                bitSet.set(1);
            }
            tTupleProtocol.writeBitSet(bitSet, 2);
            if (nVPair.isSetKey()) {
                tTupleProtocol.writeString(nVPair.key);
            }
            if (nVPair.isSetValue()) {
                tTupleProtocol.writeString(nVPair.value);
            }
        }

        public void read(TProtocol tProtocol, NVPair nVPair) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(2);
            if (bitSet.get(0)) {
                nVPair.key = tTupleProtocol.readString();
                nVPair.setKeyIsSet(true);
            }
            if (bitSet.get(1)) {
                nVPair.value = tTupleProtocol.readString();
                nVPair.setValueIsSet(true);
            }
        }
    }

    private static class NVPairStandardScheme
    extends StandardScheme<NVPair> {
        private NVPairStandardScheme() {
        }

        public void read(TProtocol tProtocol, NVPair nVPair) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 11) {
                            nVPair.key = tProtocol.readString();
                            nVPair.setKeyIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 11) {
                            nVPair.value = tProtocol.readString();
                            nVPair.setValueIsSet(true);
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
            nVPair.validate();
        }

        public void write(TProtocol tProtocol, NVPair nVPair) throws TException {
            nVPair.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (nVPair.key != null) {
                tProtocol.writeFieldBegin(KEY_FIELD_DESC);
                tProtocol.writeString(nVPair.key);
                tProtocol.writeFieldEnd();
            }
            if (nVPair.value != null) {
                tProtocol.writeFieldBegin(VALUE_FIELD_DESC);
                tProtocol.writeString(nVPair.value);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

