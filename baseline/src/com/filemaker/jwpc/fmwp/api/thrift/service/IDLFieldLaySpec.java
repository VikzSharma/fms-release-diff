/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
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
package com.filemaker.jwpc.fmwp.api.thrift.service;

import com.filemaker.jwpc.fmwp.api.thrift.service.DisplayType;
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

public class IDLFieldLaySpec
implements TBase<IDLFieldLaySpec, _Fields>,
Serializable,
Cloneable,
Comparable<IDLFieldLaySpec> {
    private static final TStruct STRUCT_DESC = new TStruct("IDLFieldLaySpec");
    private static final TField NAME_FIELD_DESC = new TField("name", 11, 1);
    private static final TField DISPLAY_TYPE_FIELD_DESC = new TField("displayType", 8, 2);
    private static final TField VALUE_LIST_FIELD_DESC = new TField("valueList", 11, 3);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new IDLFieldLaySpecStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new IDLFieldLaySpecTupleSchemeFactory();
    @Nullable
    private String name;
    @Nullable
    private DisplayType displayType;
    @Nullable
    private String valueList;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public IDLFieldLaySpec() {
    }

    public IDLFieldLaySpec(String string, DisplayType displayType, String string2) {
        this();
        this.name = string;
        this.displayType = displayType;
        this.valueList = string2;
    }

    public IDLFieldLaySpec(IDLFieldLaySpec iDLFieldLaySpec) {
        if (iDLFieldLaySpec.isSetName()) {
            this.name = iDLFieldLaySpec.name;
        }
        if (iDLFieldLaySpec.isSetDisplayType()) {
            this.displayType = iDLFieldLaySpec.displayType;
        }
        if (iDLFieldLaySpec.isSetValueList()) {
            this.valueList = iDLFieldLaySpec.valueList;
        }
    }

    public IDLFieldLaySpec deepCopy() {
        return new IDLFieldLaySpec(this);
    }

    public void clear() {
        this.name = null;
        this.displayType = null;
        this.valueList = null;
    }

    @Nullable
    public String getName() {
        return this.name;
    }

    public void setName(@Nullable String string) {
        this.name = string;
    }

    public void unsetName() {
        this.name = null;
    }

    public boolean isSetName() {
        return this.name != null;
    }

    public void setNameIsSet(boolean bl) {
        if (!bl) {
            this.name = null;
        }
    }

    @Nullable
    public DisplayType getDisplayType() {
        return this.displayType;
    }

    public void setDisplayType(@Nullable DisplayType displayType) {
        this.displayType = displayType;
    }

    public void unsetDisplayType() {
        this.displayType = null;
    }

    public boolean isSetDisplayType() {
        return this.displayType != null;
    }

    public void setDisplayTypeIsSet(boolean bl) {
        if (!bl) {
            this.displayType = null;
        }
    }

    @Nullable
    public String getValueList() {
        return this.valueList;
    }

    public void setValueList(@Nullable String string) {
        this.valueList = string;
    }

    public void unsetValueList() {
        this.valueList = null;
    }

    public boolean isSetValueList() {
        return this.valueList != null;
    }

    public void setValueListIsSet(boolean bl) {
        if (!bl) {
            this.valueList = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetName();
                    break;
                }
                this.setName((String)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetDisplayType();
                    break;
                }
                this.setDisplayType((DisplayType)((Object)object));
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetValueList();
                    break;
                }
                this.setValueList((String)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getName();
            }
            case 1: {
                return this.getDisplayType();
            }
            case 2: {
                return this.getValueList();
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
                return this.isSetName();
            }
            case 1: {
                return this.isSetDisplayType();
            }
            case 2: {
                return this.isSetValueList();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof IDLFieldLaySpec) {
            return this.equals((IDLFieldLaySpec)object);
        }
        return false;
    }

    public boolean equals(IDLFieldLaySpec iDLFieldLaySpec) {
        if (iDLFieldLaySpec == null) {
            return false;
        }
        if (this == iDLFieldLaySpec) {
            return true;
        }
        boolean bl = this.isSetName();
        boolean bl2 = iDLFieldLaySpec.isSetName();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.name.equals(iDLFieldLaySpec.name)) {
                return false;
            }
        }
        boolean bl3 = this.isSetDisplayType();
        boolean bl4 = iDLFieldLaySpec.isSetDisplayType();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.displayType.equals((Object)iDLFieldLaySpec.displayType)) {
                return false;
            }
        }
        boolean bl5 = this.isSetValueList();
        boolean bl6 = iDLFieldLaySpec.isSetValueList();
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (!this.valueList.equals(iDLFieldLaySpec.valueList)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetName() ? 131071 : 524287);
        if (this.isSetName()) {
            n = n * 8191 + this.name.hashCode();
        }
        n = n * 8191 + (this.isSetDisplayType() ? 131071 : 524287);
        if (this.isSetDisplayType()) {
            n = n * 8191 + this.displayType.getValue();
        }
        n = n * 8191 + (this.isSetValueList() ? 131071 : 524287);
        if (this.isSetValueList()) {
            n = n * 8191 + this.valueList.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(IDLFieldLaySpec iDLFieldLaySpec) {
        if (!this.getClass().equals(iDLFieldLaySpec.getClass())) {
            return this.getClass().getName().compareTo(iDLFieldLaySpec.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetName(), iDLFieldLaySpec.isSetName());
        if (n != 0) {
            return n;
        }
        if (this.isSetName() && (n = TBaseHelper.compareTo((String)this.name, (String)iDLFieldLaySpec.name)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetDisplayType(), iDLFieldLaySpec.isSetDisplayType());
        if (n != 0) {
            return n;
        }
        if (this.isSetDisplayType() && (n = TBaseHelper.compareTo((Comparable)((Object)this.displayType), (Comparable)((Object)iDLFieldLaySpec.displayType))) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetValueList(), iDLFieldLaySpec.isSetValueList());
        if (n != 0) {
            return n;
        }
        if (this.isSetValueList() && (n = TBaseHelper.compareTo((String)this.valueList, (String)iDLFieldLaySpec.valueList)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        IDLFieldLaySpec.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        IDLFieldLaySpec.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("IDLFieldLaySpec(");
        boolean bl = true;
        stringBuilder.append("name:");
        if (this.name == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.name);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("displayType:");
        if (this.displayType == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append((Object)this.displayType);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("valueList:");
        if (this.valueList == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.valueList);
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
        enumMap.put(_Fields.NAME, new FieldMetaData("name", 3, new FieldValueMetaData(11)));
        enumMap.put(_Fields.DISPLAY_TYPE, new FieldMetaData("displayType", 3, (FieldValueMetaData)new EnumMetaData(-1, DisplayType.class)));
        enumMap.put(_Fields.VALUE_LIST, new FieldMetaData("valueList", 3, new FieldValueMetaData(11)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(IDLFieldLaySpec.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        NAME(1, "name"),
        DISPLAY_TYPE(2, "displayType"),
        VALUE_LIST(3, "valueList");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return NAME;
                }
                case 2: {
                    return DISPLAY_TYPE;
                }
                case 3: {
                    return VALUE_LIST;
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

    private static class IDLFieldLaySpecStandardSchemeFactory
    implements SchemeFactory {
        private IDLFieldLaySpecStandardSchemeFactory() {
        }

        public IDLFieldLaySpecStandardScheme getScheme() {
            return new IDLFieldLaySpecStandardScheme();
        }
    }

    private static class IDLFieldLaySpecTupleSchemeFactory
    implements SchemeFactory {
        private IDLFieldLaySpecTupleSchemeFactory() {
        }

        public IDLFieldLaySpecTupleScheme getScheme() {
            return new IDLFieldLaySpecTupleScheme();
        }
    }

    private static class IDLFieldLaySpecTupleScheme
    extends TupleScheme<IDLFieldLaySpec> {
        private IDLFieldLaySpecTupleScheme() {
        }

        public void write(TProtocol tProtocol, IDLFieldLaySpec iDLFieldLaySpec) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (iDLFieldLaySpec.isSetName()) {
                bitSet.set(0);
            }
            if (iDLFieldLaySpec.isSetDisplayType()) {
                bitSet.set(1);
            }
            if (iDLFieldLaySpec.isSetValueList()) {
                bitSet.set(2);
            }
            tTupleProtocol.writeBitSet(bitSet, 3);
            if (iDLFieldLaySpec.isSetName()) {
                tTupleProtocol.writeString(iDLFieldLaySpec.name);
            }
            if (iDLFieldLaySpec.isSetDisplayType()) {
                tTupleProtocol.writeI32(iDLFieldLaySpec.displayType.getValue());
            }
            if (iDLFieldLaySpec.isSetValueList()) {
                tTupleProtocol.writeString(iDLFieldLaySpec.valueList);
            }
        }

        public void read(TProtocol tProtocol, IDLFieldLaySpec iDLFieldLaySpec) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(3);
            if (bitSet.get(0)) {
                iDLFieldLaySpec.name = tTupleProtocol.readString();
                iDLFieldLaySpec.setNameIsSet(true);
            }
            if (bitSet.get(1)) {
                iDLFieldLaySpec.displayType = DisplayType.findByValue(tTupleProtocol.readI32());
                iDLFieldLaySpec.setDisplayTypeIsSet(true);
            }
            if (bitSet.get(2)) {
                iDLFieldLaySpec.valueList = tTupleProtocol.readString();
                iDLFieldLaySpec.setValueListIsSet(true);
            }
        }
    }

    private static class IDLFieldLaySpecStandardScheme
    extends StandardScheme<IDLFieldLaySpec> {
        private IDLFieldLaySpecStandardScheme() {
        }

        public void read(TProtocol tProtocol, IDLFieldLaySpec iDLFieldLaySpec) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 11) {
                            iDLFieldLaySpec.name = tProtocol.readString();
                            iDLFieldLaySpec.setNameIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 8) {
                            iDLFieldLaySpec.displayType = DisplayType.findByValue(tProtocol.readI32());
                            iDLFieldLaySpec.setDisplayTypeIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 11) {
                            iDLFieldLaySpec.valueList = tProtocol.readString();
                            iDLFieldLaySpec.setValueListIsSet(true);
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
            iDLFieldLaySpec.validate();
        }

        public void write(TProtocol tProtocol, IDLFieldLaySpec iDLFieldLaySpec) throws TException {
            iDLFieldLaySpec.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (iDLFieldLaySpec.name != null) {
                tProtocol.writeFieldBegin(NAME_FIELD_DESC);
                tProtocol.writeString(iDLFieldLaySpec.name);
                tProtocol.writeFieldEnd();
            }
            if (iDLFieldLaySpec.displayType != null) {
                tProtocol.writeFieldBegin(DISPLAY_TYPE_FIELD_DESC);
                tProtocol.writeI32(iDLFieldLaySpec.displayType.getValue());
                tProtocol.writeFieldEnd();
            }
            if (iDLFieldLaySpec.valueList != null) {
                tProtocol.writeFieldBegin(VALUE_LIST_FIELD_DESC);
                tProtocol.writeString(iDLFieldLaySpec.valueList);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

