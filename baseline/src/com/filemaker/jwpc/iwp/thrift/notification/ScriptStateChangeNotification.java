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

import com.filemaker.jwpc.iwp.thrift.common.ScriptState;
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

public class ScriptStateChangeNotification
implements TBase<ScriptStateChangeNotification, _Fields>,
Serializable,
Cloneable,
Comparable<ScriptStateChangeNotification> {
    private static final TStruct STRUCT_DESC = new TStruct("ScriptStateChangeNotification");
    private static final TField SCRIPT_STATE_FIELD_DESC = new TField("scriptState", 8, 1);
    private static final TField ALLOW_ABORT_FIELD_DESC = new TField("allowAbort", 2, 2);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new ScriptStateChangeNotificationStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new ScriptStateChangeNotificationTupleSchemeFactory();
    @Nullable
    private ScriptState scriptState;
    private boolean allowAbort;
    private static final int __ALLOWABORT_ISSET_ID = 0;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public ScriptStateChangeNotification() {
    }

    public ScriptStateChangeNotification(ScriptState scriptState, boolean bl) {
        this();
        this.scriptState = scriptState;
        this.allowAbort = bl;
        this.setAllowAbortIsSet(true);
    }

    public ScriptStateChangeNotification(ScriptStateChangeNotification scriptStateChangeNotification) {
        this.__isset_bitfield = scriptStateChangeNotification.__isset_bitfield;
        if (scriptStateChangeNotification.isSetScriptState()) {
            this.scriptState = scriptStateChangeNotification.scriptState;
        }
        this.allowAbort = scriptStateChangeNotification.allowAbort;
    }

    public ScriptStateChangeNotification deepCopy() {
        return new ScriptStateChangeNotification(this);
    }

    public void clear() {
        this.scriptState = null;
        this.setAllowAbortIsSet(false);
        this.allowAbort = false;
    }

    @Nullable
    public ScriptState getScriptState() {
        return this.scriptState;
    }

    public void setScriptState(@Nullable ScriptState scriptState) {
        this.scriptState = scriptState;
    }

    public void unsetScriptState() {
        this.scriptState = null;
    }

    public boolean isSetScriptState() {
        return this.scriptState != null;
    }

    public void setScriptStateIsSet(boolean bl) {
        if (!bl) {
            this.scriptState = null;
        }
    }

    public boolean isAllowAbort() {
        return this.allowAbort;
    }

    public void setAllowAbort(boolean bl) {
        this.allowAbort = bl;
        this.setAllowAbortIsSet(true);
    }

    public void unsetAllowAbort() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetAllowAbort() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setAllowAbortIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetScriptState();
                    break;
                }
                this.setScriptState((ScriptState)((Object)object));
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetAllowAbort();
                    break;
                }
                this.setAllowAbort((Boolean)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getScriptState();
            }
            case 1: {
                return this.isAllowAbort();
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
                return this.isSetScriptState();
            }
            case 1: {
                return this.isSetAllowAbort();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof ScriptStateChangeNotification) {
            return this.equals((ScriptStateChangeNotification)object);
        }
        return false;
    }

    public boolean equals(ScriptStateChangeNotification scriptStateChangeNotification) {
        if (scriptStateChangeNotification == null) {
            return false;
        }
        if (this == scriptStateChangeNotification) {
            return true;
        }
        boolean bl = this.isSetScriptState();
        boolean bl2 = scriptStateChangeNotification.isSetScriptState();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.scriptState.equals((Object)scriptStateChangeNotification.scriptState)) {
                return false;
            }
        }
        boolean bl3 = true;
        boolean bl4 = true;
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (this.allowAbort != scriptStateChangeNotification.allowAbort) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetScriptState() ? 131071 : 524287);
        if (this.isSetScriptState()) {
            n = n * 8191 + this.scriptState.getValue();
        }
        n = n * 8191 + (this.allowAbort ? 131071 : 524287);
        return n;
    }

    @Override
    public int compareTo(ScriptStateChangeNotification scriptStateChangeNotification) {
        if (!this.getClass().equals(scriptStateChangeNotification.getClass())) {
            return this.getClass().getName().compareTo(scriptStateChangeNotification.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetScriptState(), scriptStateChangeNotification.isSetScriptState());
        if (n != 0) {
            return n;
        }
        if (this.isSetScriptState() && (n = TBaseHelper.compareTo((Comparable)((Object)this.scriptState), (Comparable)((Object)scriptStateChangeNotification.scriptState))) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetAllowAbort(), scriptStateChangeNotification.isSetAllowAbort());
        if (n != 0) {
            return n;
        }
        if (this.isSetAllowAbort() && (n = TBaseHelper.compareTo((boolean)this.allowAbort, (boolean)scriptStateChangeNotification.allowAbort)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        ScriptStateChangeNotification.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        ScriptStateChangeNotification.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ScriptStateChangeNotification(");
        boolean bl = true;
        stringBuilder.append("scriptState:");
        if (this.scriptState == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append((Object)this.scriptState);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("allowAbort:");
        stringBuilder.append(this.allowAbort);
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
        enumMap.put(_Fields.SCRIPT_STATE, new FieldMetaData("scriptState", 3, (FieldValueMetaData)new EnumMetaData(-1, ScriptState.class)));
        enumMap.put(_Fields.ALLOW_ABORT, new FieldMetaData("allowAbort", 3, new FieldValueMetaData(2)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(ScriptStateChangeNotification.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        SCRIPT_STATE(1, "scriptState"),
        ALLOW_ABORT(2, "allowAbort");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return SCRIPT_STATE;
                }
                case 2: {
                    return ALLOW_ABORT;
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

    private static class ScriptStateChangeNotificationStandardSchemeFactory
    implements SchemeFactory {
        private ScriptStateChangeNotificationStandardSchemeFactory() {
        }

        public ScriptStateChangeNotificationStandardScheme getScheme() {
            return new ScriptStateChangeNotificationStandardScheme();
        }
    }

    private static class ScriptStateChangeNotificationTupleSchemeFactory
    implements SchemeFactory {
        private ScriptStateChangeNotificationTupleSchemeFactory() {
        }

        public ScriptStateChangeNotificationTupleScheme getScheme() {
            return new ScriptStateChangeNotificationTupleScheme();
        }
    }

    private static class ScriptStateChangeNotificationTupleScheme
    extends TupleScheme<ScriptStateChangeNotification> {
        private ScriptStateChangeNotificationTupleScheme() {
        }

        public void write(TProtocol tProtocol, ScriptStateChangeNotification scriptStateChangeNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (scriptStateChangeNotification.isSetScriptState()) {
                bitSet.set(0);
            }
            if (scriptStateChangeNotification.isSetAllowAbort()) {
                bitSet.set(1);
            }
            tTupleProtocol.writeBitSet(bitSet, 2);
            if (scriptStateChangeNotification.isSetScriptState()) {
                tTupleProtocol.writeI32(scriptStateChangeNotification.scriptState.getValue());
            }
            if (scriptStateChangeNotification.isSetAllowAbort()) {
                tTupleProtocol.writeBool(scriptStateChangeNotification.allowAbort);
            }
        }

        public void read(TProtocol tProtocol, ScriptStateChangeNotification scriptStateChangeNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(2);
            if (bitSet.get(0)) {
                scriptStateChangeNotification.scriptState = ScriptState.findByValue(tTupleProtocol.readI32());
                scriptStateChangeNotification.setScriptStateIsSet(true);
            }
            if (bitSet.get(1)) {
                scriptStateChangeNotification.allowAbort = tTupleProtocol.readBool();
                scriptStateChangeNotification.setAllowAbortIsSet(true);
            }
        }
    }

    private static class ScriptStateChangeNotificationStandardScheme
    extends StandardScheme<ScriptStateChangeNotification> {
        private ScriptStateChangeNotificationStandardScheme() {
        }

        public void read(TProtocol tProtocol, ScriptStateChangeNotification scriptStateChangeNotification) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 8) {
                            scriptStateChangeNotification.scriptState = ScriptState.findByValue(tProtocol.readI32());
                            scriptStateChangeNotification.setScriptStateIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 2) {
                            scriptStateChangeNotification.allowAbort = tProtocol.readBool();
                            scriptStateChangeNotification.setAllowAbortIsSet(true);
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
            scriptStateChangeNotification.validate();
        }

        public void write(TProtocol tProtocol, ScriptStateChangeNotification scriptStateChangeNotification) throws TException {
            scriptStateChangeNotification.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (scriptStateChangeNotification.scriptState != null) {
                tProtocol.writeFieldBegin(SCRIPT_STATE_FIELD_DESC);
                tProtocol.writeI32(scriptStateChangeNotification.scriptState.getValue());
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(ALLOW_ABORT_FIELD_DESC);
            tProtocol.writeBool(scriptStateChangeNotification.allowAbort);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

