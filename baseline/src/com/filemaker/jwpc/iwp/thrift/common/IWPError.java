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
 *  org.apache.thrift.meta_data.MapMetaData
 *  org.apache.thrift.meta_data.StructMetaData
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

import com.filemaker.jwpc.iwp.thrift.common.Attribute;
import com.filemaker.jwpc.iwp.thrift.common.ObjectSpec;
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
import org.apache.thrift.meta_data.MapMetaData;
import org.apache.thrift.meta_data.StructMetaData;
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

public class IWPError
implements TBase<IWPError, _Fields>,
Serializable,
Cloneable,
Comparable<IWPError> {
    private static final TStruct STRUCT_DESC = new TStruct("IWPError");
    private static final TField ERROR_CODE_FIELD_DESC = new TField("errorCode", 8, 1);
    private static final TField EXTENDED_ERROR_CODE_FIELD_DESC = new TField("extendedErrorCode", 8, 2);
    private static final TField HAS_EXTENDED_ERROR_FIELD_DESC = new TField("hasExtendedError", 2, 3);
    private static final TField OBJECT_SPEC_FIELD_DESC = new TField("objectSpec", 12, 4);
    private static final TField MESSAGE_FIELD_DESC = new TField("message", 11, 5);
    private static final TField ERROR_ATTRIBUTES_FIELD_DESC = new TField("errorAttributes", 13, 6);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new IWPErrorStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new IWPErrorTupleSchemeFactory();
    private int errorCode;
    private int extendedErrorCode;
    private boolean hasExtendedError;
    @Nullable
    private ObjectSpec objectSpec;
    @Nullable
    private String message;
    @Nullable
    private Map<Attribute, String> errorAttributes;
    private static final int __ERRORCODE_ISSET_ID = 0;
    private static final int __EXTENDEDERRORCODE_ISSET_ID = 1;
    private static final int __HASEXTENDEDERROR_ISSET_ID = 2;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public IWPError() {
        this.errorCode = 0;
        this.extendedErrorCode = 0;
    }

    public IWPError(int n, int n2, boolean bl, ObjectSpec objectSpec, String string, Map<Attribute, String> map) {
        this();
        this.errorCode = n;
        this.setErrorCodeIsSet(true);
        this.extendedErrorCode = n2;
        this.setExtendedErrorCodeIsSet(true);
        this.hasExtendedError = bl;
        this.setHasExtendedErrorIsSet(true);
        this.objectSpec = objectSpec;
        this.message = string;
        this.errorAttributes = map;
    }

    public IWPError(IWPError iWPError) {
        this.__isset_bitfield = iWPError.__isset_bitfield;
        this.errorCode = iWPError.errorCode;
        this.extendedErrorCode = iWPError.extendedErrorCode;
        this.hasExtendedError = iWPError.hasExtendedError;
        if (iWPError.isSetObjectSpec()) {
            this.objectSpec = new ObjectSpec(iWPError.objectSpec);
        }
        if (iWPError.isSetMessage()) {
            this.message = iWPError.message;
        }
        if (iWPError.isSetErrorAttributes()) {
            EnumMap<Attribute, String> enumMap = new EnumMap<Attribute, String>(Attribute.class);
            for (Map.Entry<Attribute, String> entry : iWPError.errorAttributes.entrySet()) {
                Attribute attribute = entry.getKey();
                String string = entry.getValue();
                Attribute attribute2 = attribute;
                String string2 = string;
                enumMap.put(attribute2, string2);
            }
            this.errorAttributes = enumMap;
        }
    }

    public IWPError deepCopy() {
        return new IWPError(this);
    }

    public void clear() {
        this.errorCode = 0;
        this.extendedErrorCode = 0;
        this.setHasExtendedErrorIsSet(false);
        this.hasExtendedError = false;
        this.objectSpec = null;
        this.message = null;
        this.errorAttributes = null;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(int n) {
        this.errorCode = n;
        this.setErrorCodeIsSet(true);
    }

    public void unsetErrorCode() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetErrorCode() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setErrorCodeIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public int getExtendedErrorCode() {
        return this.extendedErrorCode;
    }

    public void setExtendedErrorCode(int n) {
        this.extendedErrorCode = n;
        this.setExtendedErrorCodeIsSet(true);
    }

    public void unsetExtendedErrorCode() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)1);
    }

    public boolean isSetExtendedErrorCode() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)1);
    }

    public void setExtendedErrorCodeIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)1, (boolean)bl);
    }

    public boolean isHasExtendedError() {
        return this.hasExtendedError;
    }

    public void setHasExtendedError(boolean bl) {
        this.hasExtendedError = bl;
        this.setHasExtendedErrorIsSet(true);
    }

    public void unsetHasExtendedError() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)2);
    }

    public boolean isSetHasExtendedError() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)2);
    }

    public void setHasExtendedErrorIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)2, (boolean)bl);
    }

    @Nullable
    public ObjectSpec getObjectSpec() {
        return this.objectSpec;
    }

    public void setObjectSpec(@Nullable ObjectSpec objectSpec) {
        this.objectSpec = objectSpec;
    }

    public void unsetObjectSpec() {
        this.objectSpec = null;
    }

    public boolean isSetObjectSpec() {
        return this.objectSpec != null;
    }

    public void setObjectSpecIsSet(boolean bl) {
        if (!bl) {
            this.objectSpec = null;
        }
    }

    @Nullable
    public String getMessage() {
        return this.message;
    }

    public void setMessage(@Nullable String string) {
        this.message = string;
    }

    public void unsetMessage() {
        this.message = null;
    }

    public boolean isSetMessage() {
        return this.message != null;
    }

    public void setMessageIsSet(boolean bl) {
        if (!bl) {
            this.message = null;
        }
    }

    public int getErrorAttributesSize() {
        return this.errorAttributes == null ? 0 : this.errorAttributes.size();
    }

    public void putToErrorAttributes(Attribute attribute, String string) {
        if (this.errorAttributes == null) {
            this.errorAttributes = new EnumMap<Attribute, String>(Attribute.class);
        }
        this.errorAttributes.put(attribute, string);
    }

    @Nullable
    public Map<Attribute, String> getErrorAttributes() {
        return this.errorAttributes;
    }

    public void setErrorAttributes(@Nullable Map<Attribute, String> map) {
        this.errorAttributes = map;
    }

    public void unsetErrorAttributes() {
        this.errorAttributes = null;
    }

    public boolean isSetErrorAttributes() {
        return this.errorAttributes != null;
    }

    public void setErrorAttributesIsSet(boolean bl) {
        if (!bl) {
            this.errorAttributes = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetErrorCode();
                    break;
                }
                this.setErrorCode((Integer)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetExtendedErrorCode();
                    break;
                }
                this.setExtendedErrorCode((Integer)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetHasExtendedError();
                    break;
                }
                this.setHasExtendedError((Boolean)object);
                break;
            }
            case 3: {
                if (object == null) {
                    this.unsetObjectSpec();
                    break;
                }
                this.setObjectSpec((ObjectSpec)object);
                break;
            }
            case 4: {
                if (object == null) {
                    this.unsetMessage();
                    break;
                }
                this.setMessage((String)object);
                break;
            }
            case 5: {
                if (object == null) {
                    this.unsetErrorAttributes();
                    break;
                }
                this.setErrorAttributes((Map)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getErrorCode();
            }
            case 1: {
                return this.getExtendedErrorCode();
            }
            case 2: {
                return this.isHasExtendedError();
            }
            case 3: {
                return this.getObjectSpec();
            }
            case 4: {
                return this.getMessage();
            }
            case 5: {
                return this.getErrorAttributes();
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
                return this.isSetErrorCode();
            }
            case 1: {
                return this.isSetExtendedErrorCode();
            }
            case 2: {
                return this.isSetHasExtendedError();
            }
            case 3: {
                return this.isSetObjectSpec();
            }
            case 4: {
                return this.isSetMessage();
            }
            case 5: {
                return this.isSetErrorAttributes();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof IWPError) {
            return this.equals((IWPError)object);
        }
        return false;
    }

    public boolean equals(IWPError iWPError) {
        if (iWPError == null) {
            return false;
        }
        if (this == iWPError) {
            return true;
        }
        boolean bl = true;
        boolean bl2 = true;
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (this.errorCode != iWPError.errorCode) {
                return false;
            }
        }
        boolean bl3 = true;
        boolean bl4 = true;
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (this.extendedErrorCode != iWPError.extendedErrorCode) {
                return false;
            }
        }
        boolean bl5 = true;
        boolean bl6 = true;
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (this.hasExtendedError != iWPError.hasExtendedError) {
                return false;
            }
        }
        boolean bl7 = this.isSetObjectSpec();
        boolean bl8 = iWPError.isSetObjectSpec();
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (!this.objectSpec.equals(iWPError.objectSpec)) {
                return false;
            }
        }
        boolean bl9 = this.isSetMessage();
        boolean bl10 = iWPError.isSetMessage();
        if (bl9 || bl10) {
            if (!bl9 || !bl10) {
                return false;
            }
            if (!this.message.equals(iWPError.message)) {
                return false;
            }
        }
        boolean bl11 = this.isSetErrorAttributes();
        boolean bl12 = iWPError.isSetErrorAttributes();
        if (bl11 || bl12) {
            if (!bl11 || !bl12) {
                return false;
            }
            if (!this.errorAttributes.equals(iWPError.errorAttributes)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + this.errorCode;
        n = n * 8191 + this.extendedErrorCode;
        n = n * 8191 + (this.hasExtendedError ? 131071 : 524287);
        n = n * 8191 + (this.isSetObjectSpec() ? 131071 : 524287);
        if (this.isSetObjectSpec()) {
            n = n * 8191 + this.objectSpec.hashCode();
        }
        n = n * 8191 + (this.isSetMessage() ? 131071 : 524287);
        if (this.isSetMessage()) {
            n = n * 8191 + this.message.hashCode();
        }
        n = n * 8191 + (this.isSetErrorAttributes() ? 131071 : 524287);
        if (this.isSetErrorAttributes()) {
            n = n * 8191 + this.errorAttributes.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(IWPError iWPError) {
        if (!this.getClass().equals(iWPError.getClass())) {
            return this.getClass().getName().compareTo(iWPError.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetErrorCode(), iWPError.isSetErrorCode());
        if (n != 0) {
            return n;
        }
        if (this.isSetErrorCode() && (n = TBaseHelper.compareTo((int)this.errorCode, (int)iWPError.errorCode)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetExtendedErrorCode(), iWPError.isSetExtendedErrorCode());
        if (n != 0) {
            return n;
        }
        if (this.isSetExtendedErrorCode() && (n = TBaseHelper.compareTo((int)this.extendedErrorCode, (int)iWPError.extendedErrorCode)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetHasExtendedError(), iWPError.isSetHasExtendedError());
        if (n != 0) {
            return n;
        }
        if (this.isSetHasExtendedError() && (n = TBaseHelper.compareTo((boolean)this.hasExtendedError, (boolean)iWPError.hasExtendedError)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetObjectSpec(), iWPError.isSetObjectSpec());
        if (n != 0) {
            return n;
        }
        if (this.isSetObjectSpec() && (n = TBaseHelper.compareTo((Comparable)this.objectSpec, (Comparable)iWPError.objectSpec)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetMessage(), iWPError.isSetMessage());
        if (n != 0) {
            return n;
        }
        if (this.isSetMessage() && (n = TBaseHelper.compareTo((String)this.message, (String)iWPError.message)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetErrorAttributes(), iWPError.isSetErrorAttributes());
        if (n != 0) {
            return n;
        }
        if (this.isSetErrorAttributes() && (n = TBaseHelper.compareTo(this.errorAttributes, iWPError.errorAttributes)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        IWPError.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        IWPError.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("IWPError(");
        boolean bl = true;
        stringBuilder.append("errorCode:");
        stringBuilder.append(this.errorCode);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("extendedErrorCode:");
        stringBuilder.append(this.extendedErrorCode);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("hasExtendedError:");
        stringBuilder.append(this.hasExtendedError);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("objectSpec:");
        if (this.objectSpec == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.objectSpec);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("message:");
        if (this.message == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.message);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("errorAttributes:");
        if (this.errorAttributes == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.errorAttributes);
        }
        bl = false;
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void validate() throws TException {
        if (this.objectSpec != null) {
            this.objectSpec.validate();
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
        enumMap.put(_Fields.ERROR_CODE, new FieldMetaData("errorCode", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.EXTENDED_ERROR_CODE, new FieldMetaData("extendedErrorCode", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.HAS_EXTENDED_ERROR, new FieldMetaData("hasExtendedError", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.OBJECT_SPEC, new FieldMetaData("objectSpec", 3, (FieldValueMetaData)new StructMetaData(12, ObjectSpec.class)));
        enumMap.put(_Fields.MESSAGE, new FieldMetaData("message", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.ERROR_ATTRIBUTES, new FieldMetaData("errorAttributes", 3, (FieldValueMetaData)new MapMetaData(13, (FieldValueMetaData)new EnumMetaData(-1, Attribute.class), new FieldValueMetaData(11))));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(IWPError.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        ERROR_CODE(1, "errorCode"),
        EXTENDED_ERROR_CODE(2, "extendedErrorCode"),
        HAS_EXTENDED_ERROR(3, "hasExtendedError"),
        OBJECT_SPEC(4, "objectSpec"),
        MESSAGE(5, "message"),
        ERROR_ATTRIBUTES(6, "errorAttributes");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return ERROR_CODE;
                }
                case 2: {
                    return EXTENDED_ERROR_CODE;
                }
                case 3: {
                    return HAS_EXTENDED_ERROR;
                }
                case 4: {
                    return OBJECT_SPEC;
                }
                case 5: {
                    return MESSAGE;
                }
                case 6: {
                    return ERROR_ATTRIBUTES;
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

    private static class IWPErrorStandardSchemeFactory
    implements SchemeFactory {
        private IWPErrorStandardSchemeFactory() {
        }

        public IWPErrorStandardScheme getScheme() {
            return new IWPErrorStandardScheme();
        }
    }

    private static class IWPErrorTupleSchemeFactory
    implements SchemeFactory {
        private IWPErrorTupleSchemeFactory() {
        }

        public IWPErrorTupleScheme getScheme() {
            return new IWPErrorTupleScheme();
        }
    }

    private static class IWPErrorTupleScheme
    extends TupleScheme<IWPError> {
        private IWPErrorTupleScheme() {
        }

        public void write(TProtocol tProtocol, IWPError iWPError) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (iWPError.isSetErrorCode()) {
                bitSet.set(0);
            }
            if (iWPError.isSetExtendedErrorCode()) {
                bitSet.set(1);
            }
            if (iWPError.isSetHasExtendedError()) {
                bitSet.set(2);
            }
            if (iWPError.isSetObjectSpec()) {
                bitSet.set(3);
            }
            if (iWPError.isSetMessage()) {
                bitSet.set(4);
            }
            if (iWPError.isSetErrorAttributes()) {
                bitSet.set(5);
            }
            tTupleProtocol.writeBitSet(bitSet, 6);
            if (iWPError.isSetErrorCode()) {
                tTupleProtocol.writeI32(iWPError.errorCode);
            }
            if (iWPError.isSetExtendedErrorCode()) {
                tTupleProtocol.writeI32(iWPError.extendedErrorCode);
            }
            if (iWPError.isSetHasExtendedError()) {
                tTupleProtocol.writeBool(iWPError.hasExtendedError);
            }
            if (iWPError.isSetObjectSpec()) {
                iWPError.objectSpec.write((TProtocol)tTupleProtocol);
            }
            if (iWPError.isSetMessage()) {
                tTupleProtocol.writeString(iWPError.message);
            }
            if (iWPError.isSetErrorAttributes()) {
                tTupleProtocol.writeI32(iWPError.errorAttributes.size());
                for (Map.Entry<Attribute, String> entry : iWPError.errorAttributes.entrySet()) {
                    tTupleProtocol.writeI32(entry.getKey().getValue());
                    tTupleProtocol.writeString(entry.getValue());
                }
            }
        }

        public void read(TProtocol tProtocol, IWPError iWPError) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(6);
            if (bitSet.get(0)) {
                iWPError.errorCode = tTupleProtocol.readI32();
                iWPError.setErrorCodeIsSet(true);
            }
            if (bitSet.get(1)) {
                iWPError.extendedErrorCode = tTupleProtocol.readI32();
                iWPError.setExtendedErrorCodeIsSet(true);
            }
            if (bitSet.get(2)) {
                iWPError.hasExtendedError = tTupleProtocol.readBool();
                iWPError.setHasExtendedErrorIsSet(true);
            }
            if (bitSet.get(3)) {
                iWPError.objectSpec = new ObjectSpec();
                iWPError.objectSpec.read((TProtocol)tTupleProtocol);
                iWPError.setObjectSpecIsSet(true);
            }
            if (bitSet.get(4)) {
                iWPError.message = tTupleProtocol.readString();
                iWPError.setMessageIsSet(true);
            }
            if (bitSet.get(5)) {
                TMap tMap = tTupleProtocol.readMapBegin((byte)8, (byte)11);
                iWPError.errorAttributes = new EnumMap<Attribute, String>(Attribute.class);
                for (int i = 0; i < tMap.size; ++i) {
                    Attribute attribute = Attribute.findByValue(tTupleProtocol.readI32());
                    String string = tTupleProtocol.readString();
                    if (attribute == null) continue;
                    iWPError.errorAttributes.put(attribute, string);
                }
                iWPError.setErrorAttributesIsSet(true);
            }
        }
    }

    private static class IWPErrorStandardScheme
    extends StandardScheme<IWPError> {
        private IWPErrorStandardScheme() {
        }

        public void read(TProtocol tProtocol, IWPError iWPError) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 8) {
                            iWPError.errorCode = tProtocol.readI32();
                            iWPError.setErrorCodeIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 8) {
                            iWPError.extendedErrorCode = tProtocol.readI32();
                            iWPError.setExtendedErrorCodeIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 2) {
                            iWPError.hasExtendedError = tProtocol.readBool();
                            iWPError.setHasExtendedErrorIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 12) {
                            iWPError.objectSpec = new ObjectSpec();
                            iWPError.objectSpec.read(tProtocol);
                            iWPError.setObjectSpecIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 5: {
                        if (tField.type == 11) {
                            iWPError.message = tProtocol.readString();
                            iWPError.setMessageIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 6: {
                        if (tField.type == 13) {
                            TMap tMap = tProtocol.readMapBegin();
                            iWPError.errorAttributes = new EnumMap<Attribute, String>(Attribute.class);
                            for (int i = 0; i < tMap.size; ++i) {
                                Attribute attribute = Attribute.findByValue(tProtocol.readI32());
                                String string = tProtocol.readString();
                                if (attribute == null) continue;
                                iWPError.errorAttributes.put(attribute, string);
                            }
                            tProtocol.readMapEnd();
                            iWPError.setErrorAttributesIsSet(true);
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
            iWPError.validate();
        }

        public void write(TProtocol tProtocol, IWPError iWPError) throws TException {
            iWPError.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            tProtocol.writeFieldBegin(ERROR_CODE_FIELD_DESC);
            tProtocol.writeI32(iWPError.errorCode);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(EXTENDED_ERROR_CODE_FIELD_DESC);
            tProtocol.writeI32(iWPError.extendedErrorCode);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(HAS_EXTENDED_ERROR_FIELD_DESC);
            tProtocol.writeBool(iWPError.hasExtendedError);
            tProtocol.writeFieldEnd();
            if (iWPError.objectSpec != null) {
                tProtocol.writeFieldBegin(OBJECT_SPEC_FIELD_DESC);
                iWPError.objectSpec.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            if (iWPError.message != null) {
                tProtocol.writeFieldBegin(MESSAGE_FIELD_DESC);
                tProtocol.writeString(iWPError.message);
                tProtocol.writeFieldEnd();
            }
            if (iWPError.errorAttributes != null) {
                tProtocol.writeFieldBegin(ERROR_ATTRIBUTES_FIELD_DESC);
                tProtocol.writeMapBegin(new TMap(8, 11, iWPError.errorAttributes.size()));
                for (Map.Entry<Attribute, String> entry : iWPError.errorAttributes.entrySet()) {
                    tProtocol.writeI32(entry.getKey().getValue());
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

