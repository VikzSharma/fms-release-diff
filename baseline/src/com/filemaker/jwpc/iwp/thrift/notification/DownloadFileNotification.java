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

import com.filemaker.jwpc.iwp.thrift.common.DownloadFileInfo;
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

public class DownloadFileNotification
implements TBase<DownloadFileNotification, _Fields>,
Serializable,
Cloneable,
Comparable<DownloadFileNotification> {
    private static final TStruct STRUCT_DESC = new TStruct("DownloadFileNotification");
    private static final TField FILE_INFO_FIELD_DESC = new TField("fileInfo", 12, 1);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new DownloadFileNotificationStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new DownloadFileNotificationTupleSchemeFactory();
    @Nullable
    private DownloadFileInfo fileInfo;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public DownloadFileNotification() {
    }

    public DownloadFileNotification(DownloadFileInfo downloadFileInfo) {
        this();
        this.fileInfo = downloadFileInfo;
    }

    public DownloadFileNotification(DownloadFileNotification downloadFileNotification) {
        if (downloadFileNotification.isSetFileInfo()) {
            this.fileInfo = new DownloadFileInfo(downloadFileNotification.fileInfo);
        }
    }

    public DownloadFileNotification deepCopy() {
        return new DownloadFileNotification(this);
    }

    public void clear() {
        this.fileInfo = null;
    }

    @Nullable
    public DownloadFileInfo getFileInfo() {
        return this.fileInfo;
    }

    public void setFileInfo(@Nullable DownloadFileInfo downloadFileInfo) {
        this.fileInfo = downloadFileInfo;
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
                this.setFileInfo((DownloadFileInfo)object);
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
        if (object instanceof DownloadFileNotification) {
            return this.equals((DownloadFileNotification)object);
        }
        return false;
    }

    public boolean equals(DownloadFileNotification downloadFileNotification) {
        if (downloadFileNotification == null) {
            return false;
        }
        if (this == downloadFileNotification) {
            return true;
        }
        boolean bl = this.isSetFileInfo();
        boolean bl2 = downloadFileNotification.isSetFileInfo();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.fileInfo.equals(downloadFileNotification.fileInfo)) {
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
    public int compareTo(DownloadFileNotification downloadFileNotification) {
        if (!this.getClass().equals(downloadFileNotification.getClass())) {
            return this.getClass().getName().compareTo(downloadFileNotification.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetFileInfo(), downloadFileNotification.isSetFileInfo());
        if (n != 0) {
            return n;
        }
        if (this.isSetFileInfo() && (n = TBaseHelper.compareTo((Comparable)this.fileInfo, (Comparable)downloadFileNotification.fileInfo)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        DownloadFileNotification.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        DownloadFileNotification.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("DownloadFileNotification(");
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
        enumMap.put(_Fields.FILE_INFO, new FieldMetaData("fileInfo", 3, (FieldValueMetaData)new StructMetaData(12, DownloadFileInfo.class)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(DownloadFileNotification.class, metaDataMap);
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

    private static class DownloadFileNotificationStandardSchemeFactory
    implements SchemeFactory {
        private DownloadFileNotificationStandardSchemeFactory() {
        }

        public DownloadFileNotificationStandardScheme getScheme() {
            return new DownloadFileNotificationStandardScheme();
        }
    }

    private static class DownloadFileNotificationTupleSchemeFactory
    implements SchemeFactory {
        private DownloadFileNotificationTupleSchemeFactory() {
        }

        public DownloadFileNotificationTupleScheme getScheme() {
            return new DownloadFileNotificationTupleScheme();
        }
    }

    private static class DownloadFileNotificationTupleScheme
    extends TupleScheme<DownloadFileNotification> {
        private DownloadFileNotificationTupleScheme() {
        }

        public void write(TProtocol tProtocol, DownloadFileNotification downloadFileNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (downloadFileNotification.isSetFileInfo()) {
                bitSet.set(0);
            }
            tTupleProtocol.writeBitSet(bitSet, 1);
            if (downloadFileNotification.isSetFileInfo()) {
                downloadFileNotification.fileInfo.write((TProtocol)tTupleProtocol);
            }
        }

        public void read(TProtocol tProtocol, DownloadFileNotification downloadFileNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(1);
            if (bitSet.get(0)) {
                downloadFileNotification.fileInfo = new DownloadFileInfo();
                downloadFileNotification.fileInfo.read((TProtocol)tTupleProtocol);
                downloadFileNotification.setFileInfoIsSet(true);
            }
        }
    }

    private static class DownloadFileNotificationStandardScheme
    extends StandardScheme<DownloadFileNotification> {
        private DownloadFileNotificationStandardScheme() {
        }

        public void read(TProtocol tProtocol, DownloadFileNotification downloadFileNotification) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 12) {
                            downloadFileNotification.fileInfo = new DownloadFileInfo();
                            downloadFileNotification.fileInfo.read(tProtocol);
                            downloadFileNotification.setFileInfoIsSet(true);
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
            downloadFileNotification.validate();
        }

        public void write(TProtocol tProtocol, DownloadFileNotification downloadFileNotification) throws TException {
            downloadFileNotification.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (downloadFileNotification.fileInfo != null) {
                tProtocol.writeFieldBegin(FILE_INFO_FIELD_DESC);
                downloadFileNotification.fileInfo.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

