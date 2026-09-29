/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.filemaker.jwpc.fmwp.datatype.ErrorCode
 */
package com.filemaker.jwpc.iwp.model;

import com.filemaker.jwpc.fmwp.datatype.ErrorCode;
import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.thrift.common.BinaryData;
import com.filemaker.jwpc.iwp.thrift.common.CFObject;
import com.filemaker.jwpc.iwp.thrift.common.DBAccessLevel;
import com.filemaker.jwpc.iwp.thrift.common.LayoutFieldDataType;
import com.filemaker.jwpc.iwp.thrift.common.ObjectSpec;
import com.filemaker.jwpc.iwp.thrift.common.StringData;
import com.filemaker.jwpc.iwp.thrift.layout.FieldData;
import com.filemaker.jwpc.iwp.thrift.layout.FieldObjectData;
import com.filemaker.jwpc.iwp.thrift.layout.NonFieldObjectData;
import com.filemaker.jwpc.iwp.ui.layout.LayoutFieldObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutTextFieldObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutView;
import com.filemaker.jwpc.iwp.ui.layout.component.AbstractLayout;
import com.filemaker.jwpc.iwp.ui.layout.component.Button;
import com.filemaker.jwpc.iwp.ui.layout.component.ObscuredEditBox;
import com.filemaker.jwpc.iwp.ui.layout.component.RadioSet;
import com.filemaker.jwpc.iwp.ui.layout.component.SegmentedBar;
import com.filemaker.jwpc.iwp.ui.layout.component.StringDataUpdateParameters;
import com.filemaker.jwpc.iwp.ui.layout.component.WebViewer;
import com.filemaker.jwpc.iwp.ui.layout.component.container.Container;
import com.filemaker.jwpc.iwp.ui.layout.component.panelcontainer.TabItem;
import com.filemaker.jwpc.iwp.ui.layout.component.portal.PortalRowProperty;
import com.filemaker.jwpc.iwp.ui.layout.component.repetition.RepetitionContainer;
import com.filemaker.jwpc.iwp.util.LayoutObjectUtilities;
import com.filemaker.jwpc.util.Utilities;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;

public final class DataUpdator {
    private WeakReference<App> app;
    private WeakReference<LayoutView> currentView;

    public DataUpdator(WeakReference<App> weakReference, WeakReference<LayoutView> weakReference2) {
        this.app = weakReference;
        this.currentView = weakReference2;
    }

    public void updateFieldObject(FieldObjectData fieldObjectData) {
        LayoutFieldObject layoutFieldObject = (LayoutFieldObject)((LayoutView)this.currentView.get()).getLayoutObject(fieldObjectData.getObjectSpec());
        if (layoutFieldObject != null) {
            this.updateFieldObject(layoutFieldObject, fieldObjectData, false, true);
        }
    }

    public void updateFieldObjects(AbstractLayout abstractLayout, Map<Integer, FieldObjectData> map) {
        LayoutFieldObject layoutFieldObject = null;
        for (FieldObjectData fieldObjectData : map.values()) {
            FieldObjectData fieldObjectData2;
            LayoutObject layoutObject = abstractLayout.getLayoutObject(fieldObjectData.getObjectSpec());
            layoutFieldObject = LayoutFieldObject.class.isInstance(layoutObject) ? (LayoutFieldObject)layoutObject : null;
            if (layoutFieldObject == null || (fieldObjectData2 = map.get(fieldObjectData.getObjectSpec().getObjectId())) == null) continue;
            this.updateFieldObject(layoutFieldObject, fieldObjectData2, false, true);
        }
    }

    public void updateFieldObjects(Map<Integer, FieldObjectData> map) {
        for (FieldObjectData fieldObjectData : map.values()) {
            FieldObjectData fieldObjectData2;
            LayoutFieldObject layoutFieldObject = (LayoutFieldObject)((LayoutView)this.currentView.get()).getLayoutObject(fieldObjectData.getObjectSpec());
            if (layoutFieldObject == null || (fieldObjectData2 = map.get(fieldObjectData.getObjectSpec().getObjectId())) == null) continue;
            this.updateFieldObject(layoutFieldObject, fieldObjectData2, false, true);
        }
    }

