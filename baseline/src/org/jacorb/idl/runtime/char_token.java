/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl.runtime;

import org.jacorb.idl.runtime.token;

public class char_token
extends token {
    public char char_val;

    public char_token(int n, char c) {
        super(n);
        this.char_val = c;
    }

    public char_token(int n) {
        this(n, '\u0000');
    }
}

