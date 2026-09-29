/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import org.jacorb.idl.TypeDeclaration;
import org.jacorb.idl.TypeSpec;
import org.jacorb.idl.parser;

public class TypeCodeTypeSpec
extends TypeSpec {
    public TypeCodeTypeSpec(int n) {
        super(n);
    }

    public Object clone() {
        return this;
    }

    public String typeName() {
        return "org.omg.CORBA.TypeCode";
    }

    public TypeSpec typeSpec() {
        return this;
    }

    public void setPackage(String string) {
        string = parser.pack_replace(string);
    }

    public boolean basic() {
        return true;
    }

    public void set_constr(TypeDeclaration typeDeclaration) {
    }

    public void parse() {
    }

    public String toString() {
        return this.typeName();
    }

    public String getTypeCodeExpression() {
        return "org.omg.CORBA.ORB.init().get_primitive_tc( org.omg.CORBA.TCKind.tk_TypeCode)";
    }

    public void print(PrintWriter printWriter) {
    }

    public String holderName() {
        return this.typeName() + "Holder";
    }

    public String printReadExpression(String string) {
        return string + ".read_TypeCode()";
    }

    public String printWriteStatement(String string, String string2) {
        return string2 + ".write_TypeCode(" + string + ");";
    }

    public void printInsertIntoAny(PrintWriter printWriter, String string, String string2) {
        printWriter.println("\t\t" + string + ".insert_TypeCode(" + string2 + ");");
    }

    public void printExtractResult(PrintWriter printWriter, String string, String string2, String string3) {
        printWriter.println("\t\t" + string + " = (" + string3 + ")" + string2 + ".extract_TypeCode();");
    }
}

