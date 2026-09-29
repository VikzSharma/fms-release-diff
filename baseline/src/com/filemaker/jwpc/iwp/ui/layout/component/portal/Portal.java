/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.ui.ContentMode
 *  com.vaadin.ui.AbstractComponent
 *  com.vaadin.ui.Component
 *  com.vaadin.v7.ui.VerticalLayout
 */
package com.filemaker.jwpc.iwp.ui.layout.component.portal;

import com.filemaker.jwpc.iwp.action.ActionResultGetterHandler;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.metadata.PortalMetaData;
import com.filemaker.jwpc.iwp.thrift.layout.PortalRowCount;
import com.filemaker.jwpc.iwp.ui.event.EventType;
import com.filemaker.jwpc.iwp.ui.event.PanelSwitchEvent;
import com.filemaker.jwpc.iwp.ui.event.TableChangeEvent;
import com.filemaker.jwpc.iwp.ui.event.UIEvent;
import com.filemaker.jwpc.iwp.ui.event.UIEventListener;
import com.filemaker.jwpc.iwp.ui.layout.HasGlassPane;
import com.filemaker.jwpc.iwp.ui.layout.LayoutContainer;
import com.filemaker.jwpc.iwp.ui.layout.LayoutContainerObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutObjectBuildingBlock;
import com.filemaker.jwpc.iwp.ui.layout.LayoutView;
import com.filemaker.jwpc.iwp.ui.layout.ObjectAttributes;
import com.filemaker.jwpc.iwp.ui.layout.component.AbsoluteCssLayout;
import com.filemaker.jwpc.iwp.ui.layout.component.portal.PortalRowProperty;
import com.filemaker.jwpc.iwp.ui.layout.component.portal.PortalTable;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.filemaker.jwpc.iwp.util.LayoutObjectUtilities;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Component;
import com.vaadin.v7.ui.VerticalLayout;
import java.util.Set;

