/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.Component
 *  com.vaadin.v7.ui.VerticalLayout
 *  org.vaadin.ui.ScrollEventPanel
 *  org.vaadin.ui.ScrollEventPanel$ScrollListener
 */
package com.filemaker.jwpc.iwp.ui.layout.form;

import com.filemaker.jwpc.iwp.action.ActionResultGetterHandler;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.application.AppServlet;
import com.filemaker.jwpc.iwp.metadata.ObjectMetaData;
import com.filemaker.jwpc.iwp.model.PartObjectsModel;
import com.filemaker.jwpc.iwp.notification.processor.BrowserInfoHandler;
import com.filemaker.jwpc.iwp.thrift.common.Dimensions;
import com.filemaker.jwpc.iwp.thrift.common.LayoutObjectType;
import com.filemaker.jwpc.iwp.thrift.common.LayoutViewStyle;
import com.filemaker.jwpc.iwp.thrift.common.ObjectSpec;
import com.filemaker.jwpc.iwp.thrift.layout.FieldObjectData;
import com.filemaker.jwpc.iwp.thrift.layout.LayoutDataResult;
import com.filemaker.jwpc.iwp.thrift.layout.NonFieldObjectData;
import com.filemaker.jwpc.iwp.thrift.layout.NonFieldObjectsData;
import com.filemaker.jwpc.iwp.thrift.layout.SinglePartObjectsData;
import com.filemaker.jwpc.iwp.thrift.layout.SingleRowPartsData;
import com.filemaker.jwpc.iwp.thrift.notification.ActiveRowStateNotification;
import com.filemaker.jwpc.iwp.ui.event.EventType;
import com.filemaker.jwpc.iwp.ui.event.UIEvent;
import com.filemaker.jwpc.iwp.ui.event.UIEventListener;
import com.filemaker.jwpc.iwp.ui.layout.LayoutContainer;
import com.filemaker.jwpc.iwp.ui.layout.LayoutObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutView;
import com.filemaker.jwpc.iwp.ui.layout.component.Body;
import com.filemaker.jwpc.iwp.ui.layout.component.BottomNavigation;
import com.filemaker.jwpc.iwp.ui.layout.component.CssLayoutObject;
import com.filemaker.jwpc.iwp.ui.layout.component.LayoutPart;
import com.filemaker.jwpc.iwp.ui.layout.component.TopNavigation;
import com.filemaker.jwpc.iwp.ui.layout.component.popover.PopoverButton;
import com.filemaker.jwpc.iwp.ui.layout.component.popover.PopoverWindow;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.vaadin.ui.Component;
import com.vaadin.v7.ui.VerticalLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.vaadin.ui.ScrollEventPanel;

