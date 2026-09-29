/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.Scheduler
 *  com.google.gwt.core.client.Scheduler$ScheduledCommand
 *  com.google.gwt.event.dom.client.ClickEvent
 *  com.google.gwt.event.dom.client.KeyDownEvent
 *  com.google.gwt.event.dom.client.KeyDownHandler
 *  com.google.gwt.user.client.DOM
 *  com.google.gwt.user.client.Event
 *  com.google.gwt.user.client.ui.ButtonBase
 *  com.vaadin.client.UIDL
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.jwpc.iwp.widgetset.client.rpc.RadioSetServerRpc;
import com.filemaker.jwpc.iwp.widgetset.client.state.RadioSetState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCFieldObject;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCFieldObjectState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCFocusableFieldEventManager;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomNavigableOptionGroup;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.ButtonBase;
import com.vaadin.client.UIDL;

public class VCustomRadioSet
extends VCustomNavigableOptionGroup
implements FMCFieldObject,
KeyDownHandler {
    private final FMCFocusableFieldEventManager eventManager = new FMCFocusableFieldEventManager(this.getElement(), this);
    private final FMCFieldObjectState state = new FMCFieldObjectState(this);
    protected RadioSetServerRpc rpc;
    private int rsbs = 0;
    private boolean selectionAllowed = true;

    public void setRsbs(int n) {
        this.rsbs = n;
        this.state.hasTooltip = this.getBooleanState(RadioSetState.BooleanState.hasTooltip);
        this.state.waitForServerOnEnter = true;
        this.state.waitForServerOnExit = true;
        this.state.exitOnTab = this.getBooleanState(RadioSetState.BooleanState.exitOnTAB);
        this.state.exitOnEnter = this.getBooleanState(RadioSetState.BooleanState.exitOnENTER);
        this.state.exitOnReturn = this.getBooleanState(RadioSetState.BooleanState.exitOnRETURN);
        Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand(){

            public void execute() {
                if (VCustomRadioSet.this.isAttached()) {
                    VCustomRadioSet.this.eventManager.initActiveStyle(false);
                }
            }
        });
    }

    private boolean getBooleanState(RadioSetState.BooleanState booleanState) {
        return FMCUtilities.getBooleanValue(this.rsbs, booleanState.ordinal());
    }

    @Override
    public FMCFieldObjectState getState() {
        return this.state;
    }

    @Override
    public void buildOptions(UIDL uIDL) {
        super.buildOptions(uIDL);
        for (ButtonBase buttonBase : this.panel) {
            buttonBase.addKeyDownHandler((KeyDownHandler)this);
        }
    }

    public void onLoad() {
        super.onLoad();
        this.eventManager.initActiveStyle(true);
    }

    public void onUnload() {
        super.onUnload();
        this.eventManager.removeActiveState();
    }

    public void onBrowserEvent(Event event) {
        super.onBrowserEvent(event);
        this.eventManager.handleEvent(event, this.getParent());
    }

    public void registerRadioSetServerRpc(RadioSetServerRpc radioSetServerRpc) {
        this.rpc = radioSetServerRpc;
    }

    public void onClick(ClickEvent clickEvent) {
        if (this.hasScript() || !this.selectionAllowed) {
            clickEvent.preventDefault();
            return;
        }
        this.selectionAllowed = false;
        super.onClick(clickEvent);
    }

    public void onKeyDown(KeyDownEvent keyDownEvent) {
        switch (keyDownEvent.getNativeKeyCode()) {
            case 8: 
            case 46: {
                DOM.eventPreventDefault((Event)DOM.eventGetCurrentEvent());
                keyDownEvent.stopPropagation();
                this.rpc.deleteKeyPressed("true");
                break;
            }
        }
    }

    public void setActiveStyles(boolean bl) {
        this.eventManager.updateActiveStyles(bl);
        if (bl) {
            FMCUtilities.setCanHandleTabKeyDown(true);
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
        this.rpc.onTabPress(true);
    }

    @Override
    public void performPrevOnServer() {
        this.rpc.onTabPress(false);
    }

    @Override
    public void performCommitOnServer(boolean bl) {
        this.rpc.onEnterPress(bl);
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

    protected boolean hasScript() {
        return this.getBooleanState(RadioSetState.BooleanState.hasScript);
    }

    public void setSelectionAllowed(boolean bl) {
        this.selectionAllowed = bl;
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
}

