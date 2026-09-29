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

import com.filemaker.jwpc.iwp.thrift.common.DateTime;
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

public class StringData
implements TBase<StringData, _Fields>,
Serializable,
Cloneable,
Comparable<StringData> {
    private static final TStruct STRUCT_DESC = new TStruct("StringData");
    private static final TField VALUE_FIELD_DESC = new TField("value", 11, 1);
    private static final TField NEGATIVE_NUMBER_FIELD_DESC = new TField("negativeNumber", 2, 2);
    private static final TField DATE_VALUE_FIELD_DESC = new TField("dateValue", 12, 3);
    private static final TField VALID_DATE_FIELD_DESC = new TField("validDate", 2, 4);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new StringDataStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new StringDataTupleSchemeFactory();
    @Nullable
    private String value;
    private boolean negativeNumber;
    @Nullable
    private DateTime dateValue;
    private boolean validDate;
    private static final int __NEGATIVENUMBER_ISSET_ID = 0;
    private static final int __VALIDDATE_ISSET_ID = 1;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public StringData() {
    }

    public StringData(String string, boolean bl, DateTime dateTime, boolean bl2) {
        this();
        this.value = string;
        this.negativeNumber = bl;
        this.setNegativeNumberIsSet(true);
        this.dateValue = dateTime;
        this.validDate = bl2;
        this.setValidDateIsSet(true);
    }

    public StringData(StringData stringData) {
        this.__isset_bitfield = stringData.__isset_bitfield;
        if (stringData.isSetValue()) {
            this.value = stringData.value;
        }
        this.negativeNumber = stringData.negativeNumber;
        if (stringData.isSetDateValue()) {
            this.dateValue = new DateTime(stringData.dateValue);
        }
        this.validDate = stringData.validDate;
    }

    public StringData deepCopy() {
        return new StringData(this);
    }

    public void clear() {
        this.value = null;
        this.setNegativeNumberIsSet(false);
        this.negativeNumber = false;
        this.dateValue = null;
        this.setValidDateIsSet(false);
        this.validDate = false;
    }

    @Nullable
    public String getValue() {
        return this.value;
    }

    public void setValue(@Nullable String string) {
        this.value = string;
    }

    public void unsetValue() {
        this.value = null;
    }

    public boolean isSetValue() {
        return this.value != null;
    }

    public void setValueIsSet(boolean bl) {
        if (!bl) {
            this.value = null;
        }
    }

    public boolean isNegativeNumber() {
        return this.negativeNumber;
    }

    public void setNegativeNumber(boolean bl) {
        this.negativeNumber = bl;
        this.setNegativeNumberIsSet(true);
    }

    public void unsetNegativeNumber() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetNegativeNumber() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setNegativeNumberIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    @Nullable
    public DateTime getDateValue() {
        return this.dateValue;
    }

    public void setDateValue(@Nullable DateTime dateTime) {
        this.dateValue = dateTime;
    }

    public void unsetDateValue() {
        this.dateValue = null;
    }

    public boolean isSetDateValue() {
        return this.dateValue != null;
    }

    public void setDateValueIsSet(boolean bl) {
        if (!bl) {
            this.dateValue = null;
        }
    }

    public boolean isValidDate() {
        return this.validDate;
    }

    public void setValidDate(boolean bl) {
        this.validDate = bl;
        this.setValidDateIsSet(true);
    }

    public void unsetValidDate() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)1);
    }

    public boolean isSetValidDate() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)1);
    }

    public void setValidDateIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)1, (boolean)bl);
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetValue();
                    break;
                }
                this.setValue((String)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetNegativeNumber();
                    break;
                }
                this.setNegativeNumber((Boolean)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetDateValue();
                    break;
                }
                this.setDateValue((DateTime)object);
                break;
            }
            case 3: {
                if (object == null) {
                    this.unsetValidDate();
                    break;
                }
                this.setValidDate((Boolean)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getValue();
            }
            case 1: {
                return this.isNegativeNumber();
            }
            case 2: {
                return this.getDateValue();
            }
            case 3: {
                return this.isValidDate();
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
                return this.isSetValue();
            }
            case 1: {
                return this.isSetNegativeNumber();
            }
            case 2: {
                return this.isSetDateValue();
            }
            case 3: {
                return this.isSetValidDate();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof StringData) {
            return this.equals((StringData)object);
        }
        return false;
    }

    public boolean equals(StringData stringData) {
        if (stringData == null) {
            return false;
        }
        if (this == stringData) {
            return true;
        }
        boolean bl = this.isSetValue();
        boolean bl2 = stringData.isSetValue();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.value.equals(stringData.value)) {
                return false;
            }
        }
        boolean bl3 = true;
        boolean bl4 = true;
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (this.negativeNumber != stringData.negativeNumber) {
                return false;
            }
        }
        boolean bl5 = this.isSetDateValue();
        boolean bl6 = stringData.isSetDateValue();
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (!this.dateValue.equals(stringData.dateValue)) {
                return false;
            }
        }
        boolean bl7 = true;
        boolean bl8 = true;
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (this.validDate != stringData.validDate) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetValue() ? 131071 : 524287);
        if (this.isSetValue()) {
            n = n * 8191 + this.value.hashCode();
        }
        n = n * 8191 + (this.negativeNumber ? 131071 : 524287);
        n = n * 8191 + (this.isSetDateValue() ? 131071 : 524287);
        if (this.isSetDateValue()) {
            n = n * 8191 + this.dateValue.hashCode();
        }
        n = n * 8191 + (this.validDate ? 131071 : 524287);
        return n;
    }

    @Override
    public int compareTo(StringData stringData) {
        if (!this.getClass().equals(stringData.getClass())) {
            return this.getClass().getName().compareTo(stringData.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetValue(), stringData.isSetValue());
        if (n != 0) {
            return n;
        }
        if (this.isSetValue() && (n = TBaseHelper.compareTo((String)this.value, (String)stringData.value)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetNegativeNumber(), stringData.isSetNegativeNumber());
        if (n != 0) {
            return n;
        }
        if (this.isSetNegativeNumber() && (n = TBaseHelper.compareTo((boolean)this.negativeNumber, (boolean)stringData.negativeNumber)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetDateValue(), stringData.isSetDateValue());
        if (n != 0) {
            return n;
        }
        if (this.isSetDateValue() && (n = TBaseHelper.compareTo((Comparable)this.dateValue, (Comparable)stringData.dateValue)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetValidDate(), stringData.isSetValidDate());
        if (n != 0) {
            return n;
        }
        if (this.isSetValidDate() && (n = TBaseHelper.compareTo((boolean)this.validDate, (boolean)stringData.validDate)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        StringData.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        StringData.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("StringData(");
        boolean bl = true;
        stringBuilder.append("value:");
        if (this.value == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.value);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("negativeNumber:");
        stringBuilder.append(this.negativeNumber);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("dateValue:");
        if (this.dateValue == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.dateValue);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("validDate:");
        stringBuilder.append(this.validDate);
        bl = false;
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void validate() throws TException {
        if (this.dateValue != null) {
            this.dateValue.validate();
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
        enumMap.put(_Fields.VALUE, new FieldMetaData("value", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.NEGATIVE_NUMBER, new FieldMetaData("negativeNumber", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.DATE_VALUE, new FieldMetaData("dateValue", 3, (FieldValueMetaData)new StructMetaData(12, DateTime.class)));
        enumMap.put(_Fields.VALID_DATE, new FieldMetaData("validDate", 3, new FieldValueMetaData(2)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(StringData.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        VALUE(1, "value"),
        NEGATIVE_NUMBER(2, "negativeNumber"),
        DATE_VALUE(3, "dateValue"),
        VALID_DATE(4, "validDate");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return VALUE;
                }
                case 2: {
                    return NEGATIVE_NUMBER;
                }
                case 3: {
                    return DATE_VALUE;
                }
                case 4: {
                    return VALID_DATE;
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

    private static class StringDataStandardSchemeFactory
    implements SchemeFactory {
        private StringDataStandardSchemeFactory() {
        }

        public StringDataStandardScheme getScheme() {
            return new StringDataStandardScheme();
        }
    }

    private static class StringDataTupleSchemeFactory
    implements SchemeFactory {
        private StringDataTupleSchemeFactory() {
        }

        public StringDataTupleScheme getScheme() {
            return new StringDataTupleScheme();
        }
    }

    private static class StringDataTupleScheme
    extends TupleScheme<StringData> {
        private StringDataTupleScheme() {
        }

        public void write(TProtocol tProtocol, StringData stringData) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (stringData.isSetValue()) {
                bitSet.set(0);
            }
            if (stringData.isSetNegativeNumber()) {
                bitSet.set(1);
            }
            if (stringData.isSetDateValue()) {
                bitSet.set(2);
            }
            if (stringData.isSetValidDate()) {
                bitSet.set(3);
            }
            tTupleProtocol.writeBitSet(bitSet, 4);
            if (stringData.isSetValue()) {
                tTupleProtocol.writeString(stringData.value);
            }
            if (stringData.isSetNegativeNumber()) {
                tTupleProtocol.writeBool(stringData.negativeNumber);
            }
            if (stringData.isSetDateValue()) {
                stringData.dateValue.write((TProtocol)tTupleProtocol);
            }
            if (stringData.isSetValidDate()) {
                tTupleProtocol.writeBool(stringData.validDate);
            }
        }

        public void read(TProtocol tProtocol, StringData stringData) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(4);
            if (bitSet.get(0)) {
                stringData.value = tTupleProtocol.readString();
                stringData.setValueIsSet(true);
            }
            if (bitSet.get(1)) {
                stringData.negativeNumber = tTupleProtocol.readBool();
                stringData.setNegativeNumberIsSet(true);
            }
            if (bitSet.get(2)) {
                stringData.dateValue = new DateTime();
                stringData.dateValue.read((TProtocol)tTupleProtocol);
                stringData.setDateValueIsSet(true);
            }
            if (bitSet.get(3)) {
                stringData.validDate = tTupleProtocol.readBool();
                stringData.setValidDateIsSet(true);
            }
        }
    }

    private static class StringDataStandardScheme
    extends StandardScheme<StringData> {
        private StringDataStandardScheme() {
        }

        public void read(TProtocol tProtocol, StringData stringData) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 11) {
                            stringData.value = tProtocol.readString();
                            stringData.setValueIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 2) {
                            stringData.negativeNumber = tProtocol.readBool();
                            stringData.setNegativeNumberIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 12) {
                            stringData.dateValue = new DateTime();
                            stringData.dateValue.read(tProtocol);
                            stringData.setDateValueIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 2) {
                            stringData.validDate = tProtocol.readBool();
                            stringData.setValidDateIsSet(true);
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
            stringData.validate();
        }

        public void write(TProtocol tProtocol, StringData stringData) throws TException {
            stringData.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (stringData.value != null) {
                tProtocol.writeFieldBegin(VALUE_FIELD_DESC);
                tProtocol.writeString(stringData.value);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(NEGATIVE_NUMBER_FIELD_DESC);
            tProtocol.writeBool(stringData.negativeNumber);
            tProtocol.writeFieldEnd();
            if (stringData.dateValue != null) {
                tProtocol.writeFieldBegin(DATE_VALUE_FIELD_DESC);
                stringData.dateValue.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(VALID_DATE_FIELD_DESC);
            tProtocol.writeBool(stringData.validDate);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

