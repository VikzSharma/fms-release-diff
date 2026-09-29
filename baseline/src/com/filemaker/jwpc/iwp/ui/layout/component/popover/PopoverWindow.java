/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.event.Action
 *  com.vaadin.server.PaintException
 *  com.vaadin.server.PaintTarget
 *  com.vaadin.server.Sizeable$Unit
 *  com.vaadin.ui.AbsoluteLayout
 *  com.vaadin.ui.Component
 *  com.vaadin.ui.CssLayout
 *  com.vaadin.ui.UI
 *  com.vaadin.ui.Window
 *  com.vaadin.ui.Window$CloseShortcut
 *  org.vaadin.ui.ScrollEventPanel$ScrollListener
 */
package com.filemaker.jwpc.iwp.ui.layout.component.popover;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.application.AppServlet;
import com.filemaker.jwpc.iwp.metadata.PopoverMetaData;
import com.filemaker.jwpc.iwp.ui.cardstylewindow.CardStyleWindow;
import com.filemaker.jwpc.iwp.ui.common.BusyDialog;
import com.filemaker.jwpc.iwp.ui.layout.LayoutView;
import com.filemaker.jwpc.iwp.ui.layout.ObjectAttributes;
import com.filemaker.jwpc.iwp.ui.layout.component.Popover;
import com.filemaker.jwpc.iwp.ui.layout.component.SegmentedBar;
import com.filemaker.jwpc.iwp.ui.layout.component.popover.PopoverButton;
import com.filemaker.jwpc.iwp.ui.layout.form.LayoutFormView;
import com.filemaker.jwpc.iwp.util.IWPUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.state.PopoverWindowState;
import com.vaadin.event.Action;
import com.vaadin.server.PaintException;
import com.vaadin.server.PaintTarget;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;
import java.util.ArrayList;
import java.util.Collection;
import org.vaadin.ui.ScrollEventPanel;

