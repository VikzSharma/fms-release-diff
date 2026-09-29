/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.ui.ContentMode
 *  com.vaadin.ui.Component
 */
package com.filemaker.jwpc.iwp.ui.statusarea.toolbar;

import com.filemaker.jwpc.iwp.action.GlobalUIActionHandlers;
import com.filemaker.jwpc.iwp.action.UIAction;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.application.AppRuntimeException;
import com.filemaker.jwpc.iwp.model.Privileges;
import com.filemaker.jwpc.iwp.notification.processor.BrowserInfoHandler;
import com.filemaker.jwpc.iwp.session.Session;
import com.filemaker.jwpc.iwp.thrift.common.LayoutMode;
import com.filemaker.jwpc.iwp.thrift.common.LayoutViewStyle;
import com.filemaker.jwpc.iwp.thrift.common.ToolbarStatusAreaState;
import com.filemaker.jwpc.iwp.thrift.common.UIActionType;
import com.filemaker.jwpc.iwp.thrift.context.Context;
import com.filemaker.jwpc.iwp.ui.customwidgets.IWPMenuItem;
import com.filemaker.jwpc.iwp.ui.event.EventType;
import com.filemaker.jwpc.iwp.ui.event.UIEvent;
import com.filemaker.jwpc.iwp.ui.statusarea.LayoutNamesMenu;
import com.filemaker.jwpc.iwp.ui.statusarea.menubar.Menubar;
import com.filemaker.jwpc.iwp.ui.statusarea.menubar.ScriptNamesMenu;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.state.StatusAreaMenubarState;
import com.filemaker.jwpc.util.Utilities;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Component;

