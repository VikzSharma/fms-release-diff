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

import com.filemaker.jwpc.iwp.thrift.common.LayoutFieldDataType;
import com.filemaker.jwpc.iwp.thrift.common.LayoutFieldType;
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

public class FieldSpec
implements TBase<FieldSpec, _Fields>,
Serializable,
Cloneable,
Comparable<FieldSpec> {
    private static final TStruct STRUCT_DESC = new TStruct("FieldSpec");
    private static final TField FILE_NAME_FIELD_DESC = new TField("fileName", 11, 1);
    private static final TField BASE_TABLE_ID_FIELD_DESC = new TField("baseTableId", 8, 2);
    private static final TField FIELD_ID_FIELD_DESC = new TField("fieldId", 8, 3);
    private static final TField FIELD_NAME_FIELD_DESC = new TField("fieldName", 11, 4);
    private static final TField REPETITION_FIELD_DESC = new TField("repetition", 6, 5);
    private static final TField FIELD_TYPE_FIELD_DESC = new TField("fieldType", 8, 6);
    private static final TField FIELD_DATA_TYPE_FIELD_DESC = new TField("fieldDataType", 8, 7);
    private static final TField FIELD_NAME_ALIAS_FOR_EXPORT_FIELD_DESC = new TField("fieldNameAliasForExport", 11, 8);
    private static final TField FIELD_NAME_ALIAS_FOR_SORT_FIELD_DESC = new TField("fieldNameAliasForSort", 11, 9);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new FieldSpecStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new FieldSpecTupleSchemeFactory();
    @Nullable
    private String fileName;
    private int baseTableId;
    private int fieldId;
    @Nullable
    private String fieldName;
    private short repetition;
    @Nullable
    private LayoutFieldType fieldType;
    @Nullable
    private LayoutFieldDataType fieldDataType;
    @Nullable
    private String fieldNameAliasForExport;
    @Nullable
    private String fieldNameAliasForSort;
    private static final int __BASETABLEID_ISSET_ID = 0;
    private static final int __FIELDID_ISSET_ID = 1;
    private static final int __REPETITION_ISSET_ID = 2;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public FieldSpec() {
        this.baseTableId = 0;
        this.fieldId = 0;
        this.repetition = 1;
    }

    public FieldSpec(String string, int n, int n2, String string2, short s, LayoutFieldType layoutFieldType, LayoutFieldDataType layoutFieldDataType, String string3, String string4) {
        this();
        this.fileName = string;
        this.baseTableId = n;
        this.setBaseTableIdIsSet(true);
        this.fieldId = n2;
        this.setFieldIdIsSet(true);
        this.fieldName = string2;
        this.repetition = s;
        this.setRepetitionIsSet(true);
        this.fieldType = layoutFieldType;
        this.fieldDataType = layoutFieldDataType;
        this.fieldNameAliasForExport = string3;
        this.fieldNameAliasForSort = string4;
    }

    public FieldSpec(FieldSpec fieldSpec) {
        this.__isset_bitfield = fieldSpec.__isset_bitfield;
        if (fieldSpec.isSetFileName()) {
            this.fileName = fieldSpec.fileName;
        }
        this.baseTableId = fieldSpec.baseTableId;
        this.fieldId = fieldSpec.fieldId;
        if (fieldSpec.isSetFieldName()) {
            this.fieldName = fieldSpec.fieldName;
        }
        this.repetition = fieldSpec.repetition;
        if (fieldSpec.isSetFieldType()) {
            this.fieldType = fieldSpec.fieldType;
        }
        if (fieldSpec.isSetFieldDataType()) {
            this.fieldDataType = fieldSpec.fieldDataType;
        }
        if (fieldSpec.isSetFieldNameAliasForExport()) {
            this.fieldNameAliasForExport = fieldSpec.fieldNameAliasForExport;
        }
        if (fieldSpec.isSetFieldNameAliasForSort()) {
            this.fieldNameAliasForSort = fieldSpec.fieldNameAliasForSort;
        }
    }

    public FieldSpec deepCopy() {
        return new FieldSpec(this);
    }

    public void clear() {
        this.fileName = null;
        this.baseTableId = 0;
        this.fieldId = 0;
        this.fieldName = null;
        this.repetition = 1;
        this.fieldType = null;
        this.fieldDataType = null;
        this.fieldNameAliasForExport = null;
        this.fieldNameAliasForSort = null;
    }

    @Nullable
    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(@Nullable String string) {
        this.fileName = string;
    }

    public void unsetFileName() {
        this.fileName = null;
    }

    public boolean isSetFileName() {
        return this.fileName != null;
    }

    public void setFileNameIsSet(boolean bl) {
        if (!bl) {
            this.fileName = null;
        }
    }

    public int getBaseTableId() {
        return this.baseTableId;
    }

    public void setBaseTableId(int n) {
        this.baseTableId = n;
        this.setBaseTableIdIsSet(true);
    }

    public void unsetBaseTableId() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetBaseTableId() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setBaseTableIdIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public int getFieldId() {
        return this.fieldId;
    }

    public void setFieldId(int n) {
        this.fieldId = n;
        this.setFieldIdIsSet(true);
    }

    public void unsetFieldId() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)1);
    }

    public boolean isSetFieldId() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)1);
    }

    public void setFieldIdIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)1, (boolean)bl);
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

    public short getRepetition() {
        return this.repetition;
    }

    public void setRepetition(short s) {
        this.repetition = s;
        this.setRepetitionIsSet(true);
    }

    public void unsetRepetition() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)2);
    }

    public boolean isSetRepetition() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)2);
    }

    public void setRepetitionIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)2, (boolean)bl);
    }

    @Nullable
    public LayoutFieldType getFieldType() {
        return this.fieldType;
    }

    public void setFieldType(@Nullable LayoutFieldType layoutFieldType) {
        this.fieldType = layoutFieldType;
    }

    public void unsetFieldType() {
        this.fieldType = null;
    }

    public boolean isSetFieldType() {
        return this.fieldType != null;
    }

    public void setFieldTypeIsSet(boolean bl) {
        if (!bl) {
            this.fieldType = null;
        }
    }

    @Nullable
    public LayoutFieldDataType getFieldDataType() {
        return this.fieldDataType;
    }

    public void setFieldDataType(@Nullable LayoutFieldDataType layoutFieldDataType) {
        this.fieldDataType = layoutFieldDataType;
    }

    public void unsetFieldDataType() {
        this.fieldDataType = null;
    }

    public boolean isSetFieldDataType() {
        return this.fieldDataType != null;
    }

    public void setFieldDataTypeIsSet(boolean bl) {
        if (!bl) {
            this.fieldDataType = null;
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
                    this.unsetFileName();
                    break;
                }
                this.setFileName((String)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetBaseTableId();
                    break;
                }
                this.setBaseTableId((Integer)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetFieldId();
                    break;
                }
                this.setFieldId((Integer)object);
                break;
            }
            case 3: {
                if (object == null) {
                    this.unsetFieldName();
                    break;
                }
                this.setFieldName((String)object);
                break;
            }
            case 4: {
                if (object == null) {
                    this.unsetRepetition();
                    break;
                }
                this.setRepetition((Short)object);
                break;
            }
            case 5: {
                if (object == null) {
                    this.unsetFieldType();
                    break;
                }
                this.setFieldType((LayoutFieldType)((Object)object));
                break;
            }
            case 6: {
                if (object == null) {
                    this.unsetFieldDataType();
                    break;
                }
                this.setFieldDataType((LayoutFieldDataType)((Object)object));
                break;
            }
            case 7: {
                if (object == null) {
                    this.unsetFieldNameAliasForExport();
                    break;
                }
                this.setFieldNameAliasForExport((String)object);
                break;
            }
            case 8: {
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
                return this.getFileName();
            }
            case 1: {
                return this.getBaseTableId();
            }
            case 2: {
                return this.getFieldId();
            }
            case 3: {
                return this.getFieldName();
            }
            case 4: {
                return this.getRepetition();
            }
            case 5: {
                return this.getFieldType();
            }
            case 6: {
                return this.getFieldDataType();
            }
            case 7: {
                return this.getFieldNameAliasForExport();
            }
            case 8: {
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
                return this.isSetFileName();
            }
            case 1: {
                return this.isSetBaseTableId();
            }
            case 2: {
                return this.isSetFieldId();
            }
            case 3: {
                return this.isSetFieldName();
            }
            case 4: {
                return this.isSetRepetition();
            }
            case 5: {
                return this.isSetFieldType();
            }
            case 6: {
                return this.isSetFieldDataType();
            }
            case 7: {
                return this.isSetFieldNameAliasForExport();
            }
            case 8: {
                return this.isSetFieldNameAliasForSort();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof FieldSpec) {
            return this.equals((FieldSpec)object);
        }
        return false;
    }

    public boolean equals(FieldSpec fieldSpec) {
        if (fieldSpec == null) {
            return false;
        }
        if (this == fieldSpec) {
            return true;
        }
        boolean bl = this.isSetFileName();
        boolean bl2 = fieldSpec.isSetFileName();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.fileName.equals(fieldSpec.fileName)) {
                return false;
            }
        }
        boolean bl3 = true;
        boolean bl4 = true;
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (this.baseTableId != fieldSpec.baseTableId) {
                return false;
            }
        }
        boolean bl5 = true;
        boolean bl6 = true;
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (this.fieldId != fieldSpec.fieldId) {
                return false;
            }
        }
        boolean bl7 = this.isSetFieldName();
        boolean bl8 = fieldSpec.isSetFieldName();
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (!this.fieldName.equals(fieldSpec.fieldName)) {
                return false;
            }
        }
        boolean bl9 = true;
        boolean bl10 = true;
        if (bl9 || bl10) {
            if (!bl9 || !bl10) {
                return false;
            }
            if (this.repetition != fieldSpec.repetition) {
                return false;
            }
        }
        boolean bl11 = this.isSetFieldType();
        boolean bl12 = fieldSpec.isSetFieldType();
        if (bl11 || bl12) {
            if (!bl11 || !bl12) {
                return false;
            }
            if (!this.fieldType.equals((Object)fieldSpec.fieldType)) {
                return false;
            }
        }
        boolean bl13 = this.isSetFieldDataType();
        boolean bl14 = fieldSpec.isSetFieldDataType();
        if (bl13 || bl14) {
            if (!bl13 || !bl14) {
                return false;
            }
            if (!this.fieldDataType.equals((Object)fieldSpec.fieldDataType)) {
                return false;
            }
        }
        boolean bl15 = this.isSetFieldNameAliasForExport();
        boolean bl16 = fieldSpec.isSetFieldNameAliasForExport();
        if (bl15 || bl16) {
            if (!bl15 || !bl16) {
                return false;
            }
            if (!this.fieldNameAliasForExport.equals(fieldSpec.fieldNameAliasForExport)) {
                return false;
            }
        }
        boolean bl17 = this.isSetFieldNameAliasForSort();
        boolean bl18 = fieldSpec.isSetFieldNameAliasForSort();
        if (bl17 || bl18) {
            if (!bl17 || !bl18) {
                return false;
            }
            if (!this.fieldNameAliasForSort.equals(fieldSpec.fieldNameAliasForSort)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetFileName() ? 131071 : 524287);
        if (this.isSetFileName()) {
            n = n * 8191 + this.fileName.hashCode();
        }
        n = n * 8191 + this.baseTableId;
        n = n * 8191 + this.fieldId;
        n = n * 8191 + (this.isSetFieldName() ? 131071 : 524287);
        if (this.isSetFieldName()) {
            n = n * 8191 + this.fieldName.hashCode();
        }
        n = n * 8191 + this.repetition;
        n = n * 8191 + (this.isSetFieldType() ? 131071 : 524287);
        if (this.isSetFieldType()) {
            n = n * 8191 + this.fieldType.getValue();
        }
        n = n * 8191 + (this.isSetFieldDataType() ? 131071 : 524287);
        if (this.isSetFieldDataType()) {
            n = n * 8191 + this.fieldDataType.getValue();
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
    public int compareTo(FieldSpec fieldSpec) {
        if (!this.getClass().equals(fieldSpec.getClass())) {
            return this.getClass().getName().compareTo(fieldSpec.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetFileName(), fieldSpec.isSetFileName());
        if (n != 0) {
            return n;
        }
        if (this.isSetFileName() && (n = TBaseHelper.compareTo((String)this.fileName, (String)fieldSpec.fileName)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetBaseTableId(), fieldSpec.isSetBaseTableId());
        if (n != 0) {
            return n;
        }
        if (this.isSetBaseTableId() && (n = TBaseHelper.compareTo((int)this.baseTableId, (int)fieldSpec.baseTableId)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetFieldId(), fieldSpec.isSetFieldId());
        if (n != 0) {
            return n;
        }
        if (this.isSetFieldId() && (n = TBaseHelper.compareTo((int)this.fieldId, (int)fieldSpec.fieldId)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetFieldName(), fieldSpec.isSetFieldName());
        if (n != 0) {
            return n;
        }
        if (this.isSetFieldName() && (n = TBaseHelper.compareTo((String)this.fieldName, (String)fieldSpec.fieldName)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetRepetition(), fieldSpec.isSetRepetition());
        if (n != 0) {
            return n;
        }
        if (this.isSetRepetition() && (n = TBaseHelper.compareTo((short)this.repetition, (short)fieldSpec.repetition)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetFieldType(), fieldSpec.isSetFieldType());
        if (n != 0) {
            return n;
        }
        if (this.isSetFieldType() && (n = TBaseHelper.compareTo((Comparable)((Object)this.fieldType), (Comparable)((Object)fieldSpec.fieldType))) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetFieldDataType(), fieldSpec.isSetFieldDataType());
        if (n != 0) {
            return n;
        }
        if (this.isSetFieldDataType() && (n = TBaseHelper.compareTo((Comparable)((Object)this.fieldDataType), (Comparable)((Object)fieldSpec.fieldDataType))) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetFieldNameAliasForExport(), fieldSpec.isSetFieldNameAliasForExport());
        if (n != 0) {
            return n;
        }
        if (this.isSetFieldNameAliasForExport() && (n = TBaseHelper.compareTo((String)this.fieldNameAliasForExport, (String)fieldSpec.fieldNameAliasForExport)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetFieldNameAliasForSort(), fieldSpec.isSetFieldNameAliasForSort());
        if (n != 0) {
            return n;
        }
        if (this.isSetFieldNameAliasForSort() && (n = TBaseHelper.compareTo((String)this.fieldNameAliasForSort, (String)fieldSpec.fieldNameAliasForSort)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        FieldSpec.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        FieldSpec.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("FieldSpec(");
        boolean bl = true;
        stringBuilder.append("fileName:");
        if (this.fileName == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.fileName);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("baseTableId:");
        stringBuilder.append(this.baseTableId);
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
        stringBuilder.append("repetition:");
        stringBuilder.append(this.repetition);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("fieldType:");
        if (this.fieldType == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append((Object)this.fieldType);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("fieldDataType:");
        if (this.fieldDataType == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append((Object)this.fieldDataType);
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
        enumMap.put(_Fields.FILE_NAME, new FieldMetaData("fileName", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.BASE_TABLE_ID, new FieldMetaData("baseTableId", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.FIELD_ID, new FieldMetaData("fieldId", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.FIELD_NAME, new FieldMetaData("fieldName", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.REPETITION, new FieldMetaData("repetition", 3, new FieldValueMetaData(6)));
        enumMap.put(_Fields.FIELD_TYPE, new FieldMetaData("fieldType", 3, (FieldValueMetaData)new EnumMetaData(-1, LayoutFieldType.class)));
        enumMap.put(_Fields.FIELD_DATA_TYPE, new FieldMetaData("fieldDataType", 3, (FieldValueMetaData)new EnumMetaData(-1, LayoutFieldDataType.class)));
        enumMap.put(_Fields.FIELD_NAME_ALIAS_FOR_EXPORT, new FieldMetaData("fieldNameAliasForExport", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.FIELD_NAME_ALIAS_FOR_SORT, new FieldMetaData("fieldNameAliasForSort", 3, new FieldValueMetaData(11)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(FieldSpec.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        FILE_NAME(1, "fileName"),
        BASE_TABLE_ID(2, "baseTableId"),
        FIELD_ID(3, "fieldId"),
        FIELD_NAME(4, "fieldName"),
        REPETITION(5, "repetition"),
        FIELD_TYPE(6, "fieldType"),
        FIELD_DATA_TYPE(7, "fieldDataType"),
        FIELD_NAME_ALIAS_FOR_EXPORT(8, "fieldNameAliasForExport"),
        FIELD_NAME_ALIAS_FOR_SORT(9, "fieldNameAliasForSort");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return FILE_NAME;
                }
                case 2: {
                    return BASE_TABLE_ID;
                }
                case 3: {
                    return FIELD_ID;
                }
                case 4: {
                    return FIELD_NAME;
                }
                case 5: {
                    return REPETITION;
                }
                case 6: {
                    return FIELD_TYPE;
                }
                case 7: {
                    return FIELD_DATA_TYPE;
                }
                case 8: {
                    return FIELD_NAME_ALIAS_FOR_EXPORT;
                }
                case 9: {
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

    private static class FieldSpecStandardSchemeFactory
    implements SchemeFactory {
        private FieldSpecStandardSchemeFactory() {
        }

        public FieldSpecStandardScheme getScheme() {
            return new FieldSpecStandardScheme();
        }
    }

    private static class FieldSpecTupleSchemeFactory
    implements SchemeFactory {
        private FieldSpecTupleSchemeFactory() {
        }

        public FieldSpecTupleScheme getScheme() {
            return new FieldSpecTupleScheme();
        }
    }

    private static class FieldSpecTupleScheme
    extends TupleScheme<FieldSpec> {
        private FieldSpecTupleScheme() {
        }

        public void write(TProtocol tProtocol, FieldSpec fieldSpec) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (fieldSpec.isSetFileName()) {
                bitSet.set(0);
            }
            if (fieldSpec.isSetBaseTableId()) {
                bitSet.set(1);
            }
            if (fieldSpec.isSetFieldId()) {
                bitSet.set(2);
            }
            if (fieldSpec.isSetFieldName()) {
                bitSet.set(3);
            }
            if (fieldSpec.isSetRepetition()) {
                bitSet.set(4);
            }
            if (fieldSpec.isSetFieldType()) {
                bitSet.set(5);
            }
            if (fieldSpec.isSetFieldDataType()) {
                bitSet.set(6);
            }
            if (fieldSpec.isSetFieldNameAliasForExport()) {
                bitSet.set(7);
            }
            if (fieldSpec.isSetFieldNameAliasForSort()) {
                bitSet.set(8);
            }
            tTupleProtocol.writeBitSet(bitSet, 9);
            if (fieldSpec.isSetFileName()) {
                tTupleProtocol.writeString(fieldSpec.fileName);
            }
            if (fieldSpec.isSetBaseTableId()) {
                tTupleProtocol.writeI32(fieldSpec.baseTableId);
            }
            if (fieldSpec.isSetFieldId()) {
                tTupleProtocol.writeI32(fieldSpec.fieldId);
            }
            if (fieldSpec.isSetFieldName()) {
                tTupleProtocol.writeString(fieldSpec.fieldName);
            }
            if (fieldSpec.isSetRepetition()) {
                tTupleProtocol.writeI16(fieldSpec.repetition);
            }
            if (fieldSpec.isSetFieldType()) {
                tTupleProtocol.writeI32(fieldSpec.fieldType.getValue());
            }
            if (fieldSpec.isSetFieldDataType()) {
                tTupleProtocol.writeI32(fieldSpec.fieldDataType.getValue());
            }
            if (fieldSpec.isSetFieldNameAliasForExport()) {
                tTupleProtocol.writeString(fieldSpec.fieldNameAliasForExport);
            }
            if (fieldSpec.isSetFieldNameAliasForSort()) {
                tTupleProtocol.writeString(fieldSpec.fieldNameAliasForSort);
            }
        }

        public void read(TProtocol tProtocol, FieldSpec fieldSpec) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(9);
            if (bitSet.get(0)) {
                fieldSpec.fileName = tTupleProtocol.readString();
                fieldSpec.setFileNameIsSet(true);
            }
            if (bitSet.get(1)) {
                fieldSpec.baseTableId = tTupleProtocol.readI32();
                fieldSpec.setBaseTableIdIsSet(true);
            }
            if (bitSet.get(2)) {
                fieldSpec.fieldId = tTupleProtocol.readI32();
                fieldSpec.setFieldIdIsSet(true);
            }
            if (bitSet.get(3)) {
                fieldSpec.fieldName = tTupleProtocol.readString();
                fieldSpec.setFieldNameIsSet(true);
            }
            if (bitSet.get(4)) {
                fieldSpec.repetition = tTupleProtocol.readI16();
                fieldSpec.setRepetitionIsSet(true);
            }
            if (bitSet.get(5)) {
                fieldSpec.fieldType = LayoutFieldType.findByValue(tTupleProtocol.readI32());
                fieldSpec.setFieldTypeIsSet(true);
            }
            if (bitSet.get(6)) {
                fieldSpec.fieldDataType = LayoutFieldDataType.findByValue(tTupleProtocol.readI32());
                fieldSpec.setFieldDataTypeIsSet(true);
            }
            if (bitSet.get(7)) {
                fieldSpec.fieldNameAliasForExport = tTupleProtocol.readString();
                fieldSpec.setFieldNameAliasForExportIsSet(true);
            }
            if (bitSet.get(8)) {
                fieldSpec.fieldNameAliasForSort = tTupleProtocol.readString();
                fieldSpec.setFieldNameAliasForSortIsSet(true);
            }
        }
    }

    private static class FieldSpecStandardScheme
    extends StandardScheme<FieldSpec> {
        private FieldSpecStandardScheme() {
        }

        public void read(TProtocol tProtocol, FieldSpec fieldSpec) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 11) {
                            fieldSpec.fileName = tProtocol.readString();
                            fieldSpec.setFileNameIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 8) {
                            fieldSpec.baseTableId = tProtocol.readI32();
                            fieldSpec.setBaseTableIdIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 8) {
                            fieldSpec.fieldId = tProtocol.readI32();
                            fieldSpec.setFieldIdIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 11) {
                            fieldSpec.fieldName = tProtocol.readString();
                            fieldSpec.setFieldNameIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 5: {
                        if (tField.type == 6) {
                            fieldSpec.repetition = tProtocol.readI16();
                            fieldSpec.setRepetitionIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 6: {
                        if (tField.type == 8) {
                            fieldSpec.fieldType = LayoutFieldType.findByValue(tProtocol.readI32());
                            fieldSpec.setFieldTypeIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 7: {
                        if (tField.type == 8) {
                            fieldSpec.fieldDataType = LayoutFieldDataType.findByValue(tProtocol.readI32());
                            fieldSpec.setFieldDataTypeIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 8: {
                        if (tField.type == 11) {
                            fieldSpec.fieldNameAliasForExport = tProtocol.readString();
                            fieldSpec.setFieldNameAliasForExportIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 9: {
                        if (tField.type == 11) {
                            fieldSpec.fieldNameAliasForSort = tProtocol.readString();
                            fieldSpec.setFieldNameAliasForSortIsSet(true);
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
            fieldSpec.validate();
        }

        public void write(TProtocol tProtocol, FieldSpec fieldSpec) throws TException {
            fieldSpec.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (fieldSpec.fileName != null) {
                tProtocol.writeFieldBegin(FILE_NAME_FIELD_DESC);
                tProtocol.writeString(fieldSpec.fileName);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(BASE_TABLE_ID_FIELD_DESC);
            tProtocol.writeI32(fieldSpec.baseTableId);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(FIELD_ID_FIELD_DESC);
            tProtocol.writeI32(fieldSpec.fieldId);
            tProtocol.writeFieldEnd();
            if (fieldSpec.fieldName != null) {
                tProtocol.writeFieldBegin(FIELD_NAME_FIELD_DESC);
                tProtocol.writeString(fieldSpec.fieldName);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(REPETITION_FIELD_DESC);
            tProtocol.writeI16(fieldSpec.repetition);
            tProtocol.writeFieldEnd();
            if (fieldSpec.fieldType != null) {
                tProtocol.writeFieldBegin(FIELD_TYPE_FIELD_DESC);
                tProtocol.writeI32(fieldSpec.fieldType.getValue());
                tProtocol.writeFieldEnd();
            }
            if (fieldSpec.fieldDataType != null) {
                tProtocol.writeFieldBegin(FIELD_DATA_TYPE_FIELD_DESC);
                tProtocol.writeI32(fieldSpec.fieldDataType.getValue());
                tProtocol.writeFieldEnd();
            }
            if (fieldSpec.fieldNameAliasForExport != null) {
                tProtocol.writeFieldBegin(FIELD_NAME_ALIAS_FOR_EXPORT_FIELD_DESC);
                tProtocol.writeString(fieldSpec.fieldNameAliasForExport);
                tProtocol.writeFieldEnd();
            }
            if (fieldSpec.fieldNameAliasForSort != null) {
                tProtocol.writeFieldBegin(FIELD_NAME_ALIAS_FOR_SORT_FIELD_DESC);
                tProtocol.writeString(fieldSpec.fieldNameAliasForSort);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

