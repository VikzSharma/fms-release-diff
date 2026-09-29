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

import com.filemaker.jwpc.iwp.thrift.common.MappingOption;
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

public class ImportMappingDefinition
implements TBase<ImportMappingDefinition, _Fields>,
Serializable,
Cloneable,
Comparable<ImportMappingDefinition> {
    private static final TStruct STRUCT_DESC = new TStruct("ImportMappingDefinition");
    private static final TField SOURCE_DATA_FIELD_DESC = new TField("sourceData", 11, 1);
    private static final TField TARGET_FIELD_FIELD_DESC = new TField("targetField", 11, 2);
    private static final TField FIELD_KEY_FIELD_DESC = new TField("fieldKey", 10, 3);
    private static final TField GLOBAL_FIELD_FIELD_DESC = new TField("globalField", 2, 4);
    private static final TField MAPPING_OPTION_FIELD_DESC = new TField("mappingOption", 8, 5);
    private static final TField SOURCE_DATA_PRESENT_FIELD_DESC = new TField("sourceDataPresent", 2, 6);
    private static final TField TARGET_FIELD_FLAGS_FIELD_DESC = new TField("targetFieldFlags", 8, 7);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new ImportMappingDefinitionStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new ImportMappingDefinitionTupleSchemeFactory();
    @Nullable
    private String sourceData;
    @Nullable
    private String targetField;
    private long fieldKey;
    private boolean globalField;
    @Nullable
    private MappingOption mappingOption;
    private boolean sourceDataPresent;
    private int targetFieldFlags;
    private static final int __FIELDKEY_ISSET_ID = 0;
    private static final int __GLOBALFIELD_ISSET_ID = 1;
    private static final int __SOURCEDATAPRESENT_ISSET_ID = 2;
    private static final int __TARGETFIELDFLAGS_ISSET_ID = 3;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public ImportMappingDefinition() {
    }

    public ImportMappingDefinition(String string, String string2, long l, boolean bl, MappingOption mappingOption, boolean bl2, int n) {
        this();
        this.sourceData = string;
        this.targetField = string2;
        this.fieldKey = l;
        this.setFieldKeyIsSet(true);
        this.globalField = bl;
        this.setGlobalFieldIsSet(true);
        this.mappingOption = mappingOption;
        this.sourceDataPresent = bl2;
        this.setSourceDataPresentIsSet(true);
        this.targetFieldFlags = n;
        this.setTargetFieldFlagsIsSet(true);
    }

    public ImportMappingDefinition(ImportMappingDefinition importMappingDefinition) {
        this.__isset_bitfield = importMappingDefinition.__isset_bitfield;
        if (importMappingDefinition.isSetSourceData()) {
            this.sourceData = importMappingDefinition.sourceData;
        }
        if (importMappingDefinition.isSetTargetField()) {
            this.targetField = importMappingDefinition.targetField;
        }
        this.fieldKey = importMappingDefinition.fieldKey;
        this.globalField = importMappingDefinition.globalField;
        if (importMappingDefinition.isSetMappingOption()) {
            this.mappingOption = importMappingDefinition.mappingOption;
        }
        this.sourceDataPresent = importMappingDefinition.sourceDataPresent;
        this.targetFieldFlags = importMappingDefinition.targetFieldFlags;
    }

    public ImportMappingDefinition deepCopy() {
        return new ImportMappingDefinition(this);
    }

    public void clear() {
        this.sourceData = null;
        this.targetField = null;
        this.setFieldKeyIsSet(false);
        this.fieldKey = 0L;
        this.setGlobalFieldIsSet(false);
        this.globalField = false;
        this.mappingOption = null;
        this.setSourceDataPresentIsSet(false);
        this.sourceDataPresent = false;
        this.setTargetFieldFlagsIsSet(false);
        this.targetFieldFlags = 0;
    }

    @Nullable
    public String getSourceData() {
        return this.sourceData;
    }

    public void setSourceData(@Nullable String string) {
        this.sourceData = string;
    }

    public void unsetSourceData() {
        this.sourceData = null;
    }

    public boolean isSetSourceData() {
        return this.sourceData != null;
    }

    public void setSourceDataIsSet(boolean bl) {
        if (!bl) {
            this.sourceData = null;
        }
    }

    @Nullable
    public String getTargetField() {
        return this.targetField;
    }

    public void setTargetField(@Nullable String string) {
        this.targetField = string;
    }

    public void unsetTargetField() {
        this.targetField = null;
    }

    public boolean isSetTargetField() {
        return this.targetField != null;
    }

    public void setTargetFieldIsSet(boolean bl) {
        if (!bl) {
            this.targetField = null;
        }
    }

    public long getFieldKey() {
        return this.fieldKey;
    }

    public void setFieldKey(long l) {
        this.fieldKey = l;
        this.setFieldKeyIsSet(true);
    }

    public void unsetFieldKey() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetFieldKey() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setFieldKeyIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public boolean isGlobalField() {
        return this.globalField;
    }

    public void setGlobalField(boolean bl) {
        this.globalField = bl;
        this.setGlobalFieldIsSet(true);
    }

    public void unsetGlobalField() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)1);
    }

    public boolean isSetGlobalField() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)1);
    }

    public void setGlobalFieldIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)1, (boolean)bl);
    }

    @Nullable
    public MappingOption getMappingOption() {
        return this.mappingOption;
    }

    public void setMappingOption(@Nullable MappingOption mappingOption) {
        this.mappingOption = mappingOption;
    }

    public void unsetMappingOption() {
        this.mappingOption = null;
    }

    public boolean isSetMappingOption() {
        return this.mappingOption != null;
    }

    public void setMappingOptionIsSet(boolean bl) {
        if (!bl) {
            this.mappingOption = null;
        }
    }

    public boolean isSourceDataPresent() {
        return this.sourceDataPresent;
    }

    public void setSourceDataPresent(boolean bl) {
        this.sourceDataPresent = bl;
        this.setSourceDataPresentIsSet(true);
    }

    public void unsetSourceDataPresent() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)2);
    }

    public boolean isSetSourceDataPresent() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)2);
    }

    public void setSourceDataPresentIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)2, (boolean)bl);
    }

    public int getTargetFieldFlags() {
        return this.targetFieldFlags;
    }

    public void setTargetFieldFlags(int n) {
        this.targetFieldFlags = n;
        this.setTargetFieldFlagsIsSet(true);
    }

    public void unsetTargetFieldFlags() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)3);
    }

    public boolean isSetTargetFieldFlags() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)3);
    }

    public void setTargetFieldFlagsIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)3, (boolean)bl);
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetSourceData();
                    break;
                }
                this.setSourceData((String)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetTargetField();
                    break;
                }
                this.setTargetField((String)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetFieldKey();
                    break;
                }
                this.setFieldKey((Long)object);
                break;
            }
            case 3: {
                if (object == null) {
                    this.unsetGlobalField();
                    break;
                }
                this.setGlobalField((Boolean)object);
                break;
            }
            case 4: {
                if (object == null) {
                    this.unsetMappingOption();
                    break;
                }
                this.setMappingOption((MappingOption)((Object)object));
                break;
            }
            case 5: {
                if (object == null) {
                    this.unsetSourceDataPresent();
                    break;
                }
                this.setSourceDataPresent((Boolean)object);
                break;
            }
            case 6: {
                if (object == null) {
                    this.unsetTargetFieldFlags();
                    break;
                }
                this.setTargetFieldFlags((Integer)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getSourceData();
            }
            case 1: {
                return this.getTargetField();
            }
            case 2: {
                return this.getFieldKey();
            }
            case 3: {
                return this.isGlobalField();
            }
            case 4: {
                return this.getMappingOption();
            }
            case 5: {
                return this.isSourceDataPresent();
            }
            case 6: {
                return this.getTargetFieldFlags();
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
                return this.isSetSourceData();
            }
            case 1: {
                return this.isSetTargetField();
            }
            case 2: {
                return this.isSetFieldKey();
            }
            case 3: {
                return this.isSetGlobalField();
            }
            case 4: {
                return this.isSetMappingOption();
            }
            case 5: {
                return this.isSetSourceDataPresent();
            }
            case 6: {
                return this.isSetTargetFieldFlags();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof ImportMappingDefinition) {
            return this.equals((ImportMappingDefinition)object);
        }
        return false;
    }

    public boolean equals(ImportMappingDefinition importMappingDefinition) {
        if (importMappingDefinition == null) {
            return false;
        }
        if (this == importMappingDefinition) {
            return true;
        }
        boolean bl = this.isSetSourceData();
        boolean bl2 = importMappingDefinition.isSetSourceData();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.sourceData.equals(importMappingDefinition.sourceData)) {
                return false;
            }
        }
        boolean bl3 = this.isSetTargetField();
        boolean bl4 = importMappingDefinition.isSetTargetField();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.targetField.equals(importMappingDefinition.targetField)) {
                return false;
            }
        }
        boolean bl5 = true;
        boolean bl6 = true;
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (this.fieldKey != importMappingDefinition.fieldKey) {
                return false;
            }
        }
        boolean bl7 = true;
        boolean bl8 = true;
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (this.globalField != importMappingDefinition.globalField) {
                return false;
            }
        }
        boolean bl9 = this.isSetMappingOption();
        boolean bl10 = importMappingDefinition.isSetMappingOption();
        if (bl9 || bl10) {
            if (!bl9 || !bl10) {
                return false;
            }
            if (!this.mappingOption.equals((Object)importMappingDefinition.mappingOption)) {
                return false;
            }
        }
        boolean bl11 = true;
        boolean bl12 = true;
        if (bl11 || bl12) {
            if (!bl11 || !bl12) {
                return false;
            }
            if (this.sourceDataPresent != importMappingDefinition.sourceDataPresent) {
                return false;
            }
        }
        boolean bl13 = true;
        boolean bl14 = true;
        if (bl13 || bl14) {
            if (!bl13 || !bl14) {
                return false;
            }
            if (this.targetFieldFlags != importMappingDefinition.targetFieldFlags) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetSourceData() ? 131071 : 524287);
        if (this.isSetSourceData()) {
            n = n * 8191 + this.sourceData.hashCode();
        }
        n = n * 8191 + (this.isSetTargetField() ? 131071 : 524287);
        if (this.isSetTargetField()) {
            n = n * 8191 + this.targetField.hashCode();
        }
        n = n * 8191 + TBaseHelper.hashCode((long)this.fieldKey);
        n = n * 8191 + (this.globalField ? 131071 : 524287);
        n = n * 8191 + (this.isSetMappingOption() ? 131071 : 524287);
        if (this.isSetMappingOption()) {
            n = n * 8191 + this.mappingOption.getValue();
        }
        n = n * 8191 + (this.sourceDataPresent ? 131071 : 524287);
        n = n * 8191 + this.targetFieldFlags;
        return n;
    }

    @Override
    public int compareTo(ImportMappingDefinition importMappingDefinition) {
        if (!this.getClass().equals(importMappingDefinition.getClass())) {
            return this.getClass().getName().compareTo(importMappingDefinition.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetSourceData(), importMappingDefinition.isSetSourceData());
        if (n != 0) {
            return n;
        }
        if (this.isSetSourceData() && (n = TBaseHelper.compareTo((String)this.sourceData, (String)importMappingDefinition.sourceData)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetTargetField(), importMappingDefinition.isSetTargetField());
        if (n != 0) {
            return n;
        }
        if (this.isSetTargetField() && (n = TBaseHelper.compareTo((String)this.targetField, (String)importMappingDefinition.targetField)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetFieldKey(), importMappingDefinition.isSetFieldKey());
        if (n != 0) {
            return n;
        }
        if (this.isSetFieldKey() && (n = TBaseHelper.compareTo((long)this.fieldKey, (long)importMappingDefinition.fieldKey)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetGlobalField(), importMappingDefinition.isSetGlobalField());
        if (n != 0) {
            return n;
        }
        if (this.isSetGlobalField() && (n = TBaseHelper.compareTo((boolean)this.globalField, (boolean)importMappingDefinition.globalField)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetMappingOption(), importMappingDefinition.isSetMappingOption());
        if (n != 0) {
            return n;
        }
        if (this.isSetMappingOption() && (n = TBaseHelper.compareTo((Comparable)((Object)this.mappingOption), (Comparable)((Object)importMappingDefinition.mappingOption))) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetSourceDataPresent(), importMappingDefinition.isSetSourceDataPresent());
        if (n != 0) {
            return n;
        }
        if (this.isSetSourceDataPresent() && (n = TBaseHelper.compareTo((boolean)this.sourceDataPresent, (boolean)importMappingDefinition.sourceDataPresent)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetTargetFieldFlags(), importMappingDefinition.isSetTargetFieldFlags());
        if (n != 0) {
            return n;
        }
        if (this.isSetTargetFieldFlags() && (n = TBaseHelper.compareTo((int)this.targetFieldFlags, (int)importMappingDefinition.targetFieldFlags)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        ImportMappingDefinition.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        ImportMappingDefinition.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ImportMappingDefinition(");
        boolean bl = true;
        stringBuilder.append("sourceData:");
        if (this.sourceData == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.sourceData);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("targetField:");
        if (this.targetField == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.targetField);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("fieldKey:");
        stringBuilder.append(this.fieldKey);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("globalField:");
        stringBuilder.append(this.globalField);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("mappingOption:");
        if (this.mappingOption == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append((Object)this.mappingOption);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("sourceDataPresent:");
        stringBuilder.append(this.sourceDataPresent);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("targetFieldFlags:");
        stringBuilder.append(this.targetFieldFlags);
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
        enumMap.put(_Fields.SOURCE_DATA, new FieldMetaData("sourceData", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.TARGET_FIELD, new FieldMetaData("targetField", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.FIELD_KEY, new FieldMetaData("fieldKey", 3, new FieldValueMetaData(10)));
        enumMap.put(_Fields.GLOBAL_FIELD, new FieldMetaData("globalField", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.MAPPING_OPTION, new FieldMetaData("mappingOption", 3, (FieldValueMetaData)new EnumMetaData(-1, MappingOption.class)));
        enumMap.put(_Fields.SOURCE_DATA_PRESENT, new FieldMetaData("sourceDataPresent", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.TARGET_FIELD_FLAGS, new FieldMetaData("targetFieldFlags", 3, new FieldValueMetaData(8)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(ImportMappingDefinition.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        SOURCE_DATA(1, "sourceData"),
        TARGET_FIELD(2, "targetField"),
        FIELD_KEY(3, "fieldKey"),
        GLOBAL_FIELD(4, "globalField"),
        MAPPING_OPTION(5, "mappingOption"),
        SOURCE_DATA_PRESENT(6, "sourceDataPresent"),
        TARGET_FIELD_FLAGS(7, "targetFieldFlags");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return SOURCE_DATA;
                }
                case 2: {
                    return TARGET_FIELD;
                }
                case 3: {
                    return FIELD_KEY;
                }
                case 4: {
                    return GLOBAL_FIELD;
                }
                case 5: {
                    return MAPPING_OPTION;
                }
                case 6: {
                    return SOURCE_DATA_PRESENT;
                }
                case 7: {
                    return TARGET_FIELD_FLAGS;
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

    private static class ImportMappingDefinitionStandardSchemeFactory
    implements SchemeFactory {
        private ImportMappingDefinitionStandardSchemeFactory() {
        }

        public ImportMappingDefinitionStandardScheme getScheme() {
            return new ImportMappingDefinitionStandardScheme();
        }
    }

    private static class ImportMappingDefinitionTupleSchemeFactory
    implements SchemeFactory {
        private ImportMappingDefinitionTupleSchemeFactory() {
        }

        public ImportMappingDefinitionTupleScheme getScheme() {
            return new ImportMappingDefinitionTupleScheme();
        }
    }

    private static class ImportMappingDefinitionTupleScheme
    extends TupleScheme<ImportMappingDefinition> {
        private ImportMappingDefinitionTupleScheme() {
        }

        public void write(TProtocol tProtocol, ImportMappingDefinition importMappingDefinition) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (importMappingDefinition.isSetSourceData()) {
                bitSet.set(0);
            }
            if (importMappingDefinition.isSetTargetField()) {
                bitSet.set(1);
            }
            if (importMappingDefinition.isSetFieldKey()) {
                bitSet.set(2);
            }
            if (importMappingDefinition.isSetGlobalField()) {
                bitSet.set(3);
            }
            if (importMappingDefinition.isSetMappingOption()) {
                bitSet.set(4);
            }
            if (importMappingDefinition.isSetSourceDataPresent()) {
                bitSet.set(5);
            }
            if (importMappingDefinition.isSetTargetFieldFlags()) {
                bitSet.set(6);
            }
            tTupleProtocol.writeBitSet(bitSet, 7);
            if (importMappingDefinition.isSetSourceData()) {
                tTupleProtocol.writeString(importMappingDefinition.sourceData);
            }
            if (importMappingDefinition.isSetTargetField()) {
                tTupleProtocol.writeString(importMappingDefinition.targetField);
            }
            if (importMappingDefinition.isSetFieldKey()) {
                tTupleProtocol.writeI64(importMappingDefinition.fieldKey);
            }
            if (importMappingDefinition.isSetGlobalField()) {
                tTupleProtocol.writeBool(importMappingDefinition.globalField);
            }
            if (importMappingDefinition.isSetMappingOption()) {
                tTupleProtocol.writeI32(importMappingDefinition.mappingOption.getValue());
            }
            if (importMappingDefinition.isSetSourceDataPresent()) {
                tTupleProtocol.writeBool(importMappingDefinition.sourceDataPresent);
            }
            if (importMappingDefinition.isSetTargetFieldFlags()) {
                tTupleProtocol.writeI32(importMappingDefinition.targetFieldFlags);
            }
        }

        public void read(TProtocol tProtocol, ImportMappingDefinition importMappingDefinition) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(7);
            if (bitSet.get(0)) {
                importMappingDefinition.sourceData = tTupleProtocol.readString();
                importMappingDefinition.setSourceDataIsSet(true);
            }
            if (bitSet.get(1)) {
                importMappingDefinition.targetField = tTupleProtocol.readString();
                importMappingDefinition.setTargetFieldIsSet(true);
            }
            if (bitSet.get(2)) {
                importMappingDefinition.fieldKey = tTupleProtocol.readI64();
                importMappingDefinition.setFieldKeyIsSet(true);
            }
            if (bitSet.get(3)) {
                importMappingDefinition.globalField = tTupleProtocol.readBool();
                importMappingDefinition.setGlobalFieldIsSet(true);
            }
            if (bitSet.get(4)) {
                importMappingDefinition.mappingOption = MappingOption.findByValue(tTupleProtocol.readI32());
                importMappingDefinition.setMappingOptionIsSet(true);
            }
            if (bitSet.get(5)) {
                importMappingDefinition.sourceDataPresent = tTupleProtocol.readBool();
                importMappingDefinition.setSourceDataPresentIsSet(true);
            }
            if (bitSet.get(6)) {
                importMappingDefinition.targetFieldFlags = tTupleProtocol.readI32();
                importMappingDefinition.setTargetFieldFlagsIsSet(true);
            }
        }
    }

    private static class ImportMappingDefinitionStandardScheme
    extends StandardScheme<ImportMappingDefinition> {
        private ImportMappingDefinitionStandardScheme() {
        }

        public void read(TProtocol tProtocol, ImportMappingDefinition importMappingDefinition) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 11) {
                            importMappingDefinition.sourceData = tProtocol.readString();
                            importMappingDefinition.setSourceDataIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 11) {
                            importMappingDefinition.targetField = tProtocol.readString();
                            importMappingDefinition.setTargetFieldIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 10) {
                            importMappingDefinition.fieldKey = tProtocol.readI64();
                            importMappingDefinition.setFieldKeyIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 2) {
                            importMappingDefinition.globalField = tProtocol.readBool();
                            importMappingDefinition.setGlobalFieldIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 5: {
                        if (tField.type == 8) {
                            importMappingDefinition.mappingOption = MappingOption.findByValue(tProtocol.readI32());
                            importMappingDefinition.setMappingOptionIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 6: {
                        if (tField.type == 2) {
                            importMappingDefinition.sourceDataPresent = tProtocol.readBool();
                            importMappingDefinition.setSourceDataPresentIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 7: {
                        if (tField.type == 8) {
                            importMappingDefinition.targetFieldFlags = tProtocol.readI32();
                            importMappingDefinition.setTargetFieldFlagsIsSet(true);
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
            importMappingDefinition.validate();
        }

        public void write(TProtocol tProtocol, ImportMappingDefinition importMappingDefinition) throws TException {
            importMappingDefinition.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (importMappingDefinition.sourceData != null) {
                tProtocol.writeFieldBegin(SOURCE_DATA_FIELD_DESC);
                tProtocol.writeString(importMappingDefinition.sourceData);
                tProtocol.writeFieldEnd();
            }
            if (importMappingDefinition.targetField != null) {
                tProtocol.writeFieldBegin(TARGET_FIELD_FIELD_DESC);
                tProtocol.writeString(importMappingDefinition.targetField);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(FIELD_KEY_FIELD_DESC);
            tProtocol.writeI64(importMappingDefinition.fieldKey);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(GLOBAL_FIELD_FIELD_DESC);
            tProtocol.writeBool(importMappingDefinition.globalField);
            tProtocol.writeFieldEnd();
            if (importMappingDefinition.mappingOption != null) {
                tProtocol.writeFieldBegin(MAPPING_OPTION_FIELD_DESC);
                tProtocol.writeI32(importMappingDefinition.mappingOption.getValue());
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(SOURCE_DATA_PRESENT_FIELD_DESC);
            tProtocol.writeBool(importMappingDefinition.sourceDataPresent);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(TARGET_FIELD_FLAGS_FIELD_DESC);
            tProtocol.writeI32(importMappingDefinition.targetFieldFlags);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

