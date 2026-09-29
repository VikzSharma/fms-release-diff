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

import com.filemaker.jwpc.iwp.thrift.common.LayoutObjectType;
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
import org.apache.thrift.meta_data.EnumMetaData;
import org.apache.thrift.meta_data.FieldMetaData;
import org.apache.thrift.meta_data.FieldValueMetaData;
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

public class ObjectSpec
implements TBase<ObjectSpec, _Fields>,
Serializable,
Cloneable,
Comparable<ObjectSpec> {
    private static final TStruct STRUCT_DESC = new TStruct("ObjectSpec");
    private static final TField OBJECT_ID_FIELD_DESC = new TField("objectId", 8, 1);
    private static final TField REPETITION_FIELD_DESC = new TField("repetition", 6, 2);
    private static final TField ROW_INDEX_FIELD_DESC = new TField("rowIndex", 8, 3);
    private static final TField ROW_ID_FIELD_DESC = new TField("rowId", 8, 4);
    private static final TField PORTAL_ROW_INDEX_FIELD_DESC = new TField("portalRowIndex", 8, 5);
    private static final TField PARENT_PORTAL_ID_FIELD_DESC = new TField("parentPortalId", 8, 6);
    private static final TField PART_INDEX_FIELD_DESC = new TField("partIndex", 8, 7);
    private static final TField PARENT_POPOVER_ID_FIELD_DESC = new TField("parentPopoverId", 8, 8);
    private static final TField GRAND_PARENT_POPOVER_ID_FIELD_DESC = new TField("grandParentPopoverId", 8, 9);
    private static final TField OBJECT_TYPE_FIELD_DESC = new TField("objectType", 8, 10);
    private static final TField LAYOUT_ID_FIELD_DESC = new TField("layoutId", 8, 11);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new ObjectSpecStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new ObjectSpecTupleSchemeFactory();
    private int objectId;
    private short repetition;
    private int rowIndex;
    private int rowId;
    private int portalRowIndex;
    private int parentPortalId;
    private int partIndex;
    private int parentPopoverId;
    private int grandParentPopoverId;
    @Nullable
    private LayoutObjectType objectType;
    private int layoutId;
    private static final int __OBJECTID_ISSET_ID = 0;
    private static final int __REPETITION_ISSET_ID = 1;
    private static final int __ROWINDEX_ISSET_ID = 2;
    private static final int __ROWID_ISSET_ID = 3;
    private static final int __PORTALROWINDEX_ISSET_ID = 4;
    private static final int __PARENTPORTALID_ISSET_ID = 5;
    private static final int __PARTINDEX_ISSET_ID = 6;
    private static final int __PARENTPOPOVERID_ISSET_ID = 7;
    private static final int __GRANDPARENTPOPOVERID_ISSET_ID = 8;
    private static final int __LAYOUTID_ISSET_ID = 9;
    private short __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public ObjectSpec() {
        this.objectId = 0;
        this.repetition = 1;
        this.rowIndex = 0;
        this.rowId = 0;
        this.portalRowIndex = 0;
        this.parentPortalId = 0;
        this.partIndex = -1;
        this.parentPopoverId = 0;
        this.grandParentPopoverId = 0;
        this.layoutId = 0;
    }

    public ObjectSpec(int n, short s, int n2, int n3, int n4, int n5, int n6, int n7, int n8, LayoutObjectType layoutObjectType, int n9) {
        this();
        this.objectId = n;
        this.setObjectIdIsSet(true);
        this.repetition = s;
        this.setRepetitionIsSet(true);
        this.rowIndex = n2;
        this.setRowIndexIsSet(true);
        this.rowId = n3;
        this.setRowIdIsSet(true);
        this.portalRowIndex = n4;
        this.setPortalRowIndexIsSet(true);
        this.parentPortalId = n5;
        this.setParentPortalIdIsSet(true);
        this.partIndex = n6;
        this.setPartIndexIsSet(true);
        this.parentPopoverId = n7;
        this.setParentPopoverIdIsSet(true);
        this.grandParentPopoverId = n8;
        this.setGrandParentPopoverIdIsSet(true);
        this.objectType = layoutObjectType;
        this.layoutId = n9;
        this.setLayoutIdIsSet(true);
    }

    public ObjectSpec(ObjectSpec objectSpec) {
        this.__isset_bitfield = objectSpec.__isset_bitfield;
        this.objectId = objectSpec.objectId;
        this.repetition = objectSpec.repetition;
        this.rowIndex = objectSpec.rowIndex;
        this.rowId = objectSpec.rowId;
        this.portalRowIndex = objectSpec.portalRowIndex;
        this.parentPortalId = objectSpec.parentPortalId;
        this.partIndex = objectSpec.partIndex;
        this.parentPopoverId = objectSpec.parentPopoverId;
        this.grandParentPopoverId = objectSpec.grandParentPopoverId;
        if (objectSpec.isSetObjectType()) {
            this.objectType = objectSpec.objectType;
        }
        this.layoutId = objectSpec.layoutId;
    }

    public ObjectSpec deepCopy() {
        return new ObjectSpec(this);
    }

    public void clear() {
        this.objectId = 0;
        this.repetition = 1;
        this.rowIndex = 0;
        this.rowId = 0;
        this.portalRowIndex = 0;
        this.parentPortalId = 0;
        this.partIndex = -1;
        this.parentPopoverId = 0;
        this.grandParentPopoverId = 0;
        this.objectType = null;
        this.layoutId = 0;
    }

    public int getObjectId() {
        return this.objectId;
    }

    public void setObjectId(int n) {
        this.objectId = n;
        this.setObjectIdIsSet(true);
    }

    public void unsetObjectId() {
        this.__isset_bitfield = EncodingUtils.clearBit((short)this.__isset_bitfield, (int)0);
    }

    public boolean isSetObjectId() {
        return EncodingUtils.testBit((short)this.__isset_bitfield, (int)0);
    }

    public void setObjectIdIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((short)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public short getRepetition() {
        return this.repetition;
    }

    public void setRepetition(short s) {
        this.repetition = s;
        this.setRepetitionIsSet(true);
    }

    public void unsetRepetition() {
        this.__isset_bitfield = EncodingUtils.clearBit((short)this.__isset_bitfield, (int)1);
    }

    public boolean isSetRepetition() {
        return EncodingUtils.testBit((short)this.__isset_bitfield, (int)1);
    }

    public void setRepetitionIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((short)this.__isset_bitfield, (int)1, (boolean)bl);
    }

    public int getRowIndex() {
        return this.rowIndex;
    }

    public void setRowIndex(int n) {
        this.rowIndex = n;
        this.setRowIndexIsSet(true);
    }

    public void unsetRowIndex() {
        this.__isset_bitfield = EncodingUtils.clearBit((short)this.__isset_bitfield, (int)2);
    }

    public boolean isSetRowIndex() {
        return EncodingUtils.testBit((short)this.__isset_bitfield, (int)2);
    }

    public void setRowIndexIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((short)this.__isset_bitfield, (int)2, (boolean)bl);
    }

    public int getRowId() {
        return this.rowId;
    }

    public void setRowId(int n) {
        this.rowId = n;
        this.setRowIdIsSet(true);
    }

    public void unsetRowId() {
        this.__isset_bitfield = EncodingUtils.clearBit((short)this.__isset_bitfield, (int)3);
    }

    public boolean isSetRowId() {
        return EncodingUtils.testBit((short)this.__isset_bitfield, (int)3);
    }

    public void setRowIdIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((short)this.__isset_bitfield, (int)3, (boolean)bl);
    }

    public int getPortalRowIndex() {
        return this.portalRowIndex;
    }

    public void setPortalRowIndex(int n) {
        this.portalRowIndex = n;
        this.setPortalRowIndexIsSet(true);
    }

    public void unsetPortalRowIndex() {
        this.__isset_bitfield = EncodingUtils.clearBit((short)this.__isset_bitfield, (int)4);
    }

    public boolean isSetPortalRowIndex() {
        return EncodingUtils.testBit((short)this.__isset_bitfield, (int)4);
    }

    public void setPortalRowIndexIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((short)this.__isset_bitfield, (int)4, (boolean)bl);
    }

    public int getParentPortalId() {
        return this.parentPortalId;
    }

    public void setParentPortalId(int n) {
        this.parentPortalId = n;
        this.setParentPortalIdIsSet(true);
    }

    public void unsetParentPortalId() {
        this.__isset_bitfield = EncodingUtils.clearBit((short)this.__isset_bitfield, (int)5);
    }

    public boolean isSetParentPortalId() {
        return EncodingUtils.testBit((short)this.__isset_bitfield, (int)5);
    }

    public void setParentPortalIdIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((short)this.__isset_bitfield, (int)5, (boolean)bl);
    }

    public int getPartIndex() {
        return this.partIndex;
    }

    public void setPartIndex(int n) {
        this.partIndex = n;
        this.setPartIndexIsSet(true);
    }

    public void unsetPartIndex() {
        this.__isset_bitfield = EncodingUtils.clearBit((short)this.__isset_bitfield, (int)6);
    }

    public boolean isSetPartIndex() {
        return EncodingUtils.testBit((short)this.__isset_bitfield, (int)6);
    }

    public void setPartIndexIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((short)this.__isset_bitfield, (int)6, (boolean)bl);
    }

    public int getParentPopoverId() {
        return this.parentPopoverId;
    }

    public void setParentPopoverId(int n) {
        this.parentPopoverId = n;
        this.setParentPopoverIdIsSet(true);
    }

    public void unsetParentPopoverId() {
        this.__isset_bitfield = EncodingUtils.clearBit((short)this.__isset_bitfield, (int)7);
    }

    public boolean isSetParentPopoverId() {
        return EncodingUtils.testBit((short)this.__isset_bitfield, (int)7);
    }

    public void setParentPopoverIdIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((short)this.__isset_bitfield, (int)7, (boolean)bl);
    }

    public int getGrandParentPopoverId() {
        return this.grandParentPopoverId;
    }

    public void setGrandParentPopoverId(int n) {
        this.grandParentPopoverId = n;
        this.setGrandParentPopoverIdIsSet(true);
    }

    public void unsetGrandParentPopoverId() {
        this.__isset_bitfield = EncodingUtils.clearBit((short)this.__isset_bitfield, (int)8);
    }

    public boolean isSetGrandParentPopoverId() {
        return EncodingUtils.testBit((short)this.__isset_bitfield, (int)8);
    }

    public void setGrandParentPopoverIdIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((short)this.__isset_bitfield, (int)8, (boolean)bl);
    }

    @Nullable
    public LayoutObjectType getObjectType() {
        return this.objectType;
    }

    public void setObjectType(@Nullable LayoutObjectType layoutObjectType) {
        this.objectType = layoutObjectType;
    }

    public void unsetObjectType() {
        this.objectType = null;
    }

    public boolean isSetObjectType() {
        return this.objectType != null;
    }

    public void setObjectTypeIsSet(boolean bl) {
        if (!bl) {
            this.objectType = null;
        }
    }

    public int getLayoutId() {
        return this.layoutId;
    }

    public void setLayoutId(int n) {
        this.layoutId = n;
        this.setLayoutIdIsSet(true);
    }

    public void unsetLayoutId() {
        this.__isset_bitfield = EncodingUtils.clearBit((short)this.__isset_bitfield, (int)9);
    }

    public boolean isSetLayoutId() {
        return EncodingUtils.testBit((short)this.__isset_bitfield, (int)9);
    }

    public void setLayoutIdIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((short)this.__isset_bitfield, (int)9, (boolean)bl);
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetObjectId();
                    break;
                }
                this.setObjectId((Integer)object);
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetRepetition();
                    break;
                }
                this.setRepetition((Short)object);
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetRowIndex();
                    break;
                }
                this.setRowIndex((Integer)object);
                break;
            }
            case 3: {
                if (object == null) {
                    this.unsetRowId();
                    break;
                }
                this.setRowId((Integer)object);
                break;
            }
            case 4: {
                if (object == null) {
                    this.unsetPortalRowIndex();
                    break;
                }
                this.setPortalRowIndex((Integer)object);
                break;
            }
            case 5: {
                if (object == null) {
                    this.unsetParentPortalId();
                    break;
                }
                this.setParentPortalId((Integer)object);
                break;
            }
            case 6: {
                if (object == null) {
                    this.unsetPartIndex();
                    break;
                }
                this.setPartIndex((Integer)object);
                break;
            }
            case 7: {
                if (object == null) {
                    this.unsetParentPopoverId();
                    break;
                }
                this.setParentPopoverId((Integer)object);
                break;
            }
            case 8: {
                if (object == null) {
                    this.unsetGrandParentPopoverId();
                    break;
                }
                this.setGrandParentPopoverId((Integer)object);
                break;
            }
            case 9: {
                if (object == null) {
                    this.unsetObjectType();
                    break;
                }
                this.setObjectType((LayoutObjectType)((Object)object));
                break;
            }
            case 10: {
                if (object == null) {
                    this.unsetLayoutId();
                    break;
                }
                this.setLayoutId((Integer)object);
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getObjectId();
            }
            case 1: {
                return this.getRepetition();
            }
            case 2: {
                return this.getRowIndex();
            }
            case 3: {
                return this.getRowId();
            }
            case 4: {
                return this.getPortalRowIndex();
            }
            case 5: {
                return this.getParentPortalId();
            }
            case 6: {
                return this.getPartIndex();
            }
            case 7: {
                return this.getParentPopoverId();
            }
            case 8: {
                return this.getGrandParentPopoverId();
            }
            case 9: {
                return this.getObjectType();
            }
            case 10: {
                return this.getLayoutId();
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
                return this.isSetObjectId();
            }
            case 1: {
                return this.isSetRepetition();
            }
            case 2: {
                return this.isSetRowIndex();
            }
            case 3: {
                return this.isSetRowId();
            }
            case 4: {
                return this.isSetPortalRowIndex();
            }
            case 5: {
                return this.isSetParentPortalId();
            }
            case 6: {
                return this.isSetPartIndex();
            }
            case 7: {
                return this.isSetParentPopoverId();
            }
            case 8: {
                return this.isSetGrandParentPopoverId();
            }
            case 9: {
                return this.isSetObjectType();
            }
            case 10: {
                return this.isSetLayoutId();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof ObjectSpec) {
            return this.equals((ObjectSpec)object);
        }
        return false;
    }

    public boolean equals(ObjectSpec objectSpec) {
        if (objectSpec == null) {
            return false;
        }
        if (this == objectSpec) {
            return true;
        }
        boolean bl = true;
        boolean bl2 = true;
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (this.objectId != objectSpec.objectId) {
                return false;
            }
        }
        boolean bl3 = true;
        boolean bl4 = true;
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (this.repetition != objectSpec.repetition) {
                return false;
            }
        }
        boolean bl5 = true;
        boolean bl6 = true;
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (this.rowIndex != objectSpec.rowIndex) {
                return false;
            }
        }
        boolean bl7 = true;
        boolean bl8 = true;
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (this.rowId != objectSpec.rowId) {
                return false;
            }
        }
        boolean bl9 = true;
        boolean bl10 = true;
        if (bl9 || bl10) {
            if (!bl9 || !bl10) {
                return false;
            }
            if (this.portalRowIndex != objectSpec.portalRowIndex) {
                return false;
            }
        }
        boolean bl11 = true;
        boolean bl12 = true;
        if (bl11 || bl12) {
            if (!bl11 || !bl12) {
                return false;
            }
            if (this.parentPortalId != objectSpec.parentPortalId) {
                return false;
            }
        }
        boolean bl13 = true;
        boolean bl14 = true;
        if (bl13 || bl14) {
            if (!bl13 || !bl14) {
                return false;
            }
            if (this.partIndex != objectSpec.partIndex) {
                return false;
            }
        }
        boolean bl15 = true;
        boolean bl16 = true;
        if (bl15 || bl16) {
            if (!bl15 || !bl16) {
                return false;
            }
            if (this.parentPopoverId != objectSpec.parentPopoverId) {
                return false;
            }
        }
        boolean bl17 = true;
        boolean bl18 = true;
        if (bl17 || bl18) {
            if (!bl17 || !bl18) {
                return false;
            }
            if (this.grandParentPopoverId != objectSpec.grandParentPopoverId) {
                return false;
            }
        }
        boolean bl19 = this.isSetObjectType();
        boolean bl20 = objectSpec.isSetObjectType();
        if (bl19 || bl20) {
            if (!bl19 || !bl20) {
                return false;
            }
            if (!this.objectType.equals((Object)objectSpec.objectType)) {
                return false;
            }
        }
        boolean bl21 = true;
        boolean bl22 = true;
        if (bl21 || bl22) {
            if (!bl21 || !bl22) {
                return false;
            }
            if (this.layoutId != objectSpec.layoutId) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + this.objectId;
        n = n * 8191 + this.repetition;
        n = n * 8191 + this.rowIndex;
        n = n * 8191 + this.rowId;
        n = n * 8191 + this.portalRowIndex;
        n = n * 8191 + this.parentPortalId;
        n = n * 8191 + this.partIndex;
        n = n * 8191 + this.parentPopoverId;
        n = n * 8191 + this.grandParentPopoverId;
        n = n * 8191 + (this.isSetObjectType() ? 131071 : 524287);
        if (this.isSetObjectType()) {
            n = n * 8191 + this.objectType.getValue();
        }
        n = n * 8191 + this.layoutId;
        return n;
    }

    @Override
    public int compareTo(ObjectSpec objectSpec) {
        if (!this.getClass().equals(objectSpec.getClass())) {
            return this.getClass().getName().compareTo(objectSpec.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetObjectId(), objectSpec.isSetObjectId());
        if (n != 0) {
            return n;
        }
        if (this.isSetObjectId() && (n = TBaseHelper.compareTo((int)this.objectId, (int)objectSpec.objectId)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetRepetition(), objectSpec.isSetRepetition());
        if (n != 0) {
            return n;
        }
        if (this.isSetRepetition() && (n = TBaseHelper.compareTo((short)this.repetition, (short)objectSpec.repetition)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetRowIndex(), objectSpec.isSetRowIndex());
        if (n != 0) {
            return n;
        }
        if (this.isSetRowIndex() && (n = TBaseHelper.compareTo((int)this.rowIndex, (int)objectSpec.rowIndex)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetRowId(), objectSpec.isSetRowId());
        if (n != 0) {
            return n;
        }
        if (this.isSetRowId() && (n = TBaseHelper.compareTo((int)this.rowId, (int)objectSpec.rowId)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetPortalRowIndex(), objectSpec.isSetPortalRowIndex());
        if (n != 0) {
            return n;
        }
        if (this.isSetPortalRowIndex() && (n = TBaseHelper.compareTo((int)this.portalRowIndex, (int)objectSpec.portalRowIndex)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetParentPortalId(), objectSpec.isSetParentPortalId());
        if (n != 0) {
            return n;
        }
        if (this.isSetParentPortalId() && (n = TBaseHelper.compareTo((int)this.parentPortalId, (int)objectSpec.parentPortalId)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetPartIndex(), objectSpec.isSetPartIndex());
        if (n != 0) {
            return n;
        }
        if (this.isSetPartIndex() && (n = TBaseHelper.compareTo((int)this.partIndex, (int)objectSpec.partIndex)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetParentPopoverId(), objectSpec.isSetParentPopoverId());
        if (n != 0) {
            return n;
        }
        if (this.isSetParentPopoverId() && (n = TBaseHelper.compareTo((int)this.parentPopoverId, (int)objectSpec.parentPopoverId)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetGrandParentPopoverId(), objectSpec.isSetGrandParentPopoverId());
        if (n != 0) {
            return n;
        }
        if (this.isSetGrandParentPopoverId() && (n = TBaseHelper.compareTo((int)this.grandParentPopoverId, (int)objectSpec.grandParentPopoverId)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetObjectType(), objectSpec.isSetObjectType());
        if (n != 0) {
            return n;
        }
        if (this.isSetObjectType() && (n = TBaseHelper.compareTo((Comparable)((Object)this.objectType), (Comparable)((Object)objectSpec.objectType))) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetLayoutId(), objectSpec.isSetLayoutId());
        if (n != 0) {
            return n;
        }
        if (this.isSetLayoutId() && (n = TBaseHelper.compareTo((int)this.layoutId, (int)objectSpec.layoutId)) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        ObjectSpec.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        ObjectSpec.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ObjectSpec(");
        boolean bl = true;
        stringBuilder.append("objectId:");
        stringBuilder.append(this.objectId);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("repetition:");
        stringBuilder.append(this.repetition);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("rowIndex:");
        stringBuilder.append(this.rowIndex);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("rowId:");
        stringBuilder.append(this.rowId);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("portalRowIndex:");
        stringBuilder.append(this.portalRowIndex);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("parentPortalId:");
        stringBuilder.append(this.parentPortalId);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("partIndex:");
        stringBuilder.append(this.partIndex);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("parentPopoverId:");
        stringBuilder.append(this.parentPopoverId);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("grandParentPopoverId:");
        stringBuilder.append(this.grandParentPopoverId);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("objectType:");
        if (this.objectType == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append((Object)this.objectType);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("layoutId:");
        stringBuilder.append(this.layoutId);
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
        enumMap.put(_Fields.OBJECT_ID, new FieldMetaData("objectId", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.REPETITION, new FieldMetaData("repetition", 3, new FieldValueMetaData(6)));
        enumMap.put(_Fields.ROW_INDEX, new FieldMetaData("rowIndex", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.ROW_ID, new FieldMetaData("rowId", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.PORTAL_ROW_INDEX, new FieldMetaData("portalRowIndex", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.PARENT_PORTAL_ID, new FieldMetaData("parentPortalId", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.PART_INDEX, new FieldMetaData("partIndex", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.PARENT_POPOVER_ID, new FieldMetaData("parentPopoverId", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.GRAND_PARENT_POPOVER_ID, new FieldMetaData("grandParentPopoverId", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.OBJECT_TYPE, new FieldMetaData("objectType", 3, (FieldValueMetaData)new EnumMetaData(-1, LayoutObjectType.class)));
        enumMap.put(_Fields.LAYOUT_ID, new FieldMetaData("layoutId", 3, new FieldValueMetaData(8)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(ObjectSpec.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        OBJECT_ID(1, "objectId"),
        REPETITION(2, "repetition"),
        ROW_INDEX(3, "rowIndex"),
        ROW_ID(4, "rowId"),
        PORTAL_ROW_INDEX(5, "portalRowIndex"),
        PARENT_PORTAL_ID(6, "parentPortalId"),
        PART_INDEX(7, "partIndex"),
        PARENT_POPOVER_ID(8, "parentPopoverId"),
        GRAND_PARENT_POPOVER_ID(9, "grandParentPopoverId"),
        OBJECT_TYPE(10, "objectType"),
        LAYOUT_ID(11, "layoutId");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return OBJECT_ID;
                }
                case 2: {
                    return REPETITION;
                }
                case 3: {
                    return ROW_INDEX;
                }
                case 4: {
                    return ROW_ID;
                }
                case 5: {
                    return PORTAL_ROW_INDEX;
                }
                case 6: {
                    return PARENT_PORTAL_ID;
                }
                case 7: {
                    return PART_INDEX;
                }
                case 8: {
                    return PARENT_POPOVER_ID;
                }
                case 9: {
                    return GRAND_PARENT_POPOVER_ID;
                }
                case 10: {
                    return OBJECT_TYPE;
                }
                case 11: {
                    return LAYOUT_ID;
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

    private static class ObjectSpecStandardSchemeFactory
    implements SchemeFactory {
        private ObjectSpecStandardSchemeFactory() {
        }

        public ObjectSpecStandardScheme getScheme() {
            return new ObjectSpecStandardScheme();
        }
    }

    private static class ObjectSpecTupleSchemeFactory
    implements SchemeFactory {
        private ObjectSpecTupleSchemeFactory() {
        }

        public ObjectSpecTupleScheme getScheme() {
            return new ObjectSpecTupleScheme();
        }
    }

    private static class ObjectSpecTupleScheme
    extends TupleScheme<ObjectSpec> {
        private ObjectSpecTupleScheme() {
        }

        public void write(TProtocol tProtocol, ObjectSpec objectSpec) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (objectSpec.isSetObjectId()) {
                bitSet.set(0);
            }
            if (objectSpec.isSetRepetition()) {
                bitSet.set(1);
            }
            if (objectSpec.isSetRowIndex()) {
                bitSet.set(2);
            }
            if (objectSpec.isSetRowId()) {
                bitSet.set(3);
            }
            if (objectSpec.isSetPortalRowIndex()) {
                bitSet.set(4);
            }
            if (objectSpec.isSetParentPortalId()) {
                bitSet.set(5);
            }
            if (objectSpec.isSetPartIndex()) {
                bitSet.set(6);
            }
            if (objectSpec.isSetParentPopoverId()) {
                bitSet.set(7);
            }
            if (objectSpec.isSetGrandParentPopoverId()) {
                bitSet.set(8);
            }
            if (objectSpec.isSetObjectType()) {
                bitSet.set(9);
            }
            if (objectSpec.isSetLayoutId()) {
                bitSet.set(10);
            }
            tTupleProtocol.writeBitSet(bitSet, 11);
            if (objectSpec.isSetObjectId()) {
                tTupleProtocol.writeI32(objectSpec.objectId);
            }
            if (objectSpec.isSetRepetition()) {
                tTupleProtocol.writeI16(objectSpec.repetition);
            }
            if (objectSpec.isSetRowIndex()) {
                tTupleProtocol.writeI32(objectSpec.rowIndex);
            }
            if (objectSpec.isSetRowId()) {
                tTupleProtocol.writeI32(objectSpec.rowId);
            }
            if (objectSpec.isSetPortalRowIndex()) {
                tTupleProtocol.writeI32(objectSpec.portalRowIndex);
            }
            if (objectSpec.isSetParentPortalId()) {
                tTupleProtocol.writeI32(objectSpec.parentPortalId);
            }
            if (objectSpec.isSetPartIndex()) {
                tTupleProtocol.writeI32(objectSpec.partIndex);
            }
            if (objectSpec.isSetParentPopoverId()) {
                tTupleProtocol.writeI32(objectSpec.parentPopoverId);
            }
            if (objectSpec.isSetGrandParentPopoverId()) {
                tTupleProtocol.writeI32(objectSpec.grandParentPopoverId);
            }
            if (objectSpec.isSetObjectType()) {
                tTupleProtocol.writeI32(objectSpec.objectType.getValue());
            }
            if (objectSpec.isSetLayoutId()) {
                tTupleProtocol.writeI32(objectSpec.layoutId);
            }
        }

        public void read(TProtocol tProtocol, ObjectSpec objectSpec) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(11);
            if (bitSet.get(0)) {
                objectSpec.objectId = tTupleProtocol.readI32();
                objectSpec.setObjectIdIsSet(true);
            }
            if (bitSet.get(1)) {
                objectSpec.repetition = tTupleProtocol.readI16();
                objectSpec.setRepetitionIsSet(true);
            }
            if (bitSet.get(2)) {
                objectSpec.rowIndex = tTupleProtocol.readI32();
                objectSpec.setRowIndexIsSet(true);
            }
            if (bitSet.get(3)) {
                objectSpec.rowId = tTupleProtocol.readI32();
                objectSpec.setRowIdIsSet(true);
            }
            if (bitSet.get(4)) {
                objectSpec.portalRowIndex = tTupleProtocol.readI32();
                objectSpec.setPortalRowIndexIsSet(true);
            }
            if (bitSet.get(5)) {
                objectSpec.parentPortalId = tTupleProtocol.readI32();
                objectSpec.setParentPortalIdIsSet(true);
            }
            if (bitSet.get(6)) {
                objectSpec.partIndex = tTupleProtocol.readI32();
                objectSpec.setPartIndexIsSet(true);
            }
            if (bitSet.get(7)) {
                objectSpec.parentPopoverId = tTupleProtocol.readI32();
                objectSpec.setParentPopoverIdIsSet(true);
            }
            if (bitSet.get(8)) {
                objectSpec.grandParentPopoverId = tTupleProtocol.readI32();
                objectSpec.setGrandParentPopoverIdIsSet(true);
            }
            if (bitSet.get(9)) {
                objectSpec.objectType = LayoutObjectType.findByValue(tTupleProtocol.readI32());
                objectSpec.setObjectTypeIsSet(true);
            }
            if (bitSet.get(10)) {
                objectSpec.layoutId = tTupleProtocol.readI32();
                objectSpec.setLayoutIdIsSet(true);
            }
        }
    }

    private static class ObjectSpecStandardScheme
    extends StandardScheme<ObjectSpec> {
        private ObjectSpecStandardScheme() {
        }

        public void read(TProtocol tProtocol, ObjectSpec objectSpec) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 8) {
                            objectSpec.objectId = tProtocol.readI32();
                            objectSpec.setObjectIdIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 6) {
                            objectSpec.repetition = tProtocol.readI16();
                            objectSpec.setRepetitionIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 8) {
                            objectSpec.rowIndex = tProtocol.readI32();
                            objectSpec.setRowIndexIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 8) {
                            objectSpec.rowId = tProtocol.readI32();
                            objectSpec.setRowIdIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 5: {
                        if (tField.type == 8) {
                            objectSpec.portalRowIndex = tProtocol.readI32();
                            objectSpec.setPortalRowIndexIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 6: {
                        if (tField.type == 8) {
                            objectSpec.parentPortalId = tProtocol.readI32();
                            objectSpec.setParentPortalIdIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 7: {
                        if (tField.type == 8) {
                            objectSpec.partIndex = tProtocol.readI32();
                            objectSpec.setPartIndexIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 8: {
                        if (tField.type == 8) {
                            objectSpec.parentPopoverId = tProtocol.readI32();
                            objectSpec.setParentPopoverIdIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 9: {
                        if (tField.type == 8) {
                            objectSpec.grandParentPopoverId = tProtocol.readI32();
                            objectSpec.setGrandParentPopoverIdIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 10: {
                        if (tField.type == 8) {
                            objectSpec.objectType = LayoutObjectType.findByValue(tProtocol.readI32());
                            objectSpec.setObjectTypeIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 11: {
                        if (tField.type == 8) {
                            objectSpec.layoutId = tProtocol.readI32();
                            objectSpec.setLayoutIdIsSet(true);
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
            objectSpec.validate();
        }

        public void write(TProtocol tProtocol, ObjectSpec objectSpec) throws TException {
            objectSpec.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            tProtocol.writeFieldBegin(OBJECT_ID_FIELD_DESC);
            tProtocol.writeI32(objectSpec.objectId);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(REPETITION_FIELD_DESC);
            tProtocol.writeI16(objectSpec.repetition);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(ROW_INDEX_FIELD_DESC);
            tProtocol.writeI32(objectSpec.rowIndex);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(ROW_ID_FIELD_DESC);
            tProtocol.writeI32(objectSpec.rowId);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(PORTAL_ROW_INDEX_FIELD_DESC);
            tProtocol.writeI32(objectSpec.portalRowIndex);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(PARENT_PORTAL_ID_FIELD_DESC);
            tProtocol.writeI32(objectSpec.parentPortalId);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(PART_INDEX_FIELD_DESC);
            tProtocol.writeI32(objectSpec.partIndex);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(PARENT_POPOVER_ID_FIELD_DESC);
            tProtocol.writeI32(objectSpec.parentPopoverId);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(GRAND_PARENT_POPOVER_ID_FIELD_DESC);
            tProtocol.writeI32(objectSpec.grandParentPopoverId);
            tProtocol.writeFieldEnd();
            if (objectSpec.objectType != null) {
                tProtocol.writeFieldBegin(OBJECT_TYPE_FIELD_DESC);
                tProtocol.writeI32(objectSpec.objectType.getValue());
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(LAYOUT_ID_FIELD_DESC);
            tProtocol.writeI32(objectSpec.layoutId);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

