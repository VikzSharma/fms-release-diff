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
 *  org.apache.thrift.meta_data.MapMetaData
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
package com.filemaker.jwpc.iwp.thrift.common;

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
import org.apache.thrift.meta_data.MapMetaData;
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

public class CustomDialogResult
implements TBase<CustomDialogResult, _Fields>,
Serializable,
Cloneable,
Comparable<CustomDialogResult> {
    private static final TStruct STRUCT_DESC = new TStruct("CustomDialogResult");
    private static final TField UPDATED_FIELDS_FIELD_DESC = new TField("updatedFields", 13, 1);
    private static final TField BUTTON_IDX_FIELD_DESC = new TField("buttonIdx", 6, 2);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new CustomDialogResultStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new CustomDialogResultTupleSchemeFactory();
    @Nullable
    private Map<Integer, String> updatedFields;
    private short buttonIdx;
    private static final int __BUTTONIDX_ISSET_ID = 0;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public CustomDialogResult() {
    }

    public CustomDialogResult(Map<Integer, String> map, short s) {
        this();
        this.updatedFields = map;
        this.buttonIdx = s;
        this.setButtonIdxIsSet(true);
    }

    public CustomDialogResult(CustomDialogResult customDialogResult) {
        this.__isset_bitfield = customDialogResult.__isset_bitfield;
        if (customDialogResult.isSetUpdatedFields()) {
            HashMap<Integer, String> hashMap = new HashMap<Integer, String>(customDialogResult.updatedFields);
            this.updatedFields = hashMap;
        }
        this.buttonIdx = customDialogResult.buttonIdx;
    }

    public CustomDialogResult deepCopy() {
        return new CustomDialogResult(this);
    }

    public void clear() {
        this.updatedFields = null;
        this.setButtonIdxIsSet(false);
        this.buttonIdx = 0;
    }

    public int getUpdatedFieldsSize() {
        return this.updatedFields == null ? 0 : this.updatedFields.size();
    }

    public void putToUpdatedFields(int n, String string) {
        if (this.updatedFields == null) {
            this.updatedFields = new HashMap<Integer, String>();
        }
        this.updatedFields.put(n, string);
    }

    @Nullable
    public Map<Integer, String> getUpdatedFields() {
        return this.updatedFields;
    }

    public void setUpdatedFields(@Nullable Map<Integer, String> map) {
        this.updatedFields = map;
    }

    public void unsetUpdatedFields() {
        this.updatedFields = null;
    }

    public boolean isSetUpdatedFields() {
        return this.updatedFields != null;
    }

    public void setUpdatedFieldsIsSet(boolean bl) {
        if (!bl) {
            this.updatedFields = null;
        }
    }

    public short getButtonIdx() {
        return this.buttonIdx;
    }

    public void setButtonIdx(short s) {
        this.buttonIdx = s;
        this.setButtonIdxIsSet(true);
    }

    public void unsetButtonIdx() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetButtonIdx() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setButtonIdxIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetUpdatedFields();
                    break;
                }
                this.setUpdatedFields((Map)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetButtonIdx();
                    break;
                }
                this.setButtonIdx((Short)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getUpdatedFields();
            }
            case 1: {
                return this.getButtonIdx();
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
                return this.isSetUpdatedFields();
            }
            case 1: {
                return this.isSetButtonIdx();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof CustomDialogResult) {
            return this.equals((CustomDialogResult)object);
        }
        return false;
    }

    public boolean equals(CustomDialogResult customDialogResult) {
        if (customDialogResult == null) {
            return false;
        }
        if (this == customDialogResult) {
            return true;
        }
        boolean bl = this.isSetUpdatedFields();
        boolean bl2 = customDialogResult.isSetUpdatedFields();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.updatedFields.equals(customDialogResult.updatedFields)) {
                return false;
            }
        }
        boolean bl3 = true;
        boolean bl4 = true;
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (this.buttonIdx != customDialogResult.buttonIdx) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetUpdatedFields() ? 131071 : 524287);
        if (this.isSetUpdatedFields()) {
            n = n * 8191 + this.updatedFields.hashCode();
        }
        n = n * 8191 + this.buttonIdx;
        return n;
    }

    @Override
    public int compareTo(CustomDialogResult customDialogResult) {
        if (!this.getClass().equals(customDialogResult.getClass())) {
            return this.getClass().getName().compareTo(customDialogResult.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetUpdatedFields(), customDialogResult.isSetUpdatedFields());
        if (n != 0) {
            return n;
        }
        if (this.isSetUpdatedFields() && (n = TBaseHelper.compareTo(this.updatedFields, customDialogResult.updatedFields)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetButtonIdx(), customDialogResult.isSetButtonIdx());
        if (n != 0) {
            return n;
        }
        if (this.isSetButtonIdx() && (n = TBaseHelper.compareTo((short)this.buttonIdx, (short)customDialogResult.buttonIdx)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        CustomDialogResult.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        CustomDialogResult.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("CustomDialogResult(");
        boolean bl = true;
        stringBuilder.append("updatedFields:");
        if (this.updatedFields == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.updatedFields);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("buttonIdx:");
        stringBuilder.append(this.buttonIdx);
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
        enumMap.put(_Fields.UPDATED_FIELDS, new FieldMetaData("updatedFields", 3, (FieldValueMetaData)new MapMetaData(13, new FieldValueMetaData(8), new FieldValueMetaData(11))));
        enumMap.put(_Fields.BUTTON_IDX, new FieldMetaData("buttonIdx", 3, new FieldValueMetaData(6)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(CustomDialogResult.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        UPDATED_FIELDS(1, "updatedFields"),
        BUTTON_IDX(2, "buttonIdx");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return UPDATED_FIELDS;
                }
                case 2: {
                    return BUTTON_IDX;
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

    private static class CustomDialogResultStandardSchemeFactory
    implements SchemeFactory {
        private CustomDialogResultStandardSchemeFactory() {
        }

        public CustomDialogResultStandardScheme getScheme() {
            return new CustomDialogResultStandardScheme();
        }
    }

    private static class CustomDialogResultTupleSchemeFactory
    implements SchemeFactory {
        private CustomDialogResultTupleSchemeFactory() {
        }

        public CustomDialogResultTupleScheme getScheme() {
            return new CustomDialogResultTupleScheme();
        }
    }

    private static class CustomDialogResultTupleScheme
    extends TupleScheme<CustomDialogResult> {
        private CustomDialogResultTupleScheme() {
        }

        public void write(TProtocol tProtocol, CustomDialogResult customDialogResult) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (customDialogResult.isSetUpdatedFields()) {
                bitSet.set(0);
            }
            if (customDialogResult.isSetButtonIdx()) {
                bitSet.set(1);
            }
            tTupleProtocol.writeBitSet(bitSet, 2);
            if (customDialogResult.isSetUpdatedFields()) {
                tTupleProtocol.writeI32(customDialogResult.updatedFields.size());
                for (Map.Entry<Integer, String> entry : customDialogResult.updatedFields.entrySet()) {
                    tTupleProtocol.writeI32(entry.getKey().intValue());
                    tTupleProtocol.writeString(entry.getValue());
                }
            }
            if (customDialogResult.isSetButtonIdx()) {
                tTupleProtocol.writeI16(customDialogResult.buttonIdx);
            }
        }

        public void read(TProtocol tProtocol, CustomDialogResult customDialogResult) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(2);
            if (bitSet.get(0)) {
                TMap tMap = tTupleProtocol.readMapBegin((byte)8, (byte)11);
                customDialogResult.updatedFields = new HashMap<Integer, String>(2 * tMap.size);
                for (int i = 0; i < tMap.size; ++i) {
                    int n = tTupleProtocol.readI32();
                    String string = tTupleProtocol.readString();
                    customDialogResult.updatedFields.put(n, string);
                }
                customDialogResult.setUpdatedFieldsIsSet(true);
            }
            if (bitSet.get(1)) {
                customDialogResult.buttonIdx = tTupleProtocol.readI16();
                customDialogResult.setButtonIdxIsSet(true);
            }
        }
    }

    private static class CustomDialogResultStandardScheme
    extends StandardScheme<CustomDialogResult> {
        private CustomDialogResultStandardScheme() {
        }

        public void read(TProtocol tProtocol, CustomDialogResult customDialogResult) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 13) {
                            TMap tMap = tProtocol.readMapBegin();
                            customDialogResult.updatedFields = new HashMap<Integer, String>(2 * tMap.size);
                            for (int i = 0; i < tMap.size; ++i) {
                                int n = tProtocol.readI32();
                                String string = tProtocol.readString();
                                customDialogResult.updatedFields.put(n, string);
                            }
                            tProtocol.readMapEnd();
                            customDialogResult.setUpdatedFieldsIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 6) {
                            customDialogResult.buttonIdx = tProtocol.readI16();
                            customDialogResult.setButtonIdxIsSet(true);
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
            customDialogResult.validate();
        }

        public void write(TProtocol tProtocol, CustomDialogResult customDialogResult) throws TException {
            customDialogResult.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (customDialogResult.updatedFields != null) {
                tProtocol.writeFieldBegin(UPDATED_FIELDS_FIELD_DESC);
                tProtocol.writeMapBegin(new TMap(8, 11, customDialogResult.updatedFields.size()));
                for (Map.Entry<Integer, String> entry : customDialogResult.updatedFields.entrySet()) {
                    tProtocol.writeI32(entry.getKey().intValue());
                    tProtocol.writeString(entry.getValue());
                }
                tProtocol.writeMapEnd();
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(BUTTON_IDX_FIELD_DESC);
            tProtocol.writeI16(customDialogResult.buttonIdx);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

