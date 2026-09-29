/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.filemaker.jwpc.fmwp.api.thrift.service.IDLValueList
 *  com.filemaker.jwpc.fmwp.api.thrift.service.NVPair
 */
package com.filemaker.jwpc.businessobject;

import com.filemaker.jwpc.common.DataObject;
import com.filemaker.jwpc.fmwp.api.thrift.service.IDLValueList;
import com.filemaker.jwpc.fmwp.api.thrift.service.NVPair;
import com.filemaker.jwpc.util.MultiLinkedHashMap;
import java.util.List;

public class ValueLists
extends DataObject {
    MultiLinkedHashMap<String, MultiLinkedHashMap<String, String>> valueLists = new MultiLinkedHashMap();

    public MultiLinkedHashMap<String, MultiLinkedHashMap<String, String>> getValueLists() {
        return this.valueLists;
    }

    public ValueLists(List<IDLValueList> list) {
        for (IDLValueList iDLValueList : list) {
            MultiLinkedHashMap<String, String> multiLinkedHashMap = new MultiLinkedHashMap<String, String>();
            for (NVPair nVPair : iDLValueList.getValues()) {
                multiLinkedHashMap.put(nVPair.getKey(), nVPair.getValue());
            }
            this.valueLists.put(iDLValueList.getName(), multiLinkedHashMap);
        }
    }
}

