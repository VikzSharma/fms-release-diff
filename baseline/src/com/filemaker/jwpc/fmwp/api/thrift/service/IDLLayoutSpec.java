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

import com.filemaker.jwpc.fmwp.api.thrift.service.IDLFieldLaySpec;
import com.filemaker.jwpc.fmwp.api.thrift.service.IDLFieldSpec;
import com.filemaker.jwpc.fmwp.api.thrift.service.IDLItemInfo;
import com.filemaker.jwpc.fmwp.api.thrift.service.IDLPortalFieldLaySpec;
import com.filemaker.jwpc.fmwp.api.thrift.service.IDLPortalFieldSpec;
import com.filemaker.jwpc.fmwp.api.thrift.service.IDLValueList;
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

public class IDLLayoutSpec
implements TBase<IDLLayoutSpec, _Fields>,
Serializable,
Cloneable,
Comparable<IDLLayoutSpec> {
    private static final TStruct STRUCT_DESC = new TStruct("IDLLayoutSpec");
    private static final TField DATABASE_NAME_FIELD_DESC = new TField("databaseName", 11, 1);
    private static final TField LAYOUT_INFO_FIELD_DESC = new TField("layoutInfo", 12, 2);
    private static final TField TABLE_NAME_FIELD_DESC = new TField("tableName", 11, 3);
    private static final TField TOTAL_RECORDS_FIELD_DESC = new TField("totalRecords", 10, 4);
    private static final TField FIELD_LAY_SPECS_FIELD_DESC = new TField("fieldLaySpecs", 15, 5);
    private static final TField PORTAL_FIELD_LAY_SPECS_FIELD_DESC = new TField("portalFieldLaySpecs", 15, 6);
    private static final TField VALUE_LISTS_FIELD_DESC = new TField("valueLists", 15, 7);
    private static final TField FIELD_SPECS_FIELD_DESC = new TField("fieldSpecs", 15, 8);
    private static final TField PORTAL_FIELD_SPECS_FIELD_DESC = new TField("portalFieldSpecs", 15, 9);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new IDLLayoutSpecStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new IDLLayoutSpecTupleSchemeFactory();
    @Nullable
    private String databaseName;
    @Nullable
    private IDLItemInfo layoutInfo;
    @Nullable
    private String tableName;
    private long totalRecords;
    @Nullable
    private List<IDLFieldLaySpec> fieldLaySpecs;
    @Nullable
    private List<IDLPortalFieldLaySpec> portalFieldLaySpecs;
    @Nullable
    private List<IDLValueList> valueLists;
    @Nullable
    private List<IDLFieldSpec> fieldSpecs;
    @Nullable
    private List<IDLPortalFieldSpec> portalFieldSpecs;
    private static final int __TOTALRECORDS_ISSET_ID = 0;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public IDLLayoutSpec() {
    }

    public IDLLayoutSpec(String string, IDLItemInfo iDLItemInfo, String string2, long l, List<IDLFieldLaySpec> list, List<IDLPortalFieldLaySpec> list2, List<IDLValueList> list3, List<IDLFieldSpec> list4, List<IDLPortalFieldSpec> list5) {
        this();
        this.databaseName = string;
        this.layoutInfo = iDLItemInfo;
        this.tableName = string2;
        this.totalRecords = l;
        this.setTotalRecordsIsSet(true);
        this.fieldLaySpecs = list;
        this.portalFieldLaySpecs = list2;
        this.valueLists = list3;
        this.fieldSpecs = list4;
        this.portalFieldSpecs = list5;
    }

    public IDLLayoutSpec(IDLLayoutSpec iDLLayoutSpec) {
        ArrayList<IDLFieldLaySpec> arrayList;
        this.__isset_bitfield = iDLLayoutSpec.__isset_bitfield;
        if (iDLLayoutSpec.isSetDatabaseName()) {
            this.databaseName = iDLLayoutSpec.databaseName;
        }
        if (iDLLayoutSpec.isSetLayoutInfo()) {
            this.layoutInfo = new IDLItemInfo(iDLLayoutSpec.layoutInfo);
        }
        if (iDLLayoutSpec.isSetTableName()) {
            this.tableName = iDLLayoutSpec.tableName;
        }
        this.totalRecords = iDLLayoutSpec.totalRecords;
        if (iDLLayoutSpec.isSetFieldLaySpecs()) {
            arrayList = new ArrayList<IDLFieldLaySpec>(iDLLayoutSpec.fieldLaySpecs.size());
            for (IDLFieldLaySpec comparable : iDLLayoutSpec.fieldLaySpecs) {
                arrayList.add(new IDLFieldLaySpec(comparable));
            }
            this.fieldLaySpecs = arrayList;
        }
        if (iDLLayoutSpec.isSetPortalFieldLaySpecs()) {
            arrayList = new ArrayList(iDLLayoutSpec.portalFieldLaySpecs.size());
            for (IDLPortalFieldLaySpec iDLPortalFieldLaySpec : iDLLayoutSpec.portalFieldLaySpecs) {
                arrayList.add((IDLFieldLaySpec)((Object)new IDLPortalFieldLaySpec(iDLPortalFieldLaySpec)));
            }
            this.portalFieldLaySpecs = arrayList;
        }
        if (iDLLayoutSpec.isSetValueLists()) {
            arrayList = new ArrayList(iDLLayoutSpec.valueLists.size());
            for (IDLValueList iDLValueList : iDLLayoutSpec.valueLists) {
                arrayList.add((IDLFieldLaySpec)((Object)new IDLValueList(iDLValueList)));
            }
            this.valueLists = arrayList;
        }
        if (iDLLayoutSpec.isSetFieldSpecs()) {
            arrayList = new ArrayList(iDLLayoutSpec.fieldSpecs.size());
            for (IDLFieldSpec iDLFieldSpec : iDLLayoutSpec.fieldSpecs) {
                arrayList.add((IDLFieldLaySpec)((Object)new IDLFieldSpec(iDLFieldSpec)));
            }
            this.fieldSpecs = arrayList;
        }
        if (iDLLayoutSpec.isSetPortalFieldSpecs()) {
            arrayList = new ArrayList(iDLLayoutSpec.portalFieldSpecs.size());
            for (IDLPortalFieldSpec iDLPortalFieldSpec : iDLLayoutSpec.portalFieldSpecs) {
                arrayList.add((IDLFieldLaySpec)((Object)new IDLPortalFieldSpec(iDLPortalFieldSpec)));
            }
            this.portalFieldSpecs = arrayList;
        }
    }

    public IDLLayoutSpec deepCopy() {
        return new IDLLayoutSpec(this);
    }

    public void clear() {
        this.databaseName = null;
        this.layoutInfo = null;
        this.tableName = null;
        this.setTotalRecordsIsSet(false);
        this.totalRecords = 0L;
        this.fieldLaySpecs = null;
        this.portalFieldLaySpecs = null;
        this.valueLists = null;
        this.fieldSpecs = null;
        this.portalFieldSpecs = null;
    }

    @Nullable
    public String getDatabaseName() {
        return this.databaseName;
    }

    public void setDatabaseName(@Nullable String string) {
        this.databaseName = string;
    }

    public void unsetDatabaseName() {
        this.databaseName = null;
    }

    public boolean isSetDatabaseName() {
        return this.databaseName != null;
    }

    public void setDatabaseNameIsSet(boolean bl) {
        if (!bl) {
            this.databaseName = null;
        }
    }

    @Nullable
    public IDLItemInfo getLayoutInfo() {
        return this.layoutInfo;
    }

    public void setLayoutInfo(@Nullable IDLItemInfo iDLItemInfo) {
        this.layoutInfo = iDLItemInfo;
    }

    public void unsetLayoutInfo() {
        this.layoutInfo = null;
    }

    public boolean isSetLayoutInfo() {
        return this.layoutInfo != null;
    }

    public void setLayoutInfoIsSet(boolean bl) {
        if (!bl) {
            this.layoutInfo = null;
        }
    }

    @Nullable
    public String getTableName() {
        return this.tableName;
    }

    public void setTableName(@Nullable String string) {
        this.tableName = string;
    }

    public void unsetTableName() {
        this.tableName = null;
    }

    public boolean isSetTableName() {
        return this.tableName != null;
    }

    public void setTableNameIsSet(boolean bl) {
        if (!bl) {
            this.tableName = null;
        }
    }

    public long getTotalRecords() {
        return this.totalRecords;
    }

    public void setTotalRecords(long l) {
        this.totalRecords = l;
        this.setTotalRecordsIsSet(true);
    }

    public void unsetTotalRecords() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetTotalRecords() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setTotalRecordsIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public int getFieldLaySpecsSize() {
        return this.fieldLaySpecs == null ? 0 : this.fieldLaySpecs.size();
    }

    @Nullable
    public Iterator<IDLFieldLaySpec> getFieldLaySpecsIterator() {
        return this.fieldLaySpecs == null ? null : this.fieldLaySpecs.iterator();
    }

    public void addToFieldLaySpecs(IDLFieldLaySpec iDLFieldLaySpec) {
        if (this.fieldLaySpecs == null) {
            this.fieldLaySpecs = new ArrayList<IDLFieldLaySpec>();
        }
        this.fieldLaySpecs.add(iDLFieldLaySpec);
    }

    @Nullable
    public List<IDLFieldLaySpec> getFieldLaySpecs() {
        return this.fieldLaySpecs;
    }

    public void setFieldLaySpecs(@Nullable List<IDLFieldLaySpec> list) {
        this.fieldLaySpecs = list;
    }

    public void unsetFieldLaySpecs() {
        this.fieldLaySpecs = null;
    }

    public boolean isSetFieldLaySpecs() {
        return this.fieldLaySpecs != null;
    }

    public void setFieldLaySpecsIsSet(boolean bl) {
        if (!bl) {
            this.fieldLaySpecs = null;
        }
    }

    public int getPortalFieldLaySpecsSize() {
        return this.portalFieldLaySpecs == null ? 0 : this.portalFieldLaySpecs.size();
    }

    @Nullable
    public Iterator<IDLPortalFieldLaySpec> getPortalFieldLaySpecsIterator() {
        return this.portalFieldLaySpecs == null ? null : this.portalFieldLaySpecs.iterator();
    }

    public void addToPortalFieldLaySpecs(IDLPortalFieldLaySpec iDLPortalFieldLaySpec) {
        if (this.portalFieldLaySpecs == null) {
            this.portalFieldLaySpecs = new ArrayList<IDLPortalFieldLaySpec>();
        }
        this.portalFieldLaySpecs.add(iDLPortalFieldLaySpec);
    }

    @Nullable
    public List<IDLPortalFieldLaySpec> getPortalFieldLaySpecs() {
        return this.portalFieldLaySpecs;
    }

    public void setPortalFieldLaySpecs(@Nullable List<IDLPortalFieldLaySpec> list) {
        this.portalFieldLaySpecs = list;
    }

    public void unsetPortalFieldLaySpecs() {
        this.portalFieldLaySpecs = null;
    }

    public boolean isSetPortalFieldLaySpecs() {
        return this.portalFieldLaySpecs != null;
    }

    public void setPortalFieldLaySpecsIsSet(boolean bl) {
        if (!bl) {
            this.portalFieldLaySpecs = null;
        }
    }

    public int getValueListsSize() {
        return this.valueLists == null ? 0 : this.valueLists.size();
    }

    @Nullable
    public Iterator<IDLValueList> getValueListsIterator() {
        return this.valueLists == null ? null : this.valueLists.iterator();
    }

    public void addToValueLists(IDLValueList iDLValueList) {
        if (this.valueLists == null) {
            this.valueLists = new ArrayList<IDLValueList>();
        }
        this.valueLists.add(iDLValueList);
    }

    @Nullable
    public List<IDLValueList> getValueLists() {
        return this.valueLists;
    }

    public void setValueLists(@Nullable List<IDLValueList> list) {
        this.valueLists = list;
    }

    public void unsetValueLists() {
        this.valueLists = null;
    }

    public boolean isSetValueLists() {
        return this.valueLists != null;
    }

    public void setValueListsIsSet(boolean bl) {
        if (!bl) {
            this.valueLists = null;
        }
    }

    public int getFieldSpecsSize() {
        return this.fieldSpecs == null ? 0 : this.fieldSpecs.size();
    }

    @Nullable
    public Iterator<IDLFieldSpec> getFieldSpecsIterator() {
        return this.fieldSpecs == null ? null : this.fieldSpecs.iterator();
    }

    public void addToFieldSpecs(IDLFieldSpec iDLFieldSpec) {
        if (this.fieldSpecs == null) {
            this.fieldSpecs = new ArrayList<IDLFieldSpec>();
        }
        this.fieldSpecs.add(iDLFieldSpec);
    }

    @Nullable
    public List<IDLFieldSpec> getFieldSpecs() {
        return this.fieldSpecs;
    }

    public void setFieldSpecs(@Nullable List<IDLFieldSpec> list) {
        this.fieldSpecs = list;
    }

    public void unsetFieldSpecs() {
        this.fieldSpecs = null;
    }

    public boolean isSetFieldSpecs() {
        return this.fieldSpecs != null;
    }

    public void setFieldSpecsIsSet(boolean bl) {
        if (!bl) {
            this.fieldSpecs = null;
        }
    }

    public int getPortalFieldSpecsSize() {
        return this.portalFieldSpecs == null ? 0 : this.portalFieldSpecs.size();
    }

    @Nullable
    public Iterator<IDLPortalFieldSpec> getPortalFieldSpecsIterator() {
        return this.portalFieldSpecs == null ? null : this.portalFieldSpecs.iterator();
    }

    public void addToPortalFieldSpecs(IDLPortalFieldSpec iDLPortalFieldSpec) {
        if (this.portalFieldSpecs == null) {
            this.portalFieldSpecs = new ArrayList<IDLPortalFieldSpec>();
        }
        this.portalFieldSpecs.add(iDLPortalFieldSpec);
    }

    @Nullable
    public List<IDLPortalFieldSpec> getPortalFieldSpecs() {
        return this.portalFieldSpecs;
    }

    public void setPortalFieldSpecs(@Nullable List<IDLPortalFieldSpec> list) {
        this.portalFieldSpecs = list;
    }

    public void unsetPortalFieldSpecs() {
        this.portalFieldSpecs = null;
    }

    public boolean isSetPortalFieldSpecs() {
        return this.portalFieldSpecs != null;
    }

    public void setPortalFieldSpecsIsSet(boolean bl) {
        if (!bl) {
            this.portalFieldSpecs = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetDatabaseName();
                    break;
                }
                this.setDatabaseName((String)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetLayoutInfo();
                    break;
                }
                this.setLayoutInfo((IDLItemInfo)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetTableName();
                    break;
                }
                this.setTableName((String)object);
                break;
            }
            case 3: {
                if (object == null) {
                    this.unsetTotalRecords();
                    break;
                }
                this.setTotalRecords((Long)object);
                break;
            }
            case 4: {
                if (object == null) {
                    this.unsetFieldLaySpecs();
                    break;
                }
                this.setFieldLaySpecs((List)object);
                break;
            }
            case 5: {
                if (object == null) {
                    this.unsetPortalFieldLaySpecs();
                    break;
                }
                this.setPortalFieldLaySpecs((List)object);
                break;
            }
            case 6: {
                if (object == null) {
                    this.unsetValueLists();
                    break;
                }
                this.setValueLists((List)object);
                break;
            }
            case 7: {
                if (object == null) {
                    this.unsetFieldSpecs();
                    break;
                }
                this.setFieldSpecs((List)object);
                break;
            }
            case 8: {
                if (object == null) {
                    this.unsetPortalFieldSpecs();
                    break;
                }
                this.setPortalFieldSpecs((List)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getDatabaseName();
            }
            case 1: {
                return this.getLayoutInfo();
            }
            case 2: {
                return this.getTableName();
            }
            case 3: {
                return this.getTotalRecords();
            }
            case 4: {
                return this.getFieldLaySpecs();
            }
            case 5: {
                return this.getPortalFieldLaySpecs();
            }
            case 6: {
                return this.getValueLists();
            }
            case 7: {
                return this.getFieldSpecs();
            }
            case 8: {
                return this.getPortalFieldSpecs();
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
                return this.isSetDatabaseName();
            }
            case 1: {
                return this.isSetLayoutInfo();
            }
            case 2: {
                return this.isSetTableName();
            }
            case 3: {
                return this.isSetTotalRecords();
            }
            case 4: {
                return this.isSetFieldLaySpecs();
            }
            case 5: {
                return this.isSetPortalFieldLaySpecs();
            }
            case 6: {
                return this.isSetValueLists();
            }
            case 7: {
                return this.isSetFieldSpecs();
            }
            case 8: {
                return this.isSetPortalFieldSpecs();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof IDLLayoutSpec) {
            return this.equals((IDLLayoutSpec)object);
        }
        return false;
    }

    public boolean equals(IDLLayoutSpec iDLLayoutSpec) {
        if (iDLLayoutSpec == null) {
            return false;
        }
        if (this == iDLLayoutSpec) {
            return true;
        }
        boolean bl = this.isSetDatabaseName();
        boolean bl2 = iDLLayoutSpec.isSetDatabaseName();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.databaseName.equals(iDLLayoutSpec.databaseName)) {
                return false;
            }
        }
        boolean bl3 = this.isSetLayoutInfo();
        boolean bl4 = iDLLayoutSpec.isSetLayoutInfo();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.layoutInfo.equals(iDLLayoutSpec.layoutInfo)) {
                return false;
            }
        }
        boolean bl5 = this.isSetTableName();
        boolean bl6 = iDLLayoutSpec.isSetTableName();
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (!this.tableName.equals(iDLLayoutSpec.tableName)) {
                return false;
            }
        }
        boolean bl7 = true;
        boolean bl8 = true;
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (this.totalRecords != iDLLayoutSpec.totalRecords) {
                return false;
            }
        }
        boolean bl9 = this.isSetFieldLaySpecs();
        boolean bl10 = iDLLayoutSpec.isSetFieldLaySpecs();
        if (bl9 || bl10) {
            if (!bl9 || !bl10) {
                return false;
            }
            if (!this.fieldLaySpecs.equals(iDLLayoutSpec.fieldLaySpecs)) {
                return false;
            }
        }
        boolean bl11 = this.isSetPortalFieldLaySpecs();
        boolean bl12 = iDLLayoutSpec.isSetPortalFieldLaySpecs();
        if (bl11 || bl12) {
            if (!bl11 || !bl12) {
                return false;
            }
            if (!this.portalFieldLaySpecs.equals(iDLLayoutSpec.portalFieldLaySpecs)) {
                return false;
            }
        }
        boolean bl13 = this.isSetValueLists();
        boolean bl14 = iDLLayoutSpec.isSetValueLists();
        if (bl13 || bl14) {
            if (!bl13 || !bl14) {
                return false;
            }
            if (!this.valueLists.equals(iDLLayoutSpec.valueLists)) {
                return false;
            }
        }
        boolean bl15 = this.isSetFieldSpecs();
        boolean bl16 = iDLLayoutSpec.isSetFieldSpecs();
        if (bl15 || bl16) {
            if (!bl15 || !bl16) {
                return false;
            }
            if (!this.fieldSpecs.equals(iDLLayoutSpec.fieldSpecs)) {
                return false;
            }
        }
        boolean bl17 = this.isSetPortalFieldSpecs();
        boolean bl18 = iDLLayoutSpec.isSetPortalFieldSpecs();
        if (bl17 || bl18) {
            if (!bl17 || !bl18) {
                return false;
            }
            if (!this.portalFieldSpecs.equals(iDLLayoutSpec.portalFieldSpecs)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetDatabaseName() ? 131071 : 524287);
        if (this.isSetDatabaseName()) {
            n = n * 8191 + this.databaseName.hashCode();
        }
        n = n * 8191 + (this.isSetLayoutInfo() ? 131071 : 524287);
        if (this.isSetLayoutInfo()) {
            n = n * 8191 + this.layoutInfo.hashCode();
        }
        n = n * 8191 + (this.isSetTableName() ? 131071 : 524287);
        if (this.isSetTableName()) {
            n = n * 8191 + this.tableName.hashCode();
        }
        n = n * 8191 + TBaseHelper.hashCode((long)this.totalRecords);
        n = n * 8191 + (this.isSetFieldLaySpecs() ? 131071 : 524287);
        if (this.isSetFieldLaySpecs()) {
            n = n * 8191 + this.fieldLaySpecs.hashCode();
        }
        n = n * 8191 + (this.isSetPortalFieldLaySpecs() ? 131071 : 524287);
        if (this.isSetPortalFieldLaySpecs()) {
            n = n * 8191 + this.portalFieldLaySpecs.hashCode();
        }
        n = n * 8191 + (this.isSetValueLists() ? 131071 : 524287);
        if (this.isSetValueLists()) {
            n = n * 8191 + this.valueLists.hashCode();
        }
        n = n * 8191 + (this.isSetFieldSpecs() ? 131071 : 524287);
        if (this.isSetFieldSpecs()) {
            n = n * 8191 + this.fieldSpecs.hashCode();
        }
        n = n * 8191 + (this.isSetPortalFieldSpecs() ? 131071 : 524287);
        if (this.isSetPortalFieldSpecs()) {
            n = n * 8191 + this.portalFieldSpecs.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(IDLLayoutSpec iDLLayoutSpec) {
        if (!this.getClass().equals(iDLLayoutSpec.getClass())) {
            return this.getClass().getName().compareTo(iDLLayoutSpec.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetDatabaseName(), iDLLayoutSpec.isSetDatabaseName());
        if (n != 0) {
            return n;
        }
        if (this.isSetDatabaseName() && (n = TBaseHelper.compareTo((String)this.databaseName, (String)iDLLayoutSpec.databaseName)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetLayoutInfo(), iDLLayoutSpec.isSetLayoutInfo());
        if (n != 0) {
            return n;
        }
        if (this.isSetLayoutInfo() && (n = TBaseHelper.compareTo((Comparable)this.layoutInfo, (Comparable)iDLLayoutSpec.layoutInfo)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetTableName(), iDLLayoutSpec.isSetTableName());
        if (n != 0) {
            return n;
        }
        if (this.isSetTableName() && (n = TBaseHelper.compareTo((String)this.tableName, (String)iDLLayoutSpec.tableName)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetTotalRecords(), iDLLayoutSpec.isSetTotalRecords());
        if (n != 0) {
            return n;
        }
        if (this.isSetTotalRecords() && (n = TBaseHelper.compareTo((long)this.totalRecords, (long)iDLLayoutSpec.totalRecords)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetFieldLaySpecs(), iDLLayoutSpec.isSetFieldLaySpecs());
        if (n != 0) {
            return n;
        }
        if (this.isSetFieldLaySpecs() && (n = TBaseHelper.compareTo(this.fieldLaySpecs, iDLLayoutSpec.fieldLaySpecs)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetPortalFieldLaySpecs(), iDLLayoutSpec.isSetPortalFieldLaySpecs());
        if (n != 0) {
            return n;
        }
        if (this.isSetPortalFieldLaySpecs() && (n = TBaseHelper.compareTo(this.portalFieldLaySpecs, iDLLayoutSpec.portalFieldLaySpecs)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetValueLists(), iDLLayoutSpec.isSetValueLists());
        if (n != 0) {
            return n;
        }
        if (this.isSetValueLists() && (n = TBaseHelper.compareTo(this.valueLists, iDLLayoutSpec.valueLists)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetFieldSpecs(), iDLLayoutSpec.isSetFieldSpecs());
        if (n != 0) {
            return n;
        }
        if (this.isSetFieldSpecs() && (n = TBaseHelper.compareTo(this.fieldSpecs, iDLLayoutSpec.fieldSpecs)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetPortalFieldSpecs(), iDLLayoutSpec.isSetPortalFieldSpecs());
        if (n != 0) {
            return n;
        }
        if (this.isSetPortalFieldSpecs() && (n = TBaseHelper.compareTo(this.portalFieldSpecs, iDLLayoutSpec.portalFieldSpecs)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        IDLLayoutSpec.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        IDLLayoutSpec.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("IDLLayoutSpec(");
        boolean bl = true;
        stringBuilder.append("databaseName:");
        if (this.databaseName == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.databaseName);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("layoutInfo:");
        if (this.layoutInfo == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.layoutInfo);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("tableName:");
        if (this.tableName == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.tableName);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("totalRecords:");
        stringBuilder.append(this.totalRecords);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("fieldLaySpecs:");
        if (this.fieldLaySpecs == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.fieldLaySpecs);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("portalFieldLaySpecs:");
        if (this.portalFieldLaySpecs == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.portalFieldLaySpecs);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("valueLists:");
        if (this.valueLists == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.valueLists);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("fieldSpecs:");
        if (this.fieldSpecs == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.fieldSpecs);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("portalFieldSpecs:");
        if (this.portalFieldSpecs == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.portalFieldSpecs);
        }
        bl = false;
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void validate() throws TException {
        if (this.layoutInfo != null) {
            this.layoutInfo.validate();
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
        enumMap.put(_Fields.DATABASE_NAME, new FieldMetaData("databaseName", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.LAYOUT_INFO, new FieldMetaData("layoutInfo", 3, (FieldValueMetaData)new StructMetaData(12, IDLItemInfo.class)));
        enumMap.put(_Fields.TABLE_NAME, new FieldMetaData("tableName", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.TOTAL_RECORDS, new FieldMetaData("totalRecords", 3, new FieldValueMetaData(10)));
        enumMap.put(_Fields.FIELD_LAY_SPECS, new FieldMetaData("fieldLaySpecs", 3, (FieldValueMetaData)new ListMetaData(15, (FieldValueMetaData)new StructMetaData(12, IDLFieldLaySpec.class))));
        enumMap.put(_Fields.PORTAL_FIELD_LAY_SPECS, new FieldMetaData("portalFieldLaySpecs", 3, (FieldValueMetaData)new ListMetaData(15, (FieldValueMetaData)new StructMetaData(12, IDLPortalFieldLaySpec.class))));
        enumMap.put(_Fields.VALUE_LISTS, new FieldMetaData("valueLists", 3, (FieldValueMetaData)new ListMetaData(15, (FieldValueMetaData)new StructMetaData(12, IDLValueList.class))));
        enumMap.put(_Fields.FIELD_SPECS, new FieldMetaData("fieldSpecs", 3, (FieldValueMetaData)new ListMetaData(15, (FieldValueMetaData)new StructMetaData(12, IDLFieldSpec.class))));
        enumMap.put(_Fields.PORTAL_FIELD_SPECS, new FieldMetaData("portalFieldSpecs", 3, (FieldValueMetaData)new ListMetaData(15, (FieldValueMetaData)new StructMetaData(12, IDLPortalFieldSpec.class))));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(IDLLayoutSpec.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        DATABASE_NAME(1, "databaseName"),
        LAYOUT_INFO(2, "layoutInfo"),
        TABLE_NAME(3, "tableName"),
        TOTAL_RECORDS(4, "totalRecords"),
        FIELD_LAY_SPECS(5, "fieldLaySpecs"),
        PORTAL_FIELD_LAY_SPECS(6, "portalFieldLaySpecs"),
        VALUE_LISTS(7, "valueLists"),
        FIELD_SPECS(8, "fieldSpecs"),
        PORTAL_FIELD_SPECS(9, "portalFieldSpecs");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return DATABASE_NAME;
                }
                case 2: {
                    return LAYOUT_INFO;
                }
                case 3: {
                    return TABLE_NAME;
                }
                case 4: {
                    return TOTAL_RECORDS;
                }
                case 5: {
                    return FIELD_LAY_SPECS;
                }
                case 6: {
                    return PORTAL_FIELD_LAY_SPECS;
                }
                case 7: {
                    return VALUE_LISTS;
                }
                case 8: {
                    return FIELD_SPECS;
                }
                case 9: {
                    return PORTAL_FIELD_SPECS;
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

    private static class IDLLayoutSpecStandardSchemeFactory
    implements SchemeFactory {
        private IDLLayoutSpecStandardSchemeFactory() {
        }

        public IDLLayoutSpecStandardScheme getScheme() {
            return new IDLLayoutSpecStandardScheme();
        }
    }

    private static class IDLLayoutSpecTupleSchemeFactory
    implements SchemeFactory {
        private IDLLayoutSpecTupleSchemeFactory() {
        }

        public IDLLayoutSpecTupleScheme getScheme() {
            return new IDLLayoutSpecTupleScheme();
        }
    }

    private static class IDLLayoutSpecTupleScheme
    extends TupleScheme<IDLLayoutSpec> {
        private IDLLayoutSpecTupleScheme() {
        }

        public void write(TProtocol tProtocol, IDLLayoutSpec iDLLayoutSpec) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (iDLLayoutSpec.isSetDatabaseName()) {
                bitSet.set(0);
            }
            if (iDLLayoutSpec.isSetLayoutInfo()) {
                bitSet.set(1);
            }
            if (iDLLayoutSpec.isSetTableName()) {
                bitSet.set(2);
            }
            if (iDLLayoutSpec.isSetTotalRecords()) {
                bitSet.set(3);
            }
            if (iDLLayoutSpec.isSetFieldLaySpecs()) {
                bitSet.set(4);
            }
            if (iDLLayoutSpec.isSetPortalFieldLaySpecs()) {
                bitSet.set(5);
            }
            if (iDLLayoutSpec.isSetValueLists()) {
                bitSet.set(6);
            }
            if (iDLLayoutSpec.isSetFieldSpecs()) {
                bitSet.set(7);
            }
            if (iDLLayoutSpec.isSetPortalFieldSpecs()) {
                bitSet.set(8);
            }
            tTupleProtocol.writeBitSet(bitSet, 9);
            if (iDLLayoutSpec.isSetDatabaseName()) {
                tTupleProtocol.writeString(iDLLayoutSpec.databaseName);
            }
            if (iDLLayoutSpec.isSetLayoutInfo()) {
                iDLLayoutSpec.layoutInfo.write((TProtocol)tTupleProtocol);
            }
            if (iDLLayoutSpec.isSetTableName()) {
                tTupleProtocol.writeString(iDLLayoutSpec.tableName);
            }
            if (iDLLayoutSpec.isSetTotalRecords()) {
                tTupleProtocol.writeI64(iDLLayoutSpec.totalRecords);
            }
            if (iDLLayoutSpec.isSetFieldLaySpecs()) {
                tTupleProtocol.writeI32(iDLLayoutSpec.fieldLaySpecs.size());
                for (IDLFieldLaySpec comparable : iDLLayoutSpec.fieldLaySpecs) {
                    comparable.write((TProtocol)tTupleProtocol);
                }
            }
            if (iDLLayoutSpec.isSetPortalFieldLaySpecs()) {
                tTupleProtocol.writeI32(iDLLayoutSpec.portalFieldLaySpecs.size());
                for (IDLPortalFieldLaySpec iDLPortalFieldLaySpec : iDLLayoutSpec.portalFieldLaySpecs) {
                    iDLPortalFieldLaySpec.write((TProtocol)tTupleProtocol);
                }
            }
            if (iDLLayoutSpec.isSetValueLists()) {
                tTupleProtocol.writeI32(iDLLayoutSpec.valueLists.size());
                for (IDLValueList iDLValueList : iDLLayoutSpec.valueLists) {
                    iDLValueList.write((TProtocol)tTupleProtocol);
                }
            }
            if (iDLLayoutSpec.isSetFieldSpecs()) {
                tTupleProtocol.writeI32(iDLLayoutSpec.fieldSpecs.size());
                for (IDLFieldSpec iDLFieldSpec : iDLLayoutSpec.fieldSpecs) {
                    iDLFieldSpec.write((TProtocol)tTupleProtocol);
                }
            }
            if (iDLLayoutSpec.isSetPortalFieldSpecs()) {
                tTupleProtocol.writeI32(iDLLayoutSpec.portalFieldSpecs.size());
                for (IDLPortalFieldSpec iDLPortalFieldSpec : iDLLayoutSpec.portalFieldSpecs) {
                    iDLPortalFieldSpec.write((TProtocol)tTupleProtocol);
                }
            }
        }

        public void read(TProtocol tProtocol, IDLLayoutSpec iDLLayoutSpec) throws TException {
            Comparable<IDLFieldLaySpec> comparable;
            int n;
            TList tList;
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(9);
            if (bitSet.get(0)) {
                iDLLayoutSpec.databaseName = tTupleProtocol.readString();
                iDLLayoutSpec.setDatabaseNameIsSet(true);
            }
            if (bitSet.get(1)) {
                iDLLayoutSpec.layoutInfo = new IDLItemInfo();
                iDLLayoutSpec.layoutInfo.read((TProtocol)tTupleProtocol);
                iDLLayoutSpec.setLayoutInfoIsSet(true);
            }
            if (bitSet.get(2)) {
                iDLLayoutSpec.tableName = tTupleProtocol.readString();
                iDLLayoutSpec.setTableNameIsSet(true);
            }
            if (bitSet.get(3)) {
                iDLLayoutSpec.totalRecords = tTupleProtocol.readI64();
                iDLLayoutSpec.setTotalRecordsIsSet(true);
            }
            if (bitSet.get(4)) {
                tList = tTupleProtocol.readListBegin((byte)12);
                iDLLayoutSpec.fieldLaySpecs = new ArrayList<IDLFieldLaySpec>(tList.size);
                for (n = 0; n < tList.size; ++n) {
                    comparable = new IDLFieldLaySpec();
                    ((IDLFieldLaySpec)comparable).read((TProtocol)tTupleProtocol);
                    iDLLayoutSpec.fieldLaySpecs.add((IDLFieldLaySpec)comparable);
                }
                iDLLayoutSpec.setFieldLaySpecsIsSet(true);
            }
            if (bitSet.get(5)) {
                tList = tTupleProtocol.readListBegin((byte)12);
                iDLLayoutSpec.portalFieldLaySpecs = new ArrayList<IDLPortalFieldLaySpec>(tList.size);
                for (n = 0; n < tList.size; ++n) {
                    comparable = new IDLPortalFieldLaySpec();
                    ((IDLPortalFieldLaySpec)comparable).read((TProtocol)tTupleProtocol);
                    iDLLayoutSpec.portalFieldLaySpecs.add((IDLPortalFieldLaySpec)comparable);
                }
                iDLLayoutSpec.setPortalFieldLaySpecsIsSet(true);
            }
            if (bitSet.get(6)) {
                tList = tTupleProtocol.readListBegin((byte)12);
                iDLLayoutSpec.valueLists = new ArrayList<IDLValueList>(tList.size);
                for (n = 0; n < tList.size; ++n) {
                    comparable = new IDLValueList();
                    ((IDLValueList)comparable).read((TProtocol)tTupleProtocol);
                    iDLLayoutSpec.valueLists.add((IDLValueList)comparable);
                }
                iDLLayoutSpec.setValueListsIsSet(true);
            }
            if (bitSet.get(7)) {
                tList = tTupleProtocol.readListBegin((byte)12);
                iDLLayoutSpec.fieldSpecs = new ArrayList<IDLFieldSpec>(tList.size);
                for (n = 0; n < tList.size; ++n) {
                    comparable = new IDLFieldSpec();
                    ((IDLFieldSpec)comparable).read((TProtocol)tTupleProtocol);
                    iDLLayoutSpec.fieldSpecs.add((IDLFieldSpec)comparable);
                }
                iDLLayoutSpec.setFieldSpecsIsSet(true);
            }
            if (bitSet.get(8)) {
                tList = tTupleProtocol.readListBegin((byte)12);
                iDLLayoutSpec.portalFieldSpecs = new ArrayList<IDLPortalFieldSpec>(tList.size);
                for (n = 0; n < tList.size; ++n) {
                    comparable = new IDLPortalFieldSpec();
                    ((IDLPortalFieldSpec)comparable).read((TProtocol)tTupleProtocol);
                    iDLLayoutSpec.portalFieldSpecs.add((IDLPortalFieldSpec)comparable);
                }
                iDLLayoutSpec.setPortalFieldSpecsIsSet(true);
            }
        }
    }

    private static class IDLLayoutSpecStandardScheme
    extends StandardScheme<IDLLayoutSpec> {
        private IDLLayoutSpecStandardScheme() {
        }

        public void read(TProtocol tProtocol, IDLLayoutSpec iDLLayoutSpec) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 11) {
                            iDLLayoutSpec.databaseName = tProtocol.readString();
                            iDLLayoutSpec.setDatabaseNameIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 12) {
                            iDLLayoutSpec.layoutInfo = new IDLItemInfo();
                            iDLLayoutSpec.layoutInfo.read(tProtocol);
                            iDLLayoutSpec.setLayoutInfoIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 11) {
                            iDLLayoutSpec.tableName = tProtocol.readString();
                            iDLLayoutSpec.setTableNameIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 10) {
                            iDLLayoutSpec.totalRecords = tProtocol.readI64();
                            iDLLayoutSpec.setTotalRecordsIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 5: {
                        Comparable<IDLFieldLaySpec> comparable;
                        int n;
                        TList tList;
                        if (tField.type == 15) {
                            tList = tProtocol.readListBegin();
                            iDLLayoutSpec.fieldLaySpecs = new ArrayList<IDLFieldLaySpec>(tList.size);
                            for (n = 0; n < tList.size; ++n) {
                                comparable = new IDLFieldLaySpec();
                                ((IDLFieldLaySpec)comparable).read(tProtocol);
                                iDLLayoutSpec.fieldLaySpecs.add((IDLFieldLaySpec)comparable);
                            }
                            tProtocol.readListEnd();
                            iDLLayoutSpec.setFieldLaySpecsIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 6: {
                        Comparable<IDLFieldLaySpec> comparable;
                        int n;
                        TList tList;
                        if (tField.type == 15) {
                            tList = tProtocol.readListBegin();
                            iDLLayoutSpec.portalFieldLaySpecs = new ArrayList<IDLPortalFieldLaySpec>(tList.size);
                            for (n = 0; n < tList.size; ++n) {
                                comparable = new IDLPortalFieldLaySpec();
                                ((IDLPortalFieldLaySpec)comparable).read(tProtocol);
                                iDLLayoutSpec.portalFieldLaySpecs.add((IDLPortalFieldLaySpec)comparable);
                            }
                            tProtocol.readListEnd();
                            iDLLayoutSpec.setPortalFieldLaySpecsIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 7: {
                        Comparable<IDLFieldLaySpec> comparable;
                        int n;
                        TList tList;
                        if (tField.type == 15) {
                            tList = tProtocol.readListBegin();
                            iDLLayoutSpec.valueLists = new ArrayList<IDLValueList>(tList.size);
                            for (n = 0; n < tList.size; ++n) {
                                comparable = new IDLValueList();
                                ((IDLValueList)comparable).read(tProtocol);
                                iDLLayoutSpec.valueLists.add((IDLValueList)comparable);
                            }
                            tProtocol.readListEnd();
                            iDLLayoutSpec.setValueListsIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 8: {
                        Comparable<IDLFieldLaySpec> comparable;
                        int n;
                        TList tList;
                        if (tField.type == 15) {
                            tList = tProtocol.readListBegin();
                            iDLLayoutSpec.fieldSpecs = new ArrayList<IDLFieldSpec>(tList.size);
                            for (n = 0; n < tList.size; ++n) {
                                comparable = new IDLFieldSpec();
                                ((IDLFieldSpec)comparable).read(tProtocol);
                                iDLLayoutSpec.fieldSpecs.add((IDLFieldSpec)comparable);
                            }
                            tProtocol.readListEnd();
                            iDLLayoutSpec.setFieldSpecsIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 9: {
                        Comparable<IDLFieldLaySpec> comparable;
                        int n;
                        TList tList;
                        if (tField.type == 15) {
                            tList = tProtocol.readListBegin();
                            iDLLayoutSpec.portalFieldSpecs = new ArrayList<IDLPortalFieldSpec>(tList.size);
                            for (n = 0; n < tList.size; ++n) {
                                comparable = new IDLPortalFieldSpec();
                                ((IDLPortalFieldSpec)comparable).read(tProtocol);
                                iDLLayoutSpec.portalFieldSpecs.add((IDLPortalFieldSpec)comparable);
                            }
                            tProtocol.readListEnd();
                            iDLLayoutSpec.setPortalFieldSpecsIsSet(true);
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
            iDLLayoutSpec.validate();
        }

        public void write(TProtocol tProtocol, IDLLayoutSpec iDLLayoutSpec) throws TException {
            iDLLayoutSpec.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (iDLLayoutSpec.databaseName != null) {
                tProtocol.writeFieldBegin(DATABASE_NAME_FIELD_DESC);
                tProtocol.writeString(iDLLayoutSpec.databaseName);
                tProtocol.writeFieldEnd();
            }
            if (iDLLayoutSpec.layoutInfo != null) {
                tProtocol.writeFieldBegin(LAYOUT_INFO_FIELD_DESC);
                iDLLayoutSpec.layoutInfo.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            if (iDLLayoutSpec.tableName != null) {
                tProtocol.writeFieldBegin(TABLE_NAME_FIELD_DESC);
                tProtocol.writeString(iDLLayoutSpec.tableName);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(TOTAL_RECORDS_FIELD_DESC);
            tProtocol.writeI64(iDLLayoutSpec.totalRecords);
            tProtocol.writeFieldEnd();
            if (iDLLayoutSpec.fieldLaySpecs != null) {
                tProtocol.writeFieldBegin(FIELD_LAY_SPECS_FIELD_DESC);
                tProtocol.writeListBegin(new TList(12, iDLLayoutSpec.fieldLaySpecs.size()));
                for (IDLFieldLaySpec comparable : iDLLayoutSpec.fieldLaySpecs) {
                    comparable.write(tProtocol);
                }
                tProtocol.writeListEnd();
                tProtocol.writeFieldEnd();
            }
            if (iDLLayoutSpec.portalFieldLaySpecs != null) {
                tProtocol.writeFieldBegin(PORTAL_FIELD_LAY_SPECS_FIELD_DESC);
                tProtocol.writeListBegin(new TList(12, iDLLayoutSpec.portalFieldLaySpecs.size()));
                for (IDLPortalFieldLaySpec iDLPortalFieldLaySpec : iDLLayoutSpec.portalFieldLaySpecs) {
                    iDLPortalFieldLaySpec.write(tProtocol);
                }
                tProtocol.writeListEnd();
                tProtocol.writeFieldEnd();
            }
            if (iDLLayoutSpec.valueLists != null) {
                tProtocol.writeFieldBegin(VALUE_LISTS_FIELD_DESC);
                tProtocol.writeListBegin(new TList(12, iDLLayoutSpec.valueLists.size()));
                for (IDLValueList iDLValueList : iDLLayoutSpec.valueLists) {
                    iDLValueList.write(tProtocol);
                }
                tProtocol.writeListEnd();
                tProtocol.writeFieldEnd();
            }
            if (iDLLayoutSpec.fieldSpecs != null) {
                tProtocol.writeFieldBegin(FIELD_SPECS_FIELD_DESC);
                tProtocol.writeListBegin(new TList(12, iDLLayoutSpec.fieldSpecs.size()));
                for (IDLFieldSpec iDLFieldSpec : iDLLayoutSpec.fieldSpecs) {
                    iDLFieldSpec.write(tProtocol);
                }
                tProtocol.writeListEnd();
                tProtocol.writeFieldEnd();
            }
            if (iDLLayoutSpec.portalFieldSpecs != null) {
                tProtocol.writeFieldBegin(PORTAL_FIELD_SPECS_FIELD_DESC);
                tProtocol.writeListBegin(new TList(12, iDLLayoutSpec.portalFieldSpecs.size()));
                for (IDLPortalFieldSpec iDLPortalFieldSpec : iDLLayoutSpec.portalFieldSpecs) {
                    iDLPortalFieldSpec.write(tProtocol);
                }
                tProtocol.writeListEnd();
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

