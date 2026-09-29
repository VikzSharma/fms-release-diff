/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.Scheduler
 *  com.google.gwt.core.client.Scheduler$ScheduledCommand
 *  com.google.gwt.dom.client.Element
 *  com.google.gwt.event.dom.client.BlurEvent
 *  com.google.gwt.event.dom.client.FocusEvent
 *  com.google.gwt.user.client.DOM
 *  com.google.gwt.user.client.Event
 *  com.google.gwt.user.client.ui.Widget
 *  com.vaadin.client.BrowserInfo
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.fields.client.textarea.TextAreaWidget;
import com.filemaker.fields.client.textbox.FocusBlurHandler;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.EditBoxServerRpc;
import com.filemaker.jwpc.iwp.widgetset.client.state.EditBoxState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCFieldObjectState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCInputUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCNavigableObject;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCTextField;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCTextFieldEventManager;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.BrowserInfo;

public class VCustomEditBox
extends TextAreaWidget
implements FMCTextField,
FMCNavigableObject,
FocusBlurHandler {
    private final FMCTextFieldEventManager eventManager;
    private final FMCFieldObjectState state = new FMCFieldObjectState(this);
    private boolean resyncData = false;
    private int ebbs = 0;

    public VCustomEditBox() {
        this.eventManager = this.initEventManager();
        this.addTextBoxFocusHandler(this);
        if (BrowserInfo.get().isAndroid()) {
            this.textBox.setAsCommunicationConnector(FMCTextFieldEventManager.getCommunicationConnector());
        }
    }

    protected FMCTextFieldEventManager initEventManager() {
        return new FMCTextFieldEventManager(this.getElement(), this);
    }

    public void onLoad() {
        super.onLoad();
        this.eventManager.initActiveStyle(true);
        if (this.resyncData) {
            ((EditBoxServerRpc)this.eventManager.rpc).resyncData();
        }
    }

    public void onUnload() {
        super.onUnload();
        this.eventManager.removeActiveState();
    }

    @Override
    public FMCFieldObjectState getState() {
        return this.state;
    }

    public void setTabIndex(int n) {
        this.textBox.setTabIndex(n);
    }

    public void onBrowserEvent(Event event) {
        super.onBrowserEvent(event);
        this.eventManager.handleEvent(event, (Widget)this);
    }

    public void setEbbs(int n) {
        this.ebbs = n;
        this.state.hasTooltip = this.getBooleanState(EditBoxState.BooleanState.hasTooltip);
        this.state.waitForServerOnEnter = this.getBooleanState(EditBoxState.BooleanState.waitForServerOnEnter);
        this.state.waitForServerOnExit = this.getBooleanState(EditBoxState.BooleanState.waitForServerOnExit);
        this.state.exitOnTab = this.getBooleanState(EditBoxState.BooleanState.exitOnTAB);
        this.state.exitOnReturn = this.getBooleanState(EditBoxState.BooleanState.exitOnRETURN);
        this.state.exitOnEnter = this.getBooleanState(EditBoxState.BooleanState.exitOnENTER);
        this.state.isNumberField = this.getBooleanState(EditBoxState.BooleanState.isNumberField);
        this.state.hasObjectKeyTrigger = this.getBooleanState(EditBoxState.BooleanState.hasObjectKeyTrigger);
        this.state.isKeyStrokeEnabled = this.getBooleanState(EditBoxState.BooleanState.isKeyStrokeEnabled);
        this.state.hasLayoutKeyTrigger = this.getBooleanState(EditBoxState.BooleanState.hasLayoutKeyTrigger);
        boolean bl = this.getBooleanState(EditBoxState.BooleanState.hasScript);
        this.eventManager.updateState(bl, this.getBooleanState(EditBoxState.BooleanState.hasModifyTrigger), this.getBooleanState(EditBoxState.BooleanState.isCalcOrSummary));
        if (!bl || !FMCUtilities.isMobile()) {
            this.setTextInputAllowed(true);
        }
        Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand(){

            public void execute() {
                VCustomEditBox.this.setHideZeroesOn(VCustomEditBox.this.getBooleanState(EditBoxState.BooleanState.hideZeroesOn));
                if (VCustomEditBox.this.getBooleanState(EditBoxState.BooleanState.isTextyField)) {
                    VCustomEditBox.this.innerBorder.addClassName("inner_border_texty");
                }
                if (VCustomEditBox.this.isAttached()) {
                    VCustomEditBox.this.eventManager.initActiveStyle(false);
                }
            }
        });
    }

    public void registerTextFieldServerRpc(EditBoxServerRpc editBoxServerRpc) {
        this.eventManager.registerTextFieldServerRpc(editBoxServerRpc);
    }

    public boolean getBooleanState(EditBoxState.BooleanState booleanState) {
        return FMCUtilities.getBooleanValue(this.ebbs, booleanState.ordinal());
    }

    public void setWidth(String string) {
        if (string.endsWith("px")) {
            DOM.setStyleAttribute((Element)this.getElement(), (String)"width", (String)string);
        } else {
            super.setWidth(string);
        }
    }

    public void setHeight(String string) {
        if (string.endsWith("px")) {
            DOM.setStyleAttribute((Element)this.getElement(), (String)"height", (String)string);
        } else {
            super.setHeight(string);
        }
    }

    @Override
    public void setServerText(String string) {
        if (!this.eventManager.getLastServerKnownText().equals(string)) {
            this.safeSetText(string);
            this.eventManager.setLastServerKnownText(string);
        }
    }

    @Override
    public void syncServerValue() {
        String string = this.eventManager.getLastServerKnownText();
        this.safeSetText(string);
        this.eventManager.setLastServerKnownText(string);
    }

    @Override
    public void resyncServerValue(String string) {
        this.setServerText(string);
    }

    @Override
    public boolean attemptFocus() {
        return this.eventManager.attemptFocus();
    }

    public void onFocus(FocusEvent focusEvent) {
        if (BrowserInfo.get().isIOS() && !this.state.waitForServerOnEnter && !this.getBooleanState(EditBoxState.BooleanState.hasScript)) {
            this.performTabFocus();
        }
    }

    public void onBlur(BlurEvent blurEvent) {
        if (BrowserInfo.get().isIOS() && !this.state.waitForServerOnEnter) {
            if (!FMCUtilities.isTouchToCommit() && !this.state.exitOnTab) {
                this.eventManager.handleTabInsertion();
            } else {
                if (FMCUtilities.isTouchToCommit()) {
                    FMCUtilities.setTouchToCommit(false);
                }
                this.eventManager.onBlur(blurEvent);
            }
        } else {
            this.eventManager.onBlur(blurEvent);
        }
        this.resyncData = false;
    }

    @Override
    public void removeActiveState() {
        this.eventManager.removeActiveState();
    }

    @Override
    public void performTabFocus() {
        this.eventManager.performTabFocus();
    }

    @Override
    public void prepareForFocus() {
        this.eventManager.prepareForFocus();
    }

    @Override
    public void prepareForExit() {
        this.eventManager.prepareForExit();
    }

    @Override
    public void performNextOnServer() {
        this.eventManager.performNextOnServer();
    }

    @Override
    public void performPrevOnServer() {
        this.eventManager.performPrevOnServer();
    }

    @Override
    public void performCommitOnServer(boolean bl) {
        this.eventManager.performCommitOnServer(bl);
    }

    @Override
    public void performOnKeyDownOnServer(String string, int n, boolean bl) {
        this.eventManager.performOnKeyDownOnServer(string, n, bl);
    }

    @Override
    public boolean performBrowserResize(int n, int n2) {
        this.eventManager.performBrowserResize(n, n2);
        return true;
    }

    @Override
    public void performModify() {
        this.eventManager.performModify();
    }

    @Override
    public void setPendingNavigationFocus() {
        this.eventManager.setPendingNavigationFocus();
    }

    @Override
    public void checkNavigationFocus() {
        this.eventManager.checkNavigationFocus();
    }

    @Override
    public void performNavigationFocus() {
        this.textBox.onNavigationFocus();
    }

    @Override
    public boolean hasUniqueId() {
        return this.getUniqueId() != null;
    }

    @Override
    public String getUniqueId() {
        return this.getElement().getId();
    }

    @Override
    public void storeCurrentCursorPosition() {
        this.textBox.storeCurrentCursorPosition();
    }

    @Override
    public void blockTabbing() {
        if (BrowserInfo.get().isIOS() && this.textBox.isTabbingAllowed()) {
            this.textBox.blockTabbing(true);
            this.textBox.setTabIndex(-1);
        }
    }

    @Override
    public void unblockTabbing() {
        if (BrowserInfo.get().isIOS() && !this.textBox.isTabbingAllowed()) {
            this.textBox.blockTabbing(false);
            this.textBox.setTabIndex(0);
        }
    }

    @Override
    public boolean flushTextChangeOnScroll() {
        if (this.eventManager.flushTextChangeOnScroll()) {
            this.resyncData = true;
            return true;
        }
        return false;
    }

    @Override
    public void setPortalFocus() {
        this.attemptFocus();
    }

    public native void forceRepaint(String var1);

    @Override
    public void handleContextMenuOnServer(final int n, final int n2) {
        this.textBox.startContextMenuFocus();
        Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand(){
            final /* synthetic */ VCustomEditBox this$0;
            {
                this.this$0 = vCustomEditBox;
            }

            public void execute() {
                this.this$0.textBox.cacheContextMenuSelection();
                this.this$0.eventManager.onShowContextMenu(n, n2, this.this$0.textBox.getContextMenuSelectionRange()[1]);
            }
        });
    }

    @Override
    public void handleContextMenuCopy() {
        this.textBox.handleContextMenuCopy();
    }

    @Override
    public void handleContextMenuPaste(String string) {
        this.textBox.handleContextMenuPaste(string);
    }

    @Override
    public void exitField() {
        this.eventManager.exitField(false);
    }

    @Override
    public void onFocusIn(Element element) {
        if (FMCInputUtilities.isKeyboardTab()) {
            this.performTabFocus();
        }
    }

    @Override
    public void onFocusOut(Element element) {
    }
}

