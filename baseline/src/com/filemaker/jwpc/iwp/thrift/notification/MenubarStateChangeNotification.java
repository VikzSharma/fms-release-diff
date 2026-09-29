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

public class MenubarStateChangeNotification
implements TBase<MenubarStateChangeNotification, _Fields>,
Serializable,
Cloneable,
Comparable<MenubarStateChangeNotification> {
    private static final TStruct STRUCT_DESC = new TStruct("MenubarStateChangeNotification");
    private static final TField VISIBLE_FIELD_DESC = new TField("visible", 2, 1);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new MenubarStateChangeNotificationStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new MenubarStateChangeNotificationTupleSchemeFactory();
    private boolean visible;
    private static final int __VISIBLE_ISSET_ID = 0;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public MenubarStateChangeNotification() {
    }

    public MenubarStateChangeNotification(boolean bl) {
        this();
        this.visible = bl;
        this.setVisibleIsSet(true);
    }

    public MenubarStateChangeNotification(MenubarStateChangeNotification menubarStateChangeNotification) {
        this.__isset_bitfield = menubarStateChangeNotification.__isset_bitfield;
        this.visible = menubarStateChangeNotification.visible;
    }

    public MenubarStateChangeNotification deepCopy() {
        return new MenubarStateChangeNotification(this);
    }

    public void clear() {
        this.setVisibleIsSet(false);
        this.visible = false;
    }

    public boolean isVisible() {
        return this.visible;
    }

    public void setVisible(boolean bl) {
        this.visible = bl;
        this.setVisibleIsSet(true);
    }

    public void unsetVisible() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetVisible() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setVisibleIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetVisible();
                    break;
                }
                this.setVisible((Boolean)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.isVisible();
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
                return this.isSetVisible();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof MenubarStateChangeNotification) {
            return this.equals((MenubarStateChangeNotification)object);
        }
        return false;
    }

    public boolean equals(MenubarStateChangeNotification menubarStateChangeNotification) {
        if (menubarStateChangeNotification == null) {
            return false;
        }
        if (this == menubarStateChangeNotification) {
            return true;
        }
        boolean bl = true;
        boolean bl2 = true;
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (this.visible != menubarStateChangeNotification.visible) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.visible ? 131071 : 524287);
        return n;
    }

    @Override
    public int compareTo(MenubarStateChangeNotification menubarStateChangeNotification) {
        if (!this.getClass().equals(menubarStateChangeNotification.getClass())) {
            return this.getClass().getName().compareTo(menubarStateChangeNotification.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetVisible(), menubarStateChangeNotification.isSetVisible());
        if (n != 0) {
            return n;
        }
        if (this.isSetVisible() && (n = TBaseHelper.compareTo((boolean)this.visible, (boolean)menubarStateChangeNotification.visible)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        MenubarStateChangeNotification.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        MenubarStateChangeNotification.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("MenubarStateChangeNotification(");
        boolean bl = true;
        stringBuilder.append("visible:");
        stringBuilder.append(this.visible);
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
        enumMap.put(_Fields.VISIBLE, new FieldMetaData("visible", 3, new FieldValueMetaData(2)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(MenubarStateChangeNotification.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        VISIBLE(1, "visible");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return VISIBLE;
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

    private static class MenubarStateChangeNotificationStandardSchemeFactory
    implements SchemeFactory {
        private MenubarStateChangeNotificationStandardSchemeFactory() {
        }

        public MenubarStateChangeNotificationStandardScheme getScheme() {
            return new MenubarStateChangeNotificationStandardScheme();
        }
    }

    private static class MenubarStateChangeNotificationTupleSchemeFactory
    implements SchemeFactory {
        private MenubarStateChangeNotificationTupleSchemeFactory() {
        }

        public MenubarStateChangeNotificationTupleScheme getScheme() {
            return new MenubarStateChangeNotificationTupleScheme();
        }
    }

    private static class MenubarStateChangeNotificationTupleScheme
    extends TupleScheme<MenubarStateChangeNotification> {
        private MenubarStateChangeNotificationTupleScheme() {
        }

        public void write(TProtocol tProtocol, MenubarStateChangeNotification menubarStateChangeNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (menubarStateChangeNotification.isSetVisible()) {
                bitSet.set(0);
            }
            tTupleProtocol.writeBitSet(bitSet, 1);
            if (menubarStateChangeNotification.isSetVisible()) {
                tTupleProtocol.writeBool(menubarStateChangeNotification.visible);
            }
        }

        public void read(TProtocol tProtocol, MenubarStateChangeNotification menubarStateChangeNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(1);
            if (bitSet.get(0)) {
                menubarStateChangeNotification.visible = tTupleProtocol.readBool();
                menubarStateChangeNotification.setVisibleIsSet(true);
            }
        }
    }

    private static class MenubarStateChangeNotificationStandardScheme
    extends StandardScheme<MenubarStateChangeNotification> {
        private MenubarStateChangeNotificationStandardScheme() {
        }

        public void read(TProtocol tProtocol, MenubarStateChangeNotification menubarStateChangeNotification) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 2) {
                            menubarStateChangeNotification.visible = tProtocol.readBool();
                            menubarStateChangeNotification.setVisibleIsSet(true);
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
            menubarStateChangeNotification.validate();
        }

        public void write(TProtocol tProtocol, MenubarStateChangeNotification menubarStateChangeNotification) throws TException {
            menubarStateChangeNotification.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            tProtocol.writeFieldBegin(VISIBLE_FIELD_DESC);
            tProtocol.writeBool(menubarStateChangeNotification.visible);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

