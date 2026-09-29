/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.JavaScriptObject
 *  com.google.gwt.dom.client.Element
 *  com.google.gwt.dom.client.Node
 *  com.google.gwt.dom.client.Style$Display
 *  com.google.gwt.dom.client.Style$Unit
 *  com.google.gwt.event.logical.shared.CloseEvent
 *  com.google.gwt.event.logical.shared.CloseHandler
 *  com.google.gwt.user.client.DOM
 *  com.google.gwt.user.client.Element
 *  com.google.gwt.user.client.Event
 *  com.google.gwt.user.client.Window
 *  com.google.gwt.user.client.ui.PopupPanel
 *  com.google.gwt.user.client.ui.PopupPanel$PositionCallback
 *  com.google.gwt.user.client.ui.Widget
 *  com.vaadin.client.BrowserInfo
 *  com.vaadin.client.WidgetUtil
 *  com.vaadin.client.ui.VOverlay
 */
package com.filemaker.fields.client.combobox;

import com.filemaker.fields.client.combobox.ComboBoxItem;
import com.filemaker.fields.client.combobox.ComboBoxWidget;
import com.filemaker.fields.client.combobox.SuggestionMenu;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Node;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.BrowserInfo;
import com.vaadin.client.WidgetUtil;
import com.vaadin.client.ui.VOverlay;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class SuggestionPopup
extends VOverlay
implements PopupPanel.PositionCallback,
CloseHandler<PopupPanel> {
    private static final int HORIZONTAL_MARGIN = 8;
    private static final int Z_INDEX = 30000;
    private static final long TOGGLE_CLOSE_THRESSHOLD_MS = BrowserInfo.get().isIOS() ? 600L : 200L;
    private static final int NUM_OF_MAX_ROWS = 12;
    private static final int ROW_HEIGHT_DESKTOP = 18;
    private static final int ROW_HEIGHT_MOBILE = 28;
    public final SuggestionMenu menu;
    private final Element up = DOM.createDiv();
    private final Element down = DOM.createDiv();
    private final Element status = DOM.createDiv();
    private boolean isPagingEnabled = true;
    private long lastAutoClosed;
    private int popupOuterPadding = -1;
    private ComboBoxWidget comboBox;
    private JavaScriptObject hideSuggestionOnScrollHandler = null;
    private boolean initialPopup = false;
    private boolean menuAtTop = false;

    public SuggestionPopup(ComboBoxWidget comboBoxWidget) {
        super(true, false);
        this.comboBox = comboBoxWidget;
        this.setOwner((Widget)comboBoxWidget);
        this.menu = new SuggestionMenu(this);
        this.setWidget((Widget)this.menu);
        this.getElement().getStyle().setZIndex(30000);
        com.google.gwt.user.client.Element element = this.getContainerElement();
        if (FMCUtilities.isMobile()) {
            this.up.setInnerHTML("<span>&nbsp;</span>");
            this.down.setInnerHTML("<span>&nbsp;</span>");
        } else {
            this.up.setInnerHTML("<span>\u25b2</span>");
            this.down.setInnerHTML("<span>\u25bc</span>");
        }
        DOM.sinkEvents((Element)this.up, (int)1);
        DOM.sinkEvents((Element)this.down, (int)1);
        element.insertFirst((Node)this.up);
        element.appendChild((Node)this.down);
        element.appendChild((Node)this.status);
        DOM.sinkEvents((Element)element, (int)4);
        this.addCloseHandler(this);
        this.updateStyleName();
        this.hideSuggestionOnScrollHandler = SuggestionPopup.initHideSuggestionOnScrollHandler(this);
    }

    public void updateStyleName() {
        this.setStyleName(this.getOwner().getStylePrimaryName() + "-suggestions");
        if (FMCUtilities.isMobile()) {
            this.addStyleName("fm-mobile");
        }
    }

    public void showSuggestions(List<ComboBoxItem> list, int n, int n2, int n3, ComboBoxItem comboBoxItem, boolean bl, Set<Integer> set) {
        this.menu.setSuggestions(list, comboBoxItem, bl, set);
        this.setPrevButtonActive(n > 0);
        this.setNextButtonActive(n3 > n + n2);
        this.setPopupPositionAndShow(this);
    }

    private void setNextButtonActive(boolean bl) {
        if (bl) {
            DOM.sinkEvents((Element)this.down, (int)1);
            this.down.setClassName("nextpage");
        } else {
            DOM.sinkEvents((Element)this.down, (int)0);
            this.down.setClassName("nextpage-off");
        }
    }

    private void setPrevButtonActive(boolean bl) {
        if (bl) {
            DOM.sinkEvents((Element)this.up, (int)1);
            this.up.setClassName("prevpage");
        } else {
            DOM.sinkEvents((Element)this.up, (int)0);
            this.up.setClassName("prevpage-off");
        }
    }

    public void onBrowserEvent(Event event) {
        if (event.getTypeInt() == 1) {
            com.google.gwt.user.client.Element element = DOM.eventGetTarget((Event)event);
            if (element == this.up || element == DOM.getChild((Element)this.up, (int)0)) {
                this.scrollUp();
            } else if (element == this.down || element == DOM.getChild((Element)this.down, (int)0)) {
                this.scrollDown();
            }
        } else if (event.getTypeInt() == 4) {
            event.preventDefault();
        }
    }

    void scrollUp() {
        this.comboBox.prevPageRequested();
    }

    void scrollDown() {
        this.comboBox.nextPageRequested();
    }

    public void setPagingEnabled(boolean bl) {
        if (this.isPagingEnabled == bl) {
            return;
        }
        if (bl) {
            this.down.getStyle().clearDisplay();
            this.up.getStyle().clearDisplay();
            this.status.getStyle().clearDisplay();
        } else {
            this.down.getStyle().setDisplay(Style.Display.NONE);
            this.up.getStyle().setDisplay(Style.Display.NONE);
            this.status.getStyle().setDisplay(Style.Display.NONE);
        }
        this.isPagingEnabled = bl;
    }

    public void setPosition(int n, int n2) {
        int n3;
        int n4;
        this.menu.setHeight("");
        String string = "";
        if (BrowserInfo.get().isIE()) {
            string = this.menu.getElement().getParentElement().getStyle().getWidth();
            this.menu.getElement().getParentElement().getStyle().clearWidth();
        }
        this.menu.setWidth("");
        Element element = (Element)this.menu.getElement().getFirstChildElement().cast();
        int n5 = this.menu.getOffsetWidth();
        if (element != null) {
            n5 = element.getOffsetWidth();
        }
        if (BrowserInfo.get().isIE()) {
            this.menu.getElement().getParentElement().getStyle().setProperty("width", string);
        }
        if (this.popupOuterPadding == -1) {
            this.popupOuterPadding = WidgetUtil.measureHorizontalPaddingAndBorder((Element)this.getElement(), (int)2);
        }
        if (n5 < (n4 = this.getOwner().getOffsetWidth())) {
            this.menu.setWidth(n4 - this.popupOuterPadding + "px");
            n5 = n4;
        }
        if (BrowserInfo.get().isIE()) {
            n3 = n5 - this.popupOuterPadding;
            this.getContainerElement().getStyle().setWidth((double)n3, Style.Unit.PX);
        }
        n3 = Window.getClientWidth() + Window.getScrollLeft();
        int n6 = Window.getClientHeight() + Window.getScrollTop();
        int n7 = Math.max(this.getOffsetWidth(), n5);
        int n8 = this.getOffsetHeight();
        int n9 = this.getMaxHeight();
        int n10 = this.getOwner().getElement().getAbsoluteLeft();
        int n11 = n10 + n7;
        int n12 = this.getOwner().getElement().getAbsoluteTop();
        int n13 = this.getOwner().getElement().getAbsoluteBottom();
        int n14 = n10;
        int n15 = n13 + 1;
        if (n11 > n3) {
            n14 = n3 - n7 - this.popupOuterPadding / 2;
        } else if (n14 < 1) {
            n14 = 1;
        }
        if (this.initialPopup) {
            this.menuAtTop = n13 + n9 > n6;
            this.initialPopup = false;
        }
        if (this.menuAtTop && (n15 = n12 - n8 - 1) < 1) {
            n15 = 1;
        }
        if (FMCUtilities.isMobile()) {
            n7 = this.menu.getOffsetWidth();
            if (n7 > n3 - 16) {
                n7 = n3 - 16;
                this.menu.setWidth(n7 + "px");
            }
            if (n14 - 8 < 0) {
                n14 = 8;
            } else if (n14 + n7 + 8 > n3) {
                n14 = n3 - 8 - n7;
            }
        }
        this.setPopupPosition(n14, n15);
    }

    private int getMaxHeight() {
        return 12 * (FMCUtilities.isMobile() ? 28 : 18);
    }

    public void setInitialPopup(boolean bl) {
        this.initialPopup = bl;
    }

    public boolean isJustClosed() {
        long l = new Date().getTime();
        return this.lastAutoClosed > 0L && l - this.lastAutoClosed < TOGGLE_CLOSE_THRESSHOLD_MS;
    }

    public void onClose(CloseEvent<PopupPanel> closeEvent) {
        FMCUtilities.enableTouchScroll(true);
        if (closeEvent.isAutoClosed()) {
            this.lastAutoClosed = new Date().getTime();
        }
    }

    public void fireSelectionChange(ComboBoxItem comboBoxItem) {
        this.comboBox.fireSelectionChange(comboBoxItem);
    }

    public void moveToPreviousSuggestion() {
        this.menu.moveToPreviousSuggestion();
    }

    public void moveToNextSuggestion() {
        this.menu.moveToNextSuggestion();
    }

    public void chooseFocused() {
        this.menu.chooseFocused();
    }

    public boolean isItemFocused() {
        return this.menu.isItemFocused();
    }

    public void syncAria(Widget widget) {
        this.comboBox.syncAria(widget);
    }

    public void show() {
        FMCUtilities.enableTouchScroll(false);
        super.show();
        SuggestionPopup.setHideSuggestionOnScroll(this.hideSuggestionOnScrollHandler, true);
    }

    public void hide() {
        super.hide();
        SuggestionPopup.setHideSuggestionOnScroll(this.hideSuggestionOnScrollHandler, false);
    }

    private static native JavaScriptObject initHideSuggestionOnScrollHandler(SuggestionPopup var0);

    private static native void setHideSuggestionOnScroll(JavaScriptObject var0, boolean var1);
}

