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

public class Credentials
implements TBase<Credentials, _Fields>,
Serializable,
Cloneable,
Comparable<Credentials> {
    private static final TStruct STRUCT_DESC = new TStruct("Credentials");
    private static final TField USERNAME_FIELD_DESC = new TField("username", 11, 1);
    private static final TField PASSWORD_FIELD_DESC = new TField("password", 11, 2);
    private static final TField EMAIL_FIELD_DESC = new TField("email", 11, 3);
    private static final TField PASSCODE_FIELD_DESC = new TField("passcode", 11, 4);
    private static final TField GUEST_FIELD_DESC = new TField("guest", 2, 5);
    private static final TField OAUTH_FIELD_DESC = new TField("oauth", 2, 6);
    private static final TField APPLEID_FIELD_DESC = new TField("appleid", 2, 7);
    private static final TField FMID_FIELD_DESC = new TField("fmid", 2, 8);
    private static final TField VALID_FIELD_DESC = new TField("valid", 2, 9);
    private static final TField DATABASE_FIELD_DESC = new TField("database", 11, 10);
    private static final TField PRIV_EXTENSION_FIELD_DESC = new TField("privExtension", 11, 11);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new CredentialsStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new CredentialsTupleSchemeFactory();
    @Nullable
    private String username;
    @Nullable
    private String password;
    @Nullable
    private String email;
    @Nullable
    private String passcode;
    private boolean guest;
    private boolean oauth;
    private boolean appleid;
    private boolean fmid;
    private boolean valid;
    @Nullable
    private String database;
    @Nullable
    private String privExtension;
    private static final int __GUEST_ISSET_ID = 0;
    private static final int __OAUTH_ISSET_ID = 1;
    private static final int __APPLEID_ISSET_ID = 2;
    private static final int __FMID_ISSET_ID = 3;
    private static final int __VALID_ISSET_ID = 4;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public Credentials() {
    }

    public Credentials(String string, String string2, String string3, String string4, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, String string5, String string6) {
        this();
        this.username = string;
        this.password = string2;
        this.email = string3;
        this.passcode = string4;
        this.guest = bl;
        this.setGuestIsSet(true);
        this.oauth = bl2;
        this.setOauthIsSet(true);
        this.appleid = bl3;
        this.setAppleidIsSet(true);
        this.fmid = bl4;
        this.setFmidIsSet(true);
        this.valid = bl5;
        this.setValidIsSet(true);
        this.database = string5;
        this.privExtension = string6;
    }

    public Credentials(Credentials credentials) {
        this.__isset_bitfield = credentials.__isset_bitfield;
        if (credentials.isSetUsername()) {
            this.username = credentials.username;
        }
        if (credentials.isSetPassword()) {
            this.password = credentials.password;
        }
        if (credentials.isSetEmail()) {
            this.email = credentials.email;
        }
        if (credentials.isSetPasscode()) {
            this.passcode = credentials.passcode;
        }
        this.guest = credentials.guest;
        this.oauth = credentials.oauth;
        this.appleid = credentials.appleid;
        this.fmid = credentials.fmid;
        this.valid = credentials.valid;
        if (credentials.isSetDatabase()) {
            this.database = credentials.database;
        }
        if (credentials.isSetPrivExtension()) {
            this.privExtension = credentials.privExtension;
        }
    }

    public Credentials deepCopy() {
        return new Credentials(this);
    }

    public void clear() {
        this.username = null;
        this.password = null;
        this.email = null;
        this.passcode = null;
        this.setGuestIsSet(false);
        this.guest = false;
        this.setOauthIsSet(false);
        this.oauth = false;
        this.setAppleidIsSet(false);
        this.appleid = false;
        this.setFmidIsSet(false);
        this.fmid = false;
        this.setValidIsSet(false);
        this.valid = false;
        this.database = null;
        this.privExtension = null;
    }

    @Nullable
    public String getUsername() {
        return this.username;
    }

    public void setUsername(@Nullable String string) {
        this.username = string;
    }

    public void unsetUsername() {
        this.username = null;
    }

    public boolean isSetUsername() {
        return this.username != null;
    }

    public void setUsernameIsSet(boolean bl) {
        if (!bl) {
            this.username = null;
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

    public boolean isGuest() {
        return this.guest;
    }

    public void setGuest(boolean bl) {
        this.guest = bl;
        this.setGuestIsSet(true);
    }

    public void unsetGuest() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetGuest() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setGuestIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public boolean isOauth() {
        return this.oauth;
    }

    public void setOauth(boolean bl) {
        this.oauth = bl;
        this.setOauthIsSet(true);
    }

    public void unsetOauth() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)1);
    }

    public boolean isSetOauth() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)1);
    }

    public void setOauthIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)1, (boolean)bl);
    }

    public boolean isAppleid() {
        return this.appleid;
    }

    public void setAppleid(boolean bl) {
        this.appleid = bl;
        this.setAppleidIsSet(true);
    }

    public void unsetAppleid() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)2);
    }

    public boolean isSetAppleid() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)2);
    }

    public void setAppleidIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)2, (boolean)bl);
    }

    public boolean isFmid() {
        return this.fmid;
    }

    public void setFmid(boolean bl) {
        this.fmid = bl;
        this.setFmidIsSet(true);
    }

    public void unsetFmid() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)3);
    }

    public boolean isSetFmid() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)3);
    }

    public void setFmidIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)3, (boolean)bl);
    }

    public boolean isValid() {
        return this.valid;
    }

    public void setValid(boolean bl) {
        this.valid = bl;
        this.setValidIsSet(true);
    }

    public void unsetValid() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)4);
    }

    public boolean isSetValid() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)4);
    }

    public void setValidIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)4, (boolean)bl);
    }

    @Nullable
    public String getDatabase() {
        return this.database;
    }

    public void setDatabase(@Nullable String string) {
        this.database = string;
    }

    public void unsetDatabase() {
        this.database = null;
    }

    public boolean isSetDatabase() {
        return this.database != null;
    }

    public void setDatabaseIsSet(boolean bl) {
        if (!bl) {
            this.database = null;
        }
    }

    @Nullable
    public String getPrivExtension() {
        return this.privExtension;
    }

    public void setPrivExtension(@Nullable String string) {
        this.privExtension = string;
    }

    public void unsetPrivExtension() {
        this.privExtension = null;
    }

    public boolean isSetPrivExtension() {
        return this.privExtension != null;
    }

    public void setPrivExtensionIsSet(boolean bl) {
        if (!bl) {
            this.privExtension = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetUsername();
                    break;
                }
                this.setUsername((String)object);
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
                    this.unsetEmail();
                    break;
                }
                this.setEmail((String)object);
                break;
            }
            case 3: {
                if (object == null) {
                    this.unsetPasscode();
                    break;
                }
                this.setPasscode((String)object);
                break;
            }
            case 4: {
                if (object == null) {
                    this.unsetGuest();
                    break;
                }
                this.setGuest((Boolean)object);
                break;
            }
            case 5: {
                if (object == null) {
                    this.unsetOauth();
                    break;
                }
                this.setOauth((Boolean)object);
                break;
            }
            case 6: {
                if (object == null) {
                    this.unsetAppleid();
                    break;
                }
                this.setAppleid((Boolean)object);
                break;
            }
            case 7: {
                if (object == null) {
                    this.unsetFmid();
                    break;
                }
                this.setFmid((Boolean)object);
                break;
            }
            case 8: {
                if (object == null) {
                    this.unsetValid();
                    break;
                }
                this.setValid((Boolean)object);
                break;
            }
            case 9: {
                if (object == null) {
                    this.unsetDatabase();
                    break;
                }
                this.setDatabase((String)object);
                break;
            }
            case 10: {
                if (object == null) {
                    this.unsetPrivExtension();
                    break;
                }
                this.setPrivExtension((String)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getUsername();
            }
            case 1: {
                return this.getPassword();
            }
            case 2: {
                return this.getEmail();
            }
            case 3: {
                return this.getPasscode();
            }
            case 4: {
                return this.isGuest();
            }
            case 5: {
                return this.isOauth();
            }
            case 6: {
                return this.isAppleid();
            }
            case 7: {
                return this.isFmid();
            }
            case 8: {
                return this.isValid();
            }
            case 9: {
                return this.getDatabase();
            }
            case 10: {
                return this.getPrivExtension();
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
                return this.isSetUsername();
            }
            case 1: {
                return this.isSetPassword();
            }
            case 2: {
                return this.isSetEmail();
            }
            case 3: {
                return this.isSetPasscode();
            }
            case 4: {
                return this.isSetGuest();
            }
            case 5: {
                return this.isSetOauth();
            }
            case 6: {
                return this.isSetAppleid();
            }
            case 7: {
                return this.isSetFmid();
            }
            case 8: {
                return this.isSetValid();
            }
            case 9: {
                return this.isSetDatabase();
            }
            case 10: {
                return this.isSetPrivExtension();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof Credentials) {
            return this.equals((Credentials)object);
        }
        return false;
    }

    public boolean equals(Credentials credentials) {
        if (credentials == null) {
            return false;
        }
        if (this == credentials) {
            return true;
        }
        boolean bl = this.isSetUsername();
        boolean bl2 = credentials.isSetUsername();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.username.equals(credentials.username)) {
                return false;
            }
        }
        boolean bl3 = this.isSetPassword();
        boolean bl4 = credentials.isSetPassword();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.password.equals(credentials.password)) {
                return false;
            }
        }
        boolean bl5 = this.isSetEmail();
        boolean bl6 = credentials.isSetEmail();
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (!this.email.equals(credentials.email)) {
                return false;
            }
        }
        boolean bl7 = this.isSetPasscode();
        boolean bl8 = credentials.isSetPasscode();
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (!this.passcode.equals(credentials.passcode)) {
                return false;
            }
        }
        boolean bl9 = true;
        boolean bl10 = true;
        if (bl9 || bl10) {
            if (!bl9 || !bl10) {
                return false;
            }
            if (this.guest != credentials.guest) {
                return false;
            }
        }
        boolean bl11 = true;
        boolean bl12 = true;
        if (bl11 || bl12) {
            if (!bl11 || !bl12) {
                return false;
            }
            if (this.oauth != credentials.oauth) {
                return false;
            }
        }
        boolean bl13 = true;
        boolean bl14 = true;
        if (bl13 || bl14) {
            if (!bl13 || !bl14) {
                return false;
            }
            if (this.appleid != credentials.appleid) {
                return false;
            }
        }
        boolean bl15 = true;
        boolean bl16 = true;
        if (bl15 || bl16) {
            if (!bl15 || !bl16) {
                return false;
            }
            if (this.fmid != credentials.fmid) {
                return false;
            }
        }
        boolean bl17 = true;
        boolean bl18 = true;
        if (bl17 || bl18) {
            if (!bl17 || !bl18) {
                return false;
            }
            if (this.valid != credentials.valid) {
                return false;
            }
        }
        boolean bl19 = this.isSetDatabase();
        boolean bl20 = credentials.isSetDatabase();
        if (bl19 || bl20) {
            if (!bl19 || !bl20) {
                return false;
            }
            if (!this.database.equals(credentials.database)) {
                return false;
            }
        }
        boolean bl21 = this.isSetPrivExtension();
        boolean bl22 = credentials.isSetPrivExtension();
        if (bl21 || bl22) {
            if (!bl21 || !bl22) {
                return false;
            }
            if (!this.privExtension.equals(credentials.privExtension)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetUsername() ? 131071 : 524287);
        if (this.isSetUsername()) {
            n = n * 8191 + this.username.hashCode();
        }
        n = n * 8191 + (this.isSetPassword() ? 131071 : 524287);
        if (this.isSetPassword()) {
            n = n * 8191 + this.password.hashCode();
        }
        n = n * 8191 + (this.isSetEmail() ? 131071 : 524287);
        if (this.isSetEmail()) {
            n = n * 8191 + this.email.hashCode();
        }
        n = n * 8191 + (this.isSetPasscode() ? 131071 : 524287);
        if (this.isSetPasscode()) {
            n = n * 8191 + this.passcode.hashCode();
        }
        n = n * 8191 + (this.guest ? 131071 : 524287);
        n = n * 8191 + (this.oauth ? 131071 : 524287);
        n = n * 8191 + (this.appleid ? 131071 : 524287);
        n = n * 8191 + (this.fmid ? 131071 : 524287);
        n = n * 8191 + (this.valid ? 131071 : 524287);
        n = n * 8191 + (this.isSetDatabase() ? 131071 : 524287);
        if (this.isSetDatabase()) {
            n = n * 8191 + this.database.hashCode();
        }
        n = n * 8191 + (this.isSetPrivExtension() ? 131071 : 524287);
        if (this.isSetPrivExtension()) {
            n = n * 8191 + this.privExtension.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(Credentials credentials) {
        if (!this.getClass().equals(credentials.getClass())) {
            return this.getClass().getName().compareTo(credentials.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetUsername(), credentials.isSetUsername());
        if (n != 0) {
            return n;
        }
        if (this.isSetUsername() && (n = TBaseHelper.compareTo((String)this.username, (String)credentials.username)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetPassword(), credentials.isSetPassword());
        if (n != 0) {
            return n;
        }
        if (this.isSetPassword() && (n = TBaseHelper.compareTo((String)this.password, (String)credentials.password)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetEmail(), credentials.isSetEmail());
        if (n != 0) {
            return n;
        }
        if (this.isSetEmail() && (n = TBaseHelper.compareTo((String)this.email, (String)credentials.email)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetPasscode(), credentials.isSetPasscode());
        if (n != 0) {
            return n;
        }
        if (this.isSetPasscode() && (n = TBaseHelper.compareTo((String)this.passcode, (String)credentials.passcode)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetGuest(), credentials.isSetGuest());
        if (n != 0) {
            return n;
        }
        if (this.isSetGuest() && (n = TBaseHelper.compareTo((boolean)this.guest, (boolean)credentials.guest)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetOauth(), credentials.isSetOauth());
        if (n != 0) {
            return n;
        }
        if (this.isSetOauth() && (n = TBaseHelper.compareTo((boolean)this.oauth, (boolean)credentials.oauth)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetAppleid(), credentials.isSetAppleid());
        if (n != 0) {
            return n;
        }
        if (this.isSetAppleid() && (n = TBaseHelper.compareTo((boolean)this.appleid, (boolean)credentials.appleid)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetFmid(), credentials.isSetFmid());
        if (n != 0) {
            return n;
        }
        if (this.isSetFmid() && (n = TBaseHelper.compareTo((boolean)this.fmid, (boolean)credentials.fmid)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetValid(), credentials.isSetValid());
        if (n != 0) {
            return n;
        }
        if (this.isSetValid() && (n = TBaseHelper.compareTo((boolean)this.valid, (boolean)credentials.valid)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetDatabase(), credentials.isSetDatabase());
        if (n != 0) {
            return n;
        }
        if (this.isSetDatabase() && (n = TBaseHelper.compareTo((String)this.database, (String)credentials.database)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetPrivExtension(), credentials.isSetPrivExtension());
        if (n != 0) {
            return n;
        }
        if (this.isSetPrivExtension() && (n = TBaseHelper.compareTo((String)this.privExtension, (String)credentials.privExtension)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        Credentials.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        Credentials.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Credentials(");
        boolean bl = true;
        stringBuilder.append("username:");
        if (this.username == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.username);
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
        stringBuilder.append("guest:");
        stringBuilder.append(this.guest);
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
        stringBuilder.append("appleid:");
        stringBuilder.append(this.appleid);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("fmid:");
        stringBuilder.append(this.fmid);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("valid:");
        stringBuilder.append(this.valid);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("database:");
        if (this.database == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.database);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("privExtension:");
        if (this.privExtension == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.privExtension);
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
        enumMap.put(_Fields.USERNAME, new FieldMetaData("username", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.PASSWORD, new FieldMetaData("password", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.EMAIL, new FieldMetaData("email", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.PASSCODE, new FieldMetaData("passcode", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.GUEST, new FieldMetaData("guest", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.OAUTH, new FieldMetaData("oauth", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.APPLEID, new FieldMetaData("appleid", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.FMID, new FieldMetaData("fmid", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.VALID, new FieldMetaData("valid", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.DATABASE, new FieldMetaData("database", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.PRIV_EXTENSION, new FieldMetaData("privExtension", 3, new FieldValueMetaData(11)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(Credentials.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        USERNAME(1, "username"),
        PASSWORD(2, "password"),
        EMAIL(3, "email"),
        PASSCODE(4, "passcode"),
        GUEST(5, "guest"),
        OAUTH(6, "oauth"),
        APPLEID(7, "appleid"),
        FMID(8, "fmid"),
        VALID(9, "valid"),
        DATABASE(10, "database"),
        PRIV_EXTENSION(11, "privExtension");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return USERNAME;
                }
                case 2: {
                    return PASSWORD;
                }
                case 3: {
                    return EMAIL;
                }
                case 4: {
                    return PASSCODE;
                }
                case 5: {
                    return GUEST;
                }
                case 6: {
                    return OAUTH;
                }
                case 7: {
                    return APPLEID;
                }
                case 8: {
                    return FMID;
                }
                case 9: {
                    return VALID;
                }
                case 10: {
                    return DATABASE;
                }
                case 11: {
                    return PRIV_EXTENSION;
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

    private static class CredentialsStandardSchemeFactory
    implements SchemeFactory {
        private CredentialsStandardSchemeFactory() {
        }

        public CredentialsStandardScheme getScheme() {
            return new CredentialsStandardScheme();
        }
    }

    private static class CredentialsTupleSchemeFactory
    implements SchemeFactory {
        private CredentialsTupleSchemeFactory() {
        }

        public CredentialsTupleScheme getScheme() {
            return new CredentialsTupleScheme();
        }
    }

    private static class CredentialsTupleScheme
    extends TupleScheme<Credentials> {
        private CredentialsTupleScheme() {
        }

        public void write(TProtocol tProtocol, Credentials credentials) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (credentials.isSetUsername()) {
                bitSet.set(0);
            }
            if (credentials.isSetPassword()) {
                bitSet.set(1);
            }
            if (credentials.isSetEmail()) {
                bitSet.set(2);
            }
            if (credentials.isSetPasscode()) {
                bitSet.set(3);
            }
            if (credentials.isSetGuest()) {
                bitSet.set(4);
            }
            if (credentials.isSetOauth()) {
                bitSet.set(5);
            }
            if (credentials.isSetAppleid()) {
                bitSet.set(6);
            }
            if (credentials.isSetFmid()) {
                bitSet.set(7);
            }
            if (credentials.isSetValid()) {
                bitSet.set(8);
            }
            if (credentials.isSetDatabase()) {
                bitSet.set(9);
            }
            if (credentials.isSetPrivExtension()) {
                bitSet.set(10);
            }
            tTupleProtocol.writeBitSet(bitSet, 11);
            if (credentials.isSetUsername()) {
                tTupleProtocol.writeString(credentials.username);
            }
            if (credentials.isSetPassword()) {
                tTupleProtocol.writeString(credentials.password);
            }
            if (credentials.isSetEmail()) {
                tTupleProtocol.writeString(credentials.email);
            }
            if (credentials.isSetPasscode()) {
                tTupleProtocol.writeString(credentials.passcode);
            }
            if (credentials.isSetGuest()) {
                tTupleProtocol.writeBool(credentials.guest);
            }
            if (credentials.isSetOauth()) {
                tTupleProtocol.writeBool(credentials.oauth);
            }
            if (credentials.isSetAppleid()) {
                tTupleProtocol.writeBool(credentials.appleid);
            }
            if (credentials.isSetFmid()) {
                tTupleProtocol.writeBool(credentials.fmid);
            }
            if (credentials.isSetValid()) {
                tTupleProtocol.writeBool(credentials.valid);
            }
            if (credentials.isSetDatabase()) {
                tTupleProtocol.writeString(credentials.database);
            }
            if (credentials.isSetPrivExtension()) {
                tTupleProtocol.writeString(credentials.privExtension);
            }
        }

        public void read(TProtocol tProtocol, Credentials credentials) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(11);
            if (bitSet.get(0)) {
                credentials.username = tTupleProtocol.readString();
                credentials.setUsernameIsSet(true);
            }
            if (bitSet.get(1)) {
                credentials.password = tTupleProtocol.readString();
                credentials.setPasswordIsSet(true);
            }
            if (bitSet.get(2)) {
                credentials.email = tTupleProtocol.readString();
                credentials.setEmailIsSet(true);
            }
            if (bitSet.get(3)) {
                credentials.passcode = tTupleProtocol.readString();
                credentials.setPasscodeIsSet(true);
            }
            if (bitSet.get(4)) {
                credentials.guest = tTupleProtocol.readBool();
                credentials.setGuestIsSet(true);
            }
            if (bitSet.get(5)) {
                credentials.oauth = tTupleProtocol.readBool();
                credentials.setOauthIsSet(true);
            }
            if (bitSet.get(6)) {
                credentials.appleid = tTupleProtocol.readBool();
                credentials.setAppleidIsSet(true);
            }
            if (bitSet.get(7)) {
                credentials.fmid = tTupleProtocol.readBool();
                credentials.setFmidIsSet(true);
            }
            if (bitSet.get(8)) {
                credentials.valid = tTupleProtocol.readBool();
                credentials.setValidIsSet(true);
            }
            if (bitSet.get(9)) {
                credentials.database = tTupleProtocol.readString();
                credentials.setDatabaseIsSet(true);
            }
            if (bitSet.get(10)) {
                credentials.privExtension = tTupleProtocol.readString();
                credentials.setPrivExtensionIsSet(true);
            }
        }
    }

    private static class CredentialsStandardScheme
    extends StandardScheme<Credentials> {
        private CredentialsStandardScheme() {
        }

        public void read(TProtocol tProtocol, Credentials credentials) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 11) {
                            credentials.username = tProtocol.readString();
                            credentials.setUsernameIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 11) {
                            credentials.password = tProtocol.readString();
                            credentials.setPasswordIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 11) {
                            credentials.email = tProtocol.readString();
                            credentials.setEmailIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 11) {
                            credentials.passcode = tProtocol.readString();
                            credentials.setPasscodeIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 5: {
                        if (tField.type == 2) {
                            credentials.guest = tProtocol.readBool();
                            credentials.setGuestIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 6: {
                        if (tField.type == 2) {
                            credentials.oauth = tProtocol.readBool();
                            credentials.setOauthIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 7: {
                        if (tField.type == 2) {
                            credentials.appleid = tProtocol.readBool();
                            credentials.setAppleidIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 8: {
                        if (tField.type == 2) {
                            credentials.fmid = tProtocol.readBool();
                            credentials.setFmidIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 9: {
                        if (tField.type == 2) {
                            credentials.valid = tProtocol.readBool();
                            credentials.setValidIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 10: {
                        if (tField.type == 11) {
                            credentials.database = tProtocol.readString();
                            credentials.setDatabaseIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 11: {
                        if (tField.type == 11) {
                            credentials.privExtension = tProtocol.readString();
                            credentials.setPrivExtensionIsSet(true);
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
            credentials.validate();
        }

        public void write(TProtocol tProtocol, Credentials credentials) throws TException {
            credentials.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (credentials.username != null) {
                tProtocol.writeFieldBegin(USERNAME_FIELD_DESC);
                tProtocol.writeString(credentials.username);
                tProtocol.writeFieldEnd();
            }
            if (credentials.password != null) {
                tProtocol.writeFieldBegin(PASSWORD_FIELD_DESC);
                tProtocol.writeString(credentials.password);
                tProtocol.writeFieldEnd();
            }
            if (credentials.email != null) {
                tProtocol.writeFieldBegin(EMAIL_FIELD_DESC);
                tProtocol.writeString(credentials.email);
                tProtocol.writeFieldEnd();
            }
            if (credentials.passcode != null) {
                tProtocol.writeFieldBegin(PASSCODE_FIELD_DESC);
                tProtocol.writeString(credentials.passcode);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(GUEST_FIELD_DESC);
            tProtocol.writeBool(credentials.guest);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(OAUTH_FIELD_DESC);
            tProtocol.writeBool(credentials.oauth);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(APPLEID_FIELD_DESC);
            tProtocol.writeBool(credentials.appleid);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(FMID_FIELD_DESC);
            tProtocol.writeBool(credentials.fmid);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(VALID_FIELD_DESC);
            tProtocol.writeBool(credentials.valid);
            tProtocol.writeFieldEnd();
            if (credentials.database != null) {
                tProtocol.writeFieldBegin(DATABASE_FIELD_DESC);
                tProtocol.writeString(credentials.database);
                tProtocol.writeFieldEnd();
            }
            if (credentials.privExtension != null) {
                tProtocol.writeFieldBegin(PRIV_EXTENSION_FIELD_DESC);
                tProtocol.writeString(credentials.privExtension);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

