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
 *  org.apache.thrift.meta_data.MapMetaData
 *  org.apache.thrift.meta_data.StructMetaData
 *  org.apache.thrift.protocol.TCompactProtocol
 *  org.apache.thrift.protocol.TField
 *  org.apache.thrift.protocol.TMap
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
import org.apache.thrift.meta_data.MapMetaData;
import org.apache.thrift.meta_data.StructMetaData;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TMap;
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

public class ObjectsChangeNotification
implements TBase<ObjectsChangeNotification, _Fields>,
Serializable,
Cloneable,
Comparable<ObjectsChangeNotification> {
    private static final TStruct STRUCT_DESC = new TStruct("ObjectsChangeNotification");
    private static final TField OBJECTS_FIELD_DESC = new TField("objects", 13, 1);
    private static final TField PORTALS_FIELD_DESC = new TField("portals", 13, 2);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new ObjectsChangeNotificationStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new ObjectsChangeNotificationTupleSchemeFactory();
    @Nullable
    private Map<Integer, ObjectSpec> objects;
    @Nullable
    private Map<Integer, ObjectSpec> portals;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public ObjectsChangeNotification() {
    }

    public ObjectsChangeNotification(Map<Integer, ObjectSpec> map, Map<Integer, ObjectSpec> map2) {
        this();
        this.objects = map;
        this.portals = map2;
    }

    public ObjectsChangeNotification(ObjectsChangeNotification objectsChangeNotification) {
        ObjectSpec objectSpec;
        Integer n;
        ObjectSpec objectSpec2;
        Integer n2;
        HashMap<Integer, ObjectSpec> hashMap;
        if (objectsChangeNotification.isSetObjects()) {
            hashMap = new HashMap<Integer, ObjectSpec>(objectsChangeNotification.objects.size());
            for (Map.Entry<Integer, ObjectSpec> entry : objectsChangeNotification.objects.entrySet()) {
                n2 = entry.getKey();
                objectSpec2 = entry.getValue();
                n = n2;
                objectSpec = new ObjectSpec(objectSpec2);
                hashMap.put(n, objectSpec);
            }
            this.objects = hashMap;
        }
        if (objectsChangeNotification.isSetPortals()) {
            hashMap = new HashMap(objectsChangeNotification.portals.size());
            for (Map.Entry<Integer, ObjectSpec> entry : objectsChangeNotification.portals.entrySet()) {
                n2 = entry.getKey();
                objectSpec2 = entry.getValue();
                n = n2;
                objectSpec = new ObjectSpec(objectSpec2);
                hashMap.put(n, objectSpec);
            }
            this.portals = hashMap;
        }
    }

    public ObjectsChangeNotification deepCopy() {
        return new ObjectsChangeNotification(this);
    }

    public void clear() {
        this.objects = null;
        this.portals = null;
    }

    public int getObjectsSize() {
        return this.objects == null ? 0 : this.objects.size();
    }

    public void putToObjects(int n, ObjectSpec objectSpec) {
        if (this.objects == null) {
            this.objects = new HashMap<Integer, ObjectSpec>();
        }
        this.objects.put(n, objectSpec);
    }

    @Nullable
    public Map<Integer, ObjectSpec> getObjects() {
        return this.objects;
    }

    public void setObjects(@Nullable Map<Integer, ObjectSpec> map) {
        this.objects = map;
    }

    public void unsetObjects() {
        this.objects = null;
    }

    public boolean isSetObjects() {
        return this.objects != null;
    }

    public void setObjectsIsSet(boolean bl) {
        if (!bl) {
            this.objects = null;
        }
    }

    public int getPortalsSize() {
        return this.portals == null ? 0 : this.portals.size();
    }

    public void putToPortals(int n, ObjectSpec objectSpec) {
        if (this.portals == null) {
            this.portals = new HashMap<Integer, ObjectSpec>();
        }
        this.portals.put(n, objectSpec);
    }

    @Nullable
    public Map<Integer, ObjectSpec> getPortals() {
        return this.portals;
    }

    public void setPortals(@Nullable Map<Integer, ObjectSpec> map) {
        this.portals = map;
    }

    public void unsetPortals() {
        this.portals = null;
    }

    public boolean isSetPortals() {
        return this.portals != null;
    }

    public void setPortalsIsSet(boolean bl) {
        if (!bl) {
            this.portals = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetObjects();
                    break;
                }
                this.setObjects((Map)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetPortals();
                    break;
                }
                this.setPortals((Map)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getObjects();
            }
            case 1: {
                return this.getPortals();
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
                return this.isSetObjects();
            }
            case 1: {
                return this.isSetPortals();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof ObjectsChangeNotification) {
            return this.equals((ObjectsChangeNotification)object);
        }
        return false;
    }

    public boolean equals(ObjectsChangeNotification objectsChangeNotification) {
        if (objectsChangeNotification == null) {
            return false;
        }
        if (this == objectsChangeNotification) {
            return true;
        }
        boolean bl = this.isSetObjects();
        boolean bl2 = objectsChangeNotification.isSetObjects();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.objects.equals(objectsChangeNotification.objects)) {
                return false;
            }
        }
        boolean bl3 = this.isSetPortals();
        boolean bl4 = objectsChangeNotification.isSetPortals();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.portals.equals(objectsChangeNotification.portals)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetObjects() ? 131071 : 524287);
        if (this.isSetObjects()) {
            n = n * 8191 + this.objects.hashCode();
        }
        n = n * 8191 + (this.isSetPortals() ? 131071 : 524287);
        if (this.isSetPortals()) {
            n = n * 8191 + this.portals.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(ObjectsChangeNotification objectsChangeNotification) {
        if (!this.getClass().equals(objectsChangeNotification.getClass())) {
            return this.getClass().getName().compareTo(objectsChangeNotification.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetObjects(), objectsChangeNotification.isSetObjects());
        if (n != 0) {
            return n;
        }
        if (this.isSetObjects() && (n = TBaseHelper.compareTo(this.objects, objectsChangeNotification.objects)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetPortals(), objectsChangeNotification.isSetPortals());
        if (n != 0) {
            return n;
        }
        if (this.isSetPortals() && (n = TBaseHelper.compareTo(this.portals, objectsChangeNotification.portals)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        ObjectsChangeNotification.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        ObjectsChangeNotification.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ObjectsChangeNotification(");
        boolean bl = true;
        stringBuilder.append("objects:");
        if (this.objects == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.objects);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("portals:");
        if (this.portals == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.portals);
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
        enumMap.put(_Fields.OBJECTS, new FieldMetaData("objects", 3, (FieldValueMetaData)new MapMetaData(13, new FieldValueMetaData(8), (FieldValueMetaData)new StructMetaData(12, ObjectSpec.class))));
        enumMap.put(_Fields.PORTALS, new FieldMetaData("portals", 3, (FieldValueMetaData)new MapMetaData(13, new FieldValueMetaData(8), (FieldValueMetaData)new StructMetaData(12, ObjectSpec.class))));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(ObjectsChangeNotification.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        OBJECTS(1, "objects"),
        PORTALS(2, "portals");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return OBJECTS;
                }
                case 2: {
                    return PORTALS;
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

    private static class ObjectsChangeNotificationStandardSchemeFactory
    implements SchemeFactory {
        private ObjectsChangeNotificationStandardSchemeFactory() {
        }

        public ObjectsChangeNotificationStandardScheme getScheme() {
            return new ObjectsChangeNotificationStandardScheme();
        }
    }

    private static class ObjectsChangeNotificationTupleSchemeFactory
    implements SchemeFactory {
        private ObjectsChangeNotificationTupleSchemeFactory() {
        }

        public ObjectsChangeNotificationTupleScheme getScheme() {
            return new ObjectsChangeNotificationTupleScheme();
        }
    }

    private static class ObjectsChangeNotificationTupleScheme
    extends TupleScheme<ObjectsChangeNotification> {
        private ObjectsChangeNotificationTupleScheme() {
        }

        public void write(TProtocol tProtocol, ObjectsChangeNotification objectsChangeNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (objectsChangeNotification.isSetObjects()) {
                bitSet.set(0);
            }
            if (objectsChangeNotification.isSetPortals()) {
                bitSet.set(1);
            }
            tTupleProtocol.writeBitSet(bitSet, 2);
            if (objectsChangeNotification.isSetObjects()) {
                tTupleProtocol.writeI32(objectsChangeNotification.objects.size());
                for (Map.Entry<Integer, ObjectSpec> entry : objectsChangeNotification.objects.entrySet()) {
                    tTupleProtocol.writeI32(entry.getKey().intValue());
                    entry.getValue().write((TProtocol)tTupleProtocol);
                }
            }
            if (objectsChangeNotification.isSetPortals()) {
                tTupleProtocol.writeI32(objectsChangeNotification.portals.size());
                for (Map.Entry<Integer, ObjectSpec> entry : objectsChangeNotification.portals.entrySet()) {
                    tTupleProtocol.writeI32(entry.getKey().intValue());
                    entry.getValue().write((TProtocol)tTupleProtocol);
                }
            }
        }

        public void read(TProtocol tProtocol, ObjectsChangeNotification objectsChangeNotification) throws TException {
            ObjectSpec objectSpec;
            int n;
            int n2;
            TMap tMap;
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(2);
            if (bitSet.get(0)) {
                tMap = tTupleProtocol.readMapBegin((byte)8, (byte)12);
                objectsChangeNotification.objects = new HashMap<Integer, ObjectSpec>(2 * tMap.size);
                for (n2 = 0; n2 < tMap.size; ++n2) {
                    n = tTupleProtocol.readI32();
                    objectSpec = new ObjectSpec();
                    objectSpec.read((TProtocol)tTupleProtocol);
                    objectsChangeNotification.objects.put(n, objectSpec);
                }
                objectsChangeNotification.setObjectsIsSet(true);
            }
            if (bitSet.get(1)) {
                tMap = tTupleProtocol.readMapBegin((byte)8, (byte)12);
                objectsChangeNotification.portals = new HashMap<Integer, ObjectSpec>(2 * tMap.size);
                for (n2 = 0; n2 < tMap.size; ++n2) {
                    n = tTupleProtocol.readI32();
                    objectSpec = new ObjectSpec();
                    objectSpec.read((TProtocol)tTupleProtocol);
                    objectsChangeNotification.portals.put(n, objectSpec);
                }
                objectsChangeNotification.setPortalsIsSet(true);
            }
        }
    }

    private static class ObjectsChangeNotificationStandardScheme
    extends StandardScheme<ObjectsChangeNotification> {
        private ObjectsChangeNotificationStandardScheme() {
        }

        public void read(TProtocol tProtocol, ObjectsChangeNotification objectsChangeNotification) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        ObjectSpec objectSpec;
                        int n;
                        int n2;
                        TMap tMap;
                        if (tField.type == 13) {
                            tMap = tProtocol.readMapBegin();
                            objectsChangeNotification.objects = new HashMap<Integer, ObjectSpec>(2 * tMap.size);
                            for (n2 = 0; n2 < tMap.size; ++n2) {
                                n = tProtocol.readI32();
                                objectSpec = new ObjectSpec();
                                objectSpec.read(tProtocol);
                                objectsChangeNotification.objects.put(n, objectSpec);
                            }
                            tProtocol.readMapEnd();
                            objectsChangeNotification.setObjectsIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        ObjectSpec objectSpec;
                        int n;
                        int n2;
                        TMap tMap;
                        if (tField.type == 13) {
                            tMap = tProtocol.readMapBegin();
                            objectsChangeNotification.portals = new HashMap<Integer, ObjectSpec>(2 * tMap.size);
                            for (n2 = 0; n2 < tMap.size; ++n2) {
                                n = tProtocol.readI32();
                                objectSpec = new ObjectSpec();
                                objectSpec.read(tProtocol);
                                objectsChangeNotification.portals.put(n, objectSpec);
                            }
                            tProtocol.readMapEnd();
                            objectsChangeNotification.setPortalsIsSet(true);
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
            objectsChangeNotification.validate();
        }

        public void write(TProtocol tProtocol, ObjectsChangeNotification objectsChangeNotification) throws TException {
            objectsChangeNotification.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (objectsChangeNotification.objects != null) {
                tProtocol.writeFieldBegin(OBJECTS_FIELD_DESC);
                tProtocol.writeMapBegin(new TMap(8, 12, objectsChangeNotification.objects.size()));
                for (Map.Entry<Integer, ObjectSpec> entry : objectsChangeNotification.objects.entrySet()) {
                    tProtocol.writeI32(entry.getKey().intValue());
                    entry.getValue().write(tProtocol);
                }
                tProtocol.writeMapEnd();
                tProtocol.writeFieldEnd();
            }
            if (objectsChangeNotification.portals != null) {
                tProtocol.writeFieldBegin(PORTALS_FIELD_DESC);
                tProtocol.writeMapBegin(new TMap(8, 12, objectsChangeNotification.portals.size()));
                for (Map.Entry<Integer, ObjectSpec> entry : objectsChangeNotification.portals.entrySet()) {
                    tProtocol.writeI32(entry.getKey().intValue());
                    entry.getValue().write(tProtocol);
                }
                tProtocol.writeMapEnd();
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

