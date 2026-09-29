/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl.runtime;

import org.jacorb.idl.runtime.token;

public class float_token
extends token {
    public float float_val;

    public float_token(int n, float f) {
        super(n);
        this.float_val = f;
    }

    public float_token(int n) {
        this(n, 0.0f);
    }
}