    public void updateFieldObject(LayoutFieldObject layoutFieldObject, FieldObjectData fieldObjectData, boolean bl, boolean bl2) {
        FieldData fieldData = fieldObjectData.getFieldData();
        if (fieldData != null) {
            boolean bl3 = true;
            if (bl) {
                boolean bl4 = bl3 = layoutFieldObject.getAttributes().getRecordIndex() == fieldObjectData.getObjectSpec().getRowIndex() && layoutFieldObject.getAttributes().getRowId() == fieldObjectData.getObjectSpec().getRowId() && layoutFieldObject.getAttributes().getPortalRecordIndex() == fieldObjectData.getObjectSpec().getPortalRowIndex() && layoutFieldObject.getAttributes().getRepetition() == fieldObjectData.getObjectSpec().getRepetition();
            }
            if (bl3) {
                this.updateFieldHideCondition(layoutFieldObject, fieldData.isHideConditionOn(), true);
                this.updateFieldHideZeroesFormat(layoutFieldObject, fieldData.isHideZeroesOn());
                if (fieldData.isValueListDataIncluded()) {
                    this.processFieldData(layoutFieldObject, fieldData, false);
                } else {
                    this.processFieldData(layoutFieldObject, fieldData, bl2);
                }
            }
        }
    }

    private boolean needToToggleHideCondition(LayoutObject layoutObject, boolean bl) {
        return layoutObject.isHideConditionOn() != bl;
    }

    public void updateFieldHideCondition(LayoutObject layoutObject, boolean bl, boolean bl2) {
        LayoutObject layoutObject2;
        boolean bl3 = false;
        if (layoutObject instanceof TabItem) {
            layoutObject2 = (LayoutObject)layoutObject.getParent();
            if (layoutObject2 != null) {
                layoutObject = layoutObject2;
            } else {
                return;
            }
        }
        if (bl3 = bl2 ? this.isHideConditionActive(layoutObject) : this.isHideConditionActiveForNonFieldObject(layoutObject)) {
            if (this.needToToggleHideCondition(layoutObject, bl)) {
                if (bl) {
                    layoutObject2 = ((App)((Object)this.app.get())).getActiveUIHandler().getActiveField(false, true);
                    if (layoutObject2 != null && layoutObject2 instanceof LayoutTextFieldObject && LayoutObjectUtilities.isAncestor(layoutObject2, layoutObject)) {
                        ((App)((Object)this.app.get())).getActiveUIHandler().setPendingHideObject(layoutObject);
                        this.hideLayoutObjectAndRepetitions(layoutObject, false);
                    } else {
                        this.hideLayoutObjectAndRepetitions(layoutObject, true);
                    }
                } else {
                    this.showLayoutObjectAndRepetitions(layoutObject);
                }
            }
        } else if (!layoutObject.getWrappedObject().isVisible() || layoutObject.getWrappedObject().getParent() instanceof RepetitionContainer) {
            this.showLayoutObjectAndRepetitions(layoutObject);
        }
    }

    public void updateFieldHideZeroesFormat(LayoutFieldObject layoutFieldObject, boolean bl) {
        if (layoutFieldObject.getMetaData().getFieldDataType() == LayoutFieldDataType.NUMBER && layoutFieldObject instanceof LayoutTextFieldObject) {
            ((LayoutTextFieldObject)layoutFieldObject).setHideZeroesOn(bl);
        }
    }

    private void showLayoutObjectAndRepetitions(LayoutObject layoutObject) {
        if (layoutObject.getWrappedObject().getParent() instanceof RepetitionContainer) {
            RepetitionContainer repetitionContainer = (RepetitionContainer)layoutObject.getWrappedObject().getParent();
            repetitionContainer.setVisible(true);
            layoutObject.setHideConditionOn(false);
            layoutObject.setEnabled(true);
        } else {
            layoutObject.getWrappedObject().setVisible(true);
            layoutObject.setHideConditionOn(false);
            layoutObject.setEnabled(true);
        }
    }