public class Portal
extends VerticalLayout
implements LayoutObject,
UIEventListener,
LayoutObjectBuildingBlock,
HasGlassPane {
    private App app;
    protected LayoutView view;
    private LayoutObject parent;
    private final PortalMetaData metaData;
    private final ObjectAttributes attributes;
    private PortalTable table;
    private PortalRowProperty currentSelectedCell;
    private boolean hideConditionOn = false;

    public Portal(App app, LayoutView layoutView, PortalMetaData portalMetaData, ObjectAttributes objectAttributes) {
        this.app = app;
        this.view = layoutView;
        this.metaData = portalMetaData;
        boolean bl = this.hasHideCondition();
        if (this.app.isFindMode()) {
            bl = this.hasHideConditionInFindMode();
        }
        if (bl) {
            LayoutObjectUtilities.initHideLayoutObjectAndRepetitions(this);
        }
        this.attributes = objectAttributes;
        this.setSpacing(false);
        this.setMargin(false);
        this.setWidth(portalMetaData.getWidth());
        this.setHeight(portalMetaData.getHeight());
        this.view.getUIEventBus().subscribe(this, EventType.TABLE_CHANGE, EventType.ROW_SELECTION_CHANGE, EventType.ROW_SET_CHANGE, EventType.ROW_SET_DATA_CHANGE, EventType.ROW_CHANGE, EventType.CACHED_LAYOUT_RENDERED, EventType.MODE_CHANGE, EventType.VISIBLE_PANEL_CHANGE);
        this.table = new PortalTable(app, this, portalMetaData);
        this.addComponent((Component)this.table);
        this.setExpandRatio((Component)this.table, 1.0f);
        this.initUI();
    }

    private void initUI() {
        Portal portal = this;
        LayoutObjectUtilities.initCSSStyles(this, (AbstractComponent)portal, null);
        if (this.metaData.isAltBackground()) {
            portal.addStyleName("iwp-portal-alt-style-custom");
        } else {
            portal.addStyleName("iwp-portal-alt-style");
        }
    }

    public void initPortalRows() {
        this.app.getAppSession().getPortalRowsCount(new ActionResultGetterHandler(){

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            @Override
            public void onFinish(Object object) {
                LayoutContainer layoutContainer = Portal.this.app.getLayoutContainer();
                synchronized (layoutContainer) {
                    Portal.this.getPortalTable().handleGetPortalRowsCountNotification((PortalRowCount)object, true);
                }
            }
        }, this.getAttributes().getObjectSpec(), true, this.getAttributes().getRecordIndex(), this.getObjectId());
    }

    @Override
    public void cleanupMemory() {
        if (this.table != null) {
            this.removeComponent((Component)this.table);
            this.table.cleanupMemory();
            this.table = null;
        }
        if (this.view != null) {
            if (this.view.getUIEventBus() != null) {
                this.view.getUIEventBus().unsubscribe(this, EventType.TABLE_CHANGE, EventType.ROW_SELECTION_CHANGE, EventType.ROW_SET_CHANGE, EventType.ROW_SET_DATA_CHANGE, EventType.ROW_CHANGE, EventType.CACHED_LAYOUT_RENDERED, EventType.MODE_CHANGE, EventType.VISIBLE_PANEL_CHANGE);
            }
            this.view = null;
        }
        if (this.isHideConditionOn()) {
            this.setVisible(true);
        }
    }

    @Override
    public Component getWrappedObject() {
        return this;
    }

    public PortalRowProperty getCurrentSelectedCell() {
        return this.currentSelectedCell;
    }

    private void setCurrentSelectedCell(PortalRowProperty portalRowProperty) {
        this.currentSelectedCell = portalRowProperty;
    }

    @Override
    public int getObjectId() {
        return this.metaData.getObjectId();
    }

    public PortalTable getPortalTable() {
        return this.table;
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
    public PortalMetaData getMetaData() {
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
    public void onEvent(UIEvent uIEvent) {
        block0 : switch (uIEvent.getType()) {
            case VISIBLE_PANEL_CHANGE: {
                if (!this.metaData.useCurrentFoundSet()) break;
                PanelSwitchEvent panelSwitchEvent = (PanelSwitchEvent)uIEvent;
                for (LayoutObject layoutObject = this.getParentComponent(); layoutObject != null; layoutObject = layoutObject.getParentComponent()) {
                    if (panelSwitchEvent.getPanelContainerId() != layoutObject.getObjectId()) continue;
                    this.setPortalFocus(this.app.getLayoutDataModel().getRecordIndex(), this);
                    break block0;
                }
                break;
            }
            case TABLE_CHANGE: {
                TableChangeEvent tableChangeEvent = (TableChangeEvent)uIEvent;
                if (tableChangeEvent.getTableId() != this.getMetaData().getTableId()) break;
                this.refresh(this.shouldResetScrollbar(uIEvent));
                break;
            }
            case ROW_CHANGE: 
            case CACHED_LAYOUT_RENDERED: {
                this.refresh(this.shouldResetScrollbar(uIEvent));
                break;
            }
            case ROW_SELECTION_CHANGE: {
                if (this.metaData.useCurrentFoundSet()) {
                    this.setPortalFocus(this.app.getLayoutDataModel().getRecordIndex(), this);
                    this.getPortalTable().makeActiveRowVisibleAfterRefresh = true;
                }
                if (!this.app.isFormView() && !this.getMetaData().isFixedPart()) break;
                this.refresh(this.shouldResetScrollbar(uIEvent));
                break;
            }
            case ROW_SET_CHANGE: 
            case ROW_SET_DATA_CHANGE: {
                if (!this.app.isFormView() && !this.getMetaData().isFixedPart()) break;
                this.refresh(this.shouldResetScrollbar(uIEvent) && !this.metaData.useCurrentFoundSet());
                break;
            }
            case MODE_CHANGE: {
                this.table.setModeChangedSinceLastRefresh(true);
                if (!this.app.isFindMode()) break;
                if (!(this.metaData.useCurrentFoundSet() || this.getMetaData().hasHideConditionInFindMode() || this.getMetaData().hasPlaceholderTextInFindMode())) {
                    this.table.forceEmptyPortalRowsInFindMode();
                    break;
                }
                this.refresh(this.shouldResetScrollbar(uIEvent));
            }
        }
    }

    public void refresh(boolean bl) {
        if (!this.metaData.hasRetainScroll()) {
            this.setCurrentSelectedCell(null);
        }
        this.table.refresh();
        if (bl && this.table.isShowScrollbar()) {
            if (this.getCurrentSelectedCell() != null) {
                this.table.makeRowVisible(this.getCurrentSelectedCell().getPortalRecordIndex(), null);
            } else {
                this.table.makeRowVisible(1, null);
            }
        }
    }

    @Override
    public void updateLayoutObjectData(Object object, boolean bl) {
    }

    public PortalRowProperty getPortalRow(int n) {
        return this.table.getPortalCell(n);
    }

    void setPortalFocus(int n, LayoutObject layoutObject) {
        PortalRowProperty portalRowProperty;
        if (this.getCurrentSelectedCell() != null) {
            this.getCurrentSelectedCell().unsetSelected();
        }
        if (n != 0 && (portalRowProperty = this.table.getPortalCell(n)) != null) {
            boolean bl = false;
            boolean bl2 = false;
            if (this.getMetaData().hasActiveStyle()) {
                bl = layoutObject == this || layoutObject.getAttributes().getOwningPortal() == this;
            } else if (this.getMetaData().hasGrayHighlight()) {
                bl2 = layoutObject == this;
            }
            portalRowProperty.setSelected(bl, bl2);
            this.setCurrentSelectedCell(portalRowProperty);
        }
    }

    private void unsetPortalFocus() {
        if (!this.metaData.useCurrentFoundSet()) {
            if (this.getCurrentSelectedCell() != null) {
                this.getCurrentSelectedCell().unsetSelected();
            }
            this.setCurrentSelectedCell(null);
        }
    }

    public int portalTableRowIndexForPortalRowIndex(int n) {
        int n2 = this.app.isBrowseMode() ? n - this.metaData.getInitialRowIndex() + 1 : n;
        return n2;
    }

    public void onActiveObjectStateChange(LayoutObject layoutObject, int n, boolean bl) {
        if (bl) {
            this.setPortalFocus(n, layoutObject);
        } else {
            this.unsetPortalFocus();
        }
    }

    public LayoutObject getLayoutObject(int n, short s, int n2) {
        LayoutObject layoutObject = null;
        int n3 = this.app.isFindMode() && !this.metaData.useCurrentFoundSet() ? 1 : n2;
        PortalRowProperty portalRowProperty = this.table.getPortalCell(n3);
        if (portalRowProperty != null) {
            layoutObject = portalRowProperty.getLayoutObject(n, s);
        }
        return layoutObject;
    }

    public void refreshObjects(Set<Integer> set) {
        this.table.refreshObjects(set);
    }

    private boolean shouldResetScrollbar(UIEvent uIEvent) {
        switch (uIEvent.getType()) {
            case TABLE_CHANGE: 
            case CACHED_LAYOUT_RENDERED: 
            case ROW_SELECTION_CHANGE: 
            case ROW_SET_CHANGE: 
            case MODE_CHANGE: {
                return true;
            }
        }
        return false;
    }

    @Override
    public void registerToolTip(String string) {
        this.setDescription(string, ContentMode.HTML);
    }

    public static PortalRowProperty getPortalCell(Component component) {
        if (component == null) {
            return null;
        }
        if (component instanceof PortalRowProperty) {
            return (PortalRowProperty)component;
        }
        if (component instanceof LayoutObject) {
            return Portal.getPortalCell(((LayoutObject)component).getParentComponent());
        }
        return null;
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
    public boolean allowGlassPaneActivation() {
        return false;
    }

    @Override
    public void setHideConditionOn(boolean bl) {
        this.hideConditionOn = bl;
    }

    @Override
    public void addCFStyle(String string) {
        this.addStyleName(string);
    }

    @Override
    public void removeCFStyle(String string) {
        this.removeStyleName(string);
    }

    @Override
    public void setGlassPaneParent(AbsoluteCssLayout absoluteCssLayout) {
    }

    @Override
    public void registerAccTitle(String string) {
        this.setCaption(string);
        this.addStyleName("sr-only-caption-title-and-help");
    }

    @Override
    public void registerAccHelp(String string) {
    }

    @Override
    public void registerAccLabel(String string) {
    }
}

