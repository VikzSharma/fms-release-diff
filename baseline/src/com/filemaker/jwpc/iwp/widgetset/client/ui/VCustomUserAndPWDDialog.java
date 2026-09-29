/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.Scheduler
 *  com.google.gwt.core.client.Scheduler$ScheduledCommand
 *  com.google.gwt.dom.client.Element
 *  com.google.gwt.dom.client.NodeList
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.jwpc.iwp.widgetset.client.rpc.UserAndPasswordDialogServerRPC;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomDialog;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NodeList;

public class VCustomUserAndPWDDialog
extends VCustomDialog {
    private UserAndPasswordDialogServerRPC serverRPC;

    public void show() {
        super.show();
        Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand(){

            public void execute() {
                if (VCustomUserAndPWDDialog.this.serverRPC != null) {
                    VCustomUserAndPWDDialog.this.serverRPC.setDefaultFocus();
                }
            }
        });
    }

    public void turnOffAutoComplete() {
        NodeList nodeList = this.getElement().getElementsByTagName("input");
        for (int i = 0; i < nodeList.getLength(); ++i) {
            String string;
            Element element = (Element)nodeList.getItem(i);
            if (element == null || !(string = element.getAttribute("type").toLowerCase()).equals("password") && !string.equals("text")) continue;
            element.setAttribute("autocomplete", "off");
        }
    }

    public void setPlaceholderText(String string, String string2) {
        NodeList nodeList = this.getElement().getElementsByTagName("input");
        for (int i = 0; i < nodeList.getLength(); ++i) {
            Element element = (Element)nodeList.getItem(i);
            if (element == null) continue;
            String string3 = element.getAttribute("type").toLowerCase();
            if (string3.equals("text")) {
                element.setAttribute("placeholder", string);
                continue;
            }
            if (!string3.equals("password")) continue;
            element.setAttribute("placeholder", string2);
        }
    }

    public void setAriaLabel(String string, String string2) {
        NodeList nodeList = this.getElement().getElementsByTagName("input");
        for (int i = 0; i < nodeList.getLength(); ++i) {
            Element element = (Element)nodeList.getItem(i);
            if (element == null) continue;
            String string3 = element.getAttribute("type").toLowerCase();
            if (string3.equals("text")) {
                element.setAttribute("aria-label", string);
                continue;
            }
            if (!string3.equals("password")) continue;
            element.setAttribute("aria-label", string2);
        }
    }

    public void setRPC(UserAndPasswordDialogServerRPC userAndPasswordDialogServerRPC) {
        this.serverRPC = userAndPasswordDialogServerRPC;
    }
}

