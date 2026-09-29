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
 *  org.apache.thrift.meta_data.StructMetaData
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
package com.filemaker.jwpc.fmwp.api.thrift.service;

import com.filemaker.jwpc.fmwp.api.thrift.service.IDLItemInfo;
import com.filemaker.jwpc.fmwp.api.thrift.service.ReplyStatus;
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
import org.apache.thrift.meta_data.StructMetaData;
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

public class IDLNameSet
implements TBase<IDLNameSet, _Fields>,
Serializable,
Cloneable,
Comparable<IDLNameSet> {
    private static final TStruct STRUCT_DESC = new TStruct("IDLNameSet");
    private static final TField STATUS_FIELD_DESC = new TField("status", 12, 1);
    private static final TField NAMES_FIELD_DESC = new TField("names", 15, 2);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new IDLNameSetStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new IDLNameSetTupleSchemeFactory();
    @Nullable
    private ReplyStatus status;
    @Nullable
    private List<IDLItemInfo> names;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public IDLNameSet() {
    }

    public IDLNameSet(ReplyStatus replyStatus, List<IDLItemInfo> list) {
        this();
        this.status = replyStatus;
        this.names = list;
    }

    public IDLNameSet(IDLNameSet iDLNameSet) {
        if (iDLNameSet.isSetStatus()) {
            this.status = new ReplyStatus(iDLNameSet.status);
        }
        if (iDLNameSet.isSetNames()) {
            ArrayList<IDLItemInfo> arrayList = new ArrayList<IDLItemInfo>(iDLNameSet.names.size());
            for (IDLItemInfo iDLItemInfo : iDLNameSet.names) {
                arrayList.add(new IDLItemInfo(iDLItemInfo));
            }
            this.names = arrayList;
        }
    }

    public IDLNameSet deepCopy() {
        return new IDLNameSet(this);
    }

    public void clear() {
        this.status = null;
        this.names = null;
    }

    @Nullable
    public ReplyStatus getStatus() {
        return this.status;
    }

    public void setStatus(@Nullable ReplyStatus replyStatus) {
        this.status = replyStatus;
    }

    public void unsetStatus() {
        this.status = null;
    }

    public boolean isSetStatus() {
        return this.status != null;
    }

    public void setStatusIsSet(boolean bl) {
        if (!bl) {
            this.status = null;
        }
    }

    public int getNamesSize() {
        return this.names == null ? 0 : this.names.size();
    }

    @Nullable
    public Iterator<IDLItemInfo> getNamesIterator() {
        return this.names == null ? null : this.names.iterator();
    }

    public void addToNames(IDLItemInfo iDLItemInfo) {
        if (this.names == null) {
            this.names = new ArrayList<IDLItemInfo>();
        }
        this.names.add(iDLItemInfo);
    }

    @Nullable
    public List<IDLItemInfo> getNames() {
        return this.names;
    }

    public void setNames(@Nullable List<IDLItemInfo> list) {
        this.names = list;
    }

    public void unsetNames() {
        this.names = null;
    }

    public boolean isSetNames() {
        return this.names != null;
    }

    public void setNamesIsSet(boolean bl) {
        if (!bl) {
            this.names = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetStatus();
                    break;
                }
                this.setStatus((ReplyStatus)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetNames();
                    break;
                }
                this.setNames((List)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getStatus();
            }
            case 1: {
                return this.getNames();
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
                return this.isSetStatus();
            }
            case 1: {
                return this.isSetNames();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof IDLNameSet) {
            return this.equals((IDLNameSet)object);
        }
        return false;
    }

    public boolean equals(IDLNameSet iDLNameSet) {
        if (iDLNameSet == null) {
            return false;
        }
        if (this == iDLNameSet) {
            return true;
        }
        boolean bl = this.isSetStatus();
        boolean bl2 = iDLNameSet.isSetStatus();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.status.equals(iDLNameSet.status)) {
                return false;
            }
        }
        boolean bl3 = this.isSetNames();
        boolean bl4 = iDLNameSet.isSetNames();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.names.equals(iDLNameSet.names)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetStatus() ? 131071 : 524287);
        if (this.isSetStatus()) {
            n = n * 8191 + this.status.hashCode();
        }
        n = n * 8191 + (this.isSetNames() ? 131071 : 524287);
        if (this.isSetNames()) {
            n = n * 8191 + this.names.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(IDLNameSet iDLNameSet) {
        if (!this.getClass().equals(iDLNameSet.getClass())) {
            return this.getClass().getName().compareTo(iDLNameSet.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetStatus(), iDLNameSet.isSetStatus());
        if (n != 0) {
            return n;
        }
        if (this.isSetStatus() && (n = TBaseHelper.compareTo((Comparable)this.status, (Comparable)iDLNameSet.status)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetNames(), iDLNameSet.isSetNames());
        if (n != 0) {
            return n;
        }
        if (this.isSetNames() && (n = TBaseHelper.compareTo(this.names, iDLNameSet.names)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        IDLNameSet.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        IDLNameSet.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("IDLNameSet(");
        boolean bl = true;
        stringBuilder.append("status:");
        if (this.status == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.status);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("names:");
        if (this.names == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.names);
        }
        bl = false;
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void validate() throws TException {
        if (this.status != null) {
            this.status.validate();
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
        enumMap.put(_Fields.STATUS, new FieldMetaData("status", 3, (FieldValueMetaData)new StructMetaData(12, ReplyStatus.class)));
        enumMap.put(_Fields.NAMES, new FieldMetaData("names", 3, (FieldValueMetaData)new ListMetaData(15, (FieldValueMetaData)new StructMetaData(12, IDLItemInfo.class))));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(IDLNameSet.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        STATUS(1, "status"),
        NAMES(2, "names");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return STATUS;
                }
                case 2: {
                    return NAMES;
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

    private static class IDLNameSetStandardSchemeFactory
    implements SchemeFactory {
        private IDLNameSetStandardSchemeFactory() {
        }

        public IDLNameSetStandardScheme getScheme() {
            return new IDLNameSetStandardScheme();
        }
    }

    private static class IDLNameSetTupleSchemeFactory
    implements SchemeFactory {
        private IDLNameSetTupleSchemeFactory() {
        }

        public IDLNameSetTupleScheme getScheme() {
            return new IDLNameSetTupleScheme();
        }
    }

    private static class IDLNameSetTupleScheme
    extends TupleScheme<IDLNameSet> {
        private IDLNameSetTupleScheme() {
        }

        public void write(TProtocol tProtocol, IDLNameSet iDLNameSet) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (iDLNameSet.isSetStatus()) {
                bitSet.set(0);
            }
            if (iDLNameSet.isSetNames()) {
                bitSet.set(1);
            }
            tTupleProtocol.writeBitSet(bitSet, 2);
            if (iDLNameSet.isSetStatus()) {
                iDLNameSet.status.write((TProtocol)tTupleProtocol);
            }
            if (iDLNameSet.isSetNames()) {
                tTupleProtocol.writeI32(iDLNameSet.names.size());
                for (IDLItemInfo iDLItemInfo : iDLNameSet.names) {
                    iDLItemInfo.write((TProtocol)tTupleProtocol);
                }
            }
        }

        public void read(TProtocol tProtocol, IDLNameSet iDLNameSet) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(2);
            if (bitSet.get(0)) {
                iDLNameSet.status = new ReplyStatus();
                iDLNameSet.status.read((TProtocol)tTupleProtocol);
                iDLNameSet.setStatusIsSet(true);
            }
            if (bitSet.get(1)) {
                TList tList = tTupleProtocol.readListBegin((byte)12);
                iDLNameSet.names = new ArrayList<IDLItemInfo>(tList.size);
                for (int i = 0; i < tList.size; ++i) {
                    IDLItemInfo iDLItemInfo = new IDLItemInfo();
                    iDLItemInfo.read((TProtocol)tTupleProtocol);
                    iDLNameSet.names.add(iDLItemInfo);
                }
                iDLNameSet.setNamesIsSet(true);
            }
        }
    }

    private static class IDLNameSetStandardScheme
    extends StandardScheme<IDLNameSet> {
        private IDLNameSetStandardScheme() {
        }

        public void read(TProtocol tProtocol, IDLNameSet iDLNameSet) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 12) {
                            iDLNameSet.status = new ReplyStatus();
                            iDLNameSet.status.read(tProtocol);
                            iDLNameSet.setStatusIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 15) {
                            TList tList = tProtocol.readListBegin();
                            iDLNameSet.names = new ArrayList<IDLItemInfo>(tList.size);
                            for (int i = 0; i < tList.size; ++i) {
                                IDLItemInfo iDLItemInfo = new IDLItemInfo();
                                iDLItemInfo.read(tProtocol);
                                iDLNameSet.names.add(iDLItemInfo);
                            }
                            tProtocol.readListEnd();
                            iDLNameSet.setNamesIsSet(true);
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
            iDLNameSet.validate();
        }

        public void write(TProtocol tProtocol, IDLNameSet iDLNameSet) throws TException {
            iDLNameSet.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (iDLNameSet.status != null) {
                tProtocol.writeFieldBegin(STATUS_FIELD_DESC);
                iDLNameSet.status.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            if (iDLNameSet.names != null) {
                tProtocol.writeFieldBegin(NAMES_FIELD_DESC);
                tProtocol.writeListBegin(new TList(12, iDLNameSet.names.size()));
                for (IDLItemInfo iDLItemInfo : iDLNameSet.names) {
                    iDLItemInfo.write(tProtocol);
                }
                tProtocol.writeListEnd();
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

