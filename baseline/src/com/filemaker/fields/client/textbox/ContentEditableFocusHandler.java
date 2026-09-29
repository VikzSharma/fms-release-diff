/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.event.dom.client.BlurEvent
 *  com.google.gwt.event.dom.client.FocusEvent
 */
package com.filemaker.fields.client.textbox;

import com.filemaker.fields.client.textbox.FocusBlurHandler;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.FocusEvent;
import java.util.LinkedList;

public class ContentEditableFocusHandler
implements FocusBlurHandler {
    private LinkedList<FocusBlurHandler> handlers = new LinkedList();
    private boolean enabled = true;

    public void setEnabled(boolean bl) {
        this.enabled = bl;
    }

    public boolean getEnabled() {
        return this.enabled;
    }

    public void addFocusBlurHandler(FocusBlurHandler focusBlurHandler) {
        this.handlers.add(focusBlurHandler);
    }

    public void removeFocusBlurHandler(FocusBlurHandler focusBlurHandler) {
        this.handlers.remove(focusBlurHandler);
    }

    public void onBlur(BlurEvent blurEvent) {
        if (this.enabled) {
            for (FocusBlurHandler focusBlurHandler : this.handlers) {
                focusBlurHandler.onBlur(blurEvent);
            }
        }
    }

    public void onFocus(FocusEvent focusEvent) {
        if (this.enabled) {
            for (FocusBlurHandler focusBlurHandler : this.handlers) {
                focusBlurHandler.onFocus(focusEvent);
            }
        }
    }
}

