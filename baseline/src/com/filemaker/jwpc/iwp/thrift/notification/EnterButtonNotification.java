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

import com.filemaker.jwpc.iwp.thrift.common.ObjectSpec;
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

public class EnterButtonNotification
implements TBase<EnterButtonNotification, _Fields>,
Serializable,
Cloneable,
Comparable<EnterButtonNotification> {
    private static final TStruct STRUCT_DESC = new TStruct("EnterButtonNotification");
    private static final TField OBJECT_SPEC_FIELD_DESC = new TField("objectSpec", 12, 1);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new EnterButtonNotificationStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new EnterButtonNotificationTupleSchemeFactory();
    @Nullable
    private ObjectSpec objectSpec;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public EnterButtonNotification() {
    }

    public EnterButtonNotification(ObjectSpec objectSpec) {
        this();
        this.objectSpec = objectSpec;
    }

    public EnterButtonNotification(EnterButtonNotification enterButtonNotification) {
        if (enterButtonNotification.isSetObjectSpec()) {
            this.objectSpec = new ObjectSpec(enterButtonNotification.objectSpec);
        }
    }

    public EnterButtonNotification deepCopy() {
        return new EnterButtonNotification(this);
    }

    public void clear() {
        this.objectSpec = null;
    }

    @Nullable
    public ObjectSpec getObjectSpec() {
        return this.objectSpec;
    }

    public void setObjectSpec(@Nullable ObjectSpec objectSpec) {
        this.objectSpec = objectSpec;
    }

    public void unsetObjectSpec() {
        this.objectSpec = null;
    }

    public boolean isSetObjectSpec() {
        return this.objectSpec != null;
    }

    public void setObjectSpecIsSet(boolean bl) {
        if (!bl) {
            this.objectSpec = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetObjectSpec();
                    break;
                }
                this.setObjectSpec((ObjectSpec)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getObjectSpec();
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
                return this.isSetObjectSpec();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof EnterButtonNotification) {
            return this.equals((EnterButtonNotification)object);
        }
        return false;
    }

    public boolean equals(EnterButtonNotification enterButtonNotification) {
        if (enterButtonNotification == null) {
            return false;
        }
        if (this == enterButtonNotification) {
            return true;
        }
        boolean bl = this.isSetObjectSpec();
        boolean bl2 = enterButtonNotification.isSetObjectSpec();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.objectSpec.equals(enterButtonNotification.objectSpec)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetObjectSpec() ? 131071 : 524287);
        if (this.isSetObjectSpec()) {
            n = n * 8191 + this.objectSpec.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(EnterButtonNotification enterButtonNotification) {
        if (!this.getClass().equals(enterButtonNotification.getClass())) {
            return this.getClass().getName().compareTo(enterButtonNotification.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetObjectSpec(), enterButtonNotification.isSetObjectSpec());
        if (n != 0) {
            return n;
        }
        if (this.isSetObjectSpec() && (n = TBaseHelper.compareTo((Comparable)this.objectSpec, (Comparable)enterButtonNotification.objectSpec)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        EnterButtonNotification.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        EnterButtonNotification.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("EnterButtonNotification(");
        boolean bl = true;
        stringBuilder.append("objectSpec:");
        if (this.objectSpec == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.objectSpec);
        }
        bl = false;
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void validate() throws TException {
        if (this.objectSpec != null) {
            this.objectSpec.validate();
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
        enumMap.put(_Fields.OBJECT_SPEC, new FieldMetaData("objectSpec", 3, (FieldValueMetaData)new StructMetaData(12, ObjectSpec.class)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(EnterButtonNotification.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        OBJECT_SPEC(1, "objectSpec");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return OBJECT_SPEC;
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

    private static class EnterButtonNotificationStandardSchemeFactory
    implements SchemeFactory {
        private EnterButtonNotificationStandardSchemeFactory() {
        }

        public EnterButtonNotificationStandardScheme getScheme() {
            return new EnterButtonNotificationStandardScheme();
        }
    }

    private static class EnterButtonNotificationTupleSchemeFactory
    implements SchemeFactory {
        private EnterButtonNotificationTupleSchemeFactory() {
        }

        public EnterButtonNotificationTupleScheme getScheme() {
            return new EnterButtonNotificationTupleScheme();
        }
    }

    private static class EnterButtonNotificationTupleScheme
    extends TupleScheme<EnterButtonNotification> {
        private EnterButtonNotificationTupleScheme() {
        }

        public void write(TProtocol tProtocol, EnterButtonNotification enterButtonNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (enterButtonNotification.isSetObjectSpec()) {
                bitSet.set(0);
            }
            tTupleProtocol.writeBitSet(bitSet, 1);
            if (enterButtonNotification.isSetObjectSpec()) {
                enterButtonNotification.objectSpec.write((TProtocol)tTupleProtocol);
            }
        }

        public void read(TProtocol tProtocol, EnterButtonNotification enterButtonNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(1);
            if (bitSet.get(0)) {
                enterButtonNotification.objectSpec = new ObjectSpec();
                enterButtonNotification.objectSpec.read((TProtocol)tTupleProtocol);
                enterButtonNotification.setObjectSpecIsSet(true);
            }
        }
    }

    private static class EnterButtonNotificationStandardScheme
    extends StandardScheme<EnterButtonNotification> {
        private EnterButtonNotificationStandardScheme() {
        }

        public void read(TProtocol tProtocol, EnterButtonNotification enterButtonNotification) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 12) {
                            enterButtonNotification.objectSpec = new ObjectSpec();
                            enterButtonNotification.objectSpec.read(tProtocol);
                            enterButtonNotification.setObjectSpecIsSet(true);
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
            enterButtonNotification.validate();
        }

        public void write(TProtocol tProtocol, EnterButtonNotification enterButtonNotification) throws TException {
            enterButtonNotification.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (enterButtonNotification.objectSpec != null) {
                tProtocol.writeFieldBegin(OBJECT_SPEC_FIELD_DESC);
                enterButtonNotification.objectSpec.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

