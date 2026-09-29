/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
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
package com.filemaker.jwpc.iwp.thrift.notification;

import com.filemaker.jwpc.iwp.thrift.common.ExportFieldContentsType;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
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

public class ExportFieldContentsDownloadFileNotification
implements TBase<ExportFieldContentsDownloadFileNotification, _Fields>,
Serializable,
Cloneable,
Comparable<ExportFieldContentsDownloadFileNotification> {
    private static final TStruct STRUCT_DESC = new TStruct("ExportFieldContentsDownloadFileNotification");
    private static final TField FILE_NAME_FIELD_DESC = new TField("fileName", 11, 1);
    private static final TField FILE_TYPE_FIELD_DESC = new TField("fileType", 11, 2);
    private static final TField DATA_TYPE_FIELD_DESC = new TField("dataType", 8, 3);
    private static final TField TEXT_DATA_FIELD_DESC = new TField("textData", 11, 4);
    private static final TField BINARY_DATA_URL_FIELD_DESC = new TField("binaryDataURL", 11, 5);
    private static final TField BINARY_DATA_FIELD_DESC = new TField("binaryData", 11, 6);
    private static final TField STREAM_SESSION_KEY_FIELD_DESC = new TField("streamSessionKey", 11, 7);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new ExportFieldContentsDownloadFileNotificationStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new ExportFieldContentsDownloadFileNotificationTupleSchemeFactory();
    @Nullable
    private String fileName;
    @Nullable
    private String fileType;
    @Nullable
    private ExportFieldContentsType dataType;
    @Nullable
    private String textData;
    @Nullable
    private String binaryDataURL;
    @Nullable
    private ByteBuffer binaryData;
    @Nullable
    private String streamSessionKey;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public ExportFieldContentsDownloadFileNotification() {
    }

    public ExportFieldContentsDownloadFileNotification(String string, String string2, ExportFieldContentsType exportFieldContentsType, String string3, String string4, ByteBuffer byteBuffer, String string5) {
        this();
        this.fileName = string;
        this.fileType = string2;
        this.dataType = exportFieldContentsType;
        this.textData = string3;
        this.binaryDataURL = string4;
        this.binaryData = TBaseHelper.copyBinary((ByteBuffer)byteBuffer);
        this.streamSessionKey = string5;
    }

    public ExportFieldContentsDownloadFileNotification(ExportFieldContentsDownloadFileNotification exportFieldContentsDownloadFileNotification) {
        if (exportFieldContentsDownloadFileNotification.isSetFileName()) {
            this.fileName = exportFieldContentsDownloadFileNotification.fileName;
        }
        if (exportFieldContentsDownloadFileNotification.isSetFileType()) {
            this.fileType = exportFieldContentsDownloadFileNotification.fileType;
        }
        if (exportFieldContentsDownloadFileNotification.isSetDataType()) {
            this.dataType = exportFieldContentsDownloadFileNotification.dataType;
        }
        if (exportFieldContentsDownloadFileNotification.isSetTextData()) {
            this.textData = exportFieldContentsDownloadFileNotification.textData;
        }
        if (exportFieldContentsDownloadFileNotification.isSetBinaryDataURL()) {
            this.binaryDataURL = exportFieldContentsDownloadFileNotification.binaryDataURL;
        }
        if (exportFieldContentsDownloadFileNotification.isSetBinaryData()) {
            this.binaryData = TBaseHelper.copyBinary((ByteBuffer)exportFieldContentsDownloadFileNotification.binaryData);
        }
        if (exportFieldContentsDownloadFileNotification.isSetStreamSessionKey()) {
            this.streamSessionKey = exportFieldContentsDownloadFileNotification.streamSessionKey;
        }
    }

    public ExportFieldContentsDownloadFileNotification deepCopy() {
        return new ExportFieldContentsDownloadFileNotification(this);
    }

    public void clear() {
        this.fileName = null;
        this.fileType = null;
        this.dataType = null;
        this.textData = null;
        this.binaryDataURL = null;
        this.binaryData = null;
        this.streamSessionKey = null;
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

    @Nullable
    public ExportFieldContentsType getDataType() {
        return this.dataType;
    }

    public void setDataType(@Nullable ExportFieldContentsType exportFieldContentsType) {
        this.dataType = exportFieldContentsType;
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

    @Nullable
    public String getTextData() {
        return this.textData;
    }

    public void setTextData(@Nullable String string) {
        this.textData = string;
    }

    public void unsetTextData() {
        this.textData = null;
    }

    public boolean isSetTextData() {
        return this.textData != null;
    }

    public void setTextDataIsSet(boolean bl) {
        if (!bl) {
            this.textData = null;
        }
    }

    @Nullable
    public String getBinaryDataURL() {
        return this.binaryDataURL;
    }

    public void setBinaryDataURL(@Nullable String string) {
        this.binaryDataURL = string;
    }

    public void unsetBinaryDataURL() {
        this.binaryDataURL = null;
    }

    public boolean isSetBinaryDataURL() {
        return this.binaryDataURL != null;
    }

    public void setBinaryDataURLIsSet(boolean bl) {
        if (!bl) {
            this.binaryDataURL = null;
        }
    }

    public byte[] getBinaryData() {
        this.setBinaryData(TBaseHelper.rightSize((ByteBuffer)this.binaryData));
        return this.binaryData == null ? null : this.binaryData.array();
    }

    public ByteBuffer bufferForBinaryData() {
        return TBaseHelper.copyBinary((ByteBuffer)this.binaryData);
    }

    public void setBinaryData(byte[] byArray) {
        this.binaryData = byArray == null ? (ByteBuffer)null : ByteBuffer.wrap((byte[])byArray.clone());
    }

    public void setBinaryData(@Nullable ByteBuffer byteBuffer) {
        this.binaryData = TBaseHelper.copyBinary((ByteBuffer)byteBuffer);
    }

    public void unsetBinaryData() {
        this.binaryData = null;
    }

    public boolean isSetBinaryData() {
        return this.binaryData != null;
    }

    public void setBinaryDataIsSet(boolean bl) {
        if (!bl) {
            this.binaryData = null;
        }
    }

    @Nullable
    public String getStreamSessionKey() {
        return this.streamSessionKey;
    }

    public void setStreamSessionKey(@Nullable String string) {
        this.streamSessionKey = string;
    }

    public void unsetStreamSessionKey() {
        this.streamSessionKey = null;
    }

    public boolean isSetStreamSessionKey() {
        return this.streamSessionKey != null;
    }

    public void setStreamSessionKeyIsSet(boolean bl) {
        if (!bl) {
            this.streamSessionKey = null;
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
                    this.unsetFileType();
                    break;
                }
                this.setFileType((String)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetDataType();
                    break;
                }
                this.setDataType((ExportFieldContentsType)((Object)object));
                break;
            }
            case 3: {
                if (object == null) {
                    this.unsetTextData();
                    break;
                }
                this.setTextData((String)object);
                break;
            }
            case 4: {
                if (object == null) {
                    this.unsetBinaryDataURL();
                    break;
                }
                this.setBinaryDataURL((String)object);
                break;
            }
            case 5: {
                if (object == null) {
                    this.unsetBinaryData();
                    break;
                }
                if (object instanceof byte[]) {
                    this.setBinaryData((byte[])object);
                    break;
                }
                this.setBinaryData((ByteBuffer)object);
                break;
            }
            case 6: {
                if (object == null) {
                    this.unsetStreamSessionKey();
                    break;
                }
                this.setStreamSessionKey((String)object);
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
                return this.getFileType();
            }
            case 2: {
                return this.getDataType();
            }
            case 3: {
                return this.getTextData();
            }
            case 4: {
                return this.getBinaryDataURL();
            }
            case 5: {
                return this.getBinaryData();
            }
            case 6: {
                return this.getStreamSessionKey();
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
                return this.isSetFileType();
            }
            case 2: {
                return this.isSetDataType();
            }
            case 3: {
                return this.isSetTextData();
            }
            case 4: {
                return this.isSetBinaryDataURL();
            }
            case 5: {
                return this.isSetBinaryData();
            }
            case 6: {
                return this.isSetStreamSessionKey();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof ExportFieldContentsDownloadFileNotification) {
            return this.equals((ExportFieldContentsDownloadFileNotification)object);
        }
        return false;
    }

    public boolean equals(ExportFieldContentsDownloadFileNotification exportFieldContentsDownloadFileNotification) {
        if (exportFieldContentsDownloadFileNotification == null) {
            return false;
        }
        if (this == exportFieldContentsDownloadFileNotification) {
            return true;
        }
        boolean bl = this.isSetFileName();
        boolean bl2 = exportFieldContentsDownloadFileNotification.isSetFileName();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.fileName.equals(exportFieldContentsDownloadFileNotification.fileName)) {
                return false;
            }
        }
        boolean bl3 = this.isSetFileType();
        boolean bl4 = exportFieldContentsDownloadFileNotification.isSetFileType();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.fileType.equals(exportFieldContentsDownloadFileNotification.fileType)) {
                return false;
            }
        }
        boolean bl5 = this.isSetDataType();
        boolean bl6 = exportFieldContentsDownloadFileNotification.isSetDataType();
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (!this.dataType.equals((Object)exportFieldContentsDownloadFileNotification.dataType)) {
                return false;
            }
        }
        boolean bl7 = this.isSetTextData();
        boolean bl8 = exportFieldContentsDownloadFileNotification.isSetTextData();
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (!this.textData.equals(exportFieldContentsDownloadFileNotification.textData)) {
                return false;
            }
        }
        boolean bl9 = this.isSetBinaryDataURL();
        boolean bl10 = exportFieldContentsDownloadFileNotification.isSetBinaryDataURL();
        if (bl9 || bl10) {
            if (!bl9 || !bl10) {
                return false;
            }
            if (!this.binaryDataURL.equals(exportFieldContentsDownloadFileNotification.binaryDataURL)) {
                return false;
            }
        }
        boolean bl11 = this.isSetBinaryData();
        boolean bl12 = exportFieldContentsDownloadFileNotification.isSetBinaryData();
        if (bl11 || bl12) {
            if (!bl11 || !bl12) {
                return false;
            }
            if (!this.binaryData.equals(exportFieldContentsDownloadFileNotification.binaryData)) {
                return false;
            }
        }
        boolean bl13 = this.isSetStreamSessionKey();
        boolean bl14 = exportFieldContentsDownloadFileNotification.isSetStreamSessionKey();
        if (bl13 || bl14) {
            if (!bl13 || !bl14) {
                return false;
            }
            if (!this.streamSessionKey.equals(exportFieldContentsDownloadFileNotification.streamSessionKey)) {
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
        n = n * 8191 + (this.isSetFileType() ? 131071 : 524287);
        if (this.isSetFileType()) {
            n = n * 8191 + this.fileType.hashCode();
        }
        n = n * 8191 + (this.isSetDataType() ? 131071 : 524287);
        if (this.isSetDataType()) {
            n = n * 8191 + this.dataType.getValue();
        }
        n = n * 8191 + (this.isSetTextData() ? 131071 : 524287);
        if (this.isSetTextData()) {
            n = n * 8191 + this.textData.hashCode();
        }
        n = n * 8191 + (this.isSetBinaryDataURL() ? 131071 : 524287);
        if (this.isSetBinaryDataURL()) {
            n = n * 8191 + this.binaryDataURL.hashCode();
        }
        n = n * 8191 + (this.isSetBinaryData() ? 131071 : 524287);
        if (this.isSetBinaryData()) {
            n = n * 8191 + this.binaryData.hashCode();
        }
        n = n * 8191 + (this.isSetStreamSessionKey() ? 131071 : 524287);
        if (this.isSetStreamSessionKey()) {
            n = n * 8191 + this.streamSessionKey.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(ExportFieldContentsDownloadFileNotification exportFieldContentsDownloadFileNotification) {
        if (!this.getClass().equals(exportFieldContentsDownloadFileNotification.getClass())) {
            return this.getClass().getName().compareTo(exportFieldContentsDownloadFileNotification.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetFileName(), exportFieldContentsDownloadFileNotification.isSetFileName());
        if (n != 0) {
            return n;
        }
        if (this.isSetFileName() && (n = TBaseHelper.compareTo((String)this.fileName, (String)exportFieldContentsDownloadFileNotification.fileName)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetFileType(), exportFieldContentsDownloadFileNotification.isSetFileType());
        if (n != 0) {
            return n;
        }
        if (this.isSetFileType() && (n = TBaseHelper.compareTo((String)this.fileType, (String)exportFieldContentsDownloadFileNotification.fileType)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetDataType(), exportFieldContentsDownloadFileNotification.isSetDataType());
        if (n != 0) {
            return n;
        }
        if (this.isSetDataType() && (n = TBaseHelper.compareTo((Comparable)((Object)this.dataType), (Comparable)((Object)exportFieldContentsDownloadFileNotification.dataType))) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetTextData(), exportFieldContentsDownloadFileNotification.isSetTextData());
        if (n != 0) {
            return n;
        }
        if (this.isSetTextData() && (n = TBaseHelper.compareTo((String)this.textData, (String)exportFieldContentsDownloadFileNotification.textData)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetBinaryDataURL(), exportFieldContentsDownloadFileNotification.isSetBinaryDataURL());
        if (n != 0) {
            return n;
        }
        if (this.isSetBinaryDataURL() && (n = TBaseHelper.compareTo((String)this.binaryDataURL, (String)exportFieldContentsDownloadFileNotification.binaryDataURL)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetBinaryData(), exportFieldContentsDownloadFileNotification.isSetBinaryData());
        if (n != 0) {
            return n;
        }
        if (this.isSetBinaryData() && (n = TBaseHelper.compareTo((Comparable)this.binaryData, (Comparable)exportFieldContentsDownloadFileNotification.binaryData)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetStreamSessionKey(), exportFieldContentsDownloadFileNotification.isSetStreamSessionKey());
        if (n != 0) {
            return n;
        }
        if (this.isSetStreamSessionKey() && (n = TBaseHelper.compareTo((String)this.streamSessionKey, (String)exportFieldContentsDownloadFileNotification.streamSessionKey)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        ExportFieldContentsDownloadFileNotification.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        ExportFieldContentsDownloadFileNotification.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ExportFieldContentsDownloadFileNotification(");
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
        stringBuilder.append("fileType:");
        if (this.fileType == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.fileType);
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
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("textData:");
        if (this.textData == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.textData);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("binaryDataURL:");
        if (this.binaryDataURL == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.binaryDataURL);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("binaryData:");
        if (this.binaryData == null) {
            stringBuilder.append("null");
        } else {
            TBaseHelper.toString((ByteBuffer)this.binaryData, (StringBuilder)stringBuilder);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("streamSessionKey:");
        if (this.streamSessionKey == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.streamSessionKey);
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
        enumMap.put(_Fields.FILE_NAME, new FieldMetaData("fileName", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.FILE_TYPE, new FieldMetaData("fileType", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.DATA_TYPE, new FieldMetaData("dataType", 3, (FieldValueMetaData)new EnumMetaData(-1, ExportFieldContentsType.class)));
        enumMap.put(_Fields.TEXT_DATA, new FieldMetaData("textData", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.BINARY_DATA_URL, new FieldMetaData("binaryDataURL", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.BINARY_DATA, new FieldMetaData("binaryData", 3, new FieldValueMetaData(11, true)));
        enumMap.put(_Fields.STREAM_SESSION_KEY, new FieldMetaData("streamSessionKey", 3, new FieldValueMetaData(11)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(ExportFieldContentsDownloadFileNotification.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        FILE_NAME(1, "fileName"),
        FILE_TYPE(2, "fileType"),
        DATA_TYPE(3, "dataType"),
        TEXT_DATA(4, "textData"),
        BINARY_DATA_URL(5, "binaryDataURL"),
        BINARY_DATA(6, "binaryData"),
        STREAM_SESSION_KEY(7, "streamSessionKey");

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
                    return FILE_TYPE;
                }
                case 3: {
                    return DATA_TYPE;
                }
                case 4: {
                    return TEXT_DATA;
                }
                case 5: {
                    return BINARY_DATA_URL;
                }
                case 6: {
                    return BINARY_DATA;
                }
                case 7: {
                    return STREAM_SESSION_KEY;
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

    private static class ExportFieldContentsDownloadFileNotificationStandardSchemeFactory
    implements SchemeFactory {
        private ExportFieldContentsDownloadFileNotificationStandardSchemeFactory() {
        }

        public ExportFieldContentsDownloadFileNotificationStandardScheme getScheme() {
            return new ExportFieldContentsDownloadFileNotificationStandardScheme();
        }
    }

    private static class ExportFieldContentsDownloadFileNotificationTupleSchemeFactory
    implements SchemeFactory {
        private ExportFieldContentsDownloadFileNotificationTupleSchemeFactory() {
        }

        public ExportFieldContentsDownloadFileNotificationTupleScheme getScheme() {
            return new ExportFieldContentsDownloadFileNotificationTupleScheme();
        }
    }

    private static class ExportFieldContentsDownloadFileNotificationTupleScheme
    extends TupleScheme<ExportFieldContentsDownloadFileNotification> {
        private ExportFieldContentsDownloadFileNotificationTupleScheme() {
        }

        public void write(TProtocol tProtocol, ExportFieldContentsDownloadFileNotification exportFieldContentsDownloadFileNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (exportFieldContentsDownloadFileNotification.isSetFileName()) {
                bitSet.set(0);
            }
            if (exportFieldContentsDownloadFileNotification.isSetFileType()) {
                bitSet.set(1);
            }
            if (exportFieldContentsDownloadFileNotification.isSetDataType()) {
                bitSet.set(2);
            }
            if (exportFieldContentsDownloadFileNotification.isSetTextData()) {
                bitSet.set(3);
            }
            if (exportFieldContentsDownloadFileNotification.isSetBinaryDataURL()) {
                bitSet.set(4);
            }
            if (exportFieldContentsDownloadFileNotification.isSetBinaryData()) {
                bitSet.set(5);
            }
            if (exportFieldContentsDownloadFileNotification.isSetStreamSessionKey()) {
                bitSet.set(6);
            }
            tTupleProtocol.writeBitSet(bitSet, 7);
            if (exportFieldContentsDownloadFileNotification.isSetFileName()) {
                tTupleProtocol.writeString(exportFieldContentsDownloadFileNotification.fileName);
            }
            if (exportFieldContentsDownloadFileNotification.isSetFileType()) {
                tTupleProtocol.writeString(exportFieldContentsDownloadFileNotification.fileType);
            }
            if (exportFieldContentsDownloadFileNotification.isSetDataType()) {
                tTupleProtocol.writeI32(exportFieldContentsDownloadFileNotification.dataType.getValue());
            }
            if (exportFieldContentsDownloadFileNotification.isSetTextData()) {
                tTupleProtocol.writeString(exportFieldContentsDownloadFileNotification.textData);
            }
            if (exportFieldContentsDownloadFileNotification.isSetBinaryDataURL()) {
                tTupleProtocol.writeString(exportFieldContentsDownloadFileNotification.binaryDataURL);
            }
            if (exportFieldContentsDownloadFileNotification.isSetBinaryData()) {
                tTupleProtocol.writeBinary(exportFieldContentsDownloadFileNotification.binaryData);
            }
            if (exportFieldContentsDownloadFileNotification.isSetStreamSessionKey()) {
                tTupleProtocol.writeString(exportFieldContentsDownloadFileNotification.streamSessionKey);
            }
        }

        public void read(TProtocol tProtocol, ExportFieldContentsDownloadFileNotification exportFieldContentsDownloadFileNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(7);
            if (bitSet.get(0)) {
                exportFieldContentsDownloadFileNotification.fileName = tTupleProtocol.readString();
                exportFieldContentsDownloadFileNotification.setFileNameIsSet(true);
            }
            if (bitSet.get(1)) {
                exportFieldContentsDownloadFileNotification.fileType = tTupleProtocol.readString();
                exportFieldContentsDownloadFileNotification.setFileTypeIsSet(true);
            }
            if (bitSet.get(2)) {
                exportFieldContentsDownloadFileNotification.dataType = ExportFieldContentsType.findByValue(tTupleProtocol.readI32());
                exportFieldContentsDownloadFileNotification.setDataTypeIsSet(true);
            }
            if (bitSet.get(3)) {
                exportFieldContentsDownloadFileNotification.textData = tTupleProtocol.readString();
                exportFieldContentsDownloadFileNotification.setTextDataIsSet(true);
            }
            if (bitSet.get(4)) {
                exportFieldContentsDownloadFileNotification.binaryDataURL = tTupleProtocol.readString();
                exportFieldContentsDownloadFileNotification.setBinaryDataURLIsSet(true);
            }
            if (bitSet.get(5)) {
                exportFieldContentsDownloadFileNotification.binaryData = tTupleProtocol.readBinary();
                exportFieldContentsDownloadFileNotification.setBinaryDataIsSet(true);
            }
            if (bitSet.get(6)) {
                exportFieldContentsDownloadFileNotification.streamSessionKey = tTupleProtocol.readString();
                exportFieldContentsDownloadFileNotification.setStreamSessionKeyIsSet(true);
            }
        }
    }

    private static class ExportFieldContentsDownloadFileNotificationStandardScheme
    extends StandardScheme<ExportFieldContentsDownloadFileNotification> {
        private ExportFieldContentsDownloadFileNotificationStandardScheme() {
        }

        public void read(TProtocol tProtocol, ExportFieldContentsDownloadFileNotification exportFieldContentsDownloadFileNotification) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 11) {
                            exportFieldContentsDownloadFileNotification.fileName = tProtocol.readString();
                            exportFieldContentsDownloadFileNotification.setFileNameIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 11) {
                            exportFieldContentsDownloadFileNotification.fileType = tProtocol.readString();
                            exportFieldContentsDownloadFileNotification.setFileTypeIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 8) {
                            exportFieldContentsDownloadFileNotification.dataType = ExportFieldContentsType.findByValue(tProtocol.readI32());
                            exportFieldContentsDownloadFileNotification.setDataTypeIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 11) {
                            exportFieldContentsDownloadFileNotification.textData = tProtocol.readString();
                            exportFieldContentsDownloadFileNotification.setTextDataIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 5: {
                        if (tField.type == 11) {
                            exportFieldContentsDownloadFileNotification.binaryDataURL = tProtocol.readString();
                            exportFieldContentsDownloadFileNotification.setBinaryDataURLIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 6: {
                        if (tField.type == 11) {
                            exportFieldContentsDownloadFileNotification.binaryData = tProtocol.readBinary();
                            exportFieldContentsDownloadFileNotification.setBinaryDataIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 7: {
                        if (tField.type == 11) {
                            exportFieldContentsDownloadFileNotification.streamSessionKey = tProtocol.readString();
                            exportFieldContentsDownloadFileNotification.setStreamSessionKeyIsSet(true);
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
            exportFieldContentsDownloadFileNotification.validate();
        }

        public void write(TProtocol tProtocol, ExportFieldContentsDownloadFileNotification exportFieldContentsDownloadFileNotification) throws TException {
            exportFieldContentsDownloadFileNotification.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (exportFieldContentsDownloadFileNotification.fileName != null) {
                tProtocol.writeFieldBegin(FILE_NAME_FIELD_DESC);
                tProtocol.writeString(exportFieldContentsDownloadFileNotification.fileName);
                tProtocol.writeFieldEnd();
            }
            if (exportFieldContentsDownloadFileNotification.fileType != null) {
                tProtocol.writeFieldBegin(FILE_TYPE_FIELD_DESC);
                tProtocol.writeString(exportFieldContentsDownloadFileNotification.fileType);
                tProtocol.writeFieldEnd();
            }
            if (exportFieldContentsDownloadFileNotification.dataType != null) {
                tProtocol.writeFieldBegin(DATA_TYPE_FIELD_DESC);
                tProtocol.writeI32(exportFieldContentsDownloadFileNotification.dataType.getValue());
                tProtocol.writeFieldEnd();
            }
            if (exportFieldContentsDownloadFileNotification.textData != null) {
                tProtocol.writeFieldBegin(TEXT_DATA_FIELD_DESC);
                tProtocol.writeString(exportFieldContentsDownloadFileNotification.textData);
                tProtocol.writeFieldEnd();
            }
            if (exportFieldContentsDownloadFileNotification.binaryDataURL != null) {
                tProtocol.writeFieldBegin(BINARY_DATA_URL_FIELD_DESC);
                tProtocol.writeString(exportFieldContentsDownloadFileNotification.binaryDataURL);
                tProtocol.writeFieldEnd();
            }
            if (exportFieldContentsDownloadFileNotification.binaryData != null) {
                tProtocol.writeFieldBegin(BINARY_DATA_FIELD_DESC);
                tProtocol.writeBinary(exportFieldContentsDownloadFileNotification.binaryData);
                tProtocol.writeFieldEnd();
            }
            if (exportFieldContentsDownloadFileNotification.streamSessionKey != null) {
                tProtocol.writeFieldBegin(STREAM_SESSION_KEY_FIELD_DESC);
                tProtocol.writeString(exportFieldContentsDownloadFileNotification.streamSessionKey);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

