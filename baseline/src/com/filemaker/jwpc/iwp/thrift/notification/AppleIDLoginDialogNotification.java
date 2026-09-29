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

public class AppleIDLoginDialogNotification
implements TBase<AppleIDLoginDialogNotification, _Fields>,
Serializable,
Cloneable,
Comparable<AppleIDLoginDialogNotification> {
    private static final TStruct STRUCT_DESC = new TStruct("AppleIDLoginDialogNotification");
    private static final TField IS_FIRST_TIME_FIELD_DESC = new TField("isFirstTime", 2, 1);
    private static final TField EMAIL_FIELD_DESC = new TField("email", 11, 2);
    private static final TField ERROR_FIELD_DESC = new TField("error", 12, 3);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new AppleIDLoginDialogNotificationStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new AppleIDLoginDialogNotificationTupleSchemeFactory();
    private boolean isFirstTime;
    @Nullable
    private String email;
    @Nullable
    private IWPError error;
    private static final int __ISFIRSTTIME_ISSET_ID = 0;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public AppleIDLoginDialogNotification() {
    }

    public AppleIDLoginDialogNotification(boolean bl, String string, IWPError iWPError) {
        this();
        this.isFirstTime = bl;
        this.setIsFirstTimeIsSet(true);
        this.email = string;
        this.error = iWPError;
    }

    public AppleIDLoginDialogNotification(AppleIDLoginDialogNotification appleIDLoginDialogNotification) {
        this.__isset_bitfield = appleIDLoginDialogNotification.__isset_bitfield;
        this.isFirstTime = appleIDLoginDialogNotification.isFirstTime;
        if (appleIDLoginDialogNotification.isSetEmail()) {
            this.email = appleIDLoginDialogNotification.email;
        }
        if (appleIDLoginDialogNotification.isSetError()) {
            this.error = new IWPError(appleIDLoginDialogNotification.error);
        }
    }

    public AppleIDLoginDialogNotification deepCopy() {
        return new AppleIDLoginDialogNotification(this);
    }

    public void clear() {
        this.setIsFirstTimeIsSet(false);
        this.isFirstTime = false;
        this.email = null;
        this.error = null;
    }

    public boolean isIsFirstTime() {
        return this.isFirstTime;
    }

    public void setIsFirstTime(boolean bl) {
        this.isFirstTime = bl;
        this.setIsFirstTimeIsSet(true);
    }

    public void unsetIsFirstTime() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetIsFirstTime() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setIsFirstTimeIsSet(boolean bl) {
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
                    this.unsetIsFirstTime();
                    break;
                }
                this.setIsFirstTime((Boolean)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetEmail();
                    break;
                }
                this.setEmail((String)object);
                break;
            }
            case 2: {
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
                return this.isIsFirstTime();
            }
            case 1: {
                return this.getEmail();
            }
            case 2: {
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
                return this.isSetIsFirstTime();
            }
            case 1: {
                return this.isSetEmail();
            }
            case 2: {
                return this.isSetError();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof AppleIDLoginDialogNotification) {
            return this.equals((AppleIDLoginDialogNotification)object);
        }
        return false;
    }

    public boolean equals(AppleIDLoginDialogNotification appleIDLoginDialogNotification) {
        if (appleIDLoginDialogNotification == null) {
            return false;
        }
        if (this == appleIDLoginDialogNotification) {
            return true;
        }
        boolean bl = true;
        boolean bl2 = true;
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (this.isFirstTime != appleIDLoginDialogNotification.isFirstTime) {
                return false;
            }
        }
        boolean bl3 = this.isSetEmail();
        boolean bl4 = appleIDLoginDialogNotification.isSetEmail();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.email.equals(appleIDLoginDialogNotification.email)) {
                return false;
            }
        }
        boolean bl5 = this.isSetError();
        boolean bl6 = appleIDLoginDialogNotification.isSetError();
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (!this.error.equals(appleIDLoginDialogNotification.error)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isFirstTime ? 131071 : 524287);
        n = n * 8191 + (this.isSetEmail() ? 131071 : 524287);
        if (this.isSetEmail()) {
            n = n * 8191 + this.email.hashCode();
        }
        n = n * 8191 + (this.isSetError() ? 131071 : 524287);
        if (this.isSetError()) {
            n = n * 8191 + this.error.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(AppleIDLoginDialogNotification appleIDLoginDialogNotification) {
        if (!this.getClass().equals(appleIDLoginDialogNotification.getClass())) {
            return this.getClass().getName().compareTo(appleIDLoginDialogNotification.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetIsFirstTime(), appleIDLoginDialogNotification.isSetIsFirstTime());
        if (n != 0) {
            return n;
        }
        if (this.isSetIsFirstTime() && (n = TBaseHelper.compareTo((boolean)this.isFirstTime, (boolean)appleIDLoginDialogNotification.isFirstTime)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetEmail(), appleIDLoginDialogNotification.isSetEmail());
        if (n != 0) {
            return n;
        }
        if (this.isSetEmail() && (n = TBaseHelper.compareTo((String)this.email, (String)appleIDLoginDialogNotification.email)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetError(), appleIDLoginDialogNotification.isSetError());
        if (n != 0) {
            return n;
        }
        if (this.isSetError() && (n = TBaseHelper.compareTo((Comparable)this.error, (Comparable)appleIDLoginDialogNotification.error)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        AppleIDLoginDialogNotification.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        AppleIDLoginDialogNotification.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("AppleIDLoginDialogNotification(");
        boolean bl = true;
        stringBuilder.append("isFirstTime:");
        stringBuilder.append(this.isFirstTime);
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
        enumMap.put(_Fields.IS_FIRST_TIME, new FieldMetaData("isFirstTime", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.EMAIL, new FieldMetaData("email", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.ERROR, new FieldMetaData("error", 3, (FieldValueMetaData)new StructMetaData(12, IWPError.class)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(AppleIDLoginDialogNotification.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        IS_FIRST_TIME(1, "isFirstTime"),
        EMAIL(2, "email"),
        ERROR(3, "error");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return IS_FIRST_TIME;
                }
                case 2: {
                    return EMAIL;
                }
                case 3: {
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

    private static class AppleIDLoginDialogNotificationStandardSchemeFactory
    implements SchemeFactory {
        private AppleIDLoginDialogNotificationStandardSchemeFactory() {
        }

        public AppleIDLoginDialogNotificationStandardScheme getScheme() {
            return new AppleIDLoginDialogNotificationStandardScheme();
        }
    }

    private static class AppleIDLoginDialogNotificationTupleSchemeFactory
    implements SchemeFactory {
        private AppleIDLoginDialogNotificationTupleSchemeFactory() {
        }

        public AppleIDLoginDialogNotificationTupleScheme getScheme() {
            return new AppleIDLoginDialogNotificationTupleScheme();
        }
    }

    private static class AppleIDLoginDialogNotificationTupleScheme
    extends TupleScheme<AppleIDLoginDialogNotification> {
        private AppleIDLoginDialogNotificationTupleScheme() {
        }

        public void write(TProtocol tProtocol, AppleIDLoginDialogNotification appleIDLoginDialogNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (appleIDLoginDialogNotification.isSetIsFirstTime()) {
                bitSet.set(0);
            }
            if (appleIDLoginDialogNotification.isSetEmail()) {
                bitSet.set(1);
            }
            if (appleIDLoginDialogNotification.isSetError()) {
                bitSet.set(2);
            }
            tTupleProtocol.writeBitSet(bitSet, 3);
            if (appleIDLoginDialogNotification.isSetIsFirstTime()) {
                tTupleProtocol.writeBool(appleIDLoginDialogNotification.isFirstTime);
            }
            if (appleIDLoginDialogNotification.isSetEmail()) {
                tTupleProtocol.writeString(appleIDLoginDialogNotification.email);
            }
            if (appleIDLoginDialogNotification.isSetError()) {
                appleIDLoginDialogNotification.error.write((TProtocol)tTupleProtocol);
            }
        }

        public void read(TProtocol tProtocol, AppleIDLoginDialogNotification appleIDLoginDialogNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(3);
            if (bitSet.get(0)) {
                appleIDLoginDialogNotification.isFirstTime = tTupleProtocol.readBool();
                appleIDLoginDialogNotification.setIsFirstTimeIsSet(true);
            }
            if (bitSet.get(1)) {
                appleIDLoginDialogNotification.email = tTupleProtocol.readString();
                appleIDLoginDialogNotification.setEmailIsSet(true);
            }
            if (bitSet.get(2)) {
                appleIDLoginDialogNotification.error = new IWPError();
                appleIDLoginDialogNotification.error.read((TProtocol)tTupleProtocol);
                appleIDLoginDialogNotification.setErrorIsSet(true);
            }
        }
    }

    private static class AppleIDLoginDialogNotificationStandardScheme
    extends StandardScheme<AppleIDLoginDialogNotification> {
        private AppleIDLoginDialogNotificationStandardScheme() {
        }

        public void read(TProtocol tProtocol, AppleIDLoginDialogNotification appleIDLoginDialogNotification) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 2) {
                            appleIDLoginDialogNotification.isFirstTime = tProtocol.readBool();
                            appleIDLoginDialogNotification.setIsFirstTimeIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 11) {
                            appleIDLoginDialogNotification.email = tProtocol.readString();
                            appleIDLoginDialogNotification.setEmailIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 12) {
                            appleIDLoginDialogNotification.error = new IWPError();
                            appleIDLoginDialogNotification.error.read(tProtocol);
                            appleIDLoginDialogNotification.setErrorIsSet(true);
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
            appleIDLoginDialogNotification.validate();
        }

        public void write(TProtocol tProtocol, AppleIDLoginDialogNotification appleIDLoginDialogNotification) throws TException {
            appleIDLoginDialogNotification.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            tProtocol.writeFieldBegin(IS_FIRST_TIME_FIELD_DESC);
            tProtocol.writeBool(appleIDLoginDialogNotification.isFirstTime);
            tProtocol.writeFieldEnd();
            if (appleIDLoginDialogNotification.email != null) {
                tProtocol.writeFieldBegin(EMAIL_FIELD_DESC);
                tProtocol.writeString(appleIDLoginDialogNotification.email);
                tProtocol.writeFieldEnd();
            }
            if (appleIDLoginDialogNotification.error != null) {
                tProtocol.writeFieldBegin(ERROR_FIELD_DESC);
                appleIDLoginDialogNotification.error.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

