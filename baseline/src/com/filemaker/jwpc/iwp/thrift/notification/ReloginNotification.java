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

public class ReloginNotification
implements TBase<ReloginNotification, _Fields>,
Serializable,
Cloneable,
Comparable<ReloginNotification> {
    private static final TStruct STRUCT_DESC = new TStruct("ReloginNotification");
    private static final TField WINDOW_STATE_FIELD_DESC = new TField("windowState", 12, 1);
    private static final TField LAYOUT_UI_FIELD_DESC = new TField("layoutUI", 12, 2);
    private static final TField LAYOUT_NAMES_FIELD_DESC = new TField("layoutNames", 12, 3);
    private static final TField SCRIPT_NAMES_FIELD_DESC = new TField("scriptNames", 12, 4);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new ReloginNotificationStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new ReloginNotificationTupleSchemeFactory();
    @Nullable
    private WindowState windowState;
    @Nullable
    private LayoutUI layoutUI;
    @Nullable
    private HierarchicalNames layoutNames;
    @Nullable
    private HierarchicalNames scriptNames;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public ReloginNotification() {
    }

    public ReloginNotification(WindowState windowState, LayoutUI layoutUI, HierarchicalNames hierarchicalNames, HierarchicalNames hierarchicalNames2) {
        this();
        this.windowState = windowState;
        this.layoutUI = layoutUI;
        this.layoutNames = hierarchicalNames;
        this.scriptNames = hierarchicalNames2;
    }

    public ReloginNotification(ReloginNotification reloginNotification) {
        if (reloginNotification.isSetWindowState()) {
            this.windowState = new WindowState(reloginNotification.windowState);
        }
        if (reloginNotification.isSetLayoutUI()) {
            this.layoutUI = new LayoutUI(reloginNotification.layoutUI);
        }
        if (reloginNotification.isSetLayoutNames()) {
            this.layoutNames = new HierarchicalNames(reloginNotification.layoutNames);
        }
        if (reloginNotification.isSetScriptNames()) {
            this.scriptNames = new HierarchicalNames(reloginNotification.scriptNames);
        }
    }

    public ReloginNotification deepCopy() {
        return new ReloginNotification(this);
    }

    public void clear() {
        this.windowState = null;
        this.layoutUI = null;
        this.layoutNames = null;
        this.scriptNames = null;
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
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof ReloginNotification) {
            return this.equals((ReloginNotification)object);
        }
        return false;
    }

    public boolean equals(ReloginNotification reloginNotification) {
        if (reloginNotification == null) {
            return false;
        }
        if (this == reloginNotification) {
            return true;
        }
        boolean bl = this.isSetWindowState();
        boolean bl2 = reloginNotification.isSetWindowState();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.windowState.equals(reloginNotification.windowState)) {
                return false;
            }
        }
        boolean bl3 = this.isSetLayoutUI();
        boolean bl4 = reloginNotification.isSetLayoutUI();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.layoutUI.equals(reloginNotification.layoutUI)) {
                return false;
            }
        }
        boolean bl5 = this.isSetLayoutNames();
        boolean bl6 = reloginNotification.isSetLayoutNames();
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (!this.layoutNames.equals(reloginNotification.layoutNames)) {
                return false;
            }
        }
        boolean bl7 = this.isSetScriptNames();
        boolean bl8 = reloginNotification.isSetScriptNames();
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (!this.scriptNames.equals(reloginNotification.scriptNames)) {
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
        return n;
    }

    @Override
    public int compareTo(ReloginNotification reloginNotification) {
        if (!this.getClass().equals(reloginNotification.getClass())) {
            return this.getClass().getName().compareTo(reloginNotification.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetWindowState(), reloginNotification.isSetWindowState());
        if (n != 0) {
            return n;
        }
        if (this.isSetWindowState() && (n = TBaseHelper.compareTo((Comparable)this.windowState, (Comparable)reloginNotification.windowState)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetLayoutUI(), reloginNotification.isSetLayoutUI());
        if (n != 0) {
            return n;
        }
        if (this.isSetLayoutUI() && (n = TBaseHelper.compareTo((Comparable)this.layoutUI, (Comparable)reloginNotification.layoutUI)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetLayoutNames(), reloginNotification.isSetLayoutNames());
        if (n != 0) {
            return n;
        }
        if (this.isSetLayoutNames() && (n = TBaseHelper.compareTo((Comparable)this.layoutNames, (Comparable)reloginNotification.layoutNames)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetScriptNames(), reloginNotification.isSetScriptNames());
        if (n != 0) {
            return n;
        }
        if (this.isSetScriptNames() && (n = TBaseHelper.compareTo((Comparable)this.scriptNames, (Comparable)reloginNotification.scriptNames)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        ReloginNotification.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        ReloginNotification.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ReloginNotification(");
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
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(ReloginNotification.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        WINDOW_STATE(1, "windowState"),
        LAYOUT_UI(2, "layoutUI"),
        LAYOUT_NAMES(3, "layoutNames"),
        SCRIPT_NAMES(4, "scriptNames");

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

    private static class ReloginNotificationStandardSchemeFactory
    implements SchemeFactory {
        private ReloginNotificationStandardSchemeFactory() {
        }

        public ReloginNotificationStandardScheme getScheme() {
            return new ReloginNotificationStandardScheme();
        }
    }

    private static class ReloginNotificationTupleSchemeFactory
    implements SchemeFactory {
        private ReloginNotificationTupleSchemeFactory() {
        }

        public ReloginNotificationTupleScheme getScheme() {
            return new ReloginNotificationTupleScheme();
        }
    }

    private static class ReloginNotificationTupleScheme
    extends TupleScheme<ReloginNotification> {
        private ReloginNotificationTupleScheme() {
        }

        public void write(TProtocol tProtocol, ReloginNotification reloginNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (reloginNotification.isSetWindowState()) {
                bitSet.set(0);
            }
            if (reloginNotification.isSetLayoutUI()) {
                bitSet.set(1);
            }
            if (reloginNotification.isSetLayoutNames()) {
                bitSet.set(2);
            }
            if (reloginNotification.isSetScriptNames()) {
                bitSet.set(3);
            }
            tTupleProtocol.writeBitSet(bitSet, 4);
            if (reloginNotification.isSetWindowState()) {
                reloginNotification.windowState.write((TProtocol)tTupleProtocol);
            }
            if (reloginNotification.isSetLayoutUI()) {
                reloginNotification.layoutUI.write((TProtocol)tTupleProtocol);
            }
            if (reloginNotification.isSetLayoutNames()) {
                reloginNotification.layoutNames.write((TProtocol)tTupleProtocol);
            }
            if (reloginNotification.isSetScriptNames()) {
                reloginNotification.scriptNames.write((TProtocol)tTupleProtocol);
            }
        }

        public void read(TProtocol tProtocol, ReloginNotification reloginNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(4);
            if (bitSet.get(0)) {
                reloginNotification.windowState = new WindowState();
                reloginNotification.windowState.read((TProtocol)tTupleProtocol);
                reloginNotification.setWindowStateIsSet(true);
            }
            if (bitSet.get(1)) {
                reloginNotification.layoutUI = new LayoutUI();
                reloginNotification.layoutUI.read((TProtocol)tTupleProtocol);
                reloginNotification.setLayoutUIIsSet(true);
            }
            if (bitSet.get(2)) {
                reloginNotification.layoutNames = new HierarchicalNames();
                reloginNotification.layoutNames.read((TProtocol)tTupleProtocol);
                reloginNotification.setLayoutNamesIsSet(true);
            }
            if (bitSet.get(3)) {
                reloginNotification.scriptNames = new HierarchicalNames();
                reloginNotification.scriptNames.read((TProtocol)tTupleProtocol);
                reloginNotification.setScriptNamesIsSet(true);
            }
        }
    }

    private static class ReloginNotificationStandardScheme
    extends StandardScheme<ReloginNotification> {
        private ReloginNotificationStandardScheme() {
        }

        public void read(TProtocol tProtocol, ReloginNotification reloginNotification) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 12) {
                            reloginNotification.windowState = new WindowState();
                            reloginNotification.windowState.read(tProtocol);
                            reloginNotification.setWindowStateIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 12) {
                            reloginNotification.layoutUI = new LayoutUI();
                            reloginNotification.layoutUI.read(tProtocol);
                            reloginNotification.setLayoutUIIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 12) {
                            reloginNotification.layoutNames = new HierarchicalNames();
                            reloginNotification.layoutNames.read(tProtocol);
                            reloginNotification.setLayoutNamesIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 12) {
                            reloginNotification.scriptNames = new HierarchicalNames();
                            reloginNotification.scriptNames.read(tProtocol);
                            reloginNotification.setScriptNamesIsSet(true);
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
            reloginNotification.validate();
        }

        public void write(TProtocol tProtocol, ReloginNotification reloginNotification) throws TException {
            reloginNotification.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (reloginNotification.windowState != null) {
                tProtocol.writeFieldBegin(WINDOW_STATE_FIELD_DESC);
                reloginNotification.windowState.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            if (reloginNotification.layoutUI != null) {
                tProtocol.writeFieldBegin(LAYOUT_UI_FIELD_DESC);
                reloginNotification.layoutUI.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            if (reloginNotification.layoutNames != null) {
                tProtocol.writeFieldBegin(LAYOUT_NAMES_FIELD_DESC);
                reloginNotification.layoutNames.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            if (reloginNotification.scriptNames != null) {
                tProtocol.writeFieldBegin(SCRIPT_NAMES_FIELD_DESC);
                reloginNotification.scriptNames.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

