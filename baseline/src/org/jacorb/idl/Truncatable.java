/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.ScopedName;

public class Truncatable
extends IdlSymbol {
    ScopedName scopedName;

    public Truncatable(int n) {
        super(n);
    }

    public String getId() {
        return this.scopedName.id();
    }

    public void print(PrintWriter printWriter) {
        printWriter.print(this.toString());
    }

    public String toString() {
        return "truncatable " + this.scopedName.toString();
    }
}

