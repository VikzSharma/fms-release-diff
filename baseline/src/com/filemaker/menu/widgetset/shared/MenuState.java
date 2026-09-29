/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.annotations.DelegateToWidget
 *  com.vaadin.shared.ui.AbstractSingleComponentContainerState
 */
package com.filemaker.menu.widgetset.shared;

import com.filemaker.menu.widgetset.client.Item;
import com.filemaker.menu.widgetset.shared.DisplayMode;
import com.vaadin.shared.annotations.DelegateToWidget;
import com.vaadin.shared.ui.AbstractSingleComponentContainerState;
import java.util.ArrayList;

public class MenuState
extends AbstractSingleComponentContainerState {
    public ArrayList<Item> items = new ArrayList();
    @DelegateToWidget
    public String loggedInText = "Logged in";
    @DelegateToWidget
    public String userName;
    @DelegateToWidget
    public DisplayMode displayMode = DisplayMode.DESKTOP;
    @DelegateToWidget
    public String backItemText = "Back";
    @DelegateToWidget
    public int mnbs = 0;
    @DelegateToWidget
    public String closeButtonAriaLabel;

    public static enum BooleanState {
        userInfoVisible;

    }
}

