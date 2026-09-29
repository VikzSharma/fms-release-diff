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

import com.filemaker.jwpc.iwp.thrift.common.LayoutMode;
import com.filemaker.jwpc.iwp.thrift.common.LayoutViewStyle;
import com.filemaker.jwpc.iwp.thrift.common.RowSetOrder;
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

public class WindowState
implements TBase<WindowState, _Fields>,
Serializable,
Cloneable,
Comparable<WindowState> {
    private static final TStruct STRUCT_DESC = new TStruct("WindowState");
    private static final TField MODE_FIELD_DESC = new TField("mode", 8, 1);
    private static final TField VIEW_STYLE_FIELD_DESC = new TField("viewStyle", 8, 2);
    private static final TField TOTAL_ROWS_FIELD_DESC = new TField("totalRows", 8, 3);
    private static final TField FOUND_ROWS_FIELD_DESC = new TField("foundRows", 8, 4);
    private static final TField PART_ROWS_FIELD_DESC = new TField("partRows", 8, 5);
    private static final TField ROW_INDEX_FIELD_DESC = new TField("rowIndex", 8, 6);
    private static final TField ROW_ID_FIELD_DESC = new TField("rowId", 8, 7);
    private static final TField IS_MASTER_ROW_SET_FIELD_DESC = new TField("isMasterRowSet", 2, 8);
    private static final TField OMIT_REQUEST_FIELD_DESC = new TField("omitRequest", 2, 9);
    private static final TField ROW_SET_ORDER_FIELD_DESC = new TField("rowSetOrder", 8, 10);
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new WindowStateStandardSchemeFactory();
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new WindowStateTupleSchemeFactory();
    @Nullable
    private LayoutMode mode;
    @Nullable
    private LayoutViewStyle viewStyle;
    private int totalRows;
    private int foundRows;
    private int partRows;
    private int rowIndex;
    private int rowId;
    private boolean isMasterRowSet;
    private boolean omitRequest;
    @Nullable
    private RowSetOrder rowSetOrder;
    private static final int __TOTALROWS_ISSET_ID = 0;
    private static final int __FOUNDROWS_ISSET_ID = 1;
    private static final int __PARTROWS_ISSET_ID = 2;
    private static final int __ROWINDEX_ISSET_ID = 3;
    private static final int __ROWID_ISSET_ID = 4;
    private static final int __ISMASTERROWSET_ISSET_ID = 5;
    private static final int __OMITREQUEST_ISSET_ID = 6;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, FieldMetaData> metaDataMap;

    public WindowState() {
        this.mode = LayoutMode.BROWSE;
        this.viewStyle = LayoutViewStyle.FORM;
        this.totalRows = 0;
        this.foundRows = 0;
        this.partRows = 0;
        this.rowIndex = 0;
        this.rowId = 0;
    }

    public WindowState(LayoutMode layoutMode, LayoutViewStyle layoutViewStyle, int n, int n2, int n3, int n4, int n5, boolean bl, boolean bl2, RowSetOrder rowSetOrder) {
        this();
        this.mode = layoutMode;
        this.viewStyle = layoutViewStyle;
        this.totalRows = n;
        this.setTotalRowsIsSet(true);
        this.foundRows = n2;
        this.setFoundRowsIsSet(true);
        this.partRows = n3;
        this.setPartRowsIsSet(true);
        this.rowIndex = n4;
        this.setRowIndexIsSet(true);
        this.rowId = n5;
        this.setRowIdIsSet(true);
        this.isMasterRowSet = bl;
        this.setIsMasterRowSetIsSet(true);
        this.omitRequest = bl2;
        this.setOmitRequestIsSet(true);
        this.rowSetOrder = rowSetOrder;
    }

    public WindowState(WindowState windowState) {
        this.__isset_bitfield = windowState.__isset_bitfield;
        if (windowState.isSetMode()) {
            this.mode = windowState.mode;
        }
        if (windowState.isSetViewStyle()) {
            this.viewStyle = windowState.viewStyle;
        }
        this.totalRows = windowState.totalRows;
        this.foundRows = windowState.foundRows;
        this.partRows = windowState.partRows;
        this.rowIndex = windowState.rowIndex;
        this.rowId = windowState.rowId;
        this.isMasterRowSet = windowState.isMasterRowSet;
        this.omitRequest = windowState.omitRequest;
        if (windowState.isSetRowSetOrder()) {
            this.rowSetOrder = windowState.rowSetOrder;
        }
    }

    public WindowState deepCopy() {
        return new WindowState(this);
    }

    public void clear() {
        this.mode = LayoutMode.BROWSE;
        this.viewStyle = LayoutViewStyle.FORM;
        this.totalRows = 0;
        this.foundRows = 0;
        this.partRows = 0;
        this.rowIndex = 0;
        this.rowId = 0;
        this.setIsMasterRowSetIsSet(false);
        this.isMasterRowSet = false;
        this.setOmitRequestIsSet(false);
        this.omitRequest = false;
        this.rowSetOrder = null;
    }

    @Nullable
    public LayoutMode getMode() {
        return this.mode;
    }

    public void setMode(@Nullable LayoutMode layoutMode) {
        this.mode = layoutMode;
    }

    public void unsetMode() {
        this.mode = null;
    }

    public boolean isSetMode() {
        return this.mode != null;
    }

    public void setModeIsSet(boolean bl) {
        if (!bl) {
            this.mode = null;
        }
    }

    @Nullable
    public LayoutViewStyle getViewStyle() {
        return this.viewStyle;
    }

    public void setViewStyle(@Nullable LayoutViewStyle layoutViewStyle) {
        this.viewStyle = layoutViewStyle;
    }

    public void unsetViewStyle() {
        this.viewStyle = null;
    }

    public boolean isSetViewStyle() {
        return this.viewStyle != null;
    }

    public void setViewStyleIsSet(boolean bl) {
        if (!bl) {
            this.viewStyle = null;
        }
    }

    public int getTotalRows() {
        return this.totalRows;
    }

    public void setTotalRows(int n) {
        this.totalRows = n;
        this.setTotalRowsIsSet(true);
    }

    public void unsetTotalRows() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)0);
    }

    public boolean isSetTotalRows() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)0);
    }

    public void setTotalRowsIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)0, (boolean)bl);
    }

    public int getFoundRows() {
        return this.foundRows;
    }

    public void setFoundRows(int n) {
        this.foundRows = n;
        this.setFoundRowsIsSet(true);
    }

    public void unsetFoundRows() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)1);
    }

    public boolean isSetFoundRows() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)1);
    }

    public void setFoundRowsIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)1, (boolean)bl);
    }

    public int getPartRows() {
        return this.partRows;
    }

    public void setPartRows(int n) {
        this.partRows = n;
        this.setPartRowsIsSet(true);
    }

    public void unsetPartRows() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)2);
    }

    public boolean isSetPartRows() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)2);
    }

    public void setPartRowsIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)2, (boolean)bl);
    }

    public int getRowIndex() {
        return this.rowIndex;
    }

    public void setRowIndex(int n) {
        this.rowIndex = n;
        this.setRowIndexIsSet(true);
    }

    public void unsetRowIndex() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)3);
    }

    public boolean isSetRowIndex() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)3);
    }

    public void setRowIndexIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)3, (boolean)bl);
    }

    public int getRowId() {
        return this.rowId;
    }

    public void setRowId(int n) {
        this.rowId = n;
        this.setRowIdIsSet(true);
    }

    public void unsetRowId() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)4);
    }

    public boolean isSetRowId() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)4);
    }

    public void setRowIdIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)4, (boolean)bl);
    }

    public boolean isIsMasterRowSet() {
        return this.isMasterRowSet;
    }

    public void setIsMasterRowSet(boolean bl) {
        this.isMasterRowSet = bl;
        this.setIsMasterRowSetIsSet(true);
    }

    public void unsetIsMasterRowSet() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)5);
    }

    public boolean isSetIsMasterRowSet() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)5);
    }

    public void setIsMasterRowSetIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)5, (boolean)bl);
    }

    public boolean isOmitRequest() {
        return this.omitRequest;
    }

    public void setOmitRequest(boolean bl) {
        this.omitRequest = bl;
        this.setOmitRequestIsSet(true);
    }

    public void unsetOmitRequest() {
        this.__isset_bitfield = EncodingUtils.clearBit((byte)this.__isset_bitfield, (int)6);
    }

    public boolean isSetOmitRequest() {
        return EncodingUtils.testBit((byte)this.__isset_bitfield, (int)6);
    }

    public void setOmitRequestIsSet(boolean bl) {
        this.__isset_bitfield = EncodingUtils.setBit((byte)this.__isset_bitfield, (int)6, (boolean)bl);
    }

    @Nullable
    public RowSetOrder getRowSetOrder() {
        return this.rowSetOrder;
    }

    public void setRowSetOrder(@Nullable RowSetOrder rowSetOrder) {
        this.rowSetOrder = rowSetOrder;
    }

    public void unsetRowSetOrder() {
        this.rowSetOrder = null;
    }

    public boolean isSetRowSetOrder() {
        return this.rowSetOrder != null;
    }

    public void setRowSetOrderIsSet(boolean bl) {
        if (!bl) {
            this.rowSetOrder = null;
        }
    }

    public void setFieldValue(_Fields _Fields2, @Nullable Object object) {
        switch (_Fields2.ordinal()) {
            case 0: {
                if (object == null) {
                    this.unsetMode();
                    break;
                }
                this.setMode((LayoutMode)((Object)object));
                break;
            }
            case 1: {
                if (object == null) {
                    this.unsetViewStyle();
                    break;
                }
                this.setViewStyle((LayoutViewStyle)((Object)object));
                break;
            }
            case 2: {
                if (object == null) {
                    this.unsetTotalRows();
                    break;
                }
                this.setTotalRows((Integer)object);
                break;
            }
            case 3: {
                if (object == null) {
                    this.unsetFoundRows();
                    break;
                }
                this.setFoundRows((Integer)object);
                break;
            }
            case 4: {
                if (object == null) {
                    this.unsetPartRows();
                    break;
                }
                this.setPartRows((Integer)object);
                break;
            }
            case 5: {
                if (object == null) {
                    this.unsetRowIndex();
                    break;
                }
                this.setRowIndex((Integer)object);
                break;
            }
            case 6: {
                if (object == null) {
                    this.unsetRowId();
                    break;
                }
                this.setRowId((Integer)object);
                break;
            }
            case 7: {
                if (object == null) {
                    this.unsetIsMasterRowSet();
                    break;
                }
                this.setIsMasterRowSet((Boolean)object);
                break;
            }
            case 8: {
                if (object == null) {
                    this.unsetOmitRequest();
                    break;
                }
                this.setOmitRequest((Boolean)object);
                break;
            }
            case 9: {
                if (object == null) {
                    this.unsetRowSetOrder();
                    break;
                }
                this.setRowSetOrder((RowSetOrder)((Object)object));
            }
        }
    }

    @Nullable
    public Object getFieldValue(_Fields _Fields2) {
        switch (_Fields2.ordinal()) {
            case 0: {
                return this.getMode();
            }
            case 1: {
                return this.getViewStyle();
            }
            case 2: {
                return this.getTotalRows();
            }
            case 3: {
                return this.getFoundRows();
            }
            case 4: {
                return this.getPartRows();
            }
            case 5: {
                return this.getRowIndex();
            }
            case 6: {
                return this.getRowId();
            }
            case 7: {
                return this.isIsMasterRowSet();
            }
            case 8: {
                return this.isOmitRequest();
            }
            case 9: {
                return this.getRowSetOrder();
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
                return this.isSetMode();
            }
            case 1: {
                return this.isSetViewStyle();
            }
            case 2: {
                return this.isSetTotalRows();
            }
            case 3: {
                return this.isSetFoundRows();
            }
            case 4: {
                return this.isSetPartRows();
            }
            case 5: {
                return this.isSetRowIndex();
            }
            case 6: {
                return this.isSetRowId();
            }
            case 7: {
                return this.isSetIsMasterRowSet();
            }
            case 8: {
                return this.isSetOmitRequest();
            }
            case 9: {
                return this.isSetRowSetOrder();
            }
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object instanceof WindowState) {
            return this.equals((WindowState)object);
        }
        return false;
    }

    public boolean equals(WindowState windowState) {
        if (windowState == null) {
            return false;
        }
        if (this == windowState) {
            return true;
        }
        boolean bl = this.isSetMode();
        boolean bl2 = windowState.isSetMode();
        if (bl || bl2) {
            if (!bl || !bl2) {
                return false;
            }
            if (!this.mode.equals((Object)windowState.mode)) {
                return false;
            }
        }
        boolean bl3 = this.isSetViewStyle();
        boolean bl4 = windowState.isSetViewStyle();
        if (bl3 || bl4) {
            if (!bl3 || !bl4) {
                return false;
            }
            if (!this.viewStyle.equals((Object)windowState.viewStyle)) {
                return false;
            }
        }
        boolean bl5 = true;
        boolean bl6 = true;
        if (bl5 || bl6) {
            if (!bl5 || !bl6) {
                return false;
            }
            if (this.totalRows != windowState.totalRows) {
                return false;
            }
        }
        boolean bl7 = true;
        boolean bl8 = true;
        if (bl7 || bl8) {
            if (!bl7 || !bl8) {
                return false;
            }
            if (this.foundRows != windowState.foundRows) {
                return false;
            }
        }
        boolean bl9 = true;
        boolean bl10 = true;
        if (bl9 || bl10) {
            if (!bl9 || !bl10) {
                return false;
            }
            if (this.partRows != windowState.partRows) {
                return false;
            }
        }
        boolean bl11 = true;
        boolean bl12 = true;
        if (bl11 || bl12) {
            if (!bl11 || !bl12) {
                return false;
            }
            if (this.rowIndex != windowState.rowIndex) {
                return false;
            }
        }
        boolean bl13 = true;
        boolean bl14 = true;
        if (bl13 || bl14) {
            if (!bl13 || !bl14) {
                return false;
            }
            if (this.rowId != windowState.rowId) {
                return false;
            }
        }
        boolean bl15 = true;
        boolean bl16 = true;
        if (bl15 || bl16) {
            if (!bl15 || !bl16) {
                return false;
            }
            if (this.isMasterRowSet != windowState.isMasterRowSet) {
                return false;
            }
        }
        boolean bl17 = true;
        boolean bl18 = true;
        if (bl17 || bl18) {
            if (!bl17 || !bl18) {
                return false;
            }
            if (this.omitRequest != windowState.omitRequest) {
                return false;
            }
        }
        boolean bl19 = this.isSetRowSetOrder();
        boolean bl20 = windowState.isSetRowSetOrder();
        if (bl19 || bl20) {
            if (!bl19 || !bl20) {
                return false;
            }
            if (!this.rowSetOrder.equals((Object)windowState.rowSetOrder)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 8191 + (this.isSetMode() ? 131071 : 524287);
        if (this.isSetMode()) {
            n = n * 8191 + this.mode.getValue();
        }
        n = n * 8191 + (this.isSetViewStyle() ? 131071 : 524287);
        if (this.isSetViewStyle()) {
            n = n * 8191 + this.viewStyle.getValue();
        }
        n = n * 8191 + this.totalRows;
        n = n * 8191 + this.foundRows;
        n = n * 8191 + this.partRows;
        n = n * 8191 + this.rowIndex;
        n = n * 8191 + this.rowId;
        n = n * 8191 + (this.isMasterRowSet ? 131071 : 524287);
        n = n * 8191 + (this.omitRequest ? 131071 : 524287);
        n = n * 8191 + (this.isSetRowSetOrder() ? 131071 : 524287);
        if (this.isSetRowSetOrder()) {
            n = n * 8191 + this.rowSetOrder.getValue();
        }
        return n;
    }

    @Override
    public int compareTo(WindowState windowState) {
        if (!this.getClass().equals(windowState.getClass())) {
            return this.getClass().getName().compareTo(windowState.getClass().getName());
        }
        int n = 0;
        n = Boolean.compare(this.isSetMode(), windowState.isSetMode());
        if (n != 0) {
            return n;
        }
        if (this.isSetMode() && (n = TBaseHelper.compareTo((Comparable)((Object)this.mode), (Comparable)((Object)windowState.mode))) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetViewStyle(), windowState.isSetViewStyle());
        if (n != 0) {
            return n;
        }
        if (this.isSetViewStyle() && (n = TBaseHelper.compareTo((Comparable)((Object)this.viewStyle), (Comparable)((Object)windowState.viewStyle))) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetTotalRows(), windowState.isSetTotalRows());
        if (n != 0) {
            return n;
        }
        if (this.isSetTotalRows() && (n = TBaseHelper.compareTo((int)this.totalRows, (int)windowState.totalRows)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetFoundRows(), windowState.isSetFoundRows());
        if (n != 0) {
            return n;
        }
        if (this.isSetFoundRows() && (n = TBaseHelper.compareTo((int)this.foundRows, (int)windowState.foundRows)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetPartRows(), windowState.isSetPartRows());
        if (n != 0) {
            return n;
        }
        if (this.isSetPartRows() && (n = TBaseHelper.compareTo((int)this.partRows, (int)windowState.partRows)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetRowIndex(), windowState.isSetRowIndex());
        if (n != 0) {
            return n;
        }
        if (this.isSetRowIndex() && (n = TBaseHelper.compareTo((int)this.rowIndex, (int)windowState.rowIndex)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetRowId(), windowState.isSetRowId());
        if (n != 0) {
            return n;
        }
        if (this.isSetRowId() && (n = TBaseHelper.compareTo((int)this.rowId, (int)windowState.rowId)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetIsMasterRowSet(), windowState.isSetIsMasterRowSet());
        if (n != 0) {
            return n;
        }
        if (this.isSetIsMasterRowSet() && (n = TBaseHelper.compareTo((boolean)this.isMasterRowSet, (boolean)windowState.isMasterRowSet)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetOmitRequest(), windowState.isSetOmitRequest());
        if (n != 0) {
            return n;
        }
        if (this.isSetOmitRequest() && (n = TBaseHelper.compareTo((boolean)this.omitRequest, (boolean)windowState.omitRequest)) != 0) {
            return n;
        }
        n = Boolean.compare(this.isSetRowSetOrder(), windowState.isSetRowSetOrder());
        if (n != 0) {
            return n;
        }
        if (this.isSetRowSetOrder() && (n = TBaseHelper.compareTo((Comparable)((Object)this.rowSetOrder), (Comparable)((Object)windowState.rowSetOrder))) != 0) {
            return n;
        }
        return 0;
    }

    @Nullable
    public _Fields fieldForId(int n) {
        return _Fields.findByThriftId(n);
    }

    public void read(TProtocol tProtocol) throws TException {
        WindowState.scheme(tProtocol).read(tProtocol, (TBase)this);
    }

    public void write(TProtocol tProtocol) throws TException {
        WindowState.scheme(tProtocol).write(tProtocol, (TBase)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("WindowState(");
        boolean bl = true;
        stringBuilder.append("mode:");
        if (this.mode == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append((Object)this.mode);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("viewStyle:");
        if (this.viewStyle == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append((Object)this.viewStyle);
        }
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("totalRows:");
        stringBuilder.append(this.totalRows);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("foundRows:");
        stringBuilder.append(this.foundRows);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("partRows:");
        stringBuilder.append(this.partRows);
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
        stringBuilder.append("isMasterRowSet:");
        stringBuilder.append(this.isMasterRowSet);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("omitRequest:");
        stringBuilder.append(this.omitRequest);
        bl = false;
        if (!bl) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("rowSetOrder:");
        if (this.rowSetOrder == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append((Object)this.rowSetOrder);
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
        enumMap.put(_Fields.MODE, new FieldMetaData("mode", 3, (FieldValueMetaData)new EnumMetaData(-1, LayoutMode.class)));
        enumMap.put(_Fields.VIEW_STYLE, new FieldMetaData("viewStyle", 3, (FieldValueMetaData)new EnumMetaData(-1, LayoutViewStyle.class)));
        enumMap.put(_Fields.TOTAL_ROWS, new FieldMetaData("totalRows", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.FOUND_ROWS, new FieldMetaData("foundRows", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.PART_ROWS, new FieldMetaData("partRows", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.ROW_INDEX, new FieldMetaData("rowIndex", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.ROW_ID, new FieldMetaData("rowId", 3, new FieldValueMetaData(8)));
        enumMap.put(_Fields.IS_MASTER_ROW_SET, new FieldMetaData("isMasterRowSet", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.OMIT_REQUEST, new FieldMetaData("omitRequest", 3, new FieldValueMetaData(2)));
        enumMap.put(_Fields.ROW_SET_ORDER, new FieldMetaData("rowSetOrder", 3, (FieldValueMetaData)new EnumMetaData(-1, RowSetOrder.class)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(WindowState.class, metaDataMap);
    }

    public static enum _Fields implements TFieldIdEnum
    {
        MODE(1, "mode"),
        VIEW_STYLE(2, "viewStyle"),
        TOTAL_ROWS(3, "totalRows"),
        FOUND_ROWS(4, "foundRows"),
        PART_ROWS(5, "partRows"),
        ROW_INDEX(6, "rowIndex"),
        ROW_ID(7, "rowId"),
        IS_MASTER_ROW_SET(8, "isMasterRowSet"),
        OMIT_REQUEST(9, "omitRequest"),
        ROW_SET_ORDER(10, "rowSetOrder");

        private static final Map<String, _Fields> byName;
        private final short _thriftId;
        private final String _fieldName;

        @Nullable
        public static _Fields findByThriftId(int n) {
            switch (n) {
                case 1: {
                    return MODE;
                }
                case 2: {
                    return VIEW_STYLE;
                }
                case 3: {
                    return TOTAL_ROWS;
                }
                case 4: {
                    return FOUND_ROWS;
                }
                case 5: {
                    return PART_ROWS;
                }
                case 6: {
                    return ROW_INDEX;
                }
                case 7: {
                    return ROW_ID;
                }
                case 8: {
                    return IS_MASTER_ROW_SET;
                }
                case 9: {
                    return OMIT_REQUEST;
                }
                case 10: {
                    return ROW_SET_ORDER;
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

    private static class WindowStateStandardSchemeFactory
    implements SchemeFactory {
        private WindowStateStandardSchemeFactory() {
        }

        public WindowStateStandardScheme getScheme() {
            return new WindowStateStandardScheme();
        }
    }

    private static class WindowStateTupleSchemeFactory
    implements SchemeFactory {
        private WindowStateTupleSchemeFactory() {
        }

        public WindowStateTupleScheme getScheme() {
            return new WindowStateTupleScheme();
        }
    }

    private static class WindowStateTupleScheme
    extends TupleScheme<WindowState> {
        private WindowStateTupleScheme() {
        }

        public void write(TProtocol tProtocol, WindowState windowState) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = new BitSet();
            if (windowState.isSetMode()) {
                bitSet.set(0);
            }
            if (windowState.isSetViewStyle()) {
                bitSet.set(1);
            }
            if (windowState.isSetTotalRows()) {
                bitSet.set(2);
            }
            if (windowState.isSetFoundRows()) {
                bitSet.set(3);
            }
            if (windowState.isSetPartRows()) {
                bitSet.set(4);
            }
            if (windowState.isSetRowIndex()) {
                bitSet.set(5);
            }
            if (windowState.isSetRowId()) {
                bitSet.set(6);
            }
            if (windowState.isSetIsMasterRowSet()) {
                bitSet.set(7);
            }
            if (windowState.isSetOmitRequest()) {
                bitSet.set(8);
            }
            if (windowState.isSetRowSetOrder()) {
                bitSet.set(9);
            }
            tTupleProtocol.writeBitSet(bitSet, 10);
            if (windowState.isSetMode()) {
                tTupleProtocol.writeI32(windowState.mode.getValue());
            }
            if (windowState.isSetViewStyle()) {
                tTupleProtocol.writeI32(windowState.viewStyle.getValue());
            }
            if (windowState.isSetTotalRows()) {
                tTupleProtocol.writeI32(windowState.totalRows);
            }
            if (windowState.isSetFoundRows()) {
                tTupleProtocol.writeI32(windowState.foundRows);
            }
            if (windowState.isSetPartRows()) {
                tTupleProtocol.writeI32(windowState.partRows);
            }
            if (windowState.isSetRowIndex()) {
                tTupleProtocol.writeI32(windowState.rowIndex);
            }
            if (windowState.isSetRowId()) {
                tTupleProtocol.writeI32(windowState.rowId);
            }
            if (windowState.isSetIsMasterRowSet()) {
                tTupleProtocol.writeBool(windowState.isMasterRowSet);
            }
            if (windowState.isSetOmitRequest()) {
                tTupleProtocol.writeBool(windowState.omitRequest);
            }
            if (windowState.isSetRowSetOrder()) {
                tTupleProtocol.writeI32(windowState.rowSetOrder.getValue());
            }
        }

        public void read(TProtocol tProtocol, WindowState windowState) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol)tProtocol;
            BitSet bitSet = tTupleProtocol.readBitSet(10);
            if (bitSet.get(0)) {
                windowState.mode = LayoutMode.findByValue(tTupleProtocol.readI32());
                windowState.setModeIsSet(true);
            }
            if (bitSet.get(1)) {
                windowState.viewStyle = LayoutViewStyle.findByValue(tTupleProtocol.readI32());
                windowState.setViewStyleIsSet(true);
            }
            if (bitSet.get(2)) {
                windowState.totalRows = tTupleProtocol.readI32();
                windowState.setTotalRowsIsSet(true);
            }
            if (bitSet.get(3)) {
                windowState.foundRows = tTupleProtocol.readI32();
                windowState.setFoundRowsIsSet(true);
            }
            if (bitSet.get(4)) {
                windowState.partRows = tTupleProtocol.readI32();
                windowState.setPartRowsIsSet(true);
            }
            if (bitSet.get(5)) {
                windowState.rowIndex = tTupleProtocol.readI32();
                windowState.setRowIndexIsSet(true);
            }
            if (bitSet.get(6)) {
                windowState.rowId = tTupleProtocol.readI32();
                windowState.setRowIdIsSet(true);
            }
            if (bitSet.get(7)) {
                windowState.isMasterRowSet = tTupleProtocol.readBool();
                windowState.setIsMasterRowSetIsSet(true);
            }
            if (bitSet.get(8)) {
                windowState.omitRequest = tTupleProtocol.readBool();
                windowState.setOmitRequestIsSet(true);
            }
            if (bitSet.get(9)) {
                windowState.rowSetOrder = RowSetOrder.findByValue(tTupleProtocol.readI32());
                windowState.setRowSetOrderIsSet(true);
            }
        }
    }

    private static class WindowStateStandardScheme
    extends StandardScheme<WindowState> {
        private WindowStateStandardScheme() {
        }

        public void read(TProtocol tProtocol, WindowState windowState) throws TException {
            tProtocol.readStructBegin();
            while (true) {
                TField tField = tProtocol.readFieldBegin();
                if (tField.type == 0) break;
                switch (tField.id) {
                    case 1: {
                        if (tField.type == 8) {
                            windowState.mode = LayoutMode.findByValue(tProtocol.readI32());
                            windowState.setModeIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 2: {
                        if (tField.type == 8) {
                            windowState.viewStyle = LayoutViewStyle.findByValue(tProtocol.readI32());
                            windowState.setViewStyleIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 3: {
                        if (tField.type == 8) {
                            windowState.totalRows = tProtocol.readI32();
                            windowState.setTotalRowsIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 4: {
                        if (tField.type == 8) {
                            windowState.foundRows = tProtocol.readI32();
                            windowState.setFoundRowsIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 5: {
                        if (tField.type == 8) {
                            windowState.partRows = tProtocol.readI32();
                            windowState.setPartRowsIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 6: {
                        if (tField.type == 8) {
                            windowState.rowIndex = tProtocol.readI32();
                            windowState.setRowIndexIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 7: {
                        if (tField.type == 8) {
                            windowState.rowId = tProtocol.readI32();
                            windowState.setRowIdIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 8: {
                        if (tField.type == 2) {
                            windowState.isMasterRowSet = tProtocol.readBool();
                            windowState.setIsMasterRowSetIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 9: {
                        if (tField.type == 2) {
                            windowState.omitRequest = tProtocol.readBool();
                            windowState.setOmitRequestIsSet(true);
                            break;
                        }
                        TProtocolUtil.skip((TProtocol)tProtocol, (byte)tField.type);
                        break;
                    }
                    case 10: {
                        if (tField.type == 8) {
                            windowState.rowSetOrder = RowSetOrder.findByValue(tProtocol.readI32());
                            windowState.setRowSetOrderIsSet(true);
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
            windowState.validate();
        }

        public void write(TProtocol tProtocol, WindowState windowState) throws TException {
            windowState.validate();
            tProtocol.writeStructBegin(STRUCT_DESC);
            if (windowState.mode != null) {
                tProtocol.writeFieldBegin(MODE_FIELD_DESC);
                tProtocol.writeI32(windowState.mode.getValue());
                tProtocol.writeFieldEnd();
            }
            if (windowState.viewStyle != null) {
                tProtocol.writeFieldBegin(VIEW_STYLE_FIELD_DESC);
                tProtocol.writeI32(windowState.viewStyle.getValue());
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldBegin(TOTAL_ROWS_FIELD_DESC);
            tProtocol.writeI32(windowState.totalRows);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(FOUND_ROWS_FIELD_DESC);
            tProtocol.writeI32(windowState.foundRows);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(PART_ROWS_FIELD_DESC);
            tProtocol.writeI32(windowState.partRows);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(ROW_INDEX_FIELD_DESC);
            tProtocol.writeI32(windowState.rowIndex);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(ROW_ID_FIELD_DESC);
            tProtocol.writeI32(windowState.rowId);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(IS_MASTER_ROW_SET_FIELD_DESC);
            tProtocol.writeBool(windowState.isMasterRowSet);
            tProtocol.writeFieldEnd();
            tProtocol.writeFieldBegin(OMIT_REQUEST_FIELD_DESC);
            tProtocol.writeBool(windowState.omitRequest);
            tProtocol.writeFieldEnd();
            if (windowState.rowSetOrder != null) {
                tProtocol.writeFieldBegin(ROW_SET_ORDER_FIELD_DESC);
                tProtocol.writeI32(windowState.rowSetOrder.getValue());
                tProtocol.writeFieldEnd();
            }
            tProtocol.writeFieldStop();
            tProtocol.writeStructEnd();
        }
    }
}

