/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.aria.client.LiveValue
 *  com.google.gwt.aria.client.Roles
 *  com.google.gwt.core.client.GWT
 *  com.google.gwt.core.client.JavaScriptObject
 *  com.google.gwt.core.client.Scheduler
 *  com.google.gwt.core.client.Scheduler$ScheduledCommand
 *  com.google.gwt.dom.client.Element
 *  com.google.gwt.dom.client.Node
 *  com.google.gwt.dom.client.Style$Display
 *  com.google.gwt.event.dom.client.ClickEvent
 *  com.google.gwt.event.dom.client.DomEvent
 *  com.google.gwt.event.dom.client.KeyDownEvent
 *  com.google.gwt.event.dom.client.KeyDownHandler
 *  com.google.gwt.event.dom.client.KeyPressEvent
 *  com.google.gwt.event.dom.client.KeyPressHandler
 *  com.google.gwt.event.dom.client.MouseDownEvent
 *  com.google.gwt.event.logical.shared.CloseEvent
 *  com.google.gwt.event.logical.shared.CloseHandler
 *  com.google.gwt.user.client.DOM
 *  com.google.gwt.user.client.Element
 *  com.google.gwt.user.client.Timer
 *  com.google.gwt.user.client.Window
 *  com.google.gwt.user.client.ui.FlowPanel
 *  com.google.gwt.user.client.ui.Label
 *  com.google.gwt.user.client.ui.PopupPanel
 *  com.google.gwt.user.client.ui.PopupPanel$PositionCallback
 *  com.google.gwt.user.client.ui.Widget
 *  com.vaadin.client.BrowserInfo
 *  com.vaadin.client.DateTimeService
 *  com.vaadin.client.LocaleNotLoadedException
 *  com.vaadin.client.ui.VOverlay
 *  com.vaadin.client.ui.aria.AriaHelper
 *  com.vaadin.v7.shared.ui.datefield.Resolution
 */
package com.filemaker.fields.client.datefield;

