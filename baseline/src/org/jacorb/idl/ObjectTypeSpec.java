/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import org.jacorb.idl.TypeDeclaration;
import org.jacorb.idl.TypeSpec;
import org.jacorb.idl.parser;

public class ObjectTypeSpec
extends TypeSpec {
    public ObjectTypeSpec(int n) {
        super(n);
    }

    public Object clone() {
        return this;
    }

    public String typeName() {
        return "org.omg.CORBA.Object";
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
        return "org.omg.CORBA.Object";
    }

    public String getTypeCodeExpression() {
        return "org.omg.CORBA.ORB.init().get_primitive_tc( org.omg.CORBA.TCKind.tk_objref)";
    }

    public String id() {
        return "IDL:omg.org/CORBA/Object:1.0";
    }

    public void print(PrintWriter printWriter) {
    }

    public String holderName() {
        return this.typeName() + "Holder";
    }

    public String printReadExpression(String string) {
        return string + ".read_Object()";
    }

    public String printWriteStatement(String string, String string2) {
        return string2 + ".write_Object(" + string + ");";
    }

    public void printInsertIntoAny(PrintWriter printWriter, String string, String string2) {
        printWriter.println("\t" + string + ".insert_Object(" + string2 + ");");
    }

    public void printExtractResult(PrintWriter printWriter, String string, String string2, String string3) {
        printWriter.println("\t\t" + string + " = " + string2 + ".extract_Object();");
    }

    public String printInsertExpression() {
        return "insert_Object";
    }

    public String printExtractExpression() {
        return "extract_Object";
    }
}

