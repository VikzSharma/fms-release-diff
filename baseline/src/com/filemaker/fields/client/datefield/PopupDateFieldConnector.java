/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.Scheduler
 *  com.google.gwt.core.client.Scheduler$ScheduledCommand
 *  com.google.gwt.event.dom.client.BlurEvent
 *  com.google.gwt.event.dom.client.FocusEvent
 *  com.google.gwt.user.client.Timer
 *  com.vaadin.client.BrowserInfo
 *  com.vaadin.client.communication.StateChangeEvent
 *  com.vaadin.shared.ui.Connect
 *  com.vaadin.v7.shared.ui.datefield.Resolution
 */
package com.filemaker.fields.client.datefield;

import com.filemaker.fields.FMDateField;
import com.filemaker.fields.client.common.FMConnector;
import com.filemaker.fields.client.datefield.PopupDateFieldClientRpc;
import com.filemaker.fields.client.datefield.PopupDateFieldServerRpc;
import com.filemaker.fields.client.datefield.PopupDateFieldState;
import com.filemaker.fields.client.datefield.PopupDateFieldWidget;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.user.client.Timer;
import com.vaadin.client.BrowserInfo;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.shared.ui.Connect;
import com.vaadin.v7.shared.ui.datefield.Resolution;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Connect(value=FMDateField.class)
public class PopupDateFieldConnector
extends FMConnector {
    private Runnable deferredCalendarShowAction;
    private Timer requestTimer = new Timer(){

        public void run() {
            if (BrowserInfo.get().isIE()) {
                Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand(){

                    public void execute() {
                        ((PopupDateFieldServerRpc)PopupDateFieldConnector.this.getRpcProxy(PopupDateFieldServerRpc.class)).onCalendarPopupRequest(PopupDateFieldConnector.this.getWidget().getText());
                    }
                });
            } else {
                ((PopupDateFieldServerRpc)PopupDateFieldConnector.this.getRpcProxy(PopupDateFieldServerRpc.class)).onCalendarPopupRequest(PopupDateFieldConnector.this.getWidget().getText());
            }
        }
    };
    private final PopupDateFieldWidget.PopupDateFieldListener widgetListener = new PopupDateFieldWidget.PopupDateFieldListener(){

        @Override
        public void onDateSelected(Date date) {
            ((PopupDateFieldServerRpc)PopupDateFieldConnector.this.getRpcProxy(PopupDateFieldServerRpc.class)).onDatePicked(PopupDateFieldConnector.this.dateToMap(date));
        }

        @Override
        public void onUserInputChange(String string) {
            if (!string.equals(PopupDateFieldConnector.this.getState().text)) {
                ((PopupDateFieldServerRpc)PopupDateFieldConnector.this.getRpcProxy(PopupDateFieldServerRpc.class)).onUserInput(string);
            }
        }

        @Override
        public void onCalendarPopupRequested() {
            PopupDateFieldConnector.this.clearRequestTimer();
            PopupDateFieldConnector.this.requestTimer.schedule(200);
        }

        @Override
        public void onCalendarPopupVisibilityChange(boolean bl) {
            ((PopupDateFieldServerRpc)PopupDateFieldConnector.this.getRpcProxy(PopupDateFieldServerRpc.class)).onCalendarPopupOpen(bl);
        }
    };
    private final PopupDateFieldClientRpc clientRpc = new PopupDateFieldClientRpc(){

        @Override
        public void hideCalendarPopup() {
            PopupDateFieldConnector.this.clearRequestTimer();
            PopupDateFieldConnector.this.getWidget().closeCalendarPanel();
            PopupDateFieldConnector.this.clearDeferredCalendarShow();
        }

        @Override
        public void showCalendarPopup(Map<Resolution, Integer> map, Resolution resolution, Map<Resolution, Integer> map2, Map<Resolution, Integer> map3) {
            PopupDateFieldConnector.this.clearRequestTimer();
            Date date = null;
            if (map2 != null) {
                date = PopupDateFieldConnector.this.mapToDate(resolution, map2);
            }
            Date date2 = null;
            if (map3 != null) {
                date2 = PopupDateFieldConnector.this.mapToDate(resolution, map3);
            }
            PopupDateFieldConnector.this.getWidget().setRange(date, date2);
            PopupDateFieldConnector.this.getWidget().setResolution(resolution);
            final Date date3 = PopupDateFieldConnector.this.mapToDate(resolution, map);
            if (PopupDateFieldConnector.this.getWidget().isEditable()) {
                PopupDateFieldConnector.this.getWidget().openCalendarPanel(date3);
            } else {
                PopupDateFieldConnector.this.deferredCalendarShowAction = new Runnable(){
                    final /* synthetic */ 3 this$1;
                    {
                        this.this$1 = var1_1;
                    }

                    @Override
                    public void run() {
                        this.this$1.PopupDateFieldConnector.this.getWidget().openCalendarPanel(date3);
                    }
                };
            }
        }
    };

    @Override
    public PopupDateFieldState getState() {
        return (PopupDateFieldState)super.getState();
    }

    @Override
    public PopupDateFieldWidget getWidget() {
        return (PopupDateFieldWidget)super.getWidget();
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
        this.getWidget().setServerText(this.getState().text);
        if (this.getState().locale != null) {
            this.getWidget().setCurrentLocale(this.getState().locale);
        }
    }

    @Override
    public void init() {
        super.init();
        this.registerRpc(PopupDateFieldClientRpc.class, this.clientRpc);
        this.getWidget().addPopupDateFieldListener(this.widgetListener);
    }

    private Map<Resolution, Integer> dateToMap(Date date) {
        Resolution resolution = this.getWidget().getResolution();
        HashMap<Resolution, Integer> hashMap = new HashMap<Resolution, Integer>();
        hashMap.put(Resolution.YEAR, date.getYear() + 1900);
        hashMap.put(Resolution.MONTH, resolution.getCalendarField() >= Resolution.MONTH.getCalendarField() ? date.getMonth() : -1);
        hashMap.put(Resolution.DAY, resolution.getCalendarField() >= Resolution.DAY.getCalendarField() ? date.getDate() : -1);
        hashMap.put(Resolution.HOUR, resolution.getCalendarField() >= Resolution.HOUR.getCalendarField() ? date.getHours() : 0);
        hashMap.put(Resolution.MINUTE, resolution.getCalendarField() >= Resolution.MINUTE.getCalendarField() ? date.getMinutes() : 0);
        hashMap.put(Resolution.SECOND, resolution.getCalendarField() >= Resolution.SECOND.getCalendarField() ? date.getSeconds() : 0);
        return hashMap;
    }

    private Date mapToDate(Resolution resolution, Map<Resolution, Integer> map) {
        int n;
        int n2 = map.get(Resolution.YEAR);
        int n3 = resolution.getCalendarField() >= Resolution.MONTH.getCalendarField() ? map.get(Resolution.MONTH) : -1;
        int n4 = resolution.getCalendarField() >= Resolution.DAY.getCalendarField() ? map.get(Resolution.DAY) : -1;
        int n5 = resolution.getCalendarField() >= Resolution.HOUR.getCalendarField() ? map.get(Resolution.HOUR) : 0;
        int n6 = resolution.getCalendarField() >= Resolution.MINUTE.getCalendarField() ? map.get(Resolution.MINUTE) : 0;
        int n7 = n = resolution.getCalendarField() >= Resolution.SECOND.getCalendarField() ? map.get(Resolution.SECOND) : 0;
        if (n2 > -1) {
            return new Date((long)PopupDateFieldWidget.getTime(n2, n3, n4, n5, n6, n, 0));
        }
        return null;
    }

    @Override
    public void onBlur(BlurEvent blurEvent) {
        if (this.isEnabled() && !this.isReadOnly()) {
            if (!FMCUtilities.useAriaCompliantControl() && this.getWidget().isPopupShowing()) {
                return;
            }
            String string = this.getWidget().getFieldValue();
            if (!string.equals(this.getState().text)) {
                ((PopupDateFieldServerRpc)this.getRpcProxy(PopupDateFieldServerRpc.class)).onUserInput(string);
            }
        }
        this.getWidget().handleBlur();
        super.onBlur(blurEvent);
        this.clearDeferredCalendarShow();
        this.clearRequestTimer();
    }

    @Override
    public void onFocus(FocusEvent focusEvent) {
        this.getWidget().handleFocus();
        super.onFocus(focusEvent);
        this.clearDeferredCalendarShow();
    }

    @Override
    public void startEdit() {
        super.startEdit();
        if (this.getWidget().isEditable() && this.deferredCalendarShowAction != null) {
            this.deferredCalendarShowAction.run();
            this.clearDeferredCalendarShow();
        }
    }

    private void clearDeferredCalendarShow() {
        this.deferredCalendarShowAction = null;
    }

    public void onUnregister() {
        super.onUnregister();
        this.clearRequestTimer();
    }

    private void clearRequestTimer() {
        if (this.requestTimer.isRunning()) {
            this.requestTimer.cancel();
        }
    }
}

