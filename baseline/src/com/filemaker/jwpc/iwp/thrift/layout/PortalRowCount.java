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
package com.filemaker.jwpc.iwp.thrift.layout;

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

public class PortalRowCount
implements TBase<PortalRowCount, _Fields>,
Serializable,
Cloneable,
Comparable<PortalRowCount> {
    private static final TStruct STRUCT_DESC = new TStruct("PortalRowCount");
    private static final TField OBJECT_ID_FIELD_DESC = new TField("objectId", 8, 1);
    private static final TField ROW_COUNT_FIELD_DESC = new TField("rowCount", 8, 2);
    private static final TField HIDE_CONDITION_ON_FIELD_DESC = new TField("hideConditionOn", 2, 3);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new PortalRowCountStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new PortalRowCountTupleSchemeFactory();
    private int objectId;
    private int rowCount;
    private boolean hideConditionOn;
    private static final int __OBJECTID_ISSET_ID = 0;
    private static final int __ROWCOUNT_ISSET_ID = 1;
    private static final int __HIDECONDITIONON_ISSET_ID = 2;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public PortalRowCount() {
        this.objectId = 0;
        this.rowCount = 0;
    }

    public PortalRowCount(int n, int n2, boolean bl) {
        this();
        this.objectId = n;
        this.setObjectIdIsSet(true);
        this.rowCount = n2;
        this.setRowCountIsSet(true);
        this.hideConditionOn = bl;
        this.setHideConditionOnIsSet(true);
    }

    public PortalRowCount(PortalRowCount portalRowCount) {
        this.__isset_bitfield = portalRowCount.__isset_bitfield;
        this.objectId = portalRowCount.objectId;
        this.rowCount = portalRowCount.rowCount;
        this.hideConditionOn = portalRowCount.hideConditionOn;
    }

    public PortalRowCount deepCopy() {
        return new PortalRowCount(this);
    }

    public void clear() {
        this.objectId = 0;
        this.rowCount = 0;
        this.setHideConditionOnIsSet(false);
        this.hideConditionOn = false;
    }

    public int getObjectId() {
        return this.objectId;
    }

    public void setObjectId(int n) {
        this.objectId = n;
        this.setObjectIdIsSet(true);
    }

    public void unsetObjectId() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetObjectId() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setObjectIdIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public int getRowCount() {
        return this.rowCount;
    }

    public void setRowCount(int n) {
        this.rowCount = n;
        this.setRowCountIsSet(true);
    }

    public void unsetRowCount() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)1);
    }

    public boolean isSetRowCount() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)1);
    }

    public void setRowCountIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)1, (boolean)bl);
    }

    public boolean isHideConditionOn() {
        return this.hideConditionOn;
    }

    public void setHideConditionOn(boolean bl) {
        this.hideConditionOn = bl;
        this.setHideConditionOnIsSet(true);
    }

    public void unsetHideConditionOn() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)2);
    }

    public boolean isSetHideConditionOn() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)2);
    }

    public void setHideConditionOnIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)2, (boolean)bl);
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetObjectId();
                    break;
                }
                this.setObjectId((Integer)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetRowCount();
                    break;
                }
                this.setRowCount((Integer)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetHideConditionOn();
                    break;
                }
                this.setHideConditionOn((Boolean)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getObjectId();
            }
            case 1: {
                return this.getRowCount();
            }
            case 2: {
                return this.isHideConditionOn();
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
                return this.isSetObjectId();
            }
            case 1: {
                return this.isSetRowCount();
            }
            case 2: {
                return this.isSetHideConditionOn();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof PortalRowCount) {
            return this.equals((PortalRowCount)object);
        }
        return false;
    }

    public boolean equals(PortalRowCount portalRowCount) {
        if (portalRowCount == null) {
            return false;
        }
        if (this == portalRowCount) {
            return true;
        }
        boolean bl = true;
        boolean bl2 = true;
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (this.objectId != portalRowCount.objectId) {
                return false;
            }
        }
        boolean bl3 = true;
        boolean bl4 = true;
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (this.rowCount != portalRowCount.rowCount) {
                return false;
            }
        }
        boolean bl5 = true;
        boolean bl6 = true;
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (this.hideConditionOn != portalRowCount.hideConditionOn) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + this.objectId;
        n = n * 8191 + this.rowCount;
        n = n * 8191 + (this.hideConditionOn ? 131071 : 524287);
        return n;
    }

    @Override
    public int compareTo(PortalRowCount portalRowCount) {
        if (!this.getClass().equals(portalRowCount.getClass())) {
            return this.getClass().getName().compareTo(portalRowCount.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetObjectId(), portalRowCount.isSetObjectId());
        if (n != 0) {
            return n;
        }
        if (this.isSetObjectId() && (n = TBaseHelper.compareTo((int)this.objectId, (int)portalRowCount.objectId)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetRowCount(), portalRowCount.isSetRowCount());
        if (n != 0) {
            return n;
        }
        if (this.isSetRowCount() && (n = TBaseHelper.compareTo((int)this.rowCount, (int)portalRowCount.rowCount)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetHideConditionOn(), portalRowCount.isSetHideConditionOn());
        if (n != 0) {
            return n;
        }
        if (this.isSetHideConditionOn() && (n = TBaseHelper.compareTo((boolean)this.hideConditionOn, (boolean)portalRowCount.hideConditionOn)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        PortalRowCount.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        PortalRowCount.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("PortalRowCount(");
        boolean bl = true;
        stringBuilder.append("objectId:");
        stringBuilder.append(this.objectId);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("rowCount:");
        stringBuilder.append(this.rowCount);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("hideConditionOn:");
        stringBuilder.append(this.hideConditionOn);
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
        enumMap.put(_Fields.OBJECT_ID, new FieldMetaData("objectId", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.ROW_COUNT, new FieldMetaData("rowCount", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.HIDE_CONDITION_ON, new FieldMetaData("hideConditionOn", 3, new FieldValueMetaData(2)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(PortalRowCount.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        OBJECT_ID(1, "objectId"),
        ROW_COUNT(2, "rowCount"),
        HIDE_CONDITION_ON(3, "hideConditionOn");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return OBJECT_ID;
                }
                case 2: {
                    return ROW_COUNT;
                }
                case 3: {
                    return HIDE_CONDITION_ON;
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

    private static class PortalRowCountStandardSchemeFactory
    implements SchemeFactory {
        private PortalRowCountStandardSchemeFactory() {
        }

        public PortalRowCountStandardScheme getScheme() {
            return new PortalRowCountStandardScheme();
        }
    }

    private static class PortalRowCountTupleSchemeFactory
    implements SchemeFactory {
        private PortalRowCountTupleSchemeFactory() {
        }

        public PortalRowCountTupleScheme getScheme() {
            return new PortalRowCountTupleScheme();
        }
    }

    private static class PortalRowCountTupleScheme
    extends TupleScheme<PortalRowCount> {
        private PortalRowCountTupleScheme() {
        }

        public void write(TProtocol tProtocol, PortalRowCount portalRowCount) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (portalRowCount.isSetObjectId()) {
                bitSet.set(0);
            }
            if (portalRowCount.isSetRowCount()) {
                bitSet.set(1);
            }
            if (portalRowCount.isSetHideConditionOn()) {
                bitSet.set(2);
            }
            tTupleProtocol.writeBitSet(bitSet, 3);
            if (portalRowCount.isSetObjectId()) {
                tTupleProtocol.writeI32(portalRowCount.objectId);
            }
            if (portalRowCount.isSetRowCount()) {
                tTupleProtocol.writeI32(portalRowCount.rowCount);
            }
            if (portalRowCount.isSetHideConditionOn()) {
                tTupleProtocol.writeBool(portalRowCount.hideConditionOn);
            }
        }

        public void read(TProtocol tProtocol, PortalRowCount portalRowCount) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(3);
            if (bitSet.get(0)) {
                portalRowCount.objectId = tTupleProtocol.readI32();
                portalRowCount.setObjectIdIsSet(true);
            }
            if (bitSet.get(1)) {
                portalRowCount.rowCount = tTupleProtocol.readI32();
                portalRowCount.setRowCountIsSet(true);
            }
            if (bitSet.get(2)) {
                portalRowCount.hideConditionOn = tTupleProtocol.readBool();
                portalRowCount.setHideConditionOnIsSet(true);
            }
        }
    }

    private static class PortalRowCountStandardScheme
    extends StandardScheme<PortalRowCount> {
        private PortalRowCountStandardScheme() {
        }

        public void read(TProtocol tProtocol, PortalRowCount portalRowCount) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 8) {
                            portalRowCount.objectId = tProtocol.readI32();
                            portalRowCount.setObjectIdIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 8) {
                            portalRowCount.rowCount = tProtocol.readI32();
                            portalRowCount.setRowCountIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 2) {
                            portalRowCount.hideConditionOn = tProtocol.readBool();
                            portalRowCount.setHideConditionOnIsSet(true);
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
            portalRowCount.validate();
        }

        public void write(TProtocol tProtocol, PortalRowCount portalRowCount) throws TException {
            portalRowCount.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            tProtocol.writeFieldBegin(OBJECT_ID_FIELD_DESC);
            tProtocol.writeI32(portalRowCount.objectId);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(ROW_COUNT_FIELD_DESC);
            tProtocol.writeI32(portalRowCount.rowCount);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(HIDE_CONDITION_ON_FIELD_DESC);
            tProtocol.writeBool(portalRowCount.hideConditionOn);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

