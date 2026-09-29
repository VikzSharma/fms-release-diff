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

public class InsertFromURLNotification
implements TBase<InsertFromURLNotification, _Fields>,
Serializable,
Cloneable,
Comparable<InsertFromURLNotification> {
    private static final TStruct STRUCT_DESC = new TStruct("InsertFromURLNotification");
    private static final TField URL_FIELD_DESC = new TField("url", 11, 1);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new InsertFromURLNotificationStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new InsertFromURLNotificationTupleSchemeFactory();
    @Nullable
    private String url;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public InsertFromURLNotification() {
    }

    public InsertFromURLNotification(String string) {
        this();
        this.url = string;
    }

    public InsertFromURLNotification(InsertFromURLNotification insertFromURLNotification) {
        if (insertFromURLNotification.isSetUrl()) {
            this.url = insertFromURLNotification.url;
        }
    }

    public InsertFromURLNotification deepCopy() {
        return new InsertFromURLNotification(this);
    }

    public void clear() {
        this.url = null;
    }

    @Nullable
    public String getUrl() {
        return this.url;
    }

    public void setUrl(@Nullable String string) {
        this.url = string;
    }

    public void unsetUrl() {
        this.url = null;
    }

    public boolean isSetUrl() {
        return this.url != null;
    }

    public void setUrlIsSet(boolean bl) {
        if (!bl) {
            this.url = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetUrl();
                    break;
                }
                this.setUrl((String)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getUrl();
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
                return this.isSetUrl();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof InsertFromURLNotification) {
            return this.equals((InsertFromURLNotification)object);
        }
        return false;
    }

    public boolean equals(InsertFromURLNotification insertFromURLNotification) {
        if (insertFromURLNotification == null) {
            return false;
        }
        if (this == insertFromURLNotification) {
            return true;
        }
        boolean bl = this.isSetUrl();
        boolean bl2 = insertFromURLNotification.isSetUrl();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.url.equals(insertFromURLNotification.url)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetUrl() ? 131071 : 524287);
        if (this.isSetUrl()) {
            n = n * 8191 + this.url.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(InsertFromURLNotification insertFromURLNotification) {
        if (!this.getClass().equals(insertFromURLNotification.getClass())) {
            return this.getClass().getName().compareTo(insertFromURLNotification.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetUrl(), insertFromURLNotification.isSetUrl());
        if (n != 0) {
            return n;
        }
        if (this.isSetUrl() && (n = TBaseHelper.compareTo((String)this.url, (String)insertFromURLNotification.url)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        InsertFromURLNotification.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        InsertFromURLNotification.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("InsertFromURLNotification(");
        boolean bl = true;
        stringBuilder.append("url:");
        if (this.url == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.url);
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
        enumMap.put(_Fields.URL, new FieldMetaData("url", 3, new FieldValueMetaData(11)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(InsertFromURLNotification.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        URL(1, "url");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return URL;
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

    private static class InsertFromURLNotificationStandardSchemeFactory
    implements SchemeFactory {
        private InsertFromURLNotificationStandardSchemeFactory() {
        }

        public InsertFromURLNotificationStandardScheme getScheme() {
            return new InsertFromURLNotificationStandardScheme();
        }
    }

    private static class InsertFromURLNotificationTupleSchemeFactory
    implements SchemeFactory {
        private InsertFromURLNotificationTupleSchemeFactory() {
        }

        public InsertFromURLNotificationTupleScheme getScheme() {
            return new InsertFromURLNotificationTupleScheme();
        }
    }

    private static class InsertFromURLNotificationTupleScheme
    extends TupleScheme<InsertFromURLNotification> {
        private InsertFromURLNotificationTupleScheme() {
        }

        public void write(TProtocol tProtocol, InsertFromURLNotification insertFromURLNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (insertFromURLNotification.isSetUrl()) {
                bitSet.set(0);
            }
            tTupleProtocol.writeBitSet(bitSet, 1);
            if (insertFromURLNotification.isSetUrl()) {
                tTupleProtocol.writeString(insertFromURLNotification.url);
            }
        }

        public void read(TProtocol tProtocol, InsertFromURLNotification insertFromURLNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(1);
            if (bitSet.get(0)) {
                insertFromURLNotification.url = tTupleProtocol.readString();
                insertFromURLNotification.setUrlIsSet(true);
            }
        }
    }

    private static class InsertFromURLNotificationStandardScheme
    extends StandardScheme<InsertFromURLNotification> {
        private InsertFromURLNotificationStandardScheme() {
        }

        public void read(TProtocol tProtocol, InsertFromURLNotification insertFromURLNotification) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 11) {
                            insertFromURLNotification.url = tProtocol.readString();
                            insertFromURLNotification.setUrlIsSet(true);
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
            insertFromURLNotification.validate();
        }

        public void write(TProtocol tProtocol, InsertFromURLNotification insertFromURLNotification) throws TException {
            insertFromURLNotification.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (insertFromURLNotification.url != null) {
                tProtocol.writeFieldBegin(URL_FIELD_DESC);
                tProtocol.writeString(insertFromURLNotification.url);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

