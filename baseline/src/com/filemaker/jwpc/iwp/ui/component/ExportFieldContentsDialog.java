/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.Alignment
 *  com.vaadin.ui.Button$ClickEvent
 *  com.vaadin.ui.Component
 *  com.vaadin.v7.event.FieldEvents$TextChangeEvent
 *  com.vaadin.v7.event.FieldEvents$TextChangeListener
 *  com.vaadin.v7.ui.HorizontalLayout
 *  com.vaadin.v7.ui.Label
 *  com.vaadin.v7.ui.TextField
 *  com.vaadin.v7.ui.VerticalLayout
 */
package com.filemaker.jwpc.iwp.ui.component;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.thrift.notification.ExportFieldContentsDialogNotification;
import com.filemaker.jwpc.iwp.ui.common.Dialog;
import com.filemaker.jwpc.iwp.ui.common.ServerInvokedStaticDialog;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.v7.event.FieldEvents;
import com.vaadin.v7.ui.HorizontalLayout;
import com.vaadin.v7.ui.Label;
import com.vaadin.v7.ui.TextField;
import com.vaadin.v7.ui.VerticalLayout;

public class ExportFieldContentsDialog
extends ServerInvokedStaticDialog {
    private TextField fileName;
    private String result = "";
    private static final String CAPTION_CSS_STYLE = "v-caption-sr-only-caption-dialog-fields";

    public ExportFieldContentsDialog(App app, ExportFieldContentsDialogNotification exportFieldContentsDialogNotification) {
        super(app, IWPI18N.get(app, "EXPORT_FIELD_CONTENTS_DIALOG_TITLE", new Object[0]), Dialog.ButtonOption.LEFT_RIGHT);
        this.setRightButtonDefault();
        this.setResizable(false);
        this.fileName.setCaption(IWPI18N.get(app, "EXPORT_FIELD_CONTENTS_DIALOG_MESSAGE", new Object[0]));
        this.fileName.addStyleName(CAPTION_CSS_STYLE);
        if (exportFieldContentsDialogNotification.getFileName().equalsIgnoreCase("Untitled")) {
            this.fileName.setValue(IWPI18N.get(app, "EXPORT_FIELD_CONTENTS_DEFAULT_FILE_NAME", new Object[0]));
        } else {
            this.fileName.setValue(exportFieldContentsDialogNotification.getFileName());
        }
    }

    @Override
    protected Component getContentLayout() {
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setSpacing(true);
        Label label = new Label(IWPI18N.get(this.app, "EXPORT_FIELD_CONTENTS_DIALOG_MESSAGE", new Object[0]));
        verticalLayout.addComponent((Component)label);
        Label label2 = new Label();
        label2.setHeight("3px");
        verticalLayout.addComponent((Component)label2);
        HorizontalLayout horizontalLayout = this.getFileInfoLayout();
        verticalLayout.addComponent((Component)horizontalLayout);
        verticalLayout.setComponentAlignment((Component)horizontalLayout, Alignment.BOTTOM_CENTER);
        return verticalLayout;
    }

    @Override
    protected void onInitDialog() {
        this.enableTouchUI = true;
    }

    private HorizontalLayout getFileInfoLayout() {
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setSpacing(true);
        Label label = new Label(IWPI18N.get(this.app, "SAVE_AS_COLON", new Object[0]));
        horizontalLayout.addComponent((Component)label);
        horizontalLayout.setComponentAlignment((Component)label, Alignment.MIDDLE_RIGHT);
        this.fileName = new TextField();
        this.fileName.setValue(IWPI18N.get(this.app, "EXPORT_FIELD_CONTENTS_DEFAULT_FILE_NAME", new Object[0]));
        this.fileName.setImmediate(true);
        this.fileName.addTextChangeListener(new FieldEvents.TextChangeListener(){

            public void textChange(FieldEvents.TextChangeEvent textChangeEvent) {
                ExportFieldContentsDialog.this.performFileNameChange(textChangeEvent);
            }
        });
        horizontalLayout.addComponent((Component)this.fileName);
        horizontalLayout.setComponentAlignment((Component)this.fileName, Alignment.MIDDLE_LEFT);
        return horizontalLayout;
    }

    @Override
    public final String getResult() {
        return this.result;
    }

    @Override
    protected void performLeftButtonAction(Button.ClickEvent clickEvent) {
        this.result = "";
        super.performLeftButtonAction(clickEvent);
    }

    @Override
    protected void performRightButtonAction(Button.ClickEvent clickEvent) {
        if (!((String)this.fileName.getValue()).toString().trim().isEmpty()) {
            this.result = ((String)this.fileName.getValue()).toString();
        }
        super.performRightButtonAction(clickEvent);
    }

    private void performFileNameChange(FieldEvents.TextChangeEvent textChangeEvent) {
        String string = textChangeEvent.getText();
        if (string == null || string.trim().isEmpty()) {
            if (this.getRightButton().isEnabled()) {
                this.getRightButton().setEnabled(false);
            }
        } else if (!this.getRightButton().isEnabled()) {
            this.getRightButton().setEnabled(true);
        }
    }
}

