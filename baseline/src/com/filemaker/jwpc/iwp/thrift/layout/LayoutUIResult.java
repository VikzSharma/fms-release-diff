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
package com.filemaker.jwpc.iwp.thrift.layout;

import com.filemaker.jwpc.iwp.thrift.layout.LayoutUI;
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

public class LayoutUIResult
implements TBase<LayoutUIResult, _Fields>,
Serializable,
Cloneable,
Comparable<LayoutUIResult> {
    private static final TStruct STRUCT_DESC = new TStruct("LayoutUIResult");
    private static final TField LAYOUT_UI_FIELD_DESC = new TField("layoutUI", 12, 1);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new LayoutUIResultStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new LayoutUIResultTupleSchemeFactory();
    @Nullable
    private LayoutUI layoutUI;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public LayoutUIResult() {
    }

    public LayoutUIResult(LayoutUI layoutUI) {
        this();
        this.layoutUI = layoutUI;
    }

    public LayoutUIResult(LayoutUIResult layoutUIResult) {
        if (layoutUIResult.isSetLayoutUI()) {
            this.layoutUI = new LayoutUI(layoutUIResult.layoutUI);
        }
    }

    public LayoutUIResult deepCopy() {
        return new LayoutUIResult(this);
    }

    public void clear() {
        this.layoutUI = null;
    }

    @Nullable
    public LayoutUI getLayoutUI() {
        return this.layoutUI;
    }

    public void setLayoutUI(@Nullable LayoutUI layoutUI) {
        this.layoutUI = layoutUI;
    }

    public void unsetLayoutUI() {
        this.layoutUI = null;
    }

    public boolean isSetLayoutUI() {
        return this.layoutUI != null;
    }

    public void setLayoutUIIsSet(boolean bl) {
        if (!bl) {
            this.layoutUI = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetLayoutUI();
                    break;
                }
                this.setLayoutUI((LayoutUI)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getLayoutUI();
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
                return this.isSetLayoutUI();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof LayoutUIResult) {
            return this.equals((LayoutUIResult)object);
        }
        return false;
    }

    public boolean equals(LayoutUIResult layoutUIResult) {
        if (layoutUIResult == null) {
            return false;
        }
        if (this == layoutUIResult) {
            return true;
        }
        boolean bl = this.isSetLayoutUI();
        boolean bl2 = layoutUIResult.isSetLayoutUI();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.layoutUI.equals(layoutUIResult.layoutUI)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetLayoutUI() ? 131071 : 524287);
        if (this.isSetLayoutUI()) {
            n = n * 8191 + this.layoutUI.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(LayoutUIResult layoutUIResult) {
        if (!this.getClass().equals(layoutUIResult.getClass())) {
            return this.getClass().getName().compareTo(layoutUIResult.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetLayoutUI(), layoutUIResult.isSetLayoutUI());
        if (n != 0) {
            return n;
        }
        if (this.isSetLayoutUI() && (n = TBaseHelper.compareTo((Comparable)this.layoutUI, (Comparable)layoutUIResult.layoutUI)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        LayoutUIResult.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        LayoutUIResult.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("LayoutUIResult(");
        boolean bl = true;
        stringBuilder.append("layoutUI:");
        if (this.layoutUI == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.layoutUI);
        }
        bl = false;
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void validate() throws TException {
        if (this.layoutUI != null) {
            this.layoutUI.validate();
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
        enumMap.put(_Fields.LAYOUT_UI, new FieldMetaData("layoutUI", 3, (FieldValueMetaData)new StructMetaData(12, LayoutUI.class)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(LayoutUIResult.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        LAYOUT_UI(1, "layoutUI");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return LAYOUT_UI;
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

    private static class LayoutUIResultStandardSchemeFactory
    implements SchemeFactory {
        private LayoutUIResultStandardSchemeFactory() {
        }

        public LayoutUIResultStandardScheme getScheme() {
            return new LayoutUIResultStandardScheme();
        }
    }

    private static class LayoutUIResultTupleSchemeFactory
    implements SchemeFactory {
        private LayoutUIResultTupleSchemeFactory() {
        }

        public LayoutUIResultTupleScheme getScheme() {
            return new LayoutUIResultTupleScheme();
        }
    }

    private static class LayoutUIResultTupleScheme
    extends TupleScheme<LayoutUIResult> {
        private LayoutUIResultTupleScheme() {
        }

        public void write(TProtocol tProtocol, LayoutUIResult layoutUIResult) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (layoutUIResult.isSetLayoutUI()) {
                bitSet.set(0);
            }
            tTupleProtocol.writeBitSet(bitSet, 1);
            if (layoutUIResult.isSetLayoutUI()) {
                layoutUIResult.layoutUI.write((TProtocol)tTupleProtocol);
            }
        }

        public void read(TProtocol tProtocol, LayoutUIResult layoutUIResult) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(1);
            if (bitSet.get(0)) {
                layoutUIResult.layoutUI = new LayoutUI();
                layoutUIResult.layoutUI.read((TProtocol)tTupleProtocol);
                layoutUIResult.setLayoutUIIsSet(true);
            }
        }
    }

    private static class LayoutUIResultStandardScheme
    extends StandardScheme<LayoutUIResult> {
        private LayoutUIResultStandardScheme() {
        }

        public void read(TProtocol tProtocol, LayoutUIResult layoutUIResult) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 12) {
                            layoutUIResult.layoutUI = new LayoutUI();
                            layoutUIResult.layoutUI.read(tProtocol);
                            layoutUIResult.setLayoutUIIsSet(true);
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
            layoutUIResult.validate();
        }

        public void write(TProtocol tProtocol, LayoutUIResult layoutUIResult) throws TException {
            layoutUIResult.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (layoutUIResult.layoutUI != null) {
                tProtocol.writeFieldBegin(LAYOUT_UI_FIELD_DESC);
                layoutUIResult.layoutUI.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

