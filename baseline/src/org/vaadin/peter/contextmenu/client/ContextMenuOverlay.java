/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.JavaScriptObject
 *  com.google.gwt.dom.client.Element
 *  com.google.gwt.dom.client.EventTarget
 *  com.google.gwt.dom.client.NativeEvent
 *  com.google.gwt.dom.client.Node
 *  com.google.gwt.event.logical.shared.CloseEvent
 *  com.google.gwt.event.logical.shared.CloseHandler
 *  com.google.gwt.event.shared.HandlerRegistration
 *  com.google.gwt.user.client.Window
 *  com.google.gwt.user.client.ui.FlowPanel
 *  com.google.gwt.user.client.ui.PopupPanel
 *  com.google.gwt.user.client.ui.PopupPanel$PositionCallback
 *  com.google.gwt.user.client.ui.Widget
 *  com.vaadin.client.ui.VOverlay
 */
package org.vaadin.peter.contextmenu.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.EventTarget;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.dom.client.Node;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.ui.VOverlay;
import java.util.LinkedList;
import java.util.List;
import org.vaadin.peter.contextmenu.client.ContextMenuItemWidget;

class ContextMenuOverlay
extends VOverlay {
    private final FlowPanel root;
    private final List<ContextMenuItemWidget> menuItems;
    private final CloseHandler<PopupPanel> closeHandler = new CloseHandler<PopupPanel>(){

        public void onClose(CloseEvent<PopupPanel> closeEvent) {
            ContextMenuOverlay.this.unfocusAll();
        }
    };
    private final HandlerRegistration closeHandlerRegistration = this.addCloseHandler(this.closeHandler);
    public static int Z_INDEX = VOverlay.Z_INDEX + 1;

    public ContextMenuOverlay() {
        super(false, false);
        this.setStyleName("v-context-menu-container");
        this.root = new FlowPanel();
        this.root.setStyleName("v-context-menu");
        this.menuItems = new LinkedList<ContextMenuItemWidget>();
        this.add((Widget)this.root);
    }

    public void unregister() {
        this.closeHandlerRegistration.removeHandler();
    }

    public boolean isSubmenuOpen() {
        for (ContextMenuItemWidget contextMenuItemWidget : this.menuItems) {
            if (!contextMenuItemWidget.isSubmenuOpen()) continue;
            return true;
        }
        return false;
    }

    private void focusFirstItem() {
        if (this.menuItems.size() > 0) {
            this.menuItems.iterator().next().setFocus(true);
        }
    }

    public void setFocus(boolean bl) {
        this.unfocusAll();
        if (bl) {
            this.focusFirstItem();
        }
    }

    private void unfocusAll() {
        for (ContextMenuItemWidget contextMenuItemWidget : this.menuItems) {
            contextMenuItemWidget.setFocus(false);
        }
    }

    protected void normalizeItemWidths() {
        int n = this.getWidthOfWidestItem();
        for (ContextMenuItemWidget contextMenuItemWidget : this.menuItems) {
            if (contextMenuItemWidget.getOffsetWidth() > n) continue;
            contextMenuItemWidget.setWidth(n + "px");
        }
    }

    protected boolean eventTargetsPopup(NativeEvent nativeEvent) {
        EventTarget eventTarget = nativeEvent.getEventTarget();
        if (Element.is((JavaScriptObject)eventTarget)) {
            return this.getElement().isOrHasChild((Node)Element.as((JavaScriptObject)eventTarget));
        }
        return false;
    }

    private int getWidthOfWidestItem() {
        int n = 0;
        for (ContextMenuItemWidget contextMenuItemWidget : this.menuItems) {
            int n2 = contextMenuItemWidget.getOffsetWidth() + 1;
            if (n2 <= n) continue;
            n = n2;
        }
        return n;
    }

    public void hide() {
        this.unfocusAll();
        this.closeSubMenus();
        super.hide();
    }

    public List<ContextMenuItemWidget> getMenuItems() {
        return this.menuItems;
    }

    public int getNumberOfItems() {
        return this.menuItems.size();
    }

    public void openNextTo(ContextMenuItemWidget contextMenuItemWidget) {
        int n = contextMenuItemWidget.getAbsoluteLeft() + contextMenuItemWidget.getOffsetWidth();
        int n2 = contextMenuItemWidget.getAbsoluteTop();
        this.showAt(n, n2);
    }

    public void closeSubMenus() {
        for (ContextMenuItemWidget contextMenuItemWidget : this.menuItems) {
            contextMenuItemWidget.hideSubMenu();
        }
    }

    public void selectItemBefore(ContextMenuItemWidget contextMenuItemWidget) {
        int n = this.menuItems.indexOf((Object)contextMenuItemWidget);
        if (--n < 0) {
            n = this.menuItems.size() - 1;
        }
        ContextMenuItemWidget contextMenuItemWidget2 = this.menuItems.get(n);
        contextMenuItemWidget2.setFocus(true);
    }

    public void selectItemAfter(ContextMenuItemWidget contextMenuItemWidget) {
        int n = this.menuItems.indexOf((Object)contextMenuItemWidget);
        if (++n >= this.menuItems.size()) {
            n = 0;
        }
        ContextMenuItemWidget contextMenuItemWidget2 = this.menuItems.get(n);
        contextMenuItemWidget2.setFocus(true);
    }

    public void addMenuItem(ContextMenuItemWidget contextMenuItemWidget) {
        contextMenuItemWidget.setOverlay(this);
        this.menuItems.add(contextMenuItemWidget);
        this.root.add((Widget)contextMenuItemWidget);
    }

    public void clearItems() {
        this.menuItems.clear();
        this.root.clear();
    }

    public void showAt(final int n, final int n2) {
        this.setPopupPositionAndShow(new PopupPanel.PositionCallback(){

            public void setPosition(int n7, int n22) {
                int n3;
                int n4 = n + Window.getScrollLeft();
                int n5 = n2 + Window.getScrollTop();
                int n6 = n7 + n4 - (Window.getClientWidth() + Window.getScrollLeft());
                if (n6 > 0 && (n4 -= n6) < 0) {
                    n4 = 0;
                }
                if ((n3 = n22 + n5 - (Window.getClientHeight() + Window.getScrollTop())) > 0 && (n5 -= n3) < 0) {
                    n5 = 0;
                }
                ContextMenuOverlay.this.setPopupPosition(n4, n5);
            }
        });
        this.normalizeItemWidths();
    }
}

