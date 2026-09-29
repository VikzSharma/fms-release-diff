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

import com.filemaker.jwpc.iwp.thrift.common.ActiveRowState;
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

public class ActiveRowStateNotification
implements TBase<ActiveRowStateNotification, _Fields>,
Serializable,
Cloneable,
Comparable<ActiveRowStateNotification> {
    private static final TStruct STRUCT_DESC = new TStruct("ActiveRowStateNotification");
    private static final TField ROW_STATE_FIELD_DESC = new TField("rowState", 12, 1);
    private static final TField UPDATE_SELECTION_FIELD_DESC = new TField("updateSelection", 2, 2);
    private static final TField SELECTION_START_FIELD_DESC = new TField("selectionStart", 8, 3);
    private static final TField SELECTION_END_FIELD_DESC = new TField("selectionEnd", 8, 4);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new ActiveRowStateNotificationStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new ActiveRowStateNotificationTupleSchemeFactory();
    @Nullable
    private ActiveRowState rowState;
    private boolean updateSelection;
    private int selectionStart;
    private int selectionEnd;
    private static final int __UPDATESELECTION_ISSET_ID = 0;
    private static final int __SELECTIONSTART_ISSET_ID = 1;
    private static final int __SELECTIONEND_ISSET_ID = 2;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public ActiveRowStateNotification() {
    }

    public ActiveRowStateNotification(ActiveRowState activeRowState, boolean bl, int n, int n2) {
        this();
        this.rowState = activeRowState;
        this.updateSelection = bl;
        this.setUpdateSelectionIsSet(true);
        this.selectionStart = n;
        this.setSelectionStartIsSet(true);
        this.selectionEnd = n2;
        this.setSelectionEndIsSet(true);
    }

    public ActiveRowStateNotification(ActiveRowStateNotification activeRowStateNotification) {
        this.__isset_bitfield = activeRowStateNotification.__isset_bitfield;
        if (activeRowStateNotification.isSetRowState()) {
            this.rowState = new ActiveRowState(activeRowStateNotification.rowState);
        }
        this.updateSelection = activeRowStateNotification.updateSelection;
        this.selectionStart = activeRowStateNotification.selectionStart;
        this.selectionEnd = activeRowStateNotification.selectionEnd;
    }

    public ActiveRowStateNotification deepCopy() {
        return new ActiveRowStateNotification(this);
    }

    public void clear() {
        this.rowState = null;
        this.setUpdateSelectionIsSet(false);
        this.updateSelection = false;
        this.setSelectionStartIsSet(false);
        this.selectionStart = 0;
        this.setSelectionEndIsSet(false);
        this.selectionEnd = 0;
    }

    @Nullable
    public ActiveRowState getRowState() {
        return this.rowState;
    }

    public void setRowState(@Nullable ActiveRowState activeRowState) {
        this.rowState = activeRowState;
    }

    public void unsetRowState() {
        this.rowState = null;
    }

    public boolean isSetRowState() {
        return this.rowState != null;
    }

    public void setRowStateIsSet(boolean bl) {
        if (!bl) {
            this.rowState = null;
        }
    }

    public boolean isUpdateSelection() {
        return this.updateSelection;
    }

    public void setUpdateSelection(boolean bl) {
        this.updateSelection = bl;
        this.setUpdateSelectionIsSet(true);
    }

    public void unsetUpdateSelection() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetUpdateSelection() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setUpdateSelectionIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public int getSelectionStart() {
        return this.selectionStart;
    }

    public void setSelectionStart(int n) {
        this.selectionStart = n;
        this.setSelectionStartIsSet(true);
    }

    public void unsetSelectionStart() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)1);
    }

    public boolean isSetSelectionStart() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)1);
    }

    public void setSelectionStartIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)1, (boolean)bl);
    }

    public int getSelectionEnd() {
        return this.selectionEnd;
    }

    public void setSelectionEnd(int n) {
        this.selectionEnd = n;
        this.setSelectionEndIsSet(true);
    }

    public void unsetSelectionEnd() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)2);
    }

    public boolean isSetSelectionEnd() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)2);
    }

    public void setSelectionEndIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)2, (boolean)bl);
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetRowState();
                    break;
                }
                this.setRowState((ActiveRowState)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetUpdateSelection();
                    break;
                }
                this.setUpdateSelection((Boolean)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetSelectionStart();
                    break;
                }
                this.setSelectionStart((Integer)object);
                break;
            }
            case 3: {
                if (object == null) {
                    this.unsetSelectionEnd();
                    break;
                }
                this.setSelectionEnd((Integer)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getRowState();
            }
            case 1: {
                return this.isUpdateSelection();
            }
            case 2: {
                return this.getSelectionStart();
            }
            case 3: {
                return this.getSelectionEnd();
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
                return this.isSetRowState();
            }
            case 1: {
                return this.isSetUpdateSelection();
            }
            case 2: {
                return this.isSetSelectionStart();
            }
            case 3: {
                return this.isSetSelectionEnd();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof ActiveRowStateNotification) {
            return this.equals((ActiveRowStateNotification)object);
        }
        return false;
    }

    public boolean equals(ActiveRowStateNotification activeRowStateNotification) {
        if (activeRowStateNotification == null) {
            return false;
        }
        if (this == activeRowStateNotification) {
            return true;
        }
        boolean bl = this.isSetRowState();
        boolean bl2 = activeRowStateNotification.isSetRowState();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.rowState.equals(activeRowStateNotification.rowState)) {
                return false;
            }
        }
        boolean bl3 = true;
        boolean bl4 = true;
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (this.updateSelection != activeRowStateNotification.updateSelection) {
                return false;
            }
        }
        boolean bl5 = true;
        boolean bl6 = true;
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (this.selectionStart != activeRowStateNotification.selectionStart) {
                return false;
            }
        }
        boolean bl7 = true;
        boolean bl8 = true;
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (this.selectionEnd != activeRowStateNotification.selectionEnd) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetRowState() ? 131071 : 524287);
        if (this.isSetRowState()) {
            n = n * 8191 + this.rowState.hashCode();
        }
        n = n * 8191 + (this.updateSelection ? 131071 : 524287);
        n = n * 8191 + this.selectionStart;
        n = n * 8191 + this.selectionEnd;
        return n;
    }

    @Override
    public int compareTo(ActiveRowStateNotification activeRowStateNotification) {
        if (!this.getClass().equals(activeRowStateNotification.getClass())) {
            return this.getClass().getName().compareTo(activeRowStateNotification.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetRowState(), activeRowStateNotification.isSetRowState());
        if (n != 0) {
            return n;
        }
        if (this.isSetRowState() && (n = TBaseHelper.compareTo((Comparable)this.rowState, (Comparable)activeRowStateNotification.rowState)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetUpdateSelection(), activeRowStateNotification.isSetUpdateSelection());
        if (n != 0) {
            return n;
        }
        if (this.isSetUpdateSelection() && (n = TBaseHelper.compareTo((boolean)this.updateSelection, (boolean)activeRowStateNotification.updateSelection)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetSelectionStart(), activeRowStateNotification.isSetSelectionStart());
        if (n != 0) {
            return n;
        }
        if (this.isSetSelectionStart() && (n = TBaseHelper.compareTo((int)this.selectionStart, (int)activeRowStateNotification.selectionStart)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetSelectionEnd(), activeRowStateNotification.isSetSelectionEnd());
        if (n != 0) {
            return n;
        }
        if (this.isSetSelectionEnd() && (n = TBaseHelper.compareTo((int)this.selectionEnd, (int)activeRowStateNotification.selectionEnd)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        ActiveRowStateNotification.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        ActiveRowStateNotification.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ActiveRowStateNotification(");
        boolean bl = true;
        stringBuilder.append("rowState:");
        if (this.rowState == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.rowState);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("updateSelection:");
        stringBuilder.append(this.updateSelection);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("selectionStart:");
        stringBuilder.append(this.selectionStart);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("selectionEnd:");
        stringBuilder.append(this.selectionEnd);
        bl = false;
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void validate() throws TException {
        if (this.rowState != null) {
            this.rowState.validate();
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
        enumMap.put(_Fields.ROW_STATE, new FieldMetaData("rowState", 3, (FieldValueMetaData)new StructMetaData(12, ActiveRowState.class)));
        enumMap.put(_Fields.UPDATE_SELECTION, new FieldMetaData("updateSelection", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.SELECTION_START, new FieldMetaData("selectionStart", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.SELECTION_END, new FieldMetaData("selectionEnd", 3, new FieldValueMetaData(8)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(ActiveRowStateNotification.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        ROW_STATE(1, "rowState"),
        UPDATE_SELECTION(2, "updateSelection"),
        SELECTION_START(3, "selectionStart"),
        SELECTION_END(4, "selectionEnd");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return ROW_STATE;
                }
                case 2: {
                    return UPDATE_SELECTION;
                }
                case 3: {
                    return SELECTION_START;
                }
                case 4: {
                    return SELECTION_END;
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

    private static class ActiveRowStateNotificationStandardSchemeFactory
    implements SchemeFactory {
        private ActiveRowStateNotificationStandardSchemeFactory() {
        }

        public ActiveRowStateNotificationStandardScheme getScheme() {
            return new ActiveRowStateNotificationStandardScheme();
        }
    }

    private static class ActiveRowStateNotificationTupleSchemeFactory
    implements SchemeFactory {
        private ActiveRowStateNotificationTupleSchemeFactory() {
        }

        public ActiveRowStateNotificationTupleScheme getScheme() {
            return new ActiveRowStateNotificationTupleScheme();
        }
    }

    private static class ActiveRowStateNotificationTupleScheme
    extends TupleScheme<ActiveRowStateNotification> {
        private ActiveRowStateNotificationTupleScheme() {
        }

        public void write(TProtocol tProtocol, ActiveRowStateNotification activeRowStateNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (activeRowStateNotification.isSetRowState()) {
                bitSet.set(0);
            }
            if (activeRowStateNotification.isSetUpdateSelection()) {
                bitSet.set(1);
            }
            if (activeRowStateNotification.isSetSelectionStart()) {
                bitSet.set(2);
            }
            if (activeRowStateNotification.isSetSelectionEnd()) {
                bitSet.set(3);
            }
            tTupleProtocol.writeBitSet(bitSet, 4);
            if (activeRowStateNotification.isSetRowState()) {
                activeRowStateNotification.rowState.write((TProtocol)tTupleProtocol);
            }
            if (activeRowStateNotification.isSetUpdateSelection()) {
                tTupleProtocol.writeBool(activeRowStateNotification.updateSelection);
            }
            if (activeRowStateNotification.isSetSelectionStart()) {
                tTupleProtocol.writeI32(activeRowStateNotification.selectionStart);
            }
            if (activeRowStateNotification.isSetSelectionEnd()) {
                tTupleProtocol.writeI32(activeRowStateNotification.selectionEnd);
            }
        }

        public void read(TProtocol tProtocol, ActiveRowStateNotification activeRowStateNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(4);
            if (bitSet.get(0)) {
                activeRowStateNotification.rowState = new ActiveRowState();
                activeRowStateNotification.rowState.read((TProtocol)tTupleProtocol);
                activeRowStateNotification.setRowStateIsSet(true);
            }
            if (bitSet.get(1)) {
                activeRowStateNotification.updateSelection = tTupleProtocol.readBool();
                activeRowStateNotification.setUpdateSelectionIsSet(true);
            }
            if (bitSet.get(2)) {
                activeRowStateNotification.selectionStart = tTupleProtocol.readI32();
                activeRowStateNotification.setSelectionStartIsSet(true);
            }
            if (bitSet.get(3)) {
                activeRowStateNotification.selectionEnd = tTupleProtocol.readI32();
                activeRowStateNotification.setSelectionEndIsSet(true);
            }
        }
    }

    private static class ActiveRowStateNotificationStandardScheme
    extends StandardScheme<ActiveRowStateNotification> {
        private ActiveRowStateNotificationStandardScheme() {
        }

        public void read(TProtocol tProtocol, ActiveRowStateNotification activeRowStateNotification) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 12) {
                            activeRowStateNotification.rowState = new ActiveRowState();
                            activeRowStateNotification.rowState.read(tProtocol);
                            activeRowStateNotification.setRowStateIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 2) {
                            activeRowStateNotification.updateSelection = tProtocol.readBool();
                            activeRowStateNotification.setUpdateSelectionIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 8) {
                            activeRowStateNotification.selectionStart = tProtocol.readI32();
                            activeRowStateNotification.setSelectionStartIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 8) {
                            activeRowStateNotification.selectionEnd = tProtocol.readI32();
                            activeRowStateNotification.setSelectionEndIsSet(true);
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
            activeRowStateNotification.validate();
        }

        public void write(TProtocol tProtocol, ActiveRowStateNotification activeRowStateNotification) throws TException {
            activeRowStateNotification.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (activeRowStateNotification.rowState != null) {
                tProtocol.writeFieldBegin(ROW_STATE_FIELD_DESC);
                activeRowStateNotification.rowState.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(UPDATE_SELECTION_FIELD_DESC);
            tProtocol.writeBool(activeRowStateNotification.updateSelection);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(SELECTION_START_FIELD_DESC);
            tProtocol.writeI32(activeRowStateNotification.selectionStart);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(SELECTION_END_FIELD_DESC);
            tProtocol.writeI32(activeRowStateNotification.selectionEnd);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

