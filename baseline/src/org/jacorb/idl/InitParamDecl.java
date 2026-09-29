/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import org.jacorb.idl.ParamDecl;
import org.jacorb.idl.ScopedName;
import org.jacorb.idl.TypeSpec;
import org.jacorb.idl.parser;

public class InitParamDecl
extends ParamDecl {
    public InitParamDecl(int n) {
        super(n);
    }

    public void setPackage(String string) {
        string = parser.pack_replace(string);
        this.pack_name = this.pack_name.length() > 0 ? string + "." + this.pack_name : string;
        this.paramTypeSpec.setPackage(string);
    }

    public void parse() {
        while (this.paramTypeSpec.typeSpec() instanceof ScopedName) {
            TypeSpec typeSpec = ((ScopedName)this.paramTypeSpec.typeSpec()).resolvedTypeSpec();
            if (typeSpec == null) continue;
            this.paramTypeSpec = typeSpec;
        }
    }

    public void print(PrintWriter printWriter) {
        printWriter.print(this.paramTypeSpec.toString() + " " + this.simple_declarator);
    }

    public String printWriteStatement(String string) {
        return this.printWriteStatement(this.simple_declarator.toString(), string);
    }

    public String printWriteStatement(String string, String string2) {
        return this.paramTypeSpec.typeSpec().printWriteStatement(string, string2);
    }

    public String printReadExpression(String string) {
        return this.paramTypeSpec.typeSpec().printReadExpression(string);
    }
}

