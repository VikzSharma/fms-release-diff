/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.action;

import com.filemaker.fields.interfaces.SelectionRange;
import com.filemaker.jwpc.iwp.action.UIAction;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.application.AppException;
import com.filemaker.jwpc.iwp.thrift.common.BinaryData;
import com.filemaker.jwpc.iwp.thrift.common.DateTime;
import com.filemaker.jwpc.iwp.thrift.common.UIActionType;
import com.filemaker.jwpc.iwp.thrift.layout.FieldObjectData;
import com.filemaker.jwpc.iwp.ui.layout.LayoutFieldObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutTextFieldObject;
import com.filemaker.jwpc.iwp.ui.layout.component.container.Container;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import java.util.Objects;

public class GlobalUIActionHandlers {
    public static final GlobalUIActionHandlers INSTANCE;
    public static final NextRecordAction GOTO_NEXT_ROW;
    public static final PreviousRecordAction GOTO_PREV_ROW;
    public static final GotoFindAction GOTO_FIND_MODE;
    public static final RefreshWindowAction REFRESH_WINDOW;
    public static final InsertDate INSERT_DATE;
    public static final InsertTime INSERT_TIME;
    public static final InsertCurrentUsername INSERT_CURRENT_USERNAME;
    public static final ShowGoToRecordDialog SHOW_GOTO_ROW_DIALOG;
    public static final ClearAction CLEAR_FIELD_CONTENTS;
    public static final ContainerInsertAction SHOW_INSERT_INTO_CONTAINER_DIALOG;
    public static final ShowZoomedImageAction VIEW_ZOOMED_IMAGE;
    public static final GoToRecordAction GOTO_ROW_BY_INDEX;
    public static final AbortLongOperationAction ABORT_LONG_OPERATION;
    public static final AbortLongScriptAction ABORT_LONG_SCRIPT;
    public static final InsertUploadedFileIntoContainer INSERT_UPLOADED_FILE_INTO_CONTAINER;
    public static final ModifyNonContainerFieldAction MODIFY_FIELD_TEXT;
    public static final GotoLayoutAction GOTO_LAYOUT_BY_NAME;
    public static final GotoLayoutByIdAction GOTO_LAYOUT_BY_ID;
    public static final InsertDateFromCalendarAction INSERT_DATE_FROM_CALENDAR;
    public static final ProcessClickAction PROCESS_CLICK;
    public static final PerformQuickFindAction PERFORM_QUICK_FIND;
    public static final CommitRecordAction COMMIT_RECORD;
    public static final EnterFieldAction ENTER_FIELD;
    public static final ExecuteScriptByIdAction EXECUTE_SCRIPT_BY_ID;
    public static final ExecuteScriptByNameAction EXECUTE_SCRIPT_BY_NAME;
    public static final UIAction GOTO_BROWSE_MODE;
    public static final UIAction TOGGLE_STATUS_AREA;
    public static final UIAction OMIT_RECORDS;
    public static final UIAction GOTO_LIST_VIEW;
    public static final UIAction GOTO_FORM_VIEW;
    public static final UIAction EXIT_POPOVER;
    public static final UIAction GOTO_NEXT_FIELD;
    public static final UIAction GOTO_PREV_FIELD;
    public static final UIAction RESUME_SCRIPT;
    public static final UIAction TOGGLE_OMIT_STATE;
    public static final UIAction DELETE_ALL_RECORDS;
    public static final UIAction CHANGE_PASSWORD;
    public static final UIAction REVERT_ROW;
    public static final UIAction RELOOKUP_FIELD;
    public static final UIAction SAVEAS_SNAPSHOT_LINK;
    public static final UIAction VIEW_AS_PDF;
    public static final UIAction CLOSE_TOPMOST_VISIBLE_WINDOW;
    public static final UIAction HANDLE_KEY_STROKE;

    private GlobalUIActionHandlers() {
    }

