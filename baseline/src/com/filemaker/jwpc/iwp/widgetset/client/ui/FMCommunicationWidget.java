/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.user.client.DOM
 *  com.google.gwt.user.client.ui.Widget
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.jwpc.iwp.widgetset.client.rpc.FMCommunicationServerRpc;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Widget;
import java.util.Set;

public class FMCommunicationWidget
extends Widget {
    private FMCommunicationServerRpc rpc;

    public FMCommunicationWidget() {
        this.setElement(DOM.createSpan());
        this.setWidth("0");
        this.setHeight("0");
    }

    public void registerCommunicationServerRpc(FMCommunicationServerRpc fMCommunicationServerRpc) {
        this.rpc = fMCommunicationServerRpc;
    }

    public void removeCssLinks(Set<String> set) {
        for (String string : set) {
            this.removeCssElementById(string);
        }
    }

    public void removeCssLink(String string) {
        this.removeCssElementById(string);
    }

    public native void updateCssLink(String var1, String var2, boolean var3);

    private native void removeCssElementById(String var1);

    private void onCssUpdated() {
        this.rpc.onCssUpdated();
    }

    private void onOverrideCssUpdated() {
        this.rpc.onOverrideCssUpdated();
    }
}

