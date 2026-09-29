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

public class DialogButtonObject
implements TBase<DialogButtonObject, _Fields>,
Serializable,
Cloneable,
Comparable<DialogButtonObject> {
    private static final TStruct STRUCT_DESC = new TStruct("DialogButtonObject");
    private static final TField INDEX_FIELD_DESC = new TField("index", 6, 1);
    private static final TField LABEL_FIELD_DESC = new TField("label", 11, 2);
    private static final TField DEFAULT_BUTTON_FIELD_DESC = new TField("defaultButton", 2, 3);
    private static final TField COMMIT_FIELD_DESC = new TField("commit", 2, 4);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new DialogButtonObjectStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new DialogButtonObjectTupleSchemeFactory();
    private short index;
    @Nullable
    private String label;
    private boolean defaultButton;
    private boolean commit;
    private static final int __INDEX_ISSET_ID = 0;
    private static final int __DEFAULTBUTTON_ISSET_ID = 1;
    private static final int __COMMIT_ISSET_ID = 2;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public DialogButtonObject() {
    }

    public DialogButtonObject(short s, String string, boolean bl, boolean bl2) {
        this();
        this.index = s;
        this.setIndexIsSet(true);
        this.label = string;
        this.defaultButton = bl;
        this.setDefaultButtonIsSet(true);
        this.commit = bl2;
        this.setCommitIsSet(true);
    }

    public DialogButtonObject(DialogButtonObject dialogButtonObject) {
        this.__isset_bitfield = dialogButtonObject.__isset_bitfield;
        this.index = dialogButtonObject.index;
        if (dialogButtonObject.isSetLabel()) {
            this.label = dialogButtonObject.label;
        }
        this.defaultButton = dialogButtonObject.defaultButton;
        this.commit = dialogButtonObject.commit;
    }

    public DialogButtonObject deepCopy() {
        return new DialogButtonObject(this);
    }

    public void clear() {
        this.setIndexIsSet(false);
        this.index = 0;
        this.label = null;
        this.setDefaultButtonIsSet(false);
        this.defaultButton = false;
        this.setCommitIsSet(false);
        this.commit = false;
    }

    public short getIndex() {
        return this.index;
    }

    public void setIndex(short s) {
        this.index = s;
        this.setIndexIsSet(true);
    }

    public void unsetIndex() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetIndex() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setIndexIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    @Nullable
    public String getLabel() {
        return this.label;
    }

    public void setLabel(@Nullable String string) {
        this.label = string;
    }

    public void unsetLabel() {
        this.label = null;
    }

    public boolean isSetLabel() {
        return this.label != null;
    }

    public void setLabelIsSet(boolean bl) {
        if (!bl) {
            this.label = null;
        }
    }

    public boolean isDefaultButton() {
        return this.defaultButton;
    }

    public void setDefaultButton(boolean bl) {
        this.defaultButton = bl;
        this.setDefaultButtonIsSet(true);
    }

    public void unsetDefaultButton() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)1);
    }

    public boolean isSetDefaultButton() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)1);
    }

    public void setDefaultButtonIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)1, (boolean)bl);
    }

    public boolean isCommit() {
        return this.commit;
    }

    public void setCommit(boolean bl) {
        this.commit = bl;
        this.setCommitIsSet(true);
    }

    public void unsetCommit() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)2);
    }

    public boolean isSetCommit() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)2);
    }

    public void setCommitIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)2, (boolean)bl);
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetIndex();
                    break;
                }
                this.setIndex((Short)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetLabel();
                    break;
                }
                this.setLabel((String)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetDefaultButton();
                    break;
                }
                this.setDefaultButton((Boolean)object);
                break;
            }
            case 3: {
                if (object == null) {
                    this.unsetCommit();
                    break;
                }
                this.setCommit((Boolean)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getIndex();
            }
            case 1: {
                return this.getLabel();
            }
            case 2: {
                return this.isDefaultButton();
            }
            case 3: {
                return this.isCommit();
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
                return this.isSetIndex();
            }
            case 1: {
                return this.isSetLabel();
            }
            case 2: {
                return this.isSetDefaultButton();
            }
            case 3: {
                return this.isSetCommit();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof DialogButtonObject) {
            return this.equals((DialogButtonObject)object);
        }
        return false;
    }

    public boolean equals(DialogButtonObject dialogButtonObject) {
        if (dialogButtonObject == null) {
            return false;
        }
        if (this == dialogButtonObject) {
            return true;
        }
        boolean bl = true;
        boolean bl2 = true;
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (this.index != dialogButtonObject.index) {
                return false;
            }
        }
        boolean bl3 = this.isSetLabel();
        boolean bl4 = dialogButtonObject.isSetLabel();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.label.equals(dialogButtonObject.label)) {
                return false;
            }
        }
        boolean bl5 = true;
        boolean bl6 = true;
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (this.defaultButton != dialogButtonObject.defaultButton) {
                return false;
            }
        }
        boolean bl7 = true;
        boolean bl8 = true;
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (this.commit != dialogButtonObject.commit) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + this.index;
        n = n * 8191 + (this.isSetLabel() ? 131071 : 524287);
        if (this.isSetLabel()) {
            n = n * 8191 + this.label.hashCode();
        }
        n = n * 8191 + (this.defaultButton ? 131071 : 524287);
        n = n * 8191 + (this.commit ? 131071 : 524287);
        return n;
    }

    @Override
    public int compareTo(DialogButtonObject dialogButtonObject) {
        if (!this.getClass().equals(dialogButtonObject.getClass())) {
            return this.getClass().getName().compareTo(dialogButtonObject.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetIndex(), dialogButtonObject.isSetIndex());
        if (n != 0) {
            return n;
        }
        if (this.isSetIndex() && (n = TBaseHelper.compareTo((short)this.index, (short)dialogButtonObject.index)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetLabel(), dialogButtonObject.isSetLabel());
        if (n != 0) {
            return n;
        }
        if (this.isSetLabel() && (n = TBaseHelper.compareTo((String)this.label, (String)dialogButtonObject.label)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetDefaultButton(), dialogButtonObject.isSetDefaultButton());
        if (n != 0) {
            return n;
        }
        if (this.isSetDefaultButton() && (n = TBaseHelper.compareTo((boolean)this.defaultButton, (boolean)dialogButtonObject.defaultButton)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetCommit(), dialogButtonObject.isSetCommit());
        if (n != 0) {
            return n;
        }
        if (this.isSetCommit() && (n = TBaseHelper.compareTo((boolean)this.commit, (boolean)dialogButtonObject.commit)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        DialogButtonObject.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        DialogButtonObject.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("DialogButtonObject(");
        boolean bl = true;
        stringBuilder.append("index:");
        stringBuilder.append(this.index);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("label:");
        if (this.label == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.label);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("defaultButton:");
        stringBuilder.append(this.defaultButton);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("commit:");
        stringBuilder.append(this.commit);
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
        enumMap.put(_Fields.INDEX, new FieldMetaData("index", 3, new FieldValueMetaData(6)));
        enumMap.put(_Fields.LABEL, new FieldMetaData("label", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.DEFAULT_BUTTON, new FieldMetaData("defaultButton", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.COMMIT, new FieldMetaData("commit", 3, new FieldValueMetaData(2)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(DialogButtonObject.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        INDEX(1, "index"),
        LABEL(2, "label"),
        DEFAULT_BUTTON(3, "defaultButton"),
        COMMIT(4, "commit");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return INDEX;
                }
                case 2: {
                    return LABEL;
                }
                case 3: {
                    return DEFAULT_BUTTON;
                }
                case 4: {
                    return COMMIT;
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

    private static class DialogButtonObjectStandardSchemeFactory
    implements SchemeFactory {
        private DialogButtonObjectStandardSchemeFactory() {
        }

        public DialogButtonObjectStandardScheme getScheme() {
            return new DialogButtonObjectStandardScheme();
        }
    }

    private static class DialogButtonObjectTupleSchemeFactory
    implements SchemeFactory {
        private DialogButtonObjectTupleSchemeFactory() {
        }

        public DialogButtonObjectTupleScheme getScheme() {
            return new DialogButtonObjectTupleScheme();
        }
    }

    private static class DialogButtonObjectTupleScheme
    extends TupleScheme<DialogButtonObject> {
        private DialogButtonObjectTupleScheme() {
        }

        public void write(TProtocol tProtocol, DialogButtonObject dialogButtonObject) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (dialogButtonObject.isSetIndex()) {
                bitSet.set(0);
            }
            if (dialogButtonObject.isSetLabel()) {
                bitSet.set(1);
            }
            if (dialogButtonObject.isSetDefaultButton()) {
                bitSet.set(2);
            }
            if (dialogButtonObject.isSetCommit()) {
                bitSet.set(3);
            }
            tTupleProtocol.writeBitSet(bitSet, 4);
            if (dialogButtonObject.isSetIndex()) {
                tTupleProtocol.writeI16(dialogButtonObject.index);
            }
            if (dialogButtonObject.isSetLabel()) {
                tTupleProtocol.writeString(dialogButtonObject.label);
            }
            if (dialogButtonObject.isSetDefaultButton()) {
                tTupleProtocol.writeBool(dialogButtonObject.defaultButton);
            }
            if (dialogButtonObject.isSetCommit()) {
                tTupleProtocol.writeBool(dialogButtonObject.commit);
            }
        }

        public void read(TProtocol tProtocol, DialogButtonObject dialogButtonObject) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(4);
            if (bitSet.get(0)) {
                dialogButtonObject.index = tTupleProtocol.readI16();
                dialogButtonObject.setIndexIsSet(true);
            }
            if (bitSet.get(1)) {
                dialogButtonObject.label = tTupleProtocol.readString();
                dialogButtonObject.setLabelIsSet(true);
            }
            if (bitSet.get(2)) {
                dialogButtonObject.defaultButton = tTupleProtocol.readBool();
                dialogButtonObject.setDefaultButtonIsSet(true);
            }
            if (bitSet.get(3)) {
                dialogButtonObject.commit = tTupleProtocol.readBool();
                dialogButtonObject.setCommitIsSet(true);
            }
        }
    }

    private static class DialogButtonObjectStandardScheme
    extends StandardScheme<DialogButtonObject> {
        private DialogButtonObjectStandardScheme() {
        }

        public void read(TProtocol tProtocol, DialogButtonObject dialogButtonObject) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 6) {
                            dialogButtonObject.index = tProtocol.readI16();
                            dialogButtonObject.setIndexIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 11) {
                            dialogButtonObject.label = tProtocol.readString();
                            dialogButtonObject.setLabelIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 2) {
                            dialogButtonObject.defaultButton = tProtocol.readBool();
                            dialogButtonObject.setDefaultButtonIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 2) {
                            dialogButtonObject.commit = tProtocol.readBool();
                            dialogButtonObject.setCommitIsSet(true);
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
            dialogButtonObject.validate();
        }

        public void write(TProtocol tProtocol, DialogButtonObject dialogButtonObject) throws TException {
            dialogButtonObject.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            tProtocol.writeFieldBegin(INDEX_FIELD_DESC);
            tProtocol.writeI16(dialogButtonObject.index);
            tProtocol.writeFieldEnd();
            if (dialogButtonObject.label != null) {
                tProtocol.writeFieldBegin(LABEL_FIELD_DESC);
                tProtocol.writeString(dialogButtonObject.label);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(DEFAULT_BUTTON_FIELD_DESC);
            tProtocol.writeBool(dialogButtonObject.defaultButton);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(COMMIT_FIELD_DESC);
            tProtocol.writeBool(dialogButtonObject.commit);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

