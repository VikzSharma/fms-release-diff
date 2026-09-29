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

import com.filemaker.jwpc.iwp.thrift.common.Dimensions;
import com.filemaker.jwpc.iwp.thrift.common.Position;
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

public class MoveResizeCardWindowNotification
implements TBase<MoveResizeCardWindowNotification, _Fields>,
Serializable,
Cloneable,
Comparable<MoveResizeCardWindowNotification> {
    private static final TStruct STRUCT_DESC = new TStruct("MoveResizeCardWindowNotification");
    private static final TField POSITION_FIELD_DESC = new TField("position", 12, 1);
    private static final TField DIMENSIONS_FIELD_DESC = new TField("dimensions", 12, 2);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new MoveResizeCardWindowNotificationStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new MoveResizeCardWindowNotificationTupleSchemeFactory();
    @Nullable
    private Position position;
    @Nullable
    private Dimensions dimensions;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public MoveResizeCardWindowNotification() {
    }

    public MoveResizeCardWindowNotification(Position position, Dimensions dimensions) {
        this();
        this.position = position;
        this.dimensions = dimensions;
    }

    public MoveResizeCardWindowNotification(MoveResizeCardWindowNotification moveResizeCardWindowNotification) {
        if (moveResizeCardWindowNotification.isSetPosition()) {
            this.position = new Position(moveResizeCardWindowNotification.position);
        }
        if (moveResizeCardWindowNotification.isSetDimensions()) {
            this.dimensions = new Dimensions(moveResizeCardWindowNotification.dimensions);
        }
    }

    public MoveResizeCardWindowNotification deepCopy() {
        return new MoveResizeCardWindowNotification(this);
    }

    public void clear() {
        this.position = null;
        this.dimensions = null;
    }

    @Nullable
    public Position getPosition() {
        return this.position;
    }

    public void setPosition(@Nullable Position position) {
        this.position = position;
    }

    public void unsetPosition() {
        this.position = null;
    }

    public boolean isSetPosition() {
        return this.position != null;
    }

    public void setPositionIsSet(boolean bl) {
        if (!bl) {
            this.position = null;
        }
    }

    @Nullable
    public Dimensions getDimensions() {
        return this.dimensions;
    }

    public void setDimensions(@Nullable Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    public void unsetDimensions() {
        this.dimensions = null;
    }

    public boolean isSetDimensions() {
        return this.dimensions != null;
    }

    public void setDimensionsIsSet(boolean bl) {
        if (!bl) {
            this.dimensions = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetPosition();
                    break;
                }
                this.setPosition((Position)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetDimensions();
                    break;
                }
                this.setDimensions((Dimensions)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getPosition();
            }
            case 1: {
                return this.getDimensions();
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
                return this.isSetPosition();
            }
            case 1: {
                return this.isSetDimensions();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof MoveResizeCardWindowNotification) {
            return this.equals((MoveResizeCardWindowNotification)object);
        }
        return false;
    }

    public boolean equals(MoveResizeCardWindowNotification moveResizeCardWindowNotification) {
        if (moveResizeCardWindowNotification == null) {
            return false;
        }
        if (this == moveResizeCardWindowNotification) {
            return true;
        }
        boolean bl = this.isSetPosition();
        boolean bl2 = moveResizeCardWindowNotification.isSetPosition();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.position.equals(moveResizeCardWindowNotification.position)) {
                return false;
            }
        }
        boolean bl3 = this.isSetDimensions();
        boolean bl4 = moveResizeCardWindowNotification.isSetDimensions();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.dimensions.equals(moveResizeCardWindowNotification.dimensions)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetPosition() ? 131071 : 524287);
        if (this.isSetPosition()) {
            n = n * 8191 + this.position.hashCode();
        }
        n = n * 8191 + (this.isSetDimensions() ? 131071 : 524287);
        if (this.isSetDimensions()) {
            n = n * 8191 + this.dimensions.hashCode();
        }
        return n;
    }

    @Override
    public int compareTo(MoveResizeCardWindowNotification moveResizeCardWindowNotification) {
        if (!this.getClass().equals(moveResizeCardWindowNotification.getClass())) {
            return this.getClass().getName().compareTo(moveResizeCardWindowNotification.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetPosition(), moveResizeCardWindowNotification.isSetPosition());
        if (n != 0) {
            return n;
        }
        if (this.isSetPosition() && (n = TBaseHelper.compareTo((Comparable)this.position, (Comparable)moveResizeCardWindowNotification.position)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetDimensions(), moveResizeCardWindowNotification.isSetDimensions());
        if (n != 0) {
            return n;
        }
        if (this.isSetDimensions() && (n = TBaseHelper.compareTo((Comparable)this.dimensions, (Comparable)moveResizeCardWindowNotification.dimensions)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        MoveResizeCardWindowNotification.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        MoveResizeCardWindowNotification.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("MoveResizeCardWindowNotification(");
        boolean bl = true;
        stringBuilder.append("position:");
        if (this.position == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.position);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("dimensions:");
        if (this.dimensions == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.dimensions);
        }
        bl = false;
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void validate() throws TException {
        if (this.position != null) {
            this.position.validate();
        }
        if (this.dimensions != null) {
            this.dimensions.validate();
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
        enumMap.put(_Fields.POSITION, new FieldMetaData("position", 3, (FieldValueMetaData)new StructMetaData(12, Position.class)));
        enumMap.put(_Fields.DIMENSIONS, new FieldMetaData("dimensions", 3, (FieldValueMetaData)new StructMetaData(12, Dimensions.class)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(MoveResizeCardWindowNotification.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        POSITION(1, "position"),
        DIMENSIONS(2, "dimensions");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return POSITION;
                }
                case 2: {
                    return DIMENSIONS;
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

    private static class MoveResizeCardWindowNotificationStandardSchemeFactory
    implements SchemeFactory {
        private MoveResizeCardWindowNotificationStandardSchemeFactory() {
        }

        public MoveResizeCardWindowNotificationStandardScheme getScheme() {
            return new MoveResizeCardWindowNotificationStandardScheme();
        }
    }

    private static class MoveResizeCardWindowNotificationTupleSchemeFactory
    implements SchemeFactory {
        private MoveResizeCardWindowNotificationTupleSchemeFactory() {
        }

        public MoveResizeCardWindowNotificationTupleScheme getScheme() {
            return new MoveResizeCardWindowNotificationTupleScheme();
        }
    }

    private static class MoveResizeCardWindowNotificationTupleScheme
    extends TupleScheme<MoveResizeCardWindowNotification> {
        private MoveResizeCardWindowNotificationTupleScheme() {
        }

        public void write(TProtocol tProtocol, MoveResizeCardWindowNotification moveResizeCardWindowNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (moveResizeCardWindowNotification.isSetPosition()) {
                bitSet.set(0);
            }
            if (moveResizeCardWindowNotification.isSetDimensions()) {
                bitSet.set(1);
            }
            tTupleProtocol.writeBitSet(bitSet, 2);
            if (moveResizeCardWindowNotification.isSetPosition()) {
                moveResizeCardWindowNotification.position.write((TProtocol)tTupleProtocol);
            }
            if (moveResizeCardWindowNotification.isSetDimensions()) {
                moveResizeCardWindowNotification.dimensions.write((TProtocol)tTupleProtocol);
            }
        }

        public void read(TProtocol tProtocol, MoveResizeCardWindowNotification moveResizeCardWindowNotification) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(2);
            if (bitSet.get(0)) {
                moveResizeCardWindowNotification.position = new Position();
                moveResizeCardWindowNotification.position.read((TProtocol)tTupleProtocol);
                moveResizeCardWindowNotification.setPositionIsSet(true);
            }
            if (bitSet.get(1)) {
                moveResizeCardWindowNotification.dimensions = new Dimensions();
                moveResizeCardWindowNotification.dimensions.read((TProtocol)tTupleProtocol);
                moveResizeCardWindowNotification.setDimensionsIsSet(true);
            }
        }
    }

    private static class MoveResizeCardWindowNotificationStandardScheme
    extends StandardScheme<MoveResizeCardWindowNotification> {
        private MoveResizeCardWindowNotificationStandardScheme() {
        }

        public void read(TProtocol tProtocol, MoveResizeCardWindowNotification moveResizeCardWindowNotification) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 12) {
                            moveResizeCardWindowNotification.position = new Position();
                            moveResizeCardWindowNotification.position.read(tProtocol);
                            moveResizeCardWindowNotification.setPositionIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 12) {
                            moveResizeCardWindowNotification.dimensions = new Dimensions();
                            moveResizeCardWindowNotification.dimensions.read(tProtocol);
                            moveResizeCardWindowNotification.setDimensionsIsSet(true);
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
            moveResizeCardWindowNotification.validate();
        }

        public void write(TProtocol tProtocol, MoveResizeCardWindowNotification moveResizeCardWindowNotification) throws TException {
            moveResizeCardWindowNotification.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (moveResizeCardWindowNotification.position != null) {
                tProtocol.writeFieldBegin(POSITION_FIELD_DESC);
                moveResizeCardWindowNotification.position.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            if (moveResizeCardWindowNotification.dimensions != null) {
                tProtocol.writeFieldBegin(DIMENSIONS_FIELD_DESC);
                moveResizeCardWindowNotification.dimensions.write(tProtocol);
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

