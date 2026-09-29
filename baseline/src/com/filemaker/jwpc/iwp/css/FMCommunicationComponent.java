/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.AbstractComponent
 */
package com.filemaker.jwpc.iwp.css;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.ui.event.EventType;
import com.filemaker.jwpc.iwp.ui.event.UIEvent;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.FMCommunicationClientRpc;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.FMCommunicationServerRpc;
import com.filemaker.jwpc.iwp.widgetset.client.state.FMCommunicationState;
import com.filemaker.jwpc.iwp.widgetset.client.state.LayoutLinksBean;
import com.vaadin.ui.AbstractComponent;
import java.util.ArrayList;

public class FMCommunicationComponent
extends AbstractComponent {
    private final App app;

    public FMCommunicationComponent(final App app) {
        this.app = app;
        this.setWidth("0px");
        this.setHeight("0px");
        this.setVisible(true);
        FMCommunicationServerRpc fMCommunicationServerRpc = new FMCommunicationServerRpc(){
            final /* synthetic */ FMCommunicationComponent this$0;
            {
                this.this$0 = fMCommunicationComponent;
            }

            @Override
            public void performBrowserResize(int n, int n2) {
                app.browserResized(n, n2);
            }

            @Override
            public void setIsPlayingFullScreen(boolean bl) {
                app.setIsPlayingFullScreen(bl);
            }

            @Override
            public void onCssUpdated() {
                app.notify(new UIEvent(EventType.CSS_UPDATED));
            }

            @Override
            public void onOverrideCssUpdated() {
                app.notify(new UIEvent(EventType.OVERRIDE_CSS_UPDATED));
            }
        };
        this.registerRpc(fMCommunicationServerRpc);
    }

    public synchronized void updateLayoutLinks(String string, String string2) {
        LayoutLinksBean layoutLinksBean = this.getState().layoutLinks;
        if (this.app.getAppView().isCardStyleWindow()) {
            layoutLinksBean.cardLayoutLinkPath = string;
            layoutLinksBean.cardOverridesLinkPath = string2;
        } else {
            layoutLinksBean.layoutLinkPath = string;
            layoutLinksBean.overridesLinkPath = string2;
            layoutLinksBean.cardLayoutLinkPath = null;
            layoutLinksBean.cardOverridesLinkPath = null;
        }
    }

    public FMCommunicationState getState() {
        return (FMCommunicationState)super.getState();
    }

    public static String getValidLinkId(String string) {
        return string.replaceAll("\\s+", "-");
    }

    public static String getCSSUriPath(String string) {
        return "/fmi/iwp-resources/css/" + string + ".css";
    }

    public void updateTabOrdering(ArrayList<String> arrayList) {
        ((FMCommunicationClientRpc)this.getRpcProxy(FMCommunicationClientRpc.class)).updateTabOrdering(arrayList);
    }

    public void clearActiveField() {
        ((FMCommunicationClientRpc)this.getRpcProxy(FMCommunicationClientRpc.class)).clearActiveField();
    }

    public void performBrowserResize(int n, int n2) {
        ((FMCommunicationClientRpc)this.getRpcProxy(FMCommunicationClientRpc.class)).performBrowserResize(n, n2);
    }

    public void enableLayoutTabOrder(boolean bl) {
        ((FMCommunicationClientRpc)this.getRpcProxy(FMCommunicationClientRpc.class)).enableLayoutTabOrder(bl);
    }
}

