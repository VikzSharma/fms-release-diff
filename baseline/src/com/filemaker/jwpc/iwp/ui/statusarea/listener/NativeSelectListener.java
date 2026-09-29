/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.v7.data.Property$ValueChangeEvent
 *  com.vaadin.v7.data.Property$ValueChangeListener
 *  com.vaadin.v7.ui.Field$ValueChangeEvent
 */
package com.filemaker.jwpc.iwp.ui.statusarea.listener;

import com.filemaker.jwpc.iwp.action.GlobalUIActionHandlers;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.ui.statusarea.component.NativeSelect;
import com.vaadin.v7.data.Property;
import com.vaadin.v7.ui.Field;

public class NativeSelectListener
implements Property.ValueChangeListener {
    private final App app;
    private final NativeSelect<?> target;

    public NativeSelectListener(App app, NativeSelect<?> nativeSelect) {
        this.app = app;
        this.target = nativeSelect;
        this.target.setListener(this);
    }

    public void valueChange(Property.ValueChangeEvent valueChangeEvent) {
        Object object = ((Field.ValueChangeEvent)valueChangeEvent).getSource();
        if (object == this.target) {
            String string = valueChangeEvent.getProperty().toString();
            GlobalUIActionHandlers.GOTO_LAYOUT_BY_NAME.perform(this.app, new Object[]{string});
        }
    }
}

