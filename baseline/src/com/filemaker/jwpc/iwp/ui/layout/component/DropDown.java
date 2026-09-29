/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.Component
 *  com.vaadin.ui.UI
 */
package com.filemaker.jwpc.iwp.ui.layout.component;

import com.filemaker.fields.client.combobox.ComboBoxItem;
import com.filemaker.fields.client.common.FMClientRpc;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.metadata.ObjectMetaData;
import com.filemaker.jwpc.iwp.notification.processor.BrowserInfoHandler;
import com.filemaker.jwpc.iwp.thrift.common.LayoutFieldDataType;
import com.filemaker.jwpc.iwp.thrift.common.LayoutObjectType;
import com.filemaker.jwpc.iwp.ui.layout.LayoutTextFieldObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutView;
import com.filemaker.jwpc.iwp.ui.layout.ObjectAttributes;
import com.filemaker.jwpc.iwp.ui.layout.component.LayoutTextFieldObjectDelegate;
import com.filemaker.jwpc.iwp.ui.layout.component.Popup;
import com.filemaker.jwpc.iwp.ui.layout.component.StringDataUpdateParameters;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.DropDownClientRpc;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.TextFieldServerRpc;
import com.filemaker.jwpc.iwp.widgetset.client.state.DropDownState;
import com.vaadin.ui.Component;
import com.vaadin.ui.UI;

