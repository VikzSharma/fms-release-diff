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

public class ErrorData
implements TBase<ErrorData, _Fields>,
Serializable,
Cloneable,
Comparable<ErrorData> {
    private static final TStruct STRUCT_DESC = new TStruct("ErrorData");
    private static final TField ERROR_FIELD_DESC = new TField("error", 8, 1);
    private static final TField EXT_ERROR_FIELD_DESC = new TField("extError", 8, 2);
    private static final TField SCRIPT_ERROR_FIELD_DESC = new TField("scriptError", 2, 3);
    private static final TField FILE_NAME_FIELD_DESC = new TField("fileName", 11, 4);
    private static final TField SCRIPT_NAME_FIELD_DESC = new TField("scriptName", 11, 5);
    private static final TField SCRIPT_STEP_NAME_FIELD_DESC = new TField("scriptStepName", 11, 6);
    private static final TField TIMESTAMP_FIELD_DESC = new TField("timestamp", 11, 7);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new ErrorDataStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new ErrorDataTupleSchemeFactory();
    private int error;
    private int extError;
    private boolean scriptError;
    @Nullable
    private String fileName;
    @Nullable
    private String scriptName;
    @Nullable
    private String scriptStepName;
    @Nullable
    private String timestamp;
    private static final int __ERROR_ISSET_ID = 0;
    private static final int __EXTERROR_ISSET_ID = 1;
    private static final int __SCRIPTERROR_ISSET_ID = 2;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public ErrorData() {
    }

    public ErrorData(int n, int n2, boolean bl, String string, String string2, String string3, String string4) {
        this();
        this.error = n;
        this.setErrorIsSet(true);
        this.extError = n2;
        this.setExtErrorIsSet(true);
        this.scriptError = bl;
        this.setScriptErrorIsSet(true);
        this.fileName = string;
        this.scriptName = string2;
        this.scriptStepName = string3;
        this.timestamp = string4;
    }

    public ErrorData(ErrorData errorData) {
        this.__isset_bitfield = errorData.__isset_bitfield;
        this.error = errorData.error;
        this.extError = errorData.extError;
        this.scriptError = errorData.scriptError;
        if (errorData.isSetFileName()) {
            this.fileName = errorData.fileName;
        }
        if (errorData.isSetScriptName()) {
            this.scriptName = errorData.scriptName;
        }
        if (errorData.isSetScriptStepName()) {
            this.scriptStepName = errorData.scriptStepName;
        }
        if (errorData.isSetTimestamp()) {
            this.timestamp = errorData.timestamp;
        }
    }

    public ErrorData deepCopy() {
        return new ErrorData(this);
    }

    public void clear() {
        this.setErrorIsSet(false);
        this.error = 0;
        this.setExtErrorIsSet(false);
        this.extError = 0;
        this.setScriptErrorIsSet(false);
        this.scriptError = false;
        this.fileName = null;
        this.scriptName = null;
        this.scriptStepName = null;
        this.timestamp = null;
    }

    public int getError() {
        return this.error;
    }

    public void setError(int n) {
        this.error = n;
        this.setErrorIsSet(true);
    }

    public void unsetError() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetError() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setErrorIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public int getExtError() {
        return this.extError;
    }

    public void setExtError(int n) {
        this.extError = n;
        this.setExtErrorIsSet(true);
    }

    public void unsetExtError() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)1);
    }

    public boolean isSetExtError() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)1);
    }

    public void setExtErrorIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)1, (boolean)bl);
    }

    public boolean isScriptError() {
        return this.scriptError;
    }

    public void setScriptError(boolean bl) {
        this.scriptError = bl;
        this.setScriptErrorIsSet(true);
    }

    public void unsetScriptError() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)2);
    }

    public boolean isSetScriptError() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)2);
    }

    public void setScriptErrorIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)2, (boolean)bl);
    }

    @Nullable
    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(@Nullable String string) {
        this.fileName = string;
    }

    public void unsetFileName() {
        this.fileName = null;
    }

    public boolean isSetFileName() {
        return this.fileName != null;
    }

    public void setFileNameIsSet(boolean bl) {
        if (!bl) {
            this.fileName = null;
        }
    }

    @Nullable
    public String getScriptName() {
        return this.scriptName;
    }

    public void setScriptName(@Nullable String string) {
        this.scriptName = string;
    }

    public void unsetScriptName() {
        this.scriptName = null;
    }

    public boolean isSetScriptName() {
        return this.scriptName != null;
    }

    public void setScriptNameIsSet(boolean bl) {
        if (!bl) {
            this.scriptName = null;
        }
    }

    @Nullable
    public String getScriptStepName() {
        return this.scriptStepName;
    }

    public void setScriptStepName(@Nullable String string) {
        this.scriptStepName = string;
    }

    public void unsetScriptStepName() {
        this.scriptStepName = null;
    }

    public boolean isSetScriptStepName() {
        return this.scriptStepName != null;
    }

    public void setScriptStepNameIsSet(boolean bl) {
        if (!bl) {
            this.scriptStepName = null;
        }
    }

    @Nullable
    public String getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(@Nullable String string) {
        this.timestamp = string;
    }

    public void unsetTimestamp() {
        this.timestamp = null;
    }

    public boolean isSetTimestamp() {
        return this.timestamp != null;
    }

    public void setTimestampIsSet(boolean bl) {
        if (!bl) {
            this.timestamp = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetError();
                    break;
                }
                this.setError((Integer)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetExtError();
                    break;
                }
                this.setExtError((Integer)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetScriptError();
                    break;
                }
                this.setScriptError((Boolean)object);
                break;
            }
            case 3: {
                if (object == null) {
                    this.unsetFileName();
                    break;
                }
                this.setFileName((String)object);
                break;
            }
            case 4: {
                if (object == null) {
                    this.unsetScriptName();
                    break;
                }
                this.setScriptName((String)object);
                break;
            }
            case 5: {
                if (object == null) {
                    this.unsetScriptStepName();
                    break;
                }
                this.setScriptStepName((String)object);
                break;
            }
            case 6: {
                if (object == null) {
                    this.unsetTimestamp();
                    break;
                }
                this.setTimestamp((String)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getError();
            }
            case 1: {
                return this.getExtError();
            }
            case 2: {
                return this.isScriptError();
            }
            case 3: {
                return this.getFileName();
            }
            case 4: {
                return this.getScriptName();
            }
            case 5: {
                return this.getScriptStepName();
            }
            case 6: {
                return this.getTimestamp();
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
                return this.isSetError();
            }
            case 1: {
                return this.isSetExtError();
            }
            case 2: {
                return this.isSetScriptError();
            }
            case 3: {
                return this.isSetFileName();
            }
            case 4: {
                return this.isSetScriptName();
            }
            case 5: {
                return this.isSetScriptStepName();
            }
            case 6: {
                return this.isSetTimestamp();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof ErrorData) {
            return this.equals((ErrorData)object);
        }
        return false;
    }

    public boolean equals(ErrorData errorData) {
        if (errorData == null) {
            return false;
        }
        if (this == errorData) {
            return true;
        }
        boolean bl = true;
        boolean bl2 = true;
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (this.error != errorData.error) {
                return false;
            }
        }
        boolean bl3 = true;
        boolean bl4 = true;
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (this.extError != errorData.extError) {
                return false;
            }
        }
        boolean bl5 = true;
        boolean bl6 = true;
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (this.scriptError != errorData.scriptError) {
                return false;
            }
        }
        boolean bl7 = this.isSetFileName();
        boolean bl8 = errorData.isSetFileName();
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (!this.fileName.equals(errorData.fileName)) {
                return false;
            }
        }
        boolean bl9 = this.isSetScriptName();
        boolean bl10 = errorData.isSetScriptName();
        if (bl9 || bl10) {
            if (!bl9 || !bl10) {
                return false;
            }
            if (!this.scriptName.equals(errorData.scriptName)) {
                return false;
            }
        }
        boolean bl11 = this.isSetScriptStepName();
        boolean bl12 = errorData.isSetScriptStepName();
        if (bl11 || bl12) {
            if (!bl11 || !bl12) {
                return false;
            }
            if (!this.scriptStepName.equals(errorData.scriptStepName)) {
                return false;
            }
        }
        boolean bl13 = this.isSetTimestamp();
        boolean bl14 = errorData.isSetTimestamp();
        if (bl13 || bl14) {
            if (!bl13 || !bl14) {
                return false;
            }
            if (!this.timestamp.equals(errorData.timestamp)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + this.error;
        n = n * 8191 + this.extError;
        n = n * 8191 + (this.scriptError ? 131071 : 524287);
        n = n * 8191 + (this.isSetFileName() ? 131071 : 524287);
        if (this.isSetFileName()) {
            n = n * 8191 + this.fileName.hashCode();
        }
        n = n * 8191 + (this.isSetScriptName() ? 131071 : 524287);
        if (this.isSetScriptName()) {
            n = n * 8191 + this.scriptName.hashCode();
        }
        n = n * 8191 + (this.isSetScriptStepName() ? 131071 : 524287);
        if (this.isSetScriptStepName()) {
            n = n * 8191 + this.scriptStepName.hashCode();
        }
        n = n * 8191 + (this.isSetTimestamp() ? 131071 : 524287);
        if (this.isSetTimestamp()) {
            n = n * 8191 + this.timestamp.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(ErrorData errorData) {
        if (!this.getClass().equals(errorData.getClass())) {
            return this.getClass().getName().compareTo(errorData.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetError(), errorData.isSetError());
        if (n != 0) {
            return n;
        }
        if (this.isSetError() && (n = TBaseHelper.compareTo((int)this.error, (int)errorData.error)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetExtError(), errorData.isSetExtError());
        if (n != 0) {
            return n;
        }
        if (this.isSetExtError() && (n = TBaseHelper.compareTo((int)this.extError, (int)errorData.extError)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetScriptError(), errorData.isSetScriptError());
        if (n != 0) {
            return n;
        }
        if (this.isSetScriptError() && (n = TBaseHelper.compareTo((boolean)this.scriptError, (boolean)errorData.scriptError)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetFileName(), errorData.isSetFileName());
        if (n != 0) {
            return n;
        }
        if (this.isSetFileName() && (n = TBaseHelper.compareTo((String)this.fileName, (String)errorData.fileName)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetScriptName(), errorData.isSetScriptName());
        if (n != 0) {
            return n;
        }
        if (this.isSetScriptName() && (n = TBaseHelper.compareTo((String)this.scriptName, (String)errorData.scriptName)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetScriptStepName(), errorData.isSetScriptStepName());
        if (n != 0) {
            return n;
        }
        if (this.isSetScriptStepName() && (n = TBaseHelper.compareTo((String)this.scriptStepName, (String)errorData.scriptStepName)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetTimestamp(), errorData.isSetTimestamp());
        if (n != 0) {
            return n;
        }
        if (this.isSetTimestamp() && (n = TBaseHelper.compareTo((String)this.timestamp, (String)errorData.timestamp)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        ErrorData.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        ErrorData.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ErrorData(");
        boolean bl = true;
        stringBuilder.append("error:");
        stringBuilder.append(this.error);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("extError:");
        stringBuilder.append(this.extError);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("scriptError:");
        stringBuilder.append(this.scriptError);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("fileName:");
        if (this.fileName == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.fileName);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("scriptName:");
        if (this.scriptName == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.scriptName);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("scriptStepName:");
        if (this.scriptStepName == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.scriptStepName);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("timestamp:");
        if (this.timestamp == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.timestamp);
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
        enumMap.put(_Fields.ERROR, new FieldMetaData("error", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.EXT_ERROR, new FieldMetaData("extError", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.SCRIPT_ERROR, new FieldMetaData("scriptError", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.FILE_NAME, new FieldMetaData("fileName", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.SCRIPT_NAME, new FieldMetaData("scriptName", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.SCRIPT_STEP_NAME, new FieldMetaData("scriptStepName", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.TIMESTAMP, new FieldMetaData("timestamp", 3, new FieldValueMetaData(11)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(ErrorData.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        ERROR(1, "error"),
        EXT_ERROR(2, "extError"),
        SCRIPT_ERROR(3, "scriptError"),
        FILE_NAME(4, "fileName"),
        SCRIPT_NAME(5, "scriptName"),
        SCRIPT_STEP_NAME(6, "scriptStepName"),
        TIMESTAMP(7, "timestamp");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return ERROR;
                }
                case 2: {
                    return EXT_ERROR;
                }
                case 3: {
                    return SCRIPT_ERROR;
                }
                case 4: {
                    return FILE_NAME;
                }
                case 5: {
                    return SCRIPT_NAME;
                }
                case 6: {
                    return SCRIPT_STEP_NAME;
                }
                case 7: {
                    return TIMESTAMP;
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

    private static class ErrorDataStandardSchemeFactory
    implements SchemeFactory {
        private ErrorDataStandardSchemeFactory() {
        }

        public ErrorDataStandardScheme getScheme() {
            return new ErrorDataStandardScheme();
        }
    }

    private static class ErrorDataTupleSchemeFactory
    implements SchemeFactory {
        private ErrorDataTupleSchemeFactory() {
        }

        public ErrorDataTupleScheme getScheme() {
            return new ErrorDataTupleScheme();
        }
    }

    private static class ErrorDataTupleScheme
    extends TupleScheme<ErrorData> {
        private ErrorDataTupleScheme() {
        }

        public void write(TProtocol tProtocol, ErrorData errorData) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (errorData.isSetError()) {
                bitSet.set(0);
            }
            if (errorData.isSetExtError()) {
                bitSet.set(1);
            }
            if (errorData.isSetScriptError()) {
                bitSet.set(2);
            }
            if (errorData.isSetFileName()) {
                bitSet.set(3);
            }
            if (errorData.isSetScriptName()) {
                bitSet.set(4);
            }
            if (errorData.isSetScriptStepName()) {
                bitSet.set(5);
            }
            if (errorData.isSetTimestamp()) {
                bitSet.set(6);
            }
            tTupleProtocol.writeBitSet(bitSet, 7);
            if (errorData.isSetError()) {
                tTupleProtocol.writeI32(errorData.error);
            }
            if (errorData.isSetExtError()) {
                tTupleProtocol.writeI32(errorData.extError);
            }
            if (errorData.isSetScriptError()) {
                tTupleProtocol.writeBool(errorData.scriptError);
            }
            if (errorData.isSetFileName()) {
                tTupleProtocol.writeString(errorData.fileName);
            }
            if (errorData.isSetScriptName()) {
                tTupleProtocol.writeString(errorData.scriptName);
            }
            if (errorData.isSetScriptStepName()) {
                tTupleProtocol.writeString(errorData.scriptStepName);
            }
            if (errorData.isSetTimestamp()) {
                tTupleProtocol.writeString(errorData.timestamp);
            }
        }

        public void read(TProtocol tProtocol, ErrorData errorData) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(7);
            if (bitSet.get(0)) {
                errorData.error = tTupleProtocol.readI32();
                errorData.setErrorIsSet(true);
            }
            if (bitSet.get(1)) {
                errorData.extError = tTupleProtocol.readI32();
                errorData.setExtErrorIsSet(true);
            }
            if (bitSet.get(2)) {
                errorData.scriptError = tTupleProtocol.readBool();
                errorData.setScriptErrorIsSet(true);
            }
            if (bitSet.get(3)) {
                errorData.fileName = tTupleProtocol.readString();
                errorData.setFileNameIsSet(true);
            }
            if (bitSet.get(4)) {
                errorData.scriptName = tTupleProtocol.readString();
                errorData.setScriptNameIsSet(true);
            }
            if (bitSet.get(5)) {
                errorData.scriptStepName = tTupleProtocol.readString();
                errorData.setScriptStepNameIsSet(true);
            }
            if (bitSet.get(6)) {
                errorData.timestamp = tTupleProtocol.readString();
                errorData.setTimestampIsSet(true);
            }
        }
    }

    private static class ErrorDataStandardScheme
    extends StandardScheme<ErrorData> {
        private ErrorDataStandardScheme() {
        }

        public void read(TProtocol tProtocol, ErrorData errorData) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 8) {
                            errorData.error = tProtocol.readI32();
                            errorData.setErrorIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 8) {
                            errorData.extError = tProtocol.readI32();
                            errorData.setExtErrorIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 2) {
                            errorData.scriptError = tProtocol.readBool();
                            errorData.setScriptErrorIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 11) {
                            errorData.fileName = tProtocol.readString();
                            errorData.setFileNameIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 5: {
                        if (tField.type == 11) {
                            errorData.scriptName = tProtocol.readString();
                            errorData.setScriptNameIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 6: {
                        if (tField.type == 11) {
                            errorData.scriptStepName = tProtocol.readString();
                            errorData.setScriptStepNameIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 7: {
                        if (tField.type == 11) {
                            errorData.timestamp = tProtocol.readString();
                            errorData.setTimestampIsSet(true);
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
            errorData.validate();
        }

        public void write(TProtocol tProtocol, ErrorData errorData) throws TException {
            errorData.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            tProtocol.writeFieldBegin(ERROR_FIELD_DESC);
            tProtocol.writeI32(errorData.error);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(EXT_ERROR_FIELD_DESC);
            tProtocol.writeI32(errorData.extError);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(SCRIPT_ERROR_FIELD_DESC);
            tProtocol.writeBool(errorData.scriptError);
            tProtocol.writeFieldEnd();
            if (errorData.fileName != null) {
                tProtocol.writeFieldBegin(FILE_NAME_FIELD_DESC);
                tProtocol.writeString(errorData.fileName);
                tProtocol.writeFieldEnd();
            }
            if (errorData.scriptName != null) {
                tProtocol.writeFieldBegin(SCRIPT_NAME_FIELD_DESC);
                tProtocol.writeString(errorData.scriptName);
                tProtocol.writeFieldEnd();
            }
            if (errorData.scriptStepName != null) {
                tProtocol.writeFieldBegin(SCRIPT_STEP_NAME_FIELD_DESC);
                tProtocol.writeString(errorData.scriptStepName);
                tProtocol.writeFieldEnd();
            }
            if (errorData.timestamp != null) {
                tProtocol.writeFieldBegin(TIMESTAMP_FIELD_DESC);
                tProtocol.writeString(errorData.timestamp);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

