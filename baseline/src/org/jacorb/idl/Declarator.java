/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.parser;

public class Declarator
extends IdlSymbol {
    public Declarator d;

    public Declarator(int n) {
        super(n);
    }

    public String name() {
        return this.d.name();
    }

    public void setPackage(String string) {
        string = parser.pack_replace(string);
        this.d.setPackage(string);
    }

    public void set_included(boolean bl) {
        this.included = bl;
        this.d.set_included(bl);
    }

    String full_name() {
        return this.d.full_name();
    }

    public void escapeName() {
        this.d.escapeName();
    }

    public void parse() {
        this.d.parse();
    }

    public void print(PrintWriter printWriter) {
    }

    public String toString() {
        return this.d.toString();
    }

    public void setEnclosingSymbol(IdlSymbol idlSymbol) {
        this.d.setEnclosingSymbol(idlSymbol);
    }

    public IdlSymbol getEnclosingSymbol() {
        return this.d.getEnclosingSymbol();
    }
}

