/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.client.communication.StateChangeEvent
 *  com.vaadin.shared.ui.Connect
 */
package com.filemaker.fields.client.textarea;

import com.filemaker.fields.FMTextArea;
import com.filemaker.fields.client.common.FMConnector;
import com.filemaker.fields.client.textarea.TextAreaState;
import com.filemaker.fields.client.textarea.TextAreaWidget;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.shared.ui.Connect;

@Connect(value=FMTextArea.class)
public class TextAreaConnector
extends FMConnector {
    @Override
    public TextAreaState getState() {
        return (TextAreaState)super.getState();
    }

    @Override
    public TextAreaWidget getWidget() {
        return (TextAreaWidget)super.getWidget();
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
        this.getWidget().setServerText(this.getState().text);
    }
}

