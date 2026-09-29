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
package com.filemaker.jwpc.iwp.thrift.layout;

import com.filemaker.jwpc.iwp.thrift.common.CFObject;
import com.filemaker.jwpc.iwp.thrift.layout.Data;
import com.filemaker.jwpc.iwp.thrift.layout.DataType;
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

public class NonFieldObjectData
implements TBase<NonFieldObjectData, _Fields>,
Serializable,
Cloneable,
Comparable<NonFieldObjectData> {
    private static final TStruct STRUCT_DESC = new TStruct("NonFieldObjectData");
    private static final TField OBJECT_ID_FIELD_DESC = new TField("objectId", 8, 1);
    private static final TField PORTAL_ID_FIELD_DESC = new TField("portalId", 8, 2);
    private static final TField DATA_FIELD_DESC = new TField("data", 12, 3);
    private static final TField DATA_TYPE_FIELD_DESC = new TField("dataType", 8, 4);
    private static final TField TOOLTIP_FIELD_DESC = new TField("tooltip", 11, 5);
    private static final TField CONDITIONAL_FORMATTING_FIELD_DESC = new TField("conditionalFormatting", 12, 6);
    private static final TField HIDE_CONDITION_CALCULATED_FIELD_DESC = new TField("hideConditionCalculated", 2, 7);
    private static final TField HIDE_CONDITION_ON_FIELD_DESC = new TField("hideConditionOn", 2, 8);
    private static final TField BUTTON_BAR_ACTIVE_SEGMENT_FIELD_DESC = new TField("buttonBarActiveSegment", 2, 9);
    private static final TField POPOVER_ID_FIELD_DESC = new TField("popoverId", 8, 10);
    private static final TField ACC_TITLE_FIELD_DESC = new TField("accTitle", 11, 11);
    private static final TField ACC_HELP_FIELD_DESC = new TField("accHelp", 11, 12);
    private static final TField ACC_LABEL_FIELD_DESC = new TField("accLabel", 11, 13);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new NonFieldObjectDataStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new NonFieldObjectDataTupleSchemeFactory();
    private int objectId;
    private int portalId;
    @Nullable
    private Data data;
    @Nullable
    private DataType dataType;
    @Nullable
    private String tooltip;
    @Nullable
    private CFObject conditionalFormatting;
    private boolean hideConditionCalculated;
    private boolean hideConditionOn;
    private boolean buttonBarActiveSegment;
    private int popoverId;
    @Nullable
    private String accTitle;
    @Nullable
    private String accHelp;
    @Nullable
    private String accLabel;
    private static final int __OBJECTID_ISSET_ID = 0;
    private static final int __PORTALID_ISSET_ID = 1;
    private static final int __HIDECONDITIONCALCULATED_ISSET_ID = 2;
    private static final int __HIDECONDITIONON_ISSET_ID = 3;
    private static final int __BUTTONBARACTIVESEGMENT_ISSET_ID = 4;
    private static final int __POPOVERID_ISSET_ID = 5;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public NonFieldObjectData() {
        this.objectId = 0;
        this.portalId = 0;
        this.dataType = DataType.INVALID;
        this.popoverId = 0;
    }

    public NonFieldObjectData(int n, int n2, Data data, DataType dataType, String string, CFObject cFObject, boolean bl, boolean bl2, boolean bl3, int n3, String string2, String string3, String string4) {
        this();
        this.objectId = n;
        this.setObjectIdIsSet(true);
        this.portalId = n2;
        this.setPortalIdIsSet(true);
        this.data = data;
        this.dataType = dataType;
        this.tooltip = string;
        this.conditionalFormatting = cFObject;
        this.hideConditionCalculated = bl;
        this.setHideConditionCalculatedIsSet(true);
        this.hideConditionOn = bl2;
        this.setHideConditionOnIsSet(true);
        this.buttonBarActiveSegment = bl3;
        this.setButtonBarActiveSegmentIsSet(true);
        this.popoverId = n3;
        this.setPopoverIdIsSet(true);
        this.accTitle = string2;
        this.accHelp = string3;
        this.accLabel = string4;
    }

    public NonFieldObjectData(NonFieldObjectData nonFieldObjectData) {
        this.__isset_bitfield = nonFieldObjectData.__isset_bitfield;
        this.objectId = nonFieldObjectData.objectId;
        this.portalId = nonFieldObjectData.portalId;
        if (nonFieldObjectData.isSetData()) {
            this.data = new Data(nonFieldObjectData.data);
        }
        if (nonFieldObjectData.isSetDataType()) {
            this.dataType = nonFieldObjectData.dataType;
        }
        if (nonFieldObjectData.isSetTooltip()) {
            this.tooltip = nonFieldObjectData.tooltip;
        }
        if (nonFieldObjectData.isSetConditionalFormatting()) {
            this.conditionalFormatting = new CFObject(nonFieldObjectData.conditionalFormatting);
        }
        this.hideConditionCalculated = nonFieldObjectData.hideConditionCalculated;
        this.hideConditionOn = nonFieldObjectData.hideConditionOn;
        this.buttonBarActiveSegment = nonFieldObjectData.buttonBarActiveSegment;
        this.popoverId = nonFieldObjectData.popoverId;
        if (nonFieldObjectData.isSetAccTitle()) {
            this.accTitle = nonFieldObjectData.accTitle;
        }
        if (nonFieldObjectData.isSetAccHelp()) {
            this.accHelp = nonFieldObjectData.accHelp;
        }
        if (nonFieldObjectData.isSetAccLabel()) {
            this.accLabel = nonFieldObjectData.accLabel;
        }
    }

    public NonFieldObjectData deepCopy() {
        return new NonFieldObjectData(this);
    }

    public void clear() {
        this.objectId = 0;
        this.portalId = 0;
        this.data = null;
        this.dataType = DataType.INVALID;
        this.tooltip = null;
        this.conditionalFormatting = null;
        this.setHideConditionCalculatedIsSet(false);
        this.hideConditionCalculated = false;
        this.setHideConditionOnIsSet(false);
        this.hideConditionOn = false;
        this.setButtonBarActiveSegmentIsSet(false);
        this.buttonBarActiveSegment = false;
        this.popoverId = 0;
        this.accTitle = null;
        this.accHelp = null;
        this.accLabel = null;
    }

    public int getObjectId() {
        return this.objectId;
    }

    public void setObjectId(int n) {
        this.objectId = n;
        this.setObjectIdIsSet(true);
    }

    public void unsetObjectId() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetObjectId() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setObjectIdIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public int getPortalId() {
        return this.portalId;
    }

    public void setPortalId(int n) {
        this.portalId = n;
        this.setPortalIdIsSet(true);
    }

    public void unsetPortalId() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)1);
    }

    public boolean isSetPortalId() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)1);
    }

    public void setPortalIdIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)1, (boolean)bl);
    }

    @Nullable
    public Data getData() {
        return this.data;
    }

    public void setData(@Nullable Data data) {
        this.data = data;
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

    @Nullable
    public DataType getDataType() {
        return this.dataType;
    }

    public void setDataType(@Nullable DataType dataType) {
        this.dataType = dataType;
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
    public String getTooltip() {
        return this.tooltip;
    }

    public void setTooltip(@Nullable String string) {
        this.tooltip = string;
    }

    public void unsetTooltip() {
        this.tooltip = null;
    }

    public boolean isSetTooltip() {
        return this.tooltip != null;
    }

    public void setTooltipIsSet(boolean bl) {
        if (!bl) {
            this.tooltip = null;
        }
    }

    @Nullable
    public CFObject getConditionalFormatting() {
        return this.conditionalFormatting;
    }

    public void setConditionalFormatting(@Nullable CFObject cFObject) {
        this.conditionalFormatting = cFObject;
    }

    public void unsetConditionalFormatting() {
        this.conditionalFormatting = null;
    }

    public boolean isSetConditionalFormatting() {
        return this.conditionalFormatting != null;
    }

    public void setConditionalFormattingIsSet(boolean bl) {
        if (!bl) {
            this.conditionalFormatting = null;
        }
    }

    public boolean isHideConditionCalculated() {
        return this.hideConditionCalculated;
    }

    public void setHideConditionCalculated(boolean bl) {
        this.hideConditionCalculated = bl;
        this.setHideConditionCalculatedIsSet(true);
    }

    public void unsetHideConditionCalculated() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)2);
    }

    public boolean isSetHideConditionCalculated() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)2);
    }

    public void setHideConditionCalculatedIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)2, (boolean)bl);
    }

    public boolean isHideConditionOn() {
        return this.hideConditionOn;
    }

    public void setHideConditionOn(boolean bl) {
        this.hideConditionOn = bl;
        this.setHideConditionOnIsSet(true);
    }

    public void unsetHideConditionOn() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)3);
    }

    public boolean isSetHideConditionOn() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)3);
    }

    public void setHideConditionOnIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)3, (boolean)bl);
    }

    public boolean isButtonBarActiveSegment() {
        return this.buttonBarActiveSegment;
    }

    public void setButtonBarActiveSegment(boolean bl) {
        this.buttonBarActiveSegment = bl;
        this.setButtonBarActiveSegmentIsSet(true);
    }

    public void unsetButtonBarActiveSegment() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)4);
    }

    public boolean isSetButtonBarActiveSegment() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)4);
    }

    public void setButtonBarActiveSegmentIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)4, (boolean)bl);
    }

    public int getPopoverId() {
        return this.popoverId;
    }

    public void setPopoverId(int n) {
        this.popoverId = n;
        this.setPopoverIdIsSet(true);
    }

    public void unsetPopoverId() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)5);
    }

    public boolean isSetPopoverId() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)5);
    }

    public void setPopoverIdIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)5, (boolean)bl);
    }

    @Nullable
    public String getAccTitle() {
        return this.accTitle;
    }

    public void setAccTitle(@Nullable String string) {
        this.accTitle = string;
    }

    public void unsetAccTitle() {
        this.accTitle = null;
    }

    public boolean isSetAccTitle() {
        return this.accTitle != null;
    }

    public void setAccTitleIsSet(boolean bl) {
        if (!bl) {
            this.accTitle = null;
        }
    }

    @Nullable
    public String getAccHelp() {
        return this.accHelp;
    }

    public void setAccHelp(@Nullable String string) {
        this.accHelp = string;
    }

    public void unsetAccHelp() {
        this.accHelp = null;
    }

    public boolean isSetAccHelp() {
        return this.accHelp != null;
    }

    public void setAccHelpIsSet(boolean bl) {
        if (!bl) {
            this.accHelp = null;
        }
    }

    @Nullable
    public String getAccLabel() {
        return this.accLabel;
    }

    public void setAccLabel(@Nullable String string) {
        this.accLabel = string;
    }

    public void unsetAccLabel() {
        this.accLabel = null;
    }

    public boolean isSetAccLabel() {
        return this.accLabel != null;
    }

    public void setAccLabelIsSet(boolean bl) {
        if (!bl) {
            this.accLabel = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetObjectId();
                    break;
                }
                this.setObjectId((Integer)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetPortalId();
                    break;
                }
                this.setPortalId((Integer)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetData();
                    break;
                }
                this.setData((Data)object);
                break;
            }
            case 3: {
                if (object == null) {
                    this.unsetDataType();
                    break;
                }
                this.setDataType((DataType)((Object)object));
                break;
            }
            case 4: {
                if (object == null) {
                    this.unsetTooltip();
                    break;
                }
                this.setTooltip((String)object);
                break;
            }
            case 5: {
                if (object == null) {
                    this.unsetConditionalFormatting();
                    break;
                }
                this.setConditionalFormatting((CFObject)object);
                break;
            }
            case 6: {
                if (object == null) {
                    this.unsetHideConditionCalculated();
                    break;
                }
                this.setHideConditionCalculated((Boolean)object);
                break;
            }
            case 7: {
                if (object == null) {
                    this.unsetHideConditionOn();
                    break;
                }
                this.setHideConditionOn((Boolean)object);
                break;
            }
            case 8: {
                if (object == null) {
                    this.unsetButtonBarActiveSegment();
                    break;
                }
                this.setButtonBarActiveSegment((Boolean)object);
                break;
            }
            case 9: {
                if (object == null) {
                    this.unsetPopoverId();
                    break;
                }
                this.setPopoverId((Integer)object);
                break;
            }
            case 10: {
                if (object == null) {
                    this.unsetAccTitle();
                    break;
                }
                this.setAccTitle((String)object);
                break;
            }
            case 11: {
                if (object == null) {
                    this.unsetAccHelp();
                    break;
                }
                this.setAccHelp((String)object);
                break;
            }
            case 12: {
                if (object == null) {
                    this.unsetAccLabel();
                    break;
                }
                this.setAccLabel((String)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getObjectId();
            }
            case 1: {
                return this.getPortalId();
            }
            case 2: {
                return this.getData();
            }
            case 3: {
                return this.getDataType();
            }
            case 4: {
                return this.getTooltip();
            }
            case 5: {
                return this.getConditionalFormatting();
            }
            case 6: {
                return this.isHideConditionCalculated();
            }
            case 7: {
                return this.isHideConditionOn();
            }
            case 8: {
                return this.isButtonBarActiveSegment();
            }
            case 9: {
                return this.getPopoverId();
            }
            case 10: {
                return this.getAccTitle();
            }
            case 11: {
                return this.getAccHelp();
            }
            case 12: {
                return this.getAccLabel();
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
                return this.isSetObjectId();
            }
            case 1: {
                return this.isSetPortalId();
            }
            case 2: {
                return this.isSetData();
            }
            case 3: {
                return this.isSetDataType();
            }
            case 4: {
                return this.isSetTooltip();
            }
            case 5: {
                return this.isSetConditionalFormatting();
            }
            case 6: {
                return this.isSetHideConditionCalculated();
            }
            case 7: {
                return this.isSetHideConditionOn();
            }
            case 8: {
                return this.isSetButtonBarActiveSegment();
            }
            case 9: {
                return this.isSetPopoverId();
            }
            case 10: {
                return this.isSetAccTitle();
            }
            case 11: {
                return this.isSetAccHelp();
            }
            case 12: {
                return this.isSetAccLabel();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof NonFieldObjectData) {
            return this.equals((NonFieldObjectData)object);
        }
        return false;
    }

    public boolean equals(NonFieldObjectData nonFieldObjectData) {
        if (nonFieldObjectData == null) {
            return false;
        }
        if (this == nonFieldObjectData) {
            return true;
        }
        boolean bl = true;
        boolean bl2 = true;
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (this.objectId != nonFieldObjectData.objectId) {
                return false;
            }
        }
        boolean bl3 = true;
        boolean bl4 = true;
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (this.portalId != nonFieldObjectData.portalId) {
                return false;
            }
        }
        boolean bl5 = this.isSetData();
        boolean bl6 = nonFieldObjectData.isSetData();
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (!this.data.equals(nonFieldObjectData.data)) {
                return false;
            }
        }
        boolean bl7 = this.isSetDataType();
        boolean bl8 = nonFieldObjectData.isSetDataType();
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (!this.dataType.equals((Object)nonFieldObjectData.dataType)) {
                return false;
            }
        }
        boolean bl9 = this.isSetTooltip();
        boolean bl10 = nonFieldObjectData.isSetTooltip();
        if (bl9 || bl10) {
            if (!bl9 || !bl10) {
                return false;
            }
            if (!this.tooltip.equals(nonFieldObjectData.tooltip)) {
                return false;
            }
        }
        boolean bl11 = this.isSetConditionalFormatting();
        boolean bl12 = nonFieldObjectData.isSetConditionalFormatting();
        if (bl11 || bl12) {
            if (!bl11 || !bl12) {
                return false;
            }
            if (!this.conditionalFormatting.equals(nonFieldObjectData.conditionalFormatting)) {
                return false;
            }
        }
        boolean bl13 = true;
        boolean bl14 = true;
        if (bl13 || bl14) {
            if (!bl13 || !bl14) {
                return false;
            }
            if (this.hideConditionCalculated != nonFieldObjectData.hideConditionCalculated) {
                return false;
            }
        }
        boolean bl15 = true;
        boolean bl16 = true;
        if (bl15 || bl16) {
            if (!bl15 || !bl16) {
                return false;
            }
            if (this.hideConditionOn != nonFieldObjectData.hideConditionOn) {
                return false;
            }
        }
        boolean bl17 = true;
        boolean bl18 = true;
        if (bl17 || bl18) {
            if (!bl17 || !bl18) {
                return false;
            }
            if (this.buttonBarActiveSegment != nonFieldObjectData.buttonBarActiveSegment) {
                return false;
            }
        }
        boolean bl19 = true;
        boolean bl20 = true;
        if (bl19 || bl20) {
            if (!bl19 || !bl20) {
                return false;
            }
            if (this.popoverId != nonFieldObjectData.popoverId) {
                return false;
            }
        }
        boolean bl21 = this.isSetAccTitle();
        boolean bl22 = nonFieldObjectData.isSetAccTitle();
        if (bl21 || bl22) {
            if (!bl21 || !bl22) {
                return false;
            }
            if (!this.accTitle.equals(nonFieldObjectData.accTitle)) {
                return false;
            }
        }
        boolean bl23 = this.isSetAccHelp();
        boolean bl24 = nonFieldObjectData.isSetAccHelp();
        if (bl23 || bl24) {
            if (!bl23 || !bl24) {
                return false;
            }
            if (!this.accHelp.equals(nonFieldObjectData.accHelp)) {
                return false;
            }
        }
        boolean bl25 = this.isSetAccLabel();
        boolean bl26 = nonFieldObjectData.isSetAccLabel();
        if (bl25 || bl26) {
            if (!bl25 || !bl26) {
                return false;
            }
            if (!this.accLabel.equals(nonFieldObjectData.accLabel)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + this.objectId;
        n = n * 8191 + this.portalId;
        n = n * 8191 + (this.isSetData() ? 131071 : 524287);
        if (this.isSetData()) {
            n = n * 8191 + this.data.hashCode();
        }
        n = n * 8191 + (this.isSetDataType() ? 131071 : 524287);
        if (this.isSetDataType()) {
            n = n * 8191 + this.dataType.getValue();
        }
        n = n * 8191 + (this.isSetTooltip() ? 131071 : 524287);
        if (this.isSetTooltip()) {
            n = n * 8191 + this.tooltip.hashCode();
        }
        n = n * 8191 + (this.isSetConditionalFormatting() ? 131071 : 524287);
        if (this.isSetConditionalFormatting()) {
            n = n * 8191 + this.conditionalFormatting.hashCode();
        }
        n = n * 8191 + (this.hideConditionCalculated ? 131071 : 524287);
        n = n * 8191 + (this.hideConditionOn ? 131071 : 524287);
        n = n * 8191 + (this.buttonBarActiveSegment ? 131071 : 524287);
        n = n * 8191 + this.popoverId;
        n = n * 8191 + (this.isSetAccTitle() ? 131071 : 524287);
        if (this.isSetAccTitle()) {
            n = n * 8191 + this.accTitle.hashCode();
        }
        n = n * 8191 + (this.isSetAccHelp() ? 131071 : 524287);
        if (this.isSetAccHelp()) {
            n = n * 8191 + this.accHelp.hashCode();
        }
        n = n * 8191 + (this.isSetAccLabel() ? 131071 : 524287);
        if (this.isSetAccLabel()) {
            n = n * 8191 + this.accLabel.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(NonFieldObjectData nonFieldObjectData) {
        if (!this.getClass().equals(nonFieldObjectData.getClass())) {
            return this.getClass().getName().compareTo(nonFieldObjectData.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetObjectId(), nonFieldObjectData.isSetObjectId());
        if (n != 0) {
            return n;
        }
        if (this.isSetObjectId() && (n = TBaseHelper.compareTo((int)this.objectId, (int)nonFieldObjectData.objectId)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetPortalId(), nonFieldObjectData.isSetPortalId());
        if (n != 0) {
            return n;
        }
        if (this.isSetPortalId() && (n = TBaseHelper.compareTo((int)this.portalId, (int)nonFieldObjectData.portalId)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetData(), nonFieldObjectData.isSetData());
        if (n != 0) {
            return n;
        }
        if (this.isSetData() && (n = TBaseHelper.compareTo((Comparable)this.data, (Comparable)nonFieldObjectData.data)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetDataType(), nonFieldObjectData.isSetDataType());
        if (n != 0) {
            return n;
        }
        if (this.isSetDataType() && (n = TBaseHelper.compareTo((Comparable)((Object)this.dataType), (Comparable)((Object)nonFieldObjectData.dataType))) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetTooltip(), nonFieldObjectData.isSetTooltip());
        if (n != 0) {
            return n;
        }
        if (this.isSetTooltip() && (n = TBaseHelper.compareTo((String)this.tooltip, (String)nonFieldObjectData.tooltip)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetConditionalFormatting(), nonFieldObjectData.isSetConditionalFormatting());
        if (n != 0) {
            return n;
        }
        if (this.isSetConditionalFormatting() && (n = TBaseHelper.compareTo((Comparable)this.conditionalFormatting, (Comparable)nonFieldObjectData.conditionalFormatting)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetHideConditionCalculated(), nonFieldObjectData.isSetHideConditionCalculated());
        if (n != 0) {
            return n;
        }
        if (this.isSetHideConditionCalculated() && (n = TBaseHelper.compareTo((boolean)this.hideConditionCalculated, (boolean)nonFieldObjectData.hideConditionCalculated)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetHideConditionOn(), nonFieldObjectData.isSetHideConditionOn());
        if (n != 0) {
            return n;
        }
        if (this.isSetHideConditionOn() && (n = TBaseHelper.compareTo((boolean)this.hideConditionOn, (boolean)nonFieldObjectData.hideConditionOn)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetButtonBarActiveSegment(), nonFieldObjectData.isSetButtonBarActiveSegment());
        if (n != 0) {
            return n;
        }
        if (this.isSetButtonBarActiveSegment() && (n = TBaseHelper.compareTo((boolean)this.buttonBarActiveSegment, (boolean)nonFieldObjectData.buttonBarActiveSegment)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetPopoverId(), nonFieldObjectData.isSetPopoverId());
        if (n != 0) {
            return n;
        }
        if (this.isSetPopoverId() && (n = TBaseHelper.compareTo((int)this.popoverId, (int)nonFieldObjectData.popoverId)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetAccTitle(), nonFieldObjectData.isSetAccTitle());
        if (n != 0) {
            return n;
        }
        if (this.isSetAccTitle() && (n = TBaseHelper.compareTo((String)this.accTitle, (String)nonFieldObjectData.accTitle)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetAccHelp(), nonFieldObjectData.isSetAccHelp());
        if (n != 0) {
            return n;
        }
        if (this.isSetAccHelp() && (n = TBaseHelper.compareTo((String)this.accHelp, (String)nonFieldObjectData.accHelp)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetAccLabel(), nonFieldObjectData.isSetAccLabel());
        if (n != 0) {
            return n;
        }
        if (this.isSetAccLabel() && (n = TBaseHelper.compareTo((String)this.accLabel, (String)nonFieldObjectData.accLabel)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        NonFieldObjectData.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        NonFieldObjectData.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("NonFieldObjectData(");
        boolean bl = true;
        stringBuilder.append("objectId:");
        stringBuilder.append(this.objectId);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("portalId:");
        stringBuilder.append(this.portalId);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("data:");
        if (this.data == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.data);
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
        stringBuilder.append("tooltip:");
        if (this.tooltip == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.tooltip);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("conditionalFormatting:");
        if (this.conditionalFormatting == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.conditionalFormatting);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("hideConditionCalculated:");
        stringBuilder.append(this.hideConditionCalculated);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("hideConditionOn:");
        stringBuilder.append(this.hideConditionOn);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("buttonBarActiveSegment:");
        stringBuilder.append(this.buttonBarActiveSegment);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("popoverId:");
        stringBuilder.append(this.popoverId);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("accTitle:");
        if (this.accTitle == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.accTitle);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("accHelp:");
        if (this.accHelp == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.accHelp);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("accLabel:");
        if (this.accLabel == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.accLabel);
        }
        bl = false;
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void validate() throws TException {
        if (this.data != null) {
            this.data.validate();
        }
        if (this.conditionalFormatting != null) {
            this.conditionalFormatting.validate();
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
        enumMap.put(_Fields.OBJECT_ID, new FieldMetaData("objectId", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.PORTAL_ID, new FieldMetaData("portalId", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.DATA, new FieldMetaData("data", 3, (FieldValueMetaData)new StructMetaData(12, Data.class)));
        enumMap.put(_Fields.DATA_TYPE, new FieldMetaData("dataType", 3, (FieldValueMetaData)new EnumMetaData(-1, DataType.class)));
        enumMap.put(_Fields.TOOLTIP, new FieldMetaData("tooltip", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.CONDITIONAL_FORMATTING, new FieldMetaData("conditionalFormatting", 3, (FieldValueMetaData)new StructMetaData(12, CFObject.class)));
        enumMap.put(_Fields.HIDE_CONDITION_CALCULATED, new FieldMetaData("hideConditionCalculated", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.HIDE_CONDITION_ON, new FieldMetaData("hideConditionOn", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.BUTTON_BAR_ACTIVE_SEGMENT, new FieldMetaData("buttonBarActiveSegment", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.POPOVER_ID, new FieldMetaData("popoverId", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.ACC_TITLE, new FieldMetaData("accTitle", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.ACC_HELP, new FieldMetaData("accHelp", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.ACC_LABEL, new FieldMetaData("accLabel", 3, new FieldValueMetaData(11)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(NonFieldObjectData.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        OBJECT_ID(1, "objectId"),
        PORTAL_ID(2, "portalId"),
        DATA(3, "data"),
        DATA_TYPE(4, "dataType"),
        TOOLTIP(5, "tooltip"),
        CONDITIONAL_FORMATTING(6, "conditionalFormatting"),
        HIDE_CONDITION_CALCULATED(7, "hideConditionCalculated"),
        HIDE_CONDITION_ON(8, "hideConditionOn"),
        BUTTON_BAR_ACTIVE_SEGMENT(9, "buttonBarActiveSegment"),
        POPOVER_ID(10, "popoverId"),
        ACC_TITLE(11, "accTitle"),
        ACC_HELP(12, "accHelp"),
        ACC_LABEL(13, "accLabel");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return OBJECT_ID;
                }
                case 2: {
                    return PORTAL_ID;
                }
                case 3: {
                    return DATA;
                }
                case 4: {
                    return DATA_TYPE;
                }
                case 5: {
                    return TOOLTIP;
                }
                case 6: {
                    return CONDITIONAL_FORMATTING;
                }
                case 7: {
                    return HIDE_CONDITION_CALCULATED;
                }
                case 8: {
                    return HIDE_CONDITION_ON;
                }
                case 9: {
                    return BUTTON_BAR_ACTIVE_SEGMENT;
                }
                case 10: {
                    return POPOVER_ID;
                }
                case 11: {
                    return ACC_TITLE;
                }
                case 12: {
                    return ACC_HELP;
                }
                case 13: {
                    return ACC_LABEL;
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

    private static class NonFieldObjectDataStandardSchemeFactory
    implements SchemeFactory {
        private NonFieldObjectDataStandardSchemeFactory() {
        }

        public NonFieldObjectDataStandardScheme getScheme() {
            return new NonFieldObjectDataStandardScheme();
        }
    }

    private static class NonFieldObjectDataTupleSchemeFactory
    implements SchemeFactory {
        private NonFieldObjectDataTupleSchemeFactory() {
        }

        public NonFieldObjectDataTupleScheme getScheme() {
            return new NonFieldObjectDataTupleScheme();
        }
    }

    private static class NonFieldObjectDataTupleScheme
    extends TupleScheme<NonFieldObjectData> {
        private NonFieldObjectDataTupleScheme() {
        }

        public void write(TProtocol tProtocol, NonFieldObjectData nonFieldObjectData) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (nonFieldObjectData.isSetObjectId()) {
                bitSet.set(0);
            }
            if (nonFieldObjectData.isSetPortalId()) {
                bitSet.set(1);
            }
            if (nonFieldObjectData.isSetData()) {
                bitSet.set(2);
            }
            if (nonFieldObjectData.isSetDataType()) {
                bitSet.set(3);
            }
            if (nonFieldObjectData.isSetTooltip()) {
                bitSet.set(4);
            }
            if (nonFieldObjectData.isSetConditionalFormatting()) {
                bitSet.set(5);
            }
            if (nonFieldObjectData.isSetHideConditionCalculated()) {
                bitSet.set(6);
            }
            if (nonFieldObjectData.isSetHideConditionOn()) {
                bitSet.set(7);
            }
            if (nonFieldObjectData.isSetButtonBarActiveSegment()) {
                bitSet.set(8);
            }
            if (nonFieldObjectData.isSetPopoverId()) {
                bitSet.set(9);
            }
            if (nonFieldObjectData.isSetAccTitle()) {
                bitSet.set(10);
            }
            if (nonFieldObjectData.isSetAccHelp()) {
                bitSet.set(11);
            }
            if (nonFieldObjectData.isSetAccLabel()) {
                bitSet.set(12);
            }
            tTupleProtocol.writeBitSet(bitSet, 13);
            if (nonFieldObjectData.isSetObjectId()) {
                tTupleProtocol.writeI32(nonFieldObjectData.objectId);
            }
            if (nonFieldObjectData.isSetPortalId()) {
                tTupleProtocol.writeI32(nonFieldObjectData.portalId);
            }
            if (nonFieldObjectData.isSetData()) {
                nonFieldObjectData.data.write((TProtocol)tTupleProtocol);
            }
            if (nonFieldObjectData.isSetDataType()) {
                tTupleProtocol.writeI32(nonFieldObjectData.dataType.getValue());
            }
            if (nonFieldObjectData.isSetTooltip()) {
                tTupleProtocol.writeString(nonFieldObjectData.tooltip);
            }
            if (nonFieldObjectData.isSetConditionalFormatting()) {
                nonFieldObjectData.conditionalFormatting.write((TProtocol)tTupleProtocol);
            }
            if (nonFieldObjectData.isSetHideConditionCalculated()) {
                tTupleProtocol.writeBool(nonFieldObjectData.hideConditionCalculated);
            }
            if (nonFieldObjectData.isSetHideConditionOn()) {
                tTupleProtocol.writeBool(nonFieldObjectData.hideConditionOn);
            }
            if (nonFieldObjectData.isSetButtonBarActiveSegment()) {
                tTupleProtocol.writeBool(nonFieldObjectData.buttonBarActiveSegment);
            }
            if (nonFieldObjectData.isSetPopoverId()) {
                tTupleProtocol.writeI32(nonFieldObjectData.popoverId);
            }
            if (nonFieldObjectData.isSetAccTitle()) {
                tTupleProtocol.writeString(nonFieldObjectData.accTitle);
            }
            if (nonFieldObjectData.isSetAccHelp()) {
                tTupleProtocol.writeString(nonFieldObjectData.accHelp);
            }
            if (nonFieldObjectData.isSetAccLabel()) {
                tTupleProtocol.writeString(nonFieldObjectData.accLabel);
            }
        }

        public void read(TProtocol tProtocol, NonFieldObjectData nonFieldObjectData) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(13);
            if (bitSet.get(0)) {
                nonFieldObjectData.objectId = tTupleProtocol.readI32();
                nonFieldObjectData.setObjectIdIsSet(true);
            }
            if (bitSet.get(1)) {
                nonFieldObjectData.portalId = tTupleProtocol.readI32();
                nonFieldObjectData.setPortalIdIsSet(true);
            }
            if (bitSet.get(2)) {
                nonFieldObjectData.data = new Data();
                nonFieldObjectData.data.read((TProtocol)tTupleProtocol);
                nonFieldObjectData.setDataIsSet(true);
            }
            if (bitSet.get(3)) {
                nonFieldObjectData.dataType = DataType.findByValue(tTupleProtocol.readI32());
                nonFieldObjectData.setDataTypeIsSet(true);
            }
            if (bitSet.get(4)) {
                nonFieldObjectData.tooltip = tTupleProtocol.readString();
                nonFieldObjectData.setTooltipIsSet(true);
            }
            if (bitSet.get(5)) {
                nonFieldObjectData.conditionalFormatting = new CFObject();
                nonFieldObjectData.conditionalFormatting.read((TProtocol)tTupleProtocol);
                nonFieldObjectData.setConditionalFormattingIsSet(true);
            }
            if (bitSet.get(6)) {
                nonFieldObjectData.hideConditionCalculated = tTupleProtocol.readBool();
                nonFieldObjectData.setHideConditionCalculatedIsSet(true);
            }
            if (bitSet.get(7)) {
                nonFieldObjectData.hideConditionOn = tTupleProtocol.readBool();
                nonFieldObjectData.setHideConditionOnIsSet(true);
            }
            if (bitSet.get(8)) {
                nonFieldObjectData.buttonBarActiveSegment = tTupleProtocol.readBool();
                nonFieldObjectData.setButtonBarActiveSegmentIsSet(true);
            }
            if (bitSet.get(9)) {
                nonFieldObjectData.popoverId = tTupleProtocol.readI32();
                nonFieldObjectData.setPopoverIdIsSet(true);
            }
            if (bitSet.get(10)) {
                nonFieldObjectData.accTitle = tTupleProtocol.readString();
                nonFieldObjectData.setAccTitleIsSet(true);
            }
            if (bitSet.get(11)) {
                nonFieldObjectData.accHelp = tTupleProtocol.readString();
                nonFieldObjectData.setAccHelpIsSet(true);
            }
            if (bitSet.get(12)) {
                nonFieldObjectData.accLabel = tTupleProtocol.readString();
                nonFieldObjectData.setAccLabelIsSet(true);
            }
        }
    }

    private static class NonFieldObjectDataStandardScheme
    extends StandardScheme<NonFieldObjectData> {
        private NonFieldObjectDataStandardScheme() {
        }

        public void read(TProtocol tProtocol, NonFieldObjectData nonFieldObjectData) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 8) {
                            nonFieldObjectData.objectId = tProtocol.readI32();
                            nonFieldObjectData.setObjectIdIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 8) {
                            nonFieldObjectData.portalId = tProtocol.readI32();
                            nonFieldObjectData.setPortalIdIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 12) {
                            nonFieldObjectData.data = new Data();
                            nonFieldObjectData.data.read(tProtocol);
                            nonFieldObjectData.setDataIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 8) {
                            nonFieldObjectData.dataType = DataType.findByValue(tProtocol.readI32());
                            nonFieldObjectData.setDataTypeIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 5: {
                        if (tField.type == 11) {
                            nonFieldObjectData.tooltip = tProtocol.readString();
                            nonFieldObjectData.setTooltipIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 6: {
                        if (tField.type == 12) {
                            nonFieldObjectData.conditionalFormatting = new CFObject();
                            nonFieldObjectData.conditionalFormatting.read(tProtocol);
                            nonFieldObjectData.setConditionalFormattingIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 7: {
                        if (tField.type == 2) {
                            nonFieldObjectData.hideConditionCalculated = tProtocol.readBool();
                            nonFieldObjectData.setHideConditionCalculatedIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 8: {
                        if (tField.type == 2) {
                            nonFieldObjectData.hideConditionOn = tProtocol.readBool();
                            nonFieldObjectData.setHideConditionOnIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 9: {
                        if (tField.type == 2) {
                            nonFieldObjectData.buttonBarActiveSegment = tProtocol.readBool();
                            nonFieldObjectData.setButtonBarActiveSegmentIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 10: {
                        if (tField.type == 8) {
                            nonFieldObjectData.popoverId = tProtocol.readI32();
                            nonFieldObjectData.setPopoverIdIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 11: {
                        if (tField.type == 11) {
                            nonFieldObjectData.accTitle = tProtocol.readString();
                            nonFieldObjectData.setAccTitleIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 12: {
                        if (tField.type == 11) {
                            nonFieldObjectData.accHelp = tProtocol.readString();
                            nonFieldObjectData.setAccHelpIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 13: {
                        if (tField.type == 11) {
                            nonFieldObjectData.accLabel = tProtocol.readString();
                            nonFieldObjectData.setAccLabelIsSet(true);
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
            nonFieldObjectData.validate();
        }

        public void write(TProtocol tProtocol, NonFieldObjectData nonFieldObjectData) throws TException {
            nonFieldObjectData.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            tProtocol.writeFieldBegin(OBJECT_ID_FIELD_DESC);
            tProtocol.writeI32(nonFieldObjectData.objectId);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(PORTAL_ID_FIELD_DESC);
            tProtocol.writeI32(nonFieldObjectData.portalId);
            tProtocol.writeFieldEnd();
            if (nonFieldObjectData.data != null) {
                tProtocol.writeFieldBegin(DATA_FIELD_DESC);
                nonFieldObjectData.data.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            if (nonFieldObjectData.dataType != null) {
                tProtocol.writeFieldBegin(DATA_TYPE_FIELD_DESC);
                tProtocol.writeI32(nonFieldObjectData.dataType.getValue());
                tProtocol.writeFieldEnd();
            }
            if (nonFieldObjectData.tooltip != null) {
                tProtocol.writeFieldBegin(TOOLTIP_FIELD_DESC);
                tProtocol.writeString(nonFieldObjectData.tooltip);
                tProtocol.writeFieldEnd();
            }
            if (nonFieldObjectData.conditionalFormatting != null) {
                tProtocol.writeFieldBegin(CONDITIONAL_FORMATTING_FIELD_DESC);
                nonFieldObjectData.conditionalFormatting.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(HIDE_CONDITION_CALCULATED_FIELD_DESC);
            tProtocol.writeBool(nonFieldObjectData.hideConditionCalculated);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(HIDE_CONDITION_ON_FIELD_DESC);
            tProtocol.writeBool(nonFieldObjectData.hideConditionOn);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(BUTTON_BAR_ACTIVE_SEGMENT_FIELD_DESC);
            tProtocol.writeBool(nonFieldObjectData.buttonBarActiveSegment);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(POPOVER_ID_FIELD_DESC);
            tProtocol.writeI32(nonFieldObjectData.popoverId);
            tProtocol.writeFieldEnd();
            if (nonFieldObjectData.accTitle != null) {
                tProtocol.writeFieldBegin(ACC_TITLE_FIELD_DESC);
                tProtocol.writeString(nonFieldObjectData.accTitle);
                tProtocol.writeFieldEnd();
            }
            if (nonFieldObjectData.accHelp != null) {
                tProtocol.writeFieldBegin(ACC_HELP_FIELD_DESC);
                tProtocol.writeString(nonFieldObjectData.accHelp);
                tProtocol.writeFieldEnd();
            }
            if (nonFieldObjectData.accLabel != null) {
                tProtocol.writeFieldBegin(ACC_LABEL_FIELD_DESC);
                tProtocol.writeString(nonFieldObjectData.accLabel);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

