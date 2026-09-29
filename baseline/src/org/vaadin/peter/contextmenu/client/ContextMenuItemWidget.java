/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.dom.client.Element
 *  com.google.gwt.dom.client.NativeEvent
 *  com.google.gwt.dom.client.Node
 *  com.google.gwt.user.client.DOM
 *  com.google.gwt.user.client.Event
 *  com.google.gwt.user.client.ui.FlowPanel
 *  com.google.gwt.user.client.ui.FocusWidget
 *  com.google.gwt.user.client.ui.Label
 *  com.google.gwt.user.client.ui.Widget
 *  com.vaadin.client.ui.Icon
 */
package org.vaadin.peter.contextmenu.client;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.dom.client.Node;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FocusWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.ui.Icon;
import org.vaadin.peter.contextmenu.client.ContextMenuOverlay;
import org.vaadin.peter.contextmenu.client.ContextMenuWidget;

public class ContextMenuItemWidget
extends FocusWidget {
    private final FlowPanel root = new FlowPanel();
    protected Icon icon;
    private final FlowPanel iconContainer;
    private final Label text;
    private ContextMenuOverlay subMenu;
    private ContextMenuItemWidget parentItem;
    private ContextMenuOverlay overlay;
    private ContextMenuWidget rootComponent;
    private String id;

    public ContextMenuItemWidget() {
        this.root.setStylePrimaryName("v-context-menu-item-basic");
        this.setElement(this.root.getElement());
        this.root.addStyleName("v-context-submenu");
        this.iconContainer = new FlowPanel();
        this.iconContainer.setStyleName("v-context-menu-item-basic-icon-container");
        this.text = new Label();
        this.text.setStyleName("v-context-menu-item-basic-text");
        this.root.add((Widget)this.iconContainer);
        this.root.add((Widget)this.text);
    }

    public void setFocus(boolean bl) {
        if (this.hasSubMenu()) {
            this.subMenu.setFocus(false);
        }
        super.setFocus(bl);
        if (!bl) {
            DOM.releaseCapture((Element)this.getElement());
        }
    }

    public boolean hasSubMenu() {
        return this.subMenu != null && this.subMenu.getNumberOfItems() > 0;
    }

    public void hideSubMenu() {
        if (this.hasSubMenu()) {
            this.subMenu.hide();
            this.removeStyleName("v-context-menu-item-basic-open");
        }
    }

    public boolean isRootItem() {
        return this.parentItem == null;
    }

    public void setOverlay(ContextMenuOverlay contextMenuOverlay) {
        this.overlay = contextMenuOverlay;
    }

    public void setParentItem(ContextMenuItemWidget contextMenuItemWidget) {
        this.parentItem = contextMenuItemWidget;
    }

    public ContextMenuItemWidget getParentItem() {
        return this.parentItem;
    }

    public boolean isSubmenuOpen() {
        return this.hasSubMenu() && this.subMenu.isShowing();
    }

    public void clearItems() {
        if (this.hasSubMenu()) {
            this.subMenu.clearItems();
        }
    }

    public void addSubMenuItem(ContextMenuItemWidget contextMenuItemWidget) {
        if (!this.hasSubMenu()) {
            this.subMenu = new ContextMenuOverlay();
            this.subMenu.setOwner(this.rootComponent.getExtensionTarget());
            this.setStylePrimaryName("v-context-menu-item-basic-submenu");
        }
        contextMenuItemWidget.setParentItem(this);
        this.subMenu.addMenuItem(contextMenuItemWidget);
    }

    public void setCaption(String string) {
        this.text.setText(string);
    }

    public void setIcon(Icon icon) {
        if (icon == null) {
            this.iconContainer.clear();
            this.icon = null;
        } else {
            this.iconContainer.getElement().appendChild((Node)icon.getElement());
            this.icon = icon;
        }
    }

    public void setRootComponent(ContextMenuWidget contextMenuWidget) {
        this.rootComponent = contextMenuWidget;
    }

    public void setId(String string) {
        this.id = string;
    }

    public String getId() {
        return this.id;
    }

    public void closeSiblingMenus() {
        this.overlay.closeSubMenus();
    }

    protected void selectLowerSibling() {
        this.setFocus(false);
        this.overlay.selectItemAfter(this);
    }

    protected void selectUpperSibling() {
        this.setFocus(false);
        this.overlay.selectItemBefore(this);
    }

    protected void closeThisAndSelectParent() {
        if (!this.isRootItem()) {
            this.setFocus(false);
            this.parentItem.hideSubMenu();
            this.parentItem.setFocus(true);
        }
    }

    protected boolean onItemClicked() {
        if (this.isEnabled()) {
            this.overlay.closeSubMenus();
            if (this.hasSubMenu()) {
                this.openSubMenu();
                return false;
            }
            if (this.rootComponent.isHideAutomatically()) {
                this.closeContextMenu();
                return true;
            }
            return false;
        }
        return false;
    }

    private void closeContextMenu() {
        if (this.isRootItem()) {
            this.rootComponent.hide();
        } else {
            this.parentItem.closeContextMenu();
        }
    }

    private void openSubMenu() {
        if (this.isEnabled() && this.hasSubMenu() && !this.subMenu.isShowing()) {
            this.overlay.closeSubMenus();
            this.setFocus(false);
            this.addStyleName("v-context-menu-item-basic-open");
            this.subMenu.openNextTo(this);
        }
    }

    public boolean eventTargetsPopup(Event event) {
        if (this.overlay.eventTargetsPopup((NativeEvent)event)) {
            return true;
        }
        if (this.hasSubMenu()) {
            for (ContextMenuItemWidget contextMenuItemWidget : this.subMenu.getMenuItems()) {
                if (!contextMenuItemWidget.eventTargetsPopup(event)) continue;
                return true;
            }
        }
        return false;
    }

    public void setSeparatorVisible(boolean bl) {
        if (bl) {
            this.root.addStyleName("v-context-menu-item-separator");
        } else {
            this.root.removeStyleName("v-context-menu-item-separator");
        }
    }

    public void setEnabled(boolean bl) {
        super.setEnabled(bl);
        if (bl) {
            this.root.removeStyleName("v-context-menu-item-disabled");
        } else {
            this.root.addStyleName("v-context-menu-item-disabled");
        }
    }
}

