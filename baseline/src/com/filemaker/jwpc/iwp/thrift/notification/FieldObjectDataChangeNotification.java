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
package com.filemaker.jwpc.iwp.thrift.notification;

import com.filemaker.jwpc.iwp.thrift.layout.FieldObjectData;
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

public class FieldObjectDataChangeNotification
implements TBase<FieldObjectDataChangeNotification, _Fields>,
Serializable,
Cloneable,
Comparable<FieldObjectDataChangeNotification> {
    private static final TStruct STRUCT_DESC = new TStruct("FieldObjectDataChangeNotification");
    private static final TField FIELD_OBJECT_DATA_FIELD_DESC = new TField("fieldObjectData", 12, 1);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new FieldObjectDataChangeNotificationStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new FieldObjectDataChangeNotificationTupleSchemeFactory();
    @Nullable
    private FieldObjectData fieldObjectData;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public FieldObjectDataChangeNotification() {
    }

    public FieldObjectDataChangeNotification(FieldObjectData fieldObjectData) {
        this();
        this.fieldObjectData = fieldObjectData;
    }

    public FieldObjectDataChangeNotification(FieldObjectDataChangeNotification fieldObjectDataChangeNotification) {
        if (fieldObjectDataChangeNotification.isSetFieldObjectData()) {
            this.fieldObjectData = new FieldObjectData(fieldObjectDataChangeNotification.fieldObjectData);
        }
    }

    public FieldObjectDataChangeNotification deepCopy() {
        return new FieldObjectDataChangeNotification(this);
    }

    public void clear() {
        this.fieldObjectData = null;
    }

    @Nullable
    public FieldObjectData getFieldObjectData() {
        return this.fieldObjectData;
    }

    public void setFieldObjectData(@Nullable FieldObjectData fieldObjectData) {
        this.fieldObjectData = fieldObjectData;
    }

    public void unsetFieldObjectData() {
        this.fieldObjectData = null;
    }

    public boolean isSetFieldObjectData() {
        return this.fieldObjectData != null;
    }

    public void setFieldObjectDataIsSet(boolean bl) {
        if (!bl) {
            this.fieldObjectData = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetFieldObjectData();
                    break;
                }
                this.setFieldObjectData((FieldObjectData)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getFieldObjectData();
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
                return this.isSetFieldObjectData();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof FieldObjectDataChangeNotification) {
            return this.equals((FieldObjectDataChangeNotification)object);
        }
        return false;
    }

    public boolean equals(FieldObjectDataChangeNotification fieldObjectDataChangeNotification) {
        if (fieldObjectDataChangeNotification == null) {
            return false;
        }
        if (this == fieldObjectDataChangeNotification) {
            return true;
        }
        boolean bl = this.isSetFieldObjectData();
        boolean bl2 = fieldObjectDataChangeNotification.isSetFieldObjectData();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.fieldObjectData.equals(fieldObjectDataChangeNotification.fieldObjectData)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetFieldObjectData() ? 131071 : 524287);
        if (this.isSetFieldObjectData()) {
            n = n * 8191 + this.fieldObjectData.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(FieldObjectDataChangeNotification fieldObjectDataChangeNotification) {
        if (!this.getClass().equals(fieldObjectDataChangeNotification.getClass())) {
            return this.getClass().getName().compareTo(fieldObjectDataChangeNotification.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetFieldObjectData(), fieldObjectDataChangeNotification.isSetFieldObjectData());
        if (n != 0) {
            return n;
        }
        if (this.isSetFieldObjectData() && (n = TBaseHelper.compareTo((Comparable)this.fieldObjectData, (Comparable)fieldObjectDataChangeNotification.fieldObjectData)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        FieldObjectDataChangeNotification.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        FieldObjectDataChangeNotification.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("FieldObjectDataChangeNotification(");
        boolean bl = true;
        stringBuilder.append("fieldObjectData:");
        if (this.fieldObjectData == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.fieldObjectData);
        }
        bl = false;
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void validate() throws TException {
        if (this.fieldObjectData != null) {
            this.fieldObjectData.validate();
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
        enumMap.put(_Fields.FIELD_OBJECT_DATA, new FieldMetaData("fieldObjectData", 3, (FieldValueMetaData)new StructMetaData(12, FieldObjectData.class)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(FieldObjectDataChangeNotification.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        FIELD_OBJECT_DATA(1, "fieldObjectData");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return FIELD_OBJECT_DATA;
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

    private static class FieldObjectDataChangeNotificationStandardSchemeFactory
    implements SchemeFactory {
        private FieldObjectDataChangeNotificationStandardSchemeFactory() {
        }

        public FieldObjectDataChangeNotificationStandardScheme getScheme() {
            return new FieldObjectDataChangeNotificationStandardScheme();
        }
    }

    private static class FieldObjectDataChangeNotificationTupleSchemeFactory
    implements SchemeFactory {
        private FieldObjectDataChangeNotificationTupleSchemeFactory() {
        }

        public FieldObjectDataChangeNotificationTupleScheme getScheme() {
            return new FieldObjectDataChangeNotificationTupleScheme();
        }
    }

    private static class FieldObjectDataChangeNotificationTupleScheme
    extends TupleScheme<FieldObjectDataChangeNotification> {
        private FieldObjectDataChangeNotificationTupleScheme() {
        }

        public void write(TProtocol tProtocol, FieldObjectDataChangeNotification fieldObjectDataChangeNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (fieldObjectDataChangeNotification.isSetFieldObjectData()) {
                bitSet.set(0);
            }
            tTupleProtocol.writeBitSet(bitSet, 1);
            if (fieldObjectDataChangeNotification.isSetFieldObjectData()) {
                fieldObjectDataChangeNotification.fieldObjectData.write((TProtocol)tTupleProtocol);
            }
        }

        public void read(TProtocol tProtocol, FieldObjectDataChangeNotification fieldObjectDataChangeNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(1);
            if (bitSet.get(0)) {
                fieldObjectDataChangeNotification.fieldObjectData = new FieldObjectData();
                fieldObjectDataChangeNotification.fieldObjectData.read((TProtocol)tTupleProtocol);
                fieldObjectDataChangeNotification.setFieldObjectDataIsSet(true);
            }
        }
    }

    private static class FieldObjectDataChangeNotificationStandardScheme
    extends StandardScheme<FieldObjectDataChangeNotification> {
        private FieldObjectDataChangeNotificationStandardScheme() {
        }

        public void read(TProtocol tProtocol, FieldObjectDataChangeNotification fieldObjectDataChangeNotification) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 12) {
                            fieldObjectDataChangeNotification.fieldObjectData = new FieldObjectData();
                            fieldObjectDataChangeNotification.fieldObjectData.read(tProtocol);
                            fieldObjectDataChangeNotification.setFieldObjectDataIsSet(true);
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
            fieldObjectDataChangeNotification.validate();
        }

        public void write(TProtocol tProtocol, FieldObjectDataChangeNotification fieldObjectDataChangeNotification) throws TException {
            fieldObjectDataChangeNotification.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (fieldObjectDataChangeNotification.fieldObjectData != null) {
                tProtocol.writeFieldBegin(FIELD_OBJECT_DATA_FIELD_DESC);
                fieldObjectDataChangeNotification.fieldObjectData.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

