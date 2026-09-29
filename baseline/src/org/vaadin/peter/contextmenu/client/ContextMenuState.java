/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.AbstractComponentState
 */
package org.vaadin.peter.contextmenu.client;

import com.vaadin.shared.AbstractComponentState;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContextMenuState
extends AbstractComponentState {
    private static final long serialVersionUID = -247856391284942254L;
    private List<ContextMenuItemState> rootItems = new ArrayList<ContextMenuItemState>();
    private boolean openAutomatically;
    private boolean hideAutomatically;

    public ContextMenuItemState addChild(String string, String string2) {
        ContextMenuItemState contextMenuItemState = new ContextMenuItemState();
        contextMenuItemState.caption = string;
        contextMenuItemState.id = string2;
        this.rootItems.add(contextMenuItemState);
        return contextMenuItemState;
    }

    public List<ContextMenuItemState> getRootItems() {
        return this.rootItems;
    }

    public void setRootItems(List<ContextMenuItemState> list) {
        this.rootItems = list;
    }

    public boolean isOpenAutomatically() {
        return this.openAutomatically;
    }

    public void setOpenAutomatically(boolean bl) {
        this.openAutomatically = bl;
    }

    public boolean isHideAutomatically() {
        return this.hideAutomatically;
    }

    public void setHideAutomatically(boolean bl) {
        this.hideAutomatically = bl;
    }

    public static class ContextMenuItemState
    implements Serializable {
        private static final long serialVersionUID = 3836772122928080543L;
        private List<ContextMenuItemState> children = new ArrayList<ContextMenuItemState>();
        public String caption;
        public String id;
        public boolean separator;
        public boolean enabled = true;
        private Set<String> styles = new HashSet<String>();

        public ContextMenuItemState addChild(String string, String string2) {
            ContextMenuItemState contextMenuItemState = new ContextMenuItemState();
            contextMenuItemState.caption = string;
            contextMenuItemState.id = string2;
            this.children.add(contextMenuItemState);
            return contextMenuItemState;
        }

        public List<ContextMenuItemState> getChildren() {
            return this.children;
        }

        public void setChildren(List<ContextMenuItemState> list) {
            this.children = list;
        }

        public void removeChild(ContextMenuItemState contextMenuItemState) {
            this.children.remove(contextMenuItemState);
        }

        public Set<String> getStyles() {
            return this.styles;
        }

        public void setStyles(Set<String> set) {
            this.styles = set;
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object instanceof ContextMenuItemState) {
                return this.id.equals(((ContextMenuItemState)object).id);
            }
            return false;
        }

        public int hashCode() {
            return this.id.hashCode();
        }
    }
}