    public void hideLayoutObjectAndRepetitions(LayoutObject layoutObject, boolean bl) {
        if (bl) {
            if (layoutObject.getWrappedObject().getParent() instanceof RepetitionContainer) {
                RepetitionContainer repetitionContainer = (RepetitionContainer)layoutObject.getWrappedObject().getParent();
                repetitionContainer.setVisible(false);
            } else {
                layoutObject.getWrappedObject().setVisible(false);
            }
        }
        layoutObject.setHideConditionOn(true);
    }

    protected boolean isHideConditionActive(LayoutObject layoutObject) {
        return !((App)((Object)this.app.get())).isFindMode() && layoutObject.hasHideCondition() || ((App)((Object)this.app.get())).isFindMode() && layoutObject.hasHideConditionInFindMode();
    }

    protected boolean isHideConditionActiveForNonFieldObject(LayoutObject layoutObject) {
        return !((App)((Object)this.app.get())).isFindMode() && layoutObject.hasHideCondition() || ((App)((Object)this.app.get())).isFindMode() && layoutObject.hasHideConditionInFindMode();
    }

    public void updateNonFieldObjects(AbstractLayout abstractLayout, Map<Integer, NonFieldObjectData> map) {
        if (map != null) {
            ArrayList<SegmentedBar> arrayList = null;
            for (NonFieldObjectData object : map.values()) {
                LayoutObject layoutObject = abstractLayout.getLayoutObject(this.getObjectSpec(object, abstractLayout.getAttributes().getRecordIndex(), abstractLayout.getAttributes().getRowId(), abstractLayout.getAttributes().getPortalRecordIndex()));
                if (layoutObject == null) continue;
                NonFieldObjectData nonFieldObjectData = map.get(object.getObjectId());
                if (nonFieldObjectData != null) {
                    this.updateNonFieldObject(layoutObject, nonFieldObjectData);
                }
                if (!(layoutObject instanceof SegmentedBar)) continue;
                if (arrayList == null) {
                    arrayList = new ArrayList<SegmentedBar>();
                }
                arrayList.add((SegmentedBar)layoutObject);
            }
            if (arrayList != null) {
                for (SegmentedBar segmentedBar : arrayList) {
                    segmentedBar.rebuildSegmentsIfNeeded();
                }
            }
        }
    }

    public void updateNonFieldObjects(int n, int n2, Map<Integer, NonFieldObjectData> map) {
        if (map != null) {
            ArrayList<SegmentedBar> arrayList = null;
            int n3 = 0;
            for (NonFieldObjectData object : map.values()) {
                LayoutObject layoutObject = ((LayoutView)this.currentView.get()).getLayoutObject(this.getObjectSpec(object, n, n2, n3));
                if (layoutObject == null) continue;
                NonFieldObjectData nonFieldObjectData = map.get(object.getObjectId());
                if (nonFieldObjectData != null) {
                    this.updateNonFieldObject(layoutObject, nonFieldObjectData);
                }
                if (!(layoutObject instanceof SegmentedBar)) continue;
                if (arrayList == null) {
                    arrayList = new ArrayList<SegmentedBar>();
                }
                arrayList.add((SegmentedBar)layoutObject);
            }
            if (arrayList != null) {
                for (SegmentedBar segmentedBar : arrayList) {
                    segmentedBar.rebuildSegmentsIfNeeded();
                }
            }
        }
    }

    public void updateWebViewer(AbstractLayout abstractLayout, NonFieldObjectData nonFieldObjectData) {
        LayoutObject layoutObject = abstractLayout.getLayoutObject(this.getObjectSpec(nonFieldObjectData, abstractLayout.getAttributes().getRecordIndex(), abstractLayout.getAttributes().getRowId(), abstractLayout.getAttributes().getPortalRecordIndex()));
        if (layoutObject != null && layoutObject instanceof WebViewer) {
            ((WebViewer)layoutObject).setWebViewer(nonFieldObjectData.getData().getStringValue().getValue());
        }
    }

