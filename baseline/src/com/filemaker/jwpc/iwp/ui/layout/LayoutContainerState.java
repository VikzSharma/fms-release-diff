/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.ui.layout;

import com.filemaker.jwpc.iwp.thrift.common.ObjectSpec;
import com.filemaker.jwpc.iwp.ui.layout.LayoutObject;

public final class LayoutContainerState {
    private ListViewRefreshState listviewRefreshState;
    private PortalRefreshState portalRefreshState;
    private LayoutRefreshState layoutRefreshState;
    private LayoutObject activatedSegmentBar;

    LayoutContainerState() {
    }

    public ListViewRefreshState getListViewRefreshState() {
        if (this.listviewRefreshState == null) {
            this.listviewRefreshState = new ListViewRefreshState(this);
        }
        return this.listviewRefreshState;
    }

    public PortalRefreshState getPortalRefreshState() {
        if (this.portalRefreshState == null) {
            this.portalRefreshState = new PortalRefreshState(this);
        }
        return this.portalRefreshState;
    }

    public LayoutRefreshState getLayoutRefreshState() {
        if (this.layoutRefreshState == null) {
            this.layoutRefreshState = new LayoutRefreshState(this);
        }
        return this.layoutRefreshState;
    }

    public LayoutObject getPendingActivatedSegmentBar() {
        return this.activatedSegmentBar;
    }

    public void setPendingActivatedSegmentBar(LayoutObject layoutObject) {
        this.activatedSegmentBar = layoutObject;
    }

    public class ListViewRefreshState {
        private boolean refreshInProgress = false;
        private ObjectSpec activePopoverButtonSpec = null;
        private int activePopoverId = 0;

        ListViewRefreshState(LayoutContainerState layoutContainerState) {
        }

        public synchronized void setRefreshInProgress(boolean bl) {
            this.refreshInProgress = bl;
        }

        public boolean isRefreshInProgress() {
            return this.refreshInProgress;
        }

        public synchronized void setActivePopoverButtonSpec(ObjectSpec objectSpec) {
            this.activePopoverButtonSpec = objectSpec;
        }

        public final ObjectSpec getActivePopoverButtonSpec() {
            return this.activePopoverButtonSpec;
        }

        public synchronized void setActivePopoverId(int n) {
            this.activePopoverId = n;
        }

        public int getActivePopoverId() {
            return this.activePopoverId;
        }
    }

    public class PortalRefreshState {
        private boolean refreshInProgress = false;
        private int portalId = 0;
        private ObjectSpec activePopoverButtonSpec = null;
        private int activePopoverId = 0;

        PortalRefreshState(LayoutContainerState layoutContainerState) {
        }

        public synchronized void setPortalRefreshInProgress(boolean bl, int n) {
            this.refreshInProgress = bl;
            this.portalId = n;
        }

        public boolean isPortalRefreshInProgress(int n) {
            return this.refreshInProgress && this.portalId == n;
        }

        public int getPortalId() {
            return this.portalId;
        }

        public synchronized void setPortalId(int n) {
            this.portalId = n;
        }

        public synchronized void setActivePopoverButtonSpec(ObjectSpec objectSpec) {
            this.activePopoverButtonSpec = objectSpec;
        }

        public final ObjectSpec getActivePopoverButtonSpec() {
            return this.activePopoverButtonSpec;
        }

        public synchronized void setActivePopoverId(int n) {
            this.activePopoverId = n;
        }

        public int getActivePopoverId() {
            return this.activePopoverId;
        }
    }

    public class LayoutRefreshState {
        private boolean refreshInProgress = false;
        private boolean forceRedraw = false;

        LayoutRefreshState(LayoutContainerState layoutContainerState) {
        }

        public synchronized void setRefreshInProgress(boolean bl) {
            this.setRefreshInProgress(bl, false);
        }

        public synchronized void setRefreshInProgress(boolean bl, boolean bl2) {
            this.refreshInProgress = bl;
            this.forceRedraw = bl2;
        }

        public boolean isRefreshInProgress() {
            return this.refreshInProgress;
        }

        public boolean isForceRedraw() {
            return this.forceRedraw;
        }
    }
}

