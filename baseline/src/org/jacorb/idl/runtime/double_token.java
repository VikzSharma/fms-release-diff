/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl.runtime;

import org.jacorb.idl.runtime.token;

public class double_token
extends token {
    public double double_val;

    public double_token(int n, double d) {
        super(n);
        this.double_val = d;
    }

    public double_token(int n) {
        this(n, 0.0);
    }
}

