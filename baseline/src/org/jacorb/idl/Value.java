/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import org.jacorb.idl.IDLTreeVisitor;
import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.TypeDeclaration;
import org.jacorb.idl.parser;

public class Value
extends TypeDeclaration {
    private Value value;

    public Value(int n) {
        super(n);
        this.pack_name = "";
    }

    public Object clone() {
        return this.value.clone();
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public TypeDeclaration declaration() {
        return this.value;
    }

    public String typeName() {
        return this.value.typeName();
    }

    public String getTypeCodeExpression() {
        return this.value.getTypeCodeExpression();
    }

    public boolean basic() {
        return this.value.basic();
    }

    public void setPackage(String string) {
        string = parser.pack_replace(string);
        this.value.setPackage(string);
    }

    public void set_included(boolean bl) {
        this.included = bl;
        this.value.set_included(bl);
    }

    public void parse() {
        this.value.parse();
    }

    public String holderName() {
        return this.value.holderName();
    }

    public void print(PrintWriter printWriter) {
        this.value.print(printWriter);
    }

    public String toString() {
        return this.value.toString();
    }

    public void setEnclosingSymbol(IdlSymbol idlSymbol) {
        if (this.enclosing_symbol != null && this.enclosing_symbol != idlSymbol) {
            this.logger.error("was " + this.enclosing_symbol.getClass().getName() + " now: " + idlSymbol.getClass().getName());
            throw new RuntimeException("Compiler Error: trying to reassign container for " + this.name);
        }
        if (idlSymbol == null) {
            throw new RuntimeException("Compiler Error: enclosing symbol is null!");
        }
        this.enclosing_symbol = idlSymbol;
        this.value.setEnclosingSymbol(idlSymbol);
    }

    public String printReadExpression(String string) {
        return this.value.printReadExpression(string);
    }

    public String printReadStatement(String string, String string2) {
        return this.value.printReadStatement(string, string2);
    }

    public String printWriteStatement(String string, String string2) {
        return this.value.printWriteStatement(string, string2);
    }

    public void accept(IDLTreeVisitor iDLTreeVisitor) {
        this.value.accept(iDLTreeVisitor);
    }
}

