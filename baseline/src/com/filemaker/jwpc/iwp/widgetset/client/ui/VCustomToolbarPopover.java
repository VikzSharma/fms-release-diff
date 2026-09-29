/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.Scheduler
 *  com.google.gwt.core.client.Scheduler$ScheduledCommand
 *  com.google.gwt.event.dom.client.FocusEvent
 *  com.google.gwt.event.dom.client.FocusHandler
 *  com.vaadin.client.ui.VWindow
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomToolbarPopoverLayout;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.vaadin.client.ui.VWindow;

public class VCustomToolbarPopover
extends VWindow {
    private float displayHeight = -1.0f;
    private boolean focusOnDetach = false;

    public VCustomToolbarPopover() {
        if (FMCUtilities.useAriaCompliantControl()) {
            this.contentPanel.addFocusHandler(new FocusHandler(){

                public void onFocus(FocusEvent focusEvent) {
                    Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand(){

                        public void execute() {
                            VCustomToolbarPopover.this.setFocusToFirstElement();
                        }
                    });
                }
            });
        }
    }

    public void setDisplayHeight(float f) {
        this.displayHeight = f;
    }

    public void setHeight(String object) {
        if (this.displayHeight > -1.0f) {
            object = this.displayHeight + "px";
        }
        super.setHeight((String)object);
    }

    public void setFocusToFirstElement() {
        ((VCustomToolbarPopoverLayout)this.contentPanel.getWidget()).setFocusToFirstElement();
    }

    public void setFocusOnDetach(boolean bl) {
        this.focusOnDetach = bl;
    }

    protected void onDetach() {
        if (this.focusOnDetach) {
            this.setFocusToParent();
            this.focusOnDetach = false;
        }
        super.onDetach();
    }

    public void setFocusToParent() {
        ((VCustomToolbarPopoverLayout)this.contentPanel.getWidget()).setFocusToParent();
    }
}

