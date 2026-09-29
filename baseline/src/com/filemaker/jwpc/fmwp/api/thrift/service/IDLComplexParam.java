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
package com.filemaker.jwpc.fmwp.api.thrift.service;

import com.filemaker.jwpc.fmwp.api.thrift.service.IDLFieldParam;
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

public class IDLComplexParam
implements TBase<IDLComplexParam, _Fields>,
Serializable,
Cloneable,
Comparable<IDLComplexParam> {
    private static final TStruct STRUCT_DESC = new TStruct("IDLComplexParam");
    private static final TField FIELD_FIELD_DESC = new TField("field", 12, 1);
    private static final TField TABLE_FIELD_DESC = new TField("table", 11, 2);
    private static final TField RECORD_ID_FIELD_DESC = new TField("recordId", 11, 3);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new IDLComplexParamStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new IDLComplexParamTupleSchemeFactory();
    @Nullable
    private IDLFieldParam field;
    @Nullable
    private String table;
    @Nullable
    private String recordId;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public IDLComplexParam() {
    }

    public IDLComplexParam(IDLFieldParam iDLFieldParam, String string, String string2) {
        this();
        this.field = iDLFieldParam;
        this.table = string;
        this.recordId = string2;
    }

    public IDLComplexParam(IDLComplexParam iDLComplexParam) {
        if (iDLComplexParam.isSetField()) {
            this.field = new IDLFieldParam(iDLComplexParam.field);
        }
        if (iDLComplexParam.isSetTable()) {
            this.table = iDLComplexParam.table;
        }
        if (iDLComplexParam.isSetRecordId()) {
            this.recordId = iDLComplexParam.recordId;
        }
    }

    public IDLComplexParam deepCopy() {
        return new IDLComplexParam(this);
    }

    public void clear() {
        this.field = null;
        this.table = null;
        this.recordId = null;
    }

    @Nullable
    public IDLFieldParam getField() {
        return this.field;
    }

    public void setField(@Nullable IDLFieldParam iDLFieldParam) {
        this.field = iDLFieldParam;
    }

    public void unsetField() {
        this.field = null;
    }

    public boolean isSetField() {
        return this.field != null;
    }

    public void setFieldIsSet(boolean bl) {
        if (!bl) {
            this.field = null;
        }
    }

    @Nullable
    public String getTable() {
        return this.table;
    }

    public void setTable(@Nullable String string) {
        this.table = string;
    }

    public void unsetTable() {
        this.table = null;
    }

    public boolean isSetTable() {
        return this.table != null;
    }

    public void setTableIsSet(boolean bl) {
        if (!bl) {
            this.table = null;
        }
    }

    @Nullable
    public String getRecordId() {
        return this.recordId;
    }

    public void setRecordId(@Nullable String string) {
        this.recordId = string;
    }

    public void unsetRecordId() {
        this.recordId = null;
    }

    public boolean isSetRecordId() {
        return this.recordId != null;
    }

    public void setRecordIdIsSet(boolean bl) {
        if (!bl) {
            this.recordId = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetField();
                    break;
                }
                this.setField((IDLFieldParam)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetTable();
                    break;
                }
                this.setTable((String)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetRecordId();
                    break;
                }
                this.setRecordId((String)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getField();
            }
            case 1: {
                return this.getTable();
            }
            case 2: {
                return this.getRecordId();
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
                return this.isSetField();
            }
            case 1: {
                return this.isSetTable();
            }
            case 2: {
                return this.isSetRecordId();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof IDLComplexParam) {
            return this.equals((IDLComplexParam)object);
        }
        return false;
    }

    public boolean equals(IDLComplexParam iDLComplexParam) {
        if (iDLComplexParam == null) {
            return false;
        }
        if (this == iDLComplexParam) {
            return true;
        }
        boolean bl = this.isSetField();
        boolean bl2 = iDLComplexParam.isSetField();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.field.equals(iDLComplexParam.field)) {
                return false;
            }
        }
        boolean bl3 = this.isSetTable();
        boolean bl4 = iDLComplexParam.isSetTable();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.table.equals(iDLComplexParam.table)) {
                return false;
            }
        }
        boolean bl5 = this.isSetRecordId();
        boolean bl6 = iDLComplexParam.isSetRecordId();
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (!this.recordId.equals(iDLComplexParam.recordId)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetField() ? 131071 : 524287);
        if (this.isSetField()) {
            n = n * 8191 + this.field.hashCode();
        }
        n = n * 8191 + (this.isSetTable() ? 131071 : 524287);
        if (this.isSetTable()) {
            n = n * 8191 + this.table.hashCode();
        }
        n = n * 8191 + (this.isSetRecordId() ? 131071 : 524287);
        if (this.isSetRecordId()) {
            n = n * 8191 + this.recordId.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(IDLComplexParam iDLComplexParam) {
        if (!this.getClass().equals(iDLComplexParam.getClass())) {
            return this.getClass().getName().compareTo(iDLComplexParam.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetField(), iDLComplexParam.isSetField());
        if (n != 0) {
            return n;
        }
        if (this.isSetField() && (n = TBaseHelper.compareTo((Comparable)this.field, (Comparable)iDLComplexParam.field)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetTable(), iDLComplexParam.isSetTable());
        if (n != 0) {
            return n;
        }
        if (this.isSetTable() && (n = TBaseHelper.compareTo((String)this.table, (String)iDLComplexParam.table)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetRecordId(), iDLComplexParam.isSetRecordId());
        if (n != 0) {
            return n;
        }
        if (this.isSetRecordId() && (n = TBaseHelper.compareTo((String)this.recordId, (String)iDLComplexParam.recordId)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        IDLComplexParam.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        IDLComplexParam.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("IDLComplexParam(");
        boolean bl = true;
        stringBuilder.append("field:");
        if (this.field == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.field);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("table:");
        if (this.table == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.table);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("recordId:");
        if (this.recordId == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.recordId);
        }
        bl = false;
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void validate() throws TException {
        if (this.field != null) {
            this.field.validate();
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
        enumMap.put(_Fields.FIELD, new FieldMetaData("field", 3, (FieldValueMetaData)new StructMetaData(12, IDLFieldParam.class)));
        enumMap.put(_Fields.TABLE, new FieldMetaData("table", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.RECORD_ID, new FieldMetaData("recordId", 3, new FieldValueMetaData(11)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(IDLComplexParam.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        FIELD(1, "field"),
        TABLE(2, "table"),
        RECORD_ID(3, "recordId");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return FIELD;
                }
                case 2: {
                    return TABLE;
                }
                case 3: {
                    return RECORD_ID;
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

    private static class IDLComplexParamStandardSchemeFactory
    implements SchemeFactory {
        private IDLComplexParamStandardSchemeFactory() {
        }

        public IDLComplexParamStandardScheme getScheme() {
            return new IDLComplexParamStandardScheme();
        }
    }

    private static class IDLComplexParamTupleSchemeFactory
    implements SchemeFactory {
        private IDLComplexParamTupleSchemeFactory() {
        }

        public IDLComplexParamTupleScheme getScheme() {
            return new IDLComplexParamTupleScheme();
        }
    }

    private static class IDLComplexParamTupleScheme
    extends TupleScheme<IDLComplexParam> {
        private IDLComplexParamTupleScheme() {
        }

        public void write(TProtocol tProtocol, IDLComplexParam iDLComplexParam) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (iDLComplexParam.isSetField()) {
                bitSet.set(0);
            }
            if (iDLComplexParam.isSetTable()) {
                bitSet.set(1);
            }
            if (iDLComplexParam.isSetRecordId()) {
                bitSet.set(2);
            }
            tTupleProtocol.writeBitSet(bitSet, 3);
            if (iDLComplexParam.isSetField()) {
                iDLComplexParam.field.write((TProtocol)tTupleProtocol);
            }
            if (iDLComplexParam.isSetTable()) {
                tTupleProtocol.writeString(iDLComplexParam.table);
            }
            if (iDLComplexParam.isSetRecordId()) {
                tTupleProtocol.writeString(iDLComplexParam.recordId);
            }
        }

        public void read(TProtocol tProtocol, IDLComplexParam iDLComplexParam) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(3);
            if (bitSet.get(0)) {
                iDLComplexParam.field = new IDLFieldParam();
                iDLComplexParam.field.read((TProtocol)tTupleProtocol);
                iDLComplexParam.setFieldIsSet(true);
            }
            if (bitSet.get(1)) {
                iDLComplexParam.table = tTupleProtocol.readString();
                iDLComplexParam.setTableIsSet(true);
            }
            if (bitSet.get(2)) {
                iDLComplexParam.recordId = tTupleProtocol.readString();
                iDLComplexParam.setRecordIdIsSet(true);
            }
        }
    }

    private static class IDLComplexParamStandardScheme
    extends StandardScheme<IDLComplexParam> {
        private IDLComplexParamStandardScheme() {
        }

        public void read(TProtocol tProtocol, IDLComplexParam iDLComplexParam) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 12) {
                            iDLComplexParam.field = new IDLFieldParam();
                            iDLComplexParam.field.read(tProtocol);
                            iDLComplexParam.setFieldIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 11) {
                            iDLComplexParam.table = tProtocol.readString();
                            iDLComplexParam.setTableIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 11) {
                            iDLComplexParam.recordId = tProtocol.readString();
                            iDLComplexParam.setRecordIdIsSet(true);
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
            iDLComplexParam.validate();
        }

        public void write(TProtocol tProtocol, IDLComplexParam iDLComplexParam) throws TException {
            iDLComplexParam.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (iDLComplexParam.field != null) {
                tProtocol.writeFieldBegin(FIELD_FIELD_DESC);
                iDLComplexParam.field.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            if (iDLComplexParam.table != null) {
                tProtocol.writeFieldBegin(TABLE_FIELD_DESC);
                tProtocol.writeString(iDLComplexParam.table);
                tProtocol.writeFieldEnd();
            }
            if (iDLComplexParam.recordId != null) {
                tProtocol.writeFieldBegin(RECORD_ID_FIELD_DESC);
                tProtocol.writeString(iDLComplexParam.recordId);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

