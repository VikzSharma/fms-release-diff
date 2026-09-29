/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.JavaScriptObject
 *  com.google.gwt.core.client.JsArray
 *  com.google.gwt.dom.client.Document
 *  com.google.gwt.dom.client.Element
 *  com.google.gwt.dom.client.Node
 *  com.google.gwt.dom.client.Style$Unit
 *  com.google.gwt.dom.client.TableCellElement
 *  com.google.gwt.dom.client.TableElement
 *  com.google.gwt.dom.client.TableRowElement
 *  com.google.gwt.dom.client.TableSectionElement
 *  com.google.gwt.user.client.DOM
 *  com.google.gwt.user.client.Event
 *  com.google.gwt.user.client.EventListener
 *  com.google.gwt.user.client.Window$Navigator
 *  com.google.gwt.user.client.ui.Widget
 *  com.vaadin.client.BrowserInfo
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.jwpc.iwp.widgetset.client.state.EditBoxState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCNavigableObject;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomEditBox;
import com.filemaker.jwpc.iwp.widgetset.client.ui.VCustomPortalTable;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Node;
import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.TableCellElement;
import com.google.gwt.dom.client.TableElement;
import com.google.gwt.dom.client.TableRowElement;
import com.google.gwt.dom.client.TableSectionElement;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.EventListener;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.BrowserInfo;
import java.util.Arrays;
import java.util.List;

public final class FMCUtilities {
    public static List<String> supportedTypes = Arrays.asList("video/quicktime", "video/x-ms-wmv", "video/mpeg", "video/mp4", "video/avi", "video/x-m4v", "audio/mpeg", "audio/wav", "audio/aiff", "audio/mp4", "audio/x-ms-wma");

    private FMCUtilities() {
    }

    public static native void updateActiveStyles(String var0, boolean var1);

    public static native boolean hasFocus(Element var0);

    public static native void removeFocus();

    public static native boolean isFindMode();

    public static native boolean isMobile();

    public static native boolean isValidKeyDown();

    public static native int getEventLocation(Event var0);

    public static native boolean eventLocationSupported(Event var0);

    public static native boolean isOrHasTextArea(JavaScriptObject var0);

    public static native boolean isTouchToCommit();

    public static native void setTouchToCommit(boolean var0);

    public static boolean isIE11() {
        return BrowserInfo.get().isIE() && BrowserInfo.get().getBrowserMajorVersion() == 11;
    }

    public static boolean isMSBrowser() {
        return BrowserInfo.get().isIE() || BrowserInfo.get().isEdge();
    }

    public static boolean isSafari() {
        return BrowserInfo.get().isSafari();
    }

    public static native boolean getCanHandleTabKeyDown();

    public static native void setCanHandleTabKeyDown(boolean var0);

    public static boolean getBooleanValue(int n, int n2) {
        return (n & 1 << n2) != 0;
    }

    public static boolean isHTML5SupportedMediaType(String string) {
        switch (supportedTypes.indexOf(string)) {
            case 0: {
                return true;
            }
            case 1: {
                if (!FMCUtilities.isMobile() || !BrowserInfo.get().isChrome()) break;
                return true;
            }
            case 2: {
                if (FMCUtilities.isMobile() || !BrowserInfo.get().isSafari()) break;
                return true;
            }
            case 3: {
                return true;
            }
            case 4: {
                break;
            }
            case 5: {
                return true;
            }
            case 6: {
                if (BrowserInfo.get().isIE()) break;
                return true;
            }
            case 7: {
                if (BrowserInfo.get().isIE() || FMCUtilities.isMobile() && BrowserInfo.get().isSafari()) break;
                return true;
            }
            case 8: {
                if (FMCUtilities.isMobile() || !BrowserInfo.get().isSafari()) break;
                return true;
            }
            case 9: {
                if (BrowserInfo.get().isIE()) break;
                return true;
            }
            case 10: {
                if (!FMCUtilities.isMobile() || !BrowserInfo.get().isChrome()) break;
                return true;
            }
        }
        return false;
    }

    public static native void setHasVirtualKeyboard(boolean var0);

    public static native boolean getHasVirtualKeyboard();

    private static native JavaScriptObject getAppElement();

    public static void enableTouchScroll(boolean bl) {
        Element element;
        if (BrowserInfo.get().isIOS() && (element = (Element)FMCUtilities.getAppElement()) != null) {
            if (bl) {
                element.addClassName("fm-touch-scroll");
            } else {
                element.removeClassName("fm-touch-scroll");
            }
        }
    }

