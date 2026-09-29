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
package com.filemaker.jwpc.fmwp.api.thrift.service;

import com.filemaker.jwpc.fmwp.api.thrift.service.IDLFieldLaySpec;
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

public class IDLPortalFieldLaySpec
implements TBase<IDLPortalFieldLaySpec, _Fields>,
Serializable,
Cloneable,
Comparable<IDLPortalFieldLaySpec> {
    private static final TStruct STRUCT_DESC = new TStruct("IDLPortalFieldLaySpec");
    private static final TField TABLE_NAME_FIELD_DESC = new TField("tableName", 11, 1);
    private static final TField FIELDS_FIELD_DESC = new TField("fields", 15, 2);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new IDLPortalFieldLaySpecStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new IDLPortalFieldLaySpecTupleSchemeFactory();
    @Nullable
    private String tableName;
    @Nullable
    private List<IDLFieldLaySpec> fields;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public IDLPortalFieldLaySpec() {
    }

    public IDLPortalFieldLaySpec(String string, List<IDLFieldLaySpec> list) {
        this();
        this.tableName = string;
        this.fields = list;
    }

    public IDLPortalFieldLaySpec(IDLPortalFieldLaySpec iDLPortalFieldLaySpec) {
        if (iDLPortalFieldLaySpec.isSetTableName()) {
            this.tableName = iDLPortalFieldLaySpec.tableName;
        }
        if (iDLPortalFieldLaySpec.isSetFields()) {
            ArrayList<IDLFieldLaySpec> arrayList = new ArrayList<IDLFieldLaySpec>(iDLPortalFieldLaySpec.fields.size());
            for (IDLFieldLaySpec iDLFieldLaySpec : iDLPortalFieldLaySpec.fields) {
                arrayList.add(new IDLFieldLaySpec(iDLFieldLaySpec));
            }
            this.fields = arrayList;
        }
    }

    public IDLPortalFieldLaySpec deepCopy() {
        return new IDLPortalFieldLaySpec(this);
    }

    public void clear() {
        this.tableName = null;
        this.fields = null;
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

    public int getFieldsSize() {
        return this.fields == null ? 0 : this.fields.size();
    }

    @Nullable
    public Iterator<IDLFieldLaySpec> getFieldsIterator() {
        return this.fields == null ? null : this.fields.iterator();
    }

    public void addToFields(IDLFieldLaySpec iDLFieldLaySpec) {
        if (this.fields == null) {
            this.fields = new ArrayList<IDLFieldLaySpec>();
        }
        this.fields.add(iDLFieldLaySpec);
    }

    @Nullable
    public List<IDLFieldLaySpec> getFields() {
        return this.fields;
    }

    public void setFields(@Nullable List<IDLFieldLaySpec> list) {
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

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetTableName();
                    break;
                }
                this.setTableName((String)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetFields();
                    break;
                }
                this.setFields((List)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getTableName();
            }
            case 1: {
                return this.getFields();
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
                return this.isSetTableName();
            }
            case 1: {
                return this.isSetFields();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof IDLPortalFieldLaySpec) {
            return this.equals((IDLPortalFieldLaySpec)object);
        }
        return false;
    }

    public boolean equals(IDLPortalFieldLaySpec iDLPortalFieldLaySpec) {
        if (iDLPortalFieldLaySpec == null) {
            return false;
        }
        if (this == iDLPortalFieldLaySpec) {
            return true;
        }
        boolean bl = this.isSetTableName();
        boolean bl2 = iDLPortalFieldLaySpec.isSetTableName();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.tableName.equals(iDLPortalFieldLaySpec.tableName)) {
                return false;
            }
        }
        boolean bl3 = this.isSetFields();
        boolean bl4 = iDLPortalFieldLaySpec.isSetFields();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.fields.equals(iDLPortalFieldLaySpec.fields)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetTableName() ? 131071 : 524287);
        if (this.isSetTableName()) {
            n = n * 8191 + this.tableName.hashCode();
        }
        n = n * 8191 + (this.isSetFields() ? 131071 : 524287);
        if (this.isSetFields()) {
            n = n * 8191 + this.fields.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(IDLPortalFieldLaySpec iDLPortalFieldLaySpec) {
        if (!this.getClass().equals(iDLPortalFieldLaySpec.getClass())) {
            return this.getClass().getName().compareTo(iDLPortalFieldLaySpec.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetTableName(), iDLPortalFieldLaySpec.isSetTableName());
        if (n != 0) {
            return n;
        }
        if (this.isSetTableName() && (n = TBaseHelper.compareTo((String)this.tableName, (String)iDLPortalFieldLaySpec.tableName)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetFields(), iDLPortalFieldLaySpec.isSetFields());
        if (n != 0) {
            return n;
        }
        if (this.isSetFields() && (n = TBaseHelper.compareTo(this.fields, iDLPortalFieldLaySpec.fields)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        IDLPortalFieldLaySpec.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        IDLPortalFieldLaySpec.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("IDLPortalFieldLaySpec(");
        boolean bl = true;
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
        stringBuilder.append("fields:");
        if (this.fields == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.fields);
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
        enumMap.put(_Fields.TABLE_NAME, new FieldMetaData("tableName", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.FIELDS, new FieldMetaData("fields", 3, (FieldValueMetaData)new ListMetaData(15, (FieldValueMetaData)new StructMetaData(12, IDLFieldLaySpec.class))));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(IDLPortalFieldLaySpec.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        TABLE_NAME(1, "tableName"),
        FIELDS(2, "fields");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return TABLE_NAME;
                }
                case 2: {
                    return FIELDS;
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

    private static class IDLPortalFieldLaySpecStandardSchemeFactory
    implements SchemeFactory {
        private IDLPortalFieldLaySpecStandardSchemeFactory() {
        }

        public IDLPortalFieldLaySpecStandardScheme getScheme() {
            return new IDLPortalFieldLaySpecStandardScheme();
        }
    }

    private static class IDLPortalFieldLaySpecTupleSchemeFactory
    implements SchemeFactory {
        private IDLPortalFieldLaySpecTupleSchemeFactory() {
        }

        public IDLPortalFieldLaySpecTupleScheme getScheme() {
            return new IDLPortalFieldLaySpecTupleScheme();
        }
    }

    private static class IDLPortalFieldLaySpecTupleScheme
    extends TupleScheme<IDLPortalFieldLaySpec> {
        private IDLPortalFieldLaySpecTupleScheme() {
        }

        public void write(TProtocol tProtocol, IDLPortalFieldLaySpec iDLPortalFieldLaySpec) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (iDLPortalFieldLaySpec.isSetTableName()) {
                bitSet.set(0);
            }
            if (iDLPortalFieldLaySpec.isSetFields()) {
                bitSet.set(1);
            }
            tTupleProtocol.writeBitSet(bitSet, 2);
            if (iDLPortalFieldLaySpec.isSetTableName()) {
                tTupleProtocol.writeString(iDLPortalFieldLaySpec.tableName);
            }
            if (iDLPortalFieldLaySpec.isSetFields()) {
                tTupleProtocol.writeI32(iDLPortalFieldLaySpec.fields.size());
                for (IDLFieldLaySpec iDLFieldLaySpec : iDLPortalFieldLaySpec.fields) {
                    iDLFieldLaySpec.write((TProtocol)tTupleProtocol);
                }
            }
        }

        public void read(TProtocol tProtocol, IDLPortalFieldLaySpec iDLPortalFieldLaySpec) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(2);
            if (bitSet.get(0)) {
                iDLPortalFieldLaySpec.tableName = tTupleProtocol.readString();
                iDLPortalFieldLaySpec.setTableNameIsSet(true);
            }
            if (bitSet.get(1)) {
                TList tList = tTupleProtocol.readListBegin((byte)12);
                iDLPortalFieldLaySpec.fields = new ArrayList<IDLFieldLaySpec>(tList.size);
                for (int i = 0; i < tList.size; ++i) {
                    IDLFieldLaySpec iDLFieldLaySpec = new IDLFieldLaySpec();
                    iDLFieldLaySpec.read((TProtocol)tTupleProtocol);
                    iDLPortalFieldLaySpec.fields.add(iDLFieldLaySpec);
                }
                iDLPortalFieldLaySpec.setFieldsIsSet(true);
            }
        }
    }

    private static class IDLPortalFieldLaySpecStandardScheme
    extends StandardScheme<IDLPortalFieldLaySpec> {
        private IDLPortalFieldLaySpecStandardScheme() {
        }

        public void read(TProtocol tProtocol, IDLPortalFieldLaySpec iDLPortalFieldLaySpec) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 11) {
                            iDLPortalFieldLaySpec.tableName = tProtocol.readString();
                            iDLPortalFieldLaySpec.setTableNameIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 15) {
                            TList tList = tProtocol.readListBegin();
                            iDLPortalFieldLaySpec.fields = new ArrayList<IDLFieldLaySpec>(tList.size);
                            for (int i = 0; i < tList.size; ++i) {
                                IDLFieldLaySpec iDLFieldLaySpec = new IDLFieldLaySpec();
                                iDLFieldLaySpec.read(tProtocol);
                                iDLPortalFieldLaySpec.fields.add(iDLFieldLaySpec);
                            }
                            tProtocol.readListEnd();
                            iDLPortalFieldLaySpec.setFieldsIsSet(true);
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
            iDLPortalFieldLaySpec.validate();
        }

        public void write(TProtocol tProtocol, IDLPortalFieldLaySpec iDLPortalFieldLaySpec) throws TException {
            iDLPortalFieldLaySpec.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (iDLPortalFieldLaySpec.tableName != null) {
                tProtocol.writeFieldBegin(TABLE_NAME_FIELD_DESC);
                tProtocol.writeString(iDLPortalFieldLaySpec.tableName);
                tProtocol.writeFieldEnd();
            }
            if (iDLPortalFieldLaySpec.fields != null) {
                tProtocol.writeFieldBegin(FIELDS_FIELD_DESC);
                tProtocol.writeListBegin(new TList(12, iDLPortalFieldLaySpec.fields.size()));
                for (IDLFieldLaySpec iDLFieldLaySpec : iDLPortalFieldLaySpec.fields) {
                    iDLFieldLaySpec.write(tProtocol);
                }
                tProtocol.writeListEnd();
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

