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

public class AuthInfo
implements TBase<AuthInfo, _Fields>,
Serializable,
Cloneable,
Comparable<AuthInfo> {
    private static final TStruct STRUCT_DESC = new TStruct("AuthInfo");
    private static final TField USER_NAME_FIELD_DESC = new TField("userName", 11, 1);
    private static final TField PASSWORD_FIELD_DESC = new TField("password", 11, 2);
    private static final TField PRIV_EXT_FIELD_DESC = new TField("privExt", 11, 3);
    private static final TField CLIENT_IP_FIELD_DESC = new TField("clientIP", 11, 4);
    private static final TField USER_AGENT_FIELD_DESC = new TField("userAgent", 11, 5);
    private static final TField CLIENT_HOSTNAME_FIELD_DESC = new TField("clientHostname", 11, 6);
    private static final TField OAUTH_FIELD_DESC = new TField("oauth", 2, 7);
    private static final TField EMAIL_FIELD_DESC = new TField("email", 11, 8);
    private static final TField PASSCODE_FIELD_DESC = new TField("passcode", 11, 9);
    private static final TField APPLEID_FIELD_DESC = new TField("appleid", 2, 10);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new AuthInfoStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new AuthInfoTupleSchemeFactory();
    @Nullable
    private String userName;
    @Nullable
    private String password;
    @Nullable
    private String privExt;
    @Nullable
    private String clientIP;
    @Nullable
    private String userAgent;
    @Nullable
    private String clientHostname;
    private boolean oauth;
    @Nullable
    private String email;
    @Nullable
    private String passcode;
    private boolean appleid;
    private static final int __OAUTH_ISSET_ID = 0;
    private static final int __APPLEID_ISSET_ID = 1;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public AuthInfo() {
    }

    public AuthInfo(String string, String string2, String string3, String string4, String string5, String string6, boolean bl, String string7, String string8, boolean bl2) {
        this();
        this.userName = string;
        this.password = string2;
        this.privExt = string3;
        this.clientIP = string4;
        this.userAgent = string5;
        this.clientHostname = string6;
        this.oauth = bl;
        this.setOauthIsSet(true);
        this.email = string7;
        this.passcode = string8;
        this.appleid = bl2;
        this.setAppleidIsSet(true);
    }

    public AuthInfo(AuthInfo authInfo) {
        this.__isset_bitfield = authInfo.__isset_bitfield;
        if (authInfo.isSetUserName()) {
            this.userName = authInfo.userName;
        }
        if (authInfo.isSetPassword()) {
            this.password = authInfo.password;
        }
        if (authInfo.isSetPrivExt()) {
            this.privExt = authInfo.privExt;
        }
        if (authInfo.isSetClientIP()) {
            this.clientIP = authInfo.clientIP;
        }
        if (authInfo.isSetUserAgent()) {
            this.userAgent = authInfo.userAgent;
        }
        if (authInfo.isSetClientHostname()) {
            this.clientHostname = authInfo.clientHostname;
        }
        this.oauth = authInfo.oauth;
        if (authInfo.isSetEmail()) {
            this.email = authInfo.email;
        }
        if (authInfo.isSetPasscode()) {
            this.passcode = authInfo.passcode;
        }
        this.appleid = authInfo.appleid;
    }

    public AuthInfo deepCopy() {
        return new AuthInfo(this);
    }

    public void clear() {
        this.userName = null;
        this.password = null;
        this.privExt = null;
        this.clientIP = null;
        this.userAgent = null;
        this.clientHostname = null;
        this.setOauthIsSet(false);
        this.oauth = false;
        this.email = null;
        this.passcode = null;
        this.setAppleidIsSet(false);
        this.appleid = false;
    }

    @Nullable
    public String getUserName() {
        return this.userName;
    }

    public void setUserName(@Nullable String string) {
        this.userName = string;
    }

    public void unsetUserName() {
        this.userName = null;
    }

    public boolean isSetUserName() {
        return this.userName != null;
    }

    public void setUserNameIsSet(boolean bl) {
        if (!bl) {
            this.userName = null;
        }
    }

    @Nullable
    public String getPassword() {
        return this.password;
    }

    public void setPassword(@Nullable String string) {
        this.password = string;
    }

    public void unsetPassword() {
        this.password = null;
    }

    public boolean isSetPassword() {
        return this.password != null;
    }

    public void setPasswordIsSet(boolean bl) {
        if (!bl) {
            this.password = null;
        }
    }

    @Nullable
    public String getPrivExt() {
        return this.privExt;
    }

    public void setPrivExt(@Nullable String string) {
        this.privExt = string;
    }

    public void unsetPrivExt() {
        this.privExt = null;
    }

    public boolean isSetPrivExt() {
        return this.privExt != null;
    }

    public void setPrivExtIsSet(boolean bl) {
        if (!bl) {
            this.privExt = null;
        }
    }

    @Nullable
    public String getClientIP() {
        return this.clientIP;
    }

    public void setClientIP(@Nullable String string) {
        this.clientIP = string;
    }

    public void unsetClientIP() {
        this.clientIP = null;
    }

    public boolean isSetClientIP() {
        return this.clientIP != null;
    }

    public void setClientIPIsSet(boolean bl) {
        if (!bl) {
            this.clientIP = null;
        }
    }

    @Nullable
    public String getUserAgent() {
        return this.userAgent;
    }

    public void setUserAgent(@Nullable String string) {
        this.userAgent = string;
    }

    public void unsetUserAgent() {
        this.userAgent = null;
    }

    public boolean isSetUserAgent() {
        return this.userAgent != null;
    }

    public void setUserAgentIsSet(boolean bl) {
        if (!bl) {
            this.userAgent = null;
        }
    }

    @Nullable
    public String getClientHostname() {
        return this.clientHostname;
    }

    public void setClientHostname(@Nullable String string) {
        this.clientHostname = string;
    }

    public void unsetClientHostname() {
        this.clientHostname = null;
    }

    public boolean isSetClientHostname() {
        return this.clientHostname != null;
    }

    public void setClientHostnameIsSet(boolean bl) {
        if (!bl) {
            this.clientHostname = null;
        }
    }

    public boolean isOauth() {
        return this.oauth;
    }

    public void setOauth(boolean bl) {
        this.oauth = bl;
        this.setOauthIsSet(true);
    }

    public void unsetOauth() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetOauth() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setOauthIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    @Nullable
    public String getEmail() {
        return this.email;
    }

    public void setEmail(@Nullable String string) {
        this.email = string;
    }

    public void unsetEmail() {
        this.email = null;
    }

    public boolean isSetEmail() {
        return this.email != null;
    }

    public void setEmailIsSet(boolean bl) {
        if (!bl) {
            this.email = null;
        }
    }

    @Nullable
    public String getPasscode() {
        return this.passcode;
    }

    public void setPasscode(@Nullable String string) {
        this.passcode = string;
    }

    public void unsetPasscode() {
        this.passcode = null;
    }

    public boolean isSetPasscode() {
        return this.passcode != null;
    }

    public void setPasscodeIsSet(boolean bl) {
        if (!bl) {
            this.passcode = null;
        }
    }

    public boolean isAppleid() {
        return this.appleid;
    }

    public void setAppleid(boolean bl) {
        this.appleid = bl;
        this.setAppleidIsSet(true);
    }

    public void unsetAppleid() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)1);
    }

    public boolean isSetAppleid() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)1);
    }

    public void setAppleidIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)1, (boolean)bl);
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetUserName();
                    break;
                }
                this.setUserName((String)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetPassword();
                    break;
                }
                this.setPassword((String)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetPrivExt();
                    break;
                }
                this.setPrivExt((String)object);
                break;
            }
            case 3: {
                if (object == null) {
                    this.unsetClientIP();
                    break;
                }
                this.setClientIP((String)object);
                break;
            }
            case 4: {
                if (object == null) {
                    this.unsetUserAgent();
                    break;
                }
                this.setUserAgent((String)object);
                break;
            }
            case 5: {
                if (object == null) {
                    this.unsetClientHostname();
                    break;
                }
                this.setClientHostname((String)object);
                break;
            }
            case 6: {
                if (object == null) {
                    this.unsetOauth();
                    break;
                }
                this.setOauth((Boolean)object);
                break;
            }
            case 7: {
                if (object == null) {
                    this.unsetEmail();
                    break;
                }
                this.setEmail((String)object);
                break;
            }
            case 8: {
                if (object == null) {
                    this.unsetPasscode();
                    break;
                }
                this.setPasscode((String)object);
                break;
            }
            case 9: {
                if (object == null) {
                    this.unsetAppleid();
                    break;
                }
                this.setAppleid((Boolean)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getUserName();
            }
            case 1: {
                return this.getPassword();
            }
            case 2: {
                return this.getPrivExt();
            }
            case 3: {
                return this.getClientIP();
            }
            case 4: {
                return this.getUserAgent();
            }
            case 5: {
                return this.getClientHostname();
            }
            case 6: {
                return this.isOauth();
            }
            case 7: {
                return this.getEmail();
            }
            case 8: {
                return this.getPasscode();
            }
            case 9: {
                return this.isAppleid();
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
                return this.isSetUserName();
            }
            case 1: {
                return this.isSetPassword();
            }
            case 2: {
                return this.isSetPrivExt();
            }
            case 3: {
                return this.isSetClientIP();
            }
            case 4: {
                return this.isSetUserAgent();
            }
            case 5: {
                return this.isSetClientHostname();
            }
            case 6: {
                return this.isSetOauth();
            }
            case 7: {
                return this.isSetEmail();
            }
            case 8: {
                return this.isSetPasscode();
            }
            case 9: {
                return this.isSetAppleid();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof AuthInfo) {
            return this.equals((AuthInfo)object);
        }
        return false;
    }

    public boolean equals(AuthInfo authInfo) {
        if (authInfo == null) {
            return false;
        }
        if (this == authInfo) {
            return true;
        }
        boolean bl = this.isSetUserName();
        boolean bl2 = authInfo.isSetUserName();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.userName.equals(authInfo.userName)) {
                return false;
            }
        }
        boolean bl3 = this.isSetPassword();
        boolean bl4 = authInfo.isSetPassword();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.password.equals(authInfo.password)) {
                return false;
            }
        }
        boolean bl5 = this.isSetPrivExt();
        boolean bl6 = authInfo.isSetPrivExt();
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (!this.privExt.equals(authInfo.privExt)) {
                return false;
            }
        }
        boolean bl7 = this.isSetClientIP();
        boolean bl8 = authInfo.isSetClientIP();
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (!this.clientIP.equals(authInfo.clientIP)) {
                return false;
            }
        }
        boolean bl9 = this.isSetUserAgent();
        boolean bl10 = authInfo.isSetUserAgent();
        if (bl9 || bl10) {
            if (!bl9 || !bl10) {
                return false;
            }
            if (!this.userAgent.equals(authInfo.userAgent)) {
                return false;
            }
        }
        boolean bl11 = this.isSetClientHostname();
        boolean bl12 = authInfo.isSetClientHostname();
        if (bl11 || bl12) {
            if (!bl11 || !bl12) {
                return false;
            }
            if (!this.clientHostname.equals(authInfo.clientHostname)) {
                return false;
            }
        }
        boolean bl13 = true;
        boolean bl14 = true;
        if (bl13 || bl14) {
            if (!bl13 || !bl14) {
                return false;
            }
            if (this.oauth != authInfo.oauth) {
                return false;
            }
        }
        boolean bl15 = this.isSetEmail();
        boolean bl16 = authInfo.isSetEmail();
        if (bl15 || bl16) {
            if (!bl15 || !bl16) {
                return false;
            }
            if (!this.email.equals(authInfo.email)) {
                return false;
            }
        }
        boolean bl17 = this.isSetPasscode();
        boolean bl18 = authInfo.isSetPasscode();
        if (bl17 || bl18) {
            if (!bl17 || !bl18) {
                return false;
            }
            if (!this.passcode.equals(authInfo.passcode)) {
                return false;
            }
        }
        boolean bl19 = true;
        boolean bl20 = true;
        if (bl19 || bl20) {
            if (!bl19 || !bl20) {
                return false;
            }
            if (this.appleid != authInfo.appleid) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetUserName() ? 131071 : 524287);
        if (this.isSetUserName()) {
            n = n * 8191 + this.userName.hashCode();
        }
        n = n * 8191 + (this.isSetPassword() ? 131071 : 524287);
        if (this.isSetPassword()) {
            n = n * 8191 + this.password.hashCode();
        }
        n = n * 8191 + (this.isSetPrivExt() ? 131071 : 524287);
        if (this.isSetPrivExt()) {
            n = n * 8191 + this.privExt.hashCode();
        }
        n = n * 8191 + (this.isSetClientIP() ? 131071 : 524287);
        if (this.isSetClientIP()) {
            n = n * 8191 + this.clientIP.hashCode();
        }
        n = n * 8191 + (this.isSetUserAgent() ? 131071 : 524287);
        if (this.isSetUserAgent()) {
            n = n * 8191 + this.userAgent.hashCode();
        }
        n = n * 8191 + (this.isSetClientHostname() ? 131071 : 524287);
        if (this.isSetClientHostname()) {
            n = n * 8191 + this.clientHostname.hashCode();
        }
        n = n * 8191 + (this.oauth ? 131071 : 524287);
        n = n * 8191 + (this.isSetEmail() ? 131071 : 524287);
        if (this.isSetEmail()) {
            n = n * 8191 + this.email.hashCode();
        }
        n = n * 8191 + (this.isSetPasscode() ? 131071 : 524287);
        if (this.isSetPasscode()) {
            n = n * 8191 + this.passcode.hashCode();
        }
        n = n * 8191 + (this.appleid ? 131071 : 524287);
        return n;
    }

    @Override
    public int compareTo(AuthInfo authInfo) {
        if (!this.getClass().equals(authInfo.getClass())) {
            return this.getClass().getName().compareTo(authInfo.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetUserName(), authInfo.isSetUserName());
        if (n != 0) {
            return n;
        }
        if (this.isSetUserName() && (n = TBaseHelper.compareTo((String)this.userName, (String)authInfo.userName)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetPassword(), authInfo.isSetPassword());
        if (n != 0) {
            return n;
        }
        if (this.isSetPassword() && (n = TBaseHelper.compareTo((String)this.password, (String)authInfo.password)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetPrivExt(), authInfo.isSetPrivExt());
        if (n != 0) {
            return n;
        }
        if (this.isSetPrivExt() && (n = TBaseHelper.compareTo((String)this.privExt, (String)authInfo.privExt)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetClientIP(), authInfo.isSetClientIP());
        if (n != 0) {
            return n;
        }
        if (this.isSetClientIP() && (n = TBaseHelper.compareTo((String)this.clientIP, (String)authInfo.clientIP)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetUserAgent(), authInfo.isSetUserAgent());
        if (n != 0) {
            return n;
        }
        if (this.isSetUserAgent() && (n = TBaseHelper.compareTo((String)this.userAgent, (String)authInfo.userAgent)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetClientHostname(), authInfo.isSetClientHostname());
        if (n != 0) {
            return n;
        }
        if (this.isSetClientHostname() && (n = TBaseHelper.compareTo((String)this.clientHostname, (String)authInfo.clientHostname)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetOauth(), authInfo.isSetOauth());
        if (n != 0) {
            return n;
        }
        if (this.isSetOauth() && (n = TBaseHelper.compareTo((boolean)this.oauth, (boolean)authInfo.oauth)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetEmail(), authInfo.isSetEmail());
        if (n != 0) {
            return n;
        }
        if (this.isSetEmail() && (n = TBaseHelper.compareTo((String)this.email, (String)authInfo.email)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetPasscode(), authInfo.isSetPasscode());
        if (n != 0) {
            return n;
        }
        if (this.isSetPasscode() && (n = TBaseHelper.compareTo((String)this.passcode, (String)authInfo.passcode)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetAppleid(), authInfo.isSetAppleid());
        if (n != 0) {
            return n;
        }
        if (this.isSetAppleid() && (n = TBaseHelper.compareTo((boolean)this.appleid, (boolean)authInfo.appleid)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        AuthInfo.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        AuthInfo.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("AuthInfo(");
        boolean bl = true;
        stringBuilder.append("userName:");
        if (this.userName == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.userName);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("password:");
        if (this.password == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.password);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("privExt:");
        if (this.privExt == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.privExt);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("clientIP:");
        if (this.clientIP == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.clientIP);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("userAgent:");
        if (this.userAgent == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.userAgent);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("clientHostname:");
        if (this.clientHostname == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.clientHostname);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("oauth:");
        stringBuilder.append(this.oauth);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("email:");
        if (this.email == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.email);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("passcode:");
        if (this.passcode == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.passcode);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("appleid:");
        stringBuilder.append(this.appleid);
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
        enumMap.put(_Fields.USER_NAME, new FieldMetaData("userName", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.PASSWORD, new FieldMetaData("password", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.PRIV_EXT, new FieldMetaData("privExt", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.CLIENT_IP, new FieldMetaData("clientIP", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.USER_AGENT, new FieldMetaData("userAgent", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.CLIENT_HOSTNAME, new FieldMetaData("clientHostname", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.OAUTH, new FieldMetaData("oauth", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.EMAIL, new FieldMetaData("email", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.PASSCODE, new FieldMetaData("passcode", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.APPLEID, new FieldMetaData("appleid", 3, new FieldValueMetaData(2)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(AuthInfo.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        USER_NAME(1, "userName"),
        PASSWORD(2, "password"),
        PRIV_EXT(3, "privExt"),
        CLIENT_IP(4, "clientIP"),
        USER_AGENT(5, "userAgent"),
        CLIENT_HOSTNAME(6, "clientHostname"),
        OAUTH(7, "oauth"),
        EMAIL(8, "email"),
        PASSCODE(9, "passcode"),
        APPLEID(10, "appleid");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return USER_NAME;
                }
                case 2: {
                    return PASSWORD;
                }
                case 3: {
                    return PRIV_EXT;
                }
                case 4: {
                    return CLIENT_IP;
                }
                case 5: {
                    return USER_AGENT;
                }
                case 6: {
                    return CLIENT_HOSTNAME;
                }
                case 7: {
                    return OAUTH;
                }
                case 8: {
                    return EMAIL;
                }
                case 9: {
                    return PASSCODE;
                }
                case 10: {
                    return APPLEID;
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

    private static class AuthInfoStandardSchemeFactory
    implements SchemeFactory {
        private AuthInfoStandardSchemeFactory() {
        }

        public AuthInfoStandardScheme getScheme() {
            return new AuthInfoStandardScheme();
        }
    }

    private static class AuthInfoTupleSchemeFactory
    implements SchemeFactory {
        private AuthInfoTupleSchemeFactory() {
        }

        public AuthInfoTupleScheme getScheme() {
            return new AuthInfoTupleScheme();
        }
    }

    private static class AuthInfoTupleScheme
    extends TupleScheme<AuthInfo> {
        private AuthInfoTupleScheme() {
        }

        public void write(TProtocol tProtocol, AuthInfo authInfo) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (authInfo.isSetUserName()) {
                bitSet.set(0);
            }
            if (authInfo.isSetPassword()) {
                bitSet.set(1);
            }
            if (authInfo.isSetPrivExt()) {
                bitSet.set(2);
            }
            if (authInfo.isSetClientIP()) {
                bitSet.set(3);
            }
            if (authInfo.isSetUserAgent()) {
                bitSet.set(4);
            }
            if (authInfo.isSetClientHostname()) {
                bitSet.set(5);
            }
            if (authInfo.isSetOauth()) {
                bitSet.set(6);
            }
            if (authInfo.isSetEmail()) {
                bitSet.set(7);
            }
            if (authInfo.isSetPasscode()) {
                bitSet.set(8);
            }
            if (authInfo.isSetAppleid()) {
                bitSet.set(9);
            }
            tTupleProtocol.writeBitSet(bitSet, 10);
            if (authInfo.isSetUserName()) {
                tTupleProtocol.writeString(authInfo.userName);
            }
            if (authInfo.isSetPassword()) {
                tTupleProtocol.writeString(authInfo.password);
            }
            if (authInfo.isSetPrivExt()) {
                tTupleProtocol.writeString(authInfo.privExt);
            }
            if (authInfo.isSetClientIP()) {
                tTupleProtocol.writeString(authInfo.clientIP);
            }
            if (authInfo.isSetUserAgent()) {
                tTupleProtocol.writeString(authInfo.userAgent);
            }
            if (authInfo.isSetClientHostname()) {
                tTupleProtocol.writeString(authInfo.clientHostname);
            }
            if (authInfo.isSetOauth()) {
                tTupleProtocol.writeBool(authInfo.oauth);
            }
            if (authInfo.isSetEmail()) {
                tTupleProtocol.writeString(authInfo.email);
            }
            if (authInfo.isSetPasscode()) {
                tTupleProtocol.writeString(authInfo.passcode);
            }
            if (authInfo.isSetAppleid()) {
                tTupleProtocol.writeBool(authInfo.appleid);
            }
        }

        public void read(TProtocol tProtocol, AuthInfo authInfo) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(10);
            if (bitSet.get(0)) {
                authInfo.userName = tTupleProtocol.readString();
                authInfo.setUserNameIsSet(true);
            }
            if (bitSet.get(1)) {
                authInfo.password = tTupleProtocol.readString();
                authInfo.setPasswordIsSet(true);
            }
            if (bitSet.get(2)) {
                authInfo.privExt = tTupleProtocol.readString();
                authInfo.setPrivExtIsSet(true);
            }
            if (bitSet.get(3)) {
                authInfo.clientIP = tTupleProtocol.readString();
                authInfo.setClientIPIsSet(true);
            }
            if (bitSet.get(4)) {
                authInfo.userAgent = tTupleProtocol.readString();
                authInfo.setUserAgentIsSet(true);
            }
            if (bitSet.get(5)) {
                authInfo.clientHostname = tTupleProtocol.readString();
                authInfo.setClientHostnameIsSet(true);
            }
            if (bitSet.get(6)) {
                authInfo.oauth = tTupleProtocol.readBool();
                authInfo.setOauthIsSet(true);
            }
            if (bitSet.get(7)) {
                authInfo.email = tTupleProtocol.readString();
                authInfo.setEmailIsSet(true);
            }
            if (bitSet.get(8)) {
                authInfo.passcode = tTupleProtocol.readString();
                authInfo.setPasscodeIsSet(true);
            }
            if (bitSet.get(9)) {
                authInfo.appleid = tTupleProtocol.readBool();
                authInfo.setAppleidIsSet(true);
            }
        }
    }

    private static class AuthInfoStandardScheme
    extends StandardScheme<AuthInfo> {
        private AuthInfoStandardScheme() {
        }

        public void read(TProtocol tProtocol, AuthInfo authInfo) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 11) {
                            authInfo.userName = tProtocol.readString();
                            authInfo.setUserNameIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 11) {
                            authInfo.password = tProtocol.readString();
                            authInfo.setPasswordIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 11) {
                            authInfo.privExt = tProtocol.readString();
                            authInfo.setPrivExtIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 11) {
                            authInfo.clientIP = tProtocol.readString();
                            authInfo.setClientIPIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 5: {
                        if (tField.type == 11) {
                            authInfo.userAgent = tProtocol.readString();
                            authInfo.setUserAgentIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 6: {
                        if (tField.type == 11) {
                            authInfo.clientHostname = tProtocol.readString();
                            authInfo.setClientHostnameIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 7: {
                        if (tField.type == 2) {
                            authInfo.oauth = tProtocol.readBool();
                            authInfo.setOauthIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 8: {
                        if (tField.type == 11) {
                            authInfo.email = tProtocol.readString();
                            authInfo.setEmailIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 9: {
                        if (tField.type == 11) {
                            authInfo.passcode = tProtocol.readString();
                            authInfo.setPasscodeIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 10: {
                        if (tField.type == 2) {
                            authInfo.appleid = tProtocol.readBool();
                            authInfo.setAppleidIsSet(true);
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
            authInfo.validate();
        }

        public void write(TProtocol tProtocol, AuthInfo authInfo) throws TException {
            authInfo.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (authInfo.userName != null) {
                tProtocol.writeFieldBegin(USER_NAME_FIELD_DESC);
                tProtocol.writeString(authInfo.userName);
                tProtocol.writeFieldEnd();
            }
            if (authInfo.password != null) {
                tProtocol.writeFieldBegin(PASSWORD_FIELD_DESC);
                tProtocol.writeString(authInfo.password);
                tProtocol.writeFieldEnd();
            }
            if (authInfo.privExt != null) {
                tProtocol.writeFieldBegin(PRIV_EXT_FIELD_DESC);
                tProtocol.writeString(authInfo.privExt);
                tProtocol.writeFieldEnd();
            }
            if (authInfo.clientIP != null) {
                tProtocol.writeFieldBegin(CLIENT_IP_FIELD_DESC);
                tProtocol.writeString(authInfo.clientIP);
                tProtocol.writeFieldEnd();
            }
            if (authInfo.userAgent != null) {
                tProtocol.writeFieldBegin(USER_AGENT_FIELD_DESC);
                tProtocol.writeString(authInfo.userAgent);
                tProtocol.writeFieldEnd();
            }
            if (authInfo.clientHostname != null) {
                tProtocol.writeFieldBegin(CLIENT_HOSTNAME_FIELD_DESC);
                tProtocol.writeString(authInfo.clientHostname);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(OAUTH_FIELD_DESC);
            tProtocol.writeBool(authInfo.oauth);
            tProtocol.writeFieldEnd();
            if (authInfo.email != null) {
                tProtocol.writeFieldBegin(EMAIL_FIELD_DESC);
                tProtocol.writeString(authInfo.email);
                tProtocol.writeFieldEnd();
            }
            if (authInfo.passcode != null) {
                tProtocol.writeFieldBegin(PASSCODE_FIELD_DESC);
                tProtocol.writeString(authInfo.passcode);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(APPLEID_FIELD_DESC);
            tProtocol.writeBool(authInfo.appleid);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