public class MainMenubar
extends Menubar {
    public MainMenubar(App app) throws AppRuntimeException {
        super(app);
        this.setStyleName("main-menu");
        this.setDescription(IWPI18N.get(app, "MAIN_MENU", new Object[0]));
        this.menubar.setDescription(IWPI18N.get(app, "MAIN_MENU", new Object[0]), ContentMode.HTML);
        if (!app.getDatabaseDataModel().isMenubarVisible()) {
            this.setVisible(false);
        }
        this.app.subscribe(this, EventType.MASTER_ROW_STATE_CHANGE, EventType.TOOLBAR_STATUSAREA_STATE_CHANGE, EventType.MODE_CHANGE, EventType.VIEW_STYLE_CHANGE, EventType.LAYOUT_CHANGE, EventType.ACCOUNTNAME_CHANGE, EventType.WINDOW_CHANGE, EventType.RELOGIN_CHANGE, EventType.REFRESH_MENUBAR, EventType.LOAD_CACHED_LAYOUT);
        IWPUtilities.assignUniqueId(app, "t", (Component)this);
    }

    @Override
    protected void createMenu() {
        super.createMenu();
        this.menubar.setLoggedInText(IWPI18N.get(this.app, "WELCOME", new Object[0]));
        this.menubar.setUserName(this.app.getCurrentAccountName());
        IWPMenuItem iWPMenuItem = this.findMenuItem(IWPI18N.get(this.app, "LAYOUT", new Object[0]));
        if (iWPMenuItem != null) {
            new LayoutNamesMenu(this.app, iWPMenuItem.getMenuItem());
        }
        if ((iWPMenuItem = this.findMenuItem(IWPI18N.get(this.app, "SCRIPTS", new Object[0]))) != null) {
            new ScriptNamesMenu(this.app, iWPMenuItem.getMenuItem());
        }
    }

    @Override
    protected void initMenuTextToActionsMap() {
        this.MENU_TEXT_TO_ACTIONS_MAP.put(IWPI18N.get(this.app, "BROWSE_MODE", new Object[0]), GlobalUIActionHandlers.GOTO_BROWSE_MODE);
        this.MENU_TEXT_TO_ACTIONS_MAP.put(IWPI18N.get(this.app, "FIND_MODE", new Object[0]), GlobalUIActionHandlers.GOTO_FIND_MODE);
        this.MENU_TEXT_TO_ACTIONS_MAP.put(IWPI18N.get(this.app, "FORM_VIEW", new Object[0]), GlobalUIActionHandlers.GOTO_FORM_VIEW);
        this.MENU_TEXT_TO_ACTIONS_MAP.put(IWPI18N.get(this.app, "LIST_VIEW", new Object[0]), GlobalUIActionHandlers.GOTO_LIST_VIEW);
        this.MENU_TEXT_TO_ACTIONS_MAP.put(IWPI18N.get(this.app, "VIEW_AS_PDF_DOT", new Object[0]), GlobalUIActionHandlers.VIEW_AS_PDF);
        this.MENU_TEXT_TO_ACTIONS_MAP.put(IWPI18N.get(this.app, "CURR_DATE", new Object[0]), GlobalUIActionHandlers.INSERT_DATE);
        this.MENU_TEXT_TO_ACTIONS_MAP.put(IWPI18N.get(this.app, "CURR_TIME", new Object[0]), GlobalUIActionHandlers.INSERT_TIME);
        this.MENU_TEXT_TO_ACTIONS_MAP.put(IWPI18N.get(this.app, "CURR_USER_NAME", new Object[0]), GlobalUIActionHandlers.INSERT_CURRENT_USERNAME);
        this.MENU_TEXT_TO_ACTIONS_MAP.put(IWPI18N.get(this.app, "NEXT_REC", new Object[0]), GlobalUIActionHandlers.GOTO_NEXT_ROW);
        this.MENU_TEXT_TO_ACTIONS_MAP.put(IWPI18N.get(this.app, "NEXT_REQ", new Object[0]), GlobalUIActionHandlers.GOTO_NEXT_ROW);
        this.MENU_TEXT_TO_ACTIONS_MAP.put(IWPI18N.get(this.app, "PREV_REC", new Object[0]), GlobalUIActionHandlers.GOTO_PREV_ROW);
        this.MENU_TEXT_TO_ACTIONS_MAP.put(IWPI18N.get(this.app, "PREV_REQ", new Object[0]), GlobalUIActionHandlers.GOTO_PREV_ROW);
        this.MENU_TEXT_TO_ACTIONS_MAP.put(IWPI18N.get(this.app, "CLEAR", new Object[0]), GlobalUIActionHandlers.CLEAR_FIELD_CONTENTS);
        this.MENU_TEXT_TO_ACTIONS_MAP.put(IWPI18N.get(this.app, "INSERT_INTO_CONTAINER", new Object[0]), GlobalUIActionHandlers.SHOW_INSERT_INTO_CONTAINER_DIALOG);
        this.MENU_TEXT_TO_ACTIONS_MAP.put(IWPI18N.get(this.app, "VIEW_ZOOMED_IMAGE", new Object[0]), GlobalUIActionHandlers.VIEW_ZOOMED_IMAGE);
        this.MENU_TEXT_TO_ACTIONS_MAP.put(IWPI18N.get(this.app, "DELETE_ALL", new Object[0]), GlobalUIActionHandlers.DELETE_ALL_RECORDS);
        this.MENU_TEXT_TO_ACTIONS_MAP.put(IWPI18N.get(this.app, "DELETE_FOUND", new Object[0]), GlobalUIActionHandlers.DELETE_ALL_RECORDS);
        this.MENU_TEXT_TO_ACTIONS_MAP.put(IWPI18N.get(this.app, "CHANGE_PASSWORD_DIALOG_TITLE", new Object[0]), GlobalUIActionHandlers.CHANGE_PASSWORD);
        this.MENU_TEXT_TO_ACTIONS_MAP.put(IWPI18N.get(this.app, "REVERT_RECORD", new Object[0]), GlobalUIActionHandlers.REVERT_ROW);
        this.MENU_TEXT_TO_ACTIONS_MAP.put(IWPI18N.get(this.app, "REVERT_REQUEST", new Object[0]), GlobalUIActionHandlers.REVERT_ROW);
        this.MENU_TEXT_TO_ACTIONS_MAP.put(IWPI18N.get(this.app, "SNAPSHOT_LINK_DOT", new Object[0]), GlobalUIActionHandlers.SAVEAS_SNAPSHOT_LINK);
        this.MENU_TEXT_TO_ACTIONS_MAP.put(IWPI18N.get(this.app, "OMIT_MULT_DOT", new Object[0]), GlobalUIActionHandlers.OMIT_RECORDS);
        this.MENU_TEXT_TO_ACTIONS_MAP.put(IWPI18N.get(this.app, "REFRESH_WINDOW", new Object[0]), GlobalUIActionHandlers.REFRESH_WINDOW);
        this.MENU_TEXT_TO_ACTIONS_MAP.put(IWPI18N.get(this.app, "RELOOKUP_FIELD", new Object[0]), GlobalUIActionHandlers.RELOOKUP_FIELD);
        this.MENU_TEXT_TO_ACTIONS_MAP.put(IWPI18N.get(this.app, "STATUS_TOOLBAR", new Object[0]), GlobalUIActionHandlers.TOGGLE_STATUS_AREA);
        this.MENU_TEXT_TO_ACTIONS_MAP.put(IWPI18N.get(this.app, "GO_TO", new Object[0]), GlobalUIActionHandlers.SHOW_GOTO_ROW_DIALOG);
        this.MENU_TEXT_TO_ACTIONS_MAP.put(IWPI18N.get(this.app, "EXPORT_FIELD_CONTENTS", new Object[0]), this.app.getAM().getAction(UIActionType.EXPORT_FIELD_CONTENTS));
        this.MENU_TEXT_TO_ACTIONS_MAP.put(IWPI18N.get(this.app, "FILE_DOT", new Object[0]), this.app.getAM().getAction(UIActionType.IMPORT_RECORDS));
        this.MENU_TEXT_TO_ACTIONS_MAP.put(IWPI18N.get(this.app, "EXPORT_RECORDS", new Object[0]), this.app.getAM().getAction(UIActionType.EXPORT_RECORDS));
        this.MENU_TEXT_TO_ACTIONS_MAP.put(IWPI18N.get(this.app, "OMIT_RECORD", new Object[0]), this.app.getAM().getAction(UIActionType.OMIT_RECORD));
        this.MENU_TEXT_TO_ACTIONS_MAP.put(IWPI18N.get(this.app, "DUPLICATE_RECORD", new Object[0]), this.app.getAM().getAction(UIActionType.DUP_ROW));
        this.MENU_TEXT_TO_ACTIONS_MAP.put(IWPI18N.get(this.app, "DUPLICATE_REQUEST", new Object[0]), this.app.getAM().getAction(UIActionType.DUP_ROW));
        this.MENU_TEXT_TO_ACTIONS_MAP.put(IWPI18N.get(this.app, "NEW_RECORD", new Object[0]), this.app.getAM().getAction(UIActionType.CREATE_NEW_ROW));
        this.MENU_TEXT_TO_ACTIONS_MAP.put(IWPI18N.get(this.app, "ADD_REQUEST", new Object[0]), this.app.getAM().getAction(UIActionType.CREATE_NEW_ROW));
        this.MENU_TEXT_TO_ACTIONS_MAP.put(IWPI18N.get(this.app, "DELETE_RECORD", new Object[0]), this.app.getAM().getAction(UIActionType.DELETE_ROW));
        this.MENU_TEXT_TO_ACTIONS_MAP.put(IWPI18N.get(this.app, "DELETE_REQUEST", new Object[0]), this.app.getAM().getAction(UIActionType.DELETE_ROW));
        this.MENU_TEXT_TO_ACTIONS_MAP.put(IWPI18N.get(this.app, "SHOW_ALL", new Object[0]), this.app.getAM().getAction(UIActionType.SHOW_ALL_RECORDS));
        this.MENU_TEXT_TO_ACTIONS_MAP.put(IWPI18N.get(this.app, "SHOW_ALL_BROWSE", new Object[0]), this.app.getAM().getAction(UIActionType.SHOW_ALL_RECORDS));
        this.MENU_TEXT_TO_ACTIONS_MAP.put(IWPI18N.get(this.app, "SHOW_OMITTED", new Object[0]), this.app.getAM().getAction(UIActionType.SHOW_OMITTED_RECORDS));
        this.MENU_TEXT_TO_ACTIONS_MAP.put(IWPI18N.get(this.app, "SORT_RECORDS", new Object[0]), this.app.getAM().getAction(UIActionType.SORT_RECORDS));
        this.MENU_TEXT_TO_ACTIONS_MAP.put(IWPI18N.get(this.app, "UNSORT", new Object[0]), this.app.getAM().getAction(UIActionType.UNSORT_RECORDS));
        this.MENU_TEXT_TO_ACTIONS_MAP.put(IWPI18N.get(this.app, "MODIFY_LAST_FIND", new Object[0]), this.app.getAM().getAction(UIActionType.MODIFY_LAST_FIND));
        this.MENU_TEXT_TO_ACTIONS_MAP.put(IWPI18N.get(this.app, "PERFORM_FIND", new Object[0]), this.app.getAM().getAction(UIActionType.PERFORM_FIND));
        this.MENU_TEXT_TO_ACTIONS_MAP.put(IWPI18N.get(this.app, "CONSTRAIN_FOUND_SET", new Object[0]), this.app.getAM().getAction(UIActionType.CONSTRAIN_FOUNDSET));
        this.MENU_TEXT_TO_ACTIONS_MAP.put(IWPI18N.get(this.app, "EXTEND_FOUND_SET", new Object[0]), this.app.getAM().getAction(UIActionType.EXTEND_FOUNDSET));
        this.MENU_TEXT_TO_ACTIONS_MAP.put(IWPI18N.get(this.app, "LOG_OUT", new Object[0]), this.app.getAM().getAction(UIActionType.LOG_OUT));
    }

    @Override
    protected void setMenuDefaults() {
        this.setStatusToolbarState();
        this.setDeleteActionsMenuState();
        this.HideMenuItemsForTouchDevice();
    }

    private void HideMenuItemsForTouchDevice() {
        if (BrowserInfoHandler.isTouchDevice(this.app) && !BrowserInfoHandler.isWin(this.app)) {
            this.findMenuItem(IWPI18N.get(this.app, "FILE", new Object[0])).setVisible(false);
            this.findMenuItem(IWPI18N.get(this.app, "EXPORT_FIELD_CONTENTS", new Object[0])).setVisible(false);
        }
    }

    private void setDeleteActionsMenuState() {
        boolean bl = this.app.getLayoutDataModel().isMasterRecordSet();
        this.findMenuItem(IWPI18N.get(this.app, "DELETE_FOUND", new Object[0])).setVisible(!bl);
        this.findMenuItem(IWPI18N.get(this.app, "DELETE_ALL", new Object[0])).setVisible(bl);
    }

    private void setRecordRequestMenuState() {
        this.findMenuItem(IWPI18N.get(this.app, "RECORDS", new Object[0])).setVisible(this.app.isBrowseMode());
        this.findMenuItem(IWPI18N.get(this.app, "REQUESTS", new Object[0])).setVisible(!this.app.isBrowseMode());
    }

    private void setInsertActionsMenuState() {
        Privileges privileges = this.app.getPrivileges();
        this.findMenuItem(IWPI18N.get(this.app, "CURR_DATE", new Object[0])).getMenuItem().setEnabled(privileges.isCommandEnabled(9));
        this.findMenuItem(IWPI18N.get(this.app, "CURR_TIME", new Object[0])).getMenuItem().setEnabled(privileges.isCommandEnabled(8));
        this.findMenuItem(IWPI18N.get(this.app, "CURR_USER_NAME", new Object[0])).getMenuItem().setEnabled(privileges.isCommandEnabled(7));
    }

    private void setRecordRequestActionsMenuState() {
        Privileges privileges = this.app.getPrivileges();
        switch (this.app.getLayoutDataModel().getMode()) {
            case FIND: {
                this.findMenuItem(IWPI18N.get(this.app, "DUPLICATE_REQUEST", new Object[0])).getMenuItem().setEnabled(privileges.isCommandEnabled(1));
                this.findMenuItem(IWPI18N.get(this.app, "DELETE_REQUEST", new Object[0])).getMenuItem().setEnabled(privileges.isCommandEnabled(3));
                this.findMenuItem(IWPI18N.get(this.app, "SHOW_ALL", new Object[0])).getMenuItem().setEnabled(privileges.isCommandEnabled(19));
                this.findMenuItem(IWPI18N.get(this.app, "PERFORM_FIND", new Object[0])).getMenuItem().setEnabled(privileges.isCommandEnabled(23));
                this.findMenuItem(IWPI18N.get(this.app, "CONSTRAIN_FOUND_SET", new Object[0])).getMenuItem().setEnabled(privileges.isCommandEnabled(25));
                this.findMenuItem(IWPI18N.get(this.app, "EXTEND_FOUND_SET", new Object[0])).getMenuItem().setEnabled(privileges.isCommandEnabled(26));
                break;
            }
            default: {
                this.findMenuItem(IWPI18N.get(this.app, "DELETE_RECORD", new Object[0])).getMenuItem().setEnabled(privileges.isCommandEnabled(3));
                this.findMenuItem(IWPI18N.get(this.app, "SHOW_ALL_BROWSE", new Object[0])).getMenuItem().setEnabled(privileges.isCommandEnabled(19));
                this.findMenuItem(IWPI18N.get(this.app, "OMIT_RECORD", new Object[0])).getMenuItem().setEnabled(privileges.isCommandEnabled(20));
                this.findMenuItem(IWPI18N.get(this.app, "SORT_RECORDS", new Object[0])).getMenuItem().setEnabled(privileges.isCommandEnabled(17));
                this.findMenuItem(IWPI18N.get(this.app, "UNSORT", new Object[0])).getMenuItem().setEnabled(privileges.isCommandEnabled(18));
                this.findMenuItem(IWPI18N.get(this.app, "MODIFY_LAST_FIND", new Object[0])).getMenuItem().setEnabled(privileges.isCommandEnabled(24));
            }
        }
    }

    public void setPrivilegeBasedMenuStates() {
        this.setInsertActionsMenuState();
        Privileges privileges = this.app.getPrivileges();
        IWPMenuItem iWPMenuItem = null;
        this.findMenuItem(IWPI18N.get(this.app, "FORM_VIEW", new Object[0])).getMenuItem().setEnabled(privileges.isCommandEnabled(12));
        this.findMenuItem(IWPI18N.get(this.app, "LIST_VIEW", new Object[0])).getMenuItem().setEnabled(privileges.isCommandEnabled(13));
        this.findMenuItem(IWPI18N.get(this.app, "DELETE_ALL", new Object[0])).getMenuItem().setEnabled(privileges.isCommandEnabled(4));
        this.findMenuItem(IWPI18N.get(this.app, "DELETE_FOUND", new Object[0])).getMenuItem().setEnabled(privileges.isCommandEnabled(4));
        iWPMenuItem = this.findMenuItem(IWPI18N.get(this.app, "CHANGE_PASSWORD_DIALOG_TITLE", new Object[0]));
        if (iWPMenuItem != null) {
            iWPMenuItem.getMenuItem().setEnabled(privileges.isCommandEnabled(29));
        }
        if ((iWPMenuItem = this.findMenuItem(IWPI18N.get(this.app, "REVERT_RECORD", new Object[0]))) != null) {
            iWPMenuItem.getMenuItem().setEnabled(privileges.isCommandEnabled(2));
        }
        if ((iWPMenuItem = this.findMenuItem(IWPI18N.get(this.app, "REVERT_REQUEST", new Object[0]))) != null) {
            iWPMenuItem.getMenuItem().setEnabled(privileges.isCommandEnabled(2));
        }
        if ((iWPMenuItem = this.findMenuItem(IWPI18N.get(this.app, "SNAPSHOT_LINK_DOT", new Object[0]))) != null) {
            iWPMenuItem.getMenuItem().setEnabled(privileges.isCommandEnabled(30));
        }
        if ((iWPMenuItem = this.findMenuItem(IWPI18N.get(this.app, "OMIT_MULT_DOT", new Object[0]))) != null) {
            iWPMenuItem.getMenuItem().setEnabled(privileges.isCommandEnabled(21));
        }
        this.findMenuItem(IWPI18N.get(this.app, "REFRESH_WINDOW", new Object[0])).getMenuItem().setEnabled(privileges.isCommandEnabled(33));
        this.findMenuItem(IWPI18N.get(this.app, "GO_TO", new Object[0])).getMenuItem().setEnabled(privileges.isCommandEnabled(22));
        this.findMenuItem(IWPI18N.get(this.app, "RELOOKUP_FIELD", new Object[0])).getMenuItem().setEnabled(privileges.isCommandEnabled(27));
        this.findMenuItem(IWPI18N.get(this.app, "NEXT_REC", new Object[0])).refresh();
        this.findMenuItem(IWPI18N.get(this.app, "NEXT_REQ", new Object[0])).refresh();
        this.findMenuItem(IWPI18N.get(this.app, "PREV_REC", new Object[0])).refresh();
        this.findMenuItem(IWPI18N.get(this.app, "PREV_REQ", new Object[0])).refresh();
        this.findMenuItem(IWPI18N.get(this.app, "VIEW_AS_PDF_DOT", new Object[0])).getMenuItem().setEnabled(privileges.hasPrintAccess());
    }

    private void setBrowseFindMenuState() {
        IWPMenuItem iWPMenuItem = this.findMenuItem(IWPI18N.get(this.app, "BROWSE_MODE", new Object[0]));
        IWPMenuItem iWPMenuItem2 = this.findMenuItem(IWPI18N.get(this.app, "FIND_MODE", new Object[0]));
        iWPMenuItem.setChecked(this.app.isBrowseMode());
        iWPMenuItem2.setChecked(!this.app.isBrowseMode());
        Privileges privileges = this.app.getPrivileges();
        LayoutMode layoutMode = this.app.getLayoutDataModel().getMode();
        if (layoutMode == LayoutMode.BROWSE) {
            iWPMenuItem.getMenuItem().setEnabled(false);
            iWPMenuItem2.getMenuItem().setEnabled(privileges.isCommandEnabled(16));
        } else if (layoutMode == LayoutMode.FIND) {
            iWPMenuItem.getMenuItem().setEnabled(privileges.isCommandEnabled(15));
            iWPMenuItem2.getMenuItem().setEnabled(false);
        }
    }

    private void setViewStyleState() {
        IWPMenuItem iWPMenuItem = this.findMenuItem(IWPI18N.get(this.app, "FORM_VIEW", new Object[0]));
        IWPMenuItem iWPMenuItem2 = this.findMenuItem(IWPI18N.get(this.app, "LIST_VIEW", new Object[0]));
        Privileges privileges = this.app.getPrivileges();
        LayoutViewStyle layoutViewStyle = this.app.getLayoutDataModel().getViewStyle();
        switch (layoutViewStyle) {
            case FORM: {
                iWPMenuItem.setChecked(true);
                iWPMenuItem2.setChecked(false);
                iWPMenuItem.getMenuItem().setEnabled(false);
                iWPMenuItem2.getMenuItem().setEnabled(privileges.isCommandEnabled(13));
                break;
            }
            case LIST: {
                iWPMenuItem.setChecked(false);
                iWPMenuItem2.setChecked(true);
                iWPMenuItem.getMenuItem().setEnabled(privileges.isCommandEnabled(12));
                iWPMenuItem2.getMenuItem().setEnabled(false);
                break;
            }
            case TABLE: {
                iWPMenuItem.setChecked(false);
                iWPMenuItem2.setChecked(false);
                break;
            }
        }
    }

    @Override
    public void onEvent(UIEvent uIEvent) {
        this.setBrowseFindMenuState();
        switch (uIEvent.getType()) {
            case MASTER_ROW_STATE_CHANGE: {
                this.setDeleteActionsMenuState();
                break;
            }
            case MODE_CHANGE: {
                this.setRecordRequestMenuState();
                break;
            }
            case VIEW_STYLE_CHANGE: 
            case LAYOUT_CHANGE: 
            case LOAD_CACHED_LAYOUT: {
                this.setViewStyleState();
            }
            case TOOLBAR_STATUSAREA_STATE_CHANGE: {
                this.setStatusToolbarState();
                break;
            }
            case ACCOUNTNAME_CHANGE: {
                this.updateAccountName();
                break;
            }
            case REFRESH_MENUBAR: {
                this.refresh();
                break;
            }
        }
    }

    @Override
    public void refresh() {
        this.setRecordRequestMenuState();
        this.setRecordRequestActionsMenuState();
        this.setViewStyleState();
        this.setStatusToolbarState();
        this.updateAccountName();
    }

    public IWPMenuItem getAccountMenu() {
        return this.findMenuItem(IWPI18N.get(this.app, "ACCOUNT_NAME", new Object[0]));
    }

    public void updateAccountName() {
        Context context;
        String string;
        Session session;
        if (this.app != null && (session = this.app.getAppSession()).isLoggedIn() && !Utilities.isEmptyString(string = (context = session.getCurrentContext()).getAccountName())) {
            if ("[\ue002]".equals(string)) {
                string = "[ Guest ]";
            }
            this.menubar.setUserName(string);
        }
    }

    private void setStatusToolbarState() {
        ToolbarStatusAreaState toolbarStatusAreaState = this.app.getDatabaseDataModel().getToolbarStatusAreaState();
        IWPMenuItem iWPMenuItem = this.findMenuItem(IWPI18N.get(this.app, "STATUS_TOOLBAR", new Object[0]));
        if (iWPMenuItem.isChecked() != toolbarStatusAreaState.isShow()) {
            iWPMenuItem.setChecked(toolbarStatusAreaState.isShow());
        }
        ((UIAction)this.MENU_TEXT_TO_ACTIONS_MAP.get(IWPI18N.get(this.app, "STATUS_TOOLBAR", new Object[0]))).setEnabled(!toolbarStatusAreaState.isLocked());
    }

    public StatusAreaMenubarState getState() {
        return (StatusAreaMenubarState)super.getState();
    }

    @Override
    public void setDescription(String string) {
        super.setDescription(string);
        this.updateBooleanState(StatusAreaMenubarState.BooleanState.showTooltip, !Utilities.isEmptyString(this.getDescription()) && this.isEnabled());
    }

    private void updateBooleanState(StatusAreaMenubarState.BooleanState booleanState, boolean bl) {
        this.getState().smbs = IWPUtilities.applyBooleanValue(this.getState().smbs, booleanState.ordinal(), bl);
    }
}

