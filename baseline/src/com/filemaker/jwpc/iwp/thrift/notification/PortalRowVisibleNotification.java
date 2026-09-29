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
 *  org.apache.thrift.meta_data.ListMetaData
 *  org.apache.thrift.meta_data.StructMetaData
 *  org.apache.thrift.protocol.TCompactProtocol
 *  org.apache.thrift.protocol.TField
 *  org.apache.thrift.protocol.TList
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

import com.filemaker.jwpc.iwp.thrift.common.ObjectSpec;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.thrift.TBase;
import org.apache.thrift.TBaseHelper;
import org.apache.thrift.TException;
import org.apache.thrift.TFieldIdEnum;
import org.apache.thrift.annotation.Nullable;
import org.apache.thrift.meta_data.FieldMetaData;
import org.apache.thrift.meta_data.FieldValueMetaData;
import org.apache.thrift.meta_data.ListMetaData;
import org.apache.thrift.meta_data.StructMetaData;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TList;
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

public class PortalRowVisibleNotification
implements TBase<PortalRowVisibleNotification, _Fields>,
Serializable,
Cloneable,
Comparable<PortalRowVisibleNotification> {
    private static final TStruct STRUCT_DESC = new TStruct("PortalRowVisibleNotification");
    private static final TField ROW_OBJECT_SPECS_FIELD_DESC = new TField("rowObjectSpecs", 15, 1);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new PortalRowVisibleNotificationStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new PortalRowVisibleNotificationTupleSchemeFactory();
    @Nullable
    private List<ObjectSpec> rowObjectSpecs;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public PortalRowVisibleNotification() {
    }

    public PortalRowVisibleNotification(List<ObjectSpec> list) {
        this();
        this.rowObjectSpecs = list;
    }

    public PortalRowVisibleNotification(PortalRowVisibleNotification portalRowVisibleNotification) {
        if (portalRowVisibleNotification.isSetRowObjectSpecs()) {
            ArrayList<ObjectSpec> arrayList = new ArrayList<ObjectSpec>(portalRowVisibleNotification.rowObjectSpecs.size());
            for (ObjectSpec objectSpec : portalRowVisibleNotification.rowObjectSpecs) {
                arrayList.add(new ObjectSpec(objectSpec));
            }
            this.rowObjectSpecs = arrayList;
        }
    }

    public PortalRowVisibleNotification deepCopy() {
        return new PortalRowVisibleNotification(this);
    }

    public void clear() {
        this.rowObjectSpecs = null;
    }

    public int getRowObjectSpecsSize() {
        return this.rowObjectSpecs == null ? 0 : this.rowObjectSpecs.size();
    }

    @Nullable
    public Iterator<ObjectSpec> getRowObjectSpecsIterator() {
        return this.rowObjectSpecs == null ? null : this.rowObjectSpecs.iterator();
    }

    public void addToRowObjectSpecs(ObjectSpec objectSpec) {
        if (this.rowObjectSpecs == null) {
            this.rowObjectSpecs = new ArrayList<ObjectSpec>();
        }
        this.rowObjectSpecs.add(objectSpec);
    }

    @Nullable
    public List<ObjectSpec> getRowObjectSpecs() {
        return this.rowObjectSpecs;
    }

    public void setRowObjectSpecs(@Nullable List<ObjectSpec> list) {
        this.rowObjectSpecs = list;
    }

    public void unsetRowObjectSpecs() {
        this.rowObjectSpecs = null;
    }

    public boolean isSetRowObjectSpecs() {
        return this.rowObjectSpecs != null;
    }

    public void setRowObjectSpecsIsSet(boolean bl) {
        if (!bl) {
            this.rowObjectSpecs = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetRowObjectSpecs();
                    break;
                }
                this.setRowObjectSpecs((List)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getRowObjectSpecs();
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
                return this.isSetRowObjectSpecs();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof PortalRowVisibleNotification) {
            return this.equals((PortalRowVisibleNotification)object);
        }
        return false;
    }

    public boolean equals(PortalRowVisibleNotification portalRowVisibleNotification) {
        if (portalRowVisibleNotification == null) {
            return false;
        }
        if (this == portalRowVisibleNotification) {
            return true;
        }
        boolean bl = this.isSetRowObjectSpecs();
        boolean bl2 = portalRowVisibleNotification.isSetRowObjectSpecs();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.rowObjectSpecs.equals(portalRowVisibleNotification.rowObjectSpecs)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetRowObjectSpecs() ? 131071 : 524287);
        if (this.isSetRowObjectSpecs()) {
            n = n * 8191 + this.rowObjectSpecs.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(PortalRowVisibleNotification portalRowVisibleNotification) {
        if (!this.getClass().equals(portalRowVisibleNotification.getClass())) {
            return this.getClass().getName().compareTo(portalRowVisibleNotification.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetRowObjectSpecs(), portalRowVisibleNotification.isSetRowObjectSpecs());
        if (n != 0) {
            return n;
        }
        if (this.isSetRowObjectSpecs() && (n = TBaseHelper.compareTo(this.rowObjectSpecs, portalRowVisibleNotification.rowObjectSpecs)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        PortalRowVisibleNotification.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        PortalRowVisibleNotification.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("PortalRowVisibleNotification(");
        boolean bl = true;
        stringBuilder.append("rowObjectSpecs:");
        if (this.rowObjectSpecs == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.rowObjectSpecs);
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
        enumMap.put(_Fields.ROW_OBJECT_SPECS, new FieldMetaData("rowObjectSpecs", 3, (FieldValueMetaData)new ListMetaData(15, (FieldValueMetaData)new StructMetaData(12, ObjectSpec.class))));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(PortalRowVisibleNotification.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        ROW_OBJECT_SPECS(1, "rowObjectSpecs");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return ROW_OBJECT_SPECS;
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

    private static class PortalRowVisibleNotificationStandardSchemeFactory
    implements SchemeFactory {
        private PortalRowVisibleNotificationStandardSchemeFactory() {
        }

        public PortalRowVisibleNotificationStandardScheme getScheme() {
            return new PortalRowVisibleNotificationStandardScheme();
        }
    }

    private static class PortalRowVisibleNotificationTupleSchemeFactory
    implements SchemeFactory {
        private PortalRowVisibleNotificationTupleSchemeFactory() {
        }

        public PortalRowVisibleNotificationTupleScheme getScheme() {
            return new PortalRowVisibleNotificationTupleScheme();
        }
    }

    private static class PortalRowVisibleNotificationTupleScheme
    extends TupleScheme<PortalRowVisibleNotification> {
        private PortalRowVisibleNotificationTupleScheme() {
        }

        public void write(TProtocol tProtocol, PortalRowVisibleNotification portalRowVisibleNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (portalRowVisibleNotification.isSetRowObjectSpecs()) {
                bitSet.set(0);
            }
            tTupleProtocol.writeBitSet(bitSet, 1);
            if (portalRowVisibleNotification.isSetRowObjectSpecs()) {
                tTupleProtocol.writeI32(portalRowVisibleNotification.rowObjectSpecs.size());
                for (ObjectSpec objectSpec : portalRowVisibleNotification.rowObjectSpecs) {
                    objectSpec.write((TProtocol)tTupleProtocol);
                }
            }
        }

        public void read(TProtocol tProtocol, PortalRowVisibleNotification portalRowVisibleNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(1);
            if (bitSet.get(0)) {
                TList tList = tTupleProtocol.readListBegin((byte)12);
                portalRowVisibleNotification.rowObjectSpecs = new ArrayList<ObjectSpec>(tList.size);
                for (int i = 0; i < tList.size; ++i) {
                    ObjectSpec objectSpec = new ObjectSpec();
                    objectSpec.read((TProtocol)tTupleProtocol);
                    portalRowVisibleNotification.rowObjectSpecs.add(objectSpec);
                }
                portalRowVisibleNotification.setRowObjectSpecsIsSet(true);
            }
        }
    }

    private static class PortalRowVisibleNotificationStandardScheme
    extends StandardScheme<PortalRowVisibleNotification> {
        private PortalRowVisibleNotificationStandardScheme() {
        }

        public void read(TProtocol tProtocol, PortalRowVisibleNotification portalRowVisibleNotification) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 15) {
                            TList tList = tProtocol.readListBegin();
                            portalRowVisibleNotification.rowObjectSpecs = new ArrayList<ObjectSpec>(tList.size);
                            for (int i = 0; i < tList.size; ++i) {
                                ObjectSpec objectSpec = new ObjectSpec();
                                objectSpec.read(tProtocol);
                                portalRowVisibleNotification.rowObjectSpecs.add(objectSpec);
                            }
                            tProtocol.readListEnd();
                            portalRowVisibleNotification.setRowObjectSpecsIsSet(true);
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
            portalRowVisibleNotification.validate();
        }

        public void write(TProtocol tProtocol, PortalRowVisibleNotification portalRowVisibleNotification) throws TException {
            portalRowVisibleNotification.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (portalRowVisibleNotification.rowObjectSpecs != null) {
                tProtocol.writeFieldBegin(ROW_OBJECT_SPECS_FIELD_DESC);
                tProtocol.writeListBegin(new TList(12, portalRowVisibleNotification.rowObjectSpecs.size()));
                for (ObjectSpec objectSpec : portalRowVisibleNotification.rowObjectSpecs) {
                    objectSpec.write(tProtocol);
                }
                tProtocol.writeListEnd();
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

