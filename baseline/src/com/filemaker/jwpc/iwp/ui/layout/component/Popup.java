/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.ui.ContentMode
 *  com.vaadin.ui.Component
 *  com.vaadin.ui.UI
 */
package com.filemaker.jwpc.iwp.ui.layout.component;

import com.filemaker.fields.FMComboBox;
import com.filemaker.fields.client.combobox.ComboBoxItem;
import com.filemaker.fields.client.common.FocusMode;
import com.filemaker.jwpc.iwp.action.ActionResultGetterHandler;
import com.filemaker.jwpc.iwp.action.GlobalUIActionHandlers;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.metadata.ObjectMetaData;
import com.filemaker.jwpc.iwp.thrift.common.DBAccessLevel;
import com.filemaker.jwpc.iwp.thrift.common.FilteredValueListData;
import com.filemaker.jwpc.iwp.thrift.common.FilteredValueListSubsetRequest;
import com.filemaker.jwpc.iwp.thrift.common.LayoutFieldType;
import com.filemaker.jwpc.iwp.thrift.common.LayoutObjectType;
import com.filemaker.jwpc.iwp.thrift.common.StringData;
import com.filemaker.jwpc.iwp.thrift.common.ValueListEntry;
import com.filemaker.jwpc.iwp.thrift.common.ValueListItemRequest;
import com.filemaker.jwpc.iwp.thrift.common.ValueListType;
import com.filemaker.jwpc.iwp.ui.event.UIEvent;
import com.filemaker.jwpc.iwp.ui.layout.LayoutContainerObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutFieldObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutView;
import com.filemaker.jwpc.iwp.ui.layout.ObjectAttributes;
import com.filemaker.jwpc.iwp.ui.layout.component.AbsoluteCssLayout;
import com.filemaker.jwpc.iwp.ui.layout.component.LayoutFieldObjectDelegate;
import com.filemaker.jwpc.iwp.ui.layout.component.PopupComboBoxItemProvider;
import com.filemaker.jwpc.iwp.ui.layout.component.StringDataUpdateParameters;
import com.filemaker.jwpc.iwp.ui.layout.component.repetition.RepetitionContainer;
import com.filemaker.jwpc.iwp.ui.layout.list.LayoutListView;
import com.filemaker.jwpc.iwp.ui.layout.listener.PopupListener;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.filemaker.jwpc.iwp.util.LayoutObjectUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.PopupClientRpc;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.PopupServerRpc;
import com.filemaker.jwpc.iwp.widgetset.client.state.PopupState;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Component;
import com.vaadin.ui.UI;
import java.util.ArrayList;
import java.util.Collection;

