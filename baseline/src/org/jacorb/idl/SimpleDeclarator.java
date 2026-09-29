/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import org.jacorb.idl.Declarator;
import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.NameAlreadyDefined;
import org.jacorb.idl.NameTable;
import org.jacorb.idl.lexer;
import org.jacorb.idl.parser;

public class SimpleDeclarator
extends Declarator {
    public SimpleDeclarator(int n) {
        super(n);
    }

    public String name() {
        return this.name;
    }

    public void escapeName() {
        if (!this.name.startsWith("_") && lexer.strictJavaEscapeCheck(this.name)) {
            this.name = "_" + this.name;
        }
    }

    public void parse() {
        try {
            NameTable.define(this.full_name(), "declarator");
        }
        catch (NameAlreadyDefined nameAlreadyDefined) {
            parser.error("Declarator name " + this.full_name() + " already declared in this scope.", this.token);
        }
    }

    public void setEnclosingSymbol(IdlSymbol idlSymbol) {
        if (this.enclosing_symbol != null && this.enclosing_symbol != idlSymbol) {
            throw new RuntimeException("Compiler Error: trying to reassign container for " + this.name);
        }
        this.enclosing_symbol = idlSymbol;
    }

    public IdlSymbol getEnclosingSymbol() {
        return this.enclosing_symbol;
    }

    public void setPackage(String string) {
        string = parser.pack_replace(string);
        this.pack_name = this.pack_name.length() > 0 ? string + "." + this.pack_name : string;
    }

    String full_name() {
        if (this.name.length() == 0) {
            return null;
        }
        if (this.pack_name.length() > 0) {
            return this.pack_name + "." + this.name;
        }
        return this.name;
    }

    public String toString() {
        return this.name;
    }
}

