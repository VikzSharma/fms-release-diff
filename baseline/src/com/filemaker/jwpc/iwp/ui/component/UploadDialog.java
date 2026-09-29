/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.Button$ClickEvent
 *  com.vaadin.ui.Button$ClickListener
 *  com.vaadin.ui.Component
 *  com.vaadin.ui.FormLayout
 *  com.vaadin.ui.UI
 *  com.vaadin.v7.ui.Label
 *  com.vaadin.v7.ui.ProgressBar
 */
package com.filemaker.jwpc.iwp.ui.component;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.ui.common.Dialog;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.jwpc.iwp.widgetset.client.state.UploadDialogState;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.UI;
import com.vaadin.v7.ui.Label;
import com.vaadin.v7.ui.ProgressBar;

public class UploadDialog
extends Dialog {
    private static final long serialVersionUID = 3528997175952651950L;
    private static final int DIALOG_WIDTH = 450;
    private static final String FILE_NAME_CAPTION_KEY = "FILE_NAME_CAPTION";
    private static final String UPLOAD_DIALOG_TITLE_KEY = "UPLOAD_DIALOG_TITLE";
    private static final String CANCEL_BUTTON_CAPTION_KEY = "CANCEL";
    private ProgressBar progress;
    private Label fileName;
    private Label statusLabel;
    private Button.ClickListener cancelListener;
    private String storingStateMsg;

    public UploadDialog(App app) {
        super(app, IWPI18N.get(app, UPLOAD_DIALOG_TITLE_KEY, new Object[0]), Dialog.ButtonOption.LEFT);
        this.storingStateMsg = IWPI18N.get(this.app, "BUSY_DIALOG_WAIT", new Object[0]);
        FormLayout formLayout = new FormLayout();
        formLayout.setMargin(true);
        formLayout.setSizeFull();
        this.fileName = new Label();
        this.fileName.setCaption(IWPI18N.get(app, FILE_NAME_CAPTION_KEY, new Object[0]));
        formLayout.addComponent((Component)this.fileName);
        this.statusLabel = new Label();
        this.statusLabel.setValue(IWPI18N.get(app, "TRANSFERRING_FILE", new Object[0]));
        this.progress = new ProgressBar();
        formLayout.addComponent((Component)this.progress);
        formLayout.addComponent((Component)this.statusLabel);
        this.setDialogWidth(450);
        this.initContent((Component)formLayout);
        this.initButtons(IWPI18N.get(app, CANCEL_BUTTON_CAPTION_KEY, new Object[0]), null, null);
    }

    @Override
    public boolean showDialog() {
        boolean bl = super.showDialog();
        UI.getCurrent().setPollInterval(1000);
        return bl;
    }

    @Override
    public void closeDialog() {
        UI.getCurrent().setPollInterval(-1);
        super.closeDialog();
    }

    @Override
    protected void onInitDialog() {
        this.enableTouchUI = true;
    }

    public Label getFileNameLabel() {
        return this.fileName;
    }

    public ProgressBar getProgressIndicator() {
        return this.progress;
    }

    public void setCancelButtonHandler(Button.ClickListener clickListener) {
        this.cancelListener = clickListener;
    }

    public void close() {
        this.closeDialog();
    }

    public void setStatusStoringData() {
        if (!this.progress.isIndeterminate()) {
            this.progress.setIndeterminate(true);
            this.statusLabel.setValue(this.storingStateMsg);
            this.setLeftButtonDisabled();
        }
    }

    @Override
    protected void performLeftButtonAction(Button.ClickEvent clickEvent) {
        if (this.cancelListener != null) {
            this.cancelListener.buttonClick(clickEvent);
        }
        super.performLeftButtonAction(clickEvent);
    }

    public void setStoringStateMsg(String string) {
        this.storingStateMsg = string;
    }

    protected UploadDialogState getState() {
        return (UploadDialogState)super.getState();
    }

    public void setSynthesizedFrameName(String string) {
        this.getState().synthesizedFrameName = string;
    }
}

