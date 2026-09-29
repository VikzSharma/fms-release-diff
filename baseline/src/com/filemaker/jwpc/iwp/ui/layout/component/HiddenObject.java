/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.CssLayout
 */
package com.filemaker.jwpc.iwp.ui.layout.component;

import com.filemaker.jwpc.iwp.metadata.ObjectMetaData;
import com.filemaker.jwpc.iwp.thrift.common.LayoutObjectType;
import com.filemaker.jwpc.iwp.ui.layout.LayoutObject;
import com.filemaker.jwpc.iwp.ui.layout.component.popover.PopoverButton;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.HiddenObjectClientRpc;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.HiddenObjectServerRpc;
import com.filemaker.jwpc.iwp.widgetset.client.state.HiddenObjectState;
import com.vaadin.ui.CssLayout;

public class HiddenObject
extends CssLayout {
    private ObjectMetaData metaData = null;
    private LayoutObject layoutObject = null;

    public HiddenObject(ObjectMetaData objectMetaData) {
        this.metaData = objectMetaData;
        if (this.metaData.getType() == LayoutObjectType.POPOVER_BUTTON) {
            this.registerPopoverRpc();
            this.getState().l = this.metaData.getLeftAsInt();
            this.getState().t = this.metaData.getTopAsInt();
            this.getState().w = this.metaData.getWidthAsInt();
            this.getState().h = this.metaData.getHeightAsInt();
        }
    }

    private void registerPopoverRpc() {
        HiddenObjectServerRpc hiddenObjectServerRpc = new HiddenObjectServerRpc(){

            @Override
            public void getObjectPosition(int n, int n2) {
                if (HiddenObject.this.layoutObject != null) {
                    ((PopoverButton)HiddenObject.this.layoutObject).OnServerRpcSend(n, n2);
                }
            }
        };
        this.registerRpc(hiddenObjectServerRpc);
    }

    protected HiddenObjectState getState() {
        return (HiddenObjectState)super.getState();
    }

    public void sendObjectPosition() {
        ((HiddenObjectClientRpc)this.getRpcProxy(HiddenObjectClientRpc.class)).sendObjectPosition();
    }

    public void setLayoutObject(LayoutObject layoutObject) {
        this.layoutObject = layoutObject;
        if (!layoutObject.hasHideCondition()) {
            this.setVisible(false);
        }
    }
}

