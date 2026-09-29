/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.server.Resource
 *  com.vaadin.ui.AbstractSingleComponentContainer
 *  com.vaadin.ui.Component
 *  com.vaadin.ui.MenuBar$MenuItem
 *  com.vaadin.ui.NativeButton
 */
package com.filemaker.menu;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.filemaker.menu.widgetset.client.Item;
import com.filemaker.menu.widgetset.shared.DisplayMode;
import com.filemaker.menu.widgetset.shared.MenuClientRpc;
import com.filemaker.menu.widgetset.shared.MenuServerRpc;
import com.filemaker.menu.widgetset.shared.MenuState;
import com.vaadin.server.Resource;
import com.vaadin.ui.AbstractSingleComponentContainer;
import com.vaadin.ui.Component;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.NativeButton;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Menu
extends AbstractSingleComponentContainer {
    private static int nextMenuItemId = 0;
    private final MenuServerRpc menuServerRpc = new MenuServerRpc(){

        @Override
        public void menuItemClicked(int n) {
            Menu.this.fireCommand(n);
        }
    };
    private List<MenuItem> items = new ArrayList<MenuItem>();
    private List<MenuItem> allItems = new ArrayList<MenuItem>();

    public Menu(App app) {
        this.initBooleanState();
        this.registerRpc(this.menuServerRpc);
        this.getState().closeButtonAriaLabel = IWPI18N.get(app, "CLOSE", new Object[0]);
    }

    protected MenuState getState() {
        return (MenuState)super.getState();
    }

    public MenuItem addItem(String string, Command command) {
        return this.addItem(string, null, command);
    }

    public MenuItem addItem(String string, Resource resource, Command command) {
        MenuItem menuItem = new MenuItem(string, resource, command);
        this.getState().items.add(menuItem.item);
        this.items.add(menuItem);
        this.allItems.add(menuItem);
        return menuItem;
    }

    public MenuItem addItemBefore(String string, Resource resource, Command command, MenuItem menuItem) {
        return null;
    }

    public List<MenuItem> getItems() {
        return this.items;
    }

    public void removeItem(MenuItem menuItem) {
        if (menuItem != null) {
            this.getState().items.remove(menuItem.item);
            this.items.remove(menuItem);
            this.allItems.remove(menuItem);
        }
    }

    public void removeItems() {
        this.items.clear();
        this.allItems.clear();
        this.getState().items.clear();
        this.markAsDirty();
    }

    public int getSize() {
        return this.items.size();
    }

    private void fireCommand(int n) {
        for (MenuItem menuItem : this.allItems) {
            if (menuItem.item.id != n || menuItem.getCommand() == null) continue;
            menuItem.getCommand().menuSelected(menuItem);
            break;
        }
    }

    public String getLoggedInText() {
        return this.getState().loggedInText;
    }

    public void setLoggedInText(String string) {
        this.getState().loggedInText = string;
    }

    public String getUserName() {
        return this.getState().userName;
    }

    public void setUserName(String string) {
        this.getState().userName = string;
    }

    public DisplayMode getDisplayMode() {
        return this.getState().displayMode;
    }

    public void setDisplayMode(DisplayMode displayMode) {
        this.getState().displayMode = displayMode;
    }

    public NativeButton getLogoutButton() {
        return (NativeButton)this.getContent();
    }

    public void setLogoutButton(NativeButton nativeButton) {
        this.setContent((Component)nativeButton);
    }

    public boolean isUserInfoVisible() {
        return this.getBooleanState(MenuState.BooleanState.userInfoVisible);
    }

    public void setUserInfoVisible(boolean bl) {
        this.updateBooleanState(MenuState.BooleanState.userInfoVisible, bl);
    }

    public String getBackItemText() {
        return this.getState().backItemText;
    }

    public void setBackItemText(String string) {
        this.getState().backItemText = string;
    }

    public void closeMenu() {
        ((MenuClientRpc)this.getRpcProxy(MenuClientRpc.class)).closeMenu();
    }

    private void initBooleanState() {
        this.setUserInfoVisible(true);
    }

    private void updateBooleanState(MenuState.BooleanState booleanState, boolean bl) {
        this.getState().mnbs = IWPUtilities.applyBooleanValue(this.getState().mnbs, booleanState.ordinal(), bl);
    }

    private boolean getBooleanState(MenuState.BooleanState booleanState) {
        return IWPUtilities.getBooleanValue(this.getState().mnbs, booleanState.ordinal());
    }

    public static interface Command
    extends Serializable {
        public void menuSelected(MenuItem var1);
    }

    public class MenuItem
    implements Serializable {
        private Item item = new Item(nextMenuItemId++);
        private Command command;
        private List<MenuItem> children;
        private MenuItem parent;

        public MenuItem(String string, Resource resource, Command command) {
            if (string == null) {
                throw new IllegalArgumentException("caption cannot be null");
            }
            this.item.text = string;
            this.setIcon(resource);
            this.command = command;
        }

        public MenuItem addSeparator() {
            return null;
        }

        public MenuBar.MenuItem addSeparatorBefore(MenuItem menuItem) {
            return null;
        }

        public MenuItem addItem(String string, Command command) {
            return this.addItem(string, null, command);
        }

        public MenuItem addItem(String string, Resource resource, Command command) throws IllegalStateException {
            if (string == null) {
                throw new IllegalArgumentException("Caption cannot be null");
            }
            if (this.children == null) {
                this.children = new ArrayList<MenuItem>();
            }
            MenuItem menuItem = new MenuItem(string, resource, command);
            menuItem.setParent(this);
            this.item.subItems.add(menuItem.item);
            this.children.add(menuItem);
            Menu.this.allItems.add(menuItem);
            Menu.this.markAsDirty();
            return menuItem;
        }

        public MenuItem addItemBefore(String string, Resource resource, Command command, MenuItem menuItem) {
            return null;
        }

        public Command getCommand() {
            return this.command;
        }

        public void setCommand(Command command) {
            this.command = command;
        }

        public Resource getIcon() {
            return Menu.this.getResource("" + this.item.id);
        }

        public void setIcon(Resource resource) {
            Menu.this.setResource("" + this.item.id, resource);
        }

        public String getText() {
            return this.item.text;
        }

        public void setText(String string) {
            this.item.text = string;
            Menu.this.markAsDirty();
        }

        public int getSize() {
            if (this.children != null) {
                return this.children.size();
            }
            return -1;
        }

        public int getId() {
            return this.item.id;
        }

        public boolean hasChildren() {
            return !this.isSeparator() && this.children != null;
        }

        public List<MenuItem> getChildren() {
            return this.children;
        }

        public boolean isCheckable() {
            return this.item.checkable;
        }

        public void setCheckable(boolean bl) throws IllegalStateException {
            this.item.checkable = bl;
        }

        public boolean isChecked() {
            return this.item.checked;
        }

        public void setChecked(boolean bl) {
            this.item.checked = bl;
            Menu.this.markAsDirty();
        }

        public void removeChild(MenuItem menuItem) {
            if (menuItem != null && this.children != null) {
                this.item.subItems.remove(menuItem.item);
                this.children.remove(menuItem);
                Menu.this.allItems.remove(menuItem);
                if (this.children.isEmpty()) {
                    this.children = null;
                }
                Menu.this.markAsDirty();
            }
        }

        public void removeChildren() {
            if (this.children != null) {
                for (MenuItem menuItem : this.children) {
                    menuItem.removeChildren();
                    this.item.subItems.remove(menuItem.item);
                    Menu.this.allItems.remove(menuItem);
                }
                this.children.clear();
                this.children = null;
                Menu.this.markAsDirty();
            }
        }

        public MenuItem getParent() {
            return this.parent;
        }

        protected void setParent(MenuItem menuItem) {
            this.parent = menuItem;
        }

        public boolean isEnabled() {
            return this.item.enabled;
        }

        public void setEnabled(boolean bl) {
            this.item.enabled = bl;
            Menu.this.markAsDirty();
        }

        public boolean isVisible() {
            return this.item.visible;
        }

        public void setVisible(boolean bl) {
            this.item.visible = bl;
            Menu.this.markAsDirty();
        }

        public boolean isSeparator() {
            return false;
        }

        private void setSeparator(boolean bl) {
        }

        public void setStyleName(String string) {
            this.item.styleName = string;
            Menu.this.markAsDirty();
        }

        public String getStyleName() {
            return this.item.styleName;
        }

        public String getDescription() {
            return null;
        }

        public void setDescription(String string) {
        }
    }
}

