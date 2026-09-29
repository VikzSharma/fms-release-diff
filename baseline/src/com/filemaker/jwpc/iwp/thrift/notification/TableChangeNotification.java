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
package com.filemaker.jwpc.iwp.thrift.notification;

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

public class TableChangeNotification
implements TBase<TableChangeNotification, _Fields>,
Serializable,
Cloneable,
Comparable<TableChangeNotification> {
    private static final TStruct STRUCT_DESC = new TStruct("TableChangeNotification");
    private static final TField FILE_NAME_FIELD_DESC = new TField("fileName", 11, 1);
    private static final TField TABLE_ID_FIELD_DESC = new TField("tableId", 8, 2);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new TableChangeNotificationStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new TableChangeNotificationTupleSchemeFactory();
    @Nullable
    private String fileName;
    private int tableId;
    private static final int __TABLEID_ISSET_ID = 0;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public TableChangeNotification() {
    }

    public TableChangeNotification(String string, int n) {
        this();
        this.fileName = string;
        this.tableId = n;
        this.setTableIdIsSet(true);
    }

    public TableChangeNotification(TableChangeNotification tableChangeNotification) {
        this.__isset_bitfield = tableChangeNotification.__isset_bitfield;
        if (tableChangeNotification.isSetFileName()) {
            this.fileName = tableChangeNotification.fileName;
        }
        this.tableId = tableChangeNotification.tableId;
    }

    public TableChangeNotification deepCopy() {
        return new TableChangeNotification(this);
    }

    public void clear() {
        this.fileName = null;
        this.setTableIdIsSet(false);
        this.tableId = 0;
    }

    @Nullable
    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(@Nullable String string) {
        this.fileName = string;
    }

    public void unsetFileName() {
        this.fileName = null;
    }

    public boolean isSetFileName() {
        return this.fileName != null;
    }

    public void setFileNameIsSet(boolean bl) {
        if (!bl) {
            this.fileName = null;
        }
    }

    public int getTableId() {
        return this.tableId;
    }

    public void setTableId(int n) {
        this.tableId = n;
        this.setTableIdIsSet(true);
    }

    public void unsetTableId() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetTableId() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setTableIdIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetFileName();
                    break;
                }
                this.setFileName((String)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetTableId();
                    break;
                }
                this.setTableId((Integer)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getFileName();
            }
            case 1: {
                return this.getTableId();
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
                return this.isSetFileName();
            }
            case 1: {
                return this.isSetTableId();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof TableChangeNotification) {
            return this.equals((TableChangeNotification)object);
        }
        return false;
    }

    public boolean equals(TableChangeNotification tableChangeNotification) {
        if (tableChangeNotification == null) {
            return false;
        }
        if (this == tableChangeNotification) {
            return true;
        }
        boolean bl = this.isSetFileName();
        boolean bl2 = tableChangeNotification.isSetFileName();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.fileName.equals(tableChangeNotification.fileName)) {
                return false;
            }
        }
        boolean bl3 = true;
        boolean bl4 = true;
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (this.tableId != tableChangeNotification.tableId) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetFileName() ? 131071 : 524287);
        if (this.isSetFileName()) {
            n = n * 8191 + this.fileName.hashCode();
        }
        n = n * 8191 + this.tableId;
        return n;
    }

    @Override
    public int compareTo(TableChangeNotification tableChangeNotification) {
        if (!this.getClass().equals(tableChangeNotification.getClass())) {
            return this.getClass().getName().compareTo(tableChangeNotification.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetFileName(), tableChangeNotification.isSetFileName());
        if (n != 0) {
            return n;
        }
        if (this.isSetFileName() && (n = TBaseHelper.compareTo((String)this.fileName, (String)tableChangeNotification.fileName)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetTableId(), tableChangeNotification.isSetTableId());
        if (n != 0) {
            return n;
        }
        if (this.isSetTableId() && (n = TBaseHelper.compareTo((int)this.tableId, (int)tableChangeNotification.tableId)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        TableChangeNotification.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        TableChangeNotification.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("TableChangeNotification(");
        boolean bl = true;
        stringBuilder.append("fileName:");
        if (this.fileName == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.fileName);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("tableId:");
        stringBuilder.append(this.tableId);
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
        enumMap.put(_Fields.FILE_NAME, new FieldMetaData("fileName", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.TABLE_ID, new FieldMetaData("tableId", 3, new FieldValueMetaData(8)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(TableChangeNotification.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        FILE_NAME(1, "fileName"),
        TABLE_ID(2, "tableId");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return FILE_NAME;
                }
                case 2: {
                    return TABLE_ID;
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

    private static class TableChangeNotificationStandardSchemeFactory
    implements SchemeFactory {
        private TableChangeNotificationStandardSchemeFactory() {
        }

        public TableChangeNotificationStandardScheme getScheme() {
            return new TableChangeNotificationStandardScheme();
        }
    }

    private static class TableChangeNotificationTupleSchemeFactory
    implements SchemeFactory {
        private TableChangeNotificationTupleSchemeFactory() {
        }

        public TableChangeNotificationTupleScheme getScheme() {
            return new TableChangeNotificationTupleScheme();
        }
    }

    private static class TableChangeNotificationTupleScheme
    extends TupleScheme<TableChangeNotification> {
        private TableChangeNotificationTupleScheme() {
        }

        public void write(TProtocol tProtocol, TableChangeNotification tableChangeNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (tableChangeNotification.isSetFileName()) {
                bitSet.set(0);
            }
            if (tableChangeNotification.isSetTableId()) {
                bitSet.set(1);
            }
            tTupleProtocol.writeBitSet(bitSet, 2);
            if (tableChangeNotification.isSetFileName()) {
                tTupleProtocol.writeString(tableChangeNotification.fileName);
            }
            if (tableChangeNotification.isSetTableId()) {
                tTupleProtocol.writeI32(tableChangeNotification.tableId);
            }
        }

        public void read(TProtocol tProtocol, TableChangeNotification tableChangeNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(2);
            if (bitSet.get(0)) {
                tableChangeNotification.fileName = tTupleProtocol.readString();
                tableChangeNotification.setFileNameIsSet(true);
            }
            if (bitSet.get(1)) {
                tableChangeNotification.tableId = tTupleProtocol.readI32();
                tableChangeNotification.setTableIdIsSet(true);
            }
        }
    }

    private static class TableChangeNotificationStandardScheme
    extends StandardScheme<TableChangeNotification> {
        private TableChangeNotificationStandardScheme() {
        }

        public void read(TProtocol tProtocol, TableChangeNotification tableChangeNotification) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 11) {
                            tableChangeNotification.fileName = tProtocol.readString();
                            tableChangeNotification.setFileNameIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 8) {
                            tableChangeNotification.tableId = tProtocol.readI32();
                            tableChangeNotification.setTableIdIsSet(true);
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
            tableChangeNotification.validate();
        }

        public void write(TProtocol tProtocol, TableChangeNotification tableChangeNotification) throws TException {
            tableChangeNotification.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (tableChangeNotification.fileName != null) {
                tProtocol.writeFieldBegin(FILE_NAME_FIELD_DESC);
                tProtocol.writeString(tableChangeNotification.fileName);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(TABLE_ID_FIELD_DESC);
            tProtocol.writeI32(tableChangeNotification.tableId);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

