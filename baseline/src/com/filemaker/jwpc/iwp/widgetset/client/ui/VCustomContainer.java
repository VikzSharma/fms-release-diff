/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.Scheduler
 *  com.google.gwt.core.client.Scheduler$ScheduledCommand
 *  com.google.gwt.dom.client.Element
 *  com.google.gwt.dom.client.Style
 *  com.google.gwt.user.client.Event
 *  com.vaadin.client.ui.VDragAndDropWrapper
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.jwpc.iwp.widgetset.client.state.ContainerState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCFieldEventManager;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCFieldObject;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCFieldObjectState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCNavigableObject;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.Event;
import com.vaadin.client.ui.VDragAndDropWrapper;

public class VCustomContainer
extends VDragAndDropWrapper
implements FMCFieldObject,
FMCNavigableObject {
    private final FMCFieldEventManager eventManager = new FMCFieldEventManager(this.getElement(), this);
    private final FMCFieldObjectState state = new FMCFieldObjectState(this);
    private int ctbs = 0;

    public void setCtbs(int n) {
        this.ctbs = n;
    }

    private boolean getBooleanState(ContainerState.BooleanState booleanState) {
        return FMCUtilities.getBooleanValue(this.ctbs, booleanState.ordinal());
    }

    @Override
    public FMCFieldObjectState getState() {
        return this.state;
    }

    public void onLoad() {
        super.onLoad();
        this.eventManager.initActiveStyle(true);
        if (FMCUtilities.useAriaCompliantControl()) {
            this.getElement().setTabIndex(0);
            this.getElement().setAttribute("role", "group");
            Style style = this.getElement().getStyle();
            style.setProperty("user-select", "none");
            style.setProperty("-webkit-user-select", "none");
            style.setProperty("-webkit-user-drag", "none");
        }
    }

    public void onUnload() {
        super.onUnload();
        this.eventManager.removeActiveState();
    }

    public void onBrowserEvent(Event event) {
        super.onBrowserEvent(event);
        this.eventManager.handleEvent(event, this.getParent());
    }

    public void updateState(ContainerState containerState) {
        this.state.hasTooltip = this.getBooleanState(ContainerState.BooleanState.hasTooltip);
        this.state.waitForServerOnEnter = true;
        this.state.waitForServerOnExit = true;
        this.state.exitOnTab = true;
        this.state.exitOnEnter = true;
        this.state.exitOnReturn = true;
        Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand(){

            public void execute() {
                if (VCustomContainer.this.isAttached()) {
                    VCustomContainer.this.eventManager.initActiveStyle(false);
                }
            }
        });
    }

    public void setActiveStyles(boolean bl) {
        this.eventManager.updateActiveStyles(bl);
        if (bl) {
            FMCUtilities.setCanHandleTabKeyDown(true);
            if (!FMCUtilities.useAriaCompliantControl()) {
                FMCUtilities.removeFocus();
            }
        }
    }

    @Override
    public void removeActiveState() {
        this.eventManager.removeActiveState();
    }

    @Override
    public void performTabFocus() {
    }

    @Override
    public void performNextOnServer() {
    }

    @Override
    public void performPrevOnServer() {
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
    }

    @Override
    public boolean hasUniqueId() {
        return this.getElement().getParentElement() != null && this.getUniqueId() != null;
    }

    @Override
    public String getUniqueId() {
        return this.getElement().getParentElement().getId();
    }

    @Override
    public void storeCurrentCursorPosition() {
    }

    @Override
    public void handleContextMenuOnServer(int n, int n2) {
    }

    @Override
    public void handleContextMenuCopy() {
    }

    @Override
    public void handleContextMenuPaste(String string) {
    }

    @Override
    public void onFocusIn(Element element) {
        this.setActiveStyles(true);
    }

    @Override
    public void onFocusOut(Element element) {
    }
}

