/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.v7.data.Property$ValueChangeEvent
 *  com.vaadin.v7.data.Property$ValueChangeListener
 */
package com.filemaker.jwpc.iwp.ui.layout.listener;

import com.filemaker.jwpc.iwp.action.GlobalUIActionHandlers;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.ui.layout.component.RadioSet;
import com.filemaker.jwpc.iwp.ui.layout.listener.FieldListener;
import com.vaadin.v7.data.Property;

public class RadioSetListener
extends FieldListener
implements Property.ValueChangeListener {
    private final RadioSet source;
    private boolean valueChangeListenerEnabled = true;

    public RadioSetListener(App app, RadioSet radioSet) {
        super(app, radioSet);
        this.source = radioSet;
    }

    public void enableValueChangeListener() {
        this.valueChangeListenerEnabled = true;
    }

    public void disableValueChangeListener() {
        this.valueChangeListenerEnabled = false;
    }

    public boolean isValueChangeListenerEnabled() {
        return this.valueChangeListenerEnabled;
    }

    public synchronized void valueChange(Property.ValueChangeEvent valueChangeEvent) {
        if (this.valueChangeListenerEnabled) {
            GlobalUIActionHandlers.MODIFY_FIELD_TEXT.perform(this.app, new Object[]{this.source, this.source.getFieldData().toString(), false});
        }
    }
}

