/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.Component
 *  com.vaadin.ui.CssLayout
 */
package com.filemaker.jwpc.iwp.ui.layout;

import com.filemaker.jwpc.iwp.action.ActionResultGetterHandler;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.application.AppException;
import com.filemaker.jwpc.iwp.application.AppRuntimeException;
import com.filemaker.jwpc.iwp.cache.CacheManager;
import com.filemaker.jwpc.iwp.thrift.common.Dimensions;
import com.filemaker.jwpc.iwp.thrift.common.LayoutObjectType;
import com.filemaker.jwpc.iwp.thrift.common.LayoutViewStyle;
import com.filemaker.jwpc.iwp.thrift.common.ObjectSpec;
import com.filemaker.jwpc.iwp.thrift.layout.FieldObjectData;
import com.filemaker.jwpc.iwp.thrift.layout.LayoutData;
import com.filemaker.jwpc.iwp.thrift.layout.LayoutUI;
import com.filemaker.jwpc.iwp.thrift.layout.NonFieldObjectData;
import com.filemaker.jwpc.iwp.thrift.layout.SinglePartObjectsData;
import com.filemaker.jwpc.iwp.thrift.layout.SingleRowPartsData;
import com.filemaker.jwpc.iwp.thrift.notification.ActiveRowStateNotification;
import com.filemaker.jwpc.iwp.ui.event.EventType;
import com.filemaker.jwpc.iwp.ui.event.UIEvent;
import com.filemaker.jwpc.iwp.ui.layout.LayoutContainerState;
import com.filemaker.jwpc.iwp.ui.layout.LayoutObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutView;
import com.filemaker.jwpc.iwp.ui.layout.LayoutViewManager;
import com.filemaker.jwpc.iwp.ui.layout.component.Button;
import com.filemaker.jwpc.iwp.ui.layout.component.SegmentedBar;
import com.filemaker.jwpc.iwp.ui.layout.component.popover.PopoverHandler;
import com.filemaker.jwpc.iwp.ui.layout.component.popover.PopoverWindow;
import com.filemaker.jwpc.iwp.ui.layout.component.portal.Portal;
import com.filemaker.jwpc.iwp.ui.layout.form.LayoutFormView;
import com.filemaker.jwpc.iwp.ui.layout.list.LayoutListView;
import com.filemaker.jwpc.iwp.ui.layout.listener.LayoutListener;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.filemaker.jwpc.iwp.util.LayoutObjectUtilities;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LayoutContainer
extends CssLayout {
    private final App app;
    private final LayoutListener layoutListener;
    private final LayoutViewManager viewManager;
    private final LayoutContainerState state;
    private LayoutView addedView;
    private PopoverHandler popoverHandler;
    private String previousLayoutCSSFilePath;
    private String previousOverridesCSSFilePath;

    public LayoutContainer(App app) throws AppRuntimeException {
        this.app = app;
        this.layoutListener = new LayoutListener(app);
        this.setStyleName(app.getAppView().isCardStyleWindow() ? "iwp-card-window" : "iwp-layout-container");
        this.setSizeFull();
        this.addLayoutClickListener(this.layoutListener);
        this.viewManager = new LayoutViewManager(app, this);
        this.state = new LayoutContainerState();
        IWPUtilities.assignUniqueId(app, "c", (Component)this);
    }

    public void cleanupMemory() {
        this.removeLayoutClickListener(this.layoutListener);
        this.previousLayoutCSSFilePath = null;
        this.previousOverridesCSSFilePath = null;
    }

    public synchronized void updateLayout(LayoutUI layoutUI, boolean bl, boolean bl2, boolean bl3, boolean bl4) throws AppException {
        LayoutView layoutView;
        int n = this.app.getAppSession().getSessionID();
        String string = IWPUtilities.generateLayoutKey(this.app.getAppSession().getLayoutID(), this.app.getAppView().isCardStyleWindow());
        String string2 = this.app.getAppSession().getLayoutName();
        long l = this.app.getAppSession().getLayoutModCount();
        LayoutViewStyle layoutViewStyle = this.getViewStyle();
        Dimensions dimensions = this.app.getBrowserInfoHandler().getBrowserClientInfo().getBrowserDimensions();
        if (this.viewManager.view != null) {
            if (this.viewManager.view instanceof LayoutFormView) {
                ((LayoutFormView)this.viewManager.view).removeNavPartsIfNeeded(this);
            } else if (this.viewManager.view instanceof LayoutListView) {
                ((LayoutListView)this.viewManager.view).removeNavPartsIfNeeded(this);
            }
        }
        boolean bl5 = false;
        if (!bl && (layoutView = CacheManager.USER_CACHE_MANAGER.getLayoutView(n, string, l, layoutViewStyle, dimensions)) != null) {
            bl5 = true;
            this.getContainerState().getLayoutRefreshState().setRefreshInProgress(true, bl);
            this.viewManager.view = layoutView;
            this.viewManager.view.resetCachedView();
            this.app.getLayoutDataModel().update(this.viewManager.view.getLayoutMetaData());
            this.updateViewStyle(layoutViewStyle, true, true, bl2, true, bl3, bl4);
        }
        if (!bl5) {
            this.getContainerState().getLayoutRefreshState().setRefreshInProgress(true, bl);
            this.viewManager.forceCreateView(layoutUI, n, string, string2, l, layoutViewStyle);
            this.updateViewStyle(layoutViewStyle, true, false, bl2, true, bl3, bl4);
        }
    }

    public synchronized void updateViewStyle(LayoutViewStyle layoutViewStyle, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) throws AppException {
        if (!bl) {
            int n = this.app.getAppSession().getSessionID();
            String string = IWPUtilities.generateLayoutKey(this.app.getAppSession().getLayoutID(), this.app.getAppView().isCardStyleWindow());
            String string2 = this.app.getAppSession().getLayoutName();
            long l = this.app.getAppSession().getLayoutModCount();
            Dimensions dimensions = this.app.getBrowserInfoHandler().getBrowserClientInfo().getBrowserDimensions();
            bl2 = this.viewManager.createView(n, string, string2, l, layoutViewStyle, dimensions);
        }
        if (this.addedView != null) {
            if (bl4 && this.viewManager.view != null) {
                if (this.viewManager.view instanceof LayoutFormView) {
                    ((LayoutFormView)this.viewManager.view).removeNavPartsIfNeeded(this);
                } else if (this.viewManager.view instanceof LayoutListView) {
                    ((LayoutListView)this.viewManager.view).removeNavPartsIfNeeded(this);
                }
            }
            this.addedView.removeAllPortalRows();
            this.removeComponent(this.addedView.getViewComponent());
        }
        if (this.previousLayoutCSSFilePath == null || this.previousOverridesCSSFilePath == null || !this.previousLayoutCSSFilePath.equals(this.viewManager.view.getLayoutCSSFilePath()) || !this.previousOverridesCSSFilePath.equals(this.viewManager.view.getOverridesCSSFilePath())) {
            LayoutObjectUtilities.clearAllConditionalFormattingIds(this.app);
            this.viewManager.view.updateCSSLinks(this.app.getCommunicationComponent(), bl5);
            if (!this.app.getAppView().isCardStyleWindow()) {
                this.previousLayoutCSSFilePath = this.viewManager.view.getLayoutCSSFilePath();
                this.previousOverridesCSSFilePath = this.viewManager.view.getOverridesCSSFilePath();
            }
        }
        this.addedView = this.viewManager.view;
        if (bl4) {
            if (this.viewManager.view instanceof LayoutFormView) {
                ((LayoutFormView)this.viewManager.view).updateNavPartsIfNeeded(this);
            } else if (this.viewManager.view instanceof LayoutListView) {
                ((LayoutListView)this.viewManager.view).updateNavPartsIfNeeded(this);
            }
        }
        this.addComponent(this.addedView.getViewComponent());
        this.viewManager.view.refreshViewData(bl2, bl3, bl6);
        if (bl2) {
            this.app.notify(new UIEvent(EventType.CACHED_LAYOUT_RENDERED));
        }
        this.app.notify(new UIEvent(EventType.LAYOUT_RENDERED));
        this.app.getActiveUIHandler().setPendingRefresh();
        this.processPostLayoutCreation();
    }

    private void processPostLayoutCreation() {
        if (this.app.isKeystrokeEnabled()) {
            this.app.enableKeystrokeListener();
            this.app.setKeystrokeScriptTriggerListenerAtLayout(true);
        } else {
            this.app.disableKeystrokeListener();
            this.app.setKeystrokeScriptTriggerListenerAtLayout(false);
        }
    }

    public LayoutViewStyle getViewStyle() {
        return this.app.getLayoutDataModel().getViewStyle();
    }

    public LayoutView getCurrentView() {
        return this.viewManager.view;
    }

    public LayoutContainerState getContainerState() {
        return this.state;
    }

    public int getLayoutId() {
        return this.viewManager.view.getLayoutMetaData().getLayoutId();
    }

    public PopoverHandler getPopoverHandler() {
        if (this.popoverHandler == null) {
            this.popoverHandler = new PopoverHandler(this.app);
        }
        return this.popoverHandler;
    }

    public PopoverWindow getPopoverWindow() {
        return this.getPopoverHandler().getPopoverWindow();
    }

    public void removeLocalStyles() {
        LayoutObjectUtilities.clearAllConditionalFormattingIds(this.app);
    }

    public synchronized void setActiveRowState(ActiveRowStateNotification activeRowStateNotification) {
        this.viewManager.view.updateActiveRowState(activeRowStateNotification);
    }

    public synchronized void updateRowSet(int n, int n2, boolean bl, boolean bl2, boolean bl3) throws AppException {
        LayoutView layoutView = this.getCurrentView();
        if (layoutView != null) {
            LayoutViewStyle layoutViewStyle = this.getViewStyle();
            switch (layoutViewStyle) {
                case FORM: 
                case LIST: {
                    layoutView.updateRowSet(n, n2, bl, bl2, bl3);
                    break;
                }
            }
        }
    }

    public synchronized void updateRowSelection(boolean bl) {
        this.viewManager.view.updateRowSelection(bl);
    }

    public synchronized void refreshRowSetData(boolean bl) {
        this.viewManager.view.refreshRowSetData(bl);
    }

    public synchronized void updateRow(Map<Integer, SingleRowPartsData> map) {
        for (SingleRowPartsData singleRowPartsData : map.values()) {
            for (SinglePartObjectsData singlePartObjectsData : singleRowPartsData.getPartsData()) {
                this.viewManager.view.updateRow(singleRowPartsData.getRowIndex(), singleRowPartsData.getPartsData().get(0).getPartIndex(), singlePartObjectsData.getFieldObjectsData(), singlePartObjectsData.getNonFieldObjectsData());
            }
        }
    }

    public synchronized void updateFieldObject(FieldObjectData fieldObjectData) {
        this.viewManager.view.updateFieldObject(fieldObjectData);
    }

    public synchronized void refreshObjects(Map<Integer, ObjectSpec> map, Map<Integer, ObjectSpec> map2) {
        this.viewManager.view.refreshObjects(map, map2);
    }

    public synchronized void updateELO(NonFieldObjectData nonFieldObjectData) {
        this.viewManager.view.updateELO(nonFieldObjectData);
    }

    public void layoutModeChanged() {
        this.viewManager.view.updateModeChange();
    }

    public void logout(int n) {
        this.getPopoverHandler().exitPopover(false);
        this.app.getCommunicationComponent().updateLayoutLinks(null, null);
        CacheManager.USER_CACHE_MANAGER.removeUser(n);
    }

    public static void splitPortalObjects(LayoutView layoutView, Map<Integer, ObjectSpec> map, Map<Integer, ObjectSpec> map2, Map<Integer, Integer> map3, Map<Integer, Set<Integer>> map4, Set<Integer> set) {
        for (ObjectSpec objectSpec : map.values()) {
            int n = objectSpec.getParentPortalId();
            if (n > 0) {
                if (map2.containsKey(n)) continue;
                Set<Integer> set2 = map4.get(n);
                if (set2 == null) {
                    set2 = new HashSet<Integer>();
                    map4.put(n, set2);
                    int n2 = objectSpec.getGrandParentPopoverId();
                    if (n2 > 0) {
                        map3.put(n, n2);
                    }
                }
                set2.add(objectSpec.getObjectId());
                continue;
            }
            set.add(objectSpec.getObjectId());
        }
    }

    public static void refreshPortalAndPortalObjects(LayoutView layoutView, int n, int n2, Map<Integer, Integer> map, Map<Integer, Set<Integer>> map2, Map<Integer, ObjectSpec> map3) {
        ObjectSpec objectSpec;
        for (Integer n3 : map2.keySet()) {
            objectSpec = new ObjectSpec();
            objectSpec.setParentPortalId(0);
            int n4 = 0;
            if (map.containsKey(n3)) {
                n4 = map.get(n3);
            }
            objectSpec.setParentPopoverId(n4);
            objectSpec.setObjectType(LayoutObjectType.PORTAL);
            objectSpec.setObjectId(n3);
            objectSpec.setRepetition((short)1);
            objectSpec.setPortalRowIndex(0);
            objectSpec.setRowIndex(n);
            objectSpec.setRowId(n2);
            Portal portal = (Portal)layoutView.getLayoutObject(objectSpec);
            if (portal == null) continue;
            portal.refreshObjects(map2.get(n3));
        }
        for (Integer n3 : map3.keySet()) {
            objectSpec = map3.get(n3);
            objectSpec.setRowIndex(n);
            Portal portal = (Portal)layoutView.getLayoutObject(objectSpec);
            if (portal == null) continue;
            portal.refresh(false);
        }
    }

    public static void refreshNonPortalObjects(App app, final LayoutView layoutView, Set<Integer> set, int n, int n2) {
        app.getAppSession().getLayoutObjectsData(new ActionResultGetterHandler(){

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            @Override
            public void onFinish(Object object) {
                Class<LayoutContainer> clazz = LayoutContainer.class;
                synchronized (LayoutContainer.class) {
                    LayoutContainer.handleGetLayoutObjectsDataNotification(layoutView, (LayoutData)object);
                    // ** MonitorExit[var2_2] (shouldn't be in output)
                    return;
                }
            }
        }, n, n2, set);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void handleGetLayoutObjectsDataNotification(LayoutView layoutView, LayoutData layoutData) {
        Class<LayoutContainer> clazz = LayoutContainer.class;
        synchronized (LayoutContainer.class) {
            for (SingleRowPartsData singleRowPartsData : layoutData.getRowsData().values()) {
                for (SinglePartObjectsData singlePartObjectsData : singleRowPartsData.getPartsData()) {
                    layoutView.updateRowObjects(singlePartObjectsData.getRowIndex(), singlePartObjectsData.getPartIndex(), singlePartObjectsData.getFieldObjectsData(), singlePartObjectsData.getNonFieldObjectsData());
                }
            }
            // ** MonitorExit[var2_2] (shouldn't be in output)
            return;
        }
    }

    public void activateSegment() {
        LayoutObject layoutObject;
        LayoutObject layoutObject2 = this.getContainerState().getPendingActivatedSegmentBar();
        if (layoutObject2 != null && layoutObject2.getMetaData().isSegmentedObject() && !((Button)layoutObject2).allowGlassPaneActivation() && (layoutObject = ((Button)layoutObject2).getParentComponent()) != null && layoutObject instanceof SegmentedBar) {
            ((SegmentedBar)layoutObject).setActiveSegment(layoutObject2);
            this.getContainerState().setPendingActivatedSegmentBar(null);
        }
    }

    public void statusAreaVisibilityChanged() {
        if (this.viewManager.view != null) {
            this.viewManager.view.statusAreaVisibilityChanged();
        }
    }
}