    static {
        GlobalUIActionHandlers globalUIActionHandlers = INSTANCE = new GlobalUIActionHandlers();
        Objects.requireNonNull(globalUIActionHandlers);
        GOTO_NEXT_ROW = new NextRecordAction(globalUIActionHandlers, UIActionType.GOTO_NEXT_ROW);
        GlobalUIActionHandlers globalUIActionHandlers2 = INSTANCE;
        Objects.requireNonNull(globalUIActionHandlers2);
        GOTO_PREV_ROW = new PreviousRecordAction(globalUIActionHandlers2, UIActionType.GOTO_PREV_ROW);
        GlobalUIActionHandlers globalUIActionHandlers3 = INSTANCE;
        Objects.requireNonNull(globalUIActionHandlers3);
        GOTO_FIND_MODE = new GotoFindAction(globalUIActionHandlers3, UIActionType.GOTO_FIND_MODE);
        GlobalUIActionHandlers globalUIActionHandlers4 = INSTANCE;
        Objects.requireNonNull(globalUIActionHandlers4);
        REFRESH_WINDOW = new RefreshWindowAction(globalUIActionHandlers4, UIActionType.REFRESH_WINDOW);
        GlobalUIActionHandlers globalUIActionHandlers5 = INSTANCE;
        Objects.requireNonNull(globalUIActionHandlers5);
        INSERT_DATE = new InsertDate(globalUIActionHandlers5, UIActionType.INSERT_DATE);
        GlobalUIActionHandlers globalUIActionHandlers6 = INSTANCE;
        Objects.requireNonNull(globalUIActionHandlers6);
        INSERT_TIME = new InsertTime(globalUIActionHandlers6, UIActionType.INSERT_TIME);
        GlobalUIActionHandlers globalUIActionHandlers7 = INSTANCE;
        Objects.requireNonNull(globalUIActionHandlers7);
        INSERT_CURRENT_USERNAME = new InsertCurrentUsername(globalUIActionHandlers7, UIActionType.INSERT_CURRENT_USERNAME);
        GlobalUIActionHandlers globalUIActionHandlers8 = INSTANCE;
        Objects.requireNonNull(globalUIActionHandlers8);
        SHOW_GOTO_ROW_DIALOG = new ShowGoToRecordDialog(globalUIActionHandlers8, UIActionType.SHOW_GOTO_ROW_DIALOG);
        GlobalUIActionHandlers globalUIActionHandlers9 = INSTANCE;
        Objects.requireNonNull(globalUIActionHandlers9);
        CLEAR_FIELD_CONTENTS = new ClearAction(globalUIActionHandlers9, UIActionType.CLEAR_FIELD_CONTENTS);
        GlobalUIActionHandlers globalUIActionHandlers10 = INSTANCE;
        Objects.requireNonNull(globalUIActionHandlers10);
        SHOW_INSERT_INTO_CONTAINER_DIALOG = new ContainerInsertAction(globalUIActionHandlers10, UIActionType.SHOW_INSERT_INTO_CONTAINER_DIALOG);
        GlobalUIActionHandlers globalUIActionHandlers11 = INSTANCE;
        Objects.requireNonNull(globalUIActionHandlers11);
        VIEW_ZOOMED_IMAGE = new ShowZoomedImageAction(globalUIActionHandlers11, UIActionType.VIEW_ZOOMED_IMAGE);
        GlobalUIActionHandlers globalUIActionHandlers12 = INSTANCE;
        Objects.requireNonNull(globalUIActionHandlers12);
        GOTO_ROW_BY_INDEX = new GoToRecordAction(globalUIActionHandlers12, UIActionType.GOTO_ROW_BY_INDEX);
        GlobalUIActionHandlers globalUIActionHandlers13 = INSTANCE;
        Objects.requireNonNull(globalUIActionHandlers13);
        ABORT_LONG_OPERATION = new AbortLongOperationAction(globalUIActionHandlers13, UIActionType.ABORT_LONG_OPERATION);
        GlobalUIActionHandlers globalUIActionHandlers14 = INSTANCE;
        Objects.requireNonNull(globalUIActionHandlers14);
        ABORT_LONG_SCRIPT = new AbortLongScriptAction(globalUIActionHandlers14, UIActionType.ABORT_LONG_SCRIPT);
        GlobalUIActionHandlers globalUIActionHandlers15 = INSTANCE;
        Objects.requireNonNull(globalUIActionHandlers15);
        INSERT_UPLOADED_FILE_INTO_CONTAINER = new InsertUploadedFileIntoContainer(globalUIActionHandlers15, UIActionType.INSERT_UPLOADED_FILE_INTO_CONTAINER);
        GlobalUIActionHandlers globalUIActionHandlers16 = INSTANCE;
        Objects.requireNonNull(globalUIActionHandlers16);
        MODIFY_FIELD_TEXT = new ModifyNonContainerFieldAction(globalUIActionHandlers16, UIActionType.MODIFY_FIELD_TEXT);
        GlobalUIActionHandlers globalUIActionHandlers17 = INSTANCE;
        Objects.requireNonNull(globalUIActionHandlers17);
        GOTO_LAYOUT_BY_NAME = new GotoLayoutAction(globalUIActionHandlers17, UIActionType.GOTO_LAYOUT_BY_NAME);
        GlobalUIActionHandlers globalUIActionHandlers18 = INSTANCE;
        Objects.requireNonNull(globalUIActionHandlers18);
        GOTO_LAYOUT_BY_ID = new GotoLayoutByIdAction(globalUIActionHandlers18, UIActionType.GOTO_LAYOUT_BY_ID);
        GlobalUIActionHandlers globalUIActionHandlers19 = INSTANCE;
        Objects.requireNonNull(globalUIActionHandlers19);
        INSERT_DATE_FROM_CALENDAR = new InsertDateFromCalendarAction(globalUIActionHandlers19, UIActionType.INSERT_DATE_FROM_CALENDAR);
        GlobalUIActionHandlers globalUIActionHandlers20 = INSTANCE;
        Objects.requireNonNull(globalUIActionHandlers20);
        PROCESS_CLICK = new ProcessClickAction(globalUIActionHandlers20, UIActionType.PROCESS_CLICK);
        GlobalUIActionHandlers globalUIActionHandlers21 = INSTANCE;
        Objects.requireNonNull(globalUIActionHandlers21);
        PERFORM_QUICK_FIND = new PerformQuickFindAction(globalUIActionHandlers21, UIActionType.PERFORM_QUICK_FIND);
        GlobalUIActionHandlers globalUIActionHandlers22 = INSTANCE;
        Objects.requireNonNull(globalUIActionHandlers22);
        COMMIT_RECORD = new CommitRecordAction(globalUIActionHandlers22, UIActionType.COMMIT_RECORD);
        GlobalUIActionHandlers globalUIActionHandlers23 = INSTANCE;
        Objects.requireNonNull(globalUIActionHandlers23);
        ENTER_FIELD = new EnterFieldAction(globalUIActionHandlers23, UIActionType.ENTER_FIELD);
        GlobalUIActionHandlers globalUIActionHandlers24 = INSTANCE;
        Objects.requireNonNull(globalUIActionHandlers24);
        EXECUTE_SCRIPT_BY_ID = new ExecuteScriptByIdAction(globalUIActionHandlers24, UIActionType.EXECUTE_SCRIPT_BY_ID);
        GlobalUIActionHandlers globalUIActionHandlers25 = INSTANCE;
        Objects.requireNonNull(globalUIActionHandlers25);
        EXECUTE_SCRIPT_BY_NAME = new ExecuteScriptByNameAction(globalUIActionHandlers25, UIActionType.EXECUTE_SCRIPT_BY_NAME);
        GOTO_BROWSE_MODE = new UIAction(UIActionType.GOTO_BROWSE_MODE);
        TOGGLE_STATUS_AREA = new UIAction(UIActionType.TOGGLE_STATUS_AREA);
        OMIT_RECORDS = new UIAction(UIActionType.OMIT_RECORDS);
        GOTO_LIST_VIEW = new UIAction(UIActionType.GOTO_LIST_VIEW);
        GOTO_FORM_VIEW = new UIAction(UIActionType.GOTO_FORM_VIEW);
        EXIT_POPOVER = new UIAction(UIActionType.EXIT_POPOVER);
        GOTO_NEXT_FIELD = new UIAction(UIActionType.GOTO_NEXT_FIELD);
        GOTO_PREV_FIELD = new UIAction(UIActionType.GOTO_PREV_FIELD);
        RESUME_SCRIPT = new UIAction(UIActionType.RESUME_SCRIPT);
        TOGGLE_OMIT_STATE = new UIAction(UIActionType.TOGGLE_OMIT_STATE);
        DELETE_ALL_RECORDS = new UIAction(UIActionType.DELETE_ALL_RECORDS);
        CHANGE_PASSWORD = new UIAction(UIActionType.CHANGE_PASSWORD);
        REVERT_ROW = new UIAction(UIActionType.REVERT_ROW);
        RELOOKUP_FIELD = new UIAction(UIActionType.RELOOKUP_FIELD);
        SAVEAS_SNAPSHOT_LINK = new UIAction(UIActionType.SAVEAS_SNAPSHOT_LINK);
        VIEW_AS_PDF = new UIAction(UIActionType.VIEW_AS_PDF);
        CLOSE_TOPMOST_VISIBLE_WINDOW = new UIAction(UIActionType.CLOSE_TOPMOST_VISIBLE_WINDOW);
        HANDLE_KEY_STROKE = new UIAction(UIActionType.HANDLE_KEY_STROKE);
    }

