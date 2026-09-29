/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.JavaScriptObject
 *  com.google.gwt.core.client.Scheduler
 *  com.google.gwt.core.client.Scheduler$ScheduledCommand
 *  com.google.gwt.dom.client.Document
 *  com.google.gwt.dom.client.Element
 *  com.google.gwt.dom.client.Node
 *  com.google.gwt.dom.client.Style
 *  com.google.gwt.dom.client.Style$Display
 *  com.google.gwt.dom.client.Style$Position
 *  com.google.gwt.dom.client.Style$Unit
 *  com.google.gwt.dom.client.TableCellElement
 *  com.google.gwt.dom.client.TableElement
 *  com.google.gwt.dom.client.TableRowElement
 *  com.google.gwt.dom.client.TableSectionElement
 *  com.google.gwt.event.logical.shared.ResizeEvent
 *  com.google.gwt.event.logical.shared.ResizeHandler
 *  com.google.gwt.event.shared.HandlerRegistration
 *  com.google.gwt.user.client.DOM
 *  com.google.gwt.user.client.Element
 *  com.google.gwt.user.client.Timer
 *  com.google.gwt.user.client.Window
 *  com.google.gwt.user.client.ui.Widget
 *  com.vaadin.client.ApplicationConnection
 *  com.vaadin.client.data.AbstractRemoteDataSource
 *  com.vaadin.client.data.CacheStrategy
 *  com.vaadin.client.data.CacheStrategy$AbstractBasicSymmetricalCacheStrategy
 *  com.vaadin.client.data.DataSource
 *  com.vaadin.client.widget.escalator.RowVisibilityChangeEvent
 *  com.vaadin.client.widget.escalator.RowVisibilityChangeHandler
 *  com.vaadin.client.widget.grid.events.ScrollEvent
 *  com.vaadin.client.widget.grid.events.ScrollHandler
 *  com.vaadin.client.widgets.Grid
 *  com.vaadin.shared.Range
 *  elemental.events.Event
 *  elemental.json.JsonObject
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.jwpc.iwp.widgetset.client.connector.FMCommunicationConnector;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.ListComponentServerRpc;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCFieldEventManager;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCTextField;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.ui.LogUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomPortalTable;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Node;
import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.TableCellElement;
import com.google.gwt.dom.client.TableElement;
import com.google.gwt.dom.client.TableRowElement;
import com.google.gwt.dom.client.TableSectionElement;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.ApplicationConnection;
import com.vaadin.client.data.AbstractRemoteDataSource;
import com.vaadin.client.data.CacheStrategy;
import com.vaadin.client.data.DataSource;
import com.vaadin.client.widget.escalator.RowVisibilityChangeEvent;
import com.vaadin.client.widget.escalator.RowVisibilityChangeHandler;
import com.vaadin.client.widget.grid.events.ScrollEvent;
import com.vaadin.client.widget.grid.events.ScrollHandler;
import com.vaadin.client.widgets.Grid;
import com.vaadin.shared.Range;
import elemental.events.Event;
import elemental.json.JsonObject;

