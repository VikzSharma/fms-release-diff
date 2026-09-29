/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
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

public class FieldDefinition
implements TBase<FieldDefinition, _Fields>,
Serializable,
Cloneable,
Comparable<FieldDefinition> {
    private static final TStruct STRUCT_DESC = new TStruct("FieldDefinition");
    private static final TField FIELD_NAME_FIELD_DESC = new TField("fieldName", 11, 1);
    private static final TField SUM_BY_FIELD_FIELD_DESC = new TField("sumByField", 11, 2);
    private static final TField FIELD_NAME_ALIAS_FOR_EXPORT_FIELD_DESC = new TField("fieldNameAliasForExport", 11, 3);
    private static final TField FIELD_NAME_ALIAS_FOR_SORT_FIELD_DESC = new TField("fieldNameAliasForSort", 11, 4);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new FieldDefinitionStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new FieldDefinitionTupleSchemeFactory();
    @Nullable
    private String fieldName;
    @Nullable
    private String sumByField;
    @Nullable
    private String fieldNameAliasForExport;
    @Nullable
    private String fieldNameAliasForSort;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public FieldDefinition() {
    }

    public FieldDefinition(String string, String string2, String string3, String string4) {
        this();
        this.fieldName = string;
        this.sumByField = string2;
        this.fieldNameAliasForExport = string3;
        this.fieldNameAliasForSort = string4;
    }

    public FieldDefinition(FieldDefinition fieldDefinition) {
        if (fieldDefinition.isSetFieldName()) {
            this.fieldName = fieldDefinition.fieldName;
        }
        if (fieldDefinition.isSetSumByField()) {
            this.sumByField = fieldDefinition.sumByField;
        }
        if (fieldDefinition.isSetFieldNameAliasForExport()) {
            this.fieldNameAliasForExport = fieldDefinition.fieldNameAliasForExport;
        }
        if (fieldDefinition.isSetFieldNameAliasForSort()) {
            this.fieldNameAliasForSort = fieldDefinition.fieldNameAliasForSort;
        }
    }

    public FieldDefinition deepCopy() {
        return new FieldDefinition(this);
    }

    public void clear() {
        this.fieldName = null;
        this.sumByField = null;
        this.fieldNameAliasForExport = null;
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

    @Nullable
    public String getSumByField() {
        return this.sumByField;
    }

    public void setSumByField(@Nullable String string) {
        this.sumByField = string;
    }

    public void unsetSumByField() {
        this.sumByField = null;
    }

    public boolean isSetSumByField() {
        return this.sumByField != null;
    }

    public void setSumByFieldIsSet(boolean bl) {
        if (!bl) {
            this.sumByField = null;
        }
    }

    @Nullable
    public String getFieldNameAliasForExport() {
        return this.fieldNameAliasForExport;
    }

    public void setFieldNameAliasForExport(@Nullable String string) {
        this.fieldNameAliasForExport = string;
    }

    public void unsetFieldNameAliasForExport() {
        this.fieldNameAliasForExport = null;
    }

    public boolean isSetFieldNameAliasForExport() {
        return this.fieldNameAliasForExport != null;
    }

    public void setFieldNameAliasForExportIsSet(boolean bl) {
        if (!bl) {
            this.fieldNameAliasForExport = null;
        }
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
                    this.unsetSumByField();
                    break;
                }
                this.setSumByField((String)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetFieldNameAliasForExport();
                    break;
                }
                this.setFieldNameAliasForExport((String)object);
                break;
            }
            case 3: {
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
                return this.getSumByField();
            }
            case 2: {
                return this.getFieldNameAliasForExport();
            }
            case 3: {
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
                return this.isSetSumByField();
            }
            case 2: {
                return this.isSetFieldNameAliasForExport();
            }
            case 3: {
                return this.isSetFieldNameAliasForSort();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof FieldDefinition) {
            return this.equals((FieldDefinition)object);
        }
        return false;
    }

    public boolean equals(FieldDefinition fieldDefinition) {
        if (fieldDefinition == null) {
            return false;
        }
        if (this == fieldDefinition) {
            return true;
        }
        boolean bl = this.isSetFieldName();
        boolean bl2 = fieldDefinition.isSetFieldName();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.fieldName.equals(fieldDefinition.fieldName)) {
                return false;
            }
        }
        boolean bl3 = this.isSetSumByField();
        boolean bl4 = fieldDefinition.isSetSumByField();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.sumByField.equals(fieldDefinition.sumByField)) {
                return false;
            }
        }
        boolean bl5 = this.isSetFieldNameAliasForExport();
        boolean bl6 = fieldDefinition.isSetFieldNameAliasForExport();
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (!this.fieldNameAliasForExport.equals(fieldDefinition.fieldNameAliasForExport)) {
                return false;
            }
        }
        boolean bl7 = this.isSetFieldNameAliasForSort();
        boolean bl8 = fieldDefinition.isSetFieldNameAliasForSort();
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (!this.fieldNameAliasForSort.equals(fieldDefinition.fieldNameAliasForSort)) {
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
        n = n * 8191 + (this.isSetSumByField() ? 131071 : 524287);
        if (this.isSetSumByField()) {
            n = n * 8191 + this.sumByField.hashCode();
        }
        n = n * 8191 + (this.isSetFieldNameAliasForExport() ? 131071 : 524287);
        if (this.isSetFieldNameAliasForExport()) {
            n = n * 8191 + this.fieldNameAliasForExport.hashCode();
        }
        n = n * 8191 + (this.isSetFieldNameAliasForSort() ? 131071 : 524287);
        if (this.isSetFieldNameAliasForSort()) {
            n = n * 8191 + this.fieldNameAliasForSort.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(FieldDefinition fieldDefinition) {
        if (!this.getClass().equals(fieldDefinition.getClass())) {
            return this.getClass().getName().compareTo(fieldDefinition.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetFieldName(), fieldDefinition.isSetFieldName());
        if (n != 0) {
            return n;
        }
        if (this.isSetFieldName() && (n = TBaseHelper.compareTo((String)this.fieldName, (String)fieldDefinition.fieldName)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetSumByField(), fieldDefinition.isSetSumByField());
        if (n != 0) {
            return n;
        }
        if (this.isSetSumByField() && (n = TBaseHelper.compareTo((String)this.sumByField, (String)fieldDefinition.sumByField)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetFieldNameAliasForExport(), fieldDefinition.isSetFieldNameAliasForExport());
        if (n != 0) {
            return n;
        }
        if (this.isSetFieldNameAliasForExport() && (n = TBaseHelper.compareTo((String)this.fieldNameAliasForExport, (String)fieldDefinition.fieldNameAliasForExport)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetFieldNameAliasForSort(), fieldDefinition.isSetFieldNameAliasForSort());
        if (n != 0) {
            return n;
        }
        if (this.isSetFieldNameAliasForSort() && (n = TBaseHelper.compareTo((String)this.fieldNameAliasForSort, (String)fieldDefinition.fieldNameAliasForSort)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        FieldDefinition.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        FieldDefinition.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("FieldDefinition(");
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
        stringBuilder.append("sumByField:");
        if (this.sumByField == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.sumByField);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("fieldNameAliasForExport:");
        if (this.fieldNameAliasForExport == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.fieldNameAliasForExport);
        }
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
        enumMap.put(_Fields.SUM_BY_FIELD, new FieldMetaData("sumByField", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.FIELD_NAME_ALIAS_FOR_EXPORT, new FieldMetaData("fieldNameAliasForExport", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.FIELD_NAME_ALIAS_FOR_SORT, new FieldMetaData("fieldNameAliasForSort", 3, new FieldValueMetaData(11)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(FieldDefinition.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        FIELD_NAME(1, "fieldName"),
        SUM_BY_FIELD(2, "sumByField"),
        FIELD_NAME_ALIAS_FOR_EXPORT(3, "fieldNameAliasForExport"),
        FIELD_NAME_ALIAS_FOR_SORT(4, "fieldNameAliasForSort");

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
                    return SUM_BY_FIELD;
                }
                case 3: {
                    return FIELD_NAME_ALIAS_FOR_EXPORT;
                }
                case 4: {
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

    private static class FieldDefinitionStandardSchemeFactory
    implements SchemeFactory {
        private FieldDefinitionStandardSchemeFactory() {
        }

        public FieldDefinitionStandardScheme getScheme() {
            return new FieldDefinitionStandardScheme();
        }
    }

    private static class FieldDefinitionTupleSchemeFactory
    implements SchemeFactory {
        private FieldDefinitionTupleSchemeFactory() {
        }

        public FieldDefinitionTupleScheme getScheme() {
            return new FieldDefinitionTupleScheme();
        }
    }

    private static class FieldDefinitionTupleScheme
    extends TupleScheme<FieldDefinition> {
        private FieldDefinitionTupleScheme() {
        }

        public void write(TProtocol tProtocol, FieldDefinition fieldDefinition) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (fieldDefinition.isSetFieldName()) {
                bitSet.set(0);
            }
            if (fieldDefinition.isSetSumByField()) {
                bitSet.set(1);
            }
            if (fieldDefinition.isSetFieldNameAliasForExport()) {
                bitSet.set(2);
            }
            if (fieldDefinition.isSetFieldNameAliasForSort()) {
                bitSet.set(3);
            }
            tTupleProtocol.writeBitSet(bitSet, 4);
            if (fieldDefinition.isSetFieldName()) {
                tTupleProtocol.writeString(fieldDefinition.fieldName);
            }
            if (fieldDefinition.isSetSumByField()) {
                tTupleProtocol.writeString(fieldDefinition.sumByField);
            }
            if (fieldDefinition.isSetFieldNameAliasForExport()) {
                tTupleProtocol.writeString(fieldDefinition.fieldNameAliasForExport);
            }
            if (fieldDefinition.isSetFieldNameAliasForSort()) {
                tTupleProtocol.writeString(fieldDefinition.fieldNameAliasForSort);
            }
        }

        public void read(TProtocol tProtocol, FieldDefinition fieldDefinition) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(4);
            if (bitSet.get(0)) {
                fieldDefinition.fieldName = tTupleProtocol.readString();
                fieldDefinition.setFieldNameIsSet(true);
            }
            if (bitSet.get(1)) {
                fieldDefinition.sumByField = tTupleProtocol.readString();
                fieldDefinition.setSumByFieldIsSet(true);
            }
            if (bitSet.get(2)) {
                fieldDefinition.fieldNameAliasForExport = tTupleProtocol.readString();
                fieldDefinition.setFieldNameAliasForExportIsSet(true);
            }
            if (bitSet.get(3)) {
                fieldDefinition.fieldNameAliasForSort = tTupleProtocol.readString();
                fieldDefinition.setFieldNameAliasForSortIsSet(true);
            }
        }
    }

    private static class FieldDefinitionStandardScheme
    extends StandardScheme<FieldDefinition> {
        private FieldDefinitionStandardScheme() {
        }

        public void read(TProtocol tProtocol, FieldDefinition fieldDefinition) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 11) {
                            fieldDefinition.fieldName = tProtocol.readString();
                            fieldDefinition.setFieldNameIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 11) {
                            fieldDefinition.sumByField = tProtocol.readString();
                            fieldDefinition.setSumByFieldIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 11) {
                            fieldDefinition.fieldNameAliasForExport = tProtocol.readString();
                            fieldDefinition.setFieldNameAliasForExportIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 11) {
                            fieldDefinition.fieldNameAliasForSort = tProtocol.readString();
                            fieldDefinition.setFieldNameAliasForSortIsSet(true);
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
            fieldDefinition.validate();
        }

        public void write(TProtocol tProtocol, FieldDefinition fieldDefinition) throws TException {
            fieldDefinition.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (fieldDefinition.fieldName != null) {
                tProtocol.writeFieldBegin(FIELD_NAME_FIELD_DESC);
                tProtocol.writeString(fieldDefinition.fieldName);
                tProtocol.writeFieldEnd();
            }
            if (fieldDefinition.sumByField != null) {
                tProtocol.writeFieldBegin(SUM_BY_FIELD_FIELD_DESC);
                tProtocol.writeString(fieldDefinition.sumByField);
                tProtocol.writeFieldEnd();
            }
            if (fieldDefinition.fieldNameAliasForExport != null) {
                tProtocol.writeFieldBegin(FIELD_NAME_ALIAS_FOR_EXPORT_FIELD_DESC);
                tProtocol.writeString(fieldDefinition.fieldNameAliasForExport);
                tProtocol.writeFieldEnd();
            }
            if (fieldDefinition.fieldNameAliasForSort != null) {
                tProtocol.writeFieldBegin(FIELD_NAME_ALIAS_FOR_SORT_FIELD_DESC);
                tProtocol.writeString(fieldDefinition.fieldNameAliasForSort);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

