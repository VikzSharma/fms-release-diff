/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.Component$Focusable
 */
package com.filemaker.jwpc.iwp.xml;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.metadata.DotControlMetaData;
import com.filemaker.jwpc.iwp.metadata.ObjectMetaData;
import com.filemaker.jwpc.iwp.metadata.PanelContainerPanelMetaData;
import com.filemaker.jwpc.iwp.metadata.PartMetaData;
import com.filemaker.jwpc.iwp.metadata.PopoverButtonMetaData;
import com.filemaker.jwpc.iwp.metadata.PopoverMetaData;
import com.filemaker.jwpc.iwp.metadata.PortalMetaData;
import com.filemaker.jwpc.iwp.metadata.RepetitionMetaData;
import com.filemaker.jwpc.iwp.metadata.TabControlMetaData;
import com.filemaker.jwpc.iwp.model.AbstractObjectsModel;
import com.filemaker.jwpc.iwp.model.PartObjectsModel;
import com.filemaker.jwpc.iwp.model.RowFieldObjects;
import com.filemaker.jwpc.iwp.thrift.common.LayoutObjectType;
import com.filemaker.jwpc.iwp.ui.layout.LayoutContainerObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutFieldObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutView;
import com.filemaker.jwpc.iwp.ui.layout.ObjectAttributes;
import com.filemaker.jwpc.iwp.ui.layout.component.AbsoluteCssLayout;
import com.filemaker.jwpc.iwp.ui.layout.component.Body;
import com.filemaker.jwpc.iwp.ui.layout.component.BottomNavigation;
import com.filemaker.jwpc.iwp.ui.layout.component.Button;
import com.filemaker.jwpc.iwp.ui.layout.component.Chart;
import com.filemaker.jwpc.iwp.ui.layout.component.CheckboxSet;
import com.filemaker.jwpc.iwp.ui.layout.component.DropDown;
import com.filemaker.jwpc.iwp.ui.layout.component.EditBox;
import com.filemaker.jwpc.iwp.ui.layout.component.FMCustomDateField;
import com.filemaker.jwpc.iwp.ui.layout.component.Footer;
import com.filemaker.jwpc.iwp.ui.layout.component.Group;
import com.filemaker.jwpc.iwp.ui.layout.component.Header;
import com.filemaker.jwpc.iwp.ui.layout.component.HiddenObject;
import com.filemaker.jwpc.iwp.ui.layout.component.Image;
import com.filemaker.jwpc.iwp.ui.layout.component.Label;
import com.filemaker.jwpc.iwp.ui.layout.component.LayoutPart;
import com.filemaker.jwpc.iwp.ui.layout.component.LeadingGrandSum;
import com.filemaker.jwpc.iwp.ui.layout.component.LeadingSubSum;
import com.filemaker.jwpc.iwp.ui.layout.component.Line;
import com.filemaker.jwpc.iwp.ui.layout.component.ObscuredEditBox;
import com.filemaker.jwpc.iwp.ui.layout.component.Oval;
import com.filemaker.jwpc.iwp.ui.layout.component.Popover;
import com.filemaker.jwpc.iwp.ui.layout.component.Popup;
import com.filemaker.jwpc.iwp.ui.layout.component.RadioSet;
import com.filemaker.jwpc.iwp.ui.layout.component.Rectangle;
import com.filemaker.jwpc.iwp.ui.layout.component.RoundedRectangle;
import com.filemaker.jwpc.iwp.ui.layout.component.SegmentedBar;
import com.filemaker.jwpc.iwp.ui.layout.component.TitleFooter;
import com.filemaker.jwpc.iwp.ui.layout.component.TitleHeader;
import com.filemaker.jwpc.iwp.ui.layout.component.TopNavigation;
import com.filemaker.jwpc.iwp.ui.layout.component.TrailingGrandSum;
import com.filemaker.jwpc.iwp.ui.layout.component.TrailingSubSum;
import com.filemaker.jwpc.iwp.ui.layout.component.WebViewer;
import com.filemaker.jwpc.iwp.ui.layout.component.container.Container;
import com.filemaker.jwpc.iwp.ui.layout.component.panelcontainer.DotControl;
import com.filemaker.jwpc.iwp.ui.layout.component.panelcontainer.DotPanel;
import com.filemaker.jwpc.iwp.ui.layout.component.panelcontainer.PanelContainerControl;
import com.filemaker.jwpc.iwp.ui.layout.component.panelcontainer.TabControl;
import com.filemaker.jwpc.iwp.ui.layout.component.panelcontainer.TabItem;
import com.filemaker.jwpc.iwp.ui.layout.component.popover.PopoverButton;
import com.filemaker.jwpc.iwp.ui.layout.component.portal.Portal;
import com.filemaker.jwpc.iwp.ui.layout.component.portal.PortalRowProperty;
import com.filemaker.jwpc.iwp.ui.layout.component.repetition.HorizontalRepContainer;
import com.filemaker.jwpc.iwp.ui.layout.component.repetition.RepetitionContainer;
import com.filemaker.jwpc.iwp.ui.layout.component.repetition.VerticalRepContainer;
import com.filemaker.jwpc.iwp.util.LayoutObjectUtilities;
import com.filemaker.jwpc.util.Utilities;
import com.vaadin.ui.Component;
import java.util.List;
import java.util.Map;

