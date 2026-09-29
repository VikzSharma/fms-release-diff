/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.Scheduler
 *  com.google.gwt.core.client.Scheduler$ScheduledCommand
 *  com.google.gwt.event.dom.client.KeyDownEvent
 *  com.google.gwt.event.dom.client.KeyDownHandler
 *  com.google.gwt.event.shared.EventHandler
 *  com.google.gwt.user.client.ui.Widget
 *  com.vaadin.client.ui.VCssLayout
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.ui.HasMultiNavigableItems;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.ui.VCssLayout;

public class VCustomFindRequestIncludeOmit
extends VCssLayout
implements HasMultiNavigableItems {
    private Widget prev;
    private Widget next;

    public void add(final Widget widget) {
        super.add(widget);
        if (FMCUtilities.useAriaCompliantControl()) {
            final int n = this.getWidgetCount() - 1;
            Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand(){
                final /* synthetic */ VCustomFindRequestIncludeOmit this$0;
                {
                    this.this$0 = vCustomFindRequestIncludeOmit;
                }

                public void execute() {
                    this.this$0.initNavigationControl(n, widget);
                }
            });
        }
    }

    private void initNavigationControl(int n, Widget widget) {
        if (n == 0) {
            widget.addDomHandler((EventHandler)new KeyDownHandler(){

                public void onKeyDown(KeyDownEvent keyDownEvent) {
                    switch (keyDownEvent.getNativeKeyCode()) {
                        case 9: {
                            if (!keyDownEvent.isShiftKeyDown()) break;
                            keyDownEvent.preventDefault();
                            keyDownEvent.stopPropagation();
                            if (VCustomFindRequestIncludeOmit.this.prev == null) break;
                            VCustomFindRequestIncludeOmit.this.prev.getElement().focus();
                            break;
                        }
                        case 37: 
                        case 38: {
                            if (VCustomFindRequestIncludeOmit.this.prev == null) break;
                            VCustomFindRequestIncludeOmit.this.prev.getElement().focus();
                            break;
                        }
                        case 39: 
                        case 40: {
                            VCustomFindRequestIncludeOmit.this.getWidget(1).getElement().focus();
                            break;
                        }
                    }
                }
            }, KeyDownEvent.getType());
        } else {
            widget.addDomHandler((EventHandler)new KeyDownHandler(){

                public void onKeyDown(KeyDownEvent keyDownEvent) {
                    switch (keyDownEvent.getNativeKeyCode()) {
                        case 37: 
                        case 38: {
                            VCustomFindRequestIncludeOmit.this.getWidget(0).getElement().focus();
                            break;
                        }
                        case 39: 
                        case 40: {
                            if (VCustomFindRequestIncludeOmit.this.next == null) break;
                            VCustomFindRequestIncludeOmit.this.next.getElement().focus();
                            break;
                        }
                    }
                }
            }, KeyDownEvent.getType());
        }
    }

    @Override
    public void setPrev(Widget widget) {
        this.prev = widget;
    }

    @Override
    public void setNext(Widget widget) {
        this.next = widget;
    }

    @Override
    public void setFocus(boolean bl) {
        this.getWidget(bl ? 1 : 0).getElement().focus();
    }
}

