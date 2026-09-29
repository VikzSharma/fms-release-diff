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
 *  org.apache.thrift.meta_data.StructMetaData
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

import com.filemaker.jwpc.iwp.thrift.common.Dimensions;
import com.filemaker.jwpc.iwp.thrift.common.Position;
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
import org.apache.thrift.meta_data.StructMetaData;
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

public class CardWindowSettings
implements TBase<CardWindowSettings, _Fields>,
Serializable,
Cloneable,
Comparable<CardWindowSettings> {
    private static final TStruct STRUCT_DESC = new TStruct("CardWindowSettings");
    private static final TField POSITION_FIELD_DESC = new TField("position", 12, 1);
    private static final TField DIMENSIONS_FIELD_DESC = new TField("dimensions", 12, 2);
    private static final TField HAS_CLOSE_BUTTON_FIELD_DESC = new TField("hasCloseButton", 2, 3);
    private static final TField HAS_PARENT_DIM_FIELD_DESC = new TField("hasParentDim", 2, 4);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new CardWindowSettingsStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new CardWindowSettingsTupleSchemeFactory();
    @Nullable
    private Position position;
    @Nullable
    private Dimensions dimensions;
    private boolean hasCloseButton;
    private boolean hasParentDim;
    private static final int __HASCLOSEBUTTON_ISSET_ID = 0;
    private static final int __HASPARENTDIM_ISSET_ID = 1;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public CardWindowSettings() {
    }

    public CardWindowSettings(Position position, Dimensions dimensions, boolean bl, boolean bl2) {
        this();
        this.position = position;
        this.dimensions = dimensions;
        this.hasCloseButton = bl;
        this.setHasCloseButtonIsSet(true);
        this.hasParentDim = bl2;
        this.setHasParentDimIsSet(true);
    }

    public CardWindowSettings(CardWindowSettings cardWindowSettings) {
        this.__isset_bitfield = cardWindowSettings.__isset_bitfield;
        if (cardWindowSettings.isSetPosition()) {
            this.position = new Position(cardWindowSettings.position);
        }
        if (cardWindowSettings.isSetDimensions()) {
            this.dimensions = new Dimensions(cardWindowSettings.dimensions);
        }
        this.hasCloseButton = cardWindowSettings.hasCloseButton;
        this.hasParentDim = cardWindowSettings.hasParentDim;
    }

    public CardWindowSettings deepCopy() {
        return new CardWindowSettings(this);
    }

    public void clear() {
        this.position = null;
        this.dimensions = null;
        this.setHasCloseButtonIsSet(false);
        this.hasCloseButton = false;
        this.setHasParentDimIsSet(false);
        this.hasParentDim = false;
    }

    @Nullable
    public Position getPosition() {
        return this.position;
    }

    public void setPosition(@Nullable Position position) {
        this.position = position;
    }

    public void unsetPosition() {
        this.position = null;
    }

    public boolean isSetPosition() {
        return this.position != null;
    }

    public void setPositionIsSet(boolean bl) {
        if (!bl) {
            this.position = null;
        }
    }

    @Nullable
    public Dimensions getDimensions() {
        return this.dimensions;
    }

    public void setDimensions(@Nullable Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    public void unsetDimensions() {
        this.dimensions = null;
    }

    public boolean isSetDimensions() {
        return this.dimensions != null;
    }

    public void setDimensionsIsSet(boolean bl) {
        if (!bl) {
            this.dimensions = null;
        }
    }

    public boolean isHasCloseButton() {
        return this.hasCloseButton;
    }

    public void setHasCloseButton(boolean bl) {
        this.hasCloseButton = bl;
        this.setHasCloseButtonIsSet(true);
    }

    public void unsetHasCloseButton() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetHasCloseButton() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setHasCloseButtonIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public boolean isHasParentDim() {
        return this.hasParentDim;
    }

    public void setHasParentDim(boolean bl) {
        this.hasParentDim = bl;
        this.setHasParentDimIsSet(true);
    }

    public void unsetHasParentDim() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)1);
    }

    public boolean isSetHasParentDim() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)1);
    }

    public void setHasParentDimIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)1, (boolean)bl);
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetPosition();
                    break;
                }
                this.setPosition((Position)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetDimensions();
                    break;
                }
                this.setDimensions((Dimensions)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetHasCloseButton();
                    break;
                }
                this.setHasCloseButton((Boolean)object);
                break;
            }
            case 3: {
                if (object == null) {
                    this.unsetHasParentDim();
                    break;
                }
                this.setHasParentDim((Boolean)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getPosition();
            }
            case 1: {
                return this.getDimensions();
            }
            case 2: {
                return this.isHasCloseButton();
            }
            case 3: {
                return this.isHasParentDim();
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
                return this.isSetPosition();
            }
            case 1: {
                return this.isSetDimensions();
            }
            case 2: {
                return this.isSetHasCloseButton();
            }
            case 3: {
                return this.isSetHasParentDim();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof CardWindowSettings) {
            return this.equals((CardWindowSettings)object);
        }
        return false;
    }

    public boolean equals(CardWindowSettings cardWindowSettings) {
        if (cardWindowSettings == null) {
            return false;
        }
        if (this == cardWindowSettings) {
            return true;
        }
        boolean bl = this.isSetPosition();
        boolean bl2 = cardWindowSettings.isSetPosition();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.position.equals(cardWindowSettings.position)) {
                return false;
            }
        }
        boolean bl3 = this.isSetDimensions();
        boolean bl4 = cardWindowSettings.isSetDimensions();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.dimensions.equals(cardWindowSettings.dimensions)) {
                return false;
            }
        }
        boolean bl5 = true;
        boolean bl6 = true;
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (this.hasCloseButton != cardWindowSettings.hasCloseButton) {
                return false;
            }
        }
        boolean bl7 = true;
        boolean bl8 = true;
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (this.hasParentDim != cardWindowSettings.hasParentDim) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetPosition() ? 131071 : 524287);
        if (this.isSetPosition()) {
            n = n * 8191 + this.position.hashCode();
        }
        n = n * 8191 + (this.isSetDimensions() ? 131071 : 524287);
        if (this.isSetDimensions()) {
            n = n * 8191 + this.dimensions.hashCode();
        }
        n = n * 8191 + (this.hasCloseButton ? 131071 : 524287);
        n = n * 8191 + (this.hasParentDim ? 131071 : 524287);
        return n;
    }

    @Override
    public int compareTo(CardWindowSettings cardWindowSettings) {
        if (!this.getClass().equals(cardWindowSettings.getClass())) {
            return this.getClass().getName().compareTo(cardWindowSettings.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetPosition(), cardWindowSettings.isSetPosition());
        if (n != 0) {
            return n;
        }
        if (this.isSetPosition() && (n = TBaseHelper.compareTo((Comparable)this.position, (Comparable)cardWindowSettings.position)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetDimensions(), cardWindowSettings.isSetDimensions());
        if (n != 0) {
            return n;
        }
        if (this.isSetDimensions() && (n = TBaseHelper.compareTo((Comparable)this.dimensions, (Comparable)cardWindowSettings.dimensions)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetHasCloseButton(), cardWindowSettings.isSetHasCloseButton());
        if (n != 0) {
            return n;
        }
        if (this.isSetHasCloseButton() && (n = TBaseHelper.compareTo((boolean)this.hasCloseButton, (boolean)cardWindowSettings.hasCloseButton)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetHasParentDim(), cardWindowSettings.isSetHasParentDim());
        if (n != 0) {
            return n;
        }
        if (this.isSetHasParentDim() && (n = TBaseHelper.compareTo((boolean)this.hasParentDim, (boolean)cardWindowSettings.hasParentDim)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        CardWindowSettings.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        CardWindowSettings.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("CardWindowSettings(");
        boolean bl = true;
        stringBuilder.append("position:");
        if (this.position == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.position);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("dimensions:");
        if (this.dimensions == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.dimensions);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("hasCloseButton:");
        stringBuilder.append(this.hasCloseButton);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("hasParentDim:");
        stringBuilder.append(this.hasParentDim);
        bl = false;
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void validate() throws TException {
        if (this.position != null) {
            this.position.validate();
        }
        if (this.dimensions != null) {
            this.dimensions.validate();
        }
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
        enumMap.put(_Fields.POSITION, new FieldMetaData("position", 3, (FieldValueMetaData)new StructMetaData(12, Position.class)));
        enumMap.put(_Fields.DIMENSIONS, new FieldMetaData("dimensions", 3, (FieldValueMetaData)new StructMetaData(12, Dimensions.class)));
        enumMap.put(_Fields.HAS_CLOSE_BUTTON, new FieldMetaData("hasCloseButton", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.HAS_PARENT_DIM, new FieldMetaData("hasParentDim", 3, new FieldValueMetaData(2)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(CardWindowSettings.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        POSITION(1, "position"),
        DIMENSIONS(2, "dimensions"),
        HAS_CLOSE_BUTTON(3, "hasCloseButton"),
        HAS_PARENT_DIM(4, "hasParentDim");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return POSITION;
                }
                case 2: {
                    return DIMENSIONS;
                }
                case 3: {
                    return HAS_CLOSE_BUTTON;
                }
                case 4: {
                    return HAS_PARENT_DIM;
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

    private static class CardWindowSettingsStandardSchemeFactory
    implements SchemeFactory {
        private CardWindowSettingsStandardSchemeFactory() {
        }

        public CardWindowSettingsStandardScheme getScheme() {
            return new CardWindowSettingsStandardScheme();
        }
    }

    private static class CardWindowSettingsTupleSchemeFactory
    implements SchemeFactory {
        private CardWindowSettingsTupleSchemeFactory() {
        }

        public CardWindowSettingsTupleScheme getScheme() {
            return new CardWindowSettingsTupleScheme();
        }
    }

    private static class CardWindowSettingsTupleScheme
    extends TupleScheme<CardWindowSettings> {
        private CardWindowSettingsTupleScheme() {
        }

        public void write(TProtocol tProtocol, CardWindowSettings cardWindowSettings) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (cardWindowSettings.isSetPosition()) {
                bitSet.set(0);
            }
            if (cardWindowSettings.isSetDimensions()) {
                bitSet.set(1);
            }
            if (cardWindowSettings.isSetHasCloseButton()) {
                bitSet.set(2);
            }
            if (cardWindowSettings.isSetHasParentDim()) {
                bitSet.set(3);
            }
            tTupleProtocol.writeBitSet(bitSet, 4);
            if (cardWindowSettings.isSetPosition()) {
                cardWindowSettings.position.write((TProtocol)tTupleProtocol);
            }
            if (cardWindowSettings.isSetDimensions()) {
                cardWindowSettings.dimensions.write((TProtocol)tTupleProtocol);
            }
            if (cardWindowSettings.isSetHasCloseButton()) {
                tTupleProtocol.writeBool(cardWindowSettings.hasCloseButton);
            }
            if (cardWindowSettings.isSetHasParentDim()) {
                tTupleProtocol.writeBool(cardWindowSettings.hasParentDim);
            }
        }

        public void read(TProtocol tProtocol, CardWindowSettings cardWindowSettings) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(4);
            if (bitSet.get(0)) {
                cardWindowSettings.position = new Position();
                cardWindowSettings.position.read((TProtocol)tTupleProtocol);
                cardWindowSettings.setPositionIsSet(true);
            }
            if (bitSet.get(1)) {
                cardWindowSettings.dimensions = new Dimensions();
                cardWindowSettings.dimensions.read((TProtocol)tTupleProtocol);
                cardWindowSettings.setDimensionsIsSet(true);
            }
            if (bitSet.get(2)) {
                cardWindowSettings.hasCloseButton = tTupleProtocol.readBool();
                cardWindowSettings.setHasCloseButtonIsSet(true);
            }
            if (bitSet.get(3)) {
                cardWindowSettings.hasParentDim = tTupleProtocol.readBool();
                cardWindowSettings.setHasParentDimIsSet(true);
            }
        }
    }

    private static class CardWindowSettingsStandardScheme
    extends StandardScheme<CardWindowSettings> {
        private CardWindowSettingsStandardScheme() {
        }

        public void read(TProtocol tProtocol, CardWindowSettings cardWindowSettings) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 12) {
                            cardWindowSettings.position = new Position();
                            cardWindowSettings.position.read(tProtocol);
                            cardWindowSettings.setPositionIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 12) {
                            cardWindowSettings.dimensions = new Dimensions();
                            cardWindowSettings.dimensions.read(tProtocol);
                            cardWindowSettings.setDimensionsIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 2) {
                            cardWindowSettings.hasCloseButton = tProtocol.readBool();
                            cardWindowSettings.setHasCloseButtonIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 2) {
                            cardWindowSettings.hasParentDim = tProtocol.readBool();
                            cardWindowSettings.setHasParentDimIsSet(true);
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
            cardWindowSettings.validate();
        }

        public void write(TProtocol tProtocol, CardWindowSettings cardWindowSettings) throws TException {
            cardWindowSettings.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (cardWindowSettings.position != null) {
                tProtocol.writeFieldBegin(POSITION_FIELD_DESC);
                cardWindowSettings.position.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            if (cardWindowSettings.dimensions != null) {
                tProtocol.writeFieldBegin(DIMENSIONS_FIELD_DESC);
                cardWindowSettings.dimensions.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(HAS_CLOSE_BUTTON_FIELD_DESC);
            tProtocol.writeBool(cardWindowSettings.hasCloseButton);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(HAS_PARENT_DIM_FIELD_DESC);
            tProtocol.writeBool(cardWindowSettings.hasParentDim);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

