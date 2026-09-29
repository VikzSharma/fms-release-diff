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

import com.filemaker.jwpc.iwp.thrift.layout.LayoutData;
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

public class LayoutDataResult
implements TBase<LayoutDataResult, _Fields>,
Serializable,
Cloneable,
Comparable<LayoutDataResult> {
    private static final TStruct STRUCT_DESC = new TStruct("LayoutDataResult");
    private static final TField LAYOUT_DATA_FIELD_DESC = new TField("layoutData", 12, 1);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new LayoutDataResultStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new LayoutDataResultTupleSchemeFactory();
    @Nullable
    private LayoutData layoutData;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public LayoutDataResult() {
    }

    public LayoutDataResult(LayoutData layoutData) {
        this();
        this.layoutData = layoutData;
    }

    public LayoutDataResult(LayoutDataResult layoutDataResult) {
        if (layoutDataResult.isSetLayoutData()) {
            this.layoutData = new LayoutData(layoutDataResult.layoutData);
        }
    }

    public LayoutDataResult deepCopy() {
        return new LayoutDataResult(this);
    }

    public void clear() {
        this.layoutData = null;
    }

    @Nullable
    public LayoutData getLayoutData() {
        return this.layoutData;
    }

    public void setLayoutData(@Nullable LayoutData layoutData) {
        this.layoutData = layoutData;
    }

    public void unsetLayoutData() {
        this.layoutData = null;
    }

    public boolean isSetLayoutData() {
        return this.layoutData != null;
    }

    public void setLayoutDataIsSet(boolean bl) {
        if (!bl) {
            this.layoutData = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetLayoutData();
                    break;
                }
                this.setLayoutData((LayoutData)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getLayoutData();
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
                return this.isSetLayoutData();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof LayoutDataResult) {
            return this.equals((LayoutDataResult)object);
        }
        return false;
    }

    public boolean equals(LayoutDataResult layoutDataResult) {
        if (layoutDataResult == null) {
            return false;
        }
        if (this == layoutDataResult) {
            return true;
        }
        boolean bl = this.isSetLayoutData();
        boolean bl2 = layoutDataResult.isSetLayoutData();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.layoutData.equals(layoutDataResult.layoutData)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetLayoutData() ? 131071 : 524287);
        if (this.isSetLayoutData()) {
            n = n * 8191 + this.layoutData.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(LayoutDataResult layoutDataResult) {
        if (!this.getClass().equals(layoutDataResult.getClass())) {
            return this.getClass().getName().compareTo(layoutDataResult.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetLayoutData(), layoutDataResult.isSetLayoutData());
        if (n != 0) {
            return n;
        }
        if (this.isSetLayoutData() && (n = TBaseHelper.compareTo((Comparable)this.layoutData, (Comparable)layoutDataResult.layoutData)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        LayoutDataResult.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        LayoutDataResult.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("LayoutDataResult(");
        boolean bl = true;
        stringBuilder.append("layoutData:");
        if (this.layoutData == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.layoutData);
        }
        bl = false;
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void validate() throws TException {
        if (this.layoutData != null) {
            this.layoutData.validate();
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
        enumMap.put(_Fields.LAYOUT_DATA, new FieldMetaData("layoutData", 3, (FieldValueMetaData)new StructMetaData(12, LayoutData.class)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(LayoutDataResult.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        LAYOUT_DATA(1, "layoutData");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return LAYOUT_DATA;
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

    private static class LayoutDataResultStandardSchemeFactory
    implements SchemeFactory {
        private LayoutDataResultStandardSchemeFactory() {
        }

        public LayoutDataResultStandardScheme getScheme() {
            return new LayoutDataResultStandardScheme();
        }
    }

    private static class LayoutDataResultTupleSchemeFactory
    implements SchemeFactory {
        private LayoutDataResultTupleSchemeFactory() {
        }

        public LayoutDataResultTupleScheme getScheme() {
            return new LayoutDataResultTupleScheme();
        }
    }

    private static class LayoutDataResultTupleScheme
    extends TupleScheme<LayoutDataResult> {
        private LayoutDataResultTupleScheme() {
        }

        public void write(TProtocol tProtocol, LayoutDataResult layoutDataResult) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (layoutDataResult.isSetLayoutData()) {
                bitSet.set(0);
            }
            tTupleProtocol.writeBitSet(bitSet, 1);
            if (layoutDataResult.isSetLayoutData()) {
                layoutDataResult.layoutData.write((TProtocol)tTupleProtocol);
            }
        }

        public void read(TProtocol tProtocol, LayoutDataResult layoutDataResult) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(1);
            if (bitSet.get(0)) {
                layoutDataResult.layoutData = new LayoutData();
                layoutDataResult.layoutData.read((TProtocol)tTupleProtocol);
                layoutDataResult.setLayoutDataIsSet(true);
            }
        }
    }

    private static class LayoutDataResultStandardScheme
    extends StandardScheme<LayoutDataResult> {
        private LayoutDataResultStandardScheme() {
        }

        public void read(TProtocol tProtocol, LayoutDataResult layoutDataResult) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 12) {
                            layoutDataResult.layoutData = new LayoutData();
                            layoutDataResult.layoutData.read(tProtocol);
                            layoutDataResult.setLayoutDataIsSet(true);
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
            layoutDataResult.validate();
        }

        public void write(TProtocol tProtocol, LayoutDataResult layoutDataResult) throws TException {
            layoutDataResult.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (layoutDataResult.layoutData != null) {
                tProtocol.writeFieldBegin(LAYOUT_DATA_FIELD_DESC);
                layoutDataResult.layoutData.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

