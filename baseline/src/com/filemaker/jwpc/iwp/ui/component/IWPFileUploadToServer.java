/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.v7.ui.Upload$SucceededEvent
 */
package com.filemaker.jwpc.iwp.ui.component;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.thrift.common.ImportRecordsFileInfo;
import com.filemaker.jwpc.iwp.ui.common.Dialog;
import com.filemaker.jwpc.iwp.ui.component.IWPUpload;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.vaadin.v7.ui.Upload;
import java.util.Arrays;
import java.util.List;

public class IWPFileUploadToServer
extends IWPUpload {
    private Dialog parentDialog;
    private int currentSessionId;
    private ImportRecordsFileInfo fileInfo;
    private List<String> validExtensions = null;
    private boolean prependSessionIdToFilename = true;

    public IWPFileUploadToServer(App app, String string, String string2, ImportRecordsFileInfo importRecordsFileInfo, List<String> list, Dialog dialog, int n, boolean bl) {
        super(app, string, string2);
        this.parentDialog = dialog;
        this.currentSessionId = n;
        this.fileInfo = importRecordsFileInfo;
        this.validExtensions = list;
        this.prependSessionIdToFilename = bl;
    }

    @Override
    protected String constructFileName(String string) {
        String string2 = super.constructFileName(string);
        string2 = this.prependSessionIdToFilename ? this.currentSessionId + string2 : string2;
        return string2;
    }

    @Override
    public void uploadSucceeded(Upload.SucceededEvent succeededEvent) {
        String string = this.constructFileName(succeededEvent.getFilename());
        String string2 = IWPUtilities.getFileExt(string);
        if (this.validExtensions != null && !this.validExtensions.contains(string2)) {
            List<String> list = Arrays.asList(string.split("\\."));
            for (String string3 : this.validExtensions) {
                if (!list.contains(string3)) continue;
                string2 = string3;
            }
        }
        if (this.fileInfo == null) {
            this.fileInfo = new ImportRecordsFileInfo();
        }
        this.fileInfo.setFileName(string);
        this.fileInfo.setFileType("." + string2);
        super.uploadSucceeded(succeededEvent);
        if (this.parentDialog != null) {
            this.parentDialog.closeDialog();
        }
    }

    public ImportRecordsFileInfo getFileInfo() {
        return this.fileInfo;
    }
}

