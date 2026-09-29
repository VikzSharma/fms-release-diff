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
 *  org.apache.thrift.meta_data.StructMetaData
 *  org.apache.thrift.protocol.TCompactProtocol
 *  org.apache.thrift.protocol.TField
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

import com.filemaker.jwpc.iwp.thrift.common.FilteredValueListData;
import com.filemaker.jwpc.iwp.thrift.common.ObjectSpec;
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
import org.apache.thrift.TBase;
import org.apache.thrift.TBaseHelper;
import org.apache.thrift.TException;
import org.apache.thrift.TFieldIdEnum;
import org.apache.thrift.annotation.Nullable;
import org.apache.thrift.meta_data.FieldMetaData;
import org.apache.thrift.meta_data.FieldValueMetaData;
import org.apache.thrift.meta_data.StructMetaData;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TField;
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

public class ValueListItemResult
implements TBase<ValueListItemResult, _Fields>,
Serializable,
Cloneable,
Comparable<ValueListItemResult> {
    private static final TStruct STRUCT_DESC = new TStruct("ValueListItemResult");
    private static final TField OBJECT_SPEC_FIELD_DESC = new TField("objectSpec", 12, 1);
    private static final TField DATA_FIELD_DESC = new TField("data", 12, 2);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new ValueListItemResultStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new ValueListItemResultTupleSchemeFactory();
    @Nullable
    private ObjectSpec objectSpec;
    @Nullable
    private FilteredValueListData data;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public ValueListItemResult() {
    }

    public ValueListItemResult(ObjectSpec objectSpec, FilteredValueListData filteredValueListData) {
        this();
        this.objectSpec = objectSpec;
        this.data = filteredValueListData;
    }

    public ValueListItemResult(ValueListItemResult valueListItemResult) {
        if (valueListItemResult.isSetObjectSpec()) {
            this.objectSpec = new ObjectSpec(valueListItemResult.objectSpec);
        }
        if (valueListItemResult.isSetData()) {
            this.data = new FilteredValueListData(valueListItemResult.data);
        }
    }

    public ValueListItemResult deepCopy() {
        return new ValueListItemResult(this);
    }

    public void clear() {
        this.objectSpec = null;
        this.data = null;
    }

    @Nullable
    public ObjectSpec getObjectSpec() {
        return this.objectSpec;
    }

    public void setObjectSpec(@Nullable ObjectSpec objectSpec) {
        this.objectSpec = objectSpec;
    }

    public void unsetObjectSpec() {
        this.objectSpec = null;
    }

    public boolean isSetObjectSpec() {
        return this.objectSpec != null;
    }

    public void setObjectSpecIsSet(boolean bl) {
        if (!bl) {
            this.objectSpec = null;
        }
    }

    @Nullable
    public FilteredValueListData getData() {
        return this.data;
    }

    public void setData(@Nullable FilteredValueListData filteredValueListData) {
        this.data = filteredValueListData;
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

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetObjectSpec();
                    break;
                }
                this.setObjectSpec((ObjectSpec)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetData();
                    break;
                }
                this.setData((FilteredValueListData)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getObjectSpec();
            }
            case 1: {
                return this.getData();
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
                return this.isSetObjectSpec();
            }
            case 1: {
                return this.isSetData();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof ValueListItemResult) {
            return this.equals((ValueListItemResult)object);
        }
        return false;
    }

    public boolean equals(ValueListItemResult valueListItemResult) {
        if (valueListItemResult == null) {
            return false;
        }
        if (this == valueListItemResult) {
            return true;
        }
        boolean bl = this.isSetObjectSpec();
        boolean bl2 = valueListItemResult.isSetObjectSpec();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.objectSpec.equals(valueListItemResult.objectSpec)) {
                return false;
            }
        }
        boolean bl3 = this.isSetData();
        boolean bl4 = valueListItemResult.isSetData();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.data.equals(valueListItemResult.data)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetObjectSpec() ? 131071 : 524287);
        if (this.isSetObjectSpec()) {
            n = n * 8191 + this.objectSpec.hashCode();
        }
        n = n * 8191 + (this.isSetData() ? 131071 : 524287);
        if (this.isSetData()) {
            n = n * 8191 + this.data.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(ValueListItemResult valueListItemResult) {
        if (!this.getClass().equals(valueListItemResult.getClass())) {
            return this.getClass().getName().compareTo(valueListItemResult.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetObjectSpec(), valueListItemResult.isSetObjectSpec());
        if (n != 0) {
            return n;
        }
        if (this.isSetObjectSpec() && (n = TBaseHelper.compareTo((Comparable)this.objectSpec, (Comparable)valueListItemResult.objectSpec)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetData(), valueListItemResult.isSetData());
        if (n != 0) {
            return n;
        }
        if (this.isSetData() && (n = TBaseHelper.compareTo((Comparable)this.data, (Comparable)valueListItemResult.data)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        ValueListItemResult.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        ValueListItemResult.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ValueListItemResult(");
        boolean bl = true;
        stringBuilder.append("objectSpec:");
        if (this.objectSpec == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.objectSpec);
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
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void validate() throws TException {
        if (this.objectSpec != null) {
            this.objectSpec.validate();
        }
        if (this.data != null) {
            this.data.validate();
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
        enumMap.put(_Fields.OBJECT_SPEC, new FieldMetaData("objectSpec", 3, (FieldValueMetaData)new StructMetaData(12, ObjectSpec.class)));
        enumMap.put(_Fields.DATA, new FieldMetaData("data", 3, (FieldValueMetaData)new StructMetaData(12, FilteredValueListData.class)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(ValueListItemResult.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        OBJECT_SPEC(1, "objectSpec"),
        DATA(2, "data");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return OBJECT_SPEC;
                }
                case 2: {
                    return DATA;
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

    private static class ValueListItemResultStandardSchemeFactory
    implements SchemeFactory {
        private ValueListItemResultStandardSchemeFactory() {
        }

        public ValueListItemResultStandardScheme getScheme() {
            return new ValueListItemResultStandardScheme();
        }
    }

    private static class ValueListItemResultTupleSchemeFactory
    implements SchemeFactory {
        private ValueListItemResultTupleSchemeFactory() {
        }

        public ValueListItemResultTupleScheme getScheme() {
            return new ValueListItemResultTupleScheme();
        }
    }

    private static class ValueListItemResultTupleScheme
    extends TupleScheme<ValueListItemResult> {
        private ValueListItemResultTupleScheme() {
        }

        public void write(TProtocol tProtocol, ValueListItemResult valueListItemResult) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (valueListItemResult.isSetObjectSpec()) {
                bitSet.set(0);
            }
            if (valueListItemResult.isSetData()) {
                bitSet.set(1);
            }
            tTupleProtocol.writeBitSet(bitSet, 2);
            if (valueListItemResult.isSetObjectSpec()) {
                valueListItemResult.objectSpec.write((TProtocol)tTupleProtocol);
            }
            if (valueListItemResult.isSetData()) {
                valueListItemResult.data.write((TProtocol)tTupleProtocol);
            }
        }

        public void read(TProtocol tProtocol, ValueListItemResult valueListItemResult) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(2);
            if (bitSet.get(0)) {
                valueListItemResult.objectSpec = new ObjectSpec();
                valueListItemResult.objectSpec.read((TProtocol)tTupleProtocol);
                valueListItemResult.setObjectSpecIsSet(true);
            }
            if (bitSet.get(1)) {
                valueListItemResult.data = new FilteredValueListData();
                valueListItemResult.data.read((TProtocol)tTupleProtocol);
                valueListItemResult.setDataIsSet(true);
            }
        }
    }

    private static class ValueListItemResultStandardScheme
    extends StandardScheme<ValueListItemResult> {
        private ValueListItemResultStandardScheme() {
        }

        public void read(TProtocol tProtocol, ValueListItemResult valueListItemResult) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 12) {
                            valueListItemResult.objectSpec = new ObjectSpec();
                            valueListItemResult.objectSpec.read(tProtocol);
                            valueListItemResult.setObjectSpecIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 12) {
                            valueListItemResult.data = new FilteredValueListData();
                            valueListItemResult.data.read(tProtocol);
                            valueListItemResult.setDataIsSet(true);
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
            valueListItemResult.validate();
        }

        public void write(TProtocol tProtocol, ValueListItemResult valueListItemResult) throws TException {
            valueListItemResult.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (valueListItemResult.objectSpec != null) {
                tProtocol.writeFieldBegin(OBJECT_SPEC_FIELD_DESC);
                valueListItemResult.objectSpec.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            if (valueListItemResult.data != null) {
                tProtocol.writeFieldBegin(DATA_FIELD_DESC);
                valueListItemResult.data.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