public class DropDown
extends Popup
implements LayoutTextFieldObject {
    private boolean pendingNavigationFocus = true;

    public DropDown(App app, LayoutView layoutView, ObjectMetaData objectMetaData, ObjectAttributes objectAttributes) {
        super(app, layoutView, objectMetaData, objectAttributes);
        this.type = LayoutObjectType.DROP_DOWN;
        this.registerTextFieldRpc();
    }

    @Override
    protected void initDelegate(App app, LayoutView layoutView, ObjectMetaData objectMetaData, ObjectAttributes objectAttributes) {
        this.delegate = new LayoutTextFieldObjectDelegate(app, layoutView, this, objectMetaData, objectAttributes);
    }

    private LayoutTextFieldObjectDelegate getDelegate() {
        return (LayoutTextFieldObjectDelegate)this.delegate;
    }

    private void registerTextFieldRpc() {
        TextFieldServerRpc textFieldServerRpc = new TextFieldServerRpc(){

            @Override
            public void onTabPress(boolean bl, String string) {
                DropDown.this.onTabPress(bl, string);
            }

            @Override
            public void onTextChange(String string, boolean bl) {
                DropDown.this.onTextChange(string, bl);
            }

            @Override
            public void enterField() {
                DropDown.this.onFieldObjectClick();
            }

            @Override
            public void printthis(String string) {
                System.out.println("[CLIENT DEBUG - " + DropDown.this.getUniqueId() + " ] " + string);
            }

            @Override
            public void onEnterPress(boolean bl, String string) {
                DropDown.this.onEnterPress(bl, string);
            }

            @Override
            public void onBrowserResize(int n, int n2, String string) {
                DropDown.this.onBrowserResize(n, n2, string);
            }

            @Override
            public void checkNavigationFocus() {
                DropDown.this.checkNavigationFocus();
            }

            @Override
            public void setPendingNavigationFocus() {
                DropDown.this.pendingNavigationFocus = true;
            }

            @Override
            public void onKeystroke(String string, int n, boolean bl) {
            }

            @Override
            public void onShowContextMenu(int n, int n2, int n3) {
                DropDown.this.onFieldObjectClick();
                DropDown.this.startEdit();
                DropDown.this.updatedFieldContextMenuState(n3);
                DropDown.this.showContextMenu(n, n2);
            }
        };
        this.registerRpc(textFieldServerRpc);
    }

    @Override
    protected void initUI() {
        super.initUI();
        this.setSelectContentsOnEdit(true);
    }

    @Override
    public DropDownState getState() {
        return (DropDownState)super.getState();
    }

    @Override
    public void onActive() {
        this.isActive = true;
        this.startEdit();
        ((DropDownClientRpc)this.getRpcProxy(DropDownClientRpc.class)).setActive(true);
    }

    @Override
    public void onInactive() {
        this.isActive = false;
        this.stopEdit();
        ((DropDownClientRpc)this.getRpcProxy(DropDownClientRpc.class)).setActive(false);
    }

    @Override
    public void updateFieldObjectData(StringDataUpdateParameters stringDataUpdateParameters, boolean bl) {
        super.updateFieldObjectData(stringDataUpdateParameters, bl);
        if (stringDataUpdateParameters.updateSelection()) {
            this.startEdit();
            this.setSelectionRange(stringDataUpdateParameters.selectionStart(), stringDataUpdateParameters.selectionEnd() - stringDataUpdateParameters.selectionStart());
        }
    }

    @Override
    public void insertData(String string) {
        int n = this.getDelegate().getCaretPosition();
        int n2 = this.getSelectionRange().getLength() + n;
        String string2 = IWPUtilities.getValueAfterInsert(this.getFieldData().toString(), n, n2, string);
        super.insertData(string2);
        this.startEdit();
        int n3 = n + string.length();
        this.setCursorPosition(n3);
    }

    @Override
    public void beforeClientResponse(boolean bl) {
        super.beforeClientResponse(bl);
        super.setArrowVisible(this.getMetaData().hasIcon());
        this.updateBooleanState(DropDownState.BooleanState.hasIcon, this.getMetaData().hasIcon());
        this.updateBooleanState(DropDownState.BooleanState.isNumberField, this.getMetaData().getFieldDataType() == LayoutFieldDataType.NUMBER);
        this.updateBooleanState(DropDownState.BooleanState.useAutoComplete, this.getMetaData().getUseAutoComplete());
        this.getState().hasPortalFocus = this.delegate.getApp().getActiveUIHandler().isActiveObject(this) && this.delegate.getAttributes().getOwningPortal() != null;
    }

    private void updateBooleanState(DropDownState.BooleanState booleanState, boolean bl) {
        this.getState().ddbs = IWPUtilities.applyBooleanValue(this.getState().ddbs, booleanState.ordinal(), bl);
    }

    @Override
    protected void setSelectedItem() {
        this.getState().selectedItem = (ComboBoxItem)this.getValue();
    }

    @Override
    public boolean changeFieldOnValueSelection() {
        return true;
    }

    @Override
    public void onFieldObjectClick() {
        if (this.delegate.getApp().isTouchUI() && this.delegate.getApp().isFormView() && UI.getCurrent() != null) {
            UI.getCurrent().scrollIntoView((Component)this);
        }
        this.pendingNavigationFocus = false;
        this.getDelegate().onFieldObjectClick();
    }

    private void onTabPress(boolean bl, String string) {
        this.getDelegate().onTabPress(bl, string);
    }

    @Override
    public void onTextChange(String string, boolean bl) {
        this.getDelegate().onTextChange(string, bl);
    }

    private void onEnterPress(boolean bl, String string) {
        this.getDelegate().onEnterPress(bl, string);
    }

    private void onBrowserResize(int n, int n2, String string) {
        this.getDelegate().onBrowserResize(n, n2, string);
    }

    @Override
    protected boolean selectByFieldValue() {
        return true;
    }

    @Override
    public void setTextValue(String string) {
        ComboBoxItem comboBoxItem = this.itemProvider.getItemFromStoredValue(string);
        super.setValue((Object)comboBoxItem);
    }

    @Override
    public String getTextValue() {
        ComboBoxItem comboBoxItem = (ComboBoxItem)super.getValue();
        return comboBoxItem == null ? "" : comboBoxItem.getFieldValue();
    }

    @Override
    public void setHideZeroesOn(boolean bl) {
        if (this.getMetaData().getFieldDataType() == LayoutFieldDataType.NUMBER) {
            this.updateBooleanState(DropDownState.BooleanState.hideZeroesOn, bl);
        }
    }

    @Override
    public void performModify() {
        ((FMClientRpc)this.getRpcProxy(FMClientRpc.class)).performModify();
    }

    public void checkNavigationFocus() {
        if (this.delegate != null && BrowserInfoHandler.isiOSDevice(this.delegate.getApp()) && !this.delegate.isActive() && this.pendingNavigationFocus) {
            ((FMClientRpc)this.getRpcProxy(FMClientRpc.class)).performNavigationFocus();
        }
    }

    @Override
    public void setTextValue(String string, Boolean bl) {
    }

    @Override
    public void showContextMenu(int n, int n2) {
        App app = this.delegate.getApp();
        app.positionContextMenu(n, n2, this);
        app.showContextMenu(this);
    }

    @Override
    public void cacheSelectionOnCommit() {
        this.getDelegate().cacheSelectionOnCommit();
    }

    @Override
    public void syncSelectionOnCommitFailure() {
        this.getDelegate().syncSelectionOnCommitFailure();
    }

    @Override
    public void registerAccTitle(String string) {
        this.setCaption(string);
        this.addStyleName("sr-only-caption-title-and-help");
    }

    @Override
    public void registerAccHelp(String string) {
    }

    @Override
    public void registerAccLabel(String string) {
    }
}

