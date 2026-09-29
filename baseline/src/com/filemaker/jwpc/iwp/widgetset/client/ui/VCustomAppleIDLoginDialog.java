/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.dom.client.Element
 *  com.google.gwt.user.client.DOM
 *  com.google.gwt.user.client.Event
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.jwpc.iwp.widgetset.client.rpc.AppleIDLoginDialogServerRpc;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomUserAndPWDDialog;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;

public class VCustomAppleIDLoginDialog
extends VCustomUserAndPWDDialog {
    private AppleIDLoginDialogServerRpc serverRpc = null;

    public VCustomAppleIDLoginDialog() {
        DOM.sinkEvents((Element)this.getElement(), (int)(DOM.getEventsSunk((Element)this.getElement()) | 0x80000 | 0x200));
    }

    public void setServerRpc(AppleIDLoginDialogServerRpc appleIDLoginDialogServerRpc) {
        this.serverRpc = appleIDLoginDialogServerRpc;
    }

    public void onBrowserEvent(Event event) {
        super.onBrowserEvent(event);
        switch (event.getTypeInt()) {
            case 524288: {
                this.handlePasteEvent(event);
                break;
            }
            case 512: {
                this.handleOnKeyUpEvent(event);
                break;
            }
        }
    }

    private void handlePasteEvent(Event event) {
        if (this.isEmailFocus()) {
            if (this.serverRpc != null) {
                this.serverRpc.handleEmailPaste(this.getPasteText(event));
            }
        } else if (this.isPasscodeFocus()) {
            if (this.serverRpc != null) {
                this.serverRpc.handlePasscodePaste(this.getPasteText(event));
            }
            FMCUtilities.removeFocus();
        }
        event.preventDefault();
        event.stopPropagation();
    }

    private void handleOnKeyUpEvent(Event event) {
        if (this.isPasscodeFocus()) {
            boolean bl = false;
            boolean bl2 = false;
            if (event.getKeyCode() == 8 || event.getKeyCode() == 37) {
                bl2 = true;
                if (event.getKeyCode() == 8) {
                    bl = true;
                }
            }
            if (this.serverRpc != null) {
                this.serverRpc.handleOnKeyUpEvent(bl, bl2, this.getCurrentActivePasscodeIndex(), this.getContent());
                if (!bl2 && this.getCurrentActivePasscodeIndex() == 5) {
                    FMCUtilities.removeFocus();
                }
            }
        }
        event.preventDefault();
        event.stopPropagation();
    }

    private native boolean isEmailFocus();

    private native boolean isPasscodeFocus();

    private native String getPasteText(Event var1);

    private native int getCurrentActivePasscodeIndex();

    private native String getContent();
}