public final class UIGenerator {
    private final App app;
    private final LayoutView view;

    public UIGenerator(App app, LayoutView layoutView) {
        this.app = app;
        this.view = layoutView;
    }

    public synchronized <T extends LayoutPart> T generateLayoutPartUI(Class<T> clazz, PartObjectsModel partObjectsModel, ObjectMetaData objectMetaData, int n, int n2, int n3) {
        int n4 = objectMetaData.getPartIndex();
        LayoutPart layoutPart = (LayoutPart)this.createLayoutObject(objectMetaData, n4, n, n2, n3, (short)1);
        if (partObjectsModel == null) {
            partObjectsModel = layoutPart.getPartObjectsModel();
        } else {
            layoutPart.setObjectsModel(partObjectsModel);
        }
        this.processObjects(partObjectsModel, layoutPart, objectMetaData.getChilds(), n4, n, n2, n3);
        return (T)layoutPart;
    }

    public synchronized PortalRowProperty generatePortalRowUI(PortalMetaData portalMetaData, Portal portal, int n, int n2, int n3, boolean bl) {
        int n4 = portal.getAttributes().getPartIndex();
        ObjectAttributes objectAttributes = new ObjectAttributes(this.app, portalMetaData, n4, n, n2, n3, 1);
        PortalRowProperty portalRowProperty = new PortalRowProperty(this.app, portalMetaData, portal, objectAttributes, bl);
        this.initComponent(portalRowProperty);
        List<ObjectMetaData> list = portalMetaData.getChilds();
        this.processObjects(portalRowProperty.getPortalObjectsModel(), portalRowProperty, list, n4, n, n2, n3);
        return portalRowProperty;
    }

    public synchronized Popover generatePopoverUI(PopoverMetaData popoverMetaData, int n, int n2, int n3, int n4) {
        ObjectAttributes objectAttributes = new ObjectAttributes(this.app, popoverMetaData, popoverMetaData.getPartIndex(), n2, n3, n4, popoverMetaData.getRepetitionCount());
        Popover popover = new Popover(this.app, this.view, popoverMetaData, objectAttributes, n);
        this.initComponent(popover);
        List<ObjectMetaData> list = popoverMetaData.getChilds();
        this.processObjects(popover.getPopoverObjectsModel(), popover, list, n, n2, n3, n4);
        return popover;
    }

    public RowFieldObjects generateLayoutPartFieldUI(ObjectMetaData objectMetaData, int n, int n2, int n3) {
        RowFieldObjects rowFieldObjects = new RowFieldObjects();
        List<ObjectMetaData> list = objectMetaData.getChilds();
        this.processFieldObjects(rowFieldObjects.getFieldObjects(), list, objectMetaData.getPartIndex(), n, n2, n3);
        return rowFieldObjects;
    }

