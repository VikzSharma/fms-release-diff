/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Vector;
import org.jacorb.idl.IDLTreeVisitor;
import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.SymbolList;
import org.jacorb.idl.parser;

public class Definitions
extends SymbolList {
    public Definitions(int n) {
        super(n);
        this.v = new Vector();
    }

    public void setPackage(String string) {
        string = parser.pack_replace(string);
        Enumeration enumeration = this.getElements();
        while (enumeration.hasMoreElements()) {
            IdlSymbol idlSymbol = (IdlSymbol)enumeration.nextElement();
            idlSymbol.setPackage(string);
        }
    }

    public void setEnclosingSymbol(IdlSymbol idlSymbol) {
        if (this.enclosing_symbol != null && this.enclosing_symbol != idlSymbol) {
            this.logger.error("was " + this.enclosing_symbol.getClass().getName() + " now: " + idlSymbol.getClass().getName());
            throw new RuntimeException("Compiler Error: trying to reassign container for " + this.name);
        }
        this.enclosing_symbol = idlSymbol;
        Enumeration enumeration = this.getElements();
        while (enumeration.hasMoreElements()) {
            ((IdlSymbol)enumeration.nextElement()).setEnclosingSymbol(idlSymbol);
        }
    }

    public void set_included(boolean bl) {
        this.included = bl;
        Enumeration enumeration = this.getElements();
        while (enumeration.hasMoreElements()) {
            ((IdlSymbol)enumeration.nextElement()).set_included(bl);
        }
    }

    public Enumeration getElements() {
        return this.v.elements();
    }

    public void print(PrintWriter printWriter) {
        Enumeration enumeration = this.getElements();
        while (enumeration.hasMoreElements()) {
            ((IdlSymbol)enumeration.nextElement()).print(printWriter);
        }
    }

    public void accept(IDLTreeVisitor iDLTreeVisitor) {
        iDLTreeVisitor.visitDefinitions(this);
    }
}

