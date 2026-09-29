/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.aria.client.Roles
 *  com.google.gwt.core.client.Scheduler
 *  com.google.gwt.core.client.Scheduler$ScheduledCommand
 *  com.google.gwt.dom.client.Document
 *  com.google.gwt.dom.client.Element
 *  com.google.gwt.dom.client.NativeEvent
 *  com.google.gwt.dom.client.Node
 *  com.google.gwt.event.dom.client.DomEvent
 *  com.google.gwt.event.dom.client.KeyDownEvent
 *  com.google.gwt.event.dom.client.KeyDownHandler
 *  com.google.gwt.event.dom.client.KeyPressEvent
 *  com.google.gwt.event.dom.client.KeyPressHandler
 *  com.google.gwt.event.shared.EventHandler
 *  com.google.gwt.event.shared.HasHandlers
 *  com.google.gwt.user.client.DOM
 *  com.google.gwt.user.client.ui.CheckBox
 *  com.google.gwt.user.client.ui.FlowPanel
 *  com.google.gwt.user.client.ui.Widget
 *  com.vaadin.client.UIDL
 *  com.vaadin.v7.client.ui.VOptionGroup
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.google.gwt.aria.client.Roles;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.dom.client.Node;
import com.google.gwt.event.dom.client.DomEvent;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.HasHandlers;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.UIDL;
import com.vaadin.v7.client.ui.VOptionGroup;
import java.util.ArrayList;

public class VCustomNavigableOptionGroup
extends VOptionGroup {
    public VCustomNavigableOptionGroup() {
        if (FMCUtilities.useAriaCompliantControl()) {
            this.addDomHandler((EventHandler)new KeyDownHandler(){

                public void onKeyDown(KeyDownEvent keyDownEvent) {
                    switch (keyDownEvent.getNativeKeyCode()) {
                        case 37: 
                        case 38: {
                            keyDownEvent.preventDefault();
                            VCustomNavigableOptionGroup.this.moveFocus(true);
                            break;
                        }
                        case 39: 
                        case 40: {
                            keyDownEvent.preventDefault();
                            VCustomNavigableOptionGroup.this.moveFocus(false);
                            break;
                        }
                    }
                }
            }, KeyDownEvent.getType());
        }
    }

    public void buildOptions(UIDL uIDL) {
        ArrayList<Widget> arrayList = new ArrayList<Widget>();
        ArrayList<Widget> arrayList2 = new ArrayList<Widget>();
        CheckBox checkBox = null;
        for (Widget widget : this.panel) {
            if (widget.getElement().isOrHasChild((Node)FMCUtilities.getActiveElement())) {
                checkBox = (CheckBox)widget;
            }
            arrayList.add(widget);
        }
        super.buildOptions(uIDL);
        for (Widget widget : this.panel) {
            arrayList2.add(widget);
        }
        if (FMCUtilities.useAriaCompliantControl()) {
            boolean bl = !arrayList2.equals(arrayList);
            boolean bl2 = FMCUtilities.isWindowsClient();
            for (Widget widget : arrayList2) {
                final CheckBox checkBox2 = (CheckBox)widget;
                checkBox2.getElement().setTabIndex(checkBox2.isEnabled() ? 0 : -1);
                if (bl2) {
                    checkBox2.getElement().getFirstChildElement().setAttribute("aria-checked", checkBox2.getValue().toString());
                } else {
                    checkBox2.getElement().setAttribute("aria-checked", checkBox2.getValue().toString());
                }
                if (bl) {
                    DOM.sinkEvents((Element)checkBox2.getElement(), (int)(DOM.getEventsSunk((Element)checkBox2.getElement()) | 0x100 | 0x80));
                    checkBox2.addKeyPressHandler(new KeyPressHandler(){
                        final /* synthetic */ VCustomNavigableOptionGroup this$0;
                        {
                            this.this$0 = vCustomNavigableOptionGroup;
                        }

                        public void onKeyPress(KeyPressEvent keyPressEvent) {
                            switch (keyPressEvent.getCharCode()) {
                                case '\r': 
                                case ' ': {
                                    keyPressEvent.preventDefault();
                                    keyPressEvent.stopPropagation();
                                    if (checkBox2.getStyleName().contains("v-checkbox")) {
                                        checkBox2.setValue(Boolean.valueOf(checkBox2.getValue() == false));
                                    } else {
                                        checkBox2.setValue(Boolean.valueOf(true));
                                    }
                                    this.this$0.onNavSelect(checkBox2);
                                    break;
                                }
                            }
                        }
                    });
                    checkBox2.addKeyDownHandler(new KeyDownHandler(this){

                        public void onKeyDown(KeyDownEvent keyDownEvent) {
                            if (keyDownEvent.getNativeKeyCode() == 13) {
                                keyDownEvent.stopPropagation();
                            }
                        }
                    });
                    if (checkBox2.getStyleName().contains("v-checkbox")) {
                        if (bl2) {
                            Roles.getCheckboxRole().set(checkBox2.getElement().getFirstChildElement());
                        } else {
                            Roles.getCheckboxRole().set((Element)checkBox2.getElement());
                        }
                    } else {
                        Roles.getRadioRole().set((Element)checkBox2.getElement());
                    }
                }
                if (checkBox == null || !checkBox.getHTML().equals(checkBox2.getHTML()) || checkBox2.getElement().hasClassName("v-is-active")) continue;
                Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand(){

                    public void execute() {
                        checkBox2.getElement().focus();
                    }
                });
            }
        }
    }

    private void onNavSelect(CheckBox checkBox) {
        NativeEvent nativeEvent = Document.get().createClickEvent(0, 0, 0, 0, 0, false, false, false, false);
        DomEvent.fireNativeEvent((NativeEvent)nativeEvent, (HasHandlers)checkBox);
    }

    private void moveFocus(boolean bl) {
        FlowPanel flowPanel = (FlowPanel)this.panel;
        int n = flowPanel.getWidgetCount();
        if (n > 0) {
            for (int i = 0; i < n; ++i) {
                int n2;
                if (!FMCUtilities.hasFocus((Element)flowPanel.getWidget(i).getElement())) continue;
                int n3 = n2 = bl ? i - 1 : i + 1;
                if (n2 < 0) {
                    n2 = n - 1;
                } else if (n2 >= n) {
                    n2 = 0;
                }
                flowPanel.getWidget(n2).getElement().focus();
                break;
            }
        }
    }

    public void focus() {
        if (FMCUtilities.useAriaCompliantControl()) {
            boolean bl = false;
            for (Widget widget : this.panel) {
                if (!widget.getElement().isOrHasChild((Node)FMCUtilities.getActiveElement())) continue;
                bl = true;
                break;
            }
            if (!bl) {
                super.focus();
            }
        } else {
            super.focus();
        }
    }
}

