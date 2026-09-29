/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import org.jacorb.idl.FloatPtType;
import org.jacorb.idl.TypeSpec;

public class DoubleType
extends FloatPtType {
    public DoubleType(int n) {
        super(n);
    }

    public String typeName() {
        return "double";
    }

    public void setLongDouble() {
    }

    public TypeSpec typeSpec() {
        return this;
    }

    public boolean basic() {
        return true;
    }

    public int getTCKind() {
        return 7;
    }

    public String toString() {
        return this.typeName();
    }

    public String holderName() {
        return "org.omg.CORBA.DoubleHolder";
    }

    public String printReadExpression(String string) {
        return string + ".read_double()";
    }

    public String printWriteStatement(String string, String string2) {
        return string2 + ".write_double(" + string + ");";
    }

    public String printInsertExpression() {
        return "insert_double";
    }

    public String printExtractExpression() {
        return "extract_double";
    }

    public void printInsertIntoAny(PrintWriter printWriter, String string, String string2) {
        printWriter.println("\t\t" + string + "." + this.printInsertExpression() + "(" + string2 + ");");
    }

    public void printExtractResult(PrintWriter printWriter, String string, String string2, String string3) {
        printWriter.println("\t\t" + string + " = " + string2 + "." + this.printExtractExpression() + "();");
    }
}

