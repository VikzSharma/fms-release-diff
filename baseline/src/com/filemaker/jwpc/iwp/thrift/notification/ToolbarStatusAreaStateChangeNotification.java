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

import com.filemaker.jwpc.iwp.thrift.common.ToolbarStatusAreaState;
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

public class ToolbarStatusAreaStateChangeNotification
implements TBase<ToolbarStatusAreaStateChangeNotification, _Fields>,
Serializable,
Cloneable,
Comparable<ToolbarStatusAreaStateChangeNotification> {
    private static final TStruct STRUCT_DESC = new TStruct("ToolbarStatusAreaStateChangeNotification");
    private static final TField TOOLBAR_STATUSAREA_STATE_FIELD_DESC = new TField("toolbarStatusareaState", 12, 1);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new ToolbarStatusAreaStateChangeNotificationStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new ToolbarStatusAreaStateChangeNotificationTupleSchemeFactory();
    @Nullable
    private ToolbarStatusAreaState toolbarStatusareaState;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public ToolbarStatusAreaStateChangeNotification() {
    }

    public ToolbarStatusAreaStateChangeNotification(ToolbarStatusAreaState toolbarStatusAreaState) {
        this();
        this.toolbarStatusareaState = toolbarStatusAreaState;
    }

    public ToolbarStatusAreaStateChangeNotification(ToolbarStatusAreaStateChangeNotification toolbarStatusAreaStateChangeNotification) {
        if (toolbarStatusAreaStateChangeNotification.isSetToolbarStatusareaState()) {
            this.toolbarStatusareaState = new ToolbarStatusAreaState(toolbarStatusAreaStateChangeNotification.toolbarStatusareaState);
        }
    }

    public ToolbarStatusAreaStateChangeNotification deepCopy() {
        return new ToolbarStatusAreaStateChangeNotification(this);
    }

    public void clear() {
        this.toolbarStatusareaState = null;
    }

    @Nullable
    public ToolbarStatusAreaState getToolbarStatusareaState() {
        return this.toolbarStatusareaState;
    }

    public void setToolbarStatusareaState(@Nullable ToolbarStatusAreaState toolbarStatusAreaState) {
        this.toolbarStatusareaState = toolbarStatusAreaState;
    }

    public void unsetToolbarStatusareaState() {
        this.toolbarStatusareaState = null;
    }

    public boolean isSetToolbarStatusareaState() {
        return this.toolbarStatusareaState != null;
    }

    public void setToolbarStatusareaStateIsSet(boolean bl) {
        if (!bl) {
            this.toolbarStatusareaState = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetToolbarStatusareaState();
                    break;
                }
                this.setToolbarStatusareaState((ToolbarStatusAreaState)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getToolbarStatusareaState();
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
                return this.isSetToolbarStatusareaState();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof ToolbarStatusAreaStateChangeNotification) {
            return this.equals((ToolbarStatusAreaStateChangeNotification)object);
        }
        return false;
    }

    public boolean equals(ToolbarStatusAreaStateChangeNotification toolbarStatusAreaStateChangeNotification) {
        if (toolbarStatusAreaStateChangeNotification == null) {
            return false;
        }
        if (this == toolbarStatusAreaStateChangeNotification) {
            return true;
        }
        boolean bl = this.isSetToolbarStatusareaState();
        boolean bl2 = toolbarStatusAreaStateChangeNotification.isSetToolbarStatusareaState();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.toolbarStatusareaState.equals(toolbarStatusAreaStateChangeNotification.toolbarStatusareaState)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetToolbarStatusareaState() ? 131071 : 524287);
        if (this.isSetToolbarStatusareaState()) {
            n = n * 8191 + this.toolbarStatusareaState.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(ToolbarStatusAreaStateChangeNotification toolbarStatusAreaStateChangeNotification) {
        if (!this.getClass().equals(toolbarStatusAreaStateChangeNotification.getClass())) {
            return this.getClass().getName().compareTo(toolbarStatusAreaStateChangeNotification.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetToolbarStatusareaState(), toolbarStatusAreaStateChangeNotification.isSetToolbarStatusareaState());
        if (n != 0) {
            return n;
        }
        if (this.isSetToolbarStatusareaState() && (n = TBaseHelper.compareTo((Comparable)this.toolbarStatusareaState, (Comparable)toolbarStatusAreaStateChangeNotification.toolbarStatusareaState)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        ToolbarStatusAreaStateChangeNotification.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        ToolbarStatusAreaStateChangeNotification.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ToolbarStatusAreaStateChangeNotification(");
        boolean bl = true;
        stringBuilder.append("toolbarStatusareaState:");
        if (this.toolbarStatusareaState == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.toolbarStatusareaState);
        }
        bl = false;
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void validate() throws TException {
        if (this.toolbarStatusareaState != null) {
            this.toolbarStatusareaState.validate();
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
        enumMap.put(_Fields.TOOLBAR_STATUSAREA_STATE, new FieldMetaData("toolbarStatusareaState", 3, (FieldValueMetaData)new StructMetaData(12, ToolbarStatusAreaState.class)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(ToolbarStatusAreaStateChangeNotification.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        TOOLBAR_STATUSAREA_STATE(1, "toolbarStatusareaState");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return TOOLBAR_STATUSAREA_STATE;
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

    private static class ToolbarStatusAreaStateChangeNotificationStandardSchemeFactory
    implements SchemeFactory {
        private ToolbarStatusAreaStateChangeNotificationStandardSchemeFactory() {
        }

        public ToolbarStatusAreaStateChangeNotificationStandardScheme getScheme() {
            return new ToolbarStatusAreaStateChangeNotificationStandardScheme();
        }
    }

    private static class ToolbarStatusAreaStateChangeNotificationTupleSchemeFactory
    implements SchemeFactory {
        private ToolbarStatusAreaStateChangeNotificationTupleSchemeFactory() {
        }

        public ToolbarStatusAreaStateChangeNotificationTupleScheme getScheme() {
            return new ToolbarStatusAreaStateChangeNotificationTupleScheme();
        }
    }

    private static class ToolbarStatusAreaStateChangeNotificationTupleScheme
    extends TupleScheme<ToolbarStatusAreaStateChangeNotification> {
        private ToolbarStatusAreaStateChangeNotificationTupleScheme() {
        }

        public void write(TProtocol tProtocol, ToolbarStatusAreaStateChangeNotification toolbarStatusAreaStateChangeNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (toolbarStatusAreaStateChangeNotification.isSetToolbarStatusareaState()) {
                bitSet.set(0);
            }
            tTupleProtocol.writeBitSet(bitSet, 1);
            if (toolbarStatusAreaStateChangeNotification.isSetToolbarStatusareaState()) {
                toolbarStatusAreaStateChangeNotification.toolbarStatusareaState.write((TProtocol)tTupleProtocol);
            }
        }

        public void read(TProtocol tProtocol, ToolbarStatusAreaStateChangeNotification toolbarStatusAreaStateChangeNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(1);
            if (bitSet.get(0)) {
                toolbarStatusAreaStateChangeNotification.toolbarStatusareaState = new ToolbarStatusAreaState();
                toolbarStatusAreaStateChangeNotification.toolbarStatusareaState.read((TProtocol)tTupleProtocol);
                toolbarStatusAreaStateChangeNotification.setToolbarStatusareaStateIsSet(true);
            }
        }
    }

    private static class ToolbarStatusAreaStateChangeNotificationStandardScheme
    extends StandardScheme<ToolbarStatusAreaStateChangeNotification> {
        private ToolbarStatusAreaStateChangeNotificationStandardScheme() {
        }

        public void read(TProtocol tProtocol, ToolbarStatusAreaStateChangeNotification toolbarStatusAreaStateChangeNotification) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 12) {
                            toolbarStatusAreaStateChangeNotification.toolbarStatusareaState = new ToolbarStatusAreaState();
                            toolbarStatusAreaStateChangeNotification.toolbarStatusareaState.read(tProtocol);
                            toolbarStatusAreaStateChangeNotification.setToolbarStatusareaStateIsSet(true);
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
            toolbarStatusAreaStateChangeNotification.validate();
        }

        public void write(TProtocol tProtocol, ToolbarStatusAreaStateChangeNotification toolbarStatusAreaStateChangeNotification) throws TException {
            toolbarStatusAreaStateChangeNotification.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (toolbarStatusAreaStateChangeNotification.toolbarStatusareaState != null) {
                tProtocol.writeFieldBegin(TOOLBAR_STATUSAREA_STATE_FIELD_DESC);
                toolbarStatusAreaStateChangeNotification.toolbarStatusareaState.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

