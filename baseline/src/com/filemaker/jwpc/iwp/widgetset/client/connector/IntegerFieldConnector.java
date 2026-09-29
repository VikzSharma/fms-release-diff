/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.ui.Connect
 *  com.vaadin.v7.client.ui.textfield.TextFieldConnector
 */
package com.filemaker.jwpc.iwp.widgetset.client.connector;

import com.filemaker.jwpc.iwp.ui.common.IntegerField;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.IntegerFieldClientRpc;
import com.filemaker.jwpc.iwp.widgetset.client.state.IntegerFieldState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomIntegerField;
import com.vaadin.shared.ui.Connect;
import com.vaadin.v7.client.ui.textfield.TextFieldConnector;

@Connect(value=IntegerField.class)
public class IntegerFieldConnector
extends TextFieldConnector {
    public IntegerFieldConnector() {
        this.registerRpc(IntegerFieldClientRpc.class, new IntegerFieldClientRpc(){

            @Override
            public void setFocus() {
                IntegerFieldConnector.this.getWidget().setFocus();
            }
        });
    }

    public VCustomIntegerField getWidget() {
        return (VCustomIntegerField)super.getWidget();
    }

    public IntegerFieldState getState() {
        return (IntegerFieldState)super.getState();
    }
}

