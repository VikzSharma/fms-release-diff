/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl.runtime;

import org.jacorb.idl.runtime.token;

public class int_token
extends token {
    public int int_val;

    public int_token(int n, int n2) {
        super(n);
        this.int_val = n2;
    }

    public int_token(int n) {
        this(n, 0);
    }
}

