/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.ui.layout;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.metadata.ObjectMetaData;
import com.filemaker.jwpc.iwp.thrift.common.FieldSpec;
import com.filemaker.jwpc.iwp.thrift.common.LayoutFieldDataType;
import com.filemaker.jwpc.iwp.thrift.common.LayoutFieldType;
import com.filemaker.jwpc.iwp.thrift.common.LayoutObjectType;
import com.filemaker.jwpc.iwp.thrift.common.ObjectSpec;
import com.filemaker.jwpc.iwp.ui.layout.LayoutObject;
import com.filemaker.jwpc.iwp.ui.layout.component.Popover;
import com.filemaker.jwpc.iwp.ui.layout.component.portal.Portal;
import com.filemaker.jwpc.iwp.ui.layout.component.portal.PortalRowProperty;

public final class ObjectAttributes {
    private final App app;
    private LayoutObject parent;
    private final FieldSpec fieldSpec;
    private final ObjectSpec objectSpec;
    private final ObjectMetaData metaData;
    private Boolean isRelatedNonPortalField;
    private boolean parentsUpdated;
    private Portal owningPortal;
    private Popover owningPopover;
    private String conditionalFormattingId;
    private boolean ancestorIsPopover;

    public ObjectAttributes(App app, ObjectMetaData objectMetaData) {
        this(app, objectMetaData, -1, 0, 0, 0, 1);
    }

    public ObjectAttributes(App app, ObjectMetaData objectMetaData, int n, int n2, int n3, int n4, short s) {
        this.app = app;
        this.fieldSpec = new FieldSpec("", objectMetaData.getTableId(), objectMetaData.getFieldId(), objectMetaData.getFieldName(false), s, LayoutFieldType.INVALID, LayoutFieldDataType.INVALID, objectMetaData.getFieldNameAliasForExport(false), objectMetaData.getFieldNameAliasForSort(false));
        this.objectSpec = new ObjectSpec(objectMetaData.getObjectId(), s, n2, n3, n4, 0, n, 0, 0, objectMetaData.getType(), 0);
        this.metaData = objectMetaData;
    }

    public void setParent(LayoutObject layoutObject) {
        this.parent = layoutObject;
    }

    public final synchronized ObjectSpec getObjectSpec() {
        this.updateParents();
        this.objectSpec.setRowIndex(this.getRecordIndex());
        this.objectSpec.setRowId(this.getRowId());
        int n = this.app.getAppSession().getLayoutID();
        this.objectSpec.setLayoutId(n);
        return this.objectSpec;
    }

    public final synchronized FieldSpec getFieldSpec() {
        this.updateParents();
        this.updateRelatedNonPortalFieldSettings();
        return this.fieldSpec;
    }

    public synchronized int getPartIndex() {
        return this.objectSpec.getPartIndex();
    }

    public synchronized boolean isRelatedNonPortalField() {
        this.updateRelatedNonPortalFieldSettings();
        return this.isRelatedNonPortalField;
    }

    private void updateRelatedNonPortalFieldSettings() {
        if (this.isRelatedNonPortalField == null) {
            int n;
            int n2;
            this.isRelatedNonPortalField = Boolean.FALSE;
            if (this.parent != null && this.parent.getMetaData().isField() && (n2 = this.app.getLayoutDataModel().getLayoutTableId()) != (n = this.fieldSpec.getBaseTableId())) {
                this.updateParents();
                this.isRelatedNonPortalField = this.owningPortal == null;
            }
        }
    }

    private void updateParents() {
        if (!this.parentsUpdated) {
            for (LayoutObject layoutObject = this.parent; layoutObject != null; layoutObject = layoutObject.getParentComponent()) {
                if (this.owningPortal == null && layoutObject.getMetaData().getType() == LayoutObjectType.PORTAL) {
                    Integer n;
                    if (layoutObject instanceof Portal) {
                        this.owningPortal = (Portal)layoutObject;
                    } else if (layoutObject instanceof PortalRowProperty) {
                        this.owningPortal = ((PortalRowProperty)layoutObject).getPortal();
                    }
                    if (this.owningPortal != null) {
                        this.objectSpec.setParentPortalId(this.owningPortal.getMetaData().getObjectId());
                    }
                    if ((n = this.getAncestorObjectIdOfGivenType(this.owningPortal, LayoutObjectType.POPOVER)) != null) {
                        this.objectSpec.setGrandParentPopoverId(n);
                        this.ancestorIsPopover = true;
                    }
                }
                if (this.owningPopover != null || layoutObject.getMetaData().getType() != LayoutObjectType.POPOVER || !(layoutObject instanceof Popover)) continue;
                this.owningPopover = (Popover)layoutObject;
                this.objectSpec.setParentPopoverId(this.owningPopover.getMetaData().getObjectId());
            }
            this.parentsUpdated = true;
        }
    }

    private Integer getAncestorObjectIdOfGivenType(LayoutObject layoutObject, LayoutObjectType layoutObjectType) {
        LayoutObject layoutObject2 = layoutObject;
        while (layoutObject2 != null) {
            if ((layoutObject2 = layoutObject2.getParentComponent()) == null || layoutObject2.getMetaData().getType() != layoutObjectType) continue;
            return layoutObject2.getMetaData().getObjectId();
        }
        return null;
    }

    public synchronized int getRecordIndex() {
        if (this.app.isFormView() || this.metaData.isFixedPart()) {
            return this.app.getLayoutDataModel().getRecordIndex();
        }
        return this.objectSpec.getRowIndex();
    }

    public synchronized int getRowId() {
        if (this.app.isFormView() || this.metaData.isFixedPart()) {
            return this.app.getLayoutDataModel().getRowId();
        }
        return this.objectSpec.getRowId();
    }

    public synchronized int getPortalRecordIndex() {
        return this.objectSpec.getPortalRowIndex();
    }

    public synchronized short getRepetition() {
        return this.objectSpec.getRepetition();
    }

    public synchronized void setCFId(String string) {
        this.conditionalFormattingId = string;
    }

    public synchronized String getCFId() {
        return this.conditionalFormattingId;
    }

    public Portal getOwningPortal() {
        this.updateParents();
        Portal portal = null;
        if (this.owningPortal != null) {
            portal = this.owningPortal;
        } else if (this.owningPopover != null) {
            portal = this.owningPopover.getOwningPortal();
        }
        return portal;
    }

    public Popover getOwningPopover() {
        this.updateParents();
        return this.owningPopover;
    }

    public boolean isInPopover() {
        this.updateParents();
        return this.owningPopover != null || this.ancestorIsPopover;
    }
}

