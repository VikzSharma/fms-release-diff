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

public class LogoutNotification
implements TBase<LogoutNotification, _Fields>,
Serializable,
Cloneable,
Comparable<LogoutNotification> {
    private static final TStruct STRUCT_DESC = new TStruct("LogoutNotification");
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new LogoutNotificationStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new LogoutNotificationTupleSchemeFactory();
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public LogoutNotification() {
    }

    public LogoutNotification(LogoutNotification logoutNotification) {
    }

    public LogoutNotification deepCopy() {
        return new LogoutNotification(this);
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
        if (object instanceof LogoutNotification) {
            return this.equals((LogoutNotification)object);
        }
        return false;
    }

    public boolean equals(LogoutNotification logoutNotification) {
        if (logoutNotification == null) {
            return false;
        }
        if (this == logoutNotification) {
            return true;
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        return n;
    }

    @Override
    public int compareTo(LogoutNotification logoutNotification) {
        if (!this.getClass().equals(logoutNotification.getClass())) {
            return this.getClass().getName().compareTo(logoutNotification.getClass().getName());
        }
        boolean bl = false;
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        LogoutNotification.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        LogoutNotification.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("LogoutNotification(");
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
        FieldMetaData.addStructMetaDataMap(LogoutNotification.class, metaDataMap);
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

    private static class LogoutNotificationStandardSchemeFactory
    implements SchemeFactory {
        private LogoutNotificationStandardSchemeFactory() {
        }

        public LogoutNotificationStandardScheme getScheme() {
            return new LogoutNotificationStandardScheme();
        }
    }

    private static class LogoutNotificationTupleSchemeFactory
    implements SchemeFactory {
        private LogoutNotificationTupleSchemeFactory() {
        }

        public LogoutNotificationTupleScheme getScheme() {
            return new LogoutNotificationTupleScheme();
        }
    }

    private static class LogoutNotificationTupleScheme
    extends TupleScheme<LogoutNotification> {
        private LogoutNotificationTupleScheme() {
        }

        public void write(TProtocol tProtocol, LogoutNotification logoutNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
        }

        public void read(TProtocol tProtocol, LogoutNotification logoutNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
        }
    }

    private static class LogoutNotificationStandardScheme
    extends StandardScheme<LogoutNotification> {
        private LogoutNotificationStandardScheme() {
        }

        public void read(TProtocol tProtocol, LogoutNotification logoutNotification) throws TException {
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
            logoutNotification.validate();
        }

        public void write(TProtocol tProtocol, LogoutNotification logoutNotification) throws TException {
            logoutNotification.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

