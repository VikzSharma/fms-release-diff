/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.data.ValueProvider
 *  com.vaadin.data.provider.CallbackDataProvider
 *  com.vaadin.data.provider.CallbackDataProvider$CountCallback
 *  com.vaadin.data.provider.CallbackDataProvider$FetchCallback
 *  com.vaadin.data.provider.DataProvider
 *  com.vaadin.data.provider.Query
 *  com.vaadin.data.provider.QuerySortOrder
 *  com.vaadin.server.SerializableSupplier
 *  com.vaadin.server.Sizeable$Unit
 *  com.vaadin.shared.Range
 *  com.vaadin.shared.ui.grid.ScrollDestination
 *  com.vaadin.ui.Component
 *  com.vaadin.ui.CssLayout
 *  com.vaadin.ui.Grid$FetchItemsCallback
 *  com.vaadin.ui.Panel
 *  com.vaadin.ui.renderers.AbstractRenderer
 *  com.vaadin.ui.renderers.ComponentRenderer
 *  com.vaadin.v7.data.Item
 *  com.vaadin.v7.ui.VerticalLayout
 */
package com.filemaker.jwpc.iwp.ui.layout.list;

import com.filemaker.jwpc.iwp.action.ActionResultGetterHandler;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.application.AppCardWindowContainer;
import com.filemaker.jwpc.iwp.metadata.ObjectMetaData;
import com.filemaker.jwpc.iwp.metadata.PartMetaData;
import com.filemaker.jwpc.iwp.model.PartObjectsModel;
import com.filemaker.jwpc.iwp.notification.processor.BrowserInfoHandler;
import com.filemaker.jwpc.iwp.thrift.common.Dimensions;
import com.filemaker.jwpc.iwp.thrift.common.FilteredValueListSubsetRequest;
import com.filemaker.jwpc.iwp.thrift.common.FilteredValueListSubsetResult;
import com.filemaker.jwpc.iwp.thrift.common.LayoutObjectType;
import com.filemaker.jwpc.iwp.thrift.common.LayoutViewStyle;
import com.filemaker.jwpc.iwp.thrift.common.ObjectSpec;
import com.filemaker.jwpc.iwp.thrift.common.ValueListItemRequest;
import com.filemaker.jwpc.iwp.thrift.common.ValueListItemResult;
import com.filemaker.jwpc.iwp.thrift.common.ValueListSubsetRequest;
import com.filemaker.jwpc.iwp.thrift.common.ValueListSubsetResult;
import com.filemaker.jwpc.iwp.thrift.layout.FieldObjectData;
import com.filemaker.jwpc.iwp.thrift.layout.LayoutData;
import com.filemaker.jwpc.iwp.thrift.layout.LayoutDataResult;
import com.filemaker.jwpc.iwp.thrift.layout.NonFieldObjectData;
import com.filemaker.jwpc.iwp.thrift.layout.NonFieldObjectsData;
import com.filemaker.jwpc.iwp.thrift.layout.PartDataResult;
import com.filemaker.jwpc.iwp.thrift.layout.SinglePartObjectsData;
import com.filemaker.jwpc.iwp.thrift.layout.SingleRowPartsData;
import com.filemaker.jwpc.iwp.thrift.notification.ActiveRowStateNotification;
import com.filemaker.jwpc.iwp.ui.event.EventType;
import com.filemaker.jwpc.iwp.ui.event.UIEvent;
import com.filemaker.jwpc.iwp.ui.event.UIEventListener;
import com.filemaker.jwpc.iwp.ui.layout.LayoutContainer;
import com.filemaker.jwpc.iwp.ui.layout.LayoutContainerState;
import com.filemaker.jwpc.iwp.ui.layout.LayoutObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutObjectBuildingBlock;
import com.filemaker.jwpc.iwp.ui.layout.LayoutView;
import com.filemaker.jwpc.iwp.ui.layout.TableLoadCompleteHandler;
import com.filemaker.jwpc.iwp.ui.layout.component.Body;
import com.filemaker.jwpc.iwp.ui.layout.component.BottomNavigation;
import com.filemaker.jwpc.iwp.ui.layout.component.Footer;
import com.filemaker.jwpc.iwp.ui.layout.component.Header;
import com.filemaker.jwpc.iwp.ui.layout.component.Popup;
import com.filemaker.jwpc.iwp.ui.layout.component.RadioSet;
import com.filemaker.jwpc.iwp.ui.layout.component.TopNavigation;
import com.filemaker.jwpc.iwp.ui.layout.component.WDVerticalSplitPanel;
import com.filemaker.jwpc.iwp.ui.layout.component.popover.PopoverButton;
import com.filemaker.jwpc.iwp.ui.layout.list.ListComponent;
import com.filemaker.jwpc.iwp.ui.layout.list.ListDataCommunicator;
import com.filemaker.jwpc.iwp.ui.layout.list.ListRow;
import com.filemaker.jwpc.iwp.ui.layout.list.ListRowProperty;
import com.filemaker.jwpc.iwp.ui.layout.list.ListViewState;
import com.filemaker.jwpc.iwp.util.IWPConstants;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.vaadin.data.ValueProvider;
import com.vaadin.data.provider.CallbackDataProvider;
import com.vaadin.data.provider.DataProvider;
import com.vaadin.data.provider.Query;
import com.vaadin.data.provider.QuerySortOrder;
import com.vaadin.server.SerializableSupplier;
import com.vaadin.server.Sizeable;
import com.vaadin.shared.Range;
import com.vaadin.shared.ui.grid.ScrollDestination;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Panel;
import com.vaadin.ui.renderers.AbstractRenderer;
import com.vaadin.ui.renderers.ComponentRenderer;
import com.vaadin.v7.data.Item;
import com.vaadin.v7.ui.VerticalLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Stream;

