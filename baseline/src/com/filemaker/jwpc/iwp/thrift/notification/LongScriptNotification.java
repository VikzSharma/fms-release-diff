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

public class LongScriptNotification
implements TBase<LongScriptNotification, _Fields>,
Serializable,
Cloneable,
Comparable<LongScriptNotification> {
    private static final TStruct STRUCT_DESC = new TStruct("LongScriptNotification");
    private static final TField ALLOW_ABORT_FIELD_DESC = new TField("allowAbort", 2, 1);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new LongScriptNotificationStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new LongScriptNotificationTupleSchemeFactory();
    private boolean allowAbort;
    private static final int __ALLOWABORT_ISSET_ID = 0;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public LongScriptNotification() {
    }

    public LongScriptNotification(boolean bl) {
        this();
        this.allowAbort = bl;
        this.setAllowAbortIsSet(true);
    }

    public LongScriptNotification(LongScriptNotification longScriptNotification) {
        this.__isset_bitfield = longScriptNotification.__isset_bitfield;
        this.allowAbort = longScriptNotification.allowAbort;
    }

    public LongScriptNotification deepCopy() {
        return new LongScriptNotification(this);
    }

    public void clear() {
        this.setAllowAbortIsSet(false);
        this.allowAbort = false;
    }

    public boolean isAllowAbort() {
        return this.allowAbort;
    }

    public void setAllowAbort(boolean bl) {
        this.allowAbort = bl;
        this.setAllowAbortIsSet(true);
    }

    public void unsetAllowAbort() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetAllowAbort() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setAllowAbortIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetAllowAbort();
                    break;
                }
                this.setAllowAbort((Boolean)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.isAllowAbort();
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
                return this.isSetAllowAbort();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof LongScriptNotification) {
            return this.equals((LongScriptNotification)object);
        }
        return false;
    }

    public boolean equals(LongScriptNotification longScriptNotification) {
        if (longScriptNotification == null) {
            return false;
        }
        if (this == longScriptNotification) {
            return true;
        }
        boolean bl = true;
        boolean bl2 = true;
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (this.allowAbort != longScriptNotification.allowAbort) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.allowAbort ? 131071 : 524287);
        return n;
    }

    @Override
    public int compareTo(LongScriptNotification longScriptNotification) {
        if (!this.getClass().equals(longScriptNotification.getClass())) {
            return this.getClass().getName().compareTo(longScriptNotification.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetAllowAbort(), longScriptNotification.isSetAllowAbort());
        if (n != 0) {
            return n;
        }
        if (this.isSetAllowAbort() && (n = TBaseHelper.compareTo((boolean)this.allowAbort, (boolean)longScriptNotification.allowAbort)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        LongScriptNotification.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        LongScriptNotification.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("LongScriptNotification(");
        boolean bl = true;
        stringBuilder.append("allowAbort:");
        stringBuilder.append(this.allowAbort);
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
        enumMap.put(_Fields.ALLOW_ABORT, new FieldMetaData("allowAbort", 3, new FieldValueMetaData(2)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(LongScriptNotification.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        ALLOW_ABORT(1, "allowAbort");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return ALLOW_ABORT;
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

    private static class LongScriptNotificationStandardSchemeFactory
    implements SchemeFactory {
        private LongScriptNotificationStandardSchemeFactory() {
        }

        public LongScriptNotificationStandardScheme getScheme() {
            return new LongScriptNotificationStandardScheme();
        }
    }

    private static class LongScriptNotificationTupleSchemeFactory
    implements SchemeFactory {
        private LongScriptNotificationTupleSchemeFactory() {
        }

        public LongScriptNotificationTupleScheme getScheme() {
            return new LongScriptNotificationTupleScheme();
        }
    }

    private static class LongScriptNotificationTupleScheme
    extends TupleScheme<LongScriptNotification> {
        private LongScriptNotificationTupleScheme() {
        }

        public void write(TProtocol tProtocol, LongScriptNotification longScriptNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (longScriptNotification.isSetAllowAbort()) {
                bitSet.set(0);
            }
            tTupleProtocol.writeBitSet(bitSet, 1);
            if (longScriptNotification.isSetAllowAbort()) {
                tTupleProtocol.writeBool(longScriptNotification.allowAbort);
            }
        }

        public void read(TProtocol tProtocol, LongScriptNotification longScriptNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(1);
            if (bitSet.get(0)) {
                longScriptNotification.allowAbort = tTupleProtocol.readBool();
                longScriptNotification.setAllowAbortIsSet(true);
            }
        }
    }

    private static class LongScriptNotificationStandardScheme
    extends StandardScheme<LongScriptNotification> {
        private LongScriptNotificationStandardScheme() {
        }

        public void read(TProtocol tProtocol, LongScriptNotification longScriptNotification) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 2) {
                            longScriptNotification.allowAbort = tProtocol.readBool();
                            longScriptNotification.setAllowAbortIsSet(true);
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
            longScriptNotification.validate();
        }

        public void write(TProtocol tProtocol, LongScriptNotification longScriptNotification) throws TException {
            longScriptNotification.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            tProtocol.writeFieldBegin(ALLOW_ABORT_FIELD_DESC);
            tProtocol.writeBool(longScriptNotification.allowAbort);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

