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
package com.filemaker.jwpc.iwp.thrift.notification;

import com.filemaker.jwpc.iwp.thrift.common.ImportRecordsFileInfo;
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

public class ImportRecordsNotification
implements TBase<ImportRecordsNotification, _Fields>,
Serializable,
Cloneable,
Comparable<ImportRecordsNotification> {
    private static final TStruct STRUCT_DESC = new TStruct("ImportRecordsNotification");
    private static final TField FILE_INFO_FIELD_DESC = new TField("fileInfo", 12, 1);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new ImportRecordsNotificationStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new ImportRecordsNotificationTupleSchemeFactory();
    @Nullable
    private ImportRecordsFileInfo fileInfo;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public ImportRecordsNotification() {
    }

    public ImportRecordsNotification(ImportRecordsFileInfo importRecordsFileInfo) {
        this();
        this.fileInfo = importRecordsFileInfo;
    }

    public ImportRecordsNotification(ImportRecordsNotification importRecordsNotification) {
        if (importRecordsNotification.isSetFileInfo()) {
            this.fileInfo = new ImportRecordsFileInfo(importRecordsNotification.fileInfo);
        }
    }

    public ImportRecordsNotification deepCopy() {
        return new ImportRecordsNotification(this);
    }

    public void clear() {
        this.fileInfo = null;
    }

    @Nullable
    public ImportRecordsFileInfo getFileInfo() {
        return this.fileInfo;
    }

    public void setFileInfo(@Nullable ImportRecordsFileInfo importRecordsFileInfo) {
        this.fileInfo = importRecordsFileInfo;
    }

    public void unsetFileInfo() {
        this.fileInfo = null;
    }

    public boolean isSetFileInfo() {
        return this.fileInfo != null;
    }

    public void setFileInfoIsSet(boolean bl) {
        if (!bl) {
            this.fileInfo = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetFileInfo();
                    break;
                }
                this.setFileInfo((ImportRecordsFileInfo)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getFileInfo();
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
                return this.isSetFileInfo();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof ImportRecordsNotification) {
            return this.equals((ImportRecordsNotification)object);
        }
        return false;
    }

    public boolean equals(ImportRecordsNotification importRecordsNotification) {
        if (importRecordsNotification == null) {
            return false;
        }
        if (this == importRecordsNotification) {
            return true;
        }
        boolean bl = this.isSetFileInfo();
        boolean bl2 = importRecordsNotification.isSetFileInfo();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.fileInfo.equals(importRecordsNotification.fileInfo)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetFileInfo() ? 131071 : 524287);
        if (this.isSetFileInfo()) {
            n = n * 8191 + this.fileInfo.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(ImportRecordsNotification importRecordsNotification) {
        if (!this.getClass().equals(importRecordsNotification.getClass())) {
            return this.getClass().getName().compareTo(importRecordsNotification.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetFileInfo(), importRecordsNotification.isSetFileInfo());
        if (n != 0) {
            return n;
        }
        if (this.isSetFileInfo() && (n = TBaseHelper.compareTo((Comparable)this.fileInfo, (Comparable)importRecordsNotification.fileInfo)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        ImportRecordsNotification.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        ImportRecordsNotification.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ImportRecordsNotification(");
        boolean bl = true;
        stringBuilder.append("fileInfo:");
        if (this.fileInfo == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.fileInfo);
        }
        bl = false;
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void validate() throws TException {
        if (this.fileInfo != null) {
            this.fileInfo.validate();
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
        enumMap.put(_Fields.FILE_INFO, new FieldMetaData("fileInfo", 3, (FieldValueMetaData)new StructMetaData(12, ImportRecordsFileInfo.class)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(ImportRecordsNotification.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        FILE_INFO(1, "fileInfo");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return FILE_INFO;
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

    private static class ImportRecordsNotificationStandardSchemeFactory
    implements SchemeFactory {
        private ImportRecordsNotificationStandardSchemeFactory() {
        }

        public ImportRecordsNotificationStandardScheme getScheme() {
            return new ImportRecordsNotificationStandardScheme();
        }
    }

    private static class ImportRecordsNotificationTupleSchemeFactory
    implements SchemeFactory {
        private ImportRecordsNotificationTupleSchemeFactory() {
        }

        public ImportRecordsNotificationTupleScheme getScheme() {
            return new ImportRecordsNotificationTupleScheme();
        }
    }

    private static class ImportRecordsNotificationTupleScheme
    extends TupleScheme<ImportRecordsNotification> {
        private ImportRecordsNotificationTupleScheme() {
        }

        public void write(TProtocol tProtocol, ImportRecordsNotification importRecordsNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (importRecordsNotification.isSetFileInfo()) {
                bitSet.set(0);
            }
            tTupleProtocol.writeBitSet(bitSet, 1);
            if (importRecordsNotification.isSetFileInfo()) {
                importRecordsNotification.fileInfo.write((TProtocol)tTupleProtocol);
            }
        }

        public void read(TProtocol tProtocol, ImportRecordsNotification importRecordsNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(1);
            if (bitSet.get(0)) {
                importRecordsNotification.fileInfo = new ImportRecordsFileInfo();
                importRecordsNotification.fileInfo.read((TProtocol)tTupleProtocol);
                importRecordsNotification.setFileInfoIsSet(true);
            }
        }
    }

    private static class ImportRecordsNotificationStandardScheme
    extends StandardScheme<ImportRecordsNotification> {
        private ImportRecordsNotificationStandardScheme() {
        }

        public void read(TProtocol tProtocol, ImportRecordsNotification importRecordsNotification) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 12) {
                            importRecordsNotification.fileInfo = new ImportRecordsFileInfo();
                            importRecordsNotification.fileInfo.read(tProtocol);
                            importRecordsNotification.setFileInfoIsSet(true);
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
            importRecordsNotification.validate();
        }

        public void write(TProtocol tProtocol, ImportRecordsNotification importRecordsNotification) throws TException {
            importRecordsNotification.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (importRecordsNotification.fileInfo != null) {
                tProtocol.writeFieldBegin(FILE_INFO_FIELD_DESC);
                importRecordsNotification.fileInfo.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

