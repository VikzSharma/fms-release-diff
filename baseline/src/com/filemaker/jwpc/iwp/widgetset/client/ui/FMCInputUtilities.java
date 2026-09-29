/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.dom.client.EventTarget
 *  com.google.gwt.dom.client.NativeEvent
 *  com.google.gwt.event.shared.HandlerRegistration
 *  com.google.gwt.user.client.Event
 *  com.google.gwt.user.client.Event$NativePreviewEvent
 *  com.google.gwt.user.client.Event$NativePreviewHandler
 */
package com.filemaker.jwpc.iwp.widgetset.client.ui;

import com.google.gwt.dom.client.EventTarget;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Event;
import java.util.ArrayList;
import java.util.List;

public class FMCInputUtilities {
    private static HandlerRegistration registration = null;
    private static List<InputPreviewHandler> handlers = new ArrayList<InputPreviewHandler>();
    private static EventTarget lastEventTarget = null;
    private static InteractionSource lastInteractionSource = InteractionSource.UNKNOWN;
    private static int lastKeyboardKeyCode = -1;

    private FMCInputUtilities() {
    }

    public static void startGlobalPreview() {
        if (registration == null) {
            registration = Event.addNativePreviewHandler((Event.NativePreviewHandler)new Event.NativePreviewHandler(){

                public void onPreviewNativeEvent(Event.NativePreviewEvent nativePreviewEvent) {
                    int n = nativePreviewEvent.getTypeInt();
                    NativeEvent nativeEvent = nativePreviewEvent.getNativeEvent();
                    boolean bl = false;
                    if (n == 128) {
                        lastEventTarget = nativeEvent.getEventTarget();
                        lastInteractionSource = InteractionSource.KEYBOARD;
                        lastKeyboardKeyCode = nativeEvent.getKeyCode();
                        bl = true;
                    } else if (n == 4) {
                        lastEventTarget = nativeEvent.getEventTarget();
                        lastInteractionSource = InteractionSource.MOUSE;
                        lastKeyboardKeyCode = -1;
                        bl = true;
                    } else if (n == 0x100000) {
                        lastEventTarget = nativeEvent.getEventTarget();
                        lastInteractionSource = InteractionSource.TOUCH;
                        lastKeyboardKeyCode = -1;
                        bl = true;
                    }
                    if (bl) {
                        for (InputPreviewHandler inputPreviewHandler : handlers) {
                            inputPreviewHandler.onPreviewInputEvent(nativePreviewEvent);
                        }
                    }
                }
            });
        }
    }

    public static void stopGlobalPreview() {
        if (registration != null) {
            registration.removeHandler();
            registration = null;
        }
    }

    public static void addHandler(InputPreviewHandler inputPreviewHandler) {
        if (inputPreviewHandler != null && !handlers.contains(inputPreviewHandler)) {
            handlers.add(inputPreviewHandler);
        }
    }

    public static void removeHandler(InputPreviewHandler inputPreviewHandler) {
        if (inputPreviewHandler != null && handlers.contains(inputPreviewHandler)) {
            handlers.remove(inputPreviewHandler);
        }
    }

    public static EventTarget getLastEventTarget() {
        return lastEventTarget;
    }

    public static InteractionSource getLastInteractionSource() {
        return lastInteractionSource;
    }

    public static int getLastKeyboardKeyCode() {
        return lastKeyboardKeyCode;
    }

    public static boolean isKeyboardTab() {
        return lastInteractionSource == InteractionSource.KEYBOARD && lastKeyboardKeyCode == 9;
    }

    public static boolean isKeyboardEnter() {
        return lastInteractionSource == InteractionSource.KEYBOARD && lastKeyboardKeyCode == 13;
    }

    public static enum InteractionSource {
        UNKNOWN,
        KEYBOARD,
        MOUSE,
        TOUCH,
        PROGRAMMATIC;

    }

    public static interface InputPreviewHandler {
        public void onPreviewInputEvent(Event.NativePreviewEvent var1);
    }
}

