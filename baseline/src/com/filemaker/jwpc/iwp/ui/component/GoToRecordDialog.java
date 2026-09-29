/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.server.Sizeable$Unit
 *  com.vaadin.ui.Alignment
 *  com.vaadin.ui.Button$ClickEvent
 *  com.vaadin.ui.Component
 *  com.vaadin.v7.ui.HorizontalLayout
 *  com.vaadin.v7.ui.Label
 *  com.vaadin.v7.ui.TextField
 */
package com.filemaker.jwpc.iwp.ui.component;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.ui.common.Dialog;
import com.filemaker.jwpc.iwp.ui.common.ServerInvokedStaticDialog;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.v7.ui.HorizontalLayout;
import com.vaadin.v7.ui.Label;
import com.vaadin.v7.ui.TextField;

public class GoToRecordDialog
extends ServerInvokedStaticDialog {
    private TextField number;
    private int maxNumber = -1;
    private Label postText;
    private RecordNumberDialogResult result = new RecordNumberDialogResult(this);

    public GoToRecordDialog(App app, int n, int n2) {
        super(app, IWPI18N.get(app, "SPECIFY_NUMBER", new Object[0]), Dialog.ButtonOption.LEFT_RIGHT);
        if (n == 0) {
            n = app.getLayoutDataModel().getRecordIndex();
        }
        this.postText.setValue(IWPI18N.get(app, "RECORD_NUMBER_POSTTEXT", n2));
        this.number.setValue(String.valueOf(n));
        this.maxNumber = n2;
        this.setRightButtonDefault();
        this.setResizable(false);
        this.result.number = n;
    }

    @Override
    protected Component getContentLayout() {
        this.number = new TextField();
        this.number.setValue("1");
        this.number.setMaxLength(20);
        this.number.setImmediate(true);
        this.number.setCaption(this.app.isBrowseMode() ? IWPI18N.get(this.app, "RECORD_NUMBER_ARIA_LABEL", new Object[0]) : IWPI18N.get(this.app, "REQUEST_NUMBER_ARIA_LABEL", new Object[0]));
        this.number.addStyleName("v-caption-sr-only-caption-dialog-fields");
        if (this.isTouchUI()) {
            this.number.setWidth(70.0f, Sizeable.Unit.PIXELS);
        }
        Label label = new Label(this.app.isBrowseMode() ? IWPI18N.get(this.app, "RECORD_NUMBER_PRETEXT", new Object[0]) : IWPI18N.get(this.app, "REQUEST_NUMBER_PRETEXT", new Object[0]));
        this.postText = new Label();
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setSpacing(true);
        horizontalLayout.addComponent((Component)label);
        horizontalLayout.setComponentAlignment((Component)label, Alignment.MIDDLE_CENTER);
        horizontalLayout.addComponent((Component)this.number);
        horizontalLayout.setComponentAlignment((Component)this.number, Alignment.MIDDLE_CENTER);
        horizontalLayout.addComponent((Component)this.postText);
        horizontalLayout.setComponentAlignment((Component)this.postText, Alignment.MIDDLE_CENTER);
        if (this.isTouchUI()) {
            horizontalLayout.addStyleName("expand-height");
        }
        return horizontalLayout;
    }

    @Override
    protected void onInitDialog() {
        this.enableTouchUI = true;
    }

    @Override
    protected void performRightButtonAction(Button.ClickEvent clickEvent) {
        try {
            long l = Long.parseLong(((String)this.number.getValue()).trim());
            if (l < 1L || l > (long)this.maxNumber) {
                this.app.getMessenger().showErrorDialog(IWPI18N.get(this.app, "GOTO_ERROR", 1, this.maxNumber));
            } else {
                this.result.confirm = true;
                this.result.number = (int)l;
                super.performRightButtonAction(clickEvent);
            }
        }
        catch (NumberFormatException numberFormatException) {
            this.app.getMessenger().showErrorDialog(IWPI18N.get(this.app, "GOTO_ERROR", 1, this.maxNumber));
        }
    }

    @Override
    public Object getResult() {
        return this.result;
    }

    public class RecordNumberDialogResult {
        public boolean confirm = false;
        public int number = 0;

        public RecordNumberDialogResult(GoToRecordDialog goToRecordDialog) {
        }
    }
}

