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

import com.filemaker.jwpc.iwp.thrift.common.IWPError;
import com.filemaker.jwpc.iwp.thrift.common.LayoutFieldDataType;
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

public class ValidationErrorDialogNotification
implements TBase<ValidationErrorDialogNotification, _Fields>,
Serializable,
Cloneable,
Comparable<ValidationErrorDialogNotification> {
    private static final TStruct STRUCT_DESC = new TStruct("ValidationErrorDialogNotification");
    private static final TField MESSAGE_FIELD_DESC = new TField("message", 11, 1);
    private static final TField HAS_MESSAGE_FIELD_DESC = new TField("hasMessage", 2, 2);
    private static final TField ANOTHER_LAYOUT_MESSAGE_FIELD_DESC = new TField("anotherLayoutMessage", 2, 3);
    private static final TField ALLOW_REVERT_FIELD_DESC = new TField("allowRevert", 2, 4);
    private static final TField ALLOW_OVERRIDE_FIELD_DESC = new TField("allowOverride", 2, 5);
    private static final TField RECORD_LEVEL_VALIDATION_FIELD_DESC = new TField("recordLevelValidation", 2, 6);
    private static final TField STRICT_DATA_TYPE_FIELD_DESC = new TField("strictDataType", 2, 7);
    private static final TField FIELD_DATA_TYPE_FIELD_DESC = new TField("fieldDataType", 8, 8);
    private static final TField ERROR_FIELD_DESC = new TField("error", 12, 9);
    private static final TField SAMPLE_DATE_TIME_FORMAT_FIELD_DESC = new TField("sampleDateTimeFormat", 11, 10);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new ValidationErrorDialogNotificationStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new ValidationErrorDialogNotificationTupleSchemeFactory();
    @Nullable
    private String message;
    private boolean hasMessage;
    private boolean anotherLayoutMessage;
    private boolean allowRevert;
    private boolean allowOverride;
    private boolean recordLevelValidation;
    private boolean strictDataType;
    @Nullable
    private LayoutFieldDataType fieldDataType;
    @Nullable
    private IWPError error;
    @Nullable
    private String sampleDateTimeFormat;
    private static final int __HASMESSAGE_ISSET_ID = 0;
    private static final int __ANOTHERLAYOUTMESSAGE_ISSET_ID = 1;
    private static final int __ALLOWREVERT_ISSET_ID = 2;
    private static final int __ALLOWOVERRIDE_ISSET_ID = 3;
    private static final int __RECORDLEVELVALIDATION_ISSET_ID = 4;
    private static final int __STRICTDATATYPE_ISSET_ID = 5;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public ValidationErrorDialogNotification() {
    }

    public ValidationErrorDialogNotification(String string, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, LayoutFieldDataType layoutFieldDataType, IWPError iWPError, String string2) {
        this();
        this.message = string;
        this.hasMessage = bl;
        this.setHasMessageIsSet(true);
        this.anotherLayoutMessage = bl2;
        this.setAnotherLayoutMessageIsSet(true);
        this.allowRevert = bl3;
        this.setAllowRevertIsSet(true);
        this.allowOverride = bl4;
        this.setAllowOverrideIsSet(true);
        this.recordLevelValidation = bl5;
        this.setRecordLevelValidationIsSet(true);
        this.strictDataType = bl6;
        this.setStrictDataTypeIsSet(true);
        this.fieldDataType = layoutFieldDataType;
        this.error = iWPError;
        this.sampleDateTimeFormat = string2;
    }

    public ValidationErrorDialogNotification(ValidationErrorDialogNotification validationErrorDialogNotification) {
        this.__isset_bitfield = validationErrorDialogNotification.__isset_bitfield;
        if (validationErrorDialogNotification.isSetMessage()) {
            this.message = validationErrorDialogNotification.message;
        }
        this.hasMessage = validationErrorDialogNotification.hasMessage;
        this.anotherLayoutMessage = validationErrorDialogNotification.anotherLayoutMessage;
        this.allowRevert = validationErrorDialogNotification.allowRevert;
        this.allowOverride = validationErrorDialogNotification.allowOverride;
        this.recordLevelValidation = validationErrorDialogNotification.recordLevelValidation;
        this.strictDataType = validationErrorDialogNotification.strictDataType;
        if (validationErrorDialogNotification.isSetFieldDataType()) {
            this.fieldDataType = validationErrorDialogNotification.fieldDataType;
        }
        if (validationErrorDialogNotification.isSetError()) {
            this.error = new IWPError(validationErrorDialogNotification.error);
        }
        if (validationErrorDialogNotification.isSetSampleDateTimeFormat()) {
            this.sampleDateTimeFormat = validationErrorDialogNotification.sampleDateTimeFormat;
        }
    }

    public ValidationErrorDialogNotification deepCopy() {
        return new ValidationErrorDialogNotification(this);
    }

    public void clear() {
        this.message = null;
        this.setHasMessageIsSet(false);
        this.hasMessage = false;
        this.setAnotherLayoutMessageIsSet(false);
        this.anotherLayoutMessage = false;
        this.setAllowRevertIsSet(false);
        this.allowRevert = false;
        this.setAllowOverrideIsSet(false);
        this.allowOverride = false;
        this.setRecordLevelValidationIsSet(false);
        this.recordLevelValidation = false;
        this.setStrictDataTypeIsSet(false);
        this.strictDataType = false;
        this.fieldDataType = null;
        this.error = null;
        this.sampleDateTimeFormat = null;
    }

    @Nullable
    public String getMessage() {
        return this.message;
    }

    public void setMessage(@Nullable String string) {
        this.message = string;
    }

    public void unsetMessage() {
        this.message = null;
    }

    public boolean isSetMessage() {
        return this.message != null;
    }

    public void setMessageIsSet(boolean bl) {
        if (!bl) {
            this.message = null;
        }
    }

    public boolean isHasMessage() {
        return this.hasMessage;
    }

    public void setHasMessage(boolean bl) {
        this.hasMessage = bl;
        this.setHasMessageIsSet(true);
    }

    public void unsetHasMessage() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetHasMessage() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setHasMessageIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public boolean isAnotherLayoutMessage() {
        return this.anotherLayoutMessage;
    }

    public void setAnotherLayoutMessage(boolean bl) {
        this.anotherLayoutMessage = bl;
        this.setAnotherLayoutMessageIsSet(true);
    }

    public void unsetAnotherLayoutMessage() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)1);
    }

    public boolean isSetAnotherLayoutMessage() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)1);
    }

    public void setAnotherLayoutMessageIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)1, (boolean)bl);
    }

    public boolean isAllowRevert() {
        return this.allowRevert;
    }

    public void setAllowRevert(boolean bl) {
        this.allowRevert = bl;
        this.setAllowRevertIsSet(true);
    }

    public void unsetAllowRevert() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)2);
    }

    public boolean isSetAllowRevert() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)2);
    }

    public void setAllowRevertIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)2, (boolean)bl);
    }

    public boolean isAllowOverride() {
        return this.allowOverride;
    }

    public void setAllowOverride(boolean bl) {
        this.allowOverride = bl;
        this.setAllowOverrideIsSet(true);
    }

    public void unsetAllowOverride() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)3);
    }

    public boolean isSetAllowOverride() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)3);
    }

    public void setAllowOverrideIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)3, (boolean)bl);
    }

    public boolean isRecordLevelValidation() {
        return this.recordLevelValidation;
    }

    public void setRecordLevelValidation(boolean bl) {
        this.recordLevelValidation = bl;
        this.setRecordLevelValidationIsSet(true);
    }

    public void unsetRecordLevelValidation() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)4);
    }

    public boolean isSetRecordLevelValidation() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)4);
    }

    public void setRecordLevelValidationIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)4, (boolean)bl);
    }

    public boolean isStrictDataType() {
        return this.strictDataType;
    }

    public void setStrictDataType(boolean bl) {
        this.strictDataType = bl;
        this.setStrictDataTypeIsSet(true);
    }

    public void unsetStrictDataType() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)5);
    }

    public boolean isSetStrictDataType() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)5);
    }

    public void setStrictDataTypeIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)5, (boolean)bl);
    }

    @Nullable
    public LayoutFieldDataType getFieldDataType() {
        return this.fieldDataType;
    }

    public void setFieldDataType(@Nullable LayoutFieldDataType layoutFieldDataType) {
        this.fieldDataType = layoutFieldDataType;
    }

    public void unsetFieldDataType() {
        this.fieldDataType = null;
    }

    public boolean isSetFieldDataType() {
        return this.fieldDataType != null;
    }

    public void setFieldDataTypeIsSet(boolean bl) {
        if (!bl) {
            this.fieldDataType = null;
        }
    }

    @Nullable
    public IWPError getError() {
        return this.error;
    }

    public void setError(@Nullable IWPError iWPError) {
        this.error = iWPError;
    }

    public void unsetError() {
        this.error = null;
    }

    public boolean isSetError() {
        return this.error != null;
    }

    public void setErrorIsSet(boolean bl) {
        if (!bl) {
            this.error = null;
        }
    }

    @Nullable
    public String getSampleDateTimeFormat() {
        return this.sampleDateTimeFormat;
    }

    public void setSampleDateTimeFormat(@Nullable String string) {
        this.sampleDateTimeFormat = string;
    }

    public void unsetSampleDateTimeFormat() {
        this.sampleDateTimeFormat = null;
    }

    public boolean isSetSampleDateTimeFormat() {
        return this.sampleDateTimeFormat != null;
    }

    public void setSampleDateTimeFormatIsSet(boolean bl) {
        if (!bl) {
            this.sampleDateTimeFormat = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetMessage();
                    break;
                }
                this.setMessage((String)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetHasMessage();
                    break;
                }
                this.setHasMessage((Boolean)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetAnotherLayoutMessage();
                    break;
                }
                this.setAnotherLayoutMessage((Boolean)object);
                break;
            }
            case 3: {
                if (object == null) {
                    this.unsetAllowRevert();
                    break;
                }
                this.setAllowRevert((Boolean)object);
                break;
            }
            case 4: {
                if (object == null) {
                    this.unsetAllowOverride();
                    break;
                }
                this.setAllowOverride((Boolean)object);
                break;
            }
            case 5: {
                if (object == null) {
                    this.unsetRecordLevelValidation();
                    break;
                }
                this.setRecordLevelValidation((Boolean)object);
                break;
            }
            case 6: {
                if (object == null) {
                    this.unsetStrictDataType();
                    break;
                }
                this.setStrictDataType((Boolean)object);
                break;
            }
            case 7: {
                if (object == null) {
                    this.unsetFieldDataType();
                    break;
                }
                this.setFieldDataType((LayoutFieldDataType)((Object)object));
                break;
            }
            case 8: {
                if (object == null) {
                    this.unsetError();
                    break;
                }
                this.setError((IWPError)object);
                break;
            }
            case 9: {
                if (object == null) {
                    this.unsetSampleDateTimeFormat();
                    break;
                }
                this.setSampleDateTimeFormat((String)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getMessage();
            }
            case 1: {
                return this.isHasMessage();
            }
            case 2: {
                return this.isAnotherLayoutMessage();
            }
            case 3: {
                return this.isAllowRevert();
            }
            case 4: {
                return this.isAllowOverride();
            }
            case 5: {
                return this.isRecordLevelValidation();
            }
            case 6: {
                return this.isStrictDataType();
            }
            case 7: {
                return this.getFieldDataType();
            }
            case 8: {
                return this.getError();
            }
            case 9: {
                return this.getSampleDateTimeFormat();
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
                return this.isSetMessage();
            }
            case 1: {
                return this.isSetHasMessage();
            }
            case 2: {
                return this.isSetAnotherLayoutMessage();
            }
            case 3: {
                return this.isSetAllowRevert();
            }
            case 4: {
                return this.isSetAllowOverride();
            }
            case 5: {
                return this.isSetRecordLevelValidation();
            }
            case 6: {
                return this.isSetStrictDataType();
            }
            case 7: {
                return this.isSetFieldDataType();
            }
            case 8: {
                return this.isSetError();
            }
            case 9: {
                return this.isSetSampleDateTimeFormat();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof ValidationErrorDialogNotification) {
            return this.equals((ValidationErrorDialogNotification)object);
        }
        return false;
    }

    public boolean equals(ValidationErrorDialogNotification validationErrorDialogNotification) {
        if (validationErrorDialogNotification == null) {
            return false;
        }
        if (this == validationErrorDialogNotification) {
            return true;
        }
        boolean bl = this.isSetMessage();
        boolean bl2 = validationErrorDialogNotification.isSetMessage();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.message.equals(validationErrorDialogNotification.message)) {
                return false;
            }
        }
        boolean bl3 = true;
        boolean bl4 = true;
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (this.hasMessage != validationErrorDialogNotification.hasMessage) {
                return false;
            }
        }
        boolean bl5 = true;
        boolean bl6 = true;
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (this.anotherLayoutMessage != validationErrorDialogNotification.anotherLayoutMessage) {
                return false;
            }
        }
        boolean bl7 = true;
        boolean bl8 = true;
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (this.allowRevert != validationErrorDialogNotification.allowRevert) {
                return false;
            }
        }
        boolean bl9 = true;
        boolean bl10 = true;
        if (bl9 || bl10) {
            if (!bl9 || !bl10) {
                return false;
            }
            if (this.allowOverride != validationErrorDialogNotification.allowOverride) {
                return false;
            }
        }
        boolean bl11 = true;
        boolean bl12 = true;
        if (bl11 || bl12) {
            if (!bl11 || !bl12) {
                return false;
            }
            if (this.recordLevelValidation != validationErrorDialogNotification.recordLevelValidation) {
                return false;
            }
        }
        boolean bl13 = true;
        boolean bl14 = true;
        if (bl13 || bl14) {
            if (!bl13 || !bl14) {
                return false;
            }
            if (this.strictDataType != validationErrorDialogNotification.strictDataType) {
                return false;
            }
        }
        boolean bl15 = this.isSetFieldDataType();
        boolean bl16 = validationErrorDialogNotification.isSetFieldDataType();
        if (bl15 || bl16) {
            if (!bl15 || !bl16) {
                return false;
            }
            if (!this.fieldDataType.equals((Object)validationErrorDialogNotification.fieldDataType)) {
                return false;
            }
        }
        boolean bl17 = this.isSetError();
        boolean bl18 = validationErrorDialogNotification.isSetError();
        if (bl17 || bl18) {
            if (!bl17 || !bl18) {
                return false;
            }
            if (!this.error.equals(validationErrorDialogNotification.error)) {
                return false;
            }
        }
        boolean bl19 = this.isSetSampleDateTimeFormat();
        boolean bl20 = validationErrorDialogNotification.isSetSampleDateTimeFormat();
        if (bl19 || bl20) {
            if (!bl19 || !bl20) {
                return false;
            }
            if (!this.sampleDateTimeFormat.equals(validationErrorDialogNotification.sampleDateTimeFormat)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetMessage() ? 131071 : 524287);
        if (this.isSetMessage()) {
            n = n * 8191 + this.message.hashCode();
        }
        n = n * 8191 + (this.hasMessage ? 131071 : 524287);
        n = n * 8191 + (this.anotherLayoutMessage ? 131071 : 524287);
        n = n * 8191 + (this.allowRevert ? 131071 : 524287);
        n = n * 8191 + (this.allowOverride ? 131071 : 524287);
        n = n * 8191 + (this.recordLevelValidation ? 131071 : 524287);
        n = n * 8191 + (this.strictDataType ? 131071 : 524287);
        n = n * 8191 + (this.isSetFieldDataType() ? 131071 : 524287);
        if (this.isSetFieldDataType()) {
            n = n * 8191 + this.fieldDataType.getValue();
        }
        n = n * 8191 + (this.isSetError() ? 131071 : 524287);
        if (this.isSetError()) {
            n = n * 8191 + this.error.hashCode();
        }
        n = n * 8191 + (this.isSetSampleDateTimeFormat() ? 131071 : 524287);
        if (this.isSetSampleDateTimeFormat()) {
            n = n * 8191 + this.sampleDateTimeFormat.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(ValidationErrorDialogNotification validationErrorDialogNotification) {
        if (!this.getClass().equals(validationErrorDialogNotification.getClass())) {
            return this.getClass().getName().compareTo(validationErrorDialogNotification.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetMessage(), validationErrorDialogNotification.isSetMessage());
        if (n != 0) {
            return n;
        }
        if (this.isSetMessage() && (n = TBaseHelper.compareTo((String)this.message, (String)validationErrorDialogNotification.message)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetHasMessage(), validationErrorDialogNotification.isSetHasMessage());
        if (n != 0) {
            return n;
        }
        if (this.isSetHasMessage() && (n = TBaseHelper.compareTo((boolean)this.hasMessage, (boolean)validationErrorDialogNotification.hasMessage)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetAnotherLayoutMessage(), validationErrorDialogNotification.isSetAnotherLayoutMessage());
        if (n != 0) {
            return n;
        }
        if (this.isSetAnotherLayoutMessage() && (n = TBaseHelper.compareTo((boolean)this.anotherLayoutMessage, (boolean)validationErrorDialogNotification.anotherLayoutMessage)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetAllowRevert(), validationErrorDialogNotification.isSetAllowRevert());
        if (n != 0) {
            return n;
        }
        if (this.isSetAllowRevert() && (n = TBaseHelper.compareTo((boolean)this.allowRevert, (boolean)validationErrorDialogNotification.allowRevert)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetAllowOverride(), validationErrorDialogNotification.isSetAllowOverride());
        if (n != 0) {
            return n;
        }
        if (this.isSetAllowOverride() && (n = TBaseHelper.compareTo((boolean)this.allowOverride, (boolean)validationErrorDialogNotification.allowOverride)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetRecordLevelValidation(), validationErrorDialogNotification.isSetRecordLevelValidation());
        if (n != 0) {
            return n;
        }
        if (this.isSetRecordLevelValidation() && (n = TBaseHelper.compareTo((boolean)this.recordLevelValidation, (boolean)validationErrorDialogNotification.recordLevelValidation)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetStrictDataType(), validationErrorDialogNotification.isSetStrictDataType());
        if (n != 0) {
            return n;
        }
        if (this.isSetStrictDataType() && (n = TBaseHelper.compareTo((boolean)this.strictDataType, (boolean)validationErrorDialogNotification.strictDataType)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetFieldDataType(), validationErrorDialogNotification.isSetFieldDataType());
        if (n != 0) {
            return n;
        }
        if (this.isSetFieldDataType() && (n = TBaseHelper.compareTo((Comparable)((Object)this.fieldDataType), (Comparable)((Object)validationErrorDialogNotification.fieldDataType))) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetError(), validationErrorDialogNotification.isSetError());
        if (n != 0) {
            return n;
        }
        if (this.isSetError() && (n = TBaseHelper.compareTo((Comparable)this.error, (Comparable)validationErrorDialogNotification.error)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetSampleDateTimeFormat(), validationErrorDialogNotification.isSetSampleDateTimeFormat());
        if (n != 0) {
            return n;
        }
        if (this.isSetSampleDateTimeFormat() && (n = TBaseHelper.compareTo((String)this.sampleDateTimeFormat, (String)validationErrorDialogNotification.sampleDateTimeFormat)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        ValidationErrorDialogNotification.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        ValidationErrorDialogNotification.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ValidationErrorDialogNotification(");
        boolean bl = true;
        stringBuilder.append("message:");
        if (this.message == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.message);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("hasMessage:");
        stringBuilder.append(this.hasMessage);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("anotherLayoutMessage:");
        stringBuilder.append(this.anotherLayoutMessage);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("allowRevert:");
        stringBuilder.append(this.allowRevert);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("allowOverride:");
        stringBuilder.append(this.allowOverride);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("recordLevelValidation:");
        stringBuilder.append(this.recordLevelValidation);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("strictDataType:");
        stringBuilder.append(this.strictDataType);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("fieldDataType:");
        if (this.fieldDataType == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append((Object)this.fieldDataType);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("error:");
        if (this.error == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.error);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("sampleDateTimeFormat:");
        if (this.sampleDateTimeFormat == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.sampleDateTimeFormat);
        }
        bl = false;
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void validate() throws TException {
        if (this.error != null) {
            this.error.validate();
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
        enumMap.put(_Fields.MESSAGE, new FieldMetaData("message", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.HAS_MESSAGE, new FieldMetaData("hasMessage", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.ANOTHER_LAYOUT_MESSAGE, new FieldMetaData("anotherLayoutMessage", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.ALLOW_REVERT, new FieldMetaData("allowRevert", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.ALLOW_OVERRIDE, new FieldMetaData("allowOverride", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.RECORD_LEVEL_VALIDATION, new FieldMetaData("recordLevelValidation", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.STRICT_DATA_TYPE, new FieldMetaData("strictDataType", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.FIELD_DATA_TYPE, new FieldMetaData("fieldDataType", 3, (FieldValueMetaData)new EnumMetaData(-1, LayoutFieldDataType.class)));
        enumMap.put(_Fields.ERROR, new FieldMetaData("error", 3, (FieldValueMetaData)new StructMetaData(12, IWPError.class)));
        enumMap.put(_Fields.SAMPLE_DATE_TIME_FORMAT, new FieldMetaData("sampleDateTimeFormat", 3, new FieldValueMetaData(11)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(ValidationErrorDialogNotification.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        MESSAGE(1, "message"),
        HAS_MESSAGE(2, "hasMessage"),
        ANOTHER_LAYOUT_MESSAGE(3, "anotherLayoutMessage"),
        ALLOW_REVERT(4, "allowRevert"),
        ALLOW_OVERRIDE(5, "allowOverride"),
        RECORD_LEVEL_VALIDATION(6, "recordLevelValidation"),
        STRICT_DATA_TYPE(7, "strictDataType"),
        FIELD_DATA_TYPE(8, "fieldDataType"),
        ERROR(9, "error"),
        SAMPLE_DATE_TIME_FORMAT(10, "sampleDateTimeFormat");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return MESSAGE;
                }
                case 2: {
                    return HAS_MESSAGE;
                }
                case 3: {
                    return ANOTHER_LAYOUT_MESSAGE;
                }
                case 4: {
                    return ALLOW_REVERT;
                }
                case 5: {
                    return ALLOW_OVERRIDE;
                }
                case 6: {
                    return RECORD_LEVEL_VALIDATION;
                }
                case 7: {
                    return STRICT_DATA_TYPE;
                }
                case 8: {
                    return FIELD_DATA_TYPE;
                }
                case 9: {
                    return ERROR;
                }
                case 10: {
                    return SAMPLE_DATE_TIME_FORMAT;
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

    private static class ValidationErrorDialogNotificationStandardSchemeFactory
    implements SchemeFactory {
        private ValidationErrorDialogNotificationStandardSchemeFactory() {
        }

        public ValidationErrorDialogNotificationStandardScheme getScheme() {
            return new ValidationErrorDialogNotificationStandardScheme();
        }
    }

    private static class ValidationErrorDialogNotificationTupleSchemeFactory
    implements SchemeFactory {
        private ValidationErrorDialogNotificationTupleSchemeFactory() {
        }

        public ValidationErrorDialogNotificationTupleScheme getScheme() {
            return new ValidationErrorDialogNotificationTupleScheme();
        }
    }

    private static class ValidationErrorDialogNotificationTupleScheme
    extends TupleScheme<ValidationErrorDialogNotification> {
        private ValidationErrorDialogNotificationTupleScheme() {
        }

        public void write(TProtocol tProtocol, ValidationErrorDialogNotification validationErrorDialogNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (validationErrorDialogNotification.isSetMessage()) {
                bitSet.set(0);
            }
            if (validationErrorDialogNotification.isSetHasMessage()) {
                bitSet.set(1);
            }
            if (validationErrorDialogNotification.isSetAnotherLayoutMessage()) {
                bitSet.set(2);
            }
            if (validationErrorDialogNotification.isSetAllowRevert()) {
                bitSet.set(3);
            }
            if (validationErrorDialogNotification.isSetAllowOverride()) {
                bitSet.set(4);
            }
            if (validationErrorDialogNotification.isSetRecordLevelValidation()) {
                bitSet.set(5);
            }
            if (validationErrorDialogNotification.isSetStrictDataType()) {
                bitSet.set(6);
            }
            if (validationErrorDialogNotification.isSetFieldDataType()) {
                bitSet.set(7);
            }
            if (validationErrorDialogNotification.isSetError()) {
                bitSet.set(8);
            }
            if (validationErrorDialogNotification.isSetSampleDateTimeFormat()) {
                bitSet.set(9);
            }
            tTupleProtocol.writeBitSet(bitSet, 10);
            if (validationErrorDialogNotification.isSetMessage()) {
                tTupleProtocol.writeString(validationErrorDialogNotification.message);
            }
            if (validationErrorDialogNotification.isSetHasMessage()) {
                tTupleProtocol.writeBool(validationErrorDialogNotification.hasMessage);
            }
            if (validationErrorDialogNotification.isSetAnotherLayoutMessage()) {
                tTupleProtocol.writeBool(validationErrorDialogNotification.anotherLayoutMessage);
            }
            if (validationErrorDialogNotification.isSetAllowRevert()) {
                tTupleProtocol.writeBool(validationErrorDialogNotification.allowRevert);
            }
            if (validationErrorDialogNotification.isSetAllowOverride()) {
                tTupleProtocol.writeBool(validationErrorDialogNotification.allowOverride);
            }
            if (validationErrorDialogNotification.isSetRecordLevelValidation()) {
                tTupleProtocol.writeBool(validationErrorDialogNotification.recordLevelValidation);
            }
            if (validationErrorDialogNotification.isSetStrictDataType()) {
                tTupleProtocol.writeBool(validationErrorDialogNotification.strictDataType);
            }
            if (validationErrorDialogNotification.isSetFieldDataType()) {
                tTupleProtocol.writeI32(validationErrorDialogNotification.fieldDataType.getValue());
            }
            if (validationErrorDialogNotification.isSetError()) {
                validationErrorDialogNotification.error.write((TProtocol)tTupleProtocol);
            }
            if (validationErrorDialogNotification.isSetSampleDateTimeFormat()) {
                tTupleProtocol.writeString(validationErrorDialogNotification.sampleDateTimeFormat);
            }
        }

        public void read(TProtocol tProtocol, ValidationErrorDialogNotification validationErrorDialogNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(10);
            if (bitSet.get(0)) {
                validationErrorDialogNotification.message = tTupleProtocol.readString();
                validationErrorDialogNotification.setMessageIsSet(true);
            }
            if (bitSet.get(1)) {
                validationErrorDialogNotification.hasMessage = tTupleProtocol.readBool();
                validationErrorDialogNotification.setHasMessageIsSet(true);
            }
            if (bitSet.get(2)) {
                validationErrorDialogNotification.anotherLayoutMessage = tTupleProtocol.readBool();
                validationErrorDialogNotification.setAnotherLayoutMessageIsSet(true);
            }
            if (bitSet.get(3)) {
                validationErrorDialogNotification.allowRevert = tTupleProtocol.readBool();
                validationErrorDialogNotification.setAllowRevertIsSet(true);
            }
            if (bitSet.get(4)) {
                validationErrorDialogNotification.allowOverride = tTupleProtocol.readBool();
                validationErrorDialogNotification.setAllowOverrideIsSet(true);
            }
            if (bitSet.get(5)) {
                validationErrorDialogNotification.recordLevelValidation = tTupleProtocol.readBool();
                validationErrorDialogNotification.setRecordLevelValidationIsSet(true);
            }
            if (bitSet.get(6)) {
                validationErrorDialogNotification.strictDataType = tTupleProtocol.readBool();
                validationErrorDialogNotification.setStrictDataTypeIsSet(true);
            }
            if (bitSet.get(7)) {
                validationErrorDialogNotification.fieldDataType = LayoutFieldDataType.findByValue(tTupleProtocol.readI32());
                validationErrorDialogNotification.setFieldDataTypeIsSet(true);
            }
            if (bitSet.get(8)) {
                validationErrorDialogNotification.error = new IWPError();
                validationErrorDialogNotification.error.read((TProtocol)tTupleProtocol);
                validationErrorDialogNotification.setErrorIsSet(true);
            }
            if (bitSet.get(9)) {
                validationErrorDialogNotification.sampleDateTimeFormat = tTupleProtocol.readString();
                validationErrorDialogNotification.setSampleDateTimeFormatIsSet(true);
            }
        }
    }

    private static class ValidationErrorDialogNotificationStandardScheme
    extends StandardScheme<ValidationErrorDialogNotification> {
        private ValidationErrorDialogNotificationStandardScheme() {
        }

        public void read(TProtocol tProtocol, ValidationErrorDialogNotification validationErrorDialogNotification) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 11) {
                            validationErrorDialogNotification.message = tProtocol.readString();
                            validationErrorDialogNotification.setMessageIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 2) {
                            validationErrorDialogNotification.hasMessage = tProtocol.readBool();
                            validationErrorDialogNotification.setHasMessageIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 2) {
                            validationErrorDialogNotification.anotherLayoutMessage = tProtocol.readBool();
                            validationErrorDialogNotification.setAnotherLayoutMessageIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 2) {
                            validationErrorDialogNotification.allowRevert = tProtocol.readBool();
                            validationErrorDialogNotification.setAllowRevertIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 5: {
                        if (tField.type == 2) {
                            validationErrorDialogNotification.allowOverride = tProtocol.readBool();
                            validationErrorDialogNotification.setAllowOverrideIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 6: {
                        if (tField.type == 2) {
                            validationErrorDialogNotification.recordLevelValidation = tProtocol.readBool();
                            validationErrorDialogNotification.setRecordLevelValidationIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 7: {
                        if (tField.type == 2) {
                            validationErrorDialogNotification.strictDataType = tProtocol.readBool();
                            validationErrorDialogNotification.setStrictDataTypeIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 8: {
                        if (tField.type == 8) {
                            validationErrorDialogNotification.fieldDataType = LayoutFieldDataType.findByValue(tProtocol.readI32());
                            validationErrorDialogNotification.setFieldDataTypeIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 9: {
                        if (tField.type == 12) {
                            validationErrorDialogNotification.error = new IWPError();
                            validationErrorDialogNotification.error.read(tProtocol);
                            validationErrorDialogNotification.setErrorIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 10: {
                        if (tField.type == 11) {
                            validationErrorDialogNotification.sampleDateTimeFormat = tProtocol.readString();
                            validationErrorDialogNotification.setSampleDateTimeFormatIsSet(true);
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
            validationErrorDialogNotification.validate();
        }

        public void write(TProtocol tProtocol, ValidationErrorDialogNotification validationErrorDialogNotification) throws TException {
            validationErrorDialogNotification.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (validationErrorDialogNotification.message != null) {
                tProtocol.writeFieldBegin(MESSAGE_FIELD_DESC);
                tProtocol.writeString(validationErrorDialogNotification.message);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(HAS_MESSAGE_FIELD_DESC);
            tProtocol.writeBool(validationErrorDialogNotification.hasMessage);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(ANOTHER_LAYOUT_MESSAGE_FIELD_DESC);
            tProtocol.writeBool(validationErrorDialogNotification.anotherLayoutMessage);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(ALLOW_REVERT_FIELD_DESC);
            tProtocol.writeBool(validationErrorDialogNotification.allowRevert);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(ALLOW_OVERRIDE_FIELD_DESC);
            tProtocol.writeBool(validationErrorDialogNotification.allowOverride);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(RECORD_LEVEL_VALIDATION_FIELD_DESC);
            tProtocol.writeBool(validationErrorDialogNotification.recordLevelValidation);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(STRICT_DATA_TYPE_FIELD_DESC);
            tProtocol.writeBool(validationErrorDialogNotification.strictDataType);
            tProtocol.writeFieldEnd();
            if (validationErrorDialogNotification.fieldDataType != null) {
                tProtocol.writeFieldBegin(FIELD_DATA_TYPE_FIELD_DESC);
                tProtocol.writeI32(validationErrorDialogNotification.fieldDataType.getValue());
                tProtocol.writeFieldEnd();
            }
            if (validationErrorDialogNotification.error != null) {
                tProtocol.writeFieldBegin(ERROR_FIELD_DESC);
                validationErrorDialogNotification.error.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            if (validationErrorDialogNotification.sampleDateTimeFormat != null) {
                tProtocol.writeFieldBegin(SAMPLE_DATE_TIME_FORMAT_FIELD_DESC);
                tProtocol.writeString(validationErrorDialogNotification.sampleDateTimeFormat);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

