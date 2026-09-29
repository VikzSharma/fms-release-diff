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

public class FilteredValueListSubsetRequest
implements TBase<FilteredValueListSubsetRequest, _Fields>,
Serializable,
Cloneable,
Comparable<FilteredValueListSubsetRequest> {
    private static final TStruct STRUCT_DESC = new TStruct("FilteredValueListSubsetRequest");
    private static final TField OBJECT_SPEC_FIELD_DESC = new TField("objectSpec", 12, 1);
    private static final TField START_FIELD_DESC = new TField("start", 8, 2);
    private static final TField VALUES_COUNT_FIELD_DESC = new TField("valuesCount", 8, 3);
    private static final TField FILTER_FIELD_DESC = new TField("filter", 11, 4);
    private static final TField SHOW_SELECTED_VALUE_FIELD_DESC = new TField("showSelectedValue", 2, 5);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new FilteredValueListSubsetRequestStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new FilteredValueListSubsetRequestTupleSchemeFactory();
    @Nullable
    private ObjectSpec objectSpec;
    private int start;
    private int valuesCount;
    @Nullable
    private String filter;
    private boolean showSelectedValue;
    private static final int __START_ISSET_ID = 0;
    private static final int __VALUESCOUNT_ISSET_ID = 1;
    private static final int __SHOWSELECTEDVALUE_ISSET_ID = 2;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public FilteredValueListSubsetRequest() {
    }

    public FilteredValueListSubsetRequest(ObjectSpec objectSpec, int n, int n2, String string, boolean bl) {
        this();
        this.objectSpec = objectSpec;
        this.start = n;
        this.setStartIsSet(true);
        this.valuesCount = n2;
        this.setValuesCountIsSet(true);
        this.filter = string;
        this.showSelectedValue = bl;
        this.setShowSelectedValueIsSet(true);
    }

    public FilteredValueListSubsetRequest(FilteredValueListSubsetRequest filteredValueListSubsetRequest) {
        this.__isset_bitfield = filteredValueListSubsetRequest.__isset_bitfield;
        if (filteredValueListSubsetRequest.isSetObjectSpec()) {
            this.objectSpec = new ObjectSpec(filteredValueListSubsetRequest.objectSpec);
        }
        this.start = filteredValueListSubsetRequest.start;
        this.valuesCount = filteredValueListSubsetRequest.valuesCount;
        if (filteredValueListSubsetRequest.isSetFilter()) {
            this.filter = filteredValueListSubsetRequest.filter;
        }
        this.showSelectedValue = filteredValueListSubsetRequest.showSelectedValue;
    }

    public FilteredValueListSubsetRequest deepCopy() {
        return new FilteredValueListSubsetRequest(this);
    }

    public void clear() {
        this.objectSpec = null;
        this.setStartIsSet(false);
        this.start = 0;
        this.setValuesCountIsSet(false);
        this.valuesCount = 0;
        this.filter = null;
        this.setShowSelectedValueIsSet(false);
        this.showSelectedValue = false;
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

    @Nullable
    public String getFilter() {
        return this.filter;
    }

    public void setFilter(@Nullable String string) {
        this.filter = string;
    }

    public void unsetFilter() {
        this.filter = null;
    }

    public boolean isSetFilter() {
        return this.filter != null;
    }

    public void setFilterIsSet(boolean bl) {
        if (!bl) {
            this.filter = null;
        }
    }

    public boolean isShowSelectedValue() {
        return this.showSelectedValue;
    }

    public void setShowSelectedValue(boolean bl) {
        this.showSelectedValue = bl;
        this.setShowSelectedValueIsSet(true);
    }

    public void unsetShowSelectedValue() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)2);
    }

    public boolean isSetShowSelectedValue() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)2);
    }

    public void setShowSelectedValueIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)2, (boolean)bl);
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
                break;
            }
            case 3: {
                if (object == null) {
                    this.unsetFilter();
                    break;
                }
                this.setFilter((String)object);
                break;
            }
            case 4: {
                if (object == null) {
                    this.unsetShowSelectedValue();
                    break;
                }
                this.setShowSelectedValue((Boolean)object);
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
            case 3: {
                return this.getFilter();
            }
            case 4: {
                return this.isShowSelectedValue();
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
            case 3: {
                return this.isSetFilter();
            }
            case 4: {
                return this.isSetShowSelectedValue();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof FilteredValueListSubsetRequest) {
            return this.equals((FilteredValueListSubsetRequest)object);
        }
        return false;
    }

    public boolean equals(FilteredValueListSubsetRequest filteredValueListSubsetRequest) {
        if (filteredValueListSubsetRequest == null) {
            return false;
        }
        if (this == filteredValueListSubsetRequest) {
            return true;
        }
        boolean bl = this.isSetObjectSpec();
        boolean bl2 = filteredValueListSubsetRequest.isSetObjectSpec();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.objectSpec.equals(filteredValueListSubsetRequest.objectSpec)) {
                return false;
            }
        }
        boolean bl3 = true;
        boolean bl4 = true;
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (this.start != filteredValueListSubsetRequest.start) {
                return false;
            }
        }
        boolean bl5 = true;
        boolean bl6 = true;
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (this.valuesCount != filteredValueListSubsetRequest.valuesCount) {
                return false;
            }
        }
        boolean bl7 = this.isSetFilter();
        boolean bl8 = filteredValueListSubsetRequest.isSetFilter();
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (!this.filter.equals(filteredValueListSubsetRequest.filter)) {
                return false;
            }
        }
        boolean bl9 = true;
        boolean bl10 = true;
        if (bl9 || bl10) {
            if (!bl9 || !bl10) {
                return false;
            }
            if (this.showSelectedValue != filteredValueListSubsetRequest.showSelectedValue) {
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
        n = n * 8191 + (this.isSetFilter() ? 131071 : 524287);
        if (this.isSetFilter()) {
            n = n * 8191 + this.filter.hashCode();
        }
        n = n * 8191 + (this.showSelectedValue ? 131071 : 524287);
        return n;
    }

    @Override
    public int compareTo(FilteredValueListSubsetRequest filteredValueListSubsetRequest) {
        if (!this.getClass().equals(filteredValueListSubsetRequest.getClass())) {
            return this.getClass().getName().compareTo(filteredValueListSubsetRequest.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetObjectSpec(), filteredValueListSubsetRequest.isSetObjectSpec());
        if (n != 0) {
            return n;
        }
        if (this.isSetObjectSpec() && (n = TBaseHelper.compareTo((Comparable)this.objectSpec, (Comparable)filteredValueListSubsetRequest.objectSpec)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetStart(), filteredValueListSubsetRequest.isSetStart());
        if (n != 0) {
            return n;
        }
        if (this.isSetStart() && (n = TBaseHelper.compareTo((int)this.start, (int)filteredValueListSubsetRequest.start)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetValuesCount(), filteredValueListSubsetRequest.isSetValuesCount());
        if (n != 0) {
            return n;
        }
        if (this.isSetValuesCount() && (n = TBaseHelper.compareTo((int)this.valuesCount, (int)filteredValueListSubsetRequest.valuesCount)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetFilter(), filteredValueListSubsetRequest.isSetFilter());
        if (n != 0) {
            return n;
        }
        if (this.isSetFilter() && (n = TBaseHelper.compareTo((String)this.filter, (String)filteredValueListSubsetRequest.filter)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetShowSelectedValue(), filteredValueListSubsetRequest.isSetShowSelectedValue());
        if (n != 0) {
            return n;
        }
        if (this.isSetShowSelectedValue() && (n = TBaseHelper.compareTo((boolean)this.showSelectedValue, (boolean)filteredValueListSubsetRequest.showSelectedValue)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        FilteredValueListSubsetRequest.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        FilteredValueListSubsetRequest.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("FilteredValueListSubsetRequest(");
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
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("filter:");
        if (this.filter == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.filter);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("showSelectedValue:");
        stringBuilder.append(this.showSelectedValue);
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
        enumMap.put(_Fields.FILTER, new FieldMetaData("filter", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.SHOW_SELECTED_VALUE, new FieldMetaData("showSelectedValue", 3, new FieldValueMetaData(2)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(FilteredValueListSubsetRequest.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        OBJECT_SPEC(1, "objectSpec"),
        START(2, "start"),
        VALUES_COUNT(3, "valuesCount"),
        FILTER(4, "filter"),
        SHOW_SELECTED_VALUE(5, "showSelectedValue");

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
                case 4: {
                    return FILTER;
                }
                case 5: {
                    return SHOW_SELECTED_VALUE;
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

    private static class FilteredValueListSubsetRequestStandardSchemeFactory
    implements SchemeFactory {
        private FilteredValueListSubsetRequestStandardSchemeFactory() {
        }

        public FilteredValueListSubsetRequestStandardScheme getScheme() {
            return new FilteredValueListSubsetRequestStandardScheme();
        }
    }

    private static class FilteredValueListSubsetRequestTupleSchemeFactory
    implements SchemeFactory {
        private FilteredValueListSubsetRequestTupleSchemeFactory() {
        }

        public FilteredValueListSubsetRequestTupleScheme getScheme() {
            return new FilteredValueListSubsetRequestTupleScheme();
        }
    }

    private static class FilteredValueListSubsetRequestTupleScheme
    extends TupleScheme<FilteredValueListSubsetRequest> {
        private FilteredValueListSubsetRequestTupleScheme() {
        }

        public void write(TProtocol tProtocol, FilteredValueListSubsetRequest filteredValueListSubsetRequest) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (filteredValueListSubsetRequest.isSetObjectSpec()) {
                bitSet.set(0);
            }
            if (filteredValueListSubsetRequest.isSetStart()) {
                bitSet.set(1);
            }
            if (filteredValueListSubsetRequest.isSetValuesCount()) {
                bitSet.set(2);
            }
            if (filteredValueListSubsetRequest.isSetFilter()) {
                bitSet.set(3);
            }
            if (filteredValueListSubsetRequest.isSetShowSelectedValue()) {
                bitSet.set(4);
            }
            tTupleProtocol.writeBitSet(bitSet, 5);
            if (filteredValueListSubsetRequest.isSetObjectSpec()) {
                filteredValueListSubsetRequest.objectSpec.write((TProtocol)tTupleProtocol);
            }
            if (filteredValueListSubsetRequest.isSetStart()) {
                tTupleProtocol.writeI32(filteredValueListSubsetRequest.start);
            }
            if (filteredValueListSubsetRequest.isSetValuesCount()) {
                tTupleProtocol.writeI32(filteredValueListSubsetRequest.valuesCount);
            }
            if (filteredValueListSubsetRequest.isSetFilter()) {
                tTupleProtocol.writeString(filteredValueListSubsetRequest.filter);
            }
            if (filteredValueListSubsetRequest.isSetShowSelectedValue()) {
                tTupleProtocol.writeBool(filteredValueListSubsetRequest.showSelectedValue);
            }
        }

        public void read(TProtocol tProtocol, FilteredValueListSubsetRequest filteredValueListSubsetRequest) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(5);
            if (bitSet.get(0)) {
                filteredValueListSubsetRequest.objectSpec = new ObjectSpec();
                filteredValueListSubsetRequest.objectSpec.read((TProtocol)tTupleProtocol);
                filteredValueListSubsetRequest.setObjectSpecIsSet(true);
            }
            if (bitSet.get(1)) {
                filteredValueListSubsetRequest.start = tTupleProtocol.readI32();
                filteredValueListSubsetRequest.setStartIsSet(true);
            }
            if (bitSet.get(2)) {
                filteredValueListSubsetRequest.valuesCount = tTupleProtocol.readI32();
                filteredValueListSubsetRequest.setValuesCountIsSet(true);
            }
            if (bitSet.get(3)) {
                filteredValueListSubsetRequest.filter = tTupleProtocol.readString();
                filteredValueListSubsetRequest.setFilterIsSet(true);
            }
            if (bitSet.get(4)) {
                filteredValueListSubsetRequest.showSelectedValue = tTupleProtocol.readBool();
                filteredValueListSubsetRequest.setShowSelectedValueIsSet(true);
            }
        }
    }

    private static class FilteredValueListSubsetRequestStandardScheme
    extends StandardScheme<FilteredValueListSubsetRequest> {
        private FilteredValueListSubsetRequestStandardScheme() {
        }

        public void read(TProtocol tProtocol, FilteredValueListSubsetRequest filteredValueListSubsetRequest) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 12) {
                            filteredValueListSubsetRequest.objectSpec = new ObjectSpec();
                            filteredValueListSubsetRequest.objectSpec.read(tProtocol);
                            filteredValueListSubsetRequest.setObjectSpecIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 8) {
                            filteredValueListSubsetRequest.start = tProtocol.readI32();
                            filteredValueListSubsetRequest.setStartIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 8) {
                            filteredValueListSubsetRequest.valuesCount = tProtocol.readI32();
                            filteredValueListSubsetRequest.setValuesCountIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 11) {
                            filteredValueListSubsetRequest.filter = tProtocol.readString();
                            filteredValueListSubsetRequest.setFilterIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 5: {
                        if (tField.type == 2) {
                            filteredValueListSubsetRequest.showSelectedValue = tProtocol.readBool();
                            filteredValueListSubsetRequest.setShowSelectedValueIsSet(true);
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
            filteredValueListSubsetRequest.validate();
        }

        public void write(TProtocol tProtocol, FilteredValueListSubsetRequest filteredValueListSubsetRequest) throws TException {
            filteredValueListSubsetRequest.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (filteredValueListSubsetRequest.objectSpec != null) {
                tProtocol.writeFieldBegin(OBJECT_SPEC_FIELD_DESC);
                filteredValueListSubsetRequest.objectSpec.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(START_FIELD_DESC);
            tProtocol.writeI32(filteredValueListSubsetRequest.start);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(VALUES_COUNT_FIELD_DESC);
            tProtocol.writeI32(filteredValueListSubsetRequest.valuesCount);
            tProtocol.writeFieldEnd();
            if (filteredValueListSubsetRequest.filter != null) {
                tProtocol.writeFieldBegin(FILTER_FIELD_DESC);
                tProtocol.writeString(filteredValueListSubsetRequest.filter);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(SHOW_SELECTED_VALUE_FIELD_DESC);
            tProtocol.writeBool(filteredValueListSubsetRequest.showSelectedValue);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

