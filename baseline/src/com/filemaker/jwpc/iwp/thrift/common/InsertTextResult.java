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

public class InsertTextResult
implements TBase<InsertTextResult, _Fields>,
Serializable,
Cloneable,
Comparable<InsertTextResult> {
    private static final TStruct STRUCT_DESC = new TStruct("InsertTextResult");
    private static final TField RESULT_FIELD_DESC = new TField("result", 12, 1);
    private static final TField NEW_VALUE_FIELD_DESC = new TField("newValue", 11, 2);
    private static final TField VALID_NEW_VALUE_FIELD_DESC = new TField("validNewValue", 2, 3);
    private static final TField START_CURSOR_POSITION_FIELD_DESC = new TField("startCursorPosition", 8, 4);
    private static final TField END_CURSOR_POSITION_FIELD_DESC = new TField("endCursorPosition", 8, 5);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new InsertTextResultStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new InsertTextResultTupleSchemeFactory();
    @Nullable
    private Result result;
    @Nullable
    private String newValue;
    private boolean validNewValue;
    private int startCursorPosition;
    private int endCursorPosition;
    private static final int __VALIDNEWVALUE_ISSET_ID = 0;
    private static final int __STARTCURSORPOSITION_ISSET_ID = 1;
    private static final int __ENDCURSORPOSITION_ISSET_ID = 2;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public InsertTextResult() {
    }

    public InsertTextResult(Result result, String string, boolean bl, int n, int n2) {
        this();
        this.result = result;
        this.newValue = string;
        this.validNewValue = bl;
        this.setValidNewValueIsSet(true);
        this.startCursorPosition = n;
        this.setStartCursorPositionIsSet(true);
        this.endCursorPosition = n2;
        this.setEndCursorPositionIsSet(true);
    }

    public InsertTextResult(InsertTextResult insertTextResult) {
        this.__isset_bitfield = insertTextResult.__isset_bitfield;
        if (insertTextResult.isSetResult()) {
            this.result = new Result(insertTextResult.result);
        }
        if (insertTextResult.isSetNewValue()) {
            this.newValue = insertTextResult.newValue;
        }
        this.validNewValue = insertTextResult.validNewValue;
        this.startCursorPosition = insertTextResult.startCursorPosition;
        this.endCursorPosition = insertTextResult.endCursorPosition;
    }

    public InsertTextResult deepCopy() {
        return new InsertTextResult(this);
    }

    public void clear() {
        this.result = null;
        this.newValue = null;
        this.setValidNewValueIsSet(false);
        this.validNewValue = false;
        this.setStartCursorPositionIsSet(false);
        this.startCursorPosition = 0;
        this.setEndCursorPositionIsSet(false);
        this.endCursorPosition = 0;
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
    public String getNewValue() {
        return this.newValue;
    }

    public void setNewValue(@Nullable String string) {
        this.newValue = string;
    }

    public void unsetNewValue() {
        this.newValue = null;
    }

    public boolean isSetNewValue() {
        return this.newValue != null;
    }

    public void setNewValueIsSet(boolean bl) {
        if (!bl) {
            this.newValue = null;
        }
    }

    public boolean isValidNewValue() {
        return this.validNewValue;
    }

    public void setValidNewValue(boolean bl) {
        this.validNewValue = bl;
        this.setValidNewValueIsSet(true);
    }

    public void unsetValidNewValue() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetValidNewValue() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setValidNewValueIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public int getStartCursorPosition() {
        return this.startCursorPosition;
    }

    public void setStartCursorPosition(int n) {
        this.startCursorPosition = n;
        this.setStartCursorPositionIsSet(true);
    }

    public void unsetStartCursorPosition() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)1);
    }

    public boolean isSetStartCursorPosition() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)1);
    }

    public void setStartCursorPositionIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)1, (boolean)bl);
    }

    public int getEndCursorPosition() {
        return this.endCursorPosition;
    }

    public void setEndCursorPosition(int n) {
        this.endCursorPosition = n;
        this.setEndCursorPositionIsSet(true);
    }

    public void unsetEndCursorPosition() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)2);
    }

    public boolean isSetEndCursorPosition() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)2);
    }

    public void setEndCursorPositionIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)2, (boolean)bl);
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
                    this.unsetNewValue();
                    break;
                }
                this.setNewValue((String)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetValidNewValue();
                    break;
                }
                this.setValidNewValue((Boolean)object);
                break;
            }
            case 3: {
                if (object == null) {
                    this.unsetStartCursorPosition();
                    break;
                }
                this.setStartCursorPosition((Integer)object);
                break;
            }
            case 4: {
                if (object == null) {
                    this.unsetEndCursorPosition();
                    break;
                }
                this.setEndCursorPosition((Integer)object);
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
                return this.getNewValue();
            }
            case 2: {
                return this.isValidNewValue();
            }
            case 3: {
                return this.getStartCursorPosition();
            }
            case 4: {
                return this.getEndCursorPosition();
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
                return this.isSetNewValue();
            }
            case 2: {
                return this.isSetValidNewValue();
            }
            case 3: {
                return this.isSetStartCursorPosition();
            }
            case 4: {
                return this.isSetEndCursorPosition();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof InsertTextResult) {
            return this.equals((InsertTextResult)object);
        }
        return false;
    }

    public boolean equals(InsertTextResult insertTextResult) {
        if (insertTextResult == null) {
            return false;
        }
        if (this == insertTextResult) {
            return true;
        }
        boolean bl = this.isSetResult();
        boolean bl2 = insertTextResult.isSetResult();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.result.equals(insertTextResult.result)) {
                return false;
            }
        }
        boolean bl3 = this.isSetNewValue();
        boolean bl4 = insertTextResult.isSetNewValue();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.newValue.equals(insertTextResult.newValue)) {
                return false;
            }
        }
        boolean bl5 = true;
        boolean bl6 = true;
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (this.validNewValue != insertTextResult.validNewValue) {
                return false;
            }
        }
        boolean bl7 = true;
        boolean bl8 = true;
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (this.startCursorPosition != insertTextResult.startCursorPosition) {
                return false;
            }
        }
        boolean bl9 = true;
        boolean bl10 = true;
        if (bl9 || bl10) {
            if (!bl9 || !bl10) {
                return false;
            }
            if (this.endCursorPosition != insertTextResult.endCursorPosition) {
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
        n = n * 8191 + (this.isSetNewValue() ? 131071 : 524287);
        if (this.isSetNewValue()) {
            n = n * 8191 + this.newValue.hashCode();
        }
        n = n * 8191 + (this.validNewValue ? 131071 : 524287);
        n = n * 8191 + this.startCursorPosition;
        n = n * 8191 + this.endCursorPosition;
        return n;
    }

    @Override
    public int compareTo(InsertTextResult insertTextResult) {
        if (!this.getClass().equals(insertTextResult.getClass())) {
            return this.getClass().getName().compareTo(insertTextResult.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetResult(), insertTextResult.isSetResult());
        if (n != 0) {
            return n;
        }
        if (this.isSetResult() && (n = TBaseHelper.compareTo((Comparable)this.result, (Comparable)insertTextResult.result)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetNewValue(), insertTextResult.isSetNewValue());
        if (n != 0) {
            return n;
        }
        if (this.isSetNewValue() && (n = TBaseHelper.compareTo((String)this.newValue, (String)insertTextResult.newValue)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetValidNewValue(), insertTextResult.isSetValidNewValue());
        if (n != 0) {
            return n;
        }
        if (this.isSetValidNewValue() && (n = TBaseHelper.compareTo((boolean)this.validNewValue, (boolean)insertTextResult.validNewValue)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetStartCursorPosition(), insertTextResult.isSetStartCursorPosition());
        if (n != 0) {
            return n;
        }
        if (this.isSetStartCursorPosition() && (n = TBaseHelper.compareTo((int)this.startCursorPosition, (int)insertTextResult.startCursorPosition)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetEndCursorPosition(), insertTextResult.isSetEndCursorPosition());
        if (n != 0) {
            return n;
        }
        if (this.isSetEndCursorPosition() && (n = TBaseHelper.compareTo((int)this.endCursorPosition, (int)insertTextResult.endCursorPosition)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        InsertTextResult.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        InsertTextResult.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("InsertTextResult(");
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
        stringBuilder.append("newValue:");
        if (this.newValue == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.newValue);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("validNewValue:");
        stringBuilder.append(this.validNewValue);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("startCursorPosition:");
        stringBuilder.append(this.startCursorPosition);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("endCursorPosition:");
        stringBuilder.append(this.endCursorPosition);
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
        enumMap.put(_Fields.NEW_VALUE, new FieldMetaData("newValue", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.VALID_NEW_VALUE, new FieldMetaData("validNewValue", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.START_CURSOR_POSITION, new FieldMetaData("startCursorPosition", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.END_CURSOR_POSITION, new FieldMetaData("endCursorPosition", 3, new FieldValueMetaData(8)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(InsertTextResult.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        RESULT(1, "result"),
        NEW_VALUE(2, "newValue"),
        VALID_NEW_VALUE(3, "validNewValue"),
        START_CURSOR_POSITION(4, "startCursorPosition"),
        END_CURSOR_POSITION(5, "endCursorPosition");

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
                    return NEW_VALUE;
                }
                case 3: {
                    return VALID_NEW_VALUE;
                }
                case 4: {
                    return START_CURSOR_POSITION;
                }
                case 5: {
                    return END_CURSOR_POSITION;
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

    private static class InsertTextResultStandardSchemeFactory
    implements SchemeFactory {
        private InsertTextResultStandardSchemeFactory() {
        }

        public InsertTextResultStandardScheme getScheme() {
            return new InsertTextResultStandardScheme();
        }
    }

    private static class InsertTextResultTupleSchemeFactory
    implements SchemeFactory {
        private InsertTextResultTupleSchemeFactory() {
        }

        public InsertTextResultTupleScheme getScheme() {
            return new InsertTextResultTupleScheme();
        }
    }

    private static class InsertTextResultTupleScheme
    extends TupleScheme<InsertTextResult> {
        private InsertTextResultTupleScheme() {
        }

        public void write(TProtocol tProtocol, InsertTextResult insertTextResult) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (insertTextResult.isSetResult()) {
                bitSet.set(0);
            }
            if (insertTextResult.isSetNewValue()) {
                bitSet.set(1);
            }
            if (insertTextResult.isSetValidNewValue()) {
                bitSet.set(2);
            }
            if (insertTextResult.isSetStartCursorPosition()) {
                bitSet.set(3);
            }
            if (insertTextResult.isSetEndCursorPosition()) {
                bitSet.set(4);
            }
            tTupleProtocol.writeBitSet(bitSet, 5);
            if (insertTextResult.isSetResult()) {
                insertTextResult.result.write((TProtocol)tTupleProtocol);
            }
            if (insertTextResult.isSetNewValue()) {
                tTupleProtocol.writeString(insertTextResult.newValue);
            }
            if (insertTextResult.isSetValidNewValue()) {
                tTupleProtocol.writeBool(insertTextResult.validNewValue);
            }
            if (insertTextResult.isSetStartCursorPosition()) {
                tTupleProtocol.writeI32(insertTextResult.startCursorPosition);
            }
            if (insertTextResult.isSetEndCursorPosition()) {
                tTupleProtocol.writeI32(insertTextResult.endCursorPosition);
            }
        }

        public void read(TProtocol tProtocol, InsertTextResult insertTextResult) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(5);
            if (bitSet.get(0)) {
                insertTextResult.result = new Result();
                insertTextResult.result.read((TProtocol)tTupleProtocol);
                insertTextResult.setResultIsSet(true);
            }
            if (bitSet.get(1)) {
                insertTextResult.newValue = tTupleProtocol.readString();
                insertTextResult.setNewValueIsSet(true);
            }
            if (bitSet.get(2)) {
                insertTextResult.validNewValue = tTupleProtocol.readBool();
                insertTextResult.setValidNewValueIsSet(true);
            }
            if (bitSet.get(3)) {
                insertTextResult.startCursorPosition = tTupleProtocol.readI32();
                insertTextResult.setStartCursorPositionIsSet(true);
            }
            if (bitSet.get(4)) {
                insertTextResult.endCursorPosition = tTupleProtocol.readI32();
                insertTextResult.setEndCursorPositionIsSet(true);
            }
        }
    }

    private static class InsertTextResultStandardScheme
    extends StandardScheme<InsertTextResult> {
        private InsertTextResultStandardScheme() {
        }

        public void read(TProtocol tProtocol, InsertTextResult insertTextResult) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 12) {
                            insertTextResult.result = new Result();
                            insertTextResult.result.read(tProtocol);
                            insertTextResult.setResultIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 11) {
                            insertTextResult.newValue = tProtocol.readString();
                            insertTextResult.setNewValueIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 2) {
                            insertTextResult.validNewValue = tProtocol.readBool();
                            insertTextResult.setValidNewValueIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 8) {
                            insertTextResult.startCursorPosition = tProtocol.readI32();
                            insertTextResult.setStartCursorPositionIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 5: {
                        if (tField.type == 8) {
                            insertTextResult.endCursorPosition = tProtocol.readI32();
                            insertTextResult.setEndCursorPositionIsSet(true);
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
            insertTextResult.validate();
        }

        public void write(TProtocol tProtocol, InsertTextResult insertTextResult) throws TException {
            insertTextResult.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (insertTextResult.result != null) {
                tProtocol.writeFieldBegin(RESULT_FIELD_DESC);
                insertTextResult.result.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            if (insertTextResult.newValue != null) {
                tProtocol.writeFieldBegin(NEW_VALUE_FIELD_DESC);
                tProtocol.writeString(insertTextResult.newValue);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(VALID_NEW_VALUE_FIELD_DESC);
            tProtocol.writeBool(insertTextResult.validNewValue);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(START_CURSOR_POSITION_FIELD_DESC);
            tProtocol.writeI32(insertTextResult.startCursorPosition);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(END_CURSOR_POSITION_FIELD_DESC);
            tProtocol.writeI32(insertTextResult.endCursorPosition);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

