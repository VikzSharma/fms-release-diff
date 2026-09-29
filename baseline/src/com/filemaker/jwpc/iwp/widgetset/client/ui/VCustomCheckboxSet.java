/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.event.dom.client.ClickEvent
 *  com.google.gwt.user.client.ui.CheckBox
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.jwpc.iwp.widgetset.client.rpc.CheckboxSetServerRpc;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomRadioSet;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.CheckBox;

public class VCustomCheckboxSet
extends VCustomRadioSet {
    private CheckboxSetServerRpc rpc;

    public void registerCheckboxSetServerRpc(CheckboxSetServerRpc checkboxSetServerRpc) {
        this.rpc = checkboxSetServerRpc;
    }

    @Override
    public void onClick(ClickEvent clickEvent) {
        if (this.hasScript()) {
            clickEvent.preventDefault();
            return;
        }
        CheckBox checkBox = (CheckBox)clickEvent.getSource();
        String string = this.getKeyForOption(checkBox);
        if (checkBox.getValue().booleanValue() && this.selectedKeys.contains(string) || !checkBox.getValue().booleanValue() && !this.selectedKeys.contains(string)) {
            return;
        }
        boolean bl = checkBox.getValue() != false && string != null && this.selectedKeys.contains(string);
        this.rpc.onClick(this.getSelectedItems(), checkBox.getValue(), checkBox.getText(), bl);
        super.onClick(clickEvent);
    }
}

