/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.Scheduler
 *  com.google.gwt.core.client.Scheduler$ScheduledCommand
 *  com.google.gwt.user.client.DOM
 *  com.google.gwt.user.client.Element
 *  com.google.gwt.user.client.Event
 *  com.google.gwt.user.client.ui.Widget
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCFieldEventManager;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCFieldObject;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMClientEventManager;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Widget;

public class FMCFocusableFieldEventManager
extends FMCFieldEventManager {
    protected static final int RIGHT_BUTTON = 2;

    public FMCFocusableFieldEventManager(Element element, FMCFieldObject fMCFieldObject) {
        super(element, fMCFieldObject);
        FMClientEventManager.registerEvents(element, 128);
        FMClientEventManager.registerEvents(element, 4);
    }

    @Override
    protected void handleEvent(Event event, Widget widget) {
        super.handleEvent(event, widget);
        switch (DOM.eventGetType((Event)event)) {
            case 128: {
                this.handleKeyDown(event);
                break;
            }
            case 4: {
                if (event.getButton() != 2) break;
                this.handleContextMenu(event);
                break;
            }
        }
    }

    protected void handleContextMenu(Event event) {
        int n = event.getClientX();
        int n2 = event.getClientY();
        this.fieldObject.handleContextMenuOnServer(n, n2);
    }

    protected boolean handleKeyDown(Event event) {
        boolean bl = false;
        switch (event.getKeyCode()) {
            case 9: {
                bl = this.handleTabKeyDown(event);
                break;
            }
            case 13: {
                bl = this.handleEnterKeyDown(event);
                break;
            }
            case 27: {
                bl = this.handleEscKeyDown(event);
                break;
            }
        }
        return bl;
    }

    protected boolean handleTabKeyDown(Event event) {
        if (!FMCUtilities.useAriaCompliantControl()) {
            if (!FMCUtilities.getCanHandleTabKeyDown()) {
                DOM.eventPreventDefault((Event)DOM.eventGetCurrentEvent());
                event.stopPropagation();
                return true;
            }
            boolean bl = false;
            if (this.fieldObject.getState().exitOnTab) {
                DOM.eventPreventDefault((Event)DOM.eventGetCurrentEvent());
                event.stopPropagation();
                bl = true;
                if (FMCUtilities.isValidKeyDown()) {
                    this.fieldObject.getElement().blur();
                    this.exitField(!event.getShiftKey());
                }
            }
            return bl;
        }
        Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand(){

            public void execute() {
                FMCFocusableFieldEventManager.this.fieldObject.prepareForExit();
            }
        });
        return false;
    }

    protected boolean handleEnterKeyDown(Event event) {
        boolean bl;
        boolean bl2 = false;
        boolean bl3 = FMCUtilities.isValidKeyDown();
        boolean bl4 = FMCUtilities.eventLocationSupported(event);
        boolean bl5 = (!bl4 || FMCUtilities.getEventLocation(event) == 0) && !event.getAltKey();
        boolean bl6 = !bl5;
        String string = this.fieldObject.getElement().getInnerText();
        boolean bl7 = this.fieldObject.getState().hasObjectKeyTrigger;
        boolean bl8 = this.fieldObject.getState().hasLayoutKeyTrigger;
        boolean bl9 = this.fieldObject.getState().isKeyStrokeEnabled;
        boolean bl10 = bl = bl9 && (bl7 || bl8);
        if (this.fieldObject.getState().exitOnReturn && bl5 || this.fieldObject.getState().exitOnEnter && bl6) {
            DOM.eventPreventDefault((Event)DOM.eventGetCurrentEvent());
            event.stopPropagation();
            bl2 = true;
            if (bl3) {
                if (bl) {
                    this.fieldObject.performOnKeyDownOnServer(string, event.getKeyCode(), bl5);
                }
                this.fieldObject.getElement().blur();
                this.exitField(!event.getShiftKey());
            }
        } else if (FMCUtilities.isFindMode()) {
            DOM.eventPreventDefault((Event)DOM.eventGetCurrentEvent());
            event.stopPropagation();
            bl2 = true;
            if (bl3) {
                if (bl) {
                    this.fieldObject.performOnKeyDownOnServer(string, event.getKeyCode(), bl5);
                }
                this.fieldObject.getElement().blur();
                this.fieldObject.performCommitOnServer(event.getAltKey());
            }
        } else if (bl6) {
            DOM.eventPreventDefault((Event)DOM.eventGetCurrentEvent());
            event.stopPropagation();
            bl2 = true;
            if (bl3) {
                if (bl) {
                    this.fieldObject.performOnKeyDownOnServer(string, event.getKeyCode(), bl5);
                }
                this.fieldObject.getElement().blur();
                this.fieldObject.performCommitOnServer(event.getAltKey());
            }
        } else if (bl5 && bl && bl3) {
            this.fieldObject.performOnKeyDownOnServer(string, event.getKeyCode(), bl5);
        }
        return bl2;
    }

    protected boolean handleEscKeyDown(Event event) {
        boolean bl = false;
        boolean bl2 = FMCUtilities.isValidKeyDown();
        String string = this.fieldObject.getElement().getInnerText();
        boolean bl3 = this.fieldObject.getState().hasObjectKeyTrigger;
        boolean bl4 = this.fieldObject.getState().hasLayoutKeyTrigger;
        boolean bl5 = this.fieldObject.getState().isKeyStrokeEnabled;
        boolean bl6 = bl5 && (bl3 || bl4);
        DOM.eventPreventDefault((Event)DOM.eventGetCurrentEvent());
        event.stopPropagation();
        bl = true;
        if (bl2) {
            if (bl6) {
                this.fieldObject.performOnKeyDownOnServer(string, event.getKeyCode(), false);
            }
            this.fieldObject.getElement().blur();
        }
        return bl;
    }

    protected void exitField(boolean bl) {
        boolean bl2 = true;
        if (!this.fieldObject.getState().waitForServerOnExit) {
            FMCFieldObject fMCFieldObject;
            FMCFieldObject fMCFieldObject2 = fMCFieldObject = bl ? this.getNextTabbableFieldObject() : this.getPrevTabbableFieldObject();
            if (fMCFieldObject != null && !fMCFieldObject.getState().waitForServerOnEnter) {
                this.fieldObject.prepareForExit();
                fMCFieldObject.performTabFocus();
                bl2 = false;
            }
        }
        if (bl2) {
            if (bl) {
                this.fieldObject.performNextOnServer();
            } else {
                this.fieldObject.performPrevOnServer();
            }
            FMCUtilities.setCanHandleTabKeyDown(false);
        }
    }
}

