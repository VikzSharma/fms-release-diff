/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import org.jacorb.idl.IntType;
import org.jacorb.idl.TypeSpec;

public class LongLongType
extends IntType {
    public LongLongType(int n) {
        super(n);
    }

    public Object clone() {
        return new LongLongType(LongLongType.new_num());
    }

    public TypeSpec typeSpec() {
        return this;
    }

    public String typeName() {
        return "long";
    }

    public String getJavaTypeName() {
        return this.typeName();
    }

    public String getIDLTypeName() {
        if (this.unsigned) {
            return "unsigned long long";
        }
        return "long long";
    }

    public boolean basic() {
        return true;
    }

    public int getTCKind() {
        if (this.unsigned) {
            return 24;
        }
        return 23;
    }

    public String toString() {
        return this.typeName();
    }

    public String holderName() {
        return "org.omg.CORBA.LongHolder";
    }

    public String printReadExpression(String string) {
        if (this.unsigned) {
            return string + ".read_ulonglong()";
        }
        return string + ".read_longlong()";
    }

    public String printReadStatement(String string, String string2) {
        if (this.unsigned) {
            return string + "=" + string2 + ".read_ulonglong();";
        }
        return string + "=" + string2 + ".read_longlong();";
    }

    public String printWriteStatement(String string, String string2) {
        if (this.unsigned) {
            return string2 + ".write_ulonglong(" + string + ");";
        }
        return string2 + ".write_longlong(" + string + ");";
    }

    public String printInsertExpression() {
        if (this.unsigned) {
            return "insert_ulonglong";
        }
        return "insert_longlong";
    }

    public String printExtractExpression() {
        if (this.unsigned) {
            return "extract_ulonglong";
        }
        return "extract_longlong";
    }

    public void printInsertIntoAny(PrintWriter printWriter, String string, String string2) {
        printWriter.println("\t\t" + string + "." + this.printInsertExpression() + "(" + string2 + ");");
    }

    public void printExtractResult(PrintWriter printWriter, String string, String string2, String string3) {
        printWriter.println("\t\t" + string + " = " + string2 + "." + this.printExtractExpression() + "();");
    }
}

