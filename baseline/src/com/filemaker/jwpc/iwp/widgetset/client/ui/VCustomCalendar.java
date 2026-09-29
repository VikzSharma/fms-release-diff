/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.JavaScriptObject
 *  com.google.gwt.core.client.Scheduler
 *  com.google.gwt.core.client.Scheduler$ScheduledCommand
 *  com.google.gwt.dom.client.Element
 *  com.google.gwt.event.dom.client.BlurEvent
 *  com.google.gwt.event.dom.client.FocusEvent
 *  com.google.gwt.event.dom.client.MouseDownEvent
 *  com.google.gwt.user.client.DOM
 *  com.google.gwt.user.client.Event
 *  com.google.gwt.user.client.ui.Widget
 *  com.vaadin.client.BrowserInfo
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.fields.client.datefield.PopupDateFieldWidget;
import com.filemaker.fields.client.textbox.FocusBlurHandler;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.TextFieldServerRpc;
import com.filemaker.jwpc.iwp.widgetset.client.state.FMCustomDateFieldState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCFieldObjectState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCInputUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCTextField;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCTextFieldEventManager;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.BrowserInfo;
import java.util.Date;

public class VCustomCalendar
extends PopupDateFieldWidget
implements FMCTextField,
FocusBlurHandler {
    private final FMCTextFieldEventManager eventManager;
    private final FMCFieldObjectState state = new FMCFieldObjectState(this);
    private boolean skipToggleOnFocus = false;
    private boolean shouldShowCalendar = false;
    private JavaScriptObject windowResizeHandler = null;
    private int cdbs = 0;

    public VCustomCalendar() {
        this.eventManager = new FMCTextFieldEventManager(this.getElement(), this);
        this.addTextBoxFocusHandler(this);
        this.setTextInputAllowed(true);
        if (BrowserInfo.get().isAndroid()) {
            this.textBox.setAsCommunicationConnector(FMCTextFieldEventManager.getCommunicationConnector());
        }
        if (FMCUtilities.isMobile()) {
            DOM.sinkEvents((Element)this.getElement(), (int)(DOM.getEventsSunk((Element)this.getElement()) | 0x100000));
        } else {
            DOM.sinkEvents((Element)this.getElement(), (int)(DOM.getEventsSunk((Element)this.getElement()) | 4));
        }
    }

    public void setCdbs(int n) {
        this.cdbs = n;
        this.state.hasTooltip = this.getBooleanState(FMCustomDateFieldState.BooleanState.hasTooltip);
        this.state.waitForServerOnEnter = this.getBooleanState(FMCustomDateFieldState.BooleanState.waitForServerOnEnter);
        this.state.waitForServerOnExit = this.getBooleanState(FMCustomDateFieldState.BooleanState.waitForServerOnExit);
        this.state.exitOnTab = this.getBooleanState(FMCustomDateFieldState.BooleanState.exitOnTAB);
        this.state.exitOnReturn = this.getBooleanState(FMCustomDateFieldState.BooleanState.exitOnRETURN);
        this.state.exitOnEnter = this.getBooleanState(FMCustomDateFieldState.BooleanState.exitOnENTER);
        this.state.isNumberField = this.getBooleanState(FMCustomDateFieldState.BooleanState.isNumberField);
        this.eventManager.updateState(this.getBooleanState(FMCustomDateFieldState.BooleanState.hasScript), this.getBooleanState(FMCustomDateFieldState.BooleanState.hasModifyTrigger), false);
        Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand(){

            public void execute() {
                VCustomCalendar.this.setHideZeroesOn(VCustomCalendar.this.getBooleanState(FMCustomDateFieldState.BooleanState.hideZeroesOn));
                if (VCustomCalendar.this.isAttached()) {
                    VCustomCalendar.this.eventManager.initActiveStyle(false);
                }
            }
        });
    }

    private boolean getBooleanState(FMCustomDateFieldState.BooleanState booleanState) {
        return FMCUtilities.getBooleanValue(this.cdbs, booleanState.ordinal());
    }

    public void onLoad() {
        super.onLoad();
        this.eventManager.initActiveStyle(true);
    }

    public void onUnload() {
        super.onUnload();
        this.eventManager.removeActiveState();
    }

    public void onDetach() {
        this.closeCalendarPanel();
        super.onDetach();
    }

    @Override
    public FMCFieldObjectState getState() {
        return this.state;
    }

    public void onBrowserEvent(Event event) {
        if (event.getTypeInt() == 0x100000) {
            this.handleTouchStartEvent(event);
        } else {
            super.onBrowserEvent(event);
            this.eventManager.handleEvent(event, (Widget)this);
        }
    }

    @Override
    public void openCalendarPanel(Date date) {
        super.openCalendarPanel(date);
        if (this.isClientSideAutoSizing()) {
            this.attachWindowResizeHandler();
        }
    }

    @Override
    public void closeCalendarPanel() {
        super.closeCalendarPanel();
        if (this.isClientSideAutoSizing()) {
            FMCUtilities.detachResizeHandler(this.windowResizeHandler);
        }
    }

    private void attachWindowResizeHandler() {
        if (this.windowResizeHandler == null) {
            this.windowResizeHandler = this.getWindowResizeHandler(this);
        }
        FMCUtilities.attachResizeHandler(this.windowResizeHandler);
    }

    private native JavaScriptObject getWindowResizeHandler(VCustomCalendar var1);

    private void onWindowResize() {
        this.closeCalendarPanel();
    }

    public void registerTextFieldServerRpc(TextFieldServerRpc textFieldServerRpc) {
        this.eventManager.registerTextFieldServerRpc(textFieldServerRpc);
    }

    private void handleTouchStartEvent(Event event) {
        this.shouldShowCalendar = this.shouldToggleCalendar(Element.as((JavaScriptObject)event.getEventTarget())) && !this.isPopupShowing() && !this.isPopupJustClosed();
    }

    @Override
    protected void handleMouseDownEvent(MouseDownEvent mouseDownEvent) {
        if (FMCUtilities.isMobile()) {
            if (this.shouldShowCalendar) {
                this.textBox.blockTextInput(true);
            } else {
                this.textBox.blockTextInput(!this.isTextInputAllowed());
                this.textBox.setContentEditable(this.isTextInputAllowed());
            }
        }
        super.handleMouseDownEvent(mouseDownEvent);
    }

    @Override
    protected void checkCalendarStatus(Element element) {
        if (this.skipToggleOnFocus) {
            this.skipToggleOnFocus = false;
            return;
        }
        if (FMCUtilities.isMobile()) {
            if (this.shouldShowCalendar || this.isPopupShowing()) {
                this.toggleCalendarPopup();
            }
        } else {
            super.checkCalendarStatus(element);
        }
    }

    @Override
    public void setTextInputAllowed(boolean bl) {
        super.setTextInputAllowed(bl);
        if (FMCUtilities.isMobile()) {
            this.textBox.blockTextInput(true);
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
    public boolean attemptFocus() {
        return this.eventManager.attemptFocus();
    }

    public void onFocus(FocusEvent focusEvent) {
    }

    public void onBlur(BlurEvent blurEvent) {
        this.eventManager.onBlur(blurEvent);
    }

    @Override
    public void removeActiveState() {
        this.closeCalendarPanel();
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
        this.closeCalendarPanel();
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
    }

    @Override
    public boolean performBrowserResize(int n, int n2) {
        return this.eventManager.performBrowserResize(n, n2);
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
    public void handleFocus() {
        if (this.textBox.pendingMouseRightButton) {
            this.textBox.pendingMouseRightButton = false;
        } else {
            if (!(this.isPopupShowing() || this.isPopupJustClosed() || this.calendarIconShown)) {
                if (FMCUtilities.isMobile()) {
                    this.textBox.blockTextInput(true);
                }
                this.requestCalendarPopupRequest();
                this.skipToggleOnFocus = true;
            }
            if (FMCUtilities.useAriaCompliantControl() && !this.isPopupShowing() && !this.isPopupJustClosed() && this.calendarIconShown && !this.textBox.isContentEditable() && FMCInputUtilities.getLastInteractionSource() == FMCInputUtilities.InteractionSource.KEYBOARD) {
                this.performTabFocus();
                if (this.textBox.getText() != null && this.textBox.getText().trim().length() > 0) {
                    this.textBox.selectAll();
                }
            }
        }
    }

    @Override
    public void handleBlur() {
        super.handleBlur();
        this.skipToggleOnFocus = false;
        if (FMCUtilities.isMobile()) {
            this.textBox.blockTextInput(true);
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

    @Override
    public void storeCurrentCursorPosition() {
        this.textBox.storeCurrentCursorPosition();
    }

    private boolean isClientSideAutoSizing() {
        return this.getBooleanState(FMCustomDateFieldState.BooleanState.CLIENT_SIDE_AUTO_SIZING);
    }

    @Override
    public boolean flushTextChangeOnScroll() {
        return this.eventManager.flushTextChangeOnScroll();
    }

    @Override
    public void setPortalFocus() {
        this.attemptFocus();
    }

    @Override
    public void handleContextMenuOnServer(final int n, final int n2) {
        this.textBox.startContextMenuFocus();
        Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand(){
            final /* synthetic */ VCustomCalendar this$0;
            {
                this.this$0 = vCustomCalendar;
            }

            public void execute() {
                this.this$0.textBox.cacheContextMenuSelection();
                this.this$0.eventManager.onShowContextMenu(n, n2, this.this$0.textBox.getContextMenuSelectionRange()[1]);
            }
        });
    }

    @Override
    public void exitField() {
        this.eventManager.exitField(false);
    }

    @Override
    public void handleContextMenuCopy() {
        this.textBox.handleContextMenuCopy();
    }

    @Override
    public void handleContextMenuPaste(String string) {
        this.textBox.handleContextMenuPaste(string);
    }
}

