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

import com.filemaker.jwpc.iwp.thrift.common.SaveAsPDFSettings;
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

public class SaveAsPDFResponse
implements TBase<SaveAsPDFResponse, _Fields>,
Serializable,
Cloneable,
Comparable<SaveAsPDFResponse> {
    private static final TStruct STRUCT_DESC = new TStruct("SaveAsPDFResponse");
    private static final TField CONFIRM_FIELD_DESC = new TField("confirm", 2, 1);
    private static final TField SETTINGS_FIELD_DESC = new TField("settings", 12, 2);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new SaveAsPDFResponseStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new SaveAsPDFResponseTupleSchemeFactory();
    private boolean confirm;
    @Nullable
    private SaveAsPDFSettings settings;
    private static final int __CONFIRM_ISSET_ID = 0;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public SaveAsPDFResponse() {
    }

    public SaveAsPDFResponse(boolean bl, SaveAsPDFSettings saveAsPDFSettings) {
        this();
        this.confirm = bl;
        this.setConfirmIsSet(true);
        this.settings = saveAsPDFSettings;
    }

    public SaveAsPDFResponse(SaveAsPDFResponse saveAsPDFResponse) {
        this.__isset_bitfield = saveAsPDFResponse.__isset_bitfield;
        this.confirm = saveAsPDFResponse.confirm;
        if (saveAsPDFResponse.isSetSettings()) {
            this.settings = new SaveAsPDFSettings(saveAsPDFResponse.settings);
        }
    }

    public SaveAsPDFResponse deepCopy() {
        return new SaveAsPDFResponse(this);
    }

    public void clear() {
        this.setConfirmIsSet(false);
        this.confirm = false;
        this.settings = null;
    }

    public boolean isConfirm() {
        return this.confirm;
    }

    public void setConfirm(boolean bl) {
        this.confirm = bl;
        this.setConfirmIsSet(true);
    }

    public void unsetConfirm() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetConfirm() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setConfirmIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    @Nullable
    public SaveAsPDFSettings getSettings() {
        return this.settings;
    }

    public void setSettings(@Nullable SaveAsPDFSettings saveAsPDFSettings) {
        this.settings = saveAsPDFSettings;
    }

    public void unsetSettings() {
        this.settings = null;
    }

    public boolean isSetSettings() {
        return this.settings != null;
    }

    public void setSettingsIsSet(boolean bl) {
        if (!bl) {
            this.settings = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetConfirm();
                    break;
                }
                this.setConfirm((Boolean)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetSettings();
                    break;
                }
                this.setSettings((SaveAsPDFSettings)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.isConfirm();
            }
            case 1: {
                return this.getSettings();
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
                return this.isSetConfirm();
            }
            case 1: {
                return this.isSetSettings();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof SaveAsPDFResponse) {
            return this.equals((SaveAsPDFResponse)object);
        }
        return false;
    }

    public boolean equals(SaveAsPDFResponse saveAsPDFResponse) {
        if (saveAsPDFResponse == null) {
            return false;
        }
        if (this == saveAsPDFResponse) {
            return true;
        }
        boolean bl = true;
        boolean bl2 = true;
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (this.confirm != saveAsPDFResponse.confirm) {
                return false;
            }
        }
        boolean bl3 = this.isSetSettings();
        boolean bl4 = saveAsPDFResponse.isSetSettings();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.settings.equals(saveAsPDFResponse.settings)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.confirm ? 131071 : 524287);
        n = n * 8191 + (this.isSetSettings() ? 131071 : 524287);
        if (this.isSetSettings()) {
            n = n * 8191 + this.settings.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(SaveAsPDFResponse saveAsPDFResponse) {
        if (!this.getClass().equals(saveAsPDFResponse.getClass())) {
            return this.getClass().getName().compareTo(saveAsPDFResponse.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetConfirm(), saveAsPDFResponse.isSetConfirm());
        if (n != 0) {
            return n;
        }
        if (this.isSetConfirm() && (n = TBaseHelper.compareTo((boolean)this.confirm, (boolean)saveAsPDFResponse.confirm)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetSettings(), saveAsPDFResponse.isSetSettings());
        if (n != 0) {
            return n;
        }
        if (this.isSetSettings() && (n = TBaseHelper.compareTo((Comparable)this.settings, (Comparable)saveAsPDFResponse.settings)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        SaveAsPDFResponse.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        SaveAsPDFResponse.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("SaveAsPDFResponse(");
        boolean bl = true;
        stringBuilder.append("confirm:");
        stringBuilder.append(this.confirm);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("settings:");
        if (this.settings == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.settings);
        }
        bl = false;
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void validate() throws TException {
        if (this.settings != null) {
            this.settings.validate();
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
        enumMap.put(_Fields.CONFIRM, new FieldMetaData("confirm", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.SETTINGS, new FieldMetaData("settings", 3, (FieldValueMetaData)new StructMetaData(12, SaveAsPDFSettings.class)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(SaveAsPDFResponse.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        CONFIRM(1, "confirm"),
        SETTINGS(2, "settings");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return CONFIRM;
                }
                case 2: {
                    return SETTINGS;
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

    private static class SaveAsPDFResponseStandardSchemeFactory
    implements SchemeFactory {
        private SaveAsPDFResponseStandardSchemeFactory() {
        }

        public SaveAsPDFResponseStandardScheme getScheme() {
            return new SaveAsPDFResponseStandardScheme();
        }
    }

    private static class SaveAsPDFResponseTupleSchemeFactory
    implements SchemeFactory {
        private SaveAsPDFResponseTupleSchemeFactory() {
        }

        public SaveAsPDFResponseTupleScheme getScheme() {
            return new SaveAsPDFResponseTupleScheme();
        }
    }

    private static class SaveAsPDFResponseTupleScheme
    extends TupleScheme<SaveAsPDFResponse> {
        private SaveAsPDFResponseTupleScheme() {
        }

        public void write(TProtocol tProtocol, SaveAsPDFResponse saveAsPDFResponse) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (saveAsPDFResponse.isSetConfirm()) {
                bitSet.set(0);
            }
            if (saveAsPDFResponse.isSetSettings()) {
                bitSet.set(1);
            }
            tTupleProtocol.writeBitSet(bitSet, 2);
            if (saveAsPDFResponse.isSetConfirm()) {
                tTupleProtocol.writeBool(saveAsPDFResponse.confirm);
            }
            if (saveAsPDFResponse.isSetSettings()) {
                saveAsPDFResponse.settings.write((TProtocol)tTupleProtocol);
            }
        }

        public void read(TProtocol tProtocol, SaveAsPDFResponse saveAsPDFResponse) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(2);
            if (bitSet.get(0)) {
                saveAsPDFResponse.confirm = tTupleProtocol.readBool();
                saveAsPDFResponse.setConfirmIsSet(true);
            }
            if (bitSet.get(1)) {
                saveAsPDFResponse.settings = new SaveAsPDFSettings();
                saveAsPDFResponse.settings.read((TProtocol)tTupleProtocol);
                saveAsPDFResponse.setSettingsIsSet(true);
            }
        }
    }

    private static class SaveAsPDFResponseStandardScheme
    extends StandardScheme<SaveAsPDFResponse> {
        private SaveAsPDFResponseStandardScheme() {
        }

        public void read(TProtocol tProtocol, SaveAsPDFResponse saveAsPDFResponse) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 2) {
                            saveAsPDFResponse.confirm = tProtocol.readBool();
                            saveAsPDFResponse.setConfirmIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 12) {
                            saveAsPDFResponse.settings = new SaveAsPDFSettings();
                            saveAsPDFResponse.settings.read(tProtocol);
                            saveAsPDFResponse.setSettingsIsSet(true);
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
            saveAsPDFResponse.validate();
        }

        public void write(TProtocol tProtocol, SaveAsPDFResponse saveAsPDFResponse) throws TException {
            saveAsPDFResponse.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            tProtocol.writeFieldBegin(CONFIRM_FIELD_DESC);
            tProtocol.writeBool(saveAsPDFResponse.confirm);
            tProtocol.writeFieldEnd();
            if (saveAsPDFResponse.settings != null) {
                tProtocol.writeFieldBegin(SETTINGS_FIELD_DESC);
                saveAsPDFResponse.settings.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

