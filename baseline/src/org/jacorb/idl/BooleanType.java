/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import org.jacorb.idl.BaseType;
import org.jacorb.idl.SwitchTypeSpec;
import org.jacorb.idl.TypeSpec;

public class BooleanType
extends BaseType
implements SwitchTypeSpec {
    public BooleanType(int n) {
        super(n);
    }

    public String typeName() {
        return "boolean";
    }

    public TypeSpec typeSpec() {
        return this;
    }

    public boolean basic() {
        return true;
    }

    public int getTCKind() {
        return 8;
    }

    public String toString() {
        return this.typeName();
    }

    public void parse() {
    }

    public String holderName() {
        return "org.omg.CORBA.BooleanHolder";
    }

    public String printReadExpression(String string) {
        return string + ".read_boolean()";
    }

    public String printWriteStatement(String string, String string2) {
        return string2 + ".write_boolean(" + string + ");";
    }

    public String printInsertExpression() {
        return "insert_boolean";
    }

    public String printExtractExpression() {
        return "extract_boolean";
    }

    public boolean isSwitchable() {
        return true;
    }

    public void printInsertIntoAny(PrintWriter printWriter, String string, String string2) {
        printWriter.println("\t\t" + string + "." + this.printInsertExpression() + "(" + string2 + ");");
    }

    public void printExtractResult(PrintWriter printWriter, String string, String string2, String string3) {
        printWriter.println("\t\t" + string + " = " + string2 + "." + this.printExtractExpression() + "();");
    }
}

