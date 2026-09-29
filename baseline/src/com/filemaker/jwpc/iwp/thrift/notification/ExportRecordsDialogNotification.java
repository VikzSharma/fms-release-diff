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

public class ExportRecordsDialogNotification
implements TBase<ExportRecordsDialogNotification, _Fields>,
Serializable,
Cloneable,
Comparable<ExportRecordsDialogNotification> {
    private static final TStruct STRUCT_DESC = new TStruct("ExportRecordsDialogNotification");
    private static final TField FILE_TYPE_FIELD_DESC = new TField("fileType", 11, 1);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new ExportRecordsDialogNotificationStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new ExportRecordsDialogNotificationTupleSchemeFactory();
    @Nullable
    private String fileType;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public ExportRecordsDialogNotification() {
    }

    public ExportRecordsDialogNotification(String string) {
        this();
        this.fileType = string;
    }

    public ExportRecordsDialogNotification(ExportRecordsDialogNotification exportRecordsDialogNotification) {
        if (exportRecordsDialogNotification.isSetFileType()) {
            this.fileType = exportRecordsDialogNotification.fileType;
        }
    }

    public ExportRecordsDialogNotification deepCopy() {
        return new ExportRecordsDialogNotification(this);
    }

    public void clear() {
        this.fileType = null;
    }

    @Nullable
    public String getFileType() {
        return this.fileType;
    }

    public void setFileType(@Nullable String string) {
        this.fileType = string;
    }

    public void unsetFileType() {
        this.fileType = null;
    }

    public boolean isSetFileType() {
        return this.fileType != null;
    }

    public void setFileTypeIsSet(boolean bl) {
        if (!bl) {
            this.fileType = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetFileType();
                    break;
                }
                this.setFileType((String)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getFileType();
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
                return this.isSetFileType();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof ExportRecordsDialogNotification) {
            return this.equals((ExportRecordsDialogNotification)object);
        }
        return false;
    }

    public boolean equals(ExportRecordsDialogNotification exportRecordsDialogNotification) {
        if (exportRecordsDialogNotification == null) {
            return false;
        }
        if (this == exportRecordsDialogNotification) {
            return true;
        }
        boolean bl = this.isSetFileType();
        boolean bl2 = exportRecordsDialogNotification.isSetFileType();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.fileType.equals(exportRecordsDialogNotification.fileType)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetFileType() ? 131071 : 524287);
        if (this.isSetFileType()) {
            n = n * 8191 + this.fileType.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(ExportRecordsDialogNotification exportRecordsDialogNotification) {
        if (!this.getClass().equals(exportRecordsDialogNotification.getClass())) {
            return this.getClass().getName().compareTo(exportRecordsDialogNotification.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetFileType(), exportRecordsDialogNotification.isSetFileType());
        if (n != 0) {
            return n;
        }
        if (this.isSetFileType() && (n = TBaseHelper.compareTo((String)this.fileType, (String)exportRecordsDialogNotification.fileType)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        ExportRecordsDialogNotification.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        ExportRecordsDialogNotification.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ExportRecordsDialogNotification(");
        boolean bl = true;
        stringBuilder.append("fileType:");
        if (this.fileType == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.fileType);
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
        enumMap.put(_Fields.FILE_TYPE, new FieldMetaData("fileType", 3, new FieldValueMetaData(11)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(ExportRecordsDialogNotification.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        FILE_TYPE(1, "fileType");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return FILE_TYPE;
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

    private static class ExportRecordsDialogNotificationStandardSchemeFactory
    implements SchemeFactory {
        private ExportRecordsDialogNotificationStandardSchemeFactory() {
        }

        public ExportRecordsDialogNotificationStandardScheme getScheme() {
            return new ExportRecordsDialogNotificationStandardScheme();
        }
    }

    private static class ExportRecordsDialogNotificationTupleSchemeFactory
    implements SchemeFactory {
        private ExportRecordsDialogNotificationTupleSchemeFactory() {
        }

        public ExportRecordsDialogNotificationTupleScheme getScheme() {
            return new ExportRecordsDialogNotificationTupleScheme();
        }
    }

    private static class ExportRecordsDialogNotificationTupleScheme
    extends TupleScheme<ExportRecordsDialogNotification> {
        private ExportRecordsDialogNotificationTupleScheme() {
        }

        public void write(TProtocol tProtocol, ExportRecordsDialogNotification exportRecordsDialogNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (exportRecordsDialogNotification.isSetFileType()) {
                bitSet.set(0);
            }
            tTupleProtocol.writeBitSet(bitSet, 1);
            if (exportRecordsDialogNotification.isSetFileType()) {
                tTupleProtocol.writeString(exportRecordsDialogNotification.fileType);
            }
        }

        public void read(TProtocol tProtocol, ExportRecordsDialogNotification exportRecordsDialogNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(1);
            if (bitSet.get(0)) {
                exportRecordsDialogNotification.fileType = tTupleProtocol.readString();
                exportRecordsDialogNotification.setFileTypeIsSet(true);
            }
        }
    }

    private static class ExportRecordsDialogNotificationStandardScheme
    extends StandardScheme<ExportRecordsDialogNotification> {
        private ExportRecordsDialogNotificationStandardScheme() {
        }

        public void read(TProtocol tProtocol, ExportRecordsDialogNotification exportRecordsDialogNotification) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 11) {
                            exportRecordsDialogNotification.fileType = tProtocol.readString();
                            exportRecordsDialogNotification.setFileTypeIsSet(true);
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
            exportRecordsDialogNotification.validate();
        }

        public void write(TProtocol tProtocol, ExportRecordsDialogNotification exportRecordsDialogNotification) throws TException {
            exportRecordsDialogNotification.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (exportRecordsDialogNotification.fileType != null) {
                tProtocol.writeFieldBegin(FILE_TYPE_FIELD_DESC);
                tProtocol.writeString(exportRecordsDialogNotification.fileType);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

