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
package com.filemaker.jwpc.iwp.thrift.dialog;

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

public class DialogSizeAndPos
implements TBase<DialogSizeAndPos, _Fields>,
Serializable,
Cloneable,
Comparable<DialogSizeAndPos> {
    private static final TStruct STRUCT_DESC = new TStruct("DialogSizeAndPos");
    private static final TField TOP_FIELD_DESC = new TField("top", 8, 1);
    private static final TField LEFT_FIELD_DESC = new TField("left", 8, 2);
    private static final TField WIDTH_FIELD_DESC = new TField("width", 8, 3);
    private static final TField HEIGHT_FIELD_DESC = new TField("height", 8, 4);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new DialogSizeAndPosStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new DialogSizeAndPosTupleSchemeFactory();
    private int top;
    private int left;
    private int width;
    private int height;
    private static final int __TOP_ISSET_ID = 0;
    private static final int __LEFT_ISSET_ID = 1;
    private static final int __WIDTH_ISSET_ID = 2;
    private static final int __HEIGHT_ISSET_ID = 3;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public DialogSizeAndPos() {
    }

    public DialogSizeAndPos(int n, int n2, int n3, int n4) {
        this();
        this.top = n;
        this.setTopIsSet(true);
        this.left = n2;
        this.setLeftIsSet(true);
        this.width = n3;
        this.setWidthIsSet(true);
        this.height = n4;
        this.setHeightIsSet(true);
    }

    public DialogSizeAndPos(DialogSizeAndPos dialogSizeAndPos) {
        this.__isset_bitfield = dialogSizeAndPos.__isset_bitfield;
        this.top = dialogSizeAndPos.top;
        this.left = dialogSizeAndPos.left;
        this.width = dialogSizeAndPos.width;
        this.height = dialogSizeAndPos.height;
    }

    public DialogSizeAndPos deepCopy() {
        return new DialogSizeAndPos(this);
    }

    public void clear() {
        this.setTopIsSet(false);
        this.top = 0;
        this.setLeftIsSet(false);
        this.left = 0;
        this.setWidthIsSet(false);
        this.width = 0;
        this.setHeightIsSet(false);
        this.height = 0;
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

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int n) {
        this.width = n;
        this.setWidthIsSet(true);
    }

    public void unsetWidth() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)2);
    }

    public boolean isSetWidth() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)2);
    }

    public void setWidthIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)2, (boolean)bl);
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int n) {
        this.height = n;
        this.setHeightIsSet(true);
    }

    public void unsetHeight() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)3);
    }

    public boolean isSetHeight() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)3);
    }

    public void setHeightIsSet(boolean bl) {
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
                    this.unsetWidth();
                    break;
                }
                this.setWidth((Integer)object);
                break;
            }
            case 3: {
                if (object == null) {
                    this.unsetHeight();
                    break;
                }
                this.setHeight((Integer)object);
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
                return this.getWidth();
            }
            case 3: {
                return this.getHeight();
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
                return this.isSetWidth();
            }
            case 3: {
                return this.isSetHeight();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof DialogSizeAndPos) {
            return this.equals((DialogSizeAndPos)object);
        }
        return false;
    }

    public boolean equals(DialogSizeAndPos dialogSizeAndPos) {
        if (dialogSizeAndPos == null) {
            return false;
        }
        if (this == dialogSizeAndPos) {
            return true;
        }
        boolean bl = true;
        boolean bl2 = true;
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (this.top != dialogSizeAndPos.top) {
                return false;
            }
        }
        boolean bl3 = true;
        boolean bl4 = true;
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (this.left != dialogSizeAndPos.left) {
                return false;
            }
        }
        boolean bl5 = true;
        boolean bl6 = true;
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (this.width != dialogSizeAndPos.width) {
                return false;
            }
        }
        boolean bl7 = true;
        boolean bl8 = true;
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (this.height != dialogSizeAndPos.height) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + this.top;
        n = n * 8191 + this.left;
        n = n * 8191 + this.width;
        n = n * 8191 + this.height;
        return n;
    }

    @Override
    public int compareTo(DialogSizeAndPos dialogSizeAndPos) {
        if (!this.getClass().equals(dialogSizeAndPos.getClass())) {
            return this.getClass().getName().compareTo(dialogSizeAndPos.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetTop(), dialogSizeAndPos.isSetTop());
        if (n != 0) {
            return n;
        }
        if (this.isSetTop() && (n = TBaseHelper.compareTo((int)this.top, (int)dialogSizeAndPos.top)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetLeft(), dialogSizeAndPos.isSetLeft());
        if (n != 0) {
            return n;
        }
        if (this.isSetLeft() && (n = TBaseHelper.compareTo((int)this.left, (int)dialogSizeAndPos.left)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetWidth(), dialogSizeAndPos.isSetWidth());
        if (n != 0) {
            return n;
        }
        if (this.isSetWidth() && (n = TBaseHelper.compareTo((int)this.width, (int)dialogSizeAndPos.width)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetHeight(), dialogSizeAndPos.isSetHeight());
        if (n != 0) {
            return n;
        }
        if (this.isSetHeight() && (n = TBaseHelper.compareTo((int)this.height, (int)dialogSizeAndPos.height)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        DialogSizeAndPos.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        DialogSizeAndPos.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("DialogSizeAndPos(");
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
        stringBuilder.append("width:");
        stringBuilder.append(this.width);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("height:");
        stringBuilder.append(this.height);
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
        enumMap.put(_Fields.WIDTH, new FieldMetaData("width", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.HEIGHT, new FieldMetaData("height", 3, new FieldValueMetaData(8)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(DialogSizeAndPos.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        TOP(1, "top"),
        LEFT(2, "left"),
        WIDTH(3, "width"),
        HEIGHT(4, "height");

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
                    return WIDTH;
                }
                case 4: {
                    return HEIGHT;
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

    private static class DialogSizeAndPosStandardSchemeFactory
    implements SchemeFactory {
        private DialogSizeAndPosStandardSchemeFactory() {
        }

        public DialogSizeAndPosStandardScheme getScheme() {
            return new DialogSizeAndPosStandardScheme();
        }
    }

    private static class DialogSizeAndPosTupleSchemeFactory
    implements SchemeFactory {
        private DialogSizeAndPosTupleSchemeFactory() {
        }

        public DialogSizeAndPosTupleScheme getScheme() {
            return new DialogSizeAndPosTupleScheme();
        }
    }

    private static class DialogSizeAndPosTupleScheme
    extends TupleScheme<DialogSizeAndPos> {
        private DialogSizeAndPosTupleScheme() {
        }

        public void write(TProtocol tProtocol, DialogSizeAndPos dialogSizeAndPos) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (dialogSizeAndPos.isSetTop()) {
                bitSet.set(0);
            }
            if (dialogSizeAndPos.isSetLeft()) {
                bitSet.set(1);
            }
            if (dialogSizeAndPos.isSetWidth()) {
                bitSet.set(2);
            }
            if (dialogSizeAndPos.isSetHeight()) {
                bitSet.set(3);
            }
            tTupleProtocol.writeBitSet(bitSet, 4);
            if (dialogSizeAndPos.isSetTop()) {
                tTupleProtocol.writeI32(dialogSizeAndPos.top);
            }
            if (dialogSizeAndPos.isSetLeft()) {
                tTupleProtocol.writeI32(dialogSizeAndPos.left);
            }
            if (dialogSizeAndPos.isSetWidth()) {
                tTupleProtocol.writeI32(dialogSizeAndPos.width);
            }
            if (dialogSizeAndPos.isSetHeight()) {
                tTupleProtocol.writeI32(dialogSizeAndPos.height);
            }
        }

        public void read(TProtocol tProtocol, DialogSizeAndPos dialogSizeAndPos) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(4);
            if (bitSet.get(0)) {
                dialogSizeAndPos.top = tTupleProtocol.readI32();
                dialogSizeAndPos.setTopIsSet(true);
            }
            if (bitSet.get(1)) {
                dialogSizeAndPos.left = tTupleProtocol.readI32();
                dialogSizeAndPos.setLeftIsSet(true);
            }
            if (bitSet.get(2)) {
                dialogSizeAndPos.width = tTupleProtocol.readI32();
                dialogSizeAndPos.setWidthIsSet(true);
            }
            if (bitSet.get(3)) {
                dialogSizeAndPos.height = tTupleProtocol.readI32();
                dialogSizeAndPos.setHeightIsSet(true);
            }
        }
    }

    private static class DialogSizeAndPosStandardScheme
    extends StandardScheme<DialogSizeAndPos> {
        private DialogSizeAndPosStandardScheme() {
        }

        public void read(TProtocol tProtocol, DialogSizeAndPos dialogSizeAndPos) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 8) {
                            dialogSizeAndPos.top = tProtocol.readI32();
                            dialogSizeAndPos.setTopIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 8) {
                            dialogSizeAndPos.left = tProtocol.readI32();
                            dialogSizeAndPos.setLeftIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 8) {
                            dialogSizeAndPos.width = tProtocol.readI32();
                            dialogSizeAndPos.setWidthIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 8) {
                            dialogSizeAndPos.height = tProtocol.readI32();
                            dialogSizeAndPos.setHeightIsSet(true);
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
            dialogSizeAndPos.validate();
        }

        public void write(TProtocol tProtocol, DialogSizeAndPos dialogSizeAndPos) throws TException {
            dialogSizeAndPos.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            tProtocol.writeFieldBegin(TOP_FIELD_DESC);
            tProtocol.writeI32(dialogSizeAndPos.top);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(LEFT_FIELD_DESC);
            tProtocol.writeI32(dialogSizeAndPos.left);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(WIDTH_FIELD_DESC);
            tProtocol.writeI32(dialogSizeAndPos.width);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(HEIGHT_FIELD_DESC);
            tProtocol.writeI32(dialogSizeAndPos.height);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

