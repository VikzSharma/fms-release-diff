/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.dom.client.Style
 *  com.google.gwt.dom.client.Style$Position
 *  com.google.gwt.dom.client.Style$Unit
 *  com.google.gwt.dom.client.Style$Visibility
 *  com.vaadin.client.ServerConnector
 *  com.vaadin.client.communication.RpcProxy
 *  com.vaadin.client.communication.StateChangeEvent
 *  com.vaadin.client.ui.csslayout.CssLayoutConnector
 *  com.vaadin.shared.ui.Connect
 */
package com.filemaker.jwpc.iwp.widgetset.client.connector;

import com.filemaker.jwpc.iwp.ui.layout.component.HiddenObject;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.HiddenObjectClientRpc;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.HiddenObjectServerRpc;
import com.filemaker.jwpc.iwp.widgetset.client.state.HiddenObjectState;
import com.google.gwt.dom.client.Style;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.csslayout.CssLayoutConnector;
import com.vaadin.shared.ui.Connect;

@Connect(value=HiddenObject.class)
public class HiddenObjectConnector
extends CssLayoutConnector {
    private HiddenObjectServerRpc rpc = (HiddenObjectServerRpc)RpcProxy.create(HiddenObjectServerRpc.class, (ServerConnector)this);

    public HiddenObjectConnector() {
        this.registerRpc(HiddenObjectClientRpc.class, new HiddenObjectClientRpc(){

            @Override
            public void sendObjectPosition() {
                HiddenObjectConnector.this.rpc.getObjectPosition(HiddenObjectConnector.this.getWidget().getAbsoluteTop(), HiddenObjectConnector.this.getWidget().getAbsoluteLeft());
            }
        });
    }

    public HiddenObjectState getState() {
        return (HiddenObjectState)super.getState();
    }

    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
        this.setPosition();
    }

    private void setPosition() {
        HiddenObjectState hiddenObjectState = this.getState();
        Style style = this.getWidget().getElement().getStyle();
        style.setLeft((double)hiddenObjectState.l, Style.Unit.PX);
        style.setTop((double)hiddenObjectState.t, Style.Unit.PX);
        style.setWidth((double)hiddenObjectState.w, Style.Unit.PX);
        style.setHeight((double)hiddenObjectState.h, Style.Unit.PX);
        style.setPosition(Style.Position.ABSOLUTE);
        style.setVisibility(Style.Visibility.HIDDEN);
    }
}

