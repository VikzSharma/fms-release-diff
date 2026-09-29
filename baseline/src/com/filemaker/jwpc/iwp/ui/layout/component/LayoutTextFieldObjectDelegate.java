/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.filemaker.jwpc.fmwp.datatype.ErrorCode
 *  com.vaadin.ui.Component
 */
package com.filemaker.jwpc.iwp.ui.layout.component;

import com.filemaker.fields.FMField;
import com.filemaker.fields.interfaces.SelectionRange;
import com.filemaker.jwpc.fmwp.datatype.ErrorCode;
import com.filemaker.jwpc.iwp.action.GlobalUIActionHandlers;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.metadata.ObjectMetaData;
import com.filemaker.jwpc.iwp.thrift.common.DBAccessLevel;
import com.filemaker.jwpc.iwp.thrift.common.LayoutFieldType;
import com.filemaker.jwpc.iwp.thrift.layout.FieldObjectData;
import com.filemaker.jwpc.iwp.ui.layout.LayoutTextFieldObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutView;
import com.filemaker.jwpc.iwp.ui.layout.ObjectAttributes;
import com.filemaker.jwpc.iwp.ui.layout.component.LayoutFieldObjectDelegate;
import com.filemaker.jwpc.iwp.ui.layout.component.StringDataUpdateParameters;
import com.filemaker.jwpc.iwp.ui.layout.listener.FieldListener;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.filemaker.jwpc.iwp.util.LayoutObjectUtilities;
import com.vaadin.ui.Component;

