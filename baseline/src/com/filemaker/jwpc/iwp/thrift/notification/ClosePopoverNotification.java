/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.thrift.TBase
 *  org.apache.thrift.TException
 *  org.apache.thrift.TFieldIdEnum
 *  org.apache.thrift.annotation.Nullable
 *  org.apache.thrift.meta_data.FieldMetaData
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
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import org.apache.thrift.TBase;
import org.apache.thrift.TException;
import org.apache.thrift.TFieldIdEnum;
import org.apache.thrift.annotation.Nullable;
import org.apache.thrift.meta_data.FieldMetaData;
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

public class ClosePopoverNotification
implements TBase<ClosePopoverNotification, _Fields>,
Serializable,
Cloneable,
Comparable<ClosePopoverNotification> {
    private static final TStruct STRUCT_DESC = new TStruct("ClosePopoverNotification");
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new ClosePopoverNotificationStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new ClosePopoverNotificationTupleSchemeFactory();
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public ClosePopoverNotification() {
    }

    public ClosePopoverNotification(ClosePopoverNotification closePopoverNotification) {
    }

    public ClosePopoverNotification deepCopy() {
        return new ClosePopoverNotification(this);
    }

    public void clear() {
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        _Fields2.ordinal();
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        _Fields2.ordinal();
        throw new IllegalStateException();
    }

    public boolean isSet(_Fields _Fields2) {
        if (_Fields2 == null) {
            throw new IllegalArgumentException();
        }
        _Fields2.ordinal();
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof ClosePopoverNotification) {
            return this.equals((ClosePopoverNotification)object);
        }
        return false;
    }

    public boolean equals(ClosePopoverNotification closePopoverNotification) {
        if (closePopoverNotification == null) {
            return false;
        }
        if (this == closePopoverNotification) {
            return true;
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        return n;
    }

    @Override
    public int compareTo(ClosePopoverNotification closePopoverNotification) {
        if (!this.getClass().equals(closePopoverNotification.getClass())) {
            return this.getClass().getName().compareTo(closePopoverNotification.getClass().getName());
        }
        boolean bl = false;
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        ClosePopoverNotification.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        ClosePopoverNotification.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ClosePopoverNotification(");
        boolean bl = true;
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
        EnumMap enumMap = new EnumMap(_Fields.class);
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(ClosePopoverNotification.class, metaDataMap);
    }

    public static final class _Fields
    extends Enum<_Fields>
    implements TFieldIdEnum {
        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;
        private static final /* synthetic */ _Fields[] $VALUES;

        public static _Fields[] values() {
            return (_Fields[])$VALUES.clone();
        }

        public static _Fields valueOf(String string) {
            return Enum.valueOf(_Fields.class, string);
        }

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                default: 
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

        private static /* synthetic */ _Fields[] $values() {
            return new _Fields[0];
        }

        static {
            $VALUES = _Fields.$values();
            byName = new HashMap<String, _Fields>();
            for (_Fields _Fields2 : EnumSet.allOf(_Fields.class)) {
                byName.put(_Fields2.getFieldName(), _Fields2);
            }
        }
    }

    private static class ClosePopoverNotificationStandardSchemeFactory
    implements SchemeFactory {
        private ClosePopoverNotificationStandardSchemeFactory() {
        }

        public ClosePopoverNotificationStandardScheme getScheme() {
            return new ClosePopoverNotificationStandardScheme();
        }
    }

    private static class ClosePopoverNotificationTupleSchemeFactory
    implements SchemeFactory {
        private ClosePopoverNotificationTupleSchemeFactory() {
        }

        public ClosePopoverNotificationTupleScheme getScheme() {
            return new ClosePopoverNotificationTupleScheme();
        }
    }

    private static class ClosePopoverNotificationTupleScheme
    extends TupleScheme<ClosePopoverNotification> {
        private ClosePopoverNotificationTupleScheme() {
        }

        public void write(TProtocol tProtocol, ClosePopoverNotification closePopoverNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
        }

        public void read(TProtocol tProtocol, ClosePopoverNotification closePopoverNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
        }
    }

    private static class ClosePopoverNotificationStandardScheme
    extends StandardScheme<ClosePopoverNotification> {
        private ClosePopoverNotificationStandardScheme() {
        }

        public void read(TProtocol tProtocol, ClosePopoverNotification closePopoverNotification) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    default: 
                }
                TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                tProtocol.readFieldEnd();
            }
            tProtocol.readStructEnd();
            closePopoverNotification.validate();
        }

        public void write(TProtocol tProtocol, ClosePopoverNotification closePopoverNotification) throws TException {
            closePopoverNotification.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

