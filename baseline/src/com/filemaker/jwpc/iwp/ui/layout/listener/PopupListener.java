/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.ui.layout.listener;

import com.filemaker.fields.client.combobox.ComboBoxItem;
import com.filemaker.fields.interfaces.SelectionChangeListener;
import com.filemaker.jwpc.iwp.action.GlobalUIActionHandlers;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.ui.layout.component.Popup;
import com.filemaker.jwpc.iwp.ui.layout.listener.FieldListener;

public class PopupListener
extends FieldListener
implements SelectionChangeListener {
    private final Popup source;

    public PopupListener(App app, Popup popup) {
        super(app, popup);
        this.source = popup;
    }

    @Override
    public synchronized void selectionChanged(ComboBoxItem comboBoxItem, boolean bl) {
        boolean bl2;
        boolean bl3 = bl2 = this.source.changeFieldOnValueSelection() && bl;
        if (bl) {
            GlobalUIActionHandlers.MODIFY_FIELD_TEXT.perform(this.app, new Object[]{this.source, this.source.getFieldData().toString(), bl2});
        }
    }
}

