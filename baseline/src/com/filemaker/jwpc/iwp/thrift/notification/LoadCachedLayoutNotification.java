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

import com.filemaker.jwpc.iwp.thrift.common.SortQuery;
import com.filemaker.jwpc.iwp.thrift.common.WindowState;
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
import org.apache.thrift.EncodingUtils;
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

public class LoadCachedLayoutNotification
implements TBase<LoadCachedLayoutNotification, _Fields>,
Serializable,
Cloneable,
Comparable<LoadCachedLayoutNotification> {
    private static final TStruct STRUCT_DESC = new TStruct("LoadCachedLayoutNotification");
    private static final TField WINDOW_STATE_FIELD_DESC = new TField("windowState", 12, 1);
    private static final TField LAY_ID_FIELD_DESC = new TField("layId", 8, 2);
    private static final TField MOD_COUNT_FIELD_DESC = new TField("modCount", 10, 3);
    private static final TField SORT_QUERIES_FIELD_DESC = new TField("sortQueries", 15, 4);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new LoadCachedLayoutNotificationStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new LoadCachedLayoutNotificationTupleSchemeFactory();
    @Nullable
    private WindowState windowState;
    private int layId;
    private long modCount;
    @Nullable
    private List<SortQuery> sortQueries;
    private static final int __LAYID_ISSET_ID = 0;
    private static final int __MODCOUNT_ISSET_ID = 1;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public LoadCachedLayoutNotification() {
    }

    public LoadCachedLayoutNotification(WindowState windowState, int n, long l, List<SortQuery> list) {
        this();
        this.windowState = windowState;
        this.layId = n;
        this.setLayIdIsSet(true);
        this.modCount = l;
        this.setModCountIsSet(true);
        this.sortQueries = list;
    }

    public LoadCachedLayoutNotification(LoadCachedLayoutNotification loadCachedLayoutNotification) {
        this.__isset_bitfield = loadCachedLayoutNotification.__isset_bitfield;
        if (loadCachedLayoutNotification.isSetWindowState()) {
            this.windowState = new WindowState(loadCachedLayoutNotification.windowState);
        }
        this.layId = loadCachedLayoutNotification.layId;
        this.modCount = loadCachedLayoutNotification.modCount;
        if (loadCachedLayoutNotification.isSetSortQueries()) {
            ArrayList<SortQuery> arrayList = new ArrayList<SortQuery>(loadCachedLayoutNotification.sortQueries.size());
            for (SortQuery sortQuery : loadCachedLayoutNotification.sortQueries) {
                arrayList.add(new SortQuery(sortQuery));
            }
            this.sortQueries = arrayList;
        }
    }

    public LoadCachedLayoutNotification deepCopy() {
        return new LoadCachedLayoutNotification(this);
    }

    public void clear() {
        this.windowState = null;
        this.setLayIdIsSet(false);
        this.layId = 0;
        this.setModCountIsSet(false);
        this.modCount = 0L;
        this.sortQueries = null;
    }

    @Nullable
    public WindowState getWindowState() {
        return this.windowState;
    }

    public void setWindowState(@Nullable WindowState windowState) {
        this.windowState = windowState;
    }

    public void unsetWindowState() {
        this.windowState = null;
    }

    public boolean isSetWindowState() {
        return this.windowState != null;
    }

    public void setWindowStateIsSet(boolean bl) {
        if (!bl) {
            this.windowState = null;
        }
    }

    public int getLayId() {
        return this.layId;
    }

    public void setLayId(int n) {
        this.layId = n;
        this.setLayIdIsSet(true);
    }

    public void unsetLayId() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetLayId() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setLayIdIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public long getModCount() {
        return this.modCount;
    }

    public void setModCount(long l) {
        this.modCount = l;
        this.setModCountIsSet(true);
    }

    public void unsetModCount() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)1);
    }

    public boolean isSetModCount() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)1);
    }

    public void setModCountIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)1, (boolean)bl);
    }

    public int getSortQueriesSize() {
        return this.sortQueries == null ? 0 : this.sortQueries.size();
    }

    @Nullable
    public Iterator<SortQuery> getSortQueriesIterator() {
        return this.sortQueries == null ? null : this.sortQueries.iterator();
    }

    public void addToSortQueries(SortQuery sortQuery) {
        if (this.sortQueries == null) {
            this.sortQueries = new ArrayList<SortQuery>();
        }
        this.sortQueries.add(sortQuery);
    }

    @Nullable
    public List<SortQuery> getSortQueries() {
        return this.sortQueries;
    }

    public void setSortQueries(@Nullable List<SortQuery> list) {
        this.sortQueries = list;
    }

    public void unsetSortQueries() {
        this.sortQueries = null;
    }

    public boolean isSetSortQueries() {
        return this.sortQueries != null;
    }

    public void setSortQueriesIsSet(boolean bl) {
        if (!bl) {
            this.sortQueries = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetWindowState();
                    break;
                }
                this.setWindowState((WindowState)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetLayId();
                    break;
                }
                this.setLayId((Integer)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetModCount();
                    break;
                }
                this.setModCount((Long)object);
                break;
            }
            case 3: {
                if (object == null) {
                    this.unsetSortQueries();
                    break;
                }
                this.setSortQueries((List)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getWindowState();
            }
            case 1: {
                return this.getLayId();
            }
            case 2: {
                return this.getModCount();
            }
            case 3: {
                return this.getSortQueries();
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
                return this.isSetWindowState();
            }
            case 1: {
                return this.isSetLayId();
            }
            case 2: {
                return this.isSetModCount();
            }
            case 3: {
                return this.isSetSortQueries();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof LoadCachedLayoutNotification) {
            return this.equals((LoadCachedLayoutNotification)object);
        }
        return false;
    }

    public boolean equals(LoadCachedLayoutNotification loadCachedLayoutNotification) {
        if (loadCachedLayoutNotification == null) {
            return false;
        }
        if (this == loadCachedLayoutNotification) {
            return true;
        }
        boolean bl = this.isSetWindowState();
        boolean bl2 = loadCachedLayoutNotification.isSetWindowState();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.windowState.equals(loadCachedLayoutNotification.windowState)) {
                return false;
            }
        }
        boolean bl3 = true;
        boolean bl4 = true;
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (this.layId != loadCachedLayoutNotification.layId) {
                return false;
            }
        }
        boolean bl5 = true;
        boolean bl6 = true;
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (this.modCount != loadCachedLayoutNotification.modCount) {
                return false;
            }
        }
        boolean bl7 = this.isSetSortQueries();
        boolean bl8 = loadCachedLayoutNotification.isSetSortQueries();
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (!this.sortQueries.equals(loadCachedLayoutNotification.sortQueries)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetWindowState() ? 131071 : 524287);
        if (this.isSetWindowState()) {
            n = n * 8191 + this.windowState.hashCode();
        }
        n = n * 8191 + this.layId;
        n = n * 8191 + TBaseHelper.hashCode((long)this.modCount);
        n = n * 8191 + (this.isSetSortQueries() ? 131071 : 524287);
        if (this.isSetSortQueries()) {
            n = n * 8191 + this.sortQueries.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(LoadCachedLayoutNotification loadCachedLayoutNotification) {
        if (!this.getClass().equals(loadCachedLayoutNotification.getClass())) {
            return this.getClass().getName().compareTo(loadCachedLayoutNotification.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetWindowState(), loadCachedLayoutNotification.isSetWindowState());
        if (n != 0) {
            return n;
        }
        if (this.isSetWindowState() && (n = TBaseHelper.compareTo((Comparable)this.windowState, (Comparable)loadCachedLayoutNotification.windowState)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetLayId(), loadCachedLayoutNotification.isSetLayId());
        if (n != 0) {
            return n;
        }
        if (this.isSetLayId() && (n = TBaseHelper.compareTo((int)this.layId, (int)loadCachedLayoutNotification.layId)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetModCount(), loadCachedLayoutNotification.isSetModCount());
        if (n != 0) {
            return n;
        }
        if (this.isSetModCount() && (n = TBaseHelper.compareTo((long)this.modCount, (long)loadCachedLayoutNotification.modCount)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetSortQueries(), loadCachedLayoutNotification.isSetSortQueries());
        if (n != 0) {
            return n;
        }
        if (this.isSetSortQueries() && (n = TBaseHelper.compareTo(this.sortQueries, loadCachedLayoutNotification.sortQueries)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        LoadCachedLayoutNotification.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        LoadCachedLayoutNotification.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("LoadCachedLayoutNotification(");
        boolean bl = true;
        stringBuilder.append("windowState:");
        if (this.windowState == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.windowState);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("layId:");
        stringBuilder.append(this.layId);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("modCount:");
        stringBuilder.append(this.modCount);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("sortQueries:");
        if (this.sortQueries == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.sortQueries);
        }
        bl = false;
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void validate() throws TException {
        if (this.windowState != null) {
            this.windowState.validate();
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
        enumMap.put(_Fields.WINDOW_STATE, new FieldMetaData("windowState", 3, (FieldValueMetaData)new StructMetaData(12, WindowState.class)));
        enumMap.put(_Fields.LAY_ID, new FieldMetaData("layId", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.MOD_COUNT, new FieldMetaData("modCount", 3, new FieldValueMetaData(10)));
        enumMap.put(_Fields.SORT_QUERIES, new FieldMetaData("sortQueries", 3, (FieldValueMetaData)new ListMetaData(15, (FieldValueMetaData)new StructMetaData(12, SortQuery.class))));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(LoadCachedLayoutNotification.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        WINDOW_STATE(1, "windowState"),
        LAY_ID(2, "layId"),
        MOD_COUNT(3, "modCount"),
        SORT_QUERIES(4, "sortQueries");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return WINDOW_STATE;
                }
                case 2: {
                    return LAY_ID;
                }
                case 3: {
                    return MOD_COUNT;
                }
                case 4: {
                    return SORT_QUERIES;
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

    private static class LoadCachedLayoutNotificationStandardSchemeFactory
    implements SchemeFactory {
        private LoadCachedLayoutNotificationStandardSchemeFactory() {
        }

        public LoadCachedLayoutNotificationStandardScheme getScheme() {
            return new LoadCachedLayoutNotificationStandardScheme();
        }
    }

    private static class LoadCachedLayoutNotificationTupleSchemeFactory
    implements SchemeFactory {
        private LoadCachedLayoutNotificationTupleSchemeFactory() {
        }

        public LoadCachedLayoutNotificationTupleScheme getScheme() {
            return new LoadCachedLayoutNotificationTupleScheme();
        }
    }

    private static class LoadCachedLayoutNotificationTupleScheme
    extends TupleScheme<LoadCachedLayoutNotification> {
        private LoadCachedLayoutNotificationTupleScheme() {
        }

        public void write(TProtocol tProtocol, LoadCachedLayoutNotification loadCachedLayoutNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (loadCachedLayoutNotification.isSetWindowState()) {
                bitSet.set(0);
            }
            if (loadCachedLayoutNotification.isSetLayId()) {
                bitSet.set(1);
            }
            if (loadCachedLayoutNotification.isSetModCount()) {
                bitSet.set(2);
            }
            if (loadCachedLayoutNotification.isSetSortQueries()) {
                bitSet.set(3);
            }
            tTupleProtocol.writeBitSet(bitSet, 4);
            if (loadCachedLayoutNotification.isSetWindowState()) {
                loadCachedLayoutNotification.windowState.write((TProtocol)tTupleProtocol);
            }
            if (loadCachedLayoutNotification.isSetLayId()) {
                tTupleProtocol.writeI32(loadCachedLayoutNotification.layId);
            }
            if (loadCachedLayoutNotification.isSetModCount()) {
                tTupleProtocol.writeI64(loadCachedLayoutNotification.modCount);
            }
            if (loadCachedLayoutNotification.isSetSortQueries()) {
                tTupleProtocol.writeI32(loadCachedLayoutNotification.sortQueries.size());
                for (SortQuery sortQuery : loadCachedLayoutNotification.sortQueries) {
                    sortQuery.write((TProtocol)tTupleProtocol);
                }
            }
        }

        public void read(TProtocol tProtocol, LoadCachedLayoutNotification loadCachedLayoutNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(4);
            if (bitSet.get(0)) {
                loadCachedLayoutNotification.windowState = new WindowState();
                loadCachedLayoutNotification.windowState.read((TProtocol)tTupleProtocol);
                loadCachedLayoutNotification.setWindowStateIsSet(true);
            }
            if (bitSet.get(1)) {
                loadCachedLayoutNotification.layId = tTupleProtocol.readI32();
                loadCachedLayoutNotification.setLayIdIsSet(true);
            }
            if (bitSet.get(2)) {
                loadCachedLayoutNotification.modCount = tTupleProtocol.readI64();
                loadCachedLayoutNotification.setModCountIsSet(true);
            }
            if (bitSet.get(3)) {
                TList tList = tTupleProtocol.readListBegin((byte)12);
                loadCachedLayoutNotification.sortQueries = new ArrayList<SortQuery>(tList.size);
                for (int i = 0; i < tList.size; ++i) {
                    SortQuery sortQuery = new SortQuery();
                    sortQuery.read((TProtocol)tTupleProtocol);
                    loadCachedLayoutNotification.sortQueries.add(sortQuery);
                }
                loadCachedLayoutNotification.setSortQueriesIsSet(true);
            }
        }
    }

    private static class LoadCachedLayoutNotificationStandardScheme
    extends StandardScheme<LoadCachedLayoutNotification> {
        private LoadCachedLayoutNotificationStandardScheme() {
        }

        public void read(TProtocol tProtocol, LoadCachedLayoutNotification loadCachedLayoutNotification) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 12) {
                            loadCachedLayoutNotification.windowState = new WindowState();
                            loadCachedLayoutNotification.windowState.read(tProtocol);
                            loadCachedLayoutNotification.setWindowStateIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 8) {
                            loadCachedLayoutNotification.layId = tProtocol.readI32();
                            loadCachedLayoutNotification.setLayIdIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 10) {
                            loadCachedLayoutNotification.modCount = tProtocol.readI64();
                            loadCachedLayoutNotification.setModCountIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 15) {
                            TList tList = tProtocol.readListBegin();
                            loadCachedLayoutNotification.sortQueries = new ArrayList<SortQuery>(tList.size);
                            for (int i = 0; i < tList.size; ++i) {
                                SortQuery sortQuery = new SortQuery();
                                sortQuery.read(tProtocol);
                                loadCachedLayoutNotification.sortQueries.add(sortQuery);
                            }
                            tProtocol.readListEnd();
                            loadCachedLayoutNotification.setSortQueriesIsSet(true);
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
            loadCachedLayoutNotification.validate();
        }

        public void write(TProtocol tProtocol, LoadCachedLayoutNotification loadCachedLayoutNotification) throws TException {
            loadCachedLayoutNotification.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (loadCachedLayoutNotification.windowState != null) {
                tProtocol.writeFieldBegin(WINDOW_STATE_FIELD_DESC);
                loadCachedLayoutNotification.windowState.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(LAY_ID_FIELD_DESC);
            tProtocol.writeI32(loadCachedLayoutNotification.layId);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(MOD_COUNT_FIELD_DESC);
            tProtocol.writeI64(loadCachedLayoutNotification.modCount);
            tProtocol.writeFieldEnd();
            if (loadCachedLayoutNotification.sortQueries != null) {
                tProtocol.writeFieldBegin(SORT_QUERIES_FIELD_DESC);
                tProtocol.writeListBegin(new TList(12, loadCachedLayoutNotification.sortQueries.size()));
                for (SortQuery sortQuery : loadCachedLayoutNotification.sortQueries) {
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

