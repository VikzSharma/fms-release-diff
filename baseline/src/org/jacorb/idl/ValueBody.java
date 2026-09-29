/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.util.Enumeration;
import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.InterfaceBody;
import org.jacorb.idl.ValueAbsDecl;

public class ValueBody
extends InterfaceBody {
    public ValueAbsDecl myAbsValue;

    ValueBody(int n) {
        super(n);
    }

    public void setEnclosingSymbol(IdlSymbol idlSymbol) {
        if (this.enclosing_symbol != null && this.enclosing_symbol != idlSymbol) {
            throw new RuntimeException("Compiler Error: trying to reassign container for " + this.name);
        }
        this.enclosing_symbol = idlSymbol;
        Enumeration enumeration = this.v.elements();
        while (enumeration.hasMoreElements()) {
            ((IdlSymbol)enumeration.nextElement()).setEnclosingSymbol(this.myAbsValue);
        }
    }
}

