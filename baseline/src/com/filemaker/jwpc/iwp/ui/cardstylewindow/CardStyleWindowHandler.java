/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.ui.cardstylewindow;

import com.filemaker.jwpc.iwp.action.GlobalUIActionHandlers;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.application.AppCardWindowContainer;
import com.filemaker.jwpc.iwp.thrift.common.CardWindowSettings;
import com.filemaker.jwpc.iwp.thrift.common.Dimensions;
import com.filemaker.jwpc.iwp.thrift.common.Position;
import com.filemaker.jwpc.iwp.ui.cardstylewindow.CardStyleWindow;
import com.filemaker.jwpc.iwp.ui.event.EventType;
import com.filemaker.jwpc.iwp.ui.event.UIEvent;

public class CardStyleWindowHandler {
    private final App app;
    private CardStyleWindow cardStyleWindow;
    private boolean notifyServer = true;

    public CardStyleWindowHandler(App app) {
        this.app = app;
    }

    public CardStyleWindow getWindow() {
        return this.cardStyleWindow;
    }

    public void setWindow(CardStyleWindow cardStyleWindow) {
        if (this.cardStyleWindow != null && this.app.getWindows().contains((Object)this.cardStyleWindow)) {
            this.app.removeWindow(this.cardStyleWindow);
        }
        this.cardStyleWindow = cardStyleWindow;
    }

    public void openWindow(boolean bl) {
        this.cardStyleWindow = new CardStyleWindow(this.app, bl);
        this.setWindow(this.cardStyleWindow);
        this.showWindow();
    }

    public void moveResizeWindow(Position position, Dimensions dimensions) {
        CardWindowSettings cardWindowSettings = ((AppCardWindowContainer)this.app.getAppContainer()).getWindowSettings();
        cardWindowSettings.setPosition(position);
        cardWindowSettings.setDimensions(dimensions);
        this.cardStyleWindow.display();
        this.app.notify(new UIEvent(EventType.MOVE_RESIZE_CARD_STYLE_WINDOW));
    }

    public void exitWindow(boolean bl) {
        this.notifyServer = bl;
        if (this.notifyServer) {
            GlobalUIActionHandlers.CLOSE_TOPMOST_VISIBLE_WINDOW.perform(this.app, null);
        } else {
            this.closeCardWindow();
        }
    }

    boolean isNotifyServer() {
        return this.notifyServer;
    }

    void setNotifyServer(boolean bl) {
        this.notifyServer = bl;
    }

    private void showWindow() {
        if (this.cardStyleWindow != null) {
            this.cardStyleWindow.show();
        }
    }

    private void closeCardWindow() {
        if (this.cardStyleWindow != null) {
            this.app.getLayoutContainer().getPopoverHandler().exitPopover(false);
            this.cardStyleWindow.clear();
            this.cardStyleWindow = null;
        }
    }
}