    public static native void attachResizeHandler(JavaScriptObject var0);

    public static native void detachResizeHandler(JavaScriptObject var0);

    public static boolean isInPortal(Widget widget) {
        return FMCUtilities.getOwningPortal(widget) != null;
    }

    public static boolean isInPortal(Widget widget, Widget widget2) {
        return FMCUtilities.getOwningPortal(widget) == widget2;
    }

    public static Widget getOwningPortal(Widget widget) {
        for (Widget widget2 = widget; widget2 != null; widget2 = widget2.getParent()) {
            if (!(widget2 instanceof VCustomPortalTable)) continue;
            return widget2;
        }
        return null;
    }

    public static String normalizeHtmlText(String string) {
        return string.replace("<", "&lt;").replace(">", "&gt;");
    }

    public static native boolean isElementPartiallyInViewport(Element var0);

    public static native boolean isElementInViewport(Element var0);

    public static native String Base64Encode(String var0);

    public static native String Base64Decode(String var0);

    public static Widget getWidget(Element element) {
        EventListener eventListener = DOM.getEventListener((Element)element);
        if (eventListener != null && eventListener instanceof Widget) {
            return (Widget)eventListener;
        }
        return null;
    }

    public static native Element getElementByClassName(String var0);

    public static native String getTextContent(Element var0);

    public static native void cacheContextMenuSelection(String var0, int[] var1);

    public static native int[] getContextMenuSelectionRange();

    public static native void insertHTML(String var0);

    public static native boolean useAriaCompliantControl();

    public static native Element getElementById(String var0);

    public static native Element querySelector(Element var0, String var1);

    public static native JsArray<Element> querySelectorAll(Element var0, String var1);

    public static native Element getClosestElement(Element var0, String var1);

    public static native Element getActiveElement();

    public static native void exportMethods();

    public static void focusIn(Element element) {
        if (FMCUtilities.useAriaCompliantControl()) {
            element.addClassName("v-is-active");
            Element element2 = FMCUtilities.getClosestElement(element, ".v-widget");
            Widget widget = FMCUtilities.getWidget(element2);
            if (widget != null) {
                VCustomEditBox vCustomEditBox;
                if (widget instanceof VCustomEditBox && (vCustomEditBox = (VCustomEditBox)widget).getBooleanState(EditBoxState.BooleanState.hasScript)) {
                    return;
                }
                if (widget instanceof FMCNavigableObject) {
                    ((FMCNavigableObject)widget).onFocusIn(element);
                }
            }
        }
    }

    public static void focusOut(Element element) {
        if (FMCUtilities.useAriaCompliantControl()) {
            element.removeClassName("v-is-active");
            Element element2 = FMCUtilities.getClosestElement(element, ".v-widget");
            Widget widget = FMCUtilities.getWidget(element2);
            if (widget != null && widget instanceof FMCNavigableObject) {
                ((FMCNavigableObject)widget).onFocusOut(element);
            }
        }
    }

    public static native void debugElement(String var0, Element var1);

    public static native Element getLastActiveElement();

    public static native String getUUID();

    public static boolean isWindowsClient() {
        return Window.Navigator.getPlatform().toLowerCase().contains("win");
    }

    public static void fixLayoutTableAlert(Element element) {
        JsArray<Element> jsArray = FMCUtilities.querySelectorAll(element, "table");
        for (int i = 0; i < jsArray.length(); ++i) {
            TableElement tableElement = (TableElement)jsArray.get(i);
            if (tableElement.getTHead() != null) continue;
            TableSectionElement tableSectionElement = tableElement.createTHead();
            tableSectionElement.setClassName("hidden-thead");
            tableSectionElement.setAttribute("role", "presentation");
            tableSectionElement.setAttribute("aria-hidden", "true");
            TableRowElement tableRowElement = tableSectionElement.insertRow(-1);
            tableRowElement.setAttribute("role", "presentation");
            TableCellElement tableCellElement = Document.get().createTHElement();
            tableCellElement.setInnerText("Hidden header to fix WAVE errors");
            tableCellElement.setAttribute("scope", "col");
            tableCellElement.setAttribute("role", "presentation");
            tableCellElement.getStyle().setFontSize(12.0, Style.Unit.PX);
            tableRowElement.appendChild((Node)tableCellElement);
        }
    }
}

