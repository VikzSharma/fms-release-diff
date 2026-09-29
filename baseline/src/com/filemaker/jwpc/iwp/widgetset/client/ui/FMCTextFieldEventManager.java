/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.JavaScriptObject
 *  com.google.gwt.core.client.Scheduler
 *  com.google.gwt.core.client.Scheduler$ScheduledCommand
 *  com.google.gwt.dom.client.Element
 *  com.google.gwt.event.dom.client.BlurEvent
 *  com.google.gwt.user.client.DOM
 *  com.google.gwt.user.client.Element
 *  com.google.gwt.user.client.Event
 *  com.google.gwt.user.client.ui.Widget
 *  com.vaadin.client.BrowserInfo
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.jwpc.iwp.widgetset.client.rpc.TextFieldServerRpc;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCFieldEventManager;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCFocusableFieldEventManager;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCTextField;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.BrowserInfo;

public class FMCTextFieldEventManager
extends FMCFocusableFieldEventManager {
    protected FMCTextField field;
    protected boolean hasModifyTrigger = false;
    protected TextFieldServerRpc rpc;
    protected boolean isActive = false;
    protected boolean firstTextChangeOnFocus = true;
    protected String lastServerKnownText = "";
    protected boolean compositionStarted = false;
    protected boolean isCalcOrSummary = false;
    protected int scheduledTextChangeCount = 0;
    private boolean hasScript = false;
    private String textOnCompositionStart;

    public FMCTextFieldEventManager(Element element, FMCTextField fMCTextField) {
        super(element, fMCTextField);
        this.field = fMCTextField;
        if (BrowserInfo.get().isIE()) {
            DOM.sinkEvents((com.google.gwt.dom.client.Element)element, (int)(DOM.getEventsSunk((com.google.gwt.dom.client.Element)element) | 0x80000 | 0x100));
            this.attachFMCutEventListener(element);
        } else {
            DOM.sinkEvents((com.google.gwt.dom.client.Element)element, (int)(DOM.getEventsSunk((com.google.gwt.dom.client.Element)element) | 0x80000 | 4));
            this.attachInputHandler((JavaScriptObject)element);
        }
        this.attachIMEHandlers((JavaScriptObject)element);
    }

    protected native void attachFMCutEventListener(Element var1);

    protected native void attachInputHandler(JavaScriptObject var1);

    protected final native void attachIMEHandlers(JavaScriptObject var1);

    protected void onCompositionStart() {
        this.compositionStarted = true;
        this.textOnCompositionStart = this.field.getText();
    }

    protected void onCompositionEnd() {
        this.compositionStarted = false;
        if (this.firstTextChangeOnFocus && !this.textOnCompositionStart.equals(this.field.getText())) {
            this.scheduleTextChange();
        }
    }

    public void registerTextFieldServerRpc(TextFieldServerRpc textFieldServerRpc) {
        this.rpc = textFieldServerRpc;
    }

    public void updateState(boolean bl, boolean bl2, boolean bl3) {
        this.hasScript = bl;
        this.hasModifyTrigger = bl2;
        this.isCalcOrSummary = bl3;
    }

    @Override
    protected void handleEvent(Event event, Widget widget) {
        super.handleEvent(event, widget);
        switch (DOM.eventGetType((Event)event)) {
            case 256: {
                if (!BrowserInfo.get().isIE()) break;
                this.scheduleTextChange();
                break;
            }
            case 524288: {
                if (BrowserInfo.get().isIE()) {
                    this.schedulePaste();
                    break;
                }
                this.scheduleTextChange();
                break;
            }
        }
    }

    @Override
    protected boolean handleKeyDown(Event event) {
        boolean bl = false;
        switch (event.getKeyCode()) {
            case 8: 
            case 12: 
            case 46: {
                if (!BrowserInfo.get().isIE() && !BrowserInfo.get().isEdge()) break;
                if (this.field.getText().length() == 0) {
                    DOM.eventPreventDefault((Event)DOM.eventGetCurrentEvent());
                    event.stopPropagation();
                    bl = true;
                }
                if (bl) break;
                this.scheduleTextChange();
                bl = true;
                break;
            }
            case 229: {
                if (!BrowserInfo.get().isIE()) break;
                this.scheduleTextChange();
                bl = true;
                break;
            }
            case 13: {
                if (!BrowserInfo.get().isEdge() || super.handleEnterKeyDown(event)) break;
                this.scheduleTextChange();
                bl = true;
                break;
            }
        }
        if (!bl) {
            bl = super.handleKeyDown(event);
        }
        return bl;
    }

    @Override
    protected boolean handleTabKeyDown(Event event) {
        if (!FMCUtilities.useAriaCompliantControl()) {
            if (!super.handleTabKeyDown(event)) {
                DOM.eventPreventDefault((Event)DOM.eventGetCurrentEvent());
                event.stopPropagation();
                this.handleTabInsertion();
            }
            return true;
        }
        return super.handleTabKeyDown(event);
    }

    protected synchronized void handleTabInsertion() {
        StringBuilder stringBuilder = new StringBuilder(this.field.getText());
        int n = this.field.getCursorPos();
        int n2 = this.field.getSelectionLength();
        stringBuilder.delete(n, n + n2);
        stringBuilder.insert(n, "\t");
        this.field.setText(stringBuilder.toString());
        this.field.setCursorPos(n + 1);
        this.scheduleTextChange();
    }

    @Override
    protected boolean handleEnterKeyDown(Event event) {
        if (!super.handleEnterKeyDown(event) && this.fieldObject.getState().isNumberField) {
            DOM.eventPreventDefault((Event)DOM.eventGetCurrentEvent());
            event.stopPropagation();
        }
        return true;
    }

    private void scheduleTextChange() {
        if (this.firstTextChangeOnFocus || this.hasModifyTrigger) {
            Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand(){

                public void execute() {
                    FMCTextFieldEventManager.this.onTextChange();
                    --FMCTextFieldEventManager.this.scheduledTextChangeCount;
                }
            });
            ++this.scheduledTextChangeCount;
        }
    }

    private void schedulePaste() {
        if (this.firstTextChangeOnFocus || this.hasModifyTrigger) {
            Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand(){

                public void execute() {
                    FMCTextFieldEventManager.this.onPaste(FMCTextFieldEventManager.this.field.getText());
                    --FMCTextFieldEventManager.this.scheduledTextChangeCount;
                }
            });
            ++this.scheduledTextChangeCount;
        }
    }

    protected void onTextChange() {
        if (BrowserInfo.get().isIOS() && !FMCUtilities.isFindMode() && this.isCalcOrSummary) {
            this.onTextUndo();
        } else if (this.isActive && !this.compositionStarted && (this.hasModifyTrigger || this.firstTextChangeOnFocus && !this.field.getText().equals(this.lastServerKnownText))) {
            this.rpc.onTextChange(this.field.getText(), false);
            this.firstTextChangeOnFocus = false;
            this.field.storeCurrentCursorPosition();
        }
    }

    private void onPaste(String string) {
        if (BrowserInfo.get().isIOS() && this.isCalcOrSummary) {
            this.onTextUndo();
        } else if (this.isActive && !this.compositionStarted && (this.hasModifyTrigger || this.firstTextChangeOnFocus && !string.equals(this.lastServerKnownText))) {
            this.rpc.onTextChange(string, false);
            this.firstTextChangeOnFocus = false;
            this.field.storeCurrentCursorPosition();
        }
    }

    protected void setLastServerKnownText(String string) {
        this.lastServerKnownText = string;
        this.firstTextChangeOnFocus = true;
    }

    protected String getLastServerKnownText() {
        return this.lastServerKnownText;
    }

    protected void onTextUndo() {
        int n = this.field.getCursorPos() - this.field.getText().length() + this.lastServerKnownText.length();
        if (n < 0) {
            n = 0;
        } else if (n > this.lastServerKnownText.length()) {
            n = this.lastServerKnownText.length();
        }
        this.field.setText(this.lastServerKnownText);
        this.field.setCursorPos(n);
    }

    protected boolean attemptFocus() {
        boolean bl = false;
        boolean bl2 = false;
        if (!this.isActive) {
            if (!this.hasScript) {
                bl2 = true;
                boolean bl3 = bl = !this.field.getState().waitForServerOnEnter;
            }
            if (!(bl || FMCUtilities.isMobile() || BrowserInfo.get().isIE())) {
                this.field.setFocus(false);
            }
            if (bl2) {
                this.rpc.enterField();
            }
        } else {
            bl = true;
        }
        return bl;
    }

    protected void onBlur(BlurEvent blurEvent) {
        if (this.compositionStarted) {
            this.onCompositionEnd();
        }
        this.commitTextChangeOnExit();
    }

    private void commitTextChangeOnExit() {
        boolean bl = false;
        if (!this.firstTextChangeOnFocus || this.scheduledTextChangeCount > 0) {
            bl = true;
        } else if (BrowserInfo.get().isIOS()) {
            if (this.compositionStarted && !this.field.getText().equals(this.lastServerKnownText)) {
                bl = true;
            }
        } else if (BrowserInfo.get().isEdge() && !this.field.getText().equals(this.lastServerKnownText)) {
            bl = true;
        }
        if (bl) {
            this.rpc.onTextChange(this.field.getText(), true);
        }
    }

    @Override
    protected void removeActiveState() {
        if (this.isActive) {
            super.removeActiveState();
            this.firstTextChangeOnFocus = true;
            this.isActive = false;
            this.scheduledTextChangeCount = 0;
            this.field.setEditable(false);
        }
    }

    @Override
    protected void exitField(boolean bl) {
        if (!this.fieldObject.getState().waitForServerOnExit) {
            this.field.setEditable(false);
            this.commitTextChangeOnExit();
        }
        super.exitField(bl);
    }

    protected void performTabFocus() {
        this.rpc.enterField();
        if (!FMCUtilities.getCanHandleTabKeyDown()) {
            this.field.setCursorPos(this.field.getText().length());
        }
        this.field.startTabFocus();
    }

    protected void prepareForFocus() {
        if (!this.isActive) {
            this.isActive = true;
            this.lastServerKnownText = this.field.getText();
            this.firstTextChangeOnFocus = true;
            this.updateActiveStyles(true);
            this.scheduledTextChangeCount = 0;
        }
    }

    protected void prepareForExit() {
        if (this.isActive) {
            this.updateActiveStyles(false);
            this.firstTextChangeOnFocus = true;
            this.isActive = false;
            this.scheduledTextChangeCount = 0;
        }
    }

    protected void performNextOnServer() {
        this.rpc.onTabPress(true, this.field.getText());
    }

    protected void performPrevOnServer() {
        this.rpc.onTabPress(false, this.field.getText());
    }

    protected void performCommitOnServer(boolean bl) {
        this.rpc.onEnterPress(bl, this.field.getText());
    }

    protected void performOnKeyDownOnServer(String string, int n, boolean bl) {
        this.rpc.onKeystroke(this.field.getText(), n, bl);
        this.field.storeCurrentCursorPosition();
    }

    protected boolean performBrowserResize(int n, int n2) {
        this.rpc.onBrowserResize(n, n2, this.field.getText());
        return true;
    }

    protected void performModify() {
        this.field.setCursorPos(this.field.getText().length());
    }

    protected void setPendingNavigationFocus() {
        this.rpc.setPendingNavigationFocus();
    }

    protected void checkNavigationFocus() {
        this.rpc.checkNavigationFocus();
    }

    public boolean flushTextChangeOnScroll() {
        String string = this.field.getText();
        if (string != null && !string.equals(this.lastServerKnownText)) {
            this.rpc.onTextChange(string, false);
            this.lastServerKnownText = string;
            return true;
        }
        return false;
    }

    @Override
    protected void handleContextMenu(Event event) {
        FMCTextField fMCTextField = FMCFieldEventManager.getCommunicationConnector().getActiveTextField();
        if (fMCTextField != null && !fMCTextField.getElement().equals((Object)this.field.getElement())) {
            fMCTextField.exitField();
        }
        super.handleContextMenu(event);
    }

    public void onShowContextMenu(int n, int n2, int n3) {
        if (!this.hasScript) {
            this.rpc.onShowContextMenu(n, n2, n3);
        }
    }
}

