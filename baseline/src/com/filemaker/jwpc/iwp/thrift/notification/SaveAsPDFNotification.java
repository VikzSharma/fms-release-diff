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
package com.filemaker.jwpc.iwp.thrift.notification;

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

public class SaveAsPDFNotification
implements TBase<SaveAsPDFNotification, _Fields>,
Serializable,
Cloneable,
Comparable<SaveAsPDFNotification> {
    private static final TStruct STRUCT_DESC = new TStruct("SaveAsPDFNotification");
    private static final TField VIEW_PDF_FIELD_DESC = new TField("viewPDF", 2, 1);
    private static final TField VIEW_NAME_FIELD_DESC = new TField("viewName", 11, 2);
    private static final TField OUTPUT_PATH_FIELD_DESC = new TField("outputPath", 11, 3);
    private static final TField KEY_FIELD_DESC = new TField("key", 11, 4);
    private static final TField SETTINGS_FIELD_DESC = new TField("settings", 12, 5);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new SaveAsPDFNotificationStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new SaveAsPDFNotificationTupleSchemeFactory();
    private boolean viewPDF;
    @Nullable
    private String viewName;
    @Nullable
    private String outputPath;
    @Nullable
    private String key;
    @Nullable
    private SaveAsPDFSettings settings;
    private static final int __VIEWPDF_ISSET_ID = 0;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public SaveAsPDFNotification() {
    }

    public SaveAsPDFNotification(boolean bl, String string, String string2, String string3, SaveAsPDFSettings saveAsPDFSettings) {
        this();
        this.viewPDF = bl;
        this.setViewPDFIsSet(true);
        this.viewName = string;
        this.outputPath = string2;
        this.key = string3;
        this.settings = saveAsPDFSettings;
    }

    public SaveAsPDFNotification(SaveAsPDFNotification saveAsPDFNotification) {
        this.__isset_bitfield = saveAsPDFNotification.__isset_bitfield;
        this.viewPDF = saveAsPDFNotification.viewPDF;
        if (saveAsPDFNotification.isSetViewName()) {
            this.viewName = saveAsPDFNotification.viewName;
        }
        if (saveAsPDFNotification.isSetOutputPath()) {
            this.outputPath = saveAsPDFNotification.outputPath;
        }
        if (saveAsPDFNotification.isSetKey()) {
            this.key = saveAsPDFNotification.key;
        }
        if (saveAsPDFNotification.isSetSettings()) {
            this.settings = new SaveAsPDFSettings(saveAsPDFNotification.settings);
        }
    }

    public SaveAsPDFNotification deepCopy() {
        return new SaveAsPDFNotification(this);
    }

    public void clear() {
        this.setViewPDFIsSet(false);
        this.viewPDF = false;
        this.viewName = null;
        this.outputPath = null;
        this.key = null;
        this.settings = null;
    }

    public boolean isViewPDF() {
        return this.viewPDF;
    }

    public void setViewPDF(boolean bl) {
        this.viewPDF = bl;
        this.setViewPDFIsSet(true);
    }

    public void unsetViewPDF() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetViewPDF() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setViewPDFIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    @Nullable
    public String getViewName() {
        return this.viewName;
    }

    public void setViewName(@Nullable String string) {
        this.viewName = string;
    }

    public void unsetViewName() {
        this.viewName = null;
    }

    public boolean isSetViewName() {
        return this.viewName != null;
    }

    public void setViewNameIsSet(boolean bl) {
        if (!bl) {
            this.viewName = null;
        }
    }

    @Nullable
    public String getOutputPath() {
        return this.outputPath;
    }

    public void setOutputPath(@Nullable String string) {
        this.outputPath = string;
    }

    public void unsetOutputPath() {
        this.outputPath = null;
    }

    public boolean isSetOutputPath() {
        return this.outputPath != null;
    }

    public void setOutputPathIsSet(boolean bl) {
        if (!bl) {
            this.outputPath = null;
        }
    }

    @Nullable
    public String getKey() {
        return this.key;
    }

    public void setKey(@Nullable String string) {
        this.key = string;
    }

    public void unsetKey() {
        this.key = null;
    }

    public boolean isSetKey() {
        return this.key != null;
    }

    public void setKeyIsSet(boolean bl) {
        if (!bl) {
            this.key = null;
        }
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
                    this.unsetViewPDF();
                    break;
                }
                this.setViewPDF((Boolean)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetViewName();
                    break;
                }
                this.setViewName((String)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetOutputPath();
                    break;
                }
                this.setOutputPath((String)object);
                break;
            }
            case 3: {
                if (object == null) {
                    this.unsetKey();
                    break;
                }
                this.setKey((String)object);
                break;
            }
            case 4: {
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
                return this.isViewPDF();
            }
            case 1: {
                return this.getViewName();
            }
            case 2: {
                return this.getOutputPath();
            }
            case 3: {
                return this.getKey();
            }
            case 4: {
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
                return this.isSetViewPDF();
            }
            case 1: {
                return this.isSetViewName();
            }
            case 2: {
                return this.isSetOutputPath();
            }
            case 3: {
                return this.isSetKey();
            }
            case 4: {
                return this.isSetSettings();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof SaveAsPDFNotification) {
            return this.equals((SaveAsPDFNotification)object);
        }
        return false;
    }

    public boolean equals(SaveAsPDFNotification saveAsPDFNotification) {
        if (saveAsPDFNotification == null) {
            return false;
        }
        if (this == saveAsPDFNotification) {
            return true;
        }
        boolean bl = true;
        boolean bl2 = true;
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (this.viewPDF != saveAsPDFNotification.viewPDF) {
                return false;
            }
        }
        boolean bl3 = this.isSetViewName();
        boolean bl4 = saveAsPDFNotification.isSetViewName();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.viewName.equals(saveAsPDFNotification.viewName)) {
                return false;
            }
        }
        boolean bl5 = this.isSetOutputPath();
        boolean bl6 = saveAsPDFNotification.isSetOutputPath();
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (!this.outputPath.equals(saveAsPDFNotification.outputPath)) {
                return false;
            }
        }
        boolean bl7 = this.isSetKey();
        boolean bl8 = saveAsPDFNotification.isSetKey();
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (!this.key.equals(saveAsPDFNotification.key)) {
                return false;
            }
        }
        boolean bl9 = this.isSetSettings();
        boolean bl10 = saveAsPDFNotification.isSetSettings();
        if (bl9 || bl10) {
            if (!bl9 || !bl10) {
                return false;
            }
            if (!this.settings.equals(saveAsPDFNotification.settings)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.viewPDF ? 131071 : 524287);
        n = n * 8191 + (this.isSetViewName() ? 131071 : 524287);
        if (this.isSetViewName()) {
            n = n * 8191 + this.viewName.hashCode();
        }
        n = n * 8191 + (this.isSetOutputPath() ? 131071 : 524287);
        if (this.isSetOutputPath()) {
            n = n * 8191 + this.outputPath.hashCode();
        }
        n = n * 8191 + (this.isSetKey() ? 131071 : 524287);
        if (this.isSetKey()) {
            n = n * 8191 + this.key.hashCode();
        }
        n = n * 8191 + (this.isSetSettings() ? 131071 : 524287);
        if (this.isSetSettings()) {
            n = n * 8191 + this.settings.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(SaveAsPDFNotification saveAsPDFNotification) {
        if (!this.getClass().equals(saveAsPDFNotification.getClass())) {
            return this.getClass().getName().compareTo(saveAsPDFNotification.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetViewPDF(), saveAsPDFNotification.isSetViewPDF());
        if (n != 0) {
            return n;
        }
        if (this.isSetViewPDF() && (n = TBaseHelper.compareTo((boolean)this.viewPDF, (boolean)saveAsPDFNotification.viewPDF)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetViewName(), saveAsPDFNotification.isSetViewName());
        if (n != 0) {
            return n;
        }
        if (this.isSetViewName() && (n = TBaseHelper.compareTo((String)this.viewName, (String)saveAsPDFNotification.viewName)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetOutputPath(), saveAsPDFNotification.isSetOutputPath());
        if (n != 0) {
            return n;
        }
        if (this.isSetOutputPath() && (n = TBaseHelper.compareTo((String)this.outputPath, (String)saveAsPDFNotification.outputPath)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetKey(), saveAsPDFNotification.isSetKey());
        if (n != 0) {
            return n;
        }
        if (this.isSetKey() && (n = TBaseHelper.compareTo((String)this.key, (String)saveAsPDFNotification.key)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetSettings(), saveAsPDFNotification.isSetSettings());
        if (n != 0) {
            return n;
        }
        if (this.isSetSettings() && (n = TBaseHelper.compareTo((Comparable)this.settings, (Comparable)saveAsPDFNotification.settings)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        SaveAsPDFNotification.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        SaveAsPDFNotification.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("SaveAsPDFNotification(");
        boolean bl = true;
        stringBuilder.append("viewPDF:");
        stringBuilder.append(this.viewPDF);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("viewName:");
        if (this.viewName == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.viewName);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("outputPath:");
        if (this.outputPath == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.outputPath);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("key:");
        if (this.key == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.key);
        }
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
        enumMap.put(_Fields.VIEW_PDF, new FieldMetaData("viewPDF", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.VIEW_NAME, new FieldMetaData("viewName", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.OUTPUT_PATH, new FieldMetaData("outputPath", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.KEY, new FieldMetaData("key", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.SETTINGS, new FieldMetaData("settings", 3, (FieldValueMetaData)new StructMetaData(12, SaveAsPDFSettings.class)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(SaveAsPDFNotification.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        VIEW_PDF(1, "viewPDF"),
        VIEW_NAME(2, "viewName"),
        OUTPUT_PATH(3, "outputPath"),
        KEY(4, "key"),
        SETTINGS(5, "settings");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return VIEW_PDF;
                }
                case 2: {
                    return VIEW_NAME;
                }
                case 3: {
                    return OUTPUT_PATH;
                }
                case 4: {
                    return KEY;
                }
                case 5: {
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

    private static class SaveAsPDFNotificationStandardSchemeFactory
    implements SchemeFactory {
        private SaveAsPDFNotificationStandardSchemeFactory() {
        }

        public SaveAsPDFNotificationStandardScheme getScheme() {
            return new SaveAsPDFNotificationStandardScheme();
        }
    }

    private static class SaveAsPDFNotificationTupleSchemeFactory
    implements SchemeFactory {
        private SaveAsPDFNotificationTupleSchemeFactory() {
        }

        public SaveAsPDFNotificationTupleScheme getScheme() {
            return new SaveAsPDFNotificationTupleScheme();
        }
    }

    private static class SaveAsPDFNotificationTupleScheme
    extends TupleScheme<SaveAsPDFNotification> {
        private SaveAsPDFNotificationTupleScheme() {
        }

        public void write(TProtocol tProtocol, SaveAsPDFNotification saveAsPDFNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (saveAsPDFNotification.isSetViewPDF()) {
                bitSet.set(0);
            }
            if (saveAsPDFNotification.isSetViewName()) {
                bitSet.set(1);
            }
            if (saveAsPDFNotification.isSetOutputPath()) {
                bitSet.set(2);
            }
            if (saveAsPDFNotification.isSetKey()) {
                bitSet.set(3);
            }
            if (saveAsPDFNotification.isSetSettings()) {
                bitSet.set(4);
            }
            tTupleProtocol.writeBitSet(bitSet, 5);
            if (saveAsPDFNotification.isSetViewPDF()) {
                tTupleProtocol.writeBool(saveAsPDFNotification.viewPDF);
            }
            if (saveAsPDFNotification.isSetViewName()) {
                tTupleProtocol.writeString(saveAsPDFNotification.viewName);
            }
            if (saveAsPDFNotification.isSetOutputPath()) {
                tTupleProtocol.writeString(saveAsPDFNotification.outputPath);
            }
            if (saveAsPDFNotification.isSetKey()) {
                tTupleProtocol.writeString(saveAsPDFNotification.key);
            }
            if (saveAsPDFNotification.isSetSettings()) {
                saveAsPDFNotification.settings.write((TProtocol)tTupleProtocol);
            }
        }

        public void read(TProtocol tProtocol, SaveAsPDFNotification saveAsPDFNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(5);
            if (bitSet.get(0)) {
                saveAsPDFNotification.viewPDF = tTupleProtocol.readBool();
                saveAsPDFNotification.setViewPDFIsSet(true);
            }
            if (bitSet.get(1)) {
                saveAsPDFNotification.viewName = tTupleProtocol.readString();
                saveAsPDFNotification.setViewNameIsSet(true);
            }
            if (bitSet.get(2)) {
                saveAsPDFNotification.outputPath = tTupleProtocol.readString();
                saveAsPDFNotification.setOutputPathIsSet(true);
            }
            if (bitSet.get(3)) {
                saveAsPDFNotification.key = tTupleProtocol.readString();
                saveAsPDFNotification.setKeyIsSet(true);
            }
            if (bitSet.get(4)) {
                saveAsPDFNotification.settings = new SaveAsPDFSettings();
                saveAsPDFNotification.settings.read((TProtocol)tTupleProtocol);
                saveAsPDFNotification.setSettingsIsSet(true);
            }
        }
    }

    private static class SaveAsPDFNotificationStandardScheme
    extends StandardScheme<SaveAsPDFNotification> {
        private SaveAsPDFNotificationStandardScheme() {
        }

        public void read(TProtocol tProtocol, SaveAsPDFNotification saveAsPDFNotification) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 2) {
                            saveAsPDFNotification.viewPDF = tProtocol.readBool();
                            saveAsPDFNotification.setViewPDFIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 11) {
                            saveAsPDFNotification.viewName = tProtocol.readString();
                            saveAsPDFNotification.setViewNameIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 11) {
                            saveAsPDFNotification.outputPath = tProtocol.readString();
                            saveAsPDFNotification.setOutputPathIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 11) {
                            saveAsPDFNotification.key = tProtocol.readString();
                            saveAsPDFNotification.setKeyIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 5: {
                        if (tField.type == 12) {
                            saveAsPDFNotification.settings = new SaveAsPDFSettings();
                            saveAsPDFNotification.settings.read(tProtocol);
                            saveAsPDFNotification.setSettingsIsSet(true);
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
            saveAsPDFNotification.validate();
        }

        public void write(TProtocol tProtocol, SaveAsPDFNotification saveAsPDFNotification) throws TException {
            saveAsPDFNotification.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            tProtocol.writeFieldBegin(VIEW_PDF_FIELD_DESC);
            tProtocol.writeBool(saveAsPDFNotification.viewPDF);
            tProtocol.writeFieldEnd();
            if (saveAsPDFNotification.viewName != null) {
                tProtocol.writeFieldBegin(VIEW_NAME_FIELD_DESC);
                tProtocol.writeString(saveAsPDFNotification.viewName);
                tProtocol.writeFieldEnd();
            }
            if (saveAsPDFNotification.outputPath != null) {
                tProtocol.writeFieldBegin(OUTPUT_PATH_FIELD_DESC);
                tProtocol.writeString(saveAsPDFNotification.outputPath);
                tProtocol.writeFieldEnd();
            }
            if (saveAsPDFNotification.key != null) {
                tProtocol.writeFieldBegin(KEY_FIELD_DESC);
                tProtocol.writeString(saveAsPDFNotification.key);
                tProtocol.writeFieldEnd();
            }
            if (saveAsPDFNotification.settings != null) {
                tProtocol.writeFieldBegin(SETTINGS_FIELD_DESC);
                saveAsPDFNotification.settings.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

