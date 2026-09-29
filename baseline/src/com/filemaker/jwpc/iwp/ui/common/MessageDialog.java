/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.Alignment
 *  com.vaadin.ui.Component
 *  com.vaadin.v7.shared.ui.label.ContentMode
 *  com.vaadin.v7.ui.Label
 *  org.vaadin.kim.countdownclock.CountdownClock
 *  org.vaadin.kim.countdownclock.CountdownClock$EndEventListener
 */
package com.filemaker.jwpc.iwp.ui.common;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.ui.common.Dialog;
import com.filemaker.jwpc.iwp.ui.common.ServerInvokedDialog;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.jwpc.util.Utilities;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.v7.shared.ui.label.ContentMode;
import com.vaadin.v7.ui.Label;
import java.util.Calendar;
import org.vaadin.kim.countdownclock.CountdownClock;

public class MessageDialog
extends ServerInvokedDialog {
    private static final String MESSAGE_TITLE = "Message";
    private static final String DIALOG_WIDTH = "400px";

    public MessageDialog(App app, String string) {
        super(app, MESSAGE_TITLE, Dialog.ButtonOption.LEFT);
        this.configureDialog(string);
    }

    public MessageDialog(App app, String string, String string2) {
        super(app, string, Dialog.ButtonOption.LEFT);
        this.configureDialog(string2);
    }

    protected void configureDialog(String string) {
        this.setWidth(DIALOG_WIDTH);
        this.setResizable(false);
        this.initContent(this.getContentLayout(string));
        this.initButtons(IWPI18N.get(this.app, "CLOSE", new Object[0]), "", "");
        this.addTimer();
    }

    private void addTimer() {
        CountdownClock countdownClock = new CountdownClock();
        Calendar calendar = Calendar.getInstance();
        calendar.add(13, 30);
        countdownClock.setDate(calendar.getTime());
        countdownClock.setFormat(IWPI18N.get(this.app, "CLOSE_MESSAGE_TIMER", new Object[0]));
        countdownClock.setHeight("40px");
        countdownClock.addListener(new CountdownClock.EndEventListener(){

            public void countDownEnded(CountdownClock countdownClock) {
                MessageDialog.this.closeDialog();
            }
        });
        this.root.addComponent((Component)countdownClock);
        this.root.setComponentAlignment((Component)countdownClock, Alignment.BOTTOM_LEFT);
    }

    protected Component getContentLayout(String string) {
        string = Utilities.encodeHTML(string);
        Label label = new Label(string.replace("\r", "\n"));
        label.setContentMode(ContentMode.HTML);
        return label;
    }

    @Override
    public Object getResult() {
        return null;
    }
}

