/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.v7.data.Container
 *  com.vaadin.v7.data.Item
 *  com.vaadin.v7.ui.Table$ColumnHeaderMode
 *  com.vaadin.v7.ui.Table$RowHeaderMode
 *  org.vaadin.addons.lazyquerycontainer.LazyQueryDefinition
 *  org.vaadin.addons.lazyquerycontainer.LazyQueryView
 *  org.vaadin.addons.lazyquerycontainer.QueryDefinition
 *  org.vaadin.addons.lazyquerycontainer.QueryFactory
 */
package com.filemaker.jwpc.iwp.ui.layout.component.portal;

import com.filemaker.jwpc.iwp.action.ActionResultGetterHandler;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.metadata.PortalMetaData;
import com.filemaker.jwpc.iwp.model.DataUpdator;
import com.filemaker.jwpc.iwp.thrift.common.LayoutMode;
import com.filemaker.jwpc.iwp.thrift.common.ObjectSpec;
import com.filemaker.jwpc.iwp.thrift.layout.PortalData;
import com.filemaker.jwpc.iwp.thrift.layout.PortalRowCount;
import com.filemaker.jwpc.iwp.thrift.layout.SinglePartObjectsData;
import com.filemaker.jwpc.iwp.thrift.layout.SingleRowPartsData;
import com.filemaker.jwpc.iwp.ui.layout.AbstractTable;
import com.filemaker.jwpc.iwp.ui.layout.LayoutContainer;
import com.filemaker.jwpc.iwp.ui.layout.LayoutContainerState;
import com.filemaker.jwpc.iwp.ui.layout.LayoutObjectBuildingBlock;
import com.filemaker.jwpc.iwp.ui.layout.QueryFactory;
import com.filemaker.jwpc.iwp.ui.layout.component.portal.Portal;
import com.filemaker.jwpc.iwp.ui.layout.component.portal.PortalQueryContainer;
import com.filemaker.jwpc.iwp.ui.layout.component.portal.PortalRow;
import com.filemaker.jwpc.iwp.ui.layout.component.portal.PortalRowProperty;
import com.filemaker.jwpc.iwp.ui.layout.component.portal.PortalState;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.PortalTableClientRpc;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.PortalTableServerRpc;
import com.filemaker.jwpc.iwp.widgetset.client.state.PortalTableState;
import com.vaadin.v7.data.Container;
import com.vaadin.v7.data.Item;
import com.vaadin.v7.ui.Table;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import org.vaadin.addons.lazyquerycontainer.LazyQueryDefinition;
import org.vaadin.addons.lazyquerycontainer.LazyQueryView;
import org.vaadin.addons.lazyquerycontainer.QueryDefinition;

