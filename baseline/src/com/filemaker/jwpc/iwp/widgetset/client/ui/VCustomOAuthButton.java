/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.JavaScriptObject
 *  com.google.gwt.dom.client.Element
 *  com.google.gwt.dom.client.Node
 *  com.google.gwt.http.client.URL
 *  com.google.gwt.user.client.DOM
 *  com.google.gwt.user.client.Event
 *  com.google.gwt.user.client.EventListener
 *  com.google.gwt.xhr.client.ReadyStateChangeHandler
 *  com.google.gwt.xhr.client.XMLHttpRequest
 *  com.vaadin.client.BrowserInfo
 *  com.vaadin.client.ui.VCssLayout
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.jwpc.iwp.widgetset.client.connector.OAuthButtonConnector;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Node;
import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.EventListener;
import com.google.gwt.xhr.client.ReadyStateChangeHandler;
import com.google.gwt.xhr.client.XMLHttpRequest;
import com.vaadin.client.BrowserInfo;
import com.vaadin.client.ui.VCssLayout;

public class VCustomOAuthButton
extends VCssLayout {
    private Element button;
    private OAuthButtonConnector.OAuthSignInCallback callback;
    private String providerName = "_blank";
    private String providerButtonName = "_blank";
    private String providerId = "";
    private String masterAddr = "";
    private String iconUrl = "";
    private String oauthTrackingId = "";
    private String oauthRequestId = "";
    private JavaScriptObject oauthResponseListener = this.getOAuthResponseListener();
    private boolean initProviderName = true;
    private boolean initProviderButtonName = true;
    private boolean initProviderId = true;
    private boolean initMasterAddr = true;
    private boolean initIconUrl = true;
    private boolean initButton = true;

    public void setProviderName(String string) {
        this.providerName = string;
        this.initProviderName = false;
        this.tryInitButton();
    }

    public void setProviderButtonName(String string) {
        this.providerButtonName = string;
        this.initProviderButtonName = false;
        this.tryInitButton();
    }

    public void setProviderId(String string) {
        this.providerId = string;
        this.initProviderId = false;
        this.tryInitButton();
    }

    public void setIconUrl(String string) {
        this.iconUrl = string;
        this.initIconUrl = false;
        this.tryInitButton();
    }

    public void setMasterAddr(String string) {
        this.masterAddr = string;
        this.initMasterAddr = false;
        this.tryInitButton();
    }

    public void registerCallback(OAuthButtonConnector.OAuthSignInCallback oAuthSignInCallback) {
        this.callback = oAuthSignInCallback;
    }

    private void tryInitButton() {
        if (!(this.initProviderName || this.initIconUrl || this.initMasterAddr || this.initProviderId || !this.initButton)) {
            this.initButton = false;
            this.button = DOM.createButton();
            this.button.setClassName("oauth_button");
            this.button.setInnerHTML(this.providerButtonName);
            String string = this.masterAddr;
            if (string.isEmpty()) {
                string = this.getBrowserLocationHostname();
            }
            this.setOAuthIcon(this.button, this.providerName, this.iconUrl, this.providerId, string);
            this.getElement().appendChild((Node)this.button);
            Event.sinkEvents((Element)this.button, (int)1);
            Event.setEventListener((Element)this.button, (EventListener)new EventListener(){

                public void onBrowserEvent(Event event) {
                    if (event.getTypeInt() == 1) {
                        VCustomOAuthButton.this.addOAuthResponseListener(VCustomOAuthButton.this.oauthResponseListener);
                        String string = FMCUtilities.isMobile() ? "" : "width=800,height=600";
                        final JavaScriptObject javaScriptObject = VCustomOAuthButton.this.openPopup("about:blank", VCustomOAuthButton.this.providerName, string);
                        XMLHttpRequest xMLHttpRequest = XMLHttpRequest.create();
                        xMLHttpRequest.setOnReadyStateChange(new ReadyStateChangeHandler(){
                            final /* synthetic */ 1 this$1;
                            {
                                this.this$1 = var1_1;
                            }

                            public void onReadyStateChange(XMLHttpRequest xMLHttpRequest) {
                                if (xMLHttpRequest.getReadyState() == 4 && xMLHttpRequest.getStatus() == 200) {
                                    this.this$1.VCustomOAuthButton.this.oauthRequestId = xMLHttpRequest.getResponseHeader("X-FMS-Request-ID");
                                    this.this$1.VCustomOAuthButton.this.setPopupUrl(javaScriptObject, xMLHttpRequest.getResponseText(), BrowserInfo.get().isEdge());
                                }
                            }
                        });
                        VCustomOAuthButton.this.oauthTrackingId = FMCUtilities.getUUID();
                        String string2 = VCustomOAuthButton.this.masterAddr;
                        if (string2.isEmpty()) {
                            string2 = VCustomOAuthButton.this.getBrowserLocationHostname();
                        }
                        string2 = URL.encodeQueryString((String)string2);
                        String string3 = VCustomOAuthButton.this.getBrowserLocationOrigin() + "/fmi/webd/oauth-landing.html";
                        String string4 = "trackingID=" + VCustomOAuthButton.this.oauthTrackingId + "&provider=" + VCustomOAuthButton.this.providerName + "&address=" + string2 + "&X-FMS-OAuth-AuthType=2";
                        xMLHttpRequest.open("GET", "/fmi/webd/oauthapi/getoauthurl?" + string4);
                        xMLHttpRequest.setRequestHeader("X-FMS-Application-Type", "8");
                        xMLHttpRequest.setRequestHeader("X-FMS-Application-Version", "16");
                        xMLHttpRequest.setRequestHeader("X-FMS-Return-URL", string3);
                        xMLHttpRequest.send();
                    }
                }
            });
        }
    }

    private native void setOAuthIcon(Element var1, String var2, String var3, String var4, String var5);

    public void processOAuthResponse(String string) {
        String string2 = this.getOAuthResponseParameter(string, "trackingID");
        if (string2.equals(this.oauthTrackingId)) {
            this.removeOAuthResponseListener(this.oauthResponseListener);
            this.callback.onOAuthSignIn(this.oauthRequestId, this.getOAuthResponseParameter(string, "identifier"), this.getOAuthResponseParameter(string, "error"));
        }
    }

    private String getOAuthResponseParameter(String string, String string2) {
        if (string != null) {
            String[] stringArray;
            for (String string3 : stringArray = string.split("&")) {
                String[] stringArray2 = string3.split("=");
                if (stringArray2 == null || stringArray2.length != 2 || !stringArray2[0].equals(string2)) continue;
                return stringArray2[1];
            }
        }
        return "";
    }

    private native JavaScriptObject openPopup(String var1, String var2, String var3);

    private native void setPopupUrl(JavaScriptObject var1, String var2, boolean var3);

    private native String getBrowserLocationHostname();

    private native String getBrowserLocationOrigin();

    private native String getBrowserLocationProtocol();

    private native JavaScriptObject getOAuthResponseListener();

    private native void addOAuthResponseListener(JavaScriptObject var1);

    private native void removeOAuthResponseListener(JavaScriptObject var1);
}

