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

public class LoginResponse
implements TBase<LoginResponse, _Fields>,
Serializable,
Cloneable,
Comparable<LoginResponse> {
    private static final TStruct STRUCT_DESC = new TStruct("LoginResponse");
    private static final TField CONFIRM_FIELD_DESC = new TField("confirm", 2, 1);
    private static final TField GUEST_LOGIN_FIELD_DESC = new TField("guestLogin", 2, 2);
    private static final TField OAUTH_LOGIN_FIELD_DESC = new TField("oauthLogin", 2, 3);
    private static final TField USERNAME_FIELD_DESC = new TField("username", 11, 4);
    private static final TField PASSWORD_FIELD_DESC = new TField("password", 11, 5);
    private static final TField NATIVE_LOGIN_FIELD_DESC = new TField("nativeLogin", 2, 6);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new LoginResponseStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new LoginResponseTupleSchemeFactory();
    private boolean confirm;
    private boolean guestLogin;
    private boolean oauthLogin;
    @Nullable
    private String username;
    @Nullable
    private String password;
    private boolean nativeLogin;
    private static final int __CONFIRM_ISSET_ID = 0;
    private static final int __GUESTLOGIN_ISSET_ID = 1;
    private static final int __OAUTHLOGIN_ISSET_ID = 2;
    private static final int __NATIVELOGIN_ISSET_ID = 3;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public LoginResponse() {
    }

    public LoginResponse(boolean bl, boolean bl2, boolean bl3, String string, String string2, boolean bl4) {
        this();
        this.confirm = bl;
        this.setConfirmIsSet(true);
        this.guestLogin = bl2;
        this.setGuestLoginIsSet(true);
        this.oauthLogin = bl3;
        this.setOauthLoginIsSet(true);
        this.username = string;
        this.password = string2;
        this.nativeLogin = bl4;
        this.setNativeLoginIsSet(true);
    }

    public LoginResponse(LoginResponse loginResponse) {
        this.__isset_bitfield = loginResponse.__isset_bitfield;
        this.confirm = loginResponse.confirm;
        this.guestLogin = loginResponse.guestLogin;
        this.oauthLogin = loginResponse.oauthLogin;
        if (loginResponse.isSetUsername()) {
            this.username = loginResponse.username;
        }
        if (loginResponse.isSetPassword()) {
            this.password = loginResponse.password;
        }
        this.nativeLogin = loginResponse.nativeLogin;
    }

    public LoginResponse deepCopy() {
        return new LoginResponse(this);
    }

    public void clear() {
        this.setConfirmIsSet(false);
        this.confirm = false;
        this.setGuestLoginIsSet(false);
        this.guestLogin = false;
        this.setOauthLoginIsSet(false);
        this.oauthLogin = false;
        this.username = null;
        this.password = null;
        this.setNativeLoginIsSet(false);
        this.nativeLogin = false;
    }

    public boolean isConfirm() {
        return this.confirm;
    }

    public void setConfirm(boolean bl) {
        this.confirm = bl;
        this.setConfirmIsSet(true);
    }

    public void unsetConfirm() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetConfirm() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setConfirmIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public boolean isGuestLogin() {
        return this.guestLogin;
    }

    public void setGuestLogin(boolean bl) {
        this.guestLogin = bl;
        this.setGuestLoginIsSet(true);
    }

    public void unsetGuestLogin() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)1);
    }

    public boolean isSetGuestLogin() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)1);
    }

    public void setGuestLoginIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)1, (boolean)bl);
    }

    public boolean isOauthLogin() {
        return this.oauthLogin;
    }

    public void setOauthLogin(boolean bl) {
        this.oauthLogin = bl;
        this.setOauthLoginIsSet(true);
    }

    public void unsetOauthLogin() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)2);
    }

    public boolean isSetOauthLogin() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)2);
    }

    public void setOauthLoginIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)2, (boolean)bl);
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

    public boolean isNativeLogin() {
        return this.nativeLogin;
    }

    public void setNativeLogin(boolean bl) {
        this.nativeLogin = bl;
        this.setNativeLoginIsSet(true);
    }

    public void unsetNativeLogin() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)3);
    }

    public boolean isSetNativeLogin() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)3);
    }

    public void setNativeLoginIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)3, (boolean)bl);
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetConfirm();
                    break;
                }
                this.setConfirm((Boolean)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetGuestLogin();
                    break;
                }
                this.setGuestLogin((Boolean)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetOauthLogin();
                    break;
                }
                this.setOauthLogin((Boolean)object);
                break;
            }
            case 3: {
                if (object == null) {
                    this.unsetUsername();
                    break;
                }
                this.setUsername((String)object);
                break;
            }
            case 4: {
                if (object == null) {
                    this.unsetPassword();
                    break;
                }
                this.setPassword((String)object);
                break;
            }
            case 5: {
                if (object == null) {
                    this.unsetNativeLogin();
                    break;
                }
                this.setNativeLogin((Boolean)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.isConfirm();
            }
            case 1: {
                return this.isGuestLogin();
            }
            case 2: {
                return this.isOauthLogin();
            }
            case 3: {
                return this.getUsername();
            }
            case 4: {
                return this.getPassword();
            }
            case 5: {
                return this.isNativeLogin();
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
                return this.isSetConfirm();
            }
            case 1: {
                return this.isSetGuestLogin();
            }
            case 2: {
                return this.isSetOauthLogin();
            }
            case 3: {
                return this.isSetUsername();
            }
            case 4: {
                return this.isSetPassword();
            }
            case 5: {
                return this.isSetNativeLogin();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof LoginResponse) {
            return this.equals((LoginResponse)object);
        }
        return false;
    }

    public boolean equals(LoginResponse loginResponse) {
        if (loginResponse == null) {
            return false;
        }
        if (this == loginResponse) {
            return true;
        }
        boolean bl = true;
        boolean bl2 = true;
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (this.confirm != loginResponse.confirm) {
                return false;
            }
        }
        boolean bl3 = true;
        boolean bl4 = true;
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (this.guestLogin != loginResponse.guestLogin) {
                return false;
            }
        }
        boolean bl5 = true;
        boolean bl6 = true;
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (this.oauthLogin != loginResponse.oauthLogin) {
                return false;
            }
        }
        boolean bl7 = this.isSetUsername();
        boolean bl8 = loginResponse.isSetUsername();
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (!this.username.equals(loginResponse.username)) {
                return false;
            }
        }
        boolean bl9 = this.isSetPassword();
        boolean bl10 = loginResponse.isSetPassword();
        if (bl9 || bl10) {
            if (!bl9 || !bl10) {
                return false;
            }
            if (!this.password.equals(loginResponse.password)) {
                return false;
            }
        }
        boolean bl11 = true;
        boolean bl12 = true;
        if (bl11 || bl12) {
            if (!bl11 || !bl12) {
                return false;
            }
            if (this.nativeLogin != loginResponse.nativeLogin) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.confirm ? 131071 : 524287);
        n = n * 8191 + (this.guestLogin ? 131071 : 524287);
        n = n * 8191 + (this.oauthLogin ? 131071 : 524287);
        n = n * 8191 + (this.isSetUsername() ? 131071 : 524287);
        if (this.isSetUsername()) {
            n = n * 8191 + this.username.hashCode();
        }
        n = n * 8191 + (this.isSetPassword() ? 131071 : 524287);
        if (this.isSetPassword()) {
            n = n * 8191 + this.password.hashCode();
        }
        n = n * 8191 + (this.nativeLogin ? 131071 : 524287);
        return n;
    }

    @Override
    public int compareTo(LoginResponse loginResponse) {
        if (!this.getClass().equals(loginResponse.getClass())) {
            return this.getClass().getName().compareTo(loginResponse.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetConfirm(), loginResponse.isSetConfirm());
        if (n != 0) {
            return n;
        }
        if (this.isSetConfirm() && (n = TBaseHelper.compareTo((boolean)this.confirm, (boolean)loginResponse.confirm)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetGuestLogin(), loginResponse.isSetGuestLogin());
        if (n != 0) {
            return n;
        }
        if (this.isSetGuestLogin() && (n = TBaseHelper.compareTo((boolean)this.guestLogin, (boolean)loginResponse.guestLogin)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetOauthLogin(), loginResponse.isSetOauthLogin());
        if (n != 0) {
            return n;
        }
        if (this.isSetOauthLogin() && (n = TBaseHelper.compareTo((boolean)this.oauthLogin, (boolean)loginResponse.oauthLogin)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetUsername(), loginResponse.isSetUsername());
        if (n != 0) {
            return n;
        }
        if (this.isSetUsername() && (n = TBaseHelper.compareTo((String)this.username, (String)loginResponse.username)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetPassword(), loginResponse.isSetPassword());
        if (n != 0) {
            return n;
        }
        if (this.isSetPassword() && (n = TBaseHelper.compareTo((String)this.password, (String)loginResponse.password)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetNativeLogin(), loginResponse.isSetNativeLogin());
        if (n != 0) {
            return n;
        }
        if (this.isSetNativeLogin() && (n = TBaseHelper.compareTo((boolean)this.nativeLogin, (boolean)loginResponse.nativeLogin)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        LoginResponse.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        LoginResponse.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("LoginResponse(");
        boolean bl = true;
        stringBuilder.append("confirm:");
        stringBuilder.append(this.confirm);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("guestLogin:");
        stringBuilder.append(this.guestLogin);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("oauthLogin:");
        stringBuilder.append(this.oauthLogin);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
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
        stringBuilder.append("nativeLogin:");
        stringBuilder.append(this.nativeLogin);
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
        enumMap.put(_Fields.CONFIRM, new FieldMetaData("confirm", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.GUEST_LOGIN, new FieldMetaData("guestLogin", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.OAUTH_LOGIN, new FieldMetaData("oauthLogin", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.USERNAME, new FieldMetaData("username", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.PASSWORD, new FieldMetaData("password", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.NATIVE_LOGIN, new FieldMetaData("nativeLogin", 3, new FieldValueMetaData(2)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(LoginResponse.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        CONFIRM(1, "confirm"),
        GUEST_LOGIN(2, "guestLogin"),
        OAUTH_LOGIN(3, "oauthLogin"),
        USERNAME(4, "username"),
        PASSWORD(5, "password"),
        NATIVE_LOGIN(6, "nativeLogin");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return CONFIRM;
                }
                case 2: {
                    return GUEST_LOGIN;
                }
                case 3: {
                    return OAUTH_LOGIN;
                }
                case 4: {
                    return USERNAME;
                }
                case 5: {
                    return PASSWORD;
                }
                case 6: {
                    return NATIVE_LOGIN;
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

    private static class LoginResponseStandardSchemeFactory
    implements SchemeFactory {
        private LoginResponseStandardSchemeFactory() {
        }

        public LoginResponseStandardScheme getScheme() {
            return new LoginResponseStandardScheme();
        }
    }

    private static class LoginResponseTupleSchemeFactory
    implements SchemeFactory {
        private LoginResponseTupleSchemeFactory() {
        }

        public LoginResponseTupleScheme getScheme() {
            return new LoginResponseTupleScheme();
        }
    }

    private static class LoginResponseTupleScheme
    extends TupleScheme<LoginResponse> {
        private LoginResponseTupleScheme() {
        }

        public void write(TProtocol tProtocol, LoginResponse loginResponse) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (loginResponse.isSetConfirm()) {
                bitSet.set(0);
            }
            if (loginResponse.isSetGuestLogin()) {
                bitSet.set(1);
            }
            if (loginResponse.isSetOauthLogin()) {
                bitSet.set(2);
            }
            if (loginResponse.isSetUsername()) {
                bitSet.set(3);
            }
            if (loginResponse.isSetPassword()) {
                bitSet.set(4);
            }
            if (loginResponse.isSetNativeLogin()) {
                bitSet.set(5);
            }
            tTupleProtocol.writeBitSet(bitSet, 6);
            if (loginResponse.isSetConfirm()) {
                tTupleProtocol.writeBool(loginResponse.confirm);
            }
            if (loginResponse.isSetGuestLogin()) {
                tTupleProtocol.writeBool(loginResponse.guestLogin);
            }
            if (loginResponse.isSetOauthLogin()) {
                tTupleProtocol.writeBool(loginResponse.oauthLogin);
            }
            if (loginResponse.isSetUsername()) {
                tTupleProtocol.writeString(loginResponse.username);
            }
            if (loginResponse.isSetPassword()) {
                tTupleProtocol.writeString(loginResponse.password);
            }
            if (loginResponse.isSetNativeLogin()) {
                tTupleProtocol.writeBool(loginResponse.nativeLogin);
            }
        }

        public void read(TProtocol tProtocol, LoginResponse loginResponse) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(6);
            if (bitSet.get(0)) {
                loginResponse.confirm = tTupleProtocol.readBool();
                loginResponse.setConfirmIsSet(true);
            }
            if (bitSet.get(1)) {
                loginResponse.guestLogin = tTupleProtocol.readBool();
                loginResponse.setGuestLoginIsSet(true);
            }
            if (bitSet.get(2)) {
                loginResponse.oauthLogin = tTupleProtocol.readBool();
                loginResponse.setOauthLoginIsSet(true);
            }
            if (bitSet.get(3)) {
                loginResponse.username = tTupleProtocol.readString();
                loginResponse.setUsernameIsSet(true);
            }
            if (bitSet.get(4)) {
                loginResponse.password = tTupleProtocol.readString();
                loginResponse.setPasswordIsSet(true);
            }
            if (bitSet.get(5)) {
                loginResponse.nativeLogin = tTupleProtocol.readBool();
                loginResponse.setNativeLoginIsSet(true);
            }
        }
    }

    private static class LoginResponseStandardScheme
    extends StandardScheme<LoginResponse> {
        private LoginResponseStandardScheme() {
        }

        public void read(TProtocol tProtocol, LoginResponse loginResponse) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 2) {
                            loginResponse.confirm = tProtocol.readBool();
                            loginResponse.setConfirmIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 2) {
                            loginResponse.guestLogin = tProtocol.readBool();
                            loginResponse.setGuestLoginIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 2) {
                            loginResponse.oauthLogin = tProtocol.readBool();
                            loginResponse.setOauthLoginIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 11) {
                            loginResponse.username = tProtocol.readString();
                            loginResponse.setUsernameIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 5: {
                        if (tField.type == 11) {
                            loginResponse.password = tProtocol.readString();
                            loginResponse.setPasswordIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 6: {
                        if (tField.type == 2) {
                            loginResponse.nativeLogin = tProtocol.readBool();
                            loginResponse.setNativeLoginIsSet(true);
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
            loginResponse.validate();
        }

        public void write(TProtocol tProtocol, LoginResponse loginResponse) throws TException {
            loginResponse.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            tProtocol.writeFieldBegin(CONFIRM_FIELD_DESC);
            tProtocol.writeBool(loginResponse.confirm);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(GUEST_LOGIN_FIELD_DESC);
            tProtocol.writeBool(loginResponse.guestLogin);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(OAUTH_LOGIN_FIELD_DESC);
            tProtocol.writeBool(loginResponse.oauthLogin);
            tProtocol.writeFieldEnd();
            if (loginResponse.username != null) {
                tProtocol.writeFieldBegin(USERNAME_FIELD_DESC);
                tProtocol.writeString(loginResponse.username);
                tProtocol.writeFieldEnd();
            }
            if (loginResponse.password != null) {
                tProtocol.writeFieldBegin(PASSWORD_FIELD_DESC);
                tProtocol.writeString(loginResponse.password);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(NATIVE_LOGIN_FIELD_DESC);
            tProtocol.writeBool(loginResponse.nativeLogin);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

