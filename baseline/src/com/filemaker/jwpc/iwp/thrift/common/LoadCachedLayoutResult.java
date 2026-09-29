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

public class LoadCachedLayoutResult
implements TBase<LoadCachedLayoutResult, _Fields>,
Serializable,
Cloneable,
Comparable<LoadCachedLayoutResult> {
    private static final TStruct STRUCT_DESC = new TStruct("LoadCachedLayoutResult");
    private static final TField CACHED_LAYOUT_LOADED_FIELD_DESC = new TField("cachedLayoutLoaded", 2, 1);
    private static final TField AUTORESIZE_LAYOUT_FIELD_DESC = new TField("autoresizeLayout", 2, 2);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new LoadCachedLayoutResultStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new LoadCachedLayoutResultTupleSchemeFactory();
    private boolean cachedLayoutLoaded;
    private boolean autoresizeLayout;
    private static final int __CACHEDLAYOUTLOADED_ISSET_ID = 0;
    private static final int __AUTORESIZELAYOUT_ISSET_ID = 1;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public LoadCachedLayoutResult() {
    }

    public LoadCachedLayoutResult(boolean bl, boolean bl2) {
        this();
        this.cachedLayoutLoaded = bl;
        this.setCachedLayoutLoadedIsSet(true);
        this.autoresizeLayout = bl2;
        this.setAutoresizeLayoutIsSet(true);
    }

    public LoadCachedLayoutResult(LoadCachedLayoutResult loadCachedLayoutResult) {
        this.__isset_bitfield = loadCachedLayoutResult.__isset_bitfield;
        this.cachedLayoutLoaded = loadCachedLayoutResult.cachedLayoutLoaded;
        this.autoresizeLayout = loadCachedLayoutResult.autoresizeLayout;
    }

    public LoadCachedLayoutResult deepCopy() {
        return new LoadCachedLayoutResult(this);
    }

    public void clear() {
        this.setCachedLayoutLoadedIsSet(false);
        this.cachedLayoutLoaded = false;
        this.setAutoresizeLayoutIsSet(false);
        this.autoresizeLayout = false;
    }

    public boolean isCachedLayoutLoaded() {
        return this.cachedLayoutLoaded;
    }

    public void setCachedLayoutLoaded(boolean bl) {
        this.cachedLayoutLoaded = bl;
        this.setCachedLayoutLoadedIsSet(true);
    }

    public void unsetCachedLayoutLoaded() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetCachedLayoutLoaded() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setCachedLayoutLoadedIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public boolean isAutoresizeLayout() {
        return this.autoresizeLayout;
    }

    public void setAutoresizeLayout(boolean bl) {
        this.autoresizeLayout = bl;
        this.setAutoresizeLayoutIsSet(true);
    }

    public void unsetAutoresizeLayout() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)1);
    }

    public boolean isSetAutoresizeLayout() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)1);
    }

    public void setAutoresizeLayoutIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)1, (boolean)bl);
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetCachedLayoutLoaded();
                    break;
                }
                this.setCachedLayoutLoaded((Boolean)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetAutoresizeLayout();
                    break;
                }
                this.setAutoresizeLayout((Boolean)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.isCachedLayoutLoaded();
            }
            case 1: {
                return this.isAutoresizeLayout();
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
                return this.isSetCachedLayoutLoaded();
            }
            case 1: {
                return this.isSetAutoresizeLayout();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof LoadCachedLayoutResult) {
            return this.equals((LoadCachedLayoutResult)object);
        }
        return false;
    }

    public boolean equals(LoadCachedLayoutResult loadCachedLayoutResult) {
        if (loadCachedLayoutResult == null) {
            return false;
        }
        if (this == loadCachedLayoutResult) {
            return true;
        }
        boolean bl = true;
        boolean bl2 = true;
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (this.cachedLayoutLoaded != loadCachedLayoutResult.cachedLayoutLoaded) {
                return false;
            }
        }
        boolean bl3 = true;
        boolean bl4 = true;
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (this.autoresizeLayout != loadCachedLayoutResult.autoresizeLayout) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.cachedLayoutLoaded ? 131071 : 524287);
        n = n * 8191 + (this.autoresizeLayout ? 131071 : 524287);
        return n;
    }

    @Override
    public int compareTo(LoadCachedLayoutResult loadCachedLayoutResult) {
        if (!this.getClass().equals(loadCachedLayoutResult.getClass())) {
            return this.getClass().getName().compareTo(loadCachedLayoutResult.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetCachedLayoutLoaded(), loadCachedLayoutResult.isSetCachedLayoutLoaded());
        if (n != 0) {
            return n;
        }
        if (this.isSetCachedLayoutLoaded() && (n = TBaseHelper.compareTo((boolean)this.cachedLayoutLoaded, (boolean)loadCachedLayoutResult.cachedLayoutLoaded)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetAutoresizeLayout(), loadCachedLayoutResult.isSetAutoresizeLayout());
        if (n != 0) {
            return n;
        }
        if (this.isSetAutoresizeLayout() && (n = TBaseHelper.compareTo((boolean)this.autoresizeLayout, (boolean)loadCachedLayoutResult.autoresizeLayout)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        LoadCachedLayoutResult.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        LoadCachedLayoutResult.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("LoadCachedLayoutResult(");
        boolean bl = true;
        stringBuilder.append("cachedLayoutLoaded:");
        stringBuilder.append(this.cachedLayoutLoaded);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("autoresizeLayout:");
        stringBuilder.append(this.autoresizeLayout);
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
        enumMap.put(_Fields.CACHED_LAYOUT_LOADED, new FieldMetaData("cachedLayoutLoaded", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.AUTORESIZE_LAYOUT, new FieldMetaData("autoresizeLayout", 3, new FieldValueMetaData(2)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(LoadCachedLayoutResult.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        CACHED_LAYOUT_LOADED(1, "cachedLayoutLoaded"),
        AUTORESIZE_LAYOUT(2, "autoresizeLayout");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return CACHED_LAYOUT_LOADED;
                }
                case 2: {
                    return AUTORESIZE_LAYOUT;
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

    private static class LoadCachedLayoutResultStandardSchemeFactory
    implements SchemeFactory {
        private LoadCachedLayoutResultStandardSchemeFactory() {
        }

        public LoadCachedLayoutResultStandardScheme getScheme() {
            return new LoadCachedLayoutResultStandardScheme();
        }
    }

    private static class LoadCachedLayoutResultTupleSchemeFactory
    implements SchemeFactory {
        private LoadCachedLayoutResultTupleSchemeFactory() {
        }

        public LoadCachedLayoutResultTupleScheme getScheme() {
            return new LoadCachedLayoutResultTupleScheme();
        }
    }

    private static class LoadCachedLayoutResultTupleScheme
    extends TupleScheme<LoadCachedLayoutResult> {
        private LoadCachedLayoutResultTupleScheme() {
        }

        public void write(TProtocol tProtocol, LoadCachedLayoutResult loadCachedLayoutResult) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (loadCachedLayoutResult.isSetCachedLayoutLoaded()) {
                bitSet.set(0);
            }
            if (loadCachedLayoutResult.isSetAutoresizeLayout()) {
                bitSet.set(1);
            }
            tTupleProtocol.writeBitSet(bitSet, 2);
            if (loadCachedLayoutResult.isSetCachedLayoutLoaded()) {
                tTupleProtocol.writeBool(loadCachedLayoutResult.cachedLayoutLoaded);
            }
            if (loadCachedLayoutResult.isSetAutoresizeLayout()) {
                tTupleProtocol.writeBool(loadCachedLayoutResult.autoresizeLayout);
            }
        }

        public void read(TProtocol tProtocol, LoadCachedLayoutResult loadCachedLayoutResult) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(2);
            if (bitSet.get(0)) {
                loadCachedLayoutResult.cachedLayoutLoaded = tTupleProtocol.readBool();
                loadCachedLayoutResult.setCachedLayoutLoadedIsSet(true);
            }
            if (bitSet.get(1)) {
                loadCachedLayoutResult.autoresizeLayout = tTupleProtocol.readBool();
                loadCachedLayoutResult.setAutoresizeLayoutIsSet(true);
            }
        }
    }

    private static class LoadCachedLayoutResultStandardScheme
    extends StandardScheme<LoadCachedLayoutResult> {
        private LoadCachedLayoutResultStandardScheme() {
        }

        public void read(TProtocol tProtocol, LoadCachedLayoutResult loadCachedLayoutResult) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 2) {
                            loadCachedLayoutResult.cachedLayoutLoaded = tProtocol.readBool();
                            loadCachedLayoutResult.setCachedLayoutLoadedIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 2) {
                            loadCachedLayoutResult.autoresizeLayout = tProtocol.readBool();
                            loadCachedLayoutResult.setAutoresizeLayoutIsSet(true);
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
            loadCachedLayoutResult.validate();
        }

        public void write(TProtocol tProtocol, LoadCachedLayoutResult loadCachedLayoutResult) throws TException {
            loadCachedLayoutResult.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            tProtocol.writeFieldBegin(CACHED_LAYOUT_LOADED_FIELD_DESC);
            tProtocol.writeBool(loadCachedLayoutResult.cachedLayoutLoaded);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(AUTORESIZE_LAYOUT_FIELD_DESC);
            tProtocol.writeBool(loadCachedLayoutResult.autoresizeLayout);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

