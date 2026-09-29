/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl.runtime;

import org.jacorb.idl.runtime.token;

public class long_token
extends token {
    public long long_val;

    public long_token(int n, long l) {
        super(n);
        this.long_val = l;
    }

    public long_token(int n) {
        this(n, 0L);
    }
}

