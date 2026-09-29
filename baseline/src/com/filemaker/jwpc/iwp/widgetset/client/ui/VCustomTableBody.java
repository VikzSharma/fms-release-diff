/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.client.UIDL
 *  com.vaadin.v7.client.ui.VScrollTable
 *  com.vaadin.v7.client.ui.VScrollTable$VScrollTableBody
 *  com.vaadin.v7.client.ui.VScrollTable$VScrollTableBody$VScrollTableRow
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomTableGeneratedRow;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomTableRow;
import com.vaadin.client.UIDL;
import com.vaadin.v7.client.ui.VScrollTable;

public class VCustomTableBody
extends VScrollTable.VScrollTableBody {
    protected VCustomTableBody(VScrollTable vScrollTable) {
        super(vScrollTable);
    }

    protected VScrollTable.VScrollTableBody.VScrollTableRow createRow(UIDL uIDL, char[] cArray) {
        if (uIDL.hasAttribute("gen_html")) {
            return new VCustomTableGeneratedRow(this, uIDL, cArray);
        }
        return new VCustomTableRow(this, uIDL, cArray);
    }
}

