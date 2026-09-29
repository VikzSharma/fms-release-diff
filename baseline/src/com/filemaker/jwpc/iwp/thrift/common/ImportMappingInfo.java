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
package com.filemaker.jwpc.iwp.thrift.common;

import com.filemaker.jwpc.iwp.thrift.common.ImportAction;
import com.filemaker.jwpc.iwp.thrift.common.ImportMappingDefinition;
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

public class ImportMappingInfo
implements TBase<ImportMappingInfo, _Fields>,
Serializable,
Cloneable,
Comparable<ImportMappingInfo> {
    private static final TStruct STRUCT_DESC = new TStruct("ImportMappingInfo");
    private static final TField ACTION_FIELD_DESC = new TField("action", 8, 1);
    private static final TField MAPPING_LIST_FIELD_DESC = new TField("mappingList", 15, 2);
    private static final TField FIRST_ROW_DATA_FIELD_DESC = new TField("firstRowData", 2, 3);
    private static final TField FIRST_ROW_IS_DATA_SELECTION_ENABLED_FIELD_DESC = new TField("firstRowIsDataSelectionEnabled", 2, 4);
    private static final TField ADD_REMAINING_NEW_FIELD_DESC = new TField("addRemainingNew", 2, 5);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new ImportMappingInfoStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new ImportMappingInfoTupleSchemeFactory();
    @Nullable
    private ImportAction action;
    @Nullable
    private List<ImportMappingDefinition> mappingList;
    private boolean firstRowData;
    private boolean firstRowIsDataSelectionEnabled;
    private boolean addRemainingNew;
    private static final int __FIRSTROWDATA_ISSET_ID = 0;
    private static final int __FIRSTROWISDATASELECTIONENABLED_ISSET_ID = 1;
    private static final int __ADDREMAININGNEW_ISSET_ID = 2;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public ImportMappingInfo() {
    }

    public ImportMappingInfo(ImportAction importAction, List<ImportMappingDefinition> list, boolean bl, boolean bl2, boolean bl3) {
        this();
        this.action = importAction;
        this.mappingList = list;
        this.firstRowData = bl;
        this.setFirstRowDataIsSet(true);
        this.firstRowIsDataSelectionEnabled = bl2;
        this.setFirstRowIsDataSelectionEnabledIsSet(true);
        this.addRemainingNew = bl3;
        this.setAddRemainingNewIsSet(true);
    }

    public ImportMappingInfo(ImportMappingInfo importMappingInfo) {
        this.__isset_bitfield = importMappingInfo.__isset_bitfield;
        if (importMappingInfo.isSetAction()) {
            this.action = importMappingInfo.action;
        }
        if (importMappingInfo.isSetMappingList()) {
            ArrayList<ImportMappingDefinition> arrayList = new ArrayList<ImportMappingDefinition>(importMappingInfo.mappingList.size());
            for (ImportMappingDefinition importMappingDefinition : importMappingInfo.mappingList) {
                arrayList.add(new ImportMappingDefinition(importMappingDefinition));
            }
            this.mappingList = arrayList;
        }
        this.firstRowData = importMappingInfo.firstRowData;
        this.firstRowIsDataSelectionEnabled = importMappingInfo.firstRowIsDataSelectionEnabled;
        this.addRemainingNew = importMappingInfo.addRemainingNew;
    }

    public ImportMappingInfo deepCopy() {
        return new ImportMappingInfo(this);
    }

    public void clear() {
        this.action = null;
        this.mappingList = null;
        this.setFirstRowDataIsSet(false);
        this.firstRowData = false;
        this.setFirstRowIsDataSelectionEnabledIsSet(false);
        this.firstRowIsDataSelectionEnabled = false;
        this.setAddRemainingNewIsSet(false);
        this.addRemainingNew = false;
    }

    @Nullable
    public ImportAction getAction() {
        return this.action;
    }

    public void setAction(@Nullable ImportAction importAction) {
        this.action = importAction;
    }

    public void unsetAction() {
        this.action = null;
    }

    public boolean isSetAction() {
        return this.action != null;
    }

    public void setActionIsSet(boolean bl) {
        if (!bl) {
            this.action = null;
        }
    }

    public int getMappingListSize() {
        return this.mappingList == null ? 0 : this.mappingList.size();
    }

    @Nullable
    public Iterator<ImportMappingDefinition> getMappingListIterator() {
        return this.mappingList == null ? null : this.mappingList.iterator();
    }

    public void addToMappingList(ImportMappingDefinition importMappingDefinition) {
        if (this.mappingList == null) {
            this.mappingList = new ArrayList<ImportMappingDefinition>();
        }
        this.mappingList.add(importMappingDefinition);
    }

    @Nullable
    public List<ImportMappingDefinition> getMappingList() {
        return this.mappingList;
    }

    public void setMappingList(@Nullable List<ImportMappingDefinition> list) {
        this.mappingList = list;
    }

    public void unsetMappingList() {
        this.mappingList = null;
    }

    public boolean isSetMappingList() {
        return this.mappingList != null;
    }

    public void setMappingListIsSet(boolean bl) {
        if (!bl) {
            this.mappingList = null;
        }
    }

    public boolean isFirstRowData() {
        return this.firstRowData;
    }

    public void setFirstRowData(boolean bl) {
        this.firstRowData = bl;
        this.setFirstRowDataIsSet(true);
    }

    public void unsetFirstRowData() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetFirstRowData() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setFirstRowDataIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public boolean isFirstRowIsDataSelectionEnabled() {
        return this.firstRowIsDataSelectionEnabled;
    }

    public void setFirstRowIsDataSelectionEnabled(boolean bl) {
        this.firstRowIsDataSelectionEnabled = bl;
        this.setFirstRowIsDataSelectionEnabledIsSet(true);
    }

    public void unsetFirstRowIsDataSelectionEnabled() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)1);
    }

    public boolean isSetFirstRowIsDataSelectionEnabled() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)1);
    }

    public void setFirstRowIsDataSelectionEnabledIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)1, (boolean)bl);
    }

    public boolean isAddRemainingNew() {
        return this.addRemainingNew;
    }

    public void setAddRemainingNew(boolean bl) {
        this.addRemainingNew = bl;
        this.setAddRemainingNewIsSet(true);
    }

    public void unsetAddRemainingNew() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)2);
    }

    public boolean isSetAddRemainingNew() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)2);
    }

    public void setAddRemainingNewIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)2, (boolean)bl);
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetAction();
                    break;
                }
                this.setAction((ImportAction)((Object)object));
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetMappingList();
                    break;
                }
                this.setMappingList((List)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetFirstRowData();
                    break;
                }
                this.setFirstRowData((Boolean)object);
                break;
            }
            case 3: {
                if (object == null) {
                    this.unsetFirstRowIsDataSelectionEnabled();
                    break;
                }
                this.setFirstRowIsDataSelectionEnabled((Boolean)object);
                break;
            }
            case 4: {
                if (object == null) {
                    this.unsetAddRemainingNew();
                    break;
                }
                this.setAddRemainingNew((Boolean)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getAction();
            }
            case 1: {
                return this.getMappingList();
            }
            case 2: {
                return this.isFirstRowData();
            }
            case 3: {
                return this.isFirstRowIsDataSelectionEnabled();
            }
            case 4: {
                return this.isAddRemainingNew();
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
                return this.isSetAction();
            }
            case 1: {
                return this.isSetMappingList();
            }
            case 2: {
                return this.isSetFirstRowData();
            }
            case 3: {
                return this.isSetFirstRowIsDataSelectionEnabled();
            }
            case 4: {
                return this.isSetAddRemainingNew();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof ImportMappingInfo) {
            return this.equals((ImportMappingInfo)object);
        }
        return false;
    }

    public boolean equals(ImportMappingInfo importMappingInfo) {
        if (importMappingInfo == null) {
            return false;
        }
        if (this == importMappingInfo) {
            return true;
        }
        boolean bl = this.isSetAction();
        boolean bl2 = importMappingInfo.isSetAction();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.action.equals((Object)importMappingInfo.action)) {
                return false;
            }
        }
        boolean bl3 = this.isSetMappingList();
        boolean bl4 = importMappingInfo.isSetMappingList();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.mappingList.equals(importMappingInfo.mappingList)) {
                return false;
            }
        }
        boolean bl5 = true;
        boolean bl6 = true;
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (this.firstRowData != importMappingInfo.firstRowData) {
                return false;
            }
        }
        boolean bl7 = true;
        boolean bl8 = true;
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (this.firstRowIsDataSelectionEnabled != importMappingInfo.firstRowIsDataSelectionEnabled) {
                return false;
            }
        }
        boolean bl9 = true;
        boolean bl10 = true;
        if (bl9 || bl10) {
            if (!bl9 || !bl10) {
                return false;
            }
            if (this.addRemainingNew != importMappingInfo.addRemainingNew) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetAction() ? 131071 : 524287);
        if (this.isSetAction()) {
            n = n * 8191 + this.action.getValue();
        }
        n = n * 8191 + (this.isSetMappingList() ? 131071 : 524287);
        if (this.isSetMappingList()) {
            n = n * 8191 + this.mappingList.hashCode();
        }
        n = n * 8191 + (this.firstRowData ? 131071 : 524287);
        n = n * 8191 + (this.firstRowIsDataSelectionEnabled ? 131071 : 524287);
        n = n * 8191 + (this.addRemainingNew ? 131071 : 524287);
        return n;
    }

    @Override
    public int compareTo(ImportMappingInfo importMappingInfo) {
        if (!this.getClass().equals(importMappingInfo.getClass())) {
            return this.getClass().getName().compareTo(importMappingInfo.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetAction(), importMappingInfo.isSetAction());
        if (n != 0) {
            return n;
        }
        if (this.isSetAction() && (n = TBaseHelper.compareTo((Comparable)((Object)this.action), (Comparable)((Object)importMappingInfo.action))) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetMappingList(), importMappingInfo.isSetMappingList());
        if (n != 0) {
            return n;
        }
        if (this.isSetMappingList() && (n = TBaseHelper.compareTo(this.mappingList, importMappingInfo.mappingList)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetFirstRowData(), importMappingInfo.isSetFirstRowData());
        if (n != 0) {
            return n;
        }
        if (this.isSetFirstRowData() && (n = TBaseHelper.compareTo((boolean)this.firstRowData, (boolean)importMappingInfo.firstRowData)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetFirstRowIsDataSelectionEnabled(), importMappingInfo.isSetFirstRowIsDataSelectionEnabled());
        if (n != 0) {
            return n;
        }
        if (this.isSetFirstRowIsDataSelectionEnabled() && (n = TBaseHelper.compareTo((boolean)this.firstRowIsDataSelectionEnabled, (boolean)importMappingInfo.firstRowIsDataSelectionEnabled)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetAddRemainingNew(), importMappingInfo.isSetAddRemainingNew());
        if (n != 0) {
            return n;
        }
        if (this.isSetAddRemainingNew() && (n = TBaseHelper.compareTo((boolean)this.addRemainingNew, (boolean)importMappingInfo.addRemainingNew)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        ImportMappingInfo.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        ImportMappingInfo.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ImportMappingInfo(");
        boolean bl = true;
        stringBuilder.append("action:");
        if (this.action == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append((Object)this.action);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("mappingList:");
        if (this.mappingList == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.mappingList);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("firstRowData:");
        stringBuilder.append(this.firstRowData);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("firstRowIsDataSelectionEnabled:");
        stringBuilder.append(this.firstRowIsDataSelectionEnabled);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("addRemainingNew:");
        stringBuilder.append(this.addRemainingNew);
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
        enumMap.put(_Fields.ACTION, new FieldMetaData("action", 3, (FieldValueMetaData)new EnumMetaData(-1, ImportAction.class)));
        enumMap.put(_Fields.MAPPING_LIST, new FieldMetaData("mappingList", 3, (FieldValueMetaData)new ListMetaData(15, (FieldValueMetaData)new StructMetaData(12, ImportMappingDefinition.class))));
        enumMap.put(_Fields.FIRST_ROW_DATA, new FieldMetaData("firstRowData", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.FIRST_ROW_IS_DATA_SELECTION_ENABLED, new FieldMetaData("firstRowIsDataSelectionEnabled", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.ADD_REMAINING_NEW, new FieldMetaData("addRemainingNew", 3, new FieldValueMetaData(2)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(ImportMappingInfo.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        ACTION(1, "action"),
        MAPPING_LIST(2, "mappingList"),
        FIRST_ROW_DATA(3, "firstRowData"),
        FIRST_ROW_IS_DATA_SELECTION_ENABLED(4, "firstRowIsDataSelectionEnabled"),
        ADD_REMAINING_NEW(5, "addRemainingNew");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return ACTION;
                }
                case 2: {
                    return MAPPING_LIST;
                }
                case 3: {
                    return FIRST_ROW_DATA;
                }
                case 4: {
                    return FIRST_ROW_IS_DATA_SELECTION_ENABLED;
                }
                case 5: {
                    return ADD_REMAINING_NEW;
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

    private static class ImportMappingInfoStandardSchemeFactory
    implements SchemeFactory {
        private ImportMappingInfoStandardSchemeFactory() {
        }

        public ImportMappingInfoStandardScheme getScheme() {
            return new ImportMappingInfoStandardScheme();
        }
    }

    private static class ImportMappingInfoTupleSchemeFactory
    implements SchemeFactory {
        private ImportMappingInfoTupleSchemeFactory() {
        }

        public ImportMappingInfoTupleScheme getScheme() {
            return new ImportMappingInfoTupleScheme();
        }
    }

    private static class ImportMappingInfoTupleScheme
    extends TupleScheme<ImportMappingInfo> {
        private ImportMappingInfoTupleScheme() {
        }

        public void write(TProtocol tProtocol, ImportMappingInfo importMappingInfo) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (importMappingInfo.isSetAction()) {
                bitSet.set(0);
            }
            if (importMappingInfo.isSetMappingList()) {
                bitSet.set(1);
            }
            if (importMappingInfo.isSetFirstRowData()) {
                bitSet.set(2);
            }
            if (importMappingInfo.isSetFirstRowIsDataSelectionEnabled()) {
                bitSet.set(3);
            }
            if (importMappingInfo.isSetAddRemainingNew()) {
                bitSet.set(4);
            }
            tTupleProtocol.writeBitSet(bitSet, 5);
            if (importMappingInfo.isSetAction()) {
                tTupleProtocol.writeI32(importMappingInfo.action.getValue());
            }
            if (importMappingInfo.isSetMappingList()) {
                tTupleProtocol.writeI32(importMappingInfo.mappingList.size());
                for (ImportMappingDefinition importMappingDefinition : importMappingInfo.mappingList) {
                    importMappingDefinition.write((TProtocol)tTupleProtocol);
                }
            }
            if (importMappingInfo.isSetFirstRowData()) {
                tTupleProtocol.writeBool(importMappingInfo.firstRowData);
            }
            if (importMappingInfo.isSetFirstRowIsDataSelectionEnabled()) {
                tTupleProtocol.writeBool(importMappingInfo.firstRowIsDataSelectionEnabled);
            }
            if (importMappingInfo.isSetAddRemainingNew()) {
                tTupleProtocol.writeBool(importMappingInfo.addRemainingNew);
            }
        }

        public void read(TProtocol tProtocol, ImportMappingInfo importMappingInfo) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(5);
            if (bitSet.get(0)) {
                importMappingInfo.action = ImportAction.findByValue(tTupleProtocol.readI32());
                importMappingInfo.setActionIsSet(true);
            }
            if (bitSet.get(1)) {
                TList tList = tTupleProtocol.readListBegin((byte)12);
                importMappingInfo.mappingList = new ArrayList<ImportMappingDefinition>(tList.size);
                for (int i = 0; i < tList.size; ++i) {
                    ImportMappingDefinition importMappingDefinition = new ImportMappingDefinition();
                    importMappingDefinition.read((TProtocol)tTupleProtocol);
                    importMappingInfo.mappingList.add(importMappingDefinition);
                }
                importMappingInfo.setMappingListIsSet(true);
            }
            if (bitSet.get(2)) {
                importMappingInfo.firstRowData = tTupleProtocol.readBool();
                importMappingInfo.setFirstRowDataIsSet(true);
            }
            if (bitSet.get(3)) {
                importMappingInfo.firstRowIsDataSelectionEnabled = tTupleProtocol.readBool();
                importMappingInfo.setFirstRowIsDataSelectionEnabledIsSet(true);
            }
            if (bitSet.get(4)) {
                importMappingInfo.addRemainingNew = tTupleProtocol.readBool();
                importMappingInfo.setAddRemainingNewIsSet(true);
            }
        }
    }

    private static class ImportMappingInfoStandardScheme
    extends StandardScheme<ImportMappingInfo> {
        private ImportMappingInfoStandardScheme() {
        }

        public void read(TProtocol tProtocol, ImportMappingInfo importMappingInfo) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 8) {
                            importMappingInfo.action = ImportAction.findByValue(tProtocol.readI32());
                            importMappingInfo.setActionIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 15) {
                            TList tList = tProtocol.readListBegin();
                            importMappingInfo.mappingList = new ArrayList<ImportMappingDefinition>(tList.size);
                            for (int i = 0; i < tList.size; ++i) {
                                ImportMappingDefinition importMappingDefinition = new ImportMappingDefinition();
                                importMappingDefinition.read(tProtocol);
                                importMappingInfo.mappingList.add(importMappingDefinition);
                            }
                            tProtocol.readListEnd();
                            importMappingInfo.setMappingListIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 2) {
                            importMappingInfo.firstRowData = tProtocol.readBool();
                            importMappingInfo.setFirstRowDataIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 2) {
                            importMappingInfo.firstRowIsDataSelectionEnabled = tProtocol.readBool();
                            importMappingInfo.setFirstRowIsDataSelectionEnabledIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 5: {
                        if (tField.type == 2) {
                            importMappingInfo.addRemainingNew = tProtocol.readBool();
                            importMappingInfo.setAddRemainingNewIsSet(true);
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
            importMappingInfo.validate();
        }

        public void write(TProtocol tProtocol, ImportMappingInfo importMappingInfo) throws TException {
            importMappingInfo.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (importMappingInfo.action != null) {
                tProtocol.writeFieldBegin(ACTION_FIELD_DESC);
                tProtocol.writeI32(importMappingInfo.action.getValue());
                tProtocol.writeFieldEnd();
            }
            if (importMappingInfo.mappingList != null) {
                tProtocol.writeFieldBegin(MAPPING_LIST_FIELD_DESC);
                tProtocol.writeListBegin(new TList(12, importMappingInfo.mappingList.size()));
                for (ImportMappingDefinition importMappingDefinition : importMappingInfo.mappingList) {
                    importMappingDefinition.write(tProtocol);
                }
                tProtocol.writeListEnd();
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(FIRST_ROW_DATA_FIELD_DESC);
            tProtocol.writeBool(importMappingInfo.firstRowData);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(FIRST_ROW_IS_DATA_SELECTION_ENABLED_FIELD_DESC);
            tProtocol.writeBool(importMappingInfo.firstRowIsDataSelectionEnabled);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(ADD_REMAINING_NEW_FIELD_DESC);
            tProtocol.writeBool(importMappingInfo.addRemainingNew);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

