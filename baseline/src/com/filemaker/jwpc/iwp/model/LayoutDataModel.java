/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.model;

import com.filemaker.jwpc.iwp.metadata.ObjectMetaData;
import com.filemaker.jwpc.iwp.model.FieldObjectMetaDataModel;
import com.filemaker.jwpc.iwp.thrift.common.LayoutMode;
import com.filemaker.jwpc.iwp.thrift.common.LayoutViewStyle;
import com.filemaker.jwpc.iwp.thrift.common.RowSetOrder;
import com.filemaker.jwpc.iwp.thrift.common.WindowState;
import com.filemaker.jwpc.iwp.thrift.notification.LayoutModeChangeNotification;
import com.filemaker.jwpc.iwp.thrift.notification.LayoutNotification;
import com.filemaker.jwpc.iwp.thrift.notification.LoadCachedLayoutNotification;
import com.filemaker.jwpc.iwp.thrift.notification.ReloginNotification;
import com.filemaker.jwpc.iwp.thrift.notification.RowSelectionChangeNotification;
import com.filemaker.jwpc.iwp.thrift.notification.RowSetChangeNotification;
import com.filemaker.jwpc.iwp.thrift.notification.WindowChangeNotification;
import com.filemaker.jwpc.iwp.ui.event.EventType;
import com.filemaker.jwpc.iwp.ui.event.UIEvent;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class LayoutDataModel {
    private final List<UIEvent> pendingEvents = new ArrayList<UIEvent>();
    private ObjectMetaData metaData;
    private String layoutName;
    private LayoutViewStyle viewStyle;
    private LayoutMode viewMode;
    private Integer totalRows;
    private Integer foundRows;
    private Integer partRows;
    private Integer rowIndex;
    private Integer rowId;
    private Boolean isMasterRow;
    private Boolean omitRequest;
    private RowSetOrder rowSetOrder;

    public Map<Integer, FieldObjectMetaDataModel> getSortableFieldNames(boolean bl) {
        return this.metaData.getSortableFieldNames(bl);
    }

    public String getLayoutName() {
        return this.layoutName;
    }

    public String getLayoutTableName() {
        return this.metaData.getTableName();
    }

    public int getLayoutTableId() {
        return this.metaData.getTableId();
    }

    public LayoutViewStyle getViewStyle() {
        if (this.viewStyle == null && IWPUtilities.isDebugMode()) {
            Thread.dumpStack();
        }
        return this.viewStyle;
    }

    public LayoutMode getMode() {
        if (IWPUtilities.isDebugMode() && this.viewMode == null) {
            Thread.dumpStack();
        }
        return this.viewMode;
    }

    public boolean isModeSet() {
        return this.viewMode != null;
    }

    public int getTotalRecords() {
        return this.totalRows != null ? this.totalRows : 0;
    }

    public int getFoundRecords() {
        return this.foundRows != null ? this.foundRows : 0;
    }

    public int getPartInstCount() {
        return this.partRows != null ? this.partRows : 0;
    }

    public int getRecordIndex() {
        return this.rowIndex != null ? this.rowIndex : 0;
    }

    public int getRowId() {
        return this.rowId != null ? this.rowId : 0;
    }

    public boolean isMasterRecordSet() {
        return this.isMasterRow != null ? this.isMasterRow : false;
    }

    public boolean isOmitRequest() {
        return this.omitRequest != null ? this.omitRequest : false;
    }

    public RowSetOrder getRowSetOrder() {
        return this.rowSetOrder;
    }

    public boolean hasKeyTrigger() {
        return this.metaData != null ? this.metaData.hasKeyTrigger() : false;
    }

    public void update(ObjectMetaData objectMetaData) {
        this.metaData = objectMetaData;
        this.preparePendingEvent(objectMetaData.getLayoutName(), EventType.LAYOUT_NAME_CHANGE);
        this.layoutName = objectMetaData.getLayoutName();
    }

    public boolean updateRowId(int n) {
        boolean bl = false;
        if (this.rowId == null || this.rowId != n) {
            this.rowId = n;
            bl = true;
        }
        return bl;
    }

    public void updateOmitRequest(boolean bl) {
        this.omitRequest = bl;
    }

    public void update(LoadCachedLayoutNotification loadCachedLayoutNotification, boolean bl) {
        this.updateWindowState(loadCachedLayoutNotification.getWindowState(), bl);
    }

    public void update(RowSelectionChangeNotification rowSelectionChangeNotification, boolean bl) {
        this.updateWindowState(rowSelectionChangeNotification.getWindowState(), bl);
    }

    public void update(RowSetChangeNotification rowSetChangeNotification, boolean bl) {
        this.updateWindowState(rowSetChangeNotification.getWindowState(), bl);
    }

    public void update(LayoutNotification layoutNotification, boolean bl) {
        this.updateWindowState(layoutNotification.getWindowState(), bl);
    }

    public void update(ReloginNotification reloginNotification, boolean bl) {
        this.updateWindowState(reloginNotification.getWindowState(), bl);
    }

    public void update(WindowChangeNotification windowChangeNotification, boolean bl) {
        this.updateWindowState(windowChangeNotification.getWindowState(), bl);
    }

    public void update(LayoutModeChangeNotification layoutModeChangeNotification, boolean bl) {
        this.updateWindowState(layoutModeChangeNotification.getWindowState(), bl);
    }

    public List<UIEvent> getPendingEvents() {
        return this.pendingEvents;
    }

    private void updateWindowState(WindowState windowState, boolean bl) {
        this.preparePendingEvent(windowState, EventType.VIEW_STYLE_CHANGE);
        this.viewStyle = windowState.getViewStyle();
        this.preparePendingEvent(windowState, EventType.MODE_CHANGE);
        this.viewMode = windowState.getMode();
        this.preparePendingEvent(windowState, EventType.TOTAL_RECORDS_CHANGE);
        this.totalRows = windowState.getTotalRows();
        this.preparePendingEvent(windowState, EventType.FOUND_RECORDS_CHANGE);
        this.foundRows = windowState.getFoundRows();
        this.partRows = windowState.getPartRows();
        this.preparePendingEvent(windowState, EventType.RECORD_INDEX_CHANGE);
        this.rowIndex = windowState.getRowIndex();
        this.preparePendingEvent(windowState, EventType.MASTER_ROW_STATE_CHANGE);
        this.isMasterRow = windowState.isIsMasterRowSet();
        this.preparePendingEvent(windowState, EventType.OMIT_REQUEST_STATE_CHANGE);
        this.updateOmitRequest(windowState.isOmitRequest());
        this.preparePendingEvent(windowState, EventType.SORTING_STATE_CHANGE);
        this.rowSetOrder = windowState.getRowSetOrder();
        if (bl) {
            this.updateRowId(windowState.getRowId());
        }
    }

    private void preparePendingEvent(WindowState windowState, EventType eventType) {
        switch (eventType) {
            case VIEW_STYLE_CHANGE: {
                if (this.viewStyle == windowState.getViewStyle()) break;
                this.pendingEvents.add(new UIEvent(EventType.VIEW_STYLE_CHANGE));
                break;
            }
            case MODE_CHANGE: {
                if (this.viewMode == windowState.getMode()) break;
                this.pendingEvents.add(new UIEvent(EventType.MODE_CHANGE));
                break;
            }
            case TOTAL_RECORDS_CHANGE: {
                if (this.totalRows != null && this.totalRows.intValue() == windowState.getTotalRows()) break;
                this.pendingEvents.add(new UIEvent(EventType.TOTAL_RECORDS_CHANGE));
                break;
            }
            case FOUND_RECORDS_CHANGE: {
                if (this.foundRows != null && this.foundRows.intValue() == windowState.getFoundRows()) break;
                this.pendingEvents.add(new UIEvent(EventType.FOUND_RECORDS_CHANGE));
                break;
            }
            case RECORD_INDEX_CHANGE: {
                if (this.rowIndex != null && this.rowIndex.intValue() == windowState.getRowIndex()) break;
                this.pendingEvents.add(new UIEvent(EventType.RECORD_INDEX_CHANGE));
                break;
            }
            case MASTER_ROW_STATE_CHANGE: {
                if (this.isMasterRow != null && this.isMasterRow.booleanValue() == windowState.isIsMasterRowSet()) break;
                this.pendingEvents.add(new UIEvent(EventType.MASTER_ROW_STATE_CHANGE));
                break;
            }
            case OMIT_REQUEST_STATE_CHANGE: {
                if (this.omitRequest != null && this.omitRequest.booleanValue() == windowState.isOmitRequest()) break;
                this.pendingEvents.add(new UIEvent(EventType.OMIT_REQUEST_STATE_CHANGE));
                break;
            }
            case SORTING_STATE_CHANGE: {
                if (this.rowSetOrder == windowState.getRowSetOrder()) break;
                this.pendingEvents.add(new UIEvent(EventType.SORTING_STATE_CHANGE));
            }
        }
    }

    private void preparePendingEvent(String string, EventType eventType) {
        switch (eventType) {
            case LAYOUT_NAME_CHANGE: {
                if (this.layoutName != null && this.layoutName.equals(string)) break;
                this.pendingEvents.add(new UIEvent(EventType.LAYOUT_NAME_CHANGE));
            }
        }
    }

    public boolean isEventEffectingModel(EventType eventType) {
        switch (eventType) {
            case VIEW_STYLE_CHANGE: 
            case MODE_CHANGE: 
            case TOTAL_RECORDS_CHANGE: 
            case FOUND_RECORDS_CHANGE: 
            case RECORD_INDEX_CHANGE: 
            case MASTER_ROW_STATE_CHANGE: 
            case OMIT_REQUEST_STATE_CHANGE: 
            case SORTING_STATE_CHANGE: 
            case LAYOUT_NAME_CHANGE: {
                return true;
            }
        }
        return false;
    }
}

