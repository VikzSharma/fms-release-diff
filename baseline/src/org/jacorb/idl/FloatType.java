/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import org.jacorb.idl.FloatPtType;
import org.jacorb.idl.TypeSpec;

public class FloatType
extends FloatPtType {
    public FloatType(int n) {
        super(n);
    }

    public String typeName() {
        return "float";
    }

    public String getJavaTypeName() {
        return "float";
    }

    public String getIDLTypeName() {
        return "float";
    }

    public TypeSpec typeSpec() {
        return this;
    }

    public boolean basic() {
        return true;
    }

    public int getTCKind() {
        return 6;
    }

    public String toString() {
        return this.typeName();
    }

    public String holderName() {
        return "org.omg.CORBA.FloatHolder";
    }

    public String printReadExpression(String string) {
        return string + ".read_float()";
    }

    public String printWriteStatement(String string, String string2) {
        return string2 + ".write_float(" + string + ");";
    }

    public String printInsertExpression() {
        return "insert_float";
    }

    public String printExtractExpression() {
        return "extract_float";
    }

    public void printInsertIntoAny(PrintWriter printWriter, String string, String string2) {
        printWriter.println("\t" + string + "." + this.printInsertExpression() + "(" + string2 + ");");
    }

    public void printExtractResult(PrintWriter printWriter, String string, String string2, String string3) {
        printWriter.println("\t\t" + string + " = " + string2 + "." + this.printExtractExpression() + "();");
    }
}

