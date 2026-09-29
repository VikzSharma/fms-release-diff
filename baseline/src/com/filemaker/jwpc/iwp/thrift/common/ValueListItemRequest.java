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

public class ValueListItemRequest
implements TBase<ValueListItemRequest, _Fields>,
Serializable,
Cloneable,
Comparable<ValueListItemRequest> {
    private static final TStruct STRUCT_DESC = new TStruct("ValueListItemRequest");
    private static final TField OBJECT_SPEC_FIELD_DESC = new TField("objectSpec", 12, 1);
    private static final TField VALUE_FIELD_DESC = new TField("value", 11, 2);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new ValueListItemRequestStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new ValueListItemRequestTupleSchemeFactory();
    @Nullable
    private ObjectSpec objectSpec;
    @Nullable
    private String value;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public ValueListItemRequest() {
    }

    public ValueListItemRequest(ObjectSpec objectSpec, String string) {
        this();
        this.objectSpec = objectSpec;
        this.value = string;
    }

    public ValueListItemRequest(ValueListItemRequest valueListItemRequest) {
        if (valueListItemRequest.isSetObjectSpec()) {
            this.objectSpec = new ObjectSpec(valueListItemRequest.objectSpec);
        }
        if (valueListItemRequest.isSetValue()) {
            this.value = valueListItemRequest.value;
        }
    }

    public ValueListItemRequest deepCopy() {
        return new ValueListItemRequest(this);
    }

    public void clear() {
        this.objectSpec = null;
        this.value = null;
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
    public String getValue() {
        return this.value;
    }

    public void setValue(@Nullable String string) {
        this.value = string;
    }

    public void unsetValue() {
        this.value = null;
    }

    public boolean isSetValue() {
        return this.value != null;
    }

    public void setValueIsSet(boolean bl) {
        if (!bl) {
            this.value = null;
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
                    this.unsetValue();
                    break;
                }
                this.setValue((String)object);
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
                return this.getValue();
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
                return this.isSetValue();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof ValueListItemRequest) {
            return this.equals((ValueListItemRequest)object);
        }
        return false;
    }

    public boolean equals(ValueListItemRequest valueListItemRequest) {
        if (valueListItemRequest == null) {
            return false;
        }
        if (this == valueListItemRequest) {
            return true;
        }
        boolean bl = this.isSetObjectSpec();
        boolean bl2 = valueListItemRequest.isSetObjectSpec();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.objectSpec.equals(valueListItemRequest.objectSpec)) {
                return false;
            }
        }
        boolean bl3 = this.isSetValue();
        boolean bl4 = valueListItemRequest.isSetValue();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.value.equals(valueListItemRequest.value)) {
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
        n = n * 8191 + (this.isSetValue() ? 131071 : 524287);
        if (this.isSetValue()) {
            n = n * 8191 + this.value.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(ValueListItemRequest valueListItemRequest) {
        if (!this.getClass().equals(valueListItemRequest.getClass())) {
            return this.getClass().getName().compareTo(valueListItemRequest.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetObjectSpec(), valueListItemRequest.isSetObjectSpec());
        if (n != 0) {
            return n;
        }
        if (this.isSetObjectSpec() && (n = TBaseHelper.compareTo((Comparable)this.objectSpec, (Comparable)valueListItemRequest.objectSpec)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetValue(), valueListItemRequest.isSetValue());
        if (n != 0) {
            return n;
        }
        if (this.isSetValue() && (n = TBaseHelper.compareTo((String)this.value, (String)valueListItemRequest.value)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        ValueListItemRequest.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        ValueListItemRequest.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ValueListItemRequest(");
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
        stringBuilder.append("value:");
        if (this.value == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.value);
        }
        bl = false;
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void validate() throws TException {
        if (this.objectSpec != null) {
            this.objectSpec.validate();
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
        enumMap.put(_Fields.VALUE, new FieldMetaData("value", 3, new FieldValueMetaData(11)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(ValueListItemRequest.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        OBJECT_SPEC(1, "objectSpec"),
        VALUE(2, "value");

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
                    return VALUE;
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

    private static class ValueListItemRequestStandardSchemeFactory
    implements SchemeFactory {
        private ValueListItemRequestStandardSchemeFactory() {
        }

        public ValueListItemRequestStandardScheme getScheme() {
            return new ValueListItemRequestStandardScheme();
        }
    }

    private static class ValueListItemRequestTupleSchemeFactory
    implements SchemeFactory {
        private ValueListItemRequestTupleSchemeFactory() {
        }

        public ValueListItemRequestTupleScheme getScheme() {
            return new ValueListItemRequestTupleScheme();
        }
    }

    private static class ValueListItemRequestTupleScheme
    extends TupleScheme<ValueListItemRequest> {
        private ValueListItemRequestTupleScheme() {
        }

        public void write(TProtocol tProtocol, ValueListItemRequest valueListItemRequest) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (valueListItemRequest.isSetObjectSpec()) {
                bitSet.set(0);
            }
            if (valueListItemRequest.isSetValue()) {
                bitSet.set(1);
            }
            tTupleProtocol.writeBitSet(bitSet, 2);
            if (valueListItemRequest.isSetObjectSpec()) {
                valueListItemRequest.objectSpec.write((TProtocol)tTupleProtocol);
            }
            if (valueListItemRequest.isSetValue()) {
                tTupleProtocol.writeString(valueListItemRequest.value);
            }
        }

        public void read(TProtocol tProtocol, ValueListItemRequest valueListItemRequest) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(2);
            if (bitSet.get(0)) {
                valueListItemRequest.objectSpec = new ObjectSpec();
                valueListItemRequest.objectSpec.read((TProtocol)tTupleProtocol);
                valueListItemRequest.setObjectSpecIsSet(true);
            }
            if (bitSet.get(1)) {
                valueListItemRequest.value = tTupleProtocol.readString();
                valueListItemRequest.setValueIsSet(true);
            }
        }
    }

    private static class ValueListItemRequestStandardScheme
    extends StandardScheme<ValueListItemRequest> {
        private ValueListItemRequestStandardScheme() {
        }

        public void read(TProtocol tProtocol, ValueListItemRequest valueListItemRequest) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 12) {
                            valueListItemRequest.objectSpec = new ObjectSpec();
                            valueListItemRequest.objectSpec.read(tProtocol);
                            valueListItemRequest.setObjectSpecIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 11) {
                            valueListItemRequest.value = tProtocol.readString();
                            valueListItemRequest.setValueIsSet(true);
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
            valueListItemRequest.validate();
        }

        public void write(TProtocol tProtocol, ValueListItemRequest valueListItemRequest) throws TException {
            valueListItemRequest.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (valueListItemRequest.objectSpec != null) {
                tProtocol.writeFieldBegin(OBJECT_SPEC_FIELD_DESC);
                valueListItemRequest.objectSpec.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            if (valueListItemRequest.value != null) {
                tProtocol.writeFieldBegin(VALUE_FIELD_DESC);
                tProtocol.writeString(valueListItemRequest.value);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

