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

import com.filemaker.jwpc.iwp.thrift.common.CardWindowSettings;
import com.filemaker.jwpc.iwp.thrift.common.HierarchicalNames;
import com.filemaker.jwpc.iwp.thrift.common.WindowState;
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

public class WindowChangeNotification
implements TBase<WindowChangeNotification, _Fields>,
Serializable,
Cloneable,
Comparable<WindowChangeNotification> {
    private static final TStruct STRUCT_DESC = new TStruct("WindowChangeNotification");
    private static final TField WINDOW_STATE_FIELD_DESC = new TField("windowState", 12, 1);
    private static final TField LAYOUT_UI_FIELD_DESC = new TField("layoutUI", 12, 2);
    private static final TField LAYOUT_NAMES_FIELD_DESC = new TField("layoutNames", 12, 3);
    private static final TField SCRIPT_NAMES_FIELD_DESC = new TField("scriptNames", 12, 4);
    private static final TField CARD_STYLE_WINDOW_FIELD_DESC = new TField("cardStyleWindow", 2, 5);
    private static final TField CARD_WINDOW_SETTINGS_FIELD_DESC = new TField("cardWindowSettings", 12, 6);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new WindowChangeNotificationStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new WindowChangeNotificationTupleSchemeFactory();
    @Nullable
    private WindowState windowState;
    @Nullable
    private LayoutUI layoutUI;
    @Nullable
    private HierarchicalNames layoutNames;
    @Nullable
    private HierarchicalNames scriptNames;
    private boolean cardStyleWindow;
    @Nullable
    private CardWindowSettings cardWindowSettings;
    private static final int __CARDSTYLEWINDOW_ISSET_ID = 0;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public WindowChangeNotification() {
    }

    public WindowChangeNotification(WindowState windowState, LayoutUI layoutUI, HierarchicalNames hierarchicalNames, HierarchicalNames hierarchicalNames2, boolean bl, CardWindowSettings cardWindowSettings) {
        this();
        this.windowState = windowState;
        this.layoutUI = layoutUI;
        this.layoutNames = hierarchicalNames;
        this.scriptNames = hierarchicalNames2;
        this.cardStyleWindow = bl;
        this.setCardStyleWindowIsSet(true);
        this.cardWindowSettings = cardWindowSettings;
    }

    public WindowChangeNotification(WindowChangeNotification windowChangeNotification) {
        this.__isset_bitfield = windowChangeNotification.__isset_bitfield;
        if (windowChangeNotification.isSetWindowState()) {
            this.windowState = new WindowState(windowChangeNotification.windowState);
        }
        if (windowChangeNotification.isSetLayoutUI()) {
            this.layoutUI = new LayoutUI(windowChangeNotification.layoutUI);
        }
        if (windowChangeNotification.isSetLayoutNames()) {
            this.layoutNames = new HierarchicalNames(windowChangeNotification.layoutNames);
        }
        if (windowChangeNotification.isSetScriptNames()) {
            this.scriptNames = new HierarchicalNames(windowChangeNotification.scriptNames);
        }
        this.cardStyleWindow = windowChangeNotification.cardStyleWindow;
        if (windowChangeNotification.isSetCardWindowSettings()) {
            this.cardWindowSettings = new CardWindowSettings(windowChangeNotification.cardWindowSettings);
        }
    }

    public WindowChangeNotification deepCopy() {
        return new WindowChangeNotification(this);
    }

    public void clear() {
        this.windowState = null;
        this.layoutUI = null;
        this.layoutNames = null;
        this.scriptNames = null;
        this.setCardStyleWindowIsSet(false);
        this.cardStyleWindow = false;
        this.cardWindowSettings = null;
    }

    @Nullable
    public WindowState getWindowState() {
        return this.windowState;
    }

    public void setWindowState(@Nullable WindowState windowState) {
        this.windowState = windowState;
    }

    public void unsetWindowState() {
        this.windowState = null;
    }

    public boolean isSetWindowState() {
        return this.windowState != null;
    }

    public void setWindowStateIsSet(boolean bl) {
        if (!bl) {
            this.windowState = null;
        }
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

    @Nullable
    public HierarchicalNames getLayoutNames() {
        return this.layoutNames;
    }

    public void setLayoutNames(@Nullable HierarchicalNames hierarchicalNames) {
        this.layoutNames = hierarchicalNames;
    }

    public void unsetLayoutNames() {
        this.layoutNames = null;
    }

    public boolean isSetLayoutNames() {
        return this.layoutNames != null;
    }

    public void setLayoutNamesIsSet(boolean bl) {
        if (!bl) {
            this.layoutNames = null;
        }
    }

    @Nullable
    public HierarchicalNames getScriptNames() {
        return this.scriptNames;
    }

    public void setScriptNames(@Nullable HierarchicalNames hierarchicalNames) {
        this.scriptNames = hierarchicalNames;
    }

    public void unsetScriptNames() {
        this.scriptNames = null;
    }

    public boolean isSetScriptNames() {
        return this.scriptNames != null;
    }

    public void setScriptNamesIsSet(boolean bl) {
        if (!bl) {
            this.scriptNames = null;
        }
    }

    public boolean isCardStyleWindow() {
        return this.cardStyleWindow;
    }

    public void setCardStyleWindow(boolean bl) {
        this.cardStyleWindow = bl;
        this.setCardStyleWindowIsSet(true);
    }

    public void unsetCardStyleWindow() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetCardStyleWindow() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setCardStyleWindowIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    @Nullable
    public CardWindowSettings getCardWindowSettings() {
        return this.cardWindowSettings;
    }

    public void setCardWindowSettings(@Nullable CardWindowSettings cardWindowSettings) {
        this.cardWindowSettings = cardWindowSettings;
    }

    public void unsetCardWindowSettings() {
        this.cardWindowSettings = null;
    }

    public boolean isSetCardWindowSettings() {
        return this.cardWindowSettings != null;
    }

    public void setCardWindowSettingsIsSet(boolean bl) {
        if (!bl) {
            this.cardWindowSettings = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetWindowState();
                    break;
                }
                this.setWindowState((WindowState)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetLayoutUI();
                    break;
                }
                this.setLayoutUI((LayoutUI)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetLayoutNames();
                    break;
                }
                this.setLayoutNames((HierarchicalNames)object);
                break;
            }
            case 3: {
                if (object == null) {
                    this.unsetScriptNames();
                    break;
                }
                this.setScriptNames((HierarchicalNames)object);
                break;
            }
            case 4: {
                if (object == null) {
                    this.unsetCardStyleWindow();
                    break;
                }
                this.setCardStyleWindow((Boolean)object);
                break;
            }
            case 5: {
                if (object == null) {
                    this.unsetCardWindowSettings();
                    break;
                }
                this.setCardWindowSettings((CardWindowSettings)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getWindowState();
            }
            case 1: {
                return this.getLayoutUI();
            }
            case 2: {
                return this.getLayoutNames();
            }
            case 3: {
                return this.getScriptNames();
            }
            case 4: {
                return this.isCardStyleWindow();
            }
            case 5: {
                return this.getCardWindowSettings();
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
                return this.isSetWindowState();
            }
            case 1: {
                return this.isSetLayoutUI();
            }
            case 2: {
                return this.isSetLayoutNames();
            }
            case 3: {
                return this.isSetScriptNames();
            }
            case 4: {
                return this.isSetCardStyleWindow();
            }
            case 5: {
                return this.isSetCardWindowSettings();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof WindowChangeNotification) {
            return this.equals((WindowChangeNotification)object);
        }
        return false;
    }

    public boolean equals(WindowChangeNotification windowChangeNotification) {
        if (windowChangeNotification == null) {
            return false;
        }
        if (this == windowChangeNotification) {
            return true;
        }
        boolean bl = this.isSetWindowState();
        boolean bl2 = windowChangeNotification.isSetWindowState();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.windowState.equals(windowChangeNotification.windowState)) {
                return false;
            }
        }
        boolean bl3 = this.isSetLayoutUI();
        boolean bl4 = windowChangeNotification.isSetLayoutUI();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.layoutUI.equals(windowChangeNotification.layoutUI)) {
                return false;
            }
        }
        boolean bl5 = this.isSetLayoutNames();
        boolean bl6 = windowChangeNotification.isSetLayoutNames();
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (!this.layoutNames.equals(windowChangeNotification.layoutNames)) {
                return false;
            }
        }
        boolean bl7 = this.isSetScriptNames();
        boolean bl8 = windowChangeNotification.isSetScriptNames();
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (!this.scriptNames.equals(windowChangeNotification.scriptNames)) {
                return false;
            }
        }
        boolean bl9 = true;
        boolean bl10 = true;
        if (bl9 || bl10) {
            if (!bl9 || !bl10) {
                return false;
            }
            if (this.cardStyleWindow != windowChangeNotification.cardStyleWindow) {
                return false;
            }
        }
        boolean bl11 = this.isSetCardWindowSettings();
        boolean bl12 = windowChangeNotification.isSetCardWindowSettings();
        if (bl11 || bl12) {
            if (!bl11 || !bl12) {
                return false;
            }
            if (!this.cardWindowSettings.equals(windowChangeNotification.cardWindowSettings)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetWindowState() ? 131071 : 524287);
        if (this.isSetWindowState()) {
            n = n * 8191 + this.windowState.hashCode();
        }
        n = n * 8191 + (this.isSetLayoutUI() ? 131071 : 524287);
        if (this.isSetLayoutUI()) {
            n = n * 8191 + this.layoutUI.hashCode();
        }
        n = n * 8191 + (this.isSetLayoutNames() ? 131071 : 524287);
        if (this.isSetLayoutNames()) {
            n = n * 8191 + this.layoutNames.hashCode();
        }
        n = n * 8191 + (this.isSetScriptNames() ? 131071 : 524287);
        if (this.isSetScriptNames()) {
            n = n * 8191 + this.scriptNames.hashCode();
        }
        n = n * 8191 + (this.cardStyleWindow ? 131071 : 524287);
        n = n * 8191 + (this.isSetCardWindowSettings() ? 131071 : 524287);
        if (this.isSetCardWindowSettings()) {
            n = n * 8191 + this.cardWindowSettings.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(WindowChangeNotification windowChangeNotification) {
        if (!this.getClass().equals(windowChangeNotification.getClass())) {
            return this.getClass().getName().compareTo(windowChangeNotification.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetWindowState(), windowChangeNotification.isSetWindowState());
        if (n != 0) {
            return n;
        }
        if (this.isSetWindowState() && (n = TBaseHelper.compareTo((Comparable)this.windowState, (Comparable)windowChangeNotification.windowState)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetLayoutUI(), windowChangeNotification.isSetLayoutUI());
        if (n != 0) {
            return n;
        }
        if (this.isSetLayoutUI() && (n = TBaseHelper.compareTo((Comparable)this.layoutUI, (Comparable)windowChangeNotification.layoutUI)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetLayoutNames(), windowChangeNotification.isSetLayoutNames());
        if (n != 0) {
            return n;
        }
        if (this.isSetLayoutNames() && (n = TBaseHelper.compareTo((Comparable)this.layoutNames, (Comparable)windowChangeNotification.layoutNames)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetScriptNames(), windowChangeNotification.isSetScriptNames());
        if (n != 0) {
            return n;
        }
        if (this.isSetScriptNames() && (n = TBaseHelper.compareTo((Comparable)this.scriptNames, (Comparable)windowChangeNotification.scriptNames)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetCardStyleWindow(), windowChangeNotification.isSetCardStyleWindow());
        if (n != 0) {
            return n;
        }
        if (this.isSetCardStyleWindow() && (n = TBaseHelper.compareTo((boolean)this.cardStyleWindow, (boolean)windowChangeNotification.cardStyleWindow)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetCardWindowSettings(), windowChangeNotification.isSetCardWindowSettings());
        if (n != 0) {
            return n;
        }
        if (this.isSetCardWindowSettings() && (n = TBaseHelper.compareTo((Comparable)this.cardWindowSettings, (Comparable)windowChangeNotification.cardWindowSettings)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        WindowChangeNotification.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        WindowChangeNotification.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("WindowChangeNotification(");
        boolean bl = true;
        stringBuilder.append("windowState:");
        if (this.windowState == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.windowState);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("layoutUI:");
        if (this.layoutUI == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.layoutUI);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("layoutNames:");
        if (this.layoutNames == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.layoutNames);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("scriptNames:");
        if (this.scriptNames == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.scriptNames);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("cardStyleWindow:");
        stringBuilder.append(this.cardStyleWindow);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("cardWindowSettings:");
        if (this.cardWindowSettings == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.cardWindowSettings);
        }
        bl = false;
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void validate() throws TException {
        if (this.windowState != null) {
            this.windowState.validate();
        }
        if (this.layoutUI != null) {
            this.layoutUI.validate();
        }
        if (this.layoutNames != null) {
            this.layoutNames.validate();
        }
        if (this.scriptNames != null) {
            this.scriptNames.validate();
        }
        if (this.cardWindowSettings != null) {
            this.cardWindowSettings.validate();
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
        enumMap.put(_Fields.WINDOW_STATE, new FieldMetaData("windowState", 3, (FieldValueMetaData)new StructMetaData(12, WindowState.class)));
        enumMap.put(_Fields.LAYOUT_UI, new FieldMetaData("layoutUI", 3, (FieldValueMetaData)new StructMetaData(12, LayoutUI.class)));
        enumMap.put(_Fields.LAYOUT_NAMES, new FieldMetaData("layoutNames", 3, (FieldValueMetaData)new StructMetaData(12, HierarchicalNames.class)));
        enumMap.put(_Fields.SCRIPT_NAMES, new FieldMetaData("scriptNames", 3, (FieldValueMetaData)new StructMetaData(12, HierarchicalNames.class)));
        enumMap.put(_Fields.CARD_STYLE_WINDOW, new FieldMetaData("cardStyleWindow", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.CARD_WINDOW_SETTINGS, new FieldMetaData("cardWindowSettings", 3, (FieldValueMetaData)new StructMetaData(12, CardWindowSettings.class)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(WindowChangeNotification.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        WINDOW_STATE(1, "windowState"),
        LAYOUT_UI(2, "layoutUI"),
        LAYOUT_NAMES(3, "layoutNames"),
        SCRIPT_NAMES(4, "scriptNames"),
        CARD_STYLE_WINDOW(5, "cardStyleWindow"),
        CARD_WINDOW_SETTINGS(6, "cardWindowSettings");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return WINDOW_STATE;
                }
                case 2: {
                    return LAYOUT_UI;
                }
                case 3: {
                    return LAYOUT_NAMES;
                }
                case 4: {
                    return SCRIPT_NAMES;
                }
                case 5: {
                    return CARD_STYLE_WINDOW;
                }
                case 6: {
                    return CARD_WINDOW_SETTINGS;
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

    private static class WindowChangeNotificationStandardSchemeFactory
    implements SchemeFactory {
        private WindowChangeNotificationStandardSchemeFactory() {
        }

        public WindowChangeNotificationStandardScheme getScheme() {
            return new WindowChangeNotificationStandardScheme();
        }
    }

    private static class WindowChangeNotificationTupleSchemeFactory
    implements SchemeFactory {
        private WindowChangeNotificationTupleSchemeFactory() {
        }

        public WindowChangeNotificationTupleScheme getScheme() {
            return new WindowChangeNotificationTupleScheme();
        }
    }

    private static class WindowChangeNotificationTupleScheme
    extends TupleScheme<WindowChangeNotification> {
        private WindowChangeNotificationTupleScheme() {
        }

        public void write(TProtocol tProtocol, WindowChangeNotification windowChangeNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (windowChangeNotification.isSetWindowState()) {
                bitSet.set(0);
            }
            if (windowChangeNotification.isSetLayoutUI()) {
                bitSet.set(1);
            }
            if (windowChangeNotification.isSetLayoutNames()) {
                bitSet.set(2);
            }
            if (windowChangeNotification.isSetScriptNames()) {
                bitSet.set(3);
            }
            if (windowChangeNotification.isSetCardStyleWindow()) {
                bitSet.set(4);
            }
            if (windowChangeNotification.isSetCardWindowSettings()) {
                bitSet.set(5);
            }
            tTupleProtocol.writeBitSet(bitSet, 6);
            if (windowChangeNotification.isSetWindowState()) {
                windowChangeNotification.windowState.write((TProtocol)tTupleProtocol);
            }
            if (windowChangeNotification.isSetLayoutUI()) {
                windowChangeNotification.layoutUI.write((TProtocol)tTupleProtocol);
            }
            if (windowChangeNotification.isSetLayoutNames()) {
                windowChangeNotification.layoutNames.write((TProtocol)tTupleProtocol);
            }
            if (windowChangeNotification.isSetScriptNames()) {
                windowChangeNotification.scriptNames.write((TProtocol)tTupleProtocol);
            }
            if (windowChangeNotification.isSetCardStyleWindow()) {
                tTupleProtocol.writeBool(windowChangeNotification.cardStyleWindow);
            }
            if (windowChangeNotification.isSetCardWindowSettings()) {
                windowChangeNotification.cardWindowSettings.write((TProtocol)tTupleProtocol);
            }
        }

        public void read(TProtocol tProtocol, WindowChangeNotification windowChangeNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(6);
            if (bitSet.get(0)) {
                windowChangeNotification.windowState = new WindowState();
                windowChangeNotification.windowState.read((TProtocol)tTupleProtocol);
                windowChangeNotification.setWindowStateIsSet(true);
            }
            if (bitSet.get(1)) {
                windowChangeNotification.layoutUI = new LayoutUI();
                windowChangeNotification.layoutUI.read((TProtocol)tTupleProtocol);
                windowChangeNotification.setLayoutUIIsSet(true);
            }
            if (bitSet.get(2)) {
                windowChangeNotification.layoutNames = new HierarchicalNames();
                windowChangeNotification.layoutNames.read((TProtocol)tTupleProtocol);
                windowChangeNotification.setLayoutNamesIsSet(true);
            }
            if (bitSet.get(3)) {
                windowChangeNotification.scriptNames = new HierarchicalNames();
                windowChangeNotification.scriptNames.read((TProtocol)tTupleProtocol);
                windowChangeNotification.setScriptNamesIsSet(true);
            }
            if (bitSet.get(4)) {
                windowChangeNotification.cardStyleWindow = tTupleProtocol.readBool();
                windowChangeNotification.setCardStyleWindowIsSet(true);
            }
            if (bitSet.get(5)) {
                windowChangeNotification.cardWindowSettings = new CardWindowSettings();
                windowChangeNotification.cardWindowSettings.read((TProtocol)tTupleProtocol);
                windowChangeNotification.setCardWindowSettingsIsSet(true);
            }
        }
    }

    private static class WindowChangeNotificationStandardScheme
    extends StandardScheme<WindowChangeNotification> {
        private WindowChangeNotificationStandardScheme() {
        }

        public void read(TProtocol tProtocol, WindowChangeNotification windowChangeNotification) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 12) {
                            windowChangeNotification.windowState = new WindowState();
                            windowChangeNotification.windowState.read(tProtocol);
                            windowChangeNotification.setWindowStateIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 12) {
                            windowChangeNotification.layoutUI = new LayoutUI();
                            windowChangeNotification.layoutUI.read(tProtocol);
                            windowChangeNotification.setLayoutUIIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 12) {
                            windowChangeNotification.layoutNames = new HierarchicalNames();
                            windowChangeNotification.layoutNames.read(tProtocol);
                            windowChangeNotification.setLayoutNamesIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 12) {
                            windowChangeNotification.scriptNames = new HierarchicalNames();
                            windowChangeNotification.scriptNames.read(tProtocol);
                            windowChangeNotification.setScriptNamesIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 5: {
                        if (tField.type == 2) {
                            windowChangeNotification.cardStyleWindow = tProtocol.readBool();
                            windowChangeNotification.setCardStyleWindowIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 6: {
                        if (tField.type == 12) {
                            windowChangeNotification.cardWindowSettings = new CardWindowSettings();
                            windowChangeNotification.cardWindowSettings.read(tProtocol);
                            windowChangeNotification.setCardWindowSettingsIsSet(true);
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
            windowChangeNotification.validate();
        }

        public void write(TProtocol tProtocol, WindowChangeNotification windowChangeNotification) throws TException {
            windowChangeNotification.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (windowChangeNotification.windowState != null) {
                tProtocol.writeFieldBegin(WINDOW_STATE_FIELD_DESC);
                windowChangeNotification.windowState.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            if (windowChangeNotification.layoutUI != null) {
                tProtocol.writeFieldBegin(LAYOUT_UI_FIELD_DESC);
                windowChangeNotification.layoutUI.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            if (windowChangeNotification.layoutNames != null) {
                tProtocol.writeFieldBegin(LAYOUT_NAMES_FIELD_DESC);
                windowChangeNotification.layoutNames.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            if (windowChangeNotification.scriptNames != null) {
                tProtocol.writeFieldBegin(SCRIPT_NAMES_FIELD_DESC);
                windowChangeNotification.scriptNames.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(CARD_STYLE_WINDOW_FIELD_DESC);
            tProtocol.writeBool(windowChangeNotification.cardStyleWindow);
            tProtocol.writeFieldEnd();
            if (windowChangeNotification.cardWindowSettings != null) {
                tProtocol.writeFieldBegin(CARD_WINDOW_SETTINGS_FIELD_DESC);
                windowChangeNotification.cardWindowSettings.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

