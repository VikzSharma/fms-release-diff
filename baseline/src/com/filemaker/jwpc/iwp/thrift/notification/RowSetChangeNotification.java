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
package com.filemaker.jwpc.iwp.thrift.notification;

import com.filemaker.jwpc.iwp.thrift.common.SortQuery;
import com.filemaker.jwpc.iwp.thrift.common.WindowState;
import com.filemaker.jwpc.iwp.thrift.notification.RowSetChangeType;
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

public class RowSetChangeNotification
implements TBase<RowSetChangeNotification, _Fields>,
Serializable,
Cloneable,
Comparable<RowSetChangeNotification> {
    private static final TStruct STRUCT_DESC = new TStruct("RowSetChangeNotification");
    private static final TField CHANGE_TYPE_FIELD_DESC = new TField("changeType", 8, 1);
    private static final TField WINDOW_STATE_FIELD_DESC = new TField("windowState", 12, 2);
    private static final TField AFFECTED_ROW_INDEX_FIELD_DESC = new TField("affectedRowIndex", 8, 3);
    private static final TField AFFECTED_ROW_ID_FIELD_DESC = new TField("affectedRowId", 8, 4);
    private static final TField SORT_QUERIES_FIELD_DESC = new TField("sortQueries", 15, 5);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new RowSetChangeNotificationStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new RowSetChangeNotificationTupleSchemeFactory();
    @Nullable
    private RowSetChangeType changeType;
    @Nullable
    private WindowState windowState;
    private int affectedRowIndex;
    private int affectedRowId;
    @Nullable
    private List<SortQuery> sortQueries;
    private static final int __AFFECTEDROWINDEX_ISSET_ID = 0;
    private static final int __AFFECTEDROWID_ISSET_ID = 1;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public RowSetChangeNotification() {
    }

    public RowSetChangeNotification(RowSetChangeType rowSetChangeType, WindowState windowState, int n, int n2, List<SortQuery> list) {
        this();
        this.changeType = rowSetChangeType;
        this.windowState = windowState;
        this.affectedRowIndex = n;
        this.setAffectedRowIndexIsSet(true);
        this.affectedRowId = n2;
        this.setAffectedRowIdIsSet(true);
        this.sortQueries = list;
    }

    public RowSetChangeNotification(RowSetChangeNotification rowSetChangeNotification) {
        this.__isset_bitfield = rowSetChangeNotification.__isset_bitfield;
        if (rowSetChangeNotification.isSetChangeType()) {
            this.changeType = rowSetChangeNotification.changeType;
        }
        if (rowSetChangeNotification.isSetWindowState()) {
            this.windowState = new WindowState(rowSetChangeNotification.windowState);
        }
        this.affectedRowIndex = rowSetChangeNotification.affectedRowIndex;
        this.affectedRowId = rowSetChangeNotification.affectedRowId;
        if (rowSetChangeNotification.isSetSortQueries()) {
            ArrayList<SortQuery> arrayList = new ArrayList<SortQuery>(rowSetChangeNotification.sortQueries.size());
            for (SortQuery sortQuery : rowSetChangeNotification.sortQueries) {
                arrayList.add(new SortQuery(sortQuery));
            }
            this.sortQueries = arrayList;
        }
    }

    public RowSetChangeNotification deepCopy() {
        return new RowSetChangeNotification(this);
    }

    public void clear() {
        this.changeType = null;
        this.windowState = null;
        this.setAffectedRowIndexIsSet(false);
        this.affectedRowIndex = 0;
        this.setAffectedRowIdIsSet(false);
        this.affectedRowId = 0;
        this.sortQueries = null;
    }

    @Nullable
    public RowSetChangeType getChangeType() {
        return this.changeType;
    }

    public void setChangeType(@Nullable RowSetChangeType rowSetChangeType) {
        this.changeType = rowSetChangeType;
    }

    public void unsetChangeType() {
        this.changeType = null;
    }

    public boolean isSetChangeType() {
        return this.changeType != null;
    }

    public void setChangeTypeIsSet(boolean bl) {
        if (!bl) {
            this.changeType = null;
        }
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

    public int getAffectedRowIndex() {
        return this.affectedRowIndex;
    }

    public void setAffectedRowIndex(int n) {
        this.affectedRowIndex = n;
        this.setAffectedRowIndexIsSet(true);
    }

    public void unsetAffectedRowIndex() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetAffectedRowIndex() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setAffectedRowIndexIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public int getAffectedRowId() {
        return this.affectedRowId;
    }

    public void setAffectedRowId(int n) {
        this.affectedRowId = n;
        this.setAffectedRowIdIsSet(true);
    }

    public void unsetAffectedRowId() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)1);
    }

    public boolean isSetAffectedRowId() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)1);
    }

    public void setAffectedRowIdIsSet(boolean bl) {
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
                    this.unsetChangeType();
                    break;
                }
                this.setChangeType((RowSetChangeType)((Object)object));
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetWindowState();
                    break;
                }
                this.setWindowState((WindowState)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetAffectedRowIndex();
                    break;
                }
                this.setAffectedRowIndex((Integer)object);
                break;
            }
            case 3: {
                if (object == null) {
                    this.unsetAffectedRowId();
                    break;
                }
                this.setAffectedRowId((Integer)object);
                break;
            }
            case 4: {
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
                return this.getChangeType();
            }
            case 1: {
                return this.getWindowState();
            }
            case 2: {
                return this.getAffectedRowIndex();
            }
            case 3: {
                return this.getAffectedRowId();
            }
            case 4: {
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
                return this.isSetChangeType();
            }
            case 1: {
                return this.isSetWindowState();
            }
            case 2: {
                return this.isSetAffectedRowIndex();
            }
            case 3: {
                return this.isSetAffectedRowId();
            }
            case 4: {
                return this.isSetSortQueries();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof RowSetChangeNotification) {
            return this.equals((RowSetChangeNotification)object);
        }
        return false;
    }

    public boolean equals(RowSetChangeNotification rowSetChangeNotification) {
        if (rowSetChangeNotification == null) {
            return false;
        }
        if (this == rowSetChangeNotification) {
            return true;
        }
        boolean bl = this.isSetChangeType();
        boolean bl2 = rowSetChangeNotification.isSetChangeType();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.changeType.equals((Object)rowSetChangeNotification.changeType)) {
                return false;
            }
        }
        boolean bl3 = this.isSetWindowState();
        boolean bl4 = rowSetChangeNotification.isSetWindowState();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.windowState.equals(rowSetChangeNotification.windowState)) {
                return false;
            }
        }
        boolean bl5 = true;
        boolean bl6 = true;
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (this.affectedRowIndex != rowSetChangeNotification.affectedRowIndex) {
                return false;
            }
        }
        boolean bl7 = true;
        boolean bl8 = true;
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (this.affectedRowId != rowSetChangeNotification.affectedRowId) {
                return false;
            }
        }
        boolean bl9 = this.isSetSortQueries();
        boolean bl10 = rowSetChangeNotification.isSetSortQueries();
        if (bl9 || bl10) {
            if (!bl9 || !bl10) {
                return false;
            }
            if (!this.sortQueries.equals(rowSetChangeNotification.sortQueries)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetChangeType() ? 131071 : 524287);
        if (this.isSetChangeType()) {
            n = n * 8191 + this.changeType.getValue();
        }
        n = n * 8191 + (this.isSetWindowState() ? 131071 : 524287);
        if (this.isSetWindowState()) {
            n = n * 8191 + this.windowState.hashCode();
        }
        n = n * 8191 + this.affectedRowIndex;
        n = n * 8191 + this.affectedRowId;
        n = n * 8191 + (this.isSetSortQueries() ? 131071 : 524287);
        if (this.isSetSortQueries()) {
            n = n * 8191 + this.sortQueries.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(RowSetChangeNotification rowSetChangeNotification) {
        if (!this.getClass().equals(rowSetChangeNotification.getClass())) {
            return this.getClass().getName().compareTo(rowSetChangeNotification.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetChangeType(), rowSetChangeNotification.isSetChangeType());
        if (n != 0) {
            return n;
        }
        if (this.isSetChangeType() && (n = TBaseHelper.compareTo((Comparable)((Object)this.changeType), (Comparable)((Object)rowSetChangeNotification.changeType))) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetWindowState(), rowSetChangeNotification.isSetWindowState());
        if (n != 0) {
            return n;
        }
        if (this.isSetWindowState() && (n = TBaseHelper.compareTo((Comparable)this.windowState, (Comparable)rowSetChangeNotification.windowState)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetAffectedRowIndex(), rowSetChangeNotification.isSetAffectedRowIndex());
        if (n != 0) {
            return n;
        }
        if (this.isSetAffectedRowIndex() && (n = TBaseHelper.compareTo((int)this.affectedRowIndex, (int)rowSetChangeNotification.affectedRowIndex)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetAffectedRowId(), rowSetChangeNotification.isSetAffectedRowId());
        if (n != 0) {
            return n;
        }
        if (this.isSetAffectedRowId() && (n = TBaseHelper.compareTo((int)this.affectedRowId, (int)rowSetChangeNotification.affectedRowId)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetSortQueries(), rowSetChangeNotification.isSetSortQueries());
        if (n != 0) {
            return n;
        }
        if (this.isSetSortQueries() && (n = TBaseHelper.compareTo(this.sortQueries, rowSetChangeNotification.sortQueries)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        RowSetChangeNotification.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        RowSetChangeNotification.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("RowSetChangeNotification(");
        boolean bl = true;
        stringBuilder.append("changeType:");
        if (this.changeType == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append((Object)this.changeType);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
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
        stringBuilder.append("affectedRowIndex:");
        stringBuilder.append(this.affectedRowIndex);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("affectedRowId:");
        stringBuilder.append(this.affectedRowId);
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
        enumMap.put(_Fields.CHANGE_TYPE, new FieldMetaData("changeType", 3, (FieldValueMetaData)new EnumMetaData(-1, RowSetChangeType.class)));
        enumMap.put(_Fields.WINDOW_STATE, new FieldMetaData("windowState", 3, (FieldValueMetaData)new StructMetaData(12, WindowState.class)));
        enumMap.put(_Fields.AFFECTED_ROW_INDEX, new FieldMetaData("affectedRowIndex", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.AFFECTED_ROW_ID, new FieldMetaData("affectedRowId", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.SORT_QUERIES, new FieldMetaData("sortQueries", 3, (FieldValueMetaData)new ListMetaData(15, (FieldValueMetaData)new StructMetaData(12, SortQuery.class))));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(RowSetChangeNotification.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        CHANGE_TYPE(1, "changeType"),
        WINDOW_STATE(2, "windowState"),
        AFFECTED_ROW_INDEX(3, "affectedRowIndex"),
        AFFECTED_ROW_ID(4, "affectedRowId"),
        SORT_QUERIES(5, "sortQueries");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return CHANGE_TYPE;
                }
                case 2: {
                    return WINDOW_STATE;
                }
                case 3: {
                    return AFFECTED_ROW_INDEX;
                }
                case 4: {
                    return AFFECTED_ROW_ID;
                }
                case 5: {
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

    private static class RowSetChangeNotificationStandardSchemeFactory
    implements SchemeFactory {
        private RowSetChangeNotificationStandardSchemeFactory() {
        }

        public RowSetChangeNotificationStandardScheme getScheme() {
            return new RowSetChangeNotificationStandardScheme();
        }
    }

    private static class RowSetChangeNotificationTupleSchemeFactory
    implements SchemeFactory {
        private RowSetChangeNotificationTupleSchemeFactory() {
        }

        public RowSetChangeNotificationTupleScheme getScheme() {
            return new RowSetChangeNotificationTupleScheme();
        }
    }

    private static class RowSetChangeNotificationTupleScheme
    extends TupleScheme<RowSetChangeNotification> {
        private RowSetChangeNotificationTupleScheme() {
        }

        public void write(TProtocol tProtocol, RowSetChangeNotification rowSetChangeNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (rowSetChangeNotification.isSetChangeType()) {
                bitSet.set(0);
            }
            if (rowSetChangeNotification.isSetWindowState()) {
                bitSet.set(1);
            }
            if (rowSetChangeNotification.isSetAffectedRowIndex()) {
                bitSet.set(2);
            }
            if (rowSetChangeNotification.isSetAffectedRowId()) {
                bitSet.set(3);
            }
            if (rowSetChangeNotification.isSetSortQueries()) {
                bitSet.set(4);
            }
            tTupleProtocol.writeBitSet(bitSet, 5);
            if (rowSetChangeNotification.isSetChangeType()) {
                tTupleProtocol.writeI32(rowSetChangeNotification.changeType.getValue());
            }
            if (rowSetChangeNotification.isSetWindowState()) {
                rowSetChangeNotification.windowState.write((TProtocol)tTupleProtocol);
            }
            if (rowSetChangeNotification.isSetAffectedRowIndex()) {
                tTupleProtocol.writeI32(rowSetChangeNotification.affectedRowIndex);
            }
            if (rowSetChangeNotification.isSetAffectedRowId()) {
                tTupleProtocol.writeI32(rowSetChangeNotification.affectedRowId);
            }
            if (rowSetChangeNotification.isSetSortQueries()) {
                tTupleProtocol.writeI32(rowSetChangeNotification.sortQueries.size());
                for (SortQuery sortQuery : rowSetChangeNotification.sortQueries) {
                    sortQuery.write((TProtocol)tTupleProtocol);
                }
            }
        }

        public void read(TProtocol tProtocol, RowSetChangeNotification rowSetChangeNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(5);
            if (bitSet.get(0)) {
                rowSetChangeNotification.changeType = RowSetChangeType.findByValue(tTupleProtocol.readI32());
                rowSetChangeNotification.setChangeTypeIsSet(true);
            }
            if (bitSet.get(1)) {
                rowSetChangeNotification.windowState = new WindowState();
                rowSetChangeNotification.windowState.read((TProtocol)tTupleProtocol);
                rowSetChangeNotification.setWindowStateIsSet(true);
            }
            if (bitSet.get(2)) {
                rowSetChangeNotification.affectedRowIndex = tTupleProtocol.readI32();
                rowSetChangeNotification.setAffectedRowIndexIsSet(true);
            }
            if (bitSet.get(3)) {
                rowSetChangeNotification.affectedRowId = tTupleProtocol.readI32();
                rowSetChangeNotification.setAffectedRowIdIsSet(true);
            }
            if (bitSet.get(4)) {
                TList tList = tTupleProtocol.readListBegin((byte)12);
                rowSetChangeNotification.sortQueries = new ArrayList<SortQuery>(tList.size);
                for (int i = 0; i < tList.size; ++i) {
                    SortQuery sortQuery = new SortQuery();
                    sortQuery.read((TProtocol)tTupleProtocol);
                    rowSetChangeNotification.sortQueries.add(sortQuery);
                }
                rowSetChangeNotification.setSortQueriesIsSet(true);
            }
        }
    }

    private static class RowSetChangeNotificationStandardScheme
    extends StandardScheme<RowSetChangeNotification> {
        private RowSetChangeNotificationStandardScheme() {
        }

        public void read(TProtocol tProtocol, RowSetChangeNotification rowSetChangeNotification) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 8) {
                            rowSetChangeNotification.changeType = RowSetChangeType.findByValue(tProtocol.readI32());
                            rowSetChangeNotification.setChangeTypeIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 12) {
                            rowSetChangeNotification.windowState = new WindowState();
                            rowSetChangeNotification.windowState.read(tProtocol);
                            rowSetChangeNotification.setWindowStateIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 8) {
                            rowSetChangeNotification.affectedRowIndex = tProtocol.readI32();
                            rowSetChangeNotification.setAffectedRowIndexIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 8) {
                            rowSetChangeNotification.affectedRowId = tProtocol.readI32();
                            rowSetChangeNotification.setAffectedRowIdIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 5: {
                        if (tField.type == 15) {
                            TList tList = tProtocol.readListBegin();
                            rowSetChangeNotification.sortQueries = new ArrayList<SortQuery>(tList.size);
                            for (int i = 0; i < tList.size; ++i) {
                                SortQuery sortQuery = new SortQuery();
                                sortQuery.read(tProtocol);
                                rowSetChangeNotification.sortQueries.add(sortQuery);
                            }
                            tProtocol.readListEnd();
                            rowSetChangeNotification.setSortQueriesIsSet(true);
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
            rowSetChangeNotification.validate();
        }

        public void write(TProtocol tProtocol, RowSetChangeNotification rowSetChangeNotification) throws TException {
            rowSetChangeNotification.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (rowSetChangeNotification.changeType != null) {
                tProtocol.writeFieldBegin(CHANGE_TYPE_FIELD_DESC);
                tProtocol.writeI32(rowSetChangeNotification.changeType.getValue());
                tProtocol.writeFieldEnd();
            }
            if (rowSetChangeNotification.windowState != null) {
                tProtocol.writeFieldBegin(WINDOW_STATE_FIELD_DESC);
                rowSetChangeNotification.windowState.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(AFFECTED_ROW_INDEX_FIELD_DESC);
            tProtocol.writeI32(rowSetChangeNotification.affectedRowIndex);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(AFFECTED_ROW_ID_FIELD_DESC);
            tProtocol.writeI32(rowSetChangeNotification.affectedRowId);
            tProtocol.writeFieldEnd();
            if (rowSetChangeNotification.sortQueries != null) {
                tProtocol.writeFieldBegin(SORT_QUERIES_FIELD_DESC);
                tProtocol.writeListBegin(new TList(12, rowSetChangeNotification.sortQueries.size()));
                for (SortQuery sortQuery : rowSetChangeNotification.sortQueries) {
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

