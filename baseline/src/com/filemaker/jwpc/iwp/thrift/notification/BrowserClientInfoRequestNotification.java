/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.thrift.TBase
 *  org.apache.thrift.TBaseHelper
 *  org.apache.thrift.TException
 *  org.apache.thrift.TFieldIdEnum
 *  org.apache.thrift.annotation.Nullable
 *  org.apache.thrift.meta_data.EnumMetaData
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

import com.filemaker.jwpc.iwp.thrift.common.BrowserClientInfoParameter;
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
import org.apache.thrift.meta_data.EnumMetaData;
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

public class BrowserClientInfoRequestNotification
implements TBase<BrowserClientInfoRequestNotification, _Fields>,
Serializable,
Cloneable,
Comparable<BrowserClientInfoRequestNotification> {
    private static final TStruct STRUCT_DESC = new TStruct("BrowserClientInfoRequestNotification");
    private static final TField PARAMETER_FIELD_DESC = new TField("parameter", 8, 1);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new BrowserClientInfoRequestNotificationStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new BrowserClientInfoRequestNotificationTupleSchemeFactory();
    @Nullable
    private BrowserClientInfoParameter parameter;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public BrowserClientInfoRequestNotification() {
    }

    public BrowserClientInfoRequestNotification(BrowserClientInfoParameter browserClientInfoParameter) {
        this();
        this.parameter = browserClientInfoParameter;
    }

    public BrowserClientInfoRequestNotification(BrowserClientInfoRequestNotification browserClientInfoRequestNotification) {
        if (browserClientInfoRequestNotification.isSetParameter()) {
            this.parameter = browserClientInfoRequestNotification.parameter;
        }
    }

    public BrowserClientInfoRequestNotification deepCopy() {
        return new BrowserClientInfoRequestNotification(this);
    }

    public void clear() {
        this.parameter = null;
    }

    @Nullable
    public BrowserClientInfoParameter getParameter() {
        return this.parameter;
    }

    public void setParameter(@Nullable BrowserClientInfoParameter browserClientInfoParameter) {
        this.parameter = browserClientInfoParameter;
    }

    public void unsetParameter() {
        this.parameter = null;
    }

    public boolean isSetParameter() {
        return this.parameter != null;
    }

    public void setParameterIsSet(boolean bl) {
        if (!bl) {
            this.parameter = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetParameter();
                    break;
                }
                this.setParameter((BrowserClientInfoParameter)((Object)object));
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getParameter();
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
                return this.isSetParameter();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof BrowserClientInfoRequestNotification) {
            return this.equals((BrowserClientInfoRequestNotification)object);
        }
        return false;
    }

    public boolean equals(BrowserClientInfoRequestNotification browserClientInfoRequestNotification) {
        if (browserClientInfoRequestNotification == null) {
            return false;
        }
        if (this == browserClientInfoRequestNotification) {
            return true;
        }
        boolean bl = this.isSetParameter();
        boolean bl2 = browserClientInfoRequestNotification.isSetParameter();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.parameter.equals((Object)browserClientInfoRequestNotification.parameter)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetParameter() ? 131071 : 524287);
        if (this.isSetParameter()) {
            n = n * 8191 + this.parameter.getValue();
        }
        return n;
    }

    @Override
    public int compareTo(BrowserClientInfoRequestNotification browserClientInfoRequestNotification) {
        if (!this.getClass().equals(browserClientInfoRequestNotification.getClass())) {
            return this.getClass().getName().compareTo(browserClientInfoRequestNotification.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetParameter(), browserClientInfoRequestNotification.isSetParameter());
        if (n != 0) {
            return n;
        }
        if (this.isSetParameter() && (n = TBaseHelper.compareTo((Comparable)((Object)this.parameter), (Comparable)((Object)browserClientInfoRequestNotification.parameter))) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        BrowserClientInfoRequestNotification.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        BrowserClientInfoRequestNotification.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("BrowserClientInfoRequestNotification(");
        boolean bl = true;
        stringBuilder.append("parameter:");
        if (this.parameter == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append((Object)this.parameter);
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
        enumMap.put(_Fields.PARAMETER, new FieldMetaData("parameter", 3, (FieldValueMetaData)new EnumMetaData(-1, BrowserClientInfoParameter.class)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(BrowserClientInfoRequestNotification.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        PARAMETER(1, "parameter");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return PARAMETER;
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

    private static class BrowserClientInfoRequestNotificationStandardSchemeFactory
    implements SchemeFactory {
        private BrowserClientInfoRequestNotificationStandardSchemeFactory() {
        }

        public BrowserClientInfoRequestNotificationStandardScheme getScheme() {
            return new BrowserClientInfoRequestNotificationStandardScheme();
        }
    }

    private static class BrowserClientInfoRequestNotificationTupleSchemeFactory
    implements SchemeFactory {
        private BrowserClientInfoRequestNotificationTupleSchemeFactory() {
        }

        public BrowserClientInfoRequestNotificationTupleScheme getScheme() {
            return new BrowserClientInfoRequestNotificationTupleScheme();
        }
    }

    private static class BrowserClientInfoRequestNotificationTupleScheme
    extends TupleScheme<BrowserClientInfoRequestNotification> {
        private BrowserClientInfoRequestNotificationTupleScheme() {
        }

        public void write(TProtocol tProtocol, BrowserClientInfoRequestNotification browserClientInfoRequestNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (browserClientInfoRequestNotification.isSetParameter()) {
                bitSet.set(0);
            }
            tTupleProtocol.writeBitSet(bitSet, 1);
            if (browserClientInfoRequestNotification.isSetParameter()) {
                tTupleProtocol.writeI32(browserClientInfoRequestNotification.parameter.getValue());
            }
        }

        public void read(TProtocol tProtocol, BrowserClientInfoRequestNotification browserClientInfoRequestNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(1);
            if (bitSet.get(0)) {
                browserClientInfoRequestNotification.parameter = BrowserClientInfoParameter.findByValue(tTupleProtocol.readI32());
                browserClientInfoRequestNotification.setParameterIsSet(true);
            }
        }
    }

    private static class BrowserClientInfoRequestNotificationStandardScheme
    extends StandardScheme<BrowserClientInfoRequestNotification> {
        private BrowserClientInfoRequestNotificationStandardScheme() {
        }

        public void read(TProtocol tProtocol, BrowserClientInfoRequestNotification browserClientInfoRequestNotification) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 8) {
                            browserClientInfoRequestNotification.parameter = BrowserClientInfoParameter.findByValue(tProtocol.readI32());
                            browserClientInfoRequestNotification.setParameterIsSet(true);
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
            browserClientInfoRequestNotification.validate();
        }

        public void write(TProtocol tProtocol, BrowserClientInfoRequestNotification browserClientInfoRequestNotification) throws TException {
            browserClientInfoRequestNotification.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (browserClientInfoRequestNotification.parameter != null) {
                tProtocol.writeFieldBegin(PARAMETER_FIELD_DESC);
                tProtocol.writeI32(browserClientInfoRequestNotification.parameter.getValue());
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

