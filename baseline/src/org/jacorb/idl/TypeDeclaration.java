/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import java.util.Set;
import org.jacorb.idl.Declaration;
import org.jacorb.idl.IDLTreeVisitor;
import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.NoHelperException;
import org.jacorb.idl.Value;
import org.jacorb.idl.parser;

public class TypeDeclaration
extends Declaration {
    boolean typedefd = false;
    public TypeDeclaration type_decl;

    public TypeDeclaration(int n) {
        super(n);
        this.pack_name = "";
    }

    public Object clone() {
        return this.type_decl.clone();
    }

    public TypeDeclaration declaration() {
        return this.type_decl;
    }

    public String typeName() {
        return this.type_decl.typeName();
    }

    public String getJavaTypeName() {
        return this.type_decl.getJavaTypeName();
    }

    public String getIDLTypeName() {
        return this.type_decl.getIDLTypeName();
    }

    public void markTypeDefd(String string) {
        this.type_decl.markTypeDefd(string);
    }

    public String getRecursiveTypeCodeExpression() {
        if (this.type_decl == null) {
            return "org.omg.CORBA.ORB.init().create_recursive_tc (\"" + this.id() + "\")";
        }
        return this.type_decl.getRecursiveTypeCodeExpression();
    }

    public String getTypeCodeExpression(Set set) {
        if (this.type_decl instanceof Value) {
            return this.type_decl.getTypeCodeExpression(set);
        }
        return this.type_decl.getTypeCodeExpression();
    }

    public String getTypeCodeExpression() {
        return this.type_decl.getTypeCodeExpression();
    }

    public boolean basic() {
        return this.type_decl.basic();
    }

    public void setPackage(String string) {
        string = parser.pack_replace(string);
        this.type_decl.setPackage(string);
    }

    public void set_included(boolean bl) {
        this.included = bl;
        this.type_decl.set_included(bl);
    }

    public void parse() {
        this.type_decl.parse();
    }

    public String holderName() {
        return this.type_decl.holderName();
    }

    public String helperName() throws NoHelperException {
        if (this.type_decl == null) {
            throw new NoHelperException();
        }
        return this.type_decl.helperName();
    }

    public void print(PrintWriter printWriter) {
        this.type_decl.print(printWriter);
    }

    public String toString() {
        return this.type_decl.toString();
    }

    public void setEnclosingSymbol(IdlSymbol idlSymbol) {
        if (this.enclosing_symbol != null && this.enclosing_symbol != idlSymbol) {
            this.logger.error("was " + this.enclosing_symbol.getClass().getName() + " now: " + idlSymbol.getClass().getName());
            throw new RuntimeException("Compiler Error: trying to reassign container for " + this.name);
        }
        this.enclosing_symbol = idlSymbol;
        this.type_decl.setEnclosingSymbol(idlSymbol);
    }

    public String printReadExpression(String string) {
        return this.type_decl.printReadExpression(string);
    }

    public String printReadStatement(String string, String string2) {
        return string + "=" + this.printReadExpression(string2) + ";";
    }

    public String printWriteStatement(String string, String string2) {
        return this.type_decl.printWriteStatement(string, string2);
    }

    public void accept(IDLTreeVisitor iDLTreeVisitor) {
        this.type_decl.accept(iDLTreeVisitor);
    }

    public void printInsertIntoAny(PrintWriter printWriter, String string, String string2) {
        this.type_decl.printInsertIntoAny(printWriter, string, string2);
    }

    public void printExtractResult(PrintWriter printWriter, String string, String string2, String string3) {
        this.type_decl.printExtractResult(printWriter, string, string2, string3);
    }
}

