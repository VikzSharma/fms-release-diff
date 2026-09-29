/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.Alignment
 *  com.vaadin.ui.Component
 *  com.vaadin.ui.MenuBar
 *  com.vaadin.v7.ui.HorizontalLayout
 */
package com.filemaker.jwpc.iwp.ui.customwidgets;

import com.filemaker.jwpc.iwp.action.ActionSupport;
import com.filemaker.jwpc.iwp.action.UIAction;
import com.filemaker.jwpc.iwp.ui.customwidgets.StatusAreaButton;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.MenuBar;
import com.vaadin.v7.ui.HorizontalLayout;
import java.beans.PropertyChangeEvent;

public class StatusAreaMenuButton
extends HorizontalLayout
implements ActionSupport {
    private StatusAreaButton button;
    private MenuBar menuBar;

    public StatusAreaMenuButton(StatusAreaButton statusAreaButton, MenuBar menuBar) {
        this.button = statusAreaButton;
        this.menuBar = menuBar;
        this.init();
    }

    private void init() {
        this.setMargin(false);
        this.setStyleName("fm-toolbar-item");
        this.setSizeUndefined();
        if (this.button != null) {
            this.addComponent((Component)this.button);
            this.setComponentAlignment((Component)this.button, Alignment.MIDDLE_CENTER);
        }
        if (this.menuBar != null) {
            this.addComponent((Component)this.menuBar);
            this.setComponentAlignment((Component)this.menuBar, Alignment.MIDDLE_CENTER);
        }
    }

    @Override
    public void performAction(Object[] objectArray) {
        if (this.button != null && this.button.hasAction()) {
            this.button.performAction(objectArray);
        }
    }

    @Override
    public void setAction(UIAction uIAction) {
        this.button.setAction(uIAction);
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        this.setEnabled((Boolean)propertyChangeEvent.getNewValue());
    }
}

