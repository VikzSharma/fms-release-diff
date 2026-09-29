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

public class BinaryDataOptions
implements TBase<BinaryDataOptions, _Fields>,
Serializable,
Cloneable,
Comparable<BinaryDataOptions> {
    private static final TStruct STRUCT_DESC = new TStruct("BinaryDataOptions");
    private static final TField USE_IMAGE_DIMENSIONS_FIELD_DESC = new TField("useImageDimensions", 2, 1);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new BinaryDataOptionsStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new BinaryDataOptionsTupleSchemeFactory();
    private boolean useImageDimensions;
    private static final int __USEIMAGEDIMENSIONS_ISSET_ID = 0;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public BinaryDataOptions() {
    }

    public BinaryDataOptions(boolean bl) {
        this();
        this.useImageDimensions = bl;
        this.setUseImageDimensionsIsSet(true);
    }

    public BinaryDataOptions(BinaryDataOptions binaryDataOptions) {
        this.__isset_bitfield = binaryDataOptions.__isset_bitfield;
        this.useImageDimensions = binaryDataOptions.useImageDimensions;
    }

    public BinaryDataOptions deepCopy() {
        return new BinaryDataOptions(this);
    }

    public void clear() {
        this.setUseImageDimensionsIsSet(false);
        this.useImageDimensions = false;
    }

    public boolean isUseImageDimensions() {
        return this.useImageDimensions;
    }

    public void setUseImageDimensions(boolean bl) {
        this.useImageDimensions = bl;
        this.setUseImageDimensionsIsSet(true);
    }

    public void unsetUseImageDimensions() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetUseImageDimensions() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setUseImageDimensionsIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetUseImageDimensions();
                    break;
                }
                this.setUseImageDimensions((Boolean)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.isUseImageDimensions();
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
                return this.isSetUseImageDimensions();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof BinaryDataOptions) {
            return this.equals((BinaryDataOptions)object);
        }
        return false;
    }

    public boolean equals(BinaryDataOptions binaryDataOptions) {
        if (binaryDataOptions == null) {
            return false;
        }
        if (this == binaryDataOptions) {
            return true;
        }
        boolean bl = true;
        boolean bl2 = true;
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (this.useImageDimensions != binaryDataOptions.useImageDimensions) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.useImageDimensions ? 131071 : 524287);
        return n;
    }

    @Override
    public int compareTo(BinaryDataOptions binaryDataOptions) {
        if (!this.getClass().equals(binaryDataOptions.getClass())) {
            return this.getClass().getName().compareTo(binaryDataOptions.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetUseImageDimensions(), binaryDataOptions.isSetUseImageDimensions());
        if (n != 0) {
            return n;
        }
        if (this.isSetUseImageDimensions() && (n = TBaseHelper.compareTo((boolean)this.useImageDimensions, (boolean)binaryDataOptions.useImageDimensions)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        BinaryDataOptions.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        BinaryDataOptions.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("BinaryDataOptions(");
        boolean bl = true;
        stringBuilder.append("useImageDimensions:");
        stringBuilder.append(this.useImageDimensions);
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
        enumMap.put(_Fields.USE_IMAGE_DIMENSIONS, new FieldMetaData("useImageDimensions", 3, new FieldValueMetaData(2)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(BinaryDataOptions.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        USE_IMAGE_DIMENSIONS(1, "useImageDimensions");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return USE_IMAGE_DIMENSIONS;
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

    private static class BinaryDataOptionsStandardSchemeFactory
    implements SchemeFactory {
        private BinaryDataOptionsStandardSchemeFactory() {
        }

        public BinaryDataOptionsStandardScheme getScheme() {
            return new BinaryDataOptionsStandardScheme();
        }
    }

    private static class BinaryDataOptionsTupleSchemeFactory
    implements SchemeFactory {
        private BinaryDataOptionsTupleSchemeFactory() {
        }

        public BinaryDataOptionsTupleScheme getScheme() {
            return new BinaryDataOptionsTupleScheme();
        }
    }

    private static class BinaryDataOptionsTupleScheme
    extends TupleScheme<BinaryDataOptions> {
        private BinaryDataOptionsTupleScheme() {
        }

        public void write(TProtocol tProtocol, BinaryDataOptions binaryDataOptions) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (binaryDataOptions.isSetUseImageDimensions()) {
                bitSet.set(0);
            }
            tTupleProtocol.writeBitSet(bitSet, 1);
            if (binaryDataOptions.isSetUseImageDimensions()) {
                tTupleProtocol.writeBool(binaryDataOptions.useImageDimensions);
            }
        }

        public void read(TProtocol tProtocol, BinaryDataOptions binaryDataOptions) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(1);
            if (bitSet.get(0)) {
                binaryDataOptions.useImageDimensions = tTupleProtocol.readBool();
                binaryDataOptions.setUseImageDimensionsIsSet(true);
            }
        }
    }

    private static class BinaryDataOptionsStandardScheme
    extends StandardScheme<BinaryDataOptions> {
        private BinaryDataOptionsStandardScheme() {
        }

        public void read(TProtocol tProtocol, BinaryDataOptions binaryDataOptions) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 2) {
                            binaryDataOptions.useImageDimensions = tProtocol.readBool();
                            binaryDataOptions.setUseImageDimensionsIsSet(true);
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
            binaryDataOptions.validate();
        }

        public void write(TProtocol tProtocol, BinaryDataOptions binaryDataOptions) throws TException {
            binaryDataOptions.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            tProtocol.writeFieldBegin(USE_IMAGE_DIMENSIONS_FIELD_DESC);
            tProtocol.writeBool(binaryDataOptions.useImageDimensions);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

