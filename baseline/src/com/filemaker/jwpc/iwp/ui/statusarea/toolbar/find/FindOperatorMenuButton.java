/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.Component
 */
package com.filemaker.jwpc.iwp.ui.statusarea.toolbar.find;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.ToolbarButton;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.ToolbarPopover;
import com.filemaker.jwpc.iwp.ui.statusarea.toolbar.find.FindOperatorMenu;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.vaadin.ui.Component;
import java.util.LinkedHashMap;

class FindOperatorMenuButton
extends ToolbarButton {
    private static final int POPOVER_LEFT_POSITION_1 = 270;
    private static final int POPOVER_LEFT_POSITION_2 = 320;
    private final LinkedHashMap<String, String> operators = new LinkedHashMap(17);

    FindOperatorMenuButton(App app) {
        super(app, null);
        this.addStyleName("findrequest-operator-menubar");
        this.setToolTip(IWPI18N.get(this.app, "FIND_OPERATORS_TOOLTIP", new Object[0]));
        this.initOperatorsMap();
        IWPUtilities.assignUniqueId(app, "f", (Component)this);
        this.getButton().setId("findoperatormenubutton");
    }

    private void initOperatorsMap() {
        this.operators.put(IWPI18N.get(this.app, "FIND_OPERATOR_1", new Object[0]), "=");
        this.operators.put(IWPI18N.get(this.app, "FIND_OPERATOR_2", new Object[0]), "==");
        this.operators.put(IWPI18N.get(this.app, "FIND_OPERATOR_3", new Object[0]), "!");
        this.operators.put(IWPI18N.get(this.app, "FIND_OPERATOR_4", new Object[0]), "<");
        this.operators.put(IWPI18N.get(this.app, "FIND_OPERATOR_5", new Object[0]), "<=");
        this.operators.put(IWPI18N.get(this.app, "FIND_OPERATOR_6", new Object[0]), ">");
        this.operators.put(IWPI18N.get(this.app, "FIND_OPERATOR_7", new Object[0]), ">=");
        this.operators.put(IWPI18N.get(this.app, "FIND_OPERATOR_8", new Object[0]), "...");
        this.operators.put(IWPI18N.get(this.app, "FIND_OPERATOR_9", new Object[0]), "//");
        this.operators.put(IWPI18N.get(this.app, "FIND_OPERATOR_10", new Object[0]), "?");
        this.operators.put(IWPI18N.get(this.app, "FIND_OPERATOR_11", new Object[0]), "@");
        this.operators.put(IWPI18N.get(this.app, "FIND_OPERATOR_12", new Object[0]), "#");
        this.operators.put(IWPI18N.get(this.app, "FIND_OPERATOR_13", new Object[0]), "*");
        this.operators.put(IWPI18N.get(this.app, "FIND_OPERATOR_14", new Object[0]), "\\");
        this.operators.put(IWPI18N.get(this.app, "FIND_OPERATOR_15", new Object[0]), "\"\"");
        this.operators.put(IWPI18N.get(this.app, "FIND_OPERATOR_16", new Object[0]), "*\"\"");
        this.operators.put(IWPI18N.get(this.app, "FIND_OPERATOR_17", new Object[0]), "~");
    }

    @Override
    public void performAction(Object[] objectArray) {
        super.performAction(objectArray);
        ToolbarPopover toolbarPopover = this.app.getStatusAreaContainer().getPopover();
        if (toolbarPopover == null || !(toolbarPopover instanceof FindOperatorMenu)) {
            toolbarPopover = new FindOperatorMenu(this.app, this.operators);
            this.app.getStatusAreaContainer().setPopover(toolbarPopover);
            int n = 270;
            int n2 = this.app.getPage().getBrowserWindowWidth();
            if (n2 >= 590) {
                n = 320;
            }
            toolbarPopover.show(n);
        } else {
            this.app.getStatusAreaContainer().exitPopover();
        }
    }
}

