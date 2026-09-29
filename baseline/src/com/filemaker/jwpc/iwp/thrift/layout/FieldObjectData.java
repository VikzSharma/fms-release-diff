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
package com.filemaker.jwpc.iwp.thrift.layout;

import com.filemaker.jwpc.iwp.thrift.common.ObjectSpec;
import com.filemaker.jwpc.iwp.thrift.layout.FieldData;
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

public class FieldObjectData
implements TBase<FieldObjectData, _Fields>,
Serializable,
Cloneable,
Comparable<FieldObjectData> {
    private static final TStruct STRUCT_DESC = new TStruct("FieldObjectData");
    private static final TField OBJECT_SPEC_FIELD_DESC = new TField("objectSpec", 12, 1);
    private static final TField FIELD_DATA_FIELD_DESC = new TField("fieldData", 12, 2);
    private static final TField PARENT_FIELD_ID_OF_SUMMARY_FIELD_FIELD_DESC = new TField("parentFieldIdOfSummaryField", 8, 3);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new FieldObjectDataStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new FieldObjectDataTupleSchemeFactory();
    @Nullable
    private ObjectSpec objectSpec;
    @Nullable
    private FieldData fieldData;
    private int parentFieldIdOfSummaryField;
    private static final int __PARENTFIELDIDOFSUMMARYFIELD_ISSET_ID = 0;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public FieldObjectData() {
        this.parentFieldIdOfSummaryField = 0;
    }

    public FieldObjectData(ObjectSpec objectSpec, FieldData fieldData, int n) {
        this();
        this.objectSpec = objectSpec;
        this.fieldData = fieldData;
        this.parentFieldIdOfSummaryField = n;
        this.setParentFieldIdOfSummaryFieldIsSet(true);
    }

    public FieldObjectData(FieldObjectData fieldObjectData) {
        this.__isset_bitfield = fieldObjectData.__isset_bitfield;
        if (fieldObjectData.isSetObjectSpec()) {
            this.objectSpec = new ObjectSpec(fieldObjectData.objectSpec);
        }
        if (fieldObjectData.isSetFieldData()) {
            this.fieldData = new FieldData(fieldObjectData.fieldData);
        }
        this.parentFieldIdOfSummaryField = fieldObjectData.parentFieldIdOfSummaryField;
    }

    public FieldObjectData deepCopy() {
        return new FieldObjectData(this);
    }

    public void clear() {
        this.objectSpec = null;
        this.fieldData = null;
        this.parentFieldIdOfSummaryField = 0;
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
    public FieldData getFieldData() {
        return this.fieldData;
    }

    public void setFieldData(@Nullable FieldData fieldData) {
        this.fieldData = fieldData;
    }

    public void unsetFieldData() {
        this.fieldData = null;
    }

    public boolean isSetFieldData() {
        return this.fieldData != null;
    }

    public void setFieldDataIsSet(boolean bl) {
        if (!bl) {
            this.fieldData = null;
        }
    }

    public int getParentFieldIdOfSummaryField() {
        return this.parentFieldIdOfSummaryField;
    }

    public void setParentFieldIdOfSummaryField(int n) {
        this.parentFieldIdOfSummaryField = n;
        this.setParentFieldIdOfSummaryFieldIsSet(true);
    }

    public void unsetParentFieldIdOfSummaryField() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetParentFieldIdOfSummaryField() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setParentFieldIdOfSummaryFieldIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
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
                    this.unsetFieldData();
                    break;
                }
                this.setFieldData((FieldData)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetParentFieldIdOfSummaryField();
                    break;
                }
                this.setParentFieldIdOfSummaryField((Integer)object);
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
                return this.getFieldData();
            }
            case 2: {
                return this.getParentFieldIdOfSummaryField();
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
                return this.isSetFieldData();
            }
            case 2: {
                return this.isSetParentFieldIdOfSummaryField();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof FieldObjectData) {
            return this.equals((FieldObjectData)object);
        }
        return false;
    }

    public boolean equals(FieldObjectData fieldObjectData) {
        if (fieldObjectData == null) {
            return false;
        }
        if (this == fieldObjectData) {
            return true;
        }
        boolean bl = this.isSetObjectSpec();
        boolean bl2 = fieldObjectData.isSetObjectSpec();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.objectSpec.equals(fieldObjectData.objectSpec)) {
                return false;
            }
        }
        boolean bl3 = this.isSetFieldData();
        boolean bl4 = fieldObjectData.isSetFieldData();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.fieldData.equals(fieldObjectData.fieldData)) {
                return false;
            }
        }
        boolean bl5 = true;
        boolean bl6 = true;
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (this.parentFieldIdOfSummaryField != fieldObjectData.parentFieldIdOfSummaryField) {
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
        n = n * 8191 + (this.isSetFieldData() ? 131071 : 524287);
        if (this.isSetFieldData()) {
            n = n * 8191 + this.fieldData.hashCode();
        }
        n = n * 8191 + this.parentFieldIdOfSummaryField;
        return n;
    }

    @Override
    public int compareTo(FieldObjectData fieldObjectData) {
        if (!this.getClass().equals(fieldObjectData.getClass())) {
            return this.getClass().getName().compareTo(fieldObjectData.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetObjectSpec(), fieldObjectData.isSetObjectSpec());
        if (n != 0) {
            return n;
        }
        if (this.isSetObjectSpec() && (n = TBaseHelper.compareTo((Comparable)this.objectSpec, (Comparable)fieldObjectData.objectSpec)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetFieldData(), fieldObjectData.isSetFieldData());
        if (n != 0) {
            return n;
        }
        if (this.isSetFieldData() && (n = TBaseHelper.compareTo((Comparable)this.fieldData, (Comparable)fieldObjectData.fieldData)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetParentFieldIdOfSummaryField(), fieldObjectData.isSetParentFieldIdOfSummaryField());
        if (n != 0) {
            return n;
        }
        if (this.isSetParentFieldIdOfSummaryField() && (n = TBaseHelper.compareTo((int)this.parentFieldIdOfSummaryField, (int)fieldObjectData.parentFieldIdOfSummaryField)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        FieldObjectData.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        FieldObjectData.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("FieldObjectData(");
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
        stringBuilder.append("fieldData:");
        if (this.fieldData == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.fieldData);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("parentFieldIdOfSummaryField:");
        stringBuilder.append(this.parentFieldIdOfSummaryField);
        bl = false;
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void validate() throws TException {
        if (this.objectSpec != null) {
            this.objectSpec.validate();
        }
        if (this.fieldData != null) {
            this.fieldData.validate();
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
        enumMap.put(_Fields.FIELD_DATA, new FieldMetaData("fieldData", 3, (FieldValueMetaData)new StructMetaData(12, FieldData.class)));
        enumMap.put(_Fields.PARENT_FIELD_ID_OF_SUMMARY_FIELD, new FieldMetaData("parentFieldIdOfSummaryField", 3, new FieldValueMetaData(8)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(FieldObjectData.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        OBJECT_SPEC(1, "objectSpec"),
        FIELD_DATA(2, "fieldData"),
        PARENT_FIELD_ID_OF_SUMMARY_FIELD(3, "parentFieldIdOfSummaryField");

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
                    return FIELD_DATA;
                }
                case 3: {
                    return PARENT_FIELD_ID_OF_SUMMARY_FIELD;
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

    private static class FieldObjectDataStandardSchemeFactory
    implements SchemeFactory {
        private FieldObjectDataStandardSchemeFactory() {
        }

        public FieldObjectDataStandardScheme getScheme() {
            return new FieldObjectDataStandardScheme();
        }
    }

    private static class FieldObjectDataTupleSchemeFactory
    implements SchemeFactory {
        private FieldObjectDataTupleSchemeFactory() {
        }

        public FieldObjectDataTupleScheme getScheme() {
            return new FieldObjectDataTupleScheme();
        }
    }

    private static class FieldObjectDataTupleScheme
    extends TupleScheme<FieldObjectData> {
        private FieldObjectDataTupleScheme() {
        }

        public void write(TProtocol tProtocol, FieldObjectData fieldObjectData) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (fieldObjectData.isSetObjectSpec()) {
                bitSet.set(0);
            }
            if (fieldObjectData.isSetFieldData()) {
                bitSet.set(1);
            }
            if (fieldObjectData.isSetParentFieldIdOfSummaryField()) {
                bitSet.set(2);
            }
            tTupleProtocol.writeBitSet(bitSet, 3);
            if (fieldObjectData.isSetObjectSpec()) {
                fieldObjectData.objectSpec.write((TProtocol)tTupleProtocol);
            }
            if (fieldObjectData.isSetFieldData()) {
                fieldObjectData.fieldData.write((TProtocol)tTupleProtocol);
            }
            if (fieldObjectData.isSetParentFieldIdOfSummaryField()) {
                tTupleProtocol.writeI32(fieldObjectData.parentFieldIdOfSummaryField);
            }
        }

        public void read(TProtocol tProtocol, FieldObjectData fieldObjectData) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(3);
            if (bitSet.get(0)) {
                fieldObjectData.objectSpec = new ObjectSpec();
                fieldObjectData.objectSpec.read((TProtocol)tTupleProtocol);
                fieldObjectData.setObjectSpecIsSet(true);
            }
            if (bitSet.get(1)) {
                fieldObjectData.fieldData = new FieldData();
                fieldObjectData.fieldData.read((TProtocol)tTupleProtocol);
                fieldObjectData.setFieldDataIsSet(true);
            }
            if (bitSet.get(2)) {
                fieldObjectData.parentFieldIdOfSummaryField = tTupleProtocol.readI32();
                fieldObjectData.setParentFieldIdOfSummaryFieldIsSet(true);
            }
        }
    }

    private static class FieldObjectDataStandardScheme
    extends StandardScheme<FieldObjectData> {
        private FieldObjectDataStandardScheme() {
        }

        public void read(TProtocol tProtocol, FieldObjectData fieldObjectData) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 12) {
                            fieldObjectData.objectSpec = new ObjectSpec();
                            fieldObjectData.objectSpec.read(tProtocol);
                            fieldObjectData.setObjectSpecIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 12) {
                            fieldObjectData.fieldData = new FieldData();
                            fieldObjectData.fieldData.read(tProtocol);
                            fieldObjectData.setFieldDataIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 8) {
                            fieldObjectData.parentFieldIdOfSummaryField = tProtocol.readI32();
                            fieldObjectData.setParentFieldIdOfSummaryFieldIsSet(true);
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
            fieldObjectData.validate();
        }

        public void write(TProtocol tProtocol, FieldObjectData fieldObjectData) throws TException {
            fieldObjectData.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (fieldObjectData.objectSpec != null) {
                tProtocol.writeFieldBegin(OBJECT_SPEC_FIELD_DESC);
                fieldObjectData.objectSpec.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            if (fieldObjectData.fieldData != null) {
                tProtocol.writeFieldBegin(FIELD_DATA_FIELD_DESC);
                fieldObjectData.fieldData.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(PARENT_FIELD_ID_OF_SUMMARY_FIELD_FIELD_DESC);
            tProtocol.writeI32(fieldObjectData.parentFieldIdOfSummaryField);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

