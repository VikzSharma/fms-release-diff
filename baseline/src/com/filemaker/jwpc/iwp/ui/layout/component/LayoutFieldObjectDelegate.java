/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.server.Sizeable$Unit
 *  com.vaadin.ui.AbstractComponent
 *  com.vaadin.ui.Component
 */
package com.filemaker.jwpc.iwp.ui.layout.component;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.metadata.ObjectMetaData;
import com.filemaker.jwpc.iwp.thrift.common.DBAccessLevel;
import com.filemaker.jwpc.iwp.ui.common.GlassPaneHandler;
import com.filemaker.jwpc.iwp.ui.event.EventType;
import com.filemaker.jwpc.iwp.ui.layout.LayoutFieldObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutView;
import com.filemaker.jwpc.iwp.ui.layout.ObjectAttributes;
import com.filemaker.jwpc.iwp.ui.layout.component.AbsoluteCssLayout;
import com.filemaker.jwpc.iwp.ui.layout.component.repetition.RepetitionContainer;
import com.filemaker.jwpc.iwp.util.LayoutObjectUtilities;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Component;
import java.util.ArrayList;

public class LayoutFieldObjectDelegate {
    protected App app;
    protected LayoutView view;
    private GlassPaneHandler dataEntryHandler;
    private RepetitionContainer repetition;
    private ObjectMetaData metaData;
    private ObjectAttributes attributes;
    private LayoutFieldObject fieldObject;
    private Component wrappedComponent = null;
    private final boolean isRepetition;
    private boolean isNegativeNumber = false;
    private int fmTabIndex = -1;

    public LayoutFieldObjectDelegate(App app, LayoutView layoutView, LayoutFieldObject layoutFieldObject, ObjectMetaData objectMetaData, ObjectAttributes objectAttributes) {
        this.app = app;
        this.view = layoutView;
        this.fieldObject = layoutFieldObject;
        this.metaData = objectMetaData;
        this.attributes = objectAttributes;
        boolean bl = this.isRepetition = objectMetaData.getRepetitionCount() > 1;
        if (this.app.isFormView()) {
            this.view.getUIEventBus().subscribe(layoutFieldObject, EventType.RESET_FIELD_OBJECT);
        }
    }

    public void init(LayoutFieldObject layoutFieldObject) {
        ArrayList<String> arrayList;
        this.wrappedComponent = layoutFieldObject;
        this.setWrappedComponentWidthAndHeight();
        ObjectMetaData objectMetaData = layoutFieldObject.getMetaData();
        String string = objectMetaData.getTypeSelector();
        layoutFieldObject.addStyleName(string);
        if (objectMetaData.hasLocalStyles()) {
            layoutFieldObject.addStyleName(objectMetaData.getUniqueObjectSelector());
        }
        if (objectMetaData.useHandCursor()) {
            layoutFieldObject.addStyleName("hand-cursor");
        }
        if ((arrayList = objectMetaData.getCustomStyles()) != null) {
            for (String string2 : arrayList) {
                layoutFieldObject.addStyleName(string2);
            }
        }
        if (objectMetaData.hasHideCondition()) {
            LayoutObjectUtilities.initHideLayoutObjectAndRepetitions(layoutFieldObject);
        }
    }

    private void setWrappedComponentWidthAndHeight() {
        if (this.isRepetition) {
            if (this.getMetaData().isRepetitionVertical()) {
                this.wrappedComponent.setWidth(100.0f, Sizeable.Unit.PERCENTAGE);
                this.wrappedComponent.setHeight(this.metaData.getHeight());
            } else {
                this.wrappedComponent.setWidth(this.metaData.getWidth());
                this.wrappedComponent.setHeight(100.0f, Sizeable.Unit.PERCENTAGE);
            }
        } else {
            LayoutObjectUtilities.setWidthAndHeight(this.view.isClientSideAutoSizing(), this.metaData, this.wrappedComponent, null);
        }
    }

    public void init(AbstractComponent abstractComponent, AbstractComponent abstractComponent2, AbstractComponent abstractComponent3) {
        if (abstractComponent != null) {
            this.wrappedComponent = abstractComponent;
            if (abstractComponent2 != null) {
                abstractComponent2.setSizeFull();
            }
        } else {
            this.wrappedComponent = abstractComponent2 != null ? abstractComponent2 : this.fieldObject;
        }
        this.setWrappedComponentWidthAndHeight();
        if (abstractComponent3 != null) {
            abstractComponent3.addStyleName("text");
        }
        LayoutObjectUtilities.initCSSStyles(this.fieldObject, abstractComponent, abstractComponent2);
    }

