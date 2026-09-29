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
package com.filemaker.jwpc.iwp.thrift.notification;

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

public class RowChangeNotification
implements TBase<RowChangeNotification, _Fields>,
Serializable,
Cloneable,
Comparable<RowChangeNotification> {
    private static final TStruct STRUCT_DESC = new TStruct("RowChangeNotification");
    private static final TField ROW_DATA_FIELD_DESC = new TField("rowData", 13, 1);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new RowChangeNotificationStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new RowChangeNotificationTupleSchemeFactory();
    @Nullable
    private Map<Integer, SingleRowPartsData> rowData;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public RowChangeNotification() {
    }

    public RowChangeNotification(Map<Integer, SingleRowPartsData> map) {
        this();
        this.rowData = map;
    }

    public RowChangeNotification(RowChangeNotification rowChangeNotification) {
        if (rowChangeNotification.isSetRowData()) {
            HashMap<Integer, SingleRowPartsData> hashMap = new HashMap<Integer, SingleRowPartsData>(rowChangeNotification.rowData.size());
            for (Map.Entry<Integer, SingleRowPartsData> entry : rowChangeNotification.rowData.entrySet()) {
                Integer n = entry.getKey();
                SingleRowPartsData singleRowPartsData = entry.getValue();
                Integer n2 = n;
                SingleRowPartsData singleRowPartsData2 = new SingleRowPartsData(singleRowPartsData);
                hashMap.put(n2, singleRowPartsData2);
            }
            this.rowData = hashMap;
        }
    }

    public RowChangeNotification deepCopy() {
        return new RowChangeNotification(this);
    }

    public void clear() {
        this.rowData = null;
    }

    public int getRowDataSize() {
        return this.rowData == null ? 0 : this.rowData.size();
    }

    public void putToRowData(int n, SingleRowPartsData singleRowPartsData) {
        if (this.rowData == null) {
            this.rowData = new HashMap<Integer, SingleRowPartsData>();
        }
        this.rowData.put(n, singleRowPartsData);
    }

    @Nullable
    public Map<Integer, SingleRowPartsData> getRowData() {
        return this.rowData;
    }

    public void setRowData(@Nullable Map<Integer, SingleRowPartsData> map) {
        this.rowData = map;
    }

    public void unsetRowData() {
        this.rowData = null;
    }

    public boolean isSetRowData() {
        return this.rowData != null;
    }

    public void setRowDataIsSet(boolean bl) {
        if (!bl) {
            this.rowData = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetRowData();
                    break;
                }
                this.setRowData((Map)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getRowData();
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
                return this.isSetRowData();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof RowChangeNotification) {
            return this.equals((RowChangeNotification)object);
        }
        return false;
    }

    public boolean equals(RowChangeNotification rowChangeNotification) {
        if (rowChangeNotification == null) {
            return false;
        }
        if (this == rowChangeNotification) {
            return true;
        }
        boolean bl = this.isSetRowData();
        boolean bl2 = rowChangeNotification.isSetRowData();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.rowData.equals(rowChangeNotification.rowData)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetRowData() ? 131071 : 524287);
        if (this.isSetRowData()) {
            n = n * 8191 + this.rowData.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(RowChangeNotification rowChangeNotification) {
        if (!this.getClass().equals(rowChangeNotification.getClass())) {
            return this.getClass().getName().compareTo(rowChangeNotification.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetRowData(), rowChangeNotification.isSetRowData());
        if (n != 0) {
            return n;
        }
        if (this.isSetRowData() && (n = TBaseHelper.compareTo(this.rowData, rowChangeNotification.rowData)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        RowChangeNotification.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        RowChangeNotification.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("RowChangeNotification(");
        boolean bl = true;
        stringBuilder.append("rowData:");
        if (this.rowData == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.rowData);
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
        enumMap.put(_Fields.ROW_DATA, new FieldMetaData("rowData", 3, (FieldValueMetaData)new MapMetaData(13, new FieldValueMetaData(8), (FieldValueMetaData)new StructMetaData(12, SingleRowPartsData.class))));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(RowChangeNotification.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        ROW_DATA(1, "rowData");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return ROW_DATA;
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

    private static class RowChangeNotificationStandardSchemeFactory
    implements SchemeFactory {
        private RowChangeNotificationStandardSchemeFactory() {
        }

        public RowChangeNotificationStandardScheme getScheme() {
            return new RowChangeNotificationStandardScheme();
        }
    }

    private static class RowChangeNotificationTupleSchemeFactory
    implements SchemeFactory {
        private RowChangeNotificationTupleSchemeFactory() {
        }

        public RowChangeNotificationTupleScheme getScheme() {
            return new RowChangeNotificationTupleScheme();
        }
    }

    private static class RowChangeNotificationTupleScheme
    extends TupleScheme<RowChangeNotification> {
        private RowChangeNotificationTupleScheme() {
        }

        public void write(TProtocol tProtocol, RowChangeNotification rowChangeNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (rowChangeNotification.isSetRowData()) {
                bitSet.set(0);
            }
            tTupleProtocol.writeBitSet(bitSet, 1);
            if (rowChangeNotification.isSetRowData()) {
                tTupleProtocol.writeI32(rowChangeNotification.rowData.size());
                for (Map.Entry<Integer, SingleRowPartsData> entry : rowChangeNotification.rowData.entrySet()) {
                    tTupleProtocol.writeI32(entry.getKey().intValue());
                    entry.getValue().write((TProtocol)tTupleProtocol);
                }
            }
        }

        public void read(TProtocol tProtocol, RowChangeNotification rowChangeNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(1);
            if (bitSet.get(0)) {
                TMap tMap = tTupleProtocol.readMapBegin((byte)8, (byte)12);
                rowChangeNotification.rowData = new HashMap<Integer, SingleRowPartsData>(2 * tMap.size);
                for (int i = 0; i < tMap.size; ++i) {
                    int n = tTupleProtocol.readI32();
                    SingleRowPartsData singleRowPartsData = new SingleRowPartsData();
                    singleRowPartsData.read((TProtocol)tTupleProtocol);
                    rowChangeNotification.rowData.put(n, singleRowPartsData);
                }
                rowChangeNotification.setRowDataIsSet(true);
            }
        }
    }

    private static class RowChangeNotificationStandardScheme
    extends StandardScheme<RowChangeNotification> {
        private RowChangeNotificationStandardScheme() {
        }

        public void read(TProtocol tProtocol, RowChangeNotification rowChangeNotification) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 13) {
                            TMap tMap = tProtocol.readMapBegin();
                            rowChangeNotification.rowData = new HashMap<Integer, SingleRowPartsData>(2 * tMap.size);
                            for (int i = 0; i < tMap.size; ++i) {
                                int n = tProtocol.readI32();
                                SingleRowPartsData singleRowPartsData = new SingleRowPartsData();
                                singleRowPartsData.read(tProtocol);
                                rowChangeNotification.rowData.put(n, singleRowPartsData);
                            }
                            tProtocol.readMapEnd();
                            rowChangeNotification.setRowDataIsSet(true);
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
            rowChangeNotification.validate();
        }

        public void write(TProtocol tProtocol, RowChangeNotification rowChangeNotification) throws TException {
            rowChangeNotification.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (rowChangeNotification.rowData != null) {
                tProtocol.writeFieldBegin(ROW_DATA_FIELD_DESC);
                tProtocol.writeMapBegin(new TMap(8, 12, rowChangeNotification.rowData.size()));
                for (Map.Entry<Integer, SingleRowPartsData> entry : rowChangeNotification.rowData.entrySet()) {
                    tProtocol.writeI32(entry.getKey().intValue());
                    entry.getValue().write(tProtocol);
                }
                tProtocol.writeMapEnd();
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

