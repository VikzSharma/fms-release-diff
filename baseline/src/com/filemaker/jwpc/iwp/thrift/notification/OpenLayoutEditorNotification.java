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

public class OpenLayoutEditorNotification
implements TBase<OpenLayoutEditorNotification, _Fields>,
Serializable,
Cloneable,
Comparable<OpenLayoutEditorNotification> {
    private static final TStruct STRUCT_DESC = new TStruct("OpenLayoutEditorNotification");
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new OpenLayoutEditorNotificationStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new OpenLayoutEditorNotificationTupleSchemeFactory();
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public OpenLayoutEditorNotification() {
    }

    public OpenLayoutEditorNotification(OpenLayoutEditorNotification openLayoutEditorNotification) {
    }

    public OpenLayoutEditorNotification deepCopy() {
        return new OpenLayoutEditorNotification(this);
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
        if (object instanceof OpenLayoutEditorNotification) {
            return this.equals((OpenLayoutEditorNotification)object);
        }
        return false;
    }

    public boolean equals(OpenLayoutEditorNotification openLayoutEditorNotification) {
        if (openLayoutEditorNotification == null) {
            return false;
        }
        if (this == openLayoutEditorNotification) {
            return true;
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        return n;
    }

    @Override
    public int compareTo(OpenLayoutEditorNotification openLayoutEditorNotification) {
        if (!this.getClass().equals(openLayoutEditorNotification.getClass())) {
            return this.getClass().getName().compareTo(openLayoutEditorNotification.getClass().getName());
        }
        boolean bl = false;
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        OpenLayoutEditorNotification.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        OpenLayoutEditorNotification.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("OpenLayoutEditorNotification(");
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
        FieldMetaData.addStructMetaDataMap(OpenLayoutEditorNotification.class, metaDataMap);
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

    private static class OpenLayoutEditorNotificationStandardSchemeFactory
    implements SchemeFactory {
        private OpenLayoutEditorNotificationStandardSchemeFactory() {
        }

        public OpenLayoutEditorNotificationStandardScheme getScheme() {
            return new OpenLayoutEditorNotificationStandardScheme();
        }
    }

    private static class OpenLayoutEditorNotificationTupleSchemeFactory
    implements SchemeFactory {
        private OpenLayoutEditorNotificationTupleSchemeFactory() {
        }

        public OpenLayoutEditorNotificationTupleScheme getScheme() {
            return new OpenLayoutEditorNotificationTupleScheme();
        }
    }

    private static class OpenLayoutEditorNotificationTupleScheme
    extends TupleScheme<OpenLayoutEditorNotification> {
        private OpenLayoutEditorNotificationTupleScheme() {
        }

        public void write(TProtocol tProtocol, OpenLayoutEditorNotification openLayoutEditorNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
        }

        public void read(TProtocol tProtocol, OpenLayoutEditorNotification openLayoutEditorNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
        }
    }

    private static class OpenLayoutEditorNotificationStandardScheme
    extends StandardScheme<OpenLayoutEditorNotification> {
        private OpenLayoutEditorNotificationStandardScheme() {
        }

        public void read(TProtocol tProtocol, OpenLayoutEditorNotification openLayoutEditorNotification) throws TException {
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
            openLayoutEditorNotification.validate();
        }

        public void write(TProtocol tProtocol, OpenLayoutEditorNotification openLayoutEditorNotification) throws TException {
            openLayoutEditorNotification.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

