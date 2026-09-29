/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.event.Action
 *  com.vaadin.server.PaintException
 *  com.vaadin.server.PaintTarget
 *  com.vaadin.server.Sizeable$Unit
 *  com.vaadin.ui.Component
 *  com.vaadin.ui.UI
 *  com.vaadin.ui.Window
 *  com.vaadin.ui.Window$CloseShortcut
 */
package com.filemaker.jwpc.iwp.ui.cardstylewindow;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.application.AppCardWindowContainer;
import com.filemaker.jwpc.iwp.thrift.common.CardWindowSettings;
import com.filemaker.jwpc.iwp.thrift.common.LayoutObjectType;
import com.filemaker.jwpc.iwp.ui.cardstylewindow.CardStyleWindowHandler;
import com.filemaker.jwpc.iwp.ui.layout.LayoutObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutView;
import com.filemaker.jwpc.iwp.ui.statusarea.StatusAreaContainer;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.state.CardStyleWindowState;
import com.vaadin.event.Action;
import com.vaadin.server.PaintException;
import com.vaadin.server.PaintTarget;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.Component;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;
import java.util.ArrayList;

public class CardStyleWindow
extends Window {
    private final App app;
    private boolean modalWindowInDisplay = false;

    public CardStyleWindow(App app, boolean bl) {
        this.app = app;
        this.setModal(true);
        this.setResizable(false);
        this.setDraggable(false);
        this.setStyleName("iwp-card-window");
        this.setClosable(bl);
    }

    public void addCloseShortcut(int n, int ... nArray) {
        this.addAction((Action)new Window.CloseShortcut(this, n, nArray){

            public void handleAction(Object object, Object object2) {
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
        AppCardWindowContainer appCardWindowContainer = (AppCardWindowContainer)this.app.getAppContainer();
        CardWindowSettings cardWindowSettings = appCardWindowContainer.getWindowSettings();
        int n = cardWindowSettings.getPosition().getTop();
        StatusAreaContainer statusAreaContainer = this.app.getStatusAreaContainer();
        if (statusAreaContainer != null && statusAreaContainer.isVisible()) {
            n += 44;
        }
        this.setPosition(cardWindowSettings.getPosition().getLeft(), n);
        this.setWidth(cardWindowSettings.getDimensions().getWidth() + 1, Sizeable.Unit.PIXELS);
        this.setHeight(cardWindowSettings.getDimensions().getHeight() + 1, Sizeable.Unit.PIXELS);
        appCardWindowContainer.setWidth(cardWindowSettings.getDimensions().getWidth(), Sizeable.Unit.PIXELS);
        appCardWindowContainer.setHeight(cardWindowSettings.getDimensions().getHeight(), Sizeable.Unit.PIXELS);
        this.setContent((Component)appCardWindowContainer);
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

    public CardStyleWindowState getState() {
        return (CardStyleWindowState)super.getState();
    }

    public void beforeClientResponse(boolean bl) {
        super.beforeClientResponse(bl);
        boolean bl2 = ((AppCardWindowContainer)this.app.getAppContainer()).getWindowSettings().isHasParentDim();
        this.updateBooleanState(CardStyleWindowState.BooleanState.hasParentDim, bl2);
    }

    private void updateBooleanState(CardStyleWindowState.BooleanState booleanState, boolean bl) {
        this.getState().pwbs = IWPUtilities.applyBooleanValue(this.getState().pwbs, booleanState.ordinal(), bl);
    }

    private void closeOpenCardStyleWindows() {
        ArrayList<Window> arrayList = new ArrayList<Window>();
        for (Window window : this.app.getWindows()) {
            if (!(window instanceof CardStyleWindow)) continue;
            arrayList.add(window);
        }
        for (Window window : arrayList) {
            this.app.removeWindow(window);
        }
        this.removeCachedSetWebViewerUrl();
    }

    public void close() {
        CardStyleWindowHandler cardStyleWindowHandler = this.app.getAppController().getCardStyleWindowHandler();
        if (cardStyleWindowHandler.isNotifyServer()) {
            cardStyleWindowHandler.exitWindow(true);
        } else if (this.getParent() != null) {
            this.app.enableTouchScroll(true);
            this.setVisible(false);
            this.closeOpenCardStyleWindows();
            this.app.focus();
            cardStyleWindowHandler.setNotifyServer(true);
        }
    }

    public void clear() {
        this.close();
    }

    private void removeCachedSetWebViewerUrl() {
        LayoutView layoutView = this.app.getLayoutContainer().getCurrentView();
        if (layoutView != null) {
            for (LayoutObject layoutObject : layoutView.getLayoutObjects()) {
                if (!LayoutObjectType.WEB_VIEWER.equals((Object)layoutObject.getMetaData().getType())) continue;
                this.app.removeCachedSetWebViewerUrl(layoutObject.getAttributes().getObjectSpec());
            }
        }
    }
}

