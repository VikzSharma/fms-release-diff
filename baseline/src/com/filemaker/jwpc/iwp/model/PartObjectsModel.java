/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.model;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.model.AbstractObjectsModel;
import com.filemaker.jwpc.iwp.thrift.common.ObjectSpec;
import com.filemaker.jwpc.iwp.ui.layout.LayoutObject;
import com.filemaker.jwpc.iwp.ui.layout.component.Popover;
import com.filemaker.jwpc.iwp.ui.layout.component.popover.PopoverWindow;
import com.filemaker.jwpc.iwp.ui.layout.component.portal.Portal;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

public class PartObjectsModel
extends AbstractObjectsModel {
    public PartObjectsModel() {
        this.objectsMap = new ConcurrentHashMap();
        this.portalsMap = new ConcurrentHashMap();
    }

    public LayoutObject getLayoutObjectFromPortal(int n, int n2, short s, int n3, boolean bl) {
        LayoutObject layoutObject = null;
        Portal portal = (Portal)this.portalsMap.get(n);
        if (portal != null) {
            if (n2 != portal.getObjectId()) {
                boolean bl2 = true;
                if (!bl) {
                    bl2 = portal.getPortalTable().isRowVisible(n3);
                }
                if ((bl || bl2) && (layoutObject = portal.getLayoutObject(n2, s, n3)) == null && bl) {
                    portal.getPortalTable().makeRowVisible(n3, null);
                    layoutObject = portal.getLayoutObject(n2, s, n3);
                }
            } else {
                layoutObject = portal;
            }
        }
        return layoutObject;
    }

    public LayoutObject getLayoutObjectPortal(int n, short s) {
        LayoutObject layoutObject = null;
        layoutObject = (LayoutObject)this.portalsMap.get(n);
        if (layoutObject == null) {
            String string = this.generateObjectKey(n, s);
            layoutObject = (LayoutObject)this.objectsMap.get(string);
        }
        return layoutObject;
    }

    @Override
    public LayoutObject getLayoutObject(App app, ObjectSpec objectSpec) {
        PopoverWindow popoverWindow = app.getLayoutContainer().getPopoverWindow();
        return this.getLayoutObject(popoverWindow, objectSpec, false);
    }

    public LayoutObject getLayoutObject(PopoverWindow popoverWindow, ObjectSpec objectSpec, boolean bl) {
        int n = objectSpec.getObjectId();
        short s = objectSpec.getRepetition();
        int n2 = objectSpec.getParentPopoverId();
        int n3 = objectSpec.getParentPortalId();
        int n4 = objectSpec.getGrandParentPopoverId();
        int n5 = objectSpec.getPortalRowIndex();
        LayoutObject layoutObject = null;
        if (n4 != 0 || n2 != 0) {
            Popover popover;
            int n6 = n3 = n4 != 0 ? n3 : 0;
            if (popoverWindow != null && (popover = popoverWindow.getPopover()) != null) {
                layoutObject = popover.getLayoutObject(n, objectSpec.getObjectType(), s, n3, n5);
            }
        } else {
            layoutObject = n3 != 0 ? this.getLayoutObjectFromPortal(n3, n, s, n5, bl) : this.getLayoutObjectPortal(n, s);
        }
        return layoutObject;
    }

    public Collection<LayoutObject> getLayoutObjects() {
        return this.objectsMap.values();
    }

    public boolean hasAnyPortalObjects() {
        return !this.portalsMap.isEmpty();
    }

    public boolean hasAnyPopoverObjects() {
        return this.hasPopover;
    }

    public void removeAllPortalRows() {
        if (!this.portalsMap.isEmpty()) {
            for (Portal portal : this.portalsMap.values()) {
                portal.getPortalTable().forceEmptyPortalRows();
            }
        }
    }
}

