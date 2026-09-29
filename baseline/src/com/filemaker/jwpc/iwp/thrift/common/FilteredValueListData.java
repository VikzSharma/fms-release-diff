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

import com.filemaker.jwpc.iwp.thrift.common.ValueListData;
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

public class FilteredValueListData
implements TBase<FilteredValueListData, _Fields>,
Serializable,
Cloneable,
Comparable<FilteredValueListData> {
    private static final TStruct STRUCT_DESC = new TStruct("FilteredValueListData");
    private static final TField VALUE_LIST_FIELD_DESC = new TField("valueList", 12, 1);
    private static final TField TOTAL_NUMBER_OF_ITEMS_FIELD_DESC = new TField("totalNumberOfItems", 8, 2);
    private static final TField PAGE_INDEX_OVERRIDE_FIELD_DESC = new TField("pageIndexOverride", 8, 3);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new FilteredValueListDataStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new FilteredValueListDataTupleSchemeFactory();
    @Nullable
    private ValueListData valueList;
    private int totalNumberOfItems;
    private int pageIndexOverride;
    private static final int __TOTALNUMBEROFITEMS_ISSET_ID = 0;
    private static final int __PAGEINDEXOVERRIDE_ISSET_ID = 1;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public FilteredValueListData() {
        this.pageIndexOverride = -1;
    }

    public FilteredValueListData(ValueListData valueListData, int n, int n2) {
        this();
        this.valueList = valueListData;
        this.totalNumberOfItems = n;
        this.setTotalNumberOfItemsIsSet(true);
        this.pageIndexOverride = n2;
        this.setPageIndexOverrideIsSet(true);
    }

    public FilteredValueListData(FilteredValueListData filteredValueListData) {
        this.__isset_bitfield = filteredValueListData.__isset_bitfield;
        if (filteredValueListData.isSetValueList()) {
            this.valueList = new ValueListData(filteredValueListData.valueList);
        }
        this.totalNumberOfItems = filteredValueListData.totalNumberOfItems;
        this.pageIndexOverride = filteredValueListData.pageIndexOverride;
    }

    public FilteredValueListData deepCopy() {
        return new FilteredValueListData(this);
    }

    public void clear() {
        this.valueList = null;
        this.setTotalNumberOfItemsIsSet(false);
        this.totalNumberOfItems = 0;
        this.pageIndexOverride = -1;
    }

    @Nullable
    public ValueListData getValueList() {
        return this.valueList;
    }

    public void setValueList(@Nullable ValueListData valueListData) {
        this.valueList = valueListData;
    }

    public void unsetValueList() {
        this.valueList = null;
    }

    public boolean isSetValueList() {
        return this.valueList != null;
    }

    public void setValueListIsSet(boolean bl) {
        if (!bl) {
            this.valueList = null;
        }
    }

    public int getTotalNumberOfItems() {
        return this.totalNumberOfItems;
    }

    public void setTotalNumberOfItems(int n) {
        this.totalNumberOfItems = n;
        this.setTotalNumberOfItemsIsSet(true);
    }

    public void unsetTotalNumberOfItems() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetTotalNumberOfItems() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setTotalNumberOfItemsIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public int getPageIndexOverride() {
        return this.pageIndexOverride;
    }

    public void setPageIndexOverride(int n) {
        this.pageIndexOverride = n;
        this.setPageIndexOverrideIsSet(true);
    }

    public void unsetPageIndexOverride() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)1);
    }

    public boolean isSetPageIndexOverride() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)1);
    }

    public void setPageIndexOverrideIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)1, (boolean)bl);
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetValueList();
                    break;
                }
                this.setValueList((ValueListData)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetTotalNumberOfItems();
                    break;
                }
                this.setTotalNumberOfItems((Integer)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetPageIndexOverride();
                    break;
                }
                this.setPageIndexOverride((Integer)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getValueList();
            }
            case 1: {
                return this.getTotalNumberOfItems();
            }
            case 2: {
                return this.getPageIndexOverride();
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
                return this.isSetValueList();
            }
            case 1: {
                return this.isSetTotalNumberOfItems();
            }
            case 2: {
                return this.isSetPageIndexOverride();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof FilteredValueListData) {
            return this.equals((FilteredValueListData)object);
        }
        return false;
    }

    public boolean equals(FilteredValueListData filteredValueListData) {
        if (filteredValueListData == null) {
            return false;
        }
        if (this == filteredValueListData) {
            return true;
        }
        boolean bl = this.isSetValueList();
        boolean bl2 = filteredValueListData.isSetValueList();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.valueList.equals(filteredValueListData.valueList)) {
                return false;
            }
        }
        boolean bl3 = true;
        boolean bl4 = true;
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (this.totalNumberOfItems != filteredValueListData.totalNumberOfItems) {
                return false;
            }
        }
        boolean bl5 = true;
        boolean bl6 = true;
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (this.pageIndexOverride != filteredValueListData.pageIndexOverride) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetValueList() ? 131071 : 524287);
        if (this.isSetValueList()) {
            n = n * 8191 + this.valueList.hashCode();
        }
        n = n * 8191 + this.totalNumberOfItems;
        n = n * 8191 + this.pageIndexOverride;
        return n;
    }

    @Override
    public int compareTo(FilteredValueListData filteredValueListData) {
        if (!this.getClass().equals(filteredValueListData.getClass())) {
            return this.getClass().getName().compareTo(filteredValueListData.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetValueList(), filteredValueListData.isSetValueList());
        if (n != 0) {
            return n;
        }
        if (this.isSetValueList() && (n = TBaseHelper.compareTo((Comparable)this.valueList, (Comparable)filteredValueListData.valueList)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetTotalNumberOfItems(), filteredValueListData.isSetTotalNumberOfItems());
        if (n != 0) {
            return n;
        }
        if (this.isSetTotalNumberOfItems() && (n = TBaseHelper.compareTo((int)this.totalNumberOfItems, (int)filteredValueListData.totalNumberOfItems)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetPageIndexOverride(), filteredValueListData.isSetPageIndexOverride());
        if (n != 0) {
            return n;
        }
        if (this.isSetPageIndexOverride() && (n = TBaseHelper.compareTo((int)this.pageIndexOverride, (int)filteredValueListData.pageIndexOverride)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        FilteredValueListData.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        FilteredValueListData.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("FilteredValueListData(");
        boolean bl = true;
        stringBuilder.append("valueList:");
        if (this.valueList == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.valueList);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("totalNumberOfItems:");
        stringBuilder.append(this.totalNumberOfItems);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("pageIndexOverride:");
        stringBuilder.append(this.pageIndexOverride);
        bl = false;
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void validate() throws TException {
        if (this.valueList != null) {
            this.valueList.validate();
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
        enumMap.put(_Fields.VALUE_LIST, new FieldMetaData("valueList", 3, (FieldValueMetaData)new StructMetaData(12, ValueListData.class)));
        enumMap.put(_Fields.TOTAL_NUMBER_OF_ITEMS, new FieldMetaData("totalNumberOfItems", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.PAGE_INDEX_OVERRIDE, new FieldMetaData("pageIndexOverride", 3, new FieldValueMetaData(8)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(FilteredValueListData.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        VALUE_LIST(1, "valueList"),
        TOTAL_NUMBER_OF_ITEMS(2, "totalNumberOfItems"),
        PAGE_INDEX_OVERRIDE(3, "pageIndexOverride");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return VALUE_LIST;
                }
                case 2: {
                    return TOTAL_NUMBER_OF_ITEMS;
                }
                case 3: {
                    return PAGE_INDEX_OVERRIDE;
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

    private static class FilteredValueListDataStandardSchemeFactory
    implements SchemeFactory {
        private FilteredValueListDataStandardSchemeFactory() {
        }

        public FilteredValueListDataStandardScheme getScheme() {
            return new FilteredValueListDataStandardScheme();
        }
    }

    private static class FilteredValueListDataTupleSchemeFactory
    implements SchemeFactory {
        private FilteredValueListDataTupleSchemeFactory() {
        }

        public FilteredValueListDataTupleScheme getScheme() {
            return new FilteredValueListDataTupleScheme();
        }
    }

    private static class FilteredValueListDataTupleScheme
    extends TupleScheme<FilteredValueListData> {
        private FilteredValueListDataTupleScheme() {
        }

        public void write(TProtocol tProtocol, FilteredValueListData filteredValueListData) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (filteredValueListData.isSetValueList()) {
                bitSet.set(0);
            }
            if (filteredValueListData.isSetTotalNumberOfItems()) {
                bitSet.set(1);
            }
            if (filteredValueListData.isSetPageIndexOverride()) {
                bitSet.set(2);
            }
            tTupleProtocol.writeBitSet(bitSet, 3);
            if (filteredValueListData.isSetValueList()) {
                filteredValueListData.valueList.write((TProtocol)tTupleProtocol);
            }
            if (filteredValueListData.isSetTotalNumberOfItems()) {
                tTupleProtocol.writeI32(filteredValueListData.totalNumberOfItems);
            }
            if (filteredValueListData.isSetPageIndexOverride()) {
                tTupleProtocol.writeI32(filteredValueListData.pageIndexOverride);
            }
        }

        public void read(TProtocol tProtocol, FilteredValueListData filteredValueListData) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(3);
            if (bitSet.get(0)) {
                filteredValueListData.valueList = new ValueListData();
                filteredValueListData.valueList.read((TProtocol)tTupleProtocol);
                filteredValueListData.setValueListIsSet(true);
            }
            if (bitSet.get(1)) {
                filteredValueListData.totalNumberOfItems = tTupleProtocol.readI32();
                filteredValueListData.setTotalNumberOfItemsIsSet(true);
            }
            if (bitSet.get(2)) {
                filteredValueListData.pageIndexOverride = tTupleProtocol.readI32();
                filteredValueListData.setPageIndexOverrideIsSet(true);
            }
        }
    }

    private static class FilteredValueListDataStandardScheme
    extends StandardScheme<FilteredValueListData> {
        private FilteredValueListDataStandardScheme() {
        }

        public void read(TProtocol tProtocol, FilteredValueListData filteredValueListData) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 12) {
                            filteredValueListData.valueList = new ValueListData();
                            filteredValueListData.valueList.read(tProtocol);
                            filteredValueListData.setValueListIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 8) {
                            filteredValueListData.totalNumberOfItems = tProtocol.readI32();
                            filteredValueListData.setTotalNumberOfItemsIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 8) {
                            filteredValueListData.pageIndexOverride = tProtocol.readI32();
                            filteredValueListData.setPageIndexOverrideIsSet(true);
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
            filteredValueListData.validate();
        }

        public void write(TProtocol tProtocol, FilteredValueListData filteredValueListData) throws TException {
            filteredValueListData.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (filteredValueListData.valueList != null) {
                tProtocol.writeFieldBegin(VALUE_LIST_FIELD_DESC);
                filteredValueListData.valueList.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(TOTAL_NUMBER_OF_ITEMS_FIELD_DESC);
            tProtocol.writeI32(filteredValueListData.totalNumberOfItems);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(PAGE_INDEX_OVERRIDE_FIELD_DESC);
            tProtocol.writeI32(filteredValueListData.pageIndexOverride);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

