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
package com.filemaker.jwpc.fmwp.api.thrift.service;

import com.filemaker.jwpc.fmwp.api.thrift.service.ErrorData;
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

public class ReplyStatus
implements TBase<ReplyStatus, _Fields>,
Serializable,
Cloneable,
Comparable<ReplyStatus> {
    private static final TStruct STRUCT_DESC = new TStruct("ReplyStatus");
    private static final TField ERROR_FIELD_DESC = new TField("error", 12, 1);
    private static final TField SCRIPT_ERRORS_FIELD_DESC = new TField("scriptErrors", 15, 2);
    private static final TField SESSION_FIELD_DESC = new TField("session", 8, 3);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new ReplyStatusStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new ReplyStatusTupleSchemeFactory();
    @Nullable
    private ErrorData error;
    @Nullable
    private List<ErrorData> scriptErrors;
    private int session;
    private static final int __SESSION_ISSET_ID = 0;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public ReplyStatus() {
    }

    public ReplyStatus(ErrorData errorData, List<ErrorData> list, int n) {
        this();
        this.error = errorData;
        this.scriptErrors = list;
        this.session = n;
        this.setSessionIsSet(true);
    }

    public ReplyStatus(ReplyStatus replyStatus) {
        this.__isset_bitfield = replyStatus.__isset_bitfield;
        if (replyStatus.isSetError()) {
            this.error = new ErrorData(replyStatus.error);
        }
        if (replyStatus.isSetScriptErrors()) {
            ArrayList<ErrorData> arrayList = new ArrayList<ErrorData>(replyStatus.scriptErrors.size());
            for (ErrorData errorData : replyStatus.scriptErrors) {
                arrayList.add(new ErrorData(errorData));
            }
            this.scriptErrors = arrayList;
        }
        this.session = replyStatus.session;
    }

    public ReplyStatus deepCopy() {
        return new ReplyStatus(this);
    }

    public void clear() {
        this.error = null;
        this.scriptErrors = null;
        this.setSessionIsSet(false);
        this.session = 0;
    }

    @Nullable
    public ErrorData getError() {
        return this.error;
    }

    public void setError(@Nullable ErrorData errorData) {
        this.error = errorData;
    }

    public void unsetError() {
        this.error = null;
    }

    public boolean isSetError() {
        return this.error != null;
    }

    public void setErrorIsSet(boolean bl) {
        if (!bl) {
            this.error = null;
        }
    }

    public int getScriptErrorsSize() {
        return this.scriptErrors == null ? 0 : this.scriptErrors.size();
    }

    @Nullable
    public Iterator<ErrorData> getScriptErrorsIterator() {
        return this.scriptErrors == null ? null : this.scriptErrors.iterator();
    }

    public void addToScriptErrors(ErrorData errorData) {
        if (this.scriptErrors == null) {
            this.scriptErrors = new ArrayList<ErrorData>();
        }
        this.scriptErrors.add(errorData);
    }

    @Nullable
    public List<ErrorData> getScriptErrors() {
        return this.scriptErrors;
    }

    public void setScriptErrors(@Nullable List<ErrorData> list) {
        this.scriptErrors = list;
    }

    public void unsetScriptErrors() {
        this.scriptErrors = null;
    }

    public boolean isSetScriptErrors() {
        return this.scriptErrors != null;
    }

    public void setScriptErrorsIsSet(boolean bl) {
        if (!bl) {
            this.scriptErrors = null;
        }
    }

    public int getSession() {
        return this.session;
    }

    public void setSession(int n) {
        this.session = n;
        this.setSessionIsSet(true);
    }

    public void unsetSession() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetSession() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setSessionIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetError();
                    break;
                }
                this.setError((ErrorData)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetScriptErrors();
                    break;
                }
                this.setScriptErrors((List)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetSession();
                    break;
                }
                this.setSession((Integer)object);
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
                return this.getScriptErrors();
            }
            case 2: {
                return this.getSession();
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
                return this.isSetScriptErrors();
            }
            case 2: {
                return this.isSetSession();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof ReplyStatus) {
            return this.equals((ReplyStatus)object);
        }
        return false;
    }

    public boolean equals(ReplyStatus replyStatus) {
        if (replyStatus == null) {
            return false;
        }
        if (this == replyStatus) {
            return true;
        }
        boolean bl = this.isSetError();
        boolean bl2 = replyStatus.isSetError();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.error.equals(replyStatus.error)) {
                return false;
            }
        }
        boolean bl3 = this.isSetScriptErrors();
        boolean bl4 = replyStatus.isSetScriptErrors();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.scriptErrors.equals(replyStatus.scriptErrors)) {
                return false;
            }
        }
        boolean bl5 = true;
        boolean bl6 = true;
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (this.session != replyStatus.session) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetError() ? 131071 : 524287);
        if (this.isSetError()) {
            n = n * 8191 + this.error.hashCode();
        }
        n = n * 8191 + (this.isSetScriptErrors() ? 131071 : 524287);
        if (this.isSetScriptErrors()) {
            n = n * 8191 + this.scriptErrors.hashCode();
        }
        n = n * 8191 + this.session;
        return n;
    }

    @Override
    public int compareTo(ReplyStatus replyStatus) {
        if (!this.getClass().equals(replyStatus.getClass())) {
            return this.getClass().getName().compareTo(replyStatus.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetError(), replyStatus.isSetError());
        if (n != 0) {
            return n;
        }
        if (this.isSetError() && (n = TBaseHelper.compareTo((Comparable)this.error, (Comparable)replyStatus.error)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetScriptErrors(), replyStatus.isSetScriptErrors());
        if (n != 0) {
            return n;
        }
        if (this.isSetScriptErrors() && (n = TBaseHelper.compareTo(this.scriptErrors, replyStatus.scriptErrors)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetSession(), replyStatus.isSetSession());
        if (n != 0) {
            return n;
        }
        if (this.isSetSession() && (n = TBaseHelper.compareTo((int)this.session, (int)replyStatus.session)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        ReplyStatus.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        ReplyStatus.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ReplyStatus(");
        boolean bl = true;
        stringBuilder.append("error:");
        if (this.error == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.error);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("scriptErrors:");
        if (this.scriptErrors == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.scriptErrors);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("session:");
        stringBuilder.append(this.session);
        bl = false;
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void validate() throws TException {
        if (this.error != null) {
            this.error.validate();
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
        enumMap.put(_Fields.ERROR, new FieldMetaData("error", 3, (FieldValueMetaData)new StructMetaData(12, ErrorData.class)));
        enumMap.put(_Fields.SCRIPT_ERRORS, new FieldMetaData("scriptErrors", 3, (FieldValueMetaData)new ListMetaData(15, (FieldValueMetaData)new StructMetaData(12, ErrorData.class))));
        enumMap.put(_Fields.SESSION, new FieldMetaData("session", 3, new FieldValueMetaData(8)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(ReplyStatus.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        ERROR(1, "error"),
        SCRIPT_ERRORS(2, "scriptErrors"),
        SESSION(3, "session");

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
                    return SCRIPT_ERRORS;
                }
                case 3: {
                    return SESSION;
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

    private static class ReplyStatusStandardSchemeFactory
    implements SchemeFactory {
        private ReplyStatusStandardSchemeFactory() {
        }

        public ReplyStatusStandardScheme getScheme() {
            return new ReplyStatusStandardScheme();
        }
    }

    private static class ReplyStatusTupleSchemeFactory
    implements SchemeFactory {
        private ReplyStatusTupleSchemeFactory() {
        }

        public ReplyStatusTupleScheme getScheme() {
            return new ReplyStatusTupleScheme();
        }
    }

    private static class ReplyStatusTupleScheme
    extends TupleScheme<ReplyStatus> {
        private ReplyStatusTupleScheme() {
        }

        public void write(TProtocol tProtocol, ReplyStatus replyStatus) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (replyStatus.isSetError()) {
                bitSet.set(0);
            }
            if (replyStatus.isSetScriptErrors()) {
                bitSet.set(1);
            }
            if (replyStatus.isSetSession()) {
                bitSet.set(2);
            }
            tTupleProtocol.writeBitSet(bitSet, 3);
            if (replyStatus.isSetError()) {
                replyStatus.error.write((TProtocol)tTupleProtocol);
            }
            if (replyStatus.isSetScriptErrors()) {
                tTupleProtocol.writeI32(replyStatus.scriptErrors.size());
                for (ErrorData errorData : replyStatus.scriptErrors) {
                    errorData.write((TProtocol)tTupleProtocol);
                }
            }
            if (replyStatus.isSetSession()) {
                tTupleProtocol.writeI32(replyStatus.session);
            }
        }

        public void read(TProtocol tProtocol, ReplyStatus replyStatus) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(3);
            if (bitSet.get(0)) {
                replyStatus.error = new ErrorData();
                replyStatus.error.read((TProtocol)tTupleProtocol);
                replyStatus.setErrorIsSet(true);
            }
            if (bitSet.get(1)) {
                TList tList = tTupleProtocol.readListBegin((byte)12);
                replyStatus.scriptErrors = new ArrayList<ErrorData>(tList.size);
                for (int i = 0; i < tList.size; ++i) {
                    ErrorData errorData = new ErrorData();
                    errorData.read((TProtocol)tTupleProtocol);
                    replyStatus.scriptErrors.add(errorData);
                }
                replyStatus.setScriptErrorsIsSet(true);
            }
            if (bitSet.get(2)) {
                replyStatus.session = tTupleProtocol.readI32();
                replyStatus.setSessionIsSet(true);
            }
        }
    }

    private static class ReplyStatusStandardScheme
    extends StandardScheme<ReplyStatus> {
        private ReplyStatusStandardScheme() {
        }

        public void read(TProtocol tProtocol, ReplyStatus replyStatus) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 12) {
                            replyStatus.error = new ErrorData();
                            replyStatus.error.read(tProtocol);
                            replyStatus.setErrorIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 15) {
                            TList tList = tProtocol.readListBegin();
                            replyStatus.scriptErrors = new ArrayList<ErrorData>(tList.size);
                            for (int i = 0; i < tList.size; ++i) {
                                ErrorData errorData = new ErrorData();
                                errorData.read(tProtocol);
                                replyStatus.scriptErrors.add(errorData);
                            }
                            tProtocol.readListEnd();
                            replyStatus.setScriptErrorsIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 8) {
                            replyStatus.session = tProtocol.readI32();
                            replyStatus.setSessionIsSet(true);
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
            replyStatus.validate();
        }

        public void write(TProtocol tProtocol, ReplyStatus replyStatus) throws TException {
            replyStatus.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (replyStatus.error != null) {
                tProtocol.writeFieldBegin(ERROR_FIELD_DESC);
                replyStatus.error.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            if (replyStatus.scriptErrors != null) {
                tProtocol.writeFieldBegin(SCRIPT_ERRORS_FIELD_DESC);
                tProtocol.writeListBegin(new TList(12, replyStatus.scriptErrors.size()));
                for (ErrorData errorData : replyStatus.scriptErrors) {
                    errorData.write(tProtocol);
                }
                tProtocol.writeListEnd();
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(SESSION_FIELD_DESC);
            tProtocol.writeI32(replyStatus.session);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

