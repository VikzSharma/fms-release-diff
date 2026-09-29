/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.ui.ContentMode
 *  com.vaadin.ui.Component
 *  com.vaadin.ui.TabSheet
 *  com.vaadin.ui.TabSheet$Tab
 */
package com.filemaker.jwpc.iwp.ui.layout.component.panelcontainer;

import com.filemaker.jwpc.iwp.action.ActionResultGetterHandler;
import com.filemaker.jwpc.iwp.action.ActionResultHandler;
import com.filemaker.jwpc.iwp.action.GlobalUIActionHandlers;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.metadata.ObjectMetaData;
import com.filemaker.jwpc.iwp.metadata.PanelContainerControlMetaData;
import com.filemaker.jwpc.iwp.notification.processor.BrowserInfoHandler;
import com.filemaker.jwpc.iwp.thrift.common.BrowserType;
import com.filemaker.jwpc.iwp.thrift.common.Result;
import com.filemaker.jwpc.iwp.thrift.common.UIActionType;
import com.filemaker.jwpc.iwp.ui.event.EventType;
import com.filemaker.jwpc.iwp.ui.event.PanelSwitchEvent;
import com.filemaker.jwpc.iwp.ui.event.UIEvent;
import com.filemaker.jwpc.iwp.ui.event.UIEventListener;
import com.filemaker.jwpc.iwp.ui.layout.LayoutContainerObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutView;
import com.filemaker.jwpc.iwp.ui.layout.ObjectAttributes;
import com.filemaker.jwpc.iwp.ui.layout.component.HiddenObject;
import com.filemaker.jwpc.iwp.ui.layout.component.panelcontainer.PanelContainerPanel;
import com.filemaker.jwpc.iwp.ui.layout.component.repetition.RepetitionContainer;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.PanelContainerControlServerRpc;
import com.filemaker.jwpc.iwp.widgetset.client.state.PanelContainerControlState;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Component;
import com.vaadin.ui.TabSheet;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class PanelContainerControl
extends TabSheet
implements LayoutContainerObject,
UIEventListener {
    protected App app;
    private LayoutView view;
    private Map<Integer, LayoutObject> childs;
    private LayoutObject parent;
    private PanelContainerControlMetaData metaData;
    private ObjectAttributes attributes;
    private boolean hideConditionOn = false;
    private PanelContainerPanel selectedTab;
    private boolean notifyServer = true;
    private boolean processTabBarClick = false;
    private boolean selectToSwitchTab = false;
    private AtomicBoolean receiveSwitchTabNotification = new AtomicBoolean(false);

    public PanelContainerControl(App app, LayoutView layoutView, PanelContainerControlMetaData panelContainerControlMetaData, ObjectAttributes objectAttributes) {
        this.app = app;
        this.view = layoutView;
        this.metaData = panelContainerControlMetaData;
        this.attributes = objectAttributes;
        this.setStyleName("minimal");
        this.setWidth(panelContainerControlMetaData.getWidth());
        this.setHeight(panelContainerControlMetaData.getHeight());
        this.view.getUIEventBus().subscribe(this, EventType.VISIBLE_PANEL_CHANGE, EventType.CACHED_LAYOUT_RENDERED);
        this.childs = new LinkedHashMap<Integer, LayoutObject>();
        this.registerTabControlRpc();
    }

    @Override
    public void cleanupMemory() {
        if (this.view != null) {
            if (this.view.getUIEventBus() != null) {
                this.view.getUIEventBus().unsubscribe(this, EventType.VISIBLE_PANEL_CHANGE, EventType.CACHED_LAYOUT_RENDERED);
            }
            this.view = null;
        }
        if (this.childs != null) {
            for (LayoutObject layoutObject : this.childs.values()) {
                layoutObject.cleanupMemory();
            }
            this.childs.clear();
            this.childs = null;
        }
        this.metaData = null;
        this.attributes = null;
        this.app = null;
    }

    private void registerTabControlRpc() {
        PanelContainerControlServerRpc panelContainerControlServerRpc = new PanelContainerControlServerRpc(){

            @Override
            public void onClick() {
                if (PanelContainerControl.this.processTabBarClick) {
                    if (!PanelContainerControl.this.selectToSwitchTab) {
                        boolean bl = false;
                        if (PanelContainerControl.this.app.getLayoutContainer().getPopoverHandler().isPopoverOpen()) {
                            bl = !PanelContainerControl.this.attributes.isInPopover();
                        }
                        GlobalUIActionHandlers.COMMIT_RECORD.perform(PanelContainerControl.this.app, new Object[]{bl});
                    }
                    PanelContainerControl.this.selectToSwitchTab = false;
                    PanelContainerControl.this.processTabBarClick = false;
                }
            }
        };
        this.registerRpc(panelContainerControlServerRpc);
    }

    public void setProcessTabBarClick(boolean bl) {
        this.processTabBarClick = bl;
    }

    @Override
    public int getObjectId() {
        return this.metaData.getObjectId();
    }

    @Override
    public String getUniqueId() {
        return this.getId();
    }

    @Override
    public void updateUniqueId() {
        this.setId(IWPUtilities.generateUniqueId(this.app, this));
    }

    @Override
    public ObjectAttributes getAttributes() {
        return this.attributes;
    }

    @Override
    public PanelContainerControlMetaData getMetaData() {
        return this.metaData;
    }

    @Override
    public void setParentComponent(LayoutContainerObject layoutContainerObject) {
        this.parent = layoutContainerObject;
    }

    @Override
    public LayoutObject getParentComponent() {
        return this.parent;
    }

    @Override
    public void addChild(RepetitionContainer repetitionContainer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void addChild(LayoutObject layoutObject) {
        layoutObject.setParentComponent(this);
        this.childs.put(layoutObject.getMetaData().getObjectId(), layoutObject);
    }

    public synchronized void initTabs() {
        this.notifyServer = false;
        try {
            this.app.getAppSession().getSelectedPanel(new ActionResultGetterHandler(){

                /*
                 * WARNING - Removed try catching itself - possible behaviour change.
                 */
                @Override
                public void onFinish(Object object) {
                    PanelContainerControl panelContainerControl = PanelContainerControl.this;
                    synchronized (panelContainerControl) {
                        PanelContainerControl.this.handleGetSelectedPanelNotification((Integer)object);
                    }
                }
            }, this.getAttributes().getObjectSpec(), this.getMetaData().getObjectId());
        }
        finally {
            this.notifyServer = true;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void handleGetSelectedPanelNotification(int n) {
        PanelContainerControl panelContainerControl = this;
        synchronized (panelContainerControl) {
            for (LayoutObject layoutObject : this.childs.values()) {
                String string = layoutObject.getMetaData().getName();
                string = string != null ? string : "";
                TabSheet.Tab tab = this.addTab(layoutObject, string, layoutObject.getIcon());
                ((PanelContainerPanel)layoutObject).setTab(tab, String.valueOf(layoutObject.getObjectId()));
                if (layoutObject.getMetaData().getObjectId() == n) {
                    this.selectedTab = (PanelContainerPanel)layoutObject;
                    this.setSelectedTab(layoutObject, false);
                }
                this.updateDynamicCation(tab, layoutObject);
            }
        }
    }

    protected abstract void updateDynamicCation(TabSheet.Tab var1, Component var2);

    @Override
    public Collection<LayoutObject> getChilds() {
        return this.childs.values();
    }

    @Override
    public void updateLayoutObjectData(Object object, boolean bl) {
    }

    private void updateSelectedTab(PanelContainerPanel panelContainerPanel) {
        if (this.selectedTab != panelContainerPanel) {
            if (this.selectedTab != null) {
                this.selectedTab.clearComponents();
            }
            this.selectedTab = panelContainerPanel;
            if (panelContainerPanel != null) {
                this.getMetaData().setSelectedPanelId(panelContainerPanel.getMetaData().getObjectId());
            }
            if (this.selectedTab != null) {
                this.selectedTab.initComponents();
            }
        }
    }

    public void setSelectedTab(Component component, boolean bl) {
        PanelContainerPanel panelContainerPanel = (PanelContainerPanel)component;
        final PanelContainerPanel panelContainerPanel2 = this.selectedTab;
        this.updateSelectedTab(panelContainerPanel);
        super.setSelectedTab(component, bl);
        if (this.notifyServer && panelContainerPanel != panelContainerPanel2) {
            this.selectToSwitchTab = true;
            this.receiveSwitchTabNotification.set(false);
            this.app.getAppSession().switchTabs(new ActionResultHandler(){
                final /* synthetic */ PanelContainerControl this$0;
                {
                    this.this$0 = panelContainerControl;
                }

                @Override
                public void onFinish(UIActionType uIActionType, Result result) {
                    if (IWPUtilities.hasError(result.getError()) && !this.this$0.receiveSwitchTabNotification.get()) {
                        this.this$0.updateSelectedTab(panelContainerPanel2);
                        this.this$0.setSelectedTab(panelContainerPanel2, false);
                    }
                    if (!this.this$0.processTabBarClick) {
                        this.this$0.selectToSwitchTab = false;
                    }
                    this.this$0.receiveSwitchTabNotification.set(false);
                    this.this$0.focus();
                }
            }, panelContainerPanel.getAttributes().getObjectSpec(), true);
        }
        if (this.notifyServer || panelContainerPanel != null && panelContainerPanel != panelContainerPanel2) {
            panelContainerPanel.refreshDependentUI();
            if (panelContainerPanel2 != null) {
                panelContainerPanel2.refreshDependentUI();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void onEvent(UIEvent uIEvent) {
        switch (uIEvent.getType()) {
            case VISIBLE_PANEL_CHANGE: {
                PanelSwitchEvent panelSwitchEvent = (PanelSwitchEvent)uIEvent;
                if (panelSwitchEvent.getPanelContainerId() == this.getMetaData().getObjectId()) {
                    PanelContainerPanel panelContainerPanel = (PanelContainerPanel)this.childs.get(panelSwitchEvent.getVisiblePanelId());
                    if (panelContainerPanel == null) break;
                    this.notifyServer = false;
                    this.receiveSwitchTabNotification.set(true);
                    try {
                        this.setSelectedTab(panelContainerPanel, false);
                        break;
                    }
                    finally {
                        this.notifyServer = true;
                    }
                }
                this.reapplyPosition();
                break;
            }
            case CACHED_LAYOUT_RENDERED: {
                this.initTabs();
                break;
            }
        }
    }

    @Override
    public void registerToolTip(String string) {
        if (!BrowserInfoHandler.isTouchDevice(this.app)) {
            this.setDescription(string, ContentMode.HTML);
        }
    }

    @Override
    public void addCFStyle(String string) {
        this.addStyleName(string);
    }

    @Override
    public void removeCFStyle(String string) {
        this.removeStyleName(string);
    }

    public PanelContainerControlState getState() {
        return (PanelContainerControlState)super.getState();
    }

    public void beforeClientResponse(boolean bl) {
        super.beforeClientResponse(bl);
        if (!BrowserInfoHandler.isTouchDevice(this.app)) {
            this.updateBooleanState(PanelContainerControlState.BooleanState.hasTooltip, this.getDescription() != null && this.getDescription().length() > 0);
        }
    }

    private void updateBooleanState(PanelContainerControlState.BooleanState booleanState, boolean bl) {
        this.getState().pcbs = IWPUtilities.applyBooleanValue(this.getState().pcbs, booleanState.ordinal(), bl);
    }

    @Override
    public boolean hasHideCondition() {
        return this.getMetaData().hasHideCondition();
    }

    @Override
    public boolean hasHideConditionInFindMode() {
        return this.getMetaData().hasHideConditionInFindMode();
    }

    @Override
    public boolean isHideConditionOn() {
        return this.hideConditionOn;
    }

    @Override
    public void setHideConditionOn(boolean bl) {
        ObjectMetaData objectMetaData;
        this.hideConditionOn = bl;
        if (!this.hideConditionOn && this.app.getBrowserInfoHandler().getBrowserClientInfo().getBrowserType() == BrowserType.kSafariClient && ((objectMetaData = this.getParentComponent().getMetaData()).isPart() || objectMetaData.isPanelContainerPanel())) {
            this.refreshPosition();
        }
    }

    @Override
    public void addChild(HiddenObject hiddenObject) {
        this.addComponent((Component)hiddenObject);
    }

    protected abstract void refreshPosition();

    protected abstract void reapplyPosition();
}

