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

public class RowSetDataChangeNotification
implements TBase<RowSetDataChangeNotification, _Fields>,
Serializable,
Cloneable,
Comparable<RowSetDataChangeNotification> {
    private static final TStruct STRUCT_DESC = new TStruct("RowSetDataChangeNotification");
    private static final TField RELATED_ROW_DATA_CHANGE_FIELD_DESC = new TField("relatedRowDataChange", 2, 1);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new RowSetDataChangeNotificationStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new RowSetDataChangeNotificationTupleSchemeFactory();
    private boolean relatedRowDataChange;
    private static final int __RELATEDROWDATACHANGE_ISSET_ID = 0;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public RowSetDataChangeNotification() {
    }

    public RowSetDataChangeNotification(boolean bl) {
        this();
        this.relatedRowDataChange = bl;
        this.setRelatedRowDataChangeIsSet(true);
    }

    public RowSetDataChangeNotification(RowSetDataChangeNotification rowSetDataChangeNotification) {
        this.__isset_bitfield = rowSetDataChangeNotification.__isset_bitfield;
        this.relatedRowDataChange = rowSetDataChangeNotification.relatedRowDataChange;
    }

    public RowSetDataChangeNotification deepCopy() {
        return new RowSetDataChangeNotification(this);
    }

    public void clear() {
        this.setRelatedRowDataChangeIsSet(false);
        this.relatedRowDataChange = false;
    }

    public boolean isRelatedRowDataChange() {
        return this.relatedRowDataChange;
    }

    public void setRelatedRowDataChange(boolean bl) {
        this.relatedRowDataChange = bl;
        this.setRelatedRowDataChangeIsSet(true);
    }

    public void unsetRelatedRowDataChange() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetRelatedRowDataChange() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setRelatedRowDataChangeIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetRelatedRowDataChange();
                    break;
                }
                this.setRelatedRowDataChange((Boolean)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.isRelatedRowDataChange();
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
                return this.isSetRelatedRowDataChange();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof RowSetDataChangeNotification) {
            return this.equals((RowSetDataChangeNotification)object);
        }
        return false;
    }

    public boolean equals(RowSetDataChangeNotification rowSetDataChangeNotification) {
        if (rowSetDataChangeNotification == null) {
            return false;
        }
        if (this == rowSetDataChangeNotification) {
            return true;
        }
        boolean bl = true;
        boolean bl2 = true;
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (this.relatedRowDataChange != rowSetDataChangeNotification.relatedRowDataChange) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.relatedRowDataChange ? 131071 : 524287);
        return n;
    }

    @Override
    public int compareTo(RowSetDataChangeNotification rowSetDataChangeNotification) {
        if (!this.getClass().equals(rowSetDataChangeNotification.getClass())) {
            return this.getClass().getName().compareTo(rowSetDataChangeNotification.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetRelatedRowDataChange(), rowSetDataChangeNotification.isSetRelatedRowDataChange());
        if (n != 0) {
            return n;
        }
        if (this.isSetRelatedRowDataChange() && (n = TBaseHelper.compareTo((boolean)this.relatedRowDataChange, (boolean)rowSetDataChangeNotification.relatedRowDataChange)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        RowSetDataChangeNotification.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        RowSetDataChangeNotification.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("RowSetDataChangeNotification(");
        boolean bl = true;
        stringBuilder.append("relatedRowDataChange:");
        stringBuilder.append(this.relatedRowDataChange);
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
        enumMap.put(_Fields.RELATED_ROW_DATA_CHANGE, new FieldMetaData("relatedRowDataChange", 3, new FieldValueMetaData(2)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(RowSetDataChangeNotification.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        RELATED_ROW_DATA_CHANGE(1, "relatedRowDataChange");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return RELATED_ROW_DATA_CHANGE;
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

    private static class RowSetDataChangeNotificationStandardSchemeFactory
    implements SchemeFactory {
        private RowSetDataChangeNotificationStandardSchemeFactory() {
        }

        public RowSetDataChangeNotificationStandardScheme getScheme() {
            return new RowSetDataChangeNotificationStandardScheme();
        }
    }

    private static class RowSetDataChangeNotificationTupleSchemeFactory
    implements SchemeFactory {
        private RowSetDataChangeNotificationTupleSchemeFactory() {
        }

        public RowSetDataChangeNotificationTupleScheme getScheme() {
            return new RowSetDataChangeNotificationTupleScheme();
        }
    }

    private static class RowSetDataChangeNotificationTupleScheme
    extends TupleScheme<RowSetDataChangeNotification> {
        private RowSetDataChangeNotificationTupleScheme() {
        }

        public void write(TProtocol tProtocol, RowSetDataChangeNotification rowSetDataChangeNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (rowSetDataChangeNotification.isSetRelatedRowDataChange()) {
                bitSet.set(0);
            }
            tTupleProtocol.writeBitSet(bitSet, 1);
            if (rowSetDataChangeNotification.isSetRelatedRowDataChange()) {
                tTupleProtocol.writeBool(rowSetDataChangeNotification.relatedRowDataChange);
            }
        }

        public void read(TProtocol tProtocol, RowSetDataChangeNotification rowSetDataChangeNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(1);
            if (bitSet.get(0)) {
                rowSetDataChangeNotification.relatedRowDataChange = tTupleProtocol.readBool();
                rowSetDataChangeNotification.setRelatedRowDataChangeIsSet(true);
            }
        }
    }

    private static class RowSetDataChangeNotificationStandardScheme
    extends StandardScheme<RowSetDataChangeNotification> {
        private RowSetDataChangeNotificationStandardScheme() {
        }

        public void read(TProtocol tProtocol, RowSetDataChangeNotification rowSetDataChangeNotification) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 2) {
                            rowSetDataChangeNotification.relatedRowDataChange = tProtocol.readBool();
                            rowSetDataChangeNotification.setRelatedRowDataChangeIsSet(true);
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
            rowSetDataChangeNotification.validate();
        }

        public void write(TProtocol tProtocol, RowSetDataChangeNotification rowSetDataChangeNotification) throws TException {
            rowSetDataChangeNotification.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            tProtocol.writeFieldBegin(RELATED_ROW_DATA_CHANGE_FIELD_DESC);
            tProtocol.writeBool(rowSetDataChangeNotification.relatedRowDataChange);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

