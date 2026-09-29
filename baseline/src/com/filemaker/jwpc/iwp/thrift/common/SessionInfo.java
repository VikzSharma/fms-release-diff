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

public class SessionInfo
implements TBase<SessionInfo, _Fields>,
Serializable,
Cloneable,
Comparable<SessionInfo> {
    private static final TStruct STRUCT_DESC = new TStruct("SessionInfo");
    private static final TField SESSION_ID_FIELD_DESC = new TField("sessionId", 8, 1);
    private static final TField TIMEOUT_FIELD_DESC = new TField("timeout", 10, 2);
    private static final TField UPLOAD_DIRECTORY_PATH_FIELD_DESC = new TField("uploadDirectoryPath", 11, 3);
    private static final TField OPTION_FLAG_FIELD_DESC = new TField("optionFlag", 8, 4);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new SessionInfoStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new SessionInfoTupleSchemeFactory();
    private int sessionId;
    private long timeout;
    @Nullable
    private String uploadDirectoryPath;
    private int optionFlag;
    private static final int __SESSIONID_ISSET_ID = 0;
    private static final int __TIMEOUT_ISSET_ID = 1;
    private static final int __OPTIONFLAG_ISSET_ID = 2;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public SessionInfo() {
    }

    public SessionInfo(int n, long l, String string, int n2) {
        this();
        this.sessionId = n;
        this.setSessionIdIsSet(true);
        this.timeout = l;
        this.setTimeoutIsSet(true);
        this.uploadDirectoryPath = string;
        this.optionFlag = n2;
        this.setOptionFlagIsSet(true);
    }

    public SessionInfo(SessionInfo sessionInfo) {
        this.__isset_bitfield = sessionInfo.__isset_bitfield;
        this.sessionId = sessionInfo.sessionId;
        this.timeout = sessionInfo.timeout;
        if (sessionInfo.isSetUploadDirectoryPath()) {
            this.uploadDirectoryPath = sessionInfo.uploadDirectoryPath;
        }
        this.optionFlag = sessionInfo.optionFlag;
    }

    public SessionInfo deepCopy() {
        return new SessionInfo(this);
    }

    public void clear() {
        this.setSessionIdIsSet(false);
        this.sessionId = 0;
        this.setTimeoutIsSet(false);
        this.timeout = 0L;
        this.uploadDirectoryPath = null;
        this.setOptionFlagIsSet(false);
        this.optionFlag = 0;
    }

    public int getSessionId() {
        return this.sessionId;
    }

    public void setSessionId(int n) {
        this.sessionId = n;
        this.setSessionIdIsSet(true);
    }

    public void unsetSessionId() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetSessionId() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setSessionIdIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public long getTimeout() {
        return this.timeout;
    }

    public void setTimeout(long l) {
        this.timeout = l;
        this.setTimeoutIsSet(true);
    }

    public void unsetTimeout() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)1);
    }

    public boolean isSetTimeout() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)1);
    }

    public void setTimeoutIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)1, (boolean)bl);
    }

    @Nullable
    public String getUploadDirectoryPath() {
        return this.uploadDirectoryPath;
    }

    public void setUploadDirectoryPath(@Nullable String string) {
        this.uploadDirectoryPath = string;
    }

    public void unsetUploadDirectoryPath() {
        this.uploadDirectoryPath = null;
    }

    public boolean isSetUploadDirectoryPath() {
        return this.uploadDirectoryPath != null;
    }

    public void setUploadDirectoryPathIsSet(boolean bl) {
        if (!bl) {
            this.uploadDirectoryPath = null;
        }
    }

    public int getOptionFlag() {
        return this.optionFlag;
    }

    public void setOptionFlag(int n) {
        this.optionFlag = n;
        this.setOptionFlagIsSet(true);
    }

    public void unsetOptionFlag() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)2);
    }

    public boolean isSetOptionFlag() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)2);
    }

    public void setOptionFlagIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)2, (boolean)bl);
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetSessionId();
                    break;
                }
                this.setSessionId((Integer)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetTimeout();
                    break;
                }
                this.setTimeout((Long)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetUploadDirectoryPath();
                    break;
                }
                this.setUploadDirectoryPath((String)object);
                break;
            }
            case 3: {
                if (object == null) {
                    this.unsetOptionFlag();
                    break;
                }
                this.setOptionFlag((Integer)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getSessionId();
            }
            case 1: {
                return this.getTimeout();
            }
            case 2: {
                return this.getUploadDirectoryPath();
            }
            case 3: {
                return this.getOptionFlag();
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
                return this.isSetSessionId();
            }
            case 1: {
                return this.isSetTimeout();
            }
            case 2: {
                return this.isSetUploadDirectoryPath();
            }
            case 3: {
                return this.isSetOptionFlag();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof SessionInfo) {
            return this.equals((SessionInfo)object);
        }
        return false;
    }

    public boolean equals(SessionInfo sessionInfo) {
        if (sessionInfo == null) {
            return false;
        }
        if (this == sessionInfo) {
            return true;
        }
        boolean bl = true;
        boolean bl2 = true;
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (this.sessionId != sessionInfo.sessionId) {
                return false;
            }
        }
        boolean bl3 = true;
        boolean bl4 = true;
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (this.timeout != sessionInfo.timeout) {
                return false;
            }
        }
        boolean bl5 = this.isSetUploadDirectoryPath();
        boolean bl6 = sessionInfo.isSetUploadDirectoryPath();
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (!this.uploadDirectoryPath.equals(sessionInfo.uploadDirectoryPath)) {
                return false;
            }
        }
        boolean bl7 = true;
        boolean bl8 = true;
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (this.optionFlag != sessionInfo.optionFlag) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + this.sessionId;
        n = n * 8191 + TBaseHelper.hashCode((long)this.timeout);
        n = n * 8191 + (this.isSetUploadDirectoryPath() ? 131071 : 524287);
        if (this.isSetUploadDirectoryPath()) {
            n = n * 8191 + this.uploadDirectoryPath.hashCode();
        }
        n = n * 8191 + this.optionFlag;
        return n;
    }

    @Override
    public int compareTo(SessionInfo sessionInfo) {
        if (!this.getClass().equals(sessionInfo.getClass())) {
            return this.getClass().getName().compareTo(sessionInfo.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetSessionId(), sessionInfo.isSetSessionId());
        if (n != 0) {
            return n;
        }
        if (this.isSetSessionId() && (n = TBaseHelper.compareTo((int)this.sessionId, (int)sessionInfo.sessionId)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetTimeout(), sessionInfo.isSetTimeout());
        if (n != 0) {
            return n;
        }
        if (this.isSetTimeout() && (n = TBaseHelper.compareTo((long)this.timeout, (long)sessionInfo.timeout)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetUploadDirectoryPath(), sessionInfo.isSetUploadDirectoryPath());
        if (n != 0) {
            return n;
        }
        if (this.isSetUploadDirectoryPath() && (n = TBaseHelper.compareTo((String)this.uploadDirectoryPath, (String)sessionInfo.uploadDirectoryPath)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetOptionFlag(), sessionInfo.isSetOptionFlag());
        if (n != 0) {
            return n;
        }
        if (this.isSetOptionFlag() && (n = TBaseHelper.compareTo((int)this.optionFlag, (int)sessionInfo.optionFlag)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        SessionInfo.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        SessionInfo.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("SessionInfo(");
        boolean bl = true;
        stringBuilder.append("sessionId:");
        stringBuilder.append(this.sessionId);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("timeout:");
        stringBuilder.append(this.timeout);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("uploadDirectoryPath:");
        if (this.uploadDirectoryPath == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.uploadDirectoryPath);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("optionFlag:");
        stringBuilder.append(this.optionFlag);
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
        enumMap.put(_Fields.SESSION_ID, new FieldMetaData("sessionId", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.TIMEOUT, new FieldMetaData("timeout", 3, new FieldValueMetaData(10)));
        enumMap.put(_Fields.UPLOAD_DIRECTORY_PATH, new FieldMetaData("uploadDirectoryPath", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.OPTION_FLAG, new FieldMetaData("optionFlag", 3, new FieldValueMetaData(8)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(SessionInfo.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        SESSION_ID(1, "sessionId"),
        TIMEOUT(2, "timeout"),
        UPLOAD_DIRECTORY_PATH(3, "uploadDirectoryPath"),
        OPTION_FLAG(4, "optionFlag");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return SESSION_ID;
                }
                case 2: {
                    return TIMEOUT;
                }
                case 3: {
                    return UPLOAD_DIRECTORY_PATH;
                }
                case 4: {
                    return OPTION_FLAG;
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

    private static class SessionInfoStandardSchemeFactory
    implements SchemeFactory {
        private SessionInfoStandardSchemeFactory() {
        }

        public SessionInfoStandardScheme getScheme() {
            return new SessionInfoStandardScheme();
        }
    }

    private static class SessionInfoTupleSchemeFactory
    implements SchemeFactory {
        private SessionInfoTupleSchemeFactory() {
        }

        public SessionInfoTupleScheme getScheme() {
            return new SessionInfoTupleScheme();
        }
    }

    private static class SessionInfoTupleScheme
    extends TupleScheme<SessionInfo> {
        private SessionInfoTupleScheme() {
        }

        public void write(TProtocol tProtocol, SessionInfo sessionInfo) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (sessionInfo.isSetSessionId()) {
                bitSet.set(0);
            }
            if (sessionInfo.isSetTimeout()) {
                bitSet.set(1);
            }
            if (sessionInfo.isSetUploadDirectoryPath()) {
                bitSet.set(2);
            }
            if (sessionInfo.isSetOptionFlag()) {
                bitSet.set(3);
            }
            tTupleProtocol.writeBitSet(bitSet, 4);
            if (sessionInfo.isSetSessionId()) {
                tTupleProtocol.writeI32(sessionInfo.sessionId);
            }
            if (sessionInfo.isSetTimeout()) {
                tTupleProtocol.writeI64(sessionInfo.timeout);
            }
            if (sessionInfo.isSetUploadDirectoryPath()) {
                tTupleProtocol.writeString(sessionInfo.uploadDirectoryPath);
            }
            if (sessionInfo.isSetOptionFlag()) {
                tTupleProtocol.writeI32(sessionInfo.optionFlag);
            }
        }

        public void read(TProtocol tProtocol, SessionInfo sessionInfo) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(4);
            if (bitSet.get(0)) {
                sessionInfo.sessionId = tTupleProtocol.readI32();
                sessionInfo.setSessionIdIsSet(true);
            }
            if (bitSet.get(1)) {
                sessionInfo.timeout = tTupleProtocol.readI64();
                sessionInfo.setTimeoutIsSet(true);
            }
            if (bitSet.get(2)) {
                sessionInfo.uploadDirectoryPath = tTupleProtocol.readString();
                sessionInfo.setUploadDirectoryPathIsSet(true);
            }
            if (bitSet.get(3)) {
                sessionInfo.optionFlag = tTupleProtocol.readI32();
                sessionInfo.setOptionFlagIsSet(true);
            }
        }
    }

    private static class SessionInfoStandardScheme
    extends StandardScheme<SessionInfo> {
        private SessionInfoStandardScheme() {
        }

        public void read(TProtocol tProtocol, SessionInfo sessionInfo) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 8) {
                            sessionInfo.sessionId = tProtocol.readI32();
                            sessionInfo.setSessionIdIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 10) {
                            sessionInfo.timeout = tProtocol.readI64();
                            sessionInfo.setTimeoutIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 11) {
                            sessionInfo.uploadDirectoryPath = tProtocol.readString();
                            sessionInfo.setUploadDirectoryPathIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 8) {
                            sessionInfo.optionFlag = tProtocol.readI32();
                            sessionInfo.setOptionFlagIsSet(true);
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
            sessionInfo.validate();
        }

        public void write(TProtocol tProtocol, SessionInfo sessionInfo) throws TException {
            sessionInfo.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            tProtocol.writeFieldBegin(SESSION_ID_FIELD_DESC);
            tProtocol.writeI32(sessionInfo.sessionId);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(TIMEOUT_FIELD_DESC);
            tProtocol.writeI64(sessionInfo.timeout);
            tProtocol.writeFieldEnd();
            if (sessionInfo.uploadDirectoryPath != null) {
                tProtocol.writeFieldBegin(UPLOAD_DIRECTORY_PATH_FIELD_DESC);
                tProtocol.writeString(sessionInfo.uploadDirectoryPath);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(OPTION_FLAG_FIELD_DESC);
            tProtocol.writeI32(sessionInfo.optionFlag);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

