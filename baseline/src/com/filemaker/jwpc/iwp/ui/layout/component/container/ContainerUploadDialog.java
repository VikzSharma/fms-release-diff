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
import com.filemaker.jwpc.iwp.ui.common.Dialog;
import com.filemaker.jwpc.iwp.ui.component.IWPUpload;
import com.filemaker.jwpc.iwp.ui.layout.component.container.Container;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.v7.ui.HorizontalLayout;
import com.vaadin.v7.ui.VerticalLayout;
import java.util.Objects;

public class ContainerUploadDialog
extends Dialog
implements IWPUpload.IWPUploadStartedListener {
    private static final int DEFAULT_WIDTH = 370;

    public ContainerUploadDialog(App app, Container container, String string) {
        super(app, IWPI18N.get(app, "INSERT_INTO_CONTAINER_DIALOG_TITLE", new Object[0]));
        this.setModal(true);
        this.setResizable(false);
        this.setDialogWidth(370);
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setSizeFull();
        Container container2 = container;
        Objects.requireNonNull(container2);
        Container.ContainerUpload containerUpload = container2.new Container.ContainerUpload(app, null, this, string);
        containerUpload.setImmediate(false);
        containerUpload.setCaption(null);
        containerUpload.setButtonCaption(IWPI18N.get(app, "UPLOAD_BUTTON_CAPTION", new Object[0]));
        containerUpload.setUploadStartedListener(this);
        containerUpload.addStyleName("fm-upload-field");
        if (app.getBrowserInfoHandler().isIE()) {
            containerUpload.addStyleName("fm-upload-field-ie");
        }
        horizontalLayout.addComponent((Component)containerUpload);
        horizontalLayout.setComponentAlignment((Component)containerUpload, Alignment.MIDDLE_CENTER);
        if (this.isTouchUI()) {
            this.initContent((Component)horizontalLayout);
        } else {
            VerticalLayout verticalLayout = new VerticalLayout();
            verticalLayout.addComponent((Component)horizontalLayout);
            this.setContent((Component)verticalLayout);
        }
    }

    @Override
    protected void onInitDialog() {
        this.enableTouchUI = true;
    }

    @Override
    public void uploadStarted() {
        this.close();
    }
}

