/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import org.jacorb.idl.BaseType;
import org.jacorb.idl.TypeSpec;

public class AnyType
extends BaseType {
    public AnyType(int n) {
        super(n);
    }

    public Object clone() {
        return new AnyType(AnyType.new_num());
    }

    public String typeName() {
        return "org.omg.CORBA.Any";
    }

    public String getIDLTypeName() {
        return "any";
    }

    public TypeSpec typeSpec() {
        return this;
    }

    public boolean basic() {
        return false;
    }

    public String toString() {
        return this.typeName();
    }

    public String holderName() {
        return "org.omg.CORBA.AnyHolder";
    }

    public void parse() {
    }

    public int getTCKind() {
        return 11;
    }

    public String printReadExpression(String string) {
        return string + ".read_any()";
    }

    public String printWriteStatement(String string, String string2) {
        return string2 + ".write_any(" + string + ");";
    }

    public void printInsertIntoAny(PrintWriter printWriter, String string, String string2) {
        printWriter.println("\t\t" + string + ".insert_any(" + string2 + ");");
    }

    public void printExtractResult(PrintWriter printWriter, String string, String string2, String string3) {
        printWriter.println("\t\t" + string + " = (" + string3 + ")" + string2 + ".extract_any();");
    }
}

