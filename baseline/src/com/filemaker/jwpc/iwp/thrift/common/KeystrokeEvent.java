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

public class KeystrokeEvent
implements TBase<KeystrokeEvent, _Fields>,
Serializable,
Cloneable,
Comparable<KeystrokeEvent> {
    private static final TStruct STRUCT_DESC = new TStruct("KeystrokeEvent");
    private static final TField KEY_CODE_FIELD_DESC = new TField("keyCode", 8, 1);
    private static final TField IS_RETURN_FIELD_DESC = new TField("isReturn", 2, 2);
    private static final TField CURRENT_TEXT_FIELD_DESC = new TField("currentText", 11, 3);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new KeystrokeEventStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new KeystrokeEventTupleSchemeFactory();
    private int keyCode;
    private boolean isReturn;
    @Nullable
    private String currentText;
    private static final int __KEYCODE_ISSET_ID = 0;
    private static final int __ISRETURN_ISSET_ID = 1;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public KeystrokeEvent() {
    }

    public KeystrokeEvent(int n, boolean bl, String string) {
        this();
        this.keyCode = n;
        this.setKeyCodeIsSet(true);
        this.isReturn = bl;
        this.setIsReturnIsSet(true);
        this.currentText = string;
    }

    public KeystrokeEvent(KeystrokeEvent keystrokeEvent) {
        this.__isset_bitfield = keystrokeEvent.__isset_bitfield;
        this.keyCode = keystrokeEvent.keyCode;
        this.isReturn = keystrokeEvent.isReturn;
        if (keystrokeEvent.isSetCurrentText()) {
            this.currentText = keystrokeEvent.currentText;
        }
    }

    public KeystrokeEvent deepCopy() {
        return new KeystrokeEvent(this);
    }

    public void clear() {
        this.setKeyCodeIsSet(false);
        this.keyCode = 0;
        this.setIsReturnIsSet(false);
        this.isReturn = false;
        this.currentText = null;
    }

    public int getKeyCode() {
        return this.keyCode;
    }

    public void setKeyCode(int n) {
        this.keyCode = n;
        this.setKeyCodeIsSet(true);
    }

    public void unsetKeyCode() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetKeyCode() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setKeyCodeIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public boolean isIsReturn() {
        return this.isReturn;
    }

    public void setIsReturn(boolean bl) {
        this.isReturn = bl;
        this.setIsReturnIsSet(true);
    }

    public void unsetIsReturn() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)1);
    }

    public boolean isSetIsReturn() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)1);
    }

    public void setIsReturnIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)1, (boolean)bl);
    }

    @Nullable
    public String getCurrentText() {
        return this.currentText;
    }

    public void setCurrentText(@Nullable String string) {
        this.currentText = string;
    }

    public void unsetCurrentText() {
        this.currentText = null;
    }

    public boolean isSetCurrentText() {
        return this.currentText != null;
    }

    public void setCurrentTextIsSet(boolean bl) {
        if (!bl) {
            this.currentText = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetKeyCode();
                    break;
                }
                this.setKeyCode((Integer)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetIsReturn();
                    break;
                }
                this.setIsReturn((Boolean)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetCurrentText();
                    break;
                }
                this.setCurrentText((String)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getKeyCode();
            }
            case 1: {
                return this.isIsReturn();
            }
            case 2: {
                return this.getCurrentText();
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
                return this.isSetKeyCode();
            }
            case 1: {
                return this.isSetIsReturn();
            }
            case 2: {
                return this.isSetCurrentText();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof KeystrokeEvent) {
            return this.equals((KeystrokeEvent)object);
        }
        return false;
    }

    public boolean equals(KeystrokeEvent keystrokeEvent) {
        if (keystrokeEvent == null) {
            return false;
        }
        if (this == keystrokeEvent) {
            return true;
        }
        boolean bl = true;
        boolean bl2 = true;
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (this.keyCode != keystrokeEvent.keyCode) {
                return false;
            }
        }
        boolean bl3 = true;
        boolean bl4 = true;
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (this.isReturn != keystrokeEvent.isReturn) {
                return false;
            }
        }
        boolean bl5 = this.isSetCurrentText();
        boolean bl6 = keystrokeEvent.isSetCurrentText();
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (!this.currentText.equals(keystrokeEvent.currentText)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + this.keyCode;
        n = n * 8191 + (this.isReturn ? 131071 : 524287);
        n = n * 8191 + (this.isSetCurrentText() ? 131071 : 524287);
        if (this.isSetCurrentText()) {
            n = n * 8191 + this.currentText.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(KeystrokeEvent keystrokeEvent) {
        if (!this.getClass().equals(keystrokeEvent.getClass())) {
            return this.getClass().getName().compareTo(keystrokeEvent.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetKeyCode(), keystrokeEvent.isSetKeyCode());
        if (n != 0) {
            return n;
        }
        if (this.isSetKeyCode() && (n = TBaseHelper.compareTo((int)this.keyCode, (int)keystrokeEvent.keyCode)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetIsReturn(), keystrokeEvent.isSetIsReturn());
        if (n != 0) {
            return n;
        }
        if (this.isSetIsReturn() && (n = TBaseHelper.compareTo((boolean)this.isReturn, (boolean)keystrokeEvent.isReturn)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetCurrentText(), keystrokeEvent.isSetCurrentText());
        if (n != 0) {
            return n;
        }
        if (this.isSetCurrentText() && (n = TBaseHelper.compareTo((String)this.currentText, (String)keystrokeEvent.currentText)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        KeystrokeEvent.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        KeystrokeEvent.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("KeystrokeEvent(");
        boolean bl = true;
        stringBuilder.append("keyCode:");
        stringBuilder.append(this.keyCode);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("isReturn:");
        stringBuilder.append(this.isReturn);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("currentText:");
        if (this.currentText == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.currentText);
        }
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
        enumMap.put(_Fields.KEY_CODE, new FieldMetaData("keyCode", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.IS_RETURN, new FieldMetaData("isReturn", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.CURRENT_TEXT, new FieldMetaData("currentText", 3, new FieldValueMetaData(11)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(KeystrokeEvent.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        KEY_CODE(1, "keyCode"),
        IS_RETURN(2, "isReturn"),
        CURRENT_TEXT(3, "currentText");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return KEY_CODE;
                }
                case 2: {
                    return IS_RETURN;
                }
                case 3: {
                    return CURRENT_TEXT;
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

    private static class KeystrokeEventStandardSchemeFactory
    implements SchemeFactory {
        private KeystrokeEventStandardSchemeFactory() {
        }

        public KeystrokeEventStandardScheme getScheme() {
            return new KeystrokeEventStandardScheme();
        }
    }

    private static class KeystrokeEventTupleSchemeFactory
    implements SchemeFactory {
        private KeystrokeEventTupleSchemeFactory() {
        }

        public KeystrokeEventTupleScheme getScheme() {
            return new KeystrokeEventTupleScheme();
        }
    }

    private static class KeystrokeEventTupleScheme
    extends TupleScheme<KeystrokeEvent> {
        private KeystrokeEventTupleScheme() {
        }

        public void write(TProtocol tProtocol, KeystrokeEvent keystrokeEvent) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (keystrokeEvent.isSetKeyCode()) {
                bitSet.set(0);
            }
            if (keystrokeEvent.isSetIsReturn()) {
                bitSet.set(1);
            }
            if (keystrokeEvent.isSetCurrentText()) {
                bitSet.set(2);
            }
            tTupleProtocol.writeBitSet(bitSet, 3);
            if (keystrokeEvent.isSetKeyCode()) {
                tTupleProtocol.writeI32(keystrokeEvent.keyCode);
            }
            if (keystrokeEvent.isSetIsReturn()) {
                tTupleProtocol.writeBool(keystrokeEvent.isReturn);
            }
            if (keystrokeEvent.isSetCurrentText()) {
                tTupleProtocol.writeString(keystrokeEvent.currentText);
            }
        }

        public void read(TProtocol tProtocol, KeystrokeEvent keystrokeEvent) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(3);
            if (bitSet.get(0)) {
                keystrokeEvent.keyCode = tTupleProtocol.readI32();
                keystrokeEvent.setKeyCodeIsSet(true);
            }
            if (bitSet.get(1)) {
                keystrokeEvent.isReturn = tTupleProtocol.readBool();
                keystrokeEvent.setIsReturnIsSet(true);
            }
            if (bitSet.get(2)) {
                keystrokeEvent.currentText = tTupleProtocol.readString();
                keystrokeEvent.setCurrentTextIsSet(true);
            }
        }
    }

    private static class KeystrokeEventStandardScheme
    extends StandardScheme<KeystrokeEvent> {
        private KeystrokeEventStandardScheme() {
        }

        public void read(TProtocol tProtocol, KeystrokeEvent keystrokeEvent) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 8) {
                            keystrokeEvent.keyCode = tProtocol.readI32();
                            keystrokeEvent.setKeyCodeIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 2) {
                            keystrokeEvent.isReturn = tProtocol.readBool();
                            keystrokeEvent.setIsReturnIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 11) {
                            keystrokeEvent.currentText = tProtocol.readString();
                            keystrokeEvent.setCurrentTextIsSet(true);
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
            keystrokeEvent.validate();
        }

        public void write(TProtocol tProtocol, KeystrokeEvent keystrokeEvent) throws TException {
            keystrokeEvent.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            tProtocol.writeFieldBegin(KEY_CODE_FIELD_DESC);
            tProtocol.writeI32(keystrokeEvent.keyCode);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(IS_RETURN_FIELD_DESC);
            tProtocol.writeBool(keystrokeEvent.isReturn);
            tProtocol.writeFieldEnd();
            if (keystrokeEvent.currentText != null) {
                tProtocol.writeFieldBegin(CURRENT_TEXT_FIELD_DESC);
                tProtocol.writeString(keystrokeEvent.currentText);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

