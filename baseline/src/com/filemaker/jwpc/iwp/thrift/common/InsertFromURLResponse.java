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
package com.filemaker.jwpc.iwp.thrift.common;

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

public class InsertFromURLResponse
implements TBase<InsertFromURLResponse, _Fields>,
Serializable,
Cloneable,
Comparable<InsertFromURLResponse> {
    private static final TStruct STRUCT_DESC = new TStruct("InsertFromURLResponse");
    private static final TField CONFIRM_FIELD_DESC = new TField("confirm", 2, 1);
    private static final TField URL_FIELD_DESC = new TField("url", 11, 2);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new InsertFromURLResponseStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new InsertFromURLResponseTupleSchemeFactory();
    private boolean confirm;
    @Nullable
    private String url;
    private static final int __CONFIRM_ISSET_ID = 0;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public InsertFromURLResponse() {
    }

    public InsertFromURLResponse(boolean bl, String string) {
        this();
        this.confirm = bl;
        this.setConfirmIsSet(true);
        this.url = string;
    }

    public InsertFromURLResponse(InsertFromURLResponse insertFromURLResponse) {
        this.__isset_bitfield = insertFromURLResponse.__isset_bitfield;
        this.confirm = insertFromURLResponse.confirm;
        if (insertFromURLResponse.isSetUrl()) {
            this.url = insertFromURLResponse.url;
        }
    }

    public InsertFromURLResponse deepCopy() {
        return new InsertFromURLResponse(this);
    }

    public void clear() {
        this.setConfirmIsSet(false);
        this.confirm = false;
        this.url = null;
    }

    public boolean isConfirm() {
        return this.confirm;
    }

    public void setConfirm(boolean bl) {
        this.confirm = bl;
        this.setConfirmIsSet(true);
    }

    public void unsetConfirm() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetConfirm() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setConfirmIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
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
                    this.unsetConfirm();
                    break;
                }
                this.setConfirm((Boolean)object);
                break;
            }
            case 1: {
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
                return this.isConfirm();
            }
            case 1: {
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
                return this.isSetConfirm();
            }
            case 1: {
                return this.isSetUrl();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof InsertFromURLResponse) {
            return this.equals((InsertFromURLResponse)object);
        }
        return false;
    }

    public boolean equals(InsertFromURLResponse insertFromURLResponse) {
        if (insertFromURLResponse == null) {
            return false;
        }
        if (this == insertFromURLResponse) {
            return true;
        }
        boolean bl = true;
        boolean bl2 = true;
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (this.confirm != insertFromURLResponse.confirm) {
                return false;
            }
        }
        boolean bl3 = this.isSetUrl();
        boolean bl4 = insertFromURLResponse.isSetUrl();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.url.equals(insertFromURLResponse.url)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.confirm ? 131071 : 524287);
        n = n * 8191 + (this.isSetUrl() ? 131071 : 524287);
        if (this.isSetUrl()) {
            n = n * 8191 + this.url.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(InsertFromURLResponse insertFromURLResponse) {
        if (!this.getClass().equals(insertFromURLResponse.getClass())) {
            return this.getClass().getName().compareTo(insertFromURLResponse.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetConfirm(), insertFromURLResponse.isSetConfirm());
        if (n != 0) {
            return n;
        }
        if (this.isSetConfirm() && (n = TBaseHelper.compareTo((boolean)this.confirm, (boolean)insertFromURLResponse.confirm)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetUrl(), insertFromURLResponse.isSetUrl());
        if (n != 0) {
            return n;
        }
        if (this.isSetUrl() && (n = TBaseHelper.compareTo((String)this.url, (String)insertFromURLResponse.url)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        InsertFromURLResponse.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        InsertFromURLResponse.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("InsertFromURLResponse(");
        boolean bl = true;
        stringBuilder.append("confirm:");
        stringBuilder.append(this.confirm);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
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
        enumMap.put(_Fields.CONFIRM, new FieldMetaData("confirm", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.URL, new FieldMetaData("url", 3, new FieldValueMetaData(11)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(InsertFromURLResponse.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        CONFIRM(1, "confirm"),
        URL(2, "url");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return CONFIRM;
                }
                case 2: {
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

    private static class InsertFromURLResponseStandardSchemeFactory
    implements SchemeFactory {
        private InsertFromURLResponseStandardSchemeFactory() {
        }

        public InsertFromURLResponseStandardScheme getScheme() {
            return new InsertFromURLResponseStandardScheme();
        }
    }

    private static class InsertFromURLResponseTupleSchemeFactory
    implements SchemeFactory {
        private InsertFromURLResponseTupleSchemeFactory() {
        }

        public InsertFromURLResponseTupleScheme getScheme() {
            return new InsertFromURLResponseTupleScheme();
        }
    }

    private static class InsertFromURLResponseTupleScheme
    extends TupleScheme<InsertFromURLResponse> {
        private InsertFromURLResponseTupleScheme() {
        }

        public void write(TProtocol tProtocol, InsertFromURLResponse insertFromURLResponse) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (insertFromURLResponse.isSetConfirm()) {
                bitSet.set(0);
            }
            if (insertFromURLResponse.isSetUrl()) {
                bitSet.set(1);
            }
            tTupleProtocol.writeBitSet(bitSet, 2);
            if (insertFromURLResponse.isSetConfirm()) {
                tTupleProtocol.writeBool(insertFromURLResponse.confirm);
            }
            if (insertFromURLResponse.isSetUrl()) {
                tTupleProtocol.writeString(insertFromURLResponse.url);
            }
        }

        public void read(TProtocol tProtocol, InsertFromURLResponse insertFromURLResponse) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(2);
            if (bitSet.get(0)) {
                insertFromURLResponse.confirm = tTupleProtocol.readBool();
                insertFromURLResponse.setConfirmIsSet(true);
            }
            if (bitSet.get(1)) {
                insertFromURLResponse.url = tTupleProtocol.readString();
                insertFromURLResponse.setUrlIsSet(true);
            }
        }
    }

    private static class InsertFromURLResponseStandardScheme
    extends StandardScheme<InsertFromURLResponse> {
        private InsertFromURLResponseStandardScheme() {
        }

        public void read(TProtocol tProtocol, InsertFromURLResponse insertFromURLResponse) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 2) {
                            insertFromURLResponse.confirm = tProtocol.readBool();
                            insertFromURLResponse.setConfirmIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 11) {
                            insertFromURLResponse.url = tProtocol.readString();
                            insertFromURLResponse.setUrlIsSet(true);
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
            insertFromURLResponse.validate();
        }

        public void write(TProtocol tProtocol, InsertFromURLResponse insertFromURLResponse) throws TException {
            insertFromURLResponse.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            tProtocol.writeFieldBegin(CONFIRM_FIELD_DESC);
            tProtocol.writeBool(insertFromURLResponse.confirm);
            tProtocol.writeFieldEnd();
            if (insertFromURLResponse.url != null) {
                tProtocol.writeFieldBegin(URL_FIELD_DESC);
                tProtocol.writeString(insertFromURLResponse.url);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

