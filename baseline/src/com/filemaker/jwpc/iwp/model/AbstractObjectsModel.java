/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.model;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.thrift.common.ObjectSpec;
import com.filemaker.jwpc.iwp.ui.layout.LayoutObject;
import com.filemaker.jwpc.iwp.ui.layout.component.portal.Portal;
import java.util.Map;

public abstract class AbstractObjectsModel {
    protected Map<String, LayoutObject> objectsMap;
    protected Map<Integer, Portal> portalsMap;
    protected boolean hasPopover = false;

    public void clear() {
        if (this.objectsMap != null) {
            for (LayoutObject layoutObject : this.objectsMap.values()) {
                layoutObject.cleanupMemory();
            }
            this.objectsMap.clear();
        }
        if (this.portalsMap != null) {
            for (Portal portal : this.portalsMap.values()) {
                portal.cleanupMemory();
            }
            this.portalsMap.clear();
        }
    }

    public void addObject(LayoutObject layoutObject) {
        if (this.portalsMap != null && layoutObject.getMetaData().isPortal()) {
            this.portalsMap.put(layoutObject.getObjectId(), (Portal)layoutObject);
        } else {
            String string = this.generateObjectKey(layoutObject.getObjectId(), layoutObject.getAttributes().getRepetition());
            this.objectsMap.put(string, layoutObject);
        }
        if (layoutObject.getMetaData().isPopoverButton()) {
            this.hasPopover = true;
        }
    }

    protected String generateObjectKey(int n, int n2) {
        return n + "_" + n2;
    }

    public abstract LayoutObject getLayoutObject(App var1, ObjectSpec var2);
}

