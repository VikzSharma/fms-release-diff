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
package com.filemaker.jwpc.iwp.thrift.common;

import com.filemaker.jwpc.iwp.thrift.common.ActiveObjectInfo;
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

public class ActiveRowState
implements TBase<ActiveRowState, _Fields>,
Serializable,
Cloneable,
Comparable<ActiveRowState> {
    private static final TStruct STRUCT_DESC = new TStruct("ActiveRowState");
    private static final TField ACTIVE_POPOVER_FIELD_DESC = new TField("activePopover", 2, 1);
    private static final TField OBJECT_ACTIVE_FIELD_DESC = new TField("objectActive", 2, 2);
    private static final TField ACTIVE_OBJECT_INFO_FIELD_DESC = new TField("activeObjectInfo", 12, 3);
    private static final TField NOTIFY_CLIENT_OF_ACTIVE_STATE_FIELD_DESC = new TField("notifyClientOfActiveState", 2, 4);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new ActiveRowStateStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new ActiveRowStateTupleSchemeFactory();
    private boolean activePopover;
    private boolean objectActive;
    @Nullable
    private ActiveObjectInfo activeObjectInfo;
    private boolean notifyClientOfActiveState;
    private static final int __ACTIVEPOPOVER_ISSET_ID = 0;
    private static final int __OBJECTACTIVE_ISSET_ID = 1;
    private static final int __NOTIFYCLIENTOFACTIVESTATE_ISSET_ID = 2;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public ActiveRowState() {
    }

    public ActiveRowState(boolean bl, boolean bl2, ActiveObjectInfo activeObjectInfo, boolean bl3) {
        this();
        this.activePopover = bl;
        this.setActivePopoverIsSet(true);
        this.objectActive = bl2;
        this.setObjectActiveIsSet(true);
        this.activeObjectInfo = activeObjectInfo;
        this.notifyClientOfActiveState = bl3;
        this.setNotifyClientOfActiveStateIsSet(true);
    }

    public ActiveRowState(ActiveRowState activeRowState) {
        this.__isset_bitfield = activeRowState.__isset_bitfield;
        this.activePopover = activeRowState.activePopover;
        this.objectActive = activeRowState.objectActive;
        if (activeRowState.isSetActiveObjectInfo()) {
            this.activeObjectInfo = new ActiveObjectInfo(activeRowState.activeObjectInfo);
        }
        this.notifyClientOfActiveState = activeRowState.notifyClientOfActiveState;
    }

    public ActiveRowState deepCopy() {
        return new ActiveRowState(this);
    }

    public void clear() {
        this.setActivePopoverIsSet(false);
        this.activePopover = false;
        this.setObjectActiveIsSet(false);
        this.objectActive = false;
        this.activeObjectInfo = null;
        this.setNotifyClientOfActiveStateIsSet(false);
        this.notifyClientOfActiveState = false;
    }

    public boolean isActivePopover() {
        return this.activePopover;
    }

    public void setActivePopover(boolean bl) {
        this.activePopover = bl;
        this.setActivePopoverIsSet(true);
    }

    public void unsetActivePopover() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetActivePopover() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setActivePopoverIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public boolean isObjectActive() {
        return this.objectActive;
    }

    public void setObjectActive(boolean bl) {
        this.objectActive = bl;
        this.setObjectActiveIsSet(true);
    }

    public void unsetObjectActive() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)1);
    }

    public boolean isSetObjectActive() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)1);
    }

    public void setObjectActiveIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)1, (boolean)bl);
    }

    @Nullable
    public ActiveObjectInfo getActiveObjectInfo() {
        return this.activeObjectInfo;
    }

    public void setActiveObjectInfo(@Nullable ActiveObjectInfo activeObjectInfo) {
        this.activeObjectInfo = activeObjectInfo;
    }

    public void unsetActiveObjectInfo() {
        this.activeObjectInfo = null;
    }

    public boolean isSetActiveObjectInfo() {
        return this.activeObjectInfo != null;
    }

    public void setActiveObjectInfoIsSet(boolean bl) {
        if (!bl) {
            this.activeObjectInfo = null;
        }
    }

    public boolean isNotifyClientOfActiveState() {
        return this.notifyClientOfActiveState;
    }

    public void setNotifyClientOfActiveState(boolean bl) {
        this.notifyClientOfActiveState = bl;
        this.setNotifyClientOfActiveStateIsSet(true);
    }

    public void unsetNotifyClientOfActiveState() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)2);
    }

    public boolean isSetNotifyClientOfActiveState() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)2);
    }

    public void setNotifyClientOfActiveStateIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)2, (boolean)bl);
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetActivePopover();
                    break;
                }
                this.setActivePopover((Boolean)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetObjectActive();
                    break;
                }
                this.setObjectActive((Boolean)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetActiveObjectInfo();
                    break;
                }
                this.setActiveObjectInfo((ActiveObjectInfo)object);
                break;
            }
            case 3: {
                if (object == null) {
                    this.unsetNotifyClientOfActiveState();
                    break;
                }
                this.setNotifyClientOfActiveState((Boolean)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.isActivePopover();
            }
            case 1: {
                return this.isObjectActive();
            }
            case 2: {
                return this.getActiveObjectInfo();
            }
            case 3: {
                return this.isNotifyClientOfActiveState();
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
                return this.isSetActivePopover();
            }
            case 1: {
                return this.isSetObjectActive();
            }
            case 2: {
                return this.isSetActiveObjectInfo();
            }
            case 3: {
                return this.isSetNotifyClientOfActiveState();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof ActiveRowState) {
            return this.equals((ActiveRowState)object);
        }
        return false;
    }

    public boolean equals(ActiveRowState activeRowState) {
        if (activeRowState == null) {
            return false;
        }
        if (this == activeRowState) {
            return true;
        }
        boolean bl = true;
        boolean bl2 = true;
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (this.activePopover != activeRowState.activePopover) {
                return false;
            }
        }
        boolean bl3 = true;
        boolean bl4 = true;
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (this.objectActive != activeRowState.objectActive) {
                return false;
            }
        }
        boolean bl5 = this.isSetActiveObjectInfo();
        boolean bl6 = activeRowState.isSetActiveObjectInfo();
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (!this.activeObjectInfo.equals(activeRowState.activeObjectInfo)) {
                return false;
            }
        }
        boolean bl7 = true;
        boolean bl8 = true;
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (this.notifyClientOfActiveState != activeRowState.notifyClientOfActiveState) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.activePopover ? 131071 : 524287);
        n = n * 8191 + (this.objectActive ? 131071 : 524287);
        n = n * 8191 + (this.isSetActiveObjectInfo() ? 131071 : 524287);
        if (this.isSetActiveObjectInfo()) {
            n = n * 8191 + this.activeObjectInfo.hashCode();
        }
        n = n * 8191 + (this.notifyClientOfActiveState ? 131071 : 524287);
        return n;
    }

    @Override
    public int compareTo(ActiveRowState activeRowState) {
        if (!this.getClass().equals(activeRowState.getClass())) {
            return this.getClass().getName().compareTo(activeRowState.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetActivePopover(), activeRowState.isSetActivePopover());
        if (n != 0) {
            return n;
        }
        if (this.isSetActivePopover() && (n = TBaseHelper.compareTo((boolean)this.activePopover, (boolean)activeRowState.activePopover)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetObjectActive(), activeRowState.isSetObjectActive());
        if (n != 0) {
            return n;
        }
        if (this.isSetObjectActive() && (n = TBaseHelper.compareTo((boolean)this.objectActive, (boolean)activeRowState.objectActive)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetActiveObjectInfo(), activeRowState.isSetActiveObjectInfo());
        if (n != 0) {
            return n;
        }
        if (this.isSetActiveObjectInfo() && (n = TBaseHelper.compareTo((Comparable)this.activeObjectInfo, (Comparable)activeRowState.activeObjectInfo)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetNotifyClientOfActiveState(), activeRowState.isSetNotifyClientOfActiveState());
        if (n != 0) {
            return n;
        }
        if (this.isSetNotifyClientOfActiveState() && (n = TBaseHelper.compareTo((boolean)this.notifyClientOfActiveState, (boolean)activeRowState.notifyClientOfActiveState)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        ActiveRowState.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        ActiveRowState.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ActiveRowState(");
        boolean bl = true;
        stringBuilder.append("activePopover:");
        stringBuilder.append(this.activePopover);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("objectActive:");
        stringBuilder.append(this.objectActive);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("activeObjectInfo:");
        if (this.activeObjectInfo == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.activeObjectInfo);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("notifyClientOfActiveState:");
        stringBuilder.append(this.notifyClientOfActiveState);
        bl = false;
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void validate() throws TException {
        if (this.activeObjectInfo != null) {
            this.activeObjectInfo.validate();
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
        enumMap.put(_Fields.ACTIVE_POPOVER, new FieldMetaData("activePopover", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.OBJECT_ACTIVE, new FieldMetaData("objectActive", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.ACTIVE_OBJECT_INFO, new FieldMetaData("activeObjectInfo", 3, (FieldValueMetaData)new StructMetaData(12, ActiveObjectInfo.class)));
        enumMap.put(_Fields.NOTIFY_CLIENT_OF_ACTIVE_STATE, new FieldMetaData("notifyClientOfActiveState", 3, new FieldValueMetaData(2)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(ActiveRowState.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        ACTIVE_POPOVER(1, "activePopover"),
        OBJECT_ACTIVE(2, "objectActive"),
        ACTIVE_OBJECT_INFO(3, "activeObjectInfo"),
        NOTIFY_CLIENT_OF_ACTIVE_STATE(4, "notifyClientOfActiveState");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return ACTIVE_POPOVER;
                }
                case 2: {
                    return OBJECT_ACTIVE;
                }
                case 3: {
                    return ACTIVE_OBJECT_INFO;
                }
                case 4: {
                    return NOTIFY_CLIENT_OF_ACTIVE_STATE;
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

    private static class ActiveRowStateStandardSchemeFactory
    implements SchemeFactory {
        private ActiveRowStateStandardSchemeFactory() {
        }

        public ActiveRowStateStandardScheme getScheme() {
            return new ActiveRowStateStandardScheme();
        }
    }

    private static class ActiveRowStateTupleSchemeFactory
    implements SchemeFactory {
        private ActiveRowStateTupleSchemeFactory() {
        }

        public ActiveRowStateTupleScheme getScheme() {
            return new ActiveRowStateTupleScheme();
        }
    }

    private static class ActiveRowStateTupleScheme
    extends TupleScheme<ActiveRowState> {
        private ActiveRowStateTupleScheme() {
        }

        public void write(TProtocol tProtocol, ActiveRowState activeRowState) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (activeRowState.isSetActivePopover()) {
                bitSet.set(0);
            }
            if (activeRowState.isSetObjectActive()) {
                bitSet.set(1);
            }
            if (activeRowState.isSetActiveObjectInfo()) {
                bitSet.set(2);
            }
            if (activeRowState.isSetNotifyClientOfActiveState()) {
                bitSet.set(3);
            }
            tTupleProtocol.writeBitSet(bitSet, 4);
            if (activeRowState.isSetActivePopover()) {
                tTupleProtocol.writeBool(activeRowState.activePopover);
            }
            if (activeRowState.isSetObjectActive()) {
                tTupleProtocol.writeBool(activeRowState.objectActive);
            }
            if (activeRowState.isSetActiveObjectInfo()) {
                activeRowState.activeObjectInfo.write((TProtocol)tTupleProtocol);
            }
            if (activeRowState.isSetNotifyClientOfActiveState()) {
                tTupleProtocol.writeBool(activeRowState.notifyClientOfActiveState);
            }
        }

        public void read(TProtocol tProtocol, ActiveRowState activeRowState) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(4);
            if (bitSet.get(0)) {
                activeRowState.activePopover = tTupleProtocol.readBool();
                activeRowState.setActivePopoverIsSet(true);
            }
            if (bitSet.get(1)) {
                activeRowState.objectActive = tTupleProtocol.readBool();
                activeRowState.setObjectActiveIsSet(true);
            }
            if (bitSet.get(2)) {
                activeRowState.activeObjectInfo = new ActiveObjectInfo();
                activeRowState.activeObjectInfo.read((TProtocol)tTupleProtocol);
                activeRowState.setActiveObjectInfoIsSet(true);
            }
            if (bitSet.get(3)) {
                activeRowState.notifyClientOfActiveState = tTupleProtocol.readBool();
                activeRowState.setNotifyClientOfActiveStateIsSet(true);
            }
        }
    }

    private static class ActiveRowStateStandardScheme
    extends StandardScheme<ActiveRowState> {
        private ActiveRowStateStandardScheme() {
        }

        public void read(TProtocol tProtocol, ActiveRowState activeRowState) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 2) {
                            activeRowState.activePopover = tProtocol.readBool();
                            activeRowState.setActivePopoverIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 2) {
                            activeRowState.objectActive = tProtocol.readBool();
                            activeRowState.setObjectActiveIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 12) {
                            activeRowState.activeObjectInfo = new ActiveObjectInfo();
                            activeRowState.activeObjectInfo.read(tProtocol);
                            activeRowState.setActiveObjectInfoIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 2) {
                            activeRowState.notifyClientOfActiveState = tProtocol.readBool();
                            activeRowState.setNotifyClientOfActiveStateIsSet(true);
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
            activeRowState.validate();
        }

        public void write(TProtocol tProtocol, ActiveRowState activeRowState) throws TException {
            activeRowState.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            tProtocol.writeFieldBegin(ACTIVE_POPOVER_FIELD_DESC);
            tProtocol.writeBool(activeRowState.activePopover);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(OBJECT_ACTIVE_FIELD_DESC);
            tProtocol.writeBool(activeRowState.objectActive);
            tProtocol.writeFieldEnd();
            if (activeRowState.activeObjectInfo != null) {
                tProtocol.writeFieldBegin(ACTIVE_OBJECT_INFO_FIELD_DESC);
                activeRowState.activeObjectInfo.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(NOTIFY_CLIENT_OF_ACTIVE_STATE_FIELD_DESC);
            tProtocol.writeBool(activeRowState.notifyClientOfActiveState);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

