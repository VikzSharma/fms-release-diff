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

public class WindowNameChangeNotification
implements TBase<WindowNameChangeNotification, _Fields>,
Serializable,
Cloneable,
Comparable<WindowNameChangeNotification> {
    private static final TStruct STRUCT_DESC = new TStruct("WindowNameChangeNotification");
    private static final TField WINDOW_NAME_FIELD_DESC = new TField("windowName", 11, 1);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new WindowNameChangeNotificationStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new WindowNameChangeNotificationTupleSchemeFactory();
    @Nullable
    private String windowName;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public WindowNameChangeNotification() {
    }

    public WindowNameChangeNotification(String string) {
        this();
        this.windowName = string;
    }

    public WindowNameChangeNotification(WindowNameChangeNotification windowNameChangeNotification) {
        if (windowNameChangeNotification.isSetWindowName()) {
            this.windowName = windowNameChangeNotification.windowName;
        }
    }

    public WindowNameChangeNotification deepCopy() {
        return new WindowNameChangeNotification(this);
    }

    public void clear() {
        this.windowName = null;
    }

    @Nullable
    public String getWindowName() {
        return this.windowName;
    }

    public void setWindowName(@Nullable String string) {
        this.windowName = string;
    }

    public void unsetWindowName() {
        this.windowName = null;
    }

    public boolean isSetWindowName() {
        return this.windowName != null;
    }

    public void setWindowNameIsSet(boolean bl) {
        if (!bl) {
            this.windowName = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetWindowName();
                    break;
                }
                this.setWindowName((String)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getWindowName();
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
                return this.isSetWindowName();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof WindowNameChangeNotification) {
            return this.equals((WindowNameChangeNotification)object);
        }
        return false;
    }

    public boolean equals(WindowNameChangeNotification windowNameChangeNotification) {
        if (windowNameChangeNotification == null) {
            return false;
        }
        if (this == windowNameChangeNotification) {
            return true;
        }
        boolean bl = this.isSetWindowName();
        boolean bl2 = windowNameChangeNotification.isSetWindowName();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.windowName.equals(windowNameChangeNotification.windowName)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetWindowName() ? 131071 : 524287);
        if (this.isSetWindowName()) {
            n = n * 8191 + this.windowName.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(WindowNameChangeNotification windowNameChangeNotification) {
        if (!this.getClass().equals(windowNameChangeNotification.getClass())) {
            return this.getClass().getName().compareTo(windowNameChangeNotification.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetWindowName(), windowNameChangeNotification.isSetWindowName());
        if (n != 0) {
            return n;
        }
        if (this.isSetWindowName() && (n = TBaseHelper.compareTo((String)this.windowName, (String)windowNameChangeNotification.windowName)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        WindowNameChangeNotification.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        WindowNameChangeNotification.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("WindowNameChangeNotification(");
        boolean bl = true;
        stringBuilder.append("windowName:");
        if (this.windowName == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.windowName);
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
        enumMap.put(_Fields.WINDOW_NAME, new FieldMetaData("windowName", 3, new FieldValueMetaData(11)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(WindowNameChangeNotification.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        WINDOW_NAME(1, "windowName");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return WINDOW_NAME;
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

    private static class WindowNameChangeNotificationStandardSchemeFactory
    implements SchemeFactory {
        private WindowNameChangeNotificationStandardSchemeFactory() {
        }

        public WindowNameChangeNotificationStandardScheme getScheme() {
            return new WindowNameChangeNotificationStandardScheme();
        }
    }

    private static class WindowNameChangeNotificationTupleSchemeFactory
    implements SchemeFactory {
        private WindowNameChangeNotificationTupleSchemeFactory() {
        }

        public WindowNameChangeNotificationTupleScheme getScheme() {
            return new WindowNameChangeNotificationTupleScheme();
        }
    }

    private static class WindowNameChangeNotificationTupleScheme
    extends TupleScheme<WindowNameChangeNotification> {
        private WindowNameChangeNotificationTupleScheme() {
        }

        public void write(TProtocol tProtocol, WindowNameChangeNotification windowNameChangeNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (windowNameChangeNotification.isSetWindowName()) {
                bitSet.set(0);
            }
            tTupleProtocol.writeBitSet(bitSet, 1);
            if (windowNameChangeNotification.isSetWindowName()) {
                tTupleProtocol.writeString(windowNameChangeNotification.windowName);
            }
        }

        public void read(TProtocol tProtocol, WindowNameChangeNotification windowNameChangeNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(1);
            if (bitSet.get(0)) {
                windowNameChangeNotification.windowName = tTupleProtocol.readString();
                windowNameChangeNotification.setWindowNameIsSet(true);
            }
        }
    }

    private static class WindowNameChangeNotificationStandardScheme
    extends StandardScheme<WindowNameChangeNotification> {
        private WindowNameChangeNotificationStandardScheme() {
        }

        public void read(TProtocol tProtocol, WindowNameChangeNotification windowNameChangeNotification) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 11) {
                            windowNameChangeNotification.windowName = tProtocol.readString();
                            windowNameChangeNotification.setWindowNameIsSet(true);
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
            windowNameChangeNotification.validate();
        }

        public void write(TProtocol tProtocol, WindowNameChangeNotification windowNameChangeNotification) throws TException {
            windowNameChangeNotification.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (windowNameChangeNotification.windowName != null) {
                tProtocol.writeFieldBegin(WINDOW_NAME_FIELD_DESC);
                tProtocol.writeString(windowNameChangeNotification.windowName);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

