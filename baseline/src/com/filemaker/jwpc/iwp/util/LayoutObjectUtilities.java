/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.server.Sizeable$Unit
 *  com.vaadin.ui.AbstractComponent
 *  com.vaadin.ui.Component
 *  com.vaadin.ui.Embedded
 */
package com.filemaker.jwpc.iwp.util;

import com.filemaker.jwpc.iwp.action.ActionResultGetterHandler;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.metadata.ObjectMetaData;
import com.filemaker.jwpc.iwp.model.LayoutViewModel;
import com.filemaker.jwpc.iwp.thrift.common.BinaryData;
import com.filemaker.jwpc.iwp.thrift.common.BinaryDataOptions;
import com.filemaker.jwpc.iwp.thrift.common.CFObject;
import com.filemaker.jwpc.iwp.thrift.common.DBAccessLevel;
import com.filemaker.jwpc.iwp.thrift.common.LayoutObjectType;
import com.filemaker.jwpc.iwp.thrift.layout.DataType;
import com.filemaker.jwpc.iwp.thrift.layout.FieldObjectData;
import com.filemaker.jwpc.iwp.ui.component.ZoomImageWindow;
import com.filemaker.jwpc.iwp.ui.layout.LayoutFieldObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutObject;
import com.filemaker.jwpc.iwp.ui.layout.component.popover.PopoverButton;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.filemaker.jwpc.util.Utilities;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Component;
import com.vaadin.ui.Embedded;
import java.util.ArrayList;
import java.util.Iterator;

public final class LayoutObjectUtilities {
    public static void updateCSSForConditionalFormatting(App app, LayoutObject layoutObject, CFObject cFObject) {
        if (layoutObject.getMetaData().hasConditionalFormatting()) {
            String string = layoutObject.getAttributes().getCFId();
            String string2 = null;
            String string3 = cFObject.getCfId();
            if (!Utilities.isEmptyString(string3)) {
                string2 = LayoutObjectUtilities.generateCFId(app, layoutObject, cFObject);
                cFObject.setCfId(string2);
            }
            boolean bl = false;
            if (string2 != null) {
                bl = !string2.equals(string);
            } else if (string != null) {
                boolean bl2 = bl = !string.equals(string2);
            }
            if (bl) {
                if (string != null) {
                    LayoutObjectUtilities.clearConditionalFormattingId(app, layoutObject);
                }
                if (string2 != null) {
                    LayoutObjectUtilities.setConditionalFormattingId(app, layoutObject, cFObject);
                }
            }
        }
    }

    public static void clearConditionalFormattingId(App app, LayoutObject layoutObject) {
        LayoutObjectUtilities.clearConditionalFormattingIdInternal(app, layoutObject);
        app.getLayoutContainer().getCurrentView().getViewModel().removeCFLayoutObject(layoutObject);
    }

    private static void clearConditionalFormattingIdInternal(App app, LayoutObject layoutObject) {
        if (layoutObject instanceof LayoutFieldObject && !((LayoutFieldObject)layoutObject).hasDelegate()) {
            return;
        }
        LayoutViewModel layoutViewModel = app.getLayoutContainer().getCurrentView().getViewModel();
        CFObject cFObject = layoutViewModel.getObjectsToCFMap().get(layoutObject);
        if (cFObject != null) {
            for (Integer n : cFObject.getCfIndices()) {
                layoutObject.removeCFStyle(IWPUtilities.generateCFId(n));
            }
        }
        layoutObject.getAttributes().setCFId(null);
    }

    public static void clearAllConditionalFormattingIds(App app) {
        LayoutViewModel layoutViewModel = app.getLayoutContainer().getCurrentView().getViewModel();
        for (LayoutObject layoutObject : layoutViewModel.getObjectsToCFMap().keySet()) {
            LayoutObjectUtilities.clearConditionalFormattingIdInternal(app, layoutObject);
        }
        layoutViewModel.clearAllCFLayoutObjects();
    }

