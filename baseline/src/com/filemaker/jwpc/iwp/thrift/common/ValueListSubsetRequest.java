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
import org.apache.thrift.EncodingUtils;
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

public class ValueListSubsetRequest
implements TBase<ValueListSubsetRequest, _Fields>,
Serializable,
Cloneable,
Comparable<ValueListSubsetRequest> {
    private static final TStruct STRUCT_DESC = new TStruct("ValueListSubsetRequest");
    private static final TField OBJECT_SPEC_FIELD_DESC = new TField("objectSpec", 12, 1);
    private static final TField START_FIELD_DESC = new TField("start", 8, 2);
    private static final TField VALUES_COUNT_FIELD_DESC = new TField("valuesCount", 8, 3);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new ValueListSubsetRequestStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new ValueListSubsetRequestTupleSchemeFactory();
    @Nullable
    private ObjectSpec objectSpec;
    private int start;
    private int valuesCount;
    private static final int __START_ISSET_ID = 0;
    private static final int __VALUESCOUNT_ISSET_ID = 1;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public ValueListSubsetRequest() {
    }

    public ValueListSubsetRequest(ObjectSpec objectSpec, int n, int n2) {
        this();
        this.objectSpec = objectSpec;
        this.start = n;
        this.setStartIsSet(true);
        this.valuesCount = n2;
        this.setValuesCountIsSet(true);
    }

    public ValueListSubsetRequest(ValueListSubsetRequest valueListSubsetRequest) {
        this.__isset_bitfield = valueListSubsetRequest.__isset_bitfield;
        if (valueListSubsetRequest.isSetObjectSpec()) {
            this.objectSpec = new ObjectSpec(valueListSubsetRequest.objectSpec);
        }
        this.start = valueListSubsetRequest.start;
        this.valuesCount = valueListSubsetRequest.valuesCount;
    }

    public ValueListSubsetRequest deepCopy() {
        return new ValueListSubsetRequest(this);
    }

    public void clear() {
        this.objectSpec = null;
        this.setStartIsSet(false);
        this.start = 0;
        this.setValuesCountIsSet(false);
        this.valuesCount = 0;
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

    public int getStart() {
        return this.start;
    }

    public void setStart(int n) {
        this.start = n;
        this.setStartIsSet(true);
    }

    public void unsetStart() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetStart() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setStartIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public int getValuesCount() {
        return this.valuesCount;
    }

    public void setValuesCount(int n) {
        this.valuesCount = n;
        this.setValuesCountIsSet(true);
    }

    public void unsetValuesCount() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)1);
    }

    public boolean isSetValuesCount() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)1);
    }

    public void setValuesCountIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)1, (boolean)bl);
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
                    this.unsetStart();
                    break;
                }
                this.setStart((Integer)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetValuesCount();
                    break;
                }
                this.setValuesCount((Integer)object);
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
                return this.getStart();
            }
            case 2: {
                return this.getValuesCount();
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
                return this.isSetStart();
            }
            case 2: {
                return this.isSetValuesCount();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof ValueListSubsetRequest) {
            return this.equals((ValueListSubsetRequest)object);
        }
        return false;
    }

    public boolean equals(ValueListSubsetRequest valueListSubsetRequest) {
        if (valueListSubsetRequest == null) {
            return false;
        }
        if (this == valueListSubsetRequest) {
            return true;
        }
        boolean bl = this.isSetObjectSpec();
        boolean bl2 = valueListSubsetRequest.isSetObjectSpec();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.objectSpec.equals(valueListSubsetRequest.objectSpec)) {
                return false;
            }
        }
        boolean bl3 = true;
        boolean bl4 = true;
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (this.start != valueListSubsetRequest.start) {
                return false;
            }
        }
        boolean bl5 = true;
        boolean bl6 = true;
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (this.valuesCount != valueListSubsetRequest.valuesCount) {
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
        n = n * 8191 + this.start;
        n = n * 8191 + this.valuesCount;
        return n;
    }

    @Override
    public int compareTo(ValueListSubsetRequest valueListSubsetRequest) {
        if (!this.getClass().equals(valueListSubsetRequest.getClass())) {
            return this.getClass().getName().compareTo(valueListSubsetRequest.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetObjectSpec(), valueListSubsetRequest.isSetObjectSpec());
        if (n != 0) {
            return n;
        }
        if (this.isSetObjectSpec() && (n = TBaseHelper.compareTo((Comparable)this.objectSpec, (Comparable)valueListSubsetRequest.objectSpec)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetStart(), valueListSubsetRequest.isSetStart());
        if (n != 0) {
            return n;
        }
        if (this.isSetStart() && (n = TBaseHelper.compareTo((int)this.start, (int)valueListSubsetRequest.start)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetValuesCount(), valueListSubsetRequest.isSetValuesCount());
        if (n != 0) {
            return n;
        }
        if (this.isSetValuesCount() && (n = TBaseHelper.compareTo((int)this.valuesCount, (int)valueListSubsetRequest.valuesCount)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        ValueListSubsetRequest.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        ValueListSubsetRequest.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ValueListSubsetRequest(");
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
        stringBuilder.append("start:");
        stringBuilder.append(this.start);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("valuesCount:");
        stringBuilder.append(this.valuesCount);
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
        enumMap.put(_Fields.OBJECT_SPEC, new FieldMetaData("objectSpec", 3, (FieldValueMetaData)new StructMetaData(12, ObjectSpec.class)));
        enumMap.put(_Fields.START, new FieldMetaData("start", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.VALUES_COUNT, new FieldMetaData("valuesCount", 3, new FieldValueMetaData(8)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(ValueListSubsetRequest.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        OBJECT_SPEC(1, "objectSpec"),
        START(2, "start"),
        VALUES_COUNT(3, "valuesCount");

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
                    return START;
                }
                case 3: {
                    return VALUES_COUNT;
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

    private static class ValueListSubsetRequestStandardSchemeFactory
    implements SchemeFactory {
        private ValueListSubsetRequestStandardSchemeFactory() {
        }

        public ValueListSubsetRequestStandardScheme getScheme() {
            return new ValueListSubsetRequestStandardScheme();
        }
    }

    private static class ValueListSubsetRequestTupleSchemeFactory
    implements SchemeFactory {
        private ValueListSubsetRequestTupleSchemeFactory() {
        }

        public ValueListSubsetRequestTupleScheme getScheme() {
            return new ValueListSubsetRequestTupleScheme();
        }
    }

    private static class ValueListSubsetRequestTupleScheme
    extends TupleScheme<ValueListSubsetRequest> {
        private ValueListSubsetRequestTupleScheme() {
        }

        public void write(TProtocol tProtocol, ValueListSubsetRequest valueListSubsetRequest) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (valueListSubsetRequest.isSetObjectSpec()) {
                bitSet.set(0);
            }
            if (valueListSubsetRequest.isSetStart()) {
                bitSet.set(1);
            }
            if (valueListSubsetRequest.isSetValuesCount()) {
                bitSet.set(2);
            }
            tTupleProtocol.writeBitSet(bitSet, 3);
            if (valueListSubsetRequest.isSetObjectSpec()) {
                valueListSubsetRequest.objectSpec.write((TProtocol)tTupleProtocol);
            }
            if (valueListSubsetRequest.isSetStart()) {
                tTupleProtocol.writeI32(valueListSubsetRequest.start);
            }
            if (valueListSubsetRequest.isSetValuesCount()) {
                tTupleProtocol.writeI32(valueListSubsetRequest.valuesCount);
            }
        }

        public void read(TProtocol tProtocol, ValueListSubsetRequest valueListSubsetRequest) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(3);
            if (bitSet.get(0)) {
                valueListSubsetRequest.objectSpec = new ObjectSpec();
                valueListSubsetRequest.objectSpec.read((TProtocol)tTupleProtocol);
                valueListSubsetRequest.setObjectSpecIsSet(true);
            }
            if (bitSet.get(1)) {
                valueListSubsetRequest.start = tTupleProtocol.readI32();
                valueListSubsetRequest.setStartIsSet(true);
            }
            if (bitSet.get(2)) {
                valueListSubsetRequest.valuesCount = tTupleProtocol.readI32();
                valueListSubsetRequest.setValuesCountIsSet(true);
            }
        }
    }

    private static class ValueListSubsetRequestStandardScheme
    extends StandardScheme<ValueListSubsetRequest> {
        private ValueListSubsetRequestStandardScheme() {
        }

        public void read(TProtocol tProtocol, ValueListSubsetRequest valueListSubsetRequest) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 12) {
                            valueListSubsetRequest.objectSpec = new ObjectSpec();
                            valueListSubsetRequest.objectSpec.read(tProtocol);
                            valueListSubsetRequest.setObjectSpecIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 8) {
                            valueListSubsetRequest.start = tProtocol.readI32();
                            valueListSubsetRequest.setStartIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 8) {
                            valueListSubsetRequest.valuesCount = tProtocol.readI32();
                            valueListSubsetRequest.setValuesCountIsSet(true);
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
            valueListSubsetRequest.validate();
        }

        public void write(TProtocol tProtocol, ValueListSubsetRequest valueListSubsetRequest) throws TException {
            valueListSubsetRequest.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (valueListSubsetRequest.objectSpec != null) {
                tProtocol.writeFieldBegin(OBJECT_SPEC_FIELD_DESC);
                valueListSubsetRequest.objectSpec.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(START_FIELD_DESC);
            tProtocol.writeI32(valueListSubsetRequest.start);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(VALUES_COUNT_FIELD_DESC);
            tProtocol.writeI32(valueListSubsetRequest.valuesCount);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

