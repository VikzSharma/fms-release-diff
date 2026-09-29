/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.vaadin.peter.contextmenu.ContextMenu
 */
package com.filemaker.jwpc.iwp.ui.component;

import com.filemaker.fields.FMField;
import com.filemaker.jwpc.iwp.ui.layout.LayoutFieldObject;
import org.vaadin.peter.contextmenu.ContextMenu;

public class IWPContextMenu
extends ContextMenu {
    private static final long serialVersionUID = 7642923131793049871L;
    private int contextMenuXPosition;
    private int contextMenuYPosition;
    private boolean displayContextMenu = false;
    private LayoutFieldObject activeField;

    public int getContextMenuXPosition() {
        return this.contextMenuXPosition;
    }

    public void setContextMenuXPosition(int n) {
        this.contextMenuXPosition = n;
    }

    public int getContextMenuYPosition() {
        return this.contextMenuYPosition;
    }

    public void setContextMenuYPosition(int n) {
        this.contextMenuYPosition = n;
    }

    public boolean isDisplayContextMenu() {
        return this.displayContextMenu;
    }

    public void setDisplayContextMenu(boolean bl) {
        this.displayContextMenu = bl;
    }

    public void show(LayoutFieldObject layoutFieldObject) {
        if (this.getActiveField() != null && this.getActiveField() == layoutFieldObject && this.isDisplayContextMenu()) {
            FMField fMField;
            if (layoutFieldObject instanceof FMField && (fMField = (FMField)((Object)layoutFieldObject)).isResetScrollPositionOnExit()) {
                fMField.setResetScrollPositionOnExit(false);
            }
            this.open(this.getContextMenuXPosition(), this.getContextMenuYPosition());
        }
        this.setDisplayContextMenu(false);
    }

    public void prepareToShow(int n, int n2, LayoutFieldObject layoutFieldObject) {
        this.setContextMenuXPosition(n);
        this.setContextMenuYPosition(n2);
        this.setDisplayContextMenu(true);
        this.setActiveField(layoutFieldObject);
    }

    public LayoutFieldObject getActiveField() {
        return this.activeField;
    }

    private void setActiveField(LayoutFieldObject layoutFieldObject) {
        this.activeField = layoutFieldObject;
    }
}

