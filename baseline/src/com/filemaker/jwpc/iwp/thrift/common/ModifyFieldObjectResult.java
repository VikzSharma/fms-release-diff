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
 *  org.apache.thrift.meta_data.StructMetaData
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
package com.filemaker.jwpc.iwp.thrift.common;

import com.filemaker.jwpc.iwp.thrift.common.Result;
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
import org.apache.thrift.meta_data.StructMetaData;
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

public class ModifyFieldObjectResult
implements TBase<ModifyFieldObjectResult, _Fields>,
Serializable,
Cloneable,
Comparable<ModifyFieldObjectResult> {
    private static final TStruct STRUCT_DESC = new TStruct("ModifyFieldObjectResult");
    private static final TField RESULT_FIELD_DESC = new TField("result", 12, 1);
    private static final TField ORIGINAL_VALUE_FIELD_DESC = new TField("originalValue", 11, 2);
    private static final TField VALID_ORIGINAL_VALUE_FIELD_DESC = new TField("validOriginalValue", 2, 3);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new ModifyFieldObjectResultStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new ModifyFieldObjectResultTupleSchemeFactory();
    @Nullable
    private Result result;
    @Nullable
    private String originalValue;
    private boolean validOriginalValue;
    private static final int __VALIDORIGINALVALUE_ISSET_ID = 0;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public ModifyFieldObjectResult() {
    }

    public ModifyFieldObjectResult(Result result, String string, boolean bl) {
        this();
        this.result = result;
        this.originalValue = string;
        this.validOriginalValue = bl;
        this.setValidOriginalValueIsSet(true);
    }

    public ModifyFieldObjectResult(ModifyFieldObjectResult modifyFieldObjectResult) {
        this.__isset_bitfield = modifyFieldObjectResult.__isset_bitfield;
        if (modifyFieldObjectResult.isSetResult()) {
            this.result = new Result(modifyFieldObjectResult.result);
        }
        if (modifyFieldObjectResult.isSetOriginalValue()) {
            this.originalValue = modifyFieldObjectResult.originalValue;
        }
        this.validOriginalValue = modifyFieldObjectResult.validOriginalValue;
    }

    public ModifyFieldObjectResult deepCopy() {
        return new ModifyFieldObjectResult(this);
    }

    public void clear() {
        this.result = null;
        this.originalValue = null;
        this.setValidOriginalValueIsSet(false);
        this.validOriginalValue = false;
    }

    @Nullable
    public Result getResult() {
        return this.result;
    }

    public void setResult(@Nullable Result result) {
        this.result = result;
    }

    public void unsetResult() {
        this.result = null;
    }

    public boolean isSetResult() {
        return this.result != null;
    }

    public void setResultIsSet(boolean bl) {
        if (!bl) {
            this.result = null;
        }
    }

    @Nullable
    public String getOriginalValue() {
        return this.originalValue;
    }

    public void setOriginalValue(@Nullable String string) {
        this.originalValue = string;
    }

    public void unsetOriginalValue() {
        this.originalValue = null;
    }

    public boolean isSetOriginalValue() {
        return this.originalValue != null;
    }

    public void setOriginalValueIsSet(boolean bl) {
        if (!bl) {
            this.originalValue = null;
        }
    }

    public boolean isValidOriginalValue() {
        return this.validOriginalValue;
    }

    public void setValidOriginalValue(boolean bl) {
        this.validOriginalValue = bl;
        this.setValidOriginalValueIsSet(true);
    }

    public void unsetValidOriginalValue() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetValidOriginalValue() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setValidOriginalValueIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetResult();
                    break;
                }
                this.setResult((Result)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetOriginalValue();
                    break;
                }
                this.setOriginalValue((String)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetValidOriginalValue();
                    break;
                }
                this.setValidOriginalValue((Boolean)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getResult();
            }
            case 1: {
                return this.getOriginalValue();
            }
            case 2: {
                return this.isValidOriginalValue();
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
                return this.isSetResult();
            }
            case 1: {
                return this.isSetOriginalValue();
            }
            case 2: {
                return this.isSetValidOriginalValue();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof ModifyFieldObjectResult) {
            return this.equals((ModifyFieldObjectResult)object);
        }
        return false;
    }

    public boolean equals(ModifyFieldObjectResult modifyFieldObjectResult) {
        if (modifyFieldObjectResult == null) {
            return false;
        }
        if (this == modifyFieldObjectResult) {
            return true;
        }
        boolean bl = this.isSetResult();
        boolean bl2 = modifyFieldObjectResult.isSetResult();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.result.equals(modifyFieldObjectResult.result)) {
                return false;
            }
        }
        boolean bl3 = this.isSetOriginalValue();
        boolean bl4 = modifyFieldObjectResult.isSetOriginalValue();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.originalValue.equals(modifyFieldObjectResult.originalValue)) {
                return false;
            }
        }
        boolean bl5 = true;
        boolean bl6 = true;
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (this.validOriginalValue != modifyFieldObjectResult.validOriginalValue) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetResult() ? 131071 : 524287);
        if (this.isSetResult()) {
            n = n * 8191 + this.result.hashCode();
        }
        n = n * 8191 + (this.isSetOriginalValue() ? 131071 : 524287);
        if (this.isSetOriginalValue()) {
            n = n * 8191 + this.originalValue.hashCode();
        }
        n = n * 8191 + (this.validOriginalValue ? 131071 : 524287);
        return n;
    }

    @Override
    public int compareTo(ModifyFieldObjectResult modifyFieldObjectResult) {
        if (!this.getClass().equals(modifyFieldObjectResult.getClass())) {
            return this.getClass().getName().compareTo(modifyFieldObjectResult.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetResult(), modifyFieldObjectResult.isSetResult());
        if (n != 0) {
            return n;
        }
        if (this.isSetResult() && (n = TBaseHelper.compareTo((Comparable)this.result, (Comparable)modifyFieldObjectResult.result)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetOriginalValue(), modifyFieldObjectResult.isSetOriginalValue());
        if (n != 0) {
            return n;
        }
        if (this.isSetOriginalValue() && (n = TBaseHelper.compareTo((String)this.originalValue, (String)modifyFieldObjectResult.originalValue)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetValidOriginalValue(), modifyFieldObjectResult.isSetValidOriginalValue());
        if (n != 0) {
            return n;
        }
        if (this.isSetValidOriginalValue() && (n = TBaseHelper.compareTo((boolean)this.validOriginalValue, (boolean)modifyFieldObjectResult.validOriginalValue)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        ModifyFieldObjectResult.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        ModifyFieldObjectResult.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ModifyFieldObjectResult(");
        boolean bl = true;
        stringBuilder.append("result:");
        if (this.result == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.result);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("originalValue:");
        if (this.originalValue == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.originalValue);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("validOriginalValue:");
        stringBuilder.append(this.validOriginalValue);
        bl = false;
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void validate() throws TException {
        if (this.result != null) {
            this.result.validate();
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
        enumMap.put(_Fields.RESULT, new FieldMetaData("result", 3, (FieldValueMetaData)new StructMetaData(12, Result.class)));
        enumMap.put(_Fields.ORIGINAL_VALUE, new FieldMetaData("originalValue", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.VALID_ORIGINAL_VALUE, new FieldMetaData("validOriginalValue", 3, new FieldValueMetaData(2)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(ModifyFieldObjectResult.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        RESULT(1, "result"),
        ORIGINAL_VALUE(2, "originalValue"),
        VALID_ORIGINAL_VALUE(3, "validOriginalValue");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return RESULT;
                }
                case 2: {
                    return ORIGINAL_VALUE;
                }
                case 3: {
                    return VALID_ORIGINAL_VALUE;
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

    private static class ModifyFieldObjectResultStandardSchemeFactory
    implements SchemeFactory {
        private ModifyFieldObjectResultStandardSchemeFactory() {
        }

        public ModifyFieldObjectResultStandardScheme getScheme() {
            return new ModifyFieldObjectResultStandardScheme();
        }
    }

    private static class ModifyFieldObjectResultTupleSchemeFactory
    implements SchemeFactory {
        private ModifyFieldObjectResultTupleSchemeFactory() {
        }

        public ModifyFieldObjectResultTupleScheme getScheme() {
            return new ModifyFieldObjectResultTupleScheme();
        }
    }

    private static class ModifyFieldObjectResultTupleScheme
    extends TupleScheme<ModifyFieldObjectResult> {
        private ModifyFieldObjectResultTupleScheme() {
        }

        public void write(TProtocol tProtocol, ModifyFieldObjectResult modifyFieldObjectResult) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (modifyFieldObjectResult.isSetResult()) {
                bitSet.set(0);
            }
            if (modifyFieldObjectResult.isSetOriginalValue()) {
                bitSet.set(1);
            }
            if (modifyFieldObjectResult.isSetValidOriginalValue()) {
                bitSet.set(2);
            }
            tTupleProtocol.writeBitSet(bitSet, 3);
            if (modifyFieldObjectResult.isSetResult()) {
                modifyFieldObjectResult.result.write((TProtocol)tTupleProtocol);
            }
            if (modifyFieldObjectResult.isSetOriginalValue()) {
                tTupleProtocol.writeString(modifyFieldObjectResult.originalValue);
            }
            if (modifyFieldObjectResult.isSetValidOriginalValue()) {
                tTupleProtocol.writeBool(modifyFieldObjectResult.validOriginalValue);
            }
        }

        public void read(TProtocol tProtocol, ModifyFieldObjectResult modifyFieldObjectResult) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(3);
            if (bitSet.get(0)) {
                modifyFieldObjectResult.result = new Result();
                modifyFieldObjectResult.result.read((TProtocol)tTupleProtocol);
                modifyFieldObjectResult.setResultIsSet(true);
            }
            if (bitSet.get(1)) {
                modifyFieldObjectResult.originalValue = tTupleProtocol.readString();
                modifyFieldObjectResult.setOriginalValueIsSet(true);
            }
            if (bitSet.get(2)) {
                modifyFieldObjectResult.validOriginalValue = tTupleProtocol.readBool();
                modifyFieldObjectResult.setValidOriginalValueIsSet(true);
            }
        }
    }

    private static class ModifyFieldObjectResultStandardScheme
    extends StandardScheme<ModifyFieldObjectResult> {
        private ModifyFieldObjectResultStandardScheme() {
        }

        public void read(TProtocol tProtocol, ModifyFieldObjectResult modifyFieldObjectResult) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 12) {
                            modifyFieldObjectResult.result = new Result();
                            modifyFieldObjectResult.result.read(tProtocol);
                            modifyFieldObjectResult.setResultIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 11) {
                            modifyFieldObjectResult.originalValue = tProtocol.readString();
                            modifyFieldObjectResult.setOriginalValueIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 2) {
                            modifyFieldObjectResult.validOriginalValue = tProtocol.readBool();
                            modifyFieldObjectResult.setValidOriginalValueIsSet(true);
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
            modifyFieldObjectResult.validate();
        }

        public void write(TProtocol tProtocol, ModifyFieldObjectResult modifyFieldObjectResult) throws TException {
            modifyFieldObjectResult.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (modifyFieldObjectResult.result != null) {
                tProtocol.writeFieldBegin(RESULT_FIELD_DESC);
                modifyFieldObjectResult.result.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            if (modifyFieldObjectResult.originalValue != null) {
                tProtocol.writeFieldBegin(ORIGINAL_VALUE_FIELD_DESC);
                tProtocol.writeString(modifyFieldObjectResult.originalValue);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(VALID_ORIGINAL_VALUE_FIELD_DESC);
            tProtocol.writeBool(modifyFieldObjectResult.validOriginalValue);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

