/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.action;

import com.filemaker.jwpc.iwp.action.UIAction;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.model.DatabaseDataModel;
import com.filemaker.jwpc.iwp.model.Privileges;
import com.filemaker.jwpc.iwp.thrift.common.UIActionType;
import com.filemaker.jwpc.iwp.ui.event.ActiveObjectChangeEvent;
import com.filemaker.jwpc.iwp.ui.event.ScriptStateChangeEvent;
import com.filemaker.jwpc.iwp.ui.event.UIEvent;
import com.filemaker.jwpc.iwp.ui.event.UIEventListener;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class ActionManager
implements UIEventListener {
    private final WeakReference<App> app;
    private final Map<UIActionType, UIAction> actions = new HashMap<UIActionType, UIAction>();

    public ActionManager(WeakReference<App> weakReference) {
        this.app = weakReference;
        this.actions.put(UIActionType.CANCEL_FIND, new UIAction(UIActionType.CANCEL_FIND));
        this.actions.put(UIActionType.CONSTRAIN_FOUNDSET, new UIAction(UIActionType.CONSTRAIN_FOUNDSET));
        this.actions.put(UIActionType.DELETE_ROW, new UIAction(UIActionType.DELETE_ROW));
        this.actions.put(UIActionType.DUP_ROW, new UIAction(UIActionType.DUP_ROW));
        this.actions.put(UIActionType.IMPORT_RECORDS, new UIAction(UIActionType.IMPORT_RECORDS));
        this.actions.put(UIActionType.EXECUTE_BUTTON_SCRIPT, new ExecuteButtonScriptAction(this, UIActionType.EXECUTE_BUTTON_SCRIPT));
        this.actions.put(UIActionType.EXIT_SCRIPT, new UIAction(UIActionType.EXIT_SCRIPT));
        this.actions.put(UIActionType.EXPORT_FIELD_CONTENTS, new UIAction(UIActionType.EXPORT_FIELD_CONTENTS));
        this.actions.put(UIActionType.EXPORT_RECORDS, new UIAction(UIActionType.EXPORT_RECORDS));
        this.actions.put(UIActionType.EXTEND_FOUNDSET, new UIAction(UIActionType.EXTEND_FOUNDSET));
        this.actions.put(UIActionType.LOG_OUT, new LogOutAction(this, UIActionType.LOG_OUT));
        this.actions.put(UIActionType.MODIFY_LAST_FIND, new UIAction(UIActionType.MODIFY_LAST_FIND));
        this.actions.put(UIActionType.CREATE_NEW_ROW, new UIAction(UIActionType.CREATE_NEW_ROW));
        this.actions.put(UIActionType.OMIT_RECORD, new UIAction(UIActionType.OMIT_RECORD));
        this.actions.put(UIActionType.PERFORM_FIND, new UIAction(UIActionType.PERFORM_FIND));
        this.actions.put(UIActionType.SHOW_ALL_RECORDS, new UIAction(UIActionType.SHOW_ALL_RECORDS));
        this.actions.put(UIActionType.SHOW_OMITTED_RECORDS, new UIAction(UIActionType.SHOW_OMITTED_RECORDS));
        this.actions.put(UIActionType.SORT_RECORDS, new UIAction(UIActionType.SORT_RECORDS));
        this.actions.put(UIActionType.UNSORT_RECORDS, new UIAction(UIActionType.UNSORT_RECORDS));
    }

    public UIAction getAction(UIActionType uIActionType) {
        return this.actions.get((Object)uIActionType);
    }

    public void perform(App app, UIActionType uIActionType) {
        this.perform(app, uIActionType, null);
    }

    public void perform(App app, UIActionType uIActionType, Object[] objectArray) {
        this.actions.get((Object)uIActionType).perform(app, objectArray);
    }

    @Override
    public void onEvent(UIEvent uIEvent) {
        if (this.app.get() != null) {
            App app = (App)((Object)this.app.get());
            switch (uIEvent.getType()) {
                case LAYOUT_RENDERED: 
                case UPDATE_PRIVILEGES: {
                    if (app.getLayoutContainer().getCurrentView() == null) break;
                    if (!app.getAppView().isCardStyleWindow()) {
                        app.getAppContainer().getMenubar().setPrivilegeBasedMenuStates();
                    }
                    this.updateCommonDataModel();
                    break;
                }
                case ACTIVE_OBJECT_CHANGE: {
                    if (app.getLayoutContainer().getCurrentView() == null) break;
                    this.updateActiveObjectActions();
                    app.getActiveUIHandler().updateContextMenu(((ActiveObjectChangeEvent)uIEvent).getLayoutObject());
                    break;
                }
                case SCRIPT_STATE_CHANGE: {
                    this.updateActionsOnScriptStateChanged(((ScriptStateChangeEvent)uIEvent).allowAbort());
                    break;
                }
            }
        }
    }

    private void updateCommonDataModel() {
        if (this.app.get() != null) {
            Privileges privileges = ((App)((Object)this.app.get())).getPrivileges();
            this.actions.get((Object)UIActionType.CREATE_NEW_ROW).setEnabled(privileges.isCommandEnabled(0));
            this.actions.get((Object)UIActionType.DUP_ROW).setEnabled(privileges.isCommandEnabled(1));
            this.actions.get((Object)UIActionType.DELETE_ROW).setEnabled(privileges.isCommandEnabled(3));
            this.actions.get((Object)UIActionType.SORT_RECORDS).setEnabled(privileges.isCommandEnabled(17));
            this.actions.get((Object)UIActionType.UNSORT_RECORDS).setEnabled(privileges.isCommandEnabled(18));
            this.actions.get((Object)UIActionType.SHOW_ALL_RECORDS).setEnabled(privileges.isCommandEnabled(19));
            this.actions.get((Object)UIActionType.SHOW_OMITTED_RECORDS).setEnabled(privileges.isCommandEnabled(28));
            this.actions.get((Object)UIActionType.OMIT_RECORD).setEnabled(privileges.isCommandEnabled(20));
            this.actions.get((Object)UIActionType.MODIFY_LAST_FIND).setEnabled(privileges.isCommandEnabled(24));
            this.actions.get((Object)UIActionType.CONSTRAIN_FOUNDSET).setEnabled(privileges.isCommandEnabled(25));
            this.actions.get((Object)UIActionType.EXTEND_FOUNDSET).setEnabled(privileges.isCommandEnabled(26));
            this.actions.get((Object)UIActionType.PERFORM_FIND).setEnabled(privileges.isCommandEnabled(23));
            this.actions.get((Object)UIActionType.CANCEL_FIND).setEnabled(privileges.isCommandEnabled(15));
            this.actions.get((Object)UIActionType.EXPORT_RECORDS).setEnabled(privileges.isCommandEnabled(10));
            this.actions.get((Object)UIActionType.IMPORT_RECORDS).setEnabled(privileges.isCommandEnabled(11));
        }
    }

    private void updateActionsOnScriptStateChanged(boolean bl) {
        App app = (App)((Object)this.app.get());
        if (app != null && !app.getAppView().isCardStyleWindow()) {
            DatabaseDataModel databaseDataModel = ((App)((Object)this.app.get())).getDatabaseDataModel();
            boolean bl2 = !databaseDataModel.isScriptRunning() && (!databaseDataModel.isScriptPaused() || bl);
            this.actions.get((Object)UIActionType.LOG_OUT).setEnabled(bl2);
        }
    }

    private void updateActiveObjectActions() {
        if (this.app.get() != null) {
            ((App)((Object)this.app.get())).getAppView().updatedContextMenuEnabledness();
        }
    }

    private final class ExecuteButtonScriptAction
    extends UIAction {
        public ExecuteButtonScriptAction(ActionManager actionManager, UIActionType uIActionType) {
            super(uIActionType);
        }

        @Override
        public void performAction(App app, Object[] objectArray) {
            if (IWPUtilities.isDebugMode()) {
                assert (objectArray.length == 1);
                assert (objectArray[0] instanceof Integer);
            }
            app.getAppSession().executeButtonScript((Integer)objectArray[0], true);
        }
    }

    private final class LogOutAction
    extends UIAction {
        public LogOutAction(ActionManager actionManager, UIActionType uIActionType) {
            super(uIActionType);
        }

        @Override
        public void performAction(App app, Object[] objectArray) {
            if (IWPUtilities.isDebugMode()) assert (objectArray == null);
            app.attemptSessionLogout();
        }
    }
}

