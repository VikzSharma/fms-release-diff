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
 *  org.apache.thrift.meta_data.MapMetaData
 *  org.apache.thrift.meta_data.StructMetaData
 *  org.apache.thrift.protocol.TCompactProtocol
 *  org.apache.thrift.protocol.TField
 *  org.apache.thrift.protocol.TMap
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

import com.filemaker.jwpc.iwp.thrift.layout.NonFieldObjectsData;
import com.filemaker.jwpc.iwp.thrift.layout.SingleRowPartsData;
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
import org.apache.thrift.meta_data.MapMetaData;
import org.apache.thrift.meta_data.StructMetaData;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TMap;
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

public class PortalData
implements TBase<PortalData, _Fields>,
Serializable,
Cloneable,
Comparable<PortalData> {
    private static final TStruct STRUCT_DESC = new TStruct("PortalData");
    private static final TField OBJECT_ID_FIELD_DESC = new TField("objectId", 8, 1);
    private static final TField NON_FIELD_OBJECTS_DATA_FIELD_DESC = new TField("nonFieldObjectsData", 12, 2);
    private static final TField PORTAL_ROW_DATA_FIELD_DESC = new TField("portalRowData", 13, 3);
    private static final TField NEW_PORTAL_ROW_DATA_FIELD_DESC = new TField("newPortalRowData", 12, 4);
    private static final TField HIDE_CONDITION_ON_FIELD_DESC = new TField("hideConditionOn", 2, 5);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new PortalDataStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new PortalDataTupleSchemeFactory();
    private int objectId;
    @Nullable
    private NonFieldObjectsData nonFieldObjectsData;
    @Nullable
    private Map<Integer, SingleRowPartsData> portalRowData;
    @Nullable
    private SingleRowPartsData newPortalRowData;
    private boolean hideConditionOn;
    private static final int __OBJECTID_ISSET_ID = 0;
    private static final int __HIDECONDITIONON_ISSET_ID = 1;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public PortalData() {
        this.objectId = 0;
    }

    public PortalData(int n, NonFieldObjectsData nonFieldObjectsData, Map<Integer, SingleRowPartsData> map, SingleRowPartsData singleRowPartsData, boolean bl) {
        this();
        this.objectId = n;
        this.setObjectIdIsSet(true);
        this.nonFieldObjectsData = nonFieldObjectsData;
        this.portalRowData = map;
        this.newPortalRowData = singleRowPartsData;
        this.hideConditionOn = bl;
        this.setHideConditionOnIsSet(true);
    }

    public PortalData(PortalData portalData) {
        this.__isset_bitfield = portalData.__isset_bitfield;
        this.objectId = portalData.objectId;
        if (portalData.isSetNonFieldObjectsData()) {
            this.nonFieldObjectsData = new NonFieldObjectsData(portalData.nonFieldObjectsData);
        }
        if (portalData.isSetPortalRowData()) {
            HashMap<Integer, SingleRowPartsData> hashMap = new HashMap<Integer, SingleRowPartsData>(portalData.portalRowData.size());
            for (Map.Entry<Integer, SingleRowPartsData> entry : portalData.portalRowData.entrySet()) {
                Integer n = entry.getKey();
                SingleRowPartsData singleRowPartsData = entry.getValue();
                Integer n2 = n;
                SingleRowPartsData singleRowPartsData2 = new SingleRowPartsData(singleRowPartsData);
                hashMap.put(n2, singleRowPartsData2);
            }
            this.portalRowData = hashMap;
        }
        if (portalData.isSetNewPortalRowData()) {
            this.newPortalRowData = new SingleRowPartsData(portalData.newPortalRowData);
        }
        this.hideConditionOn = portalData.hideConditionOn;
    }

    public PortalData deepCopy() {
        return new PortalData(this);
    }

    public void clear() {
        this.objectId = 0;
        this.nonFieldObjectsData = null;
        this.portalRowData = null;
        this.newPortalRowData = null;
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

    @Nullable
    public NonFieldObjectsData getNonFieldObjectsData() {
        return this.nonFieldObjectsData;
    }

    public void setNonFieldObjectsData(@Nullable NonFieldObjectsData nonFieldObjectsData) {
        this.nonFieldObjectsData = nonFieldObjectsData;
    }

    public void unsetNonFieldObjectsData() {
        this.nonFieldObjectsData = null;
    }

    public boolean isSetNonFieldObjectsData() {
        return this.nonFieldObjectsData != null;
    }

    public void setNonFieldObjectsDataIsSet(boolean bl) {
        if (!bl) {
            this.nonFieldObjectsData = null;
        }
    }

    public int getPortalRowDataSize() {
        return this.portalRowData == null ? 0 : this.portalRowData.size();
    }

    public void putToPortalRowData(int n, SingleRowPartsData singleRowPartsData) {
        if (this.portalRowData == null) {
            this.portalRowData = new HashMap<Integer, SingleRowPartsData>();
        }
        this.portalRowData.put(n, singleRowPartsData);
    }

    @Nullable
    public Map<Integer, SingleRowPartsData> getPortalRowData() {
        return this.portalRowData;
    }

    public void setPortalRowData(@Nullable Map<Integer, SingleRowPartsData> map) {
        this.portalRowData = map;
    }

    public void unsetPortalRowData() {
        this.portalRowData = null;
    }

    public boolean isSetPortalRowData() {
        return this.portalRowData != null;
    }

    public void setPortalRowDataIsSet(boolean bl) {
        if (!bl) {
            this.portalRowData = null;
        }
    }

    @Nullable
    public SingleRowPartsData getNewPortalRowData() {
        return this.newPortalRowData;
    }

    public void setNewPortalRowData(@Nullable SingleRowPartsData singleRowPartsData) {
        this.newPortalRowData = singleRowPartsData;
    }

    public void unsetNewPortalRowData() {
        this.newPortalRowData = null;
    }

    public boolean isSetNewPortalRowData() {
        return this.newPortalRowData != null;
    }

    public void setNewPortalRowDataIsSet(boolean bl) {
        if (!bl) {
            this.newPortalRowData = null;
        }
    }

    public boolean isHideConditionOn() {
        return this.hideConditionOn;
    }

    public void setHideConditionOn(boolean bl) {
        this.hideConditionOn = bl;
        this.setHideConditionOnIsSet(true);
    }

    public void unsetHideConditionOn() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)1);
    }

    public boolean isSetHideConditionOn() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)1);
    }

    public void setHideConditionOnIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)1, (boolean)bl);
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
                    this.unsetNonFieldObjectsData();
                    break;
                }
                this.setNonFieldObjectsData((NonFieldObjectsData)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetPortalRowData();
                    break;
                }
                this.setPortalRowData((Map)object);
                break;
            }
            case 3: {
                if (object == null) {
                    this.unsetNewPortalRowData();
                    break;
                }
                this.setNewPortalRowData((SingleRowPartsData)object);
                break;
            }
            case 4: {
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
                return this.getNonFieldObjectsData();
            }
            case 2: {
                return this.getPortalRowData();
            }
            case 3: {
                return this.getNewPortalRowData();
            }
            case 4: {
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
                return this.isSetNonFieldObjectsData();
            }
            case 2: {
                return this.isSetPortalRowData();
            }
            case 3: {
                return this.isSetNewPortalRowData();
            }
            case 4: {
                return this.isSetHideConditionOn();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof PortalData) {
            return this.equals((PortalData)object);
        }
        return false;
    }

    public boolean equals(PortalData portalData) {
        if (portalData == null) {
            return false;
        }
        if (this == portalData) {
            return true;
        }
        boolean bl = true;
        boolean bl2 = true;
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (this.objectId != portalData.objectId) {
                return false;
            }
        }
        boolean bl3 = this.isSetNonFieldObjectsData();
        boolean bl4 = portalData.isSetNonFieldObjectsData();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.nonFieldObjectsData.equals(portalData.nonFieldObjectsData)) {
                return false;
            }
        }
        boolean bl5 = this.isSetPortalRowData();
        boolean bl6 = portalData.isSetPortalRowData();
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (!this.portalRowData.equals(portalData.portalRowData)) {
                return false;
            }
        }
        boolean bl7 = this.isSetNewPortalRowData();
        boolean bl8 = portalData.isSetNewPortalRowData();
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (!this.newPortalRowData.equals(portalData.newPortalRowData)) {
                return false;
            }
        }
        boolean bl9 = true;
        boolean bl10 = true;
        if (bl9 || bl10) {
            if (!bl9 || !bl10) {
                return false;
            }
            if (this.hideConditionOn != portalData.hideConditionOn) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + this.objectId;
        n = n * 8191 + (this.isSetNonFieldObjectsData() ? 131071 : 524287);
        if (this.isSetNonFieldObjectsData()) {
            n = n * 8191 + this.nonFieldObjectsData.hashCode();
        }
        n = n * 8191 + (this.isSetPortalRowData() ? 131071 : 524287);
        if (this.isSetPortalRowData()) {
            n = n * 8191 + this.portalRowData.hashCode();
        }
        n = n * 8191 + (this.isSetNewPortalRowData() ? 131071 : 524287);
        if (this.isSetNewPortalRowData()) {
            n = n * 8191 + this.newPortalRowData.hashCode();
        }
        n = n * 8191 + (this.hideConditionOn ? 131071 : 524287);
        return n;
    }

    @Override
    public int compareTo(PortalData portalData) {
        if (!this.getClass().equals(portalData.getClass())) {
            return this.getClass().getName().compareTo(portalData.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetObjectId(), portalData.isSetObjectId());
        if (n != 0) {
            return n;
        }
        if (this.isSetObjectId() && (n = TBaseHelper.compareTo((int)this.objectId, (int)portalData.objectId)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetNonFieldObjectsData(), portalData.isSetNonFieldObjectsData());
        if (n != 0) {
            return n;
        }
        if (this.isSetNonFieldObjectsData() && (n = TBaseHelper.compareTo((Comparable)this.nonFieldObjectsData, (Comparable)portalData.nonFieldObjectsData)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetPortalRowData(), portalData.isSetPortalRowData());
        if (n != 0) {
            return n;
        }
        if (this.isSetPortalRowData() && (n = TBaseHelper.compareTo(this.portalRowData, portalData.portalRowData)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetNewPortalRowData(), portalData.isSetNewPortalRowData());
        if (n != 0) {
            return n;
        }
        if (this.isSetNewPortalRowData() && (n = TBaseHelper.compareTo((Comparable)this.newPortalRowData, (Comparable)portalData.newPortalRowData)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetHideConditionOn(), portalData.isSetHideConditionOn());
        if (n != 0) {
            return n;
        }
        if (this.isSetHideConditionOn() && (n = TBaseHelper.compareTo((boolean)this.hideConditionOn, (boolean)portalData.hideConditionOn)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        PortalData.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        PortalData.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("PortalData(");
        boolean bl = true;
        stringBuilder.append("objectId:");
        stringBuilder.append(this.objectId);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("nonFieldObjectsData:");
        if (this.nonFieldObjectsData == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.nonFieldObjectsData);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("portalRowData:");
        if (this.portalRowData == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.portalRowData);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("newPortalRowData:");
        if (this.newPortalRowData == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.newPortalRowData);
        }
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
        if (this.nonFieldObjectsData != null) {
            this.nonFieldObjectsData.validate();
        }
        if (this.newPortalRowData != null) {
            this.newPortalRowData.validate();
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
        enumMap.put(_Fields.OBJECT_ID, new FieldMetaData("objectId", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.NON_FIELD_OBJECTS_DATA, new FieldMetaData("nonFieldObjectsData", 3, (FieldValueMetaData)new StructMetaData(12, NonFieldObjectsData.class)));
        enumMap.put(_Fields.PORTAL_ROW_DATA, new FieldMetaData("portalRowData", 3, (FieldValueMetaData)new MapMetaData(13, new FieldValueMetaData(8), (FieldValueMetaData)new StructMetaData(12, SingleRowPartsData.class))));
        enumMap.put(_Fields.NEW_PORTAL_ROW_DATA, new FieldMetaData("newPortalRowData", 3, (FieldValueMetaData)new StructMetaData(12, SingleRowPartsData.class)));
        enumMap.put(_Fields.HIDE_CONDITION_ON, new FieldMetaData("hideConditionOn", 3, new FieldValueMetaData(2)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(PortalData.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        OBJECT_ID(1, "objectId"),
        NON_FIELD_OBJECTS_DATA(2, "nonFieldObjectsData"),
        PORTAL_ROW_DATA(3, "portalRowData"),
        NEW_PORTAL_ROW_DATA(4, "newPortalRowData"),
        HIDE_CONDITION_ON(5, "hideConditionOn");

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
                    return NON_FIELD_OBJECTS_DATA;
                }
                case 3: {
                    return PORTAL_ROW_DATA;
                }
                case 4: {
                    return NEW_PORTAL_ROW_DATA;
                }
                case 5: {
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

    private static class PortalDataStandardSchemeFactory
    implements SchemeFactory {
        private PortalDataStandardSchemeFactory() {
        }

        public PortalDataStandardScheme getScheme() {
            return new PortalDataStandardScheme();
        }
    }

    private static class PortalDataTupleSchemeFactory
    implements SchemeFactory {
        private PortalDataTupleSchemeFactory() {
        }

        public PortalDataTupleScheme getScheme() {
            return new PortalDataTupleScheme();
        }
    }

    private static class PortalDataTupleScheme
    extends TupleScheme<PortalData> {
        private PortalDataTupleScheme() {
        }

        public void write(TProtocol tProtocol, PortalData portalData) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (portalData.isSetObjectId()) {
                bitSet.set(0);
            }
            if (portalData.isSetNonFieldObjectsData()) {
                bitSet.set(1);
            }
            if (portalData.isSetPortalRowData()) {
                bitSet.set(2);
            }
            if (portalData.isSetNewPortalRowData()) {
                bitSet.set(3);
            }
            if (portalData.isSetHideConditionOn()) {
                bitSet.set(4);
            }
            tTupleProtocol.writeBitSet(bitSet, 5);
            if (portalData.isSetObjectId()) {
                tTupleProtocol.writeI32(portalData.objectId);
            }
            if (portalData.isSetNonFieldObjectsData()) {
                portalData.nonFieldObjectsData.write((TProtocol)tTupleProtocol);
            }
            if (portalData.isSetPortalRowData()) {
                tTupleProtocol.writeI32(portalData.portalRowData.size());
                for (Map.Entry<Integer, SingleRowPartsData> entry : portalData.portalRowData.entrySet()) {
                    tTupleProtocol.writeI32(entry.getKey().intValue());
                    entry.getValue().write((TProtocol)tTupleProtocol);
                }
            }
            if (portalData.isSetNewPortalRowData()) {
                portalData.newPortalRowData.write((TProtocol)tTupleProtocol);
            }
            if (portalData.isSetHideConditionOn()) {
                tTupleProtocol.writeBool(portalData.hideConditionOn);
            }
        }

        public void read(TProtocol tProtocol, PortalData portalData) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(5);
            if (bitSet.get(0)) {
                portalData.objectId = tTupleProtocol.readI32();
                portalData.setObjectIdIsSet(true);
            }
            if (bitSet.get(1)) {
                portalData.nonFieldObjectsData = new NonFieldObjectsData();
                portalData.nonFieldObjectsData.read((TProtocol)tTupleProtocol);
                portalData.setNonFieldObjectsDataIsSet(true);
            }
            if (bitSet.get(2)) {
                TMap tMap = tTupleProtocol.readMapBegin((byte)8, (byte)12);
                portalData.portalRowData = new HashMap<Integer, SingleRowPartsData>(2 * tMap.size);
                for (int i = 0; i < tMap.size; ++i) {
                    int n = tTupleProtocol.readI32();
                    SingleRowPartsData singleRowPartsData = new SingleRowPartsData();
                    singleRowPartsData.read((TProtocol)tTupleProtocol);
                    portalData.portalRowData.put(n, singleRowPartsData);
                }
                portalData.setPortalRowDataIsSet(true);
            }
            if (bitSet.get(3)) {
                portalData.newPortalRowData = new SingleRowPartsData();
                portalData.newPortalRowData.read((TProtocol)tTupleProtocol);
                portalData.setNewPortalRowDataIsSet(true);
            }
            if (bitSet.get(4)) {
                portalData.hideConditionOn = tTupleProtocol.readBool();
                portalData.setHideConditionOnIsSet(true);
            }
        }
    }

    private static class PortalDataStandardScheme
    extends StandardScheme<PortalData> {
        private PortalDataStandardScheme() {
        }

        public void read(TProtocol tProtocol, PortalData portalData) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 8) {
                            portalData.objectId = tProtocol.readI32();
                            portalData.setObjectIdIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 12) {
                            portalData.nonFieldObjectsData = new NonFieldObjectsData();
                            portalData.nonFieldObjectsData.read(tProtocol);
                            portalData.setNonFieldObjectsDataIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 13) {
                            TMap tMap = tProtocol.readMapBegin();
                            portalData.portalRowData = new HashMap<Integer, SingleRowPartsData>(2 * tMap.size);
                            for (int i = 0; i < tMap.size; ++i) {
                                int n = tProtocol.readI32();
                                SingleRowPartsData singleRowPartsData = new SingleRowPartsData();
                                singleRowPartsData.read(tProtocol);
                                portalData.portalRowData.put(n, singleRowPartsData);
                            }
                            tProtocol.readMapEnd();
                            portalData.setPortalRowDataIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 12) {
                            portalData.newPortalRowData = new SingleRowPartsData();
                            portalData.newPortalRowData.read(tProtocol);
                            portalData.setNewPortalRowDataIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 5: {
                        if (tField.type == 2) {
                            portalData.hideConditionOn = tProtocol.readBool();
                            portalData.setHideConditionOnIsSet(true);
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
            portalData.validate();
        }

        public void write(TProtocol tProtocol, PortalData portalData) throws TException {
            portalData.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            tProtocol.writeFieldBegin(OBJECT_ID_FIELD_DESC);
            tProtocol.writeI32(portalData.objectId);
            tProtocol.writeFieldEnd();
            if (portalData.nonFieldObjectsData != null) {
                tProtocol.writeFieldBegin(NON_FIELD_OBJECTS_DATA_FIELD_DESC);
                portalData.nonFieldObjectsData.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            if (portalData.portalRowData != null) {
                tProtocol.writeFieldBegin(PORTAL_ROW_DATA_FIELD_DESC);
                tProtocol.writeMapBegin(new TMap(8, 12, portalData.portalRowData.size()));
                for (Map.Entry<Integer, SingleRowPartsData> entry : portalData.portalRowData.entrySet()) {
                    tProtocol.writeI32(entry.getKey().intValue());
                    entry.getValue().write(tProtocol);
                }
                tProtocol.writeMapEnd();
                tProtocol.writeFieldEnd();
            }
            if (portalData.newPortalRowData != null) {
                tProtocol.writeFieldBegin(NEW_PORTAL_ROW_DATA_FIELD_DESC);
                portalData.newPortalRowData.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(HIDE_CONDITION_ON_FIELD_DESC);
            tProtocol.writeBool(portalData.hideConditionOn);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

