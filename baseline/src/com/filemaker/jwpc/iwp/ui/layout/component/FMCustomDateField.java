/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.event.FieldEvents$FocusListener
 *  com.vaadin.shared.Registration
 *  com.vaadin.shared.ui.ContentMode
 *  com.vaadin.ui.Component
 *  com.vaadin.ui.UI
 */
package com.filemaker.jwpc.iwp.ui.layout.component;

import com.filemaker.fields.FMDateField;
import com.filemaker.fields.client.common.FMClientRpc;
import com.filemaker.fields.client.common.FocusMode;
import com.filemaker.fields.interfaces.DateProvider;
import com.filemaker.jwpc.iwp.action.GlobalUIActionHandlers;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.metadata.ObjectMetaData;
import com.filemaker.jwpc.iwp.notification.processor.BrowserInfoHandler;
import com.filemaker.jwpc.iwp.thrift.common.DBAccessLevel;
import com.filemaker.jwpc.iwp.thrift.common.DateOrder;
import com.filemaker.jwpc.iwp.thrift.common.DateTime;
import com.filemaker.jwpc.iwp.thrift.common.LayoutFieldDataType;
import com.filemaker.jwpc.iwp.ui.event.UIEvent;
import com.filemaker.jwpc.iwp.ui.layout.LayoutContainerObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutFieldObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutTextFieldObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutView;
import com.filemaker.jwpc.iwp.ui.layout.ObjectAttributes;
import com.filemaker.jwpc.iwp.ui.layout.component.AbsoluteCssLayout;
import com.filemaker.jwpc.iwp.ui.layout.component.LayoutTextFieldObjectDelegate;
import com.filemaker.jwpc.iwp.ui.layout.component.StringDataUpdateParameters;
import com.filemaker.jwpc.iwp.ui.layout.component.repetition.RepetitionContainer;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.TextFieldServerRpc;
import com.filemaker.jwpc.iwp.widgetset.client.state.FMCustomDateFieldState;
import com.vaadin.event.FieldEvents;
import com.vaadin.shared.Registration;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Component;
import com.vaadin.ui.UI;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;