    private final class NextRecordAction
    extends UIAction {
        public NextRecordAction(GlobalUIActionHandlers globalUIActionHandlers, UIActionType uIActionType) {
            super(uIActionType);
        }

        @Override
        public boolean isEnabledFor(App app) {
            return app.getPrivileges().isCommandEnabled(6);
        }
    }

    private final class PreviousRecordAction
    extends UIAction {
        public PreviousRecordAction(GlobalUIActionHandlers globalUIActionHandlers, UIActionType uIActionType) {
            super(uIActionType);
        }

        @Override
        public boolean isEnabledFor(App app) {
            return app.getPrivileges().isCommandEnabled(5);
        }
    }

    private final class GotoFindAction
    extends UIAction {
        public GotoFindAction(GlobalUIActionHandlers globalUIActionHandlers, UIActionType uIActionType) {
            super(uIActionType);
        }

        @Override
        public boolean isEnabledFor(App app) {
            return app.getPrivileges().isCommandEnabled(16);
        }
    }

    private final class RefreshWindowAction
    extends UIAction {
        public RefreshWindowAction(GlobalUIActionHandlers globalUIActionHandlers, UIActionType uIActionType) {
            super(uIActionType);
        }

        @Override
        public void performAction(App app, Object[] objectArray) {
            SelectionRange selectionRange = IWPUtilities.getFieldSelectionRange(app.getActiveUIHandler().getActiveField(true, false));
            app.getAppSession().refreshWindow(selectionRange.getPosition(), selectionRange.getEndPosition(), true);
        }
    }

