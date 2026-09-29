/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.ui.statusarea.listener;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.ui.statusarea.component.NativeSelect;
import com.filemaker.jwpc.iwp.ui.statusarea.listener.NativeSelectListener;

public final class StatusAreaListenerInitiator {
    public void initiateNativeSelect(App app, NativeSelect nativeSelect) {
        NativeSelectListener nativeSelectListener = new NativeSelectListener(app, nativeSelect);
        nativeSelect.addValueChangeListener(nativeSelectListener);
    }
}