    private static void setConditionalFormattingId(App app, LayoutObject layoutObject, CFObject cFObject) {
        if (layoutObject instanceof LayoutFieldObject && !((LayoutFieldObject)layoutObject).hasDelegate()) {
            return;
        }
        LayoutViewModel layoutViewModel = app.getLayoutContainer().getCurrentView().getViewModel();
        layoutViewModel.addCFLayoutObject(layoutObject, cFObject);
        String string = null;
        if (cFObject != null) {
            string = cFObject.getCfId();
            for (Integer n : cFObject.getCfIndices()) {
                layoutObject.addCFStyle(IWPUtilities.generateCFId(n));
            }
        }
        layoutObject.getAttributes().setCFId(string);
    }

    private static String generateCFId(App app, LayoutObject layoutObject, CFObject cFObject) {
        int n = app.getLayoutContainer().getLayoutId();
        long l = app.getLayoutContainer().getCurrentView().getLayoutMetaData().getModCount();
        String string = cFObject.getCfId();
        return layoutObject.getUniqueId() + "-l" + n + "-m" + l + "-cf" + string;
    }

    public static void updateFieldObjectData(final App app, final LayoutFieldObject layoutFieldObject) {
        BinaryDataOptions binaryDataOptions = new BinaryDataOptions();
        app.getAppSession().getFieldObjectData(new ActionResultGetterHandler(){

            @Override
            public void onFinish(Object object) {
                if (layoutFieldObject.hasDelegate()) {
                    LayoutObjectUtilities.handleGetFieldObjectDataNotification(app, layoutFieldObject, false, (FieldObjectData)object);
                }
            }
        }, layoutFieldObject.getAttributes().getObjectSpec(), layoutFieldObject.getAttributes().getFieldSpec(), binaryDataOptions, false);
    }

    public static void handleGetFieldObjectDataNotification(App app, LayoutFieldObject layoutFieldObject, boolean bl, FieldObjectData fieldObjectData) {
        if (bl) {
            int n = 0;
            int n2 = 0;
            Embedded embedded = new Embedded();
            FieldObjectData fieldObjectData2 = fieldObjectData;
            BinaryData binaryData = LayoutObjectUtilities.getBinaryDataFromFieldData(fieldObjectData2);
            IWPUtilities.constructImageResource((AbstractComponent)embedded, binaryData);
            n = binaryData.getImageHeight();
            n2 = binaryData.getImageWidth();
            ZoomImageWindow zoomImageWindow = new ZoomImageWindow(app, embedded, binaryData.getName(), n, n2, binaryData.getData().length);
            zoomImageWindow.showDialog();
            zoomImageWindow.setClosable(true);
            zoomImageWindow.focus();
        } else {
            app.getLayoutContainer().getCurrentView().getDataUpdator().updateFieldObject(layoutFieldObject, fieldObjectData, true, false);
        }
    }

    private static BinaryData getBinaryDataFromFieldData(FieldObjectData fieldObjectData) {
        BinaryData binaryData = null;
        if (fieldObjectData != null && fieldObjectData.getFieldData().getDataType() == DataType.BINARY && !(binaryData = fieldObjectData.getFieldData().getData().getBinaryValue()).isValid()) {
            binaryData = null;
        }
        return binaryData;
    }

    public static boolean allowDataEntry(App app, LayoutFieldObject layoutFieldObject, DBAccessLevel dBAccessLevel) {
        boolean bl = false;
        ObjectMetaData objectMetaData = layoutFieldObject.getMetaData();
        if (app.hasLayoutMode()) {
            if (app.isBrowseMode()) {
                if (objectMetaData.isGlobalField()) {
                    bl = true;
                } else if (app.getLayoutDataModel().getFoundRecords() > 0) {
                    bl = objectMetaData.allowBrowseDataEntry();
                }
            } else {
                switch (objectMetaData.getFieldType()) {
                    case CALCULATED: 
                    case NORMAL: {
                        bl = objectMetaData.allowFindDataEntry();
                        break;
                    }
                }
            }
        }
        if (bl && dBAccessLevel != DBAccessLevel.UnknownAccess && dBAccessLevel != DBAccessLevel.ReadWrite) {
            bl = false;
        }
        return bl;
    }