    public void cleanupMemory() {
        if (this.app != null && this.view != null) {
            if (this.view.getUIEventBus() != null) {
                this.view.getUIEventBus().unsubscribe(this.fieldObject, EventType.RESET_FIELD_OBJECT);
            }
            this.app.getActiveUIHandler().cleanupActiveObject(this.fieldObject);
            this.app = null;
            this.view = null;
        }
        if (this.dataEntryHandler != null) {
            this.dataEntryHandler.cleanupMemory();
            this.dataEntryHandler = null;
        }
        this.repetition = null;
        this.metaData = null;
        this.attributes = null;
        this.fieldObject = null;
        this.wrappedComponent = null;
    }

    public Component getWrappedObject() {
        return this.wrappedComponent;
    }

    public boolean hasDataEntryHandler() {
        return this.dataEntryHandler != null;
    }

    public void activateGlassPane() {
        if (this.dataEntryHandler != null) {
            this.dataEntryHandler.activateGlassPane();
        }
    }

    public void deactivateGlassPane() {
        if (this.dataEntryHandler != null) {
            this.dataEntryHandler.deactivateGlassPane();
        }
    }

    public void setGlassPaneParent(AbsoluteCssLayout absoluteCssLayout) {
        if (this.dataEntryHandler == null) {
            this.dataEntryHandler = new GlassPaneHandler(this.fieldObject, absoluteCssLayout);
        }
        this.fieldObject.updateDataEntry(DBAccessLevel.UnknownAccess, true);
    }

    public boolean allowGlassPaneActivation() {
        return !this.fieldObject.getMetaData().hasValidAndExecutableScript();
    }

    public void addCFStyle(String string) {
        this.wrappedComponent.addStyleName(string);
    }

    public void removeCFStyle(String string) {
        this.wrappedComponent.removeStyleName(string);
    }

    public boolean isRepetition() {
        return this.isRepetition;
    }

    public RepetitionContainer getRepetition() {
        return this.repetition;
    }

    public void setRepetition(RepetitionContainer repetitionContainer) {
        this.repetition = repetitionContainer;
    }

    public ObjectMetaData getMetaData() {
        return this.metaData;
    }

    public ObjectAttributes getAttributes() {
        return this.attributes;
    }

    public App getApp() {
        return this.app;
    }

    public void setNegativeNumber(Component component, boolean bl) {
        if (this.isNegativeNumber != bl) {
            this.isNegativeNumber = bl;
            if (this.app.isBrowseMode() && this.metaData.hasNegativeColor() && bl) {
                component.addStyleName("neg-color");
            } else {
                component.removeStyleName("neg-color");
            }
        }
    }

    public boolean isNegativeNumber() {
        return this.isNegativeNumber;
    }

    public void resetNegativeNumberAttributes() {
        this.isNegativeNumber = false;
    }

    public void setWidthAndHeight(LayoutObject layoutObject) {
        boolean bl = true;
        boolean bl2 = true;
        if (this.view.isClientSideAutoSizing()) {
            bl = !this.metaData.isAutoResizeHorizontal();
            boolean bl3 = bl2 = !this.metaData.isAutoResizeVertical();
        }
        if (bl) {
            layoutObject.setWidth(100.0f, Sizeable.Unit.PERCENTAGE);
        }
        if (bl2) {
            layoutObject.setHeight(100.0f, Sizeable.Unit.PERCENTAGE);
        }
    }

    public void updateTabIndex(int n) {
        if (this.fmTabIndex != n) {
            this.view.updateTabIndex(this.fieldObject, this.fmTabIndex, n);
            this.fmTabIndex = n;
        }
    }

    public boolean allowClientSideTabbing() {
        return this.view.allowClientSideTabbing();
    }

    public boolean allowNewLine() {
        switch (this.metaData.getFieldDataType()) {
            case NUMBER: 
            case DATE: 
            case TIME: 
            case TIMESTAMP: {
                return false;
            }
        }
        return true;
    }

    public boolean useWordwrap() {
        switch (this.metaData.getFieldDataType()) {
            case NUMBER: {
                return !this.metaData.hasDataFormatting();
            }
        }
        return true;
    }

    public boolean isActive() {
        if (this.getApp() == null || this.getApp().getActiveUIHandler() == null) {
            return false;
        }
        return this.getApp().getActiveUIHandler().isActiveObject(this.fieldObject);
    }

    public boolean isActiveAndInPopover() {
        return this.isActive() && this.fieldObject.getAttributes().isInPopover();
    }

    public boolean waitForServerOnEnter() {
        return !this.allowClientSideTabbing() || this.getMetaData().hasEnterTriggers() || this.getMetaData().hasDataFormatting() || this.getMetaData().isMergeField();
    }

    public LayoutView getView() {
        return this.view;
    }

    public boolean isKeyStrokeEnabled() {
        return this.view.isKeyStrokeEnabled();
    }

    public boolean hasLayoutKeyStroke() {
        return this.view.hasLayoutKeyStroke();
    }
}

