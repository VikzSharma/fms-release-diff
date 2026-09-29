/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.event.ConnectorEventListener
 *  com.vaadin.ui.Component
 *  com.vaadin.ui.Component$Event
 *  com.vaadin.util.ReflectTools
 */
package com.filemaker.fields.interfaces;

import com.vaadin.event.ConnectorEventListener;
import com.vaadin.ui.Component;
import com.vaadin.util.ReflectTools;
import java.lang.reflect.Method;

public class TextAreaEvents {

    public static interface LineBreakBlockedListener
    extends ConnectorEventListener {
        public static final Method lineBreakBlockedMethod = ReflectTools.findMethod(LineBreakBlockedListener.class, (String)"lineBreakBlocked", (Class[])new Class[]{LineBreakBlockedEvent.class});

        public void lineBreakBlocked(LineBreakBlockedEvent var1);
    }

    public static class LineBreakBlockedEvent
    extends Component.Event {
        public static final String EVENT_ID = "linebreak";

        public LineBreakBlockedEvent(Component component) {
            super(component);
        }
    }
}

