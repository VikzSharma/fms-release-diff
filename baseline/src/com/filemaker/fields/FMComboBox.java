/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.event.FieldEvents$BlurEvent
 *  com.vaadin.event.FieldEvents$BlurListener
 *  com.vaadin.event.FieldEvents$FocusEvent
 *  com.vaadin.event.FieldEvents$FocusListener
 *  com.vaadin.event.SerializableEventListener
 *  com.vaadin.v7.event.FieldEvents$BlurNotifier
 *  com.vaadin.v7.event.FieldEvents$FocusNotifier
 */
package com.filemaker.fields;

import com.filemaker.fields.FMField;
import com.filemaker.fields.client.combobox.ComboBoxClientRpc;
import com.filemaker.fields.client.combobox.ComboBoxItem;
import com.filemaker.fields.client.combobox.ComboBoxServerRpc;
import com.filemaker.fields.client.combobox.ComboBoxState;
import com.filemaker.fields.client.common.FocusMode;
import com.filemaker.fields.interfaces.ComboBoxItemProvider;
import com.filemaker.fields.interfaces.SelectionChangeListener;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.vaadin.event.FieldEvents;
import com.vaadin.event.SerializableEventListener;
import com.vaadin.v7.event.FieldEvents;
import java.util.LinkedList;
import java.util.List;

