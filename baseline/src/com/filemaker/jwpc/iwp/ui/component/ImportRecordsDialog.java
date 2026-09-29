/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.Button$ClickEvent
 *  com.vaadin.ui.Component
 *  com.vaadin.v7.ui.Label
 *  com.vaadin.v7.ui.Upload$SucceededEvent
 *  com.vaadin.v7.ui.VerticalLayout
 */
package com.filemaker.jwpc.iwp.ui.component;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.thrift.common.ImportRecordsFileInfo;
import com.filemaker.jwpc.iwp.ui.common.Dialog;
import com.filemaker.jwpc.iwp.ui.common.ServerInvokedStaticDialog;
import com.filemaker.jwpc.iwp.ui.component.IWPUpload;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.v7.ui.Label;
import com.vaadin.v7.ui.Upload;
import com.vaadin.v7.ui.VerticalLayout;
import java.util.Arrays;
import java.util.List;

public class ImportRecordsDialog
extends ServerInvokedStaticDialog {
    private ImportRecordsFileInfo result = new ImportRecordsFileInfo();
    private ImportRecordsUpload upload;
    private String importFolderPath;

    public ImportRecordsDialog(App app, String string) {
        super(app, IWPI18N.get(app, "IMPORT_RECORDS_DIALOG_TITLE", new Object[0]), Dialog.ButtonOption.LEFT);
        this.setResizable(false);
        this.setWidth("475px");
        this.importFolderPath = string;
        this.upload.setImportDir(string);
        this.upload.addStyleName("fm-upload-field");
        if (app.getBrowserInfoHandler().isIE()) {
            this.upload.addStyleName("fm-upload-field-ie");
        }
    }

    @Override
    protected Component getContentLayout() {
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setSpacing(true);
        Label label = new Label(IWPI18N.get(this.app, "IMPORT_RECORDS_DIALOG_MESSAGE", new Object[0]));
        verticalLayout.addComponent((Component)label);
        Label label2 = new Label();
        label2.setHeight("1px");
        verticalLayout.addComponent((Component)label2);
        this.upload = new ImportRecordsUpload(this.app, null, this.importFolderPath);
        this.upload.setButtonCaption(IWPI18N.get(this.app, "IMPORT_RECORDS_UPLOAD_BUTTON_TEXT", new Object[0]));
        verticalLayout.addComponent((Component)this.upload);
        return verticalLayout;
    }

    @Override
    public final ImportRecordsFileInfo getResult() {
        return this.result;
    }

    @Override
    protected String getLeftButtonText() {
        return IWPI18N.get(this.app, "CANCEL", new Object[0]);
    }

    @Override
    protected void performLeftButtonAction(Button.ClickEvent clickEvent) {
        this.result.setFileName("");
        this.result.setFileType("");
        super.performLeftButtonAction(clickEvent);
    }

    private class ImportRecordsUpload
    extends IWPUpload {
        public ImportRecordsUpload(App app, String string, String string2) {
            super(app, string, string2);
        }

        @Override
        protected String constructFileName(String string) {
            Object object = ImportRecordsDialog.this.app.getCurrentSessionID() + string;
            object = ((String)object).toLowerCase();
            return object;
        }

        @Override
        public void uploadSucceeded(Upload.SucceededEvent succeededEvent) {
            String string;
            String string2 = this.constructFileName(succeededEvent.getFilename());
            List<String> list = Arrays.asList("tab", "csv", "dbf", "mer", "htm", "fmp", "xls", "xlsx");
            if (!list.contains(string = IWPUtilities.getFileExt(string2))) {
                List<String> list2 = Arrays.asList(string2.split("\\."));
                for (String string3 : list) {
                    if (!list2.contains(string3)) continue;
                    string = string3;
                }
            }
            ImportRecordsDialog.this.result.setFileName(string2);
            ImportRecordsDialog.this.result.setFileType("." + string);
            super.uploadSucceeded(succeededEvent);
            ImportRecordsDialog.this.closeDialog();
        }
    }
}

