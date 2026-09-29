/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.aria.client.Roles
 *  com.google.gwt.aria.client.SelectedValue
 *  com.google.gwt.dom.client.Element
 *  com.google.gwt.dom.client.Node
 *  com.google.gwt.event.dom.client.BlurEvent
 *  com.google.gwt.event.dom.client.BlurHandler
 *  com.google.gwt.event.dom.client.ChangeEvent
 *  com.google.gwt.event.dom.client.ChangeHandler
 *  com.google.gwt.event.dom.client.ClickEvent
 *  com.google.gwt.event.dom.client.ClickHandler
 *  com.google.gwt.event.dom.client.DomEvent
 *  com.google.gwt.event.dom.client.FocusEvent
 *  com.google.gwt.event.dom.client.FocusHandler
 *  com.google.gwt.event.dom.client.KeyDownEvent
 *  com.google.gwt.event.dom.client.KeyDownHandler
 *  com.google.gwt.event.dom.client.KeyPressEvent
 *  com.google.gwt.event.dom.client.KeyPressHandler
 *  com.google.gwt.event.dom.client.MouseDownEvent
 *  com.google.gwt.event.dom.client.MouseDownHandler
 *  com.google.gwt.event.dom.client.MouseOutEvent
 *  com.google.gwt.event.dom.client.MouseOutHandler
 *  com.google.gwt.event.dom.client.MouseUpEvent
 *  com.google.gwt.event.dom.client.MouseUpHandler
 *  com.google.gwt.user.client.DOM
 *  com.google.gwt.user.client.Element
 *  com.google.gwt.user.client.Timer
 *  com.google.gwt.user.client.ui.Button
 *  com.google.gwt.user.client.ui.FlexTable
 *  com.google.gwt.user.client.ui.FlowPanel
 *  com.google.gwt.user.client.ui.InlineHTML
 *  com.google.gwt.user.client.ui.ListBox
 *  com.google.gwt.user.client.ui.Widget
 *  com.vaadin.client.DateTimeService
 *  com.vaadin.client.Util
 *  com.vaadin.client.VConsole
 *  com.vaadin.client.ui.FocusableFlexTable
 *  com.vaadin.client.ui.SubPartAware
 *  com.vaadin.client.ui.VLabel
 *  com.vaadin.shared.util.SharedUtil
 *  com.vaadin.v7.client.ui.VCalendarPanel
 *  com.vaadin.v7.shared.ui.datefield.Resolution
 */
package com.filemaker.fields.client.datefield;

import com.filemaker.fields.client.datefield.PopupDateFieldWidget;
import com.google.gwt.aria.client.Roles;
import com.google.gwt.aria.client.SelectedValue;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Node;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.DomEvent;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.InlineHTML;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.DateTimeService;
import com.vaadin.client.Util;
import com.vaadin.client.VConsole;
import com.vaadin.client.ui.FocusableFlexTable;
import com.vaadin.client.ui.SubPartAware;
import com.vaadin.client.ui.VLabel;
import com.vaadin.shared.util.SharedUtil;
import com.vaadin.v7.client.ui.VCalendarPanel;
import com.vaadin.v7.shared.ui.datefield.Resolution;
import java.util.Date;