public class PortalTable
extends AbstractTable
implements LayoutObjectBuildingBlock {
    protected static final String PORTAL_CELL_ID = "PORTAL_CELL_ID";
    private static final String CSS = "iwp-portal";
    private static final int numCachePages = 7;
    private final PortalState portalState = new PortalState();
    private final PortalMetaData metaData;
    private PortalQueryContainer queryContainer;
    private final Portal parent;
    private int dummyRowsCount;
    private boolean forceEmptyRowForFindMode;
    private boolean modeChangedSinceLastRefresh = false;
    private int pendingGetRowsRequests = 0;
    public boolean makeActiveRowVisibleAfterRefresh = false;
    private final App app;
    private PortalTableRefreshState internalRefreshState;

    public PortalTable(App app, Portal portal, PortalMetaData portalMetaData) {
        this.app = app;
        this.initBooleanState();
        this.parent = portal;
        this.metaData = portalMetaData;
        this.setSizeFull();
        this.setStyleName(CSS);
        this.setColumnHeaderMode(Table.ColumnHeaderMode.HIDDEN);
        this.setRowHeaderMode(Table.RowHeaderMode.HIDDEN);
        this.setEditable(false);
        this.setMultiSelect(false);
        this.setColumnReorderingAllowed(false);
        this.setColumnCollapsingAllowed(false);
        this.setColumnExpandRatio(PORTAL_CELL_ID, 1.0f);
        if (portalMetaData.isAllowDelete()) {
            this.setSelectable(true);
        }
        int n = this.calculatePageLength();
        this.queryContainer = new PortalQueryContainer(new LazyQueryView((QueryDefinition)new LazyQueryDefinition(false, n, null), (org.vaadin.addons.lazyquerycontainer.QueryFactory)new QueryFactory(this)));
        this.queryContainer.addContainerProperty(PORTAL_CELL_ID, PortalRowProperty.class, null, false, false);
        this.queryContainer.getQueryView().setMaxCacheSize(this.getPageLength() * 7);
        this.setSize(0);
        this.setPageLength(n);
        this.internalRefreshState = new PortalTableRefreshState(this);
        this.registerServerRpc();
        this.getState().isListView = app.isListView();
    }

    public void cleanupMemory() {
        for (PortalRow portalRow : this.queryContainer.getCachedPortalRows()) {
            portalRow.cleanupMemory();
        }
    }

    @Override
    public boolean deleteAllItems() {
        this.cleanupMemory();
        return true;
    }

    @Override
    public void beforeClientResponse(boolean bl) {
        super.beforeClientResponse(bl);
        this.updateBooleanState(PortalTableState.BooleanState.showScrollbar, this.metaData.isShowScrollbar());
        this.updateBooleanState(PortalTableState.BooleanState.hasScript, this.metaData.hasValidAndExecutableScript());
        this.markAsDirty();
    }

    private void updateBooleanState(PortalTableState.BooleanState booleanState, boolean bl) {
        this.getState().ptbs = IWPUtilities.applyBooleanValue(this.getState().ptbs, booleanState.ordinal(), bl);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void handleGetPortalRowsCountNotification(PortalRowCount portalRowCount, boolean bl) {
        LayoutContainer layoutContainer = this.app.getLayoutContainer();
        synchronized (layoutContainer) {
            if (bl) {
                this.setPortalDisplayDataSize(portalRowCount.getRowCount());
                this.setContainerDataSource((Container)this.queryContainer);
                this.updateHideCondition(portalRowCount.isHideConditionOn());
            } else {
                if (this.app.isBrowseMode() && !this.modeChangedSinceLastRefresh && this.portalState.getPortalRowCount() == portalRowCount.getRowCount()) {
                    this.handlePortalRowCountResponse(portalRowCount, true);
                } else {
                    this.handlePortalRowCountResponse(portalRowCount, false);
                }
                this.modeChangedSinceLastRefresh = false;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void handleGetPortalRowsNotification(PortalData portalData) {
        LayoutContainer layoutContainer = this.app.getLayoutContainer();
        synchronized (layoutContainer) {
            boolean bl = false;
            if (this.parent.getCurrentSelectedCell() != null && this.parent.getCurrentSelectedCell().isNewRelatedRecordRow()) {
                bl = true;
            }
            Collection<PortalRow> collection = this.queryContainer.getCachedPortalRows();
            PortalRow portalRow = this.queryContainer.getCachedPortalRow(this.getNewCreatePortalRowIndex());
            this.updatePortalRows(collection, portalData, portalRow);
            this.app.getActiveUIHandler().refreshActiveUI();
            LayoutContainerState layoutContainerState = this.app.getLayoutContainer().getContainerState();
            ObjectSpec objectSpec = layoutContainerState.getPortalRefreshState().getActivePopoverButtonSpec();
            if (objectSpec != null && objectSpec.getParentPortalId() == this.metaData.getObjectId()) {
                this.app.getLayoutContainer().getPopoverHandler().openPopover(layoutContainerState.getPortalRefreshState().getActivePopoverId(), objectSpec);
                layoutContainerState.getPortalRefreshState().setActivePopoverButtonSpec(null);
            }
            if (bl) {
                this.app.getAppSession().getActiveRowState(true, false);
            }
        }
    }

    public void handleGetPortalLayoutObjectsDataNotification(PortalData portalData) {
        Collection<PortalRow> collection = this.queryContainer.getCachedPortalRows();
        PortalRow portalRow = this.queryContainer.getCachedPortalRow(this.getNewCreatePortalRowIndex());
        this.updatePortalRows(collection, portalData, portalRow);
    }

    @Override
    public boolean isRowVisible(int n) {
        return super.isRowVisible(n);
    }

    public List<Item> loadItems(int n, int n2) {
        boolean bl;
        ArrayList<Item> arrayList = new ArrayList<Item>();
        if (!this.portalState.isValid()) {
            return arrayList;
        }
        boolean bl2 = n + n2 >= this.size();
        boolean bl3 = bl = this.portalState.hasNewPortalRow() && bl2;
        if (bl) {
            --n2;
        }
        if (this.dummyRowsCount > 0) {
            n2 -= this.dummyRowsCount;
        }
        this.createPortalRows(arrayList, n, n2, bl, this.dummyRowsCount);
        return arrayList;
    }

    private void createPortalRows(List<Item> list, int n, int n2, boolean bl, int n3) {
        int n4 = this.getPortalRowIndexFromItemId(n);
        List<PortalRow> list2 = this.createOriginalRows(n4, n2);
        list.addAll(list2);
        PortalRow portalRow = null;
        if (bl) {
            int n5 = this.getNewCreatePortalRowIndex();
            PortalRowProperty portalRowProperty = this.getVisibleCell(n5);
            if (portalRowProperty != null) {
                portalRowProperty.updateNewRelatedRecordRow(true);
            } else {
                portalRowProperty = this.parent.view.getUIGenerator().generatePortalRowUI(this.metaData, this.parent, this.parent.getAttributes().getRecordIndex(), this.parent.getAttributes().getRowId(), n5, true);
            }
            portalRow = new PortalRow();
            portalRow.addItemProperty(portalRowProperty);
            list.add((Item)portalRow);
        }
        if (n3 > 0) {
            this.createDummyRow(list, n3);
        }
        if (!this.forceEmptyRowForFindMode) {
            this.scheduleGetOriginalRowsData(n4, n2, bl);
        } else {
            this.forceEmptyRowForFindMode = false;
            this.createDummyRow(list, 1);
        }
    }

    private void createDummyRow(List<Item> list, int n) {
        for (int i = 0; i < n; ++i) {
            PortalRowProperty portalRowProperty = new PortalRowProperty(this.app, this.metaData, this.parent, this.parent.getAttributes(), false);
            PortalRow portalRow = new PortalRow();
            portalRow.addItemProperty(portalRowProperty);
            list.add((Item)portalRow);
        }
    }

    private List<PortalRow> createOriginalRows(int n, int n2) {
        ArrayList<PortalRow> arrayList = new ArrayList<PortalRow>();
        int n3 = n;
        for (int i = 0; i < n2; ++i) {
            PortalRowProperty portalRowProperty = this.getVisibleCell(n3);
            if (portalRowProperty != null) {
                portalRowProperty.updateNewRelatedRecordRow(false);
            } else if (this.parent.view != null && this.parent.view.getUIGenerator() != null) {
                portalRowProperty = this.parent.view.getUIGenerator().generatePortalRowUI(this.metaData, this.parent, this.parent.getAttributes().getRecordIndex(), this.parent.getAttributes().getRowId(), n3, false);
            }
            PortalRow portalRow = new PortalRow();
            portalRow.addItemProperty(portalRowProperty);
            arrayList.add(portalRow);
            ++n3;
        }
        return arrayList;
    }

    private void scheduleGetOriginalRowsData(int n, int n2, boolean bl) {
        if (n2 > 0 || bl) {
            this.app.getAppSession().getPortalRows(new ActionResultGetterHandler(){

                @Override
                public void onFinish(Object object) {
                    PortalTable.this.handleGetPortalRowsNotification((PortalData)object);
                    PortalTable.this.getPortalRowsTaskEnded();
                }
            }, this.parent.getAttributes().getObjectSpec(), n, n2, bl);
            this.getPortalRowsTaskStarted();
        }
    }

    private void getPortalRowsTaskStarted() {
        ++this.pendingGetRowsRequests;
    }

    private void getPortalRowsTaskEnded() {
        --this.pendingGetRowsRequests;
        if (this.pendingGetRowsRequests == 0 && this.makeActiveRowVisibleAfterRefresh) {
            this.makeRowVisible(this.app.getLayoutDataModel().getRecordIndex(), null);
            this.makeActiveRowVisibleAfterRefresh = false;
        }
    }

    private void updateHideCondition(boolean bl) {
        DataUpdator dataUpdator = this.app.getLayoutContainer().getCurrentView().getDataUpdator();
        if (this.parent.hasHideCondition() && (this.app.isBrowseMode() || this.app.isFindMode() && bl != this.parent.isHideConditionOn())) {
            dataUpdator.updateFieldHideCondition(this.parent, bl, false);
        }
    }

    private void updatePortalRows(Collection<PortalRow> collection, PortalData portalData, PortalRow portalRow) {
        Object object;
        DataUpdator dataUpdator = this.app.getLayoutContainer().getCurrentView().getDataUpdator();
        this.updateHideCondition(portalData.isHideConditionOn());
        Object object2 = collection.iterator();
        while (object2.hasNext()) {
            object = object2.next();
            PortalRowProperty portalRowProperty = ((PortalRow)((Object)object)).getRowProperty();
            SingleRowPartsData singleRowPartsData = portalData.getPortalRowData().get(portalRowProperty.getAttributes().getPortalRecordIndex());
            if (singleRowPartsData == null || portalRowProperty.isNewRelatedRecordRow()) continue;
            dataUpdator.updatePortalNonFieldObjects(portalRowProperty, portalData.getNonFieldObjectsData().getObjects());
            if (singleRowPartsData.getPartsData().size() != 1) continue;
            SinglePartObjectsData singlePartObjectsData = singleRowPartsData.getPartsData().get(0);
            dataUpdator.updatePortalNonFieldObjects(portalRowProperty, singlePartObjectsData.getNonFieldObjectsData());
            dataUpdator.updatePortalFieldObjects(portalRowProperty, singlePartObjectsData.getFieldObjectsData());
        }
        if (portalRow != null && (object2 = portalRow.getRowProperty()) != null && ((PortalRowProperty)object2).isNewRelatedRecordRow()) {
            dataUpdator.updatePortalNonFieldObjects((PortalRowProperty)object2, portalData.getNonFieldObjectsData().getObjects());
            if (portalData.getNewPortalRowData().getPartsData().size() == 1) {
                object = portalData.getNewPortalRowData().getPartsData().get(0);
                dataUpdator.updatePortalNonFieldObjects((PortalRowProperty)object2, ((SinglePartObjectsData)object).getNonFieldObjectsData());
                dataUpdator.updatePortalFieldObjects((PortalRowProperty)object2, ((SinglePartObjectsData)object).getFieldObjectsData());
            }
        }
        if (this.metaData.useCurrentFoundSet()) {
            this.parent.setPortalFocus(this.app.getLayoutDataModel().getRecordIndex(), this.parent);
        }
    }

    @Override
    public PortalTableState getState() {
        return (PortalTableState)super.getState();
    }

    public PortalRowProperty getPortalCell(int n) {
        PortalRow portalRow = this.queryContainer.getCachedPortalRow(n);
        if (portalRow != null) {
            return portalRow.getRowProperty();
        }
        return null;
    }

    public int getRowHeight() {
        return PortalRowProperty.getPortalRowHeight(this.metaData);
    }

    public int getPortalHeight() {
        return this.metaData.getHeightAsInt();
    }

    private void handlePortalRowCountResponse(PortalRowCount portalRowCount, boolean bl) {
        this.setPortalDisplayDataSize(portalRowCount.getRowCount());
        this.updateHideCondition(portalRowCount.isHideConditionOn());
        if (bl) {
            this.refreshCachedPortalRows();
        } else {
            this.queryContainer.removeAllItems();
        }
    }

    protected void refresh() {
        if (!this.isInternalRefreshInProgress()) {
            final LayoutContainerState.PortalRefreshState portalRefreshState = this.app.getLayoutContainer().getContainerState().getPortalRefreshState();
            portalRefreshState.setPortalRefreshInProgress(true, this.metaData.getObjectId());
            this.setInternalRefreshInProgress(true);
            this.app.getAppSession().getPortalRowsCount(new ActionResultGetterHandler(){
                final /* synthetic */ PortalTable this$0;
                {
                    this.this$0 = portalTable;
                }

                @Override
                public void onFinish(Object object) {
                    this.this$0.handleGetPortalRowsCountNotification((PortalRowCount)object, false);
                    portalRefreshState.setPortalRefreshInProgress(false, 0);
                    this.this$0.setInternalRefreshInProgress(false);
                }
            }, this.parent.getAttributes().getObjectSpec(), false, this.parent.getAttributes().getRecordIndex(), this.parent.getObjectId());
        }
    }

    protected void refreshObjects(Set<Integer> set) {
        Collection<PortalRow> collection = this.queryContainer.getCachedPortalRows();
        int n = collection.size();
        if (n > 0) {
            boolean bl;
            int n2 = this.getCurrentPageFirstItemIndex();
            boolean bl2 = n2 + n >= this.size();
            boolean bl3 = bl = this.portalState.hasNewPortalRow() && bl2;
            if (bl) {
                --n;
            }
            this.app.getAppSession().getPortalLayoutObjectsData(new ActionResultGetterHandler(){

                @Override
                public void onFinish(Object object) {
                    PortalTable.this.handleGetPortalLayoutObjectsDataNotification((PortalData)object);
                }
            }, this.parent.getAttributes().getObjectSpec(), this.getPortalRowIndexFromItemId(n2), n, bl, set);
        }
    }

    private void refreshCachedPortalRows() {
        if (this.queryContainer.getCachedPortalRows().size() > 0) {
            PriorityQueue<PortalRow> priorityQueue = new PriorityQueue<PortalRow>(this.queryContainer.getCachedPortalRows().size(), new Comparator<PortalRow>(this){

                @Override
                public int compare(PortalRow portalRow, PortalRow portalRow2) {
                    return portalRow.getPortalRecordIndex() - portalRow2.getPortalRecordIndex();
                }
            });
            priorityQueue.addAll(this.queryContainer.getCachedPortalRows());
            ArrayList<PortalRow> arrayList = new ArrayList<PortalRow>();
            while (priorityQueue.size() > 0) {
                PortalRow portalRow = priorityQueue.poll();
                if (portalRow.getPortalRecordIndex() <= 0) continue;
                if (arrayList.size() == 0) {
                    arrayList.add(portalRow);
                    continue;
                }
                if (portalRow.getPortalRecordIndex() == ((PortalRow)((Object)arrayList.get(0))).getPortalRecordIndex() + arrayList.size()) {
                    arrayList.add(portalRow);
                    continue;
                }
                this.handleRefreshCachedPortalRows(arrayList);
                arrayList = new ArrayList();
                arrayList.add(portalRow);
            }
            if (arrayList.size() > 0) {
                this.handleRefreshCachedPortalRows(arrayList);
            }
        }
    }

    private void handleRefreshCachedPortalRows(List<PortalRow> list) {
        int n = list.get(0).getPortalRecordIndex();
        int n2 = list.size();
        if (this.portalState.hasNewPortalRow() && list.get(n2 - 1).getPortalRecordIndex() == this.getNewCreatePortalRowIndex()) {
            this.scheduleGetOriginalRowsData(n, --n2, true);
        } else {
            this.scheduleGetOriginalRowsData(n, n2, false);
        }
    }

    public boolean setPortalDisplayDataSize(int n) {
        int n2;
        int n3;
        this.portalState.setPortalRowCount(n);
        if (this.app.isBrowseMode() && n == -1) {
            this.portalState.setValid(false);
            this.dummyRowsCount = 0;
            this.portalState.setNewPortalRow(false);
            this.setSize(0);
            return true;
        }
        this.portalState.setValid(true);
        boolean bl = false;
        int n4 = n;
        if (this.app.isBrowseMode()) {
            if ((n4 = n4 - this.metaData.getInitialRowIndex() + 1) < 0) {
                n4 = 0;
            }
            if (this.metaData.isAllowCreate()) {
                bl = true;
                ++n4;
            }
            if (!this.isShowScrollbar() && n4 > (n3 = this.metaData.getDisplayRowCount())) {
                n4 = n3;
                bl = false;
            }
        } else {
            int n5 = n4 = this.metaData.useCurrentFoundSet() ? n : 1;
        }
        if ((n3 = n4 * this.getRowHeight()) < this.getPortalHeight()) {
            n2 = this.getPortalHeight() - n3;
            this.dummyRowsCount = n2 / this.getRowHeight();
            n4 += this.dummyRowsCount;
        } else {
            this.dummyRowsCount = 0;
        }
        if (this.portalState.hasNewPortalRow() != bl || this.size() != n4) {
            this.portalState.setNewPortalRow(bl);
            this.setSize(n4);
            n2 = this.getPortalHeight() / this.getRowHeight();
            if (this.getPageLength() < n2) {
                this.setPageLength(n2);
                this.queryContainer.getQueryView().setMaxCacheSize(n2 * 7);
                this.queryContainer.getQueryView().getQueryDefinition().setBatchSize(n2);
            }
            return true;
        }
        return false;
    }

    public int getPortalRowIndexFromItemId(int n) {
        int n2 = 1;
        if (this.app.isBrowseMode() || this.metaData.useCurrentFoundSet()) {
            n2 = n + this.metaData.getInitialRowIndex();
        }
        return n2;
    }

    private int getNewCreatePortalRowIndex() {
        int n = 0;
        if (this.app.isBrowseMode()) {
            n = this.portalState.getPortalRowCount() + 1;
        }
        return n;
    }

    private int calculatePageLength() {
        int n = IWPUtilities.getBatchSize(this.app, this.getPortalHeight(), this.getRowHeight(), 10);
        if (IWPUtilities.isDebugMode()) {
            this.app.getMessenger().showTrayMessage("Portal data batch size: " + n);
        }
        return n;
    }

    public void forceEmptyPortalRowsInFindMode() {
        this.forceEmptyRowForFindMode = true;
        this.forceEmptyPortalRows();
    }

    public void forceEmptyPortalRows() {
        this.setPortalDisplayDataSize(0);
        this.queryContainer.removeAllItems();
    }

    private void initBooleanState() {
        this.updateBooleanState(PortalTableState.BooleanState.showScrollbar, true);
    }

    public boolean isShowScrollbar() {
        return IWPUtilities.getBooleanValue(this.getState().ptbs, PortalTableState.BooleanState.showScrollbar.ordinal());
    }

    public void changeVariables(Object object, Map<String, Object> map) {
        int n;
        if (map.containsKey("pagelength") && (n = ((Integer)map.get("pagelength")).intValue()) > this.getPageLength() && n <= this.calculatePageLength() * 2) {
            this.queryContainer.getQueryView().setMaxCacheSize(n * 7);
            this.queryContainer.getQueryView().getQueryDefinition().setBatchSize(n);
        }
        super.changeVariables(object, map);
    }

    private PortalRowProperty getVisibleCell(int n) {
        if (this.pageBuffer != null) {
            for (int i = 5; i < this.pageBuffer.length; ++i) {
                for (int j = 0; j < this.pageBuffer[i].length; ++j) {
                    PortalRowProperty portalRowProperty = (PortalRowProperty)this.pageBuffer[i][j];
                    if (portalRowProperty.getPortalRecordIndex() != n) continue;
                    return portalRowProperty;
                }
            }
        }
        return null;
    }

    public void setModeChangedSinceLastRefresh(boolean bl) {
        this.modeChangedSinceLastRefresh = bl;
    }

    private void registerServerRpc() {
        this.registerRpc(new PortalTableServerRpc(){

            @Override
            public void checkNewRows() {
                PortalTable.this.checkRowsCount();
            }
        });
    }

    public void checkRowsCount() {
        this.app.getAppSession().getPortalRowsCount(new ActionResultGetterHandler(){

            @Override
            public void onFinish(Object object) {
                PortalRowCount portalRowCount = (PortalRowCount)object;
                if (PortalTable.this.app.isBrowseMode() && PortalTable.this.portalState.getPortalRowCount() < portalRowCount.getRowCount()) {
                    ((PortalTableClientRpc)PortalTable.this.getRpcProxy(PortalTableClientRpc.class)).notifyNewRows();
                    PortalTable.this.handlePortalRowCountResponse(portalRowCount, false);
                }
            }
        }, this.parent.getAttributes().getObjectSpec(), false, this.parent.getAttributes().getRecordIndex(), this.parent.getObjectId());
    }

    public void setInternalRefreshInProgress(boolean bl) {
        this.internalRefreshState.setInternalRefreshInProgress(bl, this.app.getCurrentLayoutMode());
    }

    public boolean isInternalRefreshInProgress() {
        return this.internalRefreshState.isInternalRefreshInProgress(this.app.getCurrentLayoutMode());
    }

    private class PortalTableRefreshState {
        private boolean refreshInProgress = false;
        private LayoutMode layoutMode = LayoutMode.UNKNOWN;

        public PortalTableRefreshState(PortalTable portalTable) {
        }

        public void setInternalRefreshInProgress(boolean bl, LayoutMode layoutMode) {
            this.refreshInProgress = bl;
            this.layoutMode = layoutMode;
        }

        public boolean isInternalRefreshInProgress(LayoutMode layoutMode) {
            return this.refreshInProgress && this.layoutMode == layoutMode;
        }
    }
}

