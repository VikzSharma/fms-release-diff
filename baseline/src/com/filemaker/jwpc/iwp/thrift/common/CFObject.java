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
 *  org.apache.thrift.meta_data.ListMetaData
 *  org.apache.thrift.protocol.TCompactProtocol
 *  org.apache.thrift.protocol.TField
 *  org.apache.thrift.protocol.TList
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

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.thrift.TBase;
import org.apache.thrift.TBaseHelper;
import org.apache.thrift.TException;
import org.apache.thrift.TFieldIdEnum;
import org.apache.thrift.annotation.Nullable;
import org.apache.thrift.meta_data.FieldMetaData;
import org.apache.thrift.meta_data.FieldValueMetaData;
import org.apache.thrift.meta_data.ListMetaData;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TList;
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

public class CFObject
implements TBase<CFObject, _Fields>,
Serializable,
Cloneable,
Comparable<CFObject> {
    private static final TStruct STRUCT_DESC = new TStruct("CFObject");
    private static final TField CF_ID_FIELD_DESC = new TField("cfId", 11, 1);
    private static final TField CF_INDICES_FIELD_DESC = new TField("cfIndices", 15, 2);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new CFObjectStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new CFObjectTupleSchemeFactory();
    @Nullable
    private String cfId;
    @Nullable
    private List<Integer> cfIndices;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public CFObject() {
    }

    public CFObject(String string, List<Integer> list) {
        this();
        this.cfId = string;
        this.cfIndices = list;
    }

    public CFObject(CFObject cFObject) {
        if (cFObject.isSetCfId()) {
            this.cfId = cFObject.cfId;
        }
        if (cFObject.isSetCfIndices()) {
            ArrayList<Integer> arrayList = new ArrayList<Integer>(cFObject.cfIndices);
            this.cfIndices = arrayList;
        }
    }

    public CFObject deepCopy() {
        return new CFObject(this);
    }

    public void clear() {
        this.cfId = null;
        this.cfIndices = null;
    }

    @Nullable
    public String getCfId() {
        return this.cfId;
    }

    public void setCfId(@Nullable String string) {
        this.cfId = string;
    }

    public void unsetCfId() {
        this.cfId = null;
    }

    public boolean isSetCfId() {
        return this.cfId != null;
    }

    public void setCfIdIsSet(boolean bl) {
        if (!bl) {
            this.cfId = null;
        }
    }

    public int getCfIndicesSize() {
        return this.cfIndices == null ? 0 : this.cfIndices.size();
    }

    @Nullable
    public Iterator<Integer> getCfIndicesIterator() {
        return this.cfIndices == null ? null : this.cfIndices.iterator();
    }

    public void addToCfIndices(int n) {
        if (this.cfIndices == null) {
            this.cfIndices = new ArrayList<Integer>();
        }
        this.cfIndices.add(n);
    }

    @Nullable
    public List<Integer> getCfIndices() {
        return this.cfIndices;
    }

    public void setCfIndices(@Nullable List<Integer> list) {
        this.cfIndices = list;
    }

    public void unsetCfIndices() {
        this.cfIndices = null;
    }

    public boolean isSetCfIndices() {
        return this.cfIndices != null;
    }

    public void setCfIndicesIsSet(boolean bl) {
        if (!bl) {
            this.cfIndices = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetCfId();
                    break;
                }
                this.setCfId((String)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetCfIndices();
                    break;
                }
                this.setCfIndices((List)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getCfId();
            }
            case 1: {
                return this.getCfIndices();
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
                return this.isSetCfId();
            }
            case 1: {
                return this.isSetCfIndices();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof CFObject) {
            return this.equals((CFObject)object);
        }
        return false;
    }

    public boolean equals(CFObject cFObject) {
        if (cFObject == null) {
            return false;
        }
        if (this == cFObject) {
            return true;
        }
        boolean bl = this.isSetCfId();
        boolean bl2 = cFObject.isSetCfId();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.cfId.equals(cFObject.cfId)) {
                return false;
            }
        }
        boolean bl3 = this.isSetCfIndices();
        boolean bl4 = cFObject.isSetCfIndices();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.cfIndices.equals(cFObject.cfIndices)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetCfId() ? 131071 : 524287);
        if (this.isSetCfId()) {
            n = n * 8191 + this.cfId.hashCode();
        }
        n = n * 8191 + (this.isSetCfIndices() ? 131071 : 524287);
        if (this.isSetCfIndices()) {
            n = n * 8191 + this.cfIndices.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(CFObject cFObject) {
        if (!this.getClass().equals(cFObject.getClass())) {
            return this.getClass().getName().compareTo(cFObject.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetCfId(), cFObject.isSetCfId());
        if (n != 0) {
            return n;
        }
        if (this.isSetCfId() && (n = TBaseHelper.compareTo((String)this.cfId, (String)cFObject.cfId)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetCfIndices(), cFObject.isSetCfIndices());
        if (n != 0) {
            return n;
        }
        if (this.isSetCfIndices() && (n = TBaseHelper.compareTo(this.cfIndices, cFObject.cfIndices)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        CFObject.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        CFObject.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("CFObject(");
        boolean bl = true;
        stringBuilder.append("cfId:");
        if (this.cfId == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.cfId);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("cfIndices:");
        if (this.cfIndices == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.cfIndices);
        }
        bl = false;
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void validate() throws TException {
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
        enumMap.put(_Fields.CF_ID, new FieldMetaData("cfId", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.CF_INDICES, new FieldMetaData("cfIndices", 3, (FieldValueMetaData)new ListMetaData(15, new FieldValueMetaData(8))));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(CFObject.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        CF_ID(1, "cfId"),
        CF_INDICES(2, "cfIndices");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return CF_ID;
                }
                case 2: {
                    return CF_INDICES;
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

    private static class CFObjectStandardSchemeFactory
    implements SchemeFactory {
        private CFObjectStandardSchemeFactory() {
        }

        public CFObjectStandardScheme getScheme() {
            return new CFObjectStandardScheme();
        }
    }

    private static class CFObjectTupleSchemeFactory
    implements SchemeFactory {
        private CFObjectTupleSchemeFactory() {
        }

        public CFObjectTupleScheme getScheme() {
            return new CFObjectTupleScheme();
        }
    }

    private static class CFObjectTupleScheme
    extends TupleScheme<CFObject> {
        private CFObjectTupleScheme() {
        }

        public void write(TProtocol tProtocol, CFObject cFObject) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (cFObject.isSetCfId()) {
                bitSet.set(0);
            }
            if (cFObject.isSetCfIndices()) {
                bitSet.set(1);
            }
            tTupleProtocol.writeBitSet(bitSet, 2);
            if (cFObject.isSetCfId()) {
                tTupleProtocol.writeString(cFObject.cfId);
            }
            if (cFObject.isSetCfIndices()) {
                tTupleProtocol.writeI32(cFObject.cfIndices.size());
                for (int n : cFObject.cfIndices) {
                    tTupleProtocol.writeI32(n);
                }
            }
        }

        public void read(TProtocol tProtocol, CFObject cFObject) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(2);
            if (bitSet.get(0)) {
                cFObject.cfId = tTupleProtocol.readString();
                cFObject.setCfIdIsSet(true);
            }
            if (bitSet.get(1)) {
                TList tList = tTupleProtocol.readListBegin((byte)8);
                cFObject.cfIndices = new ArrayList<Integer>(tList.size);
                for (int i = 0; i < tList.size; ++i) {
                    int n = tTupleProtocol.readI32();
                    cFObject.cfIndices.add(n);
                }
                cFObject.setCfIndicesIsSet(true);
            }
        }
    }

    private static class CFObjectStandardScheme
    extends StandardScheme<CFObject> {
        private CFObjectStandardScheme() {
        }

        public void read(TProtocol tProtocol, CFObject cFObject) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 11) {
                            cFObject.cfId = tProtocol.readString();
                            cFObject.setCfIdIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 15) {
                            TList tList = tProtocol.readListBegin();
                            cFObject.cfIndices = new ArrayList<Integer>(tList.size);
                            for (int i = 0; i < tList.size; ++i) {
                                int n = tProtocol.readI32();
                                cFObject.cfIndices.add(n);
                            }
                            tProtocol.readListEnd();
                            cFObject.setCfIndicesIsSet(true);
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
            cFObject.validate();
        }

        public void write(TProtocol tProtocol, CFObject cFObject) throws TException {
            cFObject.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (cFObject.cfId != null) {
                tProtocol.writeFieldBegin(CF_ID_FIELD_DESC);
                tProtocol.writeString(cFObject.cfId);
                tProtocol.writeFieldEnd();
            }
            if (cFObject.cfIndices != null) {
                tProtocol.writeFieldBegin(CF_INDICES_FIELD_DESC);
                tProtocol.writeListBegin(new TList(8, cFObject.cfIndices.size()));
                for (int n : cFObject.cfIndices) {
                    tProtocol.writeI32(n);
                }
                tProtocol.writeListEnd();
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

