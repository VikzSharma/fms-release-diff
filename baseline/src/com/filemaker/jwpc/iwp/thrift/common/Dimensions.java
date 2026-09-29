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

public class Dimensions
implements TBase<Dimensions, _Fields>,
Serializable,
Cloneable,
Comparable<Dimensions> {
    private static final TStruct STRUCT_DESC = new TStruct("Dimensions");
    private static final TField HEIGHT_FIELD_DESC = new TField("height", 8, 1);
    private static final TField WIDTH_FIELD_DESC = new TField("width", 8, 2);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new DimensionsStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new DimensionsTupleSchemeFactory();
    private int height;
    private int width;
    private static final int __HEIGHT_ISSET_ID = 0;
    private static final int __WIDTH_ISSET_ID = 1;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public Dimensions() {
    }

    public Dimensions(int n, int n2) {
        this();
        this.height = n;
        this.setHeightIsSet(true);
        this.width = n2;
        this.setWidthIsSet(true);
    }

    public Dimensions(Dimensions dimensions) {
        this.__isset_bitfield = dimensions.__isset_bitfield;
        this.height = dimensions.height;
        this.width = dimensions.width;
    }

    public Dimensions deepCopy() {
        return new Dimensions(this);
    }

    public void clear() {
        this.setHeightIsSet(false);
        this.height = 0;
        this.setWidthIsSet(false);
        this.width = 0;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int n) {
        this.height = n;
        this.setHeightIsSet(true);
    }

    public void unsetHeight() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetHeight() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setHeightIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int n) {
        this.width = n;
        this.setWidthIsSet(true);
    }

    public void unsetWidth() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)1);
    }

    public boolean isSetWidth() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)1);
    }

    public void setWidthIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)1, (boolean)bl);
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetHeight();
                    break;
                }
                this.setHeight((Integer)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetWidth();
                    break;
                }
                this.setWidth((Integer)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getHeight();
            }
            case 1: {
                return this.getWidth();
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
                return this.isSetHeight();
            }
            case 1: {
                return this.isSetWidth();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof Dimensions) {
            return this.equals((Dimensions)object);
        }
        return false;
    }

    public boolean equals(Dimensions dimensions) {
        if (dimensions == null) {
            return false;
        }
        if (this == dimensions) {
            return true;
        }
        boolean bl = true;
        boolean bl2 = true;
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (this.height != dimensions.height) {
                return false;
            }
        }
        boolean bl3 = true;
        boolean bl4 = true;
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (this.width != dimensions.width) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + this.height;
        n = n * 8191 + this.width;
        return n;
    }

    @Override
    public int compareTo(Dimensions dimensions) {
        if (!this.getClass().equals(dimensions.getClass())) {
            return this.getClass().getName().compareTo(dimensions.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetHeight(), dimensions.isSetHeight());
        if (n != 0) {
            return n;
        }
        if (this.isSetHeight() && (n = TBaseHelper.compareTo((int)this.height, (int)dimensions.height)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetWidth(), dimensions.isSetWidth());
        if (n != 0) {
            return n;
        }
        if (this.isSetWidth() && (n = TBaseHelper.compareTo((int)this.width, (int)dimensions.width)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        Dimensions.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        Dimensions.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Dimensions(");
        boolean bl = true;
        stringBuilder.append("height:");
        stringBuilder.append(this.height);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("width:");
        stringBuilder.append(this.width);
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
        enumMap.put(_Fields.HEIGHT, new FieldMetaData("height", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.WIDTH, new FieldMetaData("width", 3, new FieldValueMetaData(8)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(Dimensions.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        HEIGHT(1, "height"),
        WIDTH(2, "width");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return HEIGHT;
                }
                case 2: {
                    return WIDTH;
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

    private static class DimensionsStandardSchemeFactory
    implements SchemeFactory {
        private DimensionsStandardSchemeFactory() {
        }

        public DimensionsStandardScheme getScheme() {
            return new DimensionsStandardScheme();
        }
    }

    private static class DimensionsTupleSchemeFactory
    implements SchemeFactory {
        private DimensionsTupleSchemeFactory() {
        }

        public DimensionsTupleScheme getScheme() {
            return new DimensionsTupleScheme();
        }
    }

    private static class DimensionsTupleScheme
    extends TupleScheme<Dimensions> {
        private DimensionsTupleScheme() {
        }

        public void write(TProtocol tProtocol, Dimensions dimensions) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (dimensions.isSetHeight()) {
                bitSet.set(0);
            }
            if (dimensions.isSetWidth()) {
                bitSet.set(1);
            }
            tTupleProtocol.writeBitSet(bitSet, 2);
            if (dimensions.isSetHeight()) {
                tTupleProtocol.writeI32(dimensions.height);
            }
            if (dimensions.isSetWidth()) {
                tTupleProtocol.writeI32(dimensions.width);
            }
        }

        public void read(TProtocol tProtocol, Dimensions dimensions) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(2);
            if (bitSet.get(0)) {
                dimensions.height = tTupleProtocol.readI32();
                dimensions.setHeightIsSet(true);
            }
            if (bitSet.get(1)) {
                dimensions.width = tTupleProtocol.readI32();
                dimensions.setWidthIsSet(true);
            }
        }
    }

    private static class DimensionsStandardScheme
    extends StandardScheme<Dimensions> {
        private DimensionsStandardScheme() {
        }

        public void read(TProtocol tProtocol, Dimensions dimensions) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 8) {
                            dimensions.height = tProtocol.readI32();
                            dimensions.setHeightIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 8) {
                            dimensions.width = tProtocol.readI32();
                            dimensions.setWidthIsSet(true);
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
            dimensions.validate();
        }

        public void write(TProtocol tProtocol, Dimensions dimensions) throws TException {
            dimensions.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            tProtocol.writeFieldBegin(HEIGHT_FIELD_DESC);
            tProtocol.writeI32(dimensions.height);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(WIDTH_FIELD_DESC);
            tProtocol.writeI32(dimensions.width);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

