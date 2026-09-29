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

public class IDLItemInfo
implements TBase<IDLItemInfo, _Fields>,
Serializable,
Cloneable,
Comparable<IDLItemInfo> {
    private static final TStruct STRUCT_DESC = new TStruct("IDLItemInfo");
    private static final TField ITEM_NAME_FIELD_DESC = new TField("itemName", 11, 1);
    private static final TField ITEM_ID_FIELD_DESC = new TField("itemId", 10, 2);
    private static final TField MOD_COUNT_FIELD_DESC = new TField("modCount", 10, 3);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new IDLItemInfoStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new IDLItemInfoTupleSchemeFactory();
    @Nullable
    private String itemName;
    private long itemId;
    private long modCount;
    private static final int __ITEMID_ISSET_ID = 0;
    private static final int __MODCOUNT_ISSET_ID = 1;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public IDLItemInfo() {
    }

    public IDLItemInfo(String string, long l, long l2) {
        this();
        this.itemName = string;
        this.itemId = l;
        this.setItemIdIsSet(true);
        this.modCount = l2;
        this.setModCountIsSet(true);
    }

    public IDLItemInfo(IDLItemInfo iDLItemInfo) {
        this.__isset_bitfield = iDLItemInfo.__isset_bitfield;
        if (iDLItemInfo.isSetItemName()) {
            this.itemName = iDLItemInfo.itemName;
        }
        this.itemId = iDLItemInfo.itemId;
        this.modCount = iDLItemInfo.modCount;
    }

    public IDLItemInfo deepCopy() {
        return new IDLItemInfo(this);
    }

    public void clear() {
        this.itemName = null;
        this.setItemIdIsSet(false);
        this.itemId = 0L;
        this.setModCountIsSet(false);
        this.modCount = 0L;
    }

    @Nullable
    public String getItemName() {
        return this.itemName;
    }

    public void setItemName(@Nullable String string) {
        this.itemName = string;
    }

    public void unsetItemName() {
        this.itemName = null;
    }

    public boolean isSetItemName() {
        return this.itemName != null;
    }

    public void setItemNameIsSet(boolean bl) {
        if (!bl) {
            this.itemName = null;
        }
    }

    public long getItemId() {
        return this.itemId;
    }

    public void setItemId(long l) {
        this.itemId = l;
        this.setItemIdIsSet(true);
    }

    public void unsetItemId() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetItemId() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setItemIdIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public long getModCount() {
        return this.modCount;
    }

    public void setModCount(long l) {
        this.modCount = l;
        this.setModCountIsSet(true);
    }

    public void unsetModCount() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)1);
    }

    public boolean isSetModCount() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)1);
    }

    public void setModCountIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)1, (boolean)bl);
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetItemName();
                    break;
                }
                this.setItemName((String)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetItemId();
                    break;
                }
                this.setItemId((Long)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetModCount();
                    break;
                }
                this.setModCount((Long)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getItemName();
            }
            case 1: {
                return this.getItemId();
            }
            case 2: {
                return this.getModCount();
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
                return this.isSetItemName();
            }
            case 1: {
                return this.isSetItemId();
            }
            case 2: {
                return this.isSetModCount();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof IDLItemInfo) {
            return this.equals((IDLItemInfo)object);
        }
        return false;
    }

    public boolean equals(IDLItemInfo iDLItemInfo) {
        if (iDLItemInfo == null) {
            return false;
        }
        if (this == iDLItemInfo) {
            return true;
        }
        boolean bl = this.isSetItemName();
        boolean bl2 = iDLItemInfo.isSetItemName();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.itemName.equals(iDLItemInfo.itemName)) {
                return false;
            }
        }
        boolean bl3 = true;
        boolean bl4 = true;
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (this.itemId != iDLItemInfo.itemId) {
                return false;
            }
        }
        boolean bl5 = true;
        boolean bl6 = true;
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (this.modCount != iDLItemInfo.modCount) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetItemName() ? 131071 : 524287);
        if (this.isSetItemName()) {
            n = n * 8191 + this.itemName.hashCode();
        }
        n = n * 8191 + TBaseHelper.hashCode((long)this.itemId);
        n = n * 8191 + TBaseHelper.hashCode((long)this.modCount);
        return n;
    }

    @Override
    public int compareTo(IDLItemInfo iDLItemInfo) {
        if (!this.getClass().equals(iDLItemInfo.getClass())) {
            return this.getClass().getName().compareTo(iDLItemInfo.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetItemName(), iDLItemInfo.isSetItemName());
        if (n != 0) {
            return n;
        }
        if (this.isSetItemName() && (n = TBaseHelper.compareTo((String)this.itemName, (String)iDLItemInfo.itemName)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetItemId(), iDLItemInfo.isSetItemId());
        if (n != 0) {
            return n;
        }
        if (this.isSetItemId() && (n = TBaseHelper.compareTo((long)this.itemId, (long)iDLItemInfo.itemId)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetModCount(), iDLItemInfo.isSetModCount());
        if (n != 0) {
            return n;
        }
        if (this.isSetModCount() && (n = TBaseHelper.compareTo((long)this.modCount, (long)iDLItemInfo.modCount)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        IDLItemInfo.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        IDLItemInfo.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("IDLItemInfo(");
        boolean bl = true;
        stringBuilder.append("itemName:");
        if (this.itemName == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.itemName);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("itemId:");
        stringBuilder.append(this.itemId);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("modCount:");
        stringBuilder.append(this.modCount);
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
        enumMap.put(_Fields.ITEM_NAME, new FieldMetaData("itemName", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.ITEM_ID, new FieldMetaData("itemId", 3, new FieldValueMetaData(10)));
        enumMap.put(_Fields.MOD_COUNT, new FieldMetaData("modCount", 3, new FieldValueMetaData(10)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(IDLItemInfo.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        ITEM_NAME(1, "itemName"),
        ITEM_ID(2, "itemId"),
        MOD_COUNT(3, "modCount");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return ITEM_NAME;
                }
                case 2: {
                    return ITEM_ID;
                }
                case 3: {
                    return MOD_COUNT;
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

    private static class IDLItemInfoStandardSchemeFactory
    implements SchemeFactory {
        private IDLItemInfoStandardSchemeFactory() {
        }

        public IDLItemInfoStandardScheme getScheme() {
            return new IDLItemInfoStandardScheme();
        }
    }

    private static class IDLItemInfoTupleSchemeFactory
    implements SchemeFactory {
        private IDLItemInfoTupleSchemeFactory() {
        }

        public IDLItemInfoTupleScheme getScheme() {
            return new IDLItemInfoTupleScheme();
        }
    }

    private static class IDLItemInfoTupleScheme
    extends TupleScheme<IDLItemInfo> {
        private IDLItemInfoTupleScheme() {
        }

        public void write(TProtocol tProtocol, IDLItemInfo iDLItemInfo) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (iDLItemInfo.isSetItemName()) {
                bitSet.set(0);
            }
            if (iDLItemInfo.isSetItemId()) {
                bitSet.set(1);
            }
            if (iDLItemInfo.isSetModCount()) {
                bitSet.set(2);
            }
            tTupleProtocol.writeBitSet(bitSet, 3);
            if (iDLItemInfo.isSetItemName()) {
                tTupleProtocol.writeString(iDLItemInfo.itemName);
            }
            if (iDLItemInfo.isSetItemId()) {
                tTupleProtocol.writeI64(iDLItemInfo.itemId);
            }
            if (iDLItemInfo.isSetModCount()) {
                tTupleProtocol.writeI64(iDLItemInfo.modCount);
            }
        }

        public void read(TProtocol tProtocol, IDLItemInfo iDLItemInfo) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(3);
            if (bitSet.get(0)) {
                iDLItemInfo.itemName = tTupleProtocol.readString();
                iDLItemInfo.setItemNameIsSet(true);
            }
            if (bitSet.get(1)) {
                iDLItemInfo.itemId = tTupleProtocol.readI64();
                iDLItemInfo.setItemIdIsSet(true);
            }
            if (bitSet.get(2)) {
                iDLItemInfo.modCount = tTupleProtocol.readI64();
                iDLItemInfo.setModCountIsSet(true);
            }
        }
    }

    private static class IDLItemInfoStandardScheme
    extends StandardScheme<IDLItemInfo> {
        private IDLItemInfoStandardScheme() {
        }

        public void read(TProtocol tProtocol, IDLItemInfo iDLItemInfo) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 11) {
                            iDLItemInfo.itemName = tProtocol.readString();
                            iDLItemInfo.setItemNameIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 10) {
                            iDLItemInfo.itemId = tProtocol.readI64();
                            iDLItemInfo.setItemIdIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 10) {
                            iDLItemInfo.modCount = tProtocol.readI64();
                            iDLItemInfo.setModCountIsSet(true);
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
            iDLItemInfo.validate();
        }

        public void write(TProtocol tProtocol, IDLItemInfo iDLItemInfo) throws TException {
            iDLItemInfo.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (iDLItemInfo.itemName != null) {
                tProtocol.writeFieldBegin(ITEM_NAME_FIELD_DESC);
                tProtocol.writeString(iDLItemInfo.itemName);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(ITEM_ID_FIELD_DESC);
            tProtocol.writeI64(iDLItemInfo.itemId);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(MOD_COUNT_FIELD_DESC);
            tProtocol.writeI64(iDLItemInfo.modCount);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

