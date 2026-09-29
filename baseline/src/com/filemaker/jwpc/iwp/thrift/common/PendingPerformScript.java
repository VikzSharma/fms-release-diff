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

public class PendingPerformScript
implements TBase<PendingPerformScript, _Fields>,
Serializable,
Cloneable,
Comparable<PendingPerformScript> {
    private static final TStruct STRUCT_DESC = new TStruct("PendingPerformScript");
    private static final TField SCRIPT_NAME_FIELD_DESC = new TField("scriptName", 11, 1);
    private static final TField SCRIPT_PARAM_FIELD_DESC = new TField("scriptParam", 11, 2);
    private static final TField SCRIPT_OPTION_FIELD_DESC = new TField("scriptOption", 11, 3);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new PendingPerformScriptStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new PendingPerformScriptTupleSchemeFactory();
    @Nullable
    private String scriptName;
    @Nullable
    private String scriptParam;
    @Nullable
    private String scriptOption;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public PendingPerformScript() {
    }

    public PendingPerformScript(String string, String string2, String string3) {
        this();
        this.scriptName = string;
        this.scriptParam = string2;
        this.scriptOption = string3;
    }

    public PendingPerformScript(PendingPerformScript pendingPerformScript) {
        if (pendingPerformScript.isSetScriptName()) {
            this.scriptName = pendingPerformScript.scriptName;
        }
        if (pendingPerformScript.isSetScriptParam()) {
            this.scriptParam = pendingPerformScript.scriptParam;
        }
        if (pendingPerformScript.isSetScriptOption()) {
            this.scriptOption = pendingPerformScript.scriptOption;
        }
    }

    public PendingPerformScript deepCopy() {
        return new PendingPerformScript(this);
    }

    public void clear() {
        this.scriptName = null;
        this.scriptParam = null;
        this.scriptOption = null;
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
    public String getScriptParam() {
        return this.scriptParam;
    }

    public void setScriptParam(@Nullable String string) {
        this.scriptParam = string;
    }

    public void unsetScriptParam() {
        this.scriptParam = null;
    }

    public boolean isSetScriptParam() {
        return this.scriptParam != null;
    }

    public void setScriptParamIsSet(boolean bl) {
        if (!bl) {
            this.scriptParam = null;
        }
    }

    @Nullable
    public String getScriptOption() {
        return this.scriptOption;
    }

    public void setScriptOption(@Nullable String string) {
        this.scriptOption = string;
    }

    public void unsetScriptOption() {
        this.scriptOption = null;
    }

    public boolean isSetScriptOption() {
        return this.scriptOption != null;
    }

    public void setScriptOptionIsSet(boolean bl) {
        if (!bl) {
            this.scriptOption = null;
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
                    this.unsetScriptParam();
                    break;
                }
                this.setScriptParam((String)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetScriptOption();
                    break;
                }
                this.setScriptOption((String)object);
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
                return this.getScriptParam();
            }
            case 2: {
                return this.getScriptOption();
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
                return this.isSetScriptParam();
            }
            case 2: {
                return this.isSetScriptOption();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof PendingPerformScript) {
            return this.equals((PendingPerformScript)object);
        }
        return false;
    }

    public boolean equals(PendingPerformScript pendingPerformScript) {
        if (pendingPerformScript == null) {
            return false;
        }
        if (this == pendingPerformScript) {
            return true;
        }
        boolean bl = this.isSetScriptName();
        boolean bl2 = pendingPerformScript.isSetScriptName();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.scriptName.equals(pendingPerformScript.scriptName)) {
                return false;
            }
        }
        boolean bl3 = this.isSetScriptParam();
        boolean bl4 = pendingPerformScript.isSetScriptParam();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.scriptParam.equals(pendingPerformScript.scriptParam)) {
                return false;
            }
        }
        boolean bl5 = this.isSetScriptOption();
        boolean bl6 = pendingPerformScript.isSetScriptOption();
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (!this.scriptOption.equals(pendingPerformScript.scriptOption)) {
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
        n = n * 8191 + (this.isSetScriptParam() ? 131071 : 524287);
        if (this.isSetScriptParam()) {
            n = n * 8191 + this.scriptParam.hashCode();
        }
        n = n * 8191 + (this.isSetScriptOption() ? 131071 : 524287);
        if (this.isSetScriptOption()) {
            n = n * 8191 + this.scriptOption.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(PendingPerformScript pendingPerformScript) {
        if (!this.getClass().equals(pendingPerformScript.getClass())) {
            return this.getClass().getName().compareTo(pendingPerformScript.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetScriptName(), pendingPerformScript.isSetScriptName());
        if (n != 0) {
            return n;
        }
        if (this.isSetScriptName() && (n = TBaseHelper.compareTo((String)this.scriptName, (String)pendingPerformScript.scriptName)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetScriptParam(), pendingPerformScript.isSetScriptParam());
        if (n != 0) {
            return n;
        }
        if (this.isSetScriptParam() && (n = TBaseHelper.compareTo((String)this.scriptParam, (String)pendingPerformScript.scriptParam)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetScriptOption(), pendingPerformScript.isSetScriptOption());
        if (n != 0) {
            return n;
        }
        if (this.isSetScriptOption() && (n = TBaseHelper.compareTo((String)this.scriptOption, (String)pendingPerformScript.scriptOption)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        PendingPerformScript.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        PendingPerformScript.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("PendingPerformScript(");
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
        stringBuilder.append("scriptParam:");
        if (this.scriptParam == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.scriptParam);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("scriptOption:");
        if (this.scriptOption == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.scriptOption);
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
        enumMap.put(_Fields.SCRIPT_PARAM, new FieldMetaData("scriptParam", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.SCRIPT_OPTION, new FieldMetaData("scriptOption", 3, new FieldValueMetaData(11)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(PendingPerformScript.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        SCRIPT_NAME(1, "scriptName"),
        SCRIPT_PARAM(2, "scriptParam"),
        SCRIPT_OPTION(3, "scriptOption");

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
                    return SCRIPT_PARAM;
                }
                case 3: {
                    return SCRIPT_OPTION;
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

    private static class PendingPerformScriptStandardSchemeFactory
    implements SchemeFactory {
        private PendingPerformScriptStandardSchemeFactory() {
        }

        public PendingPerformScriptStandardScheme getScheme() {
            return new PendingPerformScriptStandardScheme();
        }
    }

    private static class PendingPerformScriptTupleSchemeFactory
    implements SchemeFactory {
        private PendingPerformScriptTupleSchemeFactory() {
        }

        public PendingPerformScriptTupleScheme getScheme() {
            return new PendingPerformScriptTupleScheme();
        }
    }

    private static class PendingPerformScriptTupleScheme
    extends TupleScheme<PendingPerformScript> {
        private PendingPerformScriptTupleScheme() {
        }

        public void write(TProtocol tProtocol, PendingPerformScript pendingPerformScript) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (pendingPerformScript.isSetScriptName()) {
                bitSet.set(0);
            }
            if (pendingPerformScript.isSetScriptParam()) {
                bitSet.set(1);
            }
            if (pendingPerformScript.isSetScriptOption()) {
                bitSet.set(2);
            }
            tTupleProtocol.writeBitSet(bitSet, 3);
            if (pendingPerformScript.isSetScriptName()) {
                tTupleProtocol.writeString(pendingPerformScript.scriptName);
            }
            if (pendingPerformScript.isSetScriptParam()) {
                tTupleProtocol.writeString(pendingPerformScript.scriptParam);
            }
            if (pendingPerformScript.isSetScriptOption()) {
                tTupleProtocol.writeString(pendingPerformScript.scriptOption);
            }
        }

        public void read(TProtocol tProtocol, PendingPerformScript pendingPerformScript) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(3);
            if (bitSet.get(0)) {
                pendingPerformScript.scriptName = tTupleProtocol.readString();
                pendingPerformScript.setScriptNameIsSet(true);
            }
            if (bitSet.get(1)) {
                pendingPerformScript.scriptParam = tTupleProtocol.readString();
                pendingPerformScript.setScriptParamIsSet(true);
            }
            if (bitSet.get(2)) {
                pendingPerformScript.scriptOption = tTupleProtocol.readString();
                pendingPerformScript.setScriptOptionIsSet(true);
            }
        }
    }

    private static class PendingPerformScriptStandardScheme
    extends StandardScheme<PendingPerformScript> {
        private PendingPerformScriptStandardScheme() {
        }

        public void read(TProtocol tProtocol, PendingPerformScript pendingPerformScript) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 11) {
                            pendingPerformScript.scriptName = tProtocol.readString();
                            pendingPerformScript.setScriptNameIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 11) {
                            pendingPerformScript.scriptParam = tProtocol.readString();
                            pendingPerformScript.setScriptParamIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 11) {
                            pendingPerformScript.scriptOption = tProtocol.readString();
                            pendingPerformScript.setScriptOptionIsSet(true);
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
            pendingPerformScript.validate();
        }

        public void write(TProtocol tProtocol, PendingPerformScript pendingPerformScript) throws TException {
            pendingPerformScript.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (pendingPerformScript.scriptName != null) {
                tProtocol.writeFieldBegin(SCRIPT_NAME_FIELD_DESC);
                tProtocol.writeString(pendingPerformScript.scriptName);
                tProtocol.writeFieldEnd();
            }
            if (pendingPerformScript.scriptParam != null) {
                tProtocol.writeFieldBegin(SCRIPT_PARAM_FIELD_DESC);
                tProtocol.writeString(pendingPerformScript.scriptParam);
                tProtocol.writeFieldEnd();
            }
            if (pendingPerformScript.scriptOption != null) {
                tProtocol.writeFieldBegin(SCRIPT_OPTION_FIELD_DESC);
                tProtocol.writeString(pendingPerformScript.scriptOption);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

