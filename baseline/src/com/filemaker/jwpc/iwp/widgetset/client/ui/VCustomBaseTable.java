/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.aria.client.Roles
 *  com.google.gwt.core.client.JsArray
 *  com.google.gwt.core.client.Scheduler
 *  com.google.gwt.core.client.Scheduler$ScheduledCommand
 *  com.google.gwt.dom.client.Element
 *  com.google.gwt.dom.client.InputElement
 *  com.google.gwt.event.dom.client.BlurEvent
 *  com.google.gwt.event.dom.client.FocusEvent
 *  com.vaadin.client.UIDL
 *  com.vaadin.shared.AbstractComponentState
 *  com.vaadin.v7.client.ui.VScrollTable
 *  com.vaadin.v7.client.ui.VScrollTable$FocusableScrollContextPanel
 *  com.vaadin.v7.client.ui.VScrollTable$SelectMode
 *  com.vaadin.v7.client.ui.VScrollTable$VScrollTableBody
 *  com.vaadin.v7.client.ui.VScrollTable$VScrollTableBody$VScrollTableRow
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.jwpc.iwp.widgetset.client.rpc.AbstractBaseTableServerRpc;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCInputUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomTableBody;
import com.google.gwt.aria.client.Roles;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.FocusEvent;
import com.vaadin.client.UIDL;
import com.vaadin.shared.AbstractComponentState;
import com.vaadin.v7.client.ui.VScrollTable;

public class VCustomBaseTable
extends VScrollTable {
    private AbstractBaseTableServerRpc rpc;
    private VScrollTable.SelectMode selectMode;

    public void registerServerRpc(AbstractBaseTableServerRpc abstractBaseTableServerRpc) {
        this.rpc = abstractBaseTableServerRpc;
    }

    protected VScrollTable.FocusableScrollContextPanel createScrollBodyPanel() {
        VScrollTable.FocusableScrollContextPanel focusableScrollContextPanel;
        if (FMCUtilities.useAriaCompliantControl()) {
            focusableScrollContextPanel = new VScrollTable.FocusableScrollContextPanel((VScrollTable)this, false);
            Roles.getListboxRole().set((Element)focusableScrollContextPanel.getElement());
        } else {
            focusableScrollContextPanel = super.createScrollBodyPanel();
        }
        return focusableScrollContextPanel;
    }

    public void initializeRows(UIDL uIDL, UIDL uIDL2) {
        super.initializeRows(uIDL, uIDL2);
        if (FMCUtilities.useAriaCompliantControl()) {
            this.syncAria(false);
        }
    }

    public void syncAria(boolean bl) {
        JsArray<Element> jsArray = FMCUtilities.querySelectorAll((Element)this.getElement(), ".v-table-row, .v-table-row-odd");
        for (int i = 0; i < jsArray.length(); ++i) {
            Element element = (Element)jsArray.get(i);
            InputElement inputElement = (InputElement)FMCUtilities.querySelector(element, "input");
            if (inputElement != null && inputElement.getType().equals("checkbox")) {
                Roles.getCheckboxRole().set(element);
                element.setAttribute("aria-checked", inputElement.isChecked() ? "true" : "false");
            } else {
                Roles.getOptionRole().set(element);
            }
            element.setId(FMCUtilities.getUUID());
            element.setAttribute("aria-selected", "false");
        }
        if (bl && this.rpc != null) {
            this.rpc.syncAriaDone();
        }
    }

    public boolean setRowFocus(final VScrollTable.VScrollTableBody.VScrollTableRow vScrollTableRow) {
        if (!this.isSelectable()) {
            return false;
        }
        final VScrollTable.VScrollTableBody.VScrollTableRow vScrollTableRow2 = this.focusedRow;
        boolean bl = super.setRowFocus(vScrollTableRow);
        if (FMCUtilities.useAriaCompliantControl()) {
            Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand(){
                final /* synthetic */ VCustomBaseTable this$0;
                {
                    this.this$0 = vCustomBaseTable;
                }

                public void execute() {
                    Element element = FMCUtilities.querySelector((Element)this.this$0.getElement(), ".v-table-body");
                    if (vScrollTableRow != null && vScrollTableRow.getElement().getClassName().contains("v-selected")) {
                        vScrollTableRow.getElement().setAttribute("aria-selected", "true");
                        element.setAttribute("aria-activedescendant", vScrollTableRow.getElement().getId());
                    } else {
                        element.removeAttribute("aria-activedescendant");
                    }
                    if (vScrollTableRow2 != null && vScrollTableRow2 != vScrollTableRow) {
                        vScrollTableRow2.getElement().setAttribute("aria-selected", "false");
                    }
                }
            });
        }
        return bl;
    }

    protected boolean handleNavigation(int n, boolean bl, boolean bl2) {
        if (FMCUtilities.useAriaCompliantControl()) {
            if ((n == this.getNavigationUpKey() || n == this.getNavigationDownKey()) && this.selectMode == VScrollTable.SelectMode.SINGLE) {
                boolean bl3 = false;
                if (bl2) {
                    int n2;
                    int n3 = this.focusedRow == null ? -1 : this.focusedRow.getIndex();
                    bl3 = super.handleNavigation(n, bl, false);
                    int n4 = n2 = this.focusedRow == null ? -1 : this.focusedRow.getIndex();
                    if (this.rpc != null) {
                        this.rpc.onNavMove(n3, n2);
                    }
                    return bl3;
                }
                bl3 = super.handleNavigation(n, bl, false);
                if (this.rpc != null) {
                    this.rpc.onNavFocus(this.focusedRow.getIndex());
                }
                return bl3;
            }
            if (this.isSelectable() && n == this.getNavigationSelectKey()) {
                boolean bl4 = super.handleNavigation(n, bl, bl2);
                if (this.rpc != null) {
                    this.rpc.onNavSelect(this.focusedRow.getIndex());
                }
                return bl4;
            }
        }
        return super.handleNavigation(n, bl, bl2);
    }

    public void onFocus(FocusEvent focusEvent) {
        super.onFocus(focusEvent);
        if (FMCUtilities.useAriaCompliantControl() && FMCInputUtilities.isKeyboardTab() && this.focusedRow != null) {
            this.rpc.onNavFocus(this.focusedRow.getIndex());
        }
    }

    public void onBlur(BlurEvent blurEvent) {
        super.onBlur(blurEvent);
        if (FMCUtilities.useAriaCompliantControl()) {
            if (this.focusedRow != null && !this.focusedRow.isSelected()) {
                this.focusedRow = null;
            }
            Element element = FMCUtilities.querySelector((Element)this.getElement(), ".v-table-body");
            element.removeAttribute("aria-activedescendant");
        }
    }

    public void updateSelectionProperties(UIDL uIDL, AbstractComponentState abstractComponentState, boolean bl) {
        super.updateSelectionProperties(uIDL, abstractComponentState, bl);
        if (uIDL.hasAttribute("selectmode")) {
            this.selectMode = bl ? VScrollTable.SelectMode.NONE : (uIDL.getStringAttribute("selectmode").equals("multi") ? VScrollTable.SelectMode.MULTI : (uIDL.getStringAttribute("selectmode").equals("single") ? VScrollTable.SelectMode.SINGLE : VScrollTable.SelectMode.NONE));
        }
    }

    protected VScrollTable.VScrollTableBody createScrollBody() {
        return new VCustomTableBody(this);
    }
}

