/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import org.jacorb.idl.IntType;
import org.jacorb.idl.TypeSpec;

public class ShortType
extends IntType {
    public ShortType(int n) {
        super(n);
    }

    public String typeName() {
        return "short";
    }

    public String getJavaTypeName() {
        return "short";
    }

    public String getIDLTypeName() {
        if (this.unsigned) {
            return "unsigned short";
        }
        return "short";
    }

    public TypeSpec typeSpec() {
        return this;
    }

    public boolean basic() {
        return true;
    }

    public int getTCKind() {
        if (this.unsigned) {
            return 4;
        }
        return 2;
    }

    public String toString() {
        return this.typeName();
    }

    public String holderName() {
        return "org.omg.CORBA.ShortHolder";
    }

    public String printReadExpression(String string) {
        if (this.unsigned) {
            return string + ".read_ushort()";
        }
        return string + ".read_short()";
    }

    public String printReadStatement(String string, String string2) {
        if (this.unsigned) {
            return string + "=" + string2 + ".read_ushort();";
        }
        return string + "=" + string2 + ".read_short();";
    }

    public String printWriteStatement(String string, String string2) {
        if (this.unsigned) {
            return string2 + ".write_ushort(" + string + ");";
        }
        return string2 + ".write_short(" + string + ");";
    }

    public String printInsertExpression() {
        if (this.unsigned) {
            return "insert_ushort";
        }
        return "insert_short";
    }

    public String printExtractExpression() {
        if (this.unsigned) {
            return "extract_ushort";
        }
        return "extract_short";
    }

    public void printInsertIntoAny(PrintWriter printWriter, String string, String string2) {
        printWriter.println("\t\t" + string + "." + this.printInsertExpression() + "(" + string2 + ");");
    }

    public void printExtractResult(PrintWriter printWriter, String string, String string2, String string3) {
        printWriter.println("\t\t" + string + " = " + string2 + "." + this.printExtractExpression() + "();");
    }
}