public class FMCustomDateField
extends FMDateField
implements LayoutTextFieldObject {
    private final App app;
    private final LayoutView layoutView;
    private LayoutTextFieldObjectDelegate delegate;
    private LayoutObject parent;
    private Date valueAsDate;
    private boolean hideConditionOn = false;
    private boolean hasPendingClick = false;
    private boolean pendingNavigationFocus;

    public FMCustomDateField(App app, LayoutView layoutView, ObjectMetaData objectMetaData, ObjectAttributes objectAttributes) {
        this.app = app;
        this.layoutView = layoutView;
        this.delegate = new LayoutTextFieldObjectDelegate(app, layoutView, this, objectMetaData, objectAttributes);
        this.delegate.setWidthAndHeight(this);
        this.setTimeZone(IWPUtilities.getBrowserTimeZone(this.app.getWebBrowser().getTimezoneOffset()));
        this.setDateProvider(new FMCustomDateProvider(this.layoutView.getLayoutMetaData().getDateFormat()));
        this.registerEditBoxRpc();
        this.initUI();
        this.delegate.initialized = true;
    }

    protected void updateAccess(boolean bl) {
        boolean bl2 = !bl;
        this.setReadOnly(bl2);
    }

    private void initUI() {
        super.setTabIndex(-1);
        this.delegate.init(this);
        this.setImmediate(true);
        this.setWordwrap(this.delegate.useWordwrap());
        this.setNewLineAllowed(this.delegate.allowNewLine());
        this.setSelectContentsOnEdit(true);
        this.showScrollbarsOnTextOverflow(false);
        if (this.getMetaData().hasValidAndExecutableScript() || this.delegate.waitForServerOnEnter()) {
            this.setFocusMode(FocusMode.DEFERRED);
        } else {
            this.setFocusMode(FocusMode.INSTANT);
        }
        this.setLocale(this.delegate.getApp().getWebBrowser().getLocale());
        this.setCalendarIconVisible(this.getMetaData().hasIcon());
        this.setClentSideAutoSizing(this.layoutView.isClientSideAutoSizing());
        this.updateKeyboardType(this.delegate.getMetaData().getTouchKeyboardType());
    }

    @Override
    public void detach() {
        if (this.delegate != null && this.delegate.currentText != null) {
            this.setValue(this.delegate.currentText);
            this.valueAsDate = this.getDateProvider().convertValueToDate(this.delegate.currentText);
        }
        super.detach();
    }

    @Override
    public void cleanupMemory() {
        if (this.delegate != null) {
            this.delegate.cleanupMemory();
            this.delegate = null;
        }
    }

    @Override
    public Component getWrappedObject() {
        Component component = this.delegate.getWrappedObject();
        if (component == null) {
            component = this;
        }
        return component;
    }

    private void registerEditBoxRpc() {
        TextFieldServerRpc textFieldServerRpc = new TextFieldServerRpc(){

            @Override
            public void onTabPress(boolean bl, String string) {
                FMCustomDateField.this.onTabPress(bl, string);
            }

            @Override
            public void onTextChange(String string, boolean bl) {
                FMCustomDateField.this.onTextChange(string, bl);
            }

            @Override
            public void enterField() {
                FMCustomDateField.this.hasPendingClick = false;
                FMCustomDateField.this.onFieldObjectClick();
            }

            @Override
            public void printthis(String string) {
                System.out.println("[CLIENT DEBUG - " + FMCustomDateField.this.getUniqueId() + " ] " + string);
            }

            @Override
            public void onEnterPress(boolean bl, String string) {
                FMCustomDateField.this.onEnterPress(bl, string);
            }

            @Override
            public void onBrowserResize(int n, int n2, String string) {
                FMCustomDateField.this.onBrowserResize(n, n2, string);
            }

            @Override
            public void checkNavigationFocus() {
                FMCustomDateField.this.checkNavigationFocus();
            }

            @Override
            public void setPendingNavigationFocus() {
                FMCustomDateField.this.pendingNavigationFocus = true;
            }

            @Override
            public void onKeystroke(String string, int n, boolean bl) {
            }

            @Override
            public void onShowContextMenu(int n, int n2, int n3) {
                FMCustomDateField.this.onFieldObjectClick();
                FMCustomDateField.this.updatedFieldContextMenuState(n3);
                FMCustomDateField.this.showContextMenu(n, n2);
            }
        };
        this.registerRpc(textFieldServerRpc);
    }

    protected void updatedFieldContextMenuState(int n) {
        App app = this.delegate.getApp();
        app.getAppView().updatedFieldContextMenuState(this, n);
    }

    @Override
    public void showContextMenu(int n, int n2) {
        App app = this.delegate.getApp();
        app.positionContextMenu(n, n2, this);
        app.showContextMenu(this);
    }

    private void onTabPress(boolean bl, String string) {
        this.delegate.onTabPress(bl, string);
    }

    @Override
    public void onTextChange(String string, boolean bl) {
        this.delegate.onTextChange(string, bl);
    }

    private void onEnterPress(boolean bl, String string) {
        this.delegate.onEnterPress(bl, string);
    }

    private void onBrowserResize(int n, int n2, String string) {
        this.delegate.onBrowserResize(n, n2, string);
    }

    public void reset() {
        this.hasPendingClick = false;
        this.delegate.reset();
    }

    @Override
    public DBAccessLevel getAccess() {
        return this.delegate.getAccess();
    }

    public boolean hasDataEntryHandler() {
        return this.delegate.hasDataEntryHandler();
    }

    @Override
    public FMCustomDateFieldState getState() {
        return (FMCustomDateFieldState)super.getState();
    }

    @Override
    public void beforeClientResponse(boolean bl) {
        super.beforeClientResponse(bl);
        this.updateBooleanState(FMCustomDateFieldState.BooleanState.hasScript, this.getMetaData().hasValidAndExecutableScript());
        this.updateBooleanState(FMCustomDateFieldState.BooleanState.hasTooltip, this.getDescription() != null && this.getDescription().length() > 0);
        this.updateBooleanState(FMCustomDateFieldState.BooleanState.hasModifyTrigger, this.getMetaData().hasModifyTrigger());
        this.updateBooleanState(FMCustomDateFieldState.BooleanState.waitForServerOnEnter, this.delegate.waitForServerOnEnter());
        this.updateBooleanState(FMCustomDateFieldState.BooleanState.waitForServerOnExit, this.waitForServerOnExit());
        this.updateBooleanState(FMCustomDateFieldState.BooleanState.exitOnTAB, this.getMetaData().getExitOnTAB());
        this.updateBooleanState(FMCustomDateFieldState.BooleanState.exitOnRETURN, this.getMetaData().getExitOnRETURN());
        this.updateBooleanState(FMCustomDateFieldState.BooleanState.exitOnENTER, this.getMetaData().getExitOnENTER());
        this.updateBooleanState(FMCustomDateFieldState.BooleanState.isNumberField, this.getMetaData().getFieldDataType() == LayoutFieldDataType.NUMBER);
        this.getState().hasPortalFocus = this.delegate.getApp().getActiveUIHandler().isActiveObject(this) && this.delegate.getAttributes().getOwningPortal() != null;
    }

    private void updateBooleanState(FMCustomDateFieldState.BooleanState booleanState, boolean bl) {
        this.getState().cdbs = IWPUtilities.applyBooleanValue(this.getState().cdbs, booleanState.ordinal(), bl);
    }

    @Override
    public void setGlassPaneParent(AbsoluteCssLayout absoluteCssLayout) {
        this.delegate.setGlassPaneParent(absoluteCssLayout);
    }

    @Override
    public boolean allowGlassPaneActivation() {
        return this.delegate.allowGlassPaneActivation();
    }

    @Override
    public void updateDataEntry(DBAccessLevel dBAccessLevel, boolean bl) {
        this.delegate.updateDataEntry(dBAccessLevel, bl);
    }

    @Override
    public int getObjectId() {
        return this.getMetaData().getObjectId();
    }

    @Override
    public String getUniqueId() {
        return this.getId();
    }

    @Override
    public void updateUniqueId() {
        String string = this.getUniqueId();
        String string2 = IWPUtilities.generateUniqueId(this.delegate.getApp(), this);
        if (!string2.equals(string)) {
            this.setId(string2);
            this.delegate.resetNegativeNumberAttributes();
        }
    }

    @Override
    public ObjectAttributes getAttributes() {
        return this.delegate.getAttributes();
    }

    @Override
    public ObjectMetaData getMetaData() {
        return this.delegate != null ? this.delegate.getMetaData() : null;
    }

    @Override
    public void setParentComponent(LayoutContainerObject layoutContainerObject) {
        this.parent = layoutContainerObject;
    }

    @Override
    public LayoutObject getParentComponent() {
        return this.parent;
    }

    @Override
    public Object getFieldData() {
        return this.delegate.currentText != null ? this.delegate.currentText : this.getValue();
    }

    @Override
    public synchronized void updateLayoutObjectData(Object object, boolean bl) {
        throw new UnsupportedOperationException();
    }

    @Override
    public synchronized void updateFieldObjectData(StringDataUpdateParameters stringDataUpdateParameters, boolean bl) {
        if (!stringDataUpdateParameters.hasError()) {
            this.updateDataEntry(stringDataUpdateParameters.getAccess(), false);
            this.delegate.updateFieldObjectData(stringDataUpdateParameters, bl);
            boolean bl2 = this.isReadOnly();
            boolean bl3 = this.isEnabled();
            this.setReadOnly(false);
            this.setEnabled(true);
            this.setValue(stringDataUpdateParameters.getData().getValue());
            if (stringDataUpdateParameters.getData().isValidDate()) {
                GregorianCalendar gregorianCalendar = new GregorianCalendar(stringDataUpdateParameters.getData().getDateValue().getYear(), stringDataUpdateParameters.getData().getDateValue().getMonth() - 1, stringDataUpdateParameters.getData().getDateValue().getDay());
                ((Calendar)gregorianCalendar).setTimeZone(this.getTimeZone());
                this.valueAsDate = gregorianCalendar.getTime();
            } else {
                this.valueAsDate = null;
            }
            this.setReadOnly(bl2);
            this.setEnabled(bl3);
            this.markAsDirty();
        } else {
            this.disableAccess();
            this.delegate.updateFieldObjectData(stringDataUpdateParameters, bl);
            this.valueAsDate = null;
        }
    }

    private void disableAccess() {
        this.delegate.disableAccess();
    }

    public boolean enableAccess() {
        return this.delegate.enableAccess();
    }

    @Override
    public void addRepetitionObject(RepetitionContainer repetitionContainer, String string) {
        this.delegate.getWrappedObject().addStyleName(string);
        this.delegate.setRepetition(repetitionContainer);
        this.delegate.setRepetition(repetitionContainer);
    }

    @Override
    public LayoutFieldObject getRepetitionObject(short s) {
        if (this.getMetaData().getRepetitionCount() == 1) {
            return this;
        }
        return this.delegate.getRepetition().getRepetitionObjects().get(s);
    }

    @Override
    public Collection<LayoutFieldObject> getAllRepetitionObjects() {
        if (this.getMetaData().getRepetitionCount() == 1) {
            ArrayList<LayoutFieldObject> arrayList = new ArrayList<LayoutFieldObject>();
            arrayList.add(this);
            return arrayList;
        }
        return this.delegate.getRepetition().getRepetitionObjects().values();
    }

    @Override
    public void onEvent(UIEvent uIEvent) {
        switch (uIEvent.getType()) {
            case RESET_FIELD_OBJECT: {
                if (!this.delegate.getApp().isFormView()) break;
                this.delegate.currentText = null;
                break;
            }
        }
    }

    @Override
    public void registerToolTip(String string) {
        this.setDescription(string, ContentMode.HTML);
    }

    @Override
    public void insertData(String string) {
        this.delegate.insertData(string);
    }

    @Override
    public boolean hasHideCondition() {
        return this.getMetaData().hasHideCondition();
    }

    @Override
    public boolean hasHideConditionInFindMode() {
        return this.getMetaData().hasHideConditionInFindMode();
    }

    @Override
    public boolean isHideConditionOn() {
        return this.hideConditionOn;
    }

    @Override
    public void setHideConditionOn(boolean bl) {
        this.hideConditionOn = bl;
    }

    @Override
    public void onActive() {
        if (this.delegate.getApp().getActiveUIHandler().shouldNotifyClientOfActiveState()) {
            if (this.hasPendingClick) {
                if (this.valueAsDate != null) {
                    this.showCalendarPopup(this.valueAsDate);
                } else {
                    this.showCalendarPopup((String)this.getValue());
                }
            } else {
                this.startEdit();
            }
        }
        this.hasPendingClick = false;
    }

    @Override
    public void onInactive() {
        this.hideCalendarPopup();
    }

    @Override
    public void addCFStyle(String string) {
        this.delegate.addCFStyle(string);
    }

    @Override
    public void removeCFStyle(String string) {
        this.delegate.removeCFStyle(string);
    }

    @Override
    public void onIconClicked(String string) {
        if (!this.delegate.getApp().getActiveUIHandler().isActiveObject(this)) {
            if (this.delegate.waitForServerOnEnter()) {
                this.hasPendingClick = true;
            } else {
                this.showCalendarPopup(string);
                this.hasPendingClick = false;
            }
            this.onFieldObjectClick();
        } else {
            if (this.getMetaData().hasDataFormatting()) {
                this.showCalendarPopup((String)this.getValue());
            } else {
                this.showCalendarPopup(string);
            }
            this.hasPendingClick = false;
        }
    }

    @Override
    public void onFieldObjectClick() {
        if (this.delegate.getApp().isTouchUI() && this.delegate.getApp().isFormView() && UI.getCurrent() != null) {
            UI.getCurrent().scrollIntoView((Component)this);
        }
        this.pendingNavigationFocus = false;
        this.delegate.onFieldObjectClick();
    }

    private boolean waitForServerOnExit() {
        return !this.delegate.allowClientSideTabbing() || this.getMetaData().hasModifyTrigger() || this.getMetaData().hasExitTriggers() || this.getMetaData().hasValidation() || this.getMetaData().hasDataFormatting();
    }

    public void setTabIndex(int n) {
        super.setTabIndex(-1);
    }

    @Override
    public void setPlaceholderText(String string) {
        this.setInputPrompt(string);
    }

    @Override
    public void setTextValue(String string) {
        super.setValue((Object)string);
        this.valueAsDate = this.getDateProvider().convertValueToDate(this.delegate.currentText);
    }

    @Override
    public String getTextValue() {
        return (String)super.getValue();
    }

    @Override
    public void setHideZeroesOn(boolean bl) {
        if (this.getMetaData().getFieldDataType() == LayoutFieldDataType.NUMBER) {
            this.updateBooleanState(FMCustomDateFieldState.BooleanState.hideZeroesOn, bl);
        }
    }

    @Override
    public void performModify() {
        ((FMClientRpc)this.getRpcProxy(FMClientRpc.class)).performModify();
    }

    public void checkNavigationFocus() {
        if (this.delegate != null && BrowserInfoHandler.isiOSDevice(this.delegate.getApp()) && !this.delegate.isActive() && this.pendingNavigationFocus) {
            ((FMClientRpc)this.getRpcProxy(FMClientRpc.class)).performNavigationFocus();
        }
    }

    private void setClentSideAutoSizing(boolean bl) {
        this.updateBooleanState(FMCustomDateFieldState.BooleanState.CLIENT_SIDE_AUTO_SIZING, bl);
    }

    @Override
    public boolean hasDelegate() {
        return this.delegate != null;
    }

    public Registration addFocusListener(FieldEvents.FocusListener focusListener) {
        return null;
    }

    @Override
    public void setValue(String string) {
    }

    @Override
    public void setTextValue(String string, Boolean bl) {
    }

    @Override
    public void cacheSelectionOnCommit() {
        this.delegate.cacheSelectionOnCommit();
    }

    @Override
    public void syncSelectionOnCommitFailure() {
        this.delegate.syncSelectionOnCommitFailure();
    }

    @Override
    public void registerAccTitle(String string) {
        this.setCaption(string);
        this.addStyleName("sr-only-caption-title-and-help");
    }

    @Override
    public void registerAccHelp(String string) {
    }

    @Override
    public void registerAccLabel(String string) {
    }

    private class FMCustomDateProvider
    implements DateProvider {
        private final DateOrder dateFormat;

        public FMCustomDateProvider(DateOrder dateOrder) {
            this.dateFormat = dateOrder;
        }

        @Override
        public Date convertValueToDate(String string) {
            if (string == null || string.isEmpty()) {
                return null;
            }
            Date date = null;
            try {
                String[] stringArray = Pattern.compile("\\D").split(string);
                if (stringArray != null && stringArray.length >= 3) {
                    int n = 0;
                    int n2 = 0;
                    int n3 = 0;
                    int n4 = Integer.parseInt(stringArray[0]);
                    int n5 = Integer.parseInt(stringArray[1]);
                    int n6 = Integer.parseInt(stringArray[2]);
                    switch (this.dateFormat) {
                        case DATEORDER_MYD: {
                            n = n4;
                            n3 = n5;
                            n2 = n6;
                            break;
                        }
                        case DATEORDER_DMY: {
                            n2 = n4;
                            n = n5;
                            n3 = n6;
                            break;
                        }
                        case DATEORDER_DYM: {
                            n2 = n4;
                            n3 = n5;
                            n = n6;
                            break;
                        }
                        case DATEORDER_YMD: {
                            n3 = n4;
                            n = n5;
                            n2 = n6;
                            break;
                        }
                        case DATEORDER_YDM: {
                            n3 = n4;
                            n2 = n5;
                            n = n6;
                            break;
                        }
                        default: {
                            n = n4;
                            n2 = n5;
                            n3 = n6;
                        }
                    }
                    if (this.validateDate(n, n2, n3)) {
                        GregorianCalendar gregorianCalendar = new GregorianCalendar(n3, n - 1, n2);
                        ((Calendar)gregorianCalendar).setTimeZone(FMCustomDateField.this.getTimeZone());
                        date = gregorianCalendar.getTime();
                    }
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
            return date;
        }

        private boolean validateDate(int n, int n2, int n3) {
            if (n < 1 || n > 12) {
                return false;
            }
            if (n2 < 1 || n2 > 31) {
                return false;
            }
            return n3 >= 1;
        }

        @Override
        public void handlePopupSelection(Date date) {
            if (date == null) {
                throw new IllegalStateException("Null date selection shouldn't happen");
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeZone(FMCustomDateField.this.getTimeZone());
            calendar.setTime(date);
            int n = calendar.get(1);
            int n2 = calendar.get(2) + 1;
            int n3 = calendar.get(5);
            Date date2 = FMCustomDateField.this.delegate.getApp().getPage().getWebBrowser().getCurrentDate();
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTimeZone(FMCustomDateField.this.getTimeZone());
            calendar2.setTime(date2);
            int n4 = calendar2.get(11);
            int n5 = calendar2.get(12);
            int n6 = calendar2.get(13);
            DateTime dateTime = new DateTime(n2, n3, n, n4, n5, n6);
            GlobalUIActionHandlers.INSERT_DATE_FROM_CALENDAR.perform(FMCustomDateField.this.app, new Object[]{FMCustomDateField.this, dateTime});
        }
    }
}

