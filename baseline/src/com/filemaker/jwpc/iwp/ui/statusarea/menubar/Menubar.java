/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.server.Sizeable$Unit
 *  com.vaadin.server.ThemeResource
 *  com.vaadin.shared.ui.ContentMode
 *  com.vaadin.ui.Alignment
 *  com.vaadin.ui.Component
 *  com.vaadin.v7.ui.HorizontalLayout
 *  javolution.xml.stream.XMLInputFactory
 *  javolution.xml.stream.XMLStreamException
 *  javolution.xml.stream.XMLStreamReader
 */
package com.filemaker.jwpc.iwp.ui.statusarea.menubar;

import com.filemaker.jwpc.iwp.action.UIAction;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.application.AppRuntimeException;
import com.filemaker.jwpc.iwp.notification.processor.BrowserInfoHandler;
import com.filemaker.jwpc.iwp.ui.customwidgets.IWPMenu;
import com.filemaker.jwpc.iwp.ui.customwidgets.IWPMenuItem;
import com.filemaker.jwpc.iwp.ui.customwidgets.MenubarItem;
import com.filemaker.jwpc.iwp.ui.statusarea.menubar.MenubarComponent;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.filemaker.menu.Menu;
import com.filemaker.menu.widgetset.shared.DisplayMode;
import com.vaadin.server.Sizeable;
import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.v7.ui.HorizontalLayout;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javolution.xml.stream.XMLInputFactory;
import javolution.xml.stream.XMLStreamException;
import javolution.xml.stream.XMLStreamReader;

