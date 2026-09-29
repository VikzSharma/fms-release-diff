/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.model;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.model.AbstractObjectsModel;
import com.filemaker.jwpc.iwp.thrift.common.LayoutObjectType;
import com.filemaker.jwpc.iwp.thrift.common.ObjectSpec;
import com.filemaker.jwpc.iwp.ui.layout.LayoutObject;
import com.filemaker.jwpc.iwp.ui.layout.component.portal.Portal;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

public class PopoverObjectsModel
extends AbstractObjectsModel {
    public PopoverObjectsModel() {
        this.objectsMap = new ConcurrentHashMap();
        this.portalsMap = new ConcurrentHashMap();
    }

    @Override
    public LayoutObject getLayoutObject(App app, ObjectSpec objectSpec) {
        int n = objectSpec.getObjectId();
        short s = objectSpec.getRepetition();
        int n2 = objectSpec.getParentPortalId();
        int n3 = objectSpec.getPortalRowIndex();
        return this.getLayoutObject(n, objectSpec.getObjectType(), s, n2, n3);
    }

    public LayoutObject getLayoutObject(int n, LayoutObjectType layoutObjectType, short s, int n2, int n3) {
        LayoutObject layoutObject = null;
        if (layoutObjectType == LayoutObjectType.PORTAL) {
            layoutObject = (LayoutObject)this.portalsMap.get(n);
        } else if (n2 != 0) {
            Portal portal = (Portal)this.portalsMap.get(n2);
            if (portal != null) {
                layoutObject = portal.getLayoutObject(n, s, n3);
            }
        } else {
            String string = this.generateObjectKey(n, s);
            layoutObject = (LayoutObject)this.objectsMap.get(string);
        }
        return layoutObject;
    }

    public Collection<LayoutObject> getLayoutObjects() {
        return this.objectsMap.values();
    }
}

