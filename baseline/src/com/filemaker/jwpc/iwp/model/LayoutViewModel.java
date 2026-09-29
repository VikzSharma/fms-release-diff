/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.model;

import com.filemaker.jwpc.iwp.model.PartObjectsModel;
import com.filemaker.jwpc.iwp.thrift.common.CFObject;
import com.filemaker.jwpc.iwp.ui.layout.LayoutObject;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public final class LayoutViewModel {
    private TreeMap<Integer, LayoutObject> tabbableObjects = new TreeMap();
    private PartObjectsModel fixedPartObjectsModel = new PartObjectsModel();
    private Map<LayoutObject, CFObject> layoutObjectsToCFMap = new ConcurrentHashMap<LayoutObject, CFObject>();

    public void cleanupMemory() {
        this.clearAllCFLayoutObjects();
        this.layoutObjectsToCFMap = null;
        if (this.fixedPartObjectsModel != null) {
            this.fixedPartObjectsModel.removeAllPortalRows();
            this.fixedPartObjectsModel.clear();
            this.fixedPartObjectsModel = null;
        }
        if (this.tabbableObjects != null) {
            this.tabbableObjects.clear();
            this.tabbableObjects = null;
        }
    }

    public PartObjectsModel getFixedPartsObjectsModel() {
        return this.fixedPartObjectsModel;
    }

    public Map<LayoutObject, CFObject> getObjectsToCFMap() {
        return this.layoutObjectsToCFMap;
    }

    public void addCFLayoutObject(LayoutObject layoutObject, CFObject cFObject) {
        this.layoutObjectsToCFMap.put(layoutObject, cFObject);
    }

    public void removeCFLayoutObject(LayoutObject layoutObject) {
        this.layoutObjectsToCFMap.remove(layoutObject);
    }

    public void clearAllCFLayoutObjects() {
        if (this.layoutObjectsToCFMap != null) {
            this.layoutObjectsToCFMap.clear();
        }
    }

    public void updateTabOrder(LayoutObject layoutObject, int n, int n2) {
        this.tabbableObjects.remove(n);
        if (n2 > 0) {
            this.tabbableObjects.put(n2, layoutObject);
        }
    }

    public ArrayList<String> getTabbableConnectors() {
        ArrayList<String> arrayList = new ArrayList<String>();
        for (LayoutObject layoutObject : this.tabbableObjects.values()) {
            if (!layoutObject.isAttached() || !layoutObject.isConnectorEnabled()) continue;
            arrayList.add(layoutObject.getConnectorId());
        }
        return arrayList;
    }
}

