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
import org.apache.thrift.EncodingUtils;
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

public class IDLFieldParam
implements TBase<IDLFieldParam, _Fields>,
Serializable,
Cloneable,
Comparable<IDLFieldParam> {
    private static final TStruct STRUCT_DESC = new TStruct("IDLFieldParam");
    private static final TField NAME_FIELD_DESC = new TField("name", 11, 1);
    private static final TField VALUE_FIELD_DESC = new TField("value", 11, 2);
    private static final TField REPETITION_FIELD_DESC = new TField("repetition", 6, 3);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new IDLFieldParamStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new IDLFieldParamTupleSchemeFactory();
    @Nullable
    private String name;
    @Nullable
    private String value;
    private short repetition;
    private static final int __REPETITION_ISSET_ID = 0;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public IDLFieldParam() {
    }

    public IDLFieldParam(String string, String string2, short s) {
        this();
        this.name = string;
        this.value = string2;
        this.repetition = s;
        this.setRepetitionIsSet(true);
    }

    public IDLFieldParam(IDLFieldParam iDLFieldParam) {
        this.__isset_bitfield = iDLFieldParam.__isset_bitfield;
        if (iDLFieldParam.isSetName()) {
            this.name = iDLFieldParam.name;
        }
        if (iDLFieldParam.isSetValue()) {
            this.value = iDLFieldParam.value;
        }
        this.repetition = iDLFieldParam.repetition;
    }

    public IDLFieldParam deepCopy() {
        return new IDLFieldParam(this);
    }

    public void clear() {
        this.name = null;
        this.value = null;
        this.setRepetitionIsSet(false);
        this.repetition = 0;
    }

    @Nullable
    public String getName() {
        return this.name;
    }

    public void setName(@Nullable String string) {
        this.name = string;
    }

    public void unsetName() {
        this.name = null;
    }

    public boolean isSetName() {
        return this.name != null;
    }

    public void setNameIsSet(boolean bl) {
        if (!bl) {
            this.name = null;
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

    public short getRepetition() {
        return this.repetition;
    }

    public void setRepetition(short s) {
        this.repetition = s;
        this.setRepetitionIsSet(true);
    }

    public void unsetRepetition() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetRepetition() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setRepetitionIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetName();
                    break;
                }
                this.setName((String)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetValue();
                    break;
                }
                this.setValue((String)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetRepetition();
                    break;
                }
                this.setRepetition((Short)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getName();
            }
            case 1: {
                return this.getValue();
            }
            case 2: {
                return this.getRepetition();
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
                return this.isSetName();
            }
            case 1: {
                return this.isSetValue();
            }
            case 2: {
                return this.isSetRepetition();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof IDLFieldParam) {
            return this.equals((IDLFieldParam)object);
        }
        return false;
    }

    public boolean equals(IDLFieldParam iDLFieldParam) {
        if (iDLFieldParam == null) {
            return false;
        }
        if (this == iDLFieldParam) {
            return true;
        }
        boolean bl = this.isSetName();
        boolean bl2 = iDLFieldParam.isSetName();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.name.equals(iDLFieldParam.name)) {
                return false;
            }
        }
        boolean bl3 = this.isSetValue();
        boolean bl4 = iDLFieldParam.isSetValue();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.value.equals(iDLFieldParam.value)) {
                return false;
            }
        }
        boolean bl5 = true;
        boolean bl6 = true;
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (this.repetition != iDLFieldParam.repetition) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetName() ? 131071 : 524287);
        if (this.isSetName()) {
            n = n * 8191 + this.name.hashCode();
        }
        n = n * 8191 + (this.isSetValue() ? 131071 : 524287);
        if (this.isSetValue()) {
            n = n * 8191 + this.value.hashCode();
        }
        n = n * 8191 + this.repetition;
        return n;
    }

    @Override
    public int compareTo(IDLFieldParam iDLFieldParam) {
        if (!this.getClass().equals(iDLFieldParam.getClass())) {
            return this.getClass().getName().compareTo(iDLFieldParam.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetName(), iDLFieldParam.isSetName());
        if (n != 0) {
            return n;
        }
        if (this.isSetName() && (n = TBaseHelper.compareTo((String)this.name, (String)iDLFieldParam.name)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetValue(), iDLFieldParam.isSetValue());
        if (n != 0) {
            return n;
        }
        if (this.isSetValue() && (n = TBaseHelper.compareTo((String)this.value, (String)iDLFieldParam.value)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetRepetition(), iDLFieldParam.isSetRepetition());
        if (n != 0) {
            return n;
        }
        if (this.isSetRepetition() && (n = TBaseHelper.compareTo((short)this.repetition, (short)iDLFieldParam.repetition)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        IDLFieldParam.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        IDLFieldParam.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("IDLFieldParam(");
        boolean bl = true;
        stringBuilder.append("name:");
        if (this.name == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.name);
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
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("repetition:");
        stringBuilder.append(this.repetition);
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
        enumMap.put(_Fields.NAME, new FieldMetaData("name", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.VALUE, new FieldMetaData("value", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.REPETITION, new FieldMetaData("repetition", 3, new FieldValueMetaData(6)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(IDLFieldParam.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        NAME(1, "name"),
        VALUE(2, "value"),
        REPETITION(3, "repetition");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return NAME;
                }
                case 2: {
                    return VALUE;
                }
                case 3: {
                    return REPETITION;
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

    private static class IDLFieldParamStandardSchemeFactory
    implements SchemeFactory {
        private IDLFieldParamStandardSchemeFactory() {
        }

        public IDLFieldParamStandardScheme getScheme() {
            return new IDLFieldParamStandardScheme();
        }
    }

    private static class IDLFieldParamTupleSchemeFactory
    implements SchemeFactory {
        private IDLFieldParamTupleSchemeFactory() {
        }

        public IDLFieldParamTupleScheme getScheme() {
            return new IDLFieldParamTupleScheme();
        }
    }

    private static class IDLFieldParamTupleScheme
    extends TupleScheme<IDLFieldParam> {
        private IDLFieldParamTupleScheme() {
        }

        public void write(TProtocol tProtocol, IDLFieldParam iDLFieldParam) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (iDLFieldParam.isSetName()) {
                bitSet.set(0);
            }
            if (iDLFieldParam.isSetValue()) {
                bitSet.set(1);
            }
            if (iDLFieldParam.isSetRepetition()) {
                bitSet.set(2);
            }
            tTupleProtocol.writeBitSet(bitSet, 3);
            if (iDLFieldParam.isSetName()) {
                tTupleProtocol.writeString(iDLFieldParam.name);
            }
            if (iDLFieldParam.isSetValue()) {
                tTupleProtocol.writeString(iDLFieldParam.value);
            }
            if (iDLFieldParam.isSetRepetition()) {
                tTupleProtocol.writeI16(iDLFieldParam.repetition);
            }
        }

        public void read(TProtocol tProtocol, IDLFieldParam iDLFieldParam) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(3);
            if (bitSet.get(0)) {
                iDLFieldParam.name = tTupleProtocol.readString();
                iDLFieldParam.setNameIsSet(true);
            }
            if (bitSet.get(1)) {
                iDLFieldParam.value = tTupleProtocol.readString();
                iDLFieldParam.setValueIsSet(true);
            }
            if (bitSet.get(2)) {
                iDLFieldParam.repetition = tTupleProtocol.readI16();
                iDLFieldParam.setRepetitionIsSet(true);
            }
        }
    }

    private static class IDLFieldParamStandardScheme
    extends StandardScheme<IDLFieldParam> {
        private IDLFieldParamStandardScheme() {
        }

        public void read(TProtocol tProtocol, IDLFieldParam iDLFieldParam) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 11) {
                            iDLFieldParam.name = tProtocol.readString();
                            iDLFieldParam.setNameIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 11) {
                            iDLFieldParam.value = tProtocol.readString();
                            iDLFieldParam.setValueIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 6) {
                            iDLFieldParam.repetition = tProtocol.readI16();
                            iDLFieldParam.setRepetitionIsSet(true);
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
            iDLFieldParam.validate();
        }

        public void write(TProtocol tProtocol, IDLFieldParam iDLFieldParam) throws TException {
            iDLFieldParam.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (iDLFieldParam.name != null) {
                tProtocol.writeFieldBegin(NAME_FIELD_DESC);
                tProtocol.writeString(iDLFieldParam.name);
                tProtocol.writeFieldEnd();
            }
            if (iDLFieldParam.value != null) {
                tProtocol.writeFieldBegin(VALUE_FIELD_DESC);
                tProtocol.writeString(iDLFieldParam.value);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(REPETITION_FIELD_DESC);
            tProtocol.writeI16(iDLFieldParam.repetition);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