public class Popup
extends FMComboBox
implements LayoutFieldObject {
    protected LayoutObjectType type;
    protected LayoutFieldObjectDelegate delegate;
    private LayoutObject parent;
    private PopupListener listener;
    protected PopupComboBoxItemProvider itemProvider;
    protected ComboBoxItem cachedSelectedItem;
    private boolean hasAccess = false;
    private DBAccessLevel access = DBAccessLevel.UnknownAccess;
    private boolean hideConditionOn = false;
    protected boolean isActive = false;

    public Popup(App app, LayoutView layoutView, ObjectMetaData objectMetaData, ObjectAttributes objectAttributes) {
        this.initDelegate(app, layoutView, objectMetaData, objectAttributes);
        this.type = LayoutObjectType.POP_UP;
        this.listener = new PopupListener(this.delegate.getApp(), this);
        this.addSelectionChangeListener(this.listener);
        this.itemProvider = new PopupComboBoxItemProvider();
        this.delegate.setWidthAndHeight(this);
        this.registerPopupRpc();
        this.initUI();
        this.delegate.getApp().initContextMenu(true);
    }

    protected void initDelegate(App app, LayoutView layoutView, ObjectMetaData objectMetaData, ObjectAttributes objectAttributes) {
        this.delegate = new LayoutFieldObjectDelegate(app, layoutView, this, objectMetaData, objectAttributes);
    }

    protected void initUI() {
        super.setTabIndex(-1);
        this.delegate.init(this);
        this.setImmediate(true);
        this.setFocusMode(FocusMode.DEFERRED);
        this.setWordwrap(this.delegate.useWordwrap());
        this.setItemProvider(this.itemProvider);
        this.setNewLineAllowed(this.delegate.allowNewLine());
        this.setSelectContentsOnEdit(this.getMetaData().isSelectAllOnEntry());
        this.setArrowVisible(this.getMetaData().hasIcon());
        this.setClientSideAutoSizing(this.delegate.view.isClientSideAutoSizing());
        this.showScrollbarsOnTextOverflow(false);
        if (this.getMetaData().hasIcon()) {
            this.addStyleName("iwps_icon");
        }
        this.updateKeyboardType(this.delegate.getMetaData().getTouchKeyboardType());
    }

    @Override
    public void cleanupMemory() {
        if (this.delegate != null && !this.delegate.isActiveAndInPopover()) {
            this.delegate.cleanupMemory();
            this.delegate = null;
        }
    }

    public void handleGetFilteredValueListSubsetNotification(FilteredValueListData filteredValueListData, int n, int n2, String string, boolean bl) {
        this.showOptions(filteredValueListData, string, n, n2, bl);
    }

    public void handleGetValueListItemByValueNotification(FilteredValueListData filteredValueListData) {
        this.querySelectedItem(filteredValueListData);
    }

    @Override
    public Component getWrappedObject() {
        return this.delegate.getWrappedObject();
    }

    private void registerPopupRpc() {
        PopupServerRpc popupServerRpc = new PopupServerRpc(){

            @Override
            public void enterField() {
                Popup.this.onFieldObjectClick();
            }

            @Override
            public void deleteKeyPressed(String string) {
                GlobalUIActionHandlers.ClearAction clearAction = GlobalUIActionHandlers.CLEAR_FIELD_CONTENTS;
                clearAction.perform(Popup.this.delegate.getApp(), null);
            }

            @Override
            public void onTabPress(boolean bl) {
                Popup.this.onTabPress(bl);
            }

            @Override
            public void onEnterPress(boolean bl) {
                Popup.this.onEnterPress(bl);
            }

            @Override
            public void onShowContextMenu(int n, int n2, int n3) {
                Popup.this.onFieldObjectClick();
                Popup.this.updatedFieldContextMenuState(n3);
                Popup.this.showContextMenu(n, n2);
            }

            @Override
            public void insertData(String string) {
                Popup.this.insertData(string);
            }
        };
        this.registerRpc(popupServerRpc);
    }

    protected void updatedFieldContextMenuState(int n) {
        App app = this.delegate.getApp();
        app.getAppView().updatedFieldContextMenuState(this, n);
    }

    @Override
    public void showContextMenu(int n, int n2) {
        App app = this.delegate.getApp();
        app.positionContextMenu(n, n2, this);
        app.showContextMenu(this);
    }

    private void onTabPress(boolean bl) {
        App app = this.delegate.getApp();
        app.getActiveUIHandler().setPendingTabbing(true);
        if (bl) {
            GlobalUIActionHandlers.GOTO_NEXT_FIELD.perform(app, null);
        } else {
            GlobalUIActionHandlers.GOTO_PREV_FIELD.perform(app, null);
        }
    }

    private void onEnterPress(boolean bl) {
        this.delegate.getApp().onEnterPressed(bl);
    }

    @Override
    protected void handleOptions(final String string, final int n, final int n2, final boolean bl) {
        FilteredValueListSubsetRequest filteredValueListSubsetRequest = new FilteredValueListSubsetRequest(this.getAttributes().getObjectSpec(), n, n2, string, bl);
        if (this.delegate.getApp().isListView()) {
            ((LayoutListView)this.delegate.getApp().getLayoutContainer().getCurrentView()).getFilteredValueListSubset(filteredValueListSubsetRequest);
        } else {
            this.delegate.getApp().getAppSession().getFilteredValueListSubset(new ActionResultGetterHandler(){
                final /* synthetic */ Popup this$0;
                {
                    this.this$0 = popup;
                }

                @Override
                public void onFinish(Object object) {
                    this.this$0.handleGetFilteredValueListSubsetNotification((FilteredValueListData)object, n, n2, string, bl);
                }
            }, filteredValueListSubsetRequest);
        }
    }

    @Override
    protected void showOptions(Object object, String string, int n, int n2, boolean bl) {
        if (this.delegate.getApp().getActiveUIHandler().isActiveObject(this)) {
            FilteredValueListData filteredValueListData = (FilteredValueListData)object;
            this.itemProvider.setValueCount(filteredValueListData.getTotalNumberOfItems());
            this.itemProvider.addOriginalValues(filteredValueListData.getValueList());
            this.itemProvider.setPageIndexOverride(filteredValueListData.getPageIndexOverride());
            super.showOptions(object, string, n, n2, bl);
        }
    }

    @Override
    public void onActive() {
        this.isActive = true;
        this.startEdit();
        ((PopupClientRpc)this.getRpcProxy(PopupClientRpc.class)).setActive(true);
    }

    @Override
    public void onInactive() {
        this.isActive = false;
        this.stopEdit();
        ((PopupClientRpc)this.getRpcProxy(PopupClientRpc.class)).setActive(false);
    }

    public void beforeClientResponse(boolean bl) {
        super.beforeClientResponse(bl);
        this.updateBooleanState(PopupState.BooleanState.hasScript, this.getMetaData().hasValidAndExecutableScript());
        this.updateBooleanState(PopupState.BooleanState.hasTooltip, this.getDescription() != null && this.getDescription().length() > 0);
        this.updateBooleanState(PopupState.BooleanState.exitOnTAB, this.getMetaData().getExitOnTAB());
        this.updateBooleanState(PopupState.BooleanState.exitOnRETURN, this.getMetaData().getExitOnRETURN());
        this.updateBooleanState(PopupState.BooleanState.exitOnENTER, this.getMetaData().getExitOnENTER());
        this.updateBooleanState(PopupState.BooleanState.dontOverrideFormattingWithValueList, this.getMetaData().dontOverrideFormattingWithValueList());
    }

    private void updateBooleanState(PopupState.BooleanState booleanState, boolean bl) {
        this.getState().pobs = IWPUtilities.applyBooleanValue(this.getState().pobs, booleanState.ordinal(), bl);
    }

    @Override
    protected void setSelectedItem() {
        ComboBoxItem comboBoxItem = (ComboBoxItem)this.getValue();
        boolean bl = false;
        if (!(comboBoxItem == null || comboBoxItem.getFieldValue().length() <= 0 || this.cachedSelectedItem != null && this.cachedSelectedItem.getFieldValue().equals(comboBoxItem.getFieldValue()))) {
            bl = true;
        }
        if (bl) {
            ValueListItemRequest valueListItemRequest = new ValueListItemRequest(this.getAttributes().getObjectSpec(), comboBoxItem.getFieldValue());
            if (this.delegate.getApp().isListView()) {
                ((LayoutListView)this.delegate.getApp().getLayoutContainer().getCurrentView()).getValueListItemByValue(valueListItemRequest);
            } else {
                this.delegate.getApp().getAppSession().getValueListItemByValue(new ActionResultGetterHandler(){

                    @Override
                    public void onFinish(Object object) {
                        Popup.this.handleGetValueListItemByValueNotification((FilteredValueListData)object);
                    }
                }, valueListItemRequest);
            }
        } else {
            this.handleSelectedItem();
        }
    }

    private void handleSelectedItem() {
        ComboBoxItem comboBoxItem = (ComboBoxItem)this.getValue();
        this.getState().selectedItem = comboBoxItem != null && comboBoxItem.getFieldValue().length() > 0 ? (this.cachedSelectedItem != null ? this.cachedSelectedItem : comboBoxItem) : comboBoxItem;
    }

    private void querySelectedItem(ComboBoxItem comboBoxItem) {
        this.cachedSelectedItem = comboBoxItem;
        this.handleSelectedItem();
    }

    private void querySelectedItem(FilteredValueListData filteredValueListData) {
        this.cachedSelectedItem = null;
        if (filteredValueListData != null && filteredValueListData.getValueList().getValuesSize() > 0) {
            ValueListType valueListType = filteredValueListData.getValueList().getDisplayType();
            String string = filteredValueListData.getValueList().getSeparator();
            ValueListEntry valueListEntry = filteredValueListData.getValueList().getValues().get(0);
            String string2 = valueListEntry.getStored();
            String string3 = valueListEntry.getDisplayed();
            if (string2 != null && !string2.equals("-")) {
                ComboBoxItem comboBoxItem;
                String string4;
                this.cachedSelectedItem = comboBoxItem = new ComboBoxItem(null, string4, switch (valueListType) {
                    case ValueListType.SECONDONLY -> {
                        string4 = string2;
                        yield string3;
                    }
                    case ValueListType.FIRSTONLY -> {
                        string4 = string2;
                        yield string2;
                    }
                    default -> {
                        string4 = string2;
                        yield string2 + string + string3;
                    }
                });
            }
        }
        this.handleSelectedItem();
    }

    protected void reset() {
        if (this.itemProvider != null) {
            this.itemProvider.reset();
        }
    }

    @Override
    public DBAccessLevel getAccess() {
        return this.access;
    }

    @Override
    public void setGlassPaneParent(AbsoluteCssLayout absoluteCssLayout) {
        this.delegate.setGlassPaneParent(absoluteCssLayout);
    }

    @Override
    public boolean allowGlassPaneActivation() {
        return this.delegate.allowGlassPaneActivation();
    }

    @Override
    public void updateDataEntry(DBAccessLevel dBAccessLevel, boolean bl) {
        this.access = dBAccessLevel;
        if (this.delegate.hasDataEntryHandler()) {
            boolean bl2 = this.hasAccess;
            this.hasAccess = LayoutObjectUtilities.allowDataEntry(this.delegate.getApp(), this, dBAccessLevel);
            if (bl || bl2 != this.hasAccess) {
                if (this.hasAccess) {
                    this.enableAccess();
                } else {
                    this.disableAccess();
                }
            }
        }
    }

    @Override
    public int getObjectId() {
        return this.getMetaData().getObjectId();
    }

    @Override
    public String getUniqueId() {
        return this.getId();
    }

    @Override
    public void updateUniqueId() {
        String string = this.getUniqueId();
        String string2 = IWPUtilities.generateUniqueId(this.delegate.getApp(), this);
        if (!string2.equals(string)) {
            this.setId(string2);
            this.delegate.resetNegativeNumberAttributes();
        }
    }

    @Override
    public ObjectAttributes getAttributes() {
        return this.delegate.getAttributes();
    }

    @Override
    public ObjectMetaData getMetaData() {
        return this.delegate != null ? this.delegate.getMetaData() : null;
    }

    @Override
    public void setParentComponent(LayoutContainerObject layoutContainerObject) {
        this.parent = layoutContainerObject;
    }

    @Override
    public LayoutObject getParentComponent() {
        return this.parent;
    }

    @Override
    public PopupState getState() {
        return (PopupState)super.getState();
    }

    @Override
    public synchronized void updateLayoutObjectData(Object object, boolean bl) {
        throw new UnsupportedOperationException();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public synchronized void updateFieldObjectData(StringDataUpdateParameters stringDataUpdateParameters, boolean bl) {
        if (!stringDataUpdateParameters.hasError()) {
            if (stringDataUpdateParameters.needsFormatting() && this.getMetaData().hasDataFormatting()) {
                LayoutObjectUtilities.updateFieldObjectData(this.delegate.getApp(), this);
            } else {
                this.updateDataEntry(stringDataUpdateParameters.getAccess(), false);
                if (this.delegate.isNegativeNumber() != stringDataUpdateParameters.getData().isNegativeNumber()) {
                    this.delegate.setNegativeNumber(this.getWrappedObject(), stringDataUpdateParameters.getData().isNegativeNumber());
                }
                PopupComboBoxItemProvider popupComboBoxItemProvider = this.itemProvider;
                synchronized (popupComboBoxItemProvider) {
                    Object object = stringDataUpdateParameters.getData().getValue().replaceAll("\r", "\n");
                    object = (String)object + "\n";
                    ComboBoxItem comboBoxItem = this.selectByFieldValue() ? this.itemProvider.getItemFromStoredValue((String)object) : this.itemProvider.getItemFromDisplayedValue((String)object);
                    this.updateData(comboBoxItem);
                    this.setSelectedItem();
                }
                if (!stringDataUpdateParameters.disableListeners()) {
                    GlobalUIActionHandlers.MODIFY_FIELD_TEXT.perform(this.delegate.getApp(), new Object[]{this, this.getFieldData().toString(), false});
                }
            }
        } else {
            PopupComboBoxItemProvider popupComboBoxItemProvider = this.itemProvider;
            synchronized (popupComboBoxItemProvider) {
                this.disableAccess();
                this.access = DBAccessLevel.NoAccess;
                this.setReadOnly(false);
                this.setEnabled(true);
                this.delegate.setNegativeNumber(this.getWrappedObject(), false);
                ComboBoxItem comboBoxItem = this.itemProvider.getErrorItem(stringDataUpdateParameters.getErrorMessage());
                this.setValue(comboBoxItem);
                this.querySelectedItem(comboBoxItem);
                this.setEnabled(false);
            }
        }
    }

    private void updateData(ComboBoxItem comboBoxItem) {
        boolean bl = this.isReadOnly();
        boolean bl2 = this.isEnabled();
        this.setReadOnly(false);
        this.setEnabled(true);
        this.setValue(comboBoxItem);
        this.setReadOnly(bl);
        this.setEnabled(bl2);
    }

    private void disableAccess() {
        this.hasAccess = false;
        this.access = DBAccessLevel.ReadOnly;
        this.setReadOnly(true);
        this.delegate.updateTabIndex(-1);
        this.delegate.activateGlassPane();
    }

    private void enableAccess() {
        this.hasAccess = true;
        this.access = DBAccessLevel.ReadWrite;
        this.setEnabled(true);
        this.setReadOnly(false);
        if (this.getMetaData().getFieldType() == LayoutFieldType.NORMAL) {
            this.delegate.updateTabIndex(this.getMetaData().getTabOrder(this.getAttributes().getRepetition()));
        } else {
            this.delegate.updateTabIndex(-1);
        }
        if (this.getMetaData().hasValidAndExecutableScript()) {
            this.delegate.activateGlassPane();
        } else {
            this.delegate.deactivateGlassPane();
        }
    }

    @Override
    public Object getFieldData() {
        return this.getValue() == null ? "" : ((ComboBoxItem)this.getValue()).getFieldValue();
    }

    @Override
    public void addRepetitionObject(RepetitionContainer repetitionContainer, String string) {
        this.delegate.getWrappedObject().addStyleName(string);
        this.delegate.setRepetition(repetitionContainer);
    }

    @Override
    public LayoutFieldObject getRepetitionObject(short s) {
        if (this.getMetaData().getRepetitionCount() == 1) {
            return this;
        }
        return this.delegate.getRepetition().getRepetitionObjects().get(s);
    }

    @Override
    public Collection<LayoutFieldObject> getAllRepetitionObjects() {
        if (this.getMetaData().getRepetitionCount() == 1) {
            ArrayList<LayoutFieldObject> arrayList = new ArrayList<LayoutFieldObject>();
            arrayList.add(this);
            return arrayList;
        }
        return this.delegate.getRepetition().getRepetitionObjects().values();
    }

    @Override
    public void onEvent(UIEvent uIEvent) {
        switch (uIEvent.getType()) {
            case RESET_FIELD_OBJECT: {
                if (!this.delegate.getApp().isFormView()) break;
                this.reset();
                break;
            }
        }
    }

    @Override
    public void registerToolTip(String string) {
        this.setDescription(string, ContentMode.HTML);
    }

    @Override
    public void insertData(String string) {
        StringDataUpdateParameters stringDataUpdateParameters = new StringDataUpdateParameters(new StringData(string, this.delegate.isNegativeNumber(), null, false), this.access, false, false, "", false, false, 0, 0, false);
        this.updateFieldObjectData(stringDataUpdateParameters, false);
    }

    @Override
    public boolean hasHideCondition() {
        return this.getMetaData().hasHideCondition();
    }

    @Override
    public boolean hasHideConditionInFindMode() {
        return this.getMetaData().hasHideConditionInFindMode();
    }

    @Override
    public boolean isHideConditionOn() {
        return this.hideConditionOn;
    }

    @Override
    public void setHideConditionOn(boolean bl) {
        this.hideConditionOn = bl;
    }

    @Override
    public void addCFStyle(String string) {
        this.delegate.addCFStyle(string);
    }

    @Override
    public void removeCFStyle(String string) {
        this.delegate.removeCFStyle(string);
    }

    @Override
    public void onFieldObjectClick() {
        if (this.delegate.getApp().isTouchUI() && this.delegate.getApp().isFormView() && UI.getCurrent() != null) {
            UI.getCurrent().scrollIntoView((Component)this);
        }
        this.listener.onFieldObjectClick(this.delegate.waitForServerOnEnter());
    }

    public String toString() {
        return String.format("[isActive=%s, hasAccess=%s]", this.isActive, this.hasAccess);
    }

    public void setTabIndex(int n) {
        super.setTabIndex(-1);
    }

    @Override
    public void setPlaceholderText(String string) {
        this.setInputPrompt(string);
    }

    public boolean changeFieldOnValueSelection() {
        return false;
    }

    protected boolean selectByFieldValue() {
        return this.getMetaData().dontOverrideFormattingWithValueList();
    }

    private void setClientSideAutoSizing(boolean bl) {
        this.updateBooleanState(PopupState.BooleanState.CLIENT_SIDE_AUTO_SIZING, bl);
    }

    @Override
    public boolean hasDelegate() {
        return this.delegate != null;
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

