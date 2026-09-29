/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.Scheduler$ScheduledCommand
 *  com.google.gwt.user.client.DOM
 *  com.google.gwt.user.client.Event
 *  com.vaadin.client.ui.VLazyExecutor
 *  com.vaadin.client.ui.VPanel
 */
package org.vaadin.ui.client.scrolleventpanel;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.vaadin.client.ui.VLazyExecutor;
import com.vaadin.client.ui.VPanel;
import java.util.ArrayList;
import java.util.List;

public class VScrollEventPanel
extends VPanel
implements Scheduler.ScheduledCommand {
    private VLazyExecutor executor = new VLazyExecutor(1000, (Scheduler.ScheduledCommand)this);
    private List<ScrollListener> scrollListeners = new ArrayList<ScrollListener>();
    private boolean fireEvent = true;

    public void onBrowserEvent(Event event) {
        super.onBrowserEvent(event);
        int n = DOM.eventGetType((Event)event);
        if (n == 16384) {
            this.fireScrollEvent();
            this.executor.trigger();
        }
    }

    private void fireScrollEvent() {
        if (this.fireEvent) {
            this.fireEvent = false;
            for (ScrollListener scrollListener : this.scrollListeners) {
                scrollListener.onScroll(new ScrollEvent(this.getContainerElement().getScrollTop()));
            }
        }
    }

    public void setScrollEventThreshold(int n) {
        if (n == 0) {
            this.executor = null;
            this.fireEvent = false;
        } else {
            this.executor = new VLazyExecutor(n, (Scheduler.ScheduledCommand)this);
            this.fireEvent = true;
        }
    }

    public void execute() {
        if (this.executor != null) {
            this.fireEvent = true;
        }
    }

    public void addScrollListener(ScrollListener scrollListener) {
        this.scrollListeners.add(scrollListener);
    }

    public static interface ScrollListener {
        public void onScroll(ScrollEvent var1);
    }

    public class ScrollEvent {
        private int scrollPosition;

        public int getScrollPosition() {
            return this.scrollPosition;
        }

        public ScrollEvent(int n) {
            this.scrollPosition = n;
        }
    }
}