    private final class InsertDate
    extends UIAction {
        public InsertDate(GlobalUIActionHandlers globalUIActionHandlers, UIActionType uIActionType) {
            super(uIActionType);
        }

        @Override
        public void performAction(App app, Object[] objectArray) {
            if (IWPUtilities.isDebugMode()) assert (objectArray == null);
            LayoutFieldObject layoutFieldObject = app.getActiveUIHandler().getActiveField(true, false);
            if (layoutFieldObject != null) {
                SelectionRange selectionRange = IWPUtilities.getFieldSelectionRange(layoutFieldObject);
                app.getAppSession().insertDate(layoutFieldObject.getAttributes().getObjectSpec(), IWPUtilities.getStandardizedClientTimestamp(app), selectionRange.getPosition(), selectionRange.getEndPosition(), true);
            }
        }
    }

    private final class InsertTime
    extends UIAction {
        public InsertTime(GlobalUIActionHandlers globalUIActionHandlers, UIActionType uIActionType) {
            super(uIActionType);
        }

        @Override
        public void performAction(App app, Object[] objectArray) {
            if (IWPUtilities.isDebugMode()) assert (objectArray == null);
            LayoutFieldObject layoutFieldObject = app.getActiveUIHandler().getActiveField(true, false);
            if (layoutFieldObject != null) {
                SelectionRange selectionRange = IWPUtilities.getFieldSelectionRange(layoutFieldObject);
                app.getAppSession().insertTime(layoutFieldObject.getAttributes().getObjectSpec(), IWPUtilities.getStandardizedClientTimestamp(app), selectionRange.getPosition(), selectionRange.getEndPosition(), true);
            }
        }
    }

