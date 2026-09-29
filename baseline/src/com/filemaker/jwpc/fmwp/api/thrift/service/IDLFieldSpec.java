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
package com.filemaker.jwpc.fmwp.api.thrift.service;

import com.filemaker.jwpc.fmwp.api.thrift.service.DataType;
import com.filemaker.jwpc.fmwp.api.thrift.service.FieldType;
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

public class IDLFieldSpec
implements TBase<IDLFieldSpec, _Fields>,
Serializable,
Cloneable,
Comparable<IDLFieldSpec> {
    private static final TStruct STRUCT_DESC = new TStruct("IDLFieldSpec");
    private static final TField NAME_FIELD_DESC = new TField("name", 11, 1);
    private static final TField OPTIONS_FIELD_DESC = new TField("options", 8, 2);
    private static final TField VALIDATIONS_FIELD_DESC = new TField("validations", 8, 3);
    private static final TField MAX_REPEAT_FIELD_DESC = new TField("maxRepeat", 6, 4);
    private static final TField MAX_CHARS_FIELD_DESC = new TField("maxChars", 8, 5);
    private static final TField TYPE_FIELD_DESC = new TField("type", 8, 6);
    private static final TField DATA_TYPE_FIELD_DESC = new TField("dataType", 8, 7);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new IDLFieldSpecStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new IDLFieldSpecTupleSchemeFactory();
    @Nullable
    private String name;
    private int options;
    private int validations;
    private short maxRepeat;
    private int maxChars;
    @Nullable
    private FieldType type;
    @Nullable
    private DataType dataType;
    private static final int __OPTIONS_ISSET_ID = 0;
    private static final int __VALIDATIONS_ISSET_ID = 1;
    private static final int __MAXREPEAT_ISSET_ID = 2;
    private static final int __MAXCHARS_ISSET_ID = 3;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public IDLFieldSpec() {
    }

    public IDLFieldSpec(String string, int n, int n2, short s, int n3, FieldType fieldType, DataType dataType) {
        this();
        this.name = string;
        this.options = n;
        this.setOptionsIsSet(true);
        this.validations = n2;
        this.setValidationsIsSet(true);
        this.maxRepeat = s;
        this.setMaxRepeatIsSet(true);
        this.maxChars = n3;
        this.setMaxCharsIsSet(true);
        this.type = fieldType;
        this.dataType = dataType;
    }

    public IDLFieldSpec(IDLFieldSpec iDLFieldSpec) {
        this.__isset_bitfield = iDLFieldSpec.__isset_bitfield;
        if (iDLFieldSpec.isSetName()) {
            this.name = iDLFieldSpec.name;
        }
        this.options = iDLFieldSpec.options;
        this.validations = iDLFieldSpec.validations;
        this.maxRepeat = iDLFieldSpec.maxRepeat;
        this.maxChars = iDLFieldSpec.maxChars;
        if (iDLFieldSpec.isSetType()) {
            this.type = iDLFieldSpec.type;
        }
        if (iDLFieldSpec.isSetDataType()) {
            this.dataType = iDLFieldSpec.dataType;
        }
    }

    public IDLFieldSpec deepCopy() {
        return new IDLFieldSpec(this);
    }

    public void clear() {
        this.name = null;
        this.setOptionsIsSet(false);
        this.options = 0;
        this.setValidationsIsSet(false);
        this.validations = 0;
        this.setMaxRepeatIsSet(false);
        this.maxRepeat = 0;
        this.setMaxCharsIsSet(false);
        this.maxChars = 0;
        this.type = null;
        this.dataType = null;
    }

    @Nullable
    public String getName() {
        return this.name;
    }

    public void setName(@Nullable String string) {
        this.name = string;
    }

    public void unsetName() {
        this.name = null;
    }

    public boolean isSetName() {
        return this.name != null;
    }

    public void setNameIsSet(boolean bl) {
        if (!bl) {
            this.name = null;
        }
    }

    public int getOptions() {
        return this.options;
    }

    public void setOptions(int n) {
        this.options = n;
        this.setOptionsIsSet(true);
    }

    public void unsetOptions() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetOptions() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setOptionsIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public int getValidations() {
        return this.validations;
    }

    public void setValidations(int n) {
        this.validations = n;
        this.setValidationsIsSet(true);
    }

    public void unsetValidations() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)1);
    }

    public boolean isSetValidations() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)1);
    }

    public void setValidationsIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)1, (boolean)bl);
    }

    public short getMaxRepeat() {
        return this.maxRepeat;
    }

    public void setMaxRepeat(short s) {
        this.maxRepeat = s;
        this.setMaxRepeatIsSet(true);
    }

    public void unsetMaxRepeat() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)2);
    }

    public boolean isSetMaxRepeat() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)2);
    }

    public void setMaxRepeatIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)2, (boolean)bl);
    }

    public int getMaxChars() {
        return this.maxChars;
    }

    public void setMaxChars(int n) {
        this.maxChars = n;
        this.setMaxCharsIsSet(true);
    }

    public void unsetMaxChars() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)3);
    }

    public boolean isSetMaxChars() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)3);
    }

    public void setMaxCharsIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)3, (boolean)bl);
    }

    @Nullable
    public FieldType getType() {
        return this.type;
    }

    public void setType(@Nullable FieldType fieldType) {
        this.type = fieldType;
    }

    public void unsetType() {
        this.type = null;
    }

    public boolean isSetType() {
        return this.type != null;
    }

    public void setTypeIsSet(boolean bl) {
        if (!bl) {
            this.type = null;
        }
    }

    @Nullable
    public DataType getDataType() {
        return this.dataType;
    }

    public void setDataType(@Nullable DataType dataType) {
        this.dataType = dataType;
    }

    public void unsetDataType() {
        this.dataType = null;
    }

    public boolean isSetDataType() {
        return this.dataType != null;
    }

    public void setDataTypeIsSet(boolean bl) {
        if (!bl) {
            this.dataType = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetName();
                    break;
                }
                this.setName((String)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetOptions();
                    break;
                }
                this.setOptions((Integer)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetValidations();
                    break;
                }
                this.setValidations((Integer)object);
                break;
            }
            case 3: {
                if (object == null) {
                    this.unsetMaxRepeat();
                    break;
                }
                this.setMaxRepeat((Short)object);
                break;
            }
            case 4: {
                if (object == null) {
                    this.unsetMaxChars();
                    break;
                }
                this.setMaxChars((Integer)object);
                break;
            }
            case 5: {
                if (object == null) {
                    this.unsetType();
                    break;
                }
                this.setType((FieldType)((Object)object));
                break;
            }
            case 6: {
                if (object == null) {
                    this.unsetDataType();
                    break;
                }
                this.setDataType((DataType)((Object)object));
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getName();
            }
            case 1: {
                return this.getOptions();
            }
            case 2: {
                return this.getValidations();
            }
            case 3: {
                return this.getMaxRepeat();
            }
            case 4: {
                return this.getMaxChars();
            }
            case 5: {
                return this.getType();
            }
            case 6: {
                return this.getDataType();
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
                return this.isSetName();
            }
            case 1: {
                return this.isSetOptions();
            }
            case 2: {
                return this.isSetValidations();
            }
            case 3: {
                return this.isSetMaxRepeat();
            }
            case 4: {
                return this.isSetMaxChars();
            }
            case 5: {
                return this.isSetType();
            }
            case 6: {
                return this.isSetDataType();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof IDLFieldSpec) {
            return this.equals((IDLFieldSpec)object);
        }
        return false;
    }

    public boolean equals(IDLFieldSpec iDLFieldSpec) {
        if (iDLFieldSpec == null) {
            return false;
        }
        if (this == iDLFieldSpec) {
            return true;
        }
        boolean bl = this.isSetName();
        boolean bl2 = iDLFieldSpec.isSetName();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.name.equals(iDLFieldSpec.name)) {
                return false;
            }
        }
        boolean bl3 = true;
        boolean bl4 = true;
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (this.options != iDLFieldSpec.options) {
                return false;
            }
        }
        boolean bl5 = true;
        boolean bl6 = true;
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (this.validations != iDLFieldSpec.validations) {
                return false;
            }
        }
        boolean bl7 = true;
        boolean bl8 = true;
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (this.maxRepeat != iDLFieldSpec.maxRepeat) {
                return false;
            }
        }
        boolean bl9 = true;
        boolean bl10 = true;
        if (bl9 || bl10) {
            if (!bl9 || !bl10) {
                return false;
            }
            if (this.maxChars != iDLFieldSpec.maxChars) {
                return false;
            }
        }
        boolean bl11 = this.isSetType();
        boolean bl12 = iDLFieldSpec.isSetType();
        if (bl11 || bl12) {
            if (!bl11 || !bl12) {
                return false;
            }
            if (!this.type.equals((Object)iDLFieldSpec.type)) {
                return false;
            }
        }
        boolean bl13 = this.isSetDataType();
        boolean bl14 = iDLFieldSpec.isSetDataType();
        if (bl13 || bl14) {
            if (!bl13 || !bl14) {
                return false;
            }
            if (!this.dataType.equals((Object)iDLFieldSpec.dataType)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetName() ? 131071 : 524287);
        if (this.isSetName()) {
            n = n * 8191 + this.name.hashCode();
        }
        n = n * 8191 + this.options;
        n = n * 8191 + this.validations;
        n = n * 8191 + this.maxRepeat;
        n = n * 8191 + this.maxChars;
        n = n * 8191 + (this.isSetType() ? 131071 : 524287);
        if (this.isSetType()) {
            n = n * 8191 + this.type.getValue();
        }
        n = n * 8191 + (this.isSetDataType() ? 131071 : 524287);
        if (this.isSetDataType()) {
            n = n * 8191 + this.dataType.getValue();
        }
        return n;
    }

    @Override
    public int compareTo(IDLFieldSpec iDLFieldSpec) {
        if (!this.getClass().equals(iDLFieldSpec.getClass())) {
            return this.getClass().getName().compareTo(iDLFieldSpec.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetName(), iDLFieldSpec.isSetName());
        if (n != 0) {
            return n;
        }
        if (this.isSetName() && (n = TBaseHelper.compareTo((String)this.name, (String)iDLFieldSpec.name)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetOptions(), iDLFieldSpec.isSetOptions());
        if (n != 0) {
            return n;
        }
        if (this.isSetOptions() && (n = TBaseHelper.compareTo((int)this.options, (int)iDLFieldSpec.options)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetValidations(), iDLFieldSpec.isSetValidations());
        if (n != 0) {
            return n;
        }
        if (this.isSetValidations() && (n = TBaseHelper.compareTo((int)this.validations, (int)iDLFieldSpec.validations)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetMaxRepeat(), iDLFieldSpec.isSetMaxRepeat());
        if (n != 0) {
            return n;
        }
        if (this.isSetMaxRepeat() && (n = TBaseHelper.compareTo((short)this.maxRepeat, (short)iDLFieldSpec.maxRepeat)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetMaxChars(), iDLFieldSpec.isSetMaxChars());
        if (n != 0) {
            return n;
        }
        if (this.isSetMaxChars() && (n = TBaseHelper.compareTo((int)this.maxChars, (int)iDLFieldSpec.maxChars)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetType(), iDLFieldSpec.isSetType());
        if (n != 0) {
            return n;
        }
        if (this.isSetType() && (n = TBaseHelper.compareTo((Comparable)((Object)this.type), (Comparable)((Object)iDLFieldSpec.type))) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetDataType(), iDLFieldSpec.isSetDataType());
        if (n != 0) {
            return n;
        }
        if (this.isSetDataType() && (n = TBaseHelper.compareTo((Comparable)((Object)this.dataType), (Comparable)((Object)iDLFieldSpec.dataType))) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        IDLFieldSpec.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        IDLFieldSpec.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("IDLFieldSpec(");
        boolean bl = true;
        stringBuilder.append("name:");
        if (this.name == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.name);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("options:");
        stringBuilder.append(this.options);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("validations:");
        stringBuilder.append(this.validations);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("maxRepeat:");
        stringBuilder.append(this.maxRepeat);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("maxChars:");
        stringBuilder.append(this.maxChars);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("type:");
        if (this.type == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append((Object)this.type);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("dataType:");
        if (this.dataType == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append((Object)this.dataType);
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
        enumMap.put(_Fields.NAME, new FieldMetaData("name", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.OPTIONS, new FieldMetaData("options", 3, new FieldValueMetaData(8, "Bitmap")));
        enumMap.put(_Fields.VALIDATIONS, new FieldMetaData("validations", 3, new FieldValueMetaData(8, "Bitmap")));
        enumMap.put(_Fields.MAX_REPEAT, new FieldMetaData("maxRepeat", 3, new FieldValueMetaData(6)));
        enumMap.put(_Fields.MAX_CHARS, new FieldMetaData("maxChars", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.TYPE, new FieldMetaData("type", 3, (FieldValueMetaData)new EnumMetaData(-1, FieldType.class)));
        enumMap.put(_Fields.DATA_TYPE, new FieldMetaData("dataType", 3, (FieldValueMetaData)new EnumMetaData(-1, DataType.class)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(IDLFieldSpec.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        NAME(1, "name"),
        OPTIONS(2, "options"),
        VALIDATIONS(3, "validations"),
        MAX_REPEAT(4, "maxRepeat"),
        MAX_CHARS(5, "maxChars"),
        TYPE(6, "type"),
        DATA_TYPE(7, "dataType");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return NAME;
                }
                case 2: {
                    return OPTIONS;
                }
                case 3: {
                    return VALIDATIONS;
                }
                case 4: {
                    return MAX_REPEAT;
                }
                case 5: {
                    return MAX_CHARS;
                }
                case 6: {
                    return TYPE;
                }
                case 7: {
                    return DATA_TYPE;
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

    private static class IDLFieldSpecStandardSchemeFactory
    implements SchemeFactory {
        private IDLFieldSpecStandardSchemeFactory() {
        }

        public IDLFieldSpecStandardScheme getScheme() {
            return new IDLFieldSpecStandardScheme();
        }
    }

    private static class IDLFieldSpecTupleSchemeFactory
    implements SchemeFactory {
        private IDLFieldSpecTupleSchemeFactory() {
        }

        public IDLFieldSpecTupleScheme getScheme() {
            return new IDLFieldSpecTupleScheme();
        }
    }

    private static class IDLFieldSpecTupleScheme
    extends TupleScheme<IDLFieldSpec> {
        private IDLFieldSpecTupleScheme() {
        }

        public void write(TProtocol tProtocol, IDLFieldSpec iDLFieldSpec) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (iDLFieldSpec.isSetName()) {
                bitSet.set(0);
            }
            if (iDLFieldSpec.isSetOptions()) {
                bitSet.set(1);
            }
            if (iDLFieldSpec.isSetValidations()) {
                bitSet.set(2);
            }
            if (iDLFieldSpec.isSetMaxRepeat()) {
                bitSet.set(3);
            }
            if (iDLFieldSpec.isSetMaxChars()) {
                bitSet.set(4);
            }
            if (iDLFieldSpec.isSetType()) {
                bitSet.set(5);
            }
            if (iDLFieldSpec.isSetDataType()) {
                bitSet.set(6);
            }
            tTupleProtocol.writeBitSet(bitSet, 7);
            if (iDLFieldSpec.isSetName()) {
                tTupleProtocol.writeString(iDLFieldSpec.name);
            }
            if (iDLFieldSpec.isSetOptions()) {
                tTupleProtocol.writeI32(iDLFieldSpec.options);
            }
            if (iDLFieldSpec.isSetValidations()) {
                tTupleProtocol.writeI32(iDLFieldSpec.validations);
            }
            if (iDLFieldSpec.isSetMaxRepeat()) {
                tTupleProtocol.writeI16(iDLFieldSpec.maxRepeat);
            }
            if (iDLFieldSpec.isSetMaxChars()) {
                tTupleProtocol.writeI32(iDLFieldSpec.maxChars);
            }
            if (iDLFieldSpec.isSetType()) {
                tTupleProtocol.writeI32(iDLFieldSpec.type.getValue());
            }
            if (iDLFieldSpec.isSetDataType()) {
                tTupleProtocol.writeI32(iDLFieldSpec.dataType.getValue());
            }
        }

        public void read(TProtocol tProtocol, IDLFieldSpec iDLFieldSpec) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(7);
            if (bitSet.get(0)) {
                iDLFieldSpec.name = tTupleProtocol.readString();
                iDLFieldSpec.setNameIsSet(true);
            }
            if (bitSet.get(1)) {
                iDLFieldSpec.options = tTupleProtocol.readI32();
                iDLFieldSpec.setOptionsIsSet(true);
            }
            if (bitSet.get(2)) {
                iDLFieldSpec.validations = tTupleProtocol.readI32();
                iDLFieldSpec.setValidationsIsSet(true);
            }
            if (bitSet.get(3)) {
                iDLFieldSpec.maxRepeat = tTupleProtocol.readI16();
                iDLFieldSpec.setMaxRepeatIsSet(true);
            }
            if (bitSet.get(4)) {
                iDLFieldSpec.maxChars = tTupleProtocol.readI32();
                iDLFieldSpec.setMaxCharsIsSet(true);
            }
            if (bitSet.get(5)) {
                iDLFieldSpec.type = FieldType.findByValue(tTupleProtocol.readI32());
                iDLFieldSpec.setTypeIsSet(true);
            }
            if (bitSet.get(6)) {
                iDLFieldSpec.dataType = DataType.findByValue(tTupleProtocol.readI32());
                iDLFieldSpec.setDataTypeIsSet(true);
            }
        }
    }

    private static class IDLFieldSpecStandardScheme
    extends StandardScheme<IDLFieldSpec> {
        private IDLFieldSpecStandardScheme() {
        }

        public void read(TProtocol tProtocol, IDLFieldSpec iDLFieldSpec) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 11) {
                            iDLFieldSpec.name = tProtocol.readString();
                            iDLFieldSpec.setNameIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 8) {
                            iDLFieldSpec.options = tProtocol.readI32();
                            iDLFieldSpec.setOptionsIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 8) {
                            iDLFieldSpec.validations = tProtocol.readI32();
                            iDLFieldSpec.setValidationsIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 6) {
                            iDLFieldSpec.maxRepeat = tProtocol.readI16();
                            iDLFieldSpec.setMaxRepeatIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 5: {
                        if (tField.type == 8) {
                            iDLFieldSpec.maxChars = tProtocol.readI32();
                            iDLFieldSpec.setMaxCharsIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 6: {
                        if (tField.type == 8) {
                            iDLFieldSpec.type = FieldType.findByValue(tProtocol.readI32());
                            iDLFieldSpec.setTypeIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 7: {
                        if (tField.type == 8) {
                            iDLFieldSpec.dataType = DataType.findByValue(tProtocol.readI32());
                            iDLFieldSpec.setDataTypeIsSet(true);
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
            iDLFieldSpec.validate();
        }

        public void write(TProtocol tProtocol, IDLFieldSpec iDLFieldSpec) throws TException {
            iDLFieldSpec.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (iDLFieldSpec.name != null) {
                tProtocol.writeFieldBegin(NAME_FIELD_DESC);
                tProtocol.writeString(iDLFieldSpec.name);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(OPTIONS_FIELD_DESC);
            tProtocol.writeI32(iDLFieldSpec.options);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(VALIDATIONS_FIELD_DESC);
            tProtocol.writeI32(iDLFieldSpec.validations);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(MAX_REPEAT_FIELD_DESC);
            tProtocol.writeI16(iDLFieldSpec.maxRepeat);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(MAX_CHARS_FIELD_DESC);
            tProtocol.writeI32(iDLFieldSpec.maxChars);
            tProtocol.writeFieldEnd();
            if (iDLFieldSpec.type != null) {
                tProtocol.writeFieldBegin(TYPE_FIELD_DESC);
                tProtocol.writeI32(iDLFieldSpec.type.getValue());
                tProtocol.writeFieldEnd();
            }
            if (iDLFieldSpec.dataType != null) {
                tProtocol.writeFieldBegin(DATA_TYPE_FIELD_DESC);
                tProtocol.writeI32(iDLFieldSpec.dataType.getValue());
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