import com.filemaker.fields.client.common.FMWidget;
import com.filemaker.fields.client.datefield.PopupCalendarPanel;
import com.filemaker.fields.client.datefield.PopupDateFieldState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.google.gwt.aria.client.LiveValue;
import com.google.gwt.aria.client.Roles;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Node;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.DomEvent;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.BrowserInfo;
import com.vaadin.client.DateTimeService;
import com.vaadin.client.LocaleNotLoadedException;
import com.vaadin.client.ui.VOverlay;
import com.vaadin.client.ui.aria.AriaHelper;
import com.vaadin.v7.shared.ui.datefield.Resolution;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PopupDateFieldWidget
extends FMWidget
implements CloseHandler<PopupPanel> {
    private static final String ICON_HIDDEN_STYLE = "icon-hidden";
    public DateTimeService dts = new DateTimeService();
    protected PopupCalendarPanel calendar;
    protected Label selectedDate;
    protected String currentLocale;
    protected boolean calendarIconShown = true;
    private Element icon;
    private Element iconWrapper;
    private List<PopupDateFieldListener> listeners = new ArrayList<PopupDateFieldListener>();
    private boolean open = false;
    private final VOverlay popup;
    private JavaScriptObject hideCalendarOnScrollHandler = null;
    private int pdbs = 0;
    protected long popupClosedTime = 0L;
    private boolean popupShownInEditSession;
    public static final long TOGGLE_CLOSE_THRESSHOLD_MS = BrowserInfo.get().isIOS() ? 600L : 200L;
    protected final PopupCalendarPanel.SubmitListener submitListener = new PopupCalendarPanel.SubmitListener(){

        @Override
        public void onSubmit() {
            for (PopupDateFieldListener popupDateFieldListener : PopupDateFieldWidget.this.listeners) {
                popupDateFieldListener.onDateSelected(PopupDateFieldWidget.this.calendar.getDate());
            }
            PopupDateFieldWidget.this.closeCalendarPanel();
        }

        @Override
        public void onCancel() {
            PopupDateFieldWidget.this.closeCalendarPanel();
        }
    };

    public PopupDateFieldWidget() {
        this.iconWrapper = DOM.createDiv();
        this.iconWrapper.setClassName("icon-wrapper");
        this.innerBorder.appendChild((Node)this.iconWrapper);
        this.icon = DOM.createDiv();
        this.icon.setClassName("icon");
        this.iconWrapper.appendChild((Node)this.icon);
        this.calendar = (PopupCalendarPanel)((Object)GWT.create(PopupCalendarPanel.class));
        this.calendar.setParentField(this);
        this.calendar.setDateTimeService(this.dts);
        this.calendar.setFocusOutListener(new PopupCalendarPanel.FocusOutListener(this){

            @Override
            public boolean onFocusOut(DomEvent<?> domEvent) {
                domEvent.preventDefault();
                return true;
            }
        });
        this.calendar.setSubmitListener(this.submitListener);
        this.popup = new VOverlay(true, false);
        this.popup.addStyleName("v-datefield-popup");
        this.popup.setOwner((Widget)this);
        FlowPanel flowPanel = new FlowPanel();
        this.selectedDate = new Label();
        this.selectedDate.setStyleName(this.getStylePrimaryName() + "-selecteddate");
        AriaHelper.setVisibleForAssistiveDevicesOnly((Element)this.selectedDate.getElement(), (boolean)true);
        Roles.getTextboxRole().setAriaLiveProperty((Element)this.selectedDate.getElement(), LiveValue.ASSERTIVE);
        Roles.getTextboxRole().setAriaAtomicProperty((Element)this.selectedDate.getElement(), true);
        flowPanel.add((Widget)this.selectedDate);
        flowPanel.add((Widget)this.calendar);
        this.popup.setWidget((Widget)flowPanel);
        this.popup.addCloseHandler((CloseHandler)this);
        this.calendar.getElement().setId("PID_VAADIN_POPUPCAL");
        this.attachKeyHandlers();
        this.hideCalendarOnScrollHandler = PopupDateFieldWidget.initHideCalendarOnScrollHandler(this);
    }

    public void setPdbs(int n) {
        this.pdbs = n;
        Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand(){

            public void execute() {
                PopupDateFieldWidget.this.showCalendarIcon(PopupDateFieldWidget.this.getBooleanState(PopupDateFieldState.BooleanState.calendarIconVisible));
            }
        });
    }

    private boolean getBooleanState(PopupDateFieldState.BooleanState booleanState) {
        return FMCUtilities.getBooleanValue(this.pdbs, booleanState.ordinal());
    }

    @Override
    protected void handleMouseDownEvent(MouseDownEvent mouseDownEvent) {
        Element element = (Element)Element.as((JavaScriptObject)mouseDownEvent.getNativeEvent().getEventTarget()).cast();
        if (this.isIcon(element)) {
            mouseDownEvent.preventDefault();
            mouseDownEvent.stopPropagation();
        } else {
            super.handleMouseDownEvent(mouseDownEvent);
        }
        if (this.isIcon(element) && this.hasFocus()) {
            this.textBox.getFocusBlurHandler().setEnabled(false);
        }
    }

    @Override
    protected void handleClickEvent(ClickEvent clickEvent) {
        Element element = (Element)Element.as((JavaScriptObject)clickEvent.getNativeEvent().getEventTarget()).cast();
        if (this.isIcon(element)) {
            clickEvent.preventDefault();
            clickEvent.stopPropagation();
        } else {
            super.handleClickEvent(clickEvent);
        }
        if (this.isIcon(element) && !this.hasFocus()) {
            this.setFocus(true);
        }
        this.textBox.getFocusBlurHandler().setEnabled(true);
        this.checkCalendarStatus(element);
    }

    protected boolean shouldToggleCalendar(Element element) {
        boolean bl = false;
        if (this.isIcon(element)) {
            bl = true;
        } else if (!this.isTextInputAllowed() && this.textBox.getElement().isOrHasChild((Node)element)) {
            bl = true;
        } else if (!(this.calendarIconShown || this.popupShownInEditSession && !this.isPopupShowing())) {
            bl = true;
        }
        return bl;
    }

    protected void toggleCalendarPopup() {
        if (this.isPopupShowing()) {
            this.closeCalendarPanel();
        } else if (!this.isPopupJustClosed()) {
            this.requestCalendarPopupRequest();
        }
    }

    protected void checkCalendarStatus(Element element) {
        if (this.shouldToggleCalendar(element)) {
            this.toggleCalendarPopup();
        }
    }

    protected boolean isPopupJustClosed() {
        return new Date().getTime() - this.popupClosedTime < TOGGLE_CLOSE_THRESSHOLD_MS;
    }

    protected void requestCalendarPopupRequest() {
        for (PopupDateFieldListener popupDateFieldListener : this.listeners) {
            popupDateFieldListener.onCalendarPopupRequested();
        }
    }

    private boolean isIcon(Element element) {
        return this.iconWrapper.isOrHasChild((Node)element);
    }

    @Override
    protected com.google.gwt.user.client.Element getContainerElement() {
        return this.innerBorder;
    }

    public void addPopupDateFieldListener(PopupDateFieldListener popupDateFieldListener) {
        this.listeners.add(popupDateFieldListener);
    }

    public void removePopupDateFieldListener(PopupDateFieldListener popupDateFieldListener) {
        this.listeners.remove(popupDateFieldListener);
    }

    public void openCalendarPanel(Date date) {
        if (!this.open) {
            if (date != null) {
                this.calendar.setDate((Date)date.clone());
            } else {
                this.calendar.setDate(new Date());
            }
            this.popup.setWidth("");
            this.popup.setHeight("");
            this.popup.setPopupPositionAndShow(new PopupPanel.PositionCallback(){

                public void setPosition(int n, int n2) {
                    int n3 = PopupDateFieldWidget.this.popup.getOffsetWidth();
                    int n4 = n;
                    int n5 = n2;
                    int n6 = Window.getClientWidth() + Window.getScrollLeft();
                    int n7 = Window.getClientHeight() + Window.getScrollTop();
                    int n8 = PopupDateFieldWidget.this.getElement().getAbsoluteTop();
                    int n9 = PopupDateFieldWidget.this.getElement().getAbsoluteLeft();
                    int n10 = PopupDateFieldWidget.this.getElement().getClientWidth();
                    int n11 = 30;
                    boolean bl = false;
                    if (n9 + n10 + n11 + n3 > n6) {
                        bl = true;
                        n9 = n6 - n4 - n11;
                    }
                    if (n8 + n5 + PopupDateFieldWidget.this.getElement().getOffsetHeight() + n11 > n7) {
                        n8 = n7 - n5 - PopupDateFieldWidget.this.getElement().getOffsetHeight() - n11;
                        if (!bl && !BrowserInfo.get().isTouchDevice()) {
                            n9 += PopupDateFieldWidget.this.getElement().getOffsetWidth();
                        }
                    }
                    n8 = n8 + PopupDateFieldWidget.this.getElement().getOffsetHeight() + 2;
                    if (n9 < 1) {
                        n9 = n11;
                    }
                    if (n8 < 1) {
                        n8 = n11;
                    }
                    PopupDateFieldWidget.this.popup.setPopupPosition(n9, n8);
                    FMCUtilities.enableTouchScroll(false);
                    Timer timer = new Timer(){

                        public void run() {
                            PopupDateFieldWidget.this.calendar.renderCalendar();
                        }
                    };
                    timer.schedule(100);
                }
            });
            this.open = true;
            for (PopupDateFieldListener popupDateFieldListener : this.listeners) {
                popupDateFieldListener.onCalendarPopupVisibilityChange(this.open);
            }
            PopupDateFieldWidget.setHideCalendarOnScroll(this.hideCalendarOnScrollHandler, true);
            if (!FMCUtilities.isMobile()) {
                this.textBox.getElement().removeAttribute("contenteditable");
            }
        } else {
            this.calendar.renderCalendar();
        }
        this.popupShownInEditSession = true;
    }

    public void closeCalendarPanel() {
        if (this.open) {
            this.popup.hide(true);
        }
    }

    @Override
    public void setFocus(boolean bl) {
        this.textBox.setFocus(bl);
    }

    public void onClose(CloseEvent<PopupPanel> closeEvent) {
        if (closeEvent.getSource() == this.popup) {
            FMCUtilities.enableTouchScroll(true);
            this.popupClosedTime = new Date().getTime();
            if (this.calendar.getResolution() == Resolution.YEAR || this.calendar.getResolution() == Resolution.MONTH) {
                this.calendar.setDate(this.calendar.getFocusedDate());
                this.submitListener.onSubmit();
            }
            this.open = false;
            for (PopupDateFieldListener popupDateFieldListener : this.listeners) {
                popupDateFieldListener.onCalendarPopupVisibilityChange(false);
            }
            PopupDateFieldWidget.setHideCalendarOnScroll(this.hideCalendarOnScrollHandler, false);
            if (!FMCUtilities.isMobile() && this.textBox.isTextInputAllowed()) {
                this.textBox.getElement().setAttribute("contenteditable", "true");
            }
        }
    }

    public void showCalendarIcon(boolean bl) {
        if (bl) {
            this.icon.getStyle().clearDisplay();
            this.removeStyleName(ICON_HIDDEN_STYLE);
            this.calendarIconShown = true;
        } else {
            this.icon.getStyle().setDisplay(Style.Display.NONE);
            this.addStyleName(ICON_HIDDEN_STYLE);
            this.calendarIconShown = false;
        }
    }

    public String getFieldValue() {
        return this.getText();
    }

    public void setRange(Date date, Date date2) {
        this.calendar.setRangeStart(date);
        this.calendar.setRangeEnd(date2);
    }

    public Resolution getResolution() {
        return this.calendar.getResolution();
    }

    public void setResolution(Resolution resolution) {
        this.calendar.setResolution(resolution);
    }

    public void setCurrentLocale(String string) {
        try {
            this.getDateTimeService().setLocale(string);
            this.currentLocale = string;
        }
        catch (LocaleNotLoadedException localeNotLoadedException) {
            this.currentLocale = this.getDateTimeService().getLocale();
            localeNotLoadedException.printStackTrace();
        }
    }

    public String getCurrentLocale() {
        return this.currentLocale;
    }

    public DateTimeService getDateTimeService() {
        return this.dts;
    }

    public void setDateTimeService(DateTimeService dateTimeService) {
        this.dts = dateTimeService;
        this.calendar.setDateTimeService(dateTimeService);
    }

    public static final native double getTime(int var0, int var1, int var2, int var3, int var4, int var5, int var6);

    public boolean isPopupShowing() {
        return this.open;
    }

    private void attachKeyHandlers() {
        this.textBox.addKeyDownHandler(new KeyDownHandler(){

            public void onKeyDown(KeyDownEvent keyDownEvent) {
                if (PopupDateFieldWidget.this.isPopupShowing()) {
                    if (FMCUtilities.useAriaCompliantControl() && keyDownEvent.getNativeKeyCode() == 9) {
                        return;
                    }
                    PopupDateFieldWidget.this.calendar.onKeyDown(keyDownEvent);
                    keyDownEvent.preventDefault();
                    if (keyDownEvent.getNativeKeyCode() == 13) {
                        keyDownEvent.stopPropagation();
                    }
                } else {
                    this.handleKeyDownInput(keyDownEvent);
                }
            }

            private void handleKeyDownInput(KeyDownEvent keyDownEvent) {
                if (keyDownEvent.getNativeKeyCode() == 27 || FMCUtilities.useAriaCompliantControl() && keyDownEvent.getNativeKeyCode() == 40) {
                    PopupDateFieldWidget.this.requestCalendarPopupRequest();
                    keyDownEvent.preventDefault();
                    keyDownEvent.stopPropagation();
                }
            }
        });
        this.textBox.addKeyPressHandler(new KeyPressHandler(){

            public void onKeyPress(KeyPressEvent keyPressEvent) {
                if (PopupDateFieldWidget.this.isPopupShowing()) {
                    PopupDateFieldWidget.this.calendar.onKeyPress(keyPressEvent);
                    keyPressEvent.preventDefault();
                }
            }
        });
    }

    @Override
    public void setEnabled(boolean bl) {
        super.setEnabled(bl);
        Roles.getButtonRole().setAriaDisabledState(this.icon, !bl);
    }

    @Override
    public void setText(String string) {
        super.setText(string);
        this.textBox.moveCursorToEndOfText();
    }

    public void setServerText(String string) {
        this.setText(string);
    }

    public void handleFocus() {
    }

    public void handleBlur() {
        this.popupShownInEditSession = false;
        if (BrowserInfo.get().isIE()) {
            this.textBox.clearSelection();
        }
    }

    private static native JavaScriptObject initHideCalendarOnScrollHandler(PopupDateFieldWidget var0);

    private static native void setHideCalendarOnScroll(JavaScriptObject var0, boolean var1);

    public static interface PopupDateFieldListener
    extends Serializable {
        public void onDateSelected(Date var1);

        public void onUserInputChange(String var1);

        public void onCalendarPopupRequested();

        public void onCalendarPopupVisibilityChange(boolean var1);
    }
}

