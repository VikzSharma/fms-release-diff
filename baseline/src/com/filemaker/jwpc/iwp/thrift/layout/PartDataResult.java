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
package com.filemaker.jwpc.iwp.thrift.layout;

import com.filemaker.jwpc.iwp.thrift.layout.PartData;
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

public class PartDataResult
implements TBase<PartDataResult, _Fields>,
Serializable,
Cloneable,
Comparable<PartDataResult> {
    private static final TStruct STRUCT_DESC = new TStruct("PartDataResult");
    private static final TField PART_DATA_FIELD_DESC = new TField("partData", 12, 1);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new PartDataResultStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new PartDataResultTupleSchemeFactory();
    @Nullable
    private PartData partData;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public PartDataResult() {
    }

    public PartDataResult(PartData partData) {
        this();
        this.partData = partData;
    }

    public PartDataResult(PartDataResult partDataResult) {
        if (partDataResult.isSetPartData()) {
            this.partData = new PartData(partDataResult.partData);
        }
    }

    public PartDataResult deepCopy() {
        return new PartDataResult(this);
    }

    public void clear() {
        this.partData = null;
    }

    @Nullable
    public PartData getPartData() {
        return this.partData;
    }

    public void setPartData(@Nullable PartData partData) {
        this.partData = partData;
    }

    public void unsetPartData() {
        this.partData = null;
    }

    public boolean isSetPartData() {
        return this.partData != null;
    }

    public void setPartDataIsSet(boolean bl) {
        if (!bl) {
            this.partData = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetPartData();
                    break;
                }
                this.setPartData((PartData)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getPartData();
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
                return this.isSetPartData();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof PartDataResult) {
            return this.equals((PartDataResult)object);
        }
        return false;
    }

    public boolean equals(PartDataResult partDataResult) {
        if (partDataResult == null) {
            return false;
        }
        if (this == partDataResult) {
            return true;
        }
        boolean bl = this.isSetPartData();
        boolean bl2 = partDataResult.isSetPartData();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.partData.equals(partDataResult.partData)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetPartData() ? 131071 : 524287);
        if (this.isSetPartData()) {
            n = n * 8191 + this.partData.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(PartDataResult partDataResult) {
        if (!this.getClass().equals(partDataResult.getClass())) {
            return this.getClass().getName().compareTo(partDataResult.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetPartData(), partDataResult.isSetPartData());
        if (n != 0) {
            return n;
        }
        if (this.isSetPartData() && (n = TBaseHelper.compareTo((Comparable)this.partData, (Comparable)partDataResult.partData)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        PartDataResult.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        PartDataResult.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("PartDataResult(");
        boolean bl = true;
        stringBuilder.append("partData:");
        if (this.partData == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.partData);
        }
        bl = false;
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void validate() throws TException {
        if (this.partData != null) {
            this.partData.validate();
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
        enumMap.put(_Fields.PART_DATA, new FieldMetaData("partData", 3, (FieldValueMetaData)new StructMetaData(12, PartData.class)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(PartDataResult.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        PART_DATA(1, "partData");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return PART_DATA;
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

    private static class PartDataResultStandardSchemeFactory
    implements SchemeFactory {
        private PartDataResultStandardSchemeFactory() {
        }

        public PartDataResultStandardScheme getScheme() {
            return new PartDataResultStandardScheme();
        }
    }

    private static class PartDataResultTupleSchemeFactory
    implements SchemeFactory {
        private PartDataResultTupleSchemeFactory() {
        }

        public PartDataResultTupleScheme getScheme() {
            return new PartDataResultTupleScheme();
        }
    }

    private static class PartDataResultTupleScheme
    extends TupleScheme<PartDataResult> {
        private PartDataResultTupleScheme() {
        }

        public void write(TProtocol tProtocol, PartDataResult partDataResult) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (partDataResult.isSetPartData()) {
                bitSet.set(0);
            }
            tTupleProtocol.writeBitSet(bitSet, 1);
            if (partDataResult.isSetPartData()) {
                partDataResult.partData.write((TProtocol)tTupleProtocol);
            }
        }

        public void read(TProtocol tProtocol, PartDataResult partDataResult) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(1);
            if (bitSet.get(0)) {
                partDataResult.partData = new PartData();
                partDataResult.partData.read((TProtocol)tTupleProtocol);
                partDataResult.setPartDataIsSet(true);
            }
        }
    }

    private static class PartDataResultStandardScheme
    extends StandardScheme<PartDataResult> {
        private PartDataResultStandardScheme() {
        }

        public void read(TProtocol tProtocol, PartDataResult partDataResult) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 12) {
                            partDataResult.partData = new PartData();
                            partDataResult.partData.read(tProtocol);
                            partDataResult.setPartDataIsSet(true);
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
            partDataResult.validate();
        }

        public void write(TProtocol tProtocol, PartDataResult partDataResult) throws TException {
            partDataResult.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (partDataResult.partData != null) {
                tProtocol.writeFieldBegin(PART_DATA_FIELD_DESC);
                partDataResult.partData.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

