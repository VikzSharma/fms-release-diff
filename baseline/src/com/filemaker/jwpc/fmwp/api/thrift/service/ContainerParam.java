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

import com.filemaker.jwpc.fmwp.api.thrift.service.BasicParam;
import com.filemaker.jwpc.fmwp.api.thrift.service.IDLComplexParam;
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

public class ContainerParam
implements TBase<ContainerParam, _Fields>,
Serializable,
Cloneable,
Comparable<ContainerParam> {
    private static final TStruct STRUCT_DESC = new TStruct("ContainerParam");
    private static final TField PARAM_FIELD_DESC = new TField("param", 12, 1);
    private static final TField FIELD_FIELD_DESC = new TField("field", 12, 2);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new ContainerParamStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new ContainerParamTupleSchemeFactory();
    @Nullable
    private BasicParam param;
    @Nullable
    private IDLComplexParam field;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public ContainerParam() {
    }

    public ContainerParam(BasicParam basicParam, IDLComplexParam iDLComplexParam) {
        this();
        this.param = basicParam;
        this.field = iDLComplexParam;
    }

    public ContainerParam(ContainerParam containerParam) {
        if (containerParam.isSetParam()) {
            this.param = new BasicParam(containerParam.param);
        }
        if (containerParam.isSetField()) {
            this.field = new IDLComplexParam(containerParam.field);
        }
    }

    public ContainerParam deepCopy() {
        return new ContainerParam(this);
    }

    public void clear() {
        this.param = null;
        this.field = null;
    }

    @Nullable
    public BasicParam getParam() {
        return this.param;
    }

    public void setParam(@Nullable BasicParam basicParam) {
        this.param = basicParam;
    }

    public void unsetParam() {
        this.param = null;
    }

    public boolean isSetParam() {
        return this.param != null;
    }

    public void setParamIsSet(boolean bl) {
        if (!bl) {
            this.param = null;
        }
    }

    @Nullable
    public IDLComplexParam getField() {
        return this.field;
    }

    public void setField(@Nullable IDLComplexParam iDLComplexParam) {
        this.field = iDLComplexParam;
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

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetParam();
                    break;
                }
                this.setParam((BasicParam)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetField();
                    break;
                }
                this.setField((IDLComplexParam)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getParam();
            }
            case 1: {
                return this.getField();
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
                return this.isSetParam();
            }
            case 1: {
                return this.isSetField();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof ContainerParam) {
            return this.equals((ContainerParam)object);
        }
        return false;
    }

    public boolean equals(ContainerParam containerParam) {
        if (containerParam == null) {
            return false;
        }
        if (this == containerParam) {
            return true;
        }
        boolean bl = this.isSetParam();
        boolean bl2 = containerParam.isSetParam();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.param.equals(containerParam.param)) {
                return false;
            }
        }
        boolean bl3 = this.isSetField();
        boolean bl4 = containerParam.isSetField();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.field.equals(containerParam.field)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetParam() ? 131071 : 524287);
        if (this.isSetParam()) {
            n = n * 8191 + this.param.hashCode();
        }
        n = n * 8191 + (this.isSetField() ? 131071 : 524287);
        if (this.isSetField()) {
            n = n * 8191 + this.field.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(ContainerParam containerParam) {
        if (!this.getClass().equals(containerParam.getClass())) {
            return this.getClass().getName().compareTo(containerParam.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetParam(), containerParam.isSetParam());
        if (n != 0) {
            return n;
        }
        if (this.isSetParam() && (n = TBaseHelper.compareTo((Comparable)this.param, (Comparable)containerParam.param)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetField(), containerParam.isSetField());
        if (n != 0) {
            return n;
        }
        if (this.isSetField() && (n = TBaseHelper.compareTo((Comparable)this.field, (Comparable)containerParam.field)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        ContainerParam.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        ContainerParam.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ContainerParam(");
        boolean bl = true;
        stringBuilder.append("param:");
        if (this.param == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.param);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("field:");
        if (this.field == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.field);
        }
        bl = false;
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void validate() throws TException {
        if (this.param != null) {
            this.param.validate();
        }
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
        enumMap.put(_Fields.PARAM, new FieldMetaData("param", 3, (FieldValueMetaData)new StructMetaData(12, BasicParam.class)));
        enumMap.put(_Fields.FIELD, new FieldMetaData("field", 3, (FieldValueMetaData)new StructMetaData(12, IDLComplexParam.class)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(ContainerParam.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        PARAM(1, "param"),
        FIELD(2, "field");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return PARAM;
                }
                case 2: {
                    return FIELD;
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

    private static class ContainerParamStandardSchemeFactory
    implements SchemeFactory {
        private ContainerParamStandardSchemeFactory() {
        }

        public ContainerParamStandardScheme getScheme() {
            return new ContainerParamStandardScheme();
        }
    }

    private static class ContainerParamTupleSchemeFactory
    implements SchemeFactory {
        private ContainerParamTupleSchemeFactory() {
        }

        public ContainerParamTupleScheme getScheme() {
            return new ContainerParamTupleScheme();
        }
    }

    private static class ContainerParamTupleScheme
    extends TupleScheme<ContainerParam> {
        private ContainerParamTupleScheme() {
        }

        public void write(TProtocol tProtocol, ContainerParam containerParam) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (containerParam.isSetParam()) {
                bitSet.set(0);
            }
            if (containerParam.isSetField()) {
                bitSet.set(1);
            }
            tTupleProtocol.writeBitSet(bitSet, 2);
            if (containerParam.isSetParam()) {
                containerParam.param.write((TProtocol)tTupleProtocol);
            }
            if (containerParam.isSetField()) {
                containerParam.field.write((TProtocol)tTupleProtocol);
            }
        }

        public void read(TProtocol tProtocol, ContainerParam containerParam) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(2);
            if (bitSet.get(0)) {
                containerParam.param = new BasicParam();
                containerParam.param.read((TProtocol)tTupleProtocol);
                containerParam.setParamIsSet(true);
            }
            if (bitSet.get(1)) {
                containerParam.field = new IDLComplexParam();
                containerParam.field.read((TProtocol)tTupleProtocol);
                containerParam.setFieldIsSet(true);
            }
        }
    }

    private static class ContainerParamStandardScheme
    extends StandardScheme<ContainerParam> {
        private ContainerParamStandardScheme() {
        }

        public void read(TProtocol tProtocol, ContainerParam containerParam) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 12) {
                            containerParam.param = new BasicParam();
                            containerParam.param.read(tProtocol);
                            containerParam.setParamIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 12) {
                            containerParam.field = new IDLComplexParam();
                            containerParam.field.read(tProtocol);
                            containerParam.setFieldIsSet(true);
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
            containerParam.validate();
        }

        public void write(TProtocol tProtocol, ContainerParam containerParam) throws TException {
            containerParam.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (containerParam.param != null) {
                tProtocol.writeFieldBegin(PARAM_FIELD_DESC);
                containerParam.param.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            if (containerParam.field != null) {
                tProtocol.writeFieldBegin(FIELD_FIELD_DESC);
                containerParam.field.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

