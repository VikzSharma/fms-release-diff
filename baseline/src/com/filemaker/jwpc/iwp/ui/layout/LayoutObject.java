/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.Component
 */
package com.filemaker.jwpc.iwp.ui.layout;

import com.filemaker.jwpc.iwp.metadata.ObjectMetaData;
import com.filemaker.jwpc.iwp.ui.layout.LayoutContainerObject;
import com.filemaker.jwpc.iwp.ui.layout.ObjectAttributes;
import com.vaadin.ui.Component;

public interface LayoutObject
extends Component {
    public void cleanupMemory();

    public int getObjectId();

    public String getUniqueId();

    public ObjectAttributes getAttributes();

    public ObjectMetaData getMetaData();

    public LayoutObject getParentComponent();

    public void registerToolTip(String var1);

    public void updateUniqueId();

    public void setParentComponent(LayoutContainerObject var1);

    public void updateLayoutObjectData(Object var1, boolean var2);

    public boolean hasHideCondition();

    public boolean hasHideConditionInFindMode();

    public boolean isHideConditionOn();

    public void setHideConditionOn(boolean var1);

    public Component getWrappedObject();

    public void addCFStyle(String var1);

    public void removeCFStyle(String var1);

    public void registerAccLabel(String var1);

    public void registerAccTitle(String var1);

    public void registerAccHelp(String var1);
}

