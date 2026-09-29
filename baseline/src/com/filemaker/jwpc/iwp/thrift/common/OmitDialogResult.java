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

public class OmitDialogResult
implements TBase<OmitDialogResult, _Fields>,
Serializable,
Cloneable,
Comparable<OmitDialogResult> {
    private static final TStruct STRUCT_DESC = new TStruct("OmitDialogResult");
    private static final TField APPROVE_FIELD_DESC = new TField("approve", 2, 1);
    private static final TField OMIT_COUNT_FIELD_DESC = new TField("omitCount", 8, 2);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new OmitDialogResultStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new OmitDialogResultTupleSchemeFactory();
    private boolean approve;
    private int omitCount;
    private static final int __APPROVE_ISSET_ID = 0;
    private static final int __OMITCOUNT_ISSET_ID = 1;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public OmitDialogResult() {
    }

    public OmitDialogResult(boolean bl, int n) {
        this();
        this.approve = bl;
        this.setApproveIsSet(true);
        this.omitCount = n;
        this.setOmitCountIsSet(true);
    }

    public OmitDialogResult(OmitDialogResult omitDialogResult) {
        this.__isset_bitfield = omitDialogResult.__isset_bitfield;
        this.approve = omitDialogResult.approve;
        this.omitCount = omitDialogResult.omitCount;
    }

    public OmitDialogResult deepCopy() {
        return new OmitDialogResult(this);
    }

    public void clear() {
        this.setApproveIsSet(false);
        this.approve = false;
        this.setOmitCountIsSet(false);
        this.omitCount = 0;
    }

    public boolean isApprove() {
        return this.approve;
    }

    public void setApprove(boolean bl) {
        this.approve = bl;
        this.setApproveIsSet(true);
    }

    public void unsetApprove() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetApprove() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setApproveIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public int getOmitCount() {
        return this.omitCount;
    }

    public void setOmitCount(int n) {
        this.omitCount = n;
        this.setOmitCountIsSet(true);
    }

    public void unsetOmitCount() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)1);
    }

    public boolean isSetOmitCount() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)1);
    }

    public void setOmitCountIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)1, (boolean)bl);
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetApprove();
                    break;
                }
                this.setApprove((Boolean)object);
                break;
            }
            case 1: {
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
                return this.isApprove();
            }
            case 1: {
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
                return this.isSetApprove();
            }
            case 1: {
                return this.isSetOmitCount();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof OmitDialogResult) {
            return this.equals((OmitDialogResult)object);
        }
        return false;
    }

    public boolean equals(OmitDialogResult omitDialogResult) {
        if (omitDialogResult == null) {
            return false;
        }
        if (this == omitDialogResult) {
            return true;
        }
        boolean bl = true;
        boolean bl2 = true;
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (this.approve != omitDialogResult.approve) {
                return false;
            }
        }
        boolean bl3 = true;
        boolean bl4 = true;
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (this.omitCount != omitDialogResult.omitCount) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.approve ? 131071 : 524287);
        n = n * 8191 + this.omitCount;
        return n;
    }

    @Override
    public int compareTo(OmitDialogResult omitDialogResult) {
        if (!this.getClass().equals(omitDialogResult.getClass())) {
            return this.getClass().getName().compareTo(omitDialogResult.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetApprove(), omitDialogResult.isSetApprove());
        if (n != 0) {
            return n;
        }
        if (this.isSetApprove() && (n = TBaseHelper.compareTo((boolean)this.approve, (boolean)omitDialogResult.approve)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetOmitCount(), omitDialogResult.isSetOmitCount());
        if (n != 0) {
            return n;
        }
        if (this.isSetOmitCount() && (n = TBaseHelper.compareTo((int)this.omitCount, (int)omitDialogResult.omitCount)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        OmitDialogResult.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        OmitDialogResult.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("OmitDialogResult(");
        boolean bl = true;
        stringBuilder.append("approve:");
        stringBuilder.append(this.approve);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
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
        enumMap.put(_Fields.APPROVE, new FieldMetaData("approve", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.OMIT_COUNT, new FieldMetaData("omitCount", 3, new FieldValueMetaData(8)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(OmitDialogResult.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        APPROVE(1, "approve"),
        OMIT_COUNT(2, "omitCount");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return APPROVE;
                }
                case 2: {
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

    private static class OmitDialogResultStandardSchemeFactory
    implements SchemeFactory {
        private OmitDialogResultStandardSchemeFactory() {
        }

        public OmitDialogResultStandardScheme getScheme() {
            return new OmitDialogResultStandardScheme();
        }
    }

    private static class OmitDialogResultTupleSchemeFactory
    implements SchemeFactory {
        private OmitDialogResultTupleSchemeFactory() {
        }

        public OmitDialogResultTupleScheme getScheme() {
            return new OmitDialogResultTupleScheme();
        }
    }

    private static class OmitDialogResultTupleScheme
    extends TupleScheme<OmitDialogResult> {
        private OmitDialogResultTupleScheme() {
        }

        public void write(TProtocol tProtocol, OmitDialogResult omitDialogResult) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (omitDialogResult.isSetApprove()) {
                bitSet.set(0);
            }
            if (omitDialogResult.isSetOmitCount()) {
                bitSet.set(1);
            }
            tTupleProtocol.writeBitSet(bitSet, 2);
            if (omitDialogResult.isSetApprove()) {
                tTupleProtocol.writeBool(omitDialogResult.approve);
            }
            if (omitDialogResult.isSetOmitCount()) {
                tTupleProtocol.writeI32(omitDialogResult.omitCount);
            }
        }

        public void read(TProtocol tProtocol, OmitDialogResult omitDialogResult) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(2);
            if (bitSet.get(0)) {
                omitDialogResult.approve = tTupleProtocol.readBool();
                omitDialogResult.setApproveIsSet(true);
            }
            if (bitSet.get(1)) {
                omitDialogResult.omitCount = tTupleProtocol.readI32();
                omitDialogResult.setOmitCountIsSet(true);
            }
        }
    }

    private static class OmitDialogResultStandardScheme
    extends StandardScheme<OmitDialogResult> {
        private OmitDialogResultStandardScheme() {
        }

        public void read(TProtocol tProtocol, OmitDialogResult omitDialogResult) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 2) {
                            omitDialogResult.approve = tProtocol.readBool();
                            omitDialogResult.setApproveIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 8) {
                            omitDialogResult.omitCount = tProtocol.readI32();
                            omitDialogResult.setOmitCountIsSet(true);
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
            omitDialogResult.validate();
        }

        public void write(TProtocol tProtocol, OmitDialogResult omitDialogResult) throws TException {
            omitDialogResult.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            tProtocol.writeFieldBegin(APPROVE_FIELD_DESC);
            tProtocol.writeBool(omitDialogResult.approve);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(OMIT_COUNT_FIELD_DESC);
            tProtocol.writeI32(omitDialogResult.omitCount);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