public class FMComboBox
extends FMField<ComboBoxItem>
implements FieldEvents.BlurNotifier,
FieldEvents.FocusNotifier {
    private List<SelectionChangeListener> selectionListeners = new LinkedList<SelectionChangeListener>();
    private ComboBoxItemProvider itemProvider;
    private boolean delayedShowSuggestions = false;
    private boolean editMode = false;
    private boolean isSuspended = false;

    public FMComboBox() {
        this.registerRpc();
        this.addBlurListener(new FieldEvents.BlurListener(){

            public void blur(FieldEvents.BlurEvent blurEvent) {
                FMComboBox.this.delayedShowSuggestions = false;
            }
        });
    }

    public void showSuggestions() {
        this.delayedShowSuggestions = false;
        ((ComboBoxClientRpc)this.getRpcProxy(ComboBoxClientRpc.class)).showMenu();
    }

    public void hideSuggestions() {
        ((ComboBoxClientRpc)this.getRpcProxy(ComboBoxClientRpc.class)).hideMenu();
    }

    public void suspend() {
        this.isSuspended = true;
        this.hideSuggestions();
    }

    public void resume() {
        this.isSuspended = false;
    }

    public void setItemProvider(ComboBoxItemProvider comboBoxItemProvider) {
        this.itemProvider = comboBoxItemProvider;
    }

    public void setArrowVisible(boolean bl) {
        this.updateBooleanState(ComboBoxState.BooleanState.arrowVisible, bl);
    }

    public boolean isArrowVisible() {
        return IWPUtilities.getBooleanValue(this.getState((boolean)false).cbbs, ComboBoxState.BooleanState.arrowVisible.ordinal());
    }

    public int getPageLength() {
        return this.getState((boolean)false).pageLength;
    }

    @Override
    public void setNewLineAllowed(boolean bl) {
        super.setNewLineAllowed(bl);
    }

    @Override
    public boolean isNewLineAllowed() {
        return super.isNewLineAllowed();
    }

    public void setPageLength(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("Page length can not be less than 1");
        }
        this.getState().pageLength = n;
    }

    @Override
    public ComboBoxState getState() {
        return (ComboBoxState)super.getState();
    }

    @Override
    public ComboBoxState getState(boolean bl) {
        return (ComboBoxState)super.getState(bl);
    }

    public void addBlurListener(FieldEvents.BlurListener blurListener) {
        this.addListener("blur", FieldEvents.BlurEvent.class, (SerializableEventListener)blurListener, FieldEvents.BlurListener.blurMethod);
    }

    public void removeBlurListener(FieldEvents.BlurListener blurListener) {
        this.removeListener("blur", FieldEvents.BlurEvent.class, blurListener);
    }

    public void addFocusListener(FieldEvents.FocusListener focusListener) {
        this.addListener("focus", FieldEvents.FocusEvent.class, (SerializableEventListener)focusListener, FieldEvents.FocusListener.focusMethod);
    }

    public void removeFocusListener(FieldEvents.FocusListener focusListener) {
        this.removeListener("focus", FieldEvents.FocusEvent.class, focusListener);
    }

    public Class<ComboBoxItem> getType() {
        return ComboBoxItem.class;
    }

    protected void handleOptions(String string, int n, int n2, boolean bl) {
    }

    protected void showOptions(Object object, String string, int n, int n2, boolean bl) {
        if (!this.isSuspended) {
            ComboBoxItemProvider.ItemProviderResult itemProviderResult = this.itemProvider.provideItems(string, n, n2, bl);
            if (itemProviderResult != null && itemProviderResult.items != null) {
                ((ComboBoxClientRpc)this.getRpcProxy(ComboBoxClientRpc.class)).showOptions(itemProviderResult.items, n, itemProviderResult.totalNumberOfItems, itemProviderResult.pageIndexOverride, itemProviderResult.separators, string);
            } else {
                this.hideSuggestions();
            }
        }
    }

    private void registerRpc() {
        this.registerRpc(new ComboBoxServerRpcImpl(), ComboBoxServerRpc.class);
    }

    private void convertAndSetAsValue(ComboBoxItem comboBoxItem) {
        if (comboBoxItem != null && comboBoxItem.getId() == null && this.itemProvider != null) {
            this.setValue(this.itemProvider.mapToItem(comboBoxItem.getFieldValue()));
        } else {
            this.setValue(comboBoxItem);
        }
        this.setSelectedItem();
        this.markAsDirty();
    }

    protected void setSelectedItem() {
        this.getState().selectedItem = (ComboBoxItem)this.getValue();
    }

    public void addSelectionChangeListener(SelectionChangeListener selectionChangeListener) {
        this.selectionListeners.add(selectionChangeListener);
    }

    public void removeSelectionChangeListener(SelectionChangeListener selectionChangeListener) {
        this.selectionListeners.remove(selectionChangeListener);
    }

    public void fireSelectionChange(ComboBoxItem comboBoxItem, boolean bl) {
        for (SelectionChangeListener selectionChangeListener : this.selectionListeners) {
            selectionChangeListener.selectionChanged(comboBoxItem, bl);
        }
    }

    @Override
    public void setFocusMode(FocusMode focusMode) {
        if (focusMode == FocusMode.INSTANT) {
            this.delayedShowSuggestions = false;
        }
        super.setFocusMode(focusMode);
    }

    @Override
    public void startEdit() {
        this.isSuspended = false;
        this.editMode = true;
        super.startEdit();
        if (this.delayedShowSuggestions) {
            this.showSuggestions();
        }
    }

    protected void stopEdit() {
        this.isSuspended = true;
        this.editMode = false;
    }

    private void updateBooleanState(ComboBoxState.BooleanState booleanState, boolean bl) {
        this.getState().cbbs = IWPUtilities.applyBooleanValue(this.getState().cbbs, booleanState.ordinal(), bl);
    }

    @Override
    public void onTextChange(String string, boolean bl) {
    }

    private class ComboBoxServerRpcImpl
    implements ComboBoxServerRpc {
        private ComboBoxServerRpcImpl() {
        }

        @Override
        public void requestOptions(String string, int n, int n2, boolean bl) {
            if (FMComboBox.this.getState().focusMode == FocusMode.INSTANT || FMComboBox.this.editMode || string != null && !string.isEmpty()) {
                FMComboBox.this.handleOptions(string, n, n2, bl);
            } else {
                FMComboBox.this.delayedShowSuggestions = true;
            }
        }

        @Override
        public void updateSelection(ComboBoxItem comboBoxItem, boolean bl) {
            if (comboBoxItem != null && comboBoxItem.getId() == null) {
                comboBoxItem.setFieldValue(comboBoxItem.getFieldValue());
                comboBoxItem.setPopupPresentation(comboBoxItem.getPopupPresentation());
            }
            FMComboBox.this.convertAndSetAsValue(comboBoxItem);
            FMComboBox.this.fireSelectionChange(comboBoxItem, bl);
        }
    }
}

