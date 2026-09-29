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

public class LoginDialogNotification
implements TBase<LoginDialogNotification, _Fields>,
Serializable,
Cloneable,
Comparable<LoginDialogNotification> {
    private static final TStruct STRUCT_DESC = new TStruct("LoginDialogNotification");
    private static final TField DATABASE_NAME_FIELD_DESC = new TField("databaseName", 11, 1);
    private static final TField GUEST_ENABLED_FIELD_DESC = new TField("guestEnabled", 2, 2);
    private static final TField RELOGIN_FIELD_DESC = new TField("relogin", 2, 3);
    private static final TField HOSTED_FIELD_DESC = new TField("hosted", 2, 4);
    private static final TField MAIN_FILE_FIELD_DESC = new TField("mainFile", 2, 5);
    private static final TField ERROR_FIELD_DESC = new TField("error", 12, 6);
    private static final TField HIDE_LOCAL_ACCOUNT_ENTRY_FIELD_DESC = new TField("hideLocalAccountEntry", 2, 7);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new LoginDialogNotificationStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new LoginDialogNotificationTupleSchemeFactory();
    @Nullable
    private String databaseName;
    private boolean guestEnabled;
    private boolean relogin;
    private boolean hosted;
    private boolean mainFile;
    @Nullable
    private IWPError error;
    private boolean hideLocalAccountEntry;
    private static final int __GUESTENABLED_ISSET_ID = 0;
    private static final int __RELOGIN_ISSET_ID = 1;
    private static final int __HOSTED_ISSET_ID = 2;
    private static final int __MAINFILE_ISSET_ID = 3;
    private static final int __HIDELOCALACCOUNTENTRY_ISSET_ID = 4;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public LoginDialogNotification() {
    }

    public LoginDialogNotification(String string, boolean bl, boolean bl2, boolean bl3, boolean bl4, IWPError iWPError, boolean bl5) {
        this();
        this.databaseName = string;
        this.guestEnabled = bl;
        this.setGuestEnabledIsSet(true);
        this.relogin = bl2;
        this.setReloginIsSet(true);
        this.hosted = bl3;
        this.setHostedIsSet(true);
        this.mainFile = bl4;
        this.setMainFileIsSet(true);
        this.error = iWPError;
        this.hideLocalAccountEntry = bl5;
        this.setHideLocalAccountEntryIsSet(true);
    }

    public LoginDialogNotification(LoginDialogNotification loginDialogNotification) {
        this.__isset_bitfield = loginDialogNotification.__isset_bitfield;
        if (loginDialogNotification.isSetDatabaseName()) {
            this.databaseName = loginDialogNotification.databaseName;
        }
        this.guestEnabled = loginDialogNotification.guestEnabled;
        this.relogin = loginDialogNotification.relogin;
        this.hosted = loginDialogNotification.hosted;
        this.mainFile = loginDialogNotification.mainFile;
        if (loginDialogNotification.isSetError()) {
            this.error = new IWPError(loginDialogNotification.error);
        }
        this.hideLocalAccountEntry = loginDialogNotification.hideLocalAccountEntry;
    }

    public LoginDialogNotification deepCopy() {
        return new LoginDialogNotification(this);
    }

    public void clear() {
        this.databaseName = null;
        this.setGuestEnabledIsSet(false);
        this.guestEnabled = false;
        this.setReloginIsSet(false);
        this.relogin = false;
        this.setHostedIsSet(false);
        this.hosted = false;
        this.setMainFileIsSet(false);
        this.mainFile = false;
        this.error = null;
        this.setHideLocalAccountEntryIsSet(false);
        this.hideLocalAccountEntry = false;
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

    public boolean isGuestEnabled() {
        return this.guestEnabled;
    }

    public void setGuestEnabled(boolean bl) {
        this.guestEnabled = bl;
        this.setGuestEnabledIsSet(true);
    }

    public void unsetGuestEnabled() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetGuestEnabled() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setGuestEnabledIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public boolean isRelogin() {
        return this.relogin;
    }

    public void setRelogin(boolean bl) {
        this.relogin = bl;
        this.setReloginIsSet(true);
    }

    public void unsetRelogin() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)1);
    }

    public boolean isSetRelogin() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)1);
    }

    public void setReloginIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)1, (boolean)bl);
    }

    public boolean isHosted() {
        return this.hosted;
    }

    public void setHosted(boolean bl) {
        this.hosted = bl;
        this.setHostedIsSet(true);
    }

    public void unsetHosted() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)2);
    }

    public boolean isSetHosted() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)2);
    }

    public void setHostedIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)2, (boolean)bl);
    }

    public boolean isMainFile() {
        return this.mainFile;
    }

    public void setMainFile(boolean bl) {
        this.mainFile = bl;
        this.setMainFileIsSet(true);
    }

    public void unsetMainFile() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)3);
    }

    public boolean isSetMainFile() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)3);
    }

    public void setMainFileIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)3, (boolean)bl);
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

    public boolean isHideLocalAccountEntry() {
        return this.hideLocalAccountEntry;
    }

    public void setHideLocalAccountEntry(boolean bl) {
        this.hideLocalAccountEntry = bl;
        this.setHideLocalAccountEntryIsSet(true);
    }

    public void unsetHideLocalAccountEntry() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)4);
    }

    public boolean isSetHideLocalAccountEntry() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)4);
    }

    public void setHideLocalAccountEntryIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)4, (boolean)bl);
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetDatabaseName();
                    break;
                }
                this.setDatabaseName((String)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetGuestEnabled();
                    break;
                }
                this.setGuestEnabled((Boolean)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetRelogin();
                    break;
                }
                this.setRelogin((Boolean)object);
                break;
            }
            case 3: {
                if (object == null) {
                    this.unsetHosted();
                    break;
                }
                this.setHosted((Boolean)object);
                break;
            }
            case 4: {
                if (object == null) {
                    this.unsetMainFile();
                    break;
                }
                this.setMainFile((Boolean)object);
                break;
            }
            case 5: {
                if (object == null) {
                    this.unsetError();
                    break;
                }
                this.setError((IWPError)object);
                break;
            }
            case 6: {
                if (object == null) {
                    this.unsetHideLocalAccountEntry();
                    break;
                }
                this.setHideLocalAccountEntry((Boolean)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getDatabaseName();
            }
            case 1: {
                return this.isGuestEnabled();
            }
            case 2: {
                return this.isRelogin();
            }
            case 3: {
                return this.isHosted();
            }
            case 4: {
                return this.isMainFile();
            }
            case 5: {
                return this.getError();
            }
            case 6: {
                return this.isHideLocalAccountEntry();
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
                return this.isSetDatabaseName();
            }
            case 1: {
                return this.isSetGuestEnabled();
            }
            case 2: {
                return this.isSetRelogin();
            }
            case 3: {
                return this.isSetHosted();
            }
            case 4: {
                return this.isSetMainFile();
            }
            case 5: {
                return this.isSetError();
            }
            case 6: {
                return this.isSetHideLocalAccountEntry();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof LoginDialogNotification) {
            return this.equals((LoginDialogNotification)object);
        }
        return false;
    }

    public boolean equals(LoginDialogNotification loginDialogNotification) {
        if (loginDialogNotification == null) {
            return false;
        }
        if (this == loginDialogNotification) {
            return true;
        }
        boolean bl = this.isSetDatabaseName();
        boolean bl2 = loginDialogNotification.isSetDatabaseName();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.databaseName.equals(loginDialogNotification.databaseName)) {
                return false;
            }
        }
        boolean bl3 = true;
        boolean bl4 = true;
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (this.guestEnabled != loginDialogNotification.guestEnabled) {
                return false;
            }
        }
        boolean bl5 = true;
        boolean bl6 = true;
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (this.relogin != loginDialogNotification.relogin) {
                return false;
            }
        }
        boolean bl7 = true;
        boolean bl8 = true;
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (this.hosted != loginDialogNotification.hosted) {
                return false;
            }
        }
        boolean bl9 = true;
        boolean bl10 = true;
        if (bl9 || bl10) {
            if (!bl9 || !bl10) {
                return false;
            }
            if (this.mainFile != loginDialogNotification.mainFile) {
                return false;
            }
        }
        boolean bl11 = this.isSetError();
        boolean bl12 = loginDialogNotification.isSetError();
        if (bl11 || bl12) {
            if (!bl11 || !bl12) {
                return false;
            }
            if (!this.error.equals(loginDialogNotification.error)) {
                return false;
            }
        }
        boolean bl13 = true;
        boolean bl14 = true;
        if (bl13 || bl14) {
            if (!bl13 || !bl14) {
                return false;
            }
            if (this.hideLocalAccountEntry != loginDialogNotification.hideLocalAccountEntry) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetDatabaseName() ? 131071 : 524287);
        if (this.isSetDatabaseName()) {
            n = n * 8191 + this.databaseName.hashCode();
        }
        n = n * 8191 + (this.guestEnabled ? 131071 : 524287);
        n = n * 8191 + (this.relogin ? 131071 : 524287);
        n = n * 8191 + (this.hosted ? 131071 : 524287);
        n = n * 8191 + (this.mainFile ? 131071 : 524287);
        n = n * 8191 + (this.isSetError() ? 131071 : 524287);
        if (this.isSetError()) {
            n = n * 8191 + this.error.hashCode();
        }
        n = n * 8191 + (this.hideLocalAccountEntry ? 131071 : 524287);
        return n;
    }

    @Override
    public int compareTo(LoginDialogNotification loginDialogNotification) {
        if (!this.getClass().equals(loginDialogNotification.getClass())) {
            return this.getClass().getName().compareTo(loginDialogNotification.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetDatabaseName(), loginDialogNotification.isSetDatabaseName());
        if (n != 0) {
            return n;
        }
        if (this.isSetDatabaseName() && (n = TBaseHelper.compareTo((String)this.databaseName, (String)loginDialogNotification.databaseName)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetGuestEnabled(), loginDialogNotification.isSetGuestEnabled());
        if (n != 0) {
            return n;
        }
        if (this.isSetGuestEnabled() && (n = TBaseHelper.compareTo((boolean)this.guestEnabled, (boolean)loginDialogNotification.guestEnabled)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetRelogin(), loginDialogNotification.isSetRelogin());
        if (n != 0) {
            return n;
        }
        if (this.isSetRelogin() && (n = TBaseHelper.compareTo((boolean)this.relogin, (boolean)loginDialogNotification.relogin)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetHosted(), loginDialogNotification.isSetHosted());
        if (n != 0) {
            return n;
        }
        if (this.isSetHosted() && (n = TBaseHelper.compareTo((boolean)this.hosted, (boolean)loginDialogNotification.hosted)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetMainFile(), loginDialogNotification.isSetMainFile());
        if (n != 0) {
            return n;
        }
        if (this.isSetMainFile() && (n = TBaseHelper.compareTo((boolean)this.mainFile, (boolean)loginDialogNotification.mainFile)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetError(), loginDialogNotification.isSetError());
        if (n != 0) {
            return n;
        }
        if (this.isSetError() && (n = TBaseHelper.compareTo((Comparable)this.error, (Comparable)loginDialogNotification.error)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetHideLocalAccountEntry(), loginDialogNotification.isSetHideLocalAccountEntry());
        if (n != 0) {
            return n;
        }
        if (this.isSetHideLocalAccountEntry() && (n = TBaseHelper.compareTo((boolean)this.hideLocalAccountEntry, (boolean)loginDialogNotification.hideLocalAccountEntry)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        LoginDialogNotification.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        LoginDialogNotification.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("LoginDialogNotification(");
        boolean bl = true;
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
        stringBuilder.append("guestEnabled:");
        stringBuilder.append(this.guestEnabled);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("relogin:");
        stringBuilder.append(this.relogin);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("hosted:");
        stringBuilder.append(this.hosted);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("mainFile:");
        stringBuilder.append(this.mainFile);
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
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("hideLocalAccountEntry:");
        stringBuilder.append(this.hideLocalAccountEntry);
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
        enumMap.put(_Fields.DATABASE_NAME, new FieldMetaData("databaseName", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.GUEST_ENABLED, new FieldMetaData("guestEnabled", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.RELOGIN, new FieldMetaData("relogin", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.HOSTED, new FieldMetaData("hosted", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.MAIN_FILE, new FieldMetaData("mainFile", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.ERROR, new FieldMetaData("error", 3, (FieldValueMetaData)new StructMetaData(12, IWPError.class)));
        enumMap.put(_Fields.HIDE_LOCAL_ACCOUNT_ENTRY, new FieldMetaData("hideLocalAccountEntry", 3, new FieldValueMetaData(2)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(LoginDialogNotification.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        DATABASE_NAME(1, "databaseName"),
        GUEST_ENABLED(2, "guestEnabled"),
        RELOGIN(3, "relogin"),
        HOSTED(4, "hosted"),
        MAIN_FILE(5, "mainFile"),
        ERROR(6, "error"),
        HIDE_LOCAL_ACCOUNT_ENTRY(7, "hideLocalAccountEntry");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return DATABASE_NAME;
                }
                case 2: {
                    return GUEST_ENABLED;
                }
                case 3: {
                    return RELOGIN;
                }
                case 4: {
                    return HOSTED;
                }
                case 5: {
                    return MAIN_FILE;
                }
                case 6: {
                    return ERROR;
                }
                case 7: {
                    return HIDE_LOCAL_ACCOUNT_ENTRY;
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

    private static class LoginDialogNotificationStandardSchemeFactory
    implements SchemeFactory {
        private LoginDialogNotificationStandardSchemeFactory() {
        }

        public LoginDialogNotificationStandardScheme getScheme() {
            return new LoginDialogNotificationStandardScheme();
        }
    }

    private static class LoginDialogNotificationTupleSchemeFactory
    implements SchemeFactory {
        private LoginDialogNotificationTupleSchemeFactory() {
        }

        public LoginDialogNotificationTupleScheme getScheme() {
            return new LoginDialogNotificationTupleScheme();
        }
    }

    private static class LoginDialogNotificationTupleScheme
    extends TupleScheme<LoginDialogNotification> {
        private LoginDialogNotificationTupleScheme() {
        }

        public void write(TProtocol tProtocol, LoginDialogNotification loginDialogNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (loginDialogNotification.isSetDatabaseName()) {
                bitSet.set(0);
            }
            if (loginDialogNotification.isSetGuestEnabled()) {
                bitSet.set(1);
            }
            if (loginDialogNotification.isSetRelogin()) {
                bitSet.set(2);
            }
            if (loginDialogNotification.isSetHosted()) {
                bitSet.set(3);
            }
            if (loginDialogNotification.isSetMainFile()) {
                bitSet.set(4);
            }
            if (loginDialogNotification.isSetError()) {
                bitSet.set(5);
            }
            if (loginDialogNotification.isSetHideLocalAccountEntry()) {
                bitSet.set(6);
            }
            tTupleProtocol.writeBitSet(bitSet, 7);
            if (loginDialogNotification.isSetDatabaseName()) {
                tTupleProtocol.writeString(loginDialogNotification.databaseName);
            }
            if (loginDialogNotification.isSetGuestEnabled()) {
                tTupleProtocol.writeBool(loginDialogNotification.guestEnabled);
            }
            if (loginDialogNotification.isSetRelogin()) {
                tTupleProtocol.writeBool(loginDialogNotification.relogin);
            }
            if (loginDialogNotification.isSetHosted()) {
                tTupleProtocol.writeBool(loginDialogNotification.hosted);
            }
            if (loginDialogNotification.isSetMainFile()) {
                tTupleProtocol.writeBool(loginDialogNotification.mainFile);
            }
            if (loginDialogNotification.isSetError()) {
                loginDialogNotification.error.write((TProtocol)tTupleProtocol);
            }
            if (loginDialogNotification.isSetHideLocalAccountEntry()) {
                tTupleProtocol.writeBool(loginDialogNotification.hideLocalAccountEntry);
            }
        }

        public void read(TProtocol tProtocol, LoginDialogNotification loginDialogNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(7);
            if (bitSet.get(0)) {
                loginDialogNotification.databaseName = tTupleProtocol.readString();
                loginDialogNotification.setDatabaseNameIsSet(true);
            }
            if (bitSet.get(1)) {
                loginDialogNotification.guestEnabled = tTupleProtocol.readBool();
                loginDialogNotification.setGuestEnabledIsSet(true);
            }
            if (bitSet.get(2)) {
                loginDialogNotification.relogin = tTupleProtocol.readBool();
                loginDialogNotification.setReloginIsSet(true);
            }
            if (bitSet.get(3)) {
                loginDialogNotification.hosted = tTupleProtocol.readBool();
                loginDialogNotification.setHostedIsSet(true);
            }
            if (bitSet.get(4)) {
                loginDialogNotification.mainFile = tTupleProtocol.readBool();
                loginDialogNotification.setMainFileIsSet(true);
            }
            if (bitSet.get(5)) {
                loginDialogNotification.error = new IWPError();
                loginDialogNotification.error.read((TProtocol)tTupleProtocol);
                loginDialogNotification.setErrorIsSet(true);
            }
            if (bitSet.get(6)) {
                loginDialogNotification.hideLocalAccountEntry = tTupleProtocol.readBool();
                loginDialogNotification.setHideLocalAccountEntryIsSet(true);
            }
        }
    }

    private static class LoginDialogNotificationStandardScheme
    extends StandardScheme<LoginDialogNotification> {
        private LoginDialogNotificationStandardScheme() {
        }

        public void read(TProtocol tProtocol, LoginDialogNotification loginDialogNotification) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 11) {
                            loginDialogNotification.databaseName = tProtocol.readString();
                            loginDialogNotification.setDatabaseNameIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 2) {
                            loginDialogNotification.guestEnabled = tProtocol.readBool();
                            loginDialogNotification.setGuestEnabledIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 2) {
                            loginDialogNotification.relogin = tProtocol.readBool();
                            loginDialogNotification.setReloginIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 2) {
                            loginDialogNotification.hosted = tProtocol.readBool();
                            loginDialogNotification.setHostedIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 5: {
                        if (tField.type == 2) {
                            loginDialogNotification.mainFile = tProtocol.readBool();
                            loginDialogNotification.setMainFileIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 6: {
                        if (tField.type == 12) {
                            loginDialogNotification.error = new IWPError();
                            loginDialogNotification.error.read(tProtocol);
                            loginDialogNotification.setErrorIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 7: {
                        if (tField.type == 2) {
                            loginDialogNotification.hideLocalAccountEntry = tProtocol.readBool();
                            loginDialogNotification.setHideLocalAccountEntryIsSet(true);
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
            loginDialogNotification.validate();
        }

        public void write(TProtocol tProtocol, LoginDialogNotification loginDialogNotification) throws TException {
            loginDialogNotification.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (loginDialogNotification.databaseName != null) {
                tProtocol.writeFieldBegin(DATABASE_NAME_FIELD_DESC);
                tProtocol.writeString(loginDialogNotification.databaseName);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(GUEST_ENABLED_FIELD_DESC);
            tProtocol.writeBool(loginDialogNotification.guestEnabled);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(RELOGIN_FIELD_DESC);
            tProtocol.writeBool(loginDialogNotification.relogin);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(HOSTED_FIELD_DESC);
            tProtocol.writeBool(loginDialogNotification.hosted);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(MAIN_FILE_FIELD_DESC);
            tProtocol.writeBool(loginDialogNotification.mainFile);
            tProtocol.writeFieldEnd();
            if (loginDialogNotification.error != null) {
                tProtocol.writeFieldBegin(ERROR_FIELD_DESC);
                loginDialogNotification.error.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(HIDE_LOCAL_ACCOUNT_ENTRY_FIELD_DESC);
            tProtocol.writeBool(loginDialogNotification.hideLocalAccountEntry);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

