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

public class DatabaseData
implements TBase<DatabaseData, _Fields>,
Serializable,
Cloneable,
Comparable<DatabaseData> {
    private static final TStruct STRUCT_DESC = new TStruct("DatabaseData");
    private static final TField NAME_FIELD_DESC = new TField("name", 11, 1);
    private static final TField URL_IMAGE_FIELD_DESC = new TField("urlImage", 11, 2);
    private static final TField URL_THUMBNAIL_FIELD_DESC = new TField("urlThumbnail", 11, 3);
    private static final TField METADATA_FIELD_DESC = new TField("metadata", 11, 4);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new DatabaseDataStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new DatabaseDataTupleSchemeFactory();
    @Nullable
    private String name;
    @Nullable
    private String urlImage;
    @Nullable
    private String urlThumbnail;
    @Nullable
    private String metadata;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public DatabaseData() {
    }

    public DatabaseData(String string, String string2, String string3, String string4) {
        this();
        this.name = string;
        this.urlImage = string2;
        this.urlThumbnail = string3;
        this.metadata = string4;
    }

    public DatabaseData(DatabaseData databaseData) {
        if (databaseData.isSetName()) {
            this.name = databaseData.name;
        }
        if (databaseData.isSetUrlImage()) {
            this.urlImage = databaseData.urlImage;
        }
        if (databaseData.isSetUrlThumbnail()) {
            this.urlThumbnail = databaseData.urlThumbnail;
        }
        if (databaseData.isSetMetadata()) {
            this.metadata = databaseData.metadata;
        }
    }

    public DatabaseData deepCopy() {
        return new DatabaseData(this);
    }

    public void clear() {
        this.name = null;
        this.urlImage = null;
        this.urlThumbnail = null;
        this.metadata = null;
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

    @Nullable
    public String getUrlImage() {
        return this.urlImage;
    }

    public void setUrlImage(@Nullable String string) {
        this.urlImage = string;
    }

    public void unsetUrlImage() {
        this.urlImage = null;
    }

    public boolean isSetUrlImage() {
        return this.urlImage != null;
    }

    public void setUrlImageIsSet(boolean bl) {
        if (!bl) {
            this.urlImage = null;
        }
    }

    @Nullable
    public String getUrlThumbnail() {
        return this.urlThumbnail;
    }

    public void setUrlThumbnail(@Nullable String string) {
        this.urlThumbnail = string;
    }

    public void unsetUrlThumbnail() {
        this.urlThumbnail = null;
    }

    public boolean isSetUrlThumbnail() {
        return this.urlThumbnail != null;
    }

    public void setUrlThumbnailIsSet(boolean bl) {
        if (!bl) {
            this.urlThumbnail = null;
        }
    }

    @Nullable
    public String getMetadata() {
        return this.metadata;
    }

    public void setMetadata(@Nullable String string) {
        this.metadata = string;
    }

    public void unsetMetadata() {
        this.metadata = null;
    }

    public boolean isSetMetadata() {
        return this.metadata != null;
    }

    public void setMetadataIsSet(boolean bl) {
        if (!bl) {
            this.metadata = null;
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
                    this.unsetUrlImage();
                    break;
                }
                this.setUrlImage((String)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetUrlThumbnail();
                    break;
                }
                this.setUrlThumbnail((String)object);
                break;
            }
            case 3: {
                if (object == null) {
                    this.unsetMetadata();
                    break;
                }
                this.setMetadata((String)object);
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
                return this.getUrlImage();
            }
            case 2: {
                return this.getUrlThumbnail();
            }
            case 3: {
                return this.getMetadata();
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
                return this.isSetUrlImage();
            }
            case 2: {
                return this.isSetUrlThumbnail();
            }
            case 3: {
                return this.isSetMetadata();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof DatabaseData) {
            return this.equals((DatabaseData)object);
        }
        return false;
    }

    public boolean equals(DatabaseData databaseData) {
        if (databaseData == null) {
            return false;
        }
        if (this == databaseData) {
            return true;
        }
        boolean bl = this.isSetName();
        boolean bl2 = databaseData.isSetName();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.name.equals(databaseData.name)) {
                return false;
            }
        }
        boolean bl3 = this.isSetUrlImage();
        boolean bl4 = databaseData.isSetUrlImage();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.urlImage.equals(databaseData.urlImage)) {
                return false;
            }
        }
        boolean bl5 = this.isSetUrlThumbnail();
        boolean bl6 = databaseData.isSetUrlThumbnail();
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (!this.urlThumbnail.equals(databaseData.urlThumbnail)) {
                return false;
            }
        }
        boolean bl7 = this.isSetMetadata();
        boolean bl8 = databaseData.isSetMetadata();
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (!this.metadata.equals(databaseData.metadata)) {
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
        n = n * 8191 + (this.isSetUrlImage() ? 131071 : 524287);
        if (this.isSetUrlImage()) {
            n = n * 8191 + this.urlImage.hashCode();
        }
        n = n * 8191 + (this.isSetUrlThumbnail() ? 131071 : 524287);
        if (this.isSetUrlThumbnail()) {
            n = n * 8191 + this.urlThumbnail.hashCode();
        }
        n = n * 8191 + (this.isSetMetadata() ? 131071 : 524287);
        if (this.isSetMetadata()) {
            n = n * 8191 + this.metadata.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(DatabaseData databaseData) {
        if (!this.getClass().equals(databaseData.getClass())) {
            return this.getClass().getName().compareTo(databaseData.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetName(), databaseData.isSetName());
        if (n != 0) {
            return n;
        }
        if (this.isSetName() && (n = TBaseHelper.compareTo((String)this.name, (String)databaseData.name)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetUrlImage(), databaseData.isSetUrlImage());
        if (n != 0) {
            return n;
        }
        if (this.isSetUrlImage() && (n = TBaseHelper.compareTo((String)this.urlImage, (String)databaseData.urlImage)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetUrlThumbnail(), databaseData.isSetUrlThumbnail());
        if (n != 0) {
            return n;
        }
        if (this.isSetUrlThumbnail() && (n = TBaseHelper.compareTo((String)this.urlThumbnail, (String)databaseData.urlThumbnail)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetMetadata(), databaseData.isSetMetadata());
        if (n != 0) {
            return n;
        }
        if (this.isSetMetadata() && (n = TBaseHelper.compareTo((String)this.metadata, (String)databaseData.metadata)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        DatabaseData.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        DatabaseData.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("DatabaseData(");
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
        stringBuilder.append("urlImage:");
        if (this.urlImage == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.urlImage);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("urlThumbnail:");
        if (this.urlThumbnail == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.urlThumbnail);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("metadata:");
        if (this.metadata == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.metadata);
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
        enumMap.put(_Fields.NAME, new FieldMetaData("name", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.URL_IMAGE, new FieldMetaData("urlImage", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.URL_THUMBNAIL, new FieldMetaData("urlThumbnail", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.METADATA, new FieldMetaData("metadata", 3, new FieldValueMetaData(11)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(DatabaseData.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        NAME(1, "name"),
        URL_IMAGE(2, "urlImage"),
        URL_THUMBNAIL(3, "urlThumbnail"),
        METADATA(4, "metadata");

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
                    return URL_IMAGE;
                }
                case 3: {
                    return URL_THUMBNAIL;
                }
                case 4: {
                    return METADATA;
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

    private static class DatabaseDataStandardSchemeFactory
    implements SchemeFactory {
        private DatabaseDataStandardSchemeFactory() {
        }

        public DatabaseDataStandardScheme getScheme() {
            return new DatabaseDataStandardScheme();
        }
    }

    private static class DatabaseDataTupleSchemeFactory
    implements SchemeFactory {
        private DatabaseDataTupleSchemeFactory() {
        }

        public DatabaseDataTupleScheme getScheme() {
            return new DatabaseDataTupleScheme();
        }
    }

    private static class DatabaseDataTupleScheme
    extends TupleScheme<DatabaseData> {
        private DatabaseDataTupleScheme() {
        }

        public void write(TProtocol tProtocol, DatabaseData databaseData) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (databaseData.isSetName()) {
                bitSet.set(0);
            }
            if (databaseData.isSetUrlImage()) {
                bitSet.set(1);
            }
            if (databaseData.isSetUrlThumbnail()) {
                bitSet.set(2);
            }
            if (databaseData.isSetMetadata()) {
                bitSet.set(3);
            }
            tTupleProtocol.writeBitSet(bitSet, 4);
            if (databaseData.isSetName()) {
                tTupleProtocol.writeString(databaseData.name);
            }
            if (databaseData.isSetUrlImage()) {
                tTupleProtocol.writeString(databaseData.urlImage);
            }
            if (databaseData.isSetUrlThumbnail()) {
                tTupleProtocol.writeString(databaseData.urlThumbnail);
            }
            if (databaseData.isSetMetadata()) {
                tTupleProtocol.writeString(databaseData.metadata);
            }
        }

        public void read(TProtocol tProtocol, DatabaseData databaseData) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(4);
            if (bitSet.get(0)) {
                databaseData.name = tTupleProtocol.readString();
                databaseData.setNameIsSet(true);
            }
            if (bitSet.get(1)) {
                databaseData.urlImage = tTupleProtocol.readString();
                databaseData.setUrlImageIsSet(true);
            }
            if (bitSet.get(2)) {
                databaseData.urlThumbnail = tTupleProtocol.readString();
                databaseData.setUrlThumbnailIsSet(true);
            }
            if (bitSet.get(3)) {
                databaseData.metadata = tTupleProtocol.readString();
                databaseData.setMetadataIsSet(true);
            }
        }
    }

    private static class DatabaseDataStandardScheme
    extends StandardScheme<DatabaseData> {
        private DatabaseDataStandardScheme() {
        }

        public void read(TProtocol tProtocol, DatabaseData databaseData) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 11) {
                            databaseData.name = tProtocol.readString();
                            databaseData.setNameIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 11) {
                            databaseData.urlImage = tProtocol.readString();
                            databaseData.setUrlImageIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 11) {
                            databaseData.urlThumbnail = tProtocol.readString();
                            databaseData.setUrlThumbnailIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 11) {
                            databaseData.metadata = tProtocol.readString();
                            databaseData.setMetadataIsSet(true);
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
            databaseData.validate();
        }

        public void write(TProtocol tProtocol, DatabaseData databaseData) throws TException {
            databaseData.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (databaseData.name != null) {
                tProtocol.writeFieldBegin(NAME_FIELD_DESC);
                tProtocol.writeString(databaseData.name);
                tProtocol.writeFieldEnd();
            }
            if (databaseData.urlImage != null) {
                tProtocol.writeFieldBegin(URL_IMAGE_FIELD_DESC);
                tProtocol.writeString(databaseData.urlImage);
                tProtocol.writeFieldEnd();
            }
            if (databaseData.urlThumbnail != null) {
                tProtocol.writeFieldBegin(URL_THUMBNAIL_FIELD_DESC);
                tProtocol.writeString(databaseData.urlThumbnail);
                tProtocol.writeFieldEnd();
            }
            if (databaseData.metadata != null) {
                tProtocol.writeFieldBegin(METADATA_FIELD_DESC);
                tProtocol.writeString(databaseData.metadata);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

