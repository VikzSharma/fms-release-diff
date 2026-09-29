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

import com.filemaker.jwpc.iwp.widgetset.client.connector.AppleIDSignInButtonConnector;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Node;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.EventListener;
import com.vaadin.client.ui.VCssLayout;

public class VCustomAppleIDSignInButton
extends VCssLayout {
    private Element button;
    private AppleIDSignInButtonConnector.AppleIDSignInCallback callback;
    private String text = "";

    public void setButtonText(String string) {
        this.text = string;
        this.initButton();
    }

    public void registerCallback(AppleIDSignInButtonConnector.AppleIDSignInCallback appleIDSignInCallback) {
        this.callback = appleIDSignInCallback;
    }

    private void initButton() {
        this.button = DOM.createButton();
        this.button.setClassName("fm-appleid-login-dialog-signin-button");
        this.button.setInnerHTML(this.text);
        this.getElement().appendChild((Node)this.button);
        Event.sinkEvents((Element)this.button, (int)1);
        Event.setEventListener((Element)this.button, (EventListener)new EventListener(){

            public void onBrowserEvent(Event event) {
                if (event.getTypeInt() == 1) {
                    VCustomAppleIDSignInButton.this.callback.onAppleIDSigningIn();
                }
            }
        });
    }
}