public class PopoverWindow
extends Window {
    private static final String POPOVER_CSS_CLASS = "iwp-popover";
    private static final String POPOVER_LAYOUT_CSS_CLASS = "iwp-popover-layout";
    private static final String ANCHOR_LEFT_CSS_CLASS = "iwp-popover-anchor-left";
    private static final String ANCHOR_RIGHT_CSS_CLASS = "iwp-popover-anchor-right";
    private static final String ANCHOR_TOP_CSS_CLASS = "iwp-popover-anchor-top";
    private static final String ANCHOR_BOTTOM_CSS_CLASS = "iwp-popover-anchor-bottom";
    private static final int ANCHOR_HEIGHT_IN_PIXELS = 12;
    private static final int ANCHOR_WIDTH_IN_PIXELS = 24;
    private static final int CUSHION_SIZE_IN_PIXELS = 5;
    private static final int MINIMUM_TOP_WITHOUT_STATUSAREA_IN_PIXELS = 5;
    private static final int MINIMUM_TOP_WITH_STATUSAREA_IN_PIXELS = 49;
    private final App app;
    private LayoutView view;
    private final PopoverButton button;
    private Popover popover;
    private PopoverWindowLayout windowLayout;
    private boolean modalWindowInDisplay = false;
    private FormScrollListener scrollListener;

    public PopoverWindow(App app, PopoverButton popoverButton) {
        this.app = app;
        this.view = app.getLayoutContainer().getCurrentView();
        this.button = popoverButton;
        this.button.setPopoverWindow(this);
        this.initPopover();
        this.setStyleName(app.getAppView().isCardStyleWindow() ? "iwp-card-window" : "iwp-layout-container");
        this.addStyleName(POPOVER_CSS_CLASS);
        this.setClosable(false);
        this.setResizable(false);
        this.setCloseShortcut(27, new int[0]);
    }

    public void refresh() {
        if (this.popover != null) {
            this.popover.refresh();
        }
    }

    private void initPopover() {
        if (this.scrollListener != null && this.view instanceof LayoutFormView) {
            ((LayoutFormView)this.view).addScrollListener(this.scrollListener);
        }
        this.popover = this.generatePopover(this.view, this.button);
    }

    public void setCloseShortcut(int n, int ... nArray) {
        Collection collection = this.getCloseShortcuts();
        if (collection != null) {
            this.removeAllCloseShortcuts();
        }
        PopoverCloseShortcut popoverCloseShortcut = new PopoverCloseShortcut(this, n, nArray);
        this.addAction((Action)popoverCloseShortcut);
    }

    public void show() {
        this.button.setEnabled(true);
        this.button.refreshButtonClientInfo();
    }

    public synchronized void show(int n, int n2) {
        if (!this.popover.isHideConditionOn()) {
            this.app.enableTouchScroll(false);
            this.setVisible(true);
            this.closeOpenPopOvers();
            this.app.addWindow(this);
            this.display(n, n2);
            this.scrollListener = new FormScrollListener();
            LayoutView layoutView = this.app.getLayoutContainer().getCurrentView();
            if (layoutView instanceof LayoutFormView) {
                ((LayoutFormView)layoutView).addScrollListener(this.scrollListener);
            }
            if (this.button.getMetaData().isSegmentedObject()) {
                ((SegmentedBar)this.button.getParentComponent()).setActiveSegment(this.button);
            }
            this.focus();
        }
    }

    public void focus() {
        if (!this.app.getActiveUIHandler().isActiveObjectInPopover()) {
            super.focus();
        } else {
            this.bringToFront();
        }
        this.app.pushChanges();
    }

    public void bringToFront() {
        UI uI = this.getUI();
        if (uI != null) {
            for (Window window : uI.getWindows()) {
                if (!(window.isModal() & !(window instanceof CardStyleWindow) & !(window instanceof BusyDialog))) continue;
                this.modalWindowInDisplay = true;
                return;
            }
        }
    }

    public synchronized void paintContent(PaintTarget paintTarget) throws PaintException {
        if (this.modalWindowInDisplay) {
            paintTarget.addAttribute("bringToFront", -1);
            this.modalWindowInDisplay = false;
        }
        super.paintContent(paintTarget);
    }

    public PopoverWindowState getState() {
        return (PopoverWindowState)super.getState();
    }

    public void beforeClientResponse(boolean bl) {
        super.beforeClientResponse(bl);
        this.updateBooleanState(PopoverWindowState.BooleanState.hasTooltip, this.getDescription() != null && this.getDescription().length() > 0);
    }

    private void updateBooleanState(PopoverWindowState.BooleanState booleanState, boolean bl) {
        this.getState().pwbs = IWPUtilities.applyBooleanValue(this.getState().pwbs, booleanState.ordinal(), bl);
    }

    private void closeOpenPopOvers() {
        ArrayList<Window> arrayList = new ArrayList<Window>();
        for (Window window : this.app.getWindows()) {
            if (!(window instanceof PopoverWindow)) continue;
            arrayList.add(window);
        }
        for (Window window : arrayList) {
            this.app.removeWindow(window);
        }
    }

    public void close() {
        if (this.getParent() != null) {
            this.button.setEnabled(true);
            this.app.enableTouchScroll(true);
            this.setVisible(false);
            this.closeOpenPopOvers();
            if (this.scrollListener != null) {
                if (this.view instanceof LayoutFormView) {
                    ((LayoutFormView)this.view).removeScrollListener(this.scrollListener);
                }
                this.scrollListener = null;
            }
            if (AppServlet.isAriaCompliantControlEnabled()) {
                this.button.focus();
            } else {
                this.app.focus();
            }
            if (this.popover != null) {
                this.popover.cleanupMemory();
                this.popover = null;
                this.button.setAsActiveSegment(false);
            }
        }
    }

    public void clear() {
        this.close();
        this.button.setPopoverWindow(null);
    }

    public Popover getPopover() {
        return this.popover;
    }

    private Popover generatePopover(LayoutView layoutView, PopoverButton popoverButton) {
        PopoverMetaData popoverMetaData = (PopoverMetaData)layoutView.getLayoutMetaData().getMetaDataByPopoverId(popoverButton.getMetaData().getPopoverObjectId());
        ObjectAttributes objectAttributes = popoverButton.getAttributes();
        Popover popover = layoutView.getUIGenerator().generatePopoverUI(popoverMetaData, objectAttributes.getPartIndex(), objectAttributes.getRecordIndex(), objectAttributes.getRowId(), objectAttributes.getPortalRecordIndex());
        popover.setOwningPopoverButton(popoverButton);
        popover.refresh();
        return popover;
    }

    private void display(int n, int n2) {
        this.windowLayout = new PopoverWindowLayout(n, n2);
        this.setContent((Component)this.windowLayout.contentLayout);
        this.setPositionX(this.windowLayout.popoverAbsoluteLeft);
        this.setPositionY(this.windowLayout.popoverAbsoluteTop);
    }

    private class FormScrollListener
    implements ScrollEventPanel.ScrollListener {
        private FormScrollListener() {
        }

        public void onScroll(int n) {
            PopoverWindow.this.app.getLayoutContainer().getPopoverHandler().exitPopover(true);
        }
    }

    protected class PopoverCloseShortcut
    extends Window.CloseShortcut {
        public PopoverCloseShortcut(Window window, int n, int ... nArray) {
            super(window, n, nArray);
        }

        public void handleAction(Object object, Object object2) {
            PopoverWindow.this.app.getLayoutContainer().getPopoverHandler().exitPopover(true);
        }
    }

    private class PopoverWindowLayout {
        final int buttonAbsoluteTop;
        final int buttonAbsoluteLeft;
        String anchorEdge = "e13";
        int popoverAbsoluteTop = 0;
        int popoverAbsoluteLeft = 0;
        AbsoluteLayout popoverLayout;
        AbsoluteLayout contentLayout;
        CssLayout anchorLayout;
        String popoverPosition;
        String anchorPosition;

        PopoverWindowLayout(int n, int n2) {
            this.buttonAbsoluteTop = n;
            this.buttonAbsoluteLeft = n2;
            this.init();
        }

        private void init() {
            PopoverMetaData popoverMetaData = PopoverWindow.this.popover.getMetaData();
            this.anchorEdge = popoverMetaData.getPreferredAnchorEdge();
            if (this.anchorEdge.equals("e1")) {
                if ((float)(PopoverWindow.this.app.getPage().getBrowserWindowHeight() - this.buttonAbsoluteTop) - PopoverWindow.this.button.getHeight() < (float)(popoverMetaData.getHeightAsInt() + 12)) {
                    this.anchorEdge = "e3";
                }
            } else if (this.anchorEdge.equals("e3")) {
                if (this.buttonAbsoluteTop < popoverMetaData.getHeightAsInt() + 12) {
                    this.anchorEdge = "e1";
                }
            } else if (this.anchorEdge.equals("e2")) {
                if ((float)(PopoverWindow.this.app.getPage().getBrowserWindowWidth() - this.buttonAbsoluteLeft) - PopoverWindow.this.button.getWidth() < (float)(popoverMetaData.getWidthAsInt() + 12)) {
                    this.anchorEdge = "e13";
                }
            } else if (this.buttonAbsoluteLeft < popoverMetaData.getWidthAsInt() + 12) {
                this.anchorEdge = "e2";
            }
            if (this.anchorEdge.equals("e2") || this.anchorEdge.equals("e13")) {
                int n;
                this.popoverAbsoluteLeft = this.anchorEdge.equals("e2") ? this.buttonAbsoluteLeft + this.getPopoverButtonWidth() : this.buttonAbsoluteLeft - (12 + popoverMetaData.getWidthAsInt());
                this.popoverAbsoluteTop = this.buttonAbsoluteTop + (this.getPopoverButtonHeight() - popoverMetaData.getHeightAsInt()) / 2;
                int n2 = this.getMinTop();
                if (this.popoverAbsoluteTop < n2) {
                    this.popoverAbsoluteTop = n2;
                }
                if (this.popoverAbsoluteTop > (n = this.getMaxTop(popoverMetaData))) {
                    this.popoverAbsoluteTop = n;
                }
            } else {
                int n;
                this.popoverAbsoluteTop = this.anchorEdge.equals("e1") ? this.buttonAbsoluteTop + this.getPopoverButtonHeight() : this.buttonAbsoluteTop - (12 + popoverMetaData.getHeightAsInt());
                this.popoverAbsoluteLeft = this.buttonAbsoluteLeft + (this.getPopoverButtonWidth() - popoverMetaData.getWidthAsInt()) / 2;
                int n3 = this.getMinLeft();
                if (this.popoverAbsoluteLeft < n3) {
                    this.popoverAbsoluteLeft = n3;
                }
                if (this.popoverAbsoluteLeft > (n = this.getMaxLeft(popoverMetaData))) {
                    this.popoverAbsoluteLeft = n;
                }
            }
            this.initContent();
        }

        final void initContent() {
            this.contentLayout = new AbsoluteLayout();
            PopoverMetaData popoverMetaData = PopoverWindow.this.popover.getMetaData();
            if (this.anchorEdge.equals("e13") || this.anchorEdge.equals("e2")) {
                this.contentLayout.setWidth((float)(popoverMetaData.getWidthAsInt() + 12), Sizeable.Unit.PIXELS);
                this.contentLayout.setHeight(popoverMetaData.getHeight());
            } else {
                this.contentLayout.setWidth(popoverMetaData.getWidth());
                this.contentLayout.setHeight((float)(popoverMetaData.getHeightAsInt() + 12), Sizeable.Unit.PIXELS);
            }
            this.initPopoverLayout(popoverMetaData);
            this.initPopoverCssPosition();
            this.initPopoverAnchor(popoverMetaData);
            this.initAnchorCssPosition(popoverMetaData);
            this.contentLayout.addComponent((Component)this.popoverLayout, this.popoverPosition);
            this.contentLayout.addComponent((Component)this.anchorLayout, this.anchorPosition);
        }

        private void initPopoverLayout(PopoverMetaData popoverMetaData) {
            this.popoverLayout = new AbsoluteLayout();
            this.popoverLayout.setWidth(popoverMetaData.getWidth());
            this.popoverLayout.setHeight(popoverMetaData.getHeight());
            this.popoverLayout.addStyleName(popoverMetaData.getParent().getTypeSelector());
            this.popoverLayout.addStyleName(PopoverWindow.POPOVER_LAYOUT_CSS_CLASS);
            this.popoverLayout.addComponent((Component)PopoverWindow.this.popover);
        }

        private void initPopoverAnchor(PopoverMetaData popoverMetaData) {
            ArrayList<String> arrayList;
            this.anchorLayout = new CssLayout();
            this.anchorLayout.addStyleName("iwps_popover");
            if (popoverMetaData.hasLocalStyles()) {
                this.anchorLayout.addStyleName(popoverMetaData.getUniqueObjectSelector());
            }
            if ((arrayList = popoverMetaData.getCustomStyles()) != null) {
                for (String string : arrayList) {
                    this.anchorLayout.addStyleName(string);
                }
            }
            if (this.anchorEdge.equals("e2") || this.anchorEdge.equals("e13")) {
                this.anchorLayout.addStyleName(this.anchorEdge.equals("e2") ? PopoverWindow.ANCHOR_LEFT_CSS_CLASS : PopoverWindow.ANCHOR_RIGHT_CSS_CLASS);
                this.anchorLayout.setWidth(12.0f, Sizeable.Unit.PIXELS);
                this.anchorLayout.setHeight(24.0f, Sizeable.Unit.PIXELS);
            } else {
                this.anchorLayout.addStyleName(this.anchorEdge.equals("e1") ? PopoverWindow.ANCHOR_TOP_CSS_CLASS : PopoverWindow.ANCHOR_BOTTOM_CSS_CLASS);
                this.anchorLayout.setWidth(24.0f, Sizeable.Unit.PIXELS);
                this.anchorLayout.setHeight(12.0f, Sizeable.Unit.PIXELS);
            }
        }

        private void initAnchorCssPosition(PopoverMetaData popoverMetaData) {
            int n = 0;
            int n2 = 0;
            if (this.anchorEdge.equals("e2") || this.anchorEdge.equals("e13")) {
                n = this.buttonAbsoluteTop - this.popoverAbsoluteTop + this.getPopoverButtonHeight() / 2 - 12;
                n2 = this.anchorEdge.equals("e2") ? 1 : popoverMetaData.getWidthAsInt() - 1;
            } else {
                n2 = this.buttonAbsoluteLeft - this.popoverAbsoluteLeft + this.getPopoverButtonWidth() / 2 - 12;
                n = this.anchorEdge.equals("e1") ? 1 : popoverMetaData.getHeightAsInt() - 1;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("top:").append(n).append("px;").append("left:").append(n2).append("px;");
            this.anchorPosition = stringBuilder.toString();
        }

        private void initPopoverCssPosition() {
            int n = 0;
            int n2 = 0;
            if (this.anchorEdge.equals("e1")) {
                n = 12;
            } else if (this.anchorEdge.equals("e2")) {
                n2 = 12;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("top:").append(n).append("px;").append("left:").append(n2).append("px;");
            this.popoverPosition = stringBuilder.toString();
        }

        private boolean useDynamicSize() {
            SegmentedBar segmentedBar;
            return PopoverWindow.this.button.getMetaData().isSegmentedObject() && ((segmentedBar = (SegmentedBar)PopoverWindow.this.button.getParentComponent()).getMetaData().hasAutoSizingObjects() || segmentedBar.hasHiddenSegment());
        }

        private int getPopoverButtonWidth() {
            if (this.useDynamicSize() && PopoverWindow.this.button.getWidthUnits() != Sizeable.Unit.PERCENTAGE) {
                return (int)PopoverWindow.this.button.getWidth();
            }
            return PopoverWindow.this.button.getMetaData().getWidthAsInt();
        }

        private int getPopoverButtonHeight() {
            if (this.useDynamicSize() && PopoverWindow.this.button.getHeightUnits() != Sizeable.Unit.PERCENTAGE) {
                return (int)PopoverWindow.this.button.getHeight();
            }
            return PopoverWindow.this.button.getMetaData().getHeightAsInt();
        }

        private int getMinTop() {
            int n = 5;
            if (PopoverWindow.this.app.getAppView().isCardStyleWindow()) {
                n += PopoverWindow.this.app.getAppController().getCardStyleWindowHandler().getWindow().getPositionY();
            } else if (PopoverWindow.this.app.getAppContainer().isStatusAreaVisible()) {
                n = 49;
            }
            return n;
        }

        private int getMaxTop(PopoverMetaData popoverMetaData) {
            int n = PopoverWindow.this.app.getAppView().isCardStyleWindow() ? (int)PopoverWindow.this.app.getAppController().getCardStyleWindowHandler().getWindow().getHeight() : PopoverWindow.this.app.getPage().getBrowserWindowHeight();
            int n2 = n - (popoverMetaData.getHeightAsInt() + 5);
            if (PopoverWindow.this.app.getAppView().isCardStyleWindow()) {
                n2 += PopoverWindow.this.app.getAppController().getCardStyleWindowHandler().getWindow().getPositionY();
            }
            return n2;
        }

        private int getMinLeft() {
            int n = 5;
            if (PopoverWindow.this.app.getAppView().isCardStyleWindow()) {
                n += PopoverWindow.this.app.getAppController().getCardStyleWindowHandler().getWindow().getPositionX();
            }
            return n;
        }

        private int getMaxLeft(PopoverMetaData popoverMetaData) {
            int n = PopoverWindow.this.app.getAppView().isCardStyleWindow() ? (int)PopoverWindow.this.app.getAppController().getCardStyleWindowHandler().getWindow().getWidth() : PopoverWindow.this.app.getPage().getBrowserWindowWidth();
            int n2 = n - (popoverMetaData.getWidthAsInt() + 5);
            if (PopoverWindow.this.app.getAppView().isCardStyleWindow()) {
                n2 += PopoverWindow.this.app.getAppController().getCardStyleWindowHandler().getWindow().getPositionX();
            }
            return n2;
        }
    }
}

