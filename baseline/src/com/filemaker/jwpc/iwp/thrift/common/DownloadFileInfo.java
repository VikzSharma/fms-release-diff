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

public class DownloadFileInfo
implements TBase<DownloadFileInfo, _Fields>,
Serializable,
Cloneable,
Comparable<DownloadFileInfo> {
    private static final TStruct STRUCT_DESC = new TStruct("DownloadFileInfo");
    private static final TField FILE_PATH_FIELD_DESC = new TField("filePath", 11, 1);
    private static final TField DOWNLOAD_FILE_NAME_FIELD_DESC = new TField("downloadFileName", 11, 2);
    private static final TField FILE_TYPE_FIELD_DESC = new TField("fileType", 11, 3);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new DownloadFileInfoStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new DownloadFileInfoTupleSchemeFactory();
    @Nullable
    private String filePath;
    @Nullable
    private String downloadFileName;
    @Nullable
    private String fileType;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public DownloadFileInfo() {
    }

    public DownloadFileInfo(String string, String string2, String string3) {
        this();
        this.filePath = string;
        this.downloadFileName = string2;
        this.fileType = string3;
    }

    public DownloadFileInfo(DownloadFileInfo downloadFileInfo) {
        if (downloadFileInfo.isSetFilePath()) {
            this.filePath = downloadFileInfo.filePath;
        }
        if (downloadFileInfo.isSetDownloadFileName()) {
            this.downloadFileName = downloadFileInfo.downloadFileName;
        }
        if (downloadFileInfo.isSetFileType()) {
            this.fileType = downloadFileInfo.fileType;
        }
    }

    public DownloadFileInfo deepCopy() {
        return new DownloadFileInfo(this);
    }

    public void clear() {
        this.filePath = null;
        this.downloadFileName = null;
        this.fileType = null;
    }

    @Nullable
    public String getFilePath() {
        return this.filePath;
    }

    public void setFilePath(@Nullable String string) {
        this.filePath = string;
    }

    public void unsetFilePath() {
        this.filePath = null;
    }

    public boolean isSetFilePath() {
        return this.filePath != null;
    }

    public void setFilePathIsSet(boolean bl) {
        if (!bl) {
            this.filePath = null;
        }
    }

    @Nullable
    public String getDownloadFileName() {
        return this.downloadFileName;
    }

    public void setDownloadFileName(@Nullable String string) {
        this.downloadFileName = string;
    }

    public void unsetDownloadFileName() {
        this.downloadFileName = null;
    }

    public boolean isSetDownloadFileName() {
        return this.downloadFileName != null;
    }

    public void setDownloadFileNameIsSet(boolean bl) {
        if (!bl) {
            this.downloadFileName = null;
        }
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
                    this.unsetFilePath();
                    break;
                }
                this.setFilePath((String)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetDownloadFileName();
                    break;
                }
                this.setDownloadFileName((String)object);
                break;
            }
            case 2: {
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
                return this.getFilePath();
            }
            case 1: {
                return this.getDownloadFileName();
            }
            case 2: {
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
                return this.isSetFilePath();
            }
            case 1: {
                return this.isSetDownloadFileName();
            }
            case 2: {
                return this.isSetFileType();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof DownloadFileInfo) {
            return this.equals((DownloadFileInfo)object);
        }
        return false;
    }

    public boolean equals(DownloadFileInfo downloadFileInfo) {
        if (downloadFileInfo == null) {
            return false;
        }
        if (this == downloadFileInfo) {
            return true;
        }
        boolean bl = this.isSetFilePath();
        boolean bl2 = downloadFileInfo.isSetFilePath();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.filePath.equals(downloadFileInfo.filePath)) {
                return false;
            }
        }
        boolean bl3 = this.isSetDownloadFileName();
        boolean bl4 = downloadFileInfo.isSetDownloadFileName();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.downloadFileName.equals(downloadFileInfo.downloadFileName)) {
                return false;
            }
        }
        boolean bl5 = this.isSetFileType();
        boolean bl6 = downloadFileInfo.isSetFileType();
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (!this.fileType.equals(downloadFileInfo.fileType)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetFilePath() ? 131071 : 524287);
        if (this.isSetFilePath()) {
            n = n * 8191 + this.filePath.hashCode();
        }
        n = n * 8191 + (this.isSetDownloadFileName() ? 131071 : 524287);
        if (this.isSetDownloadFileName()) {
            n = n * 8191 + this.downloadFileName.hashCode();
        }
        n = n * 8191 + (this.isSetFileType() ? 131071 : 524287);
        if (this.isSetFileType()) {
            n = n * 8191 + this.fileType.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(DownloadFileInfo downloadFileInfo) {
        if (!this.getClass().equals(downloadFileInfo.getClass())) {
            return this.getClass().getName().compareTo(downloadFileInfo.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetFilePath(), downloadFileInfo.isSetFilePath());
        if (n != 0) {
            return n;
        }
        if (this.isSetFilePath() && (n = TBaseHelper.compareTo((String)this.filePath, (String)downloadFileInfo.filePath)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetDownloadFileName(), downloadFileInfo.isSetDownloadFileName());
        if (n != 0) {
            return n;
        }
        if (this.isSetDownloadFileName() && (n = TBaseHelper.compareTo((String)this.downloadFileName, (String)downloadFileInfo.downloadFileName)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetFileType(), downloadFileInfo.isSetFileType());
        if (n != 0) {
            return n;
        }
        if (this.isSetFileType() && (n = TBaseHelper.compareTo((String)this.fileType, (String)downloadFileInfo.fileType)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        DownloadFileInfo.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        DownloadFileInfo.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("DownloadFileInfo(");
        boolean bl = true;
        stringBuilder.append("filePath:");
        if (this.filePath == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.filePath);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("downloadFileName:");
        if (this.downloadFileName == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.downloadFileName);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
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
        enumMap.put(_Fields.FILE_PATH, new FieldMetaData("filePath", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.DOWNLOAD_FILE_NAME, new FieldMetaData("downloadFileName", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.FILE_TYPE, new FieldMetaData("fileType", 3, new FieldValueMetaData(11)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(DownloadFileInfo.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        FILE_PATH(1, "filePath"),
        DOWNLOAD_FILE_NAME(2, "downloadFileName"),
        FILE_TYPE(3, "fileType");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return FILE_PATH;
                }
                case 2: {
                    return DOWNLOAD_FILE_NAME;
                }
                case 3: {
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

    private static class DownloadFileInfoStandardSchemeFactory
    implements SchemeFactory {
        private DownloadFileInfoStandardSchemeFactory() {
        }

        public DownloadFileInfoStandardScheme getScheme() {
            return new DownloadFileInfoStandardScheme();
        }
    }

    private static class DownloadFileInfoTupleSchemeFactory
    implements SchemeFactory {
        private DownloadFileInfoTupleSchemeFactory() {
        }

        public DownloadFileInfoTupleScheme getScheme() {
            return new DownloadFileInfoTupleScheme();
        }
    }

    private static class DownloadFileInfoTupleScheme
    extends TupleScheme<DownloadFileInfo> {
        private DownloadFileInfoTupleScheme() {
        }

        public void write(TProtocol tProtocol, DownloadFileInfo downloadFileInfo) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (downloadFileInfo.isSetFilePath()) {
                bitSet.set(0);
            }
            if (downloadFileInfo.isSetDownloadFileName()) {
                bitSet.set(1);
            }
            if (downloadFileInfo.isSetFileType()) {
                bitSet.set(2);
            }
            tTupleProtocol.writeBitSet(bitSet, 3);
            if (downloadFileInfo.isSetFilePath()) {
                tTupleProtocol.writeString(downloadFileInfo.filePath);
            }
            if (downloadFileInfo.isSetDownloadFileName()) {
                tTupleProtocol.writeString(downloadFileInfo.downloadFileName);
            }
            if (downloadFileInfo.isSetFileType()) {
                tTupleProtocol.writeString(downloadFileInfo.fileType);
            }
        }

        public void read(TProtocol tProtocol, DownloadFileInfo downloadFileInfo) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(3);
            if (bitSet.get(0)) {
                downloadFileInfo.filePath = tTupleProtocol.readString();
                downloadFileInfo.setFilePathIsSet(true);
            }
            if (bitSet.get(1)) {
                downloadFileInfo.downloadFileName = tTupleProtocol.readString();
                downloadFileInfo.setDownloadFileNameIsSet(true);
            }
            if (bitSet.get(2)) {
                downloadFileInfo.fileType = tTupleProtocol.readString();
                downloadFileInfo.setFileTypeIsSet(true);
            }
        }
    }

    private static class DownloadFileInfoStandardScheme
    extends StandardScheme<DownloadFileInfo> {
        private DownloadFileInfoStandardScheme() {
        }

        public void read(TProtocol tProtocol, DownloadFileInfo downloadFileInfo) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 11) {
                            downloadFileInfo.filePath = tProtocol.readString();
                            downloadFileInfo.setFilePathIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 11) {
                            downloadFileInfo.downloadFileName = tProtocol.readString();
                            downloadFileInfo.setDownloadFileNameIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 11) {
                            downloadFileInfo.fileType = tProtocol.readString();
                            downloadFileInfo.setFileTypeIsSet(true);
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
            downloadFileInfo.validate();
        }

        public void write(TProtocol tProtocol, DownloadFileInfo downloadFileInfo) throws TException {
            downloadFileInfo.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (downloadFileInfo.filePath != null) {
                tProtocol.writeFieldBegin(FILE_PATH_FIELD_DESC);
                tProtocol.writeString(downloadFileInfo.filePath);
                tProtocol.writeFieldEnd();
            }
            if (downloadFileInfo.downloadFileName != null) {
                tProtocol.writeFieldBegin(DOWNLOAD_FILE_NAME_FIELD_DESC);
                tProtocol.writeString(downloadFileInfo.downloadFileName);
                tProtocol.writeFieldEnd();
            }
            if (downloadFileInfo.fileType != null) {
                tProtocol.writeFieldBegin(FILE_TYPE_FIELD_DESC);
                tProtocol.writeString(downloadFileInfo.fileType);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

