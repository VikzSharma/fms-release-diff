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

import com.filemaker.jwpc.iwp.thrift.common.HierarchicalNames;
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

public class ScriptNamesChangeNotification
implements TBase<ScriptNamesChangeNotification, _Fields>,
Serializable,
Cloneable,
Comparable<ScriptNamesChangeNotification> {
    private static final TStruct STRUCT_DESC = new TStruct("ScriptNamesChangeNotification");
    private static final TField SCRIPT_NAMES_FIELD_DESC = new TField("scriptNames", 12, 1);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new ScriptNamesChangeNotificationStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new ScriptNamesChangeNotificationTupleSchemeFactory();
    @Nullable
    private HierarchicalNames scriptNames;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public ScriptNamesChangeNotification() {
    }

    public ScriptNamesChangeNotification(HierarchicalNames hierarchicalNames) {
        this();
        this.scriptNames = hierarchicalNames;
    }

    public ScriptNamesChangeNotification(ScriptNamesChangeNotification scriptNamesChangeNotification) {
        if (scriptNamesChangeNotification.isSetScriptNames()) {
            this.scriptNames = new HierarchicalNames(scriptNamesChangeNotification.scriptNames);
        }
    }

    public ScriptNamesChangeNotification deepCopy() {
        return new ScriptNamesChangeNotification(this);
    }

    public void clear() {
        this.scriptNames = null;
    }

    @Nullable
    public HierarchicalNames getScriptNames() {
        return this.scriptNames;
    }

    public void setScriptNames(@Nullable HierarchicalNames hierarchicalNames) {
        this.scriptNames = hierarchicalNames;
    }

    public void unsetScriptNames() {
        this.scriptNames = null;
    }

    public boolean isSetScriptNames() {
        return this.scriptNames != null;
    }

    public void setScriptNamesIsSet(boolean bl) {
        if (!bl) {
            this.scriptNames = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetScriptNames();
                    break;
                }
                this.setScriptNames((HierarchicalNames)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getScriptNames();
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
                return this.isSetScriptNames();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof ScriptNamesChangeNotification) {
            return this.equals((ScriptNamesChangeNotification)object);
        }
        return false;
    }

    public boolean equals(ScriptNamesChangeNotification scriptNamesChangeNotification) {
        if (scriptNamesChangeNotification == null) {
            return false;
        }
        if (this == scriptNamesChangeNotification) {
            return true;
        }
        boolean bl = this.isSetScriptNames();
        boolean bl2 = scriptNamesChangeNotification.isSetScriptNames();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.scriptNames.equals(scriptNamesChangeNotification.scriptNames)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetScriptNames() ? 131071 : 524287);
        if (this.isSetScriptNames()) {
            n = n * 8191 + this.scriptNames.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(ScriptNamesChangeNotification scriptNamesChangeNotification) {
        if (!this.getClass().equals(scriptNamesChangeNotification.getClass())) {
            return this.getClass().getName().compareTo(scriptNamesChangeNotification.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetScriptNames(), scriptNamesChangeNotification.isSetScriptNames());
        if (n != 0) {
            return n;
        }
        if (this.isSetScriptNames() && (n = TBaseHelper.compareTo((Comparable)this.scriptNames, (Comparable)scriptNamesChangeNotification.scriptNames)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        ScriptNamesChangeNotification.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        ScriptNamesChangeNotification.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ScriptNamesChangeNotification(");
        boolean bl = true;
        stringBuilder.append("scriptNames:");
        if (this.scriptNames == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.scriptNames);
        }
        bl = false;
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void validate() throws TException {
        if (this.scriptNames != null) {
            this.scriptNames.validate();
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
        enumMap.put(_Fields.SCRIPT_NAMES, new FieldMetaData("scriptNames", 3, (FieldValueMetaData)new StructMetaData(12, HierarchicalNames.class)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(ScriptNamesChangeNotification.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        SCRIPT_NAMES(1, "scriptNames");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return SCRIPT_NAMES;
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

    private static class ScriptNamesChangeNotificationStandardSchemeFactory
    implements SchemeFactory {
        private ScriptNamesChangeNotificationStandardSchemeFactory() {
        }

        public ScriptNamesChangeNotificationStandardScheme getScheme() {
            return new ScriptNamesChangeNotificationStandardScheme();
        }
    }

    private static class ScriptNamesChangeNotificationTupleSchemeFactory
    implements SchemeFactory {
        private ScriptNamesChangeNotificationTupleSchemeFactory() {
        }

        public ScriptNamesChangeNotificationTupleScheme getScheme() {
            return new ScriptNamesChangeNotificationTupleScheme();
        }
    }

    private static class ScriptNamesChangeNotificationTupleScheme
    extends TupleScheme<ScriptNamesChangeNotification> {
        private ScriptNamesChangeNotificationTupleScheme() {
        }

        public void write(TProtocol tProtocol, ScriptNamesChangeNotification scriptNamesChangeNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (scriptNamesChangeNotification.isSetScriptNames()) {
                bitSet.set(0);
            }
            tTupleProtocol.writeBitSet(bitSet, 1);
            if (scriptNamesChangeNotification.isSetScriptNames()) {
                scriptNamesChangeNotification.scriptNames.write((TProtocol)tTupleProtocol);
            }
        }

        public void read(TProtocol tProtocol, ScriptNamesChangeNotification scriptNamesChangeNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(1);
            if (bitSet.get(0)) {
                scriptNamesChangeNotification.scriptNames = new HierarchicalNames();
                scriptNamesChangeNotification.scriptNames.read((TProtocol)tTupleProtocol);
                scriptNamesChangeNotification.setScriptNamesIsSet(true);
            }
        }
    }

    private static class ScriptNamesChangeNotificationStandardScheme
    extends StandardScheme<ScriptNamesChangeNotification> {
        private ScriptNamesChangeNotificationStandardScheme() {
        }

        public void read(TProtocol tProtocol, ScriptNamesChangeNotification scriptNamesChangeNotification) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 12) {
                            scriptNamesChangeNotification.scriptNames = new HierarchicalNames();
                            scriptNamesChangeNotification.scriptNames.read(tProtocol);
                            scriptNamesChangeNotification.setScriptNamesIsSet(true);
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
            scriptNamesChangeNotification.validate();
        }

        public void write(TProtocol tProtocol, ScriptNamesChangeNotification scriptNamesChangeNotification) throws TException {
            scriptNamesChangeNotification.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (scriptNamesChangeNotification.scriptNames != null) {
                tProtocol.writeFieldBegin(SCRIPT_NAMES_FIELD_DESC);
                scriptNamesChangeNotification.scriptNames.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

