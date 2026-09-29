/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.lang3.builder.ToStringBuilder
 *  org.apache.commons.lang3.builder.ToStringStyle
 */
package com.filemaker.jwpc.common;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class DataObject {
    public String toString() {
        return ToStringBuilder.reflectionToString((Object)this, (ToStringStyle)ToStringStyle.MULTI_LINE_STYLE);
    }

    public static String toString(Object object) {
        try {
            return ToStringBuilder.reflectionToString((Object)object, (ToStringStyle)ToStringStyle.MULTI_LINE_STYLE);
        }
        catch (NullPointerException nullPointerException) {
            return "<null>";
        }
    }
}

