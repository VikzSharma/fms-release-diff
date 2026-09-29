/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.ui.ContentMode
 *  com.vaadin.ui.AbstractComponent
 *  com.vaadin.ui.Component
 *  com.vaadin.v7.shared.ui.label.ContentMode
 *  com.vaadin.v7.ui.Label
 */
package com.filemaker.jwpc.iwp.ui.layout.component;

import com.filemaker.jwpc.iwp.action.ActionResultGetterHandler;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.metadata.ObjectMetaData;
import com.filemaker.jwpc.iwp.metadata.PopoverMetaData;
import com.filemaker.jwpc.iwp.model.DataUpdator;
import com.filemaker.jwpc.iwp.model.PopoverObjectsModel;
import com.filemaker.jwpc.iwp.thrift.common.LayoutObjectType;
import com.filemaker.jwpc.iwp.thrift.common.ObjectSpec;
import com.filemaker.jwpc.iwp.thrift.layout.FieldObjectData;
import com.filemaker.jwpc.iwp.thrift.layout.LayoutDataResult;
import com.filemaker.jwpc.iwp.thrift.layout.NonFieldObjectData;
import com.filemaker.jwpc.iwp.thrift.layout.NonFieldObjectsData;
import com.filemaker.jwpc.iwp.thrift.layout.SinglePartObjectsData;
import com.filemaker.jwpc.iwp.thrift.layout.SingleRowPartsData;
import com.filemaker.jwpc.iwp.ui.layout.LayoutObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutView;
import com.filemaker.jwpc.iwp.ui.layout.ObjectAttributes;
import com.filemaker.jwpc.iwp.ui.layout.component.AbsoluteCssLayout;
import com.filemaker.jwpc.iwp.ui.layout.component.AbstractLayout;
import com.filemaker.jwpc.iwp.ui.layout.component.popover.PopoverButton;
import com.filemaker.jwpc.iwp.ui.layout.component.portal.Portal;
import com.filemaker.jwpc.iwp.ui.layout.component.repetition.RepetitionContainer;
import com.filemaker.jwpc.iwp.ui.layout.listener.PopoverLayoutListener;
import com.filemaker.jwpc.iwp.util.LayoutObjectUtilities;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Component;
import com.vaadin.v7.ui.Label;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class Popover
extends AbstractLayout {
    private static final String POPOVER_CONTENTS_CSS_SELECTOR = "contents";
    private static final String POPOVER_TITLE_CSS_SELECTOR = "text";
    private LayoutView view;
    private PopoverLayoutListener layoutListener;
    private PopoverObjectsModel objectsModel;
    private int partIndex;
    private boolean hideConditionOn = false;
    private final Label title;
    private final AbsoluteCssLayout contents;
    private PopoverButton popoverButton;
    private AbstractComponent selfComponent;
    private boolean closed = false;

    public Popover(App app, LayoutView layoutView, PopoverMetaData popoverMetaData, ObjectAttributes objectAttributes, int n) {
        super(app, popoverMetaData, objectAttributes);
        ArrayList<String> arrayList;
        this.view = layoutView;
        this.objectsModel = new PopoverObjectsModel();
        this.layoutListener = new PopoverLayoutListener(app);
        this.partIndex = n;
        this.setHeight(popoverMetaData.getHeight());
        this.setWidth(popoverMetaData.getWidth());
        this.addStyleName("iwps_popover");
        if (popoverMetaData.hasLocalStyles()) {
            this.addStyleName(popoverMetaData.getUniqueObjectSelector());
        }
        if ((arrayList = popoverMetaData.getCustomStyles()) != null) {
            for (String string : arrayList) {
                this.addStyleName(string);
            }
        }
        this.title = new Label(popoverMetaData.getTitle(), com.vaadin.v7.shared.ui.label.ContentMode.HTML);
        this.title.setSizeUndefined();
        this.title.addStyleName(POPOVER_TITLE_CSS_SELECTOR);
        this.addComponent((Component)this.title);
        this.contents = new AbsoluteCssLayout(true);
        this.contents.setSizeUndefined();
        this.contents.addStyleName(POPOVER_CONTENTS_CSS_SELECTOR);
        this.addComponent((Component)this.contents);
        this.setCaption(popoverMetaData.getTitle());
        this.addLayoutClickListener(this.layoutListener);
        this.initUI();
    }

    private void initUI() {
        this.selfComponent = this;
        LayoutObjectUtilities.initCSSStyles(this, this.selfComponent, null);
    }

    @Override
    public void cleanupMemory() {
        super.cleanupMemory();
        if (this.layoutListener != null) {
            this.removeLayoutClickListener(this.layoutListener);
            this.layoutListener = null;
        }
        this.removeAllComponents();
        this.closed = true;
    }

    @Override
    public Component getWrappedObject() {
        return this.selfComponent;
    }

    public void clear(boolean bl) {
    }

    public void setOwningPopoverButton(PopoverButton popoverButton) {
        this.popoverButton = popoverButton;
    }

    public PopoverButton getOwningPopoverButton() {
        return this.popoverButton;
    }

    public Portal getOwningPortal() {
        if (this.popoverButton != null) {
            return this.popoverButton.getOwningPortal();
        }
        return null;
    }

    public void refresh() {
        if (this.app.getPrivileges().hasLayoutAccess() || this.app.getPrivileges().hasBrowseAccess()) {
            this.app.getAppSession().getDataForCurrentPopover(new ActionResultGetterHandler(){

                @Override
                public void onFinish(Object object) {
                    if (!Popover.this.closed) {
                        Popover.this.handleGetDataForCurrentPopoverNotification((LayoutDataResult)object);
                    }
                }
            }, this.partIndex, this.getAttributes().getPortalRecordIndex(), this.getMetaData().getObjectId());
        }
    }

    public void handleGetDataForCurrentPopoverNotification(LayoutDataResult layoutDataResult) {
        int n;
        Map<Integer, SingleRowPartsData> map = layoutDataResult.getLayoutData().getRowsData();
        SingleRowPartsData singleRowPartsData = map.get(n = this.app.getLayoutDataModel().getRecordIndex());
        if (singleRowPartsData != null) {
            for (SinglePartObjectsData singlePartObjectsData : singleRowPartsData.getPartsData()) {
                this.fillPartData(singlePartObjectsData.getFieldObjectsData(), singlePartObjectsData.getNonFieldObjectsData(), layoutDataResult.getLayoutData().getAllPartsNonFieldObjectsData().get(singlePartObjectsData.getPartIndex()));
            }
        }
    }

    private void fillPartData(Map<Integer, FieldObjectData> map, Map<Integer, NonFieldObjectData> map2, NonFieldObjectsData nonFieldObjectsData) {
        DataUpdator dataUpdator = this.view.getDataUpdator();
        if (map != null) {
            dataUpdator.updateFieldObjects(this, map);
        }
        if (map2 != null) {
            dataUpdator.updateNonFieldObjects(this, map2);
            NonFieldObjectData nonFieldObjectData = map2.get(this.getObjectId());
            if (nonFieldObjectData != null) {
                dataUpdator.updateNonFieldObject(this, nonFieldObjectData);
            }
        }
        if (nonFieldObjectsData != null) {
            dataUpdator.updateNonFieldObjects(this, nonFieldObjectsData.getObjects());
        }
    }

    @Override
    public PopoverMetaData getMetaData() {
        return (PopoverMetaData)super.getMetaData();
    }

    public AbsoluteCssLayout getGlassPaneHost() {
        return this.contents;
    }

    @Override
    protected void addChildAsComponent(RepetitionContainer repetitionContainer) {
        if (repetitionContainer != null) {
            ObjectMetaData objectMetaData = repetitionContainer.getMetaData();
            if (!objectMetaData.isInsidePopoverContent()) {
                super.addChildAsComponent(repetitionContainer);
            } else {
                this.contents.addComponent(repetitionContainer.getWrappedObject());
            }
        }
    }

    @Override
    protected void addChildAsComponent(LayoutObject layoutObject, Component component) {
        if (layoutObject != null) {
            ObjectMetaData objectMetaData = layoutObject.getMetaData();
            if (!objectMetaData.isInsidePopoverContent()) {
                super.addChildAsComponent(layoutObject, component);
            } else if (component == null) {
                this.contents.addComponent(layoutObject.getWrappedObject());
            } else {
                this.contents.addComponent(component);
            }
        }
    }

    @Override
    public void updateLayoutObjectData(Object object, boolean bl) {
        this.title.setValue((String)object);
    }

    @Override
    public void registerToolTip(String string) {
        this.setDescription(string, ContentMode.HTML);
    }

    @Override
    public Object getValue() {
        return this;
    }

    public PopoverObjectsModel getPopoverObjectsModel() {
        return this.objectsModel;
    }

    @Override
    public LayoutObject getLayoutObject(ObjectSpec objectSpec) {
        return this.objectsModel.getLayoutObject(this.app, objectSpec);
    }

    public LayoutObject getLayoutObject(int n, LayoutObjectType layoutObjectType, short s, int n2, int n3) {
        return this.objectsModel.getLayoutObject(n, layoutObjectType, s, n2, n3);
    }

    public Collection<LayoutObject> getLayoutObjects() {
        return this.objectsModel.getLayoutObjects();
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
        this.addStyleName(string);
    }

    @Override
    public void removeCFStyle(String string) {
        this.removeStyleName(string);
    }

    @Override
    public void registerAccTitle(String string) {
    }

    @Override
    public void registerAccHelp(String string) {
    }

    @Override
    public void registerAccLabel(String string) {
    }
}

