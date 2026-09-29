/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.iwp.action;

import com.filemaker.jwpc.iwp.thrift.common.Result;
import com.filemaker.jwpc.iwp.thrift.common.UIActionType;

public interface ActionResultHandler {
    public void onFinish(UIActionType var1, Result var2);
}

