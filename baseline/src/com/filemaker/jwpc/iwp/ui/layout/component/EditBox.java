/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.ui.ContentMode
 *  com.vaadin.ui.Component
 *  com.vaadin.v7.data.Property$ReadOnlyException
 */
package com.filemaker.jwpc.iwp.ui.layout.component;

import com.filemaker.fields.FMTextArea;
import com.filemaker.fields.client.common.FMClientRpc;
import com.filemaker.fields.client.common.FocusMode;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.metadata.ObjectMetaData;
import com.filemaker.jwpc.iwp.notification.processor.BrowserInfoHandler;
import com.filemaker.jwpc.iwp.thrift.common.DBAccessLevel;
import com.filemaker.jwpc.iwp.thrift.common.LayoutFieldDataType;
import com.filemaker.jwpc.iwp.thrift.common.LayoutFieldType;
import com.filemaker.jwpc.iwp.ui.event.UIEvent;
import com.filemaker.jwpc.iwp.ui.layout.LayoutContainerObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutFieldObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutTextFieldObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutView;
import com.filemaker.jwpc.iwp.ui.layout.ObjectAttributes;
import com.filemaker.jwpc.iwp.ui.layout.component.AbsoluteCssLayout;
import com.filemaker.jwpc.iwp.ui.layout.component.LayoutTextFieldObjectDelegate;
import com.filemaker.jwpc.iwp.ui.layout.component.StringDataUpdateParameters;
import com.filemaker.jwpc.iwp.ui.layout.component.portal.PortalRowProperty;
import com.filemaker.jwpc.iwp.ui.layout.component.repetition.RepetitionContainer;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.EditBoxServerRpc;
import com.filemaker.jwpc.iwp.widgetset.client.state.EditBoxState;
import com.filemaker.jwpc.util.Utilities;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Component;
import com.vaadin.v7.data.Property;
import java.awt.FontMetrics;
import java.util.ArrayList;
import java.util.Collection;

