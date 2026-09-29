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

public class IDLField
implements TBase<IDLField, _Fields>,
Serializable,
Cloneable,
Comparable<IDLField> {
    private static final TStruct STRUCT_DESC = new TStruct("IDLField");
    private static final TField NAME_FIELD_DESC = new TField("name", 11, 1);
    private static final TField VALUES_FIELD_DESC = new TField("values", 15, 2);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new IDLFieldStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new IDLFieldTupleSchemeFactory();
    @Nullable
    private String name;
    @Nullable
    private List<String> values;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public IDLField() {
    }

    public IDLField(String string, List<String> list) {
        this();
        this.name = string;
        this.values = list;
    }

    public IDLField(IDLField iDLField) {
        if (iDLField.isSetName()) {
            this.name = iDLField.name;
        }
        if (iDLField.isSetValues()) {
            ArrayList<String> arrayList = new ArrayList<String>(iDLField.values);
            this.values = arrayList;
        }
    }

    public IDLField deepCopy() {
        return new IDLField(this);
    }

    public void clear() {
        this.name = null;
        this.values = null;
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

    public int getValuesSize() {
        return this.values == null ? 0 : this.values.size();
    }

    @Nullable
    public Iterator<String> getValuesIterator() {
        return this.values == null ? null : this.values.iterator();
    }

    public void addToValues(String string) {
        if (this.values == null) {
            this.values = new ArrayList<String>();
        }
        this.values.add(string);
    }

    @Nullable
    public List<String> getValues() {
        return this.values;
    }

    public void setValues(@Nullable List<String> list) {
        this.values = list;
    }

    public void unsetValues() {
        this.values = null;
    }

    public boolean isSetValues() {
        return this.values != null;
    }

    public void setValuesIsSet(boolean bl) {
        if (!bl) {
            this.values = null;
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
                    this.unsetValues();
                    break;
                }
                this.setValues((List)object);
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
                return this.getValues();
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
                return this.isSetValues();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof IDLField) {
            return this.equals((IDLField)object);
        }
        return false;
    }

    public boolean equals(IDLField iDLField) {
        if (iDLField == null) {
            return false;
        }
        if (this == iDLField) {
            return true;
        }
        boolean bl = this.isSetName();
        boolean bl2 = iDLField.isSetName();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.name.equals(iDLField.name)) {
                return false;
            }
        }
        boolean bl3 = this.isSetValues();
        boolean bl4 = iDLField.isSetValues();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.values.equals(iDLField.values)) {
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
        n = n * 8191 + (this.isSetValues() ? 131071 : 524287);
        if (this.isSetValues()) {
            n = n * 8191 + this.values.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(IDLField iDLField) {
        if (!this.getClass().equals(iDLField.getClass())) {
            return this.getClass().getName().compareTo(iDLField.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetName(), iDLField.isSetName());
        if (n != 0) {
            return n;
        }
        if (this.isSetName() && (n = TBaseHelper.compareTo((String)this.name, (String)iDLField.name)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetValues(), iDLField.isSetValues());
        if (n != 0) {
            return n;
        }
        if (this.isSetValues() && (n = TBaseHelper.compareTo(this.values, iDLField.values)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        IDLField.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        IDLField.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("IDLField(");
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
        stringBuilder.append("values:");
        if (this.values == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.values);
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
        enumMap.put(_Fields.NAME, new FieldMetaData("name", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.VALUES, new FieldMetaData("values", 3, (FieldValueMetaData)new ListMetaData(15, new FieldValueMetaData(11))));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(IDLField.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        NAME(1, "name"),
        VALUES(2, "values");

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
                    return VALUES;
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

    private static class IDLFieldStandardSchemeFactory
    implements SchemeFactory {
        private IDLFieldStandardSchemeFactory() {
        }

        public IDLFieldStandardScheme getScheme() {
            return new IDLFieldStandardScheme();
        }
    }

    private static class IDLFieldTupleSchemeFactory
    implements SchemeFactory {
        private IDLFieldTupleSchemeFactory() {
        }

        public IDLFieldTupleScheme getScheme() {
            return new IDLFieldTupleScheme();
        }
    }

    private static class IDLFieldTupleScheme
    extends TupleScheme<IDLField> {
        private IDLFieldTupleScheme() {
        }

        public void write(TProtocol tProtocol, IDLField iDLField) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (iDLField.isSetName()) {
                bitSet.set(0);
            }
            if (iDLField.isSetValues()) {
                bitSet.set(1);
            }
            tTupleProtocol.writeBitSet(bitSet, 2);
            if (iDLField.isSetName()) {
                tTupleProtocol.writeString(iDLField.name);
            }
            if (iDLField.isSetValues()) {
                tTupleProtocol.writeI32(iDLField.values.size());
                for (String string : iDLField.values) {
                    tTupleProtocol.writeString(string);
                }
            }
        }

        public void read(TProtocol tProtocol, IDLField iDLField) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(2);
            if (bitSet.get(0)) {
                iDLField.name = tTupleProtocol.readString();
                iDLField.setNameIsSet(true);
            }
            if (bitSet.get(1)) {
                TList tList = tTupleProtocol.readListBegin((byte)11);
                iDLField.values = new ArrayList<String>(tList.size);
                for (int i = 0; i < tList.size; ++i) {
                    String string = tTupleProtocol.readString();
                    iDLField.values.add(string);
                }
                iDLField.setValuesIsSet(true);
            }
        }
    }

    private static class IDLFieldStandardScheme
    extends StandardScheme<IDLField> {
        private IDLFieldStandardScheme() {
        }

        public void read(TProtocol tProtocol, IDLField iDLField) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 11) {
                            iDLField.name = tProtocol.readString();
                            iDLField.setNameIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 15) {
                            TList tList = tProtocol.readListBegin();
                            iDLField.values = new ArrayList<String>(tList.size);
                            for (int i = 0; i < tList.size; ++i) {
                                String string = tProtocol.readString();
                                iDLField.values.add(string);
                            }
                            tProtocol.readListEnd();
                            iDLField.setValuesIsSet(true);
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
            iDLField.validate();
        }

        public void write(TProtocol tProtocol, IDLField iDLField) throws TException {
            iDLField.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (iDLField.name != null) {
                tProtocol.writeFieldBegin(NAME_FIELD_DESC);
                tProtocol.writeString(iDLField.name);
                tProtocol.writeFieldEnd();
            }
            if (iDLField.values != null) {
                tProtocol.writeFieldBegin(VALUES_FIELD_DESC);
                tProtocol.writeListBegin(new TList(11, iDLField.values.size()));
                for (String string : iDLField.values) {
                    tProtocol.writeString(string);
                }
                tProtocol.writeListEnd();
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