    private final class InsertCurrentUsername
    extends UIAction {
        public InsertCurrentUsername(GlobalUIActionHandlers globalUIActionHandlers, UIActionType uIActionType) {
            super(uIActionType);
        }

        @Override
        public void performAction(App app, Object[] objectArray) {
            if (IWPUtilities.isDebugMode()) assert (objectArray == null);
            LayoutFieldObject layoutFieldObject = app.getActiveUIHandler().getActiveField(true, false);
            if (layoutFieldObject != null) {
                layoutFieldObject.insertData(app.getCurrentUserName());
            }
        }
    }

    private final class ShowGoToRecordDialog
    extends UIAction {
        public ShowGoToRecordDialog(GlobalUIActionHandlers globalUIActionHandlers, UIActionType uIActionType) {
            super(uIActionType);
        }
    }

    private final class ClearAction
    extends UIAction {
        public ClearAction(GlobalUIActionHandlers globalUIActionHandlers, UIActionType uIActionType) {
            super(uIActionType);
        }

        @Override
        protected void performAction(App app, Object[] objectArray) {
            if (IWPUtilities.isDebugMode()) assert (objectArray == null);
            LayoutFieldObject layoutFieldObject = app.getActiveUIHandler().getActiveField(true, false);
            if (layoutFieldObject != null) {
                SelectionRange selectionRange = IWPUtilities.getFieldSelectionRange(layoutFieldObject);
                app.getAppSession().clearFieldContents(layoutFieldObject.getAttributes().getObjectSpec(), selectionRange.getPosition(), selectionRange.getEndPosition(), true);
            }
        }

        @Override
        public boolean isEnabledFor(App app) {
            return app.getPrivileges().isCommandEnabled(32);
        }
    }

    private final class ContainerInsertAction
    extends UIAction {
        public ContainerInsertAction(GlobalUIActionHandlers globalUIActionHandlers, UIActionType uIActionType) {
            super(uIActionType);
        }

        @Override
        public void performAction(App app, Object[] objectArray) {
            if (IWPUtilities.isDebugMode()) assert (objectArray == null);
            Container container = app.getActiveContainerField(false);
            if (container != null) {
                container.showContainerUploadDialog(app);
            }
        }
    }

    private final class ShowZoomedImageAction
    extends UIAction {
        public ShowZoomedImageAction(GlobalUIActionHandlers globalUIActionHandlers, UIActionType uIActionType) {
            super(uIActionType);
        }

        @Override
        public void performAction(App app, Object[] objectArray) {
            Container container = app.getActiveContainerField(false);
            if (container != null) {
                try {
                    container.showZoomedImage();
                }
                catch (AppException appException) {
                    appException.printStackTrace();
                }
            }
        }
    }

    public final class GoToRecordAction
    extends UIAction {
        public GoToRecordAction(GlobalUIActionHandlers globalUIActionHandlers, UIActionType uIActionType) {
            super(uIActionType);
        }

        @Override
        public void performAction(App app, Object[] objectArray) {
            if (IWPUtilities.isDebugMode()) assert (objectArray.length == 1);
            int n = 0;
            try {
                n = objectArray[0] instanceof String ? Integer.parseInt((String)objectArray[0]) : (Integer)objectArray[0];
            }
            catch (NumberFormatException numberFormatException) {
                // empty catch block
            }
            app.getAppSession().gotoRow(n, true);
        }

        @Override
        public boolean isEnabledFor(App app) {
            return app.getPrivileges().isCommandEnabled(22);
        }
    }

    public final class AbortLongOperationAction
    extends UIAction {
        public AbortLongOperationAction(GlobalUIActionHandlers globalUIActionHandlers, UIActionType uIActionType) {
            super(uIActionType);
        }

        @Override
        public void performAction(App app, Object[] objectArray) {
            if (IWPUtilities.isDebugMode()) assert (objectArray == null);
            app.getAppSession().abortLongOperation();
        }
    }

    public final class AbortLongScriptAction
    extends UIAction {
        public AbortLongScriptAction(GlobalUIActionHandlers globalUIActionHandlers, UIActionType uIActionType) {
            super(uIActionType);
        }

        @Override
        public void performAction(App app, Object[] objectArray) {
            app.getAppSession().abortLongRunningScript();
        }
    }