public final class LayoutFormView
extends LayoutView
implements UIEventListener {
    private static final String CSS_CLASS = "iwp-form-base-layout-style";
    private List<LayoutPart> parts = new ArrayList<LayoutPart>();
    private AtomicBoolean loading = new AtomicBoolean(false);
    private ActiveRowStateNotification pendingActiveRowNotification = null;

    public LayoutFormView(App app, LayoutContainer layoutContainer, String string, long l) {
        super(app, layoutContainer, string, l);
        this.app.subscribe(this, EventType.VIEW_STYLE_CHANGE);
    }

    @Override
    public void updateLayoutUI(ObjectMetaData objectMetaData, String string, String string2, boolean bl) {
        this.loading.set(true);
        super.updateLayoutUI(objectMetaData, string, string2, bl);
        this.initParts();
        this.loading.set(false);
    }

    @Override
    public void cleanupMemory() {
        if (this.parts != null) {
            for (LayoutPart layoutPart : this.parts) {
                layoutPart.cleanupMemory();
            }
            this.parts.clear();
            this.parts = null;
        }
        this.app.unsubscribe(this, EventType.VIEW_STYLE_CHANGE);
        super.cleanupMemory();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void handleGetCurrentRowNotification(LayoutDataResult layoutDataResult) {
        LayoutContainer layoutContainer = this.layoutContainer;
        synchronized (layoutContainer) {
            Map<Integer, SingleRowPartsData> map = layoutDataResult.getLayoutData().getRowsData();
            int n = this.app.getLayoutDataModel().getRecordIndex();
            SingleRowPartsData singleRowPartsData = map.get(n);
            if (singleRowPartsData != null && this.parts.size() > 0) {
                int n2 = 0;
                try {
                    for (SinglePartObjectsData singlePartObjectsData : singleRowPartsData.getPartsData()) {
                        LayoutPart layoutPart;
                        if ((layoutPart = this.parts.get(n2++)) == null) continue;
                        this.fillPartData(layoutPart, singlePartObjectsData.getFieldObjectsData(), singlePartObjectsData.getNonFieldObjectsData(), layoutDataResult.getLayoutData().getAllPartsNonFieldObjectsData().get(singlePartObjectsData.getPartIndex()));
                    }
                }
                catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                    // empty catch block
                }
            }
            this.app.getCommunicationComponent().updateTabOrdering(this.getViewModel().getTabbableConnectors());
            this.loading.set(false);
            if (this.pendingActiveRowNotification != null) {
                this.updateActiveRowState(this.pendingActiveRowNotification);
            }
            this.app.getActiveUIHandler().refreshActiveUI();
        }
    }

    private void initParts() {
        Body body;
        boolean bl;
        Object object;
        Object object2;
        ObjectMetaData objectMetaData2;
        this.parts.clear();
        PartObjectsModel partObjectsModel = this.getViewModel().getFixedPartsObjectsModel();
        List<ObjectMetaData> list = this.metaData.getAllPartsMetaData();
        for (ObjectMetaData objectMetaData2 : list) {
            object2 = this.uiGenerator.generateLayoutPartUI(LayoutPart.class, partObjectsModel, objectMetaData2, this.app.getLayoutDataModel().getRecordIndex(), this.app.getLayoutDataModel().getRowId(), 0);
            this.parts.add((LayoutPart)object2);
        }
        ScrollEventPanel scrollEventPanel = new ScrollEventPanel();
        scrollEventPanel.setStyleName(CSS_CLASS);
        scrollEventPanel.setSizeFull();
        this.viewComponent = scrollEventPanel;
        objectMetaData2 = new VerticalLayout();
        scrollEventPanel.setContent((Component)objectMetaData2);
        objectMetaData2.setSpacing(false);
        objectMetaData2.setMargin(false);
        objectMetaData2.setStyleName("iwps_layout_background");
        object2 = this.metaData.getCustomStyles();
        if (object2 != null) {
            object = ((ArrayList)object2).iterator();
            while (object.hasNext()) {
                String string = (String)object.next();
                objectMetaData2.addStyleName(string);
            }
        }
        if (this.metaData.layoutVerticalAutoSizing() || this.isClassicTheme()) {
            objectMetaData2.setHeight("100%");
            if (this.metaData.layoutVerticalAutoSizing()) {
                this.viewComponent.addStyleName("fm-layout-v-auto-sizing");
            }
        } else {
            objectMetaData2.setHeight(this.metaData.getHeight());
            this.viewComponent.removeStyleName("fm-layout-v-auto-sizing");
        }
        object = this.app.getBrowserInfoHandler().getBrowserClientInfo().getBrowserDimensions();
        boolean bl2 = bl = this.metaData.layoutHorizontalAutoSizing() || this.isClassicTheme() && this.metaData.getWidthAsInt() < ((Dimensions)object).getWidth();
        if (bl) {
            objectMetaData2.setWidth("100%");
            if (this.metaData.layoutHorizontalAutoSizing()) {
                this.viewComponent.addStyleName("fm-layout-h-auto-sizing");
            }
        } else {
            objectMetaData2.setWidth(this.metaData.getWidth());
            this.viewComponent.removeStyleName("fm-layout-h-auto-sizing");
        }
        if ((body = this.getCurrentBody()) != null) {
            body.addStyleName("iwps_body_container");
        }
        LayoutPart layoutPart = null;
        for (LayoutPart layoutPart2 : this.parts) {
            if (bl) {
                layoutPart2.setWidth("100%");
            }
            objectMetaData2.addComponent(layoutPart2);
            if (layoutPart2 instanceof TopNavigation) {
                this.topNav = (TopNavigation)layoutPart2;
                continue;
            }
            if (layoutPart2 instanceof BottomNavigation) {
                this.bottomNav = (BottomNavigation)layoutPart2;
                continue;
            }
            layoutPart = layoutPart2;
        }
        if (layoutPart != null) {
            objectMetaData2.setExpandRatio(layoutPart, 1.0f);
        }
        this.doRefreshClient();
        int n = this.metaData.getHeightAsInt();
        if (this.topNav != null) {
            n = (int)((float)n - this.topNav.getHeight());
        }
        if (this.bottomNav != null) {
            n = (int)((float)n - this.bottomNav.getHeight());
        }
        if (n != this.metaData.getHeightAsInt()) {
            objectMetaData2.setHeight(String.valueOf(n) + "px");
        }
    }

    private ScrollEventPanel getRootComponent() {
        return (ScrollEventPanel)this.viewComponent;
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

    @Override
    public LayoutViewStyle getViewStyle() {
        return LayoutViewStyle.FORM;
    }

    @Override
    public void updateModeChange() {
        this.refreshView(false, false);
    }

    @Override
    public void updateRowSet(int n, int n2, boolean bl, boolean bl2, boolean bl3) {
        if (bl3 || bl) {
            this.refreshView(bl2, false);
        }
    }

    @Override
    public void refreshRowSetData(boolean bl) {
        this.refreshView(false, !bl);
    }

    @Override
    public void updateRowSelection(boolean bl) {
        if (bl) {
            this.refreshView(false, false);
        }
    }

    private void doRefreshClient() {
        CssLayoutObject cssLayoutObject = null;
        boolean bl = this.isClientSideAutoSizing();
        for (LayoutPart layoutPart : this.parts) {
            if (!(layoutPart instanceof TopNavigation) && !(layoutPart instanceof BottomNavigation)) {
                cssLayoutObject = layoutPart;
            }
            if (!bl) continue;
            layoutPart.initUI();
        }
        if (cssLayoutObject != null && this.isClassicTheme()) {
            ((LayoutPart)cssLayoutObject).setMinHeight(cssLayoutObject.getMetaData().getHeightAsInt());
            if (!bl) {
                ((LayoutPart)cssLayoutObject).setHeight("100%");
            }
        }
    }

    private void refreshView(boolean bl, boolean bl2) {
        this.app.notify(new UIEvent(EventType.RESET_FIELD_OBJECT));
        this.layoutContainer.removeLocalStyles();
        this.doRefreshClient();
        this.refreshViewData(false, bl, bl2);
    }

    @Override
    public void updateRow(int n, int n2, Map<Integer, FieldObjectData> map, Map<Integer, NonFieldObjectData> map2) {
        this.updateRowObjects(n, n2, map, map2);
    }

    @Override
    public void updateRowObjects(int n, int n2, Map<Integer, FieldObjectData> map, Map<Integer, NonFieldObjectData> map2) {
        if (this.app.getLayoutDataModel().getRecordIndex() == n) {
            this.updateFieldData(map);
            this.updateStaticData(map2);
        }
    }

    @Override
    public void refreshObjects(Map<Integer, ObjectSpec> map, Map<Integer, ObjectSpec> map2) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        HashMap<Integer, Set<Integer>> hashMap2 = new HashMap<Integer, Set<Integer>>();
        HashSet<Integer> hashSet = new HashSet<Integer>();
        LayoutContainer.splitPortalObjects(this, map, map2, hashMap, hashMap2, hashSet);
        int n = this.app.getLayoutDataModel().getRecordIndex();
        int n2 = this.app.getLayoutDataModel().getRowId();
        LayoutContainer.refreshPortalAndPortalObjects(this, n, n2, hashMap, hashMap2, map2);
        LayoutContainer.refreshNonPortalObjects(this.app, this, hashSet, n, 1);
    }

    @Override
    public void updateELO(NonFieldObjectData nonFieldObjectData) {
        int n = this.app.getLayoutDataModel().getRecordIndex();
        int n2 = this.app.getLayoutDataModel().getRowId();
        this.dataUpdator.updateWebViewer(n, n2, nonFieldObjectData);
    }

    @Override
    public void refreshViewData(boolean bl, boolean bl2, boolean bl3) {
        if (this.app.getPrivileges().hasLayoutAccess() || this.app.getPrivileges().hasBrowseAccess()) {
            this.loading.set(true);
            this.app.getAppSession().getCurrentRow(new ActionResultGetterHandler(){

                /*
                 * WARNING - Removed try catching itself - possible behaviour change.
                 */
                @Override
                public void onFinish(Object object) {
                    if (LayoutFormView.this.layoutContainer != null) {
                        LayoutContainer layoutContainer = LayoutFormView.this.layoutContainer;
                        synchronized (layoutContainer) {
                            LayoutFormView.this.handleGetCurrentRowNotification((LayoutDataResult)object);
                            LayoutFormView.this.app.getLayoutContainer().getContainerState().getLayoutRefreshState().setRefreshInProgress(false);
                        }
                    }
                }
            }, bl3);
        } else {
            this.app.getCommunicationComponent().updateTabOrdering(new ArrayList<String>());
            this.app.getLayoutContainer().getContainerState().getLayoutRefreshState().setRefreshInProgress(false);
        }
        this.app.getActiveUIHandler().setPendingTabbing(false);
        this.app.getAppView().tryEnableTabKeyHandlingInBrowser();
    }

    private void fillPartData(LayoutPart layoutPart, Map<Integer, FieldObjectData> map, Map<Integer, NonFieldObjectData> map2, NonFieldObjectsData nonFieldObjectsData) {
        if (map2 != null) {
            this.getDataUpdator().updateNonFieldObjects(layoutPart, map2);
        }
        if (map != null) {
            this.getDataUpdator().updateFieldObjects(layoutPart, map);
        }
        if (nonFieldObjectsData != null) {
            this.getDataUpdator().updateNonFieldObjects(layoutPart, nonFieldObjectsData.getObjects());
        }
    }

    private void updateFieldData(Map<Integer, FieldObjectData> map) {
        this.dataUpdator.updateFieldObjects(map);
    }

    private void updateStaticData(Map<Integer, NonFieldObjectData> map) {
        int n = this.app.getLayoutDataModel().getRecordIndex();
        int n2 = this.app.getLayoutDataModel().getRowId();
        this.dataUpdator.updateNonFieldObjects(n, n2, map);
    }

    @Override
    public void updateActiveRowState(ActiveRowStateNotification activeRowStateNotification) {
        if (this.loading.get()) {
            this.pendingActiveRowNotification = activeRowStateNotification;
        } else {
            this.app.getActiveUIHandler().setPendingSelectionUpdate(activeRowStateNotification.isUpdateSelection());
            this.app.getActiveUIHandler().setPendingSelectionStart(activeRowStateNotification.getSelectionStart());
            this.app.getActiveUIHandler().setPendingSelectionEnd(activeRowStateNotification.getSelectionEnd());
            this.app.getActiveUIHandler().updateActiveState(activeRowStateNotification.getRowState());
            this.pendingActiveRowNotification = null;
        }
    }

    @Override
    public LayoutObject getLayoutObject(ObjectSpec objectSpec) {
        LayoutObject layoutObject = null;
        if (IWPUtilities.isValidObjectSpec(objectSpec) && (objectSpec.getObjectType() == LayoutObjectType.PORTAL || this.app.getLayoutDataModel().getRowId() == objectSpec.getRowId())) {
            PopoverWindow popoverWindow = this.app.getLayoutContainer().getPopoverWindow();
            layoutObject = this.getViewModel().getFixedPartsObjectsModel().getLayoutObject(popoverWindow, objectSpec, true);
        }
        return layoutObject;
    }

    @Override
    public Collection<LayoutObject> getLayoutObjects() {
        ArrayList<LayoutObject> arrayList = new ArrayList<LayoutObject>();
        arrayList.addAll(this.getViewModel().getFixedPartsObjectsModel().getLayoutObjects());
        if (this.app.getLayoutContainer().getPopoverHandler().isPopoverOpen()) {
            arrayList.addAll(this.app.getLayoutContainer().getPopoverWindow().getPopover().getLayoutObjects());
        }
        return arrayList;
    }

    private Body getCurrentBody() {
        for (LayoutPart layoutPart : this.parts) {
            if (layoutPart.getMetaData().getType() != LayoutObjectType.BODY) continue;
            return (Body)layoutPart;
        }
        return null;
    }

    @Override
    public void updateFieldObject(FieldObjectData fieldObjectData) {
        this.dataUpdator.updateFieldObject(fieldObjectData);
    }

    @Override
    public void resetCachedView() {
        this.doRefreshClient();
    }

    public void addScrollListener(ScrollEventPanel.ScrollListener scrollListener) {
        this.getRootComponent().addScrollListener(scrollListener);
    }

    public void removeScrollListener(ScrollEventPanel.ScrollListener scrollListener) {
        this.getRootComponent().removeScrollListener(scrollListener);
    }

    @Override
    public void refreshActiveObject(ObjectSpec objectSpec, boolean bl) {
        if (IWPUtilities.isValidObjectSpec(objectSpec) && (objectSpec.getObjectType() == LayoutObjectType.PORTAL || this.app.getLayoutDataModel().getRowId() == objectSpec.getRowId())) {
            PopoverWindow popoverWindow = this.app.getLayoutContainer().getPopoverWindow();
            LayoutObject layoutObject = this.getViewModel().getFixedPartsObjectsModel().getLayoutObject(popoverWindow, objectSpec, bl);
            this.app.getActiveUIHandler().refreshActiveUI(layoutObject);
        }
    }

    @Override
    public void openPopover(ObjectSpec objectSpec) {
        this.app.getLayoutContainer().getPopoverHandler().openPopover((PopoverButton)this.getLayoutObject(objectSpec), objectSpec);
    }

    @Override
    public void updateTabIndex(LayoutObject layoutObject, int n, int n2) {
        if (this.allowClientSideTabbing()) {
            this.layoutViewModel.updateTabOrder(layoutObject, n, n2);
            if (!this.loading.get()) {
                this.app.getCommunicationComponent().updateTabOrdering(this.getViewModel().getTabbableConnectors());
            }
        }
    }

    @Override
    public boolean allowClientSideTabbing() {
        PartObjectsModel partObjectsModel = this.layoutViewModel.getFixedPartsObjectsModel();
        return !partObjectsModel.hasAnyPortalObjects() && !this.app.getLayoutContainer().getPopoverHandler().isPopoverOpen();
    }

    @Override
    public boolean refreshingViewData() {
        return this.loading.get();
    }

    @Override
    public LayoutObject getLayoutObjectFromPortal(ObjectSpec objectSpec, boolean bl) {
        return this.getLayoutObject(objectSpec);
    }

    @Override
    public void removeAllPortalRows() {
        if (this.layoutViewModel != null) {
            this.layoutViewModel.getFixedPartsObjectsModel().removeAllPortalRows();
        }
    }

    @Override
    public boolean isClientSideAutoSizing() {
        return this.getLayoutMetaData().isClientSideAutoSizing();
    }

    @Override
    public void statusAreaVisibilityChanged() {
    }

    @Override
    public void onEvent(UIEvent uIEvent) {
        switch (uIEvent.getType()) {
            case VIEW_STYLE_CHANGE: {
                if (!this.app.isFormView()) break;
                boolean bl = !BrowserInfoHandler.isMobile(this.app) || AppServlet.isPullToRefreshEnabled();
                this.updatePullToRefresh(bl);
                break;
            }
        }
    }
}