public class LayoutTextFieldObjectDelegate
extends LayoutFieldObjectDelegate {
    private FMField field;
    private LayoutTextFieldObject layFieldObject;
    private FieldListener listener;
    public boolean initialized = false;
    public DBAccessLevel access = DBAccessLevel.UnknownAccess;
    private boolean hasAccess = false;
    public String currentText;
    private SelectionRange cachedSelectionRange;

    public LayoutTextFieldObjectDelegate(App app, LayoutView layoutView, LayoutTextFieldObject layoutTextFieldObject, ObjectMetaData objectMetaData, ObjectAttributes objectAttributes) {
        super(app, layoutView, layoutTextFieldObject, objectMetaData, objectAttributes);
        this.listener = new FieldListener(app, layoutTextFieldObject);
        this.layFieldObject = layoutTextFieldObject;
        this.field = (FMField)((Object)layoutTextFieldObject);
        this.getApp().initContextMenu(true);
    }

    public void reset() {
        this.currentText = null;
    }

    public void onTabPress(boolean bl, String string) {
        this.updateData(string, true);
        GlobalUIActionHandlers.MODIFY_FIELD_TEXT.perform(this.app, new Object[]{this.layFieldObject, string, false});
        this.app.getActiveUIHandler().setPendingTabbing(true);
        if (bl) {
            GlobalUIActionHandlers.GOTO_NEXT_FIELD.perform(this.app, null);
        } else {
            GlobalUIActionHandlers.GOTO_PREV_FIELD.perform(this.app, null);
        }
    }

    public void onTextChange(String string, boolean bl) {
        if (this.app.getCurrentErrorCode() == ErrorCode.None.getErrorCode()) {
            this.currentText = string;
            if (bl) {
                this.updateData(string, true);
            }
            GlobalUIActionHandlers.MODIFY_FIELD_TEXT.perform(this.app, new Object[]{this.layFieldObject, string, false});
        }
    }

    public void onEnterPress(boolean bl, String string) {
        this.updateData(string, true);
        GlobalUIActionHandlers.MODIFY_FIELD_TEXT.perform(this.app, new Object[]{this.layFieldObject, string, false});
        this.app.onEnterPressed(bl);
    }

    public void onKeystroke(String string, int n, boolean bl) {
        this.app.onKeystroke(string, n, bl);
    }

    public void onBrowserResize(int n, int n2, String string) {
        this.updateData(string, false);
        String string2 = string.replace("\u0000", "");
        FieldObjectData fieldObjectData = IWPUtilities.createFieldObjectData(this.layFieldObject, string2);
        SelectionRange selectionRange = IWPUtilities.getFieldSelectionRange(this.layFieldObject);
        fieldObjectData.getFieldData().setUpdateSelection(true);
        fieldObjectData.getFieldData().setSelectionStart(selectionRange.getPosition());
        fieldObjectData.getFieldData().setSelectionEnd(selectionRange.getEndPosition());
        this.app.browserResizedWithActiveField(n, n2, fieldObjectData);
    }

    public void onFieldObjectClick() {
        this.listener.onFieldObjectClick(this.waitForServerOnEnter());
    }

    public void updateFieldObjectData(StringDataUpdateParameters stringDataUpdateParameters, boolean bl) {
        Component component = this.getWrappedObject();
        if (this.app.getLayoutDataModel().getLayoutName() == null) {
            System.out.println("EditBox.updateFieldObjectData(): Invalid windowstate!");
            return;
        }
        if (!stringDataUpdateParameters.hasError()) {
            if (stringDataUpdateParameters.needsFormatting() && this.getMetaData().hasDataFormatting()) {
                LayoutObjectUtilities.updateFieldObjectData(this.app, this.layFieldObject);
            } else {
                this.updateDataEntry(stringDataUpdateParameters.getAccess(), false);
                Object object = stringDataUpdateParameters.getData().getValue().replaceAll("\r", "\n");
                object = (String)object + "\n";
                if (this.isNegativeNumber() != stringDataUpdateParameters.getData().isNegativeNumber()) {
                    this.setNegativeNumber(component, stringDataUpdateParameters.getData().isNegativeNumber());
                }
                if (stringDataUpdateParameters.hasStreamOn()) {
                    this.updateData((String)object, false, stringDataUpdateParameters.hasStreamOn());
                } else {
                    this.updateData((String)object, false);
                }
            }
        } else {
            this.disableAccess();
            this.access = DBAccessLevel.NoAccess;
            this.setNegativeNumber(component, false);
            this.updateData(stringDataUpdateParameters.getErrorMessage(), false);
        }
        if (stringDataUpdateParameters.updateSelection()) {
            this.field.startEdit();
            this.field.setSelectionRange(stringDataUpdateParameters.selectionStart(), stringDataUpdateParameters.selectionEnd() - stringDataUpdateParameters.selectionStart());
        }
    }

    public void disableAccess() {
        this.hasAccess = false;
        this.access = DBAccessLevel.ReadOnly;
        this.field.setReadOnly(true);
        this.updateTabIndex(-1);
        this.activateGlassPane();
    }

    public boolean enableAccess() {
        this.hasAccess = true;
        this.access = DBAccessLevel.ReadWrite;
        this.field.setReadOnly(false);
        if (this.getMetaData().getFieldType() == LayoutFieldType.NORMAL) {
            this.updateTabIndex(this.getMetaData().getTabOrder(this.getAttributes().getRepetition()));
        } else {
            this.updateTabIndex(-1);
        }
        if (this.getMetaData().hasValidAndExecutableScript()) {
            this.activateGlassPane();
        } else {
            this.deactivateGlassPane();
        }
        return true;
    }

    public void updateDataEntry(DBAccessLevel dBAccessLevel, boolean bl) {
        this.access = dBAccessLevel;
        if (this.hasDataEntryHandler()) {
            boolean bl2 = this.hasAccess;
            this.hasAccess = LayoutObjectUtilities.allowDataEntry(this.app, this.layFieldObject, dBAccessLevel);
            if (bl || bl2 != this.hasAccess) {
                if (this.hasAccess) {
                    this.enableAccess();
                } else {
                    this.disableAccess();
                }
            }
        }
    }

    private void updateData(String string, boolean bl) {
        if (bl || this.needToUpdateValue(string)) {
            boolean bl2 = this.field.isReadOnly();
            boolean bl3 = this.field.isEnabled();
            this.field.setReadOnly(false);
            this.field.setEnabled(true);
            this.layFieldObject.setTextValue(string);
            this.field.setReadOnly(bl2);
            this.field.setEnabled(bl3);
            this.field.markAsDirty();
        }
    }

    private void updateData(String string, boolean bl, boolean bl2) {
        if (bl || this.needToUpdateValue(string)) {
            boolean bl3 = this.field.isReadOnly();
            boolean bl4 = this.field.isEnabled();
            this.field.setReadOnly(false);
            this.field.setEnabled(true);
            if (bl2) {
                this.layFieldObject.setTextValue(string, bl2);
            }
            this.field.setReadOnly(bl3);
            this.field.setEnabled(bl4);
            this.field.markAsDirty();
        }
    }

    public boolean needToUpdateValue(String string) {
        String string2 = this.getData();
        if (string == null) {
            return string2 != null;
        }
        return !string.equals(string2);
    }

    public String getData() {
        return this.currentText != null ? this.currentText : this.layFieldObject.getTextValue();
    }

    public DBAccessLevel getAccess() {
        return this.access;
    }

    public int getCaretPosition() {
        int n = this.field.getCursorPosition();
        if (n < 0) {
            n = this.getData().length();
        }
        return n;
    }

    public void insertData(String string) {
        int n = this.getCaretPosition();
        int n2 = this.field.getSelectionRange().getLength() + n;
        String string2 = IWPUtilities.getValueAfterInsert(this.getData(), n, n2, string);
        this.updateData(string2, false);
        GlobalUIActionHandlers.MODIFY_FIELD_TEXT.perform(this.app, new Object[]{this.layFieldObject, string2, false});
        this.field.startEdit();
        int n3 = n + string.length();
        this.field.setCursorPosition(n3);
    }

    public void cacheSelectionOnCommit() {
        this.cachedSelectionRange = this.field.getSelectionRange();
    }

    public void syncSelectionOnCommitFailure() {
        this.field.syncServerValue();
        this.field.setSelectionRange(this.cachedSelectionRange.getPosition(), this.cachedSelectionRange.getLength());
    }
}

