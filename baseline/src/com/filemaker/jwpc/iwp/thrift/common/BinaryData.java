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
import java.nio.ByteBuffer;
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

public class BinaryData
implements TBase<BinaryData, _Fields>,
Serializable,
Cloneable,
Comparable<BinaryData> {
    private static final TStruct STRUCT_DESC = new TStruct("BinaryData");
    private static final TField NAME_FIELD_DESC = new TField("name", 11, 1);
    private static final TField TYPE_FIELD_DESC = new TField("type", 11, 2);
    private static final TField DATA_FIELD_DESC = new TField("data", 11, 3);
    private static final TField THUMBNAIL_FIELD_DESC = new TField("thumbnail", 2, 4);
    private static final TField IMAGE_WIDTH_FIELD_DESC = new TField("imageWidth", 8, 5);
    private static final TField IMAGE_HEIGHT_FIELD_DESC = new TField("imageHeight", 8, 6);
    private static final TField CONTENT_RECT_WIDTH_FIELD_DESC = new TField("contentRectWidth", 8, 7);
    private static final TField CONTENT_RECT_HEIGHT_FIELD_DESC = new TField("contentRectHeight", 8, 8);
    private static final TField URL_FIELD_DESC = new TField("url", 11, 9);
    private static final TField VALID_FIELD_DESC = new TField("valid", 2, 10);
    private static final TField MASTER_TYPE_FIELD_DESC = new TField("masterType", 11, 11);
    private static final TField FIELD_IS_WEB_CONTAINER_FIELD_DESC = new TField("fieldIsWebContainer", 2, 12);
    private static final TField FILE_REFERENCE_FIELD_DESC = new TField("fileReference", 2, 13);
    private static final TField DISPLAY_TYPE_FIELD_DESC = new TField("displayType", 11, 14);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new BinaryDataStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new BinaryDataTupleSchemeFactory();
    @Nullable
    private String name;
    @Nullable
    private String type;
    @Nullable
    private ByteBuffer data;
    private boolean thumbnail;
    private int imageWidth;
    private int imageHeight;
    private int contentRectWidth;
    private int contentRectHeight;
    @Nullable
    private String url;
    private boolean valid;
    @Nullable
    private String masterType;
    private boolean fieldIsWebContainer;
    private boolean fileReference;
    @Nullable
    private String displayType;
    private static final int __THUMBNAIL_ISSET_ID = 0;
    private static final int __IMAGEWIDTH_ISSET_ID = 1;
    private static final int __IMAGEHEIGHT_ISSET_ID = 2;
    private static final int __CONTENTRECTWIDTH_ISSET_ID = 3;
    private static final int __CONTENTRECTHEIGHT_ISSET_ID = 4;
    private static final int __VALID_ISSET_ID = 5;
    private static final int __FIELDISWEBCONTAINER_ISSET_ID = 6;
    private static final int __FILEREFERENCE_ISSET_ID = 7;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public BinaryData() {
    }

    public BinaryData(String string, String string2, ByteBuffer byteBuffer, boolean bl, int n, int n2, int n3, int n4, String string3, boolean bl2, String string4, boolean bl3, boolean bl4, String string5) {
        this();
        this.name = string;
        this.type = string2;
        this.data = TBaseHelper.copyBinary((ByteBuffer)byteBuffer);
        this.thumbnail = bl;
        this.setThumbnailIsSet(true);
        this.imageWidth = n;
        this.setImageWidthIsSet(true);
        this.imageHeight = n2;
        this.setImageHeightIsSet(true);
        this.contentRectWidth = n3;
        this.setContentRectWidthIsSet(true);
        this.contentRectHeight = n4;
        this.setContentRectHeightIsSet(true);
        this.url = string3;
        this.valid = bl2;
        this.setValidIsSet(true);
        this.masterType = string4;
        this.fieldIsWebContainer = bl3;
        this.setFieldIsWebContainerIsSet(true);
        this.fileReference = bl4;
        this.setFileReferenceIsSet(true);
        this.displayType = string5;
    }

    public BinaryData(BinaryData binaryData) {
        this.__isset_bitfield = binaryData.__isset_bitfield;
        if (binaryData.isSetName()) {
            this.name = binaryData.name;
        }
        if (binaryData.isSetType()) {
            this.type = binaryData.type;
        }
        if (binaryData.isSetData()) {
            this.data = TBaseHelper.copyBinary((ByteBuffer)binaryData.data);
        }
        this.thumbnail = binaryData.thumbnail;
        this.imageWidth = binaryData.imageWidth;
        this.imageHeight = binaryData.imageHeight;
        this.contentRectWidth = binaryData.contentRectWidth;
        this.contentRectHeight = binaryData.contentRectHeight;
        if (binaryData.isSetUrl()) {
            this.url = binaryData.url;
        }
        this.valid = binaryData.valid;
        if (binaryData.isSetMasterType()) {
            this.masterType = binaryData.masterType;
        }
        this.fieldIsWebContainer = binaryData.fieldIsWebContainer;
        this.fileReference = binaryData.fileReference;
        if (binaryData.isSetDisplayType()) {
            this.displayType = binaryData.displayType;
        }
    }

    public BinaryData deepCopy() {
        return new BinaryData(this);
    }

    public void clear() {
        this.name = null;
        this.type = null;
        this.data = null;
        this.setThumbnailIsSet(false);
        this.thumbnail = false;
        this.setImageWidthIsSet(false);
        this.imageWidth = 0;
        this.setImageHeightIsSet(false);
        this.imageHeight = 0;
        this.setContentRectWidthIsSet(false);
        this.contentRectWidth = 0;
        this.setContentRectHeightIsSet(false);
        this.contentRectHeight = 0;
        this.url = null;
        this.setValidIsSet(false);
        this.valid = false;
        this.masterType = null;
        this.setFieldIsWebContainerIsSet(false);
        this.fieldIsWebContainer = false;
        this.setFileReferenceIsSet(false);
        this.fileReference = false;
        this.displayType = null;
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
    public String getType() {
        return this.type;
    }

    public void setType(@Nullable String string) {
        this.type = string;
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

    public byte[] getData() {
        this.setData(TBaseHelper.rightSize((ByteBuffer)this.data));
        return this.data == null ? null : this.data.array();
    }

    public ByteBuffer bufferForData() {
        return TBaseHelper.copyBinary((ByteBuffer)this.data);
    }

    public void setData(byte[] byArray) {
        this.data = byArray == null ? (ByteBuffer)null : ByteBuffer.wrap((byte[])byArray.clone());
    }

    public void setData(@Nullable ByteBuffer byteBuffer) {
        this.data = TBaseHelper.copyBinary((ByteBuffer)byteBuffer);
    }

    public void unsetData() {
        this.data = null;
    }

    public boolean isSetData() {
        return this.data != null;
    }

    public void setDataIsSet(boolean bl) {
        if (!bl) {
            this.data = null;
        }
    }

    public boolean isThumbnail() {
        return this.thumbnail;
    }

    public void setThumbnail(boolean bl) {
        this.thumbnail = bl;
        this.setThumbnailIsSet(true);
    }

    public void unsetThumbnail() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetThumbnail() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setThumbnailIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public int getImageWidth() {
        return this.imageWidth;
    }

    public void setImageWidth(int n) {
        this.imageWidth = n;
        this.setImageWidthIsSet(true);
    }

    public void unsetImageWidth() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)1);
    }

    public boolean isSetImageWidth() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)1);
    }

    public void setImageWidthIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)1, (boolean)bl);
    }

    public int getImageHeight() {
        return this.imageHeight;
    }

    public void setImageHeight(int n) {
        this.imageHeight = n;
        this.setImageHeightIsSet(true);
    }

    public void unsetImageHeight() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)2);
    }

    public boolean isSetImageHeight() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)2);
    }

    public void setImageHeightIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)2, (boolean)bl);
    }

    public int getContentRectWidth() {
        return this.contentRectWidth;
    }

    public void setContentRectWidth(int n) {
        this.contentRectWidth = n;
        this.setContentRectWidthIsSet(true);
    }

    public void unsetContentRectWidth() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)3);
    }

    public boolean isSetContentRectWidth() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)3);
    }

    public void setContentRectWidthIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)3, (boolean)bl);
    }

    public int getContentRectHeight() {
        return this.contentRectHeight;
    }

    public void setContentRectHeight(int n) {
        this.contentRectHeight = n;
        this.setContentRectHeightIsSet(true);
    }

    public void unsetContentRectHeight() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)4);
    }

    public boolean isSetContentRectHeight() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)4);
    }

    public void setContentRectHeightIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)4, (boolean)bl);
    }

    @Nullable
    public String getUrl() {
        return this.url;
    }

    public void setUrl(@Nullable String string) {
        this.url = string;
    }

    public void unsetUrl() {
        this.url = null;
    }

    public boolean isSetUrl() {
        return this.url != null;
    }

    public void setUrlIsSet(boolean bl) {
        if (!bl) {
            this.url = null;
        }
    }

    public boolean isValid() {
        return this.valid;
    }

    public void setValid(boolean bl) {
        this.valid = bl;
        this.setValidIsSet(true);
    }

    public void unsetValid() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)5);
    }

    public boolean isSetValid() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)5);
    }

    public void setValidIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)5, (boolean)bl);
    }

    @Nullable
    public String getMasterType() {
        return this.masterType;
    }

    public void setMasterType(@Nullable String string) {
        this.masterType = string;
    }

    public void unsetMasterType() {
        this.masterType = null;
    }

    public boolean isSetMasterType() {
        return this.masterType != null;
    }

    public void setMasterTypeIsSet(boolean bl) {
        if (!bl) {
            this.masterType = null;
        }
    }

    public boolean isFieldIsWebContainer() {
        return this.fieldIsWebContainer;
    }

    public void setFieldIsWebContainer(boolean bl) {
        this.fieldIsWebContainer = bl;
        this.setFieldIsWebContainerIsSet(true);
    }

    public void unsetFieldIsWebContainer() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)6);
    }

    public boolean isSetFieldIsWebContainer() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)6);
    }

    public void setFieldIsWebContainerIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)6, (boolean)bl);
    }

    public boolean isFileReference() {
        return this.fileReference;
    }

    public void setFileReference(boolean bl) {
        this.fileReference = bl;
        this.setFileReferenceIsSet(true);
    }

    public void unsetFileReference() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)7);
    }

    public boolean isSetFileReference() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)7);
    }

    public void setFileReferenceIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)7, (boolean)bl);
    }

    @Nullable
    public String getDisplayType() {
        return this.displayType;
    }

    public void setDisplayType(@Nullable String string) {
        this.displayType = string;
    }

    public void unsetDisplayType() {
        this.displayType = null;
    }

    public boolean isSetDisplayType() {
        return this.displayType != null;
    }

    public void setDisplayTypeIsSet(boolean bl) {
        if (!bl) {
            this.displayType = null;
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
                    this.unsetType();
                    break;
                }
                this.setType((String)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetData();
                    break;
                }
                if (object instanceof byte[]) {
                    this.setData((byte[])object);
                    break;
                }
                this.setData((ByteBuffer)object);
                break;
            }
            case 3: {
                if (object == null) {
                    this.unsetThumbnail();
                    break;
                }
                this.setThumbnail((Boolean)object);
                break;
            }
            case 4: {
                if (object == null) {
                    this.unsetImageWidth();
                    break;
                }
                this.setImageWidth((Integer)object);
                break;
            }
            case 5: {
                if (object == null) {
                    this.unsetImageHeight();
                    break;
                }
                this.setImageHeight((Integer)object);
                break;
            }
            case 6: {
                if (object == null) {
                    this.unsetContentRectWidth();
                    break;
                }
                this.setContentRectWidth((Integer)object);
                break;
            }
            case 7: {
                if (object == null) {
                    this.unsetContentRectHeight();
                    break;
                }
                this.setContentRectHeight((Integer)object);
                break;
            }
            case 8: {
                if (object == null) {
                    this.unsetUrl();
                    break;
                }
                this.setUrl((String)object);
                break;
            }
            case 9: {
                if (object == null) {
                    this.unsetValid();
                    break;
                }
                this.setValid((Boolean)object);
                break;
            }
            case 10: {
                if (object == null) {
                    this.unsetMasterType();
                    break;
                }
                this.setMasterType((String)object);
                break;
            }
            case 11: {
                if (object == null) {
                    this.unsetFieldIsWebContainer();
                    break;
                }
                this.setFieldIsWebContainer((Boolean)object);
                break;
            }
            case 12: {
                if (object == null) {
                    this.unsetFileReference();
                    break;
                }
                this.setFileReference((Boolean)object);
                break;
            }
            case 13: {
                if (object == null) {
                    this.unsetDisplayType();
                    break;
                }
                this.setDisplayType((String)object);
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
                return this.getType();
            }
            case 2: {
                return this.getData();
            }
            case 3: {
                return this.isThumbnail();
            }
            case 4: {
                return this.getImageWidth();
            }
            case 5: {
                return this.getImageHeight();
            }
            case 6: {
                return this.getContentRectWidth();
            }
            case 7: {
                return this.getContentRectHeight();
            }
            case 8: {
                return this.getUrl();
            }
            case 9: {
                return this.isValid();
            }
            case 10: {
                return this.getMasterType();
            }
            case 11: {
                return this.isFieldIsWebContainer();
            }
            case 12: {
                return this.isFileReference();
            }
            case 13: {
                return this.getDisplayType();
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
                return this.isSetType();
            }
            case 2: {
                return this.isSetData();
            }
            case 3: {
                return this.isSetThumbnail();
            }
            case 4: {
                return this.isSetImageWidth();
            }
            case 5: {
                return this.isSetImageHeight();
            }
            case 6: {
                return this.isSetContentRectWidth();
            }
            case 7: {
                return this.isSetContentRectHeight();
            }
            case 8: {
                return this.isSetUrl();
            }
            case 9: {
                return this.isSetValid();
            }
            case 10: {
                return this.isSetMasterType();
            }
            case 11: {
                return this.isSetFieldIsWebContainer();
            }
            case 12: {
                return this.isSetFileReference();
            }
            case 13: {
                return this.isSetDisplayType();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof BinaryData) {
            return this.equals((BinaryData)object);
        }
        return false;
    }

    public boolean equals(BinaryData binaryData) {
        if (binaryData == null) {
            return false;
        }
        if (this == binaryData) {
            return true;
        }
        boolean bl = this.isSetName();
        boolean bl2 = binaryData.isSetName();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.name.equals(binaryData.name)) {
                return false;
            }
        }
        boolean bl3 = this.isSetType();
        boolean bl4 = binaryData.isSetType();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.type.equals(binaryData.type)) {
                return false;
            }
        }
        boolean bl5 = this.isSetData();
        boolean bl6 = binaryData.isSetData();
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (!this.data.equals(binaryData.data)) {
                return false;
            }
        }
        boolean bl7 = true;
        boolean bl8 = true;
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (this.thumbnail != binaryData.thumbnail) {
                return false;
            }
        }
        boolean bl9 = true;
        boolean bl10 = true;
        if (bl9 || bl10) {
            if (!bl9 || !bl10) {
                return false;
            }
            if (this.imageWidth != binaryData.imageWidth) {
                return false;
            }
        }
        boolean bl11 = true;
        boolean bl12 = true;
        if (bl11 || bl12) {
            if (!bl11 || !bl12) {
                return false;
            }
            if (this.imageHeight != binaryData.imageHeight) {
                return false;
            }
        }
        boolean bl13 = true;
        boolean bl14 = true;
        if (bl13 || bl14) {
            if (!bl13 || !bl14) {
                return false;
            }
            if (this.contentRectWidth != binaryData.contentRectWidth) {
                return false;
            }
        }
        boolean bl15 = true;
        boolean bl16 = true;
        if (bl15 || bl16) {
            if (!bl15 || !bl16) {
                return false;
            }
            if (this.contentRectHeight != binaryData.contentRectHeight) {
                return false;
            }
        }
        boolean bl17 = this.isSetUrl();
        boolean bl18 = binaryData.isSetUrl();
        if (bl17 || bl18) {
            if (!bl17 || !bl18) {
                return false;
            }
            if (!this.url.equals(binaryData.url)) {
                return false;
            }
        }
        boolean bl19 = true;
        boolean bl20 = true;
        if (bl19 || bl20) {
            if (!bl19 || !bl20) {
                return false;
            }
            if (this.valid != binaryData.valid) {
                return false;
            }
        }
        boolean bl21 = this.isSetMasterType();
        boolean bl22 = binaryData.isSetMasterType();
        if (bl21 || bl22) {
            if (!bl21 || !bl22) {
                return false;
            }
            if (!this.masterType.equals(binaryData.masterType)) {
                return false;
            }
        }
        boolean bl23 = true;
        boolean bl24 = true;
        if (bl23 || bl24) {
            if (!bl23 || !bl24) {
                return false;
            }
            if (this.fieldIsWebContainer != binaryData.fieldIsWebContainer) {
                return false;
            }
        }
        boolean bl25 = true;
        boolean bl26 = true;
        if (bl25 || bl26) {
            if (!bl25 || !bl26) {
                return false;
            }
            if (this.fileReference != binaryData.fileReference) {
                return false;
            }
        }
        boolean bl27 = this.isSetDisplayType();
        boolean bl28 = binaryData.isSetDisplayType();
        if (bl27 || bl28) {
            if (!bl27 || !bl28) {
                return false;
            }
            if (!this.displayType.equals(binaryData.displayType)) {
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
        n = n * 8191 + (this.isSetType() ? 131071 : 524287);
        if (this.isSetType()) {
            n = n * 8191 + this.type.hashCode();
        }
        n = n * 8191 + (this.isSetData() ? 131071 : 524287);
        if (this.isSetData()) {
            n = n * 8191 + this.data.hashCode();
        }
        n = n * 8191 + (this.thumbnail ? 131071 : 524287);
        n = n * 8191 + this.imageWidth;
        n = n * 8191 + this.imageHeight;
        n = n * 8191 + this.contentRectWidth;
        n = n * 8191 + this.contentRectHeight;
        n = n * 8191 + (this.isSetUrl() ? 131071 : 524287);
        if (this.isSetUrl()) {
            n = n * 8191 + this.url.hashCode();
        }
        n = n * 8191 + (this.valid ? 131071 : 524287);
        n = n * 8191 + (this.isSetMasterType() ? 131071 : 524287);
        if (this.isSetMasterType()) {
            n = n * 8191 + this.masterType.hashCode();
        }
        n = n * 8191 + (this.fieldIsWebContainer ? 131071 : 524287);
        n = n * 8191 + (this.fileReference ? 131071 : 524287);
        n = n * 8191 + (this.isSetDisplayType() ? 131071 : 524287);
        if (this.isSetDisplayType()) {
            n = n * 8191 + this.displayType.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(BinaryData binaryData) {
        if (!this.getClass().equals(binaryData.getClass())) {
            return this.getClass().getName().compareTo(binaryData.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetName(), binaryData.isSetName());
        if (n != 0) {
            return n;
        }
        if (this.isSetName() && (n = TBaseHelper.compareTo((String)this.name, (String)binaryData.name)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetType(), binaryData.isSetType());
        if (n != 0) {
            return n;
        }
        if (this.isSetType() && (n = TBaseHelper.compareTo((String)this.type, (String)binaryData.type)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetData(), binaryData.isSetData());
        if (n != 0) {
            return n;
        }
        if (this.isSetData() && (n = TBaseHelper.compareTo((Comparable)this.data, (Comparable)binaryData.data)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetThumbnail(), binaryData.isSetThumbnail());
        if (n != 0) {
            return n;
        }
        if (this.isSetThumbnail() && (n = TBaseHelper.compareTo((boolean)this.thumbnail, (boolean)binaryData.thumbnail)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetImageWidth(), binaryData.isSetImageWidth());
        if (n != 0) {
            return n;
        }
        if (this.isSetImageWidth() && (n = TBaseHelper.compareTo((int)this.imageWidth, (int)binaryData.imageWidth)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetImageHeight(), binaryData.isSetImageHeight());
        if (n != 0) {
            return n;
        }
        if (this.isSetImageHeight() && (n = TBaseHelper.compareTo((int)this.imageHeight, (int)binaryData.imageHeight)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetContentRectWidth(), binaryData.isSetContentRectWidth());
        if (n != 0) {
            return n;
        }
        if (this.isSetContentRectWidth() && (n = TBaseHelper.compareTo((int)this.contentRectWidth, (int)binaryData.contentRectWidth)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetContentRectHeight(), binaryData.isSetContentRectHeight());
        if (n != 0) {
            return n;
        }
        if (this.isSetContentRectHeight() && (n = TBaseHelper.compareTo((int)this.contentRectHeight, (int)binaryData.contentRectHeight)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetUrl(), binaryData.isSetUrl());
        if (n != 0) {
            return n;
        }
        if (this.isSetUrl() && (n = TBaseHelper.compareTo((String)this.url, (String)binaryData.url)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetValid(), binaryData.isSetValid());
        if (n != 0) {
            return n;
        }
        if (this.isSetValid() && (n = TBaseHelper.compareTo((boolean)this.valid, (boolean)binaryData.valid)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetMasterType(), binaryData.isSetMasterType());
        if (n != 0) {
            return n;
        }
        if (this.isSetMasterType() && (n = TBaseHelper.compareTo((String)this.masterType, (String)binaryData.masterType)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetFieldIsWebContainer(), binaryData.isSetFieldIsWebContainer());
        if (n != 0) {
            return n;
        }
        if (this.isSetFieldIsWebContainer() && (n = TBaseHelper.compareTo((boolean)this.fieldIsWebContainer, (boolean)binaryData.fieldIsWebContainer)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetFileReference(), binaryData.isSetFileReference());
        if (n != 0) {
            return n;
        }
        if (this.isSetFileReference() && (n = TBaseHelper.compareTo((boolean)this.fileReference, (boolean)binaryData.fileReference)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetDisplayType(), binaryData.isSetDisplayType());
        if (n != 0) {
            return n;
        }
        if (this.isSetDisplayType() && (n = TBaseHelper.compareTo((String)this.displayType, (String)binaryData.displayType)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        BinaryData.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        BinaryData.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("BinaryData(");
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
        stringBuilder.append("type:");
        if (this.type == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.type);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("data:");
        if (this.data == null) {
            stringBuilder.append("null");
        } else {
            TBaseHelper.toString((ByteBuffer)this.data, (StringBuilder)stringBuilder);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("thumbnail:");
        stringBuilder.append(this.thumbnail);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("imageWidth:");
        stringBuilder.append(this.imageWidth);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("imageHeight:");
        stringBuilder.append(this.imageHeight);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("contentRectWidth:");
        stringBuilder.append(this.contentRectWidth);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("contentRectHeight:");
        stringBuilder.append(this.contentRectHeight);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("url:");
        if (this.url == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.url);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("valid:");
        stringBuilder.append(this.valid);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("masterType:");
        if (this.masterType == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.masterType);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("fieldIsWebContainer:");
        stringBuilder.append(this.fieldIsWebContainer);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("fileReference:");
        stringBuilder.append(this.fileReference);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("displayType:");
        if (this.displayType == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.displayType);
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
        enumMap.put(_Fields.TYPE, new FieldMetaData("type", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.DATA, new FieldMetaData("data", 3, new FieldValueMetaData(11, true)));
        enumMap.put(_Fields.THUMBNAIL, new FieldMetaData("thumbnail", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.IMAGE_WIDTH, new FieldMetaData("imageWidth", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.IMAGE_HEIGHT, new FieldMetaData("imageHeight", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.CONTENT_RECT_WIDTH, new FieldMetaData("contentRectWidth", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.CONTENT_RECT_HEIGHT, new FieldMetaData("contentRectHeight", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.URL, new FieldMetaData("url", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.VALID, new FieldMetaData("valid", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.MASTER_TYPE, new FieldMetaData("masterType", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.FIELD_IS_WEB_CONTAINER, new FieldMetaData("fieldIsWebContainer", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.FILE_REFERENCE, new FieldMetaData("fileReference", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.DISPLAY_TYPE, new FieldMetaData("displayType", 3, new FieldValueMetaData(11)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(BinaryData.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        NAME(1, "name"),
        TYPE(2, "type"),
        DATA(3, "data"),
        THUMBNAIL(4, "thumbnail"),
        IMAGE_WIDTH(5, "imageWidth"),
        IMAGE_HEIGHT(6, "imageHeight"),
        CONTENT_RECT_WIDTH(7, "contentRectWidth"),
        CONTENT_RECT_HEIGHT(8, "contentRectHeight"),
        URL(9, "url"),
        VALID(10, "valid"),
        MASTER_TYPE(11, "masterType"),
        FIELD_IS_WEB_CONTAINER(12, "fieldIsWebContainer"),
        FILE_REFERENCE(13, "fileReference"),
        DISPLAY_TYPE(14, "displayType");

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
                    return TYPE;
                }
                case 3: {
                    return DATA;
                }
                case 4: {
                    return THUMBNAIL;
                }
                case 5: {
                    return IMAGE_WIDTH;
                }
                case 6: {
                    return IMAGE_HEIGHT;
                }
                case 7: {
                    return CONTENT_RECT_WIDTH;
                }
                case 8: {
                    return CONTENT_RECT_HEIGHT;
                }
                case 9: {
                    return URL;
                }
                case 10: {
                    return VALID;
                }
                case 11: {
                    return MASTER_TYPE;
                }
                case 12: {
                    return FIELD_IS_WEB_CONTAINER;
                }
                case 13: {
                    return FILE_REFERENCE;
                }
                case 14: {
                    return DISPLAY_TYPE;
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

    private static class BinaryDataStandardSchemeFactory
    implements SchemeFactory {
        private BinaryDataStandardSchemeFactory() {
        }

        public BinaryDataStandardScheme getScheme() {
            return new BinaryDataStandardScheme();
        }
    }

    private static class BinaryDataTupleSchemeFactory
    implements SchemeFactory {
        private BinaryDataTupleSchemeFactory() {
        }

        public BinaryDataTupleScheme getScheme() {
            return new BinaryDataTupleScheme();
        }
    }

    private static class BinaryDataTupleScheme
    extends TupleScheme<BinaryData> {
        private BinaryDataTupleScheme() {
        }

        public void write(TProtocol tProtocol, BinaryData binaryData) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (binaryData.isSetName()) {
                bitSet.set(0);
            }
            if (binaryData.isSetType()) {
                bitSet.set(1);
            }
            if (binaryData.isSetData()) {
                bitSet.set(2);
            }
            if (binaryData.isSetThumbnail()) {
                bitSet.set(3);
            }
            if (binaryData.isSetImageWidth()) {
                bitSet.set(4);
            }
            if (binaryData.isSetImageHeight()) {
                bitSet.set(5);
            }
            if (binaryData.isSetContentRectWidth()) {
                bitSet.set(6);
            }
            if (binaryData.isSetContentRectHeight()) {
                bitSet.set(7);
            }
            if (binaryData.isSetUrl()) {
                bitSet.set(8);
            }
            if (binaryData.isSetValid()) {
                bitSet.set(9);
            }
            if (binaryData.isSetMasterType()) {
                bitSet.set(10);
            }
            if (binaryData.isSetFieldIsWebContainer()) {
                bitSet.set(11);
            }
            if (binaryData.isSetFileReference()) {
                bitSet.set(12);
            }
            if (binaryData.isSetDisplayType()) {
                bitSet.set(13);
            }
            tTupleProtocol.writeBitSet(bitSet, 14);
            if (binaryData.isSetName()) {
                tTupleProtocol.writeString(binaryData.name);
            }
            if (binaryData.isSetType()) {
                tTupleProtocol.writeString(binaryData.type);
            }
            if (binaryData.isSetData()) {
                tTupleProtocol.writeBinary(binaryData.data);
            }
            if (binaryData.isSetThumbnail()) {
                tTupleProtocol.writeBool(binaryData.thumbnail);
            }
            if (binaryData.isSetImageWidth()) {
                tTupleProtocol.writeI32(binaryData.imageWidth);
            }
            if (binaryData.isSetImageHeight()) {
                tTupleProtocol.writeI32(binaryData.imageHeight);
            }
            if (binaryData.isSetContentRectWidth()) {
                tTupleProtocol.writeI32(binaryData.contentRectWidth);
            }
            if (binaryData.isSetContentRectHeight()) {
                tTupleProtocol.writeI32(binaryData.contentRectHeight);
            }
            if (binaryData.isSetUrl()) {
                tTupleProtocol.writeString(binaryData.url);
            }
            if (binaryData.isSetValid()) {
                tTupleProtocol.writeBool(binaryData.valid);
            }
            if (binaryData.isSetMasterType()) {
                tTupleProtocol.writeString(binaryData.masterType);
            }
            if (binaryData.isSetFieldIsWebContainer()) {
                tTupleProtocol.writeBool(binaryData.fieldIsWebContainer);
            }
            if (binaryData.isSetFileReference()) {
                tTupleProtocol.writeBool(binaryData.fileReference);
            }
            if (binaryData.isSetDisplayType()) {
                tTupleProtocol.writeString(binaryData.displayType);
            }
        }

        public void read(TProtocol tProtocol, BinaryData binaryData) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(14);
            if (bitSet.get(0)) {
                binaryData.name = tTupleProtocol.readString();
                binaryData.setNameIsSet(true);
            }
            if (bitSet.get(1)) {
                binaryData.type = tTupleProtocol.readString();
                binaryData.setTypeIsSet(true);
            }
            if (bitSet.get(2)) {
                binaryData.data = tTupleProtocol.readBinary();
                binaryData.setDataIsSet(true);
            }
            if (bitSet.get(3)) {
                binaryData.thumbnail = tTupleProtocol.readBool();
                binaryData.setThumbnailIsSet(true);
            }
            if (bitSet.get(4)) {
                binaryData.imageWidth = tTupleProtocol.readI32();
                binaryData.setImageWidthIsSet(true);
            }
            if (bitSet.get(5)) {
                binaryData.imageHeight = tTupleProtocol.readI32();
                binaryData.setImageHeightIsSet(true);
            }
            if (bitSet.get(6)) {
                binaryData.contentRectWidth = tTupleProtocol.readI32();
                binaryData.setContentRectWidthIsSet(true);
            }
            if (bitSet.get(7)) {
                binaryData.contentRectHeight = tTupleProtocol.readI32();
                binaryData.setContentRectHeightIsSet(true);
            }
            if (bitSet.get(8)) {
                binaryData.url = tTupleProtocol.readString();
                binaryData.setUrlIsSet(true);
            }
            if (bitSet.get(9)) {
                binaryData.valid = tTupleProtocol.readBool();
                binaryData.setValidIsSet(true);
            }
            if (bitSet.get(10)) {
                binaryData.masterType = tTupleProtocol.readString();
                binaryData.setMasterTypeIsSet(true);
            }
            if (bitSet.get(11)) {
                binaryData.fieldIsWebContainer = tTupleProtocol.readBool();
                binaryData.setFieldIsWebContainerIsSet(true);
            }
            if (bitSet.get(12)) {
                binaryData.fileReference = tTupleProtocol.readBool();
                binaryData.setFileReferenceIsSet(true);
            }
            if (bitSet.get(13)) {
                binaryData.displayType = tTupleProtocol.readString();
                binaryData.setDisplayTypeIsSet(true);
            }
        }
    }

    private static class BinaryDataStandardScheme
    extends StandardScheme<BinaryData> {
        private BinaryDataStandardScheme() {
        }

        public void read(TProtocol tProtocol, BinaryData binaryData) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 11) {
                            binaryData.name = tProtocol.readString();
                            binaryData.setNameIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 11) {
                            binaryData.type = tProtocol.readString();
                            binaryData.setTypeIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 11) {
                            binaryData.data = tProtocol.readBinary();
                            binaryData.setDataIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 2) {
                            binaryData.thumbnail = tProtocol.readBool();
                            binaryData.setThumbnailIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 5: {
                        if (tField.type == 8) {
                            binaryData.imageWidth = tProtocol.readI32();
                            binaryData.setImageWidthIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 6: {
                        if (tField.type == 8) {
                            binaryData.imageHeight = tProtocol.readI32();
                            binaryData.setImageHeightIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 7: {
                        if (tField.type == 8) {
                            binaryData.contentRectWidth = tProtocol.readI32();
                            binaryData.setContentRectWidthIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 8: {
                        if (tField.type == 8) {
                            binaryData.contentRectHeight = tProtocol.readI32();
                            binaryData.setContentRectHeightIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 9: {
                        if (tField.type == 11) {
                            binaryData.url = tProtocol.readString();
                            binaryData.setUrlIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 10: {
                        if (tField.type == 2) {
                            binaryData.valid = tProtocol.readBool();
                            binaryData.setValidIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 11: {
                        if (tField.type == 11) {
                            binaryData.masterType = tProtocol.readString();
                            binaryData.setMasterTypeIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 12: {
                        if (tField.type == 2) {
                            binaryData.fieldIsWebContainer = tProtocol.readBool();
                            binaryData.setFieldIsWebContainerIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 13: {
                        if (tField.type == 2) {
                            binaryData.fileReference = tProtocol.readBool();
                            binaryData.setFileReferenceIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 14: {
                        if (tField.type == 11) {
                            binaryData.displayType = tProtocol.readString();
                            binaryData.setDisplayTypeIsSet(true);
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
            binaryData.validate();
        }

        public void write(TProtocol tProtocol, BinaryData binaryData) throws TException {
            binaryData.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (binaryData.name != null) {
                tProtocol.writeFieldBegin(NAME_FIELD_DESC);
                tProtocol.writeString(binaryData.name);
                tProtocol.writeFieldEnd();
            }
            if (binaryData.type != null) {
                tProtocol.writeFieldBegin(TYPE_FIELD_DESC);
                tProtocol.writeString(binaryData.type);
                tProtocol.writeFieldEnd();
            }
            if (binaryData.data != null) {
                tProtocol.writeFieldBegin(DATA_FIELD_DESC);
                tProtocol.writeBinary(binaryData.data);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(THUMBNAIL_FIELD_DESC);
            tProtocol.writeBool(binaryData.thumbnail);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(IMAGE_WIDTH_FIELD_DESC);
            tProtocol.writeI32(binaryData.imageWidth);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(IMAGE_HEIGHT_FIELD_DESC);
            tProtocol.writeI32(binaryData.imageHeight);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(CONTENT_RECT_WIDTH_FIELD_DESC);
            tProtocol.writeI32(binaryData.contentRectWidth);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(CONTENT_RECT_HEIGHT_FIELD_DESC);
            tProtocol.writeI32(binaryData.contentRectHeight);
            tProtocol.writeFieldEnd();
            if (binaryData.url != null) {
                tProtocol.writeFieldBegin(URL_FIELD_DESC);
                tProtocol.writeString(binaryData.url);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(VALID_FIELD_DESC);
            tProtocol.writeBool(binaryData.valid);
            tProtocol.writeFieldEnd();
            if (binaryData.masterType != null) {
                tProtocol.writeFieldBegin(MASTER_TYPE_FIELD_DESC);
                tProtocol.writeString(binaryData.masterType);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(FIELD_IS_WEB_CONTAINER_FIELD_DESC);
            tProtocol.writeBool(binaryData.fieldIsWebContainer);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(FILE_REFERENCE_FIELD_DESC);
            tProtocol.writeBool(binaryData.fileReference);
            tProtocol.writeFieldEnd();
            if (binaryData.displayType != null) {
                tProtocol.writeFieldBegin(DISPLAY_TYPE_FIELD_DESC);
                tProtocol.writeString(binaryData.displayType);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

