/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.dom.client.Element
 *  com.google.gwt.event.dom.client.MouseDownEvent
 *  com.google.gwt.event.dom.client.MouseDownHandler
 *  com.google.gwt.event.dom.client.MouseOverEvent
 *  com.google.gwt.event.dom.client.MouseOverHandler
 *  com.google.gwt.event.dom.client.MouseUpEvent
 *  com.google.gwt.event.dom.client.MouseUpHandler
 *  com.google.gwt.event.dom.client.MouseWheelEvent
 *  com.google.gwt.event.dom.client.MouseWheelHandler
 *  com.google.gwt.event.shared.EventHandler
 *  com.google.gwt.event.shared.GwtEvent$Type
 *  com.google.gwt.safehtml.shared.SafeHtmlUtils
 *  com.google.gwt.user.client.DOM
 *  com.google.gwt.user.client.ui.FlowPanel
 *  com.google.gwt.user.client.ui.HTML
 *  com.google.gwt.user.client.ui.Label
 *  com.google.gwt.user.client.ui.Widget
 */
package com.filemaker.fields.client.combobox;

import com.filemaker.fields.client.combobox.ComboBoxItem;
import com.filemaker.fields.client.combobox.SuggestionPopup;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.event.dom.client.MouseWheelEvent;
import com.google.gwt.event.dom.client.MouseWheelHandler;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import java.util.List;
import java.util.Set;

public class SuggestionMenu
extends FlowPanel
implements MouseDownHandler,
MouseUpHandler {
    private SuggestionPopup popup;
    private int focusedIndex = -1;
    private Widget focusedItem;
    protected final MouseWheelHandler mouseWheelHandler = new MouseWheelHandler(){

        public void onMouseWheel(MouseWheelEvent mouseWheelEvent) {
            if (mouseWheelEvent.getDeltaY() < 0) {
                mouseWheelEvent.preventDefault();
                mouseWheelEvent.stopPropagation();
                SuggestionMenu.this.popup.scrollUp();
            } else if (mouseWheelEvent.getDeltaY() > 0) {
                mouseWheelEvent.preventDefault();
                mouseWheelEvent.stopPropagation();
                SuggestionMenu.this.popup.scrollDown();
            }
        }
    };

    public SuggestionMenu(SuggestionPopup suggestionPopup) {
        this.popup = suggestionPopup;
        this.addStyleName("suggestion_menu");
        DOM.sinkEvents((Element)this.getElement(), (int)131072);
        this.addHandler((EventHandler)this.mouseWheelHandler, (GwtEvent.Type)MouseWheelEvent.getType());
    }

    public void setSuggestions(List<ComboBoxItem> list, ComboBoxItem comboBoxItem, boolean bl, Set<Integer> set) {
        this.clear();
        this.focusedItem = null;
        this.focusedIndex = -1;
        boolean bl2 = false;
        for (int i = 0; i < list.size(); ++i) {
            ComboBoxItem comboBoxItem2 = list.get(i);
            HTML hTML = new HTML(this.createPopupPresentation(comboBoxItem2));
            hTML.setStyleName("menu_option");
            if (FMCUtilities.useAriaCompliantControl()) {
                hTML.getElement().setAttribute("role", "option");
                hTML.addDomHandler((EventHandler)((MouseOverHandler)mouseOverEvent -> this.popup.syncAria(hTML.asWidget())), MouseOverEvent.getType());
            }
            if (!bl2) {
                boolean bl3 = false;
                if (bl && SuggestionMenu.trimTrailingNewline(comboBoxItem.getFieldValue()).equalsIgnoreCase(comboBoxItem2.getFieldValue())) {
                    bl3 = true;
                } else if (!bl && SuggestionMenu.trimTrailingNewline(comboBoxItem.getPopupPresentation()).equalsIgnoreCase(comboBoxItem2.getPopupPresentation())) {
                    bl3 = true;
                }
                if (bl3) {
                    hTML.addStyleName("selected");
                    bl2 = true;
                }
            }
            hTML.setLayoutData((Object)comboBoxItem2);
            hTML.addMouseDownHandler((MouseDownHandler)this);
            hTML.addMouseUpHandler((MouseUpHandler)this);
            if (set != null) {
                if (set.contains(i)) {
                    hTML.addStyleName("separator-after");
                }
                if (i == 0 && set.contains(-1)) {
                    hTML.addStyleName("separator-before");
                }
            }
            this.add((Widget)hTML);
        }
    }

    protected static String trimTrailingNewline(String string) {
        if (string != null && string.endsWith("\n")) {
            return string.substring(0, string.length() - 1);
        }
        return string;
    }

    private String createPopupPresentation(ComboBoxItem comboBoxItem) {
        String string = comboBoxItem.getPopupPresentation();
        StringBuilder stringBuilder = new StringBuilder();
        if (string != null) {
            for (String string2 : string.replaceAll("\r", "\n").split("\n")) {
                if (stringBuilder.length() > 0 && string2.length() > 0) {
                    stringBuilder.append("<br/>");
                }
                stringBuilder.append(SafeHtmlUtils.htmlEscape((String)string2));
            }
        }
        if (stringBuilder.length() == 0) {
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    private void fireSelectionChange(ComboBoxItem comboBoxItem) {
        this.popup.fireSelectionChange(comboBoxItem);
    }

    public void moveToPreviousSuggestion() {
        if (this.focusedIndex > 0) {
            --this.focusedIndex;
        } else {
            this.popup.scrollUp();
        }
        this.highlightFocused();
    }

    public void moveToNextSuggestion() {
        if (this.focusedIndex + 1 < this.getWidgetCount()) {
            ++this.focusedIndex;
        } else {
            this.popup.scrollDown();
        }
        this.highlightFocused();
    }

    public void chooseFocused() {
        if (this.focusedItem != null) {
            ComboBoxItem comboBoxItem = (ComboBoxItem)this.focusedItem.getLayoutData();
            this.fireSelectionChange(comboBoxItem);
        }
    }

    private void highlightFocused() {
        if (this.focusedItem != null) {
            this.focusedItem.removeStyleName("focus");
        }
        if (this.focusedIndex >= 0) {
            this.focusedItem = this.getWidget(this.focusedIndex);
            this.focusedItem.addStyleName("focus");
            if (FMCUtilities.useAriaCompliantControl()) {
                this.popup.syncAria(this.focusedItem);
            }
        }
    }

    public void onMouseDown(MouseDownEvent mouseDownEvent) {
        mouseDownEvent.preventDefault();
    }

    public void onMouseUp(MouseUpEvent mouseUpEvent) {
        Label label = (Label)mouseUpEvent.getSource();
        ComboBoxItem comboBoxItem = (ComboBoxItem)label.getLayoutData();
        this.fireSelectionChange(comboBoxItem);
    }

    public boolean isItemFocused() {
        return this.focusedItem != null;
    }
}

