/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl.runtime;

public class symbol {
    public int sym;
    public int parse_state;

    public symbol(int n, int n2) {
        this.sym = n;
        this.parse_state = n2;
    }

    public symbol(int n) {
        this(n, -1);
    }
}

