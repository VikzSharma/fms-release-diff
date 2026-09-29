/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.model;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.model.AbstractObjectsModel;
import com.filemaker.jwpc.iwp.thrift.common.ObjectSpec;
import com.filemaker.jwpc.iwp.ui.layout.LayoutObject;
import java.util.concurrent.ConcurrentHashMap;

public class PortalObjectsModel
extends AbstractObjectsModel {
    public PortalObjectsModel() {
        this.objectsMap = new ConcurrentHashMap();
    }

    public void cleanupMemory() {
        if (this.objectsMap != null) {
            for (LayoutObject layoutObject : this.objectsMap.values()) {
                layoutObject.cleanupMemory();
            }
            this.objectsMap.clear();
        }
    }

    @Override
    public LayoutObject getLayoutObject(App app, ObjectSpec objectSpec) {
        int n = objectSpec.getObjectId();
        short s = objectSpec.getRepetition();
        return this.getLayoutObject(n, s);
    }

    public LayoutObject getLayoutObject(int n, short s) {
        String string = this.generateObjectKey(n, s);
        LayoutObject layoutObject = (LayoutObject)this.objectsMap.get(string);
        return layoutObject;
    }
}

