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

import com.filemaker.jwpc.fmwp.api.thrift.service.ReplyStatus;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.thrift.EncodingUtils;
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

public class IDLContainerData
implements TBase<IDLContainerData, _Fields>,
Serializable,
Cloneable,
Comparable<IDLContainerData> {
    private static final TStruct STRUCT_DESC = new TStruct("IDLContainerData");
    private static final TField STATUS_FIELD_DESC = new TField("status", 12, 1);
    private static final TField MOD_ID_FIELD_DESC = new TField("modId", 10, 2);
    private static final TField TYPE_FIELD_DESC = new TField("type", 15, 3);
    private static final TField TOTAL_FIELD_DESC = new TField("total", 10, 4);
    private static final TField REMAIN_FIELD_DESC = new TField("remain", 10, 5);
    private static final TField DATA_FIELD_DESC = new TField("data", 11, 6);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new IDLContainerDataStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new IDLContainerDataTupleSchemeFactory();
    @Nullable
    private ReplyStatus status;
    private long modId;
    @Nullable
    private List<Byte> type;
    private long total;
    private long remain;
    @Nullable
    private ByteBuffer data;
    private static final int __MODID_ISSET_ID = 0;
    private static final int __TOTAL_ISSET_ID = 1;
    private static final int __REMAIN_ISSET_ID = 2;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public IDLContainerData() {
    }

    public IDLContainerData(ReplyStatus replyStatus, long l, List<Byte> list, long l2, long l3, ByteBuffer byteBuffer) {
        this();
        this.status = replyStatus;
        this.modId = l;
        this.setModIdIsSet(true);
        this.type = list;
        this.total = l2;
        this.setTotalIsSet(true);
        this.remain = l3;
        this.setRemainIsSet(true);
        this.data = TBaseHelper.copyBinary((ByteBuffer)byteBuffer);
    }

    public IDLContainerData(IDLContainerData iDLContainerData) {
        this.__isset_bitfield = iDLContainerData.__isset_bitfield;
        if (iDLContainerData.isSetStatus()) {
            this.status = new ReplyStatus(iDLContainerData.status);
        }
        this.modId = iDLContainerData.modId;
        if (iDLContainerData.isSetType()) {
            ArrayList<Byte> arrayList = new ArrayList<Byte>(iDLContainerData.type);
            this.type = arrayList;
        }
        this.total = iDLContainerData.total;
        this.remain = iDLContainerData.remain;
        if (iDLContainerData.isSetData()) {
            this.data = TBaseHelper.copyBinary((ByteBuffer)iDLContainerData.data);
        }
    }

    public IDLContainerData deepCopy() {
        return new IDLContainerData(this);
    }

    public void clear() {
        this.status = null;
        this.setModIdIsSet(false);
        this.modId = 0L;
        this.type = null;
        this.setTotalIsSet(false);
        this.total = 0L;
        this.setRemainIsSet(false);
        this.remain = 0L;
        this.data = null;
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

    public long getModId() {
        return this.modId;
    }

    public void setModId(long l) {
        this.modId = l;
        this.setModIdIsSet(true);
    }

    public void unsetModId() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetModId() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setModIdIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public int getTypeSize() {
        return this.type == null ? 0 : this.type.size();
    }

    @Nullable
    public Iterator<Byte> getTypeIterator() {
        return this.type == null ? null : this.type.iterator();
    }

    public void addToType(byte by) {
        if (this.type == null) {
            this.type = new ArrayList<Byte>();
        }
        this.type.add(by);
    }

    @Nullable
    public List<Byte> getType() {
        return this.type;
    }

    public void setType(@Nullable List<Byte> list) {
        this.type = list;
    }

    public void unsetType() {
        this.type = null;
    }

    public boolean isSetType() {
        return this.type != null;
    }

    public void setTypeIsSet(boolean bl) {
        if (!bl) {
            this.type = null;
        }
    }

    public long getTotal() {
        return this.total;
    }

    public void setTotal(long l) {
        this.total = l;
        this.setTotalIsSet(true);
    }

    public void unsetTotal() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)1);
    }

    public boolean isSetTotal() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)1);
    }

    public void setTotalIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)1, (boolean)bl);
    }

    public long getRemain() {
        return this.remain;
    }

    public void setRemain(long l) {
        this.remain = l;
        this.setRemainIsSet(true);
    }

    public void unsetRemain() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)2);
    }

    public boolean isSetRemain() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)2);
    }

    public void setRemainIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)2, (boolean)bl);
    }

    public byte[] getData() {
        this.setData(TBaseHelper.rightSize((ByteBuffer)this.data));
        return this.data == null ? null : this.data.array();
    }

    public ByteBuffer bufferForData() {
        return TBaseHelper.copyBinary((ByteBuffer)this.data);
    }

    public void setData(byte[] byArray) {
        this.data = byArray == null ? (ByteBuffer)null : ByteBuffer.wrap((byte[])byArray.clone());
    }

    public void setData(@Nullable ByteBuffer byteBuffer) {
        this.data = TBaseHelper.copyBinary((ByteBuffer)byteBuffer);
    }

    public void unsetData() {
        this.data = null;
    }

    public boolean isSetData() {
        return this.data != null;
    }

    public void setDataIsSet(boolean bl) {
        if (!bl) {
            this.data = null;
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
                    this.unsetModId();
                    break;
                }
                this.setModId((Long)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetType();
                    break;
                }
                this.setType((List)object);
                break;
            }
            case 3: {
                if (object == null) {
                    this.unsetTotal();
                    break;
                }
                this.setTotal((Long)object);
                break;
            }
            case 4: {
                if (object == null) {
                    this.unsetRemain();
                    break;
                }
                this.setRemain((Long)object);
                break;
            }
            case 5: {
                if (object == null) {
                    this.unsetData();
                    break;
                }
                if (object instanceof byte[]) {
                    this.setData((byte[])object);
                    break;
                }
                this.setData((ByteBuffer)object);
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
                return this.getModId();
            }
            case 2: {
                return this.getType();
            }
            case 3: {
                return this.getTotal();
            }
            case 4: {
                return this.getRemain();
            }
            case 5: {
                return this.getData();
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
                return this.isSetModId();
            }
            case 2: {
                return this.isSetType();
            }
            case 3: {
                return this.isSetTotal();
            }
            case 4: {
                return this.isSetRemain();
            }
            case 5: {
                return this.isSetData();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof IDLContainerData) {
            return this.equals((IDLContainerData)object);
        }
        return false;
    }

    public boolean equals(IDLContainerData iDLContainerData) {
        if (iDLContainerData == null) {
            return false;
        }
        if (this == iDLContainerData) {
            return true;
        }
        boolean bl = this.isSetStatus();
        boolean bl2 = iDLContainerData.isSetStatus();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.status.equals(iDLContainerData.status)) {
                return false;
            }
        }
        boolean bl3 = true;
        boolean bl4 = true;
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (this.modId != iDLContainerData.modId) {
                return false;
            }
        }
        boolean bl5 = this.isSetType();
        boolean bl6 = iDLContainerData.isSetType();
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (!this.type.equals(iDLContainerData.type)) {
                return false;
            }
        }
        boolean bl7 = true;
        boolean bl8 = true;
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (this.total != iDLContainerData.total) {
                return false;
            }
        }
        boolean bl9 = true;
        boolean bl10 = true;
        if (bl9 || bl10) {
            if (!bl9 || !bl10) {
                return false;
            }
            if (this.remain != iDLContainerData.remain) {
                return false;
            }
        }
        boolean bl11 = this.isSetData();
        boolean bl12 = iDLContainerData.isSetData();
        if (bl11 || bl12) {
            if (!bl11 || !bl12) {
                return false;
            }
            if (!this.data.equals(iDLContainerData.data)) {
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
        n = n * 8191 + TBaseHelper.hashCode((long)this.modId);
        n = n * 8191 + (this.isSetType() ? 131071 : 524287);
        if (this.isSetType()) {
            n = n * 8191 + this.type.hashCode();
        }
        n = n * 8191 + TBaseHelper.hashCode((long)this.total);
        n = n * 8191 + TBaseHelper.hashCode((long)this.remain);
        n = n * 8191 + (this.isSetData() ? 131071 : 524287);
        if (this.isSetData()) {
            n = n * 8191 + this.data.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(IDLContainerData iDLContainerData) {
        if (!this.getClass().equals(iDLContainerData.getClass())) {
            return this.getClass().getName().compareTo(iDLContainerData.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetStatus(), iDLContainerData.isSetStatus());
        if (n != 0) {
            return n;
        }
        if (this.isSetStatus() && (n = TBaseHelper.compareTo((Comparable)this.status, (Comparable)iDLContainerData.status)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetModId(), iDLContainerData.isSetModId());
        if (n != 0) {
            return n;
        }
        if (this.isSetModId() && (n = TBaseHelper.compareTo((long)this.modId, (long)iDLContainerData.modId)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetType(), iDLContainerData.isSetType());
        if (n != 0) {
            return n;
        }
        if (this.isSetType() && (n = TBaseHelper.compareTo(this.type, iDLContainerData.type)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetTotal(), iDLContainerData.isSetTotal());
        if (n != 0) {
            return n;
        }
        if (this.isSetTotal() && (n = TBaseHelper.compareTo((long)this.total, (long)iDLContainerData.total)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetRemain(), iDLContainerData.isSetRemain());
        if (n != 0) {
            return n;
        }
        if (this.isSetRemain() && (n = TBaseHelper.compareTo((long)this.remain, (long)iDLContainerData.remain)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetData(), iDLContainerData.isSetData());
        if (n != 0) {
            return n;
        }
        if (this.isSetData() && (n = TBaseHelper.compareTo((Comparable)this.data, (Comparable)iDLContainerData.data)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        IDLContainerData.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        IDLContainerData.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("IDLContainerData(");
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
        stringBuilder.append("modId:");
        stringBuilder.append(this.modId);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("type:");
        if (this.type == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.type);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("total:");
        stringBuilder.append(this.total);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("remain:");
        stringBuilder.append(this.remain);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("data:");
        if (this.data == null) {
            stringBuilder.append("null");
        } else {
            TBaseHelper.toString((ByteBuffer)this.data, (StringBuilder)stringBuilder);
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
        enumMap.put(_Fields.STATUS, new FieldMetaData("status", 3, (FieldValueMetaData)new StructMetaData(12, ReplyStatus.class)));
        enumMap.put(_Fields.MOD_ID, new FieldMetaData("modId", 3, new FieldValueMetaData(10)));
        enumMap.put(_Fields.TYPE, new FieldMetaData("type", 3, (FieldValueMetaData)new ListMetaData(15, new FieldValueMetaData(3))));
        enumMap.put(_Fields.TOTAL, new FieldMetaData("total", 3, new FieldValueMetaData(10)));
        enumMap.put(_Fields.REMAIN, new FieldMetaData("remain", 3, new FieldValueMetaData(10)));
        enumMap.put(_Fields.DATA, new FieldMetaData("data", 3, new FieldValueMetaData(11, true)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(IDLContainerData.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        STATUS(1, "status"),
        MOD_ID(2, "modId"),
        TYPE(3, "type"),
        TOTAL(4, "total"),
        REMAIN(5, "remain"),
        DATA(6, "data");

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
                    return MOD_ID;
                }
                case 3: {
                    return TYPE;
                }
                case 4: {
                    return TOTAL;
                }
                case 5: {
                    return REMAIN;
                }
                case 6: {
                    return DATA;
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

    private static class IDLContainerDataStandardSchemeFactory
    implements SchemeFactory {
        private IDLContainerDataStandardSchemeFactory() {
        }

        public IDLContainerDataStandardScheme getScheme() {
            return new IDLContainerDataStandardScheme();
        }
    }

    private static class IDLContainerDataTupleSchemeFactory
    implements SchemeFactory {
        private IDLContainerDataTupleSchemeFactory() {
        }

        public IDLContainerDataTupleScheme getScheme() {
            return new IDLContainerDataTupleScheme();
        }
    }

    private static class IDLContainerDataTupleScheme
    extends TupleScheme<IDLContainerData> {
        private IDLContainerDataTupleScheme() {
        }

        public void write(TProtocol tProtocol, IDLContainerData iDLContainerData) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (iDLContainerData.isSetStatus()) {
                bitSet.set(0);
            }
            if (iDLContainerData.isSetModId()) {
                bitSet.set(1);
            }
            if (iDLContainerData.isSetType()) {
                bitSet.set(2);
            }
            if (iDLContainerData.isSetTotal()) {
                bitSet.set(3);
            }
            if (iDLContainerData.isSetRemain()) {
                bitSet.set(4);
            }
            if (iDLContainerData.isSetData()) {
                bitSet.set(5);
            }
            tTupleProtocol.writeBitSet(bitSet, 6);
            if (iDLContainerData.isSetStatus()) {
                iDLContainerData.status.write((TProtocol)tTupleProtocol);
            }
            if (iDLContainerData.isSetModId()) {
                tTupleProtocol.writeI64(iDLContainerData.modId);
            }
            if (iDLContainerData.isSetType()) {
                tTupleProtocol.writeI32(iDLContainerData.type.size());
                for (byte by : iDLContainerData.type) {
                    tTupleProtocol.writeByte(by);
                }
            }
            if (iDLContainerData.isSetTotal()) {
                tTupleProtocol.writeI64(iDLContainerData.total);
            }
            if (iDLContainerData.isSetRemain()) {
                tTupleProtocol.writeI64(iDLContainerData.remain);
            }
            if (iDLContainerData.isSetData()) {
                tTupleProtocol.writeBinary(iDLContainerData.data);
            }
        }

        public void read(TProtocol tProtocol, IDLContainerData iDLContainerData) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(6);
            if (bitSet.get(0)) {
                iDLContainerData.status = new ReplyStatus();
                iDLContainerData.status.read((TProtocol)tTupleProtocol);
                iDLContainerData.setStatusIsSet(true);
            }
            if (bitSet.get(1)) {
                iDLContainerData.modId = tTupleProtocol.readI64();
                iDLContainerData.setModIdIsSet(true);
            }
            if (bitSet.get(2)) {
                TList tList = tTupleProtocol.readListBegin((byte)3);
                iDLContainerData.type = new ArrayList<Byte>(tList.size);
                for (int i = 0; i < tList.size; ++i) {
                    byte by = tTupleProtocol.readByte();
                    iDLContainerData.type.add(by);
                }
                iDLContainerData.setTypeIsSet(true);
            }
            if (bitSet.get(3)) {
                iDLContainerData.total = tTupleProtocol.readI64();
                iDLContainerData.setTotalIsSet(true);
            }
            if (bitSet.get(4)) {
                iDLContainerData.remain = tTupleProtocol.readI64();
                iDLContainerData.setRemainIsSet(true);
            }
            if (bitSet.get(5)) {
                iDLContainerData.data = tTupleProtocol.readBinary();
                iDLContainerData.setDataIsSet(true);
            }
        }
    }

    private static class IDLContainerDataStandardScheme
    extends StandardScheme<IDLContainerData> {
        private IDLContainerDataStandardScheme() {
        }

        public void read(TProtocol tProtocol, IDLContainerData iDLContainerData) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 12) {
                            iDLContainerData.status = new ReplyStatus();
                            iDLContainerData.status.read(tProtocol);
                            iDLContainerData.setStatusIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 10) {
                            iDLContainerData.modId = tProtocol.readI64();
                            iDLContainerData.setModIdIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 15) {
                            TList tList = tProtocol.readListBegin();
                            iDLContainerData.type = new ArrayList<Byte>(tList.size);
                            for (int i = 0; i < tList.size; ++i) {
                                byte by = tProtocol.readByte();
                                iDLContainerData.type.add(by);
                            }
                            tProtocol.readListEnd();
                            iDLContainerData.setTypeIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 10) {
                            iDLContainerData.total = tProtocol.readI64();
                            iDLContainerData.setTotalIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 5: {
                        if (tField.type == 10) {
                            iDLContainerData.remain = tProtocol.readI64();
                            iDLContainerData.setRemainIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 6: {
                        if (tField.type == 11) {
                            iDLContainerData.data = tProtocol.readBinary();
                            iDLContainerData.setDataIsSet(true);
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
            iDLContainerData.validate();
        }

        public void write(TProtocol tProtocol, IDLContainerData iDLContainerData) throws TException {
            iDLContainerData.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (iDLContainerData.status != null) {
                tProtocol.writeFieldBegin(STATUS_FIELD_DESC);
                iDLContainerData.status.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(MOD_ID_FIELD_DESC);
            tProtocol.writeI64(iDLContainerData.modId);
            tProtocol.writeFieldEnd();
            if (iDLContainerData.type != null) {
                tProtocol.writeFieldBegin(TYPE_FIELD_DESC);
                tProtocol.writeListBegin(new TList(3, iDLContainerData.type.size()));
                for (byte by : iDLContainerData.type) {
                    tProtocol.writeByte(by);
                }
                tProtocol.writeListEnd();
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(TOTAL_FIELD_DESC);
            tProtocol.writeI64(iDLContainerData.total);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(REMAIN_FIELD_DESC);
            tProtocol.writeI64(iDLContainerData.remain);
            tProtocol.writeFieldEnd();
            if (iDLContainerData.data != null) {
                tProtocol.writeFieldBegin(DATA_FIELD_DESC);
                tProtocol.writeBinary(iDLContainerData.data);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

