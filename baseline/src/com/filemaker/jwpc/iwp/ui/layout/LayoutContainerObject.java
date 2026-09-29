/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.ui.layout;

import com.filemaker.jwpc.iwp.ui.layout.LayoutObject;
import com.filemaker.jwpc.iwp.ui.layout.component.HiddenObject;
import com.filemaker.jwpc.iwp.ui.layout.component.repetition.RepetitionContainer;
import java.util.Collection;

public interface LayoutContainerObject
extends LayoutObject {
    public Collection<LayoutObject> getChilds();

    public void addChild(LayoutObject var1);

    public void addChild(RepetitionContainer var1);

    public void addChild(HiddenObject var1);
}

