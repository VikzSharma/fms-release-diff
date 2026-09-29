/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import org.jacorb.idl.BaseType;
import org.jacorb.idl.TypeSpec;

public class OctetType
extends BaseType {
    public OctetType(int n) {
        super(n);
    }

    public Object clone() {
        return new OctetType(OctetType.new_num());
    }

    public String typeName() {
        return "byte";
    }

    public String getJavaTypeName() {
        return "byte";
    }

    public String getIDLTypeName() {
        return "octet";
    }

    public TypeSpec typeSpec() {
        return this;
    }

    public String toString() {
        return this.typeName();
    }

    public boolean basic() {
        return true;
    }

    public int getTCKind() {
        return 10;
    }

    public void parse() {
    }

    public String holderName() {
        return "org.omg.CORBA.ByteHolder";
    }

    public String printReadExpression(String string) {
        return string + ".read_octet()";
    }

    public String printWriteStatement(String string, String string2) {
        return string2 + ".write_octet(" + string + ");";
    }

    public String printInsertExpression() {
        return "insert_octet";
    }

    public String printExtractExpression() {
        return "extract_octet";
    }

    public void printInsertIntoAny(PrintWriter printWriter, String string, String string2) {
        printWriter.println("\t" + string + "." + this.printInsertExpression() + "(" + string2 + ");");
    }

    public void printExtractResult(PrintWriter printWriter, String string, String string2, String string3) {
        printWriter.println("\t\t" + string + " = " + string2 + "." + this.printExtractExpression() + "();");
    }
}

