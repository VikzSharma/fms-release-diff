/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Vector;
import org.jacorb.idl.Declaration;
import org.jacorb.idl.IdlSymbol;
import org.jacorb.idl.NameAlreadyDefined;
import org.jacorb.idl.NameTable;
import org.jacorb.idl.ParamDecl;
import org.jacorb.idl.RaisesExpr;
import org.jacorb.idl.parser;

public class InitDecl
extends Declaration {
    public Vector paramDecls = new Vector();
    public IdlSymbol myValue;
    public RaisesExpr raisesExpr;

    public InitDecl(int n) {
        super(n);
    }

    public void setPackage(String string) {
        string = parser.pack_replace(string);
        this.pack_name = this.pack_name.length() > 0 ? string + "." + this.pack_name : string;
        Enumeration enumeration = this.paramDecls.elements();
        while (enumeration.hasMoreElements()) {
            ((ParamDecl)enumeration.nextElement()).setPackage(string);
        }
        this.raisesExpr.setPackage(string);
    }

    public void setEnclosingSymbol(IdlSymbol idlSymbol) {
        if (this.enclosing_symbol != null && this.enclosing_symbol != idlSymbol) {
            throw new RuntimeException("Compiler Error: trying to reassign container for " + this.name);
        }
        this.enclosing_symbol = idlSymbol;
        this.raisesExpr.setEnclosingSymbol(idlSymbol);
    }

    public void parse() {
        this.myValue = this.enclosing_symbol;
        try {
            NameTable.define(this.full_name(), "factory");
        }
        catch (NameAlreadyDefined nameAlreadyDefined) {
            parser.error("Factory " + this.full_name() + " already defined", this.token);
        }
        Enumeration enumeration = this.paramDecls.elements();
        while (enumeration.hasMoreElements()) {
            ParamDecl paramDecl = (ParamDecl)enumeration.nextElement();
            paramDecl.parse();
            try {
                NameTable.define(this.full_name() + "." + paramDecl.simple_declarator.name(), "argument");
            }
            catch (NameAlreadyDefined nameAlreadyDefined) {
                parser.error("Argument " + paramDecl.simple_declarator.name() + " already defined in operation " + this.full_name(), this.token);
            }
        }
        this.raisesExpr.parse();
    }

    public void print(PrintWriter printWriter, String string) {
        printWriter.print("\t" + string + " " + this.name + "( ");
        Enumeration enumeration = this.paramDecls.elements();
        if (enumeration.hasMoreElements()) {
            ((ParamDecl)enumeration.nextElement()).print(printWriter);
        }
        while (enumeration.hasMoreElements()) {
            printWriter.print(", ");
            ((ParamDecl)enumeration.nextElement()).print(printWriter);
        }
        printWriter.print(")");
        this.raisesExpr.print(printWriter);
        printWriter.println(";");
    }

    public void printHelperMethod(PrintWriter printWriter, String string) {
        printWriter.print("\tpublic static " + string + " " + this.name + "( ");
        printWriter.print("org.omg.CORBA.ORB orb");
        Enumeration enumeration = this.paramDecls.elements();
        while (enumeration.hasMoreElements()) {
            printWriter.print(", ");
            ((ParamDecl)enumeration.nextElement()).print(printWriter);
        }
        printWriter.println(" )");
        printWriter.println("\t{");
        printWriter.println("\t\t" + string + "ValueFactory f = " + "( " + string + "ValueFactory )" + "((org.omg.CORBA_2_3.ORB)orb).lookup_value_factory(id());");
        printWriter.println("\t\tif (f == null)");
        printWriter.println("\t\t\tthrow new org.omg.CORBA.MARSHAL( 1, org.omg.CORBA.CompletionStatus.COMPLETED_NO );");
        printWriter.print("\t\treturn f." + this.name + "( ");
        enumeration = this.paramDecls.elements();
        while (enumeration.hasMoreElements()) {
            printWriter.print(((ParamDecl)enumeration.nextElement()).simple_declarator);
            if (!enumeration.hasMoreElements()) continue;
            printWriter.print(", ");
        }
        printWriter.println(" );");
        printWriter.println("\t}");
    }

    public String name() {
        return this.name;
    }

    public String opName() {
        return this.name();
    }
}

