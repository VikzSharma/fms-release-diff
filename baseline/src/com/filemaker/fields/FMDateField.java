/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.event.FieldEvents$BlurEvent
 *  com.vaadin.event.FieldEvents$BlurListener
 *  com.vaadin.event.FieldEvents$BlurNotifier
 *  com.vaadin.event.FieldEvents$FocusNotifier
 *  com.vaadin.event.SerializableEventListener
 *  com.vaadin.shared.Registration
 *  com.vaadin.v7.data.Property
 *  com.vaadin.v7.data.Validator$InvalidValueException
 *  com.vaadin.v7.shared.ui.datefield.Resolution
 *  com.vaadin.v7.ui.DateField$UnparsableDateString
 */
package com.filemaker.fields;

import com.filemaker.fields.FMField;
import com.filemaker.fields.client.datefield.PopupDateFieldClientRpc;
import com.filemaker.fields.client.datefield.PopupDateFieldServerRpc;
import com.filemaker.fields.client.datefield.PopupDateFieldState;
import com.filemaker.fields.interfaces.DatePresenter;
import com.filemaker.fields.interfaces.DateProvider;
import com.filemaker.fields.interfaces.DefaultPopupDateFieldActionHandler;
import com.filemaker.fields.interfaces.PopupDateFieldActionHandler;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.vaadin.event.FieldEvents;
import com.vaadin.event.SerializableEventListener;
import com.vaadin.shared.Registration;
import com.vaadin.v7.data.Property;
import com.vaadin.v7.data.Validator;
import com.vaadin.v7.shared.ui.datefield.Resolution;
import com.vaadin.v7.ui.DateField;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public abstract class FMDateField
extends FMField<String>
implements FieldEvents.BlurNotifier,
FieldEvents.FocusNotifier,
DatePresenter {
    private transient Calendar calendar;
    private boolean lenient = false;
    private boolean validateDates = true;
    private boolean uiHasValidDateString = true;
    private String currentParseErrorMessage;
    private String defaultParseErrorMessage = "Date format not recognized";
    private TimeZone timeZone = null;
    private DateProvider dateProvider = null;
    protected boolean calendarOpen = false;
    protected boolean valid = true;
    protected Resolution resolution = Resolution.DAY;
    protected Date rangeStart = null;
    protected Date rangeEnd = null;
    protected PopupDateFieldActionHandler actionHandler = new DefaultPopupDateFieldActionHandler();
    private final PopupDateFieldServerRpc serverRpc = new PopupDateFieldServerRpc(){

        @Override
        public void onCalendarPopupRequest(String string) {
            if (!FMDateField.this.isReadOnly() && FMDateField.this.isEnabled()) {
                FMDateField.this.getPopupDateFieldActionHandler().onCalendarPopupClicked(FMDateField.this, string);
            }
        }

        @Override
        public void onUserInput(String string) {
            FMDateField.this.getState().text = string;
            FMDateField.this.setValue(string, false);
        }

        @Override
        public void onDatePicked(Map<Resolution, Integer> map) {
            Calendar calendar = FMDateField.this.getCalendar();
            calendar.set(2010, 0, 1, 0, 0, 0);
            for (Resolution resolution : Resolution.getResolutionsHigherOrEqualTo((Resolution)FMDateField.this.resolution)) {
                calendar.set(resolution.getCalendarField(), map.get(resolution));
            }
            Date date = calendar.getTime();
            FMDateField.this.dateProvider.handlePopupSelection(date);
        }

        @Override
        public void onCalendarPopupOpen(boolean bl) {
            FMDateField.this.calendarOpen = bl;
        }
    };

    public FMDateField() {
        this.initBooleanState();
        this.registerRpc(this.serverRpc, PopupDateFieldServerRpc.class);
    }

    public FMDateField(String string) {
        this();
        this.setCaption(string);
    }

    public FMDateField(String string, Property property) {
        this(property);
        this.setCaption(string);
    }

    public FMDateField(Property property) throws IllegalArgumentException {
        if (!Date.class.isAssignableFrom(property.getType())) {
            throw new IllegalArgumentException("Can't use " + property.getType().getName() + " typed property as datasource");
        }
        super.setNewLineAllowed(false);
        this.registerRpc(this.serverRpc, PopupDateFieldServerRpc.class);
        if (!String.class.isAssignableFrom(property.getType())) {
            throw new IllegalArgumentException("Can't use " + property.getType().getName() + " typed property as datasource");
        }
        this.setPropertyDataSource(property);
    }

    public void setCalendarIconVisible(boolean bl) {
        this.updateBooleanState(PopupDateFieldState.BooleanState.calendarIconVisible, bl);
    }

    public boolean isCalendarIconVisible() {
        return this.getBooleanState(PopupDateFieldState.BooleanState.calendarIconVisible);
    }

    public void showCalendarPopup(String string) {
        Date date = this.getDateProvider().convertValueToDate(string);
        this.showCalendarPopup(date != null ? date : new Date());
    }

    protected Map<Resolution, Integer> getDateMap(Date date) {
        if (date == null) {
            return null;
        }
        Calendar calendar = this.getCalendar();
        calendar.setTime(date);
        HashMap<Resolution, Integer> hashMap = new HashMap<Resolution, Integer>();
        for (Resolution resolution : Resolution.getResolutionsHigherOrEqualTo((Resolution)this.resolution)) {
            int n = calendar.get(resolution.getCalendarField());
            if (resolution == Resolution.MONTH) {
                ++n;
            }
            hashMap.put(resolution, n);
        }
        return hashMap;
    }

    @Override
    public void showCalendarPopup(Date date) {
        if (date == null) {
            date = new Date();
        }
        Map<Resolution, Integer> map = this.getDateMap(date);
        Map<Resolution, Integer> map2 = this.getDateMap(this.getRangeStart());
        Map<Resolution, Integer> map3 = this.getDateMap(this.getRangeEnd());
        this.startEdit();
        ((PopupDateFieldClientRpc)this.getRpcProxy(PopupDateFieldClientRpc.class)).showCalendarPopup(map, this.resolution, map2, map3);
    }

    public void hideCalendarPopup() {
        ((PopupDateFieldClientRpc)this.getRpcProxy(PopupDateFieldClientRpc.class)).hideCalendarPopup();
    }

    public boolean isCalendarPopupShown() {
        return this.calendarOpen;
    }

    public boolean isValidateDates() {
        return this.validateDates;
    }

    public void setValidateDates(boolean bl) {
        this.validateDates = bl;
    }

    protected boolean shouldHideErrors() {
        return super.shouldHideErrors() && this.uiHasValidDateString;
    }

    @Override
    protected PopupDateFieldState getState() {
        return (PopupDateFieldState)super.getState();
    }

    @Override
    protected PopupDateFieldState getState(boolean bl) {
        return (PopupDateFieldState)super.getState(bl);
    }

    public Class<String> getType() {
        return String.class;
    }

    @Override
    public Resolution getResolution() {
        return this.resolution;
    }

    @Override
    public void setResolution(Resolution resolution) {
        this.resolution = resolution;
    }

    public void setLenient(boolean bl) {
        this.lenient = bl;
        this.markAsDirty();
    }

    public boolean isLenient() {
        return this.lenient;
    }

    public Registration addBlurListener(FieldEvents.BlurListener blurListener) {
        return super.addListener("blur", FieldEvents.BlurEvent.class, (SerializableEventListener)blurListener, FieldEvents.BlurListener.blurMethod);
    }

    public void validate() throws Validator.InvalidValueException {
        if (!this.uiHasValidDateString) {
            throw new DateField.UnparsableDateString(this.currentParseErrorMessage);
        }
        super.validate();
    }

    public String getParseErrorMessage() {
        return this.defaultParseErrorMessage;
    }

    public void setParseErrorMessage(String string) {
        this.defaultParseErrorMessage = string;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
        this.markAsDirty();
    }

    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    public void beforeClientResponse(boolean bl) {
        super.beforeClientResponse(bl);
        this.getState().text = this.getValue() != null ? (String)this.getValue() : "";
        Locale locale = this.getLocale();
        this.getState().locale = locale != null ? locale.toString() : null;
    }

    @Override
    public void setDateProvider(DateProvider dateProvider) {
        this.dateProvider = dateProvider;
    }

    @Override
    public DateProvider getDateProvider() {
        return this.dateProvider;
    }

    public PopupDateFieldActionHandler getPopupDateFieldActionHandler() {
        return this.actionHandler;
    }

    public void setPopupDateFieldActionHandler(PopupDateFieldActionHandler popupDateFieldActionHandler) {
        this.actionHandler = popupDateFieldActionHandler;
    }

    public void detach() {
        this.calendarOpen = false;
        super.detach();
    }

    @Override
    public void setRangeStart(Date date) {
        this.rangeStart = date;
    }

    @Override
    public void setRangeEnd(Date date) {
        this.rangeEnd = date;
    }

    @Override
    public Date getRangeStart() {
        return this.rangeStart;
    }

    @Override
    public Date getRangeEnd() {
        return this.rangeEnd;
    }

    private Calendar getCalendar() {
        if (this.calendar == null) {
            this.calendar = Calendar.getInstance();
            for (Resolution resolution : Resolution.getResolutionsLowerThan((Resolution)this.resolution)) {
                int n = resolution.getCalendarField();
                int n2 = this.calendar.getActualMinimum(n);
                this.calendar.set(n, n2);
            }
            this.calendar.set(14, 0);
        }
        Calendar calendar = (Calendar)this.calendar.clone();
        TimeZone timeZone = this.getTimeZone();
        if (timeZone != null) {
            calendar.setTimeZone(timeZone);
        }
        return calendar;
    }

    public boolean isValid() {
        if (!this.valid) {
            return false;
        }
        return super.isValid();
    }

    public void setImmediate(boolean bl) {
        if (!bl) {
            throw new IllegalStateException("This field only supports immediate mode");
        }
    }

    public boolean isImmediate() {
        return true;
    }

    public abstract void onIconClicked(String var1);

    private void initBooleanState() {
        this.setNewLineAllowed(false);
        this.setCalendarIconVisible(true);
    }

    private void updateBooleanState(PopupDateFieldState.BooleanState booleanState, boolean bl) {
        this.getState().pdbs = IWPUtilities.applyBooleanValue(this.getState().pdbs, booleanState.ordinal(), bl);
    }

    private boolean getBooleanState(PopupDateFieldState.BooleanState booleanState) {
        return IWPUtilities.getBooleanValue(this.getState((boolean)false).pdbs, booleanState.ordinal());
    }
}

