/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import org.jacorb.idl.BaseType;
import org.jacorb.idl.SwitchTypeSpec;
import org.jacorb.idl.TypeSpec;

public class CharType
extends BaseType
implements SwitchTypeSpec {
    private boolean wide = false;

    public CharType(int n) {
        super(n);
    }

    public Object clone() {
        CharType charType = new CharType(CharType.new_num());
        if (this.wide) {
            charType.setWide();
        }
        return charType;
    }

    public boolean isWide() {
        return this.wide;
    }

    public void setWide() {
        this.wide = true;
    }

    public String typeName() {
        return "char";
    }

    public String getIDLTypeName() {
        return this.wide ? "wchar" : "char";
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
        if (this.wide) {
            return 26;
        }
        return 9;
    }

    public String holderName() {
        return "org.omg.CORBA.CharHolder";
    }

    public String printReadExpression(String string) {
        if (this.wide) {
            return string + ".read_wchar()";
        }
        return string + ".read_char()";
    }

    public String printWriteStatement(String string, String string2) {
        if (this.wide) {
            return string2 + ".write_wchar(" + string + ");";
        }
        return string2 + ".write_char(" + string + ");";
    }

    public String printInsertExpression() {
        if (this.wide) {
            return "insert_wchar";
        }
        return "insert_char";
    }

    public String printExtractExpression() {
        if (this.wide) {
            return "extract_wchar";
        }
        return "extract_char";
    }

    public boolean isSwitchable() {
        return !this.wide;
    }

    public void printInsertIntoAny(PrintWriter printWriter, String string, String string2) {
        printWriter.println("\t\t" + string + "." + this.printInsertExpression() + "(" + string2 + ");");
    }

    public void printExtractResult(PrintWriter printWriter, String string, String string2, String string3) {
        printWriter.println("\t\t" + string + " = " + string2 + "." + this.printExtractExpression() + "();");
    }
}

