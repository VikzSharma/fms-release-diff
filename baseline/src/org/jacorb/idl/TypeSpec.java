/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import java.util.Set;
import org.jacorb.idl.ConstrTypeSpec;
import org.jacorb.idl.IDLTreeVisitor;
import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.NoHelperException;
import org.jacorb.idl.TypeDeclaration;
import org.jacorb.idl.parser;

public class TypeSpec
extends IdlSymbol {
    protected String alias = null;
    public TypeSpec type_spec;

    public TypeSpec(int n) {
        super(n);
    }

    public Object clone() {
        TypeSpec typeSpec = new TypeSpec(TypeSpec.new_num());
        typeSpec.type_spec = (TypeSpec)this.type_spec.clone();
        return typeSpec;
    }

    public String typeName() {
        return this.type_spec.typeName();
    }

    public String getJavaTypeName() {
        return this.typeName();
    }

    public String getIDLTypeName() {
        return this.typeName();
    }

    public TypeSpec typeSpec() {
        return this.type_spec.typeSpec();
    }

    public int getTCKind() {
        return this.type_spec.getTCKind();
    }

    public void accept(IDLTreeVisitor iDLTreeVisitor) {
        this.type_spec.accept(iDLTreeVisitor);
    }

    public void setPackage(String string) {
        string = parser.pack_replace(string);
        this.type_spec.setPackage(string);
    }

    public void setEnclosingSymbol(IdlSymbol idlSymbol) {
        if (this.enclosing_symbol != null && this.enclosing_symbol != idlSymbol) {
            throw new RuntimeException("Compiler Error: trying to reassign container for " + this.name);
        }
        this.enclosing_symbol = idlSymbol;
        this.type_spec.setEnclosingSymbol(idlSymbol);
    }

    public boolean basic() {
        if (this.type_spec == null) {
            this.logger.warn("Typespec null " + this.getClass().getName());
        }
        return this.type_spec.basic();
    }

    public void set_constr(TypeDeclaration typeDeclaration) {
        ConstrTypeSpec constrTypeSpec = new ConstrTypeSpec(TypeSpec.new_num());
        constrTypeSpec.c_type_spec = typeDeclaration;
        this.type_spec = constrTypeSpec;
    }

    public void parse() {
        this.type_spec.parse();
    }

    public String toString() {
        try {
            return this.type_spec.toString();
        }
        catch (NullPointerException nullPointerException) {
            parser.fatal_error("Compiler Error for " + this.type_spec + " " + this.typeName() + " " + nullPointerException.getMessage(), null);
            return null;
        }
    }

    public String getTypeCodeExpression(Set set) {
        if (this.type_spec instanceof ConstrTypeSpec) {
            return this.type_spec.getTypeCodeExpression(set);
        }
        return this.getTypeCodeExpression();
    }

    public String getTypeCodeExpression() {
        return this.type_spec.getTypeCodeExpression();
    }

    public void print(PrintWriter printWriter) {
        if (!this.included) {
            this.type_spec.print(printWriter);
        }
    }

    public String holderName() {
        return this.type_spec.holderName();
    }

    public String helperName() throws NoHelperException {
        throw new NoHelperException();
    }

    public String printReadExpression(String string) {
        return this.type_spec.printReadExpression(string);
    }

    public String printReadStatement(String string, String string2) {
        return string + "=" + this.printReadExpression(string2) + ";";
    }

    public String printWriteStatement(String string, String string2) {
        return this.type_spec.printWriteStatement(string, string2);
    }

    public String printInsertExpression() {
        return this.type_spec.printInsertExpression();
    }

    public String printExtractExpression() {
        return this.type_spec.printExtractExpression();
    }

    static void printHelperClassMethods(PrintWriter printWriter, String string) {
        TypeSpec.printInsertExtractMethods(printWriter, string);
        printWriter.println("\tpublic static org.omg.CORBA.TypeCode type()");
        printWriter.println("\t{");
        printWriter.println("\t\treturn _type;");
        printWriter.println("\t}");
    }

    static void printInsertExtractMethods(PrintWriter printWriter, String string) {
        printWriter.println("\tpublic static void insert (final org.omg.CORBA.Any any, final " + string + " s)");
        printWriter.println("\t{");
        printWriter.println("\t\tany.type(type());");
        printWriter.println("\t\twrite( any.create_output_stream(),s);");
        printWriter.println("\t}\n");
        printWriter.println("\tpublic static " + string + " extract (final org.omg.CORBA.Any any)");
        printWriter.println("\t{");
        printWriter.println("\t\treturn read(any.create_input_stream());");
        printWriter.println("\t}\n");
    }

    public void printInsertIntoAny(PrintWriter printWriter, String string, String string2) {
        this.type_spec.printInsertIntoAny(printWriter, string, string2);
    }

    public void printExtractResult(PrintWriter printWriter, String string, String string2, String string3) {
        this.type_spec.printExtractResult(printWriter, string, string2, string3);
    }
}

