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

public class SaveAsPDFSettings
implements TBase<SaveAsPDFSettings, _Fields>,
Serializable,
Cloneable,
Comparable<SaveAsPDFSettings> {
    private static final TStruct STRUCT_DESC = new TStruct("SaveAsPDFSettings");
    private static final TField DOC_SAVE_TYPE_FIELD_DESC = new TField("docSaveType", 8, 1);
    private static final TField PAGES_FROM_FIELD_DESC = new TField("pagesFrom", 8, 2);
    private static final TField PAGE_ORIENTATION_FIELD_DESC = new TField("pageOrientation", 8, 3);
    private static final TField SCALING_FIELD_DESC = new TField("scaling", 4, 4);
    private static final TField PAPER_SIZE_FIELD_DESC = new TField("paperSize", 8, 5);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new SaveAsPDFSettingsStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new SaveAsPDFSettingsTupleSchemeFactory();
    private int docSaveType;
    private int pagesFrom;
    private int pageOrientation;
    private double scaling;
    private int paperSize;
    private static final int __DOCSAVETYPE_ISSET_ID = 0;
    private static final int __PAGESFROM_ISSET_ID = 1;
    private static final int __PAGEORIENTATION_ISSET_ID = 2;
    private static final int __SCALING_ISSET_ID = 3;
    private static final int __PAPERSIZE_ISSET_ID = 4;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public SaveAsPDFSettings() {
    }

    public SaveAsPDFSettings(int n, int n2, int n3, double d, int n4) {
        this();
        this.docSaveType = n;
        this.setDocSaveTypeIsSet(true);
        this.pagesFrom = n2;
        this.setPagesFromIsSet(true);
        this.pageOrientation = n3;
        this.setPageOrientationIsSet(true);
        this.scaling = d;
        this.setScalingIsSet(true);
        this.paperSize = n4;
        this.setPaperSizeIsSet(true);
    }

    public SaveAsPDFSettings(SaveAsPDFSettings saveAsPDFSettings) {
        this.__isset_bitfield = saveAsPDFSettings.__isset_bitfield;
        this.docSaveType = saveAsPDFSettings.docSaveType;
        this.pagesFrom = saveAsPDFSettings.pagesFrom;
        this.pageOrientation = saveAsPDFSettings.pageOrientation;
        this.scaling = saveAsPDFSettings.scaling;
        this.paperSize = saveAsPDFSettings.paperSize;
    }

    public SaveAsPDFSettings deepCopy() {
        return new SaveAsPDFSettings(this);
    }

    public void clear() {
        this.setDocSaveTypeIsSet(false);
        this.docSaveType = 0;
        this.setPagesFromIsSet(false);
        this.pagesFrom = 0;
        this.setPageOrientationIsSet(false);
        this.pageOrientation = 0;
        this.setScalingIsSet(false);
        this.scaling = 0.0;
        this.setPaperSizeIsSet(false);
        this.paperSize = 0;
    }

    public int getDocSaveType() {
        return this.docSaveType;
    }

    public void setDocSaveType(int n) {
        this.docSaveType = n;
        this.setDocSaveTypeIsSet(true);
    }

    public void unsetDocSaveType() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetDocSaveType() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setDocSaveTypeIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public int getPagesFrom() {
        return this.pagesFrom;
    }

    public void setPagesFrom(int n) {
        this.pagesFrom = n;
        this.setPagesFromIsSet(true);
    }

    public void unsetPagesFrom() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)1);
    }

    public boolean isSetPagesFrom() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)1);
    }

    public void setPagesFromIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)1, (boolean)bl);
    }

    public int getPageOrientation() {
        return this.pageOrientation;
    }

    public void setPageOrientation(int n) {
        this.pageOrientation = n;
        this.setPageOrientationIsSet(true);
    }

    public void unsetPageOrientation() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)2);
    }

    public boolean isSetPageOrientation() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)2);
    }

    public void setPageOrientationIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)2, (boolean)bl);
    }

    public double getScaling() {
        return this.scaling;
    }

    public void setScaling(double d) {
        this.scaling = d;
        this.setScalingIsSet(true);
    }

    public void unsetScaling() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)3);
    }

    public boolean isSetScaling() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)3);
    }

    public void setScalingIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)3, (boolean)bl);
    }

    public int getPaperSize() {
        return this.paperSize;
    }

    public void setPaperSize(int n) {
        this.paperSize = n;
        this.setPaperSizeIsSet(true);
    }

    public void unsetPaperSize() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)4);
    }

    public boolean isSetPaperSize() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)4);
    }

    public void setPaperSizeIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)4, (boolean)bl);
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetDocSaveType();
                    break;
                }
                this.setDocSaveType((Integer)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetPagesFrom();
                    break;
                }
                this.setPagesFrom((Integer)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetPageOrientation();
                    break;
                }
                this.setPageOrientation((Integer)object);
                break;
            }
            case 3: {
                if (object == null) {
                    this.unsetScaling();
                    break;
                }
                this.setScaling((Double)object);
                break;
            }
            case 4: {
                if (object == null) {
                    this.unsetPaperSize();
                    break;
                }
                this.setPaperSize((Integer)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getDocSaveType();
            }
            case 1: {
                return this.getPagesFrom();
            }
            case 2: {
                return this.getPageOrientation();
            }
            case 3: {
                return this.getScaling();
            }
            case 4: {
                return this.getPaperSize();
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
                return this.isSetDocSaveType();
            }
            case 1: {
                return this.isSetPagesFrom();
            }
            case 2: {
                return this.isSetPageOrientation();
            }
            case 3: {
                return this.isSetScaling();
            }
            case 4: {
                return this.isSetPaperSize();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof SaveAsPDFSettings) {
            return this.equals((SaveAsPDFSettings)object);
        }
        return false;
    }

    public boolean equals(SaveAsPDFSettings saveAsPDFSettings) {
        if (saveAsPDFSettings == null) {
            return false;
        }
        if (this == saveAsPDFSettings) {
            return true;
        }
        boolean bl = true;
        boolean bl2 = true;
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (this.docSaveType != saveAsPDFSettings.docSaveType) {
                return false;
            }
        }
        boolean bl3 = true;
        boolean bl4 = true;
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (this.pagesFrom != saveAsPDFSettings.pagesFrom) {
                return false;
            }
        }
        boolean bl5 = true;
        boolean bl6 = true;
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (this.pageOrientation != saveAsPDFSettings.pageOrientation) {
                return false;
            }
        }
        boolean bl7 = true;
        boolean bl8 = true;
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (this.scaling != saveAsPDFSettings.scaling) {
                return false;
            }
        }
        boolean bl9 = true;
        boolean bl10 = true;
        if (bl9 || bl10) {
            if (!bl9 || !bl10) {
                return false;
            }
            if (this.paperSize != saveAsPDFSettings.paperSize) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + this.docSaveType;
        n = n * 8191 + this.pagesFrom;
        n = n * 8191 + this.pageOrientation;
        n = n * 8191 + TBaseHelper.hashCode((double)this.scaling);
        n = n * 8191 + this.paperSize;
        return n;
    }

    @Override
    public int compareTo(SaveAsPDFSettings saveAsPDFSettings) {
        if (!this.getClass().equals(saveAsPDFSettings.getClass())) {
            return this.getClass().getName().compareTo(saveAsPDFSettings.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetDocSaveType(), saveAsPDFSettings.isSetDocSaveType());
        if (n != 0) {
            return n;
        }
        if (this.isSetDocSaveType() && (n = TBaseHelper.compareTo((int)this.docSaveType, (int)saveAsPDFSettings.docSaveType)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetPagesFrom(), saveAsPDFSettings.isSetPagesFrom());
        if (n != 0) {
            return n;
        }
        if (this.isSetPagesFrom() && (n = TBaseHelper.compareTo((int)this.pagesFrom, (int)saveAsPDFSettings.pagesFrom)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetPageOrientation(), saveAsPDFSettings.isSetPageOrientation());
        if (n != 0) {
            return n;
        }
        if (this.isSetPageOrientation() && (n = TBaseHelper.compareTo((int)this.pageOrientation, (int)saveAsPDFSettings.pageOrientation)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetScaling(), saveAsPDFSettings.isSetScaling());
        if (n != 0) {
            return n;
        }
        if (this.isSetScaling() && (n = TBaseHelper.compareTo((double)this.scaling, (double)saveAsPDFSettings.scaling)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetPaperSize(), saveAsPDFSettings.isSetPaperSize());
        if (n != 0) {
            return n;
        }
        if (this.isSetPaperSize() && (n = TBaseHelper.compareTo((int)this.paperSize, (int)saveAsPDFSettings.paperSize)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        SaveAsPDFSettings.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        SaveAsPDFSettings.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("SaveAsPDFSettings(");
        boolean bl = true;
        stringBuilder.append("docSaveType:");
        stringBuilder.append(this.docSaveType);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("pagesFrom:");
        stringBuilder.append(this.pagesFrom);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("pageOrientation:");
        stringBuilder.append(this.pageOrientation);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("scaling:");
        stringBuilder.append(this.scaling);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("paperSize:");
        stringBuilder.append(this.paperSize);
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
        enumMap.put(_Fields.DOC_SAVE_TYPE, new FieldMetaData("docSaveType", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.PAGES_FROM, new FieldMetaData("pagesFrom", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.PAGE_ORIENTATION, new FieldMetaData("pageOrientation", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.SCALING, new FieldMetaData("scaling", 3, new FieldValueMetaData(4)));
        enumMap.put(_Fields.PAPER_SIZE, new FieldMetaData("paperSize", 3, new FieldValueMetaData(8)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(SaveAsPDFSettings.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        DOC_SAVE_TYPE(1, "docSaveType"),
        PAGES_FROM(2, "pagesFrom"),
        PAGE_ORIENTATION(3, "pageOrientation"),
        SCALING(4, "scaling"),
        PAPER_SIZE(5, "paperSize");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return DOC_SAVE_TYPE;
                }
                case 2: {
                    return PAGES_FROM;
                }
                case 3: {
                    return PAGE_ORIENTATION;
                }
                case 4: {
                    return SCALING;
                }
                case 5: {
                    return PAPER_SIZE;
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

    private static class SaveAsPDFSettingsStandardSchemeFactory
    implements SchemeFactory {
        private SaveAsPDFSettingsStandardSchemeFactory() {
        }

        public SaveAsPDFSettingsStandardScheme getScheme() {
            return new SaveAsPDFSettingsStandardScheme();
        }
    }

    private static class SaveAsPDFSettingsTupleSchemeFactory
    implements SchemeFactory {
        private SaveAsPDFSettingsTupleSchemeFactory() {
        }

        public SaveAsPDFSettingsTupleScheme getScheme() {
            return new SaveAsPDFSettingsTupleScheme();
        }
    }

    private static class SaveAsPDFSettingsTupleScheme
    extends TupleScheme<SaveAsPDFSettings> {
        private SaveAsPDFSettingsTupleScheme() {
        }

        public void write(TProtocol tProtocol, SaveAsPDFSettings saveAsPDFSettings) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (saveAsPDFSettings.isSetDocSaveType()) {
                bitSet.set(0);
            }
            if (saveAsPDFSettings.isSetPagesFrom()) {
                bitSet.set(1);
            }
            if (saveAsPDFSettings.isSetPageOrientation()) {
                bitSet.set(2);
            }
            if (saveAsPDFSettings.isSetScaling()) {
                bitSet.set(3);
            }
            if (saveAsPDFSettings.isSetPaperSize()) {
                bitSet.set(4);
            }
            tTupleProtocol.writeBitSet(bitSet, 5);
            if (saveAsPDFSettings.isSetDocSaveType()) {
                tTupleProtocol.writeI32(saveAsPDFSettings.docSaveType);
            }
            if (saveAsPDFSettings.isSetPagesFrom()) {
                tTupleProtocol.writeI32(saveAsPDFSettings.pagesFrom);
            }
            if (saveAsPDFSettings.isSetPageOrientation()) {
                tTupleProtocol.writeI32(saveAsPDFSettings.pageOrientation);
            }
            if (saveAsPDFSettings.isSetScaling()) {
                tTupleProtocol.writeDouble(saveAsPDFSettings.scaling);
            }
            if (saveAsPDFSettings.isSetPaperSize()) {
                tTupleProtocol.writeI32(saveAsPDFSettings.paperSize);
            }
        }

        public void read(TProtocol tProtocol, SaveAsPDFSettings saveAsPDFSettings) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(5);
            if (bitSet.get(0)) {
                saveAsPDFSettings.docSaveType = tTupleProtocol.readI32();
                saveAsPDFSettings.setDocSaveTypeIsSet(true);
            }
            if (bitSet.get(1)) {
                saveAsPDFSettings.pagesFrom = tTupleProtocol.readI32();
                saveAsPDFSettings.setPagesFromIsSet(true);
            }
            if (bitSet.get(2)) {
                saveAsPDFSettings.pageOrientation = tTupleProtocol.readI32();
                saveAsPDFSettings.setPageOrientationIsSet(true);
            }
            if (bitSet.get(3)) {
                saveAsPDFSettings.scaling = tTupleProtocol.readDouble();
                saveAsPDFSettings.setScalingIsSet(true);
            }
            if (bitSet.get(4)) {
                saveAsPDFSettings.paperSize = tTupleProtocol.readI32();
                saveAsPDFSettings.setPaperSizeIsSet(true);
            }
        }
    }

    private static class SaveAsPDFSettingsStandardScheme
    extends StandardScheme<SaveAsPDFSettings> {
        private SaveAsPDFSettingsStandardScheme() {
        }

        public void read(TProtocol tProtocol, SaveAsPDFSettings saveAsPDFSettings) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 8) {
                            saveAsPDFSettings.docSaveType = tProtocol.readI32();
                            saveAsPDFSettings.setDocSaveTypeIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 8) {
                            saveAsPDFSettings.pagesFrom = tProtocol.readI32();
                            saveAsPDFSettings.setPagesFromIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 8) {
                            saveAsPDFSettings.pageOrientation = tProtocol.readI32();
                            saveAsPDFSettings.setPageOrientationIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 4) {
                            saveAsPDFSettings.scaling = tProtocol.readDouble();
                            saveAsPDFSettings.setScalingIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 5: {
                        if (tField.type == 8) {
                            saveAsPDFSettings.paperSize = tProtocol.readI32();
                            saveAsPDFSettings.setPaperSizeIsSet(true);
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
            saveAsPDFSettings.validate();
        }

        public void write(TProtocol tProtocol, SaveAsPDFSettings saveAsPDFSettings) throws TException {
            saveAsPDFSettings.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            tProtocol.writeFieldBegin(DOC_SAVE_TYPE_FIELD_DESC);
            tProtocol.writeI32(saveAsPDFSettings.docSaveType);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(PAGES_FROM_FIELD_DESC);
            tProtocol.writeI32(saveAsPDFSettings.pagesFrom);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(PAGE_ORIENTATION_FIELD_DESC);
            tProtocol.writeI32(saveAsPDFSettings.pageOrientation);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(SCALING_FIELD_DESC);
            tProtocol.writeDouble(saveAsPDFSettings.scaling);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(PAPER_SIZE_FIELD_DESC);
            tProtocol.writeI32(saveAsPDFSettings.paperSize);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

