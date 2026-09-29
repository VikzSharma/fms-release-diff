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
package com.filemaker.jwpc.fmwp.api.thrift.service;

import com.filemaker.jwpc.fmwp.api.thrift.service.AuthInfo;
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

public class BasicParam
implements TBase<BasicParam, _Fields>,
Serializable,
Cloneable,
Comparable<BasicParam> {
    private static final TStruct STRUCT_DESC = new TStruct("BasicParam");
    private static final TField SESSION_ID_FIELD_DESC = new TField("sessionID", 8, 1);
    private static final TField SESSION_HASH_FIELD_DESC = new TField("sessionHash", 11, 2);
    private static final TField AUTH_INFO_FIELD_DESC = new TField("authInfo", 12, 3);
    private static final TField DATABASE_NAME_FIELD_DESC = new TField("databaseName", 11, 4);
    private static final TField LAYOUT_NAME_FIELD_DESC = new TField("layoutName", 11, 5);
    private static final TField RECORD_ID_FIELD_DESC = new TField("recordId", 11, 6);
    private static final TField KEY_FIELD_DESC = new TField("key", 11, 7);
    private static final TField MOD_ID_FIELD_DESC = new TField("modId", 10, 8);
    private static final TField SKIP_FIELD_DESC = new TField("skip", 10, 9);
    private static final TField MAX_RETURN_FIELD_DESC = new TField("maxReturn", 10, 10);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new BasicParamStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new BasicParamTupleSchemeFactory();
    private int sessionID;
    @Nullable
    private String sessionHash;
    @Nullable
    private AuthInfo authInfo;
    @Nullable
    private String databaseName;
    @Nullable
    private String layoutName;
    @Nullable
    private String recordId;
    @Nullable
    private String key;
    private long modId;
    private long skip;
    private long maxReturn;
    private static final int __SESSIONID_ISSET_ID = 0;
    private static final int __MODID_ISSET_ID = 1;
    private static final int __SKIP_ISSET_ID = 2;
    private static final int __MAXRETURN_ISSET_ID = 3;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public BasicParam() {
    }

    public BasicParam(int n, String string, AuthInfo authInfo, String string2, String string3, String string4, String string5, long l, long l2, long l3) {
        this();
        this.sessionID = n;
        this.setSessionIDIsSet(true);
        this.sessionHash = string;
        this.authInfo = authInfo;
        this.databaseName = string2;
        this.layoutName = string3;
        this.recordId = string4;
        this.key = string5;
        this.modId = l;
        this.setModIdIsSet(true);
        this.skip = l2;
        this.setSkipIsSet(true);
        this.maxReturn = l3;
        this.setMaxReturnIsSet(true);
    }

    public BasicParam(BasicParam basicParam) {
        this.__isset_bitfield = basicParam.__isset_bitfield;
        this.sessionID = basicParam.sessionID;
        if (basicParam.isSetSessionHash()) {
            this.sessionHash = basicParam.sessionHash;
        }
        if (basicParam.isSetAuthInfo()) {
            this.authInfo = new AuthInfo(basicParam.authInfo);
        }
        if (basicParam.isSetDatabaseName()) {
            this.databaseName = basicParam.databaseName;
        }
        if (basicParam.isSetLayoutName()) {
            this.layoutName = basicParam.layoutName;
        }
        if (basicParam.isSetRecordId()) {
            this.recordId = basicParam.recordId;
        }
        if (basicParam.isSetKey()) {
            this.key = basicParam.key;
        }
        this.modId = basicParam.modId;
        this.skip = basicParam.skip;
        this.maxReturn = basicParam.maxReturn;
    }

    public BasicParam deepCopy() {
        return new BasicParam(this);
    }

    public void clear() {
        this.setSessionIDIsSet(false);
        this.sessionID = 0;
        this.sessionHash = null;
        this.authInfo = null;
        this.databaseName = null;
        this.layoutName = null;
        this.recordId = null;
        this.key = null;
        this.setModIdIsSet(false);
        this.modId = 0L;
        this.setSkipIsSet(false);
        this.skip = 0L;
        this.setMaxReturnIsSet(false);
        this.maxReturn = 0L;
    }

    public int getSessionID() {
        return this.sessionID;
    }

    public void setSessionID(int n) {
        this.sessionID = n;
        this.setSessionIDIsSet(true);
    }

    public void unsetSessionID() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetSessionID() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setSessionIDIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    @Nullable
    public String getSessionHash() {
        return this.sessionHash;
    }

    public void setSessionHash(@Nullable String string) {
        this.sessionHash = string;
    }

    public void unsetSessionHash() {
        this.sessionHash = null;
    }

    public boolean isSetSessionHash() {
        return this.sessionHash != null;
    }

    public void setSessionHashIsSet(boolean bl) {
        if (!bl) {
            this.sessionHash = null;
        }
    }

    @Nullable
    public AuthInfo getAuthInfo() {
        return this.authInfo;
    }

    public void setAuthInfo(@Nullable AuthInfo authInfo) {
        this.authInfo = authInfo;
    }

    public void unsetAuthInfo() {
        this.authInfo = null;
    }

    public boolean isSetAuthInfo() {
        return this.authInfo != null;
    }

    public void setAuthInfoIsSet(boolean bl) {
        if (!bl) {
            this.authInfo = null;
        }
    }

    @Nullable
    public String getDatabaseName() {
        return this.databaseName;
    }

    public void setDatabaseName(@Nullable String string) {
        this.databaseName = string;
    }

    public void unsetDatabaseName() {
        this.databaseName = null;
    }

    public boolean isSetDatabaseName() {
        return this.databaseName != null;
    }

    public void setDatabaseNameIsSet(boolean bl) {
        if (!bl) {
            this.databaseName = null;
        }
    }

    @Nullable
    public String getLayoutName() {
        return this.layoutName;
    }

    public void setLayoutName(@Nullable String string) {
        this.layoutName = string;
    }

    public void unsetLayoutName() {
        this.layoutName = null;
    }

    public boolean isSetLayoutName() {
        return this.layoutName != null;
    }

    public void setLayoutNameIsSet(boolean bl) {
        if (!bl) {
            this.layoutName = null;
        }
    }

    @Nullable
    public String getRecordId() {
        return this.recordId;
    }

    public void setRecordId(@Nullable String string) {
        this.recordId = string;
    }

    public void unsetRecordId() {
        this.recordId = null;
    }

    public boolean isSetRecordId() {
        return this.recordId != null;
    }

    public void setRecordIdIsSet(boolean bl) {
        if (!bl) {
            this.recordId = null;
        }
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

    public long getModId() {
        return this.modId;
    }

    public void setModId(long l) {
        this.modId = l;
        this.setModIdIsSet(true);
    }

    public void unsetModId() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)1);
    }

    public boolean isSetModId() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)1);
    }

    public void setModIdIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)1, (boolean)bl);
    }

    public long getSkip() {
        return this.skip;
    }

    public void setSkip(long l) {
        this.skip = l;
        this.setSkipIsSet(true);
    }

    public void unsetSkip() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)2);
    }

    public boolean isSetSkip() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)2);
    }

    public void setSkipIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)2, (boolean)bl);
    }

    public long getMaxReturn() {
        return this.maxReturn;
    }

    public void setMaxReturn(long l) {
        this.maxReturn = l;
        this.setMaxReturnIsSet(true);
    }

    public void unsetMaxReturn() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)3);
    }

    public boolean isSetMaxReturn() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)3);
    }

    public void setMaxReturnIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)3, (boolean)bl);
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetSessionID();
                    break;
                }
                this.setSessionID((Integer)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetSessionHash();
                    break;
                }
                this.setSessionHash((String)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetAuthInfo();
                    break;
                }
                this.setAuthInfo((AuthInfo)object);
                break;
            }
            case 3: {
                if (object == null) {
                    this.unsetDatabaseName();
                    break;
                }
                this.setDatabaseName((String)object);
                break;
            }
            case 4: {
                if (object == null) {
                    this.unsetLayoutName();
                    break;
                }
                this.setLayoutName((String)object);
                break;
            }
            case 5: {
                if (object == null) {
                    this.unsetRecordId();
                    break;
                }
                this.setRecordId((String)object);
                break;
            }
            case 6: {
                if (object == null) {
                    this.unsetKey();
                    break;
                }
                this.setKey((String)object);
                break;
            }
            case 7: {
                if (object == null) {
                    this.unsetModId();
                    break;
                }
                this.setModId((Long)object);
                break;
            }
            case 8: {
                if (object == null) {
                    this.unsetSkip();
                    break;
                }
                this.setSkip((Long)object);
                break;
            }
            case 9: {
                if (object == null) {
                    this.unsetMaxReturn();
                    break;
                }
                this.setMaxReturn((Long)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getSessionID();
            }
            case 1: {
                return this.getSessionHash();
            }
            case 2: {
                return this.getAuthInfo();
            }
            case 3: {
                return this.getDatabaseName();
            }
            case 4: {
                return this.getLayoutName();
            }
            case 5: {
                return this.getRecordId();
            }
            case 6: {
                return this.getKey();
            }
            case 7: {
                return this.getModId();
            }
            case 8: {
                return this.getSkip();
            }
            case 9: {
                return this.getMaxReturn();
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
                return this.isSetSessionID();
            }
            case 1: {
                return this.isSetSessionHash();
            }
            case 2: {
                return this.isSetAuthInfo();
            }
            case 3: {
                return this.isSetDatabaseName();
            }
            case 4: {
                return this.isSetLayoutName();
            }
            case 5: {
                return this.isSetRecordId();
            }
            case 6: {
                return this.isSetKey();
            }
            case 7: {
                return this.isSetModId();
            }
            case 8: {
                return this.isSetSkip();
            }
            case 9: {
                return this.isSetMaxReturn();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof BasicParam) {
            return this.equals((BasicParam)object);
        }
        return false;
    }

    public boolean equals(BasicParam basicParam) {
        if (basicParam == null) {
            return false;
        }
        if (this == basicParam) {
            return true;
        }
        boolean bl = true;
        boolean bl2 = true;
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (this.sessionID != basicParam.sessionID) {
                return false;
            }
        }
        boolean bl3 = this.isSetSessionHash();
        boolean bl4 = basicParam.isSetSessionHash();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.sessionHash.equals(basicParam.sessionHash)) {
                return false;
            }
        }
        boolean bl5 = this.isSetAuthInfo();
        boolean bl6 = basicParam.isSetAuthInfo();
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (!this.authInfo.equals(basicParam.authInfo)) {
                return false;
            }
        }
        boolean bl7 = this.isSetDatabaseName();
        boolean bl8 = basicParam.isSetDatabaseName();
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (!this.databaseName.equals(basicParam.databaseName)) {
                return false;
            }
        }
        boolean bl9 = this.isSetLayoutName();
        boolean bl10 = basicParam.isSetLayoutName();
        if (bl9 || bl10) {
            if (!bl9 || !bl10) {
                return false;
            }
            if (!this.layoutName.equals(basicParam.layoutName)) {
                return false;
            }
        }
        boolean bl11 = this.isSetRecordId();
        boolean bl12 = basicParam.isSetRecordId();
        if (bl11 || bl12) {
            if (!bl11 || !bl12) {
                return false;
            }
            if (!this.recordId.equals(basicParam.recordId)) {
                return false;
            }
        }
        boolean bl13 = this.isSetKey();
        boolean bl14 = basicParam.isSetKey();
        if (bl13 || bl14) {
            if (!bl13 || !bl14) {
                return false;
            }
            if (!this.key.equals(basicParam.key)) {
                return false;
            }
        }
        boolean bl15 = true;
        boolean bl16 = true;
        if (bl15 || bl16) {
            if (!bl15 || !bl16) {
                return false;
            }
            if (this.modId != basicParam.modId) {
                return false;
            }
        }
        boolean bl17 = true;
        boolean bl18 = true;
        if (bl17 || bl18) {
            if (!bl17 || !bl18) {
                return false;
            }
            if (this.skip != basicParam.skip) {
                return false;
            }
        }
        boolean bl19 = true;
        boolean bl20 = true;
        if (bl19 || bl20) {
            if (!bl19 || !bl20) {
                return false;
            }
            if (this.maxReturn != basicParam.maxReturn) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + this.sessionID;
        n = n * 8191 + (this.isSetSessionHash() ? 131071 : 524287);
        if (this.isSetSessionHash()) {
            n = n * 8191 + this.sessionHash.hashCode();
        }
        n = n * 8191 + (this.isSetAuthInfo() ? 131071 : 524287);
        if (this.isSetAuthInfo()) {
            n = n * 8191 + this.authInfo.hashCode();
        }
        n = n * 8191 + (this.isSetDatabaseName() ? 131071 : 524287);
        if (this.isSetDatabaseName()) {
            n = n * 8191 + this.databaseName.hashCode();
        }
        n = n * 8191 + (this.isSetLayoutName() ? 131071 : 524287);
        if (this.isSetLayoutName()) {
            n = n * 8191 + this.layoutName.hashCode();
        }
        n = n * 8191 + (this.isSetRecordId() ? 131071 : 524287);
        if (this.isSetRecordId()) {
            n = n * 8191 + this.recordId.hashCode();
        }
        n = n * 8191 + (this.isSetKey() ? 131071 : 524287);
        if (this.isSetKey()) {
            n = n * 8191 + this.key.hashCode();
        }
        n = n * 8191 + TBaseHelper.hashCode((long)this.modId);
        n = n * 8191 + TBaseHelper.hashCode((long)this.skip);
        n = n * 8191 + TBaseHelper.hashCode((long)this.maxReturn);
        return n;
    }

    @Override
    public int compareTo(BasicParam basicParam) {
        if (!this.getClass().equals(basicParam.getClass())) {
            return this.getClass().getName().compareTo(basicParam.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetSessionID(), basicParam.isSetSessionID());
        if (n != 0) {
            return n;
        }
        if (this.isSetSessionID() && (n = TBaseHelper.compareTo((int)this.sessionID, (int)basicParam.sessionID)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetSessionHash(), basicParam.isSetSessionHash());
        if (n != 0) {
            return n;
        }
        if (this.isSetSessionHash() && (n = TBaseHelper.compareTo((String)this.sessionHash, (String)basicParam.sessionHash)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetAuthInfo(), basicParam.isSetAuthInfo());
        if (n != 0) {
            return n;
        }
        if (this.isSetAuthInfo() && (n = TBaseHelper.compareTo((Comparable)this.authInfo, (Comparable)basicParam.authInfo)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetDatabaseName(), basicParam.isSetDatabaseName());
        if (n != 0) {
            return n;
        }
        if (this.isSetDatabaseName() && (n = TBaseHelper.compareTo((String)this.databaseName, (String)basicParam.databaseName)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetLayoutName(), basicParam.isSetLayoutName());
        if (n != 0) {
            return n;
        }
        if (this.isSetLayoutName() && (n = TBaseHelper.compareTo((String)this.layoutName, (String)basicParam.layoutName)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetRecordId(), basicParam.isSetRecordId());
        if (n != 0) {
            return n;
        }
        if (this.isSetRecordId() && (n = TBaseHelper.compareTo((String)this.recordId, (String)basicParam.recordId)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetKey(), basicParam.isSetKey());
        if (n != 0) {
            return n;
        }
        if (this.isSetKey() && (n = TBaseHelper.compareTo((String)this.key, (String)basicParam.key)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetModId(), basicParam.isSetModId());
        if (n != 0) {
            return n;
        }
        if (this.isSetModId() && (n = TBaseHelper.compareTo((long)this.modId, (long)basicParam.modId)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetSkip(), basicParam.isSetSkip());
        if (n != 0) {
            return n;
        }
        if (this.isSetSkip() && (n = TBaseHelper.compareTo((long)this.skip, (long)basicParam.skip)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetMaxReturn(), basicParam.isSetMaxReturn());
        if (n != 0) {
            return n;
        }
        if (this.isSetMaxReturn() && (n = TBaseHelper.compareTo((long)this.maxReturn, (long)basicParam.maxReturn)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        BasicParam.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        BasicParam.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("BasicParam(");
        boolean bl = true;
        stringBuilder.append("sessionID:");
        stringBuilder.append(this.sessionID);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("sessionHash:");
        if (this.sessionHash == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.sessionHash);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("authInfo:");
        if (this.authInfo == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.authInfo);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("databaseName:");
        if (this.databaseName == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.databaseName);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("layoutName:");
        if (this.layoutName == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.layoutName);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("recordId:");
        if (this.recordId == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.recordId);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
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
        stringBuilder.append("modId:");
        stringBuilder.append(this.modId);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("skip:");
        stringBuilder.append(this.skip);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("maxReturn:");
        stringBuilder.append(this.maxReturn);
        bl = false;
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void validate() throws TException {
        if (this.authInfo != null) {
            this.authInfo.validate();
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
        enumMap.put(_Fields.SESSION_ID, new FieldMetaData("sessionID", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.SESSION_HASH, new FieldMetaData("sessionHash", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.AUTH_INFO, new FieldMetaData("authInfo", 3, (FieldValueMetaData)new StructMetaData(12, AuthInfo.class)));
        enumMap.put(_Fields.DATABASE_NAME, new FieldMetaData("databaseName", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.LAYOUT_NAME, new FieldMetaData("layoutName", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.RECORD_ID, new FieldMetaData("recordId", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.KEY, new FieldMetaData("key", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.MOD_ID, new FieldMetaData("modId", 3, new FieldValueMetaData(10)));
        enumMap.put(_Fields.SKIP, new FieldMetaData("skip", 3, new FieldValueMetaData(10)));
        enumMap.put(_Fields.MAX_RETURN, new FieldMetaData("maxReturn", 3, new FieldValueMetaData(10)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(BasicParam.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        SESSION_ID(1, "sessionID"),
        SESSION_HASH(2, "sessionHash"),
        AUTH_INFO(3, "authInfo"),
        DATABASE_NAME(4, "databaseName"),
        LAYOUT_NAME(5, "layoutName"),
        RECORD_ID(6, "recordId"),
        KEY(7, "key"),
        MOD_ID(8, "modId"),
        SKIP(9, "skip"),
        MAX_RETURN(10, "maxReturn");

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
                    return SESSION_HASH;
                }
                case 3: {
                    return AUTH_INFO;
                }
                case 4: {
                    return DATABASE_NAME;
                }
                case 5: {
                    return LAYOUT_NAME;
                }
                case 6: {
                    return RECORD_ID;
                }
                case 7: {
                    return KEY;
                }
                case 8: {
                    return MOD_ID;
                }
                case 9: {
                    return SKIP;
                }
                case 10: {
                    return MAX_RETURN;
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

    private static class BasicParamStandardSchemeFactory
    implements SchemeFactory {
        private BasicParamStandardSchemeFactory() {
        }

        public BasicParamStandardScheme getScheme() {
            return new BasicParamStandardScheme();
        }
    }

    private static class BasicParamTupleSchemeFactory
    implements SchemeFactory {
        private BasicParamTupleSchemeFactory() {
        }

        public BasicParamTupleScheme getScheme() {
            return new BasicParamTupleScheme();
        }
    }

    private static class BasicParamTupleScheme
    extends TupleScheme<BasicParam> {
        private BasicParamTupleScheme() {
        }

        public void write(TProtocol tProtocol, BasicParam basicParam) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (basicParam.isSetSessionID()) {
                bitSet.set(0);
            }
            if (basicParam.isSetSessionHash()) {
                bitSet.set(1);
            }
            if (basicParam.isSetAuthInfo()) {
                bitSet.set(2);
            }
            if (basicParam.isSetDatabaseName()) {
                bitSet.set(3);
            }
            if (basicParam.isSetLayoutName()) {
                bitSet.set(4);
            }
            if (basicParam.isSetRecordId()) {
                bitSet.set(5);
            }
            if (basicParam.isSetKey()) {
                bitSet.set(6);
            }
            if (basicParam.isSetModId()) {
                bitSet.set(7);
            }
            if (basicParam.isSetSkip()) {
                bitSet.set(8);
            }
            if (basicParam.isSetMaxReturn()) {
                bitSet.set(9);
            }
            tTupleProtocol.writeBitSet(bitSet, 10);
            if (basicParam.isSetSessionID()) {
                tTupleProtocol.writeI32(basicParam.sessionID);
            }
            if (basicParam.isSetSessionHash()) {
                tTupleProtocol.writeString(basicParam.sessionHash);
            }
            if (basicParam.isSetAuthInfo()) {
                basicParam.authInfo.write((TProtocol)tTupleProtocol);
            }
            if (basicParam.isSetDatabaseName()) {
                tTupleProtocol.writeString(basicParam.databaseName);
            }
            if (basicParam.isSetLayoutName()) {
                tTupleProtocol.writeString(basicParam.layoutName);
            }
            if (basicParam.isSetRecordId()) {
                tTupleProtocol.writeString(basicParam.recordId);
            }
            if (basicParam.isSetKey()) {
                tTupleProtocol.writeString(basicParam.key);
            }
            if (basicParam.isSetModId()) {
                tTupleProtocol.writeI64(basicParam.modId);
            }
            if (basicParam.isSetSkip()) {
                tTupleProtocol.writeI64(basicParam.skip);
            }
            if (basicParam.isSetMaxReturn()) {
                tTupleProtocol.writeI64(basicParam.maxReturn);
            }
        }

        public void read(TProtocol tProtocol, BasicParam basicParam) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(10);
            if (bitSet.get(0)) {
                basicParam.sessionID = tTupleProtocol.readI32();
                basicParam.setSessionIDIsSet(true);
            }
            if (bitSet.get(1)) {
                basicParam.sessionHash = tTupleProtocol.readString();
                basicParam.setSessionHashIsSet(true);
            }
            if (bitSet.get(2)) {
                basicParam.authInfo = new AuthInfo();
                basicParam.authInfo.read((TProtocol)tTupleProtocol);
                basicParam.setAuthInfoIsSet(true);
            }
            if (bitSet.get(3)) {
                basicParam.databaseName = tTupleProtocol.readString();
                basicParam.setDatabaseNameIsSet(true);
            }
            if (bitSet.get(4)) {
                basicParam.layoutName = tTupleProtocol.readString();
                basicParam.setLayoutNameIsSet(true);
            }
            if (bitSet.get(5)) {
                basicParam.recordId = tTupleProtocol.readString();
                basicParam.setRecordIdIsSet(true);
            }
            if (bitSet.get(6)) {
                basicParam.key = tTupleProtocol.readString();
                basicParam.setKeyIsSet(true);
            }
            if (bitSet.get(7)) {
                basicParam.modId = tTupleProtocol.readI64();
                basicParam.setModIdIsSet(true);
            }
            if (bitSet.get(8)) {
                basicParam.skip = tTupleProtocol.readI64();
                basicParam.setSkipIsSet(true);
            }
            if (bitSet.get(9)) {
                basicParam.maxReturn = tTupleProtocol.readI64();
                basicParam.setMaxReturnIsSet(true);
            }
        }
    }

    private static class BasicParamStandardScheme
    extends StandardScheme<BasicParam> {
        private BasicParamStandardScheme() {
        }

        public void read(TProtocol tProtocol, BasicParam basicParam) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 8) {
                            basicParam.sessionID = tProtocol.readI32();
                            basicParam.setSessionIDIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 11) {
                            basicParam.sessionHash = tProtocol.readString();
                            basicParam.setSessionHashIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 12) {
                            basicParam.authInfo = new AuthInfo();
                            basicParam.authInfo.read(tProtocol);
                            basicParam.setAuthInfoIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 11) {
                            basicParam.databaseName = tProtocol.readString();
                            basicParam.setDatabaseNameIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 5: {
                        if (tField.type == 11) {
                            basicParam.layoutName = tProtocol.readString();
                            basicParam.setLayoutNameIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 6: {
                        if (tField.type == 11) {
                            basicParam.recordId = tProtocol.readString();
                            basicParam.setRecordIdIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 7: {
                        if (tField.type == 11) {
                            basicParam.key = tProtocol.readString();
                            basicParam.setKeyIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 8: {
                        if (tField.type == 10) {
                            basicParam.modId = tProtocol.readI64();
                            basicParam.setModIdIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 9: {
                        if (tField.type == 10) {
                            basicParam.skip = tProtocol.readI64();
                            basicParam.setSkipIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 10: {
                        if (tField.type == 10) {
                            basicParam.maxReturn = tProtocol.readI64();
                            basicParam.setMaxReturnIsSet(true);
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
            basicParam.validate();
        }

        public void write(TProtocol tProtocol, BasicParam basicParam) throws TException {
            basicParam.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            tProtocol.writeFieldBegin(SESSION_ID_FIELD_DESC);
            tProtocol.writeI32(basicParam.sessionID);
            tProtocol.writeFieldEnd();
            if (basicParam.sessionHash != null) {
                tProtocol.writeFieldBegin(SESSION_HASH_FIELD_DESC);
                tProtocol.writeString(basicParam.sessionHash);
                tProtocol.writeFieldEnd();
            }
            if (basicParam.authInfo != null) {
                tProtocol.writeFieldBegin(AUTH_INFO_FIELD_DESC);
                basicParam.authInfo.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            if (basicParam.databaseName != null) {
                tProtocol.writeFieldBegin(DATABASE_NAME_FIELD_DESC);
                tProtocol.writeString(basicParam.databaseName);
                tProtocol.writeFieldEnd();
            }
            if (basicParam.layoutName != null) {
                tProtocol.writeFieldBegin(LAYOUT_NAME_FIELD_DESC);
                tProtocol.writeString(basicParam.layoutName);
                tProtocol.writeFieldEnd();
            }
            if (basicParam.recordId != null) {
                tProtocol.writeFieldBegin(RECORD_ID_FIELD_DESC);
                tProtocol.writeString(basicParam.recordId);
                tProtocol.writeFieldEnd();
            }
            if (basicParam.key != null) {
                tProtocol.writeFieldBegin(KEY_FIELD_DESC);
                tProtocol.writeString(basicParam.key);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(MOD_ID_FIELD_DESC);
            tProtocol.writeI64(basicParam.modId);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(SKIP_FIELD_DESC);
            tProtocol.writeI64(basicParam.skip);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(MAX_RETURN_FIELD_DESC);
            tProtocol.writeI64(basicParam.maxReturn);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

