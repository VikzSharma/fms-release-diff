/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.application;

import com.filemaker.fields.FMComboBox;
import com.filemaker.fields.FMField;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.metadata.ObjectMetaData;
import com.filemaker.jwpc.iwp.thrift.common.ActiveObjectInfo;
import com.filemaker.jwpc.iwp.thrift.common.ActiveRowState;
import com.filemaker.jwpc.iwp.thrift.common.LayoutMode;
import com.filemaker.jwpc.iwp.thrift.common.ObjectSpec;
import com.filemaker.jwpc.iwp.ui.event.ActiveObjectChangeEvent;
import com.filemaker.jwpc.iwp.ui.event.UIEventListener;
import com.filemaker.jwpc.iwp.ui.layout.FocusableLayoutObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutContainer;
import com.filemaker.jwpc.iwp.ui.layout.LayoutFieldObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutTextFieldObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutView;
import com.filemaker.jwpc.iwp.ui.layout.component.container.Container;
import com.filemaker.jwpc.iwp.ui.layout.component.popover.PopoverWindow;
import com.filemaker.jwpc.iwp.ui.layout.component.portal.Portal;
import com.filemaker.jwpc.iwp.ui.layout.list.LayoutListView;
import com.filemaker.jwpc.iwp.ui.statusarea.component.QuickFind;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.filemaker.jwpc.iwp.util.LayoutObjectUtilities;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class ActiveUIHandler {
    private final App app;
    private ActiveObjectInfo newActiveObjectInfo = null;
    private ObjectMetaData newActiveObjectMetadata = null;
    private ContextMenuState contextMenuState = null;
    private FieldContextMenuState fieldContextMenuState = null;
    private LayoutMode currentActiveObjectMode = LayoutMode.BROWSE;
    private LayoutObject currentActiveObject = null;
    private AtomicBoolean shouldFocusQuickFind = new AtomicBoolean(false);
    private AtomicBoolean shouldShowFieldContextMenu = new AtomicBoolean(false);
    private AtomicBoolean shouldSkipRefresh = new AtomicBoolean(false);
    private boolean hasPendingActiveObjectChange = false;
    private AtomicBoolean hasPendingRefresh = new AtomicBoolean(false);
    private AtomicBoolean hasPendingTabbing = new AtomicBoolean(false);
    private AtomicBoolean hasPendingSelectionUpdate = new AtomicBoolean(false);
    private AtomicInteger pendingSelectionStart = new AtomicInteger(-1);
    private AtomicInteger pendingSelectionEnd = new AtomicInteger(-1);
    private AtomicBoolean notifyClientOfActiveState = new AtomicBoolean(true);
    private FMComboBox suspendedComboBox = null;
    private LayoutObject pendingHideObject = null;
    private long pendingTabbingTaskId = 0L;

    public ActiveUIHandler(App app) {
        this.app = app;
    }

    public void reset() {
        this.newActiveObjectInfo = null;
        this.newActiveObjectMetadata = null;
        this.contextMenuState = null;
        this.fieldContextMenuState = null;
        this.hasPendingActiveObjectChange = false;
        this.hasPendingRefresh.set(false);
        this.hasPendingTabbing.set(false);
        this.hasPendingSelectionUpdate.set(false);
        this.pendingSelectionStart.set(-1);
        this.pendingSelectionEnd.set(-1);
        this.currentActiveObjectMode = LayoutMode.BROWSE;
        this.currentActiveObject = null;
        this.shouldFocusQuickFind.set(false);
        this.shouldSkipRefresh.set(false);
        this.pendingHideObject = null;
        this.clearPendingTabbingTaskId();
    }

    public boolean shouldNotifyClientOfActiveState() {
        return this.notifyClientOfActiveState.get();
    }

    public void setPendingRefresh() {
        this.hasPendingRefresh.set(true);
    }

    public boolean hasPendingRefresh() {
        return this.hasPendingRefresh.get();
    }

    public void setSkipRefresh(boolean bl) {
        this.shouldSkipRefresh.set(bl);
    }

    public void setPendingTabbing(boolean bl) {
        this.hasPendingTabbing.set(bl);
    }

    public boolean hasPendingTabbing() {
        return this.hasPendingTabbing.get();
    }

    public void setPendingSelectionUpdate(boolean bl) {
        this.hasPendingSelectionUpdate.set(bl);
    }

    public void setQuickFindFocus(boolean bl) {
        this.shouldFocusQuickFind.set(bl);
    }

    public void setPendingSelectionStart(int n) {
        this.pendingSelectionStart.set(n);
    }

    public void setPendingSelectionEnd(int n) {
        this.pendingSelectionEnd.set(n);
    }

    public void setPendingHideObject(LayoutObject layoutObject) {
        this.pendingHideObject = layoutObject;
    }

    public void setPendingTabbingTaskId(long l) {
        this.pendingTabbingTaskId = l;
    }

    public long getPendingTabbingTaskId() {
        return this.pendingTabbingTaskId;
    }

    public void clearPendingTabbingTaskId() {
        this.pendingTabbingTaskId = 0L;
    }

    public void setContextMenuPosition(Container container, int n, int n2) {
        this.contextMenuState = new ContextMenuState(this, container, n, n2);
    }

    public void setFieldContextMenuPosition(LayoutObject layoutObject, int n, int n2) {
        this.fieldContextMenuState = new FieldContextMenuState(this, layoutObject, n, n2);
    }

    public void clearContextMenuPosition() {
        this.contextMenuState = null;
    }

    public void clearFieldContextMenuPosition() {
        this.fieldContextMenuState = null;
    }

    public void setHandleFieldContextMenu(boolean bl) {
        this.shouldShowFieldContextMenu.set(bl);
    }

    public boolean getHandleFieldContextMenu() {
        return this.shouldShowFieldContextMenu.get();
    }

    public void refreshQuickFindFocusAsNeeded() {
        if (this.shouldFocusQuickFind.get()) {
            QuickFind quickFind2 = this.app.getQuickFind();
            if (quickFind2 != null) {
                quickFind2.focus();
            } else {
                this.shouldFocusQuickFind.set(false);
            }
        }
    }

    private void setCurrentActiveObject(LayoutObject layoutObject) {
        if (this.pendingHideObject != null) {
            boolean bl;
            boolean bl2 = bl = layoutObject == null || !(layoutObject instanceof LayoutTextFieldObject) || !LayoutObjectUtilities.isAncestor(layoutObject, this.pendingHideObject);
            if (bl) {
                if (this.pendingHideObject.isHideConditionOn()) {
                    this.app.getLayoutContainer().getCurrentView().getDataUpdator().hideLayoutObjectAndRepetitions(this.pendingHideObject, true);
                }
                this.pendingHideObject = null;
            }
        }
        this.currentActiveObject = layoutObject;
        ObjectMetaData objectMetaData = this.newActiveObjectMetadata = this.currentActiveObject != null ? this.currentActiveObject.getMetaData() : null;
        if (layoutObject instanceof FMField && this.hasPendingSelectionUpdate.get()) {
            FMField fMField = (FMField)((Object)layoutObject);
            fMField.setSelectionRangeImmediately(this.pendingSelectionStart.get(), this.pendingSelectionEnd.get() - this.pendingSelectionStart.get());
            this.hasPendingSelectionUpdate.set(false);
            this.pendingSelectionStart.set(-1);
            this.pendingSelectionEnd.set(-1);
        }
    }

    private ObjectSpec getNewActiveObjectSpec() {
        return this.newActiveObjectInfo != null ? this.newActiveObjectInfo.getObjectSpec() : null;
    }

    public void updateActiveState(ActiveRowState activeRowState) {
        ObjectSpec objectSpec;
        this.notifyClientOfActiveState.set(activeRowState.isNotifyClientOfActiveState());
        ActiveObjectInfo activeObjectInfo = this.newActiveObjectInfo = activeRowState.isObjectActive() ? activeRowState.getActiveObjectInfo() : null;
        if (!activeRowState.isActivePopover()) {
            this.app.getLayoutContainer().getPopoverHandler().exitPopover(false);
        }
        ObjectSpec objectSpec2 = objectSpec = this.currentActiveObject != null ? this.currentActiveObject.getAttributes().getObjectSpec() : null;
        if (this.currentActiveObjectMode != this.app.getCurrentLayoutMode() || !IWPUtilities.representsSameFMLayoutObject(objectSpec, this.getNewActiveObjectSpec())) {
            this.hasPendingActiveObjectChange = true;
            this.clearActiveUI();
            this.currentActiveObjectMode = this.app.getCurrentLayoutMode();
        }
        this.refreshActiveUI();
        this.notifyClientOfActiveState.set(true);
    }

    public void refreshActiveUI() {
        if (this.shouldSkipRefresh.get()) {
            return;
        }
        if (IWPUtilities.isValidObjectSpec(this.getNewActiveObjectSpec())) {
            this.app.getLayoutContainer().getCurrentView().refreshActiveObject(this.getNewActiveObjectSpec(), this.hasPendingActiveObjectChange);
            this.setQuickFindFocus(false);
        } else {
            this.app.notify(new ActiveObjectChangeEvent(null));
            this.app.getCommunicationComponent().clearActiveField();
            this.refreshQuickFindFocusAsNeeded();
        }
        this.hasPendingActiveObjectChange = false;
        this.hasPendingRefresh.set(false);
        this.contextMenuState = null;
        this.fieldContextMenuState = null;
    }

    public void refreshActiveUI(LayoutObject layoutObject) {
        if (layoutObject != null) {
            this.setCurrentActiveObject(layoutObject);
            Portal portal = null;
            portal = layoutObject.getMetaData().isPortal() ? (Portal)layoutObject : layoutObject.getAttributes().getOwningPortal();
            if (portal != null) {
                portal.onActiveObjectStateChange(layoutObject, this.getNewActiveObjectSpec().getPortalRowIndex(), true);
            }
            if (layoutObject instanceof FocusableLayoutObject) {
                ((FocusableLayoutObject)((Object)layoutObject)).onActive();
                if (layoutObject instanceof FMField) {
                    this.updateActiveFMFieldObjectSelection((FMField)((Object)layoutObject));
                }
            }
            this.app.notify(new ActiveObjectChangeEvent(layoutObject));
            if (!layoutObject.getMetaData().isField()) {
                this.app.getCommunicationComponent().clearActiveField();
            }
        }
    }

    public void updateContextMenu(LayoutObject layoutObject) {
        if (this.contextMenuState != null && this.contextMenuState.container == layoutObject) {
            ((Container)layoutObject).showContextMenu(this.contextMenuState.posX, this.contextMenuState.posY);
        }
        this.contextMenuState = null;
    }

    private void clearActiveUI() {
        if (this.currentActiveObject != null) {
            UIEventListener uIEventListener;
            if (this.currentActiveObject.getMetaData().isPortal()) {
                ((Portal)this.currentActiveObject).onActiveObjectStateChange(null, 0, false);
            } else {
                uIEventListener = this.currentActiveObject.getAttributes().getOwningPortal();
                if (uIEventListener != null) {
                    ((Portal)uIEventListener).onActiveObjectStateChange(null, 0, false);
                }
            }
            if (this.currentActiveObject.getMetaData().isField()) {
                uIEventListener = (LayoutFieldObject)this.currentActiveObject;
                if (!this.currentActiveObject.getMetaData().isContainer()) {
                    LayoutObjectUtilities.updateFieldObjectData(this.app, (LayoutFieldObject)uIEventListener);
                }
                if (uIEventListener.getAttributes().isInPopover() && !this.app.getLayoutContainer().getPopoverHandler().isPopoverOpen()) {
                    uIEventListener.cleanupMemory();
                }
            }
            if (this.currentActiveObject instanceof FocusableLayoutObject) {
                ((FocusableLayoutObject)((Object)this.currentActiveObject)).onInactive();
            }
        }
        if (!IWPUtilities.isValidObjectSpec(this.getNewActiveObjectSpec())) {
            this.clearFocus();
        }
        this.setCurrentActiveObject(null);
    }

    public void cleanupActiveObject(LayoutFieldObject layoutFieldObject) {
        if (this.currentActiveObject == layoutFieldObject) {
            this.currentActiveObject = null;
            this.newActiveObjectMetadata = null;
        }
    }

    public void clearFocus() {
        if (this.app.isLoggedIn()) {
            if (!this.shouldFocusQuickFind.get()) {
                PopoverWindow popoverWindow = this.app.getLayoutContainer().getPopoverWindow();
                if (popoverWindow == null || !popoverWindow.isVisible()) {
                    this.app.focus();
                } else {
                    popoverWindow.focus();
                }
                this.app.getAppView().deselectTextInBrowser();
            } else {
                this.refreshQuickFindFocusAsNeeded();
            }
        }
    }

    public boolean hasActiveField() {
        return this.getNewActiveObjectSpec() != null;
    }

    public boolean isActiveObject(LayoutObject layoutObject) {
        return IWPUtilities.representsSameFMLayoutObject(this.getNewActiveObjectSpec(), layoutObject.getAttributes().getObjectSpec());
    }

    public boolean isActiveObject(ObjectSpec objectSpec) {
        return IWPUtilities.representsSameFMLayoutObject(this.getNewActiveObjectSpec(), objectSpec);
    }

    private void updateActiveFMFieldObjectSelection(FMField fMField) {
        if (fMField != null && this.newActiveObjectInfo != null && this.newActiveObjectInfo.isUpdateSelection()) {
            if (this.newActiveObjectInfo.isSelectAll()) {
                fMField.selectAllText();
            } else {
                int n = this.newActiveObjectInfo.getSelectionStart();
                int n2 = this.newActiveObjectInfo.getSelectionEnd();
                fMField.setSelectionRange(n, n2 - n);
            }
        }
    }

    public ObjectMetaData getActiveObjectMetaData() {
        return this.newActiveObjectMetadata;
    }

    public LayoutFieldObject getActiveField(boolean bl, boolean bl2) {
        LayoutFieldObject layoutFieldObject = null;
        LayoutObject layoutObject = this.currentActiveObject;
        if (layoutObject == null && bl && IWPUtilities.isValidObjectSpec(this.getNewActiveObjectSpec())) {
            layoutObject = this.getLayoutObject(this.getNewActiveObjectSpec());
        }
        if (layoutObject != null && layoutObject.getMetaData().isField() && (bl2 || layoutObject.isConnectorEnabled())) {
            layoutFieldObject = (LayoutFieldObject)layoutObject;
        }
        return layoutFieldObject;
    }

    public boolean isActiveObjectInPopover() {
        boolean bl = false;
        ObjectSpec objectSpec = this.getNewActiveObjectSpec();
        if (IWPUtilities.isValidObjectSpec(objectSpec)) {
            bl = objectSpec.getParentPopoverId() != 0 || objectSpec.getGrandParentPopoverId() != 0;
        }
        return bl;
    }

    private LayoutObject getLayoutObject(ObjectSpec objectSpec) {
        return this.getLayoutObject(objectSpec, false);
    }

    private LayoutObject getLayoutObject(ObjectSpec objectSpec, boolean bl) {
        PopoverWindow popoverWindow;
        LayoutView layoutView;
        LayoutObject layoutObject;
        LayoutContainer layoutContainer = this.app.getLayoutContainer();
        ObjectSpec objectSpec2 = new ObjectSpec(objectSpec);
        if (this.app.isFormView()) {
            objectSpec2.setRowId(this.app.getLayoutDataModel().getRowId());
        }
        if ((layoutObject = (layoutView = layoutContainer.getCurrentView()) instanceof LayoutListView ? ((LayoutListView)layoutView).getLayoutObject(objectSpec2, bl) : layoutView.getLayoutObject(objectSpec2)) == null && (popoverWindow = this.app.getLayoutContainer().getPopoverWindow()) != null && popoverWindow.isVisible()) {
            layoutObject = popoverWindow.getPopover().getLayoutObject(objectSpec);
        }
        if (layoutObject == null) {
            IWPUtilities.showDebugMessage(this.app, "Warning: Object with id " + objectSpec2.getObjectId() + " is missing in layout in row " + objectSpec2.getRowIndex() + ".");
        }
        return layoutObject;
    }

    public void trySuspendActiveComboBox() {
        FMComboBox fMComboBox;
        LayoutFieldObject layoutFieldObject = this.getActiveField(false, false);
        if (layoutFieldObject instanceof FMComboBox && this.suspendedComboBox != (fMComboBox = (FMComboBox)((Object)layoutFieldObject))) {
            this.tryResumeComboBox();
            this.suspendedComboBox = fMComboBox;
            this.suspendedComboBox.suspend();
        }
    }

    public void tryResumeComboBox() {
        if (this.suspendedComboBox != null) {
            this.suspendedComboBox.resume();
            this.suspendedComboBox = null;
        }
    }

    private class ContextMenuState {
        private final Container container;
        private final int posX;
        private final int posY;

        private ContextMenuState(ActiveUIHandler activeUIHandler, Container container, int n, int n2) {
            this.container = container;
            this.posX = n;
            this.posY = n2;
        }
    }

    private class FieldContextMenuState {
        private final LayoutObject target;
        private final int posX;
        private final int posY;

        private FieldContextMenuState(ActiveUIHandler activeUIHandler, LayoutObject layoutObject, int n, int n2) {
            this.target = layoutObject;
            this.posX = n;
            this.posY = n2;
        }

        private LayoutObject getTarget() {
            return this.target;
        }
    }
}

