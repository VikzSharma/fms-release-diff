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
 *  org.apache.thrift.meta_data.EnumMetaData
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

import com.filemaker.jwpc.iwp.thrift.common.LayoutObjectType;
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
import org.apache.thrift.meta_data.EnumMetaData;
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

public class DialogFieldObject
implements TBase<DialogFieldObject, _Fields>,
Serializable,
Cloneable,
Comparable<DialogFieldObject> {
    private static final TStruct STRUCT_DESC = new TStruct("DialogFieldObject");
    private static final TField TYPE_FIELD_DESC = new TField("type", 8, 1);
    private static final TField FIELD_INDEX_FIELD_DESC = new TField("fieldIndex", 8, 2);
    private static final TField FIELD_VALUE_FIELD_DESC = new TField("fieldValue", 11, 3);
    private static final TField FIELD_LABEL_FIELD_DESC = new TField("fieldLabel", 11, 4);
    private static final TField USE_PWD_CHAR_FIELD_DESC = new TField("usePwdChar", 2, 5);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new DialogFieldObjectStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new DialogFieldObjectTupleSchemeFactory();
    @Nullable
    private LayoutObjectType type;
    private int fieldIndex;
    @Nullable
    private String fieldValue;
    @Nullable
    private String fieldLabel;
    private boolean usePwdChar;
    private static final int __FIELDINDEX_ISSET_ID = 0;
    private static final int __USEPWDCHAR_ISSET_ID = 1;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public DialogFieldObject() {
    }

    public DialogFieldObject(LayoutObjectType layoutObjectType, int n, String string, String string2, boolean bl) {
        this();
        this.type = layoutObjectType;
        this.fieldIndex = n;
        this.setFieldIndexIsSet(true);
        this.fieldValue = string;
        this.fieldLabel = string2;
        this.usePwdChar = bl;
        this.setUsePwdCharIsSet(true);
    }

    public DialogFieldObject(DialogFieldObject dialogFieldObject) {
        this.__isset_bitfield = dialogFieldObject.__isset_bitfield;
        if (dialogFieldObject.isSetType()) {
            this.type = dialogFieldObject.type;
        }
        this.fieldIndex = dialogFieldObject.fieldIndex;
        if (dialogFieldObject.isSetFieldValue()) {
            this.fieldValue = dialogFieldObject.fieldValue;
        }
        if (dialogFieldObject.isSetFieldLabel()) {
            this.fieldLabel = dialogFieldObject.fieldLabel;
        }
        this.usePwdChar = dialogFieldObject.usePwdChar;
    }

    public DialogFieldObject deepCopy() {
        return new DialogFieldObject(this);
    }

    public void clear() {
        this.type = null;
        this.setFieldIndexIsSet(false);
        this.fieldIndex = 0;
        this.fieldValue = null;
        this.fieldLabel = null;
        this.setUsePwdCharIsSet(false);
        this.usePwdChar = false;
    }

    @Nullable
    public LayoutObjectType getType() {
        return this.type;
    }

    public void setType(@Nullable LayoutObjectType layoutObjectType) {
        this.type = layoutObjectType;
    }

    public void unsetType() {
        this.type = null;
    }

    public boolean isSetType() {
        return this.type != null;
    }

    public void setTypeIsSet(boolean bl) {
        if (!bl) {
            this.type = null;
        }
    }

    public int getFieldIndex() {
        return this.fieldIndex;
    }

    public void setFieldIndex(int n) {
        this.fieldIndex = n;
        this.setFieldIndexIsSet(true);
    }

    public void unsetFieldIndex() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetFieldIndex() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setFieldIndexIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    @Nullable
    public String getFieldValue() {
        return this.fieldValue;
    }

    public void setFieldValue(@Nullable String string) {
        this.fieldValue = string;
    }

    public void unsetFieldValue() {
        this.fieldValue = null;
    }

    public boolean isSetFieldValue() {
        return this.fieldValue != null;
    }

    public void setFieldValueIsSet(boolean bl) {
        if (!bl) {
            this.fieldValue = null;
        }
    }

    @Nullable
    public String getFieldLabel() {
        return this.fieldLabel;
    }

    public void setFieldLabel(@Nullable String string) {
        this.fieldLabel = string;
    }

    public void unsetFieldLabel() {
        this.fieldLabel = null;
    }

    public boolean isSetFieldLabel() {
        return this.fieldLabel != null;
    }

    public void setFieldLabelIsSet(boolean bl) {
        if (!bl) {
            this.fieldLabel = null;
        }
    }

    public boolean isUsePwdChar() {
        return this.usePwdChar;
    }

    public void setUsePwdChar(boolean bl) {
        this.usePwdChar = bl;
        this.setUsePwdCharIsSet(true);
    }

    public void unsetUsePwdChar() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)1);
    }

    public boolean isSetUsePwdChar() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)1);
    }

    public void setUsePwdCharIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)1, (boolean)bl);
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetType();
                    break;
                }
                this.setType((LayoutObjectType)((Object)object));
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetFieldIndex();
                    break;
                }
                this.setFieldIndex((Integer)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetFieldValue();
                    break;
                }
                this.setFieldValue((String)object);
                break;
            }
            case 3: {
                if (object == null) {
                    this.unsetFieldLabel();
                    break;
                }
                this.setFieldLabel((String)object);
                break;
            }
            case 4: {
                if (object == null) {
                    this.unsetUsePwdChar();
                    break;
                }
                this.setUsePwdChar((Boolean)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getType();
            }
            case 1: {
                return this.getFieldIndex();
            }
            case 2: {
                return this.getFieldValue();
            }
            case 3: {
                return this.getFieldLabel();
            }
            case 4: {
                return this.isUsePwdChar();
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
                return this.isSetType();
            }
            case 1: {
                return this.isSetFieldIndex();
            }
            case 2: {
                return this.isSetFieldValue();
            }
            case 3: {
                return this.isSetFieldLabel();
            }
            case 4: {
                return this.isSetUsePwdChar();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof DialogFieldObject) {
            return this.equals((DialogFieldObject)object);
        }
        return false;
    }

    public boolean equals(DialogFieldObject dialogFieldObject) {
        if (dialogFieldObject == null) {
            return false;
        }
        if (this == dialogFieldObject) {
            return true;
        }
        boolean bl = this.isSetType();
        boolean bl2 = dialogFieldObject.isSetType();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.type.equals((Object)dialogFieldObject.type)) {
                return false;
            }
        }
        boolean bl3 = true;
        boolean bl4 = true;
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (this.fieldIndex != dialogFieldObject.fieldIndex) {
                return false;
            }
        }
        boolean bl5 = this.isSetFieldValue();
        boolean bl6 = dialogFieldObject.isSetFieldValue();
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (!this.fieldValue.equals(dialogFieldObject.fieldValue)) {
                return false;
            }
        }
        boolean bl7 = this.isSetFieldLabel();
        boolean bl8 = dialogFieldObject.isSetFieldLabel();
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (!this.fieldLabel.equals(dialogFieldObject.fieldLabel)) {
                return false;
            }
        }
        boolean bl9 = true;
        boolean bl10 = true;
        if (bl9 || bl10) {
            if (!bl9 || !bl10) {
                return false;
            }
            if (this.usePwdChar != dialogFieldObject.usePwdChar) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetType() ? 131071 : 524287);
        if (this.isSetType()) {
            n = n * 8191 + this.type.getValue();
        }
        n = n * 8191 + this.fieldIndex;
        n = n * 8191 + (this.isSetFieldValue() ? 131071 : 524287);
        if (this.isSetFieldValue()) {
            n = n * 8191 + this.fieldValue.hashCode();
        }
        n = n * 8191 + (this.isSetFieldLabel() ? 131071 : 524287);
        if (this.isSetFieldLabel()) {
            n = n * 8191 + this.fieldLabel.hashCode();
        }
        n = n * 8191 + (this.usePwdChar ? 131071 : 524287);
        return n;
    }

    @Override
    public int compareTo(DialogFieldObject dialogFieldObject) {
        if (!this.getClass().equals(dialogFieldObject.getClass())) {
            return this.getClass().getName().compareTo(dialogFieldObject.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetType(), dialogFieldObject.isSetType());
        if (n != 0) {
            return n;
        }
        if (this.isSetType() && (n = TBaseHelper.compareTo((Comparable)((Object)this.type), (Comparable)((Object)dialogFieldObject.type))) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetFieldIndex(), dialogFieldObject.isSetFieldIndex());
        if (n != 0) {
            return n;
        }
        if (this.isSetFieldIndex() && (n = TBaseHelper.compareTo((int)this.fieldIndex, (int)dialogFieldObject.fieldIndex)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetFieldValue(), dialogFieldObject.isSetFieldValue());
        if (n != 0) {
            return n;
        }
        if (this.isSetFieldValue() && (n = TBaseHelper.compareTo((String)this.fieldValue, (String)dialogFieldObject.fieldValue)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetFieldLabel(), dialogFieldObject.isSetFieldLabel());
        if (n != 0) {
            return n;
        }
        if (this.isSetFieldLabel() && (n = TBaseHelper.compareTo((String)this.fieldLabel, (String)dialogFieldObject.fieldLabel)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetUsePwdChar(), dialogFieldObject.isSetUsePwdChar());
        if (n != 0) {
            return n;
        }
        if (this.isSetUsePwdChar() && (n = TBaseHelper.compareTo((boolean)this.usePwdChar, (boolean)dialogFieldObject.usePwdChar)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        DialogFieldObject.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        DialogFieldObject.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("DialogFieldObject(");
        boolean bl = true;
        stringBuilder.append("type:");
        if (this.type == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append((Object)this.type);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("fieldIndex:");
        stringBuilder.append(this.fieldIndex);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("fieldValue:");
        if (this.fieldValue == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.fieldValue);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("fieldLabel:");
        if (this.fieldLabel == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.fieldLabel);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("usePwdChar:");
        stringBuilder.append(this.usePwdChar);
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
        enumMap.put(_Fields.TYPE, new FieldMetaData("type", 3, (FieldValueMetaData)new EnumMetaData(-1, LayoutObjectType.class)));
        enumMap.put(_Fields.FIELD_INDEX, new FieldMetaData("fieldIndex", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.FIELD_VALUE, new FieldMetaData("fieldValue", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.FIELD_LABEL, new FieldMetaData("fieldLabel", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.USE_PWD_CHAR, new FieldMetaData("usePwdChar", 3, new FieldValueMetaData(2)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(DialogFieldObject.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        TYPE(1, "type"),
        FIELD_INDEX(2, "fieldIndex"),
        FIELD_VALUE(3, "fieldValue"),
        FIELD_LABEL(4, "fieldLabel"),
        USE_PWD_CHAR(5, "usePwdChar");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return TYPE;
                }
                case 2: {
                    return FIELD_INDEX;
                }
                case 3: {
                    return FIELD_VALUE;
                }
                case 4: {
                    return FIELD_LABEL;
                }
                case 5: {
                    return USE_PWD_CHAR;
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

    private static class DialogFieldObjectStandardSchemeFactory
    implements SchemeFactory {
        private DialogFieldObjectStandardSchemeFactory() {
        }

        public DialogFieldObjectStandardScheme getScheme() {
            return new DialogFieldObjectStandardScheme();
        }
    }

    private static class DialogFieldObjectTupleSchemeFactory
    implements SchemeFactory {
        private DialogFieldObjectTupleSchemeFactory() {
        }

        public DialogFieldObjectTupleScheme getScheme() {
            return new DialogFieldObjectTupleScheme();
        }
    }

    private static class DialogFieldObjectTupleScheme
    extends TupleScheme<DialogFieldObject> {
        private DialogFieldObjectTupleScheme() {
        }

        public void write(TProtocol tProtocol, DialogFieldObject dialogFieldObject) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (dialogFieldObject.isSetType()) {
                bitSet.set(0);
            }
            if (dialogFieldObject.isSetFieldIndex()) {
                bitSet.set(1);
            }
            if (dialogFieldObject.isSetFieldValue()) {
                bitSet.set(2);
            }
            if (dialogFieldObject.isSetFieldLabel()) {
                bitSet.set(3);
            }
            if (dialogFieldObject.isSetUsePwdChar()) {
                bitSet.set(4);
            }
            tTupleProtocol.writeBitSet(bitSet, 5);
            if (dialogFieldObject.isSetType()) {
                tTupleProtocol.writeI32(dialogFieldObject.type.getValue());
            }
            if (dialogFieldObject.isSetFieldIndex()) {
                tTupleProtocol.writeI32(dialogFieldObject.fieldIndex);
            }
            if (dialogFieldObject.isSetFieldValue()) {
                tTupleProtocol.writeString(dialogFieldObject.fieldValue);
            }
            if (dialogFieldObject.isSetFieldLabel()) {
                tTupleProtocol.writeString(dialogFieldObject.fieldLabel);
            }
            if (dialogFieldObject.isSetUsePwdChar()) {
                tTupleProtocol.writeBool(dialogFieldObject.usePwdChar);
            }
        }

        public void read(TProtocol tProtocol, DialogFieldObject dialogFieldObject) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(5);
            if (bitSet.get(0)) {
                dialogFieldObject.type = LayoutObjectType.findByValue(tTupleProtocol.readI32());
                dialogFieldObject.setTypeIsSet(true);
            }
            if (bitSet.get(1)) {
                dialogFieldObject.fieldIndex = tTupleProtocol.readI32();
                dialogFieldObject.setFieldIndexIsSet(true);
            }
            if (bitSet.get(2)) {
                dialogFieldObject.fieldValue = tTupleProtocol.readString();
                dialogFieldObject.setFieldValueIsSet(true);
            }
            if (bitSet.get(3)) {
                dialogFieldObject.fieldLabel = tTupleProtocol.readString();
                dialogFieldObject.setFieldLabelIsSet(true);
            }
            if (bitSet.get(4)) {
                dialogFieldObject.usePwdChar = tTupleProtocol.readBool();
                dialogFieldObject.setUsePwdCharIsSet(true);
            }
        }
    }

    private static class DialogFieldObjectStandardScheme
    extends StandardScheme<DialogFieldObject> {
        private DialogFieldObjectStandardScheme() {
        }

        public void read(TProtocol tProtocol, DialogFieldObject dialogFieldObject) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 8) {
                            dialogFieldObject.type = LayoutObjectType.findByValue(tProtocol.readI32());
                            dialogFieldObject.setTypeIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 8) {
                            dialogFieldObject.fieldIndex = tProtocol.readI32();
                            dialogFieldObject.setFieldIndexIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 11) {
                            dialogFieldObject.fieldValue = tProtocol.readString();
                            dialogFieldObject.setFieldValueIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 11) {
                            dialogFieldObject.fieldLabel = tProtocol.readString();
                            dialogFieldObject.setFieldLabelIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 5: {
                        if (tField.type == 2) {
                            dialogFieldObject.usePwdChar = tProtocol.readBool();
                            dialogFieldObject.setUsePwdCharIsSet(true);
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
            dialogFieldObject.validate();
        }

        public void write(TProtocol tProtocol, DialogFieldObject dialogFieldObject) throws TException {
            dialogFieldObject.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (dialogFieldObject.type != null) {
                tProtocol.writeFieldBegin(TYPE_FIELD_DESC);
                tProtocol.writeI32(dialogFieldObject.type.getValue());
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(FIELD_INDEX_FIELD_DESC);
            tProtocol.writeI32(dialogFieldObject.fieldIndex);
            tProtocol.writeFieldEnd();
            if (dialogFieldObject.fieldValue != null) {
                tProtocol.writeFieldBegin(FIELD_VALUE_FIELD_DESC);
                tProtocol.writeString(dialogFieldObject.fieldValue);
                tProtocol.writeFieldEnd();
            }
            if (dialogFieldObject.fieldLabel != null) {
                tProtocol.writeFieldBegin(FIELD_LABEL_FIELD_DESC);
                tProtocol.writeString(dialogFieldObject.fieldLabel);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(USE_PWD_CHAR_FIELD_DESC);
            tProtocol.writeBool(dialogFieldObject.usePwdChar);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

