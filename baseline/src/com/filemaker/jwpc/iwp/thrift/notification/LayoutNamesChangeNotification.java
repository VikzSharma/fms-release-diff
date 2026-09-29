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

public class LayoutNamesChangeNotification
implements TBase<LayoutNamesChangeNotification, _Fields>,
Serializable,
Cloneable,
Comparable<LayoutNamesChangeNotification> {
    private static final TStruct STRUCT_DESC = new TStruct("LayoutNamesChangeNotification");
    private static final TField LAYOUT_NAMES_FIELD_DESC = new TField("layoutNames", 12, 1);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new LayoutNamesChangeNotificationStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new LayoutNamesChangeNotificationTupleSchemeFactory();
    @Nullable
    private HierarchicalNames layoutNames;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public LayoutNamesChangeNotification() {
    }

    public LayoutNamesChangeNotification(HierarchicalNames hierarchicalNames) {
        this();
        this.layoutNames = hierarchicalNames;
    }

    public LayoutNamesChangeNotification(LayoutNamesChangeNotification layoutNamesChangeNotification) {
        if (layoutNamesChangeNotification.isSetLayoutNames()) {
            this.layoutNames = new HierarchicalNames(layoutNamesChangeNotification.layoutNames);
        }
    }

    public LayoutNamesChangeNotification deepCopy() {
        return new LayoutNamesChangeNotification(this);
    }

    public void clear() {
        this.layoutNames = null;
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

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetLayoutNames();
                    break;
                }
                this.setLayoutNames((HierarchicalNames)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getLayoutNames();
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
                return this.isSetLayoutNames();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof LayoutNamesChangeNotification) {
            return this.equals((LayoutNamesChangeNotification)object);
        }
        return false;
    }

    public boolean equals(LayoutNamesChangeNotification layoutNamesChangeNotification) {
        if (layoutNamesChangeNotification == null) {
            return false;
        }
        if (this == layoutNamesChangeNotification) {
            return true;
        }
        boolean bl = this.isSetLayoutNames();
        boolean bl2 = layoutNamesChangeNotification.isSetLayoutNames();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.layoutNames.equals(layoutNamesChangeNotification.layoutNames)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetLayoutNames() ? 131071 : 524287);
        if (this.isSetLayoutNames()) {
            n = n * 8191 + this.layoutNames.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(LayoutNamesChangeNotification layoutNamesChangeNotification) {
        if (!this.getClass().equals(layoutNamesChangeNotification.getClass())) {
            return this.getClass().getName().compareTo(layoutNamesChangeNotification.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetLayoutNames(), layoutNamesChangeNotification.isSetLayoutNames());
        if (n != 0) {
            return n;
        }
        if (this.isSetLayoutNames() && (n = TBaseHelper.compareTo((Comparable)this.layoutNames, (Comparable)layoutNamesChangeNotification.layoutNames)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        LayoutNamesChangeNotification.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        LayoutNamesChangeNotification.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("LayoutNamesChangeNotification(");
        boolean bl = true;
        stringBuilder.append("layoutNames:");
        if (this.layoutNames == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.layoutNames);
        }
        bl = false;
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void validate() throws TException {
        if (this.layoutNames != null) {
            this.layoutNames.validate();
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
        enumMap.put(_Fields.LAYOUT_NAMES, new FieldMetaData("layoutNames", 3, (FieldValueMetaData)new StructMetaData(12, HierarchicalNames.class)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(LayoutNamesChangeNotification.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        LAYOUT_NAMES(1, "layoutNames");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return LAYOUT_NAMES;
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

    private static class LayoutNamesChangeNotificationStandardSchemeFactory
    implements SchemeFactory {
        private LayoutNamesChangeNotificationStandardSchemeFactory() {
        }

        public LayoutNamesChangeNotificationStandardScheme getScheme() {
            return new LayoutNamesChangeNotificationStandardScheme();
        }
    }

    private static class LayoutNamesChangeNotificationTupleSchemeFactory
    implements SchemeFactory {
        private LayoutNamesChangeNotificationTupleSchemeFactory() {
        }

        public LayoutNamesChangeNotificationTupleScheme getScheme() {
            return new LayoutNamesChangeNotificationTupleScheme();
        }
    }

    private static class LayoutNamesChangeNotificationTupleScheme
    extends TupleScheme<LayoutNamesChangeNotification> {
        private LayoutNamesChangeNotificationTupleScheme() {
        }

        public void write(TProtocol tProtocol, LayoutNamesChangeNotification layoutNamesChangeNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (layoutNamesChangeNotification.isSetLayoutNames()) {
                bitSet.set(0);
            }
            tTupleProtocol.writeBitSet(bitSet, 1);
            if (layoutNamesChangeNotification.isSetLayoutNames()) {
                layoutNamesChangeNotification.layoutNames.write((TProtocol)tTupleProtocol);
            }
        }

        public void read(TProtocol tProtocol, LayoutNamesChangeNotification layoutNamesChangeNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(1);
            if (bitSet.get(0)) {
                layoutNamesChangeNotification.layoutNames = new HierarchicalNames();
                layoutNamesChangeNotification.layoutNames.read((TProtocol)tTupleProtocol);
                layoutNamesChangeNotification.setLayoutNamesIsSet(true);
            }
        }
    }

    private static class LayoutNamesChangeNotificationStandardScheme
    extends StandardScheme<LayoutNamesChangeNotification> {
        private LayoutNamesChangeNotificationStandardScheme() {
        }

        public void read(TProtocol tProtocol, LayoutNamesChangeNotification layoutNamesChangeNotification) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 12) {
                            layoutNamesChangeNotification.layoutNames = new HierarchicalNames();
                            layoutNamesChangeNotification.layoutNames.read(tProtocol);
                            layoutNamesChangeNotification.setLayoutNamesIsSet(true);
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
            layoutNamesChangeNotification.validate();
        }

        public void write(TProtocol tProtocol, LayoutNamesChangeNotification layoutNamesChangeNotification) throws TException {
            layoutNamesChangeNotification.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (layoutNamesChangeNotification.layoutNames != null) {
                tProtocol.writeFieldBegin(LAYOUT_NAMES_FIELD_DESC);
                layoutNamesChangeNotification.layoutNames.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

