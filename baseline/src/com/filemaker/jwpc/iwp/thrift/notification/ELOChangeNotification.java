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

import com.filemaker.jwpc.iwp.thrift.layout.NonFieldObjectData;
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

public class ELOChangeNotification
implements TBase<ELOChangeNotification, _Fields>,
Serializable,
Cloneable,
Comparable<ELOChangeNotification> {
    private static final TStruct STRUCT_DESC = new TStruct("ELOChangeNotification");
    private static final TField SO_DATA_FIELD_DESC = new TField("soData", 12, 1);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new ELOChangeNotificationStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new ELOChangeNotificationTupleSchemeFactory();
    @Nullable
    private NonFieldObjectData soData;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public ELOChangeNotification() {
    }

    public ELOChangeNotification(NonFieldObjectData nonFieldObjectData) {
        this();
        this.soData = nonFieldObjectData;
    }

    public ELOChangeNotification(ELOChangeNotification eLOChangeNotification) {
        if (eLOChangeNotification.isSetSoData()) {
            this.soData = new NonFieldObjectData(eLOChangeNotification.soData);
        }
    }

    public ELOChangeNotification deepCopy() {
        return new ELOChangeNotification(this);
    }

    public void clear() {
        this.soData = null;
    }

    @Nullable
    public NonFieldObjectData getSoData() {
        return this.soData;
    }

    public void setSoData(@Nullable NonFieldObjectData nonFieldObjectData) {
        this.soData = nonFieldObjectData;
    }

    public void unsetSoData() {
        this.soData = null;
    }

    public boolean isSetSoData() {
        return this.soData != null;
    }

    public void setSoDataIsSet(boolean bl) {
        if (!bl) {
            this.soData = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetSoData();
                    break;
                }
                this.setSoData((NonFieldObjectData)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getSoData();
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
                return this.isSetSoData();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof ELOChangeNotification) {
            return this.equals((ELOChangeNotification)object);
        }
        return false;
    }

    public boolean equals(ELOChangeNotification eLOChangeNotification) {
        if (eLOChangeNotification == null) {
            return false;
        }
        if (this == eLOChangeNotification) {
            return true;
        }
        boolean bl = this.isSetSoData();
        boolean bl2 = eLOChangeNotification.isSetSoData();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.soData.equals(eLOChangeNotification.soData)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetSoData() ? 131071 : 524287);
        if (this.isSetSoData()) {
            n = n * 8191 + this.soData.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(ELOChangeNotification eLOChangeNotification) {
        if (!this.getClass().equals(eLOChangeNotification.getClass())) {
            return this.getClass().getName().compareTo(eLOChangeNotification.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetSoData(), eLOChangeNotification.isSetSoData());
        if (n != 0) {
            return n;
        }
        if (this.isSetSoData() && (n = TBaseHelper.compareTo((Comparable)this.soData, (Comparable)eLOChangeNotification.soData)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        ELOChangeNotification.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        ELOChangeNotification.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ELOChangeNotification(");
        boolean bl = true;
        stringBuilder.append("soData:");
        if (this.soData == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.soData);
        }
        bl = false;
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void validate() throws TException {
        if (this.soData != null) {
            this.soData.validate();
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
        enumMap.put(_Fields.SO_DATA, new FieldMetaData("soData", 3, (FieldValueMetaData)new StructMetaData(12, NonFieldObjectData.class)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(ELOChangeNotification.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        SO_DATA(1, "soData");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return SO_DATA;
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

    private static class ELOChangeNotificationStandardSchemeFactory
    implements SchemeFactory {
        private ELOChangeNotificationStandardSchemeFactory() {
        }

        public ELOChangeNotificationStandardScheme getScheme() {
            return new ELOChangeNotificationStandardScheme();
        }
    }

    private static class ELOChangeNotificationTupleSchemeFactory
    implements SchemeFactory {
        private ELOChangeNotificationTupleSchemeFactory() {
        }

        public ELOChangeNotificationTupleScheme getScheme() {
            return new ELOChangeNotificationTupleScheme();
        }
    }

    private static class ELOChangeNotificationTupleScheme
    extends TupleScheme<ELOChangeNotification> {
        private ELOChangeNotificationTupleScheme() {
        }

        public void write(TProtocol tProtocol, ELOChangeNotification eLOChangeNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (eLOChangeNotification.isSetSoData()) {
                bitSet.set(0);
            }
            tTupleProtocol.writeBitSet(bitSet, 1);
            if (eLOChangeNotification.isSetSoData()) {
                eLOChangeNotification.soData.write((TProtocol)tTupleProtocol);
            }
        }

        public void read(TProtocol tProtocol, ELOChangeNotification eLOChangeNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(1);
            if (bitSet.get(0)) {
                eLOChangeNotification.soData = new NonFieldObjectData();
                eLOChangeNotification.soData.read((TProtocol)tTupleProtocol);
                eLOChangeNotification.setSoDataIsSet(true);
            }
        }
    }

    private static class ELOChangeNotificationStandardScheme
    extends StandardScheme<ELOChangeNotification> {
        private ELOChangeNotificationStandardScheme() {
        }

        public void read(TProtocol tProtocol, ELOChangeNotification eLOChangeNotification) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 12) {
                            eLOChangeNotification.soData = new NonFieldObjectData();
                            eLOChangeNotification.soData.read(tProtocol);
                            eLOChangeNotification.setSoDataIsSet(true);
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
            eLOChangeNotification.validate();
        }

        public void write(TProtocol tProtocol, ELOChangeNotification eLOChangeNotification) throws TException {
            eLOChangeNotification.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (eLOChangeNotification.soData != null) {
                tProtocol.writeFieldBegin(SO_DATA_FIELD_DESC);
                eLOChangeNotification.soData.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

