/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import org.jacorb.idl.IDLTreeVisitor;
import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.ParseException;
import org.jacorb.idl.ScopedName;
import org.jacorb.idl.SimpleDeclarator;
import org.jacorb.idl.TypeSpec;
import org.jacorb.idl.lexer;
import org.jacorb.idl.parser;

public class ParamDecl
extends IdlSymbol {
    public static final int MODE_IN = 1;
    public static final int MODE_OUT = 2;
    public static final int MODE_INOUT = 3;
    public int paramAttribute;
    public TypeSpec paramTypeSpec;
    public SimpleDeclarator simple_declarator;

    public ParamDecl(int n) {
        super(n);
    }

    public ParamDecl(int n, TypeSpec typeSpec, SimpleDeclarator simpleDeclarator) {
        super(ParamDecl.new_num());
        this.paramAttribute = n;
        this.paramTypeSpec = typeSpec;
        this.simple_declarator = simpleDeclarator;
    }

    public ParamDecl(int n, TypeSpec typeSpec, String string) {
        super(ParamDecl.new_num());
        this.paramAttribute = n;
        this.paramTypeSpec = typeSpec;
        this.simple_declarator = new SimpleDeclarator(ParamDecl.new_num());
        this.simple_declarator.name = string;
    }

    public void setPackage(String string) {
        string = parser.pack_replace(string);
        this.pack_name = this.pack_name.length() > 0 ? string + "." + this.pack_name : string;
        this.paramTypeSpec.setPackage(string);
    }

    public ParamDecl asIn() {
        return new ParamDecl(1, this.paramTypeSpec, this.simple_declarator);
    }

    public void parse() {
        while (this.paramTypeSpec.typeSpec() instanceof ScopedName) {
            TypeSpec typeSpec = ((ScopedName)this.paramTypeSpec.typeSpec()).resolvedTypeSpec();
            if (typeSpec == null) continue;
            this.paramTypeSpec = typeSpec;
        }
        if (this.paramTypeSpec == null) {
            lexer.restorePosition(this.myPosition);
            parser.fatal_error("parameter TypeSpec is null " + this.name, this.token);
        }
    }

    public void print(PrintWriter printWriter) {
        switch (this.paramAttribute) {
            case 1: {
                printWriter.print(this.paramTypeSpec.toString());
                break;
            }
            case 2: 
            case 3: {
                printWriter.print(this.paramTypeSpec.holderName());
            }
        }
        printWriter.print(" ");
        printWriter.print(this.simple_declarator);
    }

    public String printWriteStatement(String string) {
        return this.printWriteStatement(this.simple_declarator.toString(), string);
    }

    public String printWriteStatement(String string, String string2) {
        if (this.paramAttribute != 1) {
            return this.paramTypeSpec.typeSpec().printWriteStatement(string + ".value", string2);
        }
        return this.paramTypeSpec.typeSpec().printWriteStatement(string, string2);
    }

    public String printReadExpression(String string) {
        return this.paramTypeSpec.typeSpec().printReadExpression(string);
    }

    public void printAddArgumentStatement(PrintWriter printWriter, String string) {
        String string2 = this.simple_declarator.toString();
        String string3 = "$" + string2;
        printWriter.print("\t\torg.omg.CORBA.Any " + string3 + " = " + string);
        switch (this.paramAttribute) {
            case 2: {
                printWriter.println(".add_out_arg();");
                string2 = string2 + ".value";
                break;
            }
            case 1: {
                printWriter.println(".add_in_arg();");
                break;
            }
            case 3: {
                printWriter.println(".add_inout_arg();");
                string2 = string2 + ".value";
                break;
            }
            default: {
                throw new ParseException("Wrong parameter declaration");
            }
        }
        this.paramTypeSpec.typeSpec().printInsertIntoAny(printWriter, string3, string2);
    }

    public void printExtractArgumentStatement(PrintWriter printWriter) {
        String string = this.simple_declarator.toString();
        String string2 = "$" + string;
        this.paramTypeSpec.typeSpec().printExtractResult(printWriter, string + ".value", string2, this.paramTypeSpec.toString());
    }

    public void accept(IDLTreeVisitor iDLTreeVisitor) {
        iDLTreeVisitor.visitParamDecl(this);
    }
}