public class EditBox
extends FMTextArea
implements LayoutTextFieldObject {
    private LayoutTextFieldObjectDelegate delegate;
    private LayoutObject parent;
    private FontMetrics fontMetrics;
    private boolean hideConditionOn = false;
    private boolean pendingNavigationFocus;
    private PortalRowProperty parentPortalRow = null;
    private boolean isIOS = false;

    public EditBox(App app, LayoutView layoutView, ObjectMetaData objectMetaData, ObjectAttributes objectAttributes) {
        this.delegate = new LayoutTextFieldObjectDelegate(app, layoutView, this, objectMetaData, objectAttributes);
        this.delegate.setWidthAndHeight(this);
        this.registerServerRpc();
        this.initUI();
        this.delegate.initialized = true;
        this.isIOS = BrowserInfoHandler.isiOSDevice(app);
    }

    private void initUI() {
        ObjectMetaData objectMetaData;
        super.setTabIndex(-1);
        this.delegate.init(this);
        this.setImmediate(true);
        this.setWordwrap(this.delegate.useWordwrap());
        this.setNewLineAllowed(this.delegate.allowNewLine());
        this.setSelectContentsOnEdit(this.getMetaData().isSelectAllOnEntry());
        this.showScrollbarsOnTextOverflow(this.getMetaData().hasScrollbar());
        boolean bl = this.getMetaData().hasValidAndExecutableScript();
        if (bl || this.delegate.waitForServerOnEnter()) {
            this.setFocusMode(FocusMode.DEFERRED);
            if (bl && BrowserInfoHandler.isTouchDevice(this.delegate.getApp())) {
                this.setReadOnly(true);
            }
        } else {
            this.setFocusMode(FocusMode.INSTANT);
        }
        if ((objectMetaData = this.getMetaData()).checkIfDataMaskNeeded()) {
            this.fontMetrics = IWPUtilities.getFontMetrcs(objectMetaData.getFontName(), objectMetaData.IsFontBold(), objectMetaData.IsFontItalic(), objectMetaData.getFontSize());
        }
        this.updateKeyboardType(objectMetaData.getTouchKeyboardType());
    }

    public void attach() {
        super.attach();
        if (this.isIOS) {
            for (LayoutObject layoutObject = this.getParentComponent(); layoutObject != null; layoutObject = layoutObject.getParentComponent()) {
                if (!(layoutObject instanceof PortalRowProperty)) continue;
                this.parentPortalRow = (PortalRowProperty)layoutObject;
                break;
            }
        }
    }

    public void detach() {
        if (this.delegate != null && this.delegate.currentText != null) {
            this.setValue(this.delegate.currentText);
        }
        super.detach();
    }

    @Override
    public void cleanupMemory() {
        if (this.delegate != null && !this.delegate.isActiveAndInPopover()) {
            this.delegate.cleanupMemory();
            this.delegate = null;
        }
    }

    @Override
    public Component getWrappedObject() {
        Component component = this.delegate.getWrappedObject();
        if (component == null) {
            component = this;
        }
        return component;
    }

    protected void registerServerRpc() {
        EditBoxServerRpc editBoxServerRpc = new EditBoxServerRpc(){

            @Override
            public void onTabPress(boolean bl, String string) {
                EditBox.this.onTabPress(bl, string);
            }

            @Override
            public void onTextChange(String string, boolean bl) {
                EditBox.this.onTextChange(string, bl);
            }

            @Override
            public void enterField() {
                EditBox.this.onFieldObjectClick();
            }

            @Override
            public void printthis(String string) {
                System.out.println("[CLIENT DEBUG - " + EditBox.this.getUniqueId() + " ] " + string);
            }

            @Override
            public void onEnterPress(boolean bl, String string) {
                EditBox.this.onEnterPress(bl, string);
            }

            @Override
            public void onBrowserResize(int n, int n2, String string) {
                EditBox.this.onBrowserResize(n, n2, string);
            }

            @Override
            public void checkNavigationFocus() {
                EditBox.this.checkNavigationFocus();
            }

            @Override
            public void setPendingNavigationFocus() {
                EditBox.this.pendingNavigationFocus = true;
            }

            @Override
            public void resyncData() {
                ((FMClientRpc)EditBox.this.getRpcProxy(FMClientRpc.class)).resyncServerValue((String)EditBox.this.getFieldData());
            }

            @Override
            public void onKeystroke(String string, int n, boolean bl) {
                EditBox.this.onKeystroke(string, n, bl);
            }

            @Override
            public void onShowContextMenu(int n, int n2, int n3) {
                EditBox.this.onFieldObjectClick();
                EditBox.this.updatedFieldContextMenuState(n3);
                EditBox.this.showContextMenu(n, n2);
            }
        };
        this.registerRpc(editBoxServerRpc);
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

    protected void onTabPress(boolean bl, String string) {
        this.delegate.onTabPress(bl, string);
    }

    @Override
    public void onTextChange(String string, boolean bl) {
        this.delegate.onTextChange(string, bl);
    }

    protected void onEnterPress(boolean bl, String string) {
        this.delegate.onEnterPress(bl, string);
    }

    protected void onKeystroke(String string, int n, boolean bl) {
        this.delegate.onKeystroke(string, n, bl);
    }

    protected void onBrowserResize(int n, int n2, String string) {
        this.delegate.onBrowserResize(n, n2, string);
    }

    public void reset() {
        this.delegate.reset();
    }

    @Override
    public DBAccessLevel getAccess() {
        return this.delegate.getAccess();
    }

    public boolean hasDataEntryHandler() {
        return this.delegate.hasDataEntryHandler();
    }

    @Override
    public EditBoxState getState() {
        return (EditBoxState)super.getState();
    }

    @Override
    public void beforeClientResponse(boolean bl) {
        super.beforeClientResponse(bl);
        this.updateBooleanState(EditBoxState.BooleanState.hasScript, this.getMetaData().hasValidAndExecutableScript());
        this.updateBooleanState(EditBoxState.BooleanState.hasModifyTrigger, this.getMetaData().hasModifyTrigger());
        this.updateBooleanState(EditBoxState.BooleanState.waitForServerOnEnter, this.delegate.waitForServerOnEnter());
        this.updateBooleanState(EditBoxState.BooleanState.waitForServerOnExit, this.waitForServerOnExit());
        this.updateBooleanState(EditBoxState.BooleanState.hasTooltip, this.getDescription() != null && this.getDescription().length() > 0);
        this.updateBooleanState(EditBoxState.BooleanState.exitOnTAB, this.getMetaData().getExitOnTAB());
        this.updateBooleanState(EditBoxState.BooleanState.exitOnRETURN, this.getMetaData().getExitOnRETURN());
        this.updateBooleanState(EditBoxState.BooleanState.exitOnENTER, this.getMetaData().getExitOnENTER());
        this.updateBooleanState(EditBoxState.BooleanState.isNumberField, this.getMetaData().getFieldDataType() == LayoutFieldDataType.NUMBER);
        this.updateBooleanState(EditBoxState.BooleanState.isCalcOrSummary, this.getMetaData().getFieldType() == LayoutFieldType.CALCULATED || this.getMetaData().getFieldType() == LayoutFieldType.SUMMARY);
        this.updateBooleanState(EditBoxState.BooleanState.isTextyField, this.getMetaData().isTextyField());
        this.updateBooleanState(EditBoxState.BooleanState.hasObjectKeyTrigger, this.getMetaData().hasKeyTrigger());
        this.updateBooleanState(EditBoxState.BooleanState.isKeyStrokeEnabled, this.delegate.isKeyStrokeEnabled());
        this.updateBooleanState(EditBoxState.BooleanState.hasLayoutKeyTrigger, this.delegate.hasLayoutKeyStroke());
        if (this.isIOS && !this.delegate.waitForServerOnEnter()) {
            this.getState().tabIndex = this.getMetaData().getTabOrder(this.getAttributes().getRepetition());
        }
        this.getState().hasPortalFocus = this.delegate.getApp().getActiveUIHandler().isActiveObject(this) && this.delegate.getAttributes().getOwningPortal() != null;
    }

    private void updateBooleanState(EditBoxState.BooleanState booleanState, boolean bl) {
        this.getState().ebbs = IWPUtilities.applyBooleanValue(this.getState().ebbs, booleanState.ordinal(), bl);
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
        this.delegate.updateDataEntry(dBAccessLevel, bl);
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
    public void setValue(String string) throws Property.ReadOnlyException {
        boolean bl;
        String string2 = string;
        if (this.isMaskNeeded(string)) {
            string2 = "?";
        }
        if (bl = this.isReadOnly()) {
            this.setReadOnly(false);
        }
        if (this.delegate == null) {
            super.setValue(string2);
        } else {
            this.delegate.currentText = null;
            if (this.delegate.initialized && this.delegate.needToUpdateValue(string2)) {
                super.setValue((Object)string2, false);
            } else {
                super.setValue((Object)string2, true);
            }
        }
        if (bl) {
            this.setReadOnly(true);
        }
    }

    protected void setValue(String string, boolean bl) {
        if (this.delegate != null) {
            this.delegate.currentText = null;
        }
        super.setValue((Object)string, bl);
    }

    @Override
    public Object getFieldData() {
        return this.delegate.currentText != null ? this.delegate.currentText : this.getValue();
    }

    @Override
    public void updateLayoutObjectData(Object object, boolean bl) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateFieldObjectData(StringDataUpdateParameters stringDataUpdateParameters, boolean bl) {
        this.delegate.updateFieldObjectData(stringDataUpdateParameters, bl);
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
        this.delegate.insertData(string);
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
    public void onActive() {
        if (this.delegate.getApp().getActiveUIHandler().shouldNotifyClientOfActiveState()) {
            this.startEdit();
        }
    }

    @Override
    public void onInactive() {
        if (this.isMaskNeeded(this.getTextValue())) {
            this.setTextValue("?");
        }
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
        this.pendingNavigationFocus = false;
        this.delegate.onFieldObjectClick();
    }

    private boolean waitForServerOnExit() {
        return !this.delegate.allowClientSideTabbing() || this.getMetaData().hasModifyTrigger() || this.getMetaData().hasExitTriggers() || this.getMetaData().hasValidation() || this.getMetaData().hasDataFormatting() || this.getMetaData().hasKeyTrigger();
    }

    public void setTabIndex(int n) {
        super.setTabIndex(-1);
    }

    @Override
    public void setPlaceholderText(String string) {
        this.setInputPrompt(string);
    }

    @Override
    public void setTextValue(String string) {
        if (string.equals(this.getTextValue()) && this.delegate.currentText != null && !string.equals(this.delegate.currentText)) {
            this.setValue(this.delegate.currentText);
            this.delegate.app.pushChanges();
        }
        this.setValue(string);
    }

    @Override
    public void setTextValue(String string, Boolean bl) {
        this.setValue(string);
        this.delegate.app.pushChanges();
    }

    @Override
    public String getTextValue() {
        return (String)super.getValue();
    }

    @Override
    public void setHideZeroesOn(boolean bl) {
        if (this.getMetaData().getFieldDataType() == LayoutFieldDataType.NUMBER) {
            this.updateBooleanState(EditBoxState.BooleanState.hideZeroesOn, bl);
        }
    }

    @Override
    public void performModify() {
        ((FMClientRpc)this.getRpcProxy(FMClientRpc.class)).performModify();
    }

    public void checkNavigationFocus() {
        if (this.delegate != null && this.isIOS && !this.delegate.isActive() && this.pendingNavigationFocus) {
            ((FMClientRpc)this.getRpcProxy(FMClientRpc.class)).performNavigationFocus();
        }
    }

    private boolean isMaskNeeded(String string) {
        boolean bl = false;
        if (!Utilities.isEmptyString(string) && this.fontMetrics != null && this.delegate != null && !this.delegate.isActive()) {
            ObjectMetaData objectMetaData = this.getMetaData();
            Integer n = this.fontMetrics.stringWidth(string);
            Integer n2 = this.fontMetrics.charWidth(string.charAt(0));
            double d = (n.doubleValue() + 2.0 * n2.doubleValue()) * 0.75;
            if ((double)objectMetaData.getContentRectWidthAsInt() < d) {
                double d2 = Integer.valueOf(this.fontMetrics.getHeight()).doubleValue() * 1.75;
                double d3 = Integer.valueOf(objectMetaData.getContentRectHeightAsInt()).doubleValue();
                if (d3 < d2) {
                    bl = true;
                }
            }
        }
        return bl;
    }

    @Override
    public boolean hasDelegate() {
        return this.delegate != null;
    }

    @Override
    public void cacheSelectionOnCommit() {
        this.delegate.cacheSelectionOnCommit();
    }

    @Override
    public void syncSelectionOnCommitFailure() {
        this.delegate.syncSelectionOnCommitFailure();
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

