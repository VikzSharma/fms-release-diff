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

public class LayoutObjectAttributes
implements TBase<LayoutObjectAttributes, _Fields>,
Serializable,
Cloneable,
Comparable<LayoutObjectAttributes> {
    private static final TStruct STRUCT_DESC = new TStruct("LayoutObjectAttributes");
    private static final TField CSS_FIELD_DESC = new TField("css", 11, 1);
    private static final TField CSS_NAME_FIELD_DESC = new TField("cssName", 11, 2);
    private static final TField POSITION_FIELD_DESC = new TField("position", 12, 3);
    private static final TField HEIGHT_FIELD_DESC = new TField("height", 8, 4);
    private static final TField WIDTH_FIELD_DESC = new TField("width", 8, 5);
    private static final TField TAB_ORDER_FIELD_DESC = new TField("tabOrder", 8, 6);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new LayoutObjectAttributesStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new LayoutObjectAttributesTupleSchemeFactory();
    @Nullable
    private String css;
    @Nullable
    private String cssName;
    @Nullable
    private Position position;
    private int height;
    private int width;
    private int tabOrder;
    private static final int __HEIGHT_ISSET_ID = 0;
    private static final int __WIDTH_ISSET_ID = 1;
    private static final int __TABORDER_ISSET_ID = 2;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public LayoutObjectAttributes() {
    }

    public LayoutObjectAttributes(String string, String string2, Position position, int n, int n2, int n3) {
        this();
        this.css = string;
        this.cssName = string2;
        this.position = position;
        this.height = n;
        this.setHeightIsSet(true);
        this.width = n2;
        this.setWidthIsSet(true);
        this.tabOrder = n3;
        this.setTabOrderIsSet(true);
    }

    public LayoutObjectAttributes(LayoutObjectAttributes layoutObjectAttributes) {
        this.__isset_bitfield = layoutObjectAttributes.__isset_bitfield;
        if (layoutObjectAttributes.isSetCss()) {
            this.css = layoutObjectAttributes.css;
        }
        if (layoutObjectAttributes.isSetCssName()) {
            this.cssName = layoutObjectAttributes.cssName;
        }
        if (layoutObjectAttributes.isSetPosition()) {
            this.position = new Position(layoutObjectAttributes.position);
        }
        this.height = layoutObjectAttributes.height;
        this.width = layoutObjectAttributes.width;
        this.tabOrder = layoutObjectAttributes.tabOrder;
    }

    public LayoutObjectAttributes deepCopy() {
        return new LayoutObjectAttributes(this);
    }

    public void clear() {
        this.css = null;
        this.cssName = null;
        this.position = null;
        this.setHeightIsSet(false);
        this.height = 0;
        this.setWidthIsSet(false);
        this.width = 0;
        this.setTabOrderIsSet(false);
        this.tabOrder = 0;
    }

    @Nullable
    public String getCss() {
        return this.css;
    }

    public void setCss(@Nullable String string) {
        this.css = string;
    }

    public void unsetCss() {
        this.css = null;
    }

    public boolean isSetCss() {
        return this.css != null;
    }

    public void setCssIsSet(boolean bl) {
        if (!bl) {
            this.css = null;
        }
    }

    @Nullable
    public String getCssName() {
        return this.cssName;
    }

    public void setCssName(@Nullable String string) {
        this.cssName = string;
    }

    public void unsetCssName() {
        this.cssName = null;
    }

    public boolean isSetCssName() {
        return this.cssName != null;
    }

    public void setCssNameIsSet(boolean bl) {
        if (!bl) {
            this.cssName = null;
        }
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

    public int getTabOrder() {
        return this.tabOrder;
    }

    public void setTabOrder(int n) {
        this.tabOrder = n;
        this.setTabOrderIsSet(true);
    }

    public void unsetTabOrder() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)2);
    }

    public boolean isSetTabOrder() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)2);
    }

    public void setTabOrderIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)2, (boolean)bl);
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetCss();
                    break;
                }
                this.setCss((String)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetCssName();
                    break;
                }
                this.setCssName((String)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetPosition();
                    break;
                }
                this.setPosition((Position)object);
                break;
            }
            case 3: {
                if (object == null) {
                    this.unsetHeight();
                    break;
                }
                this.setHeight((Integer)object);
                break;
            }
            case 4: {
                if (object == null) {
                    this.unsetWidth();
                    break;
                }
                this.setWidth((Integer)object);
                break;
            }
            case 5: {
                if (object == null) {
                    this.unsetTabOrder();
                    break;
                }
                this.setTabOrder((Integer)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getCss();
            }
            case 1: {
                return this.getCssName();
            }
            case 2: {
                return this.getPosition();
            }
            case 3: {
                return this.getHeight();
            }
            case 4: {
                return this.getWidth();
            }
            case 5: {
                return this.getTabOrder();
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
                return this.isSetCss();
            }
            case 1: {
                return this.isSetCssName();
            }
            case 2: {
                return this.isSetPosition();
            }
            case 3: {
                return this.isSetHeight();
            }
            case 4: {
                return this.isSetWidth();
            }
            case 5: {
                return this.isSetTabOrder();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof LayoutObjectAttributes) {
            return this.equals((LayoutObjectAttributes)object);
        }
        return false;
    }

    public boolean equals(LayoutObjectAttributes layoutObjectAttributes) {
        if (layoutObjectAttributes == null) {
            return false;
        }
        if (this == layoutObjectAttributes) {
            return true;
        }
        boolean bl = this.isSetCss();
        boolean bl2 = layoutObjectAttributes.isSetCss();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.css.equals(layoutObjectAttributes.css)) {
                return false;
            }
        }
        boolean bl3 = this.isSetCssName();
        boolean bl4 = layoutObjectAttributes.isSetCssName();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.cssName.equals(layoutObjectAttributes.cssName)) {
                return false;
            }
        }
        boolean bl5 = this.isSetPosition();
        boolean bl6 = layoutObjectAttributes.isSetPosition();
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (!this.position.equals(layoutObjectAttributes.position)) {
                return false;
            }
        }
        boolean bl7 = true;
        boolean bl8 = true;
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (this.height != layoutObjectAttributes.height) {
                return false;
            }
        }
        boolean bl9 = true;
        boolean bl10 = true;
        if (bl9 || bl10) {
            if (!bl9 || !bl10) {
                return false;
            }
            if (this.width != layoutObjectAttributes.width) {
                return false;
            }
        }
        boolean bl11 = true;
        boolean bl12 = true;
        if (bl11 || bl12) {
            if (!bl11 || !bl12) {
                return false;
            }
            if (this.tabOrder != layoutObjectAttributes.tabOrder) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetCss() ? 131071 : 524287);
        if (this.isSetCss()) {
            n = n * 8191 + this.css.hashCode();
        }
        n = n * 8191 + (this.isSetCssName() ? 131071 : 524287);
        if (this.isSetCssName()) {
            n = n * 8191 + this.cssName.hashCode();
        }
        n = n * 8191 + (this.isSetPosition() ? 131071 : 524287);
        if (this.isSetPosition()) {
            n = n * 8191 + this.position.hashCode();
        }
        n = n * 8191 + this.height;
        n = n * 8191 + this.width;
        n = n * 8191 + this.tabOrder;
        return n;
    }

    @Override
    public int compareTo(LayoutObjectAttributes layoutObjectAttributes) {
        if (!this.getClass().equals(layoutObjectAttributes.getClass())) {
            return this.getClass().getName().compareTo(layoutObjectAttributes.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetCss(), layoutObjectAttributes.isSetCss());
        if (n != 0) {
            return n;
        }
        if (this.isSetCss() && (n = TBaseHelper.compareTo((String)this.css, (String)layoutObjectAttributes.css)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetCssName(), layoutObjectAttributes.isSetCssName());
        if (n != 0) {
            return n;
        }
        if (this.isSetCssName() && (n = TBaseHelper.compareTo((String)this.cssName, (String)layoutObjectAttributes.cssName)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetPosition(), layoutObjectAttributes.isSetPosition());
        if (n != 0) {
            return n;
        }
        if (this.isSetPosition() && (n = TBaseHelper.compareTo((Comparable)this.position, (Comparable)layoutObjectAttributes.position)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetHeight(), layoutObjectAttributes.isSetHeight());
        if (n != 0) {
            return n;
        }
        if (this.isSetHeight() && (n = TBaseHelper.compareTo((int)this.height, (int)layoutObjectAttributes.height)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetWidth(), layoutObjectAttributes.isSetWidth());
        if (n != 0) {
            return n;
        }
        if (this.isSetWidth() && (n = TBaseHelper.compareTo((int)this.width, (int)layoutObjectAttributes.width)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetTabOrder(), layoutObjectAttributes.isSetTabOrder());
        if (n != 0) {
            return n;
        }
        if (this.isSetTabOrder() && (n = TBaseHelper.compareTo((int)this.tabOrder, (int)layoutObjectAttributes.tabOrder)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        LayoutObjectAttributes.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        LayoutObjectAttributes.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("LayoutObjectAttributes(");
        boolean bl = true;
        stringBuilder.append("css:");
        if (this.css == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.css);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("cssName:");
        if (this.cssName == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.cssName);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
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
        stringBuilder.append("height:");
        stringBuilder.append(this.height);
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
        stringBuilder.append("tabOrder:");
        stringBuilder.append(this.tabOrder);
        bl = false;
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void validate() throws TException {
        if (this.position != null) {
            this.position.validate();
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
        enumMap.put(_Fields.CSS, new FieldMetaData("css", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.CSS_NAME, new FieldMetaData("cssName", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.POSITION, new FieldMetaData("position", 3, (FieldValueMetaData)new StructMetaData(12, Position.class)));
        enumMap.put(_Fields.HEIGHT, new FieldMetaData("height", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.WIDTH, new FieldMetaData("width", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.TAB_ORDER, new FieldMetaData("tabOrder", 3, new FieldValueMetaData(8)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(LayoutObjectAttributes.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        CSS(1, "css"),
        CSS_NAME(2, "cssName"),
        POSITION(3, "position"),
        HEIGHT(4, "height"),
        WIDTH(5, "width"),
        TAB_ORDER(6, "tabOrder");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return CSS;
                }
                case 2: {
                    return CSS_NAME;
                }
                case 3: {
                    return POSITION;
                }
                case 4: {
                    return HEIGHT;
                }
                case 5: {
                    return WIDTH;
                }
                case 6: {
                    return TAB_ORDER;
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

    private static class LayoutObjectAttributesStandardSchemeFactory
    implements SchemeFactory {
        private LayoutObjectAttributesStandardSchemeFactory() {
        }

        public LayoutObjectAttributesStandardScheme getScheme() {
            return new LayoutObjectAttributesStandardScheme();
        }
    }

    private static class LayoutObjectAttributesTupleSchemeFactory
    implements SchemeFactory {
        private LayoutObjectAttributesTupleSchemeFactory() {
        }

        public LayoutObjectAttributesTupleScheme getScheme() {
            return new LayoutObjectAttributesTupleScheme();
        }
    }

    private static class LayoutObjectAttributesTupleScheme
    extends TupleScheme<LayoutObjectAttributes> {
        private LayoutObjectAttributesTupleScheme() {
        }

        public void write(TProtocol tProtocol, LayoutObjectAttributes layoutObjectAttributes) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (layoutObjectAttributes.isSetCss()) {
                bitSet.set(0);
            }
            if (layoutObjectAttributes.isSetCssName()) {
                bitSet.set(1);
            }
            if (layoutObjectAttributes.isSetPosition()) {
                bitSet.set(2);
            }
            if (layoutObjectAttributes.isSetHeight()) {
                bitSet.set(3);
            }
            if (layoutObjectAttributes.isSetWidth()) {
                bitSet.set(4);
            }
            if (layoutObjectAttributes.isSetTabOrder()) {
                bitSet.set(5);
            }
            tTupleProtocol.writeBitSet(bitSet, 6);
            if (layoutObjectAttributes.isSetCss()) {
                tTupleProtocol.writeString(layoutObjectAttributes.css);
            }
            if (layoutObjectAttributes.isSetCssName()) {
                tTupleProtocol.writeString(layoutObjectAttributes.cssName);
            }
            if (layoutObjectAttributes.isSetPosition()) {
                layoutObjectAttributes.position.write((TProtocol)tTupleProtocol);
            }
            if (layoutObjectAttributes.isSetHeight()) {
                tTupleProtocol.writeI32(layoutObjectAttributes.height);
            }
            if (layoutObjectAttributes.isSetWidth()) {
                tTupleProtocol.writeI32(layoutObjectAttributes.width);
            }
            if (layoutObjectAttributes.isSetTabOrder()) {
                tTupleProtocol.writeI32(layoutObjectAttributes.tabOrder);
            }
        }

        public void read(TProtocol tProtocol, LayoutObjectAttributes layoutObjectAttributes) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(6);
            if (bitSet.get(0)) {
                layoutObjectAttributes.css = tTupleProtocol.readString();
                layoutObjectAttributes.setCssIsSet(true);
            }
            if (bitSet.get(1)) {
                layoutObjectAttributes.cssName = tTupleProtocol.readString();
                layoutObjectAttributes.setCssNameIsSet(true);
            }
            if (bitSet.get(2)) {
                layoutObjectAttributes.position = new Position();
                layoutObjectAttributes.position.read((TProtocol)tTupleProtocol);
                layoutObjectAttributes.setPositionIsSet(true);
            }
            if (bitSet.get(3)) {
                layoutObjectAttributes.height = tTupleProtocol.readI32();
                layoutObjectAttributes.setHeightIsSet(true);
            }
            if (bitSet.get(4)) {
                layoutObjectAttributes.width = tTupleProtocol.readI32();
                layoutObjectAttributes.setWidthIsSet(true);
            }
            if (bitSet.get(5)) {
                layoutObjectAttributes.tabOrder = tTupleProtocol.readI32();
                layoutObjectAttributes.setTabOrderIsSet(true);
            }
        }
    }

    private static class LayoutObjectAttributesStandardScheme
    extends StandardScheme<LayoutObjectAttributes> {
        private LayoutObjectAttributesStandardScheme() {
        }

        public void read(TProtocol tProtocol, LayoutObjectAttributes layoutObjectAttributes) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 11) {
                            layoutObjectAttributes.css = tProtocol.readString();
                            layoutObjectAttributes.setCssIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 11) {
                            layoutObjectAttributes.cssName = tProtocol.readString();
                            layoutObjectAttributes.setCssNameIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 12) {
                            layoutObjectAttributes.position = new Position();
                            layoutObjectAttributes.position.read(tProtocol);
                            layoutObjectAttributes.setPositionIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 8) {
                            layoutObjectAttributes.height = tProtocol.readI32();
                            layoutObjectAttributes.setHeightIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 5: {
                        if (tField.type == 8) {
                            layoutObjectAttributes.width = tProtocol.readI32();
                            layoutObjectAttributes.setWidthIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 6: {
                        if (tField.type == 8) {
                            layoutObjectAttributes.tabOrder = tProtocol.readI32();
                            layoutObjectAttributes.setTabOrderIsSet(true);
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
            layoutObjectAttributes.validate();
        }

        public void write(TProtocol tProtocol, LayoutObjectAttributes layoutObjectAttributes) throws TException {
            layoutObjectAttributes.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (layoutObjectAttributes.css != null) {
                tProtocol.writeFieldBegin(CSS_FIELD_DESC);
                tProtocol.writeString(layoutObjectAttributes.css);
                tProtocol.writeFieldEnd();
            }
            if (layoutObjectAttributes.cssName != null) {
                tProtocol.writeFieldBegin(CSS_NAME_FIELD_DESC);
                tProtocol.writeString(layoutObjectAttributes.cssName);
                tProtocol.writeFieldEnd();
            }
            if (layoutObjectAttributes.position != null) {
                tProtocol.writeFieldBegin(POSITION_FIELD_DESC);
                layoutObjectAttributes.position.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(HEIGHT_FIELD_DESC);
            tProtocol.writeI32(layoutObjectAttributes.height);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(WIDTH_FIELD_DESC);
            tProtocol.writeI32(layoutObjectAttributes.width);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(TAB_ORDER_FIELD_DESC);
            tProtocol.writeI32(layoutObjectAttributes.tabOrder);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

