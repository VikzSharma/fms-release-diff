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
package com.filemaker.jwpc.iwp.thrift.notification;

import com.filemaker.jwpc.iwp.thrift.common.IWPError;
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

public class ChangePasswordDialogNotification
implements TBase<ChangePasswordDialogNotification, _Fields>,
Serializable,
Cloneable,
Comparable<ChangePasswordDialogNotification> {
    private static final TStruct STRUCT_DESC = new TStruct("ChangePasswordDialogNotification");
    private static final TField USER_NAME_FIELD_DESC = new TField("userName", 11, 1);
    private static final TField PASSWORD_EXPIRED_FIELD_DESC = new TField("passwordExpired", 2, 2);
    private static final TField OLD_PASSWORD_FIELD_DESC = new TField("oldPassword", 11, 3);
    private static final TField NEW_PASSWORD_FIELD_DESC = new TField("newPassword", 11, 4);
    private static final TField ERROR_FIELD_DESC = new TField("error", 12, 5);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new ChangePasswordDialogNotificationStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new ChangePasswordDialogNotificationTupleSchemeFactory();
    @Nullable
    private String userName;
    private boolean passwordExpired;
    @Nullable
    private String oldPassword;
    @Nullable
    private String newPassword;
    @Nullable
    private IWPError error;
    private static final int __PASSWORDEXPIRED_ISSET_ID = 0;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public ChangePasswordDialogNotification() {
    }

    public ChangePasswordDialogNotification(String string, boolean bl, String string2, String string3, IWPError iWPError) {
        this();
        this.userName = string;
        this.passwordExpired = bl;
        this.setPasswordExpiredIsSet(true);
        this.oldPassword = string2;
        this.newPassword = string3;
        this.error = iWPError;
    }

    public ChangePasswordDialogNotification(ChangePasswordDialogNotification changePasswordDialogNotification) {
        this.__isset_bitfield = changePasswordDialogNotification.__isset_bitfield;
        if (changePasswordDialogNotification.isSetUserName()) {
            this.userName = changePasswordDialogNotification.userName;
        }
        this.passwordExpired = changePasswordDialogNotification.passwordExpired;
        if (changePasswordDialogNotification.isSetOldPassword()) {
            this.oldPassword = changePasswordDialogNotification.oldPassword;
        }
        if (changePasswordDialogNotification.isSetNewPassword()) {
            this.newPassword = changePasswordDialogNotification.newPassword;
        }
        if (changePasswordDialogNotification.isSetError()) {
            this.error = new IWPError(changePasswordDialogNotification.error);
        }
    }

    public ChangePasswordDialogNotification deepCopy() {
        return new ChangePasswordDialogNotification(this);
    }

    public void clear() {
        this.userName = null;
        this.setPasswordExpiredIsSet(false);
        this.passwordExpired = false;
        this.oldPassword = null;
        this.newPassword = null;
        this.error = null;
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

    public boolean isPasswordExpired() {
        return this.passwordExpired;
    }

    public void setPasswordExpired(boolean bl) {
        this.passwordExpired = bl;
        this.setPasswordExpiredIsSet(true);
    }

    public void unsetPasswordExpired() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetPasswordExpired() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setPasswordExpiredIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    @Nullable
    public String getOldPassword() {
        return this.oldPassword;
    }

    public void setOldPassword(@Nullable String string) {
        this.oldPassword = string;
    }

    public void unsetOldPassword() {
        this.oldPassword = null;
    }

    public boolean isSetOldPassword() {
        return this.oldPassword != null;
    }

    public void setOldPasswordIsSet(boolean bl) {
        if (!bl) {
            this.oldPassword = null;
        }
    }

    @Nullable
    public String getNewPassword() {
        return this.newPassword;
    }

    public void setNewPassword(@Nullable String string) {
        this.newPassword = string;
    }

    public void unsetNewPassword() {
        this.newPassword = null;
    }

    public boolean isSetNewPassword() {
        return this.newPassword != null;
    }

    public void setNewPasswordIsSet(boolean bl) {
        if (!bl) {
            this.newPassword = null;
        }
    }

    @Nullable
    public IWPError getError() {
        return this.error;
    }

    public void setError(@Nullable IWPError iWPError) {
        this.error = iWPError;
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
                    this.unsetPasswordExpired();
                    break;
                }
                this.setPasswordExpired((Boolean)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetOldPassword();
                    break;
                }
                this.setOldPassword((String)object);
                break;
            }
            case 3: {
                if (object == null) {
                    this.unsetNewPassword();
                    break;
                }
                this.setNewPassword((String)object);
                break;
            }
            case 4: {
                if (object == null) {
                    this.unsetError();
                    break;
                }
                this.setError((IWPError)object);
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
                return this.isPasswordExpired();
            }
            case 2: {
                return this.getOldPassword();
            }
            case 3: {
                return this.getNewPassword();
            }
            case 4: {
                return this.getError();
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
                return this.isSetPasswordExpired();
            }
            case 2: {
                return this.isSetOldPassword();
            }
            case 3: {
                return this.isSetNewPassword();
            }
            case 4: {
                return this.isSetError();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof ChangePasswordDialogNotification) {
            return this.equals((ChangePasswordDialogNotification)object);
        }
        return false;
    }

    public boolean equals(ChangePasswordDialogNotification changePasswordDialogNotification) {
        if (changePasswordDialogNotification == null) {
            return false;
        }
        if (this == changePasswordDialogNotification) {
            return true;
        }
        boolean bl = this.isSetUserName();
        boolean bl2 = changePasswordDialogNotification.isSetUserName();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.userName.equals(changePasswordDialogNotification.userName)) {
                return false;
            }
        }
        boolean bl3 = true;
        boolean bl4 = true;
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (this.passwordExpired != changePasswordDialogNotification.passwordExpired) {
                return false;
            }
        }
        boolean bl5 = this.isSetOldPassword();
        boolean bl6 = changePasswordDialogNotification.isSetOldPassword();
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (!this.oldPassword.equals(changePasswordDialogNotification.oldPassword)) {
                return false;
            }
        }
        boolean bl7 = this.isSetNewPassword();
        boolean bl8 = changePasswordDialogNotification.isSetNewPassword();
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (!this.newPassword.equals(changePasswordDialogNotification.newPassword)) {
                return false;
            }
        }
        boolean bl9 = this.isSetError();
        boolean bl10 = changePasswordDialogNotification.isSetError();
        if (bl9 || bl10) {
            if (!bl9 || !bl10) {
                return false;
            }
            if (!this.error.equals(changePasswordDialogNotification.error)) {
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
        n = n * 8191 + (this.passwordExpired ? 131071 : 524287);
        n = n * 8191 + (this.isSetOldPassword() ? 131071 : 524287);
        if (this.isSetOldPassword()) {
            n = n * 8191 + this.oldPassword.hashCode();
        }
        n = n * 8191 + (this.isSetNewPassword() ? 131071 : 524287);
        if (this.isSetNewPassword()) {
            n = n * 8191 + this.newPassword.hashCode();
        }
        n = n * 8191 + (this.isSetError() ? 131071 : 524287);
        if (this.isSetError()) {
            n = n * 8191 + this.error.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(ChangePasswordDialogNotification changePasswordDialogNotification) {
        if (!this.getClass().equals(changePasswordDialogNotification.getClass())) {
            return this.getClass().getName().compareTo(changePasswordDialogNotification.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetUserName(), changePasswordDialogNotification.isSetUserName());
        if (n != 0) {
            return n;
        }
        if (this.isSetUserName() && (n = TBaseHelper.compareTo((String)this.userName, (String)changePasswordDialogNotification.userName)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetPasswordExpired(), changePasswordDialogNotification.isSetPasswordExpired());
        if (n != 0) {
            return n;
        }
        if (this.isSetPasswordExpired() && (n = TBaseHelper.compareTo((boolean)this.passwordExpired, (boolean)changePasswordDialogNotification.passwordExpired)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetOldPassword(), changePasswordDialogNotification.isSetOldPassword());
        if (n != 0) {
            return n;
        }
        if (this.isSetOldPassword() && (n = TBaseHelper.compareTo((String)this.oldPassword, (String)changePasswordDialogNotification.oldPassword)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetNewPassword(), changePasswordDialogNotification.isSetNewPassword());
        if (n != 0) {
            return n;
        }
        if (this.isSetNewPassword() && (n = TBaseHelper.compareTo((String)this.newPassword, (String)changePasswordDialogNotification.newPassword)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetError(), changePasswordDialogNotification.isSetError());
        if (n != 0) {
            return n;
        }
        if (this.isSetError() && (n = TBaseHelper.compareTo((Comparable)this.error, (Comparable)changePasswordDialogNotification.error)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        ChangePasswordDialogNotification.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        ChangePasswordDialogNotification.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ChangePasswordDialogNotification(");
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
        stringBuilder.append("passwordExpired:");
        stringBuilder.append(this.passwordExpired);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("oldPassword:");
        if (this.oldPassword == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.oldPassword);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("newPassword:");
        if (this.newPassword == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.newPassword);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("error:");
        if (this.error == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.error);
        }
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
        enumMap.put(_Fields.USER_NAME, new FieldMetaData("userName", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.PASSWORD_EXPIRED, new FieldMetaData("passwordExpired", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.OLD_PASSWORD, new FieldMetaData("oldPassword", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.NEW_PASSWORD, new FieldMetaData("newPassword", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.ERROR, new FieldMetaData("error", 3, (FieldValueMetaData)new StructMetaData(12, IWPError.class)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(ChangePasswordDialogNotification.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        USER_NAME(1, "userName"),
        PASSWORD_EXPIRED(2, "passwordExpired"),
        OLD_PASSWORD(3, "oldPassword"),
        NEW_PASSWORD(4, "newPassword"),
        ERROR(5, "error");

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
                    return PASSWORD_EXPIRED;
                }
                case 3: {
                    return OLD_PASSWORD;
                }
                case 4: {
                    return NEW_PASSWORD;
                }
                case 5: {
                    return ERROR;
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

    private static class ChangePasswordDialogNotificationStandardSchemeFactory
    implements SchemeFactory {
        private ChangePasswordDialogNotificationStandardSchemeFactory() {
        }

        public ChangePasswordDialogNotificationStandardScheme getScheme() {
            return new ChangePasswordDialogNotificationStandardScheme();
        }
    }

    private static class ChangePasswordDialogNotificationTupleSchemeFactory
    implements SchemeFactory {
        private ChangePasswordDialogNotificationTupleSchemeFactory() {
        }

        public ChangePasswordDialogNotificationTupleScheme getScheme() {
            return new ChangePasswordDialogNotificationTupleScheme();
        }
    }

    private static class ChangePasswordDialogNotificationTupleScheme
    extends TupleScheme<ChangePasswordDialogNotification> {
        private ChangePasswordDialogNotificationTupleScheme() {
        }

        public void write(TProtocol tProtocol, ChangePasswordDialogNotification changePasswordDialogNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (changePasswordDialogNotification.isSetUserName()) {
                bitSet.set(0);
            }
            if (changePasswordDialogNotification.isSetPasswordExpired()) {
                bitSet.set(1);
            }
            if (changePasswordDialogNotification.isSetOldPassword()) {
                bitSet.set(2);
            }
            if (changePasswordDialogNotification.isSetNewPassword()) {
                bitSet.set(3);
            }
            if (changePasswordDialogNotification.isSetError()) {
                bitSet.set(4);
            }
            tTupleProtocol.writeBitSet(bitSet, 5);
            if (changePasswordDialogNotification.isSetUserName()) {
                tTupleProtocol.writeString(changePasswordDialogNotification.userName);
            }
            if (changePasswordDialogNotification.isSetPasswordExpired()) {
                tTupleProtocol.writeBool(changePasswordDialogNotification.passwordExpired);
            }
            if (changePasswordDialogNotification.isSetOldPassword()) {
                tTupleProtocol.writeString(changePasswordDialogNotification.oldPassword);
            }
            if (changePasswordDialogNotification.isSetNewPassword()) {
                tTupleProtocol.writeString(changePasswordDialogNotification.newPassword);
            }
            if (changePasswordDialogNotification.isSetError()) {
                changePasswordDialogNotification.error.write((TProtocol)tTupleProtocol);
            }
        }

        public void read(TProtocol tProtocol, ChangePasswordDialogNotification changePasswordDialogNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(5);
            if (bitSet.get(0)) {
                changePasswordDialogNotification.userName = tTupleProtocol.readString();
                changePasswordDialogNotification.setUserNameIsSet(true);
            }
            if (bitSet.get(1)) {
                changePasswordDialogNotification.passwordExpired = tTupleProtocol.readBool();
                changePasswordDialogNotification.setPasswordExpiredIsSet(true);
            }
            if (bitSet.get(2)) {
                changePasswordDialogNotification.oldPassword = tTupleProtocol.readString();
                changePasswordDialogNotification.setOldPasswordIsSet(true);
            }
            if (bitSet.get(3)) {
                changePasswordDialogNotification.newPassword = tTupleProtocol.readString();
                changePasswordDialogNotification.setNewPasswordIsSet(true);
            }
            if (bitSet.get(4)) {
                changePasswordDialogNotification.error = new IWPError();
                changePasswordDialogNotification.error.read((TProtocol)tTupleProtocol);
                changePasswordDialogNotification.setErrorIsSet(true);
            }
        }
    }

    private static class ChangePasswordDialogNotificationStandardScheme
    extends StandardScheme<ChangePasswordDialogNotification> {
        private ChangePasswordDialogNotificationStandardScheme() {
        }

        public void read(TProtocol tProtocol, ChangePasswordDialogNotification changePasswordDialogNotification) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 11) {
                            changePasswordDialogNotification.userName = tProtocol.readString();
                            changePasswordDialogNotification.setUserNameIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 2) {
                            changePasswordDialogNotification.passwordExpired = tProtocol.readBool();
                            changePasswordDialogNotification.setPasswordExpiredIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 11) {
                            changePasswordDialogNotification.oldPassword = tProtocol.readString();
                            changePasswordDialogNotification.setOldPasswordIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 11) {
                            changePasswordDialogNotification.newPassword = tProtocol.readString();
                            changePasswordDialogNotification.setNewPasswordIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 5: {
                        if (tField.type == 12) {
                            changePasswordDialogNotification.error = new IWPError();
                            changePasswordDialogNotification.error.read(tProtocol);
                            changePasswordDialogNotification.setErrorIsSet(true);
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
            changePasswordDialogNotification.validate();
        }

        public void write(TProtocol tProtocol, ChangePasswordDialogNotification changePasswordDialogNotification) throws TException {
            changePasswordDialogNotification.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (changePasswordDialogNotification.userName != null) {
                tProtocol.writeFieldBegin(USER_NAME_FIELD_DESC);
                tProtocol.writeString(changePasswordDialogNotification.userName);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(PASSWORD_EXPIRED_FIELD_DESC);
            tProtocol.writeBool(changePasswordDialogNotification.passwordExpired);
            tProtocol.writeFieldEnd();
            if (changePasswordDialogNotification.oldPassword != null) {
                tProtocol.writeFieldBegin(OLD_PASSWORD_FIELD_DESC);
                tProtocol.writeString(changePasswordDialogNotification.oldPassword);
                tProtocol.writeFieldEnd();
            }
            if (changePasswordDialogNotification.newPassword != null) {
                tProtocol.writeFieldBegin(NEW_PASSWORD_FIELD_DESC);
                tProtocol.writeString(changePasswordDialogNotification.newPassword);
                tProtocol.writeFieldEnd();
            }
            if (changePasswordDialogNotification.error != null) {
                tProtocol.writeFieldBegin(ERROR_FIELD_DESC);
                changePasswordDialogNotification.error.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

