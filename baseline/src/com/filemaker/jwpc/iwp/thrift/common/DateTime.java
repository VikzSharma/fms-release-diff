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

public class DateTime
implements TBase<DateTime, _Fields>,
Serializable,
Cloneable,
Comparable<DateTime> {
    private static final TStruct STRUCT_DESC = new TStruct("DateTime");
    private static final TField MONTH_FIELD_DESC = new TField("month", 8, 1);
    private static final TField DAY_FIELD_DESC = new TField("day", 8, 2);
    private static final TField YEAR_FIELD_DESC = new TField("year", 8, 3);
    private static final TField HOURS_FIELD_DESC = new TField("hours", 8, 4);
    private static final TField MINUTES_FIELD_DESC = new TField("minutes", 8, 5);
    private static final TField SECONDS_FIELD_DESC = new TField("seconds", 8, 6);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new DateTimeStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new DateTimeTupleSchemeFactory();
    private int month;
    private int day;
    private int year;
    private int hours;
    private int minutes;
    private int seconds;
    private static final int __MONTH_ISSET_ID = 0;
    private static final int __DAY_ISSET_ID = 1;
    private static final int __YEAR_ISSET_ID = 2;
    private static final int __HOURS_ISSET_ID = 3;
    private static final int __MINUTES_ISSET_ID = 4;
    private static final int __SECONDS_ISSET_ID = 5;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public DateTime() {
    }

    public DateTime(int n, int n2, int n3, int n4, int n5, int n6) {
        this();
        this.month = n;
        this.setMonthIsSet(true);
        this.day = n2;
        this.setDayIsSet(true);
        this.year = n3;
        this.setYearIsSet(true);
        this.hours = n4;
        this.setHoursIsSet(true);
        this.minutes = n5;
        this.setMinutesIsSet(true);
        this.seconds = n6;
        this.setSecondsIsSet(true);
    }

    public DateTime(DateTime dateTime) {
        this.__isset_bitfield = dateTime.__isset_bitfield;
        this.month = dateTime.month;
        this.day = dateTime.day;
        this.year = dateTime.year;
        this.hours = dateTime.hours;
        this.minutes = dateTime.minutes;
        this.seconds = dateTime.seconds;
    }

    public DateTime deepCopy() {
        return new DateTime(this);
    }

    public void clear() {
        this.setMonthIsSet(false);
        this.month = 0;
        this.setDayIsSet(false);
        this.day = 0;
        this.setYearIsSet(false);
        this.year = 0;
        this.setHoursIsSet(false);
        this.hours = 0;
        this.setMinutesIsSet(false);
        this.minutes = 0;
        this.setSecondsIsSet(false);
        this.seconds = 0;
    }

    public int getMonth() {
        return this.month;
    }

    public void setMonth(int n) {
        this.month = n;
        this.setMonthIsSet(true);
    }

    public void unsetMonth() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetMonth() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setMonthIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public int getDay() {
        return this.day;
    }

    public void setDay(int n) {
        this.day = n;
        this.setDayIsSet(true);
    }

    public void unsetDay() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)1);
    }

    public boolean isSetDay() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)1);
    }

    public void setDayIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)1, (boolean)bl);
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int n) {
        this.year = n;
        this.setYearIsSet(true);
    }

    public void unsetYear() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)2);
    }

    public boolean isSetYear() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)2);
    }

    public void setYearIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)2, (boolean)bl);
    }

    public int getHours() {
        return this.hours;
    }

    public void setHours(int n) {
        this.hours = n;
        this.setHoursIsSet(true);
    }

    public void unsetHours() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)3);
    }

    public boolean isSetHours() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)3);
    }

    public void setHoursIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)3, (boolean)bl);
    }

    public int getMinutes() {
        return this.minutes;
    }

    public void setMinutes(int n) {
        this.minutes = n;
        this.setMinutesIsSet(true);
    }

    public void unsetMinutes() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)4);
    }

    public boolean isSetMinutes() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)4);
    }

    public void setMinutesIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)4, (boolean)bl);
    }

    public int getSeconds() {
        return this.seconds;
    }

    public void setSeconds(int n) {
        this.seconds = n;
        this.setSecondsIsSet(true);
    }

    public void unsetSeconds() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)5);
    }

    public boolean isSetSeconds() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)5);
    }

    public void setSecondsIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)5, (boolean)bl);
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetMonth();
                    break;
                }
                this.setMonth((Integer)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetDay();
                    break;
                }
                this.setDay((Integer)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetYear();
                    break;
                }
                this.setYear((Integer)object);
                break;
            }
            case 3: {
                if (object == null) {
                    this.unsetHours();
                    break;
                }
                this.setHours((Integer)object);
                break;
            }
            case 4: {
                if (object == null) {
                    this.unsetMinutes();
                    break;
                }
                this.setMinutes((Integer)object);
                break;
            }
            case 5: {
                if (object == null) {
                    this.unsetSeconds();
                    break;
                }
                this.setSeconds((Integer)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getMonth();
            }
            case 1: {
                return this.getDay();
            }
            case 2: {
                return this.getYear();
            }
            case 3: {
                return this.getHours();
            }
            case 4: {
                return this.getMinutes();
            }
            case 5: {
                return this.getSeconds();
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
                return this.isSetMonth();
            }
            case 1: {
                return this.isSetDay();
            }
            case 2: {
                return this.isSetYear();
            }
            case 3: {
                return this.isSetHours();
            }
            case 4: {
                return this.isSetMinutes();
            }
            case 5: {
                return this.isSetSeconds();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof DateTime) {
            return this.equals((DateTime)object);
        }
        return false;
    }

    public boolean equals(DateTime dateTime) {
        if (dateTime == null) {
            return false;
        }
        if (this == dateTime) {
            return true;
        }
        boolean bl = true;
        boolean bl2 = true;
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (this.month != dateTime.month) {
                return false;
            }
        }
        boolean bl3 = true;
        boolean bl4 = true;
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (this.day != dateTime.day) {
                return false;
            }
        }
        boolean bl5 = true;
        boolean bl6 = true;
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (this.year != dateTime.year) {
                return false;
            }
        }
        boolean bl7 = true;
        boolean bl8 = true;
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (this.hours != dateTime.hours) {
                return false;
            }
        }
        boolean bl9 = true;
        boolean bl10 = true;
        if (bl9 || bl10) {
            if (!bl9 || !bl10) {
                return false;
            }
            if (this.minutes != dateTime.minutes) {
                return false;
            }
        }
        boolean bl11 = true;
        boolean bl12 = true;
        if (bl11 || bl12) {
            if (!bl11 || !bl12) {
                return false;
            }
            if (this.seconds != dateTime.seconds) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + this.month;
        n = n * 8191 + this.day;
        n = n * 8191 + this.year;
        n = n * 8191 + this.hours;
        n = n * 8191 + this.minutes;
        n = n * 8191 + this.seconds;
        return n;
    }

    @Override
    public int compareTo(DateTime dateTime) {
        if (!this.getClass().equals(dateTime.getClass())) {
            return this.getClass().getName().compareTo(dateTime.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetMonth(), dateTime.isSetMonth());
        if (n != 0) {
            return n;
        }
        if (this.isSetMonth() && (n = TBaseHelper.compareTo((int)this.month, (int)dateTime.month)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetDay(), dateTime.isSetDay());
        if (n != 0) {
            return n;
        }
        if (this.isSetDay() && (n = TBaseHelper.compareTo((int)this.day, (int)dateTime.day)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetYear(), dateTime.isSetYear());
        if (n != 0) {
            return n;
        }
        if (this.isSetYear() && (n = TBaseHelper.compareTo((int)this.year, (int)dateTime.year)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetHours(), dateTime.isSetHours());
        if (n != 0) {
            return n;
        }
        if (this.isSetHours() && (n = TBaseHelper.compareTo((int)this.hours, (int)dateTime.hours)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetMinutes(), dateTime.isSetMinutes());
        if (n != 0) {
            return n;
        }
        if (this.isSetMinutes() && (n = TBaseHelper.compareTo((int)this.minutes, (int)dateTime.minutes)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetSeconds(), dateTime.isSetSeconds());
        if (n != 0) {
            return n;
        }
        if (this.isSetSeconds() && (n = TBaseHelper.compareTo((int)this.seconds, (int)dateTime.seconds)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        DateTime.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        DateTime.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("DateTime(");
        boolean bl = true;
        stringBuilder.append("month:");
        stringBuilder.append(this.month);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("day:");
        stringBuilder.append(this.day);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("year:");
        stringBuilder.append(this.year);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("hours:");
        stringBuilder.append(this.hours);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("minutes:");
        stringBuilder.append(this.minutes);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("seconds:");
        stringBuilder.append(this.seconds);
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
        enumMap.put(_Fields.MONTH, new FieldMetaData("month", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.DAY, new FieldMetaData("day", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.YEAR, new FieldMetaData("year", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.HOURS, new FieldMetaData("hours", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.MINUTES, new FieldMetaData("minutes", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.SECONDS, new FieldMetaData("seconds", 3, new FieldValueMetaData(8)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(DateTime.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        MONTH(1, "month"),
        DAY(2, "day"),
        YEAR(3, "year"),
        HOURS(4, "hours"),
        MINUTES(5, "minutes"),
        SECONDS(6, "seconds");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return MONTH;
                }
                case 2: {
                    return DAY;
                }
                case 3: {
                    return YEAR;
                }
                case 4: {
                    return HOURS;
                }
                case 5: {
                    return MINUTES;
                }
                case 6: {
                    return SECONDS;
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

    private static class DateTimeStandardSchemeFactory
    implements SchemeFactory {
        private DateTimeStandardSchemeFactory() {
        }

        public DateTimeStandardScheme getScheme() {
            return new DateTimeStandardScheme();
        }
    }

    private static class DateTimeTupleSchemeFactory
    implements SchemeFactory {
        private DateTimeTupleSchemeFactory() {
        }

        public DateTimeTupleScheme getScheme() {
            return new DateTimeTupleScheme();
        }
    }

    private static class DateTimeTupleScheme
    extends TupleScheme<DateTime> {
        private DateTimeTupleScheme() {
        }

        public void write(TProtocol tProtocol, DateTime dateTime) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (dateTime.isSetMonth()) {
                bitSet.set(0);
            }
            if (dateTime.isSetDay()) {
                bitSet.set(1);
            }
            if (dateTime.isSetYear()) {
                bitSet.set(2);
            }
            if (dateTime.isSetHours()) {
                bitSet.set(3);
            }
            if (dateTime.isSetMinutes()) {
                bitSet.set(4);
            }
            if (dateTime.isSetSeconds()) {
                bitSet.set(5);
            }
            tTupleProtocol.writeBitSet(bitSet, 6);
            if (dateTime.isSetMonth()) {
                tTupleProtocol.writeI32(dateTime.month);
            }
            if (dateTime.isSetDay()) {
                tTupleProtocol.writeI32(dateTime.day);
            }
            if (dateTime.isSetYear()) {
                tTupleProtocol.writeI32(dateTime.year);
            }
            if (dateTime.isSetHours()) {
                tTupleProtocol.writeI32(dateTime.hours);
            }
            if (dateTime.isSetMinutes()) {
                tTupleProtocol.writeI32(dateTime.minutes);
            }
            if (dateTime.isSetSeconds()) {
                tTupleProtocol.writeI32(dateTime.seconds);
            }
        }

        public void read(TProtocol tProtocol, DateTime dateTime) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(6);
            if (bitSet.get(0)) {
                dateTime.month = tTupleProtocol.readI32();
                dateTime.setMonthIsSet(true);
            }
            if (bitSet.get(1)) {
                dateTime.day = tTupleProtocol.readI32();
                dateTime.setDayIsSet(true);
            }
            if (bitSet.get(2)) {
                dateTime.year = tTupleProtocol.readI32();
                dateTime.setYearIsSet(true);
            }
            if (bitSet.get(3)) {
                dateTime.hours = tTupleProtocol.readI32();
                dateTime.setHoursIsSet(true);
            }
            if (bitSet.get(4)) {
                dateTime.minutes = tTupleProtocol.readI32();
                dateTime.setMinutesIsSet(true);
            }
            if (bitSet.get(5)) {
                dateTime.seconds = tTupleProtocol.readI32();
                dateTime.setSecondsIsSet(true);
            }
        }
    }

    private static class DateTimeStandardScheme
    extends StandardScheme<DateTime> {
        private DateTimeStandardScheme() {
        }

        public void read(TProtocol tProtocol, DateTime dateTime) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 8) {
                            dateTime.month = tProtocol.readI32();
                            dateTime.setMonthIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 8) {
                            dateTime.day = tProtocol.readI32();
                            dateTime.setDayIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 8) {
                            dateTime.year = tProtocol.readI32();
                            dateTime.setYearIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 8) {
                            dateTime.hours = tProtocol.readI32();
                            dateTime.setHoursIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 5: {
                        if (tField.type == 8) {
                            dateTime.minutes = tProtocol.readI32();
                            dateTime.setMinutesIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 6: {
                        if (tField.type == 8) {
                            dateTime.seconds = tProtocol.readI32();
                            dateTime.setSecondsIsSet(true);
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
            dateTime.validate();
        }

        public void write(TProtocol tProtocol, DateTime dateTime) throws TException {
            dateTime.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            tProtocol.writeFieldBegin(MONTH_FIELD_DESC);
            tProtocol.writeI32(dateTime.month);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(DAY_FIELD_DESC);
            tProtocol.writeI32(dateTime.day);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(YEAR_FIELD_DESC);
            tProtocol.writeI32(dateTime.year);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(HOURS_FIELD_DESC);
            tProtocol.writeI32(dateTime.hours);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(MINUTES_FIELD_DESC);
            tProtocol.writeI32(dateTime.minutes);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(SECONDS_FIELD_DESC);
            tProtocol.writeI32(dateTime.seconds);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

