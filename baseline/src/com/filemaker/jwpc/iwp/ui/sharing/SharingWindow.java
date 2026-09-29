/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.event.Action
 *  com.vaadin.server.ExternalResource
 *  com.vaadin.server.PaintException
 *  com.vaadin.server.PaintTarget
 *  com.vaadin.server.Resource
 *  com.vaadin.server.Sizeable$Unit
 *  com.vaadin.ui.Component
 *  com.vaadin.ui.UI
 *  com.vaadin.ui.Window
 *  com.vaadin.ui.Window$CloseEvent
 *  com.vaadin.ui.Window$CloseListener
 *  com.vaadin.ui.Window$CloseShortcut
 */
package com.filemaker.jwpc.iwp.ui.sharing;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.ui.layout.component.WDBrowserFrame;
import com.vaadin.event.Action;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.PaintException;
import com.vaadin.server.PaintTarget;
import com.vaadin.server.Resource;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.Component;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;
import java.util.ArrayList;

public class SharingWindow
extends Window {
    private final App app;
    private boolean modalWindowInDisplay = false;
    private WDBrowserFrame browserFrame;

    public SharingWindow(final App app, String string) {
        this.app = app;
        this.setModal(true);
        this.setResizable(false);
        this.setStyleName("iwp-sharing-window");
        this.addCloseListener(new Window.CloseListener(){
            final /* synthetic */ SharingWindow this$0;
            {
                this.this$0 = sharingWindow;
            }

            public void windowClose(Window.CloseEvent closeEvent) {
                app.getAppController().getSharingWindowHandler().closeWindow();
            }
        });
        this.addCloseShortcut(27, new int[0]);
        this.browserFrame = this.createBrowserFrame("");
        this.browserFrame.setSource((Resource)new ExternalResource(string));
    }

    private WDBrowserFrame createBrowserFrame(String string) {
        WDBrowserFrame wDBrowserFrame = new WDBrowserFrame(this.app, string, "v-sharing-window", false);
        return wDBrowserFrame;
    }

    public void addCloseShortcut(int n, int ... nArray) {
        this.addAction((Action)new Window.CloseShortcut(this, n, nArray){

            public void handleAction(Object object, Object object2) {
                SharingWindow.this.close();
            }
        });
    }

    public synchronized void show() {
        this.app.enableTouchScroll(false);
        this.setVisible(true);
        this.app.addWindow(this);
        this.display();
        this.focus();
    }

    void display() {
        float f = 0.6f * (float)this.app.getPage().getBrowserWindowWidth();
        float f2 = 0.8f * (float)this.app.getPage().getBrowserWindowHeight();
        this.browserFrame.setWidth(f, Sizeable.Unit.PIXELS);
        this.browserFrame.setHeight(f2, Sizeable.Unit.PIXELS);
        this.setContent((Component)this.browserFrame);
    }

    public void focus() {
        if (!this.app.getActiveUIHandler().isActiveObjectInPopover()) {
            super.focus();
        } else {
            this.bringToFront();
        }
    }

    public void bringToFront() {
        UI uI = this.getUI();
        if (uI != null) {
            for (Window window : uI.getWindows()) {
                if (!window.isModal()) continue;
                this.modalWindowInDisplay = true;
                return;
            }
        }
    }

    public synchronized void paintContent(PaintTarget paintTarget) throws PaintException {
        if (this.modalWindowInDisplay) {
            paintTarget.addAttribute("bringToFront", -1);
            this.modalWindowInDisplay = false;
        }
        super.paintContent(paintTarget);
    }

    private void closeOpenSharingWindows() {
        ArrayList<Window> arrayList = new ArrayList<Window>();
        for (Window window : this.app.getWindows()) {
            if (!(window instanceof SharingWindow)) continue;
            arrayList.add(window);
        }
        for (Window window : arrayList) {
            this.app.removeWindow(window);
        }
    }

    public void close() {
        if (this.getParent() != null) {
            this.app.enableTouchScroll(true);
            this.setVisible(false);
            this.closeOpenSharingWindows();
            this.app.focus();
        }
    }

    void clear() {
        this.close();
    }
}

