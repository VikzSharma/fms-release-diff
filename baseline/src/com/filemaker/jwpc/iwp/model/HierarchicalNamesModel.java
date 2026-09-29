/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class HierarchicalNamesModel {
    private List<HierarchicalNamesModel> childs = new ArrayList<HierarchicalNamesModel>();
    private LinkedHashMap<String, ?> jsonObject;

    public HierarchicalNamesModel(LinkedHashMap<String, ?> linkedHashMap) {
        this.jsonObject = linkedHashMap;
        if (linkedHashMap.containsKey("c4")) {
            ArrayList arrayList = (ArrayList)linkedHashMap.remove("c4");
            for (Object e : arrayList) {
                LinkedHashMap linkedHashMap2 = (LinkedHashMap)e;
                this.childs.add(new HierarchicalNamesModel(linkedHashMap2));
            }
        }
    }

    public String getName() {
        return (String)this.jsonObject.get("c25");
    }

    public int getId() {
        return (Integer)this.jsonObject.get("c26");
    }

    public boolean isFolder() {
        return this.jsonObject.containsKey("c43") && ((String)this.jsonObject.get("c43")).equalsIgnoreCase("d1");
    }

    public List<HierarchicalNamesModel> getChilds() {
        return this.childs;
    }

    public String toString() {
        return "name: " + this.getName() + " id: " + this.getId() + " isFolder: " + this.isFolder();
    }
}

