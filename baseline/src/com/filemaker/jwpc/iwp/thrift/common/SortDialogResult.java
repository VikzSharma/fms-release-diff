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
package com.filemaker.jwpc.iwp.thrift.common;

import com.filemaker.jwpc.iwp.thrift.common.SortAction;
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
import org.apache.thrift.meta_data.EnumMetaData;
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

public class SortDialogResult
implements TBase<SortDialogResult, _Fields>,
Serializable,
Cloneable,
Comparable<SortDialogResult> {
    private static final TStruct STRUCT_DESC = new TStruct("SortDialogResult");
    private static final TField ACTION_FIELD_DESC = new TField("action", 8, 1);
    private static final TField QUERIES_FIELD_DESC = new TField("queries", 15, 2);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new SortDialogResultStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new SortDialogResultTupleSchemeFactory();
    @Nullable
    private SortAction action;
    @Nullable
    private List<SortQuery> queries;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public SortDialogResult() {
    }

    public SortDialogResult(SortAction sortAction, List<SortQuery> list) {
        this();
        this.action = sortAction;
        this.queries = list;
    }

    public SortDialogResult(SortDialogResult sortDialogResult) {
        if (sortDialogResult.isSetAction()) {
            this.action = sortDialogResult.action;
        }
        if (sortDialogResult.isSetQueries()) {
            ArrayList<SortQuery> arrayList = new ArrayList<SortQuery>(sortDialogResult.queries.size());
            for (SortQuery sortQuery : sortDialogResult.queries) {
                arrayList.add(new SortQuery(sortQuery));
            }
            this.queries = arrayList;
        }
    }

    public SortDialogResult deepCopy() {
        return new SortDialogResult(this);
    }

    public void clear() {
        this.action = null;
        this.queries = null;
    }

    @Nullable
    public SortAction getAction() {
        return this.action;
    }

    public void setAction(@Nullable SortAction sortAction) {
        this.action = sortAction;
    }

    public void unsetAction() {
        this.action = null;
    }

    public boolean isSetAction() {
        return this.action != null;
    }

    public void setActionIsSet(boolean bl) {
        if (!bl) {
            this.action = null;
        }
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

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetAction();
                    break;
                }
                this.setAction((SortAction)((Object)object));
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetQueries();
                    break;
                }
                this.setQueries((List)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getAction();
            }
            case 1: {
                return this.getQueries();
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
                return this.isSetAction();
            }
            case 1: {
                return this.isSetQueries();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof SortDialogResult) {
            return this.equals((SortDialogResult)object);
        }
        return false;
    }

    public boolean equals(SortDialogResult sortDialogResult) {
        if (sortDialogResult == null) {
            return false;
        }
        if (this == sortDialogResult) {
            return true;
        }
        boolean bl = this.isSetAction();
        boolean bl2 = sortDialogResult.isSetAction();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.action.equals((Object)sortDialogResult.action)) {
                return false;
            }
        }
        boolean bl3 = this.isSetQueries();
        boolean bl4 = sortDialogResult.isSetQueries();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.queries.equals(sortDialogResult.queries)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetAction() ? 131071 : 524287);
        if (this.isSetAction()) {
            n = n * 8191 + this.action.getValue();
        }
        n = n * 8191 + (this.isSetQueries() ? 131071 : 524287);
        if (this.isSetQueries()) {
            n = n * 8191 + this.queries.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(SortDialogResult sortDialogResult) {
        if (!this.getClass().equals(sortDialogResult.getClass())) {
            return this.getClass().getName().compareTo(sortDialogResult.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetAction(), sortDialogResult.isSetAction());
        if (n != 0) {
            return n;
        }
        if (this.isSetAction() && (n = TBaseHelper.compareTo((Comparable)((Object)this.action), (Comparable)((Object)sortDialogResult.action))) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetQueries(), sortDialogResult.isSetQueries());
        if (n != 0) {
            return n;
        }
        if (this.isSetQueries() && (n = TBaseHelper.compareTo(this.queries, sortDialogResult.queries)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        SortDialogResult.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        SortDialogResult.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("SortDialogResult(");
        boolean bl = true;
        stringBuilder.append("action:");
        if (this.action == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append((Object)this.action);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("queries:");
        if (this.queries == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.queries);
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
        enumMap.put(_Fields.ACTION, new FieldMetaData("action", 3, (FieldValueMetaData)new EnumMetaData(-1, SortAction.class)));
        enumMap.put(_Fields.QUERIES, new FieldMetaData("queries", 3, (FieldValueMetaData)new ListMetaData(15, (FieldValueMetaData)new StructMetaData(12, SortQuery.class))));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(SortDialogResult.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        ACTION(1, "action"),
        QUERIES(2, "queries");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return ACTION;
                }
                case 2: {
                    return QUERIES;
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

    private static class SortDialogResultStandardSchemeFactory
    implements SchemeFactory {
        private SortDialogResultStandardSchemeFactory() {
        }

        public SortDialogResultStandardScheme getScheme() {
            return new SortDialogResultStandardScheme();
        }
    }

    private static class SortDialogResultTupleSchemeFactory
    implements SchemeFactory {
        private SortDialogResultTupleSchemeFactory() {
        }

        public SortDialogResultTupleScheme getScheme() {
            return new SortDialogResultTupleScheme();
        }
    }

    private static class SortDialogResultTupleScheme
    extends TupleScheme<SortDialogResult> {
        private SortDialogResultTupleScheme() {
        }

        public void write(TProtocol tProtocol, SortDialogResult sortDialogResult) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (sortDialogResult.isSetAction()) {
                bitSet.set(0);
            }
            if (sortDialogResult.isSetQueries()) {
                bitSet.set(1);
            }
            tTupleProtocol.writeBitSet(bitSet, 2);
            if (sortDialogResult.isSetAction()) {
                tTupleProtocol.writeI32(sortDialogResult.action.getValue());
            }
            if (sortDialogResult.isSetQueries()) {
                tTupleProtocol.writeI32(sortDialogResult.queries.size());
                for (SortQuery sortQuery : sortDialogResult.queries) {
                    sortQuery.write((TProtocol)tTupleProtocol);
                }
            }
        }

        public void read(TProtocol tProtocol, SortDialogResult sortDialogResult) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(2);
            if (bitSet.get(0)) {
                sortDialogResult.action = SortAction.findByValue(tTupleProtocol.readI32());
                sortDialogResult.setActionIsSet(true);
            }
            if (bitSet.get(1)) {
                TList tList = tTupleProtocol.readListBegin((byte)12);
                sortDialogResult.queries = new ArrayList<SortQuery>(tList.size);
                for (int i = 0; i < tList.size; ++i) {
                    SortQuery sortQuery = new SortQuery();
                    sortQuery.read((TProtocol)tTupleProtocol);
                    sortDialogResult.queries.add(sortQuery);
                }
                sortDialogResult.setQueriesIsSet(true);
            }
        }
    }

    private static class SortDialogResultStandardScheme
    extends StandardScheme<SortDialogResult> {
        private SortDialogResultStandardScheme() {
        }

        public void read(TProtocol tProtocol, SortDialogResult sortDialogResult) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 8) {
                            sortDialogResult.action = SortAction.findByValue(tProtocol.readI32());
                            sortDialogResult.setActionIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 15) {
                            TList tList = tProtocol.readListBegin();
                            sortDialogResult.queries = new ArrayList<SortQuery>(tList.size);
                            for (int i = 0; i < tList.size; ++i) {
                                SortQuery sortQuery = new SortQuery();
                                sortQuery.read(tProtocol);
                                sortDialogResult.queries.add(sortQuery);
                            }
                            tProtocol.readListEnd();
                            sortDialogResult.setQueriesIsSet(true);
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
            sortDialogResult.validate();
        }

        public void write(TProtocol tProtocol, SortDialogResult sortDialogResult) throws TException {
            sortDialogResult.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (sortDialogResult.action != null) {
                tProtocol.writeFieldBegin(ACTION_FIELD_DESC);
                tProtocol.writeI32(sortDialogResult.action.getValue());
                tProtocol.writeFieldEnd();
            }
            if (sortDialogResult.queries != null) {
                tProtocol.writeFieldBegin(QUERIES_FIELD_DESC);
                tProtocol.writeListBegin(new TList(12, sortDialogResult.queries.size()));
                for (SortQuery sortQuery : sortDialogResult.queries) {
                    sortQuery.write(tProtocol);
                }
                tProtocol.writeListEnd();
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

