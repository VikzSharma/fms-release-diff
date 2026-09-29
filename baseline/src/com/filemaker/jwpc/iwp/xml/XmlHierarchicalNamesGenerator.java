/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.core.JsonParseException
 *  com.fasterxml.jackson.databind.ObjectMapper
 */
package com.filemaker.jwpc.iwp.xml;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.filemaker.jwpc.iwp.application.AppRuntimeException;
import com.filemaker.jwpc.iwp.model.HierarchicalNamesModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class XmlHierarchicalNamesGenerator {
    protected static final ObjectMapper defaultMapper = new ObjectMapper();

    public static List<HierarchicalNamesModel> processNames(String string) {
        try {
            ArrayList arrayList = (ArrayList)defaultMapper.readValue(string, ArrayList.class);
            ArrayList<HierarchicalNamesModel> arrayList2 = new ArrayList<HierarchicalNamesModel>();
            for (Object e : arrayList) {
                LinkedHashMap linkedHashMap = (LinkedHashMap)e;
                arrayList2.add(new HierarchicalNamesModel(linkedHashMap));
            }
            return arrayList2;
        }
        catch (JsonParseException jsonParseException) {
            jsonParseException.printStackTrace();
            throw new AppRuntimeException(jsonParseException);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            throw new AppRuntimeException(iOException);
        }
    }
}

