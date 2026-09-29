/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.GWT
 *  com.google.gwt.dom.client.Document
 *  com.google.gwt.dom.client.Element
 *  com.google.gwt.dom.client.NodeList
 *  com.google.gwt.event.logical.shared.CloseEvent
 *  com.google.gwt.event.logical.shared.CloseHandler
 *  com.google.gwt.user.client.ui.PopupPanel
 *  com.vaadin.client.ui.upload.UploadIFrameOnloadStrategy
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.jwpc.iwp.widgetset.client.state.UploadDialogState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.LogUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomDialog;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NodeList;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.user.client.ui.PopupPanel;
import com.vaadin.client.ui.upload.UploadIFrameOnloadStrategy;

public class VCustomUploadDialog
extends VCustomDialog {
    private String synthesizedFrameName;
    private UploadIFrameOnloadStrategy onloadstrategy = (UploadIFrameOnloadStrategy)GWT.create(UploadIFrameOnloadStrategy.class);

    public VCustomUploadDialog() {
        this.addCloseHandler((CloseHandler)new CloseHandler<PopupPanel>(){

            public void onClose(CloseEvent<PopupPanel> closeEvent) {
                VCustomUploadDialog.this.killSynthesizedFrame(VCustomUploadDialog.this.synthesizedFrameName + "_TGT_FRAME");
            }
        });
    }

    public void updateState(UploadDialogState uploadDialogState) {
        this.synthesizedFrameName = uploadDialogState.synthesizedFrameName;
    }

    private void killSynthesizedFrame(String string) {
        NodeList nodeList = Document.get().getElementsByTagName("iframe");
        for (int i = 0; i < nodeList.getLength(); ++i) {
            Element element = (Element)nodeList.getItem(i);
            if (!element.hasAttribute("name") || !element.getAttribute("name").equals(string)) continue;
            LogUtilities.warn("kill synthesized frame: " + string + " to stop uploading.");
            element.removeFromParent();
            this.onloadstrategy.unHookEvents(element);
        }
    }
}

