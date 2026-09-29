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

public class ToolbarStatusAreaState
implements TBase<ToolbarStatusAreaState, _Fields>,
Serializable,
Cloneable,
Comparable<ToolbarStatusAreaState> {
    private static final TStruct STRUCT_DESC = new TStruct("ToolbarStatusAreaState");
    private static final TField SHOW_FIELD_DESC = new TField("show", 2, 1);
    private static final TField LOCKED_FIELD_DESC = new TField("locked", 2, 2);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new ToolbarStatusAreaStateStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new ToolbarStatusAreaStateTupleSchemeFactory();
    private boolean show;
    private boolean locked;
    private static final int __SHOW_ISSET_ID = 0;
    private static final int __LOCKED_ISSET_ID = 1;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public ToolbarStatusAreaState() {
    }

    public ToolbarStatusAreaState(boolean bl, boolean bl2) {
        this();
        this.show = bl;
        this.setShowIsSet(true);
        this.locked = bl2;
        this.setLockedIsSet(true);
    }

    public ToolbarStatusAreaState(ToolbarStatusAreaState toolbarStatusAreaState) {
        this.__isset_bitfield = toolbarStatusAreaState.__isset_bitfield;
        this.show = toolbarStatusAreaState.show;
        this.locked = toolbarStatusAreaState.locked;
    }

    public ToolbarStatusAreaState deepCopy() {
        return new ToolbarStatusAreaState(this);
    }

    public void clear() {
        this.setShowIsSet(false);
        this.show = false;
        this.setLockedIsSet(false);
        this.locked = false;
    }

    public boolean isShow() {
        return this.show;
    }

    public void setShow(boolean bl) {
        this.show = bl;
        this.setShowIsSet(true);
    }

    public void unsetShow() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetShow() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setShowIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public boolean isLocked() {
        return this.locked;
    }

    public void setLocked(boolean bl) {
        this.locked = bl;
        this.setLockedIsSet(true);
    }

    public void unsetLocked() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)1);
    }

    public boolean isSetLocked() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)1);
    }

    public void setLockedIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)1, (boolean)bl);
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetShow();
                    break;
                }
                this.setShow((Boolean)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetLocked();
                    break;
                }
                this.setLocked((Boolean)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.isShow();
            }
            case 1: {
                return this.isLocked();
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
                return this.isSetShow();
            }
            case 1: {
                return this.isSetLocked();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof ToolbarStatusAreaState) {
            return this.equals((ToolbarStatusAreaState)object);
        }
        return false;
    }

    public boolean equals(ToolbarStatusAreaState toolbarStatusAreaState) {
        if (toolbarStatusAreaState == null) {
            return false;
        }
        if (this == toolbarStatusAreaState) {
            return true;
        }
        boolean bl = true;
        boolean bl2 = true;
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (this.show != toolbarStatusAreaState.show) {
                return false;
            }
        }
        boolean bl3 = true;
        boolean bl4 = true;
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (this.locked != toolbarStatusAreaState.locked) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.show ? 131071 : 524287);
        n = n * 8191 + (this.locked ? 131071 : 524287);
        return n;
    }

    @Override
    public int compareTo(ToolbarStatusAreaState toolbarStatusAreaState) {
        if (!this.getClass().equals(toolbarStatusAreaState.getClass())) {
            return this.getClass().getName().compareTo(toolbarStatusAreaState.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetShow(), toolbarStatusAreaState.isSetShow());
        if (n != 0) {
            return n;
        }
        if (this.isSetShow() && (n = TBaseHelper.compareTo((boolean)this.show, (boolean)toolbarStatusAreaState.show)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetLocked(), toolbarStatusAreaState.isSetLocked());
        if (n != 0) {
            return n;
        }
        if (this.isSetLocked() && (n = TBaseHelper.compareTo((boolean)this.locked, (boolean)toolbarStatusAreaState.locked)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        ToolbarStatusAreaState.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        ToolbarStatusAreaState.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ToolbarStatusAreaState(");
        boolean bl = true;
        stringBuilder.append("show:");
        stringBuilder.append(this.show);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("locked:");
        stringBuilder.append(this.locked);
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
        enumMap.put(_Fields.SHOW, new FieldMetaData("show", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.LOCKED, new FieldMetaData("locked", 3, new FieldValueMetaData(2)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(ToolbarStatusAreaState.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        SHOW(1, "show"),
        LOCKED(2, "locked");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return SHOW;
                }
                case 2: {
                    return LOCKED;
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

    private static class ToolbarStatusAreaStateStandardSchemeFactory
    implements SchemeFactory {
        private ToolbarStatusAreaStateStandardSchemeFactory() {
        }

        public ToolbarStatusAreaStateStandardScheme getScheme() {
            return new ToolbarStatusAreaStateStandardScheme();
        }
    }

    private static class ToolbarStatusAreaStateTupleSchemeFactory
    implements SchemeFactory {
        private ToolbarStatusAreaStateTupleSchemeFactory() {
        }

        public ToolbarStatusAreaStateTupleScheme getScheme() {
            return new ToolbarStatusAreaStateTupleScheme();
        }
    }

    private static class ToolbarStatusAreaStateTupleScheme
    extends TupleScheme<ToolbarStatusAreaState> {
        private ToolbarStatusAreaStateTupleScheme() {
        }

        public void write(TProtocol tProtocol, ToolbarStatusAreaState toolbarStatusAreaState) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (toolbarStatusAreaState.isSetShow()) {
                bitSet.set(0);
            }
            if (toolbarStatusAreaState.isSetLocked()) {
                bitSet.set(1);
            }
            tTupleProtocol.writeBitSet(bitSet, 2);
            if (toolbarStatusAreaState.isSetShow()) {
                tTupleProtocol.writeBool(toolbarStatusAreaState.show);
            }
            if (toolbarStatusAreaState.isSetLocked()) {
                tTupleProtocol.writeBool(toolbarStatusAreaState.locked);
            }
        }

        public void read(TProtocol tProtocol, ToolbarStatusAreaState toolbarStatusAreaState) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(2);
            if (bitSet.get(0)) {
                toolbarStatusAreaState.show = tTupleProtocol.readBool();
                toolbarStatusAreaState.setShowIsSet(true);
            }
            if (bitSet.get(1)) {
                toolbarStatusAreaState.locked = tTupleProtocol.readBool();
                toolbarStatusAreaState.setLockedIsSet(true);
            }
        }
    }

    private static class ToolbarStatusAreaStateStandardScheme
    extends StandardScheme<ToolbarStatusAreaState> {
        private ToolbarStatusAreaStateStandardScheme() {
        }

        public void read(TProtocol tProtocol, ToolbarStatusAreaState toolbarStatusAreaState) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 2) {
                            toolbarStatusAreaState.show = tProtocol.readBool();
                            toolbarStatusAreaState.setShowIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 2) {
                            toolbarStatusAreaState.locked = tProtocol.readBool();
                            toolbarStatusAreaState.setLockedIsSet(true);
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
            toolbarStatusAreaState.validate();
        }

        public void write(TProtocol tProtocol, ToolbarStatusAreaState toolbarStatusAreaState) throws TException {
            toolbarStatusAreaState.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            tProtocol.writeFieldBegin(SHOW_FIELD_DESC);
            tProtocol.writeBool(toolbarStatusAreaState.show);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(LOCKED_FIELD_DESC);
            tProtocol.writeBool(toolbarStatusAreaState.locked);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

