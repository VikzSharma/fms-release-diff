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

public class LayoutNotification
implements TBase<LayoutNotification, _Fields>,
Serializable,
Cloneable,
Comparable<LayoutNotification> {
    private static final TStruct STRUCT_DESC = new TStruct("LayoutNotification");
    private static final TField WINDOW_STATE_FIELD_DESC = new TField("windowState", 12, 1);
    private static final TField LAYOUT_UI_FIELD_DESC = new TField("layoutUI", 12, 2);
    private static final TField LAYOUT_NAMES_FIELD_DESC = new TField("layoutNames", 12, 3);
    private static final TField SCRIPT_NAMES_FIELD_DESC = new TField("scriptNames", 12, 4);
    private static final TField FORCE_REDRAW_FIELD_DESC = new TField("forceRedraw", 2, 5);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new LayoutNotificationStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new LayoutNotificationTupleSchemeFactory();
    @Nullable
    private WindowState windowState;
    @Nullable
    private LayoutUI layoutUI;
    @Nullable
    private HierarchicalNames layoutNames;
    @Nullable
    private HierarchicalNames scriptNames;
    private boolean forceRedraw;
    private static final int __FORCEREDRAW_ISSET_ID = 0;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public LayoutNotification() {
    }

    public LayoutNotification(WindowState windowState, LayoutUI layoutUI, HierarchicalNames hierarchicalNames, HierarchicalNames hierarchicalNames2, boolean bl) {
        this();
        this.windowState = windowState;
        this.layoutUI = layoutUI;
        this.layoutNames = hierarchicalNames;
        this.scriptNames = hierarchicalNames2;
        this.forceRedraw = bl;
        this.setForceRedrawIsSet(true);
    }

    public LayoutNotification(LayoutNotification layoutNotification) {
        this.__isset_bitfield = layoutNotification.__isset_bitfield;
        if (layoutNotification.isSetWindowState()) {
            this.windowState = new WindowState(layoutNotification.windowState);
        }
        if (layoutNotification.isSetLayoutUI()) {
            this.layoutUI = new LayoutUI(layoutNotification.layoutUI);
        }
        if (layoutNotification.isSetLayoutNames()) {
            this.layoutNames = new HierarchicalNames(layoutNotification.layoutNames);
        }
        if (layoutNotification.isSetScriptNames()) {
            this.scriptNames = new HierarchicalNames(layoutNotification.scriptNames);
        }
        this.forceRedraw = layoutNotification.forceRedraw;
    }

    public LayoutNotification deepCopy() {
        return new LayoutNotification(this);
    }

    public void clear() {
        this.windowState = null;
        this.layoutUI = null;
        this.layoutNames = null;
        this.scriptNames = null;
        this.setForceRedrawIsSet(false);
        this.forceRedraw = false;
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

    public boolean isForceRedraw() {
        return this.forceRedraw;
    }

    public void setForceRedraw(boolean bl) {
        this.forceRedraw = bl;
        this.setForceRedrawIsSet(true);
    }

    public void unsetForceRedraw() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetForceRedraw() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setForceRedrawIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
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
                    this.unsetForceRedraw();
                    break;
                }
                this.setForceRedraw((Boolean)object);
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
                return this.isForceRedraw();
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
                return this.isSetForceRedraw();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof LayoutNotification) {
            return this.equals((LayoutNotification)object);
        }
        return false;
    }

    public boolean equals(LayoutNotification layoutNotification) {
        if (layoutNotification == null) {
            return false;
        }
        if (this == layoutNotification) {
            return true;
        }
        boolean bl = this.isSetWindowState();
        boolean bl2 = layoutNotification.isSetWindowState();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.windowState.equals(layoutNotification.windowState)) {
                return false;
            }
        }
        boolean bl3 = this.isSetLayoutUI();
        boolean bl4 = layoutNotification.isSetLayoutUI();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.layoutUI.equals(layoutNotification.layoutUI)) {
                return false;
            }
        }
        boolean bl5 = this.isSetLayoutNames();
        boolean bl6 = layoutNotification.isSetLayoutNames();
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (!this.layoutNames.equals(layoutNotification.layoutNames)) {
                return false;
            }
        }
        boolean bl7 = this.isSetScriptNames();
        boolean bl8 = layoutNotification.isSetScriptNames();
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (!this.scriptNames.equals(layoutNotification.scriptNames)) {
                return false;
            }
        }
        boolean bl9 = true;
        boolean bl10 = true;
        if (bl9 || bl10) {
            if (!bl9 || !bl10) {
                return false;
            }
            if (this.forceRedraw != layoutNotification.forceRedraw) {
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
        n = n * 8191 + (this.forceRedraw ? 131071 : 524287);
        return n;
    }

    @Override
    public int compareTo(LayoutNotification layoutNotification) {
        if (!this.getClass().equals(layoutNotification.getClass())) {
            return this.getClass().getName().compareTo(layoutNotification.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetWindowState(), layoutNotification.isSetWindowState());
        if (n != 0) {
            return n;
        }
        if (this.isSetWindowState() && (n = TBaseHelper.compareTo((Comparable)this.windowState, (Comparable)layoutNotification.windowState)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetLayoutUI(), layoutNotification.isSetLayoutUI());
        if (n != 0) {
            return n;
        }
        if (this.isSetLayoutUI() && (n = TBaseHelper.compareTo((Comparable)this.layoutUI, (Comparable)layoutNotification.layoutUI)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetLayoutNames(), layoutNotification.isSetLayoutNames());
        if (n != 0) {
            return n;
        }
        if (this.isSetLayoutNames() && (n = TBaseHelper.compareTo((Comparable)this.layoutNames, (Comparable)layoutNotification.layoutNames)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetScriptNames(), layoutNotification.isSetScriptNames());
        if (n != 0) {
            return n;
        }
        if (this.isSetScriptNames() && (n = TBaseHelper.compareTo((Comparable)this.scriptNames, (Comparable)layoutNotification.scriptNames)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetForceRedraw(), layoutNotification.isSetForceRedraw());
        if (n != 0) {
            return n;
        }
        if (this.isSetForceRedraw() && (n = TBaseHelper.compareTo((boolean)this.forceRedraw, (boolean)layoutNotification.forceRedraw)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        LayoutNotification.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        LayoutNotification.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("LayoutNotification(");
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
        stringBuilder.append("forceRedraw:");
        stringBuilder.append(this.forceRedraw);
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
        enumMap.put(_Fields.FORCE_REDRAW, new FieldMetaData("forceRedraw", 3, new FieldValueMetaData(2)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(LayoutNotification.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        WINDOW_STATE(1, "windowState"),
        LAYOUT_UI(2, "layoutUI"),
        LAYOUT_NAMES(3, "layoutNames"),
        SCRIPT_NAMES(4, "scriptNames"),
        FORCE_REDRAW(5, "forceRedraw");

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
                    return FORCE_REDRAW;
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

    private static class LayoutNotificationStandardSchemeFactory
    implements SchemeFactory {
        private LayoutNotificationStandardSchemeFactory() {
        }

        public LayoutNotificationStandardScheme getScheme() {
            return new LayoutNotificationStandardScheme();
        }
    }

    private static class LayoutNotificationTupleSchemeFactory
    implements SchemeFactory {
        private LayoutNotificationTupleSchemeFactory() {
        }

        public LayoutNotificationTupleScheme getScheme() {
            return new LayoutNotificationTupleScheme();
        }
    }

    private static class LayoutNotificationTupleScheme
    extends TupleScheme<LayoutNotification> {
        private LayoutNotificationTupleScheme() {
        }

        public void write(TProtocol tProtocol, LayoutNotification layoutNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (layoutNotification.isSetWindowState()) {
                bitSet.set(0);
            }
            if (layoutNotification.isSetLayoutUI()) {
                bitSet.set(1);
            }
            if (layoutNotification.isSetLayoutNames()) {
                bitSet.set(2);
            }
            if (layoutNotification.isSetScriptNames()) {
                bitSet.set(3);
            }
            if (layoutNotification.isSetForceRedraw()) {
                bitSet.set(4);
            }
            tTupleProtocol.writeBitSet(bitSet, 5);
            if (layoutNotification.isSetWindowState()) {
                layoutNotification.windowState.write((TProtocol)tTupleProtocol);
            }
            if (layoutNotification.isSetLayoutUI()) {
                layoutNotification.layoutUI.write((TProtocol)tTupleProtocol);
            }
            if (layoutNotification.isSetLayoutNames()) {
                layoutNotification.layoutNames.write((TProtocol)tTupleProtocol);
            }
            if (layoutNotification.isSetScriptNames()) {
                layoutNotification.scriptNames.write((TProtocol)tTupleProtocol);
            }
            if (layoutNotification.isSetForceRedraw()) {
                tTupleProtocol.writeBool(layoutNotification.forceRedraw);
            }
        }

        public void read(TProtocol tProtocol, LayoutNotification layoutNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(5);
            if (bitSet.get(0)) {
                layoutNotification.windowState = new WindowState();
                layoutNotification.windowState.read((TProtocol)tTupleProtocol);
                layoutNotification.setWindowStateIsSet(true);
            }
            if (bitSet.get(1)) {
                layoutNotification.layoutUI = new LayoutUI();
                layoutNotification.layoutUI.read((TProtocol)tTupleProtocol);
                layoutNotification.setLayoutUIIsSet(true);
            }
            if (bitSet.get(2)) {
                layoutNotification.layoutNames = new HierarchicalNames();
                layoutNotification.layoutNames.read((TProtocol)tTupleProtocol);
                layoutNotification.setLayoutNamesIsSet(true);
            }
            if (bitSet.get(3)) {
                layoutNotification.scriptNames = new HierarchicalNames();
                layoutNotification.scriptNames.read((TProtocol)tTupleProtocol);
                layoutNotification.setScriptNamesIsSet(true);
            }
            if (bitSet.get(4)) {
                layoutNotification.forceRedraw = tTupleProtocol.readBool();
                layoutNotification.setForceRedrawIsSet(true);
            }
        }
    }

    private static class LayoutNotificationStandardScheme
    extends StandardScheme<LayoutNotification> {
        private LayoutNotificationStandardScheme() {
        }

        public void read(TProtocol tProtocol, LayoutNotification layoutNotification) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 12) {
                            layoutNotification.windowState = new WindowState();
                            layoutNotification.windowState.read(tProtocol);
                            layoutNotification.setWindowStateIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 12) {
                            layoutNotification.layoutUI = new LayoutUI();
                            layoutNotification.layoutUI.read(tProtocol);
                            layoutNotification.setLayoutUIIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 12) {
                            layoutNotification.layoutNames = new HierarchicalNames();
                            layoutNotification.layoutNames.read(tProtocol);
                            layoutNotification.setLayoutNamesIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 12) {
                            layoutNotification.scriptNames = new HierarchicalNames();
                            layoutNotification.scriptNames.read(tProtocol);
                            layoutNotification.setScriptNamesIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 5: {
                        if (tField.type == 2) {
                            layoutNotification.forceRedraw = tProtocol.readBool();
                            layoutNotification.setForceRedrawIsSet(true);
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
            layoutNotification.validate();
        }

        public void write(TProtocol tProtocol, LayoutNotification layoutNotification) throws TException {
            layoutNotification.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (layoutNotification.windowState != null) {
                tProtocol.writeFieldBegin(WINDOW_STATE_FIELD_DESC);
                layoutNotification.windowState.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            if (layoutNotification.layoutUI != null) {
                tProtocol.writeFieldBegin(LAYOUT_UI_FIELD_DESC);
                layoutNotification.layoutUI.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            if (layoutNotification.layoutNames != null) {
                tProtocol.writeFieldBegin(LAYOUT_NAMES_FIELD_DESC);
                layoutNotification.layoutNames.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            if (layoutNotification.scriptNames != null) {
                tProtocol.writeFieldBegin(SCRIPT_NAMES_FIELD_DESC);
                layoutNotification.scriptNames.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(FORCE_REDRAW_FIELD_DESC);
            tProtocol.writeBool(layoutNotification.forceRedraw);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

