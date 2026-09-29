/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.server.FileDownloader
 *  com.vaadin.server.Resource
 *  com.vaadin.server.StreamResource$StreamSource
 *  com.vaadin.ui.AbstractComponent
 *  com.vaadin.ui.Button
 *  com.vaadin.ui.Button$ClickEvent
 *  com.vaadin.ui.Component
 *  com.vaadin.ui.FormLayout
 *  com.vaadin.v7.ui.Label
 *  javax.ws.rs.core.UriBuilder
 */
package com.filemaker.jwpc.iwp.ui.component;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.service.Service;
import com.filemaker.jwpc.iwp.ui.common.Dialog;
import com.filemaker.jwpc.iwp.util.FileDownloadResource;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.jwpc.iwp.util.PDFSupport;
import com.vaadin.server.FileDownloader;
import com.vaadin.server.Resource;
import com.vaadin.server.StreamResource;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.v7.ui.Label;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.ws.rs.core.UriBuilder;

public class FileDownloadDialog
extends Dialog {
    private final FormLayout layout;
    private boolean isShown = false;
    private boolean hasPDFFiles = false;
    private static final int DEFAULT_WIDTH = 450;

    public FileDownloadDialog(App app) {
        super(app, IWPI18N.get(app, "DOWNLOAD_DIALOG_TITLE", new Object[0]), Dialog.ButtonOption.LEFT);
        this.setDialogWidth(450);
        this.root.addComponent((Component)new Label(IWPI18N.get(app, "DOWNLOAD_DIALOG_TEXT", new Object[0]), Label.CONTENT_XHTML));
        this.layout = new FormLayout();
        this.layout.setMargin(true);
        this.layout.setSpacing(true);
        this.layout.addStyleName("fm-download-form");
        this.initContent((Component)this.layout);
        this.initButtons(IWPI18N.get(app, "CLOSE", new Object[0]), null, null);
    }

    @Override
    protected void onInitDialog() {
        this.enableTouchUI = true;
    }

    public void addDownloadButton(InputStream inputStream, String string, String string2) {
        Button button = this.addDownloadButton(string);
        FileDownloadResource fileDownloadResource = new FileDownloadResource(inputStream, string2, string, button, this.app);
        FileDownloader fileDownloader = new FileDownloader((Resource)fileDownloadResource);
        fileDownloader.extend((AbstractComponent)button);
    }

    public void addDownloadButton(String string, String string2, String string3, String string4) {
        Object object;
        Button button = this.addDownloadButton(string3);
        Object object2 = string;
        if (string.toLowerCase().indexOf(".amazonaws.com") != -1) {
            object = string.split("\\?");
            object2 = UriBuilder.fromPath((String)"{uri}").build(new Object[]{object[0]}).toString() + "?" + object[1];
        } else {
            object2 = UriBuilder.fromPath((String)"{uri}").build(new Object[]{string}).toString();
        }
        object = new FileDownloadResource((String)object2, string2, string4, string3, button, this.app);
        FileDownloader fileDownloader = new FileDownloader((Resource)object);
        fileDownloader.extend((AbstractComponent)button);
    }

    public void addPDFDownloadButton(final String string, final String string2) {
        Path path = Paths.get(string, new String[0]);
        String string3 = path.getFileName().toString();
        Button button = this.addDownloadButton(string3);
        button.setDisableOnClick(true);
        PDFSupport.PDFStreamResource pDFStreamResource = new PDFSupport.PDFStreamResource(new StreamResource.StreamSource(){
            final /* synthetic */ FileDownloadDialog this$0;
            {
                this.this$0 = fileDownloadDialog;
            }

            public InputStream getStream() {
                return PDFSupport.getInputStream(string, string2).getStream();
            }
        }, string3);
        pDFStreamResource.setMIMEType("application/pdf");
        FileDownloader fileDownloader = new FileDownloader((Resource)pDFStreamResource);
        fileDownloader.extend((AbstractComponent)button);
        this.hasPDFFiles = true;
    }

    private Button addDownloadButton(String string) {
        Button button = new Button(string);
        button.setSizeFull();
        button.addStyleName("fm-download-button");
        this.layout.addComponent((Component)button);
        return button;
    }

    public boolean isShown() {
        return this.isShown;
    }

    @Override
    public boolean showDialog() {
        this.isShown = super.showDialog();
        return this.isShown;
    }

    @Override
    public void closeDialog() {
        this.layout.removeAllComponents();
        super.closeDialog();
        this.isShown = false;
        if (this.hasPDFFiles) {
            int n = this.app.getAppView().getCurrentSessionID();
            Service.getInstance().deletePDFFiles(n);
        }
    }

    @Override
    protected void performLeftButtonAction(Button.ClickEvent clickEvent) {
        super.performLeftButtonAction(clickEvent);
    }

    @Override
    public void setVisible(boolean bl) {
        super.setVisible(bl);
        if (bl) {
            this.app.updateShortcutHandlingOnClient(false);
        }
    }
}