public abstract class Menubar
extends HorizontalLayout
implements Menu.Command,
MenubarComponent {
    protected static final ThemeResource CHECKBOX = new ThemeResource("images/menu_check_mark.png");
    protected final App app;
    protected final IWPMenu menubar;
    protected final Map<String, UIAction> MENU_TEXT_TO_ACTIONS_MAP = new HashMap<String, UIAction>();
    private final Map<String, IWPMenuItem> menuItems = new HashMap<String, IWPMenuItem>();
    private static final MenuItemSkeleton sINSTANCE = Menubar.CreateMenuStructure();

    public Menubar(App app) throws AppRuntimeException {
        this.app = app;
        this.setMargin(false);
        this.setSpacing(false);
        this.setHeight(44.0f, Sizeable.Unit.PIXELS);
        this.setWidth(50.0f, Sizeable.Unit.PIXELS);
        this.menubar = new IWPMenu(app);
        this.menubar.setDisplayMode(DisplayMode.MOBILE);
        IWPMenu iWPMenu = this.menubar;
        iWPMenu.setSizeFull();
        this.addComponent((Component)iWPMenu);
        this.setComponentAlignment((Component)iWPMenu, Alignment.TOP_LEFT);
        this.setExpandRatio((Component)iWPMenu, 1.0f);
        this.initMenuTextToActionsMap();
        this.createMenu();
        this.setupMenuBarActions();
        this.setMenuDefaults();
        IWPUtilities.assignUniqueId(app, "m", (Component)this);
    }

    public void invalidate() {
        for (IWPMenuItem iWPMenuItem : this.menuItems.values()) {
            iWPMenuItem.invalidate();
        }
        this.menuItems.clear();
    }

    protected abstract void initMenuTextToActionsMap();

    protected abstract void setMenuDefaults();

    public IWPMenuItem findMenuItem(String string) {
        return this.menuItems.get(string);
    }

    protected void createMenu() {
        MenuItemSkeleton menuItemSkeleton = Menubar.getMenuSkeletonInstance();
        this.initMenuFromSkeleton(menuItemSkeleton, null);
    }

    public void closeMenu() {
        this.menubar.closeMenu();
    }

    private void setupMenuBarActions() {
        for (String string : this.MENU_TEXT_TO_ACTIONS_MAP.keySet()) {
            UIAction uIAction;
            IWPMenuItem iWPMenuItem = this.findMenuItem(string);
            if (iWPMenuItem == null || (uIAction = this.MENU_TEXT_TO_ACTIONS_MAP.get(string)) == null) continue;
            iWPMenuItem.setAction(uIAction);
        }
    }

    @Override
    public void menuSelected(Menu.MenuItem menuItem) {
        String string = menuItem.getText();
        if (string.contains("(")) {
            string = string.substring(0, string.lastIndexOf("(") - 1).trim();
        }
        if (this.findMenuItem(string) != null) {
            this.findMenuItem(string).performAction(null);
        }
    }

    public void setDescription(String string) {
        if (!BrowserInfoHandler.isTouchDevice(this.app)) {
            super.setDescription(string, ContentMode.HTML);
        }
    }

    public static MenuItemSkeleton getMenuSkeletonInstance() {
        return sINSTANCE;
    }

    public void initMenuFromSkeleton(MenuItemSkeleton menuItemSkeleton, IWPMenuItem iWPMenuItem) {
        if (menuItemSkeleton == null || menuItemSkeleton.childrenItem == null || menuItemSkeleton.childrenItem.isEmpty()) {
            return;
        }
        for (MenuItemSkeleton menuItemSkeleton2 : menuItemSkeleton.childrenItem) {
            IWPMenuItem iWPMenuItem2;
            String string = IWPI18N.get(this.app, menuItemSkeleton2.getName(), new Object[0]);
            if (iWPMenuItem == null) {
                Menu.MenuItem menuItem = this.menubar.addItem(string, null, null);
                iWPMenuItem2 = new MenubarItem(this.app, menuItem);
            } else {
                iWPMenuItem2 = iWPMenuItem.addItem(string, null);
            }
            iWPMenuItem2.setCheckable(menuItemSkeleton2.isCheckable());
            iWPMenuItem2.getMenuItem().setStyleName(menuItemSkeleton2.getStyleName());
            if (iWPMenuItem2.getParent() != null || menuItemSkeleton2.getName().equals("LOG_OUT")) {
                iWPMenuItem2.setCommand(this);
            }
            this.menuItems.put(string, iWPMenuItem2);
            if (menuItemSkeleton2.childrenItem == null || menuItemSkeleton2.childrenItem.isEmpty()) continue;
            this.initMenuFromSkeleton(menuItemSkeleton2, iWPMenuItem2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static MenuItemSkeleton CreateMenuStructure() {
        XMLInputFactory xMLInputFactory = XMLInputFactory.newInstance();
        InputStream inputStream = Menubar.class.getResourceAsStream("main-menu.xml");
        XMLStreamReader xMLStreamReader = null;
        MenuItemSkeleton menuItemSkeleton = new MenuItemSkeleton("_MenuBar");
        try {
            if (inputStream != null) {
                xMLStreamReader = xMLInputFactory.createXMLStreamReader(inputStream);
                Object object = null;
                block18: while (xMLStreamReader.getEventType() != 8) {
                    switch (xMLStreamReader.next()) {
                        case 1: {
                            Object object2;
                            String string = xMLStreamReader.getLocalName().toString();
                            if (!string.equals("menuitem")) break;
                            String string2 = xMLStreamReader.getAttributeValue(null, (CharSequence)"name").toString();
                            Object object3 = new MenuItemSkeleton(string2);
                            if (object == null) {
                                menuItemSkeleton.addChildren((MenuItemSkeleton)object3);
                            } else {
                                ((MenuItemSkeleton)object).addChildren((MenuItemSkeleton)object3);
                            }
                            object = object3;
                            if (xMLStreamReader.getAttributeValue(null, (CharSequence)"allow-checkmark") != null) {
                                object2 = Boolean.valueOf(xMLStreamReader.getAttributeValue(null, (CharSequence)"allow-checkmark").toString());
                                ((MenuItemSkeleton)object).setCheckable((Boolean)object2);
                            }
                            if ((object2 = xMLStreamReader.getAttributeValue(null, (CharSequence)"css-selector-name")) == null) continue block18;
                            ((MenuItemSkeleton)object).setStyleName(object2.toString());
                            break;
                        }
                        case 2: {
                            Object object3 = xMLStreamReader.getLocalName().toString();
                            if (!((String)object3).equalsIgnoreCase("menuitem")) break;
                            object = ((MenuItemSkeleton)object).getParent();
                        }
                    }
                }
            } else {
                assert (false);
                System.err.println("Could not create menus. Please restart FileMaker Server and try again.");
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        finally {
            try {
                if (xMLStreamReader != null) {
                    xMLStreamReader.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            }
            catch (XMLStreamException xMLStreamException) {
                xMLStreamException.printStackTrace();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
        return menuItemSkeleton;
    }

    private static class MenuItemSkeleton {
        private String menuName;
        private boolean checkable = false;
        private String styleName;
        private MenuItemSkeleton parent;
        private List<MenuItemSkeleton> childrenItem;

        public MenuItemSkeleton(String string) {
            assert (string != null);
            this.menuName = string;
        }

        public String getName() {
            return this.menuName;
        }

        public void setCheckable(boolean bl) {
            this.checkable = bl;
        }

        public boolean isCheckable() {
            return this.checkable;
        }

        public void setStyleName(String string) {
            this.styleName = string;
        }

        public String getStyleName() {
            return this.styleName;
        }

        private MenuItemSkeleton getParent() {
            return this.parent;
        }

        public void addChildren(MenuItemSkeleton menuItemSkeleton) {
            if (this.childrenItem == null) {
                this.childrenItem = new ArrayList<MenuItemSkeleton>();
            }
            menuItemSkeleton.parent = this;
            this.childrenItem.add(menuItemSkeleton);
        }
    }
}