    public void updateWebViewer(int n, int n2, NonFieldObjectData nonFieldObjectData) {
        int n3 = 0;
        ObjectSpec objectSpec = this.getObjectSpec(nonFieldObjectData, n, n2, n3);
        LayoutObject layoutObject = ((LayoutView)this.currentView.get()).getLayoutObject(objectSpec);
        if (layoutObject != null && layoutObject instanceof WebViewer) {
            ((WebViewer)layoutObject).setWebViewer(nonFieldObjectData.getData().getStringValue().getValue());
        }
    }

    public void updateNonFieldObject(LayoutObject layoutObject, NonFieldObjectData nonFieldObjectData) {
        this.processStaticData(layoutObject, nonFieldObjectData);
    }

    public void updatePortalFieldObjects(PortalRowProperty portalRowProperty, Map<Integer, FieldObjectData> map) {
        for (FieldObjectData fieldObjectData : map.values()) {
            FieldObjectData fieldObjectData2;
            LayoutFieldObject layoutFieldObject = (LayoutFieldObject)portalRowProperty.getLayoutObject(fieldObjectData.getObjectSpec());
            if (layoutFieldObject == null || (fieldObjectData2 = map.get(fieldObjectData.getObjectSpec().getObjectId())) == null) continue;
            this.updateFieldObject(layoutFieldObject, fieldObjectData2, false, true);
        }
    }

    public void updatePortalNonFieldObjects(PortalRowProperty portalRowProperty, Map<Integer, NonFieldObjectData> map) {
        for (NonFieldObjectData nonFieldObjectData : map.values()) {
            LayoutObject layoutObject = portalRowProperty.getLayoutObject(nonFieldObjectData.getObjectId(), (short)1);
            if (layoutObject == null) continue;
            NonFieldObjectData nonFieldObjectData2 = map.get(nonFieldObjectData.getObjectId());
            if (nonFieldObjectData2 != null) {
                this.updateNonFieldObject(layoutObject, nonFieldObjectData2);
            }
            if (!(layoutObject instanceof SegmentedBar)) continue;
            ((SegmentedBar)layoutObject).rebuildSegmentsIfNeeded();
        }
    }

    private ObjectSpec getObjectSpec(NonFieldObjectData nonFieldObjectData, int n, int n2, int n3) {
        ObjectSpec objectSpec = new ObjectSpec();
        objectSpec.setObjectId(nonFieldObjectData.getObjectId());
        objectSpec.setParentPortalId(nonFieldObjectData.getPortalId());
        objectSpec.setPortalRowIndex(n3);
        objectSpec.setRowIndex(n);
        objectSpec.setRowId(n2);
        objectSpec.setRepetition((short)1);
        objectSpec.setParentPopoverId(nonFieldObjectData.getPopoverId());
        return objectSpec;
    }

    private void processFieldData(LayoutFieldObject layoutFieldObject, FieldData fieldData, boolean bl) {
        switch (fieldData.getDataType()) {
            case STRING_REPETITION: {
                this.updateStringRepetition(layoutFieldObject, fieldData, bl);
                break;
            }
            case BINARY_REPETITION: {
                if (!layoutFieldObject.getMetaData().isContainer()) break;
                this.updateBinaryRepetition((Container)layoutFieldObject, fieldData);
                break;
            }
            case BINARY: {
                if (!layoutFieldObject.getMetaData().isContainer()) break;
                this.updateBinaryData((Container)layoutFieldObject, fieldData.getFieldAccess(), fieldData.getData().getBinaryValue(), false);
                break;
            }
            case STRING: {
                if (layoutFieldObject instanceof RadioSet && fieldData.isValueListDataIncluded()) {
                    RadioSet radioSet = (RadioSet)layoutFieldObject;
                    StringDataUpdateParameters stringDataUpdateParameters = new StringDataUpdateParameters(fieldData.getData().getStringValue(), fieldData.getFieldAccess(), true, false, "", false, fieldData.isUpdateSelection(), fieldData.getSelectionStart(), fieldData.getSelectionEnd(), fieldData.isStreamOn());
                    radioSet.instantiateContainer(stringDataUpdateParameters, fieldData.getValueListData());
                }
                this.updateStringData(layoutFieldObject, fieldData.getFieldAccess(), fieldData.getData().getStringValue(), fieldData.isUpdateSelection(), fieldData.getSelectionStart(), fieldData.getSelectionEnd(), bl, fieldData.isStreamOn());
                break;
            }
            default: {
                if (!ErrorCode.hasError((int)fieldData.getErrorCode())) break;
                this.updateErrorData(layoutFieldObject, fieldData.getFieldAccess(), fieldData.getErrorMessage(), bl);
            }
        }
        this.updateDependentUIDataForFieldLayoutObject(layoutFieldObject, fieldData);
    }

