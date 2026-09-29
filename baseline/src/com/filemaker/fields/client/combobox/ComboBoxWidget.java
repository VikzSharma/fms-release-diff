/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.aria.client.Roles
 *  com.google.gwt.core.client.JavaScriptObject
 *  com.google.gwt.core.client.Scheduler
 *  com.google.gwt.core.client.Scheduler$ScheduledCommand
 *  com.google.gwt.dom.client.Element
 *  com.google.gwt.dom.client.Node
 *  com.google.gwt.event.dom.client.ClickEvent
 *  com.google.gwt.event.dom.client.KeyDownEvent
 *  com.google.gwt.event.dom.client.KeyDownHandler
 *  com.google.gwt.event.dom.client.MouseDownEvent
 *  com.google.gwt.event.logical.shared.CloseEvent
 *  com.google.gwt.user.client.DOM
 *  com.google.gwt.user.client.Element
 *  com.google.gwt.user.client.ui.Widget
 *  com.vaadin.client.BrowserInfo
 */
package com.filemaker.fields.client.combobox;

import com.filemaker.fields.client.combobox.ComboBoxItem;
import com.filemaker.fields.client.combobox.ComboBoxState;
import com.filemaker.fields.client.combobox.PageNavigationHandler;
import com.filemaker.fields.client.combobox.SelectionChangeHandler;
import com.filemaker.fields.client.combobox.SuggestionPopup;
import com.filemaker.fields.client.combobox.SuggestionProvider;
import com.filemaker.fields.client.combobox.UserInputChangeHandler;
import com.filemaker.fields.client.common.FMWidget;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.google.gwt.aria.client.Roles;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Node;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.BrowserInfo;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ComboBoxWidget
extends FMWidget {
    private static final String ICON_HIDDEN_STYLE = "icon-hidden";
    private com.google.gwt.user.client.Element arrow;
    private Element iconWrapper;
    private SuggestionPopup popup;
    private List<PageNavigationHandler> navigationHandlers = new LinkedList<PageNavigationHandler>();
    private List<SelectionChangeHandler> selectionHandlers = new LinkedList<SelectionChangeHandler>();
    private List<UserInputChangeHandler> inputChangeHandlers = new LinkedList<UserInputChangeHandler>();
    private ComboBoxItem selectedItem = null;
    private ComboBoxItem serverSelectedItem = null;
    private SuggestionProvider suggestionProvider;
    private boolean popupShownInEditSession = false;
    private boolean shouldUpdateSuggestionOnTextInput = true;
    private int cbbs = 0;

    public ComboBoxWidget() {
        this.iconWrapper = DOM.createDiv();
        this.iconWrapper.setClassName("icon-wrapper");
        this.innerBorder.appendChild((Node)this.iconWrapper);
        this.arrow = DOM.createDiv();
        this.arrow.setClassName("icon");
        this.iconWrapper.appendChild((Node)this.arrow);
        this.popup = new SuggestionPopup(this);
        this.addKeyHandlers();
        if (FMCUtilities.useAriaCompliantControl()) {
            com.google.gwt.user.client.Element element = this.popup.menu.getElement();
            if (element.getId() == null || element.getId().isEmpty()) {
                element.setId(DOM.createUniqueId());
            }
            element.setAttribute("role", "listbox");
            com.google.gwt.user.client.Element element2 = this.textBox.getElement();
            element2.setAttribute("role", "combobox");
            element2.setAttribute("aria-haspopup", "listbox");
            element2.setAttribute("aria-expanded", "false");
            element2.setAttribute("aria-controls", element.getId());
            this.popup.addCloseHandler(arg_0 -> this.lambda$new$0((Element)element2, arg_0));
        }
    }

    public void setCbbs(int n) {
        this.cbbs = n;
        Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand(){

            public void execute() {
                if (ComboBoxWidget.this.isArrowVisible()) {
                    ComboBoxWidget.this.removeStyleName(ComboBoxWidget.ICON_HIDDEN_STYLE);
                } else {
                    ComboBoxWidget.this.addStyleName(ComboBoxWidget.ICON_HIDDEN_STYLE);
                }
            }
        });
    }

    private boolean getBooleanState(ComboBoxState.BooleanState booleanState) {
        return FMCUtilities.getBooleanValue(this.cbbs, booleanState.ordinal());
    }

    @Override
    protected com.google.gwt.user.client.Element getContainerElement() {
        return (com.google.gwt.user.client.Element)this.innerBorder.cast();
    }

    public void showOptions(List<ComboBoxItem> list, int n, int n2, int n3, Set<Integer> set) {
        this.popup.showSuggestions(list, n, n2, n3, this.selectedItem, this.selectByFieldValue(), set);
        this.popupShownInEditSession = true;
    }

    public boolean isArrowVisible() {
        return this.getBooleanState(ComboBoxState.BooleanState.arrowVisible);
    }

    public void setSelectedItem(ComboBoxItem comboBoxItem) {
        this.setText(this.getSelectedItemText(comboBoxItem));
        if (this.hasFocus() && this.textBox.isContentEditable()) {
            this.textBox.moveCursorToEndOfText();
        }
        this.selectedItem = comboBoxItem;
    }

    public void setServerSelectedItem(ComboBoxItem comboBoxItem) {
        boolean bl = false;
        if (this.serverSelectedItem == null || !this.serverSelectedItem.equals(comboBoxItem)) {
            bl = true;
        }
        this.setServerText(this.getSelectedItemText(comboBoxItem));
        if (this.hasFocus() && this.textBox.isContentEditable() && bl) {
            this.textBox.moveCursorToEndOfText();
        }
        this.selectedItem = comboBoxItem;
        this.serverSelectedItem = comboBoxItem;
    }

    protected String getSelectedItemText(ComboBoxItem comboBoxItem) {
        if (comboBoxItem == null) {
            return "";
        }
        if (this.selectByFieldValue()) {
            return comboBoxItem.getFieldValue();
        }
        return comboBoxItem.getPopupPresentation();
    }

    public void setServerText(String string) {
        this.setText(string);
    }

    @Override
    public void syncServerValue() {
        this.setSelectedItem(this.serverSelectedItem);
    }

    public String getUserInput() {
        return this.getText();
    }

    public void hideOptions() {
        this.popup.setInitialPopup(true);
        this.popup.hide();
    }

    public void prevPageRequested() {
        this.popup.setInitialPopup(false);
        for (PageNavigationHandler pageNavigationHandler : this.navigationHandlers) {
            pageNavigationHandler.prevPageRequested();
        }
    }

    public void nextPageRequested() {
        this.popup.setInitialPopup(false);
        for (PageNavigationHandler pageNavigationHandler : this.navigationHandlers) {
            pageNavigationHandler.nextPageRequested();
        }
    }

    private void fireInitialPageRequested() {
        this.popup.setInitialPopup(true);
        for (PageNavigationHandler pageNavigationHandler : this.navigationHandlers) {
            pageNavigationHandler.initialPageRequested();
        }
        if (FMCUtilities.useAriaCompliantControl()) {
            this.setTextBoxAriaExpanded(true);
        }
    }

    public void addNavigationListener(PageNavigationHandler pageNavigationHandler) {
        this.navigationHandlers.add(pageNavigationHandler);
    }

    public void removeNavigationListener(PageNavigationHandler pageNavigationHandler) {
        this.navigationHandlers.remove(pageNavigationHandler);
    }

    public void setSuggestionProvider(SuggestionProvider suggestionProvider) {
        this.suggestionProvider = suggestionProvider;
    }

    protected boolean isPopupShowing() {
        return this.popup.isAttached();
    }

    protected boolean isPopupJustClosed() {
        return this.popup.isJustClosed();
    }

    protected boolean selectByFieldValue() {
        return false;
    }

    @Override
    protected void onTextInput() {
        super.onTextInput();
        if (this.shouldUpdateSuggestionOnTextInput) {
            this.suggest();
        }
    }

    private void addKeyHandlers() {
        this.textBox.addKeyDownHandler(new KeyDownHandler(){

            public void onKeyDown(KeyDownEvent keyDownEvent) {
                if (ComboBoxWidget.this.isPopupShowing()) {
                    this.handleKeyDownPopup(keyDownEvent);
                } else {
                    this.handleKeyDownInput(keyDownEvent);
                }
            }

            private void handleKeyDownInput(KeyDownEvent keyDownEvent) {
                if (keyDownEvent.getNativeKeyCode() == 40 && (FMCUtilities.useAriaCompliantControl() || ComboBoxWidget.this.getText().trim().length() == 0) || keyDownEvent.getNativeKeyCode() == 27) {
                    ComboBoxWidget.this.requestInitialPage();
                    keyDownEvent.preventDefault();
                }
            }

            private void handleKeyDownPopup(KeyDownEvent keyDownEvent) {
                if (keyDownEvent.getNativeKeyCode() == 8 || keyDownEvent.getNativeKeyCode() == 46) {
                    ComboBoxWidget.this.suggest();
                } else if (keyDownEvent.getNativeKeyCode() == 38) {
                    ComboBoxWidget.this.popup.moveToPreviousSuggestion();
                    keyDownEvent.preventDefault();
                } else if (keyDownEvent.getNativeKeyCode() == 40) {
                    ComboBoxWidget.this.popup.moveToNextSuggestion();
                    keyDownEvent.preventDefault();
                } else if (keyDownEvent.getNativeKeyCode() == 13) {
                    if (ComboBoxWidget.this.popup.isItemFocused()) {
                        ComboBoxWidget.this.popup.chooseFocused();
                    } else {
                        ComboBoxWidget.this.popup.hide();
                    }
                    keyDownEvent.preventDefault();
                    keyDownEvent.stopPropagation();
                } else if (keyDownEvent.getNativeKeyCode() == 27) {
                    ComboBoxWidget.this.hideOptions();
                    keyDownEvent.preventDefault();
                    keyDownEvent.stopPropagation();
                }
            }
        });
    }

    private void suggest() {
        if (this.isTextInputAllowed() && this.isEditable()) {
            Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand(){

                public void execute() {
                    if (ComboBoxWidget.this.suggestionProvider != null) {
                        String string = ComboBoxWidget.this.getText();
                        if (string.length() == 0) {
                            ComboBoxWidget.this.hideOptions();
                        }
                        ComboBoxWidget.this.popup.setInitialPopup(true);
                        ComboBoxWidget.this.suggestionProvider.provideSuggestions(string);
                    }
                }
            });
        }
    }

    public void addSelectionChangeHandler(SelectionChangeHandler selectionChangeHandler) {
        this.selectionHandlers.add(selectionChangeHandler);
    }

    public void removeSelectionChangeHandler(SelectionChangeHandler selectionChangeHandler) {
        this.selectionHandlers.remove(selectionChangeHandler);
    }

    public void fireSelectionChange(ComboBoxItem comboBoxItem) {
        for (SelectionChangeHandler selectionChangeHandler : this.selectionHandlers) {
            selectionChangeHandler.selectionChanged(comboBoxItem);
        }
    }

    public void addUserInputChangeHandler(UserInputChangeHandler userInputChangeHandler) {
        this.inputChangeHandlers.add(userInputChangeHandler);
    }

    public void removeUserInputChangeHandler(UserInputChangeHandler userInputChangeHandler) {
        this.inputChangeHandlers.remove(userInputChangeHandler);
    }

    public void fireUserInputChange() {
        for (UserInputChangeHandler userInputChangeHandler : this.inputChangeHandlers) {
            userInputChangeHandler.userInputChanged();
        }
    }

    public boolean hasUserInputChanged() {
        String string = this.getUserInput();
        boolean bl = true;
        if (this.selectedItem == null && string.length() == 0) {
            bl = false;
        } else if (this.selectedItem != null && this.selectedItem.getFieldValue().equals(string)) {
            bl = false;
        }
        return bl;
    }

    @Override
    public void setEditable(boolean bl) {
        super.setEditable(bl);
        if (!bl) {
            this.popupShownInEditSession = false;
        }
    }

    @Override
    protected void handleMouseDownEvent(MouseDownEvent mouseDownEvent) {
        Element element = (Element)Element.as((JavaScriptObject)mouseDownEvent.getNativeEvent().getEventTarget()).cast();
        if (this.isArrow(element)) {
            mouseDownEvent.preventDefault();
            mouseDownEvent.stopPropagation();
        } else {
            super.handleMouseDownEvent(mouseDownEvent);
        }
        if (this.isArrow(element) && this.hasFocus()) {
            this.textBox.getFocusBlurHandler().setEnabled(false);
        }
    }

    @Override
    protected void handleClickEvent(ClickEvent clickEvent) {
        Element element = (Element)Element.as((JavaScriptObject)clickEvent.getNativeEvent().getEventTarget()).cast();
        if (this.isArrow(element)) {
            clickEvent.preventDefault();
            clickEvent.stopPropagation();
        } else {
            super.handleClickEvent(clickEvent);
        }
        if (this.isArrow(element) && !this.hasFocus()) {
            this.setFocus(true);
        }
        this.textBox.getFocusBlurHandler().setEnabled(true);
        this.checkPopupStatus(element);
    }

    protected void checkPopupStatus(Element element) {
        if (this.shouldShowPopup(element)) {
            this.requestInitialPage();
        } else if (this.shouldHidePopup(element)) {
            this.popup.hide();
        }
    }

    protected boolean shouldShowPopup(Element element) {
        if (this.isPopupShowing() || this.popup.isJustClosed()) {
            return false;
        }
        if (this.isArrow(element)) {
            return true;
        }
        return this.isField(element) && (!this.isTextInputAllowed() || !this.isArrowVisible() && !this.popupShownInEditSession);
    }

    protected boolean shouldHidePopup(Element element) {
        return this.isPopupShowing() && this.isArrow(element);
    }

    private boolean isArrow(Element element) {
        return this.iconWrapper.isOrHasChild((Node)element);
    }

    private boolean isField(Element element) {
        return this.innerBorder.isOrHasChild((Node)element);
    }

    protected void requestInitialPage() {
        this.fireInitialPageRequested();
    }

    public void setStylePrimaryName(String string) {
        super.setStylePrimaryName(string);
        this.popup.updateStyleName();
    }

    @Override
    protected void onAttach() {
        super.onAttach();
        if (!this.isArrowVisible()) {
            this.addStyleName(ICON_HIDDEN_STYLE);
        }
    }

    @Override
    public void setEnabled(boolean bl) {
        super.setEnabled(bl);
        Roles.getButtonRole().setAriaDisabledState((Element)this.arrow, !bl);
    }

    public void setUpdateSuggestionOnTextInput(boolean bl) {
        this.shouldUpdateSuggestionOnTextInput = bl;
    }

    public void handleFocus() {
        this.textBox.getFocusBlurHandler().setEnabled(true);
    }

    public void handleBlur() {
        this.textBox.getFocusBlurHandler().setEnabled(true);
        if (BrowserInfo.get().isIE()) {
            this.textBox.clearSelection();
        }
    }

    public void syncAria(Widget widget) {
        com.google.gwt.user.client.Element element = widget.getElement();
        if (element.getId() == null || element.getId().isEmpty()) {
            element.setId(DOM.createUniqueId());
        }
        this.textBox.getElement().setAttribute("aria-activedescendant", element.getId());
    }

    protected void setTextBoxAriaExpanded(boolean bl) {
        this.textBox.getElement().setAttribute("aria-expanded", String.valueOf(bl));
    }

    private /* synthetic */ void lambda$new$0(Element element, CloseEvent closeEvent) {
        element.removeAttribute("aria-activedescendant");
        this.setTextBoxAriaExpanded(false);
    }
}

