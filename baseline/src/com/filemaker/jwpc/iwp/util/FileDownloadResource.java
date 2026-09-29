/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.server.DownloadStream
 *  com.vaadin.server.StreamResource
 *  com.vaadin.ui.Button
 *  javax.ws.rs.core.UriBuilder
 */
package com.filemaker.jwpc.iwp.util;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.filemaker.jwpc.log.JWPCLogger;
import com.filemaker.jwpc.util.Utilities;
import com.vaadin.server.DownloadStream;
import com.vaadin.server.StreamResource;
import com.vaadin.ui.Button;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URLDecoder;
import javax.ws.rs.core.UriBuilder;

public class FileDownloadResource
extends StreamResource {
    private static final long serialVersionUID = -4127752847435830732L;
    private String mimeType;
    private String fileName;
    private String url;
    private String key;
    private InputStream inputStream;
    private App app;
    private Button downloadButton;
    private static JWPCLogger logger = JWPCLogger.getLogger(FileDownloadResource.class);

    public FileDownloadResource(String string, String string2, String string3, String string4, Button button, App app) {
        super(null, string4);
        this.init(app, button, string3, string4);
        this.url = string;
        this.key = string2;
    }

    public FileDownloadResource(InputStream inputStream, String string, String string2, Button button, App app) {
        super(null, string2);
        this.init(app, button, string, string2);
        this.inputStream = inputStream;
    }

    private void init(App app, Button button, String string, String string2) {
        this.app = app;
        this.mimeType = string;
        this.fileName = string2;
        this.downloadButton = button;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFilename() {
        return this.fileName;
    }

    public String getMIMEType() {
        return this.mimeType;
    }

    public DownloadStream getStream() {
        this.downloadButton.setEnabled(false);
        this.app.pushChanges();
        InputStream inputStream = this.getInputStream();
        if (inputStream != null) {
            DownloadStream downloadStream = new DownloadStream(inputStream, this.getMIMEType(), this.getFilename());
            downloadStream.setParameter("Content-Disposition", "attachment; filename*=UTF-8''" + UriBuilder.fromPath((String)"{filename}").build(new Object[]{this.getFileName()}).toString());
            downloadStream.setCacheTime(this.getCacheTime());
            return downloadStream;
        }
        return null;
    }

    private InputStream getConnectionInputStrem(String string, boolean bl) throws Exception {
        HttpURLConnection httpURLConnection = (HttpURLConnection)IWPUtilities.getXHR(string, "GET", bl);
        if (httpURLConnection != null) {
            httpURLConnection.setRequestProperty("X-FMS-Session-Key", this.key);
            if (httpURLConnection.getResponseCode() == 200) {
                return httpURLConnection.getInputStream();
            }
        }
        return null;
    }

    private InputStream getInputStream() {
        this.downloadButton.setEnabled(false);
        this.app.pushChanges();
        if (this.inputStream != null) {
            return this.inputStream;
        }
        if (this.url != null && this.key != null) {
            try {
                if (Utilities.isWindows() && !this.url.toLowerCase().contains(".amazonaws.com")) {
                    this.url = URLDecoder.decode(this.url, "UTF-8");
                }
                if (IWPUtilities.isDebugMode()) {
                    logger.info("Export Field Content URL = " + this.url);
                }
                try {
                    return this.getConnectionInputStrem(this.url, false);
                }
                catch (Exception exception) {
                    logger.info("Need to downgrade - URL = " + this.url);
                    exception.printStackTrace();
                    if (!this.url.startsWith("http://localhost:1895")) {
                        try {
                            return this.getConnectionInputStrem(this.url, true);
                        }
                        catch (Exception exception2) {
                            logger.error("Failed to download file [Worker/true]: URL = " + this.url);
                            exception2.printStackTrace();
                        }
                    }
                }
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }
}