    private void processStaticData(LayoutObject layoutObject, NonFieldObjectData nonFieldObjectData) {
        try {
            this.updateDependentUIDataForNonFieldLayoutObject(layoutObject, nonFieldObjectData);
            switch (nonFieldObjectData.getDataType()) {
                case BINARY: {
                    layoutObject.updateLayoutObjectData(nonFieldObjectData.getData().getBinaryValue(), true);
                    break;
                }
                case STRING: {
                    if (layoutObject instanceof Button) {
                        layoutObject.updateLayoutObjectData(nonFieldObjectData, true);
                        break;
                    }
                    layoutObject.updateLayoutObjectData(nonFieldObjectData.getData().getStringValue().getValue(), true);
                    break;
                }
                case STRING_LAYOUTOBJECTS: {
                    layoutObject.updateLayoutObjectData(nonFieldObjectData.getData().getStringValues(), true);
                    break;
                }
            }
        }
        catch (UnsupportedOperationException unsupportedOperationException) {
            System.out.println("Unsupported updateLayoutObjectData on " + String.valueOf(layoutObject));
        }
    }

    private void updateDependentUIDataForNonFieldLayoutObject(LayoutObject layoutObject, NonFieldObjectData nonFieldObjectData) {
        if (layoutObject.getMetaData().hasMergeTooltip()) {
            layoutObject.registerToolTip(Utilities.encodeHTML(nonFieldObjectData.getTooltip()));
        }
        if (layoutObject.getMetaData().hasConditionalFormatting()) {
            LayoutObjectUtilities.updateCSSForConditionalFormatting((App)((Object)this.app.get()), layoutObject, nonFieldObjectData.getConditionalFormatting());
        }
        if (nonFieldObjectData.isHideConditionCalculated()) {
            this.updateFieldHideCondition(layoutObject, nonFieldObjectData.isHideConditionOn(), false);
        }
    }

    private void updateDependentUIDataForFieldLayoutObject(LayoutFieldObject layoutFieldObject, FieldData fieldData) {
        Object object;
        Map<Short, Object> map;
        if (layoutFieldObject.getMetaData().hasMergeTooltip()) {
            map = fieldData.getTooltipValues();
            for (Short object22 : map.keySet()) {
                object = layoutFieldObject.getRepetitionObject(object22);
                if (object == null) continue;
                object.registerToolTip(Utilities.encodeHTML((String)map.get(object22)));
            }
        }
        if (layoutFieldObject.getMetaData().hasConditionalFormatting()) {
            map = fieldData.getConditionalFormattingValues();
            for (Short s : map.keySet()) {
                object = layoutFieldObject.getRepetitionObject(s);
                if (object == null) continue;
                LayoutObjectUtilities.updateCSSForConditionalFormatting((App)((Object)this.app.get()), (LayoutObject)object, (CFObject)map.get(s));
            }
        }
        map = fieldData.getPlaceholderTextValues();
        for (Short s : map.keySet()) {
            object = layoutFieldObject.getRepetitionObject(s);
            if (object == null) continue;
            String string = (String)map.get(s);
            object.setPlaceholderText(string);
            if (!this.isObscuredFieldErrorDisplay((LayoutObject)object, fieldData.getErrorMessage())) continue;
            ((ObscuredEditBox)object).onErrorMessageDisplay();
        }
        Map<Short, String> map2 = fieldData.getAccTitleValues();
        Map<Short, String> map3 = fieldData.getAccHelpValues();
        object = fieldData.getAccLabelValues();
        for (Short s : map2.keySet()) {
            LayoutFieldObject layoutFieldObject2 = layoutFieldObject.getRepetitionObject(s);
            if (layoutFieldObject2 == null) continue;
            Object object2 = "";
            String string = (String)object.get(s);
            String string2 = (String)map2.get(s);
            String string3 = map3.get(s);
            if (string != null && !string.isEmpty()) {
                object2 = (String)object2 + string;
            }
            if (string2 != null && !string2.isEmpty()) {
                object2 = (String)object2 + (((String)object2).isEmpty() ? "" : ", ") + string2;
            }
            if (string3 != null && !string3.isEmpty()) {
                object2 = (String)object2 + (((String)object2).isEmpty() ? "" : ", ") + string3;
            }
            layoutFieldObject2.registerAccTitle(Utilities.encodeHTML((String)object2));
        }
    }