    public static LayoutObject getLayoutObject(Component component) {
        Component component2;
        for (component2 = component; component2 != null && !(component2 instanceof LayoutObject); component2 = component2.getParent()) {
        }
        return (LayoutObject)component2;
    }

    public static boolean isAncestor(LayoutObject layoutObject, LayoutObject layoutObject2) {
        boolean bl = false;
        for (LayoutObject layoutObject3 = layoutObject; layoutObject3 != null; layoutObject3 = layoutObject3.getParent()) {
            if (!(layoutObject3 instanceof LayoutObject) || layoutObject3 != layoutObject2) continue;
            bl = true;
            break;
        }
        return bl;
    }

    public static void initCSSStyles(LayoutObject layoutObject, AbstractComponent abstractComponent, AbstractComponent abstractComponent2) {
        if (abstractComponent != null) {
            boolean bl;
            Object object;
            ObjectMetaData objectMetaData = layoutObject.getMetaData();
            if (objectMetaData.getType() != LayoutObjectType.BODY) {
                object = objectMetaData.getTypeSelector();
                abstractComponent.addStyleName((String)object);
            }
            if (objectMetaData.hasLocalStyles()) {
                abstractComponent.addStyleName(objectMetaData.getUniqueObjectSelector());
            }
            if (objectMetaData.useHandCursor() && objectMetaData.getType() != LayoutObjectType.GROUP && objectMetaData.getType() != LayoutObjectType.SEGMENTED_BAR) {
                abstractComponent.addStyleName("hand-cursor");
            }
            if ((object = objectMetaData.getCustomStyles()) != null) {
                Iterator iterator = ((ArrayList)object).iterator();
                while (iterator.hasNext()) {
                    String string = (String)iterator.next();
                    abstractComponent.addStyleName(string);
                }
            }
            if ((bl = objectMetaData.hasHideCondition()) && !objectMetaData.isPortal() && objectMetaData.getType() != LayoutObjectType.TAB_ITEM) {
                LayoutObjectUtilities.initHideLayoutObjectAndRepetitions(layoutObject);
            }
        }
        if (abstractComponent2 != null) {
            abstractComponent2.addStyleName("inner_border");
        }
    }

    public static void setWidthAndHeight(boolean bl, ObjectMetaData objectMetaData, Component component, Component component2) {
        if (component != null) {
            boolean bl2 = true;
            boolean bl3 = true;
            if (bl) {
                bl2 = !objectMetaData.isAutoResizeHorizontal();
                boolean bl4 = bl3 = !objectMetaData.isAutoResizeVertical();
                if (objectMetaData.getType() == LayoutObjectType.GROUP) {
                    component.setSizeUndefined();
                }
            }
            if (bl2) {
                component.setWidth(objectMetaData.getWidth());
                if (component2 != null) {
                    component2.setWidth(100.0f, Sizeable.Unit.PERCENTAGE);
                }
            }
            if (bl3) {
                component.setHeight(objectMetaData.getHeight());
                if (component2 != null) {
                    component2.setHeight(100.0f, Sizeable.Unit.PERCENTAGE);
                }
            }
        }
    }

    public static void initHideLayoutObjectAndRepetitions(LayoutObject layoutObject) {
        if (layoutObject.getMetaData().getRepetitionCount() > 1) {
            layoutObject.setHideConditionOn(true);
        } else {
            LayoutObjectUtilities.setVisibie(layoutObject, false);
            layoutObject.setHideConditionOn(true);
        }
    }

    public static void setVisibie(LayoutObject layoutObject, boolean bl) {
        PopoverButton popoverButton;
        layoutObject.getWrappedObject().setVisible(bl);
        if (layoutObject.getMetaData().getType() == LayoutObjectType.POPOVER_BUTTON && (popoverButton = (PopoverButton)layoutObject).getHiddenObject() != null) {
            popoverButton.getHiddenObject().setVisible(!bl);
        }
    }
}

