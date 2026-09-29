/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.v7.ui.NativeSelect
 */
package com.filemaker.jwpc.iwp.ui.statusarea.component;

import com.filemaker.jwpc.iwp.ui.statusarea.listener.NativeSelectListener;
import java.util.List;

public class NativeSelect<T>
extends com.vaadin.v7.ui.NativeSelect {
    private NativeSelectListener listener;

    public NativeSelect() {
    }

    public NativeSelect(List<T> list) {
        this.addItems(list);
    }

    public void setListener(NativeSelectListener nativeSelectListener) {
        this.listener = nativeSelectListener;
    }

    public void disableListener() {
        if (this.listener != null) {
            this.removeValueChangeListener(this.listener);
        }
    }

    public void enableListener() {
        if (this.listener != null) {
            this.addValueChangeListener(this.listener);
        }
    }

    public void addItems(List<T> list) {
        for (T t : list) {
            super.addItem(t);
        }
    }

    public void setDescription(String string) {
        this.getState().description = string;
    }
}

