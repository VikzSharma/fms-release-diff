/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.ui.layout;

import com.filemaker.jwpc.iwp.thrift.common.DBAccessLevel;
import com.filemaker.jwpc.iwp.ui.event.UIEventListener;
import com.filemaker.jwpc.iwp.ui.layout.FocusableLayoutObject;
import com.filemaker.jwpc.iwp.ui.layout.HasGlassPane;
import com.filemaker.jwpc.iwp.ui.layout.LayoutObject;
import com.filemaker.jwpc.iwp.ui.layout.component.StringDataUpdateParameters;
import com.filemaker.jwpc.iwp.ui.layout.component.repetition.RepetitionContainer;
import java.util.Collection;

public interface LayoutFieldObject
extends LayoutObject,
FocusableLayoutObject,
UIEventListener,
HasGlassPane {
    public boolean hasDelegate();

    public Object getFieldData();

    public LayoutFieldObject getRepetitionObject(short var1);

    public Collection<LayoutFieldObject> getAllRepetitionObjects();

    public void addRepetitionObject(RepetitionContainer var1, String var2);

    public void insertData(String var1);

    public DBAccessLevel getAccess();

    public void updateDataEntry(DBAccessLevel var1, boolean var2);

    public void updateFieldObjectData(StringDataUpdateParameters var1, boolean var2);

    public void onFieldObjectClick();

    public void setPlaceholderText(String var1);

    public void showContextMenu(int var1, int var2);
}

