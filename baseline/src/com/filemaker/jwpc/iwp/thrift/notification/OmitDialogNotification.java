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

public class OmitDialogNotification
implements TBase<OmitDialogNotification, _Fields>,
Serializable,
Cloneable,
Comparable<OmitDialogNotification> {
    private static final TStruct STRUCT_DESC = new TStruct("OmitDialogNotification");
    private static final TField OMIT_COUNT_FIELD_DESC = new TField("omitCount", 8, 1);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new OmitDialogNotificationStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new OmitDialogNotificationTupleSchemeFactory();
    private int omitCount;
    private static final int __OMITCOUNT_ISSET_ID = 0;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public OmitDialogNotification() {
    }

    public OmitDialogNotification(int n) {
        this();
        this.omitCount = n;
        this.setOmitCountIsSet(true);
    }

    public OmitDialogNotification(OmitDialogNotification omitDialogNotification) {
        this.__isset_bitfield = omitDialogNotification.__isset_bitfield;
        this.omitCount = omitDialogNotification.omitCount;
    }

    public OmitDialogNotification deepCopy() {
        return new OmitDialogNotification(this);
    }

    public void clear() {
        this.setOmitCountIsSet(false);
        this.omitCount = 0;
    }

    public int getOmitCount() {
        return this.omitCount;
    }

    public void setOmitCount(int n) {
        this.omitCount = n;
        this.setOmitCountIsSet(true);
    }

    public void unsetOmitCount() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetOmitCount() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setOmitCountIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetOmitCount();
                    break;
                }
                this.setOmitCount((Integer)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getOmitCount();
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
                return this.isSetOmitCount();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof OmitDialogNotification) {
            return this.equals((OmitDialogNotification)object);
        }
        return false;
    }

    public boolean equals(OmitDialogNotification omitDialogNotification) {
        if (omitDialogNotification == null) {
            return false;
        }
        if (this == omitDialogNotification) {
            return true;
        }
        boolean bl = true;
        boolean bl2 = true;
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (this.omitCount != omitDialogNotification.omitCount) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + this.omitCount;
        return n;
    }

    @Override
    public int compareTo(OmitDialogNotification omitDialogNotification) {
        if (!this.getClass().equals(omitDialogNotification.getClass())) {
            return this.getClass().getName().compareTo(omitDialogNotification.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetOmitCount(), omitDialogNotification.isSetOmitCount());
        if (n != 0) {
            return n;
        }
        if (this.isSetOmitCount() && (n = TBaseHelper.compareTo((int)this.omitCount, (int)omitDialogNotification.omitCount)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        OmitDialogNotification.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        OmitDialogNotification.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("OmitDialogNotification(");
        boolean bl = true;
        stringBuilder.append("omitCount:");
        stringBuilder.append(this.omitCount);
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
        enumMap.put(_Fields.OMIT_COUNT, new FieldMetaData("omitCount", 3, new FieldValueMetaData(8)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(OmitDialogNotification.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        OMIT_COUNT(1, "omitCount");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return OMIT_COUNT;
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

    private static class OmitDialogNotificationStandardSchemeFactory
    implements SchemeFactory {
        private OmitDialogNotificationStandardSchemeFactory() {
        }

        public OmitDialogNotificationStandardScheme getScheme() {
            return new OmitDialogNotificationStandardScheme();
        }
    }

    private static class OmitDialogNotificationTupleSchemeFactory
    implements SchemeFactory {
        private OmitDialogNotificationTupleSchemeFactory() {
        }

        public OmitDialogNotificationTupleScheme getScheme() {
            return new OmitDialogNotificationTupleScheme();
        }
    }

    private static class OmitDialogNotificationTupleScheme
    extends TupleScheme<OmitDialogNotification> {
        private OmitDialogNotificationTupleScheme() {
        }

        public void write(TProtocol tProtocol, OmitDialogNotification omitDialogNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (omitDialogNotification.isSetOmitCount()) {
                bitSet.set(0);
            }
            tTupleProtocol.writeBitSet(bitSet, 1);
            if (omitDialogNotification.isSetOmitCount()) {
                tTupleProtocol.writeI32(omitDialogNotification.omitCount);
            }
        }

        public void read(TProtocol tProtocol, OmitDialogNotification omitDialogNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(1);
            if (bitSet.get(0)) {
                omitDialogNotification.omitCount = tTupleProtocol.readI32();
                omitDialogNotification.setOmitCountIsSet(true);
            }
        }
    }

    private static class OmitDialogNotificationStandardScheme
    extends StandardScheme<OmitDialogNotification> {
        private OmitDialogNotificationStandardScheme() {
        }

        public void read(TProtocol tProtocol, OmitDialogNotification omitDialogNotification) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 8) {
                            omitDialogNotification.omitCount = tProtocol.readI32();
                            omitDialogNotification.setOmitCountIsSet(true);
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
            omitDialogNotification.validate();
        }

        public void write(TProtocol tProtocol, OmitDialogNotification omitDialogNotification) throws TException {
            omitDialogNotification.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            tProtocol.writeFieldBegin(OMIT_COUNT_FIELD_DESC);
            tProtocol.writeI32(omitDialogNotification.omitCount);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

