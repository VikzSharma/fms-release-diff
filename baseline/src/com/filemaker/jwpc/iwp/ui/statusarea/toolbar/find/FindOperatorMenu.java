/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.server.Sizeable$Unit
 *  com.vaadin.ui.Component
 */
package com.filemaker.jwpc.iwp.ui.statusarea.toolbar.find;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.ui.layout.LayoutFieldObject;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.ToolbarMenuItem;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.ToolbarPopover;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.Component;
import java.util.LinkedHashMap;

public class FindOperatorMenu
extends ToolbarPopover {
    private final LinkedHashMap<String, String> operators;

    public FindOperatorMenu(App app, LinkedHashMap<String, String> linkedHashMap) {
        super(app);
        this.operators = linkedHashMap;
        IWPUtilities.assignUniqueId(app, "f", (Component)this);
    }

    @Override
    protected ToolbarPopover.ToolbarPopoverLayout generatePopover() {
        return new FindOperatorMenuLayout();
    }

    private class FindOperatorMenuLayout
    extends ToolbarPopover.ToolbarPopoverLayout {
        private static final int LAYOUT_HEIGHT_IN_PIXEL = 778;

        private FindOperatorMenuLayout() {
        }

        @Override
        protected void initLayout() {
            if (FindOperatorMenu.this.operators != null) {
                int n = 1;
                for (String string : FindOperatorMenu.this.operators.keySet()) {
                    this.addComponent((Component)new OperatorMenuItem(FindOperatorMenu.this.app, string, n++));
                }
                this.setHeight(778.0f, Sizeable.Unit.PIXELS);
            }
        }

        class OperatorMenuItem
        extends ToolbarMenuItem {
            public OperatorMenuItem(App app, String string, int n) {
                super(app, string, null);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("findrequest-operator-").append(String.valueOf(n));
                this.addStyleName(stringBuilder.toString());
            }

            @Override
            public void performAction(Object[] objectArray) {
                LayoutFieldObject layoutFieldObject = this.app.getActiveUIHandler().getActiveField(true, false);
                String string = FindOperatorMenu.this.operators.get(this.getMenuText());
                if (layoutFieldObject != null && string != null) {
                    layoutFieldObject.insertData(string);
                }
            }
        }
    }
}

