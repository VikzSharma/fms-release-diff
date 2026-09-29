/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
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

import com.filemaker.jwpc.iwp.thrift.common.SessionDisconnectType;
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

public class SessionDisconnectNotification
implements TBase<SessionDisconnectNotification, _Fields>,
Serializable,
Cloneable,
Comparable<SessionDisconnectNotification> {
    private static final TStruct STRUCT_DESC = new TStruct("SessionDisconnectNotification");
    private static final TField TYPE_FIELD_DESC = new TField("type", 8, 1);
    private static final TField REASON_FIELD_DESC = new TField("reason", 11, 2);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new SessionDisconnectNotificationStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new SessionDisconnectNotificationTupleSchemeFactory();
    @Nullable
    private SessionDisconnectType type;
    @Nullable
    private String reason;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public SessionDisconnectNotification() {
    }

    public SessionDisconnectNotification(SessionDisconnectType sessionDisconnectType, String string) {
        this();
        this.type = sessionDisconnectType;
        this.reason = string;
    }

    public SessionDisconnectNotification(SessionDisconnectNotification sessionDisconnectNotification) {
        if (sessionDisconnectNotification.isSetType()) {
            this.type = sessionDisconnectNotification.type;
        }
        if (sessionDisconnectNotification.isSetReason()) {
            this.reason = sessionDisconnectNotification.reason;
        }
    }

    public SessionDisconnectNotification deepCopy() {
        return new SessionDisconnectNotification(this);
    }

    public void clear() {
        this.type = null;
        this.reason = null;
    }

    @Nullable
    public SessionDisconnectType getType() {
        return this.type;
    }

    public void setType(@Nullable SessionDisconnectType sessionDisconnectType) {
        this.type = sessionDisconnectType;
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

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetType();
                    break;
                }
                this.setType((SessionDisconnectType)((Object)object));
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
                return this.getType();
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
                return this.isSetType();
            }
            case 1: {
                return this.isSetReason();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof SessionDisconnectNotification) {
            return this.equals((SessionDisconnectNotification)object);
        }
        return false;
    }

    public boolean equals(SessionDisconnectNotification sessionDisconnectNotification) {
        if (sessionDisconnectNotification == null) {
            return false;
        }
        if (this == sessionDisconnectNotification) {
            return true;
        }
        boolean bl = this.isSetType();
        boolean bl2 = sessionDisconnectNotification.isSetType();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.type.equals((Object)sessionDisconnectNotification.type)) {
                return false;
            }
        }
        boolean bl3 = this.isSetReason();
        boolean bl4 = sessionDisconnectNotification.isSetReason();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.reason.equals(sessionDisconnectNotification.reason)) {
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
        return n;
    }

    @Override
    public int compareTo(SessionDisconnectNotification sessionDisconnectNotification) {
        if (!this.getClass().equals(sessionDisconnectNotification.getClass())) {
            return this.getClass().getName().compareTo(sessionDisconnectNotification.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetType(), sessionDisconnectNotification.isSetType());
        if (n != 0) {
            return n;
        }
        if (this.isSetType() && (n = TBaseHelper.compareTo((Comparable)((Object)this.type), (Comparable)((Object)sessionDisconnectNotification.type))) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetReason(), sessionDisconnectNotification.isSetReason());
        if (n != 0) {
            return n;
        }
        if (this.isSetReason() && (n = TBaseHelper.compareTo((String)this.reason, (String)sessionDisconnectNotification.reason)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        SessionDisconnectNotification.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        SessionDisconnectNotification.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("SessionDisconnectNotification(");
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
        enumMap.put(_Fields.TYPE, new FieldMetaData("type", 3, (FieldValueMetaData)new EnumMetaData(-1, SessionDisconnectType.class)));
        enumMap.put(_Fields.REASON, new FieldMetaData("reason", 3, new FieldValueMetaData(11)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(SessionDisconnectNotification.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        TYPE(1, "type"),
        REASON(2, "reason");

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

    private static class SessionDisconnectNotificationStandardSchemeFactory
    implements SchemeFactory {
        private SessionDisconnectNotificationStandardSchemeFactory() {
        }

        public SessionDisconnectNotificationStandardScheme getScheme() {
            return new SessionDisconnectNotificationStandardScheme();
        }
    }

    private static class SessionDisconnectNotificationTupleSchemeFactory
    implements SchemeFactory {
        private SessionDisconnectNotificationTupleSchemeFactory() {
        }

        public SessionDisconnectNotificationTupleScheme getScheme() {
            return new SessionDisconnectNotificationTupleScheme();
        }
    }

    private static class SessionDisconnectNotificationTupleScheme
    extends TupleScheme<SessionDisconnectNotification> {
        private SessionDisconnectNotificationTupleScheme() {
        }

        public void write(TProtocol tProtocol, SessionDisconnectNotification sessionDisconnectNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (sessionDisconnectNotification.isSetType()) {
                bitSet.set(0);
            }
            if (sessionDisconnectNotification.isSetReason()) {
                bitSet.set(1);
            }
            tTupleProtocol.writeBitSet(bitSet, 2);
            if (sessionDisconnectNotification.isSetType()) {
                tTupleProtocol.writeI32(sessionDisconnectNotification.type.getValue());
            }
            if (sessionDisconnectNotification.isSetReason()) {
                tTupleProtocol.writeString(sessionDisconnectNotification.reason);
            }
        }

        public void read(TProtocol tProtocol, SessionDisconnectNotification sessionDisconnectNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(2);
            if (bitSet.get(0)) {
                sessionDisconnectNotification.type = SessionDisconnectType.findByValue(tTupleProtocol.readI32());
                sessionDisconnectNotification.setTypeIsSet(true);
            }
            if (bitSet.get(1)) {
                sessionDisconnectNotification.reason = tTupleProtocol.readString();
                sessionDisconnectNotification.setReasonIsSet(true);
            }
        }
    }

    private static class SessionDisconnectNotificationStandardScheme
    extends StandardScheme<SessionDisconnectNotification> {
        private SessionDisconnectNotificationStandardScheme() {
        }

        public void read(TProtocol tProtocol, SessionDisconnectNotification sessionDisconnectNotification) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 8) {
                            sessionDisconnectNotification.type = SessionDisconnectType.findByValue(tProtocol.readI32());
                            sessionDisconnectNotification.setTypeIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 11) {
                            sessionDisconnectNotification.reason = tProtocol.readString();
                            sessionDisconnectNotification.setReasonIsSet(true);
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
            sessionDisconnectNotification.validate();
        }

        public void write(TProtocol tProtocol, SessionDisconnectNotification sessionDisconnectNotification) throws TException {
            sessionDisconnectNotification.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (sessionDisconnectNotification.type != null) {
                tProtocol.writeFieldBegin(TYPE_FIELD_DESC);
                tProtocol.writeI32(sessionDisconnectNotification.type.getValue());
                tProtocol.writeFieldEnd();
            }
            if (sessionDisconnectNotification.reason != null) {
                tProtocol.writeFieldBegin(REASON_FIELD_DESC);
                tProtocol.writeString(sessionDisconnectNotification.reason);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

