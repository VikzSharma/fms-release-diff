/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl.runtime;

import org.jacorb.idl.runtime.token;

public class str_token
extends token {
    public String str_val;

    public str_token(int n, String string) {
        super(n);
        this.str_val = string;
    }

    public str_token(int n) {
        this(n, "");
    }
}

