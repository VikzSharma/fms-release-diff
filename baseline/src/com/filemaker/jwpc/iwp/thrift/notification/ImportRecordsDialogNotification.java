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
package com.filemaker.jwpc.iwp.thrift.notification;

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

public class ImportRecordsDialogNotification
implements TBase<ImportRecordsDialogNotification, _Fields>,
Serializable,
Cloneable,
Comparable<ImportRecordsDialogNotification> {
    private static final TStruct STRUCT_DESC = new TStruct("ImportRecordsDialogNotification");
    private static final TField IMPORT_FOLDER_PATH_FIELD_DESC = new TField("importFolderPath", 11, 1);
    private static final TField DIALOG_TYPE_FIELD_DESC = new TField("dialogType", 8, 2);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new ImportRecordsDialogNotificationStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new ImportRecordsDialogNotificationTupleSchemeFactory();
    @Nullable
    private String importFolderPath;
    private int dialogType;
    private static final int __DIALOGTYPE_ISSET_ID = 0;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public ImportRecordsDialogNotification() {
    }

    public ImportRecordsDialogNotification(String string, int n) {
        this();
        this.importFolderPath = string;
        this.dialogType = n;
        this.setDialogTypeIsSet(true);
    }

    public ImportRecordsDialogNotification(ImportRecordsDialogNotification importRecordsDialogNotification) {
        this.__isset_bitfield = importRecordsDialogNotification.__isset_bitfield;
        if (importRecordsDialogNotification.isSetImportFolderPath()) {
            this.importFolderPath = importRecordsDialogNotification.importFolderPath;
        }
        this.dialogType = importRecordsDialogNotification.dialogType;
    }

    public ImportRecordsDialogNotification deepCopy() {
        return new ImportRecordsDialogNotification(this);
    }

    public void clear() {
        this.importFolderPath = null;
        this.setDialogTypeIsSet(false);
        this.dialogType = 0;
    }

    @Nullable
    public String getImportFolderPath() {
        return this.importFolderPath;
    }

    public void setImportFolderPath(@Nullable String string) {
        this.importFolderPath = string;
    }

    public void unsetImportFolderPath() {
        this.importFolderPath = null;
    }

    public boolean isSetImportFolderPath() {
        return this.importFolderPath != null;
    }

    public void setImportFolderPathIsSet(boolean bl) {
        if (!bl) {
            this.importFolderPath = null;
        }
    }

    public int getDialogType() {
        return this.dialogType;
    }

    public void setDialogType(int n) {
        this.dialogType = n;
        this.setDialogTypeIsSet(true);
    }

    public void unsetDialogType() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetDialogType() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setDialogTypeIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetImportFolderPath();
                    break;
                }
                this.setImportFolderPath((String)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetDialogType();
                    break;
                }
                this.setDialogType((Integer)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getImportFolderPath();
            }
            case 1: {
                return this.getDialogType();
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
                return this.isSetImportFolderPath();
            }
            case 1: {
                return this.isSetDialogType();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof ImportRecordsDialogNotification) {
            return this.equals((ImportRecordsDialogNotification)object);
        }
        return false;
    }

    public boolean equals(ImportRecordsDialogNotification importRecordsDialogNotification) {
        if (importRecordsDialogNotification == null) {
            return false;
        }
        if (this == importRecordsDialogNotification) {
            return true;
        }
        boolean bl = this.isSetImportFolderPath();
        boolean bl2 = importRecordsDialogNotification.isSetImportFolderPath();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.importFolderPath.equals(importRecordsDialogNotification.importFolderPath)) {
                return false;
            }
        }
        boolean bl3 = true;
        boolean bl4 = true;
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (this.dialogType != importRecordsDialogNotification.dialogType) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetImportFolderPath() ? 131071 : 524287);
        if (this.isSetImportFolderPath()) {
            n = n * 8191 + this.importFolderPath.hashCode();
        }
        n = n * 8191 + this.dialogType;
        return n;
    }

    @Override
    public int compareTo(ImportRecordsDialogNotification importRecordsDialogNotification) {
        if (!this.getClass().equals(importRecordsDialogNotification.getClass())) {
            return this.getClass().getName().compareTo(importRecordsDialogNotification.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetImportFolderPath(), importRecordsDialogNotification.isSetImportFolderPath());
        if (n != 0) {
            return n;
        }
        if (this.isSetImportFolderPath() && (n = TBaseHelper.compareTo((String)this.importFolderPath, (String)importRecordsDialogNotification.importFolderPath)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetDialogType(), importRecordsDialogNotification.isSetDialogType());
        if (n != 0) {
            return n;
        }
        if (this.isSetDialogType() && (n = TBaseHelper.compareTo((int)this.dialogType, (int)importRecordsDialogNotification.dialogType)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        ImportRecordsDialogNotification.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        ImportRecordsDialogNotification.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ImportRecordsDialogNotification(");
        boolean bl = true;
        stringBuilder.append("importFolderPath:");
        if (this.importFolderPath == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.importFolderPath);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("dialogType:");
        stringBuilder.append(this.dialogType);
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
        enumMap.put(_Fields.IMPORT_FOLDER_PATH, new FieldMetaData("importFolderPath", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.DIALOG_TYPE, new FieldMetaData("dialogType", 3, new FieldValueMetaData(8)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(ImportRecordsDialogNotification.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        IMPORT_FOLDER_PATH(1, "importFolderPath"),
        DIALOG_TYPE(2, "dialogType");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return IMPORT_FOLDER_PATH;
                }
                case 2: {
                    return DIALOG_TYPE;
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

    private static class ImportRecordsDialogNotificationStandardSchemeFactory
    implements SchemeFactory {
        private ImportRecordsDialogNotificationStandardSchemeFactory() {
        }

        public ImportRecordsDialogNotificationStandardScheme getScheme() {
            return new ImportRecordsDialogNotificationStandardScheme();
        }
    }

    private static class ImportRecordsDialogNotificationTupleSchemeFactory
    implements SchemeFactory {
        private ImportRecordsDialogNotificationTupleSchemeFactory() {
        }

        public ImportRecordsDialogNotificationTupleScheme getScheme() {
            return new ImportRecordsDialogNotificationTupleScheme();
        }
    }

    private static class ImportRecordsDialogNotificationTupleScheme
    extends TupleScheme<ImportRecordsDialogNotification> {
        private ImportRecordsDialogNotificationTupleScheme() {
        }

        public void write(TProtocol tProtocol, ImportRecordsDialogNotification importRecordsDialogNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (importRecordsDialogNotification.isSetImportFolderPath()) {
                bitSet.set(0);
            }
            if (importRecordsDialogNotification.isSetDialogType()) {
                bitSet.set(1);
            }
            tTupleProtocol.writeBitSet(bitSet, 2);
            if (importRecordsDialogNotification.isSetImportFolderPath()) {
                tTupleProtocol.writeString(importRecordsDialogNotification.importFolderPath);
            }
            if (importRecordsDialogNotification.isSetDialogType()) {
                tTupleProtocol.writeI32(importRecordsDialogNotification.dialogType);
            }
        }

        public void read(TProtocol tProtocol, ImportRecordsDialogNotification importRecordsDialogNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(2);
            if (bitSet.get(0)) {
                importRecordsDialogNotification.importFolderPath = tTupleProtocol.readString();
                importRecordsDialogNotification.setImportFolderPathIsSet(true);
            }
            if (bitSet.get(1)) {
                importRecordsDialogNotification.dialogType = tTupleProtocol.readI32();
                importRecordsDialogNotification.setDialogTypeIsSet(true);
            }
        }
    }

    private static class ImportRecordsDialogNotificationStandardScheme
    extends StandardScheme<ImportRecordsDialogNotification> {
        private ImportRecordsDialogNotificationStandardScheme() {
        }

        public void read(TProtocol tProtocol, ImportRecordsDialogNotification importRecordsDialogNotification) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 11) {
                            importRecordsDialogNotification.importFolderPath = tProtocol.readString();
                            importRecordsDialogNotification.setImportFolderPathIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 8) {
                            importRecordsDialogNotification.dialogType = tProtocol.readI32();
                            importRecordsDialogNotification.setDialogTypeIsSet(true);
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
            importRecordsDialogNotification.validate();
        }

        public void write(TProtocol tProtocol, ImportRecordsDialogNotification importRecordsDialogNotification) throws TException {
            importRecordsDialogNotification.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (importRecordsDialogNotification.importFolderPath != null) {
                tProtocol.writeFieldBegin(IMPORT_FOLDER_PATH_FIELD_DESC);
                tProtocol.writeString(importRecordsDialogNotification.importFolderPath);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(DIALOG_TYPE_FIELD_DESC);
            tProtocol.writeI32(importRecordsDialogNotification.dialogType);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

