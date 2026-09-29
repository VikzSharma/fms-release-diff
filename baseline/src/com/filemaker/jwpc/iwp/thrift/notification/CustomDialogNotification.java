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
package com.filemaker.jwpc.iwp.thrift.notification;

import com.filemaker.jwpc.iwp.thrift.dialog.DialogData;
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

public class CustomDialogNotification
implements TBase<CustomDialogNotification, _Fields>,
Serializable,
Cloneable,
Comparable<CustomDialogNotification> {
    private static final TStruct STRUCT_DESC = new TStruct("CustomDialogNotification");
    private static final TField DIALOG_DATA_FIELD_DESC = new TField("dialogData", 12, 1);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new CustomDialogNotificationStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new CustomDialogNotificationTupleSchemeFactory();
    @Nullable
    private DialogData dialogData;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public CustomDialogNotification() {
    }

    public CustomDialogNotification(DialogData dialogData) {
        this();
        this.dialogData = dialogData;
    }

    public CustomDialogNotification(CustomDialogNotification customDialogNotification) {
        if (customDialogNotification.isSetDialogData()) {
            this.dialogData = new DialogData(customDialogNotification.dialogData);
        }
    }

    public CustomDialogNotification deepCopy() {
        return new CustomDialogNotification(this);
    }

    public void clear() {
        this.dialogData = null;
    }

    @Nullable
    public DialogData getDialogData() {
        return this.dialogData;
    }

    public void setDialogData(@Nullable DialogData dialogData) {
        this.dialogData = dialogData;
    }

    public void unsetDialogData() {
        this.dialogData = null;
    }

    public boolean isSetDialogData() {
        return this.dialogData != null;
    }

    public void setDialogDataIsSet(boolean bl) {
        if (!bl) {
            this.dialogData = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetDialogData();
                    break;
                }
                this.setDialogData((DialogData)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getDialogData();
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
                return this.isSetDialogData();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof CustomDialogNotification) {
            return this.equals((CustomDialogNotification)object);
        }
        return false;
    }

    public boolean equals(CustomDialogNotification customDialogNotification) {
        if (customDialogNotification == null) {
            return false;
        }
        if (this == customDialogNotification) {
            return true;
        }
        boolean bl = this.isSetDialogData();
        boolean bl2 = customDialogNotification.isSetDialogData();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.dialogData.equals(customDialogNotification.dialogData)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetDialogData() ? 131071 : 524287);
        if (this.isSetDialogData()) {
            n = n * 8191 + this.dialogData.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(CustomDialogNotification customDialogNotification) {
        if (!this.getClass().equals(customDialogNotification.getClass())) {
            return this.getClass().getName().compareTo(customDialogNotification.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetDialogData(), customDialogNotification.isSetDialogData());
        if (n != 0) {
            return n;
        }
        if (this.isSetDialogData() && (n = TBaseHelper.compareTo((Comparable)this.dialogData, (Comparable)customDialogNotification.dialogData)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        CustomDialogNotification.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        CustomDialogNotification.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("CustomDialogNotification(");
        boolean bl = true;
        stringBuilder.append("dialogData:");
        if (this.dialogData == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.dialogData);
        }
        bl = false;
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void validate() throws TException {
        if (this.dialogData != null) {
            this.dialogData.validate();
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
        enumMap.put(_Fields.DIALOG_DATA, new FieldMetaData("dialogData", 3, (FieldValueMetaData)new StructMetaData(12, DialogData.class)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(CustomDialogNotification.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        DIALOG_DATA(1, "dialogData");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return DIALOG_DATA;
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

    private static class CustomDialogNotificationStandardSchemeFactory
    implements SchemeFactory {
        private CustomDialogNotificationStandardSchemeFactory() {
        }

        public CustomDialogNotificationStandardScheme getScheme() {
            return new CustomDialogNotificationStandardScheme();
        }
    }

    private static class CustomDialogNotificationTupleSchemeFactory
    implements SchemeFactory {
        private CustomDialogNotificationTupleSchemeFactory() {
        }

        public CustomDialogNotificationTupleScheme getScheme() {
            return new CustomDialogNotificationTupleScheme();
        }
    }

    private static class CustomDialogNotificationTupleScheme
    extends TupleScheme<CustomDialogNotification> {
        private CustomDialogNotificationTupleScheme() {
        }

        public void write(TProtocol tProtocol, CustomDialogNotification customDialogNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (customDialogNotification.isSetDialogData()) {
                bitSet.set(0);
            }
            tTupleProtocol.writeBitSet(bitSet, 1);
            if (customDialogNotification.isSetDialogData()) {
                customDialogNotification.dialogData.write((TProtocol)tTupleProtocol);
            }
        }

        public void read(TProtocol tProtocol, CustomDialogNotification customDialogNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(1);
            if (bitSet.get(0)) {
                customDialogNotification.dialogData = new DialogData();
                customDialogNotification.dialogData.read((TProtocol)tTupleProtocol);
                customDialogNotification.setDialogDataIsSet(true);
            }
        }
    }

    private static class CustomDialogNotificationStandardScheme
    extends StandardScheme<CustomDialogNotification> {
        private CustomDialogNotificationStandardScheme() {
        }

        public void read(TProtocol tProtocol, CustomDialogNotification customDialogNotification) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 12) {
                            customDialogNotification.dialogData = new DialogData();
                            customDialogNotification.dialogData.read(tProtocol);
                            customDialogNotification.setDialogDataIsSet(true);
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
            customDialogNotification.validate();
        }

        public void write(TProtocol tProtocol, CustomDialogNotification customDialogNotification) throws TException {
            customDialogNotification.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (customDialogNotification.dialogData != null) {
                tProtocol.writeFieldBegin(DIALOG_DATA_FIELD_DESC);
                customDialogNotification.dialogData.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

