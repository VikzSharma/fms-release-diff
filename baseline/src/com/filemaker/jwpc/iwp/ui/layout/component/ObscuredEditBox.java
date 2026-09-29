/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.ui.layout.component;

import com.filemaker.jwpc.iwp.application.App;
import com.filemaker.jwpc.iwp.metadata.ObjectMetaData;
import com.filemaker.jwpc.iwp.ui.layout.LayoutView;
import com.filemaker.jwpc.iwp.ui.layout.ObjectAttributes;
import com.filemaker.jwpc.iwp.ui.layout.component.EditBox;
import com.filemaker.jwpc.iwp.util.IWPI18N;
import com.filemaker.jwpc.iwp.widgetset.client.rpc.ObscuredEditBoxClientRpc;
import com.filemaker.jwpc.iwp.widgetset.client.state.ObscuredEditBoxState;

public class ObscuredEditBox
extends EditBox {
    private static final String STYLE_NAME = "obscured";

    public ObscuredEditBox(App app, LayoutView layoutView, ObjectMetaData objectMetaData, ObjectAttributes objectAttributes) {
        super(app, layoutView, objectMetaData, objectAttributes);
        this.addStyleName(STYLE_NAME);
        this.getState().obscuredEditBoxDescription = IWPI18N.get(app, "CONCEALED_EDIT_BOX", new Object[0]);
    }

    @Override
    public ObscuredEditBoxState getState() {
        return (ObscuredEditBoxState)super.getState();
    }

    public void onErrorMessageDisplay() {
        ((ObscuredEditBoxClientRpc)this.getRpcProxy(ObscuredEditBoxClientRpc.class)).onErrorMessageDisplay();
    }
}

