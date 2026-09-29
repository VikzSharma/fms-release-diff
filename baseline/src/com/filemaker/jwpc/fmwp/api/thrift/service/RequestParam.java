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
 *  org.apache.thrift.meta_data.ListMetaData
 *  org.apache.thrift.meta_data.StructMetaData
 *  org.apache.thrift.protocol.TCompactProtocol
 *  org.apache.thrift.protocol.TField
 *  org.apache.thrift.protocol.TList
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
package com.filemaker.jwpc.fmwp.api.thrift.service;

import com.filemaker.jwpc.fmwp.api.thrift.service.BasicParam;
import com.filemaker.jwpc.fmwp.api.thrift.service.IDLComplexParam;
import com.filemaker.jwpc.fmwp.api.thrift.service.IDLFieldsParam;
import com.filemaker.jwpc.fmwp.api.thrift.service.NVPair;
import com.filemaker.jwpc.fmwp.api.thrift.service.PortalFilterType;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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
import org.apache.thrift.meta_data.ListMetaData;
import org.apache.thrift.meta_data.StructMetaData;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TList;
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

public class RequestParam
implements TBase<RequestParam, _Fields>,
Serializable,
Cloneable,
Comparable<RequestParam> {
    private static final TStruct STRUCT_DESC = new TStruct("RequestParam");
    private static final TField CMD_CODE_FIELD_DESC = new TField("cmdCode", 8, 1);
    private static final TField PARAM_FIELD_DESC = new TField("param", 12, 2);
    private static final TField OPTIONS_FIELD_DESC = new TField("options", 8, 3);
    private static final TField PRE_SCRIPT_FIELD_DESC = new TField("preScript", 12, 4);
    private static final TField PRE_SORT_SCRIPT_FIELD_DESC = new TField("preSortScript", 12, 5);
    private static final TField POST_SCRIPT_FIELD_DESC = new TField("postScript", 12, 6);
    private static final TField SORT_PARAMS_FIELD_DESC = new TField("sortParams", 15, 7);
    private static final TField RESPONSE_LAYOUT_NAME_FIELD_DESC = new TField("responseLayoutName", 11, 8);
    private static final TField PORTAL_FILTER_FIELD_DESC = new TField("portalFilter", 8, 9);
    private static final TField PORTAL_MAX_FIELD_DESC = new TField("portalMax", 10, 10);
    private static final TField DELETE_RELATED_FIELD_DESC = new TField("deleteRelated", 15, 11);
    private static final TField FIELDS_FIELD_DESC = new TField("fields", 15, 12);
    private static final TField GLOBAL_FIELDS_FIELD_DESC = new TField("globalFields", 12, 13);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new RequestParamStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new RequestParamTupleSchemeFactory();
    private int cmdCode;
    @Nullable
    private BasicParam param;
    private int options;
    @Nullable
    private NVPair preScript;
    @Nullable
    private NVPair preSortScript;
    @Nullable
    private NVPair postScript;
    @Nullable
    private List<IDLComplexParam> sortParams;
    @Nullable
    private String responseLayoutName;
    @Nullable
    private PortalFilterType portalFilter;
    private long portalMax;
    @Nullable
    private List<NVPair> deleteRelated;
    @Nullable
    private List<IDLFieldsParam> fields;
    @Nullable
    private IDLFieldsParam globalFields;
    private static final int __CMDCODE_ISSET_ID = 0;
    private static final int __OPTIONS_ISSET_ID = 1;
    private static final int __PORTALMAX_ISSET_ID = 2;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public RequestParam() {
    }

    public RequestParam(int n, BasicParam basicParam, int n2, NVPair nVPair, NVPair nVPair2, NVPair nVPair3, List<IDLComplexParam> list, String string, PortalFilterType portalFilterType, long l, List<NVPair> list2, List<IDLFieldsParam> list3, IDLFieldsParam iDLFieldsParam) {
        this();
        this.cmdCode = n;
        this.setCmdCodeIsSet(true);
        this.param = basicParam;
        this.options = n2;
        this.setOptionsIsSet(true);
        this.preScript = nVPair;
        this.preSortScript = nVPair2;
        this.postScript = nVPair3;
        this.sortParams = list;
        this.responseLayoutName = string;
        this.portalFilter = portalFilterType;
        this.portalMax = l;
        this.setPortalMaxIsSet(true);
        this.deleteRelated = list2;
        this.fields = list3;
        this.globalFields = iDLFieldsParam;
    }

    public RequestParam(RequestParam requestParam) {
        ArrayList<IDLComplexParam> arrayList;
        this.__isset_bitfield = requestParam.__isset_bitfield;
        this.cmdCode = requestParam.cmdCode;
        if (requestParam.isSetParam()) {
            this.param = new BasicParam(requestParam.param);
        }
        this.options = requestParam.options;
        if (requestParam.isSetPreScript()) {
            this.preScript = new NVPair(requestParam.preScript);
        }
        if (requestParam.isSetPreSortScript()) {
            this.preSortScript = new NVPair(requestParam.preSortScript);
        }
        if (requestParam.isSetPostScript()) {
            this.postScript = new NVPair(requestParam.postScript);
        }
        if (requestParam.isSetSortParams()) {
            arrayList = new ArrayList<IDLComplexParam>(requestParam.sortParams.size());
            for (IDLComplexParam comparable : requestParam.sortParams) {
                arrayList.add(new IDLComplexParam(comparable));
            }
            this.sortParams = arrayList;
        }
        if (requestParam.isSetResponseLayoutName()) {
            this.responseLayoutName = requestParam.responseLayoutName;
        }
        if (requestParam.isSetPortalFilter()) {
            this.portalFilter = requestParam.portalFilter;
        }
        this.portalMax = requestParam.portalMax;
        if (requestParam.isSetDeleteRelated()) {
            arrayList = new ArrayList(requestParam.deleteRelated.size());
            for (NVPair nVPair : requestParam.deleteRelated) {
                arrayList.add((IDLComplexParam)((Object)new NVPair(nVPair)));
            }
            this.deleteRelated = arrayList;
        }
        if (requestParam.isSetFields()) {
            arrayList = new ArrayList(requestParam.fields.size());
            for (IDLFieldsParam iDLFieldsParam : requestParam.fields) {
                arrayList.add((IDLComplexParam)((Object)new IDLFieldsParam(iDLFieldsParam)));
            }
            this.fields = arrayList;
        }
        if (requestParam.isSetGlobalFields()) {
            this.globalFields = new IDLFieldsParam(requestParam.globalFields);
        }
    }

    public RequestParam deepCopy() {
        return new RequestParam(this);
    }

    public void clear() {
        this.setCmdCodeIsSet(false);
        this.cmdCode = 0;
        this.param = null;
        this.setOptionsIsSet(false);
        this.options = 0;
        this.preScript = null;
        this.preSortScript = null;
        this.postScript = null;
        this.sortParams = null;
        this.responseLayoutName = null;
        this.portalFilter = null;
        this.setPortalMaxIsSet(false);
        this.portalMax = 0L;
        this.deleteRelated = null;
        this.fields = null;
        this.globalFields = null;
    }

    public int getCmdCode() {
        return this.cmdCode;
    }

    public void setCmdCode(int n) {
        this.cmdCode = n;
        this.setCmdCodeIsSet(true);
    }

    public void unsetCmdCode() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetCmdCode() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setCmdCodeIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    @Nullable
    public BasicParam getParam() {
        return this.param;
    }

    public void setParam(@Nullable BasicParam basicParam) {
        this.param = basicParam;
    }

    public void unsetParam() {
        this.param = null;
    }

    public boolean isSetParam() {
        return this.param != null;
    }

    public void setParamIsSet(boolean bl) {
        if (!bl) {
            this.param = null;
        }
    }

    public int getOptions() {
        return this.options;
    }

    public void setOptions(int n) {
        this.options = n;
        this.setOptionsIsSet(true);
    }

    public void unsetOptions() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)1);
    }

    public boolean isSetOptions() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)1);
    }

    public void setOptionsIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)1, (boolean)bl);
    }

    @Nullable
    public NVPair getPreScript() {
        return this.preScript;
    }

    public void setPreScript(@Nullable NVPair nVPair) {
        this.preScript = nVPair;
    }

    public void unsetPreScript() {
        this.preScript = null;
    }

    public boolean isSetPreScript() {
        return this.preScript != null;
    }

    public void setPreScriptIsSet(boolean bl) {
        if (!bl) {
            this.preScript = null;
        }
    }

    @Nullable
    public NVPair getPreSortScript() {
        return this.preSortScript;
    }

    public void setPreSortScript(@Nullable NVPair nVPair) {
        this.preSortScript = nVPair;
    }

    public void unsetPreSortScript() {
        this.preSortScript = null;
    }

    public boolean isSetPreSortScript() {
        return this.preSortScript != null;
    }

    public void setPreSortScriptIsSet(boolean bl) {
        if (!bl) {
            this.preSortScript = null;
        }
    }

    @Nullable
    public NVPair getPostScript() {
        return this.postScript;
    }

    public void setPostScript(@Nullable NVPair nVPair) {
        this.postScript = nVPair;
    }

    public void unsetPostScript() {
        this.postScript = null;
    }

    public boolean isSetPostScript() {
        return this.postScript != null;
    }

    public void setPostScriptIsSet(boolean bl) {
        if (!bl) {
            this.postScript = null;
        }
    }

    public int getSortParamsSize() {
        return this.sortParams == null ? 0 : this.sortParams.size();
    }

    @Nullable
    public Iterator<IDLComplexParam> getSortParamsIterator() {
        return this.sortParams == null ? null : this.sortParams.iterator();
    }

    public void addToSortParams(IDLComplexParam iDLComplexParam) {
        if (this.sortParams == null) {
            this.sortParams = new ArrayList<IDLComplexParam>();
        }
        this.sortParams.add(iDLComplexParam);
    }

    @Nullable
    public List<IDLComplexParam> getSortParams() {
        return this.sortParams;
    }

    public void setSortParams(@Nullable List<IDLComplexParam> list) {
        this.sortParams = list;
    }

    public void unsetSortParams() {
        this.sortParams = null;
    }

    public boolean isSetSortParams() {
        return this.sortParams != null;
    }

    public void setSortParamsIsSet(boolean bl) {
        if (!bl) {
            this.sortParams = null;
        }
    }

    @Nullable
    public String getResponseLayoutName() {
        return this.responseLayoutName;
    }

    public void setResponseLayoutName(@Nullable String string) {
        this.responseLayoutName = string;
    }

    public void unsetResponseLayoutName() {
        this.responseLayoutName = null;
    }

    public boolean isSetResponseLayoutName() {
        return this.responseLayoutName != null;
    }

    public void setResponseLayoutNameIsSet(boolean bl) {
        if (!bl) {
            this.responseLayoutName = null;
        }
    }

    @Nullable
    public PortalFilterType getPortalFilter() {
        return this.portalFilter;
    }

    public void setPortalFilter(@Nullable PortalFilterType portalFilterType) {
        this.portalFilter = portalFilterType;
    }

    public void unsetPortalFilter() {
        this.portalFilter = null;
    }

    public boolean isSetPortalFilter() {
        return this.portalFilter != null;
    }

    public void setPortalFilterIsSet(boolean bl) {
        if (!bl) {
            this.portalFilter = null;
        }
    }

    public long getPortalMax() {
        return this.portalMax;
    }

    public void setPortalMax(long l) {
        this.portalMax = l;
        this.setPortalMaxIsSet(true);
    }

    public void unsetPortalMax() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)2);
    }

    public boolean isSetPortalMax() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)2);
    }

    public void setPortalMaxIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)2, (boolean)bl);
    }

    public int getDeleteRelatedSize() {
        return this.deleteRelated == null ? 0 : this.deleteRelated.size();
    }

    @Nullable
    public Iterator<NVPair> getDeleteRelatedIterator() {
        return this.deleteRelated == null ? null : this.deleteRelated.iterator();
    }

    public void addToDeleteRelated(NVPair nVPair) {
        if (this.deleteRelated == null) {
            this.deleteRelated = new ArrayList<NVPair>();
        }
        this.deleteRelated.add(nVPair);
    }

    @Nullable
    public List<NVPair> getDeleteRelated() {
        return this.deleteRelated;
    }

    public void setDeleteRelated(@Nullable List<NVPair> list) {
        this.deleteRelated = list;
    }

    public void unsetDeleteRelated() {
        this.deleteRelated = null;
    }

    public boolean isSetDeleteRelated() {
        return this.deleteRelated != null;
    }

    public void setDeleteRelatedIsSet(boolean bl) {
        if (!bl) {
            this.deleteRelated = null;
        }
    }

    public int getFieldsSize() {
        return this.fields == null ? 0 : this.fields.size();
    }

    @Nullable
    public Iterator<IDLFieldsParam> getFieldsIterator() {
        return this.fields == null ? null : this.fields.iterator();
    }

    public void addToFields(IDLFieldsParam iDLFieldsParam) {
        if (this.fields == null) {
            this.fields = new ArrayList<IDLFieldsParam>();
        }
        this.fields.add(iDLFieldsParam);
    }

    @Nullable
    public List<IDLFieldsParam> getFields() {
        return this.fields;
    }

    public void setFields(@Nullable List<IDLFieldsParam> list) {
        this.fields = list;
    }

    public void unsetFields() {
        this.fields = null;
    }

    public boolean isSetFields() {
        return this.fields != null;
    }

    public void setFieldsIsSet(boolean bl) {
        if (!bl) {
            this.fields = null;
        }
    }

    @Nullable
    public IDLFieldsParam getGlobalFields() {
        return this.globalFields;
    }

    public void setGlobalFields(@Nullable IDLFieldsParam iDLFieldsParam) {
        this.globalFields = iDLFieldsParam;
    }

    public void unsetGlobalFields() {
        this.globalFields = null;
    }

    public boolean isSetGlobalFields() {
        return this.globalFields != null;
    }

    public void setGlobalFieldsIsSet(boolean bl) {
        if (!bl) {
            this.globalFields = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetCmdCode();
                    break;
                }
                this.setCmdCode((Integer)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetParam();
                    break;
                }
                this.setParam((BasicParam)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetOptions();
                    break;
                }
                this.setOptions((Integer)object);
                break;
            }
            case 3: {
                if (object == null) {
                    this.unsetPreScript();
                    break;
                }
                this.setPreScript((NVPair)object);
                break;
            }
            case 4: {
                if (object == null) {
                    this.unsetPreSortScript();
                    break;
                }
                this.setPreSortScript((NVPair)object);
                break;
            }
            case 5: {
                if (object == null) {
                    this.unsetPostScript();
                    break;
                }
                this.setPostScript((NVPair)object);
                break;
            }
            case 6: {
                if (object == null) {
                    this.unsetSortParams();
                    break;
                }
                this.setSortParams((List)object);
                break;
            }
            case 7: {
                if (object == null) {
                    this.unsetResponseLayoutName();
                    break;
                }
                this.setResponseLayoutName((String)object);
                break;
            }
            case 8: {
                if (object == null) {
                    this.unsetPortalFilter();
                    break;
                }
                this.setPortalFilter((PortalFilterType)((Object)object));
                break;
            }
            case 9: {
                if (object == null) {
                    this.unsetPortalMax();
                    break;
                }
                this.setPortalMax((Long)object);
                break;
            }
            case 10: {
                if (object == null) {
                    this.unsetDeleteRelated();
                    break;
                }
                this.setDeleteRelated((List)object);
                break;
            }
            case 11: {
                if (object == null) {
                    this.unsetFields();
                    break;
                }
                this.setFields((List)object);
                break;
            }
            case 12: {
                if (object == null) {
                    this.unsetGlobalFields();
                    break;
                }
                this.setGlobalFields((IDLFieldsParam)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getCmdCode();
            }
            case 1: {
                return this.getParam();
            }
            case 2: {
                return this.getOptions();
            }
            case 3: {
                return this.getPreScript();
            }
            case 4: {
                return this.getPreSortScript();
            }
            case 5: {
                return this.getPostScript();
            }
            case 6: {
                return this.getSortParams();
            }
            case 7: {
                return this.getResponseLayoutName();
            }
            case 8: {
                return this.getPortalFilter();
            }
            case 9: {
                return this.getPortalMax();
            }
            case 10: {
                return this.getDeleteRelated();
            }
            case 11: {
                return this.getFields();
            }
            case 12: {
                return this.getGlobalFields();
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
                return this.isSetCmdCode();
            }
            case 1: {
                return this.isSetParam();
            }
            case 2: {
                return this.isSetOptions();
            }
            case 3: {
                return this.isSetPreScript();
            }
            case 4: {
                return this.isSetPreSortScript();
            }
            case 5: {
                return this.isSetPostScript();
            }
            case 6: {
                return this.isSetSortParams();
            }
            case 7: {
                return this.isSetResponseLayoutName();
            }
            case 8: {
                return this.isSetPortalFilter();
            }
            case 9: {
                return this.isSetPortalMax();
            }
            case 10: {
                return this.isSetDeleteRelated();
            }
            case 11: {
                return this.isSetFields();
            }
            case 12: {
                return this.isSetGlobalFields();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof RequestParam) {
            return this.equals((RequestParam)object);
        }
        return false;
    }

    public boolean equals(RequestParam requestParam) {
        if (requestParam == null) {
            return false;
        }
        if (this == requestParam) {
            return true;
        }
        boolean bl = true;
        boolean bl2 = true;
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (this.cmdCode != requestParam.cmdCode) {
                return false;
            }
        }
        boolean bl3 = this.isSetParam();
        boolean bl4 = requestParam.isSetParam();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.param.equals(requestParam.param)) {
                return false;
            }
        }
        boolean bl5 = true;
        boolean bl6 = true;
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (this.options != requestParam.options) {
                return false;
            }
        }
        boolean bl7 = this.isSetPreScript();
        boolean bl8 = requestParam.isSetPreScript();
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (!this.preScript.equals(requestParam.preScript)) {
                return false;
            }
        }
        boolean bl9 = this.isSetPreSortScript();
        boolean bl10 = requestParam.isSetPreSortScript();
        if (bl9 || bl10) {
            if (!bl9 || !bl10) {
                return false;
            }
            if (!this.preSortScript.equals(requestParam.preSortScript)) {
                return false;
            }
        }
        boolean bl11 = this.isSetPostScript();
        boolean bl12 = requestParam.isSetPostScript();
        if (bl11 || bl12) {
            if (!bl11 || !bl12) {
                return false;
            }
            if (!this.postScript.equals(requestParam.postScript)) {
                return false;
            }
        }
        boolean bl13 = this.isSetSortParams();
        boolean bl14 = requestParam.isSetSortParams();
        if (bl13 || bl14) {
            if (!bl13 || !bl14) {
                return false;
            }
            if (!this.sortParams.equals(requestParam.sortParams)) {
                return false;
            }
        }
        boolean bl15 = this.isSetResponseLayoutName();
        boolean bl16 = requestParam.isSetResponseLayoutName();
        if (bl15 || bl16) {
            if (!bl15 || !bl16) {
                return false;
            }
            if (!this.responseLayoutName.equals(requestParam.responseLayoutName)) {
                return false;
            }
        }
        boolean bl17 = this.isSetPortalFilter();
        boolean bl18 = requestParam.isSetPortalFilter();
        if (bl17 || bl18) {
            if (!bl17 || !bl18) {
                return false;
            }
            if (!this.portalFilter.equals((Object)requestParam.portalFilter)) {
                return false;
            }
        }
        boolean bl19 = true;
        boolean bl20 = true;
        if (bl19 || bl20) {
            if (!bl19 || !bl20) {
                return false;
            }
            if (this.portalMax != requestParam.portalMax) {
                return false;
            }
        }
        boolean bl21 = this.isSetDeleteRelated();
        boolean bl22 = requestParam.isSetDeleteRelated();
        if (bl21 || bl22) {
            if (!bl21 || !bl22) {
                return false;
            }
            if (!this.deleteRelated.equals(requestParam.deleteRelated)) {
                return false;
            }
        }
        boolean bl23 = this.isSetFields();
        boolean bl24 = requestParam.isSetFields();
        if (bl23 || bl24) {
            if (!bl23 || !bl24) {
                return false;
            }
            if (!this.fields.equals(requestParam.fields)) {
                return false;
            }
        }
        boolean bl25 = this.isSetGlobalFields();
        boolean bl26 = requestParam.isSetGlobalFields();
        if (bl25 || bl26) {
            if (!bl25 || !bl26) {
                return false;
            }
            if (!this.globalFields.equals(requestParam.globalFields)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + this.cmdCode;
        n = n * 8191 + (this.isSetParam() ? 131071 : 524287);
        if (this.isSetParam()) {
            n = n * 8191 + this.param.hashCode();
        }
        n = n * 8191 + this.options;
        n = n * 8191 + (this.isSetPreScript() ? 131071 : 524287);
        if (this.isSetPreScript()) {
            n = n * 8191 + this.preScript.hashCode();
        }
        n = n * 8191 + (this.isSetPreSortScript() ? 131071 : 524287);
        if (this.isSetPreSortScript()) {
            n = n * 8191 + this.preSortScript.hashCode();
        }
        n = n * 8191 + (this.isSetPostScript() ? 131071 : 524287);
        if (this.isSetPostScript()) {
            n = n * 8191 + this.postScript.hashCode();
        }
        n = n * 8191 + (this.isSetSortParams() ? 131071 : 524287);
        if (this.isSetSortParams()) {
            n = n * 8191 + this.sortParams.hashCode();
        }
        n = n * 8191 + (this.isSetResponseLayoutName() ? 131071 : 524287);
        if (this.isSetResponseLayoutName()) {
            n = n * 8191 + this.responseLayoutName.hashCode();
        }
        n = n * 8191 + (this.isSetPortalFilter() ? 131071 : 524287);
        if (this.isSetPortalFilter()) {
            n = n * 8191 + this.portalFilter.getValue();
        }
        n = n * 8191 + TBaseHelper.hashCode((long)this.portalMax);
        n = n * 8191 + (this.isSetDeleteRelated() ? 131071 : 524287);
        if (this.isSetDeleteRelated()) {
            n = n * 8191 + this.deleteRelated.hashCode();
        }
        n = n * 8191 + (this.isSetFields() ? 131071 : 524287);
        if (this.isSetFields()) {
            n = n * 8191 + this.fields.hashCode();
        }
        n = n * 8191 + (this.isSetGlobalFields() ? 131071 : 524287);
        if (this.isSetGlobalFields()) {
            n = n * 8191 + this.globalFields.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(RequestParam requestParam) {
        if (!this.getClass().equals(requestParam.getClass())) {
            return this.getClass().getName().compareTo(requestParam.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetCmdCode(), requestParam.isSetCmdCode());
        if (n != 0) {
            return n;
        }
        if (this.isSetCmdCode() && (n = TBaseHelper.compareTo((int)this.cmdCode, (int)requestParam.cmdCode)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetParam(), requestParam.isSetParam());
        if (n != 0) {
            return n;
        }
        if (this.isSetParam() && (n = TBaseHelper.compareTo((Comparable)this.param, (Comparable)requestParam.param)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetOptions(), requestParam.isSetOptions());
        if (n != 0) {
            return n;
        }
        if (this.isSetOptions() && (n = TBaseHelper.compareTo((int)this.options, (int)requestParam.options)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetPreScript(), requestParam.isSetPreScript());
        if (n != 0) {
            return n;
        }
        if (this.isSetPreScript() && (n = TBaseHelper.compareTo((Comparable)this.preScript, (Comparable)requestParam.preScript)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetPreSortScript(), requestParam.isSetPreSortScript());
        if (n != 0) {
            return n;
        }
        if (this.isSetPreSortScript() && (n = TBaseHelper.compareTo((Comparable)this.preSortScript, (Comparable)requestParam.preSortScript)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetPostScript(), requestParam.isSetPostScript());
        if (n != 0) {
            return n;
        }
        if (this.isSetPostScript() && (n = TBaseHelper.compareTo((Comparable)this.postScript, (Comparable)requestParam.postScript)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetSortParams(), requestParam.isSetSortParams());
        if (n != 0) {
            return n;
        }
        if (this.isSetSortParams() && (n = TBaseHelper.compareTo(this.sortParams, requestParam.sortParams)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetResponseLayoutName(), requestParam.isSetResponseLayoutName());
        if (n != 0) {
            return n;
        }
        if (this.isSetResponseLayoutName() && (n = TBaseHelper.compareTo((String)this.responseLayoutName, (String)requestParam.responseLayoutName)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetPortalFilter(), requestParam.isSetPortalFilter());
        if (n != 0) {
            return n;
        }
        if (this.isSetPortalFilter() && (n = TBaseHelper.compareTo((Comparable)((Object)this.portalFilter), (Comparable)((Object)requestParam.portalFilter))) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetPortalMax(), requestParam.isSetPortalMax());
        if (n != 0) {
            return n;
        }
        if (this.isSetPortalMax() && (n = TBaseHelper.compareTo((long)this.portalMax, (long)requestParam.portalMax)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetDeleteRelated(), requestParam.isSetDeleteRelated());
        if (n != 0) {
            return n;
        }
        if (this.isSetDeleteRelated() && (n = TBaseHelper.compareTo(this.deleteRelated, requestParam.deleteRelated)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetFields(), requestParam.isSetFields());
        if (n != 0) {
            return n;
        }
        if (this.isSetFields() && (n = TBaseHelper.compareTo(this.fields, requestParam.fields)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetGlobalFields(), requestParam.isSetGlobalFields());
        if (n != 0) {
            return n;
        }
        if (this.isSetGlobalFields() && (n = TBaseHelper.compareTo((Comparable)this.globalFields, (Comparable)requestParam.globalFields)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        RequestParam.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        RequestParam.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("RequestParam(");
        boolean bl = true;
        stringBuilder.append("cmdCode:");
        stringBuilder.append(this.cmdCode);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("param:");
        if (this.param == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.param);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("options:");
        stringBuilder.append(this.options);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("preScript:");
        if (this.preScript == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.preScript);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("preSortScript:");
        if (this.preSortScript == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.preSortScript);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("postScript:");
        if (this.postScript == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.postScript);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("sortParams:");
        if (this.sortParams == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.sortParams);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("responseLayoutName:");
        if (this.responseLayoutName == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.responseLayoutName);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("portalFilter:");
        if (this.portalFilter == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append((Object)this.portalFilter);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("portalMax:");
        stringBuilder.append(this.portalMax);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("deleteRelated:");
        if (this.deleteRelated == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.deleteRelated);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("fields:");
        if (this.fields == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.fields);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("globalFields:");
        if (this.globalFields == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.globalFields);
        }
        bl = false;
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void validate() throws TException {
        if (this.param != null) {
            this.param.validate();
        }
        if (this.preScript != null) {
            this.preScript.validate();
        }
        if (this.preSortScript != null) {
            this.preSortScript.validate();
        }
        if (this.postScript != null) {
            this.postScript.validate();
        }
        if (this.globalFields != null) {
            this.globalFields.validate();
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
        enumMap.put(_Fields.CMD_CODE, new FieldMetaData("cmdCode", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.PARAM, new FieldMetaData("param", 3, (FieldValueMetaData)new StructMetaData(12, BasicParam.class)));
        enumMap.put(_Fields.OPTIONS, new FieldMetaData("options", 3, new FieldValueMetaData(8, "Bitmap")));
        enumMap.put(_Fields.PRE_SCRIPT, new FieldMetaData("preScript", 3, (FieldValueMetaData)new StructMetaData(12, NVPair.class)));
        enumMap.put(_Fields.PRE_SORT_SCRIPT, new FieldMetaData("preSortScript", 3, (FieldValueMetaData)new StructMetaData(12, NVPair.class)));
        enumMap.put(_Fields.POST_SCRIPT, new FieldMetaData("postScript", 3, (FieldValueMetaData)new StructMetaData(12, NVPair.class)));
        enumMap.put(_Fields.SORT_PARAMS, new FieldMetaData("sortParams", 3, (FieldValueMetaData)new ListMetaData(15, (FieldValueMetaData)new StructMetaData(12, IDLComplexParam.class))));
        enumMap.put(_Fields.RESPONSE_LAYOUT_NAME, new FieldMetaData("responseLayoutName", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.PORTAL_FILTER, new FieldMetaData("portalFilter", 3, (FieldValueMetaData)new EnumMetaData(-1, PortalFilterType.class)));
        enumMap.put(_Fields.PORTAL_MAX, new FieldMetaData("portalMax", 3, new FieldValueMetaData(10)));
        enumMap.put(_Fields.DELETE_RELATED, new FieldMetaData("deleteRelated", 3, (FieldValueMetaData)new ListMetaData(15, (FieldValueMetaData)new StructMetaData(12, NVPair.class))));
        enumMap.put(_Fields.FIELDS, new FieldMetaData("fields", 3, (FieldValueMetaData)new ListMetaData(15, (FieldValueMetaData)new StructMetaData(12, IDLFieldsParam.class))));
        enumMap.put(_Fields.GLOBAL_FIELDS, new FieldMetaData("globalFields", 3, (FieldValueMetaData)new StructMetaData(12, IDLFieldsParam.class)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(RequestParam.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        CMD_CODE(1, "cmdCode"),
        PARAM(2, "param"),
        OPTIONS(3, "options"),
        PRE_SCRIPT(4, "preScript"),
        PRE_SORT_SCRIPT(5, "preSortScript"),
        POST_SCRIPT(6, "postScript"),
        SORT_PARAMS(7, "sortParams"),
        RESPONSE_LAYOUT_NAME(8, "responseLayoutName"),
        PORTAL_FILTER(9, "portalFilter"),
        PORTAL_MAX(10, "portalMax"),
        DELETE_RELATED(11, "deleteRelated"),
        FIELDS(12, "fields"),
        GLOBAL_FIELDS(13, "globalFields");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return CMD_CODE;
                }
                case 2: {
                    return PARAM;
                }
                case 3: {
                    return OPTIONS;
                }
                case 4: {
                    return PRE_SCRIPT;
                }
                case 5: {
                    return PRE_SORT_SCRIPT;
                }
                case 6: {
                    return POST_SCRIPT;
                }
                case 7: {
                    return SORT_PARAMS;
                }
                case 8: {
                    return RESPONSE_LAYOUT_NAME;
                }
                case 9: {
                    return PORTAL_FILTER;
                }
                case 10: {
                    return PORTAL_MAX;
                }
                case 11: {
                    return DELETE_RELATED;
                }
                case 12: {
                    return FIELDS;
                }
                case 13: {
                    return GLOBAL_FIELDS;
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

    private static class RequestParamStandardSchemeFactory
    implements SchemeFactory {
        private RequestParamStandardSchemeFactory() {
        }

        public RequestParamStandardScheme getScheme() {
            return new RequestParamStandardScheme();
        }
    }

    private static class RequestParamTupleSchemeFactory
    implements SchemeFactory {
        private RequestParamTupleSchemeFactory() {
        }

        public RequestParamTupleScheme getScheme() {
            return new RequestParamTupleScheme();
        }
    }

    private static class RequestParamTupleScheme
    extends TupleScheme<RequestParam> {
        private RequestParamTupleScheme() {
        }

        public void write(TProtocol tProtocol, RequestParam requestParam) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (requestParam.isSetCmdCode()) {
                bitSet.set(0);
            }
            if (requestParam.isSetParam()) {
                bitSet.set(1);
            }
            if (requestParam.isSetOptions()) {
                bitSet.set(2);
            }
            if (requestParam.isSetPreScript()) {
                bitSet.set(3);
            }
            if (requestParam.isSetPreSortScript()) {
                bitSet.set(4);
            }
            if (requestParam.isSetPostScript()) {
                bitSet.set(5);
            }
            if (requestParam.isSetSortParams()) {
                bitSet.set(6);
            }
            if (requestParam.isSetResponseLayoutName()) {
                bitSet.set(7);
            }
            if (requestParam.isSetPortalFilter()) {
                bitSet.set(8);
            }
            if (requestParam.isSetPortalMax()) {
                bitSet.set(9);
            }
            if (requestParam.isSetDeleteRelated()) {
                bitSet.set(10);
            }
            if (requestParam.isSetFields()) {
                bitSet.set(11);
            }
            if (requestParam.isSetGlobalFields()) {
                bitSet.set(12);
            }
            tTupleProtocol.writeBitSet(bitSet, 13);
            if (requestParam.isSetCmdCode()) {
                tTupleProtocol.writeI32(requestParam.cmdCode);
            }
            if (requestParam.isSetParam()) {
                requestParam.param.write((TProtocol)tTupleProtocol);
            }
            if (requestParam.isSetOptions()) {
                tTupleProtocol.writeI32(requestParam.options);
            }
            if (requestParam.isSetPreScript()) {
                requestParam.preScript.write((TProtocol)tTupleProtocol);
            }
            if (requestParam.isSetPreSortScript()) {
                requestParam.preSortScript.write((TProtocol)tTupleProtocol);
            }
            if (requestParam.isSetPostScript()) {
                requestParam.postScript.write((TProtocol)tTupleProtocol);
            }
            if (requestParam.isSetSortParams()) {
                tTupleProtocol.writeI32(requestParam.sortParams.size());
                for (IDLComplexParam comparable : requestParam.sortParams) {
                    comparable.write((TProtocol)tTupleProtocol);
                }
            }
            if (requestParam.isSetResponseLayoutName()) {
                tTupleProtocol.writeString(requestParam.responseLayoutName);
            }
            if (requestParam.isSetPortalFilter()) {
                tTupleProtocol.writeI32(requestParam.portalFilter.getValue());
            }
            if (requestParam.isSetPortalMax()) {
                tTupleProtocol.writeI64(requestParam.portalMax);
            }
            if (requestParam.isSetDeleteRelated()) {
                tTupleProtocol.writeI32(requestParam.deleteRelated.size());
                for (NVPair nVPair : requestParam.deleteRelated) {
                    nVPair.write((TProtocol)tTupleProtocol);
                }
            }
            if (requestParam.isSetFields()) {
                tTupleProtocol.writeI32(requestParam.fields.size());
                for (IDLFieldsParam iDLFieldsParam : requestParam.fields) {
                    iDLFieldsParam.write((TProtocol)tTupleProtocol);
                }
            }
            if (requestParam.isSetGlobalFields()) {
                requestParam.globalFields.write((TProtocol)tTupleProtocol);
            }
        }

        public void read(TProtocol tProtocol, RequestParam requestParam) throws TException {
            Comparable<IDLComplexParam> comparable;
            int n;
            TList tList;
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(13);
            if (bitSet.get(0)) {
                requestParam.cmdCode = tTupleProtocol.readI32();
                requestParam.setCmdCodeIsSet(true);
            }
            if (bitSet.get(1)) {
                requestParam.param = new BasicParam();
                requestParam.param.read((TProtocol)tTupleProtocol);
                requestParam.setParamIsSet(true);
            }
            if (bitSet.get(2)) {
                requestParam.options = tTupleProtocol.readI32();
                requestParam.setOptionsIsSet(true);
            }
            if (bitSet.get(3)) {
                requestParam.preScript = new NVPair();
                requestParam.preScript.read((TProtocol)tTupleProtocol);
                requestParam.setPreScriptIsSet(true);
            }
            if (bitSet.get(4)) {
                requestParam.preSortScript = new NVPair();
                requestParam.preSortScript.read((TProtocol)tTupleProtocol);
                requestParam.setPreSortScriptIsSet(true);
            }
            if (bitSet.get(5)) {
                requestParam.postScript = new NVPair();
                requestParam.postScript.read((TProtocol)tTupleProtocol);
                requestParam.setPostScriptIsSet(true);
            }
            if (bitSet.get(6)) {
                tList = tTupleProtocol.readListBegin((byte)12);
                requestParam.sortParams = new ArrayList<IDLComplexParam>(tList.size);
                for (n = 0; n < tList.size; ++n) {
                    comparable = new IDLComplexParam();
                    ((IDLComplexParam)comparable).read((TProtocol)tTupleProtocol);
                    requestParam.sortParams.add((IDLComplexParam)comparable);
                }
                requestParam.setSortParamsIsSet(true);
            }
            if (bitSet.get(7)) {
                requestParam.responseLayoutName = tTupleProtocol.readString();
                requestParam.setResponseLayoutNameIsSet(true);
            }
            if (bitSet.get(8)) {
                requestParam.portalFilter = PortalFilterType.findByValue(tTupleProtocol.readI32());
                requestParam.setPortalFilterIsSet(true);
            }
            if (bitSet.get(9)) {
                requestParam.portalMax = tTupleProtocol.readI64();
                requestParam.setPortalMaxIsSet(true);
            }
            if (bitSet.get(10)) {
                tList = tTupleProtocol.readListBegin((byte)12);
                requestParam.deleteRelated = new ArrayList<NVPair>(tList.size);
                for (n = 0; n < tList.size; ++n) {
                    comparable = new NVPair();
                    ((NVPair)comparable).read((TProtocol)tTupleProtocol);
                    requestParam.deleteRelated.add((NVPair)comparable);
                }
                requestParam.setDeleteRelatedIsSet(true);
            }
            if (bitSet.get(11)) {
                tList = tTupleProtocol.readListBegin((byte)12);
                requestParam.fields = new ArrayList<IDLFieldsParam>(tList.size);
                for (n = 0; n < tList.size; ++n) {
                    comparable = new IDLFieldsParam();
                    ((IDLFieldsParam)comparable).read((TProtocol)tTupleProtocol);
                    requestParam.fields.add((IDLFieldsParam)comparable);
                }
                requestParam.setFieldsIsSet(true);
            }
            if (bitSet.get(12)) {
                requestParam.globalFields = new IDLFieldsParam();
                requestParam.globalFields.read((TProtocol)tTupleProtocol);
                requestParam.setGlobalFieldsIsSet(true);
            }
        }
    }

    private static class RequestParamStandardScheme
    extends StandardScheme<RequestParam> {
        private RequestParamStandardScheme() {
        }

        public void read(TProtocol tProtocol, RequestParam requestParam) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 8) {
                            requestParam.cmdCode = tProtocol.readI32();
                            requestParam.setCmdCodeIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 12) {
                            requestParam.param = new BasicParam();
                            requestParam.param.read(tProtocol);
                            requestParam.setParamIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 8) {
                            requestParam.options = tProtocol.readI32();
                            requestParam.setOptionsIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 12) {
                            requestParam.preScript = new NVPair();
                            requestParam.preScript.read(tProtocol);
                            requestParam.setPreScriptIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 5: {
                        if (tField.type == 12) {
                            requestParam.preSortScript = new NVPair();
                            requestParam.preSortScript.read(tProtocol);
                            requestParam.setPreSortScriptIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 6: {
                        if (tField.type == 12) {
                            requestParam.postScript = new NVPair();
                            requestParam.postScript.read(tProtocol);
                            requestParam.setPostScriptIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 7: {
                        Comparable<IDLComplexParam> comparable;
                        int n;
                        TList tList;
                        if (tField.type == 15) {
                            tList = tProtocol.readListBegin();
                            requestParam.sortParams = new ArrayList<IDLComplexParam>(tList.size);
                            for (n = 0; n < tList.size; ++n) {
                                comparable = new IDLComplexParam();
                                ((IDLComplexParam)comparable).read(tProtocol);
                                requestParam.sortParams.add((IDLComplexParam)comparable);
                            }
                            tProtocol.readListEnd();
                            requestParam.setSortParamsIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 8: {
                        if (tField.type == 11) {
                            requestParam.responseLayoutName = tProtocol.readString();
                            requestParam.setResponseLayoutNameIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 9: {
                        if (tField.type == 8) {
                            requestParam.portalFilter = PortalFilterType.findByValue(tProtocol.readI32());
                            requestParam.setPortalFilterIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 10: {
                        if (tField.type == 10) {
                            requestParam.portalMax = tProtocol.readI64();
                            requestParam.setPortalMaxIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 11: {
                        Comparable<IDLComplexParam> comparable;
                        int n;
                        TList tList;
                        if (tField.type == 15) {
                            tList = tProtocol.readListBegin();
                            requestParam.deleteRelated = new ArrayList<NVPair>(tList.size);
                            for (n = 0; n < tList.size; ++n) {
                                comparable = new NVPair();
                                ((NVPair)comparable).read(tProtocol);
                                requestParam.deleteRelated.add((NVPair)comparable);
                            }
                            tProtocol.readListEnd();
                            requestParam.setDeleteRelatedIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 12: {
                        Comparable<IDLComplexParam> comparable;
                        int n;
                        TList tList;
                        if (tField.type == 15) {
                            tList = tProtocol.readListBegin();
                            requestParam.fields = new ArrayList<IDLFieldsParam>(tList.size);
                            for (n = 0; n < tList.size; ++n) {
                                comparable = new IDLFieldsParam();
                                ((IDLFieldsParam)comparable).read(tProtocol);
                                requestParam.fields.add((IDLFieldsParam)comparable);
                            }
                            tProtocol.readListEnd();
                            requestParam.setFieldsIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 13: {
                        if (tField.type == 12) {
                            requestParam.globalFields = new IDLFieldsParam();
                            requestParam.globalFields.read(tProtocol);
                            requestParam.setGlobalFieldsIsSet(true);
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
            requestParam.validate();
        }

        public void write(TProtocol tProtocol, RequestParam requestParam) throws TException {
            requestParam.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            tProtocol.writeFieldBegin(CMD_CODE_FIELD_DESC);
            tProtocol.writeI32(requestParam.cmdCode);
            tProtocol.writeFieldEnd();
            if (requestParam.param != null) {
                tProtocol.writeFieldBegin(PARAM_FIELD_DESC);
                requestParam.param.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(OPTIONS_FIELD_DESC);
            tProtocol.writeI32(requestParam.options);
            tProtocol.writeFieldEnd();
            if (requestParam.preScript != null) {
                tProtocol.writeFieldBegin(PRE_SCRIPT_FIELD_DESC);
                requestParam.preScript.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            if (requestParam.preSortScript != null) {
                tProtocol.writeFieldBegin(PRE_SORT_SCRIPT_FIELD_DESC);
                requestParam.preSortScript.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            if (requestParam.postScript != null) {
                tProtocol.writeFieldBegin(POST_SCRIPT_FIELD_DESC);
                requestParam.postScript.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            if (requestParam.sortParams != null) {
                tProtocol.writeFieldBegin(SORT_PARAMS_FIELD_DESC);
                tProtocol.writeListBegin(new TList(12, requestParam.sortParams.size()));
                for (IDLComplexParam comparable : requestParam.sortParams) {
                    comparable.write(tProtocol);
                }
                tProtocol.writeListEnd();
                tProtocol.writeFieldEnd();
            }
            if (requestParam.responseLayoutName != null) {
                tProtocol.writeFieldBegin(RESPONSE_LAYOUT_NAME_FIELD_DESC);
                tProtocol.writeString(requestParam.responseLayoutName);
                tProtocol.writeFieldEnd();
            }
            if (requestParam.portalFilter != null) {
                tProtocol.writeFieldBegin(PORTAL_FILTER_FIELD_DESC);
                tProtocol.writeI32(requestParam.portalFilter.getValue());
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(PORTAL_MAX_FIELD_DESC);
            tProtocol.writeI64(requestParam.portalMax);
            tProtocol.writeFieldEnd();
            if (requestParam.deleteRelated != null) {
                tProtocol.writeFieldBegin(DELETE_RELATED_FIELD_DESC);
                tProtocol.writeListBegin(new TList(12, requestParam.deleteRelated.size()));
                for (NVPair nVPair : requestParam.deleteRelated) {
                    nVPair.write(tProtocol);
                }
                tProtocol.writeListEnd();
                tProtocol.writeFieldEnd();
            }
            if (requestParam.fields != null) {
                tProtocol.writeFieldBegin(FIELDS_FIELD_DESC);
                tProtocol.writeListBegin(new TList(12, requestParam.fields.size()));
                for (IDLFieldsParam iDLFieldsParam : requestParam.fields) {
                    iDLFieldsParam.write(tProtocol);
                }
                tProtocol.writeListEnd();
                tProtocol.writeFieldEnd();
            }
            if (requestParam.globalFields != null) {
                tProtocol.writeFieldBegin(GLOBAL_FIELDS_FIELD_DESC);
                requestParam.globalFields.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

