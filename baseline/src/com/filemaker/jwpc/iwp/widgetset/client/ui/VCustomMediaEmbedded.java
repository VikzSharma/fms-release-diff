/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.JavaScriptObject
 *  com.google.gwt.dom.client.Element
 *  com.google.gwt.user.client.Event
 *  com.vaadin.client.ApplicationConnection
 *  com.vaadin.client.BrowserInfo
 *  com.vaadin.client.ui.VEmbedded
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.filemaker.jwpc.iwp.widgetset.client.state.MediaEmbeddedState;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCFieldEventManager;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMCUtilities;
import com.filemaker.jwpc.iwp.widgetset.client.ui.FMClientTooltipHandler;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.Event;
import com.vaadin.client.ApplicationConnection;
import com.vaadin.client.BrowserInfo;
import com.vaadin.client.ui.VEmbedded;

public class VCustomMediaEmbedded
extends VEmbedded {
    private boolean autoPlay;
    private String width = "";
    private String height = "";
    private String filename = "";
    private JavaScriptObject fullScreenHandler = null;
    private int mebs = 0;

    public VCustomMediaEmbedded() {
        this.addStyleName("fm-interactive-media-embedded");
        FMClientTooltipHandler.registerMouseEvents(this.getElement());
    }

    public void setMebs(int n) {
        this.mebs = n;
    }

    private boolean getBooleanState(MediaEmbeddedState.BooleanState booleanState) {
        return FMCUtilities.getBooleanValue(this.mebs, booleanState.ordinal());
    }

    public void onBrowserEvent(Event event) {
        super.onBrowserEvent(event);
        if (this.getBooleanState(MediaEmbeddedState.BooleanState.hasTooltip)) {
            FMClientTooltipHandler.getInstance().handleEvent(event, this.client);
        }
    }

    protected void onUnload() {
        if (!FMCUtilities.isMobile()) {
            this.addFullScreenEventHandler(false);
        }
    }

    public boolean isAutoPlay() {
        return this.autoPlay;
    }

    public void updateParameters(String string, String string2, String string3, String string4, String string5, String string6) {
        if (string != null && !string.isEmpty() && this.autoPlay != Boolean.valueOf(string)) {
            this.autoPlay = Boolean.valueOf(string);
        }
        if (string2 != null && !string2.isEmpty() && !this.height.equals(string2)) {
            this.height = string2;
        }
        if (string3 != null && !string3.isEmpty() && !this.width.equals(string3)) {
            this.width = string3;
        }
        if (string4 != null && !string4.isEmpty() && !this.filename.equals(string4)) {
            this.filename = string4;
        }
        if (string5 != null) {
            this.setHTML(this.constructMediaTag(string6, string5));
        }
        if (!FMCUtilities.isMobile() && string6 != null && FMCUtilities.isHTML5SupportedMediaType(string6) && string6.startsWith("video")) {
            this.addFullScreenEventHandler(true);
        }
    }

    private void addFullScreenEventHandler(boolean bl) {
        if (bl) {
            if (this.fullScreenHandler == null) {
                if (BrowserInfo.get().isWebkit()) {
                    this.fullScreenHandler = VCustomMediaEmbedded.addWebKitFullScreenEventHandler(this, (Element)this.getElement());
                } else if (BrowserInfo.get().isIE()) {
                    this.fullScreenHandler = VCustomMediaEmbedded.addIEFullScreenEventHandler(this);
                } else if (BrowserInfo.get().isEdge()) {
                    this.fullScreenHandler = VCustomMediaEmbedded.addEdgeFullScreenEventHandler(this);
                }
            }
        } else if (this.fullScreenHandler != null) {
            if (BrowserInfo.get().isWebkit()) {
                VCustomMediaEmbedded.removeWebKitFullScreenEventHandler(this.fullScreenHandler, (Element)this.getElement());
            } else if (BrowserInfo.get().isIE()) {
                VCustomMediaEmbedded.removeIEFullScreenEventHandler(this.fullScreenHandler);
            } else if (BrowserInfo.get().isEdge()) {
                VCustomMediaEmbedded.removeEdgeFullScreenEventHandler(this.fullScreenHandler);
            }
            this.fullScreenHandler = null;
        }
    }

    private void onPlayingFullScreen(boolean bl) {
        FMCFieldEventManager.getCommunicationConnector().setIsPlayingFullScreen(bl);
    }

    private static native JavaScriptObject addWebKitFullScreenEventHandler(VCustomMediaEmbedded var0, Element var1);

    private static native void removeWebKitFullScreenEventHandler(JavaScriptObject var0, Element var1);

    private static native JavaScriptObject addIEFullScreenEventHandler(VCustomMediaEmbedded var0);

    private static native void removeIEFullScreenEventHandler(JavaScriptObject var0);

    private static native JavaScriptObject addEdgeFullScreenEventHandler(VCustomMediaEmbedded var0);

    private static native void removeEdgeFullScreenEventHandler(JavaScriptObject var0);

    public String getSrc(String string, ApplicationConnection applicationConnection) {
        String string2 = applicationConnection.translateVaadinUri(string);
        if (string2 == null) {
            return "";
        }
        return string2;
    }

    protected String constructMediaTag(String string, String string2) {
        if (FMCUtilities.isHTML5SupportedMediaType(string)) {
            if (string.startsWith("video")) {
                return this.constructVideoTag(string, string2);
            }
            return this.constructAudioTag(string, string2);
        }
        return this.constructObjectTag(string, string2);
    }

    protected String constructAudioTag(String string, String string2) {
        StringBuilder stringBuilder = new StringBuilder("<audio controls");
        if (this.isAutoPlay()) {
            stringBuilder.append(" autoplay");
        }
        if (string != null && string.length() > 0) {
            stringBuilder.append(" type=\"");
            stringBuilder.append(string);
            stringBuilder.append("\"");
        }
        stringBuilder.append(" src=\"" + string2 + "\">");
        stringBuilder.append(" Your browser does not support the audio element. </audio>");
        return stringBuilder.toString();
    }

    protected String constructVideoTag(String string, String string2) {
        StringBuilder stringBuilder = new StringBuilder("<video controls");
        if (this.isAutoPlay()) {
            stringBuilder.append(" autoplay");
        }
        if (string != null && string.length() > 0) {
            stringBuilder.append(" type=\"");
            stringBuilder.append(string);
            stringBuilder.append("\"");
        }
        if (this.width != null && this.width.length() > 0) {
            stringBuilder.append(" width=\"" + this.width + "\"");
        }
        if (this.height != null && this.height.length() > 0) {
            stringBuilder.append(" height=\"" + this.height + "\"");
        }
        stringBuilder.append(" src=\"" + string2 + "\">");
        stringBuilder.append(" Your browser does not support the video element. </video>");
        return stringBuilder.toString();
    }

    protected String constructObjectTag(String string, String string2) {
        StringBuilder stringBuilder = new StringBuilder("<object");
        if (string != null && string.length() > 0) {
            stringBuilder.append(" type=\"");
            stringBuilder.append(string);
            stringBuilder.append("\"");
        }
        stringBuilder.append(" data=\"" + string2 + "\"");
        if (this.width != null && this.width.length() > 0) {
            stringBuilder.append(" width=\"" + this.width + "\"");
        }
        if (this.height != null && this.height.length() > 0) {
            stringBuilder.append(" height=\"" + this.height + "\"");
        }
        stringBuilder.append("><param name=\"scale\" value=\"ToFit\">");
        stringBuilder.append("<param name=\"src\" value=\"");
        stringBuilder.append(string2);
        stringBuilder.append("\">");
        if (this.isAutoPlay()) {
            stringBuilder.append("<param name=\"autoplay\" value=\"true\" />");
        } else {
            stringBuilder.append("<param name=\"autoplay\" value=\"false\" />");
        }
        this.addFallbackHyperlink(stringBuilder, string2);
        stringBuilder.append("</object>");
        return stringBuilder.toString();
    }

    protected void addFallbackHyperlink(StringBuilder stringBuilder, String string) {
        if (this.filename != null && this.filename.length() > 0) {
            stringBuilder.append("<span>");
            if (string != null && string.length() > 0) {
                stringBuilder.append("<a href=\"");
                stringBuilder.append(string);
                stringBuilder.append("\" target=\"_blank\">");
            }
            stringBuilder.append(this.filename);
            if (string != null && string.length() > 0) {
                stringBuilder.append("</a>");
            }
            stringBuilder.append("</span>");
        }
    }
}

