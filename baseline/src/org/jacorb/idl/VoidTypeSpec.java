/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.TypeSpec;
import org.jacorb.idl.parser;

public class VoidTypeSpec
extends TypeSpec {
    public VoidTypeSpec(int n) {
        super(n);
    }

    public String typeName() {
        return "void";
    }

    public int getTCKind() {
        return 1;
    }

    public boolean basic() {
        return true;
    }

    public void print(PrintWriter printWriter) {
    }

    public String toString() {
        return this.typeName();
    }

    public void setEnclosingSymbol(IdlSymbol idlSymbol) {
        if (this.enclosing_symbol != null && this.enclosing_symbol != idlSymbol) {
            throw new RuntimeException("Compiler Error: trying to reassign container for " + this.name);
        }
        this.enclosing_symbol = idlSymbol;
    }

    public void setPackage(String string) {
        string = parser.pack_replace(string);
    }

    public void parse() {
    }

    public TypeSpec typeSpec() {
        return this;
    }
}

