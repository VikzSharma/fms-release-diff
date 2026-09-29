/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.fmwp.datatype;

import com.filemaker.jwpc.fmwp.datatype.UniversalPath;
import java.util.ArrayList;
import java.util.List;

public class UniversalPathList
extends ArrayList<UniversalPath> {
    private static final long serialVersionUID = 4346558121362511060L;

    public UniversalPathList() {
    }

    public UniversalPathList(UniversalPathList universalPathList) {
        super(universalPathList);
    }

    @Override
    public synchronized UniversalPathList clone() {
        UniversalPathList universalPathList = new UniversalPathList();
        universalPathList.addAll(this);
        return universalPathList;
    }

    public synchronized List<String> getPathList() {
        ArrayList<String> arrayList = new ArrayList<String>();
        for (UniversalPath universalPath : this) {
            arrayList.add(universalPath.getFQName());
        }
        return arrayList;
    }

    public synchronized List<String> getNameList() {
        ArrayList<String> arrayList = new ArrayList<String>();
        for (UniversalPath universalPath : this) {
            arrayList.add(universalPath.getName());
        }
        return arrayList;
    }
}

