/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import org.jacorb.idl.IntType;
import org.jacorb.idl.TypeSpec;

public class LongType
extends IntType {
    public LongType(int n) {
        super(n);
    }

    public Object clone() {
        return new LongType(LongType.new_num());
    }

    public TypeSpec typeSpec() {
        return this;
    }

    public String typeName() {
        return "int";
    }

    public String getJavaTypeName() {
        return "int";
    }

    public String getIDLTypeName() {
        if (this.unsigned) {
            return "unsigned long";
        }
        return "long";
    }

    public boolean basic() {
        return true;
    }

    public int getTCKind() {
        return this.unsigned ? 5 : 3;
    }

    public String toString() {
        return this.typeName();
    }

    public String holderName() {
        return "org.omg.CORBA.IntHolder";
    }

    public String printReadExpression(String string) {
        if (this.unsigned) {
            return string + ".read_ulong()";
        }
        return string + ".read_long()";
    }

    public String printWriteStatement(String string, String string2) {
        if (this.unsigned) {
            return string2 + ".write_ulong(" + string + ");";
        }
        return string2 + ".write_long(" + string + ");";
    }

    public String printInsertExpression() {
        if (this.unsigned) {
            return "insert_ulong";
        }
        return "insert_long";
    }

    public String printExtractExpression() {
        if (this.unsigned) {
            return "extract_ulong";
        }
        return "extract_long";
    }

    public void printInsertIntoAny(PrintWriter printWriter, String string, String string2) {
        printWriter.println("\t\t" + string + "." + this.printInsertExpression() + "(" + string2 + ");");
    }

    public void printExtractResult(PrintWriter printWriter, String string, String string2, String string3) {
        printWriter.println("\t\t" + string + " = " + string2 + "." + this.printExtractExpression() + "();");
    }
}

