/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.data.provider.DataCommunicator
 *  com.vaadin.server.Sizeable$Unit
 *  com.vaadin.shared.Range
 *  com.vaadin.ui.Grid
 *  com.vaadin.ui.Grid$SelectionMode
 *  com.vaadin.v7.data.Item
 */
package com.filemaker.jwpc.iwp.ui.layout.list;

import com.filemaker.jwpc.iwp.ui.layout.LayoutContainer;
import com.filemaker.jwpc.iwp.ui.layout.list.LayoutListView;
import com.filemaker.jwpc.iwp.ui.layout.list.ListDataCommunicator;
import com.filemaker.jwpc.iwp.ui.layout.list.ListRow;
import com.filemaker.jwpc.iwp.util.IWPConstants;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.ListComponentClientRpc;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.ListComponentServerRpc;
import com.filemaker.jwpc.iwp.widgetset.client.state.ListComponentState;
import com.vaadin.data.provider.DataCommunicator;
import com.vaadin.server.Sizeable;
import com.vaadin.shared.Range;
import com.vaadin.ui.Grid;
import com.vaadin.v7.data.Item;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Map;

public final class ListComponent
extends Grid<Item> {
    private WeakReference<LayoutListView> view;
    private ListComponentServerRpc serverRpc;
    private Range visibleRowRange;
    private double listViewContentsHeight;

    public ListComponent(final WeakReference<LayoutListView> weakReference, boolean bl, ListDataCommunicator listDataCommunicator) {
        super((DataCommunicator)listDataCommunicator);
        this.view = weakReference;
        this.getState().dynamicRowHeight = bl;
        this.getState().scrollPositionEnabled = IWPConstants.LIST_SCROLL_POSITION_ENABLED;
        this.visibleRowRange = Range.emptyRange();
        this.listViewContentsHeight = 0.0;
        this.setSizeFull();
        this.setSelectionMode(Grid.SelectionMode.SINGLE);
        this.setHeaderVisible(false);
        this.setFooterVisible(false);
        this.setColumnReorderingAllowed(false);
        this.serverRpc = new ListComponentServerRpc(){
            final /* synthetic */ ListComponent this$0;
            {
                this.this$0 = listComponent;
            }

            @Override
            public void onRowVisibilityChange(int n, int n2) {
                this.this$0.visibleRowRange = Range.between((int)n, (int)n2);
                this.this$0.onRowVisibilityChanged();
            }

            @Override
            public void onBrowserWindowResized(int n, int n2) {
                ((LayoutListView)weakReference.get()).onBrowserWindowResized(n, n2);
            }
        };
        this.registerRpc(this.serverRpc);
    }

    public void cleanupMemory() {
    }

    public ListComponentState getState() {
        return (ListComponentState)super.getState();
    }

    public Map<Object, Item> getCachedData() {
        return ((ListDataCommunicator)this.getDataCommunicator()).getActiveData();
    }

    public Range getCachedDataRange() {
        Object[] objectArray = this.getCachedData().keySet().toArray();
        if (objectArray.length > 0) {
            Arrays.sort(objectArray);
            return Range.withLength((int)((Integer)objectArray[0]), (int)objectArray.length);
        }
        return null;
    }

    public Item getCachedRowDataByListIndex(int n) {
        return this.getCachedData().get(n);
    }

    public Item getCachedRowDataByRowKey(String string) {
        for (Item item : this.getCachedData().values()) {
            if (!((ListRow)item).getRowKey().equals(string)) continue;
            return item;
        }
        return null;
    }

    public Item getCachedRowDataByRowId(int n) {
        for (Item item : this.getCachedData().values()) {
            if (((ListRow)item).getRowId() != n) continue;
            return item;
        }
        return null;
    }

    public boolean isRowDataAvailable(String string) {
        ListRow listRow = (ListRow)this.getCachedRowDataByRowKey(string);
        return listRow != null && listRow.isValid();
    }

    public boolean isRowVisible(int n) {
        int n2 = n - 1;
        return this.visibleRowRange.contains(n2);
    }

    public void scrollToDynamicHeightRow(int n) {
        ((ListComponentClientRpc)this.getRpcProxy(ListComponentClientRpc.class)).scrollToDynamicHeightRow(n);
    }

    public void recalculateScrollbarsForVirtualViewport() {
        ((ListComponentClientRpc)this.getRpcProxy(ListComponentClientRpc.class)).recalculateScrollbarsForVirtualViewport();
    }

    public float getListViewContentsHeight() {
        return (float)this.listViewContentsHeight;
    }

    public void setHeight(float f, Sizeable.Unit unit) {
        super.setHeight(f, unit);
        if (((LayoutListView)this.view.get()).getBodyAndFiller() != null) {
            ((LayoutListView)this.view.get()).adjustFiller();
        }
    }

    public void setDebugLogEnabled(boolean bl) {
        this.getState().debugLogEnabled = bl;
    }

    private double getTotalVisibleRowsHeight(int n, int n2) {
        Range range = Range.between((int)n, (int)n2);
        double d = 0.0;
        for (int i = range.getStart(); i < range.getEnd(); ++i) {
            ListRow listRow = (ListRow)this.getCachedRowDataByListIndex(i);
            if (listRow == null) continue;
            d += (double)listRow.getItemProperty().getHeight();
        }
        return d;
    }

    public void beforeClientResponse(boolean bl) {
        super.beforeClientResponse(bl);
        if (this.getDataCommunicator().getDataProviderSize() == 0) {
            ((LayoutListView)this.view.get()).getListState().setInitialLoad(true);
        }
    }

    public void refreshAll() {
        this.getCachedData().values().forEach(item -> ((ListRow)((Object)item)).setValid(false));
        this.getDataProvider().refreshAll();
        if (((LayoutListView)this.view.get()).getRowCount() == 0) {
            this.resetScrollPosition();
            if (this.listViewContentsHeight != 0.0) {
                this.listViewContentsHeight = 0.0;
                ((LayoutListView)this.view.get()).adjustFiller();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void onRowVisibilityChanged() {
        LayoutContainer layoutContainer = ((LayoutListView)this.view.get()).getLayoutContainer();
        synchronized (layoutContainer) {
            int n = this.visibleRowRange.getStart();
            int n2 = this.visibleRowRange.getEnd();
            boolean bl = this.checkRowDataAvailibility(n, n2);
            if (bl) {
                double d;
                for (int i = n; i < n2; ++i) {
                    ListRow listRow = (ListRow)this.getCachedRowDataByListIndex(i);
                    listRow.getItemProperty().updateCustomBodyExpandedSizesIfNeeded();
                }
                double d2 = d = n == 0 ? this.getTotalVisibleRowsHeight(n, n2) : Double.MAX_VALUE;
                if (d != this.listViewContentsHeight) {
                    this.listViewContentsHeight = d;
                    ((LayoutListView)this.view.get()).adjustFiller();
                }
                this.updateVerticalScrollSizeIfNeeded();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void onDataLoaded(boolean bl, boolean bl2) {
        LayoutContainer layoutContainer = ((LayoutListView)this.view.get()).getLayoutContainer();
        synchronized (layoutContainer) {
            ((ListComponentClientRpc)this.getRpcProxy(ListComponentClientRpc.class)).onDataLoaded();
            this.onRowVisibilityChanged();
            if (bl || bl2) {
                this.scrollToStart();
                this.resetScrollPosition();
            }
        }
    }

    private void updateVerticalScrollSizeIfNeeded() {
        int n = ((LayoutListView)this.view.get()).getRowCount();
        if (this.getState().dynamicRowHeight && n != 0) {
            if (n == this.getCachedData().size()) {
                int n2 = ((LayoutListView)this.view.get()).calculateListHeight();
                int n3 = ((LayoutListView)this.view.get()).getLayoutMetaData().getBodyMetaData().getHeightAsInt() * n;
                if (n3 < n2) {
                    double d = this.getTotalVisibleRowsHeight(0, n);
                    double d2 = d / (double)n;
                    this.setBodyRowHeight(d2);
                } else {
                    this.resetVerticalScrollSize();
                }
            } else {
                this.resetVerticalScrollSize();
            }
        }
    }

    private boolean checkRowDataAvailibility(int n, int n2) {
        boolean bl = true;
        for (int i = n; i < n2; ++i) {
            ListRow listRow = (ListRow)this.getCachedRowDataByListIndex(i);
            if (listRow != null && listRow.isValid()) continue;
            bl = false;
            break;
        }
        return bl;
    }

    public void setMaxTouchMoveOffset(int n) {
        this.getState().maxTouchMoveOffset = n;
    }

    public void updatePageLength(int n, double d, double d2) {
        ((ListComponentClientRpc)this.getRpcProxy(ListComponentClientRpc.class)).updatePageLength(n, d, d2);
    }

    public void resetScrollPosition() {
        ((ListComponentClientRpc)this.getRpcProxy(ListComponentClientRpc.class)).resetScrollPosition();
    }

    public void onModeChanged() {
        if (this.getState().dynamicRowHeight) {
            this.resetVerticalScrollSize();
        }
    }

    private void resetVerticalScrollSize() {
        this.setBodyRowHeight(((LayoutListView)this.view.get()).getLayoutMetaData().getBodyMetaData().getHeightAsInt());
    }

    public void setBodyRowHeight(double d) {
        if (this.getState().bodyRowHeight != d) {
            super.setBodyRowHeight(d);
        }
    }
}

