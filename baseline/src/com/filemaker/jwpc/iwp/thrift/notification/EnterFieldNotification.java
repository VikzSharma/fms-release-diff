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

public class EnterFieldNotification
implements TBase<EnterFieldNotification, _Fields>,
Serializable,
Cloneable,
Comparable<EnterFieldNotification> {
    private static final TStruct STRUCT_DESC = new TStruct("EnterFieldNotification");
    private static final TField OBJECT_ID_FIELD_DESC = new TField("objectId", 8, 1);
    private static final TField RESULT_FIELD_DESC = new TField("result", 2, 2);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new EnterFieldNotificationStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new EnterFieldNotificationTupleSchemeFactory();
    private int objectId;
    private boolean result;
    private static final int __OBJECTID_ISSET_ID = 0;
    private static final int __RESULT_ISSET_ID = 1;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public EnterFieldNotification() {
    }

    public EnterFieldNotification(int n, boolean bl) {
        this();
        this.objectId = n;
        this.setObjectIdIsSet(true);
        this.result = bl;
        this.setResultIsSet(true);
    }

    public EnterFieldNotification(EnterFieldNotification enterFieldNotification) {
        this.__isset_bitfield = enterFieldNotification.__isset_bitfield;
        this.objectId = enterFieldNotification.objectId;
        this.result = enterFieldNotification.result;
    }

    public EnterFieldNotification deepCopy() {
        return new EnterFieldNotification(this);
    }

    public void clear() {
        this.setObjectIdIsSet(false);
        this.objectId = 0;
        this.setResultIsSet(false);
        this.result = false;
    }

    public int getObjectId() {
        return this.objectId;
    }

    public void setObjectId(int n) {
        this.objectId = n;
        this.setObjectIdIsSet(true);
    }

    public void unsetObjectId() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetObjectId() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setObjectIdIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public boolean isResult() {
        return this.result;
    }

    public void setResult(boolean bl) {
        this.result = bl;
        this.setResultIsSet(true);
    }

    public void unsetResult() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)1);
    }

    public boolean isSetResult() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)1);
    }

    public void setResultIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)1, (boolean)bl);
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetObjectId();
                    break;
                }
                this.setObjectId((Integer)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetResult();
                    break;
                }
                this.setResult((Boolean)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getObjectId();
            }
            case 1: {
                return this.isResult();
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
                return this.isSetObjectId();
            }
            case 1: {
                return this.isSetResult();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof EnterFieldNotification) {
            return this.equals((EnterFieldNotification)object);
        }
        return false;
    }

    public boolean equals(EnterFieldNotification enterFieldNotification) {
        if (enterFieldNotification == null) {
            return false;
        }
        if (this == enterFieldNotification) {
            return true;
        }
        boolean bl = true;
        boolean bl2 = true;
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (this.objectId != enterFieldNotification.objectId) {
                return false;
            }
        }
        boolean bl3 = true;
        boolean bl4 = true;
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (this.result != enterFieldNotification.result) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + this.objectId;
        n = n * 8191 + (this.result ? 131071 : 524287);
        return n;
    }

    @Override
    public int compareTo(EnterFieldNotification enterFieldNotification) {
        if (!this.getClass().equals(enterFieldNotification.getClass())) {
            return this.getClass().getName().compareTo(enterFieldNotification.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetObjectId(), enterFieldNotification.isSetObjectId());
        if (n != 0) {
            return n;
        }
        if (this.isSetObjectId() && (n = TBaseHelper.compareTo((int)this.objectId, (int)enterFieldNotification.objectId)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetResult(), enterFieldNotification.isSetResult());
        if (n != 0) {
            return n;
        }
        if (this.isSetResult() && (n = TBaseHelper.compareTo((boolean)this.result, (boolean)enterFieldNotification.result)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        EnterFieldNotification.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        EnterFieldNotification.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("EnterFieldNotification(");
        boolean bl = true;
        stringBuilder.append("objectId:");
        stringBuilder.append(this.objectId);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("result:");
        stringBuilder.append(this.result);
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
        enumMap.put(_Fields.OBJECT_ID, new FieldMetaData("objectId", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.RESULT, new FieldMetaData("result", 3, new FieldValueMetaData(2)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(EnterFieldNotification.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        OBJECT_ID(1, "objectId"),
        RESULT(2, "result");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return OBJECT_ID;
                }
                case 2: {
                    return RESULT;
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

    private static class EnterFieldNotificationStandardSchemeFactory
    implements SchemeFactory {
        private EnterFieldNotificationStandardSchemeFactory() {
        }

        public EnterFieldNotificationStandardScheme getScheme() {
            return new EnterFieldNotificationStandardScheme();
        }
    }

    private static class EnterFieldNotificationTupleSchemeFactory
    implements SchemeFactory {
        private EnterFieldNotificationTupleSchemeFactory() {
        }

        public EnterFieldNotificationTupleScheme getScheme() {
            return new EnterFieldNotificationTupleScheme();
        }
    }

    private static class EnterFieldNotificationTupleScheme
    extends TupleScheme<EnterFieldNotification> {
        private EnterFieldNotificationTupleScheme() {
        }

        public void write(TProtocol tProtocol, EnterFieldNotification enterFieldNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (enterFieldNotification.isSetObjectId()) {
                bitSet.set(0);
            }
            if (enterFieldNotification.isSetResult()) {
                bitSet.set(1);
            }
            tTupleProtocol.writeBitSet(bitSet, 2);
            if (enterFieldNotification.isSetObjectId()) {
                tTupleProtocol.writeI32(enterFieldNotification.objectId);
            }
            if (enterFieldNotification.isSetResult()) {
                tTupleProtocol.writeBool(enterFieldNotification.result);
            }
        }

        public void read(TProtocol tProtocol, EnterFieldNotification enterFieldNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(2);
            if (bitSet.get(0)) {
                enterFieldNotification.objectId = tTupleProtocol.readI32();
                enterFieldNotification.setObjectIdIsSet(true);
            }
            if (bitSet.get(1)) {
                enterFieldNotification.result = tTupleProtocol.readBool();
                enterFieldNotification.setResultIsSet(true);
            }
        }
    }

    private static class EnterFieldNotificationStandardScheme
    extends StandardScheme<EnterFieldNotification> {
        private EnterFieldNotificationStandardScheme() {
        }

        public void read(TProtocol tProtocol, EnterFieldNotification enterFieldNotification) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 8) {
                            enterFieldNotification.objectId = tProtocol.readI32();
                            enterFieldNotification.setObjectIdIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 2) {
                            enterFieldNotification.result = tProtocol.readBool();
                            enterFieldNotification.setResultIsSet(true);
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
            enterFieldNotification.validate();
        }

        public void write(TProtocol tProtocol, EnterFieldNotification enterFieldNotification) throws TException {
            enterFieldNotification.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            tProtocol.writeFieldBegin(OBJECT_ID_FIELD_DESC);
            tProtocol.writeI32(enterFieldNotification.objectId);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(RESULT_FIELD_DESC);
            tProtocol.writeBool(enterFieldNotification.result);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

