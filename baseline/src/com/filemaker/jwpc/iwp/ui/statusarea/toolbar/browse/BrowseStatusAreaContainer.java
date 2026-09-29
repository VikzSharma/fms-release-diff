/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.Component
 */
package com.filemaker.jwpc.iwp.ui.statusarea.toolbar.browse;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.application.AppRuntimeException;
import com.filemaker.jwpc.iwp.ui.statusarea.StatusAreaContainer;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.MainMenubar;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.browse.BrowseToolbar;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.vaadin.ui.Component;

public class BrowseStatusAreaContainer
extends StatusAreaContainer {
    static final String CSS_SELECTOR_NAME = "browse";

    public BrowseStatusAreaContainer(App app, MainMenubar mainMenubar) throws AppRuntimeException {
        super(app, new BrowseToolbar(app), mainMenubar);
        this.addStyleName(CSS_SELECTOR_NAME);
        IWPUtilities.assignUniqueId(app, "b", (Component)this);
    }
}

