/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.GWT
 *  com.google.gwt.core.client.JavaScriptObject
 *  com.google.gwt.core.client.Scheduler
 *  com.google.gwt.core.client.Scheduler$ScheduledCommand
 *  com.google.gwt.dom.client.Element
 *  com.google.gwt.dom.client.Node
 *  com.google.gwt.dom.client.Style$Unit
 *  com.google.gwt.event.dom.client.ClickEvent
 *  com.google.gwt.event.dom.client.ClickHandler
 *  com.google.gwt.event.dom.client.KeyDownEvent
 *  com.google.gwt.event.dom.client.KeyDownHandler
 *  com.google.gwt.event.dom.client.KeyPressEvent
 *  com.google.gwt.event.dom.client.KeyPressHandler
 *  com.google.gwt.event.dom.client.MouseDownEvent
 *  com.google.gwt.event.dom.client.MouseDownHandler
 *  com.google.gwt.event.shared.EventHandler
 *  com.google.gwt.user.client.DOM
 *  com.google.gwt.user.client.Element
 *  com.google.gwt.user.client.ui.HasEnabled
 *  com.google.gwt.user.client.ui.SimplePanel
 *  com.google.gwt.user.client.ui.Widget
 *  com.vaadin.client.BrowserInfo
 *  com.vaadin.client.Focusable
 */
package com.filemaker.fields.client.common;

import com.filemaker.fields.client.common.FMConnector;
import com.filemaker.fields.client.common.FMState;
import com.filemaker.fields.client.common.FocusMode;
import com.filemaker.fields.client.common.LineBreakBlockedListener;
import com.filemaker.fields.client.common.Padding;
import com.filemaker.fields.client.textbox.ContentEditableDivTextBox;
import com.filemaker.fields.client.textbox.EdgeContentEditableDivTextBox;
import com.filemaker.fields.client.textbox.FocusBlurHandler;
import com.filemaker.fields.client.textbox.IEContentEditableDivTextBox;
import com.filemaker.fields.client.textbox.MobileContentEditableDivTextBox;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Node;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.HasEnabled;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.BrowserInfo;
import com.vaadin.client.Focusable;
import java.util.LinkedList;

