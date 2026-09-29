/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vaadin.shared.ui.Connect
 *  com.vaadin.v7.client.ui.textarea.TextAreaConnector
 */
package com.filemaker.fields.client.textarea;

import com.filemaker.fields.DeprecatedTextArea;
import com.filemaker.fields.client.textarea.VCustomDeprecatedTextArea;
import com.vaadin.shared.ui.Connect;
import com.vaadin.v7.client.ui.textarea.TextAreaConnector;

@Connect(value=DeprecatedTextArea.class)
public class DeprecatedTextAreaConnector
extends TextAreaConnector {
    public VCustomDeprecatedTextArea getWidget() {
        return (VCustomDeprecatedTextArea)super.getWidget();
    }
}