    private void updateStringData(LayoutFieldObject layoutFieldObject, DBAccessLevel dBAccessLevel, StringData stringData, boolean bl, int n, int n2, boolean bl2, boolean bl3) {
        StringDataUpdateParameters stringDataUpdateParameters = new StringDataUpdateParameters(stringData, dBAccessLevel, true, false, "", false, bl, n, n2, bl3);
        layoutFieldObject.updateFieldObjectData(stringDataUpdateParameters, bl2);
    }

    private void updateBinaryData(Container container, DBAccessLevel dBAccessLevel, BinaryData binaryData, boolean bl) {
        container.updateContainerData(binaryData, dBAccessLevel, false, "", false, bl);
    }

    private void updateStringRepetition(LayoutFieldObject layoutFieldObject, FieldData fieldData, boolean bl) {
        Map<Short, StringData> map = fieldData.getData().getStringRepValues();
        for (Short s : map.keySet()) {
            LayoutFieldObject layoutFieldObject2 = layoutFieldObject.getRepetitionObject(s);
            if (layoutFieldObject2 == null) continue;
            this.updateStringData(layoutFieldObject2, fieldData.getFieldAccess(), map.get(s), false, 0, 0, bl, false);
        }
    }

    private void updateBinaryRepetition(Container container, FieldData fieldData) {
        Map<Short, BinaryData> map = fieldData.getData().getBinaryValues();
        for (Short s : map.keySet()) {
            Container container2 = container.getRepetitionObject(s);
            if (container2 == null) continue;
            this.updateBinaryData(container2, fieldData.getFieldAccess(), map.get(s), true);
        }
    }

    private void updateErrorData(LayoutFieldObject layoutFieldObject, DBAccessLevel dBAccessLevel, String string, boolean bl) {
        if (layoutFieldObject.getMetaData().isContainer()) {
            ((Container)layoutFieldObject).updateContainerData(null, dBAccessLevel, false, string, true, false);
            for (LayoutFieldObject layoutFieldObject2 : layoutFieldObject.getAllRepetitionObjects()) {
                ((Container)layoutFieldObject2).updateContainerData(null, dBAccessLevel, false, string, true, true);
            }
        } else {
            if (this.isObscuredFieldErrorDisplay(layoutFieldObject, string)) {
                string = "";
            }
            StringDataUpdateParameters stringDataUpdateParameters = new StringDataUpdateParameters(null, dBAccessLevel, true, false, string, true, false, 0, 0, false);
            layoutFieldObject.updateFieldObjectData(stringDataUpdateParameters, bl);
            for (LayoutFieldObject layoutFieldObject3 : layoutFieldObject.getAllRepetitionObjects()) {
                layoutFieldObject3.updateFieldObjectData(stringDataUpdateParameters, bl);
            }
        }
    }

    private boolean isObscuredFieldErrorDisplay(LayoutObject layoutObject, String string) {
        return layoutObject instanceof ObscuredEditBox && !Utilities.isEmptyString(string);
    }
}