    private final class InsertUploadedFileIntoContainer
    extends UIAction {
        public InsertUploadedFileIntoContainer(GlobalUIActionHandlers globalUIActionHandlers, UIActionType uIActionType) {
            super(uIActionType);
        }

        @Override
        public void performAction(App app, Object[] objectArray) {
            if (IWPUtilities.isDebugMode()) {
                assert (objectArray.length == 2);
                assert (objectArray[0] instanceof String);
                assert (objectArray[1] instanceof Boolean);
            }
            String string = (String)objectArray[0];
            boolean bl = (Boolean)objectArray[1];
            app.getAppSession().insertUploadedFileIntoContainer(string, bl);
        }
    }

    public final class ModifyNonContainerFieldAction
    extends UIAction {
        public ModifyNonContainerFieldAction(GlobalUIActionHandlers globalUIActionHandlers, UIActionType uIActionType) {
            super(uIActionType);
        }

        @Override
        public void performAction(App app, Object[] objectArray) {
            Object object;
            LayoutFieldObject layoutFieldObject = (LayoutFieldObject)objectArray[0];
            if (IWPUtilities.isDebugMode()) {
                assert (objectArray.length == 3);
                assert (objectArray[0] instanceof LayoutFieldObject);
                switch (layoutFieldObject.getMetaData().getType()) {
                    case CONTAINER: {
                        assert (objectArray[1] instanceof BinaryData);
                        break;
                    }
                    default: {
                        if (objectArray[1] != null) assert (objectArray[1] instanceof String);
                        break;
                    }
                }
                assert (objectArray[2] instanceof Boolean);
            }
            if ((object = objectArray[1]) instanceof String) {
                object = ((String)objectArray[1]).replace("\u0000", "");
            }
            FieldObjectData fieldObjectData = IWPUtilities.createFieldObjectData(layoutFieldObject, object);
            if (layoutFieldObject instanceof LayoutTextFieldObject) {
                ((LayoutTextFieldObject)layoutFieldObject).cacheSelectionOnCommit();
            }
            app.getAppSession().modifyNonContainerField(fieldObjectData, (Boolean)objectArray[2], true);
        }
    }

    public final class GotoLayoutAction
    extends UIAction {
        public GotoLayoutAction(GlobalUIActionHandlers globalUIActionHandlers, UIActionType uIActionType) {
            super(uIActionType);
        }

        @Override
        public void performAction(App app, Object[] objectArray) {
            if (IWPUtilities.isDebugMode()) {
                assert (objectArray.length == 1);
                assert (objectArray[0] instanceof String);
            }
            app.getAppSession().gotoLayout((String)objectArray[0], true);
        }
    }

    public final class GotoLayoutByIdAction
    extends UIAction {
        public GotoLayoutByIdAction(GlobalUIActionHandlers globalUIActionHandlers, UIActionType uIActionType) {
            super(uIActionType);
        }

        @Override
        public void performAction(App app, Object[] objectArray) {
            if (IWPUtilities.isDebugMode()) {
                assert (objectArray.length == 1);
                assert (objectArray[0] instanceof Integer);
            }
            app.getAppSession().gotoLayoutById((Integer)objectArray[0], true);
        }
    }

    public final class InsertDateFromCalendarAction
    extends UIAction {
        public InsertDateFromCalendarAction(GlobalUIActionHandlers globalUIActionHandlers, UIActionType uIActionType) {
            super(uIActionType);
        }

        @Override
        public void performAction(App app, Object[] objectArray) {
            if (IWPUtilities.isDebugMode()) {
                assert (objectArray.length == 2);
                assert (objectArray[0] instanceof LayoutFieldObject);
                assert (objectArray[1] instanceof DateTime);
            }
            LayoutFieldObject layoutFieldObject = (LayoutFieldObject)objectArray[0];
            DateTime dateTime = (DateTime)objectArray[1];
            app.getAppSession().insertDateFromCalendar(layoutFieldObject.getAttributes().getObjectSpec(), dateTime, true);
        }
    }

