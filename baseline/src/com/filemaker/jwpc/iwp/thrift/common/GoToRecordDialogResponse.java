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
package com.filemaker.jwpc.iwp.thrift.common;

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

public class GoToRecordDialogResponse
implements TBase<GoToRecordDialogResponse, _Fields>,
Serializable,
Cloneable,
Comparable<GoToRecordDialogResponse> {
    private static final TStruct STRUCT_DESC = new TStruct("GoToRecordDialogResponse");
    private static final TField CONFIRM_FIELD_DESC = new TField("confirm", 2, 1);
    private static final TField RECORD_NUMBER_FIELD_DESC = new TField("recordNumber", 8, 2);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new GoToRecordDialogResponseStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new GoToRecordDialogResponseTupleSchemeFactory();
    private boolean confirm;
    private int recordNumber;
    private static final int __CONFIRM_ISSET_ID = 0;
    private static final int __RECORDNUMBER_ISSET_ID = 1;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public GoToRecordDialogResponse() {
    }

    public GoToRecordDialogResponse(boolean bl, int n) {
        this();
        this.confirm = bl;
        this.setConfirmIsSet(true);
        this.recordNumber = n;
        this.setRecordNumberIsSet(true);
    }

    public GoToRecordDialogResponse(GoToRecordDialogResponse goToRecordDialogResponse) {
        this.__isset_bitfield = goToRecordDialogResponse.__isset_bitfield;
        this.confirm = goToRecordDialogResponse.confirm;
        this.recordNumber = goToRecordDialogResponse.recordNumber;
    }

    public GoToRecordDialogResponse deepCopy() {
        return new GoToRecordDialogResponse(this);
    }

    public void clear() {
        this.setConfirmIsSet(false);
        this.confirm = false;
        this.setRecordNumberIsSet(false);
        this.recordNumber = 0;
    }

    public boolean isConfirm() {
        return this.confirm;
    }

    public void setConfirm(boolean bl) {
        this.confirm = bl;
        this.setConfirmIsSet(true);
    }

    public void unsetConfirm() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetConfirm() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setConfirmIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public int getRecordNumber() {
        return this.recordNumber;
    }

    public void setRecordNumber(int n) {
        this.recordNumber = n;
        this.setRecordNumberIsSet(true);
    }

    public void unsetRecordNumber() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)1);
    }

    public boolean isSetRecordNumber() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)1);
    }

    public void setRecordNumberIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)1, (boolean)bl);
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetConfirm();
                    break;
                }
                this.setConfirm((Boolean)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetRecordNumber();
                    break;
                }
                this.setRecordNumber((Integer)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.isConfirm();
            }
            case 1: {
                return this.getRecordNumber();
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
                return this.isSetConfirm();
            }
            case 1: {
                return this.isSetRecordNumber();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof GoToRecordDialogResponse) {
            return this.equals((GoToRecordDialogResponse)object);
        }
        return false;
    }

    public boolean equals(GoToRecordDialogResponse goToRecordDialogResponse) {
        if (goToRecordDialogResponse == null) {
            return false;
        }
        if (this == goToRecordDialogResponse) {
            return true;
        }
        boolean bl = true;
        boolean bl2 = true;
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (this.confirm != goToRecordDialogResponse.confirm) {
                return false;
            }
        }
        boolean bl3 = true;
        boolean bl4 = true;
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (this.recordNumber != goToRecordDialogResponse.recordNumber) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.confirm ? 131071 : 524287);
        n = n * 8191 + this.recordNumber;
        return n;
    }

    @Override
    public int compareTo(GoToRecordDialogResponse goToRecordDialogResponse) {
        if (!this.getClass().equals(goToRecordDialogResponse.getClass())) {
            return this.getClass().getName().compareTo(goToRecordDialogResponse.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetConfirm(), goToRecordDialogResponse.isSetConfirm());
        if (n != 0) {
            return n;
        }
        if (this.isSetConfirm() && (n = TBaseHelper.compareTo((boolean)this.confirm, (boolean)goToRecordDialogResponse.confirm)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetRecordNumber(), goToRecordDialogResponse.isSetRecordNumber());
        if (n != 0) {
            return n;
        }
        if (this.isSetRecordNumber() && (n = TBaseHelper.compareTo((int)this.recordNumber, (int)goToRecordDialogResponse.recordNumber)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        GoToRecordDialogResponse.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        GoToRecordDialogResponse.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("GoToRecordDialogResponse(");
        boolean bl = true;
        stringBuilder.append("confirm:");
        stringBuilder.append(this.confirm);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("recordNumber:");
        stringBuilder.append(this.recordNumber);
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
        enumMap.put(_Fields.CONFIRM, new FieldMetaData("confirm", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.RECORD_NUMBER, new FieldMetaData("recordNumber", 3, new FieldValueMetaData(8)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(GoToRecordDialogResponse.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        CONFIRM(1, "confirm"),
        RECORD_NUMBER(2, "recordNumber");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return CONFIRM;
                }
                case 2: {
                    return RECORD_NUMBER;
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

    private static class GoToRecordDialogResponseStandardSchemeFactory
    implements SchemeFactory {
        private GoToRecordDialogResponseStandardSchemeFactory() {
        }

        public GoToRecordDialogResponseStandardScheme getScheme() {
            return new GoToRecordDialogResponseStandardScheme();
        }
    }

    private static class GoToRecordDialogResponseTupleSchemeFactory
    implements SchemeFactory {
        private GoToRecordDialogResponseTupleSchemeFactory() {
        }

        public GoToRecordDialogResponseTupleScheme getScheme() {
            return new GoToRecordDialogResponseTupleScheme();
        }
    }

    private static class GoToRecordDialogResponseTupleScheme
    extends TupleScheme<GoToRecordDialogResponse> {
        private GoToRecordDialogResponseTupleScheme() {
        }

        public void write(TProtocol tProtocol, GoToRecordDialogResponse goToRecordDialogResponse) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (goToRecordDialogResponse.isSetConfirm()) {
                bitSet.set(0);
            }
            if (goToRecordDialogResponse.isSetRecordNumber()) {
                bitSet.set(1);
            }
            tTupleProtocol.writeBitSet(bitSet, 2);
            if (goToRecordDialogResponse.isSetConfirm()) {
                tTupleProtocol.writeBool(goToRecordDialogResponse.confirm);
            }
            if (goToRecordDialogResponse.isSetRecordNumber()) {
                tTupleProtocol.writeI32(goToRecordDialogResponse.recordNumber);
            }
        }

        public void read(TProtocol tProtocol, GoToRecordDialogResponse goToRecordDialogResponse) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(2);
            if (bitSet.get(0)) {
                goToRecordDialogResponse.confirm = tTupleProtocol.readBool();
                goToRecordDialogResponse.setConfirmIsSet(true);
            }
            if (bitSet.get(1)) {
                goToRecordDialogResponse.recordNumber = tTupleProtocol.readI32();
                goToRecordDialogResponse.setRecordNumberIsSet(true);
            }
        }
    }

    private static class GoToRecordDialogResponseStandardScheme
    extends StandardScheme<GoToRecordDialogResponse> {
        private GoToRecordDialogResponseStandardScheme() {
        }

        public void read(TProtocol tProtocol, GoToRecordDialogResponse goToRecordDialogResponse) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 2) {
                            goToRecordDialogResponse.confirm = tProtocol.readBool();
                            goToRecordDialogResponse.setConfirmIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 8) {
                            goToRecordDialogResponse.recordNumber = tProtocol.readI32();
                            goToRecordDialogResponse.setRecordNumberIsSet(true);
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
            goToRecordDialogResponse.validate();
        }

        public void write(TProtocol tProtocol, GoToRecordDialogResponse goToRecordDialogResponse) throws TException {
            goToRecordDialogResponse.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            tProtocol.writeFieldBegin(CONFIRM_FIELD_DESC);
            tProtocol.writeBool(goToRecordDialogResponse.confirm);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(RECORD_NUMBER_FIELD_DESC);
            tProtocol.writeI32(goToRecordDialogResponse.recordNumber);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

