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

import com.filemaker.jwpc.iwp.thrift.common.UserPrivileges;
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

public class PrivilegesNotification
implements TBase<PrivilegesNotification, _Fields>,
Serializable,
Cloneable,
Comparable<PrivilegesNotification> {
    private static final TStruct STRUCT_DESC = new TStruct("PrivilegesNotification");
    private static final TField PRIVS_FIELD_DESC = new TField("privs", 12, 1);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new PrivilegesNotificationStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new PrivilegesNotificationTupleSchemeFactory();
    @Nullable
    private UserPrivileges privs;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public PrivilegesNotification() {
    }

    public PrivilegesNotification(UserPrivileges userPrivileges) {
        this();
        this.privs = userPrivileges;
    }

    public PrivilegesNotification(PrivilegesNotification privilegesNotification) {
        if (privilegesNotification.isSetPrivs()) {
            this.privs = new UserPrivileges(privilegesNotification.privs);
        }
    }

    public PrivilegesNotification deepCopy() {
        return new PrivilegesNotification(this);
    }

    public void clear() {
        this.privs = null;
    }

    @Nullable
    public UserPrivileges getPrivs() {
        return this.privs;
    }

    public void setPrivs(@Nullable UserPrivileges userPrivileges) {
        this.privs = userPrivileges;
    }

    public void unsetPrivs() {
        this.privs = null;
    }

    public boolean isSetPrivs() {
        return this.privs != null;
    }

    public void setPrivsIsSet(boolean bl) {
        if (!bl) {
            this.privs = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetPrivs();
                    break;
                }
                this.setPrivs((UserPrivileges)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getPrivs();
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
                return this.isSetPrivs();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof PrivilegesNotification) {
            return this.equals((PrivilegesNotification)object);
        }
        return false;
    }

    public boolean equals(PrivilegesNotification privilegesNotification) {
        if (privilegesNotification == null) {
            return false;
        }
        if (this == privilegesNotification) {
            return true;
        }
        boolean bl = this.isSetPrivs();
        boolean bl2 = privilegesNotification.isSetPrivs();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.privs.equals(privilegesNotification.privs)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetPrivs() ? 131071 : 524287);
        if (this.isSetPrivs()) {
            n = n * 8191 + this.privs.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(PrivilegesNotification privilegesNotification) {
        if (!this.getClass().equals(privilegesNotification.getClass())) {
            return this.getClass().getName().compareTo(privilegesNotification.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetPrivs(), privilegesNotification.isSetPrivs());
        if (n != 0) {
            return n;
        }
        if (this.isSetPrivs() && (n = TBaseHelper.compareTo((Comparable)this.privs, (Comparable)privilegesNotification.privs)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        PrivilegesNotification.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        PrivilegesNotification.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("PrivilegesNotification(");
        boolean bl = true;
        stringBuilder.append("privs:");
        if (this.privs == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.privs);
        }
        bl = false;
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void validate() throws TException {
        if (this.privs != null) {
            this.privs.validate();
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
        enumMap.put(_Fields.PRIVS, new FieldMetaData("privs", 3, (FieldValueMetaData)new StructMetaData(12, UserPrivileges.class)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(PrivilegesNotification.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        PRIVS(1, "privs");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return PRIVS;
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

    private static class PrivilegesNotificationStandardSchemeFactory
    implements SchemeFactory {
        private PrivilegesNotificationStandardSchemeFactory() {
        }

        public PrivilegesNotificationStandardScheme getScheme() {
            return new PrivilegesNotificationStandardScheme();
        }
    }

    private static class PrivilegesNotificationTupleSchemeFactory
    implements SchemeFactory {
        private PrivilegesNotificationTupleSchemeFactory() {
        }

        public PrivilegesNotificationTupleScheme getScheme() {
            return new PrivilegesNotificationTupleScheme();
        }
    }

    private static class PrivilegesNotificationTupleScheme
    extends TupleScheme<PrivilegesNotification> {
        private PrivilegesNotificationTupleScheme() {
        }

        public void write(TProtocol tProtocol, PrivilegesNotification privilegesNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (privilegesNotification.isSetPrivs()) {
                bitSet.set(0);
            }
            tTupleProtocol.writeBitSet(bitSet, 1);
            if (privilegesNotification.isSetPrivs()) {
                privilegesNotification.privs.write((TProtocol)tTupleProtocol);
            }
        }

        public void read(TProtocol tProtocol, PrivilegesNotification privilegesNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(1);
            if (bitSet.get(0)) {
                privilegesNotification.privs = new UserPrivileges();
                privilegesNotification.privs.read((TProtocol)tTupleProtocol);
                privilegesNotification.setPrivsIsSet(true);
            }
        }
    }

    private static class PrivilegesNotificationStandardScheme
    extends StandardScheme<PrivilegesNotification> {
        private PrivilegesNotificationStandardScheme() {
        }

        public void read(TProtocol tProtocol, PrivilegesNotification privilegesNotification) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 12) {
                            privilegesNotification.privs = new UserPrivileges();
                            privilegesNotification.privs.read(tProtocol);
                            privilegesNotification.setPrivsIsSet(true);
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
            privilegesNotification.validate();
        }

        public void write(TProtocol tProtocol, PrivilegesNotification privilegesNotification) throws TException {
            privilegesNotification.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (privilegesNotification.privs != null) {
                tProtocol.writeFieldBegin(PRIVS_FIELD_DESC);
                privilegesNotification.privs.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

