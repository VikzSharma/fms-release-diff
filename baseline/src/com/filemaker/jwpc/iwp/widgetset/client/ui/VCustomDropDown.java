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
 *  com.vaadin.client.BrowserInfo
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.fields.client.combobox.ComboBoxItem;
import com.filemaker.fields.client.textbox.FocusBlurHandler;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.TextFieldServerRpc;
import com.filemaker.jwpc.iwp.widgetset.client.state.DropDownState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCInputUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCTextField;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCTextFieldEventManager;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomPopup;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.vaadin.client.BrowserInfo;
import java.util.List;
import java.util.Set;

public class VCustomDropDown
extends VCustomPopup
implements FMCTextField,
FocusBlurHandler {
    private boolean shouldShowPopup = false;
    private List<ComboBoxItem> options;
    private int startIndex;
    private int pageLength;
    private int totalAmount;
    private Set<Integer> separatorIndexes;
    private int ddbs = 0;

    public VCustomDropDown() {
        this.addTextBoxFocusHandler(this);
        this.setTextInputAllowed(true);
        if (FMCUtilities.isMobile()) {
            DOM.sinkEvents((Element)this.getElement(), (int)0x100000);
        }
    }

    public void setDdbs(int n) {
        this.ddbs = n;
        this.getEventManager().updateState(this.hasScript(), this.getBooleanState(DropDownState.BooleanState.hasModifyTrigger), false);
        Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand(){

            public void execute() {
                VCustomDropDown.this.setHideZeroesOn(VCustomDropDown.this.getBooleanState(DropDownState.BooleanState.hideZeroesOn));
            }
        });
    }

    private boolean getBooleanState(DropDownState.BooleanState booleanState) {
        return FMCUtilities.getBooleanValue(this.ddbs, booleanState.ordinal());
    }

    @Override
    protected void initEventManager() {
        this.eventManager = new FMCTextFieldEventManager(this.getElement(), this);
        if (BrowserInfo.get().isAndroid()) {
            this.textBox.setAsCommunicationConnector(FMCTextFieldEventManager.getCommunicationConnector());
        }
    }

    @Override
    protected FMCTextFieldEventManager getEventManager() {
        return (FMCTextFieldEventManager)this.eventManager;
    }

    public void registerTextFieldServerRpc(TextFieldServerRpc textFieldServerRpc) {
        this.getEventManager().registerTextFieldServerRpc(textFieldServerRpc);
    }

    @Override
    public void onBrowserEvent(Event event) {
        if (event.getTypeInt() == 0x100000) {
            this.handleTouchStartEvent(event);
        } else {
            super.onBrowserEvent(event);
        }
    }

    private void handleTouchStartEvent(Event event) {
        this.shouldShowPopup = this.shouldShowPopup(Element.as((JavaScriptObject)event.getEventTarget()));
    }

    @Override
    protected void handleMouseDownEvent(MouseDownEvent mouseDownEvent) {
        if (FMCUtilities.isMobile()) {
            if (this.shouldShowPopup) {
                this.textBox.blockTextInput(true);
            } else {
                this.textBox.blockTextInput(!this.isTextInputAllowed());
                this.textBox.setContentEditable(this.isTextInputAllowed());
            }
        }
        super.handleMouseDownEvent(mouseDownEvent);
    }

    @Override
    public void showOptions(List<ComboBoxItem> list, int n, int n2, int n3, Set<Integer> set) {
        super.showOptions(list, n, n2, n3, set);
        if (this.isClientSideAutoSizing()) {
            this.options = list;
            this.startIndex = n;
            this.pageLength = n2;
            this.totalAmount = n3;
            this.separatorIndexes = set;
        }
    }

    @Override
    protected void onWindowResize() {
        super.onWindowResize();
        if (this.isClientSideAutoSizing()) {
            this.showOptions(this.options, this.startIndex, this.pageLength, this.totalAmount, this.separatorIndexes);
        }
    }

    @Override
    protected void checkPopupStatus(Element element) {
        if (FMCUtilities.isMobile()) {
            if (this.shouldShowPopup) {
                this.requestInitialPage();
                this.shouldShowPopup = false;
            } else if (this.shouldHidePopup(element)) {
                this.hideOptions();
            }
        } else {
            super.checkPopupStatus(element);
        }
    }

    @Override
    protected void onTextInput() {
        boolean bl = false;
        if (this.getBooleanState(DropDownState.BooleanState.hasIcon)) {
            if (this.isPopupShowing()) {
                bl = true;
            }
        } else if (this.isPopupShowing() || this.getBooleanState(DropDownState.BooleanState.useAutoComplete)) {
            bl = true;
        }
        this.setUpdateSuggestionOnTextInput(bl);
        super.onTextInput();
    }

    @Override
    protected boolean selectByFieldValue() {
        return true;
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
        if (!this.getEventManager().getLastServerKnownText().equals(string)) {
            this.safeSetText(string);
            this.getEventManager().setLastServerKnownText(string);
        }
    }

    @Override
    public void syncServerValue() {
        super.syncServerValue();
        String string = this.getEventManager().getLastServerKnownText();
        this.safeSetText(string);
        this.getEventManager().setLastServerKnownText(string);
    }

    public void setServerActive(boolean bl) {
        this.isActive = bl;
        if (bl) {
            FMCUtilities.setCanHandleTabKeyDown(true);
        }
    }

    @Override
    public boolean attemptFocus() {
        boolean bl = false;
        if (!this.isActive) {
            if (!this.hasScript() && this.isEnabled() && !this.isReadOnly()) {
                bl = this.getEventManager().attemptFocus();
            }
        } else {
            bl = true;
        }
        return bl;
    }

    public void onFocus(FocusEvent focusEvent) {
    }

    public void onBlur(BlurEvent blurEvent) {
        this.getEventManager().onBlur(blurEvent);
    }

    @Override
    public void performTabFocus() {
        this.getEventManager().performTabFocus();
    }

    @Override
    public void prepareForFocus() {
        this.getEventManager().prepareForFocus();
    }

    @Override
    public void prepareForExit() {
        super.prepareForExit();
        this.getEventManager().prepareForExit();
    }

    @Override
    public void performNextOnServer() {
        this.getEventManager().performNextOnServer();
    }

    @Override
    public void performPrevOnServer() {
        this.getEventManager().performPrevOnServer();
    }

    @Override
    public void performCommitOnServer(boolean bl) {
        this.getEventManager().performCommitOnServer(bl);
    }

    @Override
    public boolean performBrowserResize(int n, int n2) {
        this.getEventManager().performBrowserResize(n, n2);
        return true;
    }

    @Override
    public void performModify() {
        this.getEventManager().performModify();
    }

    @Override
    public void setPendingNavigationFocus() {
        this.getEventManager().setPendingNavigationFocus();
    }

    @Override
    public void checkNavigationFocus() {
        this.getEventManager().checkNavigationFocus();
    }

    @Override
    public void performNavigationFocus() {
        this.textBox.onNavigationFocus();
    }

    @Override
    public void handleFocus() {
        if (this.textBox.pendingMouseRightButton) {
            return;
        }
        if (!(this.isPopupShowing() || this.isPopupJustClosed() || this.getBooleanState(DropDownState.BooleanState.hasIcon))) {
            if (FMCUtilities.isMobile()) {
                this.textBox.blockTextInput(true);
            }
            this.requestInitialPage();
        }
        if (FMCUtilities.useAriaCompliantControl() && !this.isPopupShowing() && !this.isPopupJustClosed() && this.getBooleanState(DropDownState.BooleanState.hasIcon) && !this.textBox.isContentEditable() && FMCInputUtilities.getLastInteractionSource() == FMCInputUtilities.InteractionSource.KEYBOARD) {
            this.performTabFocus();
            if (this.textBox.getText() != null && this.textBox.getText().trim().length() > 0) {
                this.textBox.selectAll();
            }
        }
    }

    @Override
    public void handleBlur() {
        super.handleBlur();
        if (FMCUtilities.useAriaCompliantControl() && FMCInputUtilities.getLastInteractionSource() == FMCInputUtilities.InteractionSource.KEYBOARD) {
            if (this.textBox.getSelectedText().length() > 0) {
                this.textBox.clearSelection();
            }
            this.eventManager.updateActiveStyles(false);
        }
        if (FMCUtilities.isMobile()) {
            this.textBox.blockTextInput(true);
        }
    }

    @Override
    public boolean flushTextChangeOnScroll() {
        return this.getEventManager().flushTextChangeOnScroll();
    }

    @Override
    public void setPortalFocus() {
        this.attemptFocus();
    }

    @Override
    public void handleContextMenuOnServer(final int n, final int n2) {
        this.textBox.startContextMenuFocus();
        Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand(){
            final /* synthetic */ VCustomDropDown this$0;
            {
                this.this$0 = vCustomDropDown;
            }

            public void execute() {
                this.this$0.textBox.cacheContextMenuSelection();
                this.this$0.getEventManager().onShowContextMenu(n, n2, this.this$0.textBox.getContextMenuSelectionRange()[1]);
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
        this.getEventManager().exitField(false);
    }
}