    public final class ProcessClickAction
    extends UIAction {
        public ProcessClickAction(GlobalUIActionHandlers globalUIActionHandlers, UIActionType uIActionType) {
            super(uIActionType);
        }

        @Override
        public void performAction(App app, Object[] objectArray) {
            if (IWPUtilities.isDebugMode()) {
                assert (objectArray.length == 3);
                assert (objectArray[0] instanceof LayoutObject);
                assert (objectArray[1] instanceof Boolean);
                assert (objectArray[2] instanceof Boolean);
            }
            LayoutObject layoutObject = (LayoutObject)objectArray[0];
            SelectionRange selectionRange = IWPUtilities.getFieldSelectionRange(app.getActiveUIHandler().getActiveField(true, false));
            app.getAppSession().processClick(layoutObject.getAttributes().getObjectSpec(), (Boolean)objectArray[1], (Boolean)objectArray[2], layoutObject.getMetaData().hasValidAndExecutableScript(), selectionRange.getPosition(), selectionRange.getEndPosition(), true);
        }
    }

    public final class PerformQuickFindAction
    extends UIAction {
        public PerformQuickFindAction(GlobalUIActionHandlers globalUIActionHandlers, UIActionType uIActionType) {
            super(uIActionType);
        }

        @Override
        public void performAction(App app, Object[] objectArray) {
            if (IWPUtilities.isDebugMode()) assert (objectArray[0] instanceof String);
            app.getAppSession().quickFind((String)objectArray[0], true);
        }
    }

    public final class CommitRecordAction
    extends UIAction {
        private CommitRecordAction(GlobalUIActionHandlers globalUIActionHandlers, UIActionType uIActionType) {
            super(uIActionType);
        }

        @Override
        public void performAction(App app, Object[] objectArray) {
            Boolean bl = Boolean.FALSE;
            if (objectArray != null && objectArray.length > 0) {
                if (IWPUtilities.isDebugMode()) assert (objectArray[0] instanceof Boolean);
                bl = (Boolean)objectArray[0];
            }
            app.getAppSession().commitRecord(bl, true);
        }
    }

    public final class EnterFieldAction
    extends UIAction {
        private EnterFieldAction(GlobalUIActionHandlers globalUIActionHandlers, UIActionType uIActionType) {
            super(uIActionType);
        }

        @Override
        public void performAction(App app, Object[] objectArray) {
            if (IWPUtilities.isDebugMode()) {
                assert (objectArray.length == 2);
                assert (objectArray[0] instanceof LayoutObject);
                assert (objectArray[1] instanceof Boolean);
            }
            LayoutObject layoutObject = (LayoutObject)objectArray[0];
            app.getAppSession().enterField(layoutObject.getAttributes().getObjectSpec(), (Boolean)objectArray[1], true);
        }
    }

    public final class ExecuteScriptByIdAction
    extends UIAction {
        public ExecuteScriptByIdAction(GlobalUIActionHandlers globalUIActionHandlers, UIActionType uIActionType) {
            super(uIActionType);
        }

        @Override
        public void performAction(App app, Object[] objectArray) {
            if (IWPUtilities.isDebugMode()) {
                assert (objectArray.length == 1);
                assert (objectArray[0] instanceof Integer);
            }
            SelectionRange selectionRange = IWPUtilities.getFieldSelectionRange(app.getActiveUIHandler().getActiveField(true, false));
            app.getAppSession().executeScriptById((Integer)objectArray[0], selectionRange.getPosition(), selectionRange.getEndPosition(), true);
        }
    }

    public final class ExecuteScriptByNameAction
    extends UIAction {
        public ExecuteScriptByNameAction(GlobalUIActionHandlers globalUIActionHandlers, UIActionType uIActionType) {
            super(uIActionType);
        }

        @Override
        public void performAction(App app, Object[] objectArray) {
            if (IWPUtilities.isDebugMode()) {
                assert (objectArray.length == 3);
                assert (objectArray[0] instanceof String);
                assert (objectArray[1] instanceof String);
                assert (objectArray[2] instanceof String);
            }
            app.getAppSession().executeScriptByName((String)objectArray[0], (String)objectArray[1], (String)objectArray[2], true);
        }
    }
}

