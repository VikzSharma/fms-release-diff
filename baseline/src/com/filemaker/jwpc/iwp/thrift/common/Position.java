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

public class Position
implements TBase<Position, _Fields>,
Serializable,
Cloneable,
Comparable<Position> {
    private static final TStruct STRUCT_DESC = new TStruct("Position");
    private static final TField TOP_FIELD_DESC = new TField("top", 8, 1);
    private static final TField LEFT_FIELD_DESC = new TField("left", 8, 2);
    private static final TField RIGHT_FIELD_DESC = new TField("right", 8, 3);
    private static final TField BOTTOM_FIELD_DESC = new TField("bottom", 8, 4);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new PositionStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new PositionTupleSchemeFactory();
    private int top;
    private int left;
    private int right;
    private int bottom;
    private static final int __TOP_ISSET_ID = 0;
    private static final int __LEFT_ISSET_ID = 1;
    private static final int __RIGHT_ISSET_ID = 2;
    private static final int __BOTTOM_ISSET_ID = 3;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public Position() {
        this.top = -1;
        this.left = -1;
        this.right = -1;
        this.bottom = -1;
    }

    public Position(int n, int n2, int n3, int n4) {
        this();
        this.top = n;
        this.setTopIsSet(true);
        this.left = n2;
        this.setLeftIsSet(true);
        this.right = n3;
        this.setRightIsSet(true);
        this.bottom = n4;
        this.setBottomIsSet(true);
    }

    public Position(Position position) {
        this.__isset_bitfield = position.__isset_bitfield;
        this.top = position.top;
        this.left = position.left;
        this.right = position.right;
        this.bottom = position.bottom;
    }

    public Position deepCopy() {
        return new Position(this);
    }

    public void clear() {
        this.top = -1;
        this.left = -1;
        this.right = -1;
        this.bottom = -1;
    }

    public int getTop() {
        return this.top;
    }

    public void setTop(int n) {
        this.top = n;
        this.setTopIsSet(true);
    }

    public void unsetTop() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetTop() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setTopIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public int getLeft() {
        return this.left;
    }

    public void setLeft(int n) {
        this.left = n;
        this.setLeftIsSet(true);
    }

    public void unsetLeft() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)1);
    }

    public boolean isSetLeft() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)1);
    }

    public void setLeftIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)1, (boolean)bl);
    }

    public int getRight() {
        return this.right;
    }

    public void setRight(int n) {
        this.right = n;
        this.setRightIsSet(true);
    }

    public void unsetRight() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)2);
    }

    public boolean isSetRight() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)2);
    }

    public void setRightIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)2, (boolean)bl);
    }

    public int getBottom() {
        return this.bottom;
    }

    public void setBottom(int n) {
        this.bottom = n;
        this.setBottomIsSet(true);
    }

    public void unsetBottom() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)3);
    }

    public boolean isSetBottom() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)3);
    }

    public void setBottomIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)3, (boolean)bl);
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetTop();
                    break;
                }
                this.setTop((Integer)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetLeft();
                    break;
                }
                this.setLeft((Integer)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetRight();
                    break;
                }
                this.setRight((Integer)object);
                break;
            }
            case 3: {
                if (object == null) {
                    this.unsetBottom();
                    break;
                }
                this.setBottom((Integer)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getTop();
            }
            case 1: {
                return this.getLeft();
            }
            case 2: {
                return this.getRight();
            }
            case 3: {
                return this.getBottom();
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
                return this.isSetTop();
            }
            case 1: {
                return this.isSetLeft();
            }
            case 2: {
                return this.isSetRight();
            }
            case 3: {
                return this.isSetBottom();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof Position) {
            return this.equals((Position)object);
        }
        return false;
    }

    public boolean equals(Position position) {
        if (position == null) {
            return false;
        }
        if (this == position) {
            return true;
        }
        boolean bl = true;
        boolean bl2 = true;
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (this.top != position.top) {
                return false;
            }
        }
        boolean bl3 = true;
        boolean bl4 = true;
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (this.left != position.left) {
                return false;
            }
        }
        boolean bl5 = true;
        boolean bl6 = true;
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (this.right != position.right) {
                return false;
            }
        }
        boolean bl7 = true;
        boolean bl8 = true;
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (this.bottom != position.bottom) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + this.top;
        n = n * 8191 + this.left;
        n = n * 8191 + this.right;
        n = n * 8191 + this.bottom;
        return n;
    }

    @Override
    public int compareTo(Position position) {
        if (!this.getClass().equals(position.getClass())) {
            return this.getClass().getName().compareTo(position.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetTop(), position.isSetTop());
        if (n != 0) {
            return n;
        }
        if (this.isSetTop() && (n = TBaseHelper.compareTo((int)this.top, (int)position.top)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetLeft(), position.isSetLeft());
        if (n != 0) {
            return n;
        }
        if (this.isSetLeft() && (n = TBaseHelper.compareTo((int)this.left, (int)position.left)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetRight(), position.isSetRight());
        if (n != 0) {
            return n;
        }
        if (this.isSetRight() && (n = TBaseHelper.compareTo((int)this.right, (int)position.right)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetBottom(), position.isSetBottom());
        if (n != 0) {
            return n;
        }
        if (this.isSetBottom() && (n = TBaseHelper.compareTo((int)this.bottom, (int)position.bottom)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        Position.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        Position.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Position(");
        boolean bl = true;
        stringBuilder.append("top:");
        stringBuilder.append(this.top);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("left:");
        stringBuilder.append(this.left);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("right:");
        stringBuilder.append(this.right);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("bottom:");
        stringBuilder.append(this.bottom);
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
        enumMap.put(_Fields.TOP, new FieldMetaData("top", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.LEFT, new FieldMetaData("left", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.RIGHT, new FieldMetaData("right", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.BOTTOM, new FieldMetaData("bottom", 3, new FieldValueMetaData(8)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(Position.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        TOP(1, "top"),
        LEFT(2, "left"),
        RIGHT(3, "right"),
        BOTTOM(4, "bottom");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return TOP;
                }
                case 2: {
                    return LEFT;
                }
                case 3: {
                    return RIGHT;
                }
                case 4: {
                    return BOTTOM;
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

    private static class PositionStandardSchemeFactory
    implements SchemeFactory {
        private PositionStandardSchemeFactory() {
        }

        public PositionStandardScheme getScheme() {
            return new PositionStandardScheme();
        }
    }

    private static class PositionTupleSchemeFactory
    implements SchemeFactory {
        private PositionTupleSchemeFactory() {
        }

        public PositionTupleScheme getScheme() {
            return new PositionTupleScheme();
        }
    }

    private static class PositionTupleScheme
    extends TupleScheme<Position> {
        private PositionTupleScheme() {
        }

        public void write(TProtocol tProtocol, Position position) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (position.isSetTop()) {
                bitSet.set(0);
            }
            if (position.isSetLeft()) {
                bitSet.set(1);
            }
            if (position.isSetRight()) {
                bitSet.set(2);
            }
            if (position.isSetBottom()) {
                bitSet.set(3);
            }
            tTupleProtocol.writeBitSet(bitSet, 4);
            if (position.isSetTop()) {
                tTupleProtocol.writeI32(position.top);
            }
            if (position.isSetLeft()) {
                tTupleProtocol.writeI32(position.left);
            }
            if (position.isSetRight()) {
                tTupleProtocol.writeI32(position.right);
            }
            if (position.isSetBottom()) {
                tTupleProtocol.writeI32(position.bottom);
            }
        }

        public void read(TProtocol tProtocol, Position position) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(4);
            if (bitSet.get(0)) {
                position.top = tTupleProtocol.readI32();
                position.setTopIsSet(true);
            }
            if (bitSet.get(1)) {
                position.left = tTupleProtocol.readI32();
                position.setLeftIsSet(true);
            }
            if (bitSet.get(2)) {
                position.right = tTupleProtocol.readI32();
                position.setRightIsSet(true);
            }
            if (bitSet.get(3)) {
                position.bottom = tTupleProtocol.readI32();
                position.setBottomIsSet(true);
            }
        }
    }

    private static class PositionStandardScheme
    extends StandardScheme<Position> {
        private PositionStandardScheme() {
        }

        public void read(TProtocol tProtocol, Position position) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 8) {
                            position.top = tProtocol.readI32();
                            position.setTopIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 8) {
                            position.left = tProtocol.readI32();
                            position.setLeftIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 8) {
                            position.right = tProtocol.readI32();
                            position.setRightIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 8) {
                            position.bottom = tProtocol.readI32();
                            position.setBottomIsSet(true);
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
            position.validate();
        }

        public void write(TProtocol tProtocol, Position position) throws TException {
            position.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            tProtocol.writeFieldBegin(TOP_FIELD_DESC);
            tProtocol.writeI32(position.top);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(LEFT_FIELD_DESC);
            tProtocol.writeI32(position.left);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(RIGHT_FIELD_DESC);
            tProtocol.writeI32(position.right);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(BOTTOM_FIELD_DESC);
            tProtocol.writeI32(position.bottom);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

