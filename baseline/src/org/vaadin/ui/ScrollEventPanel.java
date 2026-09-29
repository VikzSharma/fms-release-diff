/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.ui.Panel
 */
package org.vaadin.ui;

import com.vaadin.ui.Panel;
import java.util.ArrayList;
import java.util.List;
import org.vaadin.ui.client.scrolleventpanel.ScrollEventPanelServerRpc;
import org.vaadin.ui.client.scrolleventpanel.ScrollEventPanelState;

public class ScrollEventPanel
extends Panel {
    private List<ScrollListener> scrollListeners = new ArrayList<ScrollListener>();
    private ScrollEventPanelServerRpc rpc = new ScrollEventPanelServerRpc(){

        @Override
        public void onScroll(int n) {
            ScrollEventPanel.this.fireScrollEvent(n);
        }
    };

    public ScrollEventPanel() {
        this.registerRpc(this.rpc);
    }

    private void fireScrollEvent(int n) {
        for (ScrollListener scrollListener : this.scrollListeners) {
            scrollListener.onScroll(n);
        }
    }

    public void addScrollListener(ScrollListener scrollListener) {
        this.scrollListeners.add(scrollListener);
    }

    public void removeScrollListener(ScrollListener scrollListener) {
        this.scrollListeners.remove(scrollListener);
    }

    public void setScrollEventThreshold(int n) {
        this.getState().scrollEventThreshold = n;
    }

    protected ScrollEventPanelState getState() {
        return (ScrollEventPanelState)super.getState();
    }

    public static interface ScrollListener {
        public void onScroll(int var1);
    }
}

