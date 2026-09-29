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

public class VisiblePanelChangeNotification
implements TBase<VisiblePanelChangeNotification, _Fields>,
Serializable,
Cloneable,
Comparable<VisiblePanelChangeNotification> {
    private static final TStruct STRUCT_DESC = new TStruct("VisiblePanelChangeNotification");
    private static final TField PANEL_CONTAINER_ID_FIELD_DESC = new TField("panelContainerId", 8, 1);
    private static final TField VISIBLE_PANEL_ID_FIELD_DESC = new TField("visiblePanelId", 8, 2);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new VisiblePanelChangeNotificationStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new VisiblePanelChangeNotificationTupleSchemeFactory();
    private int panelContainerId;
    private int visiblePanelId;
    private static final int __PANELCONTAINERID_ISSET_ID = 0;
    private static final int __VISIBLEPANELID_ISSET_ID = 1;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public VisiblePanelChangeNotification() {
    }

    public VisiblePanelChangeNotification(int n, int n2) {
        this();
        this.panelContainerId = n;
        this.setPanelContainerIdIsSet(true);
        this.visiblePanelId = n2;
        this.setVisiblePanelIdIsSet(true);
    }

    public VisiblePanelChangeNotification(VisiblePanelChangeNotification visiblePanelChangeNotification) {
        this.__isset_bitfield = visiblePanelChangeNotification.__isset_bitfield;
        this.panelContainerId = visiblePanelChangeNotification.panelContainerId;
        this.visiblePanelId = visiblePanelChangeNotification.visiblePanelId;
    }

    public VisiblePanelChangeNotification deepCopy() {
        return new VisiblePanelChangeNotification(this);
    }

    public void clear() {
        this.setPanelContainerIdIsSet(false);
        this.panelContainerId = 0;
        this.setVisiblePanelIdIsSet(false);
        this.visiblePanelId = 0;
    }

    public int getPanelContainerId() {
        return this.panelContainerId;
    }

    public void setPanelContainerId(int n) {
        this.panelContainerId = n;
        this.setPanelContainerIdIsSet(true);
    }

    public void unsetPanelContainerId() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetPanelContainerId() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setPanelContainerIdIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public int getVisiblePanelId() {
        return this.visiblePanelId;
    }

    public void setVisiblePanelId(int n) {
        this.visiblePanelId = n;
        this.setVisiblePanelIdIsSet(true);
    }

    public void unsetVisiblePanelId() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)1);
    }

    public boolean isSetVisiblePanelId() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)1);
    }

    public void setVisiblePanelIdIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)1, (boolean)bl);
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetPanelContainerId();
                    break;
                }
                this.setPanelContainerId((Integer)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetVisiblePanelId();
                    break;
                }
                this.setVisiblePanelId((Integer)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getPanelContainerId();
            }
            case 1: {
                return this.getVisiblePanelId();
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
                return this.isSetPanelContainerId();
            }
            case 1: {
                return this.isSetVisiblePanelId();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof VisiblePanelChangeNotification) {
            return this.equals((VisiblePanelChangeNotification)object);
        }
        return false;
    }

    public boolean equals(VisiblePanelChangeNotification visiblePanelChangeNotification) {
        if (visiblePanelChangeNotification == null) {
            return false;
        }
        if (this == visiblePanelChangeNotification) {
            return true;
        }
        boolean bl = true;
        boolean bl2 = true;
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (this.panelContainerId != visiblePanelChangeNotification.panelContainerId) {
                return false;
            }
        }
        boolean bl3 = true;
        boolean bl4 = true;
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (this.visiblePanelId != visiblePanelChangeNotification.visiblePanelId) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + this.panelContainerId;
        n = n * 8191 + this.visiblePanelId;
        return n;
    }

    @Override
    public int compareTo(VisiblePanelChangeNotification visiblePanelChangeNotification) {
        if (!this.getClass().equals(visiblePanelChangeNotification.getClass())) {
            return this.getClass().getName().compareTo(visiblePanelChangeNotification.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetPanelContainerId(), visiblePanelChangeNotification.isSetPanelContainerId());
        if (n != 0) {
            return n;
        }
        if (this.isSetPanelContainerId() && (n = TBaseHelper.compareTo((int)this.panelContainerId, (int)visiblePanelChangeNotification.panelContainerId)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetVisiblePanelId(), visiblePanelChangeNotification.isSetVisiblePanelId());
        if (n != 0) {
            return n;
        }
        if (this.isSetVisiblePanelId() && (n = TBaseHelper.compareTo((int)this.visiblePanelId, (int)visiblePanelChangeNotification.visiblePanelId)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        VisiblePanelChangeNotification.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        VisiblePanelChangeNotification.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("VisiblePanelChangeNotification(");
        boolean bl = true;
        stringBuilder.append("panelContainerId:");
        stringBuilder.append(this.panelContainerId);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("visiblePanelId:");
        stringBuilder.append(this.visiblePanelId);
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
        enumMap.put(_Fields.PANEL_CONTAINER_ID, new FieldMetaData("panelContainerId", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.VISIBLE_PANEL_ID, new FieldMetaData("visiblePanelId", 3, new FieldValueMetaData(8)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(VisiblePanelChangeNotification.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        PANEL_CONTAINER_ID(1, "panelContainerId"),
        VISIBLE_PANEL_ID(2, "visiblePanelId");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return PANEL_CONTAINER_ID;
                }
                case 2: {
                    return VISIBLE_PANEL_ID;
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

    private static class VisiblePanelChangeNotificationStandardSchemeFactory
    implements SchemeFactory {
        private VisiblePanelChangeNotificationStandardSchemeFactory() {
        }

        public VisiblePanelChangeNotificationStandardScheme getScheme() {
            return new VisiblePanelChangeNotificationStandardScheme();
        }
    }

    private static class VisiblePanelChangeNotificationTupleSchemeFactory
    implements SchemeFactory {
        private VisiblePanelChangeNotificationTupleSchemeFactory() {
        }

        public VisiblePanelChangeNotificationTupleScheme getScheme() {
            return new VisiblePanelChangeNotificationTupleScheme();
        }
    }

    private static class VisiblePanelChangeNotificationTupleScheme
    extends TupleScheme<VisiblePanelChangeNotification> {
        private VisiblePanelChangeNotificationTupleScheme() {
        }

        public void write(TProtocol tProtocol, VisiblePanelChangeNotification visiblePanelChangeNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (visiblePanelChangeNotification.isSetPanelContainerId()) {
                bitSet.set(0);
            }
            if (visiblePanelChangeNotification.isSetVisiblePanelId()) {
                bitSet.set(1);
            }
            tTupleProtocol.writeBitSet(bitSet, 2);
            if (visiblePanelChangeNotification.isSetPanelContainerId()) {
                tTupleProtocol.writeI32(visiblePanelChangeNotification.panelContainerId);
            }
            if (visiblePanelChangeNotification.isSetVisiblePanelId()) {
                tTupleProtocol.writeI32(visiblePanelChangeNotification.visiblePanelId);
            }
        }

        public void read(TProtocol tProtocol, VisiblePanelChangeNotification visiblePanelChangeNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(2);
            if (bitSet.get(0)) {
                visiblePanelChangeNotification.panelContainerId = tTupleProtocol.readI32();
                visiblePanelChangeNotification.setPanelContainerIdIsSet(true);
            }
            if (bitSet.get(1)) {
                visiblePanelChangeNotification.visiblePanelId = tTupleProtocol.readI32();
                visiblePanelChangeNotification.setVisiblePanelIdIsSet(true);
            }
        }
    }

    private static class VisiblePanelChangeNotificationStandardScheme
    extends StandardScheme<VisiblePanelChangeNotification> {
        private VisiblePanelChangeNotificationStandardScheme() {
        }

        public void read(TProtocol tProtocol, VisiblePanelChangeNotification visiblePanelChangeNotification) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 8) {
                            visiblePanelChangeNotification.panelContainerId = tProtocol.readI32();
                            visiblePanelChangeNotification.setPanelContainerIdIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 8) {
                            visiblePanelChangeNotification.visiblePanelId = tProtocol.readI32();
                            visiblePanelChangeNotification.setVisiblePanelIdIsSet(true);
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
            visiblePanelChangeNotification.validate();
        }

        public void write(TProtocol tProtocol, VisiblePanelChangeNotification visiblePanelChangeNotification) throws TException {
            visiblePanelChangeNotification.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            tProtocol.writeFieldBegin(PANEL_CONTAINER_ID_FIELD_DESC);
            tProtocol.writeI32(visiblePanelChangeNotification.panelContainerId);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(VISIBLE_PANEL_ID_FIELD_DESC);
            tProtocol.writeI32(visiblePanelChangeNotification.visiblePanelId);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

