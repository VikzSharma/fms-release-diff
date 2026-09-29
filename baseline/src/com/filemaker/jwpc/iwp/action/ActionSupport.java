/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.action;

import com.filemaker.jwpc.iwp.action.UIAction;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public interface ActionSupport
extends PropertyChangeListener {
    public void setAction(UIAction var1);

    @Override
    public void propertyChange(PropertyChangeEvent var1);

    public void performAction(Object[] var1);
}