public class PopupCalendarPanel
extends FocusableFlexTable
implements KeyDownHandler,
KeyPressHandler,
MouseOutHandler,
MouseDownHandler,
MouseUpHandler,
BlurHandler,
FocusHandler,
SubPartAware {
    private static final String CN_FOCUSED = "focused";
    private static final String CN_TODAY = "today";
    private static final String CN_SELECTED = "selected";
    private static final String CN_OFFMONTH = "offmonth";
    private static final String CN_OUTSIDE_RANGE = "outside-range";
    private MouseDownHandler dayMouseDownHandler = new MouseDownHandler(this){

        public void onMouseDown(MouseDownEvent mouseDownEvent) {
            mouseDownEvent.preventDefault();
        }
    };
    private ClickHandler dayClickHandler = new ClickHandler(){

        public void onClick(ClickEvent clickEvent) {
            Date date = ((Day)((Object)clickEvent.getSource())).getDate();
            if (!PopupCalendarPanel.this.isDateInsideRange(date, Resolution.DAY)) {
                return;
            }
            if (date.getMonth() != PopupCalendarPanel.this.displayedMonth.getMonth() || date.getYear() != PopupCalendarPanel.this.displayedMonth.getYear()) {
                PopupCalendarPanel.this.displayedMonth.setMonth(date.getMonth());
                PopupCalendarPanel.this.displayedMonth.setYear(date.getYear());
                PopupCalendarPanel.this.renderCalendar();
            }
            PopupCalendarPanel.this.focusDay(date);
            PopupCalendarPanel.this.selectFocused();
            PopupCalendarPanel.this.onSubmit();
        }
    };
    private VEventButton prevYear;
    private VEventButton nextYear;
    private VEventButton prevMonth;
    private VEventButton nextMonth;
    private VTime time;
    private FlexTable days = new FlexTable();
    private Resolution resolution = Resolution.YEAR;
    private int focusedRow;
    private Timer mouseTimer;
    private Date value;
    private boolean enabled = true;
    private boolean readonly = false;
    private DateTimeService dateTimeService;
    private boolean showISOWeekNumbers;
    private Date displayedMonth;
    private Date focusedDate;
    private Day selectedDay;
    private Day focusedDay;
    private FocusOutListener focusOutListener;
    private SubmitListener submitListener;
    private FocusChangeListener focusChangeListener;
    private TimeChangeListener timeChangeListener;
    private boolean hasFocus = false;
    private PopupDateFieldWidget parent;
    private boolean initialRenderDone = false;
    private static final String SUBPART_NEXT_MONTH = "nextmon";
    private static final String SUBPART_PREV_MONTH = "prevmon";
    private static final String SUBPART_NEXT_YEAR = "nexty";
    private static final String SUBPART_PREV_YEAR = "prevy";
    private static final String SUBPART_HOUR_SELECT = "h";
    private static final String SUBPART_MINUTE_SELECT = "m";
    private static final String SUBPART_SECS_SELECT = "s";
    private static final String SUBPART_MSECS_SELECT = "ms";
    private static final String SUBPART_AMPM_SELECT = "ampm";
    private static final String SUBPART_DAY = "day";
    private static final String SUBPART_MONTH_YEAR_HEADER = "header";
    private Date rangeStart;
    private Date rangeEnd;

    public PopupCalendarPanel() {
        this.getElement().setId(DOM.createUniqueId());
        this.setStyleName("v-datefield-calendarpanel");
        Roles.getGridRole().set((Element)this.getElement());
        this.addKeyDownHandler(this);
        this.addFocusHandler(this);
        this.addBlurHandler(this);
    }

    public void setParentField(PopupDateFieldWidget popupDateFieldWidget) {
        this.parent = popupDateFieldWidget;
    }

    private void focusDay(Date date) {
        if (this.resolution.getCalendarField() > Resolution.MONTH.getCalendarField()) {
            if (this.focusedDay != null) {
                this.focusedDay.removeStyleDependentName(CN_FOCUSED);
            }
            if (date != null && this.focusedDate != null) {
                this.focusedDate.setTime(date.getTime());
                int n = this.days.getRowCount();
                for (int i = 0; i < n; ++i) {
                    int n2 = this.days.getCellCount(i);
                    for (int j = 0; j < n2; ++j) {
                        Day day;
                        Widget widget = this.days.getWidget(i, j);
                        if (widget == null || !(widget instanceof Day) || !(day = (Day)widget).getDate().equals(date)) continue;
                        day.addStyleDependentName(CN_FOCUSED);
                        this.focusedDay = day;
                        this.focusedRow = i;
                        return;
                    }
                }
            }
        }
    }

    private void selectDate(Date date) {
        if (this.selectedDay != null) {
            this.selectedDay.removeStyleDependentName(CN_SELECTED);
            Roles.getGridcellRole().removeAriaSelectedState((Element)this.selectedDay.getElement());
        }
        int n = this.days.getRowCount();
        for (int i = 0; i < n; ++i) {
            int n2 = this.days.getCellCount(i);
            for (int j = 0; j < n2; ++j) {
                Day day;
                Widget widget = this.days.getWidget(i, j);
                if (widget == null || !(widget instanceof Day) || !(day = (Day)widget).getDate().equals(date)) continue;
                day.addStyleDependentName(CN_SELECTED);
                this.selectedDay = day;
                Roles.getGridcellRole().setAriaSelectedState((Element)this.selectedDay.getElement(), SelectedValue.TRUE);
                return;
            }
        }
    }

    private void selectFocused() {
        if (this.focusedDate != null && this.isDateInsideRange(this.focusedDate, this.resolution)) {
            if (this.value == null) {
                this.value = new Date();
            }
            this.value.setDate(1);
            if (this.value.getYear() != this.focusedDate.getYear()) {
                this.value.setYear(this.focusedDate.getYear());
            }
            if (this.value.getMonth() != this.focusedDate.getMonth()) {
                this.value.setMonth(this.focusedDate.getMonth());
            }
            if (this.value.getDate() != this.focusedDate.getDate()) {
                // empty if block
            }
            this.value.setDate(this.focusedDate.getDate());
            this.selectDate(this.focusedDate);
        } else {
            VConsole.log((String)"Trying to select a the focused date which is NULL!");
        }
    }

    protected boolean onValueChange() {
        return false;
    }

    public Resolution getResolution() {
        return this.resolution;
    }

    public void setResolution(Resolution resolution) {
        boolean bl = this.resolution != resolution;
        this.resolution = resolution;
        if (this.time != null) {
            this.time.removeFromParent();
            this.time = null;
        } else {
            this.renderCalendar();
        }
    }

    private boolean isReadonly() {
        return this.readonly;
    }

    private boolean isEnabled() {
        return this.enabled;
    }

    public void setStyleName(String string) {
        super.setStyleName(string);
        if (this.initialRenderDone) {
            this.renderCalendar();
        }
    }

    public void setStylePrimaryName(String string) {
        super.setStylePrimaryName(string);
        if (this.initialRenderDone) {
            this.renderCalendar();
        }
    }

    private void clearCalendarBody(boolean bl) {
        if (!bl) {
            for (int i = 1; i < 7; ++i) {
                for (int j = 0; j < 8; ++j) {
                    this.days.setHTML(i, j, "&nbsp;");
                }
            }
        } else if (this.getRowCount() > 1) {
            this.removeRow(1);
            this.days.clear();
        }
    }

    private void buildCalendarHeader(boolean bl) {
        this.getRowFormatter().addStyleName(0, this.getParentPrimaryStyleName() + "-calendarpanel-header");
        if (this.prevMonth == null && bl) {
            this.prevMonth = new VEventButton(this);
            this.prevMonth.setHTML("&lsaquo;");
            this.prevMonth.setStyleName("v-button-prevmonth");
            this.prevMonth.setTabIndex(-1);
            this.nextMonth = new VEventButton(this);
            this.nextMonth.setHTML("&rsaquo;");
            this.nextMonth.setStyleName("v-button-nextmonth");
            this.nextMonth.setTabIndex(-1);
            this.setWidget(0, 3, (Widget)this.nextMonth);
            this.setWidget(0, 1, (Widget)this.prevMonth);
        } else if (this.prevMonth != null && !bl) {
            this.remove((Widget)this.prevMonth);
            this.remove((Widget)this.nextMonth);
            this.prevMonth = null;
            this.nextMonth = null;
        }
        if (this.prevYear == null) {
            this.prevYear = new VEventButton(this);
            this.prevYear.setHTML("&laquo;");
            this.prevYear.setStyleName("v-button-prevyear");
            this.prevYear.setTabIndex(-1);
            this.nextYear = new VEventButton(this);
            this.nextYear.setHTML("&raquo;");
            this.nextYear.setStyleName("v-button-nextyear");
            this.nextYear.setTabIndex(-1);
            this.setWidget(0, 0, (Widget)this.prevYear);
            this.setWidget(0, 4, (Widget)this.nextYear);
        }
        this.updateControlButtonRangeStyles(bl);
        String string = bl ? this.getDateTimeService().getMonth(this.displayedMonth.getMonth()) : "";
        int n = this.displayedMonth.getYear() + 1900;
        this.getFlexCellFormatter().setStyleName(0, 2, this.getParentPrimaryStyleName() + "-calendarpanel-month");
        this.getFlexCellFormatter().setStyleName(0, 0, this.getParentPrimaryStyleName() + "-calendarpanel-prevyear");
        this.getFlexCellFormatter().setStyleName(0, 4, this.getParentPrimaryStyleName() + "-calendarpanel-nextyear");
        this.getFlexCellFormatter().setStyleName(0, 3, this.getParentPrimaryStyleName() + "-calendarpanel-nextmonth");
        this.getFlexCellFormatter().setStyleName(0, 1, this.getParentPrimaryStyleName() + "-calendarpanel-prevmonth");
        this.setHTML(0, 2, "<span class=\"" + this.getParentPrimaryStyleName() + "-calendarpanel-month\">" + string + " " + n + "</span>");
    }

    private String getParentPrimaryStyleName() {
        return "v-datefield";
    }

    private void updateControlButtonRangeStyles(boolean bl) {
        Date date;
        Date date2;
        if (this.focusedDate == null) {
            return;
        }
        if (bl) {
            date2 = (Date)this.focusedDate.clone();
            PopupCalendarPanel.removeOneMonth(date2);
            if (!this.isDateInsideRange(date2, Resolution.MONTH)) {
                this.prevMonth.addStyleName(CN_OUTSIDE_RANGE);
            } else {
                this.prevMonth.removeStyleName(CN_OUTSIDE_RANGE);
            }
            date = (Date)this.focusedDate.clone();
            PopupCalendarPanel.addOneMonth(date);
            if (!this.isDateInsideRange(date, Resolution.MONTH)) {
                this.nextMonth.addStyleName(CN_OUTSIDE_RANGE);
            } else {
                this.nextMonth.removeStyleName(CN_OUTSIDE_RANGE);
            }
        }
        date2 = (Date)this.focusedDate.clone();
        date2.setYear(date2.getYear() - 1);
        if (!this.isDateInsideRange(date2, Resolution.YEAR)) {
            this.prevYear.addStyleName(CN_OUTSIDE_RANGE);
        } else {
            this.prevYear.removeStyleName(CN_OUTSIDE_RANGE);
        }
        date = (Date)this.focusedDate.clone();
        date.setYear(date.getYear() + 1);
        if (!this.isDateInsideRange(date, Resolution.YEAR)) {
            this.nextYear.addStyleName(CN_OUTSIDE_RANGE);
        } else {
            this.nextYear.removeStyleName(CN_OUTSIDE_RANGE);
        }
    }

    private DateTimeService getDateTimeService() {
        return this.dateTimeService;
    }

    public void setDateTimeService(DateTimeService dateTimeService) {
        this.dateTimeService = dateTimeService;
    }

    public boolean isShowISOWeekNumbers() {
        return this.showISOWeekNumbers;
    }

    public void setShowISOWeekNumbers(boolean bl) {
        this.showISOWeekNumbers = bl;
    }

    private boolean isDateInsideRange(Date date, Resolution resolution) {
        assert (date != null);
        return this.isAcceptedByRangeEnd(date, resolution) && this.isAcceptedByRangeStart(date, resolution);
    }

    private boolean isAcceptedByRangeStart(Date date, Resolution resolution) {
        assert (date != null);
        if (this.rangeStart == null) {
            return true;
        }
        Date date2 = (Date)date.clone();
        Date date3 = (Date)this.rangeStart.clone();
        if (resolution == Resolution.YEAR) {
            return date2.getYear() >= date3.getYear();
        }
        if (resolution == Resolution.MONTH) {
            date2 = PopupCalendarPanel.clearDateBelowMonth(date2);
            date3 = PopupCalendarPanel.clearDateBelowMonth(date3);
        } else {
            date2 = PopupCalendarPanel.clearDateBelowDay(date2);
            date3 = PopupCalendarPanel.clearDateBelowDay(date3);
        }
        return !date3.after(date2);
    }

    private boolean isAcceptedByRangeEnd(Date date, Resolution resolution) {
        assert (date != null);
        if (this.rangeEnd == null) {
            return true;
        }
        Date date2 = (Date)date.clone();
        Date date3 = (Date)this.rangeEnd.clone();
        if (resolution == Resolution.YEAR) {
            return date2.getYear() <= date3.getYear();
        }
        if (resolution == Resolution.MONTH) {
            date2 = PopupCalendarPanel.clearDateBelowMonth(date2);
            date3 = PopupCalendarPanel.clearDateBelowMonth(date3);
        } else {
            date2 = PopupCalendarPanel.clearDateBelowDay(date2);
            date3 = PopupCalendarPanel.clearDateBelowDay(date3);
        }
        return !date3.before(date2);
    }

    private static Date clearDateBelowMonth(Date date) {
        date.setDate(1);
        return PopupCalendarPanel.clearDateBelowDay(date);
    }

    private static Date clearDateBelowDay(Date date) {
        date.setHours(0);
        date.setMinutes(0);
        date.setSeconds(0);
        long l = date.getTime() / 1000L;
        date = new Date(l * 1000L);
        return date;
    }

    private void buildCalendarBody() {
        this.setWidget(1, 0, (Widget)this.days);
        this.setCellPadding(0);
        this.setCellSpacing(0);
        this.getFlexCellFormatter().setColSpan(1, 0, 5);
        this.getFlexCellFormatter().setStyleName(1, 0, this.getParentPrimaryStyleName() + "-calendarpanel-body");
        this.days.getFlexCellFormatter().setStyleName(0, 0, "v-week");
        this.days.setHTML(0, 0, "<strong></strong>");
        this.days.getFlexCellFormatter().setVisible(0, 0, this.isShowISOWeekNumbers());
        this.days.getRowFormatter().setStyleName(0, this.getParentPrimaryStyleName() + "-calendarpanel-weekdays");
        if (this.isShowISOWeekNumbers()) {
            this.days.getFlexCellFormatter().setStyleName(0, 0, "v-first");
            this.days.getFlexCellFormatter().setStyleName(0, 1, "");
            this.days.getRowFormatter().addStyleName(0, this.getParentPrimaryStyleName() + "-calendarpanel-weeknumbers");
        } else {
            this.days.getFlexCellFormatter().setStyleName(0, 0, "");
            this.days.getFlexCellFormatter().setStyleName(0, 1, "v-first");
        }
        this.days.getFlexCellFormatter().setStyleName(0, 7, "v-last");
        int n = this.getDateTimeService().getFirstDayOfWeek();
        for (int i = 0; i < 7; ++i) {
            int n2 = i + n;
            if (n2 > 6) {
                n2 = 0;
            }
            if (this.getResolution().getCalendarField() > Resolution.MONTH.getCalendarField()) {
                this.days.setHTML(0, 1 + i, "<strong>" + this.getDateTimeService().getShortDay(n2) + "</strong>");
            } else {
                this.days.setHTML(0, 1 + i, "");
            }
            Roles.getColumnheaderRole().set((Element)this.days.getCellFormatter().getElement(0, 1 + i));
        }
        Date date = new Date();
        Date date2 = new Date(date.getYear(), date.getMonth(), date.getDate());
        Date date3 = this.value == null ? null : new Date(this.value.getYear(), this.value.getMonth(), this.value.getDate());
        int n3 = this.getDateTimeService().getStartWeekDay(this.displayedMonth);
        Date date4 = (Date)this.displayedMonth.clone();
        date4.setDate(1 - n3);
        for (int i = 1; i < 7; ++i) {
            for (int j = 0; j < 7; ++j) {
                Date date5 = (Date)date4.clone();
                Day day = new Day(this, date5);
                day.setStyleName(this.getParentPrimaryStyleName() + "-calendarpanel-day");
                if (!this.isDateInsideRange(date5, Resolution.DAY)) {
                    day.addStyleDependentName(CN_OUTSIDE_RANGE);
                }
                if (date4.equals(date3)) {
                    day.addStyleDependentName(CN_SELECTED);
                    Roles.getGridcellRole().setAriaSelectedState((Element)day.getElement(), SelectedValue.TRUE);
                    this.selectedDay = day;
                }
                if (date4.equals(date2)) {
                    day.addStyleDependentName(CN_TODAY);
                }
                if (date4.equals(this.focusedDate)) {
                    this.focusedDay = day;
                    this.focusedRow = i;
                    if (this.hasFocus) {
                        day.addStyleDependentName(CN_FOCUSED);
                    }
                }
                if (date4.getMonth() != this.displayedMonth.getMonth()) {
                    day.addStyleDependentName(CN_OFFMONTH);
                }
                this.days.setWidget(i, 1 + j, (Widget)day);
                Roles.getGridcellRole().set((Element)this.days.getCellFormatter().getElement(i, 1 + j));
                this.days.getCellFormatter().setVisible(i, 0, this.isShowISOWeekNumbers());
                if (this.isShowISOWeekNumbers()) {
                    String string;
                    String string2 = string = this.getParentPrimaryStyleName() + "-calendarpanel-weeknumber";
                    int n4 = DateTimeService.getISOWeekNumber((Date)date4);
                    this.days.setHTML(i, 0, "<span class=\"" + string2 + "\">" + n4 + "</span>");
                }
                date4.setDate(date4.getDate() + 1);
            }
        }
    }

    private boolean isTimeSelectorNeeded() {
        return this.getResolution().getCalendarField() > Resolution.DAY.getCalendarField();
    }

    public void renderCalendar() {
        super.setStylePrimaryName(this.getParentPrimaryStyleName() + "-calendarpanel");
        if (this.focusedDate == null) {
            Date date = new Date();
            this.focusedDate = new Date(date.getYear(), date.getMonth(), date.getDate());
            this.displayedMonth = new Date(date.getYear(), date.getMonth(), 1);
        }
        if (this.getResolution().getCalendarField() <= Resolution.MONTH.getCalendarField() && this.focusChangeListener != null) {
            this.focusChangeListener.focusChanged(new Date(this.focusedDate.getTime()));
        }
        boolean bl = this.getResolution().getCalendarField() > Resolution.YEAR.getCalendarField();
        boolean bl2 = this.getResolution().getCalendarField() >= Resolution.DAY.getCalendarField();
        this.buildCalendarHeader(bl);
        this.clearCalendarBody(!bl2);
        if (bl2) {
            this.buildCalendarBody();
        }
        if (this.isTimeSelectorNeeded() && this.time == null) {
            this.time = new VTime();
            this.setWidget(2, 0, (Widget)this.time);
            this.getFlexCellFormatter().setColSpan(2, 0, 5);
            this.getFlexCellFormatter().setStyleName(2, 0, this.getParentPrimaryStyleName() + "-calendarpanel-time");
        } else if (this.isTimeSelectorNeeded()) {
            this.time.updateTimes();
        } else if (this.time != null) {
            this.remove((Widget)this.time);
        }
        this.initialRenderDone = true;
    }

    private void focusNextDay(int n) {
        if (this.focusedDate == null) {
            return;
        }
        Date date = (Date)this.focusedDate.clone();
        date.setDate(this.focusedDate.getDate() + n);
        if (!this.isDateInsideRange(date, this.resolution)) {
            return;
        }
        int n2 = this.focusedDate.getMonth();
        int n3 = this.focusedDate.getYear();
        this.focusedDate.setDate(this.focusedDate.getDate() + n);
        if (this.focusedDate.getMonth() == n2 && this.focusedDate.getYear() == n3) {
            this.focusDay(this.focusedDate);
        } else {
            this.displayedMonth.setMonth(this.focusedDate.getMonth());
            this.displayedMonth.setYear(this.focusedDate.getYear());
            this.renderCalendar();
        }
    }

    public Date getFocusedDate() {
        return this.focusedDate;
    }

    private void focusPreviousDay(int n) {
        this.focusNextDay(-n);
    }

    private void focusNextMonth() {
        if (this.focusedDate == null) {
            return;
        }
        Date date = (Date)this.focusedDate.clone();
        PopupCalendarPanel.addOneMonth(date);
        if (!this.isDateInsideRange(date, Resolution.MONTH)) {
            return;
        }
        if (!this.isDateInsideRange(date, Resolution.DAY)) {
            date = this.adjustDateToFitInsideRange(date);
        }
        this.focusedDate.setTime(date.getTime());
        this.displayedMonth.setMonth(this.displayedMonth.getMonth() + 1);
        this.renderCalendar();
    }

    private static void addOneMonth(Date date) {
        int n = date.getMonth();
        int n2 = (n + 1) % 12;
        date.setMonth(date.getMonth() + 1);
        while (date.getMonth() != n2) {
            date.setDate(date.getDate() - 1);
        }
    }

    private static void removeOneMonth(Date date) {
        int n = date.getMonth();
        date.setMonth(date.getMonth() - 1);
        while (date.getMonth() == n) {
            date.setDate(date.getDate() - 1);
        }
    }

    private void focusPreviousMonth() {
        if (this.focusedDate == null) {
            return;
        }
        Date date = (Date)this.focusedDate.clone();
        PopupCalendarPanel.removeOneMonth(date);
        if (!this.isDateInsideRange(date, Resolution.MONTH)) {
            return;
        }
        if (!this.isDateInsideRange(date, Resolution.DAY)) {
            date = this.adjustDateToFitInsideRange(date);
        }
        this.focusedDate.setTime(date.getTime());
        this.displayedMonth.setMonth(this.displayedMonth.getMonth() - 1);
        this.renderCalendar();
    }

    private void focusPreviousYear(int n) {
        if (this.focusedDate == null) {
            return;
        }
        Date date = (Date)this.focusedDate.clone();
        date.setYear(date.getYear() - n);
        if (!this.isDateInsideRange(date, Resolution.YEAR)) {
            return;
        }
        if (!this.isDateInsideRange(date, Resolution.DAY)) {
            date = this.adjustDateToFitInsideRange(date);
            this.focusedDate.setYear(date.getYear());
            this.focusedDate.setMonth(date.getMonth());
            this.focusedDate.setDate(date.getDate());
            this.displayedMonth.setYear(date.getYear());
            this.displayedMonth.setMonth(date.getMonth());
        } else {
            int n2 = this.focusedDate.getMonth();
            this.focusedDate.setYear(this.focusedDate.getYear() - n);
            this.displayedMonth.setYear(this.displayedMonth.getYear() - n);
            if (this.focusedDate.getMonth() != n2) {
                this.focusedDate.setDate(0);
            }
        }
        this.renderCalendar();
    }

    private void focusNextYear(int n) {
        if (this.focusedDate == null) {
            return;
        }
        Date date = (Date)this.focusedDate.clone();
        date.setYear(date.getYear() + n);
        if (!this.isDateInsideRange(date, Resolution.YEAR)) {
            return;
        }
        if (!this.isDateInsideRange(date, Resolution.DAY)) {
            date = this.adjustDateToFitInsideRange(date);
            this.focusedDate.setYear(date.getYear());
            this.focusedDate.setMonth(date.getMonth());
            this.focusedDate.setDate(date.getDate());
            this.displayedMonth.setYear(date.getYear());
            this.displayedMonth.setMonth(date.getMonth());
        } else {
            int n2 = this.focusedDate.getMonth();
            this.focusedDate.setYear(this.focusedDate.getYear() + n);
            this.displayedMonth.setYear(this.displayedMonth.getYear() + n);
            if (this.focusedDate.getMonth() != n2) {
                this.focusedDate.setDate(0);
            }
        }
        this.renderCalendar();
    }

    private void processClickEvent(Widget widget) {
        if (!this.isEnabled() || this.isReadonly()) {
            return;
        }
        if (widget == this.prevYear) {
            this.focusPreviousYear(1);
        } else if (widget == this.nextYear) {
            this.focusNextYear(1);
        } else if (widget == this.prevMonth) {
            this.focusPreviousMonth();
        } else if (widget == this.nextMonth) {
            this.focusNextMonth();
        }
    }

    public void onKeyDown(KeyDownEvent keyDownEvent) {
        this.handleKeyPress((DomEvent<?>)keyDownEvent);
    }

    public void onKeyPress(KeyPressEvent keyPressEvent) {
        this.handleKeyPress((DomEvent<?>)keyPressEvent);
    }

    private void handleKeyPress(DomEvent<?> domEvent) {
        if (this.time != null && this.time.getElement().isOrHasChild((Node)domEvent.getNativeEvent().getEventTarget().cast())) {
            int n = domEvent.getNativeEvent().getKeyCode();
            if (n == this.getSelectKey()) {
                this.onSubmit();
                domEvent.preventDefault();
                domEvent.stopPropagation();
            }
            if (n == this.getCloseKey()) {
                this.onCancel();
                domEvent.preventDefault();
                domEvent.stopPropagation();
            }
            return;
        }
        int n = domEvent.getNativeEvent().getKeyCode();
        if (n == this.getCloseKey()) {
            this.onCancel();
            domEvent.stopPropagation();
            domEvent.preventDefault();
            return;
        }
        if (n == 9 && domEvent.getNativeEvent().getShiftKey() && this.onTabOut(domEvent)) {
            return;
        }
        if (this.handleNavigation(n, domEvent.getNativeEvent().getCtrlKey() || domEvent.getNativeEvent().getMetaKey(), domEvent.getNativeEvent().getShiftKey())) {
            domEvent.preventDefault();
        } else if (n == this.getCloseKey()) {
            this.onCancel();
            domEvent.preventDefault();
            domEvent.stopPropagation();
        }
    }

    private void onSubmit() {
        if (this.getSubmitListener() != null) {
            this.getSubmitListener().onSubmit();
        }
    }

    private void onCancel() {
        if (this.getSubmitListener() != null) {
            this.getSubmitListener().onCancel();
        }
    }

    protected boolean handleNavigationYearMode(int n, boolean bl, boolean bl2) {
        if (bl || bl2) {
            return false;
        }
        if (n == this.getPreviousKey()) {
            this.focusNextYear(10);
            return true;
        }
        if (n == this.getForwardKey()) {
            this.focusNextYear(1);
            return true;
        }
        if (n == this.getNextKey()) {
            this.focusPreviousYear(10);
            return true;
        }
        if (n == this.getBackwardKey()) {
            this.focusPreviousYear(1);
            return true;
        }
        if (n == this.getSelectKey()) {
            this.value = (Date)this.focusedDate.clone();
            this.onSubmit();
            return true;
        }
        if (n == this.getResetKey()) {
            this.focusedDate.setTime(this.value.getTime());
            this.renderCalendar();
            return true;
        }
        return false;
    }

    protected boolean handleNavigationMonthMode(int n, boolean bl, boolean bl2) {
        if (bl) {
            return false;
        }
        if (n == this.getPreviousKey()) {
            this.focusNextYear(1);
            return true;
        }
        if (n == this.getForwardKey()) {
            this.focusNextMonth();
            return true;
        }
        if (n == this.getNextKey()) {
            this.focusPreviousYear(1);
            return true;
        }
        if (n == this.getBackwardKey()) {
            this.focusPreviousMonth();
            return true;
        }
        if (n == this.getSelectKey()) {
            this.value = (Date)this.focusedDate.clone();
            this.onSubmit();
            return true;
        }
        if (n == this.getResetKey()) {
            this.focusedDate.setTime(this.value.getTime());
            this.renderCalendar();
            return true;
        }
        if (n == 9) {
            this.onCancel();
            return true;
        }
        return false;
    }

    protected boolean handleNavigationDayMode(int n, boolean bl, boolean bl2) {
        if (bl) {
            return false;
        }
        if (n == this.getForwardKey() && !bl2) {
            this.focusNextDay(1);
            return true;
        }
        if (n == this.getBackwardKey() && !bl2) {
            this.focusPreviousDay(1);
            return true;
        }
        if (n == this.getNextKey() && !bl2) {
            this.focusNextDay(7);
            return true;
        }
        if (n == this.getPreviousKey() && !bl2) {
            this.focusPreviousDay(7);
            return true;
        }
        if (n == this.getSelectKey() && !bl2) {
            this.selectFocused();
            this.onSubmit();
            return true;
        }
        if (bl2 && n == this.getForwardKey()) {
            this.focusNextMonth();
            return true;
        }
        if (bl2 && n == this.getBackwardKey()) {
            this.focusPreviousMonth();
            return true;
        }
        if (bl2 && n == this.getPreviousKey()) {
            this.focusNextYear(1);
            return true;
        }
        if (bl2 && n == this.getNextKey()) {
            this.focusPreviousYear(1);
            return true;
        }
        if (n == this.getResetKey() && !bl2) {
            this.focusedDate = new Date(this.value.getYear(), this.value.getMonth(), this.value.getDate());
            this.displayedMonth = new Date(this.value.getYear(), this.value.getMonth(), 1);
            this.renderCalendar();
            return true;
        }
        return false;
    }

    protected boolean handleNavigation(int n, boolean bl, boolean bl2) {
        if (!this.isEnabled() || this.isReadonly()) {
            return false;
        }
        if (this.resolution == Resolution.YEAR) {
            return this.handleNavigationYearMode(n, bl, bl2);
        }
        if (this.resolution == Resolution.MONTH) {
            return this.handleNavigationMonthMode(n, bl, bl2);
        }
        if (this.resolution == Resolution.DAY) {
            return this.handleNavigationDayMode(n, bl, bl2);
        }
        return this.handleNavigationDayMode(n, bl, bl2);
    }

    protected int getResetKey() {
        return 8;
    }

    protected int getSelectKey() {
        return 13;
    }

    protected int getCloseKey() {
        return 27;
    }

    protected int getForwardKey() {
        return 39;
    }

    protected int getBackwardKey() {
        return 37;
    }

    protected int getNextKey() {
        return 40;
    }

    protected int getPreviousKey() {
        return 38;
    }

    public void onMouseOut(MouseOutEvent mouseOutEvent) {
        if (this.mouseTimer != null) {
            this.mouseTimer.cancel();
        }
    }

    public void onMouseDown(MouseDownEvent mouseDownEvent) {
        if (mouseDownEvent.getSource() instanceof VEventButton) {
            final VEventButton vEventButton = (VEventButton)((Object)mouseDownEvent.getSource());
            this.processClickEvent((Widget)vEventButton);
            this.mouseTimer = new Timer(this){
                final /* synthetic */ PopupCalendarPanel this$0;
                {
                    this.this$0 = popupCalendarPanel;
                }

                public void run() {
                    this.this$0.mouseTimer = new Timer(this){
                        final /* synthetic */ 3 this$1;
                        {
                            this.this$1 = var1_1;
                        }

                        public void run() {
                            this.this$1.this$0.processClickEvent((Widget)vEventButton);
                        }
                    };
                    this.this$0.mouseTimer.scheduleRepeating(150);
                }
            };
            this.mouseTimer.schedule(500);
        }
    }

    public void onMouseUp(MouseUpEvent mouseUpEvent) {
        if (this.mouseTimer != null) {
            this.mouseTimer.cancel();
        }
    }

    private Date adjustDateToFitInsideRange(Date date) {
        if (this.rangeStart != null && this.rangeStart.after(date)) {
            date = (Date)this.rangeStart.clone();
        } else if (this.rangeEnd != null && this.rangeEnd.before(date)) {
            date = (Date)this.rangeEnd.clone();
        }
        return date;
    }

    public void setDate(Date date) {
        if (date == this.value && date != null) {
            return;
        }
        boolean bl = false;
        if (date != null && !this.isDateInsideRange(date, this.resolution)) {
            date = this.adjustDateToFitInsideRange(date);
            bl = true;
        }
        Date date2 = this.displayedMonth;
        this.value = date;
        if (this.value == null || bl) {
            if (this.rangeStart != null || this.rangeEnd != null) {
                Date date3 = this.adjustDateToFitInsideRange(new Date());
                this.focusedDate = new Date(date3.getYear(), date3.getMonth(), date3.getDate());
                this.displayedMonth = new Date(date3.getYear(), date3.getMonth(), 1);
                if (this.getResolution().getCalendarField() >= Resolution.DAY.getCalendarField()) {
                    this.value = null;
                }
            } else {
                this.displayedMonth = null;
                this.focusedDate = null;
            }
        } else {
            this.focusedDate = new Date(this.value.getYear(), this.value.getMonth(), this.value.getDate());
            this.displayedMonth = new Date(this.value.getYear(), this.value.getMonth(), 1);
        }
        if (this.isTimeSelectorNeeded() && this.time == null || date2 == null || this.value == null || date2.getYear() != this.value.getYear() || date2.getMonth() != this.value.getMonth()) {
            this.renderCalendar();
        } else {
            this.focusDay(this.focusedDate);
            this.selectFocused();
            if (this.isTimeSelectorNeeded()) {
                this.time.updateTimes();
            }
        }
        if (!this.hasFocus) {
            this.focusDay(null);
        }
    }

    public Date getDate() {
        return this.value;
    }

    protected boolean onTabOut(DomEvent<?> domEvent) {
        if (this.focusOutListener != null) {
            return this.focusOutListener.onFocusOut(domEvent);
        }
        return false;
    }

    public void setFocusOutListener(FocusOutListener focusOutListener) {
        this.focusOutListener = focusOutListener;
    }

    public void setSubmitListener(SubmitListener submitListener) {
        this.submitListener = submitListener;
    }

    public void setFocusChangeListener(FocusChangeListener focusChangeListener) {
        this.focusChangeListener = focusChangeListener;
    }

    public void setTimeChangeListener(TimeChangeListener timeChangeListener) {
        this.timeChangeListener = timeChangeListener;
    }

    public SubmitListener getSubmitListener() {
        return this.submitListener;
    }

    public void onBlur(BlurEvent blurEvent) {
        if (blurEvent.getSource() instanceof VCalendarPanel) {
            this.hasFocus = false;
            this.focusDay(null);
        }
    }

    public void onFocus(FocusEvent focusEvent) {
        if (focusEvent.getSource() instanceof VCalendarPanel) {
            this.hasFocus = true;
            if (this.focusedDay != null) {
                this.focusDay(this.focusedDate);
            }
        }
    }

    public String getSubPartName(com.google.gwt.user.client.Element element) {
        if (this.contains((Widget)this.nextMonth, element)) {
            return SUBPART_NEXT_MONTH;
        }
        if (this.contains((Widget)this.prevMonth, element)) {
            return SUBPART_PREV_MONTH;
        }
        if (this.contains((Widget)this.nextYear, element)) {
            return SUBPART_NEXT_YEAR;
        }
        if (this.contains((Widget)this.prevYear, element)) {
            return SUBPART_PREV_YEAR;
        }
        if (this.contains((Widget)this.days, element)) {
            Day day = (Day)((Object)Util.findWidget((Element)element, Day.class));
            if (day != null) {
                Date date = day.getDate();
                int n = date.getDate();
                if (date.getMonth() < this.displayedMonth.getMonth()) {
                    n -= DateTimeService.getNumberOfDaysInMonth((Date)date);
                } else if (date.getMonth() > this.displayedMonth.getMonth()) {
                    n += DateTimeService.getNumberOfDaysInMonth((Date)this.displayedMonth);
                }
                return SUBPART_DAY + n;
            }
        } else if (this.time != null) {
            if (this.contains((Widget)this.time.hours, element)) {
                return SUBPART_HOUR_SELECT;
            }
            if (this.contains((Widget)this.time.mins, element)) {
                return SUBPART_MINUTE_SELECT;
            }
            if (this.contains((Widget)this.time.sec, element)) {
                return SUBPART_SECS_SELECT;
            }
            if (this.contains((Widget)this.time.ampm, element)) {
                return SUBPART_AMPM_SELECT;
            }
        } else if (this.getCellFormatter().getElement(0, 2).isOrHasChild((Node)element)) {
            return SUBPART_MONTH_YEAR_HEADER;
        }
        return null;
    }

    private boolean contains(Widget widget, com.google.gwt.user.client.Element element) {
        if (widget == null || widget.getElement() == null) {
            return false;
        }
        return widget.getElement().isOrHasChild((Node)element);
    }

    public com.google.gwt.user.client.Element getSubPartElement(String string) {
        if (SUBPART_NEXT_MONTH.equals(string)) {
            return this.nextMonth.getElement();
        }
        if (SUBPART_PREV_MONTH.equals(string)) {
            return this.prevMonth.getElement();
        }
        if (SUBPART_NEXT_YEAR.equals(string)) {
            return this.nextYear.getElement();
        }
        if (SUBPART_PREV_YEAR.equals(string)) {
            return this.prevYear.getElement();
        }
        if (SUBPART_HOUR_SELECT.equals(string)) {
            return this.time.hours.getElement();
        }
        if (SUBPART_MINUTE_SELECT.equals(string)) {
            return this.time.mins.getElement();
        }
        if (SUBPART_SECS_SELECT.equals(string)) {
            return this.time.sec.getElement();
        }
        if (SUBPART_AMPM_SELECT.equals(string)) {
            return this.time.ampm.getElement();
        }
        if (string.startsWith(SUBPART_DAY)) {
            int n = Integer.parseInt(string.substring(SUBPART_DAY.length()));
            Date date = new Date(this.displayedMonth.getYear(), this.displayedMonth.getMonth(), n);
            for (Widget widget : this.days) {
                Day day;
                if (!(widget instanceof Day) || !(day = (Day)widget).getDate().equals(date)) continue;
                return day.getElement();
            }
        }
        if (SUBPART_MONTH_YEAR_HEADER.equals(string)) {
            return (com.google.gwt.user.client.Element)this.getCellFormatter().getElement(0, 2).getChild(0);
        }
        return null;
    }

    protected void onDetach() {
        super.onDetach();
        if (this.mouseTimer != null) {
            this.mouseTimer.cancel();
        }
    }

    public void setRangeStart(Date date) {
        if (!SharedUtil.equals((Object)this.rangeStart, (Object)date)) {
            this.rangeStart = date;
            if (this.initialRenderDone) {
                this.renderCalendar();
            }
        }
    }

    public void setRangeEnd(Date date) {
        if (!SharedUtil.equals((Object)this.rangeEnd, (Object)date)) {
            this.rangeEnd = date;
            if (this.initialRenderDone) {
                this.renderCalendar();
            }
        }
    }

    private class Day
    extends InlineHTML {
        private final Date date;

        Day(PopupCalendarPanel popupCalendarPanel, Date date) {
            super("" + date.getDate());
            this.date = date;
            this.addMouseDownHandler(popupCalendarPanel.dayMouseDownHandler);
            this.addClickHandler(popupCalendarPanel.dayClickHandler);
        }

        public Date getDate() {
            return this.date;
        }
    }

    public class VTime
    extends FlowPanel
    implements ChangeHandler {
        private ListBox hours;
        private ListBox mins;
        private ListBox sec;
        private ListBox ampm;

        public VTime() {
            this.setStyleName("v-datefield-time");
            this.buildTime();
        }

        private ListBox createListBox() {
            ListBox listBox = new ListBox();
            listBox.setStyleName("v-select");
            listBox.addChangeHandler((ChangeHandler)this);
            listBox.addBlurHandler((BlurHandler)PopupCalendarPanel.this);
            listBox.addFocusHandler((FocusHandler)PopupCalendarPanel.this);
            return listBox;
        }

        private void buildTime() {
            int n;
            this.clear();
            this.hours = this.createListBox();
            if (this.getDateTimeService().isTwelveHourClock()) {
                this.hours.addItem("12");
                for (var1_1 = 1; var1_1 < 12; ++var1_1) {
                    this.hours.addItem(var1_1 < 10 ? "0" + var1_1 : "" + var1_1);
                }
            } else {
                for (var1_1 = 0; var1_1 < 24; ++var1_1) {
                    this.hours.addItem(var1_1 < 10 ? "0" + var1_1 : "" + var1_1);
                }
            }
            this.hours.addChangeHandler((ChangeHandler)this);
            if (this.getDateTimeService().isTwelveHourClock()) {
                this.ampm = this.createListBox();
                String[] stringArray = this.getDateTimeService().getAmPmStrings();
                this.ampm.addItem(stringArray[0]);
                this.ampm.addItem(stringArray[1]);
                this.ampm.addChangeHandler((ChangeHandler)this);
            }
            if (PopupCalendarPanel.this.getResolution().getCalendarField() >= Resolution.MINUTE.getCalendarField()) {
                this.mins = this.createListBox();
                for (int i = 0; i < 60; ++i) {
                    this.mins.addItem(i < 10 ? "0" + i : "" + i);
                }
                this.mins.addChangeHandler((ChangeHandler)this);
            }
            if (PopupCalendarPanel.this.getResolution().getCalendarField() >= Resolution.SECOND.getCalendarField()) {
                this.sec = this.createListBox();
                for (int i = 0; i < 60; ++i) {
                    this.sec.addItem(i < 10 ? "0" + i : "" + i);
                }
                this.sec.addChangeHandler((ChangeHandler)this);
            }
            String string = this.getDateTimeService().getClockDelimeter();
            if (PopupCalendarPanel.this.isReadonly()) {
                n = 0;
                if (PopupCalendarPanel.this.value != null) {
                    n = PopupCalendarPanel.this.value.getHours();
                }
                if (this.getDateTimeService().isTwelveHourClock()) {
                    n -= n < 12 ? 0 : 12;
                }
                this.add((Widget)new VLabel(n < 10 ? "0" + n : "" + n));
            } else {
                this.add((Widget)this.hours);
            }
            if (PopupCalendarPanel.this.getResolution().getCalendarField() >= Resolution.MINUTE.getCalendarField()) {
                this.add((Widget)new VLabel(string));
                if (PopupCalendarPanel.this.isReadonly()) {
                    n = this.mins.getSelectedIndex();
                    this.add((Widget)new VLabel(n < 10 ? "0" + n : "" + n));
                } else {
                    this.add((Widget)this.mins);
                }
            }
            if (PopupCalendarPanel.this.getResolution().getCalendarField() >= Resolution.SECOND.getCalendarField()) {
                this.add((Widget)new VLabel(string));
                if (PopupCalendarPanel.this.isReadonly()) {
                    n = this.sec.getSelectedIndex();
                    this.add((Widget)new VLabel(n < 10 ? "0" + n : "" + n));
                } else {
                    this.add((Widget)this.sec);
                }
            }
            if (PopupCalendarPanel.this.getResolution() == Resolution.HOUR) {
                this.add((Widget)new VLabel(string + "00"));
            }
            if (this.getDateTimeService().isTwelveHourClock()) {
                this.add((Widget)new VLabel("&nbsp;"));
                if (PopupCalendarPanel.this.isReadonly()) {
                    n = 0;
                    if (PopupCalendarPanel.this.value != null) {
                        n = PopupCalendarPanel.this.value.getHours() < 12 ? 0 : 1;
                    }
                    this.add((Widget)new VLabel(this.ampm.getItemText(n)));
                } else {
                    this.add((Widget)this.ampm);
                }
            }
            if (PopupCalendarPanel.this.isReadonly()) {
                return;
            }
            this.updateTimes();
            ListBox listBox = this.getLastDropDown();
            listBox.addKeyDownHandler(new KeyDownHandler(){

                public void onKeyDown(KeyDownEvent keyDownEvent) {
                    boolean bl = keyDownEvent.getNativeEvent().getShiftKey();
                    if (bl) {
                        return;
                    }
                    int n = keyDownEvent.getNativeKeyCode();
                    if (n == 9) {
                        PopupCalendarPanel.this.onTabOut((DomEvent<?>)keyDownEvent);
                    }
                }
            });
        }

        private ListBox getLastDropDown() {
            for (int i = this.getWidgetCount() - 1; i >= 0; --i) {
                Widget widget = this.getWidget(i);
                if (!(widget instanceof ListBox)) continue;
                return (ListBox)widget;
            }
            return null;
        }

        public void updateTimes() {
            boolean bl = true;
            if (PopupCalendarPanel.this.value == null) {
                PopupCalendarPanel.this.value = new Date();
                bl = false;
            }
            if (this.getDateTimeService().isTwelveHourClock()) {
                int n = PopupCalendarPanel.this.value.getHours();
                this.ampm.setSelectedIndex(n < 12 ? 0 : 1);
                this.hours.setSelectedIndex(n -= this.ampm.getSelectedIndex() * 12);
            } else {
                this.hours.setSelectedIndex(PopupCalendarPanel.this.value.getHours());
            }
            if (PopupCalendarPanel.this.getResolution().getCalendarField() >= Resolution.MINUTE.getCalendarField()) {
                this.mins.setSelectedIndex(PopupCalendarPanel.this.value.getMinutes());
            }
            if (PopupCalendarPanel.this.getResolution().getCalendarField() >= Resolution.SECOND.getCalendarField()) {
                this.sec.setSelectedIndex(PopupCalendarPanel.this.value.getSeconds());
            }
            if (this.getDateTimeService().isTwelveHourClock()) {
                this.ampm.setSelectedIndex(PopupCalendarPanel.this.value.getHours() < 12 ? 0 : 1);
            }
            this.hours.setEnabled(PopupCalendarPanel.this.isEnabled());
            if (this.mins != null) {
                this.mins.setEnabled(PopupCalendarPanel.this.isEnabled());
            }
            if (this.sec != null) {
                this.sec.setEnabled(PopupCalendarPanel.this.isEnabled());
            }
            if (this.ampm != null) {
                this.ampm.setEnabled(PopupCalendarPanel.this.isEnabled());
            }
        }

        private int getMilliseconds() {
            return DateTimeService.getMilliseconds((Date)PopupCalendarPanel.this.value);
        }

        private DateTimeService getDateTimeService() {
            if (PopupCalendarPanel.this.dateTimeService == null) {
                PopupCalendarPanel.this.dateTimeService = new DateTimeService();
            }
            return PopupCalendarPanel.this.dateTimeService;
        }

        public void onChange(ChangeEvent changeEvent) {
            if (changeEvent.getSource() == this.hours) {
                int n = this.hours.getSelectedIndex();
                if (this.getDateTimeService().isTwelveHourClock()) {
                    n += this.ampm.getSelectedIndex() * 12;
                }
                PopupCalendarPanel.this.value.setHours(n);
                if (PopupCalendarPanel.this.timeChangeListener != null) {
                    PopupCalendarPanel.this.timeChangeListener.changed(n, PopupCalendarPanel.this.value.getMinutes(), PopupCalendarPanel.this.value.getSeconds(), DateTimeService.getMilliseconds((Date)PopupCalendarPanel.this.value));
                }
                changeEvent.preventDefault();
                changeEvent.stopPropagation();
            } else if (changeEvent.getSource() == this.mins) {
                int n = this.mins.getSelectedIndex();
                PopupCalendarPanel.this.value.setMinutes(n);
                if (PopupCalendarPanel.this.timeChangeListener != null) {
                    PopupCalendarPanel.this.timeChangeListener.changed(PopupCalendarPanel.this.value.getHours(), n, PopupCalendarPanel.this.value.getSeconds(), DateTimeService.getMilliseconds((Date)PopupCalendarPanel.this.value));
                }
                changeEvent.preventDefault();
                changeEvent.stopPropagation();
            } else if (changeEvent.getSource() == this.sec) {
                int n = this.sec.getSelectedIndex();
                PopupCalendarPanel.this.value.setSeconds(n);
                if (PopupCalendarPanel.this.timeChangeListener != null) {
                    PopupCalendarPanel.this.timeChangeListener.changed(PopupCalendarPanel.this.value.getHours(), PopupCalendarPanel.this.value.getMinutes(), n, DateTimeService.getMilliseconds((Date)PopupCalendarPanel.this.value));
                }
                changeEvent.preventDefault();
                changeEvent.stopPropagation();
            } else if (changeEvent.getSource() == this.ampm) {
                int n = this.hours.getSelectedIndex() + this.ampm.getSelectedIndex() * 12;
                PopupCalendarPanel.this.value.setHours(n);
                if (PopupCalendarPanel.this.timeChangeListener != null) {
                    PopupCalendarPanel.this.timeChangeListener.changed(n, PopupCalendarPanel.this.value.getMinutes(), PopupCalendarPanel.this.value.getSeconds(), DateTimeService.getMilliseconds((Date)PopupCalendarPanel.this.value));
                }
                changeEvent.preventDefault();
                changeEvent.stopPropagation();
            }
        }
    }

    private class VEventButton
    extends Button {
        public VEventButton(PopupCalendarPanel popupCalendarPanel) {
            this.addMouseDownHandler(popupCalendarPanel);
            this.addMouseOutHandler(popupCalendarPanel);
            this.addMouseUpHandler(popupCalendarPanel);
        }
    }

    public static interface FocusChangeListener {
        public void focusChanged(Date var1);
    }

    public static interface SubmitListener {
        public void onSubmit();

        public void onCancel();
    }

    public static interface FocusOutListener {
        public boolean onFocusOut(DomEvent<?> var1);
    }

    public static interface TimeChangeListener {
        public void changed(int var1, int var2, int var3, int var4);
    }
}

