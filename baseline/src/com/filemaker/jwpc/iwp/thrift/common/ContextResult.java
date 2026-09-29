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
package com.filemaker.jwpc.iwp.thrift.common;

import com.filemaker.jwpc.iwp.thrift.common.IWPError;
import com.filemaker.jwpc.iwp.thrift.context.Context;
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

public class ContextResult
implements TBase<ContextResult, _Fields>,
Serializable,
Cloneable,
Comparable<ContextResult> {
    private static final TStruct STRUCT_DESC = new TStruct("ContextResult");
    private static final TField CONTEXT_FIELD_DESC = new TField("context", 12, 1);
    private static final TField ERROR_FIELD_DESC = new TField("error", 12, 2);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new ContextResultStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new ContextResultTupleSchemeFactory();
    @Nullable
    private Context context;
    @Nullable
    private IWPError error;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public ContextResult() {
    }

    public ContextResult(Context context, IWPError iWPError) {
        this();
        this.context = context;
        this.error = iWPError;
    }

    public ContextResult(ContextResult contextResult) {
        if (contextResult.isSetContext()) {
            this.context = new Context(contextResult.context);
        }
        if (contextResult.isSetError()) {
            this.error = new IWPError(contextResult.error);
        }
    }

    public ContextResult deepCopy() {
        return new ContextResult(this);
    }

    public void clear() {
        this.context = null;
        this.error = null;
    }

    @Nullable
    public Context getContext() {
        return this.context;
    }

    public void setContext(@Nullable Context context) {
        this.context = context;
    }

    public void unsetContext() {
        this.context = null;
    }

    public boolean isSetContext() {
        return this.context != null;
    }

    public void setContextIsSet(boolean bl) {
        if (!bl) {
            this.context = null;
        }
    }

    @Nullable
    public IWPError getError() {
        return this.error;
    }

    public void setError(@Nullable IWPError iWPError) {
        this.error = iWPError;
    }

    public void unsetError() {
        this.error = null;
    }

    public boolean isSetError() {
        return this.error != null;
    }

    public void setErrorIsSet(boolean bl) {
        if (!bl) {
            this.error = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetContext();
                    break;
                }
                this.setContext((Context)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetError();
                    break;
                }
                this.setError((IWPError)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getContext();
            }
            case 1: {
                return this.getError();
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
                return this.isSetContext();
            }
            case 1: {
                return this.isSetError();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof ContextResult) {
            return this.equals((ContextResult)object);
        }
        return false;
    }

    public boolean equals(ContextResult contextResult) {
        if (contextResult == null) {
            return false;
        }
        if (this == contextResult) {
            return true;
        }
        boolean bl = this.isSetContext();
        boolean bl2 = contextResult.isSetContext();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.context.equals(contextResult.context)) {
                return false;
            }
        }
        boolean bl3 = this.isSetError();
        boolean bl4 = contextResult.isSetError();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.error.equals(contextResult.error)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetContext() ? 131071 : 524287);
        if (this.isSetContext()) {
            n = n * 8191 + this.context.hashCode();
        }
        n = n * 8191 + (this.isSetError() ? 131071 : 524287);
        if (this.isSetError()) {
            n = n * 8191 + this.error.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(ContextResult contextResult) {
        if (!this.getClass().equals(contextResult.getClass())) {
            return this.getClass().getName().compareTo(contextResult.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetContext(), contextResult.isSetContext());
        if (n != 0) {
            return n;
        }
        if (this.isSetContext() && (n = TBaseHelper.compareTo((Comparable)this.context, (Comparable)contextResult.context)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetError(), contextResult.isSetError());
        if (n != 0) {
            return n;
        }
        if (this.isSetError() && (n = TBaseHelper.compareTo((Comparable)this.error, (Comparable)contextResult.error)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        ContextResult.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        ContextResult.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ContextResult(");
        boolean bl = true;
        stringBuilder.append("context:");
        if (this.context == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.context);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("error:");
        if (this.error == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.error);
        }
        bl = false;
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void validate() throws TException {
        if (this.context != null) {
            this.context.validate();
        }
        if (this.error != null) {
            this.error.validate();
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
        enumMap.put(_Fields.CONTEXT, new FieldMetaData("context", 3, (FieldValueMetaData)new StructMetaData(12, Context.class)));
        enumMap.put(_Fields.ERROR, new FieldMetaData("error", 3, (FieldValueMetaData)new StructMetaData(12, IWPError.class)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(ContextResult.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        CONTEXT(1, "context"),
        ERROR(2, "error");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return CONTEXT;
                }
                case 2: {
                    return ERROR;
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

    private static class ContextResultStandardSchemeFactory
    implements SchemeFactory {
        private ContextResultStandardSchemeFactory() {
        }

        public ContextResultStandardScheme getScheme() {
            return new ContextResultStandardScheme();
        }
    }

    private static class ContextResultTupleSchemeFactory
    implements SchemeFactory {
        private ContextResultTupleSchemeFactory() {
        }

        public ContextResultTupleScheme getScheme() {
            return new ContextResultTupleScheme();
        }
    }

    private static class ContextResultTupleScheme
    extends TupleScheme<ContextResult> {
        private ContextResultTupleScheme() {
        }

        public void write(TProtocol tProtocol, ContextResult contextResult) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (contextResult.isSetContext()) {
                bitSet.set(0);
            }
            if (contextResult.isSetError()) {
                bitSet.set(1);
            }
            tTupleProtocol.writeBitSet(bitSet, 2);
            if (contextResult.isSetContext()) {
                contextResult.context.write((TProtocol)tTupleProtocol);
            }
            if (contextResult.isSetError()) {
                contextResult.error.write((TProtocol)tTupleProtocol);
            }
        }

        public void read(TProtocol tProtocol, ContextResult contextResult) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(2);
            if (bitSet.get(0)) {
                contextResult.context = new Context();
                contextResult.context.read((TProtocol)tTupleProtocol);
                contextResult.setContextIsSet(true);
            }
            if (bitSet.get(1)) {
                contextResult.error = new IWPError();
                contextResult.error.read((TProtocol)tTupleProtocol);
                contextResult.setErrorIsSet(true);
            }
        }
    }

    private static class ContextResultStandardScheme
    extends StandardScheme<ContextResult> {
        private ContextResultStandardScheme() {
        }

        public void read(TProtocol tProtocol, ContextResult contextResult) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 12) {
                            contextResult.context = new Context();
                            contextResult.context.read(tProtocol);
                            contextResult.setContextIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 12) {
                            contextResult.error = new IWPError();
                            contextResult.error.read(tProtocol);
                            contextResult.setErrorIsSet(true);
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
            contextResult.validate();
        }

        public void write(TProtocol tProtocol, ContextResult contextResult) throws TException {
            contextResult.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (contextResult.context != null) {
                tProtocol.writeFieldBegin(CONTEXT_FIELD_DESC);
                contextResult.context.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            if (contextResult.error != null) {
                tProtocol.writeFieldBegin(ERROR_FIELD_DESC);
                contextResult.error.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

