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
 *  org.apache.thrift.meta_data.ListMetaData
 *  org.apache.thrift.protocol.TCompactProtocol
 *  org.apache.thrift.protocol.TField
 *  org.apache.thrift.protocol.TList
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
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.thrift.TBase;
import org.apache.thrift.TBaseHelper;
import org.apache.thrift.TException;
import org.apache.thrift.TFieldIdEnum;
import org.apache.thrift.annotation.Nullable;
import org.apache.thrift.meta_data.FieldMetaData;
import org.apache.thrift.meta_data.FieldValueMetaData;
import org.apache.thrift.meta_data.ListMetaData;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TList;
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

public class PerformWebScriptNotification
implements TBase<PerformWebScriptNotification, _Fields>,
Serializable,
Cloneable,
Comparable<PerformWebScriptNotification> {
    private static final TStruct STRUCT_DESC = new TStruct("PerformWebScriptNotification");
    private static final TField OBJECT_NAME_FIELD_DESC = new TField("objectName", 11, 1);
    private static final TField METHOD_NAME_FIELD_DESC = new TField("methodName", 11, 2);
    private static final TField PARAMETERS_FIELD_DESC = new TField("parameters", 15, 3);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new PerformWebScriptNotificationStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new PerformWebScriptNotificationTupleSchemeFactory();
    @Nullable
    private String objectName;
    @Nullable
    private String methodName;
    @Nullable
    private List<String> parameters;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public PerformWebScriptNotification() {
    }

    public PerformWebScriptNotification(String string, String string2, List<String> list) {
        this();
        this.objectName = string;
        this.methodName = string2;
        this.parameters = list;
    }

    public PerformWebScriptNotification(PerformWebScriptNotification performWebScriptNotification) {
        if (performWebScriptNotification.isSetObjectName()) {
            this.objectName = performWebScriptNotification.objectName;
        }
        if (performWebScriptNotification.isSetMethodName()) {
            this.methodName = performWebScriptNotification.methodName;
        }
        if (performWebScriptNotification.isSetParameters()) {
            ArrayList<String> arrayList = new ArrayList<String>(performWebScriptNotification.parameters);
            this.parameters = arrayList;
        }
    }

    public PerformWebScriptNotification deepCopy() {
        return new PerformWebScriptNotification(this);
    }

    public void clear() {
        this.objectName = null;
        this.methodName = null;
        this.parameters = null;
    }

    @Nullable
    public String getObjectName() {
        return this.objectName;
    }

    public void setObjectName(@Nullable String string) {
        this.objectName = string;
    }

    public void unsetObjectName() {
        this.objectName = null;
    }

    public boolean isSetObjectName() {
        return this.objectName != null;
    }

    public void setObjectNameIsSet(boolean bl) {
        if (!bl) {
            this.objectName = null;
        }
    }

    @Nullable
    public String getMethodName() {
        return this.methodName;
    }

    public void setMethodName(@Nullable String string) {
        this.methodName = string;
    }

    public void unsetMethodName() {
        this.methodName = null;
    }

    public boolean isSetMethodName() {
        return this.methodName != null;
    }

    public void setMethodNameIsSet(boolean bl) {
        if (!bl) {
            this.methodName = null;
        }
    }

    public int getParametersSize() {
        return this.parameters == null ? 0 : this.parameters.size();
    }

    @Nullable
    public Iterator<String> getParametersIterator() {
        return this.parameters == null ? null : this.parameters.iterator();
    }

    public void addToParameters(String string) {
        if (this.parameters == null) {
            this.parameters = new ArrayList<String>();
        }
        this.parameters.add(string);
    }

    @Nullable
    public List<String> getParameters() {
        return this.parameters;
    }

    public void setParameters(@Nullable List<String> list) {
        this.parameters = list;
    }

    public void unsetParameters() {
        this.parameters = null;
    }

    public boolean isSetParameters() {
        return this.parameters != null;
    }

    public void setParametersIsSet(boolean bl) {
        if (!bl) {
            this.parameters = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetObjectName();
                    break;
                }
                this.setObjectName((String)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetMethodName();
                    break;
                }
                this.setMethodName((String)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetParameters();
                    break;
                }
                this.setParameters((List)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getObjectName();
            }
            case 1: {
                return this.getMethodName();
            }
            case 2: {
                return this.getParameters();
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
                return this.isSetObjectName();
            }
            case 1: {
                return this.isSetMethodName();
            }
            case 2: {
                return this.isSetParameters();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof PerformWebScriptNotification) {
            return this.equals((PerformWebScriptNotification)object);
        }
        return false;
    }

    public boolean equals(PerformWebScriptNotification performWebScriptNotification) {
        if (performWebScriptNotification == null) {
            return false;
        }
        if (this == performWebScriptNotification) {
            return true;
        }
        boolean bl = this.isSetObjectName();
        boolean bl2 = performWebScriptNotification.isSetObjectName();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.objectName.equals(performWebScriptNotification.objectName)) {
                return false;
            }
        }
        boolean bl3 = this.isSetMethodName();
        boolean bl4 = performWebScriptNotification.isSetMethodName();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.methodName.equals(performWebScriptNotification.methodName)) {
                return false;
            }
        }
        boolean bl5 = this.isSetParameters();
        boolean bl6 = performWebScriptNotification.isSetParameters();
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (!this.parameters.equals(performWebScriptNotification.parameters)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetObjectName() ? 131071 : 524287);
        if (this.isSetObjectName()) {
            n = n * 8191 + this.objectName.hashCode();
        }
        n = n * 8191 + (this.isSetMethodName() ? 131071 : 524287);
        if (this.isSetMethodName()) {
            n = n * 8191 + this.methodName.hashCode();
        }
        n = n * 8191 + (this.isSetParameters() ? 131071 : 524287);
        if (this.isSetParameters()) {
            n = n * 8191 + this.parameters.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(PerformWebScriptNotification performWebScriptNotification) {
        if (!this.getClass().equals(performWebScriptNotification.getClass())) {
            return this.getClass().getName().compareTo(performWebScriptNotification.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetObjectName(), performWebScriptNotification.isSetObjectName());
        if (n != 0) {
            return n;
        }
        if (this.isSetObjectName() && (n = TBaseHelper.compareTo((String)this.objectName, (String)performWebScriptNotification.objectName)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetMethodName(), performWebScriptNotification.isSetMethodName());
        if (n != 0) {
            return n;
        }
        if (this.isSetMethodName() && (n = TBaseHelper.compareTo((String)this.methodName, (String)performWebScriptNotification.methodName)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetParameters(), performWebScriptNotification.isSetParameters());
        if (n != 0) {
            return n;
        }
        if (this.isSetParameters() && (n = TBaseHelper.compareTo(this.parameters, performWebScriptNotification.parameters)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        PerformWebScriptNotification.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        PerformWebScriptNotification.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("PerformWebScriptNotification(");
        boolean bl = true;
        stringBuilder.append("objectName:");
        if (this.objectName == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.objectName);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("methodName:");
        if (this.methodName == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.methodName);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("parameters:");
        if (this.parameters == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.parameters);
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
        enumMap.put(_Fields.OBJECT_NAME, new FieldMetaData("objectName", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.METHOD_NAME, new FieldMetaData("methodName", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.PARAMETERS, new FieldMetaData("parameters", 3, (FieldValueMetaData)new ListMetaData(15, new FieldValueMetaData(11))));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(PerformWebScriptNotification.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        OBJECT_NAME(1, "objectName"),
        METHOD_NAME(2, "methodName"),
        PARAMETERS(3, "parameters");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return OBJECT_NAME;
                }
                case 2: {
                    return METHOD_NAME;
                }
                case 3: {
                    return PARAMETERS;
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

    private static class PerformWebScriptNotificationStandardSchemeFactory
    implements SchemeFactory {
        private PerformWebScriptNotificationStandardSchemeFactory() {
        }

        public PerformWebScriptNotificationStandardScheme getScheme() {
            return new PerformWebScriptNotificationStandardScheme();
        }
    }

    private static class PerformWebScriptNotificationTupleSchemeFactory
    implements SchemeFactory {
        private PerformWebScriptNotificationTupleSchemeFactory() {
        }

        public PerformWebScriptNotificationTupleScheme getScheme() {
            return new PerformWebScriptNotificationTupleScheme();
        }
    }

    private static class PerformWebScriptNotificationTupleScheme
    extends TupleScheme<PerformWebScriptNotification> {
        private PerformWebScriptNotificationTupleScheme() {
        }

        public void write(TProtocol tProtocol, PerformWebScriptNotification performWebScriptNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (performWebScriptNotification.isSetObjectName()) {
                bitSet.set(0);
            }
            if (performWebScriptNotification.isSetMethodName()) {
                bitSet.set(1);
            }
            if (performWebScriptNotification.isSetParameters()) {
                bitSet.set(2);
            }
            tTupleProtocol.writeBitSet(bitSet, 3);
            if (performWebScriptNotification.isSetObjectName()) {
                tTupleProtocol.writeString(performWebScriptNotification.objectName);
            }
            if (performWebScriptNotification.isSetMethodName()) {
                tTupleProtocol.writeString(performWebScriptNotification.methodName);
            }
            if (performWebScriptNotification.isSetParameters()) {
                tTupleProtocol.writeI32(performWebScriptNotification.parameters.size());
                for (String string : performWebScriptNotification.parameters) {
                    tTupleProtocol.writeString(string);
                }
            }
        }

        public void read(TProtocol tProtocol, PerformWebScriptNotification performWebScriptNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(3);
            if (bitSet.get(0)) {
                performWebScriptNotification.objectName = tTupleProtocol.readString();
                performWebScriptNotification.setObjectNameIsSet(true);
            }
            if (bitSet.get(1)) {
                performWebScriptNotification.methodName = tTupleProtocol.readString();
                performWebScriptNotification.setMethodNameIsSet(true);
            }
            if (bitSet.get(2)) {
                TList tList = tTupleProtocol.readListBegin((byte)11);
                performWebScriptNotification.parameters = new ArrayList<String>(tList.size);
                for (int i = 0; i < tList.size; ++i) {
                    String string = tTupleProtocol.readString();
                    performWebScriptNotification.parameters.add(string);
                }
                performWebScriptNotification.setParametersIsSet(true);
            }
        }
    }

    private static class PerformWebScriptNotificationStandardScheme
    extends StandardScheme<PerformWebScriptNotification> {
        private PerformWebScriptNotificationStandardScheme() {
        }

        public void read(TProtocol tProtocol, PerformWebScriptNotification performWebScriptNotification) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 11) {
                            performWebScriptNotification.objectName = tProtocol.readString();
                            performWebScriptNotification.setObjectNameIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 11) {
                            performWebScriptNotification.methodName = tProtocol.readString();
                            performWebScriptNotification.setMethodNameIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 15) {
                            TList tList = tProtocol.readListBegin();
                            performWebScriptNotification.parameters = new ArrayList<String>(tList.size);
                            for (int i = 0; i < tList.size; ++i) {
                                String string = tProtocol.readString();
                                performWebScriptNotification.parameters.add(string);
                            }
                            tProtocol.readListEnd();
                            performWebScriptNotification.setParametersIsSet(true);
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
            performWebScriptNotification.validate();
        }

        public void write(TProtocol tProtocol, PerformWebScriptNotification performWebScriptNotification) throws TException {
            performWebScriptNotification.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (performWebScriptNotification.objectName != null) {
                tProtocol.writeFieldBegin(OBJECT_NAME_FIELD_DESC);
                tProtocol.writeString(performWebScriptNotification.objectName);
                tProtocol.writeFieldEnd();
            }
            if (performWebScriptNotification.methodName != null) {
                tProtocol.writeFieldBegin(METHOD_NAME_FIELD_DESC);
                tProtocol.writeString(performWebScriptNotification.methodName);
                tProtocol.writeFieldEnd();
            }
            if (performWebScriptNotification.parameters != null) {
                tProtocol.writeFieldBegin(PARAMETERS_FIELD_DESC);
                tProtocol.writeListBegin(new TList(11, performWebScriptNotification.parameters.size()));
                for (String string : performWebScriptNotification.parameters) {
                    tProtocol.writeString(string);
                }
                tProtocol.writeListEnd();
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

