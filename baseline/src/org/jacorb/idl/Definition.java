/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import org.jacorb.idl.Declaration;
import org.jacorb.idl.IDLTreeVisitor;
import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.parser;

public class Definition
extends IdlSymbol {
    private Declaration declaration;

    public Definition(int n) {
        super(n);
        this.pack_name = "";
    }

    public Definition(Declaration declaration) {
        super(Definition.new_num());
        this.pack_name = "";
        this.declaration = declaration;
    }

    public void setPackage(String string) {
        string = parser.pack_replace(string);
        super.setPackage(string);
        this.declaration.setPackage(string);
    }

    public void setEnclosingSymbol(IdlSymbol idlSymbol) {
        if (this.enclosing_symbol != null && this.enclosing_symbol != idlSymbol) {
            this.logger.error("was " + this.enclosing_symbol.getClass().getName() + " now: " + idlSymbol.getClass().getName());
            throw new RuntimeException("Compiler Error: trying to reassign container for " + this.name);
        }
        this.enclosing_symbol = idlSymbol;
        this.declaration.setEnclosingSymbol(idlSymbol);
    }

    public Declaration get_declaration() {
        return this.declaration;
    }

    public void set_declaration(Declaration declaration) {
        this.declaration = declaration;
    }

    public void set_included(boolean bl) {
        this.included = bl;
        this.declaration.set_included(bl);
    }

    public void print(PrintWriter printWriter) {
        this.declaration.print(printWriter);
    }

    public void parse() {
        this.declaration.parse();
    }

    public void accept(IDLTreeVisitor iDLTreeVisitor) {
        iDLTreeVisitor.visitDefinition(this);
    }
}

