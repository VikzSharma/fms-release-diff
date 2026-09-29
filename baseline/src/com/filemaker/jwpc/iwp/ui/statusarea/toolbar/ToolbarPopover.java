/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.event.Action
 *  com.vaadin.server.PaintException
 *  com.vaadin.server.PaintTarget
 *  com.vaadin.server.Sizeable$Unit
 *  com.vaadin.ui.Component
 *  com.vaadin.ui.CssLayout
 *  com.vaadin.ui.UI
 *  com.vaadin.ui.Window
 *  com.vaadin.ui.Window$CloseShortcut
 *  org.vaadin.ui.ScrollEventPanel$ScrollListener
 */
package com.filemaker.jwpc.iwp.ui.statusarea.toolbar;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.application.AppServlet;
import com.filemaker.jwpc.iwp.notification.processor.BrowserInfoHandler;
import com.filemaker.jwpc.iwp.ui.event.EventType;
import com.filemaker.jwpc.iwp.ui.event.UIEvent;
import com.filemaker.jwpc.iwp.ui.layout.LayoutView;
import com.filemaker.jwpc.iwp.ui.layout.form.LayoutFormView;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.ToolbarPopoverCloser;
import com.filemaker.jwpc.iwp.widgetset.client.state.ToolbarPopoverState;
import com.vaadin.event.Action;
import com.vaadin.server.PaintException;
import com.vaadin.server.PaintTarget;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Timer;
import java.util.TimerTask;
import org.vaadin.ui.ScrollEventPanel;

public abstract class ToolbarPopover
extends Window {
    protected static final int CLOSER_HEIGHT_IN_PIXEL = 30;
    private static final String CSS_CLASS_SELECTOR = "fm-toolbar-popover";
    protected static final int POPOVER_WIDTH = 280;
    protected final App app;
    protected ToolbarPopoverLayout popover;
    protected float displayHeight = -1.0f;
    private boolean modalWindowInDisplay = false;
    private FormScrollListener scrollListener;

    public ToolbarPopover(App app) {
        this.app = app;
        this.setStyleName(CSS_CLASS_SELECTOR);
        this.setSizeUndefined();
        this.setClosable(false);
        this.setResizable(false);
        this.setCloseShortcut(27, new int[0]);
    }

    public void setCloseShortcut(int n, int ... nArray) {
        Collection collection = this.getCloseShortcuts();
        if (collection != null) {
            this.removeAllCloseShortcuts();
        }
        PopoverCloseShortcut popoverCloseShortcut = new PopoverCloseShortcut(this, n, nArray);
        this.addAction((Action)popoverCloseShortcut);
    }

    public synchronized void show(int n) {
        this.popover = this.generatePopover();
        this.app.enableTouchScroll(false);
        this.setVisible(true);
        this.closeOpenPopOvers();
        this.app.addWindow(this);
        this.display(n);
        this.focus();
        this.app.pushChanges();
        this.app.notify(new UIEvent(EventType.REFRESH_TOOLBAR_MENU));
        this.app.getStatusAreaContainer().setShouldExitPopover(false);
    }

    public void close() {
        this.app.enableTouchScroll(true);
        if (this.getParent() != null) {
            this.setVisible(false);
            this.closeOpenPopOvers();
            if (this.scrollListener != null) {
                LayoutView layoutView = this.app.getLayoutContainer().getCurrentView();
                if (layoutView instanceof LayoutFormView) {
                    ((LayoutFormView)layoutView).removeScrollListener(this.scrollListener);
                }
                this.scrollListener = null;
            }
            if (this.popover != null) {
                this.popover = null;
            }
        }
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

    private void closeOpenPopOvers() {
        ArrayList<Window> arrayList = new ArrayList<Window>();
        for (Window window : this.app.getWindows()) {
            if (!(window instanceof ToolbarPopover)) continue;
            arrayList.add(window);
        }
        for (Window window : arrayList) {
            this.app.removeWindow(window);
        }
    }

    public ToolbarPopoverState getState() {
        return (ToolbarPopoverState)super.getState();
    }

    public void beforeClientResponse(boolean bl) {
        super.beforeClientResponse(bl);
        if (BrowserInfoHandler.isAndroidDevice(this.app) && this.getState().displayHeight != this.displayHeight) {
            this.getState().displayHeight = this.displayHeight;
        }
    }

    protected abstract ToolbarPopoverLayout generatePopover();

    public ToolbarPopoverLayout getPopoverLayout() {
        return this.popover;
    }

    private void display(int n) {
        this.adjustHeight();
        this.setContent((Component)this.popover);
        int n2 = this.app.getPage().getBrowserWindowWidth() - (n + 280 + 10);
        this.popover.popoverAbsoluteLeft = n2 >= 0 ? n : n + n2;
        this.setPositionX(this.popover.popoverAbsoluteLeft);
        this.setPositionY(this.popover.popoverAbsoluteTop);
    }

    private void adjustHeight() {
        float f = this.getDisplayHeight();
        if (this.displayHeight != f) {
            this.displayHeight = f;
            this.setHeight(this.displayHeight, Sizeable.Unit.PIXELS);
            this.popover.setHeight(this.displayHeight, Sizeable.Unit.PIXELS);
        }
    }

    private float getDisplayHeight() {
        float f = -1.0f;
        float f2 = this.popover.getHeight();
        if (f2 > -1.0f && (f = (float)(this.app.getBrowserInfoHandler().getBrowserClientInfo().getBrowserDimensions().getHeight() - 49)) > f2) {
            f = f2 + 1.0f;
        }
        return f;
    }

    public void shouldSetFocusOnDetach() {
        this.getState().focusOnDetach = true;
    }

    protected class PopoverCloseShortcut
    extends Window.CloseShortcut {
        public PopoverCloseShortcut(Window window, int n, int ... nArray) {
            super(window, n, nArray);
        }

        public void handleAction(Object object, Object object2) {
            if (AppServlet.isAriaCompliantControlEnabled()) {
                ToolbarPopover.this.shouldSetFocusOnDetach();
                Timer timer = new Timer();
                timer.schedule(new TimerTask(){

                    @Override
                    public void run() {
                        ToolbarPopover.this.app.getStatusAreaContainer().exitPopover();
                        ToolbarPopover.this.app.pushChanges();
                    }
                }, 100L);
            } else {
                ToolbarPopover.this.app.getStatusAreaContainer().exitPopover();
            }
        }
    }

    public abstract class ToolbarPopoverLayout
    extends CssLayout {
        private int popoverAbsoluteTop = 44;
        private int popoverAbsoluteLeft = 0;

        protected ToolbarPopoverLayout() {
            this.initLayout();
            this.setWidth(280.0f, Sizeable.Unit.PIXELS);
            this.addStyleName("fm-toolbar-popover-layout");
            this.addComponent((Component)new ToolbarPopoverCloser(ToolbarPopover.this.app));
        }

        protected abstract void initLayout();
    }

    private class FormScrollListener
    implements ScrollEventPanel.ScrollListener {
        private FormScrollListener() {
        }

        public void onScroll(int n) {
            ToolbarPopover.this.app.getLayoutContainer().getPopoverHandler().exitPopover(true);
        }
    }
}

