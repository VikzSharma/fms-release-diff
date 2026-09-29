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

import com.filemaker.jwpc.iwp.thrift.common.ObjectSpec;
import com.filemaker.jwpc.iwp.thrift.common.ValueListData;
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

public class ValueListSubsetResult
implements TBase<ValueListSubsetResult, _Fields>,
Serializable,
Cloneable,
Comparable<ValueListSubsetResult> {
    private static final TStruct STRUCT_DESC = new TStruct("ValueListSubsetResult");
    private static final TField OBJECT_SPEC_FIELD_DESC = new TField("objectSpec", 12, 1);
    private static final TField DATA_FIELD_DESC = new TField("data", 12, 2);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new ValueListSubsetResultStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new ValueListSubsetResultTupleSchemeFactory();
    @Nullable
    private ObjectSpec objectSpec;
    @Nullable
    private ValueListData data;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public ValueListSubsetResult() {
    }

    public ValueListSubsetResult(ObjectSpec objectSpec, ValueListData valueListData) {
        this();
        this.objectSpec = objectSpec;
        this.data = valueListData;
    }

    public ValueListSubsetResult(ValueListSubsetResult valueListSubsetResult) {
        if (valueListSubsetResult.isSetObjectSpec()) {
            this.objectSpec = new ObjectSpec(valueListSubsetResult.objectSpec);
        }
        if (valueListSubsetResult.isSetData()) {
            this.data = new ValueListData(valueListSubsetResult.data);
        }
    }

    public ValueListSubsetResult deepCopy() {
        return new ValueListSubsetResult(this);
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
    public ValueListData getData() {
        return this.data;
    }

    public void setData(@Nullable ValueListData valueListData) {
        this.data = valueListData;
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
                this.setData((ValueListData)object);
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
        if (object instanceof ValueListSubsetResult) {
            return this.equals((ValueListSubsetResult)object);
        }
        return false;
    }

    public boolean equals(ValueListSubsetResult valueListSubsetResult) {
        if (valueListSubsetResult == null) {
            return false;
        }
        if (this == valueListSubsetResult) {
            return true;
        }
        boolean bl = this.isSetObjectSpec();
        boolean bl2 = valueListSubsetResult.isSetObjectSpec();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.objectSpec.equals(valueListSubsetResult.objectSpec)) {
                return false;
            }
        }
        boolean bl3 = this.isSetData();
        boolean bl4 = valueListSubsetResult.isSetData();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.data.equals(valueListSubsetResult.data)) {
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
    public int compareTo(ValueListSubsetResult valueListSubsetResult) {
        if (!this.getClass().equals(valueListSubsetResult.getClass())) {
            return this.getClass().getName().compareTo(valueListSubsetResult.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetObjectSpec(), valueListSubsetResult.isSetObjectSpec());
        if (n != 0) {
            return n;
        }
        if (this.isSetObjectSpec() && (n = TBaseHelper.compareTo((Comparable)this.objectSpec, (Comparable)valueListSubsetResult.objectSpec)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetData(), valueListSubsetResult.isSetData());
        if (n != 0) {
            return n;
        }
        if (this.isSetData() && (n = TBaseHelper.compareTo((Comparable)this.data, (Comparable)valueListSubsetResult.data)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        ValueListSubsetResult.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        ValueListSubsetResult.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ValueListSubsetResult(");
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
        enumMap.put(_Fields.DATA, new FieldMetaData("data", 3, (FieldValueMetaData)new StructMetaData(12, ValueListData.class)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(ValueListSubsetResult.class, metaDataMap);
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

    private static class ValueListSubsetResultStandardSchemeFactory
    implements SchemeFactory {
        private ValueListSubsetResultStandardSchemeFactory() {
        }

        public ValueListSubsetResultStandardScheme getScheme() {
            return new ValueListSubsetResultStandardScheme();
        }
    }

    private static class ValueListSubsetResultTupleSchemeFactory
    implements SchemeFactory {
        private ValueListSubsetResultTupleSchemeFactory() {
        }

        public ValueListSubsetResultTupleScheme getScheme() {
            return new ValueListSubsetResultTupleScheme();
        }
    }

    private static class ValueListSubsetResultTupleScheme
    extends TupleScheme<ValueListSubsetResult> {
        private ValueListSubsetResultTupleScheme() {
        }

        public void write(TProtocol tProtocol, ValueListSubsetResult valueListSubsetResult) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (valueListSubsetResult.isSetObjectSpec()) {
                bitSet.set(0);
            }
            if (valueListSubsetResult.isSetData()) {
                bitSet.set(1);
            }
            tTupleProtocol.writeBitSet(bitSet, 2);
            if (valueListSubsetResult.isSetObjectSpec()) {
                valueListSubsetResult.objectSpec.write((TProtocol)tTupleProtocol);
            }
            if (valueListSubsetResult.isSetData()) {
                valueListSubsetResult.data.write((TProtocol)tTupleProtocol);
            }
        }

        public void read(TProtocol tProtocol, ValueListSubsetResult valueListSubsetResult) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(2);
            if (bitSet.get(0)) {
                valueListSubsetResult.objectSpec = new ObjectSpec();
                valueListSubsetResult.objectSpec.read((TProtocol)tTupleProtocol);
                valueListSubsetResult.setObjectSpecIsSet(true);
            }
            if (bitSet.get(1)) {
                valueListSubsetResult.data = new ValueListData();
                valueListSubsetResult.data.read((TProtocol)tTupleProtocol);
                valueListSubsetResult.setDataIsSet(true);
            }
        }
    }

    private static class ValueListSubsetResultStandardScheme
    extends StandardScheme<ValueListSubsetResult> {
        private ValueListSubsetResultStandardScheme() {
        }

        public void read(TProtocol tProtocol, ValueListSubsetResult valueListSubsetResult) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 12) {
                            valueListSubsetResult.objectSpec = new ObjectSpec();
                            valueListSubsetResult.objectSpec.read(tProtocol);
                            valueListSubsetResult.setObjectSpecIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 12) {
                            valueListSubsetResult.data = new ValueListData();
                            valueListSubsetResult.data.read(tProtocol);
                            valueListSubsetResult.setDataIsSet(true);
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
            valueListSubsetResult.validate();
        }

        public void write(TProtocol tProtocol, ValueListSubsetResult valueListSubsetResult) throws TException {
            valueListSubsetResult.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (valueListSubsetResult.objectSpec != null) {
                tProtocol.writeFieldBegin(OBJECT_SPEC_FIELD_DESC);
                valueListSubsetResult.objectSpec.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            if (valueListSubsetResult.data != null) {
                tProtocol.writeFieldBegin(DATA_FIELD_DESC);
                valueListSubsetResult.data.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