public class VCustomListComponent
extends Grid<JsonObject> {
    private ApplicationConnection client;
    private boolean debugLogEnabled = false;
    private Range visibleRowRange = Range.emptyRange();
    private ListComponentServerRpc serverRpc = null;
    private HandlerRegistration resizeHandler = null;
    private Timer resizeTimer = null;
    private JavaScriptObject beforeScrollingListener = null;
    private boolean isScrolling = false;
    private Timer scrollTimer;
    private RowVisibilityChange lastRowVisibilityChange;
    private ScrollPositionElement scrollPositionElement;
    private boolean scrollPositionEnabled;

    public VCustomListComponent() {
        final TableElement tableElement = (TableElement)this.getEscalator().getTable();
        tableElement.setBorder(0);
        tableElement.setCellSpacing(0);
        tableElement.setCellPadding(0);
        if (FMCUtilities.useAriaCompliantControl()) {
            Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand(){

                public void execute() {
                    TableSectionElement tableSectionElement = tableElement.getTHead();
                    TableRowElement tableRowElement = tableSectionElement.insertRow(-1);
                    tableRowElement.setClassName("hidden-thead");
                    tableRowElement.setAttribute("role", "presentation");
                    TableCellElement tableCellElement = Document.get().createTHElement();
                    tableCellElement.setInnerText("Hidden header to fix WAVE errors");
                    tableCellElement.setAttribute("scope", "col");
                    tableCellElement.setAttribute("role", "presentation");
                    tableCellElement.getStyle().setFontSize(12.0, Style.Unit.PX);
                    tableRowElement.appendChild((Node)tableCellElement);
                }
            });
        }
        this.scrollPositionElement = new ScrollPositionElement();
        this.addRowVisibilityChangeHandler(new RowVisibilityChangeHandler(){

            public void onRowVisibilityChange(RowVisibilityChangeEvent rowVisibilityChangeEvent) {
                Range range = rowVisibilityChangeEvent.getVisibleRowRange();
                boolean bl = VCustomListComponent.this.visibleRowRange.intersects(range);
                boolean bl2 = range.getStart() < VCustomListComponent.this.visibleRowRange.getStart();
                VCustomListComponent.this.lastRowVisibilityChange = new RowVisibilityChange(VCustomListComponent.this, bl, bl2);
                VCustomListComponent.this.visibleRowRange = range;
                if (VCustomListComponent.this.scrollPositionEnabled) {
                    VCustomListComponent.this.scrollPositionElement.announceScrollPosition(range.getStart(), range.length());
                }
                VCustomListComponent.this.onRowVisibilityChanged();
                VCustomListComponent.this.serverRpc.onRowVisibilityChange(range.getStart(), range.getEnd());
                if (VCustomListComponent.this.debugLogEnabled) {
                    LogUtilities.warn("onRowVisibilityChange: start=" + range.getStart() + ", end=" + range.getEnd());
                }
            }
        });
        this.addScrollHandler(new ScrollHandler(){

            public void onScroll(ScrollEvent scrollEvent) {
                if (VCustomListComponent.this.scrollTimer != null) {
                    VCustomListComponent.this.scrollTimer.cancel();
                }
                VCustomListComponent.this.isScrolling = true;
                VCustomListComponent.this.scrollTimer = new Timer(){

                    public void run() {
                        VCustomListComponent.this.isScrolling = false;
                        VCustomListComponent.this.scrollTimer = null;
                    }
                };
                int n = FMCUtilities.isMobile() ? 50 : 100;
                VCustomListComponent.this.scrollTimer.schedule(n);
            }
        });
        this.resizeHandler = Window.addResizeHandler((ResizeHandler)new ResizeHandler(){

            public void onResize(final ResizeEvent resizeEvent) {
                if (VCustomListComponent.this.resizeTimer != null) {
                    VCustomListComponent.this.resizeTimer.cancel();
                }
                VCustomListComponent.this.resizeTimer = new Timer(this){
                    final /* synthetic */ 4 this$1;
                    {
                        this.this$1 = var1_1;
                    }

                    public void run() {
                        if (this.this$1.VCustomListComponent.this.serverRpc != null) {
                            this.this$1.VCustomListComponent.this.serverRpc.onBrowserWindowResized(resizeEvent.getWidth(), resizeEvent.getHeight());
                        }
                        this.this$1.VCustomListComponent.this.resizeTimer = null;
                    }
                };
                VCustomListComponent.this.resizeTimer.schedule(500);
            }
        });
    }

    public void init(ApplicationConnection applicationConnection) {
        this.client = applicationConnection;
    }

    protected void onLoad() {
        super.onLoad();
        this.attachCustomEventListeners();
        this.scrollPositionElement.attach((Element)this.getElement(), this.getEscalator().getTableWrapper());
    }

    protected void onUnload() {
        super.onUnload();
        this.detachCustomEventListeners();
        this.scrollPositionElement.detach();
        if (this.scrollTimer != null) {
            this.scrollTimer.cancel();
        }
        if (this.resizeTimer != null) {
            this.resizeTimer.cancel();
        }
        if (this.resizeHandler != null) {
            this.resizeHandler.removeHandler();
        }
    }

    private void attachCustomEventListeners() {
        this.beforeScrollingListener = this.getBeforeScrollingListener();
        if (!FMCUtilities.isMobile()) {
            this.attachMouseWheelEventHandler((Element)this.getElement(), this.beforeScrollingListener);
        } else {
            this.attachTouchEventHandler((Element)this.getElement(), this.beforeScrollingListener);
        }
    }

    private void detachCustomEventListeners() {
        if (!FMCUtilities.isMobile()) {
            this.detachMouseWheelEventHandler((Element)this.getElement(), this.beforeScrollingListener);
        } else {
            this.detachTouchEventHandler((Element)this.getElement(), this.beforeScrollingListener);
        }
        this.beforeScrollingListener = null;
    }

    public void setDynamicRowHeight(boolean bl) {
        this.getEscalator().setDynamicRowHeight(bl);
    }

    public void setDebugLogEnabled(boolean bl) {
        this.debugLogEnabled = bl;
        this.getEscalator().setDebugLogEnabled(bl);
    }

    public void setScrollPositionEnabled(boolean bl) {
        this.scrollPositionEnabled = bl;
    }

    public void setServerRpc(ListComponentServerRpc listComponentServerRpc) {
        this.serverRpc = listComponentServerRpc;
    }

    public void scrollToDynamicHeightRow(int n) {
        this.getEscalator().scrollToDynamicHeightRow(n);
    }

    public void recalculateScrollbarsForVirtualViewport() {
        this.getEscalator().recalculateScrollbarsForVirtualViewport();
    }

    private void onRowVisibilityChanged() {
        Scheduler.get().scheduleDeferred(() -> {
            this.getEscalator().refreshVisibleRows();
            this.getEscalator().updateDynamicHeightRowPositions(this.lastRowVisibilityChange.getPartialMove(), this.lastRowVisibilityChange.getScrollingUp());
            this.getEscalator().forceRefreshUI();
            if (this.debugLogEnabled) {
                LogUtilities.warn("onRowVisibilityChanged: start=" + this.visibleRowRange.getStart() + ", end=" + this.visibleRowRange.getEnd() + ", totalRowsHeight=" + this.getEscalator().getTotalVisibleRowsHeight());
            }
        });
    }

    public void onDataLoaded() {
        this.onRowVisibilityChanged();
    }

    private native void attachMouseWheelEventHandler(Element var1, JavaScriptObject var2);

    private native void detachMouseWheelEventHandler(Element var1, JavaScriptObject var2);

    private native void attachTouchEventHandler(Element var1, JavaScriptObject var2);

    private native void detachTouchEventHandler(Element var1, JavaScriptObject var2);

    private native JavaScriptObject getBeforeScrollingListener();

    private void onBeforeScrolling(Event event) {
        FMCTextField fMCTextField;
        FMCommunicationConnector fMCommunicationConnector;
        Element element = (Element)event.getTarget();
        Widget widget = FMCUtilities.getWidget(element);
        Widget widget2 = FMCUtilities.getOwningPortal(widget);
        if (!this.isScrolling && widget2 != null && ((VCustomPortalTable)widget2).isScrollable() || !this.isScrolling && widget != null && widget.getParent().getStyleName().contains("show-scrollbars")) {
            event.stopPropagation();
        }
        if ((fMCommunicationConnector = FMCFieldEventManager.getCommunicationConnector()) != null && (fMCTextField = fMCommunicationConnector.getActiveTextField()) != null && fMCTextField.flushTextChangeOnScroll()) {
            this.client.getServerRpcQueue().flush();
        }
    }

    public void setMaxTouchMoveOffset(int n) {
        this.getEscalator().setMaxTouchMoveOffset((double)n);
    }

    public void updatePageLength(int n, final double d, final double d2) {
        if (n >= 0 && d >= 0.0 && d2 >= d) {
            DataSource dataSource = this.getDataSource();
            if (dataSource == null || !(dataSource instanceof AbstractRemoteDataSource)) {
                return;
            }
            AbstractRemoteDataSource abstractRemoteDataSource = (AbstractRemoteDataSource)dataSource;
            abstractRemoteDataSource.setCacheStrategy((CacheStrategy)new CacheStrategy.AbstractBasicSymmetricalCacheStrategy(this){

                public int getMinimumCacheSize(int n) {
                    return (int)((double)n * d);
                }

                public int getMaximumCacheSize(int n) {
                    return (int)((double)n * d2);
                }
            });
        }
    }

    public void resetScrollPosition() {
        Scheduler.get().scheduleDeferred(() -> this.getEscalator().resetScrollPosition());
    }

    private class ScrollPositionElement {
        private Element scrollPositionElement;
        private Element parent;
        private Element tableWrapper;
        private Timer dismissTimer;

        private ScrollPositionElement() {
        }

        public void attach(Element element, Element element2) {
            if (this.scrollPositionElement == null) {
                this.scrollPositionElement = DOM.createDiv();
                this.scrollPositionElement.setClassName("v-table-scrollposition");
                this.scrollPositionElement.getStyle().setPosition(Style.Position.ABSOLUTE);
                this.scrollPositionElement.getStyle().setDisplay(Style.Display.NONE);
                element.appendChild((Node)this.scrollPositionElement);
                this.parent = element;
                this.tableWrapper = element2;
            }
        }

        public void detach() {
            com.google.gwt.user.client.Element element;
            if (this.dismissTimer != null) {
                this.dismissTimer.cancel();
            }
            if (this.scrollPositionElement != null && (element = DOM.getParent((Element)this.scrollPositionElement)) != null) {
                DOM.removeChild((Element)element, (Element)this.scrollPositionElement);
            }
            this.scrollPositionElement = null;
            this.parent = null;
            this.tableWrapper = null;
        }

        public void announceScrollPosition(int n, int n2) {
            int n3 = n + n2;
            int n4 = VCustomListComponent.this.getEscalator().getBody().getRowCount();
            if (n3 > n4) {
                n3 = n4;
            }
            this.scrollPositionElement.setInnerHTML("<span>" + (n + 1) + " &ndash; " + n3 + "...</span>");
            Style style = this.scrollPositionElement.getStyle();
            style.setDisplay(Style.Display.BLOCK);
            style.setMarginLeft(this.getMarginLeft(), Style.Unit.PX);
            style.setMarginTop((double)(-this.tableWrapper.getOffsetHeight()), Style.Unit.PX);
            if (this.dismissTimer != null) {
                this.dismissTimer.cancel();
            }
            this.dismissTimer = new Timer(){

                public void run() {
                    ScrollPositionElement.this.hideScrollPositionAnnotation();
                    ScrollPositionElement.this.dismissTimer = null;
                }
            };
            this.dismissTimer.schedule(1000);
        }

        public void hideScrollPositionAnnotation() {
            if (this.scrollPositionElement != null) {
                this.scrollPositionElement.getStyle().setDisplay(Style.Display.NONE);
            }
        }

        private double getMarginLeft() {
            double d = (Math.min(this.parent.getOffsetWidth(), Window.getClientWidth()) - this.scrollPositionElement.getOffsetWidth()) / 2;
            Element element = FMCUtilities.getElementByClassName("v-panel-content-iwp-list-base-layout-style");
            double d2 = element == null ? 0.0 : (double)element.getScrollLeft();
            return d + d2;
        }
    }

    private class RowVisibilityChange {
        private boolean partialMove;
        private boolean scrollingUp;

        public RowVisibilityChange(VCustomListComponent vCustomListComponent, boolean bl, boolean bl2) {
            this.partialMove = bl;
            this.scrollingUp = bl2;
        }

        public boolean getPartialMove() {
            return this.partialMove;
        }

        public boolean getScrollingUp() {
            return this.scrollingUp;
        }
    }
}