public final class LayoutListView
extends LayoutView
implements LayoutObjectBuildingBlock,
UIEventListener {
    public static final boolean DEBUG_LOG_ENABLED = false;
    public static final String LIST_VIEW_PROPERTY_ID = "LIST_VIEW_PROPERTY_ID";
    private Header header;
    private Footer footer;
    private WDVerticalSplitPanel bodyAndFooter;
    private WDVerticalSplitPanel bodyAndFiller;
    private CssLayout gridContainer;
    private ListComponent gridComponent;
    private ListRowProperty emptyRow;
    private final ListViewState listState = new ListViewState();
    private List<TableLoadCompleteHandler> loadCompleteHandlers = new ArrayList<TableLoadCompleteHandler>();
    private boolean dynamicRowHeight;
    private Timer valueListThrottleTimer;
    private int valueListThrottleDelay;
    private Map<ObjectSpec, ValueListSubsetRequest> valueListRequests;
    private Timer filteredValueListThrottleTimer;
    private int filteredValueListThrottleDelay;
    private Map<ObjectSpec, FilteredValueListSubsetRequest> filteredValueListRequests;
    private Timer valueListItemThrottleTimer;
    private int valueListItemThrottleDelay;
    private Map<ObjectSpec, ValueListItemRequest> valueListItemRequests;
    private boolean sortChanged = false;
    private boolean modeChanged = false;

    public LayoutListView(App app, LayoutContainer layoutContainer, String string, long l) {
        super(app, layoutContainer, string, l);
        NoCommitPanel noCommitPanel = new NoCommitPanel();
        noCommitPanel.setContent((Component)new VerticalLayout());
        noCommitPanel.setSizeFull();
        noCommitPanel.addStyleName("iwp-list-base-layout-style");
        this.viewComponent = noCommitPanel;
        this.valueListThrottleDelay = IWPConstants.LIST_VALUELIST_THROTTLE_DELAY;
        this.filteredValueListThrottleDelay = IWPConstants.LIST_FILTERED_VALUELIST_THROTTLE_DELAY;
        this.valueListItemThrottleDelay = IWPConstants.LIST_VALUELIST_ITEM_THROTTLE_DELAY;
        this.app.subscribe(this, EventType.VIEW_STYLE_CHANGE, EventType.MODE_CHANGE, EventType.MOVE_RESIZE_CARD_STYLE_WINDOW);
    }

    @Override
    public void cleanupMemory() {
        super.cleanupMemory();
        this.cleanupUI();
        if (!this.app.getAppView().isCardStyleWindow() && this.gridComponent != null) {
            this.gridComponent.cleanupMemory();
            this.gridComponent = null;
        }
        this.app.unsubscribe(this, EventType.VIEW_STYLE_CHANGE, EventType.MODE_CHANGE, EventType.MOVE_RESIZE_CARD_STYLE_WINDOW);
        this.cleanupValueListRequests();
        this.cleanupFilteredValueListRequests();
        this.cleanupValueListItemRequests();
        this.listState.cleanupMemory();
        this.loadCompleteHandlers.clear();
        this.loadCompleteHandlers = null;
    }

    @Override
    public LayoutViewStyle getViewStyle() {
        return LayoutViewStyle.LIST;
    }

    @Override
    public Component getViewComponent() {
        return this.viewComponent;
    }

    public Header getHeader() {
        return this.header;
    }

    public Footer getFooter() {
        return this.footer;
    }

    private void cleanupUI() {
        VerticalLayout verticalLayout = (VerticalLayout)this.getRootComponent().getContent();
        verticalLayout.removeAllComponents();
        if (this.bodyAndFooter != null) {
            this.bodyAndFooter.cleanupMemory();
        }
        if (this.bodyAndFiller != null) {
            this.bodyAndFiller.cleanupMemory();
        }
    }

    @Override
    public void updateLayoutUI(ObjectMetaData objectMetaData, String string, String string2, boolean bl) {
        this.cleanupUI();
        if (this.gridComponent != null) {
            this.gridComponent.cleanupMemory();
            this.gridComponent = null;
        }
        super.updateLayoutUI(objectMetaData, string, string2, bl);
        this.dynamicRowHeight = this.checkDynamicRowHeight();
        if (this.dynamicRowHeight) {
            this.listState.setInitialLoad(true);
        }
        this.gridComponent = new ListComponent(new WeakReference<LayoutListView>(this), this.dynamicRowHeight, new ListDataCommunicator());
        this.gridComponent.setDebugLogEnabled(false);
        this.gridComponent.setMaxTouchMoveOffset(IWPConstants.LIST_MAX_TOUCHMOVE_OFFSET);
        this.gridComponent.setDataProvider((DataProvider)new ListRowsDataProvider());
        if (this.metaData.getBodyMetaData() != null) {
            this.gridComponent.addColumn(new ListRowProvider(), (AbstractRenderer)new ComponentRenderer());
            this.gridComponent.setBodyRowHeight(this.metaData.getBodyMetaData().getHeightAsInt());
        }
        this.gridComponent.updatePageLength(this.calculatePageLength(), IWPConstants.LIST_MAX_CACHE_MULTIPLIER, IWPConstants.LIST_MAX_CACHE_MULTIPLIER);
        this.initFixedPartsUI();
        this.initDynamicPartsUI();
    }

    private void initDynamicPartsUI() {
        VerticalLayout verticalLayout = (VerticalLayout)this.getRootComponent().getContent();
        verticalLayout.setSpacing(false);
        verticalLayout.setMargin(false);
        Dimensions dimensions = this.app.getBrowserInfoHandler().getBrowserClientInfo().getBrowserDimensions();
        boolean bl = this.isClassicTheme() && this.metaData.getWidthAsInt() < dimensions.getWidth();
        verticalLayout.setSizeUndefined();
        if (bl) {
            verticalLayout.setWidth(100.0f, Sizeable.Unit.PERCENTAGE);
        }
        verticalLayout.setHeight(100.0f, Sizeable.Unit.PERCENTAGE);
        verticalLayout.addStyleName("iwps_layout_background");
        ArrayList<String> arrayList = this.metaData.getCustomStyles();
        if (arrayList != null) {
            for (String string : arrayList) {
                verticalLayout.addStyleName(string);
            }
        }
        if (this.header != null) {
            verticalLayout.addComponent((Component)this.header);
        }
        if (this.topNav != null || this.bottomNav != null) {
            this.removeNavPartsIfNeeded(this.layoutContainer);
            if (this.topNav != null) {
                this.layoutContainer.addComponent(this.topNav);
            }
            if (this.bottomNav != null) {
                this.layoutContainer.addComponent(this.bottomNav);
            }
        }
        this.initBodyAndFooterComponent();
        verticalLayout.addComponent((Component)this.bodyAndFooter);
        verticalLayout.setExpandRatio((Component)this.bodyAndFooter, 1.0f);
    }

    private NoCommitPanel getRootComponent() {
        return (NoCommitPanel)this.viewComponent;
    }

    private void initBodyAndFooterComponent() {
        this.bodyAndFooter = new WDVerticalSplitPanel(this.app);
        this.bodyAndFooter.setCaption(null);
        this.bodyAndFooter.setSizeFull();
        this.bodyAndFooter.setLocked(true);
        this.bodyAndFiller = new WDVerticalSplitPanel(this.app);
        this.bodyAndFiller.setCaption(null);
        this.bodyAndFiller.setSizeFull();
        this.bodyAndFiller.setLocked(true);
        this.gridContainer = new CssLayout();
        this.gridContainer.addStyleName("iwps_fm-list-container");
        this.gridContainer.setSizeFull();
        this.bodyAndFiller.addComponent((Component)this.gridContainer);
        this.gridComponent.addStyleName("iwps_body_container");
        this.gridComponent.setHeight(this.calculateListHeight(), Sizeable.Unit.PIXELS);
        this.gridComponent.setWidth(this.metaData.getWidthAsInt(), Sizeable.Unit.PIXELS);
        Dimensions dimensions = this.app.getBrowserInfoHandler().getBrowserClientInfo().getBrowserDimensions();
        if (this.isClassicTheme() && this.metaData.getWidthAsInt() < dimensions.getWidth()) {
            this.gridComponent.setWidth(100.0f, Sizeable.Unit.PERCENTAGE);
        }
        this.gridContainer.addComponent((Component)this.gridComponent);
        CssLayout cssLayout = new CssLayout();
        cssLayout.addStyleName("iwps_fm-list-view-filler");
        this.bodyAndFiller.addComponent((Component)cssLayout);
        this.bodyAndFooter.addComponent((Component)this.bodyAndFiller);
        if (this.footer != null) {
            this.bodyAndFooter.addComponent(this.footer);
            this.bodyAndFooter.setSplitPosition((int)this.footer.getHeight(), Sizeable.Unit.PIXELS, true);
            this.bodyAndFooter.setMinSplitPosition((int)this.footer.getHeight(), Sizeable.Unit.PIXELS);
        } else {
            this.bodyAndFooter.setSplitPosition(0.0f, Sizeable.Unit.PIXELS, true);
        }
    }

    private void initFixedPartsUI() {
        boolean bl;
        PartObjectsModel partObjectsModel = this.getViewModel().getFixedPartsObjectsModel();
        ObjectMetaData objectMetaData = this.metaData.getMetaData(LayoutObjectType.HEADER);
        if (objectMetaData != null && objectMetaData.getHeightAsInt() > 0) {
            this.header = this.uiGenerator.generateLayoutPartUI(Header.class, partObjectsModel, objectMetaData, this.app.getLayoutDataModel().getRecordIndex(), this.app.getLayoutDataModel().getRowId(), 0);
        }
        if ((objectMetaData = this.metaData.getMetaData(LayoutObjectType.TOP_NAV_PART)) != null && objectMetaData.getHeightAsInt() > 0) {
            this.topNav = this.uiGenerator.generateLayoutPartUI(TopNavigation.class, partObjectsModel, objectMetaData, this.app.getLayoutDataModel().getRecordIndex(), this.app.getLayoutDataModel().getRowId(), 0);
        }
        if ((objectMetaData = this.metaData.getMetaData(LayoutObjectType.FOOTER)) != null && objectMetaData.getHeightAsInt() > 0) {
            this.footer = this.uiGenerator.generateLayoutPartUI(Footer.class, partObjectsModel, objectMetaData, this.app.getLayoutDataModel().getRecordIndex(), this.app.getLayoutDataModel().getRowId(), 0);
        }
        if ((objectMetaData = this.metaData.getMetaData(LayoutObjectType.BOTTOM_NAV_PART)) != null && objectMetaData.getHeightAsInt() > 0) {
            this.bottomNav = this.uiGenerator.generateLayoutPartUI(BottomNavigation.class, partObjectsModel, objectMetaData, this.app.getLayoutDataModel().getRecordIndex(), this.app.getLayoutDataModel().getRowId(), 0);
        }
        Dimensions dimensions = this.app.getBrowserInfoHandler().getBrowserClientInfo().getBrowserDimensions();
        boolean bl2 = bl = this.isClassicTheme() && this.metaData.getWidthAsInt() < dimensions.getWidth();
        if (bl) {
            if (this.header != null) {
                this.header.setWidth(100.0f, Sizeable.Unit.PERCENTAGE);
            }
            if (this.footer != null) {
                this.footer.setWidth(100.0f, Sizeable.Unit.PERCENTAGE);
            }
            if (this.topNav != null) {
                this.topNav.setWidth(100.0f, Sizeable.Unit.PERCENTAGE);
            }
            if (this.bottomNav != null) {
                this.bottomNav.setWidth(100.0f, Sizeable.Unit.PERCENTAGE);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void refreshViewData(boolean bl, boolean bl2, boolean bl3) {
        this.app.getCommunicationComponent().updateTabOrdering(new ArrayList<String>());
        this.refreshFixedPartData(false);
        LayoutContainer layoutContainer = this.layoutContainer;
        synchronized (layoutContainer) {
            if (bl2 && this.metaData.hasNoBody()) {
                this.sortChanged = true;
            }
            this.refreshContainerData();
            this.changeCurrentRow(bl);
        }
        this.app.getActiveUIHandler().setPendingTabbing(false);
        this.app.getAppView().tryEnableTabKeyHandlingInBrowser();
    }

    @Override
    public void updateModeChange() {
        this.modeChanged = true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateRowSet(int n, int n2, boolean bl, boolean bl2, boolean bl3) {
        this.refreshFixedPartData(true);
        LayoutContainer layoutContainer = this.layoutContainer;
        synchronized (layoutContainer) {
            boolean bl4;
            if (bl2 && this.metaData.hasNoBody()) {
                this.sortChanged = true;
            }
            this.refreshContainerData();
            boolean bl5 = bl4 = bl3 || bl;
            if (bl4) {
                this.changeCurrentRow();
            }
        }
    }

    String getRowKey(int n, int n2) {
        StringBuilder stringBuilder = new StringBuilder().append(n);
        if (this.metaData.hasNoBody()) {
            stringBuilder.append("_").append(n2);
        }
        return stringBuilder.toString();
    }

    protected void refreshContainerData() {
        if (this.dynamicRowHeight && this.getRowCount() == 0) {
            if (this.emptyRow == null) {
                this.fetchEmptyRow();
                this.gridContainer.setWidth((float)this.metaData.getWidthAsInt(), Sizeable.Unit.PIXELS);
                this.gridContainer.addStyleName("empty-list");
                this.gridComponent.addStyleName("empty-list");
            }
        } else if (this.emptyRow != null) {
            this.gridContainer.removeComponent((Component)this.emptyRow);
            this.emptyRow.cleanupMemory();
            this.emptyRow = null;
            this.gridContainer.setWidthFull();
            this.gridContainer.removeStyleName("empty-list");
            this.gridComponent.removeStyleName("empty-list");
        }
        this.gridComponent.refreshAll();
    }

    protected void refreshFixedPartData(boolean bl) {
        if (this.header != null) {
            this.app.getAppSession().getDataForCurrentPart(new ActionResultGetterHandler(){

                @Override
                public void onFinish(Object object) {
                    LayoutListView.this.updateFixedPartData((PartDataResult)object);
                }
            }, this.header.getMetaData().getPartIndex(), bl);
        }
        if (this.footer != null) {
            this.app.getAppSession().getDataForCurrentPart(new ActionResultGetterHandler(){

                @Override
                public void onFinish(Object object) {
                    LayoutListView.this.updateFixedPartData((PartDataResult)object);
                }
            }, this.footer.getMetaData().getPartIndex(), bl);
        }
        if (this.topNav != null) {
            this.app.getAppSession().getDataForCurrentPart(new ActionResultGetterHandler(){

                @Override
                public void onFinish(Object object) {
                    LayoutListView.this.updateFixedPartData((PartDataResult)object);
                }
            }, this.topNav.getMetaData().getPartIndex(), bl);
        }
        if (this.bottomNav != null) {
            this.app.getAppSession().getDataForCurrentPart(new ActionResultGetterHandler(){

                @Override
                public void onFinish(Object object) {
                    LayoutListView.this.updateFixedPartData((PartDataResult)object);
                }
            }, this.bottomNav.getMetaData().getPartIndex(), bl);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateFixedPartData(PartDataResult partDataResult) {
        LayoutContainer layoutContainer = this.layoutContainer;
        synchronized (layoutContainer) {
            SinglePartObjectsData singlePartObjectsData;
            int n = partDataResult.getPartData().getPartObjectsData().getPartIndex();
            Map<Integer, NonFieldObjectsData> map = partDataResult.getPartData().getPartNonFieldObjectsData();
            NonFieldObjectsData nonFieldObjectsData = map.get(n);
            if (nonFieldObjectsData != null) {
                this.updateStaticData(nonFieldObjectsData.getObjects());
            }
            if ((singlePartObjectsData = partDataResult.getPartData().getPartObjectsData()) != null) {
                this.updateStaticData(singlePartObjectsData.getNonFieldObjectsData());
                this.updateFieldData(singlePartObjectsData.getFieldObjectsData());
            }
        }
    }

    @Override
    public void updateFieldObject(FieldObjectData fieldObjectData) {
        String string = this.getRowKey(fieldObjectData.getObjectSpec().getRowIndex(), fieldObjectData.getObjectSpec().getPartIndex());
        if (this.gridComponent.isRowDataAvailable(string)) {
            this.dataUpdator.updateFieldObject(fieldObjectData);
        }
    }

    @Override
    public void refreshRowSetData(boolean bl) {
        this.refreshViewData(true, false, !bl);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateRowSelection(boolean bl) {
        this.refreshFixedPartData(true);
        LayoutContainer layoutContainer = this.layoutContainer;
        synchronized (layoutContainer) {
            this.changeCurrentRow(true);
        }
    }

    @Override
    public void updateRow(int n, int n2, Map<Integer, FieldObjectData> map, Map<Integer, NonFieldObjectData> map2) {
        this.updateRowObjects(n, n2, map, map2);
    }

    @Override
    public void updateRowObjects(int n, int n2, Map<Integer, FieldObjectData> map, Map<Integer, NonFieldObjectData> map2) {
        Body body;
        ListRow listRow = (ListRow)this.gridComponent.getCachedRowDataByRowKey(this.getRowKey(n, n2));
        if (listRow != null && (body = listRow.getRowProperty()) != null) {
            this.dataUpdator.updateFieldObjects(body, map);
            this.dataUpdator.updateNonFieldObjects(body, map2);
        }
        if (n == this.app.getLayoutDataModel().getRecordIndex()) {
            this.updateFieldData(map);
            this.updateStaticData(map2);
        }
    }

    private void updateStaticData(Map<Integer, NonFieldObjectData> map) {
        int n = this.app.getLayoutDataModel().getRecordIndex();
        int n2 = this.app.getLayoutDataModel().getRowId();
        this.dataUpdator.updateNonFieldObjects(n, n2, map);
    }

    private void updateFieldData(Map<Integer, FieldObjectData> map) {
        this.dataUpdator.updateFieldObjects(map);
    }

    @Override
    public void updateELO(NonFieldObjectData nonFieldObjectData) {
        Body body = this.getCurrentBody();
        if (body != null) {
            this.dataUpdator.updateWebViewer(body, nonFieldObjectData);
        }
    }

    public void adjustFiller() {
        if (this.emptyRow != null) {
            this.adjustFillerForEmptyRow();
        } else {
            PartMetaData partMetaData = (PartMetaData)this.getLayoutMetaData().getBodyMetaData();
            if (partMetaData != null) {
                if (this.hasFillerSpace()) {
                    this.getBodyAndFiller().setSplitPosition(this.gridComponent.getListViewContentsHeight(), Sizeable.Unit.PIXELS, false);
                } else {
                    this.getBodyAndFiller().setSplitPosition(0.0f, Sizeable.Unit.PIXELS, true);
                }
            }
        }
    }

    public void adjustFillerForEmptyRow() {
        if (this.emptyRow != null && this.emptyRow.hasSummaryParts()) {
            float f = this.emptyRow.getHeight();
            if (f < (float)this.calculateListHeight()) {
                this.getBodyAndFiller().setSplitPosition(f, Sizeable.Unit.PIXELS, false);
            } else {
                this.getBodyAndFiller().setSplitPosition(0.0f, Sizeable.Unit.PIXELS, true);
            }
        } else {
            this.getBodyAndFiller().setSplitPosition(0.0f, Sizeable.Unit.PIXELS, false);
        }
    }

    public WDVerticalSplitPanel getBodyAndFiller() {
        return this.bodyAndFiller;
    }

    public boolean hasFillerSpace() {
        float f = this.calculateListHeight();
        return this.gridComponent.getListViewContentsHeight() < f;
    }

    public int getCurrentRowIndex() {
        Body body;
        if (this.listState.getCurrentActiveRow() != null && (body = this.listState.getCurrentActiveRow().getRowProperty()) != null) {
            return body.getAttributes().getRecordIndex();
        }
        return -1;
    }

    @Override
    public void refreshObjects(Map<Integer, ObjectSpec> map, Map<Integer, ObjectSpec> map2) {
        if (!this.listState.isListLoading()) {
            HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
            HashMap<Integer, Set<Integer>> hashMap2 = new HashMap<Integer, Set<Integer>>();
            HashSet<Integer> hashSet = new HashSet<Integer>();
            LayoutContainer.splitPortalObjects(this, map, map2, hashMap, hashMap2, hashSet);
            Collection<Item> collection = this.gridComponent.getCachedData().values();
            int n = collection.size();
            if (n > 0) {
                int n2 = Integer.MAX_VALUE;
                for (Item item : collection) {
                    ListRow listRow = (ListRow)item;
                    int n3 = listRow.getRecordIndex();
                    int n4 = listRow.getRowId();
                    LayoutContainer.refreshPortalAndPortalObjects(this, n3, n4, hashMap, hashMap2, map2);
                    if (n3 >= n2) continue;
                    n2 = n3;
                }
                LayoutContainer.refreshNonPortalObjects(this.app, this, hashSet, n2, n);
            } else {
                if (hashSet.size() > 0) {
                    LayoutContainer.refreshNonPortalObjects(this.app, this, hashSet, 0, 1);
                }
                if (map2 != null) {
                    LayoutContainer.refreshPortalAndPortalObjects(this, 0, 0, hashMap, hashMap2, map2);
                }
            }
        }
    }

    @Override
    public void updateActiveRowState(ActiveRowStateNotification activeRowStateNotification) {
        ListRow listRow;
        this.app.getActiveUIHandler().setPendingSelectionUpdate(activeRowStateNotification.isUpdateSelection());
        this.app.getActiveUIHandler().setPendingSelectionStart(activeRowStateNotification.getSelectionStart());
        this.app.getActiveUIHandler().setPendingSelectionEnd(activeRowStateNotification.getSelectionEnd());
        this.app.getActiveUIHandler().updateActiveState(activeRowStateNotification.getRowState());
        if (this.metaData.hasConditionalFormatting() && (listRow = this.listState.getCurrentActiveRow()) != null) {
            int n = listRow.getListIndex() + 1;
            this.app.getAppSession().getListRows(new ActionResultGetterHandler(){

                /*
                 * WARNING - Removed try catching itself - possible behaviour change.
                 */
                @Override
                public void onFinish(Object object) {
                    LayoutContainer layoutContainer = LayoutListView.this.layoutContainer;
                    synchronized (layoutContainer) {
                        LayoutListView.this.updateListRowsData((LayoutDataResult)object);
                    }
                }
            }, n, 1, false);
        }
    }

    private LayoutObject getRowLayoutObject(ObjectSpec objectSpec, boolean bl) {
        Body body;
        LayoutObject layoutObject = null;
        ListRow listRow = (ListRow)this.gridComponent.getCachedRowDataByRowKey(this.getRowKey(objectSpec.getRowIndex(), objectSpec.getPartIndex()));
        if (listRow != null && (body = listRow.getRowProperty()) != null && !body.getMetaData().isFixedPart()) {
            layoutObject = body.getLayoutObject(objectSpec, bl);
        }
        return layoutObject;
    }

    private Body getCurrentBody() {
        if (this.listState.getCurrentActiveRow() != null) {
            return this.listState.getCurrentActiveRow().getRowProperty();
        }
        return null;
    }

    public ListViewState getListState() {
        return this.listState;
    }

    @Override
    public void resetCachedView() {
        if (this.dynamicRowHeight) {
            this.listState.setInitialLoad(true);
        }
    }

    @Override
    public void refreshActiveObject(ObjectSpec objectSpec, boolean bl) {
        if (IWPUtilities.isValidObjectSpec(objectSpec)) {
            LayoutObject layoutObject = this.getViewModel().getFixedPartsObjectsModel().getLayoutObject(this.app, objectSpec);
            if (layoutObject == null) {
                layoutObject = this.getRowLayoutObject(objectSpec, bl);
            }
            this.app.getActiveUIHandler().refreshActiveUI(layoutObject);
        }
    }

    @Override
    public void openPopover(final ObjectSpec objectSpec) {
        LayoutObject layoutObject = this.getLayoutObject(objectSpec);
        if (layoutObject == null) {
            int n = objectSpec.getRowIndex();
            if (!this.gridComponent.isRowVisible(n)) {
                this.makeRowVisible(n, new TableLoadCompleteHandler(){
                    final /* synthetic */ LayoutListView this$0;
                    {
                        this.this$0 = layoutListView;
                    }

                    @Override
                    public void loadComplete() {
                        LayoutObject layoutObject = this.this$0.getRowLayoutObject(objectSpec, true);
                        this.this$0.app.getLayoutContainer().getPopoverHandler().openPopover((PopoverButton)layoutObject, objectSpec);
                    }
                }, false);
            }
        } else {
            this.app.getLayoutContainer().getPopoverHandler().openPopover((PopoverButton)layoutObject, objectSpec);
        }
    }

    @Override
    public void updateTabIndex(LayoutObject layoutObject, int n, int n2) {
    }

    @Override
    public boolean allowClientSideTabbing() {
        return false;
    }

    @Override
    public boolean refreshingViewData() {
        return false;
    }

    @Override
    public LayoutObject getLayoutObjectFromPortal(ObjectSpec objectSpec, boolean bl) {
        return this.getLayoutObject(objectSpec, bl);
    }

    @Override
    public LayoutObject getLayoutObject(ObjectSpec objectSpec) {
        return this.getLayoutObject(objectSpec, false);
    }

    public LayoutObject getLayoutObject(ObjectSpec objectSpec, boolean bl) {
        LayoutObject layoutObject = null;
        int n = objectSpec.getRowIndex();
        if (IWPUtilities.isValidObjectSpec(objectSpec) && (layoutObject = this.getViewModel().getFixedPartsObjectsModel().getLayoutObject(this.app, objectSpec)) == null) {
            layoutObject = this.getRowLayoutObject(objectSpec, bl);
        }
        if (layoutObject == null) {
            IWPUtilities.showDebugMessage(this.app, "Warning: Object with id " + objectSpec.getObjectId() + " is missing in layout in row " + n + ".");
        }
        return layoutObject;
    }

    @Override
    public Collection<LayoutObject> getLayoutObjects() {
        ArrayList<LayoutObject> arrayList = new ArrayList<LayoutObject>();
        arrayList.addAll(this.getViewModel().getFixedPartsObjectsModel().getLayoutObjects());
        Body body = this.getCurrentBody();
        if (body != null) {
            arrayList.addAll(body.getLayoutObjects());
        }
        if (this.app.getLayoutContainer().getPopoverHandler().isPopoverOpen()) {
            arrayList.addAll(this.app.getLayoutContainer().getPopoverWindow().getPopover().getLayoutObjects());
        }
        return arrayList;
    }

    @Override
    public void removeAllPortalRows() {
        if (this.getViewModel() != null) {
            this.getViewModel().getFixedPartsObjectsModel().removeAllPortalRows();
        }
        if (this.gridComponent != null) {
            for (Item item : this.gridComponent.getCachedData().values()) {
                ListRow listRow = (ListRow)item;
                if (listRow.getItemProperty().getPartObjectsModel() == null) continue;
                listRow.getItemProperty().getPartObjectsModel().removeAllPortalRows();
            }
        }
    }

    @Override
    public void updateNavPartsIfNeeded(LayoutContainer layoutContainer) {
        if (this.topNav != null) {
            ((VerticalLayout)this.getRootComponent().getContent()).removeComponent((Component)this.topNav);
            layoutContainer.addComponent(this.topNav, 0);
        }
        if (this.bottomNav != null) {
            ((VerticalLayout)this.getRootComponent().getContent()).removeComponent((Component)this.bottomNav);
            layoutContainer.addComponent(this.bottomNav);
        }
    }

    private void performPostLoading() {
        this.listState.setListLoading(false);
        for (TableLoadCompleteHandler tableLoadCompleteHandler : this.loadCompleteHandlers) {
            tableLoadCompleteHandler.loadComplete();
        }
        this.loadCompleteHandlers.clear();
    }

    private void updateListRowsData(LayoutDataResult layoutDataResult) {
        LayoutData layoutData = layoutDataResult.getLayoutData();
        Map<Integer, SingleRowPartsData> map = layoutData.getRowsData();
        Map<Integer, NonFieldObjectsData> map2 = layoutDataResult.getLayoutData().getAllPartsNonFieldObjectsData();
        for (int n : map.keySet()) {
            ListRow listRow;
            SingleRowPartsData singleRowPartsData = map.get(n);
            if (singleRowPartsData == null || singleRowPartsData.getPartsData().isEmpty() || (listRow = (ListRow)this.gridComponent.getCachedRowDataByRowKey(this.getRowKey(singleRowPartsData.getRowIndex(), singleRowPartsData.getPartsData().get(0).getPartIndex()))) == null) continue;
            listRow.updateRowData(singleRowPartsData, map2);
        }
    }

    public void changeCurrentRow() {
        this.changeCurrentRow(false);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void changeCurrentRow(final boolean bl) {
        if (this.metaData.hasNoBody()) {
            return;
        }
        final int n = this.app.getLayoutDataModel().getRecordIndex();
        if (n >= 1) {
            LayoutContainer layoutContainer = this.layoutContainer;
            synchronized (layoutContainer) {
                if (this.metaData.hasConditionalFormatting()) {
                    Range range = this.gridComponent.getCachedDataRange();
                    if (range != null && !range.isEmpty()) {
                        int n2 = range.getStart() + 1;
                        int n3 = range.length();
                        this.app.getAppSession().getListRows(new ActionResultGetterHandler(){
                            final /* synthetic */ LayoutListView this$0;
                            {
                                this.this$0 = layoutListView;
                            }

                            /*
                             * WARNING - Removed try catching itself - possible behaviour change.
                             */
                            @Override
                            public void onFinish(Object object) {
                                LayoutContainer layoutContainer = this.this$0.layoutContainer;
                                synchronized (layoutContainer) {
                                    this.this$0.updateListRowsData((LayoutDataResult)object);
                                    this.this$0.makeRowVisible(n, bl);
                                }
                            }
                        }, n2, n3, false);
                    }
                } else {
                    this.makeRowVisible(n, bl);
                }
            }
        }
    }

    private void makeRowVisible(final int n, boolean bl) {
        this.makeRowVisible(n, new TableLoadCompleteHandler(){
            final /* synthetic */ LayoutListView this$0;
            {
                this.this$0 = layoutListView;
            }

            @Override
            public void loadComplete() {
                ListRow listRow = (ListRow)this.this$0.gridComponent.getCachedRowDataByRowKey(this.this$0.getRowKey(n, 0));
                if (listRow != null) {
                    this.this$0.setCurrentActiveRow(listRow);
                    this.this$0.app.getActiveUIHandler().refreshActiveUI();
                }
            }
        }, bl);
    }

    private void makeRowVisible(int n, TableLoadCompleteHandler tableLoadCompleteHandler, boolean bl) {
        int n2 = n - 1;
        if (n2 >= this.gridComponent.getDataCommunicator().getDataProviderSize()) {
            return;
        }
        boolean bl2 = this.gridComponent.isRowVisible(n);
        boolean bl3 = this.gridComponent.isRowDataAvailable(this.getRowKey(n, 0));
        if (bl) {
            bl2 = false;
        }
        if (!bl2) {
            if (bl3) {
                if (this.dynamicRowHeight) {
                    this.gridComponent.scrollToDynamicHeightRow(n2);
                } else {
                    this.gridComponent.scrollTo(n2);
                }
            } else {
                this.gridComponent.scrollTo(n2, ScrollDestination.START);
            }
        }
        if (bl3) {
            tableLoadCompleteHandler.loadComplete();
        } else {
            this.loadCompleteHandlers.add(tableLoadCompleteHandler);
        }
    }

    public int calculatePageLength() {
        float f = this.app.getBrowserInfoHandler().getContentHeight();
        f = f - this.getPartHeight(this.metaData.getMetaData(LayoutObjectType.HEADER)) - this.getPartHeight(this.metaData.getMetaData(LayoutObjectType.FOOTER));
        float f2 = this.getPartHeight(this.metaData.getBodyMetaData());
        int n = f2 >= f ? 1 : (f2 == 0.0f ? this.app.getLayoutDataModel().getPartInstCount() : (int)Math.ceil(f / f2) * 1);
        if (n < 10) {
            n = 10;
        }
        if (IWPUtilities.isDebugMode()) {
            this.app.getMessenger().showTrayMessage("List data batch size: " + n);
        }
        return n;
    }

    public float getPartHeight(ObjectMetaData objectMetaData) {
        if (objectMetaData != null) {
            return objectMetaData.getHeightAsInt();
        }
        return 0.0f;
    }

    @Override
    public boolean isClientSideAutoSizing() {
        return false;
    }

    public int getRowCount() {
        int n = !this.metaData.hasNoBody() ? this.app.getLayoutDataModel().getFoundRecords() : this.app.getLayoutDataModel().getPartInstCount();
        return n;
    }

    public int calculateListHeight() {
        StringBuilder stringBuilder = new StringBuilder();
        int n = this.getLayoutHeight();
        stringBuilder.append("layoutAreaHeight=" + n);
        int n2 = n;
        List<ObjectMetaData> list = this.getLayoutMetaData().getAllPartsMetaData();
        if (list != null) {
            for (ObjectMetaData objectMetaData : list) {
                if (this.isInsideListRow(objectMetaData.getType()) || this.isInvisible(objectMetaData.getType())) continue;
                stringBuilder.append(", partType=" + String.valueOf((Object)objectMetaData.getType()) + ", partHeight=" + objectMetaData.getHeightAsInt());
                n2 -= objectMetaData.getHeightAsInt();
            }
        }
        stringBuilder.append(", listHeight=" + n2);
        return n2 >= 0 ? n2 : -1;
    }

    private void resizeListHeight() {
        int n = this.calculateListHeight();
        if ((float)n != this.gridComponent.getHeight()) {
            this.gridComponent.setHeight(n, Sizeable.Unit.PIXELS);
        } else {
            this.gridComponent.recalculateScrollbarsForVirtualViewport();
        }
    }

    private boolean isInsideListRow(LayoutObjectType layoutObjectType) {
        return layoutObjectType == LayoutObjectType.LEADING_GRAND_SUM || layoutObjectType == LayoutObjectType.LEADING_SUB_SUM || layoutObjectType == LayoutObjectType.TRAILING_GRAND_SUM || layoutObjectType == LayoutObjectType.TRAILING_SUB_SUM || layoutObjectType == LayoutObjectType.BODY;
    }

    private boolean isInvisible(LayoutObjectType layoutObjectType) {
        return layoutObjectType == LayoutObjectType.TITLE_HEADER || layoutObjectType == LayoutObjectType.TITLE_FOOTER;
    }

    private boolean checkDynamicRowHeight() {
        return this.metaData.getMetaData(LayoutObjectType.LEADING_GRAND_SUM) != null || this.metaData.getMetaData(LayoutObjectType.LEADING_SUB_SUM) != null || this.metaData.getMetaData(LayoutObjectType.TRAILING_GRAND_SUM) != null || this.metaData.getMetaData(LayoutObjectType.TRAILING_SUB_SUM) != null;
    }

    private void setCurrentActiveRow(ListRow listRow) {
        ListRow listRow2 = this.listState.getCurrentActiveRow();
        if (listRow2 != null) {
            listRow2.removeActiveRowStyleName();
        }
        listRow.addActiveRowStyleName();
        this.listState.setCurrentActiveRow(listRow);
    }

    public void onBrowserWindowResized(int n, int n2) {
        this.resizeListHeight();
    }

    @Override
    public void statusAreaVisibilityChanged() {
        this.resizeListHeight();
    }

    private int getLayoutHeight() {
        int n = 0;
        if (IWPUtilities.isInCardWindow(this.getViewComponent())) {
            n = ((AppCardWindowContainer)this.app.getAppContainer()).getWindowSettings().getDimensions().getHeight();
        } else {
            n = this.app.getBrowserInfoHandler().getContentHeight();
            if (!this.app.getDatabaseDataModel().isMenubarVisible() && !this.app.getDatabaseDataModel().getToolbarStatusAreaState().isShow()) {
                n += 44;
            }
        }
        return n;
    }

    private ListRow createListRow(PartMetaData partMetaData, int n, int n2) {
        ListRow listRow = new ListRow(this, partMetaData, n);
        listRow.setListIndex(n2);
        ListRowProperty listRowProperty = new ListRowProperty(listRow);
        listRow.addItemProperty(listRowProperty);
        return listRow;
    }

    private void fetchEmptyRow() {
        PartMetaData partMetaData = (PartMetaData)this.metaData.getBodyMetaData();
        if (partMetaData != null) {
            this.getListState().setListLoading(true);
            this.app.getAppSession().getListRows(new ActionResultGetterHandler(){

                /*
                 * WARNING - Removed try catching itself - possible behaviour change.
                 */
                @Override
                public void onFinish(Object object) {
                    LayoutContainer layoutContainer = LayoutListView.this.layoutContainer;
                    synchronized (layoutContainer) {
                        LayoutDataResult layoutDataResult = (LayoutDataResult)object;
                        Map<Integer, SingleRowPartsData> map = layoutDataResult.getLayoutData().getRowsData();
                        Map<Integer, NonFieldObjectsData> map2 = layoutDataResult.getLayoutData().getAllPartsNonFieldObjectsData();
                        PartMetaData partMetaData = (PartMetaData)LayoutListView.this.metaData.getBodyMetaData();
                        SingleRowPartsData singleRowPartsData = map.get(0);
                        ListRow listRow = LayoutListView.this.createListRow(partMetaData, 0, 0);
                        listRow.setValid(true);
                        if (singleRowPartsData != null) {
                            if (LayoutListView.this.metaData.hasNoBody()) {
                                int n = singleRowPartsData.getRowIndex();
                                listRow.setRecordIndex(n);
                            }
                            listRow.setRowId(singleRowPartsData.getRowId());
                            Body body = LayoutListView.this.uiGenerator.generateLayoutPartUI(Body.class, null, partMetaData, listRow.getRecordIndex(), singleRowPartsData.getRowId(), 0);
                            listRow.getItemProperty().addBody(body, singleRowPartsData, map2);
                        }
                        LayoutListView.this.performPostLoading();
                        LayoutListView.this.emptyRow = listRow.getItemProperty();
                        LayoutListView.this.gridContainer.addComponent((Component)LayoutListView.this.emptyRow);
                        LayoutListView.this.adjustFillerForEmptyRow();
                    }
                }
            }, 0, 1, true);
        }
    }

    @Override
    public void onEvent(UIEvent uIEvent) {
        switch (uIEvent.getType()) {
            case VIEW_STYLE_CHANGE: {
                this.cleanupValueListRequests();
                this.cleanupFilteredValueListRequests();
                this.cleanupValueListItemRequests();
                if (!this.app.isListView()) break;
                boolean bl = !BrowserInfoHandler.isMobile(this.app);
                this.updatePullToRefresh(bl);
                this.changeCurrentRow(true);
                break;
            }
            case MODE_CHANGE: {
                this.gridComponent.onModeChanged();
                break;
            }
            case MOVE_RESIZE_CARD_STYLE_WINDOW: {
                this.resizeListHeight();
                break;
            }
        }
    }

    public void getValueListSubset(ValueListSubsetRequest valueListSubsetRequest) {
        if (this.valueListRequests == null) {
            this.valueListRequests = new HashMap<ObjectSpec, ValueListSubsetRequest>();
        }
        if (this.valueListThrottleTimer != null) {
            this.valueListThrottleTimer.cancel();
        }
        this.valueListRequests.put(valueListSubsetRequest.getObjectSpec(), valueListSubsetRequest);
        this.valueListThrottleTimer = new Timer();
        this.valueListThrottleTimer.schedule(new TimerTask(){

            @Override
            public void run() {
                LayoutListView.this.app.getAppSession().getValueListSubsets(new ActionResultGetterHandler(){

                    @Override
                    public void onFinish(Object object) {
                        LayoutListView.this.handleGetValueListSubsetsNotification((List)object);
                    }
                }, new ArrayList<ValueListSubsetRequest>(LayoutListView.this.valueListRequests.values()));
                LayoutListView.this.cleanupValueListRequests();
            }
        }, this.valueListThrottleDelay);
    }

    public void getFilteredValueListSubset(FilteredValueListSubsetRequest filteredValueListSubsetRequest) {
        if (this.filteredValueListRequests == null) {
            this.filteredValueListRequests = new HashMap<ObjectSpec, FilteredValueListSubsetRequest>();
        }
        if (this.filteredValueListThrottleTimer != null) {
            this.filteredValueListThrottleTimer.cancel();
        }
        this.filteredValueListRequests.put(filteredValueListSubsetRequest.getObjectSpec(), filteredValueListSubsetRequest);
        this.filteredValueListThrottleTimer = new Timer();
        this.filteredValueListThrottleTimer.schedule(new TimerTask(){

            @Override
            public void run() {
                LayoutListView.this.app.getAppSession().getFilteredValueListSubsets(new ActionResultGetterHandler(){

                    @Override
                    public void onFinish(Object object) {
                        LayoutListView.this.handleGetFilteredValueListSubsetsNotification((List)object);
                    }
                }, new ArrayList<FilteredValueListSubsetRequest>(LayoutListView.this.filteredValueListRequests.values()));
                LayoutListView.this.cleanupFilteredValueListRequests();
            }
        }, this.filteredValueListThrottleDelay);
    }

    public void getValueListItemByValue(ValueListItemRequest valueListItemRequest) {
        if (this.valueListItemRequests == null) {
            this.valueListItemRequests = new HashMap<ObjectSpec, ValueListItemRequest>();
        }
        if (this.valueListItemThrottleTimer != null) {
            this.valueListItemThrottleTimer.cancel();
        }
        this.valueListItemRequests.put(valueListItemRequest.getObjectSpec(), valueListItemRequest);
        this.valueListItemThrottleTimer = new Timer();
        this.valueListItemThrottleTimer.schedule(new TimerTask(){

            @Override
            public void run() {
                LayoutListView.this.app.getAppSession().getValueListItemsByValues(new ActionResultGetterHandler(){

                    @Override
                    public void onFinish(Object object) {
                        LayoutListView.this.handleGetValueListItemsByValuesNotification((List)object);
                    }
                }, new ArrayList<ValueListItemRequest>(LayoutListView.this.valueListItemRequests.values()));
                LayoutListView.this.cleanupValueListItemRequests();
            }
        }, this.valueListItemThrottleDelay);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void handleGetValueListSubsetsNotification(List<ValueListSubsetResult> list) {
        LayoutContainer layoutContainer = this.layoutContainer;
        synchronized (layoutContainer) {
            for (ValueListSubsetResult valueListSubsetResult : list) {
                LayoutObject layoutObject = this.getLayoutObject(valueListSubsetResult.getObjectSpec());
                if (layoutObject == null) continue;
                ((RadioSet)layoutObject).handleGetValueListSubsetNotification(valueListSubsetResult.getData());
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void handleGetFilteredValueListSubsetsNotification(List<FilteredValueListSubsetResult> list) {
        LayoutContainer layoutContainer = this.layoutContainer;
        synchronized (layoutContainer) {
            for (FilteredValueListSubsetResult filteredValueListSubsetResult : list) {
                LayoutObject layoutObject = this.getLayoutObject(filteredValueListSubsetResult.getObjectSpec());
                if (layoutObject == null) continue;
                ((Popup)layoutObject).handleGetFilteredValueListSubsetNotification(filteredValueListSubsetResult.getData(), filteredValueListSubsetResult.getStart(), filteredValueListSubsetResult.getValuesCount(), filteredValueListSubsetResult.getFilter(), filteredValueListSubsetResult.isShowSelectedValue());
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void handleGetValueListItemsByValuesNotification(List<ValueListItemResult> list) {
        LayoutContainer layoutContainer = this.layoutContainer;
        synchronized (layoutContainer) {
            for (ValueListItemResult valueListItemResult : list) {
                LayoutObject layoutObject = this.getLayoutObject(valueListItemResult.getObjectSpec());
                if (layoutObject == null) continue;
                ((Popup)layoutObject).handleGetValueListItemByValueNotification(valueListItemResult.getData());
            }
        }
    }

    private void cleanupValueListRequests() {
        if (this.valueListRequests != null) {
            this.valueListRequests.clear();
            this.valueListRequests = null;
        }
        if (this.valueListThrottleTimer != null) {
            this.valueListThrottleTimer.cancel();
            this.valueListThrottleTimer.purge();
            this.valueListThrottleTimer = null;
        }
    }

    private void cleanupFilteredValueListRequests() {
        if (this.filteredValueListRequests != null) {
            this.filteredValueListRequests.clear();
            this.filteredValueListRequests = null;
        }
        if (this.filteredValueListThrottleTimer != null) {
            this.filteredValueListThrottleTimer.cancel();
            this.filteredValueListThrottleTimer.purge();
            this.filteredValueListThrottleTimer = null;
        }
    }

    private void cleanupValueListItemRequests() {
        if (this.valueListItemRequests != null) {
            this.valueListItemRequests.clear();
            this.valueListItemRequests = null;
        }
        if (this.valueListItemThrottleTimer != null) {
            this.valueListItemThrottleTimer.cancel();
            this.valueListItemThrottleTimer.purge();
            this.valueListItemThrottleTimer = null;
        }
    }

    private class NoCommitPanel
    extends Panel
    implements LayoutObjectBuildingBlock {
        private NoCommitPanel() {
        }

        public void attach() {
            super.attach();
            LayoutListView.this.resizeListHeight();
        }
    }

    private class ListRowsDataProvider
    extends CallbackDataProvider<Item, Void> {
        public ListRowsDataProvider() {
            super((CallbackDataProvider.FetchCallback)new CallbackDataProvider.FetchCallback<Item, Void>(){
                GetListRowsAsyncCallback getRowsCallback;
                {
                    this.getRowsCallback = new GetListRowsAsyncCallback();
                }

                public Stream<Item> fetch(Query<Item, Void> query) {
                    return this.getRowsCallback.fetchItems(query.getSortOrders(), query.getOffset(), query.getLimit());
                }
            }, (CallbackDataProvider.CountCallback)new CallbackDataProvider.CountCallback<Item, Void>(){
                GetListRowsCountCallback getRowsCountCallback;
                {
                    this.getRowsCountCallback = new GetListRowsCountCallback(LayoutListView.this.app);
                }

                public int count(Query<Item, Void> query) {
                    return this.getRowsCountCallback.get();
                }
            }, (ValueProvider)new ValueProvider<Item, Object>(){

                public Integer apply(Item item) {
                    ListRow listRow = (ListRow)item;
                    return listRow.getListIndex();
                }
            });
        }
    }

    private class ListRowProvider
    implements ValueProvider<Item, Component> {
        private ListRowProvider() {
        }

        public Component apply(Item item) {
            return ((ListRow)item).getItemProperty();
        }
    }

    private class GetListRowsCountCallback
    implements SerializableSupplier<Integer> {
        private App app;

        public GetListRowsCountCallback(App app) {
            this.app = app;
        }

        public Integer get() {
            return LayoutListView.this.getRowCount();
        }
    }

    private class GetListRowsAsyncCallback
    implements Grid.FetchItemsCallback<Item> {
        private GetListRowsAsyncCallback() {
        }

        public Stream<Item> fetchItems(List<QuerySortOrder> list, int n, int n2) {
            LayoutListView.this.getListState().setListLoading(true);
            boolean bl = LayoutListView.this.getListState().isInitialLoad();
            PartMetaData partMetaData = (PartMetaData)LayoutListView.this.metaData.getBodyMetaData();
            ArrayList<Item> arrayList = new ArrayList<Item>();
            if (partMetaData != null) {
                this.createListRows(arrayList, partMetaData, n, n2, bl);
                this.readAsyncListRowsData(n, n2, arrayList, bl);
            }
            if (bl) {
                LayoutListView.this.listState.setInitialLoad(false);
            }
            return arrayList.stream();
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private void createListRows(List<Item> list, PartMetaData partMetaData, int n, int n2, boolean bl) {
            LayoutContainer layoutContainer = LayoutListView.this.layoutContainer;
            synchronized (layoutContainer) {
                int n3 = n + 1;
                for (int i = 0; i < n2; ++i) {
                    ListRow listRow = (ListRow)LayoutListView.this.gridComponent.getCachedRowDataByListIndex(n + i);
                    if (listRow == null) {
                        listRow = LayoutListView.this.createListRow(partMetaData, n3 + i, n + i);
                    }
                    listRow.setValid(false);
                    if (bl) {
                        listRow.setVisible(false);
                    }
                    list.add((Item)listRow);
                }
            }
        }

        private void readAsyncListRowsData(int n, int n2, final List<Item> list, final boolean bl) {
            int n3 = n + 1;
            if (LayoutListView.this.app.getPrivileges().hasLayoutAccess() || LayoutListView.this.app.getPrivileges().hasBrowseAccess()) {
                LayoutListView.this.getLayoutContainer().getContainerState().getListViewRefreshState().setRefreshInProgress(true);
                LayoutListView.this.app.getAppSession().getListRows(new ActionResultGetterHandler(){
                    final /* synthetic */ GetListRowsAsyncCallback this$1;
                    {
                        this.this$1 = getListRowsAsyncCallback;
                    }

                    /*
                     * WARNING - Removed try catching itself - possible behaviour change.
                     */
                    @Override
                    public void onFinish(Object object) {
                        LayoutContainer layoutContainer = this.this$1.LayoutListView.this.layoutContainer;
                        synchronized (layoutContainer) {
                            Object object22;
                            LayoutDataResult layoutDataResult = (LayoutDataResult)object;
                            Map<Integer, SingleRowPartsData> map = layoutDataResult.getLayoutData().getRowsData();
                            Map<Integer, NonFieldObjectsData> map2 = layoutDataResult.getLayoutData().getAllPartsNonFieldObjectsData();
                            PartMetaData partMetaData = (PartMetaData)this.this$1.LayoutListView.this.metaData.getBodyMetaData();
                            for (Object object22 : list) {
                                SingleRowPartsData singleRowPartsData;
                                ListRow listRow = (ListRow)((Object)object22);
                                if (listRow.getItemProperty().getBody() != null) {
                                    listRow.cleanupMemory();
                                }
                                if ((singleRowPartsData = map.get(listRow.getListIndex() + 1)) != null) {
                                    if (this.this$1.LayoutListView.this.metaData.hasNoBody()) {
                                        int n = singleRowPartsData.getRowIndex();
                                        listRow.setRecordIndex(n);
                                    }
                                    listRow.setRowId(singleRowPartsData.getRowId());
                                    if (this.this$1.LayoutListView.this.app.getLayoutDataModel().getRecordIndex() == listRow.getRecordIndex()) {
                                        this.this$1.LayoutListView.this.setCurrentActiveRow(listRow);
                                    }
                                    Body body = this.this$1.LayoutListView.this.uiGenerator.generateLayoutPartUI(Body.class, null, partMetaData, listRow.getRecordIndex(), singleRowPartsData.getRowId(), 0);
                                    listRow.getItemProperty().addBody(body, singleRowPartsData, map2);
                                }
                                listRow.setValid(true);
                                if (!bl) continue;
                                listRow.setVisible(true);
                            }
                            this.this$1.LayoutListView.this.gridComponent.onDataLoaded(this.this$1.LayoutListView.this.sortChanged, this.this$1.LayoutListView.this.modeChanged);
                            this.this$1.LayoutListView.this.sortChanged = false;
                            this.this$1.LayoutListView.this.modeChanged = false;
                            this.this$1.LayoutListView.this.performPostLoading();
                            this.this$1.LayoutListView.this.app.getActiveUIHandler().refreshActiveUI();
                            LayoutContainerState.ListViewRefreshState listViewRefreshState = this.this$1.LayoutListView.this.app.getLayoutContainer().getContainerState().getListViewRefreshState();
                            listViewRefreshState.setRefreshInProgress(false);
                            object22 = listViewRefreshState.getActivePopoverButtonSpec();
                            if (object22 != null) {
                                this.this$1.LayoutListView.this.app.getLayoutContainer().getPopoverHandler().openPopover(listViewRefreshState.getActivePopoverId(), (ObjectSpec)object22);
                            }
                            this.this$1.LayoutListView.this.app.getLayoutContainer().getContainerState().getLayoutRefreshState().setRefreshInProgress(false);
                        }
                    }
                }, n3, n2, true);
            } else {
                LayoutListView.this.app.getLayoutContainer().getContainerState().getLayoutRefreshState().setRefreshInProgress(false);
            }
        }
    }
}

