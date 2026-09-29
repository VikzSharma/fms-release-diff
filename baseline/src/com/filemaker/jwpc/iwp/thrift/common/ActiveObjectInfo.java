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
package com.filemaker.jwpc.iwp.thrift.common;

import com.filemaker.jwpc.iwp.thrift.common.ObjectSpec;
import com.filemaker.jwpc.iwp.thrift.common.StringData;
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
import org.apache.thrift.EncodingUtils;
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

public class ActiveObjectInfo
implements TBase<ActiveObjectInfo, _Fields>,
Serializable,
Cloneable,
Comparable<ActiveObjectInfo> {
    private static final TStruct STRUCT_DESC = new TStruct("ActiveObjectInfo");
    private static final TField OBJECT_SPEC_FIELD_DESC = new TField("objectSpec", 12, 1);
    private static final TField DATA_FIELD_DESC = new TField("data", 12, 2);
    private static final TField UPDATE_SELECTION_FIELD_DESC = new TField("updateSelection", 2, 3);
    private static final TField SELECT_ALL_FIELD_DESC = new TField("selectAll", 2, 4);
    private static final TField SELECTION_START_FIELD_DESC = new TField("selectionStart", 8, 5);
    private static final TField SELECTION_END_FIELD_DESC = new TField("selectionEnd", 8, 6);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new ActiveObjectInfoStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new ActiveObjectInfoTupleSchemeFactory();
    @Nullable
    private ObjectSpec objectSpec;
    @Nullable
    private StringData data;
    private boolean updateSelection;
    private boolean selectAll;
    private int selectionStart;
    private int selectionEnd;
    private static final int __UPDATESELECTION_ISSET_ID = 0;
    private static final int __SELECTALL_ISSET_ID = 1;
    private static final int __SELECTIONSTART_ISSET_ID = 2;
    private static final int __SELECTIONEND_ISSET_ID = 3;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public ActiveObjectInfo() {
        this.selectionStart = 0;
        this.selectionEnd = 0;
    }

    public ActiveObjectInfo(ObjectSpec objectSpec, StringData stringData, boolean bl, boolean bl2, int n, int n2) {
        this();
        this.objectSpec = objectSpec;
        this.data = stringData;
        this.updateSelection = bl;
        this.setUpdateSelectionIsSet(true);
        this.selectAll = bl2;
        this.setSelectAllIsSet(true);
        this.selectionStart = n;
        this.setSelectionStartIsSet(true);
        this.selectionEnd = n2;
        this.setSelectionEndIsSet(true);
    }

    public ActiveObjectInfo(ActiveObjectInfo activeObjectInfo) {
        this.__isset_bitfield = activeObjectInfo.__isset_bitfield;
        if (activeObjectInfo.isSetObjectSpec()) {
            this.objectSpec = new ObjectSpec(activeObjectInfo.objectSpec);
        }
        if (activeObjectInfo.isSetData()) {
            this.data = new StringData(activeObjectInfo.data);
        }
        this.updateSelection = activeObjectInfo.updateSelection;
        this.selectAll = activeObjectInfo.selectAll;
        this.selectionStart = activeObjectInfo.selectionStart;
        this.selectionEnd = activeObjectInfo.selectionEnd;
    }

    public ActiveObjectInfo deepCopy() {
        return new ActiveObjectInfo(this);
    }

    public void clear() {
        this.objectSpec = null;
        this.data = null;
        this.setUpdateSelectionIsSet(false);
        this.updateSelection = false;
        this.setSelectAllIsSet(false);
        this.selectAll = false;
        this.selectionStart = 0;
        this.selectionEnd = 0;
    }

    @Nullable
    public ObjectSpec getObjectSpec() {
        return this.objectSpec;
    }

    public void setObjectSpec(@Nullable ObjectSpec objectSpec) {
        this.objectSpec = objectSpec;
    }

    public void unsetObjectSpec() {
        this.objectSpec = null;
    }

    public boolean isSetObjectSpec() {
        return this.objectSpec != null;
    }

    public void setObjectSpecIsSet(boolean bl) {
        if (!bl) {
            this.objectSpec = null;
        }
    }

    @Nullable
    public StringData getData() {
        return this.data;
    }

    public void setData(@Nullable StringData stringData) {
        this.data = stringData;
    }

    public void unsetData() {
        this.data = null;
    }

    public boolean isSetData() {
        return this.data != null;
    }

    public void setDataIsSet(boolean bl) {
        if (!bl) {
            this.data = null;
        }
    }

    public boolean isUpdateSelection() {
        return this.updateSelection;
    }

    public void setUpdateSelection(boolean bl) {
        this.updateSelection = bl;
        this.setUpdateSelectionIsSet(true);
    }

    public void unsetUpdateSelection() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetUpdateSelection() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setUpdateSelectionIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public boolean isSelectAll() {
        return this.selectAll;
    }

    public void setSelectAll(boolean bl) {
        this.selectAll = bl;
        this.setSelectAllIsSet(true);
    }

    public void unsetSelectAll() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)1);
    }

    public boolean isSetSelectAll() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)1);
    }

    public void setSelectAllIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)1, (boolean)bl);
    }

    public int getSelectionStart() {
        return this.selectionStart;
    }

    public void setSelectionStart(int n) {
        this.selectionStart = n;
        this.setSelectionStartIsSet(true);
    }

    public void unsetSelectionStart() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)2);
    }

    public boolean isSetSelectionStart() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)2);
    }

    public void setSelectionStartIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)2, (boolean)bl);
    }

    public int getSelectionEnd() {
        return this.selectionEnd;
    }

    public void setSelectionEnd(int n) {
        this.selectionEnd = n;
        this.setSelectionEndIsSet(true);
    }

    public void unsetSelectionEnd() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)3);
    }

    public boolean isSetSelectionEnd() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)3);
    }

    public void setSelectionEndIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)3, (boolean)bl);
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetObjectSpec();
                    break;
                }
                this.setObjectSpec((ObjectSpec)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetData();
                    break;
                }
                this.setData((StringData)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetUpdateSelection();
                    break;
                }
                this.setUpdateSelection((Boolean)object);
                break;
            }
            case 3: {
                if (object == null) {
                    this.unsetSelectAll();
                    break;
                }
                this.setSelectAll((Boolean)object);
                break;
            }
            case 4: {
                if (object == null) {
                    this.unsetSelectionStart();
                    break;
                }
                this.setSelectionStart((Integer)object);
                break;
            }
            case 5: {
                if (object == null) {
                    this.unsetSelectionEnd();
                    break;
                }
                this.setSelectionEnd((Integer)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getObjectSpec();
            }
            case 1: {
                return this.getData();
            }
            case 2: {
                return this.isUpdateSelection();
            }
            case 3: {
                return this.isSelectAll();
            }
            case 4: {
                return this.getSelectionStart();
            }
            case 5: {
                return this.getSelectionEnd();
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
                return this.isSetObjectSpec();
            }
            case 1: {
                return this.isSetData();
            }
            case 2: {
                return this.isSetUpdateSelection();
            }
            case 3: {
                return this.isSetSelectAll();
            }
            case 4: {
                return this.isSetSelectionStart();
            }
            case 5: {
                return this.isSetSelectionEnd();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof ActiveObjectInfo) {
            return this.equals((ActiveObjectInfo)object);
        }
        return false;
    }

    public boolean equals(ActiveObjectInfo activeObjectInfo) {
        if (activeObjectInfo == null) {
            return false;
        }
        if (this == activeObjectInfo) {
            return true;
        }
        boolean bl = this.isSetObjectSpec();
        boolean bl2 = activeObjectInfo.isSetObjectSpec();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.objectSpec.equals(activeObjectInfo.objectSpec)) {
                return false;
            }
        }
        boolean bl3 = this.isSetData();
        boolean bl4 = activeObjectInfo.isSetData();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.data.equals(activeObjectInfo.data)) {
                return false;
            }
        }
        boolean bl5 = true;
        boolean bl6 = true;
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (this.updateSelection != activeObjectInfo.updateSelection) {
                return false;
            }
        }
        boolean bl7 = true;
        boolean bl8 = true;
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (this.selectAll != activeObjectInfo.selectAll) {
                return false;
            }
        }
        boolean bl9 = true;
        boolean bl10 = true;
        if (bl9 || bl10) {
            if (!bl9 || !bl10) {
                return false;
            }
            if (this.selectionStart != activeObjectInfo.selectionStart) {
                return false;
            }
        }
        boolean bl11 = true;
        boolean bl12 = true;
        if (bl11 || bl12) {
            if (!bl11 || !bl12) {
                return false;
            }
            if (this.selectionEnd != activeObjectInfo.selectionEnd) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetObjectSpec() ? 131071 : 524287);
        if (this.isSetObjectSpec()) {
            n = n * 8191 + this.objectSpec.hashCode();
        }
        n = n * 8191 + (this.isSetData() ? 131071 : 524287);
        if (this.isSetData()) {
            n = n * 8191 + this.data.hashCode();
        }
        n = n * 8191 + (this.updateSelection ? 131071 : 524287);
        n = n * 8191 + (this.selectAll ? 131071 : 524287);
        n = n * 8191 + this.selectionStart;
        n = n * 8191 + this.selectionEnd;
        return n;
    }

    @Override
    public int compareTo(ActiveObjectInfo activeObjectInfo) {
        if (!this.getClass().equals(activeObjectInfo.getClass())) {
            return this.getClass().getName().compareTo(activeObjectInfo.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetObjectSpec(), activeObjectInfo.isSetObjectSpec());
        if (n != 0) {
            return n;
        }
        if (this.isSetObjectSpec() && (n = TBaseHelper.compareTo((Comparable)this.objectSpec, (Comparable)activeObjectInfo.objectSpec)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetData(), activeObjectInfo.isSetData());
        if (n != 0) {
            return n;
        }
        if (this.isSetData() && (n = TBaseHelper.compareTo((Comparable)this.data, (Comparable)activeObjectInfo.data)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetUpdateSelection(), activeObjectInfo.isSetUpdateSelection());
        if (n != 0) {
            return n;
        }
        if (this.isSetUpdateSelection() && (n = TBaseHelper.compareTo((boolean)this.updateSelection, (boolean)activeObjectInfo.updateSelection)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetSelectAll(), activeObjectInfo.isSetSelectAll());
        if (n != 0) {
            return n;
        }
        if (this.isSetSelectAll() && (n = TBaseHelper.compareTo((boolean)this.selectAll, (boolean)activeObjectInfo.selectAll)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetSelectionStart(), activeObjectInfo.isSetSelectionStart());
        if (n != 0) {
            return n;
        }
        if (this.isSetSelectionStart() && (n = TBaseHelper.compareTo((int)this.selectionStart, (int)activeObjectInfo.selectionStart)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetSelectionEnd(), activeObjectInfo.isSetSelectionEnd());
        if (n != 0) {
            return n;
        }
        if (this.isSetSelectionEnd() && (n = TBaseHelper.compareTo((int)this.selectionEnd, (int)activeObjectInfo.selectionEnd)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        ActiveObjectInfo.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        ActiveObjectInfo.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ActiveObjectInfo(");
        boolean bl = true;
        stringBuilder.append("objectSpec:");
        if (this.objectSpec == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.objectSpec);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("data:");
        if (this.data == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.data);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("updateSelection:");
        stringBuilder.append(this.updateSelection);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("selectAll:");
        stringBuilder.append(this.selectAll);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("selectionStart:");
        stringBuilder.append(this.selectionStart);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("selectionEnd:");
        stringBuilder.append(this.selectionEnd);
        bl = false;
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void validate() throws TException {
        if (this.objectSpec != null) {
            this.objectSpec.validate();
        }
        if (this.data != null) {
            this.data.validate();
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
        enumMap.put(_Fields.OBJECT_SPEC, new FieldMetaData("objectSpec", 3, (FieldValueMetaData)new StructMetaData(12, ObjectSpec.class)));
        enumMap.put(_Fields.DATA, new FieldMetaData("data", 3, (FieldValueMetaData)new StructMetaData(12, StringData.class)));
        enumMap.put(_Fields.UPDATE_SELECTION, new FieldMetaData("updateSelection", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.SELECT_ALL, new FieldMetaData("selectAll", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.SELECTION_START, new FieldMetaData("selectionStart", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.SELECTION_END, new FieldMetaData("selectionEnd", 3, new FieldValueMetaData(8)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(ActiveObjectInfo.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        OBJECT_SPEC(1, "objectSpec"),
        DATA(2, "data"),
        UPDATE_SELECTION(3, "updateSelection"),
        SELECT_ALL(4, "selectAll"),
        SELECTION_START(5, "selectionStart"),
        SELECTION_END(6, "selectionEnd");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return OBJECT_SPEC;
                }
                case 2: {
                    return DATA;
                }
                case 3: {
                    return UPDATE_SELECTION;
                }
                case 4: {
                    return SELECT_ALL;
                }
                case 5: {
                    return SELECTION_START;
                }
                case 6: {
                    return SELECTION_END;
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

    private static class ActiveObjectInfoStandardSchemeFactory
    implements SchemeFactory {
        private ActiveObjectInfoStandardSchemeFactory() {
        }

        public ActiveObjectInfoStandardScheme getScheme() {
            return new ActiveObjectInfoStandardScheme();
        }
    }

    private static class ActiveObjectInfoTupleSchemeFactory
    implements SchemeFactory {
        private ActiveObjectInfoTupleSchemeFactory() {
        }

        public ActiveObjectInfoTupleScheme getScheme() {
            return new ActiveObjectInfoTupleScheme();
        }
    }

    private static class ActiveObjectInfoTupleScheme
    extends TupleScheme<ActiveObjectInfo> {
        private ActiveObjectInfoTupleScheme() {
        }

        public void write(TProtocol tProtocol, ActiveObjectInfo activeObjectInfo) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (activeObjectInfo.isSetObjectSpec()) {
                bitSet.set(0);
            }
            if (activeObjectInfo.isSetData()) {
                bitSet.set(1);
            }
            if (activeObjectInfo.isSetUpdateSelection()) {
                bitSet.set(2);
            }
            if (activeObjectInfo.isSetSelectAll()) {
                bitSet.set(3);
            }
            if (activeObjectInfo.isSetSelectionStart()) {
                bitSet.set(4);
            }
            if (activeObjectInfo.isSetSelectionEnd()) {
                bitSet.set(5);
            }
            tTupleProtocol.writeBitSet(bitSet, 6);
            if (activeObjectInfo.isSetObjectSpec()) {
                activeObjectInfo.objectSpec.write((TProtocol)tTupleProtocol);
            }
            if (activeObjectInfo.isSetData()) {
                activeObjectInfo.data.write((TProtocol)tTupleProtocol);
            }
            if (activeObjectInfo.isSetUpdateSelection()) {
                tTupleProtocol.writeBool(activeObjectInfo.updateSelection);
            }
            if (activeObjectInfo.isSetSelectAll()) {
                tTupleProtocol.writeBool(activeObjectInfo.selectAll);
            }
            if (activeObjectInfo.isSetSelectionStart()) {
                tTupleProtocol.writeI32(activeObjectInfo.selectionStart);
            }
            if (activeObjectInfo.isSetSelectionEnd()) {
                tTupleProtocol.writeI32(activeObjectInfo.selectionEnd);
            }
        }

        public void read(TProtocol tProtocol, ActiveObjectInfo activeObjectInfo) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(6);
            if (bitSet.get(0)) {
                activeObjectInfo.objectSpec = new ObjectSpec();
                activeObjectInfo.objectSpec.read((TProtocol)tTupleProtocol);
                activeObjectInfo.setObjectSpecIsSet(true);
            }
            if (bitSet.get(1)) {
                activeObjectInfo.data = new StringData();
                activeObjectInfo.data.read((TProtocol)tTupleProtocol);
                activeObjectInfo.setDataIsSet(true);
            }
            if (bitSet.get(2)) {
                activeObjectInfo.updateSelection = tTupleProtocol.readBool();
                activeObjectInfo.setUpdateSelectionIsSet(true);
            }
            if (bitSet.get(3)) {
                activeObjectInfo.selectAll = tTupleProtocol.readBool();
                activeObjectInfo.setSelectAllIsSet(true);
            }
            if (bitSet.get(4)) {
                activeObjectInfo.selectionStart = tTupleProtocol.readI32();
                activeObjectInfo.setSelectionStartIsSet(true);
            }
            if (bitSet.get(5)) {
                activeObjectInfo.selectionEnd = tTupleProtocol.readI32();
                activeObjectInfo.setSelectionEndIsSet(true);
            }
        }
    }

    private static class ActiveObjectInfoStandardScheme
    extends StandardScheme<ActiveObjectInfo> {
        private ActiveObjectInfoStandardScheme() {
        }

        public void read(TProtocol tProtocol, ActiveObjectInfo activeObjectInfo) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 12) {
                            activeObjectInfo.objectSpec = new ObjectSpec();
                            activeObjectInfo.objectSpec.read(tProtocol);
                            activeObjectInfo.setObjectSpecIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 12) {
                            activeObjectInfo.data = new StringData();
                            activeObjectInfo.data.read(tProtocol);
                            activeObjectInfo.setDataIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 2) {
                            activeObjectInfo.updateSelection = tProtocol.readBool();
                            activeObjectInfo.setUpdateSelectionIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 2) {
                            activeObjectInfo.selectAll = tProtocol.readBool();
                            activeObjectInfo.setSelectAllIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 5: {
                        if (tField.type == 8) {
                            activeObjectInfo.selectionStart = tProtocol.readI32();
                            activeObjectInfo.setSelectionStartIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 6: {
                        if (tField.type == 8) {
                            activeObjectInfo.selectionEnd = tProtocol.readI32();
                            activeObjectInfo.setSelectionEndIsSet(true);
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
            activeObjectInfo.validate();
        }

        public void write(TProtocol tProtocol, ActiveObjectInfo activeObjectInfo) throws TException {
            activeObjectInfo.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (activeObjectInfo.objectSpec != null) {
                tProtocol.writeFieldBegin(OBJECT_SPEC_FIELD_DESC);
                activeObjectInfo.objectSpec.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            if (activeObjectInfo.data != null) {
                tProtocol.writeFieldBegin(DATA_FIELD_DESC);
                activeObjectInfo.data.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(UPDATE_SELECTION_FIELD_DESC);
            tProtocol.writeBool(activeObjectInfo.updateSelection);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(SELECT_ALL_FIELD_DESC);
            tProtocol.writeBool(activeObjectInfo.selectAll);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(SELECTION_START_FIELD_DESC);
            tProtocol.writeI32(activeObjectInfo.selectionStart);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(SELECTION_END_FIELD_DESC);
            tProtocol.writeI32(activeObjectInfo.selectionEnd);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

