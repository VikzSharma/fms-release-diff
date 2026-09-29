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

import com.filemaker.jwpc.iwp.thrift.common.WindowState;
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

public class RowSelectionChangeNotification
implements TBase<RowSelectionChangeNotification, _Fields>,
Serializable,
Cloneable,
Comparable<RowSelectionChangeNotification> {
    private static final TStruct STRUCT_DESC = new TStruct("RowSelectionChangeNotification");
    private static final TField WINDOW_STATE_FIELD_DESC = new TField("windowState", 12, 1);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new RowSelectionChangeNotificationStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new RowSelectionChangeNotificationTupleSchemeFactory();
    @Nullable
    private WindowState windowState;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public RowSelectionChangeNotification() {
    }

    public RowSelectionChangeNotification(WindowState windowState) {
        this();
        this.windowState = windowState;
    }

    public RowSelectionChangeNotification(RowSelectionChangeNotification rowSelectionChangeNotification) {
        if (rowSelectionChangeNotification.isSetWindowState()) {
            this.windowState = new WindowState(rowSelectionChangeNotification.windowState);
        }
    }

    public RowSelectionChangeNotification deepCopy() {
        return new RowSelectionChangeNotification(this);
    }

    public void clear() {
        this.windowState = null;
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

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetWindowState();
                    break;
                }
                this.setWindowState((WindowState)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getWindowState();
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
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof RowSelectionChangeNotification) {
            return this.equals((RowSelectionChangeNotification)object);
        }
        return false;
    }

    public boolean equals(RowSelectionChangeNotification rowSelectionChangeNotification) {
        if (rowSelectionChangeNotification == null) {
            return false;
        }
        if (this == rowSelectionChangeNotification) {
            return true;
        }
        boolean bl = this.isSetWindowState();
        boolean bl2 = rowSelectionChangeNotification.isSetWindowState();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.windowState.equals(rowSelectionChangeNotification.windowState)) {
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
        return n;
    }

    @Override
    public int compareTo(RowSelectionChangeNotification rowSelectionChangeNotification) {
        if (!this.getClass().equals(rowSelectionChangeNotification.getClass())) {
            return this.getClass().getName().compareTo(rowSelectionChangeNotification.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetWindowState(), rowSelectionChangeNotification.isSetWindowState());
        if (n != 0) {
            return n;
        }
        if (this.isSetWindowState() && (n = TBaseHelper.compareTo((Comparable)this.windowState, (Comparable)rowSelectionChangeNotification.windowState)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        RowSelectionChangeNotification.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        RowSelectionChangeNotification.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("RowSelectionChangeNotification(");
        boolean bl = true;
        stringBuilder.append("windowState:");
        if (this.windowState == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.windowState);
        }
        bl = false;
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void validate() throws TException {
        if (this.windowState != null) {
            this.windowState.validate();
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
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(RowSelectionChangeNotification.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        WINDOW_STATE(1, "windowState");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return WINDOW_STATE;
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

    private static class RowSelectionChangeNotificationStandardSchemeFactory
    implements SchemeFactory {
        private RowSelectionChangeNotificationStandardSchemeFactory() {
        }

        public RowSelectionChangeNotificationStandardScheme getScheme() {
            return new RowSelectionChangeNotificationStandardScheme();
        }
    }

    private static class RowSelectionChangeNotificationTupleSchemeFactory
    implements SchemeFactory {
        private RowSelectionChangeNotificationTupleSchemeFactory() {
        }

        public RowSelectionChangeNotificationTupleScheme getScheme() {
            return new RowSelectionChangeNotificationTupleScheme();
        }
    }

    private static class RowSelectionChangeNotificationTupleScheme
    extends TupleScheme<RowSelectionChangeNotification> {
        private RowSelectionChangeNotificationTupleScheme() {
        }

        public void write(TProtocol tProtocol, RowSelectionChangeNotification rowSelectionChangeNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (rowSelectionChangeNotification.isSetWindowState()) {
                bitSet.set(0);
            }
            tTupleProtocol.writeBitSet(bitSet, 1);
            if (rowSelectionChangeNotification.isSetWindowState()) {
                rowSelectionChangeNotification.windowState.write((TProtocol)tTupleProtocol);
            }
        }

        public void read(TProtocol tProtocol, RowSelectionChangeNotification rowSelectionChangeNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(1);
            if (bitSet.get(0)) {
                rowSelectionChangeNotification.windowState = new WindowState();
                rowSelectionChangeNotification.windowState.read((TProtocol)tTupleProtocol);
                rowSelectionChangeNotification.setWindowStateIsSet(true);
            }
        }
    }

    private static class RowSelectionChangeNotificationStandardScheme
    extends StandardScheme<RowSelectionChangeNotification> {
        private RowSelectionChangeNotificationStandardScheme() {
        }

        public void read(TProtocol tProtocol, RowSelectionChangeNotification rowSelectionChangeNotification) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 12) {
                            rowSelectionChangeNotification.windowState = new WindowState();
                            rowSelectionChangeNotification.windowState.read(tProtocol);
                            rowSelectionChangeNotification.setWindowStateIsSet(true);
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
            rowSelectionChangeNotification.validate();
        }

        public void write(TProtocol tProtocol, RowSelectionChangeNotification rowSelectionChangeNotification) throws TException {
            rowSelectionChangeNotification.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (rowSelectionChangeNotification.windowState != null) {
                tProtocol.writeFieldBegin(WINDOW_STATE_FIELD_DESC);
                rowSelectionChangeNotification.windowState.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

