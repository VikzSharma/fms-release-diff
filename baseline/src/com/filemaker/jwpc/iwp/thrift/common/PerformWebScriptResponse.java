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
 *  org.apache.thrift.meta_data.ListMetaData
 *  org.apache.thrift.meta_data.StructMetaData
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
package com.filemaker.jwpc.iwp.thrift.common;

import com.filemaker.jwpc.iwp.thrift.common.PendingPerformScript;
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
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TBase;
import org.apache.thrift.TBaseHelper;
import org.apache.thrift.TException;
import org.apache.thrift.TFieldIdEnum;
import org.apache.thrift.annotation.Nullable;
import org.apache.thrift.meta_data.FieldMetaData;
import org.apache.thrift.meta_data.FieldValueMetaData;
import org.apache.thrift.meta_data.ListMetaData;
import org.apache.thrift.meta_data.StructMetaData;
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

public class PerformWebScriptResponse
implements TBase<PerformWebScriptResponse, _Fields>,
Serializable,
Cloneable,
Comparable<PerformWebScriptResponse> {
    private static final TStruct STRUCT_DESC = new TStruct("PerformWebScriptResponse");
    private static final TField METHOD_NAME_FIELD_DESC = new TField("methodName", 11, 1);
    private static final TField SUCCESS_FIELD_DESC = new TField("success", 2, 2);
    private static final TField RESULT_FIELD_DESC = new TField("result", 11, 3);
    private static final TField PENDING_REQUESTS_FIELD_DESC = new TField("pendingRequests", 15, 4);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new PerformWebScriptResponseStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new PerformWebScriptResponseTupleSchemeFactory();
    @Nullable
    private String methodName;
    private boolean success;
    @Nullable
    private String result;
    @Nullable
    private List<PendingPerformScript> pendingRequests;
    private static final int __SUCCESS_ISSET_ID = 0;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public PerformWebScriptResponse() {
    }

    public PerformWebScriptResponse(String string, boolean bl, String string2, List<PendingPerformScript> list) {
        this();
        this.methodName = string;
        this.success = bl;
        this.setSuccessIsSet(true);
        this.result = string2;
        this.pendingRequests = list;
    }

    public PerformWebScriptResponse(PerformWebScriptResponse performWebScriptResponse) {
        this.__isset_bitfield = performWebScriptResponse.__isset_bitfield;
        if (performWebScriptResponse.isSetMethodName()) {
            this.methodName = performWebScriptResponse.methodName;
        }
        this.success = performWebScriptResponse.success;
        if (performWebScriptResponse.isSetResult()) {
            this.result = performWebScriptResponse.result;
        }
        if (performWebScriptResponse.isSetPendingRequests()) {
            ArrayList<PendingPerformScript> arrayList = new ArrayList<PendingPerformScript>(performWebScriptResponse.pendingRequests.size());
            for (PendingPerformScript pendingPerformScript : performWebScriptResponse.pendingRequests) {
                arrayList.add(new PendingPerformScript(pendingPerformScript));
            }
            this.pendingRequests = arrayList;
        }
    }

    public PerformWebScriptResponse deepCopy() {
        return new PerformWebScriptResponse(this);
    }

    public void clear() {
        this.methodName = null;
        this.setSuccessIsSet(false);
        this.success = false;
        this.result = null;
        this.pendingRequests = null;
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

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean bl) {
        this.success = bl;
        this.setSuccessIsSet(true);
    }

    public void unsetSuccess() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetSuccess() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setSuccessIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    @Nullable
    public String getResult() {
        return this.result;
    }

    public void setResult(@Nullable String string) {
        this.result = string;
    }

    public void unsetResult() {
        this.result = null;
    }

    public boolean isSetResult() {
        return this.result != null;
    }

    public void setResultIsSet(boolean bl) {
        if (!bl) {
            this.result = null;
        }
    }

    public int getPendingRequestsSize() {
        return this.pendingRequests == null ? 0 : this.pendingRequests.size();
    }

    @Nullable
    public Iterator<PendingPerformScript> getPendingRequestsIterator() {
        return this.pendingRequests == null ? null : this.pendingRequests.iterator();
    }

    public void addToPendingRequests(PendingPerformScript pendingPerformScript) {
        if (this.pendingRequests == null) {
            this.pendingRequests = new ArrayList<PendingPerformScript>();
        }
        this.pendingRequests.add(pendingPerformScript);
    }

    @Nullable
    public List<PendingPerformScript> getPendingRequests() {
        return this.pendingRequests;
    }

    public void setPendingRequests(@Nullable List<PendingPerformScript> list) {
        this.pendingRequests = list;
    }

    public void unsetPendingRequests() {
        this.pendingRequests = null;
    }

    public boolean isSetPendingRequests() {
        return this.pendingRequests != null;
    }

    public void setPendingRequestsIsSet(boolean bl) {
        if (!bl) {
            this.pendingRequests = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetMethodName();
                    break;
                }
                this.setMethodName((String)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetSuccess();
                    break;
                }
                this.setSuccess((Boolean)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetResult();
                    break;
                }
                this.setResult((String)object);
                break;
            }
            case 3: {
                if (object == null) {
                    this.unsetPendingRequests();
                    break;
                }
                this.setPendingRequests((List)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getMethodName();
            }
            case 1: {
                return this.isSuccess();
            }
            case 2: {
                return this.getResult();
            }
            case 3: {
                return this.getPendingRequests();
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
                return this.isSetMethodName();
            }
            case 1: {
                return this.isSetSuccess();
            }
            case 2: {
                return this.isSetResult();
            }
            case 3: {
                return this.isSetPendingRequests();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof PerformWebScriptResponse) {
            return this.equals((PerformWebScriptResponse)object);
        }
        return false;
    }

    public boolean equals(PerformWebScriptResponse performWebScriptResponse) {
        if (performWebScriptResponse == null) {
            return false;
        }
        if (this == performWebScriptResponse) {
            return true;
        }
        boolean bl = this.isSetMethodName();
        boolean bl2 = performWebScriptResponse.isSetMethodName();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.methodName.equals(performWebScriptResponse.methodName)) {
                return false;
            }
        }
        boolean bl3 = true;
        boolean bl4 = true;
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (this.success != performWebScriptResponse.success) {
                return false;
            }
        }
        boolean bl5 = this.isSetResult();
        boolean bl6 = performWebScriptResponse.isSetResult();
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (!this.result.equals(performWebScriptResponse.result)) {
                return false;
            }
        }
        boolean bl7 = this.isSetPendingRequests();
        boolean bl8 = performWebScriptResponse.isSetPendingRequests();
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (!this.pendingRequests.equals(performWebScriptResponse.pendingRequests)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetMethodName() ? 131071 : 524287);
        if (this.isSetMethodName()) {
            n = n * 8191 + this.methodName.hashCode();
        }
        n = n * 8191 + (this.success ? 131071 : 524287);
        n = n * 8191 + (this.isSetResult() ? 131071 : 524287);
        if (this.isSetResult()) {
            n = n * 8191 + this.result.hashCode();
        }
        n = n * 8191 + (this.isSetPendingRequests() ? 131071 : 524287);
        if (this.isSetPendingRequests()) {
            n = n * 8191 + this.pendingRequests.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(PerformWebScriptResponse performWebScriptResponse) {
        if (!this.getClass().equals(performWebScriptResponse.getClass())) {
            return this.getClass().getName().compareTo(performWebScriptResponse.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetMethodName(), performWebScriptResponse.isSetMethodName());
        if (n != 0) {
            return n;
        }
        if (this.isSetMethodName() && (n = TBaseHelper.compareTo((String)this.methodName, (String)performWebScriptResponse.methodName)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetSuccess(), performWebScriptResponse.isSetSuccess());
        if (n != 0) {
            return n;
        }
        if (this.isSetSuccess() && (n = TBaseHelper.compareTo((boolean)this.success, (boolean)performWebScriptResponse.success)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetResult(), performWebScriptResponse.isSetResult());
        if (n != 0) {
            return n;
        }
        if (this.isSetResult() && (n = TBaseHelper.compareTo((String)this.result, (String)performWebScriptResponse.result)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetPendingRequests(), performWebScriptResponse.isSetPendingRequests());
        if (n != 0) {
            return n;
        }
        if (this.isSetPendingRequests() && (n = TBaseHelper.compareTo(this.pendingRequests, performWebScriptResponse.pendingRequests)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        PerformWebScriptResponse.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        PerformWebScriptResponse.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("PerformWebScriptResponse(");
        boolean bl = true;
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
        stringBuilder.append("success:");
        stringBuilder.append(this.success);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("result:");
        if (this.result == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.result);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("pendingRequests:");
        if (this.pendingRequests == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.pendingRequests);
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
        enumMap.put(_Fields.METHOD_NAME, new FieldMetaData("methodName", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.SUCCESS, new FieldMetaData("success", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.RESULT, new FieldMetaData("result", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.PENDING_REQUESTS, new FieldMetaData("pendingRequests", 3, (FieldValueMetaData)new ListMetaData(15, (FieldValueMetaData)new StructMetaData(12, PendingPerformScript.class))));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(PerformWebScriptResponse.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        METHOD_NAME(1, "methodName"),
        SUCCESS(2, "success"),
        RESULT(3, "result"),
        PENDING_REQUESTS(4, "pendingRequests");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return METHOD_NAME;
                }
                case 2: {
                    return SUCCESS;
                }
                case 3: {
                    return RESULT;
                }
                case 4: {
                    return PENDING_REQUESTS;
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

    private static class PerformWebScriptResponseStandardSchemeFactory
    implements SchemeFactory {
        private PerformWebScriptResponseStandardSchemeFactory() {
        }

        public PerformWebScriptResponseStandardScheme getScheme() {
            return new PerformWebScriptResponseStandardScheme();
        }
    }

    private static class PerformWebScriptResponseTupleSchemeFactory
    implements SchemeFactory {
        private PerformWebScriptResponseTupleSchemeFactory() {
        }

        public PerformWebScriptResponseTupleScheme getScheme() {
            return new PerformWebScriptResponseTupleScheme();
        }
    }

    private static class PerformWebScriptResponseTupleScheme
    extends TupleScheme<PerformWebScriptResponse> {
        private PerformWebScriptResponseTupleScheme() {
        }

        public void write(TProtocol tProtocol, PerformWebScriptResponse performWebScriptResponse) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (performWebScriptResponse.isSetMethodName()) {
                bitSet.set(0);
            }
            if (performWebScriptResponse.isSetSuccess()) {
                bitSet.set(1);
            }
            if (performWebScriptResponse.isSetResult()) {
                bitSet.set(2);
            }
            if (performWebScriptResponse.isSetPendingRequests()) {
                bitSet.set(3);
            }
            tTupleProtocol.writeBitSet(bitSet, 4);
            if (performWebScriptResponse.isSetMethodName()) {
                tTupleProtocol.writeString(performWebScriptResponse.methodName);
            }
            if (performWebScriptResponse.isSetSuccess()) {
                tTupleProtocol.writeBool(performWebScriptResponse.success);
            }
            if (performWebScriptResponse.isSetResult()) {
                tTupleProtocol.writeString(performWebScriptResponse.result);
            }
            if (performWebScriptResponse.isSetPendingRequests()) {
                tTupleProtocol.writeI32(performWebScriptResponse.pendingRequests.size());
                for (PendingPerformScript pendingPerformScript : performWebScriptResponse.pendingRequests) {
                    pendingPerformScript.write((TProtocol)tTupleProtocol);
                }
            }
        }

        public void read(TProtocol tProtocol, PerformWebScriptResponse performWebScriptResponse) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(4);
            if (bitSet.get(0)) {
                performWebScriptResponse.methodName = tTupleProtocol.readString();
                performWebScriptResponse.setMethodNameIsSet(true);
            }
            if (bitSet.get(1)) {
                performWebScriptResponse.success = tTupleProtocol.readBool();
                performWebScriptResponse.setSuccessIsSet(true);
            }
            if (bitSet.get(2)) {
                performWebScriptResponse.result = tTupleProtocol.readString();
                performWebScriptResponse.setResultIsSet(true);
            }
            if (bitSet.get(3)) {
                TList tList = tTupleProtocol.readListBegin((byte)12);
                performWebScriptResponse.pendingRequests = new ArrayList<PendingPerformScript>(tList.size);
                for (int i = 0; i < tList.size; ++i) {
                    PendingPerformScript pendingPerformScript = new PendingPerformScript();
                    pendingPerformScript.read((TProtocol)tTupleProtocol);
                    performWebScriptResponse.pendingRequests.add(pendingPerformScript);
                }
                performWebScriptResponse.setPendingRequestsIsSet(true);
            }
        }
    }

    private static class PerformWebScriptResponseStandardScheme
    extends StandardScheme<PerformWebScriptResponse> {
        private PerformWebScriptResponseStandardScheme() {
        }

        public void read(TProtocol tProtocol, PerformWebScriptResponse performWebScriptResponse) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 11) {
                            performWebScriptResponse.methodName = tProtocol.readString();
                            performWebScriptResponse.setMethodNameIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 2) {
                            performWebScriptResponse.success = tProtocol.readBool();
                            performWebScriptResponse.setSuccessIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 11) {
                            performWebScriptResponse.result = tProtocol.readString();
                            performWebScriptResponse.setResultIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 15) {
                            TList tList = tProtocol.readListBegin();
                            performWebScriptResponse.pendingRequests = new ArrayList<PendingPerformScript>(tList.size);
                            for (int i = 0; i < tList.size; ++i) {
                                PendingPerformScript pendingPerformScript = new PendingPerformScript();
                                pendingPerformScript.read(tProtocol);
                                performWebScriptResponse.pendingRequests.add(pendingPerformScript);
                            }
                            tProtocol.readListEnd();
                            performWebScriptResponse.setPendingRequestsIsSet(true);
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
            performWebScriptResponse.validate();
        }

        public void write(TProtocol tProtocol, PerformWebScriptResponse performWebScriptResponse) throws TException {
            performWebScriptResponse.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (performWebScriptResponse.methodName != null) {
                tProtocol.writeFieldBegin(METHOD_NAME_FIELD_DESC);
                tProtocol.writeString(performWebScriptResponse.methodName);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(SUCCESS_FIELD_DESC);
            tProtocol.writeBool(performWebScriptResponse.success);
            tProtocol.writeFieldEnd();
            if (performWebScriptResponse.result != null) {
                tProtocol.writeFieldBegin(RESULT_FIELD_DESC);
                tProtocol.writeString(performWebScriptResponse.result);
                tProtocol.writeFieldEnd();
            }
            if (performWebScriptResponse.pendingRequests != null) {
                tProtocol.writeFieldBegin(PENDING_REQUESTS_FIELD_DESC);
                tProtocol.writeListBegin(new TList(12, performWebScriptResponse.pendingRequests.size()));
                for (PendingPerformScript pendingPerformScript : performWebScriptResponse.pendingRequests) {
                    pendingPerformScript.write(tProtocol);
                }
                tProtocol.writeListEnd();
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

