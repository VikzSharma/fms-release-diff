/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.dom.client.Element
 *  com.google.gwt.dom.client.IFrameElement
 *  com.vaadin.client.BrowserInfo
 *  com.vaadin.client.ui.VBrowserFrame
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.jwpc.iwp.widgetset.client.rpc.WDBrowserFrameServerRpc;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.IFrameElement;
import com.vaadin.client.BrowserInfo;
import com.vaadin.client.ui.VBrowserFrame;

public class VCustomWDBrowserFrame
extends VBrowserFrame {
    private static String DATA_URL = "data:text/html,";
    private static String BASE64_DATA_URL = "data:text/html;base64,";
    private static String EMPTY_PENDING_REQUEST_ARRAY = "[]";
    private String source = "about:blank";
    private WDBrowserFrameServerRpc rpc;
    private String uid;
    private boolean allowJSCommunication = false;
    private boolean contentLoaded = false;
    private boolean performingWebScript = false;
    private String pendingPerformScriptRequests = EMPTY_PENDING_REQUEST_ARRAY;
    private PendingWebScriptRequest pendingRequest;
    private String frameLabel;

    public void setUid(String string) {
        this.uid = string;
    }

    public void setAllowJSCommunication(boolean bl) {
        this.allowJSCommunication = bl;
    }

    public void setFrameLabel(String string) {
        this.frameLabel = string;
        if (this.iframe != null) {
            this.iframe.setAttribute("aria-label", string);
        }
    }

    public void setSource(String string) {
        this.source = string;
        super.setSource(string);
        this.checkDataUrl(string);
        if (!(string != null && string.length() != 0 || this.contentLoaded)) {
            this.onContentLoaded();
        }
    }

    public void registerRpc(WDBrowserFrameServerRpc wDBrowserFrameServerRpc) {
        this.rpc = wDBrowserFrameServerRpc;
    }

    public void addWebScriptRequest(String string, String[] stringArray) {
        this.pendingRequest = new PendingWebScriptRequest(this, string, stringArray);
    }

    protected void onAttach() {
        super.onAttach();
        if (BrowserInfo.get().isIE() && this.iframe != null && !this.iframe.getSrc().equals(this.source)) {
            this.iframe.setSrc(this.source);
            this.checkDataUrl(this.source);
        }
        this.contentLoaded = false;
    }

    protected IFrameElement createIFrameElement(String string) {
        IFrameElement iFrameElement = super.createIFrameElement(string);
        iFrameElement.setPropertyString("uid", this.uid);
        iFrameElement.setAttribute("aria-label", this.frameLabel);
        this.checkDataUrl(string);
        this.initIFrameInjection(this.iframe);
        this.contentLoaded = false;
        return iFrameElement;
    }

    private void checkDataUrl(String string) {
        if (string.startsWith(DATA_URL)) {
            this.setDataUrl(string.substring(DATA_URL.length()), this.iframe);
        } else if (string.startsWith(BASE64_DATA_URL)) {
            this.setDataUrl(FMCUtilities.Base64Decode(string.substring(BASE64_DATA_URL.length())), this.iframe);
        }
    }

    private native void setDataUrl(String var1, IFrameElement var2);

    private native void initIFrameInjection(IFrameElement var1);

    private void onContentLoaded() {
        this.injectJS((Element)this.iframe);
        this.onWebdInternalRefresh((Element)this.iframe);
        this.onContentFinallyLoaded();
    }

    private void onContentFinallyLoaded() {
        this.contentLoaded = true;
        if (this.pendingRequest != null) {
            this.performWebScript((Element)this.iframe, this.pendingRequest.methodName, this.pendingRequest.parameters);
            this.pendingRequest = null;
        }
    }

    private native void injectJS(Element var1);

    private native void injectMessageHandler(Element var1);

    private native void injectFileMakerJavaScriptObject(Element var1);

    private native void onWebdInternalRefresh(Element var1);

    public IFrameElement getFrame() {
        return this.iframe;
    }

    public boolean isContentLoaded() {
        return this.contentLoaded;
    }

    public native boolean hasWebScript(Element var1, String var2);

    public native void performWebScript(Element var1, String var2, String[] var3);

    public void performWebScriptDone(String string) {
        if (this.rpc != null) {
            if (!this.pendingPerformScriptRequests.equals(EMPTY_PENDING_REQUEST_ARRAY)) {
                this.rpc.performWebScriptDone(string, true, "Script invoked", this.pendingPerformScriptRequests);
                this.pendingPerformScriptRequests = EMPTY_PENDING_REQUEST_ARRAY;
            } else {
                this.rpc.performWebScriptDone(string, true, "Script invoked", null);
            }
        }
        this.injectMessageHandler((Element)this.iframe);
    }

    private void performScript(String string, String string2, String string3) {
        if (this.performingWebScript) {
            this.addPendingPerformScriptRequest(string, string2, string3);
        } else {
            this.performScriptImpl(string, string2, string3);
        }
    }

    public native void addPendingPerformScriptRequest(String var1, String var2, String var3);

    public native void performScriptImpl(String var1, String var2, String var3);

    public class PendingWebScriptRequest {
        public String methodName;
        public String[] parameters;

        public PendingWebScriptRequest(VCustomWDBrowserFrame vCustomWDBrowserFrame, String string, String[] stringArray) {
            this.methodName = string;
            this.parameters = stringArray;
        }
    }
}

