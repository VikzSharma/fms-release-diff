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

import com.filemaker.jwpc.iwp.thrift.layout.PortalData;
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

public class PortalDataResult
implements TBase<PortalDataResult, _Fields>,
Serializable,
Cloneable,
Comparable<PortalDataResult> {
    private static final TStruct STRUCT_DESC = new TStruct("PortalDataResult");
    private static final TField PORTAL_DATA_FIELD_DESC = new TField("portalData", 12, 1);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new PortalDataResultStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new PortalDataResultTupleSchemeFactory();
    @Nullable
    private PortalData portalData;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public PortalDataResult() {
    }

    public PortalDataResult(PortalData portalData) {
        this();
        this.portalData = portalData;
    }

    public PortalDataResult(PortalDataResult portalDataResult) {
        if (portalDataResult.isSetPortalData()) {
            this.portalData = new PortalData(portalDataResult.portalData);
        }
    }

    public PortalDataResult deepCopy() {
        return new PortalDataResult(this);
    }

    public void clear() {
        this.portalData = null;
    }

    @Nullable
    public PortalData getPortalData() {
        return this.portalData;
    }

    public void setPortalData(@Nullable PortalData portalData) {
        this.portalData = portalData;
    }

    public void unsetPortalData() {
        this.portalData = null;
    }

    public boolean isSetPortalData() {
        return this.portalData != null;
    }

    public void setPortalDataIsSet(boolean bl) {
        if (!bl) {
            this.portalData = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetPortalData();
                    break;
                }
                this.setPortalData((PortalData)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getPortalData();
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
                return this.isSetPortalData();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof PortalDataResult) {
            return this.equals((PortalDataResult)object);
        }
        return false;
    }

    public boolean equals(PortalDataResult portalDataResult) {
        if (portalDataResult == null) {
            return false;
        }
        if (this == portalDataResult) {
            return true;
        }
        boolean bl = this.isSetPortalData();
        boolean bl2 = portalDataResult.isSetPortalData();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.portalData.equals(portalDataResult.portalData)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetPortalData() ? 131071 : 524287);
        if (this.isSetPortalData()) {
            n = n * 8191 + this.portalData.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(PortalDataResult portalDataResult) {
        if (!this.getClass().equals(portalDataResult.getClass())) {
            return this.getClass().getName().compareTo(portalDataResult.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetPortalData(), portalDataResult.isSetPortalData());
        if (n != 0) {
            return n;
        }
        if (this.isSetPortalData() && (n = TBaseHelper.compareTo((Comparable)this.portalData, (Comparable)portalDataResult.portalData)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        PortalDataResult.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        PortalDataResult.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("PortalDataResult(");
        boolean bl = true;
        stringBuilder.append("portalData:");
        if (this.portalData == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.portalData);
        }
        bl = false;
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void validate() throws TException {
        if (this.portalData != null) {
            this.portalData.validate();
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
        enumMap.put(_Fields.PORTAL_DATA, new FieldMetaData("portalData", 3, (FieldValueMetaData)new StructMetaData(12, PortalData.class)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(PortalDataResult.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        PORTAL_DATA(1, "portalData");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return PORTAL_DATA;
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

    private static class PortalDataResultStandardSchemeFactory
    implements SchemeFactory {
        private PortalDataResultStandardSchemeFactory() {
        }

        public PortalDataResultStandardScheme getScheme() {
            return new PortalDataResultStandardScheme();
        }
    }

    private static class PortalDataResultTupleSchemeFactory
    implements SchemeFactory {
        private PortalDataResultTupleSchemeFactory() {
        }

        public PortalDataResultTupleScheme getScheme() {
            return new PortalDataResultTupleScheme();
        }
    }

    private static class PortalDataResultTupleScheme
    extends TupleScheme<PortalDataResult> {
        private PortalDataResultTupleScheme() {
        }

        public void write(TProtocol tProtocol, PortalDataResult portalDataResult) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (portalDataResult.isSetPortalData()) {
                bitSet.set(0);
            }
            tTupleProtocol.writeBitSet(bitSet, 1);
            if (portalDataResult.isSetPortalData()) {
                portalDataResult.portalData.write((TProtocol)tTupleProtocol);
            }
        }

        public void read(TProtocol tProtocol, PortalDataResult portalDataResult) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(1);
            if (bitSet.get(0)) {
                portalDataResult.portalData = new PortalData();
                portalDataResult.portalData.read((TProtocol)tTupleProtocol);
                portalDataResult.setPortalDataIsSet(true);
            }
        }
    }

    private static class PortalDataResultStandardScheme
    extends StandardScheme<PortalDataResult> {
        private PortalDataResultStandardScheme() {
        }

        public void read(TProtocol tProtocol, PortalDataResult portalDataResult) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 12) {
                            portalDataResult.portalData = new PortalData();
                            portalDataResult.portalData.read(tProtocol);
                            portalDataResult.setPortalDataIsSet(true);
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
            portalDataResult.validate();
        }

        public void write(TProtocol tProtocol, PortalDataResult portalDataResult) throws TException {
            portalDataResult.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (portalDataResult.portalData != null) {
                tProtocol.writeFieldBegin(PORTAL_DATA_FIELD_DESC);
                portalDataResult.portalData.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