public class FMWidget
extends SimplePanel
implements HasEnabled,
Focusable {
    protected ContentEditableDivTextBox textBox;
    protected com.google.gwt.user.client.Element innerBorder;
    protected com.google.gwt.user.client.Element placeHolder;
    private boolean enabled = true;
    private boolean readOnly = false;
    private String inputPrompt = "";
    private boolean prompting = false;
    private boolean hideZeroesOn = false;
    private boolean editable = false;
    private static final String CLASSNAME_PROMPT = "prompt";
    private LinkedList<LineBreakBlockedListener> lineBreakBlockedListeners = new LinkedList();
    private int layoutTabIndex = -1;
    private FocusMode focusMode;
    private int fmbs = 0;

    public FMWidget() {
        this.innerBorder = DOM.createDiv();
        this.innerBorder.setClassName("inner_border");
        this.getElement().appendChild((Node)this.innerBorder);
        this.textBox = this.initTextBox();
        this.setWidget((Widget)this.textBox);
        this.placeHolder = DOM.createDiv();
        this.placeHolder.addClassName("placeholder");
        this.innerBorder.insertAfter((Node)this.placeHolder, (Node)this.textBox.getElement());
        this.addDomHandler((EventHandler)new ClickHandler(){

            public void onClick(ClickEvent clickEvent) {
                FMWidget.this.handleClickEvent(clickEvent);
            }
        }, ClickEvent.getType());
        this.addDomHandler((EventHandler)new MouseDownHandler(){

            public void onMouseDown(MouseDownEvent mouseDownEvent) {
                FMWidget.this.handleMouseDownEvent(mouseDownEvent);
            }
        }, MouseDownEvent.getType());
        this.addKeyHandlers();
    }

    protected ContentEditableDivTextBox initTextBox() {
        ContentEditableDivTextBox contentEditableDivTextBox = BrowserInfo.get().isIOS() || BrowserInfo.get().isAndroid() ? (ContentEditableDivTextBox)((Object)GWT.create(MobileContentEditableDivTextBox.class)) : (BrowserInfo.get().isIE() ? (ContentEditableDivTextBox)((Object)GWT.create(IEContentEditableDivTextBox.class)) : (BrowserInfo.get().isEdge() ? (ContentEditableDivTextBox)((Object)GWT.create(EdgeContentEditableDivTextBox.class)) : (ContentEditableDivTextBox)((Object)GWT.create(ContentEditableDivTextBox.class))));
        contentEditableDivTextBox.setText("");
        return contentEditableDivTextBox;
    }

    public void setFmbs(int n) {
        boolean bl = this.isWordwrap();
        this.fmbs = n;
        boolean bl2 = this.isWordwrap();
        if (bl != bl2) {
            Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand(){

                public void execute() {
                    if (FMWidget.this.isWordwrap()) {
                        FMWidget.this.removeStyleName("no-wrap");
                    } else {
                        FMWidget.this.addStyleName("no-wrap");
                    }
                }
            });
        }
    }

    private boolean getBooleanState(FMState.BooleanState booleanState) {
        return FMCUtilities.getBooleanValue(this.fmbs, booleanState.ordinal());
    }

    protected com.google.gwt.user.client.Element getContainerElement() {
        return this.innerBorder;
    }

    public void setInputPrompt(String string) {
        this.inputPrompt = string == null ? "" : string.replaceAll("\r", "\n").replaceAll("\n", "<br/>");
        this.placeHolder.setInnerHTML(this.inputPrompt);
        this.hidePrompt();
        this.showPrompt();
    }

    private boolean isPrompting() {
        return this.prompting;
    }

    public void setHideZeroesOn(boolean bl) {
        this.hideZeroesOn = bl;
        if (this.hideZeroesOn) {
            this.hidePrompt();
        } else {
            this.showPrompt();
        }
    }

    private void showPrompt() {
        if (!this.prompting && this.shouldShowPrompt()) {
            this.prompting = true;
            if (!this.inputPrompt.isEmpty()) {
                this.addStyleDependentName(CLASSNAME_PROMPT);
            }
        }
    }

    private void hidePrompt() {
        if (this.prompting) {
            this.prompting = false;
            this.removeStyleDependentName(CLASSNAME_PROMPT);
        }
    }

    private boolean shouldShowPrompt() {
        String string = this.textBox.getText();
        return string.isEmpty() || string == "\n";
    }

    public void setEnabled(boolean bl) {
        if (this.enabled != bl) {
            this.enabled = bl;
            this.maybeSetContentEditable();
            this.maybeSetFocusable();
        }
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setReadOnly(boolean bl) {
        if (this.readOnly != bl) {
            this.readOnly = bl;
            this.maybeSetContentEditable();
            this.maybeSetFocusable();
        }
    }

    public boolean isReadOnly() {
        return this.readOnly;
    }

    public void setFocusMode(FocusMode focusMode) {
        this.focusMode = focusMode;
    }

    public boolean isFocusMode(FocusMode focusMode) {
        return this.focusMode == focusMode;
    }

    public boolean isResetScrollPositionOnExit() {
        return this.getBooleanState(FMState.BooleanState.resetScrollPositionOnExit);
    }

    public void resetScrollPosition() {
        this.textBox.getElement().setScrollTop(0);
    }

    public boolean attemptFocus() {
        return this.focusMode == FocusMode.INSTANT;
    }

    public void prepareForFocus() {
    }

    public void performModify() {
    }

    public void setPendingNavigationFocus() {
    }

    public void checkNavigationFocus() {
    }

    public void performNavigationFocus() {
    }

    public void syncServerValue() {
    }

    public void resyncServerValue(String string) {
    }

    public void blockTabbing() {
    }

    public void unblockTabbing() {
    }

    public void setEditable(boolean bl) {
        this.editable = bl;
        if (bl) {
            this.addStyleName("edited");
        } else {
            if (!this.hideZeroesOn) {
                this.showPrompt();
            }
            this.removeStyleName("edited");
        }
        this.maybeSetContentEditable();
    }

    public boolean isEditable() {
        return this.editable;
    }

    private void maybeSetContentEditable() {
        this.maybeSetContentEditable(this.isSelectContentsOnEdit());
    }

    private void maybeSetContentEditable(boolean bl) {
        boolean bl2;
        boolean bl3 = bl2 = this.isEnabled() && !this.isReadOnly() && this.isEditable() && this.isTextInputAllowed();
        if (bl2 != this.textBox.isContentEditable()) {
            this.textBox.setContentEditable(bl2);
            if (bl2 && bl) {
                Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand(){

                    public void execute() {
                        FMWidget.this.selectAll();
                    }
                });
            }
        }
    }

    private void maybeSetFocusable() {
        boolean bl;
        boolean bl2 = bl = this.isEnabled() && !this.isReadOnly();
        if (!bl) {
            this.textBox.setTabIndex(-1);
        } else {
            this.textBox.setTabIndex(0);
        }
    }

    public boolean isNewLineAllowed() {
        return this.getBooleanState(FMState.BooleanState.newLineAllowed);
    }

    protected void onAttach() {
        super.onAttach();
        this.maybeSetFocusable();
        this.maybeSetContentEditable();
        if (!this.isWordwrap()) {
            this.getElement().addClassName("no-wrap");
        }
    }

    public void setSelectionRange(int n, int n2) {
        this.textBox.setSelectionRange(n, n2);
    }

    public void selectAll() {
        this.textBox.selectAll();
    }

    public void setFocus(boolean bl) {
        if (bl) {
            this.addStyleName("focused");
        }
        if (bl != this.hasFocus()) {
            this.textBox.setFocus(bl);
        }
    }

    public int[] getSelectionRange() {
        int[] nArray = this.textBox.getSelectionRange();
        return nArray;
    }

    public void addLineBreakBlockedListener(LineBreakBlockedListener lineBreakBlockedListener) {
        this.lineBreakBlockedListeners.add(lineBreakBlockedListener);
    }

    public void removeLineBreakBlockedListener(LineBreakBlockedListener lineBreakBlockedListener) {
        this.lineBreakBlockedListeners.remove(lineBreakBlockedListener);
    }

    private void fireLineBreakBlocked() {
        for (LineBreakBlockedListener lineBreakBlockedListener : this.lineBreakBlockedListeners) {
            lineBreakBlockedListener.lineBreakBlocked();
        }
    }

    public int getCursorPos() {
        return this.getSelectionRange()[0];
    }

    public void setCursorPos(int n) {
        this.setSelectionRange(n, 0);
    }

    public int getSelectionLength() {
        return this.getSelectionRange()[1];
    }

    public String getText() {
        return this.textBox.getText();
    }

    public void setText(String string) {
        this.hidePrompt();
        this.textBox.setText(string);
        if (this.shouldShowPrompt()) {
            this.showPrompt();
        }
    }

    public void safeSetText(String string) {
        boolean bl = this.textBox.getFocusBlurHandler().getEnabled();
        this.textBox.getFocusBlurHandler().setEnabled(false);
        this.setText(string);
        this.textBox.getFocusBlurHandler().setEnabled(bl);
    }

    public boolean isSelectContentsOnEdit() {
        return this.getBooleanState(FMState.BooleanState.selectContentsOnEdit);
    }

    protected void handleClickEvent(ClickEvent clickEvent) {
        com.google.gwt.user.client.Element element = (com.google.gwt.user.client.Element)com.google.gwt.user.client.Element.as((JavaScriptObject)clickEvent.getNativeEvent().getEventTarget()).cast();
        if (this.textBox.getTabIndex() > -1 && element == this.innerBorder) {
            this.textBox.moveCursorToEndOfText();
            this.textBox.onInnerBorderClick(clickEvent);
        }
    }

    protected void handleMouseDownEvent(MouseDownEvent mouseDownEvent) {
        com.google.gwt.user.client.Element element = (com.google.gwt.user.client.Element)com.google.gwt.user.client.Element.as((JavaScriptObject)mouseDownEvent.getNativeEvent().getEventTarget()).cast();
        if (this.textBox.getTabIndex() == -1) {
            return;
        }
        if (element == this.innerBorder && this.hasFocus()) {
            mouseDownEvent.preventDefault();
            mouseDownEvent.stopPropagation();
        }
    }

    public void startTabFocus() {
        this.textBox.startTabFocus();
        this.setFocus(true);
    }

    public boolean hasFocus() {
        return FMCUtilities.hasFocus((Element)this.textBox.getElement());
    }

    public void addTextBoxFocusHandler(FocusBlurHandler focusBlurHandler) {
        this.textBox.getFocusBlurHandler().addFocusBlurHandler(focusBlurHandler);
    }

    public void removeTextBoxFocusHandler(FocusBlurHandler focusBlurHandler) {
        this.textBox.getFocusBlurHandler().removeFocusBlurHandler(focusBlurHandler);
    }

    public void setFMConnector(FMConnector fMConnector) {
        this.textBox.setFMConnector(fMConnector);
    }

    public void setTextInputAllowed(boolean bl) {
        this.textBox.setTextInputAllowed(bl);
    }

    public boolean isTextInputAllowed() {
        return this.textBox.isTextInputAllowed();
    }

    public void setPadding(Padding padding) {
        this.applyPadding(padding, this.textBox.getElement());
        this.applyPadding(padding, this.placeHolder);
    }

    protected void applyPadding(Padding padding, com.google.gwt.user.client.Element element) {
        if (padding.top == null) {
            element.getStyle().clearPaddingTop();
        } else {
            element.getStyle().setPaddingTop((double)padding.top.intValue(), Style.Unit.PX);
        }
        if (padding.right == null) {
            element.getStyle().clearPaddingRight();
        } else {
            element.getStyle().setPaddingRight((double)padding.right.intValue(), Style.Unit.PX);
        }
        if (padding.bottom == null) {
            element.getStyle().clearPaddingBottom();
        } else {
            element.getStyle().setPaddingBottom((double)padding.bottom.intValue(), Style.Unit.PX);
        }
        if (padding.left == null) {
            element.getStyle().clearPaddingLeft();
        } else {
            element.getStyle().setPaddingLeft((double)padding.left.intValue(), Style.Unit.PX);
        }
    }

    protected void onTextInput() {
        if (this.shouldShowPrompt()) {
            this.showPrompt();
        } else {
            this.hidePrompt();
        }
    }

    private void deferredTextInput() {
        Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand(){

            public void execute() {
                FMWidget.this.onTextInput();
            }
        });
    }

    private void addKeyHandlers() {
        if (BrowserInfo.get().isIE()) {
            this.textBox.addKeyPressHandler(new KeyPressHandler(){

                public void onKeyPress(KeyPressEvent keyPressEvent) {
                    char c = keyPressEvent.getCharCode();
                    if (c > '\u001f') {
                        FMWidget.this.deferredTextInput();
                    }
                }
            });
            this.textBox.addKeyDownHandler(new KeyDownHandler(){

                public void onKeyDown(KeyDownEvent keyDownEvent) {
                    if (keyDownEvent.getNativeKeyCode() == 8 || keyDownEvent.getNativeKeyCode() == 46) {
                        FMWidget.this.deferredTextInput();
                    }
                }
            });
        } else {
            this.attachInputHandler((JavaScriptObject)this.textBox.getElement());
        }
        this.textBox.addKeyPressHandler(new KeyPressHandler(){

            public void onKeyPress(KeyPressEvent keyPressEvent) {
                if (keyPressEvent.getCharCode() == '\r' && !FMWidget.this.isNewLineAllowed()) {
                    keyPressEvent.preventDefault();
                    FMWidget.this.fireLineBreakBlocked();
                }
            }
        });
    }

    public boolean isWordwrap() {
        return this.getBooleanState(FMState.BooleanState.wordwrap);
    }

    private final native void attachInputHandler(JavaScriptObject var1);

    public void enableTabFocus(boolean bl) {
        if (bl) {
            if (this.layoutTabIndex != -1) {
                this.textBox.setTabIndex(this.layoutTabIndex);
            }
        } else {
            int n = this.textBox.getTabIndex();
            if (n != -1) {
                this.layoutTabIndex = n;
                this.textBox.setTabIndex(-1);
            }
        }
    }

    public void focus() {
    }

    public void setTouchKeyboardType(int n) {
        switch (n) {
            case 2: {
                this.textBox.getElement().setAttribute("inputmode", "text");
                break;
            }
            case 3: {
                this.textBox.getElement().setAttribute("inputmode", "url");
                break;
            }
            case 4: {
                this.textBox.getElement().setAttribute("inputmode", "email");
                break;
            }
            case 6: {
                this.textBox.getElement().setAttribute("inputmode", "numeric");
                break;
            }
        }
    }
}

