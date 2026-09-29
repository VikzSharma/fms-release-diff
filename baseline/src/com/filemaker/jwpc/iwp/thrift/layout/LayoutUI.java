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
package com.filemaker.jwpc.iwp.thrift.layout;

import com.filemaker.jwpc.iwp.thrift.common.DateOrder;
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

public class LayoutUI
implements TBase<LayoutUI, _Fields>,
Serializable,
Cloneable,
Comparable<LayoutUI> {
    private static final TStruct STRUCT_DESC = new TStruct("LayoutUI");
    private static final TField VALID_FIELD_DESC = new TField("valid", 2, 1);
    private static final TField META_DATA_FIELD_DESC = new TField("metaData", 11, 2);
    private static final TField LAYOUT_CSS_FIELD_DESC = new TField("layoutCSS", 11, 3);
    private static final TField OBJECT_OVERRIDES_FIELD_DESC = new TField("objectOverrides", 11, 4);
    private static final TField THEME_ID_FIELD_DESC = new TField("themeId", 8, 5);
    private static final TField THEME_MOD_COUNT_FIELD_DESC = new TField("themeModCount", 10, 6);
    private static final TField CLASSIC_THEME_FIELD_DESC = new TField("classicTheme", 2, 7);
    private static final TField DATE_FORMAT_FIELD_DESC = new TField("dateFormat", 8, 8);
    private static final TField LAYOUT_CSSKEY_FIELD_DESC = new TField("layoutCSSKey", 11, 9);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new LayoutUIStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new LayoutUITupleSchemeFactory();
    private boolean valid;
    @Nullable
    private String metaData;
    @Nullable
    private String layoutCSS;
    @Nullable
    private String objectOverrides;
    private int themeId;
    private long themeModCount;
    private boolean classicTheme;
    @Nullable
    private DateOrder dateFormat;
    @Nullable
    private String layoutCSSKey;
    private static final int __VALID_ISSET_ID = 0;
    private static final int __THEMEID_ISSET_ID = 1;
    private static final int __THEMEMODCOUNT_ISSET_ID = 2;
    private static final int __CLASSICTHEME_ISSET_ID = 3;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public LayoutUI() {
        this.valid = false;
    }

    public LayoutUI(boolean bl, String string, String string2, String string3, int n, long l, boolean bl2, DateOrder dateOrder, String string4) {
        this();
        this.valid = bl;
        this.setValidIsSet(true);
        this.metaData = string;
        this.layoutCSS = string2;
        this.objectOverrides = string3;
        this.themeId = n;
        this.setThemeIdIsSet(true);
        this.themeModCount = l;
        this.setThemeModCountIsSet(true);
        this.classicTheme = bl2;
        this.setClassicThemeIsSet(true);
        this.dateFormat = dateOrder;
        this.layoutCSSKey = string4;
    }

    public LayoutUI(LayoutUI layoutUI) {
        this.__isset_bitfield = layoutUI.__isset_bitfield;
        this.valid = layoutUI.valid;
        if (layoutUI.isSetMetaData()) {
            this.metaData = layoutUI.metaData;
        }
        if (layoutUI.isSetLayoutCSS()) {
            this.layoutCSS = layoutUI.layoutCSS;
        }
        if (layoutUI.isSetObjectOverrides()) {
            this.objectOverrides = layoutUI.objectOverrides;
        }
        this.themeId = layoutUI.themeId;
        this.themeModCount = layoutUI.themeModCount;
        this.classicTheme = layoutUI.classicTheme;
        if (layoutUI.isSetDateFormat()) {
            this.dateFormat = layoutUI.dateFormat;
        }
        if (layoutUI.isSetLayoutCSSKey()) {
            this.layoutCSSKey = layoutUI.layoutCSSKey;
        }
    }

    public LayoutUI deepCopy() {
        return new LayoutUI(this);
    }

    public void clear() {
        this.valid = false;
        this.metaData = null;
        this.layoutCSS = null;
        this.objectOverrides = null;
        this.setThemeIdIsSet(false);
        this.themeId = 0;
        this.setThemeModCountIsSet(false);
        this.themeModCount = 0L;
        this.setClassicThemeIsSet(false);
        this.classicTheme = false;
        this.dateFormat = null;
        this.layoutCSSKey = null;
    }

    public boolean isValid() {
        return this.valid;
    }

    public void setValid(boolean bl) {
        this.valid = bl;
        this.setValidIsSet(true);
    }

    public void unsetValid() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetValid() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setValidIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    @Nullable
    public String getMetaData() {
        return this.metaData;
    }

    public void setMetaData(@Nullable String string) {
        this.metaData = string;
    }

    public void unsetMetaData() {
        this.metaData = null;
    }

    public boolean isSetMetaData() {
        return this.metaData != null;
    }

    public void setMetaDataIsSet(boolean bl) {
        if (!bl) {
            this.metaData = null;
        }
    }

    @Nullable
    public String getLayoutCSS() {
        return this.layoutCSS;
    }

    public void setLayoutCSS(@Nullable String string) {
        this.layoutCSS = string;
    }

    public void unsetLayoutCSS() {
        this.layoutCSS = null;
    }

    public boolean isSetLayoutCSS() {
        return this.layoutCSS != null;
    }

    public void setLayoutCSSIsSet(boolean bl) {
        if (!bl) {
            this.layoutCSS = null;
        }
    }

    @Nullable
    public String getObjectOverrides() {
        return this.objectOverrides;
    }

    public void setObjectOverrides(@Nullable String string) {
        this.objectOverrides = string;
    }

    public void unsetObjectOverrides() {
        this.objectOverrides = null;
    }

    public boolean isSetObjectOverrides() {
        return this.objectOverrides != null;
    }

    public void setObjectOverridesIsSet(boolean bl) {
        if (!bl) {
            this.objectOverrides = null;
        }
    }

    public int getThemeId() {
        return this.themeId;
    }

    public void setThemeId(int n) {
        this.themeId = n;
        this.setThemeIdIsSet(true);
    }

    public void unsetThemeId() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)1);
    }

    public boolean isSetThemeId() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)1);
    }

    public void setThemeIdIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)1, (boolean)bl);
    }

    public long getThemeModCount() {
        return this.themeModCount;
    }

    public void setThemeModCount(long l) {
        this.themeModCount = l;
        this.setThemeModCountIsSet(true);
    }

    public void unsetThemeModCount() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)2);
    }

    public boolean isSetThemeModCount() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)2);
    }

    public void setThemeModCountIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)2, (boolean)bl);
    }

    public boolean isClassicTheme() {
        return this.classicTheme;
    }

    public void setClassicTheme(boolean bl) {
        this.classicTheme = bl;
        this.setClassicThemeIsSet(true);
    }

    public void unsetClassicTheme() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)3);
    }

    public boolean isSetClassicTheme() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)3);
    }

    public void setClassicThemeIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)3, (boolean)bl);
    }

    @Nullable
    public DateOrder getDateFormat() {
        return this.dateFormat;
    }

    public void setDateFormat(@Nullable DateOrder dateOrder) {
        this.dateFormat = dateOrder;
    }

    public void unsetDateFormat() {
        this.dateFormat = null;
    }

    public boolean isSetDateFormat() {
        return this.dateFormat != null;
    }

    public void setDateFormatIsSet(boolean bl) {
        if (!bl) {
            this.dateFormat = null;
        }
    }

    @Nullable
    public String getLayoutCSSKey() {
        return this.layoutCSSKey;
    }

    public void setLayoutCSSKey(@Nullable String string) {
        this.layoutCSSKey = string;
    }

    public void unsetLayoutCSSKey() {
        this.layoutCSSKey = null;
    }

    public boolean isSetLayoutCSSKey() {
        return this.layoutCSSKey != null;
    }

    public void setLayoutCSSKeyIsSet(boolean bl) {
        if (!bl) {
            this.layoutCSSKey = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetValid();
                    break;
                }
                this.setValid((Boolean)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetMetaData();
                    break;
                }
                this.setMetaData((String)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetLayoutCSS();
                    break;
                }
                this.setLayoutCSS((String)object);
                break;
            }
            case 3: {
                if (object == null) {
                    this.unsetObjectOverrides();
                    break;
                }
                this.setObjectOverrides((String)object);
                break;
            }
            case 4: {
                if (object == null) {
                    this.unsetThemeId();
                    break;
                }
                this.setThemeId((Integer)object);
                break;
            }
            case 5: {
                if (object == null) {
                    this.unsetThemeModCount();
                    break;
                }
                this.setThemeModCount((Long)object);
                break;
            }
            case 6: {
                if (object == null) {
                    this.unsetClassicTheme();
                    break;
                }
                this.setClassicTheme((Boolean)object);
                break;
            }
            case 7: {
                if (object == null) {
                    this.unsetDateFormat();
                    break;
                }
                this.setDateFormat((DateOrder)((Object)object));
                break;
            }
            case 8: {
                if (object == null) {
                    this.unsetLayoutCSSKey();
                    break;
                }
                this.setLayoutCSSKey((String)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.isValid();
            }
            case 1: {
                return this.getMetaData();
            }
            case 2: {
                return this.getLayoutCSS();
            }
            case 3: {
                return this.getObjectOverrides();
            }
            case 4: {
                return this.getThemeId();
            }
            case 5: {
                return this.getThemeModCount();
            }
            case 6: {
                return this.isClassicTheme();
            }
            case 7: {
                return this.getDateFormat();
            }
            case 8: {
                return this.getLayoutCSSKey();
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
                return this.isSetValid();
            }
            case 1: {
                return this.isSetMetaData();
            }
            case 2: {
                return this.isSetLayoutCSS();
            }
            case 3: {
                return this.isSetObjectOverrides();
            }
            case 4: {
                return this.isSetThemeId();
            }
            case 5: {
                return this.isSetThemeModCount();
            }
            case 6: {
                return this.isSetClassicTheme();
            }
            case 7: {
                return this.isSetDateFormat();
            }
            case 8: {
                return this.isSetLayoutCSSKey();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof LayoutUI) {
            return this.equals((LayoutUI)object);
        }
        return false;
    }

    public boolean equals(LayoutUI layoutUI) {
        if (layoutUI == null) {
            return false;
        }
        if (this == layoutUI) {
            return true;
        }
        boolean bl = true;
        boolean bl2 = true;
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (this.valid != layoutUI.valid) {
                return false;
            }
        }
        boolean bl3 = this.isSetMetaData();
        boolean bl4 = layoutUI.isSetMetaData();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.metaData.equals(layoutUI.metaData)) {
                return false;
            }
        }
        boolean bl5 = this.isSetLayoutCSS();
        boolean bl6 = layoutUI.isSetLayoutCSS();
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (!this.layoutCSS.equals(layoutUI.layoutCSS)) {
                return false;
            }
        }
        boolean bl7 = this.isSetObjectOverrides();
        boolean bl8 = layoutUI.isSetObjectOverrides();
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (!this.objectOverrides.equals(layoutUI.objectOverrides)) {
                return false;
            }
        }
        boolean bl9 = true;
        boolean bl10 = true;
        if (bl9 || bl10) {
            if (!bl9 || !bl10) {
                return false;
            }
            if (this.themeId != layoutUI.themeId) {
                return false;
            }
        }
        boolean bl11 = true;
        boolean bl12 = true;
        if (bl11 || bl12) {
            if (!bl11 || !bl12) {
                return false;
            }
            if (this.themeModCount != layoutUI.themeModCount) {
                return false;
            }
        }
        boolean bl13 = true;
        boolean bl14 = true;
        if (bl13 || bl14) {
            if (!bl13 || !bl14) {
                return false;
            }
            if (this.classicTheme != layoutUI.classicTheme) {
                return false;
            }
        }
        boolean bl15 = this.isSetDateFormat();
        boolean bl16 = layoutUI.isSetDateFormat();
        if (bl15 || bl16) {
            if (!bl15 || !bl16) {
                return false;
            }
            if (!this.dateFormat.equals((Object)layoutUI.dateFormat)) {
                return false;
            }
        }
        boolean bl17 = this.isSetLayoutCSSKey();
        boolean bl18 = layoutUI.isSetLayoutCSSKey();
        if (bl17 || bl18) {
            if (!bl17 || !bl18) {
                return false;
            }
            if (!this.layoutCSSKey.equals(layoutUI.layoutCSSKey)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.valid ? 131071 : 524287);
        n = n * 8191 + (this.isSetMetaData() ? 131071 : 524287);
        if (this.isSetMetaData()) {
            n = n * 8191 + this.metaData.hashCode();
        }
        n = n * 8191 + (this.isSetLayoutCSS() ? 131071 : 524287);
        if (this.isSetLayoutCSS()) {
            n = n * 8191 + this.layoutCSS.hashCode();
        }
        n = n * 8191 + (this.isSetObjectOverrides() ? 131071 : 524287);
        if (this.isSetObjectOverrides()) {
            n = n * 8191 + this.objectOverrides.hashCode();
        }
        n = n * 8191 + this.themeId;
        n = n * 8191 + TBaseHelper.hashCode((long)this.themeModCount);
        n = n * 8191 + (this.classicTheme ? 131071 : 524287);
        n = n * 8191 + (this.isSetDateFormat() ? 131071 : 524287);
        if (this.isSetDateFormat()) {
            n = n * 8191 + this.dateFormat.getValue();
        }
        n = n * 8191 + (this.isSetLayoutCSSKey() ? 131071 : 524287);
        if (this.isSetLayoutCSSKey()) {
            n = n * 8191 + this.layoutCSSKey.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(LayoutUI layoutUI) {
        if (!this.getClass().equals(layoutUI.getClass())) {
            return this.getClass().getName().compareTo(layoutUI.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetValid(), layoutUI.isSetValid());
        if (n != 0) {
            return n;
        }
        if (this.isSetValid() && (n = TBaseHelper.compareTo((boolean)this.valid, (boolean)layoutUI.valid)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetMetaData(), layoutUI.isSetMetaData());
        if (n != 0) {
            return n;
        }
        if (this.isSetMetaData() && (n = TBaseHelper.compareTo((String)this.metaData, (String)layoutUI.metaData)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetLayoutCSS(), layoutUI.isSetLayoutCSS());
        if (n != 0) {
            return n;
        }
        if (this.isSetLayoutCSS() && (n = TBaseHelper.compareTo((String)this.layoutCSS, (String)layoutUI.layoutCSS)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetObjectOverrides(), layoutUI.isSetObjectOverrides());
        if (n != 0) {
            return n;
        }
        if (this.isSetObjectOverrides() && (n = TBaseHelper.compareTo((String)this.objectOverrides, (String)layoutUI.objectOverrides)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetThemeId(), layoutUI.isSetThemeId());
        if (n != 0) {
            return n;
        }
        if (this.isSetThemeId() && (n = TBaseHelper.compareTo((int)this.themeId, (int)layoutUI.themeId)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetThemeModCount(), layoutUI.isSetThemeModCount());
        if (n != 0) {
            return n;
        }
        if (this.isSetThemeModCount() && (n = TBaseHelper.compareTo((long)this.themeModCount, (long)layoutUI.themeModCount)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetClassicTheme(), layoutUI.isSetClassicTheme());
        if (n != 0) {
            return n;
        }
        if (this.isSetClassicTheme() && (n = TBaseHelper.compareTo((boolean)this.classicTheme, (boolean)layoutUI.classicTheme)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetDateFormat(), layoutUI.isSetDateFormat());
        if (n != 0) {
            return n;
        }
        if (this.isSetDateFormat() && (n = TBaseHelper.compareTo((Comparable)((Object)this.dateFormat), (Comparable)((Object)layoutUI.dateFormat))) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetLayoutCSSKey(), layoutUI.isSetLayoutCSSKey());
        if (n != 0) {
            return n;
        }
        if (this.isSetLayoutCSSKey() && (n = TBaseHelper.compareTo((String)this.layoutCSSKey, (String)layoutUI.layoutCSSKey)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        LayoutUI.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        LayoutUI.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("LayoutUI(");
        boolean bl = true;
        stringBuilder.append("valid:");
        stringBuilder.append(this.valid);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("metaData:");
        if (this.metaData == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.metaData);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("layoutCSS:");
        if (this.layoutCSS == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.layoutCSS);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("objectOverrides:");
        if (this.objectOverrides == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.objectOverrides);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("themeId:");
        stringBuilder.append(this.themeId);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("themeModCount:");
        stringBuilder.append(this.themeModCount);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("classicTheme:");
        stringBuilder.append(this.classicTheme);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("dateFormat:");
        if (this.dateFormat == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append((Object)this.dateFormat);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("layoutCSSKey:");
        if (this.layoutCSSKey == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.layoutCSSKey);
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
        enumMap.put(_Fields.VALID, new FieldMetaData("valid", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.META_DATA, new FieldMetaData("metaData", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.LAYOUT_CSS, new FieldMetaData("layoutCSS", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.OBJECT_OVERRIDES, new FieldMetaData("objectOverrides", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.THEME_ID, new FieldMetaData("themeId", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.THEME_MOD_COUNT, new FieldMetaData("themeModCount", 3, new FieldValueMetaData(10)));
        enumMap.put(_Fields.CLASSIC_THEME, new FieldMetaData("classicTheme", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.DATE_FORMAT, new FieldMetaData("dateFormat", 3, (FieldValueMetaData)new EnumMetaData(-1, DateOrder.class)));
        enumMap.put(_Fields.LAYOUT_CSSKEY, new FieldMetaData("layoutCSSKey", 3, new FieldValueMetaData(11)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(LayoutUI.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        VALID(1, "valid"),
        META_DATA(2, "metaData"),
        LAYOUT_CSS(3, "layoutCSS"),
        OBJECT_OVERRIDES(4, "objectOverrides"),
        THEME_ID(5, "themeId"),
        THEME_MOD_COUNT(6, "themeModCount"),
        CLASSIC_THEME(7, "classicTheme"),
        DATE_FORMAT(8, "dateFormat"),
        LAYOUT_CSSKEY(9, "layoutCSSKey");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return VALID;
                }
                case 2: {
                    return META_DATA;
                }
                case 3: {
                    return LAYOUT_CSS;
                }
                case 4: {
                    return OBJECT_OVERRIDES;
                }
                case 5: {
                    return THEME_ID;
                }
                case 6: {
                    return THEME_MOD_COUNT;
                }
                case 7: {
                    return CLASSIC_THEME;
                }
                case 8: {
                    return DATE_FORMAT;
                }
                case 9: {
                    return LAYOUT_CSSKEY;
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

    private static class LayoutUIStandardSchemeFactory
    implements SchemeFactory {
        private LayoutUIStandardSchemeFactory() {
        }

        public LayoutUIStandardScheme getScheme() {
            return new LayoutUIStandardScheme();
        }
    }

    private static class LayoutUITupleSchemeFactory
    implements SchemeFactory {
        private LayoutUITupleSchemeFactory() {
        }

        public LayoutUITupleScheme getScheme() {
            return new LayoutUITupleScheme();
        }
    }

    private static class LayoutUITupleScheme
    extends TupleScheme<LayoutUI> {
        private LayoutUITupleScheme() {
        }

        public void write(TProtocol tProtocol, LayoutUI layoutUI) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (layoutUI.isSetValid()) {
                bitSet.set(0);
            }
            if (layoutUI.isSetMetaData()) {
                bitSet.set(1);
            }
            if (layoutUI.isSetLayoutCSS()) {
                bitSet.set(2);
            }
            if (layoutUI.isSetObjectOverrides()) {
                bitSet.set(3);
            }
            if (layoutUI.isSetThemeId()) {
                bitSet.set(4);
            }
            if (layoutUI.isSetThemeModCount()) {
                bitSet.set(5);
            }
            if (layoutUI.isSetClassicTheme()) {
                bitSet.set(6);
            }
            if (layoutUI.isSetDateFormat()) {
                bitSet.set(7);
            }
            if (layoutUI.isSetLayoutCSSKey()) {
                bitSet.set(8);
            }
            tTupleProtocol.writeBitSet(bitSet, 9);
            if (layoutUI.isSetValid()) {
                tTupleProtocol.writeBool(layoutUI.valid);
            }
            if (layoutUI.isSetMetaData()) {
                tTupleProtocol.writeString(layoutUI.metaData);
            }
            if (layoutUI.isSetLayoutCSS()) {
                tTupleProtocol.writeString(layoutUI.layoutCSS);
            }
            if (layoutUI.isSetObjectOverrides()) {
                tTupleProtocol.writeString(layoutUI.objectOverrides);
            }
            if (layoutUI.isSetThemeId()) {
                tTupleProtocol.writeI32(layoutUI.themeId);
            }
            if (layoutUI.isSetThemeModCount()) {
                tTupleProtocol.writeI64(layoutUI.themeModCount);
            }
            if (layoutUI.isSetClassicTheme()) {
                tTupleProtocol.writeBool(layoutUI.classicTheme);
            }
            if (layoutUI.isSetDateFormat()) {
                tTupleProtocol.writeI32(layoutUI.dateFormat.getValue());
            }
            if (layoutUI.isSetLayoutCSSKey()) {
                tTupleProtocol.writeString(layoutUI.layoutCSSKey);
            }
        }

        public void read(TProtocol tProtocol, LayoutUI layoutUI) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(9);
            if (bitSet.get(0)) {
                layoutUI.valid = tTupleProtocol.readBool();
                layoutUI.setValidIsSet(true);
            }
            if (bitSet.get(1)) {
                layoutUI.metaData = tTupleProtocol.readString();
                layoutUI.setMetaDataIsSet(true);
            }
            if (bitSet.get(2)) {
                layoutUI.layoutCSS = tTupleProtocol.readString();
                layoutUI.setLayoutCSSIsSet(true);
            }
            if (bitSet.get(3)) {
                layoutUI.objectOverrides = tTupleProtocol.readString();
                layoutUI.setObjectOverridesIsSet(true);
            }
            if (bitSet.get(4)) {
                layoutUI.themeId = tTupleProtocol.readI32();
                layoutUI.setThemeIdIsSet(true);
            }
            if (bitSet.get(5)) {
                layoutUI.themeModCount = tTupleProtocol.readI64();
                layoutUI.setThemeModCountIsSet(true);
            }
            if (bitSet.get(6)) {
                layoutUI.classicTheme = tTupleProtocol.readBool();
                layoutUI.setClassicThemeIsSet(true);
            }
            if (bitSet.get(7)) {
                layoutUI.dateFormat = DateOrder.findByValue(tTupleProtocol.readI32());
                layoutUI.setDateFormatIsSet(true);
            }
            if (bitSet.get(8)) {
                layoutUI.layoutCSSKey = tTupleProtocol.readString();
                layoutUI.setLayoutCSSKeyIsSet(true);
            }
        }
    }

    private static class LayoutUIStandardScheme
    extends StandardScheme<LayoutUI> {
        private LayoutUIStandardScheme() {
        }

        public void read(TProtocol tProtocol, LayoutUI layoutUI) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 2) {
                            layoutUI.valid = tProtocol.readBool();
                            layoutUI.setValidIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 11) {
                            layoutUI.metaData = tProtocol.readString();
                            layoutUI.setMetaDataIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 11) {
                            layoutUI.layoutCSS = tProtocol.readString();
                            layoutUI.setLayoutCSSIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 11) {
                            layoutUI.objectOverrides = tProtocol.readString();
                            layoutUI.setObjectOverridesIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 5: {
                        if (tField.type == 8) {
                            layoutUI.themeId = tProtocol.readI32();
                            layoutUI.setThemeIdIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 6: {
                        if (tField.type == 10) {
                            layoutUI.themeModCount = tProtocol.readI64();
                            layoutUI.setThemeModCountIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 7: {
                        if (tField.type == 2) {
                            layoutUI.classicTheme = tProtocol.readBool();
                            layoutUI.setClassicThemeIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 8: {
                        if (tField.type == 8) {
                            layoutUI.dateFormat = DateOrder.findByValue(tProtocol.readI32());
                            layoutUI.setDateFormatIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 9: {
                        if (tField.type == 11) {
                            layoutUI.layoutCSSKey = tProtocol.readString();
                            layoutUI.setLayoutCSSKeyIsSet(true);
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
            layoutUI.validate();
        }

        public void write(TProtocol tProtocol, LayoutUI layoutUI) throws TException {
            layoutUI.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            tProtocol.writeFieldBegin(VALID_FIELD_DESC);
            tProtocol.writeBool(layoutUI.valid);
            tProtocol.writeFieldEnd();
            if (layoutUI.metaData != null) {
                tProtocol.writeFieldBegin(META_DATA_FIELD_DESC);
                tProtocol.writeString(layoutUI.metaData);
                tProtocol.writeFieldEnd();
            }
            if (layoutUI.layoutCSS != null) {
                tProtocol.writeFieldBegin(LAYOUT_CSS_FIELD_DESC);
                tProtocol.writeString(layoutUI.layoutCSS);
                tProtocol.writeFieldEnd();
            }
            if (layoutUI.objectOverrides != null) {
                tProtocol.writeFieldBegin(OBJECT_OVERRIDES_FIELD_DESC);
                tProtocol.writeString(layoutUI.objectOverrides);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(THEME_ID_FIELD_DESC);
            tProtocol.writeI32(layoutUI.themeId);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(THEME_MOD_COUNT_FIELD_DESC);
            tProtocol.writeI64(layoutUI.themeModCount);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(CLASSIC_THEME_FIELD_DESC);
            tProtocol.writeBool(layoutUI.classicTheme);
            tProtocol.writeFieldEnd();
            if (layoutUI.dateFormat != null) {
                tProtocol.writeFieldBegin(DATE_FORMAT_FIELD_DESC);
                tProtocol.writeI32(layoutUI.dateFormat.getValue());
                tProtocol.writeFieldEnd();
            }
            if (layoutUI.layoutCSSKey != null) {
                tProtocol.writeFieldBegin(LAYOUT_CSSKEY_FIELD_DESC);
                tProtocol.writeString(layoutUI.layoutCSSKey);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

