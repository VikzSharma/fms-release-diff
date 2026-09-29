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

public class HierarchicalNames
implements TBase<HierarchicalNames, _Fields>,
Serializable,
Cloneable,
Comparable<HierarchicalNames> {
    private static final TStruct STRUCT_DESC = new TStruct("HierarchicalNames");
    private static final TField HIERARCHICAL_NAMES_XML_FIELD_DESC = new TField("hierarchicalNamesXml", 11, 1);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new HierarchicalNamesStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new HierarchicalNamesTupleSchemeFactory();
    @Nullable
    private String hierarchicalNamesXml;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public HierarchicalNames() {
    }

    public HierarchicalNames(String string) {
        this();
        this.hierarchicalNamesXml = string;
    }

    public HierarchicalNames(HierarchicalNames hierarchicalNames) {
        if (hierarchicalNames.isSetHierarchicalNamesXml()) {
            this.hierarchicalNamesXml = hierarchicalNames.hierarchicalNamesXml;
        }
    }

    public HierarchicalNames deepCopy() {
        return new HierarchicalNames(this);
    }

    public void clear() {
        this.hierarchicalNamesXml = null;
    }

    @Nullable
    public String getHierarchicalNamesXml() {
        return this.hierarchicalNamesXml;
    }

    public void setHierarchicalNamesXml(@Nullable String string) {
        this.hierarchicalNamesXml = string;
    }

    public void unsetHierarchicalNamesXml() {
        this.hierarchicalNamesXml = null;
    }

    public boolean isSetHierarchicalNamesXml() {
        return this.hierarchicalNamesXml != null;
    }

    public void setHierarchicalNamesXmlIsSet(boolean bl) {
        if (!bl) {
            this.hierarchicalNamesXml = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetHierarchicalNamesXml();
                    break;
                }
                this.setHierarchicalNamesXml((String)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getHierarchicalNamesXml();
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
                return this.isSetHierarchicalNamesXml();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof HierarchicalNames) {
            return this.equals((HierarchicalNames)object);
        }
        return false;
    }

    public boolean equals(HierarchicalNames hierarchicalNames) {
        if (hierarchicalNames == null) {
            return false;
        }
        if (this == hierarchicalNames) {
            return true;
        }
        boolean bl = this.isSetHierarchicalNamesXml();
        boolean bl2 = hierarchicalNames.isSetHierarchicalNamesXml();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.hierarchicalNamesXml.equals(hierarchicalNames.hierarchicalNamesXml)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetHierarchicalNamesXml() ? 131071 : 524287);
        if (this.isSetHierarchicalNamesXml()) {
            n = n * 8191 + this.hierarchicalNamesXml.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(HierarchicalNames hierarchicalNames) {
        if (!this.getClass().equals(hierarchicalNames.getClass())) {
            return this.getClass().getName().compareTo(hierarchicalNames.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetHierarchicalNamesXml(), hierarchicalNames.isSetHierarchicalNamesXml());
        if (n != 0) {
            return n;
        }
        if (this.isSetHierarchicalNamesXml() && (n = TBaseHelper.compareTo((String)this.hierarchicalNamesXml, (String)hierarchicalNames.hierarchicalNamesXml)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        HierarchicalNames.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        HierarchicalNames.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("HierarchicalNames(");
        boolean bl = true;
        stringBuilder.append("hierarchicalNamesXml:");
        if (this.hierarchicalNamesXml == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.hierarchicalNamesXml);
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
        enumMap.put(_Fields.HIERARCHICAL_NAMES_XML, new FieldMetaData("hierarchicalNamesXml", 3, new FieldValueMetaData(11)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(HierarchicalNames.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        HIERARCHICAL_NAMES_XML(1, "hierarchicalNamesXml");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return HIERARCHICAL_NAMES_XML;
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

    private static class HierarchicalNamesStandardSchemeFactory
    implements SchemeFactory {
        private HierarchicalNamesStandardSchemeFactory() {
        }

        public HierarchicalNamesStandardScheme getScheme() {
            return new HierarchicalNamesStandardScheme();
        }
    }

    private static class HierarchicalNamesTupleSchemeFactory
    implements SchemeFactory {
        private HierarchicalNamesTupleSchemeFactory() {
        }

        public HierarchicalNamesTupleScheme getScheme() {
            return new HierarchicalNamesTupleScheme();
        }
    }

    private static class HierarchicalNamesTupleScheme
    extends TupleScheme<HierarchicalNames> {
        private HierarchicalNamesTupleScheme() {
        }

        public void write(TProtocol tProtocol, HierarchicalNames hierarchicalNames) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (hierarchicalNames.isSetHierarchicalNamesXml()) {
                bitSet.set(0);
            }
            tTupleProtocol.writeBitSet(bitSet, 1);
            if (hierarchicalNames.isSetHierarchicalNamesXml()) {
                tTupleProtocol.writeString(hierarchicalNames.hierarchicalNamesXml);
            }
        }

        public void read(TProtocol tProtocol, HierarchicalNames hierarchicalNames) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(1);
            if (bitSet.get(0)) {
                hierarchicalNames.hierarchicalNamesXml = tTupleProtocol.readString();
                hierarchicalNames.setHierarchicalNamesXmlIsSet(true);
            }
        }
    }

    private static class HierarchicalNamesStandardScheme
    extends StandardScheme<HierarchicalNames> {
        private HierarchicalNamesStandardScheme() {
        }

        public void read(TProtocol tProtocol, HierarchicalNames hierarchicalNames) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 11) {
                            hierarchicalNames.hierarchicalNamesXml = tProtocol.readString();
                            hierarchicalNames.setHierarchicalNamesXmlIsSet(true);
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
            hierarchicalNames.validate();
        }

        public void write(TProtocol tProtocol, HierarchicalNames hierarchicalNames) throws TException {
            hierarchicalNames.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (hierarchicalNames.hierarchicalNamesXml != null) {
                tProtocol.writeFieldBegin(HIERARCHICAL_NAMES_XML_FIELD_DESC);
                tProtocol.writeString(hierarchicalNames.hierarchicalNamesXml);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

