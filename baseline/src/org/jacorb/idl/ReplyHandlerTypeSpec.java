/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.io.PrintWriter;
import org.jacorb.idl.TypeDeclaration;
import org.jacorb.idl.TypeSpec;
import org.jacorb.idl.parser;

public class ReplyHandlerTypeSpec
extends TypeSpec {
    public ReplyHandlerTypeSpec(int n) {
        super(n);
    }

    public Object clone() {
        return this;
    }

    public String typeName() {
        return "org.omg.Messaging.ReplyHandler";
    }

    public TypeSpec typeSpec() {
        return this;
    }

    public void setPackage(String string) {
        string = parser.pack_replace(string);
    }

    public boolean basic() {
        return true;
    }

    public void set_constr(TypeDeclaration typeDeclaration) {
    }

    public void parse() {
    }

    public String toString() {
        return "org.omg.Messaging.ReplyHandler";
    }

    public String getTypeCodeExpression() {
        return "org.omg.CORBA.ORB.init().create_interface_tc(\"IDL:omg.org/Messaging/ReplyHandler:1.0\",\"ReplyHandler\")";
    }

    public void print(PrintWriter printWriter) {
    }

    public String holderName() {
        return this.typeName() + "Holder";
    }

    public String printReadExpression(String string) {
        return string + ".read_Object()";
    }

    public String printWriteStatement(String string, String string2) {
        return string2 + ".write_Object(" + string + ");";
    }

    public void printInsertIntoAny(PrintWriter printWriter, String string, String string2) {
        throw new RuntimeException("Should not be called");
    }

    public void printExtractResult(PrintWriter printWriter, String string, String string2, String string3) {
        throw new RuntimeException("Should not be called");
    }
}

