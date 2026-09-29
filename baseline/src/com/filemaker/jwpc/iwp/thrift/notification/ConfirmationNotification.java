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
 *  org.apache.thrift.meta_data.EnumMetaData
 *  org.apache.thrift.meta_data.FieldMetaData
 *  org.apache.thrift.meta_data.FieldValueMetaData
 *  org.apache.thrift.meta_data.MapMetaData
 *  org.apache.thrift.protocol.TCompactProtocol
 *  org.apache.thrift.protocol.TField
 *  org.apache.thrift.protocol.TMap
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

import com.filemaker.jwpc.iwp.thrift.common.Attribute;
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
import org.apache.thrift.meta_data.EnumMetaData;
import org.apache.thrift.meta_data.FieldMetaData;
import org.apache.thrift.meta_data.FieldValueMetaData;
import org.apache.thrift.meta_data.MapMetaData;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TMap;
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

public class ConfirmationNotification
implements TBase<ConfirmationNotification, _Fields>,
Serializable,
Cloneable,
Comparable<ConfirmationNotification> {
    private static final TStruct STRUCT_DESC = new TStruct("ConfirmationNotification");
    private static final TField ALERT_CODE_FIELD_DESC = new TField("alertCode", 8, 1);
    private static final TField NOTIFICATION_ATTRIBUTES_FIELD_DESC = new TField("notificationAttributes", 13, 2);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new ConfirmationNotificationStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new ConfirmationNotificationTupleSchemeFactory();
    private int alertCode;
    @Nullable
    private Map<Attribute, String> notificationAttributes;
    private static final int __ALERTCODE_ISSET_ID = 0;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public ConfirmationNotification() {
    }

    public ConfirmationNotification(int n, Map<Attribute, String> map) {
        this();
        this.alertCode = n;
        this.setAlertCodeIsSet(true);
        this.notificationAttributes = map;
    }

    public ConfirmationNotification(ConfirmationNotification confirmationNotification) {
        this.__isset_bitfield = confirmationNotification.__isset_bitfield;
        this.alertCode = confirmationNotification.alertCode;
        if (confirmationNotification.isSetNotificationAttributes()) {
            EnumMap<Attribute, String> enumMap = new EnumMap<Attribute, String>(Attribute.class);
            for (Map.Entry<Attribute, String> entry : confirmationNotification.notificationAttributes.entrySet()) {
                Attribute attribute = entry.getKey();
                String string = entry.getValue();
                Attribute attribute2 = attribute;
                String string2 = string;
                enumMap.put(attribute2, string2);
            }
            this.notificationAttributes = enumMap;
        }
    }

    public ConfirmationNotification deepCopy() {
        return new ConfirmationNotification(this);
    }

    public void clear() {
        this.setAlertCodeIsSet(false);
        this.alertCode = 0;
        this.notificationAttributes = null;
    }

    public int getAlertCode() {
        return this.alertCode;
    }

    public void setAlertCode(int n) {
        this.alertCode = n;
        this.setAlertCodeIsSet(true);
    }

    public void unsetAlertCode() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetAlertCode() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setAlertCodeIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public int getNotificationAttributesSize() {
        return this.notificationAttributes == null ? 0 : this.notificationAttributes.size();
    }

    public void putToNotificationAttributes(Attribute attribute, String string) {
        if (this.notificationAttributes == null) {
            this.notificationAttributes = new EnumMap<Attribute, String>(Attribute.class);
        }
        this.notificationAttributes.put(attribute, string);
    }

    @Nullable
    public Map<Attribute, String> getNotificationAttributes() {
        return this.notificationAttributes;
    }

    public void setNotificationAttributes(@Nullable Map<Attribute, String> map) {
        this.notificationAttributes = map;
    }

    public void unsetNotificationAttributes() {
        this.notificationAttributes = null;
    }

    public boolean isSetNotificationAttributes() {
        return this.notificationAttributes != null;
    }

    public void setNotificationAttributesIsSet(boolean bl) {
        if (!bl) {
            this.notificationAttributes = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetAlertCode();
                    break;
                }
                this.setAlertCode((Integer)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetNotificationAttributes();
                    break;
                }
                this.setNotificationAttributes((Map)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getAlertCode();
            }
            case 1: {
                return this.getNotificationAttributes();
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
                return this.isSetAlertCode();
            }
            case 1: {
                return this.isSetNotificationAttributes();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof ConfirmationNotification) {
            return this.equals((ConfirmationNotification)object);
        }
        return false;
    }

    public boolean equals(ConfirmationNotification confirmationNotification) {
        if (confirmationNotification == null) {
            return false;
        }
        if (this == confirmationNotification) {
            return true;
        }
        boolean bl = true;
        boolean bl2 = true;
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (this.alertCode != confirmationNotification.alertCode) {
                return false;
            }
        }
        boolean bl3 = this.isSetNotificationAttributes();
        boolean bl4 = confirmationNotification.isSetNotificationAttributes();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.notificationAttributes.equals(confirmationNotification.notificationAttributes)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + this.alertCode;
        n = n * 8191 + (this.isSetNotificationAttributes() ? 131071 : 524287);
        if (this.isSetNotificationAttributes()) {
            n = n * 8191 + this.notificationAttributes.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(ConfirmationNotification confirmationNotification) {
        if (!this.getClass().equals(confirmationNotification.getClass())) {
            return this.getClass().getName().compareTo(confirmationNotification.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetAlertCode(), confirmationNotification.isSetAlertCode());
        if (n != 0) {
            return n;
        }
        if (this.isSetAlertCode() && (n = TBaseHelper.compareTo((int)this.alertCode, (int)confirmationNotification.alertCode)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetNotificationAttributes(), confirmationNotification.isSetNotificationAttributes());
        if (n != 0) {
            return n;
        }
        if (this.isSetNotificationAttributes() && (n = TBaseHelper.compareTo(this.notificationAttributes, confirmationNotification.notificationAttributes)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        ConfirmationNotification.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        ConfirmationNotification.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ConfirmationNotification(");
        boolean bl = true;
        stringBuilder.append("alertCode:");
        stringBuilder.append(this.alertCode);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("notificationAttributes:");
        if (this.notificationAttributes == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.notificationAttributes);
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
        enumMap.put(_Fields.ALERT_CODE, new FieldMetaData("alertCode", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.NOTIFICATION_ATTRIBUTES, new FieldMetaData("notificationAttributes", 3, (FieldValueMetaData)new MapMetaData(13, (FieldValueMetaData)new EnumMetaData(-1, Attribute.class), new FieldValueMetaData(11))));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(ConfirmationNotification.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        ALERT_CODE(1, "alertCode"),
        NOTIFICATION_ATTRIBUTES(2, "notificationAttributes");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return ALERT_CODE;
                }
                case 2: {
                    return NOTIFICATION_ATTRIBUTES;
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

    private static class ConfirmationNotificationStandardSchemeFactory
    implements SchemeFactory {
        private ConfirmationNotificationStandardSchemeFactory() {
        }

        public ConfirmationNotificationStandardScheme getScheme() {
            return new ConfirmationNotificationStandardScheme();
        }
    }

    private static class ConfirmationNotificationTupleSchemeFactory
    implements SchemeFactory {
        private ConfirmationNotificationTupleSchemeFactory() {
        }

        public ConfirmationNotificationTupleScheme getScheme() {
            return new ConfirmationNotificationTupleScheme();
        }
    }

    private static class ConfirmationNotificationTupleScheme
    extends TupleScheme<ConfirmationNotification> {
        private ConfirmationNotificationTupleScheme() {
        }

        public void write(TProtocol tProtocol, ConfirmationNotification confirmationNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (confirmationNotification.isSetAlertCode()) {
                bitSet.set(0);
            }
            if (confirmationNotification.isSetNotificationAttributes()) {
                bitSet.set(1);
            }
            tTupleProtocol.writeBitSet(bitSet, 2);
            if (confirmationNotification.isSetAlertCode()) {
                tTupleProtocol.writeI32(confirmationNotification.alertCode);
            }
            if (confirmationNotification.isSetNotificationAttributes()) {
                tTupleProtocol.writeI32(confirmationNotification.notificationAttributes.size());
                for (Map.Entry<Attribute, String> entry : confirmationNotification.notificationAttributes.entrySet()) {
                    tTupleProtocol.writeI32(entry.getKey().getValue());
                    tTupleProtocol.writeString(entry.getValue());
                }
            }
        }

        public void read(TProtocol tProtocol, ConfirmationNotification confirmationNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(2);
            if (bitSet.get(0)) {
                confirmationNotification.alertCode = tTupleProtocol.readI32();
                confirmationNotification.setAlertCodeIsSet(true);
            }
            if (bitSet.get(1)) {
                TMap tMap = tTupleProtocol.readMapBegin((byte)8, (byte)11);
                confirmationNotification.notificationAttributes = new EnumMap<Attribute, String>(Attribute.class);
                for (int i = 0; i < tMap.size; ++i) {
                    Attribute attribute = Attribute.findByValue(tTupleProtocol.readI32());
                    String string = tTupleProtocol.readString();
                    if (attribute == null) continue;
                    confirmationNotification.notificationAttributes.put(attribute, string);
                }
                confirmationNotification.setNotificationAttributesIsSet(true);
            }
        }
    }

    private static class ConfirmationNotificationStandardScheme
    extends StandardScheme<ConfirmationNotification> {
        private ConfirmationNotificationStandardScheme() {
        }

        public void read(TProtocol tProtocol, ConfirmationNotification confirmationNotification) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 8) {
                            confirmationNotification.alertCode = tProtocol.readI32();
                            confirmationNotification.setAlertCodeIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 13) {
                            TMap tMap = tProtocol.readMapBegin();
                            confirmationNotification.notificationAttributes = new EnumMap<Attribute, String>(Attribute.class);
                            for (int i = 0; i < tMap.size; ++i) {
                                Attribute attribute = Attribute.findByValue(tProtocol.readI32());
                                String string = tProtocol.readString();
                                if (attribute == null) continue;
                                confirmationNotification.notificationAttributes.put(attribute, string);
                            }
                            tProtocol.readMapEnd();
                            confirmationNotification.setNotificationAttributesIsSet(true);
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
            confirmationNotification.validate();
        }

        public void write(TProtocol tProtocol, ConfirmationNotification confirmationNotification) throws TException {
            confirmationNotification.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            tProtocol.writeFieldBegin(ALERT_CODE_FIELD_DESC);
            tProtocol.writeI32(confirmationNotification.alertCode);
            tProtocol.writeFieldEnd();
            if (confirmationNotification.notificationAttributes != null) {
                tProtocol.writeFieldBegin(NOTIFICATION_ATTRIBUTES_FIELD_DESC);
                tProtocol.writeMapBegin(new TMap(8, 11, confirmationNotification.notificationAttributes.size()));
                for (Map.Entry<Attribute, String> entry : confirmationNotification.notificationAttributes.entrySet()) {
                    tProtocol.writeI32(entry.getKey().getValue());
                    tProtocol.writeString(entry.getValue());
                }
                tProtocol.writeMapEnd();
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

