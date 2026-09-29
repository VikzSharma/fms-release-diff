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
package com.filemaker.jwpc.iwp.thrift.common;

import com.filemaker.jwpc.iwp.thrift.common.DatabaseData;
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

public class DatabasesDataResult
implements TBase<DatabasesDataResult, _Fields>,
Serializable,
Cloneable,
Comparable<DatabasesDataResult> {
    private static final TStruct STRUCT_DESC = new TStruct("DatabasesDataResult");
    private static final TField DATABASES_DATA_FIELD_DESC = new TField("databasesData", 15, 1);
    private static final TField ERROR_FIELD_DESC = new TField("error", 12, 2);
    private static final TField FM_SELF_SIGNED_CERT_INSTALLED_FIELD_DESC = new TField("fmSelfSignedCertInstalled", 2, 3);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new DatabasesDataResultStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new DatabasesDataResultTupleSchemeFactory();
    @Nullable
    private List<DatabaseData> databasesData;
    @Nullable
    private IWPError error;
    private boolean fmSelfSignedCertInstalled;
    private static final int __FMSELFSIGNEDCERTINSTALLED_ISSET_ID = 0;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public DatabasesDataResult() {
    }

    public DatabasesDataResult(List<DatabaseData> list, IWPError iWPError, boolean bl) {
        this();
        this.databasesData = list;
        this.error = iWPError;
        this.fmSelfSignedCertInstalled = bl;
        this.setFmSelfSignedCertInstalledIsSet(true);
    }

    public DatabasesDataResult(DatabasesDataResult databasesDataResult) {
        this.__isset_bitfield = databasesDataResult.__isset_bitfield;
        if (databasesDataResult.isSetDatabasesData()) {
            ArrayList<DatabaseData> arrayList = new ArrayList<DatabaseData>(databasesDataResult.databasesData.size());
            for (DatabaseData databaseData : databasesDataResult.databasesData) {
                arrayList.add(new DatabaseData(databaseData));
            }
            this.databasesData = arrayList;
        }
        if (databasesDataResult.isSetError()) {
            this.error = new IWPError(databasesDataResult.error);
        }
        this.fmSelfSignedCertInstalled = databasesDataResult.fmSelfSignedCertInstalled;
    }

    public DatabasesDataResult deepCopy() {
        return new DatabasesDataResult(this);
    }

    public void clear() {
        this.databasesData = null;
        this.error = null;
        this.setFmSelfSignedCertInstalledIsSet(false);
        this.fmSelfSignedCertInstalled = false;
    }

    public int getDatabasesDataSize() {
        return this.databasesData == null ? 0 : this.databasesData.size();
    }

    @Nullable
    public Iterator<DatabaseData> getDatabasesDataIterator() {
        return this.databasesData == null ? null : this.databasesData.iterator();
    }

    public void addToDatabasesData(DatabaseData databaseData) {
        if (this.databasesData == null) {
            this.databasesData = new ArrayList<DatabaseData>();
        }
        this.databasesData.add(databaseData);
    }

    @Nullable
    public List<DatabaseData> getDatabasesData() {
        return this.databasesData;
    }

    public void setDatabasesData(@Nullable List<DatabaseData> list) {
        this.databasesData = list;
    }

    public void unsetDatabasesData() {
        this.databasesData = null;
    }

    public boolean isSetDatabasesData() {
        return this.databasesData != null;
    }

    public void setDatabasesDataIsSet(boolean bl) {
        if (!bl) {
            this.databasesData = null;
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

    public boolean isFmSelfSignedCertInstalled() {
        return this.fmSelfSignedCertInstalled;
    }

    public void setFmSelfSignedCertInstalled(boolean bl) {
        this.fmSelfSignedCertInstalled = bl;
        this.setFmSelfSignedCertInstalledIsSet(true);
    }

    public void unsetFmSelfSignedCertInstalled() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetFmSelfSignedCertInstalled() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setFmSelfSignedCertInstalledIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetDatabasesData();
                    break;
                }
                this.setDatabasesData((List)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetError();
                    break;
                }
                this.setError((IWPError)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetFmSelfSignedCertInstalled();
                    break;
                }
                this.setFmSelfSignedCertInstalled((Boolean)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getDatabasesData();
            }
            case 1: {
                return this.getError();
            }
            case 2: {
                return this.isFmSelfSignedCertInstalled();
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
                return this.isSetDatabasesData();
            }
            case 1: {
                return this.isSetError();
            }
            case 2: {
                return this.isSetFmSelfSignedCertInstalled();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof DatabasesDataResult) {
            return this.equals((DatabasesDataResult)object);
        }
        return false;
    }

    public boolean equals(DatabasesDataResult databasesDataResult) {
        if (databasesDataResult == null) {
            return false;
        }
        if (this == databasesDataResult) {
            return true;
        }
        boolean bl = this.isSetDatabasesData();
        boolean bl2 = databasesDataResult.isSetDatabasesData();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.databasesData.equals(databasesDataResult.databasesData)) {
                return false;
            }
        }
        boolean bl3 = this.isSetError();
        boolean bl4 = databasesDataResult.isSetError();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.error.equals(databasesDataResult.error)) {
                return false;
            }
        }
        boolean bl5 = true;
        boolean bl6 = true;
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (this.fmSelfSignedCertInstalled != databasesDataResult.fmSelfSignedCertInstalled) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetDatabasesData() ? 131071 : 524287);
        if (this.isSetDatabasesData()) {
            n = n * 8191 + this.databasesData.hashCode();
        }
        n = n * 8191 + (this.isSetError() ? 131071 : 524287);
        if (this.isSetError()) {
            n = n * 8191 + this.error.hashCode();
        }
        n = n * 8191 + (this.fmSelfSignedCertInstalled ? 131071 : 524287);
        return n;
    }

    @Override
    public int compareTo(DatabasesDataResult databasesDataResult) {
        if (!this.getClass().equals(databasesDataResult.getClass())) {
            return this.getClass().getName().compareTo(databasesDataResult.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetDatabasesData(), databasesDataResult.isSetDatabasesData());
        if (n != 0) {
            return n;
        }
        if (this.isSetDatabasesData() && (n = TBaseHelper.compareTo(this.databasesData, databasesDataResult.databasesData)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetError(), databasesDataResult.isSetError());
        if (n != 0) {
            return n;
        }
        if (this.isSetError() && (n = TBaseHelper.compareTo((Comparable)this.error, (Comparable)databasesDataResult.error)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetFmSelfSignedCertInstalled(), databasesDataResult.isSetFmSelfSignedCertInstalled());
        if (n != 0) {
            return n;
        }
        if (this.isSetFmSelfSignedCertInstalled() && (n = TBaseHelper.compareTo((boolean)this.fmSelfSignedCertInstalled, (boolean)databasesDataResult.fmSelfSignedCertInstalled)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        DatabasesDataResult.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        DatabasesDataResult.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("DatabasesDataResult(");
        boolean bl = true;
        stringBuilder.append("databasesData:");
        if (this.databasesData == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.databasesData);
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
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("fmSelfSignedCertInstalled:");
        stringBuilder.append(this.fmSelfSignedCertInstalled);
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
        enumMap.put(_Fields.DATABASES_DATA, new FieldMetaData("databasesData", 3, (FieldValueMetaData)new ListMetaData(15, (FieldValueMetaData)new StructMetaData(12, DatabaseData.class))));
        enumMap.put(_Fields.ERROR, new FieldMetaData("error", 3, (FieldValueMetaData)new StructMetaData(12, IWPError.class)));
        enumMap.put(_Fields.FM_SELF_SIGNED_CERT_INSTALLED, new FieldMetaData("fmSelfSignedCertInstalled", 3, new FieldValueMetaData(2)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(DatabasesDataResult.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        DATABASES_DATA(1, "databasesData"),
        ERROR(2, "error"),
        FM_SELF_SIGNED_CERT_INSTALLED(3, "fmSelfSignedCertInstalled");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return DATABASES_DATA;
                }
                case 2: {
                    return ERROR;
                }
                case 3: {
                    return FM_SELF_SIGNED_CERT_INSTALLED;
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

    private static class DatabasesDataResultStandardSchemeFactory
    implements SchemeFactory {
        private DatabasesDataResultStandardSchemeFactory() {
        }

        public DatabasesDataResultStandardScheme getScheme() {
            return new DatabasesDataResultStandardScheme();
        }
    }

    private static class DatabasesDataResultTupleSchemeFactory
    implements SchemeFactory {
        private DatabasesDataResultTupleSchemeFactory() {
        }

        public DatabasesDataResultTupleScheme getScheme() {
            return new DatabasesDataResultTupleScheme();
        }
    }

    private static class DatabasesDataResultTupleScheme
    extends TupleScheme<DatabasesDataResult> {
        private DatabasesDataResultTupleScheme() {
        }

        public void write(TProtocol tProtocol, DatabasesDataResult databasesDataResult) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (databasesDataResult.isSetDatabasesData()) {
                bitSet.set(0);
            }
            if (databasesDataResult.isSetError()) {
                bitSet.set(1);
            }
            if (databasesDataResult.isSetFmSelfSignedCertInstalled()) {
                bitSet.set(2);
            }
            tTupleProtocol.writeBitSet(bitSet, 3);
            if (databasesDataResult.isSetDatabasesData()) {
                tTupleProtocol.writeI32(databasesDataResult.databasesData.size());
                for (DatabaseData databaseData : databasesDataResult.databasesData) {
                    databaseData.write((TProtocol)tTupleProtocol);
                }
            }
            if (databasesDataResult.isSetError()) {
                databasesDataResult.error.write((TProtocol)tTupleProtocol);
            }
            if (databasesDataResult.isSetFmSelfSignedCertInstalled()) {
                tTupleProtocol.writeBool(databasesDataResult.fmSelfSignedCertInstalled);
            }
        }

        public void read(TProtocol tProtocol, DatabasesDataResult databasesDataResult) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(3);
            if (bitSet.get(0)) {
                TList tList = tTupleProtocol.readListBegin((byte)12);
                databasesDataResult.databasesData = new ArrayList<DatabaseData>(tList.size);
                for (int i = 0; i < tList.size; ++i) {
                    DatabaseData databaseData = new DatabaseData();
                    databaseData.read((TProtocol)tTupleProtocol);
                    databasesDataResult.databasesData.add(databaseData);
                }
                databasesDataResult.setDatabasesDataIsSet(true);
            }
            if (bitSet.get(1)) {
                databasesDataResult.error = new IWPError();
                databasesDataResult.error.read((TProtocol)tTupleProtocol);
                databasesDataResult.setErrorIsSet(true);
            }
            if (bitSet.get(2)) {
                databasesDataResult.fmSelfSignedCertInstalled = tTupleProtocol.readBool();
                databasesDataResult.setFmSelfSignedCertInstalledIsSet(true);
            }
        }
    }

    private static class DatabasesDataResultStandardScheme
    extends StandardScheme<DatabasesDataResult> {
        private DatabasesDataResultStandardScheme() {
        }

        public void read(TProtocol tProtocol, DatabasesDataResult databasesDataResult) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 15) {
                            TList tList = tProtocol.readListBegin();
                            databasesDataResult.databasesData = new ArrayList<DatabaseData>(tList.size);
                            for (int i = 0; i < tList.size; ++i) {
                                DatabaseData databaseData = new DatabaseData();
                                databaseData.read(tProtocol);
                                databasesDataResult.databasesData.add(databaseData);
                            }
                            tProtocol.readListEnd();
                            databasesDataResult.setDatabasesDataIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 12) {
                            databasesDataResult.error = new IWPError();
                            databasesDataResult.error.read(tProtocol);
                            databasesDataResult.setErrorIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 2) {
                            databasesDataResult.fmSelfSignedCertInstalled = tProtocol.readBool();
                            databasesDataResult.setFmSelfSignedCertInstalledIsSet(true);
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
            databasesDataResult.validate();
        }

        public void write(TProtocol tProtocol, DatabasesDataResult databasesDataResult) throws TException {
            databasesDataResult.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (databasesDataResult.databasesData != null) {
                tProtocol.writeFieldBegin(DATABASES_DATA_FIELD_DESC);
                tProtocol.writeListBegin(new TList(12, databasesDataResult.databasesData.size()));
                for (DatabaseData databaseData : databasesDataResult.databasesData) {
                    databaseData.write(tProtocol);
                }
                tProtocol.writeListEnd();
                tProtocol.writeFieldEnd();
            }
            if (databasesDataResult.error != null) {
                tProtocol.writeFieldBegin(ERROR_FIELD_DESC);
                databasesDataResult.error.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(FM_SELF_SIGNED_CERT_INSTALLED_FIELD_DESC);
            tProtocol.writeBool(databasesDataResult.fmSelfSignedCertInstalled);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

