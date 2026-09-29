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
 *  org.apache.thrift.meta_data.StructMetaData
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
package com.filemaker.jwpc.iwp.thrift.notification;

import com.filemaker.jwpc.iwp.thrift.common.ImportMappingInfo;
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
import org.apache.thrift.meta_data.StructMetaData;
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

public class ImportMappingDialogNotification
implements TBase<ImportMappingDialogNotification, _Fields>,
Serializable,
Cloneable,
Comparable<ImportMappingDialogNotification> {
    private static final TStruct STRUCT_DESC = new TStruct("ImportMappingDialogNotification");
    private static final TField MAPPING_INFO_FIELD_DESC = new TField("mappingInfo", 12, 1);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new ImportMappingDialogNotificationStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new ImportMappingDialogNotificationTupleSchemeFactory();
    @Nullable
    private ImportMappingInfo mappingInfo;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public ImportMappingDialogNotification() {
    }

    public ImportMappingDialogNotification(ImportMappingInfo importMappingInfo) {
        this();
        this.mappingInfo = importMappingInfo;
    }

    public ImportMappingDialogNotification(ImportMappingDialogNotification importMappingDialogNotification) {
        if (importMappingDialogNotification.isSetMappingInfo()) {
            this.mappingInfo = new ImportMappingInfo(importMappingDialogNotification.mappingInfo);
        }
    }

    public ImportMappingDialogNotification deepCopy() {
        return new ImportMappingDialogNotification(this);
    }

    public void clear() {
        this.mappingInfo = null;
    }

    @Nullable
    public ImportMappingInfo getMappingInfo() {
        return this.mappingInfo;
    }

    public void setMappingInfo(@Nullable ImportMappingInfo importMappingInfo) {
        this.mappingInfo = importMappingInfo;
    }

    public void unsetMappingInfo() {
        this.mappingInfo = null;
    }

    public boolean isSetMappingInfo() {
        return this.mappingInfo != null;
    }

    public void setMappingInfoIsSet(boolean bl) {
        if (!bl) {
            this.mappingInfo = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetMappingInfo();
                    break;
                }
                this.setMappingInfo((ImportMappingInfo)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getMappingInfo();
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
                return this.isSetMappingInfo();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof ImportMappingDialogNotification) {
            return this.equals((ImportMappingDialogNotification)object);
        }
        return false;
    }

    public boolean equals(ImportMappingDialogNotification importMappingDialogNotification) {
        if (importMappingDialogNotification == null) {
            return false;
        }
        if (this == importMappingDialogNotification) {
            return true;
        }
        boolean bl = this.isSetMappingInfo();
        boolean bl2 = importMappingDialogNotification.isSetMappingInfo();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.mappingInfo.equals(importMappingDialogNotification.mappingInfo)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetMappingInfo() ? 131071 : 524287);
        if (this.isSetMappingInfo()) {
            n = n * 8191 + this.mappingInfo.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(ImportMappingDialogNotification importMappingDialogNotification) {
        if (!this.getClass().equals(importMappingDialogNotification.getClass())) {
            return this.getClass().getName().compareTo(importMappingDialogNotification.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetMappingInfo(), importMappingDialogNotification.isSetMappingInfo());
        if (n != 0) {
            return n;
        }
        if (this.isSetMappingInfo() && (n = TBaseHelper.compareTo((Comparable)this.mappingInfo, (Comparable)importMappingDialogNotification.mappingInfo)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        ImportMappingDialogNotification.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        ImportMappingDialogNotification.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ImportMappingDialogNotification(");
        boolean bl = true;
        stringBuilder.append("mappingInfo:");
        if (this.mappingInfo == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.mappingInfo);
        }
        bl = false;
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void validate() throws TException {
        if (this.mappingInfo != null) {
            this.mappingInfo.validate();
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
        enumMap.put(_Fields.MAPPING_INFO, new FieldMetaData("mappingInfo", 3, (FieldValueMetaData)new StructMetaData(12, ImportMappingInfo.class)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(ImportMappingDialogNotification.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        MAPPING_INFO(1, "mappingInfo");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return MAPPING_INFO;
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

    private static class ImportMappingDialogNotificationStandardSchemeFactory
    implements SchemeFactory {
        private ImportMappingDialogNotificationStandardSchemeFactory() {
        }

        public ImportMappingDialogNotificationStandardScheme getScheme() {
            return new ImportMappingDialogNotificationStandardScheme();
        }
    }

    private static class ImportMappingDialogNotificationTupleSchemeFactory
    implements SchemeFactory {
        private ImportMappingDialogNotificationTupleSchemeFactory() {
        }

        public ImportMappingDialogNotificationTupleScheme getScheme() {
            return new ImportMappingDialogNotificationTupleScheme();
        }
    }

    private static class ImportMappingDialogNotificationTupleScheme
    extends TupleScheme<ImportMappingDialogNotification> {
        private ImportMappingDialogNotificationTupleScheme() {
        }

        public void write(TProtocol tProtocol, ImportMappingDialogNotification importMappingDialogNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (importMappingDialogNotification.isSetMappingInfo()) {
                bitSet.set(0);
            }
            tTupleProtocol.writeBitSet(bitSet, 1);
            if (importMappingDialogNotification.isSetMappingInfo()) {
                importMappingDialogNotification.mappingInfo.write((TProtocol)tTupleProtocol);
            }
        }

        public void read(TProtocol tProtocol, ImportMappingDialogNotification importMappingDialogNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(1);
            if (bitSet.get(0)) {
                importMappingDialogNotification.mappingInfo = new ImportMappingInfo();
                importMappingDialogNotification.mappingInfo.read((TProtocol)tTupleProtocol);
                importMappingDialogNotification.setMappingInfoIsSet(true);
            }
        }
    }

    private static class ImportMappingDialogNotificationStandardScheme
    extends StandardScheme<ImportMappingDialogNotification> {
        private ImportMappingDialogNotificationStandardScheme() {
        }

        public void read(TProtocol tProtocol, ImportMappingDialogNotification importMappingDialogNotification) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 12) {
                            importMappingDialogNotification.mappingInfo = new ImportMappingInfo();
                            importMappingDialogNotification.mappingInfo.read(tProtocol);
                            importMappingDialogNotification.setMappingInfoIsSet(true);
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
            importMappingDialogNotification.validate();
        }

        public void write(TProtocol tProtocol, ImportMappingDialogNotification importMappingDialogNotification) throws TException {
            importMappingDialogNotification.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (importMappingDialogNotification.mappingInfo != null) {
                tProtocol.writeFieldBegin(MAPPING_INFO_FIELD_DESC);
                importMappingDialogNotification.mappingInfo.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