    private synchronized void processObjects(AbstractObjectsModel abstractObjectsModel, LayoutContainerObject layoutContainerObject, List<ObjectMetaData> list, int n, int n2, int n3, int n4) {
        for (ObjectMetaData objectMetaData : list) {
            HiddenObject hiddenObject;
            if (objectMetaData.isField()) {
                this.createRepetitionObjects(abstractObjectsModel, layoutContainerObject, null, objectMetaData, n, n2, n3, n4);
                continue;
            }
            if (objectMetaData.getType() == LayoutObjectType.POPOVER) continue;
            LayoutObject layoutObject = this.createLayoutObject(objectMetaData, n, n2, n3, n4, (short)1);
            layoutContainerObject.addChild(layoutObject);
            if (abstractObjectsModel != null) {
                abstractObjectsModel.addObject(layoutObject);
            }
            if (objectMetaData.isContainerComponent()) {
                if (objectMetaData.getType() != LayoutObjectType.PORTAL) {
                    this.processObjects(abstractObjectsModel, (LayoutContainerObject)layoutObject, layoutObject.getMetaData().getChilds(), n, n2, n3, n4);
                    continue;
                }
                ((Portal)layoutObject).initPortalRows();
                continue;
            }
            if (objectMetaData.getType() != LayoutObjectType.POPOVER_BUTTON || (hiddenObject = new HiddenObject(objectMetaData)) == null) continue;
            ((PopoverButton)layoutObject).setHiddenObject(hiddenObject);
            layoutContainerObject.addChild(hiddenObject);
        }
        Object object = layoutContainerObject.getMetaData().getType();
        if (object == LayoutObjectType.TAB_CONTROL || object == LayoutObjectType.DOT_CONTROL) {
            ((PanelContainerControl)layoutContainerObject).initTabs();
        }
    }

    private void processFieldObjects(Map<Integer, LayoutFieldObject> map, List<ObjectMetaData> list, int n, int n2, int n3, int n4) {
        for (ObjectMetaData objectMetaData : list) {
            if (objectMetaData.isField()) {
                this.createRepetitionObjects(null, null, map, objectMetaData, n, n2, n3, n4);
                continue;
            }
            if (!objectMetaData.isContainerComponent()) continue;
            this.processFieldObjects(map, objectMetaData.getChilds(), n, n2, n3, n4);
        }
    }

    private void createRepetitionObjects(AbstractObjectsModel abstractObjectsModel, LayoutContainerObject layoutContainerObject, Map<Integer, LayoutFieldObject> map, ObjectMetaData objectMetaData, int n, int n2, int n3, int n4) {
        short s = objectMetaData.getStartRepetition();
        if (objectMetaData.getRepetitionCount() == 1) {
            LayoutFieldObject layoutFieldObject = (LayoutFieldObject)this.createLayoutObject(new RepetitionMetaData(objectMetaData), n, n2, n3, n4, s);
            this.initializeObject(map, abstractObjectsModel, layoutFieldObject, layoutContainerObject, null);
            if (layoutContainerObject != null) {
                layoutContainerObject.addChild(layoutFieldObject);
            }
        } else {
            RepetitionContainer repetitionContainer = objectMetaData.isRepetitionVertical() ? new VerticalRepContainer(this.app, this.view, objectMetaData, n, n2, n3, n4) : new HorizontalRepContainer(this.app, this.view, objectMetaData, n, n2, n3, n4);
            int n5 = objectMetaData.getRepetitionCount();
            int n6 = 0;
            while (n6 < n5) {
                LayoutFieldObject layoutFieldObject = repetitionContainer.createRepetitionObject(this, layoutContainerObject, s, n5, n6);
                this.initializeObject(map, abstractObjectsModel, layoutFieldObject, layoutContainerObject, repetitionContainer);
                ++n6;
                s = (short)(s + 1);
            }
            if (layoutContainerObject != null) {
                repetitionContainer.setVisible(false);
                layoutContainerObject.addChild(repetitionContainer);
            }
        }
    }

