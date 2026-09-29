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
package com.filemaker.jwpc.iwp.thrift.common;

import com.filemaker.jwpc.iwp.thrift.common.IWPError;
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

public class DatabaseNamesResult
implements TBase<DatabaseNamesResult, _Fields>,
Serializable,
Cloneable,
Comparable<DatabaseNamesResult> {
    private static final TStruct STRUCT_DESC = new TStruct("DatabaseNamesResult");
    private static final TField DATABASE_NAMES_FIELD_DESC = new TField("databaseNames", 15, 1);
    private static final TField ERROR_FIELD_DESC = new TField("error", 12, 2);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new DatabaseNamesResultStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new DatabaseNamesResultTupleSchemeFactory();
    @Nullable
    private List<String> databaseNames;
    @Nullable
    private IWPError error;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public DatabaseNamesResult() {
    }

    public DatabaseNamesResult(List<String> list, IWPError iWPError) {
        this();
        this.databaseNames = list;
        this.error = iWPError;
    }

    public DatabaseNamesResult(DatabaseNamesResult databaseNamesResult) {
        if (databaseNamesResult.isSetDatabaseNames()) {
            ArrayList<String> arrayList = new ArrayList<String>(databaseNamesResult.databaseNames);
            this.databaseNames = arrayList;
        }
        if (databaseNamesResult.isSetError()) {
            this.error = new IWPError(databaseNamesResult.error);
        }
    }

    public DatabaseNamesResult deepCopy() {
        return new DatabaseNamesResult(this);
    }

    public void clear() {
        this.databaseNames = null;
        this.error = null;
    }

    public int getDatabaseNamesSize() {
        return this.databaseNames == null ? 0 : this.databaseNames.size();
    }

    @Nullable
    public Iterator<String> getDatabaseNamesIterator() {
        return this.databaseNames == null ? null : this.databaseNames.iterator();
    }

    public void addToDatabaseNames(String string) {
        if (this.databaseNames == null) {
            this.databaseNames = new ArrayList<String>();
        }
        this.databaseNames.add(string);
    }

    @Nullable
    public List<String> getDatabaseNames() {
        return this.databaseNames;
    }

    public void setDatabaseNames(@Nullable List<String> list) {
        this.databaseNames = list;
    }

    public void unsetDatabaseNames() {
        this.databaseNames = null;
    }

    public boolean isSetDatabaseNames() {
        return this.databaseNames != null;
    }

    public void setDatabaseNamesIsSet(boolean bl) {
        if (!bl) {
            this.databaseNames = null;
        }
    }

    @Nullable
    public IWPError getError() {
        return this.error;
    }

    public void setError(@Nullable IWPError iWPError) {
        this.error = iWPError;
    }

    public void unsetError() {
        this.error = null;
    }

    public boolean isSetError() {
        return this.error != null;
    }

    public void setErrorIsSet(boolean bl) {
        if (!bl) {
            this.error = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetDatabaseNames();
                    break;
                }
                this.setDatabaseNames((List)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetError();
                    break;
                }
                this.setError((IWPError)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getDatabaseNames();
            }
            case 1: {
                return this.getError();
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
                return this.isSetDatabaseNames();
            }
            case 1: {
                return this.isSetError();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof DatabaseNamesResult) {
            return this.equals((DatabaseNamesResult)object);
        }
        return false;
    }

    public boolean equals(DatabaseNamesResult databaseNamesResult) {
        if (databaseNamesResult == null) {
            return false;
        }
        if (this == databaseNamesResult) {
            return true;
        }
        boolean bl = this.isSetDatabaseNames();
        boolean bl2 = databaseNamesResult.isSetDatabaseNames();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.databaseNames.equals(databaseNamesResult.databaseNames)) {
                return false;
            }
        }
        boolean bl3 = this.isSetError();
        boolean bl4 = databaseNamesResult.isSetError();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.error.equals(databaseNamesResult.error)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetDatabaseNames() ? 131071 : 524287);
        if (this.isSetDatabaseNames()) {
            n = n * 8191 + this.databaseNames.hashCode();
        }
        n = n * 8191 + (this.isSetError() ? 131071 : 524287);
        if (this.isSetError()) {
            n = n * 8191 + this.error.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(DatabaseNamesResult databaseNamesResult) {
        if (!this.getClass().equals(databaseNamesResult.getClass())) {
            return this.getClass().getName().compareTo(databaseNamesResult.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetDatabaseNames(), databaseNamesResult.isSetDatabaseNames());
        if (n != 0) {
            return n;
        }
        if (this.isSetDatabaseNames() && (n = TBaseHelper.compareTo(this.databaseNames, databaseNamesResult.databaseNames)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetError(), databaseNamesResult.isSetError());
        if (n != 0) {
            return n;
        }
        if (this.isSetError() && (n = TBaseHelper.compareTo((Comparable)this.error, (Comparable)databaseNamesResult.error)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        DatabaseNamesResult.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        DatabaseNamesResult.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("DatabaseNamesResult(");
        boolean bl = true;
        stringBuilder.append("databaseNames:");
        if (this.databaseNames == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.databaseNames);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("error:");
        if (this.error == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.error);
        }
        bl = false;
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void validate() throws TException {
        if (this.error != null) {
            this.error.validate();
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
        enumMap.put(_Fields.DATABASE_NAMES, new FieldMetaData("databaseNames", 3, (FieldValueMetaData)new ListMetaData(15, new FieldValueMetaData(11))));
        enumMap.put(_Fields.ERROR, new FieldMetaData("error", 3, (FieldValueMetaData)new StructMetaData(12, IWPError.class)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(DatabaseNamesResult.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        DATABASE_NAMES(1, "databaseNames"),
        ERROR(2, "error");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return DATABASE_NAMES;
                }
                case 2: {
                    return ERROR;
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

    private static class DatabaseNamesResultStandardSchemeFactory
    implements SchemeFactory {
        private DatabaseNamesResultStandardSchemeFactory() {
        }

        public DatabaseNamesResultStandardScheme getScheme() {
            return new DatabaseNamesResultStandardScheme();
        }
    }

    private static class DatabaseNamesResultTupleSchemeFactory
    implements SchemeFactory {
        private DatabaseNamesResultTupleSchemeFactory() {
        }

        public DatabaseNamesResultTupleScheme getScheme() {
            return new DatabaseNamesResultTupleScheme();
        }
    }

    private static class DatabaseNamesResultTupleScheme
    extends TupleScheme<DatabaseNamesResult> {
        private DatabaseNamesResultTupleScheme() {
        }

        public void write(TProtocol tProtocol, DatabaseNamesResult databaseNamesResult) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (databaseNamesResult.isSetDatabaseNames()) {
                bitSet.set(0);
            }
            if (databaseNamesResult.isSetError()) {
                bitSet.set(1);
            }
            tTupleProtocol.writeBitSet(bitSet, 2);
            if (databaseNamesResult.isSetDatabaseNames()) {
                tTupleProtocol.writeI32(databaseNamesResult.databaseNames.size());
                for (String string : databaseNamesResult.databaseNames) {
                    tTupleProtocol.writeString(string);
                }
            }
            if (databaseNamesResult.isSetError()) {
                databaseNamesResult.error.write((TProtocol)tTupleProtocol);
            }
        }

        public void read(TProtocol tProtocol, DatabaseNamesResult databaseNamesResult) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(2);
            if (bitSet.get(0)) {
                TList tList = tTupleProtocol.readListBegin((byte)11);
                databaseNamesResult.databaseNames = new ArrayList<String>(tList.size);
                for (int i = 0; i < tList.size; ++i) {
                    String string = tTupleProtocol.readString();
                    databaseNamesResult.databaseNames.add(string);
                }
                databaseNamesResult.setDatabaseNamesIsSet(true);
            }
            if (bitSet.get(1)) {
                databaseNamesResult.error = new IWPError();
                databaseNamesResult.error.read((TProtocol)tTupleProtocol);
                databaseNamesResult.setErrorIsSet(true);
            }
        }
    }

    private static class DatabaseNamesResultStandardScheme
    extends StandardScheme<DatabaseNamesResult> {
        private DatabaseNamesResultStandardScheme() {
        }

        public void read(TProtocol tProtocol, DatabaseNamesResult databaseNamesResult) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 15) {
                            TList tList = tProtocol.readListBegin();
                            databaseNamesResult.databaseNames = new ArrayList<String>(tList.size);
                            for (int i = 0; i < tList.size; ++i) {
                                String string = tProtocol.readString();
                                databaseNamesResult.databaseNames.add(string);
                            }
                            tProtocol.readListEnd();
                            databaseNamesResult.setDatabaseNamesIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 12) {
                            databaseNamesResult.error = new IWPError();
                            databaseNamesResult.error.read(tProtocol);
                            databaseNamesResult.setErrorIsSet(true);
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
            databaseNamesResult.validate();
        }

        public void write(TProtocol tProtocol, DatabaseNamesResult databaseNamesResult) throws TException {
            databaseNamesResult.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (databaseNamesResult.databaseNames != null) {
                tProtocol.writeFieldBegin(DATABASE_NAMES_FIELD_DESC);
                tProtocol.writeListBegin(new TList(11, databaseNamesResult.databaseNames.size()));
                for (String string : databaseNamesResult.databaseNames) {
                    tProtocol.writeString(string);
                }
                tProtocol.writeListEnd();
                tProtocol.writeFieldEnd();
            }
            if (databaseNamesResult.error != null) {
                tProtocol.writeFieldBegin(ERROR_FIELD_DESC);
                databaseNamesResult.error.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

