/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.ui.statusarea.menubar;

import com.filemaker.jwpc.iwp.action.GlobalUIActionHandlers;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.model.HierarchicalNamesModel;
import com.filemaker.jwpc.iwp.ui.event.EventType;
import com.filemaker.jwpc.iwp.ui.event.UIEvent;
import com.filemaker.jwpc.iwp.ui.event.UIEventListener;
import com.filemaker.jwpc.iwp.ui.statusarea.component.HierarchicalNamesMenu;
import com.filemaker.menu.Menu;
import java.util.List;

public class ScriptNamesMenu
extends HierarchicalNamesMenu
implements UIEventListener {
    private boolean firstLayoutChange = true;

    public ScriptNamesMenu(App app, String string) {
        super(app, string);
        this.subscribeToEvents();
    }

    public ScriptNamesMenu(App app, Menu.MenuItem menuItem) {
        super(app, menuItem);
        this.subscribeToEvents();
    }

    private void subscribeToEvents() {
        this.app.subscribe(this, EventType.LAYOUT_CHANGE, EventType.SCRIPT_NAMES_CHANGE, EventType.RELOGIN_CHANGE, EventType.WINDOW_CHANGE);
    }

    @Override
    protected HierarchicalNamesMenu.MenuHandler initMenuHandler() {
        return new ScriptsMenuHandler();
    }

    @Override
    protected List<HierarchicalNamesModel> getNamesModels() {
        return this.app.getDatabaseDataModel().getScriptNames();
    }

    @Override
    public final void onEvent(UIEvent uIEvent) {
        switch (uIEvent.getType()) {
            case WINDOW_CHANGE: 
            case LAYOUT_CHANGE: {
                if (!this.firstLayoutChange) break;
                this.updateNames(this.getNamesModels());
                this.firstLayoutChange = false;
                break;
            }
            case RELOGIN_CHANGE: 
            case SCRIPT_NAMES_CHANGE: {
                this.updateNames(this.getNamesModels());
                break;
            }
        }
    }

    @Override
    protected boolean isCheckable() {
        return false;
    }

    @Override
    protected int checkedValue() {
        return 0;
    }

    @Override
    protected String getCustomStyleName() {
        return "script-menuitem";
    }

    private final class ScriptsMenuHandler
    extends HierarchicalNamesMenu.MenuHandler {
        private ScriptsMenuHandler() {
        }

        @Override
        public void menuSelected(Menu.MenuItem menuItem) {
            GlobalUIActionHandlers.EXECUTE_SCRIPT_BY_ID.perform(ScriptNamesMenu.this.app, new Object[]{ScriptNamesMenu.this.vaadinIdToFMIdMap.get(menuItem.getId())});
        }
    }
}

