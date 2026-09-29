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
package com.filemaker.jwpc.iwp.thrift.common;

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

public class SaveAsSsLinkDialogResult
implements TBase<SaveAsSsLinkDialogResult, _Fields>,
Serializable,
Cloneable,
Comparable<SaveAsSsLinkDialogResult> {
    private static final TStruct STRUCT_DESC = new TStruct("SaveAsSsLinkDialogResult");
    private static final TField SS_LINK_FILE_NAME_FIELD_DESC = new TField("ssLinkFileName", 11, 1);
    private static final TField SAVE_OPTION_FIELD_DESC = new TField("saveOption", 8, 2);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new SaveAsSsLinkDialogResultStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new SaveAsSsLinkDialogResultTupleSchemeFactory();
    @Nullable
    private String ssLinkFileName;
    @Nullable
    private SaveRecordsOption saveOption;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public SaveAsSsLinkDialogResult() {
    }

    public SaveAsSsLinkDialogResult(String string, SaveRecordsOption saveRecordsOption) {
        this();
        this.ssLinkFileName = string;
        this.saveOption = saveRecordsOption;
    }

    public SaveAsSsLinkDialogResult(SaveAsSsLinkDialogResult saveAsSsLinkDialogResult) {
        if (saveAsSsLinkDialogResult.isSetSsLinkFileName()) {
            this.ssLinkFileName = saveAsSsLinkDialogResult.ssLinkFileName;
        }
        if (saveAsSsLinkDialogResult.isSetSaveOption()) {
            this.saveOption = saveAsSsLinkDialogResult.saveOption;
        }
    }

    public SaveAsSsLinkDialogResult deepCopy() {
        return new SaveAsSsLinkDialogResult(this);
    }

    public void clear() {
        this.ssLinkFileName = null;
        this.saveOption = null;
    }

    @Nullable
    public String getSsLinkFileName() {
        return this.ssLinkFileName;
    }

    public void setSsLinkFileName(@Nullable String string) {
        this.ssLinkFileName = string;
    }

    public void unsetSsLinkFileName() {
        this.ssLinkFileName = null;
    }

    public boolean isSetSsLinkFileName() {
        return this.ssLinkFileName != null;
    }

    public void setSsLinkFileNameIsSet(boolean bl) {
        if (!bl) {
            this.ssLinkFileName = null;
        }
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
                    this.unsetSsLinkFileName();
                    break;
                }
                this.setSsLinkFileName((String)object);
                break;
            }
            case 1: {
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
                return this.getSsLinkFileName();
            }
            case 1: {
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
                return this.isSetSsLinkFileName();
            }
            case 1: {
                return this.isSetSaveOption();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof SaveAsSsLinkDialogResult) {
            return this.equals((SaveAsSsLinkDialogResult)object);
        }
        return false;
    }

    public boolean equals(SaveAsSsLinkDialogResult saveAsSsLinkDialogResult) {
        if (saveAsSsLinkDialogResult == null) {
            return false;
        }
        if (this == saveAsSsLinkDialogResult) {
            return true;
        }
        boolean bl = this.isSetSsLinkFileName();
        boolean bl2 = saveAsSsLinkDialogResult.isSetSsLinkFileName();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.ssLinkFileName.equals(saveAsSsLinkDialogResult.ssLinkFileName)) {
                return false;
            }
        }
        boolean bl3 = this.isSetSaveOption();
        boolean bl4 = saveAsSsLinkDialogResult.isSetSaveOption();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.saveOption.equals((Object)saveAsSsLinkDialogResult.saveOption)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetSsLinkFileName() ? 131071 : 524287);
        if (this.isSetSsLinkFileName()) {
            n = n * 8191 + this.ssLinkFileName.hashCode();
        }
        n = n * 8191 + (this.isSetSaveOption() ? 131071 : 524287);
        if (this.isSetSaveOption()) {
            n = n * 8191 + this.saveOption.getValue();
        }
        return n;
    }

    @Override
    public int compareTo(SaveAsSsLinkDialogResult saveAsSsLinkDialogResult) {
        if (!this.getClass().equals(saveAsSsLinkDialogResult.getClass())) {
            return this.getClass().getName().compareTo(saveAsSsLinkDialogResult.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetSsLinkFileName(), saveAsSsLinkDialogResult.isSetSsLinkFileName());
        if (n != 0) {
            return n;
        }
        if (this.isSetSsLinkFileName() && (n = TBaseHelper.compareTo((String)this.ssLinkFileName, (String)saveAsSsLinkDialogResult.ssLinkFileName)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetSaveOption(), saveAsSsLinkDialogResult.isSetSaveOption());
        if (n != 0) {
            return n;
        }
        if (this.isSetSaveOption() && (n = TBaseHelper.compareTo((Comparable)((Object)this.saveOption), (Comparable)((Object)saveAsSsLinkDialogResult.saveOption))) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        SaveAsSsLinkDialogResult.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        SaveAsSsLinkDialogResult.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("SaveAsSsLinkDialogResult(");
        boolean bl = true;
        stringBuilder.append("ssLinkFileName:");
        if (this.ssLinkFileName == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.ssLinkFileName);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
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
        enumMap.put(_Fields.SS_LINK_FILE_NAME, new FieldMetaData("ssLinkFileName", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.SAVE_OPTION, new FieldMetaData("saveOption", 3, (FieldValueMetaData)new EnumMetaData(-1, SaveRecordsOption.class)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(SaveAsSsLinkDialogResult.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        SS_LINK_FILE_NAME(1, "ssLinkFileName"),
        SAVE_OPTION(2, "saveOption");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return SS_LINK_FILE_NAME;
                }
                case 2: {
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

    private static class SaveAsSsLinkDialogResultStandardSchemeFactory
    implements SchemeFactory {
        private SaveAsSsLinkDialogResultStandardSchemeFactory() {
        }

        public SaveAsSsLinkDialogResultStandardScheme getScheme() {
            return new SaveAsSsLinkDialogResultStandardScheme();
        }
    }

    private static class SaveAsSsLinkDialogResultTupleSchemeFactory
    implements SchemeFactory {
        private SaveAsSsLinkDialogResultTupleSchemeFactory() {
        }

        public SaveAsSsLinkDialogResultTupleScheme getScheme() {
            return new SaveAsSsLinkDialogResultTupleScheme();
        }
    }

    private static class SaveAsSsLinkDialogResultTupleScheme
    extends TupleScheme<SaveAsSsLinkDialogResult> {
        private SaveAsSsLinkDialogResultTupleScheme() {
        }

        public void write(TProtocol tProtocol, SaveAsSsLinkDialogResult saveAsSsLinkDialogResult) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (saveAsSsLinkDialogResult.isSetSsLinkFileName()) {
                bitSet.set(0);
            }
            if (saveAsSsLinkDialogResult.isSetSaveOption()) {
                bitSet.set(1);
            }
            tTupleProtocol.writeBitSet(bitSet, 2);
            if (saveAsSsLinkDialogResult.isSetSsLinkFileName()) {
                tTupleProtocol.writeString(saveAsSsLinkDialogResult.ssLinkFileName);
            }
            if (saveAsSsLinkDialogResult.isSetSaveOption()) {
                tTupleProtocol.writeI32(saveAsSsLinkDialogResult.saveOption.getValue());
            }
        }

        public void read(TProtocol tProtocol, SaveAsSsLinkDialogResult saveAsSsLinkDialogResult) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(2);
            if (bitSet.get(0)) {
                saveAsSsLinkDialogResult.ssLinkFileName = tTupleProtocol.readString();
                saveAsSsLinkDialogResult.setSsLinkFileNameIsSet(true);
            }
            if (bitSet.get(1)) {
                saveAsSsLinkDialogResult.saveOption = SaveRecordsOption.findByValue(tTupleProtocol.readI32());
                saveAsSsLinkDialogResult.setSaveOptionIsSet(true);
            }
        }
    }

    private static class SaveAsSsLinkDialogResultStandardScheme
    extends StandardScheme<SaveAsSsLinkDialogResult> {
        private SaveAsSsLinkDialogResultStandardScheme() {
        }

        public void read(TProtocol tProtocol, SaveAsSsLinkDialogResult saveAsSsLinkDialogResult) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 11) {
                            saveAsSsLinkDialogResult.ssLinkFileName = tProtocol.readString();
                            saveAsSsLinkDialogResult.setSsLinkFileNameIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 8) {
                            saveAsSsLinkDialogResult.saveOption = SaveRecordsOption.findByValue(tProtocol.readI32());
                            saveAsSsLinkDialogResult.setSaveOptionIsSet(true);
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
            saveAsSsLinkDialogResult.validate();
        }

        public void write(TProtocol tProtocol, SaveAsSsLinkDialogResult saveAsSsLinkDialogResult) throws TException {
            saveAsSsLinkDialogResult.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (saveAsSsLinkDialogResult.ssLinkFileName != null) {
                tProtocol.writeFieldBegin(SS_LINK_FILE_NAME_FIELD_DESC);
                tProtocol.writeString(saveAsSsLinkDialogResult.ssLinkFileName);
                tProtocol.writeFieldEnd();
            }
            if (saveAsSsLinkDialogResult.saveOption != null) {
                tProtocol.writeFieldBegin(SAVE_OPTION_FIELD_DESC);
                tProtocol.writeI32(saveAsSsLinkDialogResult.saveOption.getValue());
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

