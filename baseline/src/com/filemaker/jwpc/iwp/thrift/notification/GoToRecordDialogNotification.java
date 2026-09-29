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

public class GoToRecordDialogNotification
implements TBase<GoToRecordDialogNotification, _Fields>,
Serializable,
Cloneable,
Comparable<GoToRecordDialogNotification> {
    private static final TStruct STRUCT_DESC = new TStruct("GoToRecordDialogNotification");
    private static final TField RECORD_NUMBER_FIELD_DESC = new TField("recordNumber", 8, 1);
    private static final TField MAX_NUMBER_FIELD_DESC = new TField("maxNumber", 8, 2);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new GoToRecordDialogNotificationStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new GoToRecordDialogNotificationTupleSchemeFactory();
    private int recordNumber;
    private int maxNumber;
    private static final int __RECORDNUMBER_ISSET_ID = 0;
    private static final int __MAXNUMBER_ISSET_ID = 1;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public GoToRecordDialogNotification() {
    }

    public GoToRecordDialogNotification(int n, int n2) {
        this();
        this.recordNumber = n;
        this.setRecordNumberIsSet(true);
        this.maxNumber = n2;
        this.setMaxNumberIsSet(true);
    }

    public GoToRecordDialogNotification(GoToRecordDialogNotification goToRecordDialogNotification) {
        this.__isset_bitfield = goToRecordDialogNotification.__isset_bitfield;
        this.recordNumber = goToRecordDialogNotification.recordNumber;
        this.maxNumber = goToRecordDialogNotification.maxNumber;
    }

    public GoToRecordDialogNotification deepCopy() {
        return new GoToRecordDialogNotification(this);
    }

    public void clear() {
        this.setRecordNumberIsSet(false);
        this.recordNumber = 0;
        this.setMaxNumberIsSet(false);
        this.maxNumber = 0;
    }

    public int getRecordNumber() {
        return this.recordNumber;
    }

    public void setRecordNumber(int n) {
        this.recordNumber = n;
        this.setRecordNumberIsSet(true);
    }

    public void unsetRecordNumber() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetRecordNumber() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setRecordNumberIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public int getMaxNumber() {
        return this.maxNumber;
    }

    public void setMaxNumber(int n) {
        this.maxNumber = n;
        this.setMaxNumberIsSet(true);
    }

    public void unsetMaxNumber() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)1);
    }

    public boolean isSetMaxNumber() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)1);
    }

    public void setMaxNumberIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)1, (boolean)bl);
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetRecordNumber();
                    break;
                }
                this.setRecordNumber((Integer)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetMaxNumber();
                    break;
                }
                this.setMaxNumber((Integer)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getRecordNumber();
            }
            case 1: {
                return this.getMaxNumber();
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
                return this.isSetRecordNumber();
            }
            case 1: {
                return this.isSetMaxNumber();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof GoToRecordDialogNotification) {
            return this.equals((GoToRecordDialogNotification)object);
        }
        return false;
    }

    public boolean equals(GoToRecordDialogNotification goToRecordDialogNotification) {
        if (goToRecordDialogNotification == null) {
            return false;
        }
        if (this == goToRecordDialogNotification) {
            return true;
        }
        boolean bl = true;
        boolean bl2 = true;
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (this.recordNumber != goToRecordDialogNotification.recordNumber) {
                return false;
            }
        }
        boolean bl3 = true;
        boolean bl4 = true;
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (this.maxNumber != goToRecordDialogNotification.maxNumber) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + this.recordNumber;
        n = n * 8191 + this.maxNumber;
        return n;
    }

    @Override
    public int compareTo(GoToRecordDialogNotification goToRecordDialogNotification) {
        if (!this.getClass().equals(goToRecordDialogNotification.getClass())) {
            return this.getClass().getName().compareTo(goToRecordDialogNotification.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetRecordNumber(), goToRecordDialogNotification.isSetRecordNumber());
        if (n != 0) {
            return n;
        }
        if (this.isSetRecordNumber() && (n = TBaseHelper.compareTo((int)this.recordNumber, (int)goToRecordDialogNotification.recordNumber)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetMaxNumber(), goToRecordDialogNotification.isSetMaxNumber());
        if (n != 0) {
            return n;
        }
        if (this.isSetMaxNumber() && (n = TBaseHelper.compareTo((int)this.maxNumber, (int)goToRecordDialogNotification.maxNumber)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        GoToRecordDialogNotification.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        GoToRecordDialogNotification.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("GoToRecordDialogNotification(");
        boolean bl = true;
        stringBuilder.append("recordNumber:");
        stringBuilder.append(this.recordNumber);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("maxNumber:");
        stringBuilder.append(this.maxNumber);
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
        enumMap.put(_Fields.RECORD_NUMBER, new FieldMetaData("recordNumber", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.MAX_NUMBER, new FieldMetaData("maxNumber", 3, new FieldValueMetaData(8)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(GoToRecordDialogNotification.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        RECORD_NUMBER(1, "recordNumber"),
        MAX_NUMBER(2, "maxNumber");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return RECORD_NUMBER;
                }
                case 2: {
                    return MAX_NUMBER;
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

    private static class GoToRecordDialogNotificationStandardSchemeFactory
    implements SchemeFactory {
        private GoToRecordDialogNotificationStandardSchemeFactory() {
        }

        public GoToRecordDialogNotificationStandardScheme getScheme() {
            return new GoToRecordDialogNotificationStandardScheme();
        }
    }

    private static class GoToRecordDialogNotificationTupleSchemeFactory
    implements SchemeFactory {
        private GoToRecordDialogNotificationTupleSchemeFactory() {
        }

        public GoToRecordDialogNotificationTupleScheme getScheme() {
            return new GoToRecordDialogNotificationTupleScheme();
        }
    }

    private static class GoToRecordDialogNotificationTupleScheme
    extends TupleScheme<GoToRecordDialogNotification> {
        private GoToRecordDialogNotificationTupleScheme() {
        }

        public void write(TProtocol tProtocol, GoToRecordDialogNotification goToRecordDialogNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (goToRecordDialogNotification.isSetRecordNumber()) {
                bitSet.set(0);
            }
            if (goToRecordDialogNotification.isSetMaxNumber()) {
                bitSet.set(1);
            }
            tTupleProtocol.writeBitSet(bitSet, 2);
            if (goToRecordDialogNotification.isSetRecordNumber()) {
                tTupleProtocol.writeI32(goToRecordDialogNotification.recordNumber);
            }
            if (goToRecordDialogNotification.isSetMaxNumber()) {
                tTupleProtocol.writeI32(goToRecordDialogNotification.maxNumber);
            }
        }

        public void read(TProtocol tProtocol, GoToRecordDialogNotification goToRecordDialogNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(2);
            if (bitSet.get(0)) {
                goToRecordDialogNotification.recordNumber = tTupleProtocol.readI32();
                goToRecordDialogNotification.setRecordNumberIsSet(true);
            }
            if (bitSet.get(1)) {
                goToRecordDialogNotification.maxNumber = tTupleProtocol.readI32();
                goToRecordDialogNotification.setMaxNumberIsSet(true);
            }
        }
    }

    private static class GoToRecordDialogNotificationStandardScheme
    extends StandardScheme<GoToRecordDialogNotification> {
        private GoToRecordDialogNotificationStandardScheme() {
        }

        public void read(TProtocol tProtocol, GoToRecordDialogNotification goToRecordDialogNotification) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 8) {
                            goToRecordDialogNotification.recordNumber = tProtocol.readI32();
                            goToRecordDialogNotification.setRecordNumberIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 8) {
                            goToRecordDialogNotification.maxNumber = tProtocol.readI32();
                            goToRecordDialogNotification.setMaxNumberIsSet(true);
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
            goToRecordDialogNotification.validate();
        }

        public void write(TProtocol tProtocol, GoToRecordDialogNotification goToRecordDialogNotification) throws TException {
            goToRecordDialogNotification.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            tProtocol.writeFieldBegin(RECORD_NUMBER_FIELD_DESC);
            tProtocol.writeI32(goToRecordDialogNotification.recordNumber);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(MAX_NUMBER_FIELD_DESC);
            tProtocol.writeI32(goToRecordDialogNotification.maxNumber);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

