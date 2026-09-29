/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.user.client.DOM
 *  com.google.gwt.user.client.Element
 *  com.google.gwt.user.client.Event
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCFieldObject;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCFocusableFieldEventManager;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomPopup;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;

public class FMCPopupEventManager
extends FMCFocusableFieldEventManager {
    public FMCPopupEventManager(Element element, FMCFieldObject fMCFieldObject) {
        super(element, fMCFieldObject);
    }

    @Override
    protected boolean handleKeyDown(Event event) {
        boolean bl = super.handleKeyDown(event);
        switch (event.getKeyCode()) {
            case 8: 
            case 46: {
                DOM.eventPreventDefault((Event)DOM.eventGetCurrentEvent());
                event.stopPropagation();
                ((VCustomPopup)this.fieldObject).rpc.deleteKeyPressed("true");
                bl = true;
                break;
            }
        }
        return bl;
    }
}

