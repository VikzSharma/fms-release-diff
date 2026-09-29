/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.user.client.Element
 *  com.google.gwt.user.client.Event
 *  com.google.gwt.user.client.ui.Widget
 *  com.vaadin.client.BrowserInfo
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.jwpc.iwp.widgetset.client.connector.FMCommunicationConnector;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCFieldObject;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMClientEventManager;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMClientTooltipHandler;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.BrowserInfo;

public class FMCFieldEventManager
extends FMClientEventManager {
    private static FMCommunicationConnector COMMUNICATION_CONNECTOR = null;
    protected final FMCFieldObject fieldObject;
    private int hasActiveStyles = -1;

    public FMCFieldEventManager(Element element, FMCFieldObject fMCFieldObject) {
        super(element, false, BrowserInfo.get().isIE());
        this.fieldObject = fMCFieldObject;
        FMClientTooltipHandler.registerMouseEvents(element);
    }

    @Override
    protected synchronized void handleEvent(Event event, Widget widget) {
        super.handleEvent(event, widget);
        if (this.fieldObject.getState().hasTooltip) {
            FMClientTooltipHandler.getInstance().handleEvent(event, COMMUNICATION_CONNECTOR.getConnection());
        }
    }

    public static void setAsCommunicationConnector(FMCommunicationConnector fMCommunicationConnector) {
        COMMUNICATION_CONNECTOR = fMCommunicationConnector;
    }

    public static void removeCommunicationConnector(FMCommunicationConnector fMCommunicationConnector) {
        if (COMMUNICATION_CONNECTOR == fMCommunicationConnector) {
            COMMUNICATION_CONNECTOR = null;
        }
    }

    public static FMCommunicationConnector getCommunicationConnector() {
        return COMMUNICATION_CONNECTOR;
    }

    private synchronized void updateActiveStyles_internal(boolean bl) {
        String string = this.fieldObject.getUniqueId();
        if (string != null) {
            FMCUtilities.updateActiveStyles(string, bl);
        }
        if (bl) {
            this.setActiveFieldObject(this.fieldObject);
        } else {
            this.removeActiveFieldObject(this.fieldObject);
        }
    }

    protected synchronized void updateActiveStyles(boolean bl) {
        int n;
        int n2 = n = bl ? 1 : 0;
        if (this.hasActiveStyles != n) {
            this.hasActiveStyles = n;
            this.updateActiveStyles_internal(bl);
        }
    }

    protected synchronized void initActiveStyle(boolean bl) {
        if (!this.fieldObject.getUniqueId().isEmpty() && (this.hasActiveStyles == -1 || bl)) {
            this.hasActiveStyles = 0;
            this.updateActiveStyles_internal(false);
        }
    }

    protected synchronized void removeActiveState() {
        if (this.hasActiveStyles == 1) {
            this.hasActiveStyles = 0;
            String string = this.fieldObject.getUniqueId();
            if (string != null) {
                FMCUtilities.updateActiveStyles(string, false);
            }
        }
    }

    private void removeActiveFieldObject(FMCFieldObject fMCFieldObject) {
        if (COMMUNICATION_CONNECTOR != null) {
            COMMUNICATION_CONNECTOR.removeActiveFieldObject(fMCFieldObject);
        }
    }

    private void setActiveFieldObject(FMCFieldObject fMCFieldObject) {
        if (COMMUNICATION_CONNECTOR != null) {
            COMMUNICATION_CONNECTOR.setActiveFieldObject(fMCFieldObject);
        }
    }

    protected FMCFieldObject getPrevTabbableFieldObject() {
        if (!FMCUtilities.useAriaCompliantControl()) {
            FMCFieldObject fMCFieldObject = null;
            if (COMMUNICATION_CONNECTOR != null) {
                fMCFieldObject = COMMUNICATION_CONNECTOR.getPrevTabbableField(this.fieldObject);
            }
            return fMCFieldObject;
        }
        return null;
    }

    protected FMCFieldObject getNextTabbableFieldObject() {
        if (!FMCUtilities.useAriaCompliantControl()) {
            FMCFieldObject fMCFieldObject = null;
            if (COMMUNICATION_CONNECTOR != null) {
                fMCFieldObject = COMMUNICATION_CONNECTOR.getNextTabbableField(this.fieldObject);
            }
            return fMCFieldObject;
        }
        return null;
    }

    public static void printTabOrdering() {
        if (COMMUNICATION_CONNECTOR != null) {
            COMMUNICATION_CONNECTOR.printTabbableFieldObjects();
        }
    }
}

