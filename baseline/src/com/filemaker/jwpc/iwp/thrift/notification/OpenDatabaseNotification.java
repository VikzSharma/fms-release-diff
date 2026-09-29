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

import com.filemaker.jwpc.iwp.thrift.common.DatabaseState;
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

public class OpenDatabaseNotification
implements TBase<OpenDatabaseNotification, _Fields>,
Serializable,
Cloneable,
Comparable<OpenDatabaseNotification> {
    private static final TStruct STRUCT_DESC = new TStruct("OpenDatabaseNotification");
    private static final TField STATE_FIELD_DESC = new TField("state", 8, 1);
    private static final TField STREAM_SESSION_KEY_FIELD_DESC = new TField("streamSessionKey", 11, 2);
    private static final TField TIMEOUT_FIELD_DESC = new TField("timeout", 8, 3);
    private static final TField OPTION_FIELD_DESC = new TField("option", 8, 4);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new OpenDatabaseNotificationStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new OpenDatabaseNotificationTupleSchemeFactory();
    @Nullable
    private DatabaseState state;
    @Nullable
    private String streamSessionKey;
    private int timeout;
    private int option;
    private static final int __TIMEOUT_ISSET_ID = 0;
    private static final int __OPTION_ISSET_ID = 1;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public OpenDatabaseNotification() {
    }

    public OpenDatabaseNotification(DatabaseState databaseState, String string, int n, int n2) {
        this();
        this.state = databaseState;
        this.streamSessionKey = string;
        this.timeout = n;
        this.setTimeoutIsSet(true);
        this.option = n2;
        this.setOptionIsSet(true);
    }

    public OpenDatabaseNotification(OpenDatabaseNotification openDatabaseNotification) {
        this.__isset_bitfield = openDatabaseNotification.__isset_bitfield;
        if (openDatabaseNotification.isSetState()) {
            this.state = openDatabaseNotification.state;
        }
        if (openDatabaseNotification.isSetStreamSessionKey()) {
            this.streamSessionKey = openDatabaseNotification.streamSessionKey;
        }
        this.timeout = openDatabaseNotification.timeout;
        this.option = openDatabaseNotification.option;
    }

    public OpenDatabaseNotification deepCopy() {
        return new OpenDatabaseNotification(this);
    }

    public void clear() {
        this.state = null;
        this.streamSessionKey = null;
        this.setTimeoutIsSet(false);
        this.timeout = 0;
        this.setOptionIsSet(false);
        this.option = 0;
    }

    @Nullable
    public DatabaseState getState() {
        return this.state;
    }

    public void setState(@Nullable DatabaseState databaseState) {
        this.state = databaseState;
    }

    public void unsetState() {
        this.state = null;
    }

    public boolean isSetState() {
        return this.state != null;
    }

    public void setStateIsSet(boolean bl) {
        if (!bl) {
            this.state = null;
        }
    }

    @Nullable
    public String getStreamSessionKey() {
        return this.streamSessionKey;
    }

    public void setStreamSessionKey(@Nullable String string) {
        this.streamSessionKey = string;
    }

    public void unsetStreamSessionKey() {
        this.streamSessionKey = null;
    }

    public boolean isSetStreamSessionKey() {
        return this.streamSessionKey != null;
    }

    public void setStreamSessionKeyIsSet(boolean bl) {
        if (!bl) {
            this.streamSessionKey = null;
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

    public int getOption() {
        return this.option;
    }

    public void setOption(int n) {
        this.option = n;
        this.setOptionIsSet(true);
    }

    public void unsetOption() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)1);
    }

    public boolean isSetOption() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)1);
    }

    public void setOptionIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)1, (boolean)bl);
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetState();
                    break;
                }
                this.setState((DatabaseState)((Object)object));
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetStreamSessionKey();
                    break;
                }
                this.setStreamSessionKey((String)object);
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
                    this.unsetOption();
                    break;
                }
                this.setOption((Integer)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getState();
            }
            case 1: {
                return this.getStreamSessionKey();
            }
            case 2: {
                return this.getTimeout();
            }
            case 3: {
                return this.getOption();
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
                return this.isSetState();
            }
            case 1: {
                return this.isSetStreamSessionKey();
            }
            case 2: {
                return this.isSetTimeout();
            }
            case 3: {
                return this.isSetOption();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof OpenDatabaseNotification) {
            return this.equals((OpenDatabaseNotification)object);
        }
        return false;
    }

    public boolean equals(OpenDatabaseNotification openDatabaseNotification) {
        if (openDatabaseNotification == null) {
            return false;
        }
        if (this == openDatabaseNotification) {
            return true;
        }
        boolean bl = this.isSetState();
        boolean bl2 = openDatabaseNotification.isSetState();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.state.equals((Object)openDatabaseNotification.state)) {
                return false;
            }
        }
        boolean bl3 = this.isSetStreamSessionKey();
        boolean bl4 = openDatabaseNotification.isSetStreamSessionKey();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.streamSessionKey.equals(openDatabaseNotification.streamSessionKey)) {
                return false;
            }
        }
        boolean bl5 = true;
        boolean bl6 = true;
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (this.timeout != openDatabaseNotification.timeout) {
                return false;
            }
        }
        boolean bl7 = true;
        boolean bl8 = true;
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (this.option != openDatabaseNotification.option) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetState() ? 131071 : 524287);
        if (this.isSetState()) {
            n = n * 8191 + this.state.getValue();
        }
        n = n * 8191 + (this.isSetStreamSessionKey() ? 131071 : 524287);
        if (this.isSetStreamSessionKey()) {
            n = n * 8191 + this.streamSessionKey.hashCode();
        }
        n = n * 8191 + this.timeout;
        n = n * 8191 + this.option;
        return n;
    }

    @Override
    public int compareTo(OpenDatabaseNotification openDatabaseNotification) {
        if (!this.getClass().equals(openDatabaseNotification.getClass())) {
            return this.getClass().getName().compareTo(openDatabaseNotification.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetState(), openDatabaseNotification.isSetState());
        if (n != 0) {
            return n;
        }
        if (this.isSetState() && (n = TBaseHelper.compareTo((Comparable)((Object)this.state), (Comparable)((Object)openDatabaseNotification.state))) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetStreamSessionKey(), openDatabaseNotification.isSetStreamSessionKey());
        if (n != 0) {
            return n;
        }
        if (this.isSetStreamSessionKey() && (n = TBaseHelper.compareTo((String)this.streamSessionKey, (String)openDatabaseNotification.streamSessionKey)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetTimeout(), openDatabaseNotification.isSetTimeout());
        if (n != 0) {
            return n;
        }
        if (this.isSetTimeout() && (n = TBaseHelper.compareTo((int)this.timeout, (int)openDatabaseNotification.timeout)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetOption(), openDatabaseNotification.isSetOption());
        if (n != 0) {
            return n;
        }
        if (this.isSetOption() && (n = TBaseHelper.compareTo((int)this.option, (int)openDatabaseNotification.option)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        OpenDatabaseNotification.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        OpenDatabaseNotification.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("OpenDatabaseNotification(");
        boolean bl = true;
        stringBuilder.append("state:");
        if (this.state == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append((Object)this.state);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("streamSessionKey:");
        if (this.streamSessionKey == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.streamSessionKey);
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
        stringBuilder.append("option:");
        stringBuilder.append(this.option);
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
        enumMap.put(_Fields.STATE, new FieldMetaData("state", 3, (FieldValueMetaData)new EnumMetaData(-1, DatabaseState.class)));
        enumMap.put(_Fields.STREAM_SESSION_KEY, new FieldMetaData("streamSessionKey", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.TIMEOUT, new FieldMetaData("timeout", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.OPTION, new FieldMetaData("option", 3, new FieldValueMetaData(8)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(OpenDatabaseNotification.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        STATE(1, "state"),
        STREAM_SESSION_KEY(2, "streamSessionKey"),
        TIMEOUT(3, "timeout"),
        OPTION(4, "option");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return STATE;
                }
                case 2: {
                    return STREAM_SESSION_KEY;
                }
                case 3: {
                    return TIMEOUT;
                }
                case 4: {
                    return OPTION;
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

    private static class OpenDatabaseNotificationStandardSchemeFactory
    implements SchemeFactory {
        private OpenDatabaseNotificationStandardSchemeFactory() {
        }

        public OpenDatabaseNotificationStandardScheme getScheme() {
            return new OpenDatabaseNotificationStandardScheme();
        }
    }

    private static class OpenDatabaseNotificationTupleSchemeFactory
    implements SchemeFactory {
        private OpenDatabaseNotificationTupleSchemeFactory() {
        }

        public OpenDatabaseNotificationTupleScheme getScheme() {
            return new OpenDatabaseNotificationTupleScheme();
        }
    }

    private static class OpenDatabaseNotificationTupleScheme
    extends TupleScheme<OpenDatabaseNotification> {
        private OpenDatabaseNotificationTupleScheme() {
        }

        public void write(TProtocol tProtocol, OpenDatabaseNotification openDatabaseNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (openDatabaseNotification.isSetState()) {
                bitSet.set(0);
            }
            if (openDatabaseNotification.isSetStreamSessionKey()) {
                bitSet.set(1);
            }
            if (openDatabaseNotification.isSetTimeout()) {
                bitSet.set(2);
            }
            if (openDatabaseNotification.isSetOption()) {
                bitSet.set(3);
            }
            tTupleProtocol.writeBitSet(bitSet, 4);
            if (openDatabaseNotification.isSetState()) {
                tTupleProtocol.writeI32(openDatabaseNotification.state.getValue());
            }
            if (openDatabaseNotification.isSetStreamSessionKey()) {
                tTupleProtocol.writeString(openDatabaseNotification.streamSessionKey);
            }
            if (openDatabaseNotification.isSetTimeout()) {
                tTupleProtocol.writeI32(openDatabaseNotification.timeout);
            }
            if (openDatabaseNotification.isSetOption()) {
                tTupleProtocol.writeI32(openDatabaseNotification.option);
            }
        }

        public void read(TProtocol tProtocol, OpenDatabaseNotification openDatabaseNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(4);
            if (bitSet.get(0)) {
                openDatabaseNotification.state = DatabaseState.findByValue(tTupleProtocol.readI32());
                openDatabaseNotification.setStateIsSet(true);
            }
            if (bitSet.get(1)) {
                openDatabaseNotification.streamSessionKey = tTupleProtocol.readString();
                openDatabaseNotification.setStreamSessionKeyIsSet(true);
            }
            if (bitSet.get(2)) {
                openDatabaseNotification.timeout = tTupleProtocol.readI32();
                openDatabaseNotification.setTimeoutIsSet(true);
            }
            if (bitSet.get(3)) {
                openDatabaseNotification.option = tTupleProtocol.readI32();
                openDatabaseNotification.setOptionIsSet(true);
            }
        }
    }

    private static class OpenDatabaseNotificationStandardScheme
    extends StandardScheme<OpenDatabaseNotification> {
        private OpenDatabaseNotificationStandardScheme() {
        }

        public void read(TProtocol tProtocol, OpenDatabaseNotification openDatabaseNotification) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 8) {
                            openDatabaseNotification.state = DatabaseState.findByValue(tProtocol.readI32());
                            openDatabaseNotification.setStateIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 11) {
                            openDatabaseNotification.streamSessionKey = tProtocol.readString();
                            openDatabaseNotification.setStreamSessionKeyIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 8) {
                            openDatabaseNotification.timeout = tProtocol.readI32();
                            openDatabaseNotification.setTimeoutIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 8) {
                            openDatabaseNotification.option = tProtocol.readI32();
                            openDatabaseNotification.setOptionIsSet(true);
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
            openDatabaseNotification.validate();
        }

        public void write(TProtocol tProtocol, OpenDatabaseNotification openDatabaseNotification) throws TException {
            openDatabaseNotification.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (openDatabaseNotification.state != null) {
                tProtocol.writeFieldBegin(STATE_FIELD_DESC);
                tProtocol.writeI32(openDatabaseNotification.state.getValue());
                tProtocol.writeFieldEnd();
            }
            if (openDatabaseNotification.streamSessionKey != null) {
                tProtocol.writeFieldBegin(STREAM_SESSION_KEY_FIELD_DESC);
                tProtocol.writeString(openDatabaseNotification.streamSessionKey);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(TIMEOUT_FIELD_DESC);
            tProtocol.writeI32(openDatabaseNotification.timeout);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(OPTION_FIELD_DESC);
            tProtocol.writeI32(openDatabaseNotification.option);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

