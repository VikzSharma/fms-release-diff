/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.JavaScriptObject
 *  com.google.gwt.core.client.Scheduler
 *  com.google.gwt.core.client.Scheduler$ScheduledCommand
 *  com.google.gwt.dom.client.Element
 *  com.google.gwt.dom.client.Node
 *  com.google.gwt.dom.client.NodeList
 *  com.google.gwt.dom.client.Style$Unit
 *  com.google.gwt.event.dom.client.BlurEvent
 *  com.google.gwt.event.dom.client.BlurHandler
 *  com.google.gwt.event.dom.client.FocusEvent
 *  com.google.gwt.event.dom.client.FocusHandler
 *  com.google.gwt.event.dom.client.KeyDownEvent
 *  com.google.gwt.event.dom.client.KeyDownHandler
 *  com.google.gwt.event.shared.EventHandler
 *  com.google.gwt.user.client.DOM
 *  com.google.gwt.user.client.Element
 *  com.google.gwt.user.client.Event
 *  com.vaadin.client.BrowserInfo
 *  com.vaadin.client.ui.VNativeButton
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.jwpc.iwp.widgetset.client.rpc.ButtonServerRpc;
import com.filemaker.jwpc.iwp.widgetset.client.state.ButtonState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMClientEventManager;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMClientTooltipHandler;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Node;
import com.google.gwt.dom.client.NodeList;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.vaadin.client.BrowserInfo;
import com.vaadin.client.ui.VNativeButton;

