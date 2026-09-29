/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.v7.ui.TextField
 */
package com.filemaker.jwpc.iwp.ui.common;

import com.filemaker.jwpc.iwp.widgetset.client.rpc.IntegerFieldClientRpc;
import com.filemaker.jwpc.iwp.widgetset.client.state.IntegerFieldState;
import com.vaadin.v7.ui.TextField;

public class IntegerField
extends TextField {
    public IntegerFieldState getState() {
        return (IntegerFieldState)super.getState();
    }

    public void setDefaultValue(int n) {
        this.getState().defaultValue = n;
    }

    public void setAllowZero(boolean bl) {
        this.getState().allowZero = bl;
    }

    public void setFocus() {
        ((IntegerFieldClientRpc)this.getRpcProxy(IntegerFieldClientRpc.class)).setFocus();
    }

    public void setMinValue(int n) {
        this.getState().minValue = n;
    }
}

