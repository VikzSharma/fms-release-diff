/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.v7.ui.OptionGroup
 */
package com.filemaker.jwpc.iwp.ui.common;

import com.vaadin.v7.ui.OptionGroup;
import java.util.Collection;

public class NavigableOptionGroup
extends OptionGroup {
    public NavigableOptionGroup() {
    }

    public NavigableOptionGroup(String string, Collection<?> collection) {
        super(string, collection);
    }

    public void setTabIndex(int n) {
        this.getState().tabIndex = n;
    }
}