    private void initializeObject(Map<Integer, LayoutFieldObject> map, AbstractObjectsModel abstractObjectsModel, LayoutFieldObject layoutFieldObject, LayoutContainerObject layoutContainerObject, AbsoluteCssLayout absoluteCssLayout) {
        if (map != null) {
            map.put(layoutFieldObject.getMetaData().getObjectId(), layoutFieldObject);
        }
        if (abstractObjectsModel != null) {
            abstractObjectsModel.addObject(layoutFieldObject);
        }
        if (layoutContainerObject != null) {
            layoutFieldObject.setParentComponent(layoutContainerObject);
        }
        if (absoluteCssLayout != null) {
            this.setGlassPane(layoutFieldObject, absoluteCssLayout);
        }
    }

    public void setGlassPane(LayoutFieldObject layoutFieldObject, AbsoluteCssLayout absoluteCssLayout) {
        layoutFieldObject.setGlassPaneParent(absoluteCssLayout);
    }

    public LayoutObject createLayoutObject(ObjectMetaData objectMetaData, int n, int n2, int n3, int n4, short s) {
        LayoutObject layoutObject = null;
        ObjectAttributes objectAttributes = new ObjectAttributes(this.app, objectMetaData, n, n2, n3, n4, s);
        switch (objectMetaData.getType()) {
            case TOP_NAV_PART: {
                layoutObject = new TopNavigation(this.app, this.view, objectMetaData, objectAttributes);
                break;
            }
            case TITLE_HEADER: {
                layoutObject = new TitleHeader(this.app, this.view, objectMetaData, objectAttributes);
                break;
            }
            case HEADER: {
                layoutObject = new Header(this.app, this.view, objectMetaData, objectAttributes);
                break;
            }
            case LEADING_GRAND_SUM: {
                layoutObject = new LeadingGrandSum(this.app, this.view, objectMetaData, objectAttributes);
                break;
            }
            case LEADING_SUB_SUM: {
                layoutObject = new LeadingSubSum(this.app, this.view, objectMetaData, objectAttributes);
                break;
            }
            case BODY: {
                layoutObject = new Body(this.app, this.view, (PartMetaData)objectMetaData, objectAttributes);
                break;
            }
            case TRAILING_SUB_SUM: {
                layoutObject = new TrailingSubSum(this.app, this.view, objectMetaData, objectAttributes);
                break;
            }
            case TRAILING_GRAND_SUM: {
                layoutObject = new TrailingGrandSum(this.app, this.view, objectMetaData, objectAttributes);
                break;
            }
            case FOOTER: {
                layoutObject = new Footer(this.app, this.view, objectMetaData, objectAttributes);
                break;
            }
            case TITLE_FOOTER: {
                layoutObject = new TitleFooter(this.app, this.view, objectMetaData, objectAttributes);
                break;
            }
            case BOTTOM_NAV_PART: {
                layoutObject = new BottomNavigation(this.app, this.view, objectMetaData, objectAttributes);
                break;
            }
            case LABEL: {
                layoutObject = new Label(this.app, this.view, objectMetaData, objectAttributes);
                break;
            }
            case TAB_CONTROL: {
                layoutObject = new TabControl(this.app, this.view, (TabControlMetaData)objectMetaData, objectAttributes);
                break;
            }
            case TAB_ITEM: {
                layoutObject = new TabItem(this.app, (PanelContainerPanelMetaData)objectMetaData, objectAttributes);
                break;
            }
            case DOT_CONTROL: {
                layoutObject = new DotControl(this.app, this.view, (DotControlMetaData)objectMetaData, objectAttributes);
                break;
            }
            case DOT_PANEL: {
                layoutObject = new DotPanel(this.app, (PanelContainerPanelMetaData)objectMetaData, objectAttributes);
                break;
            }
            case PORTAL: {
                layoutObject = new Portal(this.app, this.view, (PortalMetaData)objectMetaData, objectAttributes);
                break;
            }
            case EDIT_BOX: {
                layoutObject = new EditBox(this.app, this.view, objectMetaData, objectAttributes);
                break;
            }
            case SECURE_TEXT: {
                layoutObject = new ObscuredEditBox(this.app, this.view, objectMetaData, objectAttributes);
                break;
            }
            case DROP_DOWN: {
                layoutObject = new DropDown(this.app, this.view, objectMetaData, objectAttributes);
                break;
            }
            case POP_UP: {
                layoutObject = new Popup(this.app, this.view, objectMetaData, objectAttributes);
                break;
            }
            case CHECKBOX_SET: {
                layoutObject = new CheckboxSet(this.app, this.view, objectMetaData, objectAttributes);
                break;
            }
            case RADIO_SET: {
                layoutObject = new RadioSet(this.app, this.view, objectMetaData, objectAttributes);
                break;
            }
            case CALENDAR: {
                layoutObject = new FMCustomDateField(this.app, this.view, objectMetaData, objectAttributes);
                break;
            }
            case CONTAINER: {
                layoutObject = new Container(this.app, this.view, objectMetaData, objectAttributes);
                break;
            }
            case BUTTON: {
                layoutObject = new Button(this.app, this.view, objectMetaData, objectAttributes);
                break;
            }
            case POPOVER_BUTTON: {
                layoutObject = new PopoverButton(this.app, this.view, (PopoverButtonMetaData)objectMetaData, objectAttributes);
                break;
            }
            case CHART: {
                layoutObject = new Chart(this.app, objectMetaData, objectAttributes);
                break;
            }
            case WEB_VIEWER: {
                layoutObject = new WebViewer(this.app, this.view, objectMetaData, objectAttributes);
                break;
            }
            case IMAGE: {
                layoutObject = new Image(this.app, objectMetaData, objectAttributes);
                break;
            }
            case LINE: {
                layoutObject = new Line(this.app, this.view, objectMetaData, objectAttributes);
                break;
            }
            case OVAL: {
                layoutObject = new Oval(this.app, this.view, objectMetaData, objectAttributes);
                break;
            }
            case RECTANGLE: {
                layoutObject = new Rectangle(this.app, this.view, objectMetaData, objectAttributes);
                break;
            }
            case ROUNDED_RECTANGLE: {
                layoutObject = new RoundedRectangle(this.app, this.view, objectMetaData, objectAttributes);
                break;
            }
            case GROUP: {
                layoutObject = new Group(this.app, objectMetaData, objectAttributes);
                break;
            }
            case SEGMENTED_BAR: {
                layoutObject = new SegmentedBar(this.app, this.view, objectMetaData, objectAttributes);
                break;
            }
        }
        if (layoutObject != null) {
            this.initComponent(layoutObject);
        }
        return layoutObject;
    }

    private void initComponent(LayoutObject layoutObject) {
        layoutObject.getAttributes().setParent(layoutObject);
        if (layoutObject.getUniqueId() == null) {
            layoutObject.updateUniqueId();
            ObjectMetaData objectMetaData = layoutObject.getMetaData();
            int n = objectMetaData.getTabOrder(layoutObject.getAttributes().getRepetition());
            if (layoutObject instanceof Component.Focusable && n > 0) {
                ((Component.Focusable)layoutObject).setTabIndex(n);
            }
            if (!objectMetaData.hasMergeTooltip()) {
                layoutObject.registerToolTip(Utilities.encodeHTML(objectMetaData.getTooltip()));
            }
            LayoutObjectUtilities.clearConditionalFormattingId(this.app, layoutObject);
            layoutObject.registerAccLabel(Utilities.encodeHTML(objectMetaData.getAccLabel()));
            layoutObject.registerAccTitle(Utilities.encodeHTML(objectMetaData.getAccTitle()));
            layoutObject.registerAccHelp(Utilities.encodeHTML(objectMetaData.getAccHelp()));
        }
    }
}

