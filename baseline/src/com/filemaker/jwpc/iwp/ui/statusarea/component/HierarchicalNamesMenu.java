/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.Component
 *  com.vaadin.v7.ui.VerticalLayout
 */
package com.filemaker.jwpc.iwp.ui.statusarea.component;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.model.HierarchicalNamesModel;
import com.filemaker.menu.Menu;
import com.vaadin.ui.Component;
import com.vaadin.v7.ui.VerticalLayout;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class HierarchicalNamesMenu
extends VerticalLayout {
    protected final App app;
    private static final String CSS_COMBO_MENU_CLASS_NAME = "iwp-comboMenu";
    private Menu.MenuItem topMenuItem;
    private final Menu.Command menuHandler;
    private final Menu menubar;
    protected Map<Integer, Integer> vaadinIdToFMIdMap;

    public HierarchicalNamesMenu(App app, String string) {
        this.app = app;
        this.menubar = new Menu(app);
        this.menubar.addStyleName(CSS_COMBO_MENU_CLASS_NAME);
        this.menubar.setSizeUndefined();
        this.vaadinIdToFMIdMap = new HashMap<Integer, Integer>();
        this.topMenuItem = this.menubar.addItem(string, null, null);
        this.menuHandler = this.initMenuHandler();
        this.addComponent((Component)this.menubar);
    }

    public HierarchicalNamesMenu(App app, String string, String string2) {
        this(app, string);
        this.topMenuItem.setDescription(string2);
    }

    public HierarchicalNamesMenu(App app, Menu.MenuItem menuItem) {
        this(app, "");
        this.topMenuItem = menuItem;
    }

    protected abstract MenuHandler initMenuHandler();

    protected abstract List<HierarchicalNamesModel> getNamesModels();

    protected Menu.MenuItem getTopMenuItem() {
        return this.topMenuItem;
    }

    protected boolean updateNames(List<HierarchicalNamesModel> list) {
        boolean bl = false;
        if (this.topMenuItem.hasChildren()) {
            this.topMenuItem.removeChildren();
            this.vaadinIdToFMIdMap.clear();
        }
        if (list.size() > 0) {
            bl = this.processFolder(this.topMenuItem, list, this.menuHandler);
        }
        return bl;
    }

    private boolean processFolder(Menu.MenuItem menuItem, List<HierarchicalNamesModel> list, Menu.Command command) {
        boolean bl = false;
        for (HierarchicalNamesModel hierarchicalNamesModel : list) {
            Menu.MenuItem menuItem2;
            String string = hierarchicalNamesModel.getName();
            if (this.isSeparator(string)) continue;
            if (hierarchicalNamesModel.isFolder()) {
                menuItem2 = menuItem.addItem(string, null);
                menuItem2.setStyleName(this.getCustomStyleName());
                if (hierarchicalNamesModel.getChilds().size() > 0) {
                    bl = this.processFolder(menuItem2, hierarchicalNamesModel.getChilds(), command);
                    continue;
                }
                menuItem2.addItem("", null);
                menuItem2.setEnabled(false);
                continue;
            }
            menuItem2 = menuItem.addItem(string, null);
            menuItem2.setStyleName(this.getCustomStyleName());
            this.vaadinIdToFMIdMap.put(menuItem2.getId(), hierarchicalNamesModel.getId());
            menuItem2.setCheckable(this.isCheckable());
            if (this.isCheckable() && hierarchicalNamesModel.getId() == this.checkedValue()) {
                menuItem2.setChecked(true);
                menuItem2.setEnabled(false);
                bl = true;
            } else {
                menuItem2.setChecked(false);
                menuItem2.setEnabled(true);
            }
            menuItem2.setCommand(command);
        }
        return bl;
    }

    private boolean isSeparator(String string) {
        return "-".equals(string);
    }

    protected abstract boolean isCheckable();

    protected abstract int checkedValue();

    protected abstract String getCustomStyleName();

    protected abstract class MenuHandler
    implements Menu.Command {
        protected MenuHandler() {
        }
    }
}

