/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.ui.layout.component.popover;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.metadata.PopoverButtonMetaData;
import com.filemaker.jwpc.iwp.ui.layout.LayoutView;
import com.filemaker.jwpc.iwp.ui.layout.ObjectAttributes;
import com.filemaker.jwpc.iwp.ui.layout.component.Button;
import com.filemaker.jwpc.iwp.ui.layout.component.HiddenObject;
import com.filemaker.jwpc.iwp.ui.layout.component.popover.PopoverWindow;
import com.filemaker.jwpc.iwp.ui.layout.component.portal.Portal;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.ButtonClientRpc;
import com.filemaker.jwpc.iwp.widgetset.client.state.ButtonState;

public class PopoverButton
extends Button {
    private PopoverWindow popoverWindow = null;
    private HiddenObject hiddenObject = null;

    public PopoverButton(App app, LayoutView layoutView, PopoverButtonMetaData popoverButtonMetaData, ObjectAttributes objectAttributes) {
        super(app, layoutView, popoverButtonMetaData, objectAttributes);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void OnServerRpcSend(int n, int n2) {
        if (this.popoverWindow != null) {
            PopoverWindow popoverWindow = this.popoverWindow;
            synchronized (popoverWindow) {
                this.popoverWindow.show(n, n2);
            }
        }
    }

    public void setPopoverWindow(PopoverWindow popoverWindow) {
        this.popoverWindow = popoverWindow;
    }

    public void refreshButtonClientInfo() {
        if (this.hasHideCondition() && this.isHideConditionOn() && this.hiddenObject != null) {
            this.hiddenObject.sendObjectPosition();
        } else {
            ((ButtonClientRpc)this.getRpcProxy(ButtonClientRpc.class)).sendButtonInfo();
        }
    }

    @Override
    public void setHideConditionOn(boolean bl) {
        super.setHideConditionOn(bl);
        if (this.hiddenObject != null && this.hasHideCondition()) {
            this.hiddenObject.setVisible(bl);
        }
    }

    @Override
    public PopoverButtonMetaData getMetaData() {
        return (PopoverButtonMetaData)super.getMetaData();
    }

    @Override
    public ButtonState getState() {
        return super.getState();
    }

    public Portal getOwningPortal() {
        return this.getAttributes().getOwningPortal();
    }

    @Override
    public boolean allowGlassPaneActivation() {
        return false;
    }

    public boolean isPopoverOpen() {
        return this.popoverWindow != null && this.popoverWindow.getPopover() != null && this.popoverWindow.getPopover().isVisible();
    }

    public void setHiddenObject(HiddenObject hiddenObject) {
        this.hiddenObject = hiddenObject;
        hiddenObject.setLayoutObject(this);
    }

    public HiddenObject getHiddenObject() {
        return this.hiddenObject;
    }
}

