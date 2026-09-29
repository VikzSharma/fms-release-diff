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

public class SessionExpiredNotification
implements TBase<SessionExpiredNotification, _Fields>,
Serializable,
Cloneable,
Comparable<SessionExpiredNotification> {
    private static final TStruct STRUCT_DESC = new TStruct("SessionExpiredNotification");
    private static final TField DURATION_FIELD_DESC = new TField("duration", 8, 1);
    private static final TField REASON_FIELD_DESC = new TField("reason", 11, 2);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new SessionExpiredNotificationStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new SessionExpiredNotificationTupleSchemeFactory();
    private int duration;
    @Nullable
    private String reason;
    private static final int __DURATION_ISSET_ID = 0;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public SessionExpiredNotification() {
    }

    public SessionExpiredNotification(int n, String string) {
        this();
        this.duration = n;
        this.setDurationIsSet(true);
        this.reason = string;
    }

    public SessionExpiredNotification(SessionExpiredNotification sessionExpiredNotification) {
        this.__isset_bitfield = sessionExpiredNotification.__isset_bitfield;
        this.duration = sessionExpiredNotification.duration;
        if (sessionExpiredNotification.isSetReason()) {
            this.reason = sessionExpiredNotification.reason;
        }
    }

    public SessionExpiredNotification deepCopy() {
        return new SessionExpiredNotification(this);
    }

    public void clear() {
        this.setDurationIsSet(false);
        this.duration = 0;
        this.reason = null;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int n) {
        this.duration = n;
        this.setDurationIsSet(true);
    }

    public void unsetDuration() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetDuration() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setDurationIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
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

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetDuration();
                    break;
                }
                this.setDuration((Integer)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetReason();
                    break;
                }
                this.setReason((String)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getDuration();
            }
            case 1: {
                return this.getReason();
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
                return this.isSetDuration();
            }
            case 1: {
                return this.isSetReason();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof SessionExpiredNotification) {
            return this.equals((SessionExpiredNotification)object);
        }
        return false;
    }

    public boolean equals(SessionExpiredNotification sessionExpiredNotification) {
        if (sessionExpiredNotification == null) {
            return false;
        }
        if (this == sessionExpiredNotification) {
            return true;
        }
        boolean bl = true;
        boolean bl2 = true;
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (this.duration != sessionExpiredNotification.duration) {
                return false;
            }
        }
        boolean bl3 = this.isSetReason();
        boolean bl4 = sessionExpiredNotification.isSetReason();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.reason.equals(sessionExpiredNotification.reason)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + this.duration;
        n = n * 8191 + (this.isSetReason() ? 131071 : 524287);
        if (this.isSetReason()) {
            n = n * 8191 + this.reason.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(SessionExpiredNotification sessionExpiredNotification) {
        if (!this.getClass().equals(sessionExpiredNotification.getClass())) {
            return this.getClass().getName().compareTo(sessionExpiredNotification.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetDuration(), sessionExpiredNotification.isSetDuration());
        if (n != 0) {
            return n;
        }
        if (this.isSetDuration() && (n = TBaseHelper.compareTo((int)this.duration, (int)sessionExpiredNotification.duration)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetReason(), sessionExpiredNotification.isSetReason());
        if (n != 0) {
            return n;
        }
        if (this.isSetReason() && (n = TBaseHelper.compareTo((String)this.reason, (String)sessionExpiredNotification.reason)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        SessionExpiredNotification.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        SessionExpiredNotification.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("SessionExpiredNotification(");
        boolean bl = true;
        stringBuilder.append("duration:");
        stringBuilder.append(this.duration);
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
        enumMap.put(_Fields.DURATION, new FieldMetaData("duration", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.REASON, new FieldMetaData("reason", 3, new FieldValueMetaData(11)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(SessionExpiredNotification.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        DURATION(1, "duration"),
        REASON(2, "reason");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return DURATION;
                }
                case 2: {
                    return REASON;
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

    private static class SessionExpiredNotificationStandardSchemeFactory
    implements SchemeFactory {
        private SessionExpiredNotificationStandardSchemeFactory() {
        }

        public SessionExpiredNotificationStandardScheme getScheme() {
            return new SessionExpiredNotificationStandardScheme();
        }
    }

    private static class SessionExpiredNotificationTupleSchemeFactory
    implements SchemeFactory {
        private SessionExpiredNotificationTupleSchemeFactory() {
        }

        public SessionExpiredNotificationTupleScheme getScheme() {
            return new SessionExpiredNotificationTupleScheme();
        }
    }

    private static class SessionExpiredNotificationTupleScheme
    extends TupleScheme<SessionExpiredNotification> {
        private SessionExpiredNotificationTupleScheme() {
        }

        public void write(TProtocol tProtocol, SessionExpiredNotification sessionExpiredNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (sessionExpiredNotification.isSetDuration()) {
                bitSet.set(0);
            }
            if (sessionExpiredNotification.isSetReason()) {
                bitSet.set(1);
            }
            tTupleProtocol.writeBitSet(bitSet, 2);
            if (sessionExpiredNotification.isSetDuration()) {
                tTupleProtocol.writeI32(sessionExpiredNotification.duration);
            }
            if (sessionExpiredNotification.isSetReason()) {
                tTupleProtocol.writeString(sessionExpiredNotification.reason);
            }
        }

        public void read(TProtocol tProtocol, SessionExpiredNotification sessionExpiredNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(2);
            if (bitSet.get(0)) {
                sessionExpiredNotification.duration = tTupleProtocol.readI32();
                sessionExpiredNotification.setDurationIsSet(true);
            }
            if (bitSet.get(1)) {
                sessionExpiredNotification.reason = tTupleProtocol.readString();
                sessionExpiredNotification.setReasonIsSet(true);
            }
        }
    }

    private static class SessionExpiredNotificationStandardScheme
    extends StandardScheme<SessionExpiredNotification> {
        private SessionExpiredNotificationStandardScheme() {
        }

        public void read(TProtocol tProtocol, SessionExpiredNotification sessionExpiredNotification) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 8) {
                            sessionExpiredNotification.duration = tProtocol.readI32();
                            sessionExpiredNotification.setDurationIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 11) {
                            sessionExpiredNotification.reason = tProtocol.readString();
                            sessionExpiredNotification.setReasonIsSet(true);
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
            sessionExpiredNotification.validate();
        }

        public void write(TProtocol tProtocol, SessionExpiredNotification sessionExpiredNotification) throws TException {
            sessionExpiredNotification.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            tProtocol.writeFieldBegin(DURATION_FIELD_DESC);
            tProtocol.writeI32(sessionExpiredNotification.duration);
            tProtocol.writeFieldEnd();
            if (sessionExpiredNotification.reason != null) {
                tProtocol.writeFieldBegin(REASON_FIELD_DESC);
                tProtocol.writeString(sessionExpiredNotification.reason);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

