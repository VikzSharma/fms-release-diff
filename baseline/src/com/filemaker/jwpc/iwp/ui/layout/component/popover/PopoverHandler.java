/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.ui.layout.component.popover;

import com.filemaker.jwpc.iwp.action.GlobalUIActionHandlers;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.metadata.PopoverMetaData;
import com.filemaker.jwpc.iwp.thrift.common.ObjectSpec;
import com.filemaker.jwpc.iwp.ui.event.EventType;
import com.filemaker.jwpc.iwp.ui.event.TableChangeEvent;
import com.filemaker.jwpc.iwp.ui.event.UIEvent;
import com.filemaker.jwpc.iwp.ui.event.UIEventListener;
import com.filemaker.jwpc.iwp.ui.layout.LayoutContainerState;
import com.filemaker.jwpc.iwp.ui.layout.ObjectAttributes;
import com.filemaker.jwpc.iwp.ui.layout.component.Button;
import com.filemaker.jwpc.iwp.ui.layout.component.Popover;
import com.filemaker.jwpc.iwp.ui.layout.component.popover.PopoverButton;
import com.filemaker.jwpc.iwp.ui.layout.component.popover.PopoverWindow;

public class PopoverHandler
implements UIEventListener {
    private final App app;
    private PopoverWindow popoverWindow;
    private ObjectSpec popoverButtonSpec;

    public PopoverHandler(App app) {
        this.app = app;
    }

    public PopoverWindow getPopoverWindow() {
        return this.popoverWindow;
    }

    public void setPopoverWindow(PopoverWindow popoverWindow) {
        if (this.popoverWindow != null && this.app.getWindows().contains((Object)this.popoverWindow)) {
            this.app.removeWindow(this.popoverWindow);
        }
        this.popoverWindow = popoverWindow;
    }

    public void openPopover(int n, ObjectSpec objectSpec) {
        Object object;
        boolean bl = false;
        if (objectSpec != null) {
            if (objectSpec.getParentPortalId() != 0) {
                object = this.app.getLayoutContainer().getContainerState().getPortalRefreshState();
                if (((LayoutContainerState.PortalRefreshState)object).isPortalRefreshInProgress(objectSpec.getParentPortalId())) {
                    ((LayoutContainerState.PortalRefreshState)object).setActivePopoverButtonSpec(objectSpec);
                    ((LayoutContainerState.PortalRefreshState)object).setActivePopoverId(n);
                    bl = true;
                }
            } else {
                object = this.app.getLayoutContainer().getContainerState().getListViewRefreshState();
                if (((LayoutContainerState.ListViewRefreshState)object).isRefreshInProgress()) {
                    ((LayoutContainerState.ListViewRefreshState)object).setActivePopoverButtonSpec(objectSpec);
                    ((LayoutContainerState.ListViewRefreshState)object).setActivePopoverId(n);
                    bl = true;
                }
            }
        }
        if (!bl) {
            object = this.getPopoverWindow();
            if (object != null) {
                PopoverMetaData popoverMetaData = object.getPopover().getMetaData();
                ObjectAttributes objectAttributes = object.getPopover().getAttributes();
                if (popoverMetaData.getObjectId() == n && objectAttributes.getRecordIndex() == objectSpec.getRowIndex() && objectAttributes.getRowId() == objectSpec.getRowId() && objectAttributes.getPortalRecordIndex() == objectSpec.getPortalRowIndex()) {
                    if (!object.isVisible()) {
                        this.showPopoverWindow(objectSpec);
                    }
                    return;
                }
                this.exitPopover(false);
            }
            this.app.getLayoutContainer().getCurrentView().openPopover(objectSpec);
        }
    }

    public void openPopover(PopoverButton popoverButton, ObjectSpec objectSpec) {
        if (popoverButton != null) {
            LayoutContainerState.ListViewRefreshState listViewRefreshState;
            this.popoverWindow = new PopoverWindow(this.app, popoverButton);
            this.setPopoverWindow(this.popoverWindow);
            this.showPopoverWindow(objectSpec);
            if (this.app.isListView() && (listViewRefreshState = this.app.getLayoutContainer().getContainerState().getListViewRefreshState()).getActivePopoverButtonSpec() != null) {
                listViewRefreshState.setActivePopoverButtonSpec(null);
            }
        }
    }

    public void exitPopover(boolean bl) {
        if (this.isPopoverOpen()) {
            if (bl) {
                GlobalUIActionHandlers.EXIT_POPOVER.perform(this.app, null);
            } else {
                this.closePopoverWindow();
            }
        } else {
            this.closePopoverWindow();
        }
    }

    public boolean isPopoverOpen() {
        return this.popoverWindow != null && this.popoverWindow.isVisible();
    }

    private void showPopoverWindow(ObjectSpec objectSpec) {
        if (this.popoverWindow != null) {
            this.popoverButtonSpec = objectSpec;
            this.popoverWindow.show();
            this.app.subscribe(this, EventType.TABLE_CHANGE, EventType.ROW_SELECTION_CHANGE, EventType.ROW_SET_CHANGE, EventType.ROW_CHANGE, EventType.OBJECTS_CHANGE, EventType.LAYOUT_RENDERED);
        }
    }

    private void closePopoverWindow() {
        if (this.popoverWindow != null) {
            this.popoverWindow.clear();
            this.popoverWindow = null;
            this.app.getActiveUIHandler().refreshQuickFindFocusAsNeeded();
        }
        this.popoverButtonSpec = null;
        this.app.unsubscribe(this, EventType.TABLE_CHANGE, EventType.ROW_SELECTION_CHANGE, EventType.ROW_SET_CHANGE, EventType.ROW_CHANGE, EventType.OBJECTS_CHANGE, EventType.LAYOUT_RENDERED);
    }

    private void refreshPopoverWindow() {
        Button button;
        if (this.popoverButtonSpec != null && (button = (Button)this.app.getLayoutContainer().getCurrentView().getLayoutObject(this.popoverButtonSpec)) != null && button instanceof PopoverButton) {
            PopoverButton popoverButton = (PopoverButton)button;
            this.popoverWindow = new PopoverWindow(this.app, popoverButton);
            this.setPopoverWindow(this.popoverWindow);
            this.popoverWindow.show();
        }
    }

    @Override
    public void onEvent(UIEvent uIEvent) {
        if (uIEvent.getType() != EventType.LAYOUT_RENDERED && this.isPopoverOpen()) {
            switch (uIEvent.getType()) {
                case TABLE_CHANGE: {
                    TableChangeEvent tableChangeEvent;
                    Popover popover = this.popoverWindow.getPopover();
                    if (popover == null || (tableChangeEvent = (TableChangeEvent)uIEvent).getTableId() != popover.getMetaData().getTableId()) break;
                    this.popoverWindow.refresh();
                    break;
                }
                case OBJECTS_CHANGE: 
                case ROW_CHANGE: {
                    this.popoverWindow.refresh();
                    break;
                }
                case ROW_SELECTION_CHANGE: 
                case ROW_SET_CHANGE: {
                    if (!this.app.isFormView()) break;
                    this.popoverWindow.refresh();
                    break;
                }
            }
        }
    }

    public void cleanupLayoutViewMemory() {
    }
}

