/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.dom.client.Element
 *  com.google.gwt.dom.client.Node
 *  com.google.gwt.user.client.DOM
 *  com.google.gwt.user.client.Event
 *  com.google.gwt.user.client.EventListener
 *  com.vaadin.client.ui.VCssLayout
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.jwpc.iwp.widgetset.client.connector.AppleIDSendEmailButtonConnector;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Node;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.EventListener;
import com.vaadin.client.ui.VCssLayout;

public class VCustomAppleIDSendEmailButton
extends VCssLayout {
    private Element button;
    private AppleIDSendEmailButtonConnector.AppleIDSendEmailCallback callback;

    public VCustomAppleIDSendEmailButton() {
        this.initButton();
    }

    public void setButtonText(String string) {
        this.button.setInnerHTML(string);
    }

    public void registerCallback(AppleIDSendEmailButtonConnector.AppleIDSendEmailCallback appleIDSendEmailCallback) {
        this.callback = appleIDSendEmailCallback;
    }

    private void initButton() {
        this.button = DOM.createButton();
        this.button.setClassName("fm-appleid-login-dialog-send-button");
        this.getElement().appendChild((Node)this.button);
        Event.sinkEvents((Element)this.button, (int)1);
        Event.setEventListener((Element)this.button, (EventListener)new EventListener(){

            public void onBrowserEvent(Event event) {
                if (event.getTypeInt() == 1) {
                    VCustomAppleIDSendEmailButton.this.callback.onAppleIDSendEmail();
                }
            }
        });
    }
}

