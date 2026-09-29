/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.Scheduler
 *  com.google.gwt.core.client.Scheduler$ScheduledCommand
 *  com.google.gwt.dom.client.Element
 *  com.google.gwt.event.logical.shared.ResizeEvent
 *  com.google.gwt.event.logical.shared.ResizeHandler
 *  com.google.gwt.event.shared.HandlerRegistration
 *  com.google.gwt.user.client.Timer
 *  com.google.gwt.user.client.Window
 *  com.vaadin.client.ui.VButton
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.vaadin.client.ui.VButton;

public class VCustomDialogButton
extends VButton {
    private boolean fitCaption = false;
    private String curText = "";
    private HandlerRegistration resizeHandler = null;
    public static final int maxFontSize = 16;
    public static final int minFontSize = 11;
    public static final int minCharSize = 6;

    private void updateFitCaptionState() {
        if (FMCUtilities.isMobile() && this.getElement() != null && this.getElement().getParentElement() != null) {
            this.fitCaption = this.getElement().getParentElement().getClassName().contains("fm-button-fitcaption");
        }
    }

    public void onLoad() {
        this.updateFitCaptionState();
        if (this.fitCaption) {
            this.enableResizeHandler(true);
        }
    }

    public void onUnload() {
        if (this.fitCaption) {
            this.enableResizeHandler(false);
        }
    }

    public void enableResizeHandler(boolean bl) {
        if (bl) {
            if (this.resizeHandler == null) {
                this.resizeHandler = Window.addResizeHandler((ResizeHandler)new ResizeHandler(){
                    Timer resizeTimer = new Timer(){

                        public void run() {
                            VCustomDialogButton.this.adjustCaptionText();
                        }
                    };

                    public void onResize(ResizeEvent resizeEvent) {
                        this.resizeTimer.cancel();
                        this.resizeTimer.schedule(500);
                    }
                });
            }
        } else if (this.resizeHandler != null) {
            this.resizeHandler.removeHandler();
        }
    }

    private boolean adjustCaptionText() {
        if (this.fitCaption) {
            Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand(){

                public void execute() {
                    String string = VCustomDialogButton.getFittedCaptionText(VCustomDialogButton.this.captionElement, VCustomDialogButton.this.wrapper, VCustomDialogButton.this.curText, 16, 11);
                    VCustomDialogButton.super.setText(string);
                }
            });
            return true;
        }
        return false;
    }

    private void setCaptionText(String string) {
        boolean bl = false;
        this.updateFitCaptionState();
        if (this.fitCaption && this.curText != string) {
            this.curText = string;
            if (string.getBytes().length > 6) {
                bl = this.adjustCaptionText();
            }
        }
        if (!bl) {
            super.setText(string);
        }
    }

    public void setText(String string) {
        this.setCaptionText(string);
    }

    private static native String getFittedCaptionText(Element var0, Element var1, String var2, int var3, int var4);
}

