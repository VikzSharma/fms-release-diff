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
 *  org.apache.thrift.protocol.TProtocolException
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
package com.filemaker.jwpc.iwp.thrift.auth;

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
import org.apache.thrift.TBaseHelper;
import org.apache.thrift.TException;
import org.apache.thrift.TFieldIdEnum;
import org.apache.thrift.annotation.Nullable;
import org.apache.thrift.meta_data.FieldMetaData;
import org.apache.thrift.meta_data.FieldValueMetaData;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.protocol.TProtocolUtil;
import org.apache.thrift.protocol.TStruct;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;
import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.transport.TIOStreamTransport;
import org.apache.thrift.transport.TTransport;

public class Auth
implements TBase<Auth, _Fields>,
Serializable,
Cloneable,
Comparable<Auth> {
    private static final TStruct STRUCT_DESC = new TStruct("Auth");
    private static final TField NAME_FIELD_DESC = new TField("name", 11, 1);
    private static final TField PASSWORD_FIELD_DESC = new TField("password", 11, 2);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new AuthStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new AuthTupleSchemeFactory();
    @Nullable
    private String name;
    @Nullable
    private String password;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public Auth() {
    }

    public Auth(String string, String string2) {
        this();
        this.name = string;
        this.password = string2;
    }

    public Auth(Auth auth) {
        if (auth.isSetName()) {
            this.name = auth.name;
        }
        if (auth.isSetPassword()) {
            this.password = auth.password;
        }
    }

    public Auth deepCopy() {
        return new Auth(this);
    }

    public void clear() {
        this.name = null;
        this.password = null;
    }

    @Nullable
    public String getName() {
        return this.name;
    }

    public void setName(@Nullable String string) {
        this.name = string;
    }

    public void unsetName() {
        this.name = null;
    }

    public boolean isSetName() {
        return this.name != null;
    }

    public void setNameIsSet(boolean bl) {
        if (!bl) {
            this.name = null;
        }
    }

    @Nullable
    public String getPassword() {
        return this.password;
    }

    public void setPassword(@Nullable String string) {
        this.password = string;
    }

    public void unsetPassword() {
        this.password = null;
    }

    public boolean isSetPassword() {
        return this.password != null;
    }

    public void setPasswordIsSet(boolean bl) {
        if (!bl) {
            this.password = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetName();
                    break;
                }
                this.setName((String)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetPassword();
                    break;
                }
                this.setPassword((String)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getName();
            }
            case 1: {
                return this.getPassword();
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
                return this.isSetName();
            }
            case 1: {
                return this.isSetPassword();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof Auth) {
            return this.equals((Auth)object);
        }
        return false;
    }

    public boolean equals(Auth auth) {
        if (auth == null) {
            return false;
        }
        if (this == auth) {
            return true;
        }
        boolean bl = this.isSetName();
        boolean bl2 = auth.isSetName();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.name.equals(auth.name)) {
                return false;
            }
        }
        boolean bl3 = this.isSetPassword();
        boolean bl4 = auth.isSetPassword();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.password.equals(auth.password)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetName() ? 131071 : 524287);
        if (this.isSetName()) {
            n = n * 8191 + this.name.hashCode();
        }
        n = n * 8191 + (this.isSetPassword() ? 131071 : 524287);
        if (this.isSetPassword()) {
            n = n * 8191 + this.password.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(Auth auth) {
        if (!this.getClass().equals(auth.getClass())) {
            return this.getClass().getName().compareTo(auth.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetName(), auth.isSetName());
        if (n != 0) {
            return n;
        }
        if (this.isSetName() && (n = TBaseHelper.compareTo((String)this.name, (String)auth.name)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetPassword(), auth.isSetPassword());
        if (n != 0) {
            return n;
        }
        if (this.isSetPassword() && (n = TBaseHelper.compareTo((String)this.password, (String)auth.password)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        Auth.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        Auth.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Auth(");
        boolean bl = true;
        stringBuilder.append("name:");
        if (this.name == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.name);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("password:");
        if (this.password == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.password);
        }
        bl = false;
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void validate() throws TException {
        if (!this.isSetName()) {
            throw new TProtocolException("Required field 'name' is unset! Struct:" + this.toString());
        }
        if (!this.isSetPassword()) {
            throw new TProtocolException("Required field 'password' is unset! Struct:" + this.toString());
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
        enumMap.put(_Fields.NAME, new FieldMetaData("name", 1, new FieldValueMetaData(11)));
        enumMap.put(_Fields.PASSWORD, new FieldMetaData("password", 1, new FieldValueMetaData(11)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(Auth.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        NAME(1, "name"),
        PASSWORD(2, "password");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return NAME;
                }
                case 2: {
                    return PASSWORD;
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

    private static class AuthStandardSchemeFactory
    implements SchemeFactory {
        private AuthStandardSchemeFactory() {
        }

        public AuthStandardScheme getScheme() {
            return new AuthStandardScheme();
        }
    }

    private static class AuthTupleSchemeFactory
    implements SchemeFactory {
        private AuthTupleSchemeFactory() {
        }

        public AuthTupleScheme getScheme() {
            return new AuthTupleScheme();
        }
    }

    private static class AuthTupleScheme
    extends TupleScheme<Auth> {
        private AuthTupleScheme() {
        }

        public void write(TProtocol tProtocol, Auth auth) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            tTupleProtocol.writeString(auth.name);
            tTupleProtocol.writeString(auth.password);
        }

        public void read(TProtocol tProtocol, Auth auth) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            auth.name = tTupleProtocol.readString();
            auth.setNameIsSet(true);
            auth.password = tTupleProtocol.readString();
            auth.setPasswordIsSet(true);
        }
    }

    private static class AuthStandardScheme
    extends StandardScheme<Auth> {
        private AuthStandardScheme() {
        }

        public void read(TProtocol tProtocol, Auth auth) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 11) {
                            auth.name = tProtocol.readString();
                            auth.setNameIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 11) {
                            auth.password = tProtocol.readString();
                            auth.setPasswordIsSet(true);
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
            auth.validate();
        }

        public void write(TProtocol tProtocol, Auth auth) throws TException {
            auth.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (auth.name != null) {
                tProtocol.writeFieldBegin(NAME_FIELD_DESC);
                tProtocol.writeString(auth.name);
                tProtocol.writeFieldEnd();
            }
            if (auth.password != null) {
                tProtocol.writeFieldBegin(PASSWORD_FIELD_DESC);
                tProtocol.writeString(auth.password);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

