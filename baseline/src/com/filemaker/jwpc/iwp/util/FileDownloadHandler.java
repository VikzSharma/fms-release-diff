/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.util;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.application.AppException;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileDownloadHandler {
    private File file;
    private String downloadFileName;
    private final App app;

    public FileDownloadHandler(App app, String string) {
        this.app = app;
        this.file = new File(string);
        this.downloadFileName = this.file.getName();
    }

    public FileDownloadHandler(App app, String string, String string2) {
        this.app = app;
        this.file = new File(string);
        this.downloadFileName = string2;
    }

    public boolean downloadAndDelete() throws AppException {
        boolean bl = false;
        byte[] byArray = this.getFileContent();
        if (byArray != null) {
            this.file.delete();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
            IWPUtilities.showFileDownloadDialog(this.app, byteArrayInputStream, IWPUtilities.getMimeTypeFromFilename(this.downloadFileName), this.downloadFileName);
            bl = true;
        }
        return bl;
    }

    public byte[] getFileContent() throws AppException {
        byte[] byArray = null;
        if (this.file.exists() && this.file.isFile()) {
            try {
                byArray = new byte[(int)this.file.length()];
                FileInputStream fileInputStream = new FileInputStream(this.file);
                fileInputStream.read(byArray);
                fileInputStream.close();
            }
            catch (FileNotFoundException fileNotFoundException) {
                System.out.println("File not found at: " + this.getPath());
            }
            catch (IOException iOException) {
                throw new AppException(iOException);
            }
        } else {
            System.out.println("File not found at: " + this.getPath());
        }
        return byArray;
    }

    private String getPath() {
        return this.file.getPath();
    }
}

