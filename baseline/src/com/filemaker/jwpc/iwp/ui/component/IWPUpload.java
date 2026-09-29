/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.ui.ContentMode
 *  com.vaadin.ui.Button$ClickEvent
 *  com.vaadin.ui.Button$ClickListener
 *  com.vaadin.ui.Component
 *  com.vaadin.v7.ui.HorizontalLayout
 *  com.vaadin.v7.ui.Upload$FailedEvent
 *  com.vaadin.v7.ui.Upload$FailedListener
 *  com.vaadin.v7.ui.Upload$FinishedEvent
 *  com.vaadin.v7.ui.Upload$FinishedListener
 *  com.vaadin.v7.ui.Upload$ProgressListener
 *  com.vaadin.v7.ui.Upload$Receiver
 *  com.vaadin.v7.ui.Upload$StartedEvent
 *  com.vaadin.v7.ui.Upload$StartedListener
 *  com.vaadin.v7.ui.Upload$SucceededEvent
 *  com.vaadin.v7.ui.Upload$SucceededListener
 */
package com.filemaker.jwpc.iwp.ui.component;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.ui.component.UploadDialog;
import com.filemaker.jwpc.iwp.ui.component.UploadFileSelector;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.v7.ui.HorizontalLayout;
import com.vaadin.v7.ui.Upload;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class IWPUpload
extends HorizontalLayout
implements Upload.StartedListener,
Upload.Receiver,
Upload.ProgressListener,
Upload.FinishedListener,
Upload.SucceededListener,
Upload.FailedListener {
    protected final UploadFileSelector upload;
    private FileOutputStream fos;
    protected UploadDialog uploadDialog;
    private Button.ClickListener cancelUploadListener;
    private IWPUploadStartedListener uploadStartedListener;
    private IWPUploadFinishedListener uploadFinishedListener;
    protected String importDir;
    private File file;
    private final App app;

    public IWPUpload(App app, String string, String string2) {
        this.app = app;
        this.setSpacing(false);
        this.setMargin(false);
        this.importDir = string2;
        this.upload = new UploadFileSelector(string, this);
        this.upload.setTabIndex(0);
        this.upload.addStartedListener(this);
        this.upload.addProgressListener(this);
        this.upload.addFinishedListener(this);
        this.upload.addSucceededListener(this);
        this.upload.addFailedListener(this);
        this.cancelUploadListener = new Button.ClickListener(){

            public void buttonClick(Button.ClickEvent clickEvent) {
                IWPUpload.this.cancelUpload();
            }
        };
        IWPUtilities.setAttributeBySelector(app, "input.gwt-FileUpload", "aria-label", app.getLocalizedString("IMPORT_RECORDS_CHOOSE_FILE_LABEL"));
        this.addComponent((Component)this.upload);
    }

    public void setUploadStartedListener(IWPUploadStartedListener iWPUploadStartedListener) {
        this.uploadStartedListener = iWPUploadStartedListener;
    }

    public void setUploadFinishedListener(IWPUploadFinishedListener iWPUploadFinishedListener) {
        this.uploadFinishedListener = iWPUploadFinishedListener;
    }

    public void setImmediate(boolean bl) {
        this.upload.setImmediate(bl);
    }

    public void setButtonCaption(String string) {
        this.upload.setButtonCaption(string);
    }

    public void setDescription(String string) {
        this.upload.setDescription(string, ContentMode.HTML);
    }

    public void uploadStarted(Upload.StartedEvent startedEvent) {
        this.initUpload(this.app, startedEvent.getFilename(), this.cancelUploadListener);
    }

    protected String constructParentDirectoryPath() {
        return this.getImportDir();
    }

    protected String constructFileName(String string) {
        return IWPUtilities.makeFilesystemSafeFilename(string);
    }

    public OutputStream receiveUpload(String string, String string2) {
        try {
            this.file = new File(this.constructParentDirectoryPath(), this.constructFileName(string));
            this.fos = new FileOutputStream(this.file);
        }
        catch (IOException iOException) {
            // empty catch block
        }
        return this.fos;
    }

    public void updateProgress(long l, long l2) {
        this.showProgress(l, l2);
    }

    public void uploadFinished(Upload.FinishedEvent finishedEvent) {
        if (this.uploadFinishedListener != null) {
            this.uploadFinishedListener.uploadFinished();
        }
        this.app.getAppSession().clientDoneProcessing(null, true);
    }

    public void uploadSucceeded(Upload.SucceededEvent succeededEvent) {
        this.shutdownDialog();
        try {
            this.fos.close();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    protected void shutdownDialog() {
        if (this.uploadDialog != null) {
            this.uploadDialog.getProgressIndicator().setValue(Float.valueOf(1.0f));
            this.uploadDialog.close();
        }
    }

    public void uploadFailed(Upload.FailedEvent failedEvent) {
        if (this.uploadDialog != null) {
            this.uploadDialog.closeDialog();
        }
        try {
            if (this.fos != null) {
                this.fos.close();
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    protected void cancelUpload() {
        this.upload.interruptUpload();
    }

    private void initUpload(App app, String string, Button.ClickListener clickListener) {
        this.uploadDialog = new UploadDialog(app);
        this.uploadDialog.getFileNameLabel().setValue(string);
        this.uploadDialog.setCancelButtonHandler(clickListener);
        this.uploadDialog.setSynthesizedFrameName(this.upload.getConnectorId());
        this.uploadDialog.showDialog();
        this.postInitUpload();
    }

    protected void postInitUpload() {
        if (this.uploadStartedListener != null) {
            this.uploadStartedListener.uploadStarted();
        }
        this.app.getAppSession().clientStartProcessing(null, true);
    }

    private void showProgress(long l, long l2) {
        if (this.uploadDialog != null) {
            Float f = Float.valueOf((float)l / (float)l2);
            if ((double)f.floatValue() >= 0.95) {
                this.uploadDialog.setStatusStoringData();
            }
            this.uploadDialog.getProgressIndicator().setValue(f);
        }
    }

    public File getFile() {
        return this.file;
    }

    public void deleteFile() {
        if (this.file != null) {
            this.file.delete();
        }
    }

    public String getImportDir() {
        return this.importDir;
    }

    public void setImportDir(String string) {
        this.importDir = string;
    }

    public static interface IWPUploadStartedListener {
        public void uploadStarted();
    }

    public static interface IWPUploadFinishedListener {
        public void uploadFinished();
    }
}

