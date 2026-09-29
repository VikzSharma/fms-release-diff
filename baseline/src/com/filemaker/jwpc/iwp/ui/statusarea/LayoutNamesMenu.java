/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.ui.statusarea;

import com.filemaker.jwpc.iwp.action.GlobalUIActionHandlers;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.model.HierarchicalNamesModel;
import com.filemaker.jwpc.iwp.ui.event.EventType;
import com.filemaker.jwpc.iwp.ui.event.UIEvent;
import com.filemaker.jwpc.iwp.ui.event.UIEventListener;
import com.filemaker.jwpc.iwp.ui.statusarea.component.HierarchicalNamesMenu;
import com.filemaker.menu.Menu;
import java.util.List;

public class LayoutNamesMenu
extends HierarchicalNamesMenu
implements UIEventListener {
    private boolean hasCustomTopMenuName = true;

    public LayoutNamesMenu(App app, String string, String string2) {
        super(app, string, string2);
        this.subscribeToEvents();
    }

    public LayoutNamesMenu(App app, Menu.MenuItem menuItem) {
        super(app, menuItem);
        this.hasCustomTopMenuName = false;
        this.subscribeToEvents();
    }

    private void subscribeToEvents() {
        this.app.subscribe(this, EventType.VIEW_STYLE_CHANGE, EventType.LAYOUT_CHANGE, EventType.LAYOUT_NAMES_LIST_CHANGE, EventType.WINDOW_CHANGE, EventType.RELOGIN_CHANGE, EventType.LOAD_CACHED_LAYOUT);
    }

    @Override
    protected HierarchicalNamesMenu.MenuHandler initMenuHandler() {
        return new LayoutsMenuHandler();
    }

    @Override
    protected List<HierarchicalNamesModel> getNamesModels() {
        return this.app.getDatabaseDataModel().getLayoutNames();
    }

    @Override
    public void onEvent(UIEvent uIEvent) {
        switch (uIEvent.getType()) {
            case WINDOW_CHANGE: 
            case RELOGIN_CHANGE: 
            case LAYOUT_CHANGE: 
            case LAYOUT_NAMES_LIST_CHANGE: 
            case LOAD_CACHED_LAYOUT: {
                this.updateNames(this.getNamesModels());
                break;
            }
        }
    }

    @Override
    protected boolean updateNames(List<HierarchicalNamesModel> list) {
        boolean bl = super.updateNames(list);
        if (list.size() > 0 && this.hasCustomTopMenuName) {
            this.setMenuText(this.app.getAppSession().getLayoutName());
        }
        return bl;
    }

    protected void setMenuText(String string) {
        this.getTopMenuItem().setText(string);
    }

    @Override
    protected boolean isCheckable() {
        return true;
    }

    @Override
    protected int checkedValue() {
        return this.app.getAppSession().getLayoutID();
    }

    @Override
    protected String getCustomStyleName() {
        return "layout-menuitem";
    }

    private class LayoutsMenuHandler
    extends HierarchicalNamesMenu.MenuHandler {
        private LayoutsMenuHandler() {
            super(LayoutNamesMenu.this);
        }

        @Override
        public void menuSelected(Menu.MenuItem menuItem) {
            GlobalUIActionHandlers.GOTO_LAYOUT_BY_ID.perform(LayoutNamesMenu.this.app, new Object[]{LayoutNamesMenu.this.vaadinIdToFMIdMap.get(menuItem.getId())});
        }
    }
}

