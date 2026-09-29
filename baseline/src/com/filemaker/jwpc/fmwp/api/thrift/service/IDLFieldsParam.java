/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
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

import com.filemaker.jwpc.fmwp.api.thrift.service.FindType;
import com.filemaker.jwpc.fmwp.api.thrift.service.IDLComplexParam;
import com.filemaker.jwpc.fmwp.api.thrift.service.IDLFieldParam;
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

public class IDLFieldsParam
implements TBase<IDLFieldsParam, _Fields>,
Serializable,
Cloneable,
Comparable<IDLFieldsParam> {
    private static final TStruct STRUCT_DESC = new TStruct("IDLFieldsParam");
    private static final TField FIND_TYPE_FIELD_DESC = new TField("findType", 8, 1);
    private static final TField FIELDS_FIELD_DESC = new TField("fields", 15, 2);
    private static final TField RELATED_PARAMS_FIELD_DESC = new TField("relatedParams", 15, 3);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new IDLFieldsParamStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new IDLFieldsParamTupleSchemeFactory();
    @Nullable
    private FindType findType;
    @Nullable
    private List<IDLFieldParam> fields;
    @Nullable
    private List<IDLComplexParam> relatedParams;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public IDLFieldsParam() {
    }

    public IDLFieldsParam(FindType findType, List<IDLFieldParam> list, List<IDLComplexParam> list2) {
        this();
        this.findType = findType;
        this.fields = list;
        this.relatedParams = list2;
    }

    public IDLFieldsParam(IDLFieldsParam iDLFieldsParam) {
        ArrayList<IDLFieldParam> arrayList;
        if (iDLFieldsParam.isSetFindType()) {
            this.findType = iDLFieldsParam.findType;
        }
        if (iDLFieldsParam.isSetFields()) {
            arrayList = new ArrayList<IDLFieldParam>(iDLFieldsParam.fields.size());
            for (IDLFieldParam comparable : iDLFieldsParam.fields) {
                arrayList.add(new IDLFieldParam(comparable));
            }
            this.fields = arrayList;
        }
        if (iDLFieldsParam.isSetRelatedParams()) {
            arrayList = new ArrayList(iDLFieldsParam.relatedParams.size());
            for (IDLComplexParam iDLComplexParam : iDLFieldsParam.relatedParams) {
                arrayList.add((IDLFieldParam)((Object)new IDLComplexParam(iDLComplexParam)));
            }
            this.relatedParams = arrayList;
        }
    }

    public IDLFieldsParam deepCopy() {
        return new IDLFieldsParam(this);
    }

    public void clear() {
        this.findType = null;
        this.fields = null;
        this.relatedParams = null;
    }

    @Nullable
    public FindType getFindType() {
        return this.findType;
    }

    public void setFindType(@Nullable FindType findType) {
        this.findType = findType;
    }

    public void unsetFindType() {
        this.findType = null;
    }

    public boolean isSetFindType() {
        return this.findType != null;
    }

    public void setFindTypeIsSet(boolean bl) {
        if (!bl) {
            this.findType = null;
        }
    }

    public int getFieldsSize() {
        return this.fields == null ? 0 : this.fields.size();
    }

    @Nullable
    public Iterator<IDLFieldParam> getFieldsIterator() {
        return this.fields == null ? null : this.fields.iterator();
    }

    public void addToFields(IDLFieldParam iDLFieldParam) {
        if (this.fields == null) {
            this.fields = new ArrayList<IDLFieldParam>();
        }
        this.fields.add(iDLFieldParam);
    }

    @Nullable
    public List<IDLFieldParam> getFields() {
        return this.fields;
    }

    public void setFields(@Nullable List<IDLFieldParam> list) {
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

    public int getRelatedParamsSize() {
        return this.relatedParams == null ? 0 : this.relatedParams.size();
    }

    @Nullable
    public Iterator<IDLComplexParam> getRelatedParamsIterator() {
        return this.relatedParams == null ? null : this.relatedParams.iterator();
    }

    public void addToRelatedParams(IDLComplexParam iDLComplexParam) {
        if (this.relatedParams == null) {
            this.relatedParams = new ArrayList<IDLComplexParam>();
        }
        this.relatedParams.add(iDLComplexParam);
    }

    @Nullable
    public List<IDLComplexParam> getRelatedParams() {
        return this.relatedParams;
    }

    public void setRelatedParams(@Nullable List<IDLComplexParam> list) {
        this.relatedParams = list;
    }

    public void unsetRelatedParams() {
        this.relatedParams = null;
    }

    public boolean isSetRelatedParams() {
        return this.relatedParams != null;
    }

    public void setRelatedParamsIsSet(boolean bl) {
        if (!bl) {
            this.relatedParams = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetFindType();
                    break;
                }
                this.setFindType((FindType)((Object)object));
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetFields();
                    break;
                }
                this.setFields((List)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetRelatedParams();
                    break;
                }
                this.setRelatedParams((List)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getFindType();
            }
            case 1: {
                return this.getFields();
            }
            case 2: {
                return this.getRelatedParams();
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
                return this.isSetFindType();
            }
            case 1: {
                return this.isSetFields();
            }
            case 2: {
                return this.isSetRelatedParams();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof IDLFieldsParam) {
            return this.equals((IDLFieldsParam)object);
        }
        return false;
    }

    public boolean equals(IDLFieldsParam iDLFieldsParam) {
        if (iDLFieldsParam == null) {
            return false;
        }
        if (this == iDLFieldsParam) {
            return true;
        }
        boolean bl = this.isSetFindType();
        boolean bl2 = iDLFieldsParam.isSetFindType();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.findType.equals((Object)iDLFieldsParam.findType)) {
                return false;
            }
        }
        boolean bl3 = this.isSetFields();
        boolean bl4 = iDLFieldsParam.isSetFields();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.fields.equals(iDLFieldsParam.fields)) {
                return false;
            }
        }
        boolean bl5 = this.isSetRelatedParams();
        boolean bl6 = iDLFieldsParam.isSetRelatedParams();
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (!this.relatedParams.equals(iDLFieldsParam.relatedParams)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetFindType() ? 131071 : 524287);
        if (this.isSetFindType()) {
            n = n * 8191 + this.findType.getValue();
        }
        n = n * 8191 + (this.isSetFields() ? 131071 : 524287);
        if (this.isSetFields()) {
            n = n * 8191 + this.fields.hashCode();
        }
        n = n * 8191 + (this.isSetRelatedParams() ? 131071 : 524287);
        if (this.isSetRelatedParams()) {
            n = n * 8191 + this.relatedParams.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(IDLFieldsParam iDLFieldsParam) {
        if (!this.getClass().equals(iDLFieldsParam.getClass())) {
            return this.getClass().getName().compareTo(iDLFieldsParam.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetFindType(), iDLFieldsParam.isSetFindType());
        if (n != 0) {
            return n;
        }
        if (this.isSetFindType() && (n = TBaseHelper.compareTo((Comparable)((Object)this.findType), (Comparable)((Object)iDLFieldsParam.findType))) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetFields(), iDLFieldsParam.isSetFields());
        if (n != 0) {
            return n;
        }
        if (this.isSetFields() && (n = TBaseHelper.compareTo(this.fields, iDLFieldsParam.fields)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetRelatedParams(), iDLFieldsParam.isSetRelatedParams());
        if (n != 0) {
            return n;
        }
        if (this.isSetRelatedParams() && (n = TBaseHelper.compareTo(this.relatedParams, iDLFieldsParam.relatedParams)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        IDLFieldsParam.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        IDLFieldsParam.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("IDLFieldsParam(");
        boolean bl = true;
        stringBuilder.append("findType:");
        if (this.findType == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append((Object)this.findType);
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
        stringBuilder.append("relatedParams:");
        if (this.relatedParams == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.relatedParams);
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
        enumMap.put(_Fields.FIND_TYPE, new FieldMetaData("findType", 3, (FieldValueMetaData)new EnumMetaData(-1, FindType.class)));
        enumMap.put(_Fields.FIELDS, new FieldMetaData("fields", 3, (FieldValueMetaData)new ListMetaData(15, (FieldValueMetaData)new StructMetaData(12, IDLFieldParam.class))));
        enumMap.put(_Fields.RELATED_PARAMS, new FieldMetaData("relatedParams", 3, (FieldValueMetaData)new ListMetaData(15, (FieldValueMetaData)new StructMetaData(12, IDLComplexParam.class))));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(IDLFieldsParam.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        FIND_TYPE(1, "findType"),
        FIELDS(2, "fields"),
        RELATED_PARAMS(3, "relatedParams");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return FIND_TYPE;
                }
                case 2: {
                    return FIELDS;
                }
                case 3: {
                    return RELATED_PARAMS;
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

    private static class IDLFieldsParamStandardSchemeFactory
    implements SchemeFactory {
        private IDLFieldsParamStandardSchemeFactory() {
        }

        public IDLFieldsParamStandardScheme getScheme() {
            return new IDLFieldsParamStandardScheme();
        }
    }

    private static class IDLFieldsParamTupleSchemeFactory
    implements SchemeFactory {
        private IDLFieldsParamTupleSchemeFactory() {
        }

        public IDLFieldsParamTupleScheme getScheme() {
            return new IDLFieldsParamTupleScheme();
        }
    }

    private static class IDLFieldsParamTupleScheme
    extends TupleScheme<IDLFieldsParam> {
        private IDLFieldsParamTupleScheme() {
        }

        public void write(TProtocol tProtocol, IDLFieldsParam iDLFieldsParam) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (iDLFieldsParam.isSetFindType()) {
                bitSet.set(0);
            }
            if (iDLFieldsParam.isSetFields()) {
                bitSet.set(1);
            }
            if (iDLFieldsParam.isSetRelatedParams()) {
                bitSet.set(2);
            }
            tTupleProtocol.writeBitSet(bitSet, 3);
            if (iDLFieldsParam.isSetFindType()) {
                tTupleProtocol.writeI32(iDLFieldsParam.findType.getValue());
            }
            if (iDLFieldsParam.isSetFields()) {
                tTupleProtocol.writeI32(iDLFieldsParam.fields.size());
                for (IDLFieldParam comparable : iDLFieldsParam.fields) {
                    comparable.write((TProtocol)tTupleProtocol);
                }
            }
            if (iDLFieldsParam.isSetRelatedParams()) {
                tTupleProtocol.writeI32(iDLFieldsParam.relatedParams.size());
                for (IDLComplexParam iDLComplexParam : iDLFieldsParam.relatedParams) {
                    iDLComplexParam.write((TProtocol)tTupleProtocol);
                }
            }
        }

        public void read(TProtocol tProtocol, IDLFieldsParam iDLFieldsParam) throws TException {
            Comparable<IDLFieldParam> comparable;
            int n;
            TList tList;
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(3);
            if (bitSet.get(0)) {
                iDLFieldsParam.findType = FindType.findByValue(tTupleProtocol.readI32());
                iDLFieldsParam.setFindTypeIsSet(true);
            }
            if (bitSet.get(1)) {
                tList = tTupleProtocol.readListBegin((byte)12);
                iDLFieldsParam.fields = new ArrayList<IDLFieldParam>(tList.size);
                for (n = 0; n < tList.size; ++n) {
                    comparable = new IDLFieldParam();
                    ((IDLFieldParam)comparable).read((TProtocol)tTupleProtocol);
                    iDLFieldsParam.fields.add((IDLFieldParam)comparable);
                }
                iDLFieldsParam.setFieldsIsSet(true);
            }
            if (bitSet.get(2)) {
                tList = tTupleProtocol.readListBegin((byte)12);
                iDLFieldsParam.relatedParams = new ArrayList<IDLComplexParam>(tList.size);
                for (n = 0; n < tList.size; ++n) {
                    comparable = new IDLComplexParam();
                    ((IDLComplexParam)comparable).read((TProtocol)tTupleProtocol);
                    iDLFieldsParam.relatedParams.add((IDLComplexParam)comparable);
                }
                iDLFieldsParam.setRelatedParamsIsSet(true);
            }
        }
    }

    private static class IDLFieldsParamStandardScheme
    extends StandardScheme<IDLFieldsParam> {
        private IDLFieldsParamStandardScheme() {
        }

        public void read(TProtocol tProtocol, IDLFieldsParam iDLFieldsParam) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 8) {
                            iDLFieldsParam.findType = FindType.findByValue(tProtocol.readI32());
                            iDLFieldsParam.setFindTypeIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        Comparable<IDLFieldParam> comparable;
                        int n;
                        TList tList;
                        if (tField.type == 15) {
                            tList = tProtocol.readListBegin();
                            iDLFieldsParam.fields = new ArrayList<IDLFieldParam>(tList.size);
                            for (n = 0; n < tList.size; ++n) {
                                comparable = new IDLFieldParam();
                                ((IDLFieldParam)comparable).read(tProtocol);
                                iDLFieldsParam.fields.add((IDLFieldParam)comparable);
                            }
                            tProtocol.readListEnd();
                            iDLFieldsParam.setFieldsIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        Comparable<IDLFieldParam> comparable;
                        int n;
                        TList tList;
                        if (tField.type == 15) {
                            tList = tProtocol.readListBegin();
                            iDLFieldsParam.relatedParams = new ArrayList<IDLComplexParam>(tList.size);
                            for (n = 0; n < tList.size; ++n) {
                                comparable = new IDLComplexParam();
                                ((IDLComplexParam)comparable).read(tProtocol);
                                iDLFieldsParam.relatedParams.add((IDLComplexParam)comparable);
                            }
                            tProtocol.readListEnd();
                            iDLFieldsParam.setRelatedParamsIsSet(true);
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
            iDLFieldsParam.validate();
        }

        public void write(TProtocol tProtocol, IDLFieldsParam iDLFieldsParam) throws TException {
            iDLFieldsParam.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (iDLFieldsParam.findType != null) {
                tProtocol.writeFieldBegin(FIND_TYPE_FIELD_DESC);
                tProtocol.writeI32(iDLFieldsParam.findType.getValue());
                tProtocol.writeFieldEnd();
            }
            if (iDLFieldsParam.fields != null) {
                tProtocol.writeFieldBegin(FIELDS_FIELD_DESC);
                tProtocol.writeListBegin(new TList(12, iDLFieldsParam.fields.size()));
                for (IDLFieldParam comparable : iDLFieldsParam.fields) {
                    comparable.write(tProtocol);
                }
                tProtocol.writeListEnd();
                tProtocol.writeFieldEnd();
            }
            if (iDLFieldsParam.relatedParams != null) {
                tProtocol.writeFieldBegin(RELATED_PARAMS_FIELD_DESC);
                tProtocol.writeListBegin(new TList(12, iDLFieldsParam.relatedParams.size()));
                for (IDLComplexParam iDLComplexParam : iDLFieldsParam.relatedParams) {
                    iDLComplexParam.write(tProtocol);
                }
                tProtocol.writeListEnd();
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

