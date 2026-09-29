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
package com.filemaker.jwpc.iwp.thrift.common;

import com.filemaker.jwpc.iwp.thrift.common.SortQueryCriteria;
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

public class SortQuery
implements TBase<SortQuery, _Fields>,
Serializable,
Cloneable,
Comparable<SortQuery> {
    private static final TStruct STRUCT_DESC = new TStruct("SortQuery");
    private static final TField FIELD_NAME_FIELD_DESC = new TField("fieldName", 11, 1);
    private static final TField FIELD_ID_FIELD_DESC = new TField("fieldId", 8, 2);
    private static final TField CRITERIA_FIELD_DESC = new TField("criteria", 8, 3);
    private static final TField VALUE_FIELD_DESC = new TField("value", 11, 4);
    private static final TField TABLE_ID_FIELD_DESC = new TField("tableId", 8, 5);
    private static final TField FIELD_NAME_ALIAS_FOR_SORT_FIELD_DESC = new TField("fieldNameAliasForSort", 11, 6);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new SortQueryStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new SortQueryTupleSchemeFactory();
    @Nullable
    private String fieldName;
    private int fieldId;
    @Nullable
    private SortQueryCriteria criteria;
    @Nullable
    private String value;
    private int tableId;
    @Nullable
    private String fieldNameAliasForSort;
    private static final int __FIELDID_ISSET_ID = 0;
    private static final int __TABLEID_ISSET_ID = 1;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public SortQuery() {
        this.fieldId = 0;
    }

    public SortQuery(String string, int n, SortQueryCriteria sortQueryCriteria, String string2, int n2, String string3) {
        this();
        this.fieldName = string;
        this.fieldId = n;
        this.setFieldIdIsSet(true);
        this.criteria = sortQueryCriteria;
        this.value = string2;
        this.tableId = n2;
        this.setTableIdIsSet(true);
        this.fieldNameAliasForSort = string3;
    }

    public SortQuery(SortQuery sortQuery) {
        this.__isset_bitfield = sortQuery.__isset_bitfield;
        if (sortQuery.isSetFieldName()) {
            this.fieldName = sortQuery.fieldName;
        }
        this.fieldId = sortQuery.fieldId;
        if (sortQuery.isSetCriteria()) {
            this.criteria = sortQuery.criteria;
        }
        if (sortQuery.isSetValue()) {
            this.value = sortQuery.value;
        }
        this.tableId = sortQuery.tableId;
        if (sortQuery.isSetFieldNameAliasForSort()) {
            this.fieldNameAliasForSort = sortQuery.fieldNameAliasForSort;
        }
    }

    public SortQuery deepCopy() {
        return new SortQuery(this);
    }

    public void clear() {
        this.fieldName = null;
        this.fieldId = 0;
        this.criteria = null;
        this.value = null;
        this.setTableIdIsSet(false);
        this.tableId = 0;
        this.fieldNameAliasForSort = null;
    }

    @Nullable
    public String getFieldName() {
        return this.fieldName;
    }

    public void setFieldName(@Nullable String string) {
        this.fieldName = string;
    }

    public void unsetFieldName() {
        this.fieldName = null;
    }

    public boolean isSetFieldName() {
        return this.fieldName != null;
    }

    public void setFieldNameIsSet(boolean bl) {
        if (!bl) {
            this.fieldName = null;
        }
    }

    public int getFieldId() {
        return this.fieldId;
    }

    public void setFieldId(int n) {
        this.fieldId = n;
        this.setFieldIdIsSet(true);
    }

    public void unsetFieldId() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetFieldId() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setFieldIdIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    @Nullable
    public SortQueryCriteria getCriteria() {
        return this.criteria;
    }

    public void setCriteria(@Nullable SortQueryCriteria sortQueryCriteria) {
        this.criteria = sortQueryCriteria;
    }

    public void unsetCriteria() {
        this.criteria = null;
    }

    public boolean isSetCriteria() {
        return this.criteria != null;
    }

    public void setCriteriaIsSet(boolean bl) {
        if (!bl) {
            this.criteria = null;
        }
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

    public int getTableId() {
        return this.tableId;
    }

    public void setTableId(int n) {
        this.tableId = n;
        this.setTableIdIsSet(true);
    }

    public void unsetTableId() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)1);
    }

    public boolean isSetTableId() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)1);
    }

    public void setTableIdIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)1, (boolean)bl);
    }

    @Nullable
    public String getFieldNameAliasForSort() {
        return this.fieldNameAliasForSort;
    }

    public void setFieldNameAliasForSort(@Nullable String string) {
        this.fieldNameAliasForSort = string;
    }

    public void unsetFieldNameAliasForSort() {
        this.fieldNameAliasForSort = null;
    }

    public boolean isSetFieldNameAliasForSort() {
        return this.fieldNameAliasForSort != null;
    }

    public void setFieldNameAliasForSortIsSet(boolean bl) {
        if (!bl) {
            this.fieldNameAliasForSort = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetFieldName();
                    break;
                }
                this.setFieldName((String)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetFieldId();
                    break;
                }
                this.setFieldId((Integer)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetCriteria();
                    break;
                }
                this.setCriteria((SortQueryCriteria)((Object)object));
                break;
            }
            case 3: {
                if (object == null) {
                    this.unsetValue();
                    break;
                }
                this.setValue((String)object);
                break;
            }
            case 4: {
                if (object == null) {
                    this.unsetTableId();
                    break;
                }
                this.setTableId((Integer)object);
                break;
            }
            case 5: {
                if (object == null) {
                    this.unsetFieldNameAliasForSort();
                    break;
                }
                this.setFieldNameAliasForSort((String)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getFieldName();
            }
            case 1: {
                return this.getFieldId();
            }
            case 2: {
                return this.getCriteria();
            }
            case 3: {
                return this.getValue();
            }
            case 4: {
                return this.getTableId();
            }
            case 5: {
                return this.getFieldNameAliasForSort();
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
                return this.isSetFieldName();
            }
            case 1: {
                return this.isSetFieldId();
            }
            case 2: {
                return this.isSetCriteria();
            }
            case 3: {
                return this.isSetValue();
            }
            case 4: {
                return this.isSetTableId();
            }
            case 5: {
                return this.isSetFieldNameAliasForSort();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof SortQuery) {
            return this.equals((SortQuery)object);
        }
        return false;
    }

    public boolean equals(SortQuery sortQuery) {
        if (sortQuery == null) {
            return false;
        }
        if (this == sortQuery) {
            return true;
        }
        boolean bl = this.isSetFieldName();
        boolean bl2 = sortQuery.isSetFieldName();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.fieldName.equals(sortQuery.fieldName)) {
                return false;
            }
        }
        boolean bl3 = true;
        boolean bl4 = true;
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (this.fieldId != sortQuery.fieldId) {
                return false;
            }
        }
        boolean bl5 = this.isSetCriteria();
        boolean bl6 = sortQuery.isSetCriteria();
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (!this.criteria.equals((Object)sortQuery.criteria)) {
                return false;
            }
        }
        boolean bl7 = this.isSetValue();
        boolean bl8 = sortQuery.isSetValue();
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (!this.value.equals(sortQuery.value)) {
                return false;
            }
        }
        boolean bl9 = true;
        boolean bl10 = true;
        if (bl9 || bl10) {
            if (!bl9 || !bl10) {
                return false;
            }
            if (this.tableId != sortQuery.tableId) {
                return false;
            }
        }
        boolean bl11 = this.isSetFieldNameAliasForSort();
        boolean bl12 = sortQuery.isSetFieldNameAliasForSort();
        if (bl11 || bl12) {
            if (!bl11 || !bl12) {
                return false;
            }
            if (!this.fieldNameAliasForSort.equals(sortQuery.fieldNameAliasForSort)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetFieldName() ? 131071 : 524287);
        if (this.isSetFieldName()) {
            n = n * 8191 + this.fieldName.hashCode();
        }
        n = n * 8191 + this.fieldId;
        n = n * 8191 + (this.isSetCriteria() ? 131071 : 524287);
        if (this.isSetCriteria()) {
            n = n * 8191 + this.criteria.getValue();
        }
        n = n * 8191 + (this.isSetValue() ? 131071 : 524287);
        if (this.isSetValue()) {
            n = n * 8191 + this.value.hashCode();
        }
        n = n * 8191 + this.tableId;
        n = n * 8191 + (this.isSetFieldNameAliasForSort() ? 131071 : 524287);
        if (this.isSetFieldNameAliasForSort()) {
            n = n * 8191 + this.fieldNameAliasForSort.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(SortQuery sortQuery) {
        if (!this.getClass().equals(sortQuery.getClass())) {
            return this.getClass().getName().compareTo(sortQuery.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetFieldName(), sortQuery.isSetFieldName());
        if (n != 0) {
            return n;
        }
        if (this.isSetFieldName() && (n = TBaseHelper.compareTo((String)this.fieldName, (String)sortQuery.fieldName)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetFieldId(), sortQuery.isSetFieldId());
        if (n != 0) {
            return n;
        }
        if (this.isSetFieldId() && (n = TBaseHelper.compareTo((int)this.fieldId, (int)sortQuery.fieldId)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetCriteria(), sortQuery.isSetCriteria());
        if (n != 0) {
            return n;
        }
        if (this.isSetCriteria() && (n = TBaseHelper.compareTo((Comparable)((Object)this.criteria), (Comparable)((Object)sortQuery.criteria))) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetValue(), sortQuery.isSetValue());
        if (n != 0) {
            return n;
        }
        if (this.isSetValue() && (n = TBaseHelper.compareTo((String)this.value, (String)sortQuery.value)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetTableId(), sortQuery.isSetTableId());
        if (n != 0) {
            return n;
        }
        if (this.isSetTableId() && (n = TBaseHelper.compareTo((int)this.tableId, (int)sortQuery.tableId)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetFieldNameAliasForSort(), sortQuery.isSetFieldNameAliasForSort());
        if (n != 0) {
            return n;
        }
        if (this.isSetFieldNameAliasForSort() && (n = TBaseHelper.compareTo((String)this.fieldNameAliasForSort, (String)sortQuery.fieldNameAliasForSort)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        SortQuery.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        SortQuery.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("SortQuery(");
        boolean bl = true;
        stringBuilder.append("fieldName:");
        if (this.fieldName == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.fieldName);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("fieldId:");
        stringBuilder.append(this.fieldId);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("criteria:");
        if (this.criteria == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append((Object)this.criteria);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
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
        stringBuilder.append("tableId:");
        stringBuilder.append(this.tableId);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("fieldNameAliasForSort:");
        if (this.fieldNameAliasForSort == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.fieldNameAliasForSort);
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
        enumMap.put(_Fields.FIELD_NAME, new FieldMetaData("fieldName", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.FIELD_ID, new FieldMetaData("fieldId", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.CRITERIA, new FieldMetaData("criteria", 3, (FieldValueMetaData)new EnumMetaData(-1, SortQueryCriteria.class)));
        enumMap.put(_Fields.VALUE, new FieldMetaData("value", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.TABLE_ID, new FieldMetaData("tableId", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.FIELD_NAME_ALIAS_FOR_SORT, new FieldMetaData("fieldNameAliasForSort", 3, new FieldValueMetaData(11)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(SortQuery.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        FIELD_NAME(1, "fieldName"),
        FIELD_ID(2, "fieldId"),
        CRITERIA(3, "criteria"),
        VALUE(4, "value"),
        TABLE_ID(5, "tableId"),
        FIELD_NAME_ALIAS_FOR_SORT(6, "fieldNameAliasForSort");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return FIELD_NAME;
                }
                case 2: {
                    return FIELD_ID;
                }
                case 3: {
                    return CRITERIA;
                }
                case 4: {
                    return VALUE;
                }
                case 5: {
                    return TABLE_ID;
                }
                case 6: {
                    return FIELD_NAME_ALIAS_FOR_SORT;
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

    private static class SortQueryStandardSchemeFactory
    implements SchemeFactory {
        private SortQueryStandardSchemeFactory() {
        }

        public SortQueryStandardScheme getScheme() {
            return new SortQueryStandardScheme();
        }
    }

    private static class SortQueryTupleSchemeFactory
    implements SchemeFactory {
        private SortQueryTupleSchemeFactory() {
        }

        public SortQueryTupleScheme getScheme() {
            return new SortQueryTupleScheme();
        }
    }

    private static class SortQueryTupleScheme
    extends TupleScheme<SortQuery> {
        private SortQueryTupleScheme() {
        }

        public void write(TProtocol tProtocol, SortQuery sortQuery) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (sortQuery.isSetFieldName()) {
                bitSet.set(0);
            }
            if (sortQuery.isSetFieldId()) {
                bitSet.set(1);
            }
            if (sortQuery.isSetCriteria()) {
                bitSet.set(2);
            }
            if (sortQuery.isSetValue()) {
                bitSet.set(3);
            }
            if (sortQuery.isSetTableId()) {
                bitSet.set(4);
            }
            if (sortQuery.isSetFieldNameAliasForSort()) {
                bitSet.set(5);
            }
            tTupleProtocol.writeBitSet(bitSet, 6);
            if (sortQuery.isSetFieldName()) {
                tTupleProtocol.writeString(sortQuery.fieldName);
            }
            if (sortQuery.isSetFieldId()) {
                tTupleProtocol.writeI32(sortQuery.fieldId);
            }
            if (sortQuery.isSetCriteria()) {
                tTupleProtocol.writeI32(sortQuery.criteria.getValue());
            }
            if (sortQuery.isSetValue()) {
                tTupleProtocol.writeString(sortQuery.value);
            }
            if (sortQuery.isSetTableId()) {
                tTupleProtocol.writeI32(sortQuery.tableId);
            }
            if (sortQuery.isSetFieldNameAliasForSort()) {
                tTupleProtocol.writeString(sortQuery.fieldNameAliasForSort);
            }
        }

        public void read(TProtocol tProtocol, SortQuery sortQuery) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(6);
            if (bitSet.get(0)) {
                sortQuery.fieldName = tTupleProtocol.readString();
                sortQuery.setFieldNameIsSet(true);
            }
            if (bitSet.get(1)) {
                sortQuery.fieldId = tTupleProtocol.readI32();
                sortQuery.setFieldIdIsSet(true);
            }
            if (bitSet.get(2)) {
                sortQuery.criteria = SortQueryCriteria.findByValue(tTupleProtocol.readI32());
                sortQuery.setCriteriaIsSet(true);
            }
            if (bitSet.get(3)) {
                sortQuery.value = tTupleProtocol.readString();
                sortQuery.setValueIsSet(true);
            }
            if (bitSet.get(4)) {
                sortQuery.tableId = tTupleProtocol.readI32();
                sortQuery.setTableIdIsSet(true);
            }
            if (bitSet.get(5)) {
                sortQuery.fieldNameAliasForSort = tTupleProtocol.readString();
                sortQuery.setFieldNameAliasForSortIsSet(true);
            }
        }
    }

    private static class SortQueryStandardScheme
    extends StandardScheme<SortQuery> {
        private SortQueryStandardScheme() {
        }

        public void read(TProtocol tProtocol, SortQuery sortQuery) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 11) {
                            sortQuery.fieldName = tProtocol.readString();
                            sortQuery.setFieldNameIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 8) {
                            sortQuery.fieldId = tProtocol.readI32();
                            sortQuery.setFieldIdIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 8) {
                            sortQuery.criteria = SortQueryCriteria.findByValue(tProtocol.readI32());
                            sortQuery.setCriteriaIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 11) {
                            sortQuery.value = tProtocol.readString();
                            sortQuery.setValueIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 5: {
                        if (tField.type == 8) {
                            sortQuery.tableId = tProtocol.readI32();
                            sortQuery.setTableIdIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 6: {
                        if (tField.type == 11) {
                            sortQuery.fieldNameAliasForSort = tProtocol.readString();
                            sortQuery.setFieldNameAliasForSortIsSet(true);
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
            sortQuery.validate();
        }

        public void write(TProtocol tProtocol, SortQuery sortQuery) throws TException {
            sortQuery.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (sortQuery.fieldName != null) {
                tProtocol.writeFieldBegin(FIELD_NAME_FIELD_DESC);
                tProtocol.writeString(sortQuery.fieldName);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(FIELD_ID_FIELD_DESC);
            tProtocol.writeI32(sortQuery.fieldId);
            tProtocol.writeFieldEnd();
            if (sortQuery.criteria != null) {
                tProtocol.writeFieldBegin(CRITERIA_FIELD_DESC);
                tProtocol.writeI32(sortQuery.criteria.getValue());
                tProtocol.writeFieldEnd();
            }
            if (sortQuery.value != null) {
                tProtocol.writeFieldBegin(VALUE_FIELD_DESC);
                tProtocol.writeString(sortQuery.value);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(TABLE_ID_FIELD_DESC);
            tProtocol.writeI32(sortQuery.tableId);
            tProtocol.writeFieldEnd();
            if (sortQuery.fieldNameAliasForSort != null) {
                tProtocol.writeFieldBegin(FIELD_NAME_ALIAS_FOR_SORT_FIELD_DESC);
                tProtocol.writeString(sortQuery.fieldNameAliasForSort);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

