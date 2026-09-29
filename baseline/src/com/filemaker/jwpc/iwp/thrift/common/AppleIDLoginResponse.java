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

public class AppleIDLoginResponse
implements TBase<AppleIDLoginResponse, _Fields>,
Serializable,
Cloneable,
Comparable<AppleIDLoginResponse> {
    private static final TStruct STRUCT_DESC = new TStruct("AppleIDLoginResponse");
    private static final TField CONFIRM_FIELD_DESC = new TField("confirm", 2, 1);
    private static final TField SEND_FIELD_DESC = new TField("send", 2, 2);
    private static final TField LOGIN_FIELD_DESC = new TField("login", 2, 3);
    private static final TField EMAIL_FIELD_DESC = new TField("email", 11, 4);
    private static final TField PASSCODE_FIELD_DESC = new TField("passcode", 11, 5);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new AppleIDLoginResponseStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new AppleIDLoginResponseTupleSchemeFactory();
    private boolean confirm;
    private boolean send;
    private boolean login;
    @Nullable
    private String email;
    @Nullable
    private String passcode;
    private static final int __CONFIRM_ISSET_ID = 0;
    private static final int __SEND_ISSET_ID = 1;
    private static final int __LOGIN_ISSET_ID = 2;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public AppleIDLoginResponse() {
    }

    public AppleIDLoginResponse(boolean bl, boolean bl2, boolean bl3, String string, String string2) {
        this();
        this.confirm = bl;
        this.setConfirmIsSet(true);
        this.send = bl2;
        this.setSendIsSet(true);
        this.login = bl3;
        this.setLoginIsSet(true);
        this.email = string;
        this.passcode = string2;
    }

    public AppleIDLoginResponse(AppleIDLoginResponse appleIDLoginResponse) {
        this.__isset_bitfield = appleIDLoginResponse.__isset_bitfield;
        this.confirm = appleIDLoginResponse.confirm;
        this.send = appleIDLoginResponse.send;
        this.login = appleIDLoginResponse.login;
        if (appleIDLoginResponse.isSetEmail()) {
            this.email = appleIDLoginResponse.email;
        }
        if (appleIDLoginResponse.isSetPasscode()) {
            this.passcode = appleIDLoginResponse.passcode;
        }
    }

    public AppleIDLoginResponse deepCopy() {
        return new AppleIDLoginResponse(this);
    }

    public void clear() {
        this.setConfirmIsSet(false);
        this.confirm = false;
        this.setSendIsSet(false);
        this.send = false;
        this.setLoginIsSet(false);
        this.login = false;
        this.email = null;
        this.passcode = null;
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

    public boolean isSend() {
        return this.send;
    }

    public void setSend(boolean bl) {
        this.send = bl;
        this.setSendIsSet(true);
    }

    public void unsetSend() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)1);
    }

    public boolean isSetSend() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)1);
    }

    public void setSendIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)1, (boolean)bl);
    }

    public boolean isLogin() {
        return this.login;
    }

    public void setLogin(boolean bl) {
        this.login = bl;
        this.setLoginIsSet(true);
    }

    public void unsetLogin() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)2);
    }

    public boolean isSetLogin() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)2);
    }

    public void setLoginIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)2, (boolean)bl);
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
                    this.unsetSend();
                    break;
                }
                this.setSend((Boolean)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetLogin();
                    break;
                }
                this.setLogin((Boolean)object);
                break;
            }
            case 3: {
                if (object == null) {
                    this.unsetEmail();
                    break;
                }
                this.setEmail((String)object);
                break;
            }
            case 4: {
                if (object == null) {
                    this.unsetPasscode();
                    break;
                }
                this.setPasscode((String)object);
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
                return this.isSend();
            }
            case 2: {
                return this.isLogin();
            }
            case 3: {
                return this.getEmail();
            }
            case 4: {
                return this.getPasscode();
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
                return this.isSetSend();
            }
            case 2: {
                return this.isSetLogin();
            }
            case 3: {
                return this.isSetEmail();
            }
            case 4: {
                return this.isSetPasscode();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof AppleIDLoginResponse) {
            return this.equals((AppleIDLoginResponse)object);
        }
        return false;
    }

    public boolean equals(AppleIDLoginResponse appleIDLoginResponse) {
        if (appleIDLoginResponse == null) {
            return false;
        }
        if (this == appleIDLoginResponse) {
            return true;
        }
        boolean bl = true;
        boolean bl2 = true;
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (this.confirm != appleIDLoginResponse.confirm) {
                return false;
            }
        }
        boolean bl3 = true;
        boolean bl4 = true;
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (this.send != appleIDLoginResponse.send) {
                return false;
            }
        }
        boolean bl5 = true;
        boolean bl6 = true;
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (this.login != appleIDLoginResponse.login) {
                return false;
            }
        }
        boolean bl7 = this.isSetEmail();
        boolean bl8 = appleIDLoginResponse.isSetEmail();
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (!this.email.equals(appleIDLoginResponse.email)) {
                return false;
            }
        }
        boolean bl9 = this.isSetPasscode();
        boolean bl10 = appleIDLoginResponse.isSetPasscode();
        if (bl9 || bl10) {
            if (!bl9 || !bl10) {
                return false;
            }
            if (!this.passcode.equals(appleIDLoginResponse.passcode)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.confirm ? 131071 : 524287);
        n = n * 8191 + (this.send ? 131071 : 524287);
        n = n * 8191 + (this.login ? 131071 : 524287);
        n = n * 8191 + (this.isSetEmail() ? 131071 : 524287);
        if (this.isSetEmail()) {
            n = n * 8191 + this.email.hashCode();
        }
        n = n * 8191 + (this.isSetPasscode() ? 131071 : 524287);
        if (this.isSetPasscode()) {
            n = n * 8191 + this.passcode.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(AppleIDLoginResponse appleIDLoginResponse) {
        if (!this.getClass().equals(appleIDLoginResponse.getClass())) {
            return this.getClass().getName().compareTo(appleIDLoginResponse.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetConfirm(), appleIDLoginResponse.isSetConfirm());
        if (n != 0) {
            return n;
        }
        if (this.isSetConfirm() && (n = TBaseHelper.compareTo((boolean)this.confirm, (boolean)appleIDLoginResponse.confirm)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetSend(), appleIDLoginResponse.isSetSend());
        if (n != 0) {
            return n;
        }
        if (this.isSetSend() && (n = TBaseHelper.compareTo((boolean)this.send, (boolean)appleIDLoginResponse.send)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetLogin(), appleIDLoginResponse.isSetLogin());
        if (n != 0) {
            return n;
        }
        if (this.isSetLogin() && (n = TBaseHelper.compareTo((boolean)this.login, (boolean)appleIDLoginResponse.login)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetEmail(), appleIDLoginResponse.isSetEmail());
        if (n != 0) {
            return n;
        }
        if (this.isSetEmail() && (n = TBaseHelper.compareTo((String)this.email, (String)appleIDLoginResponse.email)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetPasscode(), appleIDLoginResponse.isSetPasscode());
        if (n != 0) {
            return n;
        }
        if (this.isSetPasscode() && (n = TBaseHelper.compareTo((String)this.passcode, (String)appleIDLoginResponse.passcode)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        AppleIDLoginResponse.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        AppleIDLoginResponse.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("AppleIDLoginResponse(");
        boolean bl = true;
        stringBuilder.append("confirm:");
        stringBuilder.append(this.confirm);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("send:");
        stringBuilder.append(this.send);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("login:");
        stringBuilder.append(this.login);
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
        enumMap.put(_Fields.SEND, new FieldMetaData("send", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.LOGIN, new FieldMetaData("login", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.EMAIL, new FieldMetaData("email", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.PASSCODE, new FieldMetaData("passcode", 3, new FieldValueMetaData(11)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(AppleIDLoginResponse.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        CONFIRM(1, "confirm"),
        SEND(2, "send"),
        LOGIN(3, "login"),
        EMAIL(4, "email"),
        PASSCODE(5, "passcode");

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
                    return SEND;
                }
                case 3: {
                    return LOGIN;
                }
                case 4: {
                    return EMAIL;
                }
                case 5: {
                    return PASSCODE;
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

    private static class AppleIDLoginResponseStandardSchemeFactory
    implements SchemeFactory {
        private AppleIDLoginResponseStandardSchemeFactory() {
        }

        public AppleIDLoginResponseStandardScheme getScheme() {
            return new AppleIDLoginResponseStandardScheme();
        }
    }

    private static class AppleIDLoginResponseTupleSchemeFactory
    implements SchemeFactory {
        private AppleIDLoginResponseTupleSchemeFactory() {
        }

        public AppleIDLoginResponseTupleScheme getScheme() {
            return new AppleIDLoginResponseTupleScheme();
        }
    }

    private static class AppleIDLoginResponseTupleScheme
    extends TupleScheme<AppleIDLoginResponse> {
        private AppleIDLoginResponseTupleScheme() {
        }

        public void write(TProtocol tProtocol, AppleIDLoginResponse appleIDLoginResponse) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (appleIDLoginResponse.isSetConfirm()) {
                bitSet.set(0);
            }
            if (appleIDLoginResponse.isSetSend()) {
                bitSet.set(1);
            }
            if (appleIDLoginResponse.isSetLogin()) {
                bitSet.set(2);
            }
            if (appleIDLoginResponse.isSetEmail()) {
                bitSet.set(3);
            }
            if (appleIDLoginResponse.isSetPasscode()) {
                bitSet.set(4);
            }
            tTupleProtocol.writeBitSet(bitSet, 5);
            if (appleIDLoginResponse.isSetConfirm()) {
                tTupleProtocol.writeBool(appleIDLoginResponse.confirm);
            }
            if (appleIDLoginResponse.isSetSend()) {
                tTupleProtocol.writeBool(appleIDLoginResponse.send);
            }
            if (appleIDLoginResponse.isSetLogin()) {
                tTupleProtocol.writeBool(appleIDLoginResponse.login);
            }
            if (appleIDLoginResponse.isSetEmail()) {
                tTupleProtocol.writeString(appleIDLoginResponse.email);
            }
            if (appleIDLoginResponse.isSetPasscode()) {
                tTupleProtocol.writeString(appleIDLoginResponse.passcode);
            }
        }

        public void read(TProtocol tProtocol, AppleIDLoginResponse appleIDLoginResponse) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(5);
            if (bitSet.get(0)) {
                appleIDLoginResponse.confirm = tTupleProtocol.readBool();
                appleIDLoginResponse.setConfirmIsSet(true);
            }
            if (bitSet.get(1)) {
                appleIDLoginResponse.send = tTupleProtocol.readBool();
                appleIDLoginResponse.setSendIsSet(true);
            }
            if (bitSet.get(2)) {
                appleIDLoginResponse.login = tTupleProtocol.readBool();
                appleIDLoginResponse.setLoginIsSet(true);
            }
            if (bitSet.get(3)) {
                appleIDLoginResponse.email = tTupleProtocol.readString();
                appleIDLoginResponse.setEmailIsSet(true);
            }
            if (bitSet.get(4)) {
                appleIDLoginResponse.passcode = tTupleProtocol.readString();
                appleIDLoginResponse.setPasscodeIsSet(true);
            }
        }
    }

    private static class AppleIDLoginResponseStandardScheme
    extends StandardScheme<AppleIDLoginResponse> {
        private AppleIDLoginResponseStandardScheme() {
        }

        public void read(TProtocol tProtocol, AppleIDLoginResponse appleIDLoginResponse) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 2) {
                            appleIDLoginResponse.confirm = tProtocol.readBool();
                            appleIDLoginResponse.setConfirmIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 2) {
                            appleIDLoginResponse.send = tProtocol.readBool();
                            appleIDLoginResponse.setSendIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 2) {
                            appleIDLoginResponse.login = tProtocol.readBool();
                            appleIDLoginResponse.setLoginIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 11) {
                            appleIDLoginResponse.email = tProtocol.readString();
                            appleIDLoginResponse.setEmailIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 5: {
                        if (tField.type == 11) {
                            appleIDLoginResponse.passcode = tProtocol.readString();
                            appleIDLoginResponse.setPasscodeIsSet(true);
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
            appleIDLoginResponse.validate();
        }

        public void write(TProtocol tProtocol, AppleIDLoginResponse appleIDLoginResponse) throws TException {
            appleIDLoginResponse.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            tProtocol.writeFieldBegin(CONFIRM_FIELD_DESC);
            tProtocol.writeBool(appleIDLoginResponse.confirm);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(SEND_FIELD_DESC);
            tProtocol.writeBool(appleIDLoginResponse.send);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(LOGIN_FIELD_DESC);
            tProtocol.writeBool(appleIDLoginResponse.login);
            tProtocol.writeFieldEnd();
            if (appleIDLoginResponse.email != null) {
                tProtocol.writeFieldBegin(EMAIL_FIELD_DESC);
                tProtocol.writeString(appleIDLoginResponse.email);
                tProtocol.writeFieldEnd();
            }
            if (appleIDLoginResponse.passcode != null) {
                tProtocol.writeFieldBegin(PASSCODE_FIELD_DESC);
                tProtocol.writeString(appleIDLoginResponse.passcode);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

