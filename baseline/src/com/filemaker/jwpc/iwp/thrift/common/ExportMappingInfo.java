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

import com.filemaker.jwpc.iwp.thrift.common.ExportGroupByInfo;
import com.filemaker.jwpc.iwp.thrift.common.FieldDefinition;
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

public class ExportMappingInfo
implements TBase<ExportMappingInfo, _Fields>,
Serializable,
Cloneable,
Comparable<ExportMappingInfo> {
    private static final TStruct STRUCT_DESC = new TStruct("ExportMappingInfo");
    private static final TField FIELD_LIST_FIELD_DESC = new TField("fieldList", 15, 1);
    private static final TField GROUP_BY_LIST_FIELD_DESC = new TField("groupByList", 15, 2);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new ExportMappingInfoStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new ExportMappingInfoTupleSchemeFactory();
    @Nullable
    private List<FieldDefinition> fieldList;
    @Nullable
    private List<ExportGroupByInfo> groupByList;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public ExportMappingInfo() {
    }

    public ExportMappingInfo(List<FieldDefinition> list, List<ExportGroupByInfo> list2) {
        this();
        this.fieldList = list;
        this.groupByList = list2;
    }

    public ExportMappingInfo(ExportMappingInfo exportMappingInfo) {
        ArrayList<FieldDefinition> arrayList;
        if (exportMappingInfo.isSetFieldList()) {
            arrayList = new ArrayList<FieldDefinition>(exportMappingInfo.fieldList.size());
            for (FieldDefinition comparable : exportMappingInfo.fieldList) {
                arrayList.add(new FieldDefinition(comparable));
            }
            this.fieldList = arrayList;
        }
        if (exportMappingInfo.isSetGroupByList()) {
            arrayList = new ArrayList(exportMappingInfo.groupByList.size());
            for (ExportGroupByInfo exportGroupByInfo : exportMappingInfo.groupByList) {
                arrayList.add((FieldDefinition)((Object)new ExportGroupByInfo(exportGroupByInfo)));
            }
            this.groupByList = arrayList;
        }
    }

    public ExportMappingInfo deepCopy() {
        return new ExportMappingInfo(this);
    }

    public void clear() {
        this.fieldList = null;
        this.groupByList = null;
    }

    public int getFieldListSize() {
        return this.fieldList == null ? 0 : this.fieldList.size();
    }

    @Nullable
    public Iterator<FieldDefinition> getFieldListIterator() {
        return this.fieldList == null ? null : this.fieldList.iterator();
    }

    public void addToFieldList(FieldDefinition fieldDefinition) {
        if (this.fieldList == null) {
            this.fieldList = new ArrayList<FieldDefinition>();
        }
        this.fieldList.add(fieldDefinition);
    }

    @Nullable
    public List<FieldDefinition> getFieldList() {
        return this.fieldList;
    }

    public void setFieldList(@Nullable List<FieldDefinition> list) {
        this.fieldList = list;
    }

    public void unsetFieldList() {
        this.fieldList = null;
    }

    public boolean isSetFieldList() {
        return this.fieldList != null;
    }

    public void setFieldListIsSet(boolean bl) {
        if (!bl) {
            this.fieldList = null;
        }
    }

    public int getGroupByListSize() {
        return this.groupByList == null ? 0 : this.groupByList.size();
    }

    @Nullable
    public Iterator<ExportGroupByInfo> getGroupByListIterator() {
        return this.groupByList == null ? null : this.groupByList.iterator();
    }

    public void addToGroupByList(ExportGroupByInfo exportGroupByInfo) {
        if (this.groupByList == null) {
            this.groupByList = new ArrayList<ExportGroupByInfo>();
        }
        this.groupByList.add(exportGroupByInfo);
    }

    @Nullable
    public List<ExportGroupByInfo> getGroupByList() {
        return this.groupByList;
    }

    public void setGroupByList(@Nullable List<ExportGroupByInfo> list) {
        this.groupByList = list;
    }

    public void unsetGroupByList() {
        this.groupByList = null;
    }

    public boolean isSetGroupByList() {
        return this.groupByList != null;
    }

    public void setGroupByListIsSet(boolean bl) {
        if (!bl) {
            this.groupByList = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetFieldList();
                    break;
                }
                this.setFieldList((List)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetGroupByList();
                    break;
                }
                this.setGroupByList((List)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getFieldList();
            }
            case 1: {
                return this.getGroupByList();
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
                return this.isSetFieldList();
            }
            case 1: {
                return this.isSetGroupByList();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof ExportMappingInfo) {
            return this.equals((ExportMappingInfo)object);
        }
        return false;
    }

    public boolean equals(ExportMappingInfo exportMappingInfo) {
        if (exportMappingInfo == null) {
            return false;
        }
        if (this == exportMappingInfo) {
            return true;
        }
        boolean bl = this.isSetFieldList();
        boolean bl2 = exportMappingInfo.isSetFieldList();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.fieldList.equals(exportMappingInfo.fieldList)) {
                return false;
            }
        }
        boolean bl3 = this.isSetGroupByList();
        boolean bl4 = exportMappingInfo.isSetGroupByList();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.groupByList.equals(exportMappingInfo.groupByList)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetFieldList() ? 131071 : 524287);
        if (this.isSetFieldList()) {
            n = n * 8191 + this.fieldList.hashCode();
        }
        n = n * 8191 + (this.isSetGroupByList() ? 131071 : 524287);
        if (this.isSetGroupByList()) {
            n = n * 8191 + this.groupByList.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(ExportMappingInfo exportMappingInfo) {
        if (!this.getClass().equals(exportMappingInfo.getClass())) {
            return this.getClass().getName().compareTo(exportMappingInfo.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetFieldList(), exportMappingInfo.isSetFieldList());
        if (n != 0) {
            return n;
        }
        if (this.isSetFieldList() && (n = TBaseHelper.compareTo(this.fieldList, exportMappingInfo.fieldList)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetGroupByList(), exportMappingInfo.isSetGroupByList());
        if (n != 0) {
            return n;
        }
        if (this.isSetGroupByList() && (n = TBaseHelper.compareTo(this.groupByList, exportMappingInfo.groupByList)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        ExportMappingInfo.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        ExportMappingInfo.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ExportMappingInfo(");
        boolean bl = true;
        stringBuilder.append("fieldList:");
        if (this.fieldList == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.fieldList);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("groupByList:");
        if (this.groupByList == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.groupByList);
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
        enumMap.put(_Fields.FIELD_LIST, new FieldMetaData("fieldList", 3, (FieldValueMetaData)new ListMetaData(15, (FieldValueMetaData)new StructMetaData(12, FieldDefinition.class))));
        enumMap.put(_Fields.GROUP_BY_LIST, new FieldMetaData("groupByList", 3, (FieldValueMetaData)new ListMetaData(15, (FieldValueMetaData)new StructMetaData(12, ExportGroupByInfo.class))));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(ExportMappingInfo.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        FIELD_LIST(1, "fieldList"),
        GROUP_BY_LIST(2, "groupByList");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return FIELD_LIST;
                }
                case 2: {
                    return GROUP_BY_LIST;
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

    private static class ExportMappingInfoStandardSchemeFactory
    implements SchemeFactory {
        private ExportMappingInfoStandardSchemeFactory() {
        }

        public ExportMappingInfoStandardScheme getScheme() {
            return new ExportMappingInfoStandardScheme();
        }
    }

    private static class ExportMappingInfoTupleSchemeFactory
    implements SchemeFactory {
        private ExportMappingInfoTupleSchemeFactory() {
        }

        public ExportMappingInfoTupleScheme getScheme() {
            return new ExportMappingInfoTupleScheme();
        }
    }

    private static class ExportMappingInfoTupleScheme
    extends TupleScheme<ExportMappingInfo> {
        private ExportMappingInfoTupleScheme() {
        }

        public void write(TProtocol tProtocol, ExportMappingInfo exportMappingInfo) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (exportMappingInfo.isSetFieldList()) {
                bitSet.set(0);
            }
            if (exportMappingInfo.isSetGroupByList()) {
                bitSet.set(1);
            }
            tTupleProtocol.writeBitSet(bitSet, 2);
            if (exportMappingInfo.isSetFieldList()) {
                tTupleProtocol.writeI32(exportMappingInfo.fieldList.size());
                for (FieldDefinition comparable : exportMappingInfo.fieldList) {
                    comparable.write((TProtocol)tTupleProtocol);
                }
            }
            if (exportMappingInfo.isSetGroupByList()) {
                tTupleProtocol.writeI32(exportMappingInfo.groupByList.size());
                for (ExportGroupByInfo exportGroupByInfo : exportMappingInfo.groupByList) {
                    exportGroupByInfo.write((TProtocol)tTupleProtocol);
                }
            }
        }

        public void read(TProtocol tProtocol, ExportMappingInfo exportMappingInfo) throws TException {
            Comparable<FieldDefinition> comparable;
            int n;
            TList tList;
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(2);
            if (bitSet.get(0)) {
                tList = tTupleProtocol.readListBegin((byte)12);
                exportMappingInfo.fieldList = new ArrayList<FieldDefinition>(tList.size);
                for (n = 0; n < tList.size; ++n) {
                    comparable = new FieldDefinition();
                    ((FieldDefinition)comparable).read((TProtocol)tTupleProtocol);
                    exportMappingInfo.fieldList.add((FieldDefinition)comparable);
                }
                exportMappingInfo.setFieldListIsSet(true);
            }
            if (bitSet.get(1)) {
                tList = tTupleProtocol.readListBegin((byte)12);
                exportMappingInfo.groupByList = new ArrayList<ExportGroupByInfo>(tList.size);
                for (n = 0; n < tList.size; ++n) {
                    comparable = new ExportGroupByInfo();
                    ((ExportGroupByInfo)comparable).read((TProtocol)tTupleProtocol);
                    exportMappingInfo.groupByList.add((ExportGroupByInfo)comparable);
                }
                exportMappingInfo.setGroupByListIsSet(true);
            }
        }
    }

    private static class ExportMappingInfoStandardScheme
    extends StandardScheme<ExportMappingInfo> {
        private ExportMappingInfoStandardScheme() {
        }

        public void read(TProtocol tProtocol, ExportMappingInfo exportMappingInfo) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        Comparable<FieldDefinition> comparable;
                        int n;
                        TList tList;
                        if (tField.type == 15) {
                            tList = tProtocol.readListBegin();
                            exportMappingInfo.fieldList = new ArrayList<FieldDefinition>(tList.size);
                            for (n = 0; n < tList.size; ++n) {
                                comparable = new FieldDefinition();
                                ((FieldDefinition)comparable).read(tProtocol);
                                exportMappingInfo.fieldList.add((FieldDefinition)comparable);
                            }
                            tProtocol.readListEnd();
                            exportMappingInfo.setFieldListIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        Comparable<FieldDefinition> comparable;
                        int n;
                        TList tList;
                        if (tField.type == 15) {
                            tList = tProtocol.readListBegin();
                            exportMappingInfo.groupByList = new ArrayList<ExportGroupByInfo>(tList.size);
                            for (n = 0; n < tList.size; ++n) {
                                comparable = new ExportGroupByInfo();
                                ((ExportGroupByInfo)comparable).read(tProtocol);
                                exportMappingInfo.groupByList.add((ExportGroupByInfo)comparable);
                            }
                            tProtocol.readListEnd();
                            exportMappingInfo.setGroupByListIsSet(true);
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
            exportMappingInfo.validate();
        }

        public void write(TProtocol tProtocol, ExportMappingInfo exportMappingInfo) throws TException {
            exportMappingInfo.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (exportMappingInfo.fieldList != null) {
                tProtocol.writeFieldBegin(FIELD_LIST_FIELD_DESC);
                tProtocol.writeListBegin(new TList(12, exportMappingInfo.fieldList.size()));
                for (FieldDefinition comparable : exportMappingInfo.fieldList) {
                    comparable.write(tProtocol);
                }
                tProtocol.writeListEnd();
                tProtocol.writeFieldEnd();
            }
            if (exportMappingInfo.groupByList != null) {
                tProtocol.writeFieldBegin(GROUP_BY_LIST_FIELD_DESC);
                tProtocol.writeListBegin(new TList(12, exportMappingInfo.groupByList.size()));
                for (ExportGroupByInfo exportGroupByInfo : exportMappingInfo.groupByList) {
                    exportGroupByInfo.write(tProtocol);
                }
                tProtocol.writeListEnd();
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

