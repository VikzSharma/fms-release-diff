/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.ui.ContentMode
 *  com.vaadin.ui.AbstractComponent
 *  com.vaadin.ui.Component
 *  com.vaadin.v7.data.Container
 */
package com.filemaker.jwpc.iwp.ui.layout.component;

import com.filemaker.jwpc.iwp.action.ActionResultGetterHandler;
import com.filemaker.jwpc.iwp.action.GlobalUIActionHandlers;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.metadata.ObjectMetaData;
import com.filemaker.jwpc.iwp.thrift.common.DBAccessLevel;
import com.filemaker.jwpc.iwp.thrift.common.LayoutFieldType;
import com.filemaker.jwpc.iwp.thrift.common.StringData;
import com.filemaker.jwpc.iwp.thrift.common.ValueListData;
import com.filemaker.jwpc.iwp.thrift.common.ValueListSubsetRequest;
import com.filemaker.jwpc.iwp.ui.common.NavigableOptionGroup;
import com.filemaker.jwpc.iwp.ui.event.EventType;
import com.filemaker.jwpc.iwp.ui.event.UIEvent;
import com.filemaker.jwpc.iwp.ui.layout.LayoutContainerObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutFieldObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutView;
import com.filemaker.jwpc.iwp.ui.layout.ObjectAttributes;
import com.filemaker.jwpc.iwp.ui.layout.component.AbsoluteCssLayout;
import com.filemaker.jwpc.iwp.ui.layout.component.LOWrapper;
import com.filemaker.jwpc.iwp.ui.layout.component.LayoutFieldObjectDelegate;
import com.filemaker.jwpc.iwp.ui.layout.component.RadioSetValueListDataSource;
import com.filemaker.jwpc.iwp.ui.layout.component.StringDataUpdateParameters;
import com.filemaker.jwpc.iwp.ui.layout.component.ValueListItem;
import com.filemaker.jwpc.iwp.ui.layout.component.repetition.RepetitionContainer;
import com.filemaker.jwpc.iwp.ui.layout.list.LayoutListView;
import com.filemaker.jwpc.iwp.ui.layout.listener.RadioSetListener;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.filemaker.jwpc.iwp.util.LayoutObjectUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.RadioSetClientRpc;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.RadioSetServerRpc;
import com.filemaker.jwpc.iwp.widgetset.client.state.RadioSetState;
import com.filemaker.jwpc.util.Utilities;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Component;
import com.vaadin.v7.data.Container;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class RadioSet
extends NavigableOptionGroup
implements LayoutFieldObject {
    private LayoutFieldObjectDelegate delegate;
    protected RadioSetListener listener;
    private LayoutObject parent;
    protected RadioSetValueListDataSource container;
    protected Object containerLock = new Object();
    private boolean containerPopulated = false;
    private boolean hasPendingContainerRefresh = false;
    private boolean hasAccess = false;
    private DBAccessLevel access = DBAccessLevel.UnknownAccess;
    private boolean hideConditionOn = false;
    private boolean isActive = false;
    private StringDataUpdateParameters pendingData;

    public RadioSet(App app, LayoutView layoutView, ObjectMetaData objectMetaData, ObjectAttributes objectAttributes) {
        super.setTabIndex(-1);
        this.delegate = new LayoutFieldObjectDelegate(app, layoutView, this, objectMetaData, objectAttributes);
        this.listener = new RadioSetListener(this.delegate.getApp(), this);
        this.setImmediate(true);
        this.initListeners();
        this.delegate.setWidthAndHeight(this);
        this.setMultiSelect(false);
        this.setNullSelectionAllowed(true);
        this.registerRadioSetRpc();
        this.initUI();
        this.setEnabled(true);
        this.setReadOnly(false);
        this.delegate.view.getUIEventBus().subscribe(this, EventType.SCRIPT_STATE_CHANGE);
    }

    private void initUI() {
        LOWrapper lOWrapper = new LOWrapper(this, this.getMetaData().getPositionCss());
        RadioSet radioSet = this;
        this.delegate.init((AbstractComponent)lOWrapper, (AbstractComponent)radioSet, null);
    }

    @Override
    public void cleanupMemory() {
        if (this.delegate != null && !this.delegate.isActiveAndInPopover()) {
            if (this.delegate.view.getUIEventBus() != null) {
                this.delegate.view.getUIEventBus().unsubscribe(this, EventType.SCRIPT_STATE_CHANGE);
            }
            this.delegate.cleanupMemory();
            this.delegate = null;
        }
    }

    private void registerRadioSetRpc() {
        RadioSetServerRpc radioSetServerRpc = new RadioSetServerRpc(){

            @Override
            public void deleteKeyPressed(String string) {
                GlobalUIActionHandlers.ClearAction clearAction = GlobalUIActionHandlers.CLEAR_FIELD_CONTENTS;
                clearAction.perform(RadioSet.this.delegate.getApp(), null);
            }

            @Override
            public void onTabPress(boolean bl) {
                RadioSet.this.onTabPress(bl);
            }

            @Override
            public void onEnterPress(boolean bl) {
                RadioSet.this.onEnterPress(bl);
            }
        };
        this.registerRpc(radioSetServerRpc);
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
    public Component getWrappedObject() {
        return this.delegate.getWrappedObject();
    }

    public void beforeClientResponse(boolean bl) {
        super.beforeClientResponse(bl);
        this.updateBooleanState(RadioSetState.BooleanState.hasScript, this.getMetaData().hasValidAndExecutableScript());
        this.updateBooleanState(RadioSetState.BooleanState.hasTooltip, this.getDescription() != null && this.getDescription().length() > 0);
        this.updateBooleanState(RadioSetState.BooleanState.exitOnTAB, this.getMetaData().getExitOnTAB());
        this.updateBooleanState(RadioSetState.BooleanState.exitOnRETURN, this.getMetaData().getExitOnRETURN());
        this.updateBooleanState(RadioSetState.BooleanState.exitOnENTER, this.getMetaData().getExitOnENTER());
    }

    private void updateBooleanState(RadioSetState.BooleanState booleanState, boolean bl) {
        this.getState().rsbs = IWPUtilities.applyBooleanValue(this.getState().rsbs, booleanState.ordinal(), bl);
    }

    protected void reset() {
        ((RadioSetClientRpc)this.getRpcProxy(RadioSetClientRpc.class)).setSelectionAllowed(true);
        this.containerPopulated = false;
    }

    public boolean hasPendingContainerRefresh() {
        return this.hasPendingContainerRefresh;
    }

    @Override
    public DBAccessLevel getAccess() {
        return this.access;
    }

    private void initListeners() {
        this.addValueChangeListener(this.listener);
    }

    @Override
    public void setGlassPaneParent(AbsoluteCssLayout absoluteCssLayout) {
        this.delegate.setGlassPaneParent(absoluteCssLayout);
    }

    @Override
    public boolean allowGlassPaneActivation() {
        return true;
    }

    @Override
    public void updateDataEntry(DBAccessLevel dBAccessLevel, boolean bl) {
        this.access = dBAccessLevel;
        if (this.delegate.hasDataEntryHandler()) {
            boolean bl2 = this.hasAccess;
            boolean bl3 = this.hasAccess = this.containerPopulated && this.container.hasValidValues() && LayoutObjectUtilities.allowDataEntry(this.delegate.getApp(), this, dBAccessLevel);
            if (bl || bl2 != this.hasAccess) {
                if (this.hasAccess) {
                    this.enableAccess();
                } else {
                    this.disableAccess();
                }
            }
        }
    }

    private void refreshDynamicValueListData(int n, int n2, StringDataUpdateParameters stringDataUpdateParameters) {
        this.hasPendingContainerRefresh = true;
        this.pendingData = stringDataUpdateParameters;
        ValueListSubsetRequest valueListSubsetRequest = new ValueListSubsetRequest(this.getAttributes().getObjectSpec(), n, n2);
        if (this.delegate.getApp().isListView()) {
            ((LayoutListView)this.delegate.getApp().getLayoutContainer().getCurrentView()).getValueListSubset(valueListSubsetRequest);
        } else {
            this.delegate.getApp().getAppSession().getValueListSubset(new ActionResultGetterHandler(){

                @Override
                public void onFinish(Object object) {
                    RadioSet.this.handleGetValueListSubsetNotification((ValueListData)object);
                }
            }, valueListSubsetRequest);
        }
    }

    public void handleGetValueListSubsetNotification(ValueListData valueListData) {
        this.instantiateContainer(this.pendingData, valueListData);
        ((RadioSetClientRpc)this.getRpcProxy(RadioSetClientRpc.class)).setSelectionAllowed(true);
    }

    @Override
    public int getObjectId() {
        return this.delegate.getMetaData().getObjectId();
    }

    @Override
    public String getUniqueId() {
        return this.delegate.getWrappedObject().getId();
    }

    @Override
    public void updateUniqueId() {
        String string = this.getUniqueId();
        String string2 = IWPUtilities.generateUniqueId(this.delegate.getApp(), this);
        if (!string2.equals(string)) {
            this.delegate.getWrappedObject().setId(string2);
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

    public RadioSetState getState() {
        return (RadioSetState)super.getState();
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
        if (bl || !this.containerPopulated) {
            this.refreshDynamicValueListData(0, 0, stringDataUpdateParameters);
            return;
        }
        if (!stringDataUpdateParameters.hasError()) {
            this.updateDataEntry(stringDataUpdateParameters.getAccess(), false);
            this.updateDataImpl(stringDataUpdateParameters);
            if (this.isActive) {
                this.setFocus();
            }
        } else {
            Object object = this.containerLock;
            synchronized (object) {
                this.disableAccess();
                this.access = DBAccessLevel.NoAccess;
                this.updateData("");
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void updateDataImpl(StringDataUpdateParameters stringDataUpdateParameters) {
        String string = stringDataUpdateParameters.getData().getValue();
        String string2 = (String)this.getFieldData();
        if (string2 == null || !string2.equalsIgnoreCase(string)) {
            Object object = this.containerLock;
            synchronized (object) {
                if (stringDataUpdateParameters.disableListeners()) {
                    boolean bl = false;
                    try {
                        if (this.listener.isValueChangeListenerEnabled()) {
                            this.listener.disableValueChangeListener();
                            bl = true;
                        }
                        this.updateData(string);
                    }
                    finally {
                        if (bl) {
                            this.listener.enableValueChangeListener();
                        }
                    }
                } else {
                    this.updateData(string);
                }
            }
        }
    }

    private void disableAccess() {
        this.hasAccess = false;
        this.access = DBAccessLevel.ReadOnly;
        this.delegate.updateTabIndex(-1);
        this.delegate.activateGlassPane();
    }

    private void enableAccess() {
        this.hasAccess = true;
        this.access = DBAccessLevel.ReadWrite;
        if (this.getMetaData().getFieldType() == LayoutFieldType.NORMAL) {
            this.delegate.updateTabIndex(this.delegate.getMetaData().getTabOrder(this.getAttributes().getRepetition()));
        } else {
            this.delegate.updateTabIndex(-1);
        }
        if (this.getMetaData().hasValidAndExecutableScript()) {
            this.delegate.activateGlassPane();
        } else {
            this.delegate.deactivateGlassPane();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void updateData(String string) {
        Iterator iterator;
        HashSet<ValueListItem> hashSet = new HashSet<ValueListItem>();
        if (!Utilities.isEmptyString(string)) {
            for (Object object : iterator = IWPUtilities.splitValues(string)) {
                Object object2 = this.containerLock;
                synchronized (object2) {
                    ValueListItem valueListItem = this.container.lookupStored(object);
                    if (valueListItem != null) {
                        hashSet.add(valueListItem);
                        if (!this.isSelected(valueListItem)) {
                            this.select(valueListItem);
                        }
                    }
                }
            }
        }
        iterator = this.getItemIds();
        Iterator iterator2 = iterator.iterator();
        while (iterator2.hasNext()) {
            Object e = iterator2.next();
            if (hashSet.contains(e) || !this.isSelected(e)) continue;
            this.unselect(e);
        }
    }

    @Override
    public Object getFieldData() {
        return IWPUtilities.getValueListStoredStringValue(this.container, this.getValue());
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
            case SCRIPT_STATE_CHANGE: {
                ((RadioSetClientRpc)this.getRpcProxy(RadioSetClientRpc.class)).setSelectionAllowed(true);
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
        StringDataUpdateParameters stringDataUpdateParameters = new StringDataUpdateParameters(new StringData(string, false, null, false), this.access, false, false, "", false, false, 0, 0, false);
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

    private void setFocus() {
        if (this.isActive) {
            ((RadioSetClientRpc)this.getRpcProxy(RadioSetClientRpc.class)).setActive(true);
        }
    }

    @Override
    public void onActive() {
        this.isActive = true;
        this.setFocus();
    }

    @Override
    public void onInactive() {
        if (this.isActive) {
            this.isActive = false;
            ((RadioSetClientRpc)this.getRpcProxy(RadioSetClientRpc.class)).setActive(false);
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
        this.listener.onFieldObjectClick(true);
    }

    @Override
    public void setTabIndex(int n) {
        super.setTabIndex(-1);
    }

    @Override
    public void setPlaceholderText(String string) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void instantiateContainer(StringDataUpdateParameters stringDataUpdateParameters, ValueListData valueListData) {
        Object object = this.containerLock;
        synchronized (object) {
            boolean bl = false;
            boolean bl2 = false;
            try {
                if (this.listener.isValueChangeListenerEnabled()) {
                    this.listener.disableValueChangeListener();
                    bl2 = true;
                }
                this.container = new RadioSetValueListDataSource();
                if (valueListData.isValidData()) {
                    this.container.addOriginalValues(valueListData);
                    bl = true;
                } else {
                    this.container.setErrorValue(valueListData.getErrorString());
                    this.disableAccess();
                }
                this.setContainerDataSource((Container)this.container);
                this.containerPopulated = true;
            }
            finally {
                if (bl2) {
                    this.listener.enableValueChangeListener();
                }
            }
            if (bl) {
                this.updateFieldObjectData(stringDataUpdateParameters, false);
            }
            this.hasPendingContainerRefresh = false;
        }
    }

    protected void setValue(Object object, boolean bl) {
        if (object == null && this.getValue() == null || object != null && this.getValue() != null && object.equals(this.getValue())) {
            ((RadioSetClientRpc)this.getRpcProxy(RadioSetClientRpc.class)).setSelectionAllowed(true);
        }
        super.setValue(object, bl);
    }

    @Override
    public boolean hasDelegate() {
        return this.delegate != null;
    }

    @Override
    public void showContextMenu(int n, int n2) {
    }

    @Override
    public void registerAccTitle(String string) {
        this.setCaption(string.isEmpty() ? null : string);
        this.addStyleName("sr-only-caption-title-and-help");
    }

    @Override
    public void registerAccHelp(String string) {
    }

    @Override
    public void registerAccLabel(String string) {
    }
}

