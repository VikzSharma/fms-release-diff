/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.vaadin.ui.BrowserFrame
 */
package com.filemaker.jwpc.iwp.ui.layout.component;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.thrift.common.PendingPerformScript;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.WDBrowserFrameClientRpc;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.WDBrowserFrameServerRpc;
import com.filemaker.jwpc.iwp.widgetset.client.state.WDBrowserFrameState;
import com.google.gson.Gson;
import com.vaadin.ui.BrowserFrame;
import java.util.Arrays;
import java.util.List;

public class WDBrowserFrame
extends BrowserFrame {
    private App app;
    private final String positionCss;
    private PerformWebScriptResult result;

    public WDBrowserFrame(App app, String string, String string2, boolean bl) {
        this.app = app;
        this.positionCss = string;
        this.setSizeFull();
        this.registerRpc(new WDBrowserFrameServerRpc(){

            @Override
            public void performWebScriptDone(String string, boolean bl, String string2, String string3) {
                WDBrowserFrame.this.performWebScriptDone(string, bl, string2, string3);
            }
        });
        this.getState().uid = string2;
        this.getState().allowJSCommunication = bl;
        this.getState().frameLabel = IWPI18N.get(app, "WEB_VIEWER_FRAME_LABEL", new Object[0]);
    }

    public String getPositionCss() {
        return this.positionCss;
    }

    public WDBrowserFrameState getState() {
        return (WDBrowserFrameState)super.getState();
    }

    public void performWebScript(String string, String[] stringArray) {
        if (this.isConnectorEnabled()) {
            this.result = null;
            ((WDBrowserFrameClientRpc)this.getRpcProxy(WDBrowserFrameClientRpc.class)).performWebScript(string, stringArray);
            this.app.pushChanges();
        } else {
            this.result = new PerformWebScriptResult(string, false, "WebViewer not visible", null);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void performWebScriptDone(String string, boolean bl, String string2, String string3) {
        WDBrowserFrame wDBrowserFrame;
        List<PendingPerformScript> list = null;
        if (string3 != null) {
            wDBrowserFrame = new Gson();
            list = Arrays.asList((PendingPerformScript[])wDBrowserFrame.fromJson(string3, PendingPerformScript[].class));
        }
        wDBrowserFrame = this;
        synchronized (wDBrowserFrame) {
            this.result = new PerformWebScriptResult(string, bl, string2, list);
            ((Object)((Object)this)).notifyAll();
        }
    }

    public PerformWebScriptResult getPerformWebScriptResult() {
        return this.result;
    }

    public static class PerformWebScriptResult {
        public String methodName;
        public boolean success;
        public String result;
        public List<PendingPerformScript> pendingRequests;

        public PerformWebScriptResult(String string, boolean bl, String string2, List<PendingPerformScript> list) {
            this.methodName = string;
            this.success = bl;
            this.result = string2;
            this.pendingRequests = list;
        }
    }
}

