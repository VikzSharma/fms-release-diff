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
 *  org.apache.thrift.meta_data.MapMetaData
 *  org.apache.thrift.meta_data.StructMetaData
 *  org.apache.thrift.protocol.TCompactProtocol
 *  org.apache.thrift.protocol.TField
 *  org.apache.thrift.protocol.TMap
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
import com.filemaker.jwpc.iwp.thrift.common.DBAccessLevel;
import com.filemaker.jwpc.iwp.thrift.common.FieldSpec;
import com.filemaker.jwpc.iwp.thrift.common.ValueListData;
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
import org.apache.thrift.meta_data.MapMetaData;
import org.apache.thrift.meta_data.StructMetaData;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TMap;
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

public class FieldData
implements TBase<FieldData, _Fields>,
Serializable,
Cloneable,
Comparable<FieldData> {
    private static final TStruct STRUCT_DESC = new TStruct("FieldData");
    private static final TField FIELD_SPEC_FIELD_DESC = new TField("fieldSpec", 12, 1);
    private static final TField DATA_FIELD_DESC = new TField("data", 12, 2);
    private static final TField DATA_TYPE_FIELD_DESC = new TField("dataType", 8, 3);
    private static final TField FIELD_ACCESS_FIELD_DESC = new TField("fieldAccess", 8, 4);
    private static final TField ERROR_CODE_FIELD_DESC = new TField("errorCode", 8, 5);
    private static final TField ERROR_MESSAGE_FIELD_DESC = new TField("errorMessage", 11, 6);
    private static final TField TOOLTIP_VALUES_FIELD_DESC = new TField("tooltipValues", 13, 7);
    private static final TField CONDITIONAL_FORMATTING_VALUES_FIELD_DESC = new TField("conditionalFormattingValues", 13, 8);
    private static final TField HIDE_CONDITION_ON_FIELD_DESC = new TField("hideConditionOn", 2, 9);
    private static final TField PLACEHOLDER_TEXT_VALUES_FIELD_DESC = new TField("placeholderTextValues", 13, 10);
    private static final TField HIDE_ZEROES_ON_FIELD_DESC = new TField("hideZeroesOn", 2, 11);
    private static final TField UPDATE_SELECTION_FIELD_DESC = new TField("updateSelection", 2, 12);
    private static final TField SELECTION_START_FIELD_DESC = new TField("selectionStart", 8, 13);
    private static final TField SELECTION_END_FIELD_DESC = new TField("selectionEnd", 8, 14);
    private static final TField VALUE_LIST_DATA_INCLUDED_FIELD_DESC = new TField("valueListDataIncluded", 2, 15);
    private static final TField VALUE_LIST_DATA_FIELD_DESC = new TField("valueListData", 12, 16);
    private static final TField STREAM_ON_FIELD_DESC = new TField("streamOn", 2, 17);
    private static final TField ACC_TITLE_VALUES_FIELD_DESC = new TField("accTitleValues", 13, 18);
    private static final TField ACC_HELP_VALUES_FIELD_DESC = new TField("accHelpValues", 13, 19);
    private static final TField ACC_LABEL_VALUES_FIELD_DESC = new TField("accLabelValues", 13, 20);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new FieldDataStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new FieldDataTupleSchemeFactory();
    @Nullable
    private FieldSpec fieldSpec;
    @Nullable
    private Data data;
    @Nullable
    private DataType dataType;
    @Nullable
    private DBAccessLevel fieldAccess;
    private int errorCode;
    @Nullable
    private String errorMessage;
    @Nullable
    private Map<Short, String> tooltipValues;
    @Nullable
    private Map<Short, CFObject> conditionalFormattingValues;
    private boolean hideConditionOn;
    @Nullable
    private Map<Short, String> placeholderTextValues;
    private boolean hideZeroesOn;
    private boolean updateSelection;
    private int selectionStart;
    private int selectionEnd;
    private boolean valueListDataIncluded;
    @Nullable
    private ValueListData valueListData;
    private boolean streamOn;
    @Nullable
    private Map<Short, String> accTitleValues;
    @Nullable
    private Map<Short, String> accHelpValues;
    @Nullable
    private Map<Short, String> accLabelValues;
    private static final int __ERRORCODE_ISSET_ID = 0;
    private static final int __HIDECONDITIONON_ISSET_ID = 1;
    private static final int __HIDEZEROESON_ISSET_ID = 2;
    private static final int __UPDATESELECTION_ISSET_ID = 3;
    private static final int __SELECTIONSTART_ISSET_ID = 4;
    private static final int __SELECTIONEND_ISSET_ID = 5;
    private static final int __VALUELISTDATAINCLUDED_ISSET_ID = 6;
    private static final int __STREAMON_ISSET_ID = 7;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public FieldData() {
        this.dataType = DataType.INVALID;
        this.fieldAccess = DBAccessLevel.UnknownAccess;
    }

    public FieldData(FieldSpec fieldSpec, Data data, DataType dataType, DBAccessLevel dBAccessLevel, int n, String string, Map<Short, String> map, Map<Short, CFObject> map2, boolean bl, Map<Short, String> map3, boolean bl2, boolean bl3, int n2, int n3, boolean bl4, ValueListData valueListData, boolean bl5, Map<Short, String> map4, Map<Short, String> map5, Map<Short, String> map6) {
        this();
        this.fieldSpec = fieldSpec;
        this.data = data;
        this.dataType = dataType;
        this.fieldAccess = dBAccessLevel;
        this.errorCode = n;
        this.setErrorCodeIsSet(true);
        this.errorMessage = string;
        this.tooltipValues = map;
        this.conditionalFormattingValues = map2;
        this.hideConditionOn = bl;
        this.setHideConditionOnIsSet(true);
        this.placeholderTextValues = map3;
        this.hideZeroesOn = bl2;
        this.setHideZeroesOnIsSet(true);
        this.updateSelection = bl3;
        this.setUpdateSelectionIsSet(true);
        this.selectionStart = n2;
        this.setSelectionStartIsSet(true);
        this.selectionEnd = n3;
        this.setSelectionEndIsSet(true);
        this.valueListDataIncluded = bl4;
        this.setValueListDataIncludedIsSet(true);
        this.valueListData = valueListData;
        this.streamOn = bl5;
        this.setStreamOnIsSet(true);
        this.accTitleValues = map4;
        this.accHelpValues = map5;
        this.accLabelValues = map6;
    }

    public FieldData(FieldData fieldData) {
        HashMap<Short, String> hashMap;
        this.__isset_bitfield = fieldData.__isset_bitfield;
        if (fieldData.isSetFieldSpec()) {
            this.fieldSpec = new FieldSpec(fieldData.fieldSpec);
        }
        if (fieldData.isSetData()) {
            this.data = new Data(fieldData.data);
        }
        if (fieldData.isSetDataType()) {
            this.dataType = fieldData.dataType;
        }
        if (fieldData.isSetFieldAccess()) {
            this.fieldAccess = fieldData.fieldAccess;
        }
        this.errorCode = fieldData.errorCode;
        if (fieldData.isSetErrorMessage()) {
            this.errorMessage = fieldData.errorMessage;
        }
        if (fieldData.isSetTooltipValues()) {
            hashMap = new HashMap<Short, String>(fieldData.tooltipValues);
            this.tooltipValues = hashMap;
        }
        if (fieldData.isSetConditionalFormattingValues()) {
            hashMap = new HashMap(fieldData.conditionalFormattingValues.size());
            for (Map.Entry<Short, CFObject> entry : fieldData.conditionalFormattingValues.entrySet()) {
                Short s = entry.getKey();
                CFObject cFObject = entry.getValue();
                Short s2 = s;
                CFObject cFObject2 = new CFObject(cFObject);
                hashMap.put(s2, (String)((Object)cFObject2));
            }
            this.conditionalFormattingValues = hashMap;
        }
        this.hideConditionOn = fieldData.hideConditionOn;
        if (fieldData.isSetPlaceholderTextValues()) {
            hashMap = new HashMap<Short, String>(fieldData.placeholderTextValues);
            this.placeholderTextValues = hashMap;
        }
        this.hideZeroesOn = fieldData.hideZeroesOn;
        this.updateSelection = fieldData.updateSelection;
        this.selectionStart = fieldData.selectionStart;
        this.selectionEnd = fieldData.selectionEnd;
        this.valueListDataIncluded = fieldData.valueListDataIncluded;
        if (fieldData.isSetValueListData()) {
            this.valueListData = new ValueListData(fieldData.valueListData);
        }
        this.streamOn = fieldData.streamOn;
        if (fieldData.isSetAccTitleValues()) {
            hashMap = new HashMap<Short, String>(fieldData.accTitleValues);
            this.accTitleValues = hashMap;
        }
        if (fieldData.isSetAccHelpValues()) {
            hashMap = new HashMap<Short, String>(fieldData.accHelpValues);
            this.accHelpValues = hashMap;
        }
        if (fieldData.isSetAccLabelValues()) {
            hashMap = new HashMap<Short, String>(fieldData.accLabelValues);
            this.accLabelValues = hashMap;
        }
    }

    public FieldData deepCopy() {
        return new FieldData(this);
    }

    public void clear() {
        this.fieldSpec = null;
        this.data = null;
        this.dataType = DataType.INVALID;
        this.fieldAccess = DBAccessLevel.UnknownAccess;
        this.setErrorCodeIsSet(false);
        this.errorCode = 0;
        this.errorMessage = null;
        this.tooltipValues = null;
        this.conditionalFormattingValues = null;
        this.setHideConditionOnIsSet(false);
        this.hideConditionOn = false;
        this.placeholderTextValues = null;
        this.setHideZeroesOnIsSet(false);
        this.hideZeroesOn = false;
        this.setUpdateSelectionIsSet(false);
        this.updateSelection = false;
        this.setSelectionStartIsSet(false);
        this.selectionStart = 0;
        this.setSelectionEndIsSet(false);
        this.selectionEnd = 0;
        this.setValueListDataIncludedIsSet(false);
        this.valueListDataIncluded = false;
        this.valueListData = null;
        this.setStreamOnIsSet(false);
        this.streamOn = false;
        this.accTitleValues = null;
        this.accHelpValues = null;
        this.accLabelValues = null;
    }

    @Nullable
    public FieldSpec getFieldSpec() {
        return this.fieldSpec;
    }

    public void setFieldSpec(@Nullable FieldSpec fieldSpec) {
        this.fieldSpec = fieldSpec;
    }

    public void unsetFieldSpec() {
        this.fieldSpec = null;
    }

    public boolean isSetFieldSpec() {
        return this.fieldSpec != null;
    }

    public void setFieldSpecIsSet(boolean bl) {
        if (!bl) {
            this.fieldSpec = null;
        }
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
    public DBAccessLevel getFieldAccess() {
        return this.fieldAccess;
    }

    public void setFieldAccess(@Nullable DBAccessLevel dBAccessLevel) {
        this.fieldAccess = dBAccessLevel;
    }

    public void unsetFieldAccess() {
        this.fieldAccess = null;
    }

    public boolean isSetFieldAccess() {
        return this.fieldAccess != null;
    }

    public void setFieldAccessIsSet(boolean bl) {
        if (!bl) {
            this.fieldAccess = null;
        }
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(int n) {
        this.errorCode = n;
        this.setErrorCodeIsSet(true);
    }

    public void unsetErrorCode() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetErrorCode() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setErrorCodeIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    @Nullable
    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(@Nullable String string) {
        this.errorMessage = string;
    }

    public void unsetErrorMessage() {
        this.errorMessage = null;
    }

    public boolean isSetErrorMessage() {
        return this.errorMessage != null;
    }

    public void setErrorMessageIsSet(boolean bl) {
        if (!bl) {
            this.errorMessage = null;
        }
    }

    public int getTooltipValuesSize() {
        return this.tooltipValues == null ? 0 : this.tooltipValues.size();
    }

    public void putToTooltipValues(short s, String string) {
        if (this.tooltipValues == null) {
            this.tooltipValues = new HashMap<Short, String>();
        }
        this.tooltipValues.put(s, string);
    }

    @Nullable
    public Map<Short, String> getTooltipValues() {
        return this.tooltipValues;
    }

    public void setTooltipValues(@Nullable Map<Short, String> map) {
        this.tooltipValues = map;
    }

    public void unsetTooltipValues() {
        this.tooltipValues = null;
    }

    public boolean isSetTooltipValues() {
        return this.tooltipValues != null;
    }

    public void setTooltipValuesIsSet(boolean bl) {
        if (!bl) {
            this.tooltipValues = null;
        }
    }

    public int getConditionalFormattingValuesSize() {
        return this.conditionalFormattingValues == null ? 0 : this.conditionalFormattingValues.size();
    }

    public void putToConditionalFormattingValues(short s, CFObject cFObject) {
        if (this.conditionalFormattingValues == null) {
            this.conditionalFormattingValues = new HashMap<Short, CFObject>();
        }
        this.conditionalFormattingValues.put(s, cFObject);
    }

    @Nullable
    public Map<Short, CFObject> getConditionalFormattingValues() {
        return this.conditionalFormattingValues;
    }

    public void setConditionalFormattingValues(@Nullable Map<Short, CFObject> map) {
        this.conditionalFormattingValues = map;
    }

    public void unsetConditionalFormattingValues() {
        this.conditionalFormattingValues = null;
    }

    public boolean isSetConditionalFormattingValues() {
        return this.conditionalFormattingValues != null;
    }

    public void setConditionalFormattingValuesIsSet(boolean bl) {
        if (!bl) {
            this.conditionalFormattingValues = null;
        }
    }

    public boolean isHideConditionOn() {
        return this.hideConditionOn;
    }

    public void setHideConditionOn(boolean bl) {
        this.hideConditionOn = bl;
        this.setHideConditionOnIsSet(true);
    }

    public void unsetHideConditionOn() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)1);
    }

    public boolean isSetHideConditionOn() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)1);
    }

    public void setHideConditionOnIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)1, (boolean)bl);
    }

    public int getPlaceholderTextValuesSize() {
        return this.placeholderTextValues == null ? 0 : this.placeholderTextValues.size();
    }

    public void putToPlaceholderTextValues(short s, String string) {
        if (this.placeholderTextValues == null) {
            this.placeholderTextValues = new HashMap<Short, String>();
        }
        this.placeholderTextValues.put(s, string);
    }

    @Nullable
    public Map<Short, String> getPlaceholderTextValues() {
        return this.placeholderTextValues;
    }

    public void setPlaceholderTextValues(@Nullable Map<Short, String> map) {
        this.placeholderTextValues = map;
    }

    public void unsetPlaceholderTextValues() {
        this.placeholderTextValues = null;
    }

    public boolean isSetPlaceholderTextValues() {
        return this.placeholderTextValues != null;
    }

    public void setPlaceholderTextValuesIsSet(boolean bl) {
        if (!bl) {
            this.placeholderTextValues = null;
        }
    }

    public boolean isHideZeroesOn() {
        return this.hideZeroesOn;
    }

    public void setHideZeroesOn(boolean bl) {
        this.hideZeroesOn = bl;
        this.setHideZeroesOnIsSet(true);
    }

    public void unsetHideZeroesOn() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)2);
    }

    public boolean isSetHideZeroesOn() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)2);
    }

    public void setHideZeroesOnIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)2, (boolean)bl);
    }

    public boolean isUpdateSelection() {
        return this.updateSelection;
    }

    public void setUpdateSelection(boolean bl) {
        this.updateSelection = bl;
        this.setUpdateSelectionIsSet(true);
    }

    public void unsetUpdateSelection() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)3);
    }

    public boolean isSetUpdateSelection() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)3);
    }

    public void setUpdateSelectionIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)3, (boolean)bl);
    }

    public int getSelectionStart() {
        return this.selectionStart;
    }

    public void setSelectionStart(int n) {
        this.selectionStart = n;
        this.setSelectionStartIsSet(true);
    }

    public void unsetSelectionStart() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)4);
    }

    public boolean isSetSelectionStart() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)4);
    }

    public void setSelectionStartIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)4, (boolean)bl);
    }

    public int getSelectionEnd() {
        return this.selectionEnd;
    }

    public void setSelectionEnd(int n) {
        this.selectionEnd = n;
        this.setSelectionEndIsSet(true);
    }

    public void unsetSelectionEnd() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)5);
    }

    public boolean isSetSelectionEnd() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)5);
    }

    public void setSelectionEndIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)5, (boolean)bl);
    }

    public boolean isValueListDataIncluded() {
        return this.valueListDataIncluded;
    }

    public void setValueListDataIncluded(boolean bl) {
        this.valueListDataIncluded = bl;
        this.setValueListDataIncludedIsSet(true);
    }

    public void unsetValueListDataIncluded() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)6);
    }

    public boolean isSetValueListDataIncluded() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)6);
    }

    public void setValueListDataIncludedIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)6, (boolean)bl);
    }

    @Nullable
    public ValueListData getValueListData() {
        return this.valueListData;
    }

    public void setValueListData(@Nullable ValueListData valueListData) {
        this.valueListData = valueListData;
    }

    public void unsetValueListData() {
        this.valueListData = null;
    }

    public boolean isSetValueListData() {
        return this.valueListData != null;
    }

    public void setValueListDataIsSet(boolean bl) {
        if (!bl) {
            this.valueListData = null;
        }
    }

    public boolean isStreamOn() {
        return this.streamOn;
    }

    public void setStreamOn(boolean bl) {
        this.streamOn = bl;
        this.setStreamOnIsSet(true);
    }

    public void unsetStreamOn() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)7);
    }

    public boolean isSetStreamOn() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)7);
    }

    public void setStreamOnIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)7, (boolean)bl);
    }

    public int getAccTitleValuesSize() {
        return this.accTitleValues == null ? 0 : this.accTitleValues.size();
    }

    public void putToAccTitleValues(short s, String string) {
        if (this.accTitleValues == null) {
            this.accTitleValues = new HashMap<Short, String>();
        }
        this.accTitleValues.put(s, string);
    }

    @Nullable
    public Map<Short, String> getAccTitleValues() {
        return this.accTitleValues;
    }

    public void setAccTitleValues(@Nullable Map<Short, String> map) {
        this.accTitleValues = map;
    }

    public void unsetAccTitleValues() {
        this.accTitleValues = null;
    }

    public boolean isSetAccTitleValues() {
        return this.accTitleValues != null;
    }

    public void setAccTitleValuesIsSet(boolean bl) {
        if (!bl) {
            this.accTitleValues = null;
        }
    }

    public int getAccHelpValuesSize() {
        return this.accHelpValues == null ? 0 : this.accHelpValues.size();
    }

    public void putToAccHelpValues(short s, String string) {
        if (this.accHelpValues == null) {
            this.accHelpValues = new HashMap<Short, String>();
        }
        this.accHelpValues.put(s, string);
    }

    @Nullable
    public Map<Short, String> getAccHelpValues() {
        return this.accHelpValues;
    }

    public void setAccHelpValues(@Nullable Map<Short, String> map) {
        this.accHelpValues = map;
    }

    public void unsetAccHelpValues() {
        this.accHelpValues = null;
    }

    public boolean isSetAccHelpValues() {
        return this.accHelpValues != null;
    }

    public void setAccHelpValuesIsSet(boolean bl) {
        if (!bl) {
            this.accHelpValues = null;
        }
    }

    public int getAccLabelValuesSize() {
        return this.accLabelValues == null ? 0 : this.accLabelValues.size();
    }

    public void putToAccLabelValues(short s, String string) {
        if (this.accLabelValues == null) {
            this.accLabelValues = new HashMap<Short, String>();
        }
        this.accLabelValues.put(s, string);
    }

    @Nullable
    public Map<Short, String> getAccLabelValues() {
        return this.accLabelValues;
    }

    public void setAccLabelValues(@Nullable Map<Short, String> map) {
        this.accLabelValues = map;
    }

    public void unsetAccLabelValues() {
        this.accLabelValues = null;
    }

    public boolean isSetAccLabelValues() {
        return this.accLabelValues != null;
    }

    public void setAccLabelValuesIsSet(boolean bl) {
        if (!bl) {
            this.accLabelValues = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetFieldSpec();
                    break;
                }
                this.setFieldSpec((FieldSpec)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetData();
                    break;
                }
                this.setData((Data)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetDataType();
                    break;
                }
                this.setDataType((DataType)((Object)object));
                break;
            }
            case 3: {
                if (object == null) {
                    this.unsetFieldAccess();
                    break;
                }
                this.setFieldAccess((DBAccessLevel)((Object)object));
                break;
            }
            case 4: {
                if (object == null) {
                    this.unsetErrorCode();
                    break;
                }
                this.setErrorCode((Integer)object);
                break;
            }
            case 5: {
                if (object == null) {
                    this.unsetErrorMessage();
                    break;
                }
                this.setErrorMessage((String)object);
                break;
            }
            case 6: {
                if (object == null) {
                    this.unsetTooltipValues();
                    break;
                }
                this.setTooltipValues((Map)object);
                break;
            }
            case 7: {
                if (object == null) {
                    this.unsetConditionalFormattingValues();
                    break;
                }
                this.setConditionalFormattingValues((Map)object);
                break;
            }
            case 8: {
                if (object == null) {
                    this.unsetHideConditionOn();
                    break;
                }
                this.setHideConditionOn((Boolean)object);
                break;
            }
            case 9: {
                if (object == null) {
                    this.unsetPlaceholderTextValues();
                    break;
                }
                this.setPlaceholderTextValues((Map)object);
                break;
            }
            case 10: {
                if (object == null) {
                    this.unsetHideZeroesOn();
                    break;
                }
                this.setHideZeroesOn((Boolean)object);
                break;
            }
            case 11: {
                if (object == null) {
                    this.unsetUpdateSelection();
                    break;
                }
                this.setUpdateSelection((Boolean)object);
                break;
            }
            case 12: {
                if (object == null) {
                    this.unsetSelectionStart();
                    break;
                }
                this.setSelectionStart((Integer)object);
                break;
            }
            case 13: {
                if (object == null) {
                    this.unsetSelectionEnd();
                    break;
                }
                this.setSelectionEnd((Integer)object);
                break;
            }
            case 14: {
                if (object == null) {
                    this.unsetValueListDataIncluded();
                    break;
                }
                this.setValueListDataIncluded((Boolean)object);
                break;
            }
            case 15: {
                if (object == null) {
                    this.unsetValueListData();
                    break;
                }
                this.setValueListData((ValueListData)object);
                break;
            }
            case 16: {
                if (object == null) {
                    this.unsetStreamOn();
                    break;
                }
                this.setStreamOn((Boolean)object);
                break;
            }
            case 17: {
                if (object == null) {
                    this.unsetAccTitleValues();
                    break;
                }
                this.setAccTitleValues((Map)object);
                break;
            }
            case 18: {
                if (object == null) {
                    this.unsetAccHelpValues();
                    break;
                }
                this.setAccHelpValues((Map)object);
                break;
            }
            case 19: {
                if (object == null) {
                    this.unsetAccLabelValues();
                    break;
                }
                this.setAccLabelValues((Map)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getFieldSpec();
            }
            case 1: {
                return this.getData();
            }
            case 2: {
                return this.getDataType();
            }
            case 3: {
                return this.getFieldAccess();
            }
            case 4: {
                return this.getErrorCode();
            }
            case 5: {
                return this.getErrorMessage();
            }
            case 6: {
                return this.getTooltipValues();
            }
            case 7: {
                return this.getConditionalFormattingValues();
            }
            case 8: {
                return this.isHideConditionOn();
            }
            case 9: {
                return this.getPlaceholderTextValues();
            }
            case 10: {
                return this.isHideZeroesOn();
            }
            case 11: {
                return this.isUpdateSelection();
            }
            case 12: {
                return this.getSelectionStart();
            }
            case 13: {
                return this.getSelectionEnd();
            }
            case 14: {
                return this.isValueListDataIncluded();
            }
            case 15: {
                return this.getValueListData();
            }
            case 16: {
                return this.isStreamOn();
            }
            case 17: {
                return this.getAccTitleValues();
            }
            case 18: {
                return this.getAccHelpValues();
            }
            case 19: {
                return this.getAccLabelValues();
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
                return this.isSetFieldSpec();
            }
            case 1: {
                return this.isSetData();
            }
            case 2: {
                return this.isSetDataType();
            }
            case 3: {
                return this.isSetFieldAccess();
            }
            case 4: {
                return this.isSetErrorCode();
            }
            case 5: {
                return this.isSetErrorMessage();
            }
            case 6: {
                return this.isSetTooltipValues();
            }
            case 7: {
                return this.isSetConditionalFormattingValues();
            }
            case 8: {
                return this.isSetHideConditionOn();
            }
            case 9: {
                return this.isSetPlaceholderTextValues();
            }
            case 10: {
                return this.isSetHideZeroesOn();
            }
            case 11: {
                return this.isSetUpdateSelection();
            }
            case 12: {
                return this.isSetSelectionStart();
            }
            case 13: {
                return this.isSetSelectionEnd();
            }
            case 14: {
                return this.isSetValueListDataIncluded();
            }
            case 15: {
                return this.isSetValueListData();
            }
            case 16: {
                return this.isSetStreamOn();
            }
            case 17: {
                return this.isSetAccTitleValues();
            }
            case 18: {
                return this.isSetAccHelpValues();
            }
            case 19: {
                return this.isSetAccLabelValues();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof FieldData) {
            return this.equals((FieldData)object);
        }
        return false;
    }

    public boolean equals(FieldData fieldData) {
        if (fieldData == null) {
            return false;
        }
        if (this == fieldData) {
            return true;
        }
        boolean bl = this.isSetFieldSpec();
        boolean bl2 = fieldData.isSetFieldSpec();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.fieldSpec.equals(fieldData.fieldSpec)) {
                return false;
            }
        }
        boolean bl3 = this.isSetData();
        boolean bl4 = fieldData.isSetData();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.data.equals(fieldData.data)) {
                return false;
            }
        }
        boolean bl5 = this.isSetDataType();
        boolean bl6 = fieldData.isSetDataType();
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (!this.dataType.equals((Object)fieldData.dataType)) {
                return false;
            }
        }
        boolean bl7 = this.isSetFieldAccess();
        boolean bl8 = fieldData.isSetFieldAccess();
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (!this.fieldAccess.equals((Object)fieldData.fieldAccess)) {
                return false;
            }
        }
        boolean bl9 = true;
        boolean bl10 = true;
        if (bl9 || bl10) {
            if (!bl9 || !bl10) {
                return false;
            }
            if (this.errorCode != fieldData.errorCode) {
                return false;
            }
        }
        boolean bl11 = this.isSetErrorMessage();
        boolean bl12 = fieldData.isSetErrorMessage();
        if (bl11 || bl12) {
            if (!bl11 || !bl12) {
                return false;
            }
            if (!this.errorMessage.equals(fieldData.errorMessage)) {
                return false;
            }
        }
        boolean bl13 = this.isSetTooltipValues();
        boolean bl14 = fieldData.isSetTooltipValues();
        if (bl13 || bl14) {
            if (!bl13 || !bl14) {
                return false;
            }
            if (!this.tooltipValues.equals(fieldData.tooltipValues)) {
                return false;
            }
        }
        boolean bl15 = this.isSetConditionalFormattingValues();
        boolean bl16 = fieldData.isSetConditionalFormattingValues();
        if (bl15 || bl16) {
            if (!bl15 || !bl16) {
                return false;
            }
            if (!this.conditionalFormattingValues.equals(fieldData.conditionalFormattingValues)) {
                return false;
            }
        }
        boolean bl17 = true;
        boolean bl18 = true;
        if (bl17 || bl18) {
            if (!bl17 || !bl18) {
                return false;
            }
            if (this.hideConditionOn != fieldData.hideConditionOn) {
                return false;
            }
        }
        boolean bl19 = this.isSetPlaceholderTextValues();
        boolean bl20 = fieldData.isSetPlaceholderTextValues();
        if (bl19 || bl20) {
            if (!bl19 || !bl20) {
                return false;
            }
            if (!this.placeholderTextValues.equals(fieldData.placeholderTextValues)) {
                return false;
            }
        }
        boolean bl21 = true;
        boolean bl22 = true;
        if (bl21 || bl22) {
            if (!bl21 || !bl22) {
                return false;
            }
            if (this.hideZeroesOn != fieldData.hideZeroesOn) {
                return false;
            }
        }
        boolean bl23 = true;
        boolean bl24 = true;
        if (bl23 || bl24) {
            if (!bl23 || !bl24) {
                return false;
            }
            if (this.updateSelection != fieldData.updateSelection) {
                return false;
            }
        }
        boolean bl25 = true;
        boolean bl26 = true;
        if (bl25 || bl26) {
            if (!bl25 || !bl26) {
                return false;
            }
            if (this.selectionStart != fieldData.selectionStart) {
                return false;
            }
        }
        boolean bl27 = true;
        boolean bl28 = true;
        if (bl27 || bl28) {
            if (!bl27 || !bl28) {
                return false;
            }
            if (this.selectionEnd != fieldData.selectionEnd) {
                return false;
            }
        }
        boolean bl29 = true;
        boolean bl30 = true;
        if (bl29 || bl30) {
            if (!bl29 || !bl30) {
                return false;
            }
            if (this.valueListDataIncluded != fieldData.valueListDataIncluded) {
                return false;
            }
        }
        boolean bl31 = this.isSetValueListData();
        boolean bl32 = fieldData.isSetValueListData();
        if (bl31 || bl32) {
            if (!bl31 || !bl32) {
                return false;
            }
            if (!this.valueListData.equals(fieldData.valueListData)) {
                return false;
            }
        }
        boolean bl33 = true;
        boolean bl34 = true;
        if (bl33 || bl34) {
            if (!bl33 || !bl34) {
                return false;
            }
            if (this.streamOn != fieldData.streamOn) {
                return false;
            }
        }
        boolean bl35 = this.isSetAccTitleValues();
        boolean bl36 = fieldData.isSetAccTitleValues();
        if (bl35 || bl36) {
            if (!bl35 || !bl36) {
                return false;
            }
            if (!this.accTitleValues.equals(fieldData.accTitleValues)) {
                return false;
            }
        }
        boolean bl37 = this.isSetAccHelpValues();
        boolean bl38 = fieldData.isSetAccHelpValues();
        if (bl37 || bl38) {
            if (!bl37 || !bl38) {
                return false;
            }
            if (!this.accHelpValues.equals(fieldData.accHelpValues)) {
                return false;
            }
        }
        boolean bl39 = this.isSetAccLabelValues();
        boolean bl40 = fieldData.isSetAccLabelValues();
        if (bl39 || bl40) {
            if (!bl39 || !bl40) {
                return false;
            }
            if (!this.accLabelValues.equals(fieldData.accLabelValues)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetFieldSpec() ? 131071 : 524287);
        if (this.isSetFieldSpec()) {
            n = n * 8191 + this.fieldSpec.hashCode();
        }
        n = n * 8191 + (this.isSetData() ? 131071 : 524287);
        if (this.isSetData()) {
            n = n * 8191 + this.data.hashCode();
        }
        n = n * 8191 + (this.isSetDataType() ? 131071 : 524287);
        if (this.isSetDataType()) {
            n = n * 8191 + this.dataType.getValue();
        }
        n = n * 8191 + (this.isSetFieldAccess() ? 131071 : 524287);
        if (this.isSetFieldAccess()) {
            n = n * 8191 + this.fieldAccess.getValue();
        }
        n = n * 8191 + this.errorCode;
        n = n * 8191 + (this.isSetErrorMessage() ? 131071 : 524287);
        if (this.isSetErrorMessage()) {
            n = n * 8191 + this.errorMessage.hashCode();
        }
        n = n * 8191 + (this.isSetTooltipValues() ? 131071 : 524287);
        if (this.isSetTooltipValues()) {
            n = n * 8191 + this.tooltipValues.hashCode();
        }
        n = n * 8191 + (this.isSetConditionalFormattingValues() ? 131071 : 524287);
        if (this.isSetConditionalFormattingValues()) {
            n = n * 8191 + this.conditionalFormattingValues.hashCode();
        }
        n = n * 8191 + (this.hideConditionOn ? 131071 : 524287);
        n = n * 8191 + (this.isSetPlaceholderTextValues() ? 131071 : 524287);
        if (this.isSetPlaceholderTextValues()) {
            n = n * 8191 + this.placeholderTextValues.hashCode();
        }
        n = n * 8191 + (this.hideZeroesOn ? 131071 : 524287);
        n = n * 8191 + (this.updateSelection ? 131071 : 524287);
        n = n * 8191 + this.selectionStart;
        n = n * 8191 + this.selectionEnd;
        n = n * 8191 + (this.valueListDataIncluded ? 131071 : 524287);
        n = n * 8191 + (this.isSetValueListData() ? 131071 : 524287);
        if (this.isSetValueListData()) {
            n = n * 8191 + this.valueListData.hashCode();
        }
        n = n * 8191 + (this.streamOn ? 131071 : 524287);
        n = n * 8191 + (this.isSetAccTitleValues() ? 131071 : 524287);
        if (this.isSetAccTitleValues()) {
            n = n * 8191 + this.accTitleValues.hashCode();
        }
        n = n * 8191 + (this.isSetAccHelpValues() ? 131071 : 524287);
        if (this.isSetAccHelpValues()) {
            n = n * 8191 + this.accHelpValues.hashCode();
        }
        n = n * 8191 + (this.isSetAccLabelValues() ? 131071 : 524287);
        if (this.isSetAccLabelValues()) {
            n = n * 8191 + this.accLabelValues.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(FieldData fieldData) {
        if (!this.getClass().equals(fieldData.getClass())) {
            return this.getClass().getName().compareTo(fieldData.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetFieldSpec(), fieldData.isSetFieldSpec());
        if (n != 0) {
            return n;
        }
        if (this.isSetFieldSpec() && (n = TBaseHelper.compareTo((Comparable)this.fieldSpec, (Comparable)fieldData.fieldSpec)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetData(), fieldData.isSetData());
        if (n != 0) {
            return n;
        }
        if (this.isSetData() && (n = TBaseHelper.compareTo((Comparable)this.data, (Comparable)fieldData.data)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetDataType(), fieldData.isSetDataType());
        if (n != 0) {
            return n;
        }
        if (this.isSetDataType() && (n = TBaseHelper.compareTo((Comparable)((Object)this.dataType), (Comparable)((Object)fieldData.dataType))) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetFieldAccess(), fieldData.isSetFieldAccess());
        if (n != 0) {
            return n;
        }
        if (this.isSetFieldAccess() && (n = TBaseHelper.compareTo((Comparable)((Object)this.fieldAccess), (Comparable)((Object)fieldData.fieldAccess))) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetErrorCode(), fieldData.isSetErrorCode());
        if (n != 0) {
            return n;
        }
        if (this.isSetErrorCode() && (n = TBaseHelper.compareTo((int)this.errorCode, (int)fieldData.errorCode)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetErrorMessage(), fieldData.isSetErrorMessage());
        if (n != 0) {
            return n;
        }
        if (this.isSetErrorMessage() && (n = TBaseHelper.compareTo((String)this.errorMessage, (String)fieldData.errorMessage)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetTooltipValues(), fieldData.isSetTooltipValues());
        if (n != 0) {
            return n;
        }
        if (this.isSetTooltipValues() && (n = TBaseHelper.compareTo(this.tooltipValues, fieldData.tooltipValues)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetConditionalFormattingValues(), fieldData.isSetConditionalFormattingValues());
        if (n != 0) {
            return n;
        }
        if (this.isSetConditionalFormattingValues() && (n = TBaseHelper.compareTo(this.conditionalFormattingValues, fieldData.conditionalFormattingValues)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetHideConditionOn(), fieldData.isSetHideConditionOn());
        if (n != 0) {
            return n;
        }
        if (this.isSetHideConditionOn() && (n = TBaseHelper.compareTo((boolean)this.hideConditionOn, (boolean)fieldData.hideConditionOn)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetPlaceholderTextValues(), fieldData.isSetPlaceholderTextValues());
        if (n != 0) {
            return n;
        }
        if (this.isSetPlaceholderTextValues() && (n = TBaseHelper.compareTo(this.placeholderTextValues, fieldData.placeholderTextValues)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetHideZeroesOn(), fieldData.isSetHideZeroesOn());
        if (n != 0) {
            return n;
        }
        if (this.isSetHideZeroesOn() && (n = TBaseHelper.compareTo((boolean)this.hideZeroesOn, (boolean)fieldData.hideZeroesOn)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetUpdateSelection(), fieldData.isSetUpdateSelection());
        if (n != 0) {
            return n;
        }
        if (this.isSetUpdateSelection() && (n = TBaseHelper.compareTo((boolean)this.updateSelection, (boolean)fieldData.updateSelection)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetSelectionStart(), fieldData.isSetSelectionStart());
        if (n != 0) {
            return n;
        }
        if (this.isSetSelectionStart() && (n = TBaseHelper.compareTo((int)this.selectionStart, (int)fieldData.selectionStart)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetSelectionEnd(), fieldData.isSetSelectionEnd());
        if (n != 0) {
            return n;
        }
        if (this.isSetSelectionEnd() && (n = TBaseHelper.compareTo((int)this.selectionEnd, (int)fieldData.selectionEnd)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetValueListDataIncluded(), fieldData.isSetValueListDataIncluded());
        if (n != 0) {
            return n;
        }
        if (this.isSetValueListDataIncluded() && (n = TBaseHelper.compareTo((boolean)this.valueListDataIncluded, (boolean)fieldData.valueListDataIncluded)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetValueListData(), fieldData.isSetValueListData());
        if (n != 0) {
            return n;
        }
        if (this.isSetValueListData() && (n = TBaseHelper.compareTo((Comparable)this.valueListData, (Comparable)fieldData.valueListData)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetStreamOn(), fieldData.isSetStreamOn());
        if (n != 0) {
            return n;
        }
        if (this.isSetStreamOn() && (n = TBaseHelper.compareTo((boolean)this.streamOn, (boolean)fieldData.streamOn)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetAccTitleValues(), fieldData.isSetAccTitleValues());
        if (n != 0) {
            return n;
        }
        if (this.isSetAccTitleValues() && (n = TBaseHelper.compareTo(this.accTitleValues, fieldData.accTitleValues)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetAccHelpValues(), fieldData.isSetAccHelpValues());
        if (n != 0) {
            return n;
        }
        if (this.isSetAccHelpValues() && (n = TBaseHelper.compareTo(this.accHelpValues, fieldData.accHelpValues)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetAccLabelValues(), fieldData.isSetAccLabelValues());
        if (n != 0) {
            return n;
        }
        if (this.isSetAccLabelValues() && (n = TBaseHelper.compareTo(this.accLabelValues, fieldData.accLabelValues)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        FieldData.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        FieldData.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("FieldData(");
        boolean bl = true;
        stringBuilder.append("fieldSpec:");
        if (this.fieldSpec == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.fieldSpec);
        }
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
        stringBuilder.append("fieldAccess:");
        if (this.fieldAccess == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append((Object)this.fieldAccess);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("errorCode:");
        stringBuilder.append(this.errorCode);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("errorMessage:");
        if (this.errorMessage == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.errorMessage);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("tooltipValues:");
        if (this.tooltipValues == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.tooltipValues);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("conditionalFormattingValues:");
        if (this.conditionalFormattingValues == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.conditionalFormattingValues);
        }
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
        stringBuilder.append("placeholderTextValues:");
        if (this.placeholderTextValues == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.placeholderTextValues);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("hideZeroesOn:");
        stringBuilder.append(this.hideZeroesOn);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("updateSelection:");
        stringBuilder.append(this.updateSelection);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("selectionStart:");
        stringBuilder.append(this.selectionStart);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("selectionEnd:");
        stringBuilder.append(this.selectionEnd);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("valueListDataIncluded:");
        stringBuilder.append(this.valueListDataIncluded);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("valueListData:");
        if (this.valueListData == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.valueListData);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("streamOn:");
        stringBuilder.append(this.streamOn);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("accTitleValues:");
        if (this.accTitleValues == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.accTitleValues);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("accHelpValues:");
        if (this.accHelpValues == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.accHelpValues);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("accLabelValues:");
        if (this.accLabelValues == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.accLabelValues);
        }
        bl = false;
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void validate() throws TException {
        if (this.fieldSpec != null) {
            this.fieldSpec.validate();
        }
        if (this.data != null) {
            this.data.validate();
        }
        if (this.valueListData != null) {
            this.valueListData.validate();
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
        enumMap.put(_Fields.FIELD_SPEC, new FieldMetaData("fieldSpec", 3, (FieldValueMetaData)new StructMetaData(12, FieldSpec.class)));
        enumMap.put(_Fields.DATA, new FieldMetaData("data", 3, (FieldValueMetaData)new StructMetaData(12, Data.class)));
        enumMap.put(_Fields.DATA_TYPE, new FieldMetaData("dataType", 3, (FieldValueMetaData)new EnumMetaData(-1, DataType.class)));
        enumMap.put(_Fields.FIELD_ACCESS, new FieldMetaData("fieldAccess", 3, (FieldValueMetaData)new EnumMetaData(-1, DBAccessLevel.class)));
        enumMap.put(_Fields.ERROR_CODE, new FieldMetaData("errorCode", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.ERROR_MESSAGE, new FieldMetaData("errorMessage", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.TOOLTIP_VALUES, new FieldMetaData("tooltipValues", 3, (FieldValueMetaData)new MapMetaData(13, new FieldValueMetaData(6), new FieldValueMetaData(11))));
        enumMap.put(_Fields.CONDITIONAL_FORMATTING_VALUES, new FieldMetaData("conditionalFormattingValues", 3, (FieldValueMetaData)new MapMetaData(13, new FieldValueMetaData(6), (FieldValueMetaData)new StructMetaData(12, CFObject.class))));
        enumMap.put(_Fields.HIDE_CONDITION_ON, new FieldMetaData("hideConditionOn", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.PLACEHOLDER_TEXT_VALUES, new FieldMetaData("placeholderTextValues", 3, (FieldValueMetaData)new MapMetaData(13, new FieldValueMetaData(6), new FieldValueMetaData(11))));
        enumMap.put(_Fields.HIDE_ZEROES_ON, new FieldMetaData("hideZeroesOn", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.UPDATE_SELECTION, new FieldMetaData("updateSelection", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.SELECTION_START, new FieldMetaData("selectionStart", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.SELECTION_END, new FieldMetaData("selectionEnd", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.VALUE_LIST_DATA_INCLUDED, new FieldMetaData("valueListDataIncluded", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.VALUE_LIST_DATA, new FieldMetaData("valueListData", 3, (FieldValueMetaData)new StructMetaData(12, ValueListData.class)));
        enumMap.put(_Fields.STREAM_ON, new FieldMetaData("streamOn", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.ACC_TITLE_VALUES, new FieldMetaData("accTitleValues", 3, (FieldValueMetaData)new MapMetaData(13, new FieldValueMetaData(6), new FieldValueMetaData(11))));
        enumMap.put(_Fields.ACC_HELP_VALUES, new FieldMetaData("accHelpValues", 3, (FieldValueMetaData)new MapMetaData(13, new FieldValueMetaData(6), new FieldValueMetaData(11))));
        enumMap.put(_Fields.ACC_LABEL_VALUES, new FieldMetaData("accLabelValues", 3, (FieldValueMetaData)new MapMetaData(13, new FieldValueMetaData(6), new FieldValueMetaData(11))));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(FieldData.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        FIELD_SPEC(1, "fieldSpec"),
        DATA(2, "data"),
        DATA_TYPE(3, "dataType"),
        FIELD_ACCESS(4, "fieldAccess"),
        ERROR_CODE(5, "errorCode"),
        ERROR_MESSAGE(6, "errorMessage"),
        TOOLTIP_VALUES(7, "tooltipValues"),
        CONDITIONAL_FORMATTING_VALUES(8, "conditionalFormattingValues"),
        HIDE_CONDITION_ON(9, "hideConditionOn"),
        PLACEHOLDER_TEXT_VALUES(10, "placeholderTextValues"),
        HIDE_ZEROES_ON(11, "hideZeroesOn"),
        UPDATE_SELECTION(12, "updateSelection"),
        SELECTION_START(13, "selectionStart"),
        SELECTION_END(14, "selectionEnd"),
        VALUE_LIST_DATA_INCLUDED(15, "valueListDataIncluded"),
        VALUE_LIST_DATA(16, "valueListData"),
        STREAM_ON(17, "streamOn"),
        ACC_TITLE_VALUES(18, "accTitleValues"),
        ACC_HELP_VALUES(19, "accHelpValues"),
        ACC_LABEL_VALUES(20, "accLabelValues");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return FIELD_SPEC;
                }
                case 2: {
                    return DATA;
                }
                case 3: {
                    return DATA_TYPE;
                }
                case 4: {
                    return FIELD_ACCESS;
                }
                case 5: {
                    return ERROR_CODE;
                }
                case 6: {
                    return ERROR_MESSAGE;
                }
                case 7: {
                    return TOOLTIP_VALUES;
                }
                case 8: {
                    return CONDITIONAL_FORMATTING_VALUES;
                }
                case 9: {
                    return HIDE_CONDITION_ON;
                }
                case 10: {
                    return PLACEHOLDER_TEXT_VALUES;
                }
                case 11: {
                    return HIDE_ZEROES_ON;
                }
                case 12: {
                    return UPDATE_SELECTION;
                }
                case 13: {
                    return SELECTION_START;
                }
                case 14: {
                    return SELECTION_END;
                }
                case 15: {
                    return VALUE_LIST_DATA_INCLUDED;
                }
                case 16: {
                    return VALUE_LIST_DATA;
                }
                case 17: {
                    return STREAM_ON;
                }
                case 18: {
                    return ACC_TITLE_VALUES;
                }
                case 19: {
                    return ACC_HELP_VALUES;
                }
                case 20: {
                    return ACC_LABEL_VALUES;
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

    private static class FieldDataStandardSchemeFactory
    implements SchemeFactory {
        private FieldDataStandardSchemeFactory() {
        }

        public FieldDataStandardScheme getScheme() {
            return new FieldDataStandardScheme();
        }
    }

    private static class FieldDataTupleSchemeFactory
    implements SchemeFactory {
        private FieldDataTupleSchemeFactory() {
        }

        public FieldDataTupleScheme getScheme() {
            return new FieldDataTupleScheme();
        }
    }

    private static class FieldDataTupleScheme
    extends TupleScheme<FieldData> {
        private FieldDataTupleScheme() {
        }

        public void write(TProtocol tProtocol, FieldData fieldData) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (fieldData.isSetFieldSpec()) {
                bitSet.set(0);
            }
            if (fieldData.isSetData()) {
                bitSet.set(1);
            }
            if (fieldData.isSetDataType()) {
                bitSet.set(2);
            }
            if (fieldData.isSetFieldAccess()) {
                bitSet.set(3);
            }
            if (fieldData.isSetErrorCode()) {
                bitSet.set(4);
            }
            if (fieldData.isSetErrorMessage()) {
                bitSet.set(5);
            }
            if (fieldData.isSetTooltipValues()) {
                bitSet.set(6);
            }
            if (fieldData.isSetConditionalFormattingValues()) {
                bitSet.set(7);
            }
            if (fieldData.isSetHideConditionOn()) {
                bitSet.set(8);
            }
            if (fieldData.isSetPlaceholderTextValues()) {
                bitSet.set(9);
            }
            if (fieldData.isSetHideZeroesOn()) {
                bitSet.set(10);
            }
            if (fieldData.isSetUpdateSelection()) {
                bitSet.set(11);
            }
            if (fieldData.isSetSelectionStart()) {
                bitSet.set(12);
            }
            if (fieldData.isSetSelectionEnd()) {
                bitSet.set(13);
            }
            if (fieldData.isSetValueListDataIncluded()) {
                bitSet.set(14);
            }
            if (fieldData.isSetValueListData()) {
                bitSet.set(15);
            }
            if (fieldData.isSetStreamOn()) {
                bitSet.set(16);
            }
            if (fieldData.isSetAccTitleValues()) {
                bitSet.set(17);
            }
            if (fieldData.isSetAccHelpValues()) {
                bitSet.set(18);
            }
            if (fieldData.isSetAccLabelValues()) {
                bitSet.set(19);
            }
            tTupleProtocol.writeBitSet(bitSet, 20);
            if (fieldData.isSetFieldSpec()) {
                fieldData.fieldSpec.write((TProtocol)tTupleProtocol);
            }
            if (fieldData.isSetData()) {
                fieldData.data.write((TProtocol)tTupleProtocol);
            }
            if (fieldData.isSetDataType()) {
                tTupleProtocol.writeI32(fieldData.dataType.getValue());
            }
            if (fieldData.isSetFieldAccess()) {
                tTupleProtocol.writeI32(fieldData.fieldAccess.getValue());
            }
            if (fieldData.isSetErrorCode()) {
                tTupleProtocol.writeI32(fieldData.errorCode);
            }
            if (fieldData.isSetErrorMessage()) {
                tTupleProtocol.writeString(fieldData.errorMessage);
            }
            if (fieldData.isSetTooltipValues()) {
                tTupleProtocol.writeI32(fieldData.tooltipValues.size());
                for (Map.Entry<Short, Object> entry : fieldData.tooltipValues.entrySet()) {
                    tTupleProtocol.writeI16(entry.getKey().shortValue());
                    tTupleProtocol.writeString((String)entry.getValue());
                }
            }
            if (fieldData.isSetConditionalFormattingValues()) {
                tTupleProtocol.writeI32(fieldData.conditionalFormattingValues.size());
                for (Map.Entry<Short, Object> entry : fieldData.conditionalFormattingValues.entrySet()) {
                    tTupleProtocol.writeI16(entry.getKey().shortValue());
                    ((CFObject)entry.getValue()).write((TProtocol)tTupleProtocol);
                }
            }
            if (fieldData.isSetHideConditionOn()) {
                tTupleProtocol.writeBool(fieldData.hideConditionOn);
            }
            if (fieldData.isSetPlaceholderTextValues()) {
                tTupleProtocol.writeI32(fieldData.placeholderTextValues.size());
                for (Map.Entry<Short, Object> entry : fieldData.placeholderTextValues.entrySet()) {
                    tTupleProtocol.writeI16(entry.getKey().shortValue());
                    tTupleProtocol.writeString((String)entry.getValue());
                }
            }
            if (fieldData.isSetHideZeroesOn()) {
                tTupleProtocol.writeBool(fieldData.hideZeroesOn);
            }
            if (fieldData.isSetUpdateSelection()) {
                tTupleProtocol.writeBool(fieldData.updateSelection);
            }
            if (fieldData.isSetSelectionStart()) {
                tTupleProtocol.writeI32(fieldData.selectionStart);
            }
            if (fieldData.isSetSelectionEnd()) {
                tTupleProtocol.writeI32(fieldData.selectionEnd);
            }
            if (fieldData.isSetValueListDataIncluded()) {
                tTupleProtocol.writeBool(fieldData.valueListDataIncluded);
            }
            if (fieldData.isSetValueListData()) {
                fieldData.valueListData.write((TProtocol)tTupleProtocol);
            }
            if (fieldData.isSetStreamOn()) {
                tTupleProtocol.writeBool(fieldData.streamOn);
            }
            if (fieldData.isSetAccTitleValues()) {
                tTupleProtocol.writeI32(fieldData.accTitleValues.size());
                for (Map.Entry<Short, Object> entry : fieldData.accTitleValues.entrySet()) {
                    tTupleProtocol.writeI16(entry.getKey().shortValue());
                    tTupleProtocol.writeString((String)entry.getValue());
                }
            }
            if (fieldData.isSetAccHelpValues()) {
                tTupleProtocol.writeI32(fieldData.accHelpValues.size());
                for (Map.Entry<Short, Object> entry : fieldData.accHelpValues.entrySet()) {
                    tTupleProtocol.writeI16(entry.getKey().shortValue());
                    tTupleProtocol.writeString((String)entry.getValue());
                }
            }
            if (fieldData.isSetAccLabelValues()) {
                tTupleProtocol.writeI32(fieldData.accLabelValues.size());
                for (Map.Entry<Short, Object> entry : fieldData.accLabelValues.entrySet()) {
                    tTupleProtocol.writeI16(entry.getKey().shortValue());
                    tTupleProtocol.writeString((String)entry.getValue());
                }
            }
        }

        public void read(TProtocol tProtocol, FieldData fieldData) throws TException {
            Object object;
            short s;
            int n;
            TMap tMap;
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(20);
            if (bitSet.get(0)) {
                fieldData.fieldSpec = new FieldSpec();
                fieldData.fieldSpec.read((TProtocol)tTupleProtocol);
                fieldData.setFieldSpecIsSet(true);
            }
            if (bitSet.get(1)) {
                fieldData.data = new Data();
                fieldData.data.read((TProtocol)tTupleProtocol);
                fieldData.setDataIsSet(true);
            }
            if (bitSet.get(2)) {
                fieldData.dataType = DataType.findByValue(tTupleProtocol.readI32());
                fieldData.setDataTypeIsSet(true);
            }
            if (bitSet.get(3)) {
                fieldData.fieldAccess = DBAccessLevel.findByValue(tTupleProtocol.readI32());
                fieldData.setFieldAccessIsSet(true);
            }
            if (bitSet.get(4)) {
                fieldData.errorCode = tTupleProtocol.readI32();
                fieldData.setErrorCodeIsSet(true);
            }
            if (bitSet.get(5)) {
                fieldData.errorMessage = tTupleProtocol.readString();
                fieldData.setErrorMessageIsSet(true);
            }
            if (bitSet.get(6)) {
                tMap = tTupleProtocol.readMapBegin((byte)6, (byte)11);
                fieldData.tooltipValues = new HashMap<Short, String>(2 * tMap.size);
                for (n = 0; n < tMap.size; ++n) {
                    s = tTupleProtocol.readI16();
                    object = tTupleProtocol.readString();
                    fieldData.tooltipValues.put(s, (String)object);
                }
                fieldData.setTooltipValuesIsSet(true);
            }
            if (bitSet.get(7)) {
                tMap = tTupleProtocol.readMapBegin((byte)6, (byte)12);
                fieldData.conditionalFormattingValues = new HashMap<Short, CFObject>(2 * tMap.size);
                for (n = 0; n < tMap.size; ++n) {
                    s = tTupleProtocol.readI16();
                    object = new CFObject();
                    ((CFObject)object).read((TProtocol)tTupleProtocol);
                    fieldData.conditionalFormattingValues.put(s, (CFObject)object);
                }
                fieldData.setConditionalFormattingValuesIsSet(true);
            }
            if (bitSet.get(8)) {
                fieldData.hideConditionOn = tTupleProtocol.readBool();
                fieldData.setHideConditionOnIsSet(true);
            }
            if (bitSet.get(9)) {
                tMap = tTupleProtocol.readMapBegin((byte)6, (byte)11);
                fieldData.placeholderTextValues = new HashMap<Short, String>(2 * tMap.size);
                for (n = 0; n < tMap.size; ++n) {
                    s = tTupleProtocol.readI16();
                    object = tTupleProtocol.readString();
                    fieldData.placeholderTextValues.put(s, (String)object);
                }
                fieldData.setPlaceholderTextValuesIsSet(true);
            }
            if (bitSet.get(10)) {
                fieldData.hideZeroesOn = tTupleProtocol.readBool();
                fieldData.setHideZeroesOnIsSet(true);
            }
            if (bitSet.get(11)) {
                fieldData.updateSelection = tTupleProtocol.readBool();
                fieldData.setUpdateSelectionIsSet(true);
            }
            if (bitSet.get(12)) {
                fieldData.selectionStart = tTupleProtocol.readI32();
                fieldData.setSelectionStartIsSet(true);
            }
            if (bitSet.get(13)) {
                fieldData.selectionEnd = tTupleProtocol.readI32();
                fieldData.setSelectionEndIsSet(true);
            }
            if (bitSet.get(14)) {
                fieldData.valueListDataIncluded = tTupleProtocol.readBool();
                fieldData.setValueListDataIncludedIsSet(true);
            }
            if (bitSet.get(15)) {
                fieldData.valueListData = new ValueListData();
                fieldData.valueListData.read((TProtocol)tTupleProtocol);
                fieldData.setValueListDataIsSet(true);
            }
            if (bitSet.get(16)) {
                fieldData.streamOn = tTupleProtocol.readBool();
                fieldData.setStreamOnIsSet(true);
            }
            if (bitSet.get(17)) {
                tMap = tTupleProtocol.readMapBegin((byte)6, (byte)11);
                fieldData.accTitleValues = new HashMap<Short, String>(2 * tMap.size);
                for (n = 0; n < tMap.size; ++n) {
                    s = tTupleProtocol.readI16();
                    object = tTupleProtocol.readString();
                    fieldData.accTitleValues.put(s, (String)object);
                }
                fieldData.setAccTitleValuesIsSet(true);
            }
            if (bitSet.get(18)) {
                tMap = tTupleProtocol.readMapBegin((byte)6, (byte)11);
                fieldData.accHelpValues = new HashMap<Short, String>(2 * tMap.size);
                for (n = 0; n < tMap.size; ++n) {
                    s = tTupleProtocol.readI16();
                    object = tTupleProtocol.readString();
                    fieldData.accHelpValues.put(s, (String)object);
                }
                fieldData.setAccHelpValuesIsSet(true);
            }
            if (bitSet.get(19)) {
                tMap = tTupleProtocol.readMapBegin((byte)6, (byte)11);
                fieldData.accLabelValues = new HashMap<Short, String>(2 * tMap.size);
                for (n = 0; n < tMap.size; ++n) {
                    s = tTupleProtocol.readI16();
                    object = tTupleProtocol.readString();
                    fieldData.accLabelValues.put(s, (String)object);
                }
                fieldData.setAccLabelValuesIsSet(true);
            }
        }
    }

    private static class FieldDataStandardScheme
    extends StandardScheme<FieldData> {
        private FieldDataStandardScheme() {
        }

        public void read(TProtocol tProtocol, FieldData fieldData) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 12) {
                            fieldData.fieldSpec = new FieldSpec();
                            fieldData.fieldSpec.read(tProtocol);
                            fieldData.setFieldSpecIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 12) {
                            fieldData.data = new Data();
                            fieldData.data.read(tProtocol);
                            fieldData.setDataIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 8) {
                            fieldData.dataType = DataType.findByValue(tProtocol.readI32());
                            fieldData.setDataTypeIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 8) {
                            fieldData.fieldAccess = DBAccessLevel.findByValue(tProtocol.readI32());
                            fieldData.setFieldAccessIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 5: {
                        if (tField.type == 8) {
                            fieldData.errorCode = tProtocol.readI32();
                            fieldData.setErrorCodeIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 6: {
                        if (tField.type == 11) {
                            fieldData.errorMessage = tProtocol.readString();
                            fieldData.setErrorMessageIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 7: {
                        Object object;
                        short s;
                        int n;
                        TMap tMap;
                        if (tField.type == 13) {
                            tMap = tProtocol.readMapBegin();
                            fieldData.tooltipValues = new HashMap<Short, String>(2 * tMap.size);
                            for (n = 0; n < tMap.size; ++n) {
                                s = tProtocol.readI16();
                                object = tProtocol.readString();
                                fieldData.tooltipValues.put(s, (String)object);
                            }
                            tProtocol.readMapEnd();
                            fieldData.setTooltipValuesIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 8: {
                        Object object;
                        short s;
                        int n;
                        TMap tMap;
                        if (tField.type == 13) {
                            tMap = tProtocol.readMapBegin();
                            fieldData.conditionalFormattingValues = new HashMap<Short, CFObject>(2 * tMap.size);
                            for (n = 0; n < tMap.size; ++n) {
                                s = tProtocol.readI16();
                                object = new CFObject();
                                ((CFObject)object).read(tProtocol);
                                fieldData.conditionalFormattingValues.put(s, (CFObject)object);
                            }
                            tProtocol.readMapEnd();
                            fieldData.setConditionalFormattingValuesIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 9: {
                        if (tField.type == 2) {
                            fieldData.hideConditionOn = tProtocol.readBool();
                            fieldData.setHideConditionOnIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 10: {
                        Object object;
                        short s;
                        int n;
                        TMap tMap;
                        if (tField.type == 13) {
                            tMap = tProtocol.readMapBegin();
                            fieldData.placeholderTextValues = new HashMap<Short, String>(2 * tMap.size);
                            for (n = 0; n < tMap.size; ++n) {
                                s = tProtocol.readI16();
                                object = tProtocol.readString();
                                fieldData.placeholderTextValues.put(s, (String)object);
                            }
                            tProtocol.readMapEnd();
                            fieldData.setPlaceholderTextValuesIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 11: {
                        if (tField.type == 2) {
                            fieldData.hideZeroesOn = tProtocol.readBool();
                            fieldData.setHideZeroesOnIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 12: {
                        if (tField.type == 2) {
                            fieldData.updateSelection = tProtocol.readBool();
                            fieldData.setUpdateSelectionIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 13: {
                        if (tField.type == 8) {
                            fieldData.selectionStart = tProtocol.readI32();
                            fieldData.setSelectionStartIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 14: {
                        if (tField.type == 8) {
                            fieldData.selectionEnd = tProtocol.readI32();
                            fieldData.setSelectionEndIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 15: {
                        if (tField.type == 2) {
                            fieldData.valueListDataIncluded = tProtocol.readBool();
                            fieldData.setValueListDataIncludedIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 16: {
                        if (tField.type == 12) {
                            fieldData.valueListData = new ValueListData();
                            fieldData.valueListData.read(tProtocol);
                            fieldData.setValueListDataIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 17: {
                        if (tField.type == 2) {
                            fieldData.streamOn = tProtocol.readBool();
                            fieldData.setStreamOnIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 18: {
                        Object object;
                        short s;
                        int n;
                        TMap tMap;
                        if (tField.type == 13) {
                            tMap = tProtocol.readMapBegin();
                            fieldData.accTitleValues = new HashMap<Short, String>(2 * tMap.size);
                            for (n = 0; n < tMap.size; ++n) {
                                s = tProtocol.readI16();
                                object = tProtocol.readString();
                                fieldData.accTitleValues.put(s, (String)object);
                            }
                            tProtocol.readMapEnd();
                            fieldData.setAccTitleValuesIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 19: {
                        Object object;
                        short s;
                        int n;
                        TMap tMap;
                        if (tField.type == 13) {
                            tMap = tProtocol.readMapBegin();
                            fieldData.accHelpValues = new HashMap<Short, String>(2 * tMap.size);
                            for (n = 0; n < tMap.size; ++n) {
                                s = tProtocol.readI16();
                                object = tProtocol.readString();
                                fieldData.accHelpValues.put(s, (String)object);
                            }
                            tProtocol.readMapEnd();
                            fieldData.setAccHelpValuesIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 20: {
                        Object object;
                        short s;
                        int n;
                        TMap tMap;
                        if (tField.type == 13) {
                            tMap = tProtocol.readMapBegin();
                            fieldData.accLabelValues = new HashMap<Short, String>(2 * tMap.size);
                            for (n = 0; n < tMap.size; ++n) {
                                s = tProtocol.readI16();
                                object = tProtocol.readString();
                                fieldData.accLabelValues.put(s, (String)object);
                            }
                            tProtocol.readMapEnd();
                            fieldData.setAccLabelValuesIsSet(true);
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
            fieldData.validate();
        }

        public void write(TProtocol tProtocol, FieldData fieldData) throws TException {
            fieldData.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (fieldData.fieldSpec != null) {
                tProtocol.writeFieldBegin(FIELD_SPEC_FIELD_DESC);
                fieldData.fieldSpec.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            if (fieldData.data != null) {
                tProtocol.writeFieldBegin(DATA_FIELD_DESC);
                fieldData.data.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            if (fieldData.dataType != null) {
                tProtocol.writeFieldBegin(DATA_TYPE_FIELD_DESC);
                tProtocol.writeI32(fieldData.dataType.getValue());
                tProtocol.writeFieldEnd();
            }
            if (fieldData.fieldAccess != null) {
                tProtocol.writeFieldBegin(FIELD_ACCESS_FIELD_DESC);
                tProtocol.writeI32(fieldData.fieldAccess.getValue());
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(ERROR_CODE_FIELD_DESC);
            tProtocol.writeI32(fieldData.errorCode);
            tProtocol.writeFieldEnd();
            if (fieldData.errorMessage != null) {
                tProtocol.writeFieldBegin(ERROR_MESSAGE_FIELD_DESC);
                tProtocol.writeString(fieldData.errorMessage);
                tProtocol.writeFieldEnd();
            }
            if (fieldData.tooltipValues != null) {
                tProtocol.writeFieldBegin(TOOLTIP_VALUES_FIELD_DESC);
                tProtocol.writeMapBegin(new TMap(6, 11, fieldData.tooltipValues.size()));
                for (Map.Entry<Short, Object> entry : fieldData.tooltipValues.entrySet()) {
                    tProtocol.writeI16(entry.getKey().shortValue());
                    tProtocol.writeString((String)entry.getValue());
                }
                tProtocol.writeMapEnd();
                tProtocol.writeFieldEnd();
            }
            if (fieldData.conditionalFormattingValues != null) {
                tProtocol.writeFieldBegin(CONDITIONAL_FORMATTING_VALUES_FIELD_DESC);
                tProtocol.writeMapBegin(new TMap(6, 12, fieldData.conditionalFormattingValues.size()));
                for (Map.Entry<Short, Object> entry : fieldData.conditionalFormattingValues.entrySet()) {
                    tProtocol.writeI16(entry.getKey().shortValue());
                    ((CFObject)entry.getValue()).write(tProtocol);
                }
                tProtocol.writeMapEnd();
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(HIDE_CONDITION_ON_FIELD_DESC);
            tProtocol.writeBool(fieldData.hideConditionOn);
            tProtocol.writeFieldEnd();
            if (fieldData.placeholderTextValues != null) {
                tProtocol.writeFieldBegin(PLACEHOLDER_TEXT_VALUES_FIELD_DESC);
                tProtocol.writeMapBegin(new TMap(6, 11, fieldData.placeholderTextValues.size()));
                for (Map.Entry<Short, Object> entry : fieldData.placeholderTextValues.entrySet()) {
                    tProtocol.writeI16(entry.getKey().shortValue());
                    tProtocol.writeString((String)entry.getValue());
                }
                tProtocol.writeMapEnd();
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(HIDE_ZEROES_ON_FIELD_DESC);
            tProtocol.writeBool(fieldData.hideZeroesOn);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(UPDATE_SELECTION_FIELD_DESC);
            tProtocol.writeBool(fieldData.updateSelection);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(SELECTION_START_FIELD_DESC);
            tProtocol.writeI32(fieldData.selectionStart);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(SELECTION_END_FIELD_DESC);
            tProtocol.writeI32(fieldData.selectionEnd);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(VALUE_LIST_DATA_INCLUDED_FIELD_DESC);
            tProtocol.writeBool(fieldData.valueListDataIncluded);
            tProtocol.writeFieldEnd();
            if (fieldData.valueListData != null) {
                tProtocol.writeFieldBegin(VALUE_LIST_DATA_FIELD_DESC);
                fieldData.valueListData.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(STREAM_ON_FIELD_DESC);
            tProtocol.writeBool(fieldData.streamOn);
            tProtocol.writeFieldEnd();
            if (fieldData.accTitleValues != null) {
                tProtocol.writeFieldBegin(ACC_TITLE_VALUES_FIELD_DESC);
                tProtocol.writeMapBegin(new TMap(6, 11, fieldData.accTitleValues.size()));
                for (Map.Entry<Short, Object> entry : fieldData.accTitleValues.entrySet()) {
                    tProtocol.writeI16(entry.getKey().shortValue());
                    tProtocol.writeString((String)entry.getValue());
                }
                tProtocol.writeMapEnd();
                tProtocol.writeFieldEnd();
            }
            if (fieldData.accHelpValues != null) {
                tProtocol.writeFieldBegin(ACC_HELP_VALUES_FIELD_DESC);
                tProtocol.writeMapBegin(new TMap(6, 11, fieldData.accHelpValues.size()));
                for (Map.Entry<Short, Object> entry : fieldData.accHelpValues.entrySet()) {
                    tProtocol.writeI16(entry.getKey().shortValue());
                    tProtocol.writeString((String)entry.getValue());
                }
                tProtocol.writeMapEnd();
                tProtocol.writeFieldEnd();
            }
            if (fieldData.accLabelValues != null) {
                tProtocol.writeFieldBegin(ACC_LABEL_VALUES_FIELD_DESC);
                tProtocol.writeMapBegin(new TMap(6, 11, fieldData.accLabelValues.size()));
                for (Map.Entry<Short, Object> entry : fieldData.accLabelValues.entrySet()) {
                    tProtocol.writeI16(entry.getKey().shortValue());
                    tProtocol.writeString((String)entry.getValue());
                }
                tProtocol.writeMapEnd();
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

