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
import org.apache.thrift.EncodingUtils;
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

public class OpenPopoverNotification
implements TBase<OpenPopoverNotification, _Fields>,
Serializable,
Cloneable,
Comparable<OpenPopoverNotification> {
    private static final TStruct STRUCT_DESC = new TStruct("OpenPopoverNotification");
    private static final TField POPOVER_ID_FIELD_DESC = new TField("popoverId", 8, 1);
    private static final TField BUTTON_OBJECT_SPEC_FIELD_DESC = new TField("buttonObjectSpec", 12, 2);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new OpenPopoverNotificationStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new OpenPopoverNotificationTupleSchemeFactory();
    private int popoverId;
    @Nullable
    private ObjectSpec buttonObjectSpec;
    private static final int __POPOVERID_ISSET_ID = 0;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public OpenPopoverNotification() {
    }

    public OpenPopoverNotification(int n, ObjectSpec objectSpec) {
        this();
        this.popoverId = n;
        this.setPopoverIdIsSet(true);
        this.buttonObjectSpec = objectSpec;
    }

    public OpenPopoverNotification(OpenPopoverNotification openPopoverNotification) {
        this.__isset_bitfield = openPopoverNotification.__isset_bitfield;
        this.popoverId = openPopoverNotification.popoverId;
        if (openPopoverNotification.isSetButtonObjectSpec()) {
            this.buttonObjectSpec = new ObjectSpec(openPopoverNotification.buttonObjectSpec);
        }
    }

    public OpenPopoverNotification deepCopy() {
        return new OpenPopoverNotification(this);
    }

    public void clear() {
        this.setPopoverIdIsSet(false);
        this.popoverId = 0;
        this.buttonObjectSpec = null;
    }

    public int getPopoverId() {
        return this.popoverId;
    }

    public void setPopoverId(int n) {
        this.popoverId = n;
        this.setPopoverIdIsSet(true);
    }

    public void unsetPopoverId() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetPopoverId() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setPopoverIdIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    @Nullable
    public ObjectSpec getButtonObjectSpec() {
        return this.buttonObjectSpec;
    }

    public void setButtonObjectSpec(@Nullable ObjectSpec objectSpec) {
        this.buttonObjectSpec = objectSpec;
    }

    public void unsetButtonObjectSpec() {
        this.buttonObjectSpec = null;
    }

    public boolean isSetButtonObjectSpec() {
        return this.buttonObjectSpec != null;
    }

    public void setButtonObjectSpecIsSet(boolean bl) {
        if (!bl) {
            this.buttonObjectSpec = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetPopoverId();
                    break;
                }
                this.setPopoverId((Integer)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetButtonObjectSpec();
                    break;
                }
                this.setButtonObjectSpec((ObjectSpec)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getPopoverId();
            }
            case 1: {
                return this.getButtonObjectSpec();
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
                return this.isSetPopoverId();
            }
            case 1: {
                return this.isSetButtonObjectSpec();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof OpenPopoverNotification) {
            return this.equals((OpenPopoverNotification)object);
        }
        return false;
    }

    public boolean equals(OpenPopoverNotification openPopoverNotification) {
        if (openPopoverNotification == null) {
            return false;
        }
        if (this == openPopoverNotification) {
            return true;
        }
        boolean bl = true;
        boolean bl2 = true;
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (this.popoverId != openPopoverNotification.popoverId) {
                return false;
            }
        }
        boolean bl3 = this.isSetButtonObjectSpec();
        boolean bl4 = openPopoverNotification.isSetButtonObjectSpec();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.buttonObjectSpec.equals(openPopoverNotification.buttonObjectSpec)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + this.popoverId;
        n = n * 8191 + (this.isSetButtonObjectSpec() ? 131071 : 524287);
        if (this.isSetButtonObjectSpec()) {
            n = n * 8191 + this.buttonObjectSpec.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(OpenPopoverNotification openPopoverNotification) {
        if (!this.getClass().equals(openPopoverNotification.getClass())) {
            return this.getClass().getName().compareTo(openPopoverNotification.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetPopoverId(), openPopoverNotification.isSetPopoverId());
        if (n != 0) {
            return n;
        }
        if (this.isSetPopoverId() && (n = TBaseHelper.compareTo((int)this.popoverId, (int)openPopoverNotification.popoverId)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetButtonObjectSpec(), openPopoverNotification.isSetButtonObjectSpec());
        if (n != 0) {
            return n;
        }
        if (this.isSetButtonObjectSpec() && (n = TBaseHelper.compareTo((Comparable)this.buttonObjectSpec, (Comparable)openPopoverNotification.buttonObjectSpec)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        OpenPopoverNotification.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        OpenPopoverNotification.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("OpenPopoverNotification(");
        boolean bl = true;
        stringBuilder.append("popoverId:");
        stringBuilder.append(this.popoverId);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("buttonObjectSpec:");
        if (this.buttonObjectSpec == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.buttonObjectSpec);
        }
        bl = false;
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void validate() throws TException {
        if (this.buttonObjectSpec != null) {
            this.buttonObjectSpec.validate();
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
        enumMap.put(_Fields.POPOVER_ID, new FieldMetaData("popoverId", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.BUTTON_OBJECT_SPEC, new FieldMetaData("buttonObjectSpec", 3, (FieldValueMetaData)new StructMetaData(12, ObjectSpec.class)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(OpenPopoverNotification.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        POPOVER_ID(1, "popoverId"),
        BUTTON_OBJECT_SPEC(2, "buttonObjectSpec");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return POPOVER_ID;
                }
                case 2: {
                    return BUTTON_OBJECT_SPEC;
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

    private static class OpenPopoverNotificationStandardSchemeFactory
    implements SchemeFactory {
        private OpenPopoverNotificationStandardSchemeFactory() {
        }

        public OpenPopoverNotificationStandardScheme getScheme() {
            return new OpenPopoverNotificationStandardScheme();
        }
    }

    private static class OpenPopoverNotificationTupleSchemeFactory
    implements SchemeFactory {
        private OpenPopoverNotificationTupleSchemeFactory() {
        }

        public OpenPopoverNotificationTupleScheme getScheme() {
            return new OpenPopoverNotificationTupleScheme();
        }
    }

    private static class OpenPopoverNotificationTupleScheme
    extends TupleScheme<OpenPopoverNotification> {
        private OpenPopoverNotificationTupleScheme() {
        }

        public void write(TProtocol tProtocol, OpenPopoverNotification openPopoverNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (openPopoverNotification.isSetPopoverId()) {
                bitSet.set(0);
            }
            if (openPopoverNotification.isSetButtonObjectSpec()) {
                bitSet.set(1);
            }
            tTupleProtocol.writeBitSet(bitSet, 2);
            if (openPopoverNotification.isSetPopoverId()) {
                tTupleProtocol.writeI32(openPopoverNotification.popoverId);
            }
            if (openPopoverNotification.isSetButtonObjectSpec()) {
                openPopoverNotification.buttonObjectSpec.write((TProtocol)tTupleProtocol);
            }
        }

        public void read(TProtocol tProtocol, OpenPopoverNotification openPopoverNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(2);
            if (bitSet.get(0)) {
                openPopoverNotification.popoverId = tTupleProtocol.readI32();
                openPopoverNotification.setPopoverIdIsSet(true);
            }
            if (bitSet.get(1)) {
                openPopoverNotification.buttonObjectSpec = new ObjectSpec();
                openPopoverNotification.buttonObjectSpec.read((TProtocol)tTupleProtocol);
                openPopoverNotification.setButtonObjectSpecIsSet(true);
            }
        }
    }

    private static class OpenPopoverNotificationStandardScheme
    extends StandardScheme<OpenPopoverNotification> {
        private OpenPopoverNotificationStandardScheme() {
        }

        public void read(TProtocol tProtocol, OpenPopoverNotification openPopoverNotification) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 8) {
                            openPopoverNotification.popoverId = tProtocol.readI32();
                            openPopoverNotification.setPopoverIdIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 12) {
                            openPopoverNotification.buttonObjectSpec = new ObjectSpec();
                            openPopoverNotification.buttonObjectSpec.read(tProtocol);
                            openPopoverNotification.setButtonObjectSpecIsSet(true);
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
            openPopoverNotification.validate();
        }

        public void write(TProtocol tProtocol, OpenPopoverNotification openPopoverNotification) throws TException {
            openPopoverNotification.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            tProtocol.writeFieldBegin(POPOVER_ID_FIELD_DESC);
            tProtocol.writeI32(openPopoverNotification.popoverId);
            tProtocol.writeFieldEnd();
            if (openPopoverNotification.buttonObjectSpec != null) {
                tProtocol.writeFieldBegin(BUTTON_OBJECT_SPEC_FIELD_DESC);
                openPopoverNotification.buttonObjectSpec.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

