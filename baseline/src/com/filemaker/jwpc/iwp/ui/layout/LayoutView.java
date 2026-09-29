/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.Component
 */
package com.filemaker.jwpc.iwp.ui.layout;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.css.FMCommunicationComponent;
import com.filemaker.jwpc.iwp.metadata.ObjectMetaData;
import com.filemaker.jwpc.iwp.model.DataUpdator;
import com.filemaker.jwpc.iwp.model.LayoutViewModel;
import com.filemaker.jwpc.iwp.notification.processor.BrowserInfoHandler;
import com.filemaker.jwpc.iwp.thrift.common.LayoutViewStyle;
import com.filemaker.jwpc.iwp.thrift.common.ObjectSpec;
import com.filemaker.jwpc.iwp.thrift.layout.FieldObjectData;
import com.filemaker.jwpc.iwp.thrift.layout.NonFieldObjectData;
import com.filemaker.jwpc.iwp.thrift.notification.ActiveRowStateNotification;
import com.filemaker.jwpc.iwp.ui.event.UIEventBus;
import com.filemaker.jwpc.iwp.ui.layout.LayoutContainer;
import com.filemaker.jwpc.iwp.ui.layout.LayoutObject;
import com.filemaker.jwpc.iwp.ui.layout.component.BottomNavigation;
import com.filemaker.jwpc.iwp.ui.layout.component.TopNavigation;
import com.filemaker.jwpc.iwp.xml.UIGenerator;
import com.vaadin.ui.Component;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Map;

public abstract class LayoutView {
    protected final App app;
    private final String layKey;
    protected UIEventBus eventBus;
    protected LayoutViewModel layoutViewModel;
    protected DataUpdator dataUpdator;
    protected LayoutContainer layoutContainer;
    protected UIGenerator uiGenerator;
    protected ObjectMetaData metaData;
    protected String layoutCSSFilePath;
    protected String overridesCSSFilePath;
    protected boolean isClassicTheme;
    protected Component viewComponent;
    protected TopNavigation topNav;
    protected BottomNavigation bottomNav;

    public LayoutView(App app, LayoutContainer layoutContainer, String string, long l) {
        this.app = app;
        this.layKey = string;
        this.eventBus = new UIEventBus();
        this.dataUpdator = new DataUpdator(new WeakReference<App>(app), new WeakReference<LayoutView>(this));
        this.layoutViewModel = new LayoutViewModel();
        this.layoutContainer = layoutContainer;
        this.uiGenerator = new UIGenerator(app, this);
    }

    public App getApp() {
        return this.app;
    }

    public String getLayoutKey() {
        return this.layKey;
    }

    public void updateLayoutUI(ObjectMetaData objectMetaData, String string, String string2, boolean bl) {
        this.metaData = objectMetaData;
        this.layoutCSSFilePath = string;
        this.overridesCSSFilePath = string2;
        this.isClassicTheme = bl;
    }

    public abstract void refreshViewData(boolean var1, boolean var2, boolean var3);

    public UIEventBus getUIEventBus() {
        return this.eventBus;
    }

    public LayoutContainer getLayoutContainer() {
        return this.layoutContainer;
    }

    public ObjectMetaData getLayoutMetaData() {
        return this.metaData;
    }

    public DataUpdator getDataUpdator() {
        return this.dataUpdator;
    }

    public UIGenerator getUIGenerator() {
        return this.uiGenerator;
    }

    public abstract void updateRowSet(int var1, int var2, boolean var3, boolean var4, boolean var5);

    public abstract void refreshRowSetData(boolean var1);

    public abstract void updateRowSelection(boolean var1);

    public abstract void updateRow(int var1, int var2, Map<Integer, FieldObjectData> var3, Map<Integer, NonFieldObjectData> var4);

    public abstract void updateRowObjects(int var1, int var2, Map<Integer, FieldObjectData> var3, Map<Integer, NonFieldObjectData> var4);

    public abstract void updateFieldObject(FieldObjectData var1);

    public abstract void refreshObjects(Map<Integer, ObjectSpec> var1, Map<Integer, ObjectSpec> var2);

    public abstract void updateELO(NonFieldObjectData var1);

    public abstract void updateModeChange();

    public abstract void updateActiveRowState(ActiveRowStateNotification var1);

    public abstract LayoutObject getLayoutObject(ObjectSpec var1);

    public abstract Collection<LayoutObject> getLayoutObjects();

    public Component getViewComponent() {
        return this.viewComponent;
    }

    public LayoutViewModel getViewModel() {
        return this.layoutViewModel;
    }

    public abstract LayoutViewStyle getViewStyle();

    public abstract void resetCachedView();

    public abstract void refreshActiveObject(ObjectSpec var1, boolean var2);

    public abstract void openPopover(ObjectSpec var1);

    public boolean isClassicTheme() {
        return this.isClassicTheme;
    }

    void updateCSSLinks(FMCommunicationComponent fMCommunicationComponent, boolean bl) {
        if (bl) {
            fMCommunicationComponent.updateLayoutLinks(this.layoutCSSFilePath, this.overridesCSSFilePath);
        }
    }

    public String getLayoutCSSFilePath() {
        return this.layoutCSSFilePath;
    }

    public String getOverridesCSSFilePath() {
        return this.overridesCSSFilePath;
    }

    public void cleanupMemory() {
        if (this.layoutViewModel != null) {
            this.layoutViewModel.cleanupMemory();
            this.layoutViewModel = null;
        }
        if (this.eventBus != null) {
            this.eventBus.cleanupMemory();
            this.eventBus = null;
        }
        this.metaData = null;
        this.dataUpdator = null;
        this.layoutContainer = null;
        this.uiGenerator = null;
    }

    public abstract void updateTabIndex(LayoutObject var1, int var2, int var3);

    public abstract boolean allowClientSideTabbing();

    public abstract boolean refreshingViewData();

    public abstract LayoutObject getLayoutObjectFromPortal(ObjectSpec var1, boolean var2);

    public abstract void removeAllPortalRows();

    public void removeNavPartsIfNeeded(LayoutContainer layoutContainer) {
        for (int i = layoutContainer.getComponentCount() - 1; i >= 0; --i) {
            Component component = layoutContainer.getComponent(i);
            if (!(component instanceof TopNavigation) && !(component instanceof BottomNavigation)) continue;
            layoutContainer.removeComponent(component);
        }
    }

    public abstract void updateNavPartsIfNeeded(LayoutContainer var1);

    public abstract boolean isClientSideAutoSizing();

    public abstract void statusAreaVisibilityChanged();

    protected void updatePullToRefresh(boolean bl) {
        StringBuilder stringBuilder = new StringBuilder();
        if (BrowserInfoHandler.isiOSDevice(this.app)) {
            stringBuilder.append("document.querySelector('html').classList.");
        } else if (BrowserInfoHandler.isAndroidDevice(this.app)) {
            stringBuilder.append("document.body.classList.");
        }
        if (!stringBuilder.isEmpty()) {
            if (bl) {
                stringBuilder.append("remove");
            } else {
                stringBuilder.append("add");
            }
            stringBuilder.append("('pull-to-refresh-disabled');");
            this.app.getPage().getJavaScript().execute(stringBuilder.toString());
        }
    }

    public boolean isKeyStrokeEnabled() {
        return this.app.isKeystrokeEnabled();
    }

    public boolean hasLayoutKeyStroke() {
        return this.app.getLayoutDataModel().hasKeyTrigger();
    }
}

