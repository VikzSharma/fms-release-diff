/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.server.Sizeable$Unit
 *  com.vaadin.ui.Component
 *  com.vaadin.v7.data.Property
 *  com.vaadin.v7.data.Property$ReadOnlyException
 *  com.vaadin.v7.data.Property$ValueChangeListener
 *  com.vaadin.v7.data.Property$ValueChangeNotifier
 *  com.vaadin.v7.data.util.converter.Converter$ConversionException
 *  com.vaadin.v7.ui.VerticalLayout
 */
package com.filemaker.jwpc.iwp.ui.layout.list;

import com.filemaker.jwpc.iwp.metadata.ObjectMetaData;
import com.filemaker.jwpc.iwp.metadata.PartMetaData;
import com.filemaker.jwpc.iwp.model.PartObjectsModel;
import com.filemaker.jwpc.iwp.thrift.common.Dimensions;
import com.filemaker.jwpc.iwp.thrift.common.LayoutObjectType;
import com.filemaker.jwpc.iwp.thrift.layout.FieldObjectData;
import com.filemaker.jwpc.iwp.thrift.layout.NonFieldObjectData;
import com.filemaker.jwpc.iwp.thrift.layout.NonFieldObjectsData;
import com.filemaker.jwpc.iwp.thrift.layout.SinglePartObjectsData;
import com.filemaker.jwpc.iwp.thrift.layout.SingleRowPartsData;
import com.filemaker.jwpc.iwp.ui.layout.component.AbsoluteCssLayout;
import com.filemaker.jwpc.iwp.ui.layout.component.Body;
import com.filemaker.jwpc.iwp.ui.layout.component.LayoutPart;
import com.filemaker.jwpc.iwp.ui.layout.list.ListRow;
import com.filemaker.jwpc.iwp.xml.UIGenerator;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.Component;
import com.vaadin.v7.data.Property;
import com.vaadin.v7.data.util.converter.Converter;
import com.vaadin.v7.ui.VerticalLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class ListRowProperty
extends AbsoluteCssLayout
implements Property,
Property.ValueChangeNotifier {
    private final ListRow parentRow;
    private Body body;
    private CustomBody subSummaryPart;
    private SingleRowPartsData rowPartsData;
    private Map<Integer, NonFieldObjectsData> partsStaticData;
    private List<LayoutPart> partsList = new ArrayList<LayoutPart>();

    public ListRowProperty(ListRow listRow) {
        super(false);
        this.parentRow = listRow;
        this.setWidth(this.parentRow.getBodyMetaData().getWidth());
        if (this.parentRow.getListView().getApp().getLayoutDataModel().getFoundRecords() > 0) {
            this.setHeight(this.parentRow.getBodyMetaData().getHeight());
        } else {
            this.setHeight("0px");
        }
    }

    public void cleanupMemory() {
        if (this.partsStaticData != null) {
            this.partsStaticData.clear();
            this.partsStaticData = null;
        }
        for (LayoutPart layoutPart : this.partsList) {
            layoutPart.cleanupMemory();
        }
        this.partsList.clear();
        if (this.body != null) {
            this.body.cleanupMemory();
            this.body = null;
        }
        if (this.subSummaryPart != null) {
            this.subSummaryPart.cleanupMemory();
            this.subSummaryPart = null;
        }
        this.rowPartsData = null;
        this.removeAllComponents();
    }

    @Override
    protected String getCss(Component component) {
        return null;
    }

    public Body getBody() {
        return this.body;
    }

    public PartObjectsModel getPartObjectsModel() {
        if (this.body != null) {
            return this.body.getPartObjectsModel();
        }
        return null;
    }

    public PartMetaData getBodyMetaData() {
        return this.parentRow.getBodyMetaData();
    }

    public Object getValue() {
        return this;
    }

    public void setValue(Object object) throws Property.ReadOnlyException {
    }

    public Class getType() {
        return ListRowProperty.class;
    }

    public void addValueChangeListener(Property.ValueChangeListener valueChangeListener) {
    }

    public void addListener(Property.ValueChangeListener valueChangeListener) {
    }

    public void removeValueChangeListener(Property.ValueChangeListener valueChangeListener) {
    }

    public void removeListener(Property.ValueChangeListener valueChangeListener) {
    }

    public float addBody(Body body, SingleRowPartsData singleRowPartsData, Map<Integer, NonFieldObjectsData> map) {
        float f;
        boolean bl;
        this.body = body;
        this.rowPartsData = singleRowPartsData;
        this.partsStaticData = map;
        Dimensions dimensions = this.parentRow.getListView().getApp().getBrowserInfoHandler().getBrowserClientInfo().getBrowserDimensions();
        boolean bl2 = bl = this.parentRow.getListView().isClassicTheme() && body.getMetaData().getWidthAsInt() < dimensions.getWidth();
        if (bl) {
            this.setWidth(dimensions.getWidth(), Sizeable.Unit.PIXELS);
            body.setWidth(dimensions.getWidth(), Sizeable.Unit.PIXELS);
        } else {
            this.setWidth(body.getWidth(), Sizeable.Unit.PIXELS);
        }
        if (this.hasSummaryParts()) {
            this.subSummaryPart = this.createBodyWithSummaryParts(body);
            f = this.subSummaryPart.getHeight();
            this.setHeight(this.subSummaryPart.getHeight(), Sizeable.Unit.PIXELS);
            this.addComponent((Component)this.subSummaryPart);
        } else {
            this.initBodyPart(body);
            f = body.getHeight();
            this.setHeight(body.getHeight(), Sizeable.Unit.PIXELS);
            this.addComponent(body);
        }
        if (this.parentRow.getListView().getListState().getCurrentActiveRow() == this.parentRow) {
            this.parentRow.addActiveRowStyleName();
        }
        return f;
    }

    public boolean hasSummaryParts() {
        if (this.rowPartsData == null || this.rowPartsData.getPartsData().size() == 0) {
            return false;
        }
        return this.rowPartsData.getPartsData().size() != 1 || this.rowPartsData.getPartsData().get(0).getPartType() != LayoutObjectType.BODY;
    }

    public void initBodyPart(Body body) {
        if (this.rowPartsData.getPartsData().size() == 1 && this.rowPartsData.getPartsData().get(0).getPartType() == LayoutObjectType.BODY) {
            SinglePartObjectsData singlePartObjectsData = this.rowPartsData.getPartsData().get(0);
            NonFieldObjectsData nonFieldObjectsData = null;
            if (this.partsStaticData != null) {
                nonFieldObjectsData = this.partsStaticData.get(singlePartObjectsData.getPartIndex());
            }
            this.fillPartData(body, singlePartObjectsData.getFieldObjectsData(), singlePartObjectsData.getNonFieldObjectsData(), nonFieldObjectsData);
        }
        this.partsList.add(body);
    }

    private CustomBody createBodyWithSummaryParts(Body body) {
        this.initAllParts(body);
        CustomBody customBody = new CustomBody(this.getValidHeight());
        boolean bl = this.parentRow.getListView().getLayoutMetaData().hasNoBody();
        for (LayoutPart layoutPart : this.partsList) {
            customBody.addComponent(layoutPart);
            LayoutObjectType layoutObjectType = layoutPart.getPartType();
            if (layoutObjectType != LayoutObjectType.BODY && (layoutObjectType != LayoutObjectType.LEADING_GRAND_SUM || !bl)) continue;
            customBody.setExpandRatio(layoutPart, 1.0f);
        }
        customBody.setWidth(body.getWidth(), Sizeable.Unit.PIXELS);
        return customBody;
    }

    public void initAllParts(Body body) {
        UIGenerator uIGenerator = this.parentRow.getListView().getUIGenerator();
        NonFieldObjectsData nonFieldObjectsData = null;
        for (SinglePartObjectsData singlePartObjectsData : this.rowPartsData.getPartsData()) {
            if (this.partsStaticData != null) {
                nonFieldObjectsData = this.partsStaticData.get(singlePartObjectsData.getPartIndex());
            }
            if (singlePartObjectsData.getPartType() == LayoutObjectType.BODY) {
                this.partsList.add(body);
                this.fillPartData(body, singlePartObjectsData.getFieldObjectsData(), singlePartObjectsData.getNonFieldObjectsData(), nonFieldObjectsData);
                continue;
            }
            ObjectMetaData objectMetaData = this.parentRow.getListView().getLayoutMetaData().getMetaDataByPartId(singlePartObjectsData.getPartIndex());
            if (objectMetaData == null) continue;
            Object t = uIGenerator.generateLayoutPartUI(LayoutPart.getPartClass(singlePartObjectsData.getPartType()), body.getPartObjectsModel(), objectMetaData, singlePartObjectsData.getRowIndex(), singlePartObjectsData.getRowId(), body.getAttributes().getPortalRecordIndex());
            this.partsList.add((LayoutPart)t);
            this.fillPartData((LayoutPart)t, singlePartObjectsData.getFieldObjectsData(), singlePartObjectsData.getNonFieldObjectsData(), nonFieldObjectsData);
        }
    }

    public void updateRowData(SingleRowPartsData singleRowPartsData, Map<Integer, NonFieldObjectsData> map) {
        NonFieldObjectsData nonFieldObjectsData = null;
        int n = 0;
        for (SinglePartObjectsData singlePartObjectsData : singleRowPartsData.getPartsData()) {
            LayoutPart layoutPart;
            if (map != null) {
                nonFieldObjectsData = map.get(singlePartObjectsData.getPartIndex());
            }
            if (n >= 0 && n < this.partsList.size() && (layoutPart = this.partsList.get(n)) != null) {
                this.fillPartData(layoutPart, singlePartObjectsData.getFieldObjectsData(), singlePartObjectsData.getNonFieldObjectsData(), nonFieldObjectsData);
            }
            ++n;
        }
    }

    private void fillPartData(LayoutPart layoutPart, Map<Integer, FieldObjectData> map, Map<Integer, NonFieldObjectData> map2, NonFieldObjectsData nonFieldObjectsData) {
        this.parentRow.getListView().getDataUpdator().updateNonFieldObjects(layoutPart, map2);
        this.parentRow.getListView().getDataUpdator().updateFieldObjects(layoutPart, map);
        if (nonFieldObjectsData != null) {
            this.parentRow.getListView().getDataUpdator().updateNonFieldObjects(layoutPart, nonFieldObjectsData.getObjects());
        }
    }

    private float getValidHeight() {
        float f = 0.0f;
        for (LayoutPart layoutPart : this.partsList) {
            f += layoutPart.getHeight();
        }
        return f;
    }

    public void setReadOnly(boolean bl) {
        super.setReadOnly(bl);
    }

    public boolean isReadOnly() {
        return super.isReadOnly();
    }

    public int getPartIndex() {
        if (this.rowPartsData != null) {
            return this.rowPartsData.getPartsData().get(0).getPartIndex();
        }
        return 0;
    }

    public void updateCustomBodyExpandedSizesIfNeeded() {
        this.setCaptionAsHtml(!this.isCaptionAsHtml());
    }

    private class CustomBody
    extends VerticalLayout
    implements Property {
        public CustomBody(float f) {
            this.setMargin(false);
            this.setSpacing(false);
            this.setHeight(f, Sizeable.Unit.PIXELS);
        }

        public void cleanupMemory() {
            this.removeAllComponents();
        }

        public Object getValue() {
            return this;
        }

        public void setValue(Object object) throws Property.ReadOnlyException, Converter.ConversionException {
            throw new UnsupportedOperationException();
        }

        public Class<?> getType() {
            throw new UnsupportedOperationException();
        }

        public void setReadOnly(boolean bl) {
            super.setReadOnly(bl);
        }

        public boolean isReadOnly() {
            return super.isReadOnly();
        }
    }
}

