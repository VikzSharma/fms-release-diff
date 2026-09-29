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
 *  org.apache.thrift.meta_data.EnumMetaData
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

import com.filemaker.jwpc.iwp.thrift.common.CloseRequestType;
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
import org.apache.thrift.meta_data.EnumMetaData;
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

public class CloseRequestNotification
implements TBase<CloseRequestNotification, _Fields>,
Serializable,
Cloneable,
Comparable<CloseRequestNotification> {
    private static final TStruct STRUCT_DESC = new TStruct("CloseRequestNotification");
    private static final TField TYPE_FIELD_DESC = new TField("type", 8, 1);
    private static final TField REASON_FIELD_DESC = new TField("reason", 11, 2);
    private static final TField TIMEOUT_FIELD_DESC = new TField("timeout", 8, 3);
    private static final TField ACCT_NAME_FIELD_DESC = new TField("acctName", 11, 4);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new CloseRequestNotificationStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new CloseRequestNotificationTupleSchemeFactory();
    @Nullable
    private CloseRequestType type;
    @Nullable
    private String reason;
    private int timeout;
    @Nullable
    private String acctName;
    private static final int __TIMEOUT_ISSET_ID = 0;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public CloseRequestNotification() {
    }

    public CloseRequestNotification(CloseRequestType closeRequestType, String string, int n, String string2) {
        this();
        this.type = closeRequestType;
        this.reason = string;
        this.timeout = n;
        this.setTimeoutIsSet(true);
        this.acctName = string2;
    }

    public CloseRequestNotification(CloseRequestNotification closeRequestNotification) {
        this.__isset_bitfield = closeRequestNotification.__isset_bitfield;
        if (closeRequestNotification.isSetType()) {
            this.type = closeRequestNotification.type;
        }
        if (closeRequestNotification.isSetReason()) {
            this.reason = closeRequestNotification.reason;
        }
        this.timeout = closeRequestNotification.timeout;
        if (closeRequestNotification.isSetAcctName()) {
            this.acctName = closeRequestNotification.acctName;
        }
    }

    public CloseRequestNotification deepCopy() {
        return new CloseRequestNotification(this);
    }

    public void clear() {
        this.type = null;
        this.reason = null;
        this.setTimeoutIsSet(false);
        this.timeout = 0;
        this.acctName = null;
    }

    @Nullable
    public CloseRequestType getType() {
        return this.type;
    }

    public void setType(@Nullable CloseRequestType closeRequestType) {
        this.type = closeRequestType;
    }

    public void unsetType() {
        this.type = null;
    }

    public boolean isSetType() {
        return this.type != null;
    }

    public void setTypeIsSet(boolean bl) {
        if (!bl) {
            this.type = null;
        }
    }

    @Nullable
    public String getReason() {
        return this.reason;
    }

    public void setReason(@Nullable String string) {
        this.reason = string;
    }

    public void unsetReason() {
        this.reason = null;
    }

    public boolean isSetReason() {
        return this.reason != null;
    }

    public void setReasonIsSet(boolean bl) {
        if (!bl) {
            this.reason = null;
        }
    }

    public int getTimeout() {
        return this.timeout;
    }

    public void setTimeout(int n) {
        this.timeout = n;
        this.setTimeoutIsSet(true);
    }

    public void unsetTimeout() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetTimeout() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setTimeoutIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    @Nullable
    public String getAcctName() {
        return this.acctName;
    }

    public void setAcctName(@Nullable String string) {
        this.acctName = string;
    }

    public void unsetAcctName() {
        this.acctName = null;
    }

    public boolean isSetAcctName() {
        return this.acctName != null;
    }

    public void setAcctNameIsSet(boolean bl) {
        if (!bl) {
            this.acctName = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetType();
                    break;
                }
                this.setType((CloseRequestType)((Object)object));
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetReason();
                    break;
                }
                this.setReason((String)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetTimeout();
                    break;
                }
                this.setTimeout((Integer)object);
                break;
            }
            case 3: {
                if (object == null) {
                    this.unsetAcctName();
                    break;
                }
                this.setAcctName((String)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getType();
            }
            case 1: {
                return this.getReason();
            }
            case 2: {
                return this.getTimeout();
            }
            case 3: {
                return this.getAcctName();
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
                return this.isSetType();
            }
            case 1: {
                return this.isSetReason();
            }
            case 2: {
                return this.isSetTimeout();
            }
            case 3: {
                return this.isSetAcctName();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof CloseRequestNotification) {
            return this.equals((CloseRequestNotification)object);
        }
        return false;
    }

    public boolean equals(CloseRequestNotification closeRequestNotification) {
        if (closeRequestNotification == null) {
            return false;
        }
        if (this == closeRequestNotification) {
            return true;
        }
        boolean bl = this.isSetType();
        boolean bl2 = closeRequestNotification.isSetType();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.type.equals((Object)closeRequestNotification.type)) {
                return false;
            }
        }
        boolean bl3 = this.isSetReason();
        boolean bl4 = closeRequestNotification.isSetReason();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.reason.equals(closeRequestNotification.reason)) {
                return false;
            }
        }
        boolean bl5 = true;
        boolean bl6 = true;
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (this.timeout != closeRequestNotification.timeout) {
                return false;
            }
        }
        boolean bl7 = this.isSetAcctName();
        boolean bl8 = closeRequestNotification.isSetAcctName();
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (!this.acctName.equals(closeRequestNotification.acctName)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetType() ? 131071 : 524287);
        if (this.isSetType()) {
            n = n * 8191 + this.type.getValue();
        }
        n = n * 8191 + (this.isSetReason() ? 131071 : 524287);
        if (this.isSetReason()) {
            n = n * 8191 + this.reason.hashCode();
        }
        n = n * 8191 + this.timeout;
        n = n * 8191 + (this.isSetAcctName() ? 131071 : 524287);
        if (this.isSetAcctName()) {
            n = n * 8191 + this.acctName.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(CloseRequestNotification closeRequestNotification) {
        if (!this.getClass().equals(closeRequestNotification.getClass())) {
            return this.getClass().getName().compareTo(closeRequestNotification.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetType(), closeRequestNotification.isSetType());
        if (n != 0) {
            return n;
        }
        if (this.isSetType() && (n = TBaseHelper.compareTo((Comparable)((Object)this.type), (Comparable)((Object)closeRequestNotification.type))) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetReason(), closeRequestNotification.isSetReason());
        if (n != 0) {
            return n;
        }
        if (this.isSetReason() && (n = TBaseHelper.compareTo((String)this.reason, (String)closeRequestNotification.reason)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetTimeout(), closeRequestNotification.isSetTimeout());
        if (n != 0) {
            return n;
        }
        if (this.isSetTimeout() && (n = TBaseHelper.compareTo((int)this.timeout, (int)closeRequestNotification.timeout)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetAcctName(), closeRequestNotification.isSetAcctName());
        if (n != 0) {
            return n;
        }
        if (this.isSetAcctName() && (n = TBaseHelper.compareTo((String)this.acctName, (String)closeRequestNotification.acctName)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        CloseRequestNotification.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        CloseRequestNotification.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("CloseRequestNotification(");
        boolean bl = true;
        stringBuilder.append("type:");
        if (this.type == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append((Object)this.type);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("reason:");
        if (this.reason == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.reason);
        }
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
        stringBuilder.append("acctName:");
        if (this.acctName == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.acctName);
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
        enumMap.put(_Fields.TYPE, new FieldMetaData("type", 3, (FieldValueMetaData)new EnumMetaData(-1, CloseRequestType.class)));
        enumMap.put(_Fields.REASON, new FieldMetaData("reason", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.TIMEOUT, new FieldMetaData("timeout", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.ACCT_NAME, new FieldMetaData("acctName", 3, new FieldValueMetaData(11)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(CloseRequestNotification.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        TYPE(1, "type"),
        REASON(2, "reason"),
        TIMEOUT(3, "timeout"),
        ACCT_NAME(4, "acctName");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return TYPE;
                }
                case 2: {
                    return REASON;
                }
                case 3: {
                    return TIMEOUT;
                }
                case 4: {
                    return ACCT_NAME;
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

    private static class CloseRequestNotificationStandardSchemeFactory
    implements SchemeFactory {
        private CloseRequestNotificationStandardSchemeFactory() {
        }

        public CloseRequestNotificationStandardScheme getScheme() {
            return new CloseRequestNotificationStandardScheme();
        }
    }

    private static class CloseRequestNotificationTupleSchemeFactory
    implements SchemeFactory {
        private CloseRequestNotificationTupleSchemeFactory() {
        }

        public CloseRequestNotificationTupleScheme getScheme() {
            return new CloseRequestNotificationTupleScheme();
        }
    }

    private static class CloseRequestNotificationTupleScheme
    extends TupleScheme<CloseRequestNotification> {
        private CloseRequestNotificationTupleScheme() {
        }

        public void write(TProtocol tProtocol, CloseRequestNotification closeRequestNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (closeRequestNotification.isSetType()) {
                bitSet.set(0);
            }
            if (closeRequestNotification.isSetReason()) {
                bitSet.set(1);
            }
            if (closeRequestNotification.isSetTimeout()) {
                bitSet.set(2);
            }
            if (closeRequestNotification.isSetAcctName()) {
                bitSet.set(3);
            }
            tTupleProtocol.writeBitSet(bitSet, 4);
            if (closeRequestNotification.isSetType()) {
                tTupleProtocol.writeI32(closeRequestNotification.type.getValue());
            }
            if (closeRequestNotification.isSetReason()) {
                tTupleProtocol.writeString(closeRequestNotification.reason);
            }
            if (closeRequestNotification.isSetTimeout()) {
                tTupleProtocol.writeI32(closeRequestNotification.timeout);
            }
            if (closeRequestNotification.isSetAcctName()) {
                tTupleProtocol.writeString(closeRequestNotification.acctName);
            }
        }

        public void read(TProtocol tProtocol, CloseRequestNotification closeRequestNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(4);
            if (bitSet.get(0)) {
                closeRequestNotification.type = CloseRequestType.findByValue(tTupleProtocol.readI32());
                closeRequestNotification.setTypeIsSet(true);
            }
            if (bitSet.get(1)) {
                closeRequestNotification.reason = tTupleProtocol.readString();
                closeRequestNotification.setReasonIsSet(true);
            }
            if (bitSet.get(2)) {
                closeRequestNotification.timeout = tTupleProtocol.readI32();
                closeRequestNotification.setTimeoutIsSet(true);
            }
            if (bitSet.get(3)) {
                closeRequestNotification.acctName = tTupleProtocol.readString();
                closeRequestNotification.setAcctNameIsSet(true);
            }
        }
    }

    private static class CloseRequestNotificationStandardScheme
    extends StandardScheme<CloseRequestNotification> {
        private CloseRequestNotificationStandardScheme() {
        }

        public void read(TProtocol tProtocol, CloseRequestNotification closeRequestNotification) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 8) {
                            closeRequestNotification.type = CloseRequestType.findByValue(tProtocol.readI32());
                            closeRequestNotification.setTypeIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 11) {
                            closeRequestNotification.reason = tProtocol.readString();
                            closeRequestNotification.setReasonIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 8) {
                            closeRequestNotification.timeout = tProtocol.readI32();
                            closeRequestNotification.setTimeoutIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 11) {
                            closeRequestNotification.acctName = tProtocol.readString();
                            closeRequestNotification.setAcctNameIsSet(true);
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
            closeRequestNotification.validate();
        }

        public void write(TProtocol tProtocol, CloseRequestNotification closeRequestNotification) throws TException {
            closeRequestNotification.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (closeRequestNotification.type != null) {
                tProtocol.writeFieldBegin(TYPE_FIELD_DESC);
                tProtocol.writeI32(closeRequestNotification.type.getValue());
                tProtocol.writeFieldEnd();
            }
            if (closeRequestNotification.reason != null) {
                tProtocol.writeFieldBegin(REASON_FIELD_DESC);
                tProtocol.writeString(closeRequestNotification.reason);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(TIMEOUT_FIELD_DESC);
            tProtocol.writeI32(closeRequestNotification.timeout);
            tProtocol.writeFieldEnd();
            if (closeRequestNotification.acctName != null) {
                tProtocol.writeFieldBegin(ACCT_NAME_FIELD_DESC);
                tProtocol.writeString(closeRequestNotification.acctName);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

