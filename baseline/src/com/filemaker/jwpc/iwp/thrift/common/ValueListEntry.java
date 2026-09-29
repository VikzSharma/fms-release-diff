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

public class ValueListEntry
implements TBase<ValueListEntry, _Fields>,
Serializable,
Cloneable,
Comparable<ValueListEntry> {
    private static final TStruct STRUCT_DESC = new TStruct("ValueListEntry");
    private static final TField STORED_FIELD_DESC = new TField("stored", 11, 1);
    private static final TField DISPLAYED_FIELD_DESC = new TField("displayed", 11, 2);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new ValueListEntryStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new ValueListEntryTupleSchemeFactory();
    @Nullable
    private String stored;
    @Nullable
    private String displayed;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public ValueListEntry() {
    }

    public ValueListEntry(String string, String string2) {
        this();
        this.stored = string;
        this.displayed = string2;
    }

    public ValueListEntry(ValueListEntry valueListEntry) {
        if (valueListEntry.isSetStored()) {
            this.stored = valueListEntry.stored;
        }
        if (valueListEntry.isSetDisplayed()) {
            this.displayed = valueListEntry.displayed;
        }
    }

    public ValueListEntry deepCopy() {
        return new ValueListEntry(this);
    }

    public void clear() {
        this.stored = null;
        this.displayed = null;
    }

    @Nullable
    public String getStored() {
        return this.stored;
    }

    public void setStored(@Nullable String string) {
        this.stored = string;
    }

    public void unsetStored() {
        this.stored = null;
    }

    public boolean isSetStored() {
        return this.stored != null;
    }

    public void setStoredIsSet(boolean bl) {
        if (!bl) {
            this.stored = null;
        }
    }

    @Nullable
    public String getDisplayed() {
        return this.displayed;
    }

    public void setDisplayed(@Nullable String string) {
        this.displayed = string;
    }

    public void unsetDisplayed() {
        this.displayed = null;
    }

    public boolean isSetDisplayed() {
        return this.displayed != null;
    }

    public void setDisplayedIsSet(boolean bl) {
        if (!bl) {
            this.displayed = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetStored();
                    break;
                }
                this.setStored((String)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetDisplayed();
                    break;
                }
                this.setDisplayed((String)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getStored();
            }
            case 1: {
                return this.getDisplayed();
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
                return this.isSetStored();
            }
            case 1: {
                return this.isSetDisplayed();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof ValueListEntry) {
            return this.equals((ValueListEntry)object);
        }
        return false;
    }

    public boolean equals(ValueListEntry valueListEntry) {
        if (valueListEntry == null) {
            return false;
        }
        if (this == valueListEntry) {
            return true;
        }
        boolean bl = this.isSetStored();
        boolean bl2 = valueListEntry.isSetStored();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.stored.equals(valueListEntry.stored)) {
                return false;
            }
        }
        boolean bl3 = this.isSetDisplayed();
        boolean bl4 = valueListEntry.isSetDisplayed();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.displayed.equals(valueListEntry.displayed)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetStored() ? 131071 : 524287);
        if (this.isSetStored()) {
            n = n * 8191 + this.stored.hashCode();
        }
        n = n * 8191 + (this.isSetDisplayed() ? 131071 : 524287);
        if (this.isSetDisplayed()) {
            n = n * 8191 + this.displayed.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(ValueListEntry valueListEntry) {
        if (!this.getClass().equals(valueListEntry.getClass())) {
            return this.getClass().getName().compareTo(valueListEntry.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetStored(), valueListEntry.isSetStored());
        if (n != 0) {
            return n;
        }
        if (this.isSetStored() && (n = TBaseHelper.compareTo((String)this.stored, (String)valueListEntry.stored)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetDisplayed(), valueListEntry.isSetDisplayed());
        if (n != 0) {
            return n;
        }
        if (this.isSetDisplayed() && (n = TBaseHelper.compareTo((String)this.displayed, (String)valueListEntry.displayed)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        ValueListEntry.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        ValueListEntry.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ValueListEntry(");
        boolean bl = true;
        stringBuilder.append("stored:");
        if (this.stored == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.stored);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("displayed:");
        if (this.displayed == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.displayed);
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
        enumMap.put(_Fields.STORED, new FieldMetaData("stored", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.DISPLAYED, new FieldMetaData("displayed", 3, new FieldValueMetaData(11)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(ValueListEntry.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        STORED(1, "stored"),
        DISPLAYED(2, "displayed");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return STORED;
                }
                case 2: {
                    return DISPLAYED;
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

    private static class ValueListEntryStandardSchemeFactory
    implements SchemeFactory {
        private ValueListEntryStandardSchemeFactory() {
        }

        public ValueListEntryStandardScheme getScheme() {
            return new ValueListEntryStandardScheme();
        }
    }

    private static class ValueListEntryTupleSchemeFactory
    implements SchemeFactory {
        private ValueListEntryTupleSchemeFactory() {
        }

        public ValueListEntryTupleScheme getScheme() {
            return new ValueListEntryTupleScheme();
        }
    }

    private static class ValueListEntryTupleScheme
    extends TupleScheme<ValueListEntry> {
        private ValueListEntryTupleScheme() {
        }

        public void write(TProtocol tProtocol, ValueListEntry valueListEntry) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (valueListEntry.isSetStored()) {
                bitSet.set(0);
            }
            if (valueListEntry.isSetDisplayed()) {
                bitSet.set(1);
            }
            tTupleProtocol.writeBitSet(bitSet, 2);
            if (valueListEntry.isSetStored()) {
                tTupleProtocol.writeString(valueListEntry.stored);
            }
            if (valueListEntry.isSetDisplayed()) {
                tTupleProtocol.writeString(valueListEntry.displayed);
            }
        }

        public void read(TProtocol tProtocol, ValueListEntry valueListEntry) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(2);
            if (bitSet.get(0)) {
                valueListEntry.stored = tTupleProtocol.readString();
                valueListEntry.setStoredIsSet(true);
            }
            if (bitSet.get(1)) {
                valueListEntry.displayed = tTupleProtocol.readString();
                valueListEntry.setDisplayedIsSet(true);
            }
        }
    }

    private static class ValueListEntryStandardScheme
    extends StandardScheme<ValueListEntry> {
        private ValueListEntryStandardScheme() {
        }

        public void read(TProtocol tProtocol, ValueListEntry valueListEntry) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 11) {
                            valueListEntry.stored = tProtocol.readString();
                            valueListEntry.setStoredIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 11) {
                            valueListEntry.displayed = tProtocol.readString();
                            valueListEntry.setDisplayedIsSet(true);
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
            valueListEntry.validate();
        }

        public void write(TProtocol tProtocol, ValueListEntry valueListEntry) throws TException {
            valueListEntry.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (valueListEntry.stored != null) {
                tProtocol.writeFieldBegin(STORED_FIELD_DESC);
                tProtocol.writeString(valueListEntry.stored);
                tProtocol.writeFieldEnd();
            }
            if (valueListEntry.displayed != null) {
                tProtocol.writeFieldBegin(DISPLAYED_FIELD_DESC);
                tProtocol.writeString(valueListEntry.displayed);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

