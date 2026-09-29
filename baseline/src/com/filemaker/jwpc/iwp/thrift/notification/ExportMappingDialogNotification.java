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
package com.filemaker.jwpc.iwp.thrift.notification;

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

public class ExportMappingDialogNotification
implements TBase<ExportMappingDialogNotification, _Fields>,
Serializable,
Cloneable,
Comparable<ExportMappingDialogNotification> {
    private static final TStruct STRUCT_DESC = new TStruct("ExportMappingDialogNotification");
    private static final TField FIELD_LIST_FIELD_DESC = new TField("fieldList", 15, 1);
    private static final TField GROUP_BY_INFO_LIST_FIELD_DESC = new TField("groupByInfoList", 15, 2);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new ExportMappingDialogNotificationStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new ExportMappingDialogNotificationTupleSchemeFactory();
    @Nullable
    private List<FieldDefinition> fieldList;
    @Nullable
    private List<ExportGroupByInfo> groupByInfoList;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public ExportMappingDialogNotification() {
    }

    public ExportMappingDialogNotification(List<FieldDefinition> list, List<ExportGroupByInfo> list2) {
        this();
        this.fieldList = list;
        this.groupByInfoList = list2;
    }

    public ExportMappingDialogNotification(ExportMappingDialogNotification exportMappingDialogNotification) {
        ArrayList<FieldDefinition> arrayList;
        if (exportMappingDialogNotification.isSetFieldList()) {
            arrayList = new ArrayList<FieldDefinition>(exportMappingDialogNotification.fieldList.size());
            for (FieldDefinition comparable : exportMappingDialogNotification.fieldList) {
                arrayList.add(new FieldDefinition(comparable));
            }
            this.fieldList = arrayList;
        }
        if (exportMappingDialogNotification.isSetGroupByInfoList()) {
            arrayList = new ArrayList(exportMappingDialogNotification.groupByInfoList.size());
            for (ExportGroupByInfo exportGroupByInfo : exportMappingDialogNotification.groupByInfoList) {
                arrayList.add((FieldDefinition)((Object)new ExportGroupByInfo(exportGroupByInfo)));
            }
            this.groupByInfoList = arrayList;
        }
    }

    public ExportMappingDialogNotification deepCopy() {
        return new ExportMappingDialogNotification(this);
    }

    public void clear() {
        this.fieldList = null;
        this.groupByInfoList = null;
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

    public int getGroupByInfoListSize() {
        return this.groupByInfoList == null ? 0 : this.groupByInfoList.size();
    }

    @Nullable
    public Iterator<ExportGroupByInfo> getGroupByInfoListIterator() {
        return this.groupByInfoList == null ? null : this.groupByInfoList.iterator();
    }

    public void addToGroupByInfoList(ExportGroupByInfo exportGroupByInfo) {
        if (this.groupByInfoList == null) {
            this.groupByInfoList = new ArrayList<ExportGroupByInfo>();
        }
        this.groupByInfoList.add(exportGroupByInfo);
    }

    @Nullable
    public List<ExportGroupByInfo> getGroupByInfoList() {
        return this.groupByInfoList;
    }

    public void setGroupByInfoList(@Nullable List<ExportGroupByInfo> list) {
        this.groupByInfoList = list;
    }

    public void unsetGroupByInfoList() {
        this.groupByInfoList = null;
    }

    public boolean isSetGroupByInfoList() {
        return this.groupByInfoList != null;
    }

    public void setGroupByInfoListIsSet(boolean bl) {
        if (!bl) {
            this.groupByInfoList = null;
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
                    this.unsetGroupByInfoList();
                    break;
                }
                this.setGroupByInfoList((List)object);
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
                return this.getGroupByInfoList();
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
                return this.isSetGroupByInfoList();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof ExportMappingDialogNotification) {
            return this.equals((ExportMappingDialogNotification)object);
        }
        return false;
    }

    public boolean equals(ExportMappingDialogNotification exportMappingDialogNotification) {
        if (exportMappingDialogNotification == null) {
            return false;
        }
        if (this == exportMappingDialogNotification) {
            return true;
        }
        boolean bl = this.isSetFieldList();
        boolean bl2 = exportMappingDialogNotification.isSetFieldList();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.fieldList.equals(exportMappingDialogNotification.fieldList)) {
                return false;
            }
        }
        boolean bl3 = this.isSetGroupByInfoList();
        boolean bl4 = exportMappingDialogNotification.isSetGroupByInfoList();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.groupByInfoList.equals(exportMappingDialogNotification.groupByInfoList)) {
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
        n = n * 8191 + (this.isSetGroupByInfoList() ? 131071 : 524287);
        if (this.isSetGroupByInfoList()) {
            n = n * 8191 + this.groupByInfoList.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(ExportMappingDialogNotification exportMappingDialogNotification) {
        if (!this.getClass().equals(exportMappingDialogNotification.getClass())) {
            return this.getClass().getName().compareTo(exportMappingDialogNotification.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetFieldList(), exportMappingDialogNotification.isSetFieldList());
        if (n != 0) {
            return n;
        }
        if (this.isSetFieldList() && (n = TBaseHelper.compareTo(this.fieldList, exportMappingDialogNotification.fieldList)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetGroupByInfoList(), exportMappingDialogNotification.isSetGroupByInfoList());
        if (n != 0) {
            return n;
        }
        if (this.isSetGroupByInfoList() && (n = TBaseHelper.compareTo(this.groupByInfoList, exportMappingDialogNotification.groupByInfoList)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        ExportMappingDialogNotification.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        ExportMappingDialogNotification.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ExportMappingDialogNotification(");
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
        stringBuilder.append("groupByInfoList:");
        if (this.groupByInfoList == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.groupByInfoList);
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
        enumMap.put(_Fields.GROUP_BY_INFO_LIST, new FieldMetaData("groupByInfoList", 3, (FieldValueMetaData)new ListMetaData(15, (FieldValueMetaData)new StructMetaData(12, ExportGroupByInfo.class))));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(ExportMappingDialogNotification.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        FIELD_LIST(1, "fieldList"),
        GROUP_BY_INFO_LIST(2, "groupByInfoList");

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
                    return GROUP_BY_INFO_LIST;
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

    private static class ExportMappingDialogNotificationStandardSchemeFactory
    implements SchemeFactory {
        private ExportMappingDialogNotificationStandardSchemeFactory() {
        }

        public ExportMappingDialogNotificationStandardScheme getScheme() {
            return new ExportMappingDialogNotificationStandardScheme();
        }
    }

    private static class ExportMappingDialogNotificationTupleSchemeFactory
    implements SchemeFactory {
        private ExportMappingDialogNotificationTupleSchemeFactory() {
        }

        public ExportMappingDialogNotificationTupleScheme getScheme() {
            return new ExportMappingDialogNotificationTupleScheme();
        }
    }

    private static class ExportMappingDialogNotificationTupleScheme
    extends TupleScheme<ExportMappingDialogNotification> {
        private ExportMappingDialogNotificationTupleScheme() {
        }

        public void write(TProtocol tProtocol, ExportMappingDialogNotification exportMappingDialogNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (exportMappingDialogNotification.isSetFieldList()) {
                bitSet.set(0);
            }
            if (exportMappingDialogNotification.isSetGroupByInfoList()) {
                bitSet.set(1);
            }
            tTupleProtocol.writeBitSet(bitSet, 2);
            if (exportMappingDialogNotification.isSetFieldList()) {
                tTupleProtocol.writeI32(exportMappingDialogNotification.fieldList.size());
                for (FieldDefinition comparable : exportMappingDialogNotification.fieldList) {
                    comparable.write((TProtocol)tTupleProtocol);
                }
            }
            if (exportMappingDialogNotification.isSetGroupByInfoList()) {
                tTupleProtocol.writeI32(exportMappingDialogNotification.groupByInfoList.size());
                for (ExportGroupByInfo exportGroupByInfo : exportMappingDialogNotification.groupByInfoList) {
                    exportGroupByInfo.write((TProtocol)tTupleProtocol);
                }
            }
        }

        public void read(TProtocol tProtocol, ExportMappingDialogNotification exportMappingDialogNotification) throws TException {
            Comparable<FieldDefinition> comparable;
            int n;
            TList tList;
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(2);
            if (bitSet.get(0)) {
                tList = tTupleProtocol.readListBegin((byte)12);
                exportMappingDialogNotification.fieldList = new ArrayList<FieldDefinition>(tList.size);
                for (n = 0; n < tList.size; ++n) {
                    comparable = new FieldDefinition();
                    ((FieldDefinition)comparable).read((TProtocol)tTupleProtocol);
                    exportMappingDialogNotification.fieldList.add((FieldDefinition)comparable);
                }
                exportMappingDialogNotification.setFieldListIsSet(true);
            }
            if (bitSet.get(1)) {
                tList = tTupleProtocol.readListBegin((byte)12);
                exportMappingDialogNotification.groupByInfoList = new ArrayList<ExportGroupByInfo>(tList.size);
                for (n = 0; n < tList.size; ++n) {
                    comparable = new ExportGroupByInfo();
                    ((ExportGroupByInfo)comparable).read((TProtocol)tTupleProtocol);
                    exportMappingDialogNotification.groupByInfoList.add((ExportGroupByInfo)comparable);
                }
                exportMappingDialogNotification.setGroupByInfoListIsSet(true);
            }
        }
    }

    private static class ExportMappingDialogNotificationStandardScheme
    extends StandardScheme<ExportMappingDialogNotification> {
        private ExportMappingDialogNotificationStandardScheme() {
        }

        public void read(TProtocol tProtocol, ExportMappingDialogNotification exportMappingDialogNotification) throws TException {
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
                            exportMappingDialogNotification.fieldList = new ArrayList<FieldDefinition>(tList.size);
                            for (n = 0; n < tList.size; ++n) {
                                comparable = new FieldDefinition();
                                ((FieldDefinition)comparable).read(tProtocol);
                                exportMappingDialogNotification.fieldList.add((FieldDefinition)comparable);
                            }
                            tProtocol.readListEnd();
                            exportMappingDialogNotification.setFieldListIsSet(true);
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
                            exportMappingDialogNotification.groupByInfoList = new ArrayList<ExportGroupByInfo>(tList.size);
                            for (n = 0; n < tList.size; ++n) {
                                comparable = new ExportGroupByInfo();
                                ((ExportGroupByInfo)comparable).read(tProtocol);
                                exportMappingDialogNotification.groupByInfoList.add((ExportGroupByInfo)comparable);
                            }
                            tProtocol.readListEnd();
                            exportMappingDialogNotification.setGroupByInfoListIsSet(true);
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
            exportMappingDialogNotification.validate();
        }

        public void write(TProtocol tProtocol, ExportMappingDialogNotification exportMappingDialogNotification) throws TException {
            exportMappingDialogNotification.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (exportMappingDialogNotification.fieldList != null) {
                tProtocol.writeFieldBegin(FIELD_LIST_FIELD_DESC);
                tProtocol.writeListBegin(new TList(12, exportMappingDialogNotification.fieldList.size()));
                for (FieldDefinition comparable : exportMappingDialogNotification.fieldList) {
                    comparable.write(tProtocol);
                }
                tProtocol.writeListEnd();
                tProtocol.writeFieldEnd();
            }
            if (exportMappingDialogNotification.groupByInfoList != null) {
                tProtocol.writeFieldBegin(GROUP_BY_INFO_LIST_FIELD_DESC);
                tProtocol.writeListBegin(new TList(12, exportMappingDialogNotification.groupByInfoList.size()));
                for (ExportGroupByInfo exportGroupByInfo : exportMappingDialogNotification.groupByInfoList) {
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

