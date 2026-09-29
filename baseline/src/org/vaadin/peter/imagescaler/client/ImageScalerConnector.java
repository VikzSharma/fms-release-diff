/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.GWT
 *  com.google.gwt.core.client.Scheduler
 *  com.google.gwt.core.client.Scheduler$ScheduledCommand
 *  com.google.gwt.event.logical.shared.ResizeEvent
 *  com.google.gwt.event.logical.shared.ResizeHandler
 *  com.google.gwt.event.shared.HandlerRegistration
 *  com.google.gwt.user.client.Window
 *  com.vaadin.client.communication.StateChangeEvent
 *  com.vaadin.client.ui.AbstractComponentConnector
 *  com.vaadin.shared.ui.Connect
 */
package org.vaadin.peter.imagescaler.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Window;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.ui.Connect;
import org.vaadin.peter.imagescaler.ImageScaler;
import org.vaadin.peter.imagescaler.client.ImageScalerState;
import org.vaadin.peter.imagescaler.client.ImageScalerWidget;

@Connect(value=ImageScaler.class)
public class ImageScalerConnector
extends AbstractComponentConnector {
    private static final long serialVersionUID = -1842905344290997916L;
    private HandlerRegistration resizeHandlerRegistration;
    private ResizeHandler resizeHandler = new ResizeHandler(){

        public void onResize(ResizeEvent resizeEvent) {
            ImageScalerConnector.this.getWidget().refreshSize();
        }
    };

    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
        this.getWidget().setOriginalImageWidth(this.getState().getImageWidth());
        this.getWidget().setOriginalImageHeight(this.getState().getImageHeight());
        this.getWidget().setImageURL(this.getResourceUrl("image_resource"));
        this.getWidget().refreshSize();
        if (this.resizeHandlerRegistration != null) {
            this.resizeHandlerRegistration.removeHandler();
        }
        if (this.getState().isRecalculateOnSizeChangeEnabled()) {
            this.resizeHandlerRegistration = Window.addResizeHandler((ResizeHandler)this.resizeHandler);
        }
    }

    protected void init() {
        super.init();
        Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand(){

            public void execute() {
                ImageScalerConnector.this.getWidget().refreshSize();
            }
        });
    }

    public void onUnregister() {
        super.onUnregister();
        if (this.resizeHandlerRegistration != null) {
            this.resizeHandlerRegistration.removeHandler();
        }
    }

    public ImageScalerState getState() {
        return (ImageScalerState)super.getState();
    }

    protected ImageScalerWidget createWidget() {
        return (ImageScalerWidget)((Object)GWT.create(ImageScalerWidget.class));
    }

    public ImageScalerWidget getWidget() {
        return (ImageScalerWidget)super.getWidget();
    }
}

