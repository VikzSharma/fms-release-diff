/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import java.util.Set;
import org.jacorb.idl.IDLTreeVisitor;
import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.NoHelperException;
import org.jacorb.idl.TypeDeclaration;
import org.jacorb.idl.TypeSpec;
import org.jacorb.idl.parser;

public class ConstrTypeSpec
extends TypeSpec {
    public TypeDeclaration c_type_spec;

    public ConstrTypeSpec(int n) {
        super(n);
    }

    public ConstrTypeSpec(TypeDeclaration typeDeclaration) {
        super(ConstrTypeSpec.new_num());
        this.c_type_spec = typeDeclaration;
    }

    public void set_name(String string) {
        this.c_type_spec.set_name(string);
    }

    public Object clone() {
        ConstrTypeSpec constrTypeSpec = new ConstrTypeSpec(ConstrTypeSpec.new_num());
        constrTypeSpec.c_type_spec = (TypeDeclaration)this.c_type_spec.clone();
        return constrTypeSpec;
    }

    public TypeDeclaration declaration() {
        return this.c_type_spec;
    }

    public void setEnclosingSymbol(IdlSymbol idlSymbol) {
        if (this.enclosing_symbol != null && this.enclosing_symbol != idlSymbol) {
            throw new RuntimeException("Compiler Error: trying to reassign container for " + this.name);
        }
        this.enclosing_symbol = idlSymbol;
        this.c_type_spec.setEnclosingSymbol(idlSymbol);
    }

    public String toString() {
        return this.getFullName(this.typeName());
    }

    public String typeName() {
        return this.c_type_spec.typeName();
    }

    public String full_name() {
        return this.c_type_spec.full_name();
    }

    public String omgPrefix() {
        return this.c_type_spec.omg_package_prefix;
    }

    public TypeSpec typeSpec() {
        return this;
    }

    public boolean basic() {
        return this.c_type_spec.basic();
    }

    public void parse() {
        this.c_type_spec.parse();
    }

    public void setPackage(String string) {
        string = parser.pack_replace(string);
        this.c_type_spec.setPackage(string);
    }

    public String getTypeCodeExpression(Set set) {
        return this.c_type_spec.getTypeCodeExpression(set);
    }

    public String getTypeCodeExpression() {
        return this.c_type_spec.getTypeCodeExpression();
    }

    public void print(PrintWriter printWriter) {
        this.c_type_spec.print(printWriter);
    }

    public String holderName() {
        return this.c_type_spec.holderName();
    }

    public String helperName() throws NoHelperException {
        return this.c_type_spec.helperName();
    }

    public String printReadExpression(String string) {
        return this.c_type_spec.printReadExpression(string);
    }

    public String printWriteStatement(String string, String string2) {
        return this.c_type_spec.printWriteStatement(string, string2);
    }

    public String printInsertExpression() {
        throw new RuntimeException("Should not be called");
    }

    public String printExtractExpression() {
        throw new RuntimeException("Should not be called");
    }

    public String id() {
        return this.c_type_spec.declaration().id();
    }

    public void printInsertIntoAny(PrintWriter printWriter, String string, String string2) {
        this.c_type_spec.printInsertIntoAny(printWriter, string, string2);
    }

    public void printExtractResult(PrintWriter printWriter, String string, String string2, String string3) {
        this.c_type_spec.printExtractResult(printWriter, string, string2, string3);
    }

    public void accept(IDLTreeVisitor iDLTreeVisitor) {
        this.c_type_spec.declaration().accept(iDLTreeVisitor);
    }
}

