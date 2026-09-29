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

public class ExportGroupByInfo
implements TBase<ExportGroupByInfo, _Fields>,
Serializable,
Cloneable,
Comparable<ExportGroupByInfo> {
    private static final TStruct STRUCT_DESC = new TStruct("ExportGroupByInfo");
    private static final TField FIELD_NAME_FIELD_DESC = new TField("fieldName", 11, 1);
    private static final TField FIELD_CHECKED_FIELD_DESC = new TField("fieldChecked", 2, 2);
    private static final TField FIELD_NAME_ALIAS_FOR_EXPORT_FIELD_DESC = new TField("fieldNameAliasForExport", 11, 3);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new ExportGroupByInfoStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new ExportGroupByInfoTupleSchemeFactory();
    @Nullable
    private String fieldName;
    private boolean fieldChecked;
    @Nullable
    private String fieldNameAliasForExport;
    private static final int __FIELDCHECKED_ISSET_ID = 0;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public ExportGroupByInfo() {
    }

    public ExportGroupByInfo(String string, boolean bl, String string2) {
        this();
        this.fieldName = string;
        this.fieldChecked = bl;
        this.setFieldCheckedIsSet(true);
        this.fieldNameAliasForExport = string2;
    }

    public ExportGroupByInfo(ExportGroupByInfo exportGroupByInfo) {
        this.__isset_bitfield = exportGroupByInfo.__isset_bitfield;
        if (exportGroupByInfo.isSetFieldName()) {
            this.fieldName = exportGroupByInfo.fieldName;
        }
        this.fieldChecked = exportGroupByInfo.fieldChecked;
        if (exportGroupByInfo.isSetFieldNameAliasForExport()) {
            this.fieldNameAliasForExport = exportGroupByInfo.fieldNameAliasForExport;
        }
    }

    public ExportGroupByInfo deepCopy() {
        return new ExportGroupByInfo(this);
    }

    public void clear() {
        this.fieldName = null;
        this.setFieldCheckedIsSet(false);
        this.fieldChecked = false;
        this.fieldNameAliasForExport = null;
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

    public boolean isFieldChecked() {
        return this.fieldChecked;
    }

    public void setFieldChecked(boolean bl) {
        this.fieldChecked = bl;
        this.setFieldCheckedIsSet(true);
    }

    public void unsetFieldChecked() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetFieldChecked() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setFieldCheckedIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
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
                    this.unsetFieldChecked();
                    break;
                }
                this.setFieldChecked((Boolean)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetFieldNameAliasForExport();
                    break;
                }
                this.setFieldNameAliasForExport((String)object);
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
                return this.isFieldChecked();
            }
            case 2: {
                return this.getFieldNameAliasForExport();
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
                return this.isSetFieldChecked();
            }
            case 2: {
                return this.isSetFieldNameAliasForExport();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof ExportGroupByInfo) {
            return this.equals((ExportGroupByInfo)object);
        }
        return false;
    }

    public boolean equals(ExportGroupByInfo exportGroupByInfo) {
        if (exportGroupByInfo == null) {
            return false;
        }
        if (this == exportGroupByInfo) {
            return true;
        }
        boolean bl = this.isSetFieldName();
        boolean bl2 = exportGroupByInfo.isSetFieldName();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.fieldName.equals(exportGroupByInfo.fieldName)) {
                return false;
            }
        }
        boolean bl3 = true;
        boolean bl4 = true;
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (this.fieldChecked != exportGroupByInfo.fieldChecked) {
                return false;
            }
        }
        boolean bl5 = this.isSetFieldNameAliasForExport();
        boolean bl6 = exportGroupByInfo.isSetFieldNameAliasForExport();
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (!this.fieldNameAliasForExport.equals(exportGroupByInfo.fieldNameAliasForExport)) {
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
        n = n * 8191 + (this.fieldChecked ? 131071 : 524287);
        n = n * 8191 + (this.isSetFieldNameAliasForExport() ? 131071 : 524287);
        if (this.isSetFieldNameAliasForExport()) {
            n = n * 8191 + this.fieldNameAliasForExport.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(ExportGroupByInfo exportGroupByInfo) {
        if (!this.getClass().equals(exportGroupByInfo.getClass())) {
            return this.getClass().getName().compareTo(exportGroupByInfo.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetFieldName(), exportGroupByInfo.isSetFieldName());
        if (n != 0) {
            return n;
        }
        if (this.isSetFieldName() && (n = TBaseHelper.compareTo((String)this.fieldName, (String)exportGroupByInfo.fieldName)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetFieldChecked(), exportGroupByInfo.isSetFieldChecked());
        if (n != 0) {
            return n;
        }
        if (this.isSetFieldChecked() && (n = TBaseHelper.compareTo((boolean)this.fieldChecked, (boolean)exportGroupByInfo.fieldChecked)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetFieldNameAliasForExport(), exportGroupByInfo.isSetFieldNameAliasForExport());
        if (n != 0) {
            return n;
        }
        if (this.isSetFieldNameAliasForExport() && (n = TBaseHelper.compareTo((String)this.fieldNameAliasForExport, (String)exportGroupByInfo.fieldNameAliasForExport)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        ExportGroupByInfo.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        ExportGroupByInfo.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ExportGroupByInfo(");
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
        stringBuilder.append("fieldChecked:");
        stringBuilder.append(this.fieldChecked);
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
        enumMap.put(_Fields.FIELD_CHECKED, new FieldMetaData("fieldChecked", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.FIELD_NAME_ALIAS_FOR_EXPORT, new FieldMetaData("fieldNameAliasForExport", 3, new FieldValueMetaData(11)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(ExportGroupByInfo.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        FIELD_NAME(1, "fieldName"),
        FIELD_CHECKED(2, "fieldChecked"),
        FIELD_NAME_ALIAS_FOR_EXPORT(3, "fieldNameAliasForExport");

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
                    return FIELD_CHECKED;
                }
                case 3: {
                    return FIELD_NAME_ALIAS_FOR_EXPORT;
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

    private static class ExportGroupByInfoStandardSchemeFactory
    implements SchemeFactory {
        private ExportGroupByInfoStandardSchemeFactory() {
        }

        public ExportGroupByInfoStandardScheme getScheme() {
            return new ExportGroupByInfoStandardScheme();
        }
    }

    private static class ExportGroupByInfoTupleSchemeFactory
    implements SchemeFactory {
        private ExportGroupByInfoTupleSchemeFactory() {
        }

        public ExportGroupByInfoTupleScheme getScheme() {
            return new ExportGroupByInfoTupleScheme();
        }
    }

    private static class ExportGroupByInfoTupleScheme
    extends TupleScheme<ExportGroupByInfo> {
        private ExportGroupByInfoTupleScheme() {
        }

        public void write(TProtocol tProtocol, ExportGroupByInfo exportGroupByInfo) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (exportGroupByInfo.isSetFieldName()) {
                bitSet.set(0);
            }
            if (exportGroupByInfo.isSetFieldChecked()) {
                bitSet.set(1);
            }
            if (exportGroupByInfo.isSetFieldNameAliasForExport()) {
                bitSet.set(2);
            }
            tTupleProtocol.writeBitSet(bitSet, 3);
            if (exportGroupByInfo.isSetFieldName()) {
                tTupleProtocol.writeString(exportGroupByInfo.fieldName);
            }
            if (exportGroupByInfo.isSetFieldChecked()) {
                tTupleProtocol.writeBool(exportGroupByInfo.fieldChecked);
            }
            if (exportGroupByInfo.isSetFieldNameAliasForExport()) {
                tTupleProtocol.writeString(exportGroupByInfo.fieldNameAliasForExport);
            }
        }

        public void read(TProtocol tProtocol, ExportGroupByInfo exportGroupByInfo) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(3);
            if (bitSet.get(0)) {
                exportGroupByInfo.fieldName = tTupleProtocol.readString();
                exportGroupByInfo.setFieldNameIsSet(true);
            }
            if (bitSet.get(1)) {
                exportGroupByInfo.fieldChecked = tTupleProtocol.readBool();
                exportGroupByInfo.setFieldCheckedIsSet(true);
            }
            if (bitSet.get(2)) {
                exportGroupByInfo.fieldNameAliasForExport = tTupleProtocol.readString();
                exportGroupByInfo.setFieldNameAliasForExportIsSet(true);
            }
        }
    }

    private static class ExportGroupByInfoStandardScheme
    extends StandardScheme<ExportGroupByInfo> {
        private ExportGroupByInfoStandardScheme() {
        }

        public void read(TProtocol tProtocol, ExportGroupByInfo exportGroupByInfo) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 11) {
                            exportGroupByInfo.fieldName = tProtocol.readString();
                            exportGroupByInfo.setFieldNameIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 2) {
                            exportGroupByInfo.fieldChecked = tProtocol.readBool();
                            exportGroupByInfo.setFieldCheckedIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 11) {
                            exportGroupByInfo.fieldNameAliasForExport = tProtocol.readString();
                            exportGroupByInfo.setFieldNameAliasForExportIsSet(true);
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
            exportGroupByInfo.validate();
        }

        public void write(TProtocol tProtocol, ExportGroupByInfo exportGroupByInfo) throws TException {
            exportGroupByInfo.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (exportGroupByInfo.fieldName != null) {
                tProtocol.writeFieldBegin(FIELD_NAME_FIELD_DESC);
                tProtocol.writeString(exportGroupByInfo.fieldName);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(FIELD_CHECKED_FIELD_DESC);
            tProtocol.writeBool(exportGroupByInfo.fieldChecked);
            tProtocol.writeFieldEnd();
            if (exportGroupByInfo.fieldNameAliasForExport != null) {
                tProtocol.writeFieldBegin(FIELD_NAME_ALIAS_FOR_EXPORT_FIELD_DESC);
                tProtocol.writeString(exportGroupByInfo.fieldNameAliasForExport);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

