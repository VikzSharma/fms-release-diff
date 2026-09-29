/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.event.dom.client.ClickEvent
 *  com.google.gwt.event.dom.client.ClickHandler
 *  com.google.gwt.event.dom.client.KeyUpEvent
 *  com.google.gwt.event.dom.client.KeyUpHandler
 *  com.google.gwt.event.dom.client.MouseOutEvent
 *  com.google.gwt.event.dom.client.MouseOutHandler
 *  com.google.gwt.event.dom.client.MouseOverEvent
 *  com.google.gwt.event.dom.client.MouseOverHandler
 *  com.google.gwt.user.client.Timer
 *  com.vaadin.client.ServerConnector
 *  com.vaadin.client.communication.RpcProxy
 */
package org.vaadin.peter.contextmenu.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.Timer;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.communication.RpcProxy;
import org.vaadin.peter.contextmenu.client.ContextMenuItemWidget;
import org.vaadin.peter.contextmenu.client.ContextMenuServerRpc;

public class ContextMenuItemWidgetHandler
implements ClickHandler,
MouseOverHandler,
MouseOutHandler,
KeyUpHandler {
    private ContextMenuServerRpc contextMenuRpc;
    private final Timer openTimer = new Timer(){

        public void run() {
            ContextMenuItemWidgetHandler.this.onItemClicked();
        }
    };
    private ContextMenuItemWidget widget;

    public ContextMenuItemWidgetHandler(ContextMenuItemWidget contextMenuItemWidget, ServerConnector serverConnector) {
        this.widget = contextMenuItemWidget;
        this.contextMenuRpc = (ContextMenuServerRpc)RpcProxy.create(ContextMenuServerRpc.class, (ServerConnector)serverConnector);
    }

    public void onKeyUp(KeyUpEvent keyUpEvent) {
        int n = keyUpEvent.getNativeEvent().getKeyCode();
        if (n == 37) {
            this.onLeftPressed();
        } else if (n == 39) {
            this.onRightPressed();
        } else if (n == 38) {
            this.onUpPressed();
        } else if (n == 40) {
            this.onDownPressed();
        } else if (n == 13) {
            this.onEnterPressed();
        }
    }

    public void onMouseOut(MouseOutEvent mouseOutEvent) {
        this.openTimer.cancel();
        this.widget.setFocus(false);
    }

    public void onMouseOver(MouseOverEvent mouseOverEvent) {
        this.openTimer.cancel();
        if (this.isEnabled()) {
            if (!this.widget.isSubmenuOpen()) {
                this.widget.closeSiblingMenus();
            }
            this.widget.setFocus(true);
            if (this.widget.hasSubMenu() && !this.widget.isSubmenuOpen()) {
                this.openTimer.schedule(500);
            }
        }
    }

    public void onClick(ClickEvent clickEvent) {
        if (this.isEnabled()) {
            this.openTimer.cancel();
            if (this.widget.hasSubMenu()) {
                if (!this.widget.isSubmenuOpen()) {
                    this.widget.onItemClicked();
                    this.contextMenuRpc.itemClicked(this.widget.getId(), false);
                }
            } else {
                boolean bl = this.widget.onItemClicked();
                this.contextMenuRpc.itemClicked(this.widget.getId(), bl);
            }
        }
    }

    private boolean isEnabled() {
        return this.widget.isEnabled();
    }

    private void onLeftPressed() {
        if (this.isEnabled()) {
            this.widget.closeThisAndSelectParent();
        }
    }

    private void onRightPressed() {
        if (this.isEnabled() && this.widget.hasSubMenu()) {
            this.onItemClicked();
        }
    }

    private void onUpPressed() {
        if (this.isEnabled()) {
            this.widget.selectUpperSibling();
        }
    }

    private void onDownPressed() {
        if (this.isEnabled()) {
            this.widget.selectLowerSibling();
        }
    }

    private void onEnterPressed() {
        if (this.isEnabled()) {
            if (this.widget.hasSubMenu()) {
                if (!this.widget.isSubmenuOpen()) {
                    boolean bl = this.widget.onItemClicked();
                    this.contextMenuRpc.itemClicked(this.widget.getId(), bl);
                }
            } else {
                boolean bl = this.widget.onItemClicked();
                this.contextMenuRpc.itemClicked(this.widget.getId(), bl);
            }
        }
    }

    private void onItemClicked() {
        boolean bl = this.widget.onItemClicked();
        this.contextMenuRpc.itemClicked(this.widget.getId(), bl);
    }
}

