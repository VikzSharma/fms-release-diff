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
 *  org.apache.thrift.meta_data.ListMetaData
 *  org.apache.thrift.meta_data.StructMetaData
 *  org.apache.thrift.protocol.TCompactProtocol
 *  org.apache.thrift.protocol.TField
 *  org.apache.thrift.protocol.TList
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

import com.filemaker.jwpc.iwp.thrift.common.ValueListEntry;
import com.filemaker.jwpc.iwp.thrift.common.ValueListType;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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
import org.apache.thrift.meta_data.ListMetaData;
import org.apache.thrift.meta_data.StructMetaData;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TList;
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

public class ValueListData
implements TBase<ValueListData, _Fields>,
Serializable,
Cloneable,
Comparable<ValueListData> {
    private static final TStruct STRUCT_DESC = new TStruct("ValueListData");
    private static final TField DISPLAY_TYPE_FIELD_DESC = new TField("displayType", 8, 1);
    private static final TField SEPARATOR_FIELD_DESC = new TField("separator", 11, 2);
    private static final TField HAS_MORE_VALUES_FIELD_DESC = new TField("hasMoreValues", 2, 3);
    private static final TField CUSTOM_LIST_FIELD_DESC = new TField("customList", 2, 4);
    private static final TField VALUES_FIELD_DESC = new TField("values", 15, 5);
    private static final TField VALID_DATA_FIELD_DESC = new TField("validData", 2, 6);
    private static final TField ERROR_STRING_FIELD_DESC = new TField("errorString", 11, 7);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new ValueListDataStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new ValueListDataTupleSchemeFactory();
    @Nullable
    private ValueListType displayType;
    @Nullable
    private String separator;
    private boolean hasMoreValues;
    private boolean customList;
    @Nullable
    private List<ValueListEntry> values;
    private boolean validData;
    @Nullable
    private String errorString;
    private static final int __HASMOREVALUES_ISSET_ID = 0;
    private static final int __CUSTOMLIST_ISSET_ID = 1;
    private static final int __VALIDDATA_ISSET_ID = 2;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public ValueListData() {
    }

    public ValueListData(ValueListType valueListType, String string, boolean bl, boolean bl2, List<ValueListEntry> list, boolean bl3, String string2) {
        this();
        this.displayType = valueListType;
        this.separator = string;
        this.hasMoreValues = bl;
        this.setHasMoreValuesIsSet(true);
        this.customList = bl2;
        this.setCustomListIsSet(true);
        this.values = list;
        this.validData = bl3;
        this.setValidDataIsSet(true);
        this.errorString = string2;
    }

    public ValueListData(ValueListData valueListData) {
        this.__isset_bitfield = valueListData.__isset_bitfield;
        if (valueListData.isSetDisplayType()) {
            this.displayType = valueListData.displayType;
        }
        if (valueListData.isSetSeparator()) {
            this.separator = valueListData.separator;
        }
        this.hasMoreValues = valueListData.hasMoreValues;
        this.customList = valueListData.customList;
        if (valueListData.isSetValues()) {
            ArrayList<ValueListEntry> arrayList = new ArrayList<ValueListEntry>(valueListData.values.size());
            for (ValueListEntry valueListEntry : valueListData.values) {
                arrayList.add(new ValueListEntry(valueListEntry));
            }
            this.values = arrayList;
        }
        this.validData = valueListData.validData;
        if (valueListData.isSetErrorString()) {
            this.errorString = valueListData.errorString;
        }
    }

    public ValueListData deepCopy() {
        return new ValueListData(this);
    }

    public void clear() {
        this.displayType = null;
        this.separator = null;
        this.setHasMoreValuesIsSet(false);
        this.hasMoreValues = false;
        this.setCustomListIsSet(false);
        this.customList = false;
        this.values = null;
        this.setValidDataIsSet(false);
        this.validData = false;
        this.errorString = null;
    }

    @Nullable
    public ValueListType getDisplayType() {
        return this.displayType;
    }

    public void setDisplayType(@Nullable ValueListType valueListType) {
        this.displayType = valueListType;
    }

    public void unsetDisplayType() {
        this.displayType = null;
    }

    public boolean isSetDisplayType() {
        return this.displayType != null;
    }

    public void setDisplayTypeIsSet(boolean bl) {
        if (!bl) {
            this.displayType = null;
        }
    }

    @Nullable
    public String getSeparator() {
        return this.separator;
    }

    public void setSeparator(@Nullable String string) {
        this.separator = string;
    }

    public void unsetSeparator() {
        this.separator = null;
    }

    public boolean isSetSeparator() {
        return this.separator != null;
    }

    public void setSeparatorIsSet(boolean bl) {
        if (!bl) {
            this.separator = null;
        }
    }

    public boolean isHasMoreValues() {
        return this.hasMoreValues;
    }

    public void setHasMoreValues(boolean bl) {
        this.hasMoreValues = bl;
        this.setHasMoreValuesIsSet(true);
    }

    public void unsetHasMoreValues() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetHasMoreValues() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setHasMoreValuesIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public boolean isCustomList() {
        return this.customList;
    }

    public void setCustomList(boolean bl) {
        this.customList = bl;
        this.setCustomListIsSet(true);
    }

    public void unsetCustomList() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)1);
    }

    public boolean isSetCustomList() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)1);
    }

    public void setCustomListIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)1, (boolean)bl);
    }

    public int getValuesSize() {
        return this.values == null ? 0 : this.values.size();
    }

    @Nullable
    public Iterator<ValueListEntry> getValuesIterator() {
        return this.values == null ? null : this.values.iterator();
    }

    public void addToValues(ValueListEntry valueListEntry) {
        if (this.values == null) {
            this.values = new ArrayList<ValueListEntry>();
        }
        this.values.add(valueListEntry);
    }

    @Nullable
    public List<ValueListEntry> getValues() {
        return this.values;
    }

    public void setValues(@Nullable List<ValueListEntry> list) {
        this.values = list;
    }

    public void unsetValues() {
        this.values = null;
    }

    public boolean isSetValues() {
        return this.values != null;
    }

    public void setValuesIsSet(boolean bl) {
        if (!bl) {
            this.values = null;
        }
    }

    public boolean isValidData() {
        return this.validData;
    }

    public void setValidData(boolean bl) {
        this.validData = bl;
        this.setValidDataIsSet(true);
    }

    public void unsetValidData() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)2);
    }

    public boolean isSetValidData() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)2);
    }

    public void setValidDataIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)2, (boolean)bl);
    }

    @Nullable
    public String getErrorString() {
        return this.errorString;
    }

    public void setErrorString(@Nullable String string) {
        this.errorString = string;
    }

    public void unsetErrorString() {
        this.errorString = null;
    }

    public boolean isSetErrorString() {
        return this.errorString != null;
    }

    public void setErrorStringIsSet(boolean bl) {
        if (!bl) {
            this.errorString = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetDisplayType();
                    break;
                }
                this.setDisplayType((ValueListType)((Object)object));
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetSeparator();
                    break;
                }
                this.setSeparator((String)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetHasMoreValues();
                    break;
                }
                this.setHasMoreValues((Boolean)object);
                break;
            }
            case 3: {
                if (object == null) {
                    this.unsetCustomList();
                    break;
                }
                this.setCustomList((Boolean)object);
                break;
            }
            case 4: {
                if (object == null) {
                    this.unsetValues();
                    break;
                }
                this.setValues((List)object);
                break;
            }
            case 5: {
                if (object == null) {
                    this.unsetValidData();
                    break;
                }
                this.setValidData((Boolean)object);
                break;
            }
            case 6: {
                if (object == null) {
                    this.unsetErrorString();
                    break;
                }
                this.setErrorString((String)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getDisplayType();
            }
            case 1: {
                return this.getSeparator();
            }
            case 2: {
                return this.isHasMoreValues();
            }
            case 3: {
                return this.isCustomList();
            }
            case 4: {
                return this.getValues();
            }
            case 5: {
                return this.isValidData();
            }
            case 6: {
                return this.getErrorString();
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
                return this.isSetDisplayType();
            }
            case 1: {
                return this.isSetSeparator();
            }
            case 2: {
                return this.isSetHasMoreValues();
            }
            case 3: {
                return this.isSetCustomList();
            }
            case 4: {
                return this.isSetValues();
            }
            case 5: {
                return this.isSetValidData();
            }
            case 6: {
                return this.isSetErrorString();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof ValueListData) {
            return this.equals((ValueListData)object);
        }
        return false;
    }

    public boolean equals(ValueListData valueListData) {
        if (valueListData == null) {
            return false;
        }
        if (this == valueListData) {
            return true;
        }
        boolean bl = this.isSetDisplayType();
        boolean bl2 = valueListData.isSetDisplayType();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.displayType.equals((Object)valueListData.displayType)) {
                return false;
            }
        }
        boolean bl3 = this.isSetSeparator();
        boolean bl4 = valueListData.isSetSeparator();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.separator.equals(valueListData.separator)) {
                return false;
            }
        }
        boolean bl5 = true;
        boolean bl6 = true;
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (this.hasMoreValues != valueListData.hasMoreValues) {
                return false;
            }
        }
        boolean bl7 = true;
        boolean bl8 = true;
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (this.customList != valueListData.customList) {
                return false;
            }
        }
        boolean bl9 = this.isSetValues();
        boolean bl10 = valueListData.isSetValues();
        if (bl9 || bl10) {
            if (!bl9 || !bl10) {
                return false;
            }
            if (!this.values.equals(valueListData.values)) {
                return false;
            }
        }
        boolean bl11 = true;
        boolean bl12 = true;
        if (bl11 || bl12) {
            if (!bl11 || !bl12) {
                return false;
            }
            if (this.validData != valueListData.validData) {
                return false;
            }
        }
        boolean bl13 = this.isSetErrorString();
        boolean bl14 = valueListData.isSetErrorString();
        if (bl13 || bl14) {
            if (!bl13 || !bl14) {
                return false;
            }
            if (!this.errorString.equals(valueListData.errorString)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetDisplayType() ? 131071 : 524287);
        if (this.isSetDisplayType()) {
            n = n * 8191 + this.displayType.getValue();
        }
        n = n * 8191 + (this.isSetSeparator() ? 131071 : 524287);
        if (this.isSetSeparator()) {
            n = n * 8191 + this.separator.hashCode();
        }
        n = n * 8191 + (this.hasMoreValues ? 131071 : 524287);
        n = n * 8191 + (this.customList ? 131071 : 524287);
        n = n * 8191 + (this.isSetValues() ? 131071 : 524287);
        if (this.isSetValues()) {
            n = n * 8191 + this.values.hashCode();
        }
        n = n * 8191 + (this.validData ? 131071 : 524287);
        n = n * 8191 + (this.isSetErrorString() ? 131071 : 524287);
        if (this.isSetErrorString()) {
            n = n * 8191 + this.errorString.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(ValueListData valueListData) {
        if (!this.getClass().equals(valueListData.getClass())) {
            return this.getClass().getName().compareTo(valueListData.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetDisplayType(), valueListData.isSetDisplayType());
        if (n != 0) {
            return n;
        }
        if (this.isSetDisplayType() && (n = TBaseHelper.compareTo((Comparable)((Object)this.displayType), (Comparable)((Object)valueListData.displayType))) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetSeparator(), valueListData.isSetSeparator());
        if (n != 0) {
            return n;
        }
        if (this.isSetSeparator() && (n = TBaseHelper.compareTo((String)this.separator, (String)valueListData.separator)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetHasMoreValues(), valueListData.isSetHasMoreValues());
        if (n != 0) {
            return n;
        }
        if (this.isSetHasMoreValues() && (n = TBaseHelper.compareTo((boolean)this.hasMoreValues, (boolean)valueListData.hasMoreValues)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetCustomList(), valueListData.isSetCustomList());
        if (n != 0) {
            return n;
        }
        if (this.isSetCustomList() && (n = TBaseHelper.compareTo((boolean)this.customList, (boolean)valueListData.customList)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetValues(), valueListData.isSetValues());
        if (n != 0) {
            return n;
        }
        if (this.isSetValues() && (n = TBaseHelper.compareTo(this.values, valueListData.values)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetValidData(), valueListData.isSetValidData());
        if (n != 0) {
            return n;
        }
        if (this.isSetValidData() && (n = TBaseHelper.compareTo((boolean)this.validData, (boolean)valueListData.validData)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetErrorString(), valueListData.isSetErrorString());
        if (n != 0) {
            return n;
        }
        if (this.isSetErrorString() && (n = TBaseHelper.compareTo((String)this.errorString, (String)valueListData.errorString)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        ValueListData.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        ValueListData.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ValueListData(");
        boolean bl = true;
        stringBuilder.append("displayType:");
        if (this.displayType == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append((Object)this.displayType);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("separator:");
        if (this.separator == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.separator);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("hasMoreValues:");
        stringBuilder.append(this.hasMoreValues);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("customList:");
        stringBuilder.append(this.customList);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("values:");
        if (this.values == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.values);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("validData:");
        stringBuilder.append(this.validData);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("errorString:");
        if (this.errorString == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.errorString);
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
        enumMap.put(_Fields.DISPLAY_TYPE, new FieldMetaData("displayType", 3, (FieldValueMetaData)new EnumMetaData(-1, ValueListType.class)));
        enumMap.put(_Fields.SEPARATOR, new FieldMetaData("separator", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.HAS_MORE_VALUES, new FieldMetaData("hasMoreValues", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.CUSTOM_LIST, new FieldMetaData("customList", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.VALUES, new FieldMetaData("values", 3, (FieldValueMetaData)new ListMetaData(15, (FieldValueMetaData)new StructMetaData(12, ValueListEntry.class))));
        enumMap.put(_Fields.VALID_DATA, new FieldMetaData("validData", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.ERROR_STRING, new FieldMetaData("errorString", 3, new FieldValueMetaData(11)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(ValueListData.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        DISPLAY_TYPE(1, "displayType"),
        SEPARATOR(2, "separator"),
        HAS_MORE_VALUES(3, "hasMoreValues"),
        CUSTOM_LIST(4, "customList"),
        VALUES(5, "values"),
        VALID_DATA(6, "validData"),
        ERROR_STRING(7, "errorString");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return DISPLAY_TYPE;
                }
                case 2: {
                    return SEPARATOR;
                }
                case 3: {
                    return HAS_MORE_VALUES;
                }
                case 4: {
                    return CUSTOM_LIST;
                }
                case 5: {
                    return VALUES;
                }
                case 6: {
                    return VALID_DATA;
                }
                case 7: {
                    return ERROR_STRING;
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

    private static class ValueListDataStandardSchemeFactory
    implements SchemeFactory {
        private ValueListDataStandardSchemeFactory() {
        }

        public ValueListDataStandardScheme getScheme() {
            return new ValueListDataStandardScheme();
        }
    }

    private static class ValueListDataTupleSchemeFactory
    implements SchemeFactory {
        private ValueListDataTupleSchemeFactory() {
        }

        public ValueListDataTupleScheme getScheme() {
            return new ValueListDataTupleScheme();
        }
    }

    private static class ValueListDataTupleScheme
    extends TupleScheme<ValueListData> {
        private ValueListDataTupleScheme() {
        }

        public void write(TProtocol tProtocol, ValueListData valueListData) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (valueListData.isSetDisplayType()) {
                bitSet.set(0);
            }
            if (valueListData.isSetSeparator()) {
                bitSet.set(1);
            }
            if (valueListData.isSetHasMoreValues()) {
                bitSet.set(2);
            }
            if (valueListData.isSetCustomList()) {
                bitSet.set(3);
            }
            if (valueListData.isSetValues()) {
                bitSet.set(4);
            }
            if (valueListData.isSetValidData()) {
                bitSet.set(5);
            }
            if (valueListData.isSetErrorString()) {
                bitSet.set(6);
            }
            tTupleProtocol.writeBitSet(bitSet, 7);
            if (valueListData.isSetDisplayType()) {
                tTupleProtocol.writeI32(valueListData.displayType.getValue());
            }
            if (valueListData.isSetSeparator()) {
                tTupleProtocol.writeString(valueListData.separator);
            }
            if (valueListData.isSetHasMoreValues()) {
                tTupleProtocol.writeBool(valueListData.hasMoreValues);
            }
            if (valueListData.isSetCustomList()) {
                tTupleProtocol.writeBool(valueListData.customList);
            }
            if (valueListData.isSetValues()) {
                tTupleProtocol.writeI32(valueListData.values.size());
                for (ValueListEntry valueListEntry : valueListData.values) {
                    valueListEntry.write((TProtocol)tTupleProtocol);
                }
            }
            if (valueListData.isSetValidData()) {
                tTupleProtocol.writeBool(valueListData.validData);
            }
            if (valueListData.isSetErrorString()) {
                tTupleProtocol.writeString(valueListData.errorString);
            }
        }

        public void read(TProtocol tProtocol, ValueListData valueListData) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(7);
            if (bitSet.get(0)) {
                valueListData.displayType = ValueListType.findByValue(tTupleProtocol.readI32());
                valueListData.setDisplayTypeIsSet(true);
            }
            if (bitSet.get(1)) {
                valueListData.separator = tTupleProtocol.readString();
                valueListData.setSeparatorIsSet(true);
            }
            if (bitSet.get(2)) {
                valueListData.hasMoreValues = tTupleProtocol.readBool();
                valueListData.setHasMoreValuesIsSet(true);
            }
            if (bitSet.get(3)) {
                valueListData.customList = tTupleProtocol.readBool();
                valueListData.setCustomListIsSet(true);
            }
            if (bitSet.get(4)) {
                TList tList = tTupleProtocol.readListBegin((byte)12);
                valueListData.values = new ArrayList<ValueListEntry>(tList.size);
                for (int i = 0; i < tList.size; ++i) {
                    ValueListEntry valueListEntry = new ValueListEntry();
                    valueListEntry.read((TProtocol)tTupleProtocol);
                    valueListData.values.add(valueListEntry);
                }
                valueListData.setValuesIsSet(true);
            }
            if (bitSet.get(5)) {
                valueListData.validData = tTupleProtocol.readBool();
                valueListData.setValidDataIsSet(true);
            }
            if (bitSet.get(6)) {
                valueListData.errorString = tTupleProtocol.readString();
                valueListData.setErrorStringIsSet(true);
            }
        }
    }

    private static class ValueListDataStandardScheme
    extends StandardScheme<ValueListData> {
        private ValueListDataStandardScheme() {
        }

        public void read(TProtocol tProtocol, ValueListData valueListData) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 8) {
                            valueListData.displayType = ValueListType.findByValue(tProtocol.readI32());
                            valueListData.setDisplayTypeIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 11) {
                            valueListData.separator = tProtocol.readString();
                            valueListData.setSeparatorIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 2) {
                            valueListData.hasMoreValues = tProtocol.readBool();
                            valueListData.setHasMoreValuesIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 2) {
                            valueListData.customList = tProtocol.readBool();
                            valueListData.setCustomListIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 5: {
                        if (tField.type == 15) {
                            TList tList = tProtocol.readListBegin();
                            valueListData.values = new ArrayList<ValueListEntry>(tList.size);
                            for (int i = 0; i < tList.size; ++i) {
                                ValueListEntry valueListEntry = new ValueListEntry();
                                valueListEntry.read(tProtocol);
                                valueListData.values.add(valueListEntry);
                            }
                            tProtocol.readListEnd();
                            valueListData.setValuesIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 6: {
                        if (tField.type == 2) {
                            valueListData.validData = tProtocol.readBool();
                            valueListData.setValidDataIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 7: {
                        if (tField.type == 11) {
                            valueListData.errorString = tProtocol.readString();
                            valueListData.setErrorStringIsSet(true);
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
            valueListData.validate();
        }

        public void write(TProtocol tProtocol, ValueListData valueListData) throws TException {
            valueListData.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (valueListData.displayType != null) {
                tProtocol.writeFieldBegin(DISPLAY_TYPE_FIELD_DESC);
                tProtocol.writeI32(valueListData.displayType.getValue());
                tProtocol.writeFieldEnd();
            }
            if (valueListData.separator != null) {
                tProtocol.writeFieldBegin(SEPARATOR_FIELD_DESC);
                tProtocol.writeString(valueListData.separator);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(HAS_MORE_VALUES_FIELD_DESC);
            tProtocol.writeBool(valueListData.hasMoreValues);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(CUSTOM_LIST_FIELD_DESC);
            tProtocol.writeBool(valueListData.customList);
            tProtocol.writeFieldEnd();
            if (valueListData.values != null) {
                tProtocol.writeFieldBegin(VALUES_FIELD_DESC);
                tProtocol.writeListBegin(new TList(12, valueListData.values.size()));
                for (ValueListEntry valueListEntry : valueListData.values) {
                    valueListEntry.write(tProtocol);
                }
                tProtocol.writeListEnd();
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(VALID_DATA_FIELD_DESC);
            tProtocol.writeBool(valueListData.validData);
            tProtocol.writeFieldEnd();
            if (valueListData.errorString != null) {
                tProtocol.writeFieldBegin(ERROR_STRING_FIELD_DESC);
                tProtocol.writeString(valueListData.errorString);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

