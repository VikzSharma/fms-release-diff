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
 *  org.apache.thrift.meta_data.MapMetaData
 *  org.apache.thrift.meta_data.StructMetaData
 *  org.apache.thrift.protocol.TCompactProtocol
 *  org.apache.thrift.protocol.TField
 *  org.apache.thrift.protocol.TList
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

import com.filemaker.jwpc.iwp.thrift.common.SortQuery;
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
import org.apache.thrift.meta_data.MapMetaData;
import org.apache.thrift.meta_data.StructMetaData;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TList;
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

public class SortDialogNotification
implements TBase<SortDialogNotification, _Fields>,
Serializable,
Cloneable,
Comparable<SortDialogNotification> {
    private static final TStruct STRUCT_DESC = new TStruct("SortDialogNotification");
    private static final TField QUERIES_FIELD_DESC = new TField("queries", 15, 1);
    private static final TField VALUE_LIST_NAMES_FIELD_DESC = new TField("valueListNames", 13, 2);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new SortDialogNotificationStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new SortDialogNotificationTupleSchemeFactory();
    @Nullable
    private List<SortQuery> queries;
    @Nullable
    private Map<Integer, String> valueListNames;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public SortDialogNotification() {
    }

    public SortDialogNotification(List<SortQuery> list, Map<Integer, String> map) {
        this();
        this.queries = list;
        this.valueListNames = map;
    }

    public SortDialogNotification(SortDialogNotification sortDialogNotification) {
        Cloneable cloneable;
        if (sortDialogNotification.isSetQueries()) {
            cloneable = new ArrayList(sortDialogNotification.queries.size());
            for (SortQuery sortQuery : sortDialogNotification.queries) {
                cloneable.add(new SortQuery(sortQuery));
            }
            this.queries = cloneable;
        }
        if (sortDialogNotification.isSetValueListNames()) {
            cloneable = new HashMap<Integer, String>(sortDialogNotification.valueListNames);
            this.valueListNames = cloneable;
        }
    }

    public SortDialogNotification deepCopy() {
        return new SortDialogNotification(this);
    }

    public void clear() {
        this.queries = null;
        this.valueListNames = null;
    }

    public int getQueriesSize() {
        return this.queries == null ? 0 : this.queries.size();
    }

    @Nullable
    public Iterator<SortQuery> getQueriesIterator() {
        return this.queries == null ? null : this.queries.iterator();
    }

    public void addToQueries(SortQuery sortQuery) {
        if (this.queries == null) {
            this.queries = new ArrayList<SortQuery>();
        }
        this.queries.add(sortQuery);
    }

    @Nullable
    public List<SortQuery> getQueries() {
        return this.queries;
    }

    public void setQueries(@Nullable List<SortQuery> list) {
        this.queries = list;
    }

    public void unsetQueries() {
        this.queries = null;
    }

    public boolean isSetQueries() {
        return this.queries != null;
    }

    public void setQueriesIsSet(boolean bl) {
        if (!bl) {
            this.queries = null;
        }
    }

    public int getValueListNamesSize() {
        return this.valueListNames == null ? 0 : this.valueListNames.size();
    }

    public void putToValueListNames(int n, String string) {
        if (this.valueListNames == null) {
            this.valueListNames = new HashMap<Integer, String>();
        }
        this.valueListNames.put(n, string);
    }

    @Nullable
    public Map<Integer, String> getValueListNames() {
        return this.valueListNames;
    }

    public void setValueListNames(@Nullable Map<Integer, String> map) {
        this.valueListNames = map;
    }

    public void unsetValueListNames() {
        this.valueListNames = null;
    }

    public boolean isSetValueListNames() {
        return this.valueListNames != null;
    }

    public void setValueListNamesIsSet(boolean bl) {
        if (!bl) {
            this.valueListNames = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetQueries();
                    break;
                }
                this.setQueries((List)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetValueListNames();
                    break;
                }
                this.setValueListNames((Map)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getQueries();
            }
            case 1: {
                return this.getValueListNames();
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
                return this.isSetQueries();
            }
            case 1: {
                return this.isSetValueListNames();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof SortDialogNotification) {
            return this.equals((SortDialogNotification)object);
        }
        return false;
    }

    public boolean equals(SortDialogNotification sortDialogNotification) {
        if (sortDialogNotification == null) {
            return false;
        }
        if (this == sortDialogNotification) {
            return true;
        }
        boolean bl = this.isSetQueries();
        boolean bl2 = sortDialogNotification.isSetQueries();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.queries.equals(sortDialogNotification.queries)) {
                return false;
            }
        }
        boolean bl3 = this.isSetValueListNames();
        boolean bl4 = sortDialogNotification.isSetValueListNames();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.valueListNames.equals(sortDialogNotification.valueListNames)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetQueries() ? 131071 : 524287);
        if (this.isSetQueries()) {
            n = n * 8191 + this.queries.hashCode();
        }
        n = n * 8191 + (this.isSetValueListNames() ? 131071 : 524287);
        if (this.isSetValueListNames()) {
            n = n * 8191 + this.valueListNames.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(SortDialogNotification sortDialogNotification) {
        if (!this.getClass().equals(sortDialogNotification.getClass())) {
            return this.getClass().getName().compareTo(sortDialogNotification.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetQueries(), sortDialogNotification.isSetQueries());
        if (n != 0) {
            return n;
        }
        if (this.isSetQueries() && (n = TBaseHelper.compareTo(this.queries, sortDialogNotification.queries)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetValueListNames(), sortDialogNotification.isSetValueListNames());
        if (n != 0) {
            return n;
        }
        if (this.isSetValueListNames() && (n = TBaseHelper.compareTo(this.valueListNames, sortDialogNotification.valueListNames)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        SortDialogNotification.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        SortDialogNotification.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("SortDialogNotification(");
        boolean bl = true;
        stringBuilder.append("queries:");
        if (this.queries == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.queries);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("valueListNames:");
        if (this.valueListNames == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.valueListNames);
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
        enumMap.put(_Fields.QUERIES, new FieldMetaData("queries", 3, (FieldValueMetaData)new ListMetaData(15, (FieldValueMetaData)new StructMetaData(12, SortQuery.class))));
        enumMap.put(_Fields.VALUE_LIST_NAMES, new FieldMetaData("valueListNames", 3, (FieldValueMetaData)new MapMetaData(13, new FieldValueMetaData(8), new FieldValueMetaData(11))));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(SortDialogNotification.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        QUERIES(1, "queries"),
        VALUE_LIST_NAMES(2, "valueListNames");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return QUERIES;
                }
                case 2: {
                    return VALUE_LIST_NAMES;
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

    private static class SortDialogNotificationStandardSchemeFactory
    implements SchemeFactory {
        private SortDialogNotificationStandardSchemeFactory() {
        }

        public SortDialogNotificationStandardScheme getScheme() {
            return new SortDialogNotificationStandardScheme();
        }
    }

    private static class SortDialogNotificationTupleSchemeFactory
    implements SchemeFactory {
        private SortDialogNotificationTupleSchemeFactory() {
        }

        public SortDialogNotificationTupleScheme getScheme() {
            return new SortDialogNotificationTupleScheme();
        }
    }

    private static class SortDialogNotificationTupleScheme
    extends TupleScheme<SortDialogNotification> {
        private SortDialogNotificationTupleScheme() {
        }

        public void write(TProtocol tProtocol, SortDialogNotification sortDialogNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (sortDialogNotification.isSetQueries()) {
                bitSet.set(0);
            }
            if (sortDialogNotification.isSetValueListNames()) {
                bitSet.set(1);
            }
            tTupleProtocol.writeBitSet(bitSet, 2);
            if (sortDialogNotification.isSetQueries()) {
                tTupleProtocol.writeI32(sortDialogNotification.queries.size());
                for (SortQuery object : sortDialogNotification.queries) {
                    object.write((TProtocol)tTupleProtocol);
                }
            }
            if (sortDialogNotification.isSetValueListNames()) {
                tTupleProtocol.writeI32(sortDialogNotification.valueListNames.size());
                for (Map.Entry entry : sortDialogNotification.valueListNames.entrySet()) {
                    tTupleProtocol.writeI32(((Integer)entry.getKey()).intValue());
                    tTupleProtocol.writeString((String)entry.getValue());
                }
            }
        }

        public void read(TProtocol tProtocol, SortDialogNotification sortDialogNotification) throws TException {
            TList tList;
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(2);
            if (bitSet.get(0)) {
                tList = tTupleProtocol.readListBegin((byte)12);
                sortDialogNotification.queries = new ArrayList<SortQuery>(tList.size);
                for (int i = 0; i < tList.size; ++i) {
                    SortQuery sortQuery = new SortQuery();
                    sortQuery.read((TProtocol)tTupleProtocol);
                    sortDialogNotification.queries.add(sortQuery);
                }
                sortDialogNotification.setQueriesIsSet(true);
            }
            if (bitSet.get(1)) {
                tList = tTupleProtocol.readMapBegin((byte)8, (byte)11);
                sortDialogNotification.valueListNames = new HashMap<Integer, String>(2 * tList.size);
                for (int i = 0; i < tList.size; ++i) {
                    int n = tTupleProtocol.readI32();
                    String string = tTupleProtocol.readString();
                    sortDialogNotification.valueListNames.put(n, string);
                }
                sortDialogNotification.setValueListNamesIsSet(true);
            }
        }
    }

    private static class SortDialogNotificationStandardScheme
    extends StandardScheme<SortDialogNotification> {
        private SortDialogNotificationStandardScheme() {
        }

        public void read(TProtocol tProtocol, SortDialogNotification sortDialogNotification) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        TList tList;
                        if (tField.type == 15) {
                            tList = tProtocol.readListBegin();
                            sortDialogNotification.queries = new ArrayList<SortQuery>(tList.size);
                            for (int i = 0; i < tList.size; ++i) {
                                SortQuery sortQuery = new SortQuery();
                                sortQuery.read(tProtocol);
                                sortDialogNotification.queries.add(sortQuery);
                            }
                            tProtocol.readListEnd();
                            sortDialogNotification.setQueriesIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        TList tList;
                        if (tField.type == 13) {
                            tList = tProtocol.readMapBegin();
                            sortDialogNotification.valueListNames = new HashMap<Integer, String>(2 * tList.size);
                            for (int i = 0; i < tList.size; ++i) {
                                int n = tProtocol.readI32();
                                String string = tProtocol.readString();
                                sortDialogNotification.valueListNames.put(n, string);
                            }
                            tProtocol.readMapEnd();
                            sortDialogNotification.setValueListNamesIsSet(true);
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
            sortDialogNotification.validate();
        }

        public void write(TProtocol tProtocol, SortDialogNotification sortDialogNotification) throws TException {
            sortDialogNotification.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (sortDialogNotification.queries != null) {
                tProtocol.writeFieldBegin(QUERIES_FIELD_DESC);
                tProtocol.writeListBegin(new TList(12, sortDialogNotification.queries.size()));
                for (SortQuery object : sortDialogNotification.queries) {
                    object.write(tProtocol);
                }
                tProtocol.writeListEnd();
                tProtocol.writeFieldEnd();
            }
            if (sortDialogNotification.valueListNames != null) {
                tProtocol.writeFieldBegin(VALUE_LIST_NAMES_FIELD_DESC);
                tProtocol.writeMapBegin(new TMap(8, 11, sortDialogNotification.valueListNames.size()));
                for (Map.Entry entry : sortDialogNotification.valueListNames.entrySet()) {
                    tProtocol.writeI32(((Integer)entry.getKey()).intValue());
                    tProtocol.writeString((String)entry.getValue());
                }
                tProtocol.writeMapEnd();
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

