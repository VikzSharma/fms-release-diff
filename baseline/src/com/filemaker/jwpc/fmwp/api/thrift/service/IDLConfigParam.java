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
package com.filemaker.jwpc.fmwp.api.thrift.service;

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

public class IDLConfigParam
implements TBase<IDLConfigParam, _Fields>,
Serializable,
Cloneable,
Comparable<IDLConfigParam> {
    private static final TStruct STRUCT_DESC = new TStruct("IDLConfigParam");
    private static final TField CWP_SESSION_LIMIT_FIELD_DESC = new TField("cwpSessionLimit", 8, 1);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new IDLConfigParamStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new IDLConfigParamTupleSchemeFactory();
    private int cwpSessionLimit;
    private static final int __CWPSESSIONLIMIT_ISSET_ID = 0;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public IDLConfigParam() {
    }

    public IDLConfigParam(int n) {
        this();
        this.cwpSessionLimit = n;
        this.setCwpSessionLimitIsSet(true);
    }

    public IDLConfigParam(IDLConfigParam iDLConfigParam) {
        this.__isset_bitfield = iDLConfigParam.__isset_bitfield;
        this.cwpSessionLimit = iDLConfigParam.cwpSessionLimit;
    }

    public IDLConfigParam deepCopy() {
        return new IDLConfigParam(this);
    }

    public void clear() {
        this.setCwpSessionLimitIsSet(false);
        this.cwpSessionLimit = 0;
    }

    public int getCwpSessionLimit() {
        return this.cwpSessionLimit;
    }

    public void setCwpSessionLimit(int n) {
        this.cwpSessionLimit = n;
        this.setCwpSessionLimitIsSet(true);
    }

    public void unsetCwpSessionLimit() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetCwpSessionLimit() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setCwpSessionLimitIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetCwpSessionLimit();
                    break;
                }
                this.setCwpSessionLimit((Integer)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getCwpSessionLimit();
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
                return this.isSetCwpSessionLimit();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof IDLConfigParam) {
            return this.equals((IDLConfigParam)object);
        }
        return false;
    }

    public boolean equals(IDLConfigParam iDLConfigParam) {
        if (iDLConfigParam == null) {
            return false;
        }
        if (this == iDLConfigParam) {
            return true;
        }
        boolean bl = true;
        boolean bl2 = true;
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (this.cwpSessionLimit != iDLConfigParam.cwpSessionLimit) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + this.cwpSessionLimit;
        return n;
    }

    @Override
    public int compareTo(IDLConfigParam iDLConfigParam) {
        if (!this.getClass().equals(iDLConfigParam.getClass())) {
            return this.getClass().getName().compareTo(iDLConfigParam.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetCwpSessionLimit(), iDLConfigParam.isSetCwpSessionLimit());
        if (n != 0) {
            return n;
        }
        if (this.isSetCwpSessionLimit() && (n = TBaseHelper.compareTo((int)this.cwpSessionLimit, (int)iDLConfigParam.cwpSessionLimit)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        IDLConfigParam.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        IDLConfigParam.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("IDLConfigParam(");
        boolean bl = true;
        stringBuilder.append("cwpSessionLimit:");
        stringBuilder.append(this.cwpSessionLimit);
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
        enumMap.put(_Fields.CWP_SESSION_LIMIT, new FieldMetaData("cwpSessionLimit", 3, new FieldValueMetaData(8)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(IDLConfigParam.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        CWP_SESSION_LIMIT(1, "cwpSessionLimit");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return CWP_SESSION_LIMIT;
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

    private static class IDLConfigParamStandardSchemeFactory
    implements SchemeFactory {
        private IDLConfigParamStandardSchemeFactory() {
        }

        public IDLConfigParamStandardScheme getScheme() {
            return new IDLConfigParamStandardScheme();
        }
    }

    private static class IDLConfigParamTupleSchemeFactory
    implements SchemeFactory {
        private IDLConfigParamTupleSchemeFactory() {
        }

        public IDLConfigParamTupleScheme getScheme() {
            return new IDLConfigParamTupleScheme();
        }
    }

    private static class IDLConfigParamTupleScheme
    extends TupleScheme<IDLConfigParam> {
        private IDLConfigParamTupleScheme() {
        }

        public void write(TProtocol tProtocol, IDLConfigParam iDLConfigParam) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (iDLConfigParam.isSetCwpSessionLimit()) {
                bitSet.set(0);
            }
            tTupleProtocol.writeBitSet(bitSet, 1);
            if (iDLConfigParam.isSetCwpSessionLimit()) {
                tTupleProtocol.writeI32(iDLConfigParam.cwpSessionLimit);
            }
        }

        public void read(TProtocol tProtocol, IDLConfigParam iDLConfigParam) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(1);
            if (bitSet.get(0)) {
                iDLConfigParam.cwpSessionLimit = tTupleProtocol.readI32();
                iDLConfigParam.setCwpSessionLimitIsSet(true);
            }
        }
    }

    private static class IDLConfigParamStandardScheme
    extends StandardScheme<IDLConfigParam> {
        private IDLConfigParamStandardScheme() {
        }

        public void read(TProtocol tProtocol, IDLConfigParam iDLConfigParam) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 8) {
                            iDLConfigParam.cwpSessionLimit = tProtocol.readI32();
                            iDLConfigParam.setCwpSessionLimitIsSet(true);
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
            iDLConfigParam.validate();
        }

        public void write(TProtocol tProtocol, IDLConfigParam iDLConfigParam) throws TException {
            iDLConfigParam.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            tProtocol.writeFieldBegin(CWP_SESSION_LIMIT_FIELD_DESC);
            tProtocol.writeI32(iDLConfigParam.cwpSessionLimit);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

