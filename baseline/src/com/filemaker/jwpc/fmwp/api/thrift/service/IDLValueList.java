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

import com.filemaker.jwpc.fmwp.api.thrift.service.NVPair;
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

public class IDLValueList
implements TBase<IDLValueList, _Fields>,
Serializable,
Cloneable,
Comparable<IDLValueList> {
    private static final TStruct STRUCT_DESC = new TStruct("IDLValueList");
    private static final TField NAME_FIELD_DESC = new TField("name", 11, 1);
    private static final TField VALUES_FIELD_DESC = new TField("values", 15, 2);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new IDLValueListStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new IDLValueListTupleSchemeFactory();
    @Nullable
    private String name;
    @Nullable
    private List<NVPair> values;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public IDLValueList() {
    }

    public IDLValueList(String string, List<NVPair> list) {
        this();
        this.name = string;
        this.values = list;
    }

    public IDLValueList(IDLValueList iDLValueList) {
        if (iDLValueList.isSetName()) {
            this.name = iDLValueList.name;
        }
        if (iDLValueList.isSetValues()) {
            ArrayList<NVPair> arrayList = new ArrayList<NVPair>(iDLValueList.values.size());
            for (NVPair nVPair : iDLValueList.values) {
                arrayList.add(new NVPair(nVPair));
            }
            this.values = arrayList;
        }
    }

    public IDLValueList deepCopy() {
        return new IDLValueList(this);
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
    public Iterator<NVPair> getValuesIterator() {
        return this.values == null ? null : this.values.iterator();
    }

    public void addToValues(NVPair nVPair) {
        if (this.values == null) {
            this.values = new ArrayList<NVPair>();
        }
        this.values.add(nVPair);
    }

    @Nullable
    public List<NVPair> getValues() {
        return this.values;
    }

    public void setValues(@Nullable List<NVPair> list) {
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
        if (object instanceof IDLValueList) {
            return this.equals((IDLValueList)object);
        }
        return false;
    }

    public boolean equals(IDLValueList iDLValueList) {
        if (iDLValueList == null) {
            return false;
        }
        if (this == iDLValueList) {
            return true;
        }
        boolean bl = this.isSetName();
        boolean bl2 = iDLValueList.isSetName();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.name.equals(iDLValueList.name)) {
                return false;
            }
        }
        boolean bl3 = this.isSetValues();
        boolean bl4 = iDLValueList.isSetValues();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.values.equals(iDLValueList.values)) {
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
    public int compareTo(IDLValueList iDLValueList) {
        if (!this.getClass().equals(iDLValueList.getClass())) {
            return this.getClass().getName().compareTo(iDLValueList.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetName(), iDLValueList.isSetName());
        if (n != 0) {
            return n;
        }
        if (this.isSetName() && (n = TBaseHelper.compareTo((String)this.name, (String)iDLValueList.name)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetValues(), iDLValueList.isSetValues());
        if (n != 0) {
            return n;
        }
        if (this.isSetValues() && (n = TBaseHelper.compareTo(this.values, iDLValueList.values)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        IDLValueList.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        IDLValueList.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("IDLValueList(");
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
        enumMap.put(_Fields.VALUES, new FieldMetaData("values", 3, (FieldValueMetaData)new ListMetaData(15, (FieldValueMetaData)new StructMetaData(12, NVPair.class))));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(IDLValueList.class, metaDataMap);
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

    private static class IDLValueListStandardSchemeFactory
    implements SchemeFactory {
        private IDLValueListStandardSchemeFactory() {
        }

        public IDLValueListStandardScheme getScheme() {
            return new IDLValueListStandardScheme();
        }
    }

    private static class IDLValueListTupleSchemeFactory
    implements SchemeFactory {
        private IDLValueListTupleSchemeFactory() {
        }

        public IDLValueListTupleScheme getScheme() {
            return new IDLValueListTupleScheme();
        }
    }

    private static class IDLValueListTupleScheme
    extends TupleScheme<IDLValueList> {
        private IDLValueListTupleScheme() {
        }

        public void write(TProtocol tProtocol, IDLValueList iDLValueList) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (iDLValueList.isSetName()) {
                bitSet.set(0);
            }
            if (iDLValueList.isSetValues()) {
                bitSet.set(1);
            }
            tTupleProtocol.writeBitSet(bitSet, 2);
            if (iDLValueList.isSetName()) {
                tTupleProtocol.writeString(iDLValueList.name);
            }
            if (iDLValueList.isSetValues()) {
                tTupleProtocol.writeI32(iDLValueList.values.size());
                for (NVPair nVPair : iDLValueList.values) {
                    nVPair.write((TProtocol)tTupleProtocol);
                }
            }
        }

        public void read(TProtocol tProtocol, IDLValueList iDLValueList) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(2);
            if (bitSet.get(0)) {
                iDLValueList.name = tTupleProtocol.readString();
                iDLValueList.setNameIsSet(true);
            }
            if (bitSet.get(1)) {
                TList tList = tTupleProtocol.readListBegin((byte)12);
                iDLValueList.values = new ArrayList<NVPair>(tList.size);
                for (int i = 0; i < tList.size; ++i) {
                    NVPair nVPair = new NVPair();
                    nVPair.read((TProtocol)tTupleProtocol);
                    iDLValueList.values.add(nVPair);
                }
                iDLValueList.setValuesIsSet(true);
            }
        }
    }

    private static class IDLValueListStandardScheme
    extends StandardScheme<IDLValueList> {
        private IDLValueListStandardScheme() {
        }

        public void read(TProtocol tProtocol, IDLValueList iDLValueList) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 11) {
                            iDLValueList.name = tProtocol.readString();
                            iDLValueList.setNameIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 15) {
                            TList tList = tProtocol.readListBegin();
                            iDLValueList.values = new ArrayList<NVPair>(tList.size);
                            for (int i = 0; i < tList.size; ++i) {
                                NVPair nVPair = new NVPair();
                                nVPair.read(tProtocol);
                                iDLValueList.values.add(nVPair);
                            }
                            tProtocol.readListEnd();
                            iDLValueList.setValuesIsSet(true);
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
            iDLValueList.validate();
        }

        public void write(TProtocol tProtocol, IDLValueList iDLValueList) throws TException {
            iDLValueList.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (iDLValueList.name != null) {
                tProtocol.writeFieldBegin(NAME_FIELD_DESC);
                tProtocol.writeString(iDLValueList.name);
                tProtocol.writeFieldEnd();
            }
            if (iDLValueList.values != null) {
                tProtocol.writeFieldBegin(VALUES_FIELD_DESC);
                tProtocol.writeListBegin(new TList(12, iDLValueList.values.size()));
                for (NVPair nVPair : iDLValueList.values) {
                    nVPair.write(tProtocol);
                }
                tProtocol.writeListEnd();
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

