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
package com.filemaker.jwpc.iwp.thrift.notification;

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

public class OpenURLNotification
implements TBase<OpenURLNotification, _Fields>,
Serializable,
Cloneable,
Comparable<OpenURLNotification> {
    private static final TStruct STRUCT_DESC = new TStruct("OpenURLNotification");
    private static final TField SHOW_DIALOG_FIELD_DESC = new TField("showDialog", 2, 1);
    private static final TField URL_FIELD_DESC = new TField("url", 11, 2);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new OpenURLNotificationStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new OpenURLNotificationTupleSchemeFactory();
    private boolean showDialog;
    @Nullable
    private String url;
    private static final int __SHOWDIALOG_ISSET_ID = 0;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public OpenURLNotification() {
    }

    public OpenURLNotification(boolean bl, String string) {
        this();
        this.showDialog = bl;
        this.setShowDialogIsSet(true);
        this.url = string;
    }

    public OpenURLNotification(OpenURLNotification openURLNotification) {
        this.__isset_bitfield = openURLNotification.__isset_bitfield;
        this.showDialog = openURLNotification.showDialog;
        if (openURLNotification.isSetUrl()) {
            this.url = openURLNotification.url;
        }
    }

    public OpenURLNotification deepCopy() {
        return new OpenURLNotification(this);
    }

    public void clear() {
        this.setShowDialogIsSet(false);
        this.showDialog = false;
        this.url = null;
    }

    public boolean isShowDialog() {
        return this.showDialog;
    }

    public void setShowDialog(boolean bl) {
        this.showDialog = bl;
        this.setShowDialogIsSet(true);
    }

    public void unsetShowDialog() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetShowDialog() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setShowDialogIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    @Nullable
    public String getUrl() {
        return this.url;
    }

    public void setUrl(@Nullable String string) {
        this.url = string;
    }

    public void unsetUrl() {
        this.url = null;
    }

    public boolean isSetUrl() {
        return this.url != null;
    }

    public void setUrlIsSet(boolean bl) {
        if (!bl) {
            this.url = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetShowDialog();
                    break;
                }
                this.setShowDialog((Boolean)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetUrl();
                    break;
                }
                this.setUrl((String)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.isShowDialog();
            }
            case 1: {
                return this.getUrl();
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
                return this.isSetShowDialog();
            }
            case 1: {
                return this.isSetUrl();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof OpenURLNotification) {
            return this.equals((OpenURLNotification)object);
        }
        return false;
    }

    public boolean equals(OpenURLNotification openURLNotification) {
        if (openURLNotification == null) {
            return false;
        }
        if (this == openURLNotification) {
            return true;
        }
        boolean bl = true;
        boolean bl2 = true;
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (this.showDialog != openURLNotification.showDialog) {
                return false;
            }
        }
        boolean bl3 = this.isSetUrl();
        boolean bl4 = openURLNotification.isSetUrl();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.url.equals(openURLNotification.url)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.showDialog ? 131071 : 524287);
        n = n * 8191 + (this.isSetUrl() ? 131071 : 524287);
        if (this.isSetUrl()) {
            n = n * 8191 + this.url.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(OpenURLNotification openURLNotification) {
        if (!this.getClass().equals(openURLNotification.getClass())) {
            return this.getClass().getName().compareTo(openURLNotification.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetShowDialog(), openURLNotification.isSetShowDialog());
        if (n != 0) {
            return n;
        }
        if (this.isSetShowDialog() && (n = TBaseHelper.compareTo((boolean)this.showDialog, (boolean)openURLNotification.showDialog)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetUrl(), openURLNotification.isSetUrl());
        if (n != 0) {
            return n;
        }
        if (this.isSetUrl() && (n = TBaseHelper.compareTo((String)this.url, (String)openURLNotification.url)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        OpenURLNotification.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        OpenURLNotification.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("OpenURLNotification(");
        boolean bl = true;
        stringBuilder.append("showDialog:");
        stringBuilder.append(this.showDialog);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("url:");
        if (this.url == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.url);
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
        enumMap.put(_Fields.SHOW_DIALOG, new FieldMetaData("showDialog", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.URL, new FieldMetaData("url", 3, new FieldValueMetaData(11)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(OpenURLNotification.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        SHOW_DIALOG(1, "showDialog"),
        URL(2, "url");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return SHOW_DIALOG;
                }
                case 2: {
                    return URL;
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

    private static class OpenURLNotificationStandardSchemeFactory
    implements SchemeFactory {
        private OpenURLNotificationStandardSchemeFactory() {
        }

        public OpenURLNotificationStandardScheme getScheme() {
            return new OpenURLNotificationStandardScheme();
        }
    }

    private static class OpenURLNotificationTupleSchemeFactory
    implements SchemeFactory {
        private OpenURLNotificationTupleSchemeFactory() {
        }

        public OpenURLNotificationTupleScheme getScheme() {
            return new OpenURLNotificationTupleScheme();
        }
    }

    private static class OpenURLNotificationTupleScheme
    extends TupleScheme<OpenURLNotification> {
        private OpenURLNotificationTupleScheme() {
        }

        public void write(TProtocol tProtocol, OpenURLNotification openURLNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (openURLNotification.isSetShowDialog()) {
                bitSet.set(0);
            }
            if (openURLNotification.isSetUrl()) {
                bitSet.set(1);
            }
            tTupleProtocol.writeBitSet(bitSet, 2);
            if (openURLNotification.isSetShowDialog()) {
                tTupleProtocol.writeBool(openURLNotification.showDialog);
            }
            if (openURLNotification.isSetUrl()) {
                tTupleProtocol.writeString(openURLNotification.url);
            }
        }

        public void read(TProtocol tProtocol, OpenURLNotification openURLNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(2);
            if (bitSet.get(0)) {
                openURLNotification.showDialog = tTupleProtocol.readBool();
                openURLNotification.setShowDialogIsSet(true);
            }
            if (bitSet.get(1)) {
                openURLNotification.url = tTupleProtocol.readString();
                openURLNotification.setUrlIsSet(true);
            }
        }
    }

    private static class OpenURLNotificationStandardScheme
    extends StandardScheme<OpenURLNotification> {
        private OpenURLNotificationStandardScheme() {
        }

        public void read(TProtocol tProtocol, OpenURLNotification openURLNotification) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 2) {
                            openURLNotification.showDialog = tProtocol.readBool();
                            openURLNotification.setShowDialogIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 11) {
                            openURLNotification.url = tProtocol.readString();
                            openURLNotification.setUrlIsSet(true);
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
            openURLNotification.validate();
        }

        public void write(TProtocol tProtocol, OpenURLNotification openURLNotification) throws TException {
            openURLNotification.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            tProtocol.writeFieldBegin(SHOW_DIALOG_FIELD_DESC);
            tProtocol.writeBool(openURLNotification.showDialog);
            tProtocol.writeFieldEnd();
            if (openURLNotification.url != null) {
                tProtocol.writeFieldBegin(URL_FIELD_DESC);
                tProtocol.writeString(openURLNotification.url);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

