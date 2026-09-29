/*
 * Decompiled with CFR 0.152.
 */
package com.filemaker.jwpc.fmwp.datatype;

import com.filemaker.jwpc.fmwp.datatype.BitFlags;

public class RequestOptionSet
extends BitFlags {
    public RequestOptionSet(int n) {
        super(n);
    }

    public static enum RequestOptionBit {
        HasPreScript(1),
        HasPreScriptParam(2),
        HasPreSortScript(4),
        HasPreSortScriptParam(8),
        HasScript(16),
        HasScriptParam(32),
        IncludeFieldSpec(64),
        IncludeFieldLaySpec(128),
        GroupPortalFields(256);

        private int value;

        private RequestOptionBit(int n2) {
            this.value = n2;
        }

        public int value() {
            return this.value;
        }
    }
}

