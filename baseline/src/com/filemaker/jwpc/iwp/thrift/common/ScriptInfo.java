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
import org.apache.thrift.TBase;
import org.apache.thrift.TBaseHelper;
import org.apache.thrift.TException;
import org.apache.thrift.TFieldIdEnum;
import org.apache.thrift.annotation.Nullable;
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

public class ScriptInfo
implements TBase<ScriptInfo, _Fields>,
Serializable,
Cloneable,
Comparable<ScriptInfo> {
    private static final TStruct STRUCT_DESC = new TStruct("ScriptInfo");
    private static final TField SCRIPT_NAME_FIELD_DESC = new TField("scriptName", 11, 1);
    private static final TField PARAM_VALUE_FIELD_DESC = new TField("paramValue", 11, 2);
    private static final TField VARIABLE_NVPAIRS_FIELD_DESC = new TField("variableNVPairs", 13, 3);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new ScriptInfoStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new ScriptInfoTupleSchemeFactory();
    @Nullable
    private String scriptName;
    @Nullable
    private String paramValue;
    @Nullable
    private Map<String, String> variableNVPairs;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public ScriptInfo() {
    }

    public ScriptInfo(String string, String string2, Map<String, String> map) {
        this();
        this.scriptName = string;
        this.paramValue = string2;
        this.variableNVPairs = map;
    }

    public ScriptInfo(ScriptInfo scriptInfo) {
        if (scriptInfo.isSetScriptName()) {
            this.scriptName = scriptInfo.scriptName;
        }
        if (scriptInfo.isSetParamValue()) {
            this.paramValue = scriptInfo.paramValue;
        }
        if (scriptInfo.isSetVariableNVPairs()) {
            HashMap<String, String> hashMap = new HashMap<String, String>(scriptInfo.variableNVPairs);
            this.variableNVPairs = hashMap;
        }
    }

    public ScriptInfo deepCopy() {
        return new ScriptInfo(this);
    }

    public void clear() {
        this.scriptName = null;
        this.paramValue = null;
        this.variableNVPairs = null;
    }

    @Nullable
    public String getScriptName() {
        return this.scriptName;
    }

    public void setScriptName(@Nullable String string) {
        this.scriptName = string;
    }

    public void unsetScriptName() {
        this.scriptName = null;
    }

    public boolean isSetScriptName() {
        return this.scriptName != null;
    }

    public void setScriptNameIsSet(boolean bl) {
        if (!bl) {
            this.scriptName = null;
        }
    }

    @Nullable
    public String getParamValue() {
        return this.paramValue;
    }

    public void setParamValue(@Nullable String string) {
        this.paramValue = string;
    }

    public void unsetParamValue() {
        this.paramValue = null;
    }

    public boolean isSetParamValue() {
        return this.paramValue != null;
    }

    public void setParamValueIsSet(boolean bl) {
        if (!bl) {
            this.paramValue = null;
        }
    }

    public int getVariableNVPairsSize() {
        return this.variableNVPairs == null ? 0 : this.variableNVPairs.size();
    }

    public void putToVariableNVPairs(String string, String string2) {
        if (this.variableNVPairs == null) {
            this.variableNVPairs = new HashMap<String, String>();
        }
        this.variableNVPairs.put(string, string2);
    }

    @Nullable
    public Map<String, String> getVariableNVPairs() {
        return this.variableNVPairs;
    }

    public void setVariableNVPairs(@Nullable Map<String, String> map) {
        this.variableNVPairs = map;
    }

    public void unsetVariableNVPairs() {
        this.variableNVPairs = null;
    }

    public boolean isSetVariableNVPairs() {
        return this.variableNVPairs != null;
    }

    public void setVariableNVPairsIsSet(boolean bl) {
        if (!bl) {
            this.variableNVPairs = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetScriptName();
                    break;
                }
                this.setScriptName((String)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetParamValue();
                    break;
                }
                this.setParamValue((String)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetVariableNVPairs();
                    break;
                }
                this.setVariableNVPairs((Map)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getScriptName();
            }
            case 1: {
                return this.getParamValue();
            }
            case 2: {
                return this.getVariableNVPairs();
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
                return this.isSetScriptName();
            }
            case 1: {
                return this.isSetParamValue();
            }
            case 2: {
                return this.isSetVariableNVPairs();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof ScriptInfo) {
            return this.equals((ScriptInfo)object);
        }
        return false;
    }

    public boolean equals(ScriptInfo scriptInfo) {
        if (scriptInfo == null) {
            return false;
        }
        if (this == scriptInfo) {
            return true;
        }
        boolean bl = this.isSetScriptName();
        boolean bl2 = scriptInfo.isSetScriptName();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.scriptName.equals(scriptInfo.scriptName)) {
                return false;
            }
        }
        boolean bl3 = this.isSetParamValue();
        boolean bl4 = scriptInfo.isSetParamValue();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.paramValue.equals(scriptInfo.paramValue)) {
                return false;
            }
        }
        boolean bl5 = this.isSetVariableNVPairs();
        boolean bl6 = scriptInfo.isSetVariableNVPairs();
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (!this.variableNVPairs.equals(scriptInfo.variableNVPairs)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetScriptName() ? 131071 : 524287);
        if (this.isSetScriptName()) {
            n = n * 8191 + this.scriptName.hashCode();
        }
        n = n * 8191 + (this.isSetParamValue() ? 131071 : 524287);
        if (this.isSetParamValue()) {
            n = n * 8191 + this.paramValue.hashCode();
        }
        n = n * 8191 + (this.isSetVariableNVPairs() ? 131071 : 524287);
        if (this.isSetVariableNVPairs()) {
            n = n * 8191 + this.variableNVPairs.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(ScriptInfo scriptInfo) {
        if (!this.getClass().equals(scriptInfo.getClass())) {
            return this.getClass().getName().compareTo(scriptInfo.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetScriptName(), scriptInfo.isSetScriptName());
        if (n != 0) {
            return n;
        }
        if (this.isSetScriptName() && (n = TBaseHelper.compareTo((String)this.scriptName, (String)scriptInfo.scriptName)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetParamValue(), scriptInfo.isSetParamValue());
        if (n != 0) {
            return n;
        }
        if (this.isSetParamValue() && (n = TBaseHelper.compareTo((String)this.paramValue, (String)scriptInfo.paramValue)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetVariableNVPairs(), scriptInfo.isSetVariableNVPairs());
        if (n != 0) {
            return n;
        }
        if (this.isSetVariableNVPairs() && (n = TBaseHelper.compareTo(this.variableNVPairs, scriptInfo.variableNVPairs)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        ScriptInfo.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        ScriptInfo.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ScriptInfo(");
        boolean bl = true;
        stringBuilder.append("scriptName:");
        if (this.scriptName == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.scriptName);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("paramValue:");
        if (this.paramValue == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.paramValue);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("variableNVPairs:");
        if (this.variableNVPairs == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.variableNVPairs);
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
        enumMap.put(_Fields.SCRIPT_NAME, new FieldMetaData("scriptName", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.PARAM_VALUE, new FieldMetaData("paramValue", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.VARIABLE_NVPAIRS, new FieldMetaData("variableNVPairs", 3, (FieldValueMetaData)new MapMetaData(13, new FieldValueMetaData(11), new FieldValueMetaData(11))));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(ScriptInfo.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        SCRIPT_NAME(1, "scriptName"),
        PARAM_VALUE(2, "paramValue"),
        VARIABLE_NVPAIRS(3, "variableNVPairs");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return SCRIPT_NAME;
                }
                case 2: {
                    return PARAM_VALUE;
                }
                case 3: {
                    return VARIABLE_NVPAIRS;
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

    private static class ScriptInfoStandardSchemeFactory
    implements SchemeFactory {
        private ScriptInfoStandardSchemeFactory() {
        }

        public ScriptInfoStandardScheme getScheme() {
            return new ScriptInfoStandardScheme();
        }
    }

    private static class ScriptInfoTupleSchemeFactory
    implements SchemeFactory {
        private ScriptInfoTupleSchemeFactory() {
        }

        public ScriptInfoTupleScheme getScheme() {
            return new ScriptInfoTupleScheme();
        }
    }

    private static class ScriptInfoTupleScheme
    extends TupleScheme<ScriptInfo> {
        private ScriptInfoTupleScheme() {
        }

        public void write(TProtocol tProtocol, ScriptInfo scriptInfo) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (scriptInfo.isSetScriptName()) {
                bitSet.set(0);
            }
            if (scriptInfo.isSetParamValue()) {
                bitSet.set(1);
            }
            if (scriptInfo.isSetVariableNVPairs()) {
                bitSet.set(2);
            }
            tTupleProtocol.writeBitSet(bitSet, 3);
            if (scriptInfo.isSetScriptName()) {
                tTupleProtocol.writeString(scriptInfo.scriptName);
            }
            if (scriptInfo.isSetParamValue()) {
                tTupleProtocol.writeString(scriptInfo.paramValue);
            }
            if (scriptInfo.isSetVariableNVPairs()) {
                tTupleProtocol.writeI32(scriptInfo.variableNVPairs.size());
                for (Map.Entry<String, String> entry : scriptInfo.variableNVPairs.entrySet()) {
                    tTupleProtocol.writeString(entry.getKey());
                    tTupleProtocol.writeString(entry.getValue());
                }
            }
        }

        public void read(TProtocol tProtocol, ScriptInfo scriptInfo) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(3);
            if (bitSet.get(0)) {
                scriptInfo.scriptName = tTupleProtocol.readString();
                scriptInfo.setScriptNameIsSet(true);
            }
            if (bitSet.get(1)) {
                scriptInfo.paramValue = tTupleProtocol.readString();
                scriptInfo.setParamValueIsSet(true);
            }
            if (bitSet.get(2)) {
                TMap tMap = tTupleProtocol.readMapBegin((byte)11, (byte)11);
                scriptInfo.variableNVPairs = new HashMap<String, String>(2 * tMap.size);
                for (int i = 0; i < tMap.size; ++i) {
                    String string = tTupleProtocol.readString();
                    String string2 = tTupleProtocol.readString();
                    scriptInfo.variableNVPairs.put(string, string2);
                }
                scriptInfo.setVariableNVPairsIsSet(true);
            }
        }
    }

    private static class ScriptInfoStandardScheme
    extends StandardScheme<ScriptInfo> {
        private ScriptInfoStandardScheme() {
        }

        public void read(TProtocol tProtocol, ScriptInfo scriptInfo) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 11) {
                            scriptInfo.scriptName = tProtocol.readString();
                            scriptInfo.setScriptNameIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 11) {
                            scriptInfo.paramValue = tProtocol.readString();
                            scriptInfo.setParamValueIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 13) {
                            TMap tMap = tProtocol.readMapBegin();
                            scriptInfo.variableNVPairs = new HashMap<String, String>(2 * tMap.size);
                            for (int i = 0; i < tMap.size; ++i) {
                                String string = tProtocol.readString();
                                String string2 = tProtocol.readString();
                                scriptInfo.variableNVPairs.put(string, string2);
                            }
                            tProtocol.readMapEnd();
                            scriptInfo.setVariableNVPairsIsSet(true);
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
            scriptInfo.validate();
        }

        public void write(TProtocol tProtocol, ScriptInfo scriptInfo) throws TException {
            scriptInfo.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (scriptInfo.scriptName != null) {
                tProtocol.writeFieldBegin(SCRIPT_NAME_FIELD_DESC);
                tProtocol.writeString(scriptInfo.scriptName);
                tProtocol.writeFieldEnd();
            }
            if (scriptInfo.paramValue != null) {
                tProtocol.writeFieldBegin(PARAM_VALUE_FIELD_DESC);
                tProtocol.writeString(scriptInfo.paramValue);
                tProtocol.writeFieldEnd();
            }
            if (scriptInfo.variableNVPairs != null) {
                tProtocol.writeFieldBegin(VARIABLE_NVPAIRS_FIELD_DESC);
                tProtocol.writeMapBegin(new TMap(11, 11, scriptInfo.variableNVPairs.size()));
                for (Map.Entry<String, String> entry : scriptInfo.variableNVPairs.entrySet()) {
                    tProtocol.writeString(entry.getKey());
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

