/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.thrift.TBase
 *  org.apache.thrift.TBaseHelper
 *  org.apache.thrift.TException
 *  org.apache.thrift.TFieldIdEnum
 *  org.apache.thrift.annotation.Nullable
 *  org.apache.thrift.meta_data.EnumMetaData
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

import com.filemaker.jwpc.iwp.thrift.common.SaveRecordsOption;
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
import org.apache.thrift.meta_data.EnumMetaData;
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

public class SaveAsSsLinkDialogNotification
implements TBase<SaveAsSsLinkDialogNotification, _Fields>,
Serializable,
Cloneable,
Comparable<SaveAsSsLinkDialogNotification> {
    private static final TStruct STRUCT_DESC = new TStruct("SaveAsSsLinkDialogNotification");
    private static final TField SAVE_OPTION_FIELD_DESC = new TField("saveOption", 8, 1);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new SaveAsSsLinkDialogNotificationStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new SaveAsSsLinkDialogNotificationTupleSchemeFactory();
    @Nullable
    private SaveRecordsOption saveOption;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public SaveAsSsLinkDialogNotification() {
    }

    public SaveAsSsLinkDialogNotification(SaveRecordsOption saveRecordsOption) {
        this();
        this.saveOption = saveRecordsOption;
    }

    public SaveAsSsLinkDialogNotification(SaveAsSsLinkDialogNotification saveAsSsLinkDialogNotification) {
        if (saveAsSsLinkDialogNotification.isSetSaveOption()) {
            this.saveOption = saveAsSsLinkDialogNotification.saveOption;
        }
    }

    public SaveAsSsLinkDialogNotification deepCopy() {
        return new SaveAsSsLinkDialogNotification(this);
    }

    public void clear() {
        this.saveOption = null;
    }

    @Nullable
    public SaveRecordsOption getSaveOption() {
        return this.saveOption;
    }

    public void setSaveOption(@Nullable SaveRecordsOption saveRecordsOption) {
        this.saveOption = saveRecordsOption;
    }

    public void unsetSaveOption() {
        this.saveOption = null;
    }

    public boolean isSetSaveOption() {
        return this.saveOption != null;
    }

    public void setSaveOptionIsSet(boolean bl) {
        if (!bl) {
            this.saveOption = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetSaveOption();
                    break;
                }
                this.setSaveOption((SaveRecordsOption)((Object)object));
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getSaveOption();
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
                return this.isSetSaveOption();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof SaveAsSsLinkDialogNotification) {
            return this.equals((SaveAsSsLinkDialogNotification)object);
        }
        return false;
    }

    public boolean equals(SaveAsSsLinkDialogNotification saveAsSsLinkDialogNotification) {
        if (saveAsSsLinkDialogNotification == null) {
            return false;
        }
        if (this == saveAsSsLinkDialogNotification) {
            return true;
        }
        boolean bl = this.isSetSaveOption();
        boolean bl2 = saveAsSsLinkDialogNotification.isSetSaveOption();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.saveOption.equals((Object)saveAsSsLinkDialogNotification.saveOption)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetSaveOption() ? 131071 : 524287);
        if (this.isSetSaveOption()) {
            n = n * 8191 + this.saveOption.getValue();
        }
        return n;
    }

    @Override
    public int compareTo(SaveAsSsLinkDialogNotification saveAsSsLinkDialogNotification) {
        if (!this.getClass().equals(saveAsSsLinkDialogNotification.getClass())) {
            return this.getClass().getName().compareTo(saveAsSsLinkDialogNotification.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetSaveOption(), saveAsSsLinkDialogNotification.isSetSaveOption());
        if (n != 0) {
            return n;
        }
        if (this.isSetSaveOption() && (n = TBaseHelper.compareTo((Comparable)((Object)this.saveOption), (Comparable)((Object)saveAsSsLinkDialogNotification.saveOption))) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        SaveAsSsLinkDialogNotification.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        SaveAsSsLinkDialogNotification.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("SaveAsSsLinkDialogNotification(");
        boolean bl = true;
        stringBuilder.append("saveOption:");
        if (this.saveOption == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append((Object)this.saveOption);
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
        enumMap.put(_Fields.SAVE_OPTION, new FieldMetaData("saveOption", 3, (FieldValueMetaData)new EnumMetaData(-1, SaveRecordsOption.class)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(SaveAsSsLinkDialogNotification.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        SAVE_OPTION(1, "saveOption");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return SAVE_OPTION;
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

    private static class SaveAsSsLinkDialogNotificationStandardSchemeFactory
    implements SchemeFactory {
        private SaveAsSsLinkDialogNotificationStandardSchemeFactory() {
        }

        public SaveAsSsLinkDialogNotificationStandardScheme getScheme() {
            return new SaveAsSsLinkDialogNotificationStandardScheme();
        }
    }

    private static class SaveAsSsLinkDialogNotificationTupleSchemeFactory
    implements SchemeFactory {
        private SaveAsSsLinkDialogNotificationTupleSchemeFactory() {
        }

        public SaveAsSsLinkDialogNotificationTupleScheme getScheme() {
            return new SaveAsSsLinkDialogNotificationTupleScheme();
        }
    }

    private static class SaveAsSsLinkDialogNotificationTupleScheme
    extends TupleScheme<SaveAsSsLinkDialogNotification> {
        private SaveAsSsLinkDialogNotificationTupleScheme() {
        }

        public void write(TProtocol tProtocol, SaveAsSsLinkDialogNotification saveAsSsLinkDialogNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (saveAsSsLinkDialogNotification.isSetSaveOption()) {
                bitSet.set(0);
            }
            tTupleProtocol.writeBitSet(bitSet, 1);
            if (saveAsSsLinkDialogNotification.isSetSaveOption()) {
                tTupleProtocol.writeI32(saveAsSsLinkDialogNotification.saveOption.getValue());
            }
        }

        public void read(TProtocol tProtocol, SaveAsSsLinkDialogNotification saveAsSsLinkDialogNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(1);
            if (bitSet.get(0)) {
                saveAsSsLinkDialogNotification.saveOption = SaveRecordsOption.findByValue(tTupleProtocol.readI32());
                saveAsSsLinkDialogNotification.setSaveOptionIsSet(true);
            }
        }
    }

    private static class SaveAsSsLinkDialogNotificationStandardScheme
    extends StandardScheme<SaveAsSsLinkDialogNotification> {
        private SaveAsSsLinkDialogNotificationStandardScheme() {
        }

        public void read(TProtocol tProtocol, SaveAsSsLinkDialogNotification saveAsSsLinkDialogNotification) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 8) {
                            saveAsSsLinkDialogNotification.saveOption = SaveRecordsOption.findByValue(tProtocol.readI32());
                            saveAsSsLinkDialogNotification.setSaveOptionIsSet(true);
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
            saveAsSsLinkDialogNotification.validate();
        }

        public void write(TProtocol tProtocol, SaveAsSsLinkDialogNotification saveAsSsLinkDialogNotification) throws TException {
            saveAsSsLinkDialogNotification.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (saveAsSsLinkDialogNotification.saveOption != null) {
                tProtocol.writeFieldBegin(SAVE_OPTION_FIELD_DESC);
                tProtocol.writeI32(saveAsSsLinkDialogNotification.saveOption.getValue());
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

