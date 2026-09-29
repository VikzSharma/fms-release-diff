/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.JavaScriptObject
 *  com.google.gwt.core.client.Scheduler
 *  com.google.gwt.core.client.Scheduler$ScheduledCommand
 *  com.google.gwt.user.client.Event
 *  com.google.gwt.user.client.ui.Widget
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.fields.client.combobox.ComboBoxItem;
import com.filemaker.fields.client.combobox.ComboBoxWidget;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.PopupServerRpc;
import com.filemaker.jwpc.iwp.widgetset.client.state.PopupState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCFieldObject;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCFieldObjectState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCFocusableFieldEventManager;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCPopupEventManager;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Widget;
import java.util.List;
import java.util.Set;

public class VCustomPopup
extends ComboBoxWidget
implements FMCFieldObject {
    protected FMCFocusableFieldEventManager eventManager;
    protected final FMCFieldObjectState state;
    protected PopupServerRpc rpc = null;
    protected boolean isActive = false;
    protected boolean isWindowResize = false;
    private JavaScriptObject windowResizeHandler = null;
    private int pobs = 0;

    public VCustomPopup() {
        this.initEventManager();
        this.state = new FMCFieldObjectState(this);
    }

    protected void initEventManager() {
        this.eventManager = new FMCPopupEventManager(this.getElement(), this);
    }

    protected FMCFocusableFieldEventManager getEventManager() {
        return this.eventManager;
    }

    public void setPobs(int n) {
        this.pobs = n;
        this.state.hasTooltip = this.getBooleanState(PopupState.BooleanState.hasTooltip);
        this.state.waitForServerOnEnter = true;
        this.state.waitForServerOnExit = true;
        this.state.exitOnTab = this.getBooleanState(PopupState.BooleanState.exitOnTAB);
        this.state.exitOnEnter = this.getBooleanState(PopupState.BooleanState.exitOnENTER);
        this.state.exitOnReturn = this.getBooleanState(PopupState.BooleanState.exitOnRETURN);
        Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand(){

            public void execute() {
                if (VCustomPopup.this.isAttached()) {
                    VCustomPopup.this.eventManager.initActiveStyle(false);
                }
            }
        });
    }

    private boolean getBooleanState(PopupState.BooleanState booleanState) {
        return FMCUtilities.getBooleanValue(this.pobs, booleanState.ordinal());
    }

    @Override
    public FMCFieldObjectState getState() {
        return this.state;
    }

    public void onLoad() {
        super.onLoad();
        this.eventManager.initActiveStyle(true);
    }

    public void onUnload() {
        super.onUnload();
        this.eventManager.removeActiveState();
        if (this.isClientSideAutoSizing()) {
            this.removeWindowResizeHandler();
        }
    }

    public void onBrowserEvent(Event event) {
        super.onBrowserEvent(event);
        this.eventManager.handleEvent(event, (Widget)this);
    }

    public void registerPopupServerRpc(PopupServerRpc popupServerRpc) {
        this.rpc = popupServerRpc;
    }

    public void setActiveStyles(boolean bl) {
        this.getEventManager().updateActiveStyles(bl);
        this.isActive = bl;
        if (bl) {
            FMCUtilities.setCanHandleTabKeyDown(true);
        }
    }

    @Override
    public void showOptions(List<ComboBoxItem> list, int n, int n2, int n3, Set<Integer> set) {
        if (!this.textBox.pendingMouseRightButton) {
            super.showOptions(list, n, n2, n3, set);
        } else {
            this.textBox.pendingMouseRightButton = false;
        }
        if (this.isClientSideAutoSizing()) {
            this.addWindowResizeHandler();
        }
    }

    @Override
    public void hideOptions() {
        super.hideOptions();
        if (this.isClientSideAutoSizing()) {
            if (!this.isWindowResize) {
                this.removeWindowResizeHandler();
            } else {
                this.isWindowResize = false;
            }
        }
    }

    private native JavaScriptObject getWindowResizeHandler(VCustomPopup var1);

    protected void onWindowResize() {
        this.isWindowResize = true;
        this.hideOptions();
    }

    private void addWindowResizeHandler() {
        if (this.windowResizeHandler == null) {
            this.windowResizeHandler = this.getWindowResizeHandler(this);
            FMCUtilities.attachResizeHandler(this.windowResizeHandler);
        }
    }

    private void removeWindowResizeHandler() {
        if (this.windowResizeHandler != null) {
            FMCUtilities.detachResizeHandler(this.windowResizeHandler);
            this.windowResizeHandler = null;
        }
    }

    @Override
    public void removeActiveState() {
        this.getEventManager().removeActiveState();
        this.isActive = false;
    }

    @Override
    public void performTabFocus() {
    }

    @Override
    public void performNextOnServer() {
        this.rpc.onTabPress(true);
    }

    @Override
    public void performPrevOnServer() {
        this.rpc.onTabPress(false);
    }

    @Override
    public void performCommitOnServer(boolean bl) {
    }

    @Override
    public void performOnKeyDownOnServer(String string, int n, boolean bl) {
    }

    @Override
    public boolean performBrowserResize(int n, int n2) {
        return false;
    }

    @Override
    public void prepareForExit() {
        this.isActive = false;
        if (FMCUtilities.useAriaCompliantControl() && this.isPopupShowing()) {
            this.hideOptions();
        }
    }

    public void initialPageRequested() {
        if (!(this.isActive || this.hasScript() || this.textBox.pendingMouseRightButton)) {
            this.rpc.enterField();
        }
    }

    public void setPlaceholderText(String string) {
        if (string == null || string.length() == 0) {
            this.textBox.getElement().removeAttribute("placeholder");
        } else {
            this.textBox.getElement().setAttribute("placeholder", string);
        }
    }

    @Override
    public boolean hasUniqueId() {
        return this.getUniqueId() != null;
    }

    @Override
    public String getUniqueId() {
        return this.getElement().getId();
    }

    protected boolean hasScript() {
        return this.getBooleanState(PopupState.BooleanState.hasScript);
    }

    @Override
    protected boolean selectByFieldValue() {
        return this.getBooleanState(PopupState.BooleanState.dontOverrideFormattingWithValueList);
    }

    @Override
    public void storeCurrentCursorPosition() {
        this.textBox.storeCurrentCursorPosition();
    }

    protected boolean isClientSideAutoSizing() {
        return this.getBooleanState(PopupState.BooleanState.CLIENT_SIDE_AUTO_SIZING);
    }

    @Override
    public void handleContextMenuOnServer(int n, int n2) {
        int n3 = 0;
        if (!this.textBox.getText().isEmpty()) {
            this.textBox.selectAll();
            this.textBox.cacheContextMenuSelection();
            n3 = this.textBox.getContextMenuSelectionRange()[1];
        }
        this.rpc.onShowContextMenu(n, n2, n3);
    }

    @Override
    public void handleContextMenuCopy() {
        this.textBox.selectAll();
    }

    @Override
    public void handleContextMenuPaste(String string) {
        this.rpc.insertData(string);
    }
}

