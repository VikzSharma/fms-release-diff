/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.v7.data.Property
 *  com.vaadin.v7.data.util.PropertysetItem
 */
package com.filemaker.jwpc.iwp.ui.layout.list;

import com.filemaker.jwpc.iwp.metadata.PartMetaData;
import com.filemaker.jwpc.iwp.model.PartObjectsModel;
import com.filemaker.jwpc.iwp.thrift.layout.NonFieldObjectsData;
import com.filemaker.jwpc.iwp.thrift.layout.SingleRowPartsData;
import com.filemaker.jwpc.iwp.ui.layout.component.Body;
import com.filemaker.jwpc.iwp.ui.layout.list.LayoutListView;
import com.filemaker.jwpc.iwp.ui.layout.list.ListRowProperty;
import com.vaadin.v7.data.Property;
import com.vaadin.v7.data.util.PropertysetItem;
import java.util.Map;

public class ListRow
extends PropertysetItem {
    private ListRowProperty rowProperty;
    private final LayoutListView listView;
    private final PartMetaData bodyMetaData;
    private int recordIndex;
    private int rowId;
    private boolean valid;
    private int listIndex;

    public ListRow(LayoutListView layoutListView, PartMetaData partMetaData, int n) {
        this.listView = layoutListView;
        this.bodyMetaData = partMetaData;
        this.recordIndex = n;
    }

    public void cleanupMemory() {
        this.rowProperty.cleanupMemory();
    }

    public int getRowId() {
        return this.rowId;
    }

    public void setRowId(int n) {
        this.rowId = n;
    }

    public void setRecordIndex(int n) {
        this.recordIndex = n;
    }

    public boolean addItemProperty(Property property) {
        this.rowProperty = (ListRowProperty)property;
        return super.addItemProperty((Object)"LIST_VIEW_PROPERTY_ID", property);
    }

    public void updateRowData(SingleRowPartsData singleRowPartsData, Map<Integer, NonFieldObjectsData> map) {
        this.rowProperty.updateRowData(singleRowPartsData, map);
    }

    public ListRowProperty getItemProperty() {
        return this.rowProperty;
    }

    public Body getRowProperty() {
        return this.rowProperty.getBody();
    }

    public int getRecordIndex() {
        return this.recordIndex;
    }

    public LayoutListView getListView() {
        return this.listView;
    }

    public PartMetaData getBodyMetaData() {
        return this.bodyMetaData;
    }

    public void addActiveRowStyleName() {
        if (this.rowProperty.getBodyMetaData().hasActiveStyle() && this.rowProperty.getBody() != null) {
            this.rowProperty.getBody().onActive();
        }
    }

    public void removeActiveRowStyleName() {
        if (this.rowProperty.getBody() != null) {
            this.rowProperty.getBody().onInactive();
        }
    }

    public void rowRemoved() {
        PartObjectsModel partObjectsModel = this.rowProperty.getPartObjectsModel();
        if (partObjectsModel != null) {
            partObjectsModel.clear();
        }
    }

    public void setVisible(boolean bl) {
        if (bl) {
            this.rowProperty.removeStyleName("loading");
        } else {
            this.rowProperty.addStyleName("loading");
        }
    }

    public void setValid(boolean bl) {
        this.valid = bl;
    }

    public boolean isValid() {
        return this.valid;
    }

    public int getListIndex() {
        return this.listIndex;
    }

    public void setListIndex(int n) {
        this.listIndex = n;
    }

    public String getRowKey() {
        StringBuilder stringBuilder = new StringBuilder().append(this.recordIndex);
        if (this.listView.getLayoutMetaData().hasNoBody()) {
            stringBuilder.append("_").append(this.rowProperty.getPartIndex());
        }
        return stringBuilder.toString();
    }
}

