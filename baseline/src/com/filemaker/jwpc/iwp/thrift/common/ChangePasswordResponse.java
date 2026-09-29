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

public class ChangePasswordResponse
implements TBase<ChangePasswordResponse, _Fields>,
Serializable,
Cloneable,
Comparable<ChangePasswordResponse> {
    private static final TStruct STRUCT_DESC = new TStruct("ChangePasswordResponse");
    private static final TField CONFIRM_FIELD_DESC = new TField("confirm", 2, 1);
    private static final TField OLD_PASS_FIELD_DESC = new TField("oldPass", 11, 2);
    private static final TField NEW_PASS_FIELD_DESC = new TField("newPass", 11, 3);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new ChangePasswordResponseStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new ChangePasswordResponseTupleSchemeFactory();
    private boolean confirm;
    @Nullable
    private String oldPass;
    @Nullable
    private String newPass;
    private static final int __CONFIRM_ISSET_ID = 0;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public ChangePasswordResponse() {
    }

    public ChangePasswordResponse(boolean bl, String string, String string2) {
        this();
        this.confirm = bl;
        this.setConfirmIsSet(true);
        this.oldPass = string;
        this.newPass = string2;
    }

    public ChangePasswordResponse(ChangePasswordResponse changePasswordResponse) {
        this.__isset_bitfield = changePasswordResponse.__isset_bitfield;
        this.confirm = changePasswordResponse.confirm;
        if (changePasswordResponse.isSetOldPass()) {
            this.oldPass = changePasswordResponse.oldPass;
        }
        if (changePasswordResponse.isSetNewPass()) {
            this.newPass = changePasswordResponse.newPass;
        }
    }

    public ChangePasswordResponse deepCopy() {
        return new ChangePasswordResponse(this);
    }

    public void clear() {
        this.setConfirmIsSet(false);
        this.confirm = false;
        this.oldPass = null;
        this.newPass = null;
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
    public String getOldPass() {
        return this.oldPass;
    }

    public void setOldPass(@Nullable String string) {
        this.oldPass = string;
    }

    public void unsetOldPass() {
        this.oldPass = null;
    }

    public boolean isSetOldPass() {
        return this.oldPass != null;
    }

    public void setOldPassIsSet(boolean bl) {
        if (!bl) {
            this.oldPass = null;
        }
    }

    @Nullable
    public String getNewPass() {
        return this.newPass;
    }

    public void setNewPass(@Nullable String string) {
        this.newPass = string;
    }

    public void unsetNewPass() {
        this.newPass = null;
    }

    public boolean isSetNewPass() {
        return this.newPass != null;
    }

    public void setNewPassIsSet(boolean bl) {
        if (!bl) {
            this.newPass = null;
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
                    this.unsetOldPass();
                    break;
                }
                this.setOldPass((String)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetNewPass();
                    break;
                }
                this.setNewPass((String)object);
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
                return this.getOldPass();
            }
            case 2: {
                return this.getNewPass();
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
                return this.isSetOldPass();
            }
            case 2: {
                return this.isSetNewPass();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof ChangePasswordResponse) {
            return this.equals((ChangePasswordResponse)object);
        }
        return false;
    }

    public boolean equals(ChangePasswordResponse changePasswordResponse) {
        if (changePasswordResponse == null) {
            return false;
        }
        if (this == changePasswordResponse) {
            return true;
        }
        boolean bl = true;
        boolean bl2 = true;
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (this.confirm != changePasswordResponse.confirm) {
                return false;
            }
        }
        boolean bl3 = this.isSetOldPass();
        boolean bl4 = changePasswordResponse.isSetOldPass();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.oldPass.equals(changePasswordResponse.oldPass)) {
                return false;
            }
        }
        boolean bl5 = this.isSetNewPass();
        boolean bl6 = changePasswordResponse.isSetNewPass();
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (!this.newPass.equals(changePasswordResponse.newPass)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.confirm ? 131071 : 524287);
        n = n * 8191 + (this.isSetOldPass() ? 131071 : 524287);
        if (this.isSetOldPass()) {
            n = n * 8191 + this.oldPass.hashCode();
        }
        n = n * 8191 + (this.isSetNewPass() ? 131071 : 524287);
        if (this.isSetNewPass()) {
            n = n * 8191 + this.newPass.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(ChangePasswordResponse changePasswordResponse) {
        if (!this.getClass().equals(changePasswordResponse.getClass())) {
            return this.getClass().getName().compareTo(changePasswordResponse.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetConfirm(), changePasswordResponse.isSetConfirm());
        if (n != 0) {
            return n;
        }
        if (this.isSetConfirm() && (n = TBaseHelper.compareTo((boolean)this.confirm, (boolean)changePasswordResponse.confirm)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetOldPass(), changePasswordResponse.isSetOldPass());
        if (n != 0) {
            return n;
        }
        if (this.isSetOldPass() && (n = TBaseHelper.compareTo((String)this.oldPass, (String)changePasswordResponse.oldPass)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetNewPass(), changePasswordResponse.isSetNewPass());
        if (n != 0) {
            return n;
        }
        if (this.isSetNewPass() && (n = TBaseHelper.compareTo((String)this.newPass, (String)changePasswordResponse.newPass)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        ChangePasswordResponse.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        ChangePasswordResponse.scheme(tProtocol).write(tProtocol, (TBase)this);
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
        enumMap.put(_Fields.CONFIRM, new FieldMetaData("confirm", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.OLD_PASS, new FieldMetaData("oldPass", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.NEW_PASS, new FieldMetaData("newPass", 3, new FieldValueMetaData(11)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(ChangePasswordResponse.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        CONFIRM(1, "confirm"),
        OLD_PASS(2, "oldPass"),
        NEW_PASS(3, "newPass");

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
                    return OLD_PASS;
                }
                case 3: {
                    return NEW_PASS;
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

    private static class ChangePasswordResponseStandardSchemeFactory
    implements SchemeFactory {
        private ChangePasswordResponseStandardSchemeFactory() {
        }

        public ChangePasswordResponseStandardScheme getScheme() {
            return new ChangePasswordResponseStandardScheme();
        }
    }

    private static class ChangePasswordResponseTupleSchemeFactory
    implements SchemeFactory {
        private ChangePasswordResponseTupleSchemeFactory() {
        }

        public ChangePasswordResponseTupleScheme getScheme() {
            return new ChangePasswordResponseTupleScheme();
        }
    }

    private static class ChangePasswordResponseTupleScheme
    extends TupleScheme<ChangePasswordResponse> {
        private ChangePasswordResponseTupleScheme() {
        }

        public void write(TProtocol tProtocol, ChangePasswordResponse changePasswordResponse) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (changePasswordResponse.isSetConfirm()) {
                bitSet.set(0);
            }
            if (changePasswordResponse.isSetOldPass()) {
                bitSet.set(1);
            }
            if (changePasswordResponse.isSetNewPass()) {
                bitSet.set(2);
            }
            tTupleProtocol.writeBitSet(bitSet, 3);
            if (changePasswordResponse.isSetConfirm()) {
                tTupleProtocol.writeBool(changePasswordResponse.confirm);
            }
            if (changePasswordResponse.isSetOldPass()) {
                tTupleProtocol.writeString(changePasswordResponse.oldPass);
            }
            if (changePasswordResponse.isSetNewPass()) {
                tTupleProtocol.writeString(changePasswordResponse.newPass);
            }
        }

        public void read(TProtocol tProtocol, ChangePasswordResponse changePasswordResponse) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(3);
            if (bitSet.get(0)) {
                changePasswordResponse.confirm = tTupleProtocol.readBool();
                changePasswordResponse.setConfirmIsSet(true);
            }
            if (bitSet.get(1)) {
                changePasswordResponse.oldPass = tTupleProtocol.readString();
                changePasswordResponse.setOldPassIsSet(true);
            }
            if (bitSet.get(2)) {
                changePasswordResponse.newPass = tTupleProtocol.readString();
                changePasswordResponse.setNewPassIsSet(true);
            }
        }
    }

    private static class ChangePasswordResponseStandardScheme
    extends StandardScheme<ChangePasswordResponse> {
        private ChangePasswordResponseStandardScheme() {
        }

        public void read(TProtocol tProtocol, ChangePasswordResponse changePasswordResponse) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 2) {
                            changePasswordResponse.confirm = tProtocol.readBool();
                            changePasswordResponse.setConfirmIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 11) {
                            changePasswordResponse.oldPass = tProtocol.readString();
                            changePasswordResponse.setOldPassIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 11) {
                            changePasswordResponse.newPass = tProtocol.readString();
                            changePasswordResponse.setNewPassIsSet(true);
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
            changePasswordResponse.validate();
        }

        public void write(TProtocol tProtocol, ChangePasswordResponse changePasswordResponse) throws TException {
            changePasswordResponse.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            tProtocol.writeFieldBegin(CONFIRM_FIELD_DESC);
            tProtocol.writeBool(changePasswordResponse.confirm);
            tProtocol.writeFieldEnd();
            if (changePasswordResponse.oldPass != null) {
                tProtocol.writeFieldBegin(OLD_PASS_FIELD_DESC);
                tProtocol.writeString(changePasswordResponse.oldPass);
                tProtocol.writeFieldEnd();
            }
            if (changePasswordResponse.newPass != null) {
                tProtocol.writeFieldBegin(NEW_PASS_FIELD_DESC);
                tProtocol.writeString(changePasswordResponse.newPass);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

