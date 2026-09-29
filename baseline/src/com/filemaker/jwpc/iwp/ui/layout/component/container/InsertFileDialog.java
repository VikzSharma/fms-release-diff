/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.Alignment
 *  com.vaadin.ui.Component
 *  com.vaadin.v7.ui.HorizontalLayout
 *  com.vaadin.v7.ui.VerticalLayout
 */
package com.filemaker.jwpc.iwp.ui.layout.component.container;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.thrift.common.ImportRecordsFileInfo;
import com.filemaker.jwpc.iwp.ui.common.ServerInvokedStaticDialog;
import com.filemaker.jwpc.iwp.ui.component.IWPFileUploadToServer;
import com.filemaker.jwpc.iwp.ui.component.IWPUpload;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.v7.ui.HorizontalLayout;
import com.vaadin.v7.ui.VerticalLayout;

public class InsertFileDialog
extends ServerInvokedStaticDialog
implements IWPUpload.IWPUploadFinishedListener {
    private IWPFileUploadToServer upload;
    private String folderPath;

    public InsertFileDialog(App app, String string, String string2) {
        super(app, string2);
        this.folderPath = string;
        this.upload.setImportDir(string);
    }

    @Override
    public void uploadFinished() {
        this.closeDialog();
    }

    @Override
    protected String getLeftButtonText() {
        return IWPI18N.get(this.app, "CANCEL", new Object[0]);
    }

    @Override
    public Object getResult() {
        this.app.getMessenger().setBusyDialogInvisible();
        this.app.getMessenger().showBusyDialog(false, IWPI18N.get(this.app, "BUSY_INSERT_CONTAINER_MESSAGE", new Object[0]));
        if (this.upload != null) {
            return this.upload.getFileInfo();
        }
        return new ImportRecordsFileInfo();
    }

    @Override
    protected Component getContentLayout() {
        this.setModal(true);
        this.setResizable(false);
        this.setWidthUndefined();
        VerticalLayout verticalLayout = new VerticalLayout();
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setSizeFull();
        this.upload = new IWPFileUploadToServer(this.app, null, this.folderPath, null, null, this, this.app.getCurrentSessionID(), false);
        this.upload.setImmediate(false);
        this.upload.setCaption(null);
        this.upload.setButtonCaption(IWPI18N.get(this.app, "UPLOAD_BUTTON_CAPTION", new Object[0]));
        this.upload.setUploadFinishedListener(this);
        horizontalLayout.addComponent((Component)this.upload);
        horizontalLayout.setComponentAlignment((Component)this.upload, Alignment.MIDDLE_CENTER);
        verticalLayout.addComponent((Component)horizontalLayout);
        if (this.isTouchUI() || !this.app.getWebBrowser().isSafari()) {
            this.upload.addStyleName("fm-upload-field");
        }
        return verticalLayout;
    }

    @Override
    protected void onInitDialog() {
        this.enableTouchUI = true;
    }
}