public class VCustomButton
extends VNativeButton {
    private int glyphPos = 4;
    private int singleLineHeight = 10;
    private final FMClientEventManager eventManager;
    private final Element containerElement = DOM.createDiv();
    private final Element glyphElement = DOM.createDiv();
    private JavaScriptObject windowResizeHandler = null;
    private ButtonServerRpc rpc = null;
    private int bnbs = 0;

    public VCustomButton() {
        this.getElement().removeChild((Node)this.captionElement);
        this.containerElement.appendChild((Node)this.glyphElement);
        this.containerElement.appendChild((Node)this.captionElement);
        this.getElement().appendChild((Node)this.containerElement);
        this.glyphElement.setClassName("fm-button-glyph");
        this.containerElement.setClassName("fm-button-container");
        FMClientTooltipHandler.registerMouseEvents(this.getElement());
        this.eventManager = new FMClientEventManager(this.getElement(), true, true);
        if (FMCUtilities.useAriaCompliantControl()) {
            this.addDomHandler((EventHandler)new KeyDownHandler(){

                public void onKeyDown(KeyDownEvent keyDownEvent) {
                    switch (keyDownEvent.getNativeKeyCode()) {
                        case 13: 
                        case 32: {
                            if (VCustomButton.this.rpc == null) break;
                            VCustomButton.this.rpc.click();
                            break;
                        }
                    }
                }
            }, KeyDownEvent.getType());
            this.addFocusHandler(new FocusHandler(){

                public void onFocus(FocusEvent focusEvent) {
                    VCustomButton.this.getParent().addStyleName("fm-hover");
                }
            });
            this.addBlurHandler(new BlurHandler(){

                public void onBlur(BlurEvent blurEvent) {
                    VCustomButton.this.getParent().removeStyleName("fm-hover");
                }
            });
        }
    }

    public void setBnbs(int n) {
        this.bnbs = n;
    }

    public void setButtonAriaLabel(String string) {
        this.getElement().setAttribute("aria-label", string);
    }

    private boolean getBooleanState(ButtonState.BooleanState booleanState) {
        return FMCUtilities.getBooleanValue(this.bnbs, booleanState.ordinal());
    }

    public void attachWindowResizeHandler() {
        if (this.windowResizeHandler == null) {
            this.windowResizeHandler = this.getWindowResizeHandler(this);
            FMCUtilities.attachResizeHandler(this.windowResizeHandler);
        }
    }

    private native JavaScriptObject getWindowResizeHandler(VCustomButton var1);

    private void onWindowResize() {
        if (this.isClientSideAutoSizingUpdate()) {
            this.updateLabelMaxSize();
        }
    }

    public void onBrowserEvent(Event event) {
        super.onBrowserEvent(event);
        boolean bl = true;
        if (this.getBooleanState(ButtonState.BooleanState.isSegmentedObject) && !FMCUtilities.isMobile()) {
            if (event.getTypeInt() == 16 && this.getParent().getStyleName().contains("fm-selected")) {
                bl = false;
            } else if (event.getTypeInt() == 1) {
                this.getParent().removeStyleName("fm-hover");
            }
        }
        if (bl) {
            this.eventManager.handleEvent(event, this.getParent());
        }
        if (this.getBooleanState(ButtonState.BooleanState.hasTooltip)) {
            FMClientTooltipHandler.getInstance().handleEvent(event, this.client);
        }
    }

    public void onLoad() {
        Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand(){

            public void execute() {
                if (VCustomButton.this.isClientSideAutoSizingUpdate()) {
                    VCustomButton.this.updateLabelMaxSize();
                } else {
                    VCustomButton.this.updateLabelSize(false);
                }
            }
        });
    }

    public void onUnload() {
        super.onUnload();
        if (this.windowResizeHandler != null) {
            FMCUtilities.detachResizeHandler(this.windowResizeHandler);
            this.windowResizeHandler = null;
        }
        this.getParent().removeStyleName("fm-hover");
    }

    public void updateState(ButtonState buttonState) {
        this.singleLineHeight = buttonState.singleLineHeight;
        if (this.glyphPos != buttonState.glyphPos) {
            this.glyphPos = buttonState.glyphPos;
            this.updateGlyphPosition();
        }
        if (buttonState.needToReposition) {
            this.repositionButtonComponent(buttonState.left, buttonState.top);
            buttonState.needToReposition = false;
        }
    }

    public void updateBoundsIfNeeded(int n, int n2, int n3, int n4, boolean bl, boolean bl2) {
        if (!this.getBooleanState(ButtonState.BooleanState.isSegmentedObject) || n == 0 && n2 == 0 && n3 == 0 && n4 == 0) {
            return;
        }
        if (bl) {
            this.repositionButtonComponent(n, n2);
        }
        this.updateContainerSizeIfNeeded(n3, n4, bl);
    }

    private Element getButtonComponent() {
        Element element = null;
        com.google.gwt.user.client.Element element2 = this.getElement();
        if (element2 != null) {
            element = element2.getParentElement();
        }
        return element;
    }

    private Element getParagraphDiv() {
        Element element;
        Element element2 = null;
        Element element3 = this.captionElement;
        if (element3 != null && element3.getElementsByTagName("div").getLength() > 0 && (element = (Element)element3.getElementsByTagName("div").getItem(0)) != null && element.getElementsByTagName("div").getLength() > 0) {
            element2 = (Element)element.getElementsByTagName("div").getItem(0);
        }
        return element2;
    }

    private Element getLabelSpan() {
        Element element;
        Element element2;
        Element element3 = null;
        Element element4 = this.captionElement;
        if (element4 != null && element4.getElementsByTagName("div").getLength() > 0 && (element2 = (Element)element4.getElementsByTagName("div").getItem(0)) != null && element2.getElementsByTagName("div").getLength() > 0 && (element = (Element)element2.getElementsByTagName("div").getItem(0)) != null && element.getElementsByTagName("span").getLength() > 0) {
            element3 = (Element)element.getElementsByTagName("span").getItem(0);
        }
        return element3;
    }

    private int getGlyphPosition() {
        return this.glyphPos;
    }

    private void repositionButtonComponent(int n, int n2) {
        Element element = this.getButtonComponent();
        if (element != null) {
            element.getStyle().setLeft((double)n, Style.Unit.PX);
            element.getStyle().setTop((double)n2, Style.Unit.PX);
        }
    }

    private void updateContainerSizeIfNeeded(int n, int n2, boolean bl) {
        if (BrowserInfo.get().isIE()) {
            this.containerElement.getStyle().setWidth((double)n, Style.Unit.PX);
            this.containerElement.getStyle().setHeight((double)n2, Style.Unit.PX);
        }
        this.updateLabelSize(bl);
    }

    private void updateGlyphPosition() {
        this.containerElement.removeChild((Node)this.glyphElement);
        this.containerElement.removeChild((Node)this.captionElement);
        int n = this.getGlyphPosition();
        switch (n) {
            case 2: 
            case 4: {
                this.containerElement.appendChild((Node)this.glyphElement);
                this.containerElement.appendChild((Node)this.captionElement);
                break;
            }
            case 3: 
            case 5: {
                this.containerElement.appendChild((Node)this.captionElement);
                this.containerElement.appendChild((Node)this.glyphElement);
                break;
            }
            case 1: {
                this.containerElement.appendChild((Node)this.glyphElement);
                break;
            }
            default: {
                this.containerElement.appendChild((Node)this.captionElement);
            }
        }
        if (n == 2 || n == 3) {
            this.containerElement.addClassName("fm-button-container-v");
        } else {
            this.containerElement.removeClassName("fm-button-container-v");
        }
    }

    private void updateLabelSize(final boolean bl) {
        Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand(){
            final /* synthetic */ VCustomButton this$0;
            {
                this.this$0 = vCustomButton;
            }

            public void execute() {
                Element element;
                if (this.this$0.getBooleanState(ButtonState.BooleanState.isSegmentedObject)) {
                    this.this$0.updateSegmentWrapperSize();
                }
                boolean bl2 = this.this$0.getBooleanState(ButtonState.BooleanState.hasAutoResize);
                int n = this.this$0.getGlyphPosition();
                if (n == 0 && !bl2 && !bl || n == 1) {
                    return;
                }
                Element element2 = this.this$0.getLabelSpan();
                if (element2 != null && (element = this.this$0.getParagraphDiv()) != null) {
                    int n2;
                    int n3;
                    if (this.this$0.getBooleanState(ButtonState.BooleanState.isSegmentedObject)) {
                        n3 = this.this$0.containerElement.getOffsetWidth();
                        n2 = this.this$0.glyphElement.getOffsetWidth();
                        if (n == 4 || n == 5) {
                            n3 = n3 - n2 - 4;
                        }
                        element.getStyle().setProperty("max-width", (double)n3, Style.Unit.PX);
                    }
                    if (BrowserInfo.get().isIE()) {
                        element.getStyle().setWidth(100.0, Style.Unit.PCT);
                    } else {
                        n3 = element2.getOffsetHeight();
                        if (n3 > this.this$0.singleLineHeight + 4 && (n2 = this.this$0.getLabelSpanWidth()) + 4 < element.getOffsetWidth()) {
                            if (BrowserInfo.get().isIE()) {
                                n2 += 2;
                            }
                            element.getStyle().setWidth((double)n2, Style.Unit.PX);
                        }
                    }
                }
            }
        });
    }

    private void updateSegmentWrapperSize() {
        Element element;
        com.google.gwt.user.client.Element element2 = this.getParent().getElement();
        if (element2 != null && (element = element2.getParentElement()) != null) {
            if (this.getBooleanState(ButtonState.BooleanState.isSegmentedBarVertical)) {
                element2.getStyle().setWidth((double)element.getClientWidth(), Style.Unit.PX);
            } else {
                element2.getStyle().setHeight((double)element.getClientHeight(), Style.Unit.PX);
            }
        }
    }

    private int getLabelSpanWidth() {
        int n = 0;
        NodeList nodeList = this.captionElement.getElementsByTagName("span");
        if (nodeList != null) {
            for (int i = 0; i < nodeList.getLength(); ++i) {
                Element element = (Element)nodeList.getItem(i);
                if (element == null || !element.getClassName().contains("fm-text-character")) continue;
                n += element.getOffsetWidth();
            }
        }
        return n;
    }

    private void updateLabelMaxSize() {
        Element element;
        Element element2 = this.getLabelSpan();
        if (element2 != null && (element = this.getParagraphDiv()) != null) {
            int n = this.containerElement.getOffsetWidth();
            int n2 = this.glyphElement.getOffsetWidth();
            element.getStyle().setProperty("max-width", (double)(n - n2 - 4), Style.Unit.PX);
        }
    }

    public boolean isClientSideAutoSizing() {
        return this.getBooleanState(ButtonState.BooleanState.CLIENT_SIDE_AUTO_SIZING);
    }

    private boolean isClientSideAutoSizingUpdate() {
        return this.isClientSideAutoSizing() && this.glyphPos != 0 && this.glyphPos != 1;
    }

    public void registerServerRpc(ButtonServerRpc buttonServerRpc) {
        this.rpc = buttonServerRpc;
    }
}

