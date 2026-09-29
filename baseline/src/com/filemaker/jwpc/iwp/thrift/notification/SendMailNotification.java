/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
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
package com.filemaker.jwpc.iwp.thrift.notification;

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

public class SendMailNotification
implements TBase<SendMailNotification, _Fields>,
Serializable,
Cloneable,
Comparable<SendMailNotification> {
    private static final TStruct STRUCT_DESC = new TStruct("SendMailNotification");
    private static final TField TO_STRING_FIELD_DESC = new TField("toString", 11, 1);
    private static final TField CC_STRING_FIELD_DESC = new TField("ccString", 11, 2);
    private static final TField BCC_STRING_FIELD_DESC = new TField("bccString", 11, 3);
    private static final TField SUBJECT_STRING_FIELD_DESC = new TField("subjectString", 11, 4);
    private static final TField BODY_STRING_FIELD_DESC = new TField("bodyString", 11, 5);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new SendMailNotificationStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new SendMailNotificationTupleSchemeFactory();
    @Nullable
    private String toString;
    @Nullable
    private String ccString;
    @Nullable
    private String bccString;
    @Nullable
    private String subjectString;
    @Nullable
    private String bodyString;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public SendMailNotification() {
    }

    public SendMailNotification(String string, String string2, String string3, String string4, String string5) {
        this();
        this.toString = string;
        this.ccString = string2;
        this.bccString = string3;
        this.subjectString = string4;
        this.bodyString = string5;
    }

    public SendMailNotification(SendMailNotification sendMailNotification) {
        if (sendMailNotification.isSetToString()) {
            this.toString = sendMailNotification.toString;
        }
        if (sendMailNotification.isSetCcString()) {
            this.ccString = sendMailNotification.ccString;
        }
        if (sendMailNotification.isSetBccString()) {
            this.bccString = sendMailNotification.bccString;
        }
        if (sendMailNotification.isSetSubjectString()) {
            this.subjectString = sendMailNotification.subjectString;
        }
        if (sendMailNotification.isSetBodyString()) {
            this.bodyString = sendMailNotification.bodyString;
        }
    }

    public SendMailNotification deepCopy() {
        return new SendMailNotification(this);
    }

    public void clear() {
        this.toString = null;
        this.ccString = null;
        this.bccString = null;
        this.subjectString = null;
        this.bodyString = null;
    }

    @Nullable
    public String getToString() {
        return this.toString;
    }

    public void setToString(@Nullable String string) {
        this.toString = string;
    }

    public void unsetToString() {
        this.toString = null;
    }

    public boolean isSetToString() {
        return this.toString != null;
    }

    public void setToStringIsSet(boolean bl) {
        if (!bl) {
            this.toString = null;
        }
    }

    @Nullable
    public String getCcString() {
        return this.ccString;
    }

    public void setCcString(@Nullable String string) {
        this.ccString = string;
    }

    public void unsetCcString() {
        this.ccString = null;
    }

    public boolean isSetCcString() {
        return this.ccString != null;
    }

    public void setCcStringIsSet(boolean bl) {
        if (!bl) {
            this.ccString = null;
        }
    }

    @Nullable
    public String getBccString() {
        return this.bccString;
    }

    public void setBccString(@Nullable String string) {
        this.bccString = string;
    }

    public void unsetBccString() {
        this.bccString = null;
    }

    public boolean isSetBccString() {
        return this.bccString != null;
    }

    public void setBccStringIsSet(boolean bl) {
        if (!bl) {
            this.bccString = null;
        }
    }

    @Nullable
    public String getSubjectString() {
        return this.subjectString;
    }

    public void setSubjectString(@Nullable String string) {
        this.subjectString = string;
    }

    public void unsetSubjectString() {
        this.subjectString = null;
    }

    public boolean isSetSubjectString() {
        return this.subjectString != null;
    }

    public void setSubjectStringIsSet(boolean bl) {
        if (!bl) {
            this.subjectString = null;
        }
    }

    @Nullable
    public String getBodyString() {
        return this.bodyString;
    }

    public void setBodyString(@Nullable String string) {
        this.bodyString = string;
    }

    public void unsetBodyString() {
        this.bodyString = null;
    }

    public boolean isSetBodyString() {
        return this.bodyString != null;
    }

    public void setBodyStringIsSet(boolean bl) {
        if (!bl) {
            this.bodyString = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetToString();
                    break;
                }
                this.setToString((String)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetCcString();
                    break;
                }
                this.setCcString((String)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetBccString();
                    break;
                }
                this.setBccString((String)object);
                break;
            }
            case 3: {
                if (object == null) {
                    this.unsetSubjectString();
                    break;
                }
                this.setSubjectString((String)object);
                break;
            }
            case 4: {
                if (object == null) {
                    this.unsetBodyString();
                    break;
                }
                this.setBodyString((String)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getToString();
            }
            case 1: {
                return this.getCcString();
            }
            case 2: {
                return this.getBccString();
            }
            case 3: {
                return this.getSubjectString();
            }
            case 4: {
                return this.getBodyString();
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
                return this.isSetToString();
            }
            case 1: {
                return this.isSetCcString();
            }
            case 2: {
                return this.isSetBccString();
            }
            case 3: {
                return this.isSetSubjectString();
            }
            case 4: {
                return this.isSetBodyString();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof SendMailNotification) {
            return this.equals((SendMailNotification)object);
        }
        return false;
    }

    public boolean equals(SendMailNotification sendMailNotification) {
        if (sendMailNotification == null) {
            return false;
        }
        if (this == sendMailNotification) {
            return true;
        }
        boolean bl = this.isSetToString();
        boolean bl2 = sendMailNotification.isSetToString();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.toString.equals(sendMailNotification.toString)) {
                return false;
            }
        }
        boolean bl3 = this.isSetCcString();
        boolean bl4 = sendMailNotification.isSetCcString();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.ccString.equals(sendMailNotification.ccString)) {
                return false;
            }
        }
        boolean bl5 = this.isSetBccString();
        boolean bl6 = sendMailNotification.isSetBccString();
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (!this.bccString.equals(sendMailNotification.bccString)) {
                return false;
            }
        }
        boolean bl7 = this.isSetSubjectString();
        boolean bl8 = sendMailNotification.isSetSubjectString();
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (!this.subjectString.equals(sendMailNotification.subjectString)) {
                return false;
            }
        }
        boolean bl9 = this.isSetBodyString();
        boolean bl10 = sendMailNotification.isSetBodyString();
        if (bl9 || bl10) {
            if (!bl9 || !bl10) {
                return false;
            }
            if (!this.bodyString.equals(sendMailNotification.bodyString)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetToString() ? 131071 : 524287);
        if (this.isSetToString()) {
            n = n * 8191 + this.toString.hashCode();
        }
        n = n * 8191 + (this.isSetCcString() ? 131071 : 524287);
        if (this.isSetCcString()) {
            n = n * 8191 + this.ccString.hashCode();
        }
        n = n * 8191 + (this.isSetBccString() ? 131071 : 524287);
        if (this.isSetBccString()) {
            n = n * 8191 + this.bccString.hashCode();
        }
        n = n * 8191 + (this.isSetSubjectString() ? 131071 : 524287);
        if (this.isSetSubjectString()) {
            n = n * 8191 + this.subjectString.hashCode();
        }
        n = n * 8191 + (this.isSetBodyString() ? 131071 : 524287);
        if (this.isSetBodyString()) {
            n = n * 8191 + this.bodyString.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(SendMailNotification sendMailNotification) {
        if (!this.getClass().equals(sendMailNotification.getClass())) {
            return this.getClass().getName().compareTo(sendMailNotification.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetToString(), sendMailNotification.isSetToString());
        if (n != 0) {
            return n;
        }
        if (this.isSetToString() && (n = TBaseHelper.compareTo((String)this.toString, (String)sendMailNotification.toString)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetCcString(), sendMailNotification.isSetCcString());
        if (n != 0) {
            return n;
        }
        if (this.isSetCcString() && (n = TBaseHelper.compareTo((String)this.ccString, (String)sendMailNotification.ccString)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetBccString(), sendMailNotification.isSetBccString());
        if (n != 0) {
            return n;
        }
        if (this.isSetBccString() && (n = TBaseHelper.compareTo((String)this.bccString, (String)sendMailNotification.bccString)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetSubjectString(), sendMailNotification.isSetSubjectString());
        if (n != 0) {
            return n;
        }
        if (this.isSetSubjectString() && (n = TBaseHelper.compareTo((String)this.subjectString, (String)sendMailNotification.subjectString)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetBodyString(), sendMailNotification.isSetBodyString());
        if (n != 0) {
            return n;
        }
        if (this.isSetBodyString() && (n = TBaseHelper.compareTo((String)this.bodyString, (String)sendMailNotification.bodyString)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        SendMailNotification.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        SendMailNotification.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("SendMailNotification(");
        boolean bl = true;
        stringBuilder.append("toString:");
        if (this.toString == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.toString);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("ccString:");
        if (this.ccString == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.ccString);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("bccString:");
        if (this.bccString == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.bccString);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("subjectString:");
        if (this.subjectString == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.subjectString);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("bodyString:");
        if (this.bodyString == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.bodyString);
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
        enumMap.put(_Fields.TO_STRING, new FieldMetaData("toString", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.CC_STRING, new FieldMetaData("ccString", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.BCC_STRING, new FieldMetaData("bccString", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.SUBJECT_STRING, new FieldMetaData("subjectString", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.BODY_STRING, new FieldMetaData("bodyString", 3, new FieldValueMetaData(11)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(SendMailNotification.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        TO_STRING(1, "toString"),
        CC_STRING(2, "ccString"),
        BCC_STRING(3, "bccString"),
        SUBJECT_STRING(4, "subjectString"),
        BODY_STRING(5, "bodyString");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return TO_STRING;
                }
                case 2: {
                    return CC_STRING;
                }
                case 3: {
                    return BCC_STRING;
                }
                case 4: {
                    return SUBJECT_STRING;
                }
                case 5: {
                    return BODY_STRING;
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

    private static class SendMailNotificationStandardSchemeFactory
    implements SchemeFactory {
        private SendMailNotificationStandardSchemeFactory() {
        }

        public SendMailNotificationStandardScheme getScheme() {
            return new SendMailNotificationStandardScheme();
        }
    }

    private static class SendMailNotificationTupleSchemeFactory
    implements SchemeFactory {
        private SendMailNotificationTupleSchemeFactory() {
        }

        public SendMailNotificationTupleScheme getScheme() {
            return new SendMailNotificationTupleScheme();
        }
    }

    private static class SendMailNotificationTupleScheme
    extends TupleScheme<SendMailNotification> {
        private SendMailNotificationTupleScheme() {
        }

        public void write(TProtocol tProtocol, SendMailNotification sendMailNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (sendMailNotification.isSetToString()) {
                bitSet.set(0);
            }
            if (sendMailNotification.isSetCcString()) {
                bitSet.set(1);
            }
            if (sendMailNotification.isSetBccString()) {
                bitSet.set(2);
            }
            if (sendMailNotification.isSetSubjectString()) {
                bitSet.set(3);
            }
            if (sendMailNotification.isSetBodyString()) {
                bitSet.set(4);
            }
            tTupleProtocol.writeBitSet(bitSet, 5);
            if (sendMailNotification.isSetToString()) {
                tTupleProtocol.writeString(sendMailNotification.toString);
            }
            if (sendMailNotification.isSetCcString()) {
                tTupleProtocol.writeString(sendMailNotification.ccString);
            }
            if (sendMailNotification.isSetBccString()) {
                tTupleProtocol.writeString(sendMailNotification.bccString);
            }
            if (sendMailNotification.isSetSubjectString()) {
                tTupleProtocol.writeString(sendMailNotification.subjectString);
            }
            if (sendMailNotification.isSetBodyString()) {
                tTupleProtocol.writeString(sendMailNotification.bodyString);
            }
        }

        public void read(TProtocol tProtocol, SendMailNotification sendMailNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(5);
            if (bitSet.get(0)) {
                sendMailNotification.toString = tTupleProtocol.readString();
                sendMailNotification.setToStringIsSet(true);
            }
            if (bitSet.get(1)) {
                sendMailNotification.ccString = tTupleProtocol.readString();
                sendMailNotification.setCcStringIsSet(true);
            }
            if (bitSet.get(2)) {
                sendMailNotification.bccString = tTupleProtocol.readString();
                sendMailNotification.setBccStringIsSet(true);
            }
            if (bitSet.get(3)) {
                sendMailNotification.subjectString = tTupleProtocol.readString();
                sendMailNotification.setSubjectStringIsSet(true);
            }
            if (bitSet.get(4)) {
                sendMailNotification.bodyString = tTupleProtocol.readString();
                sendMailNotification.setBodyStringIsSet(true);
            }
        }
    }

    private static class SendMailNotificationStandardScheme
    extends StandardScheme<SendMailNotification> {
        private SendMailNotificationStandardScheme() {
        }

        public void read(TProtocol tProtocol, SendMailNotification sendMailNotification) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 11) {
                            sendMailNotification.toString = tProtocol.readString();
                            sendMailNotification.setToStringIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 11) {
                            sendMailNotification.ccString = tProtocol.readString();
                            sendMailNotification.setCcStringIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 11) {
                            sendMailNotification.bccString = tProtocol.readString();
                            sendMailNotification.setBccStringIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 11) {
                            sendMailNotification.subjectString = tProtocol.readString();
                            sendMailNotification.setSubjectStringIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 5: {
                        if (tField.type == 11) {
                            sendMailNotification.bodyString = tProtocol.readString();
                            sendMailNotification.setBodyStringIsSet(true);
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
            sendMailNotification.validate();
        }

        public void write(TProtocol tProtocol, SendMailNotification sendMailNotification) throws TException {
            sendMailNotification.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (sendMailNotification.toString != null) {
                tProtocol.writeFieldBegin(TO_STRING_FIELD_DESC);
                tProtocol.writeString(sendMailNotification.toString);
                tProtocol.writeFieldEnd();
            }
            if (sendMailNotification.ccString != null) {
                tProtocol.writeFieldBegin(CC_STRING_FIELD_DESC);
                tProtocol.writeString(sendMailNotification.ccString);
                tProtocol.writeFieldEnd();
            }
            if (sendMailNotification.bccString != null) {
                tProtocol.writeFieldBegin(BCC_STRING_FIELD_DESC);
                tProtocol.writeString(sendMailNotification.bccString);
                tProtocol.writeFieldEnd();
            }
            if (sendMailNotification.subjectString != null) {
                tProtocol.writeFieldBegin(SUBJECT_STRING_FIELD_DESC);
                tProtocol.writeString(sendMailNotification.subjectString);
                tProtocol.writeFieldEnd();
            }
            if (sendMailNotification.bodyString != null) {
                tProtocol.writeFieldBegin(BODY_STRING_FIELD_DESC);
                tProtocol.writeString(sendMailNotification.bodyString);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

